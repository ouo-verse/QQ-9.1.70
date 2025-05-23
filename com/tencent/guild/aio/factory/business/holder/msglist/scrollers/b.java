package com.tencent.guild.aio.factory.business.holder.msglist.scrollers;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \"2\u00020\u0001:\u0002\u0017\u001bB\u0007\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010 R\"\u0010&\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b$b;", "focusTarget", "", "e", "", "position", "d", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "g", "c", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "i", "uiHelper", DownloaderConstant.KEY_RANGE, "", h.F, "a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "scroller", "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "contextWeakRef", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b$b;", "currentFocusTarget", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "I", "f", "()I", "setRecyclerViewHeight", "(I)V", "recyclerViewHeight", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearSmoothScroller scroller;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Context> contextWeakRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FocusTarget currentFocusTarget;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IListUIOperationApi uiHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int recyclerViewHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "position", "b", "Ljava/lang/Integer;", "getUpdateType", "()Ljava/lang/Integer;", "updateType", "<init>", "(ILjava/lang/Integer;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class FocusTarget {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer updateType;

        public FocusTarget(int i3, @Nullable Integer num) {
            this.position = i3;
            this.updateType = num;
        }

        /* renamed from: a, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FocusTarget)) {
                return false;
            }
            FocusTarget focusTarget = (FocusTarget) other;
            if (this.position == focusTarget.position && Intrinsics.areEqual(this.updateType, focusTarget.updateType)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.position * 31;
            Integer num = this.updateType;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "FocusTarget(position=" + this.position + ", updateType=" + this.updateType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/scrollers/b$c", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", DKHippyEvent.EVENT_STOP, "", "dx", "calculateTimeForScrolling", "getVerticalSnapPreference", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends LinearSmoothScroller {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f110647c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, b bVar) {
            super(context);
            this.f110647c = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            QLog.d("FocusBottomHandler", 4, "calculateTimeForScrolling dx=" + dx5);
            if (dx5 > this.f110647c.getRecyclerViewHeight() / 2) {
                return 100;
            }
            if (dx5 > 0) {
                return 80;
            }
            return (int) Math.ceil(dx5);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
            super.onStop();
            IListUIOperationApi iListUIOperationApi = this.f110647c.uiHelper;
            FocusTarget focusTarget = this.f110647c.currentFocusTarget;
            if (iListUIOperationApi != null && focusTarget != null && !this.f110647c.h(iListUIOperationApi, 1)) {
                QLog.d("FocusBottomHandler", 1, "smooth scroll is stop before reach target");
            }
        }
    }

    private final LinearSmoothScroller c(Context context) {
        return new c(context, this);
    }

    private final void d(IListUIOperationApi helper, int position) {
        QLog.d("FocusBottomHandler", 2, "scroll to position directly");
        a.C11562a.a(helper, position, true, null, 4, null);
    }

    private final void e(IListUIOperationApi helper, FocusTarget focusTarget) {
        QLog.d("FocusBottomHandler", 4, "doSmoothScroll");
        Context context = helper.i().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "helper.getRecycleView().context");
        LinearSmoothScroller g16 = g(context);
        g16.setTargetPosition(focusTarget.getPosition());
        helper.i().getLayoutManager().startSmoothScroll(g16);
    }

    private final LinearSmoothScroller g(Context context) {
        Context context2;
        WeakReference<Context> weakReference = this.contextWeakRef;
        if (weakReference != null) {
            context2 = weakReference.get();
        } else {
            context2 = null;
        }
        if (!Intrinsics.areEqual(context, context2)) {
            this.contextWeakRef = new WeakReference<>(context);
            this.scroller = c(context);
        }
        if (this.scroller == null) {
            this.scroller = c(context);
        }
        LinearSmoothScroller linearSmoothScroller = this.scroller;
        Intrinsics.checkNotNull(linearSmoothScroller, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearSmoothScroller");
        return linearSmoothScroller;
    }

    /* renamed from: f, reason: from getter */
    public final int getRecyclerViewHeight() {
        return this.recyclerViewHeight;
    }

    public final boolean h(@NotNull IListUIOperationApi uiHelper, int range) {
        int i3;
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        int size = uiHelper.t().size();
        try {
            i3 = uiHelper.i().getLayoutManager().findLastVisibleItemPosition();
        } catch (NullPointerException e16) {
            QLog.e("FocusBottomHandler", 1, "isInBottomRange currentListSize=" + size + " e:" + e16);
            i3 = -1;
        }
        QLog.d("FocusBottomHandler", 4, "currentListSize=" + size + " lastItemPos=" + i3);
        if (i3 >= size - range && i3 < size) {
            return true;
        }
        return false;
    }

    public final void i(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Bundle extra = state.getExtra();
        if (extra != null) {
            z16 = extra.getBoolean("FOCUS_NO_ANIM");
        } else {
            z16 = false;
        }
        this.uiHelper = helper;
        this.recyclerViewHeight = helper.i().getHeight();
        int size = state.size() - 1;
        boolean isSmoothScrolling = helper.i().getLayoutManager().isSmoothScrolling();
        boolean h16 = h(helper, 2);
        QLog.d("FocusBottomHandler", 4, "processFocusBottom|isSmoothScrolling=" + isSmoothScrolling + " targetPosition=" + size + " isInBottomRange=" + h16 + " noAnim=" + z16);
        if (size >= 0 && size <= helper.i().getLayoutManager().getItemCount() - 1) {
            FocusTarget focusTarget = new FocusTarget(size, Integer.valueOf(state.getUpdateType()));
            if (h16 && !z16) {
                e(helper, focusTarget);
            } else {
                if (isSmoothScrolling) {
                    helper.i().stopScroll();
                }
                d(helper, size);
            }
            this.currentFocusTarget = focusTarget;
        }
    }
}
