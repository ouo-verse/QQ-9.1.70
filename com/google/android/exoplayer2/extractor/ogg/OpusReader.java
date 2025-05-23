package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
final class OpusReader extends StreamReader {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int OPUS_CODE = Util.getIntegerCodeForString("Opus");
    private static final byte[] OPUS_SIGNATURE = {79, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 72, 101, 97, 100};
    private static final int SAMPLE_RATE = 48000;
    private boolean headerRead;

    private long getPacketDurationUs(byte[] bArr) {
        int i3;
        int i16;
        int i17 = bArr[0] & 255;
        int i18 = i17 & 3;
        if (i18 != 0) {
            i3 = 2;
            if (i18 != 1 && i18 != 2) {
                i3 = bArr[1] & 63;
            }
        } else {
            i3 = 1;
        }
        int i19 = i17 >> 3;
        int i26 = i19 & 3;
        if (i19 >= 16) {
            i16 = 2500 << i26;
        } else if (i19 >= 12) {
            i16 = 10000 << (i26 & 1);
        } else if (i26 == 3) {
            i16 = 60000;
        } else {
            i16 = 10000 << i26;
        }
        return i3 * i16;
    }

    private void putNativeOrderLong(List<byte[]> list, int i3) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i3 * 1000000000) / 48000).array());
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        int bytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (bytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.data));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(ParsableByteArray parsableByteArray, long j3, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        boolean z16 = true;
        if (!this.headerRead) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit());
            int i3 = copyOf[9] & 255;
            int i16 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            putNativeOrderLong(arrayList, i16);
            putNativeOrderLong(arrayList, 3840);
            setupData.format = Format.createAudioSampleFormat(null, "audio/opus", null, -1, -1, i3, 48000, arrayList, null, 0, null);
            this.headerRead = true;
            return true;
        }
        if (parsableByteArray.readInt() != OPUS_CODE) {
            z16 = false;
        }
        parsableByteArray.setPosition(0);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z16) {
        super.reset(z16);
        if (z16) {
            this.headerRead = false;
        }
    }
}
