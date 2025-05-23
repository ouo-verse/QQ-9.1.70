package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdFloatCardStyle implements WireEnum {
    DEFAULT_STYLE(0),
    STYLE_IDLE_CARD_OPTIMIZATION(1001),
    STYLE_SMALL_HORIZONTAL_CARD_ACTION_BUTTON(2005);

    public static final ProtoAdapter<AdFloatCardStyle> ADAPTER = new EnumAdapter<AdFloatCardStyle>() { // from class: com.tencent.tvideo.protocol.pb.AdFloatCardStyle.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdFloatCardStyle adFloatCardStyle = AdFloatCardStyle.DEFAULT_STYLE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFloatCardStyle fromValue(int i3) {
            return AdFloatCardStyle.fromValue(i3);
        }
    };
    private final int value;

    AdFloatCardStyle(int i3) {
        this.value = i3;
    }

    public static AdFloatCardStyle fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1001) {
                if (i3 != 2005) {
                    return null;
                }
                return STYLE_SMALL_HORIZONTAL_CARD_ACTION_BUTTON;
            }
            return STYLE_IDLE_CARD_OPTIMIZATION;
        }
        return DEFAULT_STYLE;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
