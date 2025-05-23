package n13;

import com.tencent.mtt.hippy.common.HippyMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface c {
    boolean isNeedIntercept(HippyMap hippyMap);

    void onCallError(String str);

    void onCallJs(Object obj);

    Object onCreateFakeWebView(Object obj);

    Object onCreateWebViewPlugin(String str);

    String[] onGetDispatchArgsNameList(String str);

    String onGetDispatchMethodName(String str);

    Object onGetInvokeArgs(int i3, Class<?> cls, @NotNull Object obj, String str);

    String onGetJsbMethod(HippyMap hippyMap);

    String onGetJsbNameSpace(HippyMap hippyMap);

    Object onGetShareHelper();

    String onGetWebViewUrl();

    void onSetWebViewInternal(Object obj, Object obj2);

    void onUpdateActivity(Object obj);
}
