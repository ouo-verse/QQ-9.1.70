package ph4;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\r\u00a8\u0006\u0011"}, d2 = {"Lph4/g;", "", "", "roomId", "", "familyNoUserTypeCheck", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "listener", "", "c", "", "micPos", "Lph4/h;", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f426260a = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ph4/g$a", "Lnl4/a;", "", "permissionEnable", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements nl4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f426261a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f426262b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f426263c;

        a(h hVar, long j3, boolean z16) {
            this.f426261a = hVar;
            this.f426262b = j3;
            this.f426263c = z16;
        }

        @Override // nl4.a
        public void a(boolean permissionEnable) {
            this.f426261a.a(permissionEnable);
            if (permissionEnable) {
                g.f426260a.c(this.f426262b, this.f426263c, this.f426261a);
            } else {
                l.h("MicOperationUtil_", 1, "doOnMic# permissionEnable false!");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ph4/g$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> f426264a;

        b(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
            this.f426264a = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            gh4.d dVar;
            this.f426264a.onSuccess(result);
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                dVar = I0.m0();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_mic_join_success", dVar.E());
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            gh4.d dVar;
            this.f426264a.onError(errorCode, errorMessage);
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                dVar = I0.m0();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                HashMap<String, String> E = dVar.E();
                if (errorMessage == null) {
                    errorMessage = "";
                }
                E.put("yes_fail_reason", errorMessage);
                ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_mic_join_fail", E);
            }
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(long roomId, boolean familyNoUserTypeCheck, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> listener) {
        ((fm4.g) mm4.b.b(fm4.g.class)).A(roomId).z(((fm4.g) mm4.b.b(fm4.g.class)).m0(roomId).b(), 0, familyNoUserTypeCheck, new b(listener));
    }

    public final void b(int micPos, long roomId, boolean familyNoUserTypeCheck, @NotNull h listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((nl4.c) mm4.b.b(nl4.c.class)).k2(new a(listener, roomId, familyNoUserTypeCheck));
    }
}
