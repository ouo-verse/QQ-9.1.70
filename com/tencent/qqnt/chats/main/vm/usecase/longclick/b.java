package com.tencent.qqnt.chats.main.vm.usecase.longclick;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/b;", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/b$a;", "params", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "b", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/b$a;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "a", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "b", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;Landroid/view/View;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chats.core.adapter.itemdata.b item;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        public a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, @NotNull View view) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) item, (Object) view);
            } else {
                this.item = item;
                this.view = view;
            }
        }

        @NotNull
        public final com.tencent.qqnt.chats.core.adapter.itemdata.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.chats.core.adapter.itemdata.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.item;
        }
    }

    boolean a(@NotNull a params);

    @Nullable
    com.tencent.qqnt.chats.main.vm.usecase.result.a b(@NotNull a params);
}
