package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.pb.chatbgInfo.chatbgInfo$Bg_Auth_Rst;
import com.tencent.pb.chatbgInfo.chatbgInfo$Bg_CheckAuth_Rsp;
import com.tencent.pb.chatbgInfo.chatbgInfo$Bg_Effect_Auth_Rst;
import com.tencent.pb.chatbgInfo.chatbgInfo$Bg_Rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ChatBackgroundAuthHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f194478d;

    protected ChatBackgroundAuthHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194478d = qQAppInterface;
        }
    }

    private void E2(chatbgInfo$Bg_CheckAuth_Rsp chatbginfo_bg_checkauth_rsp) {
        List<chatbgInfo$Bg_Effect_Auth_Rst> list = chatbginfo_bg_checkauth_rsp.AuthEffectRst.get();
        HashMap hashMap = new HashMap();
        Iterator<chatbgInfo$Bg_Effect_Auth_Rst> it = list.iterator();
        while (true) {
            int i3 = 1;
            if (!it.hasNext()) {
                break;
            }
            chatbgInfo$Bg_Effect_Auth_Rst next = it.next();
            int i16 = next.effectId.get();
            String valueOf = String.valueOf(next.result.get());
            if (valueOf.endsWith(QQHealthReportApiImpl.MSG_EXPOSE_KEY) || valueOf.equals(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED)) {
                i3 = 0;
            }
            hashMap.put(Integer.valueOf(i16), Integer.valueOf(i3));
        }
        HashMap<String, Integer> q16 = ((ChatBackgroundManager) this.f194478d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).q();
        SharedPreferences.Editor edit = ChatBackgroundUtil.getMMKVData(this.f194478d.getApplication().getApplicationContext(), this.f194478d.getCurrentAccountUin()).edit();
        if (q16 != null) {
            for (String str : q16.keySet()) {
                int intValue = q16.get(str).intValue();
                if (intValue > 0) {
                    try {
                        int intValue2 = Integer.valueOf(intValue).intValue();
                        if (hashMap.containsKey(Integer.valueOf(intValue2)) && ((Integer) hashMap.get(Integer.valueOf(intValue2))).intValue() == 1) {
                            if (AppConstants.Preferences.CHAT_BG_EFFECT.equals(str)) {
                                VasLogReporter.getChatBackground().reportHighest("effect auth : remove uniform effect");
                                edit.remove(AppConstants.Preferences.CHAT_BG_EFFECT);
                            } else {
                                VasLogReporter.getChatBackground().reportHighest("effect auth : remove " + str + " effect");
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(str);
                                sb5.append(AppConstants.Preferences.CHAT_BG_EFFECT);
                                edit.remove(sb5.toString());
                            }
                            VasLogReporter.getChatBackground().reportHighest("chatBackground auth error: bgEffectId = " + intValue2 + " key:" + str);
                        }
                    } catch (Exception unused) {
                        QLog.i("ChatBackgroundAuthHandler", 1, "bgEffectId\u8f6c\u5316int\u578b\u51fa\u9519");
                    }
                }
            }
            edit.commit();
        }
    }

    public void D2(Map<Integer, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) map);
            return;
        }
        HashMap<String, String> p16 = ((ChatBackgroundManager) this.f194478d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).p();
        SharedPreferences.Editor edit = ChatBackgroundUtil.getMMKVData(this.f194478d.getApplication().getApplicationContext(), this.f194478d.getCurrentAccountUin()).edit();
        if (p16 != null) {
            for (String str : p16.keySet()) {
                String str2 = p16.get(str);
                if (str2 != null && !str2.equals("null") && !str2.equals("custom")) {
                    try {
                        int intValue = Integer.valueOf(str2).intValue();
                        if (map.containsKey(Integer.valueOf(intValue)) && map.get(Integer.valueOf(intValue)).intValue() == 1) {
                            edit.putString(str, "null");
                            VasLogReporter.getChatBackground().reportHighest("auth : " + str + " error: bgId = " + intValue);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ChatBackgroundAuthHandler", 2, "\u80cc\u666fid\u8f6c\u5316int\u578b\u51fa\u9519");
                        }
                        e16.printStackTrace();
                    }
                }
            }
            edit.commit();
        }
    }

    protected void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            chatbgInfo$Bg_Rsp chatbginfo_bg_rsp = new chatbgInfo$Bg_Rsp();
            try {
                chatbginfo_bg_rsp.mergeFrom((byte[]) obj);
                if (chatbginfo_bg_rsp.ret.get() == 0) {
                    chatbgInfo$Bg_CheckAuth_Rsp chatbginfo_bg_checkauth_rsp = chatbginfo_bg_rsp.rspcmd_0x01.get();
                    List<chatbgInfo$Bg_Auth_Rst> list = chatbginfo_bg_checkauth_rsp.AuthRst.get();
                    HashMap hashMap = new HashMap();
                    for (chatbgInfo$Bg_Auth_Rst chatbginfo_bg_auth_rst : list) {
                        int i16 = chatbginfo_bg_auth_rst.bgId.get();
                        String valueOf = String.valueOf(chatbginfo_bg_auth_rst.result.get());
                        if (!valueOf.endsWith(QQHealthReportApiImpl.MSG_EXPOSE_KEY) && !valueOf.equals(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED)) {
                            i3 = 1;
                            hashMap.put(Integer.valueOf(i16), Integer.valueOf(i3));
                        }
                        i3 = 0;
                        hashMap.put(Integer.valueOf(i16), Integer.valueOf(i3));
                    }
                    D2(hashMap);
                    E2(chatbginfo_bg_checkauth_rsp);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("Background.checkAuth".equals(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatBackgroundAuthHandler", 2, "onReceive called.");
            }
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
