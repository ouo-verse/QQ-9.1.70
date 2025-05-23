package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoEntity extends VideoBaseEntity {
    private static final String TAG = "video.VideoEntity";
    private String contentId;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder extends VideoBaseEntity.Builder {
        private String contentId;

        public Builder() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public /* bridge */ /* synthetic */ VideoBaseEntity.Builder addCustomParams(Map map) {
            return addCustomParams((Map<String, ?>) map);
        }

        public Builder setContentId(String str) {
            this.contentId = str;
            return this;
        }

        public Builder(VideoEntity videoEntity) {
            super(videoEntity);
            this.contentId = videoEntity.contentId;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder addCustomParams(Map<String, ?> map) {
            super.addCustomParams(map);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder bizReady(boolean z16) {
            super.bizReady(z16);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public VideoEntity build() {
            VideoEntity videoEntity = new VideoEntity();
            videoEntity.identifier = this.identifier;
            videoEntity.contentId = this.contentId;
            videoEntity.contentType = this.contentType;
            videoEntity.videoCustomParams = this.videoCustomParams;
            videoEntity.pageId = this.pageId;
            videoEntity.videoDuration = this.videoDuration;
            videoEntity.isBizReady = this.isBizReady;
            videoEntity.isIgnoreReport = this.isIgnoreReport;
            videoEntity.videoViewRef = this.videoViewRef;
            return videoEntity;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder ignoreReport(boolean z16) {
            super.ignoreReport(z16);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder removeAllCustomParams() {
            super.removeAllCustomParams();
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder removeCustomParam(String str) {
            super.removeCustomParam(str);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder setContentType(int i3) {
            super.setContentType(i3);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder setIdentifier(String str) {
            super.setIdentifier(str);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder setPage(Object obj) {
            super.setPage(obj);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder setVideoDuration(int i3) {
            super.setVideoDuration(i3);
            return this;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder
        public Builder setVideoView(View view) {
            super.setVideoView(view);
            return this;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface ContentType {
        public static final int CONTENT_TYPE_AD = 1;
        public static final int CONTENT_TYPE_DEFAULT = -1;
        public static final int CONTENT_TYPE_MIX = 3;
        public static final int CONTENT_TYPE_VIDEO = 2;
    }

    public String getContentId() {
        return this.contentId;
    }

    VideoEntity() {
        this.contentId = "";
        Log.i(TAG, "VideoEntity create!");
    }
}
