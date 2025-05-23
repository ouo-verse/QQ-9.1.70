package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdActionType implements WireEnum {
    AD_ACTION_TYPE_UNKNOWN(0),
    AD_ACTION_TYPE_OPEN_H5(1),
    AD_ACTION_TYPE_DOWNLOAD(2),
    AD_ACTION_TYPE_OPEN_APP(3),
    AD_ACTION_TYPE_OPEN_JDH5(4),
    AD_ACTION_TYPE_DOUBLE_LINK_OPEN_APP(5),
    AD_ACTION_TYPE_UNIVERSAL_LINK(6),
    AD_ACTION_TYPE_SUPER_UNIVERSAL_LINK(7),
    AD_ACTION_TYPE_OPEN_MINIPROGRAM(102),
    AD_ACTION_TYPE_OPEN_MINI_GAME(104);

    public static final ProtoAdapter<AdActionType> ADAPTER = new EnumAdapter<AdActionType>() { // from class: com.tencent.tvideo.protocol.pb.AdActionType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdActionType adActionType = AdActionType.AD_ACTION_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdActionType fromValue(int i3) {
            return AdActionType.fromValue(i3);
        }
    };
    private final int value;

    AdActionType(int i3) {
        this.value = i3;
    }

    public static AdActionType fromValue(int i3) {
        if (i3 != 102) {
            if (i3 != 104) {
                switch (i3) {
                    case 0:
                        return AD_ACTION_TYPE_UNKNOWN;
                    case 1:
                        return AD_ACTION_TYPE_OPEN_H5;
                    case 2:
                        return AD_ACTION_TYPE_DOWNLOAD;
                    case 3:
                        return AD_ACTION_TYPE_OPEN_APP;
                    case 4:
                        return AD_ACTION_TYPE_OPEN_JDH5;
                    case 5:
                        return AD_ACTION_TYPE_DOUBLE_LINK_OPEN_APP;
                    case 6:
                        return AD_ACTION_TYPE_UNIVERSAL_LINK;
                    case 7:
                        return AD_ACTION_TYPE_SUPER_UNIVERSAL_LINK;
                    default:
                        return null;
                }
            }
            return AD_ACTION_TYPE_OPEN_MINI_GAME;
        }
        return AD_ACTION_TYPE_OPEN_MINIPROGRAM;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
