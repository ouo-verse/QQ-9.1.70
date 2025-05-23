package com.tencent.ecommerce.biz.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import cg0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.datepicker.ECPickerView;
import com.tencent.ecommerce.biz.util.ECDateUtil;
import com.tencent.ecommerce.biz.util.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0004~\u007f\u0080\u0001B9\u0012\u0006\u0010v\u001a\u00020-\u0012\u0006\u0010w\u001a\u000200\u0012\u0006\u0010x\u001a\u00020\u0010\u0012\u0006\u0010y\u001a\u00020\u0010\u0012\u0006\u0010z\u001a\u00020\u000e\u0012\b\b\u0002\u0010u\u001a\u00020s\u00a2\u0006\u0004\b{\u0010|J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0003J\b\u0010\u0007\u001a\u00020\u0003H\u0003J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0010H\u0007J\u0018\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u000eR\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u00104R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00104R\u0014\u00107\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00104R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010E\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010K\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010GR\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010GR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010GR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010GR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001e0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001e0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001e0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010TR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u00108R\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010eR\u0016\u0010j\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u00108R\u0016\u0010l\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010LR\u0016\u0010n\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010LR\u0014\u0010r\u001a\u00020o8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010t\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/ecommerce/biz/datepicker/ECPickerView$OnSelectListener;", "", "j", "d", "f", "e", h.F, "", "endMonth", "endDay", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "showAnim", "", "delay", "l", "k", "value", "minValue", "maxValue", "g", "c", "t", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "view", "", "selected", "onSelect", "currentTimeStamp", ReportConstant.COSTREPORT_PREFIX, "dateStr", "r", "timestamp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "cancelable", "o", "canLoop", "p", "canShowAnim", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$Callback;", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$Callback;", "mCallback", "Ljava/util/Calendar;", "Ljava/util/Calendar;", "mBeginTime", "mEndTime", "mSelectedTime", "Z", "mCanDialogShow", "Landroid/app/Dialog;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Dialog;", "mPickerDialog", "Lcom/tencent/ecommerce/biz/datepicker/ECPickerView;", "D", "Lcom/tencent/ecommerce/biz/datepicker/ECPickerView;", "mDpvYear", "E", "mDpvMonth", UserInfo.SEX_FEMALE, "mDpvDay", "G", "I", "mBeginYear", "H", "mBeginMonth", "mBeginDay", "J", "mEndYear", "K", "mEndMonth", "L", "mEndDay", "", "M", "Ljava/util/List;", "mYearUnits", "N", "mMonthUnits", "P", "mDayUnits", "Ljava/text/DecimalFormat;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/text/DecimalFormat;", "mDecimalFormat", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "pattern", ExifInterface.LATITUDE_SOUTH, "mShowDaySelector", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "startDateTv", "U", "endDateTv", "V", "isStartDateTvFocused", "W", "selectedStartTimeMillis", "X", "selectedEndTimeMillis", "Ljava/text/SimpleDateFormat;", "Y", "Ljava/text/SimpleDateFormat;", "format", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$b;", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$b;", DownloadInfo.spKey_Config, "context", "callback", "beginTimestamp", "endTimestamp", "showDaySelector", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$Callback;JJZLcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$b;)V", "a0", "Callback", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCustomDatePicker implements View.OnClickListener, ECPickerView.OnSelectListener {

    /* renamed from: C, reason: from kotlin metadata */
    private Dialog mPickerDialog;

    /* renamed from: D, reason: from kotlin metadata */
    private ECPickerView mDpvYear;

    /* renamed from: E, reason: from kotlin metadata */
    private ECPickerView mDpvMonth;

    /* renamed from: F, reason: from kotlin metadata */
    private ECPickerView mDpvDay;

    /* renamed from: G, reason: from kotlin metadata */
    private int mBeginYear;

    /* renamed from: H, reason: from kotlin metadata */
    private int mBeginMonth;

    /* renamed from: I, reason: from kotlin metadata */
    private int mBeginDay;

    /* renamed from: J, reason: from kotlin metadata */
    private int mEndYear;

    /* renamed from: K, reason: from kotlin metadata */
    private int mEndMonth;

    /* renamed from: L, reason: from kotlin metadata */
    private int mEndDay;

    /* renamed from: M, reason: from kotlin metadata */
    private final List<String> mYearUnits;

    /* renamed from: N, reason: from kotlin metadata */
    private final List<String> mMonthUnits;

    /* renamed from: P, reason: from kotlin metadata */
    private final List<String> mDayUnits;

    /* renamed from: Q, reason: from kotlin metadata */
    private final DecimalFormat mDecimalFormat;

    /* renamed from: R, reason: from kotlin metadata */
    private final String pattern;

    /* renamed from: S, reason: from kotlin metadata */
    private final boolean mShowDaySelector;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView startDateTv;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView endDateTv;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isStartDateTvFocused;

    /* renamed from: W, reason: from kotlin metadata */
    private long selectedStartTimeMillis;

    /* renamed from: X, reason: from kotlin metadata */
    private long selectedEndTimeMillis;

    /* renamed from: Y, reason: from kotlin metadata */
    private final SimpleDateFormat format;

    /* renamed from: Z, reason: from kotlin metadata */
    private final PickerConfig config;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Callback mCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Calendar mBeginTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Calendar mEndTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Calendar mSelectedTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mCanDialogShow;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$Callback;", "", "onCancel", "", "onConfirmTimeSelected", "startTimeMillis", "", "endTimeMillis", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface Callback {
        void onCancel();

        void onConfirmTimeSelected(long startTimeMillis, long endTimeMillis);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            ECCustomDatePicker.this.mCallback.onCancel();
        }
    }

    public ECCustomDatePicker(Context context, Callback callback, long j3, long j16, boolean z16, PickerConfig pickerConfig) {
        this.config = pickerConfig;
        this.mYearUnits = new ArrayList();
        this.mMonthUnits = new ArrayList();
        this.mDayUnits = new ArrayList();
        this.mDecimalFormat = new DecimalFormat("00");
        this.pattern = z16 ? TuxDateStringUtils.TUX_COMMON_DATE_FORMAT : "yyyy-MM";
        this.isStartDateTvFocused = true;
        this.format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        if (j3 > 0 && j3 < j16) {
            this.mContext = context;
            this.mCallback = callback;
            this.mShowDaySelector = z16;
            Calendar calendar = Calendar.getInstance();
            this.mBeginTime = calendar;
            calendar.setTimeInMillis(j3);
            Calendar calendar2 = Calendar.getInstance();
            this.mEndTime = calendar2;
            calendar2.setTimeInMillis(j16);
            this.mSelectedTime = Calendar.getInstance();
            j();
            h();
            this.mCanDialogShow = true;
            return;
        }
        this.mCanDialogShow = false;
        throw new IllegalStateException("beginTimestamp " + j3 + " larger than endTimestamp " + j16);
    }

    private final boolean c() {
        return this.mCanDialogShow && this.mPickerDialog != null;
    }

    private final void d() {
        if (this.selectedStartTimeMillis != 0 && this.selectedEndTimeMillis != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.selectedEndTimeMillis = Math.min(currentTimeMillis, this.selectedEndTimeMillis);
            this.selectedStartTimeMillis = Math.min(currentTimeMillis, this.selectedStartTimeMillis);
            long a16 = ECDateUtil.a(this.selectedEndTimeMillis);
            this.selectedEndTimeMillis = a16;
            long j3 = this.selectedStartTimeMillis;
            if (j3 > a16) {
                this.selectedEndTimeMillis = j3;
                this.selectedStartTimeMillis = a16;
                TextView textView = this.endDateTv;
                String valueOf = String.valueOf(textView != null ? textView.getText() : null);
                TextView textView2 = this.endDateTv;
                if (textView2 != null) {
                    TextView textView3 = this.startDateTv;
                    textView2.setText(String.valueOf(textView3 != null ? textView3.getText() : null));
                }
                TextView textView4 = this.startDateTv;
                if (textView4 != null) {
                    textView4.setText(valueOf);
                }
            }
            this.mCallback.onConfirmTimeSelected(this.selectedStartTimeMillis, this.selectedEndTimeMillis);
            Dialog dialog = this.mPickerDialog;
            if (dialog != null) {
                dialog.dismiss();
                return;
            }
            return;
        }
        a.b("ECCustomDatePicker", "startTime or endTime is unselected, startTime is " + this.selectedStartTimeMillis + ", endTime is " + this.selectedEndTimeMillis);
    }

    private final void e() {
        if (this.isStartDateTvFocused) {
            this.isStartDateTvFocused = false;
            TextView textView = this.endDateTv;
            if (textView != null) {
                textView.setTextColor(this.config.inputTextFocusedColor);
            }
            TextView textView2 = this.endDateTv;
            if (textView2 != null) {
                textView2.setBackground(this.config.getInputFocusedBackground());
            }
            TextView textView3 = this.startDateTv;
            if (textView3 != null) {
                textView3.setTextColor(this.config.inputTextDefaultColor);
            }
            TextView textView4 = this.startDateTv;
            if (textView4 != null) {
                textView4.setBackground(this.config.inputDefaultBackground);
            }
            if (this.selectedEndTimeMillis != 0) {
                TextView textView5 = this.endDateTv;
                r(String.valueOf(textView5 != null ? textView5.getText() : null), false);
            }
        }
    }

    private final void f() {
        if (this.isStartDateTvFocused) {
            return;
        }
        this.isStartDateTvFocused = true;
        TextView textView = this.startDateTv;
        if (textView != null) {
            textView.setTextColor(this.config.inputTextFocusedColor);
        }
        TextView textView2 = this.startDateTv;
        if (textView2 != null) {
            textView2.setBackground(this.config.getInputFocusedBackground());
        }
        TextView textView3 = this.endDateTv;
        if (textView3 != null) {
            textView3.setTextColor(this.config.inputTextDefaultColor);
        }
        TextView textView4 = this.endDateTv;
        if (textView4 != null) {
            textView4.setBackground(this.config.inputDefaultBackground);
        }
        if (this.selectedStartTimeMillis != 0) {
            TextView textView5 = this.startDateTv;
            r(String.valueOf(textView5 != null ? textView5.getText() : null), true);
        }
    }

    private final void h() {
        this.mSelectedTime.setTimeInMillis(this.mBeginTime.getTimeInMillis());
        this.mBeginYear = this.mBeginTime.get(1);
        this.mBeginMonth = this.mBeginTime.get(2) + 1;
        this.mBeginDay = this.mBeginTime.get(5);
        this.mEndYear = this.mEndTime.get(1);
        this.mEndMonth = this.mEndTime.get(2) + 1;
        int i3 = this.mEndTime.get(5);
        this.mEndDay = i3;
        boolean z16 = this.mBeginYear != this.mEndYear;
        boolean z17 = (z16 || this.mBeginMonth == this.mEndMonth) ? false : true;
        boolean z18 = (z17 || this.mBeginDay == i3) ? false : true;
        if (z16) {
            i(12, this.mBeginTime.getActualMaximum(5));
        } else if (z17) {
            i(this.mEndMonth, this.mBeginTime.getActualMaximum(5));
        } else if (z18) {
            i(this.mEndMonth, i3);
        }
    }

    private final void i(int endMonth, int endDay) {
        int i3 = this.mBeginYear;
        int i16 = this.mEndYear;
        if (i3 <= i16) {
            while (true) {
                this.mYearUnits.add(String.valueOf(i3));
                if (i3 == i16) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        int i17 = this.mBeginMonth;
        if (i17 <= endMonth) {
            while (true) {
                this.mMonthUnits.add(this.mDecimalFormat.format(i17));
                if (i17 == endMonth) {
                    break;
                } else {
                    i17++;
                }
            }
        }
        int i18 = this.mBeginDay;
        if (i18 <= endDay) {
            while (true) {
                this.mDayUnits.add(this.mDecimalFormat.format(i18));
                if (i18 == endDay) {
                    break;
                } else {
                    i18++;
                }
            }
        }
        ECPickerView eCPickerView = this.mDpvYear;
        if (eCPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
        }
        eCPickerView.setDataList(this.mYearUnits);
        ECPickerView eCPickerView2 = this.mDpvYear;
        if (eCPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
        }
        eCPickerView2.setSelected(0);
        ECPickerView eCPickerView3 = this.mDpvMonth;
        if (eCPickerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
        }
        eCPickerView3.setDataList(this.mMonthUnits);
        ECPickerView eCPickerView4 = this.mDpvMonth;
        if (eCPickerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
        }
        eCPickerView4.setSelected(0);
        ECPickerView eCPickerView5 = this.mDpvDay;
        if (eCPickerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
        }
        eCPickerView5.setDataList(this.mDayUnits);
        ECPickerView eCPickerView6 = this.mDpvDay;
        if (eCPickerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
        }
        eCPickerView6.setSelected(0);
        m();
    }

    private final void j() {
        ReportDialog reportDialog = new ReportDialog(this.mContext, R.style.f173266zb);
        reportDialog.requestWindowFeature(1);
        reportDialog.setContentView(R.layout.cpx);
        Window window = reportDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        View findViewById = reportDialog.findViewById(R.id.od7);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = reportDialog.findViewById(R.id.oda);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        ECPickerView eCPickerView = (ECPickerView) reportDialog.findViewById(R.id.nvv);
        this.mDpvYear = eCPickerView;
        if (eCPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
        }
        eCPickerView.setOnSelectListener(this);
        ECPickerView eCPickerView2 = (ECPickerView) reportDialog.findViewById(R.id.nvs);
        this.mDpvMonth = eCPickerView2;
        if (eCPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
        }
        eCPickerView2.setOnSelectListener(this);
        ECPickerView eCPickerView3 = (ECPickerView) reportDialog.findViewById(R.id.nvp);
        this.mDpvDay = eCPickerView3;
        if (eCPickerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
        }
        eCPickerView3.setOnSelectListener(this);
        if (!this.mShowDaySelector) {
            LinearLayout linearLayout = (LinearLayout) reportDialog.findViewById(R.id.nvw);
            LinearLayout linearLayout2 = (LinearLayout) reportDialog.findViewById(R.id.nvt);
            LinearLayout linearLayout3 = (LinearLayout) reportDialog.findViewById(R.id.nvq);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 5;
            layoutParams.rightMargin = 150;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = 150;
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout3.setVisibility(8);
            linearLayout2.setLayoutParams(layoutParams);
        }
        TextView textView = (TextView) reportDialog.findViewById(R.id.odf);
        textView.setTextColor(this.config.inputTextFocusedColor);
        textView.setBackground(this.config.getInputFocusedBackground());
        Unit unit = Unit.INSTANCE;
        this.startDateTv = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.odd);
        textView2.setTextColor(this.config.inputTextDefaultColor);
        textView2.setBackground(this.config.inputDefaultBackground);
        this.endDateTv = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        this.mPickerDialog = reportDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(boolean showAnim, long delay) {
        int actualMaximum;
        int i3 = 1;
        int i16 = this.mSelectedTime.get(1);
        int i17 = this.mSelectedTime.get(2) + 1;
        int i18 = this.mBeginYear;
        int i19 = this.mEndYear;
        if (i18 == i19 && this.mBeginMonth == this.mEndMonth) {
            i3 = this.mBeginDay;
            actualMaximum = this.mEndDay;
        } else if (i16 == i18 && i17 == this.mBeginMonth) {
            i3 = this.mBeginDay;
            actualMaximum = this.mSelectedTime.getActualMaximum(5);
        } else if (i16 == i19 && i17 == this.mEndMonth) {
            actualMaximum = this.mEndDay;
        } else {
            actualMaximum = this.mSelectedTime.getActualMaximum(5);
        }
        this.mDayUnits.clear();
        if (i3 <= actualMaximum) {
            int i26 = i3;
            while (true) {
                this.mDayUnits.add(this.mDecimalFormat.format(i26));
                if (i26 == actualMaximum) {
                    break;
                } else {
                    i26++;
                }
            }
        }
        ECPickerView eCPickerView = this.mDpvDay;
        if (eCPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
        }
        eCPickerView.setDataList(this.mDayUnits);
        int g16 = g(this.mSelectedTime.get(5), i3, actualMaximum);
        this.mSelectedTime.set(5, g16);
        t();
        ECPickerView eCPickerView2 = this.mDpvDay;
        if (eCPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
        }
        eCPickerView2.setSelected(g16 - i3);
        if (showAnim) {
            ECPickerView eCPickerView3 = this.mDpvDay;
            if (eCPickerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
            }
            eCPickerView3.h();
        }
    }

    private final void l(final boolean showAnim, final long delay) {
        int i3;
        int i16;
        int i17 = this.mSelectedTime.get(1);
        int i18 = this.mBeginYear;
        int i19 = this.mEndYear;
        if (i18 == i19) {
            i3 = this.mBeginMonth;
            i16 = this.mEndMonth;
        } else {
            if (i17 == i18) {
                i3 = this.mBeginMonth;
            } else if (i17 == i19) {
                i16 = this.mEndMonth;
                i3 = 1;
            } else {
                i3 = 1;
            }
            i16 = 12;
        }
        this.mMonthUnits.clear();
        if (i3 <= i16) {
            int i26 = i3;
            while (true) {
                this.mMonthUnits.add(this.mDecimalFormat.format(i26));
                if (i26 == i16) {
                    break;
                } else {
                    i26++;
                }
            }
        }
        ECPickerView eCPickerView = this.mDpvMonth;
        if (eCPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
        }
        eCPickerView.setDataList(this.mMonthUnits);
        int g16 = g(this.mSelectedTime.get(2) + 1, i3, i16);
        this.mSelectedTime.set(2, g16 - 1);
        t();
        ECPickerView eCPickerView2 = this.mDpvMonth;
        if (eCPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
        }
        eCPickerView2.setSelected(g16 - i3);
        if (showAnim) {
            ECPickerView eCPickerView3 = this.mDpvMonth;
            if (eCPickerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
            }
            eCPickerView3.h();
        }
        ECPickerView eCPickerView4 = this.mDpvMonth;
        if (eCPickerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
        }
        eCPickerView4.postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker$linkageMonthUnit$1
            @Override // java.lang.Runnable
            public final void run() {
                ECCustomDatePicker.this.k(showAnim, delay);
            }
        }, delay);
        m();
    }

    private final void m() {
        ECPickerView eCPickerView = this.mDpvYear;
        if (eCPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
        }
        eCPickerView.setCanScroll(this.mYearUnits.size() > 1);
        ECPickerView eCPickerView2 = this.mDpvMonth;
        if (eCPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
        }
        eCPickerView2.setCanScroll(this.mMonthUnits.size() > 1);
        ECPickerView eCPickerView3 = this.mDpvDay;
        if (eCPickerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
        }
        eCPickerView3.setCanScroll(this.mDayUnits.size() > 1);
    }

    private final void t() {
        if (this.isStartDateTvFocused) {
            String format = this.format.format(this.mSelectedTime.getTime());
            if (!this.mShowDaySelector) {
                if (format != null) {
                    format = format.substring(0, 7);
                    Intrinsics.checkNotNullExpressionValue(format, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            TextView textView = this.startDateTv;
            if (textView != null) {
                textView.setText(format);
            }
            this.selectedStartTimeMillis = this.mSelectedTime.getTimeInMillis();
            return;
        }
        String format2 = this.format.format(this.mSelectedTime.getTime());
        if (!this.mShowDaySelector) {
            if (format2 != null) {
                format2 = format2.substring(0, 7);
                Intrinsics.checkNotNullExpressionValue(format2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        TextView textView2 = this.endDateTv;
        if (textView2 != null) {
            textView2.setText(format2);
        }
        this.selectedEndTimeMillis = this.mSelectedTime.getTimeInMillis();
    }

    public final void n(boolean canShowAnim) {
        if (c()) {
            ECPickerView eCPickerView = this.mDpvYear;
            if (eCPickerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
            }
            eCPickerView.setCanShowAnim(canShowAnim);
            ECPickerView eCPickerView2 = this.mDpvMonth;
            if (eCPickerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
            }
            eCPickerView2.setCanShowAnim(canShowAnim);
            ECPickerView eCPickerView3 = this.mDpvDay;
            if (eCPickerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
            }
            eCPickerView3.setCanShowAnim(canShowAnim);
        }
    }

    public final void o(boolean cancelable) {
        if (c()) {
            Dialog dialog = this.mPickerDialog;
            if (dialog != null) {
                dialog.setCancelable(cancelable);
            }
            Dialog dialog2 = this.mPickerDialog;
            if (dialog2 != null) {
                dialog2.setOnCancelListener(new c());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        int id5 = v3.getId();
        if (id5 == R.id.od7) {
            Dialog dialog = this.mPickerDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.mCallback.onCancel();
        } else if (id5 == R.id.oda) {
            d();
        } else if (id5 == R.id.odf) {
            f();
        } else if (id5 == R.id.odd) {
            e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void p(boolean canLoop) {
        if (c()) {
            ECPickerView eCPickerView = this.mDpvYear;
            if (eCPickerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
            }
            eCPickerView.setCanScrollLoop(canLoop);
            ECPickerView eCPickerView2 = this.mDpvMonth;
            if (eCPickerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvMonth");
            }
            eCPickerView2.setCanScrollLoop(canLoop);
            ECPickerView eCPickerView3 = this.mDpvDay;
            if (eCPickerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDpvDay");
            }
            eCPickerView3.setCanScrollLoop(canLoop);
        }
    }

    public final boolean q(long timestamp, boolean showAnim) {
        if (!c()) {
            return false;
        }
        if (timestamp < this.mBeginTime.getTimeInMillis()) {
            timestamp = this.mBeginTime.getTimeInMillis();
        } else if (timestamp > this.mEndTime.getTimeInMillis()) {
            timestamp = this.mEndTime.getTimeInMillis();
        }
        this.mSelectedTime.setTimeInMillis(timestamp);
        this.mYearUnits.clear();
        int i3 = this.mBeginYear;
        int i16 = this.mEndYear;
        if (i3 <= i16) {
            while (true) {
                this.mYearUnits.add(String.valueOf(i3));
                if (i3 == i16) {
                    break;
                }
                i3++;
            }
        }
        ECPickerView eCPickerView = this.mDpvYear;
        if (eCPickerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
        }
        eCPickerView.setDataList(this.mYearUnits);
        ECPickerView eCPickerView2 = this.mDpvYear;
        if (eCPickerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDpvYear");
        }
        eCPickerView2.setSelected(this.mSelectedTime.get(1) - this.mBeginYear);
        l(showAnim, showAnim ? 100L : 0L);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0014, code lost:
    
        if (r3 != 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r3 != 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r7 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(long currentTimeStamp) {
        long j3;
        Dialog dialog;
        boolean z16 = this.isStartDateTvFocused;
        if (z16) {
            j3 = this.selectedStartTimeMillis;
        }
        if (!z16) {
            j3 = this.selectedEndTimeMillis;
        }
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(Long.valueOf(currentTimeStamp));
        if (!c() || TextUtils.isEmpty(format) || !r(format, false) || (dialog = this.mPickerDialog) == null) {
            return;
        }
        dialog.show();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "inputTextDefaultColor", "b", "inputTextFocusedColor", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/graphics/drawable/Drawable;", "inputDefaultBackground", "d", "()Landroid/graphics/drawable/Drawable;", "inputFocusedBackground", "<init>", "(IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class PickerConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int inputTextDefaultColor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int inputTextFocusedColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Drawable inputDefaultBackground;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final Drawable inputFocusedBackground;

        public PickerConfig(int i3, int i16, Drawable drawable, Drawable drawable2) {
            this.inputTextDefaultColor = i3;
            this.inputTextFocusedColor = i16;
            this.inputDefaultBackground = drawable;
            this.inputFocusedBackground = drawable2;
        }

        /* renamed from: a, reason: from getter */
        public final Drawable getInputFocusedBackground() {
            return this.inputFocusedBackground;
        }

        public int hashCode() {
            int i3 = ((this.inputTextDefaultColor * 31) + this.inputTextFocusedColor) * 31;
            Drawable drawable = this.inputDefaultBackground;
            int hashCode = (i3 + (drawable != null ? drawable.hashCode() : 0)) * 31;
            Drawable drawable2 = this.inputFocusedBackground;
            return hashCode + (drawable2 != null ? drawable2.hashCode() : 0);
        }

        public String toString() {
            return "PickerConfig(inputTextDefaultColor=" + this.inputTextDefaultColor + ", inputTextFocusedColor=" + this.inputTextFocusedColor + ", inputDefaultBackground=" + this.inputDefaultBackground + ", inputFocusedBackground=" + this.inputFocusedBackground + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PickerConfig)) {
                return false;
            }
            PickerConfig pickerConfig = (PickerConfig) other;
            return this.inputTextDefaultColor == pickerConfig.inputTextDefaultColor && this.inputTextFocusedColor == pickerConfig.inputTextFocusedColor && Intrinsics.areEqual(this.inputDefaultBackground, pickerConfig.inputDefaultBackground) && Intrinsics.areEqual(this.inputFocusedBackground, pickerConfig.inputFocusedBackground);
        }
    }

    @Override // com.tencent.ecommerce.biz.datepicker.ECPickerView.OnSelectListener
    public void onSelect(View view, String selected) {
        if (view != null && !TextUtils.isEmpty(selected)) {
            try {
                int parseInt = Integer.parseInt(selected);
                int id5 = view.getId();
                if (id5 == R.id.nvv) {
                    this.mSelectedTime.set(1, parseInt);
                    l(true, 100L);
                } else if (id5 == R.id.nvs) {
                    this.mSelectedTime.add(2, parseInt - (this.mSelectedTime.get(2) + 1));
                    k(true, 100L);
                } else if (id5 == R.id.nvp) {
                    this.mSelectedTime.set(5, parseInt);
                }
                t();
            } catch (Throwable unused) {
            }
        }
    }

    private final int g(int value, int minValue, int maxValue) {
        return value < minValue ? minValue : Math.min(value, maxValue);
    }

    public final boolean r(String dateStr, boolean showAnim) {
        return dateStr != null && c() && !TextUtils.isEmpty(dateStr) && q(d.f104866a.e(dateStr, this.pattern), showAnim);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ECCustomDatePicker(Context context, Callback callback, long j3, long j16, boolean z16, PickerConfig pickerConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, callback, j3, j16, z16, r14);
        PickerConfig pickerConfig2;
        if ((i3 & 32) != 0) {
            ECSkin eCSkin = ECSkin.INSTANCE;
            int color = eCSkin.getColor(R.color.f6421i);
            int color2 = eCSkin.getColor(R.color.f6952y);
            Drawable drawable = eCSkin.getDrawable(R.drawable.bsb);
            drawable = drawable == null ? context.getResources().getDrawable(R.drawable.bsb) : drawable;
            Drawable drawable2 = eCSkin.getDrawable(R.drawable.brz);
            pickerConfig2 = new PickerConfig(color, color2, drawable, drawable2 == null ? context.getResources().getDrawable(R.drawable.brz) : drawable2);
        } else {
            pickerConfig2 = pickerConfig;
        }
    }
}
