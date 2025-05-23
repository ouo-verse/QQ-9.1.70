package com.tencent.mobileqq.troop.schooltoolbox.adapter;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.schooltoolbox.data.c;
import com.tencent.mobileqq.troop.schooltoolbox.delegate.d;
import com.tencent.mobileqq.troop.schooltoolbox.delegate.e;
import com.tencent.mobileqq.troop.schooltoolbox.delegate.f;
import com.tencent.mobileqq.troop.schooltoolbox.delegate.g;
import com.tencent.mobileqq.troop.schooltoolbox.delegate.h;
import com.tencent.mobileqq.troop.schooltoolbox.delegate.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/adapter/a;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/troop/schooltoolbox/data/c;", "", "newList", "", "submitList", "", "troopUin", "<init>", "(J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends AsyncListDifferDelegationAdapter<c> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/schooltoolbox/adapter/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/troop/schooltoolbox/data/c;", "p0", "p1", "", "b", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.schooltoolbox.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8763a extends DiffUtil.ItemCallback<c> {
        static IPatchRedirector $redirector_;

        C8763a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull c p06, @NotNull c p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06, (Object) p16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull c p06, @NotNull c p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06, (Object) p16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }
    }

    public a(long j3) {
        super(new C8763a(), new AdapterDelegatesManager(new i(), new d(), new e(), new f(j3), new g(j3), new h(j3)));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        }
    }

    public final void submitList(@NotNull List<? extends c> newList) {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newList);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        AsyncListDiffer<T> asyncListDiffer = this.differ;
        list = CollectionsKt___CollectionsKt.toList(newList);
        asyncListDiffer.submitList(list);
    }
}
