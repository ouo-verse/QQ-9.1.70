package com.tencent.sqshow.zootopia.nativeui.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/g;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "zplanAvatarMallPageType", "b", "d", "zplanPageOpenSource", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String zplanAvatarMallPageType = "1";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String zplanPageOpenSource = "";

    /* renamed from: a, reason: from getter */
    public final String getZplanAvatarMallPageType() {
        return this.zplanAvatarMallPageType;
    }

    /* renamed from: b, reason: from getter */
    public final String getZplanPageOpenSource() {
        return this.zplanPageOpenSource;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zplanAvatarMallPageType = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zplanPageOpenSource = str;
    }
}
