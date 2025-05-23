package com.tencent.qqnt.pluspanel.processor.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.r;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.az;
import com.tencent.av.utils.ba;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.jungle.videohub.proto.GroupRoomManageProto$GetGameStatusByGroupCodeReq;
import com.tencent.jungle.videohub.proto.GroupRoomManageProto$GetGameStatusByGroupCodeRsp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.trooplive.api.ITroopLiveApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aj;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncRoomIDRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J>\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\nH\u0002J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J<\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH\u0002J<\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fH\u0002JN\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001dH\u0002J0\u0010!\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002J^\u0010#\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002JV\u0010$\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002JF\u0010%\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001a2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001dH\u0002J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J2\u0010.\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J \u00101\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u00102\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u00105\u001a\u0002042\u0006\u0010\u0007\u001a\u0002032\u0006\u0010\u0019\u001a\u00020\u0012J&\u0010:\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00106\u001a\u0002042\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001aJ<\u0010;\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fR\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/util/GroupVideoEntrance;", "", "Landroid/os/Bundle;", "r", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "", "uinType", "", "groupUin", "", "maps", "", "p", "troopUin", ReportConstant.COSTREPORT_PREFIX, "", "roomId", VirtualAppProxy.KEY_GAME_ID, "L", "extraInfo", "H", "G", "uin", "", "checkWifi", "checkMutex", "", "o", "relationType", "avType", UserInfo.SEX_FEMALE, "discussId", HippyTKDListViewAdapter.X, "k", "y", "B", "D", "memberNum", "isOwner", "isMemberGaged", "isAdmin", "Lcom/tencent/mobileqq/troop/troopgag/data/e;", "troopGagInfo", "u", "randomType", "randomStatus", "v", "w", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", DomainData.DOMAIN_NAME, "sessionInfo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "fromPublicClassEntry", "t", "I", "Lcom/tencent/mobileqq/intervideo/ILoginKeyHelper;", "b", "Lcom/tencent/mobileqq/intervideo/ILoginKeyHelper;", "loginHelper", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class GroupVideoEntrance {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GroupVideoEntrance f360542a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ILoginKeyHelper loginHelper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64142);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f360542a = new GroupVideoEntrance();
        }
    }

    GroupVideoEntrance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void B(QQAppInterface app, Context context) {
        String string = context.getString(R.string.dkn);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_random_talk_not_support)");
        String string2 = context.getString(R.string.dfp);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026impl.R.string.qav_notice)");
        DialogUtil.createCustomDialog(context, 230, string2, string, R.string.cancel, R.string.ddx, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.util.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupVideoEntrance.C(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
        ReportController.o(app, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void D(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("GroupVideoEntrance", 2, "enterNewGroupVideo phone is calling!");
        }
        String string = context.getString(R.string.dg9);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qav_phone_is_calling)");
        String string2 = context.getString(R.string.dfp);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026impl.R.string.qav_notice)");
        DialogUtil.createCustomDialog(context, 230, string2, string, R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.util.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupVideoEntrance.E(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
        DataReport.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        DataReport.h();
    }

    private final boolean F(QQAppInterface app, Context context, int uinType, int relationType, int avType) {
        if (relationType == 1 && app.getAVNotifyCenter().b0() && uinType == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoEntrance", 2, "check mutex of qq call and group call!");
            }
            int l3 = app.getAVNotifyCenter().l(app.getAVNotifyCenter().n());
            if (l3 != avType && l3 == 10 && avType == 2) {
                if (app.getAVNotifyCenter().j0()) {
                    QQToast.makeText(context, R.string.dbi, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                } else {
                    QQToast.makeText(context, R.string.dbk, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(QQAppInterface app, Context context, int uinType, String groupUin, Map<String, String> extraInfo) {
        Integer num;
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("startGroupVideo, uinType[");
            sb5.append(uinType);
            sb5.append("], uin[");
            sb5.append(groupUin);
            sb5.append("]");
            QLog.i("GroupVideoEntrance", 4, sb5.toString());
        }
        ((IFactoryApi) QRoute.api(IFactoryApi.class)).monitorReport("3236166");
        o(app, context, uinType, groupUin, true, true, extraInfo);
        String str = extraInfo.get("from");
        ((IFactoryApi) QRoute.api(IFactoryApi.class)).getIVPluginReportInterface().opDepartment("group_video").opName("startGroupVideo").opType(str).report();
        try {
            Long groupId = Long.valueOf(groupUin);
            String str2 = extraInfo.get("MultiAVType");
            AVNotifyCenter.i iVar = null;
            if (str2 != null) {
                num = Integer.valueOf(str2);
            } else {
                num = null;
            }
            if (num != null) {
                int intValue = num.intValue();
                AVNotifyCenter aVNotifyCenter = app.getAVNotifyCenter();
                Intrinsics.checkNotNullExpressionValue(groupId, "groupId");
                iVar = aVNotifyCenter.Q(groupId.longValue(), intValue);
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoEntrance", 2, "startGroupVideo from=" + str + " groupId=" + groupId + " avType=" + num + " roomInfo=" + iVar);
            }
            if (iVar != null && iVar.b()) {
                if (Intrinsics.areEqual("tipBar", str)) {
                    ReportController.o(app, "dc00898", "", "", "0X800ABD4", "0X800ABD4", 0, 0, "", "", "", "");
                } else if (Intrinsics.areEqual("itemBuilder", str)) {
                    ReportController.o(app, "dc00898", "", "", "0X800ABD5", "0X800ABD5", 0, 0, "", "", "", "");
                }
            }
        } catch (Exception e16) {
            QLog.e("GroupVideoEntrance", 1, "startGroupVideo education report fail.", e16);
        }
    }

    private final void H(final QQAppInterface app, final Context context, final int uinType, final String groupUin, final Map<String, String> extraInfo) {
        ((ITroopLiveApi) QRoute.api(ITroopLiveApi.class)).needJumpSyncRoom(groupUin, new Function2<Boolean, TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit>(extraInfo, app, context, uinType, groupUin) { // from class: com.tencent.qqnt.pluspanel.processor.util.GroupVideoEntrance$startGroupVideo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQAppInterface $app;
            final /* synthetic */ Context $context;
            final /* synthetic */ Map<String, String> $extraInfo;
            final /* synthetic */ String $groupUin;
            final /* synthetic */ int $uinType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$extraInfo = extraInfo;
                this.$app = app;
                this.$context = context;
                this.$uinType = uinType;
                this.$groupUin = groupUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, extraInfo, app, context, Integer.valueOf(uinType), groupUin);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopLiveSyncSvr$GetSyncRoomIDRsp troopLiveSyncSvr$GetSyncRoomIDRsp) {
                invoke(bool.booleanValue(), troopLiveSyncSvr$GetSyncRoomIDRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull TroopLiveSyncSvr$GetSyncRoomIDRsp syncRoomInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), syncRoomInfo);
                    return;
                }
                Intrinsics.checkNotNullParameter(syncRoomInfo, "syncRoomInfo");
                if (!z16) {
                    GroupVideoEntrance.f360542a.G(this.$app, this.$context, this.$uinType, this.$groupUin, this.$extraInfo);
                } else {
                    this.$extraInfo.put("openType", "enterRoom");
                    GroupVideoEntrance.f360542a.G(this.$app, this.$context, this.$uinType, String.valueOf(syncRoomInfo.group_code.get()), this.$extraInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final QQAppInterface app, final Context context, final int i3, final String groupUin, final Map map) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(groupUin, "$groupUin");
        ILoginKeyHelper iLoginKeyHelper = loginHelper;
        if (iLoginKeyHelper != null) {
            iLoginKeyHelper.getPSkey(app, "qvideo.qq.com", new ILoginKeyHelper.b() { // from class: com.tencent.qqnt.pluspanel.processor.util.c
                @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper.b
                public final void a(String str, boolean z16, int i16) {
                    GroupVideoEntrance.K(QQAppInterface.this, context, i3, groupUin, map, str, z16, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(QQAppInterface app, Context context, int i3, String groupUin, Map map, String str, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(groupUin, "$groupUin");
        f360542a.p(app, context, i3, groupUin, map);
    }

    private final void L(int uinType, long groupUin, int roomId, int gameId) {
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("startGroupVoice, uinType[");
            sb5.append(uinType);
            sb5.append("], groupUin[");
            sb5.append(groupUin);
            sb5.append("], roomId[");
            sb5.append(roomId);
            sb5.append("], gameId[");
            sb5.append(gameId);
            sb5.append("]");
            QLog.i("GroupVideoEntrance", 4, sb5.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString("roomid", String.valueOf(roomId));
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, String.valueOf(gameId));
        bundle.putString("groupUin", String.valueOf(groupUin));
        bundle.putString("uinType", String.valueOf(uinType));
        bundle.putString("fromid", "10032");
        bundle.putString(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "2");
        bundle.putString("roomtype", HippyQQConstants.HIPPY_CHANNEL);
        bundle.putString("is_record", "0");
        bundle.putString("enter_record_if_finish", "0");
        bundle.putString("first_jump_mode", "plugin");
        bundle.putString("startsrc", VipFunCallConstants.KEY_GROUP);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("mqqapi://now/openroom?");
        for (String str : bundle.keySet()) {
            sb6.append(str);
            sb6.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb6.append(bundle.getString(str));
            sb6.append(ContainerUtils.FIELD_DELIMITER);
        }
        bundle.putString("mqqScheme", sb6.toString());
        if (QLog.isDevelopLevel()) {
            QLog.i("GroupVideoEntrance", 4, bundle.toString());
        }
        AppInterface qQAppInterface = ((IDynamicNowManagerApi) QRoute.api(IDynamicNowManagerApi.class)).getQQAppInterface();
        Intrinsics.checkNotNull(qQAppInterface, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) qQAppInterface).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager");
        ((com.tencent.mobileqq.intervideo.now.dynamic.b) manager).c(bundle);
    }

    private final void k(final QQAppInterface app, final Context context, final int uinType, final String uin, final boolean checkWifi, final Map<String, String> extraInfo, final int relationType, final int avType) {
        if (QLog.isColorLevel()) {
            QLog.d("GroupVideoEntrance", 2, "enterNewGroupVideo is multi calling!");
        }
        String string = context.getString(R.string.dbj);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026audio_join_other_content)");
        int a16 = az.a(app, app.getCurrentAccountUin(), uin);
        PopupDialog.o0(context, 230, null, string, R.string.d_2, R.string.d_d, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.util.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupVideoEntrance.l(QQAppInterface.this, context, relationType, avType, uinType, uin, checkWifi, extraInfo, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.util.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GroupVideoEntrance.m(QQAppInterface.this, uin, dialogInterface, i3);
            }
        });
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a16);
        ReportController.o(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, uin, sb5.toString(), "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QQAppInterface app, Context context, int i3, int i16, int i17, String uin, boolean z16, Map map, DialogInterface dialogInterface, int i18) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        ChatActivityUtils.U(-1034L, app, context, i3, i16);
        f360542a.o(app, context, i17, uin, z16, false, map);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QQAppInterface app, String uin, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Long valueOf = Long.valueOf(uin);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(uin)");
        QAVHrMeeting.i(app, valueOf.longValue(), null);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x022c, code lost:
    
        if (r27.getAVNotifyCenter().O(java.lang.Long.parseLong(r30)) == false) goto L95;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o(QQAppInterface app, Context context, int uinType, String uin, boolean checkWifi, boolean checkMutex, Map<String, String> extraInfo) {
        int i3;
        int i16;
        long j3;
        String str;
        String str2;
        String str3;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.d("GroupVideoEntrance", 2, "enterNewGroupVideo uinType[" + uinType + "], uin[" + uin + "]");
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoEntrance", 2, "enterNewGroupVideo Activity isDestroyed!");
                return;
            }
            return;
        }
        int i18 = 0;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(context, R.string.cgc, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            ReportController.o(app, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
            return;
        }
        ReportController.o(app, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
        if (app.getAVNotifyCenter().e0() && !app.isVideoChatting()) {
            D(context);
            return;
        }
        if (!AVCoreSystemInfo.isNormalSharp()) {
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoEntrance", 2, "enterNewGroupVideo old engine!");
            }
            if (uinType == 1011) {
                B(app, context);
                return;
            }
        }
        if (!DiscussionInfo.isValidDisUin(uin) && uinType == 3000) {
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoEntrance", 2, "invalid discussId: " + uin);
                return;
            }
            return;
        }
        if (app.getAVNotifyCenter().i(context, uin)) {
            return;
        }
        long c16 = com.tencent.mobileqq.qcall.g.c(uin);
        int uinType2AVRelationType = ba.uinType2AVRelationType(uinType);
        if (extraInfo != null && uinType2AVRelationType == 1) {
            String str4 = extraInfo.get("MultiAVType");
            if (str4 != null) {
                i17 = Integer.valueOf(str4).intValue();
            } else {
                i17 = 0;
            }
            String str5 = extraInfo.get(BaseProfileQZoneComponent.KEY_IS_VIDEO);
            if (str5 != null && Intrinsics.areEqual(str5, "true")) {
                app.getAVNotifyCenter().Y0(-1034L, true);
            } else {
                app.getAVNotifyCenter().Y0(-1034L, false);
            }
            i18 = i17;
        }
        if (uinType2AVRelationType == 2) {
            i3 = 1;
        } else {
            i3 = i18;
        }
        if (app.getAVNotifyCenter().W(uinType2AVRelationType, c16) && F(app, context, uinType, uinType2AVRelationType, i3)) {
            return;
        }
        if (!app.getAVNotifyCenter().X(uinType2AVRelationType, c16, i3)) {
            if (checkWifi && !NetworkUtil.isWifiConnected(BaseApplication.getContext()) && !NetworkUtil.isBluetoothSharedNetwork(BaseApplication.getContext())) {
                y(app, context, uinType, uin, checkMutex, extraInfo);
                return;
            }
            if (checkMutex && app.isVideoChatting()) {
                i16 = i3;
                j3 = c16;
                if (x(app, context, uinType, uin, checkWifi, extraInfo, c16, uinType2AVRelationType, i16)) {
                    return;
                }
                String str6 = "0";
                if (extraInfo == null) {
                    String str7 = extraInfo.get("from");
                    String str8 = "openMiddlePage";
                    if (TextUtils.equals(str7, "Panel")) {
                        if (TextUtils.equals(extraInfo.get("publicClass"), "false")) {
                            str6 = "1";
                        } else {
                            str6 = "3690";
                        }
                    } else {
                        if (TextUtils.equals(str7, "tipBar")) {
                            str6 = "2";
                        }
                        str8 = "openRoom";
                    }
                    if (extraInfo.containsKey("openType")) {
                        str = extraInfo.get("openType");
                    } else {
                        str3 = str6;
                        str2 = str8;
                        Manager manager = app.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
                        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager");
                        ((com.tencent.mobileqq.intervideo.groupvideo.h) manager).i(context, app.getCurrentAccountUin(), uin, str3, str2, r());
                        app.getAVNotifyCenter().B0(8, j3, i16);
                    }
                } else {
                    str = null;
                }
                str3 = str6;
                str2 = str;
                Manager manager2 = app.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
                Intrinsics.checkNotNull(manager2, "null cannot be cast to non-null type com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager");
                ((com.tencent.mobileqq.intervideo.groupvideo.h) manager2).i(context, app.getCurrentAccountUin(), uin, str3, str2, r());
                app.getAVNotifyCenter().B0(8, j3, i16);
            }
        }
        i16 = i3;
        j3 = c16;
        String str62 = "0";
        if (extraInfo == null) {
        }
        str3 = str62;
        str2 = str;
        Manager manager22 = app.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
        Intrinsics.checkNotNull(manager22, "null cannot be cast to non-null type com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager");
        ((com.tencent.mobileqq.intervideo.groupvideo.h) manager22).i(context, app.getCurrentAccountUin(), uin, str3, str2, r());
        app.getAVNotifyCenter().B0(8, j3, i16);
    }

    private final void p(final QQAppInterface app, final Context context, final int uinType, final String groupUin, Map<String, String> maps) {
        final HashMap hashMap = new HashMap();
        if (maps != null) {
            hashMap.putAll(maps);
        } else {
            hashMap.put("from", QzoneWebMusicJsPlugin.EVENT_UNKOWN);
        }
        GroupRoomManageProto$GetGameStatusByGroupCodeReq groupRoomManageProto$GetGameStatusByGroupCodeReq = new GroupRoomManageProto$GetGameStatusByGroupCodeReq();
        PBUInt64Field pBUInt64Field = groupRoomManageProto$GetGameStatusByGroupCodeReq.group_code;
        Long valueOf = Long.valueOf(groupUin);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(groupUin)");
        pBUInt64Field.set(valueOf.longValue());
        IODCsChannel iODCsChannel = (IODCsChannel) QRoute.api(IODCsChannel.class);
        Long valueOf2 = Long.valueOf(groupUin);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(groupUin)");
        iODCsChannel.get(app, valueOf2.longValue()).sendOIDBRequest(93113, groupRoomManageProto$GetGameStatusByGroupCodeReq.toByteArray(), r(), new IODCsChannel.a() { // from class: com.tencent.qqnt.pluspanel.processor.util.d
            @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel.a
            public final void a(int i3, byte[] bArr, Bundle bundle) {
                GroupVideoEntrance.q(QQAppInterface.this, context, uinType, groupUin, hashMap, i3, bArr, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(QQAppInterface app, Context context, int i3, String groupUin, HashMap extraInfo, int i16, byte[] bArr, Bundle bundle) {
        String str;
        boolean z16;
        int i17;
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(groupUin, "$groupUin");
        Intrinsics.checkNotNullParameter(extraInfo, "$extraInfo");
        if (i16 == 0 && bArr != null) {
            GroupRoomManageProto$GetGameStatusByGroupCodeRsp groupRoomManageProto$GetGameStatusByGroupCodeRsp = new GroupRoomManageProto$GetGameStatusByGroupCodeRsp();
            try {
                GroupRoomManageProto$GetGameStatusByGroupCodeRsp mergeFrom = groupRoomManageProto$GetGameStatusByGroupCodeRsp.mergeFrom(bArr);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "rsp.mergeFrom(data)");
                groupRoomManageProto$GetGameStatusByGroupCodeRsp = mergeFrom;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            int i18 = 1;
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoEntrance", 2, "MSF.C.NetConnTag", " room_id=" + groupRoomManageProto$GetGameStatusByGroupCodeRsp.room_id.get() + ", app_type=" + groupRoomManageProto$GetGameStatusByGroupCodeRsp.app_type.get() + ", game_id=" + groupRoomManageProto$GetGameStatusByGroupCodeRsp.game_id.get() + ", is_group_member=" + groupRoomManageProto$GetGameStatusByGroupCodeRsp.is_group_member.get());
            }
            if (groupRoomManageProto$GetGameStatusByGroupCodeRsp.app_type.get() > 0 && groupRoomManageProto$GetGameStatusByGroupCodeRsp.is_group_member.get() == 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (Intrinsics.areEqual("Panel", extraInfo.get("from"))) {
                i17 = 1;
            } else if (Intrinsics.areEqual("tipBar", extraInfo.get("from"))) {
                i17 = 2;
            } else if (Intrinsics.areEqual("itemBuilder", extraInfo.get("from"))) {
                i17 = 3;
            } else {
                i17 = 0;
            }
            IODReportTask obj2 = ((IODReportTask) QRoute.api(IODReportTask.class)).setModule("QQ_chatroom_surface").setAction("click_entrance").obj1(i17).obj2(String.valueOf(z16));
            if (groupRoomManageProto$GetGameStatusByGroupCodeRsp.app_type.get() != 2) {
                i18 = 0;
            }
            obj2.obj3(i18).report();
            if (!z16) {
                f360542a.s(app, groupUin);
                return;
            }
            if (groupRoomManageProto$GetGameStatusByGroupCodeRsp.app_type.get() == 2) {
                GroupVideoEntrance groupVideoEntrance = f360542a;
                Long valueOf = Long.valueOf(groupUin);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(groupUin)");
                groupVideoEntrance.L(i3, valueOf.longValue(), groupRoomManageProto$GetGameStatusByGroupCodeRsp.room_id.get(), groupRoomManageProto$GetGameStatusByGroupCodeRsp.game_id.get());
                return;
            }
            f360542a.H(app, context, i3, groupUin, extraInfo);
            return;
        }
        if (bundle == null || (str = bundle.toString()) == null) {
            str = "null";
        }
        QLog.i("GroupVideoEntrance", 2, "login: errorCode=" + i16 + ", bundle=" + str + ", data=" + Arrays.toString(bArr));
        f360542a.H(app, context, i3, groupUin, extraInfo);
    }

    private final Bundle r() {
        Bundle bundle;
        ILoginKeyHelper.a accountInfo;
        ILoginKeyHelper iLoginKeyHelper = loginHelper;
        if (iLoginKeyHelper != null && (accountInfo = iLoginKeyHelper.getAccountInfo()) != null) {
            bundle = accountInfo.a();
        } else {
            bundle = null;
        }
        if (bundle == null) {
            return new Bundle();
        }
        return bundle;
    }

    private final void s(QQAppInterface app, String troopUin) {
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        Manager manager = app.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopManager troopManager = (TroopManager) manager;
        if (troopInfoFromCache == null || troopInfoFromCache.isPassiveExit()) {
            troopManager.c(troopUin);
        }
    }

    private final boolean u(long memberNum, boolean isOwner, boolean isMemberGaged, boolean isAdmin, com.tencent.mobileqq.troop.troopgag.data.e troopGagInfo) {
        if (memberNum == 0 && ((!isOwner && isMemberGaged) || (!isAdmin && troopGagInfo != null && troopGagInfo.f300239b > 0))) {
            return true;
        }
        return false;
    }

    private final boolean v(int randomType, int randomStatus, QQAppInterface app) {
        if (((randomType == 1 || randomType == 2) && randomStatus >= 1 && randomStatus <= 5) || app.getAVNotifyCenter().L() == 1 || app.getAVNotifyCenter().L() == 2) {
            return true;
        }
        return false;
    }

    private final boolean w(int randomType, int randomStatus, QQAppInterface app) {
        if (((randomType == 3 || randomType == 4) && randomStatus >= 1 && randomStatus <= 5) || app.getAVNotifyCenter().L() == 3 || app.getAVNotifyCenter().L() == 4) {
            return true;
        }
        return false;
    }

    private final boolean x(QQAppInterface app, Context context, int uinType, String uin, boolean checkWifi, Map<String, String> extraInfo, long discussId, int relationType, int avType) {
        int J = app.getAVNotifyCenter().J();
        int H = app.getAVNotifyCenter().H();
        if (v(H, J, app)) {
            QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            Long valueOf = Long.valueOf(uin);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(uin)");
            QAVHrMeeting.i(app, valueOf.longValue(), null);
            return true;
        }
        if (w(H, J, app)) {
            if (app.getAVNotifyCenter().n() == discussId && relationType != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("GroupVideoEntrance", 2, "enterNewGroupVideo-->chatUin==discussid???Why");
                }
                return true;
            }
            if (app.getAVNotifyCenter().n() > 0) {
                k(app, context, uinType, uin, checkWifi, extraInfo, relationType, avType);
                return true;
            }
            return false;
        }
        return false;
    }

    private final void y(final QQAppInterface app, final Context context, final int uinType, final String uin, final boolean checkMutex, final Map<String, String> extraInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String string;
        if (r.C0(r.f74233b + app.getCurrentAccountUin()) > 0) {
            o(app, context, uinType, uin, false, checkMutex, extraInfo);
            return;
        }
        if (NetworkUtil.isMobileNetWork(BaseApplication.getContext())) {
            str = context.getString(R.string.dfp);
            str2 = context.getString(R.string.dfl);
        } else {
            str = null;
            str2 = null;
        }
        if (NetworkUtil.is3Gor4G(BaseApplication.getContext())) {
            String string2 = context.getString(R.string.dfp);
            if (extraInfo != null && TextUtils.equals(extraInfo.get(BaseProfileQZoneComponent.KEY_IS_VIDEO), "true")) {
                string = context.getString(R.string.dfm);
            } else {
                string = context.getString(R.string.dfn);
            }
            str3 = string2;
            str4 = string;
        } else {
            str3 = str;
            str4 = str2;
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            ChatActivityUtils.a0(app, context, 230, str3, str4, R.string.d_2, R.string.d_d, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.util.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GroupVideoEntrance.z(QQAppInterface.this, context, uinType, uin, checkMutex, extraInfo, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.util.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GroupVideoEntrance.A(dialogInterface, i3);
                }
            });
        } else if (QLog.isColorLevel()) {
            QLog.e("GroupVideoEntrance", 2, "enterNewGroupVideo title or content is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QQAppInterface app, Context context, int i3, String uin, boolean z16, Map map, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        f360542a.o(app, context, i3, uin, false, z16, map);
    }

    public final void I(@NotNull final QQAppInterface app, @NotNull final Context context, final int uinType, @NotNull final String groupUin, @Nullable final Map<String, String> maps) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, app, context, Integer.valueOf(uinType), groupUin, maps);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        if (QLog.isColorLevel()) {
            QLog.d("GroupVideoEntrance", 2, "uinType = " + uinType + " groupUin = " + groupUin);
        }
        loginHelper = (ILoginKeyHelper) QRoute.api(ILoginKeyHelper.class);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.pluspanel.processor.util.b
            @Override // java.lang.Runnable
            public final void run() {
                GroupVideoEntrance.J(QQAppInterface.this, context, uinType, groupUin, maps);
            }
        }, 128, null, false);
    }

    @NotNull
    public final SessionInfo n(@NotNull com.tencent.aio.api.runtime.a context, long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SessionInfo) iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(uin));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = String.valueOf(uin);
        sessionInfo.f179559f = String.valueOf(uin);
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(context.g().r().c().e());
        sessionInfo.f179563i = context.g().r().c().g();
        return sessionInfo;
    }

    public final void t(@NotNull QQAppInterface app, @NotNull SessionInfo sessionInfo, @NotNull Activity activity, boolean fromPublicClassEntry) {
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, app, sessionInfo, activity, Boolean.valueOf(fromPublicClassEntry));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (sessionInfo.f179555d == 1) {
            try {
                String str2 = sessionInfo.f179557e;
                Intrinsics.checkNotNullExpressionValue(str2, "sessionInfo.curFriendUin");
                j3 = Long.parseLong(str2);
            } catch (NumberFormatException e16) {
                QLog.d("GroupVideoEntrance", 1, e16, new Object[0]);
                j3 = 0;
            }
            long y16 = app.getAVNotifyCenter().y(ba.uinType2AVRelationType(sessionInfo.f179555d), j3);
            Manager manager = app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopGagMgr");
            aj ajVar = (aj) manager;
            if (u(y16, ajVar.f(sessionInfo.f179557e), ajVar.e(sessionInfo.f179557e), ajVar.d(sessionInfo.f179557e), ajVar.b(sessionInfo.f179557e))) {
                QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.f172305pa3), 0).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("MultiAVType", "2");
            hashMap.put("from", "Panel");
            if (fromPublicClassEntry) {
                str = "true";
            } else {
                str = "false";
            }
            hashMap.put("publicClass", str);
            if (fromPublicClassEntry) {
                int i3 = sessionInfo.f179555d;
                String str3 = sessionInfo.f179557e;
                Intrinsics.checkNotNullExpressionValue(str3, "sessionInfo.curFriendUin");
                H(app, activity, i3, str3, hashMap);
            } else {
                int i16 = sessionInfo.f179555d;
                String str4 = sessionInfo.f179557e;
                Intrinsics.checkNotNullExpressionValue(str4, "sessionInfo.curFriendUin");
                I(app, activity, i16, str4, hashMap);
            }
            if (activity instanceof QBaseActivity) {
                ((QBaseActivity) activity).setCanLock(false);
            }
            String str5 = sessionInfo.f179557e;
            Intrinsics.checkNotNullExpressionValue(str5, "sessionInfo.curFriendUin");
            if (!app.getAVNotifyCenter().R(1, Long.parseLong(str5))) {
                String str6 = sessionInfo.f179557e;
                int j16 = TroopUtils.j(app, str6);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j16);
                ReportController.o(null, "dc00899", "Grp_video", "", UinConfigManager.KEY_ADS, "video", 0, 0, str6, sb5.toString(), "1", "");
            }
            l61.a.b(app, "0X8005CB5", sessionInfo.f179555d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(DialogInterface dialogInterface, int i3) {
    }
}
