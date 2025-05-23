package com.tencent.mobileqq.zplan.avatar.upload;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.zplan.avatar.upload.ZplanFileUploader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0012\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002H\u0002J8\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\bJ\u0014\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/upload/ZplanFileUploader;", "", "", "e", "", "key", "localPath", "uuid", "Lkotlin/Function2;", "", "", "callback", "f", "", "keyList", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/avatar/upload/ZplanFileUploader$b;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "uploadHandlerMap", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanFileUploader {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy<ZplanFileUploader> f331971c;

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy<String> f331972d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, b> uploadHandlerMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/upload/ZplanFileUploader$a;", "", "Lcom/tencent/mobileqq/zplan/avatar/upload/ZplanFileUploader;", "INSTANCE$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/zplan/avatar/upload/ZplanFileUploader;", "getINSTANCE$annotations", "()V", "INSTANCE", "", "RECORD_HOST$delegate", "c", "()Ljava/lang/String;", "RECORD_HOST", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "a", "()Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "currentTransFileController", "TAG", "Ljava/lang/String;", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.upload.ZplanFileUploader$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ITransFileController a() {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            AppRuntime peekAppRuntime = mobileQQ != null ? mobileQQ.peekAppRuntime() : null;
            if (peekAppRuntime != null) {
                return (ITransFileController) peekAppRuntime.getRuntimeService(ITransFileController.class, "all");
            }
            return null;
        }

        public final ZplanFileUploader b() {
            return (ZplanFileUploader) ZplanFileUploader.f331971c.getValue();
        }

        public final String c() {
            return (String) ZplanFileUploader.f331972d.getValue();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R,\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/upload/ZplanFileUploader$b;", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Lkotlin/Function3;", "", "Lcom/tencent/mobileqq/transfile/FileMsg;", "a", "Lkotlin/jvm/functions/Function3;", "cb", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
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

    static {
        Lazy<ZplanFileUploader> lazy;
        Lazy<String> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ZplanFileUploader>() { // from class: com.tencent.mobileqq.zplan.avatar.upload.ZplanFileUploader$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanFileUploader invoke() {
                return new ZplanFileUploader();
            }
        });
        f331971c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.zplan.avatar.upload.ZplanFileUploader$Companion$RECORD_HOST$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String J2 = ZPlanFeatureSwitch.f369852a.J2();
                QLog.i("ZplanFileUploader", 1, "RECORD_HOST:" + J2);
                return J2;
            }
        });
        f331972d = lazy2;
    }

    public final void d(List<Long> keyList) {
        IHttpCommunicatorListener iHttpCommunicatorListener;
        Intrinsics.checkNotNullParameter(keyList, "keyList");
        if (keyList.isEmpty()) {
            QLog.i("ZplanFileUploader", 1, "keyList isEmpty ");
            return;
        }
        Iterator<T> it = keyList.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            ITransFileController a16 = INSTANCE.a();
            if (a16 != null) {
                iHttpCommunicatorListener = a16.findProcessor("ZplanFileUploader" + longValue);
            } else {
                iHttpCommunicatorListener = null;
            }
            boolean z16 = iHttpCommunicatorListener instanceof NearbyPeoplePhotoUploadProcessor;
            QLog.d("ZplanFileUploader", 1, "cancel -> " + z16);
            if (z16) {
                ((NearbyPeoplePhotoUploadProcessor) iHttpCommunicatorListener).cancel();
            }
        }
    }

    public final void f(long key, final String localPath, String uuid, final Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b(new Function3<b, Integer, FileMsg, Unit>() { // from class: com.tencent.mobileqq.zplan.avatar.upload.ZplanFileUploader$upload$uploadHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ZplanFileUploader.b bVar2, Integer num, FileMsg fileMsg) {
                invoke(bVar2, num.intValue(), fileMsg);
                return Unit.INSTANCE;
            }

            public final void invoke(ZplanFileUploader.b self, int i3, FileMsg fileMsg) {
                String e16;
                TransferRequest transferRequest;
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(fileMsg, "fileMsg");
                BaseTransProcessor baseTransProcessor = fileMsg.processor;
                if (Intrinsics.areEqual(localPath, (baseTransProcessor == null || (transferRequest = baseTransProcessor.mUiRequest) == null) ? null : transferRequest.mLocalPath)) {
                    boolean z16 = true;
                    switch (i3) {
                        case 1003:
                            ITransFileController a16 = ZplanFileUploader.INSTANCE.a();
                            if (a16 != null) {
                                a16.removeHandle(self);
                            }
                            ZplanFileUploader zplanFileUploader = this;
                            BaseTransProcessor baseTransProcessor2 = fileMsg.processor;
                            NearbyPeoplePhotoUploadProcessor nearbyPeoplePhotoUploadProcessor = baseTransProcessor2 instanceof NearbyPeoplePhotoUploadProcessor ? (NearbyPeoplePhotoUploadProcessor) baseTransProcessor2 : null;
                            e16 = zplanFileUploader.e(nearbyPeoplePhotoUploadProcessor != null ? nearbyPeoplePhotoUploadProcessor.mUrl : null);
                            QLog.i("ZplanFileUploader", 1, "upload " + localPath + " finished, url = " + e16);
                            if (e16 != null && e16.length() != 0) {
                                z16 = false;
                            }
                            if (z16) {
                                return;
                            }
                            callback.invoke(Boolean.TRUE, e16);
                            return;
                        case 1004:
                            QLog.i("ZplanFileUploader", 1, "upload " + localPath + " cancel");
                            ITransFileController a17 = ZplanFileUploader.INSTANCE.a();
                            if (a17 != null) {
                                a17.removeHandle(self);
                            }
                            callback.invoke(Boolean.FALSE, "");
                            return;
                        case 1005:
                            QLog.e("ZplanFileUploader", 1, "upload " + localPath + " error");
                            ITransFileController a18 = ZplanFileUploader.INSTANCE.a();
                            if (a18 != null) {
                                a18.removeHandle(self);
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
        QLog.i("ZplanFileUploader", 1, "upload " + localPath + ", uuid: " + uuid + " ");
        ITransFileController a16 = INSTANCE.a();
        if (a16 == null) {
            callback.invoke(Boolean.FALSE, "");
            QLog.e("ZplanFileUploader", 1, "upload " + localPath + ", uuid:" + uuid + " fail, transFileController null");
            return;
        }
        a16.addHandle(bVar);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = localPath;
        transferRequest.mUniseq = key;
        transferRequest.mPeerUin = "ZplanFileUploader";
        transferRequest.mFileType = 72;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(uuid));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        a16.transferAsync(transferRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(String str) {
        String replace$default;
        if (str == null) {
            return null;
        }
        String oldHost = new URL(str).getHost();
        Intrinsics.checkNotNullExpressionValue(oldHost, "oldHost");
        replace$default = StringsKt__StringsJVMKt.replace$default(str, oldHost, INSTANCE.c(), false, 4, (Object) null);
        return replace$default;
    }
}
