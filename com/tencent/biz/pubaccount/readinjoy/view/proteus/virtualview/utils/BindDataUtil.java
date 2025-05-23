package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class BindDataUtil {
    private static String TAG = "BindDataUtil";

    /* JADX WARN: Removed duplicated region for block: B:28:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0118 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void bindDynamicValueWithoutRecursion(Container container, TemplateBean templateBean, TemplateBean templateBean2) {
        Map<String, ViewBean> map;
        Layout.Params comLayoutParams;
        ViewBean viewBean;
        boolean z16;
        Map<String, ViewBean> map2;
        Map<String, ViewBean> map3;
        if (container != null && templateBean2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, ViewBase> viewIdMapping = container.getViewIdMapping();
            Map<String, ViewBean> viewDataBinding = templateBean2.getViewDataBinding();
            HashSet hashSet = new HashSet();
            if (templateBean != null) {
                map = templateBean.getViewDataBinding();
            } else {
                map = null;
            }
            if (viewIdMapping != null) {
                hashSet.addAll(viewIdMapping.keySet());
            }
            for (String str : viewDataBinding.keySet()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                ViewBean viewBean2 = viewDataBinding.get(str);
                if (map != null) {
                    viewBean = map.get(str);
                } else {
                    viewBean = null;
                }
                hashSet.remove(str);
                ViewBase viewBase = viewIdMapping.get(str);
                if (str != null && viewBase != null && viewBean2 != null && (viewBean == null || !viewBean2.valueBean.dynamicValue.equals(viewBean.valueBean.dynamicValue))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    viewBean2.setVisible(true);
                    viewBase.bindDynamicValue(viewBean2);
                    map2 = viewDataBinding;
                    LogUtil.QLog.d(TAG, 1, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value changed ] newValue: " + viewBean2.valueBean.dynamicValue + "; cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                } else {
                    map2 = viewDataBinding;
                    if (viewBean2 != null) {
                        String str2 = TAG;
                        StringBuilder sb5 = new StringBuilder();
                        map3 = map;
                        sb5.append("[bindDynamicValueWithoutRecursion] skip: ");
                        sb5.append(viewBean2.valueBean.dynamicValue);
                        sb5.append(" viewId = ");
                        sb5.append(str);
                        LogUtil.QLog.i(str2, 1, sb5.toString());
                        LogUtil.QLog.d(TAG, 2, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value not changed ] cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                        if (viewBase == null) {
                            viewBase.setVisibility(0);
                        }
                        viewDataBinding = map2;
                        map = map3;
                    }
                }
                map3 = map;
                if (viewBase == null) {
                }
                viewDataBinding = map2;
                map = map3;
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                viewIdMapping.get((String) it.next()).setVisibility(8);
            }
            LogUtil.QLog.d(TAG, 2, "bindDynamicValueWithoutRecursion_____ " + templateBean2.getStyleName() + " cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            ViewBase virtualView = container.getVirtualView();
            if (virtualView == null || (comLayoutParams = virtualView.getComLayoutParams()) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.MarginLayoutParams(comLayoutParams.mLayoutWidth, comLayoutParams.mLayoutHeight);
            } else {
                layoutParams.width = comLayoutParams.mLayoutWidth;
                layoutParams.height = comLayoutParams.mLayoutHeight;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = comLayoutParams.mLayoutMarginLeft;
                marginLayoutParams.topMargin = comLayoutParams.mLayoutMarginTop;
                marginLayoutParams.rightMargin = comLayoutParams.mLayoutMarginRight;
                marginLayoutParams.bottomMargin = comLayoutParams.mLayoutMarginBottom;
            }
            container.setLayoutParams(layoutParams);
            return;
        }
        LogUtil.QLog.i(TAG, 1, "[bindDynamicValueWithoutRecursion], container or newTemplateBean is null.");
    }
}
