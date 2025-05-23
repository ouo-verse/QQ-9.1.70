package com.tencent.mobileqq.search.searchdetail.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchBoxSugWordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.UfsGetSugWordsReq;
import com.tencent.qqnt.kernel.nativeinterface.UfsGetSugWordsRsp;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\u000b\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0004\u0012\u00020\n0\u0006H\u0007J4\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\r\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0004\u0012\u00020\n0\u0006H\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015R6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00108\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u0012\u0004\b\u0017\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/SearchBoxWordsUtil;", "", "", "g", "", "source", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "", "getSugWordsCallback", "c", "getWordsCb", tl.h.F, "f", "Ljava/util/concurrent/ConcurrentHashMap;", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "getExpireTimeMap$annotations", "()V", "expireTimeMap", "getHintWordsMap$annotations", "hintWordsMap", "e", "()Z", "isCanSearchBoxWords", "<init>", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchBoxWordsUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SearchBoxWordsUtil f284723a = new SearchBoxWordsUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Long> expireTimeMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, ArrayList<String>> hintWordsMap = new ConcurrentHashMap<>();

    SearchBoxWordsUtil() {
    }

    @JvmStatic
    public static final void c(final int source, @NotNull Function1<? super ArrayList<String>, Unit> getSugWordsCallback) {
        long longValue;
        boolean z16;
        Intrinsics.checkNotNullParameter(getSugWordsCallback, "getSugWordsCallback");
        Long l3 = expireTimeMap.get(Integer.valueOf(source));
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        ArrayList<String> arrayList = hintWordsMap.get(Integer.valueOf(source));
        final SearchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1 searchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1 = new SearchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1(getSugWordsCallback);
        if (System.currentTimeMillis() <= longValue) {
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                searchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1.invoke((SearchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1) arrayList);
                QLog.i("SearchBoxWordUtil", 1, "getSearchBoxSugWords  searchBoxSugWords  Unexpired  source:" + source);
                return;
            }
        }
        QLog.i("SearchBoxWordUtil", 1, "getSearchBoxSugWords start source:" + source + " expireTime:" + longValue);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.util.h
            @Override // java.lang.Runnable
            public final void run() {
                SearchBoxWordsUtil.d(source, searchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, Function1 proxyCb) {
        Intrinsics.checkNotNullParameter(proxyCb, "$proxyCb");
        f284723a.h(i3, proxyCb);
    }

    private final boolean g() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102909", false);
        QLog.i("SearchBoxWordUtil", 4, "isUniteConfigSwitchOn=" + isSwitchOn);
        return isSwitchOn;
    }

    private final void h(final int source, final Function1<? super ArrayList<String>, Unit> getWordsCb) {
        UfsGetSugWordsReq ufsGetSugWordsReq = new UfsGetSugWordsReq();
        ufsGetSugWordsReq.source = source;
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.getSearchBoxSugWords(ufsGetSugWordsReq, new IGetSearchBoxSugWordsCallback() { // from class: com.tencent.mobileqq.search.searchdetail.util.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetSearchBoxSugWordsCallback
                public final void onResult(int i3, String str, UfsGetSugWordsRsp ufsGetSugWordsRsp) {
                    SearchBoxWordsUtil.i(source, getWordsCb, i3, str, ufsGetSugWordsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, Function1 getWordsCb, int i16, String errMsg, UfsGetSugWordsRsp rsp) {
        Intrinsics.checkNotNullParameter(getWordsCb, "$getWordsCb");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (i16 == 0) {
            expireTimeMap.put(Integer.valueOf(i3), Long.valueOf(rsp.expireTime));
            ConcurrentHashMap<Integer, ArrayList<String>> concurrentHashMap = hintWordsMap;
            Integer valueOf = Integer.valueOf(i3);
            ArrayList<String> sugWords = rsp.getSugWords();
            Intrinsics.checkNotNullExpressionValue(sugWords, "rsp.getSugWords()");
            concurrentHashMap.put(valueOf, sugWords);
            ArrayList<String> sugWords2 = rsp.getSugWords();
            Intrinsics.checkNotNullExpressionValue(sugWords2, "rsp.getSugWords()");
            getWordsCb.invoke(sugWords2);
            QLog.i("SearchBoxWordUtil", 1, "requestSearchBoxSugWords  success   hintWords count=" + rsp.getSugWords().size());
            return;
        }
        getWordsCb.invoke(new ArrayList());
        QLog.i("SearchBoxWordUtil", 1, "requestSearchBoxSugWords  error   source=" + i3 + "     errCode=" + i16 + "     errMsg:" + errMsg);
    }

    public final boolean e() {
        return g();
    }

    public final boolean f(int source) {
        long longValue;
        Long l3 = expireTimeMap.get(Integer.valueOf(source));
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        if (System.currentTimeMillis() > longValue) {
            return true;
        }
        return false;
    }
}
