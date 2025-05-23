package com.tencent.mobileqq.pic;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.business.PicRefreshChatHandler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicHelperImpl;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* loaded from: classes16.dex */
public class PicPreDownloader implements Manager {
    static IPatchRedirector $redirector_;
    public static boolean D;
    private static boolean E;
    private PriorityBlockingQueue<p> C;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f258520d;

    /* renamed from: e, reason: collision with root package name */
    private s f258521e;

    /* renamed from: f, reason: collision with root package name */
    private PicPreDownloaderCore f258522f;

    /* renamed from: h, reason: collision with root package name */
    public w f258523h;

    /* renamed from: i, reason: collision with root package name */
    private BroadcastReceiver f258524i;

    /* renamed from: m, reason: collision with root package name */
    private LinkedBlockingQueue<MessageRecord> f258525m;

    /* loaded from: classes16.dex */
    public static class ScreenBroadcastReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f258538a;

        public ScreenBroadcastReceiver(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f258538a = str;
            }
        }

        public boolean a(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
            }
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                boolean unused = PicPreDownloader.E = PicPreDownloader.D;
                PicPreDownloader.D = !a(context);
            } else if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                boolean unused2 = PicPreDownloader.E = PicPreDownloader.D;
                PicPreDownloader.D = false;
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                boolean unused3 = PicPreDownloader.E = PicPreDownloader.D;
                PicPreDownloader.D = true;
            }
            f.b("PIC_TAG_PRELOAD", "onReceive", "isScreenOn:" + PicPreDownloader.D + ",lastScreenOnState:" + PicPreDownloader.E);
            boolean z16 = PicPreDownloader.E;
            boolean z17 = PicPreDownloader.D;
            if (z16 == z17 && !z17) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenBroadcastReceiver.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (!TextUtils.isEmpty(peekAppRuntime.getAccount())) {
                        PicPreDownloader picPreDownloader = ((PicPreDownloadImpl) peekAppRuntime.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader;
                        picPreDownloader.n();
                        picPreDownloader.o();
                        ((IDep) QRoute.api(IDep.class)).consumeAllThumbsInPendingQueue();
                    }
                }
            }, 128, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends ac.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicPreDownloader.this);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void b(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void g(int i3, q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) qVar);
                return;
            }
            PicRefreshChatHandler picRefreshChatHandler = (PicRefreshChatHandler) PicPreDownloader.this.f258520d.getBusinessHandler(PicRefreshChatHandler.class.getName());
            if (picRefreshChatHandler != null) {
                picRefreshChatHandler.D2();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17621);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            D = true;
            E = false;
        }
    }

    public PicPreDownloader(AppInterface appInterface, s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) sVar);
            return;
        }
        this.f258525m = new LinkedBlockingQueue<>(100);
        this.C = new PriorityBlockingQueue<>();
        QLog.i("PicPreDownload", 1, "[init] stack=" + QLog.getStackTraceString(new RuntimeException()));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f258524i = new ScreenBroadcastReceiver(appInterface.getCurrentAccountUin());
        appInterface.getApp().registerReceiver(this.f258524i, intentFilter);
        w wVar = new w();
        this.f258523h = wVar;
        this.f258522f = new PicPreDownloaderCore(this, wVar);
        ThreadManagerV2.excute(new Runnable(appInterface, sVar) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppInterface f258526d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ s f258527e;

            {
                this.f258526d = appInterface;
                this.f258527e = sVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PicPreDownloader.this, appInterface, sVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    PicPreDownloader.this.f258523h.u(this.f258526d, this.f258527e);
                }
            }
        }, 64, null, true);
        this.f258520d = appInterface;
        this.f258521e = sVar;
        f.b("PIC_TAG_PRELOAD", "onInit", "Finished");
    }

    private void D(MessageRecord messageRecord) {
        int a16 = com.tencent.mobileqq.pic.a.a();
        f.b("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + a16);
        if (messageRecord instanceof MessageForPic) {
            ((MessageForPic) messageRecord).preDownNetworkType = a16;
            return;
        }
        if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(messageRecord)) {
            for (MessageRecord messageRecord2 : ((IMsgMixed) QRoute.api(IMsgMixed.class)).getElementList(messageRecord)) {
                if (messageRecord2 instanceof MessageForPic) {
                    ((MessageForPic) messageRecord2).preDownNetworkType = a16;
                }
            }
        }
    }

    private void h(MessageRecord messageRecord, int i3, int i16) {
        if (messageRecord == null) {
            return;
        }
        if (messageRecord.isSendFromLocal()) {
            f.b("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
        } else {
            j(messageRecord, i3, i16);
        }
    }

    private boolean i(MessageForPic messageForPic, int i3) {
        int i16;
        if (PicHelperImpl.hasBigFile(messageForPic)) {
            f.b("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + messageForPic.uniseq + ", priority: " + i3);
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
            }
            n.n(this.f258520d, messageForPic);
            return false;
        }
        if (com.tencent.mobileqq.app.ac.c(messageForPic) && AbsDownloader.getFlashPicFile(((IPicHelper) QRoute.api(IPicHelper.class)).getURL(messageForPic, 1, (String) null).toString()) != null) {
            f.b("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + messageForPic.uniseq + ", priority: " + i3);
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture, uniseq: " + messageForPic.uniseq);
        }
        f.b("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq:" + messageForPic.uniseq + ", suMsgId: " + messageForPic.subMsgId + ", priority:" + i3);
        if (com.tencent.mobileqq.pic.a.a() == 0) {
            i16 = 1536;
        } else {
            i16 = 1537;
        }
        p f16 = i.f(6, i16, 2);
        f16.G = new a();
        k picDownloadInfo = messageForPic.getPicDownloadInfo();
        if (picDownloadInfo != null) {
            picDownloadInfo.f258727d0 = 1;
            picDownloadInfo.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
        }
        f16.d(messageForPic, picDownloadInfo);
        this.f258522f.i(f16, n.i(this.f258520d, messageForPic.istroop, messageForPic.frienduin), i3);
        f.b("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq:" + messageForPic.uniseq + ", suMsgId: " + messageForPic.subMsgId + ", priority: " + i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(MessageRecord messageRecord, int i3, int i16) {
        int i17;
        String str;
        boolean z16;
        if (messageRecord instanceof MessageForPic) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("START uniseq:");
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            sb5.append(messageForPic.uniseq);
            sb5.append(", suMsgId:");
            sb5.append(messageForPic.subMsgId);
            sb5.append(", priority:");
            sb5.append(i16);
            f.b("PIC_TAG_PRELOAD", "add", sb5.toString());
        }
        if (messageRecord.isMultiMsg && !messageRecord.isSend()) {
            com.tencent.mobileqq.multimsg.api.a multiMsgValue = ((IMultiMsg) QRoute.api(IMultiMsg.class)).getMultiMsgValue();
            if (multiMsgValue.f251591d != null) {
                i17 = multiMsgValue.f251589b;
                str = multiMsgValue.f251590c;
            } else {
                i17 = messageRecord.istroop;
                str = messageRecord.frienduin;
            }
        } else {
            i17 = messageRecord.istroop;
            str = messageRecord.frienduin;
        }
        int i18 = n.i(this.f258520d, i17, str);
        int a16 = com.tencent.mobileqq.pic.a.a();
        GroupMsgMask troopMask = ((IConversationFacade) this.f258520d.getRuntimeService(IConversationFacade.class, "")).getTroopMask(str);
        if (i18 == 4) {
            troopMask = GroupMsgMask.NOTIFY;
        }
        GroupMsgMask groupMsgMask = troopMask;
        boolean[] d16 = s().d(i18, a16);
        if (d16[0] && (i3 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = d16[1];
        f.b("PIC_TAG_PRELOAD", "add", "preDownThumb=" + z16 + " preDownBig=" + z17);
        if (messageRecord instanceof MessageForPic) {
            t((MessageForPic) messageRecord, i3, i16, groupMsgMask, z16, z17);
        } else if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
            u(messageRecord, a16, i16, groupMsgMask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return b.f258636h;
    }

    private boolean l() {
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1 || readValue) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String str;
        f.b("PIC_TAG_PRELOAD", "consumeThumb", "START");
        int a16 = com.tencent.mobileqq.pic.a.a();
        if (!D && a16 != 0) {
            f.b("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + a16);
            return;
        }
        Iterator<p> it = this.C.iterator();
        while (it.hasNext()) {
            p next = it.next();
            this.f258522f.j(new Runnable(next) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ p f258535d;

                {
                    this.f258535d = next;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicPreDownloader.this, (Object) next);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        i.k(this.f258535d);
                    }
                }
            }, "consumeAllThumbsInPendingQueue-thumbPendingQueue", next.H);
            if (next.f258788m != null) {
                str = "uniseq:" + next.f258788m.D;
            } else {
                str = "";
            }
            f.b("PIC_TAG_PRELOAD", "run picReq thumb", str);
        }
        this.C.clear();
        Iterator<MessageRecord> it5 = this.f258525m.iterator();
        while (it5.hasNext()) {
            MessageRecord next2 = it5.next();
            if (next2 != null) {
                this.f258522f.j(new Runnable(next2) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.8
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MessageRecord f258536d;

                    {
                        this.f258536d = next2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicPreDownloader.this, (Object) next2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ((IMsgStructing) QRoute.api(IMsgStructing.class)).consumeStructMsgPicPre(this.f258536d);
                        }
                    }
                }, "consumeAllThumbsInPendingQueue-structMsgPendingQueue", next2);
                f.b("PIC_TAG_PRELOAD", "structMsg-add ", "finish struct msg preDownload,  uniseq =" + next2.uniseq);
            }
        }
        this.f258525m.clear();
        f.b("PIC_TAG_PRELOAD", "consumeThumb", "END");
    }

    private void p(MessageForPic messageForPic) {
        boolean z16;
        int i3;
        if (PicHelperImpl.hasThumbFile(messageForPic)) {
            return;
        }
        if (!com.tencent.mobileqq.utils.c.h(messageForPic.msgtype) && (i3 = messageForPic.msgtype) != -3001 && i3 != -30002 && i3 != -30003) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.f258521e.h(messageForPic);
        p f16 = i.f(5, 1536, 2);
        k picDownloadInfo = messageForPic.getPicDownloadInfo();
        if (picDownloadInfo != null) {
            picDownloadInfo.f258727d0 = 1;
        }
        f16.d(messageForPic, picDownloadInfo);
        int a16 = com.tencent.mobileqq.pic.a.a();
        if (!D && a16 != 0) {
            f.b("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + a16);
            this.C.add(f16);
            return;
        }
        this.f258522f.j(new Runnable(f16) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ p f258534d;

            {
                this.f258534d = f16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicPreDownloader.this, (Object) f16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    i.k(this.f258534d);
                }
            }
        }, "consumeThumb", f16.H);
        f.b("PIC_TAG_PRELOAD", "run picReq thumb", "uniseq:" + messageForPic.uniseq + ",subMsgId:" + messageForPic.subMsgId);
    }

    private void t(MessageForPic messageForPic, int i3, int i16, GroupMsgMask groupMsgMask, boolean z16, boolean z17) {
        if (messageForPic.path == null && messageForPic.uuid == null && messageForPic.md5 == null) {
            f.b("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
            E(messageForPic, -3);
            return;
        }
        if (this.f258522f.p(messageForPic, i16)) {
            f.b("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + messageForPic.uniseq + ",suMsgId:" + messageForPic.subMsgId + "priority:" + i16);
            return;
        }
        if (z16 && groupMsgMask != GroupMsgMask.ASSISTANT) {
            p(messageForPic);
        }
        if ((i3 & 2) == 2) {
            if (!l()) {
                if (QLog.isColorLevel()) {
                    QLog.d("PIC_TAG_PRELOAD", 2, "messageForPicAddToQueue, cannot preDownload big pic");
                }
                if (messageForPic.checkGif()) {
                    messageForPic.isDownStatusReady = true;
                    ((w) s()).C();
                }
                E(messageForPic, -1);
                return;
            }
            boolean e16 = d.e(messageForPic, false, i16);
            if (!z17 && !e16) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (groupMsgMask != GroupMsgMask.NOTIFY && !e16) {
                f.b("PIC_TAG_PRELOAD", "add", "The troop is num troop, uniseq:" + messageForPic.uniseq);
                E(messageForPic, -7);
            } else if (s().f(messageForPic)) {
                if (i(messageForPic, i16) && z17) {
                    if (this.f258522f.t()) {
                        f.b("PIC_TAG_PRELOAD", "add", "start to consume, uniseq:" + messageForPic.uniseq);
                        n();
                    } else {
                        f.b("PIC_TAG_PRELOAD", "add", "handling queue full, uniseq:" + messageForPic.uniseq);
                    }
                    if (messageForPic.checkGif() && !messageForPic.isSendFromLocal() && i16 == 6 && !PicHelperImpl.hasThumbFile(messageForPic)) {
                        f.b("PIC_TAG_PRELOAD", "addBigPicRequest", "not hasThumbFile,download thumb,uniseq: " + messageForPic.uniseq + ", priority: " + i16);
                        p(messageForPic);
                    }
                }
            } else {
                E(messageForPic, -6);
            }
        }
        f.b("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + messageForPic.uniseq + ",suMsgId:" + messageForPic.subMsgId + ",priority:" + i16 + ", preDownBig:" + z17);
    }

    private void u(MessageRecord messageRecord, int i3, int i16, GroupMsgMask groupMsgMask) {
        if (i3 != 0 && groupMsgMask == GroupMsgMask.ASSISTANT) {
            f.b("PIC_TAG_PRELOAD", "add", "add struct msg to queue, num group skip, uniseq:" + messageRecord.uniseq + "priority:" + i16);
            return;
        }
        if (!D && i3 != 0) {
            try {
                this.f258525m.add(messageRecord);
            } catch (Exception unused) {
                f.b("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload exception happened,networkType:" + i3);
            }
            f.b("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload,networkType:" + i3);
            return;
        }
        this.f258522f.j(new Runnable(messageRecord) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageRecord f258533d;

            {
                this.f258533d = messageRecord;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicPreDownloader.this, (Object) messageRecord);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((IMsgStructing) QRoute.api(IMsgStructing.class)).consumeStructMsgPicPre(this.f258533d);
                }
            }
        }, "addToQueue-MessageForStruct", messageRecord);
        f.b("PIC_TAG_PRELOAD", "structMsg-add ", "finish preDownload uniseq:" + messageRecord.uniseq + ",");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(MessageRecord messageRecord, int i3, int i16) {
        if (messageRecord instanceof MessageForPic) {
            h(messageRecord, i3, i16);
            return;
        }
        if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(messageRecord)) {
            List<MessageRecord> elementList = ((IMsgMixed) QRoute.api(IMsgMixed.class)).getElementList(messageRecord);
            for (int i17 = 0; i17 < elementList.size(); i17++) {
                MessageRecord messageRecord2 = elementList.get(i17);
                if (messageRecord2 instanceof MessageForPic) {
                    MessageForPic messageForPic = (MessageForPic) messageRecord2;
                    if (messageForPic.time == 0) {
                        ((IMsgMixed) QRoute.api(IMsgMixed.class)).copyBaseInfoFromMixedToPic(messageForPic, messageRecord);
                    }
                    h(messageForPic, i3, i16);
                }
            }
            return;
        }
        if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
            h(messageRecord, i3, i16);
        }
    }

    private void z(MessageForPic messageForPic, int i3, int i16) {
        this.f258522f.j(new Runnable(messageForPic, i3, i16) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageForPic f258530d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f258531e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f258532f;

            {
                this.f258530d = messageForPic;
                this.f258531e = i3;
                this.f258532f = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PicPreDownloader.this, messageForPic, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    if (PicPreDownloader.this.k()) {
                        PicPreDownloader.this.y(this.f258530d, this.f258531e, this.f258532f);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PIC_TAG_PRELOAD", 2, "productAsync, cannot preDownload");
                    }
                    PicPreDownloader.this.E(this.f258530d, -1);
                }
            }
        }, "productAsync", messageForPic);
    }

    public void A(MessageForPic messageForPic, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageForPic, i3);
            return;
        }
        D(messageForPic);
        long j3 = b.f258637i;
        if (j3 != 2 && j3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
            }
            E(messageForPic, -2);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): ");
            }
            z(messageForPic, i3, 6);
        }
    }

    public void B(MessageForPic messageForPic, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) messageForPic, i3);
            return;
        }
        D(messageForPic);
        long j3 = b.f258637i;
        if (j3 != 2 && j3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
            }
            E(messageForPic, -2);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIODynamicPic(): ");
            }
            this.f258522f.j(new Runnable(messageForPic, i3) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MessageForPic f258528d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f258529e;

                {
                    this.f258528d = messageForPic;
                    this.f258529e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PicPreDownloader.this, messageForPic, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (PicPreDownloader.this.k()) {
                            PicPreDownloader.this.j(this.f258528d, this.f258529e, 6);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("PIC_TAG_PRELOAD", 2, "productAsync(): cannot preDownload");
                        }
                        PicPreDownloader.this.E(this.f258528d, -1);
                    }
                }
            }, "productFromAIODynamicPic", messageForPic);
        }
    }

    public void C(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) messageRecord, i3);
            return;
        }
        D(messageRecord);
        if (!k()) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): cannot preDownload");
            }
            E(messageRecord, -1);
            return;
        }
        long j3 = b.f258637i;
        if (j3 != 1 && j3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): PicAuDownTimePoint is not DOWNLOAD_POINT_MSG or DOWNLOAD_POINT_ALL");
            }
            E(messageRecord, -2);
            return;
        }
        IMessageFacade iMessageFacade = (IMessageFacade) this.f258520d.getRuntimeService(IMessageFacade.class, "");
        if (iMessageFacade.isChatting() && TextUtils.equals(iMessageFacade.getCurrChatUin(), messageRecord.frienduin)) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "The AIO is opening, does not need to preDownload the thumb picture");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): ");
        }
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            messageForPic.getReportInfo().f258584f = com.tencent.mobileqq.pic.a.a();
            messageForPic.getReportInfo().f258583e = System.currentTimeMillis();
            messageForPic.getReportInfo().f258582d = 0;
        }
        y(messageRecord, i3, 1);
        ChatImageDownloader.reportClientExist(messageRecord);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord, i3);
            return;
        }
        StringBuilder sb5 = new StringBuilder("Reason=" + i3);
        if (messageRecord != null) {
            sb5.append(", uniseq:");
            sb5.append(messageRecord.uniseq);
        }
        f.b("PIC_TAG_PRELOAD", "setNotPreDownloadReason", sb5.toString());
        if (messageRecord instanceof MessageForPic) {
            ((MessageForPic) messageRecord).mNotPredownloadReason = i3;
            return;
        }
        if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(messageRecord)) {
            for (MessageRecord messageRecord2 : ((IMsgMixed) QRoute.api(IMsgMixed.class)).getElementList(messageRecord)) {
                if (messageRecord2 instanceof MessageForPic) {
                    ((MessageForPic) messageRecord2).mNotPredownloadReason = i3;
                }
            }
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f258522f.m();
        }
    }

    public void n() {
        int i3;
        Collection<p> s16;
        MessageForPic messageForPic;
        ThumbWidthHeightDP thumbWidthHeightDP;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        f.b("PIC_TAG_PRELOAD", "consume", "START");
        if (!this.f258522f.u()) {
            f.b("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
            return;
        }
        if (!this.f258522f.t()) {
            f.b("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
            return;
        }
        boolean z16 = false;
        p q16 = this.f258522f.q(false);
        if (q16 != null && (messageForPic = q16.H) != null && (thumbWidthHeightDP = messageForPic.thumbWidthHeightDP) != null) {
            z16 = thumbWidthHeightDP.useCustomSize();
            f.b("PIC_TAG_PRELOAD", "consume", "isBigImage=" + z16);
        }
        int a16 = com.tencent.mobileqq.pic.a.a();
        if (!D && a16 != 0 && !z16) {
            f.b("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + a16);
            return;
        }
        p q17 = this.f258522f.q(true);
        if (q17 != null) {
            k kVar = q17.f258788m;
            if (kVar == null) {
                f.d("PIC_TAG_PRELOAD", "consume", "picReq.downInfo == null");
                E(q17.H, -4);
                return;
            }
            Map<String, Integer> map = this.f258522f.f258549j;
            map.remove(kVar.K);
            AppInterface appInterface = this.f258520d;
            k kVar2 = q17.f258788m;
            int i16 = n.i(appInterface, kVar2.f258713h, kVar2.f258715m);
            int c16 = s().c(q17.f258788m.U, i16, a16, com.tencent.mobileqq.v.c(q17.H.imageType), q17.K);
            E(q17.H, c16);
            if (c16 < 0) {
                f.b("PIC_TAG_PRELOAD", "consume", "overLimit uinType=" + i16 + " networkType=" + a16);
                if (!d.d(q17.H) && (s16 = this.f258522f.s(q17.K)) != null) {
                    s16.add(q17);
                    map.put(q17.f258788m.K, Integer.valueOf(q17.K));
                    this.f258522f.l();
                    return;
                }
                return;
            }
            if (q17.f258783d == 6 && !d.d(q17.H) && !s().d(i16, a16)[1]) {
                f.b("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uinType:" + q17.f258788m.f258713h + ", networkType:" + a16 + ", uniseq:" + q17.f258788m.D);
                Collection<p> s17 = this.f258522f.s(q17.K);
                if (s17 != null) {
                    s17.add(q17);
                    map.put(q17.f258788m.K, Integer.valueOf(q17.K));
                    this.f258522f.l();
                    return;
                }
                return;
            }
            this.f258522f.k(q17);
            if (q17.f258783d == 6 && !d.d(q17.H) && !new File(q17.f258788m.d()).exists()) {
                MessageForPic messageForPic2 = q17.H;
                if (messageForPic2 != null) {
                    i3 = n.i(this.f258520d, messageForPic2.istroop, messageForPic2.frienduin);
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                s().b(q17.f258788m.U, a16, i3);
                this.f258521e.d(a16, i3);
            }
            this.f258522f.j(new Runnable(q17) { // from class: com.tencent.mobileqq.pic.PicPreDownloader.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ p f258537d;

                {
                    this.f258537d = q17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicPreDownloader.this, (Object) q17);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        i.k(this.f258537d);
                    }
                }
            }, "consume", q17.H);
        }
        f.b("PIC_TAG_PRELOAD", "consume", "END");
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "onDestroy, receiver:" + this.f258524i);
            }
            this.f258520d.getApp().unregisterReceiver(this.f258524i);
            this.f258524i = null;
            this.f258522f.x();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, e16.getMessage());
            }
            e16.printStackTrace();
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f258522f.o(str);
        }
    }

    public int r(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageForPic)).intValue();
        }
        return this.f258522f.r(messageForPic);
    }

    public com.tencent.mobileqq.pic.operator.g s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.pic.operator.g) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f258523h;
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f258522f.v();
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f258522f.w();
        }
    }

    public void x(p pVar, c.a aVar) {
        MessageForPic messageForPic;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) pVar, (Object) aVar);
            return;
        }
        if (this.f258522f.y(pVar)) {
            if (aVar != null && aVar.f258658e != null && (messageForPic = pVar.H) != null && messageForPic.size == 0) {
                if (d.d(messageForPic)) {
                    return;
                } else {
                    s().e(messageForPic, new File(aVar.f258658e).length());
                }
            }
            n();
        }
    }
}
