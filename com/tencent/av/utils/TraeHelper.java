package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.av.VideoRecoveryMonitor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.TraeHelper;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.NtrtcAudioDevice;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sharp.jni.api.IMediaPlayerApi;
import com.tencent.sharp.jni.callback.OnCompletionListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TraeHelper {
    public static int C = 0;
    public static int D = 1;
    static volatile TraeHelper E;
    static final long[] F = {100, 1500, 1500, 1500, 1500};

    /* renamed from: e, reason: collision with root package name */
    WeakReference<Context> f76829e;

    /* renamed from: k, reason: collision with root package name */
    k f76835k;

    /* renamed from: u, reason: collision with root package name */
    private f f76845u;

    /* renamed from: a, reason: collision with root package name */
    int f76825a = 0;

    /* renamed from: b, reason: collision with root package name */
    NtrtcAudioDevice f76826b = null;

    /* renamed from: c, reason: collision with root package name */
    IMediaPlayerApi f76827c = null;

    /* renamed from: d, reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f76828d = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f76830f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f76831g = false;

    /* renamed from: h, reason: collision with root package name */
    String f76832h = null;

    /* renamed from: i, reason: collision with root package name */
    WeakReference<Button> f76833i = null;

    /* renamed from: j, reason: collision with root package name */
    WeakReference<l> f76834j = null;

    /* renamed from: l, reason: collision with root package name */
    boolean f76836l = false;

    /* renamed from: m, reason: collision with root package name */
    AudioManager.OnAudioFocusChangeListener f76837m = null;

    /* renamed from: n, reason: collision with root package name */
    int f76838n = 0;

    /* renamed from: o, reason: collision with root package name */
    int f76839o = 0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f76840p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f76841q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f76842r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f76843s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f76844t = false;

    /* renamed from: v, reason: collision with root package name */
    private SessionInfo f76846v = null;

    /* renamed from: w, reason: collision with root package name */
    private h f76847w = null;

    /* renamed from: x, reason: collision with root package name */
    private QActivityLifecycleCallbacks f76848x = null;

    /* renamed from: y, reason: collision with root package name */
    String f76849y = null;

    /* renamed from: z, reason: collision with root package name */
    int f76850z = -1;
    private boolean A = false;
    Runnable B = new Runnable() { // from class: com.tencent.av.utils.TraeHelper.9
        @Override // java.lang.Runnable
        public void run() {
            Button button;
            int i3;
            if (com.tencent.av.r.h0() == null) {
                return;
            }
            WeakReference<Button> weakReference = TraeHelper.this.f76833i;
            if (weakReference != null && (button = weakReference.get()) != null) {
                button.setClickable(true);
                if (TraeHelper.this.f76842r && af.F()) {
                    button.setSelected(true);
                    ba.setAccText(button, button.getResources().getString(R.string.f170494sv));
                } else {
                    button.setSelected(TraeHelper.this.f76846v.I0);
                    Resources resources = button.getResources();
                    if (TraeHelper.this.f76846v.I0) {
                        i3 = R.string.f170495sw;
                    } else {
                        i3 = R.string.f170496sx;
                    }
                    ba.setAccText(button, resources.getString(i3));
                }
            }
            com.tencent.av.n.e().f().r0("handFreeJob", TraeHelper.this.f76846v.I0);
            TraeHelper.this.R();
            VideoRecoveryMonitor T = VideoAppInterface.N().T();
            if (T != null) {
                T.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Button f76857d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f76858e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f76859f;

        a(Button button, long j3, ActionSheet actionSheet) {
            this.f76857d = button;
            this.f76858e = j3;
            this.f76859f = actionSheet;
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            j.a aVar;
            if (TraeHelper.this.f76845u != null && (aVar = (j.a) TraeHelper.this.f76845u.getItem(i3)) != null && !TextUtils.isEmpty(aVar.f76879a) && TraeHelper.this.f76826b != null) {
                if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(aVar.f76879a)) {
                    cw.e.n((VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime(), 3014);
                    QLog.w("TraeSessionHelper", 1, "lgx TYPE_WAITING_FOR_BLUETOOTH_TIPS onItemClick....");
                    Button button = this.f76857d;
                    if (button != null) {
                        button.setClickable(false);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D20 at: " + System.currentTimeMillis());
                    }
                    ReportController.o(null, "CliOper", "", "", "0X8008D20", "0X8008D20", 0, 0, "", "", "", "");
                } else if (TraeConstants.DEVICE_SPEAKERPHONE.equals(aVar.f76879a)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1F at: " + System.currentTimeMillis());
                    }
                    ReportController.o(null, "CliOper", "", "", "0X8008D1F", "0X8008D1F", 0, 0, "", "", "", "");
                } else if (TraeConstants.DEVICE_EARPHONE.equals(aVar.f76879a)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D21-1 at: " + System.currentTimeMillis());
                    }
                    ReportController.o(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 1, 0, "", "", "", "");
                } else if (TraeConstants.DEVICE_WIRED_HEADSET.equals(aVar.f76879a)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D21-2 at: " + System.currentTimeMillis());
                    }
                    ReportController.o(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 2, 0, "", "", "", "");
                }
                TraeHelper.this.A = true;
                TraeHelper.this.f76826b.connectDevice(this.f76858e, aVar.f76879a);
            }
            this.f76859f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements ActionSheet.OnDismissListener {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            if (QLog.isColorLevel()) {
                QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D22 at: " + System.currentTimeMillis());
            }
            ReportController.o(null, "CliOper", "", "", "0X8008D22", "0X8008D22", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnShowListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1E at: " + System.currentTimeMillis());
            }
            ReportController.o(null, "CliOper", "", "", "0X8008D1E", "0X8008D1E", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AudioManager f76863d;

        d(AudioManager audioManager) {
            this.f76863d = audioManager;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            if (QLog.isColorLevel()) {
                QLog.w("TraeSessionHelper", 2, "focusChange[" + i3 + "], focusSteamType[" + TraeHelper.this.f76838n + "], mAudioManager.getMode()[" + this.f76863d.getMode() + "], mActiveMode[" + TraeHelper.this.f76839o + "]");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements OnCompletionListener {
        e() {
        }

        @Override // com.tencent.sharp.jni.callback.OnCompletionListener
        public void onCompletion(long j3) {
            TraeHelper.this.N(j3);
            TraeHelper.this.Q(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class f extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Context> f76866d;

        /* renamed from: e, reason: collision with root package name */
        private int f76867e = 0;

        /* renamed from: f, reason: collision with root package name */
        private String[] f76868f;

        /* renamed from: h, reason: collision with root package name */
        j f76869h;

        f(Context context, @NonNull j jVar) {
            this.f76866d = new WeakReference<>(context);
            this.f76869h = jVar;
            this.f76868f = jVar.a();
        }

        public void a(int i3) {
            this.f76867e = i3;
            notifyDataSetChanged();
        }

        public void b(String str) {
            String str2;
            int count = getCount();
            for (int i3 = 0; i3 < count; i3++) {
                j.a aVar = (j.a) getItem(i3);
                if (aVar != null && (str2 = aVar.f76879a) != null && str2.equals(str)) {
                    a(i3);
                    return;
                }
            }
        }

        public void c(Context context, @NonNull j jVar) {
            if (context != null) {
                this.f76866d = new WeakReference<>(context);
            }
            this.f76868f = jVar.a();
            this.f76869h = jVar;
            notifyDataSetInvalidated();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            j jVar = this.f76869h;
            if (jVar != null) {
                return jVar.d();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f76869h.b(this.f76868f[i3]);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            boolean z16;
            j.a aVar = (j.a) getItem(i3);
            if (aVar != null) {
                if (view == null) {
                    view = new g(this.f76866d.get(), aVar.f76880b, aVar.f76881c);
                } else {
                    g gVar = (g) view;
                    gVar.c(aVar.f76881c);
                    view.setContentDescription(aVar.f76881c);
                    gVar.b(aVar.f76880b);
                }
            }
            g gVar2 = (g) view;
            if (i3 == this.f76867e) {
                z16 = true;
            } else {
                z16 = false;
            }
            gVar2.a(z16);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class g extends RelativeLayout {

        /* renamed from: d, reason: collision with root package name */
        private ImageView f76870d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f76871e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f76872f;

        public g(Context context, int i3, CharSequence charSequence) {
            super(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(context.getResources().getDimensionPixelSize(R.dimen.a9j), 0, 0, 0);
            layoutParams.addRule(15, -1);
            layoutParams.addRule(9, -1);
            ImageView imageView = new ImageView(context);
            this.f76871e = imageView;
            imageView.setId(R.id.f30080nd);
            this.f76871e.setImageResource(i3);
            this.f76871e.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, context.getResources().getDimensionPixelSize(R.dimen.a9j), 0);
            layoutParams2.addRule(15, -1);
            layoutParams2.addRule(11, -1);
            ImageView imageView2 = new ImageView(context);
            this.f76870d = imageView2;
            imageView2.setId(R.id.f30070nc);
            this.f76870d.setImageResource(R.drawable.f161382de0);
            this.f76870d.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(context.getResources().getDimensionPixelSize(R.dimen.a9j), 0, context.getResources().getDimensionPixelSize(R.dimen.a9j), 0);
            layoutParams3.addRule(15, -1);
            layoutParams3.addRule(14, -1);
            layoutParams3.addRule(1, R.id.f30080nd);
            layoutParams3.addRule(0, R.id.f30070nc);
            TextView textView = new TextView(context);
            this.f76872f = textView;
            textView.setText(charSequence);
            this.f76872f.setLayoutParams(layoutParams3);
            this.f76872f.setGravity(17);
            this.f76872f.setTextColor(-16777216);
            this.f76872f.setSingleLine();
            this.f76872f.setEllipsize(TextUtils.TruncateAt.END);
            this.f76872f.setTextSize(0, context.getResources().getDimension(R.dimen.az6));
            addView(this.f76871e);
            addView(this.f76872f);
            addView(this.f76870d);
            setBackgroundResource(R.drawable.f160040p);
            setId(R.id.e2h);
            setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.f158528hz));
        }

        public void a(boolean z16) {
            int i3;
            ImageView imageView = this.f76870d;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            imageView.setVisibility(i3);
        }

        public void b(int i3) {
            this.f76871e.setImageResource(i3);
        }

        public void c(CharSequence charSequence) {
            this.f76872f.setText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class h extends AudioDeviceCallback {

        /* renamed from: a, reason: collision with root package name */
        private boolean f76873a = false;

        /* renamed from: b, reason: collision with root package name */
        private boolean f76874b = false;

        /* renamed from: c, reason: collision with root package name */
        private long f76875c = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes3.dex */
        public class a extends QQPermission.BasePermissionsListener {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(DialogInterface dialogInterface) {
                h.this.f76873a = false;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                h.this.f76873a = false;
                super.onAllGranted();
                TraeHelper.Z();
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(List<String> list, List<Integer> list2) {
                super.onDenied(list, list2);
                h.this.f76875c = System.currentTimeMillis();
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
                super.onDeniedWithoutShowDlg(list, list2);
                h.this.f76873a = false;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
                super.onDialogShow(permissionRequestDialog, list);
                if (permissionRequestDialog != null) {
                    permissionRequestDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.av.utils.ay
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            TraeHelper.h.a.this.b(dialogInterface);
                        }
                    });
                }
            }
        }

        h() {
        }

        public void c(Context context) {
            boolean z16;
            boolean z17;
            boolean z18;
            Activity topActivity;
            if (context != null && !this.f76873a) {
                if (AppSetting.m() >= 31 && Build.VERSION.SDK_INT >= 31) {
                    if (context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                } else {
                    z16 = true;
                    z17 = true;
                    z18 = true;
                }
                if (z18 && z17 && z16) {
                    this.f76874b = false;
                    return;
                }
                if (context instanceof Activity) {
                    topActivity = (Activity) context;
                } else {
                    topActivity = Foreground.getTopActivity();
                }
                if (!TraeHelper.P(topActivity)) {
                    QLog.d("TraeSessionHelper", 1, "checkAndRequestBluetoothPermission failed to get available Activity!");
                    this.f76874b = true;
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (!z16) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_SCAN);
                }
                if (!z17) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_CONNECT);
                }
                if (!z18) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(topActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV));
                this.f76873a = true;
                this.f76874b = false;
                qQPermission.requestPermissions(strArr, 2, new a());
            }
        }

        public boolean d() {
            return this.f76874b;
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            TraeHelper I = TraeHelper.I();
            if (I == null) {
                return;
            }
            boolean z16 = false;
            boolean z17 = false;
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                int type = audioDeviceInfo.getType();
                if (type != 8 && type != 7 && type != 26) {
                    z17 = true;
                } else {
                    QLog.d("TraeSessionHelper", 1, "add device name: " + ((Object) audioDeviceInfo.getProductName()) + " type: " + type);
                    z16 = true;
                }
            }
            if (z16 && !z17 && I.f76829e != null && I.f76826b != null && I.f76836l) {
                long currentTimeMillis = System.currentTimeMillis() - this.f76875c;
                if (currentTimeMillis < 5000) {
                    QLog.d("TraeSessionHelper", 1, "not request permission interval too short: " + currentTimeMillis + "ms");
                    return;
                }
                c(I.f76829e.get());
                return;
            }
            QLog.d("TraeSessionHelper", 1, "not request permission hasBluetoothDevice=" + z16 + " hasOtherDevice=" + z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private String[] f76877a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, a> f76878b = new HashMap();

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public String f76879a;

            /* renamed from: b, reason: collision with root package name */
            public int f76880b;

            /* renamed from: c, reason: collision with root package name */
            public String f76881c;

            public a(int i3, String str, String str2) {
                this.f76880b = i3;
                this.f76881c = str;
                this.f76879a = str2;
            }
        }

        public j(String[] strArr) {
            this.f76877a = strArr;
            if (strArr != null) {
                for (String str : strArr) {
                    if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str)) {
                        this.f76878b.put(str, new a(R.drawable.ddw, HardCodeUtil.qqStr(R.string.u7u), str));
                    } else if (TraeConstants.DEVICE_EARPHONE.equals(str)) {
                        this.f76878b.put(str, new a(R.drawable.ddy, HardCodeUtil.qqStr(R.string.u7v), str));
                    } else if (TraeConstants.DEVICE_SPEAKERPHONE.equals(str)) {
                        this.f76878b.put(str, new a(R.drawable.f161383de1, HardCodeUtil.qqStr(R.string.u7y), str));
                    } else if (TraeConstants.DEVICE_WIRED_HEADSET.equals(str)) {
                        this.f76878b.put(str, new a(R.drawable.f161385de3, HardCodeUtil.qqStr(R.string.u7w), str));
                    }
                }
            }
        }

        public String[] a() {
            return this.f76877a;
        }

        public a b(String str) {
            return this.f76878b.get(str);
        }

        public void c(String str) {
            a aVar;
            if (!TextUtils.isEmpty(str) && (aVar = this.f76878b.get(TraeConstants.DEVICE_BLUETOOTH_HEADSET)) != null) {
                aVar.f76881c = HardCodeUtil.qqStr(R.string.u7x) + str + "\uff09";
            }
        }

        public int d() {
            return this.f76878b.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface l {
        void a(boolean z16, int i3);
    }

    public TraeHelper(Context context, Button button) {
        this.f76829e = new WeakReference<>(context);
        c0(button);
        this.f76835k = new k();
        L();
        o0(-1031L, com.tencent.av.n.e().f());
    }

    static boolean A(VideoAppInterface videoAppInterface) {
        if (videoAppInterface != null && videoAppInterface.getApp() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        boolean z16;
        int i3;
        if (!MobileQQ.processName.endsWith(MsfConstants.PROCESS_VIDEO)) {
            return true;
        }
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (f16 != null && ((i3 = f16.f73035i) == 1 || i3 == 2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !com.tencent.av.r.h0().Y0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(Context context) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (context == null) {
            if (AppSetting.m() >= 31 && Build.VERSION.SDK_INT >= 31) {
                return false;
            }
            return true;
        }
        if (AppSetting.m() >= 31 && Build.VERSION.SDK_INT >= 31) {
            if (context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        } else {
            z16 = true;
            z17 = true;
            z18 = true;
        }
        if (!z17 || !z18 || !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String[] strArr) {
        boolean z16 = this.f76842r;
        if (strArr != null) {
            this.f76842r = Arrays.asList(strArr).contains(TraeConstants.DEVICE_BLUETOOTH_HEADSET);
        } else {
            this.f76842r = false;
        }
        boolean z17 = this.f76842r;
        if (z17 != z16 && z17) {
            if (QLog.isColorLevel()) {
                QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1D at: " + System.currentTimeMillis());
            }
            ReportController.o(null, "CliOper", "", "", "0X8008D1D", "0X8008D1D", 0, 0, "", "", "", "");
        }
    }

    public static TraeHelper G(Context context) {
        if (E == null) {
            synchronized (TraeHelper.class) {
                if (E == null) {
                    E = new TraeHelper(context, null);
                }
            }
        }
        return E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable H(Resources resources, int i3, boolean z16) {
        Drawable a16;
        switch (i3) {
            case 1:
            case 3:
                if (z16) {
                    a16 = com.tencent.av.utils.l.c(resources, R.drawable.k9j, false, false, false);
                    break;
                } else {
                    a16 = aw.a(resources, R.drawable.d_w, R.color.f157481qm);
                    break;
                }
            case 2:
            case 4:
                if (z16) {
                    a16 = com.tencent.av.utils.l.c(resources, R.drawable.k9i, false, false, false);
                    break;
                } else {
                    a16 = aw.a(resources, R.drawable.d_v, R.color.f157481qm);
                    break;
                }
            case 5:
                if (z16) {
                    a16 = com.tencent.av.utils.l.b(resources, R.drawable.d_u, false, false);
                    break;
                } else {
                    a16 = aw.a(resources, R.drawable.ddx, R.color.f157512rm);
                    break;
                }
            case 6:
                if (z16) {
                    a16 = com.tencent.av.utils.l.b(resources, R.drawable.d_y, false, false);
                    break;
                } else {
                    a16 = aw.a(resources, R.drawable.f161386de4, R.color.f157512rm);
                    break;
                }
            case 7:
                if (z16) {
                    a16 = com.tencent.av.utils.l.b(resources, R.drawable.d_x, false, false);
                    break;
                } else {
                    a16 = aw.a(resources, R.drawable.ddz, R.color.f157512rm);
                    break;
                }
            case 8:
                if (z16) {
                    a16 = com.tencent.av.utils.l.c(resources, R.drawable.k9i, false, false, false);
                    break;
                } else {
                    a16 = aw.a(resources, R.drawable.f161384de2, R.color.f157512rm);
                    break;
                }
            default:
                a16 = null;
                break;
        }
        if (a16 != null && !z16) {
            a16.setBounds(0, 0, a16.getIntrinsicWidth(), a16.getIntrinsicHeight());
        }
        return a16;
    }

    public static synchronized TraeHelper I() {
        TraeHelper traeHelper;
        synchronized (TraeHelper.class) {
            traeHelper = E;
        }
        return traeHelper;
    }

    public static String J(Context context) {
        String str;
        if (AVCoreSystemInfo.getCpuArchitecture() > 2) {
            str = "/txlib/libtraeimp-qq.so";
        } else {
            str = "/txlib/libtraeimp-armeabi.so";
        }
        String str2 = context.getFilesDir().getParent() + str;
        try {
            System.load(str2);
            return str2;
        } catch (UnsatisfiedLinkError unused) {
            return null;
        }
    }

    private void K() {
        WeakReference<Context> weakReference = this.f76829e;
        if (weakReference != null && weakReference.get() != null) {
            if (this.f76827c == null) {
                IMediaPlayerApi iMediaPlayerApi = (IMediaPlayerApi) QRoute.api(IMediaPlayerApi.class);
                this.f76827c = iMediaPlayerApi;
                iMediaPlayerApi.init(this.f76829e.get(), new e());
                this.f76831g = true;
                return;
            }
            return;
        }
        QLog.w("TraeSessionHelper", 1, "initRingMediaPlayer fail");
    }

    private void M(long j3, int i3, int i16, Uri uri, String str, boolean z16, int i17, String str2, boolean z17) {
        boolean z18;
        if (this.f76826b != null && this.f76827c != null) {
            if (this.f76839o == 2) {
                O();
            }
            if (this.f76839o != 1) {
                this.f76839o = 2;
            }
            IMediaPlayerApi iMediaPlayerApi = this.f76827c;
            if (this.f76839o == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            boolean playRing = iMediaPlayerApi.playRing(0L, i3, i16, uri, str, z16, i17, z17, z18, this.f76825a);
            if (!this.f76827c.hasCall()) {
                Y(this.f76827c.getStreamType());
            }
            this.f76835k.onStreamTypeUpdate(0L, this.f76827c.getStreamType(), this.f76839o);
            this.f76826b.setActiveMode(this.f76839o);
            if (QLog.isColorLevel()) {
                QLog.w("TraeSessionHelper", 1, "InternalStartRing end, Userdata[" + str2 + "], dataSource[" + i3 + "], DurationMS[" + this.f76827c.getDuration() + "], ret[" + playRing + "]");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(long j3) {
        IMediaPlayerApi iMediaPlayerApi = this.f76827c;
        if (this.f76826b != null && iMediaPlayerApi != null && this.f76831g) {
            l0(iMediaPlayerApi);
            if (!iMediaPlayerApi.hasCall() && this.f76839o == 2) {
                x();
                this.f76839o = 0;
            }
        }
    }

    private void O() {
        IMediaPlayerApi iMediaPlayerApi;
        if (this.f76826b != null && (iMediaPlayerApi = this.f76827c) != null) {
            if (this.f76839o != 2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TraeSessionHelper", 2, "interruptRing failed, mActiveMode[" + this.f76839o + "]");
                    return;
                }
                return;
            }
            l0(iMediaPlayerApi);
            x();
            this.f76839o = 0;
            this.f76826b.setActiveMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(Activity activity) {
        if ((!(activity instanceof AVActivity) && !(activity instanceof VideoInviteActivity) && !(activity instanceof MultiIncomingCallsActivity) && !(activity instanceof GaInviteLockActivity)) || activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(long j3) {
        final MediaPlayer.OnCompletionListener onCompletionListener = this.f76828d;
        this.f76828d = null;
        QLog.w("TraeSessionHelper", 1, "onRingCompletion, mRingComListener[" + onCompletionListener + "], seq[" + j3 + "]");
        if (com.tencent.av.r.h0() == null) {
            return;
        }
        VideoAppInterface.N().M().post(new Runnable() { // from class: com.tencent.av.utils.TraeHelper.6
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer.OnCompletionListener onCompletionListener2 = onCompletionListener;
                if (onCompletionListener2 != null) {
                    onCompletionListener2.onCompletion(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        final Button button;
        final Context context;
        WeakReference<Button> weakReference = this.f76833i;
        if (weakReference != null && (button = weakReference.get()) != null && (context = button.getContext()) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TraeSessionHelper", 2, "switchButton_handFree onUpdateButtonHandFree()");
            }
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.av.utils.TraeHelper.10
                @Override // java.lang.Runnable
                public void run() {
                    if (com.tencent.av.r.h0() == null) {
                        return;
                    }
                    TraeHelper.this.f76850z = 2;
                    VideoAppInterface.N().runOnUiThread(new Runnable() { // from class: com.tencent.av.utils.TraeHelper.10.1
                        /* JADX WARN: Removed duplicated region for block: B:45:0x01e4  */
                        /* JADX WARN: Removed duplicated region for block: B:47:0x01e5  */
                        /* JADX WARN: Removed duplicated region for block: B:74:0x0161  */
                        /* JADX WARN: Removed duplicated region for block: B:78:0x0168  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            boolean z16;
                            String string;
                            VideoAppInterface videoAppInterface;
                            boolean z17;
                            int i3;
                            int i16;
                            WeakReference<l> weakReference2;
                            l lVar;
                            try {
                                if (com.tencent.av.r.h0() == null) {
                                    return;
                                }
                                Resources resources = button.getResources();
                                SessionInfo f16 = com.tencent.av.n.e().f();
                                int i17 = f16.f73035i;
                                if (i17 != 2 && ((i17 != 4 || !f16.f73060o0 || !com.tencent.biz.common.util.g.b(context)) && !TraeHelper.this.f76844t)) {
                                    z16 = false;
                                    string = resources.getString(R.string.d_j);
                                    videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                    z17 = TraeHelper.this.f76842r;
                                    i3 = DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT;
                                    int i18 = 8;
                                    if (!z17 && af.F()) {
                                        if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(f16.F0)) {
                                            string = resources.getString(R.string.d_h);
                                            cw.e.d(videoAppInterface, 3014);
                                            if (TraeHelper.this.A || TraeHelper.this.f76840p) {
                                                TraeHelper.this.A = false;
                                                TraeHelper.this.f76840p = false;
                                                cw.e.g(videoAppInterface, 1067, 3000L);
                                            }
                                            i18 = 5;
                                        } else if (TraeConstants.DEVICE_WIRED_HEADSET.equals(f16.F0)) {
                                            string = resources.getString(R.string.d_k);
                                            if (TraeHelper.this.A || TraeHelper.this.f76840p) {
                                                TraeHelper.this.A = false;
                                                TraeHelper.this.f76840p = false;
                                                cw.e.g(videoAppInterface, DataTableNameType.TABLE_DATA_COLLECTION, 3000L);
                                            }
                                            i18 = 6;
                                        } else if (TraeConstants.DEVICE_EARPHONE.equals(f16.F0)) {
                                            string = resources.getString(R.string.d_i);
                                            if (TraeHelper.this.A || TraeHelper.this.f76840p) {
                                                TraeHelper.this.A = false;
                                                TraeHelper.this.f76840p = false;
                                                cw.e.g(videoAppInterface, 1069, 3000L);
                                            }
                                            i18 = 7;
                                        } else if (TraeConstants.DEVICE_SPEAKERPHONE.equals(f16.F0)) {
                                            string = resources.getString(R.string.d_j);
                                            if (TraeHelper.this.A || TraeHelper.this.f76840p) {
                                                TraeHelper.this.A = false;
                                                TraeHelper.this.f76840p = false;
                                                cw.e.g(videoAppInterface, DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT, 3000L);
                                            }
                                        }
                                    } else {
                                        cw.e.d(videoAppInterface, 3014);
                                        i16 = TraeHelper.this.f76850z;
                                        if (i16 != 1) {
                                            if (z16) {
                                                i18 = 3;
                                            } else {
                                                i18 = 1;
                                            }
                                        } else if (i16 == 2) {
                                            if (z16) {
                                                i18 = 4;
                                            } else {
                                                i18 = 2;
                                            }
                                        }
                                        string = resources.getString(R.string.d_j);
                                    }
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    button.setCompoundDrawables(null, TraeHelper.this.H(context.getResources(), i18, TraeHelper.this.f76843s), null, null);
                                    button.setText(string);
                                    weakReference2 = TraeHelper.this.f76834j;
                                    if (weakReference2 != null && (lVar = weakReference2.get()) != null) {
                                        lVar.a(f16.I0, TraeHelper.this.f76850z);
                                    }
                                    if ((!TraeHelper.this.f76841q || TraeHelper.this.f76840p) && !TraeHelper.this.f76842r) {
                                        TraeHelper.this.f76841q = false;
                                        TraeHelper.this.f76840p = false;
                                        if (f16.I0) {
                                            i3 = DataTableNameType.TABLE_SPORT_METADATA;
                                        }
                                        cw.e.g(videoAppInterface, i3, 3000L);
                                    }
                                    QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + string + "], deviceName[" + f16.F0 + "], mCurrentAudioLevel[" + TraeHelper.this.f76850z + "]");
                                }
                                z16 = true;
                                string = resources.getString(R.string.d_j);
                                videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                z17 = TraeHelper.this.f76842r;
                                i3 = DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT;
                                int i182 = 8;
                                if (!z17) {
                                }
                                cw.e.d(videoAppInterface, 3014);
                                i16 = TraeHelper.this.f76850z;
                                if (i16 != 1) {
                                }
                                string = resources.getString(R.string.d_j);
                                AnonymousClass10 anonymousClass102 = AnonymousClass10.this;
                                button.setCompoundDrawables(null, TraeHelper.this.H(context.getResources(), i182, TraeHelper.this.f76843s), null, null);
                                button.setText(string);
                                weakReference2 = TraeHelper.this.f76834j;
                                if (weakReference2 != null) {
                                    lVar.a(f16.I0, TraeHelper.this.f76850z);
                                }
                                if (!TraeHelper.this.f76841q) {
                                }
                                TraeHelper.this.f76841q = false;
                                TraeHelper.this.f76840p = false;
                                if (f16.I0) {
                                }
                                cw.e.g(videoAppInterface, i3, 3000L);
                                QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + string + "], deviceName[" + f16.F0 + "], mCurrentAudioLevel[" + TraeHelper.this.f76850z + "]");
                            } catch (Exception e16) {
                                QLog.e("TraeSessionHelper", 1, "onUpdateButtonHandFree ui task fail.", e16);
                            }
                        }
                    });
                }
            }, null, false);
        }
    }

    private void U() {
        Context context;
        AudioManager audioManager;
        WeakReference<Context> weakReference = this.f76829e;
        if (weakReference != null && this.f76847w == null && (context = weakReference.get()) != null && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
            QLog.d("TraeSessionHelper", 1, "registerAudioDeviceCallback!!");
            h hVar = new h();
            this.f76847w = hVar;
            audioManager.registerAudioDeviceCallback(hVar, null);
        }
    }

    private void V() {
        if (this.f76848x != null) {
            return;
        }
        i iVar = new i();
        this.f76848x = iVar;
        Foreground.addActivityLifeCallback(iVar);
    }

    @TargetApi(31)
    private void W() {
        Context context;
        PhoneStatusAudioModeMonitor u06;
        if (this.f76829e == null || com.tencent.av.r.h0() == null || (context = this.f76829e.get()) == null || (u06 = com.tencent.av.r.h0().u0()) == null) {
            return;
        }
        u06.j(context);
    }

    private void Y(int i3) {
        WeakReference<Context> weakReference = this.f76829e;
        if (weakReference != null && weakReference.get() != null) {
            final AudioManager audioManager = (AudioManager) this.f76829e.get().getSystemService("audio");
            if (this.f76837m == null) {
                d dVar = new d(audioManager);
                this.f76837m = dVar;
                if (audioManager != null) {
                    final int requestAudioFocus = audioManager.requestAudioFocus(dVar, i3, 2);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.TraeHelper.5
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.d("TraeSessionHelper", 1, "requestAudioFocus, ret[" + requestAudioFocus + "], mode[" + audioManager.getMode() + "]");
                        }
                    }, 16, null, false);
                    this.f76838n = i3;
                }
            }
        }
    }

    public static void Z() {
        TraeHelper I = I();
        if (I != null && I.f76826b != null && I.f76836l && I.f76830f) {
            if (TraeConstants.VOICE_CALL_CONFIG_WITHOUT_BLUETOOTH.equals(I.f76832h)) {
                I.i0(TraeConstants.VOICE_CALL_CONFIG);
            } else if (TraeConstants.VIDEO_CALL_CONFIG_WITHOUT_BLUETOOTH.equals(I.f76832h)) {
                I.i0(TraeConstants.VIDEO_CALL_CONFIG);
            }
        }
    }

    public static void j0(VideoAppInterface videoAppInterface, boolean z16, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("TraeSessionHelper", 1, "startShake seq[" + j3 + "]", new Throwable());
        }
        if (videoAppInterface != null && videoAppInterface.getApp() != null && A(videoAppInterface) && y(videoAppInterface.getApp().getApplicationContext())) {
            if (z16) {
                com.tencent.av.compat.b.b(videoAppInterface.getApp(), 200L);
            } else {
                com.tencent.av.compat.b.c(videoAppInterface.getApp(), F, 1);
            }
        }
    }

    private void l0(IMediaPlayerApi iMediaPlayerApi) {
        if (iMediaPlayerApi != null) {
            iMediaPlayerApi.stopRing(0L);
        }
    }

    public static void n0(VideoAppInterface videoAppInterface) {
        if (videoAppInterface != null && videoAppInterface.getApp() != null) {
            QLog.w("TraeSessionHelper", 1, "stopShake.");
            Vibrator vibrator = (Vibrator) videoAppInterface.getApp().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.cancel();
            }
        }
    }

    private void p0() {
        IMediaPlayerApi iMediaPlayerApi = this.f76827c;
        if (iMediaPlayerApi != null) {
            this.f76831g = false;
            iMediaPlayerApi.stopRing(0L);
            this.f76827c = null;
        }
    }

    private void q0() {
        Context context;
        AudioManager audioManager;
        WeakReference<Context> weakReference = this.f76829e;
        if (weakReference != null && this.f76847w != null && (context = weakReference.get()) != null && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
            audioManager.unregisterAudioDeviceCallback(this.f76847w);
            this.f76847w = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        QActivityLifecycleCallbacks qActivityLifecycleCallbacks = this.f76848x;
        if (qActivityLifecycleCallbacks == null) {
            return;
        }
        Foreground.removeActivityLifeCallback(qActivityLifecycleCallbacks);
        this.f76848x = null;
    }

    @TargetApi(31)
    private void s0() {
        Context context;
        PhoneStatusAudioModeMonitor u06;
        if (this.f76829e == null || com.tencent.av.r.h0() == null || (context = this.f76829e.get()) == null || (u06 = com.tencent.av.r.h0().u0()) == null) {
            return;
        }
        u06.o(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(String str, String str2) {
        if (!this.f76842r && !this.f76841q && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f76841q = TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str);
        }
    }

    public static boolean y(Context context) {
        boolean z16 = false;
        int readValueForInt = SettingCloneUtil.readValueForInt(context, null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, 0);
        int i3 = (int) (com.tencent.av.utils.e.i() / 1000);
        if (i3 > readValueForInt) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TraeSessionHelper", 2, "canDisturb, ret[" + z16 + "], cur[" + i3 + "], mode[" + readValueForInt + "]");
        }
        return z16;
    }

    private static boolean z(VideoAppInterface videoAppInterface) {
        return true;
    }

    public int E(long j3, String str) {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("connectDevice, strDevice[");
            sb5.append(str);
            sb5.append("], mNtrtcAudioDevice[");
            if (this.f76826b != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.w("TraeSessionHelper", 1, sb5.toString());
        }
        if (this.f76826b == null) {
            NtrtcAudioDevice ntrtcAudioDevice = new NtrtcAudioDevice();
            this.f76826b = ntrtcAudioDevice;
            ntrtcAudioDevice.init(this.f76835k);
        }
        return this.f76826b.connectDevice(j3, str);
    }

    public int F() {
        if (QLog.isColorLevel()) {
            QLog.d("TraeSessionHelper", 2, "connectHighestPriorityDevice");
        }
        if (this.f76826b == null) {
            NtrtcAudioDevice ntrtcAudioDevice = new NtrtcAudioDevice();
            this.f76826b = ntrtcAudioDevice;
            ntrtcAudioDevice.init(this.f76835k);
        }
        return this.f76826b.connectHighestPriorityDevice();
    }

    public void L() {
        if (com.tencent.av.r.h0() == null) {
            return;
        }
        long d16 = com.tencent.av.utils.e.d();
        if (this.f76836l) {
            if (!TextUtils.isEmpty(com.tencent.av.n.e().f().F0)) {
                this.f76826b.connectDevice(d16, com.tencent.av.n.e().f().F0);
                return;
            } else {
                this.f76826b.connectHighestPriorityDevice();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TraeSessionHelper", 1, "initTRAE, seq[" + d16 + "]");
        }
        WeakReference<Context> weakReference = this.f76829e;
        if (weakReference != null && weakReference.get() != null) {
            if (this.f76826b == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TraeSessionHelper", 2, "initTRAE new mNtrtcAudioDevice");
                }
                NtrtcAudioDevice ntrtcAudioDevice = new NtrtcAudioDevice();
                this.f76826b = ntrtcAudioDevice;
                ntrtcAudioDevice.init(this.f76835k);
            }
            if (!TextUtils.isEmpty(com.tencent.av.n.e().f().F0)) {
                this.f76826b.connectDevice(d16, com.tencent.av.n.e().f().F0);
            } else {
                this.f76826b.connectHighestPriorityDevice();
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            W();
        }
        NtrtcAudioDevice ntrtcAudioDevice2 = this.f76826b;
        if (ntrtcAudioDevice2 != null) {
            ntrtcAudioDevice2.getStreamType();
        }
        this.f76836l = true;
    }

    public void S() {
        T(C);
    }

    public void T(int i3) {
        boolean z16;
        Throwable th5;
        Context context;
        Button button;
        if (com.tencent.av.r.h0() != null && this.f76826b != null) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (i3 == D) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isDevelopLevel()) {
                th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
            } else {
                th5 = null;
            }
            long d16 = com.tencent.av.utils.e.d();
            QLog.w("TraeSessionHelper", 1, "pressHandFreeBtn, isSpeakerOn[" + f16.I0 + "], seq[" + d16 + "]", th5);
            String[] strArr = f16.H0;
            if (QLog.isColorLevel() && strArr != null) {
                StringBuilder sb5 = new StringBuilder();
                for (String str : strArr) {
                    sb5.append(str);
                    sb5.append(";");
                }
                QLog.w("TraeSessionHelper", 1, "pressHandFreeBtn, strDeviceList[" + ((Object) sb5) + "]");
            }
            D(strArr);
            if (strArr != null) {
                if (this.f76842r && af.F()) {
                    WeakReference<Button> weakReference = this.f76833i;
                    if (weakReference != null) {
                        Button button2 = weakReference.get();
                        if (button2 != null) {
                            context = button2.getContext();
                            button = button2;
                        } else {
                            button = button2;
                            context = null;
                        }
                    } else {
                        context = null;
                        button = null;
                    }
                    if (context != null) {
                        j jVar = new j(strArr);
                        if (!TextUtils.isEmpty(f16.G0)) {
                            jVar.c(f16.G0);
                        }
                        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(context, null);
                        actionSheet.setMainTitle(R.string.ddt);
                        ListView listView = new ListView(context);
                        f fVar = this.f76845u;
                        if (fVar == null) {
                            this.f76845u = new f(context, jVar);
                        } else {
                            fVar.c(context, jVar);
                        }
                        listView.setAdapter((ListAdapter) this.f76845u);
                        listView.setDivider(new ColorDrawable(Color.parseColor("#e5e3e4")));
                        listView.setDividerHeight(1);
                        NtrtcAudioDevice ntrtcAudioDevice = this.f76826b;
                        if (ntrtcAudioDevice != null) {
                            ntrtcAudioDevice.getConnectedDevice(d16);
                        }
                        listView.setOnItemClickListener(new a(button, d16, actionSheet));
                        actionSheet.addView(listView);
                        actionSheet.addCancelButton(R.string.cancel);
                        actionSheet.setOnDismissListener(new b());
                        actionSheet.setOnShowListener(new c());
                        actionSheet.show();
                        return;
                    }
                    return;
                }
                if (f16.I0) {
                    boolean z17 = false;
                    do {
                        int i16 = 0;
                        while (true) {
                            if (i16 >= strArr.length) {
                                break;
                            }
                            if (TraeConstants.DEVICE_WIRED_HEADSET.equals(strArr[i16])) {
                                this.f76826b.connectDevice(d16, TraeConstants.DEVICE_WIRED_HEADSET);
                                z17 = true;
                                break;
                            }
                            i16++;
                        }
                        int i17 = 0;
                        while (true) {
                            if (i17 >= strArr.length || z17) {
                                break;
                            }
                            if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(strArr[i17])) {
                                this.f76826b.connectDevice(d16, TraeConstants.DEVICE_BLUETOOTH_HEADSET);
                                z17 = true;
                                break;
                            }
                            i17++;
                        }
                        int i18 = 0;
                        while (true) {
                            if (i18 >= strArr.length || z17) {
                                break;
                            }
                            if (TraeConstants.DEVICE_EARPHONE.equals(strArr[i18])) {
                                this.f76826b.connectDevice(d16, TraeConstants.DEVICE_EARPHONE);
                                z17 = true;
                                break;
                            }
                            i18++;
                        }
                    } while (!z17);
                } else {
                    this.f76826b.connectDevice(d16, TraeConstants.DEVICE_SPEAKERPHONE);
                }
                if (z16) {
                    this.f76840p = true;
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TraeSessionHelper", 2, "pressHandFreeBtn: devicesList is null");
            }
            this.f76826b.getDeviceList();
        }
    }

    public synchronized void X(long j3) {
        QLog.w("TraeSessionHelper", 1, "releaseTRAE, seq[" + j3 + "]");
        if (this.f76826b != null) {
            m0();
            this.f76826b.release();
            this.f76826b = null;
            if (QLog.isColorLevel()) {
                QLog.w("TraeSessionHelper", 1, "releaseTRAE, mNtrtcAudioDevice.release, seq[" + j3 + "]");
            }
            this.f76836l = false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            s0();
        }
        this.f76828d = null;
    }

    public void a0() {
        if (com.tencent.av.r.h0() == null) {
            return;
        }
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isDevelopLevel()) {
            QLog.w("TraeSessionHelper", 1, "setHFBtnStatus, deviceName[" + com.tencent.av.n.e().f().F0 + "], seq[" + d16 + "]");
        }
        com.tencent.av.n.e().f().r0("setHFBtnStatus", TraeConstants.DEVICE_SPEAKERPHONE.equals(com.tencent.av.n.e().f().F0));
        o0(d16, com.tencent.av.n.e().f());
    }

    public void b0(Button button) {
        if (button != null && (button.getContext() instanceof Activity) && ((Activity) button.getContext()).isFinishing()) {
            return;
        }
        this.f76833i = new WeakReference<>(button);
        this.f76843s = false;
    }

    public void c0(Button button) {
        if (button != null && (button.getContext() instanceof Activity) && ((Activity) button.getContext()).isFinishing()) {
            return;
        }
        this.f76833i = new WeakReference<>(button);
        this.f76843s = true;
    }

    public void d0(boolean z16) {
        if (QLog.isDevelopLevel() || z16 != this.f76844t) {
            QLog.d("TraeSessionHelper", 2, String.format("setLightStyle lightStyle=%s mLightBtnStyle=%s", Boolean.valueOf(z16), Boolean.valueOf(this.f76844t)));
        }
        this.f76844t = z16;
        R();
    }

    public boolean e0(long j3, VideoAppInterface videoAppInterface, int i3, int i16, MediaPlayer.OnCompletionListener onCompletionListener) {
        boolean z16;
        int i17;
        String str;
        boolean z17;
        int i18;
        String str2;
        if (!z(videoAppInterface) || !y(videoAppInterface.getApp().getApplicationContext())) {
            return false;
        }
        if (this.f76826b != null) {
            if (QLog.isDevelopLevel() || this.f76828d != onCompletionListener) {
                QLog.w("TraeSessionHelper", 1, "startInviteRing, mRingComListener[" + this.f76828d + "->" + onCompletionListener + "], seq[" + j3 + "]");
            }
            this.f76828d = onCompletionListener;
            if (i3 != SoundAndVibrateActivity.G0) {
                if (i16 < 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (i16 <= 0) {
                    i18 = 1;
                } else {
                    i18 = i16;
                }
                if (onCompletionListener != null) {
                    str2 = "comp-ring";
                } else {
                    str2 = "normal-ring";
                }
                M(j3, 0, i3, null, null, z17, i18, str2, true);
            } else {
                Uri uri = Settings.System.DEFAULT_NOTIFICATION_URI;
                if (i16 < 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i16 <= 0) {
                    i17 = 1;
                } else {
                    i17 = i16;
                }
                if (onCompletionListener != null) {
                    str = "comp-ring";
                } else {
                    str = "normal-ring";
                }
                M(j3, 1, -1, uri, null, z16, i17, str, true);
            }
        } else {
            AudioUtil.l(i3, i16, onCompletionListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x001d, B:9:0x0022, B:11:0x0028, B:15:0x0064, B:26:0x008e, B:32:0x0093, B:41:0x00a9, B:45:0x00bd, B:52:0x00d1, B:56:0x0030, B:57:0x00e4), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f0(long j3, VideoAppInterface videoAppInterface, int i3, String str, int i16, MediaPlayer.OnCompletionListener onCompletionListener) {
        boolean z16;
        int i17;
        String str2;
        boolean z17;
        int i18;
        String str3;
        boolean z18;
        int i19;
        String str4;
        try {
            if (z(videoAppInterface) && y(videoAppInterface.getApp().getApplicationContext())) {
                if (this.f76826b != null) {
                    if (!QLog.isDevelopLevel() && this.f76828d == onCompletionListener) {
                        this.f76828d = onCompletionListener;
                        if (i3 != 0) {
                            if (i16 < 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (i16 <= 0) {
                                i19 = 1;
                            } else {
                                i19 = i16;
                            }
                            if (onCompletionListener != null) {
                                str4 = "comp-ring";
                            } else {
                                str4 = "normal-ring";
                            }
                            M(j3, 2, i3, null, str, z18, i19, str4, true);
                        } else if (i3 != SoundAndVibrateActivity.G0) {
                            if (i16 < 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (i16 <= 0) {
                                i18 = 1;
                            } else {
                                i18 = i16;
                            }
                            if (onCompletionListener != null) {
                                str3 = "comp-ring";
                            } else {
                                str3 = "normal-ring";
                            }
                            M(j3, 0, i3, null, null, z17, i18, str3, true);
                        } else {
                            Uri uri = Settings.System.DEFAULT_NOTIFICATION_URI;
                            if (i16 < 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (i16 <= 0) {
                                i17 = 1;
                            } else {
                                i17 = i16;
                            }
                            if (onCompletionListener != null) {
                                str2 = "comp-ring";
                            } else {
                                str2 = "normal-ring";
                            }
                            M(j3, 1, -1, uri, null, z16, i17, str2, true);
                        }
                    }
                    QLog.w("TraeSessionHelper", 1, "startInviteRing, [" + this.f76828d + "->" + onCompletionListener + "], seq[" + j3 + "]");
                    this.f76828d = onCompletionListener;
                    if (i3 != 0) {
                    }
                } else {
                    AudioUtil.l(i3, i16, onCompletionListener);
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084 A[Catch: Exception -> 0x00b5, TryCatch #0 {Exception -> 0x00b5, blocks: (B:3:0x000d, B:5:0x0013, B:7:0x0021, B:9:0x0025, B:11:0x002b, B:15:0x0064, B:25:0x0094, B:28:0x0084, B:31:0x008d, B:35:0x0033, B:36:0x00a4), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g0(long j3, VideoAppInterface videoAppInterface, int i3, String str, int i16, MediaPlayer.OnCompletionListener onCompletionListener) {
        boolean z16;
        int i17;
        String str2;
        Uri uri;
        String str3;
        int i18;
        int i19;
        try {
            if (z(videoAppInterface) && y(videoAppInterface.getApp().getApplicationContext())) {
                if (this.f76826b != null) {
                    if (!QLog.isDevelopLevel() && this.f76828d == onCompletionListener) {
                        this.f76828d = onCompletionListener;
                        if (i16 >= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (i16 > 0) {
                            i17 = 1;
                        } else {
                            i17 = i16;
                        }
                        if (onCompletionListener == null) {
                            str2 = "comp-ring";
                        } else {
                            str2 = "normal-ring";
                        }
                        String str4 = str2;
                        if (i3 != 0) {
                            str3 = str;
                            i18 = i3;
                            uri = null;
                            i19 = 2;
                        } else if (i3 != SoundAndVibrateActivity.G0) {
                            i18 = i3;
                            uri = null;
                            str3 = null;
                            i19 = 0;
                        } else {
                            uri = Settings.System.DEFAULT_NOTIFICATION_URI;
                            str3 = null;
                            i18 = -1;
                            i19 = 1;
                        }
                        M(j3, i19, i18, uri, str3, z16, i17, str4, false);
                    }
                    QLog.w("TraeSessionHelper", 1, "startRing, mRingComListener[" + this.f76828d + "->" + onCompletionListener + "], seq[" + j3 + "]");
                    this.f76828d = onCompletionListener;
                    if (i16 >= 0) {
                    }
                    if (i16 > 0) {
                    }
                    if (onCompletionListener == null) {
                    }
                    String str42 = str2;
                    if (i3 != 0) {
                    }
                    M(j3, i19, i18, uri, str3, z16, i17, str42, false);
                } else {
                    AudioUtil.l(i3, i16, onCompletionListener);
                }
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.w("TraeSessionHelper", 1, "startRing, fail");
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.w("TraeSessionHelper", 1, "startRing, Exception", e16);
            }
            return false;
        }
    }

    public int h0(long j3, String str, String str2) {
        Throwable th5;
        boolean z16;
        if (QLog.isDevelopLevel()) {
            th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
        } else {
            th5 = null;
        }
        boolean C2 = C(this.f76829e.get());
        if (!C2) {
            if (TraeConstants.VOICE_CALL_CONFIG.equals(str)) {
                str = TraeConstants.VOICE_CALL_CONFIG_WITHOUT_BLUETOOTH;
            } else if (TraeConstants.VIDEO_CALL_CONFIG.equals(str)) {
                str = TraeConstants.VIDEO_CALL_CONFIG_WITHOUT_BLUETOOTH;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("prepare to start, config[");
        sb5.append(str);
        sb5.append("], WhenServiceOn[");
        sb5.append(str2);
        sb5.append("], mHasStartService[");
        sb5.append(this.f76830f);
        sb5.append("], mNtrtcAudioDevice[");
        if (this.f76826b != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("], isAllowedUseBluetoothDevice[");
        sb5.append(C2);
        sb5.append("]");
        QLog.w("TraeSessionHelper", 1, sb5.toString(), th5);
        this.f76849y = str2;
        if (this.f76826b == null) {
            NtrtcAudioDevice ntrtcAudioDevice = new NtrtcAudioDevice();
            this.f76826b = ntrtcAudioDevice;
            ntrtcAudioDevice.init(this.f76835k);
        }
        if (this.f76830f) {
            if (str.equals(this.f76832h)) {
                return 0;
            }
            QLog.w("TraeSessionHelper", 1, "stop current service!");
            O();
            p0();
            q0();
            r0();
            this.f76826b.stopService();
        }
        QLog.w("TraeSessionHelper", 1, "real startService, config[" + str + "], WhenServiceOn[" + str2 + "], seq[" + j3 + "], isAllowedUseBluetoothDevice[" + C2 + "]");
        int startService = this.f76826b.startService(j3, str, str2, C2);
        this.f76826b.getStreamType();
        K();
        if (!C2) {
            U();
            V();
        }
        if (startService == 0) {
            this.f76832h = str;
            this.f76830f = true;
        }
        return startService;
    }

    public int i0(String str) {
        return h0(com.tencent.av.utils.e.d(), str, null);
    }

    public void k0(long j3) {
        if (this.f76826b != null) {
            N(j3);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.TraeHelper.8
                @Override // java.lang.Runnable
                public void run() {
                    AudioUtil.s();
                }
            }, 16, null, true);
        }
    }

    public void m0() {
        Throwable th5;
        boolean z16;
        if (QLog.isDevelopLevel()) {
            th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
        } else {
            th5 = null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("stopSerivce, mHasStartService[");
        sb5.append(this.f76830f);
        sb5.append("], mNtrtcAudioDevice[");
        if (this.f76826b != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("]");
        QLog.w("TraeSessionHelper", 1, sb5.toString(), th5);
        if (!this.f76830f) {
            return;
        }
        if (this.f76826b == null) {
            NtrtcAudioDevice ntrtcAudioDevice = new NtrtcAudioDevice();
            this.f76826b = ntrtcAudioDevice;
            ntrtcAudioDevice.init(this.f76835k);
        }
        O();
        p0();
        q0();
        r0();
        ai.l(false);
        this.f76826b.stopService();
        this.f76839o = 0;
        this.f76830f = false;
    }

    public void o0(long j3, SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TraeSessionHelper", 1, "switchButton_handFree, !sessionInfo, seq[" + j3 + "]");
                return;
            }
            return;
        }
        if (com.tencent.av.r.h0() == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("TraeSessionHelper", 1, "switchButton_handFree, isSpeakerOn[" + sessionInfo.I0 + "], seq[" + j3 + "]");
        }
        this.f76846v = sessionInfo;
        VideoAppInterface.N().M().removeCallbacks(this.B);
        VideoAppInterface.N().M().postDelayed(this.B, 100L);
    }

    public void x() {
        if (QLog.isColorLevel()) {
            QLog.e("TraeSessionHelper", 2, "abandonAudioFocus");
        }
        WeakReference<Context> weakReference = this.f76829e;
        if (weakReference != null && weakReference.get() != null) {
            AudioManager audioManager = (AudioManager) this.f76829e.get().getSystemService("audio");
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f76837m;
            if (onAudioFocusChangeListener != null && audioManager != null) {
                audioManager.abandonAudioFocus(onAudioFocusChangeListener);
                this.f76837m = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class i implements QActivityLifecycleCallbacks {
        i() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@androidx.annotation.NonNull Activity activity) {
            TraeHelper I = TraeHelper.I();
            if (I != null && I.f76826b != null && I.f76836l && I.f76830f && I.f76847w != null && I.f76847w.d() && TraeHelper.P(activity)) {
                I.f76847w.c(activity);
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            WeakReference<Context> weakReference;
            Context context;
            TraeHelper I = TraeHelper.I();
            if (I != null && (weakReference = I.f76829e) != null && (context = weakReference.get()) != null) {
                boolean C = I.C(context);
                QLog.d("TraeSessionHelper", 1, "onProcessForeground hasPermission=" + C);
                if (C) {
                    TraeHelper.Z();
                    I.r0();
                }
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@androidx.annotation.NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@androidx.annotation.NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@androidx.annotation.NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@androidx.annotation.NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@androidx.annotation.NonNull Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@androidx.annotation.NonNull Activity activity, @androidx.annotation.NonNull Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class k implements ITraeAudioCallback {

        /* renamed from: a, reason: collision with root package name */
        private boolean f76882a = false;

        k() {
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onBeginConnectDevice(String str) {
            if (QLog.isColorLevel()) {
                QLog.i("TraeSessionHelper", 2, "lgx onBeginConnectDevice connectedDev: " + str);
            }
            if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str)) {
                cw.e.n((VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime(), 3014);
                this.f76882a = true;
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onConnectDeviceRes(int i3, String str, boolean z16) {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w("TraeSessionHelper", 1, "onConnectDeviceRes, err[" + i3 + "], strDeviceName[" + str + "], bIsConnected[" + z16 + "], seq[" + d16 + "]");
            }
            if (!z16 || com.tencent.av.r.h0() == null) {
                return;
            }
            if (com.tencent.av.n.e().f().f73025g != 3) {
                com.tencent.av.n.e().f().Y("onConnectDeviceRes", str);
            }
            TraeHelper.this.a0();
            NtrtcAudioDevice ntrtcAudioDevice = TraeHelper.this.f76826b;
            if (ntrtcAudioDevice != null) {
                ntrtcAudioDevice.getConnectedDevice(d16);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onDeviceChangeableUpdate(boolean z16) {
            if (com.tencent.av.r.h0() == null) {
                return;
            }
            int i3 = com.tencent.av.n.e().f().f73035i;
            if ((i3 != 1 && i3 != 2) || !com.tencent.av.r.h0().i1()) {
                return;
            }
            com.tencent.av.n.e().f().z();
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onDeviceExternalSwitch(String str) {
            boolean z16;
            if (QLog.isColorLevel()) {
                QLog.i("TraeSessionHelper", 2, "onDeviceExternalSwitch switchThreadDeviceName: " + str);
            }
            if (TraeHelper.this.f76826b != null && com.tencent.av.r.h0() != null) {
                if (TraeConstants.DEVICE_EARPHONE.equals(str)) {
                    TraeHelper traeHelper = TraeHelper.this;
                    traeHelper.f76826b.forceSwitchAudioDevice(str, traeHelper.B());
                } else if (TraeConstants.DEVICE_SPEAKERPHONE.equals(str)) {
                    boolean endsWith = MobileQQ.processName.endsWith(MsfConstants.PROCESS_VIDEO);
                    if (!com.tencent.av.n.e().f().I0 && endsWith) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    TraeHelper.this.f76826b.forceSwitchAudioDevice(str, !z16);
                }
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onDeviceListUpdate(long j3, String[] strArr, String str, String str2, String str3) {
            String str4;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                for (String str5 : strArr) {
                    sb5.append(str5);
                    sb5.append(" ");
                }
                QLog.w("TraeSessionHelper", 1, "onDeviceListUpdate, strConnectedDeviceName[" + str + "], strPrevConnectedDeviceName[" + str2 + "], bluetoothName[" + str3 + "], strDeviceList[" + sb5.toString() + "], seq[" + j3 + "]");
            }
            if (com.tencent.av.r.h0() == null) {
                return;
            }
            if (this.f76882a && TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str)) {
                cw.e.d((VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime(), 3014);
                this.f76882a = false;
            }
            SessionInfo f16 = com.tencent.av.n.e().f();
            String[] strArr2 = f16.H0;
            if (f16.f73025g != 3) {
                str4 = f16.F0;
                f16.Y("onDeviceListUpdate", str);
            } else {
                str4 = "";
            }
            f16.H0 = strArr;
            f16.G0 = str3;
            TraeHelper.this.D(strArr);
            TraeHelper.this.t0(str4, str);
            if (TraeHelper.this.f76845u != null) {
                TraeHelper.this.f76845u.notifyDataSetChanged();
            }
            TraeHelper.this.a0();
            if (TraeHelper.this.f76826b != null && strArr2 != null && strArr != null) {
                List asList = Arrays.asList(strArr2);
                List asList2 = Arrays.asList(strArr);
                if (asList2.contains(TraeConstants.DEVICE_BLUETOOTH_HEADSET) && asList2.contains(TraeConstants.DEVICE_WIRED_HEADSET)) {
                    if (asList.contains(TraeConstants.DEVICE_BLUETOOTH_HEADSET) && !asList.contains(TraeConstants.DEVICE_WIRED_HEADSET)) {
                        if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str)) {
                            TraeHelper.this.f76826b.connectDevice(j3, TraeConstants.DEVICE_WIRED_HEADSET);
                        }
                    } else if (!asList.contains(TraeConstants.DEVICE_BLUETOOTH_HEADSET) && asList.contains(TraeConstants.DEVICE_WIRED_HEADSET) && TraeConstants.DEVICE_WIRED_HEADSET.equals(str)) {
                        TraeHelper.this.f76826b.connectDevice(j3, TraeConstants.DEVICE_BLUETOOTH_HEADSET);
                    }
                }
            }
            if (strArr != null) {
                for (String str6 : strArr) {
                    if (str6.equals(TraeConstants.DEVICE_WIRED_HEADSET)) {
                        DataReport.A();
                    }
                }
            }
            if (!TraeConstants.DEVICE_NONE.equals(com.tencent.av.n.e().f().f73065p1)) {
                if (TraeHelper.this.f76826b != null && !str.equals(com.tencent.av.n.e().f().f73065p1)) {
                    TraeHelper.this.f76826b.connectDevice(j3, com.tencent.av.n.e().f().f73065p1);
                }
                com.tencent.av.n.e().f().f73065p1 = TraeConstants.DEVICE_NONE;
            }
            if (TraeHelper.this.f76845u != null) {
                TraeHelper.this.f76845u.c(null, new j(strArr));
                NtrtcAudioDevice ntrtcAudioDevice = TraeHelper.this.f76826b;
                if (ntrtcAudioDevice != null) {
                    ntrtcAudioDevice.getConnectedDevice(j3);
                }
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onGetConnectedDeviceRes(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("TraeSessionHelper", 2, "onGetConnectedDeviceRes err is: " + i3 + " device name is: " + str);
            }
            if (TraeHelper.this.f76845u != null) {
                TraeHelper.this.f76845u.b(str);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onGetDeviceListRes(int i3, String[] strArr, String str, String str2, String str3) {
            if (i3 != 0) {
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                if (strArr != null) {
                    for (String str4 : strArr) {
                        sb5.append(str4);
                        sb5.append(" ");
                    }
                }
                QLog.d("TraeSessionHelper", 2, "onGetDeviceListRes strDeviceList: " + sb5.toString());
            }
            if (com.tencent.av.r.h0() == null) {
                return;
            }
            String str5 = com.tencent.av.n.e().f().F0;
            com.tencent.av.n.e().f().H0 = strArr;
            com.tencent.av.n.e().f().Y("onGetDeviceListRes", str);
            com.tencent.av.n.e().f().G0 = str3;
            TraeHelper.this.D(strArr);
            TraeHelper.this.t0(str5, str);
            if (strArr != null) {
                for (String str6 : strArr) {
                    if (str6.equals(TraeConstants.DEVICE_WIRED_HEADSET)) {
                        DataReport.A();
                    }
                }
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onGetStreamTypeRes(int i3, int i16, int i17) {
            TraeHelper traeHelper;
            IMediaPlayerApi iMediaPlayerApi;
            if (i3 != 0 || com.tencent.av.r.h0() == null) {
                return;
            }
            if (i17 == 2 && (iMediaPlayerApi = (traeHelper = TraeHelper.this).f76827c) != null) {
                traeHelper.f76825a = iMediaPlayerApi.getStreamType();
                com.tencent.av.n.e().f().E0 = TraeHelper.this.f76827c.getStreamType();
            } else {
                TraeHelper.this.f76825a = i16;
                com.tencent.av.n.e().f().E0 = i16;
            }
            TraeHelper.this.f76839o = i17;
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onServiceStateUpdate(long j3, boolean z16) {
            if (z16 && !TextUtils.isEmpty(TraeHelper.this.f76849y)) {
                if (QLog.isColorLevel()) {
                    QLog.w("TraeSessionHelper", 1, "ConnectDeviceWhenServiceOn, deviceName[" + TraeHelper.this.f76849y + "], seq[" + j3 + "]");
                }
                TraeHelper traeHelper = TraeHelper.this;
                traeHelper.E(j3, traeHelper.f76849y);
            }
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onStreamTypeUpdate(long j3, int i3, int i16) {
            if (com.tencent.av.r.h0() == null) {
                return;
            }
            TraeHelper.this.f76825a = i3;
            com.tencent.av.n.e().f().E0 = i3;
            TraeHelper.this.f76839o = i16;
            if (QLog.isColorLevel()) {
                QLog.w("TraeSessionHelper", 1, "onStreamTypeUpdate, streamType[" + i3 + "], activeMode[" + i16 + "], seq[" + j3 + "]");
            }
            TraeHelper.this.o0(j3, com.tencent.av.n.e().f());
        }

        @Override // com.tencent.avcore.jni.audiodevice.api.ITraeAudioCallback
        public void onVoiceCallPreProcessRes(int i3) {
        }
    }
}
