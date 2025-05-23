package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.aio.event.AIOCenterContainerEvent;
import com.tencent.mobileqq.aio.event.TitleTabEvent;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedRefreshApi;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCnt;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import com.tencent.troopguild.report.api.ITroopGuildDtReportApi;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u00047:>B\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0015H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010,R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010,R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ej;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "troopUin", ReportConstant.COSTREPORT_PREFIX, "", "refreshUI", "y", "w", "Lcom/tencent/troopguild/api/ITroopGuildUnreadCntService;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "o", "p", DomainData.DOMAIN_NAME, "", "from", "u", "v", "Landroid/os/Bundle;", "bundle", "B", "message", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lmqq/app/AppRuntime;", "d", "Lmqq/app/AppRuntime;", "app", "e", "Z", "isFirstShow", "f", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", tl.h.F, "Ljava/lang/String;", "isTroopGuildSwitchOpen", "isTroopGuild", BdhLogUtil.LogTag.Tag_Conn, "lastNetConnected", "com/tencent/qqnt/aio/helper/ej$e", "Lcom/tencent/qqnt/aio/helper/ej$e;", "troopPushObserver", "com/tencent/qqnt/aio/helper/ej$d", "E", "Lcom/tencent/qqnt/aio/helper/ej$d;", "troopObserver", "com/tencent/qqnt/aio/helper/ej$c", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/helper/ej$c;", "mAction", "com/tencent/qqnt/aio/helper/ej$b", "G", "Lcom/tencent/qqnt/aio/helper/ej$b;", "kernelListener", "Ljava/util/Observer;", "H", "Ljava/util/Observer;", "unreadObserver", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "I", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "networkListener", "<init>", "()V", "J", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ej implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean lastNetConnected = true;

    /* renamed from: D, reason: from kotlin metadata */
    private final e troopPushObserver = new e();

    /* renamed from: E, reason: from kotlin metadata */
    private final d troopObserver = new d();

    /* renamed from: F, reason: from kotlin metadata */
    private final c mAction = new c();

    /* renamed from: G, reason: from kotlin metadata */
    private final b kernelListener = new b();

    /* renamed from: H, reason: from kotlin metadata */
    private final Observer unreadObserver = new Observer() { // from class: com.tencent.qqnt.aio.helper.eg
        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            ej.C(ej.this, observable, obj);
        }
    };

    /* renamed from: I, reason: from kotlin metadata */
    private final INetworkStateApi.a networkListener = new INetworkStateApi.a() { // from class: com.tencent.qqnt.aio.helper.eh
        @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
        public final void onNetworkConnect(boolean z16) {
            ej.t(ej.this, z16);
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AppRuntime app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helperParam;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String troopUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isTroopGuildSwitchOpen;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isTroopGuild;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ej$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            ej.this.r(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ej$d", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "", "onAdminUpdate", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends com.tencent.mobileqq.troop.api.observer.e {
        d() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onAdminUpdate(String troopCode) {
            ITroopGuildPermissionService iTroopGuildPermissionService;
            String str = ej.this.troopUin;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str = null;
            }
            if (TextUtils.equals(troopCode, str)) {
                String str3 = ej.this.troopUin;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                    str3 = null;
                }
                QLog.i("TroopGuildHelper", 1, "[onAdminUpdate] troopUin = " + str3);
                AppRuntime appRuntime = ej.this.app;
                if (appRuntime == null || (iTroopGuildPermissionService = (ITroopGuildPermissionService) appRuntime.getRuntimeService(ITroopGuildPermissionService.class, "")) == null) {
                    return;
                }
                String str4 = ej.this.troopUin;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                } else {
                    str2 = str4;
                }
                iTroopGuildPermissionService.onMuteStateChanged(str2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/helper/ej$e", "Lcom/tencent/mobileqq/troop/api/observer/f;", "", "troopUin", "", "reason", "Lcom/tencent/mobileqq/troop/api/handler/ITroopPushHandler$PushType;", "pushType", "", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends com.tencent.mobileqq.troop.api.observer.f {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(String troopUin, int reason, ITroopPushHandler.PushType pushType) {
            Intrinsics.checkNotNullParameter(pushType, "pushType");
            ej.this.A(new TitleTabEvent.SetTabVisibility(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(MsgIntent message) {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            QLog.i("TroopGuildHelper", 1, "[sendMsgIntent] fail, helperParam = null");
        } else {
            if (bVar == null || (a16 = bVar.a()) == null || (e16 = a16.e()) == null) {
                return;
            }
            e16.h(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ej this$0, Observable observable, Object obj) {
        ITroopGuildUnreadCntService q16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (obj instanceof uo4.f) {
            uo4.f fVar = (uo4.f) obj;
            String str = fVar.getUnreadCntInfo().peer.peerUid;
            String str2 = this$0.troopUin;
            String str3 = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
                String str4 = this$0.troopUin;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                    str4 = null;
                }
                if (iTroopGuildApi.isTroopGuildSwitchOpen(str4)) {
                    String str5 = this$0.troopUin;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                        str5 = null;
                    }
                    QLog.i("TroopGuildHelper", 1, "[onUpdate] troopUin = " + str5 + ", " + fVar.getUnreadCntInfo());
                    this$0.D();
                    if (fVar.getUnreadCntInfo().lastRelatedToFeedType.ordinal() <= 0 || (q16 = this$0.q()) == null) {
                        return;
                    }
                    String str6 = this$0.troopUin;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                    } else {
                        str3 = str6;
                    }
                    q16.cleanTroopGuildUnreadHighLight(str3);
                }
            }
        }
    }

    private final void D() {
        uo4.f fVar;
        IGPSService iGPSService;
        ITroopGuildUnreadCntService q16 = q();
        if (q16 != null) {
            String str = this.troopUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str = null;
            }
            fVar = q16.getUnreadCntInfo(str);
        } else {
            fVar = null;
        }
        if (fVar != null && fVar.getHasLoad()) {
            byte[] bArr = fVar.getUnreadCntInfo().headerUrl;
            Intrinsics.checkNotNullExpressionValue(bArr, "unreadCntInfo.getUnreadCntInfo().headerUrl");
            if (!(bArr.length == 0)) {
                byte[] bArr2 = fVar.getUnreadCntInfo().headerUrl;
                Intrinsics.checkNotNullExpressionValue(bArr2, "unreadCntInfo.getUnreadCntInfo().headerUrl");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
                String str2 = new String(bArr2, forName);
                try {
                    AppRuntime appRuntime = this.app;
                    String fullAvatarUrl = (appRuntime == null || (iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")) == null) ? null : iGPSService.getFullAvatarUrl(new com.tencent.mobileqq.qqguildsdk.data.cw("0", str2), 3);
                    String str3 = this.troopUin;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                        str3 = null;
                    }
                    QLog.i("TroopGuildHelper", 1, "[updateTitleTab] troopUin = " + str3 + ", headUrl: " + fullAvatarUrl);
                    A(new TitleTabEvent.TroopGuildTitleEvent(1, fullAvatarUrl));
                } catch (Exception e16) {
                    String str4 = this.troopUin;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                        str4 = null;
                    }
                    QLog.i("TroopGuildHelper", 1, "[updateTitleTab] troopUin = " + str4 + ", getFullAvatarUrl exception: " + e16.getMessage());
                }
            } else {
                A(new TitleTabEvent.TroopGuildTitleEvent(2, null));
            }
            String str5 = this.troopUin;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str5 = null;
            }
            QLog.i("TroopGuildHelper", 1, "[updateTitleTab] troopUin = " + str5 + ", atmeUnreadCnt: " + fVar.getUnreadCntInfo().atmeUnreadCnt.cnt + ", showUnreadCnt: " + fVar.getUnreadCntInfo().showUnreadCnt.cnt);
            if (fVar.getUnreadCntInfo().atmeUnreadCnt.cnt > 0) {
                A(new TitleTabEvent.TroopGuildTitleEvent(3, String.valueOf(fVar.getUnreadCntInfo().atmeUnreadCnt.cnt)));
            } else if (fVar.getUnreadCntInfo().showUnreadCnt.cnt > 0) {
                A(new TitleTabEvent.TroopGuildTitleEvent(5, null));
            } else {
                A(new TitleTabEvent.TroopGuildTitleEvent(6, null));
                A(new TitleTabEvent.TroopGuildTitleEvent(4, null));
            }
        }
    }

    private final void m() {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        Bundle l3;
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if ((bVar == null || (a16 = bVar.a()) == null || (g16 = a16.g()) == null || (l3 = g16.l()) == null) ? false : l3.getBoolean("key_is_scale_chat", false)) {
            String str = this.troopUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str = null;
            }
            QLog.i("TroopGuildHelper", 1, "dealScaleAIO: troopUin:" + str);
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity instanceof QBaseActivity) {
                FlingHandler flingHandler = GestureActivityModule.getFlingHandler((QBaseActivity) topActivity);
                if (flingHandler instanceof FlingGestureHandler) {
                    FlingGestureHandler flingGestureHandler = (FlingGestureHandler) flingHandler;
                    TopGestureLayout topGestureLayout = flingGestureHandler.mTopLayout;
                    if (topGestureLayout != null) {
                        topGestureLayout.setInterceptScrollRLFlag(false);
                        flingGestureHandler.mTopLayout.setInterceptScrollLRFlag(false);
                        return;
                    }
                    return;
                }
                QLog.i("TroopGuildHelper", 1, "dealScaleAIO. no FlingGestureHandler");
                return;
            }
            QLog.i("TroopGuildHelper", 1, "dealScaleAIO. no topActivity");
        }
    }

    private final void n() {
        ITroopGuildInfoService iTroopGuildInfoService;
        if (this.isTroopGuild) {
            ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
            String str = this.troopUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str = null;
            }
            String troopGuildId = iTroopGuildApi.getTroopGuildId(str);
            AppRuntime appRuntime = this.app;
            if (appRuntime != null && (iTroopGuildInfoService = (ITroopGuildInfoService) appRuntime.getRuntimeService(ITroopGuildInfoService.class, "")) != null) {
                iTroopGuildInfoService.onTroopGuildAioEntered(troopGuildId, this.isTroopGuildSwitchOpen);
            }
            y(false);
        }
    }

    private final void o() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        ITroopGuildInfoService iTroopGuildInfoService;
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.s groupService;
        if (this.isTroopGuild) {
            ITroopGuildUnreadCntService q16 = q();
            if (q16 != null) {
                q16.deleteUnreadCntInfoObserver(this.unreadObserver);
            }
            ITroopGuildUnreadCntService q17 = q();
            if (q17 != null) {
                String str = this.troopUin;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                    str = null;
                }
                q17.cleanTroopGuildUnreadHighLight(str);
            }
            AppRuntime appRuntime = this.app;
            if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "all")) != null && (groupService = iKernelService.getGroupService()) != null) {
                groupService.x0(this.kernelListener);
            }
            AppRuntime appRuntime2 = this.app;
            if (appRuntime2 instanceof QQAppInterface) {
                Intrinsics.checkNotNull(appRuntime2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                ((QQAppInterface) appRuntime2).removeObserver(this.troopPushObserver);
                AppRuntime appRuntime3 = this.app;
                Intrinsics.checkNotNull(appRuntime3, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                ((QQAppInterface) appRuntime3).removeObserver(this.troopObserver);
            }
            AppRuntime appRuntime4 = this.app;
            if (appRuntime4 != null && (iTroopGuildInfoService = (ITroopGuildInfoService) appRuntime4.getRuntimeService(ITroopGuildInfoService.class, "")) != null) {
                iTroopGuildInfoService.onTroopGuildAioExisted();
            }
            this.isFirstShow = false;
            this.isTroopGuild = false;
            ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(this.networkListener);
            com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
            if (bVar != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
                e16.i(this, this.mAction);
            }
            this.app = null;
            this.helperParam = null;
        }
    }

    private final void p() {
        com.tencent.aio.api.runtime.a a16;
        Fragment c16;
        FragmentActivity activity;
        Intent intent;
        if (this.isTroopGuildSwitchOpen) {
            m();
            D();
            if (!this.isFirstShow) {
                this.isFirstShow = true;
            }
            com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
            Bundle bundleExtra = (bVar == null || (a16 = bVar.a()) == null || (c16 = a16.c()) == null || (activity = c16.getActivity()) == null || (intent = activity.getIntent()) == null) ? null : intent.getBundleExtra(AppConstants.Key.TROOP_GUILD_BUNDLE);
            if (bundleExtra != null && bundleExtra.getBoolean("selectGuildContainer")) {
                bundleExtra.remove("selectGuildContainer");
                A(new TitleTabEvent.SelectFeedTab(3, false));
            }
            B(bundleExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ITroopGuildUnreadCntService q() {
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            return (ITroopGuildUnreadCntService) appRuntime.getRuntimeService(ITroopGuildUnreadCntService.class, "");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(MsgIntent i3) {
        if (i3 instanceof TitleTabEvent.GetFeedFragmentFailEvent) {
            s(((TitleTabEvent.GetFeedFragmentFailEvent) i3).a());
        } else if (i3 instanceof TitleTabEvent.OnFeedTabSelected) {
            u(((TitleTabEvent.OnFeedTabSelected) i3).a());
        } else if (i3 instanceof TitleTabEvent.OnMsgTabSelected) {
            v();
        }
    }

    private final void s(String troopUin) {
        String str = this.troopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        if (Intrinsics.areEqual(str, troopUin)) {
            y(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ej this$0, boolean z16) {
        ITroopGuildInfoService iTroopGuildInfoService;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.troopUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        QLog.i("TroopGuildHelper", 1, "networkChange: " + z16 + " troopUin:" + str);
        if (z16 != this$0.lastNetConnected && z16) {
            String str3 = this$0.troopUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            } else {
                str2 = str3;
            }
            QLog.i("TroopGuildHelper", 1, "onReconnect: " + str2);
            AppRuntime appRuntime = this$0.app;
            if (appRuntime != null && (iTroopGuildInfoService = (ITroopGuildInfoService) appRuntime.getRuntimeService(ITroopGuildInfoService.class, "")) != null) {
                iTroopGuildInfoService.onReconnect();
            }
        }
        this$0.lastNetConnected = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(int from) {
        UnreadCntInfo unreadCntInfo;
        boolean z16;
        int i3;
        ITroopGuildUnreadCntService q16;
        UnreadCnt unreadCnt;
        UnreadCnt unreadCnt2;
        ITroopGuildUnreadCntService q17 = q();
        String str = null;
        if (q17 != null) {
            String str2 = this.troopUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str2 = null;
            }
            uo4.f unreadCntInfo2 = q17.getUnreadCntInfo(str2);
            if (unreadCntInfo2 != null) {
                unreadCntInfo = unreadCntInfo2.getUnreadCntInfo();
                z16 = from != 2;
                i3 = (unreadCntInfo != null || (unreadCnt2 = unreadCntInfo.atmeUnreadCnt) == null) ? 0 : unreadCnt2.cnt;
                int i16 = (unreadCntInfo != null || (unreadCnt = unreadCntInfo.showUnreadCnt) == null) ? 0 : unreadCnt.cnt;
                if (i3 > 0 && i16 <= 0) {
                    ((IGuildFeedRefreshApi) QRoute.api(IGuildFeedRefreshApi.class)).doFeedTroopRefresh(false, z16);
                } else {
                    ((IGuildFeedRefreshApi) QRoute.api(IGuildFeedRefreshApi.class)).doFeedTroopRefresh(true, z16);
                }
                q16 = q();
                if (q16 != null) {
                    String str3 = this.troopUin;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                    } else {
                        str = str3;
                    }
                    q16.setTroopGuildMsgRead(str, GuildGroupSceneType.KFEEDBASE, false);
                }
                ((IGuildFeedContainerLifeCycleApi) QRoute.api(IGuildFeedContainerLifeCycleApi.class)).onSelectFeed();
            }
        }
        unreadCntInfo = null;
        if (from != 2) {
        }
        if (unreadCntInfo != null) {
        }
        if (unreadCntInfo != null) {
        }
        if (i3 > 0) {
        }
        ((IGuildFeedRefreshApi) QRoute.api(IGuildFeedRefreshApi.class)).doFeedTroopRefresh(true, z16);
        q16 = q();
        if (q16 != null) {
        }
        ((IGuildFeedContainerLifeCycleApi) QRoute.api(IGuildFeedContainerLifeCycleApi.class)).onSelectFeed();
    }

    private final void v() {
        ((IGuildFeedContainerLifeCycleApi) QRoute.api(IGuildFeedContainerLifeCycleApi.class)).onUnSelectFeed();
    }

    private final void w(final boolean refreshUI) {
        ITroopGuildInfoService iTroopGuildInfoService;
        IGPSService iGPSService;
        ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
        String str = this.troopUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        String troopGuildId = iTroopGuildApi.getTroopGuildId(str);
        if (TextUtils.isEmpty(troopGuildId)) {
            return;
        }
        try {
            AppRuntime appRuntime = this.app;
            boolean z16 = ((appRuntime == null || (iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")) == null) ? null : iGPSService.getGuildInfo(troopGuildId)) == null;
            AppRuntime appRuntime2 = this.app;
            if (appRuntime2 == null || (iTroopGuildInfoService = (ITroopGuildInfoService) appRuntime2.getRuntimeService(ITroopGuildInfoService.class, "")) == null) {
                return;
            }
            iTroopGuildInfoService.fetchGuildInfo(troopGuildId, z16, new vh2.v() { // from class: com.tencent.qqnt.aio.helper.ei
                @Override // vh2.v
                public final void a(int i3, String str3, IGProGuildInfo iGProGuildInfo) {
                    ej.x(ej.this, refreshUI, i3, str3, iGProGuildInfo);
                }
            });
        } catch (Exception e16) {
            String str3 = this.troopUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            } else {
                str2 = str3;
            }
            QLog.i("TroopGuildHelper", 1, "[refreshGuildInfo] troopUin = " + str2 + ", exception: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ej this$0, boolean z16, int i3, String str, IGProGuildInfo iGProGuildInfo) {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = this$0.troopUin;
        String str3 = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str2 = null;
        }
        QLog.i("TroopGuildHelper", 1, "[refreshGuildInfo] troopUin = " + str2 + ", result: " + i3 + ", errMsg: " + str + ", refreshUI: " + z16);
        if (!z16 || iGProGuildInfo == null) {
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = this$0.helperParam;
        com.tencent.mvi.base.route.k k3 = (bVar == null || (a16 = bVar.a()) == null || (e16 = a16.e()) == null) ? null : e16.k(TitleTabEvent.GetTitleTabStatusEvent.f188716d);
        if ((k3 instanceof m.g) && ((m.g) k3).a()) {
            IGuildTroopApi iGuildTroopApi = (IGuildTroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildTroopApi.class);
            String str4 = this$0.troopUin;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            } else {
                str3 = str4;
            }
            Fragment feedFragment = iGuildTroopApi.getFeedFragment(str3);
            if (feedFragment != null) {
                this$0.A(new AIOCenterContainerEvent.ShowFragment(feedFragment, false));
            }
        }
    }

    private final void y(final boolean refreshUI) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ef
            @Override // java.lang.Runnable
            public final void run() {
                ej.z(ej.this, refreshUI);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ej this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w(z16);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350638h0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.GetFeedFragmentFailEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.OnFeedTabSelected");
        hashSet.add("com.tencent.mobileqq.aio.event.TitleTabEvent.OnMsgTabSelected");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopGuildHelper";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    @Override // com.tencent.aio.main.businesshelper.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        boolean z16;
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.s groupService;
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(param, "param");
        this.helperParam = param;
        this.troopUin = param.a().g().r().c().j();
        ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
        String str = this.troopUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        boolean isTroopGuild = iTroopGuildApi.isTroopGuild(str);
        this.isTroopGuild = isTroopGuild;
        if (isTroopGuild) {
            ITroopGuildApi iTroopGuildApi2 = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
            String str3 = this.troopUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                str3 = null;
            }
            if (iTroopGuildApi2.isTroopGuildSwitchOpen(str3)) {
                z16 = true;
                this.isTroopGuildSwitchOpen = z16;
                if (this.isTroopGuild) {
                    return;
                }
                this.app = MobileQQ.sMobileQQ.peekAppRuntime();
                ITroopGuildUnreadCntService q16 = q();
                if (q16 != null) {
                    String str4 = this.troopUin;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                        str4 = null;
                    }
                    q16.cleanTroopGuildUnreadHighLight(str4);
                }
                this.lastNetConnected = ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).isNetworkAvailable();
                ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(this.networkListener);
                if (this.isTroopGuildSwitchOpen) {
                    ITroopGuildUnreadCntService q17 = q();
                    if (q17 != null) {
                        q17.addUnreadCntInfoObserver(this.unreadObserver);
                    }
                    com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
                    if (bVar != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
                        e16.f(this, this.mAction);
                    }
                    try {
                        AppRuntime appRuntime = this.app;
                        if (appRuntime != null && (iKernelService = (IKernelService) appRuntime.getRuntimeService(IKernelService.class, "all")) != null && (groupService = iKernelService.getGroupService()) != null) {
                            groupService.D(this.kernelListener);
                            String str5 = this.troopUin;
                            if (str5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                                str5 = null;
                            }
                            groupService.getGroupDetailInfo(Long.parseLong(str5), GroupInfoSource.KAIO, null);
                        }
                    } catch (Exception e17) {
                        String str6 = this.troopUin;
                        if (str6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                        } else {
                            str2 = str6;
                        }
                        QLog.e("TroopGuildHelper", 1, "[onCreate] troopUin = " + str2 + ", getGroupDetail exception: " + e17.getMessage());
                    }
                    AppRuntime appRuntime2 = this.app;
                    if (appRuntime2 instanceof QQAppInterface) {
                        Intrinsics.checkNotNull(appRuntime2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                        ((QQAppInterface) appRuntime2).addObserver(this.troopPushObserver);
                        AppRuntime appRuntime3 = this.app;
                        Intrinsics.checkNotNull(appRuntime3, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                        ((QQAppInterface) appRuntime3).addObserver(this.troopObserver);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        z16 = false;
        this.isTroopGuildSwitchOpen = z16;
        if (this.isTroopGuild) {
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ej$b", "Lcom/tencent/qqnt/aio/helper/bi;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "", "onGroupDetailInfoChange", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends bi {
        b() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupDetailInfoChange(GroupDetailInfo groupDetail) {
            ITroopGuildUnreadCntService q16;
            if (groupDetail != null) {
                String valueOf = String.valueOf(groupDetail.groupCode);
                String str = ej.this.troopUin;
                String str2 = null;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                    str = null;
                }
                if (TextUtils.equals(valueOf, str) && groupDetail.cmdUinMsgMask == GroupMsgMask.SHIELD && (q16 = ej.this.q()) != null) {
                    String str3 = ej.this.troopUin;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopUin");
                    } else {
                        str2 = str3;
                    }
                    q16.fetchUnreadCntInfo(str2);
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 12, 0};
    }

    private final void B(Bundle bundle) {
        boolean z16 = false;
        if (bundle != null && bundle.getInt("key_source_from", 0) == 2) {
            z16 = true;
        }
        if (!z16 || bundle.getBoolean("key_launched")) {
            return;
        }
        bundle.putBoolean("key_launched", true);
        QLog.i("TroopGuildHelper", 1, "[tryLaunchTroopFeedNoticeActivity] ");
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar != null) {
            IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
            Context requireContext = bVar.a().c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "it.aioContext.fragment.requireContext()");
            String string = bundle.getString("key_guild_id", "");
            Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(GuildFe\u2026unchKey.KEY_GUILD_ID, \"\")");
            String string2 = bundle.getString("key_channel_id", "");
            Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(GuildFe\u2026chKey.KEY_CHANNEL_ID, \"\")");
            String string3 = bundle.getString("key_troop_id", "");
            Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(GuildFe\u2026unchKey.KEY_TROOP_ID, \"\")");
            iGuildFeedLauncherApi.launchTroopFeedNoticeActivity(requireContext, string, string2, string3, 2);
        }
        Serializable serializable = bundle.getSerializable("PushMsgreportData");
        if (serializable instanceof ITroopGuildMsgApi.MsgPushInfo) {
            ((ITroopGuildDtReportApi) QRoute.api(ITroopGuildDtReportApi.class)).reportMsgPushClick((ITroopGuildMsgApi.MsgPushInfo) serializable);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            n();
        } else if (state == 3) {
            p();
        } else {
            if (state != 12) {
                return;
            }
            o();
        }
    }
}
