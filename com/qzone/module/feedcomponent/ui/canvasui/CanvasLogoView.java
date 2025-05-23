package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyPresenter;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAdvContainerAttach;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.AdvRoundCornerProcessor;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasLogoView extends MarginCanvasAreaView {

    @DittoField
    AsyncCanvasImageArea logo_img;

    @DittoField
    RichCanvasTextArea logo_jump_button;

    @DittoField
    RichCanvasTextArea logo_name;
    private BusinessFeedData mFeedData;

    public CanvasLogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentAreaForJsonFile("qzone_canvas_ui_logoview.json");
        setBackgroundDrawable(AreaManager.BORDER_CONTAINER_ADV);
    }

    private void initData() {
        FeedPictureInfo feedPictureInfo;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return;
        }
        FeedPictureInfo[] feedPictureInfoArr = businessFeedData.pics;
        String str = null;
        if (feedPictureInfoArr != null && feedPictureInfoArr.length > 0 && (feedPictureInfo = feedPictureInfoArr[0]) != null && feedPictureInfo.h() != null && !TextUtils.isEmpty(feedPictureInfo.h().url)) {
            ImageLoader.Options options = new ImageLoader.Options();
            options.extraProcessor = new AdvRoundCornerProcessor(new float[]{30.0f, 30.0f, 30.0f, 30.0f, 30.0f, 30.0f, 30.0f, 30.0f}, feedPictureInfo.f50256s, feedPictureInfo.f50257t);
            this.logo_img.setAsyncImage(feedPictureInfo.h().imageUrl, feedPictureInfo.h().url, null, options);
        }
        CellAdvContainerAttach cellAdvContainerAttach = this.mFeedData.getCellAdvContainerAttach();
        if (cellAdvContainerAttach != null && !TextUtils.isEmpty(cellAdvContainerAttach.remark)) {
            this.logo_name.setText(cellAdvContainerAttach.remark);
        }
        if (this.mFeedData.getRecommAction() != null && !TextUtils.isEmpty(this.mFeedData.getRecommAction().buttonText)) {
            str = this.mFeedData.getRecommAction().buttonText;
        }
        if (this.mFeedData.isAppAd()) {
            if (FeedGlobalEnv.g().checkHasInstallPackage(getContext(), this.mFeedData.getOperationInfo().appid)) {
                if (this.mFeedData.getRecommAction() != null && !TextUtils.isEmpty(this.mFeedData.getRecommAction().installed_buttontxt)) {
                    str = this.mFeedData.getRecommAction().installed_buttontxt;
                } else {
                    str = DownloadImmediatelyPresenter.openText;
                }
            } else if (TextUtils.isEmpty(str)) {
                str = DownloadImmediatelyPresenter.downloadText;
            }
        } else if (TextUtils.isEmpty(str)) {
            str = "\u53bb\u770b\u770b";
        }
        this.logo_jump_button.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"logo_jump_button", "logo_attach_root", "logo_name", "logo_img", "logo_root"})
    public void onJump(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        this.onFeedElementClickListener.onClick(this, FeedElement.LOGO_ATTACH, this.feedPosition, null);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        initData();
    }
}
