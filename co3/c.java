package co3;

import com.tencent.now.pkgame.linkandpkobserver.repository.LinkScreenAndPkServiceImpl;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0005\fB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lco3/c;", "", "Lco3/c$b;", "callback", "", "a", "", "J", "getRoomId", "()J", "roomId", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/a;", "b", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/a;", "linkScreenAndPKServiceApi", "<init>", "(J)V", "c", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.pkgame.linkandpkobserver.repository.a linkScreenAndPKServiceApi = new LinkScreenAndPkServiceImpl();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lco3/c$b;", "", "", "pkType", "", "isInPK", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(int pkType, boolean isInPK);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"co3/c$c", "Lko3/c;", "Lg55/q;", "data", "", "a", "", "code", "", "msg", "fail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: co3.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C0210c implements ko3.c<q> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f31192a;

        C0210c(b bVar) {
            this.f31192a = bVar;
        }

        @Override // ko3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable q data) {
            b bVar;
            boolean z16;
            if (data != null && (bVar = this.f31192a) != null) {
                int i3 = data.f401383f;
                if (data.f401381d == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.a(i3, z16);
            }
        }

        @Override // ko3.c
        public void fail(int code, @Nullable String msg2) {
            AegisLogger.INSTANCE.e("PK_Biz|AnchorRankPKChecker", "checkIsInPK", "fail, code:" + code + ", msg:" + msg2);
        }
    }

    public c(long j3) {
        this.roomId = j3;
    }

    public final void a(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.linkScreenAndPKServiceApi.a(this.roomId, new C0210c(callback));
    }
}
