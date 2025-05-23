package com.tencent.qqmini.sdk.launcher.core.model;

/* loaded from: classes23.dex */
public class AppPageInfo {
    public static final int FLAG_GET_ALL = -1;
    public static final int FLAG_GET_NONE = 0;
    public static final int FLAG_GET_PAGE_ID = 1;
    public static final int FLAG_GET_PAGE_URL = 2;
    public static final int FLAG_GET_PAGE_WINDOW_HEIGHT = 8;
    public static final int FLAG_GET_PAGE_WINDOW_WIDTH = 4;
    public static final int FLAG_GET_SURFACE_VIEW_HEIGHT = 32;
    public static final int FLAG_GET_SURFACE_VIEW_WIDTH = 16;
    public static final int FLAG_GET_WEB_VIEW_URL = 64;
    public int pageId;
    public String pageUrl;
    public int surfaceViewHeight;
    public int surfaceViewWidth;
    public String webViewUrl;
    public int windowHeight;
    public int windowWidth;

    /* loaded from: classes23.dex */
    public static class Builder {
        private AppPageInfo appPageInfo = new AppPageInfo();

        public AppPageInfo build() {
            return this.appPageInfo;
        }

        public Builder setPageId(int i3) {
            this.appPageInfo.pageId = i3;
            return this;
        }

        public Builder setPageUrl(String str) {
            this.appPageInfo.pageUrl = str;
            return this;
        }

        public Builder setSurfaceViewHeight(int i3) {
            this.appPageInfo.surfaceViewHeight = i3;
            return this;
        }

        public Builder setSurfaceViewWidth(int i3) {
            this.appPageInfo.surfaceViewWidth = i3;
            return this;
        }

        public Builder setWebViewUrl(String str) {
            this.appPageInfo.webViewUrl = str;
            return this;
        }

        public Builder setWindowHeight(int i3) {
            this.appPageInfo.windowHeight = i3;
            return this;
        }

        public Builder setWindowWidth(int i3) {
            this.appPageInfo.windowWidth = i3;
            return this;
        }
    }

    public static boolean enableGetAll(int i3) {
        if (i3 == -1) {
            return true;
        }
        return false;
    }

    public static boolean enableGetPageId(int i3) {
        if ((i3 & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean enableGetPageUrl(int i3) {
        if ((i3 & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean enableGetPageWindowHeight(int i3) {
        if ((i3 & 8) != 0) {
            return true;
        }
        return false;
    }

    public static boolean enableGetPageWindowWidth(int i3) {
        if ((i3 & 4) != 0) {
            return true;
        }
        return false;
    }

    public static boolean enableGetWebViewUrl(int i3) {
        if ((i3 & 64) != 0) {
            return true;
        }
        return false;
    }
}
