package com.tencent.qqlive.tvkplayer.logo.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKDynamicsLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLogoInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoCommonDefine {
    public static final int DRAW_LOGO_ON_IMAGE_VIEW = 1;
    public static final int DRAW_LOGO_ON_SURFACE_VIEW = 0;
    public static final int LOGO_TYPE_DYNAMICS = 2;
    public static final int LOGO_TYPE_STATIC = 1;
    public static final int LOGO_TYPE_UNKNOWN = 0;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class LogoShowUIInfo {
        private TVKLogoImageView mImageView;
        private float mRightX = 0.0f;
        private float mRightY = 0.0f;
        private float mLogoWidth = 0.0f;
        private float mLogoHeight = 0.0f;
        private int mAlpha = 100;
        private boolean mNeedShow = true;

        public int getAlpha() {
            return this.mAlpha;
        }

        public TVKLogoImageView getImageView() {
            return this.mImageView;
        }

        public float getLogoHeight() {
            return this.mLogoHeight;
        }

        public float getLogoWidth() {
            return this.mLogoWidth;
        }

        public float getRightX() {
            return this.mRightX;
        }

        public float getRightY() {
            return this.mRightY;
        }

        public boolean isNeedShow() {
            return this.mNeedShow;
        }

        public void setAlpha(int i3) {
            this.mAlpha = i3;
        }

        public void setImageView(TVKLogoImageView tVKLogoImageView) {
            this.mImageView = tVKLogoImageView;
        }

        public void setLogoHeight(float f16) {
            this.mLogoHeight = f16;
        }

        public void setLogoWidth(float f16) {
            this.mLogoWidth = f16;
        }

        public void setNeedShow(boolean z16) {
            this.mNeedShow = z16;
        }

        public void setRightX(float f16) {
            this.mRightX = f16;
        }

        public void setRightY(float f16) {
            this.mRightY = f16;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface LogoType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface LogoViewType {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKDynamicLogoInfoWithImageViews {
        private TVKDynamicsLogoInfo mDynamicsLogoInfo;
        private List<SceneWithImageViews> mSceneWithImageViewList = new ArrayList();

        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static class SceneWithImageViews {
            private final int mEnd;
            private final int mInTimeMs;
            private final Map<TVKLogoInfo, TVKLogoImageView> mLogoInfoToImageViewMap = new HashMap();
            private final int mOutTimeMs;
            private final int mStart;

            public SceneWithImageViews(@NonNull Context context, @NonNull TVKDynamicsLogoInfo.Scenes scenes) {
                this.mInTimeMs = scenes.getInTimeMs();
                this.mOutTimeMs = scenes.getOutTimeMs();
                this.mStart = scenes.getStart();
                this.mEnd = scenes.getEnd();
                Iterator<TVKLogoInfo> it = scenes.getLogoInfoList().iterator();
                while (it.hasNext()) {
                    this.mLogoInfoToImageViewMap.put(it.next(), new TVKLogoImageView(context));
                }
            }

            public int getEnd() {
                return this.mEnd;
            }

            public int getInTimeMs() {
                return this.mInTimeMs;
            }

            @NonNull
            public Map<TVKLogoInfo, TVKLogoImageView> getLogoInfoToImageViewMap() {
                return this.mLogoInfoToImageViewMap;
            }

            public int getOutTimeMs() {
                return this.mOutTimeMs;
            }

            public int getStart() {
                return this.mStart;
            }
        }

        public void addSceneWithImageViews(SceneWithImageViews sceneWithImageViews) {
            if (sceneWithImageViews != null) {
                this.mSceneWithImageViewList.add(sceneWithImageViews);
            }
        }

        public TVKDynamicsLogoInfo getDynamicsLogoInfo() {
            return this.mDynamicsLogoInfo;
        }

        @NonNull
        public List<SceneWithImageViews> getSceneWithImageViewsList() {
            return this.mSceneWithImageViewList;
        }

        public void setDynamicsLogoInfo(TVKDynamicsLogoInfo tVKDynamicsLogoInfo) {
            this.mDynamicsLogoInfo = tVKDynamicsLogoInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKOriginalLogoInfo {
        public String defn;
        public TVKDynamicsLogoInfo liveDynamicLogoInfo;
        public List<TVKLogoInfo> logoInfoList;
        public String vid;
        public int videoH;
        public int videoW;
        public String vodDynamicLogoActionUrl;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKStaticLogoInfoWithImageViews {
        public String defn;
        public List<LogoInfoWithImageView> logoInfoWithImageViewList;
        public int videoH;
        public int videoW;

        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static class LogoInfoWithImageView {
            public TVKLogoImageView imageView;
            public TVKLogoInfo logoInfo;
        }
    }
}
