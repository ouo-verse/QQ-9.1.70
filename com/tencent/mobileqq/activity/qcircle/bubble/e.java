package com.tencent.mobileqq.activity.qcircle.bubble;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleInfo;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleAvatarListView;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 C2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\u0002*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0012\u0010\u0011\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0002JQ\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00142%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016H\u0007J \u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH&J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0007J\b\u0010$\u001a\u00020\u0002H&J\b\u0010%\u001a\u00020\u001bH&R\u0016\u0010(\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010+R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00107R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010<R\u0011\u0010@\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/e;", "", "", tl.h.F, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/qcircle/bubble/k;", "bubbleInfo", "Landroid/view/View;", "g", "Landroid/widget/FrameLayout;", "", "Lcom/tencent/mobileqq/activity/qcircle/bubble/k$b;", "iconInfoList", "f", "Lcom/tencent/mobileqq/activity/qcircle/bubble/g;", "Landroid/text/SpannableStringBuilder;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/app/FrameFragment;", "frameFragment", "Lkotlin/Function0;", "onDismissListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "onClickListener", "", "p", "parentView", "qCircleTabIconView", "bubbleView", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/activity/qcircle/bubble/RedPointDismissSource;", "source", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "a", "Z", "_bubbleClicked", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "frameFragmentRef", "Lcom/tencent/mobileqq/tab/b;", "c", "qqTabWidgetRef", "Lcom/tencent/mobileqq/app/QQAppInterface;", "d", "appRef", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "delayRunnable", "Lkotlin/jvm/functions/Function0;", "Lcom/tencent/mobileqq/logic/a;", "Lcom/tencent/mobileqq/logic/a;", "tabDataObserver", "Lcom/tencent/mobileqq/tab/e;", "Lcom/tencent/mobileqq/tab/e;", "qqTabWidgetTranslateYUpdateListener", "k", "()Z", "bubbleClicked", "<init>", "()V", "i", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean _bubbleClicked;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<FrameFragment> frameFragmentRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<com.tencent.mobileqq.tab.b> qqTabWidgetRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<QQAppInterface> appRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onDismissListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable delayRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.a
        @Override // java.lang.Runnable
        public final void run() {
            e.i(e.this);
        }
    };

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.logic.a tabDataObserver = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.tab.e qqTabWidgetTranslateYUpdateListener = new com.tencent.mobileqq.tab.e() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.b
        @Override // com.tencent.mobileqq.tab.e
        public final void a(float f16) {
            e.o(e.this, f16);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/activity/qcircle/bubble/e$b", "Lcom/tencent/mobileqq/logic/a;", "", "type", "", "isSuccess", "", "data", "", "onReceive", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends com.tencent.mobileqq.logic.a {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.logic.a
        public void onReceive(int type, boolean isSuccess, @Nullable Object data) {
            Object obj;
            FrameFragment frameFragment;
            QLog.i("QCircleTabRedPoint.BubbleImplStrategy", 1, "tabDataObserver, onReceive\uff0c type=" + type + ", isSuccess=" + isSuccess);
            if (isSuccess) {
                WeakReference weakReference = e.this.frameFragmentRef;
                QCircleFrame qCircleFrame = null;
                if (weakReference != null && (frameFragment = (FrameFragment) weakReference.get()) != null) {
                    obj = frameFragment.getFrame(QCircleFrame.class);
                } else {
                    obj = null;
                }
                if (obj instanceof QCircleFrame) {
                    qCircleFrame = (QCircleFrame) obj;
                }
                if (qCircleFrame == null) {
                    QLog.i("QCircleTabRedPoint.BubbleImplStrategy", 1, "tabDataChange, tab dismiss");
                    e.this.j(RedPointDismissSource.TAB_DISMISS);
                }
            }
        }
    }

    private final void f(FrameLayout frameLayout, List<QCircleTabRedPointBubbleInfo.IconInfo> list) {
        for (QCircleTabRedPointBubbleInfo.IconInfo iconInfo : list) {
            SquareImageView squareImageView = new SquareImageView(frameLayout.getContext());
            squareImageView.setRoundRect(LayoutAttrsKt.getDp(4));
            squareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            squareImageView.setImageDrawable(iconInfo.getDrawable());
            squareImageView.setAlpha(iconInfo.getAlpha());
            frameLayout.addView(squareImageView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private final View g(Context context, QCircleTabRedPointBubbleInfo bubbleInfo) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.g3n, (ViewGroup) null);
        inflate.findViewById(R.id.f97655kz).setBackgroundResource(R.drawable.nb7);
        TextView textView = (TextView) inflate.findViewById(R.id.f55562i9);
        textView.setTextColor(-1);
        textView.setText(s(bubbleInfo.a()));
        if (bubbleInfo.getIconType() == IconType.PICTURE && (!bubbleInfo.c().isEmpty())) {
            View findViewById = inflate.findViewById(R.id.f34020y1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<QCircleAvat\u2026ew>(R.id.qfs_avatar_list)");
            findViewById.setVisibility(8);
            FrameLayout buildBubbleView$lambda$7$lambda$5 = (FrameLayout) inflate.findViewById(R.id.fn6);
            Intrinsics.checkNotNullExpressionValue(buildBubbleView$lambda$7$lambda$5, "buildBubbleView$lambda$7$lambda$5");
            buildBubbleView$lambda$7$lambda$5.setVisibility(0);
            f(buildBubbleView$lambda$7$lambda$5, bubbleInfo.c());
        } else if (bubbleInfo.getIconType() == IconType.AVATAR && (!bubbleInfo.e().isEmpty())) {
            View findViewById2 = inflate.findViewById(R.id.f34020y1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<QCircleAvat\u2026ew>(R.id.qfs_avatar_list)");
            findViewById2.setVisibility(0);
            QCircleAvatarListView qCircleAvatarListView = (QCircleAvatarListView) inflate.findViewById(R.id.f34020y1);
            qCircleAvatarListView.setBackgroundRes(R.color.cak);
            qCircleAvatarListView.setData(bubbleInfo.e());
        } else {
            View findViewById3 = inflate.findViewById(R.id.f34020y1);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<QCircleAvat\u2026ew>(R.id.qfs_avatar_list)");
            findViewById3.setVisibility(8);
        }
        inflate.measure(0, 0);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n        .i\u2026ec.UNSPECIFIED)\n        }");
        return inflate;
    }

    private final void h() {
        Long bubbleDelayDismissTimeMills = uq3.c.Z0("qqcircle", "qcircle_bottom_bubble_view_duration", 5000L);
        QLog.i("QCircleTabRedPoint.BubbleImplStrategy", 1, "delayDismiss, bubbleDelayDismissTimeMills=" + bubbleDelayDismissTimeMills);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = this.delayRunnable;
        Intrinsics.checkNotNullExpressionValue(bubbleDelayDismissTimeMills, "bubbleDelayDismissTimeMills");
        uIHandlerV2.postDelayed(runnable, bubbleDelayDismissTimeMills.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j(RedPointDismissSource.TIME_OUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(e this$0, float f16) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<com.tencent.mobileqq.tab.b> weakReference = this$0.qqTabWidgetRef;
        if (weakReference != null && (obj = (com.tencent.mobileqq.tab.b) weakReference.get()) != null && f16 >= ((View) obj).getHeight()) {
            this$0.j(RedPointDismissSource.TAB_ANIMATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(e this$0, Function1 function1, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._bubbleClicked = true;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function1.invoke(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(e this$0, Function1 function1, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._bubbleClicked = true;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function1.invoke(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final SpannableStringBuilder s(List<QCircleTabRedPointBubbleContentElement> list) {
        String replace$default;
        boolean z16;
        int i3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (QCircleTabRedPointBubbleContentElement qCircleTabRedPointBubbleContentElement : list) {
            replace$default = StringsKt__StringsJVMKt.replace$default(qCircleTabRedPointBubbleContentElement.getText(), RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
            SpannableString spannableString = new SpannableString(replace$default);
            if (qCircleTabRedPointBubbleContentElement.getTextColor().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = Color.parseColor(qCircleTabRedPointBubbleContentElement.getTextColor());
            } else {
                i3 = -1;
            }
            spannableString.setSpan(new ForegroundColorSpan(i3), 0, spannableString.length(), 33);
            spannableString.setSpan(new StyleSpan(qCircleTabRedPointBubbleContentElement.getBold() ? 1 : 0), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        return spannableStringBuilder;
    }

    @UiThread
    public final void j(@NotNull RedPointDismissSource source) {
        com.tencent.mobileqq.tab.b bVar;
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(source, "source");
        if (l()) {
            QLog.i("QCircleTabRedPoint.BubbleImplStrategy", 1, "final dismiss, source=" + source.getSourceType());
            m();
            Function0<Unit> function0 = this.onDismissListener;
            if (function0 != null) {
                function0.invoke();
            }
            com.tencent.biz.pubaccount.util.c.b();
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.delayRunnable);
            WeakReference<QQAppInterface> weakReference = this.appRef;
            if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
                qQAppInterface.removeObserver(this.tabDataObserver);
            }
            WeakReference<com.tencent.mobileqq.tab.b> weakReference2 = this.qqTabWidgetRef;
            if (weakReference2 != null && (bVar = weakReference2.get()) != null) {
                bVar.b(this.qqTabWidgetTranslateYUpdateListener);
            }
            this.appRef = null;
            this.qqTabWidgetRef = null;
            this.onDismissListener = null;
            this.frameFragmentRef = null;
            this._bubbleClicked = false;
        }
    }

    /* renamed from: k, reason: from getter */
    public final boolean get_bubbleClicked() {
        return this._bubbleClicked;
    }

    public abstract boolean l();

    public abstract void m();

    public abstract void n(@NotNull View parentView, @NotNull View qCircleTabIconView, @NotNull View bubbleView);

    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public final boolean p(@NotNull FrameFragment frameFragment, @NotNull QCircleTabRedPointBubbleInfo bubbleInfo, @Nullable Function0<Unit> onDismissListener, @Nullable final Function1<? super View, Unit> onClickListener) {
        View view;
        Intrinsics.checkNotNullParameter(frameFragment, "frameFragment");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        FragmentActivity activity = frameFragment.getActivity();
        if (activity != null && !activity.isFinishing()) {
            View findViewById = activity.findViewById(af.f());
            if (findViewById.getTranslationY() >= findViewById.getHeight()) {
                QLog.e("QCircleTabRedPoint.BubbleImplStrategy", 1, "showBubble failed, qqWidgetView is play anime, translationY=" + findViewById.getTranslationY());
                return false;
            }
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.tab.ITranslateYMgr");
            com.tencent.mobileqq.tab.b bVar = (com.tencent.mobileqq.tab.b) findViewById;
            bVar.a(this.qqTabWidgetTranslateYUpdateListener);
            this.qqTabWidgetRef = new WeakReference<>(bVar);
            TabViewMap tabViewMap = frameFragment.mTabViewMap;
            QQAppInterface qQAppInterface = null;
            if (tabViewMap != null) {
                view = tabViewMap.get(TabDataHelper.TAB_NEW_WORLD);
            } else {
                view = null;
            }
            if (view == null) {
                QLog.e("QCircleTabRedPoint.BubbleImplStrategy", 1, "showBubble failed, qCircleTab == null");
                return false;
            }
            View findViewById2 = view.findViewById(R.id.j_k);
            if (findViewById2 == null) {
                QLog.e("QCircleTabRedPoint.BubbleImplStrategy", 1, "showBubble failed, qCircleTabIconView == null");
                return false;
            }
            if (l()) {
                QLog.e("QCircleTabRedPoint.BubbleImplStrategy", 1, "showBubble failed, isShowing");
                return false;
            }
            QLog.i("QCircleTabRedPoint.BubbleImplStrategy", 1, "final showBubble");
            View g16 = g(activity, bubbleInfo);
            g16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.q(e.this, onClickListener, view2);
                }
            });
            ((TextView) g16.findViewById(R.id.f55562i9)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.r(e.this, onClickListener, view2);
                }
            });
            View contentFrame = activity.findViewById(R.id.b9o);
            AppRuntime appRuntime = frameFragment.app;
            if (appRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) appRuntime;
            }
            WeakReference<QQAppInterface> weakReference = new WeakReference<>(qQAppInterface);
            this.appRef = weakReference;
            QQAppInterface qQAppInterface2 = weakReference.get();
            if (qQAppInterface2 != null) {
                qQAppInterface2.addObserver(this.tabDataObserver);
            }
            this.frameFragmentRef = new WeakReference<>(frameFragment);
            this.onDismissListener = onDismissListener;
            com.tencent.biz.pubaccount.util.c.a();
            AbstractGifImage.resumeAll();
            Intrinsics.checkNotNullExpressionValue(contentFrame, "contentFrame");
            n(contentFrame, findViewById2, g16);
            h();
            return true;
        }
        QLog.e("QCircleTabRedPoint.BubbleImplStrategy", 1, "showBubble failed, currentActivity state error");
        return false;
    }
}
