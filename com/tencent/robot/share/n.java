package com.tencent.robot.share;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.data.RobotInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00062\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b(\u0010)J\u001e\u0010\u0006\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\r\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0011\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0015\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001d\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u0011\u0010\u001f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u0011\u0010!\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b \u0010\fR\u0011\u0010#\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\fR\u0011\u0010%\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\fR\u0011\u0010'\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\f\u00a8\u0006*"}, d2 = {"Lcom/tencent/robot/share/n;", "", "Lkotlin/Function1;", "", "", "callback", "b", "Lcom/tencent/robot/data/RobotInfo;", "a", "Lcom/tencent/robot/data/RobotInfo;", "mRobotInfo", "e", "()Ljava/lang/String;", PhotoCategorySummaryInfo.AVATAR_URL, "l", "robotUin", "k", "robotUid", "", "d", "()Z", "allowAddC2C", "Lcom/tencent/mobileqq/sharehelper/d;", tl.h.F, "()Lcom/tencent/mobileqq/sharehelper/d;", "qzoneLinkShareInfo", DomainData.DOMAIN_NAME, "shareTitle", "j", "robotName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "shareDesc", "o", "targetUrl", "f", "copyUrlText", "g", "copyUrlTips", "i", "robotAppId", "<init>", "(Lcom/tencent/robot/data/RobotInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotInfo mRobotInfo;

    public n(@NotNull RobotInfo mRobotInfo) {
        Intrinsics.checkNotNullParameter(mRobotInfo, "mRobotInfo");
        this.mRobotInfo = mRobotInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 function1, String arkInfoStr) {
        boolean z16;
        QLog.d("robot.share.RobotShareInfoProvider", 4, "fetchRobotShareInfo arkInfoStr:" + arkInfoStr);
        if (arkInfoStr != null && arkInfoStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("robot.share.RobotShareInfoProvider", 1, "fetchRobotShareInfo failed fetch arkInfo");
            if (function1 != null) {
                function1.invoke("");
                return;
            }
            return;
        }
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(arkInfoStr, "arkInfoStr");
            function1.invoke(arkInfoStr);
        }
    }

    public final void b(@Nullable final Function1<? super String, Unit> callback) {
        QRouteApi api = QRoute.api(ITroopUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
        ((ITroopUtilApi) api).fetchRobotShareInfo(MobileQQ.sMobileQQ.peekAppRuntime(), this.mRobotInfo.getRobotUin(), new com.tencent.mobileqq.troop.api.a() { // from class: com.tencent.robot.share.m
            @Override // com.tencent.mobileqq.troop.api.a
            public final void onResult(String str) {
                n.c(Function1.this, str);
            }
        });
    }

    public final boolean d() {
        return this.mRobotInfo.getAllowAddC2C();
    }

    @NotNull
    public final String e() {
        return this.mRobotInfo.getRobotAvatarUrl();
    }

    @NotNull
    public final String f() {
        return "\u70b9\u51fb\u94fe\u63a5\u4e86\u89e3\u673a\u5668\u4eba\u8be6\u60c5\u3010" + this.mRobotInfo.getRobotName() + "\u3011" + this.mRobotInfo.getRobotJumpUrl();
    }

    @NotNull
    public final String g() {
        String string = MobileQQ.sMobileQQ.getString(R.string.f223406g5);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.st\u2026robot_share_copy_success)");
        return string;
    }

    @NotNull
    public final com.tencent.mobileqq.sharehelper.d h() {
        com.tencent.mobileqq.sharehelper.d dVar = new com.tencent.mobileqq.sharehelper.d();
        dVar.n(m());
        dVar.j("");
        dVar.p(n());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(e());
        dVar.l(arrayList);
        dVar.o(o());
        dVar.k(0);
        dVar.i(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        dVar.m(2000);
        return dVar;
    }

    @NotNull
    public final String i() {
        return this.mRobotInfo.getRobotAppId();
    }

    @NotNull
    public final String j() {
        return this.mRobotInfo.getRobotName();
    }

    @NotNull
    public final String k() {
        String robotUid = this.mRobotInfo.getRobotUid();
        if (robotUid == null) {
            return "";
        }
        return robotUid;
    }

    @NotNull
    public final String l() {
        String robotUin = this.mRobotInfo.getRobotUin();
        if (robotUin == null) {
            return "";
        }
        return robotUin;
    }

    @NotNull
    public final String m() {
        String robotDesc = this.mRobotInfo.getRobotDesc();
        if (robotDesc == null) {
            return "";
        }
        return robotDesc;
    }

    @NotNull
    public final String n() {
        return this.mRobotInfo.getRobotName();
    }

    @NotNull
    public final String o() {
        String robotJumpUrl = this.mRobotInfo.getRobotJumpUrl();
        if (robotJumpUrl == null) {
            return "";
        }
        return robotJumpUrl;
    }
}
