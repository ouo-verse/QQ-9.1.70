package com.tencent.mobileqq.flock.layer.part;

import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.flock.download.FlockDownloadConfig;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016R#\u0010%\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010)\u001a\n  *\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/flock/layer/part/FlockFeedLayerMediaSavePart;", "Lcom/tencent/mobileqq/flock/base/e;", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "H9", "N9", "G9", "Lkotlin/Function0;", "block", "J9", "O9", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "listener", "F9", "P9", "", "filePath", "L9", "action", "", "args", "handleBroadcastMessage", "", "isSuccess", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "e", "Lcom/tencent/biz/richframework/download/RFWDownloader;", QDLog.TAG_DOWNLOAD, "<init>", "()V", "f", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedLayerMediaSavePart extends com.tencent.mobileqq.flock.base.e implements RFWDownloader.RFWDownloadListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RFWDownloader downloader;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/layer/part/FlockFeedLayerMediaSavePart$a;", "", "", "MSG_ACTION_DOWNLOAD", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.layer.part.FlockFeedLayerMediaSavePart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/flock/layer/part/FlockFeedLayerMediaSavePart$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f210212b;

        b(String str) {
            this.f210212b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedLayerMediaSavePart.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            RFWLog.i("FlockFeedLayerMediaSavePart", RFWLog.USR, "checkPermission, onAllGranted ");
            FlockFeedLayerMediaSavePart.this.N9();
            FlockFeedLayerMediaSavePart.this.downloader.download(this.f210212b, FlockFeedLayerMediaSavePart.this);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            super.onDenied(permissions, results);
            RFWLog.i("FlockFeedLayerMediaSavePart", RFWLog.USR, "checkPermission, onDenied ");
            FlockFeedLayerMediaSavePart.this.O9();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedLayerMediaSavePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.flock.layer.part.FlockFeedLayerMediaSavePart$qqPermission$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedLayerMediaSavePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final QQPermission invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? QQPermissionFactory.getQQPermission(FlockFeedLayerMediaSavePart.this.getHostFragment(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_FLOCK, QQPermissionConstants.Business.SCENE.FLOCK_SAVE_MEDIA_TO_ALBUM)) : (QQPermission) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.qqPermission = lazy;
            this.downloader = RFWDownloaderFactory.getDownloader(FlockDownloadConfig.f210022a.a());
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void F9(QQPermission.BasePermissionsListener listener) {
        if (I9().hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0 && I9().hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) {
            listener.onAllGranted();
        } else {
            I9().requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, listener);
        }
    }

    private final void G9() {
        broadcastMessage("ACTION_MSG_HIDE_LOADING", null);
    }

    private final void H9() {
        String str;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null && (downloadPicInfo = layerPicInfo.getDownloadPicInfo()) != null) {
            str = downloadPicInfo.getUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            O9();
        } else {
            F9(new b(str));
        }
    }

    private final QQPermission I9() {
        return (QQPermission) this.qqPermission.getValue();
    }

    private final void J9(final Function0<Unit> block) {
        if (RFWThreadManager.isMainThread()) {
            block.invoke();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.flock.layer.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    FlockFeedLayerMediaSavePart.K9(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    private final void L9(String filePath) {
        RFWSaveUtil.insertMedia(getContext(), filePath, new Consumer() { // from class: com.tencent.mobileqq.flock.layer.part.d
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                FlockFeedLayerMediaSavePart.M9((RFWSaveMediaResultBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        RFWLog.i("FlockFeedLayerMediaSavePart", RFWLog.USR, "saveMediaToSystemAlbum, ret:" + rFWSaveMediaResultBean.isSuccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        broadcastMessage("ACTION_MSG_SHOW_LOADING", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        J9(FlockFeedLayerMediaSavePart$toastError$1.INSTANCE);
    }

    private final void P9() {
        J9(FlockFeedLayerMediaSavePart$toastSuccess$1.INSTANCE);
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

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, args);
        } else if (Intrinsics.areEqual(action, "MSG_ACTION_DOWNLOAD")) {
            H9();
        }
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
    public void onDownloadProgress(float percent, long downloadedLength, long totalLength) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(percent), Long.valueOf(downloadedLength), Long.valueOf(totalLength));
        }
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
    public void onRspCallback(boolean isSuccess, @Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), filePath);
            return;
        }
        RFWLog.i("FlockFeedLayerMediaSavePart", RFWLog.USR, "onRspCallback, isSuccess:" + isSuccess + ", filePath:" + filePath);
        G9();
        if (isSuccess) {
            if (filePath != null && filePath.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                L9(filePath);
                P9();
                return;
            }
        }
        O9();
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
}
