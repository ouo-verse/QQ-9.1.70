package com.tencent.biz.qrcode.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qrcode.logindev.NTLoginDeviceManagerHandler;
import com.tencent.biz.qrcode.logindev.pclock.LockPCServiceHandler;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.api.IExportFileService;
import com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.widget.Switch;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import rd0.e;
import rd0.g;
import rd0.k;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QRLoginMgrActivity extends BaseActivity implements View.OnClickListener, e.f {

    /* renamed from: v0, reason: collision with root package name */
    private static final a.b f94762v0 = new a.b(0.7f, 0.5f, 0.3f, 0.5f, 0.0f);

    /* renamed from: w0, reason: collision with root package name */
    private static final String f94763w0 = HardCodeUtil.qqStr(R.string.voj) + "\uff0c" + HardCodeUtil.qqStr(R.string.f216875zh);

    /* renamed from: c0, reason: collision with root package name */
    private TextView f94766c0;

    /* renamed from: d0, reason: collision with root package name */
    private QUIPolarLightView f94767d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f94768e0;

    /* renamed from: f0, reason: collision with root package name */
    private QQProAvatarView f94769f0;

    /* renamed from: g0, reason: collision with root package name */
    private ListView f94770g0;

    /* renamed from: h0, reason: collision with root package name */
    private Switch f94771h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f94772i0;

    /* renamed from: m0, reason: collision with root package name */
    private rd0.e f94776m0;

    /* renamed from: n0, reason: collision with root package name */
    private QQProgressDialog f94777n0;

    /* renamed from: o0, reason: collision with root package name */
    private rd0.g f94778o0;

    /* renamed from: p0, reason: collision with root package name */
    private Context f94779p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f94780q0;

    /* renamed from: r0, reason: collision with root package name */
    private long f94781r0;

    /* renamed from: a0, reason: collision with root package name */
    private final List<Integer> f94764a0 = Arrays.asList(-4428, -344833, -4540161, -4338945, -6033153, -786433);

    /* renamed from: b0, reason: collision with root package name */
    private final List<Integer> f94765b0 = Arrays.asList(-16169079, -13026376, -10339966, -9224591, -8369834, -8362166);

    /* renamed from: j0, reason: collision with root package name */
    private MqqHandler f94773j0 = ThreadManager.getUIHandler();

    /* renamed from: k0, reason: collision with root package name */
    private ConcurrentHashMap<Long, rd0.f> f94774k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    private Set<Long> f94775l0 = null;

    /* renamed from: s0, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f94782s0 = new f();

    /* renamed from: t0, reason: collision with root package name */
    private g.c f94783t0 = new AnonymousClass7();

    /* renamed from: u0, reason: collision with root package name */
    private ar f94784u0 = new i();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qrcode.activity.QRLoginMgrActivity$7, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass7 implements g.c {
        AnonymousClass7() {
        }

        @Override // rd0.g.c
        public void d0(final List<rd0.f> list) {
            QRLoginMgrActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.7.1
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    List list2 = list;
                    if (list2 != null && list2.size() != 0) {
                        if (QRLoginMgrActivity.this.f94776m0 != null) {
                            QRLoginMgrActivity.this.f94776m0.p(list);
                        }
                        TextView textView = QRLoginMgrActivity.this.f94766c0;
                        if (list.size() == 1) {
                            i3 = 8;
                        } else {
                            i3 = 0;
                        }
                        textView.setVisibility(i3);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QRLoginMgrActivity.this.f94778o0 != null) {
                                    QRLoginMgrActivity.this.f94778o0.t();
                                }
                            }
                        }, 128, null, true);
                        return;
                    }
                    QRLoginMgrActivity.this.finish();
                }
            });
        }

        @Override // rd0.g.c
        public void p0(final List<rd0.f> list) {
            QRLoginMgrActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.7.2
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    List list2 = list;
                    if (list2 != null && list2.size() != 0) {
                        if (QRLoginMgrActivity.this.f94776m0 != null) {
                            QRLoginMgrActivity.this.f94776m0.p(list);
                        }
                        TextView textView = QRLoginMgrActivity.this.f94766c0;
                        if (list.size() == 1) {
                            i3 = 8;
                        } else {
                            i3 = 0;
                        }
                        textView.setVisibility(i3);
                        return;
                    }
                    QRLoginMgrActivity.this.finish();
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rd0.f f94803a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f94804b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f94805c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f94806d;

        b(rd0.f fVar, int i3, String str, String str2) {
            this.f94803a = fVar;
            this.f94804b = i3;
            this.f94805c = str;
            this.f94806d = str2;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QRLoginMgrActivity.this.Y2(this.f94803a, this.f94804b, this.f94805c, this.f94806d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rd0.f f94808d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CheckBox f94809e;

        c(rd0.f fVar, CheckBox checkBox) {
            this.f94808d = fVar;
            this.f94809e = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ReportController.o(null, "dc00898", "", "", "0X800C456", "0X800C456", this.f94808d.f431099d, 0, "", "", "", "");
            QRLoginMgrActivity.this.d3(this.f94809e, this.f94808d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f94812d;

        e(View view) {
            this.f94812d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QRLoginMgrActivity.this.f94771h0.setChecked(!QRLoginMgrActivity.this.f94771h0.isChecked());
            AccessibilityUtil.q(this.f94812d, QRLoginMgrActivity.f94763w0, QRLoginMgrActivity.this.f94771h0.isChecked());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements CompoundButton.OnCheckedChangeListener {

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ((RegisterProxySvcPackHandler) QRLoginMgrActivity.this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a3(true);
                ReportController.o(null, "dc00898", "", "", "0X800A476", "0X800A476", 0, 0, "", "", "", "");
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class b implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CompoundButton f94816d;

            b(CompoundButton compoundButton) {
                this.f94816d = compoundButton;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                this.f94816d.setChecked(true);
            }
        }

        f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (QLog.isColorLevel()) {
                QLog.d("QRLoginMgrActivity", 2, "qqmute onCheckedChanged:", Boolean.valueOf(z16));
            }
            if (!NetworkUtil.isNetworkAvailable(QRLoginMgrActivity.this)) {
                QQToast.makeText(QRLoginMgrActivity.this.f94779p0, 1, R.string.dqp, 0).show(QRLoginMgrActivity.this.getTitleBarHeight());
                compoundButton.setChecked(!z16);
            } else if (!z16) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(QRLoginMgrActivity.this.f94779p0, 230);
                createCustomDialog.setTitle(R.string.voi);
                createCustomDialog.setMessage(R.string.voh);
                createCustomDialog.setPositiveButton(R.string.f171151ok, new a());
                createCustomDialog.setNegativeButton(R.string.cancel, new b(compoundButton));
                createCustomDialog.show();
                ReportController.o(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
            } else {
                ((RegisterProxySvcPackHandler) QRLoginMgrActivity.this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a3(false);
            }
            if (ab.a() && AppSetting.f99565y) {
                AccessibilityUtil.q(QRLoginMgrActivity.this.f94772i0, QRLoginMgrActivity.f94763w0, QRLoginMgrActivity.this.f94771h0.isChecked());
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QRLoginMgrActivity.this.Z2(true, 0L, -1);
            ReportController.o(null, "dc00898", "", "", "0X800A478", "0X800A478", 0, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class i extends ar {
        i() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onKickOutDevFResult(boolean z16, long j3, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d("QRLoginMgrActivity", 2, "onKickOutDevFResult isSuccess:", Boolean.valueOf(z16), " appid:", Long.valueOf(j3), " result:", Integer.valueOf(i3), " index:", Integer.valueOf(i16));
            }
            if (!z16) {
                if (QRLoginMgrActivity.this.f94775l0 == null) {
                    QRLoginMgrActivity.this.f94775l0 = new HashSet();
                }
                QRLoginMgrActivity.this.f94775l0.add(Long.valueOf(j3));
            }
            if (QRLoginMgrActivity.this.f94774k0 != null) {
                QRLoginMgrActivity.this.f94774k0.remove(Long.valueOf(j3));
            }
            if (QRLoginMgrActivity.this.f94774k0 == null || QRLoginMgrActivity.this.f94774k0.size() == 0) {
                QRLoginMgrActivity.this.hideProgerssDialog();
                QRLoginMgrActivity.this.finish();
                if (QRLoginMgrActivity.this.f94775l0 != null && QRLoginMgrActivity.this.f94775l0.size() > 0) {
                    QQToast.makeText(QRLoginMgrActivity.this.getApplicationContext(), 1, R.string.vob, 0).show();
                    return;
                }
                QQToast.makeText(QRLoginMgrActivity.this.getApplicationContext(), 2, R.string.voc, 0).show();
                Intent intent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
                intent.putExtra("status", "logout");
                QRLoginMgrActivity.this.getApplicationContext().sendBroadcast(intent);
                return;
            }
            if (i16 == 100) {
                QRLoginMgrActivity.this.hideProgerssDialog();
                if (z16) {
                    QQToast.makeText(QRLoginMgrActivity.this.getApplicationContext(), 2, R.string.g2m, 0).show();
                } else {
                    QQToast.makeText(QRLoginMgrActivity.this.getApplicationContext(), 1, R.string.vob, 0).show();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class j implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rd0.f f94821d;

        j(rd0.f fVar) {
            this.f94821d = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QRLoginMgrActivity qRLoginMgrActivity = QRLoginMgrActivity.this;
            rd0.f fVar = this.f94821d;
            qRLoginMgrActivity.Z2(false, fVar.f431096a, fVar.f431103h);
            ReportController.o(null, "dc00898", "", "", "0X800A474", "0X800A474", this.f94821d.f431099d, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2(rd0.f fVar, int i3, String str, String str2) {
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "devItem.mDeviceAppid is " + fVar.f431096a + " ,devItem.mDeviceType is " + fVar.f431097b + " ,deviceTypeForNewMyComputer is " + i3 + " ,deviceUinForNewMyComputer is " + str + " ,deviceUidForNewMyComputer is " + str2);
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByQRLoginMyComputer(this, "qrlogin_appid", fVar.f431096a, 2, i3, str, str2);
        ReportController.o(null, "dc00898", "", "", "0X800A472", "0X800A472", fVar.f431099d, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(boolean z16, long j3, int i3) {
        showProgressDialog(1);
        Set<Long> set = this.f94775l0;
        if (set != null) {
            set.clear();
            this.f94775l0 = null;
        }
        if (this.f94774k0 == null) {
            this.f94774k0 = new ConcurrentHashMap<>();
        }
        this.f94774k0.clear();
        for (rd0.f fVar : this.f94776m0.k()) {
            this.f94774k0.put(Long.valueOf(fVar.f431096a), fVar);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QRLoginMgrActivity", 2, "confirmQRLogout allLogout:", Boolean.valueOf(z16), " appid:", Long.valueOf(j3), " size:", Integer.valueOf(this.f94774k0.size()), " platform: ", Integer.valueOf(i3));
        }
        if (z16) {
            Iterator<Long> it = this.f94774k0.keySet().iterator();
            while (it.hasNext()) {
                if (!EquipmentLockImpl.o().w(this.app, it.next().longValue(), (byte) 0, new byte[0], 101)) {
                    hideProgerssDialog();
                    QQToast.makeText(getApplicationContext(), 1, R.string.vob, 0).show();
                    return;
                }
            }
            ((IExportFileService) QRoute.api(IExportFileService.class)).disconnect();
            return;
        }
        if (!EquipmentLockImpl.o().w(this.app, j3, (byte) 0, new byte[0], 100)) {
            hideProgerssDialog();
            QQToast.makeText(getApplicationContext(), 1, R.string.vob, 0).show();
        } else if (i3 == 1029 || i3 == 1024 || i3 == 1031 || i3 == 1035) {
            ((IExportFileService) QRoute.api(IExportFileService.class)).disconnect();
        }
    }

    private void b3() {
        rd0.g gVar = (rd0.g) this.app.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
        this.f94778o0 = gVar;
        gVar.n(this.f94783t0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(final CheckBox checkBox, final rd0.f fVar) {
        ((NTLoginDeviceManagerHandler) this.app.getBusinessHandler(NTLoginDeviceManagerHandler.class.getName())).K2(fVar.f431105j, !checkBox.isChecked(), new k() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.15
            @Override // rd0.k, rd0.j
            public void b(boolean z16, @Nullable Object obj) {
                if (z16) {
                    QRLoginMgrActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            checkBox.setChecked(!r0.isChecked());
                            AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                            fVar.f431105j.f431117e = checkBox.isChecked();
                            QLog.d("QRLoginMgrActivity", 1, "onUpdateAutoLoginSwitchRsp success, checkbox = " + checkBox.isChecked());
                        }
                    });
                } else {
                    QLog.d("QRLoginMgrActivity", 1, "onUpdateAutoLoginSwitchRsp failed.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgerssDialog() {
        this.f94773j0.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QRLoginMgrActivity.this.f94777n0 != null && QRLoginMgrActivity.this.f94777n0.isShowing()) {
                        QRLoginMgrActivity.this.f94777n0.dismiss();
                        QRLoginMgrActivity.this.f94777n0.cancel();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                QRLoginMgrActivity.this.f94777n0 = null;
            }
        });
    }

    private void initBackground() {
        Drawable drawable = getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f30520ok);
        if (QQTheme.isVasTheme()) {
            viewGroup.setBackground(drawable);
            return;
        }
        QUIPolarLightView qUIPolarLightView = (QUIPolarLightView) findViewById(R.id.f26270d3);
        this.f94767d0 = qUIPolarLightView;
        qUIPolarLightView.setVisibility(0);
        this.f94767d0.getLayoutParams().height = (int) (ViewUtils.getScreenHeight() * 0.6d);
        this.f94767d0.getPolarLightRender().p(0.025f);
        this.f94767d0.getPolarLightRender().r(0.5f);
        PolarImageRender polarLightRender = this.f94767d0.getPolarLightRender();
        a.b bVar = f94762v0;
        polarLightRender.q(bVar);
        if (QQTheme.isNowThemeIsNight()) {
            this.f94767d0.getPolarLightRender().s(this.f94765b0);
        } else {
            this.f94767d0.getPolarLightRender().s(this.f94764a0);
        }
        this.f94767d0.getPolarLightRender().q(bVar);
    }

    private void initListView() {
        this.f94770g0 = (ListView) findViewById(R.id.lfo);
        rd0.e eVar = new rd0.e();
        this.f94776m0 = eVar;
        eVar.q(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.c_u, (ViewGroup) null);
        this.f94771h0 = (Switch) inflate.findViewById(R.id.lwv);
        this.f94771h0.setChecked(!SettingCloneUtil.readValue((Context) this, this.app.getCurrentUin(), (String) null, AppConstants.QQSETTING_QRLOGIN_SET_MUTE, false));
        this.f94771h0.setOnCheckedChangeListener(this.f94782s0);
        this.f94770g0.addFooterView(inflate);
        this.f94776m0.r(this.f94770g0);
        this.f94770g0.setAdapter((ListAdapter) this.f94776m0);
        inflate.setVisibility(0);
        this.f94772i0 = inflate;
        if (ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.n(this.f94771h0, false);
            AccessibilityUtil.n(this.f94772i0.findViewById(R.id.f110356ia), false);
            AccessibilityUtil.n(this.f94772i0.findViewById(R.id.f110346i_), false);
            AccessibilityUtil.n(this.f94772i0.findViewById(R.id.eeh), false);
            AccessibilityUtil.q(this.f94772i0, f94763w0, this.f94771h0.isChecked());
            this.f94772i0.setOnClickListener(new e(inflate));
        }
    }

    private void initUI() {
        setContentView(R.layout.aci);
        this.f94768e0 = (TextView) findViewById(R.id.f9_);
        this.f94769f0 = (QQProAvatarView) findViewById(R.id.c0s);
        TextView textView = (TextView) findViewById(R.id.lyb);
        this.f94766c0 = textView;
        textView.setOnClickListener(this);
        findViewById(R.id.lpm).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.activity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRLoginMgrActivity.this.c3(view);
            }
        });
        initBackground();
        initListView();
    }

    private void showProgressDialog(final int i3) {
        this.f94773j0.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!QRLoginMgrActivity.this.isFinishing()) {
                        if (QRLoginMgrActivity.this.f94777n0 != null && QRLoginMgrActivity.this.f94777n0.isShowing()) {
                            QRLoginMgrActivity.this.f94777n0.dismiss();
                            QRLoginMgrActivity.this.f94777n0.cancel();
                            QRLoginMgrActivity.this.f94777n0 = null;
                        }
                        QRLoginMgrActivity.this.f94777n0 = new QQProgressDialog(QRLoginMgrActivity.this.f94779p0, QRLoginMgrActivity.this.getTitleBarHeight());
                        QRLoginMgrActivity.this.f94777n0.setMessage(R.string.f173059h05);
                        if (i3 == 1) {
                            QRLoginMgrActivity.this.f94777n0.setMessage(R.string.cpr);
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (QRLoginMgrActivity.this.f94777n0 != null && !QRLoginMgrActivity.this.f94777n0.isShowing()) {
                    QRLoginMgrActivity.this.f94777n0.show();
                }
            }
        });
    }

    @Override // rd0.e.f
    public void I1(rd0.f fVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QRLoginMgrActivity", 2, "onCloseClick type:", Integer.valueOf(fVar.f431097b));
        }
        if (!NetworkUtil.isNetworkAvailable(this)) {
            QQToast.makeText(this.f94779p0, 1, R.string.dqp, 0).show(getTitleBarHeight());
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        String string = getString(R.string.f216715z2, fVar.f431100e);
        String string2 = getString(R.string.f216705z1);
        createCustomDialog.setTitle(string);
        createCustomDialog.setMessage(string2);
        createCustomDialog.setPositiveButton(R.string.f171151ok, new j(fVar));
        createCustomDialog.setNegativeButton(R.string.cancel, new a());
        createCustomDialog.show();
        ReportController.o(null, "dc00898", "", "", "0X800A473", "0X800A473", fVar.f431099d, 0, "", "", "", "");
    }

    @Override // rd0.e.f
    public void K(final rd0.f fVar) {
        int i3;
        int i16;
        int i17;
        QLog.d("QRLoginMgrActivity", 1, "onUnlockClick ");
        final int i18 = fVar.f431106k;
        if (i18 == 2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C5CA", "0X800C5CA", 0, 0, String.valueOf(i3), "", "", "");
        final rd0.g gVar = (rd0.g) qQAppInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
        boolean z16 = false;
        if (!NetworkUtil.isNetworkAvailable(this)) {
            if (i18 == 2) {
                i17 = R.string.f21707601;
            } else {
                i17 = R.string.f216765z7;
            }
            QQToast.makeText(this, getString(i17), 0).show();
            QLog.e("QRLoginMgrActivity", 1, "network is unAvailable!");
            return;
        }
        if (i18 == 2) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        gVar.s(fVar.f431096a, i16);
        LockPCServiceHandler lockPCServiceHandler = (LockPCServiceHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOCK_PC);
        if (i16 == 2) {
            z16 = true;
        }
        final int i19 = i16;
        lockPCServiceHandler.D2(z16, (int) fVar.f431096a, new com.tencent.biz.qrcode.logindev.pclock.g() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.14
            @Override // com.tencent.biz.qrcode.logindev.pclock.g
            public void onResult(int i26, @NonNull String str) {
                QLog.d("QRLoginMgrActivity", 1, "requestUpdateLockPCStatus onResult " + i26 + " errorMsg :" + str);
                if (i26 != 0) {
                    gVar.s(fVar.f431096a, i18);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.QRLoginMgrActivity.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i27;
                            Activity topActivity = Foreground.getTopActivity();
                            if (i19 == 2) {
                                i27 = R.string.f216755z6;
                            } else {
                                i27 = R.string.f21706600;
                            }
                            if (topActivity != null) {
                                QQToast.makeText(topActivity, topActivity.getString(i27), 0).show();
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0086  */
    @Override // rd0.e.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V0(rd0.f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        QQPermission qQPermission;
        int i16 = 0;
        if (QLog.isColorLevel()) {
            QLog.d("QRLoginMgrActivity", 2, "onFileClick type:", Integer.valueOf(fVar.f431097b));
        }
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (rd0.h.b(fVar.f431097b)) {
            str3 = AppConstants.DATALINE_PC_UIN;
            dataLineHandler.f194549h = str3;
            dataLineHandler.f194551i = 0;
            i16 = 6000;
            str4 = PeerUid.DATALINE_PC_UID;
        } else {
            if (rd0.h.c(fVar.f431097b)) {
                String str5 = AppConstants.DATALINE_IPAD_UIN;
                dataLineHandler.f194549h = str5;
                dataLineHandler.f194551i = 1;
                i3 = 6003;
                str2 = PeerUid.DATALINE_PAD_UID;
                str = str5;
                qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PC_LOGIN, QQPermissionConstants.Business.SCENE.QQ_PC_LOGIN_GOTO_FILE));
                if (qQPermission == null && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                    qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(fVar, i3, str, str2));
                    return;
                } else {
                    Y2(fVar, i3, str, str2);
                }
            }
            if (rd0.h.d(fVar.f431097b)) {
                str3 = AppConstants.DATALINE_PHONE_UIN;
                dataLineHandler.f194549h = str3;
                dataLineHandler.f194551i = 2;
                i16 = 6005;
                str4 = PeerUid.DATALINE_PHONE_UID;
            } else {
                str = "";
                str2 = str;
                i3 = i16;
                qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PC_LOGIN, QQPermissionConstants.Business.SCENE.QQ_PC_LOGIN_GOTO_FILE));
                if (qQPermission == null) {
                }
                Y2(fVar, i3, str, str2);
            }
        }
        str2 = str4;
        str = str3;
        i3 = i16;
        qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PC_LOGIN, QQPermissionConstants.Business.SCENE.QQ_PC_LOGIN_GOTO_FILE));
        if (qQPermission == null) {
        }
        Y2(fVar, i3, str, str2);
    }

    @Override // rd0.e.f
    public void W(rd0.f fVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QRLoginMgrActivity", 2, "onItmeClick type:", Integer.valueOf(fVar.f431097b));
        }
        if (rd0.h.b(fVar.f431097b)) {
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app)) {
                com.tencent.mobileqq.filemanager.fileassistant.util.h.s(this);
            } else {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onItemClick PeerUid.DATALINE_PC_UID is u_rK7NMsbv2ZjEGPdCuOiCfw ,devItem.mDeviceType is " + fVar.f431097b);
                ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this, 8, PeerUid.DATALINE_PC_UID, getResources().getString(R.string.c5f), 0L, new Bundle());
            }
        } else if (rd0.h.d(fVar.f431097b)) {
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app)) {
                com.tencent.mobileqq.filemanager.fileassistant.util.h.s(this);
            } else {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onItemClick PeerUid.DATALINE_PHONE_UID is u_Wcc5rknRRqRO8y5gxMD6sA ,devItem.mDeviceType is " + fVar.f431097b);
                ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this.f94779p0, 8, PeerUid.DATALINE_PHONE_UID, getResources().getString(R.string.f16273218), 0L, new Bundle());
            }
        } else if (rd0.h.c(fVar.f431097b)) {
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app)) {
                com.tencent.mobileqq.filemanager.fileassistant.util.h.s(this);
            } else if (((RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "ipad onItemClick PeerUid.DATALINE_PAD_UID is u_l7jpPIZxQo0mzJwoEt-SKw ,devItem.mDeviceType is " + fVar.f431097b);
                ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this.f94779p0, 8, PeerUid.DATALINE_PAD_UID, getResources().getString(R.string.c5g), 0L, new Bundle());
            } else {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "pad onItemClick PeerUid.DATALINE_PAD_UID is u_l7jpPIZxQo0mzJwoEt-SKw ,devItem.mDeviceType is " + fVar.f431097b);
                ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this.f94779p0, 8, PeerUid.DATALINE_PAD_UID, getResources().getString(R.string.f16272217), 0L, new Bundle());
            }
        } else if (rd0.h.f(fVar.f431097b)) {
            QQToast.makeText(getApplicationContext(), getString(R.string.vok), 0).show(getTitleBarHeight());
        }
        ReportController.o(null, "dc00898", "", "", "0X800A471", "0X800A471", fVar.f431099d, 0, "", "", "", "");
    }

    @Override // rd0.e.f
    public void Z1(CheckBox checkBox, rd0.f fVar) {
        String str;
        String string;
        QLog.d("QRLoginMgrActivity", 1, "onAutoLoginClick, checkbox = " + checkBox.isChecked());
        if (!NetworkUtil.isNetworkAvailable(this)) {
            QQToast.makeText(this.f94779p0, 1, R.string.dqp, 0).show(getTitleBarHeight());
            return;
        }
        int i3 = fVar.f431099d;
        if (checkBox.isChecked()) {
            str = "2";
        } else {
            str = "1";
        }
        ReportController.o(null, "dc00898", "", "", "0X800C454", "0X800C454", i3, 0, str, "", "", "");
        if (checkBox.isChecked()) {
            d3(checkBox, fVar);
            return;
        }
        if (isFinishing()) {
            QLog.i("QRLoginMgrActivity", 1, "onAutoLoginClick, activity is finishing.");
            return;
        }
        try {
            String string2 = getResources().getString(R.string.f172652r1);
            if (TextUtils.isEmpty(fVar.f431104i)) {
                string = getResources().getString(R.string.f172632qz);
            } else {
                string = getResources().getString(R.string.f172642r0, fVar.f431104i);
            }
            DialogUtil.createCustomDialog(this.f94779p0, 230, string2, getResources().getString(R.string.f172622qy, string), R.string.cancel, R.string.f172612qx, new c(fVar, checkBox), new d()).show();
            ReportController.o(null, "dc00898", "", "", "0X800C455", "0X800C455", fVar.f431099d, 0, "", "", "", "");
        } catch (Exception e16) {
            QLog.e("QRLoginMgrActivity", 1, "onAutoLoginClick, " + e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 2 && i16 == -1) {
            long longExtra = intent.getLongExtra("qrlogin_appid", -1L);
            if (longExtra == -1) {
                QLog.w("QRLoginMgrActivity", 1, "appid is -1 !");
                return;
            }
            for (rd0.f fVar : this.f94776m0.k()) {
                if (fVar.f431096a == longExtra) {
                    W(fVar);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        if (this.app == null) {
            super.finish();
            return true;
        }
        QLog.i("QRLoginMgrActivity", 1, "doOnCreate");
        if (ab.a()) {
            AccessibilityUtil.A(getApplicationContext());
        }
        this.f94779p0 = this;
        this.f94780q0 = getIntent().getStringExtra("qrlogin_position");
        this.f94781r0 = getIntent().getLongExtra("qrlogin_appid", -1L);
        initUI();
        String currentAccountUin = this.app.getCurrentAccountUin();
        this.f94768e0.setText(ac.f(this.app, currentAccountUin));
        this.f94769f0.x(1, currentAccountUin, new e.a().g(200).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(currentAccountUin)).a());
        b3();
        addObserver(this.f94784u0);
        ReportController.o(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        hideProgerssDialog();
        removeObserver(this.f94784u0);
        this.f94773j0.removeCallbacksAndMessages(null);
        rd0.g gVar = this.f94778o0;
        if (gVar != null) {
            gVar.p(this.f94783t0);
        }
        this.f94779p0 = null;
        this.f94774k0 = null;
        this.f94775l0 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        QUIPolarLightView qUIPolarLightView = this.f94767d0;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.stopAnimation();
        }
        VideoReport.setPageId(this, "pg_bas_login_device");
        VideoReport.reportPgOut(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        QUIPolarLightView qUIPolarLightView = this.f94767d0;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.m();
        }
        VideoReport.setPageId(this, "pg_bas_login_device");
        VideoReport.reportPgIn(this);
    }

    @Override // rd0.e.f
    public void i(rd0.f fVar) {
        if (fVar.f431106k == 2) {
            QQToast.makeText(this.f94779p0, "QQ\u5728\u7535\u8111\u4e0a\u5df2\u9501\u5b9a\uff0c\u8bf7\u89e3\u9501\u540e\u91cd\u8bd5", 0).show();
        } else if (!NetworkUtil.isNetworkAvailable(this)) {
            QQToast.makeText(this.f94779p0, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5", 0).show();
        } else {
            ((IWifiPhotoService) QRoute.api(IWifiPhotoService.class)).enterWifiPhoto(this, "/wifi_photo/push_apply", 3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.lyb) {
            if (!NetworkUtil.isNetworkAvailable(this)) {
                QQToast.makeText(this.f94779p0, 1, R.string.dqp, 0).show(getTitleBarHeight());
            } else {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
                createCustomDialog.setTitle(R.string.vo9);
                rd0.g gVar = this.f94778o0;
                if (gVar != null) {
                    createCustomDialog.setMessage(gVar.j(this.f94779p0));
                } else {
                    createCustomDialog.setMessage(R.string.vo_);
                }
                createCustomDialog.setPositiveButton(R.string.f171151ok, new g());
                createCustomDialog.setNegativeButton(R.string.cancel, new h());
                createCustomDialog.show();
                ReportController.o(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        initBackground();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
