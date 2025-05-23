package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet;
import com.tencent.mobileqq.guild.media.thirdapp.share.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.LoadingUtil;
import com.tencent.util.UiThreadUtil;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u00011\u0018\u0000 62\u00020\u0001:\u00027%B\u0007\u00a2\u0006\u0004\b4\u00105J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J>\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011H\u0002J'\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016JD\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001dH\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\rH\u0016J\"\u0010)\u001a\u00020!2\u0006\u0010&\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00102\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "code", "shareType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lokhttp3/Response;", "response", "", ReportConstant.COSTREPORT_PREFIX, "", "imageUrl", "t", "query", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "u", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod$b;", "w", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$e;", "extraInfo", "Lkotlin/Function2;", HippyTKDListViewAdapter.X, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "v", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "b", "url", "Lorg/json/JSONObject;", "args", "c", "d", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "checkJob", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "progressDialog", "com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod$timeOutRunnable$1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod$timeOutRunnable$1;", "timeOutRunnable", "<init>", "()V", "g", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ShareAppMessageMethod extends o {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b checkJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog progressDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareAppMessageMethod$timeOutRunnable$1 timeOutRunnable = new ShareAppMessageMethod$timeOutRunnable$1(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod$c", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/b;", "", "code", "", "fileId", "sessionId", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.thirdapp.share.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<FetchRsp> f229309a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super FetchRsp> cancellableContinuation) {
            this.f229309a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.share.b
        public void onResult(int code, @Nullable String fileId, @Nullable String sessionId) {
            Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[FetchShareInfoCallback] callback code " + code + ", fileId " + fileId + " sessionId " + sessionId);
            CancellableContinuation<FetchRsp> cancellableContinuation = this.f229309a;
            Result.Companion companion = Result.INSTANCE;
            if (fileId == null) {
                fileId = "";
            }
            if (sessionId == null) {
                sessionId = "";
            }
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new FetchRsp(code, fileId, sessionId)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod$d", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$d;", "", "code", "shareType", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements GuildMediaShareActionSheet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, Integer, Unit> f229310a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super Integer, ? super Integer, Unit> function2) {
            this.f229310a = function2;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet.d
        public void a(int code, int shareType) {
            Function2<Integer, Integer, Unit> function2 = this.f229310a;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(code), Integer.valueOf(shareType));
            }
            Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[MediaShareCallback] code " + code + ", shareType " + shareType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback, int code, int shareType) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", String.valueOf(code));
        jSONObject.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, String.valueOf(shareType));
        c.a.a(callback, jSONObject, false, 2, null);
        Dialog dialog = this.progressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        UiThreadUtil.remove(this.timeOutRunnable);
        Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[callbackToJs] code " + code + ", shareType " + shareType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r(ShareAppMessageMethod shareAppMessageMethod, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = -10001;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        shareAppMessageMethod.q(cVar, i3, i16);
    }

    private final long s(Response response) {
        ResponseBody body = response.body();
        if (body == null) {
            return -1L;
        }
        InputStream byteStream = body.byteStream();
        byte[] bArr = new byte[4096];
        long j3 = 0;
        do {
            try {
                int read = byteStream.read(bArr);
                if (read == -1) {
                    break;
                }
                j3 += read;
            } finally {
            }
        } while (j3 <= 1048576);
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(byteStream, null);
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t(String imageUrl) {
        Long longOrNull;
        String str = "0";
        boolean z16 = true;
        long j3 = -1;
        try {
            Response execute = new OkHttpClient().newCall(new Request.Builder().url(imageUrl).head().build()).execute();
            Logger logger = Logger.f235387a;
            logger.d().d("ShareAppMessageMethod", 1, "[doCheckImageSize] response " + execute.code());
            if (execute.isSuccessful()) {
                String header = execute.header("Content-Length", "0");
                if (header != null) {
                    str = header;
                }
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = 0;
                }
                logger.d().d("ShareAppMessageMethod", 1, "[doCheckImageSize] Content-Length " + j3);
                if (j3 == 0) {
                    j3 = s(execute);
                    logger.d().d("ShareAppMessageMethod", 1, "[doCheckImageSize] checkIfByteStreamSize " + j3);
                }
            }
            execute.close();
        } catch (Throwable th5) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "[checkImageSize] error " + th5;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("ShareAppMessageMethod", 1, (String) it.next(), th5);
            }
        }
        if (1 > j3 || j3 >= 1048577) {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return -10001;
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b u(String imageUrl, String query, Function3<? super Integer, ? super String, ? super String, Unit> callback) {
        return CorountineFunKt.e(com.tencent.mobileqq.guild.media.core.j.b(), "fetchShareInfo", Boolean.TRUE, null, null, new ShareAppMessageMethod$fetchShareInfo$1(imageUrl, callback, this, query, null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v(Activity activity) {
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object w(String str, String str2, Continuation<? super FetchRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (guildInfo != null && channelInfo != null) {
            IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
            IGProLobbyStateInfo lobbyRoomInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getLobbyRoomInfo();
            if (thirdAppInfo != null && lobbyRoomInfo != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", thirdAppInfo.getAppId());
                jSONObject.put("appName", thirdAppInfo.getAppName());
                jSONObject.put("channelId", com.tencent.mobileqq.guild.media.core.j.a().E());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playAppInfo", jSONObject);
                jSONObject2.put("query", str2);
                Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[requestSessionId] GuildMediaFetchShareUseCase.request " + jSONObject2);
                g.Companion companion = com.tencent.mobileqq.guild.media.thirdapp.share.g.INSTANCE;
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "queryString.toString()");
                companion.b(jSONObject3, str, new c(cancellableContinuationImpl));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new FetchRsp(-1, null, null, 6, null)));
            }
        } else {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[requestSessionId] guildInfo or channelInfo is null, ignore");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("ShareAppMessageMethod", 1, (String) it.next(), null);
            }
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new FetchRsp(-1, null, null, 6, null)));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo, GuildMediaShareActionSheet.MediaShareExtraInfo extraInfo, Function2<? super Integer, ? super Integer, Unit> callback) {
        Activity activity;
        WeakReference<Activity> a16 = e().a();
        if (a16 != null && (activity = a16.get()) != null) {
            GuildMediaShareActionSheet guildMediaShareActionSheet = new GuildMediaShareActionSheet(activity, guildInfo, channelInfo, GuildMediaShareActionSheet.ShareScene.THIRD_APP_JSAPI);
            if (extraInfo != null) {
                guildMediaShareActionSheet.W(extraInfo);
            }
            guildMediaShareActionSheet.X(new d(callback));
            guildMediaShareActionSheet.z();
            return;
        }
        if (callback != null) {
            callback.invoke(-1, 0);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return com.tencent.luggage.wxa.c3.d.NAME;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull final com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        String str;
        final String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        final Activity activity;
        Job f16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (args != null) {
            str = args.optString("title");
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (args != null) {
            str3 = args.optString("image_url");
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        if (args != null) {
            str5 = args.optString("query");
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        WeakReference<Activity> a16 = e().a();
        if (a16 == null || (activity = a16.get()) == null) {
            return false;
        }
        if (v(activity)) {
            r(this, callback, 0, 0, 6, null);
            return false;
        }
        Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[onInvoke] customTitle " + str2 + ", imageUrl " + str4 + " queryString " + str6);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.checkJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        Dialog dialog = this.progressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(activity, 1, false);
        this.progressDialog = showOnlyLoadingImageDialog;
        if (showOnlyLoadingImageDialog != null) {
            showOnlyLoadingImageDialog.show();
        }
        this.timeOutRunnable.a(new mqq.util.WeakReference<>(callback));
        UiThreadUtil.runOnUiThread(this.timeOutRunnable, 15000L);
        final String str7 = str4;
        this.checkJob = u(str4, str6, new Function3<Integer, String, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod$onInvoke$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str8, String str9) {
                invoke(num.intValue(), str8, str9);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String fileId, @NotNull String sessionId) {
                IGProChannelInfo channelInfo;
                boolean v3;
                Dialog dialog2;
                ShareAppMessageMethod$timeOutRunnable$1 shareAppMessageMethod$timeOutRunnable$1;
                Intrinsics.checkNotNullParameter(fileId, "fileId");
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[fetchShareInfo] fileId " + fileId + " sessionId " + sessionId);
                if (i3 != 0) {
                    ShareAppMessageMethod.r(ShareAppMessageMethod.this, callback, i3, 0, 4, null);
                    return;
                }
                GuildMediaShareActionSheet.MediaShareExtraInfo mediaShareExtraInfo = new GuildMediaShareActionSheet.MediaShareExtraInfo(str2, fileId, sessionId, str7);
                IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
                if (guildInfo == null || (channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo()) == null) {
                    return;
                }
                v3 = ShareAppMessageMethod.this.v(activity);
                if (!v3) {
                    dialog2 = ShareAppMessageMethod.this.progressDialog;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                    shareAppMessageMethod$timeOutRunnable$1 = ShareAppMessageMethod.this.timeOutRunnable;
                    UiThreadUtil.remove(shareAppMessageMethod$timeOutRunnable$1);
                    final ShareAppMessageMethod shareAppMessageMethod = ShareAppMessageMethod.this;
                    final com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar = callback;
                    shareAppMessageMethod.x(guildInfo, channelInfo, mediaShareExtraInfo, new Function2<Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod$onInvoke$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                            invoke(num.intValue(), num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i16, int i17) {
                            Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[showShareActionSheet callback] code " + i16 + " shareType " + i17);
                            ShareAppMessageMethod.this.q(cVar, i16 == 0 ? 0 : 1, i17);
                        }
                    });
                    return;
                }
                ShareAppMessageMethod.r(ShareAppMessageMethod.this, callback, 0, 0, 6, null);
            }
        });
        return super.c(url, args, callback);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o
    @NotNull
    public String f() {
        return "ShareAppMessageMethod";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public void onDestroy() {
        Job f16;
        super.onDestroy();
        Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[onDestroy] ");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.checkJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/ShareAppMessageMethod$b;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "fileId", "c", "sessionId", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class FetchRsp {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String fileId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sessionId;

        public FetchRsp(int i3, @NotNull String fileId, @NotNull String sessionId) {
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.code = i3;
            this.fileId = fileId;
            this.sessionId = sessionId;
        }

        /* renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public final boolean d() {
            if (this.code == 0) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FetchRsp)) {
                return false;
            }
            FetchRsp fetchRsp = (FetchRsp) other;
            if (this.code == fetchRsp.code && Intrinsics.areEqual(this.fileId, fetchRsp.fileId) && Intrinsics.areEqual(this.sessionId, fetchRsp.sessionId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.code * 31) + this.fileId.hashCode()) * 31) + this.sessionId.hashCode();
        }

        @NotNull
        public String toString() {
            return "FetchRsp(code=" + this.code + ", fileId=" + this.fileId + ", sessionId=" + this.sessionId + ")";
        }

        public /* synthetic */ FetchRsp(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2);
        }
    }
}
