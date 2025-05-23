package com.tencent.mobileqq.matchfriend.reborn.content.main.matching;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010/R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/t;", "", "", "sourceId", "", "g", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "", "zipUrl", "l", "k", "j", "f", "", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View$OnClickListener;", "onCancel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Landroid/content/Context;", "context", tl.h.F, "Landroid/view/View;", "a", "Landroid/view/View;", "loadingView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "loadingRootView", "c", "loadingTextureView", "Lcom/airbnb/lottie/LottieAnimationView;", "loadingAnimFg", "e", "loadingAnimBg", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "loadingTextView", "Z", "isLoadingState", "I", AdMetricTag.Report.TYPE, "Lcom/tencent/mobileqq/matchfriend/utils/d;", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "reportHelper", "hasReportPageOut", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View loadingView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingRootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingTextureView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView loadingAnimFg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView loadingAnimBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView loadingTextView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int reportType = 1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.matchfriend.utils.d reportHelper;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportPageOut;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Activity activity, t this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Window window = activity.getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup != null) {
                viewGroup.removeView(this$0.loadingView);
            }
            this$0.isLoadingState = false;
        } catch (Throwable th5) {
            QLog.e("QQStrangerFullScreenLoading", 1, th5, new Object[0]);
        }
    }

    private final int f(int sourceId) {
        if (sourceId == 2) {
            return 2;
        }
        return 1;
    }

    private final void j() {
        if (this.hasReportPageOut) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("loading_type", Integer.valueOf(this.reportType));
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.reportHelper;
        if (dVar != null) {
            dVar.j(hashMap);
        }
        this.hasReportPageOut = true;
    }

    private final void k(int sourceId) {
        this.reportType = f(sourceId);
        HashMap hashMap = new HashMap();
        hashMap.put("loading_type", Integer.valueOf(this.reportType));
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.reportHelper;
        if (dVar != null) {
            dVar.i(hashMap);
        }
        this.hasReportPageOut = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(t this$0, Activity activity, int i3, View.OnClickListener onCancel) {
        View findViewById;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onCancel, "$onCancel");
        View inflate = LayoutInflater.from(activity).inflate(R.layout.cxl, (ViewGroup) null);
        this$0.loadingView = inflate;
        if (inflate != null) {
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.o(view);
                }
            });
        }
        View view = this$0.loadingView;
        this$0.loadingRootView = view != null ? (ImageView) view.findViewById(R.id.onn) : null;
        View view2 = this$0.loadingView;
        this$0.loadingTextureView = view2 != null ? (ImageView) view2.findViewById(R.id.ook) : null;
        View view3 = this$0.loadingView;
        this$0.loadingAnimFg = view3 != null ? (LottieAnimationView) view3.findViewById(R.id.ooe) : null;
        View view4 = this$0.loadingView;
        this$0.loadingAnimBg = view4 != null ? (LottieAnimationView) view4.findViewById(R.id.ood) : null;
        View view5 = this$0.loadingView;
        this$0.loadingTextView = view5 != null ? (TextView) view5.findViewById(R.id.ooj) : null;
        this$0.g(i3);
        View view6 = this$0.loadingView;
        if (view6 != null && (findViewById = view6.findViewById(R.id.oof)) != null) {
            findViewById.setOnClickListener(onCancel);
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            viewGroup.addView(this$0.loadingView);
        }
        this$0.isLoadingState = true;
    }

    public final void h(Context context, int sourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportHelper = new com.tencent.mobileqq.matchfriend.utils.d(context);
        this.reportType = f(sourceId);
        HashMap hashMap = new HashMap();
        hashMap.put("loading_type", Integer.valueOf(this.reportType));
        com.tencent.mobileqq.matchfriend.utils.d dVar = this.reportHelper;
        if (dVar != null) {
            dVar.c("pg_kl_match_loading", hashMap);
        }
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsLoadingState() {
        return this.isLoadingState;
    }

    public final void m(final Activity activity, final int sourceId, final View.OnClickListener onCancel) {
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.r
                @Override // java.lang.Runnable
                public final void run() {
                    t.n(t.this, activity, sourceId, onCancel);
                }
            });
        }
        k(sourceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(View view) {
        QLog.i("QQStrangerFullScreenLoading", 1, "unused click, loading...");
    }

    public final void d(final Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.q
                @Override // java.lang.Runnable
                public final void run() {
                    t.e(activity, this);
                }
            });
        }
        j();
    }

    private final void l(LottieAnimationView view, String zipUrl) {
        if (view == null) {
            return;
        }
        new LottieLoader(view.getContext()).fromNetworkWithCacheBitmap(view, zipUrl);
        view.setRepeatCount(-1);
        view.setRepeatMode(1);
        view.setVisibility(0);
    }

    private final void g(int sourceId) {
        if (sourceId == 2) {
            ImageView imageView = this.loadingRootView;
            if (imageView != null) {
                com.tencent.mobileqq.matchfriend.reborn.utils.p.b(imageView, "https://downv6.qq.com/extendfriend/qqstranger_match_voice_loading_bg.png", imageView.getResources().getDrawable(R.drawable.g3p), false, 8, null);
            }
            ImageView imageView2 = this.loadingTextureView;
            if (imageView2 != null) {
                com.tencent.mobileqq.matchfriend.reborn.utils.p.b(imageView2, "https://downv6.qq.com/extendfriend/qqstranger_match_voice_loading_texture.png", new ColorDrawable(0), false, 8, null);
            }
            l(this.loadingAnimBg, "https://downv6.qq.com/extendfriend/qqstranger_match_voice_loading_lottiev1.zip");
            l(this.loadingAnimFg, "https://static-res.qq.com/static-res/qqstranger/match/qqstranger_match_loading_lottie.zip");
            TextView textView = this.loadingTextView;
            if (textView == null) {
                return;
            }
            textView.setText("\u8fde\u9ea6\u4e2d...");
            return;
        }
        if (sourceId != 3) {
            return;
        }
        ImageView imageView3 = this.loadingRootView;
        if (imageView3 != null) {
            com.tencent.mobileqq.matchfriend.reborn.utils.p.b(imageView3, "https://downv6.qq.com/extendfriend/qqstranger_match_chat_loading_bg.png", imageView3.getResources().getDrawable(R.drawable.g2w), false, 8, null);
        }
        ImageView imageView4 = this.loadingTextureView;
        if (imageView4 != null) {
            com.tencent.mobileqq.matchfriend.reborn.utils.p.b(imageView4, "https://downv6.qq.com/extendfriend/qqstranger_match_chat_loading_texture.png", new ColorDrawable(0), false, 8, null);
        }
        l(this.loadingAnimBg, "https://downv6.qq.com/extendfriend/qqstranger_match_chat_loading_lottiev1.zip");
        l(this.loadingAnimFg, "https://static-res.qq.com/static-res/qqstranger/match/qqstranger_match_loading_lottie.zip");
        TextView textView2 = this.loadingTextView;
        if (textView2 == null) {
            return;
        }
        textView2.setText("\u5339\u914d\u4e2d...");
    }
}
