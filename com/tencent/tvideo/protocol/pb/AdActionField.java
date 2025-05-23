package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdActionField implements WireEnum {
    AD_ACTION_FIELD_UNKNOWN(0),
    AD_ACTION_FIELD_POSTER(1),
    AD_ACTION_FIELD_ACTION_BTN(2);

    public static final ProtoAdapter<AdActionField> ADAPTER = new EnumAdapter<AdActionField>() { // from class: com.tencent.tvideo.protocol.pb.AdActionField.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdActionField adActionField = AdActionField.AD_ACTION_FIELD_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdActionField fromValue(int i3) {
            return AdActionField.fromValue(i3);
        }
    };
    private final int value;

    AdActionField(int i3) {
        this.value = i3;
    }

    public static AdActionField fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return AD_ACTION_FIELD_ACTION_BTN;
            }
            return AD_ACTION_FIELD_POSTER;
        }
        return AD_ACTION_FIELD_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
