package com.tencent.mobileqq.emoticon;

import android.util.Pair;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J>\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/emoticon/n;", "", "Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResMgr$DownloadResItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "savePath", "Lcom/tencent/mobileqq/emoticon/n$a;", "downloadEmoticonResListener", "", "e", "d", "", "restType", "configPath", "configFileName", "configMd5", "", "needCheckInnerAsset", "Landroid/util/Pair;", "Lorg/json/JSONObject;", "c", "saveDir", "b", "Ljava/lang/Boolean;", "sSysFaceDownloadUseHttpTask", "<init>", "()V", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f204850a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean sSysFaceDownloadUseHttpTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticon/n$a;", "", "Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResMgr$DownloadResItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "filePath", "", "isSuc", "", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void a(@NotNull QQSysAndEmojiResMgr.DownloadResItem item, @NotNull String filePath, boolean isSuc);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/emoticon/n$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f204852a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQSysAndEmojiResMgr.DownloadResItem f204853b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f204854c;

        b(String str, QQSysAndEmojiResMgr.DownloadResItem downloadResItem, a aVar) {
            this.f204852a = str;
            this.f204853b = downloadResItem;
            this.f204854c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, downloadResItem, aVar);
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) call, (Object) e16);
                return;
            }
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            n.f204850a.b(this.f204852a);
            File file = new File(this.f204852a, this.f204853b.mName);
            QLog.e("QQSysAndEmojiResMgrUtil", 1, "[sendDownloadRequest] failed! url=" + this.f204853b.mUrl + ", stack=", e16);
            a aVar = this.f204854c;
            if (aVar != null) {
                QQSysAndEmojiResMgr.DownloadResItem downloadResItem = this.f204853b;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                aVar.a(downloadResItem, absolutePath, false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:63:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            FileOutputStream fileOutputStream;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) call, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (QLog.isColorLevel()) {
                QLog.d("QQSysAndEmojiResMgrUtil", 2, "[sendDownloadRequest] success! url=" + this.f204853b.mUrl);
            }
            byte[] bArr = new byte[2048];
            n.f204850a.b(this.f204852a);
            File file = new File(this.f204852a, this.f204853b.mName);
            InputStream inputStream = null;
            try {
                ResponseBody body = response.body();
                Intrinsics.checkNotNull(body);
                InputStream byteStream = body.byteStream();
                try {
                    ResponseBody body2 = response.body();
                    Intrinsics.checkNotNull(body2);
                    body2.getContentLength();
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        } catch (IOException e16) {
                            e = e16;
                            inputStream = byteStream;
                            try {
                                QLog.e("QQSysAndEmojiResMgrUtil", 1, e, new Object[0]);
                                a aVar = this.f204854c;
                                if (aVar != null) {
                                    QQSysAndEmojiResMgr.DownloadResItem downloadResItem = this.f204853b;
                                    String absolutePath = file.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                                    aVar.a(downloadResItem, absolutePath, false);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e17) {
                                        QLog.e("QQSysAndEmojiResMgrUtil", 1, e17, new Object[0]);
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e18) {
                                        QLog.e("QQSysAndEmojiResMgrUtil", 1, e18, new Object[0]);
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e19) {
                                        QLog.e("QQSysAndEmojiResMgrUtil", 1, e19, new Object[0]);
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (IOException e26) {
                                        QLog.e("QQSysAndEmojiResMgrUtil", 1, e26, new Object[0]);
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream = byteStream;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream == null) {
                            }
                        }
                    }
                    fileOutputStream.flush();
                    a aVar2 = this.f204854c;
                    if (aVar2 != null) {
                        QQSysAndEmojiResMgr.DownloadResItem downloadResItem2 = this.f204853b;
                        String absolutePath2 = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath2, "file.absolutePath");
                        aVar2.a(downloadResItem2, absolutePath2, true);
                    }
                    try {
                        byteStream.close();
                    } catch (IOException e27) {
                        QLog.e("QQSysAndEmojiResMgrUtil", 1, e27, new Object[0]);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e28) {
                        QLog.e("QQSysAndEmojiResMgrUtil", 1, e28, new Object[0]);
                    }
                } catch (IOException e29) {
                    e = e29;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (IOException e36) {
                e = e36;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/emoticon/n$c", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onSuccess", "onFailed", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements com.tencent.qqnt.http.api.l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQSysAndEmojiResMgr.DownloadResItem f204855a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f204856b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ File f204857c;

        c(QQSysAndEmojiResMgr.DownloadResItem downloadResItem, a aVar, File file) {
            this.f204855a = downloadResItem;
            this.f204856b = aVar;
            this.f204857c = file;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, downloadResItem, aVar, file);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.e("QQSysAndEmojiResMgrUtil", 1, "[sendDownloadRequestUseHttpTask] failed. url=" + this.f204855a.mUrl + ", result=" + result);
            a aVar = this.f204856b;
            if (aVar != null) {
                QQSysAndEmojiResMgr.DownloadResItem downloadResItem = this.f204855a;
                String absolutePath = this.f204857c.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                aVar.a(downloadResItem, absolutePath, false);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            if (QLog.isColorLevel()) {
                QLog.d("QQSysAndEmojiResMgrUtil", 2, "[sendDownloadRequestUseHttpTask] success. url=" + this.f204855a.mUrl);
            }
            a aVar = this.f204856b;
            if (aVar != null) {
                QQSysAndEmojiResMgr.DownloadResItem downloadResItem = this.f204855a;
                String absolutePath = this.f204857c.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                aVar.a(downloadResItem, absolutePath, true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31225);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f204850a = new n();
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(String saveDir) {
        File file = new File(saveDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return saveDir;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Pair<JSONObject, Boolean> c(int restType, @NotNull String configPath, @NotNull String configFileName, @NotNull String configMd5, boolean needCheckInnerAsset) {
        boolean z16;
        boolean z17;
        long currentTimeMillis;
        File file;
        String str;
        Intrinsics.checkNotNullParameter(configPath, "configPath");
        Intrinsics.checkNotNullParameter(configFileName, "configFileName");
        Intrinsics.checkNotNullParameter(configMd5, "configMd5");
        if (QLog.isColorLevel()) {
            QLog.d("QQSysAndEmojiResMgrUtil", 2, "parseFaceConfigJson restType=" + restType + " configFileName=" + configFileName);
        }
        JSONObject jSONObject = null;
        boolean z18 = true;
        try {
            currentTimeMillis = System.currentTimeMillis();
            file = new File(configPath + configFileName);
            try {
                try {
                } catch (JSONException e16) {
                    e = e16;
                    z16 = false;
                }
            } catch (JSONException e17) {
                e = e17;
                z16 = true;
            }
        } catch (JSONException e18) {
            e = e18;
            z16 = false;
        }
        if (file.exists()) {
            str = com.tencent.qqnt.emotion.utils.h.e(file);
            long D = m.D(restType);
            if (D != file.length()) {
                QLog.i("QQSysAndEmojiResMgrUtil", 1, "getFaceConfigJson, size not match, " + D + "!=" + file.length());
                m.E(restType, "reset");
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("QQSysAndEmojiResMgrUtil", 2, "getFaceConfigJson, size match, expectSize=" + D);
                }
                z17 = false;
                if (str != null) {
                    try {
                        if (str.length() > 0) {
                            JSONObject jSONObject2 = new JSONObject(str);
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQSysAndEmojiResMgrUtil", 2, "getFaceConfigJson len:", Integer.valueOf(jSONObject2.length()), " ,costTime = [", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "]");
                                }
                                jSONObject = jSONObject2;
                            } catch (JSONException e19) {
                                e = e19;
                                jSONObject = jSONObject2;
                                z16 = z17;
                                QLog.e("QQSysAndEmojiResMgrUtil", 1, "parseFaceConfigJson, " + e);
                                z17 = z16;
                                if (z17) {
                                }
                                z18 = z17;
                                return new Pair<>(jSONObject, Boolean.valueOf(z18));
                            }
                        }
                    } catch (JSONException e26) {
                        e = e26;
                    }
                }
                if (z17 && m.j(restType, configMd5)) {
                    QLog.i("QQSysAndEmojiResMgrUtil", 1, "getFaceConfigJson, size match, but md5 not match.");
                } else {
                    z18 = z17;
                }
                return new Pair<>(jSONObject, Boolean.valueOf(z18));
            }
        } else {
            if (needCheckInnerAsset) {
                str = com.tencent.qqnt.emotion.utils.h.f(configFileName);
            } else {
                str = null;
            }
            QLog.e("QQSysAndEmojiResMgrUtil", 1, "getFaceConfigJson not exist!");
            m.E(restType, "reset");
        }
        z17 = true;
        if (str != null) {
        }
        if (z17) {
        }
        z18 = z17;
        return new Pair<>(jSONObject, Boolean.valueOf(z18));
    }

    @JvmStatic
    public static final void d(@NotNull QQSysAndEmojiResMgr.DownloadResItem item, @NotNull String savePath, @Nullable a downloadEmoticonResListener) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        if (sSysFaceDownloadUseHttpTask == null) {
            sSysFaceDownloadUseHttpTask = Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_sysface_download_use_http_task", true));
        }
        if (Intrinsics.areEqual(sSysFaceDownloadUseHttpTask, Boolean.TRUE)) {
            f204850a.e(item, savePath, downloadEmoticonResListener);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSysAndEmojiResMgrUtil", 2, "[sendDownloadRequest] start. url=" + item.mUrl);
        }
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request.Builder builder = new Request.Builder();
        String str = item.mUrl;
        Intrinsics.checkNotNullExpressionValue(str, "item.mUrl");
        build.newCall(builder.url(str).build()).enqueue(new b(savePath, item, downloadEmoticonResListener));
    }

    private final void e(QQSysAndEmojiResMgr.DownloadResItem item, String savePath, a downloadEmoticonResListener) {
        if (QLog.isColorLevel()) {
            QLog.d("QQSysAndEmojiResMgrUtil", 2, "[sendDownloadRequestUseHttpTask] start. url=" + item.mUrl);
        }
        b(savePath);
        File file = new File(savePath, item.mName);
        String str = item.mUrl;
        Intrinsics.checkNotNullExpressionValue(str, "item.mUrl");
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(new b.a("SysAndEmoji", str, file).R(true).T(new c(item, downloadEmoticonResListener, file)).c());
    }
}
