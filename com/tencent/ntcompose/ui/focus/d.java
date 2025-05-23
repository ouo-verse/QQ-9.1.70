package com.tencent.ntcompose.ui.focus;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ntcompose/ui/focus/d;", "Lcom/tencent/ntcompose/ui/focus/c;", "", "a", "Z", "getInputFocus", "()Z", "inputFocus", "b", HippyTextInputController.COMMAND_IS_FOCUSED, "hasFocus", "<init>", "(Z)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean inputFocus;

    public d(boolean z16) {
        this.inputFocus = z16;
    }

    @Override // com.tencent.ntcompose.ui.focus.c
    public boolean a() {
        return getInputFocus();
    }

    /* renamed from: b, reason: from getter */
    public boolean getInputFocus() {
        return this.inputFocus;
    }
}
