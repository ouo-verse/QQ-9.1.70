package com.tencent.mobileqq.ad.cardad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\bJ4\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0017R,\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u001c*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR,\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u001c*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/utils/b;", "", "", "traceId", "", "aId", "", "d", "", "g", "i", "c", "b", "e", h.F, "a", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "isFilter", "", "slot", "f", "", "", "kotlin.jvm.PlatformType", "Ljava/util/Set;", "mOriginExpoReportedData", "mValidExpoReportedData", "Ljava/lang/String;", "mLastDirectExpoReportTraceId", "J", "mLastDirectExpoReportTime", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f186729a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mOriginExpoReportedData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mValidExpoReportedData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mLastDirectExpoReportTraceId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long mLastDirectExpoReportTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f186729a = new b();
        mOriginExpoReportedData = Collections.synchronizedSet(new HashSet());
        mValidExpoReportedData = Collections.synchronizedSet(new HashSet());
        mLastDirectExpoReportTraceId = "";
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean d(String traceId, long aId) {
        return mOriginExpoReportedData.contains(traceId + util.base64_pad_url + aId);
    }

    private final void g(String traceId, long aId) {
        String str = traceId + util.base64_pad_url + aId;
        Set<String> set = mOriginExpoReportedData;
        if (set.size() > 400) {
            set.clear();
        }
        set.add(str);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            mLastDirectExpoReportTraceId = "";
        }
    }

    public final void b(@NotNull String traceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) traceId);
            return;
        }
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (TextUtils.equals(mLastDirectExpoReportTraceId, traceId)) {
            mLastDirectExpoReportTraceId = "";
        }
    }

    public final boolean c(@NotNull String traceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) traceId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (!TextUtils.equals(mLastDirectExpoReportTraceId, traceId) && System.currentTimeMillis() - mLastDirectExpoReportTime > 100) {
            return true;
        }
        return false;
    }

    public final boolean e(@Nullable String traceId, long aId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, traceId, Long.valueOf(aId))).booleanValue();
        }
        return mValidExpoReportedData.contains(traceId + util.base64_pad_url + aId);
    }

    public final void f(@NotNull GdtAd gdtAd, @NotNull Context context, @Nullable aa reportCallback, boolean isFilter, int slot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, gdtAd, context, reportCallback, Boolean.valueOf(isFilter), Integer.valueOf(slot));
            return;
        }
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        Intrinsics.checkNotNullParameter(context, "context");
        if (gdtAd.info == null) {
            QLog.e("CardAdReportHelper", 1, "reportAdOriginExpo error: ad is null");
            return;
        }
        String traceId = gdtAd.getTraceId();
        long aId = gdtAd.getAId();
        String str = traceId + util.base64_pad_url + aId;
        if (TextUtils.isEmpty(traceId)) {
            QLog.e("CardAdReportHelper", 1, "reportAdOriginExpo error: tag is null");
            return;
        }
        if (d(traceId, aId)) {
            return;
        }
        GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, context, slot, isFilter);
        g(traceId, aId);
        if (reportCallback != null) {
            reportCallback.a(gdtAd);
        }
        QLog.d("CardAdReportHelper", 2, "origin expo report success:", str);
    }

    public final void h(@Nullable String traceId, long aId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, traceId, Long.valueOf(aId));
            return;
        }
        String str = traceId + util.base64_pad_url + aId;
        Set<String> set = mValidExpoReportedData;
        if (set.size() > 400) {
            set.clear();
        }
        set.add(str);
    }

    public final void i(@NotNull String traceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) traceId);
            return;
        }
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        mLastDirectExpoReportTraceId = traceId;
        mLastDirectExpoReportTime = System.currentTimeMillis();
    }
}
