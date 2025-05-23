package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.listener.IDownloadEventListener;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import f04.a;
import f04.b;
import f04.c;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes25.dex */
public class BrowserBasePresenter extends BasePresenter implements b, IGalleryImageListener, IDownloadEventListener {
    public BrowserBaseView browserBaseView;
    public ConcurrentHashMap<Integer, URLDrawable> mActiveDrawable = new ConcurrentHashMap<>();
    public MainBrowserPresenter mainBrowserPresenter;

    public void back() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.back();
        }
    }

    public RelativeLayout getContentView() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            return mainBrowserScene.getContentView();
        }
        return null;
    }

    public int getCount() {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserModel = mainBrowserPresenter.browserModel) != null) {
            return mainBrowserModel.getCount();
        }
        return 0;
    }

    public int getCurrentPosition() {
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null) {
            return mainBrowserPresenter.getCurrentPosition();
        }
        return -1;
    }

    public RichMediaBrowserInfo getItem(int i3) {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter == null || (mainBrowserScene = mainBrowserPresenter.browserScene) == null) {
            return null;
        }
        return mainBrowserScene.getItem(i3);
    }

    public RecyclerView getRecyclerView() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            return mainBrowserScene.getRecyclerView();
        }
        return null;
    }

    public RelativeLayout getRootView() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            return mainBrowserScene.mRoot;
        }
        return null;
    }

    public int getSelectedIndex() {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserModel = mainBrowserPresenter.browserModel) != null) {
            return mainBrowserModel.getSelectedIndex();
        }
        return 0;
    }

    public RichMediaBrowserInfo getSelectedItem() {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserModel = mainBrowserPresenter.browserModel) != null) {
            return mainBrowserModel.getSelectedItem();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.notifyDataSetChanged();
        }
    }

    public void notifyItemChanged(int i3) {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.notifyItemChanged(i3);
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        this.mActiveDrawable.clear();
    }

    @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
    public void onLoadDrawable(int i3, URLDrawable uRLDrawable) {
        if (uRLDrawable != null) {
            this.mActiveDrawable.put(Integer.valueOf(i3), uRLDrawable);
        }
    }

    public void onLoadFinish(int i3, boolean z16) {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.onLoadFinish(i3, z16);
        }
    }

    public void onLoadStart(int i3, int i16) {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.onLoadStart(i3, i16);
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
    public void onLoadSuccessed(int i3, boolean z16) {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.onLoadSuccessed(i3, z16);
        }
    }

    public void setBrowserView(c cVar) {
        if (cVar instanceof BrowserBaseView) {
            this.browserBaseView = (BrowserBaseView) cVar;
        }
    }

    public void setMainBrowserPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.mainBrowserPresenter = mainBrowserPresenter;
    }

    @Override // f04.b
    public void setRelyPresenter(b bVar) {
        if (bVar instanceof MainBrowserPresenter) {
            setMainBrowserPresenter((MainBrowserPresenter) bVar);
        }
    }

    public void showContentView(boolean z16) {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.showContentView(z16);
        }
    }

    public void updateItem(RichMediaBrowserInfo richMediaBrowserInfo) {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter == null || (mainBrowserModel = mainBrowserPresenter.browserModel) == null) {
            return;
        }
        mainBrowserModel.updateItem(richMediaBrowserInfo);
    }

    public void updateItemStatus(String str, int i3) {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserModel = mainBrowserPresenter.browserModel) != null) {
            mainBrowserModel.updateItemStatus(str, i3);
        }
    }

    public void updateSystemUIVisablity() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            mainBrowserScene.updateSystemUIVisablity();
        }
    }

    public RichMediaBrowserInfo getItem(String str) {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter == null || (mainBrowserModel = mainBrowserPresenter.browserModel) == null) {
            return null;
        }
        return mainBrowserModel.getItem(str);
    }

    public void updateItem(RichMediaBrowserInfo richMediaBrowserInfo, int i3) {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter == null || (mainBrowserModel = mainBrowserPresenter.browserModel) == null) {
            return;
        }
        mainBrowserModel.updateItem(richMediaBrowserInfo, i3);
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

    public void onItemSelect(int i3) {
    }

    @Override // f04.b
    public void setBrowserModel(a aVar) {
    }

    @Override // com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyProgress(String str, int i3) {
    }

    @Override // com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyResult(String str, int i3) {
    }
}
