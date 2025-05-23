package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.view.RewardedAdController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.RewardVrReportData;
import com.tencent.tvideo.protocol.pb.ADVideoInfo;
import com.tencent.tvideo.protocol.pb.AdActionField;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import pw2.w;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010.\u001a\u00020,\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J8\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0014J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0014J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001cH\u0014JP\u0010\"\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00022\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u001fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011` 2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007JP\u0010#\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00022\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u001fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011` 2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010$\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0005JB\u0010%\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001cJ0\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001` 2\b\u0010(\u001a\u0004\u0018\u00010'J&\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010*\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010'R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/f;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/qadreport/advrreport/b;", "", "isAdMaskArea", "isPopWindow", "", DomainData.DOMAIN_NAME, "v", "y", "w", "D", "clickField", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "view", "", "", "", "otherReportParams", "", "E", HippyTKDListViewAdapter.X, "B", "Lew2/a;", "e", "a", "viewId", "b", "", h.F, "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraReportMap", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", ReportConstant.COSTREPORT_PREFIX, "t", "u", "Lfx2/b;", "rewardAdLoadInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "eid", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "Lcom/tencent/ams/xsad/rewarded/RewardedAd;", "rewardedAd", "Lgw2/a;", "vrProvider", "<init>", "(Lgw2/a;Lcom/tencent/ams/xsad/rewarded/RewardedAd;)V", "f", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class f extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RewardedAd rewardedAd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull gw2.a vrProvider, @NotNull RewardedAd rewardedAd) {
        super(vrProvider);
        Intrinsics.checkNotNullParameter(vrProvider, "vrProvider");
        Intrinsics.checkNotNullParameter(rewardedAd, "rewardedAd");
        this.rewardedAd = rewardedAd;
        B();
    }

    private final boolean C(int clickField) {
        if (clickField != 7 && clickField != 8 && clickField != 6 && clickField != 9) {
            return false;
        }
        return true;
    }

    private final boolean D() {
        RewardedAdData g16 = this.rewardedAd.g();
        if (g16 != null) {
            return g16.f71688b;
        }
        return false;
    }

    private final void E(View view, Map<String, ? extends Object> otherReportParams, boolean isAdMaskArea, boolean isPopWindow) {
        RewardedAdController h16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (otherReportParams == null || !otherReportParams.containsKey(QAdVrReportParams.ParamKey.AD_LAYER)) {
            linkedHashMap.put(QAdVrReportParams.ParamKey.AD_LAYER, Integer.valueOf(n(isAdMaskArea, isPopWindow)));
        }
        if (otherReportParams != null) {
            linkedHashMap.putAll(otherReportParams);
        }
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            linkedHashMap.put("ad_display_type", Integer.valueOf(h16.getDisplayType()));
        }
        QAdVrReport.f(view, linkedHashMap);
    }

    private final int n(boolean isAdMaskArea, boolean isPopWindow) {
        if (isAdMaskArea) {
            return v();
        }
        if (isPopWindow) {
            return y();
        }
        return w();
    }

    public static /* synthetic */ void p(f fVar, View view, String str, boolean z16, HashMap hashMap, boolean z17, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z17 = false;
        }
        fVar.o(view, str, z16, hashMap, z17);
    }

    public static /* synthetic */ void r(f fVar, View view, String str, boolean z16, HashMap hashMap, boolean z17, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z17 = false;
        }
        fVar.q(view, str, z16, hashMap, z17);
    }

    private final int v() {
        if (D()) {
            return 4;
        }
        return 6;
    }

    private final int w() {
        if (D()) {
            return 3;
        }
        return 5;
    }

    private final Map<String, Object> x(int clickField) {
        Integer num;
        RewardedAdController h16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ew2.a e16 = e(clickField);
        if (e16 != null) {
            num = Integer.valueOf(e16.f397277b);
        } else {
            num = null;
        }
        int a16 = a(clickField);
        if (num != null) {
            linkedHashMap.put(QAdVrReportParams.ParamKey.AD_ACTION_TYPE, Integer.valueOf(num.intValue()));
        }
        linkedHashMap.put(QAdVrReportParams.ParamKey.AD_LAYER, Integer.valueOf(a16));
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            linkedHashMap.put("ad_display_type", Integer.valueOf(h16.getDisplayType()));
        }
        return linkedHashMap;
    }

    private final int y() {
        if (D()) {
            return 18;
        }
        return 19;
    }

    @NotNull
    public final Map<String, String> A(@NotNull String eid, @Nullable fx2.b rewardAdLoadInfo) {
        Map<String, String> emptyMap;
        int mapCapacity;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(eid, "eid");
        emptyMap = MapsKt__MapsKt.emptyMap();
        if (g() == null) {
            return emptyMap;
        }
        try {
            HashMap hashMap = new HashMap();
            Map<String, Object> d16 = w.d();
            if (d16 != null) {
                hashMap.putAll(d16);
            }
            Map<String, Object> g16 = w.g(g());
            if (g16 != null) {
                Object obj = g16.get("cur_pg");
                if (TypeIntrinsics.isMutableMap(obj)) {
                    Object obj2 = ((Map) obj).get("pgid");
                    if (obj2 != null) {
                        hashMap.put("cur_pgid", obj2);
                    }
                    Object obj3 = ((Map) obj).get("ref_pg");
                    if (obj3 != null && TypeIntrinsics.isMutableMap(obj3)) {
                        hashMap.putAll(TypeIntrinsics.asMutableMap(obj3));
                        hashMap.put("ref_pg", obj3);
                    }
                }
                if (rewardAdLoadInfo instanceof fx2.c) {
                    ADVideoInfo mVideoInfo = ((fx2.c) rewardAdLoadInfo).getMVideoInfo();
                    if (mVideoInfo != null) {
                        str4 = mVideoInfo.vid;
                    } else {
                        str4 = null;
                    }
                    hashMap.put(QAdVrReportParams.ParamKey.PG_VID, str4);
                    ADVideoInfo mVideoInfo2 = ((fx2.c) rewardAdLoadInfo).getMVideoInfo();
                    if (mVideoInfo2 != null) {
                        str5 = mVideoInfo2.cid;
                    } else {
                        str5 = null;
                    }
                    hashMap.put(QAdVrReportParams.ParamKey.PG_CID, str5);
                }
                hashMap.put("eid", eid);
                AdOrderItem f16 = f();
                if (f16 != null) {
                    str2 = f16.order_id;
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    AdOrderItem f17 = f();
                    if (f17 != null) {
                        str3 = f17.order_id;
                    } else {
                        str3 = null;
                    }
                    hashMap.put("ad_group_id", str3);
                }
            }
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(hashMap.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Object obj4 : hashMap.entrySet()) {
                Object key = ((Map.Entry) obj4).getKey();
                Object value = ((Map.Entry) obj4).getValue();
                if (value != null) {
                    str = value.toString();
                } else {
                    str = null;
                }
                linkedHashMap.put(key, str);
            }
            return linkedHashMap;
        } catch (Exception unused) {
            n.b("[RewardAd]QAdRewardVrHelper", "getAdExtraInfo, convert error");
            return emptyMap;
        }
    }

    public void B() {
        Map<Integer, ew2.a> map = this.f304029d;
        map.clear();
        AdActionField adActionField = AdActionField.AD_ACTION_FIELD_ACTION_BTN;
        map.put(1, new ew2.a(adActionField, 1002, QAdVrReport.ElementID.AD_HEAD));
        map.put(2, new ew2.a(adActionField, 1003, QAdVrReport.ElementID.AD_NAME));
        map.put(3, new ew2.a(adActionField, 1011, QAdVrReport.ElementID.AD_TITLE));
        map.put(4, new ew2.a(adActionField, 1021, QAdVrReport.ElementID.AD_ACTION_BTN));
        map.put(5, new ew2.a(adActionField, 1024, QAdVrReport.ElementID.AD_POSTER_RELATIVE));
        map.put(6, new ew2.a(adActionField, 1031, QAdVrReport.ElementID.AD_HEAD));
        map.put(7, new ew2.a(adActionField, 1030, QAdVrReport.ElementID.AD_NAME));
        map.put(8, new ew2.a(adActionField, 1041, QAdVrReport.ElementID.AD_TITLE));
        map.put(9, new ew2.a(adActionField, 1023, QAdVrReport.ElementID.AD_ACTION_BTN));
        map.put(11, new ew2.a(adActionField, 1014, QAdVrReport.ElementID.AD_POSTER));
        map.put(10, new ew2.a(adActionField, 1024, QAdVrReport.ElementID.AD_POSTER_RELATIVE));
        map.put(12, new ew2.a(adActionField, 1024, QAdVrReport.ElementID.AD_AUTO_OPEN));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    protected int a(int clickField) {
        return n(C(clickField), false);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    protected int b(int viewId) {
        return 0;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    @Nullable
    public ew2.a e(int clickField) {
        return this.f304029d.get(Integer.valueOf(clickField));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    @Nullable
    protected Map<String, String> h() {
        return QAdVrReport.b(f());
    }

    @JvmOverloads
    public final void o(@Nullable View view, @NotNull String elementId, boolean isPopWindow, @NotNull HashMap<String, Object> extraReportMap, boolean isAdMaskArea) {
        RewardedAdController h16;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(extraReportMap, "extraReportMap");
        if (view == null) {
            return;
        }
        if (this.f304027b == null) {
            l(null);
        }
        extraReportMap.put(QAdVrReportParams.ParamKey.AD_LAYER, Integer.valueOf(n(isAdMaskArea, isPopWindow)));
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            int displayType = h16.getDisplayType();
            QAdVrReportParams qAdVrReportParams = this.f304027b;
            if (qAdVrReportParams != null) {
                qAdVrReportParams.f("ad_display_type", Integer.valueOf(displayType));
            }
        }
        QAdVrReportParams qAdVrReportParams2 = this.f304027b;
        if (qAdVrReportParams2 != null) {
            qAdVrReportParams2.f(QAdVrReportParams.ParamKey.IS_FULLSCREEN, "1");
        }
        QAdVrReportParams i3 = new QAdVrReportParams.a().g(this.f304027b).h(extraReportMap).i();
        Intrinsics.checkNotNullExpressionValue(i3, "QAdVrReportParams.Builde\u2026s(extraReportMap).build()");
        n.e("[RewardAd]QAdRewardVrHelper", "doEffectExposureReport");
        QAdVrReport.g(view, i3, elementId);
    }

    @JvmOverloads
    public final void q(@Nullable View view, @NotNull String elementId, boolean isPopWindow, @NotNull HashMap<String, Object> extraReportMap, boolean isAdMaskArea) {
        RewardedAdController h16;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(extraReportMap, "extraReportMap");
        if (view == null) {
            return;
        }
        if (this.f304027b == null) {
            l(null);
        }
        extraReportMap.put(QAdVrReportParams.ParamKey.AD_LAYER, Integer.valueOf(n(isAdMaskArea, isPopWindow)));
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            int displayType = h16.getDisplayType();
            QAdVrReportParams qAdVrReportParams = this.f304027b;
            if (qAdVrReportParams != null) {
                qAdVrReportParams.f("ad_display_type", Integer.valueOf(displayType));
            }
        }
        QAdVrReportParams qAdVrReportParams2 = this.f304027b;
        if (qAdVrReportParams2 != null) {
            qAdVrReportParams2.f(QAdVrReportParams.ParamKey.IS_FULLSCREEN, "1");
        }
        QAdVrReportParams i3 = new QAdVrReportParams.a().g(this.f304027b).h(extraReportMap).i();
        Intrinsics.checkNotNullExpressionValue(i3, "QAdVrReportParams.Builde\u2026s(extraReportMap).build()");
        n.e("[RewardAd]QAdRewardVrHelper", "doOriginExposureReport");
        QAdVrReport.m(view, i3, elementId);
    }

    public final void s(@Nullable View view, int clickField) {
        ew2.a e16;
        String str;
        Map<String, Object> map;
        if (view != null && f() != null && (e16 = e(clickField)) != null && (str = e16.f397278c) != null) {
            AdOrderItem f16 = f();
            QAdVrReportParams qAdVrReportParams = this.f304027b;
            if (qAdVrReportParams != null) {
                map = qAdVrReportParams.h();
            } else {
                map = null;
            }
            vv2.a.b(view, f16, str, 0, map);
            QAdVrReport.f(view, x(clickField));
        }
    }

    public final void t(@Nullable View view, @Nullable String elementId, @Nullable Map<String, ? extends Object> otherReportParams, boolean isAdMaskArea, boolean isPopWindow) {
        Map<String, Object> map;
        if (view != null && f() != null) {
            AdOrderItem f16 = f();
            QAdVrReportParams qAdVrReportParams = this.f304027b;
            if (qAdVrReportParams != null) {
                map = qAdVrReportParams.h();
            } else {
                map = null;
            }
            vv2.a.b(view, f16, elementId, 0, map);
            E(view, otherReportParams, isAdMaskArea, isPopWindow);
        }
    }

    @Nullable
    public final Map<String, Object> u() {
        Map<String, Object> linkedHashMap;
        RewardedAdController h16;
        View g16 = g();
        if (g16 == null || (linkedHashMap = w.g(g16)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null && (h16 = rewardedAd.h()) != null) {
            linkedHashMap.put("ad_display_type", Integer.valueOf(h16.getDisplayType()));
        }
        return linkedHashMap;
    }

    @Nullable
    public final HashMap<String, String> z(@Nullable fx2.b rewardAdLoadInfo) {
        Object obj;
        boolean z16;
        RewardVrReportData mVrReportData;
        Map<String, Object> b16;
        HashMap<String, String> hashMap = null;
        if (rewardAdLoadInfo != null && (mVrReportData = rewardAdLoadInfo.getMVrReportData()) != null && (b16 = mVrReportData.b()) != null) {
            obj = b16.get("cur_pg");
        } else {
            obj = null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get("ref_pg");
            if (obj2 instanceof Map) {
                hashMap = new HashMap<>();
                hashMap.put("pgid", String.valueOf(map.get("pgid")));
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    Object key = entry.getKey();
                    if (Intrinsics.areEqual(key, QAdVrReportParams.ParamKey.PG_CID) || Intrinsics.areEqual(key, QAdVrReportParams.ParamKey.PG_LID) || Intrinsics.areEqual(key, QAdVrReportParams.ParamKey.PG_VID) || Intrinsics.areEqual(key, QAdVrReportParams.ParamKey.PG_TYPE) || Intrinsics.areEqual(key, QAdVrReportParams.ParamKey.PG_TYPE_ID)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        hashMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                    }
                }
            }
        }
        return hashMap;
    }
}
