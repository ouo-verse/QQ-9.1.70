package com.tencent.mobileqq.pic;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.media.pic.config.api.IGuildDownRequest;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

/* loaded from: classes16.dex */
public class PicPreDownloaderCore {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f258540a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f258541b;

    /* renamed from: c, reason: collision with root package name */
    private w f258542c;

    /* renamed from: d, reason: collision with root package name */
    private PicPreDownloader f258543d;

    /* renamed from: e, reason: collision with root package name */
    private MqqHandler f258544e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f258545f;

    /* renamed from: g, reason: collision with root package name */
    private AtomicBoolean f258546g;

    /* renamed from: h, reason: collision with root package name */
    private PriorityBlockingQueue<p> f258547h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentLinkedQueue<PicPreDownRunner> f258548i;

    /* renamed from: j, reason: collision with root package name */
    protected Map<String, Integer> f258549j;

    /* renamed from: k, reason: collision with root package name */
    private final List<p> f258550k;

    /* renamed from: l, reason: collision with root package name */
    private final List<p> f258551l;

    /* renamed from: m, reason: collision with root package name */
    private final List<p> f258552m;

    /* renamed from: n, reason: collision with root package name */
    private final List<p> f258553n;

    /* renamed from: o, reason: collision with root package name */
    private final List<p> f258554o;

    /* loaded from: classes16.dex */
    public class PicPreDownRunner implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Runnable f258556d;

        /* renamed from: e, reason: collision with root package name */
        String f258557e;

