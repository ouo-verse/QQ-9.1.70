package com.tencent.qqnt.avatar.dynamic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.avatar.fetch.d;
import com.tencent.qqnt.avatar.meta.request.c;
import com.tencent.qqnt.avatar.meta.task.TaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/avatar/dynamic/DynamicResourceFetcher;", "Lcom/tencent/qqnt/avatar/core/a;", "Lkotlin/Function0;", "", "cancelBlock", "Lcom/tencent/qqnt/avatar/fetch/b;", "f", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/bean/a;", "bean", "Lcom/tencent/qqnt/avatar/core/a$a;", "callback", "", "forceRefresh", "a", "Lcom/tencent/qqnt/avatar/fetch/d;", "c", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "b", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "taskManager", "", "resourceType", "<init>", "(I)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DynamicResourceFetcher extends com.tencent.qqnt.avatar.core.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TaskManager taskManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/avatar/dynamic/DynamicResourceFetcher$a", "Lcom/tencent/qqnt/avatar/meta/request/a;", "Landroid/graphics/drawable/Drawable;", "result", "", "a", "", "errorMsg", "onFail", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.qqnt.avatar.meta.request.a<Drawable> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.bean.a f352779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC9507a f352780b;

        a(com.tencent.qqnt.avatar.bean.a aVar, a.InterfaceC9507a interfaceC9507a) {
            this.f352779a = aVar;
            this.f352780b = interfaceC9507a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) interfaceC9507a);
            }
        }

        @Override // com.tencent.qqnt.avatar.meta.request.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinish(@NotNull Drawable result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            com.tencent.qqnt.avatar.bean.a aVar = this.f352779a;
            this.f352780b.a(new d(aVar, true, new com.tencent.qqnt.avatar.layer.b(aVar, result, null, 4, null), null, 8, null));
        }

        @Override // com.tencent.qqnt.avatar.meta.request.a
        public void onFail(@Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorMsg);
            } else {
                this.f352780b.a(new d(this.f352779a, false, null, errorMsg));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/avatar/dynamic/DynamicResourceFetcher$b", "Lcom/tencent/qqnt/avatar/fetch/b;", "", "cancel", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.avatar.fetch.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f352781a;

        b(Function0<Unit> function0) {
            this.f352781a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.qqnt.avatar.fetch.b
        public void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Function0<Unit> function0 = this.f352781a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public DynamicResourceFetcher(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.taskManager = new TaskManager("DynamicResourceFetcher", null, 4, 0L, 0, 0, false, 122, null);
        }
    }

    private final com.tencent.qqnt.avatar.fetch.b f(Function0<Unit> cancelBlock) {
        return new b(cancelBlock);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ com.tencent.qqnt.avatar.fetch.b g(DynamicResourceFetcher dynamicResourceFetcher, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        return dynamicResourceFetcher.f(function0);
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @NotNull
    public com.tencent.qqnt.avatar.fetch.b a(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.bean.a bean, @NotNull a.InterfaceC9507a callback, boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.fetch.b) iPatchRedirector.redirect((short) 2, this, context, bean, callback, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(bean instanceof com.tencent.qqnt.avatar.dynamic.a)) {
            callback.a(new d(bean, false, null, "avatarBean is invalid"));
            return g(this, null, 1, null);
        }
        final DynamicAvatarLoadTask dynamicAvatarLoadTask = new DynamicAvatarLoadTask(new c(context, (com.tencent.qqnt.avatar.meta.a) bean, new a(bean, callback)));
        this.taskManager.o(dynamicAvatarLoadTask, forceRefresh);
        return f(new Function0<Unit>(dynamicAvatarLoadTask) { // from class: com.tencent.qqnt.avatar.dynamic.DynamicResourceFetcher$fetcherResource$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DynamicAvatarLoadTask $task;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$task = dynamicAvatarLoadTask;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicResourceFetcher.this, (Object) dynamicAvatarLoadTask);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TaskManager taskManager;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    taskManager = DynamicResourceFetcher.this.taskManager;
                    taskManager.s(this.$task);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @Nullable
    public d c(@NotNull com.tencent.qqnt.avatar.bean.a bean, boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, this, bean, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        return null;
    }
}
