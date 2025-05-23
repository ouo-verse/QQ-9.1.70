package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DvbDecoder extends SimpleSubtitleDecoder {
    private final DvbParser parser;

    public DvbDecoder(List<byte[]> list) {
        super("DvbDecoder");
        ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        this.parser = new DvbParser(parsableByteArray.readUnsignedShort(), parsableByteArray.readUnsignedShort());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public DvbSubtitle decode(byte[] bArr, int i3, boolean z16) {
        if (z16) {
            this.parser.reset();
        }
        return new DvbSubtitle(this.parser.decode(bArr, i3));
    }
}
