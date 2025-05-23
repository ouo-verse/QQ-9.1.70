package com.tencent.mobileqq.icgame.room.frame.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchPageInfo;
import com.tencent.mobileqq.icgame.base.room.multipage.api.c;
import com.tencent.mobileqq.icgame.base.room.multipage.controller.MultiPageController;
import com.tencent.mobileqq.icgame.room.frame.switchroom.QQLiveSwitchRoomViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/frame/activity/QQLiveRoomContainerFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sh", "th", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "qh", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/content/Intent;", "intent", "onNewIntent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "", "themeChangeRightNow", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "D", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController;", "E", "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/MultiPageController;", "multiPageController", "Landroidx/activity/OnBackPressedCallback;", UserInfo.SEX_FEMALE, "Landroidx/activity/OnBackPressedCallback;", "getBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "setBackPressedCallback", "(Landroidx/activity/OnBackPressedCallback;)V", "backPressedCallback", "<init>", "()V", "G", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveRoomContainerFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "QQLiveRoomContainerFragment" + hashCode();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy multiPageController;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private OnBackPressedCallback backPressedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/icgame/room/frame/activity/QQLiveRoomContainerFragment$b", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends OnBackPressedCallback {
        b() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (!QQLiveRoomContainerFragment.this.rh().p()) {
                setEnabled(false);
                QQLiveRoomContainerFragment.this.requireActivity().onBackPressed();
            }
        }
    }

    public QQLiveRoomContainerFragment() {
        Lazy lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MultiPageController>() { // from class: com.tencent.mobileqq.icgame.room.frame.activity.QQLiveRoomContainerFragment$multiPageController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MultiPageController invoke() {
                return new MultiPageController();
            }
        });
        this.multiPageController = lazy;
        this.backPressedCallback = new b();
    }

    private final SwitchPageInfo qh() {
        Intent intent;
        String stringExtra;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        Intrinsics.checkNotNull(intent);
        long longExtra = intent.getLongExtra("roomid", 0L);
        String str = "";
        if (intent.hasExtra("video_url") && (stringExtra = intent.getStringExtra("video_url")) != null) {
            str = stringExtra;
        }
        String str2 = str;
        QLog.i(this.TAG, 1, "buildParamsFromIntent roomid = " + longExtra + ",videoUrl = " + str2);
        return new SwitchPageInfo(0, longExtra, str2, intent.getBundleExtra("biz_ext_data"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiPageController rh() {
        return (MultiPageController) this.multiPageController.getValue();
    }

    private final void sh(FrameLayout rootView) {
        if (getActivity() != null) {
            MultiPageController rh5 = rh();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            SwitchPageInfo qh5 = qh();
            Object obj = new ViewModelProvider(requireActivity()).get(QQLiveSwitchRoomViewModel.class);
            Intrinsics.checkNotNullExpressionValue(obj, "ViewModelProvider(requir\u2026oomViewModel::class.java)");
            rh5.k(rootView, childFragmentManager, this, qh5, (c) obj, new g42.a(), new g42.b());
        }
    }

    private final void th() {
        if (getActivity() != null && (getActivity() instanceof QBaseActivity)) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QBaseActivity) requireActivity);
            if (systemBarComp != null) {
                systemBarComp.setStatusDrawable(null);
                systemBarComp.setStatusBarColor(0);
                systemBarComp.setStatusColor(0);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.overridePendingTransition(R.anim.activity_new, 0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.aegisLog.i(this.TAG, 1, "onAttach");
        requireActivity().getOnBackPressedDispatcher().addCallback(this, this.backPressedCallback);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.aegisLog.i(this.TAG, 1, "onConfigurationChanged");
        rh().q(newConfig);
        th();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        th();
        View inflate = inflater.inflate(R.layout.fat, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.aegisLog.i(this.TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        rh().t();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        int i3 = 1;
        this.aegisLog.i(this.TAG, 1, "onNewIntent");
        if (intent.getBooleanExtra("open_from_float_window", false)) {
            this.aegisLog.i(this.TAG, "skipNewIntent, return");
            return;
        }
        long longExtra = intent.getLongExtra("roomid", -1L);
        int intExtra = intent.getIntExtra("video_format", 1);
        if (longExtra > 0 && longExtra != rh().i().getRoomid()) {
            SwitchPageInfo switchPageInfo = new SwitchPageInfo(0, 0L, null, null, 15, null);
            switchPageInfo.g(longExtra);
            String stringExtra = intent.getStringExtra("video_url");
            if (stringExtra == null) {
                stringExtra = "";
            }
            switchPageInfo.h(stringExtra);
            switchPageInfo.e(intent.getBundleExtra("biz_ext_data"));
            if (intExtra != 3) {
                i3 = 0;
            }
            Bundle extraData = switchPageInfo.getExtraData();
            if (extraData != null) {
                extraData.putInt("video_format", i3);
            }
            rh().r(switchPageInfo);
            return;
        }
        this.aegisLog.i(this.TAG, "roomId equal, return");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FrameLayout rootView = (FrameLayout) view.findViewById(R.id.f7804460);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        sh(rootView);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean themeChangeRightNow() {
        return false;
    }
}
