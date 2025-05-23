package com.tencent.mobileqq.profilecard.widget.selector;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit;
import com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BaseSelectorView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseSelectorView";
    protected ActionSheetProfileEdit actionSheet;
    private final View divider2;
    private final View divider3;
    protected Context mContext;
    protected ProfileEditPickerView pickerView;
    private final View privacyWrapper;

    public BaseSelectorView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContext = context;
        ActionSheetProfileEdit createSelectDialog = ActionSheetProfileEdit.createSelectDialog(context);
        this.actionSheet = createSelectDialog;
        createSelectDialog.setOnPrivacyChangeListener(new ActionSheetProfileEdit.OnPrivacyChangeListener() { // from class: com.tencent.mobileqq.profilecard.widget.selector.a
            @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyChangeListener
            public final void onChange(int i3) {
                BaseSelectorView.this.onPrivacyChange(i3);
            }
        });
        this.pickerView = (ProfileEditPickerView) this.actionSheet.findViewById(R.id.lzh);
        this.divider2 = this.actionSheet.findViewById(R.id.ujg);
        this.privacyWrapper = this.actionSheet.findViewById(R.id.f27710gz);
        this.divider3 = this.actionSheet.findViewById(R.id.ujh);
    }

    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            Context context = this.mContext;
            if (context instanceof Activity) {
                if (((Activity) context).isFinishing() && this.actionSheet.isShowing()) {
                    this.actionSheet.dismiss();
                    return;
                }
                return;
            }
            this.actionSheet.dismiss();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "BaseSelectorView dismiss error", e16);
        }
    }

    public ActionSheetProfileEdit.OnActionSheetListener getOnActionSheetListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ActionSheetProfileEdit.OnActionSheetListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.actionSheet.getOnActionSheetListener();
    }

    public ActionSheetProfileEdit.OnPrivacyListener getOnPrivacyListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ActionSheetProfileEdit.OnPrivacyListener) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.actionSheet.getOnPrivacyListener();
    }

    public boolean isHide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ActionSheetProfileEdit actionSheetProfileEdit = this.actionSheet;
        if (actionSheetProfileEdit != null && actionSheetProfileEdit.isHide()) {
            return true;
        }
        return false;
    }

    public void onPrivacyChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        ProfileEditPickerView profileEditPickerView = this.pickerView;
        if (profileEditPickerView != null) {
            profileEditPickerView.onPrivacyChange(i3);
        }
    }

    public void setOnActionSheetListener(ActionSheetProfileEdit.OnActionSheetListener onActionSheetListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onActionSheetListener);
        } else {
            this.actionSheet.setOnActionSheetListener(onActionSheetListener);
        }
    }

    public void setOnPrivacyListener(ActionSheetProfileEdit.OnPrivacyListener onPrivacyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onPrivacyListener);
        } else {
            this.actionSheet.setOnPrivacyListener(onPrivacyListener);
        }
    }

    public void setPrivacy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.actionSheet.setPrivacy(i3);
        }
    }

    public void setPrivacyVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.divider2.setVisibility(i3);
        this.privacyWrapper.setVisibility(i3);
        this.divider3.setVisibility(i3);
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.actionSheet.setTitle(str);
        }
    }

    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Context context = this.mContext;
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing() && !this.actionSheet.isShowing()) {
                    this.actionSheet.show();
                    return;
                }
                return;
            }
            this.actionSheet.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "BaseSelectorView show error", e16);
        }
    }
}
