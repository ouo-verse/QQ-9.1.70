package com.tencent.robot.profile;

import a54.a;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.mobileqq.util.conversationtitlebutton.api.IConversationTitleBtnFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotEntranceCards;
import com.tencent.qqnt.kernel.nativeinterface.RobotGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotStatus;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.api.IRobotInfoUpdateService;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.profile.RobotProfileViewModel;
import com.tencent.robot.profile.data.RobotBlacklistInfoData;
import com.tencent.robot.profile.data.RobotProfileAvatarHeaderData;
import com.tencent.robot.profile.data.RobotProfileColor;
import com.tencent.robot.profile.data.RobotProfileGroupCardData;
import com.tencent.robot.profile.data.RobotProfileMyCmdsData;
import com.tencent.robot.profile.data.RobotProfileMyServiceData;
import com.tencent.robot.profile.data.RobotProfileOfflineData;
import com.tencent.robot.profile.data.RobotProfileStoryInfoData;
import com.tencent.robot.profile.data.RobotProfileUsagePreviewData;
import com.tencent.robot.profile.data.RobotQZoneInfoData;
import com.tencent.robot.profile.data.VasSSRData;
import com.tencent.robot.profile.data.g;
import com.tencent.robot.profile.data.m;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.util.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\u0015*\u0002\u0090\u0001\u0018\u0000 \u00a0\u00012\u00020\u0001:\u0006\u00a1\u0001\u00a2\u0001\u00a3\u0001B!\u0012\u0006\u0010B\u001a\u00020=\u0012\u0006\u0010+\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0013\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J \u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\b\u00101\u001a\u00020\u0006H\u0014J\b\u00102\u001a\u0004\u0018\u00010\u000fJ\u0006\u00103\u001a\u00020\u0006J\u0010\u00104\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u000e\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020,J\u000e\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020,J\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\u0006R\u0017\u0010B\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010+\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010*\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\bG\u0010D\u001a\u0004\bH\u0010FR \u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00140I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010P\u001a\u0010\u0012\f\u0012\n N*\u0004\u0018\u00010M0M0I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010KR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010KR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010KR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010KR\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040W8\u0006\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010KR\"\u0010d\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010X\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR0\u0010p\u001a\u0010\u0012\f\u0012\n N*\u0004\u0018\u00010\u00040\u00040I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010K\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR(\u0010t\u001a\b\u0012\u0004\u0012\u00020&0I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010K\u001a\u0004\br\u0010m\"\u0004\bs\u0010oR0\u0010x\u001a\u0010\u0012\f\u0012\n N*\u0004\u0018\u00010\u00040\u00040I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010K\u001a\u0004\bv\u0010m\"\u0004\bw\u0010oR\u001d\u0010|\u001a\b\u0012\u0004\u0012\u00020y0I8\u0006\u00a2\u0006\f\n\u0004\bz\u0010K\u001a\u0004\b{\u0010mR\u001a\u0010\u0082\u0001\u001a\u00020}8\u0006\u00a2\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R+\u0010\u0089\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\b0I8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010KR\u0018\u0010\u008d\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010XR\u0018\u0010\u008f\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010XR\u0018\u0010\u0093\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001f\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00140W8F\u00a2\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010[R\u0019\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020M0W8F\u00a2\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010[R\u0019\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040W8F\u00a2\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010[R\u0019\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040W8F\u00a2\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010[R\u0019\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\b0W8F\u00a2\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010[\u00a8\u0006\u00a4\u0001"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "", "timeStart", "", "fetchLocal", "", "Z1", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "O2", "C2", "e2", "d2", "", "Lcom/tencent/robot/profile/data/g;", "profileList", "Lcom/tencent/robot/profile/data/h;", "robotColor", "y2", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGroupInfo;", "robotGroupInfoList", "z2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneInfo;", "qZoneInfo", "B2", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotEntranceCards;", "entranceCards", "E2", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "storySet", Constants.BASE_IN_PLUGIN_VERSION, "toShow", "I2", "P2", "Lcom/tencent/robot/profile/data/d;", "relationShip", "Lcom/tencent/robot/profile/RobotProfileViewModel$AddToTroopBtnState;", "f2", "F2", "", "robotUin", "troopUin", "", "addType", "K2", "L2", NowProxyConstants.AccountInfoKey.A2, "onCleared", "m2", "b2", "H2", Constants.MMCCID, "c2", "height", "M2", "naviHeight", "N2", "W1", "x2", "Landroidx/lifecycle/LifecycleOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "w2", "()Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "u2", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_profileListLiveData", "Lcom/tencent/robot/profile/RobotProfileViewModel$PageState;", "kotlin.jvm.PlatformType", "E", "_pageStateLiveData", UserInfo.SEX_FEMALE, "_offLineLiveData", "G", "_blackListData", "H", "_showSquareBtnLiveData", "Landroidx/lifecycle/LiveData;", "I", "Landroidx/lifecycle/LiveData;", "v2", "()Landroidx/lifecycle/LiveData;", "showSquareBtnLiveData", "J", "_needShowOpenSquareTipsLiveData", "K", "t2", "()I", "setRobotType", "(I)V", "robotType", "L", "Lcom/tencent/robot/profile/data/d;", "o2", "()Lcom/tencent/robot/profile/data/d;", "setRelationShip", "(Lcom/tencent/robot/profile/data/d;)V", "M", "i2", "()Landroidx/lifecycle/MutableLiveData;", "setCanC2CLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "canC2CLiveData", "N", "g2", "setAddToTroopBtnStateLiveData", "addToTroopBtnStateLiveData", "P", "j2", "setManageBtnStateLiveData", "manageBtnStateLiveData", "Lcom/tencent/robot/data/RobotInfo;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "q2", "robotInfoLiveData", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Bundle;", "p2", "()Landroid/os/Bundle;", "reportEventData", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", ICustomDataEditor.STRING_PARAM_2, "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "setRobotProfileRaw", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;)V", "robotProfileRaw", "T", "_robotProfileLiveData", "U", "navBarHeight", "V", "bottomLayoutHeight", "com/tencent/robot/profile/RobotProfileViewModel$b", "W", "Lcom/tencent/robot/profile/RobotProfileViewModel$b;", "relationObserver", ICustomDataEditor.NUMBER_PARAM_2, "profileListLiveData", "l2", "pageStateLiveData", "k2", "offLineLiveData", SemanticAttributes.DbSystemValues.H2, "blackListData", "r2", "robotProfileLiveData", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Ljava/lang/String;)V", "X", "AddToTroopBtnState", "a", "PageState", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.robot.profile.data.g>> _profileListLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PageState> _pageStateLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _offLineLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _blackListData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showSquareBtnLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showSquareBtnLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _needShowOpenSquareTipsLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private int robotType;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private com.tencent.robot.profile.data.d relationShip;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> canC2CLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<AddToTroopBtnState> addToTroopBtnStateLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> manageBtnStateLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<RobotInfo> robotInfoLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Bundle reportEventData;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private GroupRobotProfile robotProfileRaw;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<GroupRobotProfile> _robotProfileLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    private int navBarHeight;

    /* renamed from: V, reason: from kotlin metadata */
    private int bottomLayoutHeight;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final b relationObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileViewModel$AddToTroopBtnState;", "", "(Ljava/lang/String;I)V", "STATE_GONE", "STATE_ADD_TO_CURRENT_TROOP", "STATE_ADD_TO_TROOP", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public enum AddToTroopBtnState {
        STATE_GONE,
        STATE_ADD_TO_CURRENT_TROOP,
        STATE_ADD_TO_TROOP
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/profile/RobotProfileViewModel$PageState;", "", "(Ljava/lang/String;I)V", "IDLE", "PROFILE_DATA_FETCHING", "PROFILE_DATA_FETCHED", "DESTROY", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public enum PageState {
        IDLE,
        PROFILE_DATA_FETCHING,
        PROFILE_DATA_FETCHED,
        DESTROY
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/robot/profile/RobotProfileViewModel$b", "La54/a;", "", "robotUin", "", "c", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "d", "a", "f", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements a54.a {
        b() {
        }

        @Override // a54.a
        public void a(@NotNull String robotUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            QLog.d("robot.profile.RobotProfileViewModel", 1, "onRemoveFriendSucc robotUin:" + robotUin);
            if (!Intrinsics.areEqual(robotUin, RobotProfileViewModel.this.getRobotUin())) {
                return;
            }
            RobotProfileViewModel.this.getRelationShip().e(false);
        }

        @Override // a54.a
        public void b(@NotNull String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(@NotNull String robotUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            QLog.d("robot.profile.RobotProfileViewModel", 1, "onAddFriendSucc robotUin:" + robotUin);
            if (!Intrinsics.areEqual(robotUin, RobotProfileViewModel.this.getRobotUin())) {
                return;
            }
            RobotProfileViewModel.this.getRelationShip().e(true);
            RobotProfileViewModel.this.b2();
            RobotProfileViewModel.this.K2(robotUin, "", 2);
        }

        @Override // a54.a
        public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            QLog.d("robot.profile.RobotProfileViewModel", 1, "onAddRobotToGroupSucc robotUin:" + robotUin + " troopUin:" + troopUin);
            if (!Intrinsics.areEqual(robotUin, RobotProfileViewModel.this.getRobotUin()) && !Intrinsics.areEqual(troopUin, RobotProfileViewModel.this.getTroopUin())) {
                return;
            }
            RobotProfileViewModel.this.getRelationShip().f(0);
            RobotProfileViewModel.this.b2();
            RobotProfileViewModel.this.K2(robotUin, troopUin, 1);
        }

        @Override // a54.a
        public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(@NotNull String robotUin, @NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            if (!Intrinsics.areEqual(robotUin, RobotProfileViewModel.this.getRobotUin()) && !Intrinsics.areEqual(troopUin, RobotProfileViewModel.this.getTroopUin())) {
                return;
            }
            RobotProfileViewModel.this.getRelationShip().f(-1);
            QLog.d("robot.profile.RobotProfileViewModel", 1, "onRemoveRobotFromGroupSucc robotUin:" + robotUin + " troopUin:" + troopUin + " " + RobotProfileViewModel.this.getRelationShip());
            MutableLiveData<AddToTroopBtnState> g26 = RobotProfileViewModel.this.g2();
            RobotProfileViewModel robotProfileViewModel = RobotProfileViewModel.this;
            g26.setValue(robotProfileViewModel.f2(robotProfileViewModel.getRelationShip()));
        }
    }

    public RobotProfileViewModel(@NotNull LifecycleOwner lifecycleOwner, @NotNull String troopUin, @NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        this.lifecycleOwner = lifecycleOwner;
        this.troopUin = troopUin;
        this.robotUin = robotUin;
        this._profileListLiveData = new MutableLiveData<>();
        this._pageStateLiveData = new MutableLiveData<>(PageState.IDLE);
        this._offLineLiveData = new MutableLiveData<>();
        this._blackListData = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._showSquareBtnLiveData = mutableLiveData;
        this.showSquareBtnLiveData = mutableLiveData;
        this._needShowOpenSquareTipsLiveData = new MutableLiveData<>();
        this.relationShip = new com.tencent.robot.profile.data.d(0, 0, false, false, false, 31, null);
        Boolean bool = Boolean.FALSE;
        this.canC2CLiveData = new MutableLiveData<>(bool);
        this.addToTroopBtnStateLiveData = new MutableLiveData<>();
        this.manageBtnStateLiveData = new MutableLiveData<>(bool);
        this.robotInfoLiveData = new MutableLiveData<>(null);
        this.reportEventData = new Bundle();
        this._robotProfileLiveData = new MutableLiveData<>();
        b bVar = new b();
        this.relationObserver = bVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRobotRelationService iRobotRelationService = (IRobotRelationService) (peekAppRuntime != null ? peekAppRuntime.getRuntimeService(IRobotRelationService.class, "") : null);
        if (iRobotRelationService != null) {
            iRobotRelationService.addRelationObserver(bVar);
        }
    }

    private final boolean A2() {
        boolean z16;
        boolean z17;
        MutableLiveData<Boolean> mutableLiveData = this.canC2CLiveData;
        boolean z18 = false;
        if (mutableLiveData != null) {
            z16 = Intrinsics.areEqual(mutableLiveData.getValue(), Boolean.TRUE);
        } else {
            z16 = false;
        }
        MutableLiveData<Boolean> mutableLiveData2 = this.manageBtnStateLiveData;
        if (mutableLiveData2 != null) {
            z17 = Intrinsics.areEqual(mutableLiveData2.getValue(), Boolean.TRUE);
        } else {
            z17 = false;
        }
        if (!z16 && !z17 && this.addToTroopBtnStateLiveData.getValue() == AddToTroopBtnState.STATE_GONE) {
            z18 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("robot.profile.RobotProfileViewModel", 1, "isHideBottomLayout canC2C=" + z16 + ", manageBtnState = " + z17 + ", addToTroopBtnStateLiveData.value = " + this.addToTroopBtnStateLiveData.getValue() + ", result = " + z18);
        }
        return z18;
    }

    private final boolean B2(GroupRobotQzoneInfo qZoneInfo) {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"uin", "nick", "uid", "title"});
        QLog.d("robot.profile.RobotProfileViewModel", 1, "isQZoneInfoValid qZoneInfo=" + k.f(qZoneInfo, listOf));
        return qZoneInfo.hasOpenQQZone;
    }

    private final boolean C2(GroupRobotProfile robotProfile) {
        if (com.tencent.robot.profile.data.g.INSTANCE.b(this.troopUin)) {
            if (robotProfile.userMembership != -1) {
                return true;
            }
        } else if (robotProfile.userMembership == -1) {
            return true;
        }
        return false;
    }

    private final boolean D2(QueryHalfViewDataRsp storySet) {
        Intrinsics.checkNotNullExpressionValue(storySet.cardNodes, "storySet.cardNodes");
        if (!r0.isEmpty()) {
            Intrinsics.checkNotNullExpressionValue(storySet.layoutMap, "storySet.layoutMap");
            if (!r0.isEmpty()) {
                Intrinsics.checkNotNullExpressionValue(storySet.attrMap, "storySet.attrMap");
                if (!r4.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean E2(RobotEntranceCards entranceCards) {
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
            QLog.i("robot.profile.RobotProfileViewModel", 1, "dismiss ssr in studymode");
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(entranceCards.getCards(), "entranceCards.getCards()");
        if (!r6.isEmpty()) {
            return true;
        }
        QLog.i("robot.profile.RobotProfileViewModel", 1, "no ssr " + this.robotUin);
        return false;
    }

    private final void F2() {
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f222266d2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I2(final boolean toShow) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.profile.g
            @Override // java.lang.Runnable
            public final void run() {
                RobotProfileViewModel.J2(RobotProfileViewModel.this, toShow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(RobotProfileViewModel this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._showSquareBtnLiveData.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2(String robotUin, String troopUin, int addType) {
        EventData.Builder withId = EventData.builder().withId("ev_sgrp_robot_add_success");
        if (addType == 2) {
            troopUin = robotUin;
        }
        VideoReport.reportEvent(withId.withParam("to_uin", troopUin).withParam("add_type", Integer.valueOf(addType)).withParam("robot_id", robotUin).withParams(RobotProfileUtils.f368193a.g(this.reportEventData)).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L2() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return false;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return fromV2.getBoolean("robot.profile.RobotProfileViewModel_show_robot_square_tips_" + appInterface.getCurrentUin(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O2(GroupRobotProfile robotProfile) {
        this.robotType = robotProfile.robotData.robotBizType;
        this.robotProfileRaw = robotProfile;
        this._robotProfileLiveData.setValue(robotProfile);
        d2(robotProfile);
        e2(robotProfile);
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(this.robotUin, robotProfile.robotData.robotUid);
    }

    private final void P2() {
        Object obj;
        List<com.tencent.robot.profile.data.g> mutableList;
        Object obj2;
        List<com.tencent.robot.profile.data.g> value = this._profileListLiveData.getValue();
        m mVar = null;
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    if (((com.tencent.robot.profile.data.g) obj2) instanceof m) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            obj = (com.tencent.robot.profile.data.g) obj2;
        } else {
            obj = null;
        }
        if (obj instanceof m) {
            mVar = (m) obj;
        }
        if (mVar != null) {
            m i3 = mVar.i();
            i3.m(this.navBarHeight);
            i3.l(this.bottomLayoutHeight);
            if (value != null) {
                MutableLiveData<List<com.tencent.robot.profile.data.g>> mutableLiveData = this._profileListLiveData;
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value);
                int indexOf = mutableList.indexOf(mVar);
                mutableList.remove(mVar);
                mutableList.add(indexOf, i3);
                mutableLiveData.setValue(mutableList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(RobotProfileViewModel this$0, int i3, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger.f235387a.d().w("robot.profile.RobotProfileViewModel", 1, "AddRobotToGroupReq " + i3 + " " + str + " " + this$0.getRobotUin() + " " + this$0.getTroopUin());
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                String string = BaseApplication.getContext().getString(R.string.f222136cp);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R.string.robot_add_failed)");
                QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), 0, str, 0).show();
            return;
        }
        this$0.addToTroopBtnStateLiveData.setValue(AddToTroopBtnState.STATE_ADD_TO_TROOP);
        this$0.relationShip.f(0);
        Logger.f235387a.d().i("robot.profile.RobotProfileViewModel", 1, "AddRobotToGroupReq " + i3 + " " + str + " " + this$0.getRobotUin() + " " + this$0.getTroopUin() + " " + this$0.getRelationShip());
        this$0.F2();
    }

    private final void Z1(final long timeStart, boolean fetchLocal) {
        QLog.d("robot.profile.RobotProfileViewModel", 1, "fetchGroupRobotProfile uin=" + k.d(this.robotUin) + " troop=" + k.d(this.troopUin) + " fetchLocal=" + fetchLocal);
        IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback = new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.profile.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                RobotProfileViewModel.a2(timeStart, this, i3, str, groupRobotProfile);
            }
        };
        if (fetchLocal) {
            ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfo(this.robotUin, this.troopUin, iGetGroupRobotProfileCallback);
        } else {
            ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfoFromServer(this.robotUin, this.troopUin, iGetGroupRobotProfileCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(long j3, final RobotProfileViewModel this$0, final int i3, final String str, final GroupRobotProfile robotProfile) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("robot.profile.RobotProfileViewModel", 1, "fetchProfileData costTime:" + (System.currentTimeMillis() - j3) + " ms");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.RobotProfileViewModel$fetchGroupRobotProfile$callback$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                List listOf;
                int i16 = i3;
                if (i16 == 0 && robotProfile != null) {
                    mutableLiveData2 = this$0._pageStateLiveData;
                    mutableLiveData2.setValue(RobotProfileViewModel.PageState.PROFILE_DATA_FETCHED);
                    GroupRobotProfile robotProfile2 = robotProfile;
                    if (robotProfile2.robotData.robotUin == 0) {
                        QLog.w("robot.profile.RobotProfileViewModel", 1, "fetchGroupRobotProfile no local data");
                        return;
                    }
                    RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
                    Intrinsics.checkNotNullExpressionValue(robotProfile2, "robotProfile");
                    String v3 = robotProfileUtils.v(robotProfile2);
                    Logger.a d16 = Logger.f235387a.d();
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"uin", "addedUin", "uid", "name", "nick"});
                    d16.i("robot.profile.RobotProfileViewModel", 1, "fetchGroupRobotProfile " + k.f(v3, listOf));
                    RobotProfileViewModel robotProfileViewModel = this$0;
                    GroupRobotProfile robotProfile3 = robotProfile;
                    Intrinsics.checkNotNullExpressionValue(robotProfile3, "robotProfile");
                    robotProfileViewModel.O2(robotProfile3);
                    return;
                }
                QLog.e("robot.profile.RobotProfileViewModel", 1, "fetchProfileData result:" + i16 + " errMsg:" + str + " " + this$0.getRobotUin() + " " + this$0.getTroopUin());
                mutableLiveData = this$0._pageStateLiveData;
                mutableLiveData.setValue(RobotProfileViewModel.PageState.DESTROY);
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotInfoUpdateService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotInfoUpdateService iRobotInfoUpdateService = (IRobotInfoUpdateService) iRuntimeService;
        if (iRobotInfoUpdateService != null) {
            Intrinsics.checkNotNullExpressionValue(robotProfile, "robotProfile");
            iRobotInfoUpdateService.onFetchRobotProfile(robotProfile);
        }
    }

    private final void d2(GroupRobotProfile robotProfile) {
        int i3;
        RobotProfileColor a16 = RobotProfileColor.INSTANCE.a(robotProfile);
        this.relationShip = com.tencent.robot.profile.data.d.INSTANCE.a(robotProfile);
        ArrayList arrayList = new ArrayList();
        arrayList.add(RobotProfileAvatarHeaderData.Companion.b(RobotProfileAvatarHeaderData.INSTANCE, this.robotUin, this.troopUin, robotProfile, a16, false, 16, null));
        if (y2(arrayList, robotProfile, a16)) {
            return;
        }
        if (z2(robotProfile.robotGroupInfoList)) {
            RobotProfileGroupCardData.Companion companion = RobotProfileGroupCardData.INSTANCE;
            String str = this.robotUin;
            String str2 = this.troopUin;
            String str3 = robotProfile.robotData.callName;
            Intrinsics.checkNotNullExpressionValue(str3, "robotProfile.robotData.callName");
            ArrayList<RobotGroupInfo> arrayList2 = robotProfile.robotGroupInfoList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "robotProfile.robotGroupInfoList");
            arrayList.add(companion.a(str, str2, a16, str3, arrayList2));
        }
        GroupRobotQzoneInfo qzoneInfo = robotProfile.getQzoneInfo();
        Intrinsics.checkNotNullExpressionValue(qzoneInfo, "robotProfile.getQzoneInfo()");
        if (B2(qzoneInfo)) {
            String str4 = this.robotUin;
            String str5 = this.troopUin;
            String str6 = robotProfile.robotData.name;
            Intrinsics.checkNotNullExpressionValue(str6, "robotProfile.robotData.name");
            GroupRobotQzoneInfo qzoneInfo2 = robotProfile.getQzoneInfo();
            Intrinsics.checkNotNullExpressionValue(qzoneInfo2, "robotProfile.getQzoneInfo()");
            arrayList.add(new RobotQZoneInfoData(str4, str5, a16, str6, qzoneInfo2));
        }
        RobotEntranceCards entranceCards = robotProfile.getEntranceCards();
        Intrinsics.checkNotNullExpressionValue(entranceCards, "robotProfile.getEntranceCards()");
        if (E2(entranceCards)) {
            String str7 = this.robotUin;
            String str8 = this.troopUin;
            String str9 = robotProfile.robotData.name;
            Intrinsics.checkNotNullExpressionValue(str9, "robotProfile.robotData.name");
            RobotEntranceCards robotEntranceCards = robotProfile.entranceCards;
            Intrinsics.checkNotNullExpressionValue(robotEntranceCards, "robotProfile.entranceCards");
            arrayList.add(new VasSSRData(str7, str8, a16, str9, robotEntranceCards));
        }
        QueryHalfViewDataRsp queryHalfViewDataRsp = robotProfile.allStorySet;
        Intrinsics.checkNotNullExpressionValue(queryHalfViewDataRsp, "robotProfile.allStorySet");
        if (D2(queryHalfViewDataRsp)) {
            RobotProfileStoryInfoData.Companion companion2 = RobotProfileStoryInfoData.INSTANCE;
            String str10 = this.robotUin;
            String str11 = this.troopUin;
            String str12 = robotProfile.robotData.name;
            Intrinsics.checkNotNullExpressionValue(str12, "robotProfile.robotData.name");
            arrayList.add(RobotProfileStoryInfoData.Companion.b(companion2, str10, str11, a16, str12, robotProfile, null, 32, null));
        }
        this.canC2CLiveData.setValue(Boolean.valueOf(robotProfile.robotData.allowedAddC2C));
        if (robotProfile.robotData.robotSource == 4) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                this.manageBtnStateLiveData.setValue(Boolean.FALSE);
            } else {
                this.manageBtnStateLiveData.setValue(Boolean.valueOf(Intrinsics.areEqual(peekAppRuntime.getCurrentUid(), robotProfile.robotData.createInfo.createUid)));
            }
        } else {
            this.manageBtnStateLiveData.setValue(Boolean.FALSE);
        }
        this.addToTroopBtnStateLiveData.setValue(f2(this.relationShip));
        Intrinsics.checkNotNullExpressionValue(robotProfile.previewImages, "robotProfile.previewImages");
        if (!r1.isEmpty()) {
            arrayList.add(RobotProfileUsagePreviewData.INSTANCE.a(this.robotUin, this.troopUin, robotProfile, a16));
        }
        Intrinsics.checkNotNullExpressionValue(robotProfile.panels, "robotProfile.panels");
        if (!r1.isEmpty()) {
            arrayList.add(RobotProfileMyServiceData.INSTANCE.a(this.robotUin, this.troopUin, robotProfile, a16, this.relationShip));
        }
        Intrinsics.checkNotNullExpressionValue(robotProfile.commands, "robotProfile.commands");
        if (!r1.isEmpty()) {
            arrayList.add(RobotProfileMyCmdsData.INSTANCE.a(this.robotUin, this.troopUin, robotProfile, a16, this.relationShip));
        }
        boolean q16 = RobotProfileUtils.f368193a.q();
        if (A2()) {
            i3 = 32;
        } else {
            i3 = 20;
        }
        int i16 = i3;
        if (arrayList.size() <= 1) {
            if (q16) {
                com.tencent.robot.profile.data.g gVar = arrayList.get(0);
                if (gVar instanceof RobotProfileAvatarHeaderData) {
                    ((RobotProfileAvatarHeaderData) gVar).p(false);
                }
            } else {
                arrayList.add(new RobotProfileOfflineData(this.robotUin, this.troopUin, a16, false, null, true, 24, null));
            }
        }
        arrayList.add(new m(i16, this.robotUin, this.troopUin, a16, q16, this.navBarHeight, this.bottomLayoutHeight));
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("robot.profile.RobotProfileViewModel", "generateProfileItemList distance = " + i16 + ", needReverseEmpty: " + q16 + ", " + getRelationShip() + " \n" + arrayList);
        }
        this._profileListLiveData.setValue(arrayList);
    }

    private final void e2(GroupRobotProfile robotProfile) {
        String str;
        String str2;
        RobotBaseInfo robotBaseInfo = robotProfile.robotData;
        String valueOf = String.valueOf(robotBaseInfo.robotUin);
        String valueOf2 = String.valueOf(robotBaseInfo.appid);
        String name = robotBaseInfo.name;
        String str3 = robotBaseInfo.desc;
        String robotAvatar = robotBaseInfo.robotAvatar;
        String str4 = robotProfile.jumpUrl;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        boolean z16 = robotBaseInfo.allowedAddC2C;
        String str5 = robotBaseInfo.robotUid;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        Intrinsics.checkNotNullExpressionValue(name, "name");
        Intrinsics.checkNotNullExpressionValue(robotAvatar, "robotAvatar");
        this.robotInfoLiveData.setValue(new RobotInfo(valueOf2, name, str3, robotAvatar, str, valueOf, null, z16, str2, 64, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddToTroopBtnState f2(com.tencent.robot.profile.data.d relationShip) {
        if (!relationShip.getAllowAdd2Group()) {
            return AddToTroopBtnState.STATE_GONE;
        }
        g.Companion companion = com.tencent.robot.profile.data.g.INSTANCE;
        if (companion.b(this.troopUin) && relationShip.getRobotMemberShip() == -1 && (companion.a(relationShip.getUserMemberShip()) || ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).canInviteRobotInGroup(MobileQQ.sMobileQQ.peekAppRuntime(), this.troopUin))) {
            return AddToTroopBtnState.STATE_ADD_TO_CURRENT_TROOP;
        }
        return AddToTroopBtnState.STATE_ADD_TO_TROOP;
    }

    private final boolean y2(List<com.tencent.robot.profile.data.g> profileList, GroupRobotProfile robotProfile, RobotProfileColor robotColor) {
        boolean z16;
        RobotBaseInfo robotBaseInfo = robotProfile.robotData;
        RobotStatus robotStatus = robotBaseInfo.robotStatus;
        if (robotBaseInfo.offline != 1 && robotStatus != RobotStatus.KBANNED && robotStatus != RobotStatus.KOFFLINE && robotStatus != RobotStatus.KDELETED) {
            z16 = false;
        } else {
            z16 = true;
        }
        this._offLineLiveData.setValue(Boolean.valueOf(z16));
        this._blackListData.setValue(Boolean.FALSE);
        if (z16) {
            String str = this.robotUin;
            String str2 = this.troopUin;
            Intrinsics.checkNotNullExpressionValue(robotStatus, "robotStatus");
            profileList.add(new RobotProfileOfflineData(str, str2, robotColor, true, robotStatus, false, 32, null));
            profileList.add(new m(32, this.robotUin, this.troopUin, robotColor, false, this.navBarHeight, this.bottomLayoutHeight, 16, null));
            this._profileListLiveData.setValue(profileList);
            return true;
        }
        if (!robotProfile.blacklistInfo.isBlock) {
            return false;
        }
        profileList.add(new RobotBlacklistInfoData(this.robotUin, this.troopUin, robotColor, false, true, false));
        profileList.add(new m(32, this.robotUin, this.troopUin, robotColor, false, this.navBarHeight, this.bottomLayoutHeight, 16, null));
        this._blackListData.setValue(Boolean.valueOf(robotProfile.blacklistInfo.isBlock));
        this._profileListLiveData.setValue(profileList);
        return true;
    }

    private final boolean z2(List<RobotGroupInfo> robotGroupInfoList) {
        boolean z16;
        QLog.d("robot.profile.RobotProfileViewModel", 1, "isGroupCardValid robotGroupInfoList=" + robotGroupInfoList);
        List<RobotGroupInfo> list = robotGroupInfoList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    public final void G2() {
        boolean z16;
        GroupRobotProfile groupRobotProfile = this.robotProfileRaw;
        if (groupRobotProfile != null) {
            com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
            if (b16 != null) {
                Boolean valueOf = Boolean.valueOf(groupRobotProfile.isFriend);
                String str = groupRobotProfile.robotData.robotUid;
                Intrinsics.checkNotNullExpressionValue(str, "it.robotData.robotUid");
                z16 = Intrinsics.areEqual(valueOf, b16.isBuddy(str));
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.f235387a.d().i("robot.profile.RobotProfileViewModel", 1, "onRobotFriendListChanged isFriend=" + groupRobotProfile.isFriend);
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.RobotProfileViewModel$onRobotFriendListChanged$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RobotProfileViewModel.this.b2();
                    }
                });
            }
        }
    }

    public final void H2(@Nullable final GroupRobotProfile robotProfile) {
        IRuntimeService iRuntimeService;
        if (robotProfile != null && Intrinsics.areEqual(String.valueOf(robotProfile.robotData.robotUin), this.robotUin) && C2(robotProfile)) {
            Logger.f235387a.d().i("robot.profile.RobotProfileViewModel", 1, "onRobotProfileChanged " + RobotProfileUtils.f368193a.v(robotProfile));
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                O2(robotProfile);
            } else {
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.RobotProfileViewModel$onRobotProfileChanged$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RobotProfileViewModel.this.O2(robotProfile);
                    }
                });
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotInfoUpdateService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRobotInfoUpdateService iRobotInfoUpdateService = (IRobotInfoUpdateService) iRuntimeService;
            if (iRobotInfoUpdateService != null) {
                iRobotInfoUpdateService.onFetchRobotProfile(robotProfile);
            }
        }
    }

    public final void M2(int height) {
        if (this.bottomLayoutHeight != height) {
            this.bottomLayoutHeight = height;
            P2();
        }
    }

    public final void N2(int naviHeight) {
        if (this.navBarHeight != naviHeight) {
            this.navBarHeight = naviHeight;
            P2();
        }
    }

    public final void W1() {
        IRuntimeService iRuntimeService;
        if (FastClickUtils.isFastDoubleClick("robot.profile.RobotProfileViewModeladdRobotToCurrentGroup")) {
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci7, 0).show();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            IRobotRelationService.a.a(iRobotRelationService, this.robotUin, this.troopUin, null, new ISetAddRobotToGroupCallback() { // from class: com.tencent.robot.profile.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
                public final void onResult(int i3, String str) {
                    RobotProfileViewModel.X1(RobotProfileViewModel.this, i3, str);
                }
            }, 4, null);
        }
    }

    public final void b2() {
        GroupRobotProfile recentRobotProfileCache;
        PageState value = this._pageStateLiveData.getValue();
        PageState pageState = PageState.PROFILE_DATA_FETCHING;
        if (value == pageState) {
            QLog.w("robot.profile.RobotProfileViewModel", 1, "fetchProfileData repeatRequest");
            return;
        }
        if (this.robotProfileRaw == null && (recentRobotProfileCache = ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRecentRobotProfileCache(this.robotUin)) != null) {
            QLog.d("robot.profile.RobotProfileViewModel", 1, "fetchProfileData hit cache");
            O2(recentRobotProfileCache);
        }
        this._pageStateLiveData.setValue(pageState);
        if (this.robotProfileRaw != null) {
            Z1(System.currentTimeMillis(), false);
        } else {
            Z1(System.currentTimeMillis(), true);
        }
    }

    public final void c2() {
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
            if (QLog.isColorLevel()) {
                QLog.i("robot.profile.RobotProfileViewModel", 2, "[fetchSquareConfig] study mode, return");
            }
            I2(false);
            return;
        }
        ((IConversationTitleBtnFactory) QRoute.api(IConversationTitleBtnFactory.class)).createConversationTitleBtnConfig(new Function1<ConversationTitleBtnConfig, Unit>() { // from class: com.tencent.robot.profile.RobotProfileViewModel$fetchSquareConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConversationTitleBtnConfig conversationTitleBtnConfig) {
                invoke2(conversationTitleBtnConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConversationTitleBtnConfig it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (QLog.isColorLevel()) {
                    QLog.i("robot.profile.RobotProfileViewModel", 2, "[fetchSquareConfig] title btn config: " + it);
                }
                RobotProfileViewModel.this.I2(Intrinsics.areEqual(it.getBusinessId(), "Adelie") && it.i());
            }
        });
    }

    @NotNull
    public final MutableLiveData<AddToTroopBtnState> g2() {
        return this.addToTroopBtnStateLiveData;
    }

    @NotNull
    public final LiveData<Boolean> h2() {
        return this._blackListData;
    }

    @NotNull
    public final MutableLiveData<Boolean> i2() {
        return this.canC2CLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> j2() {
        return this.manageBtnStateLiveData;
    }

    @NotNull
    public final LiveData<Boolean> k2() {
        return this._offLineLiveData;
    }

    @NotNull
    public final LiveData<PageState> l2() {
        return this._pageStateLiveData;
    }

    @Nullable
    public final com.tencent.robot.profile.data.g m2() {
        List<com.tencent.robot.profile.data.g> value = n2().getValue();
        Object obj = null;
        if (value == null) {
            return null;
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((com.tencent.robot.profile.data.g) next) instanceof RobotProfileAvatarHeaderData) {
                obj = next;
                break;
            }
        }
        return (com.tencent.robot.profile.data.g) obj;
    }

    @NotNull
    public final LiveData<List<com.tencent.robot.profile.data.g>> n2() {
        return this._profileListLiveData;
    }

    @NotNull
    /* renamed from: o2, reason: from getter */
    public final com.tencent.robot.profile.data.d getRelationShip() {
        return this.relationShip;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IRuntimeService iRuntimeService;
        super.onCleared();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRelationObserver(this.relationObserver);
        }
    }

    @NotNull
    /* renamed from: p2, reason: from getter */
    public final Bundle getReportEventData() {
        return this.reportEventData;
    }

    @NotNull
    public final MutableLiveData<RobotInfo> q2() {
        return this.robotInfoLiveData;
    }

    @NotNull
    public final LiveData<GroupRobotProfile> r2() {
        return this._robotProfileLiveData;
    }

    @Nullable
    /* renamed from: s2, reason: from getter */
    public final GroupRobotProfile getRobotProfileRaw() {
        return this.robotProfileRaw;
    }

    /* renamed from: t2, reason: from getter */
    public final int getRobotType() {
        return this.robotType;
    }

    @NotNull
    /* renamed from: u2, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    @NotNull
    public final LiveData<Boolean> v2() {
        return this.showSquareBtnLiveData;
    }

    @NotNull
    /* renamed from: w2, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public final void x2() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "robot.profile.RobotProfileViewModel", Boolean.FALSE, null, null, new RobotProfileViewModel$initNeedOpenRobotSquareState$1(this, null), 12, null);
    }
}
