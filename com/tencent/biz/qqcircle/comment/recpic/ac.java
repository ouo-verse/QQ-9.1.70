package com.tencent.biz.qqcircle.comment.recpic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/ac;", "", "", "subCate", "photoId", "b", "", "c", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f83765a = new ac();

    ac() {
    }

    private final String b(String subCate, String photoId) {
        return subCate + "_" + photoId;
    }

    public final boolean a(@NotNull String subCate, @NotNull String photoId) {
        Intrinsics.checkNotNullParameter(subCate, "subCate");
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        if (System.currentTimeMillis() - uq3.k.a().f(b(subCate, photoId), 0L) > z.f83900a.k().getMinExposureInterval()) {
            return true;
        }
        return false;
    }

    public final void c(@NotNull String subCate, @NotNull String photoId) {
        Intrinsics.checkNotNullParameter(subCate, "subCate");
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        uq3.k.a().n(b(subCate, photoId), System.currentTimeMillis());
    }
}
