package com.tencent.hippy.qq.view.viola.list;

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
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListViewController;

/* compiled from: P */
@HippyController(name = TkdListViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class TkdListViewController extends HippyListViewController {
    public static final String CLASS_NAME = "tkdListView";
    private static final String SCROLL_TO_POSITION = "scrollToPosition";

    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new TkdListView(context);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "preloadDistance")
    public void setPreloadDistance(HippyListView hippyListView, int i3) {
        if (hippyListView instanceof TkdListView) {
            ((TkdListView) hippyListView).setPreloadDistance(i3);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "scrollMinOffset")
    public void setScrollMinOffset(HippyListView hippyListView, int i3) {
        if (hippyListView instanceof TkdListView) {
            ((TkdListView) hippyListView).setScrollMinOffset(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public View createViewImpl(Context context, HippyMap hippyMap) {
        return new TkdListView(context, (hippyMap == null || !((hippyMap.containsKey("direction") && hippyMap.getString("direction").equals("horizontal")) || hippyMap.containsKey("horizontal"))) ? 1 : 0);
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyListView hippyListView, String str, HippyArray hippyArray) {
        super.dispatchFunction(hippyListView, str, hippyArray);
        if (!TextUtils.isEmpty(str) && (hippyListView instanceof TkdListView) && str.equals("loadMoreFinish")) {
            ((TkdListView) hippyListView).setIsLoading(false);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyListView hippyListView, String str, HippyArray hippyArray, Promise promise) {
        String str2;
        int i3;
        super.dispatchFunction((TkdListViewController) hippyListView, str, hippyArray, promise);
        if ((hippyListView instanceof TkdListView) && TextUtils.equals(SCROLL_TO_POSITION, str)) {
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
                ((TkdListView) hippyListView).scrollWithDistance(i16, i3, promise);
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
