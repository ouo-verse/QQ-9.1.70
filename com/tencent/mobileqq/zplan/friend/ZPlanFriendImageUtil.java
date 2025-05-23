package com.tencent.mobileqq.zplan.friend;

import android.os.Message;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.friend.ZPlanFriendImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J2\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendImageUtil;", "", "", "success", "", "url", "Lkotlin/Function2;", "", "cb", "c", "path", "Lcom/tencent/common/app/AppInterface;", "app", "e", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendImageUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanFriendImageUtil f333664a = new ZPlanFriendImageUtil();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R,\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendImageUtil$a;", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Lkotlin/Function3;", "", "Lcom/tencent/mobileqq/transfile/FileMsg;", "a", "Lkotlin/jvm/functions/Function3;", "cb", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function3<a, Integer, FileMsg, Unit> cb;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function3<? super a, ? super Integer, ? super FileMsg, Unit> cb5) {
            Intrinsics.checkNotNullParameter(cb5, "cb");
            this.cb = cb5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.obj instanceof FileMsg) {
                Function3<a, Integer, FileMsg, Unit> function3 = this.cb;
                Integer valueOf = Integer.valueOf(msg2.what);
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
                function3.invoke(this, valueOf, (FileMsg) obj);
                return;
            }
            super.handleMessage(msg2);
        }
    }

    ZPlanFriendImageUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(final boolean success, final String url, final Function2<? super Boolean, ? super String, Unit> cb5) {
        QLog.i("ZPlanFriendImageProcessor", 1, "final upload result: " + success + ", with url = " + url);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.friend.p
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanFriendImageUtil.d(Function2.this, success, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function2 cb5, boolean z16, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.invoke(Boolean.valueOf(z16), str);
    }

    public final void e(final String path, final AppInterface app, final Function2<? super Boolean, ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        IRuntimeService runtimeService = app.getRuntimeService(ITransFileController.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        final ITransFileController iTransFileController = (ITransFileController) runtimeService;
        a aVar = new a(new Function3<a, Integer, FileMsg, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.ZPlanFriendImageUtil$uploadUserImage$uploadHandler$1

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/friend/ZPlanFriendImageUtil$uploadUserImage$uploadHandler$1$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements td3.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f333666a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function2<Boolean, String, Unit> f333667b;

                /* JADX WARN: Multi-variable type inference failed */
                a(String str, Function2<? super Boolean, ? super String, Unit> function2) {
                    this.f333666a = str;
                    this.f333667b = function2;
                }

                @Override // td3.a
                public void a(Integer errCode, String errMsg) {
                    QLog.e("ZPlanFriendImageProcessor", 1, "bind user image error, errorCode = " + errCode + ", errorMsg = " + errMsg);
                    ZPlanFriendImageUtil.f333664a.c(false, this.f333666a, this.f333667b);
                }

                @Override // td3.a
                public void onReceive(byte[] data) {
                    QLog.i("ZPlanFriendImageProcessor", 1, "bind user image success");
                    ZPlanFriendImageUtil.f333664a.c(true, this.f333666a, this.f333667b);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public final void invoke(ZPlanFriendImageUtil.a self, int i3, FileMsg fileMsg) {
                Map emptyMap;
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(fileMsg, "fileMsg");
                switch (i3) {
                    case 1003:
                        ITransFileController.this.removeHandle(self);
                        BaseTransProcessor baseTransProcessor = fileMsg.processor;
                        NearbyPeoplePhotoUploadProcessor nearbyPeoplePhotoUploadProcessor = baseTransProcessor instanceof NearbyPeoplePhotoUploadProcessor ? (NearbyPeoplePhotoUploadProcessor) baseTransProcessor : null;
                        String str = nearbyPeoplePhotoUploadProcessor != null ? nearbyPeoplePhotoUploadProcessor.mUrl : null;
                        QLog.i("ZPlanFriendImageProcessor", 1, "transmit file " + path + " finished, url = " + str);
                        if (str == null) {
                            ZPlanFriendImageUtil.f333664a.c(false, null, cb5);
                            return;
                        }
                        cw4.e eVar = new cw4.e();
                        eVar.f392183a = str;
                        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
                        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
                        AppInterface appInterface = app;
                        byte[] byteArray = MessageNano.toByteArray(eVar);
                        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
                        emptyMap = MapsKt__MapsKt.emptyMap();
                        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.user_info.UserInfoSvr", "SetPersonImage", byteArray, emptyMap, new a(str, cb5), 0, 0, 192, null);
                        return;
                    case 1004:
                        QLog.i("ZPlanFriendImageProcessor", 1, "transmit file " + path + " cancel");
                        ITransFileController.this.removeHandle(self);
                        ZPlanFriendImageUtil.f333664a.c(false, null, cb5);
                        return;
                    case 1005:
                        QLog.e("ZPlanFriendImageProcessor", 1, "transmit file " + path + " error");
                        ITransFileController.this.removeHandle(self);
                        ZPlanFriendImageUtil.f333664a.c(false, null, cb5);
                        return;
                    default:
                        return;
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanFriendImageUtil.a aVar2, Integer num, FileMsg fileMsg) {
                invoke(aVar2, num.intValue(), fileMsg);
                return Unit.INSTANCE;
            }
        });
        aVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        iTransFileController.addHandle(aVar);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = path;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = 69;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8("test_" + System.currentTimeMillis() + ".jpeg"));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        iTransFileController.transferAsync(transferRequest);
    }
}
