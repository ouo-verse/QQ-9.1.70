package com.tencent.robot.aio.helper.tts;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.tts.TtsMsgIntent;
import com.tencent.qqnt.aio.tts.a;
import com.tencent.qqnt.audio.tts.ui.e;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.aio.helper.tts.RobotTtsAbilityHelper$mAction$2;
import com.tencent.robot.aio.helper.tts.RobotTtsAbilityHelper$mActionR$2;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.profile.RobotProfileMsgIntent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import su3.c;
import tl.h;
import u64.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0005\n\u0002\b\b*\u0002>C\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001IB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00104R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00104R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010?\u001a\u0004\bD\u0010E\u00a8\u0006J"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/RobotTtsAbilityHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", BdhLogUtil.LogTag.Tag_Conn, "B", "", "targetSwitchOpened", "J", "E", "", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "r", "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$OnTtsPlayStateChanged;", HippyTKDListViewAdapter.X, "y", "G", "H", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "K", "Lcom/tencent/robot/profile/RobotProfileMsgIntent$OnRobotPersonalInfoUpdated;", "w", "Lcom/tencent/mvi/base/route/k;", ReportConstant.COSTREPORT_PREFIX, "v", "u", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/tts/TtsMsgIntent$ChangeAutoTtsSwitchState;", "t", "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Z", "mIsSupportTts", "f", "mIsSupportAutoTts", h.F, "mIsAutoTtsSwitchInit", "i", "mIsAutoTtsSwitchOpened", "mIsAutoSwitchShowing", "mIsPlaying", "com/tencent/robot/aio/helper/tts/RobotTtsAbilityHelper$mAction$2$a", "Lkotlin/Lazy;", "p", "()Lcom/tencent/robot/aio/helper/tts/RobotTtsAbilityHelper$mAction$2$a;", "mAction", "com/tencent/robot/aio/helper/tts/RobotTtsAbilityHelper$mActionR$2$a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/robot/aio/helper/tts/RobotTtsAbilityHelper$mActionR$2$a;", "mActionR", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class RobotTtsAbilityHelper implements com.tencent.aio.main.businesshelper.h, g {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsPlaying;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAction;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mActionR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSupportTts;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSupportAutoTts;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAutoTtsSwitchInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAutoTtsSwitchOpened;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAutoSwitchShowing;

    public RobotTtsAbilityHelper() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RobotTtsAbilityHelper$mAction$2.a>() { // from class: com.tencent.robot.aio.helper.tts.RobotTtsAbilityHelper$mAction$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/tts/RobotTtsAbilityHelper$mAction$2$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements com.tencent.mvi.base.route.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RobotTtsAbilityHelper f367093d;

                a(RobotTtsAbilityHelper robotTtsAbilityHelper) {
                    this.f367093d = robotTtsAbilityHelper;
                }

                @Override // com.tencent.mvi.base.route.a
                public void call(@NotNull MsgIntent intent) {
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    this.f367093d.r(intent);
                }

                @Override // com.tencent.mvi.base.route.a
                public boolean sticky() {
                    return a.C9235a.a(this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotTtsAbilityHelper.this);
            }
        });
        this.mAction = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<RobotTtsAbilityHelper$mActionR$2.a>() { // from class: com.tencent.robot.aio.helper.tts.RobotTtsAbilityHelper$mActionR$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/tts/RobotTtsAbilityHelper$mActionR$2$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements com.tencent.mvi.base.route.b {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RobotTtsAbilityHelper f367094d;

                a(RobotTtsAbilityHelper robotTtsAbilityHelper) {
                    this.f367094d = robotTtsAbilityHelper;
                }

                @Override // com.tencent.mvi.base.route.b
                @NotNull
                public k call(@NotNull MsgIntent intent) {
                    k s16;
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    s16 = this.f367094d.s(intent);
                    return s16;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotTtsAbilityHelper.this);
            }
        });
        this.mActionR = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean targetSwitchOpened) {
        int i3;
        BaseApplication context = BaseApplication.getContext();
        if (targetSwitchOpened) {
            i3 = R.string.f222166cs;
        } else {
            i3 = R.string.f222156cr;
        }
        QQToast.makeText(context, 2, i3, 0).show();
    }

    private final void B() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (fromV2.contains("mmkv_auto_tts_switch_state")) {
            this.mIsAutoTtsSwitchOpened = fromV2.getBoolean("mmkv_auto_tts_switch_state", false);
            this.mIsAutoTtsSwitchInit = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if (r1.hasExtra("key_support_tts") == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void C() {
        boolean z16;
        boolean z17;
        FragmentActivity activity;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Intent intent = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        if (c16 != null && (activity = c16.getActivity()) != null) {
            intent = activity.getIntent();
        }
        boolean z18 = false;
        if (intent != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 && intent.hasExtra("key_support_auto_tts")) {
            this.mIsSupportTts = intent.getBooleanExtra("key_support_tts", false);
            this.mIsSupportAutoTts = intent.getBooleanExtra("key_support_auto_tts", false);
            return;
        }
        RobotCoreInfo robotCoreInfoFromFriendsCache = ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotCoreInfoFromFriendsCache(o());
        if (robotCoreInfoFromFriendsCache != null) {
            z17 = u64.b.b(robotCoreInfoFromFriendsCache);
        } else {
            z17 = false;
        }
        this.mIsSupportTts = z17;
        if (robotCoreInfoFromFriendsCache != null) {
            z18 = u64.b.a(robotCoreInfoFromFriendsCache);
        }
        this.mIsSupportAutoTts = z18;
    }

    private final boolean D() {
        if (!Intrinsics.areEqual("1103", ThemeUtil.curThemeId) && !Intrinsics.areEqual("2920", ThemeUtil.curThemeId)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new TtsMsgIntent.OnAutoTtsSwitchStateChanged(this.mIsAutoTtsSwitchOpened));
    }

    private final void F() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new TtsMsgIntent.OnTtsAbilityInitCompleted(this.mIsSupportTts, this.mIsSupportAutoTts, this.mIsAutoTtsSwitchOpened));
    }

    private final void G() {
        int i3;
        HashMap hashMap = new HashMap();
        if (this.mIsAutoTtsSwitchOpened) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("status", Integer.valueOf(i3));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_autoread", hashMap);
    }

    private final void H() {
        int i3;
        HashMap hashMap = new HashMap();
        if (this.mIsAutoTtsSwitchOpened) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("status", Integer.valueOf(i3));
        com.tencent.mobileqq.aio.utils.b.q("em_bas_autoread", hashMap);
    }

    private final void I(boolean targetSwitchOpened) {
        QLog.i("RobotAutoTtsAbilityHelper", 1, "setAutoTtsSwitchState targetSwitchOpened = " + targetSwitchOpened);
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f170622lj, 0).show();
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        LifecycleOwner d16 = aVar.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "RobotAutoTtsAbilityHelper_handleRight3IvClickEvent", Boolean.TRUE, null, null, new RobotTtsAbilityHelper$setAutoTtsSwitchState$1(this, targetSwitchOpened, null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(boolean targetSwitchOpened) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putBoolean("mmkv_auto_tts_switch_state", targetSwitchOpened);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K() {
        int i3;
        Context context;
        Drawable drawable;
        Drawable drawable2;
        com.tencent.aio.api.runtime.a aVar;
        Context context2;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (this.mIsSupportTts && this.mIsSupportAutoTts) {
            if (this.mIsAutoTtsSwitchOpened) {
                i3 = R.drawable.qui_robot_auto_tts_icon_nav_secondary;
            } else {
                i3 = R.drawable.qui_robot_auto_tts_mute_icon_nav_secondary;
            }
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar3 = null;
            }
            Fragment c16 = aVar3.c();
            if (c16 != null && (context = c16.getContext()) != null && (drawable = context.getDrawable(i3)) != null) {
                if (this.mIsPlaying && this.mIsAutoTtsSwitchOpened) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mUseApngImage = true;
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_density", 320);
                    obtain.mExtraInfo = bundle;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    drawable = URLDrawable.getDrawable(m(), obtain).mutate();
                    if (drawable != null) {
                        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                            aVar4 = null;
                        }
                        Fragment c17 = aVar4.c();
                        if (c17 != null && (context2 = c17.getContext()) != null) {
                            drawable.setColorFilter(new PorterDuffColorFilter(context2.getColor(R.color.qui_common_icon_nav_primary), PorterDuff.Mode.SRC_IN));
                        } else {
                            return;
                        }
                    } else {
                        drawable2 = null;
                        if (!this.mIsAutoSwitchShowing) {
                            this.mIsAutoSwitchShowing = true;
                            H();
                        }
                        aVar = this.mAIOContext;
                        if (aVar != null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        } else {
                            aVar2 = aVar;
                        }
                        aVar2.e().h(new AIOTitleEvent.UpdateRight3IvEvent(false, true, drawable2, "", null, 16, null));
                        return;
                    }
                }
                drawable2 = drawable;
                if (!this.mIsAutoSwitchShowing) {
                }
                aVar = this.mAIOContext;
                if (aVar != null) {
                }
                aVar2.e().h(new AIOTitleEvent.UpdateRight3IvEvent(false, true, drawable2, "", null, 16, null));
                return;
            }
            return;
        }
        this.mIsAutoSwitchShowing = false;
        com.tencent.aio.api.runtime.a aVar5 = this.mAIOContext;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar5;
        }
        aVar2.e().h(new AIOTitleEvent.UpdateRight3IvEvent(false, false, null, "", null, 16, null));
    }

    private final String m() {
        if (D()) {
            return "https://shiply-adelie.shiply-cdn.qq.com/reshub/mobile_qq_android/robot_tts_auto_trigger_playing/formal/20250310170410/Production/robot_tts_auto_trigger_playing_night.png";
        }
        return "https://shiply-adelie.shiply-cdn.qq.com/reshub/mobile_qq_android/robot_tts_auto_trigger_playing/formal/20250310170045/Production/robot_tts_auto_trigger_playing.png";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        return aVar.g().r().c().j();
    }

    private final String o() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        return c.b(g16);
    }

    private final RobotTtsAbilityHelper$mAction$2.a p() {
        return (RobotTtsAbilityHelper$mAction$2.a) this.mAction.getValue();
    }

    private final RobotTtsAbilityHelper$mActionR$2.a q() {
        return (RobotTtsAbilityHelper$mActionR$2.a) this.mActionR.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(MsgIntent msgIntent) {
        if (msgIntent instanceof AIOTitleEvent.Right3IvClickEvent) {
            y();
            return;
        }
        if (msgIntent instanceof RobotProfileMsgIntent.OnRobotPersonalInfoUpdated) {
            w((RobotProfileMsgIntent.OnRobotPersonalInfoUpdated) msgIntent);
        } else if (msgIntent instanceof TtsMsgIntent.ChangeAutoTtsSwitchState) {
            t((TtsMsgIntent.ChangeAutoTtsSwitchState) msgIntent);
        } else if (msgIntent instanceof TtsMsgIntent.OnTtsPlayStateChanged) {
            x((TtsMsgIntent.OnTtsPlayStateChanged) msgIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k s(MsgIntent msgIntent) {
        if (msgIntent instanceof TtsMsgIntent.GetSupportTtsAbilityMsgIntent) {
            return v();
        }
        if (msgIntent instanceof TtsMsgIntent.GetAutoTtsAbilityMsgIntent) {
            return u();
        }
        return new j54.a();
    }

    private final void t(TtsMsgIntent.ChangeAutoTtsSwitchState msgIntent) {
        QLog.i("RobotAutoTtsAbilityHelper", 1, "handleChangeAutoTtsSwitchState isNeedOpen = " + msgIntent.a());
        if (this.mIsSupportTts && this.mIsSupportAutoTts && this.mIsAutoTtsSwitchOpened != msgIntent.a()) {
            I(msgIntent.a());
        }
    }

    private final k u() {
        return new a.C9498a(this.mIsSupportTts, this.mIsSupportAutoTts, this.mIsAutoTtsSwitchOpened);
    }

    private final k v() {
        return new a.b(this.mIsSupportTts);
    }

    private final void w(RobotProfileMsgIntent.OnRobotPersonalInfoUpdated msgIntent) {
        if (!Intrinsics.areEqual(msgIntent.getRobotUin(), o())) {
            return;
        }
        boolean a16 = d.a(msgIntent.getRobotFeature());
        boolean z16 = this.mIsAutoTtsSwitchOpened;
        if (a16 != z16) {
            boolean z17 = !z16;
            this.mIsAutoTtsSwitchOpened = z17;
            J(z17);
            E();
            K();
        }
        if (!this.mIsAutoTtsSwitchInit) {
            this.mIsAutoTtsSwitchInit = true;
            F();
        }
        QLog.i("RobotAutoTtsAbilityHelper", 1, "handleOnRobotPersonalInfoUpdatedmIsSupportTts = " + this.mIsSupportTts + " mIsSupportAutoTts = " + this.mIsSupportAutoTts + " mIsSupportAutoTts = " + this.mIsAutoTtsSwitchOpened);
    }

    private final void x(TtsMsgIntent.OnTtsPlayStateChanged msgIntent) {
        boolean z16;
        e.Companion companion = e.INSTANCE;
        if (companion.b().m(msgIntent.a()) && !companion.b().l(msgIntent.a())) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsPlaying = z16;
        K();
    }

    private final void y() {
        if (!FastClickUtils.isFastDoubleClick("RobotAutoTtsAbilityHelper") && this.mIsSupportTts && this.mIsSupportAutoTts) {
            G();
            I(!this.mIsAutoTtsSwitchOpened);
            return;
        }
        QLog.i("RobotAutoTtsAbilityHelper", 1, "handleRight3IvClickEvent return. " + this.mIsSupportTts + " " + this.mIsSupportAutoTts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean targetSwitchOpened) {
        this.mIsAutoTtsSwitchOpened = !targetSwitchOpened;
        K();
        E();
        QQToast.makeText(BaseApplication.context, 1, R.string.f170632lk, 0).show();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.D1;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.Right3IvClickEvent");
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotPersonalInfoUpdated");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.ChangeAutoTtsSwitchState");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.OnTtsPlayStateChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.GetSupportTtsAbilityMsgIntent");
        hashSet.add("com.tencent.qqnt.aio.tts.TtsMsgIntent.GetAutoTtsAbilityMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotAutoTtsAbilityHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        j e16 = a16.e();
        e16.f(this, p());
        e16.l(this, q());
        C();
        B();
        if (this.mIsAutoTtsSwitchInit) {
            F();
        }
        K();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, p());
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().e(this);
        this.mIsSupportTts = false;
        this.mIsSupportAutoTts = false;
        this.mIsAutoTtsSwitchOpened = false;
        this.mIsAutoTtsSwitchInit = false;
        this.mIsAutoSwitchShowing = false;
        this.mIsPlaying = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
