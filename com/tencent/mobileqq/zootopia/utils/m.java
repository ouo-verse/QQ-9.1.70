package com.tencent.mobileqq.zootopia.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/m;", "", "", "a", "", "b", "", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f329564a = new m();

    m() {
    }

    public final int a() {
        return HttpUtil.getNetWorkTypeContain5G();
    }

    public final String b() {
        int a16 = a();
        switch (a16) {
            case 0:
                return "NONE";
            case 1:
                return Global.TRACKING_WIFI;
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "CABLE";
            case 6:
                return "5G";
            default:
                return "UNKNOWN_" + a16;
        }
    }

    public final boolean c() {
        try {
            Object systemService = BaseApplication.getContext().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager == null) {
                return AppNetConnInfo.isMobileConn();
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && NetworkMonitor.getType(activeNetworkInfo) == 0;
        } catch (Exception unused) {
            return AppNetConnInfo.isMobileConn();
        }
    }
}
