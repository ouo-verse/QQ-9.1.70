package com.tencent.qqmini.sdk.launcher.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AllCapsTransformationMethod implements TransformationMethod2 {
    private static final String TAG = "AllCapsTransformationMethod";
    private boolean mEnabled;
    private Locale mLocale;

    public AllCapsTransformationMethod(Context context) {
        this.mLocale = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (this.mEnabled) {
            if (charSequence != null) {
                return charSequence.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
        QMLog.w(TAG, "Caller did not enable length changes; not transforming text");
        return charSequence;
    }

    @Override // com.tencent.qqmini.sdk.launcher.widget.TransformationMethod2
    public void setLengthChangesAllowed(boolean z16) {
        this.mEnabled = z16;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z16, int i3, Rect rect) {
    }
}
