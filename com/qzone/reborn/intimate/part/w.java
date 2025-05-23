package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.intimate.part.w;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.QQToastUtil;
import ij.QZIntimateCheckInInfoBean;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pj.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0002H\u0014J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/intimate/part/w;", "Lcom/qzone/reborn/intimate/part/QZIntimatePunchDialogBasePart;", "", "text", "", "Hb", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Cb", "U9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lij/b;", "uiStateData", "La", "R9", "Q9", "", "Fa", "Lpj/h$b;", "na", "d0", "Z", "hasEnterSharePreview", "Landroid/app/Dialog;", "e0", "Landroid/app/Dialog;", "waitingDialog", "<init>", "()V", "f0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class w extends QZIntimatePunchDialogBasePart {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean hasEnterSharePreview;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private Dialog waitingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/w$b", "Lpj/h$b;", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements h.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(w this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Activity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // pj.h.b
        public void a() {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final w wVar = w.this;
            rFWThreadManager.postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.x
                @Override // java.lang.Runnable
                public final void run() {
                    w.b.d(w.this);
                }
            }, 200L);
        }

        @Override // pj.h.b
        public void b() {
            w.this.hasEnterSharePreview = true;
            Dialog punchDialog = w.this.getPunchDialog();
            if (punchDialog != null) {
                punchDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Db(final w this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.hasEnterSharePreview) {
            return;
        }
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.t
            @Override // java.lang.Runnable
            public final void run() {
                w.Eb(w.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eb(w this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fb(w this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Hb(String text) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        if (this.waitingDialog == null) {
            ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
            this.waitingDialog = reportDialog;
            reportDialog.setContentView(R.layout.bqd);
            Dialog dialog = this.waitingDialog;
            View findViewById = dialog != null ? dialog.findViewById(R.id.kja) : null;
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Dialog dialog2 = this.waitingDialog;
            View findViewById2 = dialog2 != null ? dialog2.findViewById(R.id.cib) : null;
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        Dialog dialog3 = this.waitingDialog;
        View findViewById3 = dialog3 != null ? dialog3.findViewById(R.id.dialogText) : null;
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById3).setText(text);
        Dialog dialog4 = this.waitingDialog;
        if (dialog4 != null) {
            dialog4.show();
        }
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public boolean Fa() {
        return false;
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    protected void La(UIStateData<QZIntimateCheckInInfoBean> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        Cb();
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.u
            @Override // java.lang.Runnable
            public final void run() {
                w.Fb(w.this);
            }
        }, 200L);
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.v
            @Override // java.lang.Runnable
            public final void run() {
                w.Gb();
            }
        }, 500L);
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void Q9() {
        Cb();
        cb();
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void R9() {
        Hb("\u6b63\u5728\u4e3a\u60a8\u7ed8\u5236\u65e5\u7b7e\u5361\u4e2d");
        if (TextUtils.isEmpty(V9().getCheckDate())) {
            QLog.e("QZIntimateQueryPunchDialogPart", 1, "check date is null");
        } else {
            V9().p2(V9().getSpaceId(), V9().getCheckDate());
        }
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    protected String U9() {
        try {
            String checkDate = V9().getCheckDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd EEEE", Locale.getDefault());
            Object parse = simpleDateFormat.parse(checkDate);
            if (parse == null) {
                parse = V9().getCheckDate();
            }
            String format = simpleDateFormat2.format(parse);
            QLog.i("QZIntimateQueryPunchDialogPart", 1, "date format is " + format);
            Intrinsics.checkNotNullExpressionValue(format, "{\n            // \u539f\u59cb\u65e5\u671f\u5b57\u7b26\u4e32\u2026     dateFormat\n        }");
            return format;
        } catch (Exception e16) {
            QLog.e("QZIntimateQueryPunchDialogPart", 1, "getCheckInDayText exception is " + e16);
            return V9().getCheckDate();
        }
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public h.b na() {
        return new b();
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        Dialog punchDialog = getPunchDialog();
        if (punchDialog != null) {
            punchDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qzone.reborn.intimate.part.s
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    w.Db(w.this, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gb() {
        QQToastUtil.showQQToastInUiThread(3, "\u62c9\u53d6\u65e5\u7b7e\u5361\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }

    public final void Cb() {
        Dialog dialog;
        try {
            Dialog dialog2 = this.waitingDialog;
            if (!(dialog2 != null && dialog2.isShowing()) || (dialog = this.waitingDialog) == null) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e16) {
            RFWLog.e(getTAG(), RFWLog.USR, "exception is " + e16);
        }
    }
}
