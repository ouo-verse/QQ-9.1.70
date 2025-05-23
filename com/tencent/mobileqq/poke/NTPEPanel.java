package com.tencent.mobileqq.poke;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.data.NTPEItemData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stickerbubble.StickerBubbleListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 <2\u00020\u0001:\u0002=>B%\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u00a2\u0006\u0004\b8\u00109B/\b\u0016\u0012\u0006\u0010:\u001a\u00020/\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u00a2\u0006\u0004\b8\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0018\u00010\u0016R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/poke/NTPEPanel;", "Landroid/widget/FrameLayout;", "", "d", "", "e", "", "placeInfo", "i", "g", "viewVisible", "setListViewVisible", "Lcom/tencent/widget/ListView;", "Lcom/tencent/widget/ListView;", "listView", "Lcom/tencent/mobileqq/poke/d;", "Lcom/tencent/mobileqq/poke/d;", "adapter", "Lcom/airbnb/lottie/LottieAnimationView;", "f", "Lcom/airbnb/lottie/LottieAnimationView;", "mPEAnimImg", "Lcom/tencent/mobileqq/poke/NTPEPanel$b;", tl.h.F, "Lcom/tencent/mobileqq/poke/NTPEPanel$b;", "mAnimListener", "Ljava/lang/String;", "mLottieJsonPath", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsLottieJsonLoaded", "", BdhLogUtil.LogTag.Tag_Conn, "J", "listviewDelayTime", "Lmqq/os/MqqHandler;", "D", "Lmqq/os/MqqHandler;", "mUIHandler", "E", "I", "mPanelHeight", "Lmqq/app/AppRuntime;", UserInfo.SEX_FEMALE, "Lmqq/app/AppRuntime;", "mApp", "Lcom/tencent/aio/api/runtime/a;", "G", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aioContext", "(Lcom/tencent/aio/api/runtime/a;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "b", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NTPEPanel extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long listviewDelayTime;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MqqHandler mUIHandler;

    /* renamed from: E, reason: from kotlin metadata */
    private int mPanelHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private AppRuntime mApp;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ListView listView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView mPEAnimImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mAnimListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mLottieJsonPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLottieJsonLoaded;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/poke/NTPEPanel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.poke.NTPEPanel$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/poke/NTPEPanel$b;", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "Landroid/animation/Animator;", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "<init>", "(Lcom/tencent/mobileqq/poke/NTPEPanel;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b extends com.tencent.mobileqq.widget.f implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPEPanel.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[1];
                ListView listView = NTPEPanel.this.listView;
                if (listView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    listView = null;
                }
                objArr[0] = Integer.valueOf(listView.getVisibility());
                String format = String.format(" playLottieAnim onAnimationEnd listView.visibility = %d ", Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d("PokeEmo.PEPanel", 2, format);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                NTPEPanel.this.setListViewVisible(8);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25921);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPEPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    private final int d() {
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar = null;
        }
        h.b bVar = (h.b) aVar.e().k(PanelContainerMsgIntent.GetPanelHeightParamMsgIntent.f116806d);
        if (bVar != null) {
            return bVar.a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(NTPEPanel this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what != 0) {
            return false;
        }
        ListView listView = this$0.listView;
        ListView listView2 = null;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        listView.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this$0.mPanelHeight, 0.0f);
        translateAnimation.setDuration(200L);
        ListView listView3 = this$0.listView;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            listView2 = listView3;
        }
        listView2.startAnimation(translateAnimation);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(NTPEPanel this$0, LottieAnimationView lottieAnimationView, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (lottieComposition == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PokeEmo.PEPanel", 2, "composition is null ,return");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(" playLottieAnim onCompositionLoaded done ", Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d("PokeEmo.PEPanel", 2, format);
        }
        this$0.listviewDelayTime = (lottieComposition.getDuration() * 6) / 10;
        lottieAnimationView.setComposition(lottieComposition);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
        lottieAnimationView.addAnimatorListener(this$0.mAnimListener);
        lottieAnimationView.addAnimatorUpdateListener(this$0.mAnimListener);
        c cVar = c.f258994a;
        if (!cVar.e()) {
            lottieAnimationView.playAnimation();
            cVar.m(true);
            MqqHandler mqqHandler = this$0.mUIHandler;
            Intrinsics.checkNotNull(mqqHandler);
            mqqHandler.sendEmptyMessageDelayed(0, this$0.listviewDelayTime);
            return;
        }
        lottieAnimationView.setMinAndMaxProgress(1.0f, 1.0f);
        this$0.setListViewVisible(0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        this.mApp = peekAppRuntime;
        this.mPanelHeight = d();
        LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
        int i3 = this.mPanelHeight;
        com.tencent.mobileqq.poke.utils.a aVar = com.tencent.mobileqq.poke.utils.a.f259088a;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3 - aVar.a(40.0f, resources));
        this.mPEAnimImg = lottieAnimationView;
        addView(lottieAnimationView, layoutParams);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
        View view = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar2 = null;
        }
        this.listView = new StickerBubbleListView(context, aVar2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        layoutParams2.topMargin = aVar.a(30.0f, resources2);
        ListView listView = this.listView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        listView.setLayoutParams(layoutParams2);
        ListView listView2 = this.listView;
        if (listView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView2 = null;
        }
        listView2.setPadding(0, 0, 0, 0);
        ListView listView3 = this.listView;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView3 = null;
        }
        listView3.setDivider(null);
        ListView listView4 = this.listView;
        if (listView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView4 = null;
        }
        listView4.setScrollbarFadingEnabled(true);
        ListView listView5 = this.listView;
        if (listView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView5 = null;
        }
        listView5.setVerticalFadingEdgeEnabled(true);
        ListView listView6 = this.listView;
        if (listView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView6 = null;
        }
        listView6.setSelector(new ColorDrawable(0));
        ListView listView7 = this.listView;
        if (listView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView7 = null;
        }
        listView7.setVisibility(8);
        View view2 = this.listView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            view = view2;
        }
        addView(view, layoutParams2);
        this.mAnimListener = new b();
        this.mLottieJsonPath = c.f258994a.i() + "aio_panel_pe_ani.json";
        this.mUIHandler = new MqqHandler(Looper.myLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.poke.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean f16;
                f16 = NTPEPanel.f(NTPEPanel.this, message);
                return f16;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        int i3;
        AppRuntime appRuntime;
        AppRuntime appRuntime2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String str = this.mLottieJsonPath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLottieJsonPath");
            str = null;
        }
        final LottieAnimationView lottieAnimationView = this.mPEAnimImg;
        int i16 = 2;
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNull(lottieAnimationView);
            String format = String.format(" playLottieAnim isAlreadyAnimating = %b,mIsLottieJsonLoaded = %b", Arrays.copyOf(new Object[]{Boolean.valueOf(lottieAnimationView.isAnimating()), Boolean.valueOf(this.mIsLottieJsonLoaded)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d("PokeEmo.PEPanel", 2, format);
        }
        Intrinsics.checkNotNull(lottieAnimationView);
        if (lottieAnimationView.isAnimating()) {
            return;
        }
        if (!this.mIsLottieJsonLoaded) {
            try {
                LottieComposition.Factory.fromInputStream(new FileInputStream(str), new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.poke.a
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        NTPEPanel.h(NTPEPanel.this, lottieAnimationView, lottieComposition);
                    }
                });
                this.mIsLottieJsonLoaded = true;
            } catch (Exception e16) {
                ListView listView = this.listView;
                if (listView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    listView = null;
                }
                listView.setVisibility(0);
                if (QLog.isColorLevel()) {
                    QLog.d("PokeEmo.PEPanel", 2, "load lottie exception ,msg = " + e16.getMessage());
                }
            }
        }
        AppRuntime appRuntime3 = this.mApp;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appRuntime3 = null;
        }
        int g16 = f.g(appRuntime3, 4);
        AppRuntime appRuntime4 = this.mApp;
        if (appRuntime4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appRuntime4 = null;
        }
        int g17 = f.g(appRuntime4, 1);
        if (g16 != 1 || g17 <= 0) {
            if (g16 != 0 || g17 <= 0) {
                if (g16 == 1 && g17 == 0) {
                    i16 = 3;
                } else if (g16 == 0 && g17 == 0) {
                    i3 = 4;
                    appRuntime = this.mApp;
                    if (appRuntime == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mApp");
                        appRuntime2 = null;
                    } else {
                        appRuntime2 = appRuntime;
                    }
                    ReportController.o(appRuntime2, "dc00898", "", "", "0X8009221", "0X8009221", i3, 0, "", "", "", "");
                }
            }
            i3 = i16;
            appRuntime = this.mApp;
            if (appRuntime == null) {
            }
            ReportController.o(appRuntime2, "dc00898", "", "", "0X8009221", "0X8009221", i3, 0, "", "", "", "");
        }
        i3 = 1;
        appRuntime = this.mApp;
        if (appRuntime == null) {
        }
        ReportController.o(appRuntime2, "dc00898", "", "", "0X8009221", "0X8009221", i3, 0, "", "", "", "");
    }

    public final void i(@Nullable String placeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) placeInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(" reload..reload = %s", Arrays.copyOf(new Object[]{placeInfo}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d("PokeEmo.PEPanel", 2, format);
        }
        List<NTPEItemData> h16 = c.f258994a.h(placeInfo);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.adapter = new d(context, this.mPanelHeight);
        ListView listView = this.listView;
        ListView listView2 = null;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        listView.setAdapter((ListAdapter) this.adapter);
        d dVar = this.adapter;
        Intrinsics.checkNotNull(dVar);
        dVar.b(h16);
        ListView listView3 = this.listView;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            listView2 = listView3;
        }
        listView2.setSelection(0);
    }

    public final void setListViewVisible(int viewVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, viewVisible);
            return;
        }
        ListView listView = this.listView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        listView.setVisibility(viewVisible);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NTPEPanel(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mAioContext = aioContext;
        } else {
            iPatchRedirector.redirect((short) 3, this, aioContext, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
