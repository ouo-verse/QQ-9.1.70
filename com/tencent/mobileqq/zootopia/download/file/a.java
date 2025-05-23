package com.tencent.mobileqq.zootopia.download.file;

import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import xk3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/file/a;", "", "", "downloadCategory", "", "b", "Lcom/tencent/mobileqq/z1/download/a;", "downloadParams", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f328049a = new a();

    a() {
    }

    public final FileDownloadParams a(FileDownloadParams downloadParams) {
        Pair<Integer, String> f16;
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        downloadParams.k(b(downloadParams.getCategory()));
        if (downloadParams.getCategory() == ZPlanFileCategory.LuaDownload.getValue() && (f16 = e.f448113d.f()) != null) {
            downloadParams.l(f16.getFirst());
            downloadParams.m(f16.getSecond());
        }
        return downloadParams;
    }

    public final String b(int downloadCategory) {
        String g16;
        if (downloadCategory == ZPlanFileCategory.LuaDownload.getValue()) {
            g16 = e.f448113d.h();
        } else {
            g16 = e.f448113d.g();
        }
        return g16 == null ? "" : g16;
    }
}
