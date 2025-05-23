package com.tencent.tedger.sample;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedgecontext.b;
import com.tencent.tedgecontext.c;
import com.tencent.tedger.TEdgeBusinessCenter;
import com.tencent.tedger.event.EdgeTrainingEvent;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.SampleInfoDB;
import com.tencent.tedger.outapi.proto.TEdgeSample$PointWiseSample;
import com.tencent.tedger.routecenter.defaultimp.f;
import com.tencent.video.decode.AVDecodeError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import ve4.n;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeSampleCenter extends b implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final String f375325i;

    /* renamed from: j, reason: collision with root package name */
    private static long f375326j;

    /* renamed from: k, reason: collision with root package name */
    private static long f375327k;

    /* renamed from: l, reason: collision with root package name */
    private static long f375328l;

    /* renamed from: m, reason: collision with root package name */
    private static long f375329m;

    /* renamed from: n, reason: collision with root package name */
    private static long f375330n;

    /* renamed from: a, reason: collision with root package name */
    private String f375331a;

    /* renamed from: b, reason: collision with root package name */
    private long f375332b;

    /* renamed from: c, reason: collision with root package name */
    private long f375333c;

    /* renamed from: d, reason: collision with root package name */
    private long f375334d;

    /* renamed from: e, reason: collision with root package name */
    private long f375335e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f375336f;

    /* renamed from: g, reason: collision with root package name */
    CopyOnWriteArrayList<EdgePointWiseSample> f375337g;

    /* renamed from: h, reason: collision with root package name */
    CopyOnWriteArrayList<EdgePointWiseSample> f375338h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EdgeSampleCenter.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (EdgeSampleCenter.this.getRouter().a()) {
                EdgeSampleCenter.this.f375336f = false;
                return;
            }
            if (objArr != null && objArr[0] != null) {
                ((b) EdgeSampleCenter.this).mLog.d(EdgeSampleCenter.f375325i, "train success & markSamplesUsed reqId = " + str + " edgeStatus = " + edgeStatus.getCode());
                EdgeSampleCenter.this.T((List) objArr[0], new EdgeStatus());
            }
            EdgeSampleCenter.this.f375336f = false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f375325i = EdgeSampleCenter.class.getSimpleName();
        f375326j = JoinTimeType.SEVEN_DAY;
        f375327k = 500L;
        f375328l = 50L;
        f375329m = -1L;
        f375330n = 80L;
    }

    public EdgeSampleCenter(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375331a = "TEdge_tab_sample_";
        this.f375334d = 10000L;
        this.f375335e = 0L;
        this.f375336f = false;
        this.f375337g = new CopyOnWriteArrayList<>();
        this.f375338h = new CopyOnWriteArrayList<>();
        this.f375331a += getContext().p() + "_" + getContext().c();
        getContext().h().a(this.f375331a, TEdgeBusinessCenter.DB_VERSION);
        getRouter().f375305c.l(new Runnable() { // from class: com.tencent.tedger.sample.EdgeSampleCenter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EdgeSampleCenter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    EdgeSampleCenter.this.L();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        try {
            int d16 = getContext().h().d(this.f375331a, "insertTime<?", new String[]{(System.currentTimeMillis() - (f375326j * 1000)) + ""});
            this.mLog.d(f375325i, "deleteExpiredSamples delete count = " + d16);
            while (true) {
                List<com.tencent.tedger.outapi.beans.a> e16 = getContext().h().e(this.f375331a, f375327k + "," + f375328l, true);
                if (e16 != null && !e16.isEmpty()) {
                    for (int i3 = 0; i3 < e16.size(); i3++) {
                        getContext().h().d(this.f375331a, "dataId=?", new String[]{e16.get(i3).f375273a});
                    }
                    this.mLog.d(f375325i, "deleteExpiredSamples list size = " + e16.size());
                } else {
                    return;
                }
            }
        } catch (Exception e17) {
            this.mLog.h(f375325i, "deleteExpiredSamples " + e17);
        }
    }

    private EdgePointWiseSample M(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<EdgePointWiseSample> it = this.f375337g.iterator();
            while (it.hasNext()) {
                EdgePointWiseSample next = it.next();
                if (next.getData().item_id.get().equals(str) && next.getData().req_id.get().equals(str2)) {
                    return next;
                }
            }
            Iterator<EdgePointWiseSample> it5 = this.f375338h.iterator();
            while (it5.hasNext()) {
                EdgePointWiseSample next2 = it5.next();
                if (next2.getData().item_id.get().equals(str) && next2.getData().req_id.get().equals(str2)) {
                    this.f375337g.add(next2);
                    this.f375338h.remove(next2);
                    return next2;
                }
            }
            EdgePointWiseSample N = N(str, str2);
            if (N != null) {
                this.f375337g.add(N);
                return N;
            }
            this.mLog.c(f375325i, "no sample");
            return null;
        }
        this.mLog.c(f375325i, "no item_Id or reqId");
        return null;
    }

    private EdgePointWiseSample N(String str, String str2) {
        return Q(str + "_" + str2);
    }

    private long O(String str, long j3) {
        f fVar = getRouter().f375304b;
        String str2 = "sdk.sample_center." + str;
        return Integer.parseInt(fVar.getConfig(str2, j3 + ""));
    }

    private EdgePointWiseSample Q(String str) {
        byte[] bArr;
        this.mLog.d(f375325i, "getAllSamples");
        com.tencent.tedger.outapi.beans.a c16 = getContext().h().c(this.f375331a, str);
        if (c16 != null && (bArr = c16.f375274b) != null) {
            SampleInfoDB ByteToObject = SampleInfoDB.ByteToObject(bArr);
            try {
                TEdgeSample$PointWiseSample tEdgeSample$PointWiseSample = new TEdgeSample$PointWiseSample();
                tEdgeSample$PointWiseSample.mergeFrom(ByteToObject.sample);
                EdgePointWiseSample edgePointWiseSample = new EdgePointWiseSample(tEdgeSample$PointWiseSample);
                edgePointWiseSample.hasUsed = ByteToObject.hasUsed;
                return edgePointWiseSample;
            } catch (InvalidProtocolBufferMicroException e16) {
                this.mLog.h(f375325i, e16.toString());
                return null;
            }
        }
        return null;
    }

    private List<EdgePointWiseSample> R(int i3) {
        int size;
        byte[] bArr;
        this.mLog.d(f375325i, "getSamples " + i3);
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        int i17 = 0;
        while (arrayList.size() < i3 && i16 < f375327k) {
            List<com.tencent.tedger.outapi.beans.a> e16 = getContext().h().e(this.f375331a, i16 + "," + i3, true);
            c cVar = this.mLog;
            String str = f375325i;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getSamples list size = ");
            if (e16 == null) {
                size = 0;
            } else {
                size = e16.size();
            }
            sb5.append(size);
            sb5.append(" offset = ");
            sb5.append(i16);
            sb5.append(" limit = ");
            sb5.append(i3);
            sb5.append(" samples size = ");
            sb5.append(arrayList.size());
            cVar.d(str, sb5.toString());
            if (e16 == null || e16.isEmpty()) {
                break;
            }
            for (com.tencent.tedger.outapi.beans.a aVar : e16) {
                if (aVar != null && (bArr = aVar.f375274b) != null) {
                    SampleInfoDB ByteToObject = SampleInfoDB.ByteToObject(bArr);
                    if (!ByteToObject.hasUsed) {
                        try {
                            TEdgeSample$PointWiseSample tEdgeSample$PointWiseSample = new TEdgeSample$PointWiseSample();
                            tEdgeSample$PointWiseSample.mergeFrom(ByteToObject.sample);
                            EdgePointWiseSample edgePointWiseSample = new EdgePointWiseSample(tEdgeSample$PointWiseSample);
                            edgePointWiseSample.hasUsed = ByteToObject.hasUsed;
                            arrayList.add(edgePointWiseSample);
                        } catch (InvalidProtocolBufferMicroException e17) {
                            this.mLog.h(f375325i, e17.toString());
                            i17++;
                        }
                    }
                }
            }
            i16 += i3;
        }
        if (i17 > 10) {
            int d16 = getContext().h().d(this.f375331a, null, null);
            this.mLog.d(f375325i, "getSamples parseErrorTime > 10,delete DB count = " + d16);
        }
        if (arrayList.size() < i3) {
            this.mLog.d(f375325i, "getSamples samples.size() < maxCount " + arrayList.size() + " < " + i3);
            return arrayList;
        }
        return arrayList.subList(0, i3);
    }

    private void S() {
        byte[] bArr;
        SampleInfoDB ByteToObject;
        this.f375335e++;
        List<com.tencent.tedger.outapi.beans.a> e16 = getContext().h().e(this.f375331a, (this.f375335e * f375328l) + "," + ((int) f375328l), false);
        if (e16 != null && !e16.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.tencent.tedger.outapi.beans.a aVar : e16) {
                if (aVar != null && (bArr = aVar.f375274b) != null && (ByteToObject = SampleInfoDB.ByteToObject(bArr)) != null && ByteToObject.hasUsed) {
                    ByteToObject.hasUsed = false;
                    com.tencent.tedger.outapi.beans.a aVar2 = new com.tencent.tedger.outapi.beans.a();
                    aVar2.f375273a = ByteToObject.ID;
                    aVar2.f375274b = SampleInfoDB.toByteArray(ByteToObject);
                    aVar2.f375275c = System.currentTimeMillis();
                    arrayList.add(aVar2);
                }
            }
            if (!arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    int d16 = getContext().h().d(this.f375331a, "dataId=?", new String[]{arrayList.get(i3).f375273a});
                    this.mLog.d(f375325i, "markSamples delete count = " + d16);
                }
                getContext().h().b(this.f375331a, arrayList);
                this.mLog.d(f375325i, "markSamples " + arrayList.size());
            }
            if (this.f375335e < 10) {
                e16.clear();
                arrayList.clear();
                S();
            }
        }
    }

    private static void V(List<EdgePointWiseSample> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<EdgePointWiseSample> it = list.iterator();
            while (it.hasNext()) {
                it.next().releaseNativePoint();
            }
        }
    }

    private synchronized void W(boolean z16) {
        if (!z16) {
            if (System.currentTimeMillis() - this.f375332b < this.f375334d) {
                return;
            }
        }
        this.f375332b = System.currentTimeMillis();
        try {
            if (!this.f375337g.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<EdgePointWiseSample> it = this.f375337g.iterator();
                while (it.hasNext()) {
                    EdgePointWiseSample next = it.next();
                    SampleInfoDB sampleInfoDB = new SampleInfoDB();
                    sampleInfoDB.timeStamp = next.getData().timestamp.get();
                    sampleInfoDB.sample = next.readBussinessData();
                    sampleInfoDB.ID = next.getData().item_id.get() + "_" + next.getData().req_id.get();
                    sampleInfoDB.hasUsed = next.hasUsed;
                    com.tencent.tedger.outapi.beans.a aVar = new com.tencent.tedger.outapi.beans.a();
                    aVar.f375273a = sampleInfoDB.ID;
                    aVar.f375274b = SampleInfoDB.toByteArray(sampleInfoDB);
                    aVar.f375275c = System.currentTimeMillis();
                    arrayList.add(aVar);
                }
                int i3 = 0;
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    i3 += getContext().h().d(this.f375331a, "dataId=?", new String[]{arrayList.get(i16).f375273a});
                }
                this.mLog.d(f375325i, "saveData delete count = " + i3);
                getContext().h().b(this.f375331a, arrayList);
                V(this.f375337g);
                this.f375337g.clear();
            }
        } catch (Throwable th5) {
            this.mLog.e(f375325i, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, th5 + "");
        }
    }

    @Override // ve4.n
    public void A(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) edgeStatus);
            return;
        }
        S();
        this.mLog.d(f375325i, "markAllSamplesUnUsed");
        edgeStatus.setCode(0L);
    }

    @Override // com.tencent.tedger.outapi.api.n
    public void G(List<EdgePointWiseSample> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (list.size() + this.f375338h.size() > f375328l) {
                int min = Math.min((list.size() + this.f375338h.size()) - ((int) f375328l), this.f375338h.size());
                ArrayList arrayList = new ArrayList(this.f375338h.subList(0, min));
                this.mLog.h(f375325i, "remove sampleItems size = " + min);
                this.f375338h.removeAll(arrayList);
                V(arrayList);
            }
            if (!list.isEmpty()) {
                for (EdgePointWiseSample edgePointWiseSample : list) {
                    if (edgePointWiseSample.getData() == null) {
                        try {
                            byte[] readNativeData = edgePointWiseSample.readNativeData();
                            if (readNativeData != null) {
                                TEdgeSample$PointWiseSample tEdgeSample$PointWiseSample = new TEdgeSample$PointWiseSample();
                                tEdgeSample$PointWiseSample.mergeFrom(readNativeData);
                                this.f375338h.add(new EdgePointWiseSample(tEdgeSample$PointWiseSample));
                            } else {
                                this.mLog.h(f375325i, "addSamples data is null");
                            }
                        } catch (Throwable th5) {
                            this.mLog.e(f375325i, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, th5 + "");
                        }
                    } else {
                        this.f375338h.add(new EdgePointWiseSample(edgePointWiseSample.getData()));
                        this.mLog.h(f375325i, "addSamples data is not null");
                    }
                }
                V(list);
                list.clear();
                return;
            }
            return;
        }
        this.mLog.h(f375325i, "addSamples sampleItems is null");
    }

    public List<EdgePointWiseSample> P(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16));
        }
        ArrayList arrayList = new ArrayList();
        List<EdgePointWiseSample> R = R((int) f375330n);
        if (R.isEmpty()) {
            this.mLog.h(f375325i, "getSample readySamples is null");
            return null;
        }
        if (R.size() < f375330n) {
            this.mLog.h(f375325i, "getSample readySamples size is " + R.size() + ",less than " + f375330n);
            V(R);
            return null;
        }
        for (EdgePointWiseSample edgePointWiseSample : R) {
            if (arrayList.size() < j16 && !edgePointWiseSample.hasUsed && (j3 == -1 || System.currentTimeMillis() - edgePointWiseSample.getData().timestamp.get() < j3)) {
                arrayList.add(edgePointWiseSample);
            } else {
                edgePointWiseSample.releaseNativePoint();
            }
        }
        this.mLog.d(f375325i, "getSample sampleArrayList size is " + arrayList.size() + " count =  " + j16);
        if (arrayList.size() >= j16) {
            return arrayList;
        }
        V(arrayList);
        return null;
    }

    public void T(List<EdgePointWiseSample> list, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, (Object) edgeStatus);
            return;
        }
        if (list != null && !list.isEmpty()) {
            try {
                ArrayList arrayList = new ArrayList(list);
                for (EdgePointWiseSample edgePointWiseSample : list) {
                    Iterator<EdgePointWiseSample> it = this.f375337g.iterator();
                    while (it.hasNext()) {
                        EdgePointWiseSample next = it.next();
                        if (Objects.equals(edgePointWiseSample.getData().item_id.get(), next.getData().item_id.get()) && Objects.equals(edgePointWiseSample.getData().req_id.get(), next.getData().req_id.get())) {
                            next.hasUsed = true;
                            edgeStatus.setCode(0L);
                            arrayList.remove(edgePointWiseSample);
                        }
                    }
                    edgePointWiseSample.hasUsed = true;
                }
                this.f375337g.addAll(arrayList);
                W(true);
                return;
            } catch (Throwable th5) {
                this.mLog.e(f375325i, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, th5 + "");
                return;
            }
        }
        this.mLog.h(f375325i, "markSamplesUsed sampleItems is null");
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (System.currentTimeMillis() - this.f375333c < 10000) {
            this.mLog.d(f375325i, "needTrain 10s limit");
            return;
        }
        this.f375333c = System.currentTimeMillis();
        if (getRouter().a()) {
            this.mLog.d(f375325i, "needTrain isDestroyed");
            return;
        }
        if (!getRouter().f375304b.j()) {
            this.mLog.d(f375325i, "needTrain not openTraining");
            return;
        }
        if (this.f375336f) {
            this.mLog.d(f375325i, "needTrain isTrain");
            return;
        }
        if (getRouter().f375304b.a()) {
            this.mLog.d(f375325i, "needTrain isInvalidDevice");
            return;
        }
        if (getContext().r()) {
            this.mLog.d(f375325i, "debug mode count limit = 21");
            f375330n = 21L;
        }
        this.f375336f = true;
        List<EdgePointWiseSample> P = P(f375329m, f375330n);
        if (P != null) {
            EdgeTrainingEvent edgeTrainingEvent = new EdgeTrainingEvent(new a());
            edgeTrainingEvent.samples = P;
            getRouter().f375309g.k(edgeTrainingEvent);
        } else {
            this.f375336f = false;
            this.mLog.d(f375325i, "no enough train sample");
        }
    }

    @Override // ve4.n
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        f375326j = O("sdk_sample_center_max_time_key", f375326j);
        f375327k = O("sdk_sample_center_max_item_count_key", f375327k);
        f375328l = O("sdk_sample_center_max_no_act_item_count_key", f375328l);
        f375330n = O("sdk_sample_center_need_train_count_limit_key", f375330n);
        f375329m = O("sdk_sample_center_need_train_time_range_limit_key", f375329m);
        this.f375334d = O("sdk_sample_center_db_save_time_interval", this.f375334d);
    }

    @Override // com.tencent.tedger.outapi.api.n
    public void d(EdgeAction edgeAction, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) edgeAction, (Object) edgeStatus);
            return;
        }
        String itemID = edgeAction.getItemID();
        String str = edgeAction.getEvents().get(0).req_id.get();
        if (TextUtils.isEmpty(itemID)) {
            this.mLog.c(f375325i, "no item_Id");
            return;
        }
        EdgePointWiseSample M = M(itemID, str);
        if (M != null) {
            M.getData().feedbacks.get().add(edgeAction.getEvents().get(0));
            M.getData().timestamp.set(edgeAction.getEvents().get(0).timestamp.get());
            W(false);
        }
        U();
    }

    @Override // com.tencent.tedger.outapi.api.n
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mLog.d(f375325i, "EdgeSampleCenter onDestroy = ");
        V(this.f375337g);
        V(this.f375338h);
        this.f375337g.clear();
        this.f375338h.clear();
    }

    @Override // com.tencent.tedger.outapi.api.n
    public void p(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) edgeStatus);
        } else {
            U();
        }
    }
}
