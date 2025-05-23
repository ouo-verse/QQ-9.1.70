package com.tencent.mtt.hippy.views.text;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.TextExtra;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.dom.node.f;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = "Text")
/* loaded from: classes20.dex */
public class HippyTextViewController extends HippyViewController<HippyTextView> {
    public static final String CLASS_NAME = "Text";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public StyleNode createNode(boolean z16) {
        return new TextNode(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyTextView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public boolean handleGestureBySelf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void updateExtra(View view, Object obj) {
        TextExtra textExtra = (TextExtra) obj;
        if (textExtra != null) {
            Object obj2 = textExtra.mExtra;
            if ((obj2 instanceof Layout) && (view instanceof HippyTextView)) {
                HippyTextView hippyTextView = (HippyTextView) view;
                Layout layout = (Layout) obj2;
                CharSequence text = layout.getText();
                if (text instanceof Spannable) {
                    Spannable spannable = (Spannable) text;
                    boolean z16 = false;
                    f[] fVarArr = (f[]) spannable.getSpans(0, spannable.length(), f.class);
                    if (fVarArr != null && fVarArr.length > 0) {
                        z16 = true;
                    }
                    hippyTextView.setNativeGestureEnable(z16);
                }
                hippyTextView.setPadding((int) Math.floor(textExtra.mLeftPadding), (int) Math.floor(textExtra.mTopPadding), (int) Math.floor(textExtra.mRightPadding), (int) Math.floor(textExtra.mBottomPadding));
                hippyTextView.setLayout(layout);
                hippyTextView.postInvalidate();
            }
        }
    }
}
