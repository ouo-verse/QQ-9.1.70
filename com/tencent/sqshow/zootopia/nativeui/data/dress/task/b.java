package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.b;
import com.tencent.sqshow.zootopia.nativeui.ue.ChangeDressTask;
import com.tencent.sqshow.zootopia.nativeui.ue.n;
import com.tencent.zplan.luabridge.a;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0012B3\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010%\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J.\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0004J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0014R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "", "Lb94/d;", "dressController", "", "i", "Lm94/a;", "newDressInfo", "", "addToHistory", "Lorg/json/JSONObject;", "clickedItemParam", "c", "Lcom/tencent/zplan/luabridge/a$b;", "cb", "k", "j", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "g", "()Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "", "b", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lm94/i;", "Lm94/i;", "f", "()Lm94/i;", "callback", "d", "Z", "e", "waitingUeCallback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Ljava/lang/String;Lm94/i;ZZ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final DressTaskChannel dressTaskChannel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final m94.i callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean addToHistory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean waitingUeCallback;

    public b(DressTaskChannel dressTaskChannel, String taskId, m94.i callback, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.dressTaskChannel = dressTaskChannel;
        this.taskId = taskId;
        this.callback = callback;
        this.addToHistory = z16;
        this.waitingUeCallback = z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b this$0, b94.d dressController, m94.a newDressInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dressController, "$dressController");
        Intrinsics.checkNotNullParameter(newDressInfo, "$newDressInfo");
        this$0.j(dressController, newDressInfo, z16);
        this$0.callback.b(this$0);
    }

    protected final void c(final b94.d dressController, final m94.a newDressInfo, final boolean addToHistory, JSONObject clickedItemParam) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        Intrinsics.checkNotNullParameter(newDressInfo, "newDressInfo");
        Runnable runnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.dress.task.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(b.this, dressController, newDressInfo, addToHistory);
            }
        };
        k(newDressInfo, clickedItemParam, new C9814b(runnable));
        if (this.waitingUeCallback) {
            return;
        }
        runnable.run();
    }

    /* renamed from: f, reason: from getter */
    public final m94.i getCallback() {
        return this.callback;
    }

    /* renamed from: g, reason: from getter */
    public final DressTaskChannel getDressTaskChannel() {
        return this.dressTaskChannel;
    }

    /* renamed from: h, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public abstract void i(b94.d dressController);

    protected void j(b94.d dressController, m94.a newDressInfo, boolean addToHistory) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        Intrinsics.checkNotNullParameter(newDressInfo, "newDressInfo");
        dressController.Nc(newDressInfo, addToHistory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(m94.a newDressInfo, JSONObject clickedItemParam, a.b cb5) {
        Set set;
        List list;
        Intrinsics.checkNotNullParameter(newDressInfo, "newDressInfo");
        n nVar = n.f371383a;
        String valueOf = String.valueOf(this);
        set = CollectionsKt___CollectionsKt.toSet(newDressInfo.b().values());
        list = CollectionsKt___CollectionsKt.toList(r94.b.i(set));
        nVar.c(new ChangeDressTask(valueOf, list, newDressInfo.getAvatarCharacter(), this.dressTaskChannel.getEngineApi(), clickedItemParam, cb5, null, 64, null));
    }

    public /* synthetic */ b(DressTaskChannel dressTaskChannel, String str, m94.i iVar, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(dressTaskChannel, str, iVar, (i3 & 8) != 0 ? true : z16, (i3 & 16) != 0 ? false : z17);
    }

    public static /* synthetic */ void d(b bVar, b94.d dVar, m94.a aVar, boolean z16, JSONObject jSONObject, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = bVar.addToHistory;
            }
            if ((i3 & 8) != 0) {
                jSONObject = null;
            }
            bVar.c(dVar, aVar, z16, jSONObject);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finalChangeAvatarCharacter");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/dress/task/b$b", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.data.dress.task.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9814b implements a.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f370961e;

        C9814b(Runnable runnable) {
            this.f370961e = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Runnable succeedTask) {
            Intrinsics.checkNotNullParameter(succeedTask, "$succeedTask");
            succeedTask.run();
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            if (b.this.waitingUeCallback) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Runnable runnable = this.f370961e;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.dress.task.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.C9814b.b(runnable);
                    }
                });
            }
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
        }
    }
}
