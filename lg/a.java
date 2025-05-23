package lg;

import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.route.QZoneUserHomeBean;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Llg/a;", "", "Lcom/qzone/proxy/feedcomponent/model/User;", QCircleAlphaUserReporter.KEY_USER, "", "a", "Lcom/qzone/reborn/route/QZoneUserHomeBean;", "bean", "b", "", "uin", "c", "Lx6/a;", "userInfoData", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414452a = new a();

    a() {
    }

    public final boolean c(long uin) {
        return vo.d.b().d(uin);
    }

    public final boolean d(x6.a userInfoData) {
        Intrinsics.checkNotNullParameter(userInfoData, "userInfoData");
        return userInfoData.isVideo57SpaceUser() || userInfoData.isSchoolSpaceUser() || userInfoData.isStarSpaceUser();
    }

    public final boolean a(User user) {
        if (user == null) {
            return false;
        }
        return user.isFamousWhite == 3 || user.actiontype == 35 || c(user.uin);
    }

    public final boolean b(QZoneUserHomeBean bean) {
        if (bean == null) {
            return false;
        }
        return bean.isFamousSpace() || bean.getActionType() == 35 || c(bean.getUin());
    }
}
