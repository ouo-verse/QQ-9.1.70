package com.tencent.mm.ui.widget.edittext;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00103\u001a\u00020\u0001\u00a2\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n \n*\u0004\u0018\u00010\t0\tH\u0096\u0001J'\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J!\u0010\u0014\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n \n*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\r\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J)\u0010\u001c\u001a\n \n*\u0004\u0018\u00010\u001b0\u001b2\u000e\u0010\u0005\u001a\n \n*\u0004\u0018\u00010\u001a0\u001a2\u0006\u0010\r\u001a\u00020\u0004H\u0096\u0001J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0097\u0001J\u0019\u0010\u001f\u001a\n \n*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J)\u0010#\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n \n*\u0004\u0018\u00010\"0\"2\u000e\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0011\u0010$\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n \n*\u0004\u0018\u00010&0&H\u0096\u0001J\u0019\u0010(\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0096\u0001J!\u0010)\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n \n*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\r\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010*\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0096\u0001J\u001a\u0010-\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0016J\u001a\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0016R\u0017\u00103\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SafeProxyInputConnection;", "Landroid/view/inputmethod/InputConnection;", "", "beginBatchEdit", "", "p0", "clearMetaKeyStates", "", "closeConnection", "Landroid/view/inputmethod/CompletionInfo;", "kotlin.jvm.PlatformType", "commitCompletion", "Landroid/view/inputmethod/InputContentInfo;", "p1", "Landroid/os/Bundle;", "p2", "commitContent", "Landroid/view/inputmethod/CorrectionInfo;", "commitCorrection", "", "commitText", "deleteSurroundingText", "deleteSurroundingTextInCodePoints", "endBatchEdit", "finishComposingText", "getCursorCapsMode", "Landroid/view/inputmethod/ExtractedTextRequest;", "Landroid/view/inputmethod/ExtractedText;", "getExtractedText", "Landroid/os/Handler;", "getHandler", "getSelectedText", "performContextMenuAction", "performEditorAction", "", "performPrivateCommand", "reportFullscreenMode", "requestCursorUpdates", "Landroid/view/KeyEvent;", "sendKeyEvent", "setComposingRegion", "setComposingText", "setSelection", DomainData.DOMAIN_NAME, WadlProxyConsts.FLAGS, "getTextBeforeCursor", "getTextAfterCursor", "a", "Landroid/view/inputmethod/InputConnection;", "getIc", "()Landroid/view/inputmethod/InputConnection;", "ic", "<init>", "(Landroid/view/inputmethod/InputConnection;)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SafeProxyInputConnection implements InputConnection {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InputConnection ic;

    public SafeProxyInputConnection(@NotNull InputConnection ic5) {
        Intrinsics.checkNotNullParameter(ic5, "ic");
        this.ic = ic5;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        return this.ic.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int p06) {
        return this.ic.clearMetaKeyStates(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.ic.closeConnection();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo p06) {
        return this.ic.commitCompletion(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(@NonNull @NotNull InputContentInfo p06, int p16, @Nullable @org.jetbrains.annotations.Nullable Bundle p26) {
        boolean commitContent;
        Intrinsics.checkNotNullParameter(p06, "p0");
        commitContent = this.ic.commitContent(p06, p16, p26);
        return commitContent;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo p06) {
        return this.ic.commitCorrection(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence p06, int p16) {
        return this.ic.commitText(p06, p16);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int p06, int p16) {
        return this.ic.deleteSurroundingText(p06, p16);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int p06, int p16) {
        boolean deleteSurroundingTextInCodePoints;
        deleteSurroundingTextInCodePoints = this.ic.deleteSurroundingTextInCodePoints(p06, p16);
        return deleteSurroundingTextInCodePoints;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return this.ic.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return this.ic.finishComposingText();
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int p06) {
        return this.ic.getCursorCapsMode(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest p06, int p16) {
        return this.ic.getExtractedText(p06, p16);
    }

    @Override // android.view.inputmethod.InputConnection
    @Nullable
    @org.jetbrains.annotations.Nullable
    public Handler getHandler() {
        Handler handler;
        handler = this.ic.getHandler();
        return handler;
    }

    @NotNull
    public final InputConnection getIc() {
        return this.ic;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int p06) {
        return this.ic.getSelectedText(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    @org.jetbrains.annotations.Nullable
    public CharSequence getTextAfterCursor(int n3, int flags) {
        try {
            return this.ic.getTextAfterCursor(n3, flags);
        } catch (Throwable th5) {
            n.a("SafeProxyInputConnection", th5, "getTextAfterCursor err", new Object[0]);
            return "";
        }
    }

    @Override // android.view.inputmethod.InputConnection
    @org.jetbrains.annotations.Nullable
    public CharSequence getTextBeforeCursor(int n3, int flags) {
        try {
            return this.ic.getTextBeforeCursor(n3, flags);
        } catch (Throwable th5) {
            n.a("SafeProxyInputConnection", th5, "getTextBeforeCursor err", new Object[0]);
            return "";
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int p06) {
        return this.ic.performContextMenuAction(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int p06) {
        return this.ic.performEditorAction(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String p06, Bundle p16) {
        return this.ic.performPrivateCommand(p06, p16);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean p06) {
        return this.ic.reportFullscreenMode(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int p06) {
        return this.ic.requestCursorUpdates(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent p06) {
        return this.ic.sendKeyEvent(p06);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int p06, int p16) {
        return this.ic.setComposingRegion(p06, p16);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence p06, int p16) {
        return this.ic.setComposingText(p06, p16);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int p06, int p16) {
        return this.ic.setSelection(p06, p16);
    }
}
