package com.tencent.richmediabrowser.core;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MainBrowserBuilder implements IBrowserBuilder {
    private static final String TAG = "MainBrowserBuilder";
    private Context mContext;
    private MainBrowserModel model;
    private MainBrowserPresenter presenter;
    private MainBrowserScene scene;

    public MainBrowserBuilder(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildComplete() {
        this.presenter.buildComplete();
        this.scene.buildComplete();
        this.model.buildComplete();
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildModel() {
        this.model.buildModel();
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildParams(Intent intent) {
        this.presenter.buildParams(intent);
        this.scene.buildParams(intent);
        this.model.buildParams(intent);
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildPresenter() {
        MainBrowserPresenter mainBrowserPresenter = new MainBrowserPresenter();
        this.presenter = mainBrowserPresenter;
        MainBrowserScene mainBrowserScene = new MainBrowserScene(this.mContext, mainBrowserPresenter);
        this.scene = mainBrowserScene;
        this.presenter.setBrowserScene(mainBrowserScene);
        MainBrowserModel mainBrowserModel = new MainBrowserModel(this.presenter);
        this.model = mainBrowserModel;
        this.presenter.setBrowserModel(mainBrowserModel);
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public void buildView() {
        this.scene.buildView();
    }

    public RelativeLayout getMainView() {
        MainBrowserScene mainBrowserScene = this.scene;
        if (mainBrowserScene != null) {
            return mainBrowserScene.getRootView();
        }
        return null;
    }

    @Override // com.tencent.richmediabrowser.core.IBrowserBuilder
    public MainBrowserPresenter getPresenter() {
        return this.presenter;
    }
}
