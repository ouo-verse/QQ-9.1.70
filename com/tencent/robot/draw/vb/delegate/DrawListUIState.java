package com.tencent.robot.draw.vb.delegate;

import a44.a;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/draw/vb/delegate/DrawListUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "<init>", "()V", "SubmitListUIState", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class DrawListUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/draw/vb/delegate/DrawListUIState$SubmitListUIState;", "Lcom/tencent/robot/draw/vb/delegate/DrawListUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "La44/a;", "d", "La44/a;", "a", "()La44/a;", "data", "<init>", "(La44/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitListUIState extends DrawListUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final a data;

        public SubmitListUIState(@Nullable a aVar) {
            this.data = aVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final a getData() {
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
            a aVar = this.data;
            if (aVar == null) {
                return 0;
            }
            return aVar.hashCode();
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
