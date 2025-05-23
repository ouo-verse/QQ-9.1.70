package com.tencent.mobileqq.servlet;

import android.os.Bundle;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.register.RegisterConfigPB$FinishRegisterReq;
import tencent.im.oidb.register.RegisterConfigPB$FinishRegisterRsp;
import tencent.im.oidb.register.RegisterConfigPB$GetRegisterHeadConfigReq;
import tencent.im.oidb.register.RegisterConfigPB$GetRegisterHeadConfigRsp;
import tencent.im.oidb.register.RegisterConfigPB$RegisterHeadConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\n\u001a\u00020\b2'\u0010\t\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\u0014\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0016\u0018\u00010\u0015H\u0014J\u0012\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/servlet/RegisterZPlanAvatarHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "Lkotlin/ParameterName;", "name", "avatarList", "", "callback", Constants.MMCCID, "", "callbackInfo", "E2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "", "getCommandList", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RegisterZPlanAvatarHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/servlet/RegisterZPlanAvatarHandler$a;", "", "", "CMD_FINISH_REGISTER", "Ljava/lang/String;", "CMD_REGISTER_GET_HEAD_CONFIG", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.servlet.RegisterZPlanAvatarHandler$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/servlet/RegisterZPlanAvatarHandler$b", "Lmqq/observer/BusinessObserver;", "", "Ltencent/im/oidb/register/RegisterConfigPB$RegisterHeadConfig;", "originAvatarList", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "avatarList", "", "a", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "onReceive", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<List<ZPlanAvatarInfo>, Unit> f286464d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super List<ZPlanAvatarInfo>, Unit> function1) {
            this.f286464d = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        private final void a(List<RegisterConfigPB$RegisterHeadConfig> originAvatarList, List<ZPlanAvatarInfo> avatarList) {
            for (RegisterConfigPB$RegisterHeadConfig registerConfigPB$RegisterHeadConfig : originAvatarList) {
                String str = registerConfigPB$RegisterHeadConfig.default_url.get();
                String str2 = registerConfigPB$RegisterHeadConfig.out_bounds_clipper_url.get();
                String str3 = registerConfigPB$RegisterHeadConfig.background_config.url.get();
                int i3 = registerConfigPB$RegisterHeadConfig.background_config.f436024id.get();
                int i16 = (int) (registerConfigPB$RegisterHeadConfig.mask_rate.get() * 100);
                String str4 = registerConfigPB$RegisterHeadConfig.suit_id.get();
                byte[] byteArray = registerConfigPB$RegisterHeadConfig.call_back_info.get().toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "avatar.call_back_info.get().toByteArray()");
                ZPlanAvatarInfo zPlanAvatarInfo = new ZPlanAvatarInfo(str, str2, str3, i3, i16, str4, byteArray);
                avatarList.add(zPlanAvatarInfo);
                QLog.d("RegisterZPlanAvatarHandler", 1, "addToAvatarList " + zPlanAvatarInfo);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int type, boolean isSuccess, @Nullable Bundle bundle) {
            byte[] bArr;
            List<ZPlanAvatarInfo> emptyList;
            List<RegisterConfigPB$RegisterHeadConfig> mutableList;
            List<ZPlanAvatarInfo> emptyList2;
            List<ZPlanAvatarInfo> emptyList3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), bundle);
                return;
            }
            if (!isSuccess) {
                QLog.e("RegisterZPlanAvatarHandler", 1, "onReceive isSuccess: false");
                Function1<List<ZPlanAvatarInfo>, Unit> function1 = this.f286464d;
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                function1.invoke(emptyList3);
                return;
            }
            RegisterConfigPB$GetRegisterHeadConfigRsp registerConfigPB$GetRegisterHeadConfigRsp = new RegisterConfigPB$GetRegisterHeadConfigRsp();
            if (bundle != null) {
                bArr = bundle.getByteArray("data");
            } else {
                bArr = null;
            }
            if (bArr == null) {
                QLog.e("RegisterZPlanAvatarHandler", 1, "onReceive data is null");
                Function1<List<ZPlanAvatarInfo>, Unit> function12 = this.f286464d;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                function12.invoke(emptyList2);
                return;
            }
            try {
                RegisterConfigPB$GetRegisterHeadConfigRsp mergeFrom = registerConfigPB$GetRegisterHeadConfigRsp.mergeFrom(bArr);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "rsp.mergeFrom(data)");
                List<RegisterConfigPB$RegisterHeadConfig> list = mergeFrom.register_head_configs.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.register_head_configs.get()");
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                ArrayList arrayList = new ArrayList();
                a(mutableList, arrayList);
                QLog.i("RegisterZPlanAvatarHandler", 1, "onReceive rsp:" + arrayList.size());
                this.f286464d.invoke(arrayList);
            } catch (Exception e16) {
                QLog.e("RegisterZPlanAvatarHandler", 1, "onReceive error:" + e16);
                Function1<List<ZPlanAvatarInfo>, Unit> function13 = this.f286464d;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                function13.invoke(emptyList);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegisterZPlanAvatarHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(int i3, boolean z16, Object obj) {
        QLog.i("RegisterZPlanAvatarHandler", 2, "finishRegister onReceive " + z16);
    }

    public final void E2(@NotNull byte[] callbackInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callbackInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(callbackInfo, "callbackInfo");
        QLog.i("RegisterZPlanAvatarHandler", 1, "finishRegister");
        RegisterConfigPB$FinishRegisterReq registerConfigPB$FinishRegisterReq = new RegisterConfigPB$FinishRegisterReq();
        registerConfigPB$FinishRegisterReq.call_back_info.set(ByteStringMicro.copyFrom(callbackInfo));
        registerConfigPB$FinishRegisterReq.ue_version.set(((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanVersion());
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.zplan.avatar_head_info.Config.SsoFinishRegister", new com.tencent.mobileqq.app.BusinessObserver() { // from class: com.tencent.mobileqq.servlet.p
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                RegisterZPlanAvatarHandler.F2(i3, z16, obj);
            }
        });
        createToServiceMsg.putWupBuffer(registerConfigPB$FinishRegisterReq.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public final void G2(@NotNull Function1<? super List<ZPlanAvatarInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("RegisterZPlanAvatarHandler", 1, "fetchAvatarList");
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.mobileqq.loginregister.servlet.e.class);
        newIntent.setObserver(new b(callback));
        newIntent.setWithouLogin(true);
        newIntent.putExtra("data", new MessageMicro<RegisterConfigPB$GetRegisterHeadConfigReq>() { // from class: tencent.im.oidb.register.RegisterConfigPB$GetRegisterHeadConfigReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RegisterConfigPB$GetRegisterHeadConfigReq.class);
        }.toByteArray());
        newIntent.putExtra("cmd", "trpc.zplan.avatar_head_info.Config.SsoGetRegisterHeadConfig");
        newIntent.putExtra("action", 1025);
        MobileQQ.sMobileQQ.peekAppRuntime().startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @Nullable
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.zplan.avatar_head_info.Config.SsoFinishRegister");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends com.tencent.mobileqq.app.BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, req, res, data);
            return;
        }
        if (res != null && !msgCmdFilter(res.getServiceCmd()) && Intrinsics.areEqual("trpc.zplan.avatar_head_info.Config.SsoFinishRegister", res.getServiceCmd())) {
            QLog.i("RegisterZPlanAvatarHandler", 1, "onReceive SsoFinishRegister result : " + OidbWrapper.parseOIDBPkg(res, data, new MessageMicro<RegisterConfigPB$FinishRegisterRsp>() { // from class: tencent.im.oidb.register.RegisterConfigPB$FinishRegisterRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RegisterConfigPB$FinishRegisterRsp.class);
            }));
        }
    }
}
