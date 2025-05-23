package com.tencent.mobileqq.wink.magicstudio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MagicStudioActionDoneEditText extends EditText {
    public MagicStudioActionDoneEditText(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        int i3 = editorInfo.imeOptions;
        int i16 = i3 & 255;
        if ((i16 & 6) != 0) {
            editorInfo.imeOptions = (i3 ^ i16) | 6;
        }
        int i17 = editorInfo.imeOptions;
        if ((1073741824 & i17) != 0) {
            editorInfo.imeOptions = i17 & (-1073741825);
        }
        return onCreateInputConnection;
    }

    public MagicStudioActionDoneEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
