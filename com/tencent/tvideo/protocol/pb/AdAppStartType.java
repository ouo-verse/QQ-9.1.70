package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdAppStartType implements WireEnum {
    AD_APP_START_TYPE_OTHER(0),
    AD_APP_START_TYPE_Default(1),
    AD_APP_START_TYPE_PUSH(2),
    AD_APP_START_TYPE_URL(3);

    public static final ProtoAdapter<AdAppStartType> ADAPTER = new EnumAdapter<AdAppStartType>() { // from class: com.tencent.tvideo.protocol.pb.AdAppStartType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdAppStartType adAppStartType = AdAppStartType.AD_APP_START_TYPE_OTHER;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdAppStartType fromValue(int i3) {
            return AdAppStartType.fromValue(i3);
        }
    };
    private final int value;

    AdAppStartType(int i3) {
        this.value = i3;
    }

    public static AdAppStartType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return AD_APP_START_TYPE_URL;
                }
                return AD_APP_START_TYPE_PUSH;
            }
            return AD_APP_START_TYPE_Default;
        }
        return AD_APP_START_TYPE_OTHER;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
