package com.tencent.mobileqq.qqexpand.manager;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean$BannerItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface e {
    boolean A(Activity activity, BaseQQAppInterface baseQQAppInterface);

    boolean B();

    boolean C();

    void D(String str, Bundle bundle);

    void E(wg2.a aVar);

    boolean F();

    String G();

    void H(String str, String str2, int i3);

    void I();

    int J();

    String K();

    boolean L(ExpandConfig expandConfig);

    void M(boolean z16);

    int N();

    void O(com.tencent.mobileqq.qqexpand.bean.feed.a aVar);

    boolean P();

    void Q();

    void R(int i3);

    void S(BusinessInfoCheckUpdate.AppInfo appInfo);

    boolean T();

    void U();

    void V(int i3, int i16);

    boolean W(BaseQQAppInterface baseQQAppInterface);

    int X();

    String Y();

    int a();

    com.tencent.mobileqq.qqexpand.bean.feed.a a0();

    void b();

    void b0(boolean z16);

    boolean c();

    String c0();

    ExtendFriendSearchHistoryManager d();

    int d0();

    ExpandConfig e();

    ExtendFriendSearchHistoryManager e0();

    int f(String str);

    ExpandConfig g();

    ArrayList<ExpandBannerConfBean$BannerItem> getBannerConfigList();

    int h();

    String i();

    boolean isResourceReady();

    void j(int i3, String str, String str2, int i16);

    void k(Activity activity);

    String l();

    void m(ExpandUserInfo expandUserInfo);

    void n();

    ExpandUserInfo o(String str, boolean z16);

    boolean p();

    List<String> q(int i3);

    List<String> r(int i3);

    boolean s();

    String t();

    boolean u();

    void v(String str);

    vg2.b w();

    Object x();

    boolean y();

    String z();
}
