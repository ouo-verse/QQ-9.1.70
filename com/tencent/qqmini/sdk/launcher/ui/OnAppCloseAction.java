package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public abstract class OnAppCloseAction {
    public Action appCloseAction;
    public String appCloseExpoReportStr;
    public String negativeButtonClickReportStr;
    public int negativeButtonColor;
    public String negativeButtonExpoReportStr;
    public DialogInterface.OnClickListener negativeButtonListener;
    public String negativeButtonText;
    public String positiveButtonClickReportStr;
    public int positiveButtonColor;
    public String positiveButtonExpoReportStr;
    public DialogInterface.OnClickListener positiveButtonListener;
    public String positiveButtonText;
    public int dialogWidth = -1;
    public int dialogHeight = -2;
    public int appCloseActionType = 0;

    /* compiled from: P */
    @MiniKeep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface ACTION_TYPE {
        public static final int DEFAULT = 0;
        public static final int GUESS_YOU_LIKE = 1;
    }

    /* compiled from: P */
    @MiniKeep
    /* loaded from: classes23.dex */
    public interface Action {
        void onAppCloseClicked(Dialog dialog);
    }

    public abstract View getContentView(Context context, Dialog dialog);

    public OnAppCloseAction setAppCloseAction(Action action, String str, int i3) {
        this.appCloseAction = action;
        this.appCloseExpoReportStr = str;
        this.appCloseActionType = i3;
        return this;
    }

    public OnAppCloseAction setHeight(int i3) {
        this.dialogHeight = i3;
        return this;
    }

    public OnAppCloseAction setNegativeButton(String str, int i3, DialogInterface.OnClickListener onClickListener, String str2, String str3) {
        this.negativeButtonText = str;
        this.negativeButtonListener = onClickListener;
        this.negativeButtonColor = i3;
        this.negativeButtonExpoReportStr = str2;
        this.negativeButtonClickReportStr = str3;
        return this;
    }

    public OnAppCloseAction setPositiveButton(String str, int i3, DialogInterface.OnClickListener onClickListener, String str2, String str3) {
        this.positiveButtonText = str;
        this.positiveButtonListener = onClickListener;
        this.positiveButtonColor = i3;
        this.positiveButtonExpoReportStr = str2;
        this.positiveButtonClickReportStr = str3;
        return this;
    }

    public OnAppCloseAction setWidth(int i3) {
        this.dialogWidth = i3;
        return this;
    }
}
