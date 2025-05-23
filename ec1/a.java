package ec1;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.dt.api.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tJX\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0014"}, d2 = {"Lec1/a;", "", "Lmqq/app/AppRuntime;", "runtime", "", "appId", "groupId", "evilUin", "fileId", "", "busId", "", "a", "evilUinType", "contentId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f396078a = new a();

    a() {
    }

    public final void a(@NotNull AppRuntime runtime, @Nullable String appId, @Nullable String groupId, @Nullable String evilUin, @Nullable String fileId, int busId) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        b(runtime, appId, groupId, evilUin, fileId, busId, 2, "groupID=" + groupId + "&busID=" + busId + "&fileID=" + fileId, null);
    }

    public final void b(@NotNull AppRuntime runtime, @Nullable String appId, @Nullable String groupId, @Nullable String evilUin, @Nullable String fileId, int busId, int evilUinType, @NotNull String contentId, @Nullable Activity activity) {
        String str;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        b bVar = new b();
        bVar.i(appId);
        bVar.r(groupId);
        bVar.n(evilUin);
        bVar.o(evilUinType);
        bVar.s(0);
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(evilUin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (iFriendsInfoService.isFriend(uid, "JuBaoTroopFile")) {
            str = "1";
        } else {
            str = "0";
        }
        bVar.j(str);
        bVar.m(contentId);
        if (activity == null) {
            activity = QBaseActivity.sTopActivity;
        }
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(activity, bVar);
    }
}
