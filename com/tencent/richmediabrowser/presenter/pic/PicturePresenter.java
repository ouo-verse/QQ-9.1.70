package com.tencent.richmediabrowser.presenter.pic;

import android.text.TextUtils;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.pic.PictureData;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.pic.PictureView;
import f04.c;

/* loaded from: classes25.dex */
public class PicturePresenter extends BrowserBasePresenter {
    private static final String TAG = "PicturePresenter";
    public PictureView pictureView;

    public PictureData getCurrentPictureData() {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo selectedItem = getSelectedItem();
        if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 1) {
            return (PictureData) selectedItem.baseData;
        }
        return null;
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyProgress(String str, int i3) {
        RichMediaBrowserInfo item = getItem(str);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof PictureData) {
                PictureData pictureData = (PictureData) richMediaBaseData;
                pictureData.status = 1;
                pictureData.progress = i3;
                item.baseData = pictureData;
                updateItem(item);
            }
        }
        RichMediaBrowserInfo selectedItem = getSelectedItem();
        if (this.pictureView != null && selectedItem.baseData != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(selectedItem.baseData.f365136id) && str.equals(selectedItem.baseData.f365136id)) {
            this.pictureView.updateUI();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyResult(String str, int i3) {
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "notifyResult id = " + str + " ,result = " + i3);
        RichMediaBrowserInfo item = getItem(str);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof PictureData) {
                PictureData pictureData = (PictureData) richMediaBaseData;
                boolean z16 = false;
                pictureData.status = 0;
                pictureData.progress = 0;
                if (i3 == 0) {
                    z16 = true;
                }
                pictureData.isDownloadSuccess = z16;
                pictureData.errorCode = i3;
                item.baseData = pictureData;
                updateItem(item);
            }
        }
        RichMediaBrowserInfo selectedItem = getSelectedItem();
        if (this.pictureView != null && selectedItem.baseData != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(selectedItem.baseData.f365136id) && str.equals(selectedItem.baseData.f365136id)) {
            this.pictureView.updateUI();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        super.onDestroy();
        PictureData currentPictureData = getCurrentPictureData();
        if (currentPictureData != null && currentPictureData.status == 1 && !TextUtils.isEmpty(currentPictureData.url) && this.mainBrowserPresenter.getParamsBuilder().c() != null) {
            this.mainBrowserPresenter.getParamsBuilder().c().j(currentPictureData.url);
        }
        PictureView pictureView = this.pictureView;
        if (pictureView != null) {
            pictureView.onDestroy();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, f04.b
    public void setBrowserView(c cVar) {
        super.setBrowserView(cVar);
        if (cVar instanceof PictureView) {
            this.pictureView = (PictureView) cVar;
        }
    }
}
