package nl4;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import fm4.p;
import fm4.q;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010H\u001a\u00020D\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J*\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J*\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\"\u0010\u0017\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J2\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\fH\u0016J*\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0018\u0010\"\u001a\u00020\u00052\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\bH\u0016J\"\u0010(\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J$\u0010.\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J(\u00104\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0016J\u0018\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u000201H\u0016J \u00108\u001a\u00020\u00052\u0006\u00103\u001a\u0002012\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u000201H\u0016J\u001a\u0010;\u001a\u00020\u00052\u0006\u00109\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020#H\u0016J\u0012\u0010@\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u001e\u0010C\u001a\u00020\u00052\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\f\u0018\u00010AH\u0016R\u0017\u0010H\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\bC\u0010E\u001a\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lnl4/d;", "Lfm4/q;", "Lfm4/p;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "y", "v", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "speakingPosInfoList", "o", "", "inOutType", "speakingPosInfo", "lastestPosInfoList", "e", "readyStatusType", "k", "posStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "switchType", "i", "w", "kickedUserId", "reason", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "onlineNum", "b", "newRoomOwnerUid", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomModifyInfoActionContent;", "modifyInfoContentList", "p", "", "isStatusChanged", "gameStatus", "Ltrpc/yes/common/YoloRoomOuterClass$YoloGameRouteInfo;", "gameRouteInfo", ReportConstant.COSTREPORT_PREFIX, "", "msgId", "obStatus", "Ltrpc/yes/common/YoloRoomOuterClass$YoloBattleOBStatusChangeAction;", "obStatusChangeAction", "r", "inviterUid", "invitedUid", "", "expireTimeStamp", "roomId", "t", "uid", "applyTime", "u", "d", "errorCode", "errorMsg", DomainData.DOMAIN_NAME, "isRemindOwner", "c", "Lsn4/a;", "roomState", h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "memberMicLevelList", "a", "Lnl4/b;", "Lnl4/b;", "getObserver", "()Lnl4/b;", "observer", "<init>", "(Lnl4/b;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class d implements q, p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer;

    public d(@NotNull b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observer = observer;
    }

    @Override // fm4.p
    public void a(@Nullable ConcurrentHashMap<String, Integer> memberMicLevelList) {
        if (memberMicLevelList != null) {
            this.observer.a(memberMicLevelList);
        }
    }

    @Override // fm4.q
    public void d(long roomId, @NotNull CommonOuterClass$QQUserId uid, long applyTime) {
        Intrinsics.checkNotNullParameter(uid, "uid");
    }

    @Override // fm4.q
    public void e(int inOutType, @Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList) {
        if (lastestPosInfoList != null) {
            this.observer.b(lastestPosInfoList);
        }
    }

    @Override // fm4.q
    public void i(int switchType, @Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList) {
        if (lastestPosInfoList != null) {
            this.observer.b(lastestPosInfoList);
        }
    }

    @Override // fm4.q
    public void k(int readyStatusType, @Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList) {
        if (lastestPosInfoList != null) {
            this.observer.b(lastestPosInfoList);
        }
    }

    @Override // fm4.q
    public void m(@NotNull CommonOuterClass$QQUserId kickedUserId, @Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList, int reason) {
        Intrinsics.checkNotNullParameter(kickedUserId, "kickedUserId");
        if (lastestPosInfoList != null) {
            this.observer.b(lastestPosInfoList);
        }
    }

    @Override // fm4.q
    public void o(@Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> speakingPosInfoList) {
        if (speakingPosInfoList != null) {
            this.observer.b(speakingPosInfoList);
        }
    }

    @Override // fm4.q
    public void q(@NotNull CommonOuterClass$QQUserId newRoomOwnerUid) {
        Intrinsics.checkNotNullParameter(newRoomOwnerUid, "newRoomOwnerUid");
    }

    @Override // fm4.q
    public void t(@NotNull CommonOuterClass$QQUserId inviterUid, @NotNull CommonOuterClass$QQUserId invitedUid, long expireTimeStamp, long roomId) {
        Intrinsics.checkNotNullParameter(inviterUid, "inviterUid");
        Intrinsics.checkNotNullParameter(invitedUid, "invitedUid");
    }

    @Override // fm4.q
    public void u(@NotNull CommonOuterClass$QQUserId uid, long applyTime) {
        Intrinsics.checkNotNullParameter(uid, "uid");
    }

    @Override // fm4.q
    public void v(@NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
    }

    @Override // fm4.q
    public void w(@Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList) {
        if (lastestPosInfoList != null) {
            this.observer.b(lastestPosInfoList);
        }
    }

    @Override // fm4.q
    public void x(@NotNull CommonOuterClass$QQUserId kickedUserId, @Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList) {
        Intrinsics.checkNotNullParameter(kickedUserId, "kickedUserId");
        if (lastestPosInfoList != null) {
            this.observer.b(lastestPosInfoList);
        }
    }

    @Override // fm4.q
    public void y(@NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
    }

    @Override // fm4.q
    public void z(int posStatus, @Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo speakingPosInfo, @Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> lastestPosInfoList) {
        if (lastestPosInfoList != null) {
            this.observer.b(lastestPosInfoList);
        }
    }

    @Override // fm4.q
    public void b(int onlineNum) {
    }

    @Override // fm4.q
    public void c(boolean isRemindOwner) {
    }

    @Override // fm4.p
    public void h(@Nullable sn4.a roomState) {
    }

    @Override // fm4.q
    public void p(@Nullable List<YoloRoomOuterClass$YoloRoomModifyInfoActionContent> modifyInfoContentList) {
    }

    @Override // fm4.q
    public void n(int errorCode, @Nullable String errorMsg) {
    }

    @Override // fm4.q
    public void r(@Nullable String msgId, int obStatus, @Nullable YoloRoomOuterClass$YoloBattleOBStatusChangeAction obStatusChangeAction) {
    }

    @Override // fm4.q
    public void s(boolean isStatusChanged, int gameStatus, @Nullable YoloRoomOuterClass$YoloGameRouteInfo gameRouteInfo) {
    }
}
