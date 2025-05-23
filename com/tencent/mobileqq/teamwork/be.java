package com.tencent.mobileqq.teamwork;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class be implements Manager {

    /* renamed from: f, reason: collision with root package name */
    private static String f292061f = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";

    /* renamed from: h, reason: collision with root package name */
    private static String f292062h = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";

    /* renamed from: i, reason: collision with root package name */
    private static String f292063i = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";

    /* renamed from: m, reason: collision with root package name */
    private static String f292064m = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";

    /* renamed from: d, reason: collision with root package name */
    AppInterface f292065d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f292066e = false;

    public be(AppInterface appInterface) {
        this.f292065d = appInterface;
    }

    public static String a() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(b.f292028a, 4);
        if (sharedPreferences != null) {
            f292063i = sharedPreferences.getString(b.f292031d, "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png");
        }
        return f292063i;
    }

    public static String b() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(b.f292028a, 4);
        if (sharedPreferences != null) {
            f292064m = sharedPreferences.getString(b.f292032e, "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png");
        }
        return f292064m;
    }

    public static String c() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(b.f292028a, 4);
        if (sharedPreferences != null) {
            f292061f = sharedPreferences.getString(b.f292029b, "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png");
        }
        return f292061f;
    }

    public static String d() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(b.f292028a, 4);
        if (sharedPreferences != null) {
            f292062h = sharedPreferences.getString(b.f292030c, "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png");
        }
        return f292062h;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
