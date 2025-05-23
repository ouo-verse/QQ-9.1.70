package com.tencent.mobileqq.pic.operator.multipic;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends com.tencent.mobileqq.pic.operator.d {
    static IPatchRedirector $redirector_;
    protected static int H;
    public ArrayList<q> E;
    protected ArrayList<l> F;
    protected int G;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f258768a;

        /* renamed from: b, reason: collision with root package name */
        public String f258769b;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<AppInterface> f258770c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<q> f258771d;

        /* renamed from: e, reason: collision with root package name */
        List<l> f258772e;

        /* renamed from: f, reason: collision with root package name */
        final RichProtoProc.RichProtoCallback f258773f;

        public a(AppInterface appInterface, List<l> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, appInterface, list);
                return;
            }
            this.f258768a = c.this.f258749d;
            this.f258769b = c.this.f258750e;
            this.f258770c = new WeakReference<>(appInterface);
            this.f258772e = list;
            this.f258771d = new ArrayList<>(list.size());
            for (int i3 = 0; i3 < list.size(); i3++) {
                q qVar = new q();
                qVar.f258792c = c.this.f258751f;
                this.f258771d.add(qVar);
            }
            this.f258773f = new d(this, ((com.tencent.mobileqq.pic.operator.a) c.this).f258752h, this.f258770c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            boolean z16;
            boolean z17;
            URL url;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
            int i3 = 0;
            while (true) {
                String str = null;
                if (i3 >= this.f258772e.size()) {
                    break;
                }
                l lVar = this.f258772e.get(i3);
                RichProto.RichProtoReq.PicUpReq picUpReq = new RichProto.RichProtoReq.PicUpReq();
                picUpReq.selfUin = this.f258770c.get().getAccount();
                picUpReq.peerUin = ((com.tencent.mobileqq.pic.operator.a) c.this).f258752h.frienduin;
                picUpReq.uinType = ((com.tencent.mobileqq.pic.operator.a) c.this).f258752h.istroop;
                picUpReq.secondUin = ((com.tencent.mobileqq.pic.operator.a) c.this).f258752h.senderuin;
                if (picUpReq.uinType == 1006) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                picUpReq.isContact = z16;
                picUpReq.md5 = HexUtil.hexStr2Bytes(lVar.f258731f.J);
                v vVar = lVar.f258731f;
                if (vVar.f258818d0 == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                picUpReq.isRaw = z17;
                if (lVar.f258734m == 2) {
                    picUpReq.isRaw = true;
                }
                if (vVar.f258815a0 != 0 && vVar.f258816b0 != 0 && 0 != vVar.f258817c0) {
                    c cVar = c.this;
                    f.c(cVar.f258750e, cVar.f258749d, "uploadForwardMultiMsgPics", "[" + i3 + "] Get width/height/filesize from UploadInfo");
                    v vVar2 = lVar.f258731f;
                    picUpReq.width = vVar2.f258815a0;
                    picUpReq.height = vVar2.f258816b0;
                    picUpReq.fileSize = vVar2.f258817c0;
                } else {
                    c cVar2 = c.this;
                    f.c(cVar2.f258750e, cVar2.f258749d, "uploadForwardMultiMsgPics", "[" + i3 + "] Get width/height/filesize from File");
                    if (FileUtils.fileExistsAndNotEmpty(lVar.f258731f.K)) {
                        str = lVar.f258731f.K;
                    } else {
                        if (picUpReq.isRaw) {
                            url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(lVar, 131075, (String) null);
                        } else {
                            url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(lVar, 1, (String) null);
                        }
                        if (url != null) {
                            str = AbsDownloader.getFilePath(url.toString());
                        }
                    }
                    if (FileUtils.fileExistsAndNotEmpty(str)) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        SafeBitmapFactory.decodeFile(str, options);
                        picUpReq.width = options.outWidth;
                        picUpReq.height = options.outHeight;
                        picUpReq.fileSize = FileUtils.getFileSizes(str);
                    } else {
                        c cVar3 = c.this;
                        f.f(cVar3.f258750e, cVar3.f258749d, "uploadForwardMultiMsgPics", "[" + i3 + "] Get width/height/filesize from File failed, targetPicFilepath = " + str);
                    }
                }
                int i16 = picUpReq.uinType;
                if (i16 != 1 && i16 != 3000) {
                    c cVar4 = c.this;
                    f.f(cVar4.f258750e, cVar4.f258749d, "uploadForwardMultiMsgPics", "[" + i3 + "] is C2C message");
                    richProtoReq.protoKey = RichProtoProc.C2C_PIC_UP;
                } else {
                    c cVar5 = c.this;
                    f.f(cVar5.f258750e, cVar5.f258749d, "uploadForwardMultiMsgPics", "[" + i3 + "] is Troop/Discussion message");
                    richProtoReq.protoKey = RichProtoProc.GRP_PIC_UP;
                }
                picUpReq.fileName = lVar.f258731f.J;
                richProtoReq.reqs.add(picUpReq);
                i3++;
            }
            if (!richProtoReq.reqs.isEmpty()) {
                richProtoReq.callback = this.f258773f;
                richProtoReq.protoReqMgr = (IProtoReqManager) this.f258770c.get().getRuntimeService(IProtoReqManager.class, "");
                c cVar6 = c.this;
                f.f(cVar6.f258750e, cVar6.f258749d, "uploadForwardMultiMsgPics", "requestStart:" + richProtoReq.toString());
                RichProtoProc.procRichProtoReq(richProtoReq);
            } else {
                c();
            }
            return null;
        }

        public void b(q qVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                c.this.e(6, 0, qVar);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            c.this.E.addAll(this.f258771d);
            c.this.z();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34919);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            H = 20;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void A(ArrayList<l> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList.get(0).f258730e = true;
            this.f258752h = p(arrayList.get(0));
            this.E = new ArrayList<>(arrayList.size());
            this.F = arrayList;
            this.G = 0;
            System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] start");
            }
            z();
            return;
        }
        QLog.e("MultiPicsOperator", 1, "[uploadForwardMultiMsgPics] error, infoList is null");
        e(5, -1, null);
    }

    @Override // com.tencent.mobileqq.pic.operator.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            A(this.f258751f.F);
        }
    }

    public l x(MessageForPic messageForPic, int i3, String str, String str2, String str3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (l) iPatchRedirector.redirect((short) 5, this, messageForPic, Integer.valueOf(i3), str, str2, str3);
        }
        if (messageForPic == null || i3 < 0 || str == null || str2 == null || str3 == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(messageForPic, !(com.tencent.mobileqq.utils.c.h(messageForPic.msgtype) || (i16 = messageForPic.msgtype) == -3001 || i16 == -30002 || i16 == -30003) ? 65537 : 1, (String) null);
        String url2 = url != null ? url.toString() : null;
        l lVar = new l();
        lVar.f258733i = messageForPic.isSendFromLocal();
        v.a aVar = new v.a();
        aVar.m(1009);
        aVar.v(messageForPic.path);
        aVar.B(str3);
        aVar.y(10);
        aVar.J((int) messageForPic.width);
        aVar.s((int) messageForPic.height);
        f.c(this.f258750e, this.f258749d, "createForwardPicInfo", "picMsg.width = " + messageForPic.width + ",picMsg.height = " + messageForPic.height);
        aVar.p((long) ((int) messageForPic.size));
        aVar.q(messageForPic.fileSizeFlag);
        aVar.G(messageForPic.thumbWidth);
        aVar.E(messageForPic.thumbHeight);
        aVar.u(messageForPic.imageType);
        File file = AbsDownloader.getFile(url2);
        if (file != null) {
            aVar.F(file.getAbsolutePath());
        }
        aVar.I(i3);
        aVar.A(str);
        aVar.x(str2);
        aVar.w(messageForPic.md5);
        v l3 = aVar.l();
        lVar.f258731f = l3;
        l3.f258711e = messageForPic.localUUID;
        l3.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
        if (l3.R < 0 && com.tencent.mobileqq.v.d(messageForPic.path)) {
            bm.a();
            try {
                l3.P = com.tencent.mobileqq.v.b(messageForPic.path);
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos\uff0c " + messageForPic.path + "'s size is " + FileUtils.getFileSizes(messageForPic.path));
                }
            }
            bm.b("peak_pgjpeg", "PeakUtils.getSliceInfos(" + messageForPic.path + ")");
        }
        if (messageForPic.isMultiMsg || !FileUtils.fileExistsAndNotEmpty(messageForPic.path)) {
            k.a aVar2 = new k.a();
            aVar2.j(1009);
            aVar2.n(str3);
            aVar2.m(messageForPic.frienduin);
            aVar2.p(messageForPic.istroop);
            aVar2.r(messageForPic.uuid);
            aVar2.q(messageForPic.uniseq);
            aVar2.l(messageForPic.md5);
            aVar2.k(messageForPic.issend);
            aVar2.o(messageForPic.time);
            k i17 = aVar2.i();
            lVar.f258732h = i17;
            i17.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
            i17.R = messageForPic.fileSizeFlag;
            i17.L = messageForPic.groupFileID;
        }
        f.c(this.f258750e, this.f258749d, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        String str4 = this.f258750e;
        String str5 = this.f258749d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("retry:");
        sb5.append(lVar.f258731f.A0 != null);
        f.c(str4, str5, "createForwardPicInfo", sb5.toString());
        return lVar;
    }

    public ArrayList<l> y(MessageRecord messageRecord, int i3, String str, String str2, String str3) {
        List<MessageRecord> elementList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, this, messageRecord, Integer.valueOf(i3), str, str2, str3);
        }
        if (messageRecord == null || i3 < 0 || str == null || str2 == null || str3 == null || (elementList = ((IMsgMixed) QRoute.api(IMsgMixed.class)).getElementList(messageRecord)) == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<l> arrayList = new ArrayList<>();
        for (MessageRecord messageRecord2 : elementList) {
            if (messageRecord2 instanceof MessageForPic) {
                arrayList.add(x((MessageForPic) messageRecord2, i3, str, str2, str3));
            }
        }
        f.c(this.f258750e, this.f258749d, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    public void z() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.G >= this.F.size()) {
            QLog.i("MultiPicsOperator", 1, String.format("createPicsUploadTask total:%d finished and notifyUI", Integer.valueOf(this.F.size())));
            e(5, 0, this.E);
            return;
        }
        if (this.G + H < this.F.size()) {
            size = this.G + H;
        } else {
            size = this.F.size();
        }
        QLog.i("MultiPicsOperator", 1, String.format("createPicsUploadTask startIdx:%d, finishIdx:%d", Integer.valueOf(this.G), Integer.valueOf(size)));
        List<l> subList = this.F.subList(this.G, size);
        this.G = size;
        new a(this.f258754m, subList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
