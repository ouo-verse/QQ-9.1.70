package com.tencent.mobileqq.guild.mainframe.centerpanel;

import android.view.MotionEvent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rr1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "BusiInterceptMoveEvent", "ChildConsumeTouchEvent", "NotifyEvent", "a", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$BusiInterceptMoveEvent;", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$ChildConsumeTouchEvent;", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$NotifyEvent;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class MFGestureListIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$BusiInterceptMoveEvent;", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "getFoldStatus", "()I", "foldStatus", "e", "getCurMoveDirection", "setCurMoveDirection", "(I)V", "curMoveDirection", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;", "f", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;", "getRet", "()Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;", "setRet", "(Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;)V", "ret", "<init>", "(IILcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class BusiInterceptMoveEvent extends MFGestureListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int foldStatus;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int curMoveDirection;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private RetBoolean ret;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusiInterceptMoveEvent(int i3, int i16, @NotNull RetBoolean ret) {
            super(null);
            Intrinsics.checkNotNullParameter(ret, "ret");
            this.foldStatus = i3;
            this.curMoveDirection = i16;
            this.ret = ret;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BusiInterceptMoveEvent)) {
                return false;
            }
            BusiInterceptMoveEvent busiInterceptMoveEvent = (BusiInterceptMoveEvent) other;
            if (this.foldStatus == busiInterceptMoveEvent.foldStatus && this.curMoveDirection == busiInterceptMoveEvent.curMoveDirection && Intrinsics.areEqual(this.ret, busiInterceptMoveEvent.ret)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.foldStatus * 31) + this.curMoveDirection) * 31) + this.ret.hashCode();
        }

        @NotNull
        public String toString() {
            return "BusiInterceptMoveEvent(foldStatus=" + this.foldStatus + ", curMoveDirection=" + this.curMoveDirection + ", ret=" + this.ret + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$ChildConsumeTouchEvent;", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/MotionEvent;", "d", "Landroid/view/MotionEvent;", "getEvent", "()Landroid/view/MotionEvent;", "event", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;", "e", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;", "getRet", "()Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;", "setRet", "(Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;)V", "ret", "<init>", "(Landroid/view/MotionEvent;Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class ChildConsumeTouchEvent extends MFGestureListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MotionEvent event;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private RetBoolean ret;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildConsumeTouchEvent(@NotNull MotionEvent event, @NotNull RetBoolean ret) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(ret, "ret");
            this.event = event;
            this.ret = ret;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChildConsumeTouchEvent)) {
                return false;
            }
            ChildConsumeTouchEvent childConsumeTouchEvent = (ChildConsumeTouchEvent) other;
            if (Intrinsics.areEqual(this.event, childConsumeTouchEvent.event) && Intrinsics.areEqual(this.ret, childConsumeTouchEvent.ret)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.event.hashCode() * 31) + this.ret.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChildConsumeTouchEvent(event=" + this.event + ", ret=" + this.ret + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$NotifyEvent;", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lrr1/i;", "d", "Lrr1/i;", "a", "()Lrr1/i;", "notifyData", "<init>", "(Lrr1/i;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class NotifyEvent extends MFGestureListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final i notifyData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotifyEvent(@NotNull i notifyData) {
            super(null);
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            this.notifyData = notifyData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final i getNotifyData() {
            return this.notifyData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NotifyEvent) && Intrinsics.areEqual(this.notifyData, ((NotifyEvent) other).notifyData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.notifyData.hashCode();
        }

        @NotNull
        public String toString() {
            return "NotifyEvent(notifyData=" + this.notifyData + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "setRet", "(Z)V", "ret", "<init>", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class RetBoolean {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean ret;

        public RetBoolean() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getRet() {
            return this.ret;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RetBoolean) && this.ret == ((RetBoolean) other).ret) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.ret;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "RetBoolean(ret=" + this.ret + ')';
        }

        public RetBoolean(boolean z16) {
            this.ret = z16;
        }

        public /* synthetic */ RetBoolean(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    public /* synthetic */ MFGestureListIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    MFGestureListIntent() {
    }
}
