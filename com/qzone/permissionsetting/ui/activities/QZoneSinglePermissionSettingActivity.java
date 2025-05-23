package com.qzone.permissionsetting.ui.activities;

import a8.b;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.business.result.QZoneResult;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;

/* loaded from: classes39.dex */
public class QZoneSinglePermissionSettingActivity extends QZoneTitleBarFragmentV2 {

    /* renamed from: h0, reason: collision with root package name */
    private long f49129h0;

    /* renamed from: i0, reason: collision with root package name */
    private x6.a f49130i0;

    /* renamed from: j0, reason: collision with root package name */
    private b f49131j0;

    /* renamed from: k0, reason: collision with root package name */
    private a8.a f49132k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f49133l0;

    /* renamed from: m0, reason: collision with root package name */
    private Switch f49134m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f49135n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f49136o0;

    /* renamed from: p0, reason: collision with root package name */
    private Switch f49137p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f49138q0 = false;

    /* renamed from: r0, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f49139r0 = new a();

    /* loaded from: classes39.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!NetworkState.isNetSupport()) {
                QZoneSinglePermissionSettingActivity.this.pi();
            } else {
                int id5 = compoundButton.getId();
                if (id5 == R.id.fl_) {
                    QZoneSinglePermissionSettingActivity.this.wi(z16);
                } else if (id5 == R.id.fl6) {
                    QZoneSinglePermissionSettingActivity.this.vi(z16);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    private boolean P2() {
        return this.f49129h0 != LoginData.getInstance().getUin();
    }

    private int mi() {
        x6.a aVar = this.f49130i0;
        return (aVar == null || aVar.gender != 0) ? (aVar == null || aVar.gender != 1) ? R.string.h0j : R.string.h0b : R.string.h0h;
    }

    private int ni() {
        x6.a aVar = this.f49130i0;
        return (aVar == null || aVar.gender != 0) ? (aVar == null || aVar.gender != 1) ? R.string.b0y : R.string.b0w : R.string.b0x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneSinglePermissionSettingActivity.this.toast(R.string.f173117hh4, 4);
                QZoneSinglePermissionSettingActivity.this.zi();
            }
        }, 3000L);
    }

    private boolean qi() {
        return P2() && y6.b.d(this.f49130i0);
    }

    private void ri() {
        z5.a f16 = z5.a.f();
        if (f16 != null) {
            f16.q(this.f49129h0, getHandler());
        }
    }

    private void ti() {
        if (this.f49138q0) {
            setResult(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(boolean z16) {
        x6.a aVar;
        if (!P2() || (aVar = this.f49130i0) == null || this.f49131j0 == null) {
            return;
        }
        boolean z17 = aVar.isBlocked;
        if (z17 && z16) {
            return;
        }
        if (z17 || z16) {
            this.f49132k0 = new a8.a(this.f49129h0, this.f49130i0.name);
            xi(z16);
            if (z16) {
                this.f49131j0.E(LoginData.getInstance().getUin(), this.f49132k0, getHandler());
            } else {
                this.f49131j0.b0(LoginData.getInstance().getUin(), this.f49132k0, getHandler());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(boolean z16) {
        x6.a aVar;
        if (!P2() || (aVar = this.f49130i0) == null || this.f49131j0 == null) {
            return;
        }
        boolean z17 = aVar.isExcluded;
        if (z17 && z16) {
            return;
        }
        if (z17 || z16) {
            this.f49132k0 = new a8.a(this.f49129h0, this.f49130i0.name);
            yi(z16);
            if (z16) {
                this.f49131j0.H(LoginData.getInstance().getUin(), this.f49132k0, getHandler());
            } else {
                this.f49131j0.e0(LoginData.getInstance().getUin(), this.f49132k0, getHandler());
            }
        }
    }

    private void xi(boolean z16) {
        Switch r06 = this.f49137p0;
        if (r06 == null) {
            return;
        }
        if (z16) {
            r06.setContentDescription(getText(R.string.gqd));
        } else {
            r06.setContentDescription(getText(R.string.gqc));
        }
    }

    private void yi(boolean z16) {
        Switch r06 = this.f49134m0;
        if (r06 == null) {
            return;
        }
        if (z16) {
            r06.setContentDescription(getText(R.string.gqj));
        } else {
            r06.setContentDescription(getText(R.string.gqi));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        x6.a aVar = this.f49130i0;
        if (aVar != null) {
            ui(this.f49134m0, aVar.isExcluded);
            ui(this.f49137p0, aVar.isBlocked);
            yi(aVar.isExcluded);
            xi(aVar.isBlocked);
            this.f49133l0.setVisibility(qi() ? 0 : 8);
            this.f49135n0.setText(getString(ni()));
            this.f49136o0.setText(getString(mi()));
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    protected boolean Hh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    public void Wh(Intent intent) {
        TextView textView = this.C;
        if (textView == null || !(textView instanceof TextView) || intent == null || intent.getExtras() == null) {
            return;
        }
        this.C.setText("");
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ti();
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean onBackPress() {
        ti();
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        onServiceResult(QZoneResult.unpack(message));
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        si(bundle);
        final z5.a f16 = z5.a.f();
        if (f16 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneSinglePermissionSettingActivity qZoneSinglePermissionSettingActivity = QZoneSinglePermissionSettingActivity.this;
                    qZoneSinglePermissionSettingActivity.f49130i0 = f16.g(qZoneSinglePermissionSettingActivity.f49129h0);
                }
            });
        }
        initUI();
        zi();
        this.f49131j0 = b.O();
        if (f16 != null) {
            ri();
        }
    }

    protected void si(Bundle bundle) {
        if (bundle != null) {
            this.f49129h0 = bundle.getLong("qqid", 0L);
        } else {
            this.f49129h0 = getIntent().getLongExtra("qqid", 0L);
        }
        if (this.f49129h0 == 0) {
            this.f49129h0 = LoginData.getInstance().getUin();
        }
    }

    private void ui(Switch r26, boolean z16) {
        r26.setOnCheckedChangeListener(null);
        r26.setChecked(z16);
        r26.setOnCheckedChangeListener(this.f49139r0);
    }

    private void oi(QZoneResult qZoneResult) {
        x6.a aVar;
        if (qZoneResult == null || !qZoneResult.getSucceed() || (aVar = (x6.a) qZoneResult.getData()) == null) {
            return;
        }
        this.f49130i0 = aVar;
        zi();
    }

    private void initUI() {
        setTitle(R.string.f173020gj0);
        this.D.setMaxWidth(R.dimen.f158708mx);
        setLeftButton(R.string.f170549u3, null);
        this.f49133l0 = findViewById(R.id.fla);
        this.f49134m0 = (Switch) findViewById(R.id.fl_);
        this.f49135n0 = (TextView) findViewById(R.id.bzg);
        this.f49134m0.setOnCheckedChangeListener(this.f49139r0);
        this.f49137p0 = (Switch) findViewById(R.id.fl6);
        this.f49136o0 = (TextView) findViewById(R.id.f164616ab4);
        this.f49137p0.setOnCheckedChangeListener(this.f49139r0);
        this.f49133l0.setVisibility(qi() ? 0 : 8);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment
    public void IOnSetTheme() {
        setTheme(R.style.f173580gi);
        com.tencent.mobileqq.theme.a.f(getWindow());
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.brc, viewGroup);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected void onServiceResult(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        switch (qZoneResult.what) {
            case 999924:
                oi(qZoneResult);
                return;
            case 999983:
            case 999984:
                if (qZoneResult.getSucceed()) {
                    x6.a aVar = this.f49130i0;
                    if (aVar != null) {
                        boolean z16 = !aVar.isExcluded;
                        aVar.isExcluded = z16;
                        if (z16) {
                            toast(getString(R.string.gof), 5);
                        } else {
                            toast(getString(R.string.i_y), 5);
                        }
                        z5.a f16 = z5.a.f();
                        if (f16 != null) {
                            f16.t(this.f49130i0);
                        }
                    }
                    this.f49138q0 = true;
                } else if (qZoneResult.getMessage() != null && qZoneResult.getMessage().length() > 0) {
                    toast(qZoneResult.getMessage(), 4);
                } else if (this.f49130i0 != null) {
                    toast(R.string.f173117hh4, 4);
                }
                zi();
                return;
            case 999987:
            case 999988:
                if (qZoneResult.getSucceed()) {
                    x6.a aVar2 = this.f49130i0;
                    if (aVar2 != null) {
                        boolean z17 = aVar2.isBlocked;
                        aVar2.isBlocked = !z17;
                        if (z17) {
                            toast(getString(R.string.i_y), 5);
                        } else {
                            toast(getString(R.string.gof), 5);
                        }
                        final z5.a f17 = z5.a.f();
                        if (f17 != null) {
                            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    f17.t(QZoneSinglePermissionSettingActivity.this.f49130i0);
                                }
                            });
                        }
                    }
                    this.f49138q0 = true;
                } else if (qZoneResult.getMessage() != null && qZoneResult.getMessage().length() > 0) {
                    toast(qZoneResult.getMessage(), 4);
                } else if (this.f49130i0 != null) {
                    toast(R.string.f173117hh4, 4);
                }
                zi();
                return;
            default:
                return;
        }
    }
}
