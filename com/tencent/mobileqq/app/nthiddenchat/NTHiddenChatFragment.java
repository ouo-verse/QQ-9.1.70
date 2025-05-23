package com.tencent.mobileqq.app.nthiddenchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.miniaio.h;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u000f\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/app/nthiddenchat/NTHiddenChatFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUserParam;", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "initTitleBar", "", "hasFocus", "onWindowFocusChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isWrapContent", "", "getContentLayoutId", "view", NodeProps.ON_CLICK, "onBackEvent", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chats/core/mvi/a;", "mHiddenChatsVM", "Lcom/tencent/qqnt/chats/biz/hiddenchat/a;", "D", "Lcom/tencent/qqnt/chats/biz/hiddenchat/a;", "mHiddenChatsVB", "Lcom/tencent/mobileqq/app/QQAppInterface;", "E", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;", "mMiniMsg", "Lcom/tencent/mobileqq/troop/troopsetting/api/b;", "G", "Lcom/tencent/mobileqq/troop/troopsetting/api/b;", "troopSettingObserver", "<init>", "()V", "H", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NTHiddenChatFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String I;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mHiddenChatsVM;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.biz.hiddenchat.a mHiddenChatsVB;

    /* renamed from: E, reason: from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MiniMsgUser mMiniMsg;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopsetting.api.b troopSettingObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/app/nthiddenchat/NTHiddenChatFragment$a;", "", "Landroid/content/Context;", "context", "", IProfileCardConst.KEY_FROM_TYPE, "Landroid/content/Intent;", "intent", "", "a", "", "EXTRA_FROM_TYPE", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.nthiddenchat.NTHiddenChatFragment$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

        @JvmStatic
        public final void a(@NotNull Context context, int fromType, @NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(fromType), intent);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            intent.putExtra("FromType", fromType);
            intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154445lb);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, R.anim.f154449lf);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, R.anim.f154435l2);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, R.anim.f154436l4);
            QLog.d(NTHiddenChatFragment.I, 1, "startNTHiddenChatFragmentFragment");
            QPublicFragmentActivity.startForResult((Activity) context, intent, (Class<? extends QPublicBaseFragment>) NTHiddenChatFragment.class, 0);
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
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/app/nthiddenchat/NTHiddenChatFragment$b", "Lcom/tencent/mobileqq/troop/troopsetting/api/b;", "", "isSuccess", "", "troopUin", "memberUin", "", "op", "type", "", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends com.tencent.mobileqq.troop.troopsetting.api.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHiddenChatFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsetting.api.b
        protected void c(boolean isSuccess, @NotNull String troopUin, @NotNull String memberUin, int op5, int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, memberUin, Integer.valueOf(op5), Integer.valueOf(type));
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            if (type == 512 && isSuccess) {
                QQAppInterface qQAppInterface = NTHiddenChatFragment.this.mApp;
                QQAppInterface qQAppInterface2 = null;
                if (qQAppInterface == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mApp");
                    qQAppInterface = null;
                }
                Manager manager = qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
                TroopInfo k3 = ((TroopManager) manager).k(troopUin);
                QQAppInterface qQAppInterface3 = NTHiddenChatFragment.this.mApp;
                if (qQAppInterface3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mApp");
                } else {
                    qQAppInterface2 = qQAppInterface3;
                }
                com.tencent.mobileqq.app.hiddenchat.c.a(qQAppInterface2, k3);
                if (QLog.isColorLevel()) {
                    QLog.d(NTHiddenChatFragment.I, 2, "onSetHiddenChatSwitch troopUin=" + troopUin);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
            I = "NTHiddenChatFragment";
        }
    }

    public NTHiddenChatFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopSettingObserver = new b();
        }
    }

    private final View createView() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.evx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.drag_area)");
        DragFrameLayout dragFrameLayout = (DragFrameLayout) findViewById;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mHiddenChatsVM;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVM");
            aVar = null;
        }
        com.tencent.qqnt.chats.biz.hiddenchat.a aVar3 = new com.tencent.qqnt.chats.biz.hiddenchat.a(aVar, new com.tencent.qqnt.chats.biz.hiddenchat.c());
        this.mHiddenChatsVB = aVar3;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.tug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.chats_list)");
        View findViewById3 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.evx);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewByI\u2026ag_area\n                )");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        aVar3.d0(new ChatsListVB.b((RecyclerView) findViewById2, (QUIBadgeDragLayout) findViewById3, null, requireContext, null, null, null, null, 240, null));
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar4 = this.mHiddenChatsVM;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVM");
            aVar4 = null;
        }
        com.tencent.qqnt.chats.biz.hiddenchat.a aVar5 = this.mHiddenChatsVB;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVB");
            aVar5 = null;
        }
        aVar4.d(aVar5);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar6 = this.mHiddenChatsVM;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVM");
        } else {
            aVar2 = aVar6;
        }
        aVar2.o(b.c.f355083a);
        return dragFrameLayout;
    }

    private final MiniMsgUserParam qh() {
        Drawable drawable = getQBaseActivity().getApplication().getResources().getDrawable(R.drawable.qui_message);
        Intrinsics.checkNotNullExpressionValue(drawable, "qBaseActivity.applicatio\u2026n.R.drawable.qui_message)");
        TextPaint paint = this.rightViewText.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "rightViewText.paint");
        int measureText = (int) paint.measureText(this.rightViewText.getText().toString());
        int i3 = getQBaseActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
        int dpToPx = ((i3 - (ViewUtils.dpToPx(16.0f) - ((ViewUtils.dpToPx(52.0f) - measureText) / 2))) - ViewUtils.dpToPx(56.0f)) - drawable.getIntrinsicWidth();
        int dip2px = statusBarHeight + ViewUtils.dip2px(5.0f);
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 24;
        miniMsgUserParam.accessType = 0;
        miniMsgUserParam.entryType = 1;
        miniMsgUserParam.positionX = dpToPx;
        miniMsgUserParam.positionY = dip2px;
        miniMsgUserParam.colorType = 1;
        miniMsgUserParam.filterMsgType = 1;
        return miniMsgUserParam;
    }

    @JvmStatic
    public static final void rh(@NotNull Context context, int i3, @NotNull Intent intent) {
        INSTANCE.a(context, i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        initTitleBar();
        createView();
        if (FrameHelperActivity.Gi()) {
            FrameHelperActivity.gj(true, I);
            FrameHelperActivity.Zh();
        }
        if (getQBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            this.mApp = qQAppInterface;
            if (qQAppInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface = null;
            }
            qQAppInterface.addObserver(this.troopSettingObserver);
        }
        this.mMiniMsg = new MiniMsgUser(getQBaseActivity(), qh());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return R.layout.fqb;
    }

    public final void initTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        setTitle(getString(R.string.iwm));
        this.rightViewText.setText(R.string.hhb);
        this.rightViewText.setVisibility(0);
        this.rightViewText.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        boolean onBackEvent = super.onBackEvent();
        com.tencent.mobileqq.app.nthiddenchat.b bVar = com.tencent.mobileqq.app.nthiddenchat.b.f196422a;
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        bVar.b(qBaseActivity, PermissionPrivacyFragmentKotlin.class);
        return onBackEvent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (Intrinsics.areEqual(view, this.rightViewText)) {
            QPublicFragmentActivity.start(getQBaseActivity(), HiddenChatSettingFragment.class);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        MiniMsgUserParam qh5 = qh();
        MiniMsgUser miniMsgUser = this.mMiniMsg;
        if (miniMsgUser != null) {
            miniMsgUser.updateWhenConfigChanged(newConfig, qh5.positionX, qh5.positionY);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        QLog.d(I, 1, "NTHiddenChatFragment.onCreate");
        IChatsViewModelCreator iChatsViewModelCreator = (IChatsViewModelCreator) QRoute.api(IChatsViewModelCreator.class);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.mHiddenChatsVM = (com.tencent.qqnt.chats.core.mvi.a) iChatsViewModelCreator.createHiddenChatViewModel(lifecycleScope, requireContext, new c());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mHiddenChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVM");
            aVar = null;
        }
        aVar.o(b.d.f355084a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mHiddenChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVM");
            aVar2 = null;
        }
        com.tencent.qqnt.chats.biz.hiddenchat.a aVar3 = this.mHiddenChatsVB;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVB");
            aVar3 = null;
        }
        aVar2.m(aVar3);
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        qQAppInterface.removeObserver(this.troopSettingObserver);
        MiniMsgUser miniMsgUser = this.mMiniMsg;
        if (miniMsgUser != null) {
            if (miniMsgUser != null) {
                miniMsgUser.destroy();
            }
            this.mMiniMsg = null;
        }
        MiniMsgIPCClient.getInstance().clearBusiness(24);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        MiniMsgUser miniMsgUser = this.mMiniMsg;
        if (miniMsgUser != null && miniMsgUser != null) {
            miniMsgUser.onBackground();
        }
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mHiddenChatsVM;
        com.tencent.qqnt.chats.biz.hiddenchat.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVM");
            aVar = null;
        }
        aVar.o(b.h.f355088a);
        com.tencent.qqnt.chats.biz.hiddenchat.a aVar3 = this.mHiddenChatsVB;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVB");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.qqnt.chats.api.b v3 = aVar2.v();
        if (v3 != null) {
            View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
            Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
            v3.u(mContentView);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mHiddenChatsVM;
        com.tencent.qqnt.chats.biz.hiddenchat.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVM");
            aVar = null;
        }
        aVar.o(b.i.f355089a);
        MiniMsgUser miniMsgUser = this.mMiniMsg;
        if (miniMsgUser != null && miniMsgUser != null) {
            miniMsgUser.onForeground();
        }
        com.tencent.qqnt.chats.biz.hiddenchat.a aVar3 = this.mHiddenChatsVB;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHiddenChatsVB");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.qqnt.chats.api.b v3 = aVar2.v();
        if (v3 != null) {
            View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
            Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
            b.C9561b.a(v3, mContentView, "", 2, null, 8, null);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean hasFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, hasFocus);
            return;
        }
        super.onWindowFocusChanged(hasFocus);
        MiniMsgUser miniMsgUser = this.mMiniMsg;
        if (miniMsgUser != null && hasFocus) {
            if (miniMsgUser != null) {
                miniMsgUser.showEntry();
            }
            h.v().B();
        }
    }
}
