package com.tencent.biz.qqcircle.debug.mocklbs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.debug.QFSShowNotificationEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcirclepush.QCircleNotificationHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;

/* loaded from: classes4.dex */
public class QCircleSchemeTestPart extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f84305d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f84306e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements f {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.debug.mocklbs.QCircleSchemeTestPart.f
        public void a(String str) {
            QLog.d("QCircleSchemeTestPart", 1, "scheme:" + str);
            SimpleEventBus.getInstance().dispatchEvent(new QFSShowNotificationEvent(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements f {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.debug.mocklbs.QCircleSchemeTestPart.f
        public void a(String str) {
            QCircleToast.u(str, 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f84310a;

        c(Context context) {
            this.f84310a = context;
        }

        @Override // com.tencent.biz.qqcircle.debug.mocklbs.QCircleSchemeTestPart.f
        public void a(String str) {
            QLog.d("QCircleSchemeTestPart", 1, "scheme:" + str);
            com.tencent.biz.qqcircle.launcher.c.g(this.f84310a, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f84312d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f84313e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Dialog f84314f;

        d(EditText editText, f fVar, Dialog dialog) {
            this.f84312d = editText;
            this.f84313e = fVar;
            this.f84314f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = this.f84312d.getText().toString();
            f fVar = this.f84313e;
            if (fVar != null) {
                fVar.a(obj);
            }
            this.f84314f.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f84316d;

        e(EditText editText) {
            this.f84316d = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleSchemeTestPart.this.K9(this.f84316d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface f {
        void a(String str);
    }

    private void F9() {
        D9("ToastTest", new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.debug.mocklbs.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleSchemeTestPart.this.H9(view);
            }
        });
        D9(com.tencent.biz.qqcircle.utils.h.a(R.string.f182653h2), new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.debug.mocklbs.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleSchemeTestPart.this.I9(view);
            }
        });
        D9(com.tencent.biz.qqcircle.utils.h.a(R.string.f182593gw), new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.debug.mocklbs.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleSchemeTestPart.this.J9(view);
            }
        });
        E9(com.tencent.biz.qqcircle.utils.h.a(R.string.f182683h5), "mqqapi://qcircle/openfolder?first_login_source=39&xsj_main_entrance=pg_xsj_spring_festival_2021_activity&xsj_sub_entrance=pg_xsj_coupon_withdraw_page&is_force_jump_sub_page=1&domain_url=https%3A%2F%2Fqzone.qq.com&domain_id=5&tabtype=6&card_id=sU5ixXQL8m19uEKIL4wV_qeF-2XS5dAn&code=ec8a618f97428b8cf97b6f896fcff771&attach=uin%3D3587745282%26pack_id%3Dec8a618f97428b8cf97b6f896fcff771%26business%3D10875%26signature%3D450be5f85001b1d3a60ec0d56065ba7a&behavior=get");
        E9(com.tencent.biz.qqcircle.utils.h.a(R.string.f182643h1), "mqqapi://qcircle/openfolder?first_login_source=41&xsj_main_entrance=pg_xsj_spring_festival_2021_activity&xsj_sub_entrance=pg_xsj_branch_session_page&main_venue_url=https%3A%2F%2Fqzact.qzone.qq.com%2Fqzone%2Fqzact%2Fact%2Fexternal%2Fspring-2022%2Fwish%2Findex.html%3F_wv%3D16778144%26_wwv%3D1029");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G9(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        O9(getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        N9(getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        M9(getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setTextIsSelectable(true);
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(editText, 0);
    }

    private void L9(Context context, String str, String str2, f fVar) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.f173523f9);
        reportDialog.setCanceledOnTouchOutside(false);
        reportDialog.setContentView(R.layout.g5m);
        TextView textView = (TextView) reportDialog.findViewById(R.id.f94545ck);
        textView.setText(str2);
        final EditText editText = (EditText) reportDialog.findViewById(R.id.f95265ei);
        editText.setHint(str);
        textView.setOnClickListener(new d(editText, fVar, reportDialog));
        reportDialog.getWindow().clearFlags(131072);
        reportDialog.show();
        editText.setOnClickListener(new e(editText));
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.mocklbs.QCircleSchemeTestPart.6
            @Override // java.lang.Runnable
            public void run() {
                QCircleSchemeTestPart.this.K9(editText);
            }
        }, 1000L);
    }

    private void M9(Context context) {
        try {
            QCircleNotificationHandler qCircleNotificationHandler = QCircleNotificationHandler.f261745d;
            QCircleNotificationHandler.class.getDeclaredField("INSTANCE");
        } catch (Exception e16) {
            QLog.e("QCircleSchemeTestPart", 1, "showPushDialog error:" + e16);
        }
        L9(context, com.tencent.biz.qqcircle.utils.h.a(R.string.f182663h3), com.tencent.biz.qqcircle.utils.h.a(R.string.f182593gw), new a());
    }

    private void N9(Context context) {
        L9(context, com.tencent.biz.qqcircle.utils.h.a(R.string.f182663h3), com.tencent.biz.qqcircle.utils.h.a(R.string.f182673h4), new c(context));
    }

    private void O9(Context context) {
        L9(context, com.tencent.biz.qqcircle.utils.h.a(R.string.f182773hd), com.tencent.biz.qqcircle.utils.h.a(R.string.f182783he), new b());
    }

    private void destroy() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    public void D9(String str, View.OnClickListener onClickListener) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(18.0f);
        textView.setPadding(30, 30, 30, 30);
        textView.setOnClickListener(onClickListener);
        this.f84306e.addView(textView);
    }

    public void E9(String str, final String str2) {
        D9(str, new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.debug.mocklbs.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleSchemeTestPart.this.G9(str2, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleSchemeTestPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            destroy();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f84305d = (ImageView) view.findViewById(R.id.y_2);
        this.f84306e = (LinearLayout) view.findViewById(R.id.f166090ed2);
        this.f84305d.setOnClickListener(this);
        this.f84306e.setOnClickListener(this);
        if (getHostFragment() instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(this.f84305d);
        }
        F9();
    }
}
