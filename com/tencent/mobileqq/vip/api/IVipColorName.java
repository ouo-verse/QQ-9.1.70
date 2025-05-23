package com.tencent.mobileqq.vip.api;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0010\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\rH&J,\u0010\u0010\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH&J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001a\u0010\u0017\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipColorName;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "aSyncSetGradient", "", "textView", "Landroid/view/View;", "uin", "", "clearTextColorGradient", "openChangeColorNamePage", "context", "Landroid/content/Context;", "updateColorNameByCard", "", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/data/Card;", "updateColorNameByUin", "isVip", "noise", "updateColorNameByVipBusiness", "", "info", "Lcom/tencent/mobileqq/vip/api/VipInfoForBusiness;", "updateColorNameByVipBusinessWithoutUin", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipColorName extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipColorName$Companion;", "", "()V", "getShader", "Landroid/graphics/Shader;", "width", "", "height", "getShaderAct", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39887);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                $$INSTANCE = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Shader getShader(int width, int height) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Shader) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(width), Integer.valueOf(height));
            }
            return new LinearGradient(0.0f, 0.0f, width, 0.0f, new int[]{Color.parseColor("#1AE5F8"), Color.parseColor("#3874F4"), Color.parseColor("#FF7BCA")}, (float[]) null, Shader.TileMode.CLAMP);
        }

        @NotNull
        public final Shader getShaderAct(int width) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Shader) iPatchRedirector.redirect((short) 3, (Object) this, width);
            }
            return new LinearGradient(0.0f, 0.0f, width, 0.0f, new int[]{Color.parseColor("#deb756"), Color.parseColor("#deb756"), Color.parseColor("#deb756")}, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39888), (Class<?>) IVipColorName.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.$$INSTANCE;
        }
    }

    void aSyncSetGradient(@Nullable View textView, @Nullable String uin);

    void clearTextColorGradient(@Nullable View textView);

    void openChangeColorNamePage(@NotNull Context context);

    boolean updateColorNameByCard(@Nullable View textView, @Nullable Card card);

    boolean updateColorNameByUin(@Nullable View textView, @Nullable String uin, boolean isVip);

    boolean updateColorNameByUin(@Nullable View textView, @Nullable String uin, boolean isVip, boolean noise);

    int updateColorNameByVipBusiness(@Nullable View textView, @NotNull VipInfoForBusiness info);

    int updateColorNameByVipBusinessWithoutUin(@Nullable View textView, @NotNull VipInfoForBusiness info);
}
