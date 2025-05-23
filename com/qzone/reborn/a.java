package com.qzone.reborn;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/a;", "", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "_experimentGrpId", "", "b", "d", "a", "", h.F, "reportExposure", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f52169a = new a();

    a() {
    }

    public final String a(String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(expName)");
        return expEntity.getGrayId();
    }

    public final boolean b(String expName, String _experimentGrpId) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(expName)");
        if (_experimentGrpId == null || _experimentGrpId.length() == 0) {
            _experimentGrpId = "_B";
        }
        return expEntity.isExperiment(expEntity.getExpName() + _experimentGrpId);
    }

    public final boolean d(String expName, String _experimentGrpId) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(expName)");
        expEntity.reportExpExposure();
        if (_experimentGrpId == null || _experimentGrpId.length() == 0) {
            _experimentGrpId = "_B";
        }
        return expEntity.isExperiment(expEntity.getExpName() + _experimentGrpId);
    }

    public final boolean f(String expName, boolean reportExposure) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(expName)");
        if (reportExposure) {
            expEntity.reportExpExposure();
        }
        return !expEntity.isExpInvalid();
    }

    public final void h(String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ABTestController.getInstance().getExpEntity(expName).reportExpExposure();
    }

    public static /* synthetic */ boolean c(a aVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "_B";
        }
        return aVar.b(str, str2);
    }

    public static /* synthetic */ boolean e(a aVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "_B";
        }
        return aVar.d(str, str2);
    }

    public static /* synthetic */ boolean g(a aVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return aVar.f(str, z16);
    }
}
