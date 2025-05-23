package com.tencent.mobileqq.aio.robot.helper;

import android.view.View;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.aio.menu.ui.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/helper/RobotEventIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ShowPopupMenu", "Lcom/tencent/mobileqq/aio/robot/helper/RobotEventIntent$ShowPopupMenu;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class RobotEventIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/helper/RobotEventIntent$ShowPopupMenu;", "Lcom/tencent/mobileqq/aio/robot/helper/RobotEventIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "anchor", "Lcom/tencent/qqnt/aio/menu/ui/c;", "e", "Lcom/tencent/qqnt/aio/menu/ui/c;", "b", "()Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "<init>", "(Landroid/view/View;Lcom/tencent/qqnt/aio/menu/ui/c;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class ShowPopupMenu extends RobotEventIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View anchor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final c menu;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPopupMenu(@NotNull View anchor, @NotNull c menu) {
            super(null);
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            Intrinsics.checkNotNullParameter(menu, "menu");
            this.anchor = anchor;
            this.menu = menu;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getAnchor() {
            return this.anchor;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final c getMenu() {
            return this.menu;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowPopupMenu)) {
                return false;
            }
            ShowPopupMenu showPopupMenu = (ShowPopupMenu) other;
            if (Intrinsics.areEqual(this.anchor, showPopupMenu.anchor) && Intrinsics.areEqual(this.menu, showPopupMenu.menu)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.aio.robot.helper.RobotEventIntent.ShowPopupMenu";
        }

        public int hashCode() {
            return (this.anchor.hashCode() * 31) + this.menu.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowPopupMenu(anchor=" + this.anchor + ", menu=" + this.menu + ")";
        }
    }

    public /* synthetic */ RobotEventIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotEventIntent() {
    }
}
