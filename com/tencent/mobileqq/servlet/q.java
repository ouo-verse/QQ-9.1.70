package com.tencent.mobileqq.servlet;

import QQService.strupbuff;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q extends MSFServlet {
    static IPatchRedirector $redirector_;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new String[]{BaseConstants.CMD_REPORTSTAT};
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (BaseConstants.CMD_REPORTSTAT.equals(fromServiceMsg.getServiceCmd()) && intent != null && intent.getExtras() != null) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            if (intent.getExtras().getInt("seqKey") != 0) {
                notifyObserver(intent, intent.getExtras().getInt("sendType"), isSuccess, intent.getExtras(), null);
            }
            if (isSuccess) {
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String str;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        String str2;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        switch (intent.getExtras().getInt("sendType")) {
            case 2:
                StrupBuff strupBuff = new StrupBuff();
                String string = intent.getExtras().getString("tag");
                strupBuff.prefix = "";
                String string2 = intent.getExtras().getString("content");
                ArrayList arrayList3 = new ArrayList();
                if (ReportController.z(string)) {
                    str = "GBK";
                } else {
                    str = "UTF-8";
                }
                try {
                    arrayList3.add(string2.getBytes(str));
                    HashMap hashMap = new HashMap();
                    hashMap.put(string, arrayList3);
                    strupBuff.logstring = new HashMap(hashMap);
                    strupBuff.encoding = (byte) 0;
                    packet.setSSOCommand(BaseConstants.CMD_REPORTSTAT);
                    packet.setServantName("QQService.CliLogSvc.MainServantObj");
                    packet.setFuncName("UploadReq");
                    packet.addRequestPacket("Data", strupBuff);
                    packet.setNoResponse();
                    if (QLog.isColorLevel() && "dc02181".equals(string)) {
                        QLog.d("CaptureReport", 2, "[Capture Report Send:runtime] tag = " + string + ", content = " + string2);
                        return;
                    }
                    return;
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                    return;
                }
            case 3:
                sendToMSF(intent, MsfMsgUtil.getCurrentDataCountMsg(null, intent.getStringArrayExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS)));
                return;
            case 4:
                String string3 = intent.getExtras().getString("tagName");
                long j3 = intent.getExtras().getLong("duration");
                long j16 = intent.getExtras().getLong("size");
                Boolean valueOf = Boolean.valueOf(intent.getExtras().getBoolean("success"));
                HashMap hashMap2 = (HashMap) intent.getExtras().getSerializable("Params_MAP");
                Boolean valueOf2 = Boolean.valueOf(intent.getExtras().getBoolean("realtime"));
                RdmReq rdmReq = new RdmReq();
                rdmReq.eventName = string3;
                rdmReq.elapse = j3;
                rdmReq.size = j16;
                rdmReq.isSucceed = valueOf.booleanValue();
                rdmReq.isRealTime = valueOf2.booleanValue();
                rdmReq.params = hashMap2;
                sendToMSF(intent, MsfMsgUtil.getRdmReportMsg(null, rdmReq));
                return;
            case 5:
            default:
                return;
            case 6:
                StrupBuff strupBuff2 = new StrupBuff();
                String string4 = intent.getExtras().getString("tag");
                strupBuff2.prefix = "";
                ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("content");
                ArrayList arrayList4 = new ArrayList();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    try {
                        arrayList4.add(it.next().getBytes("utf-8"));
                    } catch (UnsupportedEncodingException e17) {
                        e17.printStackTrace();
                        return;
                    }
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put(string4, arrayList4);
                strupBuff2.logstring = new HashMap(hashMap3);
                strupBuff2.encoding = (byte) 2;
                packet.setSSOCommand(BaseConstants.CMD_REPORTSTAT);
                packet.setServantName("QQService.CliLogSvc.MainServantObj");
                packet.setFuncName("UploadReq");
                packet.addRequestPacket("Data", strupBuff2);
                packet.setNoResponse();
                return;
            case 7:
                sendToMSF(intent, MsfMsgUtil.getAppDataIncermentMsg(null, intent.getStringExtra("uin"), intent.getStringArrayExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS), intent.getLongExtra("count", 0L)));
                return;
            case 8:
                StrupBuff strupBuff3 = new StrupBuff();
                strupBuff3.prefix = "";
                ArrayList<String> stringArrayList2 = intent.getExtras().getStringArrayList(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
                ArrayList<String> stringArrayList3 = intent.getExtras().getStringArrayList("contents");
                HashMap hashMap4 = new HashMap();
                for (int i3 = 0; i3 < stringArrayList2.size(); i3++) {
                    String str3 = stringArrayList2.get(i3);
                    try {
                        byte[] bytes = stringArrayList3.get(i3).getBytes("utf-8");
                        ArrayList arrayList5 = (ArrayList) hashMap4.get(str3);
                        if (arrayList5 == null) {
                            arrayList5 = new ArrayList();
                            hashMap4.put(str3, arrayList5);
                        }
                        arrayList5.add(bytes);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                strupBuff3.logstring = new HashMap(hashMap4);
                strupBuff3.encoding = (byte) 2;
                packet.setSSOCommand(BaseConstants.CMD_REPORTSTAT);
                packet.setServantName("QQService.CliLogSvc.MainServantObj");
                packet.setFuncName("UploadReq");
                packet.addRequestPacket("Data", strupBuff3);
                packet.setNoResponse();
                return;
            case 9:
                StrupBuff strupBuff4 = new StrupBuff();
                String string5 = intent.getExtras().getString("tag");
                strupBuff4.prefix = "";
                byte[] byteArray = intent.getExtras().getByteArray("content");
                ArrayList arrayList6 = new ArrayList();
                arrayList6.add(byteArray);
                HashMap hashMap5 = new HashMap();
                hashMap5.put(string5, arrayList6);
                strupBuff4.logstring = new HashMap(hashMap5);
                strupBuff4.encoding = (byte) 0;
                packet.setSSOCommand(BaseConstants.CMD_REPORTSTAT);
                packet.setServantName("QQService.CliLogSvc.MainServantObj");
                packet.setFuncName("UploadReq");
                packet.addRequestPacket("Data", strupBuff4);
                packet.setNoResponse();
                return;
            case 10:
                strupbuff strupbuffVar = new strupbuff();
                strupbuffVar.prefix = "";
                ArrayList<String> stringArrayList4 = intent.getExtras().getStringArrayList(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
                ArrayList<String> stringArrayList5 = intent.getExtras().getStringArrayList("contents");
                HashMap hashMap6 = new HashMap();
                int i16 = 0;
                StringBuilder sb6 = null;
                while (i16 < stringArrayList4.size()) {
                    String str4 = stringArrayList4.get(i16);
                    String str5 = stringArrayList5.get(i16);
                    if (QLog.isColorLevel()) {
                        arrayList = stringArrayList4;
                        if (sb6 == null) {
                            arrayList2 = stringArrayList5;
                            sb5 = new StringBuilder("[Capture Report Send:not runtime]:\n");
                        } else {
                            arrayList2 = stringArrayList5;
                            sb5 = sb6;
                        }
                        sb5.append("[");
                        sb5.append(i16);
                        sb5.append("]");
                        sb5.append(" tag = ");
                        sb5.append(str4);
                        sb5.append(", content = ");
                        sb5.append(str5);
                        sb5.append("\n");
                        sb6 = sb5;
                    } else {
                        arrayList = stringArrayList4;
                        arrayList2 = stringArrayList5;
                    }
                    if (ReportController.z(str4)) {
                        str2 = "GBK";
                    } else {
                        str2 = "UTF-8";
                    }
                    try {
                        byte[] bytes2 = str5.getBytes(str2);
                        ArrayList arrayList7 = (ArrayList) hashMap6.get(str4);
                        if (arrayList7 == null) {
                            arrayList7 = new ArrayList();
                            hashMap6.put(str4, arrayList7);
                        }
                        arrayList7.add(bytes2);
                    } catch (UnsupportedEncodingException unused2) {
                    }
                    i16++;
                    stringArrayList4 = arrayList;
                    stringArrayList5 = arrayList2;
                }
                strupbuffVar.logstring = new HashMap(hashMap6);
                strupbuffVar.encoding = (byte) 0;
                strupbuffVar.seqno = intent.getExtras().getInt("seqKey");
                packet.setSSOCommand(BaseConstants.CMD_REPORTSTAT);
                packet.setServantName("QQService.CliLogSvc.MainServantObj");
                packet.setFuncName("UploadReq");
                packet.addRequestPacket("Data", strupbuffVar);
                packet.setTimeout(30000L);
                if (!TextUtils.isEmpty(sb6)) {
                    QLog.d("CaptureReport", 2, sb6.toString());
                    return;
                }
                return;
        }
    }
}
