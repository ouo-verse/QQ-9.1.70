package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSFoldFullScreenChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFolderFirstFragmentShowEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bm extends u implements SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    private QCircleFolderBean f87768e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f87767d = false;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f87769f = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f87770h = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.bk
        @Override // java.lang.Runnable
        public final void run() {
            bm.this.D9();
        }
    };

    private void A9(@NotNull QFSFolderFirstFragmentShowEvent qFSFolderFirstFragmentShowEvent) {
        if (qFSFolderFirstFragmentShowEvent.getActivityHashCode() == getActivityHashCode() || !this.f87769f.get()) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.bl
            @Override // java.lang.Runnable
            public final void run() {
                bm.this.C9();
            }
        });
    }

    private long B9() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_fold_screen_mode_exit_time_out", String.valueOf(3000L)));
        } catch (Exception e16) {
            RFWLog.e("QFSFoldExitInterceptPart", RFWLog.USR, "getExitTimeOutDelay error:" + e16);
            return 3000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C9() {
        if (this.f87769f.get()) {
            RFWLog.d("QFSFoldExitInterceptPart", RFWLog.USR, "[dealFirstFeedSucceedEvent] real do destroy");
            RFWThreadManager.getUIHandler().removeCallbacks(this.f87770h);
            E9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D9() {
        E9();
        RFWLog.d("QFSFoldExitInterceptPart", RFWLog.USR, "timeout run");
    }

    private void E9() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            activity.finish();
        }
    }

    private boolean F9() {
        QCircleFolderBean qCircleFolderBean = this.f87768e;
        if (qCircleFolderBean != null && qCircleFolderBean.isTabFullScreenMode()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFolderFirstFragmentShowEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!F9()) {
            return false;
        }
        RFWLog.d("QFSFoldExitInterceptPart", RFWLog.USR, "[onBackEvent]");
        if (this.f87769f.compareAndSet(false, true)) {
            RFWLog.d("QFSFoldExitInterceptPart", RFWLog.USR, "[onBackEvent] do dispatch exit event");
            SimpleEventBus.getInstance().dispatchEvent(new QFSFoldFullScreenChangeEvent(getActivityHashCode(), false));
            RFWThreadManager.getUIHandler().postDelayed(this.f87770h, B9());
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!F9()) {
            return;
        }
        boolean p16 = com.tencent.biz.qqcircle.utils.bz.p();
        if (this.f87767d && !p16) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSFoldFullScreenChangeEvent(getActivityHashCode(), false));
            RFWLog.d("QFSFoldExitInterceptPart", RFWLog.USR, "[onConfigurationChanged] flat change to false");
            E9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(activity);
        if (qCircleInitBean instanceof QCircleFolderBean) {
            this.f87768e = (QCircleFolderBean) qCircleInitBean;
        }
        this.f87767d = com.tencent.biz.qqcircle.utils.bz.p();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFolderFirstFragmentShowEvent) {
            A9((QFSFolderFirstFragmentShowEvent) simpleBaseEvent);
        }
    }
}
