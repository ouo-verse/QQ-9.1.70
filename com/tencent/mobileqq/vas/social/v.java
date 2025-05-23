package com.tencent.mobileqq.vas.social;

import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.vas.social.record.RecordStepProduct;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.zplan.meme.action.MODE;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u000e\u0013B\u0007\u00a2\u0006\u0004\b\"\u0010#J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J.\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aR \u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/social/v;", "", "Lmqq/app/AppRuntime;", "app", "", "localPath", "uploadName", "", "current", "", "actionId", "type", "identifierKey", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "a", "Lcom/tencent/state/square/record/RecordIdentifier;", "recordIdentifier", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "b", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "Lcom/tencent/mobileqq/vas/social/v$b;", "uploadHandler", "", "d", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "handler", "", "c", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "Lmqq/util/WeakReference;", "transFileController", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<ITransFileController> transFileController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R,\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/social/v$b;", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Lkotlin/Function3;", "", "Lcom/tencent/mobileqq/transfile/FileMsg;", "a", "Lkotlin/jvm/functions/Function3;", "cb", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function3<TransProcessorHandler, Integer, FileMsg, Unit> cb;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Function3<? super TransProcessorHandler, ? super Integer, ? super FileMsg, Unit> cb5) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(cb5, "cb");
            this.cb = cb5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.obj instanceof FileMsg) {
                Function3<TransProcessorHandler, Integer, FileMsg, Unit> function3 = this.cb;
                Integer valueOf = Integer.valueOf(msg2.what);
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
                function3.invoke(this, valueOf, (FileMsg) obj);
                return;
            }
            super.handleMessage(msg2);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310844a;

        static {
            int[] iArr = new int[MODE.values().length];
            try {
                iArr[MODE.MP4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MODE.FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MODE.SHARPP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MODE.GIF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f310844a = iArr;
        }
    }

    private final TransferRequest a(AppRuntime app, String localPath, String uploadName, long current, int actionId, int type, String identifierKey) {
        Map mapOf;
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = localPath;
        transferRequest.mCommandId = 101;
        transferRequest.mPeerUin = "0";
        transferRequest.mFileType = 24;
        transferRequest.mSelfUin = app.getCurrentAccountUin();
        transferRequest.mUniseq = current;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("actionId", Integer.valueOf(actionId)), TuplesKt.to("type", Integer.valueOf(type)), TuplesKt.to(IECDtReport.ACTION_IDENTIFIER, identifierKey));
        transferRequest.extraObject = mapOf;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(uploadName));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        return transferRequest;
    }

    private final String b(RecordIdentifier recordIdentifier, int actionId, long current, MODE mode) {
        String str;
        String md5 = MD5Utils.toMD5(recordIdentifier.getSender().getUin() + "_square");
        int i3 = c.f310844a[mode.ordinal()];
        if (i3 == 1) {
            str = ".mp4";
        } else if (i3 == 3) {
            str = ".shp";
        } else if (i3 != 4) {
            str = ".png";
        } else {
            str = QzoneEmotionUtils.SIGN_ICON_URL_END;
        }
        return "square/" + recordIdentifier.getType() + "/" + md5 + "/" + current + "/" + actionId + str;
    }

    public final void c(TransProcessorHandler handler) {
        ITransFileController iTransFileController;
        Intrinsics.checkNotNullParameter(handler, "handler");
        WeakReference<ITransFileController> weakReference = this.transFileController;
        if (weakReference == null || (iTransFileController = weakReference.get()) == null) {
            return;
        }
        iTransFileController.removeHandle(handler);
    }

    public final boolean d(int actionId, RecordStepProduct product, RecordIdentifier recordIdentifier, MODE mode, b uploadHandler) {
        String path;
        String str;
        ITransFileController iTransFileController;
        ITransFileController iTransFileController2;
        RecordSource localCover;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(uploadHandler, "uploadHandler");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.e("ZPlanVasSocialUploadHelper", 1, "uploadAction but appRuntime is null");
            return false;
        }
        int i3 = c.f310844a[mode.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (localCover = product.getLocalCover()) != null) {
                path = localCover.getPath();
                str = path;
            }
            str = null;
        } else {
            RecordSource localMp4 = product.getLocalMp4();
            if (localMp4 != null) {
                path = localMp4.getPath();
                str = path;
            }
            str = null;
        }
        if (str == null || str.length() == 0) {
            QLog.e("ZPlanVasSocialUploadHelper", 1, "uploadAction but localPath invalid:" + str);
            return false;
        }
        this.transFileController = new WeakReference<>(appInterface.getRuntimeService(ITransFileController.class, ""));
        if (!uploadHandler.getFilter().contains(BDHCommonUploadProcessor.class)) {
            uploadHandler.addFilter(BDHCommonUploadProcessor.class);
        }
        WeakReference<ITransFileController> weakReference = this.transFileController;
        if (weakReference != null && (iTransFileController2 = weakReference.get()) != null) {
            iTransFileController2.addHandle(uploadHandler);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String b16 = b(recordIdentifier, actionId, currentTimeMillis, mode);
        if (QLog.isColorLevel()) {
            QLog.d("ZPlanVasSocialUploadHelper", 2, "uploadAction uploadName:" + b16);
        }
        TransferRequest a16 = a(appInterface, str, b16, currentTimeMillis, actionId, SocialActionRecordHelper.f310651d.l(mode), recordIdentifier.key());
        WeakReference<ITransFileController> weakReference2 = this.transFileController;
        if (weakReference2 != null && (iTransFileController = weakReference2.get()) != null) {
            iTransFileController.transferAsync(a16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZPlanVasSocialUploadHelper", 2, "[RECORD] 5-2.1 send upload action req: recordIdentifier:" + recordIdentifier + ", actionId:" + actionId + ", mode:" + mode.name());
        }
        return true;
    }
}
