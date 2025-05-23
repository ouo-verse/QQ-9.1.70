package com.tencent.sqshow.zootopia.samestyle;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPage;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPageFrom;
import com.tencent.sqshow.zootopia.samestyle.mix.ZPlanTemplateMixPreviewPage;
import com.tencent.state.report.SquareReportConst;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/a;", "Li74/a;", "", "e", "", "d", "", "keyCode", "Landroid/view/KeyEvent;", "event", "g", "b", "f", "Landroidx/fragment/app/Fragment;", tl.h.F, "Landroidx/fragment/app/Fragment;", "fragment", "", "l", "()Ljava/lang/String;", "logicName", "<init>", "()V", "i", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends i74.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Fragment fragment;

    @Override // i74.a
    public void b() {
        Fragment fragment = this.fragment;
        Fragment fragment2 = null;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment = null;
        }
        if (fragment instanceof QPublicBaseFragment) {
            Fragment fragment3 = this.fragment;
            if (fragment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
            } else {
                fragment2 = fragment3;
            }
            ((QPublicBaseFragment) fragment2).beforeFinish();
        }
    }

    @Override // i74.a
    public boolean d() {
        Fragment fragment = this.fragment;
        Fragment fragment2 = null;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment = null;
        }
        if (!(fragment instanceof QPublicBaseFragment)) {
            return false;
        }
        Fragment fragment3 = this.fragment;
        if (fragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
        } else {
            fragment2 = fragment3;
        }
        return ((QPublicBaseFragment) fragment2).onBackEvent();
    }

    @Override // i74.a
    public void e() {
        Fragment zPlanTemplatePreviewFragment;
        super.e();
        k().setTheme(R.style.Theme.Black.NoTitleBar);
        k().setContentView(com.tencent.mobileqq.R.layout.dc8);
        QLog.i("SameStyleActivityLogic", 1, "doOnCreate readyCallback forceStopEngineOnDestroy" + k().getIntent().getBooleanExtra("key_force_stop_engine_on_destroy", false));
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).zootopiaServiceManagerStartZPlanService();
        Serializable serializableExtra = k().getIntent().getSerializableExtra("share_extra_params");
        HashMap<String, Object> hashMap = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
        if (hashMap != null) {
            ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setShareExtraParams(hashMap);
        }
        Serializable serializableExtra2 = k().getIntent().getSerializableExtra(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE);
        ZootopiaSource zootopiaSource = serializableExtra2 instanceof ZootopiaSource ? (ZootopiaSource) serializableExtra2 : null;
        if (zootopiaSource != null) {
            ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setSource(zootopiaSource);
        }
        int intExtra = k().getIntent().getIntExtra("biz", 0);
        String stringExtra = k().getIntent().getStringExtra("KEY_FROM");
        if (stringExtra == null) {
            stringExtra = SameStyleContentPageFrom.FROM_SAME_STYLE;
        }
        boolean areEqual = Intrinsics.areEqual(stringExtra, SameStyleContentPageFrom.FROM_CONTENT_PUBLISH);
        if (intExtra != 0) {
            QLog.i("SameStyleActivityLogic", 1, "doOnCreate from:" + stringExtra);
            if (areEqual) {
                zPlanTemplatePreviewFragment = new ZPlanTemplateMixPreviewPage();
            } else {
                zPlanTemplatePreviewFragment = new ZPlanTemplatePreviewFragment();
            }
        } else if (areEqual) {
            zPlanTemplatePreviewFragment = SameStyleContentPage.Companion.c(SameStyleContentPage.INSTANCE, SameStyleContentPageFrom.FROM_SAME_STYLE, zootopiaSource == null ? ZootopiaSource.INSTANCE.i() : zootopiaSource, null, 4, null);
        } else {
            zPlanTemplatePreviewFragment = new ZPlanTemplateEntranceFragment();
        }
        this.fragment = zPlanTemplatePreviewFragment;
        if (zPlanTemplatePreviewFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            zPlanTemplatePreviewFragment = null;
        }
        zPlanTemplatePreviewFragment.setArguments(k().getIntent().getExtras());
        Fragment fragment = this.fragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment = null;
        }
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            if (zootopiaSource == null) {
                zootopiaSource = ZootopiaSource.INSTANCE.i();
            }
            arguments.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, zootopiaSource);
        }
        FragmentTransaction beginTransaction = k().getSupportFragmentManager().beginTransaction();
        Fragment fragment2 = this.fragment;
        if (fragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment2 = null;
        }
        beginTransaction.replace(com.tencent.mobileqq.R.id.plw, fragment2).commitAllowingStateLoss();
        ((ICommonApi) QRoute.api(ICommonApi.class)).refreshClothesCache();
        QRouteApi api = QRoute.api(ICommonApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ICommonApi::class.java)");
        ICommonApi.a.a((ICommonApi) api, null, 1, null);
    }

    @Override // i74.a
    public void f() {
        super.f();
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).clearShareExtraParams();
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).clearSource();
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).zootopiaServiceManagerStopZPlanService(true);
    }

    @Override // i74.a
    public boolean g(int keyCode, KeyEvent event) {
        Fragment fragment = this.fragment;
        Fragment fragment2 = null;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment = null;
        }
        if (!(fragment instanceof QPublicBaseFragment)) {
            return false;
        }
        Fragment fragment3 = this.fragment;
        if (fragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
        } else {
            fragment2 = fragment3;
        }
        return ((QPublicBaseFragment) fragment2).doOnKeyDown(keyCode, event);
    }

    @Override // i74.a
    /* renamed from: l */
    protected String getLogicName() {
        return "SameStyleActivityLogic";
    }
}
