package com.tencent.mobileqq.gamecenter.nt.aio.bottom;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgBottomBarEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "AddBottomView", "RemoveBottomView", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public class GameMsgBottomBarEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgBottomBarEvent$AddBottomView;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgBottomBarEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "priority", "Landroid/view/View;", "e", "Landroid/view/View;", "c", "()Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "f", "Landroid/view/ViewGroup$LayoutParams;", "a", "()Landroid/view/ViewGroup$LayoutParams;", "params", "<init>", "(ILandroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class AddBottomView extends GameMsgBottomBarEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int priority;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View view;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ViewGroup.LayoutParams params;

        public AddBottomView(int i3, @NotNull View view, @NotNull ViewGroup.LayoutParams params) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(params, "params");
            this.priority = i3;
            this.view = view;
            this.params = params;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ViewGroup.LayoutParams getParams() {
            return this.params;
        }

        /* renamed from: b, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddBottomView)) {
                return false;
            }
            AddBottomView addBottomView = (AddBottomView) other;
            if (this.priority == addBottomView.priority && Intrinsics.areEqual(this.view, addBottomView.view) && Intrinsics.areEqual(this.params, addBottomView.params)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.priority * 31) + this.view.hashCode()) * 31) + this.params.hashCode();
        }

        @NotNull
        public String toString() {
            return "AddBottomView(priority=" + this.priority + ", view=" + this.view + ", params=" + this.params + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgBottomBarEvent$RemoveBottomView;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/bottom/GameMsgBottomBarEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class RemoveBottomView extends GameMsgBottomBarEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View view;

        public RemoveBottomView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RemoveBottomView) && Intrinsics.areEqual(this.view, ((RemoveBottomView) other).view)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.view.hashCode();
        }

        @NotNull
        public String toString() {
            return "RemoveBottomView(view=" + this.view + ')';
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
