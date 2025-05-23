package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.os.Handler;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.DebugKt;
import mqq.manager.Manager;

/* loaded from: classes18.dex */
public class ShortVideoPreDownloader implements Manager {
    public static long K = 86400000;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f287671d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, Integer> f287672e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f, reason: collision with root package name */
    List<v> f287673f = Collections.synchronizedList(new LinkedList());

    /* renamed from: h, reason: collision with root package name */
    List<v> f287674h = Collections.synchronizedList(new LinkedList());

    /* renamed from: i, reason: collision with root package name */
    List<v> f287675i = Collections.synchronizedList(new LinkedList());

    /* renamed from: m, reason: collision with root package name */
    List<v> f287676m = Collections.synchronizedList(new LinkedList());
    AtomicBoolean D = new AtomicBoolean(true);
    public AtomicInteger E = new AtomicInteger(0);
    PriorityBlockingQueue<v> F = new PriorityBlockingQueue<>();
    public PriorityBlockingQueue<v> G = new PriorityBlockingQueue<>();
    public AtomicInteger H = new AtomicInteger();
    Handler I = null;
    Runnable J = new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2
        @Override // java.lang.Runnable
        public void run() {
            if (!ShortVideoPreDownloader.this.D.get()) {
                ShortVideoPreDownloader.this.D.set(true);
                ShortVideoPreDownloader.o("openRunnable", "Timer count off, mIsPreDownloaderOpen=" + ShortVideoPreDownloader.this.D.get());
            }
        }
    };
    ab C = new a();

    public ShortVideoPreDownloader(QQAppInterface qQAppInterface) {
        this.f287671d = qQAppInterface;
    }

    public static boolean b(QQAppInterface qQAppInterface, MessageForShortVideo messageForShortVideo) {
        GroupMsgMask troopMask;
        com.tencent.mobileqq.app.n nVar;
        DiscussionMemberInfo l3;
        int calcUinType = ((IPicPreDownload) qQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(qQAppInterface, messageForShortVideo.istroop, messageForShortVideo.frienduin);
        if ((calcUinType == 0 || calcUinType == 1) && ((troopMask = qQAppInterface.getTroopMask(messageForShortVideo.frienduin)) == GroupMsgMask.ASSISTANT || troopMask == GroupMsgMask.SHIELD || troopMask == GroupMsgMask.RECEIVE)) {
            return false;
        }
        if (calcUinType == 2 && (nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)) != null && (l3 = nVar.l(messageForShortVideo.frienduin, qQAppInterface.getCurrentAccountUin())) != null && (l3.flag & 1) != 0) {
            return false;
        }
        return true;
    }

    private String g(long j3, List<v> list) {
        for (v vVar : list) {
            MessageForShortVideo messageForShortVideo = vVar.F;
            if (messageForShortVideo != null && messageForShortVideo.uniseq == j3) {
                this.f287673f.remove(vVar);
                return vVar.f288266f;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(String str, String str2) {
        if (QLog.isColorLevel()) {
            if (str2 == null) {
                str2 = "";
            }
            QLog.d("ShortVideoPreDownloader", 2, str + "(): " + str2);
        }
    }

    void a(MessageForShortVideo messageForShortVideo, int i3) {
        String str;
        o("add", "uniseq=" + messageForShortVideo.uniseq + " md5=" + messageForShortVideo.md5 + " priority=" + i3);
        if (messageForShortVideo.uuid == null && messageForShortVideo.md5 == null) {
            o("add", "msg.uuid and md5 are null");
            return;
        }
        if (messageForShortVideo.isSendFromLocal()) {
            o("add", "MessageRecord isSendFromLocal");
            return;
        }
        if (f(messageForShortVideo, i3)) {
            o("add", "skip uniseq:" + messageForShortVideo.uniseq + "priority:" + i3);
            return;
        }
        if (messageForShortVideo.isMultiMsg && !messageForShortVideo.isSend()) {
            SessionInfo H = MultiMsgManager.w().H();
            if (H != null) {
                int i16 = H.f179555d;
                str = H.f179557e;
            } else {
                str = messageForShortVideo.frienduin;
            }
        } else {
            str = messageForShortVideo.frienduin;
        }
        int a16 = com.tencent.mobileqq.pic.a.a();
        GroupMsgMask troopMask = this.f287671d.getTroopMask(str);
        if (a16 != 0 && troopMask == GroupMsgMask.ASSISTANT) {
            o("add", "MSG_FILTER_NUM, no need to pre download short video");
        } else {
            k(messageForShortVideo, i3);
        }
    }

    public void c() {
        o("consumeAllThumbsInPendingQueue", null);
        int a16 = com.tencent.mobileqq.pic.a.a();
        if (!((IPicPreDownload) this.f287671d.getRuntimeService(IPicPreDownload.class)).isScreenOn() && a16 != 0) {
            o("consumeAllThumbsInPendingQueue", "screenOFF, no preDownload, networkType: " + a16);
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator<v> it = ShortVideoPreDownloader.this.F.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    l.e(next, ShortVideoPreDownloader.this.f287671d);
                    if (next.f288268i != null) {
                        ShortVideoPreDownloader.o("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + next.f288268i.f288045h);
                    }
                }
                ShortVideoPreDownloader.this.F.clear();
            }
        }, 5, null, false);
    }

    public void d() {
        o("consumeShortVideo", null);
        if (!this.D.get()) {
            com.tencent.mobileqq.pic.f.b("PIC_TAG_PRELOAD", "consume", "!mIsPreDownloaderOpen.get() failed");
            return;
        }
        int i3 = this.H.get();
        if (i3 >= 1) {
            o("consumeShortVideo", "handlingNum(" + i3 + ") >= MAX_HANDLING_THREADS(1)");
            return;
        }
        final v j3 = j();
        if (j3 != null) {
            n nVar = j3.f288268i;
            if (nVar == null) {
                o("consumeShortVideo", "req.downinfo == null");
                return;
            }
            this.f287672e.remove(nVar.f288039b);
            this.G.add(j3);
            j3.H = j3.G;
            j3.G = 7;
            this.f287672e.put(j3.f288268i.f288039b, 7);
            this.H.addAndGet(1);
            j3.E = this.C;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
                @Override // java.lang.Runnable
                public void run() {
                    ShortVideoPreDownloader.o("consumeShortVideo", "start pre download short video type=" + j3.f288265e + " uniseq=" + j3.f288268i.f288045h + ", uuid=" + j3.f288268i.f288039b);
                    ShortVideoPreDownloader.this.n(j3);
                }
            }, 5, null, false);
        }
    }

    void e(final MessageForShortVideo messageForShortVideo) {
        o("consumeShortVideoThumb", null);
        String l3 = j.l(messageForShortVideo.thumbMD5, "jpg");
        if (FileUtils.fileExistsAndNotEmpty(l3)) {
            o("consumeShortVideoThumb", l3 + " exists");
            return;
        }
        final v b16 = h.b(2, messageForShortVideo.busiType);
        final n downloadInfo = messageForShortVideo.getDownloadInfo(b16.f288265e);
        downloadInfo.f288194r = l3;
        int i3 = messageForShortVideo.istroop;
        if (i3 == 0) {
            downloadInfo.f288195s = 1002;
        } else if (i3 == 3000) {
            downloadInfo.f288195s = 1006;
        } else if (i3 == 1) {
            downloadInfo.f288195s = 1004;
        } else if (i3 == 10014) {
            downloadInfo.f288195s = 1008;
        }
        downloadInfo.f288196t = 2;
        QQMessageFacade messageFacade = this.f287671d.getMessageFacade();
        if (messageFacade.K1() && messageFacade.s1().equals(messageForShortVideo.frienduin)) {
            downloadInfo.f288197u = 2;
        } else {
            downloadInfo.f288197u = 1;
        }
        b16.c(downloadInfo);
        b16.g(messageForShortVideo);
        int a16 = com.tencent.mobileqq.pic.a.a();
        if (!((IPicPreDownload) this.f287671d.getRuntimeService(IPicPreDownload.class)).isScreenOn() && a16 != 0) {
            o("consumeShortVideoThumb", "screenOFF, no preDownload, networkType: " + a16);
            this.F.add(b16);
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoPreDownloader.o("consumeShortVideoThumb", "start download thumb, fileType=" + downloadInfo.f288195s + ", uniseq:" + messageForShortVideo.uniseq);
                l.e(b16, ShortVideoPreDownloader.this.f287671d);
            }
        }, 5, null, false);
    }

    boolean f(MessageForShortVideo messageForShortVideo, int i3) {
        v vVar;
        o("filter", "uuid=" + messageForShortVideo.uuid + " uniseq=" + messageForShortVideo.uniseq + " priority=" + i3);
        Integer num = this.f287672e.get(messageForShortVideo.uuid);
        boolean z16 = false;
        if (num == null) {
            o("filter", "msg cannot be found in the PriorityMap");
            return false;
        }
        Collection<v> i16 = i(num.intValue());
        if (i16 == null) {
            o("filter", "originalRequests == null");
            return false;
        }
        synchronized (i16) {
            vVar = null;
            for (v vVar2 : i16) {
                if (vVar2.f288268i.f288045h == messageForShortVideo.uniseq) {
                    z16 = true;
                    vVar = vVar2;
                }
            }
        }
        if (z16 && i3 > num.intValue()) {
            Collection<v> i17 = i(i3);
            if (i17 != null) {
                vVar.H = vVar.G;
                vVar.G = i3;
                i16.remove(vVar);
                i17.add(vVar);
                this.f287672e.put(messageForShortVideo.uuid, Integer.valueOf(i3));
                o("filter", "Updated the short video request");
            }
        } else {
            o("filter", "No need to update the short video request");
        }
        return z16;
    }

    protected String h(long j3) {
        String g16 = g(j3, this.f287673f);
        if (g16 != null) {
            return g16;
        }
        String g17 = g(j3, this.f287675i);
        if (g17 != null) {
            return g17;
        }
        String g18 = g(j3, this.f287676m);
        if (g18 != null) {
            return g18;
        }
        String g19 = g(j3, this.f287674h);
        if (g19 != null) {
            return g19;
        }
        return null;
    }

    Collection<v> i(int i3) {
        o("getRequestsByPriority", "priority=" + i3);
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            return null;
                        }
                        return this.G;
                    }
                    return this.f287673f;
                }
                return this.f287674h;
            }
            return this.f287675i;
        }
        return this.f287676m;
    }

    v j() {
        synchronized (this.f287673f) {
            int size = this.f287673f.size();
            if (size > 0) {
                o("getShortVideoRequest", "get a short video request from AIORequests");
                int i3 = size - 1;
                v vVar = this.f287673f.get(i3);
                this.f287673f.remove(i3);
                return vVar;
            }
            synchronized (this.f287674h) {
                int size2 = this.f287674h.size();
                if (size2 > 0) {
                    o("getShortVideoRequest", "get a short video request from C2CRequests");
                    int i16 = size2 - 1;
                    v vVar2 = this.f287674h.get(i16);
                    this.f287674h.remove(i16);
                    return vVar2;
                }
                synchronized (this.f287675i) {
                    int size3 = this.f287675i.size();
                    if (size3 > 0) {
                        o("getShortVideoRequest", "get a short video request from DiscussionRequests");
                        int i17 = size3 - 1;
                        v vVar3 = this.f287675i.get(i17);
                        this.f287675i.remove(i17);
                        return vVar3;
                    }
                    synchronized (this.f287676m) {
                        int size4 = this.f287676m.size();
                        if (size4 > 0) {
                            o("getShortVideoRequest", "get a short video request from GroupRequests");
                            int i18 = size4 - 1;
                            v vVar4 = this.f287676m.get(i18);
                            this.f287676m.remove(i18);
                            return vVar4;
                        }
                        o("getShortVideoRequest", "cannot get any request");
                        return null;
                    }
                }
            }
        }
    }

    void k(MessageForShortVideo messageForShortVideo, int i3) {
        List<v> list;
        o("handleShortVideo", " START uniseq=" + messageForShortVideo.uniseq + ", uuid=" + messageForShortVideo.uuid + ", priority=" + i3);
        String j3 = j.j(messageForShortVideo, "mp4");
        if (FileUtils.fileExistsAndNotEmpty(j3)) {
            o("handleShortVideo", "Video has already existed, path=" + j3);
            return;
        }
        v c16 = h.c(this.f287671d, messageForShortVideo, 2);
        if (c16 == null) {
            return;
        }
        String str = "";
        int calcUinType = ((IPicPreDownload) this.f287671d.getRuntimeService(IPicPreDownload.class, "")).calcUinType(this.f287671d, messageForShortVideo.istroop, messageForShortVideo.frienduin);
        if (i3 == 6) {
            list = this.f287673f;
            c16.G = 6;
            if (calcUinType != 2) {
                if (calcUinType != 3) {
                    c16.H = 2;
                } else {
                    c16.H = 5;
                }
            } else {
                c16.H = 3;
            }
            str = "AIORequests";
        } else if (i3 == 1) {
            if (calcUinType != 2) {
                if (calcUinType != 3) {
                    list = this.f287676m;
                    c16.G = 2;
                    c16.H = 2;
                    str = "GroupRequests";
                } else {
                    list = this.f287674h;
                    c16.G = 5;
                    c16.H = 5;
                    str = "C2CRequests";
                }
            } else {
                list = this.f287675i;
                c16.G = 3;
                c16.H = 3;
                str = "DiscussionRequests";
            }
        } else {
            list = null;
        }
        if (list != null) {
            o("handleShortVideo", "successfully to add the short video request to " + str);
            list.add(c16);
            this.f287672e.put(c16.f288268i.f288039b, Integer.valueOf(c16.G));
        }
        int i16 = this.H.get();
        if (i16 < 1) {
            d();
            return;
        }
        o("handleShortVideo", "mHandlingNum(" + i16 + ") >= MAX_HANDLING_THREADS(1)");
    }

    public boolean l(MessageForShortVideo messageForShortVideo, boolean z16) {
        AtomicInteger atomicInteger;
        boolean z17;
        if (messageForShortVideo.videoFileStatus == 5002) {
            o("isNeedPredownload", "short video has expired");
            return false;
        }
        if (messageForShortVideo.busiType == 0) {
            atomicInteger = ShortVideoUtils.getDefaultShortVideoStrategy();
        } else {
            atomicInteger = this.E;
        }
        if (!z16 && atomicInteger.get() == 1) {
            o("isNeedPredownload", "isFromAIO=false and mIsNotPreDownloadEvenWhenEnterAIO=true");
            return false;
        }
        if (atomicInteger.get() == 2) {
            o("isNeedPredownload", "mIsNotPreDownloadEvenWhenEnterAIO=true");
            return false;
        }
        if (messageForShortVideo.istroop == 0 && messageForShortVideo.msgtype == -2071) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && System.currentTimeMillis() - (messageForShortVideo.time * 1000) > K) {
            o("isNeedPredownload", "out of validity, no need to pre download");
            return false;
        }
        int a16 = com.tencent.mobileqq.pic.a.a();
        if (z17) {
            if (a16 != 0 && a16 != 1) {
                o("isNeedPredownload", "Not Wifi or 4G, networkType=" + a16 + ", no need to predownload for lightvideo");
                return false;
            }
        } else if (a16 != 0) {
            o("isNeedPredownload", "Not Wifi, networkType=" + a16 + ", no need to predownload");
            return false;
        }
        return b(this.f287671d, messageForShortVideo);
    }

    public boolean m(MessageForShortVideo messageForShortVideo) {
        boolean z16;
        if (messageForShortVideo.videoFileStatus == 5002) {
            o("isNeedPredownloadThumb", "short video has expired");
            return false;
        }
        if (System.currentTimeMillis() - (messageForShortVideo.time * 1000) > K) {
            o("isNeedPredownloadThumb", "out of validity, no need to pre download");
            return false;
        }
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1 && !readValue) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!((IPicPreDownload) this.f287671d.getRuntimeService(IPicPreDownload.class)).getPreDownSwitch() && !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(v vVar) {
        l.e(vVar, this.f287671d);
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + vVar.F.busiType);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        o(MosaicConstants$JsFunction.FUNC_ON_DESTROY, null);
        Handler handler = this.I;
        if (handler != null) {
            handler.removeCallbacks(this.J);
            this.I = null;
        }
    }

    public void p() {
        o(DebugKt.DEBUG_PROPERTY_VALUE_OFF, "mIsPreDownloaderOpen=" + this.D.get());
        this.D.set(false);
        Handler handler = this.I;
        if (handler != null) {
            handler.removeCallbacks(this.J);
        } else {
            this.I = new Handler(ThreadManagerV2.getSubThreadLooper());
        }
        this.I.postDelayed(this.J, 60000L);
    }

    public void q(MessageForShortVideo messageForShortVideo) {
        o("productFromMsg", "uniseq:" + messageForShortVideo.uniseq + ", md5=" + messageForShortVideo.md5);
        boolean l3 = l(messageForShortVideo, false);
        if (l3) {
            a(messageForShortVideo, 1);
        }
        if (!l3 && m(messageForShortVideo)) {
            e(messageForShortVideo);
        }
    }

    public void r(MessageForShortVideo messageForShortVideo) {
        String h16 = h(messageForShortVideo.uniseq);
        if (h16 != null) {
            this.f287672e.remove(h16);
        }
    }

    /* loaded from: classes18.dex */
    class a implements ab {
        a() {
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void onUpdateProgress(int i3) {
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void a(int i3, y yVar) {
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void b(int i3, ArrayList<y> arrayList) {
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void c(int i3, y yVar) {
        }
    }
}
