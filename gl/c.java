package gl;

import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.message.data.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import ef.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mk.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u001a\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\nR\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lgl/c;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", QCircleAlphaUserReporter.KEY_USER, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "stCommonExt", "", "f", "", "g", "", "d", "e", "uin", "", "uid", "b", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f402376a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QZonePassiveMessageUtils";

    c() {
    }

    public final boolean a() {
        return com.qzone.reborn.a.f52169a.b("exp_qzone_message_page_UI", "_C");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r9.isFriend(r8, gl.c.TAG) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(long uin, String uid) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        boolean c16 = com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp_qzone_message_page_chat", null, 2, null);
        if (uid.length() > 0) {
            z16 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uid, TAG);
        } else {
            if (uin != 0) {
                String uidFromNT = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(uin));
                if (!(uidFromNT == null || uidFromNT.length() == 0)) {
                    IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                    Intrinsics.checkNotNullExpressionValue(uidFromNT, "uidFromNT");
                }
                z16 = false;
            }
            z16 = true;
        }
        return c16 && z16;
    }

    public final boolean d() {
        com.qzone.reborn.a aVar = com.qzone.reborn.a.f52169a;
        boolean z16 = aVar.b("exp_qzone_message_page_UI", "_B") || aVar.b("exp_qzone_message_page_UI", "_C");
        return !AppSetting.isPublicVersion() ? gd.a.f401926a.c("KEY_ENABLE_NEW_PASSIVE_MESSAGE", false) && z16 : z16;
    }

    public final boolean e() {
        if (!AppSetting.isPublicVersion()) {
            return gd.a.f401926a.c("KEY_ENABLE_OLD_STYLE_PASSIVE_MESSAGE", true);
        }
        return g.f53821a.b().Y();
    }

    public final long f(CommonStUser user, CommonStCommonExt stCommonExt) {
        Intrinsics.checkNotNullParameter(user, "user");
        long k3 = d.k(user.getUin());
        if (k3 != 0) {
            return k3;
        }
        return h.f416877a.g(user.getUid(), stCommonExt != null ? e.A(stCommonExt) : null);
    }

    public final void g() {
        com.qzone.reborn.a aVar = com.qzone.reborn.a.f52169a;
        com.qzone.reborn.a.e(aVar, "exp_qzone_message_page_UI", null, 2, null);
        com.qzone.reborn.a.e(aVar, "exp_qzone_message_page_chat", null, 2, null);
    }

    public static /* synthetic */ boolean c(c cVar, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        if ((i3 & 2) != 0) {
            str = "";
        }
        return cVar.b(j3, str);
    }
}
