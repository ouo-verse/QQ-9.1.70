package com.tencent.mobileqq.onlinestatus.networkhandler;

import android.os.Bundle;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.avatar.GetUrlResult;
import com.tencent.mobileqq.onlinestatus.networkhandler.d;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0007\u00a2\u0006\u0004\b*\u0010+JZ\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000628\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\bH\u0002J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J=\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152%\u0010\u0010\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017JX\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bJ[\u0010#\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001b2#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017JC\u0010%\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017J;\u0010&\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017JZ\u0010)\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00152:\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/OnlineStatusAvatarPreviewHandler;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "cmd", "", "reqBody", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/ZplanAvatarProto$Response;", "rsp", "", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "data", "g", "", "uin", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/onlinestatus/avatar/a;", "result", "i", "", "key", "exist", "k", "md5", "sha1", "fileSize", TagName.FILE_TYPE, "d", "filePath", "e", "l", "type", ZPlanPublishSource.FROM_SCHEME, h.F, "<init>", "()V", "a", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusAvatarPreviewHandler {

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00128\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\b0\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011RI\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\b0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/OnlineStatusAvatarPreviewHandler$b;", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "d", "I", "getCmd", "()I", "cmd", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/ZplanAvatarProto$Response;", "rsp", "e", "Lkotlin/jvm/functions/Function2;", "getCallback", "()Lkotlin/jvm/functions/Function2;", "callback", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/networkhandler/OnlineStatusAvatarPreviewHandler;ILkotlin/jvm/functions/Function2;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int cmd;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function2<Boolean, ZplanAvatarProto$Response, Unit> callback;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ OnlineStatusAvatarPreviewHandler f256068f;

        /* JADX WARN: Multi-variable type inference failed */
        public b(OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler, @NotNull int i3, Function2<? super Boolean, ? super ZplanAvatarProto$Response, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f256068f = onlineStatusAvatarPreviewHandler;
            this.cmd = i3;
            this.callback = callback;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            QLog.i("OnlineStatusAvatar.PreviewHandler", 1, "[onError]: errorCode is " + errorCode + ", errorMsg is " + errorMsg);
            if (errorCode != 600) {
                if (errorCode != 1001) {
                    return super.onError(errorCode, errorMsg, bundle);
                }
                this.callback.invoke(Boolean.TRUE, null);
            }
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            if (errorCode == 0 && data != null) {
                ZplanAvatarProto$Response g16 = this.f256068f.g(data);
                this.callback.invoke(Boolean.valueOf(this.f256068f.j(g16)), g16);
                return;
            }
            QLog.e("OnlineStatusAvatar.PreviewHandler", 1, "[onResult] fail, cmd=" + this.cmd + ", error=" + errorCode);
            this.callback.invoke(Boolean.FALSE, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String filePath, Function1 function1, OnlineStatusAvatarPreviewHandler this$0, AppInterface app, String key) {
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(key, "$key");
        d.a a16 = d.f256083a.a(filePath);
        if (a16 == null) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        } else {
            String bytes2HexStr = HexUtil.bytes2HexStr(a16.getMd5());
            Intrinsics.checkNotNullExpressionValue(bytes2HexStr, "bytes2HexStr(fileInfo.md5)");
            String bytes2HexStr2 = HexUtil.bytes2HexStr(a16.getSha1());
            Intrinsics.checkNotNullExpressionValue(bytes2HexStr2, "bytes2HexStr(fileInfo.sha1)");
            this$0.d(app, key, bytes2HexStr, bytes2HexStr2, a16.getFileSize(), a16.getCom.tencent.ams.dsdk.monitor.metric.event.TagName.FILE_TYPE java.lang.String(), function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZplanAvatarProto$Response g(byte[] data) {
        try {
            return new ZplanAvatarProto$Response().mergeFrom(data);
        } catch (Exception e16) {
            QLog.i("OnlineStatusAvatar.PreviewHandler", 1, "[getResponse] exception=" + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(ZplanAvatarProto$Response rsp) {
        if (rsp == null || rsp.ret_code.get() != 0) {
            return false;
        }
        return true;
    }

    private final void m(AppInterface app, int cmd, byte[] reqBody, Function2<? super Boolean, ? super ZplanAvatarProto$Response, Unit> callback) {
        ProtoUtils.a(app, new b(this, cmd, callback), reqBody, "OidbSvcTrpcTcp.0x125b_" + cmd, 4699, cmd);
    }

    public final void d(@NotNull AppInterface app, @NotNull String key, @NotNull String md5, @NotNull String sha1, long fileSize, @NotNull String fileType, @Nullable final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        ZplanAvatarProto$Request zplanAvatarProto$Request = new ZplanAvatarProto$Request();
        zplanAvatarProto$Request.cmd.set(300);
        ZplanAvatarProto$CreateStatusReq zplanAvatarProto$CreateStatusReq = zplanAvatarProto$Request.create_status;
        ZplanAvatarProto$CreateStatusReq zplanAvatarProto$CreateStatusReq2 = new ZplanAvatarProto$CreateStatusReq();
        zplanAvatarProto$CreateStatusReq2.key.set(key);
        PBStringField pBStringField = zplanAvatarProto$CreateStatusReq2.md5;
        String lowerCase = md5.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        pBStringField.set(lowerCase);
        PBStringField pBStringField2 = zplanAvatarProto$CreateStatusReq2.sha1;
        String lowerCase2 = sha1.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
        pBStringField2.set(lowerCase2);
        zplanAvatarProto$CreateStatusReq2.file_size.set(fileSize);
        zplanAvatarProto$CreateStatusReq2.file_type.set(fileType);
        zplanAvatarProto$CreateStatusReq.set(zplanAvatarProto$CreateStatusReq2);
        byte[] reqBody = zplanAvatarProto$Request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(reqBody, "reqBody");
        m(app, 300, reqBody, new Function2<Boolean, ZplanAvatarProto$Response, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAvatarPreviewHandler$addUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, ZplanAvatarProto$Response zplanAvatarProto$Response) {
                invoke(bool.booleanValue(), zplanAvatarProto$Response);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable ZplanAvatarProto$Response zplanAvatarProto$Response) {
                Function1<Boolean, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(z16));
                }
            }
        });
    }

    public final void e(@NotNull final AppInterface app, @NotNull final String key, @NotNull final String filePath, @Nullable final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.e
            @Override // java.lang.Runnable
            public final void run() {
                OnlineStatusAvatarPreviewHandler.f(filePath, callback, this, app, key);
            }
        }, 16, null, false);
    }

    public final void h(@NotNull AppInterface app, long uin, long type, @Nullable final Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        ZplanAvatarProto$Request zplanAvatarProto$Request = new ZplanAvatarProto$Request();
        ZplanAvatarProto$GetStatusJumpSchemeReq zplanAvatarProto$GetStatusJumpSchemeReq = new ZplanAvatarProto$GetStatusJumpSchemeReq();
        zplanAvatarProto$GetStatusJumpSchemeReq.obi_uin.set(uin);
        zplanAvatarProto$GetStatusJumpSchemeReq.type.set(type);
        zplanAvatarProto$Request.cmd.set(500);
        zplanAvatarProto$Request.get_status_jump_scheme.set(zplanAvatarProto$GetStatusJumpSchemeReq);
        byte[] reqBody = zplanAvatarProto$Request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(reqBody, "reqBody");
        m(app, 500, reqBody, new Function2<Boolean, ZplanAvatarProto$Response, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAvatarPreviewHandler$getStatusJumpScheme$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, ZplanAvatarProto$Response zplanAvatarProto$Response) {
                invoke(bool.booleanValue(), zplanAvatarProto$Response);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable ZplanAvatarProto$Response zplanAvatarProto$Response) {
                if (!z16) {
                    Function2<Boolean, String, Unit> function2 = callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.FALSE, "");
                        return;
                    }
                    return;
                }
                if (zplanAvatarProto$Response == null) {
                    Function2<Boolean, String, Unit> function22 = callback;
                    if (function22 != null) {
                        function22.invoke(Boolean.TRUE, "");
                        return;
                    }
                    return;
                }
                Function2<Boolean, String, Unit> function23 = callback;
                if (function23 != null) {
                    function23.invoke(Boolean.TRUE, zplanAvatarProto$Response.get_status_jump_scheme.scheme.get());
                }
            }
        });
    }

    public final void i(@NotNull AppInterface app, long uin, @Nullable final Function1<? super GetUrlResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        ZplanAvatarProto$Request zplanAvatarProto$Request = new ZplanAvatarProto$Request();
        ZplanAvatarProto$GetStatusReq zplanAvatarProto$GetStatusReq = new ZplanAvatarProto$GetStatusReq();
        zplanAvatarProto$GetStatusReq.obj_uin.set(uin);
        zplanAvatarProto$Request.cmd.set(100);
        zplanAvatarProto$Request.get_status.set(zplanAvatarProto$GetStatusReq);
        byte[] reqBody = zplanAvatarProto$Request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(reqBody, "reqBody");
        m(app, 100, reqBody, new Function2<Boolean, ZplanAvatarProto$Response, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAvatarPreviewHandler$getUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, ZplanAvatarProto$Response zplanAvatarProto$Response) {
                invoke(bool.booleanValue(), zplanAvatarProto$Response);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable ZplanAvatarProto$Response zplanAvatarProto$Response) {
                if (zplanAvatarProto$Response == null) {
                    Function1<GetUrlResult, Unit> function1 = callback;
                    if (function1 != null) {
                        function1.invoke(null);
                        return;
                    }
                    return;
                }
                ZplanAvatarProto$GetStatusRsp zplanAvatarProto$GetStatusRsp = zplanAvatarProto$Response.get_status;
                String str = zplanAvatarProto$GetStatusRsp.key.get();
                Intrinsics.checkNotNullExpressionValue(str, "getStatus.key.get()");
                String str2 = zplanAvatarProto$GetStatusRsp.download_url.get();
                Intrinsics.checkNotNullExpressionValue(str2, "getStatus.download_url.get()");
                boolean z17 = zplanAvatarProto$GetStatusRsp.check_md5_sha1.get();
                String str3 = zplanAvatarProto$GetStatusRsp.md5.get();
                Intrinsics.checkNotNullExpressionValue(str3, "getStatus.md5.get()");
                String str4 = zplanAvatarProto$GetStatusRsp.sha1.get();
                Intrinsics.checkNotNullExpressionValue(str4, "getStatus.sha1.get()");
                GetUrlResult getUrlResult = new GetUrlResult(str, str2, z17, str3, str4);
                Function1<GetUrlResult, Unit> function12 = callback;
                if (function12 != null) {
                    function12.invoke(getUrlResult);
                }
            }
        });
    }

    public final void k(@NotNull AppInterface app, long uin, @NotNull String key, @Nullable final Function2<? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(key, "key");
        ZplanAvatarProto$Request zplanAvatarProto$Request = new ZplanAvatarProto$Request();
        ZplanAvatarProto$IsExistStatusReq zplanAvatarProto$IsExistStatusReq = new ZplanAvatarProto$IsExistStatusReq();
        zplanAvatarProto$IsExistStatusReq.obj_uin.set(uin);
        PBStringField pBStringField = zplanAvatarProto$IsExistStatusReq.key;
        String lowerCase = key.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        pBStringField.set(lowerCase);
        zplanAvatarProto$Request.cmd.set(200);
        zplanAvatarProto$Request.is_exist_status.set(zplanAvatarProto$IsExistStatusReq);
        byte[] reqBody = zplanAvatarProto$Request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(reqBody, "reqBody");
        m(app, 200, reqBody, new Function2<Boolean, ZplanAvatarProto$Response, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAvatarPreviewHandler$isUrlExist$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, ZplanAvatarProto$Response zplanAvatarProto$Response) {
                invoke(bool.booleanValue(), zplanAvatarProto$Response);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable ZplanAvatarProto$Response zplanAvatarProto$Response) {
                if (!z16) {
                    Function2<Boolean, Boolean, Unit> function2 = callback;
                    if (function2 != null) {
                        Boolean bool = Boolean.FALSE;
                        function2.invoke(bool, bool);
                        return;
                    }
                    return;
                }
                if (zplanAvatarProto$Response == null) {
                    Function2<Boolean, Boolean, Unit> function22 = callback;
                    if (function22 != null) {
                        function22.invoke(Boolean.TRUE, Boolean.FALSE);
                        return;
                    }
                    return;
                }
                Function2<Boolean, Boolean, Unit> function23 = callback;
                if (function23 != null) {
                    function23.invoke(Boolean.TRUE, Boolean.valueOf(zplanAvatarProto$Response.is_exist_status.is_exist.get()));
                }
            }
        });
    }

    public final void l(@NotNull AppInterface app, @NotNull String key, @Nullable final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(key, "key");
        ZplanAvatarProto$Request zplanAvatarProto$Request = new ZplanAvatarProto$Request();
        zplanAvatarProto$Request.cmd.set(400);
        ZplanAvatarProto$SetStatusReq zplanAvatarProto$SetStatusReq = zplanAvatarProto$Request.set_status;
        ZplanAvatarProto$SetStatusReq zplanAvatarProto$SetStatusReq2 = new ZplanAvatarProto$SetStatusReq();
        zplanAvatarProto$SetStatusReq2.key.set(key);
        zplanAvatarProto$SetStatusReq.set(zplanAvatarProto$SetStatusReq2);
        byte[] reqBody = zplanAvatarProto$Request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(reqBody, "reqBody");
        m(app, 400, reqBody, new Function2<Boolean, ZplanAvatarProto$Response, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAvatarPreviewHandler$keepUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, ZplanAvatarProto$Response zplanAvatarProto$Response) {
                invoke(bool.booleanValue(), zplanAvatarProto$Response);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable ZplanAvatarProto$Response zplanAvatarProto$Response) {
                Function1<Boolean, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(z16));
                }
            }
        });
    }
}
