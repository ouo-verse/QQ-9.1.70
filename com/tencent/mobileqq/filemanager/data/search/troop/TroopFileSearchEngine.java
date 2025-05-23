package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.filemanager.data.search.e;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.search.ae;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.l;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.filemanager.data.d;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchReqBody;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchRspBody;
import tencent.im.cs.cmd0x383.cmd0x383$ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383$RspBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TroopFileSearchEngine implements on2.b<com.tencent.mobileqq.filemanager.data.search.troop.a>, ae.e {
    private ae C;
    private List<d> K;
    private e M;
    private on2.d<com.tencent.mobileqq.filemanager.data.search.troop.a> N;

    /* renamed from: d, reason: collision with root package name */
    private int f207942d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f207943e;

    /* renamed from: f, reason: collision with root package name */
    private Context f207944f;

    /* renamed from: h, reason: collision with root package name */
    private long f207945h;

    /* renamed from: m, reason: collision with root package name */
    protected List<Long> f207947m;

    /* renamed from: i, reason: collision with root package name */
    private List<j> f207946i = new ArrayList();
    private boolean D = false;
    private volatile boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private long H = 0;
    private String I = "";
    private String J = "";
    private volatile boolean L = true;
    private int P = 1;
    protected com.tencent.mobileqq.app.c Q = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.app.c {
        a() {
        }

        @Override // com.tencent.mobileqq.app.c
        protected void f(boolean z16, Object obj) {
            boolean z17;
            ArrayList arrayList = new ArrayList();
            TroopFileSearchEngine.this.L = true;
            try {
                if (obj != null && z16) {
                    try {
                        cmd0x383$RspBody mergeFrom = new cmd0x383$RspBody().mergeFrom((byte[]) obj);
                        if (mergeFrom == null) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("TroopFileSearchEngine<QFile>", 4, "bigRsp is null !!!");
                            }
                        } else {
                            int i3 = mergeFrom.int32_ret_code.get();
                            if (i3 < 0) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("TroopFileSearchEngine<QFile>", 4, String.format("onRspTroopFileSearch - retCode: %d", Integer.valueOf(i3)));
                                }
                            } else {
                                cmd0x383$ApplyFileSearchRspBody cmd0x383_applyfilesearchrspbody = mergeFrom.msg_file_search_rsp_body.get();
                                if (cmd0x383_applyfilesearchrspbody == null) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("TroopFileSearchEngine<QFile>", 4, "rsp = " + cmd0x383_applyfilesearchrspbody);
                                    }
                                } else {
                                    String stringUtf8 = cmd0x383_applyfilesearchrspbody.bytes_key_word.get().toStringUtf8();
                                    if (TextUtils.isEmpty(stringUtf8) || stringUtf8.equals(TroopFileSearchEngine.this.J)) {
                                        TroopFileSearchEngine.this.I = cmd0x383_applyfilesearchrspbody.bytes_sync_cookie.get().toStringUtf8();
                                        TroopFileSearchEngine troopFileSearchEngine = TroopFileSearchEngine.this;
                                        if (cmd0x383_applyfilesearchrspbody.uint32_is_end.get() == 1) {
                                            z17 = true;
                                        } else {
                                            z17 = false;
                                        }
                                        troopFileSearchEngine.G = z17;
                                        if (QLog.isDevelopLevel()) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("onRspTroopFileSearch cookie = " + TroopFileSearchEngine.this.I);
                                            sb5.append(", isEnd = " + TroopFileSearchEngine.this.G);
                                            sb5.append(", keyWord = " + cmd0x383_applyfilesearchrspbody.bytes_key_word.get().toStringUtf8());
                                            sb5.append(", totalCount = " + cmd0x383_applyfilesearchrspbody.uint32_total_match_count.get());
                                            QLog.d("TroopFileSearchEngine<QFile>", 4, sb5.toString());
                                        }
                                        List<cmd0x383$ApplyFileSearchRspBody.Item> list = cmd0x383_applyfilesearchrspbody.item_list.get();
                                        if (list != null && list.size() != 0) {
                                            for (int i16 = 0; i16 < list.size(); i16++) {
                                                d dVar = new d(TroopFileSearchEngine.this.f207943e, list.get(i16));
                                                if (dVar.f295828i != null) {
                                                    TroopFileManager F = TroopFileManager.F(TroopFileSearchEngine.this.f207943e, dVar.f295820a);
                                                    n A = F.A(dVar.f295828i.f294916b);
                                                    if (A != null) {
                                                        dVar.f295828i.f294915a = A.f294915a;
                                                    } else {
                                                        dVar.f295828i.f294915a = UUID.randomUUID();
                                                    }
                                                    n nVar = dVar.f295828i;
                                                    F.R(nVar.f294916b, nVar);
                                                }
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("TroopFileSearchEngine<QFile>", 4, "fileList[" + i16 + "]: " + dVar.toString());
                                                }
                                                arrayList.add(dVar);
                                            }
                                            TroopFileSearchEngine.this.F(true, arrayList);
                                            return;
                                        }
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("TroopFileSearchEngine<QFile>", 4, "filelist is empty--------");
                                        }
                                    } else {
                                        QLog.i("TroopFileSearchEngine<QFile>", 1, "keyword is update, current result is old");
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("TroopFileSearchEngine<QFile>", 4, QLog.getStackTraceString(e16));
                        }
                    }
                } else if (QLog.isDevelopLevel()) {
                    QLog.d("TroopFileSearchEngine<QFile>", 4, "data = " + obj + ", isSuccess = " + z16);
                }
            } catch (Exception e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TroopFileSearchEngine<QFile>", 4, QLog.getStackTraceString(e17));
                }
            }
            QLog.i("TroopFileSearchEngine<QFile>", 1, "error, can not handle search response, return a empty list.");
            TroopFileSearchEngine.this.F(false, arrayList);
        }
    }

    public TroopFileSearchEngine(QQAppInterface qQAppInterface, Context context, long j3, int i3, e eVar) {
        this.f207942d = 0;
        this.f207943e = qQAppInterface;
        this.f207944f = context;
        this.f207942d = i3;
        this.f207945h = j3;
        this.M = eVar;
    }

    private void A() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine$2$a */
            /* loaded from: classes12.dex */
            class a implements TroopFileSearchManager.a {
                a() {
                }

                @Override // com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager.a
                public void a(List<j> list) {
                    TroopFileSearchEngine.this.f207946i = list;
                    if (TroopFileSearchEngine.this.E) {
                        QLog.i("TroopFileSearchEngine<QFile>", 4, "collectContactInfos. need do search. execSearch.");
                        TroopFileSearchEngine.this.D();
                        TroopFileSearchEngine troopFileSearchEngine = TroopFileSearchEngine.this;
                        troopFileSearchEngine.J = troopFileSearchEngine.M.getSearchKeyword();
                        TroopFileSearchEngine troopFileSearchEngine2 = TroopFileSearchEngine.this;
                        troopFileSearchEngine2.C(troopFileSearchEngine2.J);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                TroopFileSearchManager.e().g(TroopFileSearchEngine.this.f207944f, TroopFileSearchEngine.this.f207943e, 0, new a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void B(QQAppInterface qQAppInterface, long j3, List<Long> list, String str, String str2) {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch.");
        if (!this.L) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("TroopFileSearchEngine<QFile>", 1, "doReqTroopFileSearch err marchWord is null--------------");
        } else {
            this.H = System.currentTimeMillis();
            this.L = false;
            cmd0x383$ApplyFileSearchReqBody cmd0x383_applyfilesearchreqbody = new cmd0x383$ApplyFileSearchReqBody();
            cmd0x383_applyfilesearchreqbody.bytes_key_word.set(ByteStringMicro.copyFromUtf8(str));
            if (list != null) {
                cmd0x383_applyfilesearchreqbody.uint64_uin_list.set(list);
            }
            if (!TextUtils.isEmpty(str2)) {
                cmd0x383_applyfilesearchreqbody.bytes_sync_cookie.set(ByteStringMicro.copyFromUtf8(str2));
            }
            cmd0x383_applyfilesearchreqbody.uint32_count.set(20);
            cmd0x383$ReqBody cmd0x383_reqbody = new cmd0x383$ReqBody();
            cmd0x383_reqbody.uint64_groupcode.set(j3);
            cmd0x383_reqbody.uint32_app_id.set(3);
            cmd0x383_reqbody.msg_file_search_req_body.set(cmd0x383_applyfilesearchreqbody);
            cmd0x383_reqbody.setHasFlag(true);
            Bundle bundle = new Bundle();
            bundle.putLong("troopUin", j3);
            bundle.putString("reqKeyword", str);
            ((TroopFileHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).J2("GroupFileAppSvr.GetFileSearch", cmd0x383_reqbody.toByteArray(), bundle);
            if (QLog.isColorLevel()) {
                QLog.d("TroopFileSearchEngine<QFile>", 4, "doReqTroopFileSearch troopUin = " + j3 + ", marchWord = " + str + ", cookie = " + str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void C(String str) {
        QLog.d("TroopFileSearchEngine<QFile>", 1, "execSearch. keyWord[" + str + "]");
        if (this.F) {
            return;
        }
        if (this.f207946i == null) {
            this.E = true;
            QLog.d("TroopFileSearchEngine<QFile>", 1, "execSearch. friend set is null. wait");
            return;
        }
        QLog.d("TroopFileSearchEngine<QFile>", 1, "mContactSearchTask = " + this.C);
        ae aeVar = this.C;
        if (aeVar != null) {
            aeVar.cancel(true);
            this.C = null;
        }
        QLog.i("TroopFileSearchEngine<QFile>", 4, "execSearch. success.");
        ae aeVar2 = new ae(str, str, this.f207946i, this);
        this.C = aeVar2;
        aeVar2.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = "";
        this.J = "";
        this.L = true;
        List<d> list = this.K;
        if (list != null) {
            list.clear();
            this.K = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(final boolean z16, final List<d> list) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.3
            @Override // java.lang.Runnable
            public void run() {
                if (TroopFileSearchEngine.this.N == null) {
                    QLog.i("TroopFileSearchEngine<QFile>", 4, "notifyFileSearchFinish. listener is null");
                }
                if (z16) {
                    ArrayList arrayList = new ArrayList();
                    List list2 = list;
                    if (list2 != null && !list2.isEmpty()) {
                        if (TroopFileSearchEngine.this.K == null) {
                            TroopFileSearchEngine.this.K = new ArrayList();
                        }
                        TroopFileSearchEngine.this.K.addAll(list);
                        Iterator it = TroopFileSearchEngine.this.K.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new com.tencent.mobileqq.filemanager.data.search.troop.a(TroopFileSearchEngine.this.f207943e, TroopFileSearchEngine.this.f207944f, TroopFileSearchEngine.this.J, (d) it.next()));
                        }
                    }
                    if (TroopFileSearchEngine.this.N != null) {
                        TroopFileSearchEngine.this.N.onFinish(arrayList, 1);
                    }
                } else if (TroopFileSearchEngine.this.N != null) {
                    TroopFileSearchEngine.this.N.onFinish(new ArrayList(), 6);
                }
                long currentTimeMillis = System.currentTimeMillis() - TroopFileSearchEngine.this.H;
                String searchKeyword = TroopFileSearchEngine.this.M.getSearchKeyword();
                if (!searchKeyword.equals(TroopFileSearchEngine.this.J) && currentTimeMillis >= 800) {
                    QLog.e("TroopFileSearchEngine<QFile>", 2, "notifyFileSearchFinish currentKeyword[" + searchKeyword + "] mLastKeyWord[" + TroopFileSearchEngine.this.J + "] timeInterval[" + currentTimeMillis + "]");
                    TroopFileSearchEngine.this.D();
                    TroopFileSearchEngine.this.J = searchKeyword;
                    TroopFileSearchEngine troopFileSearchEngine = TroopFileSearchEngine.this;
                    troopFileSearchEngine.C(troopFileSearchEngine.J);
                }
            }
        });
    }

    public void E(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(this.J)) {
            if (!this.L) {
                QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish.");
                return;
            }
            QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. but last search is not finish. keyWord[" + str + "] lastKeyWord[" + this.J + "]");
            B(this.f207943e, this.f207945h, this.f207947m, this.J, this.I);
            return;
        }
        QLog.i("TroopFileSearchEngine<QFile>", 1, "loadMoreSearchData. keyword is not match keyWord[" + str + "] lastKeyWord[" + this.J + "]");
    }

    public void G(int i3) {
        this.P = i3;
    }

    @Override // on2.b
    public List<com.tencent.mobileqq.filemanager.data.search.troop.a> a(pn2.a aVar) {
        return null;
    }

    @Override // com.tencent.mobileqq.search.ae.e
    public void b(final int i3, final List<? extends l> list) {
        QLog.i("TroopFileSearchEngine<QFile>", 4, "onSearchFinish. search contact with keyWord finish.");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5
            @Override // java.lang.Runnable
            public void run() {
                if (i3 != 1) {
                    TroopFileSearchEngine.this.F(false, null);
                    return;
                }
                TroopFileSearchEngine.this.f207947m = TroopFileSearchManager.a(list);
                TroopFileSearchEngine troopFileSearchEngine = TroopFileSearchEngine.this;
                QQAppInterface qQAppInterface = troopFileSearchEngine.f207943e;
                long j3 = TroopFileSearchEngine.this.f207945h;
                TroopFileSearchEngine troopFileSearchEngine2 = TroopFileSearchEngine.this;
                troopFileSearchEngine.B(qQAppInterface, j3, troopFileSearchEngine2.f207947m, troopFileSearchEngine2.J, TroopFileSearchEngine.this.I);
                list.clear();
            }
        });
    }

    @Override // on2.b
    public void c(pn2.a aVar, on2.d<com.tencent.mobileqq.filemanager.data.search.troop.a> dVar) {
        String str;
        if (aVar != null && (str = aVar.f426495a) != null && !TextUtils.isEmpty(str.trim())) {
            if (this.N == null) {
                this.N = dVar;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TroopFileSearchEngine.this.L) {
                        TroopFileSearchEngine.this.D();
                        TroopFileSearchEngine troopFileSearchEngine = TroopFileSearchEngine.this;
                        troopFileSearchEngine.J = troopFileSearchEngine.M.getSearchKeyword();
                        TroopFileSearchEngine troopFileSearchEngine2 = TroopFileSearchEngine.this;
                        troopFileSearchEngine2.C(troopFileSearchEngine2.J);
                    }
                }
            }, 800L);
        }
    }

    @Override // on2.b
    public void cancel() {
        if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileSearchEngine<QFile>", 4, "cancel.");
        }
        D();
    }

    @Override // on2.b
    public void destroy() {
        com.tencent.mobileqq.app.c cVar = this.Q;
        if (cVar != null) {
            this.f207943e.removeObserver(cVar);
        }
        List<j> list = this.f207946i;
        if (list != null) {
            list.clear();
        }
        ae aeVar = this.C;
        if (aeVar != null) {
            aeVar.cancel(true);
        }
    }

    @Override // on2.b
    public void init() {
        if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileSearchEngine<QFile>", 4, "init. get contact info.");
        }
        A();
    }

    @Override // on2.b
    public void pause() {
        com.tencent.mobileqq.app.c cVar = this.Q;
        if (cVar != null) {
            this.f207943e.removeObserver(cVar);
        }
    }

    @Override // on2.b
    public void resume() {
        com.tencent.mobileqq.app.c cVar = this.Q;
        if (cVar != null) {
            this.f207943e.addObserver(cVar);
        }
    }

    public boolean z(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(this.J)) {
            return this.G;
        }
        return true;
    }
}
