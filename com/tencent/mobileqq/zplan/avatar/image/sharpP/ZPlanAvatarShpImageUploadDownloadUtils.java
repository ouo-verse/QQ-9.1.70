package com.tencent.mobileqq.zplan.avatar.image.sharpP;

import android.os.Looper;
import android.os.Message;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.common.model.UploadConfig;
import java.io.File;
import java.net.URL;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J8\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tJ0\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tJ:\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tJH\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tJ(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/ZPlanAvatarShpImageUploadDownloadUtils;", "", "", "", "isCDN", "e", "uin", "zipPath", "zipTail", "Lkotlin/Function2;", "", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "localPath", "uuid", "Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "uploadTarget", "k", "", "key", "", TagName.FILE_TYPE, "j", "url", "f", h.F, "<init>", "()V", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarShpImageUploadDownloadUtils {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy<ZPlanAvatarShpImageUploadDownloadUtils> f331853b;

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy<String> f331854c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/ZPlanAvatarShpImageUploadDownloadUtils$a;", "", "Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/ZPlanAvatarShpImageUploadDownloadUtils;", "INSTANCE$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/ZPlanAvatarShpImageUploadDownloadUtils;", "getINSTANCE$annotations", "()V", "INSTANCE", "", "CDN_HOST$delegate", "a", "()Ljava/lang/String;", "CDN_HOST", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "b", "()Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "currentTransFileController", "DOWNLOAD_FOLDER", "Ljava/lang/String;", "TAG", "ZIP_FILE_TAIL", "ZIP_PIC_TAIL", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return (String) ZPlanAvatarShpImageUploadDownloadUtils.f331854c.getValue();
        }

        public final ITransFileController b() {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            AppRuntime peekAppRuntime = mobileQQ != null ? mobileQQ.peekAppRuntime() : null;
            if (peekAppRuntime != null) {
                return (ITransFileController) peekAppRuntime.getRuntimeService(ITransFileController.class, "all");
            }
            return null;
        }

        public final ZPlanAvatarShpImageUploadDownloadUtils c() {
            return (ZPlanAvatarShpImageUploadDownloadUtils) ZPlanAvatarShpImageUploadDownloadUtils.f331853b.getValue();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R,\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/ZPlanAvatarShpImageUploadDownloadUtils$b;", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Lkotlin/Function3;", "", "Lcom/tencent/mobileqq/transfile/FileMsg;", "a", "Lkotlin/jvm/functions/Function3;", "cb", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function3<b, Integer, FileMsg, Unit> cb;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Function3<? super b, ? super Integer, ? super FileMsg, Unit> cb5) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(cb5, "cb");
            this.cb = cb5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.obj instanceof FileMsg) {
                Function3<b, Integer, FileMsg, Unit> function3 = this.cb;
                Integer valueOf = Integer.valueOf(msg2.what);
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
                function3.invoke(this, valueOf, (FileMsg) obj);
                return;
            }
            super.handleMessage(msg2);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331856a;

        static {
            int[] iArr = new int[UploadConfig.UploadTarget.values().length];
            try {
                iArr[UploadConfig.UploadTarget.CDN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UploadConfig.UploadTarget.CDN_AVATAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f331856a = iArr;
        }
    }

    static {
        Lazy<ZPlanAvatarShpImageUploadDownloadUtils> lazy;
        Lazy<String> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ZPlanAvatarShpImageUploadDownloadUtils>() { // from class: com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanAvatarShpImageUploadDownloadUtils invoke() {
                return new ZPlanAvatarShpImageUploadDownloadUtils(null);
            }
        });
        f331853b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils$Companion$CDN_HOST$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String g26 = ZPlanFeatureSwitch.f369852a.g2();
                QLog.i("ZPlanAvatarShpImageUploadDownloadUtils", 1, "CDN_HOST:" + g26);
                return g26;
            }
        });
        f331854c = lazy2;
    }

    public /* synthetic */ ZPlanAvatarShpImageUploadDownloadUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String url, File f16, Function2 callback) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(f16, "$f");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (DownloaderFactory.o(new g(url, f16), null) == 0 && f16.exists()) {
            Boolean bool = Boolean.TRUE;
            String absolutePath = f16.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "f.absolutePath");
            callback.invoke(bool, absolutePath);
        }
    }

    public static final ZPlanAvatarShpImageUploadDownloadUtils i() {
        return INSTANCE.c();
    }

    public final void f(final String url, final Function2<? super Boolean, ? super String, Unit> callback) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z16 = true;
        QLog.i("ZPlanAvatarShpImageUploadDownloadUtils", 1, "[downloadShpImagePackage] url:" + url);
        String h16 = h(url);
        if (h16 != null && h16.length() != 0) {
            z16 = false;
        }
        if (z16) {
            callback.invoke(Boolean.FALSE, "");
            return;
        }
        final File file = new File(h16);
        if (!file.exists()) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                if (!startsWith$default2) {
                    callback.invoke(Boolean.FALSE, "");
                    return;
                }
            }
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.sharpP.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarShpImageUploadDownloadUtils.g(url, file, callback);
                }
            });
            return;
        }
        callback.invoke(Boolean.TRUE, h16);
    }

    public final String h(String url) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(url, "url");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, "/", 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            String a16 = ZPlanAvatarShpImageCacheManager.INSTANCE.a().a("download/");
            String substring = url.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return a16 + substring;
        }
        return "";
    }

    public final void j(long key, final String localPath, String uuid, final boolean isCDN, int fileType, final Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b(new Function3<b, Integer, FileMsg, Unit>() { // from class: com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils$upload$uploadHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanAvatarShpImageUploadDownloadUtils.b bVar2, Integer num, FileMsg fileMsg) {
                invoke(bVar2, num.intValue(), fileMsg);
                return Unit.INSTANCE;
            }

            public final void invoke(ZPlanAvatarShpImageUploadDownloadUtils.b self, int i3, FileMsg fileMsg) {
                String e16;
                TransferRequest transferRequest;
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(fileMsg, "fileMsg");
                BaseTransProcessor baseTransProcessor = fileMsg.processor;
                if (Intrinsics.areEqual(localPath, (baseTransProcessor == null || (transferRequest = baseTransProcessor.mUiRequest) == null) ? null : transferRequest.mLocalPath)) {
                    boolean z16 = true;
                    switch (i3) {
                        case 1003:
                            ITransFileController b16 = ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.b();
                            if (b16 != null) {
                                b16.removeHandle(self);
                            }
                            ZPlanAvatarShpImageUploadDownloadUtils zPlanAvatarShpImageUploadDownloadUtils = this;
                            BaseTransProcessor baseTransProcessor2 = fileMsg.processor;
                            NearbyPeoplePhotoUploadProcessor nearbyPeoplePhotoUploadProcessor = baseTransProcessor2 instanceof NearbyPeoplePhotoUploadProcessor ? (NearbyPeoplePhotoUploadProcessor) baseTransProcessor2 : null;
                            e16 = zPlanAvatarShpImageUploadDownloadUtils.e(nearbyPeoplePhotoUploadProcessor != null ? nearbyPeoplePhotoUploadProcessor.mUrl : null, isCDN);
                            QLog.i("ZPlanAvatarShpImageUploadDownloadUtils", 1, "upload " + localPath + " finished, url = " + e16);
                            if (e16 != null && e16.length() != 0) {
                                z16 = false;
                            }
                            if (z16) {
                                return;
                            }
                            callback.invoke(Boolean.TRUE, e16);
                            return;
                        case 1004:
                            QLog.i("ZPlanAvatarShpImageUploadDownloadUtils", 1, "upload " + localPath + " cancel");
                            ITransFileController b17 = ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.b();
                            if (b17 != null) {
                                b17.removeHandle(self);
                            }
                            callback.invoke(Boolean.FALSE, "");
                            return;
                        case 1005:
                            QLog.e("ZPlanAvatarShpImageUploadDownloadUtils", 1, "upload " + localPath + " error");
                            ITransFileController b18 = ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.b();
                            if (b18 != null) {
                                b18.removeHandle(self);
                            }
                            callback.invoke(Boolean.FALSE, "");
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        bVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        ITransFileController b16 = INSTANCE.b();
        if (b16 == null) {
            callback.invoke(Boolean.FALSE, "");
            QLog.e("ZPlanAvatarShpImageUploadDownloadUtils", 1, "upload " + localPath + ", uuid:" + uuid + " fail, transFileController null");
            return;
        }
        b16.addHandle(bVar);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = localPath;
        transferRequest.mUniseq = key;
        transferRequest.mFileType = fileType;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(uuid));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        b16.transferAsync(transferRequest);
    }

    public final void k(String localPath, String uuid, UploadConfig.UploadTarget uploadTarget, Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(uploadTarget, "uploadTarget");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i3 = c.f331856a[uploadTarget.ordinal()];
        j(System.currentTimeMillis(), localPath, uuid, uploadTarget != UploadConfig.UploadTarget.IDC, i3 != 1 ? i3 != 2 ? 69 : 71 : 70, callback);
    }

    public final void m(String uin, String zipPath, String zipTail, Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(zipTail, "zipTail");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZPlanAvatarShpImageUploadDownloadUtils", 1, "[uploadShpImagePackage] " + uin + " , " + zipPath);
        l(this, zipPath, uin + System.currentTimeMillis() + zipTail, null, callback, 4, null);
    }

    public final void n(String uin, String zipPath, Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        m(uin, zipPath, ".zip", callback);
    }

    ZPlanAvatarShpImageUploadDownloadUtils() {
    }

    public static /* synthetic */ void l(ZPlanAvatarShpImageUploadDownloadUtils zPlanAvatarShpImageUploadDownloadUtils, String str, String str2, UploadConfig.UploadTarget uploadTarget, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            uploadTarget = UploadConfig.UploadTarget.IDC;
        }
        zPlanAvatarShpImageUploadDownloadUtils.k(str, str2, uploadTarget, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(String str, boolean z16) {
        String replace$default;
        if (str == null) {
            return null;
        }
        if (!z16) {
            return str;
        }
        String oldHost = new URL(str).getHost();
        Intrinsics.checkNotNullExpressionValue(oldHost, "oldHost");
        replace$default = StringsKt__StringsJVMKt.replace$default(str, oldHost, INSTANCE.a(), false, 4, (Object) null);
        return replace$default;
    }
}
