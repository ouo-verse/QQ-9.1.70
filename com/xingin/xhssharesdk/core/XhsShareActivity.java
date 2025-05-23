package com.xingin.xhssharesdk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteErrorCode;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.i.c;
import com.xingin.xhssharesdk.i.g;
import com.xingin.xhssharesdk.model.other.VersionCheckResult;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import cooperation.qzone.remote.ServiceConst;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import oz4.k;
import wz4.c;
import xz4.i;
import xz4.j;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class XhsShareActivity extends Activity {
    private static final String TAG = "XhsShare_XhsShareActivity";

    @Nullable
    private g mReceiver;
    private boolean waitingResume = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements wz4.a {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<XhsShareActivity> f389975a;

        public a(XhsShareActivity xhsShareActivity) {
            this.f389975a = new WeakReference<>(xhsShareActivity);
        }

        @Override // wz4.a
        public final void a(@NonNull String str, int i3, int i16, @NonNull String str2, Throwable th5) {
            XhsShareActivity xhsShareActivity = this.f389975a.get();
            if (xhsShareActivity != null) {
                xhsShareActivity.sendErrorAndFinish(str, i3, i16, str2, th5);
            }
        }

        @Override // wz4.a
        @SuppressLint({"QueryPermissionsNeeded"})
        public final void b(@NonNull String str, @NonNull Uri uri) {
            XhsShareActivity xhsShareActivity = this.f389975a.get();
            if (xhsShareActivity != null) {
                xhsShareActivity.openXhs(str, uri);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<XhsShareActivity> f389976a;

        public b(XhsShareActivity xhsShareActivity) {
            this.f389976a = new WeakReference<>(xhsShareActivity);
        }

        @Override // wz4.c
        public final void a(a05.b bVar) {
            String str;
            XhsShareActivity xhsShareActivity = this.f389976a.get();
            if (XhsShareSdk.f389977a != null) {
                str = XhsShareSdk.f389977a.c();
            } else {
                str = "";
            }
            if (xhsShareActivity != null && TextUtils.equals(bVar.f25325d, str)) {
                xhsShareActivity.handleShareResultFromXhs(bVar);
                xhsShareActivity.unregisterShareResultReceiver();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShareResultFromXhs(a05.b bVar) {
        if (bVar != null) {
            if (bVar.f25322a) {
                if (XhsShareSdk.f389977a != null) {
                    XhsShareSdk.f389977a.i(bVar.f25325d);
                }
            } else {
                Pair<Integer, Integer> errorCodeFromXhsShareResult = XhsShareSdkTools.getErrorCodeFromXhsShareResult(bVar);
                sendErrorAndFinish(bVar.f25325d, ((Integer) errorCodeFromXhsShareResult.first).intValue(), ((Integer) errorCodeFromXhsShareResult.second).intValue(), bVar.f25324c, null);
            }
        }
    }

    private boolean isNeedRegisterReceiverWithOutsideActivity() {
        if (XhsShareSdk.f389977a != null) {
            return XhsShareSdk.f389977a.f389981c.isNeedRegisterReceiverWithOutsideActivity();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openXhs(@NonNull String str, @NonNull Uri uri) {
        d05.b bVar;
        boolean z16;
        Intent intent = new Intent();
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            XhsShareSdk.b(TAG, "Start Activity: " + uri);
            long j3 = 0;
            if (XhsShareSdk.f389977a != null) {
                xz4.a aVar = XhsShareSdk.f389977a.f389987i;
                if (aVar != null) {
                    d05.b bVar2 = aVar.f449176b;
                    String str2 = aVar.f449175a;
                    if (!TextUtils.isEmpty(bVar2.f392637a) && TextUtils.equals(str2, bVar2.f392637a)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (bVar2.f392639c != 0) {
                            XhsShareSdk.d("ShareTimelineTracker", "openShareTimestamp has be assigned!", null);
                        } else {
                            bVar2.f392639c = System.currentTimeMillis();
                        }
                    }
                }
                xz4.a aVar2 = XhsShareSdk.f389977a.f389987i;
                if (aVar2 != null) {
                    bVar = aVar2.f449176b;
                } else {
                    bVar = d05.b.f392636e;
                }
                long j16 = bVar.f392639c;
                if (j16 > 0) {
                    long j17 = bVar.f392638b;
                    if (j17 > 0) {
                        long j18 = j16 - j17;
                        if (j18 >= 0) {
                            j3 = j18;
                        }
                    }
                }
                j3 = -1;
            }
            Context applicationContext = getApplicationContext();
            oz4.g h16 = oz4.g.h();
            k.a a16 = d05.a.a(applicationContext);
            a16.f424784b = 30757;
            a16.f424785c = 3;
            a16.f424786d.put(ServiceConst.PARA_SESSION_ID, str);
            a16.f424786d.put("time_consume", String.valueOf(j3));
            h16.d(a16);
            if (isNeedRegisterReceiverWithOutsideActivity()) {
                if (XhsShareSdk.f389977a != null) {
                    com.xingin.xhssharesdk.i.c cVar = XhsShareSdk.f389977a;
                    WeakReference<Activity> weakReference = cVar.f389991m;
                    if (weakReference != null && weakReference.get() != null) {
                        Activity activity = cVar.f389991m.get();
                        cVar.f389993o = new g(new c.d());
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("com.xingin.xhs.action.VOLLEY_SHARE_RESULT");
                        try {
                            activity.registerReceiver(cVar.f389993o, intentFilter);
                            cVar.j();
                        } catch (Throwable th5) {
                            XhsShareSdk.d("XhsShare_Sdk", "registerShareResultReceiverWithOutsideActivity Error!", th5);
                        }
                    } else {
                        cVar.f389992n.w("XhsShare_Sdk", "registerShareResultReceiverWithOutsideActivity, OutsideActivity is NULL!", null);
                    }
                }
            } else {
                registerShareResultReceiver();
            }
            startActivity(intent);
            this.waitingResume = true;
            return;
        }
        sendErrorAndFinish(str, XhsShareConstants$XhsShareNoteNewErrorCode.INTENT_NOT_RESOLVE_ERROR, XhsShareConstants$XhsShareNoteErrorCode.INTENT_NOT_RESOLVE, "Intent.resolveActivity is false", null);
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private void registerShareResultReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new g(new b(this));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xingin.xhs.action.VOLLEY_SHARE_RESULT");
        try {
            registerReceiver(this.mReceiver, intentFilter);
        } catch (Throwable th5) {
            XhsShareSdk.d(TAG, "registerShareResultReceiver Error!", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendErrorAndFinish(String str, int i3, int i16, String str2, Throwable th5) {
        boolean z16;
        XhsShareSdk.c(TAG, "[" + str + "][new: " + i3 + "][old:" + i16 + "]" + str2, th5);
        if (XhsShareSdk.f389977a != null) {
            xz4.a aVar = XhsShareSdk.f389977a.f389987i;
            if (aVar == null) {
                z16 = false;
            } else {
                z16 = aVar.f449177c;
            }
            if (z16) {
                XhsShareSdk.f389977a.g(str, i3, i16, str2, th5, true);
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterShareResultReceiver() {
        g gVar = this.mReceiver;
        if (gVar != null) {
            try {
                unregisterReceiver(gVar);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02b4  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        a05.a a16;
        int i3;
        xz4.a aVar;
        boolean z16;
        String cacheDirPath;
        Throwable th5;
        String cacheDirPath2;
        int i16;
        super.onCreate(bundle);
        XhsShareSdk.b(TAG, "XhsShareActivity onCreate: savedInstanceState is " + bundle + ", Referrer is " + getReferrer().toString());
        setContentView(R.layout.dr8);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        Intent intent = getIntent();
        if (intent == null) {
            sendErrorAndFinish("", XhsShareConstants$XhsShareNoteNewErrorCode.INTENT_IS_EMPTY, -10000001, "The intent is NULL!", null);
            return;
        }
        if (TextUtils.equals(intent.getStringExtra("XHS_SHARE_FLAG"), "REDIRECT")) {
            XhsShareSdk.b(TAG, "onCreate - REDIRECT");
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("XHS_SHARE_SESSION_ID");
        String str2 = "";
        if (TextUtils.isEmpty(stringExtra)) {
            XhsShareSdk.d(TAG, "The sessionId is empty!", null);
            str = "";
        } else {
            str = stringExtra;
        }
        XhsNote xhsNote = (XhsNote) intent.getParcelableExtra("XHS_SHARE_NOTE_KEY");
        if (xhsNote == null) {
            sendErrorAndFinish(str, XhsShareConstants$XhsShareNoteNewErrorCode.NOTE_IS_EMPTY, -10000001, "The Note is NULL!", null);
            return;
        }
        if (XhsShareSdk.f389977a != null) {
            com.xingin.xhssharesdk.i.c cVar = XhsShareSdk.f389977a;
            a aVar2 = new a(this);
            xz4.a aVar3 = cVar.f389987i;
            if (aVar3 == null) {
                aVar2.a(str, XhsShareConstants$XhsShareNoteNewErrorCode.SHARE_CONTEXT_IS_NULL, -10000001, "[makeShareNoteDeeplink]CurrentShareContext is NULL!", null);
                return;
            }
            if (!TextUtils.equals(aVar3.f449175a, str)) {
                aVar2.a(str, XhsShareConstants$XhsShareNoteNewErrorCode.SESSION_ID_IS_NOT_EQUAL, -10000001, "[makeShareNoteDeeplink]SessionId is not equal!", null);
                return;
            }
            VersionCheckResult isSupportShareNote = XhsShareSdkTools.isSupportShareNote(cVar.f389979a.getApplicationContext());
            int i17 = isSupportShareNote.checkResultCode;
            if (i17 != 0) {
                if (i17 == -1) {
                    i16 = XhsShareConstants$XhsShareNoteNewErrorCode.XHS_NOT_INSTALL;
                } else {
                    i16 = XhsShareConstants$XhsShareNoteNewErrorCode.XHS_VERSION_LOW;
                }
                aVar2.a(str, i16, XhsShareConstants$XhsShareNoteErrorCode.INVALID_VERSION, isSupportShareNote.errorMessage, isSupportShareNote.exception);
                return;
            }
            cVar.f389992n.d("XhsShare_Sdk", "ReadTokenCheckInfoFromLocal.");
            String string = cVar.f389979a.getSharedPreferences("XHS_SHARE_SDK_SP", 0).getString("XHS_SHARE_SDK_SP_KEY_TOKEN_CHECK_INFO", null);
            if (TextUtils.isEmpty(string)) {
                cVar.f389992n.i("XhsShare_Sdk", "Get no TokenCheckInfo.");
            } else {
                try {
                    a16 = a05.a.a(string);
                } catch (JSONException e16) {
                    cVar.f389992n.w("XhsShare_Sdk", "Json to TokenCheckInfo error.\n json is " + string, e16);
                }
                i3 = 1;
                if (a16 != null) {
                    if (!a16.f25319e) {
                        cVar.f389992n.d("XhsShare_Sdk", "Last Token Check Error!");
                        if (a16.f25320f != -10000001) {
                            z16 = !cVar.f389989k;
                            aVar = aVar3;
                        }
                    } else {
                        aVar = aVar3;
                        long currentTimeMillis = System.currentTimeMillis() - a16.f25318d;
                        if (currentTimeMillis > 604800000) {
                            cVar.f389992n.d("XhsShare_Sdk", "Token expire! threshold: 604800000 current: " + currentTimeMillis);
                        } else {
                            String str3 = cVar.f389985g;
                            if (str3 == null) {
                                try {
                                    cVar.f389985g = XhsShareSdkTools.getCurrentAppVersionName(cVar.f389979a);
                                } catch (PackageManager.NameNotFoundException e17) {
                                    cVar.f389992n.w("XhsShare_Sdk", "Invoke getAppVersionName() Error!", e17);
                                }
                                str3 = cVar.f389985g;
                            }
                            String currentAppPackageName = XhsShareSdkTools.getCurrentAppPackageName(cVar.f389979a);
                            String sdkVersion = XhsShareSdkTools.getSdkVersion();
                            if (!TextUtils.equals(currentAppPackageName, a16.f25316b)) {
                                cVar.f389992n.d("XhsShare_Sdk", "AppPackage Changed! last: " + a16.f25316b + " current: " + currentAppPackageName);
                            } else if (!TextUtils.equals(str3, a16.f25315a)) {
                                cVar.f389992n.d("XhsShare_Sdk", "AppVersion Changed! last: " + a16.f25315a + " current: " + str3);
                            } else if (!TextUtils.equals(sdkVersion, a16.f25317c)) {
                                cVar.f389992n.d("XhsShare_Sdk", "SdkVersion Changed! last: " + a16.f25317c + " current: " + sdkVersion);
                            } else {
                                z16 = false;
                            }
                        }
                        z16 = true;
                    }
                    cVar.f389992n.d("XhsShare_Sdk", "Need Check Token? " + z16);
                    if (z16) {
                        String str4 = cVar.f389980b;
                        String currentAppPackageName2 = XhsShareSdkTools.getCurrentAppPackageName(cVar.f389979a);
                        String str5 = cVar.f389985g;
                        if (str5 == null) {
                            try {
                                cVar.f389985g = XhsShareSdkTools.getCurrentAppVersionName(cVar.f389979a);
                            } catch (PackageManager.NameNotFoundException e18) {
                                cVar.f389992n.w("XhsShare_Sdk", "Invoke getAppVersionName() Error!", e18);
                            }
                            str5 = cVar.f389985g;
                        }
                        String sdkVersion2 = XhsShareSdkTools.getSdkVersion();
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        c05.a aVar4 = new c05.a(str4, currentAppPackageName2, str5, sdkVersion2, valueOf);
                        a05.a aVar5 = new a05.a(str5, currentAppPackageName2, sdkVersion2, Long.parseLong(valueOf), true, 0, null);
                        cVar.f389989k = true;
                        i.b(aVar4, new xz4.b(cVar, aVar5));
                        i3 = 2;
                    } else {
                        cVar.f389982d = a16;
                        if (!a16.f25319e && a16.f25320f != -10000001 && cVar.f389989k) {
                            i3 = 3;
                        }
                    }
                    cVar.f389992n.d("XhsShare_Sdk", "CheckToken Result is ".concat(vz4.a.a(i3)));
                    if (i3 == 3) {
                        if (cVar.f389982d != null) {
                            str2 = "[" + cVar.f389982d.f25320f + "]," + cVar.f389982d.f25321g;
                        }
                        aVar2.a(str, XhsShareConstants$XhsShareNoteNewErrorCode.APP_KEY_CHECK_ERROR, XhsShareConstants$XhsShareNoteErrorCode.TOKEN_CHECK_ERROR, str2, null);
                        return;
                    }
                    if (!j.d(xhsNote)) {
                        aVar2.a(str, XhsShareConstants$XhsShareNoteNewErrorCode.RESOURCE_MISS, XhsShareConstants$XhsShareNoteErrorCode.PRE_CHECK_ERROR, "The Image and Video is invalid!", null);
                        return;
                    }
                    if (TextUtils.isEmpty(cVar.f389981c.getCacheDirPath())) {
                        cacheDirPath = XhsShareSdkTools.getDefaultCacheDirPath(cVar.f389979a);
                    } else {
                        cacheDirPath = cVar.f389981c.getCacheDirPath();
                    }
                    File file = new File(cacheDirPath);
                    if (!file.exists() && !file.mkdirs()) {
                        c.a aVar6 = cVar.f389992n;
                        StringBuilder sb5 = new StringBuilder("Create cache dir error! The path is ");
                        if (TextUtils.isEmpty(cVar.f389981c.getCacheDirPath())) {
                            cacheDirPath2 = XhsShareSdkTools.getDefaultCacheDirPath(cVar.f389979a);
                        } else {
                            cacheDirPath2 = cVar.f389981c.getCacheDirPath();
                        }
                        sb5.append(cacheDirPath2);
                        th5 = null;
                        aVar6.w("XhsShare_Sdk", sb5.toString(), null);
                    } else {
                        th5 = null;
                    }
                    c.e eVar = cVar.f389986h;
                    if (eVar != null && eVar.isAlive()) {
                        cVar.f389992n.w("XhsShare_Sdk", "The last ProcessDataThread is alive!!", th5);
                        cVar.f389986h.interrupt();
                    }
                    c.e eVar2 = new c.e(xhsNote, str, aVar.f449176b.f392638b, aVar2);
                    cVar.f389986h = eVar2;
                    eVar2.start();
                    return;
                }
                aVar = aVar3;
                z16 = true;
                cVar.f389992n.d("XhsShare_Sdk", "Need Check Token? " + z16);
                if (z16) {
                }
                cVar.f389992n.d("XhsShare_Sdk", "CheckToken Result is ".concat(vz4.a.a(i3)));
                if (i3 == 3) {
                }
            }
            a16 = null;
            i3 = 1;
            if (a16 != null) {
            }
            aVar = aVar3;
            z16 = true;
            cVar.f389992n.d("XhsShare_Sdk", "Need Check Token? " + z16);
            if (z16) {
            }
            cVar.f389992n.d("XhsShare_Sdk", "CheckToken Result is ".concat(vz4.a.a(i3)));
            if (i3 == 3) {
            }
        } else {
            sendErrorAndFinish(str, XhsShareConstants$XhsShareNoteNewErrorCode.HAS_NOT_REGISTER, -10000001, "XhsShare instance is null! Maybe not invoke [XhsShareSdk.registerApp]!", null);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        XhsShareSdk.b(TAG, "XhsShareActivity onDestroy");
        unregisterShareResultReceiver();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("XHS_SHARE_FLAG");
        XhsShareSdk.b(TAG, "XhsShareActivity onNewIntent, flag is " + stringExtra);
        if (TextUtils.equals(stringExtra, "SHARE")) {
            sendErrorAndFinish("", XhsShareConstants$XhsShareNoteNewErrorCode.REPEAT_SHARE, XhsShareConstants$XhsShareNoteErrorCode.REPEAT_SHARE, "Last share not over yet!!", null);
        } else if (TextUtils.equals(stringExtra, "REDIRECT")) {
            XhsShareSdk.b(TAG, "onNewIntent - REDIRECT");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        XhsShareSdk.b(TAG, "XhsShareActivity onRestoreInstanceState: " + bundle);
    }

    @Override // android.app.Activity
    public void onResume() {
        boolean z16;
        super.onResume();
        XhsShareSdk.b(TAG, "XhsShareActivity onResume, waitingResume is " + this.waitingResume);
        if (this.waitingResume && XhsShareSdk.f389977a != null) {
            StringBuilder sb5 = new StringBuilder("XhsShareActivity onResume, isSharing: ");
            xz4.a aVar = XhsShareSdk.f389977a.f389987i;
            boolean z17 = false;
            if (aVar == null) {
                z16 = false;
            } else {
                z16 = aVar.f449177c;
            }
            sb5.append(z16);
            XhsShareSdk.b(TAG, sb5.toString());
            xz4.a aVar2 = XhsShareSdk.f389977a.f389987i;
            if (aVar2 != null) {
                z17 = aVar2.f449177c;
            }
            if (z17) {
                sendErrorAndFinish(XhsShareSdk.f389977a.c(), XhsShareConstants$XhsShareNoteNewErrorCode.APP_RESUME_BEFORE_GET_SHARE_RESULT_FROM_XHS, XhsShareConstants$XhsShareNoteErrorCode.APP_RESUME_BEFORE_GET_SHARE_RESULT, "App resume before get share result!", null);
            } else {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        XhsShareSdk.b(TAG, "XhsShareActivity onSaveInstanceState!");
    }
}
