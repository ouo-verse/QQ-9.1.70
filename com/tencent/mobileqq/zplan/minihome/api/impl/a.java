package com.tencent.mobileqq.zplan.minihome.api.impl;

import com.tencent.mobileqq.zplan.minihome.MiniHomeController;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mobileqq.zplan.minihome.y;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/api/impl/a;", "", "", "uin", "uniqueKey", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", "Lcom/tencent/mobileqq/zplan/minihome/y;", "a", "", "b", "Lcom/tencent/mobileqq/zplan/minihome/y;", "miniHomeController", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f334316a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static y miniHomeController;

    a() {
    }

    public final y a(String uin, String uniqueKey, MiniHomeSceneEnum scene) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(scene, "scene");
        y yVar = miniHomeController;
        if (Intrinsics.areEqual(uniqueKey, yVar != null ? yVar.getUin() : null)) {
            QLog.e("MiniHomeHelper", 1, "reuse miniHomeController");
            y yVar2 = miniHomeController;
            if (yVar2 != null) {
                yVar2.h(scene);
            }
            y yVar3 = miniHomeController;
            if (yVar3 != null) {
                yVar3.u();
            }
            y yVar4 = miniHomeController;
            Intrinsics.checkNotNull(yVar4);
            return yVar4;
        }
        QLog.e("MiniHomeHelper", 1, "new miniHomeController");
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        MiniHomeController miniHomeController2 = new MiniHomeController(context, uin, scene);
        miniHomeController2.u();
        miniHomeController = miniHomeController2;
        Intrinsics.checkNotNull(miniHomeController2);
        return miniHomeController2;
    }

    public final void b() {
        y yVar = miniHomeController;
        QLog.e("MiniHomeHelper", 1, "releaseMiniHomeController " + (yVar != null ? Integer.valueOf(yVar.v()) : null));
        y yVar2 = miniHomeController;
        if ((yVar2 != null ? yVar2.v() : 0) > 0) {
            return;
        }
        QLog.e("MiniHomeHelper", 1, "releaseMiniHomeController  miniHomeController = null");
        miniHomeController = null;
    }
}
