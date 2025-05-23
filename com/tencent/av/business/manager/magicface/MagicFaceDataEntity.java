package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.m;
import com.tencent.av.r;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MagicFaceDataEntity extends com.tencent.av.business.manager.magicface.c {

    /* renamed from: i, reason: collision with root package name */
    protected VideoAppInterface f73334i;

    /* renamed from: j, reason: collision with root package name */
    protected Handler f73335j;

    /* renamed from: k, reason: collision with root package name */
    protected a f73336k;

    /* renamed from: l, reason: collision with root package name */
    int[] f73337l;

    /* renamed from: m, reason: collision with root package name */
    int f73338m;

    /* renamed from: n, reason: collision with root package name */
    boolean f73339n;

    /* renamed from: o, reason: collision with root package name */
    boolean f73340o;

    /* renamed from: p, reason: collision with root package name */
    BitSet f73341p;

    /* renamed from: q, reason: collision with root package name */
    StopSelfDecorationRunnable f73342q;

    /* renamed from: r, reason: collision with root package name */
    EffectPendantTools f73343r;

    /* renamed from: s, reason: collision with root package name */
    b f73344s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class StopSelfDecorationRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final PendantItem f73347d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<MagicFaceDataEntity> f73348e;

        StopSelfDecorationRunnable(MagicFaceDataEntity magicFaceDataEntity, PendantItem pendantItem) {
            this.f73347d = pendantItem;
            this.f73348e = new WeakReference<>(magicFaceDataEntity);
        }

        @Override // java.lang.Runnable
        public void run() {
            PendantItem u16;
            MagicFaceDataEntity magicFaceDataEntity = this.f73348e.get();
            if (magicFaceDataEntity != null && (u16 = magicFaceDataEntity.f73343r.u()) != null && this.f73347d.getName().equals(u16.getName())) {
                magicFaceDataEntity.L(this.f73347d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements Observer {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<MagicFaceDataEntity> f73349d;

        a(MagicFaceDataEntity magicFaceDataEntity) {
            this.f73349d = new WeakReference<>(magicFaceDataEntity);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (this.f73349d.get() != null) {
                Handler handler = this.f73349d.get().f73335j;
                if (obj != null) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length > 0) {
                        int i3 = 0;
                        int intValue = ((Integer) objArr[0]).intValue();
                        if (intValue == 130 || intValue == 131 || intValue == 132) {
                            if (intValue == 131 || intValue == 132) {
                                i3 = 500;
                            }
                            AVCoreLog.printColorLog("MagicFaceDataEntity", "MagicFaceDataEntity update :" + intValue + "|" + i3);
                            handler.sendMessageDelayed(handler.obtainMessage(1, obj), (long) i3);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            MagicFaceDataEntity magicFaceDataEntity = MagicFaceDataEntity.this;
                            if (magicFaceDataEntity.f73338m == 1) {
                                magicFaceDataEntity.B(((Integer) message.obj).intValue());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    MagicFaceDataEntity magicFaceDataEntity2 = MagicFaceDataEntity.this;
                    if (magicFaceDataEntity2.f73338m == 1) {
                        magicFaceDataEntity2.f73338m = 0;
                        magicFaceDataEntity2.C();
                        return;
                    }
                    return;
                }
                MagicFaceDataEntity magicFaceDataEntity3 = MagicFaceDataEntity.this;
                if (magicFaceDataEntity3.f73338m == 0) {
                    magicFaceDataEntity3.f73338m = 1;
                    magicFaceDataEntity3.A();
                    return;
                }
                return;
            }
            MagicFaceDataEntity magicFaceDataEntity4 = MagicFaceDataEntity.this;
            if (magicFaceDataEntity4.f73338m == 1) {
                magicFaceDataEntity4.D((Object[]) message.obj);
            }
        }
    }

    public MagicFaceDataEntity(VideoAppInterface videoAppInterface, String str, String str2, String str3, boolean z16, int i3) {
        super(str3, str, str2);
        AVCoreLog.printColorLog("MagicFaceDataEntity", "MagicFaceDataEntity constructor:" + str + "|" + z16 + "|" + i3);
        this.f73334i = videoAppInterface;
        this.f73340o = z16;
        this.f73335j = new c(Looper.getMainLooper());
        this.f73337l = r();
        BitSet bitSet = new BitSet();
        this.f73341p = bitSet;
        if ((i3 & 1) != 0) {
            bitSet.set(0);
        }
        if ((i3 & 2) != 0) {
            this.f73341p.set(1);
        }
        this.f73343r = (EffectPendantTools) this.f73334i.B(2);
        this.f73344s = new b();
        a aVar = new a(this);
        this.f73336k = aVar;
        this.f73334i.addObserver(aVar);
        this.f73338m = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Object[] objArr) {
        switch (((Integer) objArr[0]).intValue()) {
            case 130:
                x((String) objArr[1], (byte[]) objArr[2]);
                return;
            case 131:
                w(1, (String) objArr[1]);
                return;
            case 132:
                w(3, (String) objArr[1]);
                return;
            default:
                return;
        }
    }

    private void E(final String str) {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "reloadDecrateList 1:" + str);
        PtvTemplateManager.h(this.f73334i).m(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicFaceDataEntity.1
            @Override // java.lang.Runnable
            public void run() {
                AVCoreLog.printColorLog("MagicFaceDataEntity", "reloadDecrateList 2:" + str);
                MagicFaceDataEntity.this.f73334i.M().post(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicFaceDataEntity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AVCoreLog.printColorLog("MagicFaceDataEntity", "reloadDecrateList 3:" + str);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        MagicFaceDataEntity.this.n(str);
                    }
                });
            }
        });
    }

    private void I(MagicfaceDataPendantJason magicfaceDataPendantJason) {
        String o16 = o(magicfaceDataPendantJason);
        if (o16 != null) {
            K(o16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(long j3, PendantItem pendantItem) {
        QLog.w("MagicFaceDataEntity", 1, "startSelfDecoration, info[" + pendantItem.getName() + "], seq[" + j3 + "]");
        this.f73343r.L(j3, pendantItem);
        if (!TextUtils.isEmpty(pendantItem.getName()) && this.f73371e != null) {
            String M = M(pendantItem.getName());
            MagicfaceDataPendantJason magicfaceDataPendantJason = this.f73371e.get(M);
            AVCoreLog.printColorLog("MagicFaceDataEntity", "startSelfDecoration 2:" + M + "|" + magicfaceDataPendantJason);
            if (magicfaceDataPendantJason != null && magicfaceDataPendantJason.duration > 0) {
                AVCoreLog.printColorLog("MagicFaceDataEntity", "startSelfDecoration 3:" + magicfaceDataPendantJason.duration);
                int i3 = magicfaceDataPendantJason.duration;
                StopSelfDecorationRunnable stopSelfDecorationRunnable = new StopSelfDecorationRunnable(this, pendantItem);
                this.f73342q = stopSelfDecorationRunnable;
                this.f73335j.postDelayed(stopSelfDecorationRunnable, i3);
            }
        }
    }

    private void K(String str) {
        boolean z16;
        AVCoreLog.printColorLog("MagicFaceDataEntity", "startSelfPendant 1:" + str);
        if (str != null) {
            ArrayList<PtvTemplateManager.PtvTemplateInfo> j3 = PtvTemplateManager.h(this.f73334i).j();
            if (j3 != null && j3.size() != 0) {
                n(str);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startSelfPendant, infos[");
            if (j3 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("]");
            QLog.w("MagicFaceDataEntity", 1, sb5.toString());
            E(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        PendantItem s16 = s(str);
        if (s16 != null) {
            long d16 = com.tencent.av.utils.e.d();
            if (com.tencent.av.utils.e.k()) {
                QLog.w("MagicFaceDataEntity", 1, "doStartSelfDecoration, seq[" + d16 + "], target[" + s16 + "]");
            }
            if (!s16.isUsable()) {
                this.f73343r.N(d16, s16);
            } else {
                J(d16, s16);
            }
        }
    }

    @Nullable
    private String p(String str) {
        Map<String, MagicfaceDataPendantJason> map = this.f73371e;
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, MagicfaceDataPendantJason>> it = map.entrySet().iterator();
        int i3 = 0;
        String str2 = null;
        if (it != null) {
            int i16 = 0;
            while (it.hasNext()) {
                MagicfaceDataPendantJason value = it.next().getValue();
                if (!TextUtils.isEmpty(value.belongto)) {
                    if (value.belongto.equals("sender") && this.f73341p.get(0)) {
                        str2 = value.name;
                    } else if (value.belongto.equals(MagicfaceDataPendantJason.BELONG_TO_RECEIVER) && this.f73341p.get(1)) {
                        str2 = value.name;
                    } else if (value.belongto.equals(MagicfaceDataPendantJason.BELONG_TO_BOTH)) {
                        str2 = value.name;
                    }
                    i16++;
                }
            }
            i3 = i16;
        }
        AVCoreLog.printColorLog("MagicFaceDataEntity", "getDecorateNameById: " + i3 + "|" + str + "|" + str2);
        if (i3 != 1) {
            return null;
        }
        return str2;
    }

    private int[] r() {
        int size;
        Map<String, MagicfaceDataPendantJason> map = this.f73371e;
        if (map != null && (size = map.size()) > 0) {
            int[] iArr = new int[size];
            int i3 = 0;
            for (Map.Entry<String, MagicfaceDataPendantJason> entry : this.f73371e.entrySet()) {
                entry.getKey();
                iArr[i3] = entry.getValue().startframe;
                i3++;
            }
            return iArr;
        }
        return null;
    }

    @Nullable
    private PendantItem s(String str) {
        PendantItem pendantItem = null;
        Iterator<PendantItem> it = this.f73343r.q(null).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PendantItem next = it.next();
            if (str.equals(next.getName())) {
                pendantItem = next;
                break;
            }
        }
        AVCoreLog.printColorLog("MagicFaceDataEntity", "getPtvTemplateInfo 1:" + str + "|" + pendantItem);
        return pendantItem;
    }

    private boolean t(int i3) {
        if (this.f73337l != null) {
            int i16 = 0;
            while (true) {
                int[] iArr = this.f73337l;
                if (i16 >= iArr.length) {
                    break;
                }
                if (iArr[i16] == i3) {
                    return true;
                }
                i16++;
            }
        }
        return false;
    }

    private void x(String str, byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3;
        boolean z16;
        short s16;
        short s17;
        short s18;
        short s19;
        AVCoreLog.printColorLog("MagicFaceDataEntity", "onReceiveFunChatExpData:" + str + "|" + bArr.length);
        SparseArray<lv.a> b16 = lv.b.b(bArr);
        lv.a aVar = b16.get(1);
        lv.a aVar2 = b16.get(4);
        if (aVar2 != null) {
            z16 = true;
            bArr3 = aVar2.d();
        } else {
            if (aVar != null) {
                bArr2 = aVar.d();
            } else {
                bArr2 = null;
            }
            bArr3 = bArr2;
            z16 = false;
        }
        if (bArr3 != null) {
            lv.a aVar3 = b16.get(3);
            if (aVar3 != null) {
                byte[] d16 = aVar3.d();
                short s26 = (short) ((d16[1] & 255) | (d16[0] << 8));
                short s27 = (short) ((d16[3] & 255) | (d16[2] << 8));
                short s28 = (short) ((d16[4] << 8) | (d16[5] & 255));
                s16 = s26;
                s19 = (short) ((d16[6] << 8) | (d16[7] & 255));
                s17 = s27;
                s18 = s28;
            } else {
                s16 = 320;
                s17 = 240;
                s18 = 0;
                s19 = 0;
            }
            y(str, bArr3, s17, s16, s18, s19, z16);
        }
        lv.a aVar4 = b16.get(2);
        if (aVar4 != null) {
            z(str, ByteBuffer.wrap(aVar4.d()).getShort());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "processStart:" + this.f73367a + "|" + this);
        this.f73343r.p(-1041L, this.f73344s);
    }

    protected void B(int i3) {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "processStartDecoration:" + this.f73367a + "|" + i3 + "|" + this.f73341p.get(0) + "|" + this.f73341p.get(1));
        for (Map.Entry<String, MagicfaceDataPendantJason> entry : this.f73371e.entrySet()) {
            entry.getKey();
            MagicfaceDataPendantJason value = entry.getValue();
            if (i3 == value.startframe && !TextUtils.isEmpty(value.belongto)) {
                if (value.belongto.equals("sender") && this.f73341p.get(0)) {
                    I(value);
                } else if (value.belongto.equals(MagicfaceDataPendantJason.BELONG_TO_RECEIVER) && this.f73341p.get(1)) {
                    I(value);
                } else if (value.belongto.equals(MagicfaceDataPendantJason.BELONG_TO_BOTH)) {
                    I(value);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "processStop:" + this.f73367a);
        if (q() != null) {
            L(null);
        }
        StopSelfDecorationRunnable stopSelfDecorationRunnable = this.f73342q;
        if (stopSelfDecorationRunnable != null) {
            this.f73335j.removeCallbacks(stopSelfDecorationRunnable);
            this.f73342q.run();
            this.f73342q = null;
        }
        this.f73343r.J(-1042L, this.f73344s);
        this.f73334i.deleteObserver(this.f73336k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(boolean z16) {
        String str;
        if (z16) {
            str = "START";
        } else {
            str = "STOP";
        }
        AVCoreLog.printColorLog("MagicFaceDataEntity", "requestFaceFeatureExp:" + z16 + "|" + str);
        r.h0().s2(6, str);
    }

    protected void G(int i3) {
        SessionInfo f16 = n.e().f();
        m R = r.h0().R(true);
        if (R != null) {
            R.N(i3);
        }
        f16.I1.set(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(String str) {
        if (TextUtils.isEmpty(str)) {
            cw.e.d(this.f73334i, 1016);
        } else {
            cw.e.p(this.f73334i, 1016, str);
        }
    }

    protected void L(PendantItem pendantItem) {
        this.f73343r.L(com.tencent.av.utils.e.d(), null);
    }

    String M(String str) {
        if (str != null && str.endsWith("_mirror")) {
            return str.substring(0, str.length() - 7);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.c
    public int a() {
        return this.f73369c.frame_count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.business.manager.magicface.c
    public String c(int i3) {
        return "video";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.c
    public void g(int i3, int i16) {
        this.f73374h = i3;
        if (t(i3)) {
            AVCoreLog.printColorLog("MagicFaceDataEntity", " inPendantStartFrames:" + i3);
            this.f73335j.obtainMessage(4, Integer.valueOf(i3)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.c
    public void h() {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "start:" + this.f73367a + "|" + this);
        this.f73335j.obtainMessage(2).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.magicface.c
    public void i() {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "stop:" + this.f73367a);
        this.f73335j.obtainMessage(3).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(int i3) {
        SessionInfo f16 = n.e().f();
        m R = r.h0().R(false);
        if (R != null) {
            R.J(i3);
        }
        f16.I1.clear(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o(MagicfaceDataPendantJason magicfaceDataPendantJason) {
        return magicfaceDataPendantJason.name;
    }

    public PendantItem q() {
        String p16 = p(this.f73367a);
        if (p16 != null) {
            return s(p16);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(String str) {
        return this.f73334i.getCurrentAccountUin().equals(str);
    }

    public boolean v() {
        return this.f73341p.get(0);
    }

    protected void w(int i3, String str) {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "onReceiveFunChatExpCMD:" + i3 + "|" + str);
        if (str != null) {
            AVCoreLog.printColorLog("MagicFaceDataEntity", "onReceiveFunChatExpCMD 22:" + i3 + "|" + str + "|START");
            if (str.equals("START")) {
                AVCoreLog.printColorLog("MagicFaceDataEntity", "onReceiveFunChatExpCMD 33:" + i3 + "|" + str);
                G(i3);
                return;
            }
            if (str.equals("STOP")) {
                m(i3);
            }
        }
    }

    public void y(String str, byte[] bArr, short s16, short s17, short s18, short s19, boolean z16) {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "onReceivePeerFaceFeature:" + str + "|" + bArr.length);
    }

    public void z(String str, int i3) {
        AVCoreLog.printColorLog("MagicFaceDataEntity", "onReceiveVolume:" + str + "|" + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements EffectConfigBase.b<PendantItem> {
        b() {
        }

        @Override // com.tencent.av.business.manager.EffectConfigBase.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDownloadFinish(long j3, PendantItem pendantItem, boolean z16) {
            AVCoreLog.printColorLog("MagicFaceDataEntity", "onDownloadFinish: " + pendantItem.toString() + "|" + z16);
            if (z16) {
                MagicFaceDataEntity.this.J(j3, pendantItem);
            }
        }

        @Override // com.tencent.av.business.manager.EffectConfigBase.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onItemSelectedChanged(long j3, PendantItem pendantItem) {
        }

        @Override // com.tencent.av.business.manager.EffectConfigBase.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(PendantItem pendantItem, int i3) {
        }
    }
}
