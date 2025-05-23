package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactorWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ContainerWithHotReload extends Container implements ProteusParserWithHotReload.IHotReloadChangedObserver {
    private OnReflateListener mOnReflateListener;
    private TemplateBean mTemplateBean;
    private VafContext mVafContext;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface OnReflateListener {
        void onReflate();
    }

    public ContainerWithHotReload(Context context) {
        super(context);
    }

    private void trySetLayoutParamsMargin(ViewGroup.LayoutParams layoutParams, Layout.Params params) {
        try {
            Field field = layoutParams.getClass().getField("leftMargin");
            Field field2 = layoutParams.getClass().getField("rightMargin");
            Field field3 = layoutParams.getClass().getField("topMargin");
            Field field4 = layoutParams.getClass().getField("bottomMargin");
            field.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);
            field4.setAccessible(true);
            field.set(layoutParams, Integer.valueOf(params.mLayoutMarginLeft));
            field2.set(layoutParams, Integer.valueOf(params.mLayoutMarginRight));
            field3.set(layoutParams, Integer.valueOf(params.mLayoutMarginTop));
            field4.set(layoutParams, Integer.valueOf(params.mLayoutMarginBottom));
        } catch (Exception e16) {
            LogUtil.QLog.e("readinjoy.proteus", 2, " there is no margin field in layout params: " + e16.toString());
        }
    }

    public OnReflateListener getOnReflateListener() {
        return this.mOnReflateListener;
    }

    public TemplateBean getTemplateBean() {
        return this.mTemplateBean;
    }

    public VafContext getVafContext() {
        return this.mVafContext;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver
    public void onHotReloadChanged(Context context, String str, String str2) {
        if (str.equals(this.mTemplateBean.getStyleName())) {
            try {
                refresh(str, this);
            } catch (IOException e16) {
                e16.printStackTrace();
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    public void refresh(String str, ContainerWithHotReload containerWithHotReload) throws JSONException, IOException {
        VafContext vafContext = containerWithHotReload.getVafContext();
        TemplateBean template = vafContext.getTemplateFactory().getTemplate(str);
        JSONObject data = containerWithHotReload.getTemplateBean().getData();
        if (data != null) {
            template.bindData(data);
        }
        ViewFactory viewFactory = vafContext.getViewFactory();
        if (viewFactory instanceof ViewFactorWithHotReload) {
            ((ViewFactorWithHotReload) viewFactory).reflate(vafContext, template, containerWithHotReload);
        }
        BindDataUtil.bindDynamicValueWithoutRecursion(containerWithHotReload, null, template);
        ViewGroup.LayoutParams layoutParams = containerWithHotReload.getLayoutParams();
        Layout.Params comLayoutParams = containerWithHotReload.getVirtualView().getComLayoutParams();
        layoutParams.width = comLayoutParams.mLayoutWidth;
        layoutParams.height = comLayoutParams.mLayoutHeight;
        trySetLayoutParamsMargin(layoutParams, comLayoutParams);
        if (containerWithHotReload.getParent() != null) {
            containerWithHotReload.getParent().requestLayout();
            ((View) containerWithHotReload.getParent()).invalidate();
        }
    }

    public void setOnReflateListener(OnReflateListener onReflateListener) {
        this.mOnReflateListener = onReflateListener;
    }

    public void setTemplateBean(TemplateBean templateBean) {
        this.mTemplateBean = templateBean;
    }

    public void setVafContext(VafContext vafContext) {
        this.mVafContext = vafContext;
    }
}
