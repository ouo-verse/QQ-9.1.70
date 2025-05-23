package com.tencent.qqnt.troop;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.troop.handler.TroopModifyHandler;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingHandler;
import com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler;
import com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopsetting.api.impl.TroopSettingHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.ActiveExtGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.ActiveGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.DestroyGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupCardPrefix;
import com.tencent.qqnt.kernel.nativeinterface.GroupCardPrefixFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoCacheFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoCacheReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupModifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupModifyInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupModifyInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMaskMemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMaskReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.ICreateGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IJoinGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IModifyGroupExtCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRcvJoinVerifyMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetGroupMsgMaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITransferGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.ModifyGroupExtResult;
import com.tencent.qqnt.kernel.nativeinterface.QuitGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.RcvJoinVerifyMsgReq;
import com.tencent.qqnt.kernel.nativeinterface.RcvJoinVerifyMsgRsp;
import com.tencent.qqnt.kernel.nativeinterface.SecurityButton;
import com.tencent.qqnt.kernel.nativeinterface.SecurityInfo;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupMsgMaskReq;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupMsgMaskRsp;
import com.tencent.qqnt.kernel.nativeinterface.TransferGroupRsp;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00bf\u0001\u0010\u00c0\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J0\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J:\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J>\u0010!\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J:\u0010&\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J@\u0010,\u001a\u00020\t2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JX\u00102\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\t0'2\n\b\u0002\u00101\u001a\u0004\u0018\u000100H\u0002J*\u00107\u001a\u00020\t2\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0002J*\u0010;\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u000bH\u0002J*\u0010<\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u000bH\u0002J4\u0010?\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u00062\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\t0=H\u0002J0\u0010B\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010C\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J \u0010E\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0018\u0010F\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010G\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0010\u0010H\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0006H\u0002J\u0012\u0010I\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J0\u0010M\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010J\u001a\u00020\u000b2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\t0'H\u0002J:\u0010T\u001a\u00020\t2\u0006\u0010O\u001a\u00020N2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0P2\b\u0010 \u001a\u0004\u0018\u00010SH\u0016J,\u0010V\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010UH\u0016J \u0010X\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J6\u0010Y\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J8\u0010[\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016JV\u0010^\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\\\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010]\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J6\u0010_\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J6\u0010`\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J@\u0010b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010a\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016JH\u0010d\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J.\u0010f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J4\u0010i\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010g\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u00162\u0006\u0010+\u001a\u00020*H\u0016J,\u0010k\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010j\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J,\u0010m\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*H\u0016J,\u0010n\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*H\u0016J,\u0010p\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010o\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J<\u0010q\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010h\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J<\u0010u\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0016\u0010t\u001a\u0012\u0012\u0004\u0012\u00020\u00040rj\b\u0012\u0004\u0012\u00020\u0004`s2\u0006\u0010+\u001a\u00020*H\u0016J4\u0010x\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010v\u001a\u00020\u000b2\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*H\u0016J.\u0010z\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J:\u0010}\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010{\u001a\u0004\u0018\u00010\u00062\b\u0010|\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J.\u0010\u007f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010~\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J9\u0010\u0082\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u00042\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J0\u0010\u0083\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J0\u0010\u0085\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0084\u0001\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016JK\u0010\u0088\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00062\u0017\u0010\u0087\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00060rj\b\u0012\u0004\u0012\u00020\u0006`s2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J2\u0010\u008a\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J9\u0010\u008d\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u008c\u0001\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010+\u001a\u00020*H\u0016J9\u0010\u0090\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u008f\u0001\u001a\u00030\u008e\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J/\u0010\u0091\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J$\u0010\u0093\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J$\u0010\u0095\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0094\u0001\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J\u001c\u0010\u0097\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0096\u0001\u001a\u00020\u0016H\u0016J#\u0010\u0098\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J#\u0010\u0099\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J#\u0010\u009a\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J#\u0010\u009b\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J\u001c\u0010\u009d\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u009c\u0001\u001a\u00020\u0016H\u0016J\u001b\u0010\u009e\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u000bH\u0016J$\u0010\u00a0\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u000b2\u0007\u0010\u009f\u0001\u001a\u00020\u0004H\u0016J\u001b\u0010\u00a1\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u000bH\u0016J\u001b\u0010\u00a2\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u000bH\u0016J\u001b\u0010\u00a3\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u000bH\u0016J\u001b\u0010\u00a4\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u000bH\u0016J\u001c\u0010\u00a6\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u00a5\u0001\u001a\u00020\u000bH\u0016J\u001b\u0010\u00a7\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u000bH\u0016J\u001c\u0010\u00a9\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u00a8\u0001\u001a\u00020\u0016H\u0016J\u001c\u0010\u00ab\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u00aa\u0001\u001a\u00020\u000bH\u0016J\u0013\u0010\u00ac\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u00ae\u0001\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00062\u0007\u0010\u00ad\u0001\u001a\u00020\u0016H\u0016J\u001c\u0010\u00b0\u0001\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u00af\u0001\u001a\u00020\u0004H\u0016R\u0017\u0010\u00b1\u0001\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0017\u0010\u00b3\u0001\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R(\u0010\u00bb\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b6\u00010\u00b5\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001R$\u0010\u00bd\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u00bc\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001\u00a8\u0006\u00c1\u0001"}, d2 = {"Lcom/tencent/qqnt/troop/TroopOperationRepo;", "Lcom/tencent/qqnt/troop/ITroopOperationRepoApi;", "Lcom/tencent/qqnt/bean/JoinTroopParam;", "joinTroopParam", "", "callbackId", "", "from", "uniqueFrom", "", "joinGroupInner", "", "isSuc", "code", "troopUin", "notifyJoinGroupResult", "groupCode", "groupName", "result", NotificationCompat.CATEGORY_ERROR, "notifyModifyGroupName", "notifyModifyGroupRemark", "", "oldOwnerUid", "newOwnerUid", "errMsg", "notifyTransferGroup", "holdMsg", "isDestroy", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/qqnt/troop/i;", "asyncCallback", "quitOrDestroyTroop", "success", "memberUid", "op", "type", "notifyModifyGroupGroupMsgMask", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfo;", "modifyInfo", "Lcom/tencent/qqnt/troop/e;", "callback", "modifyGroupDetailInfoV2Privilege", "modifyType", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfoReq;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/troop/h;", "innerCallback", "modifyGroupDetailInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "changedInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFilter;", "filter", "modifyGroupExtInfo", "log", "mask", "open", "updateFlagExt3", "updateFlagExt4", "Lkotlin/Function2;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupInfoCacheReq;", "updateGroupInfo", "isDestroyTroop", "isSuccess", "notifyTroopQuitOrDestroy", "cancelHideChat", IProfileProtocolConst.PARAM_TROOP_CODE, "handleTroopMsg", "handleDestroyGroupResult", "handleResignGroupResult", "deleteRecentContactsVer2", "onIllegalParams", "createNewWhenNull", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", QCircleDaTongConstant.ElementParamValue.OPERATION, "updateTroopInfo", "Lcom/tencent/qqnt/bean/a;", "createParam", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "weakAct", "Lcom/tencent/qqnt/troop/b;", "createGroupV2", "Lcom/tencent/qqnt/troop/d;", "joinGroup", "continueRequest", "joinGroupForSecurityBack", "modifyGroupName", "groupRemark", "modifyGroupRemark", "oldOwnerUin", "newOwnerUin", "transferGroup", "destroyGroup", "quitGroup", "cmd", "setGroupMsgMaskV2_0", "time", "setGroupMsgMaskV2_4", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "setGroupMsgMask", "privilegeFlag", "privilegeMask", "modifyTroopPrivilegeFlag", "opt", "modifyTroopSearchType", "allowUpload", "modifyUploadTroopFile", "modifyUploadTroopAlbum", "joinTypeOpt", "modifyTroopJoinTypeFlag", "modifyTroopPayToJoinFlag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedGameIds", "modifyTroopSelectedGameId", "isAllowMemberInvite", "onlyInviteJoinTroop", "modifyOnlyTroopMemberInviteJoinTroop", "isAllow", "modifyAllowMemberInvite", "question", "answer", "modifyAnswerAndQuestion", "timestamp", "modifyTroopShutUpTime", "gameType", "on", "modifyGameCardSwitch", "modifyEnableHistoryForNewMember", "msgLimitFreq", "modifyTroopMsgLimitFreq", "intro", "prefixWords", "modifyTroopNickRule", "troopLocation", "modifyTroopLocation", "adminUin", "can", "setAdminCanRcvJoinMsg", "Lcom/tencent/mobileqq/data/troop/b;", "troopCard", "modifyTroopData", "setTroopIsActive", "essenceSwitch", "updateTroopEssenceSwitch", "essentialMsgPrivilege", "updateTroopEssencePrivilege", "guildId", "updateTroopGuildId", "updateInviteRobotSwitch", "updateAllowMemberInviteRobotSwitch", "updateAllowMemberModifyTroopName", "updateRobotMemberExamine", "aioGuildId", "updateTroopAIOGuildId", "updateHonorAIOSwitch", "flag", "updateTogetherBusinessFlag", "updateShareLocationState", "updateWatchTogetherState", "updateListenTogetherState", "updateTroopAutoApproval", "isLive", "updateTroopLive", "updateLuckyCharFlag", "account", "updateAssociatePubAccount", TransFileControllerImpl.VALUE_USE_PRE_CONN, "updateUseClassAvatar", "updateNewTroopState", "cmduinFlagEx3Grocery", "updateGameCardSwitch", "value", "updateFullGroupExpansionSwitch", "TAG", "Ljava/lang/String;", "CREATE_TROOP_BLACKLIST_RETCODE", "I", "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "", "troopOperationCallbackStore$delegate", "Lkotlin/Lazy;", "getTroopOperationCallbackStore", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "troopOperationCallbackStore", "Ljava/util/concurrent/ConcurrentHashMap;", "send0xA80ReqTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopOperationRepo implements ITroopOperationRepoApi {
    static IPatchRedirector $redirector_ = null;
    private static final int CREATE_TROOP_BLACKLIST_RETCODE = 255;

    @NotNull
    public static final TroopOperationRepo INSTANCE;

    @NotNull
    private static final String TAG = "TroopOperationRepo";

    @NotNull
    private static final ConcurrentHashMap<String, Long> send0xA80ReqTimeMap;

    /* renamed from: troopOperationCallbackStore$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy troopOperationCallbackStore;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    static final class a implements h, FunctionAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ Function2 f362399d;

        a(Function2 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function);
            } else {
                this.f362399d = function;
            }
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof h) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f362399d;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.tencent.qqnt.troop.h
        public final /* synthetic */ void onResult(int i3, String str) {
            this.f362399d.invoke(Integer.valueOf(i3), str);
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63156);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 53)) {
            redirector.redirect((short) 53);
            return;
        }
        INSTANCE = new TroopOperationRepo();
        lazy = LazyKt__LazyJVMKt.lazy(TroopOperationRepo$troopOperationCallbackStore$2.INSTANCE);
        troopOperationCallbackStore = lazy;
        send0xA80ReqTimeMap = new ConcurrentHashMap<>();
    }

    TroopOperationRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void cancelHideChat(String groupCode) {
        ITroopInfoService iTroopInfoService = (ITroopInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopInfoService.class);
        if (iTroopInfoService != null) {
            iTroopInfoService.tryToCancelTroopHideChat(groupCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createGroupV2$lambda$5(final com.tencent.qqnt.report.m report, final int i3, final String uniqueFrom, final WeakReference weakAct, final int i16, final String str, final CreateGroupResult createGroupResult) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(weakAct, "$weakAct");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.cy
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.createGroupV2$lambda$5$lambda$4(i16, createGroupResult, i3, str, report, uniqueFrom, weakAct);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, com.tencent.qqnt.kernel.nativeinterface.SecurityInfo] */
    public static final void createGroupV2$lambda$5$lambda$4(final int i3, CreateGroupResult createGroupResult, int i16, final String errMsg, com.tencent.qqnt.report.m report, String uniqueFrom, final WeakReference weakAct) {
        b bVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(weakAct, "$weakAct");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (i3 == 255) {
            ArrayList<SecurityInfo> securityInfo = createGroupResult.getSecurityInfo();
            Intrinsics.checkNotNullExpressionValue(securityInfo, "result.getSecurityInfo()");
            Iterator<T> it = securityInfo.iterator();
            while (it.hasNext()) {
                ?? r36 = (SecurityInfo) it.next();
                String str = r36.wording;
                boolean z17 = false;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    ArrayList<SecurityButton> arrayList = r36.buttons;
                    if (arrayList == null || arrayList.isEmpty()) {
                        z17 = true;
                    }
                    if (z17) {
                    }
                }
                objectRef.element = r36;
            }
        }
        QLog.i(TAG, 1, "[createGroupV2] errCode:" + i3 + ",errMsg:" + errMsg + ", from:" + uniqueFrom + ", result:" + createGroupResult);
        Object f16 = INSTANCE.getTroopOperationCallbackStore().f(i16);
        String str2 = null;
        if (f16 instanceof b) {
            bVar = (b) f16;
        } else {
            bVar = null;
        }
        if (createGroupResult.getGroupCode() != 0) {
            str2 = String.valueOf(createGroupResult.getGroupCode());
        }
        if (bVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            bVar.a(d16, i3, errMsg, str2);
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, errMsg, 2, null);
        if (!com.tencent.qqnt.e.d(i3)) {
            com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.bo
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.createGroupV2$lambda$5$lambda$4$lambda$3(i3, errMsg, objectRef, weakAct);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void createGroupV2$lambda$5$lambda$4$lambda$3(int i3, String str, Ref.ObjectRef securityInfo, WeakReference weakAct) {
        Intrinsics.checkNotNullParameter(securityInfo, "$securityInfo");
        Intrinsics.checkNotNullParameter(weakAct, "$weakAct");
        ((ICreateTroopBlackListUtilApi) QRoute.api(ICreateTroopBlackListUtilApi.class)).onCreateTroopFailure(i3, str, (SecurityInfo) securityInfo.element, weakAct);
    }

    private final void deleteRecentContactsVer2(String troopCode) {
        com.tencent.qqnt.kernel.api.aa aaVar;
        IKernelService iKernelService = (IKernelService) com.tencent.mobileqq.troop.utils.bg.m(IKernelService.class, "all");
        if (iKernelService != null) {
            aaVar = iKernelService.getRecentContactService();
        } else {
            aaVar = null;
        }
        if (aaVar == null) {
            QLog.e(TAG, 1, "[deleteRecentContactsVer2] is error! recentContactService is null!");
            return;
        }
        ArrayList<Contact> arrayList = new ArrayList<>();
        Contact contact = new Contact();
        contact.peerUid = troopCode;
        contact.chatType = 2;
        arrayList.add(contact);
        aaVar.a0(arrayList, new IOperateCallback() { // from class: com.tencent.qqnt.troop.cb
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                TroopOperationRepo.deleteRecentContactsVer2$lambda$146(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteRecentContactsVer2$lambda$146(int i3, String str) {
        QLog.i(TAG, 1, "[deleteRecentContactsVer2] result:" + i3 + ", errMsg:" + str);
    }

    private final TroopLifecycleCallback<Object> getTroopOperationCallbackStore() {
        return (TroopLifecycleCallback) troopOperationCallbackStore.getValue();
    }

    private final void handleDestroyGroupResult(final String troopCode, final boolean holdMsg) {
        final AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null) {
            com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.cd
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.handleDestroyGroupResult$lambda$140$lambda$139(holdMsg, e16, troopCode);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDestroyGroupResult$lambda$140$lambda$139(boolean z16, AppInterface it, String troopCode) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(troopCode, "$troopCode");
        if (z16) {
            com.tencent.mobileqq.troop.api.config.ag.d(it, troopCode);
        } else {
            com.tencent.mobileqq.troop.api.config.ag.c(it, troopCode);
        }
    }

    private final void handleResignGroupResult(final String troopCode, final boolean holdMsg) {
        final AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null) {
            com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.cl
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.handleResignGroupResult$lambda$142$lambda$141(holdMsg, e16, troopCode);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleResignGroupResult$lambda$142$lambda$141(boolean z16, AppInterface it, String troopCode) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(troopCode, "$troopCode");
        if (z16) {
            com.tencent.mobileqq.troop.api.config.ag.f(it, troopCode);
        } else {
            com.tencent.mobileqq.troop.api.config.ag.e(it, troopCode);
        }
    }

    private final void handleTroopMsg(String troopCode, boolean holdMsg, boolean isDestroyTroop) {
        QLog.i(TAG, 1, "[handleTroopMsg] troopCode:" + troopCode + ", holdMsg:" + holdMsg);
        if (isDestroyTroop) {
            handleDestroyGroupResult(troopCode, holdMsg);
        } else {
            handleResignGroupResult(troopCode, holdMsg);
        }
        if (holdMsg) {
            return;
        }
        TroopListRepo.INSTANCE.deleteTroopInCache(troopCode);
        deleteRecentContactsVer2(troopCode);
    }

    private final void joinGroupInner(final JoinTroopParam joinTroopParam, final int callbackId, String from, final String uniqueFrom) {
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("joinGroup", joinTroopParam.e(), "TroopOperationRepo-" + from, false, true, 8, null);
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.joinGroup(joinTroopParam.a(), new IJoinGroupCallback() { // from class: com.tencent.qqnt.troop.bp
                @Override // com.tencent.qqnt.kernel.nativeinterface.IJoinGroupCallback
                public final void onResult(int i3, String str, JoinGroupNotifyMsg joinGroupNotifyMsg) {
                    TroopOperationRepo.joinGroupInner$lambda$14(com.tencent.qqnt.report.m.this, joinTroopParam, callbackId, uniqueFrom, i3, str, joinGroupNotifyMsg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void joinGroupInner$lambda$14(final com.tencent.qqnt.report.m report, final JoinTroopParam joinTroopParam, final int i3, final String uniqueFrom, final int i16, final String str, final JoinGroupNotifyMsg joinGroupNotifyMsg) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(joinTroopParam, "$joinTroopParam");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.ck
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.joinGroupInner$lambda$14$lambda$13(i16, joinGroupNotifyMsg, joinTroopParam, i3, report, str, uniqueFrom);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v15, types: [T, com.tencent.qqnt.bean.e] */
    /* JADX WARN: Type inference failed for: r5v19, types: [T, com.tencent.qqnt.bean.d] */
    public static final void joinGroupInner$lambda$14$lambda$13(int i3, JoinGroupNotifyMsg joinGroupNotifyMsg, JoinTroopParam joinTroopParam, int i16, com.tencent.qqnt.report.m report, final String str, String uniqueFrom) {
        final d dVar;
        Intrinsics.checkNotNullParameter(joinTroopParam, "$joinTroopParam");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean z16 = true;
        QLog.i(TAG, 1, "[joinGroupInner] errCode:" + i3 + ", errMsg:" + str + ", from:" + uniqueFrom + ", result:" + joinGroupNotifyMsg);
        if (i3 == 0) {
            int i17 = joinGroupNotifyMsg.result;
            if (i17 != 0 && i17 != 1) {
                switch (i17) {
                    case 13:
                        int ordinal = joinGroupNotifyMsg.verifyInfo.type.ordinal();
                        String verifyUrl = joinGroupNotifyMsg.verifyInfo.url;
                        joinTroopParam.f(i16);
                        Intrinsics.checkNotNullExpressionValue(verifyUrl, "verifyUrl");
                        if (verifyUrl.length() <= 0) {
                            z16 = false;
                        }
                        if (z16) {
                            com.tencent.mobileqq.troop.api.config.ag.g(verifyUrl, ordinal, joinTroopParam);
                            report.b(Integer.valueOf(i3), Integer.valueOf(joinGroupNotifyMsg.result), str);
                            return;
                        }
                        break;
                    case 14:
                        String str2 = joinGroupNotifyMsg.joinPrompt;
                        Intrinsics.checkNotNullExpressionValue(str2, "result.joinPrompt");
                        ?? eVar = new com.tencent.qqnt.bean.e(str2);
                        objectRef.element = eVar;
                        if (eVar.c()) {
                            intRef.element = 14;
                            break;
                        }
                        break;
                    case 15:
                        ?? dVar2 = new com.tencent.qqnt.bean.d(joinGroupNotifyMsg.securityTransInfo);
                        objectRef2.element = dVar2;
                        if (dVar2.b()) {
                            intRef.element = 15;
                            QLog.i(TAG, 1, "[joinGroupInner] from:" + uniqueFrom + ", kaiyang:" + objectRef2.element);
                            break;
                        }
                        break;
                    default:
                        intRef.element = i17;
                        break;
                }
            } else {
                booleanRef.element = true;
                intRef.element = i17;
                if (i17 == 0) {
                    TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(joinTroopParam.e());
                    if (troopInfoFromCache == null) {
                        troopInfoFromCache = new TroopInfo(joinTroopParam.e());
                    }
                    troopInfoFromCache.markHadJoinTroop();
                    TroopListRepo.INSTANCE.saveTroopInCache(troopInfoFromCache);
                }
                if (joinGroupNotifyMsg.result == 1) {
                    intRef.element = -2;
                }
            }
        }
        TroopOperationRepo troopOperationRepo = INSTANCE;
        Object f16 = troopOperationRepo.getTroopOperationCallbackStore().f(i16);
        Integer num = null;
        if (f16 instanceof d) {
            dVar = (d) f16;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.bt
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.joinGroupInner$lambda$14$lambda$13$lambda$12$lambda$11(d.this, booleanRef, intRef, str, objectRef, objectRef2);
                }
            });
        }
        troopOperationRepo.notifyJoinGroupResult(booleanRef.element, intRef.element, joinTroopParam.e());
        Integer valueOf = Integer.valueOf(i3);
        if (joinGroupNotifyMsg != null) {
            num = Integer.valueOf(joinGroupNotifyMsg.result);
        }
        report.b(valueOf, num, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void joinGroupInner$lambda$14$lambda$13$lambda$12$lambda$11(d it, Ref.BooleanRef isSuc, Ref.IntRef code, String errMsg, Ref.ObjectRef secPrompt, Ref.ObjectRef kaiYang) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(isSuc, "$isSuc");
        Intrinsics.checkNotNullParameter(code, "$code");
        Intrinsics.checkNotNullParameter(secPrompt, "$secPrompt");
        Intrinsics.checkNotNullParameter(kaiYang, "$kaiYang");
        boolean z16 = isSuc.element;
        int i3 = code.element;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        it.a(z16, i3, errMsg, new com.tencent.qqnt.bean.c((com.tencent.qqnt.bean.e) secPrompt.element, (com.tencent.qqnt.bean.d) kaiYang.element));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void modifyGameCardSwitch$lambda$73(TroopInfo troopInfo, int i3, int i16, String str, int i17, String errMsg) {
        BusinessHandler businessHandler;
        long j3;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (com.tencent.qqnt.e.d(i17)) {
            troopInfo.setGroupFlagPro1(i3, i16);
        }
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        com.tencent.mobileqq.troop.troopgame.api.a aVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopGameHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopgame.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopgame.api.a) businessHandler;
        }
        com.tencent.mobileqq.troop.troopgame.api.a aVar2 = aVar;
        if (aVar2 != null) {
            if (str != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            aVar2.N0(j3, com.tencent.qqnt.e.d(i17), i17, errMsg);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0035, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void modifyGroupDetailInfo(String troopUin, LifecycleOwner owner, final String from, int modifyType, e callback, Function1<? super GroupModifyInfoReq, Unit> config, final h innerCallback) {
        Unit unit;
        Long longOrNull;
        QLog.i(TAG, 1, "[modifyGroupDetailInfo] from:" + from + ", troopUin:" + troopUin);
        GroupModifyInfoReq groupModifyInfoReq = new GroupModifyInfoReq();
        config.invoke(groupModifyInfoReq);
        if (troopUin != null && longOrNull != null) {
            groupModifyInfoReq.groupCode = longOrNull.longValue();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (callback != null) {
                callback.onResult(false, -1, "");
            }
            QLog.e(TAG, 1, "troopUin illegal");
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[modifyGroupDetailInfo] req:" + groupModifyInfoReq);
        }
        final int h16 = getTroopOperationCallbackStore().h(owner, callback);
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("modifyGroupDetailInfoV2_" + modifyType, troopUin, "TroopOperationRepo-" + from, false, true, 8, null);
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.modifyGroupDetailInfoV2(groupModifyInfoReq, modifyType, new IOperateCallback() { // from class: com.tencent.qqnt.troop.cq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    TroopOperationRepo.modifyGroupDetailInfo$lambda$88(com.tencent.qqnt.report.m.this, from, innerCallback, h16, i3, str);
                }
            });
        }
    }

    static /* synthetic */ void modifyGroupDetailInfo$default(TroopOperationRepo troopOperationRepo, String str, LifecycleOwner lifecycleOwner, String str2, int i3, e eVar, Function1 function1, h hVar, int i16, Object obj) {
        int i17;
        h hVar2;
        if ((i16 & 8) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        if ((i16 & 64) != 0) {
            hVar2 = null;
        } else {
            hVar2 = hVar;
        }
        troopOperationRepo.modifyGroupDetailInfo(str, lifecycleOwner, str2, i17, eVar, function1, hVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupDetailInfo$lambda$88(final com.tencent.qqnt.report.m report, final String from, final h hVar, final int i3, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        report.f();
        QLog.i(TAG, 1, "[modifyGroupDetailInfo] from:" + from + ", result:" + i16 + "," + str);
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.cv
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.modifyGroupDetailInfo$lambda$88$lambda$87(h.this, i16, str, i3, report, from);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupDetailInfo$lambda$88$lambda$87(h hVar, final int i3, final String errMsg, int i16, com.tencent.qqnt.report.m report, String from) {
        final e eVar;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        if (hVar != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            hVar.onResult(i3, errMsg);
        }
        Object f16 = INSTANCE.getTroopOperationCallbackStore().f(i16);
        Unit unit = null;
        if (f16 instanceof e) {
            eVar = (e) f16;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.bs
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.modifyGroupDetailInfo$lambda$88$lambda$87$lambda$85$lambda$84(e.this, i3, errMsg);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(TAG, 1, "[modifyGroupDetailInfo] from:" + from + ", get callback fail");
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, errMsg, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupDetailInfo$lambda$88$lambda$87$lambda$85$lambda$84(e it, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(it, "$it");
        boolean d16 = com.tencent.qqnt.e.d(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        it.onResult(d16, i3, errMsg);
    }

    private final void modifyGroupDetailInfoV2Privilege(final Function1<? super GroupModifyInfo, Unit> modifyInfo, LifecycleOwner owner, String groupCode, e callback, String from) {
        modifyGroupDetailInfo$default(this, groupCode, owner, from, 8, callback, new Function1<GroupModifyInfoReq, Unit>(modifyInfo) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyGroupDetailInfoV2Privilege$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<GroupModifyInfo, Unit> $modifyInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$modifyInfo = modifyInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) modifyInfo);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                Function1<GroupModifyInfo, Unit> function1 = this.$modifyInfo;
                GroupModifyInfo groupModifyInfo = req.modifyInfo;
                Intrinsics.checkNotNullExpressionValue(groupModifyInfo, "req.modifyInfo");
                function1.invoke(groupModifyInfo);
                GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                groupModifyInfoFilter.appPrivilegeFlag = 1;
                groupModifyInfoFilter.appPrivilegeMask = 1;
            }
        }, null, 64, null);
    }

    private final void modifyGroupExtInfo(GroupExtInfo changedInfo, GroupExtFilter filter, String from, final e callback) {
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("modifyGroupExtInfoV2", String.valueOf(changedInfo.groupCode), "TroopOperationRepo-" + from, false, true, 8, null);
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.modifyGroupExtInfoV2(changedInfo, filter, new IModifyGroupExtCallback() { // from class: com.tencent.qqnt.troop.ct
                @Override // com.tencent.qqnt.kernel.nativeinterface.IModifyGroupExtCallback
                public final void onResult(int i3, String str, ModifyGroupExtResult modifyGroupExtResult) {
                    TroopOperationRepo.modifyGroupExtInfo$lambda$125(com.tencent.qqnt.report.m.this, callback, i3, str, modifyGroupExtResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupExtInfo$lambda$125(com.tencent.qqnt.report.m report, final e eVar, final int i3, final String str, ModifyGroupExtResult modifyGroupExtResult) {
        Integer num;
        Intrinsics.checkNotNullParameter(report, "$report");
        com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.cn
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.modifyGroupExtInfo$lambda$125$lambda$124(e.this, i3, str);
            }
        });
        report.f();
        Integer valueOf = Integer.valueOf(i3);
        if (modifyGroupExtResult != null) {
            num = Integer.valueOf(modifyGroupExtResult.result);
        } else {
            num = null;
        }
        report.b(valueOf, num, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupExtInfo$lambda$125$lambda$124(e eVar, int i3, String errMsg) {
        boolean z16;
        if (eVar != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            eVar.onResult(z16, i3, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupName$lambda$19(final com.tencent.qqnt.report.m report, final String str, final String groupName, final String uniqueFrom, final int i3, final int i16, final String str2) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(groupName, "$groupName");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.ch
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.modifyGroupName$lambda$19$lambda$18(str2, i16, str, groupName, uniqueFrom, i3, report);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupName$lambda$19$lambda$18(String str, int i3, String str2, String groupName, String uniqueFrom, int i16, com.tencent.qqnt.report.m report) {
        String errMsg;
        i iVar;
        TroopInfo troopInfoFromCache;
        Intrinsics.checkNotNullParameter(groupName, "$groupName");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        QLog.i(TAG, 1, "[modifyGroupName] result:" + i3 + ", err:" + str + ", from:" + uniqueFrom);
        if (i3 == 1328) {
            errMsg = HardCodeUtil.qqStr(R.string.f159891tj);
        } else {
            errMsg = str;
        }
        if (i3 == 1299) {
            errMsg = HardCodeUtil.qqStr(R.string.f160441v1);
        }
        if (com.tencent.qqnt.e.d(i3) && (troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(str2)) != null) {
            troopInfoFromCache.troopNameFromNT = groupName;
        }
        TroopOperationRepo troopOperationRepo = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        troopOperationRepo.notifyModifyGroupName(str2, groupName, i3, errMsg, uniqueFrom);
        Object f16 = troopOperationRepo.getTroopOperationCallbackStore().f(i16);
        if (f16 instanceof i) {
            iVar = (i) f16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            iVar.onResult(d16, i3, errMsg);
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, str, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupRemark$lambda$25(final com.tencent.qqnt.report.m report, final String str, final String uniqueFrom, final int i3, final String str2, final int i16, final String str3) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.bu
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.modifyGroupRemark$lambda$25$lambda$24(i16, str, uniqueFrom, i3, str3, report, str2);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyGroupRemark$lambda$25$lambda$24(int i3, String str, String uniqueFrom, int i16, String err, com.tencent.qqnt.report.m report, final String str2) {
        i iVar;
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        QLog.i(TAG, 1, "[modifyGroupRemark] result:" + i3 + ", err:" + err + ", from:" + uniqueFrom);
        if (com.tencent.qqnt.e.d(i3)) {
            INSTANCE.updateTroopInfo(str, false, new Function1<TroopInfo, Unit>(str2) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyGroupRemark$3$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $groupRemark;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupRemark = str2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str2);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopInfo it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.troopRemark = this.$groupRemark;
                    }
                }
            });
        }
        TroopOperationRepo troopOperationRepo = INSTANCE;
        troopOperationRepo.notifyModifyGroupRemark(str, i3, uniqueFrom);
        Object f16 = troopOperationRepo.getTroopOperationCallbackStore().f(i16);
        if (f16 instanceof i) {
            iVar = (i) f16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i3);
            Intrinsics.checkNotNullExpressionValue(err, "err");
            iVar.onResult(d16, i3, err);
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, err, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyTroopLocation$lambda$101(final com.tencent.qqnt.report.m report, String from, final String str, final int i3, final String str2, final GroupGeoInfoReq req, final int i16, final String str3) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(req, "$req");
        report.f();
        QLog.i(TAG, 1, "[modifyTroopLocation]from:" + from + ", res:" + i16 + ", msg:" + str3);
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.cs
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.modifyTroopLocation$lambda$101$lambda$100(i16, str, i3, report, str3, str2, req);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyTroopLocation$lambda$101$lambda$100(final int i3, String str, int i16, com.tencent.qqnt.report.m report, final String str2, final String str3, final GroupGeoInfoReq req) {
        final e eVar;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(req, "$req");
        if (com.tencent.qqnt.e.d(i3)) {
            updateTroopInfo$default(INSTANCE, str, false, new Function1<TroopInfo, Unit>(str3, req) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopLocation$5$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupGeoInfoReq $req;
                final /* synthetic */ String $troopLocation;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$troopLocation = str3;
                    this.$req = req;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str3, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopInfo it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.strLocation = this.$troopLocation;
                    it.troopLat = (int) this.$req.groupGeoInfo.getLatitude();
                    it.troopLon = (int) this.$req.groupGeoInfo.getLongitude();
                }
            }, 2, null);
        }
        Object f16 = INSTANCE.getTroopOperationCallbackStore().f(i16);
        if (f16 instanceof e) {
            eVar = (e) f16;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.co
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.modifyTroopLocation$lambda$101$lambda$100$lambda$99$lambda$98(e.this, i3, str2);
                }
            });
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, str2, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyTroopLocation$lambda$101$lambda$100$lambda$99$lambda$98(e it, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(it, "$it");
        boolean d16 = com.tencent.qqnt.e.d(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        it.onResult(d16, i3, errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyTroopMsgLimitFreq$lambda$76(String str, final int i3, int i16, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (!com.tencent.qqnt.e.d(i16)) {
            return;
        }
        updateTroopInfo$default(INSTANCE, str, false, new Function1<TroopInfo, Unit>(i3) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopMsgLimitFreq$3$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $msgLimitFreq;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$msgLimitFreq = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                invoke2(troopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopInfo it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.nMsgLimitFreq = this.$msgLimitFreq;
                }
            }
        }, 2, null);
    }

    private final void notifyJoinGroupResult(boolean isSuc, int code, String troopUin) {
        BusinessHandler businessHandler;
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        com.tencent.mobileqq.troop.api.handler.h hVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopMngHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.h) {
            hVar = (com.tencent.mobileqq.troop.api.handler.h) businessHandler;
        }
        if (hVar != null) {
            hVar.S0(isSuc, code, troopUin);
        }
    }

    private final void notifyModifyGroupGroupMsgMask(boolean success, String troopUin, String memberUid, int op5, int type, String from) {
        BusinessHandler businessHandler;
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopSettingHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopsetting.api.a) {
            ((com.tencent.mobileqq.troop.troopsetting.api.a) businessHandler).n(success, troopUin, memberUid, op5, type);
            return;
        }
        QLog.i(TAG, 1, "[notifyModifyGroupGroupMsgMask] handler illegal, from:" + from);
    }

    private final void notifyModifyGroupName(String groupCode, String groupName, int result, String err, String uniqueFrom) {
        BusinessHandler businessHandler;
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        com.tencent.mobileqq.troop.api.handler.i iVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopModifyHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.i) {
            iVar = (com.tencent.mobileqq.troop.api.handler.i) businessHandler;
        }
        com.tencent.mobileqq.troop.api.handler.i iVar2 = iVar;
        boolean z16 = true;
        if (iVar2 == null) {
            QLog.e(TAG, 1, "[notifyModifyGroupName] th is null");
        }
        if (iVar2 != null) {
            if (result != 0) {
                z16 = false;
            }
            iVar2.f(groupCode, groupName, z16, result, err, uniqueFrom);
        }
    }

    private final void notifyModifyGroupRemark(String groupCode, int result, String from) {
        BusinessHandler businessHandler;
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        com.tencent.mobileqq.troop.troopsetting.api.a aVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopSettingHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopsetting.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopsetting.api.a) businessHandler;
        }
        if (aVar == null) {
            QLog.e(TAG, 1, "[notifyModifyGroupRemark] th is null");
        }
        if (aVar != null) {
            aVar.m2(groupCode, result, from);
        }
    }

    private final void notifyTransferGroup(long groupCode, String oldOwnerUid, String newOwnerUid, int result, String errMsg, String from) {
        BusinessHandler businessHandler;
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        com.tencent.mobileqq.troop.api.handler.h hVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopMngHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.h) {
            hVar = (com.tencent.mobileqq.troop.api.handler.h) businessHandler;
        }
        com.tencent.mobileqq.troop.api.handler.h hVar2 = hVar;
        if (hVar2 == null) {
            QLog.e(TAG, 1, "[notifyTransferGroup] th is empty,groupCode:" + groupCode + " ");
        }
        if (hVar2 != null) {
            hVar2.g0(groupCode, oldOwnerUid, newOwnerUid, result, errMsg, from);
        }
    }

    private final void notifyTroopQuitOrDestroy(String groupCode, boolean isDestroyTroop, boolean isSuccess, int result, String from) {
        BusinessHandler businessHandler;
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        com.tencent.mobileqq.troop.api.handler.h hVar = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopMngHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.h) {
            hVar = (com.tencent.mobileqq.troop.api.handler.h) businessHandler;
        }
        com.tencent.mobileqq.troop.api.handler.h hVar2 = hVar;
        if (hVar2 != null) {
            hVar2.a1(isDestroyTroop, isSuccess, result, groupCode, from);
        }
    }

    private final void onIllegalParams(i asyncCallback) {
        if (asyncCallback != null) {
            asyncCallback.onResult(false, -1, "");
        }
    }

    private final void quitOrDestroyTroop(final String groupCode, final boolean holdMsg, final boolean isDestroy, LifecycleOwner owner, String from, i asyncCallback) {
        Long l3;
        String str;
        final String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
        QLog.i(TAG, 1, "[quitOrDestroyTroop] groupCode:" + groupCode + ", holdMsg:" + holdMsg + ", isDestroy:" + isDestroy + ", from:" + o16);
        if (groupCode != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(groupCode);
        } else {
            l3 = null;
        }
        Long l16 = l3;
        if (com.tencent.qqnt.e.c() != null && l16 != null) {
            final int h16 = getTroopOperationCallbackStore().h(owner, asyncCallback);
            AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
            if (e16 != null) {
                if (isDestroy) {
                    com.tencent.mobileqq.troop.api.config.ag.b(e16, groupCode);
                } else {
                    com.tencent.mobileqq.troop.api.config.ag.h(e16, groupCode);
                }
            }
            if (isDestroy) {
                str = "destroyGroupV2";
            } else {
                str = "quitGroupV2";
            }
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m(str, groupCode, "TroopOperationRepo-" + from, false, true, 8, null);
            IOperateCallback iOperateCallback = new IOperateCallback() { // from class: com.tencent.qqnt.troop.ci
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    TroopOperationRepo.quitOrDestroyTroop$lambda$38(com.tencent.qqnt.report.m.this, o16, isDestroy, groupCode, holdMsg, h16, i3, str2);
                }
            };
            if (isDestroy) {
                com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
                if (c16 != null) {
                    DestroyGroupReq destroyGroupReq = new DestroyGroupReq();
                    destroyGroupReq.groupCode = l16.longValue();
                    destroyGroupReq.needDeleteLocalMsg = !holdMsg;
                    c16.destroyGroupV2(destroyGroupReq, iOperateCallback);
                    return;
                }
                return;
            }
            com.tencent.qqnt.kernel.api.s c17 = com.tencent.qqnt.e.c();
            if (c17 != null) {
                QuitGroupReq quitGroupReq = new QuitGroupReq();
                quitGroupReq.groupCode = l16.longValue();
                quitGroupReq.needDeleteLocalMsg = !holdMsg;
                c17.quitGroupV2(quitGroupReq, iOperateCallback);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[quitOrDestroyTroop] illegal params");
        onIllegalParams(asyncCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void quitOrDestroyTroop$lambda$38(final com.tencent.qqnt.report.m report, final String uniqueFrom, final boolean z16, final String str, final boolean z17, final int i3, final int i16, final String str2) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        QLog.i(TAG, 1, "[quitOrDestroyTroop] result:" + i16 + ", err:" + str2 + ", from:" + uniqueFrom);
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.da
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.quitOrDestroyTroop$lambda$38$lambda$37(z16, i16, str2, str, z17, uniqueFrom, i3, report);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void quitOrDestroyTroop$lambda$38$lambda$37(boolean z16, int i3, String errMsg, String str, boolean z17, String uniqueFrom, int i16, com.tencent.qqnt.report.m report) {
        i iVar;
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        if (z16 && i3 == 2013004) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            com.tencent.qqnt.e.k(null, 1, errMsg, 0, null, 25, null);
        } else if (z16 && i3 == 2013005) {
            String qqStr = HardCodeUtil.qqStr(R.string.f2328775q);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.troop_disband_in_freeze)");
            com.tencent.qqnt.e.k(null, 1, qqStr, 0, null, 25, null);
        } else if (z16 && i3 == 2013006) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.f2328875r);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026op_disband_is_paid_group)");
            com.tencent.qqnt.e.k(null, 1, qqStr2, 0, null, 25, null);
        }
        if (com.tencent.qqnt.e.d(i3)) {
            TroopOperationRepo troopOperationRepo = INSTANCE;
            troopOperationRepo.cancelHideChat(str);
            troopOperationRepo.handleTroopMsg(str, z17, z16);
        }
        TroopOperationRepo troopOperationRepo2 = INSTANCE;
        troopOperationRepo2.notifyTroopQuitOrDestroy(str, z16, com.tencent.qqnt.e.d(i3), i3, uniqueFrom);
        Object f16 = troopOperationRepo2.getTroopOperationCallbackStore().f(i16);
        if (f16 instanceof i) {
            iVar = (i) f16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            iVar.onResult(d16, i3, errMsg);
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, errMsg, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAdminCanRcvJoinMsg$lambda$106(com.tencent.qqnt.report.m report, int i3, final int i16, final String str, RcvJoinVerifyMsgRsp rcvJoinVerifyMsgRsp) {
        final e eVar;
        Intrinsics.checkNotNullParameter(report, "$report");
        report.f();
        QLog.i(TAG, 1, "[modifyGroupDetailInfo] result:" + rcvJoinVerifyMsgRsp + "," + str);
        Object f16 = INSTANCE.getTroopOperationCallbackStore().f(i3);
        if (f16 instanceof e) {
            eVar = (e) f16;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.db
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.setAdminCanRcvJoinMsg$lambda$106$lambda$105$lambda$104(e.this, i16, str);
                }
            });
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i16), null, str, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAdminCanRcvJoinMsg$lambda$106$lambda$105$lambda$104(e it, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(it, "$it");
        boolean d16 = com.tencent.qqnt.e.d(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        it.onResult(d16, i3, errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGroupMsgMask$lambda$66(final com.tencent.qqnt.report.m report, String uniqueFrom, final String str, final int i3, final GroupMsgMask mask, final int i16, final String str2, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(mask, "$mask");
        report.f();
        QLog.i(TAG, 1, "[setGroupMsgMask] from:" + uniqueFrom + ", code:" + i16 + ", msg:" + str2 + ", result:" + setGroupMsgMaskRsp.rptMsgRspGroupInfo);
        com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.cg
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.setGroupMsgMask$lambda$66$lambda$65(i16, str, i3, str2, mask, report);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGroupMsgMask$lambda$66$lambda$65(int i3, String str, int i16, String errMsg, final GroupMsgMask mask, com.tencent.qqnt.report.m report) {
        e eVar;
        BusinessHandler businessHandler;
        Intrinsics.checkNotNullParameter(mask, "$mask");
        Intrinsics.checkNotNullParameter(report, "$report");
        if (com.tencent.qqnt.e.d(i3)) {
            INSTANCE.updateTroopInfo(str, false, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.troop.TroopOperationRepo$setGroupMsgMask$3$2$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupMsgMask.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopInfo it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.troopmask = GroupMsgMask.this;
                    }
                }
            });
        }
        Object f16 = INSTANCE.getTroopOperationCallbackStore().f(i16);
        if (f16 instanceof e) {
            eVar = (e) f16;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            eVar.onResult(d16, i3, errMsg);
        }
        Object[] objArr = {str, mask};
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null && (businessHandler = e16.getBusinessHandler(RoamSettingHandler.class.getName())) != null) {
            businessHandler.notifyUI(4, true, objArr);
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, errMsg, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGroupMsgMaskV2_0$lambda$49(final com.tencent.qqnt.report.m report, final String uniqueFrom, final int i3, final String str, final String str2, final int i16, final int i17, final String str3, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        QLog.i(TAG, 1, "[setGroupMsgMaskV2_0] from:" + uniqueFrom + ", code:" + i17 + ", msg:" + str3 + ", result:" + setGroupMsgMaskRsp.rptMsgRspGroupInfo);
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.cr
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.setGroupMsgMaskV2_0$lambda$49$lambda$48(i3, i17, str3, str, str2, i16, uniqueFrom, report);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGroupMsgMaskV2_0$lambda$49$lambda$48(int i3, int i16, String errMsg, String str, String str2, int i17, String uniqueFrom, com.tencent.qqnt.report.m report) {
        i iVar;
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        TroopOperationRepo troopOperationRepo = INSTANCE;
        Object f16 = troopOperationRepo.getTroopOperationCallbackStore().f(i3);
        if (f16 instanceof i) {
            iVar = (i) f16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i16);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            iVar.onResult(d16, i16, errMsg);
        }
        troopOperationRepo.notifyModifyGroupGroupMsgMask(com.tencent.qqnt.e.d(i16), str, str2, i17, 0, uniqueFrom);
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i16), null, errMsg, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGroupMsgMaskV2_4$lambda$57(final com.tencent.qqnt.report.m report, final String uniqueFrom, final int i3, final String str, final int i16, final String str2, final int i17, final int i18, final String str3, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        QLog.i(TAG, 1, "[setGroupMsgMaskV2_4] from:" + uniqueFrom + ", code:" + i18 + ", msg:" + str3 + ", result:" + setGroupMsgMaskRsp.rptMsgRspGroupInfo);
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.cc
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.setGroupMsgMaskV2_4$lambda$57$lambda$56(i18, i3, str, i16, str3, str2, i17, uniqueFrom, report);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGroupMsgMaskV2_4$lambda$57$lambda$56(int i3, final int i16, String str, int i17, String errMsg, String str2, final int i18, String uniqueFrom, com.tencent.qqnt.report.m report) {
        i iVar;
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        if (com.tencent.qqnt.e.d(i3) && i16 != 0 && i16 != 9) {
            INSTANCE.updateTroopInfo(str, true, new Function1<TroopInfo, Unit>(i18, i16) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$setGroupMsgMaskV2_4$3$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $op;
                final /* synthetic */ int $type;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$op = i18;
                    this.$type = i16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i18), Integer.valueOf(i16));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopInfo it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.setCmdUinFlagEx2(this.$op == 1, this.$type);
                    }
                }
            });
        }
        TroopOperationRepo troopOperationRepo = INSTANCE;
        Object f16 = troopOperationRepo.getTroopOperationCallbackStore().f(i17);
        if (f16 instanceof i) {
            iVar = (i) f16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            iVar.onResult(d16, i3, errMsg);
        }
        troopOperationRepo.notifyModifyGroupGroupMsgMask(com.tencent.qqnt.e.d(i3), str, str2, i18, i16, uniqueFrom);
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, errMsg, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTroopIsActive$lambda$119(final com.tencent.qqnt.report.m report, final String from, final int i3, final String str, final int i16, final String str2) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        report.f();
        QLog.i(TAG, 1, "[setTroopIsActive] from:" + from + ", result:" + i16 + ",errMsg:" + str2);
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.cz
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.setTroopIsActive$lambda$119$lambda$118(i3, i16, str, report, str2, from);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTroopIsActive$lambda$119$lambda$118(int i3, final int i16, String str, com.tencent.qqnt.report.m report, final String str2, String from) {
        final e eVar;
        Unit unit;
        Object obj;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        Object f16 = INSTANCE.getTroopOperationCallbackStore().f(i3);
        com.tencent.mobileqq.troop.troopmanager.api.a aVar = null;
        if (f16 instanceof e) {
            eVar = (e) f16;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.bv
                @Override // java.lang.Runnable
                public final void run() {
                    TroopOperationRepo.setTroopIsActive$lambda$119$lambda$118$lambda$114$lambda$113(e.this, i16, str2);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(TAG, 1, "[setTroopIsActive] from:" + from + ", get callback fail");
        }
        if (com.tencent.qqnt.e.d(i16)) {
            AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
            if (e16 != null) {
                obj = e16.getBusinessHandler(TroopManagerBizHandler.class.getName());
            } else {
                obj = null;
            }
            if (obj instanceof com.tencent.mobileqq.troop.troopmanager.api.a) {
                aVar = (com.tencent.mobileqq.troop.troopmanager.api.a) obj;
            }
            if (aVar == null) {
                QLog.i(TAG, 1, "[setTroopIsActive] from:" + from + ", handler is null");
                Unit unit2 = Unit.INSTANCE;
            }
            if (aVar != null) {
                aVar.l0(str);
            }
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i16), null, str2, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTroopIsActive$lambda$119$lambda$118$lambda$114$lambda$113(e it, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(it, "$it");
        boolean d16 = com.tencent.qqnt.e.d(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        it.onResult(d16, i3, errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transferGroup$lambda$31(final com.tencent.qqnt.report.m report, final String str, final String str2, final String from, final String str3, final Long l3, final String str4, final String str5, final String uniqueFrom, final int i3, final int i16, final String str6, final TransferGroupRsp transferGroupRsp) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.bx
            @Override // java.lang.Runnable
            public final void run() {
                TroopOperationRepo.transferGroup$lambda$31$lambda$30(str6, i16, transferGroupRsp, str, str2, from, str3, l3, str4, str5, uniqueFrom, i3, report);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transferGroup$lambda$31$lambda$30(String str, int i3, TransferGroupRsp transferGroupRsp, String str2, String str3, String from, final String str4, Long l3, String str5, final String str6, String uniqueFrom, int i16, com.tencent.qqnt.report.m report) {
        String errMsg;
        int i17;
        boolean z16;
        i iVar;
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        QLog.i(TAG, 1, "[transferGroup] code:" + i3 + ", msg:" + str + ", from:" + uniqueFrom + ", result:" + transferGroupRsp);
        int i18 = transferGroupRsp.result;
        if (i18 > 0) {
            i17 = i18;
            errMsg = transferGroupRsp.strClientPrompt;
        } else {
            errMsg = str;
            i17 = i3;
        }
        boolean z17 = com.tencent.qqnt.e.d(i3) && com.tencent.qqnt.e.d(transferGroupRsp.result);
        if (z17) {
            z16 = z17;
            updateTroopInfo$default(INSTANCE, str2, false, new Function1<TroopInfo, Unit>(str4, str6) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$transferGroup$3$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $newOwnerUid;
                final /* synthetic */ String $newOwnerUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$newOwnerUin = str4;
                    this.$newOwnerUid = str6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str4, (Object) str6);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopInfo it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.troopowneruin = this.$newOwnerUin;
                    it.troopOwnerUid = this.$newOwnerUid;
                    it.memberRole = MemberRole.MEMBER;
                }
            }, 2, null);
            TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
            iVar = null;
            TroopMemberInfo troopMemberFromCache = troopMemberListRepo.getTroopMemberFromCache(str2, str3, null, "TroopOperationRepo-" + from);
            if (troopMemberFromCache != null) {
                troopMemberFromCache.role = MemberRole.MEMBER;
            }
            TroopMemberInfo troopMemberFromCache2 = troopMemberListRepo.getTroopMemberFromCache(str2, str4, null, "TroopOperationRepo-" + from);
            if (troopMemberFromCache2 != null) {
                troopMemberFromCache2.role = MemberRole.OWNER;
            }
        } else {
            z16 = z17;
            iVar = null;
        }
        TroopOperationRepo troopOperationRepo = INSTANCE;
        i iVar2 = iVar;
        troopOperationRepo.notifyTransferGroup(l3.longValue(), str5, str6, i17, errMsg, uniqueFrom);
        Object f16 = troopOperationRepo.getTroopOperationCallbackStore().f(i16);
        i iVar3 = f16 instanceof i ? (i) f16 : iVar2;
        if (iVar3 != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            iVar3.onResult(z16, i17, errMsg);
        }
        report.b(Integer.valueOf(i3), Integer.valueOf(transferGroupRsp.result), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAllowMemberModifyTroopName$lambda$132(String str, int i3, e callback, boolean z16, int i16, String errMsg) {
        GroupExt groupExt;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (z16) {
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(str);
            if (troopInfoFromCache != null) {
                groupExt = troopInfoFromCache.groupExt;
            } else {
                groupExt = null;
            }
            if (groupExt != null) {
                groupExt.memberChangeGroupNameSwitch = i3;
            }
        }
        callback.onResult(z16, i16, errMsg);
    }

    private final void updateFlagExt3(String troopUin, String log, final int mask, final boolean open) {
        updateGroupInfo(troopUin, log + ContainerUtils.KEY_VALUE_DELIMITER + open, new Function2<String, GroupInfoCacheReq, Unit>(open, mask) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$updateFlagExt3$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $mask;
            final /* synthetic */ boolean $open;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$open = open;
                this.$mask = mask;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(open), Integer.valueOf(mask));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupInfoCacheReq groupInfoCacheReq) {
                invoke2(str, groupInfoCacheReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopCode, @NotNull GroupInfoCacheReq req) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopCode, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopCode, "troopCode");
                Intrinsics.checkNotNullParameter(req, "req");
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopCode);
                if (troopInfoFromCache != null) {
                    boolean z16 = this.$open;
                    int i3 = this.$mask;
                    if (z16) {
                        troopInfoFromCache.dwGroupFlagExt3 = i3 | troopInfoFromCache.dwGroupFlagExt3;
                    } else {
                        troopInfoFromCache.dwGroupFlagExt3 = (~i3) & troopInfoFromCache.dwGroupFlagExt3;
                    }
                    req.detailInfo.groupFlagExt3 = (int) troopInfoFromCache.dwGroupFlagExt3;
                }
                req.filter.groupFlagExt3 = true;
            }
        });
    }

    private final void updateFlagExt4(String troopUin, String log, final int mask, final boolean open) {
        updateGroupInfo(troopUin, log + ContainerUtils.KEY_VALUE_DELIMITER + open, new Function2<String, GroupInfoCacheReq, Unit>(open, mask) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$updateFlagExt4$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $mask;
            final /* synthetic */ boolean $open;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$open = open;
                this.$mask = mask;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(open), Integer.valueOf(mask));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupInfoCacheReq groupInfoCacheReq) {
                invoke2(str, groupInfoCacheReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopCode, @NotNull GroupInfoCacheReq req) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopCode, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopCode, "troopCode");
                Intrinsics.checkNotNullParameter(req, "req");
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopCode);
                if (troopInfoFromCache != null) {
                    boolean z16 = this.$open;
                    int i3 = this.$mask;
                    if (z16) {
                        troopInfoFromCache.groupFlagExt4 |= i3;
                    } else {
                        troopInfoFromCache.groupFlagExt4 &= ~i3;
                    }
                    req.detailInfo.groupFlagExt4 = troopInfoFromCache.groupFlagExt4;
                }
                req.filter.groupFlagExt4 = true;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateGroupInfo(String troopUin, String log, Function2<? super String, ? super GroupInfoCacheReq, Unit> callback) {
        Long longOrNull;
        com.tencent.qqnt.kernel.api.s c16;
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateGroupInfo: troopUin=" + troopUin + ", " + log);
            }
            GroupInfoCacheReq groupInfoCacheReq = new GroupInfoCacheReq();
            groupInfoCacheReq.groupCode = longValue;
            callback.invoke(troopUin, groupInfoCacheReq);
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null && troopInfoFromCache.isMember() && (c16 = com.tencent.qqnt.e.c()) != null) {
                c16.updateGroupInfoByMqq(groupInfoCacheReq);
            }
        }
    }

    private final void updateTroopInfo(String troopUin, boolean createNewWhenNull, Function1<? super TroopInfo, Unit> operation) {
        if (troopUin == null) {
            return;
        }
        TroopInfo troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        if (createNewWhenNull && troopInfoFromCache == null) {
            troopInfoFromCache = new TroopInfo(troopUin);
        }
        if (troopInfoFromCache != null) {
            operation.invoke(troopInfoFromCache);
        }
    }

    static /* synthetic */ void updateTroopInfo$default(TroopOperationRepo troopOperationRepo, String str, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        troopOperationRepo.updateTroopInfo(str, z16, function1);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void createGroupV2(@NotNull com.tencent.qqnt.bean.a createParam, @Nullable LifecycleOwner owner, @NotNull String from, @NotNull final WeakReference<Activity> weakAct, @Nullable b asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, createParam, owner, from, weakAct, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(createParam, "createParam");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(weakAct, "weakAct");
        final String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
        QLog.i(TAG, 1, "[createGroupV2] from:" + o16 + ", param:" + createParam);
        CreateGroupReq b16 = createParam.b();
        final int h16 = getTroopOperationCallbackStore().h(owner, asyncCallback);
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("createGroupV2", createParam.d(), "TroopOperationRepo-" + from, false, true, 8, null);
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.createGroupV2(b16, createParam.c(), new ICreateGroupCallback() { // from class: com.tencent.qqnt.troop.cu
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICreateGroupCallback
                public final void onResult(int i3, String str, CreateGroupResult createGroupResult) {
                    TroopOperationRepo.createGroupV2$lambda$5(com.tencent.qqnt.report.m.this, h16, o16, weakAct, i3, str, createGroupResult);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void destroyGroup(@Nullable String groupCode, boolean holdMsg, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, groupCode, Boolean.valueOf(holdMsg), owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            quitOrDestroyTroop(groupCode, holdMsg, true, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void joinGroup(@NotNull JoinTroopParam joinTroopParam, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, joinTroopParam, owner, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(joinTroopParam, "joinTroopParam");
        Intrinsics.checkNotNullParameter(from, "from");
        String o16 = com.tencent.qqnt.e.o(from, callback);
        QLog.i(TAG, 1, "[joinGroup] from:" + o16 + ", param:" + joinTroopParam);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[joinGroup] from:" + o16 + ", param.authSig:" + joinTroopParam.b());
        }
        joinGroupInner(joinTroopParam, getTroopOperationCallbackStore().h(owner, callback), from, o16);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void joinGroupForSecurityBack(@NotNull JoinTroopParam joinTroopParam, boolean continueRequest, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, joinTroopParam, Boolean.valueOf(continueRequest), from);
            return;
        }
        Intrinsics.checkNotNullParameter(joinTroopParam, "joinTroopParam");
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i(TAG, 1, "[joinGroupForSecurityBack] from:" + from + ", continueRequest:" + continueRequest + ", param:" + joinTroopParam);
        if (continueRequest) {
            joinGroupInner(joinTroopParam, joinTroopParam.c(), from, from);
        } else {
            notifyJoinGroupResult(false, -1, joinTroopParam.e());
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyAllowMemberInvite(@Nullable String troopUin, final boolean isAllow, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, troopUin, Boolean.valueOf(isAllow), owner, callback);
            return;
        }
        QLog.i(TAG, 1, "[modifyAllowMemberInvite] troopUin:" + troopUin + ", isAllow:" + isAllow);
        modifyGroupDetailInfo$default(this, troopUin, owner, "memberInvite", 0, callback, new Function1<GroupModifyInfoReq, Unit>(isAllow) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyAllowMemberInvite$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $isAllow;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$isAllow = isAllow;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, isAllow);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                req.filter.allowMemberInvite = 1;
                req.modifyInfo.allowMemberInvite = this.$isAllow ? 1 : 0;
            }
        }, null, 72, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyAnswerAndQuestion(@Nullable String troopUin, @Nullable final String question, @Nullable final String answer, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, troopUin, question, answer, owner, callback);
            return;
        }
        QLog.i(TAG, 1, "[modifyAnswerAndQuestion] troopUin:" + troopUin + ", question:" + question + ", answer:" + answer);
        modifyGroupDetailInfo$default(this, troopUin, owner, "A&Q", 0, callback, new Function1<GroupModifyInfoReq, Unit>(question, answer) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyAnswerAndQuestion$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $answer;
            final /* synthetic */ String $question;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$question = question;
                this.$answer = answer;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) question, (Object) answer);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                groupModifyInfoFilter.groupQuestion = 1;
                groupModifyInfoFilter.groupAnswer = 1;
                GroupModifyInfo groupModifyInfo = req.modifyInfo;
                String str = this.$question;
                String str2 = this.$answer;
                if (str == null) {
                    str = "";
                }
                groupModifyInfo.groupQuestion = str;
                if (str2 == null) {
                    str2 = "";
                }
                groupModifyInfo.groupAnswer = str2;
            }
        }, null, 72, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyEnableHistoryForNewMember(@Nullable String troopUin, boolean on5, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        final int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, troopUin, Boolean.valueOf(on5), owner, callback);
            return;
        }
        QLog.i(TAG, 1, "[modifyEnableHistoryForNewMember] troopUin:" + troopUin + ", on:" + on5);
        if (!on5) {
            i3 = 0;
        }
        modifyGroupDetailInfo$default(this, troopUin, owner, "history", 0, callback, new Function1<GroupModifyInfoReq, Unit>(i3) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyEnableHistoryForNewMember$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $mask;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$mask = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                groupModifyInfoFilter.groupFlagExt4 = 1;
                groupModifyInfoFilter.groupFlagExt4Mask = 1;
                GroupModifyInfo groupModifyInfo = req.modifyInfo;
                groupModifyInfo.groupFlagExt4 = this.$mask;
                groupModifyInfo.groupFlagExt4Mask = 4;
            }
        }, null, 72, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyGameCardSwitch(@Nullable final String troopUin, int gameType, boolean on5, @Nullable LifecycleOwner owner, @Nullable e callback) {
        final TroopInfo troopInfo;
        final int groupFlagPro1Mask;
        final int groupFlagPro1;
        IPatchRedirector iPatchRedirector = $redirector_;
        final int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, Integer.valueOf(gameType), Boolean.valueOf(on5), owner, callback);
            return;
        }
        QLog.i(TAG, 1, "[modifyGameCardSwitch] troopUin:" + troopUin + ", gameType:" + gameType + ", on:" + on5);
        ITroopInfoService iTroopInfoService = (ITroopInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopInfoService.class);
        if (iTroopInfoService != null) {
            troopInfo = iTroopInfoService.getTroopInfo(troopUin);
        } else {
            troopInfo = null;
        }
        if (troopInfo == null) {
            QLog.e(TAG, 1, "setTroopGameCardSwitch, empty TroopInfo");
            return;
        }
        final int groupFlagPro1MaskFromGameType = troopInfo.getGroupFlagPro1MaskFromGameType(gameType);
        if (on5) {
            i3 = groupFlagPro1MaskFromGameType;
        }
        if (on5) {
            groupFlagPro1Mask = groupFlagPro1MaskFromGameType;
        } else {
            groupFlagPro1Mask = troopInfo.groupFlagPro1Mask() | groupFlagPro1MaskFromGameType;
        }
        if (on5) {
            groupFlagPro1 = groupFlagPro1MaskFromGameType;
        } else {
            groupFlagPro1 = troopInfo.groupFlagPro1() & (~groupFlagPro1MaskFromGameType);
        }
        modifyGroupDetailInfo$default(this, troopUin, owner, "game", 0, callback, new Function1<GroupModifyInfoReq, Unit>(groupFlagPro1MaskFromGameType, i3) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyGameCardSwitch$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $flag;
            final /* synthetic */ int $mask;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$mask = groupFlagPro1MaskFromGameType;
                this.$flag = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(groupFlagPro1MaskFromGameType), Integer.valueOf(i3));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                groupModifyInfoFilter.groupFlagPro1Mask = 1;
                groupModifyInfoFilter.groupFlagPro1 = 1;
                GroupModifyInfo groupModifyInfo = req.modifyInfo;
                int i16 = this.$mask;
                int i17 = this.$flag;
                groupModifyInfo.groupFlagPro1Mask = i16;
                groupModifyInfo.groupFlagPro1 = i17;
            }
        }, new h() { // from class: com.tencent.qqnt.troop.bw
            @Override // com.tencent.qqnt.troop.h
            public final void onResult(int i16, String str) {
                TroopOperationRepo.modifyGameCardSwitch$lambda$73(TroopInfo.this, groupFlagPro1Mask, groupFlagPro1, troopUin, i16, str);
            }
        }, 8, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyGroupName(@Nullable final String groupCode, @NotNull final String groupName, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        boolean z16;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, groupCode, groupName, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(from, "from");
        final String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(groupCode);
        if (troopInfoFromCache != null && troopInfoFromCache.isOwnerOrAdmin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z18 = !z16;
        if (troopInfoFromCache != null) {
            z17 = true;
        }
        QLog.i(TAG, 1, "[modifyGroupName] groupCode:" + groupCode + ", groupName:" + groupName + ", info:" + z17 + ", isNormalMember:" + z18 + ", from:" + o16);
        if (groupCode != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(groupCode);
        } else {
            l3 = null;
        }
        Long l16 = l3;
        if (com.tencent.qqnt.e.c() != null && l16 != null) {
            final int h16 = getTroopOperationCallbackStore().h(owner, asyncCallback);
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("modifyGroupName:" + z18, groupCode, "TroopOperationRepo-" + from, false, true, 8, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.modifyGroupName(l16.longValue(), groupName, z18, new IOperateCallback() { // from class: com.tencent.qqnt.troop.br
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        TroopOperationRepo.modifyGroupName$lambda$19(com.tencent.qqnt.report.m.this, groupCode, groupName, o16, h16, i3, str);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[modifyGroupName] illegal params");
        onIllegalParams(asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyGroupRemark(@Nullable final String groupCode, @Nullable final String groupRemark, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, groupCode, groupRemark, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (groupCode == null || groupCode.length() == 0) {
            z16 = true;
        }
        if (!z16 && groupRemark != null) {
            final String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
            QLog.i(TAG, 1, "[modifyGroupRemark] groupCode:" + groupCode + ", remark:" + groupRemark + ", from:" + o16);
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(groupCode);
            if (com.tencent.qqnt.e.c() != null && longOrNull != null) {
                final int h16 = getTroopOperationCallbackStore().h(owner, asyncCallback);
                final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("modifyGroupRemark", groupCode, "TroopOperationRepo-" + from, false, true, 8, null);
                com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
                if (c16 != null) {
                    c16.modifyGroupRemark(longOrNull.longValue(), groupRemark, new IOperateCallback() { // from class: com.tencent.qqnt.troop.cf
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            TroopOperationRepo.modifyGroupRemark$lambda$25(com.tencent.qqnt.report.m.this, groupCode, o16, h16, groupRemark, i3, str);
                        }
                    });
                    return;
                }
                return;
            }
            QLog.e(TAG, 1, "[modifyGroupRemark] illegal params");
            onIllegalParams(asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyOnlyTroopMemberInviteJoinTroop(@Nullable LifecycleOwner owner, @Nullable String groupCode, final boolean isAllowMemberInvite, final boolean onlyInviteJoinTroop, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, owner, groupCode, Boolean.valueOf(isAllowMemberInvite), Boolean.valueOf(onlyInviteJoinTroop), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            modifyGroupDetailInfo$default(this, groupCode, owner, "modifyOnlyTroopMemberInviteJoinTroop", 8, callback, new Function1<GroupModifyInfoReq, Unit>(onlyInviteJoinTroop, isAllowMemberInvite) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyOnlyTroopMemberInviteJoinTroop$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isAllowMemberInvite;
                final /* synthetic */ boolean $onlyInviteJoinTroop;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$onlyInviteJoinTroop = onlyInviteJoinTroop;
                    this.$isAllowMemberInvite = isAllowMemberInvite;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Boolean.valueOf(onlyInviteJoinTroop), Boolean.valueOf(isAllowMemberInvite));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                    invoke2(groupModifyInfoReq);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GroupModifyInfoReq req) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(req, "req");
                    GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                    groupModifyInfoFilter.allowMemberInvite = 1;
                    groupModifyInfoFilter.groupFlagExt3 = 1;
                    groupModifyInfoFilter.groupFlagExt3Mask = 1;
                    boolean z16 = this.$onlyInviteJoinTroop;
                    if (z16) {
                        groupModifyInfoFilter.addOption = 1;
                    }
                    GroupModifyInfo groupModifyInfo = req.modifyInfo;
                    groupModifyInfo.allowMemberInvite = this.$isAllowMemberInvite ? 1 : 0;
                    groupModifyInfo.groupFlagExt3 = z16 ? 4 : 0;
                    groupModifyInfo.groupFlagExt3Mask = 4;
                    if (z16) {
                        groupModifyInfo.addOption = 2;
                    }
                }
            }, null, 64, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopData(@Nullable String troopUin, @NotNull final com.tencent.mobileqq.data.troop.b troopCard, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, troopUin, troopCard, owner, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopCard, "troopCard");
        Intrinsics.checkNotNullParameter(from, "from");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "modifyTroopData: troopUin=" + troopUin + ", troopCard=" + troopCard + ", from:" + from);
        }
        modifyGroupDetailInfo$default(this, troopUin, owner, "modifyTroopData-" + from, 0, callback, new Function1<GroupModifyInfoReq, Unit>() { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.data.troop.b.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                req.filter = com.tencent.mobileqq.data.troop.b.this.getFilter();
                req.modifyInfo = com.tencent.mobileqq.data.troop.b.this.getModifyInfo();
            }
        }, null, 72, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopJoinTypeFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, final int joinTypeOpt, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, owner, groupCode, Integer.valueOf(joinTypeOpt), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            modifyGroupDetailInfo$default(this, groupCode, owner, "modifyTroopJoinTypeFlag", 8, callback, new Function1<GroupModifyInfoReq, Unit>(joinTypeOpt) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopJoinTypeFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $joinTypeOpt;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$joinTypeOpt = joinTypeOpt;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, joinTypeOpt);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                    invoke2(groupModifyInfoReq);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GroupModifyInfoReq req) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(req, "req");
                    GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                    groupModifyInfoFilter.addOption = 1;
                    int i3 = this.$joinTypeOpt;
                    if (i3 == 1) {
                        groupModifyInfoFilter.allowMemberInvite = 1;
                    }
                    GroupModifyInfo groupModifyInfo = req.modifyInfo;
                    groupModifyInfo.addOption = i3;
                    if (i3 == 1) {
                        groupModifyInfo.allowMemberInvite = 1;
                    }
                }
            }, null, 64, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c4, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00de, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0102, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r4);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void modifyTroopLocation(@Nullable final String troopUin, @Nullable final String troopLocation, @Nullable LifecycleOwner owner, @Nullable e callback) {
        Long l3;
        String str;
        String str2;
        Object orNull;
        Object orNull2;
        long j3;
        Object orNull3;
        Object orNull4;
        Double doubleOrNull;
        Double doubleOrNull2;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, troopUin, troopLocation, owner, callback);
            return;
        }
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        String str3 = "";
        final String o16 = com.tencent.qqnt.e.o("", callback);
        if (l3 == null) {
            QLog.e(TAG, 1, "[modifyTroopLocation] from:" + o16 + ", troopUin:" + troopUin);
            return;
        }
        QLog.i(TAG, 1, "[modifyTroopLocation] from:" + o16 + ", tUin:" + troopUin + ", loc:" + troopLocation);
        if (troopLocation == null) {
            str = "";
        } else {
            str = troopLocation;
        }
        final GroupGeoInfoReq groupGeoInfoReq = new GroupGeoInfoReq();
        groupGeoInfoReq.groupCode = l3.longValue();
        GroupGeoInfo groupGeoInfo = groupGeoInfoReq.groupGeoInfo;
        groupGeoInfo.GeoContent = str;
        TroopInfo troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache == null || (str2 = troopInfoFromCache.troopOwnerUid) == null) {
            str2 = "";
        }
        groupGeoInfo.ownerUid = str2;
        List<String> split = new Regex("\\|").split(str, 0);
        if (!split.isEmpty()) {
            GroupGeoInfo groupGeoInfo2 = groupGeoInfoReq.groupGeoInfo;
            orNull = CollectionsKt___CollectionsKt.getOrNull(split, 0);
            String str4 = (String) orNull;
            if (str4 != null && intOrNull != null) {
                i3 = intOrNull.intValue();
            }
            groupGeoInfo2.setCityId(i3);
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(split, 1);
            String str5 = (String) orNull2;
            long j16 = 0;
            if (str5 != null && doubleOrNull2 != null) {
                j3 = Long.valueOf((long) (1000000 * doubleOrNull2.doubleValue())).longValue();
            } else {
                j3 = 0;
            }
            groupGeoInfo2.setLatitude(j3);
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(split, 2);
            String str6 = (String) orNull3;
            if (str6 != null && doubleOrNull != null) {
                j16 = Long.valueOf((long) (doubleOrNull.doubleValue() * 1000000)).longValue();
            }
            groupGeoInfo2.setLongitude(j16);
            orNull4 = CollectionsKt___CollectionsKt.getOrNull(split, 3);
            String str7 = (String) orNull4;
            if (str7 != null) {
                str3 = str7;
            }
            groupGeoInfo2.setGeoContent(str3);
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[modifyTroopLocation] from:" + o16 + ", req:" + groupGeoInfoReq);
        }
        final int h16 = getTroopOperationCallbackStore().h(owner, callback);
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setGroupGeoInfo", troopUin, TAG, false, true, 8, null);
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.setGroupGeoInfo(groupGeoInfoReq, new IOperateCallback() { // from class: com.tencent.qqnt.troop.bq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str8) {
                    TroopOperationRepo.modifyTroopLocation$lambda$101(com.tencent.qqnt.report.m.this, o16, troopUin, h16, troopLocation, groupGeoInfoReq, i16, str8);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopMsgLimitFreq(@Nullable final String troopUin, final int msgLimitFreq, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, troopUin, Integer.valueOf(msgLimitFreq), owner, callback);
            return;
        }
        QLog.i(TAG, 1, "[modifyTroopMsgLimitFreq] troopUin:" + troopUin + ", msgLimitFreq:" + msgLimitFreq);
        modifyGroupDetailInfo$default(this, troopUin, owner, "msgLimit", 0, callback, new Function1<GroupModifyInfoReq, Unit>(msgLimitFreq) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopMsgLimitFreq$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $msgLimitFreq;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$msgLimitFreq = msgLimitFreq;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, msgLimitFreq);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                req.filter.msgLimitFrequency = 1;
                req.modifyInfo.msgLimitFrequency = this.$msgLimitFreq;
            }
        }, new h() { // from class: com.tencent.qqnt.troop.cp
            @Override // com.tencent.qqnt.troop.h
            public final void onResult(int i3, String str) {
                TroopOperationRepo.modifyTroopMsgLimitFreq$lambda$76(troopUin, msgLimitFreq, i3, str);
            }
        }, 8, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopNickRule(@Nullable String troopUin, @Nullable final String intro, @NotNull final ArrayList<String> prefixWords, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, troopUin, intro, prefixWords, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(prefixWords, "prefixWords");
        QLog.i(TAG, 1, "[modifyTroopNickRule] troopUin:" + troopUin + ", intro:" + intro + ", prefixWords:" + prefixWords);
        modifyGroupDetailInfo$default(this, troopUin, owner, "nickRule", 0, callback, new Function1<GroupModifyInfoReq, Unit>(intro, prefixWords) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopNickRule$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $intro;
            final /* synthetic */ ArrayList<String> $prefixWords;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$intro = intro;
                this.$prefixWords = prefixWords;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) intro, (Object) prefixWords);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                GroupCardPrefixFilter groupCardPrefixFilter = req.filter.groupCardPrefix;
                groupCardPrefixFilter.introduction = 1;
                groupCardPrefixFilter.rptPrefix = 1;
                GroupCardPrefix groupCardPrefix = req.modifyInfo.groupCardPrefix;
                String str = this.$intro;
                ArrayList<String> arrayList = this.$prefixWords;
                if (str == null) {
                    str = "";
                }
                groupCardPrefix.introduction = str;
                groupCardPrefix.rptPrefix = arrayList;
            }
        }, null, 72, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopPayToJoinFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, final int privilegeMask, final int privilegeFlag, final int joinTypeOpt, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, owner, groupCode, Integer.valueOf(privilegeMask), Integer.valueOf(privilegeFlag), Integer.valueOf(joinTypeOpt), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            modifyGroupDetailInfo$default(this, groupCode, owner, "modifyTroopPayToJoinFlag", 8, callback, new Function1<GroupModifyInfoReq, Unit>(privilegeMask, privilegeFlag, joinTypeOpt) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopPayToJoinFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $joinTypeOpt;
                final /* synthetic */ int $privilegeFlag;
                final /* synthetic */ int $privilegeMask;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$privilegeMask = privilegeMask;
                    this.$privilegeFlag = privilegeFlag;
                    this.$joinTypeOpt = joinTypeOpt;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(privilegeMask), Integer.valueOf(privilegeFlag), Integer.valueOf(joinTypeOpt));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                    invoke2(groupModifyInfoReq);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GroupModifyInfoReq req) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(req, "req");
                    GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                    groupModifyInfoFilter.appPrivilegeMask = 1;
                    groupModifyInfoFilter.appPrivilegeFlag = 1;
                    groupModifyInfoFilter.addOption = 1;
                    GroupModifyInfo groupModifyInfo = req.modifyInfo;
                    groupModifyInfo.appPrivilegeMask = this.$privilegeMask;
                    groupModifyInfo.appPrivilegeFlag = this.$privilegeFlag;
                    groupModifyInfo.addOption = this.$joinTypeOpt;
                }
            }, null, 64, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopPrivilegeFlag(@Nullable LifecycleOwner owner, @Nullable String groupCode, final long privilegeFlag, final long privilegeMask, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, owner, groupCode, Long.valueOf(privilegeFlag), Long.valueOf(privilegeMask), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            modifyGroupDetailInfoV2Privilege(new Function1<GroupModifyInfo, Unit>(privilegeFlag, privilegeMask) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopPrivilegeFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $privilegeFlag;
                final /* synthetic */ long $privilegeMask;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$privilegeFlag = privilegeFlag;
                    this.$privilegeMask = privilegeMask;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(privilegeFlag), Long.valueOf(privilegeMask));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfo groupModifyInfo) {
                    invoke2(groupModifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GroupModifyInfo it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.appPrivilegeFlag = (int) this.$privilegeFlag;
                    it.appPrivilegeMask = (int) this.$privilegeMask;
                }
            }, owner, groupCode, callback, "modifyTroopPrivilegeFlag");
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopSearchType(@Nullable LifecycleOwner owner, @Nullable final String groupCode, int opt, @NotNull e callback) {
        Pair pair;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, owner, groupCode, Integer.valueOf(opt), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (opt != 0) {
            if (opt != 1) {
                if (opt != 2) {
                    QLog.e(TAG, 1, "modifyTroopSearchType, opt:" + opt + ", invalid!");
                    if (AppSetting.isPublicVersion()) {
                        return;
                    } else {
                        throw new IllegalArgumentException("modifyTroopSearchType opt invalid.");
                    }
                }
                pair = new Pair(0, 0);
            } else {
                pair = new Pair(1, 0);
            }
        } else {
            pair = new Pair(1, 1);
        }
        final int intValue = ((Number) pair.component1()).intValue();
        final int intValue2 = ((Number) pair.component2()).intValue();
        modifyGroupDetailInfo(groupCode, owner, "modifyTroopSearchType", 8, callback, new Function1<GroupModifyInfoReq, Unit>(intValue, intValue2) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopSearchType$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $noCodeFingerOpenFlag;
            final /* synthetic */ int $noFingerOpenFlag;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$noFingerOpenFlag = intValue;
                this.$noCodeFingerOpenFlag = intValue2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(intValue), Integer.valueOf(intValue2));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                GroupModifyInfoFilter groupModifyInfoFilter = req.filter;
                groupModifyInfoFilter.noFingerOpenFlag = 1;
                groupModifyInfoFilter.noCodeFingerOpenFlag = 1;
                GroupModifyInfo groupModifyInfo = req.modifyInfo;
                groupModifyInfo.noFingerOpenFlag = this.$noFingerOpenFlag;
                groupModifyInfo.noCodeFingerOpenFlag = this.$noCodeFingerOpenFlag;
            }
        }, new a(new Function2<Integer, String, Unit>(groupCode, intValue2, intValue) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopSearchType$innerCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupCode;
            final /* synthetic */ int $noCodeFingerOpenFlag;
            final /* synthetic */ int $noFingerOpenFlag;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$groupCode = groupCode;
                this.$noCodeFingerOpenFlag = intValue2;
                this.$noFingerOpenFlag = intValue;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, groupCode, Integer.valueOf(intValue2), Integer.valueOf(intValue));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                if (com.tencent.qqnt.e.d(i3)) {
                    TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(this.$groupCode);
                    if (troopInfoFromCache != null) {
                        troopInfoFromCache.mCanSearchByTroopUin = this.$noCodeFingerOpenFlag == 0;
                    }
                    if (troopInfoFromCache == null) {
                        return;
                    }
                    troopInfoFromCache.mCanSearchByKeywords = this.$noFingerOpenFlag == 0;
                }
            }
        }));
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopSelectedGameId(@Nullable LifecycleOwner owner, @Nullable String groupCode, @NotNull final ArrayList<Integer> selectedGameIds, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, owner, groupCode, selectedGameIds, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(selectedGameIds, "selectedGameIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        modifyGroupDetailInfo$default(this, groupCode, owner, "modifyTroopSelectedGameId", 0, callback, new Function1<GroupModifyInfoReq, Unit>(selectedGameIds) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopSelectedGameId$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<Integer> $selectedGameIds;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$selectedGameIds = selectedGameIds;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) selectedGameIds);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                req.filter.selectedGameId = 1;
                req.modifyInfo.selectedGameId = this.$selectedGameIds;
            }
        }, null, 72, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyTroopShutUpTime(@Nullable String troopUin, final long timestamp, @Nullable LifecycleOwner owner, @Nullable e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, troopUin, Long.valueOf(timestamp), owner, callback);
            return;
        }
        QLog.i(TAG, 1, "[modifyTroopShutUpTime] troopUin:" + troopUin + ", timestamp:" + timestamp);
        modifyGroupDetailInfo$default(this, troopUin, owner, "shutUp", 0, callback, new Function1<GroupModifyInfoReq, Unit>(timestamp) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyTroopShutUpTime$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $timestamp;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$timestamp = timestamp;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, timestamp);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfoReq groupModifyInfoReq) {
                invoke2(groupModifyInfoReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupModifyInfoReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(req, "req");
                req.filter.shutUpTime = 1;
                req.modifyInfo.shutUpTime = (int) this.$timestamp;
            }
        }, null, 72, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyUploadTroopAlbum(@Nullable LifecycleOwner owner, @Nullable String groupCode, final boolean allowUpload, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, owner, groupCode, Boolean.valueOf(allowUpload), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            modifyGroupDetailInfoV2Privilege(new Function1<GroupModifyInfo, Unit>(allowUpload) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyUploadTroopAlbum$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $allowUpload;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$allowUpload = allowUpload;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, allowUpload);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfo groupModifyInfo) {
                    invoke2(groupModifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GroupModifyInfo it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.appPrivilegeFlag = !this.$allowUpload ? 1 : 0;
                    it.appPrivilegeMask = 1;
                }
            }, owner, groupCode, callback, "modifyUploadTroopAlbum");
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void modifyUploadTroopFile(@Nullable LifecycleOwner owner, @Nullable String groupCode, final boolean allowUpload, @NotNull e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, owner, groupCode, Boolean.valueOf(allowUpload), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            modifyGroupDetailInfoV2Privilege(new Function1<GroupModifyInfo, Unit>(allowUpload) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$modifyUploadTroopFile$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $allowUpload;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$allowUpload = allowUpload;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, allowUpload);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GroupModifyInfo groupModifyInfo) {
                    invoke2(groupModifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GroupModifyInfo it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.appPrivilegeFlag = this.$allowUpload ? 0 : 2;
                    it.appPrivilegeMask = 2;
                }
            }, owner, groupCode, callback, "modifyUploadTroopFile");
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void quitGroup(@Nullable String groupCode, boolean holdMsg, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, groupCode, Boolean.valueOf(holdMsg), owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            quitOrDestroyTroop(groupCode, holdMsg, false, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setAdminCanRcvJoinMsg(@Nullable String troopUin, @Nullable String adminUin, boolean can, @Nullable LifecycleOwner owner, @NotNull e callback) {
        Long l3;
        ArrayList<Long> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, troopUin, adminUin, Boolean.valueOf(can), owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        Long l16 = null;
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (adminUin != null) {
            l16 = StringsKt__StringNumberConversionsKt.toLongOrNull(adminUin);
        }
        if (l3 != null && adminUin != null) {
            RcvJoinVerifyMsgReq rcvJoinVerifyMsgReq = new RcvJoinVerifyMsgReq();
            rcvJoinVerifyMsgReq.groupCode = l3.longValue();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(l16);
            rcvJoinVerifyMsgReq.rptAdminUin = arrayListOf;
            rcvJoinVerifyMsgReq.operate = can ? 1 : 0;
            rcvJoinVerifyMsgReq.authority = 1;
            final int h16 = getTroopOperationCallbackStore().h(owner, callback);
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setRcvJoinVerifyMsg", troopUin, TAG, false, true, 8, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.setRcvJoinVerifyMsg(rcvJoinVerifyMsgReq, new IRcvJoinVerifyMsgCallback() { // from class: com.tencent.qqnt.troop.cm
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IRcvJoinVerifyMsgCallback
                    public final void onResult(int i3, String str, RcvJoinVerifyMsgRsp rcvJoinVerifyMsgRsp) {
                        TroopOperationRepo.setAdminCanRcvJoinMsg$lambda$106(com.tencent.qqnt.report.m.this, h16, i3, str, rcvJoinVerifyMsgRsp);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[setAdminCanRcvJoinMsg] troopUin:" + troopUin + ", adminUin:" + adminUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setGroupMsgMask(@Nullable final String troopUin, @NotNull final GroupMsgMask mask, @Nullable LifecycleOwner owner, @Nullable e callback) {
        Long l3;
        String currentUid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, troopUin, mask, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(mask, "mask");
        String str = "";
        final String o16 = com.tencent.qqnt.e.o("", callback);
        QLog.i(TAG, 1, "[setGroupMsgMask] troopUin:" + troopUin + ", flag:" + mask + ", uniqueFrom:" + o16);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (com.tencent.qqnt.e.c() != null && l3 != null) {
            SetGroupMsgMaskReq setGroupMsgMaskReq = new SetGroupMsgMaskReq();
            ArrayList<GroupMsgMaskReqInfo> arrayList = setGroupMsgMaskReq.rptMsgReqGroupInfo;
            GroupMsgMaskReqInfo groupMsgMaskReqInfo = new GroupMsgMaskReqInfo();
            groupMsgMaskReqInfo.groupCode = l3.longValue();
            groupMsgMaskReqInfo.clientType = 1;
            groupMsgMaskReqInfo.option = 1;
            ArrayList<GroupMsgMaskMemberInfo> arrayList2 = groupMsgMaskReqInfo.rptMsgMemberInfo;
            GroupMsgMaskMemberInfo groupMsgMaskMemberInfo = new GroupMsgMaskMemberInfo();
            AppRuntime f16 = com.tencent.mobileqq.troop.utils.bg.f();
            if (f16 != null && (currentUid = f16.getCurrentUid()) != null) {
                str = currentUid;
            }
            groupMsgMaskMemberInfo.memberUid = str;
            groupMsgMaskMemberInfo.groupMsgMask = mask.ordinal();
            arrayList2.add(groupMsgMaskMemberInfo);
            arrayList.add(groupMsgMaskReqInfo);
            final int h16 = getTroopOperationCallbackStore().h(owner, callback);
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setGroupMsgMaskV2_1", troopUin, TAG, false, true, 8, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.setGroupMsgMaskV2(setGroupMsgMaskReq, 1, new ISetGroupMsgMaskCallback() { // from class: com.tencent.qqnt.troop.ce
                    @Override // com.tencent.qqnt.kernel.nativeinterface.ISetGroupMsgMaskCallback
                    public final void onResult(int i3, String str2, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
                        TroopOperationRepo.setGroupMsgMask$lambda$66(com.tencent.qqnt.report.m.this, o16, troopUin, h16, mask, i3, str2, setGroupMsgMaskRsp);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[setGroupMsgMask] illegal params");
        if (callback != null) {
            callback.onResult(false, -1, "illegal params");
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setGroupMsgMaskV2_0(@Nullable final String troopUin, @Nullable final String memberUid, final int cmd, int mask, @Nullable LifecycleOwner owner, @Nullable i asyncCallback) {
        Long l3;
        long longValue;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, memberUid, Integer.valueOf(cmd), Integer.valueOf(mask), owner, asyncCallback);
            return;
        }
        String o16 = com.tencent.qqnt.e.o("", asyncCallback);
        QLog.i(TAG, 1, "[setGroupMsgMaskV2_0] troopUin:" + troopUin + ",memberUid:" + memberUid + ",cmd:" + cmd + ",mask:" + mask + ",uniqueFrom:" + o16);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (com.tencent.qqnt.e.c() != null && l3 != null) {
            if (cmd != 0) {
                if (cmd == 1) {
                    send0xA80ReqTimeMap.remove(troopUin);
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                ConcurrentHashMap<String, Long> concurrentHashMap = send0xA80ReqTimeMap;
                if (concurrentHashMap.containsKey(troopUin)) {
                    Long l16 = concurrentHashMap.get(troopUin);
                    if (l16 == null) {
                        longValue = 0;
                    } else {
                        longValue = l16.longValue();
                    }
                    if (currentTimeMillis - longValue < 15000) {
                        QLog.i(TAG, 1, "[setGroupMsgMaskV2_0] less 15s");
                        return;
                    }
                }
                concurrentHashMap.put(troopUin, Long.valueOf(currentTimeMillis));
            }
            SetGroupMsgMaskReq setGroupMsgMaskReq = new SetGroupMsgMaskReq();
            ArrayList<GroupMsgMaskReqInfo> arrayList = setGroupMsgMaskReq.rptMsgReqGroupInfo;
            GroupMsgMaskReqInfo groupMsgMaskReqInfo = new GroupMsgMaskReqInfo();
            groupMsgMaskReqInfo.groupCode = l3.longValue();
            groupMsgMaskReqInfo.option = cmd;
            ArrayList<GroupMsgMaskMemberInfo> arrayList2 = groupMsgMaskReqInfo.rptMsgMemberInfo;
            GroupMsgMaskMemberInfo groupMsgMaskMemberInfo = new GroupMsgMaskMemberInfo();
            groupMsgMaskMemberInfo.memberUid = memberUid;
            if (mask == 0) {
                str = o16;
                groupMsgMaskMemberInfo.heartbeatTime = (int) (System.currentTimeMillis() / 1000);
            } else {
                str = o16;
                groupMsgMaskMemberInfo.groupMsgMask = mask;
            }
            arrayList2.add(groupMsgMaskMemberInfo);
            arrayList.add(groupMsgMaskReqInfo);
            final int h16 = getTroopOperationCallbackStore().h(owner, asyncCallback);
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setGroupMsgMaskV2_0", troopUin, TAG, false, true, 8, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                final String str2 = str;
                c16.setGroupMsgMaskV2(setGroupMsgMaskReq, 0, new ISetGroupMsgMaskCallback() { // from class: com.tencent.qqnt.troop.cw
                    @Override // com.tencent.qqnt.kernel.nativeinterface.ISetGroupMsgMaskCallback
                    public final void onResult(int i3, String str3, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
                        TroopOperationRepo.setGroupMsgMaskV2_0$lambda$49(com.tencent.qqnt.report.m.this, str2, h16, troopUin, memberUid, cmd, i3, str3, setGroupMsgMaskRsp);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[setGroupMsgMaskV2_0] illegal params");
        onIllegalParams(asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setGroupMsgMaskV2_4(@Nullable final String troopUin, @Nullable final String memberUid, final int op5, final int type, int time, @Nullable LifecycleOwner owner, @Nullable i asyncCallback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, troopUin, memberUid, Integer.valueOf(op5), Integer.valueOf(type), Integer.valueOf(time), owner, asyncCallback);
            return;
        }
        final String o16 = com.tencent.qqnt.e.o("", asyncCallback);
        QLog.i(TAG, 1, "[setGroupMsgMaskV2_4] troopUin:" + troopUin + ",memberUid:" + memberUid + ",op:" + op5 + ",type:" + type + ",time:" + time + ",uniqueFrom:" + o16);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (com.tencent.qqnt.e.c() != null && l3 != null) {
            SetGroupMsgMaskReq setGroupMsgMaskReq = new SetGroupMsgMaskReq();
            ArrayList<GroupMsgMaskReqInfo> arrayList = setGroupMsgMaskReq.rptMsgReqGroupInfo;
            GroupMsgMaskReqInfo groupMsgMaskReqInfo = new GroupMsgMaskReqInfo();
            groupMsgMaskReqInfo.groupCode = l3.longValue();
            groupMsgMaskReqInfo.option = op5;
            groupMsgMaskReqInfo.clientType = 1;
            ArrayList<GroupMsgMaskMemberInfo> arrayList2 = groupMsgMaskReqInfo.rptMsgMemberInfo;
            GroupMsgMaskMemberInfo groupMsgMaskMemberInfo = new GroupMsgMaskMemberInfo();
            groupMsgMaskMemberInfo.memberUid = memberUid;
            if (type != 9) {
                if (type != 512) {
                    if (type != 1024) {
                        if (type != 2048) {
                            if (type == 4096) {
                                groupMsgMaskMemberInfo.groupVibrateSwitch = time;
                            }
                        } else {
                            groupMsgMaskMemberInfo.groupRingtoneSwitch = time;
                        }
                    } else {
                        groupMsgMaskMemberInfo.groupMsgPreviewSwitch = time;
                    }
                } else {
                    groupMsgMaskMemberInfo.groupMsgHideSwitch = time;
                }
            } else {
                groupMsgMaskMemberInfo.groupRingtoneId = time;
            }
            arrayList2.add(groupMsgMaskMemberInfo);
            arrayList.add(groupMsgMaskReqInfo);
            final int h16 = getTroopOperationCallbackStore().h(owner, asyncCallback);
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setGroupMsgMaskV2_4", troopUin, TAG, false, true, 8, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.setGroupMsgMaskV2(setGroupMsgMaskReq, 4, new ISetGroupMsgMaskCallback() { // from class: com.tencent.qqnt.troop.ca
                    @Override // com.tencent.qqnt.kernel.nativeinterface.ISetGroupMsgMaskCallback
                    public final void onResult(int i3, String str, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
                        TroopOperationRepo.setGroupMsgMaskV2_4$lambda$57(com.tencent.qqnt.report.m.this, o16, type, troopUin, h16, memberUid, op5, i3, str, setGroupMsgMaskRsp);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[setGroupMsgMaskV2_4] illegal params");
        onIllegalParams(asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void setTroopIsActive(@Nullable final String troopUin, @Nullable LifecycleOwner owner, @NotNull final String from, @Nullable e callback) {
        Long l3;
        long j3;
        String currentUin;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, troopUin, owner, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i(TAG, 1, "[setTroopIsActive] from:" + from + ", troopUin:" + troopUin);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null) {
            l3.longValue();
            final int h16 = getTroopOperationCallbackStore().h(owner, callback);
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setActiveExtGroup", troopUin, "TroopOperationRepo-" + from, false, true, 8, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                ActiveExtGroupReq activeExtGroupReq = new ActiveExtGroupReq();
                AppRuntime f16 = com.tencent.mobileqq.troop.utils.bg.f();
                if (f16 != null && (currentUin = f16.getCurrentUin()) != null) {
                    Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(currentUin);
                    if (longOrNull != null) {
                        j3 = longOrNull.longValue();
                        activeExtGroupReq.uin = j3;
                        ArrayList<ActiveGroupInfo> arrayList = activeExtGroupReq.rptMsgGroupInfo;
                        ActiveGroupInfo activeGroupInfo = new ActiveGroupInfo();
                        activeGroupInfo.groupUin = l3.longValue();
                        arrayList.add(activeGroupInfo);
                        c16.setActiveExtGroup(activeExtGroupReq, new IOperateCallback() { // from class: com.tencent.qqnt.troop.cx
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                            public final void onResult(int i3, String str) {
                                TroopOperationRepo.setTroopIsActive$lambda$119(com.tencent.qqnt.report.m.this, from, h16, troopUin, i3, str);
                            }
                        });
                        return;
                    }
                }
                j3 = 0;
                activeExtGroupReq.uin = j3;
                ArrayList<ActiveGroupInfo> arrayList2 = activeExtGroupReq.rptMsgGroupInfo;
                ActiveGroupInfo activeGroupInfo2 = new ActiveGroupInfo();
                activeGroupInfo2.groupUin = l3.longValue();
                arrayList2.add(activeGroupInfo2);
                c16.setActiveExtGroup(activeExtGroupReq, new IOperateCallback() { // from class: com.tencent.qqnt.troop.cx
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        TroopOperationRepo.setTroopIsActive$lambda$119(com.tencent.qqnt.report.m.this, from, h16, troopUin, i3, str);
                    }
                });
                return;
            }
            return;
        }
        if (callback != null) {
            callback.onResult(false, -1, "");
        }
        QLog.e(TAG, 1, "[setTroopIsActive] from:" + from + ", troopUin illegal");
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void transferGroup(@Nullable final String groupCode, @Nullable final String oldOwnerUin, @Nullable final String oldOwnerUid, @Nullable final String newOwnerUin, @Nullable final String newOwnerUid, @Nullable LifecycleOwner owner, @NotNull final String from, @Nullable i asyncCallback) {
        Long l3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, groupCode, oldOwnerUin, oldOwnerUid, newOwnerUin, newOwnerUid, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        final String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
        QLog.i(TAG, 1, "[transferGroup] groupCode:" + groupCode + ", oldUid:" + oldOwnerUid + ", newUin:" + newOwnerUin + ", newUid:" + newOwnerUid + ", from:" + o16);
        if (groupCode != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(groupCode);
        } else {
            l3 = null;
        }
        final Long l16 = l3;
        if (com.tencent.qqnt.e.c() != null && l16 != null) {
            if (oldOwnerUid != null && oldOwnerUid.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (newOwnerUid == null || newOwnerUid.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    final int h16 = getTroopOperationCallbackStore().h(owner, asyncCallback);
                    final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("transferGroupV2", groupCode, "TroopOperationRepo-" + from, false, true, 8, null);
                    com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
                    if (c16 != null) {
                        c16.transferGroupV2(l16.longValue(), oldOwnerUid, newOwnerUid, new ITransferGroupCallback() { // from class: com.tencent.qqnt.troop.cj
                            @Override // com.tencent.qqnt.kernel.nativeinterface.ITransferGroupCallback
                            public final void onResult(int i3, String str, TransferGroupRsp transferGroupRsp) {
                                TroopOperationRepo.transferGroup$lambda$31(com.tencent.qqnt.report.m.this, groupCode, oldOwnerUin, from, newOwnerUin, l16, oldOwnerUid, newOwnerUid, o16, h16, i3, str, transferGroupRsp);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
        }
        QLog.e(TAG, 1, "[transferGroup] illegal params");
        onIllegalParams(asyncCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateAllowMemberInviteRobotSwitch(@Nullable String troopUin, int open, @NotNull e callback) {
        Long longOrNull;
        GroupExt groupExt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, troopUin, Integer.valueOf(open), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateAllowMemberInviteRobotSwitch: troopUin=" + troopUin + ", open=" + open);
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null) {
                groupExt = troopInfoFromCache.groupExt;
            } else {
                groupExt = null;
            }
            if (groupExt != null) {
                groupExt.inviteRobotMemberSwitch = open;
            }
            GroupExtInfo groupExtInfo = new GroupExtInfo();
            groupExtInfo.groupCode = longValue;
            groupExtInfo.extInfo.inviteRobotMemberSwitch = open;
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.inviteRobotMemberSwitch = 1;
            modifyGroupExtInfo(groupExtInfo, groupExtFilter, "updateAllowMemberInviteRobotSwitch", callback);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateAllowMemberModifyTroopName(@Nullable final String troopUin, final int open, @NotNull final e callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, troopUin, Integer.valueOf(open), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateAllowMemberModifyTroopName: troopUin=" + troopUin + ", open=" + open);
            }
            GroupExtInfo groupExtInfo = new GroupExtInfo();
            groupExtInfo.groupCode = longValue;
            groupExtInfo.extInfo.memberChangeGroupNameSwitch = open;
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.memberChangeGroupNameSwitch = 1;
            modifyGroupExtInfo(groupExtInfo, groupExtFilter, "updateAllowMemberModifyTroopName", new e() { // from class: com.tencent.qqnt.troop.bz
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z16, int i3, String str) {
                    TroopOperationRepo.updateAllowMemberModifyTroopName$lambda$132(troopUin, open, callback, z16, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateAssociatePubAccount(@Nullable String troopUin, final long account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, troopUin, Long.valueOf(account));
            return;
        }
        updateGroupInfo(troopUin, "PubAccount=" + account, new Function2<String, GroupInfoCacheReq, Unit>(account) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$updateAssociatePubAccount$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $account;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$account = account;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, account);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupInfoCacheReq groupInfoCacheReq) {
                invoke2(str, groupInfoCacheReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopCode, @NotNull GroupInfoCacheReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopCode, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopCode, "troopCode");
                Intrinsics.checkNotNullParameter(req, "req");
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopCode);
                if (troopInfoFromCache != null) {
                    troopInfoFromCache.associatePubAccount = this.$account;
                }
                GroupDetailInfo groupDetailInfo = req.detailInfo;
                groupDetailInfo.subscriptionUin = troopInfoFromCache != null ? troopInfoFromCache.associatePubAccount : 0L;
                groupDetailInfo.subscriptionUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(req.detailInfo.subscriptionUin));
                GroupInfoCacheFilter groupInfoCacheFilter = req.filter;
                groupInfoCacheFilter.subscriptionUin = true;
                groupInfoCacheFilter.subscriptionUid = true;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateFullGroupExpansionSwitch(@Nullable String troopUin, int value) {
        Long longOrNull;
        GroupExt groupExt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) troopUin, value);
            return;
        }
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateFullGroupExpansionSwitch: troopUin=" + troopUin + ", value=" + value);
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null) {
                groupExt = troopInfoFromCache.groupExt;
            } else {
                groupExt = null;
            }
            if (groupExt != null) {
                groupExt.fullGroupExpansionSwitch = value;
            }
            GroupExtInfo groupExtInfo = new GroupExtInfo();
            groupExtInfo.groupCode = longValue;
            groupExtInfo.extInfo.fullGroupExpansionSwitch = value;
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.fullGroupExpansionSwitch = 1;
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.modifyGroupExtInfoV2(groupExtInfo, groupExtFilter, null);
            }
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateGameCardSwitch(@NotNull String troopUin, final long cmduinFlagEx3Grocery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, troopUin, Long.valueOf(cmduinFlagEx3Grocery));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        updateGroupInfo(troopUin, "GameCardSwitch=" + cmduinFlagEx3Grocery, new Function2<String, GroupInfoCacheReq, Unit>(cmduinFlagEx3Grocery) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$updateGameCardSwitch$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $cmduinFlagEx3Grocery;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$cmduinFlagEx3Grocery = cmduinFlagEx3Grocery;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, cmduinFlagEx3Grocery);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupInfoCacheReq groupInfoCacheReq) {
                invoke2(str, groupInfoCacheReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopCode, @NotNull GroupInfoCacheReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopCode, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopCode, "troopCode");
                Intrinsics.checkNotNullParameter(req, "req");
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopCode);
                if (troopInfoFromCache != null) {
                    troopInfoFromCache.cmduinFlagEx3Grocery = this.$cmduinFlagEx3Grocery;
                }
                req.detailInfo.cmdUinFlagExt3Grocery = troopInfoFromCache != null ? (int) troopInfoFromCache.cmduinFlagEx3Grocery : 0;
                req.filter.cmdUinFlagExt3Grocery = true;
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateHonorAIOSwitch(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, troopUin, Boolean.valueOf(open));
        } else {
            updateFlagExt3(troopUin, "HonorAIOSwitch", 33554432, !open);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateInviteRobotSwitch(@Nullable String troopUin, int open, @NotNull e callback) {
        Long longOrNull;
        GroupExt groupExt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, troopUin, Integer.valueOf(open), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateInviteRobotSwitch: troopUin=" + troopUin + ", open=" + open);
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null) {
                groupExt = troopInfoFromCache.groupExt;
            } else {
                groupExt = null;
            }
            if (groupExt != null) {
                groupExt.inviteRobotSwitch = open;
            }
            GroupExtInfo groupExtInfo = new GroupExtInfo();
            groupExtInfo.groupCode = longValue;
            groupExtInfo.extInfo.inviteRobotSwitch = open;
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.inviteRobotSwitch = 1;
            modifyGroupExtInfo(groupExtInfo, groupExtFilter, "updateInviteRobotSwitch", callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateListenTogetherState(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, troopUin, Boolean.valueOf(open));
        } else {
            updateFlagExt3(troopUin, "ListenTogetherState", 2097152, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateLuckyCharFlag(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, troopUin, Boolean.valueOf(open));
        } else {
            updateFlagExt4(troopUin, "LuckyCharFlag", 32768, !open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateNewTroopState(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) troopUin);
        } else {
            updateGroupInfo(troopUin, "updateNewTroopState", TroopOperationRepo$updateNewTroopState$1.INSTANCE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateRobotMemberExamine(@Nullable String troopUin, int open, @NotNull e callback) {
        Long longOrNull;
        GroupExt groupExt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, troopUin, Integer.valueOf(open), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateRobotMemberExamine: troopUin=" + troopUin + ", open=" + open);
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null) {
                groupExt = troopInfoFromCache.groupExt;
            } else {
                groupExt = null;
            }
            if (groupExt != null) {
                groupExt.inviteRobotMemberExamine = open;
            }
            GroupExtInfo groupExtInfo = new GroupExtInfo();
            groupExtInfo.groupCode = longValue;
            groupExtInfo.extInfo.inviteRobotMemberExamine = open;
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.inviteRobotMemberExamine = 1;
            modifyGroupExtInfo(groupExtInfo, groupExtFilter, "updateRobotMemberExamine", callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateShareLocationState(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, troopUin, Boolean.valueOf(open));
        } else {
            updateFlagExt3(troopUin, "ShareLocationState", 67108864, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTogetherBusinessFlag(@Nullable String troopUin, boolean open, int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, troopUin, Boolean.valueOf(open), Integer.valueOf(flag));
        } else {
            updateFlagExt3(troopUin, "TogetherBusinessFlag", flag, open);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopAIOGuildId(@Nullable String troopUin, final long aioGuildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, troopUin, Long.valueOf(aioGuildId));
            return;
        }
        updateGroupInfo(troopUin, "groupAioBindGuildId=" + aioGuildId, new Function2<String, GroupInfoCacheReq, Unit>(aioGuildId) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$updateTroopAIOGuildId$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $aioGuildId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$aioGuildId = aioGuildId;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, aioGuildId);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupInfoCacheReq groupInfoCacheReq) {
                invoke2(str, groupInfoCacheReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopCode, @NotNull GroupInfoCacheReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopCode, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopCode, "troopCode");
                Intrinsics.checkNotNullParameter(req, "req");
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopCode);
                GroupExt groupExt = troopInfoFromCache != null ? troopInfoFromCache.groupExt : null;
                if (groupExt != null) {
                    groupExt.groupAioBindGuildId = this.$aioGuildId;
                }
                req.detailInfo.groupExt.groupAioBindGuildId = this.$aioGuildId;
                req.filter.extFilter.groupAioBindGuildId = true;
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopAutoApproval(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, troopUin, Boolean.valueOf(open));
        } else {
            updateFlagExt3(troopUin, "AutoApproval", 1048576, open);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateTroopEssencePrivilege(@Nullable String troopUin, int essentialMsgPrivilege, @NotNull e callback) {
        Long longOrNull;
        GroupExt groupExt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, troopUin, Integer.valueOf(essentialMsgPrivilege), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateTroopEssencePrivilege: troopUin=" + troopUin + ", essentialMsgPrivilege=" + essentialMsgPrivilege);
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null) {
                groupExt = troopInfoFromCache.groupExt;
            } else {
                groupExt = null;
            }
            if (groupExt != null) {
                groupExt.essentialMsgPrivilege = essentialMsgPrivilege;
            }
            GroupExtInfo groupExtInfo = new GroupExtInfo();
            groupExtInfo.groupCode = longValue;
            groupExtInfo.extInfo.essentialMsgPrivilege = essentialMsgPrivilege;
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.essentialMsgPrivilege = 1;
            modifyGroupExtInfo(groupExtInfo, groupExtFilter, "EssencePrivilege", callback);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateTroopEssenceSwitch(@Nullable String troopUin, int essenceSwitch, @NotNull e callback) {
        Long longOrNull;
        GroupExt groupExt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, troopUin, Integer.valueOf(essenceSwitch), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateTroopEssenceSwitch: troopUin=" + troopUin + ", essenceSwitch=" + essenceSwitch);
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null) {
                groupExt = troopInfoFromCache.groupExt;
            } else {
                groupExt = null;
            }
            if (groupExt != null) {
                groupExt.essentialMsgSwitch = essenceSwitch;
            }
            GroupExtInfo groupExtInfo = new GroupExtInfo();
            groupExtInfo.groupCode = longValue;
            groupExtInfo.extInfo.essentialMsgSwitch = essenceSwitch;
            GroupExtFilter groupExtFilter = new GroupExtFilter();
            groupExtFilter.essentialMsgSwitch = 1;
            modifyGroupExtInfo(groupExtInfo, groupExtFilter, "EssenceSwitch", callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopGuildId(@Nullable String troopUin, final long guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, troopUin, Long.valueOf(guildId));
            return;
        }
        updateGroupInfo(troopUin, "bindGuildId=" + guildId, new Function2<String, GroupInfoCacheReq, Unit>(guildId) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$updateTroopGuildId$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $guildId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$guildId = guildId;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, guildId);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupInfoCacheReq groupInfoCacheReq) {
                invoke2(str, groupInfoCacheReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopCode, @NotNull GroupInfoCacheReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopCode, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopCode, "troopCode");
                Intrinsics.checkNotNullParameter(req, "req");
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopCode);
                GroupExt groupExt = troopInfoFromCache != null ? troopInfoFromCache.groupExt : null;
                if (groupExt != null) {
                    groupExt.bindGuildId = this.$guildId;
                }
                req.detailInfo.groupExt.bindGuildId = this.$guildId;
                req.filter.extFilter.bindGuildId = true;
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateTroopLive(@Nullable String troopUin, boolean isLive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, troopUin, Boolean.valueOf(isLive));
        } else {
            updateFlagExt4(troopUin, "isLive", 1024, isLive);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateUseClassAvatar(@Nullable String troopUin, final boolean use) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, troopUin, Boolean.valueOf(use));
            return;
        }
        updateGroupInfo(troopUin, "UseClassAvatar=" + use, new Function2<String, GroupInfoCacheReq, Unit>(use) { // from class: com.tencent.qqnt.troop.TroopOperationRepo$updateUseClassAvatar$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $use;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$use = use;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, use);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupInfoCacheReq groupInfoCacheReq) {
                invoke2(str, groupInfoCacheReq);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopCode, @NotNull GroupInfoCacheReq req) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopCode, (Object) req);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopCode, "troopCode");
                Intrinsics.checkNotNullParameter(req, "req");
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopCode);
                if (troopInfoFromCache != null) {
                    if (this.$use) {
                        troopInfoFromCache.dwGroupFlagExt |= 131072;
                    } else {
                        troopInfoFromCache.dwGroupFlagExt &= -131073;
                    }
                    req.detailInfo.groupFlagExt = (int) troopInfoFromCache.dwGroupFlagExt;
                }
                req.filter.groupFlagExt = true;
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopOperationRepoApi
    public void updateWatchTogetherState(@Nullable String troopUin, boolean open) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, troopUin, Boolean.valueOf(open));
        } else {
            updateFlagExt3(troopUin, "WatchTogetherState", 4194304, open);
        }
    }
}
