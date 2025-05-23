package com.tencent.mobileqq.profilecard.widget.selector;

import android.content.Context;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.ProfileEditDateUtils;
import com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.util.WnsError;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BirthDaySelectorView extends BaseSelectorView {
    static IPatchRedirector $redirector_;
    private final ProfileEditPickerView.PickerViewAdapter mBirthdayAdapter;
    private int mCurrentDay;
    private int mCurrentMonth;
    private int mCurrentYear;
    private int mDay;
    private int mDayIndex;
    private final ProfileEditPickerView.ProfileEditPickListener mListener;
    private int mMonth;
    private int mMonthIndex;
    private int mYear;
    private int mYearIndex;
    private int minYear;

    public BirthDaySelectorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.minYear = WnsError.WNS_CODE_LOGIN_PTLOGIN_BUSY;
        ProfileEditPickerView.PickerViewAdapter pickerViewAdapter = new ProfileEditPickerView.PickerViewAdapter() { // from class: com.tencent.mobileqq.profilecard.widget.selector.BirthDaySelectorView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BirthDaySelectorView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public int getColumnCount() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    return 2;
                }
                return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this)).intValue();
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public int getRowCount(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this, i3)).intValue();
                }
                if (i3 == 0) {
                    if (BirthDaySelectorView.this.mYearIndex + BirthDaySelectorView.this.minYear == BirthDaySelectorView.this.mCurrentYear) {
                        return BirthDaySelectorView.this.mCurrentMonth;
                    }
                    return 12;
                }
                if (BirthDaySelectorView.this.mYearIndex + BirthDaySelectorView.this.minYear == BirthDaySelectorView.this.mCurrentYear && BirthDaySelectorView.this.mMonthIndex + 1 == BirthDaySelectorView.this.mCurrentMonth) {
                    return BirthDaySelectorView.this.mCurrentDay;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.set(1, BirthDaySelectorView.this.mYearIndex + BirthDaySelectorView.this.minYear);
                calendar.set(2, BirthDaySelectorView.this.mMonthIndex);
                calendar.set(5, 1);
                return calendar.getActualMaximum(5);
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.PickerViewAdapter
            public String getText(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (String) iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
                if (i3 == 0) {
                    return (i16 + 1) + "\u6708";
                }
                return (i16 + 1) + "\u65e5";
            }
        };
        this.mBirthdayAdapter = pickerViewAdapter;
        ProfileEditPickerView.ProfileEditPickListener profileEditPickListener = new ProfileEditPickerView.ProfileEditPickListener() { // from class: com.tencent.mobileqq.profilecard.widget.selector.BirthDaySelectorView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BirthDaySelectorView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.ProfileEditPickListener
            public void onItemSelected(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                } else if (i3 == 0) {
                    BirthDaySelectorView.this.mMonthIndex = i16;
                    BirthDaySelectorView.this.pickerView.notifyDataSetChange(1);
                } else {
                    BirthDaySelectorView.this.mDayIndex = i16;
                }
            }
        };
        this.mListener = profileEditPickListener;
        this.pickerView.useCustomLayout();
        this.pickerView.initialize(pickerViewAdapter);
        this.pickerView.setHide(this.actionSheet.isHide());
        this.pickerView.setPickListener(profileEditPickListener);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(1, -120);
        calendar.add(5, 1);
        this.minYear = calendar.get(1);
    }

    private void updateCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        this.mCurrentYear = calendar.get(1);
        this.mCurrentMonth = calendar.get(2) + 1;
        this.mCurrentDay = calendar.get(5);
    }

    private void updateDate() {
        this.mYear = this.mYearIndex + this.minYear;
        this.mMonth = this.mMonthIndex + 1;
        this.mDay = this.mDayIndex + 1;
    }

    private void updateDateIndex() {
        this.mYearIndex = this.mYear - this.minYear;
        this.mMonthIndex = this.mMonth - 1;
        this.mDayIndex = this.mDay - 1;
    }

    public int getBirthdayCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        this.mMonthIndex = this.pickerView.getSelection(0);
        this.mDayIndex = this.pickerView.getSelection(1);
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
        this.pickerView.setSelection(0, this.mMonthIndex);
        this.pickerView.setSelection(1, this.mDayIndex);
        this.pickerView.notifyDataSetChange(0);
        this.pickerView.notifyDataSetChange(1);
    }
}
