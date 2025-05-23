package com.tencent.robot.widget.bottomdialog.adorn.msgintent;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "DisplayModeChange", "OnDismissAnimStart", "OnScrollToBottom", "OnScrollToTop", "UpdateLayoutMsgIntent", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$DisplayModeChange;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$OnDismissAnimStart;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$OnScrollToBottom;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$OnScrollToTop;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$UpdateLayoutMsgIntent;", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class BottomSheetDialogAdornMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$DisplayModeChange;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "newMode", "e", "b", "oldMode", "<init>", "(II)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class DisplayModeChange extends BottomSheetDialogAdornMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int newMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int oldMode;

        public DisplayModeChange(int i3, int i16) {
            super(null);
            this.newMode = i3;
            this.oldMode = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getNewMode() {
            return this.newMode;
        }

        /* renamed from: b, reason: from getter */
        public final int getOldMode() {
            return this.oldMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DisplayModeChange)) {
                return false;
            }
            DisplayModeChange displayModeChange = (DisplayModeChange) other;
            if (this.newMode == displayModeChange.newMode && this.oldMode == displayModeChange.oldMode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.newMode * 31) + this.oldMode;
        }

        @NotNull
        public String toString() {
            return "DisplayModeChange(newMode=" + this.newMode + ", oldMode=" + this.oldMode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$OnDismissAnimStart;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent;", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnDismissAnimStart extends BottomSheetDialogAdornMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnDismissAnimStart f368649d = new OnDismissAnimStart();

        OnDismissAnimStart() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$OnScrollToBottom;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent;", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnScrollToBottom extends BottomSheetDialogAdornMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnScrollToBottom f368650d = new OnScrollToBottom();

        OnScrollToBottom() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$OnScrollToTop;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent;", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnScrollToTop extends BottomSheetDialogAdornMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnScrollToTop f368651d = new OnScrollToTop();

        OnScrollToTop() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rB\u0019\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$UpdateLayoutMsgIntent;", "Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "payload", "<init>", "(Ljava/util/List;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateLayoutMsgIntent extends BottomSheetDialogAdornMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<Object> payload;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/adorn/msgintent/BottomSheetDialogAdornMsgIntent$UpdateLayoutMsgIntent$a;", "", "<init>", "()V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f368653a = new a();

            a() {
            }
        }

        public UpdateLayoutMsgIntent() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        public final List<Object> a() {
            return this.payload;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateLayoutMsgIntent) && Intrinsics.areEqual(this.payload, ((UpdateLayoutMsgIntent) other).payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            List<Object> list = this.payload;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateLayoutMsgIntent(payload=" + this.payload + ")";
        }

        public /* synthetic */ UpdateLayoutMsgIntent(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : list);
        }

        public UpdateLayoutMsgIntent(@Nullable List<? extends Object> list) {
            super(null);
            this.payload = list;
        }
    }

    public /* synthetic */ BottomSheetDialogAdornMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    BottomSheetDialogAdornMsgIntent() {
    }
}
