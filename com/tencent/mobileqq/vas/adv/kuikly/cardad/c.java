package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0011B\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/c;", "", "", "f", "", "d", "", "adIndex", "Ltencent/gdt/access$AdGetRsp;", "e", "c", "b", "adRsp", "o", "index", "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView;", "kuiklyCardAdView", "a", DomainData.DOMAIN_NAME, "i", "j", h.F, "k", "g", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "pageName", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mIndexToAdMap", "Ljava/util/WeakHashMap;", "Ljava/util/WeakHashMap;", "mAdViewWeakMap", "<init>", "(Ljava/lang/String;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, access.AdGetRsp> mIndexToAdMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakHashMap<Integer, VasKuiklyCardAdView> mAdViewWeakMap;

    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void d() {
        this.mIndexToAdMap.clear();
        this.mAdViewWeakMap.clear();
        com.tencent.mobileqq.ad.cardad.utils.b.f186729a.a();
    }

    private final String f() {
        return "VasKuiklyCardAdPageModel:" + this.pageName;
    }

    public final void a(int index, @NotNull VasKuiklyCardAdView kuiklyCardAdView) {
        Intrinsics.checkNotNullParameter(kuiklyCardAdView, "kuiklyCardAdView");
        this.mAdViewWeakMap.put(Integer.valueOf(index), kuiklyCardAdView);
        QLog.d(f(), 1, "addToNotifyView,index:", Integer.valueOf(index), ",size:", Integer.valueOf(this.mAdViewWeakMap.size()));
    }

    public final void b(int adIndex) {
        QLog.d(f(), 1, "asyncAdRequestFailed:", Integer.valueOf(adIndex));
        VasKuiklyCardAdView vasKuiklyCardAdView = this.mAdViewWeakMap.get(Integer.valueOf(adIndex));
        if (vasKuiklyCardAdView != null) {
            vasKuiklyCardAdView.q();
        }
    }

    public final void c(int adIndex) {
        QLog.d(f(), 1, "asyncAdRequestSuccess:", Integer.valueOf(adIndex));
        VasKuiklyCardAdView vasKuiklyCardAdView = this.mAdViewWeakMap.get(Integer.valueOf(adIndex));
        if (vasKuiklyCardAdView != null) {
            vasKuiklyCardAdView.r();
        }
    }

    @Nullable
    public final access.AdGetRsp e(int adIndex) {
        QLog.d(f(), 1, "getAd adIndex:", Integer.valueOf(adIndex));
        if (this.mIndexToAdMap.containsKey(Integer.valueOf(adIndex))) {
            return this.mIndexToAdMap.get(Integer.valueOf(adIndex));
        }
        return null;
    }

    public final void g() {
        QLog.d(f(), 1, "handleEventCheckAdVisibility");
        Iterator<Map.Entry<Integer, VasKuiklyCardAdView>> it = this.mAdViewWeakMap.entrySet().iterator();
        while (it.hasNext()) {
            VasKuiklyCardAdView value = it.next().getValue();
            if (value != null) {
                value.u();
            }
        }
    }

    public final void h() {
        QLog.d(f(), 1, "handleEventOnPageAppear");
        Iterator<Map.Entry<Integer, VasKuiklyCardAdView>> it = this.mAdViewWeakMap.entrySet().iterator();
        while (it.hasNext()) {
            VasKuiklyCardAdView value = it.next().getValue();
            if (value != null) {
                value.setPageAppear();
            }
        }
    }

    public final void i() {
        QLog.d(f(), 1, "handleEventOnPageCreate");
        Iterator<Map.Entry<Integer, VasKuiklyCardAdView>> it = this.mAdViewWeakMap.entrySet().iterator();
        while (it.hasNext()) {
            VasKuiklyCardAdView value = it.next().getValue();
            if (value != null) {
                value.u();
            }
        }
    }

    public final void j() {
        QLog.d(f(), 1, "handleEventOnPageDestroy");
        Iterator<Map.Entry<Integer, VasKuiklyCardAdView>> it = this.mAdViewWeakMap.entrySet().iterator();
        while (it.hasNext()) {
            VasKuiklyCardAdView value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        d();
    }

    public final void k() {
        QLog.d(f(), 1, "handleEventOnPageDisappear");
        Iterator<Map.Entry<Integer, VasKuiklyCardAdView>> it = this.mAdViewWeakMap.entrySet().iterator();
        while (it.hasNext()) {
            VasKuiklyCardAdView value = it.next().getValue();
            if (value != null) {
                value.y(null);
            }
        }
    }

    public final void l(int adIndex) {
        QLog.d(f(), 1, "handleEventRefreshAdData,", Integer.valueOf(adIndex));
        Iterator<Map.Entry<Integer, VasKuiklyCardAdView>> it = this.mAdViewWeakMap.entrySet().iterator();
        while (it.hasNext()) {
            VasKuiklyCardAdView value = it.next().getValue();
            if (value != null) {
                value.H(adIndex);
            }
        }
    }

    public final boolean m() {
        return this.mAdViewWeakMap.isEmpty();
    }

    public final void n(int index) {
        this.mAdViewWeakMap.remove(Integer.valueOf(index));
        QLog.d(f(), 1, "removeFromNotifyView,index:", Integer.valueOf(index), ",size:", Integer.valueOf(this.mAdViewWeakMap.size()));
    }

    public final void o(int adIndex, @NotNull access.AdGetRsp adRsp) {
        Intrinsics.checkNotNullParameter(adRsp, "adRsp");
        QLog.d(f(), 1, "updateAd:", Integer.valueOf(adIndex));
        this.mIndexToAdMap.put(Integer.valueOf(adIndex), adRsp);
    }

    public c(@NotNull String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        this.pageName = pageName;
        this.mIndexToAdMap = new ConcurrentHashMap<>();
        this.mAdViewWeakMap = new WeakHashMap<>();
    }

    public /* synthetic */ c(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "default_page" : str);
    }
}
