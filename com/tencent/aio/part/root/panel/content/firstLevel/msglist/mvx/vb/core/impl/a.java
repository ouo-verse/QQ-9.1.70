package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import android.annotation.SuppressLint;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0010H\u0097\u0001J\u0019\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0001J%\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/a;", "Lcom/tencent/aio/api/list/e;", "Lcom/tencent/aio/api/list/d;", "", "position", "Lcom/tencent/aio/data/msglist/a;", HippyTKDListViewAdapter.X, "w", "startPosition", "endPosition", "Lkotlin/Pair;", "Lcom/tencent/aio/api/vo/a;", "J", "Landroid/view/View;", "view", "index", "", "B", "notifyDataSetChanged", "fromPosition", "toPosition", "v", "positionStart", "itemCount", "d", "", "payload", "u", h.F, "e", "K", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "adapter", "updateCallBack", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;Lcom/tencent/aio/api/list/d;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements com.tencent.aio.api.list.e, com.tencent.aio.api.list.d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a adapter;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ com.tencent.aio.api.list.d f69625e;

    public a(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a adapter, @NotNull com.tencent.aio.api.list.d updateCallBack) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(updateCallBack, "updateCallBack");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) adapter, (Object) updateCallBack);
        } else {
            this.f69625e = updateCallBack;
            this.adapter = adapter;
        }
    }

    @Override // com.tencent.aio.api.list.c
    public void B(@NotNull View view, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, index);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f69625e.B(view, index);
        }
    }

    @Override // com.tencent.aio.api.list.e
    @NotNull
    public Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J(int startPosition, int endPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(startPosition), Integer.valueOf(endPosition));
        }
        while (startPosition <= endPosition) {
            com.tencent.aio.data.msglist.a x16 = x(startPosition);
            com.tencent.aio.data.msglist.a x17 = x(endPosition);
            if (x16 != null && x17 != null) {
                return new Pair<>(new com.tencent.aio.api.vo.a(x16, startPosition), new com.tencent.aio.api.vo.a(x17, endPosition));
            }
            if (x16 == null) {
                startPosition++;
            }
            if (x17 == null) {
                endPosition--;
            }
        }
        return new Pair<>(null, null);
    }

    @Override // com.tencent.aio.api.list.c
    public void K(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f69625e.K(view);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void d(int positionStart, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            this.f69625e.d(positionStart, itemCount);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void e(int positionStart, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            this.f69625e.e(positionStart, itemCount);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void h(int positionStart, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            this.f69625e.h(positionStart, itemCount);
        }
    }

    @Override // com.tencent.aio.api.list.d
    @SuppressLint({"NotifyDataSetChanged"})
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f69625e.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void u(int positionStart, int itemCount, @Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount), payload);
        } else {
            this.f69625e.u(positionStart, itemCount, payload);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void v(int fromPosition, int toPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
        } else {
            this.f69625e.v(fromPosition, toPosition);
        }
    }

    @Override // com.tencent.aio.api.list.e
    public int w(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, position)).intValue();
        }
        if (position < this.adapter.n0() || position >= this.adapter.n0() + this.adapter.o0()) {
            return -1;
        }
        return position - this.adapter.n0();
    }

    @Override // com.tencent.aio.api.list.e
    @Nullable
    public com.tencent.aio.data.msglist.a x(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 1, (Object) this, position);
        }
        if (position < this.adapter.n0() || position >= this.adapter.n0() + this.adapter.o0()) {
            return null;
        }
        return this.adapter.j0().t().get(position - this.adapter.n0());
    }
}
