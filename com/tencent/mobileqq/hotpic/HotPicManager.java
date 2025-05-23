package com.tencent.mobileqq.hotpic;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.CommonEmoticonConstans;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.hotpicmsg.HotPicMsg$GetImgInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg$GetImgInfoRsp;
import com.tencent.pb.hotpicmsg.HotPicMsg$GetVideoInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg$ImgInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg$ReqBody;
import com.tencent.pb.hotpicmsg.HotPicMsg$RspBody;
import com.tencent.pb.hotpicmsg.HotPicMsg$TagInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg$ThirdPartyInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.manager.Manager;

/* loaded from: classes9.dex */
public class HotPicManager implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    private WeakReferenceHandler C;
    private EntityManager D;
    private SparseArray<ArrayList<HotPicData>> E;
    private SparseArray<ArrayList<HotPicData>> F;
    private List<HotPicTagInfo> G;
    private List<HotPicTagInfo> H;
    private LinkedList<HotPicSendData> I;
    f J;
    boolean K;
    private boolean L;
    public int M;
    private boolean N;
    Object P;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f236939d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f236940e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f236941f;

    /* renamed from: h, reason: collision with root package name */
    Set<Integer> f236942h;

    /* renamed from: i, reason: collision with root package name */
    boolean f236943i;

    /* renamed from: m, reason: collision with root package name */
    boolean f236944m;

    public HotPicManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f236940e = false;
        this.f236941f = false;
        this.f236942h = new HashSet();
        this.f236943i = true;
        this.f236944m = false;
        this.C = new WeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this);
        this.E = new SparseArray<>();
        this.F = new SparseArray<>();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new LinkedList<>();
        this.K = false;
        this.L = false;
        this.N = false;
        this.P = new Object();
        this.f236939d = qQAppInterface;
    }

    private synchronized void E(List<HotPicData> list, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("HotPicManager", 2, "updateHotPicData " + z16);
        }
        if (z16) {
            this.D.drop(HotPicData.class);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<HotPicData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PersistOrReplaceTransaction(it.next()));
        }
        if (!this.D.doMultiDBOperateByTransaction(arrayList)) {
            QLog.w("HotPicManager", 1, "updateHotPicData, failed");
        }
    }

    private synchronized void F(ArrayList<HotPicTagInfo> arrayList) {
        this.D.drop(HotPicTagInfo.class);
        Iterator it = ((ArrayList) arrayList.clone()).iterator();
        while (it.hasNext()) {
            this.D.persistOrReplace((HotPicTagInfo) it.next());
        }
    }

    private void h(List<HotPicTagInfo> list, int i3) {
        HotPicTagInfo hotPicTagInfo = new HotPicTagInfo();
        hotPicTagInfo.tagName = this.f236939d.getApp().getString(R.string.fkj);
        hotPicTagInfo.version = i3;
        hotPicTagInfo.tagId = 2;
        hotPicTagInfo.tagType = 1;
        hotPicTagInfo.position = 0;
        list.add(hotPicTagInfo);
        HotPicTagInfo hotPicTagInfo2 = new HotPicTagInfo();
        hotPicTagInfo2.tagName = this.f236939d.getApp().getString(R.string.fkk);
        hotPicTagInfo2.version = i3;
        hotPicTagInfo2.tagId = -20;
        hotPicTagInfo2.tagType = 255;
        hotPicTagInfo2.position = 1;
        list.add(hotPicTagInfo2);
    }

    public static HotPicManager i(QQAppInterface qQAppInterface) {
        return (HotPicManager) qQAppInterface.getManager(QQManagerFactory.HOT_PIC_MANAGER);
    }

    public static Manager k(QQAppInterface qQAppInterface) {
        return qQAppInterface.getManager(QQManagerFactory.HOT_PIC_MANAGER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(HotPicSendData hotPicSendData, HotPicSendData hotPicSendData2) {
        this.D.persistOrReplace(hotPicSendData);
        if (hotPicSendData2 != null) {
            this.D.remove(hotPicSendData2);
        }
    }

    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.L = z16;
        }
    }

    public void B(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) fVar);
        } else {
            this.J = fVar;
        }
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!this.f236943i && !this.f236944m) {
            this.f236939d.getApplication().getSharedPreferences("sp_hotpic_" + this.f236939d.getCurrentUin(), 0);
            this.f236944m = true;
        }
        return this.f236943i;
    }

    public boolean D() {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.H.size() <= 0) {
            return false;
        }
        synchronized (this.P) {
            this.G.clear();
            this.E.clear();
            for (HotPicTagInfo hotPicTagInfo : this.H) {
                int i3 = hotPicTagInfo.tagId;
                this.G.add(hotPicTagInfo);
                ArrayList<HotPicData> arrayList = this.F.get(i3);
                SparseArray<ArrayList<HotPicData>> sparseArray = this.E;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                sparseArray.put(i3, arrayList);
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[1];
                if (("update NewVersionTagInfo" + this.H.get(0)) == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(this.H.get(0).version);
                }
                objArr[0] = valueOf;
                QLog.d("HotPicManager", 2, objArr);
            }
            this.F.clear();
            this.H.clear();
        }
        this.K = true;
        this.C.sendEmptyMessage(101);
        return true;
    }

    public void c(HotPicData hotPicData) {
        final HotPicSendData build;
        final HotPicSendData hotPicSendData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) hotPicData);
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.I.size()) {
                if (this.I.get(i3).md5.equals(hotPicData.md5)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            this.I.remove(i3);
        }
        if (hotPicData instanceof HotPicSendData) {
            build = (HotPicSendData) hotPicData;
        } else {
            build = HotPicSendData.build(hotPicData);
        }
        build.sendTime = NetConnInfoCenter.getServerTime();
        this.I.addFirst(build);
        if (this.I.size() > 500) {
            hotPicSendData = this.I.removeLast();
        } else {
            hotPicSendData = null;
        }
        f fVar = this.J;
        if (fVar != null) {
            fVar.a(8, -20, 0);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.hotpic.g
            @Override // java.lang.Runnable
            public final void run() {
                HotPicManager.this.r(build, hotPicSendData);
            }
        }, 32, null, false);
    }

    public synchronized boolean d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        ArrayList<HotPicData> arrayList = this.E.get(i3);
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        return this.f236942h.contains(Integer.valueOf(i3));
    }

    boolean f(int i3) {
        List<HotPicTagInfo> list = this.G;
        if (list == null) {
            return false;
        }
        for (HotPicTagInfo hotPicTagInfo : list) {
            if (hotPicTagInfo.tagId == i3 && hotPicTagInfo.tagType == 2) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.f236942h.clear();
            this.C.sendEmptyMessageDelayed(103, 10000L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 101) {
            F(p());
            E(j(), true);
            return true;
        }
        if (i3 == 104) {
            F(p());
        } else if (i3 == 103 && this.J == null) {
            for (HotPicData hotPicData : j()) {
                if (this.J != null) {
                    break;
                }
                try {
                    if (hotPicData.getDataType() != 2 && (url = b.getURL(hotPicData.url)) != null) {
                        URLDrawable.removeMemoryCacheByUrl(url.toString());
                    }
                } catch (Exception unused) {
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager", 2, "clear urldrawable cache");
            }
        }
        return false;
    }

    List<HotPicData> j() {
        ArrayList<HotPicData> valueAt;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            if (!f(this.E.keyAt(i3)) && (valueAt = this.E.valueAt(i3)) != null && valueAt.size() > 0) {
                arrayList.addAll(valueAt);
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<HotPicData> l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        ArrayList<HotPicData> arrayList = this.E.get(i3);
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<HotPicData> arrayList2 = (ArrayList) arrayList.clone();
        if (f(i3)) {
            Iterator<HotPicData> it = arrayList2.iterator();
            while (it.hasNext()) {
                HotPicData next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("HotPicManager", 2, "getHotPics IsVideo " + next.toString());
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager", 2, "getHotPics IsVideo size:" + arrayList2.size());
            }
        }
        return arrayList2;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f236939d.getApplication().getSharedPreferences("sp_hotpic_" + this.f236939d.getCurrentUin(), 0).getInt("hot_pic_last_click", -1);
    }

    int n() {
        synchronized (this.P) {
            Iterator<HotPicTagInfo> it = this.G.iterator();
            while (it.hasNext()) {
                int i3 = it.next().version;
                if (i3 != 0) {
                    return i3;
                }
            }
            return 0;
        }
    }

    public LinkedList<HotPicSendData> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LinkedList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.I;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        EntityManager entityManager = this.D;
        if (entityManager != null) {
            entityManager.close();
        }
    }

    public ArrayList<HotPicTagInfo> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (ArrayList) this.G;
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x00da, code lost:
    
        if (r3.int32_result.get() != (-5)) goto L97;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x041b A[Catch: all -> 0x0547, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04d6 A[Catch: all -> 0x0547, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0500 A[Catch: all -> 0x0547, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0504 A[Catch: all -> 0x0547, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0493 A[Catch: all -> 0x0547, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0353 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x035f A[Catch: all -> 0x0547, LOOP:1: B:81:0x0359->B:83:0x035f, LOOP_END, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x039d A[Catch: all -> 0x0547, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03b3 A[Catch: all -> 0x0547, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000b, B:8:0x0013, B:12:0x0018, B:17:0x0046, B:19:0x004c, B:22:0x0057, B:24:0x005e, B:25:0x009a, B:27:0x00a2, B:29:0x00b5, B:32:0x00cb, B:177:0x00d3, B:34:0x00e3, B:36:0x00f1, B:37:0x00f9, B:39:0x00ff, B:42:0x012a, B:44:0x0130, B:46:0x0136, B:47:0x0164, B:48:0x0166, B:70:0x01f9, B:75:0x0349, B:77:0x034d, B:80:0x0355, B:81:0x0359, B:83:0x035f, B:85:0x037e, B:88:0x039d, B:91:0x03a5, B:93:0x03b3, B:96:0x03d8, B:98:0x03e8, B:99:0x0409, B:101:0x040d, B:104:0x041b, B:106:0x0421, B:107:0x04d0, B:109:0x04d6, B:112:0x04f2, B:113:0x04fc, B:115:0x0500, B:118:0x0504, B:121:0x0430, B:123:0x043e, B:124:0x0452, B:131:0x0493, B:133:0x0499, B:135:0x04a6, B:137:0x04ac, B:140:0x04b7, B:142:0x04c6, B:148:0x020f, B:157:0x0210, B:159:0x0218, B:161:0x021e, B:162:0x0224, B:164:0x022a, B:167:0x02ba, B:169:0x02ec, B:180:0x02f9, B:182:0x0300, B:184:0x0310, B:185:0x031e, B:187:0x0328, B:192:0x0512, B:194:0x0521, B:195:0x053d, B:197:0x0541), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03d6  */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v6, types: [com.tencent.mobileqq.pb.MessageMicro, com.tencent.pb.hotpicmsg.HotPicMsg$RspBody] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:151:0x020d -> B:142:0x020e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void q(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        ?? r132;
        InvalidProtocolBufferMicroException invalidProtocolBufferMicroException;
        int i3;
        ArrayList<HotPicData> arrayList;
        boolean z17;
        boolean z18;
        int i16;
        f fVar;
        Iterator<HotPicData> it;
        int i17;
        int i18;
        HotPicMsg$GetImgInfoRsp hotPicMsg$GetImgInfoRsp;
        Object obj;
        List<HotPicMsg$TagInfo> list;
        Throwable th5;
        boolean z19;
        int i19;
        List<HotPicTagInfo> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        int intExtra = intent.getIntExtra("REQUEST_VERSION", -1);
        int intExtra2 = intent.getIntExtra("REQUEST_TAG", -1);
        int n3 = n();
        boolean booleanExtra = intent.getBooleanExtra("REQUEST_CHECK_UPDATE", false);
        int intExtra3 = intent.getIntExtra("REQUEST_TYPE", -1);
        if (intExtra3 == 10003) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (intExtra3 == 10001) {
            z16 = f(intExtra2);
        }
        if (z16) {
            QLog.e("HotPicManager", 1, "Unable to have a video type");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotPicManager", 2, "handleResonpse: REQUEST_VERSION " + intExtra + " ,REQUEST_TAG:" + intExtra2 + " ,localVersion:" + n3 + " ,isCheckUpdateRequest:" + booleanExtra + " ,reqType:" + intExtra3);
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
            fromServiceMsg.putWupBuffer(bArr);
            try {
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                r132 = new HotPicMsg$RspBody();
                r132.mergeFrom(wupBuffer);
                hotPicMsg$GetImgInfoRsp = r132.msg_get_imginfo_rsp.get();
                try {
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    invalidProtocolBufferMicroException = e;
                    i18 = r132;
                    invalidProtocolBufferMicroException.printStackTrace();
                    i17 = i18;
                    arrayList = null;
                    i3 = i17;
                    if (QLog.isColorLevel()) {
                    }
                    if (arrayList != null) {
                    }
                    z17 = true;
                    z18 = false;
                    if (n3 != 0) {
                    }
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                r132 = 3;
            }
            if (hotPicMsg$GetImgInfoRsp != null) {
                if (hotPicMsg$GetImgInfoRsp.int32_result.get() != 0) {
                    try {
                    } catch (InvalidProtocolBufferMicroException e18) {
                        invalidProtocolBufferMicroException = e18;
                        i18 = 3;
                        invalidProtocolBufferMicroException.printStackTrace();
                        i17 = i18;
                        arrayList = null;
                        i3 = i17;
                        if (QLog.isColorLevel()) {
                        }
                        if (arrayList != null) {
                        }
                        z17 = true;
                        z18 = false;
                        if (n3 != 0) {
                        }
                    }
                }
                intExtra = hotPicMsg$GetImgInfoRsp.uint32_build_ver.get();
                if (hotPicMsg$GetImgInfoRsp.rpt_msg_tag_info.has()) {
                    list = hotPicMsg$GetImgInfoRsp.rpt_msg_tag_info.get();
                } else {
                    list = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("HotPicManager", 2, "handleResonpse,REQ_GET_PIC buildVersion:" + intExtra + " ,result:" + hotPicMsg$GetImgInfoRsp.int32_result.get());
                }
                if (booleanExtra && list != null && list.size() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("HotPicManager", 2, "handleResonpse update TagInfo:localVersion:" + n3 + " buildVersion" + intExtra + " hotPicTagInfos .size()" + list.size());
                    }
                    synchronized (this.P) {
                        try {
                            if (n3 == 0) {
                                list2 = this.G;
                                i19 = intExtra;
                                z19 = true;
                            } else {
                                z19 = false;
                                i19 = n3;
                                list2 = this.H;
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                        }
                        try {
                            list2.clear();
                            h(list2, intExtra);
                            for (HotPicMsg$TagInfo hotPicMsg$TagInfo : list) {
                                HotPicTagInfo hotPicTagInfo = new HotPicTagInfo();
                                hotPicTagInfo.tagType = hotPicMsg$TagInfo.uint32_tag_type.get();
                                int i26 = hotPicMsg$TagInfo.uint32_tag_id.get();
                                hotPicTagInfo.tagId = i26;
                                if (i26 != 2) {
                                    hotPicTagInfo.position = list2.size();
                                    hotPicTagInfo.tagName = hotPicMsg$TagInfo.bytes_tag_name.get().toStringUtf8();
                                    hotPicTagInfo.version = intExtra;
                                    list2.add(hotPicTagInfo);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("HotPicManager", 2, "handleResonpse update new getLoaclVersion name is " + hotPicTagInfo.tagName + " position is " + hotPicTagInfo.position + " tagId is " + hotPicTagInfo.tagId);
                                    }
                                }
                            }
                            if (z19) {
                                try {
                                    this.C.sendEmptyMessage(104);
                                } catch (InvalidProtocolBufferMicroException e19) {
                                    invalidProtocolBufferMicroException = e19;
                                    n3 = i19;
                                    i18 = 3;
                                    invalidProtocolBufferMicroException.printStackTrace();
                                    i17 = i18;
                                    arrayList = null;
                                    i3 = i17;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (arrayList != null) {
                                    }
                                    z17 = true;
                                    z18 = false;
                                    if (n3 != 0) {
                                    }
                                }
                            }
                            n3 = i19;
                        } catch (Throwable th7) {
                            th5 = th7;
                            n3 = i19;
                            throw th5;
                        }
                    }
                }
                List<HotPicMsg$ImgInfo> list3 = hotPicMsg$GetImgInfoRsp.rpt_msg_img_info.get();
                if (list3 != null && list3.size() > 0) {
                    ArrayList<HotPicData> arrayList2 = new ArrayList<>();
                    for (int i27 = 0; i27 < list3.size(); i27++) {
                        HotPicMsg$ImgInfo hotPicMsg$ImgInfo = list3.get(i27);
                        HotPicData hotPicData = new HotPicData();
                        hotPicData.version = intExtra;
                        hotPicData.picIndex = hotPicMsg$ImgInfo.uint32_pic_index.get();
                        hotPicData.fileType = hotPicMsg$ImgInfo.uint32_file_type.get();
                        hotPicData.sourceType = hotPicMsg$ImgInfo.uint32_source_type.get();
                        hotPicData.height = hotPicMsg$ImgInfo.uint32_thumb_file_height.get();
                        hotPicData.width = hotPicMsg$ImgInfo.uint32_thumb_file_width.get();
                        hotPicData.url = hotPicMsg$ImgInfo.bytes_thumb_down_url.get().toStringUtf8();
                        hotPicData.md5 = hotPicMsg$ImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
                        hotPicData.fileSize = hotPicMsg$ImgInfo.uint64_thumb_file_size.get();
                        hotPicData.originalMD5 = hotPicMsg$ImgInfo.bytes_file_md5.get().toStringUtf8();
                        hotPicData.originalUrl = hotPicMsg$ImgInfo.bytes_pic_down_url.get().toStringUtf8();
                        hotPicData.originalHeight = hotPicMsg$ImgInfo.uint32_file_height.get();
                        hotPicData.originalWidth = hotPicMsg$ImgInfo.uint32_file_width.get();
                        hotPicData.oringinalSize = hotPicMsg$ImgInfo.uint64_file_size.get();
                        hotPicData.tag = intExtra2;
                        if (hotPicData.sourceType == 3) {
                            HotPicMsg$ThirdPartyInfo hotPicMsg$ThirdPartyInfo = hotPicMsg$ImgInfo.msg_third_party_info;
                            hotPicData.iconUrl = hotPicMsg$ThirdPartyInfo.bytes_icon_url.get().toStringUtf8();
                            hotPicData.name = hotPicMsg$ThirdPartyInfo.bytes_name.get().toStringUtf8();
                            hotPicData.jumpUrl = hotPicMsg$ThirdPartyInfo.bytes_jump_url.get().toStringUtf8();
                            hotPicData.appid = hotPicMsg$ThirdPartyInfo.bytes_appid.get().toStringUtf8();
                        }
                        arrayList2.add(hotPicData);
                    }
                    i3 = 3;
                    arrayList = arrayList2;
                    if (QLog.isColorLevel()) {
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                        }
                        QLog.d("HotPicManager", 2, "onGetResp hotPicObject Size" + arrayList.size());
                    }
                    if (arrayList != null) {
                        ArrayList arrayList3 = this.E.get(intExtra2);
                        if (QLog.isColorLevel()) {
                        }
                        if (n3 == intExtra) {
                        }
                    }
                    z17 = true;
                    z18 = false;
                    if (n3 != 0) {
                    }
                } else {
                    i17 = 3;
                    arrayList = null;
                    i3 = i17;
                    if (QLog.isColorLevel() && arrayList != null) {
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            QLog.d("HotPicManager", 2, "onGetResp hotPicObject:" + it.next());
                        }
                        QLog.d("HotPicManager", 2, "onGetResp hotPicObject Size" + arrayList.size());
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList arrayList32 = this.E.get(intExtra2);
                        if (QLog.isColorLevel()) {
                            QLog.d("HotPicManager", 2, "handleResonpse, newversion " + intExtra + " local " + n3);
                        }
                        if (n3 == intExtra) {
                            if (booleanExtra) {
                                this.F.clear();
                                this.F.put(intExtra2, arrayList);
                                if (QLog.isColorLevel()) {
                                    QLog.d("HotPicManager", 2, "handleResonpse, newversion " + intExtra + " local " + n3);
                                }
                                if (this.J == null) {
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.hotpic.HotPicManager.2
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HotPicManager.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                            } else {
                                                HotPicManager.this.D();
                                            }
                                        }
                                    });
                                }
                            }
                            return;
                        }
                        if (arrayList32.size() == 0) {
                            arrayList32.addAll(arrayList);
                            E(arrayList32, false);
                            i16 = 7;
                            z18 = false;
                            z17 = true;
                        } else if (n3 != 0) {
                            if (arrayList.get(0).picIndex == arrayList32.size()) {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.addAll(arrayList);
                                arrayList32.addAll(arrayList4);
                                E(arrayList4, false);
                                i16 = i3;
                                z17 = true;
                                z18 = false;
                            } else {
                                QLog.d("HotPicManager", 1, "wrong begin index " + arrayList.get(0).picIndex + ", local " + arrayList32.size() + ",tag " + intExtra2);
                                return;
                            }
                        } else {
                            z18 = false;
                            z17 = true;
                            i16 = 5;
                        }
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("onGetResp result:");
                            sb5.append(i16);
                            sb5.append(" has listener:");
                            if (this.J != null) {
                                z18 = z17;
                            }
                            sb5.append(z18);
                            QLog.d("HotPicManager", 2, sb5.toString());
                        }
                        fVar = this.J;
                        if (fVar != null) {
                            fVar.a(i16, intExtra2, intExtra);
                        } else {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.hotpic.HotPicManager.3
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HotPicManager.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        HotPicManager.this.D();
                                    }
                                }
                            });
                        }
                        return;
                    }
                    z17 = true;
                    z18 = false;
                    if (n3 != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("HotPicManager", 2, "handleResonpse,arrays null,localVersion == 0 result NOTIFY_ERR");
                        }
                        i16 = 5;
                        if (QLog.isColorLevel()) {
                        }
                        fVar = this.J;
                        if (fVar != null) {
                        }
                        return;
                    }
                    if (booleanExtra) {
                        if (QLog.isColorLevel()) {
                            QLog.d("HotPicManager", 2, "handleResonpse,arrays null,isCheckUpdateRequest result NOTIFY_NO_UPDATE");
                        }
                        return;
                    }
                    this.f236942h.add(Integer.valueOf(intExtra2));
                    if (QLog.isColorLevel()) {
                        QLog.d("HotPicManager", 2, "handleResonpse,arrays null,result NOTIFY_ERR_AT_LOAD_MORE");
                    }
                    i16 = 6;
                    if (QLog.isColorLevel()) {
                    }
                    fVar = this.J;
                    if (fVar != null) {
                    }
                    return;
                }
            }
            i17 = 3;
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("handleResonpse,REQ_GET_PIC error,result:");
                if (hotPicMsg$GetImgInfoRsp != null) {
                    obj = Integer.valueOf(hotPicMsg$GetImgInfoRsp.int32_result.get());
                } else {
                    obj = "null";
                }
                sb6.append(obj);
                QLog.d("HotPicManager", 2, sb6.toString());
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "HotPicManagerfail", true, 0L, 0L, null, "");
            arrayList = null;
            i3 = i17;
            if (QLog.isColorLevel()) {
            }
            if (arrayList != null) {
            }
            z17 = true;
            z18 = false;
            if (n3 != 0) {
            }
        } else {
            this.f236942h.add(Integer.valueOf(intExtra2));
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager", 2, "handleResonpse,msg.getResultCode() error:" + fromServiceMsg.getResultCode());
            }
            f fVar2 = this.J;
            if (fVar2 != null) {
                fVar2.a(6, intExtra2, intExtra);
            }
        }
    }

    public synchronized void s() {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.f236940e) {
            this.f236940e = true;
            this.f236941f = this.f236939d.getApplication().getSharedPreferences("sp_hotpic_" + this.f236939d.getCurrentUin(), 0).getBoolean("k_hotlist_f", true);
            EntityManager createEntityManager = this.f236939d.getEntityManagerFactory().createEntityManager();
            this.D = createEntityManager;
            try {
                ArrayList arrayList2 = (ArrayList) createEntityManager.query(HotPicTagInfo.class, true, null, null, null, null, "position asc", null);
                this.G = arrayList2;
                if (arrayList2 == null) {
                    ArrayList arrayList3 = new ArrayList();
                    this.G = arrayList3;
                    h(arrayList3, 0);
                }
                for (HotPicTagInfo hotPicTagInfo : this.G) {
                    int i3 = hotPicTagInfo.tagType;
                    if (i3 != 255) {
                        int i16 = hotPicTagInfo.tagId;
                        String[] strArr = {String.valueOf(i16)};
                        if (i3 != 2) {
                            ArrayList<HotPicData> arrayList4 = (ArrayList) this.D.query(HotPicData.class, true, "tag = ?", strArr, null, null, "picIndex asc", null);
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList<>();
                            }
                            this.E.put(i16, arrayList4);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("HotPicManager", 2, "makesureInit localTagInfo name is " + hotPicTagInfo.tagName);
                        }
                    }
                }
                arrayList = (ArrayList) this.D.query(HotPicSendData.class, true, null, null, null, null, null, null);
            } catch (Exception e16) {
                e16.printStackTrace();
                arrayList = null;
            }
            if (arrayList != null) {
                Collections.sort(arrayList, Collections.reverseOrder());
                this.I.addAll(arrayList);
            }
            this.M = m();
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.f236941f) {
            this.f236941f = false;
            this.f236939d.getApplication().getSharedPreferences("sp_hotpic_" + this.f236939d.getCurrentUin(), 0).edit().putBoolean("k_hotlist_f", false).commit();
        }
    }

    public synchronized void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (!D()) {
            if (!this.L) {
                w();
                this.L = true;
            }
        } else {
            this.N = true;
        }
        this.C.removeMessages(103);
    }

    public void v(HotPicTagInfo hotPicTagInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) hotPicTagInfo);
            return;
        }
        int i3 = hotPicTagInfo.tagId;
        if (D() || this.N) {
            this.N = false;
            if (i3 != -20) {
                x(10001, hotPicTagInfo.tagId);
            }
        }
        this.M = i3;
        ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.mobileqq.hotpic.HotPicManager.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f236947d;

            {
                this.f236947d = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HotPicManager.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                HotPicManager.this.f236939d.getApplication().getSharedPreferences("sp_hotpic_" + HotPicManager.this.f236939d.getCurrentUin(), 0).edit().putInt("hot_pic_last_click", this.f236947d).commit();
            }
        }, 5, null, false);
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!this.f236943i) {
            return;
        }
        s();
        int i3 = this.M;
        if (i3 != -1) {
            if (i3 != -20) {
                x(10001, i3);
                return;
            } else {
                x(10001, 2);
                return;
            }
        }
        if (this.f236941f) {
            x(10001, 2);
        }
    }

    public void x(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            ThreadManagerV2.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.hotpic.HotPicManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f236945d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f236946e;

                {
                    this.f236945d = i3;
                    this.f236946e = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HotPicManager.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    HotPicManager.this.s();
                    switch (this.f236945d) {
                        case 10001:
                            HotPicManager hotPicManager = HotPicManager.this;
                            if (!hotPicManager.f236941f && !hotPicManager.C()) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("HotPicManager", 2, "cancel request");
                                    return;
                                }
                                return;
                            }
                            boolean f16 = HotPicManager.this.f(this.f236946e);
                            HotPicManager hotPicManager2 = HotPicManager.this;
                            int n3 = hotPicManager2.n();
                            int i18 = this.f236946e;
                            if (f16) {
                                i17 = 10003;
                            } else {
                                i17 = 10002;
                            }
                            hotPicManager2.z(0, 15, n3, i18, true, i17);
                            if (QLog.isColorLevel()) {
                                QLog.d("HotPicManager", 2, "request REQ_CHECK_UPDATE getLoaclVersion is " + HotPicManager.this.n());
                                return;
                            }
                            return;
                        case 10002:
                            ArrayList arrayList = (ArrayList) HotPicManager.this.E.get(this.f236946e);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                HotPicManager.this.E.put(this.f236946e, arrayList);
                            }
                            int size = arrayList.size();
                            HotPicManager hotPicManager3 = HotPicManager.this;
                            hotPicManager3.z(size, (size + 16) - 1, hotPicManager3.n(), this.f236946e, false, this.f236945d);
                            return;
                        case 10003:
                            ArrayList arrayList2 = (ArrayList) HotPicManager.this.E.get(this.f236946e);
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                                HotPicManager.this.E.put(this.f236946e, arrayList2);
                            }
                            int size2 = arrayList2.size();
                            HotPicManager hotPicManager4 = HotPicManager.this;
                            hotPicManager4.z(size2, (size2 + 8) - 1, hotPicManager4.n(), this.f236946e, false, this.f236945d);
                            return;
                        default:
                            return;
                    }
                }
            }, 8, null, false);
        }
    }

    public void y(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        Iterator<HotPicTagInfo> it = this.G.iterator();
        while (true) {
            if (it.hasNext()) {
                HotPicTagInfo next = it.next();
                if (next.tagId == i3 && next.tagType == 2) {
                    i16 = 10003;
                    break;
                }
            } else {
                i16 = 10002;
                break;
            }
        }
        x(i16, i3);
    }

    public synchronized void z(int i3, int i16, int i17, int i18, boolean z16, int i19) {
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i28 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotPicManager", 2, "requestHotPicList " + i3 + "-" + i16 + " version= " + i17 + " tag= " + i18 + " checkUpdate" + z16 + " reqType= " + i19);
        }
        HotPicMsg$ReqBody hotPicMsg$ReqBody = new HotPicMsg$ReqBody();
        if (i19 == 10003) {
            HotPicMsg$GetVideoInfoReq hotPicMsg$GetVideoInfoReq = new HotPicMsg$GetVideoInfoReq();
            hotPicMsg$ReqBody.setHasFlag(true);
            hotPicMsg$GetVideoInfoReq.uint64_src_uin.set(Long.parseLong(this.f236939d.getCurrentAccountUin()));
            hotPicMsg$GetVideoInfoReq.uint32_src_term.set(3);
            hotPicMsg$GetVideoInfoReq.uint32_start_video_index.set(i3);
            hotPicMsg$GetVideoInfoReq.uint32_end_video_index.set(i16);
            hotPicMsg$GetVideoInfoReq.uint32_build_ver.set(i17);
            hotPicMsg$GetVideoInfoReq.uint32_tag_id.set(i18);
            hotPicMsg$GetVideoInfoReq.bytes_client_ver.set(ByteStringMicro.copyFromUtf8(AppSetting.f99551k));
            PBUInt32Field pBUInt32Field = hotPicMsg$GetVideoInfoReq.uint32_need_update;
            if (z16) {
                i27 = 1;
            } else {
                i27 = 0;
            }
            pBUInt32Field.set(i27);
            String str = this.f236939d.getCurrentAccountUin() + SystemClock.uptimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager", 2, "sessionId:" + str);
            }
            hotPicMsg$GetVideoInfoReq.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
            hotPicMsg$ReqBody.msg_get_videoinfo_req.set(hotPicMsg$GetVideoInfoReq);
        } else {
            HotPicMsg$GetImgInfoReq hotPicMsg$GetImgInfoReq = new HotPicMsg$GetImgInfoReq();
            hotPicMsg$ReqBody.setHasFlag(true);
            if (TextUtils.isEmpty(this.f236939d.getCurrentAccountUin())) {
                return;
            }
            hotPicMsg$GetImgInfoReq.uint64_src_uin.set(Long.parseLong(this.f236939d.getCurrentAccountUin()));
            hotPicMsg$GetImgInfoReq.uint32_src_term.set(3);
            hotPicMsg$GetImgInfoReq.uint32_start_pic_index.set(i3);
            hotPicMsg$GetImgInfoReq.uint32_end_pic_index.set(i16);
            hotPicMsg$GetImgInfoReq.uint32_build_ver.set(i17);
            hotPicMsg$GetImgInfoReq.uint32_pic_tag.set(i18);
            hotPicMsg$GetImgInfoReq.bytes_client_ver.set(ByteStringMicro.copyFromUtf8(AppSetting.f99551k));
            PBUInt32Field pBUInt32Field2 = hotPicMsg$GetImgInfoReq.uint32_need_update;
            if (!z16) {
                i28 = 0;
            }
            pBUInt32Field2.set(i28);
            String str2 = this.f236939d.getCurrentAccountUin() + SystemClock.uptimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager", 2, "sessionId:" + str2);
            }
            hotPicMsg$GetImgInfoReq.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str2));
            hotPicMsg$ReqBody.msg_get_imginfo_req.set(hotPicMsg$GetImgInfoReq);
        }
        byte[] byteArray = hotPicMsg$ReqBody.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4).put(byteArray);
        byte[] array = allocate.array();
        NewIntent newIntent = new NewIntent(this.f236939d.getApp(), i.class);
        newIntent.putExtra(ProtoServlet.KEY_BODY, array);
        newIntent.putExtra("key_cmd", CommonEmoticonConstans.SSOCMD);
        newIntent.putExtra("REQUEST_CHECK_UPDATE", z16);
        newIntent.putExtra("REQUEST_TAG", i18);
        if (z16) {
            i26 = 10001;
        } else {
            i26 = i19;
        }
        newIntent.putExtra("REQUEST_TYPE", i26);
        newIntent.putExtra("REQUEST_VERSION", i17);
        this.f236939d.startServlet(newIntent);
    }
}
