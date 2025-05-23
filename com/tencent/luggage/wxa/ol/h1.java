package com.tencent.luggage.wxa.ol;

import android.widget.TextView;
import com.tencent.mm.ui.widget.edittext.CursorHandle;
import com.tencent.mm.ui.widget.edittext.OperateWindow;
import com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h1 extends SelectableEditTextHelper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(TextView textView) {
        super(new SelectableEditTextHelper.Builder(textView));
        Intrinsics.checkNotNullParameter(textView, "textView");
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void a(int i3, int i16, boolean z16) {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    /* renamed from: c */
    public Runnable getShowSelectViewTask() {
        Runnable runnable;
        runnable = i1.f136786a;
        return runnable;
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void a(CursorHandle cursorHandle) {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void closeSelectAndTools() {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void hideSelectView() {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void resetSelectionInfo() {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void dismissOperWindow(OperateWindow operateWindow) {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void showCursorHandle(CursorHandle cursorHandle) {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void showOperWindow(OperateWindow operateWindow) {
    }

    @Override // com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
    public void selectText(int i3, int i16) {
    }
}
