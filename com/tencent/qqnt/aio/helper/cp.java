package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.shortcutbar.adapter.TroopShortcutBarEvent;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.relation.common.nt.api.IRelationOneWayFriendApi;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4$DelResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004R\u0014\u0010!\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010M\u001a\u00020G8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bH\u0010LR\"\u0010O\u001a\u00020G8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010I\u001a\u0004\bN\u0010K\"\u0004\b@\u0010LR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/qqnt/aio/helper/cp;", "Lcom/tencent/aio/main/businesshelper/h;", "", "isOneWayFriend", "", "K", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, HippyTKDListViewAdapter.X, "t", "", "addUin", "D", "B", "", QQBrowserActivity.KEY_MSG_TYPE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "getId", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "", "interestedIn", "getTag", BdhLogUtil.LogTag.Tag_Conn, "H", "w", ReportConstant.COSTREPORT_PREFIX, "I", "d", "Ljava/lang/String;", "FRIEND_SETTING_SCHEMA", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "e", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mProgressDialog", "f", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Lcom/tencent/aio/api/runtime/a;", tl.h.F, "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/app/QQAppInterface;", "i", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "mActivity", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "mSessionInfo", "Lcom/tencent/mobileqq/relationx/onewayfriend/b;", "Lcom/tencent/mobileqq/relationx/onewayfriend/b;", "mObserver", "Lcom/tencent/mobileqq/app/ar;", "E", "Lcom/tencent/mobileqq/app/ar;", "friendListObserver", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "getLinearLayout", "()Landroid/widget/LinearLayout;", "setLinearLayout", "(Landroid/widget/LinearLayout;)V", "linearLayout", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "v", "()Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "blackTv", "u", "addFriendTv", "Lcom/tencent/mobileqq/stranger/observer/a;", "Lcom/tencent/mobileqq/stranger/observer/a;", "singleDirectionFriendObserver", "<init>", "()V", "J", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class cp implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private SessionInfo mSessionInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout linearLayout;

    /* renamed from: G, reason: from kotlin metadata */
    public TextView blackTv;

    /* renamed from: H, reason: from kotlin metadata */
    public TextView addFriendTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQProgressDialog mProgressDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Activity mActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String FRIEND_SETTING_SCHEMA = "mqqapi://relation/friendSetting?";

    /* renamed from: D, reason: from kotlin metadata */
    private final com.tencent.mobileqq.relationx.onewayfriend.b mObserver = new c();

    /* renamed from: E, reason: from kotlin metadata */
    private final com.tencent.mobileqq.app.ar friendListObserver = new b();

    /* renamed from: I, reason: from kotlin metadata */
    private final com.tencent.mobileqq.stranger.observer.a singleDirectionFriendObserver = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/cp$b", "Lcom/tencent/mobileqq/app/ar;", "", "addUin", "", "onAddFriend", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.app.ar {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onAddFriend(String addUin) {
            Intrinsics.checkNotNullParameter(addUin, "addUin");
            cp.this.D(addUin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/cp$c", "Lcom/tencent/mobileqq/relationx/onewayfriend/b;", "", "success", "Lcom/tencent/mobileqq/relationx/onewayfriend/c;", "result", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.relationx.onewayfriend.b {
        c() {
        }

        @Override // com.tencent.mobileqq.relationx.onewayfriend.b
        public void a(boolean success, com.tencent.mobileqq.relationx.onewayfriend.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SessionInfo sessionInfo = cp.this.mSessionInfo;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            if (TextUtils.equals(sessionInfo.f179557e, String.valueOf(result.f280832a))) {
                boolean z16 = success && result.f280833b;
                cp.this.K(z16);
                cp.this.B(z16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0016\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/aio/helper/cp$d", "Lcom/tencent/mobileqq/stranger/observer/a;", "", "isSuccess", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult;", "delResult", "", "b", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends com.tencent.mobileqq.stranger.observer.a {
        d() {
        }

        @Override // com.tencent.mobileqq.stranger.observer.a
        public void a(List<String> uinList) {
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            boolean z16 = true;
            com.tencent.aio.main.businesshelper.b bVar = null;
            if (!uinList.isEmpty()) {
                for (String str : uinList) {
                    SessionInfo sessionInfo = cp.this.mSessionInfo;
                    if (sessionInfo == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                        sessionInfo = null;
                    }
                    if (Intrinsics.areEqual(str, sessionInfo.f179557e)) {
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                com.tencent.aio.main.businesshelper.b bVar2 = cp.this.mHelperParam;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                } else {
                    bVar = bVar2;
                }
                bVar.a().e().h(new ExternalCommIntent("close_aio", new Bundle()));
            }
        }

        @Override // com.tencent.mobileqq.stranger.observer.a
        public void b(boolean isSuccess, PBRepeatMessageField<oidb_0x5d4$DelResult> delResult) {
            boolean equals;
            Intrinsics.checkNotNullParameter(delResult, "delResult");
            Activity activity = cp.this.mActivity;
            com.tencent.aio.main.businesshelper.b bVar = null;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity = null;
            }
            if (activity.isFinishing()) {
                return;
            }
            cp.this.t();
            if (isSuccess) {
                Iterator<oidb_0x5d4$DelResult> it = delResult.get().iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    String valueOf = String.valueOf(it.next().uin.get());
                    SessionInfo sessionInfo = cp.this.mSessionInfo;
                    if (sessionInfo == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                        sessionInfo = null;
                    }
                    equals = StringsKt__StringsJVMKt.equals(valueOf, sessionInfo.f179557e, true);
                    if (equals) {
                        z16 = true;
                    }
                }
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OneWayFriendNtHelper", 2, "StrangerObserver : onDelete , result=" + z16);
                    }
                    ArrayList arrayList = new ArrayList();
                    SessionInfo sessionInfo2 = cp.this.mSessionInfo;
                    if (sessionInfo2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                        sessionInfo2 = null;
                    }
                    String str = sessionInfo2.f179557e;
                    Intrinsics.checkNotNullExpressionValue(str, "mSessionInfo.curFriendUin");
                    arrayList.add(str);
                    QQAppInterface qQAppInterface = cp.this.mApp;
                    if (qQAppInterface == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mApp");
                        qQAppInterface = null;
                    }
                    ChatActivityFacade.M(qQAppInterface, BaseApplication.getContext(), arrayList);
                    IRelationOneWayFriendApi iRelationOneWayFriendApi = (IRelationOneWayFriendApi) QRoute.api(IRelationOneWayFriendApi.class);
                    com.tencent.aio.api.runtime.a aVar = cp.this.mAIOContext;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar = null;
                    }
                    iRelationOneWayFriendApi.deleteOneWayFriendGrayTipsIfNeed(aVar.g().r().c().j());
                    QQAppInterface qQAppInterface2 = cp.this.mApp;
                    if (qQAppInterface2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mApp");
                        qQAppInterface2 = null;
                    }
                    RecentUserProxy m3 = qQAppInterface2.getProxyManager().m();
                    Intrinsics.checkNotNullExpressionValue(m3, "mApp.getProxyManager().getRecentUserProxy()");
                    SessionInfo sessionInfo3 = cp.this.mSessionInfo;
                    if (sessionInfo3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                        sessionInfo3 = null;
                    }
                    String str2 = sessionInfo3.f179557e;
                    SessionInfo sessionInfo4 = cp.this.mSessionInfo;
                    if (sessionInfo4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                        sessionInfo4 = null;
                    }
                    RecentUser findRecentUserByUin = m3.findRecentUserByUin(str2, sessionInfo4.f179555d);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("OneWayFriendNtHelper", 4, "StrangerObserver, delete Recent user");
                    }
                    m3.delRecentUser(findRecentUserByUin);
                    QQToastUtil.showQQToastInUiThread(2, HardCodeUtil.qqStr(R.string.hn_));
                    com.tencent.aio.main.businesshelper.b bVar2 = cp.this.mHelperParam;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    } else {
                        bVar = bVar2;
                    }
                    bVar.a().e().h(new ExternalCommIntent("close_aio", new Bundle()));
                    return;
                }
                return;
            }
            QQToastUtil.showQQToastInUiThread(2, HardCodeUtil.qqStr(R.string.hn8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(cp this$0, int i3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            QLog.e("OneWayFriendNtHelper", 1, "addLocalGrayTip is error! result is " + i3);
            return;
        }
        com.tencent.relation.common.utils.i c16 = com.tencent.relation.common.utils.i.c();
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        c16.j(aVar.g().r().c().j(), j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(boolean isOneWayFriend) {
        String str;
        int i3;
        if (!isOneWayFriend) {
            if (QLog.isColorLevel()) {
                QLog.d("OneWayFriendNtHelper", 1, "not single way add allow insert grayTips!");
                return;
            }
            return;
        }
        SessionInfo sessionInfo = this.mSessionInfo;
        SessionInfo sessionInfo2 = null;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        if (1024 == sessionInfo.f179555d) {
            if (QLog.isColorLevel()) {
                QLog.d("OneWayFriendNtHelper", 1, "not allow insert grayTips! this uin type is UIN_TYPE_BUSINESS_CMR_TMP!");
                return;
            }
            return;
        }
        IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        int localSelfAddFriendSetting = iAddFriendApi.getLocalSelfAddFriendSetting(qQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d("OneWayFriendNtHelper", 1, "single way add allow insert grayTips settingValue:" + localSelfAddFriendSetting);
        }
        if (localSelfAddFriendSetting == 0 || localSelfAddFriendSetting == 3) {
            if (localSelfAddFriendSetting == 0) {
                str = AppConstants.Preferences.SINGLE_WAY_FRIEND_ADD_ALLOW_LIST;
                i3 = MessageRecord.MSG_TYPE_SINGLE_WAY_FRIEND_ADD_ALLOW_ALL_MSG;
            } else {
                str = AppConstants.Preferences.SINGLE_WAY_FRIEND_LIST;
                i3 = MessageRecord.MSG_TYPE_SINGLE_WAY_FRIEND_MSG;
            }
            Activity activity = this.mActivity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity = null;
            }
            SessionInfo sessionInfo3 = this.mSessionInfo;
            if (sessionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo3 = null;
            }
            if (ChatActivityUtils.O(activity, sessionInfo3, str)) {
                return;
            }
            com.tencent.relation.common.utils.i c16 = com.tencent.relation.common.utils.i.c();
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            boolean z16 = c16.d(aVar.g().r().c().j()) != 0;
            if (QLog.isColorLevel()) {
                QLog.d("OneWayFriendNtHelper", 1, "single way add allow insert grayTips  hasInserted:" + z16);
            }
            if (z16) {
                return;
            }
            Activity activity2 = this.mActivity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity2 = null;
            }
            SessionInfo sessionInfo4 = this.mSessionInfo;
            if (sessionInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo2 = sessionInfo4;
            }
            ChatActivityUtils.K(activity2, sessionInfo2, str);
            z(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(String addUin) {
        SessionInfo sessionInfo = this.mSessionInfo;
        Activity activity = null;
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
                Activity activity2 = this.mActivity;
                if (activity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                } else {
                    activity = activity2;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.cj
                    @Override // java.lang.Runnable
                    public final void run() {
                        cp.E(cp.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(cp this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(cp this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(cp this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        try {
            QQProgressDialog qQProgressDialog = this.mProgressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
        } catch (Exception unused) {
            QLog.e("OneWayFriendNtHelper", 1, "dialogDismiss is exception!");
        }
    }

    private final void x(Resources resources) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.cn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cp.y(cp.this, view);
            }
        };
        Activity activity = this.mActivity;
        com.tencent.aio.api.runtime.a aVar = null;
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
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity2 = null;
        }
        G(new DrawableCenterTextView(activity2));
        v().setTextSize(0, resources.getDimension(R.dimen.f158274c0));
        v().setText(HardCodeUtil.qqStr(R.string.hn7));
        v().setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.qui_unlink), (Drawable) null, (Drawable) null, (Drawable) null);
        v().setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, resources));
        v().setOnClickListener(onClickListener);
        v().setTag(4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Activity activity3 = this.mActivity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity3 = null;
        }
        View view = new View(activity3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, -1);
        Activity activity4 = this.mActivity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity4 = null;
        }
        F(new DrawableCenterTextView(activity4));
        u().setText(HardCodeUtil.qqStr(R.string.f170193ik));
        TextView u16 = u();
        Activity activity5 = this.mActivity;
        if (activity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity5 = null;
        }
        u16.setTextSize(0, activity5.getResources().getDimensionPixelSize(R.dimen.f158274c0));
        Activity activity6 = this.mActivity;
        if (activity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity6 = null;
        }
        u().setCompoundDrawablesWithIntrinsicBounds(activity6.getResources().getDrawable(R.drawable.qui_add_friend), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView u17 = u();
        Activity activity7 = this.mActivity;
        if (activity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity7 = null;
        }
        u17.setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, activity7.getResources()));
        u().setContentDescription(u().getText());
        u().setOnClickListener(onClickListener);
        u().setTag(3);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        if (ThemeUtil.isDefaultTheme()) {
            view.setBackgroundColor(Color.parseColor("#d3d5dc"));
            v().setTextColor(resources.getColorStateList(R.color.afd));
            TextView u18 = u();
            Activity activity8 = this.mActivity;
            if (activity8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity8 = null;
            }
            u18.setTextColor(activity8.getResources().getColorStateList(R.color.afd));
        } else {
            Activity activity9 = this.mActivity;
            if (activity9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity9 = null;
            }
            view.setBackgroundColor(activity9.getResources().getColor(R.color.qq_profilecard_btns_divider));
            v().setTextColor(resources.getColorStateList(R.color.skin_float_btn));
            TextView u19 = u();
            Activity activity10 = this.mActivity;
            if (activity10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity10 = null;
            }
            u19.setTextColor(activity10.getResources().getColorStateList(R.color.skin_float_btn));
        }
        v().setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        u().setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        LinearLayout linearLayout3 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.addView(v(), layoutParams);
        LinearLayout linearLayout4 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout4);
        linearLayout4.addView(view, layoutParams2);
        LinearLayout linearLayout5 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout5);
        linearLayout5.addView(u(), layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(10);
        layoutParams4.width = ViewUtils.getScreenWidth();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        LinearLayout linearLayout6 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout6);
        e16.h(new TroopShortcutBarEvent.SetShortcutView(0, linearLayout6, layoutParams4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(cp this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view.getTag();
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num != null) {
            int intValue = num.intValue();
            if (com.tencent.mobileqq.activity.aio.a.a()) {
                return;
            }
            if (intValue == 3) {
                this$0.s();
            } else {
                if (intValue != 4) {
                    return;
                }
                this$0.I();
            }
        }
    }

    private final void z(int msgType) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        QQAppInterface qQAppInterface = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(aVar.g().r().c().j(), 1, 1011L, 1, true, false, null, 96, null);
        if (msgType == -7006) {
            String qqStr = HardCodeUtil.qqStr(R.string.f227826s3);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.single_wa\u2026nd_add_allow_tips_prefix)");
            LocalGrayTip.LocalGrayTipBuilder i3 = LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, qqStr, 0, 2, null);
            String qqStr2 = HardCodeUtil.qqStr(R.string.hnc);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.single_wa\u2026d_add_allow_tips_keyword)");
            LocalGrayTip.LocalGrayTipBuilder.f(i3, qqStr2, this.FRIEND_SETTING_SCHEMA, 0, 4, null);
        } else if (msgType == -2019) {
            String qqStr3 = HardCodeUtil.qqStr(R.string.hnd);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.single_way_friend_tips)");
            LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, qqStr3, 0, 2, null);
        }
        INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
        QQAppInterface qQAppInterface2 = this.mApp;
        if (qQAppInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
        } else {
            qQAppInterface = qQAppInterface2;
        }
        iNtGrayTipApi.addLocalGrayTip(qQAppInterface, localGrayTipBuilder.m(), new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.qqnt.aio.helper.cm
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
            public final void onResult(int i16, long j3) {
                cp.A(cp.this, i16, j3);
            }
        });
    }

    public final void C() {
        QQAppInterface qQAppInterface = this.mApp;
        SessionInfo sessionInfo = null;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        SessionInfo sessionInfo2 = this.mSessionInfo;
        if (sessionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo2 = null;
        }
        int i3 = sessionInfo2.f179555d;
        SessionInfo sessionInfo3 = this.mSessionInfo;
        if (sessionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo3 = null;
        }
        boolean a16 = com.tencent.mobileqq.relationx.onewayfriend.a.a(qQAppInterface, i3, sessionInfo3.f179557e);
        if (a16) {
            QQAppInterface qQAppInterface2 = this.mApp;
            if (qQAppInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface2 = null;
            }
            BusinessHandler businessHandler = qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.ONE_WAY_FRIEND_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHandler");
            OneWayFriendHandler oneWayFriendHandler = (OneWayFriendHandler) businessHandler;
            SessionInfo sessionInfo4 = this.mSessionInfo;
            if (sessionInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo = sessionInfo4;
            }
            oneWayFriendHandler.D2(StringUtil.stringToLong("OneWayFriendNtHelper", sessionInfo.f179557e));
            return;
        }
        K(a16);
        B(a16);
    }

    public final void F(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.addFriendTv = textView;
    }

    public final void G(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.blackTv = textView;
    }

    public final void H() {
        if (QLog.isColorLevel()) {
            QLog.d("OneWayFriendNtHelper", 2, "showOneWayFriendView() ==== called.");
        }
        if (this.linearLayout == null) {
            QQAppInterface qQAppInterface = this.mApp;
            if (qQAppInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface = null;
            }
            Resources resources = qQAppInterface.getApplication().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "mApp.application.resources");
            x(resources);
        }
        LinearLayout linearLayout = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(0);
    }

    public final void I() {
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
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.co
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                cp.J(cp.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
        ReportController.o(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350683w0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "OneWayFriendNtHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParam = param;
        this.mAIOContext = param.a();
        FragmentActivity requireActivity = param.a().c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "param.aioContext.fragment.requireActivity()");
        this.mActivity = requireActivity;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
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
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    public final void s() {
        QQAppInterface qQAppInterface;
        Activity activity;
        SessionInfo sessionInfo;
        QQAppInterface qQAppInterface2 = this.mApp;
        SessionInfo sessionInfo2 = null;
        if (qQAppInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        } else {
            qQAppInterface = qQAppInterface2;
        }
        SessionInfo sessionInfo3 = this.mSessionInfo;
        if (sessionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo3 = null;
        }
        ReportController.o(qQAppInterface, "CliOper", "", sessionInfo3.f179557e, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        } else {
            activity = activity2;
        }
        SessionInfo sessionInfo4 = this.mSessionInfo;
        if (sessionInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        } else {
            sessionInfo = sessionInfo4;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.button_back);
        Activity activity3 = this.mActivity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity3 = null;
        }
        boolean z16 = activity3.getIntent().getStringExtra("param_return_addr") != null;
        SessionInfo sessionInfo5 = this.mSessionInfo;
        if (sessionInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
        } else {
            sessionInfo2 = sessionInfo5;
        }
        ChatActivityUtils.e(activity, sessionInfo, qqStr, z16, true, sessionInfo2.f179557e);
    }

    public final TextView u() {
        TextView textView = this.addFriendTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addFriendTv");
        return null;
    }

    public final TextView v() {
        TextView textView = this.blackTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blackTv");
        return null;
    }

    public final void w() {
        if (QLog.isColorLevel()) {
            QLog.i("OneWayFriendNtHelper", 1, "hideOneWayFriendHelper will executed!");
        }
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(8);
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            LinearLayout linearLayout2 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout2);
            e16.h(new TroopShortcutBarEvent.RemoveShortcutView(linearLayout2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(boolean isOneWayFriend) {
        Activity activity = null;
        if (isOneWayFriend) {
            if (QLog.isColorLevel()) {
                QLog.i("OneWayFriendNtHelper", 2, "updateOneWayFriendView true");
            }
            Activity activity2 = this.mActivity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            } else {
                activity = activity2;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ck
                @Override // java.lang.Runnable
                public final void run() {
                    cp.L(cp.this);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("OneWayFriendNtHelper", 2, "updateOneWayFriendView false");
        }
        Activity activity3 = this.mActivity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        } else {
            activity = activity3;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.cl
            @Override // java.lang.Runnable
            public final void run() {
                cp.M(cp.this);
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 4, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QQAppInterface qQAppInterface = null;
        if (state == 0) {
            QQAppInterface qQAppInterface2 = this.mApp;
            if (qQAppInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface2 = null;
            }
            qQAppInterface2.addObserver(this.mObserver);
            QQAppInterface qQAppInterface3 = this.mApp;
            if (qQAppInterface3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface3 = null;
            }
            qQAppInterface3.addObserver(this.friendListObserver);
            QQAppInterface qQAppInterface4 = this.mApp;
            if (qQAppInterface4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
            } else {
                qQAppInterface = qQAppInterface4;
            }
            qQAppInterface.addObserver(this.singleDirectionFriendObserver);
            return;
        }
        if (state == 4) {
            C();
            return;
        }
        if (state != 12) {
            return;
        }
        w();
        QQAppInterface qQAppInterface5 = this.mApp;
        if (qQAppInterface5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface5 = null;
        }
        qQAppInterface5.removeObserver(this.mObserver);
        QQAppInterface qQAppInterface6 = this.mApp;
        if (qQAppInterface6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface6 = null;
        }
        qQAppInterface6.removeObserver(this.friendListObserver);
        QQAppInterface qQAppInterface7 = this.mApp;
        if (qQAppInterface7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
        } else {
            qQAppInterface = qQAppInterface7;
        }
        qQAppInterface.removeObserver(this.singleDirectionFriendObserver);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(cp this$0, ActionSheet actionSheet, View view, int i3) {
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
                    QLog.d("OneWayFriendNtHelper", 2, "delete Stranger parseLong() error", e16);
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
}
