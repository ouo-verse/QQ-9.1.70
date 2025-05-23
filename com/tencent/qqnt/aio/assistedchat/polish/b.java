package com.tencent.qqnt.aio.assistedchat.polish;

import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.Build;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/b;", "", "", "c", "b", "Lcom/airbnb/lottie/LottieDrawable;", "lottieDrawable", "", "tintColor", "", "d", "a", "Z", "enableAIOBlur", "<init>", "(Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enableAIOBlur;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/b$a;", "", "", "LOTTIE_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.polish.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.enableAIOBlur = z16;
        }
    }

    private final boolean c() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 31 && i3 != 32 && i3 != 33) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter e(int i3, LottieFrameInfo lottieFrameInfo) {
        return new LightingColorFilter(0, i3);
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.enableAIOBlur && c()) {
            return false;
        }
        return true;
    }

    public final void d(@NotNull LottieDrawable lottieDrawable, final int tintColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) lottieDrawable, tintColor);
            return;
        }
        Intrinsics.checkNotNullParameter(lottieDrawable, "lottieDrawable");
        SimpleLottieValueCallback simpleLottieValueCallback = new SimpleLottieValueCallback() { // from class: com.tencent.qqnt.aio.assistedchat.polish.a
            @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
            public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                ColorFilter e16;
                e16 = b.e(tintColor, lottieFrameInfo);
                return e16;
            }
        };
        KeyPath keyPath = new KeyPath("\u56fe\u5c422\u8f6e\u5ed3", "**");
        ColorFilter colorFilter = LottieProperty.COLOR_FILTER;
        lottieDrawable.addValueCallback(keyPath, (KeyPath) colorFilter, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback);
        lottieDrawable.addValueCallback(new KeyPath("\u56fe\u5c423\u8f6e\u5ed3", "**"), (KeyPath) colorFilter, (SimpleLottieValueCallback<KeyPath>) simpleLottieValueCallback);
    }
}
