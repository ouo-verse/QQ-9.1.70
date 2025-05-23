package com.tencent.robot.widget.list.vb;

import a74.CustomTitleInfo;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnItemClickMsgIntent", "SubmitListMsgIntent", "Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent$OnItemClickMsgIntent;", "Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent$SubmitListMsgIntent;", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class CommonListMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent$OnItemClickMsgIntent;", "Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lb74/a;", "d", "Lb74/a;", "a", "()Lb74/a;", "itemData", "<init>", "(Lb74/a;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnItemClickMsgIntent extends CommonListMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final b74.a itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnItemClickMsgIntent(@NotNull b74.a itemData) {
            super(null);
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this.itemData = itemData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final b74.a getItemData() {
            return this.itemData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnItemClickMsgIntent) && Intrinsics.areEqual(this.itemData, ((OnItemClickMsgIntent) other).itemData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.itemData.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnItemClickMsgIntent(itemData=" + this.itemData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\f\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent$SubmitListMsgIntent;", "Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lb74/a;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "itemDataList", "e", "I", "()I", QQBrowserActivityConstants.KEY_TITLE_STYLE, "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "c", "()Ljava/lang/Runnable;", "submitCallback", "La74/a;", h.F, "La74/a;", "a", "()La74/a;", "customTitleInfo", "<init>", "(Ljava/util/List;ILjava/lang/Runnable;La74/a;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitListMsgIntent extends CommonListMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<b74.a> itemDataList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int titleStyle;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Runnable submitCallback;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final CustomTitleInfo customTitleInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public SubmitListMsgIntent(@NotNull List<? extends b74.a> itemDataList, int i3, @Nullable Runnable runnable, @Nullable CustomTitleInfo customTitleInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(itemDataList, "itemDataList");
            this.itemDataList = itemDataList;
            this.titleStyle = i3;
            this.submitCallback = runnable;
            this.customTitleInfo = customTitleInfo;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final CustomTitleInfo getCustomTitleInfo() {
            return this.customTitleInfo;
        }

        @NotNull
        public final List<b74.a> b() {
            return this.itemDataList;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Runnable getSubmitCallback() {
            return this.submitCallback;
        }

        /* renamed from: d, reason: from getter */
        public final int getTitleStyle() {
            return this.titleStyle;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubmitListMsgIntent)) {
                return false;
            }
            SubmitListMsgIntent submitListMsgIntent = (SubmitListMsgIntent) other;
            if (Intrinsics.areEqual(this.itemDataList, submitListMsgIntent.itemDataList) && this.titleStyle == submitListMsgIntent.titleStyle && Intrinsics.areEqual(this.submitCallback, submitListMsgIntent.submitCallback) && Intrinsics.areEqual(this.customTitleInfo, submitListMsgIntent.customTitleInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.itemDataList.hashCode() * 31) + this.titleStyle) * 31;
            Runnable runnable = this.submitCallback;
            int i3 = 0;
            if (runnable == null) {
                hashCode = 0;
            } else {
                hashCode = runnable.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            CustomTitleInfo customTitleInfo = this.customTitleInfo;
            if (customTitleInfo != null) {
                i3 = customTitleInfo.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "SubmitListMsgIntent(itemDataList=" + this.itemDataList + ", titleStyle=" + this.titleStyle + ", submitCallback=" + this.submitCallback + ", customTitleInfo=" + this.customTitleInfo + ")";
        }

        public /* synthetic */ SubmitListMsgIntent(List list, int i3, Runnable runnable, CustomTitleInfo customTitleInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : runnable, (i16 & 8) != 0 ? null : customTitleInfo);
        }
    }

    public /* synthetic */ CommonListMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    CommonListMsgIntent() {
    }
}
