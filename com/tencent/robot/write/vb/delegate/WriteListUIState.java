package com.tencent.robot.write.vb.delegate;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import e74.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/WriteListUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "SubmitListUIState", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public class WriteListUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/WriteListUIState$SubmitListUIState;", "Lcom/tencent/robot/write/vb/delegate/WriteListUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Le74/f;", "d", "Le74/f;", "a", "()Le74/f;", "data", "<init>", "(Le74/f;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitListUIState extends WriteListUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final f data;

        public SubmitListUIState(@Nullable f fVar) {
            this.data = fVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final f getData() {
            return this.data;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitListUIState) && Intrinsics.areEqual(this.data, ((SubmitListUIState) other).data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            f fVar = this.data;
            if (fVar == null) {
                return 0;
            }
            return fVar.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitListUIState(data=" + this.data + ")";
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
