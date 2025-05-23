package com.tenpay.proxy.dlg.age;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AgeSelDlg {
    public static final int LONG_DAY_NUM = 31;
    private static final String LONG_MONTHDAY = "";
    public static final int LONG_MONTH_NUM = 12;
    public static final int LONG_YEAR_NUM = 9999;
    public static final String LONG_YEAR_TXT = "\u957f\u671f";
    private static final String TAG = "AgeSelDlg";
    private static final int TAG_INDEX_DAY = 2;
    private static final int TAG_INDEX_MONTH = 1;
    private static final int TAG_INDEX_YEARE = 0;

    /* renamed from: as, reason: collision with root package name */
    ActionSheet f386683as;
    private Context context;
    private OnDateSelectListener dateSelectListener;
    private DateAdapter mAdapter;
    int mCurrentDay;
    int mCurrentMonth;
    int mCurrentYear = 2020;
    private IphonePickerView.IphonePickListener mDatePickerListener = new IphonePickerView.IphonePickListener() { // from class: com.tenpay.proxy.dlg.age.AgeSelDlg.3
        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            AgeSelDlg.this.f386683as.dismiss();
            int selection = AgeSelDlg.this.f386684pv.getSelection(0);
            int selection2 = AgeSelDlg.this.f386684pv.getSelection(1);
            if (selection >= AgeSelDlg.this.mMaxYearCount) {
                AgeSelDlg.this.dateSelectListener.dateSelectListener(9999, 12, 31);
                return;
            }
            if (selection == 0 && selection2 == 0 && !AgeSelDlg.this.mIsCardBeginTime) {
                OnDateSelectListener onDateSelectListener = AgeSelDlg.this.dateSelectListener;
                AgeSelDlg ageSelDlg = AgeSelDlg.this;
                int i3 = ageSelDlg.mCurrentYear + selection;
                int selection3 = ageSelDlg.f386684pv.getSelection(1);
                AgeSelDlg ageSelDlg2 = AgeSelDlg.this;
                onDateSelectListener.dateSelectListener(i3, selection3 + ageSelDlg2.mCurrentMonth + 1, ageSelDlg2.f386684pv.getSelection(2) + AgeSelDlg.this.mCurrentDay);
                return;
            }
            if (selection != 0 || AgeSelDlg.this.mIsCardBeginTime) {
                OnDateSelectListener onDateSelectListener2 = AgeSelDlg.this.dateSelectListener;
                AgeSelDlg ageSelDlg3 = AgeSelDlg.this;
                onDateSelectListener2.dateSelectListener(ageSelDlg3.mCurrentYear + selection, ageSelDlg3.f386684pv.getSelection(1) + 1, AgeSelDlg.this.f386684pv.getSelection(2) + 1);
            } else {
                OnDateSelectListener onDateSelectListener3 = AgeSelDlg.this.dateSelectListener;
                AgeSelDlg ageSelDlg4 = AgeSelDlg.this;
                int i16 = ageSelDlg4.mCurrentYear + selection;
                int selection4 = ageSelDlg4.f386684pv.getSelection(1);
                AgeSelDlg ageSelDlg5 = AgeSelDlg.this;
                onDateSelectListener3.dateSelectListener(i16, selection4 + ageSelDlg5.mCurrentMonth + 1, ageSelDlg5.f386684pv.getSelection(2) + 1);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            if (i3 != 0) {
                if (i3 == 1) {
                    AgeSelDlg.this.f386684pv.notifyDataSetChange(2);
                }
            } else {
                AgeSelDlg.this.f386684pv.notifyDataSetChange(1);
                AgeSelDlg.this.f386684pv.post(new Runnable() { // from class: com.tenpay.proxy.dlg.age.AgeSelDlg.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AgeSelDlg.this.f386684pv.notifyDataSetChange(2);
                    }
                });
            }
        }
    };
    private boolean mIsCardBeginTime;
    private int mMaxYearCount;

    /* renamed from: pv, reason: collision with root package name */
    IphonePickerView f386684pv;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class DateAdapter implements IphonePickerView.PickerViewAdapter {
        DateAdapter() {
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            return 3;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            int selection = AgeSelDlg.this.f386684pv.getSelection(0);
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return 0;
                    }
                    int selection2 = AgeSelDlg.this.f386684pv.getSelection(1);
                    if (selection >= AgeSelDlg.this.mMaxYearCount) {
                        return 1;
                    }
                    AgeSelDlg ageSelDlg = AgeSelDlg.this;
                    int dayInMonth = ageSelDlg.getDayInMonth(ageSelDlg.mCurrentYear + ageSelDlg.f386684pv.getSelection(0), AgeSelDlg.this.f386684pv.getSelection(1));
                    if (selection == 0 && !AgeSelDlg.this.mIsCardBeginTime) {
                        AgeSelDlg ageSelDlg2 = AgeSelDlg.this;
                        dayInMonth = ageSelDlg2.getDayInMonth(ageSelDlg2.mCurrentYear + ageSelDlg2.f386684pv.getSelection(0), AgeSelDlg.this.f386684pv.getSelection(1) + AgeSelDlg.this.mCurrentMonth);
                    }
                    if (selection == 0 && selection2 == 0 && !AgeSelDlg.this.mIsCardBeginTime) {
                        return (dayInMonth - AgeSelDlg.this.mCurrentDay) + 1;
                    }
                    if (selection == AgeSelDlg.this.mMaxYearCount - 1) {
                        AgeSelDlg ageSelDlg3 = AgeSelDlg.this;
                        if (selection2 == ageSelDlg3.mCurrentMonth && ageSelDlg3.mIsCardBeginTime) {
                            return AgeSelDlg.this.mCurrentDay;
                        }
                    }
                    return dayInMonth;
                }
                QLog.i(AgeSelDlg.TAG, 2, "year index: " + AgeSelDlg.this.f386684pv.getSelection(0));
                if (selection >= AgeSelDlg.this.mMaxYearCount) {
                    return 1;
                }
                if (selection == 0 && !AgeSelDlg.this.mIsCardBeginTime) {
                    return 12 - AgeSelDlg.this.mCurrentMonth;
                }
                if (selection != AgeSelDlg.this.mMaxYearCount - 1 || !AgeSelDlg.this.mIsCardBeginTime) {
                    return 12;
                }
                return AgeSelDlg.this.mCurrentMonth + 1;
            }
            if (AgeSelDlg.this.mIsCardBeginTime) {
                return AgeSelDlg.this.mMaxYearCount;
            }
            return AgeSelDlg.this.mMaxYearCount + 1;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            int selection = AgeSelDlg.this.f386684pv.getSelection(0);
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "";
                    }
                    int selection2 = AgeSelDlg.this.f386684pv.getSelection(1);
                    if (selection >= AgeSelDlg.this.mMaxYearCount) {
                        return "";
                    }
                    if (selection == 0 && selection2 == 0 && !AgeSelDlg.this.mIsCardBeginTime) {
                        return (AgeSelDlg.this.mCurrentDay + i16) + HardCodeUtil.qqStr(R.string.j8e);
                    }
                    return (i16 + 1) + HardCodeUtil.qqStr(R.string.j8e);
                }
                if (selection >= AgeSelDlg.this.mMaxYearCount) {
                    return "";
                }
                if (selection == 0 && !AgeSelDlg.this.mIsCardBeginTime) {
                    return (AgeSelDlg.this.mCurrentMonth + i16 + 1) + HardCodeUtil.qqStr(R.string.j8g);
                }
                return (i16 + 1) + HardCodeUtil.qqStr(R.string.j8g);
            }
            if (i16 >= AgeSelDlg.this.mMaxYearCount) {
                return AgeSelDlg.LONG_YEAR_TXT;
            }
            return (AgeSelDlg.this.mCurrentYear + i16) + HardCodeUtil.qqStr(R.string.j8f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnDateSelectListener {
        void dateSelectListener(int i3, int i16, int i17);

        void dateSelectNotValid();
    }

    public AgeSelDlg(Context context, boolean z16) {
        this.mMaxYearCount = 31;
        this.context = context;
        this.mIsCardBeginTime = z16;
        if (z16) {
            this.mMaxYearCount = 51;
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDayInMonth(int i3, int i16) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i3);
        calendar.set(2, i16);
        calendar.set(5, 1);
        return calendar.getActualMaximum(5);
    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        int i3 = calendar.get(1);
        this.mCurrentYear = i3;
        if (this.mIsCardBeginTime) {
            this.mCurrentYear = i3 - (this.mMaxYearCount - 1);
        }
        this.mCurrentMonth = calendar.get(2);
        this.mCurrentDay = calendar.get(5);
        calendar.set(2, this.mCurrentMonth);
        calendar.set(1, this.mCurrentYear);
        int actualMaximum = calendar.getActualMaximum(5);
        if (actualMaximum < this.mCurrentDay) {
            this.mCurrentDay = actualMaximum;
        }
    }

    private void setPVIndex(IphonePickerView iphonePickerView, int i3, int i16, int i17) {
        iphonePickerView.setSelection(0, i3);
        iphonePickerView.setSelection(1, i16);
        iphonePickerView.setSelection(2, i17);
        if (i3 != 0) {
            iphonePickerView.post(new Runnable() { // from class: com.tenpay.proxy.dlg.age.AgeSelDlg.2
                @Override // java.lang.Runnable
                public void run() {
                    AgeSelDlg.this.mDatePickerListener.onItemSelected(0, 1);
                }
            });
        }
    }

    @SuppressLint({"NewApi"})
    public void popupPickerView(int i3, String str) {
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this.context);
        this.f386683as = createMenuSheet;
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) createMenuSheet.findViewById(i3);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        this.f386683as.setCloseAutoRead(true);
        IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this.context).inflate(R.layout.avo, (ViewGroup) null);
        this.f386684pv = iphonePickerView;
        View findViewById = iphonePickerView.findViewById(R.id.maf);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.proxy.dlg.age.AgeSelDlg.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AgeSelDlg.this.f386683as.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        ((TextView) this.f386684pv.findViewById(R.id.jlr)).setTextColor(-16777216);
        DateAdapter dateAdapter = new DateAdapter();
        this.mAdapter = dateAdapter;
        this.f386684pv.initialize(dateAdapter);
        this.f386684pv.setPickListener(this.mDatePickerListener);
        if (TextUtils.isEmpty(str)) {
            setPVIndex(this.f386684pv, 0, 0, 0);
        } else if (LONG_YEAR_TXT.equals(str)) {
            setPVIndex(this.f386684pv, this.mMaxYearCount, 0, 0);
        } else {
            String[] split = str.split("/");
            if (split.length == 3) {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]) - 1;
                int parseInt3 = Integer.parseInt(split[2]) - 1;
                int dayInMonth = getDayInMonth(parseInt, parseInt2);
                int i16 = this.mCurrentYear;
                if (parseInt >= i16 && parseInt < this.mMaxYearCount + i16 && parseInt2 >= 0 && parseInt2 < 12 && parseInt3 >= 0 && parseInt3 < dayInMonth) {
                    if (parseInt == i16) {
                        setPVIndex(this.f386684pv, 0, parseInt2 - this.mCurrentMonth, (parseInt3 - this.mCurrentDay) + 1);
                    } else {
                        setPVIndex(this.f386684pv, parseInt - i16, parseInt2, parseInt3);
                    }
                } else {
                    setPVIndex(this.f386684pv, 0, 0, 0);
                }
            } else {
                setPVIndex(this.f386684pv, 0, 0, 0);
            }
        }
        this.f386683as.getWindow().setFlags(16777216, 16777216);
        this.f386683as.setActionContentView(this.f386684pv, null);
        try {
            this.f386683as.show();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
    }

    public void setOnDateSelectListener(OnDateSelectListener onDateSelectListener) {
        this.dateSelectListener = onDateSelectListener;
    }
}
