package com.tencent.mobileqq.qqexpand.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final View.OnTouchListener f264107a = new a();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f264108d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Dialog f264109e;

        b(Context context, Dialog dialog) {
            this.f264108d = context;
            this.f264109e = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.putExtra("url", "https://ti.qq.com/extend-friend/?_wv=536870912");
            RouteUtils.startActivity(this.f264108d, intent, RouterConstants.UI_ROUTE_BROWSER);
            ReportController.o(null, "dc00898", "", "", "kuolie", "0X80097DE", 0, 0, "", "", "", "");
            Dialog dialog = this.f264109e;
            if (dialog != null && dialog.isShowing()) {
                this.f264109e.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f264110d;

        c(Dialog dialog) {
            this.f264110d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(null, "dc00898", "", "", "kuolie", "0X80097DF", 0, 0, "", "", "", "");
            Dialog dialog = this.f264110d;
            if (dialog != null && dialog.isShowing()) {
                this.f264110d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static Dialog a(Context context, int i3, View.OnClickListener onClickListener) {
        String e16;
        String qqStr;
        String qqStr2;
        int c16;
        int c17;
        Bitmap bitmap = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.gwg, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.ah8);
        findViewById.setOnTouchListener(f264107a);
        findViewById.setOnClickListener(onClickListener);
        Button button = (Button) inflate.findViewById(R.id.aip);
        button.setOnClickListener(onClickListener);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(x.c(context, 320.0f), -2);
        ReportDialog reportDialog = new ReportDialog(context, R.style.f173557fv);
        reportDialog.addContentView(inflate, layoutParams);
        reportDialog.setCanceledOnTouchOutside(false);
        if (i3 != 2) {
            e16 = e.e("expand_guide_profile.png");
            qqStr = HardCodeUtil.qqStr(R.string.peu);
            qqStr2 = HardCodeUtil.qqStr(R.string.pet);
            c16 = x.c(context, 163.0f);
            c17 = x.c(context, 102.0f);
        } else {
            e16 = e.e("expand_guide_switch.png");
            qqStr = HardCodeUtil.qqStr(R.string.pev);
            qqStr2 = HardCodeUtil.qqStr(R.string.pew);
            c16 = x.c(context, 180.0f);
            c17 = x.c(context, 102.0f);
        }
        if (new File(e16).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmap = e.a(e16, options);
            } catch (Exception e17) {
                QLog.e("ProfileGuideDialogUtils", 1, "showFirstGuide decode bitmap fail.", e17);
            }
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dgv);
        TextView textView = (TextView) inflate.findViewById(R.id.ker);
        imageView.setImageBitmap(bitmap);
        textView.setText(qqStr);
        button.setText(qqStr2);
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        layoutParams2.width = c16;
        layoutParams2.height = c17;
        imageView.setLayoutParams(layoutParams2);
        return reportDialog;
    }

    public static Dialog b(Context context) {
        Bitmap bitmap = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.gwh, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.h2_);
        View findViewById2 = inflate.findViewById(R.id.ah8);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.h2d);
        View.OnTouchListener onTouchListener = f264107a;
        findViewById.setOnTouchListener(onTouchListener);
        findViewById2.setOnTouchListener(onTouchListener);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(x.c(context, 320.0f), -2);
        String e16 = e.e("expand_question_dialog.png");
        if (new File(e16).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmap = e.a(e16, options);
            } catch (Exception e17) {
                QLog.e("ProfileGuideDialogUtils", 1, "createQuestionDialog decode bitmap fail.", e17);
            }
        }
        imageView.setImageBitmap(bitmap);
        ReportDialog reportDialog = new ReportDialog(context, R.style.f173557fv);
        reportDialog.addContentView(inflate, layoutParams);
        reportDialog.setCanceledOnTouchOutside(false);
        findViewById.setOnClickListener(new b(context, reportDialog));
        findViewById2.setOnClickListener(new c(reportDialog));
        return reportDialog;
    }
}
