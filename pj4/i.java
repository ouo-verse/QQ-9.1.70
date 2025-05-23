package pj4;

import ag4.i;
import android.app.Activity;
import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J.\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lpj4/i;", "", "Landroid/content/Context;", "context", "", "roomId", "", VirtualAppProxy.KEY_GAME_ID, "Lpj4/a;", "presenter", "Lpj4/j;", "livingInscriptionSettingListener", "", "b", "", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "LivingInscriptionSettingHelper";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"pj4/i$a", "Lag4/i$d;", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "a", "", "errorCode", "", "errorMsg", "e", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements i.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f426378b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f426379c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f426380d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ pj4.a f426381e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f426382f;

        a(Context context, long j3, int i3, pj4.a aVar, j jVar) {
            this.f426378b = context;
            this.f426379c = j3;
            this.f426380d = i3;
            this.f426381e = aVar;
            this.f426382f = jVar;
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
            Intrinsics.checkNotNullParameter(selectedDefaultAccount, "selectedDefaultAccount");
            l.i(i.this.TAG, "sendProfileMessage bindSucceed ");
            h hVar = new h(this.f426378b, this.f426379c, this.f426380d);
            hVar.H0(this.f426381e);
            hVar.I0(this.f426382f);
            hVar.show();
        }

        @Override // ag4.i.d
        public void b() {
            l.i(i.this.TAG, "sendProfileMessage bindCancel ");
        }

        @Override // ag4.i.c
        public void c() {
            l.i(i.this.TAG, "sendProfileMessage onDialogShow ");
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
            l.i(i.this.TAG, "sendProfileMessage bindFailed ");
        }
    }

    public final void b(@NotNull Context context, long roomId, int gameId, @NotNull pj4.a presenter, @NotNull j livingInscriptionSettingListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(livingInscriptionSettingListener, "livingInscriptionSettingListener");
        if (context instanceof Activity) {
            ((ag4.i) mm4.b.b(ag4.i.class)).F3(101, (Activity) context, Boolean.TRUE, null, new a(context, roomId, gameId, presenter, livingInscriptionSettingListener));
        } else {
            com.tencent.timi.game.ui.widget.f.c("\u9875\u9762\u5f02\u5e38\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5\u3002");
        }
    }
}
