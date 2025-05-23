package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/j;", "", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/c;", "a", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper;", "f", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/k;", "e", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/i;", "d", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/e;", "c", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/l;", "b", "Lsb4/a;", "Lsb4/a;", "getPreviewPage", "()Lsb4/a;", "previewPage", "<init>", "(Lsb4/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sb4.a previewPage;

    public j(sb4.a previewPage) {
        Intrinsics.checkNotNullParameter(previewPage, "previewPage");
        this.previewPage = previewPage;
    }

    public final c a() {
        return new c(this.previewPage);
    }

    public final l b() {
        return new l(this.previewPage);
    }

    public final e c() {
        return new e(this.previewPage);
    }

    public final i d() {
        return new i(this.previewPage);
    }

    public final k e() {
        return new k(this.previewPage);
    }

    public final PreviewVideoPlayHelper f() {
        return new PreviewVideoPlayHelper(this.previewPage);
    }
}
