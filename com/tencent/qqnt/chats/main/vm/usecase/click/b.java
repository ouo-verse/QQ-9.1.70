package com.tencent.qqnt.chats.main.vm.usecase.click;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "needUnifiedAnim", "invoke", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "a", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "b", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "Landroid/view/View;", "c", "()Landroid/view/View;", "view", "Lcom/tencent/qqnt/chats/core/a;", "Lcom/tencent/qqnt/chats/core/a;", "()Lcom/tencent/qqnt/chats/core/a;", "chatsContext", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;Landroid/view/View;Lcom/tencent/qqnt/chats/core/a;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.b item;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.a chatsContext;

        public a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, @NotNull View view, @NotNull com.tencent.qqnt.chats.core.a chatsContext) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(chatsContext, "chatsContext");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, item, view, chatsContext);
                return;
            }
            this.item = item;
            this.view = view;
            this.chatsContext = chatsContext;
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.chats.core.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.chatsContext;
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.item;
        }

        @NotNull
        public final View c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.view;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.item, aVar.item) && Intrinsics.areEqual(this.view, aVar.view) && Intrinsics.areEqual(this.chatsContext, aVar.chatsContext)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.item.hashCode() * 31) + this.view.hashCode()) * 31) + this.chatsContext.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "ClickParams(item=" + this.item + ", view=" + this.view + ", chatsContext=" + this.chatsContext + ")";
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.click.b$b, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9598b {
        public static boolean a(@NotNull b bVar, @NotNull a params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return true;
        }
    }

    boolean interestedIn(@NotNull a params);

    boolean invoke(@NotNull a params);

    boolean needUnifiedAnim(@NotNull a params);
}
