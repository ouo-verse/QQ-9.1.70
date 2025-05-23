package com.tencent.biz.qrcode.mgr;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qrcode.util.f;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.qrscan.m;
import com.tencent.mobileqq.qrscan.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002Z1B\t\b\u0002\u00a2\u0006\u0004\bX\u0010YJJ\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002Jt\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00052`\u0010\f\u001a\\\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u000b0!H\u0002J\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u000bJ)\u0010'\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0&J\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(J\u0006\u0010,\u001a\u00020+J\u000e\u0010.\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020-J\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020-R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020-008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010O\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006["}, d2 = {"Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager;", "", "", "url", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "downloadUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "L", "filePath", "M", "v", "", HippyTKDListViewAdapter.X, "style", "N", "y", "shortChain", "O", "Lcom/tencent/biz/qrcode/mgr/d;", "data", "B", "o", "isUnsetAIGCStyle", "Lkotlin/Function4;", "H", DomainData.DOMAIN_NAME, UserInfo.SEX_FEMALE, "E", "Lkotlin/Function1;", "J", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "u", "Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager$a;", "D", "P", "", "b", "Ljava/util/List;", "listeners", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "w", "()Landroid/os/Handler;", "handler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setDownloading", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isDownloading", "e", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "K", "(Ljava/lang/String;)V", PanoramaConfig.KEY_CURRENT_UIN, "f", "Lcom/tencent/biz/qrcode/mgr/d;", "r", "()Lcom/tencent/biz/qrcode/mgr/d;", "setCurrentQRCodeData", "(Lcom/tencent/biz/qrcode/mgr/d;)V", "currentQRCodeData", "Lmqq/app/IAccountCallback;", "g", "Lmqq/app/IAccountCallback;", "accountCallback", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "downloadTimeoutRunnable", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class MyQRCodeManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MyQRCodeManager f94961a = new MyQRCodeManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> listeners = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler = new Handler();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean isDownloading = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String currentUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.biz.qrcode.mgr.d currentQRCodeData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAccountCallback accountCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable downloadTimeoutRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager$a;", "", "Lcom/tencent/biz/qrcode/mgr/d;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public interface a {
        void a(@Nullable com.tencent.biz.qrcode.mgr.d data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager$b;", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "", "getBusinessKey", "getDownloadRootPath", "Landroid/content/SharedPreferences;", "getSP", "", "supportUnZipFile", "supportBreakPointDownload", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b extends RFWDownloadStrategy {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f94969a = new b();

        b() {
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @NotNull
        public String getBusinessKey() {
            return "QRCodeDownloadStrategy";
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @NotNull
        public String getDownloadRootPath() {
            return MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/qrcode/";
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        @NotNull
        public SharedPreferences getSP() {
            SharedPreferences preferences = MobileQQ.sMobileQQ.peekAppRuntime().getPreferences();
            Intrinsics.checkNotNullExpressionValue(preferences, "sMobileQQ.peekAppRuntime().preferences");
            return preferences;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportBreakPointDownload() {
            return true;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportUnZipFile() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qrcode/mgr/MyQRCodeManager$c", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements IAccountCallback {
        c() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            QLog.i("MyQRCodeManager", 1, "onAccountChangeFailed, currentUin = " + MyQRCodeManager.f94961a.s());
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            String str;
            MyQRCodeManager myQRCodeManager = MyQRCodeManager.f94961a;
            myQRCodeManager.n();
            if (newRuntime != null) {
                str = newRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            myQRCodeManager.K(String.valueOf(str));
            QLog.i("MyQRCodeManager", 1, "onAccountChanged, currentUin = " + myQRCodeManager.s());
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            QLog.i("MyQRCodeManager", 1, "onLogout, reason = " + reason);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qrcode/mgr/MyQRCodeManager$e", "Lcom/tencent/mobileqq/qrscan/o;", "", "i", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class e extends o {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function4<Boolean, Integer, String, String, Unit> f94972d;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function4<? super Boolean, ? super Integer, ? super String, ? super String, Unit> function4) {
            this.f94972d = function4;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
        @Override // com.tencent.mobileqq.qrscan.o, mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean isSuccess, @Nullable Bundle bundle) {
            String str;
            boolean z16 = false;
            if (isSuccess && bundle != null && bundle.containsKey("result")) {
                String string = bundle.getString("result");
                if (string == null) {
                    return;
                }
                String str2 = null;
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.getInt("r") == 0) {
                        z16 = jSONObject.optBoolean("is_use_custom_qr_code", false);
                        String string2 = jSONObject.getString("url");
                        if (z16) {
                            try {
                                str2 = jSONObject.optString("custom_qr_code_url");
                                QLog.i("MyQRCodeManager", 1, "[sendEncodeRequest][onReceive]downloadUrl=" + str2);
                            } catch (Exception e16) {
                                e = e16;
                                String str3 = str2;
                                str2 = string2;
                                str = str3;
                                QLog.e("MyQRCodeManager", 1, "QRCodeBusinessObserver onReceive error, ", e);
                                if (!TextUtils.isEmpty(str2)) {
                                }
                            }
                        }
                        String str4 = str2;
                        str2 = string2;
                        str = str4;
                    } else {
                        str = null;
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    QLog.e("MyQRCodeManager", 1, "[sendEncodeRequest][onReceive]shortChain is empty!");
                    this.f94972d.invoke(Boolean.FALSE, 0, "", "");
                    return;
                }
                if (z16 && !TextUtils.isEmpty(str)) {
                    Function4<Boolean, Integer, String, String, Unit> function4 = this.f94972d;
                    Boolean bool = Boolean.TRUE;
                    Intrinsics.checkNotNull(str2);
                    Intrinsics.checkNotNull(str);
                    function4.invoke(bool, 2, str2, str);
                    return;
                }
                if (!z16) {
                    Function4<Boolean, Integer, String, String, Unit> function42 = this.f94972d;
                    Boolean bool2 = Boolean.TRUE;
                    Intrinsics.checkNotNull(str2);
                    function42.invoke(bool2, 1, str2, "");
                    return;
                }
                QLog.e("MyQRCodeManager", 1, "[sendEncodeRequest][onReceive]now is aigc style, but downloadUrl is empty.");
                Function4<Boolean, Integer, String, String, Unit> function43 = this.f94972d;
                Boolean bool3 = Boolean.TRUE;
                Intrinsics.checkNotNull(str2);
                function43.invoke(bool3, 1, str2, "");
                return;
            }
            QLog.e("MyQRCodeManager", 1, "[sendEncodeRequest][onReceive]fail.");
            this.f94972d.invoke(Boolean.FALSE, 0, "", "");
        }
    }

    static {
        currentUin = "";
        c cVar = new c();
        accountCallback = cVar;
        downloadTimeoutRunnable = new Runnable() { // from class: com.tencent.biz.qrcode.mgr.b
            @Override // java.lang.Runnable
            public final void run() {
                MyQRCodeManager.p();
            }
        };
        MobileQQ.sMobileQQ.registerAccountCallback(cVar);
        String currentUin2 = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        currentUin = currentUin2;
        QLog.i("MyQRCodeManager", 1, "new instance, currentUin = " + currentUin2);
    }

    MyQRCodeManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(final com.tencent.biz.qrcode.mgr.d data) {
        if (!data.a()) {
            QLog.e("MyQRCodeManager", 1, "notify data invalid:" + data);
            QLog.e("MyQRCodeManager", 1, QLog.getStackTraceString(new Throwable("notify data invalid.")));
            return;
        }
        com.tencent.biz.qrcode.mgr.d dVar = currentQRCodeData;
        boolean z16 = false;
        if (dVar != null && dVar.equals(data)) {
            z16 = true;
        }
        if (z16) {
            QLog.i("MyQRCodeManager", 1, "needn't notify.");
            return;
        }
        currentQRCodeData = data;
        N(data.getStyle());
        QLog.i("MyQRCodeManager", 1, "notify currentData = " + currentQRCodeData);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qrcode.mgr.a
            @Override // java.lang.Runnable
            public final void run() {
                MyQRCodeManager.C(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(com.tencent.biz.qrcode.mgr.d data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(new com.tencent.biz.qrcode.mgr.d(data.getStyle(), data.getShortChain(), data.getFilePath(), data.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G() {
        f94961a.H(true, new Function4<Boolean, Integer, String, String, Unit>() { // from class: com.tencent.biz.qrcode.mgr.MyQRCodeManager$requestResetToDefault$2$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, String str2) {
                invoke(bool.booleanValue(), num.intValue(), str, str2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, final int i3, @NotNull final String shortChain, @NotNull String url) {
                Intrinsics.checkNotNullParameter(shortChain, "shortChain");
                Intrinsics.checkNotNullParameter(url, "url");
                if (!z16) {
                    QLog.e("MyQRCodeManager", 1, "requestResetToDefault failed.");
                    return;
                }
                if (i3 == 1) {
                    MyQRCodeManager myQRCodeManager = MyQRCodeManager.f94961a;
                    myQRCodeManager.O(shortChain);
                    myQRCodeManager.B(new d(i3, shortChain, null, null, 12, null));
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    QLog.e("MyQRCodeManager", 1, "requestResetToDefault style is wrong.");
                    MyQRCodeManager.f94961a.q(url, new Function2<Boolean, Bitmap, Unit>() { // from class: com.tencent.biz.qrcode.mgr.MyQRCodeManager$requestResetToDefault$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Bitmap bitmap) {
                            invoke(bool.booleanValue(), bitmap);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17, @Nullable Bitmap bitmap) {
                            String v3;
                            if (z17) {
                                MyQRCodeManager myQRCodeManager2 = MyQRCodeManager.f94961a;
                                int i16 = i3;
                                String str = shortChain;
                                v3 = myQRCodeManager2.v();
                                myQRCodeManager2.B(new d(i16, str, v3, bitmap));
                            }
                        }
                    });
                }
            }
        });
    }

    private final void H(boolean isUnsetAIGCStyle, Function4<? super Boolean, ? super Integer, ? super String, ? super String, Unit> cb5) {
        QLog.i("MyQRCodeManager", 1, "[sendEncodeRequest]start, isUnsetAIGCStyle=" + isUnsetAIGCStyle);
        m a16 = m.a(1, currentUin);
        if (a16 == null) {
            QLog.e("MyQRCodeManager", 1, "[sendEncodeRequest]entity is null in sendEncodeRequest");
            cb5.invoke(Boolean.FALSE, 0, "", "");
            return;
        }
        Bundle bundle = new Bundle();
        if (isUnsetAIGCStyle) {
            bundle.putBoolean("is_unset_custom_qr_code", true);
        }
        ((IQRDataApi) QRoute.api(IQRDataApi.class)).requestUrlEncode(MobileQQ.sMobileQQ.peekAppRuntime(), a16.e(), bundle, new e(cb5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void I(MyQRCodeManager myQRCodeManager, boolean z16, Function4 function4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        myQRCodeManager.H(z16, function4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(String url) {
        u().encodeString("aigc_download_url_" + currentUin, url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(String filePath) {
        u().encodeString("aigc_file_path_" + currentUin, filePath);
    }

    private final void N(int style) {
        u().encodeInt("key_my_qrcode_style_" + currentUin, style);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(String shortChain) {
        u().encodeString("key_my_qrcode_short_chain_" + currentUin, shortChain);
    }

    private final boolean m(String downloadUrl) {
        boolean z16;
        boolean z17;
        String str = currentUin;
        if (str == null) {
            return false;
        }
        Intrinsics.checkNotNull(str);
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if (!Intrinsics.areEqual(t(), downloadUrl)) {
            return true;
        }
        if (v().length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && new File(v()).exists()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap o(String filePath) {
        try {
            if (!new File(filePath).exists()) {
                QLog.e("MyQRCodeManager", 1, "decodeBitmapFromFile, but file not exist. filePath = " + filePath);
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            Bitmap decodeFile = BitmapFactory.decodeFile(filePath, options);
            QLog.i("MyQRCodeManager", 1, "decodeBitmapFromFile cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return decodeFile;
        } catch (Throwable th5) {
            QLog.e("MyQRCodeManager", 1, "decodeBitmapFromFile error, ", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        QLog.i("MyQRCodeManager", 1, "download time out.");
        isDownloading.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String url, Function2<? super Boolean, ? super Bitmap, Unit> cb5) {
        if (!m(url)) {
            QLog.i("MyQRCodeManager", 1, "[getBitmapAsync]needn't download.");
            Bitmap o16 = o(v());
            if (o16 != null) {
                cb5.invoke(Boolean.TRUE, o16);
                return;
            } else {
                QLog.e("MyQRCodeManager", 1, "[getBitmapAsync]decode local file failed.");
                cb5.invoke(Boolean.FALSE, null);
                return;
            }
        }
        QLog.i("MyQRCodeManager", 1, "[getBitmapAsync], url = " + url);
        M("");
        L("");
        if (isDownloading.compareAndSet(false, true)) {
            handler.postDelayed(downloadTimeoutRunnable, 10000L);
            RFWDownloaderFactory.getDownloader(b.f94969a).download(url, new d(cb5, url));
        } else {
            QLog.e("MyQRCodeManager", 1, "is downloading now, ignore.");
        }
    }

    private final String t() {
        String decodeString = u().decodeString("aigc_download_url_" + currentUin, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getEntity().decodeString\u2026oad_url_$currentUin\", \"\")");
        return decodeString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v() {
        String decodeString = u().decodeString("aigc_file_path_" + currentUin, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getEntity().decodeString\u2026le_path_$currentUin\", \"\")");
        return decodeString;
    }

    private final int x() {
        return u().decodeInt("key_my_qrcode_style_" + currentUin, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String y() {
        String decodeString = u().decodeString("key_my_qrcode_short_chain_" + currentUin, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getEntity().decodeString\u2026t_chain_$currentUin\", \"\")");
        return decodeString;
    }

    public final void A(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity.getIntent().getBooleanExtra("key_start_by_js", false)) {
            activity.finish();
        } else {
            QRoute.createNavigator(activity, RouterConstants.UI_ROUTE_BROWSER).withBoolean("key_start_by_my_qrcode", true).withString("url", "https://h5.tu.qq.com/web/pretty-qrcode/result?type=1&root_channel=qq_code&current_channel=qq_code&_wv=3&_wwv=1").request();
        }
    }

    public final void D(@NotNull a cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        List<a> list = listeners;
        if (!list.contains(cb5)) {
            list.add(cb5);
        }
    }

    public final void E() {
        QLog.i("MyQRCodeManager", 1, "requestQRCodeData.");
        if (currentQRCodeData != null) {
            return;
        }
        int x16 = x();
        if (x16 != 1) {
            if (x16 == 2) {
                if (!f.a()) {
                    QLog.i("MyQRCodeManager", 1, "AIGC Style is not enabled.");
                    B(new com.tencent.biz.qrcode.mgr.d(1, y(), null, null, 12, null));
                }
                String v3 = v();
                Bitmap o16 = o(v3);
                if (o16 != null) {
                    MyQRCodeManager myQRCodeManager = f94961a;
                    myQRCodeManager.B(new com.tencent.biz.qrcode.mgr.d(x16, myQRCodeManager.y(), v3, o16));
                }
            }
        } else {
            B(new com.tencent.biz.qrcode.mgr.d(x16, y(), null, null, 12, null));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.mgr.MyQRCodeManager$requestQRCodeData$2
            @Override // java.lang.Runnable
            public void run() {
                MyQRCodeManager.I(MyQRCodeManager.f94961a, false, new Function4<Boolean, Integer, String, String, Unit>() { // from class: com.tencent.biz.qrcode.mgr.MyQRCodeManager$requestQRCodeData$2$run$1
                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, String str2) {
                        invoke(bool.booleanValue(), num.intValue(), str, str2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, final int i3, @NotNull final String shortChain, @NotNull String url) {
                        String y16;
                        String y17;
                        Intrinsics.checkNotNullParameter(shortChain, "shortChain");
                        Intrinsics.checkNotNullParameter(url, "url");
                        if (z16) {
                            MyQRCodeManager myQRCodeManager2 = MyQRCodeManager.f94961a;
                            myQRCodeManager2.O(shortChain);
                            if (i3 == 1) {
                                myQRCodeManager2.B(new d(i3, shortChain, null, null, 12, null));
                                return;
                            }
                            if (i3 != 2) {
                                return;
                            }
                            if (f.a()) {
                                myQRCodeManager2.q(url, new Function2<Boolean, Bitmap, Unit>() { // from class: com.tencent.biz.qrcode.mgr.MyQRCodeManager$requestQRCodeData$2$run$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Bitmap bitmap) {
                                        invoke(bool.booleanValue(), bitmap);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z17, @Nullable Bitmap bitmap) {
                                        String v16;
                                        if (z17) {
                                            MyQRCodeManager myQRCodeManager3 = MyQRCodeManager.f94961a;
                                            int i16 = i3;
                                            String str = shortChain;
                                            v16 = myQRCodeManager3.v();
                                            myQRCodeManager3.B(new d(i16, str, v16, bitmap));
                                        }
                                    }
                                });
                                return;
                            } else {
                                QLog.i("MyQRCodeManager", 1, "AIGC Style is not enabled.");
                                myQRCodeManager2.B(new d(1, shortChain, null, null, 12, null));
                                return;
                            }
                        }
                        MyQRCodeManager myQRCodeManager3 = MyQRCodeManager.f94961a;
                        if (myQRCodeManager3.r() == null) {
                            y16 = myQRCodeManager3.y();
                            if (y16.length() > 0) {
                                y17 = myQRCodeManager3.y();
                                myQRCodeManager3.B(new d(1, y17, null, null, 12, null));
                            }
                        }
                        QLog.e("MyQRCodeManager", 1, "request error.");
                    }
                }, 1, null);
            }
        }, 128, null, false);
    }

    public final void F() {
        QLog.i("MyQRCodeManager", 1, "requestResetToDefault start.");
        com.tencent.biz.qrcode.mgr.d dVar = currentQRCodeData;
        if (dVar != null) {
            f94961a.B(new com.tencent.biz.qrcode.mgr.d(1, dVar.getShortChain(), null, null, 12, null));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.mgr.c
            @Override // java.lang.Runnable
            public final void run() {
                MyQRCodeManager.G();
            }
        }, 128, null, false);
    }

    public final void J(@NotNull final Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!f.a()) {
            QLog.i("MyQRCodeManager", 1, "AIGC Style is not enabled.");
            cb5.invoke(Boolean.FALSE);
        } else {
            I(this, false, new Function4<Boolean, Integer, String, String, Unit>() { // from class: com.tencent.biz.qrcode.mgr.MyQRCodeManager$setAIGCQRCode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, String str2) {
                    invoke(bool.booleanValue(), num.intValue(), str, str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3, @NotNull final String shortChain, @NotNull String url) {
                    Intrinsics.checkNotNullParameter(shortChain, "shortChain");
                    Intrinsics.checkNotNullParameter(url, "url");
                    if (!z16) {
                        cb5.invoke(Boolean.FALSE);
                        return;
                    }
                    if (i3 == 2) {
                        MyQRCodeManager myQRCodeManager = MyQRCodeManager.f94961a;
                        final Function1<Boolean, Unit> function1 = cb5;
                        myQRCodeManager.q(url, new Function2<Boolean, Bitmap, Unit>() { // from class: com.tencent.biz.qrcode.mgr.MyQRCodeManager$setAIGCQRCode$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Bitmap bitmap) {
                                invoke(bool.booleanValue(), bitmap);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z17, @Nullable Bitmap bitmap) {
                                String v3;
                                if (z17) {
                                    MyQRCodeManager myQRCodeManager2 = MyQRCodeManager.f94961a;
                                    myQRCodeManager2.O(shortChain);
                                    String str = shortChain;
                                    v3 = myQRCodeManager2.v();
                                    myQRCodeManager2.B(new d(2, str, v3, bitmap));
                                    function1.invoke(Boolean.TRUE);
                                    return;
                                }
                                function1.invoke(Boolean.FALSE);
                            }
                        });
                    } else {
                        QLog.i("MyQRCodeManager", 1, "setAIGCQRCode onReceive success, but style not match.");
                        cb5.invoke(Boolean.FALSE);
                    }
                }
            }, 1, null);
        }
    }

    public final void K(@Nullable String str) {
        currentUin = str;
    }

    public final void P(@NotNull a cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        listeners.remove(cb5);
    }

    public final void n() {
        currentQRCodeData = null;
        currentUin = "";
        isDownloading.set(false);
    }

    @Nullable
    public final com.tencent.biz.qrcode.mgr.d r() {
        return currentQRCodeData;
    }

    @Nullable
    public final String s() {
        return currentUin;
    }

    @NotNull
    public final MMKVOptionEntity u() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from;
    }

    @NotNull
    public final Handler w() {
        return handler;
    }

    @NotNull
    public final AtomicBoolean z() {
        return isDownloading;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qrcode/mgr/MyQRCodeManager$d", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Bitmap, Unit> f94970d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f94971e;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super Boolean, ? super Bitmap, Unit> function2, String str) {
            this.f94970d = function2;
            this.f94971e = str;
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean isSuccess, @Nullable String filePath) {
            MyQRCodeManager myQRCodeManager = MyQRCodeManager.f94961a;
            boolean z16 = false;
            myQRCodeManager.z().set(false);
            myQRCodeManager.w().removeCallbacks(MyQRCodeManager.downloadTimeoutRunnable);
            if (isSuccess) {
                QLog.i("MyQRCodeManager", 1, "[getBitmapAsync][download]onRspCallback, filePath = " + filePath);
                if (filePath != null) {
                    if (filePath.length() > 0) {
                        z16 = true;
                    }
                    if (z16) {
                        Bitmap o16 = myQRCodeManager.o(filePath);
                        if (o16 != null) {
                            myQRCodeManager.L(this.f94971e);
                            myQRCodeManager.M(filePath);
                            this.f94970d.invoke(Boolean.TRUE, o16);
                            return;
                        } else {
                            QLog.e("MyQRCodeManager", 1, "[getBitmapAsync][download]onRspCallback, decodeFile failed.");
                            this.f94970d.invoke(Boolean.FALSE, null);
                            return;
                        }
                    }
                }
                this.f94970d.invoke(Boolean.FALSE, null);
                return;
            }
            QLog.e("MyQRCodeManager", 1, "[getBitmapAsync][download]onRspCallback fail.");
            this.f94970d.invoke(Boolean.FALSE, null);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            v.t(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float percent, long downloadedLength, long totalLength) {
        }
    }
}
