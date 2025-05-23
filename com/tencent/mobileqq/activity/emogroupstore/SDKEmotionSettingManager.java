package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.permission.a;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.util.MqqWeakReferenceHandler;
import com.vivo.push.PushClientConstants;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SDKEmotionSettingManager implements Handler.Callback, com.tencent.mobileqq.activity.emogroupstore.n {
    static IPatchRedirector $redirector_;
    private String C;
    protected boolean D;
    protected boolean E;
    private boolean F;
    private List<Integer> G;
    private List<String> H;
    private List<Uri> I;
    private String J;
    private final MqqHandler K;
    private boolean L;
    private Runnable M;
    private Runnable N;
    private Runnable P;
    protected QQProgressDialog Q;
    protected QQCustomDialog R;
    protected QQCustomDialog S;
    private s T;

    /* renamed from: d, reason: collision with root package name */
    private final long f182067d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f182068e;

    /* renamed from: f, reason: collision with root package name */
    private String f182069f;

    /* renamed from: h, reason: collision with root package name */
    private String f182070h;

    /* renamed from: i, reason: collision with root package name */
    private String f182071i;

    /* renamed from: m, reason: collision with root package name */
    private String f182072m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4) {
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                sDKEmotionSettingManager.V(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue());
                SDKEmotionSettingManager.this.H();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("SDKEmotionSettingManager", 1, "showAccountConfirm which=", Integer.valueOf(i3));
            if (i3 == 1) {
                SDKEmotionSettingManager.this.D();
            } else if (i3 == 0) {
                SDKEmotionSettingManager.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                dialogInterface.dismiss();
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                sDKEmotionSettingManager.V(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue());
                SDKEmotionSettingManager.this.H();
            } catch (Exception unused) {
                QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f182086d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f182087e;

        d(ArrayList arrayList, int i3) {
            this.f182086d = arrayList;
            this.f182087e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SDKEmotionSettingManager.this, arrayList, Integer.valueOf(i3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SDKEmotionSettingManager.this.F = true;
                SDKEmotionSettingManager.this.T.N(1);
                SDKEmotionSettingManager.this.a0(this.f182086d.size(), 0.0f);
                if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    SDKEmotionSettingManager.this.T.Q((int) (90.0f / this.f182087e));
                }
                SDKEmotionSettingManager.this.Z(this.f182086d);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f182089d;

        e(int i3) {
            this.f182089d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this, i3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SDKEmotionSettingManager.this.J(this.f182089d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f182091d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f182092e;

        f(int i3, ArrayList arrayList) {
            this.f182091d = i3;
            this.f182092e = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SDKEmotionSettingManager.this, Integer.valueOf(i3), arrayList);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!SDKEmotionSettingManager.this.F) {
                if (this.f182091d == 1) {
                    SDKSetEmotionPreviewFragment.sh((String) this.f182092e.get(0), SDKEmotionSettingManager.this.f182068e, null);
                } else {
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("path_list", this.f182092e);
                    PublicFragmentActivity.start(SDKEmotionSettingManager.this.f182068e, intent, SDKSetEmotionPreviewFragment.class);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                AbstractGifImage.pauseAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f182095d;

        h(int i3) {
            this.f182095d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this, i3);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4) {
                if (SDKEmotionSettingManager.this.F) {
                    SDKEmotionSettingManager.this.J(this.f182095d);
                } else {
                    SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                    sDKEmotionSettingManager.V(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue());
                    SDKEmotionSettingManager.this.H();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements IFavroamingManagerService.AddCustomEmotionsCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f182097a;

        i(int i3) {
            this.f182097a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onProgressChanged(float f16, List<Integer> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + f16 + ", addEmotionsResults=" + list + ", isTimeOut=" + SDKEmotionSettingManager.this.L);
            }
            if (!SDKEmotionSettingManager.this.L) {
                SDKEmotionSettingManager.this.b0(list);
                SDKEmotionSettingManager.this.a0(this.f182097a, f16);
            }
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onUploadFinish(List<Integer> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + list + ", isTimeOut=" + SDKEmotionSettingManager.this.L);
            }
            if (!SDKEmotionSettingManager.this.L) {
                SDKEmotionSettingManager.this.K.removeMessages(11);
                SDKEmotionSettingManager.this.I(this.f182097a, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j extends AsyncTask<Void, Void, ArrayList<String>> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f182099a;

        j(List list) {
            this.f182099a = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this, (Object) list);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<String> doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            return SDKEmotionSettingManager.this.F(this.f182099a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
                return;
            }
            if (arrayList != null && arrayList.size() != 0) {
                ReportController.o(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, arrayList.size() + "", "", "", "");
                SDKEmotionSettingManager.this.H.clear();
                SDKEmotionSettingManager.this.H.addAll(arrayList);
                SDKEmotionSettingManager.this.R(arrayList);
                return;
            }
            QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + arrayList);
            SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
            sDKEmotionSettingManager.W(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), false, "");
            SDKEmotionSettingManager.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f182101d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f182102e;

        k(boolean z16, String str) {
            this.f182101d = z16;
            this.f182102e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SDKEmotionSettingManager.this, Boolean.valueOf(z16), str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X8009DCB", "0X8009DCB", 0, 0, SDKEmotionSettingManager.this.f182071i, "", "", "");
            if (this.f182101d) {
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                sDKEmotionSettingManager.X(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), false);
            } else {
                SDKEmotionSettingManager sDKEmotionSettingManager2 = SDKEmotionSettingManager.this;
                sDKEmotionSettingManager2.W(sDKEmotionSettingManager2.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), false, this.f182102e);
            }
            SDKEmotionSettingManager.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f182104d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f182105e;

        l(boolean z16, String str) {
            this.f182104d = z16;
            this.f182105e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SDKEmotionSettingManager.this, Boolean.valueOf(z16), str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X8009DCA", "0X8009DCA", 0, 0, SDKEmotionSettingManager.this.f182071i, "", "", "");
            if (this.f182104d) {
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                sDKEmotionSettingManager.X(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), false);
            } else {
                SDKEmotionSettingManager sDKEmotionSettingManager2 = SDKEmotionSettingManager.this;
                sDKEmotionSettingManager2.W(sDKEmotionSettingManager2.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), false, this.f182105e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 0) {
                SDKEmotionSettingManager.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class n implements com.tencent.mobileqq.Doraemon.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f182108a;

        n(String str) {
            this.f182108a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d("SDKEmotionSettingManager", 1, "check api, onFailure, code=", Integer.valueOf(i3), ", msg=", str);
            if (SDKEmotionSettingManager.this.f182068e != null && !SDKEmotionSettingManager.this.f182068e.isFinishing()) {
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                if (!sDKEmotionSettingManager.E) {
                    sDKEmotionSettingManager.K();
                    if (SDKEmotionSettingManager.this.K != null) {
                        SDKEmotionSettingManager.this.K.removeCallbacks(SDKEmotionSettingManager.this.M);
                    }
                    SDKEmotionSettingManager.this.P(HardCodeUtil.qqStr(R.string.f172662t60), this.f182108a);
                    return;
                }
            }
            QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            QLog.d("SDKEmotionSettingManager", 1, "check api, onPermission, code=", Integer.valueOf(i3));
            if (SDKEmotionSettingManager.this.f182068e != null && !SDKEmotionSettingManager.this.f182068e.isFinishing()) {
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                if (!sDKEmotionSettingManager.E) {
                    sDKEmotionSettingManager.K();
                    if (SDKEmotionSettingManager.this.K != null) {
                        SDKEmotionSettingManager.this.K.removeCallbacks(SDKEmotionSettingManager.this.M);
                    }
                    SDKEmotionSettingManager.this.P(HardCodeUtil.qqStr(R.string.f172663t61), this.f182108a);
                }
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
                return;
            }
            QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
            if (SDKEmotionSettingManager.this.f182068e != null && !SDKEmotionSettingManager.this.f182068e.isFinishing()) {
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                if (!sDKEmotionSettingManager.E) {
                    if (sDKEmotionSettingManager.K != null) {
                        SDKEmotionSettingManager.this.K.removeCallbacks(SDKEmotionSettingManager.this.M);
                    }
                    SDKEmotionSettingManager.this.C();
                }
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
            } else {
                QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class o implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements a.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                }
            }

            @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
            public void allow() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QLog.i("SDKEmotionSettingManager", 1, "setEmotion show self dialog grant");
                }
            }

            @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
            public void reject() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                QLog.i("SDKEmotionSettingManager", 1, "setEmotion show self dialog denied");
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                sDKEmotionSettingManager.L(sDKEmotionSettingManager.I);
            }
        }

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
            } else {
                QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
                DialogUtil.showPermissionDialogForStorageWithCallback(SDKEmotionSettingManager.this.f182068e, new a());
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
            SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
            sDKEmotionSettingManager.L(sDKEmotionSettingManager.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class p extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + i3);
            if (SDKEmotionSettingManager.this.f182068e != null && !SDKEmotionSettingManager.this.f182068e.isFinishing()) {
                SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                if (!sDKEmotionSettingManager.D) {
                    sDKEmotionSettingManager.K();
                    if (SDKEmotionSettingManager.this.K != null) {
                        SDKEmotionSettingManager.this.K.removeCallbacks(SDKEmotionSettingManager.this.N);
                    }
                    if (i3 != 16) {
                        SDKEmotionSettingManager.this.D();
                        return;
                    } else {
                        SDKEmotionSettingManager.this.O();
                        return;
                    }
                }
            }
            QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class q implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 0) {
                SDKEmotionSettingManager.this.H();
            }
        }
    }

    public SDKEmotionSettingManager(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f182067d = 60000L;
        this.f182069f = null;
        this.f182070h = null;
        this.D = false;
        this.E = false;
        this.F = false;
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.K = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
        this.L = false;
        this.M = new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SDKEmotionSettingManager.this.f182068e != null && !SDKEmotionSettingManager.this.f182068e.isFinishing()) {
                    if (QLog.isColorLevel()) {
                        QLog.w("SDKEmotionSettingManager", 2, "checkApiTimeOutRunnable -->preForward--checkapi timeout");
                    }
                    SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                    sDKEmotionSettingManager.E = true;
                    sDKEmotionSettingManager.C();
                }
            }
        };
        this.N = new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SDKEmotionSettingManager.this.f182068e != null && !SDKEmotionSettingManager.this.f182068e.isFinishing()) {
                    QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->preForward--fetch openid timeout");
                    SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                    sDKEmotionSettingManager.D = true;
                    sDKEmotionSettingManager.K();
                    SDKEmotionSettingManager.this.D();
                    return;
                }
                QLog.i("SDKEmotionSettingManager", 1, "checkJumpActionTimeOutRunnable -->activity finish");
            }
        };
        this.P = new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SDKEmotionSettingManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (SDKEmotionSettingManager.this.f182068e != null && !SDKEmotionSettingManager.this.f182068e.isFinishing()) {
                    SDKEmotionSettingManager.this.f182068e.sendBroadcast(new Intent("com.tencent.mobileqq.action.refresh.emotiom"));
                } else {
                    QLog.i("SDKEmotionSettingManager", 1, "refreshEmotionRunnable -->activity finish");
                }
            }
        };
        this.R = null;
        this.S = null;
        if (QLog.isColorLevel()) {
            QLog.w("SDKEmotionSettingManager", 2, " onCreateView ");
        }
        this.f182068e = activity;
    }

    private void B() {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        String bytes2HexStr;
        if (this.f182068e == null) {
            QLog.e("SDKEmotionSettingManager", 1, "checkApiPermission activity is null");
            return;
        }
        String str = this.f182068e.getString(R.string.hih) + this.f182069f;
        try {
            if (!TextUtils.isEmpty(this.f182070h)) {
                try {
                    packageInfo = InstalledAppListMonitor.getPackageInfo(this.f182068e.getPackageManager(), this.f182070h, 64);
                } catch (Exception e16) {
                    QLog.e("SDKEmotionSettingManager", 1, "check, get signature exception=", e16);
                }
                if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(signatureArr[0].toByteArray());
                    bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
                    QLog.d("SDKEmotionSettingManager", 1, "checkApiPermission api, mShareAppId=", this.f182071i, ", mPkgName=", this.f182070h, ",signature=", bytes2HexStr, ",mSdkVerdion=", this.C);
                    if (TextUtils.isEmpty(this.f182071i) && !TextUtils.isEmpty(this.f182070h) && !TextUtils.isEmpty(bytes2HexStr)) {
                        ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
                        Bundle bundle = new Bundle();
                        bundle.putString("sdkVersion", this.C);
                        bundle.putString(PushClientConstants.TAG_PKG_NAME, this.f182070h);
                        bundle.putString("signature", bytes2HexStr);
                        S(R.string.hjn);
                        this.K.postDelayed(this.M, 5000L);
                        ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(this.f182068e, 1, this.f182071i, bundle).d("sdk_face_collection", null, new n(str));
                        return;
                    }
                    QLog.e("SDKEmotionSettingManager", 1, "check, invalid param, mShareAppId=", this.f182071i, ", pkgName=", this.f182070h, ", signature=", bytes2HexStr);
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f182068e, 230);
                    createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.f172664t63));
                    createCustomDialog.setNegativeButton(R.string.cancel, new m());
                    createCustomDialog.setCancelable(false);
                    createCustomDialog.show();
                    return;
                }
            } else {
                QLog.e("SDKEmotionSettingManager", 1, "check, pkgName null");
            }
            QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(this.f182068e, 230);
            createCustomDialog2.setMessage(HardCodeUtil.qqStr(R.string.f172664t63));
            createCustomDialog2.setNegativeButton(R.string.cancel, new m());
            createCustomDialog2.setCancelable(false);
            createCustomDialog2.show();
            return;
        } catch (Exception e17) {
            QLog.e("SDKEmotionSettingManager", 1, "show invalid param dialog, exception=", e17);
            return;
        }
        bytes2HexStr = null;
        QLog.d("SDKEmotionSettingManager", 1, "checkApiPermission api, mShareAppId=", this.f182071i, ", mPkgName=", this.f182070h, ",signature=", bytes2HexStr, ",mSdkVerdion=", this.C);
        if (TextUtils.isEmpty(this.f182071i)) {
        }
        QLog.e("SDKEmotionSettingManager", 1, "check, invalid param, mShareAppId=", this.f182071i, ", pkgName=", this.f182070h, ", signature=", bytes2HexStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction mShareAppId = " + this.f182071i + "\uff0c mShareOpenId =" + this.f182072m);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            W(this.f182068e, Long.valueOf(this.f182071i).longValue(), false, "-10");
            H();
            return;
        }
        if (!TextUtils.isEmpty(this.f182071i) && !TextUtils.isEmpty(this.f182072m)) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            OpenID b36 = qQAppInterface.getMsgHandler().b3(this.f182071i);
            if (b36 == null) {
                S(R.string.hjn);
                this.K.postDelayed(this.N, 8000L);
                try {
                    qQAppInterface.getMsgHandler().O2(Long.parseLong(qQAppInterface.getCurrentAccountUin()), this.f182072m, Long.valueOf(this.f182071i).longValue(), new p());
                    return;
                } catch (Exception e16) {
                    QLog.e("SDKEmotionSettingManager", 1, "-->parse uin exception:", e16);
                    return;
                }
            }
            if (!this.f182072m.equals(b36.openID)) {
                QLog.i("SDKEmotionSettingManager", 1, "-->preForward--openid doesn't equal current local openid");
                O();
                return;
            } else {
                K();
                D();
                return;
            }
        }
        QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction find third app not login setEmotion");
        K();
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        boolean b16 = BaseForwardUtil.b(this.f182068e);
        QLog.d("SDKEmotionSettingManager", 1, "setEmotion hasPermission=", Boolean.valueOf(b16));
        if (!b16) {
            Activity activity = this.f182068e;
            if (activity instanceof AppActivity) {
                PermissionUtils.requestStorePermission((AppActivity) activity, 3, new o());
                return;
            }
        }
        L(this.I);
    }

    private String G(List<Integer> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                int intValue = list.get(i3).intValue();
                if (intValue == 0) {
                    sb5.append("0_");
                } else if (intValue == 1) {
                    sb5.append("102_");
                } else if (intValue == 3) {
                    sb5.append("100_");
                } else if (intValue == 2) {
                    sb5.append("100_");
                } else {
                    sb5.append("101_");
                }
            }
            return sb5.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.K.removeMessages(11);
        E();
        Activity activity = this.f182068e;
        if (activity != null) {
            activity.moveTaskToBack(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i3, List<Integer> list) {
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "handleFinishUpload addEmotionsResults =" + list + ", totalSize =" + i3);
        }
        if (i3 == 0 || list == null || i3 != list.size()) {
            return;
        }
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < list.size(); i18++) {
            if (list.get(i18).intValue() == 0) {
                i16++;
            } else {
                i17++;
            }
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable(i3, i16, G(list), list, i17) { // from class: com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f182078d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f182079e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f182080f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ List f182081h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f182082i;

            {
                this.f182078d = i3;
                this.f182079e = i16;
                this.f182080f = r8;
                this.f182081h = list;
                this.f182082i = i17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SDKEmotionSettingManager.this, Integer.valueOf(i3), Integer.valueOf(i16), r8, list, Integer.valueOf(i17));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (SDKEmotionSettingManager.this.T != null) {
                    SDKEmotionSettingManager.this.T.dismiss();
                }
                SDKEmotionSettingManager.this.F = false;
                if (this.f182078d == this.f182079e) {
                    SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                    sDKEmotionSettingManager.X(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), true);
                } else {
                    SDKEmotionSettingManager sDKEmotionSettingManager2 = SDKEmotionSettingManager.this;
                    sDKEmotionSettingManager2.W(sDKEmotionSettingManager2.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), true, this.f182080f);
                }
                if (this.f182078d == 1) {
                    SDKEmotionSettingManager.this.U(((Integer) this.f182081h.get(0)).intValue(), this.f182080f);
                } else {
                    SDKEmotionSettingManager.this.Q(this.f182079e, this.f182082i, this.f182080f);
                }
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "handleStopUpload totalSize =" + i3 + ", mCurrentUploadedList = " + this.G);
        }
        this.K.removeMessages(11);
        Y();
        int i16 = 0;
        if (this.G != null) {
            int i17 = 0;
            while (i16 < this.G.size()) {
                if (this.G.get(i16).intValue() == 0) {
                    i17++;
                }
                i16++;
            }
            i16 = i17;
        }
        ThreadManager.getUIHandler().post(new Runnable(i3, i16, i3 - i16) { // from class: com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f182075d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f182076e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f182077f;

            {
                this.f182075d = i3;
                this.f182076e = i16;
                this.f182077f = r8;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SDKEmotionSettingManager.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(r8));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (SDKEmotionSettingManager.this.T != null) {
                    SDKEmotionSettingManager.this.T.dismiss();
                }
                SDKEmotionSettingManager.this.F = false;
                if (this.f182075d == this.f182076e) {
                    SDKEmotionSettingManager sDKEmotionSettingManager = SDKEmotionSettingManager.this;
                    sDKEmotionSettingManager.X(sDKEmotionSettingManager.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), true);
                } else {
                    SDKEmotionSettingManager sDKEmotionSettingManager2 = SDKEmotionSettingManager.this;
                    sDKEmotionSettingManager2.W(sDKEmotionSettingManager2.f182068e, Long.valueOf(SDKEmotionSettingManager.this.f182071i).longValue(), true, null);
                }
                if (this.f182075d != 1) {
                    SDKEmotionSettingManager.this.Q(this.f182076e, this.f182077f, null);
                    return;
                }
                if (SDKEmotionSettingManager.this.G != null && SDKEmotionSettingManager.this.G.size() > 0) {
                    i18 = ((Integer) SDKEmotionSettingManager.this.G.get(0)).intValue();
                } else {
                    i18 = -1;
                }
                SDKEmotionSettingManager.this.U(i18, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<Uri> list) {
        QLog.d("SDKEmotionSettingManager", 1, " openSetEmotion uriList = ", list);
        ((IFavroamingManagerService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).syncRoaming();
        this.K.postDelayed(this.P, 2000L);
        new j(list).execute(new Void[0]);
    }

    private void M() {
        this.D = false;
        this.E = false;
    }

    private void N() {
        try {
            PendingIntent pendingIntent = (PendingIntent) this.f182068e.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
            if (pendingIntent != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SDKEmotionSettingManager", 2, "-->finish--send callback using PendingIntent");
                }
                try {
                    pendingIntent.send();
                } catch (PendingIntent.CanceledException e16) {
                    QLog.e("SDKEmotionSettingManager", 2, "failed to send PendingIntent", e16);
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("SDKEmotionSettingManager", 2, "qbShowShareResultDialog ", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3, int i16, String str) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "showResultDialog successCount =" + i3 + ", failCount =" + i16);
        }
        if (i3 >= 0 && i16 >= 0) {
            if (i3 == 0 && i16 == 0) {
                return;
            }
            int i17 = i3 + i16;
            boolean z16 = true;
            if (i3 > 0 && i16 == 0) {
                str2 = String.format(BaseApplication.getContext().getResources().getString(R.string.afq), Integer.valueOf(i3), Integer.valueOf(i3));
            } else {
                if (i3 > 0 && i16 > 0) {
                    str2 = String.format(BaseApplication.getContext().getResources().getString(R.string.afs), Integer.valueOf(i3), Integer.valueOf(i17), Integer.valueOf(i16));
                } else if (i3 == 0 && i16 > 0) {
                    str2 = String.format(BaseApplication.getContext().getResources().getString(R.string.afl), Integer.valueOf(i16), Integer.valueOf(i16));
                } else {
                    z16 = false;
                    str2 = "";
                }
                z16 = false;
            }
            T(null, str2, z16, str);
            ReportController.o(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.f182071i, i17 + "", i3 + "", i16 + "");
            if (i16 > 0) {
                ReportController.o(null, "dc00898", "", "", "0X8009DCC", "0X8009DCC", 0, 0, "" + i16, "", "", "");
            }
        }
    }

    private void T(String str, String str2, boolean z16, String str3) {
        String str4;
        Activity activity = this.f182068e;
        if (activity != null && !activity.isFinishing()) {
            if (TextUtils.isEmpty(this.f182069f)) {
                str4 = HardCodeUtil.qqStr(R.string.f171898lr0);
            } else {
                str4 = HardCodeUtil.qqStr(R.string.f171898lr0) + this.f182069f;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f182068e, 230);
            createCustomDialog.setTitle(str);
            createCustomDialog.setMessage(str2);
            createCustomDialog.setPositiveButton("\u7559\u5728QQ", new l(z16, str3)).setNegativeButton(str4, new k(z16, str3)).show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "showResultDialog is finishing return");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i3, String str) {
        Resources resources;
        String string;
        String str2;
        String str3;
        String str4;
        String str5;
        Activity activity = this.f182068e;
        if (activity == null || (resources = activity.getResources()) == null) {
            return;
        }
        boolean z16 = true;
        if (i3 == 0) {
            str4 = resources.getString(R.string.afr);
            str2 = str;
            str3 = "";
        } else {
            if (i3 != 2 && i3 != 3) {
                if (i3 == 1) {
                    string = resources.getString(R.string.afo);
                } else {
                    string = resources.getString(R.string.afm);
                }
            } else {
                string = resources.getString(R.string.afj);
            }
            str2 = str;
            str3 = string;
            str4 = null;
            z16 = false;
        }
        T(str4, str3, z16, str2);
        String str6 = "1";
        if (z16) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        if (z16) {
            str6 = "0";
        }
        ReportController.o(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, this.f182071i, "1", str5 + "", str6 + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Activity activity, long j3) {
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "startSdkCancelCallback:sdk callback= appid=" + j3);
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", Long.valueOf(j3), "sdkSetEmotion")));
        if (activity.getIntent() != null) {
            intent.setPackage(this.f182070h);
        }
        try {
            PendingIntent activity2 = PendingIntent.getActivity(activity, 0, intent, 301989888);
            Intent intent2 = activity.getIntent();
            if (intent2 != null) {
                intent2.removeExtra("sdk_emotion_pending_intent");
                intent2.putExtra("sdk_emotion_pending_intent", activity2);
            }
        } catch (ActivityNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Activity activity, long j3, boolean z16, String str) {
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "startSdkErrorCallback:sdk callback= appid=" + j3);
        }
        Intent intent = new Intent();
        if (z16) {
            intent.putExtra("stay_back_stack", true);
        }
        if (str == null) {
            str = "";
        }
        intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", Long.valueOf(j3), "sdkSetEmotion", -1, str)));
        if (activity.getIntent() != null) {
            intent.setPackage(this.f182070h);
        }
        try {
            PendingIntent activity2 = PendingIntent.getActivity(activity, 0, intent, 301989888);
            Intent intent2 = activity.getIntent();
            if (intent2 != null) {
                intent2.removeExtra("sdk_emotion_pending_intent");
                intent2.putExtra("sdk_emotion_pending_intent", activity2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Activity activity, long j3, boolean z16) {
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, "startSdkSuccessCallback:sdk callback= appid=" + j3);
        }
        Intent intent = new Intent();
        if (z16) {
            intent.putExtra("stay_back_stack", true);
        }
        intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j3), "sdkSetEmotion")));
        if (activity.getIntent() != null) {
            intent.setPackage(this.f182070h);
        }
        try {
            PendingIntent activity2 = PendingIntent.getActivity(activity, 0, intent, 301989888);
            Intent intent2 = activity.getIntent();
            if (intent2 != null) {
                intent2.removeExtra("sdk_emotion_pending_intent");
                intent2.putExtra("sdk_emotion_pending_intent", activity2);
            }
        } catch (ActivityNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, e16.getMessage());
            }
        }
    }

    private void Y() {
        ((IFavroamingManagerService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).cancelAddCustomEmotions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.L = false;
            int size = arrayList.size();
            Message obtainMessage = this.K.obtainMessage(11);
            obtainMessage.arg1 = size;
            this.K.sendMessageDelayed(obtainMessage, 60000L);
            ((IFavroamingManagerService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).addCustomEmotions(arrayList, new i(size));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i3, float f16) {
        s sVar;
        Activity activity = this.f182068e;
        if (activity != null && !activity.isFinishing() && (sVar = this.T) != null && sVar.isShowing()) {
            int i16 = (int) (i3 * f16);
            int i17 = (int) (f16 * 100.0d);
            String format = String.format(this.f182068e.getResources().getString(R.string.afn), Integer.valueOf(i16), Integer.valueOf(i3));
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, "updateCurrentDisplay displayStr=" + format + " disPlayProgress=" + i17 + ", currentCount = " + i16);
            }
            ThreadManager.getUIHandler().post(new Runnable(format, i17) { // from class: com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.19
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f182073d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f182074e;

                {
                    this.f182073d = format;
                    this.f182074e = i17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, SDKEmotionSettingManager.this, format, Integer.valueOf(i17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        SDKEmotionSettingManager.this.T.X(this.f182073d, this.f182074e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(List<Integer> list) {
        if (this.G == null) {
            this.G = new ArrayList();
        }
        if (list != null && list.size() > 0) {
            this.G.clear();
            this.G.addAll(list);
        } else {
            this.G.clear();
        }
    }

    protected void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.f182068e != null) {
            N();
            this.f182068e.setResult(-1, new Intent());
            this.f182068e.finish();
        }
    }

    public ArrayList<String> F(List<Uri> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        } else {
            if (!TextUtils.isEmpty(this.J)) {
                try {
                    for (String str : this.J.split(";")) {
                        arrayList.add(Uri.parse(str));
                    }
                } catch (Exception e16) {
                    QLog.d("SDKEmotionSettingManager", 1, " openSetEmotion mComingStrUriList parse error!", e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, " openSetEmotion JSONArray currentUris = " + arrayList);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (this.f182068e != null) {
            UriParserPathHelper uriParserPathHelper = new UriParserPathHelper(this.f182068e, false, null);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String pathFromUri = uriParserPathHelper.getPathFromUri((Uri) arrayList.get(i3), false);
                if (!TextUtils.isEmpty(pathFromUri)) {
                    arrayList2.add(pathFromUri);
                }
            }
        }
        return arrayList2;
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.Q;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.Q.dismiss();
        }
    }

    protected void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Activity activity = this.f182068e;
        if (activity == null) {
            QLog.e("SDKEmotionSettingManager", 1, "showAccountConfirm activity is null");
            return;
        }
        QQCustomDialog qQCustomDialog = this.S;
        if (qQCustomDialog != null) {
            if (!qQCustomDialog.isShowing()) {
                this.S.show();
                return;
            }
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        this.S = createCustomDialog;
        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.t5z));
        this.S.setTitle(R.string.b1v);
        b bVar = new b();
        this.S.setNegativeButton(R.string.cancel, bVar);
        this.S.setPositiveButton(R.string.hin, bVar);
        this.S.show();
    }

    protected void P(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f182068e == null) {
            QLog.e("SDKEmotionSettingManager", 1, "showError activity is null");
            return;
        }
        QQCustomDialog qQCustomDialog = this.R;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f182068e, 230);
        this.S = createCustomDialog;
        createCustomDialog.setMessage(str);
        this.S.setNegativeButton(str2, new q());
        this.S.setOnKeyListener(new a());
        this.S.show();
    }

    public void R(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) arrayList);
            return;
        }
        QLog.i("SDKEmotionSettingManager", 1, "showPreviewDialog list =" + arrayList);
        if (this.f182068e == null) {
            QLog.e("SDKEmotionSettingManager", 1, "showPreviewDialog activity is null");
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            int size = arrayList.size();
            s sVar = new s(this.f182068e);
            this.T = sVar;
            sVar.W("\u6536\u85cf\u4e3aQQ\u8868\u60c5");
            this.T.O(R.string.cancel, new c());
            this.T.P(R.string.afb, new d(arrayList, size));
            this.T.U(R.string.afc, new e(size));
            this.T.S(arrayList, new f(size, arrayList));
            if (size > 1) {
                this.T.R(String.format(this.f182068e.getResources().getString(R.string.afk), Integer.valueOf(size)));
            }
            this.T.setOnDismissListener(new g());
            this.T.setOnKeyListener(new h(size));
            this.T.setCanceledOnTouchOutside(false);
            this.T.show();
            AbstractGifImage.resumeAll();
            return;
        }
        QLog.e("SDKEmotionSettingManager", 1, "showPreviewDialog list null error");
    }

    public void S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (this.f182068e == null) {
            return;
        }
        if (this.Q == null) {
            Activity activity = this.f182068e;
            this.Q = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        this.Q.setMessage(i3);
        if (!this.f182068e.isFinishing()) {
            this.Q.show();
        }
    }

    @Override // com.tencent.mobileqq.activity.emogroupstore.n
    public void a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        this.J = intent.getStringExtra("key_from_sdk_set_emotion_uri_list");
        this.I = intent.getParcelableArrayListExtra("key_from_sdk_set_emotion_uri");
        this.f182069f = intent.getStringExtra("key_from_sdk_set_emotion_appname");
        this.f182071i = intent.getStringExtra("key_from_sdk_set_emotion_share_id");
        this.f182072m = intent.getStringExtra("key_from_sdk_set_emotion_open_id");
        this.f182070h = intent.getStringExtra("pkg_name");
        this.C = intent.getStringExtra("sdk_version");
        M();
        if (QLog.isColorLevel()) {
            QLog.w("SDKEmotionSettingManager", 2, " initParam ");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 11) {
            this.L = true;
            J(message.arg1);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.emogroupstore.n
    public void onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f182068e != null) {
            Intent intent = new Intent();
            PendingIntent pendingIntent = (PendingIntent) this.f182068e.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
            if (pendingIntent != null) {
                QLog.d("SDKEmotionSettingManager", 1, "onBackEvent using PendingIntent");
                intent.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT, pendingIntent);
            }
            intent.setComponent(SplashActivity.getAliasComponent(this.f182068e));
            intent.setFlags(67108864);
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            this.f182068e.startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.emogroupstore.n
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.K.removeMessages(11);
        s sVar = this.T;
        if (sVar != null) {
            sVar.dismiss();
        }
        this.H.clear();
        this.F = false;
        this.L = false;
        this.f182068e = null;
    }

    @Override // com.tencent.mobileqq.activity.emogroupstore.n
    public void onNewIntent(Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        s sVar = this.T;
        if (sVar != null && sVar.isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.d("SDKEmotionSettingManager", 2, " onNewIntent return error");
            }
            if (this.H != null) {
                StringBuilder sb5 = new StringBuilder();
                for (String str2 : this.H) {
                    sb5.append("104_");
                }
                str = sb5.toString();
            } else {
                str = null;
            }
            W(this.f182068e, Long.valueOf(this.f182071i).longValue(), false, str);
            N();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SDKEmotionSettingManager", 2, " onNewIntent start new");
        }
        Activity activity = this.f182068e;
        if (activity != null) {
            activity.setIntent(intent);
        }
        a(intent);
        start();
    }

    @Override // com.tencent.mobileqq.activity.emogroupstore.n
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            B();
        }
    }
}
