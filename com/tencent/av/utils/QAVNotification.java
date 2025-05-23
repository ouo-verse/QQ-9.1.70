package com.tencent.av.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QAVNotification {

    /* renamed from: m, reason: collision with root package name */
    static QAVNotification f76734m;

    /* renamed from: c, reason: collision with root package name */
    z f76737c;

    /* renamed from: e, reason: collision with root package name */
    VideoAppInterface f76739e;

    /* renamed from: f, reason: collision with root package name */
    Context f76740f;

    /* renamed from: a, reason: collision with root package name */
    Notification f76735a = null;

    /* renamed from: b, reason: collision with root package name */
    QQNotificationManager f76736b = null;

    /* renamed from: d, reason: collision with root package name */
    RemoteViews f76738d = null;

    /* renamed from: g, reason: collision with root package name */
    boolean f76741g = false;

    /* renamed from: h, reason: collision with root package name */
    b f76742h = null;

    /* renamed from: i, reason: collision with root package name */
    Map<String, b> f76743i = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    final b f76744j = new b();

    /* renamed from: k, reason: collision with root package name */
    int f76745k = 0;

    /* renamed from: l, reason: collision with root package name */
    private String f76746l = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f76758a;

        /* renamed from: b, reason: collision with root package name */
        public final String f76759b;

        /* renamed from: c, reason: collision with root package name */
        public final PendingIntent f76760c;

        public a(int i3, String str, PendingIntent pendingIntent) {
            this.f76758a = i3;
            this.f76759b = str;
            this.f76760c = pendingIntent;
        }
    }

    QAVNotification(VideoAppInterface videoAppInterface) {
        this.f76740f = null;
        this.f76739e = videoAppInterface;
        if (this.f76740f == null) {
            this.f76740f = videoAppInterface.getApplication().getApplicationContext();
        }
        this.f76737c = new z(this.f76740f);
    }

    private void A(b bVar, boolean z16, String str, boolean z17, boolean z18) {
        Intent intent;
        String str2;
        String string;
        Bitmap bitmap;
        boolean z19;
        String string2;
        Bitmap bitmap2;
        String string3;
        Bitmap bitmap3;
        PendingIntent pendingIntent;
        String str3;
        int i3;
        int i16;
        boolean s16 = s(bVar.f76761a);
        boolean r16 = r(bVar.f76761a);
        boolean t16 = t(bVar.f76761a);
        String str4 = bVar.f76770j;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(200);
            sb5.append("updateNotification, data=");
            sb5.append(bVar);
            sb5.append(", create=");
            sb5.append(z16);
            sb5.append(", time=");
            sb5.append(str);
            sb5.append(", invite=");
            sb5.append(z17);
            sb5.append(", fullScreen=");
            sb5.append(z18);
            sb5.append(", isSessionCanNotify=");
            sb5.append(r16);
            sb5.append(", isSwitch2DoubleMeeting=");
            sb5.append(t16);
            QLog.d("QAVNotification", 2, sb5.toString());
        }
        if ((!z17 && !s16) || !r16) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            j(bVar);
        }
        boolean k3 = AVUtil.k(this.f76739e.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.w("QAVNotification", 2, "updateNotification avCallBtnState[" + k3 + "]");
        }
        if (!k3 && TextUtils.isEmpty(str) && !p(bVar)) {
            return;
        }
        boolean y16 = TraeHelper.y(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.w("QAVNotification", 2, "updateNotification canDisturb[" + y16 + "]");
        }
        if (!y16 && TextUtils.isEmpty(str) && !p(bVar)) {
            return;
        }
        int i17 = bVar.f76766f;
        int i18 = R.drawable.h9n;
        switch (i17) {
            case 40:
                intent = new Intent(this.f76740f, (Class<?>) VideoInviteActivity.class);
                str2 = bVar.f76762b;
                string = this.f76740f.getString(R.string.idm);
                bitmap = bVar.f76763c;
                i18 = R.drawable.h9o;
                break;
            case 41:
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                intent.putExtra("uin", bVar.f76764d);
                str2 = bVar.f76762b;
                string = this.f76740f.getString(R.string.d95);
                bitmap = bVar.f76763c;
                i18 = R.drawable.h9o;
                break;
            case 42:
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                intent.putExtra("uin", bVar.f76764d);
                str2 = bVar.f76762b;
                string = this.f76740f.getString(R.string.dfy);
                bitmap = bVar.f76763c;
                i18 = R.drawable.h9o;
                break;
            case 43:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 58:
            case 59:
            case 60:
            default:
                str2 = "";
                string = "";
                intent = null;
                bitmap = null;
                i18 = 0;
                break;
            case 44:
                z19 = true;
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                intent.putExtra("GroupId", bVar.f76764d);
                intent.putExtra("Type", 2);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
                intent.putExtra("uinType", bVar.f76767g);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                str2 = bVar.f76762b;
                string2 = this.f76740f.getString(R.string.dci);
                bitmap2 = bVar.f76763c;
                Bitmap bitmap4 = bitmap2;
                string = string2;
                bitmap = bitmap4;
                break;
            case 45:
                z19 = true;
                intent = new Intent(this.f76740f, (Class<?>) VideoInviteActivity.class);
                intent.addFlags(4194304);
                intent.addFlags(262144);
                str2 = bVar.f76762b;
                string2 = this.f76740f.getString(R.string.dfx);
                bitmap2 = bVar.f76763c;
                Bitmap bitmap42 = bitmap2;
                string = string2;
                bitmap = bitmap42;
                break;
            case 46:
                z19 = true;
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                intent.putExtra("GroupId", bVar.f76764d);
                str2 = bVar.f76762b;
                string2 = this.f76740f.getString(R.string.d95);
                bitmap2 = bVar.f76763c;
                Bitmap bitmap422 = bitmap2;
                string = string2;
                bitmap = bitmap422;
                break;
            case 47:
                z19 = true;
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                intent.putExtra("GroupId", bVar.f76764d);
                str2 = bVar.f76762b;
                string2 = this.f76740f.getString(R.string.dfq);
                bitmap2 = bVar.f76763c;
                Bitmap bitmap4222 = bitmap2;
                string = string2;
                bitmap = bitmap4222;
                break;
            case 48:
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                z19 = true;
                intent.putExtra("isDoubleVideoMeeting", true);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                intent.putExtra("GroupId", bVar.f76764d);
                str2 = bVar.f76762b;
                if (bVar.f76768h == 4) {
                    string2 = this.f76740f.getString(R.string.dfy);
                } else {
                    string2 = this.f76740f.getString(R.string.dfq);
                }
                bitmap2 = bVar.f76763c;
                i18 = R.drawable.h9o;
                Bitmap bitmap42222 = bitmap2;
                string = string2;
                bitmap = bitmap42222;
                break;
            case 55:
                intent = ag.e(this.f76740f, bVar.f76761a);
                str2 = bVar.f76762b;
                string3 = this.f76740f.getString(R.string.f170486sm);
                bitmap3 = bVar.f76763c;
                bitmap = bitmap3;
                string = string3;
                break;
            case 56:
                intent = ag.e(this.f76740f, bVar.f76761a);
                str2 = bVar.f76762b;
                string3 = this.f76740f.getString(R.string.idm);
                bitmap = bVar.f76763c;
                i18 = R.drawable.h9o;
                string = string3;
                break;
            case 57:
                intent = ag.e(this.f76740f, bVar.f76761a);
                str2 = bVar.f76762b;
                if (t16) {
                    String string4 = this.f76740f.getString(R.string.dfq);
                    Intent intent2 = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                    intent2.putExtra("isDoubleVideoMeeting", true);
                    intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                    intent2.putExtra("uinType", bVar.f76767g);
                    intent2.putExtra("GroupId", bVar.f76764d);
                    string3 = string4;
                    intent = intent2;
                } else if (TextUtils.isEmpty(bVar.f76765e)) {
                    string3 = this.f76740f.getString(R.string.f171248df4);
                } else {
                    string3 = String.format(this.f76740f.getString(R.string.df5), w(bVar.f76765e, 7));
                }
                bitmap3 = bVar.f76763c;
                bitmap = bitmap3;
                string = string3;
                break;
            case 61:
                intent = ag.d(this.f76740f, bVar.f76761a);
                str2 = bVar.f76762b;
                if (TextUtils.isEmpty(bVar.f76765e)) {
                    string3 = this.f76740f.getString(R.string.f171248df4);
                } else {
                    string3 = String.format(this.f76740f.getString(R.string.df5), w(bVar.f76765e, 7));
                }
                bitmap3 = bVar.f76763c;
                bitmap = bitmap3;
                string = string3;
                break;
            case 62:
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                intent.putExtra("GroupId", bVar.f76764d);
                intent.putExtra("Type", 2);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
                intent.putExtra("uinType", bVar.f76767g);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                str2 = bVar.f76762b;
                string3 = this.f76740f.getString(R.string.dfq);
                bitmap3 = bVar.f76763c;
                bitmap = bitmap3;
                string = string3;
                break;
            case 63:
                intent = new Intent(this.f76740f, (Class<?>) AVActivity.class);
                intent.putExtra("GroupId", bVar.f76764d);
                intent.putExtra("Type", 2);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
                intent.putExtra("uinType", bVar.f76767g);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, bVar.f76768h);
                str2 = bVar.f76762b;
                string3 = this.f76740f.getString(R.string.dfy);
                bitmap3 = bVar.f76763c;
                bitmap = bitmap3;
                string = string3;
                break;
        }
        int i19 = SessionInfo.j3;
        if (intent != null) {
            intent.putExtra("MultiAVType", i19);
            intent.putExtra("Fromwhere", "AVNotification");
            intent.addFlags(4194304);
            intent.addFlags(262144);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 235);
            intent.putExtra(ReportConst.ACTION.FULLSCREEN, z18);
            intent.putExtra("traceId", str4);
            int i26 = bVar.f76766f;
            if (i26 != 40 && i26 != 45) {
                intent.addFlags(268435456);
            }
            pendingIntent = PendingIntent.getActivity(this.f76740f, 0, intent, 167772160);
        } else {
            pendingIntent = null;
        }
        if (i19 == 2) {
            str3 = str2.replace(this.f76740f.getString(R.string.f173216i41), this.f76740f.getString(R.string.f173217i42));
            i3 = 2;
        } else {
            str3 = str2;
            i3 = 2;
        }
        String replace = i19 == i3 ? string.replace(this.f76740f.getString(R.string.f173216i41), this.f76740f.getString(R.string.f173217i42)) : string;
        ArrayList<a> e16 = t16 ? null : e(bVar, intent);
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder(300);
            sb6.append("updateNotification title: ");
            sb6.append(str3);
            sb6.append(", state: ");
            sb6.append(replace);
            sb6.append(", id: ");
            sb6.append(bVar.f76764d);
            sb6.append(", sessionId: ");
            sb6.append(bVar.f76761a);
            sb6.append(", name: ");
            sb6.append(bVar.f76762b);
            sb6.append(", type: ");
            sb6.append(bVar.f76766f);
            sb6.append(", avType: ");
            sb6.append(i19);
            sb6.append(", actions: ");
            sb6.append(e16 == null ? "null" : Integer.valueOf(e16.size()));
            sb6.append(", time: ");
            sb6.append(System.currentTimeMillis());
            QLog.d("QAVNotification", 2, sb6.toString());
        }
        try {
            boolean f16 = ax.a.f();
            if (!f16 && Build.VERSION.SDK_INT >= 26) {
                QQNotificationManager.getInstance();
            }
            try {
                Notification D = D(z16, z18, str3, replace, i18, bitmap, pendingIntent, e16);
                if (!f16 && z18) {
                    BadgeUtils.p(this.f76739e.getApplicationContext(), 10, D);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    QQNotificationManager.addChannelIfNeed(D, QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
                }
                if (z16) {
                    this.f76739e.v0(true, D);
                }
                if (this.f76736b == null) {
                    this.f76736b = QQNotificationManager.getInstance();
                }
                this.f76736b.notify("QAVNotification", 235, D);
                bVar.f76769i = false;
                this.f76744j.e(bVar);
                this.f76742h = bVar;
                this.f76741g = true;
                i16 = 1;
                if (z17) {
                    return;
                }
                try {
                    i(bVar.f76761a);
                } catch (Throwable th5) {
                    th = th5;
                    QLog.e("QAVNotification", i16, "updateNotification fail.", th);
                }
            } catch (Throwable th6) {
                th = th6;
                i16 = 1;
            }
        } catch (Throwable th7) {
            th = th7;
            i16 = 1;
        }
    }

    private Notification D(boolean z16, boolean z17, String str, String str2, int i3, Bitmap bitmap, PendingIntent pendingIntent, List<a> list) {
        NotificationCompat.Builder builder;
        boolean f16 = ax.a.f();
        if (z17 && !f16) {
            builder = new NotificationCompat.Builder(this.f76740f, QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
            builder.setOngoing(q());
            builder.setAutoCancel(true);
        } else {
            builder = new NotificationCompat.Builder(this.f76740f);
        }
        builder.setSmallIcon(i3);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(bitmap);
        builder.setContentIntent(pendingIntent);
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                builder.addAction(aVar.f76758a, aVar.f76759b, aVar.f76760c);
            }
        }
        if (z17) {
            if (f16) {
                builder.setPriority(2);
            } else {
                if (Build.VERSION.SDK_INT >= 24) {
                    builder.setPriority(1);
                }
                builder.setCategory("call");
                builder.setVisibility(1);
            }
            builder.setFullScreenIntent(pendingIntent, true);
            builder.setVibrate(TraeHelper.F);
        } else {
            builder.setPriority(0);
            builder.setFullScreenIntent(null, false);
            builder.setVibrate(null);
        }
        this.f76735a = builder.build();
        if (AVUtil.p() && z17) {
            if (f16) {
                Notification notification = this.f76735a;
                notification.flags = notification.flags | 2 | 32;
            }
            Notification notification2 = this.f76735a;
            notification2.flags = (notification2.flags & (-9)) | 4 | 1;
        } else {
            Notification notification3 = this.f76735a;
            notification3.flags = (notification3.flags | 2 | 32 | 8) & (-5) & (-2);
        }
        if (z17) {
            if (f16) {
                Notification notification4 = this.f76735a;
                notification4.category = "call";
                notification4.flags |= 128;
            }
        } else {
            Notification notification5 = this.f76735a;
            notification5.category = null;
            notification5.flags &= -129;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "useDefaultStyle flags: " + this.f76735a.flags + " useOldNotification:" + f16);
        }
        return this.f76735a;
    }

    private ArrayList<a> e(b bVar, Intent intent) {
        if (bVar == null || intent == null) {
            return null;
        }
        int i3 = bVar.f76766f;
        if (i3 != 40 && i3 != 45 && i3 != 61) {
            switch (i3) {
                case 55:
                case 56:
                case 57:
                    break;
                default:
                    return null;
            }
        }
        ArrayList<a> arrayList = new ArrayList<>(2);
        Intent intent2 = new Intent(intent);
        intent2.setAction("com.tencent.qav.notify.accept");
        intent2.putExtra(ServiceConst.PARA_SESSION_ID, bVar.f76761a);
        intent2.putExtra("traceId", bVar.f76770j);
        arrayList.add(new a(R.drawable.dbc, HardCodeUtil.qqStr(R.string.pqx), PendingIntent.getActivity(this.f76740f, 0, intent2, 167772160)));
        Intent intent3 = new Intent("com.tencent.qav.notify.refuse");
        intent3.putExtra("uin", this.f76739e.getCurrentAccountUin());
        intent3.putExtra(ServiceConst.PARA_SESSION_ID, bVar.f76761a);
        intent3.putExtra("notify_type", bVar.f76766f);
        intent3.putExtra("traceId", bVar.f76770j);
        intent3.putExtra("uinType", bVar.f76767g);
        arrayList.add(new a(R.drawable.dbd, HardCodeUtil.qqStr(R.string.pqw), PendingIntent.getBroadcast(this.f76740f, 0, intent3, 167772160)));
        return arrayList;
    }

    public static void h(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("QAVNotification", 2, "cancelNotificationForce", new Throwable());
        }
        QQNotificationManager.getInstance().cancel("QAVNotification", 235);
    }

    private void i(String str) {
        if (!TextUtils.isEmpty(this.f76746l) && this.f76746l.equals(str)) {
            AudioUtil.s();
            TraeHelper.n0(this.f76739e);
            this.f76746l = null;
        }
    }

    private b k(String str, int i3) {
        SessionInfo i16 = com.tencent.av.n.e().i(str);
        if (i16 != null) {
            b bVar = new b();
            bVar.f76761a = str;
            bVar.f76768h = i3;
            int i17 = i16.f73035i;
            if (i17 != 1 && i17 != 2) {
                if (i16.f73060o0) {
                    String valueOf = String.valueOf(i16.P0);
                    bVar.f76762b = this.f76739e.G(i16.f73067q, valueOf, null);
                    bVar.f76763c = this.f76739e.J(i16.f73067q, valueOf, null, true, true);
                    bVar.f76766f = 48;
                } else {
                    String valueOf2 = String.valueOf(i16.P0);
                    bVar.f76762b = this.f76739e.G(i16.f73067q, valueOf2, null);
                    bVar.f76763c = this.f76739e.J(i16.f73067q, valueOf2, null, true, true);
                    if (i16.f73035i == 3) {
                        bVar.f76766f = 62;
                    } else {
                        bVar.f76766f = 63;
                    }
                }
            } else {
                bVar.f76762b = this.f76739e.G(i16.f73067q, i16.f73091w, i16.f73103z);
                bVar.f76763c = this.f76739e.J(i16.f73067q, i16.f73091w, null, true, true);
                if (i16.f73035i == 1) {
                    bVar.f76766f = 47;
                } else {
                    bVar.f76766f = 42;
                }
            }
            this.f76743i.put(str, bVar);
            if (QLog.isColorLevel()) {
                QLog.i("QAVNotification", 2, "createNotifyData, we create one data, data[" + bVar + "]");
            }
            return bVar;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i("QAVNotification", 2, "createNotifyData, no sessionInfo, id[" + str + "]");
        return null;
    }

    public static QAVNotification l(VideoAppInterface videoAppInterface) {
        if (f76734m == null && videoAppInterface != null) {
            synchronized (QAVNotification.class) {
                if (f76734m == null) {
                    f76734m = new QAVNotification(videoAppInterface);
                }
            }
        }
        return f76734m;
    }

    private boolean o(String str) {
        b bVar = this.f76742h;
        if (bVar == null || !this.f76741g || !TextUtils.equals(str, bVar.f76761a)) {
            return false;
        }
        return true;
    }

    private boolean p(b bVar) {
        boolean z16;
        if ((this.f76745k == 2 && !n()) || (n() && this.f76744j.d(bVar))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QAVNotification", 4, "isNeedNotificationAnyWay, flag[" + this.f76745k + "], active[" + n() + "], come[" + bVar + "], last[" + this.f76744j + "], need[" + z16 + "]");
        }
        return z16;
    }

    private boolean q() {
        String str;
        try {
            str = this.f76739e.getApp().getString(R.string.hhh);
        } catch (Exception unused) {
            str = null;
        }
        boolean z16 = false;
        if (str != null) {
            z16 = SettingCloneUtil.readValue((Context) this.f76739e.getApp(), (String) null, str, AppConstants.QQSETTING_NOTIFY_ICON_KEY, false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "isOpenNoClearNotification: " + z16 + " defStr: " + str);
        }
        return z16;
    }

    private boolean r(String str) {
        if (com.tencent.av.n.e().i(str) != null) {
            return !r2.Q(this.f76739e);
        }
        return false;
    }

    private boolean s(String str) {
        SessionInfo i3 = com.tencent.av.n.e().i(str);
        if (i3 == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QAVNotification", 2, "isSessionIdVisible sessionInfo.sessionStatus = " + i3.f73025g);
        }
        if (i3.f73025g == 3) {
            return false;
        }
        return true;
    }

    private boolean t(String str) {
        SessionInfo i3 = com.tencent.av.n.e().i(str);
        if (i3 != null) {
            return i3.V0;
        }
        return false;
    }

    private String w(String str, int i3) {
        StringBuilder sb5 = new StringBuilder(str);
        if (sb5.length() >= i3 && i3 > 0) {
            char[] charArray = str.toCharArray();
            sb5 = new StringBuilder(String.valueOf(charArray[0]));
            for (int i16 = 1; i16 < 5; i16++) {
                sb5.append(String.valueOf(charArray[i16]));
            }
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
        return sb5.toString();
    }

    private void y(b bVar, boolean z16) {
        z(bVar, z16, null, false);
    }

    private void z(b bVar, boolean z16, String str, boolean z17) {
        A(bVar, z16, str, z17, false);
    }

    public synchronized void B(String str, int i3, String str2, boolean z16) {
        b bVar = this.f76743i.get(str);
        if (bVar == null && this.f76745k == 2) {
            try {
                bVar = k(str, i3);
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.i("QAVNotification", 1, "updateNotification exception", th5);
            }
        }
        boolean s16 = s(str);
        boolean o16 = o(str);
        if (QLog.isColorLevel()) {
            QLog.w("QAVNotification", 2, "updateNotification, sessionId[" + str + "], mIsActive[" + this.f76741g + "], SessionType[" + i3 + "], isSessionIdVisible[" + s16 + "], isActiveSession[" + o16 + "], isGameMode[" + z16 + "], time[" + str2 + "], data[" + bVar + "]");
        }
        if (z16 && !p(bVar)) {
            return;
        }
        if (s16 && bVar != null) {
            if (!o16 && !p(bVar)) {
                return;
            }
            if ((this.f76741g && this.f76735a != null) || p(bVar)) {
                z(bVar, true, str2, false);
            }
        }
    }

    public void C(final String str, final int i3, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.QAVNotification.2
            @Override // java.lang.Runnable
            public void run() {
                final boolean Y0 = com.tencent.av.r.h0().Y0();
                QAVNotification.this.f76739e.M().post(new Runnable() { // from class: com.tencent.av.utils.QAVNotification.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        QAVNotification.this.B(str, i3, str2, Y0);
                    }
                });
            }
        }, 16, null, false);
    }

    public synchronized void a(boolean z16, String str, String str2, Bitmap bitmap, String str3, int i3, int i16, int i17, String str4, String str5) {
        boolean Y0 = com.tencent.av.r.h0().Y0();
        boolean o16 = o(str);
        boolean z17 = true;
        QLog.d("QAVNotification", 1, String.format("addFullScreenInviteNotification isGameMode=%s isActiveSession=%s traceId=%s", Boolean.valueOf(Y0), Boolean.valueOf(o16), str5));
        boolean z18 = !Y0;
        if (z18 || !AVUtil.p()) {
            z17 = z18;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "addFullScreenInviteNotification needNotify[" + z17 + "], isGameMode[" + Y0 + "], isUseCompatMode[" + AVUtil.p() + "]");
        }
        if (z17 && !TextUtils.isEmpty(str)) {
            if (o16) {
                b bVar = this.f76742h;
                bVar.f76761a = str;
                bVar.f76763c = bitmap;
                bVar.f76766f = i3;
                bVar.f76764d = str3;
                bVar.f76767g = i16;
                bVar.f76768h = i17;
                bVar.f76762b = str2;
                bVar.f76765e = str4;
                bVar.f76770j = str5;
                if (z16) {
                    A(bVar, true, null, true, true);
                } else {
                    A(bVar, false, null, true, true);
                }
            } else {
                b bVar2 = new b(str, str2, bitmap, str3, i3, i16, i17, str4);
                this.f76743i.put(str, bVar2);
                A(bVar2, true, null, true, true);
            }
        }
    }

    public synchronized void b(boolean z16, String str, String str2, Bitmap bitmap, String str3, int i3, int i16, int i17, String str4) {
        boolean Y0 = com.tencent.av.r.h0().Y0();
        boolean o16 = o(str);
        QLog.w("QAVNotification", 1, "addInviteNotification, sessionId[" + LogUtil.getSafePrintUin(str) + "], name[" + str2 + "], id[" + str3 + "], type[" + i3 + "], uinType[" + i16 + "], sessionType[" + i17 + "], isActiveSession[" + o16 + "], isGameMode[" + Y0 + "], traceId[" + str4 + "]");
        if (Y0) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (o16) {
                b bVar = this.f76742h;
                bVar.f76761a = str;
                bVar.f76763c = bitmap;
                bVar.f76766f = i3;
                bVar.f76764d = str3;
                bVar.f76767g = i16;
                bVar.f76768h = i17;
                bVar.f76762b = str2;
                bVar.f76765e = null;
                bVar.f76770j = str4;
                if (z16) {
                    z(bVar, true, null, true);
                } else {
                    z(bVar, false, null, true);
                }
            } else {
                b bVar2 = new b(str, str2, bitmap, str3, i3, i16, i17, null);
                this.f76743i.put(str, bVar2);
                z(bVar2, true, null, true);
            }
        }
    }

    public synchronized void c(final String str, final String str2, final Bitmap bitmap, final String str3, final int i3, final int i16, final int i17) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.QAVNotification.1
            @Override // java.lang.Runnable
            public void run() {
                QAVNotification.this.d(str, str2, bitmap, str3, i3, i16, i17, null);
            }
        }, 16, null, false);
    }

    public synchronized void d(String str, String str2, Bitmap bitmap, String str3, int i3, int i16, int i17, String str4) {
        boolean u16 = com.tencent.av.n.e().f().u();
        boolean Y0 = com.tencent.av.r.h0().Y0();
        boolean o16 = o(str);
        if (QLog.isColorLevel()) {
            QLog.w("QAVNotification", 2, "addNotification, sessionId[" + str + "], name[" + str2 + "], id[" + str3 + "], type[" + i3 + "], uinType[" + i16 + "], sessionType[" + i17 + "], isActiveSession[" + o16 + "], isBeInviting[" + u16 + "], isGameMode[" + Y0 + "]");
        }
        if (u16 && Y0) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (o16) {
                b bVar = this.f76742h;
                bVar.f76761a = str;
                bVar.f76763c = bitmap;
                bVar.f76766f = i3;
                bVar.f76764d = str3;
                bVar.f76762b = str2;
                bVar.f76767g = i16;
                bVar.f76768h = i17;
                bVar.f76765e = str4;
                y(bVar, false);
            } else {
                b bVar2 = new b(str, str2, bitmap, str3, i3, i16, i17, null);
                this.f76743i.put(str, bVar2);
                y(bVar2, true);
            }
        }
    }

    public synchronized void f(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QAVNotification", 2, "cancelNotification mIsActive: " + this.f76741g + ", sessionId:" + str + " stopRingId=" + this.f76746l, new Throwable());
        }
        if (o(str)) {
            QQNotificationManager qQNotificationManager = this.f76736b;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel("QAVNotification", 235);
            }
            this.f76743i.remove(str);
            this.f76742h = null;
            this.f76741g = false;
            this.f76744j.e(null);
            if (!this.f76743i.isEmpty()) {
                Iterator<b> it = this.f76743i.values().iterator();
                if (it.hasNext()) {
                    y(it.next(), true);
                }
            } else {
                x(0);
                this.f76739e.v0(false, null);
            }
        } else {
            this.f76743i.remove(str);
        }
        i(str);
    }

    public synchronized void g() {
        if (QLog.isColorLevel()) {
            QLog.d("QAVNotification", 2, "cancelNotificationEx mIsActive: " + this.f76741g, new Throwable());
        }
        if (this.f76741g) {
            QQNotificationManager qQNotificationManager = this.f76736b;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel("QAVNotification", 235);
            }
            this.f76739e.v0(false, null);
            this.f76742h = null;
            this.f76741g = false;
            this.f76743i.clear();
            this.f76736b = null;
            this.f76735a = null;
            this.f76738d = null;
        }
        i(this.f76746l);
    }

    public void j(b bVar) {
        SessionInfo i3;
        if (bVar == null || (i3 = com.tencent.av.n.e().i(bVar.f76761a)) == null) {
            return;
        }
        int i16 = bVar.f76766f;
        if (i3.f73060o0) {
            if (!i3.L()) {
                if (i3.N()) {
                    bVar.f76768h = i3.f73035i;
                }
            }
            i16 = 48;
        } else if (i3.F()) {
            if (i3.N()) {
                i16 = i3.f73035i == 3 ? 62 : 63;
            }
        } else if (i3.z()) {
            i16 = i3.f73035i == 1 ? 47 : 42;
        }
        if (bVar.f76766f != i16) {
            if (QLog.isColorLevel()) {
                QLog.i("QAVNotification", 2, "checkAndUpdateNotifyData, pre[" + bVar.f76766f + "], cur[" + i16 + "], info[" + i3 + "]");
            }
            bVar.f76766f = i16;
        }
    }

    public synchronized boolean m(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QAVNotification", 2, "hideNotification mIsActive: " + this.f76741g + ", sessionId:" + str);
        }
        i(str);
        if (!o(str)) {
            return false;
        }
        this.f76742h.f76769i = true;
        QQNotificationManager qQNotificationManager = this.f76736b;
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel("QAVNotification", 235);
        }
        this.f76742h = null;
        this.f76741g = false;
        return true;
    }

    public boolean n() {
        return this.f76741g;
    }

    public synchronized boolean u(String str) {
        b bVar = this.f76743i.get(str);
        if (QLog.isColorLevel()) {
            QLog.w("QAVNotification", 1, "reshowNotification, sessionId[" + str + "], mIsActive[" + this.f76741g + "], data[" + bVar + "]");
        }
        if (bVar != null && bVar.f76769i && !this.f76741g) {
            y(bVar, true);
            return true;
        }
        return false;
    }

    public void v(String str) {
        this.f76746l = str;
    }

    public void x(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "updateFlag, flag[" + i3 + "]");
        }
        this.f76745k = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f76761a;

        /* renamed from: b, reason: collision with root package name */
        String f76762b;

        /* renamed from: c, reason: collision with root package name */
        Bitmap f76763c;

        /* renamed from: d, reason: collision with root package name */
        String f76764d;

        /* renamed from: e, reason: collision with root package name */
        String f76765e;

        /* renamed from: f, reason: collision with root package name */
        int f76766f;

        /* renamed from: g, reason: collision with root package name */
        int f76767g;

        /* renamed from: h, reason: collision with root package name */
        int f76768h;

        /* renamed from: i, reason: collision with root package name */
        boolean f76769i = false;

        /* renamed from: j, reason: collision with root package name */
        public String f76770j = "";

        b(String str, String str2, Bitmap bitmap, String str3, int i3, int i16, int i17, String str4) {
            this.f76761a = str;
            this.f76762b = str2;
            this.f76763c = bitmap;
            this.f76764d = str3;
            this.f76766f = i3;
            this.f76767g = i16;
            this.f76768h = i17;
            this.f76765e = str4;
        }

        private boolean c() {
            int i3 = this.f76766f;
            if (i3 != 47 && i3 != 42 && i3 != 48 && i3 != 44) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d(b bVar) {
            if (bVar != null && (!TextUtils.equals(this.f76761a, bVar.f76761a) || (this.f76766f != bVar.f76766f && bVar.c()))) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b bVar) {
            if (bVar != null) {
                this.f76761a = bVar.f76761a;
                this.f76766f = bVar.f76766f;
                this.f76764d = bVar.f76764d;
                this.f76762b = bVar.f76762b;
                this.f76765e = bVar.f76765e;
                this.f76767g = bVar.f76767g;
                this.f76768h = bVar.f76768h;
                this.f76769i = bVar.f76769i;
                return;
            }
            this.f76761a = "";
            this.f76766f = 0;
            this.f76764d = "";
            this.f76762b = "";
            this.f76765e = "";
            this.f76767g = 0;
            this.f76768h = 0;
            this.f76769i = false;
        }

        public String toString() {
            boolean z16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("NotifyData{sessionId[");
            sb5.append(this.f76761a);
            sb5.append("], id[");
            sb5.append(this.f76764d);
            sb5.append("], type[");
            sb5.append(this.f76766f);
            sb5.append("], uinType[");
            sb5.append(this.f76767g);
            sb5.append("], name[");
            sb5.append(this.f76762b);
            sb5.append("], extraName[");
            sb5.append(this.f76765e);
            sb5.append("], traceId[");
            sb5.append(this.f76770j);
            sb5.append("], head[");
            if (this.f76763c != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], isHide[");
            sb5.append(this.f76769i);
            sb5.append("]}");
            return sb5.toString();
        }

        b() {
            e(null);
        }
    }
}
