package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import PushNotifyPack.DisMsgReadedNotify;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ag;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc$PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;
import org.jetbrains.annotations.NotNull;
import tencent.im.conf.sysmsg_0x20c_0x20$Convert2Group;
import tencent.im.conf.sysmsg_0x20c_0x20$MemberNumRemind;
import tencent.im.conf.sysmsg_0x20c_0x20$SysMsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef$MsgInfoUserDef;
import tencent.im.oidb.cmd0x858.oidb_0x858$GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858$MessageRecallReminder;
import tencent.im.oidb.cmd0x858.oidb_0x858$NotifyMsgBody;
import tencent.im.oidb.cmd0x858.oidb_0x858$NotifyObjmsgUpdate;
import tencent.im.oidb.cmd0x858.oidb_0x858$RedGrayTipsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa$MsgBody;

/* loaded from: classes11.dex */
public class DiscMessageProcessor extends com.tencent.imcore.message.e {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    Handler f195841v;

    /* renamed from: w, reason: collision with root package name */
    public final ConcurrentHashMap<String, ArrayList<Pair<String, String>>> f195842w;

    public DiscMessageProcessor(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
        } else {
            this.f195842w = new ConcurrentHashMap<>();
        }
    }

    private void D(byte[] bArr, int i3, List<String> list, int i16, HashSet<String> hashSet) {
        for (int i17 = 0; i17 < i16; i17++) {
            long longData = PkgTools.getLongData(bArr, i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg MSG_DISCUSSION_TYPE_KICKOUT_MEMBER uin=" + longData);
            }
            i3 += 4;
            hashSet.add(String.valueOf(longData));
            list.add(String.valueOf(longData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(StringBuilder sb5, ArrayList<Pair<Long, String>> arrayList, long j3) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = (String) arrayList.get(i3).second;
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 9 server showName empty");
                }
                str = ac.n((QQAppInterface) this.f116342a, String.valueOf(j3), String.valueOf(arrayList.get(i3)));
            }
            if (i3 == 0) {
                sb5.append(str);
            } else {
                sb5.append("\u3001" + str);
            }
        }
    }

    private void F(MsgInfo msgInfo, long j3, long j16, long j17, DiscussionHandler discussionHandler, long j18, String str, HashSet<String> hashSet, String str2, DiscussionHandler discussionHandler2) {
        String string = this.f116342a.getApp().getString(R.string.f170850au3, str2);
        if (hashSet.contains(this.f116342a.getCurrentAccountUin())) {
            if (((int) j18) < 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group\uff0cdwCmdTime=" + j18);
                    return;
                }
                return;
            }
            if (com.tencent.mobileqq.app.n.y()) {
                discussionHandler2.P2(String.valueOf(j17));
            }
            G(msgInfo, j3, j16, j16, HardCodeUtil.qqStr(R.string.lne));
            return;
        }
        String str3 = str + HardCodeUtil.qqStr(R.string.lnd) + string;
        discussionHandler2.Q2(String.valueOf(j17), hashSet);
        discussionHandler.S2(j17);
        G(msgInfo, j3, j16, j16, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MsgInfo msgInfo, long j3, long j16, long j17, String str) {
        MessageRecord d16 = q.d(-1004);
        d16.init(j3, j16, j16, str, msgInfo.uRealMsgTime, -1004, 3000, msgInfo.uMsgTime);
        d16.isread = true;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + j16 + " msgType: -1004 friendType: 3000 shMsgSeq: " + ((int) msgInfo.shMsgSeq) + " msgContent: " + aw.a(str));
        }
        if (!MessageHandlerUtils.msgFilter(this.f116342a, d16, false)) {
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).addMessage(d16, String.valueOf(j3));
        }
    }

    private String H(MsgInfo msgInfo) {
        ArrayList<String> arrayList = msgInfo.vNickName;
        if (arrayList != null && arrayList.size() > 0) {
            return msgInfo.vNickName.get(0);
        }
        return "";
    }

    private String I(long j3, String str, byte b16, long j16, long j17, String str2, StringBuffer stringBuffer, String str3) {
        boolean z16;
        String str4;
        if (b16 == 22) {
            if (j16 == 0) {
                return this.f116342a.getApp().getString(R.string.au7);
            }
            if (j16 == 1) {
                return this.f116342a.getApp().getString(R.string.au8);
            }
            if (j16 == 2) {
                return this.f116342a.getApp().getString(R.string.b3f, stringBuffer.toString());
            }
            return str3;
        }
        if (j17 == j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                str4 = this.f116342a.getApp().getString(R.string.ath);
            } else {
                str4 = "";
            }
        } else {
            if (TextUtils.isEmpty(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server invitorName empty cOpType:" + ((int) b16));
                }
                str2 = ac.n((QQAppInterface) this.f116342a, str, String.valueOf(j17));
            }
            if (ac.p0((QQAppInterface) this.f116342a, str)) {
                str2 = ac.n((QQAppInterface) this.f116342a, str, String.valueOf(j17));
            }
            str4 = str2 + this.f116342a.getApp().getString(R.string.atg);
        }
        return str4 + this.f116342a.getApp().getString(R.string.f170847au0, stringBuffer.toString());
    }

    private String J(long j3, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
            }
            return ac.n((QQAppInterface) this.f116342a, String.valueOf(j3), str);
        }
        return str2;
    }

    private String K(long j3, HashSet<String> hashSet, StringBuffer stringBuffer, String str) {
        if (hashSet.size() > 0) {
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                stringBuffer.append(ac.n((QQAppInterface) this.f116342a, String.valueOf(j3), it.next()));
                stringBuffer.append("\u3001");
            }
        }
        if (stringBuffer.length() > 0) {
            return stringBuffer.deleteCharAt(stringBuffer.toString().length() - 1).toString();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void L(MsgInfo msgInfo, long j3, byte[] bArr, long j16, int i3, byte b16, long j17, long j18, List<String> list, DiscussionHandler discussionHandler, boolean z16, long j19, long j26, Pair<Long, String> pair) {
        int i16;
        int i17;
        ArrayList<String> arrayList;
        short shortData = PkgTools.getShortData(bArr, i3);
        int i18 = i3 + 2;
        Pair pair2 = new Pair(Long.valueOf(j26), (!z16 || (arrayList = msgInfo.vNickName) == null || arrayList.size() < 2) ? "" : msgInfo.vNickName.get(1));
        DiscussionHandler.c cVar = new DiscussionHandler.c();
        cVar.f194620c = shortData;
        cVar.f194618a = String.valueOf(j18);
        discussionHandler.T2(cVar);
        ArrayList arrayList2 = new ArrayList();
        int i19 = (z16 ? 1 : 0) + 1;
        for (int i26 = 0; i26 < shortData; i26++) {
            String valueOf = String.valueOf(PkgTools.getLongData(bArr, i18));
            ArrayList<String> arrayList3 = msgInfo.vNickName;
            arrayList2.add(new Pair(valueOf, (arrayList3 == null || arrayList3.size() < shortData + i19) ? "" : msgInfo.vNickName.get(i26 + i19)));
            list.add(valueOf);
            i18 += 4;
        }
        if (j19 == 0) {
            i17 = 10007;
        } else if (j19 == 1) {
            i17 = 10006;
        } else {
            if (j19 != 2) {
                i16 = 0;
                discussionHandler.f4(j18, String.valueOf(j17), list, i16);
                if (this.f195841v == null) {
                    this.f195841v = new Handler(ThreadManagerV2.getSubThreadLooper());
                }
                this.f195841v.postDelayed(new Runnable(j17, j3, pair, msgInfo, j18, j16, b16, j19, pair2, arrayList2) { // from class: com.tencent.mobileqq.app.message.DiscMessageProcessor.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ byte C;
                    final /* synthetic */ long D;
                    final /* synthetic */ Pair E;
                    final /* synthetic */ ArrayList F;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f195843d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ long f195844e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Pair f195845f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ MsgInfo f195846h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ long f195847i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ long f195848m;

                    {
                        this.f195843d = j17;
                        this.f195844e = j3;
                        this.f195845f = pair;
                        this.f195846h = msgInfo;
                        this.f195847i = j18;
                        this.f195848m = j16;
                        this.C = b16;
                        this.D = j19;
                        this.E = pair2;
                        this.F = arrayList2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, DiscMessageProcessor.this, Long.valueOf(j17), Long.valueOf(j3), pair, msgInfo, Long.valueOf(j18), Long.valueOf(j16), Byte.valueOf(b16), Long.valueOf(j19), pair2, arrayList2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        long j27 = this.f195843d;
                        long j28 = this.f195844e;
                        if (j27 != j28) {
                            DiscMessageProcessor.this.f0(this.f195845f, this.f195846h, j28, this.f195847i, this.f195848m, this.C, this.D, this.E);
                        } else {
                            DiscMessageProcessor.this.g0(this.f195845f, this.f195846h, this.F, j28, String.valueOf(this.f195847i), this.C, this.D, false);
                        }
                    }
                }, 2000L);
            }
            i17 = 10008;
        }
        i16 = i17;
        discussionHandler.f4(j18, String.valueOf(j17), list, i16);
        if (this.f195841v == null) {
        }
        this.f195841v.postDelayed(new Runnable(j17, j3, pair, msgInfo, j18, j16, b16, j19, pair2, arrayList2) { // from class: com.tencent.mobileqq.app.message.DiscMessageProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ byte C;
            final /* synthetic */ long D;
            final /* synthetic */ Pair E;
            final /* synthetic */ ArrayList F;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f195843d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f195844e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Pair f195845f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ MsgInfo f195846h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f195847i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ long f195848m;

            {
                this.f195843d = j17;
                this.f195844e = j3;
                this.f195845f = pair;
                this.f195846h = msgInfo;
                this.f195847i = j18;
                this.f195848m = j16;
                this.C = b16;
                this.D = j19;
                this.E = pair2;
                this.F = arrayList2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DiscMessageProcessor.this, Long.valueOf(j17), Long.valueOf(j3), pair, msgInfo, Long.valueOf(j18), Long.valueOf(j16), Byte.valueOf(b16), Long.valueOf(j19), pair2, arrayList2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long j27 = this.f195843d;
                long j28 = this.f195844e;
                if (j27 != j28) {
                    DiscMessageProcessor.this.f0(this.f195845f, this.f195846h, j28, this.f195847i, this.f195848m, this.C, this.D, this.E);
                } else {
                    DiscMessageProcessor.this.g0(this.f195845f, this.f195846h, this.F, j28, String.valueOf(this.f195847i), this.C, this.D, false);
                }
            }
        }, 2000L);
    }

    private void M(MsgInfo msgInfo, long j3, byte[] bArr, long j16, int i3, long j17, List<String> list) {
        long j18;
        long longData = PkgTools.getLongData(bArr, i3);
        int i16 = i3 + 4;
        long longData2 = PkgTools.getLongData(bArr, i16);
        int i17 = i16 + 4;
        int unsignedByte = PkgTools.getUnsignedByte(bArr[i17]);
        int i18 = i17 + 1;
        PkgTools.getUTFString(bArr, i18, unsignedByte);
        int i19 = i18 + unsignedByte;
        short shortData = PkgTools.getShortData(bArr, i19);
        int i26 = i19 + 2;
        HashSet<String> hashSet = new HashSet<>();
        for (int i27 = 0; i27 < shortData; i27++) {
            long longData3 = PkgTools.getLongData(bArr, i26);
            i26 += 4;
            hashSet.add(String.valueOf(longData3));
            list.add(String.valueOf(longData3));
        }
        if (hashSet.size() > 0) {
            DiscussionHandler discussionHandler = (DiscussionHandler) this.f116342a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
            String valueOf = String.valueOf(j17);
            if (hashSet.contains(this.f116342a.getCurrentAccountUin())) {
                if (((int) longData2) < 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group\uff0cdwCmdTime=" + longData2);
                    }
                } else {
                    if (com.tencent.mobileqq.app.n.y()) {
                        discussionHandler.P2(valueOf);
                    }
                    G(msgInfo, j3, j16, j16, HardCodeUtil.qqStr(R.string.lnf));
                }
            } else {
                discussionHandler.Q2(valueOf, hashSet);
                if (Long.getLong(valueOf) != null) {
                    j18 = Long.getLong(valueOf).longValue();
                } else {
                    j18 = 0;
                }
                discussionHandler.S2(j18);
            }
            discussionHandler.f4(j17, String.valueOf(longData), list, 10005);
        }
    }

    private void N(MsgInfo msgInfo, long j3, byte[] bArr, long j16, int i3, byte b16, long j17, List<String> list, DiscussionHandler discussionHandler) {
        boolean z16;
        String str;
        DiscMessageProcessor discMessageProcessor;
        long longData = PkgTools.getLongData(bArr, i3);
        int i16 = i3 + 4;
        PkgTools.getLongData(bArr, i16);
        int i17 = i16 + 4;
        long longData2 = PkgTools.getLongData(bArr, i17);
        int i18 = i17 + 4;
        long longData3 = PkgTools.getLongData(bArr, i18);
        int i19 = i18 + 4 + 4;
        if (longData3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<String> arrayList = msgInfo.vNickName;
        if (arrayList != null && arrayList.size() >= 1) {
            str = msgInfo.vNickName.get(0);
        } else {
            str = "";
        }
        Pair<Long, String> pair = new Pair<>(Long.valueOf(longData), str);
        int i26 = (int) longData2;
        if (i26 != 0 && i26 != 1 && i26 != 2) {
            discMessageProcessor = this;
        } else {
            discMessageProcessor = this;
            discMessageProcessor.L(msgInfo, j3, bArr, j16, i19, b16, longData, j17, list, discussionHandler, z16, longData2, longData3, pair);
        }
        RecentUserProxy m3 = ((QQAppInterface) discMessageProcessor.f116342a).getProxyManager().m();
        if (m3.findRecentUser(Long.toString(j17), 3000) != null) {
            return;
        }
        RecentUser findRecentUserByUin = m3.findRecentUserByUin(Long.toString(j17), 3000);
        findRecentUserByUin.uin = Long.toString(j17);
        findRecentUserByUin.lastmsgtime = msgInfo.uRealMsgTime;
        findRecentUserByUin.setType(3000);
        m3.saveRecentUser(findRecentUserByUin);
    }

    private void O(MsgInfo msgInfo, long j3, byte[] bArr, long j16, int i3, long j17) {
        String str;
        if (PkgTools.getShortData(bArr, i3) != 0) {
            int i16 = i3 + 2;
            short shortData = PkgTools.getShortData(bArr, i16);
            int i17 = i16 + 2;
            ArrayList arrayList = new ArrayList();
            for (int i18 = 0; i18 < shortData; i18++) {
                long longData = PkgTools.getLongData(bArr, i17);
                ArrayList<String> arrayList2 = msgInfo.vNickName;
                if (arrayList2 != null && arrayList2.size() >= shortData) {
                    str = msgInfo.vNickName.get(i18);
                } else {
                    str = "";
                }
                arrayList.add(new Pair(Long.valueOf(longData), str));
                i17 += 4;
            }
            int shortData2 = PkgTools.getShortData(bArr, i17);
            byte[] bArr2 = new byte[shortData2];
            PkgTools.getBytesData(bArr, i17 + 2, bArr2, shortData2);
            String str2 = new String(bArr2);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +uinList.size()=" + arrayList.size());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +\u904d\u5386uin uin=" + pair.first);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +sTips=" + str2 + "+lUin=" + j3);
            }
            if (this.f195841v == null) {
                this.f195841v = new Handler(ThreadManagerV2.getSubThreadLooper());
            }
            this.f195841v.postDelayed(new Runnable(arrayList, j3, j17, str2, msgInfo, j16) { // from class: com.tencent.mobileqq.app.message.DiscMessageProcessor.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f195849d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f195850e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f195851f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f195852h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ MsgInfo f195853i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ long f195854m;

                {
                    this.f195849d = arrayList;
                    this.f195850e = j3;
                    this.f195851f = j17;
                    this.f195852h = str2;
                    this.f195853i = msgInfo;
                    this.f195854m = j16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, DiscMessageProcessor.this, arrayList, Long.valueOf(j3), Long.valueOf(j17), str2, msgInfo, Long.valueOf(j16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f195849d.contains(Long.valueOf(this.f195850e))) {
                        this.f195849d.remove(Long.valueOf(this.f195850e));
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "\u964c\u751f\u4ebauin\u5305\u62ec\u81ea\u5df1,\u79fb\u51fa");
                        }
                    }
                    if (this.f195849d.size() != 0) {
                        StringBuilder sb5 = new StringBuilder(this.f195849d.size() * 8);
                        DiscMessageProcessor.this.E(sb5, this.f195849d, this.f195851f);
                        sb5.append(this.f195852h);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "show yinsi tips" + sb5.toString());
                        }
                        DiscMessageProcessor.this.G(this.f195853i, this.f195850e, this.f195851f, this.f195854m, sb5.toString());
                    }
                }
            }, 2000L);
        }
    }

    @NotNull
    private MessageRecord P(byte[] bArr, long j3, int i3) {
        int length = bArr.length - i3;
        byte[] bArr2 = new byte[length];
        PkgTools.getBytesData(bArr, i3, bArr2, length);
        oidb_0x858$NotifyMsgBody oidb_0x858_notifymsgbody = new oidb_0x858$NotifyMsgBody();
        MessageForQQWalletTips messageForQQWalletTips = (MessageForQQWalletTips) q.d(MessageRecord.MSG_TYPE_QQWALLET_TIPS);
        try {
            oidb_0x858_notifymsgbody.mergeFrom(bArr2);
            oidb_0x858$RedGrayTipsInfo oidb_0x858_redgraytipsinfo = oidb_0x858_notifymsgbody.opt_msg_redtips.get();
            messageForQQWalletTips.senderUin = oidb_0x858_redgraytipsinfo.uint64_sender_uin.get() + "";
            messageForQQWalletTips.reciverUin = oidb_0x858_redgraytipsinfo.uint64_receiver_uin.get() + "";
            messageForQQWalletTips.senderContent = oidb_0x858_redgraytipsinfo.bytes_sender_rich_content.get().toStringUtf8();
            messageForQQWalletTips.reciverContent = oidb_0x858_redgraytipsinfo.bytes_receiver_rich_content.get().toStringUtf8();
            messageForQQWalletTips.authKey = oidb_0x858_redgraytipsinfo.bytes_authkey.get().toStringUtf8();
            messageForQQWalletTips.idiomSeq = oidb_0x858_redgraytipsinfo.uint32_idiom_seq.get();
            messageForQQWalletTips.idiom = oidb_0x858_redgraytipsinfo.bytes_idiom.get().toStringUtf8();
            messageForQQWalletTips.msgType = oidb_0x858_redgraytipsinfo.sint32_msgtype.get();
            messageForQQWalletTips.richContent = oidb_0x858_redgraytipsinfo.bytes_broadcast_rich_content.get().toStringUtf8();
            messageForQQWalletTips.lastPinyin = oidb_0x858_redgraytipsinfo.bytes_idiom_alpha.get().toStringUtf8();
            messageForQQWalletTips.bytes_jumpurl = oidb_0x858_redgraytipsinfo.bytes_jumpurl.get().toStringUtf8();
            messageForQQWalletTips.subChannel = oidb_0x858_redgraytipsinfo.uint32_subchannel.get();
            try {
                messageForQQWalletTips.init(this.f116342a.getCurrentAccountUin(), j3 + "", "", "[QQWallet Tips]", com.tencent.mobileqq.service.message.e.K0(), MessageRecord.MSG_TYPE_QQWALLET_TIPS, 3000, com.tencent.mobileqq.service.message.e.K0());
                messageForQQWalletTips.isread = true;
                messageForQQWalletTips.getBytes();
                messageForQQWalletTips.onReceiveGrapTips();
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                return messageForQQWalletTips;
            }
        } catch (Exception e17) {
            e = e17;
        }
        return messageForQQWalletTips;
    }

    private boolean Q(MsgInfo msgInfo, long j3, byte[] bArr, long j16, int i3, byte b16, long j17, List<String> list, DiscussionHandler discussionHandler, com.tencent.mobileqq.app.n nVar) {
        long longData = PkgTools.getLongData(bArr, i3);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + j17 + " memberUin: " + longData);
        }
        String valueOf = String.valueOf(longData);
        if (X(longData, j17, msgInfo.shMsgSeq)) {
            return true;
        }
        String H = H(msgInfo);
        if (TextUtils.isEmpty(H) || ac.p0((QQAppInterface) this.f116342a, String.valueOf(j17))) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
            }
            H = ac.n((QQAppInterface) this.f116342a, String.valueOf(j17), valueOf);
        }
        String string = this.f116342a.getApp().getString(R.string.au6, H);
        list.add(valueOf);
        discussionHandler.f4(j17, valueOf, list, 10009);
        if (valueOf.equals(this.f116342a.getCurrentAccountUin())) {
            nVar.e(String.valueOf(j17), String.valueOf(longData));
            e0(b16, j17, longData);
            if (com.tencent.mobileqq.app.n.y()) {
                discussionHandler.P2(String.valueOf(j17));
            }
            return true;
        }
        discussionHandler.S2(j17);
        nVar.e(String.valueOf(j17), String.valueOf(longData));
        G(msgInfo, j3, j16, j16, string);
        return false;
    }

    private void R(MsgInfo msgInfo, long j3, byte[] bArr, int i3, byte b16, long j16, DiscussionHandler discussionHandler, com.tencent.mobileqq.app.n nVar) {
        String str;
        String string;
        long longData = PkgTools.getLongData(bArr, i3);
        int i16 = i3 + 4;
        long longData2 = PkgTools.getLongData(bArr, i16);
        int i17 = i16 + 4;
        PkgTools.getLongData(bArr, i17);
        int i18 = i17 + 4;
        int shortData = PkgTools.getShortData(bArr, i18);
        byte[] bArr2 = new byte[shortData];
        PkgTools.getBytesData(bArr, i18 + 2, bArr2, shortData);
        String str2 = new String(bArr2);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:" + ((int) b16) + "dwCmdUin =" + longData + " dwCmdTime=" + longData2 + " strName=" + str2);
        }
        if (longData == j3) {
            string = this.f116342a.getApp().getString(R.string.ask, str2);
        } else {
            DiscussionInfo h16 = nVar.h(String.valueOf(j16));
            if (h16 != null && h16.isDiscussHrMeeting()) {
                str = QAVHrMeeting.g(nVar, h16.uin, String.valueOf(longData));
            } else {
                ArrayList<String> arrayList = msgInfo.vNickName;
                if (arrayList != null && arrayList.size() > 0) {
                    str = msgInfo.vNickName.get(0);
                } else {
                    str = "";
                }
            }
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 6 server opeaterName empty");
                }
                str = ac.n((QQAppInterface) this.f116342a, String.valueOf(j16), String.valueOf(longData));
            }
            string = this.f116342a.getApp().getString(R.string.asl, str, str2);
        }
        String str3 = string;
        discussionHandler.i3(String.valueOf(j16), str2);
        G(msgInfo, j3, j16, longData, str3);
    }

    private void S(MsgInfo msgInfo, long j3, byte[] bArr, int i3, byte b16, long j16, List<String> list, DiscussionHandler discussionHandler) {
        ArrayList<String> vNickName = msgInfo.getVNickName();
        long longData = PkgTools.getLongData(bArr, i3);
        int i16 = i3 + 8;
        short shortData = PkgTools.getShortData(bArr, i16);
        int i17 = i16 + 2;
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        for (short s16 = 1; s16 < shortData + 1; s16 = (short) (s16 + 1)) {
            String str = vNickName.get(s16);
            long longData2 = PkgTools.getLongData(bArr, i17);
            i17 += 4;
            list.add(String.valueOf(longData2));
            arrayList.add(new Pair<>(String.valueOf(longData2), str));
        }
        DiscussionHandler.c cVar = new DiscussionHandler.c();
        cVar.f194620c = vNickName.size();
        cVar.f194618a = String.valueOf(j16);
        discussionHandler.T2(cVar);
        discussionHandler.f4(j16, String.valueOf(longData), list, 10004);
        Pair<Long, String> pair = new Pair<>(Long.valueOf(longData), vNickName.get(0));
        RecentUserProxy m3 = ((QQAppInterface) this.f116342a).getProxyManager().m();
        if (m3.findRecentUser(Long.toString(j16), 3000) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru alreadyintab");
            }
            if (ac.p0((QQAppInterface) this.f116342a, String.valueOf(j16))) {
                i0(pair, msgInfo, arrayList, j3, String.valueOf(j16), b16, false);
                return;
            } else {
                h0(pair, msgInfo, arrayList, j3, String.valueOf(j16), b16, false);
                return;
            }
        }
        RecentUser findRecentUserByUin = m3.findRecentUserByUin(Long.toString(j16), 3000);
        RecentUtil.K0(findRecentUserByUin, ((QQAppInterface) this.f116342a).getMessageFacade());
        findRecentUserByUin.uin = Long.toString(j16);
        findRecentUserByUin.lastmsgtime = msgInfo.uRealMsgTime;
        findRecentUserByUin.setType(3000);
        m3.saveRecentUser(findRecentUserByUin);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru.lastmsgtime " + msgInfo.uRealMsgTime);
        }
        String currentAccountUin = this.f116342a.getCurrentAccountUin();
        if (((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg()) {
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).setSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg(false);
            h0(pair, msgInfo, arrayList, j3, String.valueOf(j16), b16, true);
        } else if (TextUtils.equals(currentAccountUin, String.valueOf(longData))) {
            j0(vNickName, findRecentUserByUin.uin, currentAccountUin, currentAccountUin);
            ReportController.o(this.f116342a, "CliOper", "", "", "Multi_call", "Show_discuss_tips", 0, 0, "", "", "", "");
        } else {
            h0(pair, msgInfo, arrayList, j3, String.valueOf(j16), b16, true);
        }
    }

    private void T(byte[] bArr, int i3, long j3, com.tencent.mobileqq.app.n nVar) {
        int longData = (int) PkgTools.getLongData(bArr, i3);
        byte[] bArr2 = new byte[longData];
        PkgTools.getBytesData(bArr, i3 + 4, bArr2, longData);
        sysmsg_0x20c_0x20$SysMsgBody sysmsg_0x20c_0x20_sysmsgbody = new sysmsg_0x20c_0x20$SysMsgBody();
        try {
            sysmsg_0x20c_0x20_sysmsgbody.mergeFrom(bArr2);
            if (sysmsg_0x20c_0x20_sysmsgbody.u32_cmd.has()) {
                U(j3, nVar, sysmsg_0x20c_0x20_sysmsgbody, sysmsg_0x20c_0x20_sysmsgbody.u32_cmd.get());
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc", 2, "0x20: Parsing data failed!");
            }
        }
    }

    private void U(long j3, com.tencent.mobileqq.app.n nVar, sysmsg_0x20c_0x20$SysMsgBody sysmsg_0x20c_0x20_sysmsgbody, int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4 && sysmsg_0x20c_0x20_sysmsgbody.msg_upload_file_remind.has()) {
                    long j16 = sysmsg_0x20c_0x20_sysmsgbody.msg_upload_file_remind.get().u64_discuss_code.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=4): Discussion %d gets a file uploaded.", Long.valueOf(j16)));
                        return;
                    }
                    return;
                }
                return;
            }
            if (sysmsg_0x20c_0x20_sysmsgbody.msg_mem_num_remind.has()) {
                sysmsg_0x20c_0x20$MemberNumRemind sysmsg_0x20c_0x20_membernumremind = sysmsg_0x20c_0x20_sysmsgbody.msg_mem_num_remind.get();
                int i16 = sysmsg_0x20c_0x20_membernumremind.u32_mem_num.get();
                long j17 = sysmsg_0x20c_0x20_membernumremind.u64_discuss_code.get();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=3): Discussion %d remains %d members.", Long.valueOf(j17), Integer.valueOf(i16)));
                    return;
                }
                return;
            }
            return;
        }
        if (sysmsg_0x20c_0x20_sysmsgbody.msg_convert_to_group.has()) {
            sysmsg_0x20c_0x20$Convert2Group sysmsg_0x20c_0x20_convert2group = sysmsg_0x20c_0x20_sysmsgbody.msg_convert_to_group.get();
            String valueOf = String.valueOf(sysmsg_0x20c_0x20_convert2group.u64_operator.get());
            String valueOf2 = String.valueOf(sysmsg_0x20c_0x20_convert2group.u64_group_code.get());
            String valueOf3 = String.valueOf(sysmsg_0x20c_0x20_convert2group.u64_discuss_code.get());
            Map<String, String[]> map = nVar.C;
            if (map != null) {
                map.put(valueOf3, new String[]{valueOf2, valueOf});
                nVar.D.add(valueOf2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=2): Discussion %s is converted to group %s by user %s.", valueOf3, valueOf2, valueOf));
            }
            if (com.tencent.mobileqq.app.n.y()) {
                ((DiscussionHandler) this.f116342a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).P2(String.valueOf(j3));
            }
            ((com.tencent.mobileqq.troop.api.handler.h) this.f116342a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(com.tencent.mobileqq.troop.api.observer.b.D, true, new Object[]{Integer.valueOf(R.string.dre), valueOf3, valueOf2, Boolean.valueOf(this.f116342a.getCurrentUin().equals(valueOf))});
        }
    }

    private void V(byte[] bArr, int i3) {
        PkgTools.getLongData(bArr, i3);
        int i16 = i3 + 4;
        PkgTools.getLongData(bArr, i16);
        byte b16 = bArr[i16 + 4];
    }

    private MessageRecord W(MsgInfo msgInfo, long j3) {
        MessageRecord messageRecord;
        byte[] bArr = msgInfo.vMsg;
        long j16 = msgInfo.lFromUin;
        long longData = PkgTools.getLongData(bArr, 0);
        byte b16 = bArr[4];
        ArrayList arrayList = new ArrayList();
        AppInterface appInterface = this.f116342a;
        String str = BusinessHandlerFactory.DISCUSSION_HANDLER;
        DiscussionHandler discussionHandler = (DiscussionHandler) appInterface.getBusinessHandler(str);
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) this.f116342a.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg cOpType: " + ((int) b16) + ", dwConfUin=" + longData);
        }
        if (b16 != 2) {
            if (b16 != 3) {
                if (b16 != 6) {
                    if (b16 != 7) {
                        if (b16 != 9) {
                            if (b16 != 10) {
                                if (b16 != 15) {
                                    if (b16 != 22) {
                                        if (b16 != 32) {
                                            if (b16 != 24) {
                                                if (b16 != 25) {
                                                    if (b16 != 34) {
                                                        if (b16 == 35) {
                                                            b0((QQAppInterface) this.f116342a, bArr, 5, null, true);
                                                        }
                                                    } else {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("GameParty", 2, "recv 0x20c_0x22 online push");
                                                        }
                                                        a0((QQAppInterface) this.f116342a, bArr, 5, null, true);
                                                    }
                                                } else {
                                                    Z((QQAppInterface) this.f116342a, bArr, 5, null, true);
                                                }
                                                messageRecord = null;
                                            } else {
                                                return P(bArr, j16, 5);
                                            }
                                        } else {
                                            messageRecord = null;
                                            T(bArr, 5, longData, nVar);
                                        }
                                    } else {
                                        messageRecord = null;
                                        N(msgInfo, j3, bArr, j16, 5, b16, longData, arrayList, discussionHandler);
                                    }
                                } else {
                                    messageRecord = null;
                                    V(bArr, 5);
                                }
                            } else {
                                messageRecord = null;
                                M(msgInfo, j3, bArr, j16, 5, longData, arrayList);
                            }
                        } else {
                            messageRecord = null;
                            O(msgInfo, j3, bArr, j16, 5, longData);
                        }
                    } else {
                        messageRecord = null;
                        long longData2 = PkgTools.getLongData(bArr, 5);
                        long longData3 = PkgTools.getLongData(bArr, 9);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + longData + " memberUin: " + longData2);
                        }
                        String valueOf = String.valueOf(longData2);
                        if (X(longData2, longData, msgInfo.shMsgSeq)) {
                            return null;
                        }
                        if (!valueOf.equals(this.f116342a.getCurrentAccountUin())) {
                            String J = J(longData, valueOf, H(msgInfo));
                            short shortData = PkgTools.getShortData(bArr, 13);
                            HashSet<String> hashSet = new HashSet<>();
                            D(bArr, 15, arrayList, shortData, hashSet);
                            String K = K(longData, hashSet, new StringBuffer(), "");
                            DiscussionHandler discussionHandler2 = (DiscussionHandler) this.f116342a.getBusinessHandler(str);
                            discussionHandler2.f4(longData, valueOf, arrayList, 10005);
                            F(msgInfo, j3, j16, longData, discussionHandler, longData3, J, hashSet, K, discussionHandler2);
                        }
                    }
                } else {
                    messageRecord = null;
                    R(msgInfo, j3, bArr, 5, b16, longData, discussionHandler, nVar);
                }
            } else {
                messageRecord = null;
                S(msgInfo, j3, bArr, 5, b16, longData, arrayList, discussionHandler);
            }
        } else {
            messageRecord = null;
            if (Q(msgInfo, j3, bArr, j16, 5, b16, longData, arrayList, discussionHandler, nVar)) {
                return null;
            }
        }
        return messageRecord;
    }

    private synchronized boolean X(long j3, long j16, short s16) {
        String str = j3 + "|" + j16 + "|" + ((int) s16);
        if (((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).J0().contains(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.DiscMsgPc", 2, "memberChangeMsgFilter key: " + str);
            }
            return true;
        }
        ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).y(str);
        return false;
    }

    public static void Z(QQAppInterface qQAppInterface, byte[] bArr, int i3, MessageRecord messageRecord, boolean z16) {
        String str = "revokeMsg";
        int length = bArr.length - i3;
        byte[] bArr2 = new byte[length];
        PkgTools.getBytesData(bArr, i3, bArr2, length);
        oidb_0x858$NotifyMsgBody oidb_0x858_notifymsgbody = new oidb_0x858$NotifyMsgBody();
        try {
            oidb_0x858_notifymsgbody.mergeFrom(bArr2);
            int i16 = oidb_0x858_notifymsgbody.opt_enum_type.get();
            long j3 = oidb_0x858_notifymsgbody.opt_uint64_conf_uin.get();
            if (i16 == 7 && oidb_0x858_notifymsgbody.opt_msg_recall_reminder.has()) {
                oidb_0x858$MessageRecallReminder oidb_0x858_messagerecallreminder = oidb_0x858_notifymsgbody.opt_msg_recall_reminder.get();
                long j16 = oidb_0x858_messagerecallreminder.uint64_uin.get();
                long j17 = oidb_0x858_messagerecallreminder.uint64_admin_uin.get();
                HashMap hashMap = new HashMap();
                try {
                    msgrevoke_userdef$MsgInfoUserDef msgrevoke_userdef_msginfouserdef = new msgrevoke_userdef$MsgInfoUserDef();
                    msgrevoke_userdef_msginfouserdef.mergeFrom(oidb_0x858_messagerecallreminder.bytes_userdef.get().toByteArray());
                    int i17 = msgrevoke_userdef_msginfouserdef.uint32_long_message_flag.get();
                    if (i17 == 1) {
                        Iterator it = ((ArrayList) msgrevoke_userdef_msginfouserdef.long_msg_info.get()).iterator();
                        while (it.hasNext()) {
                            msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef msgInfoDef = (msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef) it.next();
                            hashMap.put(Integer.valueOf(msgInfoDef.uint32_msg_seq.get()), msgInfoDef);
                        }
                    }
                    ArrayList<RevokeMsgInfo> arrayList = new ArrayList<>();
                    Iterator it5 = ((ArrayList) oidb_0x858_messagerecallreminder.uint32_recalled_msg_list.get()).iterator();
                    while (it5.hasNext()) {
                        oidb_0x858$MessageRecallReminder.MessageMeta messageMeta = (oidb_0x858$MessageRecallReminder.MessageMeta) it5.next();
                        RevokeMsgInfo revokeMsgInfo = new RevokeMsgInfo();
                        revokeMsgInfo.f281289h = String.valueOf(j16);
                        revokeMsgInfo.f281290i = String.valueOf(j17);
                        revokeMsgInfo.f281288f = String.valueOf(j3);
                        revokeMsgInfo.f281286d = 3000;
                        String str2 = str;
                        revokeMsgInfo.f281287e = messageMeta.uint32_seq.get();
                        revokeMsgInfo.C = messageMeta.uint32_time.get();
                        revokeMsgInfo.J = messageMeta.uint32_is_anony_msg.get();
                        if (i17 == 1) {
                            msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef msgInfoDef2 = (msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef) hashMap.get(Integer.valueOf(messageMeta.uint32_seq.get()));
                            revokeMsgInfo.E = msgInfoDef2.long_msg_id.get();
                            revokeMsgInfo.F = msgInfoDef2.long_msg_num.get();
                            revokeMsgInfo.G = msgInfoDef2.long_msg_index.get();
                        }
                        arrayList.add(revokeMsgInfo);
                        if (QLog.isColorLevel()) {
                            str = str2;
                            QLog.d(str, 2, "recv 0x20c_0x19 msg," + revokeMsgInfo.toString());
                        } else {
                            str = str2;
                        }
                    }
                    ((IMessageFacade) qQAppInterface.getRuntimeService(IMessageFacade.class, "")).handleRevokedNotifyAndNotify(arrayList, false);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg, parse msgInfoUserDef error");
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x19 Exception " + e16.getStackTrace());
            }
        }
    }

    public static void a0(QQAppInterface qQAppInterface, byte[] bArr, int i3, MessageRecord messageRecord, boolean z16) {
        int length = bArr.length - i3;
        byte[] bArr2 = new byte[length];
        PkgTools.getBytesData(bArr, i3, bArr2, length);
        oidb_0x858$NotifyMsgBody oidb_0x858_notifymsgbody = new oidb_0x858$NotifyMsgBody();
        try {
            oidb_0x858_notifymsgbody.mergeFrom(bArr2);
            int i16 = oidb_0x858_notifymsgbody.opt_enum_type.get();
            oidb_0x858_notifymsgbody.opt_uint64_conf_uin.get();
            if (i16 == 9 && oidb_0x858_notifymsgbody.opt_msg_obj_update.has()) {
                oidb_0x858$NotifyObjmsgUpdate oidb_0x858_notifyobjmsgupdate = oidb_0x858_notifymsgbody.opt_msg_obj_update.get();
                if (oidb_0x858_notifyobjmsgupdate.bytes_ext_msg.has()) {
                    try {
                        new SubMsgType0xaa$MsgBody().mergeFrom(oidb_0x858_notifyobjmsgupdate.bytes_ext_msg.get().toByteArray());
                    } catch (Exception unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("GameParty", 2, "recv 0x858_notifyobjmsgupdate, prase msgBody error");
                        }
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x22 Exception " + e16.getStackTrace());
            }
        }
    }

    public static void b0(QQAppInterface qQAppInterface, byte[] bArr, int i3, MessageRecord messageRecord, boolean z16) {
        int length = bArr.length - i3;
        byte[] bArr2 = new byte[length];
        PkgTools.getBytesData(bArr, i3, bArr2, length);
        oidb_0x858$NotifyMsgBody oidb_0x858_notifymsgbody = new oidb_0x858$NotifyMsgBody();
        try {
            oidb_0x858_notifymsgbody.mergeFrom(bArr2);
            int i16 = oidb_0x858_notifymsgbody.opt_enum_type.get();
            oidb_0x858_notifymsgbody.opt_uint64_conf_uin.get();
            if (i16 == 11) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc", 2, "apollo game status push, [Discussion].");
                    return;
                }
                return;
            }
            if (i16 == 12) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc", 2, "recv action push message, [Discussion].");
                }
            } else if (i16 == 13) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.DiscMsgPc", 2, "goldmsg push, [Discussion].");
                }
                if (oidb_0x858_notifymsgbody.opt_msg_goldtips.has()) {
                    oidb_0x858$GoldMsgTipsElem oidb_0x858_goldmsgtipselem = oidb_0x858_notifymsgbody.opt_msg_goldtips.get();
                    if (oidb_0x858_goldmsgtipselem.type.has() && oidb_0x858_goldmsgtipselem.type.get() == 3) {
                        ((INotifyMsgApi) QRoute.api(INotifyMsgApi.class)).onReceiveAAPaySysNotify(3000, null, oidb_0x858_notifymsgbody.opt_msg_goldtips.get());
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("Q.msg.DiscMsgPc", 1, "parse0x20c_subType0x23 Exception " + e16.getStackTrace());
        }
    }

    private MessageRecord c0(MsgInfo msgInfo, SvcReqPushMsg svcReqPushMsg) {
        MessageRecord W = W(msgInfo, svcReqPushMsg.lUin);
        if (W != null && !MessageHandlerUtils.msgFilter(this.f116342a, W, true)) {
            return W;
        }
        return null;
    }

    private void e0(byte b16, long j3, long j16) {
        MqqHandler handler;
        if (j16 == Long.valueOf(this.f116342a.getCurrentAccountUin()).longValue() && b16 == 2 && (handler = this.f116342a.getHandler(AVNotifyCenter.class)) != null) {
            Message obtainMessage = handler.obtainMessage(10003);
            obtainMessage.obj = Long.valueOf(j3);
            handler.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(Pair<Long, String> pair, MsgInfo msgInfo, long j3, long j16, long j17, byte b16, long j18, Pair<Long, String> pair2) {
        String string;
        long longValue = ((Long) pair.first).longValue();
        long longValue2 = ((Long) pair2.first).longValue();
        String str = (String) pair.second;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server showName empty");
            }
            str = ac.n((QQAppInterface) this.f116342a, String.valueOf(j16), String.valueOf(longValue));
        }
        String str2 = (String) pair2.second;
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server shareName empty");
            }
            str2 = ac.n((QQAppInterface) this.f116342a, String.valueOf(j16), String.valueOf(longValue2));
        }
        if (ac.p0((QQAppInterface) this.f116342a, String.valueOf(j16))) {
            str = ac.n((QQAppInterface) this.f116342a, String.valueOf(j16), String.valueOf(longValue));
        }
        if (j18 == 0) {
            string = this.f116342a.getApp().getString(R.string.f170851au4, str);
        } else if (j18 == 1) {
            string = this.f116342a.getApp().getString(R.string.au5, str, str2);
        } else if (j18 == 2) {
            string = this.f116342a.getApp().getString(R.string.b3e, str);
        } else {
            string = this.f116342a.getApp().getString(R.string.f170847au0, str);
        }
        G(msgInfo, j3, j16, j17, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(Pair<Long, String> pair, MsgInfo msgInfo, ArrayList<Pair<String, String>> arrayList, long j3, String str, byte b16, long j16, boolean z16) {
        int i3;
        int i16;
        String str2;
        ArrayList arrayList2;
        boolean z17;
        int i17;
        StringBuffer stringBuffer;
        int i18;
        String str3;
        long longValue = ((Long) pair.first).longValue();
        String str4 = (String) pair.second;
        int size = arrayList.size();
        int i19 = 50;
        if (size > 50) {
            i3 = 50;
        } else {
            i3 = size;
        }
        StringBuffer stringBuffer2 = new StringBuffer(i3 * 10);
        int i26 = 0;
        while (i26 < i3) {
            Pair<String, String> pair2 = arrayList.get(i26);
            String str5 = (String) pair2.first;
            if (Long.valueOf(str5).longValue() == j3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                str3 = this.f116342a.getApp().getString(R.string.au9);
                i17 = i26;
                stringBuffer = stringBuffer2;
                i18 = i3;
                e0(b16, Long.valueOf(str).longValue(), j3);
            } else {
                i17 = i26;
                stringBuffer = stringBuffer2;
                i18 = i3;
                str3 = (String) pair2.second;
                if (TextUtils.isEmpty(str3) || ac.p0((QQAppInterface) this.f116342a, str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server name empty cOpType:" + ((int) b16));
                    }
                    str3 = ac.n((QQAppInterface) this.f116342a, str, str5);
                }
            }
            String str6 = str3;
            if (i17 == 0) {
                stringBuffer.append(str6);
            } else {
                stringBuffer.append("\u3001" + str6);
            }
            i26 = i17 + 1;
            i3 = i18;
            stringBuffer2 = stringBuffer;
            i19 = 50;
        }
        int i27 = i19;
        StringBuffer stringBuffer3 = stringBuffer2;
        if (size > i27) {
            stringBuffer3.append(" \u7b49");
            stringBuffer3.append(size - 1);
            stringBuffer3.append("\u4eba");
        }
        if (z16) {
            i16 = -5001;
        } else {
            i16 = -1004;
        }
        int i28 = i16;
        ArrayList arrayList3 = new ArrayList();
        MessageRecord d16 = q.d(i28);
        if (b16 != 11) {
            str2 = "";
        } else {
            str2 = this.f116342a.getApp().getString(R.string.au7);
        }
        String I = I(j3, str, b16, j16, longValue, str4, stringBuffer3, str2);
        long j17 = msgInfo.lFromUin;
        d16.init(j3, j17, j17, I, msgInfo.uRealMsgTime, i28, 3000, msgInfo.uMsgTime);
        d16.isread = true;
        if (d16 instanceof MessageForNewGrayTips) {
            ((MessageForNewGrayTips) d16).updateMsgData();
        }
        if (!MessageHandlerUtils.msgFilter(this.f116342a, d16, false)) {
            arrayList2 = arrayList3;
            arrayList2.add(d16);
        } else {
            arrayList2 = arrayList3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis(showWelcomeTips) friendUin: " + d16.frienduin + " msgType: " + i28 + " friendType: 3000 shMsgSeq: " + ((int) msgInfo.shMsgSeq) + " msgContent: " + d16.getLogColorContent());
        }
        if (arrayList2.size() > 0) {
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).addMessage(arrayList2, String.valueOf(j3));
        }
    }

    private void h0(Pair<Long, String> pair, MsgInfo msgInfo, ArrayList<Pair<String, String>> arrayList, long j3, String str, byte b16, boolean z16) {
        g0(pair, msgInfo, arrayList, j3, str, b16, 0L, z16);
    }

    private void i0(Pair<Long, String> pair, MsgInfo msgInfo, ArrayList<Pair<String, String>> arrayList, long j3, String str, byte b16, boolean z16) {
        if (this.f195841v == null) {
            this.f195841v = new Handler(ThreadManagerV2.getSubThreadLooper());
        }
        this.f195841v.postDelayed(new Runnable(pair, msgInfo, arrayList, j3, str, b16, z16) { // from class: com.tencent.mobileqq.app.message.DiscMessageProcessor.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean C;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Pair f195855d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MsgInfo f195856e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ ArrayList f195857f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f195858h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f195859i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ byte f195860m;

            {
                this.f195855d = pair;
                this.f195856e = msgInfo;
                this.f195857f = arrayList;
                this.f195858h = j3;
                this.f195859i = str;
                this.f195860m = b16;
                this.C = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DiscMessageProcessor.this, pair, msgInfo, arrayList, Long.valueOf(j3), str, Byte.valueOf(b16), Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    DiscMessageProcessor.this.g0(this.f195855d, this.f195856e, this.f195857f, this.f195858h, this.f195859i, this.f195860m, 0L, this.C);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 2000L);
    }

    private void j0(ArrayList<String> arrayList, String str, String str2, String str3) {
        int i3;
        MessageRecord d16 = q.d(-1016);
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (arrayList != null && arrayList.size() > 1) {
            int size = arrayList.size();
            if (size > 50) {
                i3 = 50;
            } else {
                i3 = size;
            }
            StringBuilder sb5 = new StringBuilder(i3 * 10);
            for (int i16 = 1; i16 < i3; i16++) {
                sb5.append(arrayList.get(i16));
                if (i16 != i3 - 1) {
                    sb5.append("\u3001");
                }
            }
            if (size > 50) {
                sb5.append(" \u7b49");
                sb5.append(size - 1);
                sb5.append("\u4eba");
            }
            String string = this.f116342a.getApplication().getString(R.string.f170799af0, sb5);
            d16.init(str2, str, str3, "", K0, -1016, 3000, K0);
            d16.extStr = string;
            d16.isread = true;
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).addMessage(d16, d16.selfuin);
        }
    }

    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Handler handler = this.f195841v;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void c(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        super.c(str, i3, j3);
        msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
        msg_svc$PbDiscussReadedReportReq msg_svc_pbdiscussreadedreportreq = new msg_svc$PbDiscussReadedReportReq();
        msg_svc_pbdiscussreadedreportreq.conf_uin.set(Long.valueOf(str).longValue());
        msg_svc_pbdiscussreadedreportreq.last_read_seq.set(j3);
        msg_svc_pbmsgreadedreportreq.dis_read_report.add(msg_svc_pbdiscussreadedreportreq);
        w(msg_svc_pbmsgreadedreportreq);
    }

    public void d0(DisMsgReadedNotify disMsgReadedNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) disMsgReadedNotify);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "DisMsgReadedNotify lDisUin is " + disMsgReadedNotify.lDisUin + ", lMemberSeq  is " + disMsgReadedNotify.lMemberSeq);
        }
        String valueOf = String.valueOf(disMsgReadedNotify.lDisUin);
        Object[] r06 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).r0(valueOf);
        if (r06 != null && r06.length >= 2) {
            long longValue = ((Long) r06[0]).longValue();
            ((Long) r06[1]).longValue();
            if (longValue < disMsgReadedNotify.lMemberSeq) {
                ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).o(valueOf, new Object[]{Long.valueOf(disMsgReadedNotify.lMemberSeq), Long.valueOf(disMsgReadedNotify.lDisMsgSeq)});
            }
        }
        ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setReadFrom(valueOf, 3000, disMsgReadedNotify.lMemberSeq);
        if (disMsgReadedNotify.lMemberSeq >= 0) {
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeNotification(valueOf, 3000);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public ag o(int i3, MsgInfo msgInfo, SvcReqPushMsg svcReqPushMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ag) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), msgInfo, svcReqPushMsg);
        }
        if (i3 == 9010) {
            if (msgInfo != null && svcReqPushMsg != null) {
                return new ag(c0(msgInfo, svcReqPushMsg), false);
            }
            f(getClass().getName(), i3);
            return null;
        }
        return null;
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) objArr);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        }
    }
}
