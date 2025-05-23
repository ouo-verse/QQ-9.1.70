package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.immersive.events.QFSHandleFirstTaskPublishedEvent;
import com.tencent.biz.qqcircle.immersive.part.au;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 ;2\u00020\u0001:\u0001<B#\u0012\b\u0010$\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010'\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016R\u0016\u0010$\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010&R\u0016\u0010*\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010)R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00040+j\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0004`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0004018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00102R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/m;", "Lcom/tencent/biz/richframework/order/IOrderElement;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxCombineController;", "d", "Landroid/view/View;", "progressBox", "", "dif", "", "e", "Ljava/lang/Runnable;", "g", "p", DomainData.DOMAIN_NAME, "progressView", "j", "k", "l", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "isElementCanActivate", "onElementActivated", "onElementInactivated", "", "getGroup", "getPriority", "getContextHashCode", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/r;", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/r;", "mPart", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mContainerView", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "mProgressBoxMap", "", "Ljava/util/List;", "mProgressBoxList", "J", "mExposureTime", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Runnable;", "mFirstTaskDelayEndRunnable", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/r;Landroid/view/ViewGroup;)V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class m implements IOrderElement {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean E;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Runnable mFirstTaskDelayEndRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final r mPart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ViewGroup mContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, QFSRectBoxCombineController> mProgressBoxMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSRectBoxCombineController> mProgressBoxList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long mExposureTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/m$a;", "", "", "mShowing", "Z", "a", "()Z", "setMShowing", "(Z)V", "", "ANIMATOR_DURATION", "J", "", "DP_12", "I", "DP_6", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.publishprogress.m$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return m.E;
        }

        Companion() {
        }
    }

    public m(@Nullable Context context, @NotNull r mPart, @Nullable ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(mPart, "mPart");
        this.mContext = context;
        this.mPart = mPart;
        this.mContainerView = viewGroup;
        this.mProgressBoxMap = new HashMap<>();
        this.mProgressBoxList = new ArrayList();
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
    }

    private final QFSRectBoxCombineController d(TaskInfo taskInfo) {
        boolean z16;
        long taskId = taskInfo.getTaskId();
        QFSRectBoxCombineController qFSRectBoxCombineController = this.mProgressBoxMap.get(Long.valueOf(taskId));
        if (qFSRectBoxCombineController == null) {
            qFSRectBoxCombineController = new QFSRectBoxCombineController(taskInfo);
            if (this.mProgressBoxList.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qFSRectBoxCombineController.A(this.mContext, this.mPart, z16);
            this.mProgressBoxMap.put(Long.valueOf(taskId), qFSRectBoxCombineController);
            this.mProgressBoxList.add(qFSRectBoxCombineController);
            ViewGroup layoutView = qFSRectBoxCombineController.getLayoutView();
            ViewGroup viewGroup = this.mContainerView;
            if (viewGroup != null) {
                viewGroup.addView(layoutView, 0);
            }
            if (this.mProgressBoxList.size() == 1) {
                if (layoutView != null) {
                    layoutView.setVisibility(0);
                }
                QFSRectBoxCombineController.n(qFSRectBoxCombineController, false, 1, null);
            } else if (this.mProgressBoxList.size() == 2) {
                if (layoutView != null) {
                    layoutView.setVisibility(0);
                }
                e(layoutView, 6);
            } else if (this.mProgressBoxList.size() > 2) {
                if (layoutView != null) {
                    layoutView.setVisibility(8);
                }
                e(layoutView, 12);
            }
            if (this.mProgressBoxList.size() > 1) {
                this.mProgressBoxList.get(0).s();
            }
        }
        return qFSRectBoxCombineController;
    }

    private final void e(View progressBox, int dif) {
        float f16 = dif;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(progressBox, "translationX", ViewUtils.dpToPx(f16), ViewUtils.dpToPx(f16));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(progressBox, "translationY", ViewUtils.dpToPx(f16), ViewUtils.dpToPx(f16));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(0L);
        animatorSet.start();
    }

    private final void f() {
        Iterator<QFSRectBoxCombineController> it = this.mProgressBoxList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    private final Runnable g(final TaskInfo taskInfo) {
        return new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.l
            @Override // java.lang.Runnable
            public final void run() {
                m.h(m.this, taskInfo);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(m this$0, TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskInfo, "$taskInfo");
        this$0.n(taskInfo);
        SimpleEventBus.getInstance().dispatchEvent(new QFSHandleFirstTaskPublishedEvent(taskInfo));
        this$0.mFirstTaskDelayEndRunnable = null;
    }

    private final void j(QFSRectBoxCombineController progressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(progressView.getLayoutView(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(320L);
        ofFloat.addListener(new b(progressView));
        ofFloat.start();
    }

    private final void k() {
        if (this.mProgressBoxList.size() > 0) {
            QFSRectBoxCombineController qFSRectBoxCombineController = this.mProgressBoxList.get(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qFSRectBoxCombineController.getLayoutView(), "translationY", ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(0.0f));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(qFSRectBoxCombineController.getLayoutView(), "translationX", ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(0.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat2).with(ofFloat);
            animatorSet.setDuration(320L);
            animatorSet.start();
            qFSRectBoxCombineController.m(false);
        }
    }

    private final void l() {
        if (this.mProgressBoxList.size() > 1) {
            QFSRectBoxCombineController qFSRectBoxCombineController = this.mProgressBoxList.get(1);
            ViewGroup layoutView = qFSRectBoxCombineController.getLayoutView();
            if (layoutView != null) {
                layoutView.setVisibility(0);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qFSRectBoxCombineController.getLayoutView(), "translationY", ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(6.0f));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(qFSRectBoxCombineController.getLayoutView(), "translationX", ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(6.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat2).with(ofFloat);
            animatorSet.setDuration(320L);
            animatorSet.start();
        }
    }

    private final void n(TaskInfo taskInfo) {
        Long l3;
        HashMap<Long, QFSRectBoxCombineController> hashMap = this.mProgressBoxMap;
        if (taskInfo != null) {
            l3 = Long.valueOf(taskInfo.getTaskId());
        } else {
            l3 = null;
        }
        QFSRectBoxCombineController qFSRectBoxCombineController = (QFSRectBoxCombineController) TypeIntrinsics.asMutableMap(hashMap).remove(l3);
        if (qFSRectBoxCombineController == null) {
            return;
        }
        this.mProgressBoxList.remove(qFSRectBoxCombineController);
        qFSRectBoxCombineController.destroy();
        j(qFSRectBoxCombineController);
        k();
        l();
    }

    private final void p() {
        Runnable runnable = this.mFirstTaskDelayEndRunnable;
        if (runnable == null || this.mProgressBoxList.isEmpty()) {
            return;
        }
        TaskInfo mTaskInfo = this.mProgressBoxList.get(0).getMTaskInfo();
        if (com.tencent.biz.qqcircle.widgets.p.d(mTaskInfo)) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
            n(mTaskInfo);
            SimpleEventBus.getInstance().dispatchEvent(new QFSHandleFirstTaskPublishedEvent(mTaskInfo));
            this.mFirstTaskDelayEndRunnable = null;
        }
    }

    private final void q(boolean visible) {
        int i3;
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            viewGroup.setVisibility(i3);
        }
        E = visible;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    @NotNull
    public String getContextHashCode() {
        String num;
        Context context = this.mContext;
        if (context == null || (num = Integer.valueOf(context.hashCode()).toString()) == null) {
            return "";
        }
        return num;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    @NotNull
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

    public final void i() {
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.mProgressBoxMap.size() > 0) {
            return true;
        }
        return false;
    }

    public final void m(@Nullable TaskInfo taskInfo) {
        QFSRectBoxCombineController qFSRectBoxCombineController;
        if (taskInfo != null && (qFSRectBoxCombineController = this.mProgressBoxMap.get(Long.valueOf(taskInfo.getTaskId()))) != null) {
            qFSRectBoxCombineController.x(taskInfo);
        }
    }

    public final void o(@Nullable TaskInfo taskInfo) {
        long j3;
        if (taskInfo == null) {
            QLog.e("WinkPublish-Progress-QFSRectBoxProgressManager", 1, "[handleTaskStateChange] taskInfo is null");
            return;
        }
        if (taskInfo.isActive()) {
            p();
            QFSRectBoxCombineController d16 = d(taskInfo);
            QLog.e("WinkPublish-Progress-QFSRectBoxProgressManager", 1, "[handleTaskStateChange] notifyGroupActivate");
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this, RFWOrderElementManager.OrderMode.ROB_MODE);
            d16.y(taskInfo);
            return;
        }
        if (com.tencent.biz.qqcircle.widgets.p.d(taskInfo)) {
            k kVar = k.f88273a;
            if (kVar.d(taskInfo)) {
                QFSRectBoxCombineController qFSRectBoxCombineController = this.mProgressBoxMap.get(Long.valueOf(taskInfo.getTaskId()));
                if (qFSRectBoxCombineController != null) {
                    qFSRectBoxCombineController.r();
                    qFSRectBoxCombineController.destroy();
                } else {
                    qFSRectBoxCombineController = null;
                }
                if (qFSRectBoxCombineController != null) {
                    j3 = qFSRectBoxCombineController.getStartShowTimeMs();
                } else {
                    j3 = 0;
                }
                long b16 = kVar.b(j3);
                Runnable g16 = g(taskInfo);
                this.mFirstTaskDelayEndRunnable = g16;
                if (g16 != null) {
                    RFWThreadManager.getUIHandler().postDelayed(g16, b16);
                }
                QLog.i("WinkPublish-Progress-QFSRectBoxProgressManager", 1, "First publish, RectBox bubble need diffMs:" + b16);
                return;
            }
            n(taskInfo);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("WinkPublish-Progress-QFSRectBoxProgressManager", 1, "onElementActivated");
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup != null && viewGroup.getVisibility() != 0 && isElementCanActivate()) {
            this.mExposureTime = System.currentTimeMillis();
            q(true);
            au.C9(this.mContainerView, "dt_imp", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_LOADING_PANEL, null);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("WinkPublish-Progress-QFSRectBoxProgressManager", 1, "onElementInactivated");
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup != null && viewGroup.getVisibility() != 8) {
            q(false);
            long currentTimeMillis = System.currentTimeMillis() - this.mExposureTime;
            HashMap hashMap = new HashMap();
            hashMap.put("element_lvtm", Long.valueOf(currentTimeMillis));
            au.C9(this.mContainerView, "dt_imp_end", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_LOADING_PANEL, hashMap);
        }
        f();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/publishprogress/m$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSRectBoxCombineController f88284e;

        b(QFSRectBoxCombineController qFSRectBoxCombineController) {
            this.f88284e = qFSRectBoxCombineController;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            ViewGroup viewGroup = m.this.mContainerView;
            if (viewGroup != null) {
                viewGroup.removeView(this.f88284e.getLayoutView());
            }
            if (!m.this.isElementCanActivate()) {
                QLog.e("WinkPublish-Progress-QFSRectBoxProgressManager", 1, "[doFirstBoxAnimator] inactivateElement");
                com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(m.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
