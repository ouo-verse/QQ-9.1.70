package com.tencent.biz.qui.toast;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.biz.qui.toast.QUIClickableCenterToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ud0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0002&\u0014B\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/qui/toast/QUIClickableCenterToast;", "", "Landroid/view/View;", "d", "", "j", "Landroid/graphics/drawable/Drawable;", "leftDrawable", "g", "", IMiniCardBeancurd.SIGN_PLAIN_TEXT, "i", "clickText", "e", "", "durationTime", "f", "Landroid/view/View$OnClickListener;", "onClickListener", h.F, "a", "Landroid/graphics/drawable/Drawable;", "b", "Ljava/lang/String;", "c", "Landroid/view/View$OnClickListener;", "", "I", "offset", "J", "Lcom/tencent/biz/qui/toast/QUIClickableCenterToast$ClickToast;", "Lcom/tencent/biz/qui/toast/QUIClickableCenterToast$ClickToast;", "toast", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "ClickToast", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUIClickableCenterToast {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Drawable leftDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String plainText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String clickText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int offset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long durationTime = 3000;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ClickToast toast;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final ToastManager f95367i = new ToastManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qui/toast/QUIClickableCenterToast$ClickToast;", "Landroid/widget/PopupWindow;", "Lcom/tencent/biz/qui/toast/a;", "", "dismiss", "Lkotlin/Function0;", "dismissCallback", "a", "Landroid/app/Activity;", "getActivity", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "cancelRunnable", "e", "Lkotlin/jvm/functions/Function0;", "finalCallback", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", h.F, "I", "offset", "", "i", "J", "delayTime", "Landroid/view/View;", "contentView", "width", "<init>", "(Landroid/app/Activity;Landroid/view/View;IIJ)V", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class ClickToast extends PopupWindow implements a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Runnable cancelRunnable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Function0<Unit> finalCallback;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final Activity activity;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int offset;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final long delayTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickToast(@Nullable Activity activity, @NotNull View contentView, int i3, int i16, long j3) {
            super(contentView, i3, -2);
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            this.activity = activity;
            this.offset = i16;
            this.delayTime = j3;
            this.cancelRunnable = new Runnable() { // from class: com.tencent.biz.qui.toast.QUIClickableCenterToast$ClickToast$cancelRunnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    QUIClickableCenterToast.ClickToast.this.dismiss();
                }
            };
            this.finalCallback = new Function0<Unit>() { // from class: com.tencent.biz.qui.toast.QUIClickableCenterToast$ClickToast$finalCallback$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }

        @Override // com.tencent.biz.qui.toast.a
        public void a(@NotNull final Function0<Unit> dismissCallback) {
            Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
            this.finalCallback = new Function0<Unit>() { // from class: com.tencent.biz.qui.toast.QUIClickableCenterToast$ClickToast$show$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0.this.invoke();
                }
            };
            Activity activity = this.activity;
            if (activity != null && !activity.isFinishing() && !this.activity.isDestroyed()) {
                setAnimationStyle(R.style.f173934na);
                try {
                    Window window = this.activity.getWindow();
                    Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                    View decorView = window.getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
                    View rootView = decorView.getRootView();
                    int e16 = this.offset + e.e(this.activity);
                    this.offset = e16;
                    showAtLocation(rootView, 17, 0, e16);
                } catch (WindowManager.BadTokenException e17) {
                    d.b("QUIClickableCenterToast", d.f438811e, "show error:" + e17);
                }
                getContentView().postDelayed(this.cancelRunnable, this.delayTime);
                return;
            }
            d.b("QUIClickableCenterToast", d.f438811e, "show error");
            this.finalCallback.invoke();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            super.dismiss();
            this.finalCallback.invoke();
            getContentView().removeCallbacks(this.cancelRunnable);
        }

        @Override // com.tencent.biz.qui.toast.a
        @Nullable
        public Activity getActivity() {
            return this.activity;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J:\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qui/toast/QUIClickableCenterToast$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/drawable/Drawable;", "leftDrawable", "", IMiniCardBeancurd.SIGN_PLAIN_TEXT, "clickText", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/biz/qui/toast/QUIClickableCenterToast;", "a", "", "DELAY_TIME", "J", "TAG", "Ljava/lang/String;", "Lcom/tencent/biz/qui/toast/ToastManager;", "toastManager", "Lcom/tencent/biz/qui/toast/ToastManager;", "<init>", "()V", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.biz.qui.toast.QUIClickableCenterToast$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final QUIClickableCenterToast a(@Nullable Activity activity, @Nullable Drawable leftDrawable, @Nullable String plainText, @Nullable String clickText, @Nullable View.OnClickListener onClickListener) {
            return new QUIClickableCenterToast(activity).g(leftDrawable).i(plainText).e(clickText).h(onClickListener);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View.OnClickListener onClickListener = QUIClickableCenterToast.this.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            ClickToast clickToast = QUIClickableCenterToast.this.toast;
            if (clickToast != null) {
                clickToast.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QUIClickableCenterToast(@Nullable Activity activity) {
        this.activity = activity;
    }

    private final View d() {
        View view = LayoutInflater.from(this.activity).inflate(R.layout.f168948hg1, (ViewGroup) null);
        ImageView leftIv = (ImageView) view.findViewById(R.id.toast_icon);
        Drawable drawable = this.leftDrawable;
        if (drawable != null) {
            leftIv.setImageDrawable(drawable);
            Intrinsics.checkNotNullExpressionValue(leftIv, "leftIv");
            leftIv.setVisibility(0);
        } else {
            Intrinsics.checkNotNullExpressionValue(leftIv, "leftIv");
            leftIv.setVisibility(8);
        }
        View findViewById = view.findViewById(R.id.f110036hf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<TextView>(R.id.tv_plain_text)");
        ((TextView) findViewById).setText(this.plainText);
        TextView clickTextView = (TextView) view.findViewById(R.id.f1068069p);
        if (!TextUtils.isEmpty(this.clickText) && this.onClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(clickTextView, "clickTextView");
            clickTextView.setText(this.clickText);
            clickTextView.setOnClickListener(new b());
            clickTextView.setVisibility(0);
        } else {
            Intrinsics.checkNotNullExpressionValue(clickTextView, "clickTextView");
            clickTextView.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @NotNull
    public final QUIClickableCenterToast e(@Nullable String clickText) {
        this.clickText = clickText;
        return this;
    }

    @NotNull
    public final QUIClickableCenterToast f(long durationTime) {
        this.durationTime = durationTime;
        return this;
    }

    @NotNull
    public final QUIClickableCenterToast g(@Nullable Drawable leftDrawable) {
        this.leftDrawable = leftDrawable;
        return this;
    }

    @NotNull
    public final QUIClickableCenterToast h(@Nullable View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    @NotNull
    public final QUIClickableCenterToast i(@Nullable String plainText) {
        this.plainText = plainText;
        return this;
    }

    public final void j() {
        if (this.activity != null && !TextUtils.isEmpty(this.plainText)) {
            final ClickToast clickToast = new ClickToast(this.activity, d(), -2, this.offset, this.durationTime);
            this.toast = clickToast;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.biz.qui.toast.QUIClickableCenterToast$show$1
                @Override // java.lang.Runnable
                public final void run() {
                    ToastManager toastManager;
                    toastManager = QUIClickableCenterToast.f95367i;
                    toastManager.d(QUIClickableCenterToast.ClickToast.this);
                }
            });
            return;
        }
        d.a("QUIClickableCenterToast", d.f438811e, "toast show error, context: " + this.activity + ", text: " + this.plainText);
    }
}
