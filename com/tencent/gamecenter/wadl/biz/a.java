package com.tencent.gamecenter.wadl.biz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCookieInfo$GetUserSessionReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCookieInfo$GetUserSessionRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCookieInfo$SessionItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import cooperation.qzone.util.QZoneImageUtils;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J$\u0010\u000f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002J\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u0014H\u0016J.\u0010\u001d\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\rRj\u0010\"\u001aV\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002` 0\u001fj*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002` ` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010!RV\u0010%\u001aB\u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020$0#0\u001fj \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020$0#` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R*\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/gamecenter/wadl/biz/a;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "", "urlString", "d", "", "b", "name", "Lorg/json/JSONObject;", "c", "cookieHost", "Lkotlin/Function1;", "", "", "callback", "a", "url", "", "f", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getFilterCmds", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "onTrpcRsp", "e", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mWhiteList", "Lkotlin/Pair;", "", "mCache", "Lcom/tencent/gamecenter/wadl/biz/CookieCallback;", h.F, "Lkotlin/jvm/functions/Function1;", "mCallback", "<init>", "()V", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements WadlTrpcListener {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f106712d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, HashMap<String, String>> mWhiteList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, Pair<Long, String[]>> mCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super Integer, Unit> mCallback;

    static {
        a aVar = new a();
        f106712d = aVar;
        mWhiteList = new HashMap<>();
        mCache = new HashMap<>();
        JSONObject c16 = aVar.c("105560");
        try {
            Iterator keys = c16.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "config.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str != null) {
                    Object obj = c16.get(str);
                    if (obj instanceof JSONObject) {
                        HashMap<String, HashMap<String, String>> hashMap = mWhiteList;
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        Iterator keys2 = ((JSONObject) obj).keys();
                        Intrinsics.checkNotNullExpressionValue(keys2, "value.keys()");
                        while (keys2.hasNext()) {
                            String str2 = (String) keys2.next();
                            if (str2 != null) {
                                hashMap2.put(str2, ((JSONObject) obj).getString(str2));
                            }
                        }
                        hashMap.put(str, hashMap2);
                    }
                }
            }
        } catch (Exception unused) {
            QLog.e("GameCenterCookieManager", 1, "[constructor] e");
        }
        QLog.i("GameCenterCookieManager", 1, "[constructor] whitelist size: " + mWhiteList.size());
    }

    a() {
    }

    private final Map<String, String> b(String urlString) {
        List split$default;
        List split$default2;
        String query = new URL(urlString).getQuery();
        HashMap hashMap = new HashMap();
        if (query != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    hashMap.put(split$default2.get(0), split$default2.get(1));
                }
            }
        }
        return hashMap;
    }

    private final String d(String urlString) {
        try {
            return new URL(urlString).getHost();
        } catch (Exception e16) {
            QLog.e("GameCenterCookieManager", 2, "[getHostFromUrl] " + e16 + ".");
            return null;
        }
    }

    public final void a(@Nullable String cookieHost, @NotNull Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (cookieHost != null) {
            QLog.i("GameCenterCookieManager", 1, "[collectBusinessCookie] start to get cookie, url: " + cookieHost);
            mCallback = callback;
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
            GameCookieInfo$GetUserSessionReq gameCookieInfo$GetUserSessionReq = new GameCookieInfo$GetUserSessionReq();
            gameCookieInfo$GetUserSessionReq.url.set(cookieHost);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1887", false, gameCookieInfo$GetUserSessionReq.toByteArray());
            Bundle bundle = new Bundle();
            bundle.putString("url", cookieHost);
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        }
    }

    @NotNull
    public final JSONObject c(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            boolean z16 = false;
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(name, new byte[0]);
            if (loadRawConfig.length == 0) {
                z16 = true;
            }
            if (!z16) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                return new JSONObject(new String(loadRawConfig, UTF_8));
            }
        } catch (Throwable th5) {
            QLog.e("GameCenterCookieManager", 1, "getConfigJsonObj " + name + " fail.", th5);
        }
        return new JSONObject();
    }

    public final void e() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
    }

    public final boolean f(@NotNull String url) {
        String str;
        boolean containsKey;
        Long l3;
        long j3;
        Intrinsics.checkNotNullParameter(url, "url");
        String d16 = d(url);
        boolean z16 = false;
        if (d16 != null) {
            if (mCache.containsKey(d16)) {
                Pair<Long, String[]> pair = mCache.get(d16);
                String[] strArr = null;
                if (pair != null) {
                    l3 = pair.getFirst();
                } else {
                    l3 = null;
                }
                Pair<Long, String[]> pair2 = mCache.get(d16);
                if (pair2 != null) {
                    strArr = pair2.getSecond();
                }
                QLog.i("GameCenterCookieManager", 2, "[shouldInterceptUrl] expireTime: " + l3 + ", " + strArr);
                long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
                Pair<Long, String[]> pair3 = mCache.get(d16);
                if (pair3 != null) {
                    j3 = pair3.getFirst().longValue();
                } else {
                    j3 = 0;
                }
                if (currentTimeMillis >= j3) {
                    containsKey = true;
                    z16 = containsKey;
                }
            } else if (mWhiteList.containsKey(d16)) {
                Map<String, String> b16 = f106712d.b(url);
                HashMap<String, String> hashMap = mWhiteList.get(d16);
                if (hashMap == null || (str = hashMap.get(QZoneImageUtils.KEY_MATCH)) == null) {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(str, "mWhiteList[it]?.get(\"match\") ?: \"\"");
                containsKey = b16.containsKey(str);
                z16 = containsKey;
            }
        }
        QLog.i("GameCenterCookieManager", 2, "[shouldInterceptUrl] ret: " + z16);
        return z16;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    @NotNull
    public HashSet<String> getFilterCmds() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("/v1/1887");
        return hashSet;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(@Nullable Intent request, @Nullable String cmd, long ret, @Nullable TrpcProxy.TrpcInovkeRsp rsp) {
        QLog.i("GameCenterCookieManager", 2, "[onTrpcRsp] onTrpcRsp ret:" + ret + ", cmd:" + cmd);
        if (request != null && !TextUtils.isEmpty(cmd)) {
            if (Intrinsics.areEqual("/v1/1887", cmd)) {
                long j3 = 0;
                if (ret == 0 && rsp != null && rsp.data.get() != null) {
                    GameCookieInfo$GetUserSessionRsp mergeFrom = new GameCookieInfo$GetUserSessionRsp().mergeFrom(rsp.data.get().toByteArray());
                    if (mergeFrom.ttl.has()) {
                        j3 = mergeFrom.ttl.get();
                    }
                    HashMap hashMap = new HashMap();
                    List<GameCookieInfo$SessionItem> list = mergeFrom.session.get();
                    Intrinsics.checkNotNullExpressionValue(list, "cookieInfo.session.get()");
                    for (GameCookieInfo$SessionItem gameCookieInfo$SessionItem : list) {
                        hashMap.put(gameCookieInfo$SessionItem.key.get(), gameCookieInfo$SessionItem.val.get());
                    }
                    QLog.i("GameCenterCookieManager", 2, "[onTrpcRsp] cookies size:" + hashMap.size());
                    String d16 = d(request.getStringExtra("url"));
                    if (d16 != null) {
                        Object[] objArr = new String[0];
                        for (Map.Entry entry : hashMap.entrySet()) {
                            String b16 = com.tencent.mobileqq.webview.swift.cookie.b.b((String) entry.getKey(), (String) entry.getValue(), d16, false);
                            Intrinsics.checkNotNullExpressionValue(b16, "buildCookie(key, value, host, false)");
                            objArr = ArraysKt___ArraysJvmKt.plus((String[]) objArr, b16);
                        }
                        mCache.put(d16, new Pair<>(Long.valueOf(j3), objArr));
                        HashMap hashMap2 = new HashMap(1);
                        hashMap2.put(d16, objArr);
                        CookieManager.getInstance().setCookies(hashMap2);
                        QLog.i("GameCenterCookieManager", 2, "[onTrpcRsp] expireTime:" + j3 + ", array:" + objArr.length);
                    }
                    Function1<? super Integer, Unit> function1 = mCallback;
                    if (function1 != null) {
                        function1.invoke(0);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        QLog.i("GameCenterCookieManager", 2, "[onTrpcRsp] onTrpcRsp request null.");
    }
}
