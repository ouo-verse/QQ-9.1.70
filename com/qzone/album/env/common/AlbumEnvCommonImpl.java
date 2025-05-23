package com.qzone.album.env.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.qzone.common.tool.ReportUtils;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.retention.RetentionReport;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import ho.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import s8.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumEnvCommonImpl extends a {

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, StringBuilder> f43882b = new HashMap();

    @Override // com.qzone.album.env.common.a
    public boolean B() {
        return true;
    }

    @Override // com.qzone.album.env.common.a
    public boolean C() {
        return NetworkState.isNetSupport();
    }

    @Override // com.qzone.album.env.common.a
    public boolean D() {
        return false;
    }

    @Override // com.qzone.album.env.common.a
    public int E(String str) {
        return LoginData.getInstance().getUserType();
    }

    @Override // com.qzone.album.env.common.a
    public boolean F(String str) {
        return u5.b.B(str);
    }

    @Override // com.qzone.album.env.common.a
    public void G(Activity activity, long j3) {
        i.z().r(activity, j3);
    }

    @Override // com.qzone.album.env.common.a
    public void H(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(runnable);
    }

    @Override // com.qzone.album.env.common.a
    public void I(Runnable runnable, long j3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(runnable, j3);
    }

    @Override // com.qzone.album.env.common.a
    public void J(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(runnable);
    }

    @Override // com.qzone.album.env.common.a
    public void K(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(runnable);
    }

    @Override // com.qzone.album.env.common.a
    public void L() {
        f.f().g("0");
    }

    @Override // com.qzone.album.env.common.a
    public void M(String str, boolean z16) {
        u5.b.o0(str, z16);
    }

    @Override // com.qzone.album.env.common.a
    public void N(String str, long j3) {
        LocalMultiProcConfig.putLong(str, j3);
    }

    @Override // com.qzone.album.env.common.a
    public void O(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(runnable);
    }

    @Override // com.qzone.album.env.common.a
    public void P(int i3, int i16, String str, boolean z16, String... strArr) {
        ClickReport.c(i3, i16, str, z16, strArr);
    }

    @Override // com.qzone.album.env.common.a
    public void Q(int i3, String str, int... iArr) {
        ClickReport.e(i3, str, iArr);
    }

    @Override // com.qzone.album.env.common.a
    public void R(String str, String str2, String str3) {
        ClickReport.m(str, str2, str3);
    }

    @Override // com.qzone.album.env.common.a
    public void S(String str, HashMap<String, String> hashMap) {
        ReportUtils.b(str, hashMap);
    }

    @Override // com.qzone.album.env.common.a
    public void T(int i3) {
        RetentionReport.report(i3);
    }

    @Override // com.qzone.album.env.common.a
    public void U(int i3) {
        ToastUtil.n(i3);
    }

    @Override // com.qzone.album.env.common.a
    public void V(String str) {
        ToastUtil.r(str);
    }

    @Override // com.qzone.album.env.common.a
    public void W(String str, int i3) {
        ToastUtil.s(str, i3);
    }

    @Override // com.qzone.album.env.common.a
    public void X(String str) {
        oy3.a.a().b(str);
    }

    @Override // com.qzone.album.env.common.a
    public void Y(String str, boolean z16) {
        oy3.a.a().c(str, z16);
    }

    @Override // com.qzone.album.env.common.a
    public void a() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.album.env.common.AlbumEnvCommonImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        for (Map.Entry<String, StringBuilder> entry : AlbumEnvCommonImpl.f43882b.entrySet()) {
                            QZLog.d("CloseTrace", 2, "====================Trace Info====================");
                            if (entry.getValue().toString().length() < 4000) {
                                QZLog.d(entry.getKey(), 2, entry.getValue().toString());
                            } else {
                                int length = entry.getValue().toString().length() / 4000;
                                int i3 = 0;
                                while (i3 < length) {
                                    int i16 = i3 * 4000;
                                    QZLog.d(entry.getKey(), 2, entry.getValue().toString().substring(i16, i16 + 4000));
                                    i3++;
                                }
                                if (entry.getValue().toString().length() % 4000 != 0) {
                                    QZLog.d(entry.getKey(), 2, entry.getValue().toString().substring(i3 * 4000, entry.getValue().toString().length()));
                                }
                            }
                            QZLog.d("CloseTrace", 2, "====================End Trace Info====================");
                        }
                    } catch (OutOfMemoryError e16) {
                        QZLog.e("AlbumEnvCommonImpl", 1, e16, new Object[0]);
                    }
                } finally {
                    AlbumEnvCommonImpl.f43882b.clear();
                }
            }
        });
    }

    @Override // com.qzone.album.env.common.a
    public void c(String str, Object... objArr) {
        if (QZLog.isColorLevel()) {
            QZLog.d(str, 1, objArr);
        }
    }

    @Override // com.qzone.album.env.common.a
    public void d(String str, Object... objArr) {
        if (QZLog.isColorLevel()) {
            QZLog.d(str, 2, objArr);
        }
    }

    @Override // com.qzone.album.env.common.a
    public void e(String str, String str2) {
        QZLog.e(str, str2);
    }

    @Override // com.qzone.album.env.common.a
    public void f(String str, String str2, Throwable th5) {
        QZLog.e(str, str2, th5);
    }

    @Override // com.qzone.album.env.common.a
    public boolean j() {
        return NetworkState.isWifiConn() && com.qzone.adapter.feedcomponent.i.H().k() && com.qzone.adapter.feedcomponent.i.H().Y() == 3;
    }

    @Override // com.qzone.album.env.common.a
    public void k() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.album.env.common.AlbumEnvCommonImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (z5.a.f().g(LoginData.getInstance().getUin()) == null) {
                    z5.a.f().q(LoginData.getInstance().getUin(), null);
                }
            }
        });
    }

    @Override // com.qzone.album.env.common.a
    public Handler o() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler();
    }

    @Override // com.qzone.album.env.common.a
    public boolean p(String str, boolean z16) {
        return u5.b.D(str, z16);
    }

    @Override // com.qzone.album.env.common.a
    public float q() {
        return ar.i();
    }

    @Override // com.qzone.album.env.common.a
    public long s() {
        return LoginData.getInstance().getUin();
    }

    @Override // com.qzone.album.env.common.a
    public int t(String str, String str2, int i3) {
        return QzoneConfig.getInstance().getConfig(str, str2, i3);
    }

    @Override // com.qzone.album.env.common.a
    public Handler u() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler();
    }

    @Override // com.qzone.album.env.common.a
    public int v() {
        return ar.l();
    }

    @Override // com.qzone.album.env.common.a
    public int w(long j3) {
        x6.a g16 = z5.a.f().g(j3);
        if (g16 != null) {
            return g16.gender;
        }
        return 0;
    }

    @Override // com.qzone.album.env.common.a
    public String x(long j3) {
        x6.a g16 = z5.a.f().g(j3);
        if (g16 != null) {
            return g16.nickName;
        }
        return null;
    }

    @Override // com.qzone.album.env.common.a
    public void y(Activity activity, int i3, int i16, int i17, int i18, ArrayList<String> arrayList, boolean z16) {
        Intent intent = new Intent();
        if (!z16) {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        }
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, i3);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i16);
        intent.putExtra("key_selected_share_uin", i17);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        if (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, intent, i18);
    }

    @Override // com.qzone.album.env.common.a
    public void b(String str, Object... objArr) {
        QLog.d(str, 4, objArr);
    }

    @Override // com.qzone.album.env.common.a
    public void g(String str, Throwable th5) {
        QZLog.e(str, 1, th5, new Object[0]);
    }

    @Override // com.qzone.album.env.common.a
    public void h(String str, Object... objArr) {
        QZLog.i(str, 1, objArr);
    }

    @Override // com.qzone.album.env.common.a
    public void i(String str, Object... objArr) {
        QZLog.w(str, 1, objArr);
    }

    @Override // com.qzone.album.env.common.a
    public void l(String str) {
        PerfTracer.traceEnd(str, true);
    }

    @Override // com.qzone.album.env.common.a
    public Context n(Activity activity) {
        if (activity != null) {
            return activity.getApplicationContext();
        }
        throw new RuntimeException("AlbumEnvCommonImplgetApplicationContext");
    }

    @Override // com.qzone.album.env.common.a
    public ArrayList<s4.b> r(Intent intent) {
        ArrayList parcelableArrayListExtra;
        if (intent == null || intent.getExtras() == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET)) == null) {
            return null;
        }
        ArrayList<s4.b> arrayList = new ArrayList<>();
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            ResultRecord resultRecord = (ResultRecord) it.next();
            try {
                arrayList.add(new s4.b(Long.parseLong(resultRecord.uin), resultRecord.name));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    @Override // com.qzone.album.env.common.a
    public void z(Activity activity, int i3, int i16) {
        if (activity == null) {
            QLog.e("AlbumEnvCommonImpl", 1, "gotoSelectSingleFriendsPage  sourceActivity == null");
            return;
        }
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ForwardFriendListActivity.class);
        intent.putExtra("extra_choose_friend", 3);
        intent.putExtra("key_selected_share_uin", i3);
        intent.putExtra("only_single_selection", true);
        activity.startActivityForResult(intent, i16);
    }
}
