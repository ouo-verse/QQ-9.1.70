package com.tencent.mobileqq.troop.utils;

import android.database.Observable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$TransFileRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileManager extends Observable<com.tencent.mobileqq.troop.data.q> {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name */
    public static final Long f301886r;

    /* renamed from: s, reason: collision with root package name */
    public static Map<Long, TroopFileManager> f301887s;

    /* renamed from: t, reason: collision with root package name */
    static final /* synthetic */ boolean f301888t;

    /* renamed from: a, reason: collision with root package name */
    public long f301889a;

    /* renamed from: b, reason: collision with root package name */
    public QQAppInterface f301890b;

    /* renamed from: c, reason: collision with root package name */
    public TroopFileTransferManager f301891c;

    /* renamed from: d, reason: collision with root package name */
    public Map<UUID, com.tencent.mobileqq.troop.data.n> f301892d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, com.tencent.mobileqq.troop.data.n> f301893e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayMap<Integer, List<com.tencent.mobileqq.troop.data.s>> f301894f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, e> f301895g;

    /* renamed from: h, reason: collision with root package name */
    public int f301896h;

    /* renamed from: i, reason: collision with root package name */
    public Handler f301897i;

    /* renamed from: j, reason: collision with root package name */
    public int f301898j;

    /* renamed from: k, reason: collision with root package name */
    public String f301899k;

    /* renamed from: l, reason: collision with root package name */
    public f f301900l;

    /* renamed from: m, reason: collision with root package name */
    public f f301901m;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.mobileqq.app.c f301902n;

    /* renamed from: o, reason: collision with root package name */
    private ef0.c f301903o;

    /* renamed from: p, reason: collision with root package name */
    private ef0.o f301904p;

    /* renamed from: q, reason: collision with root package name */
    private ef0.f f301905q;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileManager.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            Object[] objArr = (Object[]) message.obj;
            switch (message.what) {
                case 1:
                    TroopFileManager.this.K((List) objArr[0], ((Boolean) objArr[1]).booleanValue(), (String) objArr[2], ((Long) objArr[3]).longValue(), (ArrayList) objArr[4]);
                    return;
                case 2:
                    TroopFileManager.this.i((com.tencent.mobileqq.troop.data.n) objArr[0]);
                    return;
                case 3:
                    TroopFileManager.this.m((com.tencent.mobileqq.troop.data.n) objArr[0]);
                    return;
                case 4:
                    TroopFileManager.this.k((com.tencent.mobileqq.troop.data.n) objArr[0]);
                    return;
                case 5:
                    TroopFileManager.this.n(message.arg1);
                    return;
                case 6:
                    TroopFileManager.this.j((com.tencent.mobileqq.troop.data.n) objArr[0]);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.app.c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ boolean f301914e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76725);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f301914e = true;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileManager.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
        
            return;
         */
        @Override // com.tencent.mobileqq.app.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void g(Object obj) {
            com.tencent.mobileqq.troop.data.n nVar;
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            if (obj != null && (obj instanceof com.tencent.mobileqq.troop.data.t)) {
                com.tencent.mobileqq.troop.data.t tVar = (com.tencent.mobileqq.troop.data.t) obj;
                synchronized (TroopFileManager.this) {
                    long j3 = tVar.f294971e;
                    TroopFileManager troopFileManager = TroopFileManager.this;
                    if (j3 != troopFileManager.f301889a) {
                        return;
                    }
                    com.tencent.mobileqq.troop.data.n nVar2 = troopFileManager.f301892d.get(tVar.f294967a);
                    if (!f301914e && nVar2 == null) {
                        throw new AssertionError();
                    }
                    int i16 = nVar2.f294930p;
                    if (nVar2.f294916b == null && (str = tVar.f294985s) != null) {
                        TroopFileManager.this.f301893e.put(str, nVar2);
                    }
                    nVar2.q(tVar, TroopFileManager.this.f301890b);
                    int i17 = tVar.f294972f;
                    if (i17 == 12) {
                        com.tencent.mobileqq.troop.data.n nVar3 = TroopFileManager.this.f301893e.get(nVar2.f294929o);
                        if (nVar3 != null) {
                            nVar3.l(nVar2);
                        }
                        TroopFileManager.this.O(nVar2);
                        return;
                    }
                    boolean z16 = true;
                    if (nVar2.f294936v) {
                        if (i17 != 11) {
                            z16 = false;
                        }
                        nVar2.f294936v = z16;
                    } else if (i17 == 11 && nVar2.f294930p != 11) {
                        nVar2.f294936v = true;
                    }
                    if (!"/".equals(nVar2.f294929o) && (nVar = TroopFileManager.this.f301893e.get(nVar2.f294929o)) != null && ((i3 = nVar2.f294930p) == 9 || i3 == 10 || i3 == 11)) {
                        nVar.l(nVar2);
                    }
                    if (tVar.f294972f == 6 && i16 != 6) {
                        nVar2.k((int) NetConnInfoCenter.getServerTime());
                        nVar2.j((int) NetConnInfoCenter.getServerTime());
                        TroopFileManager.this.N(nVar2);
                    }
                    TroopFileManager.this.O(nVar2);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c extends ef0.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileManager.this);
            }
        }

        @Override // ef0.c
        protected void c(boolean z16, int i3, Bundle bundle, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), bundle, str, str2);
                return;
            }
            if (bundle == null) {
                return;
            }
            int dimensionPixelSize = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            String string = bundle.getString("fileId");
            e.b.c("TroopFileManager", e.b.f295938b, "delete onActionResult: fileId:" + string + " isSuccess:" + z16 + " errorCode:" + i3);
            if (z16) {
                TroopFileManager.this.x(string);
                return;
            }
            if (i3 != -302 && i3 != -301) {
                if (i3 != -121) {
                    if (i3 != -103) {
                        QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.ufq), 0).show(dimensionPixelSize);
                        return;
                    }
                } else {
                    QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.uf8), 0).show(dimensionPixelSize);
                    return;
                }
            }
            QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.ufn), 0).show(dimensionPixelSize);
            TroopFileManager.this.y(string);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d extends ef0.o {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileManager.this);
            }
        }

        @Override // ef0.o
        public void c(boolean z16, int i3, oidb_0x6d9$TransFileRspBody oidb_0x6d9_transfilerspbody, Bundle bundle) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), oidb_0x6d9_transfilerspbody, bundle);
                return;
            }
            TroopFileManager.this.f301896h--;
            if (z16 && oidb_0x6d9_transfilerspbody != null) {
                String string = bundle.getString("fileId");
                com.tencent.mobileqq.troop.data.n nVar = TroopFileManager.this.f301893e.get(string);
                if (nVar == null) {
                    return;
                }
                int i17 = oidb_0x6d9_transfilerspbody.int32_ret_code.get();
                e.b.c("TroopFileManager", e.b.f295938b, "onTransFileResult: fileId:" + string + " isSuccess:" + z16 + " errCode:" + i3 + " retCode:" + i17);
                if (i17 < 0) {
                    if (i17 != -25086) {
                        if (i17 != -6101) {
                            if (i17 != -403) {
                                if (i17 != -107 && i17 != -22) {
                                    if (i17 != -20001 && i17 != -20000) {
                                        if (i17 != -302 && i17 != -301 && i17 != -103) {
                                            if (i17 != -102) {
                                                if (i17 != -4) {
                                                    if (i17 != -3) {
                                                        i16 = 501;
                                                    } else {
                                                        i16 = 504;
                                                    }
                                                } else {
                                                    i16 = 103;
                                                }
                                                TroopFileManager.this.Q(nVar, i16);
                                                return;
                                            }
                                        }
                                    }
                                }
                                i16 = 101;
                                TroopFileManager.this.Q(nVar, i16);
                                return;
                            }
                        }
                        i16 = 502;
                        TroopFileManager.this.Q(nVar, i16);
                        return;
                    }
                    i16 = 503;
                    TroopFileManager.this.Q(nVar, i16);
                    return;
                }
                String str = oidb_0x6d9_transfilerspbody.str_save_file_path.get();
                TroopFileManager.this.f301891c.E0(nVar.f294915a, str);
                nVar.f294916b = str;
                nVar.f294919e = 102;
                nVar.f294923i = 0;
                TroopFileManager.this.f301893e.remove(string);
                TroopFileManager.this.f301893e.put(str, nVar);
                TroopFileManager.this.O(nVar);
                e eVar = TroopFileManager.this.f301895g.get(nVar.f294929o);
                if (eVar != null) {
                    eVar.f301923f = null;
                }
                TroopFileManager.this.Q(nVar, 505);
                return;
            }
            e.b.b("TroopFileManager", e.b.f295938b, "onTransFileResult:  isSuccess:false");
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface f {
        boolean a(com.tencent.mobileqq.troop.data.n nVar);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class g implements f {
        static IPatchRedirector $redirector_;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.TroopFileManager.f
        public boolean a(com.tencent.mobileqq.troop.data.n nVar) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar)).booleanValue();
            }
            if (nVar.f294940z || (i3 = nVar.f294930p) == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class h implements f {
        static IPatchRedirector $redirector_;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.TroopFileManager.f
        public boolean a(com.tencent.mobileqq.troop.data.n nVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar)).booleanValue();
            }
            if (nVar.f294918d > TroopFileManager.f301886r.longValue()) {
                return false;
            }
            int i3 = nVar.f294930p;
            if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
                return false;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76734);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        f301888t = true;
        f301886r = 4294967296L;
        f301887s = new HashMap();
    }

    public TroopFileManager(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, Long.valueOf(j3));
            return;
        }
        this.f301892d = new HashMap();
        this.f301893e = new HashMap();
        this.f301894f = new ArrayMap<>();
        this.f301895g = new HashMap();
        this.f301899k = "";
        this.f301900l = new g();
        this.f301901m = new h();
        this.f301902n = new b();
        this.f301903o = new c();
        this.f301904p = new d();
        this.f301905q = new ef0.f() { // from class: com.tencent.mobileqq.troop.utils.TroopFileManager.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileManager.this);
                }
            }

            @Override // ef0.f
            public void c(boolean z16, boolean z17, int i3, int i16, int i17, ByteStringMicro byteStringMicro, List<com.tencent.mobileqq.troop.data.n> list, Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), byteStringMicro, list, bundle);
                } else {
                    ThreadManagerV2.post(new Runnable(bundle, i16, byteStringMicro, z16, list, z17, i17, i3) { // from class: com.tencent.mobileqq.troop.utils.TroopFileManager.5.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int C;
                        final /* synthetic */ int D;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Bundle f301907d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f301908e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ ByteStringMicro f301909f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ boolean f301910h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ List f301911i;

                        /* renamed from: m, reason: collision with root package name */
                        final /* synthetic */ boolean f301912m;

                        {
                            this.f301907d = bundle;
                            this.f301908e = i16;
                            this.f301909f = byteStringMicro;
                            this.f301910h = z16;
                            this.f301911i = list;
                            this.f301912m = z17;
                            this.C = i17;
                            this.D = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass5.this, bundle, Integer.valueOf(i16), byteStringMicro, Boolean.valueOf(z16), list, Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i3));
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:100:0x05ae A[Catch: all -> 0x0660, TryCatch #0 {all -> 0x0660, blocks: (B:98:0x05aa, B:100:0x05ae, B:102:0x05b4, B:108:0x065b, B:109:0x05d5, B:110:0x05e3, B:115:0x05f7, B:117:0x05fb, B:119:0x0603, B:121:0x0607, B:123:0x060c, B:124:0x061b, B:125:0x062c, B:127:0x0630, B:129:0x0638, B:131:0x063c, B:133:0x0641, B:134:0x064d, B:201:0x043c, B:203:0x0440, B:205:0x0446, B:211:0x04ef, B:213:0x0467, B:214:0x0475, B:220:0x048b, B:222:0x048f, B:224:0x0497, B:226:0x049b, B:228:0x04a0, B:229:0x04af, B:230:0x04c0, B:232:0x04c4, B:234:0x04cc, B:236:0x04d0, B:238:0x04d5, B:239:0x04e1, B:325:0x065e, B:246:0x04f7, B:248:0x04fd, B:254:0x05a6, B:256:0x051e, B:257:0x052c, B:263:0x0542, B:265:0x0546, B:267:0x054e, B:269:0x0552, B:271:0x0557, B:272:0x0566, B:273:0x0577, B:275:0x057b, B:277:0x0583, B:279:0x0587, B:281:0x058c, B:282:0x0598), top: B:10:0x0016 }] */
                        /* JADX WARN: Removed duplicated region for block: B:111:0x05f1  */
                        /* JADX WARN: Removed duplicated region for block: B:186:0x0412 A[Catch: all -> 0x0439, TryCatch #3 {, blocks: (B:153:0x038e, B:154:0x0392, B:156:0x0398, B:159:0x03aa, B:161:0x03b4, B:166:0x03cc, B:168:0x03d0, B:170:0x03d8, B:174:0x03f0, B:180:0x03ff, B:182:0x0405, B:186:0x0412, B:195:0x0430), top: B:152:0x038e, outer: #1 }] */
                        /* JADX WARN: Removed duplicated region for block: B:189:0x042a A[SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            e eVar;
                            int i18;
                            List<com.tencent.mobileqq.troop.data.n> list2;
                            int i19;
                            int i26;
                            List<com.tencent.mobileqq.troop.data.n> list3;
                            int i27;
                            int i28;
                            List<com.tencent.mobileqq.troop.data.n> list4;
                            int i29;
                            int i36;
                            List<com.tencent.mobileqq.troop.data.n> list5;
                            int i37;
                            com.tencent.mobileqq.troop.data.n nVar;
                            int i38;
                            Iterator it;
                            boolean z18;
                            Iterator it5;
                            com.tencent.mobileqq.troop.data.n nVar2;
                            TroopFileManager troopFileManager;
                            boolean z19;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            TroopFileManager troopFileManager2 = TroopFileManager.this;
                            synchronized (troopFileManager2) {
                                try {
                                    try {
                                        int i39 = this.f301907d.getInt("reqFor");
                                        boolean z26 = this.f301907d.getBoolean("isFirstPage");
                                        String string = this.f301907d.getString("parentFileId");
                                        long j16 = this.f301907d.getLong("uin_filter");
                                        ArrayList<Long> arrayList = (ArrayList) this.f301907d.getSerializable("uin_filter_list");
                                        if (arrayList != null) {
                                            eVar = TroopFileManager.this.f301895g.get(string + TroopFileManager.this.D(arrayList));
                                        } else {
                                            eVar = TroopFileManager.this.f301895g.get(string + j16);
                                        }
                                        if (eVar == null) {
                                            return;
                                        }
                                        int i46 = 1;
                                        if (i39 == 1) {
                                            try {
                                                if (this.f301908e == -1000) {
                                                    if (!this.f301910h) {
                                                        if (QLog.isDevelopLevel()) {
                                                            QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i39);
                                                        }
                                                        if (i39 != 1) {
                                                            if (i39 == 3) {
                                                                eVar.f301922e = false;
                                                                TroopFileManager.this.M(null, false, string, j16, arrayList);
                                                            }
                                                        } else {
                                                            eVar.f301927j = 0L;
                                                            TroopFileManager.this.M(null, false, string, j16, arrayList);
                                                        }
                                                    } else if (i39 != 1) {
                                                        if (i39 == 3 && (list2 = eVar.f301924g) != null) {
                                                            if (list2.size() < 15 && !eVar.f301920c && (i19 = eVar.f301926i) <= 3) {
                                                                eVar.f301926i = i19 + 1;
                                                                eVar.f301922e = false;
                                                                TroopFileManager.this.J(string, j16, arrayList);
                                                            } else {
                                                                eVar.f301922e = false;
                                                                eVar.f301926i = 0;
                                                                TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                            }
                                                        }
                                                    } else {
                                                        List<com.tencent.mobileqq.troop.data.n> list6 = eVar.f301924g;
                                                        if (list6 != null) {
                                                            if (list6.size() < 15 && !eVar.f301920c && (i18 = eVar.f301926i) <= 3) {
                                                                eVar.f301926i = i18 + 1;
                                                                TroopFileManager.this.J(string, j16, arrayList);
                                                            } else {
                                                                eVar.f301926i = 0;
                                                                TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                            }
                                                        }
                                                    }
                                                    return;
                                                }
                                                eVar.f301923f = this.f301909f;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                if (this.f301910h) {
                                                }
                                                throw th;
                                            }
                                        }
                                        boolean z27 = this.f301910h;
                                        if (z27 && this.f301911i != null) {
                                            eVar.f301920c = this.f301912m;
                                            eVar.f301919b = this.C;
                                            if (z26) {
                                                eVar.f301918a = this.D;
                                                List<com.tencent.mobileqq.troop.data.n> G = TroopFileManager.this.G();
                                                eVar.f301924g.clear();
                                                eVar.f301925h.clear();
                                                for (com.tencent.mobileqq.troop.data.n nVar3 : G) {
                                                    TroopFileManager.this.f301892d.put(nVar3.f294915a, nVar3);
                                                    TroopFileManager.this.f301893e.put(nVar3.f294916b, nVar3);
                                                }
                                            }
                                            if (i39 == 1 || i39 == 3) {
                                                eVar.f301920c = this.f301912m;
                                            }
                                            List<com.tencent.mobileqq.troop.data.t> L = TroopFileManager.this.f301891c.L();
                                            for (com.tencent.mobileqq.troop.data.n nVar4 : this.f301911i) {
                                                if (nVar4.B) {
                                                    String str = nVar4.f294916b;
                                                    if (str != null) {
                                                        com.tencent.mobileqq.troop.data.n nVar5 = TroopFileManager.this.f301893e.get(str);
                                                        if (nVar5 == null) {
                                                            nVar4.f294915a = UUID.randomUUID();
                                                            TroopFileManager.this.f301893e.put(nVar4.f294916b, nVar4);
                                                            for (com.tencent.mobileqq.troop.data.t tVar : L) {
                                                                if (nVar4.f294916b.equals(tVar.f294991y)) {
                                                                    com.tencent.mobileqq.troop.data.n nVar6 = new com.tencent.mobileqq.troop.data.n();
                                                                    nVar6.f294915a = tVar.f294967a;
                                                                    nVar6.f294916b = tVar.f294985s;
                                                                    nVar6.f294929o = tVar.f294991y;
                                                                    nVar6.q(tVar, TroopFileManager.this.f301890b);
                                                                    nVar4.l(nVar6);
                                                                }
                                                            }
                                                        } else {
                                                            nVar5.m(nVar4);
                                                            nVar4 = nVar5;
                                                        }
                                                        TroopFileManager.this.f301892d.put(nVar4.f294915a, nVar4);
                                                        if (eVar.f301925h.get(nVar4.f294916b) == null) {
                                                            eVar.f301924g.add(nVar4);
                                                            eVar.f301925h.put(nVar4.f294916b, nVar4);
                                                        }
                                                        TroopFileManager.this.f301893e.put(nVar4.f294916b, nVar4);
                                                        troopFileManager = troopFileManager2;
                                                    }
                                                } else {
                                                    com.tencent.mobileqq.troop.data.t H = TroopFileManager.this.f301891c.H(nVar4.f294916b);
                                                    if (H == null) {
                                                        nVar4.f294915a = UUID.randomUUID();
                                                        nVar4.f294932r = nVar4.f294921g;
                                                    } else {
                                                        nVar4.f294915a = H.f294967a;
                                                        nVar4.q(H, TroopFileManager.this.f301890b);
                                                        if (nVar4.f294930p == 9 && (nVar2 = TroopFileManager.this.f301893e.get(H.f294991y)) != null) {
                                                            nVar2.l(nVar4);
                                                        }
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("onRspFileListV2: fileName = ");
                                                        sb5.append(nVar4.f294917c);
                                                        sb5.append(", localFile = ");
                                                        sb5.append(nVar4.f294934t);
                                                        sb5.append(", status = ");
                                                        sb5.append(nVar4.f294930p);
                                                        sb5.append(", statusInfo = ");
                                                        if (H == null) {
                                                            z19 = i46;
                                                        } else {
                                                            z19 = 0;
                                                        }
                                                        sb5.append(z19);
                                                        sb5.append(", filePath = ");
                                                        sb5.append(nVar4.f294916b);
                                                        sb5.append(", sha = ");
                                                        sb5.append(nVar4.f294926l);
                                                        QLog.i("TroopFileManager", 2, sb5.toString());
                                                    }
                                                    int i47 = nVar4.f294930p;
                                                    if (i47 != i46 && i47 != 3 && i47 != 2 && i47 != 12) {
                                                        com.tencent.mobileqq.troop.data.n nVar7 = TroopFileManager.this.f301893e.get(nVar4.f294916b);
                                                        if (nVar7 != null) {
                                                            nVar7.m(nVar4);
                                                            nVar4 = nVar7;
                                                        }
                                                        TroopFileManager troopFileManager3 = TroopFileManager.this;
                                                        troopFileManager = troopFileManager2;
                                                        try {
                                                            nVar4.r(troopFileManager3.f301890b, troopFileManager3.f301889a);
                                                            TroopFileManager.this.f301892d.put(nVar4.f294915a, nVar4);
                                                            if (eVar.f301925h.get(nVar4.f294916b) == null) {
                                                                eVar.f301924g.add(nVar4);
                                                                eVar.f301925h.put(nVar4.f294916b, nVar4);
                                                            }
                                                            TroopFileManager.this.f301893e.put(nVar4.f294916b, nVar4);
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            if (this.f301910h) {
                                                                if (QLog.isDevelopLevel()) {
                                                                    QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i39);
                                                                }
                                                                if (i39 != 1) {
                                                                    if (i39 == 3) {
                                                                        eVar.f301922e = false;
                                                                        TroopFileManager.this.M(null, false, string, j16, arrayList);
                                                                    }
                                                                } else {
                                                                    eVar.f301927j = 0L;
                                                                    TroopFileManager.this.M(null, false, string, j16, arrayList);
                                                                }
                                                            } else if (i39 != 1) {
                                                                if (i39 == 3 && (list3 = eVar.f301924g) != null) {
                                                                    if (list3.size() < 15 && !eVar.f301920c && (i27 = eVar.f301926i) <= 3) {
                                                                        eVar.f301926i = i27 + 1;
                                                                        eVar.f301922e = false;
                                                                        TroopFileManager.this.J(string, j16, arrayList);
                                                                    } else {
                                                                        eVar.f301922e = false;
                                                                        eVar.f301926i = 0;
                                                                        TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                                    }
                                                                }
                                                            } else {
                                                                List<com.tencent.mobileqq.troop.data.n> list7 = eVar.f301924g;
                                                                if (list7 != null) {
                                                                    if (list7.size() < 15 && !eVar.f301920c && (i26 = eVar.f301926i) <= 3) {
                                                                        eVar.f301926i = i26 + 1;
                                                                        TroopFileManager.this.J(string, j16, arrayList);
                                                                    } else {
                                                                        eVar.f301926i = 0;
                                                                        TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                                    }
                                                                }
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                }
                                                troopFileManager2 = troopFileManager;
                                                i46 = 1;
                                            }
                                            TroopFileManager troopFileManager4 = troopFileManager2;
                                            if (!"/".equals(string) && (nVar = TroopFileManager.this.f301893e.get(string)) != null) {
                                                Set<String> keySet = nVar.D.keySet();
                                                ArrayList arrayList2 = new ArrayList();
                                                Iterator<String> it6 = keySet.iterator();
                                                while (it6.hasNext()) {
                                                    arrayList2.add(it6.next());
                                                }
                                                int size = eVar.f301924g.size();
                                                synchronized (TroopFileManager.this.f301891c) {
                                                    Iterator it7 = arrayList2.iterator();
                                                    while (it7.hasNext()) {
                                                        com.tencent.mobileqq.troop.data.n nVar8 = nVar.D.get((String) it7.next());
                                                        if (nVar8 != null) {
                                                            if (size > 0) {
                                                                int i48 = size - 1;
                                                                if (eVar.f301924g.get(i48) != null) {
                                                                    int f16 = eVar.f301924g.get(i48).f();
                                                                    if (nVar8.f() >= f16) {
                                                                        int i49 = 0;
                                                                        z18 = false;
                                                                        while (true) {
                                                                            i38 = size;
                                                                            if (i49 >= size) {
                                                                                break;
                                                                            }
                                                                            if (nVar8.f294916b != null && eVar.f301924g.get(i49) != null) {
                                                                                it5 = it7;
                                                                                if (nVar8.f294916b.equals(eVar.f301924g.get(i49).f294916b)) {
                                                                                    z18 = true;
                                                                                }
                                                                            } else {
                                                                                it5 = it7;
                                                                            }
                                                                            i49++;
                                                                            size = i38;
                                                                            it7 = it5;
                                                                        }
                                                                        it = it7;
                                                                    } else {
                                                                        i38 = size;
                                                                        it = it7;
                                                                        z18 = false;
                                                                    }
                                                                    if (nVar8.f() <= f16 && !this.f301912m) {
                                                                        z18 = true;
                                                                    }
                                                                    if (z18) {
                                                                        nVar.D.remove(nVar8.f294916b);
                                                                        TroopFileManager.this.f301891c.b0(nVar8.f294915a, true);
                                                                    }
                                                                }
                                                            }
                                                            i38 = size;
                                                            it = it7;
                                                            z18 = false;
                                                            if (z18) {
                                                            }
                                                        } else {
                                                            i38 = size;
                                                            it = it7;
                                                        }
                                                        size = i38;
                                                        it7 = it;
                                                    }
                                                }
                                                TroopFileManager.this.O(nVar);
                                            }
                                            if (!this.f301910h) {
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i39);
                                                }
                                                if (i39 != 1) {
                                                    if (i39 == 3) {
                                                        eVar.f301922e = false;
                                                        TroopFileManager.this.M(null, false, string, j16, arrayList);
                                                    }
                                                } else {
                                                    eVar.f301927j = 0L;
                                                    TroopFileManager.this.M(null, false, string, j16, arrayList);
                                                }
                                            } else if (i39 != 1) {
                                                if (i39 == 3 && (list5 = eVar.f301924g) != null) {
                                                    if (list5.size() < 15 && !eVar.f301920c && (i37 = eVar.f301926i) <= 3) {
                                                        eVar.f301926i = i37 + 1;
                                                        eVar.f301922e = false;
                                                        TroopFileManager.this.J(string, j16, arrayList);
                                                    } else {
                                                        eVar.f301922e = false;
                                                        eVar.f301926i = 0;
                                                        TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                    }
                                                }
                                            } else {
                                                List<com.tencent.mobileqq.troop.data.n> list8 = eVar.f301924g;
                                                if (list8 != null) {
                                                    if (list8.size() < 15 && !eVar.f301920c && (i36 = eVar.f301926i) <= 3) {
                                                        eVar.f301926i = i36 + 1;
                                                        TroopFileManager.this.J(string, j16, arrayList);
                                                    } else {
                                                        eVar.f301926i = 0;
                                                        TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                    }
                                                }
                                            }
                                            return;
                                        }
                                        if (!z27) {
                                            if (QLog.isDevelopLevel()) {
                                                QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + i39);
                                            }
                                            if (i39 != 1) {
                                                if (i39 == 3) {
                                                    eVar.f301922e = false;
                                                    TroopFileManager.this.M(null, false, string, j16, arrayList);
                                                }
                                            } else {
                                                eVar.f301927j = 0L;
                                                TroopFileManager.this.M(null, false, string, j16, arrayList);
                                            }
                                        } else if (i39 != 1) {
                                            if (i39 == 3 && (list4 = eVar.f301924g) != null) {
                                                if (list4.size() < 15 && !eVar.f301920c && (i29 = eVar.f301926i) <= 3) {
                                                    eVar.f301926i = i29 + 1;
                                                    eVar.f301922e = false;
                                                    TroopFileManager.this.J(string, j16, arrayList);
                                                } else {
                                                    eVar.f301922e = false;
                                                    eVar.f301926i = 0;
                                                    TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                }
                                            }
                                        } else {
                                            List<com.tencent.mobileqq.troop.data.n> list9 = eVar.f301924g;
                                            if (list9 != null) {
                                                if (list9.size() < 15 && !eVar.f301920c && (i28 = eVar.f301926i) <= 3) {
                                                    eVar.f301926i = i28 + 1;
                                                    TroopFileManager.this.J(string, j16, arrayList);
                                                } else {
                                                    eVar.f301926i = 0;
                                                    TroopFileManager.this.M(eVar.f301924g, eVar.f301920c, string, j16, arrayList);
                                                }
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        throw th;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    throw th;
                                }
                            }
                        }
                    }, 8, null, true);
                }
            }
        };
        this.f301889a = j3;
        this.f301890b = qQAppInterface;
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, j3);
        this.f301891c = O;
        for (com.tencent.mobileqq.troop.data.t tVar : O.G()) {
            com.tencent.mobileqq.troop.data.n nVar = new com.tencent.mobileqq.troop.data.n();
            nVar.f294915a = tVar.f294967a;
            nVar.q(tVar, this.f301890b);
            this.f301892d.put(nVar.f294915a, nVar);
            String str = nVar.f294916b;
            if (str != null && !"/".equals(str)) {
                this.f301893e.put(nVar.f294916b, nVar);
            }
        }
        this.f301897i = new a(qQAppInterface.getApplication().getMainLooper());
        qQAppInterface.addObserver(this.f301902n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String D(@NonNull List<Long> list) {
        return String.valueOf(new LinkedHashSet(list).hashCode());
    }

    public static List<com.tencent.mobileqq.troop.data.n> E(Collection<com.tencent.mobileqq.troop.data.n> collection, f fVar) {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.troop.data.n nVar : collection) {
            if (fVar.a(nVar)) {
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    public static TroopFileManager F(QQAppInterface qQAppInterface, long j3) {
        TroopFileManager troopFileManager;
        synchronized (TroopFileManager.class) {
            troopFileManager = f301887s.get(Long.valueOf(j3));
            if (troopFileManager == null || troopFileManager.f301890b != qQAppInterface) {
                troopFileManager = new TroopFileManager(qQAppInterface, j3);
                f301887s.put(Long.valueOf(j3), troopFileManager);
            }
        }
        return troopFileManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        synchronized (this) {
            Iterator<com.tencent.mobileqq.troop.data.n> it = this.f301892d.values().iterator();
            while (it.hasNext()) {
                it.next().f294936v = false;
            }
        }
    }

    private synchronized void f() {
        this.f301890b.removeObserver(this.f301902n);
    }

    public static void g() {
        TroopFileTransferManager.j();
        synchronized (TroopFileManager.class) {
            Iterator<TroopFileManager> it = f301887s.values().iterator();
            while (it.hasNext()) {
                it.next().f();
            }
            f301887s.clear();
        }
    }

    public synchronized com.tencent.mobileqq.troop.data.n A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.troop.data.n) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        Map<String, com.tencent.mobileqq.troop.data.n> map = this.f301893e;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public synchronized com.tencent.mobileqq.troop.data.n B(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.troop.data.n) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uuid);
        }
        return this.f301892d.get(uuid);
    }

    public int C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.f301898j;
    }

    public final synchronized List<com.tencent.mobileqq.troop.data.n> G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return E(this.f301892d.values(), this.f301901m);
    }

    public final synchronized boolean H(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, str, Long.valueOf(j3))).booleanValue();
        }
        e eVar = this.f301895g.get(str + j3);
        if (eVar == null) {
            eVar = new e(j3);
        }
        return eVar.f301920c;
    }

    public final synchronized boolean J(String str, long j3, ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, str, Long.valueOf(j3), arrayList)).booleanValue();
        }
        String valueOf = String.valueOf(j3);
        if (arrayList != null) {
            valueOf = D(arrayList);
            QLog.i("TroopFileManager", 2, "morePagingFiles, filterUinList key is " + valueOf + ", size:" + arrayList.size());
        }
        e eVar = this.f301895g.get(str + valueOf);
        if (eVar == null) {
            eVar = new e(this, j3, arrayList);
            this.f301895g.put(str + valueOf, eVar);
        }
        e eVar2 = eVar;
        if (!eVar2.f301920c && !eVar2.f301922e) {
            com.tencent.biz.troop.file.a.f(this.f301890b, this.f301889a, eVar2.f301918a, 3, 20, 3, 1, str, eVar2.f301921d, j3, arrayList, eVar2.f301919b, eVar2.f301923f, this.f301905q);
            eVar2.f301922e = true;
            return true;
        }
        return false;
    }

    public void K(List<com.tencent.mobileqq.troop.data.n> list, boolean z16, String str, long j3, ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, list, Boolean.valueOf(z16), str, Long.valueOf(j3), arrayList);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).N0(list, z16, str, j3, arrayList);
        }
    }

    public void L(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) nVar);
        } else {
            this.f301891c.x(nVar.f294915a);
            this.f301897i.obtainMessage(2, new Object[]{nVar}).sendToTarget();
        }
    }

    public void M(Collection<com.tencent.mobileqq.troop.data.n> collection, boolean z16, String str, long j3, ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, collection, Boolean.valueOf(z16), str, Long.valueOf(j3), arrayList);
        } else {
            this.f301897i.obtainMessage(1, new Object[]{collection, Boolean.valueOf(z16), str, Long.valueOf(j3), arrayList}).sendToTarget();
        }
    }

    public void N(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) nVar);
        } else {
            this.f301897i.obtainMessage(6, new Object[]{nVar}).sendToTarget();
        }
    }

    public void O(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) nVar);
        } else {
            this.f301897i.obtainMessage(3, new Object[]{nVar}).sendToTarget();
        }
    }

    public synchronized boolean P(int i3, String str, long j3, ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, Long.valueOf(j3), arrayList)).booleanValue();
        }
        String valueOf = String.valueOf(j3);
        if (arrayList != null) {
            valueOf = D(arrayList);
            QLog.i("TroopFileManager", 2, "refreshPagingFiles, filterUinList key is " + valueOf + ", size:" + arrayList.size());
        }
        e eVar = this.f301895g.get(str + valueOf);
        if (eVar == null) {
            eVar = new e(this, j3, arrayList);
            this.f301895g.put(str + valueOf, eVar);
        }
        long currentTimeMillis = System.currentTimeMillis() - eVar.f301927j;
        if (0 < currentTimeMillis && currentTimeMillis < i3 * 1000) {
            return false;
        }
        eVar.f301927j = System.currentTimeMillis();
        com.tencent.biz.troop.file.a.f(this.f301890b, this.f301889a, eVar.f301918a, 1, 20, 3, 1, str, eVar.f301921d, j3, arrayList, 0, eVar.f301923f, this.f301905q);
        return true;
    }

    public void Q(com.tencent.mobileqq.troop.data.n nVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) nVar, i3);
        } else {
            TroopFileError.j(this.f301890b, this.f301889a, nVar.f294917c, nVar.f294930p, i3);
        }
    }

    public synchronized void R(String str, com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) nVar);
        } else {
            this.f301893e.put(str, nVar);
        }
    }

    public final synchronized boolean S(com.tencent.mobileqq.troop.data.n nVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) nVar)).booleanValue();
        }
        if (nVar.f294919e != 0 && nVar.f294916b != null) {
            int i3 = e.b.f295938b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            UUID uuid = nVar.f294915a;
            if (uuid != null) {
                str = uuid.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
            sb5.append("] transFile. mFileId:");
            sb5.append(nVar.f294916b);
            e.b.c("TroopFileManager", i3, sb5.toString());
            com.tencent.biz.troop.file.a.u(this.f301890b, this.f301889a, nVar, this.f301904p);
            this.f301896h++;
            return true;
        }
        return false;
    }

    public final synchronized void c(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) uuid);
            return;
        }
        if (uuid == null) {
            return;
        }
        com.tencent.mobileqq.troop.data.n nVar = this.f301892d.get(uuid);
        if (nVar != null && nVar.f294936v) {
            nVar.f294936v = false;
            O(nVar);
        }
    }

    public synchronized com.tencent.mobileqq.troop.data.n d(String str, long j3, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.troop.data.n) iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3), Integer.valueOf(i3), bundle);
        }
        com.tencent.mobileqq.troop.data.n nVar = new com.tencent.mobileqq.troop.data.n();
        if (bundle != null) {
            long j16 = bundle.getLong("TRANS_PARAM_NT_MSGID");
            long j17 = bundle.getLong("TRANS_PARAM_NT_ELEMENTID");
            if (j16 != 0) {
                nVar.G = j16;
            }
            if (j17 != 0) {
                nVar.H = j17;
            }
        }
        nVar.f294915a = UUID.randomUUID();
        nVar.f294917c = str;
        nVar.f294918d = j3;
        nVar.f294919e = i3;
        nVar.k((int) NetConnInfoCenter.getServerTime());
        this.f301892d.put(nVar.f294915a, nVar);
        return nVar;
    }

    public synchronized com.tencent.mobileqq.troop.data.n e(String str, String str2, long j3, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.troop.data.n) iPatchRedirector.redirect((short) 11, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), bundle);
        }
        return z(str, str2, j3, i3, bundle);
    }

    public void h(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) nVar);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).X0(nVar);
        }
    }

    public void i(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) nVar);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).p1(nVar);
        }
    }

    public void j(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) nVar);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).D1(nVar);
        }
    }

    public void k(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) nVar);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).B1(nVar);
        }
    }

    public void l(com.tencent.mobileqq.troop.data.n nVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) nVar, (Object) str);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).x0(nVar, str);
        }
    }

    public void m(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) nVar);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).I0(nVar);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        Iterator it = ((Observable) this).mObservers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.data.q) it.next()).m0(i3);
        }
    }

    public boolean o(com.tencent.mobileqq.troop.data.n nVar, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, nVar, Long.valueOf(j3), Long.valueOf(j16))).booleanValue();
        }
        if (nVar == null) {
            return false;
        }
        if (nVar.G == 0 && j3 != 0) {
            nVar.G = j3;
            z16 = true;
        }
        if (nVar.H == 0 && j16 != 0) {
            nVar.H = j16;
            z16 = true;
        }
        if (z16) {
            QLog.w("TroopFileManager", 1, "checkUpdateNtMsgAndElemId:" + nVar.f294915a.toString() + " ntMsgId:" + nVar.G + " ntElementId:" + nVar.H);
        }
        return z16;
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.af
                @Override // java.lang.Runnable
                public final void run() {
                    TroopFileManager.this.I();
                }
            }, 8, null, true);
        }
    }

    public boolean q(com.tencent.mobileqq.troop.data.q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) qVar)).booleanValue();
        }
        return ((Observable) this).mObservers.contains(qVar);
    }

    public synchronized com.tencent.mobileqq.troop.data.n r(String str, String str2, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.troop.data.n) iPatchRedirector.redirect((short) 9, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
        }
        com.tencent.mobileqq.troop.data.n nVar = new com.tencent.mobileqq.troop.data.n();
        UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes(str.getBytes());
        nVar.f294915a = nameUUIDFromBytes;
        nVar.f294916b = str;
        nVar.f294917c = str2;
        nVar.f294918d = j3;
        nVar.f294919e = i3;
        nVar.f294929o = "/";
        this.f301892d.put(nameUUIDFromBytes, nVar);
        this.f301893e.put(str, nVar);
        return nVar;
    }

    public synchronized com.tencent.mobileqq.troop.data.n s(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troop.data.n) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        com.tencent.mobileqq.troop.data.n nVar = new com.tencent.mobileqq.troop.data.n();
        nVar.f294915a = UUID.randomUUID();
        nVar.f294934t = str;
        File file = new File(str);
        nVar.f294918d = file.length();
        nVar.f294917c = file.getName();
        if (TextUtils.isEmpty(this.f301899k)) {
            str2 = "/";
        } else {
            str2 = this.f301899k;
        }
        nVar.f294929o = str2;
        this.f301892d.put(nVar.f294915a, nVar);
        return nVar;
    }

    public final synchronized void t(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) nVar);
        } else {
            u(nVar, 0, 0);
        }
    }

    public final synchronized void u(com.tencent.mobileqq.troop.data.n nVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, nVar, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (nVar != null && nVar.f294915a != null) {
            e.b.c("TroopFileManager", e.b.f295938b, "[" + nVar.f294915a.toString() + "] delete. mFileId:" + nVar.f294916b + " mParentId:" + nVar.f294929o + " uint32_bus_id:" + nVar.f294919e);
            String str = nVar.f294916b;
            if (str != null && nVar.f294929o != null && !"".equals(str) && !"".equals(nVar.f294929o)) {
                int i17 = nVar.f294919e;
                if (i17 == 0) {
                    return;
                }
                com.tencent.biz.troop.file.a.c(this.f301890b, this.f301889a, i17, nVar.f294916b, nVar.f294929o, i3, i16, this.f301903o);
                return;
            }
            w(nVar.f294915a);
        }
    }

    public final synchronized void v(com.tencent.mobileqq.troop.data.n nVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) nVar);
            return;
        }
        if (nVar != null) {
            int i3 = e.b.f295938b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            UUID uuid = nVar.f294915a;
            if (uuid != null) {
                str = uuid.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
            sb5.append("] doDelete2");
            e.b.c("TroopFileManager", i3, sb5.toString());
            this.f301893e.remove(nVar.f294916b);
            this.f301892d.remove(nVar.f294915a);
            L(nVar);
        }
    }

    public final synchronized void w(UUID uuid) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) uuid);
            return;
        }
        int i3 = e.b.f295938b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append("] doDelete");
        e.b.c("TroopFileManager", i3, sb5.toString());
        com.tencent.mobileqq.troop.data.n remove = this.f301892d.remove(uuid);
        if (remove == null) {
            return;
        }
        L(remove);
        this.f301893e.remove(remove.f294916b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        r4.f301892d.remove(r5.f294915a);
        L(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        e.b.c("TroopFileManager", e.b.f295938b, "doTroopFileDelete: filePath:" + str);
        com.tencent.mobileqq.troop.data.n remove = this.f301893e.remove(str);
        if (!f301888t && remove == null) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        r4.f301892d.remove(r5.f294915a);
        L(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        e.b.c("TroopFileManager", e.b.f295938b, "doUploadDelete: filePath:" + str);
        com.tencent.mobileqq.troop.data.n remove = this.f301893e.remove(str);
        if (!f301888t && remove == null) {
            throw new AssertionError();
        }
    }

    public synchronized com.tencent.mobileqq.troop.data.n z(String str, String str2, long j3, int i3, Bundle bundle) {
        long j16;
        long j17;
        long j18;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.troop.data.n) iPatchRedirector.redirect((short) 8, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), bundle);
        }
        if (str == null) {
            return null;
        }
        if (bundle != null) {
            j16 = bundle.getLong("TRANS_PARAM_NT_MSGID");
            j17 = bundle.getLong("TRANS_PARAM_NT_ELEMENTID");
            j18 = bundle.getLong("TRANS_PARAM_UPLOAD_TIME");
        } else {
            j16 = 0;
            j17 = 0;
            j18 = 0;
        }
        String c16 = com.tencent.mobileqq.troop.filemanager.e.c(str);
        if (c16 == null || c16.length() == 0) {
            c16 = "0";
        }
        com.tencent.mobileqq.troop.data.n nVar = this.f301893e.get(str);
        if (nVar != null) {
            o(nVar, j16, j17);
            this.f301892d.put(nVar.f294915a, nVar);
            return nVar;
        }
        com.tencent.mobileqq.troop.data.n nVar2 = this.f301893e.get(c16);
        if (nVar2 != null) {
            o(nVar2, j16, j17);
            this.f301892d.put(nVar2.f294915a, nVar2);
            return nVar2;
        }
        if (i3 == 0) {
            return null;
        }
        com.tencent.mobileqq.troop.data.n nVar3 = new com.tencent.mobileqq.troop.data.n();
        com.tencent.mobileqq.troop.data.t H = this.f301891c.H(str);
        if (H != null) {
            nVar3.f294915a = H.f294967a;
        }
        if (nVar3.f294915a == null) {
            nVar3.f294915a = UUID.nameUUIDFromBytes(str.getBytes());
        }
        nVar3.f294916b = str;
        nVar3.f294917c = str2;
        nVar3.f294918d = j3;
        nVar3.f294919e = i3;
        if (TextUtils.isEmpty(this.f301899k)) {
            str3 = "/";
        } else {
            str3 = this.f301899k;
        }
        nVar3.f294929o = str3;
        nVar3.G = j16;
        nVar3.H = j17;
        nVar3.f294922h = (int) j18;
        this.f301892d.put(nVar3.f294915a, nVar3);
        this.f301893e.put(str, nVar3);
        return nVar3;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f301918a;

        /* renamed from: b, reason: collision with root package name */
        public int f301919b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f301920c;

        /* renamed from: d, reason: collision with root package name */
        public int f301921d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f301922e;

        /* renamed from: f, reason: collision with root package name */
        public ByteStringMicro f301923f;

        /* renamed from: g, reason: collision with root package name */
        public List<com.tencent.mobileqq.troop.data.n> f301924g;

        /* renamed from: h, reason: collision with root package name */
        public Map<String, com.tencent.mobileqq.troop.data.n> f301925h;

        /* renamed from: i, reason: collision with root package name */
        public int f301926i;

        /* renamed from: j, reason: collision with root package name */
        public long f301927j;

        public e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 3;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileManager.this, Long.valueOf(j3));
                return;
            }
            this.f301918a = 0;
            this.f301920c = false;
            this.f301922e = false;
            this.f301919b = 0;
            this.f301926i = 0;
            this.f301927j = 0L;
            this.f301923f = ByteStringMicro.copyFromUtf8("");
            this.f301924g = new ArrayList();
            this.f301925h = new HashMap();
            if (j3 == 0) {
                this.f301921d = 0;
                i3 = 0;
            }
            this.f301921d = i3;
        }

        public e(TroopFileManager troopFileManager, long j3, ArrayList<Long> arrayList) {
            this(j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopFileManager, Long.valueOf(j3), arrayList);
            } else if (arrayList != null) {
                this.f301921d = 5;
            }
        }
    }
}
