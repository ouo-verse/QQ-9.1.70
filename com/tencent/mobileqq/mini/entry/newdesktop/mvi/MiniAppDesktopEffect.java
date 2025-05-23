package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "", "()V", "OnBottomPartDragDropAdd", "OnBottomPartDragDropDelete", "OnDragEntered", "OuterRvPartOnPause", "OuterRvPartOnResume", "OuterRvPartOnScrollStateChanged", "SetSubLayoutDesktopDataList", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OnBottomPartDragDropAdd;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OnBottomPartDragDropDelete;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OnDragEntered;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OuterRvPartOnPause;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OuterRvPartOnResume;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OuterRvPartOnScrollStateChanged;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$SetSubLayoutDesktopDataList;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class MiniAppDesktopEffect {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OnDragEntered;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "startDragViewId", "", "receiveViewId", "(II)V", "getReceiveViewId", "()I", "getStartDragViewId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnDragEntered extends MiniAppDesktopEffect {
        private final int receiveViewId;
        private final int startDragViewId;

        /* renamed from: component1, reason: from getter */
        public final int getStartDragViewId() {
            return this.startDragViewId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getReceiveViewId() {
            return this.receiveViewId;
        }

        public final OnDragEntered copy(int startDragViewId, int receiveViewId) {
            return new OnDragEntered(startDragViewId, receiveViewId);
        }

        public final int getReceiveViewId() {
            return this.receiveViewId;
        }

        public final int getStartDragViewId() {
            return this.startDragViewId;
        }

        public int hashCode() {
            return (this.startDragViewId * 31) + this.receiveViewId;
        }

        public String toString() {
            return "OnDragEntered(startDragViewId=" + this.startDragViewId + ", receiveViewId=" + this.receiveViewId + ")";
        }

        public OnDragEntered(int i3, int i16) {
            super(null);
            this.startDragViewId = i3;
            this.receiveViewId = i16;
        }

        public static /* synthetic */ OnDragEntered copy$default(OnDragEntered onDragEntered, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = onDragEntered.startDragViewId;
            }
            if ((i17 & 2) != 0) {
                i16 = onDragEntered.receiveViewId;
            }
            return onDragEntered.copy(i3, i16);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnDragEntered)) {
                return false;
            }
            OnDragEntered onDragEntered = (OnDragEntered) other;
            return this.startDragViewId == onDragEntered.startDragViewId && this.receiveViewId == onDragEntered.receiveViewId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OuterRvPartOnPause;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "state", "", "(I)V", "getState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OuterRvPartOnPause extends MiniAppDesktopEffect {
        private final int state;

        /* renamed from: component1, reason: from getter */
        public final int getState() {
            return this.state;
        }

        public final OuterRvPartOnPause copy(int state) {
            return new OuterRvPartOnPause(state);
        }

        public final int getState() {
            return this.state;
        }

        public int hashCode() {
            return this.state;
        }

        public String toString() {
            return "OuterRvPartOnPause(state=" + this.state + ")";
        }

        public OuterRvPartOnPause(int i3) {
            super(null);
            this.state = i3;
        }

        public static /* synthetic */ OuterRvPartOnPause copy$default(OuterRvPartOnPause outerRvPartOnPause, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = outerRvPartOnPause.state;
            }
            return outerRvPartOnPause.copy(i3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OuterRvPartOnPause) && this.state == ((OuterRvPartOnPause) other).state;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OuterRvPartOnResume;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "state", "", "(I)V", "getState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OuterRvPartOnResume extends MiniAppDesktopEffect {
        private final int state;

        /* renamed from: component1, reason: from getter */
        public final int getState() {
            return this.state;
        }

        public final OuterRvPartOnResume copy(int state) {
            return new OuterRvPartOnResume(state);
        }

        public final int getState() {
            return this.state;
        }

        public int hashCode() {
            return this.state;
        }

        public String toString() {
            return "OuterRvPartOnResume(state=" + this.state + ")";
        }

        public OuterRvPartOnResume(int i3) {
            super(null);
            this.state = i3;
        }

        public static /* synthetic */ OuterRvPartOnResume copy$default(OuterRvPartOnResume outerRvPartOnResume, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = outerRvPartOnResume.state;
            }
            return outerRvPartOnResume.copy(i3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OuterRvPartOnResume) && this.state == ((OuterRvPartOnResume) other).state;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OuterRvPartOnScrollStateChanged;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "newState", "", "(I)V", "getNewState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OuterRvPartOnScrollStateChanged extends MiniAppDesktopEffect {
        private final int newState;

        /* renamed from: component1, reason: from getter */
        public final int getNewState() {
            return this.newState;
        }

        public final OuterRvPartOnScrollStateChanged copy(int newState) {
            return new OuterRvPartOnScrollStateChanged(newState);
        }

        public final int getNewState() {
            return this.newState;
        }

        public int hashCode() {
            return this.newState;
        }

        public String toString() {
            return "OuterRvPartOnScrollStateChanged(newState=" + this.newState + ")";
        }

        public OuterRvPartOnScrollStateChanged(int i3) {
            super(null);
            this.newState = i3;
        }

        public static /* synthetic */ OuterRvPartOnScrollStateChanged copy$default(OuterRvPartOnScrollStateChanged outerRvPartOnScrollStateChanged, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = outerRvPartOnScrollStateChanged.newState;
            }
            return outerRvPartOnScrollStateChanged.copy(i3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OuterRvPartOnScrollStateChanged) && this.newState == ((OuterRvPartOnScrollStateChanged) other).newState;
        }
    }

    public /* synthetic */ MiniAppDesktopEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    MiniAppDesktopEffect() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OnBottomPartDragDropAdd;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "fromMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;)V", "getFromMiniAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnBottomPartDragDropAdd extends MiniAppDesktopEffect {
        private final DesktopAppInfo fromMiniAppInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBottomPartDragDropAdd(DesktopAppInfo fromMiniAppInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(fromMiniAppInfo, "fromMiniAppInfo");
            this.fromMiniAppInfo = fromMiniAppInfo;
        }

        /* renamed from: component1, reason: from getter */
        public final DesktopAppInfo getFromMiniAppInfo() {
            return this.fromMiniAppInfo;
        }

        public final OnBottomPartDragDropAdd copy(DesktopAppInfo fromMiniAppInfo) {
            Intrinsics.checkNotNullParameter(fromMiniAppInfo, "fromMiniAppInfo");
            return new OnBottomPartDragDropAdd(fromMiniAppInfo);
        }

        public final DesktopAppInfo getFromMiniAppInfo() {
            return this.fromMiniAppInfo;
        }

        public int hashCode() {
            return this.fromMiniAppInfo.hashCode();
        }

        public String toString() {
            return "OnBottomPartDragDropAdd(fromMiniAppInfo=" + this.fromMiniAppInfo + ")";
        }

        public static /* synthetic */ OnBottomPartDragDropAdd copy$default(OnBottomPartDragDropAdd onBottomPartDragDropAdd, DesktopAppInfo desktopAppInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                desktopAppInfo = onBottomPartDragDropAdd.fromMiniAppInfo;
            }
            return onBottomPartDragDropAdd.copy(desktopAppInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnBottomPartDragDropAdd) && Intrinsics.areEqual(this.fromMiniAppInfo, ((OnBottomPartDragDropAdd) other).fromMiniAppInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$OnBottomPartDragDropDelete;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "startDragViewId", "", "receiveViewId", "fromPosition", "fromMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(IIILcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;)V", "getFromMiniAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getFromPosition", "()I", "getReceiveViewId", "getStartDragViewId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnBottomPartDragDropDelete extends MiniAppDesktopEffect {
        private final DesktopAppInfo fromMiniAppInfo;
        private final int fromPosition;
        private final int receiveViewId;
        private final int startDragViewId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBottomPartDragDropDelete(int i3, int i16, int i17, DesktopAppInfo fromMiniAppInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(fromMiniAppInfo, "fromMiniAppInfo");
            this.startDragViewId = i3;
            this.receiveViewId = i16;
            this.fromPosition = i17;
            this.fromMiniAppInfo = fromMiniAppInfo;
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartDragViewId() {
            return this.startDragViewId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getReceiveViewId() {
            return this.receiveViewId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFromPosition() {
            return this.fromPosition;
        }

        /* renamed from: component4, reason: from getter */
        public final DesktopAppInfo getFromMiniAppInfo() {
            return this.fromMiniAppInfo;
        }

        public final OnBottomPartDragDropDelete copy(int startDragViewId, int receiveViewId, int fromPosition, DesktopAppInfo fromMiniAppInfo) {
            Intrinsics.checkNotNullParameter(fromMiniAppInfo, "fromMiniAppInfo");
            return new OnBottomPartDragDropDelete(startDragViewId, receiveViewId, fromPosition, fromMiniAppInfo);
        }

        public final DesktopAppInfo getFromMiniAppInfo() {
            return this.fromMiniAppInfo;
        }

        public final int getFromPosition() {
            return this.fromPosition;
        }

        public final int getReceiveViewId() {
            return this.receiveViewId;
        }

        public final int getStartDragViewId() {
            return this.startDragViewId;
        }

        public int hashCode() {
            return (((((this.startDragViewId * 31) + this.receiveViewId) * 31) + this.fromPosition) * 31) + this.fromMiniAppInfo.hashCode();
        }

        public String toString() {
            return "OnBottomPartDragDropDelete(startDragViewId=" + this.startDragViewId + ", receiveViewId=" + this.receiveViewId + ", fromPosition=" + this.fromPosition + ", fromMiniAppInfo=" + this.fromMiniAppInfo + ")";
        }

        public static /* synthetic */ OnBottomPartDragDropDelete copy$default(OnBottomPartDragDropDelete onBottomPartDragDropDelete, int i3, int i16, int i17, DesktopAppInfo desktopAppInfo, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i3 = onBottomPartDragDropDelete.startDragViewId;
            }
            if ((i18 & 2) != 0) {
                i16 = onBottomPartDragDropDelete.receiveViewId;
            }
            if ((i18 & 4) != 0) {
                i17 = onBottomPartDragDropDelete.fromPosition;
            }
            if ((i18 & 8) != 0) {
                desktopAppInfo = onBottomPartDragDropDelete.fromMiniAppInfo;
            }
            return onBottomPartDragDropDelete.copy(i3, i16, i17, desktopAppInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnBottomPartDragDropDelete)) {
                return false;
            }
            OnBottomPartDragDropDelete onBottomPartDragDropDelete = (OnBottomPartDragDropDelete) other;
            return this.startDragViewId == onBottomPartDragDropDelete.startDragViewId && this.receiveViewId == onBottomPartDragDropDelete.receiveViewId && this.fromPosition == onBottomPartDragDropDelete.fromPosition && Intrinsics.areEqual(this.fromMiniAppInfo, onBottomPartDragDropDelete.fromMiniAppInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect$SetSubLayoutDesktopDataList;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDesktopEffect;", "desktopDataList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "type", "", "titleName", "", "(Ljava/util/List;ILjava/lang/String;)V", "getDesktopDataList", "()Ljava/util/List;", "getTitleName", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class SetSubLayoutDesktopDataList extends MiniAppDesktopEffect {
        private final List<DesktopItemInfo> desktopDataList;
        private final String titleName;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetSubLayoutDesktopDataList(List<DesktopItemInfo> desktopDataList, int i3, String titleName) {
            super(null);
            Intrinsics.checkNotNullParameter(desktopDataList, "desktopDataList");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            this.desktopDataList = desktopDataList;
            this.type = i3;
            this.titleName = titleName;
        }

        public final List<DesktopItemInfo> component1() {
            return this.desktopDataList;
        }

        /* renamed from: component2, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitleName() {
            return this.titleName;
        }

        public final SetSubLayoutDesktopDataList copy(List<DesktopItemInfo> desktopDataList, int type, String titleName) {
            Intrinsics.checkNotNullParameter(desktopDataList, "desktopDataList");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            return new SetSubLayoutDesktopDataList(desktopDataList, type, titleName);
        }

        public final List<DesktopItemInfo> getDesktopDataList() {
            return this.desktopDataList;
        }

        public final String getTitleName() {
            return this.titleName;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return (((this.desktopDataList.hashCode() * 31) + this.type) * 31) + this.titleName.hashCode();
        }

        public String toString() {
            return "SetSubLayoutDesktopDataList(desktopDataList=" + this.desktopDataList + ", type=" + this.type + ", titleName=" + this.titleName + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SetSubLayoutDesktopDataList copy$default(SetSubLayoutDesktopDataList setSubLayoutDesktopDataList, List list, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                list = setSubLayoutDesktopDataList.desktopDataList;
            }
            if ((i16 & 2) != 0) {
                i3 = setSubLayoutDesktopDataList.type;
            }
            if ((i16 & 4) != 0) {
                str = setSubLayoutDesktopDataList.titleName;
            }
            return setSubLayoutDesktopDataList.copy(list, i3, str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetSubLayoutDesktopDataList)) {
                return false;
            }
            SetSubLayoutDesktopDataList setSubLayoutDesktopDataList = (SetSubLayoutDesktopDataList) other;
            return Intrinsics.areEqual(this.desktopDataList, setSubLayoutDesktopDataList.desktopDataList) && this.type == setSubLayoutDesktopDataList.type && Intrinsics.areEqual(this.titleName, setSubLayoutDesktopDataList.titleName);
        }
    }
}
