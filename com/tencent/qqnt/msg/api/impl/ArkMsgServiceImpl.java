package com.tencent.qqnt.msg.api.impl;

import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IArkMsgService;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/ArkMsgServiceImpl;", "Lcom/tencent/qqnt/msg/api/IArkMsgService;", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "transToMsgArkElement", "", "guildID", "channelID", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "createContact", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "", SmsPlugin.API_SEND_SMS, "contact", "", "sendMsgWithMsgId", "TAG", "Ljava/lang/String;", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ArkMsgServiceImpl implements IArkMsgService {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    public ArkMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "ArkMsgServiceImpl";
        }
    }

    private final Contact createContact(String guildID, String channelID) {
        return new Contact(4, channelID, guildID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMsg$lambda$0(ArkMsgServiceImpl this$0, IOperateCallback iOperateCallback, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i(this$0.TAG, 4, "sendArkMsg result=" + i3 + " errMsg=" + errMsg);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMsgWithMsgId$lambda$1(ArkMsgServiceImpl this$0, long j3, IOperateCallback iOperateCallback, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i(this$0.TAG, 4, "sendMsgWithMsgId result=" + i3 + " errMsg=" + errMsg + ", msgId: " + j3);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, errMsg);
        }
    }

    private final ArrayList<MsgElement> transToMsgArkElement(com.tencent.qqnt.msg.data.a arkMsgModel) {
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createArkElement(arkMsgModel));
        return arrayList;
    }

    @Override // com.tencent.qqnt.msg.api.IArkMsgService
    public void sendMsg(@NotNull String guildID, @NotNull String channelID, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, guildID, channelID, arkMsgModel, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        sendMsg(createContact(guildID, channelID), arkMsgModel, listener);
    }

    @Override // com.tencent.qqnt.msg.api.IArkMsgService
    public long sendMsgWithMsgId(@NotNull Contact contact, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable final IOperateCallback listener) {
        final long j3;
        Long j06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, contact, arkMsgModel, listener)).longValue();
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        w e16 = f.e();
        if (e16 != null && (j06 = e16.j0(contact.chatType)) != null) {
            j3 = j06.longValue();
        } else {
            j3 = 0;
        }
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, j3, transToMsgArkElement(arkMsgModel), new IOperateCallback() { // from class: com.tencent.qqnt.msg.api.impl.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                ArkMsgServiceImpl.sendMsgWithMsgId$lambda$1(ArkMsgServiceImpl.this, j3, listener, i3, str);
            }
        });
        return j3;
    }

    @Override // com.tencent.qqnt.msg.api.IArkMsgService
    public void sendMsg(@NotNull Contact contact, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable final IOperateCallback listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, contact, arkMsgModel, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, transToMsgArkElement(arkMsgModel), new IOperateCallback() { // from class: com.tencent.qqnt.msg.api.impl.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                ArkMsgServiceImpl.sendMsg$lambda$0(ArkMsgServiceImpl.this, listener, i3, str);
            }
        });
    }
}
