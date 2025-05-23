package com.tencent.ilink.interfaces;

import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.interfaces.ILinkCallbackInterface;
import com.tencent.luggage.wxa.s0.b;
import com.tencent.luggage.wxa.s0.d;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ILinkAppImInterfaceService {
    private static final String TAG = "ILinkImInterfaceService";
    private static ILinkAppImInterfaceService instance;
    public IILinkCallback iILinkCallback;
    private TimerTask task;
    private Timer timer;
    public static final int CONTACT_OPCODE_ADD = ILinkCallbackInterface.EnContactOpCode.CONTACT_ADD.toValue();
    public static final int CONTACT_OPCODE_UPDATE = ILinkCallbackInterface.EnContactOpCode.CONTACT_UPDATE.toValue();
    public static final int CONTACT_OPCODE_DELETE = ILinkCallbackInterface.EnContactOpCode.CONTACT_DELETE.toValue();

    ILinkAppImInterfaceService() {
    }

    public static ILinkAppImInterfaceService getInstance() {
        if (instance == null) {
            instance = new ILinkAppImInterfaceService();
        }
        return instance;
    }

    public static void setVoipAppid(String str) {
        ILinkAppImInterface.setVoipAppid(str);
    }

    public void cancelInterfaceTimer() {
        if (this.timer != null) {
            this.task.cancel();
            this.timer.cancel();
        }
    }

    public void cancelLogin() {
        ILinkAppImInterface.cancelLogin();
    }

    public void closeSdkAccount() {
        ILinkAppImInterface.closeSdkAccount();
    }

    public void deleteContactByIlinkId(String str) {
        ILinkAppImInterface.deleteContactByIlinkimId(str);
    }

    public ArrayList<b> getAllContacts() {
        ArrayList<byte[]> allContacts = ILinkAppImInterface.getAllContacts();
        ArrayList<b> arrayList = new ArrayList<>();
        if (allContacts != null) {
            Log.d(TAG, "getAllContacts size:" + allContacts.size());
            try {
                Iterator<byte[]> it = allContacts.iterator();
                while (it.hasNext()) {
                    byte[] next = it.next();
                    if (b.a(next) != null) {
                        arrayList.add(b.a(next));
                    }
                }
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        } else {
            Log.e(TAG, "contacts is null");
        }
        return arrayList;
    }

    public ArrayList<d> getAllUnVerifyRequests() {
        ArrayList<byte[]> allUnVerifyRequests = ILinkAppImInterface.getAllUnVerifyRequests();
        ArrayList<d> arrayList = new ArrayList<>();
        Iterator<byte[]> it = allUnVerifyRequests.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(d.a(it.next()));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        return arrayList;
    }

    public b getContactByIlinkimId(String str) {
        try {
            return b.a(ILinkAppImInterface.getContactByIlinkimId(str));
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public int getDeviceShadow() {
        return ILinkAppImInterface.getDeviceShadow();
    }

    public IILinkCallback getILinkCallback() {
        return this.iILinkCallback;
    }

    public void getImTicket(int i3) {
        ILinkAppImInterface.getImTicket(i3);
    }

    public Profile getProfile() {
        return Profile.pb2Profile(ILinkAppImInterface.getProfile());
    }

    public void getPublicAccountQrCode(int i3) {
        ILinkAppImInterface.getPublicAccountQrCode(i3);
    }

    public long getUin() {
        return ILinkAppImInterface.getUin();
    }

    public void handleContactVerifyRequest(String str, boolean z16) {
        ILinkAppImInterface.handleContactVerifyRequest(str, z16);
    }

    public int init(String str, String str2, boolean z16, boolean z17) {
        return ILinkAppImInterface.init(str, str2, z17);
    }

    public void initContacts() {
        ILinkAppImInterface.initContacts();
    }

    public void login(int i3) {
        Log.v(TAG, "login");
        if (this.timer != null) {
            this.task.cancel();
            this.timer.cancel();
            this.timer = null;
        }
        this.timer = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.ilink.interfaces.ILinkAppImInterfaceService.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IILinkCallback iLinkCallback = ILinkAppImInterfaceService.this.getILinkCallback();
                if (iLinkCallback != null) {
                    iLinkCallback.onLoginComplete(303);
                }
            }
        };
        this.task = timerTask;
        this.timer.schedule(timerTask, i3 * 1000);
        ILinkAppImInterface.login();
    }

    public void logout(boolean z16) {
        ILinkAppImInterface.logout(z16);
    }

    public void reportDataWithCacheKey(String str, byte[] bArr, int i3) {
        ILinkAppImInterface.reportDataWithCacheKey(str, bArr, i3);
    }

    public String sendImageMessage(String str, byte[] bArr) {
        return ILinkAppImInterface.sendImageMessage(str, bArr);
    }

    public String sendIotMessage(String str, String str2, String str3) {
        return ILinkAppImInterface.sendIotMessage(str, str2, str3);
    }

    public String sendTextMessage(String str, String str2) {
        return ILinkAppImInterface.sendTextMessage(str, str2);
    }

    public String sendVideoMessage(String str, byte[] bArr) {
        return ILinkAppImInterface.sendVideoMessage(str, bArr);
    }

    public void setILinkCallback(IILinkCallback iILinkCallback) {
        this.iILinkCallback = iILinkCallback;
    }

    public void startAutoSync(int i3) {
        ILinkAppImInterface.startAutoSync(i3);
    }

    public void uninit() {
        ILinkAppImInterface.uninit();
    }

    public void updateAvatar(String str) {
        ILinkAppImInterface.updateAvatar(str);
    }

    public void updateContactAlias(String str, String str2) {
        ILinkAppImInterface.updateContactAlias(str, str2);
    }

    public int updateDeviceShadow(byte[] bArr) {
        return ILinkAppImInterface.updateDeviceShadow(bArr);
    }

    public void updateNickname(String str) {
        ILinkAppImInterface.updateNickname(str);
    }
}
