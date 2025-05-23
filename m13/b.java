package m13;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements HippyCustomViewCreator {
    @Override // com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator
    public View createCustomView(String str, Context context, HippyMap hippyMap) {
        if (TextUtils.equals("WebView", str)) {
            return new TouchWebView(context);
        }
        return null;
    }
}
