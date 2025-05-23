package com.tencent.richmediabrowser.core;

import android.content.Context;
import android.content.Intent;
import c04.a;
import c04.b;
import c04.c;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserBuilder implements IBrowserBuilder {
    private static final String TAG = "BrowserBuilder";
    private a decoratorModel;
    private b decoratorPresenter;
    private c decoratorView;
    private Context mContext;
    private int mType;
    private f04.a model;
    private f04.b presenter;
    private MainBrowserPresenter relyPresenter;
    private f04.c view;

    public BrowserBuilder(Context context, int i3) {
        this.mContext = context;
        this.mType = i3;
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildComplete() {
        f04.b bVar = this.presenter;
        if (bVar != null) {
            bVar.buildComplete();
        }
        f04.c cVar = this.view;
        if (cVar != null) {
            cVar.buildComplete();
        }
        f04.a aVar = this.model;
        if (aVar != null) {
            aVar.buildComplete();
        }
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildModel() {
        f04.a aVar = this.model;
        if (aVar != null) {
            aVar.buildModel();
        }
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildParams(Intent intent) {
        f04.b bVar = this.presenter;
        if (bVar != null) {
            bVar.buildParams(intent);
        }
        f04.c cVar = this.view;
        if (cVar != null) {
            cVar.buildParams(intent);
        }
        f04.a aVar = this.model;
        if (aVar != null) {
            aVar.buildParams(intent);
        }
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildPresenter() {
        if (this.relyPresenter.getParamsBuilder() != null && this.relyPresenter.getParamsBuilder().f27653c != null && this.relyPresenter.getParamsBuilder().f27653c.get(Integer.valueOf(this.mType)) != null) {
            int intValue = this.relyPresenter.getParamsBuilder().f27653c.get(Integer.valueOf(this.mType)).intValue();
            if (intValue > 0) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildPresenter businessType = " + this.mType + ", decoratorType = " + intValue);
                buildPresenter(intValue);
                if (this.relyPresenter.getParamsBuilder().f27652b != null) {
                    b createPresenter = this.relyPresenter.getParamsBuilder().f27652b.createPresenter(this.mType);
                    this.decoratorPresenter = createPresenter;
                    createPresenter.setRelyPresenter(this.relyPresenter);
                    this.decoratorView = this.relyPresenter.getParamsBuilder().f27652b.a(this.mContext, this.mType, this.decoratorPresenter);
                    a b16 = this.relyPresenter.getParamsBuilder().f27652b.b(this.mType, this.decoratorPresenter);
                    this.decoratorModel = b16;
                    b16.a(this.model);
                    this.decoratorView.g(this.view);
                    this.decoratorPresenter.a(this.presenter);
                    this.decoratorPresenter.d(this.decoratorModel);
                    this.decoratorPresenter.e(this.decoratorView);
                    return;
                }
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildPresenter decoratorMvpFactory is null");
                return;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildPresenter mType = " + this.mType);
            buildPresenter(this.mType);
            return;
        }
        buildPresenter(this.mType);
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildView() {
        f04.c cVar = this.view;
        if (cVar != null) {
            cVar.buildView();
        }
    }

    public b getDecoratorPresenter() {
        return this.decoratorPresenter;
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public f04.b getPresenter() {
        return this.presenter;
    }

    public f04.c getView() {
        return this.view;
    }

    public void setRelyPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.relyPresenter = mainBrowserPresenter;
    }

    private void buildPresenter(int i3) {
        MVPFactory mVPFactory = new MVPFactory(this.relyPresenter);
        f04.b createPresenter = mVPFactory.createPresenter(i3);
        this.presenter = createPresenter;
        if (createPresenter == null) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "buildPresenter presenter is null!");
            return;
        }
        createPresenter.setRelyPresenter(this.relyPresenter);
        f04.c createView = mVPFactory.createView(this.mContext, i3, this.presenter);
        this.view = createView;
        this.presenter.setBrowserView(createView);
        f04.a createModel = mVPFactory.createModel(i3, this.presenter);
        this.model = createModel;
        this.presenter.setBrowserModel(createModel);
        this.presenter.buildPresenter();
    }
}
