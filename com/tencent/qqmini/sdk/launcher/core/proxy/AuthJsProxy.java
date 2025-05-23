package com.tencent.qqmini.sdk.launcher.core.proxy;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class AuthJsProxy {
    public static final int AUTH_DETAIL_DIALOG_TYPE_BOTTOM = 1;
    public static final int AUTH_DETAIL_DIALOG_TYPE_CENTER = 2;
    public static final String CANCEL_MINI_REPORT_EVENT = "cancel";
    public static final String CLICK_MINI_REPORT_EVENT = "click";
    public static final String EXPO_MINI_REPORT_EVENT = "expo";
    public static final int REQUEST_CODE_ADD_PHONENUMBER = 1088;
    public static final int REQUEST_CODE_PHONE_MANAGER = 1089;
    public static final String SUB_MINIGAME_REPORT = "minigamesubs";
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_ONCE_SUB_MSG = 3;
    public static final int TYPE_PHONENUMBER = 2;
    public static final int TYPE_SYS_SUB_MSG = 4;
    public static final int TYPE_USER_INFO = 5;
    public static final String UNSUB_MINIGAME_REPORT = "no_mgs";

    /* loaded from: classes23.dex */
    public static class AuthDetailDialogResConfig {
        public boolean canceledOnTouchOutside;
        public List<COMM.Entry> content;
        public INTERFACE$StSubscribeMessage curSubMsg;
        public int dialogType;
        public int requestHeight;
        public int requestWidth;
        public String title;
    }

    /* loaded from: classes23.dex */
    public static class AuthDialogResConfig {
        public String authDesc;
        public String authTitle;
        public boolean canceledOnTouchOutside;
        public int dialogType = 1;
        public String eventName;
        public View.OnClickListener leftBtnClickListener;
        public String leftBtnText;
        public IMiniAppContext miniAppContext;
        public Drawable miniAppIconUrl;
        public MiniAppInfo miniAppInfo;
        public String miniAppName;
        public JSONArray phoneNumberList;
        public String reportSubAction;
        public View.OnClickListener rightBtnClickListener;
        public String rightBtnText;
        public Drawable userIconUrl;
        public String userName;
    }

    public abstract void dismissAuthDialog();

    public abstract Bundle getAuthDialogBundleData();

    public abstract AuthDialogResConfig getAuthDialogResConfig();

    public abstract int getAuthDialogType();

    public abstract JSONObject getSelectPhoneNumber();

    public abstract void initAuthDialog(@NonNull Activity activity, AuthDialogResConfig authDialogResConfig);

    public abstract boolean isAuthConfirm();

    public abstract boolean isAuthDialogInit();

    public abstract boolean isAuthDialogNotNull();

    public abstract boolean isAuthDialogShow();

    public abstract boolean isAuthRefuse();

    public abstract void reportMiniAppEvent(String str);

    public abstract void setAuthDialogBundleData(Bundle bundle);

    public abstract void setAuthDialogToNull();

    public abstract void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    public abstract void showAuthDialog(AuthDialogResConfig authDialogResConfig);

    public abstract void showAuthListViewHintDialog(@NonNull Activity activity, AuthDetailDialogResConfig authDetailDialogResConfig);
}
