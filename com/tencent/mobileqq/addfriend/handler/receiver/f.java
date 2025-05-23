package com.tencent.mobileqq.addfriend.handler.receiver;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyRsp;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.friend.AddContactVerifyInfo$AddFriendVerifyInfo;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBeatRsp;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBtn;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/f;", "Lcom/tencent/mobileqq/addfriend/handler/receiver/a;", "Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;", "Lcom/tencent/qqnt/kernel/nativeinterface/AddBuddyRsp;", "resp", "Lcom/tencent/qqnt/remote/d;", "req", "", "f", "Landroid/os/Bundle;", "data", "Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "functionLockBeatRsp", "e", "", "b", "toNTMsg", "Lcom/tencent/qqnt/remote/b;", "fromNTMsg", "d", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;)V", "c", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends a<NTAddFriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.handler.receiver.f$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull AppInterface appRuntime, @NotNull NTAddFriendHandler handler) {
        super(appRuntime, handler);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        }
    }

    private final void e(Bundle data, FunctionLockMsg$FunctionLockBeatRsp functionLockBeatRsp) {
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

    private final void f(AddBuddyRsp resp, com.tencent.qqnt.remote.d req) {
        int intValue;
        boolean z16;
        String str;
        Long l3;
        Long l16;
        String str2;
        Bundle bundle = new Bundle();
        bundle.putAll(req.a());
        boolean z17 = false;
        if (resp == null) {
            c().notifyUI(3, false, bundle);
            QLog.d("NTFriendAddReceiver", 1, "handleAddFriend, resp is null");
            return;
        }
        bundle.putInt(QzoneIPCModule.RESULT_CODE, resp.result);
        String str3 = resp.errorString;
        if (str3 == null) {
            str3 = "";
        }
        bundle.putString("ErrorString", str3);
        Integer num = resp.errorCode;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        bundle.putInt("error_code", intValue);
        if (resp.verify != null) {
            AddContactVerifyInfo$AddFriendVerifyInfo addContactVerifyInfo$AddFriendVerifyInfo = new AddContactVerifyInfo$AddFriendVerifyInfo();
            try {
                addContactVerifyInfo$AddFriendVerifyInfo.mergeFrom(resp.verify);
            } catch (Exception e16) {
                QLog.e("NTFriendAddReceiver", 1, "handleAddFriend, AddFriendVerifyInfo mergeFrom failed: ", e16);
            }
            Integer num2 = resp.errorCode;
            if (num2 != null && num2.intValue() == 168) {
                FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp = new FunctionLockMsg$FunctionLockBeatRsp();
                try {
                    functionLockMsg$FunctionLockBeatRsp.mergeFrom(resp.verify);
                } catch (Exception e17) {
                    QLog.e("NTFriendAddReceiver", 1, "handleAddFriend, FunctionLockBeatRsp mergeFrom failed: ", e17);
                }
                e(bundle, functionLockMsg$FunctionLockBeatRsp);
            } else if (addContactVerifyInfo$AddFriendVerifyInfo.str_url.has()) {
                String str4 = addContactVerifyInfo$AddFriendVerifyInfo.str_url.get();
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("security_check_url", str4);
                    bundle.putString("security_check_buffer", addContactVerifyInfo$AddFriendVerifyInfo.str_verify_info.get());
                    c().notifyUI(8, true, bundle);
                    if (QLog.isColorLevel()) {
                        QLog.d("NTFriendAddReceiver", 2, "handleAddFriend, needSecCheck");
                        return;
                    }
                    return;
                }
            }
        }
        if (resp.result == 0) {
            Bundle a16 = req.a();
            boolean z18 = a16.getBoolean("auto_send", false);
            int i3 = a16.getInt("source_id");
            boolean z19 = a16.getBoolean("contact_bothway");
            if (z18 && com.tencent.mobileqq.friend.utils.a.a(resp.addFriendSetting, i3, z19)) {
                z16 = true;
            } else {
                z16 = false;
            }
            String str5 = null;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("resp.sig = ");
                byte[] bArr = resp.sig;
                if (bArr != null) {
                    str2 = Arrays.toString(bArr);
                    Intrinsics.checkNotNullExpressionValue(str2, "toString(this)");
                } else {
                    str2 = null;
                }
                sb5.append(str2);
                QLog.i("NTFriendAddReceiver", 2, sb5.toString());
            }
            bundle.putByteArray(PreloadTRTCPlayerParams.KEY_SIG, resp.sig);
            AccountInfo accountInfo = resp.targetInfo;
            if (accountInfo != null && (l16 = accountInfo.uin) != null) {
                str = String.valueOf(l16);
            } else {
                str = null;
            }
            bundle.putString(ISelectMemberActivityConstants.Result_Uin, str);
            if (z18 && z16) {
                z17 = true;
            }
            bundle.putBoolean(com.tencent.mobileqq.friend.observer.a.ADD_DIRECT, z17);
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("$handleAddFriend|autoSend=");
                sb6.append(z18);
                sb6.append(",uin");
                AccountInfo accountInfo2 = resp.targetInfo;
                if (accountInfo2 != null && (l3 = accountInfo2.uin) != null) {
                    str5 = String.valueOf(l3);
                }
                sb6.append(str5);
                sb6.append(",sourceId=");
                sb6.append(i3);
                sb6.append(",beBothWay=");
                sb6.append(z19);
                sb6.append(",successDirectly=");
                sb6.append(com.tencent.mobileqq.friend.utils.a.a(resp.addFriendSetting, i3, z19));
                QLog.d("NTFriendAddReceiver", 2, sb6.toString());
            }
            Iterator<BaseFriendProcessor> it = c().D2().iterator();
            while (it.hasNext()) {
                it.next().onAddFriendSuccess(resp, req);
            }
            c().notifyUI(3, true, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTFriendAddReceiver", 2, "ErrorString:" + resp.errorString + ",resultCode:" + resp.result + ",errorCode:" + resp.errorCode);
        }
        c().notifyUI(3, true, bundle);
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.api.a.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    public void d(@NotNull com.tencent.qqnt.remote.d toNTMsg, @NotNull com.tencent.qqnt.remote.b fromNTMsg) {
        AddBuddyRsp addBuddyRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toNTMsg, (Object) fromNTMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(toNTMsg, "toNTMsg");
        Intrinsics.checkNotNullParameter(fromNTMsg, "fromNTMsg");
        if (Intrinsics.areEqual(fromNTMsg.d(), com.tencent.mobileqq.addfriend.api.a.INSTANCE.a())) {
            if (QLog.isColorLevel()) {
                QLog.i("NTFriendAddReceiver", 2, "receive and handle cmd FriendCMD.CMD_ADD");
            }
            Object a16 = fromNTMsg.a();
            if (a16 instanceof AddBuddyRsp) {
                addBuddyRsp = (AddBuddyRsp) a16;
            } else {
                addBuddyRsp = null;
            }
            f(addBuddyRsp, toNTMsg);
            return;
        }
        QLog.e("NTFriendAddReceiver", 1, "receive cmd error: can not handle");
    }
}
