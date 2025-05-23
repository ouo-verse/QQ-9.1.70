package com.tencent.mobileqq.kandian.biz.share;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/b;", "Lcom/tencent/mobileqq/kandian/biz/share/a;", "", "d", "Ljava/lang/String;", "url", "name", "", "action", "", "webHandle", "<init>", "(Ljava/lang/String;IZLjava/lang/String;)V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String name, int i3, boolean z16, String url) {
        super(name, i3, z16);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }
}
