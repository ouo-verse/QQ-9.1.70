package com.tencent.mobileqq.zplan.utils;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
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
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J%\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/DebugUtils;", "", "", "d", CommonConstant.KEY_ACCESS_TOKEN, "Ljava/io/File;", "file", "Lokhttp3/Callback;", "callback", "", "e", "cacheDirPath", "content", tl.h.F, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "avatarString", "g", "Lorg/json/JSONObject;", "message", "f", "dirPath", "", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DebugUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final DebugUtils f335718a = new DebugUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/utils/DebugUtils$a", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "Lokio/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f335719a;

        a(b bVar) {
            this.f335719a = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            e16.printStackTrace();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                JSONObject message = new JSONObject().put(AppConstants.Key.COLUMN_MSG_TYPE, "file").put("agentid", 1).put("file", new JSONObject().put("media_id", new JSONObject(body != null ? body.string() : null).getString("media_id"))).put("safe", 0).put("enable_duplicate_check", 0).put("duplicate_check_interval", TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
                DebugUtils debugUtils = DebugUtils.f335718a;
                Intrinsics.checkNotNullExpressionValue(message, "message");
                debugUtils.f("21218ba7-97be-42b3-980f-22fd7ed9d812", message, this.f335719a);
                return;
            }
            QLog.e("DebugUtils", 2, "fileUploadCallback failed:" + response.code());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/utils/DebugUtils$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f335720a;

        b(String str) {
            this.f335720a = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            DebugUtils.f335718a.c(this.f335720a);
            QLog.e("DebugUtils", 2, "wechat messageCallback failed: " + e16);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            DebugUtils.f335718a.c(this.f335720a);
            QLog.i("DebugUtils", 2, "wechat messageCallback success");
        }
    }

    DebugUtils() {
    }

    private final String d() {
        String format = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(Date())");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String accessToken, File file, Callback callback) {
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
    public final boolean c(String dirPath) {
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
                if (c(absolutePath)) {
                }
                z16 = false;
            }
        }
        return file.delete() && z16;
    }

    public final void f(String accessToken, JSONObject message, Callback callback) {
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

    public final void g(String avatarString, String cacheDirPath) {
        Intrinsics.checkNotNullParameter(avatarString, "avatarString");
        Intrinsics.checkNotNullParameter(cacheDirPath, "cacheDirPath");
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            QLog.i("DebugUtils", 2, "network not available, return immediately");
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), Dispatchers.getIO(), null, new DebugUtils$zipAndUploadAvatarJsonToWorkChat$1(cacheDirPath, avatarString, new a(new b(cacheDirPath)), null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(String str, String str2, Continuation<? super String> continuation) {
        try {
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String str3 = bb.f335811a.e() + d();
            File file = new File(str + "/" + str3 + ".zip");
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                Boxing.boxBoolean(parentFile.mkdirs());
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str3 + Sticker.JSON_SUFFIX));
                    zipOutputStream.write(bytes);
                    zipOutputStream.closeEntry();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(zipOutputStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return file.getAbsolutePath();
                } finally {
                }
            } finally {
            }
        } catch (Exception e16) {
            QLog.e("DebugUtils", 2, "avatar zip error : " + e16);
            e16.printStackTrace();
            return null;
        }
    }
}
