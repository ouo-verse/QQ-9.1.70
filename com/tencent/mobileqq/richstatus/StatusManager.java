package com.tencent.mobileqq.richstatus;

import PersonalState.UserProfile;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.etrump.mixlayout.VasFontIPCModule;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.da;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.b;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.data.SquareJSConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.xml.sax.SAXException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StatusManager implements b.InterfaceC8524b, Manager {
    static IPatchRedirector $redirector_;
    private static volatile WeakReference<StatusManager> V;
    private static Object[] W;
    private long C;
    private long D;
    private com.tencent.mobileqq.app.h E;
    private m F;
    private da G;
    private long H;
    private long I;
    private HashSet<String> J;
    private LinkedList<e> K;
    private LinkedList<d> L;
    private LinkedList<f> M;
    private LinkedList<h> N;
    private LinkedList<g> P;
    private ArrayList<UserProfile> Q;
    private ArrayList<UserProfile> R;
    private AsyncTask<Void, Void, ArrayList<UserProfile>> S;
    private byte[] T;
    private HashMap<Long, UserProfile> U;

    /* renamed from: d, reason: collision with root package name */
    private volatile SparseArray<com.tencent.mobileqq.richstatus.a> f282268d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<l> f282269e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f282270f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.richstatus.b f282271h;

    /* renamed from: i, reason: collision with root package name */
    private volatile AsyncTask<Void, Integer, Integer> f282272i;

    /* renamed from: m, reason: collision with root package name */
    private RichStatus f282273m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richstatus.StatusManager$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass3 extends m {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.richstatus.StatusManager$3$1, reason: invalid class name */
        /* loaded from: classes18.dex */
        class AnonymousClass1 implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f282275d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f282276e;

            AnonymousClass1(boolean z16, Bundle bundle) {
                this.f282275d = z16;
                this.f282276e = bundle;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AnonymousClass3.this, Boolean.valueOf(z16), bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(StatusManager.this.f282270f.getAccount());
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, LogTag.RICH_STATUS);
                if (friendsSimpleInfoWithUid == null) {
                    friendsSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                    friendsSimpleInfoWithUid.v0(uidFromUin);
                    friendsSimpleInfoWithUid.w0(StatusManager.this.f282270f.getAccount());
                }
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = friendsSimpleInfoWithUid;
                if (this.f282275d) {
                    int i3 = this.f282276e.getInt("k_source", 0);
                    byte[] byteArray = this.f282276e.getByteArray("k_rspbody");
                    if (byteArray != null) {
                        ByteBuffer wrap = ByteBuffer.wrap(byteArray);
                        wrap.get();
                        int i16 = wrap.getInt();
                        byte[] bArr = new byte[wrap.getShort()];
                        wrap.get(bArr);
                        ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasInfoWithUid(uidFromUin, LogTag.RICH_STATUS, new hx3.b<kx3.a>(uidFromUin, dVar, i16, bArr, i3) { // from class: com.tencent.mobileqq.richstatus.StatusManager.3.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: a, reason: collision with root package name */
                            final /* synthetic */ String f282278a;

                            /* renamed from: b, reason: collision with root package name */
                            final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.d f282279b;

                            /* renamed from: c, reason: collision with root package name */
                            final /* synthetic */ int f282280c;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ byte[] f282281d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ int f282282e;

                            {
                                this.f282278a = uidFromUin;
                                this.f282279b = dVar;
                                this.f282280c = i16;
                                this.f282281d = bArr;
                                this.f282282e = i3;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, uidFromUin, dVar, Integer.valueOf(i16), bArr, Integer.valueOf(i3));
                                }
                            }

                            @Override // hx3.b
                            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<kx3.a> eVar) {
                                kx3.a aVar;
                                int i17;
                                Bundle bundle;
                                String str;
                                Bundle bundle2;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                                    return;
                                }
                                if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                                    aVar = eVar.b().get(0);
                                } else {
                                    aVar = new kx3.a();
                                    aVar.r0(this.f282278a);
                                    aVar.s0(this.f282279b.x());
                                }
                                long timestamp = aVar.getTimestamp();
                                int i18 = this.f282280c;
                                if (timestamp != i18) {
                                    com.tencent.mobileqq.richstatus.c.k(this.f282279b, this.f282281d, i18);
                                    RichStatus h16 = com.tencent.mobileqq.richstatus.c.h(this.f282279b);
                                    if (h16 != null) {
                                        RichStatus richStatus = StatusManager.this.f282273m;
                                        if (this.f282282e == 1 && (bundle2 = AnonymousClass1.this.f282276e) != null && bundle2.getInt("ret", 0) == 65535) {
                                            h16.fontId = 0;
                                            h16.fontType = 0;
                                        } else if (richStatus != null) {
                                            h16.fontId = richStatus.fontId;
                                            h16.fontType = richStatus.fontType;
                                            ArrayList<RichStatus.StickerInfo> arrayList = richStatus.mStickerInfos;
                                            if (arrayList != null && arrayList.size() > 0) {
                                                h16.mStickerInfos = new ArrayList<>(richStatus.mStickerInfos);
                                            }
                                        }
                                    }
                                }
                                RichStatus h17 = com.tencent.mobileqq.richstatus.c.h(this.f282279b);
                                if (AnonymousClass1.this.f282275d) {
                                    if (h17.tplId == 0) {
                                        str = "1";
                                    } else {
                                        str = "0";
                                    }
                                    ReportController.o(null, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, str, "", "", "");
                                }
                                TipsInfo tipsInfo = new TipsInfo();
                                Bundle bundle3 = AnonymousClass1.this.f282276e;
                                if (bundle3 != null && bundle3.getInt("k_source", 0) == 1) {
                                    tipsInfo.errorDesc = AnonymousClass1.this.f282276e.getString("errorDesc");
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (!anonymousClass1.f282275d && (bundle = anonymousClass1.f282276e) != null) {
                                    i17 = bundle.getInt("k_auth_code", -1);
                                    int i19 = AnonymousClass1.this.f282276e.getInt("cRet", 0);
                                    if (i19 == 2) {
                                        i17 = 103;
                                    } else if (i19 != 0) {
                                        i17 = i19;
                                    }
                                    if (TextUtils.isEmpty(tipsInfo.errorDesc) && AnonymousClass1.this.f282276e.containsKey("errorDesc")) {
                                        tipsInfo.errorDesc = AnonymousClass1.this.f282276e.getString("errorDesc");
                                    }
                                    boolean z16 = AnonymousClass1.this.f282276e.getBoolean("valid");
                                    tipsInfo.authAppid = AnonymousClass1.this.f282276e.getInt("authAppid");
                                    if (z16) {
                                        int i26 = AnonymousClass1.this.f282276e.getInt("type", -1);
                                        String string = AnonymousClass1.this.f282276e.getString("titleWording");
                                        String string2 = AnonymousClass1.this.f282276e.getString("wording");
                                        String string3 = AnonymousClass1.this.f282276e.getString("rightBtnWording");
                                        String string4 = AnonymousClass1.this.f282276e.getString("leftBtnWording");
                                        String string5 = AnonymousClass1.this.f282276e.getString("vipType");
                                        int i27 = AnonymousClass1.this.f282276e.getInt("vipMonth");
                                        String string6 = AnonymousClass1.this.f282276e.getString("url");
                                        tipsInfo.ret = AnonymousClass1.this.f282276e.getInt("ret");
                                        tipsInfo.type = i26;
                                        tipsInfo.titleWording = string;
                                        tipsInfo.wording = string2;
                                        tipsInfo.rightBtnWording = string3;
                                        tipsInfo.leftBtnWording = string4;
                                        tipsInfo.vipType = string5;
                                        tipsInfo.vipMonth = i27;
                                        tipsInfo.url = string6;
                                        if (i26 != 1) {
                                            if (i26 == 2) {
                                                if (TextUtils.isEmpty(string)) {
                                                    tipsInfo.titleWording = HardCodeUtil.qqStr(R.string.tpn);
                                                }
                                                if (TextUtils.isEmpty(string4)) {
                                                    tipsInfo.leftBtnWording = HardCodeUtil.qqStr(R.string.j6l);
                                                }
                                                if (TextUtils.isEmpty(string3)) {
                                                    tipsInfo.rightBtnWording = HardCodeUtil.qqStr(R.string.tpr);
                                                }
                                            }
                                        } else {
                                            if (TextUtils.isEmpty(string)) {
                                                tipsInfo.titleWording = HardCodeUtil.qqStr(R.string.tpo);
                                            }
                                            if (TextUtils.isEmpty(string4)) {
                                                tipsInfo.leftBtnWording = HardCodeUtil.qqStr(R.string.j6l);
                                            }
                                            if (TextUtils.isEmpty(string3)) {
                                                tipsInfo.rightBtnWording = HardCodeUtil.qqStr(R.string.tpq);
                                            }
                                        }
                                    }
                                } else {
                                    i17 = 100;
                                }
                                StatusManager.this.f282273m = null;
                                ThreadManager.getUIHandler().post(new Runnable(i17, h17, tipsInfo) { // from class: com.tencent.mobileqq.richstatus.StatusManager.3.1.1.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ int f282284d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ RichStatus f282285e;

                                    /* renamed from: f, reason: collision with root package name */
                                    final /* synthetic */ TipsInfo f282286f;

                                    {
                                        this.f282284d = i17;
                                        this.f282285e = h17;
                                        this.f282286f = tipsInfo;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, this, C85221.this, Integer.valueOf(i17), h17, tipsInfo);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else if (StatusManager.this.N != null) {
                                            Iterator it = StatusManager.this.N.iterator();
                                            while (it.hasNext()) {
                                                ((h) it.next()).onChangeStatus(this.f282284d, this.f282285e, this.f282286f);
                                            }
                                        }
                                    }
                                });
                                VasFontIPCModule.f().g(i17, h17, tipsInfo, 0);
                            }
                        });
                    }
                }
            }
        }

        AnonymousClass3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StatusManager.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.m
        @TargetApi(9)
        protected void a(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), bundle);
            } else {
                ThreadManager.getSubThreadHandler().post(new AnonymousClass1(z16, bundle));
            }
        }

        @Override // com.tencent.mobileqq.richstatus.m
        protected void b(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), bundle);
            } else {
                ThreadManager.getSubThreadHandler().post(new Runnable(z16) { // from class: com.tencent.mobileqq.richstatus.StatusManager.3.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ boolean f282288d;

                    {
                        this.f282288d = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass3.this, Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            StatusManager.this.f282273m = null;
                            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(StatusManager.this.f282270f.getAccount());
                            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                            RichStatus h16 = com.tencent.mobileqq.richstatus.c.h(iFriendsInfoService.getFriendsSimpleInfoWithUid(uidFromUin, LogTag.RICH_STATUS));
                            int i3 = 0;
                            if (h16 != null && (!TextUtils.isEmpty(h16.actionText) || !TextUtils.isEmpty(h16.dataText) || !TextUtils.isEmpty(h16.toSpannableStringWithoutAction()))) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (this.f282288d && !z17) {
                                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, StatusManager.this.f282270f.getAccount());
                                dVar.M();
                                com.tencent.mobileqq.richstatus.c.m(dVar, new byte[0], NetConnInfoCenter.getServerTimeMillis() / 1000);
                                iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, LogTag.RICH_STATUS, (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
                            }
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richstatus.StatusManager.3.2.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    int i16;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (StatusManager.this.N != null) {
                                        Iterator it = StatusManager.this.N.iterator();
                                        while (it.hasNext()) {
                                            h hVar = (h) it.next();
                                            if (AnonymousClass2.this.f282288d) {
                                                i16 = 100;
                                            } else {
                                                i16 = -1;
                                            }
                                            hVar.onChangeStatus(i16, RichStatus.getEmptyStatus(), null);
                                        }
                                    }
                                }
                            });
                            VasFontIPCModule f16 = VasFontIPCModule.f();
                            if (!this.f282288d) {
                                i3 = -1;
                            }
                            f16.g(i3, RichStatus.getEmptyStatus(), null, 1);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.richstatus.m
        protected void f(boolean z16, boolean z17, int i3, byte[] bArr, ArrayList<UserProfile> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z18 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), bArr, arrayList);
                return;
            }
            if (arrayList == null) {
                QLog.d("Q.richstatus.mate", 2, "onGetStatusMate " + z16 + " " + z17 + " " + i3 + " userInfo is null");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.mate", 2, "onGetStatusMate " + z16 + " " + z17 + " " + i3 + " " + arrayList.size());
            }
            if (z16) {
                StatusManager.this.T = bArr;
            } else if (z17) {
                StatusManager.this.T = null;
            }
            if (z16) {
                if (z17) {
                    if (StatusManager.this.S != null) {
                        StatusManager.this.Q = arrayList;
                        return;
                    }
                    if (StatusManager.this.R == null) {
                        StatusManager.this.R = new ArrayList();
                    }
                    StatusManager statusManager = StatusManager.this;
                    arrayList = statusManager.V(statusManager.R, arrayList, i3);
                } else {
                    arrayList = StatusManager.this.I(arrayList);
                }
            }
            if (StatusManager.this.T == null || StatusManager.this.T.length <= 0) {
                z18 = false;
            }
            if (StatusManager.this.P != null) {
                Iterator it = StatusManager.this.P.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).a(z16, z17, i3, arrayList, z18);
                }
            }
        }

        @Override // com.tencent.mobileqq.richstatus.m
        protected void g(boolean z16, boolean z17) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.shuo", 2, "onGetSyncShuoshuo " + z16 + ", " + z17);
            }
            if (z16) {
                StatusManager.this.C = 0L;
                StatusManager.this.g0(z17);
            } else {
                StatusManager.this.C = (System.currentTimeMillis() - 180000) + 60000;
                z17 = StatusManager.this.O().getBoolean("k_sync_ss", false);
            }
            if (StatusManager.this.N != null) {
                Iterator it = StatusManager.this.N.iterator();
                while (it.hasNext()) {
                    h hVar = (h) it.next();
                    if (z16) {
                        i3 = 100;
                    } else {
                        i3 = -1;
                    }
                    hVar.onGetSyncShuoShuo(i3, z17);
                }
            }
        }

        @Override // com.tencent.mobileqq.richstatus.m
        protected void h(boolean z16, boolean z17) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.shuo", 2, "onSetSyncShuoshuo " + z16 + ", " + z17);
            }
            if (z16) {
                StatusManager.this.g0(z17);
            } else {
                z17 = StatusManager.this.O().getBoolean("k_sync_ss", false);
            }
            if (StatusManager.this.N != null) {
                Iterator it = StatusManager.this.N.iterator();
                while (it.hasNext()) {
                    h hVar = (h) it.next();
                    if (z16) {
                        i3 = 100;
                    } else {
                        i3 = -1;
                    }
                    hVar.onSetSyncShuoShuo(i3, z17);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends AsyncTask<Void, Integer, Integer> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StatusManager.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(long j3) {
            InputStream fileInputStream;
            SparseArray sparseArray;
            StatusManager statusManager;
            long j16 = StatusManager.this.M().getLong("k_icon", 0L);
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask clearIcons " + j16 + ", " + j3 + ", 104");
            }
            if (j16 < j3) {
                if (j3 > 104) {
                    try {
                        fileInputStream = StatusManager.this.f282270f.getApp().getAssets().open("rich_status.xml");
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        fileInputStream = null;
                        sparseArray = (SparseArray) StatusManager.this.a0(fileInputStream)[0];
                        statusManager = StatusManager.this;
                        if (statusManager.c0(sparseArray, statusManager.f282268d)) {
                        }
                    }
                } else {
                    try {
                        fileInputStream = new FileInputStream(new File(StatusManager.this.f282270f.getApp().getFilesDir(), "rich_status.xml"));
                    } catch (FileNotFoundException e17) {
                        e17.printStackTrace();
                        fileInputStream = null;
                        sparseArray = (SparseArray) StatusManager.this.a0(fileInputStream)[0];
                        statusManager = StatusManager.this;
                        if (statusManager.c0(sparseArray, statusManager.f282268d)) {
                        }
                    }
                }
                sparseArray = (SparseArray) StatusManager.this.a0(fileInputStream)[0];
                statusManager = StatusManager.this;
                if (statusManager.c0(sparseArray, statusManager.f282268d)) {
                    StatusManager.this.M().edit().putLong("k_icon", j3).commit();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(Void... voidArr) {
            InputStream fileInputStream;
            SparseArray sparseArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            long j3 = StatusManager.this.M().getLong("k_version", 0L);
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "updateActions_Local with file " + j3 + ", 104");
            }
            if (j3 > 104) {
                try {
                    fileInputStream = new FileInputStream(new File(StatusManager.this.f282270f.getApp().getFilesDir(), "rich_status.xml"));
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
                if (fileInputStream == null) {
                    try {
                        fileInputStream = StatusManager.this.f282270f.getApp().getAssets().open("rich_status.xml");
                        j3 = 104;
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                Object[] a06 = StatusManager.this.a0(fileInputStream);
                sparseArray = (SparseArray) a06[0];
                ArrayList arrayList = (ArrayList) a06[1];
                if (sparseArray == null && sparseArray.size() != 0 && arrayList != null && arrayList.size() != 0) {
                    synchronized (StatusManager.this.f282268d) {
                        if (!isCancelled() && StatusManager.this.f282268d.size() == 0) {
                            StatusManager.this.f282268d = sparseArray;
                            StatusManager.this.f282269e.clear();
                            StatusManager.this.f282269e.addAll(arrayList);
                            publishProgress(102);
                        } else {
                            cancel(true);
                        }
                    }
                } else {
                    publishProgress(-1);
                }
                a(j3);
                return 100;
            }
            fileInputStream = null;
            if (fileInputStream == null) {
            }
            Object[] a062 = StatusManager.this.a0(fileInputStream);
            sparseArray = (SparseArray) a062[0];
            ArrayList arrayList2 = (ArrayList) a062[1];
            if (sparseArray == null) {
            }
            publishProgress(-1);
            a(j3);
            return 100;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) num);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onPostExecute " + num);
            }
            StatusManager.this.f282272i = null;
            if (101 == StatusManager.this.F(false)) {
                StatusManager.this.k0();
            }
            StatusManager.this.H(false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) numArr);
                return;
            }
            int intValue = numArr[0].intValue();
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onProgressUpdate " + intValue);
            }
            if (StatusManager.this.L != null) {
                Iterator it = StatusManager.this.L.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).v2(intValue, 300);
                }
            }
            VasFontIPCModule.f().i(intValue, 300);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onCancelled");
            }
            StatusManager.this.f282272i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.app.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StatusManager.this);
            }
        }

        @Override // com.tencent.mobileqq.app.h
        protected void n(boolean z16, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + z16 + ", " + i3);
            }
            StatusManager.this.D = 0L;
            if (z16) {
                if (i3 == 100) {
                    StatusManager.this.H = System.currentTimeMillis();
                    StatusManager.this.M().edit().putLong("k_update_time", StatusManager.this.H).commit();
                }
                StatusManager.this.H(true);
            }
            if (StatusManager.this.L != null) {
                Iterator it = StatusManager.this.L.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (z16) {
                        i16 = 300;
                    } else {
                        i16 = 301;
                    }
                    dVar.v2(i3, i16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends da {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StatusManager.this);
            }
        }

        @Override // com.tencent.mobileqq.app.da
        protected void e(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            int intValue = ((Integer) obj).intValue();
            VasFontIPCModule f16 = VasFontIPCModule.f();
            if (!z16) {
                i3 = -1;
            }
            f16.j(i3, intValue);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74789);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            W = new Object[2];
        }
    }

    StatusManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f282268d = new SparseArray<>();
        this.f282269e = new ArrayList<>();
        this.f282270f = qQAppInterface;
        this.J = new HashSet<>();
        this.H = M().getLong("k_update_time", 0L);
    }

    private boolean D() {
        int F = F(true);
        if (F != 100) {
            i0(F);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(boolean z16) {
        if (this.f282268d.size() == 0) {
            return 102;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(this.H - currentTimeMillis) > 43200000) {
            if (!z16) {
                return 101;
            }
            if (Math.abs(this.I - currentTimeMillis) > MiniBoxNoticeInfo.MIN_5) {
                this.I = currentTimeMillis;
                return 101;
            }
            return 100;
        }
        return 100;
    }

    public static StatusManager G(QQAppInterface qQAppInterface) {
        StatusManager statusManager;
        QQAppInterface qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface2 != qQAppInterface) {
            return (StatusManager) qQAppInterface2.getManager(QQManagerFactory.STATUS_MANAGER);
        }
        if (V != null) {
            statusManager = V.get();
        } else {
            statusManager = null;
        }
        if (statusManager == null) {
            StatusManager statusManager2 = new StatusManager(qQAppInterface);
            V = new WeakReference<>(statusManager2);
            return statusManager2;
        }
        statusManager.J.clear();
        statusManager.D = 0L;
        statusManager.C = 0L;
        statusManager.f282273m = null;
        com.tencent.mobileqq.app.h hVar = statusManager.E;
        if (hVar != null) {
            statusManager.f282270f.removeObserver(hVar);
            statusManager.E = null;
        }
        m mVar = statusManager.F;
        if (mVar != null) {
            statusManager.f282270f.unRegistObserver(mVar);
            statusManager.F = null;
        }
        com.tencent.mobileqq.richstatus.b bVar = statusManager.f282271h;
        if (bVar != null) {
            bVar.k();
        }
        da daVar = statusManager.G;
        if (daVar != null) {
            statusManager.f282270f.removeObserver(daVar);
            statusManager.G = null;
        }
        statusManager.f282270f = qQAppInterface;
        return statusManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences M() {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(this.f282270f.getApp().getBaseContext(), SquareJSConst.Params.PARAMS_RICH_STATUS, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(this.f282270f.getApp().getBaseContext(), SquareJSConst.Params.PARAMS_RICH_STATUS, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences O() {
        String str = SquareJSConst.Params.PARAMS_RICH_STATUS + this.f282270f.getCurrentAccountUin();
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(this.f282270f.getApp().getBaseContext(), str, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(this.f282270f.getApp().getBaseContext(), str, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    private void W() {
        b bVar = new b();
        this.E = bVar;
        this.f282270f.addObserver(bVar);
    }

    private void X() {
        c cVar = new c();
        this.G = cVar;
        this.f282270f.addObserver(cVar);
    }

    private void Y() {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        this.F = anonymousClass3;
        this.f282270f.registObserver(anonymousClass3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0073 -> B:19:0x0076). Please report as a decompilation issue!!! */
    public Object[] a0(InputStream inputStream) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "parseXmlFile(" + inputStream + ")");
        }
        Object[] objArr = new Object[2];
        if (inputStream == null) {
            return objArr;
        }
        n nVar = new n();
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                SAXParserFactory.newInstance().newSAXParser().parse(inputStream, nVar);
                SparseArray<com.tencent.mobileqq.richstatus.a> a16 = nVar.a();
                ArrayList<l> b16 = nVar.b();
                if (a16.size() > 1) {
                    objArr[0] = a16;
                }
                if (b16.size() > 0) {
                    objArr[1] = b16;
                }
                inputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
                inputStream.close();
            } catch (ParserConfigurationException e18) {
                e18.printStackTrace();
                inputStream.close();
            } catch (SAXException e19) {
                e19.printStackTrace();
                inputStream.close();
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("parseXmlFile return, action num: ");
                Object obj = objArr[0];
                int i16 = -1;
                if (obj != null) {
                    i3 = ((SparseArray) obj).size();
                } else {
                    i3 = -1;
                }
                sb5.append(i3);
                sb5.append(" tag num: ");
                Object obj2 = objArr[1];
                if (obj2 != null) {
                    i16 = ((ArrayList) obj2).size();
                }
                sb5.append(i16);
                QLog.d("Q.richstatus.xml", 2, sb5.toString());
            }
            return objArr;
        } catch (Throwable th5) {
            try {
                inputStream.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c0(SparseArray<com.tencent.mobileqq.richstatus.a> sparseArray, SparseArray<com.tencent.mobileqq.richstatus.a> sparseArray2) {
        String str;
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "removeOldIcons(" + sparseArray + ", " + sparseArray2 + ")");
        }
        File j3 = com.tencent.mobileqq.richstatus.b.j();
        int i3 = 0;
        if (j3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir is null");
            }
            return false;
        }
        if (!j3.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir does not exist!");
                return true;
            }
            return true;
        }
        if (!j3.canWrite()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir can not write!");
            }
            return false;
        }
        if (sparseArray == null) {
            File[] listFiles = j3.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i3 < length) {
                    File file = listFiles[i3];
                    if (file != null && file.exists() && !file.delete() && !file.delete()) {
                        file.delete();
                    }
                    i3++;
                }
            }
            boolean canWrite = j3.canWrite();
            if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + canWrite);
            }
            return canWrite;
        }
        ArrayList arrayList = new ArrayList();
        int size = sparseArray2.size();
        while (i3 < size) {
            com.tencent.mobileqq.richstatus.a valueAt = sparseArray2.valueAt(i3);
            com.tencent.mobileqq.richstatus.a aVar = sparseArray.get(valueAt.f282295b);
            if (aVar != null && (str2 = aVar.f282296c) != null && !str2.equalsIgnoreCase(valueAt.f282296c)) {
                arrayList.add(aVar.f282295b + "_s_201");
            }
            if (aVar != null && (str = aVar.f282297d) != null && !str.equalsIgnoreCase(valueAt.f282297d)) {
                arrayList.add(aVar.f282295b + "_s_200");
            }
            i3++;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file2 = new File(j3, (String) it.next());
            if (file2.exists() && !file2.delete() && !file2.delete()) {
                file2.delete();
            }
        }
        boolean canWrite2 = j3.canWrite();
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + canWrite2);
        }
        return canWrite2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(boolean z16) {
        O().edit().putBoolean("k_sync_ss", z16).putLong("k_ss_time", System.currentTimeMillis()).commit();
    }

    private int j0() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "updateActions_Local");
        }
        if (this.f282272i != null) {
            return 100;
        }
        this.f282272i = new a().execute(new Void[0]);
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "updateActions_Remote:" + currentTimeMillis + ", " + this.D + ", rich_status_android");
        }
        if (Math.abs(currentTimeMillis - this.D) > 240000) {
            ConfigHandler configHandler = (ConfigHandler) this.f282270f.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
            if (this.E == null) {
                W();
            }
            configHandler.y3(null, configHandler.N2());
            this.D = currentTimeMillis;
            return 100;
        }
        return 100;
    }

    public synchronized void C(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        if (obj instanceof e) {
            LinkedList<e> linkedList = this.K;
            if (linkedList == null) {
                LinkedList<e> linkedList2 = new LinkedList<>();
                this.K = linkedList2;
                linkedList2.add((e) obj);
            } else if (!linkedList.contains(obj)) {
                this.K.add((e) obj);
            }
        }
        if (obj instanceof d) {
            LinkedList<d> linkedList3 = this.L;
            if (linkedList3 == null) {
                LinkedList<d> linkedList4 = new LinkedList<>();
                this.L = linkedList4;
                linkedList4.add((d) obj);
            } else if (!linkedList3.contains(obj)) {
                this.L.add((d) obj);
            }
        }
        if (obj instanceof f) {
            LinkedList<f> linkedList5 = this.M;
            if (linkedList5 == null) {
                LinkedList<f> linkedList6 = new LinkedList<>();
                this.M = linkedList6;
                linkedList6.add((f) obj);
            } else if (!linkedList5.contains(obj)) {
                this.M.add((f) obj);
            }
        }
        if (obj instanceof h) {
            LinkedList<h> linkedList7 = this.N;
            if (linkedList7 == null) {
                LinkedList<h> linkedList8 = new LinkedList<>();
                this.N = linkedList8;
                linkedList8.add((h) obj);
            } else if (!linkedList7.contains(obj)) {
                this.N.add((h) obj);
            }
        }
        if (obj instanceof g) {
            LinkedList<g> linkedList9 = this.P;
            if (linkedList9 == null) {
                LinkedList<g> linkedList10 = new LinkedList<>();
                this.P = linkedList10;
                linkedList10.add((g) obj);
            } else if (!linkedList9.contains(obj)) {
                this.P.add((g) obj);
            }
        }
    }

    public int E(RichStatus richStatus, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) richStatus, i3)).intValue();
        }
        if (richStatus == null) {
            return 100;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.richstatus.set", 2, String.format("changeStatus %d,%d [%s]", Integer.valueOf(richStatus.actionId), Integer.valueOf(i3), richStatus.toSpannableString(null)));
        }
        this.f282273m = richStatus;
        if (richStatus.isEmpty()) {
            if (this.f282270f != null) {
                NewIntent newIntent = new NewIntent(this.f282270f.getApp(), StatusServlet.class);
                newIntent.putExtra("k_cmd", 8);
                this.f282270f.startServlet(newIntent);
            }
        } else {
            byte[] encode = richStatus.encode();
            NewIntent newIntent2 = new NewIntent(this.f282270f.getApp(), StatusServlet.class);
            newIntent2.putExtra("k_cmd", 9);
            newIntent2.putExtra("k_tpl_id", richStatus.tplId);
            newIntent2.putExtra("k_font_id", richStatus.fontId);
            newIntent2.putExtra("k_sign_len", encode.length);
            newIntent2.putExtra("k_sign_data", encode);
            newIntent2.putExtra("k_source", i3);
            this.f282270f.startServlet(newIntent2);
        }
        if (this.F == null) {
            Y();
        }
        return 100;
    }

    protected void H(boolean z16) {
        LinkedList<f> linkedList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        LinkedList<e> linkedList2 = this.K;
        if ((linkedList2 != null && linkedList2.size() != 0) || ((linkedList = this.M) != null && linkedList.size() != 0)) {
            Iterator<String> it = this.J.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String[] split = next.split("_");
                com.tencent.mobileqq.richstatus.a aVar = this.f282268d.get(Integer.parseInt(split[0]));
                if (aVar != null) {
                    if (split.length == 3) {
                        if (Integer.parseInt(split[2]) == 201) {
                            str = aVar.f282296c;
                        } else {
                            str = aVar.f282297d;
                        }
                    } else if (split.length == 2 && !TextUtils.isEmpty(aVar.f282303j)) {
                        str = aVar.f282303j.replace("$U", split[1]);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        Bitmap g16 = this.f282271h.g(next, null, str);
                        if (g16 != null) {
                            a(next, str, g16, 1);
                        }
                    } else {
                        it.remove();
                    }
                }
            }
            if (z16) {
                this.J.clear();
                return;
            }
            return;
        }
        this.J.clear();
    }

    protected ArrayList<UserProfile> I(ArrayList<UserProfile> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (ArrayList) iPatchRedirector.redirect((short) 28, (Object) this, (Object) arrayList);
        }
        HashMap<Long, UserProfile> hashMap = this.U;
        int size = arrayList.size();
        int i3 = -1;
        if (hashMap != null && hashMap.size() > 0 && size > 0) {
            for (int i16 = size - 1; i16 > -1; i16--) {
                UserProfile userProfile = arrayList.get(i16);
                UserProfile userProfile2 = hashMap.get(Long.valueOf(userProfile.lEctID));
                if (userProfile2 != null) {
                    userProfile2.bAge = userProfile.bAge;
                    userProfile2.bSex = userProfile.bSex;
                    userProfile2.strDesc = userProfile.strDesc;
                    arrayList.remove(i16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("filterFriends ");
            sb5.append(size);
            sb5.append(" - ");
            if (hashMap != null) {
                i3 = hashMap.size();
            }
            sb5.append(i3);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(arrayList.size());
            QLog.d("Q.richstatus.mate", 2, sb5.toString());
        }
        return arrayList;
    }

    public com.tencent.mobileqq.richstatus.a J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.richstatus.a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        com.tencent.mobileqq.richstatus.a aVar = this.f282268d.get(i3);
        if (aVar == null) {
            D();
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap K(int i3, int i16) {
        String str;
        Bitmap f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (this.f282271h == null) {
            this.f282271h = new com.tencent.mobileqq.richstatus.b("StatusIcon_", this);
        }
        com.tencent.mobileqq.richstatus.a aVar = this.f282268d.get(i3);
        String str2 = i3 + "_s_" + i16;
        com.tencent.mobileqq.richstatus.b bVar = this.f282271h;
        Bitmap bitmap = null;
        if (aVar != null) {
            if (i16 == 201) {
                str = aVar.f282296c;
            } else {
                str = aVar.f282297d;
            }
        } else {
            str = null;
        }
        Bitmap g16 = bVar.g(str2, null, str);
        if (aVar == null && D() && g16 == null) {
            this.J.add(str2);
        }
        if (i16 == 201) {
            try {
                ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                f16 = imageCacheHelper.f("StatusIcon_RichStatusDefaultBig");
                if (f16 == null) {
                    try {
                        f16 = com.tencent.mobileqq.util.j.g(this.f282270f.getApp().getResources(), R.drawable.bwj);
                        imageCacheHelper.i("StatusIcon_RichStatusDefaultBig", f16, Business.Conversation);
                    } catch (OutOfMemoryError unused) {
                    }
                }
            } catch (OutOfMemoryError unused2) {
            }
            if (g16 == null) {
                if (i16 == 201) {
                    return f16;
                }
                return bitmap;
            }
            return g16;
        }
        if (i16 == 200) {
            ImageCacheHelper imageCacheHelper2 = ImageCacheHelper.f98636a;
            Bitmap f17 = imageCacheHelper2.f("StatusIcon_RichStatusDefaultSmall");
            if (f17 == null) {
                f17 = com.tencent.mobileqq.util.j.g(this.f282270f.getApp().getResources(), R.drawable.bwk);
                imageCacheHelper2.i("StatusIcon_RichStatusDefaultSmall", f17, Business.Conversation);
            }
            bitmap = f17;
            f16 = null;
            if (g16 == null) {
            }
        }
        f16 = null;
        if (g16 == null) {
        }
    }

    public long L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return M().getLong("k_version", 0L);
    }

    public void N(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
            return;
        }
        ((SignatureHandler) this.f282270f.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).H2(j3);
        if (this.G == null) {
            X();
        }
    }

    public int P(ArrayList<l> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList)).intValue();
        }
        if (arrayList != null) {
            arrayList.clear();
            if (this.f282269e.size() > 0) {
                arrayList.addAll(this.f282269e);
            }
            return F(false);
        }
        throw new InvalidParameterException("array list is null");
    }

    public RichStatus Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (RichStatus) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return R(true);
    }

    public RichStatus R(boolean z16) {
        RichStatus richStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RichStatus) iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
        RichStatus richStatus2 = this.f282273m;
        if (richStatus2 != null) {
            return richStatus2;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f282270f.getCurrentAccountUin()), LogTag.RICH_STATUS);
        if (friendsSimpleInfoWithUid != null) {
            richStatus = com.tencent.mobileqq.richstatus.c.h(friendsSimpleInfoWithUid);
        } else {
            richStatus = null;
        }
        if (richStatus == null) {
            return new RichStatus(null);
        }
        return richStatus;
    }

    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        SharedPreferences O = O();
        boolean z16 = O.getBoolean("k_sync_ss", false);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.C) > 180000 && Math.abs(currentTimeMillis - O.getLong("k_ss_time", 0L)) > 60000) {
            if (this.F == null) {
                Y();
            }
            this.C = currentTimeMillis;
            StatusServlet.e(this.f282270f);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo " + z16);
        }
        return z16;
    }

    public boolean T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f282273m != null) {
            return true;
        }
        return false;
    }

    public boolean U(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, j3)).booleanValue();
        }
        long j16 = M().getLong("k_version", 104L);
        if (j16 < 104) {
            j16 = 104;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "StatusManager.isNewVersion(): localVersion " + j16 + " serverVersion " + j3 + ", builtInVersion 104");
        }
        if (j3 > j16) {
            return true;
        }
        return false;
    }

    protected ArrayList<UserProfile> V(ArrayList<UserProfile> arrayList, ArrayList<UserProfile> arrayList2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ArrayList) iPatchRedirector.redirect((short) 27, this, arrayList, arrayList2, Integer.valueOf(i3));
        }
        HashMap<Long, UserProfile> hashMap = new HashMap<>();
        ArrayList<UserProfile> arrayList3 = new ArrayList<>();
        if (i3 == -1) {
            arrayList3.addAll(arrayList);
            Iterator<UserProfile> it = arrayList.iterator();
            while (it.hasNext()) {
                UserProfile next = it.next();
                hashMap.put(Long.valueOf(next.lEctID), next);
            }
        } else {
            Iterator<UserProfile> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                UserProfile next2 = it5.next();
                if (next2.bSex == i3) {
                    arrayList3.add(next2);
                    hashMap.put(Long.valueOf(next2.lEctID), next2);
                }
            }
        }
        long j3 = 0L;
        try {
            j3 = Long.valueOf(Long.parseLong(this.f282270f.getCurrentAccountUin()));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.richstatus.xml", 2, e16.toString());
            }
        }
        hashMap.put(j3, new UserProfile());
        Iterator<UserProfile> it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            UserProfile next3 = it6.next();
            UserProfile userProfile = hashMap.get(Long.valueOf(next3.lEctID));
            if (userProfile == null) {
                arrayList3.add(next3);
            } else {
                userProfile.bAge = next3.bAge;
                userProfile.bSex = next3.bSex;
                userProfile.strDesc = next3.strDesc;
            }
        }
        this.U = hashMap;
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.mate", 2, "mergeFriendsStrangers " + arrayList.size() + " " + arrayList2.size() + " " + i3 + ContainerUtils.KEY_VALUE_DELIMITER + arrayList3.size());
        }
        return arrayList3;
    }

    @Override // com.tencent.mobileqq.richstatus.b.InterfaceC8524b
    public void a(String str, String str2, Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, str2, bitmap, Integer.valueOf(i3));
            return;
        }
        if (str2 == null && bitmap != null) {
            this.J.remove(str);
        }
        String[] split = str.split("_");
        if (split.length == 3) {
            if (this.K != null) {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[2]);
                Iterator<e> it = this.K.iterator();
                while (it.hasNext()) {
                    it.next().onGetIcon(parseInt, parseInt2, bitmap);
                }
                return;
            }
            return;
        }
        if (split.length == 2 && this.M != null) {
            int parseInt3 = Integer.parseInt(split[0]);
            int parseInt4 = Integer.parseInt(split[1]);
            Iterator<f> it5 = this.M.iterator();
            while (it5.hasNext()) {
                it5.next().a(parseInt3, parseInt4, bitmap, i3);
            }
        }
    }

    public void b0(Object obj) {
        LinkedList<g> linkedList;
        LinkedList<h> linkedList2;
        LinkedList<f> linkedList3;
        LinkedList<d> linkedList4;
        LinkedList<e> linkedList5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        if ((obj instanceof e) && (linkedList5 = this.K) != null) {
            linkedList5.remove(obj);
        }
        if ((obj instanceof d) && (linkedList4 = this.L) != null) {
            linkedList4.remove(obj);
        }
        if ((obj instanceof f) && (linkedList3 = this.M) != null) {
            linkedList3.remove(obj);
        }
        if ((obj instanceof h) && (linkedList2 = this.N) != null) {
            linkedList2.remove(obj);
        }
        if ((obj instanceof g) && (linkedList = this.P) != null) {
            linkedList.remove(obj);
        }
    }

    public String d0(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        }
        return str.replace("$I", Integer.toString(i3)).replace("$U", Integer.toString(i16)).replace("$A", this.f282270f.getCurrentAccountUin()).replace("$N", str2);
    }

    public boolean e0(File file, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, this, file, Long.valueOf(j3))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "saveActions(" + file + ", " + j3 + ")");
        }
        try {
            Object[] a06 = a0(new FileInputStream(file));
            SparseArray<com.tencent.mobileqq.richstatus.a> sparseArray = (SparseArray) a06[0];
            ArrayList arrayList = (ArrayList) a06[1];
            if (sparseArray != null && sparseArray.size() > 0 && arrayList != null && arrayList.size() > 0) {
                SparseArray<com.tencent.mobileqq.richstatus.a> sparseArray2 = this.f282268d;
                synchronized (this.f282268d) {
                    AsyncTask<Void, Integer, Integer> asyncTask = this.f282272i;
                    if (asyncTask != null) {
                        asyncTask.cancel(true);
                    }
                    this.f282268d = sparseArray;
                }
                if (arrayList.size() > 0) {
                    synchronized (this.f282269e) {
                        this.f282269e.clear();
                        this.f282269e.addAll(arrayList);
                    }
                }
                this.H = System.currentTimeMillis();
                File file2 = new File(this.f282270f.getApp().getFilesDir(), "rich_status.xml");
                if (!file.renameTo(file2) && !file.renameTo(file2) && !file.renameTo(file2)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.richstatus.xml", 2, "saveActions rename failed!");
                    }
                    z16 = true;
                }
                SharedPreferences.Editor edit = M().edit();
                edit.putLong("k_version", j3).putLong("k_update_time", this.H).commit();
                if (c0(sparseArray2, this.f282268d)) {
                    edit.putLong("k_icon", j3).commit();
                }
                z16 = true;
            }
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.xml", 2, "saveActions return with " + z16);
        }
        return z16;
    }

    public void f0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        this.f282270f.getPreferences().edit().putString(this.f282270f.getCurrentAccountUin() + "sp_hot_status", str).commit();
    }

    public int h0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, z16)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.shuo", 2, "setSyncShuoShuo " + z16);
        }
        if (this.F == null) {
            Y();
        }
        StatusServlet.h(this.f282270f, z16);
        return 100;
    }

    public int i0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (i3 == 102) {
            return j0();
        }
        if (i3 == 101) {
            return k0();
        }
        return -1;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        }
    }
}
