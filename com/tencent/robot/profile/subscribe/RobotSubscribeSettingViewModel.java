package com.tencent.robot.profile.subscribe;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IFetchSubcribeMsgTemplateStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotCommonCallBack;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateOp;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateSetReq;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateStatus;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.profile.data.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 A2\u00020\u0001:\u0001BB'\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\u0006\u00104\u001a\u00020\u0013\u0012\u0006\u00107\u001a\u00020\u0013\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J*\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000ej\u0002`\u00110\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002J2\u0010\u0018\u001a\u0010\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000ej\u0002`\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0017\u001a\u00060\u000fj\u0002`\u0010H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J \u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000ej\u0002`\u00110\u001e0\u001dJN\u0010&\u001a\u00020\u00022F\u0010%\u001aB\u00120\u0012.\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000ej\u0011`\u0011\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0002\u0018\u00010 j\u0004\u0018\u0001`$J0\u0010(\u001a\u00020\u00022\u0014\u0010#\u001a\u0010\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000ej\u0002`\u00112\u0006\u0010\u0019\u001a\u00020\u00152\n\u0010'\u001a\u00060\u000fj\u0002`\u0010R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0017\u00104\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00107\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R.\u0010;\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000ej\u0002`\u00110\u001e088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:RV\u0010>\u001aB\u00120\u0012.\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000ej\u0011`\u0011\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0002\u0018\u00010 j\u0004\u0018\u0001`$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/robot/profile/subscribe/RobotSubscribeSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "T1", "", "start", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SubscribeMsgTemplateStatus;", "Lkotlin/collections/ArrayList;", "response", "U1", "", "templateStatusList", "Lcom/tencent/robot/profile/subscribe/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/SubscribeMsgTemplateID;", "Lcom/tencent/robot/profile/subscribe/TemplateID;", "Lcom/tencent/robot/profile/subscribe/RobotSwitchTagSingleLineConfig1;", "P1", "", "title", "", "isChecked", "associatedData", "Q1", "isAllowed", "Z1", "Lcom/tencent/qqnt/kernel/api/ac;", "R1", "Landroidx/lifecycle/LiveData;", "", "S1", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", DownloadInfo.spKey_Config, "Lcom/tencent/robot/profile/subscribe/RobotSingleLineConfigChangeListener;", "listener", "c2", "templateID", "W1", "Landroidx/lifecycle/LifecycleOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "userMembership", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "D", "getRobotUin", "robotUin", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "mConfigListLiveData", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "mQUISwitchCheckChangeListener", "<init>", "(Landroidx/lifecycle/LifecycleOwner;ILjava/lang/String;Ljava/lang/String;)V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSubscribeSettingViewModel extends ViewModel {

    @NotNull
    private static final a G = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<e<SubscribeMsgTemplateID>>> mConfigListLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function1<? super e<SubscribeMsgTemplateID>, Unit> mQUISwitchCheckChangeListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int userMembership;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/profile/subscribe/RobotSubscribeSettingViewModel$a;", "", "", "PAGE_NUM", "I", "", "TAG", "Ljava/lang/String;", "TEXT_COLUMN", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public RobotSubscribeSettingViewModel(@NotNull LifecycleOwner lifecycleOwner, int i3, @NotNull String troopUin, @NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        this.lifecycleOwner = lifecycleOwner;
        this.userMembership = i3;
        this.troopUin = troopUin;
        this.robotUin = robotUin;
        this.mConfigListLiveData = new MutableLiveData<>(new LinkedList());
        T1();
    }

    private final List<e<SubscribeMsgTemplateID>> P1(List<SubscribeMsgTemplateStatus> templateStatusList) {
        int collectionSizeOrDefault;
        List<SubscribeMsgTemplateStatus> list = templateStatusList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SubscribeMsgTemplateStatus subscribeMsgTemplateStatus : list) {
            String str = subscribeMsgTemplateStatus.templateInfo.templateTitle;
            Intrinsics.checkNotNullExpressionValue(str, "it.templateInfo.templateTitle");
            boolean z16 = true;
            if (subscribeMsgTemplateStatus.status != 1) {
                z16 = false;
            }
            SubscribeMsgTemplateID subscribeMsgTemplateID = subscribeMsgTemplateStatus.templateInfo.templateId;
            Intrinsics.checkNotNullExpressionValue(subscribeMsgTemplateID, "it.templateInfo.templateId");
            arrayList.add(Q1(str, z16, subscribeMsgTemplateID));
        }
        return arrayList;
    }

    private final e<SubscribeMsgTemplateID> Q1(String title, boolean isChecked, SubscribeMsgTemplateID associatedData) {
        String str;
        int i3;
        if (g.INSTANCE.b(this.troopUin) && this.userMembership != 1) {
            String qqStr = HardCodeUtil.qqStr(R.string.f222386dd);
            if (isChecked) {
                i3 = R.string.f223596gn;
            } else {
                i3 = R.string.f223586gm;
            }
            str = qqStr + "\uff1a" + HardCodeUtil.qqStr(i3);
        } else {
            str = null;
        }
        e<SubscribeMsgTemplateID> eVar = new e<>(new x.b.d(title), x.c.C8997c.f317072b);
        eVar.X(str);
        eVar.W(associatedData);
        if (str == null) {
            eVar.U(new x.c.f(isChecked, null));
        }
        return eVar;
    }

    private final ac R1() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getRobotService();
        }
        return null;
    }

    private final void T1() {
        a2(0);
    }

    private final void U1(ArrayList<SubscribeMsgTemplateStatus> response) {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), "RobotSubscribeSettingViewModel.requestSettingDataFromSDK", Boolean.TRUE, null, null, new RobotSubscribeSettingViewModel$mergeResponseToLiveData$1(this, P1(response), null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(RobotSubscribeSettingViewModel this$0, e config, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        if (i3 != 0) {
            QLog.e("RobotSubscribeSettingViewModel", 1, "[modifySubscribeMsgTemplateStatus]: result=" + i3 + ", err=" + str);
            CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this$0.lifecycleOwner), "RobotSubscribeSettingViewModel.subscribeMsgTemplateSet", Boolean.TRUE, null, null, new RobotSubscribeSettingViewModel$modifySubscribeMsgTemplateStatus$1$1(config, this$0, null), 12, null);
        }
    }

    private final int Z1(boolean isAllowed) {
        if (isAllowed) {
            return 1;
        }
        return 2;
    }

    private final void a2(final int start) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        long j16;
        ac R1 = R1();
        if (R1 != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(this.robotUin);
            if (longOrNull2 != null) {
                j16 = longOrNull2.longValue();
            } else {
                j16 = 0;
            }
            R1.FetchSubcribeMsgTemplateStatus(new QuerySubscribeMsgTemplateStatusReq(j3, 0L, j16, start, 0), new IFetchSubcribeMsgTemplateStatusCallback() { // from class: com.tencent.robot.profile.subscribe.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchSubcribeMsgTemplateStatusCallback
                public final void onResult(int i3, String str, QuerySubscribeMsgTemplateStatusRsp querySubscribeMsgTemplateStatusRsp) {
                    RobotSubscribeSettingViewModel.b2(RobotSubscribeSettingViewModel.this, start, i3, str, querySubscribeMsgTemplateStatusRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(RobotSubscribeSettingViewModel this$0, int i3, int i16, String str, QuerySubscribeMsgTemplateStatusRsp querySubscribeMsgTemplateStatusRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 == 0 && querySubscribeMsgTemplateStatusRsp != null) {
            ArrayList<SubscribeMsgTemplateStatus> arrayList = querySubscribeMsgTemplateStatusRsp.templateStatus;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this$0.U1(arrayList);
            int size = arrayList.size() + i3;
            boolean z16 = querySubscribeMsgTemplateStatusRsp.isEnd;
            if (!z16 && size != i3) {
                this$0.a2(size);
                return;
            } else {
                if (!z16) {
                    QLog.e("RobotSubscribeSettingViewModel", 1, "[requestSettingDataFromSDK], nextStart=" + size);
                    return;
                }
                return;
            }
        }
        QLog.e("RobotSubscribeSettingViewModel", 1, "[requestSettingDataFromSDK]: result=" + i16 + ", errMsg=" + str + ", total=" + querySubscribeMsgTemplateStatusRsp.total + ", isEnd=" + querySubscribeMsgTemplateStatusRsp.isEnd);
    }

    @NotNull
    public final LiveData<List<e<SubscribeMsgTemplateID>>> S1() {
        return this.mConfigListLiveData;
    }

    public final void W1(@NotNull final e<SubscribeMsgTemplateID> config, boolean isAllowed, @NotNull SubscribeMsgTemplateID templateID) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        long j16;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(templateID, "templateID");
        ac R1 = R1();
        if (R1 != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(this.robotUin);
            if (longOrNull2 != null) {
                j16 = longOrNull2.longValue();
            } else {
                j16 = 0;
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new SubscribeMsgTemplateOp(templateID, Z1(isAllowed)));
            R1.SubscribeMsgTemplateSet(new SubscribeMsgTemplateSetReq(j3, 0L, j16, arrayListOf), new IRobotCommonCallBack() { // from class: com.tencent.robot.profile.subscribe.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotCommonCallBack
                public final void onResult(int i3, String str) {
                    RobotSubscribeSettingViewModel.X1(RobotSubscribeSettingViewModel.this, config, i3, str);
                }
            });
        }
    }

    public final void c2(@Nullable Function1<? super e<SubscribeMsgTemplateID>, Unit> listener) {
        this.mQUISwitchCheckChangeListener = listener;
    }
}