        PicPreDownRunner(Runnable runnable, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PicPreDownloaderCore.this, runnable, str);
            } else {
                this.f258556d = runnable;
                this.f258557e = str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f258556d.run();
            PicPreDownloaderCore.this.f258540a.decrementAndGet();
            PicPreDownloaderCore.this.z();
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "PicPreDownloader ," + this.f258557e;
        }
    }

    public PicPreDownloaderCore(PicPreDownloader picPreDownloader, w wVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) picPreDownloader, (Object) wVar);
            return;
        }
        this.f258540a = new AtomicInteger();
        this.f258541b = new AtomicInteger();
        this.f258546g = new AtomicBoolean(false);
        this.f258547h = new PriorityBlockingQueue<>();
        this.f258548i = new ConcurrentLinkedQueue<>();
        this.f258549j = Collections.synchronizedMap(new HashMap());
        this.f258550k = Collections.synchronizedList(new LinkedList());
        this.f258551l = Collections.synchronizedList(new LinkedList());
        this.f258552m = ((IGuildDownRequest) QRoute.api(IGuildDownRequest.class)).getRequest();
        this.f258553n = Collections.synchronizedList(new LinkedList());
        this.f258554o = Collections.synchronizedList(new LinkedList());
        this.f258543d = picPreDownloader;
        this.f258542c = wVar;
        this.f258544e = ThreadManager.getSubThreadHandler();
        this.f258545f = new Runnable() { // from class: com.tencent.mobileqq.pic.PicPreDownloaderCore.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicPreDownloaderCore.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!PicPreDownloaderCore.this.f258546g.get()) {
                    PicPreDownloaderCore.this.f258546g.set(true);
                    f.b("PIC_TAG_PRELOAD", "timer count off, picPreDownload set on", "mIsPicPreloadSuitable" + PicPreDownloaderCore.this.f258546g.get());
                }
            }
        };
    }

    private p n(String str, Collection<p> collection) {
        synchronized (collection) {
            for (p pVar : collection) {
                k kVar = pVar.f258788m;
                if (kVar != null) {
                    boolean z16 = true;
                    if (kVar.R != 1) {
                        z16 = false;
                    }
                    int fileSizeType = ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(pVar.f258788m.I, z16);
                    k kVar2 = pVar.f258788m;
                    String makeReceiveKey = BaseTransFileController.makeReceiveKey(kVar2.J, kVar2.K, fileSizeType);
                    if (str != null && str.equals(makeReceiveKey)) {
                        collection.remove(pVar);
                        this.f258549j.remove(pVar.f258788m.K);
                        this.f258543d.E(pVar.H, -5);
                        return pVar;
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        PicPreDownRunner poll;
        if (this.f258540a.get() < 3 && (poll = this.f258548i.poll()) != null) {
            this.f258540a.incrementAndGet();
            ThreadManagerV2.excute(poll, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(p pVar, int i3, int i16) {
        List<p> list;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, pVar, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 == 6) {
            list = this.f258550k;
            pVar.K = 6;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        pVar.L = 2;
                    } else {
                        pVar.L = 4;
                    }
                } else {
                    pVar.L = 5;
                }
            } else {
                pVar.L = 3;
            }
            str = "AIORequests";
        } else if (i16 == 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        list = this.f258554o;
                        pVar.K = 2;
                        pVar.L = 2;
                        str = "GroupRequests";
                    } else {
                        list = this.f258552m;
                        pVar.K = 4;
                        pVar.L = 4;
                        str = "GuildRequests";
                    }
                } else {
                    list = this.f258551l;
                    pVar.K = 5;
                    pVar.L = 5;
                    str = "C2CRequests";
                }
            } else {
                list = this.f258553n;
                pVar.K = 3;
                pVar.L = 3;
                str = "DiscussionRequests";
            }
        } else {
            list = null;
            str = "";
        }
        if (list != null) {
            f.b("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + str);
            list.add(pVar);
            l();
            this.f258549j.put(pVar.f258788m.K, Integer.valueOf(pVar.K));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Runnable runnable, String str, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, runnable, str, messageRecord);
            return;
        }
        if (messageRecord != null) {
            str = str + ", msgSeq = " + messageRecord.shmsgseq;
        }
        this.f258548i.offer(new PicPreDownRunner(runnable, str));
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(p pVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) pVar);
            return;
        }
        this.f258547h.add(pVar);
        pVar.L = pVar.K;
        pVar.K = 7;
        this.f258549j.put(pVar.f258788m.K, 7);
        if (pVar.f258783d == 6) {
            str = " big";
        } else {
            str = " thumb";
        }
        f.b("PIC_TAG_PRELOAD", "addToHandlingQueue, cmdStr:" + str, ", uniseq:" + pVar.f258788m.D + ", subMsgId:" + pVar.f258788m.f258724a0 + ", priority:" + pVar.K);
        this.f258541b.addAndGet(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        p pVar;
        p remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f258550k.size() + this.f258551l.size() + this.f258553n.size() + this.f258554o.size() + this.f258552m.size() > this.f258542c.f258845a0.longValue()) {
            synchronized (this.f258554o) {
                if (this.f258554o.size() > 0) {
                    pVar = this.f258554o.remove(0);
                } else {
                    synchronized (this.f258553n) {
                        if (this.f258553n.size() > 0) {
                            remove = this.f258553n.remove(0);
                        } else {
                            synchronized (this.f258552m) {
                                if (this.f258552m.size() > 0) {
                                    pVar = this.f258552m.remove(0);
                                } else {
                                    synchronized (this.f258551l) {
                                        if (this.f258551l.size() > 0) {
                                            remove = this.f258551l.remove(0);
                                        } else {
                                            synchronized (this.f258550k) {
                                                if (this.f258550k.size() > 0) {
                                                    pVar = this.f258550k.remove(0);
                                                } else {
                                                    pVar = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    pVar = remove;
                }
            }
            if (pVar != null) {
                this.f258549j.remove(pVar.f258788m.K);
                this.f258542c.Q++;
                f.b("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.f258542c.f258845a0 + ", remove a request");
            }
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        try {
            int size = this.f258550k.size();
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): AIORequests size=" + size);
            }
            ThreadManagerV2.excute(new Runnable(size) { // from class: com.tencent.mobileqq.pic.PicPreDownloaderCore.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f258555d;

                {
                    this.f258555d = size;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicPreDownloaderCore.this, size);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        synchronized (PicPreDownloaderCore.this.f258550k) {
                            int i3 = 0;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            for (p pVar : PicPreDownloaderCore.this.f258550k) {
                                int i19 = pVar.L;
                                if (i19 != 3) {
                                    if (i19 != 4) {
                                        if (i19 == 5) {
                                            i17++;
                                            pVar.K = i19;
                                            PicPreDownloaderCore.this.f258549j.put(pVar.f258788m.K, Integer.valueOf(i19));
                                            PicPreDownloaderCore.this.f258551l.add(0, pVar);
                                        }
                                    } else {
                                        i16++;
                                        pVar.K = i19;
                                        PicPreDownloaderCore.this.f258549j.put(pVar.f258788m.K, Integer.valueOf(i19));
                                        PicPreDownloaderCore.this.f258552m.add(0, pVar);
                                    }
                                    i18++;
                                    int i26 = pVar.L;
                                    pVar.K = i26;
                                    PicPreDownloaderCore.this.f258549j.put(pVar.f258788m.K, Integer.valueOf(i26));
                                    PicPreDownloaderCore.this.f258554o.add(0, pVar);
                                } else {
                                    i3++;
                                    pVar.K = i19;
                                    PicPreDownloaderCore.this.f258549j.put(pVar.f258788m.K, Integer.valueOf(i19));
                                    PicPreDownloaderCore.this.f258553n.add(0, pVar);
                                }
                                int i27 = pVar.L;
                                pVar.K = i27;
                                PicPreDownloaderCore.this.f258549j.put(pVar.f258788m.K, Integer.valueOf(i27));
                            }
                            PicPreDownloaderCore.this.f258550k.clear();
                            if (QLog.isColorLevel()) {
                                QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): totalCount=" + this.f258555d + " countOfC2C=" + i17 + " countOfDiscussion=" + i3 + " countOfGroup=" + i18 + " countOfGuild=" + i16);
                            }
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 16, null, false);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): exception=" + e16.getMessage());
            }
        }
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        p n3 = n(str, this.f258550k);
        if (n3 != null) {
            f.c("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + n3.f258788m.D + ",key:" + str + ",cmd:" + n3.f258783d);
            return;
        }
        p n16 = n(str, this.f258551l);
        if (n16 != null) {
            f.c("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + n16.f258788m.D + ",key:" + str + ",cmd:" + n16.f258783d);
            return;
        }
        p n17 = n(str, this.f258552m);
        if (n17 != null) {
            f.c("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + n17.f258788m.D + ",key:" + str + ",cmd:" + n17.f258783d);
            return;
        }
        p n18 = n(str, this.f258553n);
        if (n18 != null) {
            f.c("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + n18.f258788m.D + ",key:" + str + ",cmd:" + n18.f258783d);
            return;
        }
        p n19 = n(str, this.f258554o);
        if (n19 != null) {
            f.c("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + n19.f258788m.D + ",key:" + str + ",cmd:" + n19.f258783d);
            return;
        }
        f.c("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(MessageForPic messageForPic, int i3) {
        p pVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) messageForPic, i3)).booleanValue();
        }
        Integer num = this.f258549j.get(messageForPic.uuid);
        boolean z16 = false;
        if (num == null) {
            f.b("PIC_TAG_PRELOAD", "filter", "uuid=" + messageForPic.uuid + ", priority=" + i3 + ", cannot be found in the PriorityMap");
            return false;
        }
        Collection<p> s16 = s(num.intValue());
        f.b("PIC_TAG_PRELOAD", "filter", "priority: " + i3 + ", uniseq: " + messageForPic.uniseq + ", subMsgId:" + messageForPic.subMsgId);
        if (s16 == null) {
            f.b("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
            return false;
        }
        synchronized (s16) {
            pVar = null;
            for (p pVar2 : s16) {
                if (messageForPic.subMsgId == pVar2.f258788m.f258724a0) {
                    z16 = true;
                    pVar = pVar2;
                }
            }
        }
        if (z16 && i3 > num.intValue()) {
            Collection<p> s17 = s(i3);
            if (s17 != null) {
                pVar.L = pVar.K;
                pVar.K = i3;
                s16.remove(pVar);
                s17.add(pVar);
                this.f258549j.put(messageForPic.uuid, Integer.valueOf(i3));
                f.b("PIC_TAG_PRELOAD", "filter", "update the picReq");
            }
        } else {
            f.b("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p q(boolean z16) {
        synchronized (this.f258550k) {
            int size = this.f258550k.size();
            if (size > 0) {
                f.b("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
                int i3 = size - 1;
                p pVar = this.f258550k.get(i3);
                if (z16) {
                    this.f258550k.remove(i3);
                }
                return pVar;
            }
            synchronized (this.f258551l) {
                int size2 = this.f258551l.size();
                if (size2 > 0) {
                    f.b("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
                    int i16 = size2 - 1;
                    p pVar2 = this.f258551l.get(i16);
                    if (z16) {
                        this.f258551l.remove(i16);
                    }
                    return pVar2;
                }
                synchronized (this.f258552m) {
                    int size3 = this.f258552m.size();
                    if (size3 > 0) {
                        f.b("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GuildRequests");
                        int i17 = size3 - 1;
                        p pVar3 = this.f258552m.get(i17);
                        if (z16) {
                            this.f258552m.remove(i17);
                        }
                        return pVar3;
                    }
                    synchronized (this.f258553n) {
                        int size4 = this.f258553n.size();
                        if (size4 > 0) {
                            f.b("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
                            int i18 = size4 - 1;
                            p pVar4 = this.f258553n.get(i18);
                            if (z16) {
                                this.f258553n.remove(i18);
                            }
                            return pVar4;
                        }
                        synchronized (this.f258554o) {
                            int size5 = this.f258554o.size();
                            if (size5 > 0) {
                                f.b("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
                                int i19 = size5 - 1;
                                p pVar5 = this.f258554o.get(i19);
                                if (z16) {
                                    this.f258554o.remove(i19);
                                }
                                return pVar5;
                            }
                            f.b("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
                            return null;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int r(MessageForPic messageForPic) {
        Collection<p> s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) messageForPic)).intValue();
        }
        Integer num = this.f258549j.get(messageForPic.uuid);
        if (num != null && (s16 = s(num.intValue())) != null) {
            synchronized (s16) {
                Iterator<p> it = s16.iterator();
                while (it.hasNext()) {
                    if (messageForPic.subMsgId == it.next().f258788m.f258724a0) {
                        f.b("PIC_TAG_PRELOAD", "getPriority", "uuid: " + messageForPic.uuid + " subMsgId: " + messageForPic.subMsgId);
                        return num.intValue();
                    }
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<p> s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Collection) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        f.b("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + i3);
        switch (i3) {
            case 2:
                return this.f258554o;
            case 3:
                return this.f258553n;
            case 4:
                return this.f258552m;
            case 5:
                return this.f258551l;
            case 6:
                return this.f258550k;
            case 7:
                return this.f258547h;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.f258541b.get() < 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f258546g.get();
    }

    public void v() {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f258546g.set(false);
        f.b("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.f258546g.get());
        MqqHandler mqqHandler = this.f258544e;
        if (mqqHandler != null && (runnable = this.f258545f) != null) {
            mqqHandler.removeCallbacks(runnable);
            this.f258544e.postDelayed(this.f258545f, 60000L);
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f258546g.set(true);
        f.b("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.f258546g.get());
        this.f258543d.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        MqqHandler mqqHandler = this.f258544e;
        if (mqqHandler != null && (runnable = this.f258545f) != null) {
            mqqHandler.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) pVar)).booleanValue();
        }
        if (this.f258547h.contains(pVar)) {
            this.f258547h.remove(pVar);
            this.f258541b.decrementAndGet();
            this.f258549j.remove(pVar.f258788m.K);
            f.b("PIC_TAG_PRELOAD", "onDownload", "decrement, uniseq:" + pVar.f258788m.D + ", cmd:" + pVar.f258783d + ", curHandingNum:" + this.f258541b.get());
            return true;
        }
        f.b("PIC_TAG_PRELOAD", "onDownload", "not contains, uniseq:" + pVar.f258788m.D + ", cmd:" + pVar.f258783d + ", curHandingNum:" + this.f258541b.get());
        return false;
    }
}
