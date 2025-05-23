package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import friendlist.AddFriendResp;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.friend.AddContactVerifyInfo$AddFriendVerifyInfo;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBeatRsp;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBtn;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/recevier/d;", "Lcom/tencent/mobileqq/friend/handler/recevier/a;", "Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "", "c", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "e", "Lfriendlist/AddFriendResp;", "resp", "g", "Landroid/os/Bundle;", "Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "functionLockBeatRsp", "f", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/friend/handler/FriendHandler;)V", "a", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/recevier/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.handler.recevier.d$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34841);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull AppInterface appRuntime, @NotNull FriendHandler handler) {
        super(appRuntime, handler);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "friendlist.addFriend";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, req, res, data);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        if (Intrinsics.areEqual(res.getServiceCmd(), "friendlist.addFriend")) {
            if (QLog.isColorLevel()) {
                QLog.i("IMCore.friend.FriendAddReceiver", 2, "receive and handle cmd FriendCMD.CMD_ADD");
            }
            g((AddFriendResp) data, req);
            return;
        }
        QLog.e("IMCore.friend.FriendAddReceiver", 1, "receive cmd error: can not handle");
    }

    public final void f(@NotNull Bundle data, @NotNull FunctionLockMsg$FunctionLockBeatRsp functionLockBeatRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) data, (Object) functionLockBeatRsp);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(functionLockBeatRsp, "functionLockBeatRsp");
        data.putString("error_tips_wording", functionLockBeatRsp.wording.get());
        for (FunctionLockMsg$FunctionLockBtn functionLockMsg$FunctionLockBtn : functionLockBeatRsp.btns.get()) {
            if (functionLockMsg$FunctionLockBtn != null) {
                if (functionLockMsg$FunctionLockBtn.jump_type.get() == 1) {
                    data.putString("error_tips_h5_url", functionLockMsg$FunctionLockBtn.url.get());
                    data.putString("error_tips_jump_btn_wording", functionLockMsg$FunctionLockBtn.woding.get());
                } else if (functionLockMsg$FunctionLockBtn.jump_type.get() == 2) {
                    data.putString("error_tips_mini_app_url", functionLockMsg$FunctionLockBtn.url.get());
                    data.putString("error_tips_jump_btn_wording", functionLockMsg$FunctionLockBtn.woding.get());
                } else if (functionLockMsg$FunctionLockBtn.jump_type.get() == 0) {
                    data.putString("error_tips_cancel_wording", functionLockMsg$FunctionLockBtn.woding.get());
                }
            }
        }
    }

    public final void g(@Nullable AddFriendResp resp, @NotNull ToServiceMsg req) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) resp, (Object) req);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Bundle bundle = new Bundle();
        bundle.putAll(req.extraData);
        boolean z17 = false;
        if (resp == null) {
            d().notifyUI(11, false, bundle);
            QLog.d("IMCore.friend.FriendAddReceiver", 1, "handleAddFriend, resp or req is null");
            return;
        }
        bundle.putInt(QzoneIPCModule.RESULT_CODE, resp.result);
        bundle.putString("ErrorString", resp.ErrorString);
        bundle.putInt("error_code", resp.errorCode);
        if (resp.verify != null) {
            AddContactVerifyInfo$AddFriendVerifyInfo addContactVerifyInfo$AddFriendVerifyInfo = new AddContactVerifyInfo$AddFriendVerifyInfo();
            try {
                addContactVerifyInfo$AddFriendVerifyInfo.mergeFrom(resp.verify);
            } catch (Exception e16) {
                QLog.e("IMCore.friend.FriendAddReceiver", 1, "handleAddFriend, AddFriendVerifyInfo mergeFrom failed: ", e16);
            }
            if (resp.errorCode == 168) {
                FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp = new FunctionLockMsg$FunctionLockBeatRsp();
                try {
                    functionLockMsg$FunctionLockBeatRsp.mergeFrom(resp.verify);
                } catch (Exception e17) {
                    QLog.e("IMCore.friend.FriendAddReceiver", 1, "handleAddFriend, FunctionLockBeatRsp mergeFrom failed: ", e17);
                }
                f(bundle, functionLockMsg$FunctionLockBeatRsp);
            } else if (addContactVerifyInfo$AddFriendVerifyInfo.str_url.has()) {
                String str = addContactVerifyInfo$AddFriendVerifyInfo.str_url.get();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("security_check_url", str);
                    bundle.putString("security_check_buffer", addContactVerifyInfo$AddFriendVerifyInfo.str_verify_info.get());
                    d().notifyUI(113, true, bundle);
                    if (QLog.isColorLevel()) {
                        QLog.d("IMCore.friend.FriendAddReceiver", 2, "handleAddFriend, needSecCheck");
                        return;
                    }
                    return;
                }
            }
        }
        if (resp.result == 0) {
            Bundle bundle2 = req.extraData;
            boolean z18 = bundle2.getBoolean("auto_send", false);
            int i3 = bundle2.getInt("source_id");
            boolean z19 = bundle2.getBoolean("contact_bothway");
            if (z18 && com.tencent.mobileqq.friend.utils.a.a(resp.adduinsetting, i3, z19)) {
                z16 = true;
            } else {
                z16 = false;
            }
            bundle.putByteArray(PreloadTRTCPlayerParams.KEY_SIG, resp.sig);
            bundle.putString(ISelectMemberActivityConstants.Result_Uin, String.valueOf(resp.adduin));
            if (z18 && z16) {
                z17 = true;
            }
            bundle.putBoolean(com.tencent.mobileqq.friend.observer.a.ADD_DIRECT, z17);
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.FriendAddReceiver", 2, "$handleAddFriend|autoSend=" + z18 + ",uin" + resp.adduin + ",sourceId=" + i3 + ",beBothWay=" + z19 + ",successDirectly=" + com.tencent.mobileqq.friend.utils.a.a(resp.adduinsetting, i3, z19));
            }
            Iterator<BaseFriendProcessor> it = d().F2().iterator();
            while (it.hasNext()) {
                it.next().onAddFriendSuccess(resp, req);
            }
            d().notifyUI(11, true, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendAddReceiver", 2, "ErrorString:" + resp.ErrorString + ",resultCode:" + resp.result + ",errorCode:" + ((int) resp.errorCode));
        }
        d().notifyUI(11, true, bundle);
    }
}
