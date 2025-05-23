package com.tencent.sqshow.zootopia.recommend.main.tab;

import android.graphics.Color;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContentUrl;
import com.tencent.sqshow.zootopia.recommend.main.tab.network.ZPlanTabServerDataManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import qv4.ba;
import qv4.x;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0014\u001a\u00020\u0013R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/b;", "", "", "colorString", "", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "e", DownloadInfo.spKey_Config, "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", "Lkotlin/collections/ArrayList;", "f", "c", "", "d", "", "a", "pageType", "b", "Lqv4/x;", "rsp", "g", "Ljava/util/ArrayList;", "mDefaultTabList", "Ljava/lang/String;", "mCacheConfig", "mCacheConfigTabList", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f372639a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<ZPlanTabData> mDefaultTabList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String mCacheConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<ZPlanTabData> mCacheConfigTabList;

    static {
        b bVar = new b();
        f372639a = bVar;
        ArrayList<ZPlanTabData> arrayList = new ArrayList<>();
        mDefaultTabList = arrayList;
        String c16 = bVar.c();
        mCacheConfig = c16;
        mCacheConfigTabList = bVar.f(c16);
        arrayList.add(new ZPlanTabData("\u89d2\u8272", 1, 0, new ZPlanTabContentUrl(1, 0, null, null, 14, null), R.drawable.igi, R.drawable.igh, null, null, 0, 0, null, 0, null, null, 0L, 32708, null));
    }

    b() {
    }

    private final String c() {
        String homePageTabConfigV2 = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getHomePageTabConfigV2();
        QLog.i("ZPlanTabConfigManager_", 1, "getTabConfig config:" + homePageTabConfigV2);
        return homePageTabConfigV2;
    }

    private final int e(String colorString, int defaultColor) {
        try {
            return Color.parseColor(colorString);
        } catch (Exception unused) {
            QLog.e("ZPlanTabConfigManager_", 1, "safeParseColor error - " + colorString);
            return defaultColor;
        }
    }

    public final boolean b(int pageType) {
        Object obj;
        Iterator<T> it = d().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ZPlanTabData) obj).getContentUrlInfo().getPageType() == pageType) {
                break;
            }
        }
        return obj != null;
    }

    public final List<ZPlanTabData> d() {
        List<ZPlanTabData> l3 = ZPlanTabServerDataManager.f372670a.l();
        if (!l3.isEmpty()) {
            QLog.i("ZPlanTabConfigManager_", 1, "getTabData, use serverData");
            return l3;
        }
        mCacheConfig = c();
        ArrayList<ZPlanTabData> arrayList = mCacheConfigTabList;
        arrayList.clear();
        arrayList.addAll(f(mCacheConfig));
        if (!arrayList.isEmpty()) {
            QLog.i("ZPlanTabConfigManager_", 1, "getTabData, use toggleConfigData");
            return arrayList;
        }
        QLog.i("ZPlanTabConfigManager_", 1, "getTabData, use clientData");
        return mDefaultTabList;
    }

    public final boolean a() {
        return b(3);
    }

    private final ArrayList<ZPlanTabData> f(String config) {
        JSONArray optJSONArray;
        String str;
        JSONArray jSONArray;
        String str2 = WadlProxyConsts.KEY_JUMP_URL;
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        int i3 = 1;
        QLog.i("ZPlanTabConfigManager_", 1, "transConfigToTabList config:" + config + " studyMode:" + studyModeSwitch);
        ArrayList<ZPlanTabData> arrayList = new ArrayList<>();
        try {
            optJSONArray = new JSONObject(config).optJSONArray("tabList");
        } catch (Exception e16) {
            QLog.w("ZPlanTabConfigManager_", 1, "transConfigToTabList failed, config:" + config, e16);
        }
        if (optJSONArray == null) {
            return arrayList;
        }
        int length = optJSONArray.length();
        int i16 = 0;
        while (i16 < length) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i16);
            String optString = jSONObject.optString(str2);
            ZPlanTabContentUrl.Companion companion = ZPlanTabContentUrl.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(optString, str2);
            ZPlanTabContentUrl a16 = companion.a(optString);
            QLog.i("ZPlanTabConfigManager_", i3, "transConfigToTabList contentUrlInfo:" + a16);
            if (a16 != null && a16.getPageType() != 3) {
                String optString2 = jSONObject.optString("name");
                Intrinsics.checkNotNullExpressionValue(optString2, "tabContent.optString(\"name\")");
                int optInt = jSONObject.optInt("id");
                int optInt2 = jSONObject.optInt("type");
                String optString3 = jSONObject.optString("selectedIcon");
                Intrinsics.checkNotNullExpressionValue(optString3, "tabContent.optString(\"selectedIcon\")");
                String optString4 = jSONObject.optString("unselectedIcon");
                Intrinsics.checkNotNullExpressionValue(optString4, "tabContent.optString(\"unselectedIcon\")");
                int parseColor = Color.parseColor(jSONObject.optString("selectedTxtColor"));
                int parseColor2 = Color.parseColor(jSONObject.optString("unselectedTxtColor"));
                String optString5 = jSONObject.optString("transitionUrl");
                str = str2;
                Intrinsics.checkNotNullExpressionValue(optString5, "tabContent.optString(\"transitionUrl\")");
                jSONArray = optJSONArray;
                ZPlanTabData zPlanTabData = new ZPlanTabData(optString2, optInt, optInt2, a16, 0, 0, optString3, optString4, parseColor, parseColor2, optString5, jSONObject.optInt("childrenMode", 0), null, null, 0L, 28720, null);
                if (studyModeSwitch && zPlanTabData.getStudyModeSwitch() == 1) {
                    QLog.w("ZPlanTabConfigManager_", 1, "transConfigToTabList studyMode and tabData.studyModeSwitch == 1, filtered");
                } else {
                    arrayList.add(zPlanTabData);
                }
                i16++;
                str2 = str;
                optJSONArray = jSONArray;
                i3 = 1;
            }
            str = str2;
            jSONArray = optJSONArray;
            i16++;
            str2 = str;
            optJSONArray = jSONArray;
            i3 = 1;
        }
        return arrayList;
    }

    public final List<ZPlanTabData> g(x rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        ArrayList arrayList = new ArrayList();
        ba[] baVarArr = rsp.f430208a;
        if (baVarArr != null) {
            for (ba baVar : baVarArr) {
                long serverTime = NetConnInfoCenter.getServerTime() + 2;
                if (baVar.f430033c == 1) {
                    long j3 = baVar.f430042l;
                    if (j3 <= serverTime) {
                        QLog.e("ZPlanTabConfigManager_", 1, "id:" + baVar.f430031a + ", name:" + baVar.f430032b + ",endTimeInSec:" + j3 + ", nowTimeInSec:" + serverTime + ", data passed!");
                    }
                }
                ZPlanTabContentUrl.Companion companion = ZPlanTabContentUrl.INSTANCE;
                String str = baVar.f430037g;
                Intrinsics.checkNotNullExpressionValue(str, "bottomTabItem.jumpUrl");
                ZPlanTabContentUrl a16 = companion.a(str);
                if (a16 != null) {
                    String str2 = baVar.f430032b;
                    Intrinsics.checkNotNullExpressionValue(str2, "bottomTabItem.name");
                    int i3 = baVar.f430031a;
                    int i16 = baVar.f430033c;
                    String str3 = baVar.f430035e;
                    Intrinsics.checkNotNullExpressionValue(str3, "bottomTabItem.selectedIconUrl");
                    String str4 = baVar.f430034d;
                    Intrinsics.checkNotNullExpressionValue(str4, "bottomTabItem.unselectedIconUrl");
                    b bVar = f372639a;
                    String str5 = baVar.f430039i;
                    Intrinsics.checkNotNullExpressionValue(str5, "bottomTabItem.selectedTxtColor");
                    int e16 = bVar.e(str5, Color.parseColor("#292929"));
                    String str6 = baVar.f430038h;
                    Intrinsics.checkNotNullExpressionValue(str6, "bottomTabItem.unselectedTxtColor");
                    int e17 = bVar.e(str6, Color.parseColor("#B4B5BB"));
                    String str7 = baVar.f430036f;
                    Intrinsics.checkNotNullExpressionValue(str7, "bottomTabItem.transitionUrl");
                    pu4.g gVar = baVar.f430040j;
                    if (gVar == null) {
                        gVar = new pu4.g();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(gVar, "bottomTabItem.sResourceUnselected ?: Material()");
                    }
                    pu4.g gVar2 = gVar;
                    pu4.g gVar3 = baVar.f430041k;
                    if (gVar3 == null) {
                        gVar3 = new pu4.g();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(gVar3, "bottomTabItem.sResourceSelected ?: Material()");
                    }
                    arrayList.add(new ZPlanTabData(str2, i3, i16, a16, 0, 0, str3, str4, e16, e17, str7, 0, gVar2, gVar3, baVar.f430042l, 2096, null));
                } else {
                    QLog.e("ZPlanTabConfigManager_", 1, "transServerRspToTabList item error - " + baVar.f430037g);
                }
            }
        }
        return arrayList;
    }
}
