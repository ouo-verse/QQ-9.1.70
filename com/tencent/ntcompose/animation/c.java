package com.tencent.ntcompose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00008V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0004\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/animation/c;", "T", "Landroidx/compose/runtime/State;", "a", "()Ljava/lang/Object;", "Landroidx/compose/runtime/MutableState;", "d", "Landroidx/compose/runtime/MutableState;", "getStateValue$ntcompose_release", "()Landroidx/compose/runtime/MutableState;", "stateValue", "value", HippyTextInputController.COMMAND_getValue, HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;)V", "initialValue", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c<T> implements State<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MutableState<T> stateValue;

    public c(T t16) {
        MutableState<T> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
        this.stateValue = mutableStateOf$default;
    }

    public final T a() {
        return this.stateValue.getValue();
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        ComposeAnimationManager.f339152a.j();
        return this.stateValue.getValue();
    }

    public void setValue(T t16) {
        this.stateValue.setValue(t16);
    }
}
