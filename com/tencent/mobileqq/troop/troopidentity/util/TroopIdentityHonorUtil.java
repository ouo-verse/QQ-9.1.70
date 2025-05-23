package com.tencent.mobileqq.troop.troopidentity.util;

import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.util.QQToastUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\u0006J6\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R#\u0010\u001f\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/util/TroopIdentityHonorUtil;", "", "", "id", "", "e", "(Ljava/lang/Integer;)Ljava/lang/String;", "a", "d", "Lkotlin/Function2;", "Landroid/widget/ImageView;", "Lkotlin/ParameterName;", "name", "imageView", "url", "", "f", "i", "", "needToast", "g", "Lkotlin/text/Regex;", "b", "Lkotlin/text/Regex;", "()Lkotlin/text/Regex;", "CHINESE_REGEX", "Lcom/tencent/mobileqq/troop/honor/config/b;", "kotlin.jvm.PlatformType", "c", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/troop/honor/config/b;", DownloadInfo.spKey_Config, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityHonorUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final TroopIdentityHonorUtil f300410a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Regex CHINESE_REGEX;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final Lazy com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f300410a = new TroopIdentityHonorUtil();
        CHINESE_REGEX = new Regex("[\u4e00-\u9fff]+");
        lazy = LazyKt__LazyJVMKt.lazy(TroopIdentityHonorUtil$config$2.INSTANCE);
        com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String = lazy;
    }

    TroopIdentityHonorUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.troop.honor.config.b c() {
        return (com.tencent.mobileqq.troop.honor.config.b) com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.getValue();
    }

    public static /* synthetic */ boolean h(TroopIdentityHonorUtil troopIdentityHonorUtil, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return troopIdentityHonorUtil.g(z16);
    }

    @NotNull
    public final String a(@Nullable Integer id5) {
        com.tencent.mobileqq.troop.honor.config.a c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) id5);
        }
        if (id5 == null || (c16 = c().c(id5.intValue())) == null) {
            return "";
        }
        String str = c16.f297514h;
        Intrinsics.checkNotNullExpressionValue(str, "honor.bigIconUrl");
        return str;
    }

    @NotNull
    public final Regex b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Regex) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return CHINESE_REGEX;
    }

    @NotNull
    public final String d(@Nullable Integer id5) {
        com.tencent.mobileqq.troop.honor.config.a c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) id5);
        }
        if (id5 == null || (c16 = c().c(id5.intValue())) == null) {
            return "";
        }
        String str = c16.f297515i;
        Intrinsics.checkNotNullExpressionValue(str, "honor.greyBigIconUrl");
        return str;
    }

    @NotNull
    public final String e(@Nullable Integer id5) {
        com.tencent.mobileqq.troop.honor.config.a c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) id5);
        }
        if (id5 == null || (c16 = c().c(id5.intValue())) == null) {
            return "";
        }
        String str = c16.f297513f;
        Intrinsics.checkNotNullExpressionValue(str, "honor.iconUrl");
        return str;
    }

    @NotNull
    public final Function2<ImageView, String, Unit> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Function2) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return TroopIdentityHonorUtil$getImageLoader$1.INSTANCE;
    }

    public final boolean g(boolean needToast) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, needToast)).booleanValue();
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            if (needToast) {
                QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f235097aq));
            }
            return true;
        }
        return false;
    }

    public final void i(@NotNull ImageView imageView, @Nullable String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) imageView, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            imageView.setImageDrawable(new ColorDrawable(0));
            return;
        }
        Option option = Option.obtain().setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0)).setTargetView(imageView).setUrl(url);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }
}
