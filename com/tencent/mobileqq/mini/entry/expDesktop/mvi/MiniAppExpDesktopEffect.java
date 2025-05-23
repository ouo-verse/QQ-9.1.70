package com.tencent.mobileqq.mini.entry.expDesktop.mvi;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "", "()V", "DesktopOpenChanged", "OnBottomPartDragDropAdd", "OnBottomPartDragDropDelete", "OnBottomPartDragDropExtra", "OnDragEntered", "OuterRvPartOnPause", "OuterRvPartOnResume", "OuterRvPartOnScrollStateChanged", "SetMiniAppNotificationData", "SetSubLayoutDesktopDataList", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$DesktopOpenChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnBottomPartDragDropAdd;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnBottomPartDragDropDelete;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnBottomPartDragDropExtra;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnDragEntered;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OuterRvPartOnPause;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OuterRvPartOnResume;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OuterRvPartOnScrollStateChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$SetMiniAppNotificationData;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$SetSubLayoutDesktopDataList;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class MiniAppExpDesktopEffect {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$DesktopOpenChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "isDesktopOpen", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class DesktopOpenChanged extends MiniAppExpDesktopEffect {
        private final boolean isDesktopOpen;

        /* renamed from: component1, reason: from getter */
        public final boolean getIsDesktopOpen() {
            return this.isDesktopOpen;
        }

        public final DesktopOpenChanged copy(boolean isDesktopOpen) {
            return new DesktopOpenChanged(isDesktopOpen);
        }

        public int hashCode() {
            boolean z16 = this.isDesktopOpen;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public final boolean isDesktopOpen() {
            return this.isDesktopOpen;
        }

        public String toString() {
            return "DesktopOpenChanged(isDesktopOpen=" + this.isDesktopOpen + ")";
        }

        public DesktopOpenChanged(boolean z16) {
            super(null);
            this.isDesktopOpen = z16;
        }

        public static /* synthetic */ DesktopOpenChanged copy$default(DesktopOpenChanged desktopOpenChanged, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = desktopOpenChanged.isDesktopOpen;
            }
            return desktopOpenChanged.copy(z16);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DesktopOpenChanged) && this.isDesktopOpen == ((DesktopOpenChanged) other).isDesktopOpen;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnDragEntered;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "startDragViewId", "", "receiveViewId", "(II)V", "getReceiveViewId", "()I", "getStartDragViewId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnDragEntered extends MiniAppExpDesktopEffect {
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OuterRvPartOnPause;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "state", "", "(I)V", "getState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OuterRvPartOnPause extends MiniAppExpDesktopEffect {
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OuterRvPartOnResume;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "state", "", "(I)V", "getState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OuterRvPartOnResume extends MiniAppExpDesktopEffect {
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OuterRvPartOnScrollStateChanged;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "newState", "", "(I)V", "getNewState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OuterRvPartOnScrollStateChanged extends MiniAppExpDesktopEffect {
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

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\rH\u00c6\u0003JU\u0010\u001e\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001J\t\u0010#\u001a\u00020\tH\u00d6\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$SetSubLayoutDesktopDataList;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "desktopDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "moduleType", "", "titleName", "", "via", "hostScene", "isFinished", "", "(Ljava/util/ArrayList;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDesktopDataList", "()Ljava/util/ArrayList;", "getHostScene", "()Ljava/lang/String;", "()Z", "getModuleType", "()I", "getTitleName", "getVia", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class SetSubLayoutDesktopDataList extends MiniAppExpDesktopEffect {
        private final ArrayList<DesktopAppInfo> desktopDataList;
        private final String hostScene;
        private final boolean isFinished;
        private final int moduleType;
        private final String titleName;
        private final String via;

        public /* synthetic */ SetSubLayoutDesktopDataList(ArrayList arrayList, int i3, String str, String str2, String str3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(arrayList, i3, str, str2, str3, (i16 & 32) != 0 ? false : z16);
        }

        public final ArrayList<DesktopAppInfo> component1() {
            return this.desktopDataList;
        }

        /* renamed from: component2, reason: from getter */
        public final int getModuleType() {
            return this.moduleType;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitleName() {
            return this.titleName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getVia() {
            return this.via;
        }

        /* renamed from: component5, reason: from getter */
        public final String getHostScene() {
            return this.hostScene;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsFinished() {
            return this.isFinished;
        }

        public final SetSubLayoutDesktopDataList copy(ArrayList<DesktopAppInfo> desktopDataList, int moduleType, String titleName, String via, String hostScene, boolean isFinished) {
            Intrinsics.checkNotNullParameter(desktopDataList, "desktopDataList");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            Intrinsics.checkNotNullParameter(via, "via");
            Intrinsics.checkNotNullParameter(hostScene, "hostScene");
            return new SetSubLayoutDesktopDataList(desktopDataList, moduleType, titleName, via, hostScene, isFinished);
        }

        public final ArrayList<DesktopAppInfo> getDesktopDataList() {
            return this.desktopDataList;
        }

        public final String getHostScene() {
            return this.hostScene;
        }

        public final int getModuleType() {
            return this.moduleType;
        }

        public final String getTitleName() {
            return this.titleName;
        }

        public final String getVia() {
            return this.via;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((this.desktopDataList.hashCode() * 31) + this.moduleType) * 31) + this.titleName.hashCode()) * 31) + this.via.hashCode()) * 31) + this.hostScene.hashCode()) * 31;
            boolean z16 = this.isFinished;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public String toString() {
            return "SetSubLayoutDesktopDataList(desktopDataList=" + this.desktopDataList + ", moduleType=" + this.moduleType + ", titleName=" + this.titleName + ", via=" + this.via + ", hostScene=" + this.hostScene + ", isFinished=" + this.isFinished + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetSubLayoutDesktopDataList(ArrayList<DesktopAppInfo> desktopDataList, int i3, String titleName, String via, String hostScene, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(desktopDataList, "desktopDataList");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            Intrinsics.checkNotNullParameter(via, "via");
            Intrinsics.checkNotNullParameter(hostScene, "hostScene");
            this.desktopDataList = desktopDataList;
            this.moduleType = i3;
            this.titleName = titleName;
            this.via = via;
            this.hostScene = hostScene;
            this.isFinished = z16;
        }

        public static /* synthetic */ SetSubLayoutDesktopDataList copy$default(SetSubLayoutDesktopDataList setSubLayoutDesktopDataList, ArrayList arrayList, int i3, String str, String str2, String str3, boolean z16, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                arrayList = setSubLayoutDesktopDataList.desktopDataList;
            }
            if ((i16 & 2) != 0) {
                i3 = setSubLayoutDesktopDataList.moduleType;
            }
            int i17 = i3;
            if ((i16 & 4) != 0) {
                str = setSubLayoutDesktopDataList.titleName;
            }
            String str4 = str;
            if ((i16 & 8) != 0) {
                str2 = setSubLayoutDesktopDataList.via;
            }
            String str5 = str2;
            if ((i16 & 16) != 0) {
                str3 = setSubLayoutDesktopDataList.hostScene;
            }
            String str6 = str3;
            if ((i16 & 32) != 0) {
                z16 = setSubLayoutDesktopDataList.isFinished;
            }
            return setSubLayoutDesktopDataList.copy(arrayList, i17, str4, str5, str6, z16);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetSubLayoutDesktopDataList)) {
                return false;
            }
            SetSubLayoutDesktopDataList setSubLayoutDesktopDataList = (SetSubLayoutDesktopDataList) other;
            return Intrinsics.areEqual(this.desktopDataList, setSubLayoutDesktopDataList.desktopDataList) && this.moduleType == setSubLayoutDesktopDataList.moduleType && Intrinsics.areEqual(this.titleName, setSubLayoutDesktopDataList.titleName) && Intrinsics.areEqual(this.via, setSubLayoutDesktopDataList.via) && Intrinsics.areEqual(this.hostScene, setSubLayoutDesktopDataList.hostScene) && this.isFinished == setSubLayoutDesktopDataList.isFinished;
        }
    }

    public /* synthetic */ MiniAppExpDesktopEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    MiniAppExpDesktopEffect() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnBottomPartDragDropAdd;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "fromMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;)V", "getFromMiniAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnBottomPartDragDropAdd extends MiniAppExpDesktopEffect {
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
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnBottomPartDragDropDelete;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "startDragViewId", "", "receiveViewId", "fromPosition", "fromMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(IIILcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;)V", "getFromMiniAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getFromPosition", "()I", "getReceiveViewId", "getStartDragViewId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnBottomPartDragDropDelete extends MiniAppExpDesktopEffect {
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
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$OnBottomPartDragDropExtra;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "startDragViewId", "", "receiveViewId", "fromPosition", "fromMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "(IIILcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;)V", "getFromMiniAppInfo", "()Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "getFromPosition", "()I", "getReceiveViewId", "getStartDragViewId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnBottomPartDragDropExtra extends MiniAppExpDesktopEffect {
        private final DesktopAppInfo fromMiniAppInfo;
        private final int fromPosition;
        private final int receiveViewId;
        private final int startDragViewId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBottomPartDragDropExtra(int i3, int i16, int i17, DesktopAppInfo fromMiniAppInfo) {
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

        public final OnBottomPartDragDropExtra copy(int startDragViewId, int receiveViewId, int fromPosition, DesktopAppInfo fromMiniAppInfo) {
            Intrinsics.checkNotNullParameter(fromMiniAppInfo, "fromMiniAppInfo");
            return new OnBottomPartDragDropExtra(startDragViewId, receiveViewId, fromPosition, fromMiniAppInfo);
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
            return "OnBottomPartDragDropExtra(startDragViewId=" + this.startDragViewId + ", receiveViewId=" + this.receiveViewId + ", fromPosition=" + this.fromPosition + ", fromMiniAppInfo=" + this.fromMiniAppInfo + ")";
        }

        public static /* synthetic */ OnBottomPartDragDropExtra copy$default(OnBottomPartDragDropExtra onBottomPartDragDropExtra, int i3, int i16, int i17, DesktopAppInfo desktopAppInfo, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i3 = onBottomPartDragDropExtra.startDragViewId;
            }
            if ((i18 & 2) != 0) {
                i16 = onBottomPartDragDropExtra.receiveViewId;
            }
            if ((i18 & 4) != 0) {
                i17 = onBottomPartDragDropExtra.fromPosition;
            }
            if ((i18 & 8) != 0) {
                desktopAppInfo = onBottomPartDragDropExtra.fromMiniAppInfo;
            }
            return onBottomPartDragDropExtra.copy(i3, i16, i17, desktopAppInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnBottomPartDragDropExtra)) {
                return false;
            }
            OnBottomPartDragDropExtra onBottomPartDragDropExtra = (OnBottomPartDragDropExtra) other;
            return this.startDragViewId == onBottomPartDragDropExtra.startDragViewId && this.receiveViewId == onBottomPartDragDropExtra.receiveViewId && this.fromPosition == onBottomPartDragDropExtra.fromPosition && Intrinsics.areEqual(this.fromMiniAppInfo, onBottomPartDragDropExtra.fromMiniAppInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect$SetMiniAppNotificationData;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopEffect;", "titleName", "", "(Ljava/lang/String;)V", "getTitleName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class SetMiniAppNotificationData extends MiniAppExpDesktopEffect {
        private final String titleName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetMiniAppNotificationData(String titleName) {
            super(null);
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            this.titleName = titleName;
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitleName() {
            return this.titleName;
        }

        public final SetMiniAppNotificationData copy(String titleName) {
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            return new SetMiniAppNotificationData(titleName);
        }

        public final String getTitleName() {
            return this.titleName;
        }

        public int hashCode() {
            return this.titleName.hashCode();
        }

        public String toString() {
            return "SetMiniAppNotificationData(titleName=" + this.titleName + ")";
        }

        public static /* synthetic */ SetMiniAppNotificationData copy$default(SetMiniAppNotificationData setMiniAppNotificationData, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = setMiniAppNotificationData.titleName;
            }
            return setMiniAppNotificationData.copy(str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SetMiniAppNotificationData) && Intrinsics.areEqual(this.titleName, ((SetMiniAppNotificationData) other).titleName);
        }
    }
}
