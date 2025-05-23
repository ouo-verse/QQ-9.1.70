package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.base.log.CGLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CgTextEditor extends EditText {
    static InputMethodCb mCb;
    CgInputConnection cgInputConnection;
    SpannableStringBuilder mText;

    public CgTextEditor(Context context) {
        this(context, null, 0);
    }

    private void init() {
        setFocusableInTouchMode(true);
        this.mText = new SpannableStringBuilder();
        setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.CgTextEditor.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                CGLog.i("action=" + keyEvent.getAction() + "keycode=" + i3);
                if (keyEvent.getAction() == 0) {
                    if (keyEvent.getUnicodeChar() == 0) {
                        if (i3 == 67) {
                            InputMethodCb inputMethodCb = CgTextEditor.mCb;
                            if (inputMethodCb != null) {
                                inputMethodCb.sendBackSpaceCb();
                            }
                            Log.i("TAG", "text:" + ((Object) CgTextEditor.this.mText) + " (keycode)");
                            return true;
                        }
                        return false;
                    }
                    Log.i("TAG", "text:" + ((Object) CgTextEditor.this.mText) + " (keycode)");
                    return true;
                }
                return false;
            }
        });
    }

    public static void setCb(InputMethodCb inputMethodCb) {
        mCb = inputMethodCb;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.inputType = 1;
        editorInfo.imeOptions = 268435462;
        CgInputConnection cgInputConnection = new CgInputConnection(this, true);
        this.cgInputConnection = cgInputConnection;
        return cgInputConnection;
    }

    public CgTextEditor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CgTextEditor(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
