package com.tencent.biz.qqcircle.comment.recpic.db;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v20.b;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/db/a;", "", "Lv20/b;", "e", "", "a", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/biz/qqcircle/comment/recpic/aj;", "d", "info", "f", "b", "", "path", "c", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final b e() {
        try {
            return QFSPicInfoDatabase.d(this.context).e();
        } catch (Exception e16) {
            QLog.e("QFSRecPicInfoRepository", 1, "QFSRecPicInfoRepository init error", e16);
            return null;
        }
    }

    public final void a() {
        QFSPicInfoDatabase.c();
    }

    public final void b() {
        b e16 = e();
        if (e16 != null) {
            e16.deleteAll();
        }
    }

    public final void c(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        b e16 = e();
        if (e16 != null) {
            e16.delete(path);
        }
    }

    @Nullable
    public final LiveData<List<QFSRecPicInfo>> d() {
        b e16 = e();
        if (e16 != null) {
            return e16.getAllData();
        }
        return null;
    }

    public final void f(@NotNull QFSRecPicInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        b e16 = e();
        if (e16 != null) {
            e16.a(info);
        }
    }
}
