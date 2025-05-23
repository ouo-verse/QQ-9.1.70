package com.tencent.mobileqq.troop.tipsbar;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.d;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dt.api.IO3NotifyBannerApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.tipsbar.TroopSecurityTipsBanner$Companion$accountChangeCallback$2;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.ConsumeGroupTopBannerReq;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupTopBannerInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryGroupTopBannersCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.NotifyBanner;
import com.tencent.qqnt.kernel.nativeinterface.QueryGroupTopBannersReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryGroupTopBannersRsp;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.report.TroopFeatureReport;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001@\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J \u0010 \u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\fH\u0002J7\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0016\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010&0%\"\u0004\u0018\u00010&H\u0016\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016R\u0016\u0010/\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00107R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0015R\u0016\u0010<\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010.R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010>R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/troop/tipsbar/TroopSecurityTipsBanner;", "Lcom/tencent/mobileqq/aio/notification/d;", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", "", HippyTKDListViewAdapter.X, "y", "", "curSeq", "r", "groupId", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/NotifyBanner;", "banner", "seq", "p", "data", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "w", "D", "t", "J", "bannerInfo", "E", "L", "B", "", BdhLogUtil.LogTag.Tag_Conn, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "expireTime", "msgId", "K", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "eventType", "", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", h.F, "d", "Ljava/lang/String;", "curTroopUin", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "f", "Lcom/tencent/mobileqq/aio/notification/c;", "", "Z", "hasDestroyed", "i", "isRequesting", "curShowSecurityBannerSeq", "beforeTopBannerToken", "Lcom/tencent/qqnt/kernel/api/s;", "Lcom/tencent/qqnt/kernel/api/s;", "groupService", "com/tencent/mobileqq/troop/tipsbar/TroopSecurityTipsBanner$b", "Lcom/tencent/mobileqq/troop/tipsbar/TroopSecurityTipsBanner$b;", "groupListener", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSecurityTipsBanner implements com.tencent.mobileqq.aio.notification.d {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static volatile Boolean G;

    @NotNull
    private static final Lazy<TroopSecurityTipsBanner$Companion$accountChangeCallback$2.a> H;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String beforeTopBannerToken;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private s groupService;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b groupListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String curTroopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.notification.c notificationManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasDestroyed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isRequesting;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long curShowSecurityBannerSeq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/tipsbar/TroopSecurityTipsBanner$a;", "", "", "b", "com/tencent/mobileqq/troop/tipsbar/TroopSecurityTipsBanner$Companion$accountChangeCallback$2$a", "accountChangeCallback$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/troop/tipsbar/TroopSecurityTipsBanner$Companion$accountChangeCallback$2$a;", "accountChangeCallback", "", "KEY_BANNER_CONTENT_TEXT", "Ljava/lang/String;", "KEY_BANNER_CONTENT_URL", "KEY_BANNER_EXPIRE_TIME", "KEY_BANNER_MSG_ID", "KEY_BANNER_SEQ", "", "SECURITY_BANNER_TYPE", "I", "SECURITY_BIZ_TYPE", "TAG", "isEnable", "Ljava/lang/Boolean;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.tipsbar.TroopSecurityTipsBanner$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final TroopSecurityTipsBanner$Companion$accountChangeCallback$2.a a() {
            return (TroopSecurityTipsBanner$Companion$accountChangeCallback$2.a) TroopSecurityTipsBanner.H.getValue();
        }

        @JvmStatic
        public final synchronized boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            boolean z16 = true;
            if (TroopSecurityTipsBanner.G == null) {
                com.tencent.qqnt.report.d.f361946d.a(a());
                TroopSecurityTipsBanner.G = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106172", true));
                if (QLog.isColorLevel()) {
                    QLog.i("TroopSecurityTipsBar", 2, "[isEnable] isEnable:" + TroopSecurityTipsBanner.G);
                }
            }
            Boolean bool = TroopSecurityTipsBanner.G;
            if (bool != null) {
                z16 = bool.booleanValue();
            }
            return z16;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/tipsbar/TroopSecurityTipsBanner$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtListUpdateType;", "updateType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "Lkotlin/collections/ArrayList;", "groupExtList", "", "onGroupExtListUpdate", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSecurityTipsBanner.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
            am.a(this, j3, str, groupBulletinListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAdd(long j3) {
            am.b(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
            am.c(this, groupAllInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
            am.d(this, j3, groupArkInviteStateInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
            am.e(this, j3, groupBulletin);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
            am.f(this, j3, remindGroupBulletinMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.g(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            am.h(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
            am.i(this, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
            am.j(this, groupDetailInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupEssenceListChange(long j3) {
            am.k(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupExtListUpdate(@Nullable GroupExtListUpdateType updateType, @Nullable ArrayList<GroupExtInfo> groupExtList) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateType, (Object) groupExtList);
                return;
            }
            if (groupExtList != null && updateType != GroupExtListUpdateType.REMOVE) {
                TroopSecurityTipsBanner troopSecurityTipsBanner = TroopSecurityTipsBanner.this;
                Iterator<T> it = groupExtList.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String valueOf = String.valueOf(((GroupExtInfo) next).groupCode);
                    String str = troopSecurityTipsBanner.curTroopUin;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                    } else {
                        obj = str;
                    }
                    if (Intrinsics.areEqual(valueOf, obj)) {
                        obj = next;
                        break;
                    }
                }
                GroupExtInfo groupExtInfo = (GroupExtInfo) obj;
                if (groupExtInfo != null) {
                    TroopSecurityTipsBanner.this.r(groupExtInfo.extInfo.topBannerSeq);
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
            am.m(this, firstGroupBulletinInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListInited(boolean z16) {
            am.n(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
            am.o(this, groupListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
            am.p(this, j3, groupMemberLevelInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
            am.q(this, z16, j3, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
            am.r(this, z16, j3, i3, i16, i17, i18);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
            am.s(this, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            am.t(this, z16, j3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
            am.u(this, z16, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
            am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
            am.w(this, j3, groupStatisticInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
            am.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
            am.y(this, j3, z16, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
            am.z(this, joinGroupNotifyMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
            am.A(this, j3, dataSource, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
            am.B(this, groupMemberListChangeInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
            am.C(this, str, str2, arrayList, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            am.D(this, j3, arrayList);
        }
    }

    static {
        Lazy<TroopSecurityTipsBanner$Companion$accountChangeCallback$2.a> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(TroopSecurityTipsBanner$Companion$accountChangeCallback$2.INSTANCE);
        H = lazy;
    }

    public TroopSecurityTipsBanner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.beforeTopBannerToken = "";
            this.groupListener = new b();
        }
    }

    private final NotifyBanner A() {
        boolean z16;
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String str = this.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        String n3 = com.tencent.mobileqq.troop.config.a.n(aVar, "troop_aio_security_banner_content_text_" + str, "", false, 4, null);
        String str2 = this.curTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str2 = null;
        }
        String n16 = com.tencent.mobileqq.troop.config.a.n(aVar, "troop_aio_security_banner_content_url_" + str2, "", false, 4, null);
        String str3 = this.curTroopUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str3 = null;
        }
        long l3 = com.tencent.mobileqq.troop.config.a.l(aVar, "troop_aio_security_banner_expire_time_" + str3, 0L, false, 4, null);
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[getLocalSecurityBanner] expireTime:" + l3 + ", curTime:" + serverTime + ", text:" + n3 + ". url" + n16);
        }
        if (n3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || l3 < serverTime) {
            return null;
        }
        NotifyBanner notifyBanner = new NotifyBanner();
        notifyBanner.text = n3;
        notifyBanner.url = n16;
        return notifyBanner;
    }

    private final long B() {
        return com.tencent.mobileqq.troop.config.a.l(com.tencent.mobileqq.troop.config.a.f294689a, C(), 0L, false, 4, null);
    }

    private final String C() {
        String str = this.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        return "troop_aio_security_banner_seq_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[handleCloseBannerTips] ");
        }
        t();
        J();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(NotifyBanner bannerInfo) {
        boolean startsWith$default;
        BaseQQAppInterface baseQQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[handleO3BannerClicked] ");
        }
        D();
        String url = bannerInfo.url;
        if (TextUtils.isEmpty(url)) {
            QLog.i("TroopSecurityTipsBar", 1, "[handleO3BannerClicked] url is empty");
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        ax axVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (activity == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        boolean z16 = false;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://o3/report", false, 2, null);
        if (startsWith$default) {
            String str = this.curTroopUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                str = null;
            }
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar2 = null;
            }
            url = ((Object) url) + "&uid=" + str + "&chat_type=" + aVar2.g().r().c().e() + "&gray_tip_time=" + (System.currentTimeMillis() / 1000) + "&src=2";
        }
        AppInterface e16 = bg.e();
        if (e16 instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) e16;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null) {
            axVar = bi.c(baseQQAppInterface, activity, url);
        }
        if (axVar == null) {
            z16 = true;
        }
        QLog.i("TroopSecurityTipsBar", 1, "[handleO3BannerClicked] action:" + z16);
        if (axVar != null) {
            axVar.b();
        } else {
            QRoute.createNavigator(activity, RouterConstants.UI_ROUTE_BROWSER).withString("url", url).request();
        }
    }

    @JvmStatic
    public static final synchronized boolean F() {
        boolean b16;
        synchronized (TroopSecurityTipsBanner.class) {
            b16 = INSTANCE.b();
        }
        return b16;
    }

    private final void G(final long groupId, final long curSeq) {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.tipsbar.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopSecurityTipsBanner.H(curSeq, this, groupId);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(long j3, final TroopSecurityTipsBanner this$0, long j16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 <= this$0.B()) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSecurityTipsBar", 2, "[queryGroupTopBanners] skip queryGroupTopBanners, curSeq:" + j3);
                return;
            }
            return;
        }
        s i3 = bg.i(null, 1, null);
        if (i3 == null) {
            return;
        }
        TroopFeatureReport.c(TroopFeatureReport.f361921a, "TroopSecurityTipsBar", false, 2, null);
        QueryGroupTopBannersReq queryGroupTopBannersReq = new QueryGroupTopBannersReq();
        queryGroupTopBannersReq.groupId = j16;
        i3.queryGroupTopBanners(queryGroupTopBannersReq, new IQueryGroupTopBannersCallback() { // from class: com.tencent.mobileqq.troop.tipsbar.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryGroupTopBannersCallback
            public final void onResult(int i16, String str, QueryGroupTopBannersRsp queryGroupTopBannersRsp) {
                TroopSecurityTipsBanner.I(TroopSecurityTipsBanner.this, i16, str, queryGroupTopBannersRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(TroopSecurityTipsBanner this$0, int i3, String str, QueryGroupTopBannersRsp queryGroupTopBannersRsp) {
        Object firstOrNull;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopSecurityTipsBar", 1, "[queryGroupTopBanners] errCode:" + i3 + ". errMsg:" + str + ", seq:" + queryGroupTopBannersRsp.seq);
        if (com.tencent.qqnt.e.d(i3)) {
            this$0.L(queryGroupTopBannersRsp.seq);
            ArrayList<GroupTopBannerInfo> arrayList = queryGroupTopBannersRsp.banners;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.banners");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                GroupTopBannerInfo groupTopBannerInfo = (GroupTopBannerInfo) obj;
                if (groupTopBannerInfo.bizType == 9 && groupTopBannerInfo.bannerType == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
            GroupTopBannerInfo groupTopBannerInfo2 = (GroupTopBannerInfo) firstOrNull;
            if (groupTopBannerInfo2 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopSecurityTipsBar", 2, "[queryGroupTopBanners] " + groupTopBannerInfo2.getNotifyBanner() + ", expireTime:" + groupTopBannerInfo2.exprieTime + ", msgId:" + groupTopBannerInfo2.msgId);
                }
                NotifyBanner notifyBanner = groupTopBannerInfo2.getNotifyBanner();
                Intrinsics.checkNotNullExpressionValue(notifyBanner, "it.getNotifyBanner()");
                long j3 = groupTopBannerInfo2.exprieTime;
                byte[] bArr = groupTopBannerInfo2.msgId;
                Intrinsics.checkNotNullExpressionValue(bArr, "it.msgId");
                this$0.K(notifyBanner, j3, bArr);
                NotifyBanner notifyBanner2 = groupTopBannerInfo2.getNotifyBanner();
                Intrinsics.checkNotNullExpressionValue(notifyBanner2, "it.getNotifyBanner()");
                this$0.p(notifyBanner2, queryGroupTopBannersRsp.seq);
            }
        }
        this$0.isRequesting = false;
    }

    private final void J() {
        boolean z16;
        if (this.beforeTopBannerToken.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                cVar = null;
            }
            cVar.g(this.beforeTopBannerToken);
            QLog.i("TroopSecurityTipsBar", 1, "[removeShowBanner] beforeTopBannerToken:" + this.beforeTopBannerToken);
        }
    }

    private final void K(NotifyBanner banner, long expireTime, byte[] msgId) {
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String str = this.curTroopUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        String str3 = banner.text;
        Intrinsics.checkNotNullExpressionValue(str3, "banner.text");
        com.tencent.mobileqq.troop.config.a.z(aVar, "troop_aio_security_banner_content_text_" + str, str3, false, 4, null);
        String str4 = this.curTroopUin;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str4 = null;
        }
        String str5 = banner.url;
        Intrinsics.checkNotNullExpressionValue(str5, "banner.url");
        com.tencent.mobileqq.troop.config.a.z(aVar, "troop_aio_security_banner_content_url_" + str4, str5, false, 4, null);
        String str6 = this.curTroopUin;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str6 = null;
        }
        com.tencent.mobileqq.troop.config.a.x(aVar, "troop_aio_security_banner_expire_time_" + str6, expireTime, false, 4, null);
        String str7 = this.curTroopUin;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
        } else {
            str2 = str7;
        }
        com.tencent.mobileqq.troop.config.a.z(aVar, "troop_aio_security_banner_msg_id_" + str2, new String(msgId, Charsets.UTF_8), false, 4, null);
    }

    private final void L(long seq) {
        com.tencent.mobileqq.troop.config.a.x(com.tencent.mobileqq.troop.config.a.f294689a, C(), seq, false, 4, null);
    }

    private final void p(final NotifyBanner banner, final long seq) {
        com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.mobileqq.troop.tipsbar.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopSecurityTipsBanner.q(seq, this, banner);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(long j3, TroopSecurityTipsBanner this$0, NotifyBanner banner) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(banner, "$banner");
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[checkToShowTopBanner] seq:" + j3 + "\uff0c showSeq:" + this$0.curShowSecurityBannerSeq + "\uff0c hasDestroy:" + this$0.hasDestroyed);
        }
        if (this$0.curShowSecurityBannerSeq != j3 && !this$0.hasDestroyed) {
            this$0.curShowSecurityBannerSeq = j3;
            this$0.J();
            com.tencent.mobileqq.aio.notification.c cVar = this$0.notificationManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                cVar = null;
            }
            this$0.beforeTopBannerToken = cVar.c(this$0.w(banner));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(long curSeq) {
        boolean z16;
        Long longOrNull;
        String str = this.curTroopUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && curSeq != 0) {
            ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class);
            String str3 = this.curTroopUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                str3 = null;
            }
            if (iTroopListRepoApi.isExit(str3, "TroopSecurityTipsBar", false)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopSecurityTipsBar", 2, "[checkTopBannerSeqUpdate] skip, isExited");
                    return;
                }
                return;
            }
            long B = B();
            if (QLog.isColorLevel()) {
                QLog.i("TroopSecurityTipsBar", 2, "[checkTopBannerSeqUpdate] curSeq:" + curSeq + ", beforeSeq:" + B);
            }
            if (curSeq > B) {
                s();
                J();
                String str4 = this.curTroopUin;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                } else {
                    str2 = str4;
                }
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
                if (longOrNull != null) {
                    G(longOrNull.longValue(), curSeq);
                    return;
                }
                return;
            }
            NotifyBanner A = A();
            if (A == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopSecurityTipsBar", 2, "[checkTopBannerSeqUpdate] show local cache");
            }
            p(A, B);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[checkTopBannerSeqUpdate] skip, curSeq:" + curSeq);
        }
    }

    private final void s() {
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String str = this.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        com.tencent.mobileqq.troop.config.a.p(aVar, "troop_aio_security_banner_content_text_" + str, false, 2, null);
        String str2 = this.curTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str2 = null;
        }
        com.tencent.mobileqq.troop.config.a.p(aVar, "troop_aio_security_banner_content_url_" + str2, false, 2, null);
        String str3 = this.curTroopUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str3 = null;
        }
        com.tencent.mobileqq.troop.config.a.p(aVar, "troop_aio_security_banner_expire_time_" + str3, false, 2, null);
        String str4 = this.curTroopUin;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str4 = null;
        }
        com.tencent.mobileqq.troop.config.a.p(aVar, "troop_aio_security_banner_msg_id_" + str4, false, 2, null);
    }

    private final void t() {
        final byte[] z16 = z();
        if (z16 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[consumeGroupTopBanner] msgId:" + z16);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.tipsbar.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopSecurityTipsBanner.u(TroopSecurityTipsBanner.this, z16);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(TroopSecurityTipsBanner this$0, byte[] msgId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgId, "$msgId");
        String str = null;
        s i3 = bg.i(null, 1, null);
        if (i3 == null) {
            return;
        }
        ConsumeGroupTopBannerReq consumeGroupTopBannerReq = new ConsumeGroupTopBannerReq();
        String str2 = this$0.curTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
        } else {
            str = str2;
        }
        consumeGroupTopBannerReq.groupId = Long.parseLong(str);
        consumeGroupTopBannerReq.bizType = 9;
        consumeGroupTopBannerReq.msgId = msgId;
        i3.consumeGroupTopBanner(consumeGroupTopBannerReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.tipsbar.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str3) {
                TroopSecurityTipsBanner.v(i16, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(int i3, String str) {
        QLog.i("TroopSecurityTipsBar", 1, "[consumeGroupTopBanner] errCode:" + i3 + ". errMsg:" + str);
    }

    private final IAIONotificationUIModel w(final NotifyBanner data) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        final int e16 = aVar.g().r().c().e();
        IO3NotifyBannerApi iO3NotifyBannerApi = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
        String str2 = data.url;
        String str3 = this.curTroopUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
        } else {
            str = str3;
        }
        iO3NotifyBannerApi.onNotifyBannerCreate(str2, str, e16);
        AIONotificationBusiId aIONotificationBusiId = AIONotificationBusiId.FRAUD;
        String str4 = data.text;
        Intrinsics.checkNotNullExpressionValue(str4, "data.text");
        return new IAIONotificationUIModel.b(aIONotificationBusiId, str4, IAIONotificationUIModel.ActionIcon.CLOSE, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>(this, e16) { // from class: com.tencent.mobileqq.troop.tipsbar.TroopSecurityTipsBanner$createUIModel$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $chatType;
            final /* synthetic */ TroopSecurityTipsBanner this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
                this.$chatType = e16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NotifyBanner.this, this, Integer.valueOf(e16));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                invoke(iAIONotificationUIModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                String str5 = null;
                if (i3 == 1) {
                    IO3NotifyBannerApi iO3NotifyBannerApi2 = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
                    String str6 = NotifyBanner.this.url;
                    String str7 = this.this$0.curTroopUin;
                    if (str7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                    } else {
                        str5 = str7;
                    }
                    iO3NotifyBannerApi2.onNotifyBannerClick(str6, str5, this.$chatType, 1);
                    this.this$0.E(NotifyBanner.this);
                    return;
                }
                if (i3 != 2) {
                    return;
                }
                IO3NotifyBannerApi iO3NotifyBannerApi3 = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
                String str8 = NotifyBanner.this.url;
                String str9 = this.this$0.curTroopUin;
                if (str9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
                } else {
                    str5 = str9;
                }
                iO3NotifyBannerApi3.onNotifyBannerClick(str8, str5, this.$chatType, 3);
                this.this$0.D();
            }
        }, 24, null);
    }

    private final void x(com.tencent.mobileqq.aio.notification.c notificationManager) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[doOnCreate]");
        }
        this.hasDestroyed = false;
        this.isRequesting = false;
        this.curShowSecurityBannerSeq = 0L;
        this.notificationManager = notificationManager;
        com.tencent.aio.api.runtime.a a16 = notificationManager.a();
        this.aioContext = a16;
        String str = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        this.curTroopUin = a16.g().r().c().j();
        s i3 = bg.i(null, 1, null);
        this.groupService = i3;
        if (i3 != null) {
            i3.D(this.groupListener);
        }
        TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
        String str2 = this.curTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
        } else {
            str = str2;
        }
        TroopInfo troopInfoFromCache = troopInfoRepo.getTroopInfoFromCache(str);
        if (troopInfoFromCache != null) {
            r(troopInfoFromCache.getTopBannerNotifySeq());
        }
    }

    private final void y() {
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[doOnDestroy]");
        }
        s sVar = this.groupService;
        if (sVar != null) {
            sVar.x0(this.groupListener);
        }
        this.groupService = null;
        this.hasDestroyed = true;
    }

    private final byte[] z() {
        boolean z16;
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String str = this.curTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curTroopUin");
            str = null;
        }
        String n3 = com.tencent.mobileqq.troop.config.a.n(aVar, "troop_aio_security_banner_msg_id_" + str, "", false, 4, null);
        if (QLog.isColorLevel()) {
            QLog.i("TroopSecurityTipsBar", 2, "[getCurBannerMsgId] msgId:" + n3);
        }
        if (n3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        byte[] bytes = n3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(AIONotificationBusiId.FRAUD);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!INSTANCE.b() || notificationManager.a().g().r().c().e() != 2) {
            return;
        }
        d.Companion companion = com.tencent.mobileqq.aio.notification.d.INSTANCE;
        if (eventType == companion.a()) {
            x(notificationManager);
        } else if (eventType == companion.c()) {
            y();
        }
    }
}
