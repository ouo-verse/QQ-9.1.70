package com.tencent.mobileqq.ad.loadingad;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001\tB\u0019\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0014\u0010\u000eR$\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b\u0016\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/ad/loadingad/a;", "", "", tl.h.F, "", "url", "path", "", "g", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageUrl", "b", "f", "setVideoUrl", AppConstants.Key.KEY_QZONE_VIDEO_URL, "setImagePath", "imagePath", "d", "e", "setVideoPath", "videoPath", "", "J", "aid", "creativeId", "saveKey", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "()Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "listener", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "uin", "<init>", "(Lcom/tencent/gdtad/aditem/GdtAd;Ljava/lang/String;)V", "i", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String imageUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String imagePath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long aid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long creativeId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String saveKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Downloader.DownloadListener listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/loadingad/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.loadingad.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/ad/loadingad/a$b", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "", "url", "", "onDownloadCanceled", "Lcom/tencent/component/network/downloader/DownloadResult;", "downloadResult", "onDownloadFailed", "onDownloadSucceed", "", "l", "", "v", "onDownloadProgress", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Downloader.DownloadListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(@NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            } else {
                Intrinsics.checkNotNullParameter(url, "url");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(@NotNull String url, @NotNull DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) downloadResult);
            } else {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(@NotNull String url, long l3, float v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, url, Long.valueOf(l3), Float.valueOf(v3));
            } else {
                Intrinsics.checkNotNullParameter(url, "url");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(@NotNull String url, @NotNull DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) url, (Object) downloadResult);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            QLog.d("CachedAdInfo", 1, "onDownloadSucceed url\uff1a" + url + " filePath:" + a.this.b());
            a.this.h();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28105);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@Nullable GdtAd gdtAd, @NotNull String uin) {
        long j3;
        String str;
        String basic_img;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo;
        PBUInt64Field pBUInt64Field;
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gdtAd, (Object) uin);
            return;
        }
        this.saveKey = "loading_ad_preload_adjson_key_" + uin;
        this.listener = new b();
        long j16 = 0;
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = 0;
        }
        this.aid = j3;
        if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null && (traceInfo = reportInfo.trace_info) != null && (pBUInt64Field = traceInfo.creative_id) != null) {
            j16 = pBUInt64Field.get();
        }
        this.creativeId = j16;
        this.imageUrl = (gdtAd == null || (basic_img = gdtAd.getBasic_img()) == null) ? "" : basic_img;
        if (gdtAd != null) {
            str = gdtAd.getVideoUrl();
        } else {
            str = null;
        }
        this.videoUrl = str;
        if (!TextUtils.isEmpty(this.imageUrl)) {
            this.imagePath = g.f186889a.v(this.imageUrl, uin);
        }
        if (!TextUtils.isEmpty(this.videoUrl)) {
            g gVar = g.f186889a;
            this.videoPath = gVar.v(this.videoUrl, uin) + gVar.u(this.videoUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        QLog.d("CachedAdInfo", 1, "updatePreloadAdCache \u66f4\u65b0\u7f13\u5b58\u5e7f\u544a\u5217\u8868");
        try {
            g gVar = g.f186889a;
            String str = this.saveKey;
            String jSONObject = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            JSONObject jSONObject2 = new JSONObject(gVar.x(str, jSONObject));
            JSONArray optJSONArray = jSONObject2.optJSONArray("adarray");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("aid", this.aid);
            jSONObject3.put("creativeId", this.creativeId);
            jSONObject3.put("url", this.imageUrl);
            jSONObject3.put("filePath", this.imagePath);
            jSONObject3.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, this.videoUrl);
            jSONObject3.put("videoPath", this.videoPath);
            optJSONArray.mo162put(jSONObject3);
            jSONObject2.put("adarray", optJSONArray);
            String str2 = this.saveKey;
            String jSONObject4 = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonObject.toString()");
            gVar.H(str2, jSONObject4);
        } catch (JSONException e16) {
            QLog.e("CachedAdInfo", 1, "updatePreloadAdCache failed, error is " + e16);
        }
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.imagePath;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.imageUrl;
    }

    @NotNull
    public final Downloader.DownloadListener d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Downloader.DownloadListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.listener;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.videoPath;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.videoUrl;
    }

    public final boolean g(@Nullable String url, @Nullable String path) {
        File file;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) url, (Object) path)).booleanValue();
        }
        if (path != null) {
            file = new File(path);
        } else {
            file = null;
        }
        if (file != null && file.exists()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h();
        }
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(path) && this.aid != 0 && this.creativeId != 0) {
            if (file != null && !file.exists()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }
}
