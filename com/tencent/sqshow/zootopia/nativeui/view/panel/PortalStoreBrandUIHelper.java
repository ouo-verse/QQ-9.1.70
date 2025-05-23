package com.tencent.sqshow.zootopia.nativeui.view.panel;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.api.IZPlanSmallHomeHelper;
import com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PortalStorePanelAllData;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nx4.a;
import org.json.JSONObject;
import uv4.at;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0003&\u0019\u001dB\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b$\u0010%J\u001c\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J,\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u000bR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper;", "", "", "brandId", "", "skipConfigTab", "k", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper$BackgroundConfigBean;", DownloadInfo.spKey_Config, "j", "path", "", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/m;", "data", "d", "", "isDark", "hideGroups", "g", "f", "panelHasEnter", "i", "e", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "a", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "nativeUI", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/o;", "b", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/o;", "getAnimHelper", "()Lcom/tencent/sqshow/zootopia/nativeui/view/panel/o;", "animHelper", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper$BackgroundConfigBean;", "configBean", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;Lcom/tencent/sqshow/zootopia/nativeui/view/panel/o;)V", "BackgroundConfigBean", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreBrandUIHelper {

    /* renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final a nativeUI;

    /* renamed from: b, reason: from kotlin metadata */
    private final o animHelper;

    /* renamed from: c, reason: from kotlin metadata */
    private volatile BackgroundConfigBean configBean;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper$a;", "", "", "brandId", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreBrandUIHelper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String brandId) {
            return "zplan_brand_store_background_" + brandId;
        }

        Companion() {
        }
    }

    public PortalStoreBrandUIHelper(a nativeUI, o animHelper) {
        Intrinsics.checkNotNullParameter(nativeUI, "nativeUI");
        Intrinsics.checkNotNullParameter(animHelper, "animHelper");
        this.nativeUI = nativeUI;
        this.animHelper = animHelper;
    }

    private final void c(String path) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", path);
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        if (S != null) {
            a.C10063a.d(S, "N2L_UpdateAvatarBackground", jSONObject, null, false, 8, null);
        }
    }

    public final boolean j(BackgroundConfigBean r56) {
        boolean isEngineReady = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady();
        QLog.d("PortalStoreBrandUIHelper_", 1, "update Backgroud Image => " + r56.toJson() + ", isEngineReady => " + isEngineReady);
        if (!isEngineReady) {
            return false;
        }
        c(r56.getImagePath());
        return true;
    }

    private final boolean k(String brandId, boolean skipConfigTab) {
        BackgroundConfigBean a16;
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(INSTANCE.a(brandId), "");
        QLog.d("PortalStoreBrandUIHelper_", 1, "brandId: " + brandId + ", saved data : " + string);
        if (!(string.length() > 0) || (a16 = BackgroundConfigBean.INSTANCE.a(string)) == null) {
            return false;
        }
        if (!skipConfigTab) {
            this.animHelper.t(!a16.getHideGroups());
        }
        j(a16);
        return true;
    }

    public final void d(PortalStorePanelAllData data, String brandId) {
        Intrinsics.checkNotNullParameter(data, "data");
        at commonCfg = data.getCommonCfg();
        this.animHelper.t(!(commonCfg != null && commonCfg.f440227e));
        at commonCfg2 = data.getCommonCfg();
        String str = commonCfg2 != null ? commonCfg2.f440225c : null;
        if (str == null) {
            return;
        }
        if (!(str.length() == 0) && ZPlanQQMC.INSTANCE.enableLoadBrandBg()) {
            int i3 = data.getCommonCfg().f440226d;
            boolean z16 = data.getCommonCfg().f440227e;
            if (brandId == null) {
                brandId = "null";
            }
            g(str, i3, z16, brandId);
        }
    }

    public final void f(String brandId) {
        Intrinsics.checkNotNullParameter(brandId, "brandId");
        QLog.i("PortalStoreBrandUIHelper_", 1, "reset Back " + brandId);
        if (brandId.length() > 0) {
            k("", true);
        }
    }

    public final void g(String path, int isDark, boolean hideGroups, String brandId) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brandId, "brandId");
        QLog.i("PortalStoreBrandUIHelper_", 1, "start download path:" + path + " isDark:" + isDark + ", hideGroups:" + hideGroups + ", brandId:" + brandId);
        ZPlanResDownloadReq zPlanResDownloadReq = new ZPlanResDownloadReq(path, null, null, 6, null);
        QRouteApi api = QRoute.api(ICommonDownloadHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ICommonDownloadHelper::class.java)");
        ICommonDownloadHelper.a.a((ICommonDownloadHelper) api, zPlanResDownloadReq, new b(isDark, hideGroups, brandId, this), false, 4, null);
    }

    public final void i(String brandId, boolean panelHasEnter) {
        ((IZPlanSmallHomeHelper) QRoute.api(IZPlanSmallHomeHelper.class)).setShouldShowUvAni(!panelHasEnter && com.tencent.sqshow.zootopia.recommend.characterV2.data.c.f372487a.a().b().booleanValue());
        if (brandId != null) {
            if (brandId.length() > 0) {
                this.animHelper.t(false);
            }
        }
        BackgroundConfigBean backgroundConfigBean = this.configBean;
        QLog.d("PortalStoreBrandUIHelper_", 1, "brandId: " + brandId + ", panelHasEnter: " + panelHasEnter + ", config => " + (backgroundConfigBean != null ? backgroundConfigBean.toJson() : null));
        if (backgroundConfigBean != null) {
            this.animHelper.t(!backgroundConfigBean.getHideGroups());
            j(backgroundConfigBean);
        } else {
            if (l(this, brandId, false, 2, null)) {
                return;
            }
            k("", true);
        }
    }

    public final void e() {
        QLog.d("PortalStoreBrandUIHelper_", 1, "remove cache ");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper$BackgroundConfigBean;", "Ljava/io/Serializable;", "", "toJson", "component1", "", "component2", "", "component3", "imagePath", "isDark", "hideGroups", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getImagePath", "()Ljava/lang/String;", "I", "()I", "Z", "getHideGroups", "()Z", "<init>", "(Ljava/lang/String;IZ)V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final /* data */ class BackgroundConfigBean implements Serializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean hideGroups;
        private final String imagePath;
        private final int isDark;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper$BackgroundConfigBean$a;", "", "", "jsonStr", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper$BackgroundConfigBean;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreBrandUIHelper$BackgroundConfigBean$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BackgroundConfigBean a(String jsonStr) {
                Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
                try {
                    JSONObject jSONObject = new JSONObject(jsonStr);
                    String path = jSONObject.optString("path");
                    int optInt = jSONObject.optInt("isDark");
                    boolean optBoolean = jSONObject.optBoolean("hideGroups", true);
                    Intrinsics.checkNotNullExpressionValue(path, "path");
                    return new BackgroundConfigBean(path, optInt, optBoolean);
                } catch (Exception e16) {
                    QLog.e("PortalStoreBrandUIHelper_", 1, "error => " + e16);
                    return null;
                }
            }

            Companion() {
            }
        }

        public BackgroundConfigBean(String imagePath, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            this.imagePath = imagePath;
            this.isDark = i3;
            this.hideGroups = z16;
        }

        /* renamed from: component1, reason: from getter */
        public final String getImagePath() {
            return this.imagePath;
        }

        /* renamed from: component2, reason: from getter */
        public final int getIsDark() {
            return this.isDark;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getHideGroups() {
            return this.hideGroups;
        }

        public final BackgroundConfigBean copy(String imagePath, int isDark, boolean hideGroups) {
            Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            return new BackgroundConfigBean(imagePath, isDark, hideGroups);
        }

        public final boolean getHideGroups() {
            return this.hideGroups;
        }

        public final String getImagePath() {
            return this.imagePath;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.imagePath.hashCode() * 31) + this.isDark) * 31;
            boolean z16 = this.hideGroups;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public final int isDark() {
            return this.isDark;
        }

        public final String toJson() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", this.imagePath);
            jSONObject.put("isDark", this.isDark);
            jSONObject.put("hideGroups", this.hideGroups);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            return jSONObject2;
        }

        public String toString() {
            return "BackgroundConfigBean(imagePath=" + this.imagePath + ", isDark=" + this.isDark + ", hideGroups=" + this.hideGroups + ")";
        }

        public static /* synthetic */ BackgroundConfigBean copy$default(BackgroundConfigBean backgroundConfigBean, String str, int i3, boolean z16, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = backgroundConfigBean.imagePath;
            }
            if ((i16 & 2) != 0) {
                i3 = backgroundConfigBean.isDark;
            }
            if ((i16 & 4) != 0) {
                z16 = backgroundConfigBean.hideGroups;
            }
            return backgroundConfigBean.copy(str, i3, z16);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BackgroundConfigBean)) {
                return false;
            }
            BackgroundConfigBean backgroundConfigBean = (BackgroundConfigBean) other;
            return Intrinsics.areEqual(this.imagePath, backgroundConfigBean.imagePath) && this.isDark == backgroundConfigBean.isDark && this.hideGroups == backgroundConfigBean.hideGroups;
        }
    }

    static /* synthetic */ boolean l(PortalStoreBrandUIHelper portalStoreBrandUIHelper, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return portalStoreBrandUIHelper.k(str, z16);
    }

    public static /* synthetic */ void h(PortalStoreBrandUIHelper portalStoreBrandUIHelper, String str, int i3, boolean z16, String str2, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        if ((i16 & 8) != 0) {
            str2 = com.tencent.open.base.g.d(str);
            Intrinsics.checkNotNullExpressionValue(str2, "toMD5(path)");
        }
        portalStoreBrandUIHelper.g(str, i3, z16, str2);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b%\u0010&J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper$b;", "Lqb3/b;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "filePath", "Lnx4/a$b;", "result", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "urlRspInfo", "", "b", "", "progress", "", "writtenBytes", "totalBytes", "onDownloadProgress", "errorCode", "errorMessage", "onDownloadFailed", "a", "I", "isDark", "", "Z", "hideGroups", "c", "Ljava/lang/String;", "brandId", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "uiHelperReference", "uiHelper", "<init>", "(IZLjava/lang/String;Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements qb3.b {

        /* renamed from: a, reason: from kotlin metadata */
        private final int isDark;

        /* renamed from: b, reason: from kotlin metadata */
        private final boolean hideGroups;

        /* renamed from: c, reason: from kotlin metadata */
        private final String brandId;

        /* renamed from: d, reason: from kotlin metadata */
        private final WeakReference<PortalStoreBrandUIHelper> uiHelperReference;

        public b(int i3, boolean z16, String str, PortalStoreBrandUIHelper uiHelper) {
            Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
            this.isDark = i3;
            this.hideGroups = z16;
            this.brandId = str;
            this.uiHelperReference = new WeakReference<>(uiHelper);
        }

        @Override // qb3.b
        public void a(int errorCode, String errorMessage) {
            QLog.e("PortalStoreBrandUIHelper_", 1, "getDownload url failed " + errorCode + ", " + errorMessage);
        }

        @Override // qb3.b
        public void b(int r16, String filePath, a.b result, ZPlanResDownloadUrlRsp urlRspInfo) {
            Intrinsics.checkNotNullParameter(urlRspInfo, "urlRspInfo");
            if (filePath == null) {
                filePath = "";
            }
            BackgroundConfigBean backgroundConfigBean = new BackgroundConfigBean(filePath, this.isDark, this.hideGroups);
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(PortalStoreBrandUIHelper.INSTANCE.a(this.brandId), backgroundConfigBean.toJson());
            PortalStoreBrandUIHelper portalStoreBrandUIHelper = this.uiHelperReference.get();
            if (portalStoreBrandUIHelper != null) {
                portalStoreBrandUIHelper.configBean = backgroundConfigBean;
            }
            QLog.d("PortalStoreBrandUIHelper_", 1, "background download success => " + backgroundConfigBean);
            PortalStoreBrandUIHelper portalStoreBrandUIHelper2 = this.uiHelperReference.get();
            if (portalStoreBrandUIHelper2 != null) {
                portalStoreBrandUIHelper2.j(backgroundConfigBean);
            }
        }

        @Override // qb3.b
        public void onDownloadFailed(int errorCode, String errorMessage) {
            QLog.e("PortalStoreBrandUIHelper_", 1, "download Failed " + errorCode + ", " + errorMessage);
        }

        @Override // qb3.b
        public void onDownloadProgress(float progress, long writtenBytes, long totalBytes) {
        }
    }
}
