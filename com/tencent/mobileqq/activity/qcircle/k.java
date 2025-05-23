package com.tencent.mobileqq.activity.qcircle;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.utils.l;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.thread.RFWThreadManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.qqnt.avatar.meta.refresh.c<FrameFragment> f184570a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f184571b;

    /* renamed from: c, reason: collision with root package name */
    private static final Observer<? super Boolean> f184572c = new a();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[dealWithEventDelayInit]  guild create");
                LiveData<Boolean> guildTabLoadingFinishData = ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).guildTabLoadingFinishData();
                if (guildTabLoadingFinishData != null) {
                    guildTabLoadingFinishData.removeObserver(this);
                }
                FrameFragment c16 = k.c();
                if (c16 != null) {
                    RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[dealWithEventDelayInit] real do");
                    QCircleInjectImpl.E0(c16);
                }
            }
        }
    }

    static /* bridge */ /* synthetic */ FrameFragment c() {
        return e();
    }

    private static void d(@NotNull FrameFragment frameFragment) {
        if (frameFragment.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183047j) {
            LiveData<Boolean> guildTabLoadingFinishData = ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).guildTabLoadingFinishData();
            RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[dealWithEventDelayInit] guild tab,guildTabFinishLiveData:" + guildTabLoadingFinishData);
            if (guildTabLoadingFinishData != null) {
                Observer<? super Boolean> observer = f184572c;
                guildTabLoadingFinishData.removeObserver(observer);
                guildTabLoadingFinishData.observeForever(observer);
                return;
            }
            return;
        }
        RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[dealWithEventDelayInit] default msg tab");
        QCircleInjectImpl.E0(frameFragment);
    }

    private static FrameFragment e() {
        com.tencent.qqnt.avatar.meta.refresh.c<FrameFragment> cVar = f184570a;
        if (cVar == null) {
            return null;
        }
        return cVar.get();
    }

    private static boolean f(String str) {
        String assignment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("qfs_preload_view_exp_9095");
        if (!TextUtils.isEmpty(assignment)) {
            return TextUtils.equals(assignment, str);
        }
        String h16 = uq3.k.a().h("sp_key_preload_view_9095_exp_name", "");
        RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[isHit] load from mmkv:" + h16);
        if (!TextUtils.isEmpty(h16)) {
            return TextUtils.equals(h16, str);
        }
        if (!l.g()) {
            return false;
        }
        return TextUtils.equals(str, "qfs_preload_view_exp_9095_D");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g() {
        RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[onMainTabCreate] hit C");
        FrameFragment e16 = e();
        if (e16 != null) {
            QCircleInjectImpl.E0(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h() {
        String assignment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("qfs_preload_view_exp_9095");
        RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "reportExpExposure :" + assignment);
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("qfs_preload_view_exp_9095");
    }

    public static void i() {
        f184571b = false;
    }

    public static void j(FrameFragment frameFragment) {
        if (frameFragment == null) {
            return;
        }
        f184570a = new com.tencent.qqnt.avatar.meta.refresh.c<>(frameFragment);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pre_load_view_exp", true)) {
            QCircleInjectImpl.E0(frameFragment);
            return;
        }
        if (f("qfs_preload_view_exp_9095_B")) {
            RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[onMainTabCreate] hit B do nothing");
        } else if (f("qfs_preload_view_exp_9095_C")) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.g();
                }
            }, 7000L);
        } else if (f("qfs_preload_view_exp_9095_D")) {
            d(frameFragment);
        } else {
            RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[onMainTabCreate] hit other");
            QCircleInjectImpl.E0(frameFragment);
        }
        k();
    }

    public static void k() {
        if (!f184571b) {
            f184571b = true;
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.h();
                }
            }, 3000L);
        }
    }

    public static void l() {
        String assignment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("qfs_preload_view_exp_9095");
        if (TextUtils.isEmpty(assignment)) {
            return;
        }
        uq3.k.a().p("sp_key_preload_view_9095_exp_name", assignment);
        RFWLog.d("QFSPreloadFluency9095", RFWLog.USR, "[saveTabExp]" + assignment);
    }
}
