package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.f;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.participle.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.textpreview.AbsTextPreviewActivity;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import com.tencent.util.LoadingUtil;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes33.dex */
public class TextPreviewMenu extends com.tencent.mobileqq.activity.selectable.a<AbsTextPreviewActivity> {
    private int P;
    protected Dialog Q;
    private List<String> R;
    private int L = -1;
    private String M = null;
    private boolean N = false;
    private final Boolean S = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102198", false));
    private final int T = 1;
    private final int U = 2;
    private final int V = 1;
    private final int W = 2;
    private final int X = 3;
    private final int Y = 4;
    private final int Z = 5;

    /* renamed from: a0, reason: collision with root package name */
    private final int f186133a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private final int f186134b0 = 2;

    /* renamed from: c0, reason: collision with root package name */
    private final int f186135c0 = 3;

    /* renamed from: d0, reason: collision with root package name */
    private final int f186136d0 = 4;

    /* renamed from: e0, reason: collision with root package name */
    private final int f186137e0 = 5;

    /* renamed from: f0, reason: collision with root package name */
    private final String f186138f0 = "op_result";

    /* renamed from: g0, reason: collision with root package name */
    private final String f186139g0 = "text_bottom_button_type";

    /* renamed from: h0, reason: collision with root package name */
    private d f186140h0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements ParticipleBottomMenuView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbsTextPreviewActivity f186144a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.textpreview.a f186145b;

