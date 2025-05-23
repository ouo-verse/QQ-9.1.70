package com.tencent.mobileqq.aio.input.at.common.list.data;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.aio.input.at.common.CancelSelectItemEvent;
import com.tencent.mobileqq.aio.input.at.common.SelectItemEvent;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.aio.input.at.common.j;
import com.tencent.mobileqq.aio.input.at.common.list.base.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u000e\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/list/data/a;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Lcom/tencent/mobileqq/aio/input/at/common/list/base/d;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "", "k0", "", VideoTemplateParser.ITEM_LIST, "submitList", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "G", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "com/tencent/mobileqq/aio/input/at/common/list/data/a$b", "H", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/a$b;", "mDelegateListener", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a<T extends c> extends d<com.tencent.mobileqq.aio.input.at.common.list.data.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final j<T> mDialogContext;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b mDelegateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/input/at/common/list/data/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "oldItem", "newItem", "", "b", "a", "", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.common.list.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7257a extends DiffUtil.ItemCallback<com.tencent.mobileqq.aio.input.at.common.list.data.b> {
        static IPatchRedirector $redirector_;

        C7257a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b oldItem, @NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.e(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b oldItem, @NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.f(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b oldItem, @NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) oldItem, (Object) newItem);
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.b(newItem);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/input/at/common/list/data/a$b", "Lcom/tencent/mobileqq/aio/input/at/common/b;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "itemData", "", "b", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.aio.input.at.common.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.b
        public void a(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) itemData);
            } else {
                Intrinsics.checkNotNullParameter(itemData, "itemData");
                SimpleEventBus.getInstance().dispatchEvent(new CancelSelectItemEvent(itemData));
            }
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.b
        public void b(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemData);
            } else {
                Intrinsics.checkNotNullParameter(itemData, "itemData");
                SimpleEventBus.getInstance().dispatchEvent(new SelectItemEvent(itemData));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull j<T> mDialogContext) {
        super(new C7257a());
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext);
            return;
        }
        this.mDialogContext = mDialogContext;
        this.mDelegateListener = new b();
        k0();
    }

    private final void k0() {
        Iterator<T> it = this.mDialogContext.b().h(this.mDialogContext, this.mDelegateListener).iterator();
        while (it.hasNext()) {
            this.f189310m.b((com.tencent.mobileqq.aio.input.at.common.list.base.b) it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void submitList(@NotNull List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemList);
        } else {
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            setItems(itemList);
        }
    }
}
