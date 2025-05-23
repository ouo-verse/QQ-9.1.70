package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    private static final int BOX_HEADER_SIZE = 8;
    private static final int TYPE_payl = Util.getIntegerCodeForString("payl");
    private static final int TYPE_sttg = Util.getIntegerCodeForString("sttg");
    private static final int TYPE_vttc = Util.getIntegerCodeForString("vttc");
    private final WebvttCue.Builder builder;
    private final ParsableByteArray sampleData;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.sampleData = new ParsableByteArray();
        this.builder = new WebvttCue.Builder();
    }

    private static Cue parseVttCueBox(ParsableByteArray parsableByteArray, WebvttCue.Builder builder, int i3) throws SubtitleDecoderException {
        builder.reset();
        while (i3 > 0) {
            if (i3 >= 8) {
                int readInt = parsableByteArray.readInt();
                int readInt2 = parsableByteArray.readInt();
                int i16 = readInt - 8;
                String str = new String(parsableByteArray.data, parsableByteArray.getPosition(), i16);
                parsableByteArray.skipBytes(i16);
                i3 = (i3 - 8) - i16;
                if (readInt2 == TYPE_sttg) {
                    WebvttCueParser.parseCueSettingsList(str, builder);
                } else if (readInt2 == TYPE_payl) {
                    WebvttCueParser.parseCueText(null, str.trim(), builder, Collections.emptyList());
                }
            } else {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Mp4WebvttSubtitle decode(byte[] bArr, int i3, boolean z16) throws SubtitleDecoderException {
        this.sampleData.reset(bArr, i3);
        ArrayList arrayList = new ArrayList();
        while (this.sampleData.bytesLeft() > 0) {
            if (this.sampleData.bytesLeft() >= 8) {
                int readInt = this.sampleData.readInt();
                if (this.sampleData.readInt() == TYPE_vttc) {
                    arrayList.add(parseVttCueBox(this.sampleData, this.builder, readInt - 8));
                } else {
                    this.sampleData.skipBytes(readInt - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new Mp4WebvttSubtitle(arrayList);
    }
}
