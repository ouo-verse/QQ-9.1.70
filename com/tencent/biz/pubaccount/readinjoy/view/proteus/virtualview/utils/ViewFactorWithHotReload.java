package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.ContainerWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ViewFactorWithHotReload extends ViewFactory {
    private static final String TAG = "ViewFactorWithHotReload";

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory
    public Container inflate(VafContext vafContext, TemplateBean templateBean) {
        if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
            ContainerWithHotReload containerWithHotReload = (ContainerWithHotReload) super.inflate(vafContext, templateBean);
            if (containerWithHotReload != null && templateBean != null) {
                containerWithHotReload.setTemplateBean(templateBean);
            }
            return containerWithHotReload;
        }
        return super.inflate(vafContext, templateBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory
    public Container onCreateContainer(VafContext vafContext) {
        if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
            ContainerWithHotReload containerWithHotReload = new ContainerWithHotReload(vafContext.getContext());
            containerWithHotReload.setVafContext(vafContext);
            return containerWithHotReload;
        }
        return super.onCreateContainer(vafContext);
    }

    public void reflate(VafContext vafContext, TemplateBean templateBean, ContainerWithHotReload containerWithHotReload) {
        if (templateBean == null) {
            return;
        }
        if (LogUtils.shouldLog()) {
            LogUtils.d(TAG, "[inflate] " + templateBean.getStyleName());
        }
        if (containerWithHotReload == null) {
            containerWithHotReload = (ContainerWithHotReload) onCreateContainer(vafContext);
        } else {
            containerWithHotReload.removeAllViews();
        }
        containerWithHotReload.setTemplateBean(templateBean);
        ViewBase constructViewBaseTree = constructViewBaseTree(vafContext, null, templateBean.getViewBean(), containerWithHotReload.getViewIdMapping());
        if (constructViewBaseTree != null) {
            containerWithHotReload.setVirtualView(constructViewBaseTree);
            containerWithHotReload.attachViews();
            if (LogUtils.shouldLog()) {
                LogUtils.d(TAG, "[inflate] hierarchy after inflation: ");
                LogUtils.logViewBaseHierarchy(constructViewBaseTree, TAG);
            }
        } else {
            LogUtil.QLog.d(TAG, 2, "inflate: fail to inflate, vb is null");
        }
        ContainerWithHotReload.OnReflateListener onReflateListener = containerWithHotReload.getOnReflateListener();
        if (onReflateListener != null) {
            onReflateListener.onReflate();
        }
    }
}
