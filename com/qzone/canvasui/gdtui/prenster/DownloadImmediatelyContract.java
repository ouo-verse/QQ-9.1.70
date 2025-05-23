package com.qzone.canvasui.gdtui.prenster;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface DownloadImmediatelyContract {
    public static final int STATUS_DEFAULT = 0;
    public static final int STATUS_DOWNLOAD_IMMEDIATELY = 2;
    public static final int STATUS_DOWNLOAD_SUSPEND = 3;
    public static final int STATUS_INSTALL = 4;
    public static final int STATUS_OPEN = 5;
    public static final int STATUS_SHOW_PROGRESS = 1;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface Presenter {
        String getAppDownloadUrl();

        String getAppId();

        int getDownProgress();

        int getDownloadStatus();

        void hidePercent();

        boolean needDrawProgress();

        void reset();

        void setAppDownloadUrl(String str);

        void setAppId(String str);

        void setupText(String str, String str2);

        void showPercent();

        void updateDownloadStatus(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface View {
        Presenter getPresenter();

        void refreshView();

        void setPresenter(Presenter presenter);

        void setViewText(String str);
    }
}
