package com.tencent.mobileqq.zplan.emoticon.panel.repository;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ<\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\b0\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/a;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/AbsRepository;", "Lcom/tencent/mobileqq/zplan/model/e;", "info", "", "uin", "Lkotlin/Function3;", "", "", "callback", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends AbsRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final a f333162b = new a();

    a() {
    }

    public void e(ZPlanActionInfo info, String uin, Function3<? super Integer, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        File file = new File(a(com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.f(info, uin), info.getId()));
        if (file.exists() && file.isDirectory()) {
            if (b(file)) {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "resFile.absolutePath");
                d(absolutePath, callback);
                QLog.i("Emoticon2DLocalRepository", 1, "query success, match local data, info=" + info);
                return;
            }
            QLog.i("Emoticon2DLocalRepository", 1, "query failed, fileTree is empty, info=" + info);
            FileUtils.deleteDirectory(file.getAbsolutePath());
            callback.invoke(-1, "", "");
            return;
        }
        QLog.w("Emoticon2DLocalRepository", 1, "no match local data, " + info);
        callback.invoke(-1, "", "");
    }
}
