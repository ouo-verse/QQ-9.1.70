package com.qzone.reborn.feedx.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.reborn.feedx.itemview.QZoneFeedxEmptyPageView;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class k {
    public static uc.a B(Context context, String str) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(16).setTitle(str).setBackgroundColorType(0).setHalfScreenState(true)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(true));
    }

    public static uc.a D(Context context, String str) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(str).setBackgroundColorType(0).setHalfScreenState(false)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(false));
    }

    public static QZoneFeedxEmptyPageView.a a(String str) {
        return new QZoneFeedxEmptyPageView.a().o(false).n(str).i(com.qzone.reborn.util.h.b(true, QQTheme.isNowThemeIsNightForQzone())).l(false);
    }

    public static uc.a c(Context context, String str) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(8).setTitle(str).setBackgroundColorType(0).setHalfScreenState(true)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(true));
    }

    public static uc.a d(Context context, boolean z16, String str, View.OnClickListener onClickListener) {
        return new uc.a().c(new QZoneBlankStateView.a().d("").b(new QUIEmptyState.Builder(context).setImageType(6).setHalfScreenState(true).setTitle(str).setBackgroundColorType(0))).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(true));
    }

    public static uc.a e(Context context, String str) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(str).setBackgroundColorType(0).setHalfScreenState(true)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(true));
    }

    public static uc.a g(Context context) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(com.qzone.util.l.a(R.string.v8o)).setBackgroundColorType(0));
    }

    public static uc.a h(Context context, String str) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(8).setHalfScreenState(true).setTitle(str).setBackgroundColorType(0)).f(new QUIEmptyState.Builder(context).setImageType(13).setHalfScreenState(true).setDesc(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0));
    }

    public static uc.a i(Context context) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(com.qzone.util.l.a(R.string.v8p)).setBackgroundColorType(0));
    }

    public static uc.a j(Context context, boolean z16, View.OnClickListener onClickListener) {
        String str;
        uc.a aVar = new uc.a();
        QZoneBlankStateView.a c16 = new QZoneBlankStateView.a().c(onClickListener);
        String str2 = "";
        if (!z16) {
            str = "";
        } else {
            str = com.qzone.util.l.a(R.string.f133155c);
        }
        QZoneBlankStateView.a d16 = c16.d(str);
        QUIEmptyState.Builder halfScreenState = new QUIEmptyState.Builder(context).setImageType(6).setHalfScreenState(true);
        if (!z16) {
            str2 = com.qzone.util.l.a(R.string.w9o);
        }
        return aVar.c(d16.b(halfScreenState.setDesc(str2).setBackgroundColorType(0))).e(new QZoneBlankStateView.a().b(new QUIEmptyState.Builder(context).setImageType(13).setHalfScreenState(true).setDesc(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0)));
    }

    public static QZoneFeedxEmptyPageView.a k(boolean z16) {
        return new QZoneFeedxEmptyPageView.a().o(false).n(l(!z16)).i(com.qzone.reborn.util.h.d()).m(true).p(com.qzone.reborn.util.h.e(z16)).j(true).l(false);
    }

    public static uc.a m(Context context, String str, String str2, String str3, View.OnClickListener onClickListener) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(str).setBackgroundColorType(0).setDesc(str2).setHalfScreenState(true).setButton(str3, onClickListener)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(true));
    }

    public static uc.a n(Context context, String str) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(8).setHalfScreenState(false).setTitle(str).setBackgroundColorType(0)).f(new QUIEmptyState.Builder(context).setImageType(13).setHalfScreenState(false).setDesc(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0));
    }

    public static uc.a o(Context context, String str, String str2) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(1).setTitle(str).setBackgroundColorType(0).setHalfScreenState(false).setDesc(str2)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(false));
    }

    public static uc.a p(Context context) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(com.qzone.util.l.a(R.string.f169522jj0)).setBackgroundColorType(0).setHalfScreenState(false).setDesc(com.qzone.util.l.a(R.string.jiw))).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(false));
    }

    public static uc.a q(Context context, View.OnClickListener onClickListener) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(com.qzone.util.l.a(R.string.f169523jj1)).setBackgroundColorType(0).setHalfScreenState(false).setButton(com.qzone.util.l.a(R.string.jiv), onClickListener)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(false));
    }

    public static uc.a r(Context context) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(com.qzone.util.l.a(R.string.f169526jj4)).setBackgroundColorType(0).setHalfScreenState(false).setDesc(com.qzone.util.l.a(R.string.f169525jj3))).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(false));
    }

    public static uc.a s(Context context, View.OnClickListener onClickListener) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(6).setTitle(com.qzone.util.l.a(R.string.jj5)).setBackgroundColorType(0).setHalfScreenState(false).setButton(com.qzone.util.l.a(R.string.f169524jj2), onClickListener)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(false));
    }

    public static QZoneFeedxEmptyPageView.a t(boolean z16) {
        return new QZoneFeedxEmptyPageView.a().o(false).n(C(z16)).i(com.qzone.reborn.util.h.b(true, QQTheme.isNowThemeIsNightForQzone())).l(!z16).k(true);
    }

    public static QZoneFeedxEmptyPageView.a u(String str) {
        return new QZoneFeedxEmptyPageView.a().o(false).n("\u65e0\u6cd5\u67e5\u770b").p(str).m(true).i(com.qzone.reborn.util.h.b(true, QQTheme.isNowThemeIsNightForQzone())).l(false).k(true);
    }

    public static QZoneFeedxEmptyPageView.a v(boolean z16) {
        String str;
        QZoneFeedxEmptyPageView.a n3 = new QZoneFeedxEmptyPageView.a().o(false).n("\u8fd9\u7247\u661f\u7a7a\uff0c\u53ea\u6709\u6d41\u661f\u5212\u8fc7");
        if (z16) {
            str = "\u7533\u8bf7\u8bbf\u95ee\u4ed6\u7684\u7a7a\u95f4\uff0c\u5bf9\u65b9\u540c\u610f\u540e\u5373\u53ef\u67e5\u770b\u3002";
        } else {
            str = "\u7533\u8bf7\u8bbf\u95ee\u5979\u7684\u7a7a\u95f4\uff0c\u5bf9\u65b9\u540c\u610f\u540e\u5373\u53ef\u67e5\u770b\u3002";
        }
        return n3.p(str).m(true).i(com.qzone.reborn.util.h.b(true, QQTheme.isNowThemeIsNightForQzone())).l(true).m(true).k(true);
    }

    public static QZoneFeedxEmptyPageView.a w(String str) {
        return new QZoneFeedxEmptyPageView.a().o(false).n(str).i(com.qzone.reborn.util.h.b(true, QQTheme.isNowThemeIsNightForQzone())).l(false).k(true);
    }

    public static QZoneFeedxEmptyPageView.a x() {
        return new QZoneFeedxEmptyPageView.a().o(false).n("\u4e3b\u4eba\u672a\u5f00\u901a\u7a7a\u95f4").i(com.qzone.reborn.util.h.b(true, QQTheme.isNowThemeIsNightForQzone())).l(false).k(true);
    }

    public static uc.a y(Context context) {
        return new uc.a().c(new QZoneBlankStateView.a().b(new QUIEmptyState.Builder(context).setImageType(16).setHalfScreenState(true).setTitle(com.qzone.util.l.a(R.string.was)).setBackgroundColorType(0))).f(new QUIEmptyState.Builder(context).setImageType(13).setHalfScreenState(true).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0));
    }

    public static uc.a z(Context context, String str) {
        return new uc.a().d(new QUIEmptyState.Builder(context).setImageType(16).setTitle(str).setBackgroundColorType(0).setHalfScreenState(true)).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0).setHalfScreenState(true));
    }

    private static String C(boolean z16) {
        if (z16) {
            return "\u70b9\u51fb+\u53f7\uff0c\u5f00\u59cb\u8fde\u8f7d\u4f60\u7684\u751f\u6d3b";
        }
        if (!TextUtils.isEmpty(QZoneFeedService.f47178j0)) {
            return QZoneFeedService.f47178j0;
        }
        return "\u8fd9\u7247\u661f\u7a7a\uff0c\u53ea\u6709\u6d41\u661f\u5212\u8fc7";
    }

    public static boolean E(x6.a aVar) {
        x6.d dVar;
        return (aVar == null || (dVar = aVar.strangerDecorate) == null || TextUtils.isEmpty(dVar.f447267b)) ? false : true;
    }

    public static uc.a b(Context context, boolean z16, View.OnClickListener onClickListener) {
        String l3;
        if (z16) {
            l3 = com.qzone.reborn.configx.g.f53821a.g().j();
        } else {
            l3 = com.qzone.reborn.configx.g.f53821a.g().l();
        }
        return new uc.a().c(new QZoneBlankStateView.a().b(new QUIEmptyState.Builder(context).setImageType(6).setHalfScreenState(true).setTitle(l3).setBackgroundColorType(0))).f(new QUIEmptyState.Builder(context).setImageType(13).setHalfScreenState(true).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0));
    }

    public static uc.a f(Context context, boolean z16, boolean z17, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        String n3;
        String str;
        if (z16) {
            n3 = com.qzone.reborn.configx.g.f53821a.h().m();
        } else {
            n3 = com.qzone.reborn.configx.g.f53821a.h().n();
        }
        uc.a aVar = new uc.a();
        QZoneBlankStateView.a e16 = new QZoneBlankStateView.a().c(onClickListener).e(onClickListener2);
        String str2 = "";
        if (z16) {
            str = "";
        } else {
            str = com.qzone.util.l.a(R.string.uzz);
        }
        QZoneBlankStateView.a d16 = e16.d(str);
        if (!z16 && z17) {
            str2 = com.qzone.util.l.a(R.string.uzx);
        }
        return aVar.c(d16.f(str2).b(new QUIEmptyState.Builder(context).setImageType(6).setHalfScreenState(true).setTitle(n3).setBackgroundColorType(0))).f(new QUIEmptyState.Builder(context).setImageType(13).setHalfScreenState(true).setTitle(com.qzone.util.l.a(R.string.f133596j)).setBackgroundColorType(0));
    }

    private static String l(boolean z16) {
        if (z16) {
            return com.qzone.reborn.util.h.f(false);
        }
        if (!TextUtils.isEmpty(y6.e.H)) {
            return y6.e.H;
        }
        return com.qzone.reborn.util.h.f(true);
    }

    public static boolean F(x6.a aVar) {
        return aVar != null && aVar.isOpenFollow && aVar.isFollow48SpaceUser() && !aVar.isLimitRelationship();
    }

    public static boolean G(x6.a aVar) {
        if (aVar == null) {
            return false;
        }
        QLog.i("QZoneEmptyOrForbiddenPageViewHelper", 1, "host uin is " + aVar.uin + ", guest uin is " + LoginData.getInstance().getUin() + ", relationship is " + aVar.relationShip);
        int i3 = aVar.relationShip;
        return i3 == 2 || i3 == 1 || aVar.uin == LoginData.getInstance().getUin();
    }

    public static uc.a A(Context context, boolean z16, boolean z17, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        String a16;
        String str;
        if (z16) {
            a16 = com.qzone.util.l.a(R.string.f134087v);
        } else {
            a16 = com.qzone.util.l.a(R.string.f134097w);
        }
        uc.a aVar = new uc.a();
        QZoneBlankStateView.a c16 = new QZoneBlankStateView.a().c(onClickListener);
        String str2 = "";
        if (!z17) {
            str = "";
        } else {
            str = com.qzone.util.l.a(R.string.f134067t);
        }
        QZoneBlankStateView.a d16 = c16.d(str);
        QUIEmptyState.Builder title = new QUIEmptyState.Builder(context).setImageType(6).setHalfScreenState(true).setTitle(a16);
        if (z16) {
            str2 = com.qzone.util.l.a(R.string.f134077u);
        }
        return aVar.c(d16.b(title.setDesc(str2).setBackgroundColorType(0))).e(new QZoneBlankStateView.a().d(com.qzone.util.l.a(R.string.f134107x)).c(onClickListener2).b(new QUIEmptyState.Builder(context).setImageType(5).setHalfScreenState(true).setTitle(com.qzone.util.l.a(R.string.f134127z)).setDesc(com.qzone.util.l.a(R.string.f134117y)).setBackgroundColorType(0)));
    }
}
