package com.tencent.robot.timbre.setting;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTsConfigReq;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.helper.tts.task.RobotTtsSimpleEvent;
import com.tencent.robot.aio.tts.api.IRobotTtsApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.timbre.RobotTimbrePlayerManager;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0016*\u0001\\\u0018\u0000 o2\u00020\u0001:\u0001pB\u0007\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J+\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001d\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001c0\u00182\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u001a\u0010%\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u0016H\u0002J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0012\u0010)\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J\b\u0010+\u001a\u00020\u0002H\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\u0012\u0010/\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0002H\u0016J\b\u00102\u001a\u00020\u0002H\u0016J\b\u00104\u001a\u000203H\u0014J\b\u00105\u001a\u000203H\u0014J\u0012\u00108\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u000106H\u0014J\u001a\u00109\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\b\u0010:\u001a\u00020\u0002H\u0016R\u0016\u0010=\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R&\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u001f0Bj\b\u0012\u0004\u0012\u00020\u001f`C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010<R\u0016\u0010c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010<R\u0016\u0010e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010<R\u0016\u0010g\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010<R\u0016\u0010i\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010WR\u0016\u0010l\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010k\u00a8\u0006q"}, d2 = {"Lcom/tencent/robot/timbre/setting/RobotTimbreSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneStatusTitleBarFragment;", "", "initArguments", "Fh", "Vh", "Jh", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "bi", "Landroid/view/View;", "view", "initUI", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTTSList;", "ttsList", "Th", "", "vipVoiceInfo", "", "Ih", "", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "", "initialSelectedTtsId", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Gh", "(Ljava/util/List;Ljava/lang/String;)[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Hh", "(Ljava/util/List;Ljava/lang/String;)[Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/robot/timbre/setting/k;", DownloadInfo.spKey_Config, "onlyRefresh", "Oh", "ttsInfo", "ttsId", "Nh", "Rh", "isPlaying", "ai", "Zh", "Xh", "Yh", "Wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getContentLayoutId", "getTitleLayoutId", "Landroid/content/Context;", "context", "initTitle", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "currentSelectedTimbreId", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "D", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "mSettingListItemAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "mTimbreSettingItemConfigList", "Lcom/tencent/robot/timbre/setting/m;", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/timbre/setting/m;", "mVasRobotTimbreLogic", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "mVasTtsInfo", "", "H", "Ljava/lang/Long;", "robotListenerId", "Landroid/app/Dialog;", "I", "Landroid/app/Dialog;", "loadingDialog", "Lcom/tencent/robot/timbre/RobotTimbrePlayerManager;", "J", "Lkotlin/Lazy;", "Mh", "()Lcom/tencent/robot/timbre/RobotTimbrePlayerManager;", "mTimbrePlayerManager", "com/tencent/robot/timbre/setting/RobotTimbreSettingFragment$mKuiklyReceiver$1", "K", "Lcom/tencent/robot/timbre/setting/RobotTimbreSettingFragment$mKuiklyReceiver$1;", "mKuiklyReceiver", "L", "robotUin", "M", "robotUid", "N", "mPickTtsId", "P", "mFinalPickTtsId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "groupId", BdhLogUtil.LogTag.Tag_Req, "Z", "isPageInReported", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotTimbreSettingFragment extends QIphoneStatusTitleBarFragment {

    /* renamed from: D, reason: from kotlin metadata */
    private QUIListItemAdapter mSettingListItemAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Long robotListenerId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTimbrePlayerManager;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final RobotTimbreSettingFragment$mKuiklyReceiver$1 mKuiklyReceiver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String robotUin;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String robotUid;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String mPickTtsId;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String mFinalPickTtsId;

    /* renamed from: Q, reason: from kotlin metadata */
    private long groupId;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isPageInReported;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String currentSelectedTimbreId = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<k> mTimbreSettingItemConfigList = new ArrayList<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private m mVasRobotTimbreLogic = new m();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private TtsInfo mVasTtsInfo = new TtsInfo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/timbre/setting/RobotTimbreSettingFragment$b", "Lcom/tencent/qqnt/kernel/listeneradapt/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "onRobotProfileChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends com.tencent.qqnt.kernel.listeneradapt.a {
        b() {
        }

        @Override // com.tencent.qqnt.kernel.listeneradapt.a, com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public void onRobotProfileChanged(@Nullable GroupRobotProfile robotProfile) {
            RobotTimbreSettingFragment.this.bi(robotProfile);
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mKuiklyReceiver$1] */
    public RobotTimbreSettingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotTimbrePlayerManager>() { // from class: com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mTimbrePlayerManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotTimbrePlayerManager invoke() {
                RobotTimbrePlayerManager robotTimbrePlayerManager = new RobotTimbrePlayerManager();
                final RobotTimbreSettingFragment robotTimbreSettingFragment = RobotTimbreSettingFragment.this;
                robotTimbrePlayerManager.p(new RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$1(robotTimbreSettingFragment, robotTimbrePlayerManager));
                robotTimbrePlayerManager.o(new Function2<Boolean, TtsInfo, Unit>() { // from class: com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TtsInfo ttsInfo) {
                        invoke(bool.booleanValue(), ttsInfo);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull TtsInfo ttsInfo) {
                        Dialog dialog;
                        Intrinsics.checkNotNullParameter(ttsInfo, "<anonymous parameter 1>");
                        dialog = RobotTimbreSettingFragment.this.loadingDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        RobotTimbreSettingFragment.this.loadingDialog = null;
                        if (z16) {
                            return;
                        }
                        QQToastUtil.showQQToast(1, R.string.f223306fv);
                    }
                });
                robotTimbrePlayerManager.t(new Function1<TtsInfo, Unit>() { // from class: com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
                        invoke2(ttsInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        RobotTimbreSettingFragment.this.ai(it, true);
                    }
                });
                robotTimbrePlayerManager.k(new Function1<TtsInfo, Unit>() { // from class: com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
                        invoke2(ttsInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo it) {
                        m mVar;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (QLog.isColorLevel()) {
                            QLog.i("RobotTimbreSettingFragment", 2, "onCancelPlay " + it);
                        }
                        RobotTimbreSettingFragment.this.ai(it, false);
                        mVar = RobotTimbreSettingFragment.this.mVasRobotTimbreLogic;
                        mVar.c(RobotTimbreSettingFragment.this.getContext(), null, "");
                    }
                });
                robotTimbrePlayerManager.l(new Function1<TtsInfo, Unit>() { // from class: com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
                        invoke2(ttsInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo it) {
                        m mVar;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (QLog.isColorLevel()) {
                            QLog.i("RobotTimbreSettingFragment", 2, "onCompletedPlay " + it);
                        }
                        RobotTimbreSettingFragment.this.ai(it, false);
                        mVar = RobotTimbreSettingFragment.this.mVasRobotTimbreLogic;
                        mVar.c(RobotTimbreSettingFragment.this.getContext(), null, "");
                    }
                });
                robotTimbrePlayerManager.r(new Function2<TtsInfo, String, Unit>() { // from class: com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo, String str) {
                        invoke2(ttsInfo, str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo ttsInfo, @NotNull String msg2) {
                        m mVar;
                        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        if (QLog.isColorLevel()) {
                            QLog.i("RobotTimbreSettingFragment", 2, "onPlayFailed " + ttsInfo + ",  msg : " + msg2);
                        }
                        QQToastUtil.showQQToast(1, R.string.f223306fv);
                        RobotTimbreSettingFragment.this.ai(ttsInfo, false);
                        mVar = RobotTimbreSettingFragment.this.mVasRobotTimbreLogic;
                        mVar.c(RobotTimbreSettingFragment.this.getContext(), null, "");
                    }
                });
                return robotTimbrePlayerManager;
            }
        });
        this.mTimbrePlayerManager = lazy;
        this.mKuiklyReceiver = new BroadcastReceiver() { // from class: com.tencent.robot.timbre.setting.RobotTimbreSettingFragment$mKuiklyReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                JSONObject b16;
                String optString;
                TtsInfo ttsInfo;
                TtsInfo ttsInfo2;
                RobotTimbrePlayerManager Mh;
                TtsInfo ttsInfo3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual("vas_robot_timbre", com.tencent.kuikly.core.render.android.expand.module.l.a(intent)) && (optString = (b16 = com.tencent.kuikly.core.render.android.expand.module.l.b(intent)).optString("event_name")) != null) {
                    int hashCode = optString.hashCode();
                    if (hashCode != 113762) {
                        if (hashCode != 3443508) {
                            if (hashCode == 97322682 && optString.equals("fetch")) {
                                RobotTimbreSettingFragment.this.Jh();
                                if (QLog.isColorLevel()) {
                                    QLog.d("VasRobotTimbre", 1, "receiverEvent fetch");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (optString.equals("play")) {
                            String optString2 = b16.optString("url");
                            String optString3 = b16.optString("id");
                            ttsInfo = RobotTimbreSettingFragment.this.mVasTtsInfo;
                            ttsInfo.ttsId = optString3;
                            ttsInfo2 = RobotTimbreSettingFragment.this.mVasTtsInfo;
                            ttsInfo2.ttsExample = optString2;
                            Mh = RobotTimbreSettingFragment.this.Mh();
                            ttsInfo3 = RobotTimbreSettingFragment.this.mVasTtsInfo;
                            Mh.v(ttsInfo3);
                            if (QLog.isColorLevel()) {
                                QLog.d("VasRobotTimbre", 1, "receiverEvent play " + optString3 + " " + optString2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (optString.equals("set")) {
                        String ttsId = b16.optString("id");
                        RobotTimbreSettingFragment robotTimbreSettingFragment = RobotTimbreSettingFragment.this;
                        Intrinsics.checkNotNullExpressionValue(ttsId, "ttsId");
                        robotTimbreSettingFragment.Nh(null, ttsId);
                        if (QLog.isColorLevel()) {
                            QLog.d("VasRobotTimbre", 1, "receiverEvent set " + ttsId);
                        }
                    }
                }
            }
        };
        this.robotUin = "";
        this.robotUid = "";
        this.mPickTtsId = "";
        this.mFinalPickTtsId = "";
    }

    private final void Fh() {
        Long l3;
        ac robotService;
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && (robotService = i3.getRobotService()) != null) {
            l3 = Long.valueOf(robotService.addKernelRobotListener(new b()));
        } else {
            l3 = null;
        }
        this.robotListenerId = l3;
        Context context = getContext();
        if (context != null) {
            com.tencent.kuikly.core.render.android.expand.module.l.c(context, this.mKuiklyReceiver);
        }
    }

    private final Group[] Gh(List<TtsInfo> ttsList, String initialSelectedTtsId) {
        com.tencent.mobileqq.widget.listitem.a<?>[] Hh = Hh(ttsList, initialSelectedTtsId);
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(Hh, Hh.length))};
    }

    private final com.tencent.mobileqq.widget.listitem.a<?>[] Hh(List<TtsInfo> ttsList, String initialSelectedTtsId) {
        ArrayList<k> arrayList = new ArrayList<>();
        Iterator<T> it = ttsList.iterator();
        while (it.hasNext()) {
            arrayList.add(new k((TtsInfo) it.next(), initialSelectedTtsId, this.robotUin, new RobotTimbreSettingFragment$createTimbreSettingConfigs$1$1$1(this)));
        }
        this.mTimbreSettingItemConfigList = arrayList;
        Object[] array = arrayList.toArray(new k[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.tencent.mobileqq.widget.listitem.a[]) array;
    }

    private final boolean Ih(byte[] vipVoiceInfo) {
        boolean z16;
        if (vipVoiceInfo == null) {
            return false;
        }
        if (vipVoiceInfo.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh() {
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfo(this.robotUin, String.valueOf(this.groupId), new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.timbre.setting.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                RobotTimbreSettingFragment.Kh(RobotTimbreSettingFragment.this, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(RobotTimbreSettingFragment this$0, int i3, final String errMsg, GroupRobotProfile groupRobotProfile) {
        boolean z16;
        String str;
        RobotTTSList robotTTSList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (groupRobotProfile != null && (robotTTSList = groupRobotProfile.ttsList) != null) {
                str = robotTTSList.pickTtsId;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            this$0.mPickTtsId = str;
            this$0.bi(groupRobotProfile);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        if (errMsg.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.timbre.setting.b
                @Override // java.lang.Runnable
                public final void run() {
                    RobotTimbreSettingFragment.Lh(errMsg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(String str) {
        QQToastUtil.showQQToast(1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RobotTimbrePlayerManager Mh() {
        return (RobotTimbrePlayerManager) this.mTimbrePlayerManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(TtsInfo ttsInfo, final String ttsId) {
        ac robotService;
        this.mVasRobotTimbreLogic.c(getContext(), null, ttsId);
        Zh(ttsInfo);
        RobotTTsConfigReq robotTTsConfigReq = new RobotTTsConfigReq();
        robotTTsConfigReq.robotUid = this.robotUid;
        robotTTsConfigReq.pickTtsId = ttsId;
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && (robotService = i3.getRobotService()) != null) {
            robotService.setRobotTTsConfig(robotTTsConfigReq, new IOperateCallback() { // from class: com.tencent.robot.timbre.setting.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    RobotTimbreSettingFragment.Ph(ttsId, this, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(k config, boolean onlyRefresh) {
        if (onlyRefresh) {
            Zh(config.getTtsInfo());
            return;
        }
        Mh().v(config.getTtsInfo());
        TtsInfo ttsInfo = config.getTtsInfo();
        String str = config.getTtsInfo().ttsId;
        Intrinsics.checkNotNullExpressionValue(str, "config.ttsInfo.ttsId");
        Nh(ttsInfo, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(final String ttsId, final RobotTimbreSettingFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(ttsId, "$ttsId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotTimbreSettingFragment", 1, "setRobotPickTts ttsId: " + ttsId + ", result: " + i3 + ", errMsg: " + str);
        if (i3 == 0) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.robot.timbre.setting.f
                @Override // java.lang.Runnable
                public final void run() {
                    RobotTimbreSettingFragment.Qh(RobotTimbreSettingFragment.this, ttsId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(RobotTimbreSettingFragment this$0, String ttsId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsId, "$ttsId");
        this$0.mFinalPickTtsId = ttsId;
        ((IRobotTtsApi) QRoute.api(IRobotTtsApi.class)).clearOldVersionLocalPickTtsId(this$0.robotUin);
        SimpleEventBus.getInstance().dispatchEvent(new RobotTtsSimpleEvent.OnPickedTtsIdChangedEvent(this$0.robotUin, ttsId));
    }

    private final void Rh(final RobotTTSList ttsList) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.timbre.setting.d
            @Override // java.lang.Runnable
            public final void run() {
                RobotTimbreSettingFragment.Sh(RobotTimbreSettingFragment.this, ttsList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(RobotTimbreSettingFragment this$0, RobotTTSList ttsList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsList, "$ttsList");
        if (this$0.isAdded()) {
            this$0.currentSelectedTimbreId = ((IRobotTtsApi) QRoute.api(IRobotTtsApi.class)).calculateCurrentTtsId(this$0.robotUin, ttsList);
            QUIListItemAdapter qUIListItemAdapter = this$0.mSettingListItemAdapter;
            if (qUIListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingListItemAdapter");
                qUIListItemAdapter = null;
            }
            ArrayList<TtsInfo> arrayList = ttsList.ttsList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "ttsList.ttsList");
            Group[] Gh = this$0.Gh(arrayList, this$0.currentSelectedTimbreId);
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(Gh, Gh.length));
            this$0.Xh();
        }
    }

    private final void Th(final RobotTTSList ttsList) {
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.robot.timbre.setting.c
                @Override // java.lang.Runnable
                public final void run() {
                    RobotTimbreSettingFragment.Uh(RobotTimbreSettingFragment.this, ttsList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(RobotTimbreSettingFragment this$0, RobotTTSList ttsList) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsList, "$ttsList");
        if (this$0.Ih(ttsList.vipVoiceInfo)) {
            View view = this$0.getView();
            if (view != null && (linearLayout2 = (LinearLayout) view.findViewById(R.id.f83854ko)) != null) {
                linearLayout2.setVisibility(0);
                String pickedTtsId = ttsList.pickTtsId;
                if (TextUtils.isEmpty(pickedTtsId)) {
                    pickedTtsId = ttsList.defaultTtsId;
                }
                m mVar = this$0.mVasRobotTimbreLogic;
                byte[] bArr = ttsList.vipVoiceInfo;
                Intrinsics.checkNotNullExpressionValue(pickedTtsId, "pickedTtsId");
                mVar.a(linearLayout2, bArr, pickedTtsId, this$0.robotUin);
                return;
            }
            return;
        }
        View view2 = this$0.getView();
        if (view2 != null && (linearLayout = (LinearLayout) view2.findViewById(R.id.f83854ko)) != null) {
            linearLayout.setVisibility(8);
        }
    }

    private final void Vh() {
        ac robotService;
        Long l3 = this.robotListenerId;
        if (l3 != null) {
            long longValue = l3.longValue();
            this.robotListenerId = null;
            IKernelService i3 = com.tencent.qqnt.msg.f.i();
            if (i3 != null && (robotService = i3.getRobotService()) != null) {
                robotService.removeKernelRobotListener(longValue);
            }
        }
        Context context = getContext();
        if (context != null) {
            com.tencent.kuikly.core.render.android.expand.module.l.f(context, this.mKuiklyReceiver);
        }
    }

    private final void Wh() {
        Iterator<T> it = this.mTimbreSettingItemConfigList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).m0(this.currentSelectedTimbreId);
        }
    }

    private final void Xh() {
        if (this.isPageInReported) {
            return;
        }
        this.isPageInReported = true;
        View view = getView();
        if (view != null) {
            l.f368635a.d(view, this.currentSelectedTimbreId);
        }
    }

    private final void Yh() {
        View view = getView();
        if (view != null) {
            l.f368635a.e(view, this.currentSelectedTimbreId);
        }
    }

    private final void Zh(TtsInfo ttsInfo) {
        String str;
        if (ttsInfo != null) {
            str = ttsInfo.ttsId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.currentSelectedTimbreId = str;
        for (k kVar : this.mTimbreSettingItemConfigList) {
            boolean areEqual = Intrinsics.areEqual(kVar.getTtsInfo(), ttsInfo);
            kVar.o0(areEqual);
            if (!areEqual) {
                kVar.n0(areEqual);
            }
            if (kVar.getIsPlayOrSelectStateChanged()) {
                QLog.i("RobotTimbreSettingFragment", 4, "updateRobotTimbrePlayAndSelectedState state changed tts info: " + kVar.getTtsInfo());
                QUIListItemAdapter qUIListItemAdapter = this.mSettingListItemAdapter;
                if (qUIListItemAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSettingListItemAdapter");
                    qUIListItemAdapter = null;
                }
                qUIListItemAdapter.l0(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(TtsInfo ttsInfo, boolean isPlaying) {
        QUIListItemAdapter qUIListItemAdapter;
        Object obj;
        Iterator<T> it = this.mTimbreSettingItemConfigList.iterator();
        while (true) {
            qUIListItemAdapter = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((k) obj).getTtsInfo(), ttsInfo)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        k kVar = (k) obj;
        if (kVar != null) {
            kVar.n0(isPlaying);
            if (kVar.getIsPlayOrSelectStateChanged()) {
                QLog.i("RobotTimbreSettingFragment", 4, "updateRobotTimbrePlayState state changed tts info: " + kVar.getTtsInfo());
                QUIListItemAdapter qUIListItemAdapter2 = this.mSettingListItemAdapter;
                if (qUIListItemAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSettingListItemAdapter");
                } else {
                    qUIListItemAdapter = qUIListItemAdapter2;
                }
                qUIListItemAdapter.l0(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(GroupRobotProfile robotProfile) {
        String str;
        RobotBaseInfo robotBaseInfo;
        RobotBaseInfo robotBaseInfo2;
        String str2 = this.robotUin;
        Long l3 = null;
        if (robotProfile != null && (robotBaseInfo2 = robotProfile.robotData) != null) {
            str = Long.valueOf(robotBaseInfo2.robotUin).toString();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str2, str)) {
            if (QLog.isDevelopLevel()) {
                String str3 = this.robotUin;
                if (robotProfile != null && (robotBaseInfo = robotProfile.robotData) != null) {
                    l3 = Long.valueOf(robotBaseInfo.robotUin);
                }
                QLog.d("RobotTimbreSettingFragment", 4, "[updateUI] skip, not equal. curUin=" + str3 + ", callbackUin=" + l3);
                return;
            }
            return;
        }
        RobotTTSList robotTTSList = robotProfile.ttsList;
        if (robotTTSList != null) {
            Th(robotTTSList);
            Rh(robotTTSList);
        }
    }

    private final void initArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("key_uin", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(KEY_UIN, \"\")");
            this.robotUin = string;
            this.groupId = arguments.getLong("key_groupID");
            String string2 = arguments.getString("key_uid", "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(KEY_UID, \"\")");
            this.robotUid = string2;
        }
    }

    private final void initUI(View view) {
        setTitle(getString(R.string.f223366g1));
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) view.findViewById(R.id.f83844kn);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.mSettingListItemAdapter = qUIListItemAdapter;
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.ffc;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment
    protected int getTitleLayoutId() {
        return R.layout.e4y;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment
    protected void initTitle(@Nullable Context context) {
        int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight(getContext());
        View findViewById = this.titleRoot.findViewById(R.id.rlCommenTitle);
        findViewById.getLayoutParams().height += statusBarHeight;
        findViewById.setPadding(findViewById.getPaddingLeft(), statusBarHeight, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mh().m();
        initArguments();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (!Intrinsics.areEqual(this.mFinalPickTtsId, this.mPickTtsId)) {
            com.tencent.mobileqq.tts.data.g.h().f(this.robotUin);
        }
        Mh().n();
        ApngImage.pauseAll();
        super.onDestroy();
        this.mVasRobotTimbreLogic.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Vh();
        Yh();
        Wh();
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Mh().q();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Mh().s();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initUI(view);
        Jh();
        Fh();
    }
}
