package com.tencent.gamematrix.gmcg.webrtc;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import com.tencent.gamematrix.gmcg.base.log.CGLog;

/* compiled from: P */
/* loaded from: classes6.dex */
class CgInputConnection extends BaseInputConnection {
    private static InputMethodCb mCb;
    private SpannableStringBuilder _editable;
    private SpannableStringBuilder mEditable;

    public CgInputConnection(View view, boolean z16) {
        super(view, z16);
    }

    public static void setCb(InputMethodCb inputMethodCb) {
        mCb = inputMethodCb;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        CGLog.i("commitText: " + ((Object) charSequence));
        InputMethodCb inputMethodCb = mCb;
        if (inputMethodCb != null) {
            inputMethodCb.sendInputTextCb(charSequence.toString());
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i16) {
        CGLog.d("deleteSurroundingText: i=" + i3 + ", j=" + i16);
        if (mCb != null) {
            for (int i17 = 0; i17 < Math.abs(i3 + i16); i17++) {
                mCb.sendBackSpaceCb();
            }
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i3) {
        InputMethodCb inputMethodCb = mCb;
        if (inputMethodCb != null) {
            inputMethodCb.sendCloseCb();
            return true;
        }
        return true;
    }
}
