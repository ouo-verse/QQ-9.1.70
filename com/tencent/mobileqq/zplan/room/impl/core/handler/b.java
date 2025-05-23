package com.tencent.mobileqq.zplan.room.impl.core.handler;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import gk3.b;
import iv4.i;
import iv4.k;
import iv4.m;
import jv4.g;
import jv4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lv4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J \u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/core/handler/b;", "Lhk3/b;", "", "roomCmdType", "Ljv4/g;", "roomCmd", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/f;", "callback", "", "i", "roleType", "", "c", "isEnable", "b", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "a", "d", "mute", "e", "Lhk3/a;", "Lhk3/a;", "getDataApi", "", "Ljava/lang/String;", "roomId", "Ljk3/c;", "Ljk3/c;", "roomManager", "Z", "selfMicSwitch", "<init>", "(Lhk3/a;Ljava/lang/String;Ljk3/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b implements hk3.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final hk3.a getDataApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final jk3.c roomManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean selfMicSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/core/handler/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.room.impl.core.handler.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9193b implements com.tencent.mobileqq.zootopia.api.e<f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f335179d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<f> f335180e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f335181f;

        C9193b(String str, com.tencent.mobileqq.zootopia.api.e<f> eVar, b bVar) {
            this.f335179d = str;
            this.f335180e = eVar;
            this.f335181f = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZPlanRoom_OperationHandler", 1, this.f335179d + " success");
            com.tencent.mobileqq.zootopia.api.e<f> eVar = this.f335180e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
            this.f335181f.roomManager.y();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanRoom_OperationHandler", 1, this.f335179d + " error, code= " + error + ", message= " + message);
            com.tencent.mobileqq.zootopia.api.e<f> eVar = this.f335180e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            this.f335181f.roomManager.j("doRoomCmd", error);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/core/handler/b$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Boolean> f335185d;

        d(com.tencent.mobileqq.zootopia.api.e<Boolean> eVar) {
            this.f335185d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).p(new a(this.f335185d));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            com.tencent.mobileqq.zootopia.api.e<Boolean> eVar = this.f335185d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/core/handler/b$d$a", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Boolean> f335186a;

            a(com.tencent.mobileqq.zootopia.api.e<Boolean> eVar) {
                this.f335186a = eVar;
            }

            @Override // gk3.b.a
            public void a(boolean isSuccess, ErrorMessage errorMessage) {
                if (isSuccess) {
                    com.tencent.mobileqq.zootopia.api.e<Boolean> eVar = this.f335186a;
                    if (eVar != null) {
                        eVar.onResultSuccess(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.zootopia.api.e<Boolean> eVar2 = this.f335186a;
                if (eVar2 != null) {
                    eVar2.onResultFailure(errorMessage != null ? errorMessage.getErrorCode() : 0, errorMessage != null ? errorMessage.getErrorMessage() : null);
                }
            }
        }
    }

    public b(hk3.a getDataApi, String roomId, jk3.c roomManager) {
        Intrinsics.checkNotNullParameter(getDataApi, "getDataApi");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(roomManager, "roomManager");
        this.getDataApi = getDataApi;
        this.roomId = roomId;
        this.roomManager = roomManager;
        QLog.i("ZPlanRoom_OperationHandler", 1, "initOperation - " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int roomCmdType, g roomCmd, com.tencent.mobileqq.zootopia.api.e<f> callback) {
        iv4.e eVar;
        lv4.e eVar2 = new lv4.e();
        roomCmd.f411029a = roomCmdType;
        eVar2.f415643c = roomCmd;
        iv4.f roomDetail = this.getDataApi.getRoomDetail();
        if (roomDetail == null || (eVar = roomDetail.f408821a) == null) {
            eVar = new iv4.e();
        }
        eVar2.f415641a = eVar;
        eVar2.f415642b = this.getDataApi.getSelfUserInfo();
        String str = this.roomId + " - doRoomCmd_" + roomCmdType;
        QLog.i("ZPlanRoom_OperationHandler", 1, str + ", roomCmd= " + roomCmd);
        lk3.a.f(lk3.a.f414963a, eVar2, new C9193b(str, callback, this), 0, 4, null);
    }

    @Override // hk3.b
    public void a(int volume) {
        QLog.i("ZPlanRoom_OperationHandler", 1, "setAudioCaptureMicVolume, volume= " + volume);
        b.C10383b.c((gk3.b) vb3.a.f441346a.a(gk3.b.class), volume, null, 2, null);
    }

    @Override // hk3.b
    public void b(boolean isEnable, com.tencent.mobileqq.zootopia.api.e<Boolean> callback) {
        QLog.i("ZPlanRoom_OperationHandler", 1, "setSelfMicEnable - " + isEnable);
        this.selfMicSwitch = isEnable;
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).v(isEnable, new c(callback, this, isEnable));
    }

    @Override // hk3.b
    public void d(int volume) {
        QLog.i("ZPlanRoom_OperationHandler", 1, "setAudioSpeakerVolume, volume= " + volume);
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).setAudioPlayoutVolume(volume);
    }

    @Override // hk3.b
    public void e(boolean mute) {
        QLog.i("ZPlanRoom_OperationHandler", 1, "setAllRemoteAudioStreamMuteStatus - " + mute);
        vb3.a aVar = vb3.a.f441346a;
        ((gk3.b) aVar.a(gk3.b.class)).muteAllRemoteAudio(mute);
        if (mute) {
            b.C10383b.b((gk3.b) aVar.a(gk3.b.class), true, null, 2, null);
        } else if (this.selfMicSwitch) {
            b.C10383b.b((gk3.b) aVar.a(gk3.b.class), false, null, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/core/handler/b$c", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Boolean> f335182a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f335183b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f335184c;

        c(com.tencent.mobileqq.zootopia.api.e<Boolean> eVar, b bVar, boolean z16) {
            this.f335182a = eVar;
            this.f335183b = bVar;
            this.f335184c = z16;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (!isSuccess) {
                com.tencent.mobileqq.zootopia.api.e<Boolean> eVar = this.f335182a;
                if (eVar != null) {
                    eVar.onResultFailure(errorMessage != null ? errorMessage.getErrorCode() : 0, errorMessage != null ? errorMessage.getErrorMessage() : null);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.zootopia.api.e<Boolean> eVar2 = this.f335182a;
            if (eVar2 != null) {
                eVar2.onResultSuccess(Boolean.TRUE);
            }
            g gVar = new g();
            b bVar = this.f335183b;
            boolean z16 = this.f335184c;
            n nVar = new n();
            k kVar = new k();
            kVar.f408831a = bVar.getDataApi.getSelfUserInfo();
            m mVar = new m();
            i iVar = new i();
            iVar.f408828b = !z16 ? 1 : 0;
            mVar.f408836a = iVar;
            kVar.f408833c = mVar;
            nVar.f411042a = kVar;
            gVar.f411032d = nVar;
            this.f335183b.i(105, gVar, new a());
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/core/handler/b$c$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements com.tencent.mobileqq.zootopia.api.e<f> {
            a() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(f result) {
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
            }
        }
    }

    @Override // hk3.b
    public void c(int roleType, com.tencent.mobileqq.zootopia.api.e<Boolean> callback) {
        boolean z16 = roleType == 1;
        QLog.i("ZPlanRoom_OperationHandler", 1, "inOutSpeaking switchRole - " + z16);
        k kVar = new k();
        kVar.f408831a = this.getDataApi.getSelfUserInfo();
        if (z16) {
            g gVar = new g();
            jv4.b bVar = new jv4.b();
            bVar.f411013a = kVar;
            gVar.f411030b = bVar;
            i(103, gVar, new d(callback));
            return;
        }
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).c0();
        if (callback != null) {
            callback.onResultSuccess(Boolean.TRUE);
        }
        g gVar2 = new g();
        jv4.d dVar = new jv4.d();
        dVar.f411016a = kVar;
        gVar2.f411031c = dVar;
        i(104, gVar2, new e());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/core/handler/b$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<f> {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(f result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }
}
