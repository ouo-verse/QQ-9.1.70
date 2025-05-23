package com.tencent.mobileqq.qmmkv.v2;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QMMKVSplitHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110$\u0012\b\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J(\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000fH\u0014J(\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\fH\u0014J\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0005H\u0014R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010+R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010/\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010+R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/MMKVMemoryCache;", "Lcom/tencent/mobileqq/qmmkv/v2/b;", "Ljava/lang/Runnable;", "", "multiplier", "", "recoveryDelay", "", "E", "D", "", "mmapId", "", "withAccount", "d", "Lcom/tencent/mobileqq/qmmkv/v2/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", UserInfo.SEX_FEMALE, "key", "kv", "priority", "prioritySize", "v", "mmapKey", "y", HippyTKDListViewAdapter.X, "isTrimElseRemove", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "G", "L", TencentLocation.RUN_MODE, "I", "H", "size", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "priorityMap", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "Z", "mmkvAutoCloseSwitch", "originMaxCacheCountMap", "maxCacheCountMap", "scaleMultiplier", "bLogout", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "keysWithAccount", "Lcom/tencent/mobileqq/qmmkv/i;", "callback", "<init>", "(Ljava/util/Map;Lcom/tencent/mobileqq/qmmkv/i;)V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MMKVMemoryCache extends b implements Runnable {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mmkvAutoCloseSwitch;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> originMaxCacheCountMap;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Map<Integer, Integer> maxCacheCountMap;

    /* renamed from: G, reason: from kotlin metadata */
    private volatile float scaleMultiplier;

    /* renamed from: H, reason: from kotlin metadata */
    private volatile boolean bLogout;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, String> keysWithAccount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Integer> priorityMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MMKVMemoryCache(@NotNull Map<String, Integer> priorityMap, @Nullable com.tencent.mobileqq.qmmkv.i iVar) {
        super(Long.MAX_VALUE);
        Map<Integer, Integer> emptyMap;
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(priorityMap, "priorityMap");
        this.priorityMap = priorityMap;
        this.TAG = "QMMKV_cache_MMKVMemoryCache";
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.maxCacheCountMap = emptyMap;
        this.keysWithAccount = new ConcurrentHashMap<>();
        com.tencent.mobileqq.qmmkv.g.b();
        com.tencent.mobileqq.qmmkv.g gVar = com.tencent.mobileqq.qmmkv.g.f262011a;
        com.tencent.mobileqq.qmmkv.d a16 = gVar.a();
        Intrinsics.checkNotNull(a16);
        boolean d16 = a16.d();
        this.mmkvAutoCloseSwitch = d16;
        if (d16) {
            com.tencent.mobileqq.qmmkv.d a17 = gVar.a();
            Intrinsics.checkNotNull(a17);
            Map<Integer, Integer> b16 = a17.b();
            this.originMaxCacheCountMap = b16;
            QLog.d("QMMKV_cache_MMKVMemoryCache", 1, "init mmkvAutoCloseSwitch is open. maxCacheCountMap:" + b16);
            D(1.0f);
            return;
        }
        QLog.w("QMMKV_cache_MMKVMemoryCache", 1, "init mmkvAutoCloseSwitch is closed.");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 0), TuplesKt.to(2, 0), TuplesKt.to(4, 0), TuplesKt.to(8, 0));
        this.originMaxCacheCountMap = hashMapOf;
    }

    private final void D(float multiplier) {
        int mapCapacity;
        int roundToInt;
        if (!this.mmkvAutoCloseSwitch) {
            return;
        }
        this.scaleMultiplier = multiplier;
        Map<Integer, Integer> map = this.originMaxCacheCountMap;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            roundToInt = MathKt__MathJVMKt.roundToInt(((Number) entry.getValue()).floatValue() * multiplier);
            linkedHashMap.put(key, Integer.valueOf(roundToInt));
        }
        this.maxCacheCountMap = linkedHashMap;
        Iterator it5 = linkedHashMap.entrySet().iterator();
        int i3 = 0;
        while (it5.hasNext()) {
            i3 += ((Number) ((Map.Entry) it5.next()).getValue()).intValue();
        }
        QLog.d(this.TAG, 1, "cacheScaling newMax:" + i3 + " curMax:" + m() + " curSize:" + l());
        long j3 = (long) i3;
        if (m() != j3) {
            s(j3);
        }
    }

    private final void E(float multiplier, long recoveryDelay) {
        if (!this.mmkvAutoCloseSwitch) {
            return;
        }
        if (QLog.isColorLevel()) {
            String str = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cacheScalingWithRecovery multiplier:");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(multiplier)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb5.append(format);
            sb5.append(", recoveryDelay:");
            sb5.append(recoveryDelay);
            QLog.d(str, 2, sb5.toString());
        }
        if (this.scaleMultiplier < multiplier) {
            D(multiplier);
        }
        ThreadManagerV2.removeJob(this, 16);
        ThreadManagerV2.executeDelay(this, 16, null, true, recoveryDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(HashMap mapParams) {
        Intrinsics.checkNotNullParameter(mapParams, "$mapParams");
        com.tencent.mobileqq.qmmkv.e a16 = com.tencent.mobileqq.qmmkv.k.f262017a.a();
        Intrinsics.checkNotNull(a16);
        a16.report("actMMKVEvictFailedReport", mapParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(HashMap mapParams) {
        Intrinsics.checkNotNullParameter(mapParams, "$mapParams");
        com.tencent.mobileqq.qmmkv.e a16 = com.tencent.mobileqq.qmmkv.k.f262017a.a();
        Intrinsics.checkNotNull(a16);
        a16.report("actMMKVEvictFailedReport", mapParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(HashMap mapParams) {
        Intrinsics.checkNotNullParameter(mapParams, "$mapParams");
        com.tencent.mobileqq.qmmkv.e a16 = com.tencent.mobileqq.qmmkv.k.f262017a.a();
        Intrinsics.checkNotNull(a16);
        a16.report("actMMKVExceptionReport", mapParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076 A[EDGE_INSN: B:27:0x0076->B:28:0x0076 BREAK  A[LOOP:0: B:18:0x0047->B:35:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:0: B:18:0x0047->B:35:?, LOOP_END, SYNTHETIC] */
    @Override // com.tencent.mobileqq.qmmkv.v2.f
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int n(@NotNull e item) {
        boolean z16;
        Integer num;
        Object obj;
        boolean startsWith$default;
        boolean z17;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(item, "item");
        if (!this.mmkvAutoCloseSwitch) {
            return -1;
        }
        String mmapId = item.getMmapId();
        if (mmapId != null && mmapId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 8;
        }
        if (this.priorityMap.containsKey(mmapId)) {
            Integer num2 = this.priorityMap.get(mmapId);
            Intrinsics.checkNotNull(num2);
            return num2.intValue() >>> 16;
        }
        Iterator<T> it = this.priorityMap.entrySet().iterator();
        while (true) {
            num = null;
            if (it.hasNext()) {
                obj = it.next();
                Map.Entry entry = (Map.Entry) obj;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mmapId, (String) entry.getKey(), false, 2, null);
                if (!startsWith$default) {
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(mmapId, (String) entry.getKey(), false, 2, null);
                    if (!endsWith$default) {
                        z17 = false;
                        if (!z17) {
                            break;
                        }
                    }
                }
                z17 = true;
                if (!z17) {
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) obj;
        if (entry2 != null) {
            num = Integer.valueOf(((Number) entry2.getValue()).intValue() >>> 16);
        }
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }

    public final void G() {
        QLog.i(this.TAG, 1, "onAccountLogout");
        this.bLogout = true;
        g();
        this.bLogout = false;
        this.keysWithAccount.clear();
    }

    public final void H() {
        E(1.25f, 30000L);
    }

    public final void I() {
        E(1.5f, 90000L);
    }

    public final void L(@Nullable String mmapId) {
        QLog.i(this.TAG, 1, "onMMKVSplitWithAccount: " + mmapId);
        this.keysWithAccount.clear();
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.b, com.tencent.mobileqq.qmmkv.v2.k
    @NotNull
    public String d(@NotNull String mmapId, boolean withAccount) {
        boolean z16;
        String str;
        boolean z17;
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        if (!withAccount) {
            return mmapId;
        }
        String str2 = this.keysWithAccount.get(mmapId);
        boolean z18 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return str2;
        }
        AppRuntime peekAppRuntime = MobileQQ.getMobileQQ().peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUid();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (QLog.isColorLevel()) {
                QLog.e(this.TAG, 1, "generateMmapKey [" + mmapId + "] withAccount error, uid invalid!!!");
            }
            return mmapId;
        }
        if (QMMKVSplitHelper.f194966a.a().decodeBool(mmapId + util.base64_pad_url + str + "_split", false) || "file_account_test".equals(mmapId)) {
            z18 = true;
        }
        if (z18) {
            String str3 = mmapId + util.base64_pad_url + str;
            this.keysWithAccount.put(mmapId, str3);
            return str3;
        }
        this.keysWithAccount.put(mmapId, mmapId);
        return mmapId;
    }

    @Override // java.lang.Runnable
    public void run() {
        D(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qmmkv.v2.f
    public void t(long size) {
        try {
            super.t(size);
        } catch (Throwable th5) {
            QLog.d(this.TAG, 1, "trimToSize exception: " + th5.getMessage(), th5);
            final HashMap hashMap = new HashMap();
            hashMap.put("scene", "1");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.v2.g
                @Override // java.lang.Runnable
                public final void run() {
                    MMKVMemoryCache.M(hashMap);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.b
    protected boolean v(@NotNull String key, @NotNull e kv5, int priority, long prioritySize) {
        int i3;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        if (this.bLogout && !Intrinsics.areEqual(key, kv5.getMmapId())) {
            QLog.w(this.TAG, 1, "canEvict [" + key + "]: true cause of account logout");
            return true;
        }
        boolean z16 = false;
        if (priority == -1) {
            return false;
        }
        Integer num = this.maxCacheCountMap.get(Integer.valueOf(priority));
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 6;
        }
        if (prioritySize > i3) {
            z16 = true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(this.TAG, 1, "canEvict:" + z16 + " [" + key + "] cur:" + prioritySize + " max: " + i3);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qmmkv.v2.b
    public void x(@NotNull String mmapKey, @NotNull e kv5) {
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        super.x(mmapKey, kv5);
        final HashMap hashMap = new HashMap();
        hashMap.put("mmapKey", mmapKey);
        hashMap.put("mmapId", String.valueOf(kv5.getMmapId()));
        hashMap.put("isTrimElseRemove", "0");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.v2.i
            @Override // java.lang.Runnable
            public final void run() {
                MMKVMemoryCache.K(hashMap);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qmmkv.v2.b
    public void y(@NotNull String mmapKey, @NotNull e kv5, int priority, long prioritySize) {
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        super.y(mmapKey, kv5, priority, prioritySize);
        final HashMap hashMap = new HashMap();
        hashMap.put("mmapKey", mmapKey);
        hashMap.put("mmapId", String.valueOf(kv5.getMmapId()));
        hashMap.put("priority", String.valueOf(priority));
        hashMap.put("prioritySize", String.valueOf(prioritySize));
        hashMap.put("isTrimElseRemove", "1");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.v2.h
            @Override // java.lang.Runnable
            public final void run() {
                MMKVMemoryCache.J(hashMap);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qmmkv.v2.b, com.tencent.mobileqq.qmmkv.v2.f
    /* renamed from: z */
    public void p(@NotNull String mmapKey, @NotNull e kv5, int priority, boolean isTrimElseRemove) {
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        super.p(mmapKey, kv5, priority, isTrimElseRemove);
    }
}
