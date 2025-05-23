package com.qzone.reborn.albumx.common.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/i;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "leftText", "b", "d", "(Ljava/lang/String;)V", "rightTip", "", "c", "Z", "()Z", "e", "(Z)V", "isShowSwitch", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String leftText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String rightTip;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isShowSwitch;

    public i(String leftText) {
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        this.leftText = leftText;
        this.rightTip = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getLeftText() {
        return this.leftText;
    }

    /* renamed from: b, reason: from getter */
    public final String getRightTip() {
        return this.rightTip;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsShowSwitch() {
        return this.isShowSwitch;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightTip = str;
    }

    public final void e(boolean z16) {
        this.isShowSwitch = z16;
    }
}
