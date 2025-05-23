package com.tencent.hippy.qq.view.viola.scroll;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewController;

/* compiled from: P */
@HippyController(name = TkdScrollViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class TkdScrollViewController extends HippyScrollViewController {
    public static final String CLASS_NAME = "tkdScrollView";
    private static final String LOAD_MORE_FINISH = "loadMoreFinish";
    private static final String SCROLL_TO_POSITION = "scrollToPosition";
    private static final String SCROLL_TO_TOP = "scrollToTop";

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(View view, String str, HippyArray hippyArray) {
        super.dispatchFunction(view, str, hippyArray);
        if (view instanceof TkdScrollView) {
            if (TextUtils.equals("scrollTo", str)) {
                int round = Math.round(PixelUtil.dp2px(hippyArray.getDouble(0)));
                int round2 = Math.round(PixelUtil.dp2px(hippyArray.getDouble(1)));
                if (hippyArray.getBoolean(2)) {
                    ((TkdScrollView) view).callSmoothScrollTo(round, round2, 0);
                    return;
                } else {
                    view.scrollTo(round, round2);
                    return;
                }
            }
            if (TextUtils.equals(LOAD_MORE_FINISH, str)) {
                ((TkdScrollView) view).callLoadMoreFinish();
            } else if (TextUtils.equals("scrollToTop", str)) {
                ((TkdScrollView) view).callScrollToTop(hippyArray.getBoolean(0));
            }
        }
    }

    @HippyControllerProps(defaultNumber = 200.0d, defaultType = "number", name = "preloadDistance")
    public void setPreloadDistance(TkdScrollView tkdScrollView, int i3) {
        tkdScrollView.setPreloadDistance(i3);
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        if (hippyMap != null && hippyMap.containsKey("horizontal")) {
            return new TkdHorizontalScrollView(context);
        }
        return new TkdVerticalScrollView(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(View view, String str, HippyArray hippyArray, Promise promise) {
        String str2;
        int i3;
        super.dispatchFunction(view, str, hippyArray, promise);
        if ((view instanceof TkdScrollView) && TextUtils.equals(SCROLL_TO_POSITION, str)) {
            int i16 = 0;
            if (hippyArray == null || hippyArray.size() <= 0) {
                str2 = "invalid parameter!";
                i3 = 0;
            } else {
                HippyMap map = hippyArray.getMap(0);
                if (map != null) {
                    i16 = (int) PixelUtil.dp2px(map.getInt(Element.ELEMENT_NAME_DISTANCE));
                    i3 = map.getInt("duration");
                } else {
                    i3 = 0;
                }
                str2 = "";
            }
            if (i16 != 0) {
                ((TkdScrollView) view).callScrollToPosition(i16, i3, promise);
            } else {
                str2 = "invalid distance parameter!";
            }
            if (TextUtils.isEmpty(str2) || promise == null) {
                return;
            }
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("msg", str2);
            promise.resolve(hippyMap);
        }
    }
}
