package com.tencent.robot.profile;

import a54.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.robot.aio.background.RobotAIOBackgroundContainer;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.profile.RobotProfileViewModel;
import com.tencent.robot.profile.data.g;
import com.tencent.robot.profile.parts.RobotProfileImmersivePart;
import com.tencent.robot.profile.parts.RobotProfileListPart;
import com.tencent.robot.profile.parts.RobotProfileOperationPart;
import com.tencent.robot.profile.parts.RobotProfileQRCodePosterPart;
import com.tencent.robot.profile.parts.RobotProfileTitlePart;
import com.tencent.robot.profile.setting.a;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.robot.relation.api.IRobotRelationService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u64.i;

@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001B\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J&\u0010\u001b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0014J\b\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020 H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\b0=j\b\u0012\u0004\u0012\u00020\b`>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Bh", "initData", "registerIoc", "Hh", "Gh", "Lj44/b;", "listener", OcrConfig.CHINESE, "Ih", "Kh", "Jh", "Ch", "Ah", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "", "useQUISecNavBar", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "secNavBarNeedImmersive", "needImmersive", "needStatusTrans", "isWrapContent", "onResume", "Lcom/tencent/robot/profile/RobotProfileViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/profile/RobotProfileViewModel;", "viewModel", "", "D", "Ljava/lang/Long;", "robotListenerId", "E", "Z", "isDTReportInit", UserInfo.SEX_FEMALE, "needRefreshWhenResumed", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "G", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "rootBg", "La54/a;", "H", "La54/a;", "relationObserver", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "I", "Ljava/util/ArrayList;", "lifecycleIocListeners", "com/tencent/robot/profile/RobotProfileFragment$c", "J", "Lcom/tencent/robot/profile/RobotProfileFragment$c;", "onBlackStateChangedListener", "<init>", "()V", "K", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileFragment extends QIphoneTitleBarFragment {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private RobotProfileViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Long robotListenerId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDTReportInit;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean needRefreshWhenResumed;

    /* renamed from: G, reason: from kotlin metadata */
    private RobotAIOBackgroundContainer rootBg;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final a54.a relationObserver = new f();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<j44.b> lifecycleIocListeners = new ArrayList<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final c onBlackStateChangedListener = new c();

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JH\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u001c\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileFragment$a;", "", "Landroid/content/Intent;", "intent", "", "e", "", "source", "a", "Landroid/content/Context;", "context", "", "troopUin", "robotUin", "", "enableNewTask", "exposureId", "Landroid/os/Bundle;", "bundel", "b", "shortUrl", "Lkotlin/Function0;", "exitFunc", "d", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.RobotProfileFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/profile/RobotProfileFragment$a$a", "Lcom/tencent/robot/api/b;", "", "success", "", "longUrl", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.profile.RobotProfileFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9776a implements com.tencent.robot.api.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f367814a;

            C9776a(Function0<Unit> function0) {
                this.f367814a = function0;
            }

            @Override // com.tencent.robot.api.b
            public void a(boolean success, @NotNull String longUrl) {
                Intrinsics.checkNotNullParameter(longUrl, "longUrl");
                if (success) {
                    Uri uri = Uri.parse(longUrl);
                    RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                    MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                    Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                    robotProfileUtils.s(uri, sMobileQQ);
                }
                this.f367814a.invoke();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(int source) {
            if (source == 2) {
                return 3;
            }
            return 0;
        }

        public static /* synthetic */ void c(Companion companion, Context context, String str, String str2, int i3, boolean z16, int i16, Bundle bundle, int i17, Object obj) {
            boolean z17;
            int i18;
            Bundle bundle2;
            if ((i17 & 16) != 0) {
                z17 = false;
            } else {
                z17 = z16;
            }
            if ((i17 & 32) != 0) {
                i18 = 0;
            } else {
                i18 = i16;
            }
            if ((i17 & 64) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            companion.b(context, str, str2, i3, z17, i18, bundle2);
        }

        private final void e(Intent intent) {
            intent.removeExtra("key_day_color");
            intent.removeExtra("key_night_color");
            intent.removeExtra("key_avatar_dominantColor");
            intent.removeExtra("key_day_bg");
            intent.removeExtra("key_night_bg");
            intent.removeExtra("key_day_dynamic_bg");
            intent.removeExtra("key_night_dynamic_bg");
        }

        public final void b(@NotNull Context context, @Nullable String troopUin, @NotNull String robotUin, int source, boolean enableNewTask, int exposureId, @Nullable Bundle bundel) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intent intent = new Intent();
            intent.putExtra("uin", robotUin);
            intent.putExtra("key_peerUin", RFWStringsKt.toLongOrDefault$default(robotUin, 0L, 0, 2, null));
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra("source", source);
            intent.putExtra("exposure_id", exposureId);
            intent.putExtra("key_chat_type", 1);
            if (enableNewTask) {
                intent.setFlags(268435456);
            }
            if (bundel != null) {
                intent.putExtras(bundel);
            }
            e(intent);
            if (context instanceof Activity) {
                if (bundel != null) {
                    z16 = bundel.getBoolean("key_enter_chat_by_finish");
                } else {
                    z16 = false;
                }
                if (z16) {
                    RobotImmersiveFragmentActivity.INSTANCE.b((Activity) context, intent, RobotProfileFragment.class, a(source));
                    QLog.d("robot.profile.RobotProfileFragment", 1, "open troop:" + troopUin + " robot:" + robotUin);
                }
            }
            RobotImmersiveFragmentActivity.INSTANCE.a(context, intent, RobotProfileFragment.class);
            QLog.d("robot.profile.RobotProfileFragment", 1, "open troop:" + troopUin + " robot:" + robotUin);
        }

        public final void d(@NotNull String shortUrl, @NotNull Function0<Unit> exitFunc) {
            Intrinsics.checkNotNullParameter(shortUrl, "shortUrl");
            Intrinsics.checkNotNullParameter(exitFunc, "exitFunc");
            u44.a.f438221a.c(shortUrl, new C9776a(exitFunc));
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/robot/profile/RobotProfileFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f367815a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RobotProfileFragment f367816b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f367817c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f367818d;

        public b(ViewModelStoreOwner viewModelStoreOwner, RobotProfileFragment robotProfileFragment, String str, String str2) {
            this.f367815a = viewModelStoreOwner;
            this.f367816b = robotProfileFragment;
            this.f367817c = str;
            this.f367818d = str2;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            LifecycleOwner viewLifecycleOwner = this.f367816b.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            return new RobotProfileViewModel(viewLifecycleOwner, this.f367817c, this.f367818d);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/profile/RobotProfileFragment$c", "Lcom/tencent/robot/profile/setting/a$a;", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements a.InterfaceC9777a {
        c() {
        }

        @Override // com.tencent.robot.profile.setting.a.InterfaceC9777a
        public void a() {
            RobotProfileFragment.this.needRefreshWhenResumed = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/profile/RobotProfileFragment$d", "Lj44/a;", "Lj44/b;", "listener", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements j44.a {
        d() {
        }

        @Override // j44.a
        public void a(@NotNull j44.b listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            RobotProfileFragment.this.zh(listener);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/profile/RobotProfileFragment$e", "Lj44/c;", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements j44.c {
        e() {
        }

        @Override // j44.c
        public void a() {
            RobotProfileFragment.this.needRefreshWhenResumed = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/profile/RobotProfileFragment$f", "La54/a;", "", "robotUin", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements a54.a {
        f() {
        }

        @Override // a54.a
        public void a(@NotNull String robotUin) {
            FragmentActivity activity;
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            g.Companion companion = com.tencent.robot.profile.data.g.INSTANCE;
            RobotProfileViewModel robotProfileViewModel = RobotProfileFragment.this.viewModel;
            if (robotProfileViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                robotProfileViewModel = null;
            }
            if (!companion.b(robotProfileViewModel.getTroopUin()) && (activity = RobotProfileFragment.this.getActivity()) != null) {
                activity.finish();
            }
        }

        @Override // a54.a
        public void b(@NotNull String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(@NotNull String str) {
            a.C0013a.a(this, str);
        }

        @Override // a54.a
        public void d(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.c(this, str, str2, obj);
        }

        @Override // a54.a
        public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(@NotNull String str, @NotNull String str2) {
            a.C0013a.f(this, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah() {
        int i3;
        String str;
        String str2;
        Bundle arguments = getArguments();
        int i16 = 0;
        if (arguments != null) {
            i3 = arguments.getInt("source");
        } else {
            i3 = 0;
        }
        RobotProfileViewModel robotProfileViewModel = this.viewModel;
        String str3 = null;
        if (robotProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel = null;
        }
        Bundle reportEventData = robotProfileViewModel.getReportEventData();
        reportEventData.clear();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "getAppRuntime()?.currentAccountUin ?: \"\"");
        }
        reportEventData.putString("uin", str);
        reportEventData.putInt("qq_robot_type", 1);
        reportEventData.putInt("robot_import_source", i3);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.titleRoot, "pg_bas_robot_data_card");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("robot_import_source", Integer.valueOf(i3));
        RobotProfileViewModel robotProfileViewModel2 = this.viewModel;
        if (robotProfileViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel2 = null;
        }
        linkedHashMap.put("agent_uin", robotProfileViewModel2.getRobotUin());
        RobotProfileViewModel robotProfileViewModel3 = this.viewModel;
        if (robotProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel3 = null;
        }
        if (robotProfileViewModel3.getRobotType() == 1) {
            str2 = "agt";
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str3 = arguments2.getString("troop_uin");
            }
            if (!TextUtils.isEmpty(str3)) {
                str2 = "grp";
            } else {
                str2 = "frd";
            }
        }
        linkedHashMap.put("zlk_type", str2);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i16 = arguments3.getInt("exposure_id");
        }
        linkedHashMap.put("exposure_id", Integer.valueOf(i16));
        VideoReport.setPageParams(this.titleRoot, new PageParams(linkedHashMap));
        VideoReport.setPageReportPolicy(this.titleRoot, PageReportPolicy.REPORT_ALL);
    }

    private final void Bh() {
        Iterator<T> it = this.lifecycleIocListeners.iterator();
        while (it.hasNext()) {
            ((j44.b) it.next()).onDestroy();
        }
    }

    private final void Ch() {
        RobotProfileViewModel robotProfileViewModel = this.viewModel;
        RobotProfileViewModel robotProfileViewModel2 = null;
        if (robotProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel = null;
        }
        LiveData<List<com.tencent.robot.profile.data.g>> n26 = robotProfileViewModel.n2();
        final Function1<List<? extends com.tencent.robot.profile.data.g>, Unit> function1 = new Function1<List<? extends com.tencent.robot.profile.data.g>, Unit>() { // from class: com.tencent.robot.profile.RobotProfileFragment$observeViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.robot.profile.data.g> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.robot.profile.data.g> list) {
                boolean z16;
                z16 = RobotProfileFragment.this.isDTReportInit;
                if (z16) {
                    return;
                }
                RobotProfileFragment.this.Ah();
                RobotProfileFragment.this.isDTReportInit = true;
            }
        };
        n26.observe(this, new Observer() { // from class: com.tencent.robot.profile.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileFragment.Dh(Function1.this, obj);
            }
        });
        RobotProfileViewModel robotProfileViewModel3 = this.viewModel;
        if (robotProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel3 = null;
        }
        LiveData<RobotProfileViewModel.PageState> l26 = robotProfileViewModel3.l2();
        final Function1<RobotProfileViewModel.PageState, Unit> function12 = new Function1<RobotProfileViewModel.PageState, Unit>() { // from class: com.tencent.robot.profile.RobotProfileFragment$observeViewModel$2

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes25.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f367823a;

                static {
                    int[] iArr = new int[RobotProfileViewModel.PageState.values().length];
                    try {
                        iArr[RobotProfileViewModel.PageState.DESTROY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f367823a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotProfileViewModel.PageState pageState) {
                invoke2(pageState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RobotProfileViewModel.PageState pageState) {
                FragmentActivity activity;
                QLog.d("robot.profile.RobotProfileFragment", 4, "pageState:" + pageState);
                if ((pageState == null ? -1 : a.f367823a[pageState.ordinal()]) != 1 || (activity = RobotProfileFragment.this.getActivity()) == null) {
                    return;
                }
                activity.finish();
            }
        };
        l26.observe(this, new Observer() { // from class: com.tencent.robot.profile.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileFragment.Eh(Function1.this, obj);
            }
        });
        RobotProfileViewModel robotProfileViewModel4 = this.viewModel;
        if (robotProfileViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            robotProfileViewModel2 = robotProfileViewModel4;
        }
        LiveData<GroupRobotProfile> r26 = robotProfileViewModel2.r2();
        final Function1<GroupRobotProfile, Unit> function13 = new Function1<GroupRobotProfile, Unit>() { // from class: com.tencent.robot.profile.RobotProfileFragment$observeViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupRobotProfile groupRobotProfile) {
                invoke2(groupRobotProfile);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupRobotProfile it) {
                RobotAIOBackgroundContainer robotAIOBackgroundContainer;
                robotAIOBackgroundContainer = RobotProfileFragment.this.rootBg;
                if (robotAIOBackgroundContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootBg");
                    robotAIOBackgroundContainer = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                RobotAIOBackgroundContainer.s(robotAIOBackgroundContainer, it, false, true, 2, null);
            }
        };
        r26.observe(this, new Observer() { // from class: com.tencent.robot.profile.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileFragment.Fh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Gh() {
        RFWIocAbilityProvider.g().registerIoc(RobotProfileUtils.f368193a.j(((QIphoneTitleBarFragment) this).mContentView), new d(), j44.a.class);
    }

    private final void Hh() {
        RFWIocAbilityProvider.g().registerIoc(RobotProfileUtils.f368193a.j(((QIphoneTitleBarFragment) this).mContentView), new e(), j44.c.class);
    }

    private final void Ih() {
        Kh();
        Jh();
    }

    private final void Jh() {
        RFWIocAbilityProvider.g().unregisterSingleIoc(RobotProfileUtils.f368193a.j(((QIphoneTitleBarFragment) this).mContentView), j44.a.class);
    }

    private final void Kh() {
        RFWIocAbilityProvider.g().unregisterSingleIoc(RobotProfileUtils.f368193a.j(((QIphoneTitleBarFragment) this).mContentView), j44.c.class);
    }

    private final void initData() {
        String str;
        boolean z16;
        String string;
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString("troop_uin")) == null) {
            str = "";
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("uin")) != null) {
            str2 = string;
        }
        i iVar = i.f438514a;
        ViewModel viewModel = new ViewModelProvider(this, new b(this, this, str, str2)).get(RobotProfileViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelStoreOwner.genV\u2026        })[T::class.java]");
        this.viewModel = (RobotProfileViewModel) viewModel;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Ch();
        RobotProfileViewModel robotProfileViewModel = this.viewModel;
        if (robotProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel = null;
        }
        robotProfileViewModel.b2();
    }

    private final void registerIoc() {
        Hh();
        Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(j44.b listener) {
        if (!this.lifecycleIocListeners.contains(listener)) {
            this.lifecycleIocListeners.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[5];
        RobotProfileViewModel robotProfileViewModel = this.viewModel;
        RobotProfileViewModel robotProfileViewModel2 = null;
        if (robotProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel = null;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        partArr[0] = new RobotProfileImmersivePart(robotProfileViewModel, viewLifecycleOwner);
        RobotProfileViewModel robotProfileViewModel3 = this.viewModel;
        if (robotProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel3 = null;
        }
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        QUISecNavBar quiSecNavBar = this.quiSecNavBar;
        Intrinsics.checkNotNullExpressionValue(quiSecNavBar, "quiSecNavBar");
        partArr[1] = new RobotProfileTitlePart(robotProfileViewModel3, viewLifecycleOwner2, quiSecNavBar);
        RobotProfileViewModel robotProfileViewModel4 = this.viewModel;
        if (robotProfileViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel4 = null;
        }
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        partArr[2] = new RobotProfileOperationPart(robotProfileViewModel4, viewLifecycleOwner3, R.id.acy);
        RobotProfileViewModel robotProfileViewModel5 = this.viewModel;
        if (robotProfileViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel5 = null;
        }
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        partArr[3] = new RobotProfileListPart(robotProfileViewModel5, viewLifecycleOwner4);
        RobotProfileViewModel robotProfileViewModel6 = this.viewModel;
        if (robotProfileViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            robotProfileViewModel2 = robotProfileViewModel6;
        }
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        partArr[4] = new RobotProfileQRCodePosterPart(robotProfileViewModel2, viewLifecycleOwner5, new Function0<String>() { // from class: com.tencent.robot.profile.RobotProfileFragment$assembleParts$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                RobotAIOBackgroundContainer robotAIOBackgroundContainer;
                robotAIOBackgroundContainer = RobotProfileFragment.this.rootBg;
                if (robotAIOBackgroundContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rootBg");
                    robotAIOBackgroundContainer = null;
                }
                return robotAIOBackgroundContainer.h();
            }
        });
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RobotAIOBackgroundContainer robotAIOBackgroundContainer;
        super.doOnCreateView(inflater, container, savedInstanceState);
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.robot.aio.background.RobotAIOBackgroundContainer");
        this.rootBg = (RobotAIOBackgroundContainer) view;
        initData();
        RobotAIOBackgroundContainer robotAIOBackgroundContainer2 = this.rootBg;
        RobotProfileViewModel robotProfileViewModel = null;
        if (robotAIOBackgroundContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootBg");
            robotAIOBackgroundContainer2 = null;
        }
        ViewGroup.LayoutParams layoutParams = robotAIOBackgroundContainer2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.removeRule(3);
        RobotAIOBackgroundContainer robotAIOBackgroundContainer3 = this.rootBg;
        if (robotAIOBackgroundContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootBg");
            robotAIOBackgroundContainer3 = null;
        }
        robotAIOBackgroundContainer3.setLayoutParams(layoutParams2);
        RobotAIOBackgroundContainer robotAIOBackgroundContainer4 = this.rootBg;
        if (robotAIOBackgroundContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootBg");
            robotAIOBackgroundContainer = null;
        } else {
            robotAIOBackgroundContainer = robotAIOBackgroundContainer4;
        }
        RobotProfileViewModel robotProfileViewModel2 = this.viewModel;
        if (robotProfileViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel2 = null;
        }
        String robotUin = robotProfileViewModel2.getRobotUin();
        IRobotProfileInfoApi iRobotProfileInfoApi = (IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class);
        RobotProfileViewModel robotProfileViewModel3 = this.viewModel;
        if (robotProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            robotProfileViewModel = robotProfileViewModel3;
        }
        RobotAIOBackgroundContainer.setInfo$default(robotAIOBackgroundContainer, robotUin, iRobotProfileInfoApi.getRobotCoreInfoFromFriendsCache(robotProfileViewModel.getRobotUin()), false, false, true, 8, null);
        this.quiSecNavBar.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hor;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    protected boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IRuntimeService iRuntimeService;
        super.onDestroyView();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        RobotAIOBackgroundContainer robotAIOBackgroundContainer = null;
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRelationObserver(this.relationObserver);
        }
        Long l3 = this.robotListenerId;
        if (l3 != null) {
            long longValue = l3.longValue();
            ac robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService();
            if (robotService != null) {
                robotService.removeKernelRobotListener(longValue);
            }
        }
        Bh();
        this.lifecycleIocListeners.clear();
        com.tencent.robot.profile.setting.a aVar = com.tencent.robot.profile.setting.a.f368094a;
        aVar.d(this.onBlackStateChangedListener);
        aVar.c();
        Ih();
        com.tencent.robot.profile.setting.b.f368096a.b();
        RobotAIOBackgroundContainer robotAIOBackgroundContainer2 = this.rootBg;
        if (robotAIOBackgroundContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootBg");
        } else {
            robotAIOBackgroundContainer = robotAIOBackgroundContainer2;
        }
        robotAIOBackgroundContainer.t();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needRefreshWhenResumed) {
            RobotProfileViewModel robotProfileViewModel = this.viewModel;
            if (robotProfileViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                robotProfileViewModel = null;
            }
            robotProfileViewModel.b2();
            this.needRefreshWhenResumed = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Long l3 = null;
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.addRelationObserver(this.relationObserver);
        }
        ac robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService();
        if (robotService != null) {
            l3 = Long.valueOf(robotService.addKernelRobotListener(new RobotProfileFragment$onViewCreated$1(this)));
        }
        this.robotListenerId = l3;
        com.tencent.robot.profile.setting.a.f368094a.a(this.onBlackStateChangedListener);
        registerIoc();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
