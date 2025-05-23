package l4;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f413791e = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSortShootTimeFirst", "\u6700\u65b0\u62cd\u6444\u5728\u524d");

    /* renamed from: f, reason: collision with root package name */
    private static final String f413792f = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSortShootTimeLast", "\u6700\u65b0\u62cd\u6444\u5728\u540e");

    /* renamed from: g, reason: collision with root package name */
    private static final String f413793g = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSortUploadTimeFirst", "\u6700\u65b0\u4e0a\u4f20\u5728\u524d");

    /* renamed from: h, reason: collision with root package name */
    private static final String f413794h = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSortUploadTimeLast", "\u6700\u65b0\u4e0a\u4f20\u5728\u540e");

    /* renamed from: a, reason: collision with root package name */
    private ActionSheet f413795a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f413796b;

    /* renamed from: c, reason: collision with root package name */
    private ActionSheet.OnButtonClickListener f413797c;

    /* renamed from: d, reason: collision with root package name */
    private int f413798d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: l4.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10704a implements ActionSheet.OnButtonClickListener {
        C10704a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            a.this.c(view, i3);
        }
    }

    public a(Activity activity) {
        b(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, int i3) {
        int i16;
        ActionSheet actionSheet = this.f413795a;
        if (actionSheet == null) {
            return;
        }
        ActionSheetHelper.dismissActionSheet(this.f413796b, actionSheet);
        if (this.f413798d == i3) {
            return;
        }
        this.f413798d = i3;
        int i17 = 2;
        if (i3 != 0) {
            i16 = 3;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        i16 = 0;
                    } else {
                        i17 = 5;
                        i16 = 4;
                    }
                }
                i17 = 4;
            } else {
                i17 = 3;
                i16 = 6;
            }
        } else {
            i16 = 5;
        }
        LpReportInfo_pf00064.allReport(86, 5, i17);
        ActionSheet.OnButtonClickListener onButtonClickListener = this.f413797c;
        if (onButtonClickListener != null) {
            onButtonClickListener.onClick(view, i16);
        }
    }

    private int f(int i3) {
        if (i3 == 3) {
            return 2;
        }
        if (i3 == 4) {
            return 3;
        }
        if (i3 != 5) {
            if (i3 != 6) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public void b(Activity activity) {
        this.f413796b = activity;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(activity, null);
        this.f413795a = actionSheet;
        actionSheet.addRadioButton((CharSequence) f413791e, 1, false);
        this.f413795a.addRadioButton((CharSequence) f413792f, 1, false);
        this.f413795a.addRadioButton((CharSequence) f413793g, 1, true);
        this.f413795a.addRadioButton((CharSequence) f413794h, 1, false);
        this.f413795a.setOnButtonClickListener(new C10704a());
        this.f413795a.addCancelButton(R.string.cancel);
        this.f413795a.registerWatchDisMissActionListener(new b());
    }

    public void d(ActionSheet.OnButtonClickListener onButtonClickListener) {
        this.f413797c = onButtonClickListener;
    }

    public void e(int i3) {
        this.f413795a.clearAllRadioBtnCheckStatus();
        int f16 = f(i3);
        this.f413798d = f16;
        this.f413795a.setRadioButtonChecked(f16);
        if (this.f413795a.isShowing()) {
            this.f413795a.dismiss();
        } else {
            this.f413795a.show();
        }
        LpReportInfo_pf00064.allReport(86, 5, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements ActionSheet.WatchDismissActions {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public void onDismissOperations() {
            LpReportInfo_pf00064.allReport(86, 5, 6);
        }
    }
}
