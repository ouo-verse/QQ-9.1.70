package com.tencent.hippy.qq.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.hippy.qq.api.IHippyInnerApi;
import com.tencent.hippy.qq.view.gridview.HippyQQDragGridView;
import com.tencent.hippy.qq.view.gridview.HippyQQDragGridViewController;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.hippy.qq.view.recycleview.HippyQQRecyclerView;
import com.tencent.hippy.qq.view.text.HippyQQJustifyTextView;
import com.tencent.hippy.qq.view.text.HippyQQJustifyTextViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.api.IVasHippyApi;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;
import com.tencent.mtt.hippy.views.image.HippyImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQViewCreator implements HippyCustomViewCreator {
    private HippyCustomViewCreator boodoCreator;
    private String currentModuleName;
    private HippyCustomViewCreator qqshopCreator;
    private HippyCustomViewCreator vasCreator;

    public HippyQQViewCreator(String str) {
        this.currentModuleName = str;
        IQQComicHippyUtil iQQComicHippyUtil = (IQQComicHippyUtil) QRoute.api(IQQComicHippyUtil.class);
        if (iQQComicHippyUtil.isBoodoModule(this.currentModuleName)) {
            this.boodoCreator = iQQComicHippyUtil.createHippyCustomViewCreator();
        }
        IVasHippyApi iVasHippyApi = (IVasHippyApi) QRoute.api(IVasHippyApi.class);
        if (iVasHippyApi.isVasModuleNeedToBeAdd(this.currentModuleName)) {
            this.vasCreator = iVasHippyApi.createHippyCustomViewCreator();
        }
    }

    private View createDefaultCustomView(String str, Context context, HippyMap hippyMap) {
        if (TextUtils.equals("ListView", str)) {
            return new HippyRecyclerViewWrapper(context, HippyRecyclerViewController.initDefault(context, hippyMap, new HippyQQRecyclerView(context)));
        }
        if (TextUtils.equals("Image", str)) {
            HippyImageView hippyQQImageView = ((IHippyInnerApi) QRoute.api(IHippyInnerApi.class)).getHippyQQImageView(context);
            if (hippyMap != null) {
                hippyQQImageView.setInitProps(hippyMap);
            }
            return hippyQQImageView;
        }
        if (TextUtils.equals(HippyQQPagViewController.CLASS_NAME, str)) {
            return new HippyQQPagView(context);
        }
        if (TextUtils.equals(HippyQQDragGridViewController.CLASS_NAME, str)) {
            return new HippyRecyclerViewWrapper(context, HippyQQDragGridViewController.initGridView(context, hippyMap, new HippyQQDragGridView(context)));
        }
        if (TextUtils.equals(HippyQQJustifyTextViewController.CLASS_NAME, str)) {
            return new HippyQQJustifyTextView(context);
        }
        return null;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator
    public View createCustomView(String str, Context context, HippyMap hippyMap) {
        View createCustomView;
        View createCustomView2;
        View createCustomView3;
        HippyCustomViewCreator hippyCustomViewCreator = this.boodoCreator;
        if (hippyCustomViewCreator != null && (createCustomView3 = hippyCustomViewCreator.createCustomView(str, context, hippyMap)) != null) {
            return createCustomView3;
        }
        HippyCustomViewCreator hippyCustomViewCreator2 = this.qqshopCreator;
        if (hippyCustomViewCreator2 != null && (createCustomView2 = hippyCustomViewCreator2.createCustomView(str, context, hippyMap)) != null) {
            return createCustomView2;
        }
        HippyCustomViewCreator hippyCustomViewCreator3 = this.vasCreator;
        if (hippyCustomViewCreator3 != null && (createCustomView = hippyCustomViewCreator3.createCustomView(str, context, hippyMap)) != null) {
            return createCustomView;
        }
        return createDefaultCustomView(str, context, hippyMap);
    }
}
