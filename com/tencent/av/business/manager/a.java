package com.tencent.av.business.manager;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.utils.ea;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: f, reason: collision with root package name */
    protected static final String[] f73314f = {"MANAGER_ZIMU", "MANAGER_FILTER", "MANAGER_PENDANT", "MANAGER_FACE", "MANAGER_NODE_REPORTER", "MANAGER_SUPPORT", "MANAGER_REDPACKET", "MANAGER_REDPACKET_Entry", "MANAGER_EFFECT_OPERATE", "MANAGER_ZIMU_LIVE", "MANAGER_Voice_Recog", "MANAGER_Tips", "MANAGER_mutex", "MANAGER_MAKEUP", "MANAGER_VIRTUAL_BG", "MANAGER_EFFECT_MATERIAL", "MANAGER_AVAYAR_2D"};

    /* renamed from: d, reason: collision with root package name */
    public final String f73315d = getClass().getSimpleName() + "_" + e.d();

    /* renamed from: e, reason: collision with root package name */
    protected VideoAppInterface f73316e;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(VideoAppInterface videoAppInterface) {
        this.f73316e = videoAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(String str, VideoAppInterface videoAppInterface, int i3) {
        if (i3 >= 0 && i3 < 20) {
            String[] strArr = f73314f;
            if (i3 < strArr.length) {
                String str2 = "Business_" + strArr[i3];
                boolean z16 = ea.T0(videoAppInterface.getApplication()).getBoolean(str2, false);
                AVCoreLog.printColorLog(str, "isPreloaded:" + str2 + "|" + z16);
                return z16;
            }
        }
        AVCoreLog.printErrorLog(str, "isPreloaded ERROR : bid=" + i3);
        return false;
    }

    public static void k(String str, Context context, int i3, boolean z16) {
        if (i3 >= 0 && i3 < 20) {
            String[] strArr = f73314f;
            if (i3 < strArr.length) {
                String str2 = "Business_" + strArr[i3];
                SharedPreferences.Editor edit = ea.T0(context).edit();
                edit.putBoolean(str2, z16);
                edit.commit();
                AVCoreLog.printErrorLog(str, "setPreload zzzzz  bid=" + i3);
                return;
            }
        }
        AVCoreLog.printErrorLog(str, "setPreload ERROR : bid=" + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void g();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean i(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(long j3, int i3, String str, String str2) {
    }
}
