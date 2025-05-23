package com.tencent.biz.pubaccount.aio;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\t\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\t\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lat/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "AddInputContainerAboveViewIntent", "CustomMenuItemClickIntent", "CustomMenuSwitchBtnClickIntent", "CustomMenuSwitchBtnVisibleIntent", "InputContainerAboveViewParentMarginIntent", "InputContainerVisibleIntent", "InputMenuSwitchBtnClickIntent", "RemoveInputContainerAboveViewIntent", "SwitchMenuIntent", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$AddInputContainerAboveViewIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$CustomMenuItemClickIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$CustomMenuSwitchBtnClickIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$CustomMenuSwitchBtnVisibleIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$InputContainerAboveViewParentMarginIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$InputContainerVisibleIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$InputMenuSwitchBtnClickIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$RemoveInputContainerAboveViewIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent$SwitchMenuIntent;", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class PAInputIntent implements at.a, MsgIntent {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$AddInputContainerAboveViewIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Landroid/view/View;", "d", "Landroid/view/View;", "b", "()Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "e", "Landroid/view/ViewGroup$LayoutParams;", "a", "()Landroid/view/ViewGroup$LayoutParams;", "params", "<init>", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class AddInputContainerAboveViewIntent extends PAInputIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewGroup.LayoutParams params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddInputContainerAboveViewIntent(@NotNull View view, @NotNull ViewGroup.LayoutParams params) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(params, "params");
            this.view = view;
            this.params = params;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ViewGroup.LayoutParams getParams() {
            return this.params;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final View getView() {
            return this.view;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$CustomMenuItemClickIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "menuCommand", "e", "I", "b", "()I", "menuId", "f", "c", "menuLevel", "<init>", "(Ljava/lang/String;II)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final /* data */ class CustomMenuItemClickIntent extends PAInputIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String menuCommand;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int menuId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int menuLevel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomMenuItemClickIntent(@NotNull String menuCommand, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(menuCommand, "menuCommand");
            this.menuCommand = menuCommand;
            this.menuId = i3;
            this.menuLevel = i16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getMenuCommand() {
            return this.menuCommand;
        }

        /* renamed from: b, reason: from getter */
        public final int getMenuId() {
            return this.menuId;
        }

        /* renamed from: c, reason: from getter */
        public final int getMenuLevel() {
            return this.menuLevel;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomMenuItemClickIntent)) {
                return false;
            }
            CustomMenuItemClickIntent customMenuItemClickIntent = (CustomMenuItemClickIntent) other;
            if (Intrinsics.areEqual(this.menuCommand, customMenuItemClickIntent.menuCommand) && this.menuId == customMenuItemClickIntent.menuId && this.menuLevel == customMenuItemClickIntent.menuLevel) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.menuCommand.hashCode() * 31) + this.menuId) * 31) + this.menuLevel;
        }

        @NotNull
        public String toString() {
            return "CustomMenuItemClickIntent(menuCommand=" + this.menuCommand + ", menuId=" + this.menuId + ", menuLevel=" + this.menuLevel + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$CustomMenuSwitchBtnClickIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "()V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class CustomMenuSwitchBtnClickIntent extends PAInputIntent {
        public CustomMenuSwitchBtnClickIntent() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$CustomMenuSwitchBtnVisibleIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class CustomMenuSwitchBtnVisibleIntent extends PAInputIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        public CustomMenuSwitchBtnVisibleIntent(int i3) {
            super(null);
            this.visibility = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$InputContainerAboveViewParentMarginIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "", "d", "I", "b", "()I", "leftMargin", "e", "topMargin", "f", "c", "rightMargin", tl.h.F, "a", "bottomMargin", "<init>", "(IIII)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class InputContainerAboveViewParentMarginIntent extends PAInputIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int leftMargin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int topMargin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int rightMargin;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final int bottomMargin;

        public InputContainerAboveViewParentMarginIntent(int i3, int i16, int i17, int i18) {
            super(null);
            this.leftMargin = i3;
            this.topMargin = i16;
            this.rightMargin = i17;
            this.bottomMargin = i18;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottomMargin() {
            return this.bottomMargin;
        }

        /* renamed from: b, reason: from getter */
        public final int getLeftMargin() {
            return this.leftMargin;
        }

        /* renamed from: c, reason: from getter */
        public final int getRightMargin() {
            return this.rightMargin;
        }

        /* renamed from: d, reason: from getter */
        public final int getTopMargin() {
            return this.topMargin;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$InputContainerVisibleIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class InputContainerVisibleIntent extends PAInputIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        public InputContainerVisibleIntent(int i3) {
            super(null);
            this.visibility = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$InputMenuSwitchBtnClickIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "()V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class InputMenuSwitchBtnClickIntent extends PAInputIntent {
        public InputMenuSwitchBtnClickIntent() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$RemoveInputContainerAboveViewIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "view", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class RemoveInputContainerAboveViewIntent extends PAInputIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getView() {
            return this.view;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputIntent$SwitchMenuIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "", "d", "I", "a", "()I", "type", "", "e", "Z", "b", "()Z", "isNeedAnimate", "<init>", "(IZ)V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class SwitchMenuIntent extends PAInputIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isNeedAnimate;

        public SwitchMenuIntent(int i3, boolean z16) {
            super(null);
            this.type = i3;
            this.isNeedAnimate = z16;
        }

        /* renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsNeedAnimate() {
            return this.isNeedAnimate;
        }
    }

    public /* synthetic */ PAInputIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    PAInputIntent() {
    }
}
