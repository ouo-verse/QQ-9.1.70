package com.tencent.richmediabrowser.presenter.video;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.model.video.VideoModel;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.EmptyDrawable;
import com.tencent.richmediabrowser.view.video.VideoView;
import f04.a;
import f04.c;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes25.dex */
public class VideoPresenter extends BrowserBasePresenter {
    private static final String TAG = "VideoPresenter";
    public ConcurrentHashMap<Integer, Drawable> mActiveThumbDrawable = new ConcurrentHashMap<>();
    public VideoModel videoModel;
    private VideoView videoView;

    public static Drawable getCoverDrawable(String str, int i3, int i16) {
        EmptyDrawable emptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), i3, i16);
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(str, emptyDrawable, emptyDrawable);
                if (drawable.getStatus() != 1) {
                    drawable.downloadImediatly();
                }
                return drawable;
            } catch (Exception e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + str + "exception = " + e16.getMessage());
            }
        }
        return emptyDrawable;
    }

    public void dealVideoAutoPlay(String str, boolean z16) {
        RichMediaBrowserInfo item = getItem(str);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof VideoData) {
                VideoData videoData = (VideoData) richMediaBaseData;
                videoData.isAutoPlay = z16;
                item.baseData = videoData;
                updateItem(item);
            }
        }
    }

    public void dealVideoMutePlay(String str, boolean z16) {
        RichMediaBrowserInfo item = getItem(str);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof VideoData) {
                VideoData videoData = (VideoData) richMediaBaseData;
                videoData.isMutePlay = z16;
                item.baseData = videoData;
                updateItem(item);
            }
        }
    }

    public void downloadVideo(VideoData videoData) {
        if (videoData != null && !TextUtils.isEmpty(videoData.url) && this.mainBrowserPresenter.getParamsBuilder().c() != null) {
            this.mainBrowserPresenter.getParamsBuilder().c().i(videoData.url);
        }
    }

    public VideoData getCurrentVideoData() {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo selectedItem = getSelectedItem();
        if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null && richMediaBaseData.getType() == 2) {
            return (VideoData) selectedItem.baseData;
        }
        return null;
    }

    public boolean isAutoPlay(String str) {
        RichMediaBrowserInfo item = getItem(str);
        if (item == null) {
            return false;
        }
        RichMediaBaseData richMediaBaseData = item.baseData;
        if (richMediaBaseData instanceof VideoData) {
            return ((VideoData) richMediaBaseData).isAutoPlay;
        }
        return false;
    }

    public boolean isMutePlay(String str) {
        RichMediaBrowserInfo item = getItem(str);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof VideoData) {
                return ((VideoData) richMediaBaseData).isMutePlay;
            }
            return false;
        }
        return false;
    }

    public void loadVideoCover(int i3, int i16, ImageView imageView, int i17) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo item = getItem(i17);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 2) {
            VideoData videoData = (VideoData) item.baseData;
            Drawable drawable = videoData.coverDrawable;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.mActiveThumbDrawable.put(Integer.valueOf(i17), videoData.coverDrawable);
            } else {
                if (!TextUtils.isEmpty(videoData.coverUrl)) {
                    Drawable coverDrawable = getCoverDrawable(videoData.coverUrl, i3, i16);
                    this.mActiveThumbDrawable.put(Integer.valueOf(i17), coverDrawable);
                    imageView.setImageDrawable(coverDrawable);
                    return;
                }
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "loadVideoCover error");
            }
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyProgress(String str, int i3) {
        RichMediaBrowserInfo item = getItem(str);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof VideoData) {
                VideoData videoData = (VideoData) richMediaBaseData;
                videoData.status = 1;
                videoData.progress = i3;
                item.baseData = videoData;
                updateItem(item);
            }
        }
        RichMediaBrowserInfo selectedItem = getSelectedItem();
        if (this.videoView != null && selectedItem.baseData != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(selectedItem.baseData.f365136id) && str.equals(selectedItem.baseData.f365136id)) {
            this.videoView.updateUI();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.listener.IDownloadEventListener
    public void notifyResult(String str, int i3) {
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "notifyResult id = " + str + " ,result = " + i3);
        RichMediaBrowserInfo item = getItem(str);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof VideoData) {
                VideoData videoData = (VideoData) richMediaBaseData;
                videoData.status = 0;
                videoData.progress = 0;
                videoData.errorCode = i3;
                item.baseData = videoData;
                updateItem(item);
            }
        }
        RichMediaBrowserInfo selectedItem = getSelectedItem();
        if (this.videoView != null && selectedItem.baseData != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(selectedItem.baseData.f365136id) && str.equals(selectedItem.baseData.f365136id)) {
            this.videoView.updateUI();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        super.onDestroy();
        VideoView videoView = this.videoView;
        if (videoView != null) {
            videoView.onDestroy();
        }
        this.mActiveThumbDrawable.clear();
        VideoData currentVideoData = getCurrentVideoData();
        if (currentVideoData != null && currentVideoData.status == 1 && !TextUtils.isEmpty(currentVideoData.url) && this.mainBrowserPresenter.getParamsBuilder().c() != null) {
            this.mainBrowserPresenter.getParamsBuilder().c().l(currentVideoData.url);
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onPause() {
        super.onPause();
        VideoView videoView = this.videoView;
        if (videoView != null) {
            videoView.onPause();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onResume() {
        super.onResume();
        VideoView videoView = this.videoView;
        if (videoView != null) {
            videoView.onResume();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onStop() {
        super.onStop();
        VideoView videoView = this.videoView;
        if (videoView != null) {
            videoView.onStop();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, f04.b
    public void setBrowserModel(a aVar) {
        if (aVar instanceof VideoModel) {
            this.videoModel = (VideoModel) aVar;
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, f04.b
    public void setBrowserView(c cVar) {
        super.setBrowserView(cVar);
        if (cVar instanceof VideoView) {
            this.videoView = (VideoView) cVar;
        }
    }

    public boolean isAutoPlay(int i3) {
        RichMediaBrowserInfo item = getItem(i3);
        if (item == null) {
            return false;
        }
        RichMediaBaseData richMediaBaseData = item.baseData;
        if (richMediaBaseData instanceof VideoData) {
            return ((VideoData) richMediaBaseData).isAutoPlay;
        }
        return false;
    }
}
