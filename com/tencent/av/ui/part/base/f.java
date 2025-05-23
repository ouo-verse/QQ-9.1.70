package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ai;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionCallback;
import mw.k;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends nw.a implements mw.h {
    private String C = Build.MANUFACTURER + "." + DeviceInfoMonitor.getModel();
    private int D = 0;
    private boolean E = false;
    private boolean F = false;
    private boolean G = true;
    private k H;

    /* renamed from: e, reason: collision with root package name */
    private QQPermission f76266e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Context> f76267f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f76268h;

    /* renamed from: i, reason: collision with root package name */
    private String f76269i;

    /* renamed from: m, reason: collision with root package name */
    private String f76270m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AVActivity f76271a;

        a(AVActivity aVActivity) {
            this.f76271a = aVActivity;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            f fVar = f.this;
            fVar.N9(this.f76271a, fVar.f76266e, null, true);
            QLog.d("AVPermissionPart", 1, "DEVICE_PERMISSION_TYPE_CAMERA_OPEN_FAIL showPermissionDialog grantForCameraAudio(1) 0");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            QLog.d("AVPermissionPart", 1, "DEVICE_PERMISSION_TYPE_CAMERA_OPEN_FAIL showPermissionDialog deniedForCameraAudio(1) 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f76273a;

        b(long j3) {
            this.f76273a = j3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QLog.d("AVPermissionPart", 1, "DEVICE_PERMISSION_TYPE_CAMERA_OPEN_FAIL showPermissionDialog grantForCamera");
            f.this.H.f(this.f76273a, null, QQPermissionConstants.Permission.CAMERA);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            QLog.d("AVPermissionPart", 1, "DEVICE_PERMISSION_TYPE_CAMERA_OPEN_FAIL showPermissionDialog deniedForCamera");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AVActivity f76275a;

        c(AVActivity aVActivity) {
            this.f76275a = aVActivity;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            f fVar = f.this;
            fVar.N9(this.f76275a, fVar.f76266e, null, true);
            QLog.d("AVPermissionPart", 1, "DEVICE_PERMISSION_TYPE_MIC showPermissionDialog grantForMic");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            QLog.d("AVPermissionPart", 1, "DEVICE_PERMISSION_TYPE_MIC showPermissionDialog deniedForMic");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f76277a;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements DialogInterface.OnDismissListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DialogInterface.OnClickListener onClickListener = d.this.f76277a;
                if (onClickListener != null) {
                    onClickListener.onClick(null, 1);
                }
            }
        }

        d(DialogInterface.OnClickListener onClickListener) {
            this.f76277a = onClickListener;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            DialogInterface.OnClickListener onClickListener = this.f76277a;
            if (onClickListener != null) {
                onClickListener.onClick(null, 1);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            DialogInterface.OnClickListener onClickListener = this.f76277a;
            if (onClickListener != null) {
                onClickListener.onClick(null, 1);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
            permissionRequestDialog.setOnDismissListener(new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f76280a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f76281b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQPermissionCallback f76282c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76283d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f76284e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AVActivity f76285f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f76286g;

        e(boolean z16, String[] strArr, QQPermissionCallback qQPermissionCallback, long j3, View view, AVActivity aVActivity, String str) {
            this.f76280a = z16;
            this.f76281b = strArr;
            this.f76282c = qQPermissionCallback;
            this.f76283d = j3;
            this.f76284e = view;
            this.f76285f = aVActivity;
            this.f76286g = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            int[] iArr;
            super.onAllGranted();
            QLog.w("AVPermissionPart", 1, "onClick_Camera, all grant, mRequestPermissionIng[" + f.this.F);
            int i3 = 0;
            f.this.F = false;
            if (this.f76280a) {
                iArr = new int[]{0, 0};
            } else {
                iArr = new int[]{0};
            }
            while (true) {
                String[] strArr = this.f76281b;
                if (i3 >= strArr.length) {
                    return;
                }
                QQPermissionCallback qQPermissionCallback = this.f76282c;
                if (qQPermissionCallback != null) {
                    qQPermissionCallback.grant(i3, strArr, iArr);
                } else {
                    f.this.H.f(this.f76283d, this.f76284e, this.f76281b[i3]);
                    if (QQPermissionConstants.Permission.RECORD_AUDIO.equals(this.f76281b[i3])) {
                        f fVar = f.this;
                        fVar.N9(this.f76285f, fVar.f76266e, null, true);
                    }
                }
                i3++;
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            f.this.F = false;
            if (this.f76282c == null || this.f76286g == null || list2 == null) {
                return;
            }
            QLog.w("AVPermissionPart", 1, "onClick_Camera, deny, mRequestPermissionIng[" + f.this.F + "], permissions[" + com.tencent.av.utils.e.f(list.toArray()) + "], grantResults[" + com.tencent.av.utils.e.f(list2.toArray()) + "]");
            String[] strArr = new String[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                strArr[i3] = list.get(i3);
            }
            int[] iArr = new int[list2.size()];
            for (int i16 = 0; i16 < list2.size(); i16++) {
                iArr[i16] = list2.get(i16).intValue();
            }
            this.f76282c.deny(-1, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.part.base.f$f, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class DialogInterfaceOnClickListenerC0765f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76288d;

        DialogInterfaceOnClickListenerC0765f(long j3) {
            this.f76288d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            f fVar = f.this;
            AVActivity x95 = fVar.x9(fVar.f76267f);
            if (x95 == null || x95.isDestroyed()) {
                return;
            }
            QLog.w("AVPermissionPart", 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.f76288d + "]");
            ba.openPermissionActivity(x95);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76290d;

        g(long j3) {
            this.f76290d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.w("AVPermissionPart", 1, "showPermissionNormalDialog.Cancel, seq[" + this.f76290d + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76294d;

        i(long j3) {
            this.f76294d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (f.this.f76267f != null) {
                QLog.w("AVPermissionPart", 1, "showPermissionDialog.Cancel, seq[" + this.f76294d + "]");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean N9(Activity activity, QQPermission qQPermission, DialogInterface.OnClickListener onClickListener, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        ArrayList arrayList;
        if (AppSetting.m() < 31 || Build.VERSION.SDK_INT < 31) {
            z17 = true;
            z18 = true;
            z19 = true;
            z26 = true;
        } else {
            z17 = activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0;
            z18 = activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0;
            z19 = activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0;
            if (z16) {
                z27 = ai.g(activity);
                z26 = ai.i(activity);
                arrayList = new ArrayList();
                if (!z17) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_SCAN);
                }
                if (!z18) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_CONNECT);
                }
                if (!z19) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);
                }
                QLog.d("AVPermissionPart", 1, "checkBluetoothPermission checkScanResult=" + z17 + " checkConnectResult=" + z18 + " checkAdvertiseResult=" + z19 + " size=" + arrayList.size() + " request=" + z16 + " hasRequestBluetooth=" + z26 + " hasBluetoothDevice=" + z27, new Throwable());
                if (z16 || arrayList.size() <= 0 || qQPermission == null || z26 || !z27) {
                    if (z16 && onClickListener != null) {
                        onClickListener.onClick(null, 1);
                    }
                    return arrayList.size() > 0;
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                ai.k(activity);
                qQPermission.requestPermissions(strArr, 2, new d(onClickListener));
                return false;
            }
            z26 = true;
        }
        z27 = false;
        arrayList = new ArrayList();
        if (!z17) {
        }
        if (!z18) {
        }
        if (!z19) {
        }
        QLog.d("AVPermissionPart", 1, "checkBluetoothPermission checkScanResult=" + z17 + " checkConnectResult=" + z18 + " checkAdvertiseResult=" + z19 + " size=" + arrayList.size() + " request=" + z16 + " hasRequestBluetooth=" + z26 + " hasBluetoothDevice=" + z27, new Throwable());
        if (z16) {
        }
        if (z16) {
            onClickListener.onClick(null, 1);
        }
        if (arrayList.size() > 0) {
        }
    }

    private void R9(long j3, String str, String str2) {
        if (this.f76267f == null) {
            return;
        }
        QLog.w("AVPermissionPart", 1, "showPermissionDialog, msg[" + str + "], title[" + str2 + "], seq[" + j3 + "]");
        AVActivity x95 = x9(this.f76267f);
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(x95, 230).setMessage(str).setTitle(str2).setNegativeButton(R.string.cancel, new i(j3)).setPositiveButton(ba.gotoSetting(x95) ? R.string.deu : R.string.dev, new h(j3));
        if (x95 == null || !x95.isResume()) {
            return;
        }
        try {
            positiveButton.show();
        } catch (Exception e16) {
            QLog.d("AVPermissionPart", 1, "showPermissionDialog, crash", e16);
        }
    }

    private void S9(long j3, String str) {
        String string;
        String string2;
        AVActivity x95 = x9(this.f76267f);
        if (x95 == null) {
            return;
        }
        if (QQPermissionConstants.Permission.CAMERA.equals(str)) {
            string = x95.getString(R.string.dek);
            string2 = x95.getString(R.string.del);
        } else if (QQPermissionConstants.Permission.RECORD_AUDIO.equals(str)) {
            string = x95.getString(R.string.des);
            string2 = x95.getString(R.string.det);
        } else {
            if (!QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE.equals(str)) {
                return;
            }
            string = x95.getString(R.string.f171242w33);
            string2 = x95.getString(R.string.f171243w34);
        }
        N8(j3, string, string2);
    }

    @Override // mw.h
    public void N8(long j3, String str, String str2) {
        AVActivity x95 = x9(this.f76267f);
        if (x95 == null || x95.isDestroyed()) {
            return;
        }
        DialogUtil.createCustomDialog(x95, 230).setMessage(str).setTitle(str2).setNegativeButton(R.string.cancel, new g(j3)).setPositiveButton(ba.gotoSetting(x95) ? R.string.deu : R.string.dev, new DialogInterfaceOnClickListenerC0765f(j3)).show();
    }

    public boolean O9() {
        return this.F;
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
        this.f76266e = null;
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        z9(getContext(), nw.b.b());
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.h.class);
        this.H = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, view, null);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.h.class);
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.f76267f = new WeakReference<>(context);
        this.f76268h = new WeakReference<>((VideoAppInterface) appInterface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76292d;

        h(long j3) {
            this.f76292d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            f fVar = f.this;
            AVActivity x95 = fVar.x9(fVar.f76267f);
            if (x95 == null || x95.isDestroyed()) {
                return;
            }
            SessionInfo e36 = x95.e3();
            QLog.w("AVPermissionPart", 1, "showPermissionDialog.gotoSetting, seq[" + this.f76292d + "]");
            if (e36 != null) {
                if (f.this.G && f.this.f76270m != null) {
                    ReportController.o(null, "CliOper", "", "", f.this.f76270m, f.this.f76270m, 0, 0, "", "", f.this.C, "");
                }
                ba.openPermissionActivity(x95);
                if (f.this.D == 2 || f.this.D == 1) {
                    f.this.H.g(this.f76292d);
                    long longValue = Long.valueOf(((VideoAppInterface) f.this.f76268h.get()).getCurrentAccountUin()).longValue();
                    int q16 = e36.q(longValue, 1);
                    if (q16 == -1) {
                        return;
                    }
                    e36.f73045k1.remove(q16);
                    synchronized (e36.f73053m1) {
                        int p16 = e36.p(longValue, 1);
                        if (p16 != -1) {
                            e36.f73053m1.remove(p16);
                            e36.S();
                        }
                    }
                    return;
                }
                return;
            }
            QLog.e("AVPermissionPart", 1, "showPermissionDialog onClick session is null.");
        }
    }

    public void onStart() {
        this.E = false;
    }

    public void P9(long j3, int i3) {
        SessionInfo f16;
        String string;
        String string2;
        if (QLog.isColorLevel()) {
            QLog.w("AVPermissionPart", 1, "onDetectNoDevicePermission, issueType[" + this.D + "->" + i3 + "], isRequestCameraPermission[" + this.E + "], seq[" + j3 + "]");
        }
        this.D = i3;
        String str = "";
        this.f76269i = "";
        AVActivity x95 = x9(this.f76267f);
        if (x95 == null || this.f76268h == null || r.h0() == null || (f16 = n.e().f()) == null) {
            return;
        }
        if (i3 == 1) {
            QLog.w("AVPermissionPart", 1, "\u8bf7\u6c42\u76f8\u673a\u6743\u9650.2");
            string = x95.getString(R.string.dek);
            string2 = x95.getString(R.string.del);
            if (f16.F()) {
                this.f76269i = "0X8004892";
                this.f76270m = "0X8004893";
                if (f16.f73067q == 1) {
                    this.f76269i = "0X8004898";
                    this.f76270m = "0X8004899";
                }
            } else if (f16.f73035i == 2) {
                this.f76269i = "0X800488C";
                this.f76270m = "0X800488D";
            }
            this.G = true;
        } else {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (!r.h0().X0()) {
                        cw.e.n(this.f76268h.get(), 3006);
                    }
                    if (f16.F()) {
                        this.f76269i = "0X800488F";
                        this.f76270m = "0X8004890";
                        if (f16.f73067q == 1) {
                            this.f76269i = "0X8004895";
                            this.f76270m = "0X8004896";
                        }
                    } else {
                        int i16 = f16.f73035i;
                        if (i16 == 2) {
                            this.f76269i = "0X8004889";
                            this.f76270m = "0X800488A";
                        } else if (i16 == 1) {
                            this.f76269i = "0X8004885";
                            this.f76270m = "0X8004886";
                        }
                    }
                    this.G = true;
                    String str2 = this.f76269i;
                    ReportController.o(null, "CliOper", "", "", str2, str2, 0, 0, "", "", this.C, "");
                    return;
                }
                if (i3 == 6) {
                    cw.e.n(this.f76268h.get(), 3007);
                    return;
                }
                if (i3 != 4) {
                    if (i3 == 2048) {
                        f16.U = true;
                        return;
                    }
                    return;
                }
                if (!r.h0().X0()) {
                    cw.e.n(this.f76268h.get(), 3004);
                }
                if (f16.F()) {
                    if (f16.f73067q == 1) {
                        str = "0X8004897";
                    } else {
                        str = "0X8004891";
                    }
                } else {
                    int i17 = f16.f73035i;
                    if (i17 == 2) {
                        str = "0X800488B";
                    } else if (i17 == 1) {
                        str = "0X8004887";
                    }
                }
                String str3 = str;
                ReportController.o(null, "CliOper", "", "", str3, str3, 0, 0, "", "", this.C, "");
                return;
            }
            QLog.w("AVPermissionPart", 1, "\u8bf7\u6c42\u76f8\u673a\u6743\u9650.3");
            string = x95.getString(R.string.dek);
            string2 = x95.getString(R.string.del);
            if (f16.F()) {
                this.f76269i = "0X80049D3";
                if (f16.f73067q == 1) {
                    this.f76269i = "0X80049D4";
                }
            } else if (f16.f73039j == 1) {
                this.f76269i = "0X80049D1";
            } else if (f16.f73035i == 2) {
                this.f76269i = "0X80049D2";
            }
            this.G = false;
        }
        String str4 = string2;
        String str5 = string;
        String str6 = this.f76269i;
        ReportController.o(null, "CliOper", "", "", str6, str6, 0, 0, "", "", this.C, "");
        if (VideoUtil.c(x95)) {
            if (i3 == 2 && this.E) {
                return;
            }
            Q9(j3, i3, str5, str4, true);
            return;
        }
        R9(j3, str5, str4);
    }

    @Override // mw.h
    public boolean f1(long j3, String str, View view, QQPermissionCallback qQPermissionCallback) {
        boolean z16;
        String[] strArr;
        AVActivity x95 = x9(this.f76267f);
        if (x95 == null) {
            return false;
        }
        if (this.f76266e == null) {
            this.f76266e = QQPermissionFactory.getQQPermission(x95, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AV, QQPermissionConstants.Business.SCENE.QQ_AV_ROOM));
        }
        QQPermission qQPermission = this.f76266e;
        if (qQPermission == null) {
            return false;
        }
        boolean z17 = qQPermission.hasPermission(str) == 0;
        if (QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE.equals(str)) {
            z17 = z17 && this.f76266e.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0;
            z16 = true;
        } else {
            z16 = false;
        }
        if (z17) {
            return true;
        }
        if (VideoUtil.c(x95)) {
            QLog.w("AVPermissionPart", 1, "checkSelfPermission, begin, permission[" + str + "], mRequestPermissionIng[" + this.F + "], seq[" + j3 + "]");
            this.F = true;
            if (z16) {
                strArr = new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
            } else {
                strArr = new String[]{str};
            }
            String[] strArr2 = strArr;
            this.f76266e.requestPermissions(strArr2, 2, new e(z16, strArr2, qQPermissionCallback, j3, view, x95, str));
        } else {
            QLog.w("AVPermissionPart", 1, "checkSelfPermission, fail, permission[" + str + "], seq[" + j3 + "]");
            if (qQPermissionCallback == null) {
                S9(j3, str);
            } else {
                qQPermissionCallback.deny(-1, new String[]{str}, new int[]{-1});
            }
        }
        return false;
    }

    private void Q9(long j3, int i3, String str, String str2, boolean z16) {
        AVActivity x95 = x9(this.f76267f);
        if (x95 == null) {
            return;
        }
        if (!x95.isResume()) {
            QLog.w("AVPermissionPart", 1, "showPermissionDialog, no isResume, seq[" + j3 + "]");
            return;
        }
        if (this.f76266e == null) {
            this.f76266e = QQPermissionFactory.getQQPermission(x95, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AV, QQPermissionConstants.Business.SCENE.QQ_AV_ROOM));
        }
        QQPermission qQPermission = this.f76266e;
        if (qQPermission == null) {
            return;
        }
        boolean z17 = qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0;
        boolean z18 = this.f76266e.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0;
        QLog.w("AVPermissionPart", 1, "showPermissionDialog, issueType[" + i3 + "], showNormalDialog[" + z16 + "], checkCameraResult[" + z17 + "], checkRecordResult[" + z18 + "], seq[" + j3 + "]");
        if (!z17 && !z18 && i3 == 2) {
            this.f76266e.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new a(x95));
            this.E = true;
            return;
        }
        if (i3 == 2) {
            if (!z17) {
                this.f76266e.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new b(j3));
                this.E = true;
                return;
            } else {
                if (z16) {
                    R9(j3, str, str2);
                    return;
                }
                return;
            }
        }
        if (i3 != 3) {
            return;
        }
        if (!z18) {
            this.f76266e.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new c(x95));
        } else if (z16) {
            R9(j3, str, str2);
        }
    }
}
