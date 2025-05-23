package cooperation.qqcircle.factory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface OnHookCreateViewCallback {
    List<ParseViewAttrEntry> parseViewAttrResId(Context context, String str, AttributeSet attributeSet);

    void updateViewAttrValue(Context context, View view, String str, String str2, IQFSViewAttrParse iQFSViewAttrParse);
}
