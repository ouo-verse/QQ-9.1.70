package com.tencent.av.compat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.n;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BaseActivity;
import mqq.app.BaseFragmentActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVCallCompactHelper {

    /* renamed from: b, reason: collision with root package name */
    private static final String f73542b = VideoInviteActivity.class.getName();

    /* renamed from: c, reason: collision with root package name */
    public static final String f73543c = GaInviteLockActivity.class.getName();

    /* renamed from: d, reason: collision with root package name */
    private static final String f73544d = MultiIncomingCallsActivity.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Intent> f73545a = new ConcurrentHashMap<>(3);

    private void c(String str, Intent intent) {
        try {
            this.f73545a.put(str, intent);
        } catch (Throwable th5) {
            QLog.i("CompatModeTag", 1, "addIntent", th5);
        }
    }

    private void h() {
        try {
            this.f73545a.clear();
        } catch (Throwable th5) {
            QLog.i("CompatModeTag", 1, "clearIntents", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent i(String str) {
        Intent intent = null;
        try {
            if (this.f73545a.size() > 0) {
                for (String str2 : this.f73545a.keySet()) {
                    if (n.e().i(str2) == null) {
                        this.f73545a.remove(str2);
                    } else {
                        Intent intent2 = this.f73545a.get(str2);
                        if (intent2 != null && intent2.getComponent() != null && intent2.getComponent().getClassName().equals(str)) {
                            intent = intent2;
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.i("CompatModeTag", 1, "getIntentByComponentClassName", th5);
        }
        return intent;
    }

    private Intent j(String str) {
        try {
            return this.f73545a.get(str);
        } catch (Throwable th5) {
            QLog.i("CompatModeTag", 1, "getIntentByKey", th5);
            return null;
        }
    }

    public static String k(String str, Intent intent) {
        StringBuilder sb5;
        String str2;
        int i3;
        int intExtra;
        String valueOf;
        if (!TextUtils.isEmpty(str) && intent != null) {
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder(200);
                sb5.append("getSessionIdFromIntent");
                sb5.append(", class[");
                sb5.append(str);
                sb5.append("]");
                sb5.append(", intent[");
                sb5.append(intent);
                sb5.append("]");
            } else {
                sb5 = null;
            }
            if (f73544d.equals(str)) {
                String stringExtra = intent.getStringExtra("peerUin");
                boolean booleanExtra = intent.getBooleanExtra("isDoubleVideoMeeting", false);
                int intExtra2 = intent.getIntExtra("uinType", 0);
                if (intExtra2 != 1 && intExtra2 != 3000) {
                    if (booleanExtra) {
                        valueOf = stringExtra;
                        intExtra = 100;
                    } else {
                        valueOf = stringExtra;
                        intExtra = 3;
                    }
                } else {
                    long longExtra = intent.getLongExtra("discussId", 0L);
                    intExtra = intent.getIntExtra("relationType", 3);
                    valueOf = String.valueOf(longExtra);
                }
                str2 = n.b(intExtra, valueOf, new int[0]);
                if (sb5 != null) {
                    sb5.append(", uinType[");
                    sb5.append(intExtra2);
                    sb5.append("]");
                    sb5.append(", relationType[");
                    sb5.append(intExtra);
                    sb5.append("]");
                    sb5.append(", relationId[");
                    sb5.append(valueOf);
                    sb5.append("]");
                    sb5.append(", isDoubleVideoMeeting[");
                    sb5.append(booleanExtra);
                    sb5.append("]");
                    sb5.append(", peerUin[");
                    sb5.append(stringExtra);
                    sb5.append("]");
                    sb5.append(", session[");
                    sb5.append(str2);
                    sb5.append("]");
                }
            } else if (f73543c.equals(str)) {
                long longExtra2 = intent.getLongExtra("discussId", 0L);
                int intExtra3 = intent.getIntExtra("relationType", 0);
                str2 = n.b(intExtra3, String.valueOf(longExtra2), new int[0]);
                if (sb5 != null) {
                    sb5.append(", relationType[");
                    sb5.append(intExtra3);
                    sb5.append("]");
                    sb5.append(", groupId[");
                    sb5.append(longExtra2);
                    sb5.append("]");
                    sb5.append(", session[");
                    sb5.append(str2);
                    sb5.append("]");
                }
            } else if (f73542b.equals(str)) {
                String stringExtra2 = intent.getStringExtra("peerUin");
                boolean booleanExtra2 = intent.getBooleanExtra("isDoubleVideoMeeting", false);
                if (booleanExtra2) {
                    i3 = 100;
                } else {
                    i3 = 3;
                }
                str2 = n.b(i3, stringExtra2, new int[0]);
                if (sb5 != null) {
                    sb5.append(", peerUin[");
                    sb5.append(stringExtra2);
                    sb5.append("]");
                    sb5.append(", isDoubleVideoMeeting[");
                    sb5.append(booleanExtra2);
                    sb5.append("]");
                    sb5.append(", relationType[");
                    sb5.append(i3);
                    sb5.append("]");
                    sb5.append(", session[");
                    sb5.append(str2);
                    sb5.append("]");
                }
            } else {
                str2 = null;
            }
            if (QLog.isColorLevel() && sb5 != null) {
                QLog.i("CompatModeTag", 2, sb5.toString());
            }
            return str2;
        }
        return null;
    }

    private Intent l(String str) {
        try {
            return this.f73545a.remove(str);
        } catch (Throwable th5) {
            QLog.i("CompatModeTag", 1, "removeIntent", th5);
            return null;
        }
    }

    public void d(Runnable runnable, VideoAppInterface videoAppInterface) {
        if (runnable != null && videoAppInterface != null) {
            videoAppInterface.M().removeCallbacks(runnable);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CompatModeTag", 2, "clearCallIntent");
        }
    }

    public boolean e(Activity activity) {
        String str;
        Intent intent;
        boolean z16 = false;
        if (activity == null) {
            return false;
        }
        SessionInfo f16 = n.e().f();
        String str2 = null;
        if (f16 != null) {
            str = f16.f73030h;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            intent = j(f16.f73030h);
        } else {
            intent = null;
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component != null) {
                str2 = component.getClassName();
            }
            if (!f73542b.equals(str2) && !f73543c.equals(str2)) {
                if (f73544d.equals(str2)) {
                    l(f16.f73030h);
                }
            } else {
                z16 = true;
            }
        }
        if (z16) {
            activity.startActivity(intent);
            activity.finish();
        }
        if (QLog.isColorLevel()) {
            QLog.i("CompatModeTag", 2, "checkMainCallIntent, hasMainCallIntent[" + z16 + "], mainCallIntent[" + intent + "], class[" + str2 + "]");
        }
        return z16;
    }

    public Runnable f(final Activity activity, VideoAppInterface videoAppInterface) {
        Runnable runnable;
        SessionInfo f16 = n.e().f();
        if (f16 != null) {
            l(f16.f73030h);
        }
        Intent i3 = i(f73544d);
        if (i3 != null && activity != null && videoAppInterface != null) {
            runnable = new Runnable() { // from class: com.tencent.av.compat.AVCallCompactHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    String str;
                    SessionInfo sessionInfo;
                    Intent i16 = AVCallCompactHelper.this.i(AVCallCompactHelper.f73544d);
                    Activity activity2 = activity;
                    int i17 = 0;
                    if (activity2 instanceof BaseActivity) {
                        z16 = ((BaseActivity) activity2).isResume();
                    } else if (activity2 instanceof BaseFragmentActivity) {
                        z16 = ((BaseFragmentActivity) activity2).isResume();
                    } else {
                        z16 = false;
                    }
                    if (z16 && i16 != null) {
                        i17 = n.e().c();
                        str = AVCallCompactHelper.k(AVCallCompactHelper.f73544d, i16);
                        sessionInfo = n.e().i(str);
                        if (i17 >= 2 && sessionInfo != null && sessionInfo.u()) {
                            activity.startActivity(i16);
                        }
                    } else {
                        str = null;
                        sessionInfo = null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("CompatModeTag", 2, "checkThirdCallIntent, isResume[" + z16 + "], count[" + i17 + "], session[" + str + "], info[" + sessionInfo + "]");
                    }
                }
            };
            videoAppInterface.M().postDelayed(runnable, 1000L);
        } else {
            runnable = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CompatModeTag", 2, "checkThirdCallIntent , activity[" + activity + "], app[" + videoAppInterface + "], multiCallIntent[" + i3 + "]");
        }
        return runnable;
    }

    public void g(String str, Intent intent) {
        Intent intent2;
        SessionInfo f16;
        String k3 = k(str, intent);
        if (!TextUtils.isEmpty(k3)) {
            intent2 = l(k3);
        } else if (f73542b.equals(str) && (f16 = n.e().f()) != null) {
            k3 = f16.f73030h;
            intent2 = l(k3);
        } else {
            intent2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CompatModeTag", 2, "clearCallIntent , class[" + str + "], session[" + k3 + ", intent[" + intent2 + "]");
        }
    }

    public void m(Intent intent) {
        String str;
        if (intent != null && intent.getComponent() != null) {
            str = intent.getComponent().getClassName();
        } else {
            str = null;
        }
        if (f73542b.equals(str) || f73543c.equals(str)) {
            h();
        }
        String k3 = k(str, intent);
        if (!TextUtils.isEmpty(k3)) {
            c(k3, intent);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CompatModeTag", 2, "saveCallIntent , class[" + str + "], session[" + k3 + "], intent[" + intent + "]");
        }
    }
}
