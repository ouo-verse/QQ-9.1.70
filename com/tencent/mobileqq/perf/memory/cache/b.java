package com.tencent.mobileqq.perf.memory.cache;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.cache.core.manager.api.c;
import com.tencent.cache.core.manager.api.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoDeclare;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import cooperation.qzone.QZoneClickReport;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR2\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R2\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/cache/b;", "", "", "d", "Lcom/tencent/mobileqq/perf/memory/cache/a;", "listener", "c", "f", "e", "", "b", "Ljava/util/Set;", "listeners", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "businessToResidentCache", "businessToFixedCache", "com/tencent/mobileqq/perf/memory/cache/b$b", "Lcom/tencent/mobileqq/perf/memory/cache/b$b;", "logProxy", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f257663a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<com.tencent.mobileqq.perf.memory.cache.a> listeners;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoDeclare(configPath = "AutoInjectYml/Foundation/QQPerf/Inject_MemoryControl.yml", version = 1)
    @NotNull
    private static HashMap<String, String> businessToResidentCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoDeclare(configPath = "AutoInjectYml/Foundation/QQPerf/Inject_MemoryControl.yml", version = 1)
    @NotNull
    private static HashMap<String, String> businessToFixedCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C8199b logProxy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J4\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\rH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/perf/memory/cache/b$a", "Lcom/tencent/cache/core/manager/api/b;", "Landroid/content/Context;", "getAppContext", "Lcom/tencent/cache/core/manager/api/ClearMode;", "clearMode", "", "targetRatio", "", "a", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "d", "", "level", "onTrimMemory", "key", "b", "value", "c", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.cache.core.manager.api.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.cache.core.manager.api.b
        public void a(@NotNull ClearMode clearMode, float targetRatio) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, clearMode, Float.valueOf(targetRatio));
                return;
            }
            Intrinsics.checkNotNullParameter(clearMode, "clearMode");
            synchronized (b.listeners) {
                Iterator it = b.listeners.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mobileqq.perf.memory.cache.a) it.next()).onClear(clearMode, targetRatio);
                }
                Unit unit = Unit.INSTANCE;
            }
            b.f257663a.d();
        }

        @Override // com.tencent.cache.core.manager.api.b
        @NotNull
        public String b(@NotNull String key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key);
            }
            Intrinsics.checkNotNullParameter(key, "key");
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            String decodeString = from.decodeString(key, "");
            Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(key, \"\")");
            return decodeString;
        }

        @Override // com.tencent.cache.core.manager.api.b
        public void c(@NotNull String key, @NotNull String value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) value);
                return;
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.encodeString(key, value);
        }

        @Override // com.tencent.cache.core.manager.api.b
        public void d(@NotNull String eventName, @NotNull HashMap<String, String> params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) eventName, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            if (Intrinsics.areEqual(MobileQQ.processName, MobileQQ.PACKAGE_NAME)) {
                params.put("coldStartStage", String.valueOf(com.tencent.mobileqq.startup.b.f289681a.a()));
                StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, eventName, true, 0L, 0L, params, "");
            }
        }

        @Override // com.tencent.cache.core.manager.api.b
        @NotNull
        public Context getAppContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            return context;
        }

        @Override // com.tencent.cache.core.manager.api.b
        public void onTrimMemory(int level) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, level);
                return;
            }
            Iterator it = b.listeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.perf.memory.cache.a) it.next()).onTrimMemory(level);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/perf/memory/cache/b$b", "Lcom/tencent/cache/core/manager/api/d;", "", "tag", "msg", "", "d", "e", "", ReportConstant.COSTREPORT_TRANS, "i", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.memory.cache.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8199b implements d {
        static IPatchRedirector $redirector_;

        C8199b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void d(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isDevelopLevel()) {
                QLog.d(tag, 4, msg2);
            }
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void e(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, 1, msg2);
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void i(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(tag, 1, msg2);
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void e(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, tag, msg2, tr5);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(tr5, "tr");
            QLog.e(tag, 1, msg2, tr5);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30234);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f257663a = new b();
        Set<com.tencent.mobileqq.perf.memory.cache.a> synchronizedSet = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(synchronizedSet, "synchronizedSet(mutableSetOf())");
        listeners = synchronizedSet;
        HashMap<String, String> hashMap = new HashMap<>();
        businessToResidentCache = hashMap;
        hashMap.put("Default", "freesia;InputMethodManagerLeak;DisplayManagerLeak;MemoryCollect");
        businessToResidentCache.put("Guild", "GuildHotFeedCache");
        businessToResidentCache.put("QZone", "FeedDataNickNameHelper");
        businessToResidentCache.put(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "AIORecycleViewPool;TroopMembers;TroopMemberExt;TroopMemberUin;TroopMemberUid");
        businessToResidentCache.put("Conversation", "TempChatInfo");
        HashMap<String, String> hashMap2 = new HashMap<>();
        businessToFixedCache = hashMap2;
        hashMap2.put("Album", "albumToLocalMedia;localMedias;idToLocalMedia");
        businessToFixedCache.put(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "ShowExternalTroop;RoamSetting;TroopRoamSetting");
        businessToFixedCache.put("Conversation", "DiscussionInfo;FiendExtensionInfo;ShieldListInfo;ConversationMsgInfo;ConversationRefreshAction;ConversationInfo;TroopInfo;commonlyUsedTroop");
        logProxy = new C8199b();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        long j3;
        uy3.b.a(MobileQQ.class.getClassLoader());
        try {
            Object[] releasePreloadDrawableCache = SkinEngine.getInstances().releasePreloadDrawableCache();
            if (releasePreloadDrawableCache.length >= 2) {
                int i3 = 0;
                Object obj = releasePreloadDrawableCache[0];
                if (obj instanceof Integer) {
                    i3 = Integer.parseInt(obj.toString());
                }
                Object obj2 = releasePreloadDrawableCache[1];
                if (obj2 instanceof Long) {
                    j3 = Long.parseLong(obj2.toString());
                } else {
                    j3 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("MemoryControl_CacheManagerProxy", 2, "SkinEngine releasePreloadDrawableCache, count:" + i3 + ", size:" + j3);
                }
            }
        } catch (Exception e16) {
            QLog.i("MemoryControl_CacheManagerProxy", 1, "releasePreloadDrawableCache fail, " + e16.getMessage());
        }
    }

    public final void c(@NotNull com.tencent.mobileqq.perf.memory.cache.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (listeners.add(listener)) {
            QLog.i("MemoryControl_CacheManagerProxy", 1, "addListener, " + listener);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        c cVar = c.f98725d;
        cVar.l(QLog.getUIN_REPORTLOG_LEVEL(), logProxy);
        cVar.i(com.tencent.mobileqq.perf.process.config.c.INSTANCE.b().c());
        cVar.m(businessToResidentCache);
        cVar.k(businessToFixedCache);
        cVar.j(new a());
    }

    public final void f(@NotNull com.tencent.mobileqq.perf.memory.cache.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (listeners.remove(listener)) {
            QLog.i("MemoryControl_CacheManagerProxy", 1, "removeListener, " + listener);
        }
    }
}
