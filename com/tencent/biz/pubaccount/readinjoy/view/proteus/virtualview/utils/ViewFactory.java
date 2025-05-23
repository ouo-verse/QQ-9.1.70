package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeRelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.BoringView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.NativeImage;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ViewFactory {
    private static final String TAG = "ViewFactory";
    private HashMap<String, ViewBase.IBuilder> mBuilders = new HashMap<>();
    private static final ViewBase.IBuilder NORMAL_BUILDER = new BoringView.Builder();
    private static boolean isShowViewIdInDesc = false;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface FoundClickableViewListener {
        void onFound(ViewBase viewBase);
    }

    public ViewFactory() {
        registerViewBuilder(ParseCommon.LINEAR_LAYOUT, new LinearLayout.Builder());
        registerViewBuilder(ParseCommon.UILABEL, new NativeText.Builder());
        registerViewBuilder(ParseCommon.READINJOY_ASYN_IMAGEVIEW, new NativeImage.Builder());
        registerViewBuilder(ParseCommon.UI_IMAGE_VIEW, new NativeImage.Builder());
        registerViewBuilder(ParseCommon.READINJOY_ASYN_IMAGE_ICON, new NativeImage.Builder());
        registerViewBuilder(ParseCommon.UIVIEW, new BoringView.Builder());
        registerViewBuilder(ParseCommon.RELATIVE_LAYOUT, new RelativeLayout.Builder());
        registerViewBuilder(ParseCommon.UI_BUTTON_VIEW, new NativeButton.Builder());
        registerViewBuilder(ParseCommon.UI_NATIVE_LINEARLAYOUT, new NativeLinearLayout.Builder());
        registerViewBuilder(ParseCommon.UI_NATIVE_RELATIVELAYOUT, new NativeRelativeLayout.Builder());
        registerViewBuilder(ParseCommon.UI_RICH_TEXT_VIEW, new RichNativeText.Builder());
    }

    private ViewBase createView(VafContext vafContext, String str) {
        ViewBase.IBuilder viewBuilder = getViewBuilder(str);
        if (viewBuilder != null) {
            return viewBuilder.build(vafContext);
        }
        return NORMAL_BUILDER.build(vafContext);
    }

    public static void findClickableViewListener(ViewBase viewBase, FoundClickableViewListener foundClickableViewListener) {
        List<ViewBase> subViews;
        if (viewBase == null) {
            return;
        }
        if (viewBase.getClickEvnet() != null) {
            foundClickableViewListener.onFound(viewBase);
        }
        if ((viewBase instanceof Layout) && (subViews = ((Layout) viewBase).getSubViews()) != null) {
            Iterator<ViewBase> it = subViews.iterator();
            while (it.hasNext()) {
                findClickableViewListener(it.next(), foundClickableViewListener);
            }
        }
    }

    private ViewBase.IBuilder getViewBuilder(String str) {
        return this.mBuilders.get(str);
    }

    public static void setIsShowViewIdInDesc(boolean z16) {
        isShowViewIdInDesc = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBase constructViewBaseTree(VafContext vafContext, ViewBase viewBase, ViewBean viewBean, Map<String, ViewBase> map) {
        Layout.Params params;
        ViewBase createView = createView(vafContext, viewBean.viewType);
        if (createView != null) {
            map.put(viewBean.viewId, createView);
            createView.setName(viewBean.viewId);
            View nativeView = createView.getNativeView();
            if (isShowViewIdInDesc && nativeView != null) {
                nativeView.setContentDescription(viewBean.viewId);
            }
            if (viewBase != null) {
                params = ((Layout) viewBase).generateParams();
            } else {
                params = new Layout.Params();
            }
            createView.setComLayoutParams(params);
            createView.bindNormalValue(viewBean);
            if (LogUtils.shouldLog()) {
                LogUtils.d(TAG, "[constructViewBaseTree] make [" + viewBean.viewType + ", " + viewBean.viewId + "]");
            }
            if (viewBean.children != null && (createView instanceof Layout)) {
                if (LogUtils.shouldLog()) {
                    LogUtils.d(TAG, "[constructViewBaseTree] add children for [" + viewBean.viewType + ", " + viewBean.viewId + "], expected children count: " + viewBean.children.length);
                }
                for (ViewBean viewBean2 : viewBean.children) {
                    ((Layout) createView).addView(constructViewBaseTree(vafContext, createView, viewBean2, map));
                }
            }
        }
        return createView;
    }

    public Container inflate(VafContext vafContext, TemplateBean templateBean) {
        if (templateBean == null) {
            return null;
        }
        if (LogUtils.shouldLog()) {
            LogUtils.d(TAG, "[inflate] " + templateBean.getStyleName());
        }
        Container onCreateContainer = onCreateContainer(vafContext);
        ViewBase constructViewBaseTree = constructViewBaseTree(vafContext, null, templateBean.getViewBean(), onCreateContainer.getViewIdMapping());
        if (constructViewBaseTree != null) {
            onCreateContainer.setVirtualView(constructViewBaseTree);
            onCreateContainer.attachViews();
            if (LogUtils.shouldLog()) {
                LogUtils.d(TAG, "[inflate] hierarchy after inflation: ");
                LogUtils.logViewBaseHierarchy(constructViewBaseTree, TAG);
            }
            return onCreateContainer;
        }
        LogUtil.QLog.d(TAG, 2, "inflate: fail to inflate, vb is null");
        return null;
    }

    public void init(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Utils.init(displayMetrics.density, displayMetrics.widthPixels);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Container onCreateContainer(VafContext vafContext) {
        return new Container(vafContext.getContext());
    }

    public void registerViewBuilder(String str, ViewBase.IBuilder iBuilder) {
        this.mBuilders.put(str, iBuilder);
    }
}
