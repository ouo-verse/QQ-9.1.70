package com.tencent.mobileqq.qqlive.anchor.util;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.anchor.room.LabelOriginInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAddress;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataConfigInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFrame;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataMediaInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRichTitleElement;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomRichTitle;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStreamInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.common.api.AegisLogger;
import gr4.aa;
import gr4.k;
import gr4.l;
import gr4.m;
import gr4.o;
import gr4.r;
import gr4.s;
import gr4.t;
import gr4.u;
import gr4.w;
import gr4.y;
import gr4.z;
import java.util.ArrayList;
import nt3.c;
import ot3.b;
import ot3.f;
import pt3.d;
import pt3.e;
import pt3.g;
import pt3.h;
import pt3.i;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class C8354a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f270953a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60746);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[QQLiveAnchorDataRoomAttr.PushType.values().length];
            f270953a = iArr;
            try {
                iArr[QQLiveAnchorDataRoomAttr.PushType.QLS_CAMERA_CAPTURE_TRTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f270953a[QQLiveAnchorDataRoomAttr.PushType.QLS_SCREEN_CAPTURE_TRTC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f270953a[QQLiveAnchorDataRoomAttr.PushType.QLS_OBS_CAPTURE_RTMP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final d A(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        d dVar = new d();
        dVar.f427130a = J(qQLiveAnchorRoomInfo.source);
        dVar.f427133d = 1;
        dVar.f427131b = qQLiveAnchorRoomInfo.roomData.f271212id;
        g gVar = new g();
        dVar.f427132c = gVar;
        gVar.f427145b = J(qQLiveAnchorRoomInfo.roomData.programId);
        dVar.f427135f = ht3.a.b("qqlive_push_url_expire_time", TroopMemberSpecialTitleInfo.SPECIAL_TITLE_EXPIRE_SOON_TIME);
        return dVar;
    }

    public static final QQLiveAnchorDataPushInfo B(e eVar) {
        boolean z16;
        QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo = new QQLiveAnchorDataPushInfo();
        if (eVar.f427136a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        qQLiveAnchorDataPushInfo.isSuccess = z16;
        if (!z16) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6221;
            qQLiveErrorMsg.bizErrMsg = "push url result error";
            qQLiveErrorMsg.originErrCode = eVar.f427136a;
            qQLiveAnchorDataPushInfo.errorMsg = qQLiveErrorMsg;
        }
        qQLiveAnchorDataPushInfo.rtmpUrl = eVar.f427137b;
        qQLiveAnchorDataPushInfo.serverPart = eVar.f427138c;
        qQLiveAnchorDataPushInfo.streamParam = eVar.f427139d;
        qQLiveAnchorDataPushInfo.expireTs = eVar.f427140e;
        return qQLiveAnchorDataPushInfo;
    }

    public static final u C(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr) {
        u uVar = new u();
        if (qQLiveAnchorRoomInfo != null) {
            uVar.f403214a = qQLiveAnchorRoomInfo.roomData.f271212id;
            uVar.f403217d = J(qQLiveAnchorRoomInfo.source);
            uVar.f403218e = J(qQLiveAnchorRoomInfo.roomData.programId);
            uVar.f403219f = J(qQLiveAnchorRoomInfo.machieId);
        }
        if (qQLiveAnchorDataRoomAttr != null) {
            uVar.f403216c = y(qQLiveAnchorDataRoomAttr.tags);
            uVar.f403215b = H(qQLiveAnchorDataRoomAttr);
            uVar.f403225l = qQLiveAnchorDataRoomAttr.liveRoomType;
            uVar.f403226m = x(qQLiveAnchorDataRoomAttr.gameInfo);
            uVar.f403227n = j(qQLiveAnchorDataRoomAttr);
        }
        L(qQLiveAnchorDataRoomAttr);
        return uVar;
    }

    public static final c D(long j3, String str) {
        c cVar = new c();
        cVar.f421270a = J(str);
        cVar.f421271b = 0L;
        nt3.a aVar = new nt3.a();
        aVar.f421264a = 4;
        aVar.f421265b = 3;
        aVar.f421267d = 0;
        cVar.f421272c = aVar;
        return cVar;
    }

    public static final i E(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, int i3) {
        int i16;
        i iVar = new i();
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData;
        iVar.f427148a = qQLiveAnchorDataRoomInfo.f271212id;
        iVar.f427149b = i3;
        if (qQLiveAnchorDataRoomInfo.isPrivateLive) {
            i16 = 5;
        } else {
            i16 = 4;
        }
        iVar.f427150c = i16;
        iVar.f427151d = J(qQLiveAnchorRoomInfo.trtcData.sig);
        iVar.f427152e = 3;
        pt3.c cVar = new pt3.c();
        cVar.f427121b = DeviceInfoMonitor.getModel();
        cVar.f427122c = "1.0.0";
        h hVar = new h();
        hVar.f427147b = 1280;
        hVar.f427146a = 720;
        cVar.f427123d = hVar;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo2 = qQLiveAnchorRoomInfo.roomData;
        if (qQLiveAnchorDataRoomInfo2.liveRoomType == 1) {
            cVar.f427124e = 3;
        } else {
            cVar.f427124e = 0;
        }
        iVar.f427153f = cVar;
        iVar.f427155h = 0;
        iVar.f427156i = 0;
        iVar.f427157j = 0;
        iVar.f427158k = J(qQLiveAnchorDataRoomInfo2.programId);
        return iVar;
    }

    private static final QQLiveAnchorDataStream F(f fVar) {
        QQLiveAnchorDataStream qQLiveAnchorDataStream = new QQLiveAnchorDataStream();
        if (fVar != null) {
            qQLiveAnchorDataStream.name = fVar.f424042b;
            qQLiveAnchorDataStream.rawLevel = fVar.f424043c;
            qQLiveAnchorDataStream.frames = i(fVar.f424041a);
        }
        return qQLiveAnchorDataStream;
    }

    private static final ArrayList<QQLiveAnchorDataStream> G(f[] fVarArr) {
        ArrayList<QQLiveAnchorDataStream> arrayList = new ArrayList<>();
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                arrayList.add(F(fVar));
            }
        }
        return arrayList;
    }

    private static final y[] H(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr) {
        long j3;
        if (qQLiveAnchorDataRoomAttr == null) {
            return new y[0];
        }
        ArrayList arrayList = new ArrayList();
        y K = K();
        K.f403243a = 1;
        K.f403245c = J(qQLiveAnchorDataRoomAttr.roomName);
        arrayList.add(K);
        y K2 = K();
        K2.f403243a = 2;
        K2.f403245c = J(qQLiveAnchorDataRoomAttr.locationNG);
        arrayList.add(K2);
        y K3 = K();
        K3.f403243a = 3;
        K3.f403245c = J(qQLiveAnchorDataRoomAttr.locationAT);
        arrayList.add(K3);
        y K4 = K();
        K4.f403243a = 4;
        K4.f403245c = J(qQLiveAnchorDataRoomAttr.city);
        arrayList.add(K4);
        y K5 = K();
        K5.f403243a = 5;
        K5.f403245c = J(qQLiveAnchorDataRoomAttr.phoneModel);
        arrayList.add(K5);
        y K6 = K();
        K6.f403243a = 6;
        if (qQLiveAnchorDataRoomAttr.enableGif) {
            j3 = 0;
        } else {
            j3 = 1;
        }
        K6.f403244b = j3;
        arrayList.add(K6);
        y K7 = K();
        K7.f403243a = 7;
        K7.f403245c = J(qQLiveAnchorDataRoomAttr.poster);
        arrayList.add(K7);
        y K8 = K();
        K8.f403243a = 8;
        K8.f403244b = qQLiveAnchorDataRoomAttr.posterTime;
        arrayList.add(K8);
        y K9 = K();
        K9.f403243a = 11;
        K9.f403245c = J(qQLiveAnchorDataRoomAttr.poster3v4);
        arrayList.add(K9);
        y K10 = K();
        K10.f403243a = 12;
        K10.f403244b = qQLiveAnchorDataRoomAttr.posterTime3v4;
        arrayList.add(K10);
        y K11 = K();
        K11.f403243a = 9;
        K11.f403245c = J(qQLiveAnchorDataRoomAttr.poster16v9);
        arrayList.add(K11);
        y K12 = K();
        K12.f403243a = 10;
        K12.f403244b = qQLiveAnchorDataRoomAttr.posterTime16v9;
        arrayList.add(K12);
        y[] yVarArr = new y[arrayList.size()];
        arrayList.toArray(yVarArr);
        return yVarArr;
    }

    private static final int I(QQLiveAnchorDataRoomAttr.PushType pushType) {
        int i3 = C8354a.f270953a[pushType.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    return 0;
                }
            }
        }
        return i16;
    }

    public static final String J(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    private static y K() {
        y yVar = new y();
        yVar.f403245c = "";
        return yVar;
    }

    private static void L(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr) {
        if (qQLiveAnchorDataRoomAttr != null && TextUtils.isEmpty(qQLiveAnchorDataRoomAttr.poster)) {
            AegisLogger.e("Open_Live|QQLiveAnchorSSOHelper", "printAttrLog", "set\u534f\u8bae\u5c01\u9762\u56fe\u4e3a\u7a7a, 16:9 url:" + qQLiveAnchorDataRoomAttr.poster16v9);
        }
    }

    public static final int M(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static final void N(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        if (qQLiveAnchorDataRoomAttr != null && qQLiveAnchorRoomInfo != null && (qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData) != null) {
            qQLiveAnchorDataRoomInfo.name = qQLiveAnchorDataRoomAttr.roomName;
            qQLiveAnchorDataRoomInfo.giftFlag = !qQLiveAnchorDataRoomAttr.enableGif ? 1 : 0;
            qQLiveAnchorDataRoomInfo.poster = qQLiveAnchorDataRoomAttr.poster;
            qQLiveAnchorDataRoomInfo.coverUrl3v4 = qQLiveAnchorDataRoomAttr.poster3v4;
            qQLiveAnchorDataRoomInfo.coverUrl16v9 = qQLiveAnchorDataRoomAttr.poster16v9;
            qQLiveAnchorDataRoomInfo.liveRoomType = qQLiveAnchorDataRoomAttr.liveRoomType;
            qQLiveAnchorDataRoomInfo.pushType = qQLiveAnchorDataRoomAttr.pushType;
            qQLiveAnchorDataRoomInfo.gameInfo = new QQLiveAnchorRoomGameInfo(qQLiveAnchorDataRoomAttr.gameInfo);
            qQLiveAnchorRoomInfo.roomData.tags = new QQLiveAnchorDataRoomRichTitle(qQLiveAnchorDataRoomAttr.tags);
            qQLiveAnchorRoomInfo.roomData.isPrivateLive = qQLiveAnchorDataRoomAttr.isPrivateLive;
        }
    }

    public static final void a(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) throws QQLiveAnchorThrowable {
        if (z16) {
            if (hVar != null) {
                if (hVar.g() == 0) {
                    if (hVar.b() == 0) {
                        if (hVar.e() != null) {
                            return;
                        } else {
                            throw new QQLiveAnchorThrowable("data is null");
                        }
                    }
                    throw new QQLiveAnchorThrowable("biz error", hVar.b(), hVar.c());
                }
                throw new QQLiveAnchorThrowable("proxy error", hVar.g(), hVar.f());
            }
            throw new QQLiveAnchorThrowable("rsp is null");
        }
        throw new QQLiveAnchorThrowable("isSuccess is false");
    }

    private static final QQLiveAnchorDataAddress b(ot3.a aVar) {
        QQLiveAnchorDataAddress qQLiveAnchorDataAddress = new QQLiveAnchorDataAddress();
        if (aVar != null) {
            qQLiveAnchorDataAddress.url = aVar.f424007a;
            qQLiveAnchorDataAddress.bitrate = aVar.f424008b;
            qQLiveAnchorDataAddress.format = aVar.f424009c;
        }
        return qQLiveAnchorDataAddress;
    }

    private static final ArrayList<QQLiveAnchorDataAddress> c(ot3.a[] aVarArr) {
        ArrayList<QQLiveAnchorDataAddress> arrayList = new ArrayList<>();
        if (aVarArr != null) {
            for (ot3.a aVar : aVarArr) {
                arrayList.add(b(aVar));
            }
        }
        return arrayList;
    }

    public static pt3.a d(long j3, String str, String str2, int i3) {
        pt3.a aVar = new pt3.a();
        aVar.f427106a = j3;
        aVar.f427107b = i3;
        aVar.f427108c = 4;
        aVar.f427109d = J(str);
        aVar.f427110e = 3;
        pt3.c cVar = new pt3.c();
        cVar.f427121b = DeviceInfoMonitor.getModel();
        cVar.f427122c = "1.0.0";
        h hVar = new h();
        hVar.f427147b = 1280;
        hVar.f427146a = 720;
        cVar.f427123d = hVar;
        aVar.f427111f = cVar;
        aVar.f427113h = 0;
        aVar.f427114i = 0;
        aVar.f427115j = 0;
        aVar.f427116k = J(str2);
        return aVar;
    }

    public static final pt3.a e(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, int i3) {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData;
        return d(qQLiveAnchorDataRoomInfo.f271212id, qQLiveAnchorRoomInfo.trtcData.sig, qQLiveAnchorDataRoomInfo.programId, i3);
    }

    public static final gr4.d f(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        gr4.d dVar = new gr4.d();
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = qQLiveAnchorRoomInfo.roomData;
        dVar.f403103a = qQLiveAnchorDataRoomInfo.f271212id;
        dVar.f403105c = J(qQLiveAnchorDataRoomInfo.programId);
        dVar.f403106d = J(qQLiveAnchorRoomInfo.machieId);
        dVar.f403110h = I(qQLiveAnchorRoomInfo.roomData.pushType);
        return dVar;
    }

    public static final QQLiveAnchorDataEnter g(gr4.e eVar) {
        boolean z16;
        QQLiveAnchorDataEnter qQLiveAnchorDataEnter = new QQLiveAnchorDataEnter();
        if (eVar.f403111a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        qQLiveAnchorDataEnter.isSuccess = z16;
        if (!z16) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6250;
            qQLiveErrorMsg.bizErrMsg = "enter result error";
            qQLiveErrorMsg.originErrCode = eVar.f403111a;
            qQLiveErrorMsg.originErrMsg = eVar.f403112b;
            qQLiveAnchorDataEnter.errorMsg = qQLiveErrorMsg;
        }
        qQLiveAnchorDataEnter.roomInfo = q(eVar.f403113c);
        qQLiveAnchorDataEnter.userInfo = v(eVar.f403114d);
        qQLiveAnchorDataEnter.mediaInfo = n(eVar.f403115e);
        qQLiveAnchorDataEnter.trtcInfo = u(eVar.f403116f);
        qQLiveAnchorDataEnter.configInfo = m(eVar.f403118h);
        return qQLiveAnchorDataEnter;
    }

    private static final QQLiveAnchorDataFrame h(b bVar) {
        QQLiveAnchorDataFrame qQLiveAnchorDataFrame = new QQLiveAnchorDataFrame();
        if (bVar != null) {
            qQLiveAnchorDataFrame.level = bVar.f424011a;
            qQLiveAnchorDataFrame.definition = bVar.f424013c;
            qQLiveAnchorDataFrame.codecType = bVar.f424014d;
            qQLiveAnchorDataFrame.addresses = c(bVar.f424012b);
        }
        return qQLiveAnchorDataFrame;
    }

    private static final ArrayList<QQLiveAnchorDataFrame> i(b[] bVarArr) {
        ArrayList<QQLiveAnchorDataFrame> arrayList = new ArrayList<>();
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                arrayList.add(h(bVar));
            }
        }
        return arrayList;
    }

    public static final rq4.b j(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr) {
        rq4.b bVar = new rq4.b();
        bVar.f431968a = qQLiveAnchorDataRoomAttr.isECGoodsLive;
        bVar.f431970c = qQLiveAnchorDataRoomAttr.openTabLevel;
        return bVar;
    }

    public static final jt3.a k(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo) {
        jt3.a aVar = new jt3.a();
        long j3 = qQLiveAnchorRoomInfo.roomData.f271212id;
        aVar.f410946b = (int) j3;
        aVar.f410945a = (int) j3;
        String str = qQLiveAnchorRoomInfo.trtcData.sig;
        if (str != null) {
            aVar.f410947c = str.getBytes();
        }
        return aVar;
    }

    private static final ArrayList<Integer> l(int[] iArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (iArr != null) {
            for (int i3 : iArr) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        return arrayList;
    }

    public static QQLiveAnchorDataConfigInfo m(gr4.a aVar) {
        QQLiveAnchorDataConfigInfo qQLiveAnchorDataConfigInfo = new QQLiveAnchorDataConfigInfo();
        if (aVar != null) {
            qQLiveAnchorDataConfigInfo.commonConfig = aVar.f403089b;
            qQLiveAnchorDataConfigInfo.currentAnchorConfig = aVar.f403088a;
            qQLiveAnchorDataConfigInfo.gameAnchorConfig = aVar.f403090c;
            qQLiveAnchorDataConfigInfo.normalAnchorConfig = aVar.f403091d;
        }
        return qQLiveAnchorDataConfigInfo;
    }

    private static final QQLiveAnchorDataMediaInfo n(l lVar) {
        QQLiveAnchorDataMediaInfo qQLiveAnchorDataMediaInfo = new QQLiveAnchorDataMediaInfo();
        if (lVar != null) {
            qQLiveAnchorDataMediaInfo.sig = lVar.f403144a;
            qQLiveAnchorDataMediaInfo.timeout = lVar.f403145b;
            qQLiveAnchorDataMediaInfo.type = lVar.f403146c;
            qQLiveAnchorDataMediaInfo.serverPat = lVar.f403147d;
            qQLiveAnchorDataMediaInfo.streamParam = lVar.f403148e;
        }
        return qQLiveAnchorDataMediaInfo;
    }

    public static final QQLiveAnchorDataPrepare o(o oVar) {
        boolean z16;
        k[] kVarArr;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = new QQLiveAnchorDataPrepare();
        int i3 = 0;
        if (oVar.f403157a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        qQLiveAnchorDataPrepare.isSuccess = z16;
        if (!z16) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = 6200;
            qQLiveErrorMsg.bizErrMsg = "prepare result error";
            qQLiveErrorMsg.originErrCode = oVar.f403157a;
            qQLiveErrorMsg.originErrMsg = oVar.f403158b;
            qQLiveAnchorDataPrepare.errorMsg = qQLiveErrorMsg;
        }
        qQLiveAnchorDataPrepare.roomInfo = q(oVar.f403159c);
        if (oVar.f403162f != null) {
            ArrayList arrayList = new ArrayList();
            k[] kVarArr2 = oVar.f403162f;
            int length = kVarArr2.length;
            while (i3 < length) {
                k kVar = kVarArr2[i3];
                if (kVar == null) {
                    kVarArr = kVarArr2;
                } else {
                    kVarArr = kVarArr2;
                    arrayList.add(new LabelOriginInfo(kVar.f403143g, kVar.f403137a, kVar.f403142f, kVar.f403138b, kVar.f403139c, kVar.f403140d, kVar.f403141e));
                    QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = qQLiveAnchorDataPrepare.roomInfo;
                    if (qQLiveAnchorDataRoomInfo.roomGameType == kVar.f403141e) {
                        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = qQLiveAnchorDataRoomInfo.gameInfo;
                        qQLiveAnchorRoomGameInfo.f271211id = kVar.f403142f;
                        qQLiveAnchorRoomGameInfo.icon = kVar.f403139c;
                        qQLiveAnchorRoomGameInfo.name = kVar.f403138b;
                        qQLiveAnchorRoomGameInfo.secondTagId = kVar.f403143g;
                    }
                }
                i3++;
                kVarArr2 = kVarArr;
            }
            qQLiveAnchorDataPrepare.roomInfo.labelOriginInfos = arrayList;
        }
        QQLiveAnchorDataRoomAttr w3 = w(qQLiveAnchorDataPrepare.roomInfo);
        qQLiveAnchorDataPrepare.roomAttr = w3;
        w3.defaultRoomName = oVar.f403160d;
        w3.posterNum = oVar.f403161e;
        m mVar = oVar.f403163g;
        if (mVar != null) {
            qQLiveAnchorDataPrepare.popupDialogUrl = mVar.f403149a;
        }
        w3.backgroundInfo = oVar.f403168l;
        return qQLiveAnchorDataPrepare;
    }

    private static final QQLiveAnchorRoomGameInfo p(rq4.a aVar) {
        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo = new QQLiveAnchorRoomGameInfo();
        if (aVar != null) {
            qQLiveAnchorRoomGameInfo.f271211id = aVar.f431964a;
            qQLiveAnchorRoomGameInfo.icon = aVar.f431966c;
            qQLiveAnchorRoomGameInfo.name = aVar.f431965b;
            qQLiveAnchorRoomGameInfo.secondTagId = aVar.f431967d;
        }
        return qQLiveAnchorRoomGameInfo;
    }

    public static final QQLiveAnchorDataRoomInfo q(s sVar) {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo = new QQLiveAnchorDataRoomInfo();
        if (sVar != null) {
            qQLiveAnchorDataRoomInfo.f271212id = sVar.f403194a;
            qQLiveAnchorDataRoomInfo.name = sVar.f403195b;
            qQLiveAnchorDataRoomInfo.poster = sVar.f403196c;
            qQLiveAnchorDataRoomInfo.programId = sVar.f403197d;
            qQLiveAnchorDataRoomInfo.giftFlag = sVar.f403198e;
            qQLiveAnchorDataRoomInfo.coverUrl16v9 = sVar.f403202i;
            qQLiveAnchorDataRoomInfo.coverUrl3v4 = sVar.f403203j;
            qQLiveAnchorDataRoomInfo.roomPrepareNotify = sVar.f403204k;
            qQLiveAnchorDataRoomInfo.roomGameType = sVar.f403205l;
            qQLiveAnchorDataRoomInfo.systemNotice = sVar.f403206m;
            qQLiveAnchorDataRoomInfo.continueLiveStatus = sVar.f403207n;
            qQLiveAnchorDataRoomInfo.tags = r(sVar.f403201h);
            qQLiveAnchorDataRoomInfo.liveRoomType = sVar.f403211r;
            qQLiveAnchorDataRoomInfo.gameInfo = p(sVar.f403212s);
        }
        return qQLiveAnchorDataRoomInfo;
    }

    private static final QQLiveAnchorDataRoomRichTitle r(t tVar) {
        QQLiveAnchorDataRoomRichTitle qQLiveAnchorDataRoomRichTitle = new QQLiveAnchorDataRoomRichTitle();
        if (tVar != null && tVar.f403213a != null) {
            qQLiveAnchorDataRoomRichTitle.elements = new ArrayList<>();
            for (r rVar : tVar.f403213a) {
                qQLiveAnchorDataRoomRichTitle.elements.add(s(rVar));
            }
        }
        return qQLiveAnchorDataRoomRichTitle;
    }

    private static final QQLiveAnchorDataRichTitleElement s(r rVar) {
        QQLiveAnchorDataRichTitleElement qQLiveAnchorDataRichTitleElement = new QQLiveAnchorDataRichTitleElement();
        if (rVar != null) {
            qQLiveAnchorDataRichTitleElement.type = rVar.f403191a;
            qQLiveAnchorDataRichTitleElement.text = rVar.f403192b;
            qQLiveAnchorDataRichTitleElement.url = rVar.f403193c;
        }
        return qQLiveAnchorDataRichTitleElement;
    }

    private static final QQLiveAnchorDataStreamInfo t(w wVar) {
        QQLiveAnchorDataStreamInfo qQLiveAnchorDataStreamInfo = new QQLiveAnchorDataStreamInfo();
        if (wVar != null) {
            qQLiveAnchorDataStreamInfo.uid = wVar.f403230a;
            qQLiveAnchorDataStreamInfo.roomId = wVar.f403231b;
            qQLiveAnchorDataStreamInfo.mainStreamId = wVar.f403232c;
            qQLiveAnchorDataStreamInfo.auxStreamId = wVar.f403233d;
            qQLiveAnchorDataStreamInfo.isSelfInfo = wVar.f403234e;
            qQLiveAnchorDataStreamInfo.originUid = wVar.f403235f;
            qQLiveAnchorDataStreamInfo.originRoomId = wVar.f403236g;
        }
        return qQLiveAnchorDataStreamInfo;
    }

    private static final QQLiveAnchorDataTrtcInfo u(z zVar) {
        QQLiveAnchorDataTrtcInfo qQLiveAnchorDataTrtcInfo = new QQLiveAnchorDataTrtcInfo();
        if (zVar != null) {
            qQLiveAnchorDataTrtcInfo.sig = zVar.f403246a;
            qQLiveAnchorDataTrtcInfo.timeout = zVar.f403247b;
            qQLiveAnchorDataTrtcInfo.businessInfo = zVar.f403249d;
            qQLiveAnchorDataTrtcInfo.trtcStr = zVar.f403250e;
            qQLiveAnchorDataTrtcInfo.streamInfo = t(zVar.f403248c);
        }
        return qQLiveAnchorDataTrtcInfo;
    }

    private static final QQLiveAnchorDataUserInfo v(aa aaVar) {
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo = new QQLiveAnchorDataUserInfo();
        if (aaVar != null) {
            qQLiveAnchorDataUserInfo.f271213id = aaVar.f403092a;
            qQLiveAnchorDataUserInfo.explicitId = aaVar.f403093b;
            qQLiveAnchorDataUserInfo.nickName = aaVar.f403094c;
            qQLiveAnchorDataUserInfo.avatarUrl = aaVar.f403095d;
            qQLiveAnchorDataUserInfo.initialClientType = aaVar.f403096e;
            qQLiveAnchorDataUserInfo.businessUid = aaVar.f403097f;
            qQLiveAnchorDataUserInfo.tinyId = aaVar.f403098g;
        }
        return qQLiveAnchorDataUserInfo;
    }

    public static final QQLiveAnchorDataRoomAttr w(QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo) {
        boolean z16;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = new QQLiveAnchorDataRoomAttr();
        if (qQLiveAnchorDataRoomInfo != null) {
            qQLiveAnchorDataRoomAttr.roomId = qQLiveAnchorDataRoomInfo.f271212id;
            qQLiveAnchorDataRoomAttr.roomName = qQLiveAnchorDataRoomInfo.name;
            qQLiveAnchorDataRoomAttr.poster = qQLiveAnchorDataRoomInfo.poster;
            if (qQLiveAnchorDataRoomInfo.giftFlag == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qQLiveAnchorDataRoomAttr.enableGif = z16;
            qQLiveAnchorDataRoomAttr.poster3v4 = qQLiveAnchorDataRoomInfo.coverUrl3v4;
            qQLiveAnchorDataRoomAttr.poster16v9 = qQLiveAnchorDataRoomInfo.coverUrl16v9;
            qQLiveAnchorDataRoomAttr.tags = qQLiveAnchorDataRoomInfo.tags;
            qQLiveAnchorDataRoomAttr.liveRoomType = qQLiveAnchorDataRoomInfo.liveRoomType;
            qQLiveAnchorDataRoomAttr.pushType = qQLiveAnchorDataRoomInfo.pushType;
            qQLiveAnchorDataRoomAttr.gameInfo = qQLiveAnchorDataRoomInfo.gameInfo;
        }
        return qQLiveAnchorDataRoomAttr;
    }

    public static final rq4.a x(QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo) {
        rq4.a aVar = new rq4.a();
        if (qQLiveAnchorRoomGameInfo != null) {
            aVar.f431964a = qQLiveAnchorRoomGameInfo.f271211id;
            aVar.f431966c = J(qQLiveAnchorRoomGameInfo.icon);
            aVar.f431965b = J(qQLiveAnchorRoomGameInfo.name);
            aVar.f431967d = qQLiveAnchorRoomGameInfo.secondTagId;
        }
        return aVar;
    }

    public static final t y(QQLiveAnchorDataRoomRichTitle qQLiveAnchorDataRoomRichTitle) {
        ArrayList<QQLiveAnchorDataRichTitleElement> arrayList;
        t tVar = new t();
        if (qQLiveAnchorDataRoomRichTitle != null && (arrayList = qQLiveAnchorDataRoomRichTitle.elements) != null && arrayList.size() != 0) {
            r[] rVarArr = new r[qQLiveAnchorDataRoomRichTitle.elements.size()];
            for (int i3 = 0; i3 < qQLiveAnchorDataRoomRichTitle.elements.size(); i3++) {
                QQLiveAnchorDataRichTitleElement qQLiveAnchorDataRichTitleElement = qQLiveAnchorDataRoomRichTitle.elements.get(i3);
                r rVar = new r();
                rVar.f403191a = qQLiveAnchorDataRichTitleElement.type;
                rVar.f403192b = J(qQLiveAnchorDataRichTitleElement.text);
                rVar.f403193c = J(qQLiveAnchorDataRichTitleElement.url);
                rVarArr[i3] = rVar;
            }
            tVar.f403213a = rVarArr;
        } else {
            tVar.f403213a = new r[0];
        }
        return tVar;
    }

    public static final QQLiveAnchorDataPullInfo z(ot3.e eVar) {
        boolean z16;
        QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo = new QQLiveAnchorDataPullInfo();
        if (eVar.f424029a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        qQLiveAnchorDataPullInfo.isSuccess = z16;
        if (!z16) {
            QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
            qQLiveErrorMsg.bizModule = 2;
            qQLiveErrorMsg.bizErrCode = QQLiveError.ANCHOR_PULL_URL_ERR;
            qQLiveErrorMsg.bizErrMsg = "pull url result error";
            qQLiveErrorMsg.originErrCode = eVar.f424029a;
            qQLiveErrorMsg.originErrMsg = eVar.f424030b;
            qQLiveAnchorDataPullInfo.errorMsg = qQLiveErrorMsg;
        }
        qQLiveAnchorDataPullInfo.isSwitch = eVar.f424032d;
        qQLiveAnchorDataPullInfo.liveStat = eVar.f424034f;
        qQLiveAnchorDataPullInfo.sugLevel = eVar.f424035g;
        qQLiveAnchorDataPullInfo.avType = eVar.f424037i;
        qQLiveAnchorDataPullInfo.pixelsX = eVar.f424038j;
        qQLiveAnchorDataPullInfo.pixelsY = eVar.f424039k;
        qQLiveAnchorDataPullInfo.streams = G(eVar.f424031c);
        qQLiveAnchorDataPullInfo.levelList = l(eVar.f424033e);
        return qQLiveAnchorDataPullInfo;
    }
}
