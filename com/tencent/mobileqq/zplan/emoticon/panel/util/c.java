package com.tencent.mobileqq.zplan.emoticon.panel.util;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.emoticon.api.impl.ZPlanEmotionPanelBuilderImpl;
import com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter;
import com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager;
import com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import java.util.List;
import kotlin.Metadata;
import t74.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0016\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001:B\u000f\u0012\u0006\u00107\u001a\u00020\u0014\u00a2\u0006\u0004\b8\u00109J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\b\u0010,\u001a\u00020\u000eH\u0016R\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00103R\u0016\u00106\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/util/c;", "Lcom/tencent/mobileqq/emoticonview/AbsEmoticonPanelLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/emoticon/EmotionInjectionInfo;", "f", "Lcom/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter;", "d", "Loh3/a;", "e", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelInfo;", "panelDataList", "", "j", "", "k", "l", "Lcom/tencent/mobileqq/emoticonview/IEmoticonPanelController;", "controller", "p", "", "position", "i", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lrj3/a;", "g", DomainData.DOMAIN_NAME, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "", "interestedIn", "", "getTag", "initAfter", "onShow", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestory", "onPageSelected", "openSoftInput", "onHide", "onPullUp", "onPullDown", "Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "", "J", "mTabExposeTime", "I", "mExposeState", "providerID", "<init>", "(I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class c extends AbsEmoticonPanelLifecycleObserver implements LifecycleOwner {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LifecycleRegistry lifecycleRegistry;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mTabExposeTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mExposeState;

    public c(int i3) {
        super(i3);
        this.lifecycleRegistry = new LifecycleRegistry(this);
        this.mExposeState = -1;
        QLog.i("[zplan][ZPlanEmoticonPanelHelper]", 1, "create new!");
    }

    private final ZPlanEmoticonAdapter d() {
        ZPlanEmotionPanelBuilderImpl zPlanEmotionPanelBuilderImpl;
        EmotionInjectionInfo f16 = f();
        if (f16 == null) {
            return null;
        }
        IEmotionPanelBuilder iEmotionPanelBuilder = f16.emotionPanelBuilder;
        if (!(iEmotionPanelBuilder == null ? true : iEmotionPanelBuilder instanceof ZPlanEmotionPanelBuilderImpl) || (zPlanEmotionPanelBuilderImpl = (ZPlanEmotionPanelBuilderImpl) iEmotionPanelBuilder) == null) {
            return null;
        }
        return zPlanEmotionPanelBuilderImpl.getAdapter();
    }

    private final oh3.a e() {
        IEmotionTabCreateListener iEmotionTabCreateListener;
        EmotionInjectionInfo f16 = f();
        if (f16 == null || (iEmotionTabCreateListener = f16.emotionTabListener) == null || !(iEmotionTabCreateListener instanceof oh3.a)) {
            return null;
        }
        return (oh3.a) iEmotionTabCreateListener;
    }

    private final EmotionInjectionInfo f() {
        T t16 = this.mPanelController;
        if (t16 == 0) {
            return null;
        }
        return t16.getEmotionInjectionInfo(17);
    }

    private final rj3.a g(IEmoticonPanelController controller) {
        IPanelInteractionListener hostInterface = controller.getHostInterface();
        int curType = hostInterface != null ? hostInterface.getCurType() : -1;
        IPanelInteractionListener hostInterface2 = controller.getHostInterface();
        return new rj3.a().g(hostInterface2 != null ? hostInterface2.getCurFriendUin() : null).b(curType).e(2).k(1);
    }

    private final void h(int position) {
        oh3.a e16 = e();
        if (e16 != null) {
            e16.b(position);
        }
    }

    private final void i(IEmoticonPanelController controller, int position) {
        h(position);
        m(controller);
        n(controller);
    }

    private final void k() {
        IEmoticonPanelController iEmoticonPanelController = this.mPanelController;
        if (iEmoticonPanelController == null || this.mExposeState == 1) {
            return;
        }
        this.mExposeState = 1;
        r.c("aio", "emojicmtab", "bigexpose", g(iEmoticonPanelController).a());
    }

    private final void l() {
        IEmoticonPanelController iEmoticonPanelController = this.mPanelController;
        if (iEmoticonPanelController == null || this.mExposeState == 0) {
            return;
        }
        this.mExposeState = 0;
        r.c("aio", "emojicmtab", "smallexpose", g(iEmoticonPanelController).a());
    }

    private final void m(IEmoticonPanelController controller) {
        r.c("aio", "emojicmtab", "click", g(controller).a());
    }

    private final void o(IEmoticonPanelController controller) {
        if (j(controller.getPanelDataList())) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.mTabExposeTime > 2000) {
                this.mTabExposeTime = elapsedRealtime;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(IEmotionTabCreateListener iEmotionTabCreateListener) {
        ((oh3.a) iEmotionTabCreateListener).c();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        return "[zplan][ZPlanEmoticonPanelHelper]";
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initAfter() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        super.initAfter();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDestory() {
        QLog.i("[zplan][ZPlanEmoticonPanelHelper]", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        try {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            ZPlanEmoticonUtil.f333176e.s();
        } catch (Throwable th5) {
            QLog.e("[zplan][ZPlanEmoticonPanelHelper]", 1, "onDestroy exception", th5);
        }
        super.onDestory();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int position) {
        try {
            IEmoticonPanelController iEmoticonPanelController = this.mPanelController;
            if (iEmoticonPanelController == null) {
                return;
            }
            boolean isEmoticonOnShow = iEmoticonPanelController.isEmoticonOnShow(17);
            QLog.w("[zplan][ZPlanEmoticonPanelHelper]", 1, "onPageSelected, isZPlanTabShowing:" + isEmoticonOnShow);
            ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
            if (a16 != null) {
                a16.notifyUI(7, true, Boolean.valueOf(isEmoticonOnShow));
            }
            if (isEmoticonOnShow) {
                i(iEmoticonPanelController, position);
                MemeHelper.INSTANCE.toggleQueuePauseState(false, "EmoticonPageSelected");
                ZPlanEmoticonUtil.f333176e.J(LifecycleOwnerKt.getLifecycleScope(this));
            }
            ZPlanEmoticonAdapter d16 = d();
            if (d16 != null) {
                d16.D(isEmoticonOnShow);
            }
            if (isEmoticonOnShow) {
                return;
            }
            this.mExposeState = -1;
        } catch (Throwable th5) {
            QLog.e("[zplan][ZPlanEmoticonPanelHelper]", 1, "onPageSelected error", th5);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullDown() {
        T t16 = this.mPanelController;
        if (t16 != 0 && t16.isEmoticonOnShow(17)) {
            l();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullUp() {
        T t16 = this.mPanelController;
        if (t16 != 0 && t16.isEmoticonOnShow(17)) {
            k();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onResume() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        super.onResume();
        QLog.w("[zplan][ZPlanEmoticonPanelHelper]", 1, "onResume");
        ZPlanEmoticonAdapter d16 = d();
        if (d16 != null) {
            d16.C();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onShow() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        try {
            IEmoticonPanelController iEmoticonPanelController = this.mPanelController;
            if (iEmoticonPanelController == null) {
                return;
            }
            p(iEmoticonPanelController);
            o(iEmoticonPanelController);
            n(iEmoticonPanelController);
            boolean isEmoticonOnShow = this.mPanelController.isEmoticonOnShow(17);
            ZPlanEmoticonTabAvatarManager.f333345a.J(isEmoticonOnShow);
            ZPlanEmoticonAdapter d16 = d();
            if (d16 != null) {
                d16.E(isEmoticonOnShow);
            }
            ZPlanEmoticonUtil.f333176e.d0(true);
        } catch (Throwable th5) {
            QLog.e("[zplan][ZPlanEmoticonPanelHelper]", 1, "onShow error", th5);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onHide(boolean openSoftInput) {
        QLog.w("[zplan][ZPlanEmoticonPanelHelper]", 1, "onHide");
        if (this.lifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        zPlanEmoticonUtil.d0(false);
        zPlanEmoticonUtil.c0("aio");
        ZPlanEmoticonAdapter d16 = d();
        if (d16 != null) {
            d16.A();
        }
        this.mExposeState = -1;
        this.mTabExposeTime = 0L;
        kh3.c.f412361a.o();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPause() {
        QLog.i("[zplan][ZPlanEmoticonPanelHelper]", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        if (this.lifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        super.onPause();
        ZPlanEmoticonAdapter d16 = d();
        if (d16 != null) {
            d16.B();
        }
    }

    private final void n(IEmoticonPanelController controller) {
        if (controller.isEmoticonOnShow(17)) {
            if (controller.isPanelOpen()) {
                k();
            } else {
                l();
            }
        }
    }

    private final void p(IEmoticonPanelController controller) {
        EmotionInjectionInfo emotionInjectionInfo = controller.getEmotionInjectionInfo(17);
        if (emotionInjectionInfo == null) {
            return;
        }
        boolean isEmoticonOnShow = controller.isEmoticonOnShow(17);
        final IEmotionTabCreateListener iEmotionTabCreateListener = emotionInjectionInfo.emotionTabListener;
        if (!(iEmotionTabCreateListener instanceof oh3.a) || isEmoticonOnShow) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.util.b
            @Override // java.lang.Runnable
            public final void run() {
                c.q(IEmotionTabCreateListener.this);
            }
        }, 100L);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        return new int[]{5, 3, 4, 11, 12, 6, 7, 8};
    }

    private final boolean j(List<? extends EmotionPanelInfo> panelDataList) {
        if (panelDataList == null) {
            return false;
        }
        for (EmotionPanelInfo emotionPanelInfo : panelDataList) {
            if (emotionPanelInfo != null && emotionPanelInfo.type == 17) {
                return true;
            }
        }
        return false;
    }
}
