package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT = new MetadataDecoderFactory() { // from class: com.google.android.exoplayer2.metadata.MetadataDecoderFactory.1
        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        public MetadataDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1248341703:
                    if (str.equals("application/id3")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 1154383568:
                    if (str.equals("application/x-emsg")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1652648887:
                    if (str.equals("application/x-scte35")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    return new Id3Decoder();
                case 1:
                    return new EventMessageDecoder();
                case 2:
                    return new SpliceInfoDecoder();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        public boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            if (!"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str)) {
                return false;
            }
            return true;
        }
    };

    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
