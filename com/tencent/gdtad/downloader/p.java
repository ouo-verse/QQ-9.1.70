package com.tencent.gdtad.downloader;

import com.tencent.ark.ark;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/gdtad/downloader/p;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/gdtad/downloader/t;", "listener", "", "i", "Lcom/tencent/open/downloadnew/DownloadInfo;", "downloadInfo", "e", "g", "Lorg/json/JSONArray;", "jsA", "Lcom/tencent/gdtad/downloader/x;", "callback", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "o", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mListenerMap", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "c", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "mNetHandler", "d", "Lcom/tencent/gdtad/downloader/t;", "mDownloadListener", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f109191a = new p();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, t> mListenerMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final INetInfoHandler mNetHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final t mDownloadListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/gdtad/downloader/p$b", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", ReportConstant.COSTREPORT_PREFIX, "", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements INetInfoHandler {
        b() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            p.f109191a.k();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@NotNull String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            p.f109191a.m();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@NotNull String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@NotNull String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            p.f109191a.m();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@NotNull String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            p.f109191a.k();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            p.f109191a.k();
        }
    }

    static {
        b bVar = new b();
        mNetHandler = bVar;
        mDownloadListener = new a();
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), bVar);
    }

    p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DownloadInfo downloadInfo, t tVar) {
        t tVar2;
        Intrinsics.checkNotNullParameter(downloadInfo, "$downloadInfo");
        String downloadUrl = downloadInfo.f341186f;
        i iVar = i.f109183a;
        if (tVar == null) {
            tVar2 = mListenerMap.get(downloadUrl);
            if (tVar2 == null) {
                tVar2 = mDownloadListener;
            }
            Intrinsics.checkNotNullExpressionValue(tVar2, "mListenerMap[downloadUrl] ?: mDownloadListener");
        } else {
            tVar2 = tVar;
        }
        iVar.m(downloadInfo, tVar2);
        if (tVar == null) {
            return;
        }
        HashMap<String, t> hashMap = mListenerMap;
        Intrinsics.checkNotNullExpressionValue(downloadUrl, "downloadUrl");
        hashMap.put(downloadUrl, tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DownloadInfo downloadInfo) {
        Intrinsics.checkNotNullParameter(downloadInfo, "$downloadInfo");
        i.f109183a.e(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
        ArrayList<DownloadInfo> t16 = j.f109185f.t();
        if (t16 != null && !t16.isEmpty()) {
            Iterator<DownloadInfo> it = t16.iterator();
            while (it.hasNext()) {
                DownloadInfo info = it.next();
                i iVar = i.f109183a;
                Intrinsics.checkNotNullExpressionValue(info, "info");
                iVar.k(info, true);
            }
            return;
        }
        QLog.e("AdDownloadProxy", 1, "pauseAllTask failed, target list is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        boolean z16;
        ArrayList<DownloadInfo> s16 = j.f109185f.s();
        int i3 = 0;
        if (s16 != null && !s16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdDownloadProxy", 1, "restartDownload failed, target list is null");
            return;
        }
        if (!k.f109187a.d()) {
            QLog.e("AdDownloadProxy", 1, "switch closed, cancel restartDownload");
            return;
        }
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).registerAppInstallerReceiver(MobileQQ.sMobileQQ);
        Iterator<DownloadInfo> it = s16.iterator();
        while (it.hasNext()) {
            DownloadInfo list = it.next();
            Intrinsics.checkNotNullExpressionValue(list, "list");
            DownloadInfo downloadInfo = list;
            if (i3 <= 3) {
                i3++;
                t tVar = mListenerMap.get(downloadInfo.f341186f);
                i iVar = i.f109183a;
                if (tVar == null) {
                    tVar = mDownloadListener;
                }
                iVar.f(downloadInfo, tVar);
            } else {
                return;
            }
        }
    }

    public final void e(@NotNull final DownloadInfo downloadInfo, @Nullable final t listener) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.downloader.m
            @Override // java.lang.Runnable
            public final void run() {
                p.f(DownloadInfo.this, listener);
            }
        }, 32, null, false);
    }

    public final void g(@NotNull final DownloadInfo downloadInfo) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.downloader.o
            @Override // java.lang.Runnable
            public final void run() {
                p.h(DownloadInfo.this);
            }
        }, 16, null, false);
    }

    public final void i(@NotNull JSONObject json, @Nullable t listener) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (QLog.isDebugVersion()) {
            QLog.d("AdDownloadProxy", 1, "doDownloadAction pParamsJson=" + json);
        }
        try {
            e(k.f109187a.b(json), listener);
        } catch (JSONException e16) {
            QLog.e("AdDownloadProxy", 1, "[doDownloadAction] JSONException", e16);
        }
    }

    public final synchronized void j(@NotNull JSONArray jsA, @NotNull x callback) {
        Intrinsics.checkNotNullParameter(jsA, "jsA");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            int length = jsA.length();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jsA.getJSONObject(i3);
                j jVar = j.f109185f;
                String optString = jSONObject.optString("url");
                Intrinsics.checkNotNullExpressionValue(optString, "params.optString(\"url\")");
                DownloadInfo k3 = jVar.k(optString);
                if (k3 != null) {
                    jSONArray.mo162put(k3.l());
                }
            }
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonInfoArray.toString()");
            callback.a(jSONArray2);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("AdDownloadProxy", "[innerQuery] e=", e16);
        }
    }

    public final void k() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.downloader.n
            @Override // java.lang.Runnable
            public final void run() {
                p.l();
            }
        }, 16, null, false, 2000L);
    }

    public final void m() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.downloader.l
            @Override // java.lang.Runnable
            public final void run() {
                p.n();
            }
        }, 16, null, false, 2000L);
    }

    public final void o() {
        if (HttpUtil.getNetWorkType() != 1) {
            QLog.e("AdDownloadProxy", 1, "restartDownloadAfterLogin failed, net can't pay");
        } else {
            m();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/gdtad/downloader/p$a", "Lcom/tencent/gdtad/downloader/t;", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "", "f", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends t {
        a() {
        }

        @Override // com.tencent.gdtad.downloader.t
        public void f(@Nullable DownloadInfo info) {
        }
    }
}
