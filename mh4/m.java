package mh4;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.team.impl.TeamActivity;
import fm4.s;
import fm4.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomForbiddenSpeechConf;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0002\u0012\u0015\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lmh4/m;", "", "", "f", "c", "e", "d", "Lgh4/e;", "a", "Lgh4/e;", "mHall", "Lcom/tencent/mobileqq/app/QBaseActivity;", "b", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mContext", "Lgm4/d;", "Lgm4/d;", "mRoomListenerService", "mh4/m$b", "Lmh4/m$b;", "mRoomLifecycleListener", "mh4/m$a", "Lmh4/m$a;", "mForbiddenSpeechListener", "<init>", "(Lgh4/e;Lcom/tencent/mobileqq/app/QBaseActivity;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.e mHall;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity mContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private gm4.d mRoomListenerService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mRoomLifecycleListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mForbiddenSpeechListener;

    public m(@NotNull gh4.e mHall, @NotNull QBaseActivity mContext) {
        Intrinsics.checkNotNullParameter(mHall, "mHall");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mHall = mHall;
        this.mContext = mContext;
        this.mRoomLifecycleListener = new b();
        this.mForbiddenSpeechListener = new a();
    }

    private final void f() {
        gm4.d dVar = this.mRoomListenerService;
        if (dVar != null) {
            dVar.t(this.mRoomLifecycleListener);
        }
        gm4.d dVar2 = this.mRoomListenerService;
        if (dVar2 != null) {
            dVar2.d(this.mForbiddenSpeechListener);
        }
    }

    public final void c() {
        this.mRoomListenerService = ((fm4.g) mm4.b.b(fm4.g.class)).k(this.mHall.ue());
    }

    public final void d() {
        f();
    }

    public final void e() {
        gm4.d dVar = this.mRoomListenerService;
        if (dVar != null) {
            dVar.j(this.mRoomLifecycleListener);
        }
        gm4.d dVar2 = this.mRoomListenerService;
        if (dVar2 != null) {
            dVar2.b(this.mForbiddenSpeechListener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"mh4/m$a", "Lfm4/s;", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "c", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomForbiddenSpeechConf;", "yoloRoomForbiddenSpeechConfList", "a", "", "roomId", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements s {
        a() {
        }

        @Override // fm4.s
        public void c(int second) {
            if (second != 0) {
                com.tencent.timi.game.ui.widget.f.c("\u4f60\u56e0\u8fdd\u53cd\u5927\u5385\u89c4\u8303\uff0c\u88ab\u4e3b\u6301\u4eba\u7981\u8a00" + yn4.d.e(second));
            }
        }

        @Override // fm4.s
        public void a(@Nullable List<YoloRoomOuterClass$YoloRoomForbiddenSpeechConf> yoloRoomForbiddenSpeechConfList) {
        }

        @Override // fm4.s
        public void b(long roomId) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"mh4/m$b", "Lfm4/t;", "", "roomId", "", "roomType", "", "f", "l", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements t {
        b() {
        }

        @Override // fm4.t
        public void l(long roomId, int roomType) {
            if (roomId == m.this.mHall.ue() && roomType == 5) {
                com.tencent.timi.game.utils.l.e("ExpandHallFragment_", "finish when exit!! " + roomId);
                QBaseActivity b16 = vf4.a.b();
                if (b16 == null || !(b16 instanceof TeamActivity) || !com.tencent.timi.game.utils.g.c(m.this.mContext)) {
                    Object obj = m.this.mHall;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
                    ((TimiGameBaseFragment) obj).qh(3);
                    com.tencent.timi.game.utils.l.e("ExpandHallFragment_", "just hall Activity exit");
                    return;
                }
                if (((fm4.g) mm4.b.b(fm4.g.class)).z1() != null) {
                    ((sm4.a) mm4.b.b(sm4.a.class)).u3(m.this.mContext);
                    Object obj2 = m.this.mHall;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.timi.game.base.TimiGameBaseFragment");
                    ((TimiGameBaseFragment) obj2).qh(3);
                }
                com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "finish with team Activity exit");
            }
        }

        @Override // fm4.t
        public void f(long roomId, int roomType) {
        }
    }
}
