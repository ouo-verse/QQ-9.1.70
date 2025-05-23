package com.tencent.mobileqq.hermes.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/hermes/util/a;", "", "", "ranking", "", "g", "c", "", "b", "a", "Landroid/view/View;", "v", "", "color", "Landroid/graphics/Bitmap;", h.F, "picUrl", "d", "e", "", "firstTime", "f", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f236827a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity entity;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f236827a = new a();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        entity = from;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(long ranking) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, ranking);
        }
        String format = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.US)).format(ranking);
        Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat(\"#,###\", D\u2026cale.US)).format(ranking)");
        return format;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("101753", "");
        TextUtils.isEmpty(loadAsString);
        return loadAsString;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return entity.decodeLong("RANKING_KEY" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), Long.MIN_VALUE);
    }

    public final void d(@NotNull String picUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) picUrl);
        } else {
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C5C4", "0X800C5C4", 0, 0, "", "", picUrl, "");
        }
    }

    public final void e(@NotNull String picUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) picUrl);
        } else {
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0x800C5C3", "0x800C5C3", 0, 0, "", "", picUrl, "");
        }
    }

    public final void f(boolean firstTime) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, firstTime);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (firstTime) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0x800C5C2", "0x800C5C2", 0, 0, str, "", "", "");
    }

    public final void g(long ranking) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, ranking);
            return;
        }
        entity.encodeLong("RANKING_KEY" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), ranking);
    }

    @Nullable
    public final Bitmap h(@NotNull View v3, int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, color);
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        v3.clearFocus();
        v3.setPressed(false);
        Bitmap bitmap = null;
        try {
            v3.setDrawingCacheEnabled(true);
            v3.setDrawingCacheBackgroundColor(color);
            v3.buildDrawingCache();
            bitmap = Bitmap.createBitmap(v3.getDrawingCache());
            v3.destroyDrawingCache();
            return bitmap;
        } catch (Exception e16) {
            QLog.e("HermesUtil", 1, "shotViewBitmap error!", e16);
            return bitmap;
        }
    }
}
