package com.tencent.robot.adelie.homepage.utils;

import android.content.Context;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/AdelieAvatarUgcDebugUtil;", "", "", CommonConstant.KEY_ACCESS_TOKEN, "Ljava/io/File;", "file", "Lokhttp3/Callback;", "callback", "", "c", "Landroid/content/Context;", "context", "cacheDirPath", "zipFilePath", "e", "Lorg/json/JSONObject;", "message", "d", "dirPath", "", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarUgcDebugUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdelieAvatarUgcDebugUtil f366632a = new AdelieAvatarUgcDebugUtil();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/adelie/homepage/utils/AdelieAvatarUgcDebugUtil$a", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f366633a;

        a(b bVar) {
            this.f366633a = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            this.f366633a.onFailure(call, e16);
            QLog.e("AdelieAvatarUgcDebugUtil", 2, "wechat fileUploadCallback failed: " + e16);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            String str;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    str = body.string();
                } else {
                    str = null;
                }
                JSONObject message = new JSONObject().put(AppConstants.Key.COLUMN_MSG_TYPE, "file").put("agentid", 1).put("file", new JSONObject().put("media_id", new JSONObject(str).getString("media_id"))).put("safe", 0).put("enable_duplicate_check", 0).put("duplicate_check_interval", TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
                AdelieAvatarUgcDebugUtil adelieAvatarUgcDebugUtil = AdelieAvatarUgcDebugUtil.f366632a;
                Intrinsics.checkNotNullExpressionValue(message, "message");
                adelieAvatarUgcDebugUtil.d("e424a177-399d-4664-abbc-9db656e97133", message, this.f366633a);
                return;
            }
            QLog.e("AdelieAvatarUgcDebugUtil", 2, "fileUploadCallback failed:" + response.code());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/adelie/homepage/utils/AdelieAvatarUgcDebugUtil$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f366634a;

        b(String str) {
            this.f366634a = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            AdelieAvatarUgcDebugUtil.f366632a.b(this.f366634a);
            QLog.e("AdelieAvatarUgcDebugUtil", 2, "wechat messageCallback failed: " + e16);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            AdelieAvatarUgcDebugUtil.f366632a.b(this.f366634a);
            QLog.i("AdelieAvatarUgcDebugUtil", 2, "wechat messageCallback success");
        }
    }

    AdelieAvatarUgcDebugUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String accessToken, File file, Callback callback) {
        new OkHttpClient().newCall(new Request.Builder().url("https://qyapi.weixin.qq.com/cgi-bin/webhook/upload_media?key=" + accessToken + "&type=file").post(new MultipartBody.Builder(null, 1, 0 == true ? 1 : 0).setType(MultipartBody.FORM).addFormDataPart(QAdVrReportParams.ParamKey.MEDIA, file.getName(), RequestBody.INSTANCE.create(MediaType.INSTANCE.parse("application/octet-stream"), file)).build()).build()).enqueue(callback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r5 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(@NotNull String dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        File file = new File(dirPath);
        if (!file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        Intrinsics.checkNotNull(listFiles);
        boolean z16 = true;
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (file2.delete()) {
                }
                z16 = false;
            } else if (file2.isDirectory()) {
                String absolutePath = file2.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                if (b(absolutePath)) {
                }
                z16 = false;
            }
        }
        if (!file.delete() || !z16) {
            return false;
        }
        return true;
    }

    public final void d(@NotNull String accessToken, @NotNull JSONObject message, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType parse = MediaType.INSTANCE.parse("application/json; charset=utf-8");
        String jSONObject = message.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "message.toString()");
        okHttpClient.newCall(new Request.Builder().url("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=" + accessToken).post(companion.create(parse, jSONObject)).build()).enqueue(callback);
    }

    public final void e(@NotNull Context context, @NotNull String cacheDirPath, @NotNull String zipFilePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheDirPath, "cacheDirPath");
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        if (!NetworkUtil.isNetworkAvailable(context)) {
            QLog.i("AdelieAvatarUgcDebugUtil", 2, "network not available, return immediately");
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), Dispatchers.getIO(), null, new AdelieAvatarUgcDebugUtil$uploadUgcTemplateToWorkChat$1(zipFilePath, new a(new b(cacheDirPath)), null), 2, null);
        }
    }
}
