package com.tencent.robot.slash.dialog.content.list.vbdelegate;

import com.tencent.robot.widget.list.vb.CommonListUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/SlashListUIState;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "()V", "DisplayModeState", "Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/SlashListUIState$DisplayModeState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class SlashListUIState extends CommonListUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/SlashListUIState$DisplayModeState;", "Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/SlashListUIState;", "", "d", "I", "a", "()I", "mode", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class DisplayModeState extends SlashListUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int mode;

        public DisplayModeState(int i3) {
            super(null);
            this.mode = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getMode() {
            return this.mode;
        }
    }

    public /* synthetic */ SlashListUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    SlashListUIState() {
    }
}
