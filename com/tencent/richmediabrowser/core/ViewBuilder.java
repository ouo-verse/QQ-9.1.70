package com.tencent.richmediabrowser.core;

import android.content.Context;
import android.content.Intent;
import c04.c;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import f04.b;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ViewBuilder implements IViewBuilder {
    private static final String TAG = "ViewBuilder";
    private b basePresenter;
    private c04.b decoratorPresenter;
    private c decoratorView;
    private Context mContext;
    private int mType;
    private f04.c view;

    public ViewBuilder(Context context, int i3, b bVar, c04.b bVar2) {
        this.mContext = context;
        this.mType = i3;
        this.basePresenter = bVar;
        this.decoratorPresenter = bVar2;
    }

    @Override // com.tencent.richmediabrowser.core.IViewBuilder
    public void buildComplete() {
        f04.c cVar = this.view;
        if (cVar != null) {
            cVar.buildComplete();
        }
    }

    @Override // com.tencent.richmediabrowser.core.IViewBuilder
    public void buildInit() {
        BrowserBasePresenter browserBasePresenter;
        MainBrowserPresenter mainBrowserPresenter;
        b bVar = this.basePresenter;
        if ((bVar instanceof BrowserBasePresenter) && (mainBrowserPresenter = (browserBasePresenter = (BrowserBasePresenter) bVar).mainBrowserPresenter) != null) {
            MVPFactory mVPFactory = new MVPFactory(mainBrowserPresenter);
            int intValue = browserBasePresenter.mainBrowserPresenter.getParamsBuilder().f27653c.get(Integer.valueOf(this.mType)).intValue();
            if (intValue > 0) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildInit businessType = " + this.mType + ", decoratorType = " + intValue);
                f04.c createView = mVPFactory.createView(this.mContext, intValue, this.basePresenter);
                this.view = createView;
                this.basePresenter.setBrowserView(createView);
                if (browserBasePresenter.mainBrowserPresenter.getParamsBuilder().f27652b != null) {
                    c a16 = browserBasePresenter.mainBrowserPresenter.getParamsBuilder().f27652b.a(this.mContext, this.mType, this.decoratorPresenter);
                    this.decoratorView = a16;
                    a16.g(this.view);
                    this.decoratorPresenter.e(this.decoratorView);
                    this.decoratorPresenter.a(this.basePresenter);
                    return;
                }
                return;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildInit mType = " + this.mType);
            this.view = mVPFactory.createView(this.mContext, this.mType, this.basePresenter);
        }
    }

    @Override // com.tencent.richmediabrowser.core.IViewBuilder
    public void buildParams(Intent intent) {
        f04.c cVar = this.view;
        if (cVar != null) {
            cVar.buildParams(intent);
        }
    }

    @Override // com.tencent.richmediabrowser.core.IViewBuilder
    public void buildView() {
        f04.c cVar = this.view;
        if (cVar != null) {
            cVar.buildView();
        }
    }

    public c04.b getDecoratorPresenter() {
        return this.decoratorPresenter;
    }

    public b getPresenter() {
        return this.basePresenter;
    }

    public f04.c getView() {
        return this.view;
    }
}
