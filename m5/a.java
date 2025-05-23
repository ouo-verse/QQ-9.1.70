package m5;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.util.al;
import com.tencent.component.media.image.ImageLoader;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;
import n7.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends Observable implements IQZoneServiceListener {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f416149e = false;

    /* renamed from: f, reason: collision with root package name */
    private static QbossAdvDesc f416150f = null;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f416151h = false;

    /* renamed from: i, reason: collision with root package name */
    private static final al<a, Void> f416152i = new C10764a();

    /* renamed from: d, reason: collision with root package name */
    private final b f416153d = new b("TABLE_QBOSS", QbossAdvDesc.class);

    /* compiled from: P */
    /* renamed from: m5.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10764a extends al<a, Void> {
        C10764a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f416154a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f416155b;

        /* renamed from: c, reason: collision with root package name */
        String f416156c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f416157d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f416158e = new C10765a();

        /* compiled from: P */
        /* renamed from: m5.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        class C10765a implements a.InterfaceC10828a {
            C10765a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                b bVar = b.this;
                bVar.f416154a = 0L;
                bVar.f416155b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f416156c = str;
            this.f416157d = cls;
        }
    }

    private DbCacheManager E(b bVar) {
        D(bVar);
        return bVar.f416155b;
    }

    public static a H() {
        return f416152i.get(null);
    }

    private DbCacheManager K() {
        return E(this.f416153d);
    }

    private void L(QZoneTask qZoneTask, int i3) {
        JceStruct jceStruct;
        Map<Integer, ArrayList<tAdvDesc>> map;
        if (qZoneTask == null) {
            QZLog.e("QzoneQbossService", "handleFontGifShow task is null");
            return;
        }
        QZoneResult result = qZoneTask.getResult(i3);
        if (result != null && result.getReturnCode() == 0) {
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if ((qZoneRequest instanceof QzoneQBossAdvRequest) && (jceStruct = ((QzoneQBossAdvRequest) qZoneRequest).rsp) != null && (jceStruct instanceof MobileQbossAdvRsp) && (map = ((MobileQbossAdvRsp) jceStruct).mapAdv) != null) {
                ArrayList<tAdvDesc> arrayList = map.get(2749);
                if (arrayList != null && arrayList.size() > 0) {
                    QbossAdvDesc qbossAdvDesc = QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2749L, arrayList.get(0));
                    f416150f = qbossAdvDesc;
                    EventCenter.getInstance().post("FontQbossGifShow", 1, qbossAdvDesc);
                } else {
                    QZLog.d("QzoneQbossService", 2, "handleFontGifShow  \u597d\u53cb\u52a8\u6001\u5b57\u4f53  2749:\u6ca1\u6709\u5e7f\u544a\u4f4d");
                }
                ArrayList<tAdvDesc> arrayList2 = map.get(2748);
                if (arrayList2 != null && arrayList2.size() > 0) {
                    EventCenter.getInstance().post("FontQbossGifShow", 2, QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2748L, arrayList2.get(0)));
                    return;
                } else {
                    QZLog.d("QzoneQbossService", 2, "handleFontGifShow  \u5199\u8bf4\u8bf4\u5b57\u4f53  2748:\u6ca1\u6709\u5e7f\u544a\u4f4d");
                    return;
                }
            }
            return;
        }
        QZLog.d("QzoneQbossService", 1, "handleFontGifShow  businessType:" + i3 + " fail code:" + qZoneTask.mResultCode);
    }

    private void N(QZoneTask qZoneTask, int i3) {
        JceStruct jceStruct;
        Map<Integer, ArrayList<tAdvDesc>> map;
        ArrayList<tAdvDesc> arrayList;
        if (qZoneTask == null) {
            QZLog.e("QzoneQbossService", "processGetExperienceTaskReponse task is null");
            return;
        }
        QZoneResult result = qZoneTask.getResult(i3);
        if (result != null && result.getReturnCode() == 0) {
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if ((qZoneRequest instanceof QzoneQBossAdvRequest) && (jceStruct = ((QzoneQBossAdvRequest) qZoneRequest).rsp) != null && (jceStruct instanceof MobileQbossAdvRsp) && (map = ((MobileQbossAdvRsp) jceStruct).mapAdv) != null && (arrayList = map.get(2811)) != null && arrayList.size() > 0) {
                EventCenter.getInstance().post("GuestInfoQBoss", 1, QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2811L, arrayList.get(0)));
                return;
            }
            return;
        }
        QZLog.d("QzoneQbossService", 1, "processGetExperienceTaskReponse  businessType:" + i3 + " fail code:" + qZoneTask.mResultCode);
    }

    private void O(QZoneTask qZoneTask, int i3) {
        JceStruct jceStruct;
        Map<Integer, ArrayList<tAdvDesc>> map;
        String str;
        String str2;
        if (qZoneTask == null) {
            QZLog.e("QzoneQbossService", "processTaskReponse task is null");
            return;
        }
        QZoneResult result = qZoneTask.getResult(i3);
        if (result != null && result.getReturnCode() == 0) {
            QZoneRequest qZoneRequest = qZoneTask.mRequest;
            if ((qZoneRequest instanceof QzoneQBossAdvRequest) && (jceStruct = ((QzoneQBossAdvRequest) qZoneRequest).rsp) != null && (jceStruct instanceof MobileQbossAdvRsp) && (map = ((MobileQbossAdvRsp) jceStruct).mapAdv) != null) {
                ArrayList<tAdvDesc> arrayList = map.get(2657);
                if (arrayList != null && arrayList.size() > 0) {
                    H().P(QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2657L, arrayList.get(0)));
                    ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_mlHcsh0Vpy.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                    ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_Z0ALPzltCO.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                }
                ArrayList<tAdvDesc> arrayList2 = map.get(2656);
                if (arrayList2 != null && arrayList2.size() > 0) {
                    H().P(QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2656L, arrayList2.get(0)));
                    ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_2FkI4iOAWN.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                }
                ArrayList<tAdvDesc> arrayList3 = map.get(2655);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    H().P(QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2655L, arrayList3.get(0)));
                    if (LoginData.getInstance().isQzoneVip()) {
                        str2 = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_svUJcaCyIZ.png";
                    } else {
                        str2 = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_eiEc6zwDkg.png";
                    }
                    ImageLoader.getInstance().loadImage(str2, (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                }
                ArrayList<tAdvDesc> arrayList4 = map.get(2707);
                if (arrayList4 != null && arrayList4.size() > 0) {
                    EventCenter.getInstance().post("Cover", 1, QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2707L, arrayList4.get(0)));
                }
                ArrayList<tAdvDesc> arrayList5 = map.get(2863);
                if (arrayList5 != null && arrayList5.size() > 0) {
                    H().P(QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2863L, arrayList5.get(0)));
                    if (LoginData.getInstance().isQzoneVip()) {
                        str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213858_fLykFCXK8Y.png";
                    } else {
                        str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213858_JgkhIOsAGu.png";
                    }
                    ImageLoader.getInstance().loadImage(str, (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                }
                ArrayList<tAdvDesc> arrayList6 = map.get(2864);
                if (arrayList6 == null || arrayList6.size() <= 0) {
                    return;
                }
                H().P(QbossAdvDesc.toQbossAdvDesc(LoginData.getInstance().getUin(), 2864L, arrayList6.get(0)));
                return;
            }
            return;
        }
        QZLog.d("QzoneQbossService", 1, "processTaskReponse  businessType:" + i3 + " fail code:" + qZoneTask.mResultCode);
    }

    public void C(String str, int i3) {
        DbCacheManager K = K();
        if (K != null) {
            K.b0("uin_qboss_id == ?", new String[]{str + "_" + i3});
        }
        EventCenter.getInstance().post("Qboss", 2, (Object[]) null);
    }

    public void F(int i3, boolean z16) {
        if ((!f416149e || z16) && !z16) {
            return;
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), i3), null, this, 2));
        QZLog.d("QzoneQbossService", 1, "getFontGifQboss businessType:" + i3);
        if (z16) {
            return;
        }
        f416149e = false;
    }

    public QbossAdvDesc G() {
        return f416150f;
    }

    public boolean I() {
        return f416151h;
    }

    public QbossAdvDesc J(long j3, int i3) {
        QbossAdvDesc qbossAdvDesc;
        synchronized (this.f416153d) {
            D(this.f416153d);
            qbossAdvDesc = (QbossAdvDesc) this.f416153d.f416155b.k0("uin_qboss_id=?", new String[]{j3 + "_" + i3});
        }
        return qbossAdvDesc;
    }

    public void M(boolean z16) {
        f416151h = z16;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            O(qZoneTask, 1);
        } else if (i3 == 2) {
            L(qZoneTask, 2);
        } else {
            if (i3 != 3) {
                return;
            }
            N(qZoneTask, 3);
        }
    }

    private void D(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f416154a || (dbCacheManager = bVar.f416155b) == null || dbCacheManager.isClosed()) {
            bVar.f416154a = uin;
            DbCacheManager e16 = c.g().e(bVar.f416157d, uin, bVar.f416156c);
            bVar.f416155b = e16;
            e16.U(bVar.f416158e);
        }
    }

    public void P(QbossAdvDesc qbossAdvDesc) {
        if (qbossAdvDesc == null) {
            return;
        }
        DbCacheManager K = K();
        if (K != null) {
            K.r0("uin_qboss_id=?");
            K.t0(new String[]{"" + qbossAdvDesc.uin_qboss_id});
            K.o0(qbossAdvDesc, 2);
        }
        EventCenter.getInstance().post("Qboss", 2, qbossAdvDesc);
    }
}
