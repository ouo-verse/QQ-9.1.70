package com.tencent.mobileqq.pskey;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.pskey.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0006\u0010\u0019\u001a\u00020\u0004J.\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ#\u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u001c\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/pskey/PskeyLocalDataManager;", "", "Lsd2/b;", "listener", "", "j", "", DomainData.DOMAIN_NAME, "", "uin", "i", "", "domains", "", "Lcom/tencent/mobileqq/pskey/a;", "e", "g", "", "expiredTime", "domainToPskeyMap", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "domain", "b", "o", "f", "k", "", "d", "(Ljava/lang/String;[Ljava/lang/String;)V", tl.h.F, "Ljava/util/concurrent/ConcurrentMap;", "Lcom/tencent/mobileqq/pskey/g;", "a", "Ljava/util/concurrent/ConcurrentMap;", "mCacheMap", "J", "mLastCheckTimeStamp", "mLastSendBroadcastTimeStamp", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mBroadcastReceiver", "Lmqq/app/AppRuntime;", "app", "<init>", "(Lmqq/app/AppRuntime;Lsd2/b;)V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PskeyLocalDataManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentMap<String, g> mCacheMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mLastCheckTimeStamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mLastSendBroadcastTimeStamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BroadcastReceiver mBroadcastReceiver;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/pskey/PskeyLocalDataManager$a;", "", "", "b", "", "ACTION_REFRESH_CACHE", "Ljava/lang/String;", "CHECK_UPDATE_COOL_DOWN", "J", "EXPIRED_DURATION", "KEY_UIN", "MMKV_DOMAIN_LIST", "MMKV_NAME_PREFIX", "MMKV_PUSKEY_DOMAIN_LIST", "REPLACE_DURATION", "SEND_BROADCAST_COOL_DOWN", "TAG", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pskey.PskeyLocalDataManager$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final long b() {
            return System.currentTimeMillis() + 129600000;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35103);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PskeyLocalDataManager(@NotNull AppRuntime app, @NotNull sd2.b listener) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) listener);
            return;
        }
        this.mCacheMap = new ConcurrentHashMap();
        this.mContext = app.getApplicationContext();
        j(listener);
    }

    private final String b(String uin, String domain) {
        return uin + "_" + domain;
    }

    private final void c() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, g> entry : this.mCacheMap.entrySet()) {
            String uinAndDomain = entry.getKey();
            g pskey = entry.getValue();
            if (g.INSTANCE.c(pskey)) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("PskeyLocalDataManager", 4, "cleanInvalidPskey uinAndDomain = " + uinAndDomain + ", pskey is invalid");
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(uinAndDomain, "uinAndDomain");
                Intrinsics.checkNotNullExpressionValue(pskey, "pskey");
                concurrentHashMap.put(uinAndDomain, pskey);
            }
        }
        this.mCacheMap.clear();
        this.mCacheMap.putAll(concurrentHashMap);
    }

    private final Map<String, a> e(String uin, List<String> domains) {
        boolean z16;
        boolean z17;
        c();
        HashMap hashMap = new HashMap();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        Iterator<String> it = domains.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            g gVar = this.mCacheMap.get(b(uin, next));
            g.Companion companion = g.INSTANCE;
            if (companion.c(gVar)) {
                sb5.append(next + ",");
                hashMap.put(next, new a("", "", 3));
            } else if (companion.b(gVar)) {
                sb6.append(next + ",");
                hashMap.put(next, new a("", "", 2));
            } else {
                sb7.append(next + ",");
                Intrinsics.checkNotNull(gVar);
                hashMap.put(next, new a(gVar.c(), gVar.e(), 1));
            }
        }
        if (sb5.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && QLog.isDevelopLevel()) {
            QLog.d("PskeyLocalDataManager", 4, "getPskeyFromCache invalidList = [" + ((Object) sb5) + "]");
        }
        if (sb6.length() <= 0) {
            z16 = false;
        }
        if (z16 && QLog.isDevelopLevel()) {
            QLog.d("PskeyLocalDataManager", 4, "getPskeyFromCache expiredList = [" + ((Object) sb6) + "]");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PskeyLocalDataManager", 4, "getPskeyFromCache okList = [" + ((Object) sb7) + "]");
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String uin) {
        boolean z16;
        HashMap hashMap = new HashMap();
        try {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            Set<String> decodeStringSet = from.decodeStringSet("pskey_uksey_MmkvName_" + uin + "domainList", new HashSet());
            Intrinsics.checkNotNullExpressionValue(decodeStringSet, "mmkvEntity.decodeStringS\u2026t<String>()\n            )");
            StringBuilder sb5 = new StringBuilder();
            for (String str : decodeStringSet) {
                String pskeyEntryString = from.decodeString("pskey_uksey_MmkvName_" + str, "");
                if (TextUtils.isEmpty(pskeyEntryString)) {
                    sb5.append(str + ",");
                } else {
                    Intrinsics.checkNotNullExpressionValue(pskeyEntryString, "pskeyEntryString");
                    hashMap.put(str, pskeyEntryString);
                }
            }
            if (sb5.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && QLog.isDevelopLevel()) {
                QLog.d("PskeyLocalDataManager", 4, "pskeyEntryString emptyList = [" + ((Object) sb5) + "]");
            }
        } catch (Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.e("PskeyLocalDataManager", 4, th5, new Object[0]);
            }
        }
        StringBuilder sb6 = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            g.Companion companion = g.INSTANCE;
            g a16 = companion.a(str3);
            if (companion.c(a16)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("PskeyLocalDataManager", 4, "loadPskeyFromMmkvToCache uinAndDomain = " + str2 + ", pskey is invalid");
                }
            } else {
                this.mCacheMap.put(str2, a16);
                sb6.append(str2 + ",");
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PskeyLocalDataManager", 4, "loadPskeyFromMmkvToCache okList = [" + ((Object) sb6) + "]");
        }
        c();
    }

    private final void i(String uin) {
        Context context;
        if (!n() && (context = this.mContext) != null) {
            Intent intent = new Intent();
            intent.setAction("action_refresh_cache");
            intent.getData();
            intent.putExtra("uin", uin);
            context.sendBroadcast(intent);
        }
    }

    private final void j(final sd2.b listener) {
        synchronized (this) {
            QLog.d("PskeyLocalDataManager", 4, "registerBroadcastReceiver");
            o();
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver(listener) { // from class: com.tencent.mobileqq.pskey.PskeyLocalDataManager$registerBroadcastReceiver$1$1
                static IPatchRedirector $redirector_;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ sd2.b f261136b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f261136b = listener;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PskeyLocalDataManager.this, (Object) listener);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (intent != null) {
                        str = intent.getStringExtra("uin");
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        PskeyLocalDataManager pskeyLocalDataManager = PskeyLocalDataManager.this;
                        Intrinsics.checkNotNull(str);
                        pskeyLocalDataManager.g(str);
                        this.f261136b.a();
                    }
                }
            };
            this.mBroadcastReceiver = broadcastReceiver;
            Context context = this.mContext;
            if (context != null) {
                context.registerReceiver(broadcastReceiver, new IntentFilter("action_refresh_cache"));
            }
        }
    }

    private final void l(String uin, long expiredTime, Map<String, a> domainToPskeyMap) {
        if (QLog.isDevelopLevel()) {
            QLog.i("PskeyLocalDataManager", 4, "saveToCache, expiredTime = " + expiredTime);
        }
        for (Map.Entry<String, a> entry : domainToPskeyMap.entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            this.mCacheMap.put(b(uin, key), new g(uin, key, value.b(), value.c(), expiredTime));
        }
        c();
    }

    private final void m(String uin) {
        StringBuilder sb5 = new StringBuilder();
        try {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            Set<String> decodeStringSet = from.decodeStringSet("pskey_uksey_MmkvName_" + uin + "domainList", new HashSet());
            Intrinsics.checkNotNullExpressionValue(decodeStringSet, "mmkvEntity.decodeStringS\u2026_LIST, HashSet<String>())");
            for (Map.Entry<String, g> entry : this.mCacheMap.entrySet()) {
                String uinAndDomain = entry.getKey();
                String gVar = entry.getValue().toString();
                if (!TextUtils.isEmpty(gVar)) {
                    from.encodeString("pskey_uksey_MmkvName_" + uinAndDomain, gVar);
                    Intrinsics.checkNotNullExpressionValue(uinAndDomain, "uinAndDomain");
                    decodeStringSet.add(uinAndDomain);
                    sb5.append(uinAndDomain + ",");
                }
            }
            from.encodeStringSet("pskey_uksey_MmkvName_" + uin + "domainList", decodeStringSet).commitSync();
        } catch (Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.e("PskeyLocalDataManager", 4, th5, new Object[0]);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PskeyLocalDataManager", 4, "saveToMmkv okList = [" + ((Object) sb5) + "]");
        }
    }

    private final boolean n() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.mLastSendBroadcastTimeStamp + 20000) {
            return true;
        }
        this.mLastSendBroadcastTimeStamp = currentTimeMillis;
        return false;
    }

    public final void d(@NotNull String uin, @NotNull String[] domains) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin, (Object) domains);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(domains, "domains");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        StringBuilder sb5 = new StringBuilder();
        for (String str : domains) {
            String b16 = b(uin, str);
            this.mCacheMap.remove(b16);
            from.removeKey("pskey_uksey_MmkvName_" + b16);
            sb5.append(str + ",");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PskeyLocalDataManager", 4, "clearLocalPskey mmkvName = pskey_uksey_MmkvName_ okList = [" + ((Object) sb5) + "]");
        }
    }

    @NotNull
    public final Map<String, a> f(@NotNull String uin, @NotNull Map<String, a> domains) {
        List<String> list;
        List<String> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin, (Object) domains);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(domains, "domains");
        list = CollectionsKt___CollectionsKt.toList(domains.keySet());
        Map<String, a> e16 = e(uin, list);
        i iVar = i.f261182a;
        if (iVar.b(e16)) {
            return e16;
        }
        g(uin);
        list2 = CollectionsKt___CollectionsKt.toList(domains.keySet());
        Map<String, a> e17 = e(uin, list2);
        if (iVar.b(e17)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("PskeyLocalDataManager", 4, "getPskeyFromLocal from cache success, after load from Mmkv");
            }
            return e17;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("PskeyLocalDataManager", 4, "getPskeyFromLocal from cache failed");
        }
        return e17;
    }

    public final boolean h(@NotNull String uin) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCheckTimeStamp <= MiniBoxNoticeInfo.MIN_5) {
            return false;
        }
        this.mLastCheckTimeStamp = currentTimeMillis;
        for (Map.Entry<String, g> entry : this.mCacheMap.entrySet()) {
            String uinAndDomain = entry.getKey();
            g value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(uinAndDomain, "uinAndDomain");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(uinAndDomain, uin, false, 2, null);
            if (startsWith$default && !TextUtils.isEmpty(value.toString()) && value.b() - currentTimeMillis <= 43200000) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("PskeyLocalDataManager", 4, "needUpdateAllPskey uin = " + uin);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public final void k(@NotNull String uin, @NotNull Map<String, a> domainToPskeyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin, (Object) domainToPskeyMap);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(domainToPskeyMap, "domainToPskeyMap");
        if (QLog.isDevelopLevel()) {
            QLog.i("PskeyLocalDataManager", 4, "savePskey start");
        }
        l(uin, INSTANCE.b(), domainToPskeyMap);
        m(uin);
        i(uin);
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this) {
            QLog.d("PskeyLocalDataManager", 4, "unregisterBroadcastReceiver");
            BroadcastReceiver broadcastReceiver = this.mBroadcastReceiver;
            if (broadcastReceiver != null) {
                Context context = this.mContext;
                if (context != null) {
                    context.unregisterReceiver(broadcastReceiver);
                }
                this.mBroadcastReceiver = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
