package com.tencent.mobileqq.weather.mvvm;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J0\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bR\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/d;", "Lcom/tencent/mobileqq/weather/mvvm/c;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAds", "", "adPosId", "", "pagePos", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "", "O1", "", "needRequestMask", "isRefresh", "P1", "R1", UserInfo.SEX_FEMALE, "I", "getMRequestState", "()I", "setMRequestState", "(I)V", "mRequestState", "", "G", "Ljava/util/List;", "getMFirstPageAds", "()Ljava/util/List;", "setMFirstPageAds", "(Ljava/util/List;)V", "mFirstPageAds", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d extends c {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final d E;

    /* renamed from: F, reason: from kotlin metadata */
    private static int mRequestState;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static List<GdtAd> mFirstPageAds;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32078);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        E = new d();
        List<GdtAd> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(ArrayList())");
        mFirstPageAds = synchronizedList;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.weather.mvvm.c
    public void O1(@NotNull List<? extends GdtAd> gdtAds, @NotNull String adPosId, int pagePos, @Nullable access.UserActionReportInfo userActionReportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, gdtAds, adPosId, Integer.valueOf(pagePos), userActionReportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(gdtAds, "gdtAds");
        Intrinsics.checkNotNullParameter(adPosId, "adPosId");
        mFirstPageAds.clear();
        mFirstPageAds.addAll(gdtAds);
        mRequestState = 1;
        super.O1(gdtAds, adPosId, pagePos, userActionReportInfo);
    }

    @Override // com.tencent.mobileqq.weather.mvvm.c
    public void P1(boolean needRequestMask, boolean isRefresh, int pagePos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(needRequestMask), Boolean.valueOf(isRefresh), Integer.valueOf(pagePos));
            return;
        }
        if (!needRequestMask && !isRefresh) {
            if (mRequestState == 1) {
                M1().postValue(mFirstPageAds);
            }
        } else {
            mRequestState = 0;
            super.P1(needRequestMask, isRefresh, pagePos);
        }
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            mRequestState = 0;
            mFirstPageAds.clear();
        }
    }
}
