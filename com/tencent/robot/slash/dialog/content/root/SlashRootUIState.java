package com.tencent.robot.slash.dialog.content.root;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "OnDisplayModeUpdated", "Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState$OnDisplayModeUpdated;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class SlashRootUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState$OnDisplayModeUpdated;", "Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState;", "", "d", "I", "a", "()I", "newMode", "e", "getOldMode", "oldMode", "<init>", "(II)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class OnDisplayModeUpdated extends SlashRootUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int newMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int oldMode;

        public OnDisplayModeUpdated(int i3, int i16) {
            super(null);
            this.newMode = i3;
            this.oldMode = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getNewMode() {
            return this.newMode;
        }
    }

    public /* synthetic */ SlashRootUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    SlashRootUIState() {
    }
}
