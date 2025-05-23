package com.tencent.qqnt.aio.helper.gamecenter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.AIOInputSendBtn;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.GameGlobalData;
import com.tencent.mobileqq.gamecenter.nt.aio.bottom.GameMsgBottomBarEvent;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.helper.gamecenter.u;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import p03.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002gk\u0018\u0000 q2\u00020\u0001:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\u001a\u0010#\u001a\u00020\t2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 H\u0002J\b\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001bH\u0016J\u000e\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\tR\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010AR\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010FR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010IR\u0016\u0010M\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010m\u00a8\u0006s"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/u;", "Lcom/tencent/aio/main/businesshelper/h;", "", "t", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "", "p", "", "v", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "y", "G", "Lcom/tencent/mobileqq/app/QQAppInterface;", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "Landroid/widget/PopupWindow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "I", ViewStickEventHelper.IS_SHOW, UserInfo.SEX_FEMALE, "", "retCode", "", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/mobileqq/gamecenter/data/n;", "list", "u", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "isShowPartnerUI", "B", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mRootView", "e", "mLayoutApplyPartner", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "mLayoutPartnerGuide", tl.h.F, "Landroid/widget/PopupWindow;", "mGuidePopupWindow", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "i", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "mAIOEditText", "Lcom/tencent/mobileqq/aio/input/AIOInputSendBtn;", "Lcom/tencent/mobileqq/aio/input/AIOInputSendBtn;", "mAIOInputSendBtn", "Z", "mIsChatAioDestroyed", "Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData;", "Lcom/tencent/mobileqq/gamecenter/data/GameGlobalData;", "mGameGlobal", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "mSessionInfo", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "mCustomParam", "Lorg/json/JSONObject;", "H", "Lorg/json/JSONObject;", "mExtParams", "Ljava/lang/String;", "mPeerUid", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "J", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "mMsgApi", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "K", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "mGameMsgManager", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "L", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "mGameSession", "Landroid/view/View$OnClickListener;", "M", "Landroid/view/View$OnClickListener;", "mClickListener", "com/tencent/qqnt/aio/helper/gamecenter/u$d", "N", "Lcom/tencent/qqnt/aio/helper/gamecenter/u$d;", "mRequestCallback", "com/tencent/qqnt/aio/helper/gamecenter/u$c", "P", "Lcom/tencent/qqnt/aio/helper/gamecenter/u$c;", "mPartnerListener", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class u implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private volatile boolean mIsChatAioDestroyed;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: F, reason: from kotlin metadata */
    private SessionInfo mSessionInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private Bundle mCustomParam;

    /* renamed from: H, reason: from kotlin metadata */
    private JSONObject mExtParams;

    /* renamed from: J, reason: from kotlin metadata */
    private final IGameMsgNtApi mMsgApi;

    /* renamed from: K, reason: from kotlin metadata */
    private IGameMsgManagerService mGameMsgManager;

    /* renamed from: L, reason: from kotlin metadata */
    private TempChatGameSession mGameSession;

    /* renamed from: M, reason: from kotlin metadata */
    private final View.OnClickListener mClickListener;

    /* renamed from: N, reason: from kotlin metadata */
    private final d mRequestCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private final c mPartnerListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mLayoutApplyPartner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mLayoutPartnerGuide;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PopupWindow mGuidePopupWindow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AIOEditText mAIOEditText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AIOInputSendBtn mAIOInputSendBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private final GameGlobalData mGameGlobal = GameGlobalData.INSTANCE.a();

    /* renamed from: I, reason: from kotlin metadata */
    private String mPeerUid = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/u$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            AIOInputSendBtn aIOInputSendBtn = u.this.mAIOInputSendBtn;
            if (aIOInputSendBtn == null) {
                return;
            }
            aIOInputSendBtn.setEnabled(!TextUtils.isEmpty(s16));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/u$c", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService$a;", "", "Lcom/tencent/mobileqq/gamecenter/data/n;", "list", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements IGameMsgManagerService.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(u this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.mIsChatAioDestroyed) {
                return;
            }
            this$0.q();
        }

        @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService.a
        public void a(List<com.tencent.mobileqq.gamecenter.data.n> list) {
            if (u.this.u(list)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final u uVar = u.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.c.c(u.this);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/u$d", "Lcom/tencent/mobileqq/gamecenter/api/g;", "", "retCode", "", "errMsg", "", "b", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.gamecenter.api.g {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(u this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.mIsChatAioDestroyed) {
                return;
            }
            this$0.A(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(u this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.mIsChatAioDestroyed) {
                return;
            }
            this$0.C(j3);
        }

        @Override // com.tencent.mobileqq.gamecenter.api.g
        public void a(final long retCode, String errMsg) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final u uVar = u.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.x
                @Override // java.lang.Runnable
                public final void run() {
                    u.d.f(u.this, retCode);
                }
            });
        }

        @Override // com.tencent.mobileqq.gamecenter.api.g
        public void b(final long retCode, String errMsg) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final u uVar = u.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.w
                @Override // java.lang.Runnable
                public final void run() {
                    u.d.e(u.this, retCode);
                }
            });
        }
    }

    public u() {
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        this.mMsgApi = (IGameMsgNtApi) api;
        this.mClickListener = new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.w(u.this, view);
            }
        };
        this.mRequestCallback = new d();
        this.mPartnerListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(long retCode) {
        int o16 = o(retCode);
        if (retCode == 0) {
            o16 = R.string.f13605034;
        } else if (o16 == 0) {
            o16 = R.string.f13602031;
        }
        QQToast.makeText(BaseApplication.getContext(), o16, 0).show();
    }

    private final void D() {
        Editable text;
        AIOEditText aIOEditText = this.mAIOEditText;
        SessionInfo sessionInfo = null;
        String obj = (aIOEditText == null || (text = aIOEditText.getText()) == null) ? null : text.toString();
        if (obj == null || obj.length() == 0) {
            return;
        }
        IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
        if (iGameMsgManagerService != null) {
            SessionInfo sessionInfo2 = this.mSessionInfo;
            if (sessionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo2 = null;
            }
            String e16 = sessionInfo2.e();
            SessionInfo sessionInfo3 = this.mSessionInfo;
            if (sessionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo = sessionInfo3;
            }
            String c16 = sessionInfo.c();
            Intrinsics.checkNotNull(obj);
            iGameMsgManagerService.sendApplyPartnerMessage(e16, c16, obj, this.mRequestCallback);
        }
        AIOEditText aIOEditText2 = this.mAIOEditText;
        if (aIOEditText2 != null) {
            aIOEditText2.setText("");
        }
    }

    private final void E() {
        LinearLayout linearLayout = this.mRootView;
        if (linearLayout != null) {
            com.tencent.aio.api.runtime.a aVar = this.mAioContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            if (e16 != null) {
                e16.h(new GameMsgBottomBarEvent.RemoveBottomView(linearLayout));
            }
        }
    }

    private final void G() {
        if (this.mRootView != null || this.mIsChatAioDestroyed) {
            return;
        }
        this.mGameGlobal.k(true);
        F(false);
        t();
        a.Companion companion = p03.a.INSTANCE;
        QQAppInterface n3 = n();
        p03.a a16 = companion.a(n3 != null ? n3.getCurrentUin() : null);
        if (!a16.c("game_msg_partner_is_show_guide", false)) {
            a16.h("game_msg_partner_is_show_guide", true);
            I();
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.s
                @Override // java.lang.Runnable
                public final void run() {
                    u.H(u.this);
                }
            }, 10000L);
        }
        IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
        if (iGameMsgManagerService != null) {
            iGameMsgManagerService.addRecentPartnerListener(this.mPartnerListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(u this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    private final void I() {
        LinearLayout linearLayout = this.mLayoutApplyPartner;
        if (linearLayout != null) {
            linearLayout.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.gamecenter.t
                @Override // java.lang.Runnable
                public final void run() {
                    u.J(u.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(u this$0) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mIsChatAioDestroyed) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this$0.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        FragmentActivity activity = c16 != null ? c16.getActivity() : null;
        if (activity == null || activity.isFinishing() || (linearLayout = this$0.mLayoutApplyPartner) == null) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        if (linearLayout.isAttachedToWindow()) {
            try {
                PopupWindow m3 = this$0.m(activity);
                this$0.mGuidePopupWindow = m3;
                if (m3 != null) {
                    View view = this$0.mLayoutApplyPartner;
                    Intrinsics.checkNotNull(view);
                    m3.showAsDropDown(view, 0, -ViewUtils.dpToPx(54.0f));
                }
            } catch (Throwable th5) {
                QLog.e("GameMsgPartnerHelper", 1, "[showGuidePopupWindow] e:", th5);
            }
        }
    }

    private final PopupWindow m(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dv5, (ViewGroup) null, false);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f166019yf0);
        this.mLayoutPartnerGuide = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this.mClickListener);
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        return popupWindow;
    }

    private final QQAppInterface n() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final int o(long retCode) {
        if (retCode == 80009) {
            return R.string.f1361103_;
        }
        if (retCode == 80010) {
            return R.string.f1361203a;
        }
        if (retCode == 80011) {
            return R.string.f13610039;
        }
        if (retCode == 80012) {
            return R.string.f1361703f;
        }
        if (retCode == 80013) {
            return R.string.f1361603e;
        }
        if (retCode == 80014) {
            return R.string.f1361803g;
        }
        if (retCode == 80015) {
            return R.string.f13608037;
        }
        if (retCode == 80016) {
            return R.string.f13609038;
        }
        if (retCode == 80017) {
            return R.string.f1361303b;
        }
        if (retCode == 80018) {
            return R.string.f1361503d;
        }
        if (retCode == 80019) {
            return R.string.f1361403c;
        }
        return 0;
    }

    private final String p() {
        TempChatGameSession tempChatGameSession = this.mGameSession;
        if (tempChatGameSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGameSession");
            tempChatGameSession = null;
        }
        return String.valueOf(tempChatGameSession.gameAppId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        LinearLayout linearLayout = this.mRootView;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            E();
            F(true);
            IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
            if (iGameMsgManagerService != null) {
                iGameMsgManagerService.removeRecentPartnerListener(this.mPartnerListener);
            }
            this.mRootView = null;
        }
    }

    private final void r() {
        if (this.mIsChatAioDestroyed) {
            return;
        }
        try {
            RelativeLayout relativeLayout = this.mLayoutPartnerGuide;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(null);
            }
            PopupWindow popupWindow = this.mGuidePopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            this.mGuidePopupWindow = null;
        } catch (Throwable th5) {
            QLog.e("GameMsgPartnerHelper", 1, "[hideGuidePopupWindow] e:", th5);
        }
    }

    private final void s() {
        this.mGameGlobal.k(false);
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        Bundle bundle = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        this.mCustomParam = l3;
        if (l3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            l3 = null;
        }
        String string = l3.getString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, "");
        Bundle bundle2 = this.mCustomParam;
        if (bundle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle2 = null;
        }
        String string2 = bundle2.getString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, "");
        Bundle bundle3 = this.mCustomParam;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle3 = null;
        }
        String string3 = bundle3.getString("key_peerId", "");
        Intrinsics.checkNotNullExpressionValue(string3, "mCustomParam.getString(C\u2026Constants.KEY_PEERID, \"\")");
        this.mPeerUid = string3;
        IGameMsgNtApi iGameMsgNtApi = this.mMsgApi;
        Bundle bundle4 = this.mCustomParam;
        if (bundle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
            bundle4 = null;
        }
        this.mGameSession = iGameMsgNtApi.getGameSessionFromPeerUidOrJson(string3, bundle4.getString(AppConstants.Key.KEY_GAME_MSG_SESSION, ""));
        SessionInfo sessionInfo = this.mSessionInfo;
        if (sessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo = null;
        }
        sessionInfo.j(string);
        SessionInfo sessionInfo2 = this.mSessionInfo;
        if (sessionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            sessionInfo2 = null;
        }
        sessionInfo2.k(string2);
        Bundle bundle5 = this.mCustomParam;
        if (bundle5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomParam");
        } else {
            bundle = bundle5;
        }
        String string4 = bundle.getString(AppConstants.Key.KEY_GAME_MSG_EXT_PARAMS);
        if (string4 != null) {
            try {
                if (TextUtils.isEmpty(string4)) {
                    return;
                }
                this.mExtParams = new JSONObject(string4);
            } catch (JSONException e16) {
                QLog.e("GameMsgPartnerHelper", 1, "parse ext params e:", e16);
            }
        }
    }

    private final void t() {
        com.tencent.aio.api.runtime.a aVar = null;
        View inflate = View.inflate(BaseApplication.getContext(), R.layout.dv6, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.mRootView = linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setId(R.id.yec);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.yea);
        this.mLayoutApplyPartner = linearLayout2;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this.mClickListener);
        }
        AIOEditText aIOEditText = (AIOEditText) linearLayout.findViewById(R.id.vhp);
        this.mAIOEditText = aIOEditText;
        if (aIOEditText != null) {
            aIOEditText.addTextChangedListener(new b());
        }
        AIOInputSendBtn aIOInputSendBtn = (AIOInputSendBtn) linearLayout.findViewById(R.id.vhq);
        this.mAIOInputSendBtn = aIOInputSendBtn;
        if (aIOInputSendBtn != null) {
            aIOInputSendBtn.setOnClickListener(this.mClickListener);
        }
        AIOInputSendBtn aIOInputSendBtn2 = this.mAIOInputSendBtn;
        if (aIOInputSendBtn2 != null) {
            aIOInputSendBtn2.setEnabled(false);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 8388659;
        com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        } else {
            aVar = aVar2;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(new GameMsgBottomBarEvent.AddBottomView(0, linearLayout, layoutParams));
        }
    }

    private final boolean v() {
        JSONObject jSONObject;
        List<com.tencent.mobileqq.gamecenter.data.n> recentPartnerList;
        IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
        return (iGameMsgManagerService == null || (recentPartnerList = iGameMsgManagerService.getRecentPartnerList()) == null || !u(recentPartnerList)) && (jSONObject = this.mExtParams) != null && jSONObject.optBoolean("is_show_partner_ui");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int id5 = view.getId();
        if (id5 == R.id.vhq) {
            this$0.D();
        } else if (id5 == R.id.yea) {
            this$0.z();
        } else {
            if (id5 != R.id.f166019yf0) {
                return;
            }
            this$0.r();
        }
    }

    private final void x() {
        s();
        if (v()) {
            G();
        }
        QLog.i("GameMsgPartnerHelper", 1, "[doOnAIOCreate]");
    }

    private final void y() {
        r();
        IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
        if (iGameMsgManagerService != null) {
            iGameMsgManagerService.removeRecentPartnerListener(this.mPartnerListener);
        }
        IGameMsgManagerService iGameMsgManagerService2 = this.mGameMsgManager;
        if (iGameMsgManagerService2 != null) {
            iGameMsgManagerService2.removeGameMsgPartnerCallback();
        }
        this.mGameGlobal.i();
        this.mIsChatAioDestroyed = true;
    }

    private final void z() {
        IGameMsgManagerService iGameMsgManagerService = this.mGameMsgManager;
        if (iGameMsgManagerService != null) {
            SessionInfo sessionInfo = this.mSessionInfo;
            SessionInfo sessionInfo2 = null;
            if (sessionInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                sessionInfo = null;
            }
            String e16 = sessionInfo.e();
            SessionInfo sessionInfo3 = this.mSessionInfo;
            if (sessionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            } else {
                sessionInfo2 = sessionInfo3;
            }
            iGameMsgManagerService.applyPartner(e16, sessionInfo2.c(), this.mRequestCallback);
        }
        r();
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(p(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "958247", "", "", "20", "");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.Y;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameMsgPartnerHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAioContext.aioParam");
        this.mSessionInfo = su3.b.a(g16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.mGameMsgManager = peekAppRuntime != null ? (IGameMsgManagerService) peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "") : null;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgPartnerHelper", 2, "[onMoveToState] state:" + state);
        }
        if (state == 0) {
            x();
        } else {
            if (state != 12) {
                return;
            }
            y();
        }
    }

    private final void F(boolean isShow) {
        com.tencent.aio.api.runtime.a aVar = null;
        if (!isShow) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
                aVar2 = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar2.e();
            if (e16 != null) {
                e16.h(InputEvent.InputHide.f188577d);
            }
            com.tencent.aio.api.runtime.a aVar3 = this.mAioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            } else {
                aVar = aVar3;
            }
            com.tencent.mvi.base.route.j e17 = aVar.e();
            if (e17 != null) {
                e17.h(InputEvent.AIOShortcutBarHide.f188562d);
                return;
            }
            return;
        }
        com.tencent.aio.api.runtime.a aVar4 = this.mAioContext;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            aVar4 = null;
        }
        com.tencent.mvi.base.route.j e18 = aVar4.e();
        if (e18 != null) {
            e18.h(InputEvent.InputShow.f188578d);
        }
        com.tencent.aio.api.runtime.a aVar5 = this.mAioContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        } else {
            aVar = aVar5;
        }
        com.tencent.mvi.base.route.j e19 = aVar.e();
        if (e19 != null) {
            e19.h(InputEvent.AIOShortcutBarShow.f188563d);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    public final void B(boolean isShowPartnerUI) {
        if (isShowPartnerUI) {
            G();
        } else {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0009 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(List<com.tencent.mobileqq.gamecenter.data.n> list) {
        boolean z16;
        boolean z17;
        String toRoleId;
        String fromRoleId;
        if (list != null) {
            for (com.tencent.mobileqq.gamecenter.data.n nVar : list) {
                SessionInfo sessionInfo = null;
                if (nVar != null && (fromRoleId = nVar.getFromRoleId()) != null) {
                    SessionInfo sessionInfo2 = this.mSessionInfo;
                    if (sessionInfo2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                        sessionInfo2 = null;
                    }
                    if (fromRoleId.equals(sessionInfo2.e())) {
                        z16 = true;
                        if (z16) {
                            if (nVar != null && (toRoleId = nVar.getToRoleId()) != null) {
                                SessionInfo sessionInfo3 = this.mSessionInfo;
                                if (sessionInfo3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
                                } else {
                                    sessionInfo = sessionInfo3;
                                }
                                if (toRoleId.equals(sessionInfo.c())) {
                                    z17 = true;
                                    if (z17) {
                                        if (nVar != null && nVar.getCom.tencent.mobileqq.shortvideo.ShortVideoConstants.PARAM_KEY_SESSION_TYPE java.lang.String() == com.tencent.mobileqq.gamecenter.data.n.INSTANCE.a()) {
                                            return true;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            z17 = false;
                            if (z17) {
                            }
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long retCode) {
        if (retCode == 0) {
            return;
        }
        int o16 = o(retCode);
        if (o16 == 0) {
            o16 = R.string.f1365304e;
        }
        QQToast.makeText(BaseApplication.getContext(), o16, 0).show();
    }
}
