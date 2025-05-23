package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;

/* compiled from: P */
/* loaded from: classes4.dex */
public class VafContext {
    public static final int SLOP = 5;
    private Context context;
    private Activity curActivity;
    private BaseTemplateFactory templateFactory;
    private ViewFactory viewFactory = new ViewFactory();

    public Context getContext() {
        return this.context;
    }

    public Activity getCurActivity() {
        return this.curActivity;
    }

    public BaseTemplateFactory getTemplateFactory() {
        return this.templateFactory;
    }

    public ViewFactory getViewFactory() {
        return this.viewFactory;
    }

    public void setContext(Context context) {
        this.context = context;
        this.viewFactory.init(context);
    }

    public void setCurActivity(Activity activity) {
        this.curActivity = activity;
    }

    public void setTemplateFactory(BaseTemplateFactory baseTemplateFactory) {
        this.templateFactory = baseTemplateFactory;
    }

    public void setViewFactory(ViewFactory viewFactory) {
        if (viewFactory != null) {
            this.viewFactory = viewFactory;
        }
    }
}
