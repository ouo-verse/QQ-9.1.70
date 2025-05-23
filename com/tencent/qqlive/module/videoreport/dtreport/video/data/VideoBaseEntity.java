package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoBaseEntity {
    private static final String TAG = "video.VideoBaseEntity";
    protected String identifier;
    protected Map<String, Object> videoCustomParams;
    protected WeakReference<View> videoViewRef;
    protected int pageId = 0;
    protected int contentType = -1;
    protected int videoDuration = 0;
    protected boolean isBizReady = true;
    protected boolean isIgnoreReport = false;
    private int player = -1;

    public VideoBaseEntity() {
        Log.i(TAG, "VideoBaseEntity create!");
    }

    public void bindBizPlayer(int i3) {
        this.player = i3;
    }

    public int getBizPlayer() {
        return this.player;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public int getPageId() {
        return this.pageId;
    }

    public Map<String, Object> getVideoCustomParams() {
        if (this.videoCustomParams == null) {
            this.videoCustomParams = new ConcurrentHashMap();
        }
        return this.videoCustomParams;
    }

    public long getVideoDuration() {
        return this.videoDuration;
    }

    public View getVideoView() {
        WeakReference<View> weakReference = this.videoViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean isBizReady() {
        return this.isBizReady;
    }

    public boolean isIgnoreReport() {
        return this.isIgnoreReport;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder {
        protected int contentType;
        protected String identifier;
        protected boolean isBizReady;
        protected boolean isIgnoreReport;
        protected int pageId;
        protected Map<String, Object> videoCustomParams;
        protected int videoDuration;
        protected WeakReference<View> videoViewRef;

        public Builder() {
            this.isBizReady = true;
            this.isIgnoreReport = false;
        }

        public Builder addCustomParams(Map<String, ?> map) {
            if (map == null) {
                return this;
            }
            if (this.videoCustomParams == null) {
                this.videoCustomParams = new ConcurrentHashMap(map.size());
            }
            this.videoCustomParams.putAll(map);
            return this;
        }

        public Builder bizReady(boolean z16) {
            this.isBizReady = z16;
            return this;
        }

        public VideoBaseEntity build() {
            VideoBaseEntity videoBaseEntity = new VideoBaseEntity();
            videoBaseEntity.identifier = this.identifier;
            videoBaseEntity.contentType = this.contentType;
            videoBaseEntity.videoCustomParams = this.videoCustomParams;
            videoBaseEntity.pageId = this.pageId;
            videoBaseEntity.videoDuration = this.videoDuration;
            videoBaseEntity.isBizReady = this.isBizReady;
            videoBaseEntity.isIgnoreReport = this.isIgnoreReport;
            videoBaseEntity.videoViewRef = this.videoViewRef;
            return videoBaseEntity;
        }

        public Builder ignoreReport(boolean z16) {
            this.isIgnoreReport = z16;
            return this;
        }

        public Builder removeAllCustomParams() {
            Map<String, Object> map = this.videoCustomParams;
            if (map != null) {
                map.clear();
            }
            return this;
        }

        public Builder removeCustomParam(String str) {
            Map<String, Object> map = this.videoCustomParams;
            if (map != null) {
                map.remove(str);
            }
            return this;
        }

        public Builder setContentType(int i3) {
            this.contentType = i3;
            return this;
        }

        public Builder setIdentifier(String str) {
            this.identifier = str;
            return this;
        }

        public Builder setPage(Object obj) {
            if (obj == null) {
                return this;
            }
            this.pageId = obj.hashCode();
            return this;
        }

        public Builder setVideoDuration(int i3) {
            this.videoDuration = i3;
            return this;
        }

        public Builder setVideoView(View view) {
            if (view != null) {
                this.videoViewRef = new WeakReference<>(view);
            }
            return this;
        }

        public Builder(VideoBaseEntity videoBaseEntity) {
            this.isBizReady = true;
            this.isIgnoreReport = false;
            this.identifier = videoBaseEntity.identifier;
            this.contentType = videoBaseEntity.contentType;
            this.videoCustomParams = videoBaseEntity.videoCustomParams;
            this.pageId = videoBaseEntity.pageId;
            this.videoDuration = videoBaseEntity.videoDuration;
            this.isBizReady = videoBaseEntity.isBizReady;
            this.isIgnoreReport = videoBaseEntity.isIgnoreReport;
            this.videoViewRef = videoBaseEntity.videoViewRef;
        }
    }
}
