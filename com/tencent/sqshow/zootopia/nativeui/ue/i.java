package com.tencent.sqshow.zootopia.nativeui.ue;

import android.os.Handler;
import b94.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.ue.i;
import com.tencent.zplan.luabridge.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m94.DressErrorMsg;
import s94.FaceControlPointData;
import s94.FaceInfoSyncData;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010-\u001a\u00020)\u00a2\u0006\u0004\b7\u00108J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u001a\u0010\"\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010%\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020#H\u0016R\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010,R0\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040.j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/i;", "Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", "", "slotId", "Ls94/c;", "data", "targetIndex", "Lm94/h;", "cb", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ls94/b;", IZplanHandleApi.BUSINESS_DRESS_INFO, "r", DomainData.DOMAIN_NAME, "id", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqu4/j;", "g", "e", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/ue/r;", "listener", "a", "Ls94/a;", "controlData", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "j", "b", "i", "targetHistoryIndex", "p", "faceInfoData", "k", "", "addToHistory", "c", "j1", "d", "f", "Lb94/a;", "Lb94/a;", "getEngineApi", "()Lb94/a;", "engineApi", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "historyMap", "Lcom/tencent/sqshow/zootopia/nativeui/ue/r;", "faceChangeListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mDressingLock", "<init>", "(Lb94/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i implements t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b94.a engineApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, s94.c> historyMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private r faceChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mDressingLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/i$b", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FaceControlPointData f371367d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371368e;

        b(FaceControlPointData faceControlPointData, com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
            this.f371367d = faceControlPointData;
            this.f371368e = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(com.tencent.sqshow.zootopia.nativeui.data.j channel, FaceControlPointData controlData) {
            Intrinsics.checkNotNullParameter(channel, "$channel");
            Intrinsics.checkNotNullParameter(controlData, "$controlData");
            channel.getCameraController().w(new CameraKey(controlData.getCameraCfg().f440157a, 0, 2, null), "changeUEFaceCfg");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            if (success && this.f371367d.getCameraCfg().f440157a != 0) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.f371368e;
                final FaceControlPointData faceControlPointData = this.f371367d;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.b(com.tencent.sqshow.zootopia.nativeui.data.j.this, faceControlPointData);
                    }
                });
            }
            QLog.i("AvatarFaceController", 1, "changeUEFaceCfg onLuaResult, success: " + success + ", result:" + result);
        }
    }

    public i(b94.a engineApi) {
        Intrinsics.checkNotNullParameter(engineApi, "engineApi");
        this.engineApi = engineApi;
        this.historyMap = new HashMap<>();
        this.mDressingLock = new AtomicBoolean(false);
    }

    private final s94.c m(int id5) {
        if (this.historyMap.get(Integer.valueOf(id5)) == null) {
            this.historyMap.put(Integer.valueOf(id5), new s94.c(id5, null, 0, 6, null));
        }
        s94.c cVar = this.historyMap.get(Integer.valueOf(id5));
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    private final void n(final int slotId, s94.c data, final int targetIndex) {
        final FaceInfoSyncData h16 = data.h(targetIndex, e());
        h16.e(slotId);
        a.C0113a.j(this.engineApi, h16, null, 2, null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.h
            @Override // java.lang.Runnable
            public final void run() {
                i.o(i.this, slotId, targetIndex, h16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(i this$0, int i3, int i16, FaceInfoSyncData pointHistoryData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pointHistoryData, "$pointHistoryData");
        this$0.p(i3, i16);
        this$0.c(pointHistoryData, false);
        QLog.i("AvatarFaceController", 1, "recordHistory newHistoryData:" + pointHistoryData);
    }

    private final void q(int slotId, s94.c data, int targetIndex, m94.h cb5) {
        QLog.i("AvatarFaceController", 1, "moveToHistory targetIndex:" + targetIndex + ", mHistoryCursor:" + data.getHistoryCursor() + ", historySize:" + data.i());
        if (data.i() == 0) {
            cb5.a(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.e(cb5), DressErrorMsg.INSTANCE.b());
            return;
        }
        if (targetIndex < -1) {
            cb5.a(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.e(cb5), DressErrorMsg.INSTANCE.c());
        } else if (targetIndex >= data.i()) {
            cb5.a(new com.tencent.sqshow.zootopia.nativeui.data.dress.task.e(cb5), DressErrorMsg.INSTANCE.d());
        } else {
            n(slotId, data, targetIndex);
        }
    }

    private final void r(int slotId, int targetIndex, FaceInfoSyncData dressInfo) {
        QLog.i("AvatarFaceController", 1, "recordHistory targetIndex:" + targetIndex + ", dressInfo:" + dressInfo);
        s94.c m3 = m(slotId);
        if (dressInfo != null) {
            m3.k(targetIndex, dressInfo);
        } else {
            m3.j(targetIndex);
        }
        r rVar = this.faceChangeListener;
        if (rVar != null) {
            rVar.b(m3);
        }
        QLog.i("AvatarFaceController", 1, "recordHistory newHistoryData:" + m3);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public void a(r listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.faceChangeListener = listener;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public void b(int slotId, m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        q(slotId, m(slotId), r0.getHistoryCursor() - 1, cb5);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public void c(FaceInfoSyncData faceInfoData, boolean addToHistory) {
        Intrinsics.checkNotNullParameter(faceInfoData, "faceInfoData");
        QLog.i("AvatarFaceController", 1, "updateDressInfo: " + faceInfoData);
        if (!addToHistory) {
            QLog.i("AvatarFaceController", 1, "do not add to history");
        } else {
            int slotId = faceInfoData.getSlotId();
            r(slotId, m(slotId).getHistoryCursor() + 1, faceInfoData);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public qu4.j d() {
        Object last;
        qu4.j h16 = h();
        if (this.historyMap.isEmpty()) {
            return h16;
        }
        int length = h16.f429607b.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = h16.f429607b[i3].f429609a;
            for (Map.Entry<Integer, s94.c> entry : this.historyMap.entrySet()) {
                int intValue = entry.getKey().intValue();
                s94.c value = entry.getValue();
                if (intValue == i16 && !value.f().isEmpty()) {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) value.f());
                    for (qu4.k kVar : ((FaceInfoSyncData) last).getFaceInfo().f429607b) {
                        if (intValue == kVar.f429609a) {
                            h16.f429607b[i3] = kVar;
                        }
                    }
                }
            }
        }
        return h16;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public qu4.j e() {
        qu4.j jVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.w().b().getAvatarCharacter().f429573b;
        if (jVar == null) {
            jVar = new qu4.j();
        }
        return bj3.a.j(jVar);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public boolean f() {
        return !this.historyMap.isEmpty();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public qu4.j g() {
        qu4.j jVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.p().b().getAvatarCharacter().f429573b;
        if (jVar == null) {
            jVar = new qu4.j();
        }
        return bj3.a.j(jVar);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public qu4.j h() {
        qu4.j jVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().getAvatarCharacter().f429573b;
        if (jVar == null) {
            jVar = new qu4.j();
        }
        return bj3.a.j(jVar);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public void i(int slotId, m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        s94.c m3 = m(slotId);
        q(slotId, m3, m3.getHistoryCursor() + 1, cb5);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public void j(FaceControlPointData controlData, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(controlData, "controlData");
        Intrinsics.checkNotNullParameter(channel, "channel");
        QLog.i("AvatarFaceController", 1, "changeUEFaceCfg controlData: " + controlData);
        this.engineApi.j(controlData, new b(controlData, channel));
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public void j1() {
        for (Map.Entry<Integer, s94.c> entry : this.historyMap.entrySet()) {
            entry.getKey().intValue();
            entry.getValue().d();
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.ue.t
    public void k(int slotId, qu4.j faceInfoData) {
        if (faceInfoData == null) {
            QLog.i("AvatarFaceController", 1, "updateFaceInfo faceInfoData is null, return");
            return;
        }
        if (slotId != -1) {
            r(slotId, m(slotId).getHistoryCursor() + 1, FaceInfoSyncData.INSTANCE.b(faceInfoData));
            return;
        }
        int length = faceInfoData.f429607b.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = faceInfoData.f429607b[i3].f429609a;
            r(i16, m(i16).getHistoryCursor() + 1, FaceInfoSyncData.INSTANCE.b(faceInfoData));
        }
    }

    static /* synthetic */ void s(i iVar, int i3, int i16, FaceInfoSyncData faceInfoSyncData, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            faceInfoSyncData = null;
        }
        iVar.r(i3, i16, faceInfoSyncData);
    }

    public void p(int slotId, int targetHistoryIndex) {
        s(this, slotId, targetHistoryIndex, null, 4, null);
    }
}
