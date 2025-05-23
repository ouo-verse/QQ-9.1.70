package com.tencent.mobileqq.ark.download;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkDownloadController {

    /* renamed from: i, reason: collision with root package name */
    private static ArkDownloadController f199462i;

    /* renamed from: a, reason: collision with root package name */
    private QQCustomDialog f199463a = null;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.ark.download.a> f199464b = new ArrayList<>(4);

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.ark.download.a> f199465c = new ArrayList<>(4);

    /* renamed from: d, reason: collision with root package name */
    private Object f199466d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f199467e = false;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f199468f = null;

    /* renamed from: g, reason: collision with root package name */
    private int f199469g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f199470h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f199472d;

        a(String str) {
            this.f199472d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            synchronized (ArkDownloadController.this.f199466d) {
                for (int i16 = 0; i16 < ArkDownloadController.this.f199465c.size(); i16++) {
                    com.tencent.mobileqq.ark.download.a aVar = (com.tencent.mobileqq.ark.download.a) ArkDownloadController.this.f199465c.get(i16);
                    if (aVar != null) {
                        aVar.f199478d.onClick(ArkDownloadController.this.f199463a, i3);
                    }
                }
            }
            try {
                ArkDownloadController.this.f199467e = false;
                if (ArkDownloadController.this.f199463a != null && ArkDownloadController.this.f199463a.isShowing()) {
                    ArkDownloadController.this.f199463a.dismiss();
                }
                ArkDownloadController.this.h(this.f199472d);
            } catch (Exception e16) {
                QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", e16);
            }
            QLog.d("ark.download.ctrl", 1, "ark.dctrl [onClickListener] which=", Integer.valueOf(i3), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - ArkDownloadController.this.f199470h)));
            if (i3 == 1) {
                ReportController.r(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(ArkDownloadController.this.f199469g), "", this.f199472d, "");
            } else if (i3 == 0) {
                ReportController.r(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(ArkDownloadController.this.f199469g), "", this.f199472d, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ArkDownloadController.this.f199467e = false;
            QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] onDismiss");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        synchronized (this.f199466d) {
            QLog.e("ark.download.ctrl", 1, "ark.dctrl [checkWaitQueueToShowDialog] waite size:", Integer.valueOf(this.f199464b.size()));
            if (this.f199464b.size() > 0) {
                this.f199465c.clear();
                this.f199465c.addAll((ArrayList) this.f199464b.clone());
                this.f199464b.clear();
                k(str);
            }
        }
    }

    public static ArkDownloadController i() {
        if (f199462i == null) {
            synchronized (ArkDownloadController.class) {
                if (f199462i == null) {
                    f199462i = new ArkDownloadController();
                }
            }
        }
        return f199462i;
    }

    private void j(Context context, ArrayList<com.tencent.mobileqq.ark.download.a> arrayList, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (arrayList.size() <= 4) {
            linearLayout2.setVisibility(8);
        }
        Drawable drawable = context.getResources().getDrawable(R.drawable.mnp);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.tencent.mobileqq.ark.download.a aVar = arrayList.get(i3);
            View inflate = LayoutInflater.from(context).inflate(R.layout.dz7, (ViewGroup) null, false);
            URLImageView uRLImageView = (URLImageView) inflate.findViewById(R.id.xd5);
            TextView textView = (TextView) inflate.findViewById(R.id.zvo);
            QLog.d("ark.download.ctrl", 1, "ark.dctrl [initAppView] item[", Integer.valueOf(i3), "],app name:", aVar.f199476b, ",appid:", aVar.f199475a, ",icon:", aVar.f199477c);
            if (i3 < 7) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                int f16 = BaseAIOUtils.f(47.0f, context.getResources());
                obtain.mRequestWidth = f16;
                obtain.mRequestHeight = f16;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                URLDrawable drawable2 = URLDrawable.getDrawable(aVar.f199477c, obtain);
                drawable2.setTargetDensity(context.getResources().getDisplayMetrics().densityDpi);
                if (drawable2.getStatus() == 2) {
                    drawable2.restartDownload();
                }
                uRLImageView.setImageDrawable(drawable2);
                textView.setVisibility(8);
            } else if (i3 == 7) {
                uRLImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.mnq));
                textView.setText(String.format("+%d", Integer.valueOf(arrayList.size() - 7)));
                textView.setVisibility(0);
            } else {
                return;
            }
            if (i3 < 4) {
                linearLayout.addView(inflate, i3);
            } else {
                linearLayout2.addView(inflate, i3 - 4);
            }
        }
    }

    private void k(String str) {
        ArrayList<com.tencent.mobileqq.ark.download.a> arrayList;
        Activity topActivity = Foreground.getTopActivity();
        int i3 = 0;
        if (topActivity != null && !topActivity.isFinishing() && (arrayList = this.f199465c) != null && arrayList.size() > 0) {
            a aVar = new a(str);
            try {
                this.f199470h = System.currentTimeMillis();
                int size = this.f199465c.size();
                this.f199469g = size;
                QLog.e("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] arkappname:", str, ",showlist size:", Integer.valueOf(size));
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(topActivity, 230, R.layout.dz6, (String) null, String.format(topActivity.getString(R.string.z69), Integer.valueOf(this.f199469g)), topActivity.getString(R.string.cancel), topActivity.getString(R.string.z68), aVar, aVar);
                this.f199463a = createCustomDialog;
                j(topActivity, this.f199465c, (LinearLayout) createCustomDialog.findViewById(R.id.yiq), (LinearLayout) this.f199463a.findViewById(R.id.yip));
                this.f199463a.setOnDismissListener(new b());
                this.f199463a.show();
                ReportController.r(null, "dc00898", "", "", "0X800AD1C", "0X800AD1C", 3, 0, String.valueOf(this.f199469g), "", str, "");
                return;
            } catch (Exception e16) {
                QLog.e("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] exception:", e16);
                return;
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = "ark.dctrl [showDownloadDialog] error,showlist size:";
        ArrayList<com.tencent.mobileqq.ark.download.a> arrayList2 = this.f199465c;
        if (arrayList2 != null) {
            i3 = arrayList2.size();
        }
        objArr[1] = Integer.valueOf(i3);
        QLog.e("ark.download.ctrl", 1, objArr);
    }

    public void l(final String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadPermissionDialog] arkAppName:", str, ", queue size[", Integer.valueOf(this.f199464b.size()), "], app:" + str3 + ",iconUrl:" + str4);
        com.tencent.mobileqq.ark.download.a aVar = new com.tencent.mobileqq.ark.download.a();
        aVar.f199475a = str2;
        aVar.f199477c = str4;
        aVar.f199476b = str3;
        aVar.f199478d = onClickListener;
        synchronized (this.f199466d) {
            this.f199464b.add(aVar);
        }
        if (!this.f199467e) {
            this.f199467e = true;
            this.f199468f = new Runnable() { // from class: com.tencent.mobileqq.ark.download.ArkDownloadController.1
                @Override // java.lang.Runnable
                public void run() {
                    ArkDownloadController.this.h(str);
                }
            };
            ArkDispatchTask.getInstance().postToMainThreadDelayed(this.f199468f, 150L);
        }
    }
}
