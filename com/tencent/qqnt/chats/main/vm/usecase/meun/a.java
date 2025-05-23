package com.tencent.qqnt.chats.main.vm.usecase.meun;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.adapter.itemdata.b;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6\u0002R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "getRecentContactRepo", "()Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "", "processType", "I", "getProcessType", "()I", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a {
    static IPatchRedirector $redirector_;
    private final int processType;

    @NotNull
    private final IRecentContactRepo recentContactRepo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "a", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "b", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;Landroid/content/Context;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.meun.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final /* data */ class C9600a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b item;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Context context;

        public C9600a(@NotNull b item, @Nullable Context context) {
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) item, (Object) context);
            } else {
                this.item = item;
                this.context = context;
            }
        }

        @Nullable
        public final Context a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.context;
        }

        @NotNull
        public final b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.item;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C9600a)) {
                return false;
            }
            C9600a c9600a = (C9600a) other;
            if (Intrinsics.areEqual(this.item, c9600a.item) && Intrinsics.areEqual(this.context, c9600a.context)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int hashCode2 = this.item.hashCode() * 31;
            Context context = this.context;
            if (context == null) {
                hashCode = 0;
            } else {
                hashCode = context.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "MenuClickParams(item=" + this.item + ", context=" + this.context + ")";
        }
    }

    public a(@NotNull IRecentContactRepo recentContactRepo) {
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentContactRepo);
        } else {
            this.recentContactRepo = recentContactRepo;
            this.processType = -1;
        }
    }

    public int getProcessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.processType;
    }

    @NotNull
    public final IRecentContactRepo getRecentContactRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IRecentContactRepo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.recentContactRepo;
    }

    public abstract boolean interestedIn(@NotNull C9600a params);

    @Nullable
    public abstract Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(@NotNull C9600a params);
}
