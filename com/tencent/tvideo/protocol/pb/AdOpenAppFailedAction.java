package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdOpenAppFailedAction implements WireEnum {
    AD_OPEN_APP_FAILED_UNKNOWN(0),
    AD_OPEN_APP_FAILED_NONE(1),
    AD_OPEN_APP_FAILED_TO_WEBVIEW(2),
    AD_OPEN_APP_FAILED_TO_DOWNLOAD(3);

    public static final ProtoAdapter<AdOpenAppFailedAction> ADAPTER = new EnumAdapter<AdOpenAppFailedAction>() { // from class: com.tencent.tvideo.protocol.pb.AdOpenAppFailedAction.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdOpenAppFailedAction adOpenAppFailedAction = AdOpenAppFailedAction.AD_OPEN_APP_FAILED_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdOpenAppFailedAction fromValue(int i3) {
            return AdOpenAppFailedAction.fromValue(i3);
        }
    };
    private final int value;

    AdOpenAppFailedAction(int i3) {
        this.value = i3;
    }

    public static AdOpenAppFailedAction fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return AD_OPEN_APP_FAILED_TO_DOWNLOAD;
                }
                return AD_OPEN_APP_FAILED_TO_WEBVIEW;
            }
            return AD_OPEN_APP_FAILED_NONE;
        }
        return AD_OPEN_APP_FAILED_UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
