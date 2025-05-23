package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdDownloadType implements WireEnum {
    AD_DOWNLOAD_TYPE_UNKNOWN(0),
    AD_DOWNLOAD_TYPE_YYB(1),
    AD_DOWNLOAD_TYPE_GP(2),
    AD_DOWNLOAD_TYPE_SPA(3),
    AD_DOWNLOAD_TYPE_H5(4);

    public static final ProtoAdapter<AdDownloadType> ADAPTER = new EnumAdapter<AdDownloadType>() { // from class: com.tencent.tvideo.protocol.pb.AdDownloadType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdDownloadType adDownloadType = AdDownloadType.AD_DOWNLOAD_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdDownloadType fromValue(int i3) {
            return AdDownloadType.fromValue(i3);
        }
    };
    private final int value;

    AdDownloadType(int i3) {
        this.value = i3;
    }

    public static AdDownloadType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return AD_DOWNLOAD_TYPE_H5;
                    }
                    return AD_DOWNLOAD_TYPE_SPA;
                }
                return AD_DOWNLOAD_TYPE_GP;
            }
            return AD_DOWNLOAD_TYPE_YYB;
        }
        return AD_DOWNLOAD_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
