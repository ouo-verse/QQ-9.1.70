package com.tencent.mobileqq.kandian.biz.share;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/a;", "", "", "a", "Ljava/lang/String;", "name", "", "b", "I", "action", "", "c", "Z", "webHandle", "<init>", "(Ljava/lang/String;IZ)V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int action;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean webHandle;

    public a(String name, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.action = i3;
        this.webHandle = z16;
    }
}
