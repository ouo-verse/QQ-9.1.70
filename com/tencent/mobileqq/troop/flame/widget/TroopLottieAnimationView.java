package com.tencent.mobileqq.troop.flame.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/widget/TroopLottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "", "path", "url", "", "setAnimationFromPath", "playAndDownLoadAnimFromUrl", "getLottieCacheKey", "setAnimationFromUrl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopLottieAnimationView extends LottieAnimationView {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopLottieAnimationView";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/widget/TroopLottieAnimationView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.widget.TroopLottieAnimationView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopLottieAnimationView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
    }

    private final String getLottieCacheKey(String path) {
        return "path-" + path.hashCode();
    }

    private final void playAndDownLoadAnimFromUrl(final String url) {
        super.setAnimationFromUrl(url, getLottieCacheKey(url));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.flame.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopLottieAnimationView.playAndDownLoadAnimFromUrl$lambda$1(url);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playAndDownLoadAnimFromUrl$lambda$1(String url) {
        Intrinsics.checkNotNullParameter(url, "$url");
        TroopFlameLottieDownLoader.f296150a.c(url);
    }

    private final void setAnimationFromPath(String path, String url) {
        try {
            LottieCompositionFactory.fromJsonInputStream(new FileInputStream(new File(path)), getLottieCacheKey(path)).addListener(new LottieListener() { // from class: com.tencent.mobileqq.troop.flame.widget.b
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    TroopLottieAnimationView.setAnimationFromPath$lambda$0(TroopLottieAnimationView.this, (LottieComposition) obj);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[setAnimationFromPath] file not found, path:" + path, th5);
            playAndDownLoadAnimFromUrl(url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAnimationFromPath$lambda$0(TroopLottieAnimationView this$0, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (lottieComposition == null) {
            QLog.e(TAG, 1, "[setAnimationFromPath] composition is null");
        } else {
            this$0.setComposition(lottieComposition);
            this$0.playAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.airbnb.lottie.LottieAnimationView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setAnimationFromUrl(@Nullable String url) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
            return;
        }
        if (url != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(url);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    return;
                }
                String e16 = TroopFlameLottieDownLoader.f296150a.e(url);
                QLog.i(TAG, 1, "[setAnimationFromUrl] url = " + url + ", filePath = " + e16);
                isBlank = StringsKt__StringsJVMKt.isBlank(e16);
                if (true ^ isBlank) {
                    setAnimationFromPath(e16, url);
                    return;
                } else {
                    playAndDownLoadAnimFromUrl(url);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopLottieAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopLottieAnimationView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopLottieAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }
}
