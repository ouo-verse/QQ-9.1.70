package com.tencent.mobileqq.troop.exitoptimise.msgintent;

import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/exitoptimise/msgintent/TroopUiStateManageMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "UpdateGroupRight2Iv", "UpdateInputMode", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class TroopUiStateManageMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/exitoptimise/msgintent/TroopUiStateManageMsgIntent$UpdateGroupRight2Iv;", "Lcom/tencent/mobileqq/troop/exitoptimise/msgintent/TroopUiStateManageMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "type", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight2IvEvent;", "e", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight2IvEvent;", "a", "()Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight2IvEvent;", "event", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class UpdateGroupRight2Iv extends TroopUiStateManageMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final AIOTitleEvent.UpdateRight2IvEvent event;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AIOTitleEvent.UpdateRight2IvEvent getEvent() {
            return this.event;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGroupRight2Iv)) {
                return false;
            }
            UpdateGroupRight2Iv updateGroupRight2Iv = (UpdateGroupRight2Iv) other;
            if (this.type == updateGroupRight2Iv.type && Intrinsics.areEqual(this.event, updateGroupRight2Iv.event)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent.UpdateGroupRight2Iv";
        }

        public int hashCode() {
            return (this.type * 31) + this.event.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateGroupRight2Iv(type=" + this.type + ", event=" + this.event + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/exitoptimise/msgintent/TroopUiStateManageMsgIntent$UpdateInputMode;", "Lcom/tencent/mobileqq/troop/exitoptimise/msgintent/TroopUiStateManageMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "c", "()I", "type", "e", "Z", "b", "()Z", "inputEnable", "f", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "disableHintText", "<init>", "(IZLjava/lang/String;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class UpdateInputMode extends TroopUiStateManageMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean inputEnable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String disableHintText;

        public UpdateInputMode(int i3, boolean z16, @NotNull String disableHintText) {
            Intrinsics.checkNotNullParameter(disableHintText, "disableHintText");
            this.type = i3;
            this.inputEnable = z16;
            this.disableHintText = disableHintText;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getDisableHintText() {
            return this.disableHintText;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getInputEnable() {
            return this.inputEnable;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateInputMode)) {
                return false;
            }
            UpdateInputMode updateInputMode = (UpdateInputMode) other;
            if (this.type == updateInputMode.type && this.inputEnable == updateInputMode.inputEnable && Intrinsics.areEqual(this.disableHintText, updateInputMode.disableHintText)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent.UpdateInputMode";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.type * 31;
            boolean z16 = this.inputEnable;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return ((i3 + i16) * 31) + this.disableHintText.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateInputMode(type=" + this.type + ", inputEnable=" + this.inputEnable + ", disableHintText=" + this.disableHintText + ")";
        }
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
