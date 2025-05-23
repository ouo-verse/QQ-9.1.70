package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/data/SquareMainPosterShareInfo;", "", "background", "", "qrCodeUrl", "nickName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackground", "()Ljava/lang/String;", "getNickName", "getQrCodeUrl", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMainPosterShareInfo {
    private final String background;
    private final String nickName;
    private final String qrCodeUrl;

    public SquareMainPosterShareInfo() {
        this(null, null, null, 7, null);
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public SquareMainPosterShareInfo(String str, String str2, String str3) {
        this.background = str;
        this.qrCodeUrl = str2;
        this.nickName = str3;
    }

    public /* synthetic */ SquareMainPosterShareInfo(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
    }
}
