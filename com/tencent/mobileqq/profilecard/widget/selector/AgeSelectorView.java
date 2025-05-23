package com.tencent.mobileqq.profilecard.widget.selector;

import android.content.Context;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.ProfileEditDateUtils;
import com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.util.WnsError;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AgeSelectorView extends BaseSelectorView {
    static IPatchRedirector $redirector_ = null;
    public static final int MAX_AGE = 120;
    private final ProfileEditPickerView.PickerViewAdapter mAgeAdapter;
    private int mCurrentYear;
    private int mDay;
    private int mDayIndex;
    private int mMonth;
    private int mMonthIndex;
    private int mYear;
    private int mYearIndex;
    private int minYear;

    public AgeSelectorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.minYear = WnsError.WNS_CODE_LOGIN_PTLOGIN_BUSY;
        ProfileEditPickerView.PickerViewAdapter pickerViewAdapter = new ProfileEditPickerView.PickerViewAdapter() { // from class: com.tencent.mobileqq.profilecard.widget.selector.AgeSelectorView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AgeSelectorView.this);
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
                AgeSelectorView ageSelectorView = AgeSelectorView.this;
                return ageSelectorView.getYearIndex(ageSelectorView.mCurrentYear + 1);
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public String getText(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (String) iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
                return String.valueOf(AgeSelectorView.this.getYear(i16));
            }
        };
        this.mAgeAdapter = pickerViewAdapter;
        this.pickerView.initialize(pickerViewAdapter);
        this.pickerView.setHide(this.actionSheet.isHide());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(1, -120);
        calendar.add(5, 1);
        this.minYear = calendar.get(1);
    }

    private int getLeapYear(int i3) {
        int i16 = this.minYear;
        int i17 = i16 % 4;
        if (i17 != 0) {
            i16 = (i16 - i17) + 4;
        }
        return i16 + (i3 * 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYear(int i3) {
        if (this.mMonth == 2 && this.mDay == 29) {
            return getLeapYear(i3);
        }
        return this.minYear + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYearIndex(int i3) {
        int i16 = i3 - this.minYear;
        if (this.mMonth == 2 && this.mDay == 29) {
            return i16 / 4;
        }
        return i16;
    }

    private void updateCurrentDate() {
        this.mCurrentYear = Calendar.getInstance().get(1);
    }

    private void updateDate() {
        this.mYear = getYear(this.mYearIndex);
        this.mMonth = this.mMonthIndex + 1;
        this.mDay = this.mDayIndex + 1;
    }

    private void updateDateIndex() {
        this.mYearIndex = getYearIndex(this.mYear);
        this.mMonthIndex = this.mMonth - 1;
        this.mDayIndex = this.mDay - 1;
    }

    public int getBirthdayCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        this.mYearIndex = this.pickerView.getSelection(0);
        updateDate();
        return ProfileEditDateUtils.getBirthdayCode(this.mYear, this.mMonth, this.mDay);
    }

    public void init(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.mYear = i3;
        this.mMonth = i16;
        this.mDay = i17;
        updateCurrentDate();
        updateDateIndex();
        this.pickerView.setSelection(0, this.mYearIndex);
        this.pickerView.notifyDataSetChange(0);
    }
}
