package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdFeedStyle implements WireEnum {
    AD_FEED_STYLE_NONE(0),
    AD_FEED_STYLE_IMMERSIVE(1);

    public static final ProtoAdapter<AdFeedStyle> ADAPTER = new EnumAdapter<AdFeedStyle>() { // from class: com.tencent.tvideo.protocol.pb.AdFeedStyle.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdFeedStyle adFeedStyle = AdFeedStyle.AD_FEED_STYLE_NONE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedStyle fromValue(int i3) {
            return AdFeedStyle.fromValue(i3);
        }
    };
    private final int value;

    AdFeedStyle(int i3) {
        this.value = i3;
    }

    public static AdFeedStyle fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return AD_FEED_STYLE_IMMERSIVE;
        }
        return AD_FEED_STYLE_NONE;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
