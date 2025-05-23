package com.tencent.mobileqq.leba.data;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dBs\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/leba/data/b;", "Lcom/tencent/freesia/IConfigData;", "Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;", "pluginInfo", "", "e", "d", "f", "", "Z", "b", "()Z", "enable", "c", "isDefaultConfig", "", "", "", "Ljava/util/Map;", "nameMap", tl.h.F, "simpleNameMap", "i", "iconMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "simpleIconMap", "<init>", "(ZZLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean enable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isDefaultConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, String> nameMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, String> simpleNameMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, String> iconMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, String> simpleIconMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/leba/data/b$a;", "", "Lcom/tencent/mobileqq/leba/data/b;", "b", "a", "", "TAG", "Ljava/lang/String;", "UNITED_CONFIG_LEBA_PATCH_RESOURCE", "UNITED_CONFIG_LEBA_PATCH_SWITCH", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.data.b$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

        private final b b() {
            Map mapOf;
            Map map;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(10000L, "https://static-res.qq.com/static-res/dongtai/20250327/qzone.png"), TuplesKt.to(4045L, "https://static-res.qq.com/static-res/dongtai/20250327/qcircle.png"), TuplesKt.to(785L, "https://static-res.qq.com/static-res/dongtai/20250327/albums.png"), TuplesKt.to(4036L, "https://static-res.qq.com/static-res/dongtai/20250327/reading.png"), TuplesKt.to(489L, "https://static-res.qq.com/static-res/dongtai/20250327/game_center.png"), TuplesKt.to(4038L, "https://static-res.qq.com/static-res/dongtai/20250327/meet.png"), TuplesKt.to(4050L, "https://static-res.qq.com/static-res/dongtai/20250327/meet.png"), TuplesKt.to(769L, "https://static-res.qq.com/static-res/dongtai/20250327/book.png"), TuplesKt.to(1113L, "https://static-res.qq.com/static-res/dongtai/20250327/volatile_comic.png"), TuplesKt.to(4048L, "https://static-res.qq.com/static-res/dongtai/20250327/dreamstar.png"), TuplesKt.to(3053L, "https://static-res.qq.com/static-res/dongtai/20250327/shopping.png"), TuplesKt.to(4559L, "https://static-res.qq.com/static-res/dongtai/20250327/sport.png"), TuplesKt.to(879L, "https://static-res.qq.com/static-res/dongtai/20250327/live.png"), TuplesKt.to(4049L, "https://static-res.qq.com/static-res/dongtai/20250327/qqcards.png"), TuplesKt.to(7966L, "https://static-res.qq.com/static-res/dongtai/20250327/wesee.png"), TuplesKt.to(7102L, "https://static-res.qq.com/static-res/dongtai/20250327/tencent_news.png"), TuplesKt.to(4035L, "https://static-res.qq.com/static-res/dongtai/20250327/tencent_video.png"), TuplesKt.to(4028L, "https://static-res.qq.com/static-res/dongtai/20250327/tencent_doc.png"), TuplesKt.to(795L, "https://static-res.qq.com/static-res/dongtai/20250327/yingyongbao.png"), TuplesKt.to(4037L, "https://static-res.qq.com/static-res/dongtai/20250327/yellowvip.png"), TuplesKt.to(4039L, "https://static-res.qq.com/static-res/dongtai/20250327/vip.png"), TuplesKt.to(777L, "https://static-res.qq.com/static-res/dongtai/20250327/feadback.png"), TuplesKt.to(1047L, "https://static-res.qq.com/static-res/dongtai/20250327/music.png"), TuplesKt.to(4031L, "https://static-res.qq.com/static-res/dongtai/20250327/wesing.png"), TuplesKt.to(8059L, "https://static-res.qq.com/static-res/dongtai/20250327/minigame.png"));
            map = MapsKt__MapsKt.toMap(mapOf);
            return new b(true, true, null, null, mapOf, map, 12, null);
        }

        @JvmStatic
        @NotNull
        public final b a() {
            boolean z16;
            String readText$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) api;
            if (!iUnitedConfigManager.isSwitchOn("leba_patch_config", true)) {
                return new b(false, false, null, null, null, null, 60, null);
            }
            String resourcePath = iUnitedConfigManager.getResourcePath("leba_plugin_data_patch");
            boolean z17 = false;
            if (resourcePath != null && resourcePath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.e("LebaPluginPatchConfig", 1, "build config error. resource path is null or empty");
                return b();
            }
            File file = new File(resourcePath);
            if (file.exists()) {
                try {
                    readText$default = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
                    if (readText$default.length() == 0) {
                        z17 = true;
                    }
                    if (z17) {
                        QLog.e("LebaPluginPatchConfig", 1, "build config error. resource file content is empty. path: " + resourcePath);
                        return b();
                    }
                    JSONObject jSONObject = new JSONObject(readText$default);
                    HashMap hashMap = new HashMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject("name");
                    if (optJSONObject != null) {
                        Iterator keys = optJSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
                        while (keys.hasNext()) {
                            String key = (String) keys.next();
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            Long valueOf = Long.valueOf(Long.parseLong(key));
                            String string = optJSONObject.getString(key);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(key)");
                            hashMap.put(valueOf, string);
                        }
                    }
                    HashMap hashMap2 = new HashMap();
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("simpleName");
                    if (optJSONObject2 != null) {
                        Iterator keys2 = optJSONObject2.keys();
                        Intrinsics.checkNotNullExpressionValue(keys2, "keys()");
                        while (keys2.hasNext()) {
                            String key2 = (String) keys2.next();
                            Intrinsics.checkNotNullExpressionValue(key2, "key");
                            Long valueOf2 = Long.valueOf(Long.parseLong(key2));
                            String string2 = optJSONObject2.getString(key2);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(key)");
                            hashMap2.put(valueOf2, string2);
                        }
                    }
                    HashMap hashMap3 = new HashMap();
                    JSONObject optJSONObject3 = jSONObject.optJSONObject("icon");
                    if (optJSONObject3 != null) {
                        Iterator keys3 = optJSONObject3.keys();
                        Intrinsics.checkNotNullExpressionValue(keys3, "keys()");
                        while (keys3.hasNext()) {
                            String key3 = (String) keys3.next();
                            Intrinsics.checkNotNullExpressionValue(key3, "key");
                            Long valueOf3 = Long.valueOf(Long.parseLong(key3));
                            String string3 = optJSONObject3.getString(key3);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(key)");
                            hashMap3.put(valueOf3, string3);
                        }
                    }
                    HashMap hashMap4 = new HashMap();
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("simpleIcon");
                    if (optJSONObject4 != null) {
                        Iterator keys4 = optJSONObject4.keys();
                        Intrinsics.checkNotNullExpressionValue(keys4, "keys()");
                        while (keys4.hasNext()) {
                            String key4 = (String) keys4.next();
                            Intrinsics.checkNotNullExpressionValue(key4, "key");
                            Long valueOf4 = Long.valueOf(Long.parseLong(key4));
                            String string4 = optJSONObject4.getString(key4);
                            Intrinsics.checkNotNullExpressionValue(string4, "getString(key)");
                            hashMap4.put(valueOf4, string4);
                        }
                    }
                    return new b(true, false, hashMap, hashMap2, hashMap3, hashMap4);
                } catch (Exception e16) {
                    QLog.e("LebaPluginPatchConfig", 1, "parse json error", e16);
                    return b();
                }
            }
            QLog.e("LebaPluginPatchConfig", 1, "build config error. resource file not exist. path: " + file.getAbsolutePath());
            return b();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17573);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        this(false, false, null, null, null, null, 63, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @JvmStatic
    @NotNull
    public static final b a() {
        return INSTANCE.a();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isDefaultConfig;
    }

    public final void d(@Nullable LebaPluginInfo pluginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pluginInfo);
            return;
        }
        if (this.enable && pluginInfo != null) {
            long j3 = pluginInfo.uiResId;
            String str = this.iconMap.get(Long.valueOf(j3));
            if (str != null) {
                pluginInfo.strResURL = str;
            }
            String str2 = this.simpleIconMap.get(Long.valueOf(j3));
            if (str2 != null) {
                pluginInfo.strSimpleResUrl = str2;
            }
        }
    }

    public final void e(@Nullable LebaPluginInfo pluginInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pluginInfo);
            return;
        }
        if (this.enable && pluginInfo != null) {
            long j3 = pluginInfo.uiResId;
            String str = this.nameMap.get(Long.valueOf(j3));
            if (str != null) {
                pluginInfo.strResName = str;
            }
            String str2 = this.simpleNameMap.get(Long.valueOf(j3));
            if (str2 != null) {
                String str3 = pluginInfo.resConf;
                if (str3 != null && str3.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    try {
                        JSONObject jSONObject = new JSONObject(pluginInfo.resConf);
                        if (jSONObject.has(LebaPluginInfo.EXT_CONF_SIMPLE_MODE_NAME)) {
                            jSONObject.put(LebaPluginInfo.EXT_CONF_SIMPLE_MODE_NAME, str2);
                        }
                        pluginInfo.resConf = jSONObject.toString();
                    } catch (Exception e16) {
                        QLog.e("LebaPluginPatchConfig", 1, "pluginInfoPatch simpleName exception", e16);
                    }
                }
            }
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enable: " + this.enable + "\n");
            sb5.append("nameMap[");
            sb5.append(this.nameMap.size());
            sb5.append("]\n");
            for (Map.Entry<Long, String> entry : this.nameMap.entrySet()) {
                sb5.append(entry.getKey().longValue());
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(entry.getValue());
                sb5.append("\n");
            }
            sb5.append("simpleNameMap[");
            sb5.append(this.simpleNameMap.size());
            sb5.append("]\n");
            for (Map.Entry<Long, String> entry2 : this.simpleNameMap.entrySet()) {
                sb5.append(entry2.getKey().longValue());
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(entry2.getValue());
                sb5.append("\n");
            }
            sb5.append("iconMap[");
            sb5.append(this.iconMap.size());
            sb5.append("]\n");
            for (Map.Entry<Long, String> entry3 : this.iconMap.entrySet()) {
                sb5.append(entry3.getKey().longValue());
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(entry3.getValue());
                sb5.append("\n");
            }
            sb5.append("simpleIconMap[");
            sb5.append(this.simpleIconMap.size());
            sb5.append("]\n");
            for (Map.Entry<Long, String> entry4 : this.simpleIconMap.entrySet()) {
                sb5.append(entry4.getKey().longValue());
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(entry4.getValue());
                sb5.append("\n");
            }
            QLog.d("LebaPluginPatchConfig", 1, sb5.toString());
        }
    }

    public b(boolean z16, boolean z17, @NotNull Map<Long, String> nameMap, @NotNull Map<Long, String> simpleNameMap, @NotNull Map<Long, String> iconMap, @NotNull Map<Long, String> simpleIconMap) {
        Intrinsics.checkNotNullParameter(nameMap, "nameMap");
        Intrinsics.checkNotNullParameter(simpleNameMap, "simpleNameMap");
        Intrinsics.checkNotNullParameter(iconMap, "iconMap");
        Intrinsics.checkNotNullParameter(simpleIconMap, "simpleIconMap");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), nameMap, simpleNameMap, iconMap, simpleIconMap);
            return;
        }
        this.enable = z16;
        this.isDefaultConfig = z17;
        this.nameMap = nameMap;
        this.simpleNameMap = simpleNameMap;
        this.iconMap = iconMap;
        this.simpleIconMap = simpleIconMap;
    }

    public /* synthetic */ b(boolean z16, boolean z17, Map map, Map map2, Map map3, Map map4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? new HashMap() : map, (i3 & 8) != 0 ? new HashMap() : map2, (i3 & 16) != 0 ? new HashMap() : map3, (i3 & 32) != 0 ? new HashMap() : map4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), map, map2, map3, map4, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
