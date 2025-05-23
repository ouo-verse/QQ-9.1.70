package com.tencent.mobileqq.stt;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.m;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.qqmc.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SttManager implements Manager, BusinessObserver, Handler.Callback {
    static IPatchRedirector $redirector_;
    private volatile boolean C;

    /* renamed from: d, reason: collision with root package name */
    public AppRuntime f290704d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    private a f290705e;

    /* renamed from: f, reason: collision with root package name */
    protected Handler f290706f;

    /* renamed from: h, reason: collision with root package name */
    protected Handler f290707h;

    /* renamed from: i, reason: collision with root package name */
    private CopyOnWriteArrayList<Long> f290708i;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<Long, c> f290709m;

    public SttManager(AppRuntime appRuntime) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.f290704d = appRuntime;
        this.f290706f = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f290707h = new Handler(Looper.getMainLooper(), this);
    }

    @Nullable
    private boolean b(MessageForPtt messageForPtt, a aVar) {
        if (messageForPtt.istroop == 0) {
            if (StringUtil.isEmpty(messageForPtt.urlAtServer)) {
                QLog.e("", 1, "stt err, c2c no fileID ", messageForPtt);
                messageForPtt.getSttResult().f(1, 2003);
                i(messageForPtt, aVar);
                return false;
            }
        } else if (StringUtil.isEmpty(messageForPtt.md5)) {
            QLog.e("", 1, "stt err, troop no md5 ", messageForPtt);
            messageForPtt.getSttResult().f(1, 2004);
            i(messageForPtt, aVar);
            return false;
        }
        return true;
    }

    private Long c(int i3, MessageForPtt messageForPtt, int i16, a aVar) {
        c c16 = c.c(i3, messageForPtt, this.f290704d, i16, aVar);
        if (c16 == null) {
            return null;
        }
        c16.q(this.f290706f);
        Long p16 = c16.p();
        if (p16 != null) {
            this.f290709m.put(p16, c16);
            this.f290708i.add(Long.valueOf(messageForPtt.uniseq));
        }
        return p16;
    }

    private void d(MessageForPtt messageForPtt) {
        g gVar = new g(messageForPtt.frienduin, messageForPtt.selfuin, HardCodeUtil.qqStr(R.string.twm), messageForPtt.istroop, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 655392, messageForPtt.time);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        if (messageForPtt.istroop == 1) {
            messageForUniteGrayTip.shmsgseq = messageForPtt.shmsgseq;
        }
        messageForUniteGrayTip.initGrayTipMsg(this.f290704d, gVar);
        f.a(this.f290704d, messageForUniteGrayTip);
        QVipConfigManager.setBoolean(this.f290704d, QVipConfigManager.KEY_BOOLEAN_HAVE_ADD_PTT_SVIP_GRAY_MSG, true);
    }

    private void f() {
        if (!this.C) {
            this.f290704d.registObserver(this);
            this.C = true;
        }
    }

    private boolean h(boolean z16) {
        if (QVipAutoPttConfig.INSTANCE.getStage() == 2 && !z16 && VasUtil.getSignedService(this.f290704d).getVipStatus().isSVip() && m.f179515e) {
            return true;
        }
        return false;
    }

    private void i(MessageForPtt messageForPtt, a aVar) {
        this.f290707h.post(new Runnable(messageForPtt, aVar) { // from class: com.tencent.mobileqq.stt.SttManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageForPtt f290710d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f290711e;

            {
                this.f290710d = messageForPtt;
                this.f290711e = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SttManager.this, messageForPtt, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                SttManager sttManager = SttManager.this;
                MessageForPtt messageForPtt2 = this.f290710d;
                sttManager.m(messageForPtt2, messageForPtt2.getSttResult().c());
                a aVar2 = this.f290711e;
                if (aVar2 != null) {
                    aVar2.b(this.f290710d);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(MessageForPtt messageForPtt, int i3) {
        if (messageForPtt != null) {
            messageForPtt.sttAbility = 3;
            messageForPtt.sttText = "";
            messageForPtt.isReadPtt = true;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_succ_flag", "0");
            hashMap.put("param_version", Build.VERSION.SDK_INT + "");
            hashMap.put("param_deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            sb5.append("");
            hashMap.put("param_resultCode", sb5.toString());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ptttotextSuc", false, 0L, 0L, hashMap, null);
            try {
                messageForPtt.serial();
                ((IMessageFacade) this.f290704d.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.STT, 2, "updatedb", e16);
                }
            }
        }
    }

    private void n(MessageForPtt messageForPtt) {
        boolean z16 = QVipConfigManager.getBoolean(this.f290704d, QVipConfigManager.KEY_BOOLEAN_HAVE_ADD_PTT_SVIP_GRAY_MSG, false);
        if (h(z16)) {
            d(messageForPtt);
            QLog.e(LogTag.STT, 1, "stage2 first translate It is need add gray msg and insert success");
        } else if (QLog.isColorLevel()) {
            QLog.d(LogTag.STT, 1, "stage2 first translate It is need add gray msg and insert failed:conf.stage == " + QVipAutoPttConfig.INSTANCE.getStage() + " && " + z16);
        }
    }

    public boolean e(MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        return this.f290708i.contains(Long.valueOf(messageForPtt.uniseq));
    }

    public boolean g(MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        if (messageForPtt.autoToText >= 1 && !e(messageForPtt) && messageForPtt.sttAbility != 2) {
            return true;
        }
        ((ISttManagerApi) QRoute.api(ISttManagerApi.class)).initAutoToTextSwitch(this.f290704d);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.STT, 2, "needAuotoChange AutoChangeFlag=" + m.f179515e + " AutoChangeSetTime=" + m.f179516f + " isTranslating=" + e(messageForPtt) + "msgPtt.msgTime=" + messageForPtt.msgTime + " msgPtt.time=" + messageForPtt.time + " msgPtt.sttAbility=" + messageForPtt.sttAbility);
        }
        if (!e(messageForPtt) && m.f179515e) {
            long j3 = m.f179516f;
            if ((j3 < messageForPtt.msgTime || j3 < messageForPtt.time) && messageForPtt.voiceChangeFlag != 1) {
                int i3 = messageForPtt.sttAbility;
                if (i3 == 1 || i3 == 3) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        long j3 = (message.arg1 << 32) | (message.arg2 & 4294967295L);
        int i16 = message.what;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        if (i16 != 1001 && i16 != 1002) {
                            QLog.e(LogTag.STT, 1, "handleMessage unknown msg = " + message.what);
                        } else {
                            c remove = this.f290709m.remove(Long.valueOf(j3));
                            if (remove == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(LogTag.STT, 2, "handleMessage STT_MSG_STT_RSP_ERROR get sttTask is null = " + message.what);
                                }
                                return true;
                            }
                            MessageForPtt h16 = remove.h();
                            this.f290708i.remove(Long.valueOf(h16.uniseq));
                            i(h16, remove.g());
                        }
                        return true;
                    }
                }
            }
            c cVar = this.f290709m.get(Long.valueOf(j3));
            if (cVar == null) {
                QLog.e(LogTag.STT, 2, "handleMessage STT_MSG_TASK_STT_UPDATE get sttTask is null = " + message.what);
                return true;
            }
            MessageForPtt h17 = cVar.h();
            if (cVar.j() == 3) {
                h17.sttText = h17.getSttResult().a();
                h17.sttAbility = 2;
                h17.isReadPtt = true;
                h17.serial();
                this.f290709m.remove(Long.valueOf(j3));
                this.f290708i.remove(Long.valueOf(h17.uniseq));
                this.f290707h.post(new Runnable(h17, cVar) { // from class: com.tencent.mobileqq.stt.SttManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MessageForPtt f290712d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ c f290713e;

                    {
                        this.f290712d = h17;
                        this.f290713e = cVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, SttManager.this, h17, cVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        IMessageFacade iMessageFacade = (IMessageFacade) SttManager.this.f290704d.getRuntimeService(IMessageFacade.class, "");
                        MessageForPtt messageForPtt = this.f290712d;
                        iMessageFacade.updateMsgContentByUniseq(messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
                        if (!this.f290712d.getSttResult().d() && this.f290713e.g() != null) {
                            this.f290713e.g().a(this.f290712d, false);
                        }
                    }
                });
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.STT, 2, "PttSttReport PTT_STT_RESULT_MONITOR success");
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(QzoneIPCModule.RESULT_CODE, "0");
                hashMap.put("subCode", "0");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_STT_RESULT_MONITOR, true, 0L, 0L, hashMap, null);
            }
            if (h17.getSttResult().d()) {
                if (message.what == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && !h17.isReadPtt) {
                    h17.isReadPtt = true;
                    h17.serial();
                }
                this.f290707h.post(new Runnable(cVar, h17, z16) { // from class: com.tencent.mobileqq.stt.SttManager.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ c f290714d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ MessageForPtt f290715e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f290716f;

                    {
                        this.f290714d = cVar;
                        this.f290715e = h17;
                        this.f290716f = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, SttManager.this, cVar, h17, Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f290714d.g() != null) {
                            this.f290714d.g().a(this.f290715e, this.f290716f);
                        }
                    }
                });
            }
            return true;
        }
        if (!this.f290709m.containsKey(Long.valueOf(j3))) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.STT, 2, "handleMessage TIME OUT task not key = " + message.what + "  | session = " + j3);
            }
            return true;
        }
        c remove2 = this.f290709m.remove(Long.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.e(LogTag.STT, 2, "handleMessage TIME OUT key = " + message.what + "  | session = " + j3);
        }
        if (remove2 != null && remove2.h() != null) {
            this.f290708i.remove(Long.valueOf(remove2.h().uniseq));
            if (message.what == 3) {
                i3 = 2006;
            } else {
                i3 = 2002;
            }
            Long b16 = remove2.b(i3);
            if (b16 != null) {
                this.f290709m.put(b16, remove2);
                this.f290707h.post(new Runnable(remove2) { // from class: com.tencent.mobileqq.stt.SttManager.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ c f290717d;

                    {
                        this.f290717d = remove2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SttManager.this, (Object) remove2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f290717d.g() != null) {
                            this.f290717d.g().c(this.f290717d.h());
                        }
                    }
                });
            } else {
                MessageForPtt h18 = remove2.h();
                m(h18, h18.getSttResult().c());
                this.f290707h.post(new Runnable(remove2) { // from class: com.tencent.mobileqq.stt.SttManager.5
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ c f290718d;

                    {
                        this.f290718d = remove2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SttManager.this, (Object) remove2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (this.f290718d.g() != null) {
                            this.f290718d.g().b(this.f290718d.h());
                        }
                    }
                });
            }
        }
        return true;
    }

    public void j(byte[] bArr) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
            return;
        }
        SttResultPush$MsgBody sttResultPush$MsgBody = new SttResultPush$MsgBody();
        try {
            sttResultPush$MsgBody.mergeFrom(bArr);
            if (sttResultPush$MsgBody.msg_ptt_shard_resp.has()) {
                j3 = sttResultPush$MsgBody.msg_ptt_shard_resp.uint64_sessionid.get();
            } else if (sttResultPush$MsgBody.msg_ptt_resp.has()) {
                j3 = sttResultPush$MsgBody.msg_ptt_resp.uint64_sessionid.get();
            } else {
                j3 = 0;
            }
            c cVar = this.f290709m.get(Long.valueOf(j3));
            if (cVar == null) {
                QLog.e(LogTag.STT, 1, "onSttResultPush task not find: session = " + j3);
                return;
            }
            QLog.i(LogTag.STT, 1, "onSttResultPush task doReceivePushData session = " + j3 + " | result = " + cVar.e(sttResultPush$MsgBody));
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(LogTag.STT, 1, "onSttResultPush failed with: ", e16);
        }
    }

    public Long k(String str, String str2, int i3, String str3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Long) iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), str3, aVar);
        }
        f();
        MessageForPtt messageForPtt = new MessageForPtt();
        messageForPtt.senderuin = str;
        messageForPtt.frienduin = str2;
        messageForPtt.istroop = i3;
        messageForPtt.md5 = str3;
        return c(2, messageForPtt, 1, aVar);
    }

    public void l(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f290705e = aVar;
        }
    }

    @Deprecated
    public Long o(MessageForPtt messageForPtt, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageForPtt, i3);
        }
        return p(messageForPtt, i3, this.f290705e);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ((ISttManagerApi) QRoute.api(ISttManagerApi.class)).resetSttAbility();
        this.f290709m.clear();
        this.f290708i.clear();
        if (this.C) {
            this.f290704d.unRegistObserver(this);
            this.C = false;
        }
        this.f290705e = null;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.STT, 2, "onReceive bundle is null");
                return;
            }
            return;
        }
        Long valueOf = Long.valueOf(bundle.getLong("k_session", 0L));
        c cVar = this.f290709m.get(valueOf);
        if (cVar == null) {
            QLog.e(LogTag.STT, 2, "mSttTaskList get by session is null , session = " + valueOf);
            return;
        }
        boolean d16 = cVar.d(z16, bundle);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.STT, 2, "onReceive result is " + d16);
        }
    }

    public Long p(MessageForPtt messageForPtt, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Long) iPatchRedirector.redirect((short) 7, this, messageForPtt, Integer.valueOf(i3), aVar);
        }
        f();
        if (!b(messageForPtt, aVar)) {
            return null;
        }
        n(messageForPtt);
        return c(1, messageForPtt, i3, aVar);
    }

    public Long q(MessageForPtt messageForPtt, String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Long) iPatchRedirector.redirect((short) 5, this, messageForPtt, str, aVar);
        }
        f();
        messageForPtt.md5 = str;
        return c(3, messageForPtt, 1, aVar);
    }

    public SttManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.C = false;
        this.f290709m = new ConcurrentHashMap<>();
        this.f290708i = new CopyOnWriteArrayList<>();
    }
}
