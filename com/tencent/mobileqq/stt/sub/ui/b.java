package com.tencent.mobileqq.stt.sub.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020\u000f\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u001a\u0010!\u001a\u00020\u001c8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/stt/sub/ui/b;", "Landroid/widget/PopupWindow;", "", "b", "d", "", "delayTime", "c", "dismiss", "Landroid/view/View;", "view", "", "text", "displayTime", "f", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "", UserInfo.SEX_FEMALE, "mDensity", "Landroid/os/Handler;", "Landroid/os/Handler;", "mMainHandler", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "mWeakThis", "", "e", "I", "getMarginWithView", "()I", "marginWithView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTextView", "Lcom/tencent/mobileqq/stt/sub/ui/GuideBalloonArrow;", "g", "Lcom/tencent/mobileqq/stt/sub/ui/GuideBalloonArrow;", "mArrowView", h.F, "Landroid/view/View;", "mTextContainer", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "runnableDismiss", "context", "<init>", "(Landroid/content/Context;)V", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends PopupWindow {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float mDensity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mMainHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<b> mWeakThis;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int marginWithView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mTextView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuideBalloonArrow mArrowView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mTextContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable runnableDismiss;

    public b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContext = context;
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mWeakThis = new WeakReference<>(this);
        this.marginWithView = 2;
        setContentView(LayoutInflater.from(context).inflate(R.layout.fe7, (ViewGroup) null));
        View findViewById = getContentView().findViewById(R.id.jfb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.text)");
        this.mTextView = (TextView) findViewById;
        View findViewById2 = getContentView().findViewById(R.id.f164472yw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.arrow)");
        this.mArrowView = (GuideBalloonArrow) findViewById2;
        View findViewById3 = getContentView().findViewById(R.id.f95195eb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.text_container)");
        this.mTextContainer = findViewById3;
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setTouchable(true);
        setFocusable(true);
        b();
        this.runnableDismiss = new Runnable() { // from class: com.tencent.mobileqq.stt.sub.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(b.this);
            }
        };
    }

    private final void b() {
        if (QQTheme.isNowThemeIsNight()) {
            this.mTextContainer.setBackgroundResource(R.drawable.ll_);
            this.mArrowView.setColor(Color.parseColor("#040A19"));
            this.mArrowView.setStroke(Color.parseColor("#282A2F"), 1.0f);
        }
    }

    private final void c(long delayTime) {
        if (delayTime > 0) {
            this.mMainHandler.postDelayed(this.runnableDismiss, delayTime);
        }
    }

    private final void d() {
        if (isShowing()) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.mWeakThis.get();
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mMainHandler.removeCallbacks(this.runnableDismiss);
        if (this.mTextContainer.isAttachedToWindow()) {
            super.dismiss();
        }
    }

    public final void f(@NotNull View view, @NotNull String text, long displayTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, text, Long.valueOf(displayTime));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(text, "text");
        if (isShowing()) {
            return;
        }
        this.mTextView.setText(text);
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(10000, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(10000, Integer.MIN_VALUE));
        showAsDropDown(view, (view.getWidth() - getContentView().getMeasuredWidth()) / 2, -(view.getHeight() + getContentView().getMeasuredHeight() + ((int) (this.marginWithView * this.mDensity))));
        c(displayTime);
    }
}
