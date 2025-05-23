package com.tencent.mobileqq.flashchat;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends MSFServlet {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ArrayList<FlashChatItem> a(byte[] bArr) {
        try {
            FlashChatSso$TSsoRsp flashChatSso$TSsoRsp = new FlashChatSso$TSsoRsp();
            flashChatSso$TSsoRsp.mergeFrom(bArr);
            if (flashChatSso$TSsoRsp.st_cmd0x1_rsp.has()) {
                ArrayList<FlashChatItem> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < flashChatSso$TSsoRsp.st_cmd0x1_rsp.item.size(); i3++) {
                    FlashChatSso$TItem flashChatSso$TItem = flashChatSso$TSsoRsp.st_cmd0x1_rsp.item.get(i3);
                    FlashChatItem flashChatItem = new FlashChatItem();
                    flashChatItem.f209775id = flashChatSso$TItem.i32_id.get();
                    flashChatItem.feedType = flashChatSso$TItem.uint32_feetype.get();
                    flashChatItem.name = flashChatSso$TItem.string_name.get();
                    flashChatItem.appName = flashChatSso$TItem.string_app_name.get();
                    flashChatItem.iconUrl = flashChatSso$TItem.string_icon_url.get();
                    flashChatItem.mainView = flashChatSso$TItem.string_main_view.get();
                    flashChatItem.ver = flashChatSso$TItem.string_ver.get();
                    flashChatItem.color = flashChatSso$TItem.string_bg_color.get();
                    arrayList.add(flashChatItem);
                }
                return arrayList;
            }
            return null;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean isSuccess;
        ArrayList<FlashChatItem> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg == null) {
            isSuccess = false;
        } else {
            isSuccess = fromServiceMsg.isSuccess();
        }
        int intExtra = intent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, 0);
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "onReceive cmd:" + intExtra);
        }
        Bundle bundle = new Bundle();
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r14.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                if (intExtra == 1 && (a16 = a(bArr)) != null) {
                    ((FlashChatManager) getAppRuntime().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).z(a16, true, bArr);
                    notifyObserver(intent, 967, isSuccess, bundle, b.class);
                    return;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        notifyObserver(intent, 967, false, bundle, b.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int intExtra = intent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, -1);
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "onSend cmd:" + intExtra);
        }
        if (intExtra == 1) {
            FlashChatSso$TSsoReq flashChatSso$TSsoReq = new FlashChatSso$TSsoReq();
            flashChatSso$TSsoReq.i32_cmd.set(1);
            flashChatSso$TSsoReq.i32_implat.set(109);
            flashChatSso$TSsoReq.str_qq_ver.set(AppSetting.f99551k);
            byte[] byteArray = flashChatSso$TSsoReq.toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
            allocate.putInt(byteArray.length + 4).put(byteArray);
            byte[] array = allocate.array();
            packet.setSSOCommand("Flashchat.OpReq");
            packet.putSendData(array);
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "FlashChatServlet onSend ssoCmd:Flashchat.OpReq");
            }
        }
    }
}
