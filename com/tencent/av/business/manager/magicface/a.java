package com.tencent.av.business.manager.magicface;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.n;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends EffectConfigBase<FaceItem> implements MagicfaceBaseDecoder.a, EffectMutexManager.a {
    private ArrayList<String> F;
    private MagicFaceDataEntity G;
    private WeakReference<MagicfaceBaseDecoder.b> H;
    private String I;
    private e J;
    private Queue<MagicFaceDataEntity> K;

    public a(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.H = new WeakReference<>(null);
        this.K = new ArrayBlockingQueue(8);
        this.F = new ArrayList<>();
        this.J = new e();
    }

    private MagicFaceDataEntity S(FaceItem faceItem, String str, boolean z16, int i3) {
        MagicFaceDataEntity magicFaceDataEntity;
        if (faceItem != null) {
            AVCoreLog.printColorLog(this.f73315d, String.format("createMagicEntity: id=%s, senderType%s.", faceItem.getId(), Integer.valueOf(i3)));
            String id5 = faceItem.getId();
            String type = faceItem.getType();
            if ("multi_result".equalsIgnoreCase(faceItem.getAttr())) {
                magicFaceDataEntity = new b(this.f73316e, id5, type, str, z16, i3);
            } else {
                magicFaceDataEntity = new MagicFaceDataEntity(this.f73316e, id5, type, str, z16, i3);
            }
            faceItem.lastPositionIndex = magicFaceDataEntity.f(faceItem.lastPositionIndex);
            return magicFaceDataEntity;
        }
        return null;
    }

    private boolean W(long j3) {
        if (this.K.size() > 0) {
            MagicFaceDataEntity remove = this.K.remove();
            if (com.tencent.av.utils.e.k()) {
                QLog.w(this.f73315d, 1, "playItemFromQueueHead, id[" + remove + "], seq[" + j3 + "]");
            }
            Z(j3, remove, this.H.get());
            M(j3, remove.b());
            if (remove.d()) {
                U(j3, 6102, null, null);
                this.I = null;
            }
            return true;
        }
        return false;
    }

    private MagicFaceDataEntity X(String str, boolean z16) {
        FaceItem w3 = w(str);
        if (w3 != null) {
            File file = new File(y(w3) + "config.json");
            int i3 = 1;
            if (file.exists()) {
                String readFileContent = FileUtils.readFileContent(file);
                boolean z17 = !n.e().f().G;
                if (!z16) {
                    i3 = 2;
                }
                return S(w3, readFileContent, z17, i3);
            }
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add("config.json");
            this.D.b(w3, v(w3), y(w3), arrayList, false);
            AVCoreLog.printErrorLog(this.f73315d, "prepareEntity FILE not exist: " + file.getPath());
        }
        return null;
    }

    private void Z(long j3, MagicFaceDataEntity magicFaceDataEntity, MagicfaceBaseDecoder.b bVar) {
        FaceItem w3;
        this.G = magicFaceDataEntity;
        if (magicFaceDataEntity != null && (w3 = w(magicFaceDataEntity.b())) != null) {
            String y16 = y(w3);
            if (!TextUtils.isEmpty(y16)) {
                this.J.c(j3, y16, magicFaceDataEntity, bVar, this);
            }
        }
    }

    private void a0(String str) {
        String id5;
        int i3;
        FaceItem w3 = w(str);
        if (w3 != null) {
            if (w3.isInteract()) {
                id5 = "START_" + w3.getId();
                i3 = 3;
            } else {
                id5 = w3.getId();
                i3 = 1;
            }
            E(i3, id5);
        }
    }

    private void b0(String str) {
        String str2;
        int i3;
        int i16 = 3;
        if (TextUtils.isEmpty(str)) {
            str2 = "START_0";
            i3 = 3;
        } else {
            str2 = "0";
            i3 = 1;
        }
        FaceItem w3 = w(str);
        if (w3 != null) {
            if (w3.isInteract()) {
                str2 = "STOP" + w3.getId();
            } else {
                str2 = w3.getId();
                i16 = 1;
            }
        } else {
            i16 = i3;
        }
        E(i16, str2);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected boolean B() {
        return true;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected void H() {
        List<T> list = this.f73303i;
        if (list == 0 || list.size() == 0) {
            com.tencent.av.business.processor.a aVar = (com.tencent.av.business.processor.a) ((hu.a) this.f73316e.B(15)).n(2);
            List<FaceItem> i3 = aVar.i(com.tencent.av.b.g(), "face_update_template.json", "face_default_template.json");
            this.f73303i = i3;
            I(i3);
            String l3 = aVar.l();
            if (!TextUtils.isEmpty(l3)) {
                this.F = new ArrayList<>(Arrays.asList(l3.split(",")));
            }
        }
    }

    void R(MagicFaceDataEntity magicFaceDataEntity) {
        MagicFaceDataEntity magicFaceDataEntity2;
        if (magicFaceDataEntity == null) {
            return;
        }
        Iterator<MagicFaceDataEntity> it = this.K.iterator();
        while (true) {
            if (it.hasNext()) {
                magicFaceDataEntity2 = it.next();
                if (magicFaceDataEntity2.d()) {
                    break;
                }
            } else {
                magicFaceDataEntity2 = null;
                break;
            }
        }
        this.K.offer(magicFaceDataEntity);
        if (magicFaceDataEntity2 != null) {
            this.K.remove(magicFaceDataEntity2);
            if (!magicFaceDataEntity.d()) {
                this.K.offer(magicFaceDataEntity2);
            }
        }
        Y("addItemToQueue");
    }

    public boolean T() {
        MagicFaceDataEntity magicFaceDataEntity = this.G;
        if (magicFaceDataEntity != null && magicFaceDataEntity.v()) {
            return true;
        }
        return false;
    }

    protected void U(long j3, int i3, Object obj, Object obj2) {
        if (QLog.isColorLevel()) {
            QLog.w(this.f73315d, 1, "notifyEvent, event[" + i3 + "], value[" + obj + "], value2[" + obj2 + "], seq[" + j3 + "]");
        }
        this.f73316e.k0(new Object[]{Integer.valueOf(i3), obj, obj2});
    }

    public int V(int i3, String str) {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.f73315d, 1, "onReceivedMessageOfPeer, type[" + i3 + "], seq[" + d16 + "], info[" + str + "]");
        if (i3 == 3) {
            int indexOf = str.indexOf(95);
            if (indexOf == -1) {
                return -1;
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1, str.length());
            boolean equals = "START".equals(substring);
            boolean equals2 = "VSTART".equals(substring);
            if (!equals && !equals2) {
                "STOP".equals(substring);
            } else if (!"0".equalsIgnoreCase(substring2) && !"0_iOS".equalsIgnoreCase(substring2)) {
                if (equals) {
                    U(d16, 6104, str, null);
                }
                new ControlUIObserver.d(d16, substring2, false, 4).b(this.f73316e);
                U(d16, 164, 0, null);
            } else {
                U(d16, 6101, null, Boolean.FALSE);
            }
        } else if (i3 == 1) {
            new ControlUIObserver.d(d16, str, false, 4).b(this.f73316e);
        }
        return 0;
    }

    void Y(String str) {
        if (QLog.isDevelopLevel()) {
            String str2 = (str + "\n") + "size :" + this.K.size() + "\n";
            Iterator<MagicFaceDataEntity> it = this.K.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                str2 = str2 + i3 + ":" + it.next() + "\n";
                i3++;
            }
            String str3 = (str2 + "\ncur :" + this.G) + "\nmLastPendantId :" + this.I;
            QLog.w(this.f73315d, 1, "printQueue, " + str3);
        }
    }

    @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
    public void b(long j3, String str, int i3) {
        boolean z16;
        MagicFaceDataEntity peek = this.K.peek();
        MagicFaceDataEntity magicFaceDataEntity = this.G;
        if (magicFaceDataEntity != null && magicFaceDataEntity.b().equalsIgnoreCase(str) && peek != null) {
            z16 = this.G.e(peek);
            if (z16 && this.K.size() < 8) {
                R(this.G);
            }
        } else {
            z16 = false;
        }
        if (com.tencent.av.utils.e.k()) {
            QLog.w(this.f73315d, 1, "onEndMagicPlay, id[" + str + "], reason[" + i3 + "], cur[" + this.G + "], next[" + peek + "], size[" + this.K.size() + "], needBeRestore[" + z16 + "], mLastPendantId[" + this.I + "], seq[" + j3 + "]");
        }
        Y("onEndMagicPlay.1");
        this.G = null;
        boolean W = W(j3);
        Y("onEndMagicPlay.2_" + W);
        if (!W) {
            U(j3, 6101, str, Boolean.FALSE);
            if (!TextUtils.isEmpty(this.I)) {
                ((EffectPendantTools) this.f73316e.B(2)).M(j3, this.I);
                U(j3, 6102, null, null);
                this.I = null;
            }
        }
        U(j3, 165, 3, null);
    }

    @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
    public void c(long j3, String str) {
        U(j3, 165, 2, null);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public boolean L(long j3, FaceItem faceItem) {
        boolean L = super.L(j3, faceItem);
        if (L) {
            this.f73304m.obtainMessage(101, this.f73302h).sendToTarget();
            if (faceItem != null) {
                String type = faceItem.getType();
                EffectMutexManager effectMutexManager = (EffectMutexManager) this.f73316e.B(12);
                if (effectMutexManager != null) {
                    effectMutexManager.m(3003, type);
                }
            }
        }
        return L;
    }

    @Override // com.tencent.av.business.manager.EffectMutexManager.a
    public void d(int i3, String str) {
        boolean z16;
        long d16 = com.tencent.av.utils.e.d();
        if (i3 == 3003 || i3 == 3002 || (i3 != 3001 && i3 != 3004 && i3 != 3005)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f73315d, 2, "MuteByOthers, seq[" + d16 + "], fromMuteKey[" + i3 + "], data[" + str + "], mute[" + z16 + "]");
        }
        if (z16) {
            this.f73316e.k0(new Object[]{134});
            e0(0, null, true);
            Queue<MagicFaceDataEntity> queue = this.K;
            if (queue != null) {
                queue.clear();
            }
            this.G = null;
            M(d16, null);
            if (this.J.b()) {
                this.J.e();
            }
        }
    }

    public boolean d0(long j3, FaceItem faceItem, String str, boolean z16, MagicfaceBaseDecoder.b bVar) {
        MagicFaceDataEntity magicFaceDataEntity;
        MagicFaceDataEntity X;
        boolean z17;
        if (com.tencent.av.utils.e.k()) {
            String str2 = this.f73315d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("start, id[");
            sb5.append(str);
            sb5.append("], curData[");
            sb5.append(this.G);
            sb5.append("], isSender[");
            sb5.append(z16);
            sb5.append("], queue[");
            sb5.append(this.K.size());
            sb5.append("], isPlaying[");
            e eVar = this.J;
            if (eVar != null && eVar.b()) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append("], mLastPendantId[");
            sb5.append(this.I);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.w(str2, 1, sb5.toString());
        }
        if (TextUtils.isEmpty(str) || this.K.size() >= 8 || ((magicFaceDataEntity = this.G) != null && str.equalsIgnoreCase(magicFaceDataEntity.b()))) {
            return false;
        }
        this.H = new WeakReference<>(bVar);
        e eVar2 = this.J;
        if (eVar2 != null && eVar2.b()) {
            X = X(str, z16);
            R(X);
            this.J.e();
        } else {
            X = X(str, z16);
            if (X != null) {
                Z(j3, X, bVar);
            }
        }
        if (X != null) {
            String str3 = this.I;
            M(j3, str);
            this.I = null;
            QLog.w(this.f73315d, 1, "start, step[3], mLastPendantId[" + str3 + "->" + this.I + "]");
        }
        if (z16) {
            a0(str);
        }
        return true;
    }

    public boolean e0(int i3, String str, boolean z16) {
        long d16 = com.tencent.av.utils.e.d();
        if (com.tencent.av.utils.e.k()) {
            QLog.w(this.f73315d, 1, "stop, id[" + str + "], reason[" + i3 + "], isSender[" + z16 + "], seq[" + d16 + "]");
        }
        MagicFaceDataEntity magicFaceDataEntity = this.G;
        if (magicFaceDataEntity != null) {
            String b16 = magicFaceDataEntity.b();
            if (TextUtils.isEmpty(str) || b16.equalsIgnoreCase(str)) {
                this.K.clear();
                AVCoreLog.printErrorLog(this.f73315d, "stop dequeue" + str);
                this.G = null;
                if (z16) {
                    b0(str);
                }
                M(d16, null);
                if (this.J.b()) {
                    this.J.e();
                    AVCoreLog.printErrorLog(this.f73315d, "stop " + str + ", mStopType =" + i3);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase, com.tencent.av.business.manager.a
    public void g() {
        super.g();
        EffectMutexManager effectMutexManager = (EffectMutexManager) this.f73316e.B(12);
        if (effectMutexManager != null) {
            effectMutexManager.n(3003, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase, com.tencent.av.business.manager.a
    public void h(String str, boolean z16) {
        super.h(str, z16);
        if (z16 && str.equals(n.e().f().f73091w)) {
            this.I = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void j(long j3, int i3, String str, String str2) {
        if (i3 != 2) {
            if (i3 == 3) {
                U(j3, 6101, null, Boolean.FALSE);
            }
        } else {
            U(j3, 6101, null, Boolean.FALSE);
            MagicDataReport.i(this.f73316e, str);
            MagicDataReport.m(2, str);
            MagicDataReport.l(2);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public List<FaceItem> q(String str) {
        List q16 = super.q(str);
        ArrayList arrayList = new ArrayList();
        if (q16 != null) {
            if (!TextUtils.isEmpty(str)) {
                int size = q16.size();
                for (int i3 = 0; i3 < size; i3++) {
                    FaceItem faceItem = (FaceItem) q16.get(i3);
                    if (faceItem.isSameType(str)) {
                        arrayList.add(faceItem);
                    }
                }
            } else {
                arrayList.addAll(q16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public int r() {
        return 176;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected String t() {
        return DKConfiguration.Directory.RESOURCES;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected Class<?> x() {
        return FaceItem.class;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected void z(Message message) {
        if (message.what == 101) {
            this.f73316e.k0(new Object[]{168, message.obj});
        }
    }

    @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
    public void a(long j3, String str) {
    }

    @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
    public void e(long j3, String str, boolean z16) {
    }
}
