package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002+,B\u0013\b\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b!\u0010\"B\u001d\b\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%B%\b\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b!\u0010(B%\b\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010)\u001a\u00020\t\u00a2\u0006\u0004\b!\u0010*J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001e\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/chats/view/RefreshView;", "Landroid/widget/ImageView;", "Lcom/tencent/qqnt/chats/view/RefreshView$b;", "listener", "", "d", "", WadlProxyConsts.PARAM_FILENAME, "e", "", "isNight", "i", "j", "k", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "speed", "setSpeed", "Lcom/airbnb/lottie/LottieDrawable;", "Lcom/airbnb/lottie/LottieDrawable;", "mEllipsisDrawable", "Ljava/lang/String;", "mDirName", "f", "mJsonName", tl.h.F, "mNightJsonName", "c", "()F", IOnlineStatusService.REMAIN_TIME, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nightMode", "(Landroid/content/Context;Lcom/tencent/qqnt/chats/view/RefreshView$b;Z)V", "a", "b", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RefreshView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mEllipsisDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mDirName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mJsonName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mNightJsonName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/view/RefreshView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.view.RefreshView$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/view/RefreshView$b;", "", "", "a", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        void a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RefreshView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mDirName = "refresh_lottie/";
        this.mJsonName = "refresh.json";
        this.mNightJsonName = "refresh_night.json";
        f(this, null, 1, null);
    }

    public static /* synthetic */ void f(RefreshView refreshView, b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bVar = null;
        }
        refreshView.d(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final RefreshView this$0, b bVar, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (lottieComposition == null) {
            QLog.e("RefreshView", 1, "onCompositionLoaded lottieComposition is null");
            return;
        }
        final LottieDrawable lottieDrawable = new LottieDrawable();
        lottieDrawable.setComposition(lottieComposition);
        lottieDrawable.loop(true);
        this$0.mEllipsisDrawable = lottieDrawable;
        if (bVar != null) {
            bVar.a();
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.chats.view.h
            @Override // java.lang.Runnable
            public final void run() {
                RefreshView.h(RefreshView.this, lottieDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RefreshView this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lottieDrawable, "$lottieDrawable");
        this$0.setImageDrawable(lottieDrawable);
        this$0.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public final float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable == null) {
            return 0.0f;
        }
        return (0.5f - lottieDrawable.getProgress()) / lottieDrawable.getSpeed();
    }

    protected final void d(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
            return;
        }
        e(this.mDirName + this.mJsonName, listener);
    }

    protected final void e(@Nullable String fileName, @Nullable final b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fileName, (Object) listener);
            return;
        }
        try {
            LottieComposition.Factory.fromAssetFileName(getContext(), fileName, new OnCompositionLoadedListener(listener) { // from class: com.tencent.qqnt.chats.view.g
                @Override // com.airbnb.lottie.OnCompositionLoadedListener
                public final void onCompositionLoaded(LottieComposition lottieComposition) {
                    RefreshView.g(RefreshView.this, null, lottieComposition);
                }
            });
        } catch (Exception e16) {
            QLog.e("RefreshView", 1, "loadEllipsisAnimation fail.", e16);
        }
    }

    public final void i(boolean isNight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isNight);
            return;
        }
        if (isNight) {
            e(this.mDirName + this.mNightJsonName, null);
            return;
        }
        e(this.mDirName + this.mJsonName, null);
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable == null) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PortalFragment", 4, "startLoadingAnim, mEllipsisDrawable : " + lottieDrawable);
        }
        lottieDrawable.resumeAnimation();
        return false;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable == null) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("stopLoadingAnim", 4, "stopLoadingAnim, mEllipsisDrawable : " + lottieDrawable);
        }
        lottieDrawable.endAnimation();
        return true;
    }

    public final void setProgress(float progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(progress));
            return;
        }
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.setProgress(progress);
        }
    }

    public final void setSpeed(float speed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(speed));
            return;
        }
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.setSpeed(speed);
        }
    }

    public RefreshView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mDirName = "refresh_lottie/";
        this.mJsonName = "refresh.json";
        this.mNightJsonName = "refresh_night.json";
        f(this, null, 1, null);
    }

    public RefreshView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mDirName = "refresh_lottie/";
        this.mJsonName = "refresh.json";
        this.mNightJsonName = "refresh_night.json";
        f(this, null, 1, null);
    }

    public RefreshView(@Nullable Context context, @Nullable b bVar, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, bVar, Boolean.valueOf(z16));
            return;
        }
        this.mDirName = "refresh_lottie/";
        this.mJsonName = "refresh.json";
        this.mNightJsonName = "refresh_night.json";
        if (z16) {
            e("refresh_lottie/refresh_night.json", bVar);
            return;
        }
        e("refresh_lottie/refresh.json", bVar);
    }
}
