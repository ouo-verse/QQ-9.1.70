package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.core.BrowserBuilder;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.listener.IDownloadEventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter;
import e04.a;
import f04.b;
import f04.c;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes25.dex */
public class MainBrowserPresenter implements b, IDownloadEventListener, a {
    private static final String TAG = "MainBrowserPresenter";
    public a activityEventListener;
    public MainBrowserModel browserModel;
    public MainBrowserScene browserScene;
    private b04.a paramsBuilder;
    private ConcurrentHashMap<Integer, b> presenterMap = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Integer, c04.b> decoratorPresenterMap = new ConcurrentHashMap<>();

    public c buildItemView(int i3) {
        BrowserBuilder browserBuilder = new BrowserBuilder(this.browserScene.mContext, i3);
        browserBuilder.setRelyPresenter(this);
        new BrowserDirector().construct(browserBuilder, this.browserScene.mIntent);
        if (browserBuilder.getPresenter() instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) browserBuilder.getPresenter()).setMainBrowserPresenter(this);
            this.presenterMap.put(Integer.valueOf(i3), browserBuilder.getPresenter());
            if (browserBuilder.getDecoratorPresenter() != null) {
                this.decoratorPresenterMap.put(Integer.valueOf(i3), browserBuilder.getDecoratorPresenter());
            }
        }
        return browserBuilder.getView();
    }

    public boolean enableScrollLeft() {
        if (getCurrentPosition() != 0) {
            return true;
        }
        return false;
    }

    public boolean enableScrollRight() {
        if (getCurrentPosition() != getItemCount() - 1) {
            return true;
        }
        return false;
    }

    public Rect getAnimationEndDstRect() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            return mainBrowserScene.getAnimationEndDstRect();
        }
        return null;
    }

    public c04.b getCurrentDecoratorPresenter() {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null && (item = mainBrowserModel.getItem(getCurrentPosition())) != null && (richMediaBaseData = item.baseData) != null) {
            return this.decoratorPresenterMap.get(Integer.valueOf(richMediaBaseData.getType()));
        }
        return null;
    }

    public int getCurrentPosition() {
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null) {
            return mainBrowserModel.getSelectedIndex();
        }
        return 0;
    }

    public b getCurrentPresenter() {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null && (item = mainBrowserModel.getItem(getCurrentPosition())) != null && (richMediaBaseData = item.baseData) != null) {
            return this.presenterMap.get(Integer.valueOf(richMediaBaseData.getType()));
        }
        return null;
    }

    public int getCurrentType() {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null && (item = mainBrowserModel.getItem(getCurrentPosition())) != null && (richMediaBaseData = item.baseData) != null) {
            return richMediaBaseData.getType();
        }
        return 0;
    }

    public c04.b getDecoratorPresenter(int i3) {
        return this.decoratorPresenterMap.get(Integer.valueOf(i3));
    }

    public int getItemCount() {
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null) {
            return mainBrowserModel.getCount();
        }
        return 0;
    }

    public int getLastVisibleItemPosition() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            return mainBrowserScene.getLastVisibleItemPosition();
        }
        return 0;
    }

    public b04.a getParamsBuilder() {
        if (this.paramsBuilder == null) {
            this.paramsBuilder = new b04.a();
        }
        return this.paramsBuilder;
    }

    public b getPresenter(int i3) {
        return this.presenterMap.get(Integer.valueOf(i3));
    }

    public boolean isCurrentView(String str) {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        if (this.browserModel == null || TextUtils.isEmpty(str) || (item = this.browserModel.getItem(getCurrentPosition())) == null || (richMediaBaseData = item.baseData) == null || TextUtils.isEmpty(richMediaBaseData.f365136id) || !str.equals(item.baseData.f365136id)) {
            return false;
        }
        return true;
    }

    public boolean isNeedDisallowInterceptEvent(MotionEvent motionEvent) {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null && mainBrowserScene.isNeedDisallowInterceptEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void notifyImageListChanged(List<RichMediaBrowserInfo> list, int i3) {
        int i16;
        if (list != null) {
            i16 = list.size();
        } else {
            i16 = 0;
        }
        BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "notifyImageListChanged list size " + i16 + ", selected " + i3);
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null) {
            mainBrowserModel.updateList(list);
            this.browserModel.setSelectedIndex(i3);
        }
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.notifyImageModelDataChanged();
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyProgress(String str, int i3) {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null && (item = mainBrowserModel.getItem(str)) != null && (richMediaBaseData = item.baseData) != null) {
            b bVar = this.presenterMap.get(Integer.valueOf(richMediaBaseData.getType()));
            if (bVar instanceof BrowserBasePresenter) {
                ((BrowserBasePresenter) bVar).notifyProgress(str, i3);
            }
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyResult(String str, int i3) {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null && (item = mainBrowserModel.getItem(str)) != null && (richMediaBaseData = item.baseData) != null) {
            b bVar = this.presenterMap.get(Integer.valueOf(richMediaBaseData.getType()));
            if (bVar instanceof BrowserBasePresenter) {
                ((BrowserBasePresenter) bVar).notifyResult(str, i3);
            }
        }
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onActivityResult(i3, i16, intent);
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onActivityResult(i3, i16, intent);
        }
    }

    @Override // e04.a
    public boolean onBackEvent() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.back();
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onBackEvent();
        }
        a aVar = this.activityEventListener;
        if (aVar != null) {
            return aVar.onBackEvent();
        }
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onConfigurationChanged(configuration);
        }
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onConfigurationChanged(configuration);
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onConfigurationChanged(configuration);
        }
    }

    @Override // e04.a
    public void onCreate(Bundle bundle) {
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onCreate(bundle);
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onCreate(bundle);
        }
    }

    public void onDestroy() {
        for (b bVar : this.presenterMap.values()) {
            if (bVar instanceof BrowserBasePresenter) {
                BrowserBasePresenter browserBasePresenter = (BrowserBasePresenter) bVar;
                browserBasePresenter.onDestroy();
                BrowserBaseView browserBaseView = browserBasePresenter.browserBaseView;
                if (browserBaseView != null) {
                    browserBaseView.onDestroy();
                }
            }
        }
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.presenterMap.clear();
        this.decoratorPresenterMap.clear();
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onDestroy();
        }
    }

    public void onDoubleTap() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onDoubleTap();
        }
    }

    public void onItemSelect(int i3) {
        BrowserAdapter.BrowserViewHolder browserViewHolder;
        MainBrowserModel mainBrowserModel = this.browserModel;
        if (mainBrowserModel != null) {
            mainBrowserModel.setSelectedIndex(i3);
            RichMediaBrowserInfo item = this.browserModel.getItem(i3);
            if (item != null && item.baseData != null && (browserViewHolder = this.browserScene.getBrowserViewHolder(i3)) != null) {
                if (browserViewHolder.decoratorPresenter != null) {
                    this.decoratorPresenterMap.put(Integer.valueOf(item.baseData.getType()), browserViewHolder.decoratorPresenter);
                }
                if (browserViewHolder.presenterBuilder != null) {
                    this.presenterMap.put(Integer.valueOf(item.baseData.getType()), browserViewHolder.presenterBuilder);
                }
                b bVar = browserViewHolder.presenterBuilder;
                if (bVar instanceof BrowserBasePresenter) {
                    ((BrowserBasePresenter) bVar).onItemSelect(i3);
                }
            }
        }
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onItemSelected(i3);
        }
    }

    @Override // e04.a
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onKeyDown(i3, keyEvent);
        }
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            return mainBrowserScene.onKeyDown(i3, keyEvent);
        }
        a aVar = this.activityEventListener;
        if (aVar != null) {
            return aVar.onKeyDown(i3, keyEvent);
        }
        return false;
    }

    public void onPause() {
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onPause();
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onPause();
        }
    }

    public void onResume() {
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onResume();
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onResume();
        }
    }

    public void onScale() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onScale();
        }
    }

    public void onScaleBegin() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onScaleBegin();
        }
    }

    public void onScaleEnd() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onScaleEnd();
        }
    }

    public void onShowAreaChanged(View view, RegionDrawableData regionDrawableData) {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onShowAreaChanged(getCurrentPosition(), view, regionDrawableData);
        }
    }

    public void onStart() {
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onStart();
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onStart();
        }
    }

    public void onStop() {
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onStop();
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onStop();
        }
    }

    @Override // e04.a
    public void onWindowFocusChanged() {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.onWindowFocusChanged();
        }
        a aVar = this.activityEventListener;
        if (aVar != null) {
            aVar.onWindowFocusChanged();
        }
        b presenter = getPresenter(getCurrentType());
        if (presenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) presenter).onWindowFocusChanged();
        }
    }

    public void requestDisallowInterceptDragEvent(boolean z16) {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.requestDisallowInterceptDragEvent(z16);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z16) {
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.requestDisallowInterceptTouchEvent(z16);
        }
    }

    public void setActivityEventListener(a aVar) {
        this.activityEventListener = aVar;
    }

    @Override // f04.b
    public void setBrowserModel(f04.a aVar) {
        if (aVar instanceof MainBrowserModel) {
            this.browserModel = (MainBrowserModel) aVar;
        }
    }

    public void setBrowserScene(MainBrowserScene mainBrowserScene) {
        this.browserScene = mainBrowserScene;
    }

    public void setParamsBuilder(b04.a aVar) {
        this.paramsBuilder = aVar;
    }

    @Override // f04.b
    public void buildComplete() {
    }

    @Override // f04.b
    public void buildPresenter() {
    }

    @Override // f04.b
    public void buildParams(Intent intent) {
    }

    public void resetItemView(int i3) {
    }

    @Override // f04.b
    public void setBrowserView(c cVar) {
    }

    @Override // f04.b
    public void setRelyPresenter(b bVar) {
    }
}
