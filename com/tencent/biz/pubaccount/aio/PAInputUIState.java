package com.tencent.biz.pubaccount.aio;

import com.tencent.aio.base.mvi.part.InputUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "<init>", "()V", "CustomMenuDismissPopupMenuState", "CustomMenuSwitchBtnVisibleState", "InitState", "InputContainerVisibleState", "OnResumeState", "SetCustomMenuDataState", "SetLongShotBarVisibility", "SetMultiSelectBarVisibility", "SwitchMenuDataState", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$CustomMenuDismissPopupMenuState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$CustomMenuSwitchBtnVisibleState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$InitState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$InputContainerVisibleState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$OnResumeState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SetCustomMenuDataState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SetLongShotBarVisibility;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SetMultiSelectBarVisibility;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SwitchMenuDataState;", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class PAInputUIState implements InputUIState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$CustomMenuDismissPopupMenuState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public static final class CustomMenuDismissPopupMenuState extends PAInputUIState {
        public CustomMenuDismissPopupMenuState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$CustomMenuSwitchBtnVisibleState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class CustomMenuSwitchBtnVisibleState extends PAInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public CustomMenuSwitchBtnVisibleState(int i3) {
            super(null);
            this.visibility = i3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$InitState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "Lcom/tencent/biz/pubaccount/aio/b;", "d", "Lcom/tencent/biz/pubaccount/aio/b;", "a", "()Lcom/tencent/biz/pubaccount/aio/b;", "pAInputSessionInfo", "<init>", "(Lcom/tencent/biz/pubaccount/aio/b;)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class InitState extends PAInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final PAInputSessionInfo pAInputSessionInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitState(PAInputSessionInfo pAInputSessionInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(pAInputSessionInfo, "pAInputSessionInfo");
            this.pAInputSessionInfo = pAInputSessionInfo;
        }

        /* renamed from: a, reason: from getter */
        public final PAInputSessionInfo getPAInputSessionInfo() {
            return this.pAInputSessionInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$InputContainerVisibleState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class InputContainerVisibleState extends PAInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public InputContainerVisibleState(int i3) {
            super(null);
            this.visibility = i3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$OnResumeState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public static final class OnResumeState extends PAInputUIState {
        public OnResumeState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SetCustomMenuDataState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "Lcom/tencent/biz/ui/c;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "customViewDatas", "<init>", "(Ljava/util/List;)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class SetCustomMenuDataState extends PAInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final List<com.tencent.biz.ui.c> customViewDatas;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public SetCustomMenuDataState(List<? extends com.tencent.biz.ui.c> customViewDatas) {
            super(null);
            Intrinsics.checkNotNullParameter(customViewDatas, "customViewDatas");
            this.customViewDatas = customViewDatas;
        }

        public final List<com.tencent.biz.ui.c> a() {
            return this.customViewDatas;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SetLongShotBarVisibility;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final /* data */ class SetLongShotBarVisibility extends PAInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibility;

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            return this.visibility;
        }

        public String toString() {
            return "SetLongShotBarVisibility(visibility=" + this.visibility + ')';
        }

        public SetLongShotBarVisibility(int i3) {
            super(null);
            this.visibility = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SetLongShotBarVisibility) && this.visibility == ((SetLongShotBarVisibility) other).visibility;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SetMultiSelectBarVisibility;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "visibility", "<init>", "(I)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final /* data */ class SetMultiSelectBarVisibility extends PAInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibility;

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            return this.visibility;
        }

        public String toString() {
            return "SetMultiSelectBarVisibility(visibility=" + this.visibility + ')';
        }

        public SetMultiSelectBarVisibility(int i3) {
            super(null);
            this.visibility = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SetMultiSelectBarVisibility) && this.visibility == ((SetMultiSelectBarVisibility) other).visibility;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SwitchMenuDataState;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "d", "I", "a", "()I", "type", "", "e", "Z", "isNeedAnimate", "()Z", "<init>", "(IZ)V", "f", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class SwitchMenuDataState extends PAInputUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isNeedAnimate;

        /* renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public SwitchMenuDataState(int i3, boolean z16) {
            super(null);
            this.type = i3;
            this.isNeedAnimate = z16;
        }
    }

    public /* synthetic */ PAInputUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    PAInputUIState() {
    }
}
