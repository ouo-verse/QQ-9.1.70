package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.AIOTopTipEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.troop.shortcutbar.adapter.TroopShortcutBarEvent;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.utils.RelationDialogUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$BlockRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CountBlockListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001R\b\u0007\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u0018\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\rH\u0016J\u0006\u0010+\u001a\u00020\u0006J\u0018\u0010,\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ \u0010.\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\rJ\u0010\u00102\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0018\u00103\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u00104\u001a\u00020\u0006J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u0006\u00107\u001a\u00020\u000bR\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010NR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010=R\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010SR$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010c\u001a\u00020]8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010f\u001a\u00020]8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bd\u0010^\u001a\u0004\bd\u0010`\"\u0004\be\u0010bR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010hR\u0016\u0010k\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010=R\u0014\u0010n\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010m\u00a8\u0006s"}, d2 = {"Lcom/tencent/qqnt/aio/helper/AddFriendNtHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "J", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "L", "", "isSingleWayFriend", "", "uin", "s0", "isBlacklist", "needReport", "o0", "W", "G", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "needTransferButton", "X", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N", BdhLogUtil.LogTag.Tag_Conn, "i0", "f0", "addUin", "O", "", "getId", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "", "interestedIn", "getTag", "d0", "l0", "y", "b0", "type", "option", "P", "E", BdhLogUtil.LogTag.Tag_Req, "B", "g0", "K", "e0", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "d", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mProgressDialog", "e", "Z", "mIsTransferShield", "f", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Lcom/tencent/aio/api/runtime/a;", tl.h.F, "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/app/QQAppInterface;", "i", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "mActivity", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "mSessionInfo", "D", "mOneWayFriendSwitch", "com/tencent/qqnt/aio/helper/AddFriendNtHelper$c", "Lcom/tencent/qqnt/aio/helper/AddFriendNtHelper$c;", "mAction", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "getLinearLayout", "()Landroid/widget/LinearLayout;", "setLinearLayout", "(Landroid/widget/LinearLayout;)V", "linearLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "I", "()Landroid/widget/TextView;", "V", "(Landroid/widget/TextView;)V", "blackTv", "H", "U", "addFriendTv", "Landroid/view/View;", "Landroid/view/View;", "splitLineVertical", "splitLineHorizontal", "isOneWayFriend", "Lcom/tencent/mobileqq/app/ar;", "Lcom/tencent/mobileqq/app/ar;", "friendListObserver", "<init>", "()V", "M", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AddFriendNtHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: C, reason: from kotlin metadata */
    private SessionInfo mSessionInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout linearLayout;

    /* renamed from: G, reason: from kotlin metadata */
    public TextView blackTv;

    /* renamed from: H, reason: from kotlin metadata */
    public TextView addFriendTv;

    /* renamed from: I, reason: from kotlin metadata */
    private View splitLineVertical;

    /* renamed from: J, reason: from kotlin metadata */
    private View splitLineHorizontal;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isOneWayFriend;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQProgressDialog mProgressDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsTransferShield;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Activity mActivity;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mOneWayFriendSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103238", true);

    /* renamed from: E, reason: from kotlin metadata */
    private final c mAction = new c();

    /* renamed from: L, reason: from kotlin metadata */
    private final com.tencent.mobileqq.app.ar friendListObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/AddFriendNtHelper$b", "Lcom/tencent/mobileqq/app/ar;", "", "addUin", "", "onAddFriend", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.app.ar {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onAddFriend(String addUin) {
            Intrinsics.checkNotNullParameter(addUin, "addUin");
            AddFriendNtHelper.this.O(addUin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/AddFriendNtHelper$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            AddFriendNtHelper.this.J(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(boolean z16, Object obj, AddFriendNtHelper this$0, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (z16) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type tencent.im.oidb.cmdBlacklist.RelationBlacklist.CountBlockListRsp");
            RelationBlacklist$CountBlockListRsp relationBlacklist$CountBlockListRsp = (RelationBlacklist$CountBlockListRsp) obj;
            Activity activity = this$0.mActivity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity = null;
            }
            this$0.b0(activity, relationBlacklist$CountBlockListRsp.count.get() > 0, uin);
        }
    }

    private final void C() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        SessionInfo sessionInfo = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        long j3 = aVar.g().l().getLong("key_groupUin");
        if (j3 > 0) {
            SessionInfo sessionInfo2 = this.mSessionInfo;
            if (sessionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo = sessionInfo2;
            }
            sessionInfo.f179559f = String.valueOf(j3);
            N();
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        if (aVar3.g().r().c().j().length() == 0) {
            N();
            return;
        }
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null) {
            com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar4;
            }
            msgService.getTempChatInfo(100, aVar2.g().r().c().j(), new IGetTempChatInfoCallback() { // from class: com.tencent.qqnt.aio.helper.s
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                    AddFriendNtHelper.D(AddFriendNtHelper.this, i3, str, tempChatInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AddFriendNtHelper this$0, int i3, String str, TempChatInfo tempChatInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SessionInfo sessionInfo = null;
        String groupCode = tempChatInfo != null ? tempChatInfo.getGroupCode() : null;
        SessionInfo sessionInfo2 = this$0.mSessionInfo;
        if (sessionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
        } else {
            sessionInfo = sessionInfo2;
        }
        sessionInfo.f179559f = groupCode;
        this$0.N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(String str, AddFriendNtHelper this$0, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            com.tencent.relation.common.utils.i.c().m(str, false);
            this$0.o0(this$0.isOneWayFriend, false, false);
        }
    }

    private final void G(String uin) {
        com.tencent.mobileqq.activity.aio.helper.a.a(I(), ProfileCardBlacklistReportConst.ELEM_ID_EM_BLOCK_USER_BUTTON);
        VideoReport.reportEvent("clck", I(), new HashMap<String, String>() { // from class: com.tencent.qqnt.aio.helper.AddFriendNtHelper$cancelShieldBlacklist$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_BUTTON_CLICK, "2");
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsValue((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                return getEntries();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<String> getValues() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<String> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            public /* bridge */ boolean containsValue(String str) {
                return super.containsValue((Object) str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public final /* bridge */ String getOrDefault(Object obj, String str) {
                return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public /* bridge */ String get(String str) {
                return (String) super.get((Object) str);
            }

            public /* bridge */ String getOrDefault(String str, String str2) {
                return (String) super.getOrDefault((Object) str, str2);
            }

            public /* bridge */ String remove(String str) {
                return (String) super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if (!(obj == null ? true : obj instanceof String)) {
                    return false;
                }
                if (obj2 != null ? obj2 instanceof String : true) {
                    return remove((String) obj, (String) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, String str2) {
                return super.remove((Object) str, (Object) str2);
            }
        });
        E(uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(MsgIntent intent) {
        if (!Intrinsics.areEqual(intent, ThemeEvent.PostThemeChanged.f188712d) || this.blackTv == null) {
            return;
        }
        Resources resources = I().getResources();
        Activity activity = null;
        if (ThemeUtil.isDefaultTheme()) {
            I().setTextColor(resources.getColorStateList(R.color.afd));
            TextView H = H();
            Activity activity2 = this.mActivity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity2 = null;
            }
            H.setTextColor(activity2.getResources().getColorStateList(R.color.afd));
        } else {
            I().setTextColor(resources.getColorStateList(R.color.skin_float_btn));
            TextView H2 = H();
            Activity activity3 = this.mActivity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity3 = null;
            }
            H2.setTextColor(activity3.getResources().getColorStateList(R.color.skin_float_btn));
        }
        I().setBackgroundColor(resources.getColor(R.color.qui_common_bg_nav_aio));
        H().setBackgroundColor(resources.getColor(R.color.qui_common_bg_nav_aio));
        View view = this.splitLineVertical;
        if (view != null) {
            Activity activity4 = this.mActivity;
            if (activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity4 = null;
            }
            view.setBackgroundColor(activity4.getResources().getColor(R.color.qui_common_fill_standard_primary));
        }
        View view2 = this.splitLineHorizontal;
        if (view2 != null) {
            Activity activity5 = this.mActivity;
            if (activity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            } else {
                activity = activity5;
            }
            view2.setBackgroundColor(activity.getResources().getColor(R.color.qui_common_fill_standard_primary));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1.C, "") != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void L(Resources resources) {
        SessionInfo sessionInfo;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        View view;
        Activity activity6;
        View view2;
        LinearLayout linearLayout;
        Activity activity7;
        LinearLayout linearLayout2;
        com.tencent.aio.api.runtime.a aVar;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                AddFriendNtHelper.M(AddFriendNtHelper.this, view3);
            }
        };
        Activity activity8 = this.mActivity;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (activity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity8 = null;
        }
        LinearLayout linearLayout3 = new LinearLayout(activity8);
        this.linearLayout = linearLayout3;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.setId(R.id.f164244ob);
        LinearLayout linearLayout4 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout4);
        linearLayout4.setOrientation(1);
        Activity activity9 = this.mActivity;
        if (activity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity9 = null;
        }
        V(new DrawableCenterTextView(activity9));
        SessionInfo sessionInfo2 = this.mSessionInfo;
        if (sessionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo2 = null;
        }
        if (sessionInfo2.f179555d == 1006) {
            SessionInfo sessionInfo3 = this.mSessionInfo;
            if (sessionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo3 = null;
            }
            if (sessionInfo3.C != null) {
                SessionInfo sessionInfo4 = this.mSessionInfo;
                if (sessionInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo4 = null;
                }
            }
            I().setEnabled(false);
            I().setClickable(false);
            I().setTextSize(0, resources.getDimension(R.dimen.f158274c0));
            TextView I = I();
            IProfileCardFeatureApi iProfileCardFeatureApi = (IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class);
            sessionInfo = this.mSessionInfo;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            I.setText(HardCodeUtil.qqStr(!iProfileCardFeatureApi.isBlacklistUin(sessionInfo.f179557e, null) ? R.string.yov : R.string.yow));
            I().setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, resources));
            I().setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            activity = this.mActivity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity = null;
            }
            this.splitLineVertical = new View(activity);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, -1);
            activity2 = this.mActivity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity2 = null;
            }
            U(new DrawableCenterTextView(activity2));
            H().setText(HardCodeUtil.qqStr(R.string.f170193ik));
            TextView H = H();
            activity3 = this.mActivity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity3 = null;
            }
            H.setTextSize(0, activity3.getResources().getDimensionPixelSize(R.dimen.f158274c0));
            activity4 = this.mActivity;
            if (activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity4 = null;
            }
            H().setCompoundDrawablesWithIntrinsicBounds(activity4.getResources().getDrawable(R.drawable.qui_add_friend), (Drawable) null, (Drawable) null, (Drawable) null);
            TextView H2 = H();
            activity5 = this.mActivity;
            if (activity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity5 = null;
            }
            H2.setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, activity5.getResources()));
            H().setContentDescription(H().getText());
            H().setOnClickListener(onClickListener);
            H().setTag(3);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            if (!ThemeUtil.isDefaultTheme()) {
                I().setTextColor(resources.getColorStateList(R.color.afd));
                TextView H3 = H();
                Activity activity10 = this.mActivity;
                if (activity10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                    activity10 = null;
                }
                H3.setTextColor(activity10.getResources().getColorStateList(R.color.afd));
            } else {
                I().setTextColor(resources.getColorStateList(R.color.skin_float_btn));
                TextView H4 = H();
                Activity activity11 = this.mActivity;
                if (activity11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                    activity11 = null;
                }
                H4.setTextColor(activity11.getResources().getColorStateList(R.color.skin_float_btn));
            }
            view = this.splitLineVertical;
            if (view != null) {
                Activity activity12 = this.mActivity;
                if (activity12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                    activity12 = null;
                }
                view.setBackgroundColor(activity12.getResources().getColor(R.color.qui_common_fill_standard_primary));
            }
            I().setBackgroundColor(resources.getColor(R.color.qui_common_bg_nav_aio));
            H().setBackgroundColor(resources.getColor(R.color.qui_common_bg_nav_aio));
            activity6 = this.mActivity;
            if (activity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity6 = null;
            }
            LinearLayout linearLayout5 = new LinearLayout(activity6);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams4.weight = 1.0f;
            linearLayout5.setLayoutParams(layoutParams4);
            linearLayout5.setOrientation(0);
            linearLayout5.addView(I(), layoutParams);
            view2 = this.splitLineVertical;
            if (view2 != null) {
                linearLayout5.addView(view2, layoutParams2);
            }
            linearLayout5.addView(H(), layoutParams3);
            linearLayout = this.linearLayout;
            if (linearLayout != null) {
                linearLayout.addView(linearLayout5);
            }
            activity7 = this.mActivity;
            if (activity7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity7 = null;
            }
            View view3 = new View(activity7);
            view3.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
            view3.setBackgroundColor(resources.getColor(R.color.qui_common_fill_standard_primary));
            linearLayout2 = this.linearLayout;
            if (linearLayout2 != null) {
                linearLayout2.addView(view3);
            }
            this.splitLineHorizontal = view3;
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams5.addRule(10);
            aVar = this.mAIOContext;
            if (aVar != null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar;
            }
            com.tencent.mvi.base.route.j e16 = aVar2.e();
            LinearLayout linearLayout6 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout6);
            e16.h(new TroopShortcutBarEvent.SetShortcutView(0, linearLayout6, layoutParams5));
        }
        I().setEnabled(true);
        I().setClickable(true);
        I().setTextSize(0, resources.getDimension(R.dimen.f158274c0));
        TextView I2 = I();
        IProfileCardFeatureApi iProfileCardFeatureApi2 = (IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class);
        sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
        }
        I2.setText(HardCodeUtil.qqStr(!iProfileCardFeatureApi2.isBlacklistUin(sessionInfo.f179557e, null) ? R.string.yov : R.string.yow));
        I().setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, resources));
        I().setOnClickListener(onClickListener);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.weight = 1.0f;
        activity = this.mActivity;
        if (activity == null) {
        }
        this.splitLineVertical = new View(activity);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(1, -1);
        activity2 = this.mActivity;
        if (activity2 == null) {
        }
        U(new DrawableCenterTextView(activity2));
        H().setText(HardCodeUtil.qqStr(R.string.f170193ik));
        TextView H5 = H();
        activity3 = this.mActivity;
        if (activity3 == null) {
        }
        H5.setTextSize(0, activity3.getResources().getDimensionPixelSize(R.dimen.f158274c0));
        activity4 = this.mActivity;
        if (activity4 == null) {
        }
        H().setCompoundDrawablesWithIntrinsicBounds(activity4.getResources().getDrawable(R.drawable.qui_add_friend), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView H22 = H();
        activity5 = this.mActivity;
        if (activity5 == null) {
        }
        H22.setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, activity5.getResources()));
        H().setContentDescription(H().getText());
        H().setOnClickListener(onClickListener);
        H().setTag(3);
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(0, -1);
        layoutParams32.weight = 1.0f;
        if (!ThemeUtil.isDefaultTheme()) {
        }
        view = this.splitLineVertical;
        if (view != null) {
        }
        I().setBackgroundColor(resources.getColor(R.color.qui_common_bg_nav_aio));
        H().setBackgroundColor(resources.getColor(R.color.qui_common_bg_nav_aio));
        activity6 = this.mActivity;
        if (activity6 == null) {
        }
        LinearLayout linearLayout52 = new LinearLayout(activity6);
        LinearLayout.LayoutParams layoutParams42 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams42.weight = 1.0f;
        linearLayout52.setLayoutParams(layoutParams42);
        linearLayout52.setOrientation(0);
        linearLayout52.addView(I(), layoutParams6);
        view2 = this.splitLineVertical;
        if (view2 != null) {
        }
        linearLayout52.addView(H(), layoutParams32);
        linearLayout = this.linearLayout;
        if (linearLayout != null) {
        }
        activity7 = this.mActivity;
        if (activity7 == null) {
        }
        View view32 = new View(activity7);
        view32.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        view32.setBackgroundColor(resources.getColor(R.color.qui_common_fill_standard_primary));
        linearLayout2 = this.linearLayout;
        if (linearLayout2 != null) {
        }
        this.splitLineHorizontal = view32;
        RelativeLayout.LayoutParams layoutParams52 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams52.addRule(10);
        aVar = this.mAIOContext;
        if (aVar != null) {
        }
        com.tencent.mvi.base.route.j e162 = aVar2.e();
        LinearLayout linearLayout62 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout62);
        e162.h(new TroopShortcutBarEvent.SetShortcutView(0, linearLayout62, layoutParams52));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(AddFriendNtHelper this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view.getTag();
        SessionInfo sessionInfo = null;
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num != null) {
            int intValue = num.intValue();
            if (com.tencent.mobileqq.activity.aio.a.a()) {
                return;
            }
            SessionInfo sessionInfo2 = this$0.mSessionInfo;
            if (sessionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo2 = null;
            }
            String uin = sessionInfo2.f179557e;
            SessionInfo sessionInfo3 = this$0.mSessionInfo;
            if (sessionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo3 = null;
            }
            if (sessionInfo3.f179555d == 1006) {
                SessionInfo sessionInfo4 = this$0.mSessionInfo;
                if (sessionInfo4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                } else {
                    sessionInfo = sessionInfo4;
                }
                uin = sessionInfo.C;
            }
            if (intValue == 1) {
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                this$0.G(uin);
            } else if (intValue == 2) {
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                this$0.W(uin);
            } else if (intValue == 3) {
                this$0.B();
            } else {
                if (intValue != 4) {
                    return;
                }
                this$0.g0();
            }
        }
    }

    private final void N() {
        Activity activity;
        Activity activity2 = this.mActivity;
        SessionInfo sessionInfo = null;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        } else {
            activity = activity2;
        }
        SessionInfo sessionInfo2 = this.mSessionInfo;
        if (sessionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo2 = null;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.button_back);
        Activity activity3 = this.mActivity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity3 = null;
        }
        boolean z16 = activity3.getIntent().getStringExtra("param_return_addr") != null;
        boolean z17 = this.isOneWayFriend;
        SessionInfo sessionInfo3 = this.mSessionInfo;
        if (sessionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
        } else {
            sessionInfo = sessionInfo3;
        }
        ChatActivityUtils.e(activity, sessionInfo2, qqStr, z16, z17, sessionInfo.f179557e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(String addUin) {
        SessionInfo sessionInfo = this.mSessionInfo;
        com.tencent.aio.api.runtime.a aVar = null;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        if (Intrinsics.areEqual(sessionInfo.f179557e, addUin)) {
            int[] UIN_TYPE_C2C_ALL = com.tencent.imcore.message.ao.f116570d;
            Intrinsics.checkNotNullExpressionValue(UIN_TYPE_C2C_ALL, "UIN_TYPE_C2C_ALL");
            int length = UIN_TYPE_C2C_ALL.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int i16 = UIN_TYPE_C2C_ALL[i3];
                SessionInfo sessionInfo2 = this.mSessionInfo;
                if (sessionInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo2 = null;
                }
                if (sessionInfo2.f179555d == i16) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (z16) {
                com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar = aVar2;
                }
                aVar.e().h(new ExternalCommIntent("close_aio", new Bundle()));
            }
        }
    }

    private final void Q(Activity activity, String uin) {
        R(activity, uin);
        if (this.mIsTransferShield) {
            QQToastUtil.showQQToastInUiThread(2, HardCodeUtil.qqStr(R.string.f227626rj));
            com.tencent.relation.common.utils.i.c().i(true);
            ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendShieldListTransferRequest(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(final String uin, AddFriendNtHelper this$0, Activity activity, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type tencent.im.oidb.cmdBlacklist.RelationBlacklist.BlockRsp");
            RelationBlacklist$BlockRsp relationBlacklist$BlockRsp = (RelationBlacklist$BlockRsp) obj;
            if (relationBlacklist$BlockRsp.code.get() == 0) {
                com.tencent.relation.common.utils.i.c().m(uin, true);
                this$0.o0(this$0.isOneWayFriend, true, false);
                return;
            }
            if (relationBlacklist$BlockRsp.code.get() == 10001) {
                RelationDialogUtil.c(activity, 230, HardCodeUtil.qqStr(R.string.f159971tr), relationBlacklist$BlockRsp.f436002msg.get(), HardCodeUtil.qqStr(R.string.f159961tq), "", null, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        AddFriendNtHelper.T(dialogInterface, i3);
                    }
                });
                QQAppInterface qQAppInterface = this$0.mApp;
                if (qQAppInterface == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mApp");
                    qQAppInterface = null;
                }
                ((IProfileCardBlacklistService) qQAppInterface.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", ProfileCardBlacklistReportConst.PAGE_ID_PG_BLACKLIST_LIMIT_POP, null, new HashMap<String, String>(uin) { // from class: com.tencent.qqnt.aio.helper.AddFriendNtHelper$sendAddBlacklist$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        put("to_uin", uin);
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ boolean containsKey(Object obj2) {
                        if (obj2 == null ? true : obj2 instanceof String) {
                            return containsKey((String) obj2);
                        }
                        return false;
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ boolean containsValue(Object obj2) {
                        if (obj2 == null ? true : obj2 instanceof String) {
                            return containsValue((String) obj2);
                        }
                        return false;
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                        return getEntries();
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ /* synthetic */ Object get(Object obj2) {
                        if (obj2 == null ? true : obj2 instanceof String) {
                            return get((String) obj2);
                        }
                        return null;
                    }

                    public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                        return super.entrySet();
                    }

                    public /* bridge */ Set<String> getKeys() {
                        return super.keySet();
                    }

                    @Override // java.util.HashMap, java.util.Map
                    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj2, Object obj3) {
                        return !(obj2 == null ? true : obj2 instanceof String) ? obj3 : getOrDefault((String) obj2, (String) obj3);
                    }

                    public /* bridge */ int getSize() {
                        return super.size();
                    }

                    public /* bridge */ Collection<String> getValues() {
                        return super.values();
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ Set<String> keySet() {
                        return getKeys();
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ /* synthetic */ Object remove(Object obj2) {
                        if (obj2 == null ? true : obj2 instanceof String) {
                            return remove((String) obj2);
                        }
                        return null;
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ int size() {
                        return getSize();
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ Collection<String> values() {
                        return getValues();
                    }

                    public /* bridge */ boolean containsKey(String str) {
                        return super.containsKey((Object) str);
                    }

                    public /* bridge */ boolean containsValue(String str) {
                        return super.containsValue((Object) str);
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ String get(Object obj2) {
                        if (obj2 == null ? true : obj2 instanceof String) {
                            return get((String) obj2);
                        }
                        return null;
                    }

                    public final /* bridge */ String getOrDefault(Object obj2, String str) {
                        return !(obj2 == null ? true : obj2 instanceof String) ? str : getOrDefault((String) obj2, str);
                    }

                    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                    public final /* bridge */ String remove(Object obj2) {
                        if (obj2 == null ? true : obj2 instanceof String) {
                            return remove((String) obj2);
                        }
                        return null;
                    }

                    public /* bridge */ String get(String str) {
                        return (String) super.get((Object) str);
                    }

                    public /* bridge */ String getOrDefault(String str, String str2) {
                        return (String) super.getOrDefault((Object) str, str2);
                    }

                    public /* bridge */ String remove(String str) {
                        return (String) super.remove((Object) str);
                    }

                    @Override // java.util.HashMap, java.util.Map
                    public final /* bridge */ boolean remove(Object obj2, Object obj3) {
                        if (!(obj2 == null ? true : obj2 instanceof String)) {
                            return false;
                        }
                        if (obj3 != null ? obj3 instanceof String : true) {
                            return remove((String) obj2, (String) obj3);
                        }
                        return false;
                    }

                    public /* bridge */ boolean remove(String str, String str2) {
                        return super.remove((Object) str, (Object) str2);
                    }
                }, null);
                return;
            }
            String str = relationBlacklist$BlockRsp.f436002msg.get();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            QQToastUtil.showQQToastInUiThread(1, str);
        }
    }

    private final void W(String uin) {
        com.tencent.mobileqq.activity.aio.helper.a.a(I(), ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_BLACKLIST_BUTTON);
        VideoReport.reportEvent("clck", I(), new HashMap<String, String>() { // from class: com.tencent.qqnt.aio.helper.AddFriendNtHelper$shieldOrBlacklist$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_BUTTON_CLICK, "1");
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsValue((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                return getEntries();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<String> getValues() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<String> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            public /* bridge */ boolean containsValue(String str) {
                return super.containsValue((Object) str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public final /* bridge */ String getOrDefault(Object obj, String str) {
                return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public /* bridge */ String get(String str) {
                return (String) super.get((Object) str);
            }

            public /* bridge */ String getOrDefault(String str, String str2) {
                return (String) super.getOrDefault((Object) str, str2);
            }

            public /* bridge */ String remove(String str) {
                return (String) super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if (!(obj == null ? true : obj instanceof String)) {
                    return false;
                }
                if (obj2 != null ? obj2 instanceof String : true) {
                    return remove((String) obj, (String) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, String str2) {
                return super.remove((Object) str, (Object) str2);
            }
        });
        y(uin);
    }

    private final void X(final Activity activity, final boolean needTransferButton, final String uin) {
        this.mIsTransferShield = needTransferButton;
        QQCustomDialog addBlacklistDialog = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getAddBlacklistDialog(activity, needTransferButton, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AddFriendNtHelper.Y(AddFriendNtHelper.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AddFriendNtHelper.Z(AddFriendNtHelper.this, activity, uin, needTransferButton, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AddFriendNtHelper.a0(AddFriendNtHelper.this, needTransferButton, dialogInterface, i3);
            }
        });
        if (activity != null && !activity.isFinishing() && addBlacklistDialog != null) {
            addBlacklistDialog.show();
            com.tencent.mobileqq.activity.aio.helper.a.a(I(), ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_TO_BLACKLIST_ACTIONSHEET);
            VideoReport.reportEvent("imp", I(), new HashMap<String, String>(needTransferButton) { // from class: com.tencent.qqnt.aio.helper.AddFriendNtHelper$showAddBlacklistDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    String str;
                    if (needTransferButton) {
                        str = "2";
                    } else {
                        str = "1";
                    }
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_ACTIONSHEET_TYPE, str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsValue((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    return super.keySet();
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ Collection<String> getValues() {
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<String> values() {
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str) {
                    return super.containsKey((Object) str);
                }

                public /* bridge */ boolean containsValue(String str) {
                    return super.containsValue((Object) str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public final /* bridge */ String getOrDefault(Object obj, String str) {
                    return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                public /* bridge */ String get(String str) {
                    return (String) super.get((Object) str);
                }

                public /* bridge */ String getOrDefault(String str, String str2) {
                    return (String) super.getOrDefault((Object) str, str2);
                }

                public /* bridge */ String remove(String str) {
                    return (String) super.remove((Object) str);
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if (!(obj == null ? true : obj instanceof String)) {
                        return false;
                    }
                    if (obj2 != null ? obj2 instanceof String : true) {
                        return remove((String) obj, (String) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str, String str2) {
                    return super.remove((Object) str, (Object) str2);
                }
            });
            return;
        }
        QLog.e("AddFriendNtHelper", 1, "showAddBlacklistDialog is error!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(AddFriendNtHelper this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mIsTransferShield = i3 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AddFriendNtHelper this$0, Activity activity, String uin, boolean z16, DialogInterface dialogInterface, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.Q(activity, uin);
        String str2 = "2";
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        if (!this$0.mIsTransferShield) {
            str2 = "1";
        }
        this$0.P(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(AddFriendNtHelper this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        this$0.P(str, "3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AddFriendNtHelper this$0, Activity activity, boolean z16, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.X(activity, z16, uin);
    }

    private final boolean f0() {
        com.tencent.qqnt.contact.friends.b bVar = com.tencent.qqnt.contact.friends.b.f355778a;
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        boolean z16 = !bVar.c(sessionInfo.f179557e, "AddFriendNtHelper");
        QLog.i("AddFriendNtHelper", 1, "CMR is not friend: " + z16);
        return z16;
    }

    private final void i0() {
        Activity activity = null;
        if (e0()) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
            }
            Activity activity2 = this.mActivity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            } else {
                activity = activity2;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.b
                @Override // java.lang.Runnable
                public final void run() {
                    AddFriendNtHelper.j0(AddFriendNtHelper.this);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
        }
        Activity activity3 = this.mActivity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        } else {
            activity = activity3;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.l
            @Override // java.lang.Runnable
            public final void run() {
                AddFriendNtHelper.k0(AddFriendNtHelper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(AddFriendNtHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(AddFriendNtHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(final AddFriendNtHelper this$0, final boolean z16, final boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.p
            @Override // java.lang.Runnable
            public final void run() {
                AddFriendNtHelper.n0(AddFriendNtHelper.this, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(AddFriendNtHelper this$0, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o0(z16, z17, false);
    }

    private final void o0(boolean isSingleWayFriend, final boolean isBlacklist, final boolean needReport) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.r
            @Override // java.lang.Runnable
            public final void run() {
                AddFriendNtHelper.p0(isBlacklist, this, needReport);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(boolean z16, final AddFriendNtHelper this$0, final boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = null;
        if (z16) {
            Activity activity2 = this$0.mActivity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            } else {
                activity = activity2;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    AddFriendNtHelper.r0(AddFriendNtHelper.this, z17);
                }
            });
            return;
        }
        if (this$0.isOneWayFriend) {
            return;
        }
        Activity activity3 = this$0.mActivity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        } else {
            activity = activity3;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.e
            @Override // java.lang.Runnable
            public final void run() {
                AddFriendNtHelper.q0(AddFriendNtHelper.this, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(AddFriendNtHelper this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I().setText(HardCodeUtil.qqStr(R.string.yow));
        QQAppInterface qQAppInterface = this$0.mApp;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        Resources resources = qQAppInterface.getApplication().getResources();
        if (resources != null) {
            this$0.I().setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.qui_shield), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this$0.I().setTag(2);
        if (z16) {
            com.tencent.mobileqq.activity.aio.helper.a.a(this$0.I(), ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_BLACKLIST_BUTTON);
            VideoReport.reportEvent("imp", this$0.I(), new HashMap<String, String>() { // from class: com.tencent.qqnt.aio.helper.AddFriendNtHelper$updateBlacklistStatusAsync$1$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_BUTTON_TEXT_CONTENT, "1");
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsValue((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    return super.keySet();
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ Collection<String> getValues() {
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<String> values() {
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str) {
                    return super.containsKey((Object) str);
                }

                public /* bridge */ boolean containsValue(String str) {
                    return super.containsValue((Object) str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public final /* bridge */ String getOrDefault(Object obj, String str) {
                    return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                public /* bridge */ String get(String str) {
                    return (String) super.get((Object) str);
                }

                public /* bridge */ String getOrDefault(String str, String str2) {
                    return (String) super.getOrDefault((Object) str, str2);
                }

                public /* bridge */ String remove(String str) {
                    return (String) super.remove((Object) str);
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if (!(obj == null ? true : obj instanceof String)) {
                        return false;
                    }
                    if (obj2 != null ? obj2 instanceof String : true) {
                        return remove((String) obj, (String) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str, String str2) {
                    return super.remove((Object) str, (Object) str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(AddFriendNtHelper this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I().setText(HardCodeUtil.qqStr(R.string.yov));
        QQAppInterface qQAppInterface = this$0.mApp;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        Resources resources = qQAppInterface.getApplication().getResources();
        if (resources != null) {
            this$0.I().setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.qui_sort), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this$0.I().setTag(1);
        if (z16) {
            com.tencent.mobileqq.activity.aio.helper.a.a(this$0.I(), ProfileCardBlacklistReportConst.ELEM_ID_EM_ADD_BLACKLIST_BUTTON);
            VideoReport.reportEvent("imp", this$0.I(), new HashMap<String, String>() { // from class: com.tencent.qqnt.aio.helper.AddFriendNtHelper$updateBlacklistStatusAsync$1$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    put(ProfileCardBlacklistReportConst.ELEM_PARAM_BUTTON_TEXT_CONTENT, "2");
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsKey(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsKey((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ boolean containsValue(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return containsValue((String) obj);
                    }
                    return false;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                    return getEntries();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                    return super.entrySet();
                }

                public /* bridge */ Set<String> getKeys() {
                    return super.keySet();
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                    return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ Collection<String> getValues() {
                    return super.values();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Set<String> keySet() {
                    return getKeys();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ Collection<String> values() {
                    return getValues();
                }

                public /* bridge */ boolean containsKey(String str) {
                    return super.containsKey((Object) str);
                }

                public /* bridge */ boolean containsValue(String str) {
                    return super.containsValue((Object) str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String get(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return get((String) obj);
                    }
                    return null;
                }

                public final /* bridge */ String getOrDefault(Object obj, String str) {
                    return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final /* bridge */ String remove(Object obj) {
                    if (obj == null ? true : obj instanceof String) {
                        return remove((String) obj);
                    }
                    return null;
                }

                public /* bridge */ String get(String str) {
                    return (String) super.get((Object) str);
                }

                public /* bridge */ String getOrDefault(String str, String str2) {
                    return (String) super.getOrDefault((Object) str, str2);
                }

                public /* bridge */ String remove(String str) {
                    return (String) super.remove((Object) str);
                }

                @Override // java.util.HashMap, java.util.Map
                public final /* bridge */ boolean remove(Object obj, Object obj2) {
                    if (!(obj == null ? true : obj instanceof String)) {
                        return false;
                    }
                    if (obj2 != null ? obj2 instanceof String : true) {
                        return remove((String) obj, (String) obj2);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(String str, String str2) {
                    return super.remove((Object) str, (Object) str2);
                }
            });
        }
    }

    private final void s0(boolean isSingleWayFriend, String uin) {
        l0(isSingleWayFriend, uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(final AddFriendNtHelper this$0, final String uin, final boolean z16, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.f
            @Override // java.lang.Runnable
            public final void run() {
                AddFriendNtHelper.A(z16, obj, this$0, uin);
            }
        });
    }

    public final void B() {
        QQAppInterface qQAppInterface;
        SessionInfo sessionInfo = null;
        if (this.isOneWayFriend) {
            QQAppInterface qQAppInterface2 = this.mApp;
            if (qQAppInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface = null;
            } else {
                qQAppInterface = qQAppInterface2;
            }
            SessionInfo sessionInfo2 = this.mSessionInfo;
            if (sessionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo2 = null;
            }
            ReportController.o(qQAppInterface, "CliOper", "", sessionInfo2.f179557e, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
        }
        SessionInfo sessionInfo3 = this.mSessionInfo;
        if (sessionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo3 = null;
        }
        if (sessionInfo3.f179555d == 1000) {
            SessionInfo sessionInfo4 = this.mSessionInfo;
            if (sessionInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo = sessionInfo4;
            }
            String str = sessionInfo.f179559f;
            if (str == null || str.length() == 0) {
                C();
                return;
            }
        }
        N();
    }

    public final void E(final String uin) {
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendDeleteBlacklistRequest(uin, new RelationBlacklistListener() { // from class: com.tencent.qqnt.aio.helper.t
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z16, Object obj) {
                AddFriendNtHelper.F(uin, this, z16, obj);
            }
        });
    }

    public final TextView H() {
        TextView textView = this.addFriendTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
        return null;
    }

    public final TextView I() {
        TextView textView = this.blackTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blackTv");
        return null;
    }

    public final void K() {
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendNtHelper", 1, "hideAddFriendAndShield will executed!");
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new AIOTopTipEvent.SetTopPadding(0));
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(8);
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar3;
            }
            com.tencent.mvi.base.route.j e16 = aVar2.e();
            LinearLayout linearLayout2 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout2);
            e16.h(new TroopShortcutBarEvent.RemoveShortcutView(linearLayout2));
        }
    }

    public final void P(final String type, final String option) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(option, "option");
        VideoReport.reportEvent("clck", I(), new HashMap<String, String>(type, option) { // from class: com.tencent.qqnt.aio.helper.AddFriendNtHelper$reportBlacklistDialogClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_ACTIONSHEET_TYPE, type);
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_ACTIONSHEET_OPTION, option);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return containsValue((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                return getEntries();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<String> getValues() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<String> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            public /* bridge */ boolean containsValue(String str) {
                return super.containsValue((Object) str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String get(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public final /* bridge */ String getOrDefault(Object obj, String str) {
                return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String remove(Object obj) {
                if (obj == null ? true : obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public /* bridge */ String get(String str) {
                return (String) super.get((Object) str);
            }

            public /* bridge */ String getOrDefault(String str, String str2) {
                return (String) super.getOrDefault((Object) str, str2);
            }

            public /* bridge */ String remove(String str) {
                return (String) super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if (!(obj == null ? true : obj instanceof String)) {
                    return false;
                }
                if (obj2 != null ? obj2 instanceof String : true) {
                    return remove((String) obj, (String) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, String str2) {
                return super.remove((Object) str, (Object) str2);
            }
        });
    }

    public final void R(final Activity activity, final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendAddBlacklistRequest(uin, new RelationBlacklistListener() { // from class: com.tencent.qqnt.aio.helper.j
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z16, Object obj) {
                AddFriendNtHelper.S(uin, this, activity, z16, obj);
            }
        });
    }

    public final void U(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.addFriendTv = textView;
    }

    public final void V(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.blackTv = textView;
    }

    public final void b0(final Activity activity, final boolean needTransferButton, final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                AddFriendNtHelper.c0(AddFriendNtHelper.this, activity, needTransferButton, uin);
            }
        });
    }

    public final void d0() {
        Drawable drawable;
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendNtHelper", 2, "showAddFriendAndShield() ==== called.");
        }
        QQAppInterface qQAppInterface = this.mApp;
        SessionInfo sessionInfo = null;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        Resources resources = qQAppInterface.getApplication().getResources();
        if (this.linearLayout == null) {
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            L(resources);
        }
        if (resources != null) {
            IProfileCardFeatureApi iProfileCardFeatureApi = (IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class);
            SessionInfo sessionInfo2 = this.mSessionInfo;
            if (sessionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo2 = null;
            }
            drawable = resources.getDrawable(iProfileCardFeatureApi.isBlacklistUin(sessionInfo2.f179557e, null) ? R.drawable.qui_sort : R.drawable.qui_shield);
        } else {
            drawable = null;
        }
        if (this.isOneWayFriend) {
            drawable = resources.getDrawable(R.drawable.aio_cancel_friend_icon);
            I().setText(HardCodeUtil.qqStr(R.string.hn7));
            I().setTag(4);
        }
        I().setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        SessionInfo sessionInfo3 = this.mSessionInfo;
        if (sessionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo3 = null;
        }
        String uinFinal = sessionInfo3.f179557e;
        SessionInfo sessionInfo4 = this.mSessionInfo;
        if (sessionInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo4 = null;
        }
        if (sessionInfo4.f179555d == 1006) {
            SessionInfo sessionInfo5 = this.mSessionInfo;
            if (sessionInfo5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo = sessionInfo5;
            }
            uinFinal = sessionInfo.C;
        }
        boolean z16 = this.isOneWayFriend;
        Intrinsics.checkNotNullExpressionValue(uinFinal, "uinFinal");
        s0(z16, uinFinal);
        LinearLayout linearLayout = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(0);
    }

    public final boolean e0() {
        SessionInfo sessionInfo = this.mSessionInfo;
        SessionInfo sessionInfo2 = null;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        if (sessionInfo.f179555d == 1025) {
            return f0();
        }
        SessionInfo sessionInfo3 = this.mSessionInfo;
        if (sessionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
        } else {
            sessionInfo2 = sessionInfo3;
        }
        return sessionInfo2.f179555d != 0 || this.isOneWayFriend;
    }

    public final void g0() {
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(HardCodeUtil.qqStr(R.string.hn9));
        actionSheet.addButton(R.string.hn7, 3);
        actionSheet.addButton(R.string.f173155wh0);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.o
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                AddFriendNtHelper.h0(AddFriendNtHelper.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
        ReportController.o(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350665q0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "AddFriendNtHelper";
    }

    public final void l0(final boolean isSingleWayFriend, String uin) {
        o0(isSingleWayFriend, ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isBlacklistUin(uin, new CheckBlacklistListener() { // from class: com.tencent.qqnt.aio.helper.n
            @Override // com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener
            public final void onResult(boolean z16) {
                AddFriendNtHelper.m0(AddFriendNtHelper.this, isSingleWayFriend, z16);
            }
        }), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    @Override // com.tencent.aio.main.businesshelper.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(com.tencent.aio.main.businesshelper.b helperParam) {
        boolean z16;
        com.tencent.aio.main.businesshelper.b bVar;
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        this.mHelperParam = helperParam;
        this.mAIOContext = helperParam.a();
        FragmentActivity requireActivity = helperParam.a().c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "helperParam.aioContext.fragment.requireActivity()");
        this.mActivity = requireActivity;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        this.mSessionInfo = su3.b.a(g16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        this.mApp = (QQAppInterface) peekAppRuntime;
        if (this.mOneWayFriendSwitch) {
            SessionInfo sessionInfo = this.mSessionInfo;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            if (sessionInfo.f179555d == 0) {
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                SessionInfo sessionInfo2 = this.mSessionInfo;
                if (sessionInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo2 = null;
                }
                String str = sessionInfo2.f178172i0;
                Intrinsics.checkNotNullExpressionValue(str, "mSessionInfo.uid");
                if (!iFriendsInfoService.isFriend(str, "AddFriendNtHelper")) {
                    z16 = true;
                    this.isOneWayFriend = z16;
                    bVar = this.mHelperParam;
                    if (bVar != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    } else {
                        bVar2 = bVar;
                    }
                    bVar2.a().e().f(this, this.mAction);
                }
            }
        }
        z16 = false;
        this.isOneWayFriend = z16;
        bVar = this.mHelperParam;
        if (bVar != null) {
        }
        bVar2.a().e().f(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.mAction);
    }

    public final void y(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (com.tencent.relation.common.utils.i.c().b()) {
            Activity activity = this.mActivity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity = null;
            }
            b0(activity, false, uin);
            return;
        }
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendGetShieldListNumberRequest(new RelationBlacklistListener() { // from class: com.tencent.qqnt.aio.helper.q
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z16, Object obj) {
                AddFriendNtHelper.z(AddFriendNtHelper.this, uin, z16, obj);
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 3, 6, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QQAppInterface qQAppInterface = null;
        if (state == 0) {
            QQAppInterface qQAppInterface2 = this.mApp;
            if (qQAppInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
            } else {
                qQAppInterface = qQAppInterface2;
            }
            qQAppInterface.addObserver(this.friendListObserver);
            i0();
            return;
        }
        if (state == 3) {
            i0();
            return;
        }
        if (state != 12) {
            return;
        }
        K();
        QQAppInterface qQAppInterface3 = this.mApp;
        if (qQAppInterface3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
        } else {
            qQAppInterface = qQAppInterface3;
        }
        qQAppInterface.removeObserver(this.friendListObserver);
        QQProgressDialog qQProgressDialog = this.mProgressDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(AddFriendNtHelper this$0, ActionSheet actionSheet, View view, int i3) {
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Activity activity = null;
        if (i3 == 0) {
            QQAppInterface qQAppInterface2 = this$0.mApp;
            if (qQAppInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface = null;
            } else {
                qQAppInterface = qQAppInterface2;
            }
            SessionInfo sessionInfo = this$0.mSessionInfo;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            ReportController.o(qQAppInterface, "CliOper", "", sessionInfo.f179557e, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
            ReportController.o(null, "dc00898", "", "", "0X800ACA3", "0X800ACA3", 0, 0, "", "0", "0", "");
            ArrayList arrayList = new ArrayList();
            try {
                SessionInfo sessionInfo2 = this$0.mSessionInfo;
                if (sessionInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                    sessionInfo2 = null;
                }
                String str = sessionInfo2.f179557e;
                Intrinsics.checkNotNullExpressionValue(str, "mSessionInfo.curFriendUin");
                arrayList.add(Long.valueOf(Long.parseLong(str)));
                QQAppInterface qQAppInterface3 = this$0.mApp;
                if (qQAppInterface3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mApp");
                    qQAppInterface3 = null;
                }
                IRuntimeService runtimeService = qQAppInterface3.getRuntimeService(IStrangerService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(I\u2026ava, ProcessConstant.ALL)");
                ((IStrangerService) runtimeService).deleteStrangers(arrayList);
                if (this$0.mProgressDialog == null) {
                    Activity activity2 = this$0.mActivity;
                    if (activity2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                    } else {
                        activity = activity2;
                    }
                    this$0.mProgressDialog = new QQProgressDialog(activity, 0);
                }
                QQProgressDialog qQProgressDialog = this$0.mProgressDialog;
                Intrinsics.checkNotNull(qQProgressDialog);
                qQProgressDialog.show();
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendNtHelper", 2, "delete Stranger parseLong() error", e16);
                    return;
                }
                return;
            }
        } else if (i3 == 1) {
            Activity activity3 = this$0.mActivity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity3 = null;
            }
            Intent intent = new Intent(activity3, (Class<?>) QQBrowserActivity.class);
            SessionInfo sessionInfo3 = this$0.mSessionInfo;
            if (sessionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo3 = null;
            }
            intent.putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=" + sessionInfo3.f179557e);
            Activity activity4 = this$0.mActivity;
            if (activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            } else {
                activity = activity4;
            }
            activity.startActivity(intent);
            ReportController.o(null, "dc00898", "", "", "0X800ACA4", "0X800ACA4", 0, 0, "", "0", "0", "");
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(DialogInterface dialogInterface, int i3) {
    }
}
