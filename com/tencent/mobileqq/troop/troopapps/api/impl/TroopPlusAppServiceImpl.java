package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService;
import com.tencent.mobileqq.troop.troopapps.data.PlusPanelAppsInfo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.AppListAppInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAppListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAppListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetAppListCallback;
import com.tencent.qqnt.pluspanel.utils.a;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.ab;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\"\u0018\u0000 '2\u00020\u0001:\u0002()B\u0007\u00a2\u0006\u0004\b%\u0010&J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0004H\u0016R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl;", "Lcom/tencent/mobileqq/troop/troopapps/api/ITroopPlusAppService;", "", "mode", "", "serverTime", NotifyMsgApiImpl.KEY_GROUP_TYPE, "Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$AppInfoCacheBean;", "appInfoCacheBean", "", "isCacheValid", "(IJLjava/lang/Long;Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$AppInfoCacheBean;)Z", "troopUin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDefaultApps", "getCurrentMode", "", "initTroopInfoObserver", "unInitTroopInfoObserver", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isMoreListSwitchOn", "Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "getAppsFromCache", "Lcom/tencent/mobileqq/troop/troopapps/api/ITroopPlusAppService$a;", "callback", "getAppsAsync", "initPlusAppsCache", "Landroidx/collection/LruCache;", "cacheMap", "Landroidx/collection/LruCache;", "com/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$c", "troopInfoObserver", "Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$c;", "<init>", "()V", "Companion", "AppInfoCacheBean", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopPlusAppServiceImpl implements ITroopPlusAppService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int ERR_CODE_TROOP_INFO_NOT_FOUND = -1;
    private static final int MAX_CACHE_SIZE = 20;

    @NotNull
    private static final String MMKV_KEY_PREFIX = "troop_plus_panel_apps_";

    @NotNull
    public static final String TAG = "TroopPlusAppServiceImpl";

    @NotNull
    private final LruCache<Long, AppInfoCacheBean> cacheMap;

    @NotNull
    private final c troopInfoObserver;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\tH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$AppInfoCacheBean;", "Ljava/io/Serializable;", "", "toString", "toJson", "Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "component1", "", "component2", "", "component3", "appInfo", "mode", NotifyMsgApiImpl.KEY_GROUP_TYPE, "copy", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "getAppInfo", "()Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "I", "getMode", "()I", "J", "getGroupType", "()J", "<init>", "(Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;IJ)V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class AppInfoCacheBean implements Serializable {
        static IPatchRedirector $redirector_;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @NotNull
        private final PlusPanelAppsInfo appInfo;
        private final long groupType;
        private final int mode;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$AppInfoCacheBean$a;", "", "", "jsonString", "Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$AppInfoCacheBean;", "a", "JSON_KEY_APP_INFO", "Ljava/lang/String;", "JSON_KEY_GROUP_TYPE", "JSON_KEY_MODE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopapps.api.impl.TroopPlusAppServiceImpl$AppInfoCacheBean$a, reason: from kotlin metadata */
        /* loaded from: classes19.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @Nullable
            public final AppInfoCacheBean a(@Nullable String jsonString) {
                PlusPanelAppsInfo a16;
                int i3;
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (AppInfoCacheBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonString);
                }
                if (TextUtils.isEmpty(jsonString)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(jsonString);
                    if (!jSONObject.has(j.T0) || !jSONObject.has("mode") || (a16 = PlusPanelAppsInfo.INSTANCE.a(jSONObject.getString(j.T0))) == null) {
                        return null;
                    }
                    if (jSONObject.has("mode")) {
                        i3 = jSONObject.getInt("mode");
                    } else {
                        i3 = 0;
                    }
                    if (jSONObject.has("group_type")) {
                        j3 = jSONObject.getLong("group_type");
                    } else {
                        j3 = 0;
                    }
                    return new AppInfoCacheBean(a16, i3, j3);
                } catch (JSONException e16) {
                    QLog.e(TroopPlusAppServiceImpl.TAG, 1, "[fromJson] exception: " + e16, e16);
                    return null;
                }
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56532);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 13)) {
                redirector.redirect((short) 13);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public AppInfoCacheBean(@NotNull PlusPanelAppsInfo appInfo, int i3, long j3) {
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appInfo, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            this.appInfo = appInfo;
            this.mode = i3;
            this.groupType = j3;
        }

        public static /* synthetic */ AppInfoCacheBean copy$default(AppInfoCacheBean appInfoCacheBean, PlusPanelAppsInfo plusPanelAppsInfo, int i3, long j3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                plusPanelAppsInfo = appInfoCacheBean.appInfo;
            }
            if ((i16 & 2) != 0) {
                i3 = appInfoCacheBean.mode;
            }
            if ((i16 & 4) != 0) {
                j3 = appInfoCacheBean.groupType;
            }
            return appInfoCacheBean.copy(plusPanelAppsInfo, i3, j3);
        }

        @NotNull
        public final PlusPanelAppsInfo component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (PlusPanelAppsInfo) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.appInfo;
        }

        public final int component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.mode;
        }

        public final long component3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
            }
            return this.groupType;
        }

        @NotNull
        public final AppInfoCacheBean copy(@NotNull PlusPanelAppsInfo appInfo, int mode, long groupType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (AppInfoCacheBean) iPatchRedirector.redirect((short) 10, this, appInfo, Integer.valueOf(mode), Long.valueOf(groupType));
            }
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            return new AppInfoCacheBean(appInfo, mode, groupType);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppInfoCacheBean)) {
                return false;
            }
            AppInfoCacheBean appInfoCacheBean = (AppInfoCacheBean) other;
            if (Intrinsics.areEqual(this.appInfo, appInfoCacheBean.appInfo) && this.mode == appInfoCacheBean.mode && this.groupType == appInfoCacheBean.groupType) {
                return true;
            }
            return false;
        }

        @NotNull
        public final PlusPanelAppsInfo getAppInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PlusPanelAppsInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.appInfo;
        }

        public final long getGroupType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.groupType;
        }

        public final int getMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.mode;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return (((this.appInfo.hashCode() * 31) + this.mode) * 31) + androidx.fragment.app.a.a(this.groupType);
        }

        @NotNull
        public final String toJson() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(j.T0, this.appInfo.toJson());
            jSONObject.put("mode", this.mode);
            jSONObject.put("group_type", this.groupType);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
            return jSONObject2;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return toJson();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$a;", "", "", "ERR_CODE_TROOP_INFO_NOT_FOUND", "I", "MAX_CACHE_SIZE", "", "MMKV_KEY_PREFIX", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopapps.api.impl.TroopPlusAppServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$b", "Lcom/tencent/mobileqq/troop/troopapps/api/ITroopPlusAppService$a;", "", "errCode", "", "errMsg", "Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "apps", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ITroopPlusAppService.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService.a
        public void a(int errCode, @NotNull String errMsg, @NotNull PlusPanelAppsInfo apps) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errCode), errMsg, apps);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(apps, "apps");
            QLog.i(TroopPlusAppServiceImpl.TAG, 1, "initPlusAppsCache getAppsAsync code:" + errCode + ", msg:" + errMsg);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopapps/api/impl/TroopPlusAppServiceImpl$c", "Lcom/tencent/qqnt/troop/ab;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements ab {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPlusAppServiceImpl.this);
            }
        }

        @Override // com.tencent.qqnt.troop.ab
        public void a(@NotNull TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            String troopUin = troopInfo.getTroopUin();
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
            long parseLong = Long.parseLong(troopUin);
            AppInfoCacheBean appInfoCacheBean = (AppInfoCacheBean) TroopPlusAppServiceImpl.this.cacheMap.get(Long.valueOf(parseLong));
            if (appInfoCacheBean != null) {
                if (!TroopPlusAppServiceImpl.this.isCacheValid(TroopPlusAppServiceImpl.this.getCurrentMode(), NetConnInfoCenter.getServerTime(), Long.valueOf(troopInfo.dwGroupClassExt), appInfoCacheBean)) {
                    QLog.i(TroopPlusAppServiceImpl.TAG, 1, "[onTroopInfoChanged] groupType:" + troopInfo.dwGroupClassExt);
                    TroopPlusAppServiceImpl.this.initPlusAppsCache(parseLong);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56536);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopPlusAppServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cacheMap = new LruCache<>(20);
            this.troopInfoObserver = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAppsAsync$lambda$4(int i3, TroopInfo troopInfo, TroopPlusAppServiceImpl this$0, final long j3, ITroopPlusAppService.a callback, int i16, String errMsg, GetAppListRsp getAppListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i(TAG, 1, "[getAppsAsync] code: " + i16 + ", msg: " + errMsg + ", appList: " + getAppListRsp.getAppList().size() + ", moreList: " + getAppListRsp.getMoreList().size() + ", expiry:" + getAppListRsp.getCacheInterval());
        if (i16 == 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList<AppListAppInfo> appList = getAppListRsp.getAppList();
            Intrinsics.checkNotNullExpressionValue(appList, "rsp.getAppList()");
            Iterator<T> it = appList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((AppListAppInfo) it.next()).getAppid()));
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList<AppListAppInfo> moreList = getAppListRsp.getMoreList();
            Intrinsics.checkNotNullExpressionValue(moreList, "rsp.getMoreList()");
            Iterator<T> it5 = moreList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(Integer.valueOf(((AppListAppInfo) it5.next()).getAppid()));
            }
            PlusPanelAppsInfo plusPanelAppsInfo = new PlusPanelAppsInfo(arrayList, arrayList2, NetConnInfoCenter.getServerTime() + getAppListRsp.getCacheInterval());
            final AppInfoCacheBean appInfoCacheBean = new AppInfoCacheBean(plusPanelAppsInfo, i3, troopInfo.dwGroupClassExt);
            this$0.cacheMap.put(Long.valueOf(j3), appInfoCacheBean);
            QLog.d(TAG, 4, "cache info. size:" + this$0.cacheMap.size());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    TroopPlusAppServiceImpl.getAppsAsync$lambda$4$lambda$3(j3, appInfoCacheBean);
                }
            }, 64, null, true);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            callback.a(i16, errMsg, plusPanelAppsInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAppsAsync$lambda$4$lambda$3(long j3, AppInfoCacheBean localInfo) {
        Intrinsics.checkNotNullParameter(localInfo, "$localInfo");
        com.tencent.mobileqq.troop.config.a.z(com.tencent.mobileqq.troop.config.a.f294689a, MMKV_KEY_PREFIX + j3, localInfo.toJson(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentMode() {
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
            return 2;
        }
        if (((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).getSimpleUISwitch()) {
            return 1;
        }
        if (SimpleUIUtil.isNowElderMode()) {
            return 3;
        }
        return 0;
    }

    private final ArrayList<Integer> getDefaultApps(long troopUin) {
        boolean simpleUISwitch = ((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).getSimpleUISwitch();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (simpleUISwitch) {
            a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
            arrayList.add(Integer.valueOf(companion.f0()));
            arrayList.add(Integer.valueOf(companion.j0()));
        }
        a.Companion companion2 = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        arrayList.add(Integer.valueOf(companion2.c0()));
        arrayList.add(Integer.valueOf(companion2.e0()));
        arrayList.add(Integer.valueOf(companion2.Y()));
        arrayList.add(Integer.valueOf(companion2.Q()));
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(troopUin));
        boolean z16 = false;
        if (troopInfoFromCache != null && troopInfoFromCache.isHomeworkTroop()) {
            z16 = true;
        }
        if (z16) {
            arrayList.add(Integer.valueOf(companion2.U()));
        }
        arrayList.add(Integer.valueOf(companion2.r0()));
        arrayList.add(Integer.valueOf(companion2.M()));
        if (!((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
            arrayList.add(Integer.valueOf(companion2.u0()));
        }
        arrayList.add(Integer.valueOf(companion2.v0()));
        return arrayList;
    }

    private final void initTroopInfoObserver() {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(null, this.troopInfoObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCacheValid(int mode, long serverTime, Long groupType, AppInfoCacheBean appInfoCacheBean) {
        QLog.d(TAG, 4, "[isCacheValid] mode:" + mode + ", serverTime:" + serverTime + ", groupType:" + groupType + ", appInfoCacheBean:" + appInfoCacheBean);
        if (appInfoCacheBean == null || mode != appInfoCacheBean.getMode()) {
            return false;
        }
        long groupType2 = appInfoCacheBean.getGroupType();
        if (groupType == null || groupType.longValue() != groupType2 || appInfoCacheBean.getAppInfo().getCacheExpiryTime() <= serverTime) {
            return false;
        }
        return true;
    }

    private final void unInitTroopInfoObserver() {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.troopInfoObserver);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService
    public void getAppsAsync(final long troopUin, @NotNull final ITroopPlusAppService.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(troopUin), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(String.valueOf(troopUin));
        if (troopInfoFromCache == null) {
            QLog.w(TAG, 1, "[getAppsAsync] troopInfo is null");
            callback.a(-1, "troop info not found", new PlusPanelAppsInfo(getDefaultApps(troopUin), null, 0L, 2, null));
            return;
        }
        final int currentMode = getCurrentMode();
        s i3 = bg.i(null, 1, null);
        GetAppListReq getAppListReq = new GetAppListReq();
        getAppListReq.groupId = troopUin;
        getAppListReq.groupType = (int) troopInfoFromCache.dwGroupClassExt;
        getAppListReq.mode = currentMode;
        if (i3 != null) {
            i3.getGroupPlusAppList(getAppListReq, new IGetAppListCallback() { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAppListCallback
                public final void onResult(int i16, String str, GetAppListRsp getAppListRsp) {
                    TroopPlusAppServiceImpl.getAppsAsync$lambda$4(currentMode, troopInfoFromCache, this, troopUin, callback, i16, str, getAppListRsp);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService
    @NotNull
    public PlusPanelAppsInfo getAppsFromCache(long troopUin) {
        Long l3;
        Long l16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (PlusPanelAppsInfo) iPatchRedirector.redirect((short) 5, (Object) this, troopUin);
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        int currentMode = getCurrentMode();
        AppInfoCacheBean appInfoCacheBean = this.cacheMap.get(Long.valueOf(troopUin));
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(String.valueOf(troopUin));
        QLog.d(TAG, 4, "[getAppsFromCache] memory: " + appInfoCacheBean);
        if (appInfoCacheBean != null) {
            if (troopInfoFromCache != null) {
                l16 = Long.valueOf(troopInfoFromCache.dwGroupClassExt);
            } else {
                l16 = null;
            }
            if (isCacheValid(currentMode, serverTime, l16, appInfoCacheBean)) {
                QLog.d(TAG, 4, "getAppsFromCache return from cache:" + appInfoCacheBean);
                return appInfoCacheBean.getAppInfo();
            }
        }
        String n3 = com.tencent.mobileqq.troop.config.a.n(com.tencent.mobileqq.troop.config.a.f294689a, MMKV_KEY_PREFIX + troopUin, "", false, 4, null);
        QLog.i(TAG, 1, "[getAppsFromCache] mmkv value: " + n3);
        if (!TextUtils.isEmpty(n3)) {
            AppInfoCacheBean a16 = AppInfoCacheBean.INSTANCE.a(n3);
            QLog.d(TAG, 4, "[getAppsFromCache] mmkv localInfo:" + a16);
            if (a16 != null) {
                if (troopInfoFromCache != null) {
                    l3 = Long.valueOf(troopInfoFromCache.dwGroupClassExt);
                } else {
                    l3 = null;
                }
                if (isCacheValid(currentMode, serverTime, l3, a16)) {
                    this.cacheMap.put(Long.valueOf(troopUin), a16);
                    QLog.d(TAG, 4, "cache info. size:" + this.cacheMap.size());
                    QLog.d(TAG, 4, "getAppsFromCache return from mmkv:" + a16);
                    return a16.getAppInfo();
                }
            }
        }
        return new PlusPanelAppsInfo(getDefaultApps(troopUin), null, 0L, 2, null);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService
    public void initPlusAppsCache(long troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, troopUin);
        } else {
            if (getAppsFromCache(troopUin).getCacheExpiryTime() != 0) {
                return;
            }
            getAppsAsync(troopUin, new b());
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService
    public boolean isMoreListSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105913", false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            initTroopInfoObserver();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.cacheMap.evictAll();
            unInitTroopInfoObserver();
        }
    }
}