        a(AbsTextPreviewActivity absTextPreviewActivity, com.tencent.qqnt.textpreview.a aVar) {
            this.f186144a = absTextPreviewActivity;
            this.f186145b = aVar;
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void a(String str) {
            BaseMenuUtil.copy(str, "OCR_Participle_copy");
            TextPreviewMenu.this.x(2);
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void b(String str) {
            com.tencent.mobileqq.textpreview.a.c(this.f186144a, str);
            TextPreviewMenu.this.x(3);
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void c(String str) {
            TextPreviewMenu.this.G(this.f186144a, str);
            TextPreviewMenu.this.x(5);
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void d(String str) {
            AbsTextPreviewActivity absTextPreviewActivity = this.f186144a;
            com.tencent.mobileqq.textpreview.a.b(absTextPreviewActivity, (QQAppInterface) absTextPreviewActivity.getAppRuntime(), str);
            TextPreviewMenu.this.x(4);
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void onCancelClick() {
            TextPreviewMenu.this.F();
            TextPreviewMenu.this.z(this.f186145b.d(), "pg_bas_highlight", Boolean.FALSE);
            TextPreviewMenu.this.x(1);
        }
    }

    /* loaded from: classes33.dex */
    class b extends d {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.participle.d
        public void a(boolean z16, List<String> list) {
            TextPreviewMenu.this.t();
            TextPreviewMenu.this.E(list);
        }
    }

    private void A(View view) {
        int i3;
        switch (view.getId()) {
            case R.id.let /* 2131366482 */:
                i3 = 2;
                break;
            case R.id.lib /* 2131369058 */:
                i3 = 3;
                break;
            case R.id.lif /* 2131369130 */:
                i3 = 5;
                break;
            case R.id.m9f /* 2131387930 */:
                i3 = 1;
                break;
            case R.id.f100885tp /* 2131390097 */:
                i3 = 4;
                break;
            default:
                i3 = 0;
                break;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("text_bottom_button_type", Integer.valueOf(i3));
        hashMap.put("cur_pg", s());
        com.tencent.mobileqq.activity.selectable.b.a("pg_bas_text_detail", "em_bas_text_bottom_button", hashMap);
    }

    private void B(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("text_bottom_button_type", Integer.valueOf(i3));
        hashMap.put("cur_pg", s());
        com.tencent.mobileqq.activity.selectable.b.b("pg_bas_highlight", "em_bas_text_bottom_button", hashMap);
    }

    private void C() {
        Activity activity = (Activity) this.C.get();
        if (activity != null) {
            Dialog dialog = this.Q;
            if (dialog == null) {
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(activity, HardCodeUtil.qqStr(R.string.u3i), false);
                this.Q = showLoadingDialog;
                showLoadingDialog.setOnCancelListener(new f(activity));
            } else {
                dialog.dismiss();
            }
            this.Q.show();
        }
    }

    private void D() {
        List<String> list = this.R;
        if (list != null && list.size() > 0) {
            E(this.R);
            return;
        }
        AbsTextPreviewActivity absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get();
        if (absTextPreviewActivity != null) {
            if (!NetworkUtil.isNetSupport(absTextPreviewActivity)) {
                QQToast.makeText(absTextPreviewActivity, HardCodeUtil.qqStr(R.string.u38), 0).show(absTextPreviewActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            } else {
                if (TextUtils.isEmpty(this.D)) {
                    return;
                }
                ((IParticipleApi) QRoute.api(IParticipleApi.class)).participleTheContent((AppInterface) absTextPreviewActivity.getAppRuntime(), this.D, this.M);
                C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        AbsTextPreviewActivity absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get();
        if (absTextPreviewActivity != null) {
            com.tencent.qqnt.textpreview.a I2 = absTextPreviewActivity.I2();
            I2.b().setVisibility(8);
            I2.d().setVisibility(8);
            I2.a().setVisibility(0);
            I2.getContainerView().setVisibility(0);
            absTextPreviewActivity.findViewById(R.id.ti5).setVisibility(0);
            if (absTextPreviewActivity.findViewById(R.id.ti5).getLayoutParams().height > 0) {
                absTextPreviewActivity.findViewById(R.id.acz).getLayoutParams().height = ViewUtils.dpToPx(16.0f);
            } else {
                absTextPreviewActivity.findViewById(R.id.acz).getLayoutParams().height = ViewUtils.dpToPx(50.0f);
            }
            q(absTextPreviewActivity, 135, 20);
        }
    }

    private void H(Intent intent) {
        AbsTextPreviewActivity absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get();
        if (absTextPreviewActivity != null) {
            absTextPreviewActivity.startActivityForResult(intent, -1);
        }
    }

    private void q(final AbsTextPreviewActivity absTextPreviewActivity, int i3, int i16) {
        final com.tencent.qqnt.textpreview.a I2 = absTextPreviewActivity.I2();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) I2.c().getLayoutParams();
        layoutParams.bottomMargin = BaseAIOUtils.f(i3, absTextPreviewActivity.getResources());
        float f16 = i16;
        layoutParams.leftMargin = BaseAIOUtils.f(f16, absTextPreviewActivity.getResources());
        layoutParams.rightMargin = BaseAIOUtils.f(f16, absTextPreviewActivity.getResources());
        I2.c().setLayoutParams(layoutParams);
        I2.c().post(new Runnable() { // from class: com.tencent.mobileqq.activity.selectable.TextPreviewMenu.3
            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout relativeLayout = (RelativeLayout) absTextPreviewActivity.findViewById(R.id.lyv);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.height = I2.c().getHeight();
                relativeLayout.setLayoutParams(layoutParams2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002a A[FALL_THROUGH, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int r(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 1006) {
                if (i3 != 3000) {
                    if (i3 != 10008 && i3 != 10010 && i3 != 1020 && i3 != 1021) {
                        switch (i3) {
                            default:
                                switch (i3) {
                                    default:
                                        switch (i3) {
                                            case 1023:
                                            case 1024:
                                            case 1025:
                                                break;
                                            default:
                                                return -2;
                                        }
                                    case 1008:
                                    case 1009:
                                    case 1010:
                                    case 1011:
                                        return 3;
                                }
                            case 1000:
                            case 1001:
                            case 1002:
                            case 1003:
                            case 1004:
                                break;
                        }
                    }
                } else {
                    return 4;
                }
            }
            return 3;
        }
        return 2;
    }

    private HashMap<String, Object> s() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("op_result", Integer.valueOf(this.S.booleanValue() ? 1 : 2));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Dialog dialog = this.Q;
        if (dialog != null) {
            dialog.setOnCancelListener(null);
            this.Q.dismiss();
        }
    }

    private void u(AbsTextPreviewActivity absTextPreviewActivity) {
        com.tencent.qqnt.textpreview.a I2 = absTextPreviewActivity.I2();
        I2.b().b(I2.d());
        I2.b().setOnMenuClickListener(new a(absTextPreviewActivity, I2));
        absTextPreviewActivity.findViewById(R.id.m9f).setOnClickListener(this);
        int F2 = absTextPreviewActivity.F2();
        if (F2 > 0 && QQSysFaceUtil.isRandomChainSticker(F2)) {
            absTextPreviewActivity.findViewById(R.id.let).setVisibility(8);
        } else {
            absTextPreviewActivity.findViewById(R.id.let).setOnClickListener(this);
        }
        if (F2 > 0) {
            absTextPreviewActivity.findViewById(R.id.lib).setVisibility(8);
            absTextPreviewActivity.findViewById(R.id.lif).setVisibility(8);
            absTextPreviewActivity.findViewById(R.id.f100885tp).setVisibility(8);
        } else {
            absTextPreviewActivity.findViewById(R.id.lib).setOnClickListener(this);
            absTextPreviewActivity.findViewById(R.id.lif).setOnClickListener(this);
            View findViewById = absTextPreviewActivity.findViewById(R.id.f100885tp);
            findViewById.setOnClickListener(this);
            findViewById.setVisibility(this.S.booleanValue() ? 0 : 8);
        }
        absTextPreviewActivity.findViewById(R.id.ti5).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("text_bottom_button_type", Integer.valueOf(i3));
        hashMap.put("cur_pg", s());
        com.tencent.mobileqq.activity.selectable.b.a("pg_bas_highlight", "em_bas_text_bottom_button", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view, String str, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put("op_result", Integer.valueOf(this.S.booleanValue() ? 1 : 2));
        if (bool.booleanValue()) {
            com.tencent.mobileqq.activity.selectable.b.c(view, str, hashMap);
        } else {
            com.tencent.mobileqq.activity.selectable.b.d(view, str, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.activity.selectable.a, com.tencent.qqnt.textpreview.inject.c
    public void b(PreviewTextContainerView previewTextContainerView) {
        super.b(previewTextContainerView);
        AbsTextPreviewActivity absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get();
        if (absTextPreviewActivity != null && absTextPreviewActivity.getAppRuntime() != null) {
            ((AppInterface) absTextPreviewActivity.getAppRuntime()).removeObserver(this.f186140h0);
        }
        t();
        z(previewTextContainerView, "pg_bas_text_detail", Boolean.FALSE);
    }

    @Override // com.tencent.mobileqq.activity.selectable.a
    protected void j(PreviewTextContainerView previewTextContainerView, View view) {
        super.j(previewTextContainerView, view);
        ReportController.o(this.f186154m.get(), "dc00898", "", "", "0X8009EFF", "0X8009EFF", r(this.P), 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.selectable.a, com.tencent.qqnt.textpreview.inject.c
    public boolean onBackPress() {
        AbsTextPreviewActivity absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get();
        if (absTextPreviewActivity != null) {
            com.tencent.qqnt.textpreview.a I2 = absTextPreviewActivity.I2();
            r1 = I2.d().getVisibility() == 0;
            if (r1) {
                F();
                z(I2.d(), "pg_bas_highlight", Boolean.FALSE);
            }
        }
        return r1;
    }

    @Override // com.tencent.mobileqq.activity.selectable.a, com.tencent.qqnt.textpreview.inject.c
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void a(AbsTextPreviewActivity absTextPreviewActivity, PreviewTextContainerView previewTextContainerView) {
        super.a(absTextPreviewActivity, previewTextContainerView);
        this.L = absTextPreviewActivity.getUinType();
        this.M = absTextPreviewActivity.G2();
        this.N = absTextPreviewActivity.J2();
        this.P = absTextPreviewActivity.H2();
        u(absTextPreviewActivity);
        ((AppInterface) absTextPreviewActivity.getAppRuntime()).addObserver(this.f186140h0);
        z(previewTextContainerView, "pg_bas_text_detail", Boolean.TRUE);
    }

    /* loaded from: classes33.dex */
    public static final class ProgressView extends FrameLayout {

        /* renamed from: d, reason: collision with root package name */
        private TextView f186143d;

        public ProgressView(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            LayoutInflater.from(context).inflate(R.layout.baj, this);
            this.f186143d = (TextView) findViewById(R.id.jfb);
            findViewById(R.id.f164600a83).setBackgroundColor(Color.parseColor("#1c1c1d"));
        }

        public ProgressView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            a(context);
        }

        public void setProgressText(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 0) {
                this.f186143d.setVisibility(0);
                this.f186143d.setText(charSequence);
            } else {
                this.f186143d.setVisibility(8);
            }
        }
    }

    private void y() {
        B(1);
        B(2);
        B(3);
        B(4);
        B(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<String> list) {
        if (list != null && list.size() > 0) {
            this.R = list;
            AbsTextPreviewActivity absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get();
            if (absTextPreviewActivity != null) {
                com.tencent.qqnt.textpreview.a I2 = absTextPreviewActivity.I2();
                I2.getContainerView().setVisibility(8);
                I2.a().setVisibility(8);
                absTextPreviewActivity.findViewById(R.id.ti5).setVisibility(4);
                absTextPreviewActivity.findViewById(R.id.acz).getLayoutParams().height = ViewUtils.dpToPx(50.0f);
                I2.d().setParticipleItems(list);
                I2.d().R();
                I2.b().a();
                q(absTextPreviewActivity, 60, 10);
                z(I2.d(), "pg_bas_highlight", Boolean.TRUE);
                y();
                return;
            }
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.u3h), 0).show();
    }

    @Override // com.tencent.mobileqq.activity.selectable.a, android.view.View.OnClickListener
    public void onClick(View view) {
        AppRuntime appRuntime = this.f186154m.get();
        AbsTextPreviewActivity absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get();
        A(view);
        boolean z16 = true;
        switch (view.getId()) {
            case R.id.ti5 /* 2131364796 */:
                if (absTextPreviewActivity != null) {
                    absTextPreviewActivity.K2(R.id.ti5, null);
                    break;
                } else {
                    QLog.e("TextPreviewMenu", 1, "activity is null, so activity.onClickFontSettingBtn not invoke");
                    break;
                }
            case R.id.bbi /* 2131366582 */:
                z16 = false;
            case R.id.let /* 2131366482 */:
                v(absTextPreviewActivity, appRuntime, null, z16);
                break;
            case R.id.c39 /* 2131368247 */:
                ECommerceDataReportUtil.h(appRuntime, null, 4);
                if (appRuntime != null) {
                    com.tencent.mobileqq.textpreview.a.b((Activity) view.getContext(), (QQAppInterface) appRuntime, f());
                }
                ReportController.o(appRuntime, "dc00898", "", "", "0X8009F02", "0X8009F02", 0, 0, "", "", "", "");
                break;
            case R.id.lib /* 2131369058 */:
                D();
                if (absTextPreviewActivity != null) {
                    ReportController.o(absTextPreviewActivity.getAppRuntime(), "dc00898", "", "", "0X800A357", "0X800A357", 1, 0, "", "", "", "");
                    break;
                } else {
                    QLog.e("TextPreviewMenu", 1, "activity is null, so ReportController.reportClickEvent not invoke");
                    break;
                }
            case R.id.lif /* 2131369130 */:
                if (absTextPreviewActivity != null) {
                    absTextPreviewActivity.K2(R.id.lif, null);
                    break;
                } else {
                    QLog.e("TextPreviewMenu", 1, "activity is null, so activity.onClickFontSettingBtn not invoke");
                    break;
                }
            case R.id.cjs /* 2131369204 */:
                ECommerceDataReportUtil.h(appRuntime, null, 3);
                int F2 = absTextPreviewActivity.F2();
                if (F2 >= 0) {
                    com.tencent.mobileqq.textpreview.a.d((Activity) view.getContext(), f(), F2);
                } else {
                    com.tencent.mobileqq.textpreview.a.c((Activity) view.getContext(), f());
                }
                ReportController.o(appRuntime, "dc00898", "", "", "0X8009F01", "0X8009F01", 0, 0, "", "", "", "");
                break;
            case R.id.i7f /* 2131385641 */:
                if (absTextPreviewActivity != null) {
                    absTextPreviewActivity.setResult(ITeamWorkDocEditBrowserProxy.REQUEST_CODE_OPEN_TEAM_WORK_EDIT_BROWSER, absTextPreviewActivity.getIntent());
                    absTextPreviewActivity.finish();
                    ReportController.o(appRuntime, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 4, 0, "", "", "", "");
                    break;
                }
                break;
            case R.id.ilw /* 2131386961 */:
                com.tencent.qqnt.selectable.a.C().n(null);
                break;
            case R.id.m9e /* 2131387929 */:
            case R.id.m9f /* 2131387930 */:
                if (absTextPreviewActivity != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("content", f());
                    absTextPreviewActivity.K2(R.id.m9e, bundle);
                    ReportController.o(appRuntime, "dc00898", "", "", "0X800A1D1", "0X800A1D1", 5, 0, "", "", "", "");
                    break;
                }
                break;
            case R.id.f100885tp /* 2131390097 */:
                G(absTextPreviewActivity, f());
                break;
        }
        if (view.getId() == R.id.ilw || !com.tencent.qqnt.selectable.a.C().isSelected()) {
            return;
        }
        com.tencent.qqnt.selectable.a.C().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(Activity activity, String str) {
        if (activity == null) {
            QLog.e("TextPreviewMenu", 1, "activity is null, so activity.onClickTransBtn not invoke");
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) TextPreviewTranslateActivity.class);
        intent.putExtra("TranslateText", str);
        intent.putExtra("WhereAreYouFrom", "AIO_TEXTPREVIEW");
        H(intent);
    }

    @Override // com.tencent.mobileqq.activity.selectable.a
    protected void h(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        AbsTextPreviewActivity absTextPreviewActivity;
        aVar.b(R.id.bbi, HardCodeUtil.qqStr(R.string.u3c), R.drawable.cb5);
        aVar.b(R.id.cjs, HardCodeUtil.qqStr(R.string.u3a), R.drawable.cbd);
        int i3 = this.L;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 3000 && (absTextPreviewActivity = (AbsTextPreviewActivity) this.C.get()) != null && absTextPreviewActivity.getAppRuntime() != null && !this.M.equals(absTextPreviewActivity.getAppRuntime().getCurrentAccountUin())) {
                aVar.b(R.id.i7f, HardCodeUtil.qqStr(R.string.u3b), R.drawable.cbh);
            }
        } else if (!this.N && this.P != -2) {
            aVar.b(R.id.i7f, HardCodeUtil.qqStr(R.string.u3j), R.drawable.cbh);
        }
        aVar.b(R.id.c39, HardCodeUtil.qqStr(R.string.u3d), R.drawable.cbc);
    }

    private void v(Activity activity, AppRuntime appRuntime, MessageRecord messageRecord, boolean z16) {
        ECommerceDataReportUtil.h(appRuntime, messageRecord, 2);
        try {
            BaseMenuUtil.copy(f(), "TextPreview");
            if (z16) {
                ReportController.o(appRuntime, "dc00898", "", "", "0X800A356", "0X800A356", 0, 0, "", "", "", "");
            } else {
                ReportController.o(appRuntime, "dc00898", "", "", "0X8009F00", "0X8009F00", 0, 0, "", "", "", "");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TextPreviewMenu", 2, e16.toString());
            }
        }
    }
}
