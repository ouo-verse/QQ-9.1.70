package com.tencent.ams.fusion.widget.downloadcard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface DownloadCardListener {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewType {
        public static final int ACTION_BUTTON = 8;
        public static final int AGE_APPROPRIATE = 11;
        public static final int AGREEMENT = 6;
        public static final int APP_ICON = 1;
        public static final int APP_NAME = 2;
        public static final int APP_VERSION = 3;
        public static final int AUTHOR_NAME = 4;
        public static final int CANCEL_TEXTVIEW = 10;
        public static final int CLOSE = 7;
        public static final int DEVELOPER_NAME = 12;
        public static final int EMPTY = 0;
        public static final int FEATURELIST = 9;
        public static final int PERMISSION = 5;
    }

    void onAgreementWebViewDismiss();

    void onAgreementWebViewShow();

    void onCancelViewCancelButtonClick();

    void onCancelViewConfirmButtonClick();

    void onCancelViewShow();

    void onFeatureListWebViewDismiss();

    void onFeatureListWebViewShow();

    void onOpenAppClick();

    void onPermissionWebViewDismiss();

    void onPermissionWebViewShow();

    void onResumeDownloadClick();

    void onStartDownloadClick();

    void onStartInstallClick();

    void onViewClick(int i3, float f16, float f17);

    void onViewDismiss();

    void onViewShow();
}
