package li4;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.timi.game.live.impl.danmuku.ktv.KtvPlayView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lli4/a;", "", "", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "ktvPlayViewList", "", "b", "Ljava/util/Queue;", "", "a", "Ljava/util/Queue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "", "Ljava/util/List;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<String> queue = new LinkedList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<KtvPlayView> ktvPlayViewList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lli4/a$a;", "", "", HippyQQPagView.EventName.ON_PLAY_END, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: li4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC10727a {
        void onPlayEnd();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"li4/a$b", "Lli4/a$a;", "", HippyQQPagView.EventName.ON_PLAY_END, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements InterfaceC10727a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<KtvPlayView> f414840b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ KtvPlayView f414841c;

        b(List<KtvPlayView> list, KtvPlayView ktvPlayView) {
            this.f414840b = list;
            this.f414841c = ktvPlayView;
        }

        @Override // li4.a.InterfaceC10727a
        public void onPlayEnd() {
            String str = (String) a.this.queue.poll();
            if (str == null) {
                return;
            }
            int size = this.f414840b.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f414841c.f(str);
            }
        }
    }

    public final void b(@NotNull List<KtvPlayView> ktvPlayViewList) {
        Intrinsics.checkNotNullParameter(ktvPlayViewList, "ktvPlayViewList");
        this.ktvPlayViewList.clear();
        this.ktvPlayViewList.addAll(ktvPlayViewList);
        for (KtvPlayView ktvPlayView : ktvPlayViewList) {
            ktvPlayView.setKtvPlayController(new b(ktvPlayViewList, ktvPlayView));
        }
    }
}
