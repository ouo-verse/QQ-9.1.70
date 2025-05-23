package com.tencent.ttpic.videoshelf.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.widget.VideoView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoShelfView extends VideoView {
    public VideoShelfView(Context context) {
        super(getWrapperContext(context));
    }

    private static Context getWrapperContext(Context context) {
        return new ContextWrapper(context) { // from class: com.tencent.ttpic.videoshelf.ui.VideoShelfView.1
            @Override // android.content.ContextWrapper, android.content.Context
            public Object getSystemService(String str) {
                if ("audio".equals(str)) {
                    return getApplicationContext().getSystemService(str);
                }
                return super.getSystemService(str);
            }
        };
    }

    public VideoShelfView(Context context, AttributeSet attributeSet) {
        super(getWrapperContext(context), attributeSet);
    }

    public VideoShelfView(Context context, AttributeSet attributeSet, int i3) {
        super(getWrapperContext(context), attributeSet, i3);
    }

    @TargetApi(21)
    public VideoShelfView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(getWrapperContext(context), attributeSet, i3, i16);
    }
}
