package com.tencent.mobileqq.profilecard.widget.selector;

import android.content.Context;
import com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SexSelectorView extends BaseSelectorView {
    static IPatchRedirector $redirector_;
    private final ProfileEditPickerView.PickerViewAdapter mSexAdapter;

    public SexSelectorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        ProfileEditPickerView.PickerViewAdapter pickerViewAdapter = new ProfileEditPickerView.PickerViewAdapter() { // from class: com.tencent.mobileqq.profilecard.widget.selector.SexSelectorView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SexSelectorView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public int getColumnCount() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this)).intValue();
                }
                return 1;
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public int getRowCount(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this, i3)).intValue();
                }
                return 2;
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public String getText(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (String) iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
                if (i16 < 0 || i16 > 1) {
                    i16 = 0;
                }
                if (i16 == 0) {
                    return "\u7537";
                }
                return "\u5973";
            }
        };
        this.mSexAdapter = pickerViewAdapter;
        this.pickerView.initialize(pickerViewAdapter);
        this.pickerView.setHide(this.actionSheet.isHide());
    }

    public int getSex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.pickerView.getSelection(0);
    }

    public void init(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.pickerView.setSelection(0, i3);
            this.pickerView.notifyDataSetChange(0);
        }
    }
}
