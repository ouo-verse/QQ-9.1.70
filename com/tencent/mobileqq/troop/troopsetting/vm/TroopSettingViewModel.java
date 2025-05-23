package com.tencent.mobileqq.troop.troopsetting.vm;

import a54.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.association.data.AllianceItem;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.modules.memberface.TroopMemberFaceUpdateSource;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.MemberCommonInfo;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopBatchFetch;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troop.TroopListRepo;
import com.tencent.qqnt.troop.ab;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.state.data.SquareJSConst;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u00bc\u0002\u0018\u0000 \u00e7\u00022\u00020\u0001:\u0002\u00e8\u0002B\t\u00a2\u0006\u0006\b\u00e6\u0002\u0010\u00fd\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\u00020\u00022\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0002J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\bH\u0002J\b\u00103\u001a\u00020\u0006H\u0002J\b\u00104\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0002J\u0014\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010:\u001a\u0004\u0018\u000106H\u0002J\n\u0010<\u001a\u0004\u0018\u00010;H\u0002J\n\u0010>\u001a\u0004\u0018\u00010=H\u0002J\u0006\u0010?\u001a\u00020\u0006J \u0010C\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010(\u001a\u00020'2\u0006\u0010B\u001a\u00020)J\u0006\u0010D\u001a\u00020\u0006J\u000e\u0010E\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$J\u0018\u0010I\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010GJ\u0018\u0010J\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010GJ\u0006\u0010K\u001a\u00020\u0006J$\u0010O\u001a\u00020\u00062\b\u0010L\u001a\u0004\u0018\u00010\b2\b\u0010M\u001a\u0004\u0018\u00010\b2\b\u0010N\u001a\u0004\u0018\u00010\bJ\u0006\u0010P\u001a\u00020\u0006J\u0006\u0010Q\u001a\u00020\u0006J\u0006\u0010R\u001a\u00020\u0006J\u0006\u0010S\u001a\u00020\u0006J\u0006\u0010T\u001a\u00020\u0006J\u0010\u0010U\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u00010@J\u0010\u0010V\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u00010@J+\u0010Z\u001a\u00020\u00062\b\u0010W\u001a\u0004\u0018\u00010\b2\b\u0010X\u001a\u0004\u0018\u00010\u000f2\b\u0010Y\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\bZ\u0010[JH\u0010b\u001a\u00020\u00062@\b\u0002\u0010a\u001a:\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\j\u0004\u0018\u0001``J\u0006\u0010c\u001a\u00020\u0006J\u0006\u0010d\u001a\u00020\u0006J\u0010\u0010g\u001a\u00020\u00062\b\u0010f\u001a\u0004\u0018\u00010eJ\u0010\u0010i\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\bJ\u0006\u0010j\u001a\u00020\u0006J\u0018\u0010m\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010lJ\u0010\u0010n\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000106J\u000e\u0010o\u001a\u00020\u00062\u0006\u00107\u001a\u000206J\u000e\u0010p\u001a\u00020\u00062\u0006\u00107\u001a\u000206J\u0010\u0010r\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u00010qJ \u0010s\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010l2\u0006\u0010A\u001a\u00020q2\u0006\u00107\u001a\u000206J\u0006\u0010t\u001a\u00020\u0002J\u0006\u0010u\u001a\u00020\u0006J\u0016\u0010w\u001a\u00020\u00062\u0006\u0010A\u001a\u00020q2\u0006\u0010v\u001a\u00020)R\u001e\u0010{\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR&\u0010B\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R,\u0010\u0088\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R(\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R+\u0010\u0095\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R.\u0010\u0098\u0001\u001a\u0004\u0018\u00010\b2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0090\u0001\u001a\u0006\b\u0097\u0001\u0010\u0092\u0001R*\u0010\u009d\u0001\u001a\u00020\u00022\u0007\u0010\u0083\u0001\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001e\u0010\u00a1\u0001\u001a\t\u0012\u0004\u0012\u00020$0\u009e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R#\u0010\u00a7\u0001\u001a\t\u0012\u0004\u0012\u00020$0\u00a2\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R)\u0010\u00ab\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a8\u0001\u0010\u0090\u0001\u001a\u0006\b\u00a9\u0001\u0010\u0092\u0001\"\u0006\b\u00aa\u0001\u0010\u0094\u0001R)\u0010\u00b0\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ac\u0001\u0010\u009a\u0001\u001a\u0006\b\u00ad\u0001\u0010\u009c\u0001\"\u0006\b\u00ae\u0001\u0010\u00af\u0001R,\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b1\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b2\u0001\u0010\u00b3\u0001\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001\"\u0006\b\u00b6\u0001\u0010\u00b7\u0001R)\u0010\u00be\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b9\u0001\u0010\u00a3\u0001\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001\"\u0006\b\u00bc\u0001\u0010\u00bd\u0001R)\u0010\u00c2\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00bf\u0001\u0010\u009a\u0001\u001a\u0006\b\u00c0\u0001\u0010\u009c\u0001\"\u0006\b\u00c1\u0001\u0010\u00af\u0001R)\u0010\u00c6\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c3\u0001\u0010\u009a\u0001\u001a\u0006\b\u00c4\u0001\u0010\u009c\u0001\"\u0006\b\u00c5\u0001\u0010\u00af\u0001R)\u0010\u00ca\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c7\u0001\u0010\u009a\u0001\u001a\u0006\b\u00c8\u0001\u0010\u009c\u0001\"\u0006\b\u00c9\u0001\u0010\u00af\u0001R+\u0010\u00ce\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00cb\u0001\u0010\u0090\u0001\u001a\u0006\b\u00cc\u0001\u0010\u0092\u0001\"\u0006\b\u00cd\u0001\u0010\u0094\u0001R2\u0010\u00d6\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00cf\u0001\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d0\u0001\u0010\u00d1\u0001\u001a\u0006\b\u00d2\u0001\u0010\u00d3\u0001\"\u0006\b\u00d4\u0001\u0010\u00d5\u0001R)\u0010\u00da\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d7\u0001\u0010\u009a\u0001\u001a\u0006\b\u00d8\u0001\u0010\u009c\u0001\"\u0006\b\u00d9\u0001\u0010\u00af\u0001R+\u0010\u00e1\u0001\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00db\u0001\u0010\u00dc\u0001\u001a\u0006\b\u00dd\u0001\u0010\u00de\u0001\"\u0006\b\u00df\u0001\u0010\u00e0\u0001R)\u0010\u00e5\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e2\u0001\u0010\u009a\u0001\u001a\u0006\b\u00e3\u0001\u0010\u009c\u0001\"\u0006\b\u00e4\u0001\u0010\u00af\u0001R)\u0010\u00e7\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e6\u0001\u0010\u009a\u0001\u001a\u0006\b\u00e7\u0001\u0010\u009c\u0001\"\u0006\b\u00e8\u0001\u0010\u00af\u0001R)\u0010\u00ec\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e9\u0001\u0010\u009a\u0001\u001a\u0006\b\u00ea\u0001\u0010\u009c\u0001\"\u0006\b\u00eb\u0001\u0010\u00af\u0001R)\u0010\u00f0\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ed\u0001\u0010\u00a3\u0001\u001a\u0006\b\u00ee\u0001\u0010\u00bb\u0001\"\u0006\b\u00ef\u0001\u0010\u00bd\u0001R2\u0010\u00f7\u0001\u001a\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00f1\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u00f2\u0001\u001a\u0006\b\u00f3\u0001\u0010\u00f4\u0001\"\u0006\b\u00f5\u0001\u0010\u00f6\u0001R8\u0010\u00fe\u0001\u001a\t\u0012\u0005\u0012\u00030\u00f8\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006 \n\u0006\b\u00f9\u0001\u0010\u00d1\u0001\u0012\u0006\b\u00fc\u0001\u0010\u00fd\u0001\u001a\u0006\b\u00fa\u0001\u0010\u00d3\u0001\"\u0006\b\u00fb\u0001\u0010\u00d5\u0001R,\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u00ff\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R)\u0010\u008a\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u009a\u0001\u001a\u0006\b\u0088\u0002\u0010\u009c\u0001\"\u0006\b\u0089\u0002\u0010\u00af\u0001R)\u0010\u008e\u0002\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008b\u0002\u0010\u009a\u0001\u001a\u0006\b\u008c\u0002\u0010\u009c\u0001\"\u0006\b\u008d\u0002\u0010\u00af\u0001RK\u0010\u0096\u0002\u001a$\u0012\u001f\u0012\u001d\u0012\u0007\u0012\u0005\u0018\u00010\u008f\u0002\u0018\u00010 j\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u008f\u0002\u0018\u0001`\u0090\u00020\u009e\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0091\u0002\u0010\u00a0\u0001\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002\"\u0006\b\u0094\u0002\u0010\u0095\u0002R*\u0010\u0099\u0002\u001a\u0013\u0012\u0004\u0012\u00020\b0 j\t\u0012\u0004\u0012\u00020\b`\u0090\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0002\u0010\u0098\u0002R6\u0010\u00a1\u0002\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u009a\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0002\u0010\u009c\u0002\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002\"\u0006\b\u009f\u0002\u0010\u00a0\u0002R\u001a\u0010\u00a5\u0002\u001a\u00030\u00a2\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0002\u0010\u00a4\u0002R\u0018\u0010\u00a9\u0002\u001a\u00030\u00a6\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0002\u0010\u00a8\u0002R\u001a\u0010\u00ad\u0002\u001a\u00030\u00aa\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0002\u0010\u00ac\u0002R\u001d\u0010\u00b3\u0002\u001a\u00030\u00ae\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00af\u0002\u0010\u00b0\u0002\u001a\u0006\b\u00b1\u0002\u0010\u00b2\u0002R*\u0010\u00bb\u0002\u001a\u00030\u00b4\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b5\u0002\u0010\u00b6\u0002\u001a\u0006\b\u00b7\u0002\u0010\u00b8\u0002\"\u0006\b\u00b9\u0002\u0010\u00ba\u0002R\u0018\u0010\u00bf\u0002\u001a\u00030\u00bc\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bd\u0002\u0010\u00be\u0002R\u0018\u0010\u00c3\u0002\u001a\u00030\u00c0\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c1\u0002\u0010\u00c2\u0002R\u0018\u0010\u00c7\u0002\u001a\u00030\u00c4\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c5\u0002\u0010\u00c6\u0002R\u0018\u0010\u00cb\u0002\u001a\u00030\u00c8\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c9\u0002\u0010\u00ca\u0002R\u0018\u0010\u00cf\u0002\u001a\u00030\u00cc\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cd\u0002\u0010\u00ce\u0002R\u001a\u0010\u00d3\u0002\u001a\u00030\u00d0\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d1\u0002\u0010\u00d2\u0002R\u0018\u0010\u00d7\u0002\u001a\u00030\u00d4\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d5\u0002\u0010\u00d6\u0002R\u0018\u0010\u00db\u0002\u001a\u00030\u00d8\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d9\u0002\u0010\u00da\u0002R\u001a\u0010\u00df\u0002\u001a\u00030\u00dc\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00dd\u0002\u0010\u00de\u0002R\u001a\u0010\u00e3\u0002\u001a\u00030\u00e0\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e1\u0002\u0010\u00e2\u0002R\"\u0010\u00e5\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e4\u0002\u0010z\u00a8\u0006\u00e9\u0002"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "isSuc", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "newTroopInfo", "", "q3", "", "newName", "l4", "", "memberUinList", "W2", "detailInfo", "", "result", "c3", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;", "data", "f3", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "levelInfo", "d3", "troopInfo", "j4", "b3", ICustomDataEditor.STRING_ARRAY_PARAM_3, "Lcom/tencent/mobileqq/troop/troopsetting/modules/memberface/TroopMemberFaceUpdateSource;", "source", "Z3", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/troop/TroopMemberCardInfo;", "list", "i4", "Lcom/tencent/mobileqq/troop/troopsetting/event/a;", "intent", "t2", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extra", "q2", "o2", "Lcom/tencent/qqnt/troopmemberlist/datasync/e;", "o3", "y2", "Y3", "troopuin", "v3", "g4", "i3", "f4", "Lcom/tencent/common/app/AppInterface;", "appInterface", "W3", "u2", "w2", "Lcom/tencent/mobileqq/troop/api/ITroopMemberInfoService;", "U2", "Lcom/tencent/robot/relation/api/IRobotRelationService;", "O2", "u3", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "bundle", "k3", "K2", "b4", "holdMsg", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "z3", "r2", "S3", "subAction", "actionName", "r3", "w3", "m4", "k4", "onCreate", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "t3", "p3", "colorNick", "colorNickId", "troopCard", "h4", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/qqnt/troop/FetchTroopInfoCallback;", "callback", "x3", "init", "C3", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "tmi", "e4", "newTroopName", "d4", "p2", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "j3", "v2", "K0", "X3", "Landroid/app/Activity;", "U3", "g3", "T3", ICustomDataEditor.NUMBER_PARAM_4, "arguments", "m2", "Lmqq/util/WeakReference;", "i", "Lmqq/util/WeakReference;", "activityRef", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "T2", "()Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "D", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "S2", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "R3", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "E", "Ljava/lang/String;", "getAuthKey", "()Ljava/lang/String;", "setAuthKey", "(Ljava/lang/String;)V", "authKey", UserInfo.SEX_FEMALE, "getAuthSig", "authSig", "G", "Z", "F2", "()Z", "mIsFromThirdApp", "Lkotlinx/coroutines/flow/MutableStateFlow;", "H", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_troopSettingIntent", "Lkotlinx/coroutines/flow/StateFlow;", "I", "Lkotlinx/coroutines/flow/StateFlow;", "V2", "()Lkotlinx/coroutines/flow/StateFlow;", "troopSettingIntent", "J", "B2", "setMCacheNTTroopName", "mCacheNTTroopName", "K", Constants.MMCCID, "setMIsQidianPrivateTroop", "(Z)V", "mIsQidianPrivateTroop", "Lcom/tencent/mobileqq/troop/troopurl/config/a;", "L", "Lcom/tencent/mobileqq/troop/troopurl/config/a;", "C2", "()Lcom/tencent/mobileqq/troop/troopurl/config/a;", "H3", "(Lcom/tencent/mobileqq/troop/troopurl/config/a;)V", "mConfigBean", "M", "I2", "()I", "setMSubmitTime", "(I)V", "mSubmitTime", "N", Constants.BASE_IN_PLUGIN_VERSION, "I3", "mHasChangedMsgNotify", "P", "z2", "F3", "hindChatIsChecked", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Q2", "O3", "shieldConfigIsChecked", BdhLogUtil.LogTag.Tag_Req, "J2", "M3", "mTroopMemo", "Ltencent/im/oidb/cmd0xe83/oidb_0xe83$AppInfo;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "R2", "()Ljava/util/List;", "Q3", "(Ljava/util/List;)V", "troopAppList", "T", "getMNeedRefreshed", "K3", "mNeedRefreshed", "U", "Landroid/content/Intent;", "H2", "()Landroid/content/Intent;", "L3", "(Landroid/content/Intent;)V", "mNewerGuideOpResult", "V", "E2", "J3", "mInviteJoinTroop", "W", "isInitialized", "setInitialized", "X", "getMFirstEnter", "setMFirstEnter", "mFirstEnter", "Y", NowProxyConstants.AccountInfoKey.A2, Constants.EMULATOR_INFO, "mActionFlag", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "L2", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setMemberUinListForCard", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "memberUinListForCard", "", "a0", "M2", "N3", "getMemberUins$annotations", "()V", "memberUins", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "b0", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "P2", "()Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "setSearchWayViewModel", "(Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;)V", "searchWayViewModel", "c0", "getMIsInit", "setMIsInit", "mIsInit", "d0", "m3", "P3", "isShowModifyTroopNameDialog", "Lbt2/d;", "Lkotlin/collections/ArrayList;", "e0", "N2", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setRobotList", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "robotList", "f0", "Ljava/util/ArrayList;", "adminUinListFrom0x899", "", "g0", "Ljava/util/Map;", "x2", "()Ljava/util/Map;", "E3", "(Ljava/util/Map;)V", "cachedUinToNameMap", "Lcom/tencent/mobileqq/troop/announcement/api/b;", "h0", "Lcom/tencent/mobileqq/troop/announcement/api/b;", "troopAnnouncementObserver", "Lcom/tencent/mobileqq/troop/troopapps/api/b;", "i0", "Lcom/tencent/mobileqq/troop/troopapps/api/b;", "troopAppObserver", "Lcom/tencent/mobileqq/troop/observer/i;", "j0", "Lcom/tencent/mobileqq/troop/observer/i;", "troopRedDotObserver", "Lcom/tencent/mobileqq/troop/api/observer/e;", "k0", "Lcom/tencent/mobileqq/troop/api/observer/e;", "getTroopObserver", "()Lcom/tencent/mobileqq/troop/api/observer/e;", "troopObserver", "Lcom/tencent/mobileqq/troop/api/observer/c;", "l0", "Lcom/tencent/mobileqq/troop/api/observer/c;", "getTroopModifyObserver", "()Lcom/tencent/mobileqq/troop/api/observer/c;", "setTroopModifyObserver", "(Lcom/tencent/mobileqq/troop/api/observer/c;)V", "troopModifyObserver", "com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$c", "m0", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$c;", "robotRelationObserver", "Lct2/b;", "n0", "Lct2/b;", "troopRobotObserver", "Lcom/tencent/mobileqq/troop/api/observer/f;", "o0", "Lcom/tencent/mobileqq/troop/api/observer/f;", "troopPushObserver", "Lcom/tencent/mobileqq/troop/association/api/b;", "p0", "Lcom/tencent/mobileqq/troop/association/api/b;", "troopAssociationObserver", "Lcom/tencent/mobileqq/troop/onlinemember/api/b;", "q0", "Lcom/tencent/mobileqq/troop/onlinemember/api/b;", "troopOnlineMemberObserver", "Lcom/tencent/mobileqq/troop/troopsetting/api/b;", "r0", "Lcom/tencent/mobileqq/troop/troopsetting/api/b;", "troopSettingObserver", "Lcom/tencent/mobileqq/troop/api/ITroopMemberInfoService$b;", "s0", "Lcom/tencent/mobileqq/troop/api/ITroopMemberInfoService$b;", "troopMemberUpdateObserver", "Lcom/tencent/qqnt/troop/ab;", "t0", "Lcom/tencent/qqnt/troop/ab;", "troopInfoChangedObserver", "Ljava/lang/Runnable;", "u0", "Ljava/lang/Runnable;", "mInitRunnable", "Lcom/tencent/mobileqq/troop/troopapps/api/ITroopCardAppInfoHelperApi$a;", "v0", "Lcom/tencent/mobileqq/troop/troopapps/api/ITroopCardAppInfoHelperApi$a;", "mIGetAppInfoCB", "w0", "cachedApp", "<init>", "x0", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TroopInfoData troopInfoData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TroopInfo troopInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String authKey;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String authSig;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsFromThirdApp;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<com.tencent.mobileqq.troop.troopsetting.event.a> _troopSettingIntent;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<com.tencent.mobileqq.troop.troopsetting.event.a> troopSettingIntent;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String mCacheNTTroopName;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mIsQidianPrivateTroop;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopurl.config.a mConfigBean;

    /* renamed from: M, reason: from kotlin metadata */
    private int mSubmitTime;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mHasChangedMsgNotify;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hindChatIsChecked;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean shieldConfigIsChecked;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String mTroopMemo;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private List<oidb_0xe83$AppInfo> troopAppList;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mNeedRefreshed;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Intent mNewerGuideOpResult;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mInviteJoinTroop;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isInitialized;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean mFirstEnter;

    /* renamed from: Y, reason: from kotlin metadata */
    private int mActionFlag;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private CopyOnWriteArrayList<String> memberUinListForCard;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> memberUins;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b searchWayViewModel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInit;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isShowModifyTroopNameDialog;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableStateFlow<ArrayList<bt2.d>> robotList;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> adminUinListFrom0x899;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> cachedUinToNameMap;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.announcement.api.b troopAnnouncementObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<QBaseActivity> activityRef;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopapps.api.b troopAppObserver;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.observer.i troopRedDotObserver;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.api.observer.e troopObserver;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.api.observer.c troopModifyObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle bundle;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c robotRelationObserver;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ct2.b troopRobotObserver;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.api.observer.f troopPushObserver;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.association.api.b troopAssociationObserver;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.onlinemember.api.b troopOnlineMemberObserver;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.troopsetting.api.b troopSettingObserver;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ITroopMemberInfoService.b troopMemberUpdateObserver;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ab troopInfoChangedObserver;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable mInitRunnable;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ITroopCardAppInfoHelperApi.a mIGetAppInfoCB;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AppInterface> cachedApp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$b", "Lcom/tencent/mobileqq/troop/troopapps/api/ITroopCardAppInfoHelperApi$a;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/troopapps/data/TroopAppInfo;", "appInfoList", "", "onSuccess", "onFailed", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ITroopCardAppInfoHelperApi.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.a
        public void onFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.a
        public void onSuccess(@Nullable ArrayList<TroopAppInfo> appInfoList) {
            ITroopAppService iTroopAppService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInfoList);
                return;
            }
            if (TroopSettingViewModel.this.activityRef.get() != 0) {
                QBaseActivity qBaseActivity = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                boolean z16 = false;
                if (qBaseActivity != null && qBaseActivity.isFinishing()) {
                    z16 = true;
                }
                if (!z16 && appInfoList != null && appInfoList.size() != 0) {
                    ArrayList<Long> arrayList = new ArrayList<>();
                    AppInterface w26 = TroopSettingViewModel.this.w2();
                    if (w26 != null) {
                        iTroopAppService = (ITroopAppService) w26.getRuntimeService(ITroopAppService.class, "all");
                    } else {
                        iTroopAppService = null;
                    }
                    Iterator<TroopAppInfo> it = appInfoList.iterator();
                    while (it.hasNext()) {
                        TroopAppInfo next = it.next();
                        if (iTroopAppService != null) {
                            iTroopAppService.addTroopAppInfo(Long.valueOf(next.appId), next);
                        }
                        arrayList.add(Long.valueOf(next.appId));
                    }
                    if (iTroopAppService != null) {
                        iTroopAppService.setTroopCardAppListCache(TroopSettingViewModel.this.T2().troopUin, arrayList);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$c", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "f", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements a54.a {
        c() {
        }

        @Override // a54.a
        public void a(@NotNull String str) {
            a.C0013a.e(this, str);
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
        public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.c(this, robotUin, troopUin, extraData);
            if (TroopSettingViewModel.this.T2().troopUin != null && Intrinsics.areEqual(troopUin, TroopSettingViewModel.this.T2().troopUin)) {
                TroopSettingViewModel.this.K3(true);
            }
        }

        @Override // a54.a
        public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(@NotNull String robotUin, @NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.f(this, robotUin, troopUin);
            if (TroopSettingViewModel.this.T2().troopUin != null && Intrinsics.areEqual(troopUin, TroopSettingViewModel.this.T2().troopUin)) {
                TroopSettingViewModel.this.K3(true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$d", "Lcom/tencent/mobileqq/troop/announcement/api/b;", "", "suc", "", "troopUin", "strMemo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends com.tencent.mobileqq.troop.announcement.api.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.announcement.api.b
        protected void a(boolean suc, @Nullable String troopUin, @Nullable String strMemo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(suc), troopUin, strMemo);
                return;
            }
            if (suc && TextUtils.equals(troopUin, TroopSettingViewModel.this.S2().troopuin)) {
                if (TextUtils.isEmpty(strMemo)) {
                    strMemo = TroopSettingViewModel.this.S2().getLatestMemo();
                }
                if (QLog.isColorLevel()) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("get last memo [%s, %s]", Arrays.copyOf(new Object[]{troopUin, strMemo}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    QLog.i("TroopSettingViewModel", 2, format);
                }
                if (!TextUtils.isEmpty(strMemo)) {
                    TroopSettingViewModel.this.b4(new a.ae(strMemo));
                }
                TroopSettingViewModel.this.M3(strMemo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$e", "Lcom/tencent/mobileqq/troop/troopapps/api/b;", "Ltencent/im/oidb/cmd0xe83/oidb_0xe83$RspBody;", "data", "", "serviceType", "", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e extends com.tencent.mobileqq.troop.troopapps.api.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.b
        protected void c(@Nullable oidb_0xe83$RspBody data, int serviceType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, serviceType);
                return;
            }
            if (data != null && data.group_id.has()) {
                String valueOf = String.valueOf(data.group_id.get());
                if (!TextUtils.equals(TroopSettingViewModel.this.T2().troopUin, valueOf)) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopSettingViewModel", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + valueOf + ", current uin=" + TroopSettingViewModel.this.T2().troopUin);
                        return;
                    }
                    return;
                }
                if (serviceType == 0) {
                    TroopSettingViewModel.this.b4(new a.x(data));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("TroopSettingViewModel", 2, "onGetNewTroopAppList group_id lost. current uin=" + TroopSettingViewModel.this.T2().troopUin);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$f", "Lcom/tencent/mobileqq/troop/association/api/b;", "", "isSuc", "", "troopUin", "", "opType", "", "getSeq", "Lcom/tencent/mobileqq/troop/association/data/AllianceItem;", "allianceItem", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class f extends com.tencent.mobileqq.troop.association.api.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.association.api.b
        protected void a(boolean isSuc, @Nullable String troopUin, int opType, long getSeq, @Nullable AllianceItem allianceItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), troopUin, Integer.valueOf(opType), Long.valueOf(getSeq), allianceItem);
            } else if (isSuc && TextUtils.equals(troopUin, TroopSettingViewModel.this.T2().troopUin) && allianceItem != null) {
                TroopSettingViewModel.this.b4(new a.y(allianceItem.associatedTroopCount));
            } else {
                TroopSettingViewModel.this.b4(new a.y(0));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$g", "Lcom/tencent/mobileqq/troop/troopsetting/api/impl/a;", "", "troopUin", "memberUin", "", "f", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class g extends com.tencent.mobileqq.troop.troopsetting.api.impl.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
        public void f(@Nullable String troopUin, @Nullable String memberUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) memberUin);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J6\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$h", "Lcom/tencent/mobileqq/troop/api/observer/c;", "", "isSuccess", "", "troopUin", "", "d", "newName", "errorMsg", "", QzoneIPCModule.RESULT_CODE, "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class h extends com.tencent.mobileqq.troop.api.observer.c {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.api.observer.c
        public void b(boolean isSuccess, @Nullable String troopUin, @Nullable String newName, @Nullable String errorMsg, int resultCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), troopUin, newName, errorMsg, Integer.valueOf(resultCode));
                return;
            }
            super.b(isSuccess, troopUin, newName, errorMsg, resultCode);
            if (TextUtils.equals(TroopSettingViewModel.this.T2().troopUin, troopUin)) {
                com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.f();
                if (isSuccess) {
                    TroopSettingViewModel.this.T2().hasSetNewTroopName = true;
                    if (newName != null) {
                        TroopSettingViewModel.this.l4(newName);
                    }
                    QBaseActivity qBaseActivity = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                    if (qBaseActivity == null || !qBaseActivity.isResume()) {
                        z16 = false;
                    }
                    if (z16 && TroopSettingViewModel.this.m3()) {
                        TroopSettingViewModel.this.S2().isNewTroop = false;
                        TroopSettingViewModel.this.P3(false);
                        TroopSettingViewModel.this.b4(a.ai.f301113a);
                        return;
                    }
                    return;
                }
                if (resultCode == 1328) {
                    TroopSettingViewModel.this.b4(a.d.f301116a);
                }
                if (TextUtils.isEmpty(errorMsg)) {
                    errorMsg = HardCodeUtil.qqStr(R.string.khc);
                }
                QQToast makeText = QQToast.makeText((Context) TroopSettingViewModel.this.activityRef.get(), 1, errorMsg, 0);
                QBaseActivity qBaseActivity2 = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                if (qBaseActivity2 != null) {
                    i3 = qBaseActivity2.getTitleBarHeight();
                }
                makeText.show(i3);
                if (TroopSettingViewModel.this.S2().getTroopUin() != null) {
                    TroopSettingViewModel.this.T2().troopName = TroopSettingViewModel.this.S2().getTroopDisplayName();
                    TroopSettingViewModel.this.m4();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSettingViewModel", 2, errorMsg);
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.c
        protected void d(boolean isSuccess, @Nullable String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin);
            } else if (TextUtils.equals(TroopSettingViewModel.this.T2().troopUin, troopUin) && isSuccess) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSettingViewModel", 2, "onUpdateTroopSearchApproachPageTroopInfoUpdated ");
                }
                TroopSettingViewModel.this.u3();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u001e\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000bH\u0014J0\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u001e\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u000bH\u0014J:\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u001e\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0014J>\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0014\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$i", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "troopUin", "newTroopName", "", "onGenNewTroopName", "", "isSuc", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lkotlin/collections/ArrayList;", "list", "onGetMutilTroopInfoResult", "Lcom/tencent/mobileqq/data/troop/TroopMemberCardInfo;", "onModifyTroopInfoPushResult", "errorMsg", "onModifyTroopInfoResult", "isSuccess", "", "errorCode", SquareJSConst.Params.PARAMS_UIN_LIST, "onDeleteTroopMember", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfoList", "onTroopMemberListFirstInited", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class i extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TroopSettingViewModel this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i3();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onDeleteTroopMember(boolean isSuccess, int errorCode, @Nullable ArrayList<String> uinList, @Nullable String troopUin) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(isSuccess), Integer.valueOf(errorCode), uinList, troopUin);
                return;
            }
            if (!isSuccess) {
                if (errorCode == 2) {
                    QQToast makeText = QQToast.makeText((Context) TroopSettingViewModel.this.activityRef.get(), 1, HardCodeUtil.qqStr(R.string.khi), 0);
                    QBaseActivity qBaseActivity = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                    if (qBaseActivity != null) {
                        i3 = qBaseActivity.getTitleBarHeight();
                    }
                    makeText.show(i3);
                    return;
                }
                return;
            }
            if (TroopSettingViewModel.this.S2().troopuin != null) {
                str = TroopSettingViewModel.this.S2().troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
            } else {
                str = "";
            }
            if (TroopSettingViewModel.this.L2() == null) {
                return;
            }
            if (troopUin != null && Intrinsics.areEqual(troopUin, str) && uinList != null) {
                TroopSettingViewModel troopSettingViewModel = TroopSettingViewModel.this;
                for (String str2 : uinList) {
                    CopyOnWriteArrayList<String> L2 = troopSettingViewModel.L2();
                    if (L2 != null) {
                        L2.remove(str2);
                    }
                }
            }
            TroopSettingViewModel.this.T2().wMemberNum = TroopSettingViewModel.this.S2().getMemberNum();
            TroopSettingViewModel.this.b4(a.h.f301120a);
            TroopSettingViewModel.this.Z3(TroopMemberFaceUpdateSource.DELETE_MEMBER_HOST);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGenNewTroopName(@Nullable String troopUin, @Nullable String newTroopName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) newTroopName);
                return;
            }
            TroopSettingViewModel.this.T2().newTroopName = TroopSettingViewModel.this.S2().getNewTroopNameOrTroopName();
            TroopSettingViewModel.this.m4();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetMutilTroopInfoResult(boolean isSuc, @Nullable ArrayList<TroopInfo> list) {
            Resources resources;
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuc), list);
                return;
            }
            if (isSuc && list != null && list.size() != 0) {
                BusinessHandler businessHandler = null;
                TroopInfo troopInfo = null;
                for (int i3 = 0; troopInfo == null && i3 < list.size(); i3++) {
                    troopInfo = list.get(i3);
                    if (troopInfo != null) {
                        str2 = troopInfo.troopuin;
                    } else {
                        str2 = null;
                    }
                    if (!Utils.p(str2, TroopSettingViewModel.this.T2().troopUin)) {
                        troopInfo = null;
                    }
                }
                if (troopInfo != null) {
                    TroopSettingViewModel.this.R3(troopInfo);
                    TroopInfoData T2 = TroopSettingViewModel.this.T2();
                    QBaseActivity qBaseActivity = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                    if (qBaseActivity != null) {
                        resources = qBaseActivity.getResources();
                    } else {
                        resources = null;
                    }
                    AppInterface w26 = TroopSettingViewModel.this.w2();
                    if (w26 != null) {
                        str = w26.getCurrentAccountUin();
                    } else {
                        str = null;
                    }
                    T2.updateForTroopChatSetting(troopInfo, resources, str);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopSettingViewModel", 2, "onGetMutilTroopInfoResult send MSG_UPDATE_INFO msg");
                    }
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final TroopSettingViewModel troopSettingViewModel = TroopSettingViewModel.this;
                    uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopSettingViewModel.i.b(TroopSettingViewModel.this);
                        }
                    });
                    try {
                        String str3 = TroopSettingViewModel.this.T2().troopUin;
                        Intrinsics.checkNotNullExpressionValue(str3, "troopInfoData.troopUin");
                        long parseLong = Long.parseLong(str3);
                        String str4 = TroopSettingViewModel.this.T2().troopCode;
                        Intrinsics.checkNotNullExpressionValue(str4, "troopInfoData.troopCode");
                        long parseLong2 = Long.parseLong(str4);
                        AppInterface w27 = TroopSettingViewModel.this.w2();
                        if (w27 != null) {
                            businessHandler = w27.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
                        }
                        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler");
                        ((com.tencent.mobileqq.troop.announcement.api.a) businessHandler).b1(0, parseLong2, parseLong, 0L, "", 0, (short) 23, false, false);
                    } catch (Exception e16) {
                        QLog.e("TroopSettingViewModel", 1, "[onGetMutilTroopInfoResult] exception = " + e16);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onModifyTroopInfoPushResult(boolean isSuc, @Nullable ArrayList<TroopMemberCardInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSuc), list);
            } else if (isSuc && list != null) {
                TroopSettingViewModel.this.i4(list);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onModifyTroopInfoResult(boolean isSuc, @Nullable ArrayList<TroopMemberCardInfo> list, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isSuc), list, errorMsg);
                return;
            }
            if (isSuc && list != null && list.size() != 0) {
                z16 = TroopSettingViewModel.this.i4(list);
            }
            if (!isSuc && !TextUtils.isEmpty(errorMsg)) {
                QBaseActivity qBaseActivity = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                if (qBaseActivity != null) {
                    com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                    if (errorMsg == null) {
                        errorMsg = "";
                    }
                    aVar.j(qBaseActivity, 2, errorMsg, 1000);
                    return;
                }
                return;
            }
            if (!isSuc && (TroopSettingViewModel.this.A2() & 1) == 1) {
                TroopSettingViewModel troopSettingViewModel = TroopSettingViewModel.this;
                troopSettingViewModel.G3(troopSettingViewModel.A2() & (-2));
                QBaseActivity qBaseActivity2 = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                if (qBaseActivity2 != null) {
                    com.tencent.mobileqq.troop.troopsetting.activity.a aVar2 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                    String string = qBaseActivity2.getResources().getString(R.string.ca_);
                    Intrinsics.checkNotNullExpressionValue(string, "it.resources.getString(c\u2026my_troopmember_card_fail)");
                    aVar2.j(qBaseActivity2, 2, string, 1000);
                    return;
                }
                return;
            }
            if (z16 && (TroopSettingViewModel.this.A2() & 1) == 1) {
                TroopSettingViewModel troopSettingViewModel2 = TroopSettingViewModel.this;
                troopSettingViewModel2.G3(troopSettingViewModel2.A2() & (-2));
                QBaseActivity qBaseActivity3 = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
                if (qBaseActivity3 != null) {
                    com.tencent.mobileqq.troop.troopsetting.activity.a aVar3 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                    String string2 = qBaseActivity3.getResources().getString(R.string.caa);
                    Intrinsics.checkNotNullExpressionValue(string2, "it.resources.getString(c\u2026_troopmember_card_sucess)");
                    aVar3.j(qBaseActivity3, 1, string2, 1000);
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopMemberListFirstInited(@NotNull String troopUin, @NotNull List<TroopMemberInfo> troopMemberInfoList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopUin, (Object) troopMemberInfoList);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(troopMemberInfoList, "troopMemberInfoList");
            TroopSettingViewModel troopSettingViewModel = TroopSettingViewModel.this;
            troopSettingViewModel.W2(troopSettingViewModel.L2());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$j", "Lcom/tencent/mobileqq/troop/onlinemember/api/b;", "", "isSuccess", "", "troopUin", "isChanged", "", "e", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class j extends com.tencent.mobileqq.troop.onlinemember.api.b {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void e(boolean isSuccess, @Nullable String troopUin, boolean isChanged) {
            AppInterface w26;
            ITroopOnlineMemberService iTroopOnlineMemberService;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, Boolean.valueOf(isChanged));
                return;
            }
            if (isSuccess) {
                if (isChanged && TroopSettingViewModel.this.w2() != null && (w26 = TroopSettingViewModel.this.w2()) != null && (iTroopOnlineMemberService = (ITroopOnlineMemberService) w26.getRuntimeService(ITroopOnlineMemberService.class, "")) != null) {
                    iTroopOnlineMemberService.removeDetailOnlineData(TroopSettingViewModel.this.T2().troopUin);
                    return;
                }
                return;
            }
            QQToast makeText = QQToast.makeText(BaseApplication.getContext(), R.string.dqp, 0);
            QBaseActivity qBaseActivity = (QBaseActivity) TroopSettingViewModel.this.activityRef.get();
            if (qBaseActivity != null) {
                i3 = qBaseActivity.getTitleBarHeight();
            }
            makeText.show(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$k", "Lcom/tencent/mobileqq/troop/api/observer/f;", "", "isSucc", "", "troopUin", "", "oldGroupFlagExt4", "", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class k extends com.tencent.mobileqq.troop.api.observer.f {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.f
        protected void d(boolean isSucc, @Nullable String troopUin, int oldGroupFlagExt4) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSucc), troopUin, Integer.valueOf(oldGroupFlagExt4));
                return;
            }
            if (TroopSettingViewModel.this.T2().troopUin != null && Intrinsics.areEqual(TroopSettingViewModel.this.T2().troopUin, troopUin)) {
                TroopSettingViewModel troopSettingViewModel = TroopSettingViewModel.this;
                TroopInfo u26 = troopSettingViewModel.u2(troopSettingViewModel.T2().troopUin);
                if (u26 != null) {
                    ITroopSPUtilApi iTroopSPUtilApi = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
                    AppInterface w26 = TroopSettingViewModel.this.w2();
                    if (w26 != null) {
                        str = w26.getCurrentUin();
                    } else {
                        str = null;
                    }
                    iTroopSPUtilApi.setTroopGameCardRedPoint(str, TroopSettingViewModel.this.T2().troopUin, u26.isTroopGameCardEnabled());
                    TroopSettingViewModel.this.b4(a.ab.f301106a);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J2\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$l", "Lcom/tencent/mobileqq/troop/observer/i;", "", "isSuc", "", "troopUin", "", "c", "isPush", "", "Lcom/tencent/mobileqq/troop/unreadmsg/a;", "list", "", "redPointCount", "f", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class l extends com.tencent.mobileqq.troop.observer.i {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.observer.i
        public void c(boolean isSuc, @Nullable String troopUin) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), troopUin);
                return;
            }
            super.c(isSuc, troopUin);
            if (isSuc) {
                TroopInfoData T2 = TroopSettingViewModel.this.T2();
                ITroopSPUtilApi iTroopSPUtilApi = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
                AppInterface w26 = TroopSettingViewModel.this.w2();
                if (w26 != null) {
                    str = w26.getCurrentAccountUin();
                } else {
                    str = null;
                }
                T2.nNewFileMsgNum = iTroopSPUtilApi.groupGroupNewsInfo(str, ITroopSPUtilApi.KEY_FILE_NEW, TroopSettingViewModel.this.T2().troopUin);
                TroopSettingViewModel.this.T2().nUnreadFileMsgnum = 0;
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.i
        protected void f(boolean isSuc, boolean isPush, @Nullable List<? extends com.tencent.mobileqq.troop.unreadmsg.a> list, int redPointCount) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuc), Boolean.valueOf(isPush), list, Integer.valueOf(redPointCount));
                return;
            }
            if (isSuc) {
                List<? extends com.tencent.mobileqq.troop.unreadmsg.a> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        com.tencent.mobileqq.troop.unreadmsg.a aVar = list.get(i3);
                        if (aVar != null && Utils.p(aVar.f301845b, TroopSettingViewModel.this.T2().troopUin)) {
                            long j3 = aVar.f301844a;
                            if (j3 == 2) {
                                TroopSettingViewModel.this.T2().nNewPhotoNum = aVar.f301847d;
                                TroopSettingViewModel.this.T2().nUnreadMsgNum = aVar.f301846c;
                                if (isPush) {
                                    TroopSettingViewModel.this.b4(a.ah.f301112a);
                                }
                            } else if (j3 == 1) {
                                TroopSettingViewModel.this.T2().nUnreadFileMsgnum = aVar.f301846c;
                                TroopSettingViewModel.this.T2().nNewFileMsgNum = aVar.f301847d;
                            } else if (j3 == 1101236949) {
                                TroopSettingViewModel.this.T2().mNewTroopNotificationNum = aVar.f301847d;
                            } else if (j3 == 1106664488) {
                                TroopSettingViewModel.this.T2().nUnreadFileMsgnum = 1;
                                TroopSettingViewModel.this.T2().nNewFileMsgNum = aVar.f301847d;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("TroopSettingViewModel", 2, "onUpdateTroopUnreadMsg| isPush = " + isPush + ", " + aVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J@\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001e\u0010\u0011\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0010H\u0014\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$m", "Lct2/b;", "", "troopUin", "robotUin", "robotName", "", "b", "", "success", "", QzoneIPCModule.RESULT_CODE, "", "troopuin", "Ljava/util/ArrayList;", "Lbt2/d;", "Lkotlin/collections/ArrayList;", "troopRobotInfos", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class m extends ct2.b {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // ct2.b
        protected void b(@Nullable String troopUin, @Nullable String robotUin, @Nullable String robotName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopUin, robotUin, robotName);
            } else if (troopUin != null && TroopSettingViewModel.this.T2().troopUin != null && Intrinsics.areEqual(troopUin, TroopSettingViewModel.this.T2().troopUin)) {
                TroopSettingViewModel.this.K3(true);
            }
        }

        @Override // ct2.b
        protected void c(boolean success, int resultCode, long troopuin, @Nullable ArrayList<bt2.d> troopRobotInfos) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(success), Integer.valueOf(resultCode), Long.valueOf(troopuin), troopRobotInfos);
                return;
            }
            if (QLog.isColorLevel()) {
                if (troopRobotInfos != null) {
                    str = troopRobotInfos.toString();
                } else {
                    str = null;
                }
                QLog.d("TroopSettingViewModel", 2, "RobotMemberFormItem onGetAddedRobots suc:" + success + " retCode:" + resultCode + " troopuin:" + troopuin + " infos:" + str);
            }
            TroopSettingViewModel.this.N2().setValue(troopRobotInfos);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$n", "Lcom/tencent/mobileqq/troop/troopsetting/api/b;", "", "isSuccess", "", "troopUin", "memberUin", "", "op", "type", "", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class n extends com.tencent.mobileqq.troop.troopsetting.api.b {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsetting.api.b
        protected void c(boolean isSuccess, @Nullable String troopUin, @Nullable String memberUin, int op5, int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, memberUin, Integer.valueOf(op5), Integer.valueOf(type));
                return;
            }
            if (troopUin != null && TroopSettingViewModel.this.T2().troopUin != null && Intrinsics.areEqual(troopUin, TroopSettingViewModel.this.T2().troopUin) && type == 512) {
                if (isSuccess) {
                    ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).updateHiddenChat(TroopSettingViewModel.this.w2(), TroopSettingViewModel.this.S2());
                } else {
                    TroopSettingViewModel.this.b4(a.i.f301121a);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel$o", "Lcom/tencent/qqnt/troopmemberlist/g;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class o implements com.tencent.qqnt.troopmemberlist.g {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
            } else {
                TroopSettingViewModel.this.e4(troopMemberInfo);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 90)) {
            redirector.redirect((short) 90);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingViewModel() {
        Map<String, String> emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.activityRef = new WeakReference<>(null);
        this.troopInfoData = new TroopInfoData();
        this.troopInfo = new TroopInfo("");
        MutableStateFlow<com.tencent.mobileqq.troop.troopsetting.event.a> MutableStateFlow = StateFlowKt.MutableStateFlow(a.e.f301117a);
        this._troopSettingIntent = MutableStateFlow;
        this.troopSettingIntent = MutableStateFlow;
        this.mCacheNTTroopName = "";
        this.memberUins = new ArrayList();
        this.mIsInit = true;
        this.robotList = StateFlowKt.MutableStateFlow(new ArrayList());
        this.adminUinListFrom0x899 = new ArrayList<>();
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.cachedUinToNameMap = emptyMap;
        this.troopAnnouncementObserver = new d();
        this.troopAppObserver = new e();
        this.troopRedDotObserver = new l();
        this.troopObserver = new i();
        this.troopModifyObserver = new h();
        this.robotRelationObserver = new c();
        this.troopRobotObserver = new m();
        this.troopPushObserver = new k();
        this.troopAssociationObserver = new f();
        this.troopOnlineMemberObserver = new j();
        this.troopSettingObserver = new n();
        this.troopMemberUpdateObserver = new g();
        this.troopInfoChangedObserver = new ab() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.j
            @Override // com.tencent.qqnt.troop.ab
            public final void a(TroopInfo troopInfo) {
                TroopSettingViewModel.V3(TroopSettingViewModel.this, troopInfo);
            }
        };
        this.mInitRunnable = new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.k
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingViewModel.n3(TroopSettingViewModel.this);
            }
        };
        this.mIGetAppInfoCB = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A3(TroopSettingViewModel this$0, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        this$0.b4(new a.j(z16, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D3(TroopSettingViewModel this$0, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e4(troopMemberInfo);
    }

    private final IRobotRelationService O2() {
        AppInterface w26 = w2();
        if (w26 != null) {
            return (IRobotRelationService) w26.getRuntimeService(IRobotRelationService.class, "");
        }
        return null;
    }

    private final ITroopMemberInfoService U2() {
        AppInterface w26 = w2();
        if (w26 != null) {
            return (ITroopMemberInfoService) w26.getRuntimeService(ITroopMemberInfoService.class, "");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V3(TroopSettingViewModel this$0, TroopInfo it) {
        boolean z16;
        AppInterface w26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        String str = this$0.troopInfoData.troopUin;
        Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopUin");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(it.troopuin, this$0.troopInfoData.troopUin)) {
            this$0.b4(new a.k(it));
            if (it.dwGroupClassExt != this$0.troopInfoData.dwGroupClassExt && (w26 = this$0.w2()) != null) {
                this$0.X3(w26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARN: Type inference failed for: r5v29, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v6, types: [T, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W2(List<String> memberUinList) {
        boolean z16;
        ITroopRobotService iTroopRobotService;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        List<String> list = memberUinList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ArrayList arrayList = new ArrayList();
        AppInterface w26 = w2();
        if (w26 != null) {
            iTroopRobotService = (ITroopRobotService) w26.getRuntimeService(ITroopRobotService.class, "all");
        } else {
            iTroopRobotService = null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = this.adminUinListFrom0x899.iterator();
        while (it.hasNext()) {
            ?? r95 = (String) it.next();
            if (this.troopInfo.isTroopOwner(r95)) {
                objectRef.element = r95;
            } else {
                arrayList2.add(r95);
            }
        }
        for (String str : memberUinList) {
            if (!this.troopInfo.isTroopOwner(str) && !this.adminUinListFrom0x899.contains(str)) {
                if (iTroopRobotService != null && iTroopRobotService.isRobotUin(str)) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (z27) {
                    arrayList.add(str);
                } else {
                    arrayList3.add(str);
                }
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (objectRef.element == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopSettingViewModel", 2, "handle0X8990: not found troop owner, auto generate");
            }
            String str2 = this.troopInfo.troopowneruin;
            if (str2 != null && str2.length() != 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (!z19) {
                objectRef.element = this.troopInfo.troopowneruin;
            } else {
                String str3 = this.troopInfo.troopOwnerUid;
                if (str3 != null && str3.length() != 0) {
                    z26 = false;
                } else {
                    z26 = true;
                }
                if (!z26) {
                    ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.troopInfo.troopOwnerUid, false, true, new IRelationNTUinAndUidApi.e() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.o
                        @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.e
                        public final void a(String str4) {
                            TroopSettingViewModel.Y2(Ref.ObjectRef.this, str4);
                        }
                    });
                }
            }
        }
        String str4 = (String) objectRef.element;
        if (str4 != null) {
            if (str4.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z17 = true;
                if (!z17) {
                    String str5 = (String) objectRef.element;
                    if (str5 != null) {
                        arrayList4.add(0, str5);
                    }
                } else {
                    TroopInfo troopInfo = this.troopInfo;
                    QLog.e("TroopSettingViewModel", 1, "handle0X8990: not found troop owner, uin=" + troopInfo.troopowneruin + ", uid=" + troopInfo.troopOwnerUid);
                }
                arrayList4.addAll(arrayList2);
                arrayList4.addAll(arrayList3);
                arrayList4.addAll(arrayList);
                this.memberUinListForCard = new CopyOnWriteArrayList<>(arrayList4);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSettingViewModel", 2, "handle0X899_0,memberListForCard.size = " + arrayList4.size());
                }
                TroopExtDBInfoRepo.INSTANCE.updateTroopSettingMemberList(this.troopInfo.getTroopUin(), arrayList4);
                Z3(TroopMemberFaceUpdateSource.NETWORK_REQUEST_0X899);
                TroopMemberExtInfoRepo troopMemberExtInfoRepo = TroopMemberExtInfoRepo.INSTANCE;
                String str6 = this.troopInfoData.troopUin;
                Intrinsics.checkNotNullExpressionValue(str6, "troopInfoData.troopUin");
                troopMemberExtInfoRepo.fetchTroopMemberNickName(str6, arrayList4, true, null, this.activityRef.get(), new Function2<Boolean, Map<String, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$handle0X8990$4
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends String> map) {
                        invoke(bool.booleanValue(), (Map<String, String>) map);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z28, @NotNull Map<String, String> uin2NameMap) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z28), uin2NameMap);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(uin2NameMap, "uin2NameMap");
                        if (z28) {
                            TroopSettingViewModel.this.E3(uin2NameMap);
                            TroopSettingViewModel.this.Z3(TroopMemberFaceUpdateSource.BATCH_FETCH_TROOP_INFO);
                        }
                    }
                });
            }
        }
        z17 = false;
        if (!z17) {
        }
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        arrayList4.addAll(arrayList);
        this.memberUinListForCard = new CopyOnWriteArrayList<>(arrayList4);
        if (QLog.isColorLevel()) {
        }
        TroopExtDBInfoRepo.INSTANCE.updateTroopSettingMemberList(this.troopInfo.getTroopUin(), arrayList4);
        Z3(TroopMemberFaceUpdateSource.NETWORK_REQUEST_0X899);
        TroopMemberExtInfoRepo troopMemberExtInfoRepo2 = TroopMemberExtInfoRepo.INSTANCE;
        String str62 = this.troopInfoData.troopUin;
        Intrinsics.checkNotNullExpressionValue(str62, "troopInfoData.troopUin");
        troopMemberExtInfoRepo2.fetchTroopMemberNickName(str62, arrayList4, true, null, this.activityRef.get(), new Function2<Boolean, Map<String, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$handle0X8990$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends String> map) {
                invoke(bool.booleanValue(), (Map<String, String>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z28, @NotNull Map<String, String> uin2NameMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z28), uin2NameMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(uin2NameMap, "uin2NameMap");
                if (z28) {
                    TroopSettingViewModel.this.E3(uin2NameMap);
                    TroopSettingViewModel.this.Z3(TroopMemberFaceUpdateSource.BATCH_FETCH_TROOP_INFO);
                }
            }
        });
    }

    private final void W3(AppInterface appInterface) {
        IRuntimeService runtimeService = appInterface.getRuntimeService(ITroopAppService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026ava, ProcessConstant.ALL)");
        if (((ITroopAppService) runtimeService).getProfileAppListChangedFromWebOperate(this.troopInfoData.troopUin)) {
            X3(appInterface);
            if (((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).isShowingAppShortCutBar(appInterface, this.troopInfoData.troopUin)) {
                IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
                TroopInfoData troopInfoData = this.troopInfoData;
                iChatSettingForTroopApi.refreshAppShortCutBarAppList(appInterface, troopInfoData.troopUin, (int) troopInfoData.dwGroupClassExt);
            }
        }
        if (this.mNeedRefreshed) {
            o2();
            this.mNeedRefreshed = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Y2(Ref.ObjectRef troopOwner, String it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopOwner, "$troopOwner");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            troopOwner.element = it;
        }
    }

    private final void Y3() {
        Object obj;
        if (this.troopInfo.getTroopUin() != null && this.troopInfo.isKingBattleTroop()) {
            AppInterface w26 = w2();
            if (w26 != null) {
                obj = w26.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName());
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler");
            ((com.tencent.mobileqq.troop.onlinemember.api.a) obj).E1(this.troopInfo.troopuin, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z3(TroopMemberFaceUpdateSource source) {
        Long longOrNull;
        long j3;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.memberUinListForCard;
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                String uin = it.next();
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = 0;
                }
                arrayList.add(Long.valueOf(j3));
            }
            this.memberUins = arrayList;
            if (QLog.isColorLevel()) {
                QLog.d("TroopSettingViewModel", 2, "[updateGridTroopMemberFace] from = " + source.ordinal() + " list size = " + copyOnWriteArrayList.size() + " memberUins.size = " + arrayList.size());
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.n
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingViewModel.a4(TroopSettingViewModel.this);
                }
            });
            return;
        }
        QLog.e("TroopSettingViewModel", 1, "[updateGridTroopMemberFace] failed. list is null. from = " + source.ordinal());
    }

    private final void a3() {
        QBaseActivity qBaseActivity = this.activityRef.get();
        if (qBaseActivity != null) {
            QQToast.makeText(qBaseActivity, R.string.cke, 1).show(qBaseActivity.getTitleBarHeight());
        }
        TroopListRepo troopListRepo = TroopListRepo.INSTANCE;
        String str = this.troopInfoData.troopUin;
        Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopUin");
        troopListRepo.deleteTroopInCache(str);
        this.troopInfo = new TroopInfo(this.troopInfoData.troopUin);
        this.troopInfoData.isMember = false;
        Intent intent = new Intent();
        Bundle bundle = this.bundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        intent.putExtra(AppConstants.Key.TROOP_INFO_IS_MEMBER, false);
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).popBack(this.activityRef.get());
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(this.activityRef.get(), intent.getExtras(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a4(TroopSettingViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity qBaseActivity = this$0.activityRef.get();
        if (qBaseActivity == null || qBaseActivity.isFinishing()) {
            return;
        }
        this$0.b4(a.u.f301134a);
    }

    private final void b3(TroopInfo detailInfo) {
        TroopInfoData troopInfoData = this.troopInfoData;
        if (troopInfoData.troopUin == null) {
            return;
        }
        troopInfoData.coverFrom(detailInfo);
        if (!TextUtils.isEmpty(this.troopInfoData.newTroopName)) {
            m4();
        }
        if (this.troopInfoData.hasSetNewTroopHead) {
            b4(a.m.f301126a);
        }
        long j3 = detailInfo.dwGroupFlagExt3;
        this.mIsQidianPrivateTroop = TroopInfo.isQidianPrivateTroop(j3);
        if (QLog.isColorLevel()) {
            QLog.d("TroopSettingViewModel", 2, "[handleTroopInfoAsMember] troopUin:" + this.troopInfoData.troopUin + ", flagExt3:" + j3 + ", mIsQidianPrivateTroop:" + this.mIsQidianPrivateTroop);
        }
        if (QLog.isColorLevel()) {
            short s16 = detailInfo.cGroupOption;
            QLog.i("TroopSettingViewModel", 2, "[handleTroopInfoAsMember] cGOption:" + ((int) s16) + ", troopPriFlag:" + detailInfo.troopPrivilegeFlag + ", dwGFlagExt:" + detailInfo.dwGroupFlagExt + ", isAdmin:" + detailInfo.isOwnerOrAdmin() + ", isOwner:" + detailInfo.isOwner());
        }
        if (this.troopInfo.getTroopUin() != null) {
            TroopInfo u26 = u2(this.troopInfoData.troopUin);
            if (u26 != null) {
                this.troopInfo = u26;
            }
            this.troopInfoData.newTroopName = this.troopInfo.getNewTroopNameOrTroopName();
        }
        if (this.mIsQidianPrivateTroop) {
            com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.o(this.troopInfoData);
        }
        b4(a.ai.f301113a);
        b4(a.g.f301119a);
        b4(a.v.f301135a);
        b4(a.u.f301134a);
        b4(new a.l(false));
    }

    private final void c3(TroopInfo detailInfo, int result) {
        if (result == 72) {
            a3();
            return;
        }
        if (result == 0 && detailInfo != null) {
            b3(detailInfo);
            return;
        }
        QLog.e("TroopSettingViewModel", 1, "[handleTroopInfoResp] receive 0x88d error:" + result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c4(TroopSettingViewModel this$0, com.tencent.mobileqq.troop.troopsetting.event.a intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        this$0.t2(intent);
    }

    private final void d3(String troopUin, GroupMemberExtListResult levelInfo) {
        if (levelInfo == null) {
            QLog.e("TroopSettingViewModel", 2, "[handleTroopMemberLevelResp] levelInfo is null");
            return;
        }
        TroopInfo u26 = u2(troopUin);
        if (u26 != null) {
            final com.tencent.qqnt.inner.compator.troopinfo.d dVar = new com.tencent.qqnt.inner.compator.troopinfo.d();
            dVar.b(u26);
            j4(levelInfo, troopUin, u26);
            dVar.a(u26);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.d
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingViewModel.e3(com.tencent.qqnt.inner.compator.troopinfo.d.this);
                }
            }, 8, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(com.tencent.qqnt.inner.compator.troopinfo.d comparator) {
        Intrinsics.checkNotNullParameter(comparator, "$comparator");
        comparator.c();
    }

    private final void f3(GroupMemberCommonListResult data) {
        if (data == null) {
            QLog.e("TroopSettingViewModel", 1, "[handleTroopMemberResp] data is null");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(data.memberList, "data.memberList");
        if ((!r1.isEmpty()) && data.identifyFlag == 5) {
            if (this.troopInfoData.isMember) {
                ArrayList arrayList = new ArrayList();
                ArrayList<MemberCommonInfo> arrayList2 = data.memberList;
                if (arrayList2 != null) {
                    Iterator<MemberCommonInfo> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(String.valueOf(it.next().memberUin));
                    }
                }
                W2(arrayList);
                return;
            }
            return;
        }
        ArrayList<MemberCommonInfo> arrayList3 = data.memberList;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "data.memberList");
        if ((true ^ arrayList3.isEmpty()) && data.identifyFlag == 2) {
            this.adminUinListFrom0x899 = new ArrayList<>();
            ArrayList<MemberCommonInfo> arrayList4 = data.memberList;
            if (arrayList4 != null) {
                Iterator<MemberCommonInfo> it5 = arrayList4.iterator();
                while (it5.hasNext()) {
                    this.adminUinListFrom0x899.add(String.valueOf(it5.next().memberUin));
                }
            }
        }
    }

    private final void f4() {
        boolean z16;
        TroopInfo troopInfo = this.troopInfo;
        short s16 = troopInfo.cGroupOption;
        int i3 = troopInfo.groupExt.inviteRobotMemberSwitch;
        boolean z17 = false;
        if (s16 != 1 && (s16 != 2 || i3 == 1)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (troopInfo.isOwnerOrAdmin() || z16) {
            z17 = true;
        }
        b4(new a.s(z17));
    }

    private final void g4() {
        AppInterface w26 = w2();
        if (w26 != null && !TextUtils.isEmpty(this.troopInfoData.troopUin)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingViewModel", 2, "updateNick async");
            }
            TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
            String str = this.troopInfoData.troopUin;
            String currentAccountUin = w26.getCurrentAccountUin();
            QBaseActivity qBaseActivity = this.activityRef.get();
            if (qBaseActivity == null) {
                return;
            }
            troopMemberListRepo.fetchTroopMemberInfo(str, currentAccountUin, false, qBaseActivity, "TroopSettingViewModel-updateNick", new o());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(TroopSettingViewModel this$0, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (troopMemberInfo != null) {
            this$0.h4(troopMemberInfo.troopColorNick, Integer.valueOf(troopMemberInfo.troopColorNickId), troopMemberInfo.troopnick);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i3() {
        b4(a.c.f301115a);
        b4(a.w.f301136a);
        m4();
        f4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i4(ArrayList<TroopMemberCardInfo> list) {
        String str;
        TroopMemberCardInfo troopMemberCardInfo = null;
        for (int i3 = 0; troopMemberCardInfo == null && i3 < list.size(); i3++) {
            troopMemberCardInfo = list.get(i3);
            if (troopMemberCardInfo != null) {
                if (Utils.p(troopMemberCardInfo.troopuin, this.troopInfoData.troopUin)) {
                    String str2 = troopMemberCardInfo.memberuin;
                    AppInterface w26 = w2();
                    if (w26 != null) {
                        str = w26.getCurrentAccountUin();
                    } else {
                        str = null;
                    }
                    if (Utils.p(str2, str)) {
                    }
                }
                troopMemberCardInfo = null;
            }
        }
        String str3 = this.troopInfoData.troopCard;
        Intrinsics.checkNotNullExpressionValue(str3, "troopInfoData.troopCard");
        QLog.i("TroopSettingViewModel", 1, "updateTroopMemberCard " + this.troopInfoData.troopCard);
        if (troopMemberCardInfo != null && !Utils.p(str3, this.troopInfoData.troopCard)) {
            h4(troopMemberCardInfo.colorNick, Integer.valueOf(troopMemberCardInfo.colorNickId), troopMemberCardInfo.name);
        }
        if (troopMemberCardInfo == null) {
            return false;
        }
        return true;
    }

    private final void j4(GroupMemberExtListResult levelInfo, String troopUin, TroopInfo troopInfo) {
        com.tencent.qqnt.inner.g.e(com.tencent.qqnt.inner.g.f357168a, levelInfo, troopInfo, false, 4, null);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.GET_TROOP_MEMBER_LEVEL_INFO, 2, troopUin + ", sysFlag:" + levelInfo.sysShowFlag + ", userFlag:" + levelInfo.userShowFlag + ",newUserFlag:" + levelInfo.userShowFlagNew);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l3(TroopSettingViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mConfigBean = TroopUrlConfProcessor.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l4(String newName) {
        TroopInfoData troopInfoData = this.troopInfoData;
        troopInfoData.troopName = newName;
        if (!troopInfoData.isNewTroop || troopInfoData.hasSetNewTroopName) {
            troopInfoData.newTroopName = newName;
        }
        m4();
        TroopInfoData troopInfoData2 = this.troopInfoData;
        troopInfoData2.hasSetNewTroopName = true;
        if (troopInfoData2.hasSetNewTroopHead) {
            troopInfoData2.isNewTroop = false;
        }
        if (this.troopInfo.getTroopUin() != null) {
            TroopInfo troopInfo = this.troopInfo;
            TroopInfoData troopInfoData3 = this.troopInfoData;
            troopInfo.troopname = troopInfoData3.troopName;
            troopInfo.hasSetNewTroopName = troopInfoData3.hasSetNewTroopName;
            troopInfo.isNewTroop = troopInfoData3.isNewTroop;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(TroopSettingViewModel this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).restartAIOToTroopGuildIfNeeded(this$0.w2(), activity, this$0.troopInfo.getTroopUin(), "TroopSettingViewModel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n3(TroopSettingViewModel this$0) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingViewModel", 2, "mInitRunnable and init cardInfo");
            }
            this$0.g4();
            AppInterface w26 = this$0.w2();
            TroopInfoData troopInfoData = this$0.troopInfoData;
            ITroopSPUtilApi iTroopSPUtilApi = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
            String str4 = null;
            if (w26 != null) {
                str = w26.getCurrentAccountUin();
            } else {
                str = null;
            }
            troopInfoData.nUnreadMsgNum = iTroopSPUtilApi.groupGroupNewsInfo(str, ITroopSPUtilApi.KEY_ALBUM_MESSAGE, this$0.troopInfoData.troopUin);
            TroopInfoData troopInfoData2 = this$0.troopInfoData;
            ITroopSPUtilApi iTroopSPUtilApi2 = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
            if (w26 != null) {
                str2 = w26.getCurrentAccountUin();
            } else {
                str2 = null;
            }
            troopInfoData2.nNewPhotoNum = iTroopSPUtilApi2.groupGroupNewsInfo(str2, ITroopSPUtilApi.KEY_ALBUM_NEW_PHOTOES, this$0.troopInfoData.troopUin);
            if (QLog.isColorLevel()) {
                TroopInfoData troopInfoData3 = this$0.troopInfoData;
                QLog.i("TroopSettingViewModel", 2, "\u521d\u59cb\u5316\uff0c\u7fa4\u7a7a\u95f4\u672a\u8bfb\u8ba1\u6570\uff0c troopuin = " + troopInfoData3.troopUin + ", unreadmsgnum = " + troopInfoData3.nUnreadMsgNum + ", newphotonum = " + troopInfoData3.nNewPhotoNum);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingViewModel", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
            }
            TroopInfoData troopInfoData4 = this$0.troopInfoData;
            ITroopSPUtilApi iTroopSPUtilApi3 = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
            if (w26 != null) {
                str3 = w26.getCurrentAccountUin();
            } else {
                str3 = null;
            }
            troopInfoData4.nNewFileMsgNum = iTroopSPUtilApi3.groupGroupNewsInfo(str3, ITroopSPUtilApi.KEY_FILE_NEW, this$0.troopInfoData.troopUin);
            TroopInfoData troopInfoData5 = this$0.troopInfoData;
            troopInfoData5.nUnreadFileMsgnum = 0;
            ITroopSPUtilApi iTroopSPUtilApi4 = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
            if (w26 != null) {
                str4 = w26.getCurrentAccountUin();
            }
            troopInfoData5.mNewTroopNotificationNum = iTroopSPUtilApi4.groupGroupNewsInfo(str4, ITroopSPUtilApi.KEY_TROOP_NOTIFICATION_NEW, this$0.troopInfoData.troopUin);
            this$0.C3();
            this$0.y2();
            this$0.Y3();
            this$0.b4(a.ac.f301107a);
            String str5 = this$0.troopInfoData.troopUin;
            Intrinsics.checkNotNullExpressionValue(str5, "troopInfoData.troopUin");
            this$0.v3(str5);
        } catch (Throwable th5) {
            QLog.e("TroopSettingViewModel", 1, "[mInitRunnable] e = " + th5);
        }
    }

    private final void o2() {
        if (TextUtils.isEmpty(this.troopInfo.troopuin)) {
            QLog.i("TroopSettingViewModel", 1, "mTroopInfo is null or mTroopInfo.troopuin is empty or mTroopCardAppInfoHandler is null");
            return;
        }
        final String troopUin = this.troopInfo.troopuin;
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        TroopBatchFetch.c(troopUin, true, this.activityRef.get(), "TroopSettingViewModel", new Function1<com.tencent.qqnt.troopmemberlist.datasync.e, Unit>(troopUin) { // from class: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$batchGetTroopInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$troopUin = troopUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this, (Object) troopUin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.troopmemberlist.datasync.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.troopmemberlist.datasync.e it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                TroopSettingViewModel troopSettingViewModel = TroopSettingViewModel.this;
                String troopUin2 = this.$troopUin;
                Intrinsics.checkNotNullExpressionValue(troopUin2, "troopUin");
                troopSettingViewModel.o3(troopUin2, it);
            }
        });
        QRouteApi api = QRoute.api(ITroopCardAppInfoHelperApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopCardAppInfoHelperApi::class.java)");
        ITroopCardAppInfoHelperApi iTroopCardAppInfoHelperApi = (ITroopCardAppInfoHelperApi) api;
        iTroopCardAppInfoHelperApi.init(w2());
        iTroopCardAppInfoHelperApi.getAppInfoBriefList(troopUin, this.mIGetAppInfoCB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o3(String troopUin, com.tencent.qqnt.troopmemberlist.datasync.e data) {
        if (!Intrinsics.areEqual(troopUin, this.troopInfoData.troopUin)) {
            QLog.e("TroopSettingViewModel", 2, "[onBatchGetTroopInfoResp] filter resp, curTroopUin:" + this.troopInfoData.troopUin + ",respUin:" + troopUin);
            return;
        }
        QLog.i("TroopSettingViewModel", 1, "[onBatchGetTroopInfoResp] isSucc:" + data.n());
        c3(data.k(), data.l());
        f3(data.i());
        f3(data.m());
        d3(troopUin, data.o());
        if (data.k() != null) {
            i3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o4(TroopSettingViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(this$0.troopInfo.troopuin);
        if (troopInfoFromCache == null) {
            return;
        }
        GroupMsgMask groupMsgMask = troopInfoFromCache.troopmask;
        Intrinsics.checkNotNullExpressionValue(groupMsgMask, "troopInfo.troopmask");
        this$0.b4(new a.z(groupMsgMask));
        String str = troopInfoFromCache.troopNameFromNT;
        if (str == null) {
            str = "";
        }
        this$0.mCacheNTTroopName = str;
        this$0.k4();
    }

    private final boolean q2(Context context, Bundle extra) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        boolean z16 = false;
        if (appInterface == null) {
            return false;
        }
        try {
            this.isInitialized = false;
            TroopInfoData initTroopInfoData = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).initTroopInfoData(extra, context);
            Intrinsics.checkNotNullExpressionValue(initTroopInfoData, "api(ITroopUtilsApi::clas\u2026pInfoData(extra, context)");
            this.troopInfoData = initTroopInfoData;
            TroopInfo initTroopInfo = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).initTroopInfo(appInterface, this.troopInfoData, context);
            if (initTroopInfo != null) {
                this.troopInfo = initTroopInfo;
            }
            String str = this.troopInfoData.troopUin;
            Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopUin");
            if (Long.parseLong(str) > 0) {
                z16 = true;
            }
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setExposureSource(extra.getInt("exposureSource", 99));
            this.mIsFromThirdApp = extra.getBoolean("fromThirdAppByOpenSDK");
            this.authKey = extra.getString("authKey");
            this.authSig = extra.getString("authSig");
            IRuntimeService runtimeService = appInterface.getRuntimeService(ITroopInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
            this.mIsQidianPrivateTroop = ((ITroopInfoService) runtimeService).isQidianPrivateTroop(this.troopInfoData.troopUin);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingViewModel", 2, e16.toString());
            }
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).bnrReport(appInterface, 69);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q3(boolean isSuc, TroopInfo newTroopInfo) {
        Resources resources;
        if (this.troopInfoData.troopUin != null && isSuc && Utils.p(newTroopInfo.getTroopUin(), this.troopInfoData.troopUin)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingViewModel", 2, "onGetTroopInfoResult, newTroop = " + newTroopInfo);
            }
            this.troopInfo = newTroopInfo;
            TroopInfoData troopInfoData = this.troopInfoData;
            QBaseActivity qBaseActivity = this.activityRef.get();
            String str = null;
            if (qBaseActivity != null) {
                resources = qBaseActivity.getResources();
            } else {
                resources = null;
            }
            AppInterface w26 = w2();
            if (w26 != null) {
                str = w26.getCurrentAccountUin();
            }
            troopInfoData.updateForTroopChatSetting(newTroopInfo, resources, str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.e
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingViewModel.r3(TroopSettingViewModel.this);
                }
            });
            b4(a.n.f301127a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r3(TroopSettingViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(TroopSettingViewModel this$0, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        this$0.b4(new a.j(z16, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s3(TroopSettingViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.init();
    }

    private final void t2(com.tencent.mobileqq.troop.troopsetting.event.a intent) {
        if (Intrinsics.areEqual(this._troopSettingIntent.getValue(), intent)) {
            this._troopSettingIntent.setValue(a.e.f301117a);
        }
        this._troopSettingIntent.setValue(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopInfo u2(String troopUin) {
        ITroopInfoService iTroopInfoService;
        AppInterface w26 = w2();
        if (w26 != null && (iTroopInfoService = (ITroopInfoService) w26.getRuntimeService(ITroopInfoService.class, "")) != null) {
            return iTroopInfoService.findTroopInfo(troopUin);
        }
        return null;
    }

    private final void v3(String troopuin) {
        IQQAvatarHandlerService iQQAvatarHandlerService;
        AppInterface w26 = w2();
        if (w26 != null && (iQQAvatarHandlerService = (IQQAvatarHandlerService) w26.getRuntimeService(IQQAvatarHandlerService.class, "")) != null) {
            iQQAvatarHandlerService.getTroopHead(troopuin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppInterface w2() {
        AppInterface appInterface;
        AppInterface appInterface2;
        WeakReference<AppInterface> weakReference = this.cachedApp;
        if (weakReference != null) {
            appInterface = weakReference.get();
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface2 = (AppInterface) peekAppRuntime;
            } else {
                appInterface2 = null;
            }
            this.cachedApp = new WeakReference<>(appInterface2);
        }
        WeakReference<AppInterface> weakReference2 = this.cachedApp;
        if (weakReference2 == null) {
            return null;
        }
        return weakReference2.get();
    }

    private final void y2() {
        if (this.troopInfoData.troopUin != null) {
            com.tencent.mobileqq.troop.troopcreate.classify.detail.g.f("TroopSettingViewModel");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void y3(TroopSettingViewModel troopSettingViewModel, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function2 = null;
        }
        troopSettingViewModel.x3(function2);
    }

    public final int A2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return this.mActionFlag;
    }

    @NotNull
    public final String B2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mCacheNTTroopName;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.troopurl.config.a C2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.troop.troopurl.config.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mConfigBean;
    }

    public final void C3() {
        Context context;
        QBaseActivity qBaseActivity;
        final com.tencent.mobileqq.troop.api.handler.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity2 = this.activityRef.get();
        com.tencent.mobileqq.troop.troopapps.api.a aVar = null;
        if (qBaseActivity2 != null) {
            context = qBaseActivity2.getApplicationContext();
        } else {
            context = null;
        }
        int i3 = 1;
        if (!NetworkUtil.isNetworkAvailable(context)) {
            QLog.i("TroopSettingViewModel", 1, "NetWorkIsNotAvailable");
            return;
        }
        AppInterface w26 = w2();
        if (w26 == null || (qBaseActivity = this.activityRef.get()) == null) {
            return;
        }
        Object businessHandler = w26.getBusinessHandler(TroopListHandler.class.getName());
        if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.d) {
            dVar = (com.tencent.mobileqq.troop.api.handler.d) businessHandler;
        } else {
            dVar = null;
        }
        Object businessHandler2 = w26.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAppHandlerName());
        if (businessHandler2 instanceof com.tencent.mobileqq.troop.troopapps.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopapps.api.a) businessHandler2;
        }
        TroopMemberListRepo.INSTANCE.fetchTroopMemberInfo(this.troopInfoData.troopUin, w26.getCurrentAccountUin(), true, qBaseActivity, "TroopSettingViewModel-net", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.p
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopSettingViewModel.D3(TroopSettingViewModel.this, troopMemberInfo);
            }
        });
        if (dVar != null) {
            x3(new Function2<Boolean, TroopInfo, Unit>(dVar) { // from class: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$sendNetWorkRequest$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.mobileqq.troop.api.handler.d $listHandler;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$listHandler = dVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this, (Object) dVar);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                    invoke(bool.booleanValue(), troopInfo);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull TroopInfo newTroopInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), newTroopInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(newTroopInfo, "newTroopInfo");
                    if (TroopSettingViewModel.this.T2().isMember) {
                        this.$listHandler.a(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_MULTI_TROOP_INFO, z16, z16 ? CollectionsKt__CollectionsKt.arrayListOf(newTroopInfo) : null);
                    }
                }
            });
        }
        o2();
        if (aVar != null) {
            String str = this.troopInfoData.troopUin;
            if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                i3 = -1;
            }
            aVar.x1(str, false, 0, 0, i3);
        }
    }

    public final boolean D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.mHasChangedMsgNotify;
    }

    public final boolean E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return this.mInviteJoinTroop;
    }

    public final void E3(@NotNull Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) map);
        } else {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.cachedUinToNameMap = map;
        }
    }

    public final boolean F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mIsFromThirdApp;
    }

    public final void F3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.hindChatIsChecked = z16;
        }
    }

    public final boolean G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mIsQidianPrivateTroop;
    }

    public final void G3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, i3);
        } else {
            this.mActionFlag = i3;
        }
    }

    @Nullable
    public final Intent H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Intent) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.mNewerGuideOpResult;
    }

    public final void H3(@Nullable com.tencent.mobileqq.troop.troopurl.config.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
        } else {
            this.mConfigBean = aVar;
        }
    }

    public final int I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mSubmitTime;
    }

    public final void I3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.mHasChangedMsgNotify = z16;
        }
    }

    @Nullable
    public final String J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.mTroopMemo;
    }

    public final void J3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
        } else {
            this.mInviteJoinTroop = z16;
        }
    }

    public final void K0(@NotNull AppInterface appInterface) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) appInterface);
            return;
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        if (this.mIsInit) {
            this.mIsInit = false;
            String[] strArr = new String[3];
            TroopInfoData troopInfoData = this.troopInfoData;
            strArr[0] = troopInfoData.troopUin;
            strArr[1] = eu.c(troopInfoData);
            if (this.troopInfoData.hasSetNewTroopHead) {
                str = "1";
            } else {
                str = "0";
            }
            strArr[2] = str;
            eu.g("Grp_set_new", "grpData_admin", "exp", 0, 0, strArr);
            return;
        }
        W3(appInterface);
    }

    public final void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
            return;
        }
        if (this.troopInfo.getTroopUin() != null) {
            ArrayList<Long> parseTroopMemberList = this.troopInfo.parseTroopMemberList();
            if (parseTroopMemberList == null) {
                parseTroopMemberList = new ArrayList<>();
            }
            this.memberUins = parseTroopMemberList;
            if (QLog.isColorLevel()) {
                QLog.d("TroopSettingViewModel", 2, "getMemberListFromTroopInfo,memberUins.size = " + this.memberUins.size());
            }
            b4(a.u.f301134a);
        }
    }

    public final void K3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.mNeedRefreshed = z16;
        }
    }

    @Nullable
    public final CopyOnWriteArrayList<String> L2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.memberUinListForCard;
    }

    public final void L3(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) intent);
        } else {
            this.mNewerGuideOpResult = intent;
        }
    }

    @NotNull
    public final List<Long> M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (List) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.memberUins;
    }

    public final void M3(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        } else {
            this.mTroopMemo = str;
        }
    }

    @NotNull
    public final MutableStateFlow<ArrayList<bt2.d>> N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (MutableStateFlow) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return this.robotList;
    }

    public final void N3(@NotNull List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.memberUins = list;
        }
    }

    public final void O3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.shieldConfigIsChecked = z16;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return this.searchWayViewModel;
    }

    public final void P3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
        } else {
            this.isShowModifyTroopNameDialog = z16;
        }
    }

    public final boolean Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.shieldConfigIsChecked;
    }

    public final void Q3(@Nullable List<oidb_0xe83$AppInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) list);
        } else {
            this.troopAppList = list;
        }
    }

    @Nullable
    public final List<oidb_0xe83$AppInfo> R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.troopAppList;
    }

    public final void R3(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "<set-?>");
            this.troopInfo = troopInfo;
        }
    }

    @NotNull
    public final TroopInfo S2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.troopInfo;
    }

    public final void S3() {
        ITroopAppService iTroopAppService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this);
            return;
        }
        AppInterface w26 = w2();
        byte[] bArr = null;
        if (w26 != null) {
            iTroopAppService = (ITroopAppService) w26.getRuntimeService(ITroopAppService.class, "all");
        } else {
            iTroopAppService = null;
        }
        if (iTroopAppService != null) {
            try {
                bArr = iTroopAppService.getTroopAppListData(this.troopInfoData.troopUin);
            } catch (Throwable th5) {
                QLog.e("TroopSettingViewModel.troop.troop_app", 2, "init, cached troopAppListData exception = " + th5);
                return;
            }
        }
        if (bArr != null) {
            oidb_0xe83$RspBody oidb_0xe83_rspbody = new oidb_0xe83$RspBody();
            oidb_0xe83_rspbody.mergeFrom(bArr);
            b4(new a.x(oidb_0xe83_rspbody));
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopSettingViewModel.troop.troop_app", 2, "init, cached troopAppListData==null");
        }
    }

    @NotNull
    public final TroopInfoData T2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfoData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopInfoData;
    }

    public final boolean T3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return ((Boolean) iPatchRedirector.redirect((short) 87, (Object) this)).booleanValue();
        }
        if (a.f301534a.a() && com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model.a.a(this.troopInfo)) {
            return true;
        }
        return false;
    }

    public final void U3(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) activity);
            return;
        }
        String str = this.troopInfo.troopuin;
        if (str == null) {
            QLog.e("TroopSettingViewModel", 1, "startTroopMemberCard child data error.");
            return;
        }
        boolean isHomeworkTroop = this.troopInfoData.isHomeworkTroop();
        TroopInfoData troopInfoData = this.troopInfoData;
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).startTroopMemberCard(activity, w2(), new com.tencent.mobileqq.troop.k(str, isHomeworkTroop, troopInfoData.troopColorNick, troopInfoData.troopColorNickId, eu.c(troopInfoData)), 2);
    }

    @NotNull
    public final StateFlow<com.tencent.mobileqq.troop.troopsetting.event.a> V2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (StateFlow) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.troopSettingIntent;
    }

    public final void X3(@NotNull AppInterface appInterface) {
        com.tencent.mobileqq.troop.troopapps.api.a aVar;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) appInterface);
            return;
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Object businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAppHandlerName());
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopapps.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopapps.api.a) businessHandler;
        } else {
            aVar = null;
        }
        com.tencent.mobileqq.troop.troopapps.api.a aVar2 = aVar;
        if (aVar2 != null) {
            String str = this.troopInfoData.troopUin;
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            aVar2.x1(str, true, 0, 0, i3);
        }
    }

    public final void b4(@NotNull final com.tencent.mobileqq.troop.troopsetting.event.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            t2(intent);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.h
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingViewModel.c4(TroopSettingViewModel.this, intent);
                }
            });
        }
    }

    public final void d4(@Nullable String newTroopName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, (Object) newTroopName);
            return;
        }
        TroopInfoData troopInfoData = this.troopInfoData;
        troopInfoData.troopName = newTroopName;
        troopInfoData.newTroopName = this.troopInfo.getTroopDisplayName();
    }

    public final void e4(@Nullable TroopMemberInfo tmi) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) tmi);
            return;
        }
        Integer num = null;
        if (tmi != null) {
            str = tmi.troopColorNick;
            str2 = tmi.troopnick;
        } else {
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (tmi != null) {
                num = Integer.valueOf(tmi.troopColorNickId);
            }
            h4(str, num, str2);
            return;
        }
        QLog.i("TroopSettingViewModel", 1, "updateNickUseTroopMemberInfo name empty");
    }

    public final void g3(@Nullable Intent data, @NotNull Activity activity, @NotNull AppInterface appInterface) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, this, data, activity, appInterface);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        if (data != null && data.getExtras() != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                z16 = extras.getBoolean(AppConstants.Key.IS_NEED_FINISH);
            } else {
                z16 = false;
            }
            if (z16) {
                Intent intent = new Intent();
                intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                activity.setResult(-1, intent);
                com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.h(activity);
                return;
            }
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(ITroopMemberInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026ssConstant.MAIN\n        )");
        ((ITroopMemberInfoService) runtimeService).getTroopMemberInfoAsync(this.troopInfoData.troopUin, appInterface.getCurrentAccountUin(), "TroopSettingViewModel-handleUpdateSelfInfoReq", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.m
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopSettingViewModel.h3(TroopSettingViewModel.this, troopMemberInfo);
            }
        });
        b4(a.u.f301134a);
    }

    public final void h4(@Nullable String colorNick, @Nullable Integer colorNickId, @Nullable String troopCard) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, colorNick, colorNickId, troopCard);
            return;
        }
        TroopInfoData troopInfoData = this.troopInfoData;
        troopInfoData.troopColorNick = colorNick;
        if (colorNickId != null) {
            i3 = colorNickId.intValue();
        } else {
            i3 = 0;
        }
        troopInfoData.troopColorNickId = i3;
        TroopInfoData troopInfoData2 = this.troopInfoData;
        troopInfoData2.troopCard = troopCard;
        QLog.i("TroopSettingViewModel", 1, "updateTroopMemberCard nick=" + troopInfoData2.troopColorNick + ", nickId=" + troopInfoData2.troopColorNickId + ", name=" + troopCard);
        b4(a.aa.f301105a);
    }

    public final void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this);
        } else {
            if (this.isInitialized) {
                return;
            }
            this.isInitialized = true;
            ThreadManagerV2.post(this.mInitRunnable, 8, null, false);
        }
    }

    public final void j3(int resultCode, @Nullable Intent data) {
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, resultCode, (Object) data);
            return;
        }
        if (resultCode == -1 && data != null && (extras = data.getExtras()) != null) {
            this.troopInfoData.troopLocation = extras.getString("location");
            this.troopInfoData.troopLat = extras.getInt(QCircleSchemeAttr.Polymerize.LAT, 0);
            this.troopInfoData.troopLon = extras.getInt("lon", 0);
        }
    }

    public final boolean k3(@Nullable QBaseActivity activity, @NotNull Context context, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, this, activity, context, bundle)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.activityRef = new WeakReference<>(activity);
        this.bundle = bundle;
        if (!q2(context, bundle)) {
            return false;
        }
        AppInterface w26 = w2();
        if (w26 != null) {
            this.searchWayViewModel = new com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b(w26);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingViewModel.l3(TroopSettingViewModel.this);
            }
        }, 16, null, true);
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).preloadMemberIllegalInfoFromLocal(this.troopInfo.getTroopUin());
        return true;
    }

    public final void k4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this);
            return;
        }
        AppInterface w26 = w2();
        if (w26 != null) {
            com.tencent.mobileqq.troop.troopsetting.modules.base.e.c(w26, this.troopInfoData.troopUin, new Function1<TroopInfo, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$updateTroopName$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable TroopInfo troopInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopSettingViewModel.this.b4(new a.ad(troopInfo));
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopInfo);
                    }
                }
            });
        }
    }

    public final void m2(@NotNull final Activity activity, @NotNull Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, (Object) activity, (Object) arguments);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (com.tencent.mobileqq.troop.troopsetting.activity.f.c(arguments)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.b
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingViewModel.n2(TroopSettingViewModel.this, activity);
                }
            });
        }
    }

    public final boolean m3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.isShowModifyTroopNameDialog;
    }

    public final void m4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
        } else {
            n4();
            k4();
        }
    }

    public final void n4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this);
        } else {
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.l
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingViewModel.o4(TroopSettingViewModel.this);
                }
            });
        }
    }

    public final void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this);
        } else {
            this.mFirstEnter = true;
        }
    }

    public final void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this);
        } else {
            this.mFirstEnter = false;
        }
    }

    public final void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this);
            return;
        }
        if (!this.isInitialized) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.i
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingViewModel.s3(TroopSettingViewModel.this);
                }
            });
        }
        if (!this.mFirstEnter) {
            n4();
        }
    }

    public final void p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this);
            return;
        }
        TroopMemberExtInfoRepo troopMemberExtInfoRepo = TroopMemberExtInfoRepo.INSTANCE;
        String str = this.troopInfoData.troopUin;
        Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopUin");
        QBaseActivity qBaseActivity = this.activityRef.get();
        if (qBaseActivity == null) {
            return;
        }
        troopMemberExtInfoRepo.fetchTroopMemberUin(str, 100, qBaseActivity, new Function2<Boolean, List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$batchGetTroopMemberList$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends String> list) {
                invoke(bool.booleanValue(), (List<String>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull List<String> uinList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), uinList);
                    return;
                }
                Intrinsics.checkNotNullParameter(uinList, "uinList");
                if (z16) {
                    TroopSettingViewModel.this.W2(uinList);
                } else if (QLog.isColorLevel()) {
                    QLog.e("TroopSettingViewModel", 2, "batchGetTroopMemberList failed");
                }
            }
        });
    }

    public final void p3(@Nullable QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) activity);
            return;
        }
        if (activity != null) {
            activity.removeObserver(this.troopAnnouncementObserver);
            activity.removeObserver(this.troopRedDotObserver);
            activity.removeObserver(this.troopAppObserver);
            activity.removeObserver(this.troopObserver);
            activity.removeObserver(this.troopModifyObserver);
            activity.removeObserver(this.troopRobotObserver);
            activity.removeObserver(this.troopPushObserver);
            activity.removeObserver(this.troopAssociationObserver);
            activity.removeObserver(this.troopOnlineMemberObserver);
            activity.removeObserver(this.troopSettingObserver);
        }
        com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.a();
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar = this.searchWayViewModel;
        if (bVar != null) {
            bVar.b();
        }
        ITroopMemberInfoService U2 = U2();
        if (U2 != null) {
            U2.removeTroopMemberUpdateObserver(this.troopMemberUpdateObserver);
        }
        IRobotRelationService O2 = O2();
        if (O2 != null) {
            O2.removeRelationObserver(this.robotRelationObserver);
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.troopInfoChangedObserver);
    }

    public final void r2(boolean holdMsg, @Nullable LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, Boolean.valueOf(holdMsg), lifecycleOwner);
        } else {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).destroyGroup(this.troopInfoData.troopUin, holdMsg, lifecycleOwner, "TroopSettingViewModel", new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.g
                @Override // com.tencent.qqnt.troop.i
                public final void onResult(boolean z16, int i3, String str) {
                    TroopSettingViewModel.s2(TroopSettingViewModel.this, z16, i3, str);
                }
            });
        }
    }

    public final void t3(@Nullable QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) activity);
            return;
        }
        if (activity != null) {
            activity.addObserver(this.troopAnnouncementObserver);
            activity.addObserver(this.troopRedDotObserver);
            activity.addObserver(this.troopAppObserver);
            activity.addObserver(this.troopObserver);
            activity.addObserver(this.troopModifyObserver);
            activity.addObserver(this.troopRobotObserver);
            activity.addObserver(this.troopPushObserver);
            activity.addObserver(this.troopAssociationObserver);
            activity.addObserver(this.troopOnlineMemberObserver);
            activity.addObserver(this.troopSettingObserver);
        }
        ITroopMemberInfoService U2 = U2();
        if (U2 != null) {
            U2.addTroopMemberUpdateObserver(this.troopMemberUpdateObserver);
        }
        IRobotRelationService O2 = O2();
        if (O2 != null) {
            O2.addRelationObserver(this.robotRelationObserver);
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(this.activityRef.get(), this.troopInfoChangedObserver);
    }

    public final void u3() {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSettingViewModel", 2, "refreshTroopBasicInfo");
        }
        TroopInfo u26 = u2(this.troopInfoData.troopUin);
        if (u26 != null) {
            this.troopInfo = u26;
        }
        TroopInfoData troopInfoData = this.troopInfoData;
        TroopInfo troopInfo = this.troopInfo;
        QBaseActivity qBaseActivity = this.activityRef.get();
        String str = null;
        if (qBaseActivity != null) {
            resources = qBaseActivity.getResources();
        } else {
            resources = null;
        }
        AppInterface w26 = w2();
        if (w26 != null) {
            str = w26.getCurrentAccountUin();
        }
        troopInfoData.updateForTroopChatSetting(troopInfo, resources, str);
        TroopInfoData troopInfoData2 = this.troopInfoData;
        if (troopInfoData2.isNewTroop && troopInfoData2.hasSetNewTroopHead && troopInfoData2.hasSetNewTroopName) {
            troopInfoData2.isNewTroop = false;
            if (this.troopInfo.getTroopUin() != null) {
                this.troopInfo.isNewTroop = false;
            }
        }
        m4();
        b4(a.g.f301119a);
        b4(a.ai.f301113a);
    }

    public final void v2(@Nullable AppInterface appInterface) {
        BusinessHandler businessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) appInterface);
            return;
        }
        TroopInfoData troopInfoData = this.troopInfoData;
        if (troopInfoData.isMember) {
            try {
                String str = troopInfoData.troopUin;
                Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopUin");
                long parseLong = Long.parseLong(str);
                ct2.a aVar = null;
                if (appInterface != null) {
                    businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopRobotHandlerName());
                } else {
                    businessHandler = null;
                }
                if (businessHandler instanceof ct2.a) {
                    aVar = (ct2.a) businessHandler;
                }
                if (aVar != null) {
                    aVar.Z(parseLong);
                }
            } catch (NumberFormatException e16) {
                QLog.e("TroopSettingViewModel", 2, "onResume  parseLong err", e16);
            }
        }
    }

    public final void w3(@Nullable String subAction, @Nullable String actionName, @Nullable String r36) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, subAction, actionName, r36);
        } else {
            ReportController.o(w2(), "P_CliOper", "Grp_set", "", subAction, actionName, 0, 0, this.troopInfoData.troopUin, r36, "", "");
        }
    }

    @NotNull
    public final Map<String, String> x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (Map) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        return this.cachedUinToNameMap;
    }

    public final void x3(@Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        BusinessHandler businessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) callback);
            return;
        }
        AppInterface w26 = w2();
        com.tencent.mobileqq.troop.announcement.api.a aVar = null;
        if (w26 != null) {
            businessHandler = w26.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.announcement.api.a) {
            aVar = (com.tencent.mobileqq.troop.announcement.api.a) businessHandler;
        }
        if (aVar == null) {
            return;
        }
        try {
            TroopInfo u26 = u2(this.troopInfoData.troopUin);
            if (u26 != null) {
                this.troopInfo = u26;
            }
            if (this.troopInfo.isNeedInterceptOnBlockTroop()) {
                QLog.i("TroopSettingViewModel", 1, "[requestGroupInfo] troopInfo is TroopBlocked ");
            } else {
                TroopInfoRepo.INSTANCE.fetchTroopBasicInfoWithExt(this.troopInfo.troopuin, "TroopSettingViewModel", this.activityRef.get(), new Function2<Boolean, TroopInfo, Unit>(callback) { // from class: com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel$requestGroupInfo$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function2<Boolean, TroopInfo, Unit> $callback;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                        this.$callback = callback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingViewModel.this, (Object) callback);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                        invoke(bool.booleanValue(), troopInfo);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull TroopInfo newTroopInfo) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), newTroopInfo);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(newTroopInfo, "newTroopInfo");
                        TroopSettingViewModel.this.q3(z16, newTroopInfo);
                        Function2<Boolean, TroopInfo, Unit> function2 = this.$callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.valueOf(z16), newTroopInfo);
                        }
                    }
                });
                aVar.f0(this.troopInfo.troopuin);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingViewModel", 2, e16.toString());
            }
        }
    }

    public final boolean z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.hindChatIsChecked;
    }

    public final void z3(boolean holdMsg, @Nullable LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Boolean.valueOf(holdMsg), lifecycleOwner);
        } else {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).quitGroup(this.troopInfoData.troopUin, holdMsg, lifecycleOwner, "TroopSettingViewModel", new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.troop.troopsetting.vm.f
                @Override // com.tencent.qqnt.troop.i
                public final void onResult(boolean z16, int i3, String str) {
                    TroopSettingViewModel.A3(TroopSettingViewModel.this, z16, i3, str);
                }
            });
        }
    }
}
