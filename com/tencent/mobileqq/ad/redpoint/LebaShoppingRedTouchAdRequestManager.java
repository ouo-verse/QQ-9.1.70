package com.tencent.mobileqq.ad.redpoint;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002&'B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/ad/redpoint/LebaShoppingRedTouchAdRequestManager;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", DomainData.DOMAIN_NAME, "", "traceId", "", "isUpdate", "e", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "Ls71/a;", "callback", "l", "g", "c", "", "j", "time", "p", "Landroid/content/Context;", h.F, "key", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "b", "o", "i", "Lcom/tencent/mobileqq/ad/redpoint/LebaShoppingRedTouchAdRequestManager$LimitedLinkedHashMap;", "Lcom/tencent/mobileqq/ad/redpoint/LebaShoppingRedTouchAdRequestManager$LimitedLinkedHashMap;", "mAdCacheMap", "<init>", "()V", "LimitedLinkedHashMap", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class LebaShoppingRedTouchAdRequestManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LebaShoppingRedTouchAdRequestManager f186905a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LimitedLinkedHashMap<String, String> mAdCacheMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ad/redpoint/LebaShoppingRedTouchAdRequestManager$LimitedLinkedHashMap;", "K", "V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "maxSize", "", "(I)V", "removeEldestEntry", "", "eldest", "", "qqad-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class LimitedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        static IPatchRedirector $redirector_;
        private final int maxSize;

        public LimitedLinkedHashMap(int i3) {
            super(i3, 0.75f, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.maxSize = i3;
            }
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return (Set<Map.Entry<K, V>>) getEntries();
        }

        public /* bridge */ Set<Map.Entry<Object, Object>> getEntries() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return super.entrySet();
        }

        public /* bridge */ Set<Object> getKeys() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return super.size();
        }

        public /* bridge */ Collection<Object> getValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Collection) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<K> keySet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return (Set<K>) getKeys();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(@Nullable Map.Entry<K, V> eldest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eldest)).booleanValue();
            }
            if (size() > this.maxSize) {
                return true;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<V> values() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Collection) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return (Collection<V>) getValues();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00040\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/redpoint/LebaShoppingRedTouchAdRequestManager$a;", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends TypeToken<LinkedHashMap<String, String>> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f186907a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28205);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f186907a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/ad/redpoint/LebaShoppingRedTouchAdRequestManager$b", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "", "msg", "", "onRsp", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements VasAdCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s71.a f186908a;

        b(s71.a aVar) {
            this.f186908a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp rsp, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(retCode), rsp, msg2);
            } else {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                LebaShoppingRedTouchAdRequestManager.f186905a.l(retCode, rsp, this.f186908a);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f186905a = new LebaShoppingRedTouchAdRequestManager();
            mAdCacheMap = new LimitedLinkedHashMap<>(10);
        }
    }

    LebaShoppingRedTouchAdRequestManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c() {
        if (System.currentTimeMillis() > j()) {
            return true;
        }
        return false;
    }

    private final String e(String traceId, boolean isUpdate) {
        MMKVOptionEntity from = QMMKV.from(h(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        String decodeString = from.decodeString(k("leba_shopping_cache_ad"), "");
        if (TextUtils.isEmpty(decodeString)) {
            QLog.e("LebaShoppingRedTouchAdRequestManager", 1, "getCacheAdStr error:adCacheMapStr is empty");
            return "";
        }
        try {
            Object fromJson = new Gson().fromJson(decodeString, a.f186907a.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(adCacheMap\u2026kedHashMapTypeToken.type)");
            LinkedHashMap linkedHashMap = (LinkedHashMap) fromJson;
            if (isUpdate || mAdCacheMap.isEmpty()) {
                mAdCacheMap.putAll(linkedHashMap);
            }
            if (TextUtils.isEmpty(traceId)) {
                return "";
            }
            String str = (String) linkedHashMap.get(traceId);
            if (str == null) {
                return "";
            }
            return str;
        } catch (Exception e16) {
            QLog.e("LebaShoppingRedTouchAdRequestManager", 1, "getCacheAdJson error", e16);
            return "";
        }
    }

    static /* synthetic */ String f(LebaShoppingRedTouchAdRequestManager lebaShoppingRedTouchAdRequestManager, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return lebaShoppingRedTouchAdRequestManager.e(str, z16);
    }

    private final String g() {
        if (SimpleUIUtil.isNowElderMode()) {
            return PlatformInfor.ELDER_MODE;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        return "default";
    }

    private final Context h() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private final long j() {
        MMKVOptionEntity from = QMMKV.from(h(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return from.decodeLong(k("leba_shopping_next_req_ad_time_ms"), 0L);
    }

    private final String k(String key) {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int retCode, access.AdGetRsp rsp, s71.a callback) {
        access.RetMsg retMsg;
        long j3;
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
        PBInt64Field pBInt64Field;
        access.RetMsg retMsg2;
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list = null;
        if (rsp != null && (retMsg2 = rsp.ret_msg) != null) {
            retMsg = retMsg2.get();
        } else {
            retMsg = null;
        }
        QLog.d("LebaShoppingRedTouchAdRequestManager", 1, "onAdRsp retCode:" + retCode + ", retMsg:" + retMsg);
        if (retCode != 0) {
            p(System.currentTimeMillis() + ShortVideoConstants.VIDEO_MAX_DURATION);
            callback.a(retCode);
            QLog.e("LebaShoppingRedTouchAdRequestManager", 1, "onAdRsp error");
            return;
        }
        if (rsp != null && (pBInt64Field = rsp.next_req_gap_in_seconds) != null) {
            j3 = pBInt64Field.get();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            j3 = 1200;
        }
        QLog.d("LebaShoppingRedTouchAdRequestManager", 1, "nextRequestFreqS:" + j3);
        p(System.currentTimeMillis() + (j3 * 1000));
        if (rsp != null) {
            try {
                qq_ad_get.QQAdGetRsp qQAdGetRsp = rsp.qq_ad_get_rsp;
                if (qQAdGetRsp != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null) {
                    list = pBRepeatMessageField.get();
                }
            } catch (Throwable th5) {
                QLog.e("LebaShoppingRedTouchAdRequestManager", 1, "onAdRsp parse ad error:", th5);
            }
        }
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = list.get(0);
            if (posAdInfo.has()) {
                Intrinsics.checkNotNullExpressionValue(posAdInfo.ads_info.get(), "adInfo.ads_info.get()");
                if (!r1.isEmpty()) {
                    n(new GdtAd(posAdInfo.ads_info.get().get(0)));
                    callback.a(retCode);
                    return;
                }
            }
        }
        callback.a(retCode);
    }

    private final void n(GdtAd gdtAd) {
        String traceId = gdtAd.getTraceId();
        if (traceId == null) {
            traceId = "";
        }
        if (TextUtils.isEmpty(traceId)) {
            QLog.e("LebaShoppingRedTouchAdRequestManager", 1, "updateCacheAd error:traceId is empty");
            return;
        }
        LimitedLinkedHashMap<String, String> limitedLinkedHashMap = mAdCacheMap;
        if (limitedLinkedHashMap.isEmpty()) {
            e("", true);
        }
        String gdtAd2 = gdtAd.toString();
        Intrinsics.checkNotNullExpressionValue(gdtAd2, "gdtAd.toString()");
        limitedLinkedHashMap.put(traceId, gdtAd2);
        String str = new Gson().toJson(limitedLinkedHashMap).toString();
        MMKVOptionEntity from = QMMKV.from(h(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeString(k("leba_shopping_cache_ad"), str);
        QLog.d("LebaShoppingRedTouchAdRequestManager", 2, "updateCacheAd success:" + traceId + ", cache size:" + limitedLinkedHashMap.size());
    }

    private final void p(long time) {
        MMKVOptionEntity from = QMMKV.from(h(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeLong(k("leba_shopping_next_req_ad_time_ms"), time);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        mAdCacheMap.clear();
        MMKVOptionEntity from = QMMKV.from(h(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeString(k("leba_shopping_cache_ad"), "");
    }

    @Nullable
    public final GdtAd d(@NotNull String traceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GdtAd) iPatchRedirector.redirect((short) 3, (Object) this, (Object) traceId);
        }
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (TextUtils.isEmpty(traceId)) {
            return null;
        }
        String f16 = f(this, traceId, false, 2, null);
        if (TextUtils.isEmpty(f16)) {
            return null;
        }
        try {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(f16));
            if (adInfo == null) {
                return null;
            }
            return new GdtAd(adInfo);
        } catch (Exception e16) {
            QLog.e("LebaShoppingRedTouchAdRequestManager", 1, "getCacheAd error:", e16);
            return null;
        }
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        MMKVOptionEntity from = QMMKV.from(h(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        String decodeString = from.decodeString(k("leba_shopping_last_expo_ad"), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(getU\u2026OPPING_LAST_EXPO_AD), \"\")");
        return decodeString;
    }

    public final void m(@NotNull s71.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("LebaShoppingRedTouchAdRequestManager", 2, "requestAd");
        if (!c()) {
            QLog.d("LebaShoppingRedTouchAdRequestManager", 2, "requestAd freq, nextReqTime:", Long.valueOf(j()));
            return;
        }
        b bVar = new b(callback);
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add("1143225921254886");
        build.setBusiType(83);
        build.setClientMod(f186905a.g());
        iVasAdvApi.requestAd(build, bVar);
    }

    public final void o(@NotNull String traceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) traceId);
            return;
        }
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        MMKVOptionEntity from = QMMKV.from(h(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeString(k("leba_shopping_last_expo_ad"), traceId);
    }
}
