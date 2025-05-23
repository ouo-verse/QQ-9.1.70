package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class at implements IOrderElement {
    public static boolean F = false;
    private long C;
    private View D;
    private mc0.a E;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f87718d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f87719e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f87720f;

    /* renamed from: h, reason: collision with root package name */
    private au f87721h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<Long, QFSBoxProgress> f87722i = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private List<QFSBoxProgress> f87723m = new ArrayList();

    public at(Activity activity, Context context, au auVar, ViewGroup viewGroup, View view) {
        this.f87718d = activity;
        this.f87719e = context;
        this.f87721h = auVar;
        this.f87720f = viewGroup;
        this.D = view;
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
    }

    private void d(View view, int i3) {
        float f16 = i3;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", ViewUtils.dpToPx(f16), ViewUtils.dpToPx(f16));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", ViewUtils.dpToPx(f16), ViewUtils.dpToPx(f16));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(0L);
        animatorSet.start();
    }

    private void g(QFSBoxProgress qFSBoxProgress) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qFSBoxProgress.f87321e, "translationY", ViewUtils.dpToPx(0.0f), ViewUtils.dpToPx(-50.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(qFSBoxProgress.f87321e, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(320L);
        animatorSet.start();
        animatorSet.addListener(new a(qFSBoxProgress));
    }

    private void h() {
        QFSBoxProgress qFSBoxProgress;
        if (this.f87723m.size() <= 0 || (qFSBoxProgress = this.f87723m.get(0)) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qFSBoxProgress.f87321e, "translationY", ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(0.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(qFSBoxProgress.f87321e, "translationX", ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(0.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).with(ofFloat);
        animatorSet.setDuration(320L);
        animatorSet.start();
        qFSBoxProgress.f();
    }

    private void i() {
        QFSBoxProgress qFSBoxProgress;
        if (this.f87723m.size() <= 1 || (qFSBoxProgress = this.f87723m.get(1)) == null) {
            return;
        }
        qFSBoxProgress.f87321e.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qFSBoxProgress.f87321e, "translationY", ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(8.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(qFSBoxProgress.f87321e, "translationX", ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(8.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).with(ofFloat);
        animatorSet.setDuration(320L);
        animatorSet.start();
    }

    private boolean l() {
        if (!QCirclePluginUtil.isTabMode()) {
            return true;
        }
        boolean isOnThirdTab = ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        QLog.d("WinkPublish-Progress-QFSBoxProgressManager", 1, "isTabMode: true, select qCircle: " + isOnThirdTab);
        return isOnThirdTab;
    }

    private boolean m(TaskInfo taskInfo) {
        String str;
        if (taskInfo == null) {
            return false;
        }
        if (taskInfo.getTransParams() != null) {
            str = taskInfo.getTransParams().getString(QQWinkConstants.WINK_PUBLISH_TASK_ID);
        } else {
            str = "";
        }
        if (QQWinkConstants.WinkPublishTaskID.XSJ_TOUXIANG.equals(str)) {
            return false;
        }
        if ((taskInfo.getBusinessType() == 7 || QQWinkConstants.WinkPublishTaskID.QQ_STATUS_NEW.equals(str)) && !QQWinkConstants.WinkPublishTaskID.QQ_STATUS_OLD.equals(str)) {
            return false;
        }
        return true;
    }

    private void n(boolean z16) {
        int i3;
        ViewGroup viewGroup = this.f87720f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        F = z16;
    }

    private void o() {
        Activity activity;
        mc0.a aVar = this.E;
        if ((aVar == null || !aVar.isShowing()) && (activity = this.f87718d) != null && !activity.isFinishing()) {
            View view = this.D;
            if (view != null && view.getAlpha() == 0.0f) {
                return;
            }
            if (!l()) {
                QLog.d("WinkPublish-Progress-QFSBoxProgressManager", 1, "isQCircleInTopActivity = false. ");
            } else {
                this.E = (mc0.a) mc0.a.c(this.f87719e, R.string.f193934aj).setAnchor(this.f87720f).setPosition(1).setAlignment(1);
            }
        }
    }

    public QFSBoxProgress c(TaskInfo taskInfo) {
        long taskId = taskInfo.getTaskId();
        QFSBoxProgress qFSBoxProgress = this.f87722i.get(Long.valueOf(taskId));
        if (qFSBoxProgress == null) {
            qFSBoxProgress = new QFSBoxProgress(taskInfo);
            qFSBoxProgress.l(this.f87719e, this.f87721h);
            this.f87722i.put(Long.valueOf(taskId), qFSBoxProgress);
            this.f87723m.add(qFSBoxProgress);
            this.f87720f.addView(qFSBoxProgress.f87321e, 0);
            if (this.f87723m.size() == 1) {
                qFSBoxProgress.f87321e.setVisibility(0);
                qFSBoxProgress.f();
            } else if (this.f87723m.size() == 2) {
                qFSBoxProgress.f87321e.setVisibility(0);
                d(qFSBoxProgress.f87321e, 8);
            } else if (this.f87723m.size() > 2) {
                qFSBoxProgress.f87321e.setVisibility(8);
                d(qFSBoxProgress.f87321e, 16);
            }
        }
        return qFSBoxProgress;
    }

    public void e() {
        for (QFSBoxProgress qFSBoxProgress : this.f87723m) {
            if (qFSBoxProgress != null) {
                qFSBoxProgress.destroy();
            }
        }
    }

    public void f() {
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        Context context = this.f87719e;
        if (context == null) {
            return "";
        }
        return String.valueOf(context.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "folder_pendant";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 104;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        HashMap<Long, QFSBoxProgress> hashMap = this.f87722i;
        if (hashMap != null && hashMap.size() > 0) {
            return true;
        }
        return false;
    }

    public void j(TaskInfo taskInfo) {
        QFSBoxProgress qFSBoxProgress;
        if (taskInfo != null && (qFSBoxProgress = this.f87722i.get(Long.valueOf(taskInfo.getTaskId()))) != null) {
            qFSBoxProgress.j(taskInfo);
        }
    }

    public void k(TaskInfo taskInfo) {
        QFSBoxProgress remove;
        if (taskInfo == null) {
            QLog.e("WinkPublish-Progress-QFSBoxProgressManager", 1, "[handleTaskStateChange] taskInfo is null");
            return;
        }
        if (taskInfo.isActive()) {
            QFSBoxProgress c16 = c(taskInfo);
            if (m(taskInfo)) {
                QLog.e("WinkPublish-Progress-QFSBoxProgressManager", 1, "[handleTaskStateChange] notifyGroupActivate");
                com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this, RFWOrderElementManager.OrderMode.ROB_MODE);
            }
            c16.k(taskInfo);
            return;
        }
        if (!com.tencent.biz.qqcircle.widgets.p.d(taskInfo) || (remove = this.f87722i.remove(Long.valueOf(taskInfo.getTaskId()))) == null) {
            return;
        }
        this.f87723m.remove(remove);
        remove.destroy();
        g(remove);
        h();
        i();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("WinkPublish-Progress-QFSBoxProgressManager", 1, "onElementActivated");
        ViewGroup viewGroup = this.f87720f;
        if (viewGroup != null && viewGroup.getVisibility() != 0 && isElementCanActivate()) {
            this.C = System.currentTimeMillis();
            n(true);
            o();
            au.C9(this.f87720f, "dt_imp", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_LOADING_PANEL, null);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("WinkPublish-Progress-QFSBoxProgressManager", 1, "onElementInactivated");
        ViewGroup viewGroup = this.f87720f;
        if (viewGroup != null && viewGroup.getVisibility() != 8) {
            n(false);
            long currentTimeMillis = System.currentTimeMillis() - this.C;
            HashMap hashMap = new HashMap();
            hashMap.put("element_lvtm", Long.valueOf(currentTimeMillis));
            au.C9(this.f87720f, "dt_imp_end", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_LOADING_PANEL, hashMap);
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSBoxProgress f87724d;

        a(QFSBoxProgress qFSBoxProgress) {
            this.f87724d = qFSBoxProgress;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f87724d != null) {
                at.this.f87720f.removeView(this.f87724d.f87321e);
            }
            if (!at.this.isElementCanActivate()) {
                QLog.e("WinkPublish-Progress-QFSBoxProgressManager", 1, "[doFirstBoxAnimator] inactivateElement");
                com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(at.this);
            }
            if (at.this.E != null && at.this.E.isShowing()) {
                at.this.E.dismiss();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
