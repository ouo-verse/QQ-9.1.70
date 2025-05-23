package com.tencent.mobileqq.together.clockin;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@AutoEventName
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/together/clockin/ClockMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ShowTroopClockDialogMsgIntent", "Lcom/tencent/mobileqq/together/clockin/ClockMsgIntent$ShowTroopClockDialogMsgIntent;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public abstract class ClockMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/together/clockin/ClockMsgIntent$ShowTroopClockDialogMsgIntent;", "Lcom/tencent/mobileqq/together/clockin/ClockMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "sourceType", "<init>", "(I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final /* data */ class ShowTroopClockDialogMsgIntent extends ClockMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int sourceType;

        public ShowTroopClockDialogMsgIntent(int i3) {
            super(null);
            this.sourceType = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getSourceType() {
            return this.sourceType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowTroopClockDialogMsgIntent) && this.sourceType == ((ShowTroopClockDialogMsgIntent) other).sourceType) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.together.clockin.ClockMsgIntent.ShowTroopClockDialogMsgIntent";
        }

        public int hashCode() {
            return this.sourceType;
        }

        @NotNull
        public String toString() {
            return "ShowTroopClockDialogMsgIntent(sourceType=" + this.sourceType + ")";
        }
    }

    public /* synthetic */ ClockMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    ClockMsgIntent() {
    }
}
