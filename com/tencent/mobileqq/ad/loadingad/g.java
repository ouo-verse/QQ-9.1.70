package com.tencent.mobileqq.ad.loadingad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ark;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.ad.loadingad.g;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.mini.api.IMiniLoadingAdApi;
import com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdReportHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\"\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J0\u0010\u001f\u001a\u00020\u00022\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\"\u001a\u00020\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180 H\u0002J:\u0010'\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010)\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u001cH\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\b\u0010-\u001a\u00020\u000fH\u0002J\b\u0010.\u001a\u00020\u000fH\u0002J\n\u00100\u001a\u0004\u0018\u00010/H\u0002J\u000e\u00101\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007J\u0016\u00102\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014J \u00109\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207J\u0018\u0010:\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180 2\b\u0010;\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010?\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010\u000f2\b\u0010>\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010@\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010B\u001a\u00020\u000b2\b\u0010A\u001a\u0004\u0018\u00010\u0018J\u0016\u0010E\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fJ\u0016\u0010G\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000fR\u0016\u0010I\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00102R \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR \u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/ad/loadingad/g;", "", "", tl.h.F, "Lorg/json/JSONArray;", "cachedAdInfoArray", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "reqBusiType", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "vasAdCallback", "", "isPreload", "k", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "p", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "Lcom/tencent/mobileqq/ad/loadingad/b;", "chooseAdEndListener", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/gdtad/aditem/GdtAd;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "aidList", "adJson", "D", "", "ads", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aid", "imagePath", "traceId", "reportEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lorg/json/JSONObject;", "t", "saveKey", "r", "i", "w", "y", "Landroid/content/Context;", ReportConstant.COSTREPORT_PREFIX, "E", "I", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/ad/loadingad/c;", "info", "Lcom/tencent/mobileqq/ad/loadingad/i;", "adShowStateListener", "J", UserInfo.SEX_FEMALE, ark.ARKMETADATA_JSON, "j", "url", "uin", "v", "u", "adInfo", "B", "key", "value", "H", RemoteHandleConst.PARAM_DEFAULT_VALUE, HippyTKDListViewAdapter.X, "b", "mAdType", "", "c", "Ljava/util/Map;", "cachedAidImagePathMap", "d", "cachedAidVideoPathMap", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f186889a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mAdType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Long, String> cachedAidImagePathMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Long, String> cachedAidVideoPathMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/ad/loadingad/g$a", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements VasAdCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(retCode), adRsp, msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("LoadingAdHelper", 1, "onRsp: retCode:" + retCode + ", msg:" + msg2);
            if (retCode == 0 && adRsp != null) {
                g gVar = g.f186889a;
                try {
                    gVar.m(gVar.q(adRsp));
                } catch (Exception e16) {
                    QLog.e("LoadingAdHelper", 1, "preloadAd error:", e16);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/ad/loadingad/g$b", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "", "url", "", "onDownloadCanceled", "Lcom/tencent/component/network/downloader/DownloadResult;", "downloadResult", "onDownloadFailed", "onDownloadSucceed", "", "l", "", "v", "onDownloadProgress", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Downloader.DownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ad.loadingad.b f186893a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f186894b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f186895c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f186896d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ad.loadingad.a f186897e;

        b(com.tencent.mobileqq.ad.loadingad.b bVar, String str, String str2, long j3, com.tencent.mobileqq.ad.loadingad.a aVar) {
            this.f186893a = bVar;
            this.f186894b = str;
            this.f186895c = str2;
            this.f186896d = j3;
            this.f186897e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, str, str2, Long.valueOf(j3), aVar);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(@NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d("LoadingAdHelper", 1, "processSelectAdWithUncachedAd download url= " + url + " canceled");
            this.f186893a.onDownloadAdEnd(null, -1L);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(@NotNull String url, @NotNull DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) downloadResult);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            QLog.d("LoadingAdHelper", 1, "processSelectAdWithUncachedAd download url= " + url + " failed");
            this.f186893a.onDownloadAdEnd(null, -1L);
            ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).reportEvent(MiniLoadingAdReportHelper.EVENT_LOAD_FAIL, null, this.f186894b);
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
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) url, (Object) downloadResult);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            QLog.d("LoadingAdHelper", 1, "processSelectAdWithUncachedAd download url= " + url + " succeed");
            g gVar = g.f186889a;
            String str3 = this.f186895c;
            long j3 = this.f186896d;
            String b16 = this.f186897e.b();
            if (b16 == null) {
                str = "";
            } else {
                str = b16;
            }
            String str4 = this.f186894b;
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
            gVar.z(str3, j3, str, str2, MiniLoadingAdReportHelper.EVENT_LOAD_SUCCESS, this.f186893a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/ad/loadingad/g$c", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements VasAdCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ad.loadingad.b f186898a;

        c(com.tencent.mobileqq.ad.loadingad.b bVar) {
            this.f186898a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(retCode), adRsp, msg2);
            } else {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                g.f186889a.C(retCode, adRsp, this.f186898a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JJ\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\bH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\fH\u0016J$\u0010\u001a\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/ad/loadingad/g$d", "Lcom/tencent/mobileqq/mini/api/data/IMiniLoadingAdListener;", "", "adJson", "Ljava/util/ArrayList;", "", "aidList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "loadingConfigMap", "", "onSelectAdProcessDone", "", "retCode", "onPreloadAdReceive", "getLoadingAdLayoutReady", "", "isSkip", "onAdDismiss", "Landroid/view/View;", "adLayout", "onAdShow", "type", "onAdClick", "aid", "filePath", "onDownloadAdEnd", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements IMiniLoadingAdListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f186899a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f186900b;

        d(i iVar, Activity activity) {
            this.f186899a = iVar;
            this.f186900b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVar, (Object) activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ViewGroup viewGroup, View view) {
            viewGroup.addView(view);
        }

        @Override // com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener
        public void getLoadingAdLayoutReady() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                QLog.d("LoadingAdHelper", 1, "getLoadingAdLayoutReady");
            }
        }

        @Override // com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener
        public void onAdClick(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, type);
            } else {
                QLog.d("LoadingAdHelper", 1, "onAdClick");
            }
        }

        @Override // com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener
        public void onAdDismiss(boolean isSkip) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, isSkip);
            } else {
                QLog.d("LoadingAdHelper", 1, "onAdDismiss");
                this.f186899a.onAdClose();
            }
        }

        @Override // com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener
        public void onAdShow(@Nullable final View adLayout) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) adLayout);
                return;
            }
            QLog.d("LoadingAdHelper", 1, "onAdShow");
            Window window = this.f186900b.getWindow();
            final ViewGroup viewGroup = null;
            if (window != null) {
                view = window.getDecorView();
            } else {
                view = null;
            }
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            }
            if (viewGroup == null) {
                QLog.d("LoadingAdHelper", 1, "onAdShow error: rootView is null");
                this.f186899a.a(false);
            } else {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.ad.loadingad.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.d.b(viewGroup, adLayout);
                    }
                });
                this.f186899a.a(true);
            }
        }

        @Override // com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener
        public void onDownloadAdEnd(@Nullable String adJson, long aid, @Nullable String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, adJson, Long.valueOf(aid), filePath);
            } else {
                QLog.d("LoadingAdHelper", 1, "onDownloadAdEnd");
            }
        }

        @Override // com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener
        public void onPreloadAdReceive(int retCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, retCode);
            } else {
                QLog.d("LoadingAdHelper", 1, "onPreloadAdReceive");
            }
        }

        @Override // com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener
        public void onSelectAdProcessDone(@Nullable String adJson, @Nullable ArrayList<Long> aidList, @Nullable HashMap<String, String> loadingConfigMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adJson, aidList, loadingConfigMap);
            } else {
                QLog.d("LoadingAdHelper", 1, "onSelectAdProcessDone");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28194);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f186889a = new g();
        cachedAidImagePathMap = new LinkedHashMap();
        cachedAidVideoPathMap = new LinkedHashMap();
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A(JSONArray cachedAdInfoArray) {
        if (cachedAdInfoArray != null && cachedAdInfoArray.length() != 0) {
            try {
                int length = cachedAdInfoArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = cachedAdInfoArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        String path = jSONObject.optString("filePath");
                        if (new File(path).exists()) {
                            long j3 = jSONObject.getLong("aid");
                            Long valueOf = Long.valueOf(j3);
                            Map<Long, String> map = cachedAidImagePathMap;
                            Intrinsics.checkNotNullExpressionValue(path, "path");
                            map.put(valueOf, path);
                            String videoPath = jSONObject.optString("videoPath");
                            if (new File(videoPath).exists()) {
                                Long valueOf2 = Long.valueOf(j3);
                                Map<Long, String> map2 = cachedAidVideoPathMap;
                                Intrinsics.checkNotNullExpressionValue(videoPath, "videoPath");
                                map2.put(valueOf2, videoPath);
                            }
                        }
                    }
                }
            } catch (JSONException e16) {
                QLog.e("LoadingAdHelper", 1, "initCachedAdMap error:", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int retCode, access.AdGetRsp rsp, com.tencent.mobileqq.ad.loadingad.b chooseAdEndListener) {
        String str;
        qq_ad_get.QQAdGetRsp qQAdGetRsp;
        List<access.ExpInfo> list;
        access.RetMsg retMsg;
        PBStringField pBStringField;
        if (rsp != null && (retMsg = rsp.ret_msg) != null && (pBStringField = retMsg.err_msg) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QLog.d("LoadingAdHelper", 1, "onAdRsp retCode:" + retCode + ", retMsg:" + str);
        if (retCode == 0 && rsp != null) {
            qq_ad_get.QQAdGetRsp qQAdGetRsp2 = rsp.qq_ad_get_rsp;
            if (qQAdGetRsp2 != null) {
                qQAdGetRsp = qQAdGetRsp2.get();
            } else {
                qQAdGetRsp = null;
            }
            String valueOf = String.valueOf(GdtJsonPbUtil.pbToJson(qQAdGetRsp));
            if (TextUtils.isEmpty(valueOf)) {
                ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_EMPTY, null, null);
                chooseAdEndListener.onChooseAdEnd(null, -1L, false);
                return;
            }
            PBRepeatMessageField<access.ExpInfo> pBRepeatMessageField = rsp.ext;
            if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                for (access.ExpInfo expInfo : list) {
                    if (Intrinsics.areEqual(expInfo.key.get(), "click_style")) {
                        int i3 = !Intrinsics.areEqual(expInfo.value.get(), ReportConst.ACTION.FULLSCREEN) ? 1 : 0;
                        mAdType = i3;
                        QLog.d("LoadingAdHelper", 1, "onAdRsp getAdType:" + i3);
                    }
                }
            }
            List<GdtAd> q16 = q(rsp);
            ArrayList<Long> arrayList = new ArrayList<>();
            int size = q16.size();
            String str2 = "";
            for (int i16 = 0; i16 < size; i16++) {
                GdtAd gdtAd = q16.get(i16);
                arrayList.add(Long.valueOf(gdtAd.getAId()));
                if (i16 == 0) {
                    str2 = gdtAd.getTraceId();
                    if (str2 == null) {
                        str2 = "";
                    }
                    QLog.d("LoadingAdHelper", 1, "onAdRsp suc aid:" + gdtAd.getAId());
                }
            }
            ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_SUCCESS, null, str2);
            D(arrayList, valueOf, chooseAdEndListener);
            return;
        }
        ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_FAIL, null, null);
        chooseAdEndListener.onChooseAdEnd(null, -1L, false);
    }

    private final void D(ArrayList<Long> aidList, String adJson, com.tencent.mobileqq.ad.loadingad.b chooseAdEndListener) {
        long j3;
        boolean z16;
        long j16;
        if (!aidList.isEmpty()) {
            Long l3 = aidList.get(0);
            Intrinsics.checkNotNullExpressionValue(l3, "aidList[0]");
            j3 = l3.longValue();
        } else {
            j3 = -1;
        }
        if (aidList.size() > 1) {
            Long l16 = aidList.get(1);
            Intrinsics.checkNotNullExpressionValue(l16, "aidList[1]");
            j16 = l16.longValue();
            z16 = cachedAidImagePathMap.containsKey(Long.valueOf(j16));
        } else {
            z16 = false;
            j16 = -1;
        }
        boolean z17 = !cachedAidImagePathMap.containsKey(Long.valueOf(j3));
        QLog.d("LoadingAdHelper", 1, "onSelectAdProcessDone hasCachedAd\uff1a" + z16 + " needDownload " + z17 + " cachedAid " + j16);
        if (z16 && z17) {
            chooseAdEndListener.onNeedWaitRealTime(adJson, true, j16);
        }
        if (!TextUtils.isEmpty(adJson)) {
            chooseAdEndListener.onChooseAdEnd(adJson, j3, z17);
        } else {
            chooseAdEndListener.onChooseAdEnd(null, -1L, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(com.tencent.mobileqq.ad.loadingad.a newCachedAdInfo, String str, Downloader.DownloadListener listener) {
        Intrinsics.checkNotNullParameter(newCachedAdInfo, "$newCachedAdInfo");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        QLog.d("LoadingAdHelper", 1, "processSelectAdWithUncachedAd download newCachedAdInfo.url= " + newCachedAdInfo.c() + " start");
        ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).reportEvent(MiniLoadingAdReportHelper.EVENT_LOAD_START, null, str);
        ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).downloadAd(newCachedAdInfo.c(), newCachedAdInfo.b(), false, listener, Downloader.DownloadMode.OkHttpMode, null);
    }

    private final void h() {
        cachedAidImagePathMap.clear();
        A(r("loading_ad_preload_adjson_key_" + y()));
    }

    private final void i() {
        if (FileUtils.getFileOrFolderSize(w()) > 209715200) {
            QLog.d("LoadingAdHelper", 1, "checkCacheFolder size > maxAdCachedSize");
            FileUtils.deleteFilesInDirectory(w());
        }
    }

    private final void k(int reqBusiType, VasAdCallback vasAdCallback, boolean isPreload) {
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        g gVar = f186889a;
        build.setTargetPosId(gVar.p(reqBusiType));
        if (isPreload) {
            build.setGetAdType(1);
        } else {
            build.setGetAdType(2);
            build.setSpecifiedAdsJsonList(gVar.t());
        }
        build.getAdvPos().add("7063963898289162");
        build.setBusiType(Integer.valueOf(reqBusiType));
        iVasAdvApi.requestAd(build, vasAdCallback);
    }

    static /* synthetic */ void l(g gVar, int i3, VasAdCallback vasAdCallback, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        gVar.k(i3, vasAdCallback, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(List<? extends GdtAd> ads) {
        QLog.d("LoadingAdHelper", 1, "downloadAndSaveLoadingAd");
        String str = "loading_ad_preload_adjson_key_" + y();
        String jSONObject = new JSONObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
        H(str, jSONObject);
        i();
        if (ads.isEmpty()) {
            QLog.d("LoadingAdHelper", 1, "downloadAndSaveLoadingAd: ad is empty");
            return;
        }
        for (GdtAd gdtAd : ads) {
            final com.tencent.mobileqq.ad.loadingad.a aVar = new com.tencent.mobileqq.ad.loadingad.a(gdtAd, y());
            if (aVar.g(aVar.c(), aVar.b())) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ad.loadingad.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.n(a.this);
                    }
                }, 128, null, false);
            } else {
                QLog.d("LoadingAdHelper", 1, "downloadAndSaveLoadingAd image skip");
            }
            if (B(gdtAd) && aVar.g(aVar.f(), aVar.e())) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ad.loadingad.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.o(a.this);
                    }
                }, 128, null, false);
            } else {
                QLog.d("LoadingAdHelper", 1, "downloadAndSaveLoadingAd video skip");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(com.tencent.mobileqq.ad.loadingad.a cachedAdInfo) {
        Intrinsics.checkNotNullParameter(cachedAdInfo, "$cachedAdInfo");
        ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).downloadAd(cachedAdInfo.c(), cachedAdInfo.b(), false, cachedAdInfo.d(), Downloader.DownloadMode.OkHttpMode, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(com.tencent.mobileqq.ad.loadingad.a cachedAdInfo) {
        Intrinsics.checkNotNullParameter(cachedAdInfo, "$cachedAdInfo");
        ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).downloadAd(cachedAdInfo.f(), cachedAdInfo.e(), false, cachedAdInfo.d(), Downloader.DownloadMode.OkHttpMode, null);
    }

    private final String p(int busiType) {
        if (busiType == 86) {
            return "7063963898289162";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<GdtAd> q(access.AdGetRsp rsp) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list = rsp.qq_ad_get_rsp.get().pos_ads_info.get();
        if (list == null) {
            return arrayList;
        }
        Iterator<qq_ad_get.QQAdGetRsp.PosAdInfo> it = list.iterator();
        while (it.hasNext()) {
            List<qq_ad_get.QQAdGetRsp.AdInfo> list2 = it.next().ads_info.get();
            List<qq_ad_get.QQAdGetRsp.AdInfo> list3 = list2;
            if (list3 != null && !list3.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Iterator<qq_ad_get.QQAdGetRsp.AdInfo> it5 = list2.iterator();
                while (it5.hasNext()) {
                    arrayList.add(new GdtAd(it5.next()));
                }
            }
        }
        return arrayList;
    }

    private final JSONArray r(String saveKey) {
        String jSONObject = new JSONObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
        try {
            JSONArray optJSONArray = new JSONObject(x(saveKey, jSONObject)).optJSONArray("adarray");
            if (optJSONArray != null) {
                if (optJSONArray.length() >= 1) {
                    return optJSONArray;
                }
            }
            return null;
        } catch (JSONException unused) {
            QLog.e("LoadingAdHelper", 1, "getCachedAdJsonArray error");
            return null;
        }
    }

    private final Context s() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private final ArrayList<JSONObject> t() {
        cachedAidImagePathMap.clear();
        JSONArray r16 = r("loading_ad_preload_adjson_key_" + y());
        if (r16 != null && r16.length() != 0) {
            try {
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                int length = r16.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = r16.getJSONObject(i3);
                    if (jSONObject != null) {
                        String path = jSONObject.getString("filePath");
                        if (new File(path).exists()) {
                            Long valueOf = Long.valueOf(jSONObject.getLong("aid"));
                            Map<Long, String> map = cachedAidImagePathMap;
                            Intrinsics.checkNotNullExpressionValue(path, "path");
                            map.put(valueOf, path);
                            arrayList.add(jSONObject);
                        }
                    }
                }
                return arrayList;
            } catch (Exception e16) {
                QLog.e("LoadingAdHelper", 1, "getCurCachedAdsList error:", e16);
            }
        }
        return null;
    }

    private final String w() {
        return PreDownloadScheduleUtil.getPreDownloadPathStatic("adcache", PreDownloadConstants.DEPARTMENT_VAS, false) + "/";
    }

    private final String y() {
        String account;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (account = peekAppRuntime.getAccount()) == null) {
            return "";
        }
        return account;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String adJson, long aid, String imagePath, String traceId, String reportEvent, com.tencent.mobileqq.ad.loadingad.b chooseAdEndListener) {
        if (!TextUtils.isEmpty(imagePath)) {
            cachedAidImagePathMap.put(Long.valueOf(aid), imagePath);
            chooseAdEndListener.onDownloadAdEnd(adJson, aid);
            ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).reportEvent(reportEvent, null, traceId);
            return;
        }
        chooseAdEndListener.onDownloadAdEnd(null, -1L);
    }

    public final boolean B(@Nullable GdtAd adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) adInfo)).booleanValue();
        }
        if (adInfo != null && (adInfo.getInnerShowType() == 3 || adInfo.getInnerShowType() == 4 || adInfo.getInnerShowType() == 34)) {
            return true;
        }
        return false;
    }

    public final void E(int busiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, busiType);
        } else {
            k(busiType, new a(), true);
        }
    }

    public final void F(@Nullable String adJson, @NotNull com.tencent.mobileqq.ad.loadingad.b chooseAdEndListener) {
        File file;
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) adJson, (Object) chooseAdEndListener);
            return;
        }
        Intrinsics.checkNotNullParameter(chooseAdEndListener, "chooseAdEndListener");
        List<GdtAd> j3 = j(adJson);
        if (j3.isEmpty()) {
            return;
        }
        GdtAd gdtAd = j3.get(0);
        long aId = gdtAd.getAId();
        final String traceId = gdtAd.getTraceId();
        final com.tencent.mobileqq.ad.loadingad.a aVar = new com.tencent.mobileqq.ad.loadingad.a(gdtAd, y());
        final b bVar = new b(chooseAdEndListener, traceId, adJson, aId, aVar);
        String b16 = aVar.b();
        if (b16 != null) {
            file = new File(b16);
        } else {
            file = null;
        }
        if (file != null && file.exists()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("LoadingAdHelper", 1, "processSelectAdWithUncachedAd \u4e4b\u524d\u7684\u5b9e\u65f6\u5e7f\u544a\u4e0b\u8f7d\u8fc7 \u56e0\u5b9e\u65f6\u5e7f\u544a\u4e0d\u843d\u5730 \u5bfc\u81f4\u7684\u672c\u5730\u6709\u56fe\u7247\u4f46\u662f\u6ca1\u4fe1\u606f\u7684\u60c5\u51b5 \u76f4\u63a5\u56de\u8c03");
            String b17 = aVar.b();
            if (b17 == null) {
                str = "";
            } else {
                str = b17;
            }
            if (traceId == null) {
                str2 = "";
            } else {
                str2 = traceId;
            }
            z(adJson, aId, str, str2, MiniLoadingAdReportHelper.EVENT_LOAD_CACHED, chooseAdEndListener);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ad.loadingad.d
            @Override // java.lang.Runnable
            public final void run() {
                g.G(a.this, traceId, bVar);
            }
        }, 128, null, false);
    }

    public final void H(@NotNull String key, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        MMKVOptionEntity from = QMMKV.from(s(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeString(key, value);
    }

    public final void I(int busiType, @NotNull com.tencent.mobileqq.ad.loadingad.b chooseAdEndListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, busiType, (Object) chooseAdEndListener);
            return;
        }
        Intrinsics.checkNotNullParameter(chooseAdEndListener, "chooseAdEndListener");
        h();
        ((IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class)).reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_START, null, null);
        l(this, busiType, new c(chooseAdEndListener), false, 4, null);
    }

    public final void J(@Nullable Activity activity, @NotNull com.tencent.mobileqq.ad.loadingad.c info, @NotNull i adShowStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, info, adShowStateListener);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(adShowStateListener, "adShowStateListener");
        if (activity == null) {
            QLog.e("LoadingAdHelper", 1, "showAd error: container is null");
            adShowStateListener.a(false);
            return;
        }
        String a16 = info.a();
        long b16 = info.b();
        if (!TextUtils.isEmpty(info.a()) && b16 > 0) {
            String str = cachedAidImagePathMap.get(Long.valueOf(b16));
            if (TextUtils.isEmpty(str)) {
                QLog.e("LoadingAdHelper", 1, "showLoadingAd error: imagePath is empty");
                adShowStateListener.a(false);
                return;
            }
            QLog.d("LoadingAdHelper", 2, "showAd:" + a16);
            IMiniLoadingAdApi iMiniLoadingAdApi = (IMiniLoadingAdApi) QRoute.api(IMiniLoadingAdApi.class);
            int i3 = mAdType;
            String e16 = info.e();
            String d16 = info.d();
            String c16 = info.c();
            String str2 = cachedAidVideoPathMap.get(Long.valueOf(b16));
            if (str2 == null) {
                str2 = "";
            }
            iMiniLoadingAdApi.updateLoadingAdLayoutAndShow(activity, i3, a16, e16, d16, c16, str, str2, b16, new d(adShowStateListener, activity));
            return;
        }
        QLog.e("LoadingAdHelper", 1, "showLoadingAd error: ad is empty");
        adShowStateListener.a(false);
    }

    @NotNull
    public final List<GdtAd> j(@Nullable String json) {
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) json);
        }
        ArrayList arrayList = new ArrayList();
        try {
            list = ((qq_ad_get.QQAdGetRsp) qq_ad_get.QQAdGetRsp.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp(), new JSONObject(json)))).pos_ads_info.get();
        } catch (Exception e16) {
            QLog.e("LoadingAdHelper", 1, "convertJson2GdtAds", e16);
        }
        if (list != null && !list.isEmpty()) {
            arrayList.clear();
            Iterator<qq_ad_get.QQAdGetRsp.PosAdInfo> it = list.iterator();
            while (it.hasNext()) {
                List<qq_ad_get.QQAdGetRsp.AdInfo> list2 = it.next().ads_info.get();
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<qq_ad_get.QQAdGetRsp.AdInfo> it5 = list2.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(new GdtAd(it5.next()));
                    }
                }
                QLog.e("LoadingAdHelper", 1, "convertJson2GdtAds() adInfos.isEmpty");
            }
            Object[] array = arrayList.toArray(new GdtAd[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String arrays = Arrays.toString(array);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            QLog.d("LoadingAdHelper", 1, "convertJson2GdtAds() result = [" + arrays + "]");
            return arrayList;
        }
        QLog.e("LoadingAdHelper", 1, "convertJson2GdtAds() posAdInfos.isEmpty");
        return arrayList;
    }

    @NotNull
    public final String u(@Nullable String url) {
        int lastIndexOf$default;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
        }
        try {
            url = new URL(url).getPath();
        } catch (Exception e16) {
            QLog.e("LoadingAdHelper", 1, "getFileSuffixByUrl error", e16);
        }
        String str = "";
        if (!TextUtils.isEmpty(url)) {
            if (url != null) {
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, ".", 0, false, 6, (Object) null);
                if (lastIndexOf$default != -1 && (i3 = lastIndexOf$default + 1) < url.length()) {
                    str = url.substring(i3);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                }
            } else {
                return "";
            }
        }
        return "." + str;
    }

    @NotNull
    public final String v(@Nullable String url, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) url, (Object) uin);
        }
        return w() + MD5Utils.toMD5(url) + "_" + MD5Utils.toMD5(uin);
    }

    @NotNull
    public final String x(@NotNull String key, @NotNull String defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        MMKVOptionEntity from = QMMKV.from(s(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        String decodeString = from.decodeString(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(key, defaultValue)");
        return decodeString;
    }
}
