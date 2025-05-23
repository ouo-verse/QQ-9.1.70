package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdImmersiveType implements WireEnum {
    AD_IMMERSIVE_TYPE_UNKNOWN(0),
    AD_IMMERSIVE_TYPE_NORMAL(1),
    AD_IMMERSIVE_TYPE_Form(2),
    AD_IMMERSIVE_TYPE_HORIZONTAL(3),
    AD_IMMERSIVE_TYPE_VERTICAL(4);

    public static final ProtoAdapter<AdImmersiveType> ADAPTER = new EnumAdapter<AdImmersiveType>() { // from class: com.tencent.tvideo.protocol.pb.AdImmersiveType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdImmersiveType adImmersiveType = AdImmersiveType.AD_IMMERSIVE_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdImmersiveType fromValue(int i3) {
            return AdImmersiveType.fromValue(i3);
        }
    };
    private final int value;

    AdImmersiveType(int i3) {
        this.value = i3;
    }

    public static AdImmersiveType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return AD_IMMERSIVE_TYPE_VERTICAL;
                    }
                    return AD_IMMERSIVE_TYPE_HORIZONTAL;
                }
                return AD_IMMERSIVE_TYPE_Form;
            }
            return AD_IMMERSIVE_TYPE_NORMAL;
        }
        return AD_IMMERSIVE_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
