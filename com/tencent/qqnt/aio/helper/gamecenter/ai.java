package com.tencent.qqnt.aio.helper.gamecenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.nt.aio.top.GameMsgTopBarEvent;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterLimit$CheckLimitReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterLimit$CheckLimitRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterLimit$ReportReq;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bd\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001c\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001nB\u0007\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 H\u0016J\u000e\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 J\u0018\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u000b0&j\b\u0012\u0004\u0012\u00020\u000b`'H\u0016J.\u0010/\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020,2\b\u0010\u0011\u001a\u0004\u0018\u00010.H\u0016R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010D\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010ER\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010HR\u0016\u0010L\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010Z\u001a\n X*\u0004\u0018\u00010W0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010YR&\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u000b0&j\b\u0012\u0004\u0012\u00020\u000b`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010KR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010i\u00a8\u0006o"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/ai;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "v", "Lcom/tencent/mobileqq/app/QQAppInterface;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "D", "", "uin", "", HippyTKDListViewAdapter.X, "o", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/GameCenterLimit$CheckLimitRsp;", "rsp", "r", "B", "operId", "actionType", BdhLogUtil.LogTag.Tag_Conn, "p", "", "data", "t", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "onCreate", "", "interestedIn", "", "getId", "getTag", "state", "onMoveToState", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getFilterCmds", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "onTrpcRsp", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/app/Activity;", "e", "Landroid/app/Activity;", "mActivity", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "linearLayout", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "startGameTv", "i", "addFriendTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mHashCode", "Lcom/tencent/aio/main/businesshelper/b;", "helpParam", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "mGameSession", "E", "Ljava/lang/String;", "mPeerUid", UserInfo.SEX_FEMALE, "mPeerUin", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "G", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "mGameMsgManager", "Lgd1/a;", "H", "Lgd1/a;", "mFriendGameInfo", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "J", "Ljava/util/HashSet;", "cmdMap", "K", "Z", "isDestroy", "L", "mZoneUrl", "com/tencent/qqnt/aio/helper/gamecenter/ai$c", "M", "Lcom/tencent/qqnt/aio/helper/gamecenter/ai$c;", "mSsoObserver", "Lcom/tencent/mobileqq/app/ar;", "N", "Lcom/tencent/mobileqq/app/ar;", "friendListObserver", "<init>", "()V", "P", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ai implements com.tencent.aio.main.businesshelper.h, WadlTrpcListener {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helpParam;

    /* renamed from: D, reason: from kotlin metadata */
    private TempChatGameSession mGameSession;

    /* renamed from: G, reason: from kotlin metadata */
    private IGameMsgManagerService mGameMsgManager;

    /* renamed from: H, reason: from kotlin metadata */
    private gd1.a mFriendGameInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: L, reason: from kotlin metadata */
    private String mZoneUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Activity mActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout linearLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView startGameTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView addFriendTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mHashCode = hashCode();

    /* renamed from: E, reason: from kotlin metadata */
    private String mPeerUid = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String mPeerUin = "";

    /* renamed from: I, reason: from kotlin metadata */
    private final Resources resources = MobileQQ.sMobileQQ.getResources();

    /* renamed from: J, reason: from kotlin metadata */
    private HashSet<String> cmdMap = new HashSet<>();

    /* renamed from: M, reason: from kotlin metadata */
    private final c mSsoObserver = new c(this.mHashCode);

    /* renamed from: N, reason: from kotlin metadata */
    private final ar friendListObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/ai$b", "Lcom/tencent/mobileqq/app/ar;", "", "addUin", "", "onAddFriend", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends ar {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onAddFriend(String addUin) {
            Intrinsics.checkNotNullParameter(addUin, "addUin");
            QLog.i("GameMsgTopBarHelper", 2, "[onAddFriend] addUin:" + addUin + "  mPeerUid:" + ai.this.mPeerUid);
            if (Intrinsics.areEqual(ai.this.mPeerUin, addUin)) {
                ai.this.u();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/ai$c", "Lie1/b;", "", "detailInfos", "", "d", "data", ReportConstant.COSTREPORT_PREFIX, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends ie1.b {
        c(int i3) {
            super(i3);
        }

        @Override // ie1.b
        public void d(Object detailInfos) {
            QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "[onGameUsrInfoChangedNotify]");
            try {
                if (detailInfos instanceof ArrayList) {
                    Iterator it = ((ArrayList) detailInfos).iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof gd1.a) && !TextUtils.isEmpty(((gd1.a) next).f401937a)) {
                            String str = ((gd1.a) next).f401937a;
                            TempChatGameSession tempChatGameSession = ai.this.mGameSession;
                            if (tempChatGameSession == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                                tempChatGameSession = null;
                            }
                            if (Intrinsics.areEqual(str, tempChatGameSession.peerRoleId)) {
                                ai.this.mFriendGameInfo = (gd1.a) next;
                                ai aiVar = ai.this;
                                gd1.a aVar = aiVar.mFriendGameInfo;
                                Intrinsics.checkNotNull(aVar);
                                String str2 = aVar.f401938b;
                                Intrinsics.checkNotNullExpressionValue(str2, "mFriendGameInfo!!.mUin");
                                aiVar.mPeerUin = str2;
                                QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "onGameUsrInfoChangedNotify update friend info mPeerUin=" + ai.this.mPeerUin);
                                ai.this.A();
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e("GameCenterMsg.GameCenterUnissoObserver", 1, th5.getMessage());
            }
        }

        @Override // ie1.b
        public void s(Object data) {
            ai.this.t(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        QLog.d("GameMsgTopBarHelper", 2, "optShowBar peerUin=" + this.mPeerUin);
        if (this.isDestroy || TextUtils.isEmpty(this.mPeerUin)) {
            return;
        }
        if (x(this.mPeerUin)) {
            QLog.d("GameMsgTopBarHelper", 2, "optShowBar peerUin " + this.mPeerUin + " is Friend");
            return;
        }
        if (this.linearLayout != null) {
            QLog.w("GameMsgTopBarHelper", 2, "optShowBar linearLayout is not null");
            return;
        }
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
        QQAppInterface q16 = q();
        if (q16 != null) {
            q16.addObserver(this.friendListObserver);
        }
        v();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(40.0f, this.resources));
        layoutParams.addRule(10);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        LinearLayout linearLayout = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        e16.h(new GameMsgTopBarEvent.AddTopView(0, linearLayout, layoutParams));
        C("929275", "8");
        C("929277", "8");
    }

    private final void B() {
        TempChatGameSession tempChatGameSession = this.mGameSession;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        String str = tempChatGameSession.selfOpenId;
        TempChatGameSession tempChatGameSession2 = this.mGameSession;
        if (tempChatGameSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession2 = null;
        }
        String str2 = str + "_" + tempChatGameSession2.peerOpenId;
        QLog.i("GameMsgTopBarHelper", 1, "[reportCheckAddFriend] gid=" + str2);
        GameCenterLimit$ReportReq gameCenterLimit$ReportReq = new GameCenterLimit$ReportReq();
        gameCenterLimit$ReportReq.gid.set(str2);
        gameCenterLimit$ReportReq.strategy_id.set(1029);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(WadlProxyConsts.CMD_REPORT_ADD_FRIEND, false, gameCenterLimit$ReportReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
    }

    private final void C(String operId, String actionType) {
        new WadlReportBuilder().setBussinessId("1").setPage(WadlProxyConsts.PAGE_ID_DOWNLOAD).setOperModule("920").setModuleType("92051").setOperId(operId).setOpertype(actionType).report();
    }

    private final void D() {
        IGameMsgBoxManager iGameMsgBoxManager;
        String str;
        Activity activity;
        try {
            TempChatGameSession tempChatGameSession = this.mGameSession;
            TempChatGameSession tempChatGameSession2 = null;
            if (tempChatGameSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession = null;
            }
            String str2 = tempChatGameSession.peerOpenId;
            TempChatGameSession tempChatGameSession3 = this.mGameSession;
            if (tempChatGameSession3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession3 = null;
            }
            QLog.i("GameMsgTopBarHelper", 2, "[startAddFriend] peerOpenId=" + str2 + ", gameAppId=" + tempChatGameSession3.gameAppId);
            QQAppInterface q16 = q();
            if (q16 == null || (iGameMsgBoxManager = (IGameMsgBoxManager) q16.getRuntimeService(IGameMsgBoxManager.class, "")) == null) {
                return;
            }
            gd1.a aVar = this.mFriendGameInfo;
            String str3 = aVar != null ? aVar.f401941e : null;
            if (str3 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "mFriendGameInfo?.mNickInGame ?: \"\"");
                str = str3;
            }
            Activity activity2 = this.mActivity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity = null;
            } else {
                activity = activity2;
            }
            TempChatGameSession tempChatGameSession4 = this.mGameSession;
            if (tempChatGameSession4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession4 = null;
            }
            String str4 = tempChatGameSession4.peerOpenId;
            TempChatGameSession tempChatGameSession5 = this.mGameSession;
            if (tempChatGameSession5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            } else {
                tempChatGameSession2 = tempChatGameSession5;
            }
            iGameMsgBoxManager.startAddFriend(activity, str4, String.valueOf(tempChatGameSession2.gameAppId), str, "");
            B();
        } catch (Throwable th5) {
            QLog.e("GameMsgTopBarHelper", 1, th5, new Object[0]);
        }
    }

    private final void o() {
        TempChatGameSession tempChatGameSession = this.mGameSession;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        if (TextUtils.isEmpty(tempChatGameSession.peerOpenId)) {
            QLog.w("GameMsgTopBarHelper", 1, "[checkAddFriendLimit] peerOpenId is empty");
            return;
        }
        TempChatGameSession tempChatGameSession2 = this.mGameSession;
        if (tempChatGameSession2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession2 = null;
        }
        String str = tempChatGameSession2.selfOpenId;
        TempChatGameSession tempChatGameSession3 = this.mGameSession;
        if (tempChatGameSession3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession3 = null;
        }
        String str2 = str + "_" + tempChatGameSession3.peerOpenId;
        QLog.d("GameMsgTopBarHelper", 1, "[checkAddFriendLimit] mPeerUid=" + this.mPeerUid + " gid=" + str2);
        GameCenterLimit$CheckLimitReq gameCenterLimit$CheckLimitReq = new GameCenterLimit$CheckLimitReq();
        gameCenterLimit$CheckLimitReq.gid.set(str2);
        gameCenterLimit$CheckLimitReq.strategy_id.set(1029);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(WadlProxyConsts.CMD_CHECK_ADD_FRIEND_LIMIT, false, gameCenterLimit$CheckLimitReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
        C("929275", "20");
    }

    private final QQAppInterface q() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void r(GameCenterLimit$CheckLimitRsp rsp) {
        if (this.isDestroy) {
            return;
        }
        boolean z16 = rsp.is_limit.get();
        QLog.i("GameMsgTopBarHelper", 1, "[handleCheckAddFriendLimit] mPeerUid=" + this.mPeerUid + " isLimit=" + z16);
        if (z16) {
            com.tencent.aio.main.businesshelper.b bVar = this.helpParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helpParam");
                bVar = null;
            }
            final FragmentActivity activity = bVar.a().c().getActivity();
            if (activity != null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        ai.s(FragmentActivity.this);
                    }
                });
                return;
            }
            return;
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(FragmentActivity it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        QQToast.makeText(it, 1, HardCodeUtil.qqStr(R.string.f209845gi), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(Object data) {
        try {
            QLog.i("GameMsgAIOHelper", 1, "[handleGetZoneUrl], data:" + data);
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
            this.mZoneUrl = (String) data;
        } catch (Throwable th5) {
            QLog.w("GameMsgAIOHelper", 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        QLog.d("GameMsgTopBarHelper", 2, "hideBar linearLayout=" + this.linearLayout);
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().h(new GameMsgTopBarEvent.RemoveTopView(linearLayout));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ai this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view.getTag();
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 1) {
                this$0.y();
            } else {
                if (intValue != 2) {
                    return;
                }
                this$0.o();
            }
        }
    }

    private final boolean x(String uin) {
        QQAppInterface q16 = q();
        IFriendDataService iFriendDataService = q16 != null ? (IFriendDataService) q16.getRuntimeService(IFriendDataService.class, "all") : null;
        if (iFriendDataService != null) {
            return iFriendDataService.isFriend(uin);
        }
        return false;
    }

    private final void y() {
        QLog.i("GameMsgTopBarHelper", 1, "[launchGame] mFriendGameInfo=" + this.mFriendGameInfo);
        IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        iGameMsgHelperApi.startGame(activity, this.mZoneUrl, this.mFriendGameInfo);
        C("929278", "20");
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return this.cmdMap;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350617a0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameMsgTopBarHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b helperParam) {
        IGameMsgManagerService iGameMsgManagerService;
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        this.helpParam = helperParam;
        this.cmdMap.add(WadlProxyConsts.CMD_CHECK_ADD_FRIEND_LIMIT);
        this.cmdMap.add(WadlProxyConsts.CMD_REPORT_ADD_FRIEND);
        com.tencent.aio.api.runtime.a a16 = helperParam.a();
        this.mAIOContext = a16;
        IGameMsgManagerService iGameMsgManagerService2 = null;
        iGameMsgManagerService2 = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        FragmentActivity requireActivity = a16.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mAIOContext.fragment.requireActivity()");
        this.mActivity = requireActivity;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        String str = "";
        String string = l3.getString("key_peerId", "");
        Intrinsics.checkNotNullExpressionValue(string, "mCustomParam.getString(C\u2026Constants.KEY_PEERID, \"\")");
        this.mPeerUid = string;
        this.mGameSession = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUidOrJson(this.mPeerUid, l3.getString(AppConstants.Key.KEY_GAME_MSG_SESSION, ""));
        QQAppInterface q16 = q();
        if (q16 != null && (iGameMsgManagerService = (IGameMsgManagerService) q16.getRuntimeService(IGameMsgManagerService.class, "")) != null) {
            iGameMsgManagerService.addUserInfoChangedObserver(this.mSsoObserver);
            TempChatGameSession tempChatGameSession = this.mGameSession;
            if (tempChatGameSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
                tempChatGameSession = null;
            }
            gd1.a singleGameDetail = iGameMsgManagerService.getSingleGameDetail(tempChatGameSession.peerRoleId);
            this.mFriendGameInfo = singleGameDetail;
            String str2 = singleGameDetail != null ? singleGameDetail.f401938b : null;
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "mFriendGameInfo?.mUin ?: \"\"");
                str = str2;
            }
            this.mPeerUin = str;
            iGameMsgManagerService2 = iGameMsgManagerService;
        }
        this.mGameMsgManager = iGameMsgManagerService2;
        QLog.i("GameMsgTopBarHelper", 1, "onCreate mPeerUid=" + this.mPeerUid + " mPeerUin=" + this.mPeerUin);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgTopBarHelper", 2, "[onMoveToState] state:" + state);
        }
        if (state == 12) {
            p();
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        PBBytesField pBBytesField;
        if (rsp != null) {
            QLog.d("GameMsgTopBarHelper", 1, "[onTrpcRsp] cmd=" + cmd + ",ret=" + ret + ",trpcRspRetCode=" + rsp.ret.get() + " msg=" + rsp.f106731msg.get());
        } else {
            QLog.d("GameMsgTopBarHelper", 1, "[onTrpcRsp] cmd=" + cmd + ",ret=" + ret + " rsp is null");
        }
        if (Intrinsics.areEqual(WadlProxyConsts.CMD_CHECK_ADD_FRIEND_LIMIT, cmd) && ret == 0) {
            if (((rsp == null || (pBBytesField = rsp.data) == null) ? null : pBBytesField.get()) != null) {
                GameCenterLimit$CheckLimitRsp gameCenterLimit$CheckLimitRsp = new GameCenterLimit$CheckLimitRsp();
                try {
                    gameCenterLimit$CheckLimitRsp.mergeFrom(rsp.data.get().toByteArray());
                    r(gameCenterLimit$CheckLimitRsp);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("GameMsgTopBarHelper", 1, "[onTrpcRsp] exception", e16);
                }
            }
        }
    }

    private final void p() {
        this.isDestroy = true;
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
        IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
        if (iGameMsgManagerService != null) {
            iGameMsgManagerService.removeUserInfoChangedObserver(this.mSsoObserver);
        }
        QQAppInterface q16 = q();
        if (q16 != null) {
            q16.removeObserver(this.friendListObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    private final void v() {
        TextView textView;
        QLog.d("GameMsgTopBarHelper", 2, "initView");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ai.w(ai.this, view);
            }
        };
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        LinearLayout linearLayout = new LinearLayout(activity);
        this.linearLayout = linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setId(R.id.f164244ob);
        LinearLayout linearLayout2 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setOrientation(0);
        LinearLayout linearLayout3 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.setGravity(16);
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity2 = null;
        }
        TextView textView2 = new TextView(activity2);
        this.startGameTv = textView2;
        textView2.setBackgroundResource(R.drawable.qui_common_bg_primary_bg);
        TextView textView3 = this.startGameTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView3 = null;
        }
        textView3.setText(HardCodeUtil.qqStr(R.string.f209875gl));
        TextView textView4 = this.startGameTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView4 = null;
        }
        textView4.setGravity(17);
        TextView textView5 = this.startGameTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView5 = null;
        }
        textView5.setTextSize(0, this.resources.getDimension(R.dimen.f158274c0));
        TextView textView6 = this.startGameTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView6 = null;
        }
        TextView textView7 = this.startGameTv;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView7 = null;
        }
        textView6.setContentDescription(textView7.getText());
        TextView textView8 = this.startGameTv;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView8 = null;
        }
        textView8.setOnClickListener(onClickListener);
        TextView textView9 = this.startGameTv;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView9 = null;
        }
        textView9.setTag(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Activity activity3 = this.mActivity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity3 = null;
        }
        View view = new View(activity3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, BaseAIOUtils.f(15.0f, this.resources));
        Activity activity4 = this.mActivity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity4 = null;
        }
        DrawableCenterTextView drawableCenterTextView = new DrawableCenterTextView(activity4);
        this.addFriendTv = drawableCenterTextView;
        drawableCenterTextView.setBackgroundResource(R.drawable.qui_common_bg_primary_bg);
        TextView textView10 = this.addFriendTv;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView10 = null;
        }
        textView10.setText(HardCodeUtil.qqStr(R.string.f170193ik));
        TextView textView11 = this.addFriendTv;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView11 = null;
        }
        textView11.setTextSize(0, this.resources.getDimension(R.dimen.f158274c0));
        TextView textView12 = this.addFriendTv;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView12 = null;
        }
        textView12.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qui_add_friend, 0, 0, 0);
        TextView textView13 = this.addFriendTv;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView13 = null;
        }
        textView13.setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, this.resources));
        TextView textView14 = this.addFriendTv;
        if (textView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView14 = null;
        }
        TextView textView15 = this.addFriendTv;
        if (textView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView15 = null;
        }
        textView14.setContentDescription(textView15.getText());
        TextView textView16 = this.addFriendTv;
        if (textView16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView16 = null;
        }
        textView16.setOnClickListener(onClickListener);
        TextView textView17 = this.addFriendTv;
        if (textView17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView17 = null;
        }
        textView17.setTag(2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        if (ThemeUtil.isDefaultTheme()) {
            view.setBackgroundColor(Color.parseColor("#D9D9D9"));
            LinearLayout linearLayout4 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout4);
            linearLayout4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            TextView textView18 = this.startGameTv;
            if (textView18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
                textView18 = null;
            }
            textView18.setTextColor(this.resources.getColorStateList(R.color.afd));
            TextView textView19 = this.addFriendTv;
            if (textView19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
                textView19 = null;
            }
            Activity activity5 = this.mActivity;
            if (activity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity5 = null;
            }
            textView19.setTextColor(activity5.getResources().getColorStateList(R.color.afd));
        } else {
            view.setBackgroundColor(Color.parseColor("#CDCDCD"));
            LinearLayout linearLayout5 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout5);
            linearLayout5.setBackgroundColor(Color.parseColor("#000000"));
            TextView textView20 = this.startGameTv;
            if (textView20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
                textView20 = null;
            }
            textView20.setTextColor(this.resources.getColorStateList(R.color.skin_float_btn));
            TextView textView21 = this.addFriendTv;
            if (textView21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
                textView21 = null;
            }
            Activity activity6 = this.mActivity;
            if (activity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity6 = null;
            }
            textView21.setTextColor(activity6.getResources().getColorStateList(R.color.skin_float_btn));
        }
        LinearLayout linearLayout6 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout6);
        TextView textView22 = this.startGameTv;
        if (textView22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGameTv");
            textView22 = null;
        }
        linearLayout6.addView(textView22, layoutParams);
        LinearLayout linearLayout7 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout7);
        linearLayout7.addView(view, layoutParams2);
        LinearLayout linearLayout8 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout8);
        TextView textView23 = this.addFriendTv;
        if (textView23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
            textView = null;
        } else {
            textView = textView23;
        }
        linearLayout8.addView(textView, layoutParams3);
    }

    public final void z(int state) {
        if (state == 2) {
            A();
        }
    }
}
