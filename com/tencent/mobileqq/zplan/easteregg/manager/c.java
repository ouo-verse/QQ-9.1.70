package com.tencent.mobileqq.zplan.easteregg.manager;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\u0016\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR>\u0010\u0014\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00060\u0010j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0006`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/manager/c;", "", "Lcom/tencent/mobileqq/zplan/easteregg/model/c;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "", "d", "Lcom/tencent/mobileqq/zplan/easteregg/manager/f;", "task", "", "c", "Lcom/tencent/mobileqq/zplan/easteregg/manager/g;", "listener", "e", "a", "Lcom/tencent/mobileqq/zplan/easteregg/model/c;", "param", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", Constants.Raft.TASKS, "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "taskFinished", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "f", "()Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "setResourceTaskResult", "(Lcom/tencent/mobileqq/zplan/easteregg/manager/h;)V", "resourceTaskResult", "<init>", "(Lcom/tencent/mobileqq/zplan/easteregg/model/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.easteregg.model.c param;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HashSet<f<com.tencent.mobileqq.zplan.easteregg.model.c, IEasterEggResourceTaskResult>> tasks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<Integer, Boolean> taskFinished;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile IEasterEggResourceTaskResult resourceTaskResult;

    public c(com.tencent.mobileqq.zplan.easteregg.model.c param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.tasks = new HashSet<>();
        this.taskFinished = new ConcurrentHashMap<>();
        this.resourceTaskResult = new IEasterEggResourceTaskResult(null, null, null, null, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d() {
        Collection<Boolean> values = this.taskFinished.values();
        Intrinsics.checkNotNullExpressionValue(values, "taskFinished.values");
        while (true) {
            boolean z16 = true;
            for (Boolean it : values) {
                if (z16) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        break;
                    }
                }
                z16 = false;
            }
            return z16;
        }
    }

    public void c(f<com.tencent.mobileqq.zplan.easteregg.model.c, IEasterEggResourceTaskResult> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.tasks.add(task);
        this.taskFinished.put(Integer.valueOf(task.getType()), Boolean.FALSE);
    }

    public void e(g<IEasterEggResourceTaskResult> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<T> it = this.tasks.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            fVar.a(this.param, new a(listener, fVar, this));
        }
    }

    /* renamed from: f, reason: from getter */
    public final IEasterEggResourceTaskResult getResourceTaskResult() {
        return this.resourceTaskResult;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/manager/c$a", "Lcom/tencent/mobileqq/zplan/easteregg/manager/g;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "", "code", "res", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements g<IEasterEggResourceTaskResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<IEasterEggResourceTaskResult> f332920a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f<com.tencent.mobileqq.zplan.easteregg.model.c, IEasterEggResourceTaskResult> f332921b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f332922c;

        a(g<IEasterEggResourceTaskResult> gVar, f<com.tencent.mobileqq.zplan.easteregg.model.c, IEasterEggResourceTaskResult> fVar, c cVar) {
            this.f332920a = gVar;
            this.f332921b = fVar;
            this.f332922c = cVar;
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.manager.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int code, IEasterEggResourceTaskResult res) {
            if (code != 0) {
                this.f332920a.a(code, null);
            }
            int type = this.f332921b.getType();
            if (type == 1) {
                this.f332922c.getResourceTaskResult().i(res != null ? res.getBackgroundResourcePath() : null);
            } else if (type == 2) {
                this.f332922c.getResourceTaskResult().g(res != null ? res.getAtmospherePagAnimationPath() : null);
                this.f332922c.getResourceTaskResult().h(res != null ? res.getAvatarPagAnimationPath() : null);
                this.f332922c.getResourceTaskResult().j(res != null ? res.getFullScreenPagAnimationPath() : null);
            } else if (type == 3) {
                this.f332922c.getResourceTaskResult().k(res != null ? res.getPortraitHeadPath() : null);
                this.f332922c.getResourceTaskResult().l(res != null ? res.getPortraitSource() : null);
            }
            this.f332922c.taskFinished.put(Integer.valueOf(this.f332921b.getType()), Boolean.TRUE);
            if (this.f332922c.d()) {
                this.f332920a.a(0, this.f332922c.getResourceTaskResult());
            }
        }
    }
}
