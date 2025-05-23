package com.tencent.robot.aio.bottombar;

import android.view.View;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "", "<init>", "()V", "HideRobotBottomBar", "PostThemeChanged", "ShowRobotBottomBar", "SubmitBottomItemList", "SubmitSections", "UpdateBlurState", "UpdateBottomItem", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$HideRobotBottomBar;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$PostThemeChanged;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$ShowRobotBottomBar;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$SubmitBottomItemList;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$SubmitSections;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$UpdateBlurState;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$UpdateBottomItem;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class RobotBottomBarUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$HideRobotBottomBar;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class HideRobotBottomBar extends RobotBottomBarUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideRobotBottomBar f366866d = new HideRobotBottomBar();

        HideRobotBottomBar() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$PostThemeChanged;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class PostThemeChanged extends RobotBottomBarUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final PostThemeChanged f366867d = new PostThemeChanged();

        PostThemeChanged() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$ShowRobotBottomBar;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowRobotBottomBar extends RobotBottomBarUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowRobotBottomBar f366868d = new ShowRobotBottomBar();

        ShowRobotBottomBar() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$SubmitBottomItemList;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/robot/aio/bottombar/model/a;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "dataList", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitBottomItemList extends RobotBottomBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<RobotBottomBarItemModel> dataList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitBottomItemList(@NotNull List<RobotBottomBarItemModel> dataList) {
            super(null);
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.dataList = dataList;
        }

        @NotNull
        public final List<RobotBottomBarItemModel> a() {
            return this.dataList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitBottomItemList) && Intrinsics.areEqual(this.dataList, ((SubmitBottomItemList) other).dataList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.dataList.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitBottomItemList(dataList=" + this.dataList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$SubmitSections;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitSections extends RobotBottomBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Object> data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitSections(@NotNull List<Object> data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitSections) && Intrinsics.areEqual(this.data, ((SubmitSections) other).data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitSections(data=" + this.data + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$UpdateBlurState;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "c", "()Z", "show", "Landroid/view/View;", "e", "Landroid/view/View;", "b", "()Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "bgList", "<init>", "(ZLandroid/view/View;Ljava/util/ArrayList;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateBlurState extends RobotBottomBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean show;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final View bgView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final ArrayList<Object> bgList;

        public /* synthetic */ UpdateBlurState(boolean z16, View view, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? null : view, (i3 & 4) != 0 ? null : arrayList);
        }

        @Nullable
        public final ArrayList<Object> a() {
            return this.bgList;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final View getBgView() {
            return this.bgView;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateBlurState)) {
                return false;
            }
            UpdateBlurState updateBlurState = (UpdateBlurState) other;
            if (this.show == updateBlurState.show && Intrinsics.areEqual(this.bgView, updateBlurState.bgView) && Intrinsics.areEqual(this.bgList, updateBlurState.bgList)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.show;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            View view = this.bgView;
            int i16 = 0;
            if (view == null) {
                hashCode = 0;
            } else {
                hashCode = view.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            ArrayList<Object> arrayList = this.bgList;
            if (arrayList != null) {
                i16 = arrayList.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "UpdateBlurState(show=" + this.show + ", bgView=" + this.bgView + ", bgList=" + this.bgList + ")";
        }

        public UpdateBlurState(boolean z16, @Nullable View view, @Nullable ArrayList<Object> arrayList) {
            super(null);
            this.show = z16;
            this.bgView = view;
            this.bgList = arrayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState$UpdateBottomItem;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/aio/bottombar/model/a;", "d", "Lcom/tencent/robot/aio/bottombar/model/a;", "a", "()Lcom/tencent/robot/aio/bottombar/model/a;", "data", "<init>", "(Lcom/tencent/robot/aio/bottombar/model/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateBottomItem extends RobotBottomBarUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RobotBottomBarItemModel data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateBottomItem(@NotNull RobotBottomBarItemModel data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotBottomBarItemModel getData() {
            return this.data;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateBottomItem) && Intrinsics.areEqual(this.data, ((UpdateBottomItem) other).data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateBottomItem(data=" + this.data + ")";
        }
    }

    public /* synthetic */ RobotBottomBarUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    RobotBottomBarUIState() {
    }
}
