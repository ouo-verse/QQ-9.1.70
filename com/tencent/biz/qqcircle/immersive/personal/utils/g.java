package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import qqcircle.QQCircleProfile$SetProfileRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final g f89069b = new g();

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QCircleLoadingDialog> f89070a;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f89071a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f89072b;

        a(Activity activity, int i3) {
            this.f89071a = activity;
            this.f89072b = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
            if (z16 && j3 == 0) {
                QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f1928848p), 0);
                this.f89071a.finish();
            } else {
                if (!uq3.l.b().a(j3)) {
                    int i3 = this.f89072b;
                    if (i3 == 10001) {
                        str = this.f89071a.getString(R.string.f1927748e);
                    } else if (i3 == 10016) {
                        str = this.f89071a.getString(R.string.f1925247q);
                    } else {
                        str = this.f89071a.getString(R.string.f1926047y);
                    }
                }
                QCircleToast.p(str, 0, true);
            }
            g.this.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f89074a;

        b(Activity activity) {
            this.f89074a = activity;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
            g.this.d();
            if (!z16) {
                QCircleToast.o(this.f89074a.getString(R.string.f19269487), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QCircleLoadingDialog f89076d;

        c(QCircleLoadingDialog qCircleLoadingDialog) {
            this.f89076d = qCircleLoadingDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleLoadingDialog qCircleLoadingDialog = this.f89076d;
            if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
                this.f89076d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    g() {
    }

    private void b(QCircleLoadingDialog qCircleLoadingDialog) {
        if (qCircleLoadingDialog == null) {
            return;
        }
        qCircleLoadingDialog.S("\u6b63\u5728\u4fdd\u5b58");
        ImageView U = qCircleLoadingDialog.U();
        U.setVisibility(0);
        U.setOnClickListener(new c(qCircleLoadingDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        WeakReference<QCircleLoadingDialog> weakReference = this.f89070a;
        if (weakReference != null && weakReference.get() != null && this.f89070a.get().isShowing()) {
            this.f89070a.get().dismiss();
        }
    }

    public static g e() {
        return f89069b;
    }

    public static String f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, 1);
        calendar.set(5, calendar.getActualMinimum(5));
        return simpleDateFormat.format(calendar.getTime());
    }

    private void i(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            WeakReference<QCircleLoadingDialog> weakReference = new WeakReference<>(new QCircleLoadingDialog(activity));
            this.f89070a = weakReference;
            b(weakReference.get());
            this.f89070a.get().showDialog();
        }
    }

    public void c() {
        this.f89070a = null;
    }

    public void g(int i3, Object obj, Activity activity) {
        i(activity);
        QFSPersonalEditViewModel.f2(i3, obj, new a(activity, i3));
    }

    public void h(com.tencent.biz.qqcircle.immersive.personal.bean.l lVar, Activity activity) {
        i(activity);
        QFSPersonalEditViewModel.f2(10021, lVar, new b(activity));
    }
}
