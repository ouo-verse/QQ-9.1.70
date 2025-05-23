package com.tencent.sqshow.zootopia.recommend.characterV2.controller;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZPlanModComponentHelper;
import com.tencent.mobileqq.zplan.api.IZPlanForceUpdateHelper;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.EngineLoadingScene;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarMallLoadingComponent;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarMallViewInitData;
import com.tencent.sqshow.zootopia.avatar.mall.k;
import com.tencent.sqshow.zootopia.data.ZootopiaFaceAdListData;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.d;
import com.tencent.sqshow.zootopia.nativeui.data.o;
import com.tencent.sqshow.zootopia.operation.ZplanOperationImpl;
import com.tencent.sqshow.zootopia.operation.facead.report.ZootopiaFaceAdReport;
import com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent;
import com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleMidComponent;
import com.tencent.sqshow.zootopia.recommend.characterV2.component.b;
import com.tencent.sqshow.zootopia.recommend.characterV2.component.c;
import com.tencent.sqshow.zootopia.recommend.characterV2.controller.b;
import com.tencent.sqshow.zootopia.recommend.characterV2.data.ZPlanRoleData;
import com.tencent.sqshow.zootopia.recommend.characterV2.data.ZPlanRoleRepo;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.EnterAvatarMallEvent;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.FaceAdDataEvent;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.NewBodyUpdateAgreeEvent;
import com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRoleMidTouchTap;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.m;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import m94.DressErrorMsg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import qv4.bh;
import qv4.bi;
import qv4.bj;
import qv4.bk;
import qv4.z;
import uv4.w;

@Metadata(d1 = {"\u0000\u00e6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 z2\u00020\u00012\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b:\u0002n`B)\u0012\b\u0010\u0082\u0001\u001a\u00030\u0080\u0001\u0012\b\u0010\u0085\u0001\u001a\u00030\u0083\u0001\u0012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u0001\u00a2\u0006\u0006\b\u00d8\u0001\u0010\u00d9\u0001J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u000bH\u0016J\b\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u000bH\u0016J\b\u0010+\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\tH\u0016J \u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0011H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J \u00109\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0014H\u0016J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020\u000bH\u0016J\b\u0010>\u001a\u00020\u000bH\u0016J\b\u0010?\u001a\u00020\u000bH\u0016J#\u0010C\u001a\u00020\u000b2\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0004\bC\u0010DJ \u0010E\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0014H\u0016J\b\u0010F\u001a\u00020\tH\u0016J\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0001H\u0016J\u0010\u0010H\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0003H\u0016J\b\u0010I\u001a\u00020\u000bH\u0016J \u0010J\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0014H\u0016J\b\u0010K\u001a\u00020\u000bH\u0016J\b\u0010L\u001a\u00020\u000bH\u0016J \u0010M\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0014H\u0016J\u0010\u0010O\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020NH\u0016J\u0010\u0010P\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020NH\u0016J\u0010\u0010R\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020QH\u0016J\u0010\u0010T\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\tH\u0016J \u0010Y\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\tH\u0016J\u0010\u0010\\\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020ZH\u0016J\u0018\u0010`\u001a\u00020\u000b2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010]H\u0016J\u000e\u0010c\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020aJ\b\u0010d\u001a\u00020\u000bH\u0016J\u0018\u0010g\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020U2\u0006\u0010f\u001a\u00020UH\u0016J\b\u0010h\u001a\u00020\u000bH\u0016J\u0012\u0010i\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010m\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050k0jj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050k`lH\u0016J\b\u0010n\u001a\u00020\tH\u0016J\n\u0010o\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00110pH\u0016J\b\u0010r\u001a\u00020\tH\u0016J\b\u0010s\u001a\u00020\tH\u0016J\b\u0010t\u001a\u00020\tH\u0016J\u0010\u0010v\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020\tH\u0016J\n\u0010x\u001a\u0004\u0018\u00010wH\u0016J\n\u0010z\u001a\u0004\u0018\u00010yH\u0016J\b\u0010{\u001a\u00020\tH\u0016J\n\u0010}\u001a\u0004\u0018\u00010|H\u0016J\n\u0010\u007f\u001a\u0004\u0018\u00010~H\u0016R\u0017\u0010\u0082\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bh\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bo\u0010\u0084\u0001R\u001a\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\"\u0010\u0091\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R0\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@BX\u0082\u000e\u00a2\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R;\u0010\u00a5\u0001\u001a\u000b\u0012\u0004\u0012\u00020a\u0018\u00010\u00a1\u00012\u0010\u0010\u009b\u0001\u001a\u000b\u0012\u0004\u0012\u00020a\u0018\u00010\u00a1\u00018\u0002@BX\u0082\u000e\u00a2\u0006\u000f\n\u0005\b{\u0010\u00a2\u0001\"\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u001c\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00aa\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001c\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001c\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00b2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001b\u0010\u00b8\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u001b\u0010\u00ba\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00b7\u0001R?\u0010\u00bf\u0001\u001a*\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010\u00010\u0001 \u00bc\u0001*\u0013\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010\u00010\u0001\u0018\u00010p0\u00bb\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R?\u0010\u00c1\u0001\u001a*\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010:0: \u00bc\u0001*\u0013\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010:0:\u0018\u00010p0\u00bb\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u00be\u0001R>\u0010\u00c2\u0001\u001a*\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010\u00030\u0003 \u00bc\u0001*\u0013\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010\u00030\u0003\u0018\u00010p0\u00bb\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bR\u0010\u00be\u0001R>\u0010\u00c3\u0001\u001a*\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010Q0Q \u00bc\u0001*\u0013\u0012\r\u0012\u000b \u00bc\u0001*\u0004\u0018\u00010Q0Q\u0018\u00010p0\u00bb\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bE\u0010\u00be\u0001R\u0017\u0010\u00c4\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010LR\u0017\u0010\u00c5\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010LR\u0017\u0010\u00c6\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010LR\u0017\u0010\u00c7\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010LR\u0017\u0010\u00c8\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010LR\u0017\u0010\u00c9\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010LR\u0017\u0010\u00ca\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010LR\u0019\u0010\u00cd\u0001\u001a\u00030\u00cb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b3\u0010\u00cc\u0001R\u0017\u0010\u00ce\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010LR \u0010\u00d3\u0001\u001a\u00030\u00cf\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\bL\u0010\u00d0\u0001\u001a\u0006\b\u00d1\u0001\u0010\u00d2\u0001R\u0018\u0010\u00d4\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bI\u0010\u00b3\u0001R\u0017\u0010\u00d7\u0001\u001a\u00030\u00d5\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bT\u0010\u00d6\u0001\u00a8\u0006\u00da\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", "Luk0/e;", "", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/b;", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "", "o0", "", "H0", "N0", "J0", "V", "U", "", "viewportType", "W0", "Landroid/view/ViewGroup;", "e0", "rootLayout", "k0", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/event/FaceAdDataEvent;", "event", "i0", "j0", "g0", "O", "M0", "I0", "F0", "Landroid/content/Intent;", "intent", "z0", "v0", "C0", "onResume", "A0", DKHippyEvent.EVENT_STOP, "w0", "B0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "hidden", "y0", "Landroid/content/res/Configuration;", "newConfig", "fullViewWidth", "fullViewHeight", "u0", "X", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", ParseCommon.CONTAINER, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lya4/a;", "listener", "P0", "U0", "m0", "p0", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "nativeAppId", "W", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/Integer;)V", "P", "V0", "O0", "Q0", "a0", ExifInterface.LATITUDE_SOUTH, "r0", "Z", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "qg", ICustomDataEditor.STRING_PARAM_2, "Lcom/tencent/sqshow/zootopia/avatar/mall/k;", "N", "withAnim", "b0", "", "from", "withoutBlend", "withDelay", "Ya", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "observer", "q0", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/z;", "callback", "b", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/a;", "bannerData", "t0", "E0", "type", "eventData", "onEvent", "d", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "a", "e", "", "c", "T", "s0", "n0", "select", "R0", "Lb94/a;", "d0", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "c0", "E", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "Y", "Lqu4/a;", "x0", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2;", "roleFragment", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "f", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/sqshow/zootopia/avatar/a;", tl.h.F, "Lcom/tencent/sqshow/zootopia/avatar/a;", "sceneInfoParser", "Ldw4/b;", "i", "Lcom/tencent/mobileqq/zootopia/api/e;", "avatarDressInfoCallback", "Lza4/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lza4/a;", "avatarInitDataController", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/ZPlanRoleRepo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/ZPlanRoleRepo;", "roleRepo", "Lqv4/bk;", "value", "D", "Lqv4/bk;", "T0", "(Lqv4/bk;)V", "titleData", "", "Ljava/util/List;", "S0", "(Ljava/util/List;)V", "titleBannerDataList", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleAvatarComponent;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleAvatarComponent;", "avatarComponent", "Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarMallLoadingComponent;", "G", "Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarMallLoadingComponent;", "loadingComponent", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent;", "H", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent;", "midComponent", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/f;", "I", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/f;", "mallComponent", "J", "Landroid/view/ViewGroup;", "avatarContainer", "K", "midContainer", "", "kotlin.jvm.PlatformType", "L", "Ljava/util/Set;", "engineListenerSet", "M", "loadingListenerSet", "sceneRenderListenerSet", "avatarMallNativeUIListenerSet", "isLoading", "isHiddenState", "isResumedState", "isNativeUIShow", "isTabSelected", "isAvatarCharacterChanged", "hasHandleFaceAd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReceivedFirstFrame", "needUpdateBannerInfos", "Lcom/tencent/sqshow/zootopia/operation/ZplanOperationImpl;", "Lkotlin/Lazy;", "f0", "()Lcom/tencent/sqshow/zootopia/operation/ZplanOperationImpl;", "zplanOperationApi", "tianshuAdId", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$a;", "zplanRequestObserver", "<init>", "(Lcom/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoleControllerV2 implements uk0.e, com.tencent.sqshow.zootopia.avatar.filament.h, SimpleEventReceiver<SimpleBaseEvent>, com.tencent.sqshow.zootopia.recommend.characterV2.controller.a, b, com.tencent.sqshow.zootopia.nativeui.data.d {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZPlanRoleRepo roleRepo;

    /* renamed from: D, reason: from kotlin metadata */
    private bk titleData;

    /* renamed from: E, reason: from kotlin metadata */
    private List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> titleBannerDataList;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanRoleAvatarComponent avatarComponent;

    /* renamed from: G, reason: from kotlin metadata */
    private AvatarMallLoadingComponent loadingComponent;

    /* renamed from: H, reason: from kotlin metadata */
    private ZPlanRoleMidComponent midComponent;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.recommend.characterV2.component.f mallComponent;

    /* renamed from: J, reason: from kotlin metadata */
    private ViewGroup avatarContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private ViewGroup midContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private final Set<uk0.e> engineListenerSet;

    /* renamed from: M, reason: from kotlin metadata */
    private final Set<ya4.a> loadingListenerSet;

    /* renamed from: N, reason: from kotlin metadata */
    private final Set<com.tencent.sqshow.zootopia.avatar.filament.h> sceneRenderListenerSet;

    /* renamed from: P, reason: from kotlin metadata */
    private final Set<k> avatarMallNativeUIListenerSet;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isHiddenState;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isResumedState;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isNativeUIShow;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isTabSelected;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isAvatarCharacterChanged;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean hasHandleFaceAd;

    /* renamed from: X, reason: from kotlin metadata */
    private AtomicBoolean hasReceivedFirstFrame;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean needUpdateBannerInfos;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Lazy zplanOperationApi;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int tianshuAdId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final a zplanRequestObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanRoleFragmentV2 roleFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Bundle arguments;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.avatar.a sceneInfoParser;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.api.e<dw4.b> avatarDressInfoCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private za4.a avatarInitDataController;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$d", "Lcom/tencent/sqshow/zootopia/avatar/mall/k;", "", "ma", "I7", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements k {
        d() {
        }

        @Override // com.tencent.sqshow.zootopia.avatar.mall.k
        public void I7() {
            ZPlanRoleControllerV2.this.isNativeUIShow = false;
            ZPlanRoleMidComponent zPlanRoleMidComponent = ZPlanRoleControllerV2.this.midComponent;
            if (zPlanRoleMidComponent != null) {
                c.a.b(zPlanRoleMidComponent, true, null, 2, null);
            }
            Set avatarMallNativeUIListenerSet = ZPlanRoleControllerV2.this.avatarMallNativeUIListenerSet;
            Intrinsics.checkNotNullExpressionValue(avatarMallNativeUIListenerSet, "avatarMallNativeUIListenerSet");
            Iterator it = avatarMallNativeUIListenerSet.iterator();
            while (it.hasNext()) {
                ((k) it.next()).I7();
            }
            if (ZPlanRoleControllerV2.this.avatarContainer instanceof ZPlanRoleMidTouchTap) {
                ViewGroup viewGroup = ZPlanRoleControllerV2.this.avatarContainer;
                Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRoleMidTouchTap");
                ((ZPlanRoleMidTouchTap) viewGroup).b();
            }
        }

        @Override // com.tencent.sqshow.zootopia.avatar.mall.k
        public void ma() {
            ZPlanRoleControllerV2.this.isNativeUIShow = true;
            ZPlanRoleMidComponent zPlanRoleMidComponent = ZPlanRoleControllerV2.this.midComponent;
            if (zPlanRoleMidComponent != null) {
                c.a.a(zPlanRoleMidComponent, true, null, 2, null);
            }
            Set avatarMallNativeUIListenerSet = ZPlanRoleControllerV2.this.avatarMallNativeUIListenerSet;
            Intrinsics.checkNotNullExpressionValue(avatarMallNativeUIListenerSet, "avatarMallNativeUIListenerSet");
            Iterator it = avatarMallNativeUIListenerSet.iterator();
            while (it.hasNext()) {
                ((k) it.next()).ma();
            }
            if (ZPlanRoleControllerV2.this.avatarContainer instanceof ZPlanRoleMidTouchTap) {
                ViewGroup viewGroup = ZPlanRoleControllerV2.this.avatarContainer;
                Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRoleMidTouchTap");
                ((ZPlanRoleMidTouchTap) viewGroup).a();
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<w> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f372446e;

        e(f fVar) {
            this.f372446e = fVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(w result) {
            Intrinsics.checkNotNullParameter(result, "result");
            com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = ZPlanRoleControllerV2.this.mallComponent;
            if (fVar != null) {
                fVar.r1(this.f372446e, true);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            com.tencent.sqshow.zootopia.operation.facead.d.INSTANCE.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$f", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements m94.h {
        f() {
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            com.tencent.sqshow.zootopia.operation.facead.d.INSTANCE.a();
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            com.tencent.sqshow.zootopia.operation.facead.d.INSTANCE.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$g", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "onGetAdvs", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements TianShuGetAdvCallback {
        g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0121 A[SYNTHETIC] */
        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onGetAdvs(boolean result, TianShuAccess.GetAdsRsp getAdsRsp) {
            List<TianShuAccess.RspEntry> list;
            TianShuAccess.AdPlacementInfo adPlacementInfo;
            PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
            List<TianShuAccess.AdItem> list2;
            long j3;
            String str;
            String str2;
            Long longOrNull;
            Long longOrNull2;
            List<TianShuAccess.MapEntry> list3;
            List emptyList;
            List emptyList2;
            if (!result) {
                QLog.e("portal_ZPlanRoleControllerV2", 1, "requestBannerData failed. result: false");
                ZPlanRoleControllerV2 zPlanRoleControllerV2 = ZPlanRoleControllerV2.this;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                zPlanRoleControllerV2.S0(emptyList2);
                return;
            }
            if (getAdsRsp == null) {
                QLog.e("portal_ZPlanRoleControllerV2", 1, "requestBannerData failed. result: true, getAdsRsp: null");
                ZPlanRoleControllerV2 zPlanRoleControllerV22 = ZPlanRoleControllerV2.this;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                zPlanRoleControllerV22.S0(emptyList);
                return;
            }
            ArrayList arrayList = new ArrayList();
            PBRepeatMessageField<TianShuAccess.RspEntry> pBRepeatMessageField2 = getAdsRsp.mapAds;
            if (pBRepeatMessageField2 != null && (list = pBRepeatMessageField2.get()) != null) {
                for (TianShuAccess.RspEntry rspEntry : list) {
                    if (rspEntry.key.get() == 1380 && (adPlacementInfo = rspEntry.value.get()) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null && (list2 = pBRepeatMessageField.get()) != null) {
                        Intrinsics.checkNotNullExpressionValue(list2, "get()");
                        for (TianShuAccess.AdItem adItem : list2) {
                            HashMap hashMap = new HashMap();
                            PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField3 = adItem.argList;
                            if (pBRepeatMessageField3 != null && (list3 = pBRepeatMessageField3.get()) != null) {
                                Intrinsics.checkNotNullExpressionValue(list3, "get()");
                                for (TianShuAccess.MapEntry mapEntry : list3) {
                                    String str3 = mapEntry.key.get();
                                    Intrinsics.checkNotNullExpressionValue(str3, "it.key.get()");
                                    String str4 = mapEntry.value.get();
                                    Intrinsics.checkNotNullExpressionValue(str4, "it.value.get()");
                                    hashMap.put(str3, str4);
                                }
                            }
                            bh bhVar = new bh();
                            String str5 = (String) hashMap.get("id");
                            long j16 = 0;
                            if (str5 != null) {
                                Intrinsics.checkNotNullExpressionValue(str5, "adArgMap[\"id\"]");
                                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(str5);
                                if (longOrNull2 != null) {
                                    j3 = longOrNull2.longValue();
                                    bhVar.f430061a = j3;
                                    str = (String) hashMap.get("pic");
                                    if (str == null) {
                                        str = "";
                                    }
                                    bhVar.f430063c = str;
                                    String str6 = (String) hashMap.get("jump_url");
                                    bhVar.f430064d = str6 != null ? str6 : "";
                                    str2 = (String) hashMap.get("sort_id");
                                    if (str2 == null) {
                                        Intrinsics.checkNotNullExpressionValue(str2, "adArgMap[\"sort_id\"]");
                                        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
                                        if (longOrNull != null) {
                                            j16 = longOrNull.longValue();
                                        }
                                    }
                                    bhVar.f430065e = j16;
                                    int i3 = adItem.iAdId.get();
                                    String str7 = adItem.traceinfo.get();
                                    Intrinsics.checkNotNullExpressionValue(str7, "adItem.traceinfo.get()");
                                    arrayList.add(new com.tencent.sqshow.zootopia.recommend.characterV2.data.a(bhVar, i3, str7, 273));
                                }
                            }
                            j3 = 0;
                            bhVar.f430061a = j3;
                            str = (String) hashMap.get("pic");
                            if (str == null) {
                            }
                            bhVar.f430063c = str;
                            String str62 = (String) hashMap.get("jump_url");
                            bhVar.f430064d = str62 != null ? str62 : "";
                            str2 = (String) hashMap.get("sort_id");
                            if (str2 == null) {
                            }
                            bhVar.f430065e = j16;
                            int i36 = adItem.iAdId.get();
                            String str72 = adItem.traceinfo.get();
                            Intrinsics.checkNotNullExpressionValue(str72, "adItem.traceinfo.get()");
                            arrayList.add(new com.tencent.sqshow.zootopia.recommend.characterV2.data.a(bhVar, i36, str72, 273));
                        }
                    }
                }
            }
            QLog.i("portal_ZPlanRoleControllerV2", 1, "requestBannerData success. list.count: " + arrayList.size());
            ZPlanRoleControllerV2.this.S0(arrayList);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$h", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/z;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements com.tencent.mobileqq.zootopia.api.e<z> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<z> f372448d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanRoleControllerV2 f372449e;

        h(com.tencent.mobileqq.zootopia.api.e<z> eVar, ZPlanRoleControllerV2 zPlanRoleControllerV2) {
            this.f372448d = eVar;
            this.f372449e = zPlanRoleControllerV2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(z result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("portal_ZPlanRoleControllerV2", 1, "requestRoleData onResultSuccess");
            com.tencent.mobileqq.zootopia.api.e<z> eVar = this.f372448d;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
            ZPlanRoleMidComponent zPlanRoleMidComponent = this.f372449e.midComponent;
            if (zPlanRoleMidComponent != null) {
                zPlanRoleMidComponent.Y();
            }
            this.f372449e.V();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ISceneLoadingView V;
            QLog.i("portal_ZPlanRoleControllerV2", 1, "requestRoleData onResultFailure");
            com.tencent.mobileqq.zootopia.api.e<z> eVar = this.f372448d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            if (this.f372449e.isLoading) {
                AvatarMallLoadingComponent avatarMallLoadingComponent = this.f372449e.loadingComponent;
                if ((avatarMallLoadingComponent == null || (V = avatarMallLoadingComponent.V()) == null) ? false : V.getMRecordAvatarIsShowing()) {
                    this.f372449e.roleFragment.Zh(8);
                    return;
                } else {
                    this.f372449e.roleFragment.Zh(0);
                    return;
                }
            }
            this.f372449e.roleFragment.Zh(8);
            ZPlanRoleMidComponent zPlanRoleMidComponent = this.f372449e.midComponent;
            if (zPlanRoleMidComponent != null) {
                zPlanRoleMidComponent.s(this.f372449e.roleFragment);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$i", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldw4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i implements com.tencent.mobileqq.zootopia.api.e<dw4.b> {
        i() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(dw4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("portal_ZPlanRoleControllerV2", 1, "onResultSuccess");
            ZPlanRoleControllerV2.this.H0();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("portal_ZPlanRoleControllerV2", 1, "onResultFailure error=" + error + ", message=" + message);
        }
    }

    public ZPlanRoleControllerV2(ZPlanRoleFragmentV2 roleFragment, ZootopiaSource source, Bundle bundle) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(roleFragment, "roleFragment");
        Intrinsics.checkNotNullParameter(source, "source");
        this.roleFragment = roleFragment;
        this.source = source;
        this.arguments = bundle;
        com.tencent.sqshow.zootopia.avatar.a aVar = new com.tencent.sqshow.zootopia.avatar.a();
        this.sceneInfoParser = aVar;
        this.avatarInitDataController = new za4.a();
        this.roleRepo = new ZPlanRoleRepo(roleFragment);
        this.engineListenerSet = Collections.synchronizedSet(new LinkedHashSet());
        this.loadingListenerSet = Collections.synchronizedSet(new LinkedHashSet());
        this.sceneRenderListenerSet = Collections.synchronizedSet(new LinkedHashSet());
        this.avatarMallNativeUIListenerSet = Collections.synchronizedSet(new LinkedHashSet());
        this.hasReceivedFirstFrame = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZplanOperationImpl>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$zplanOperationApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanOperationImpl invoke() {
                return new ZplanOperationImpl(ZPlanRoleControllerV2.this.roleFragment.getActivity(), ZPlanRoleControllerV2.this.roleFragment);
            }
        });
        this.zplanOperationApi = lazy;
        this.zplanRequestObserver = new a(new WeakReference(this));
        aVar.b(source);
        W0(0);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void F0() {
        if (this.hasReceivedFirstFrame.compareAndSet(false, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanRoleControllerV2.G0();
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0() {
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).ensureDeviceInfoValid();
        QLog.i("portal_ZPlanRoleControllerV2", 1, "preload AvatarShareConfig");
        com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.a aVar = com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.a.f371751a;
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        aVar.h(zPlanQQMC.getZPlanShareConfig());
        if (zPlanQQMC.enablePreloadUEAvatarInPortal()) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "preloadDownloadUEResource");
            ((IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class)).preloadUEAvatarSuitInfo();
        }
        if (zPlanQQMC.enablePreloadUEXWInPortal()) {
            QRouteApi api = QRoute.api(IZPlanModComponentHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanModComponentHelper::class.java)");
            IZPlanModComponentHelper.a.a((IZPlanModComponentHelper) api, true, false, 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = this.avatarComponent;
        if (zPlanRoleAvatarComponent != null) {
            zPlanRoleAvatarComponent.b0("", null);
        }
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent2 = this.avatarComponent;
        if (zPlanRoleAvatarComponent2 != null) {
            zPlanRoleAvatarComponent2.Z(this);
        }
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent3 = this.avatarComponent;
        if (zPlanRoleAvatarComponent3 != null) {
            zPlanRoleAvatarComponent3.a0(this);
        }
    }

    private final void I0() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "refreshAvatarCharacterIfNeed isAvatarCharacterChanged=" + this.isAvatarCharacterChanged);
        if (this.isAvatarCharacterChanged) {
            com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
            if (fVar != null) {
                b.a.b(fVar, null, false, 3, null);
            }
            this.isAvatarCharacterChanged = false;
        }
    }

    private final void J0() {
        if (this.roleFragment.isDetached()) {
            return;
        }
        MutableLiveData<ZPlanRoleData> i3 = this.roleRepo.i();
        LifecycleOwner viewLifecycleOwner = this.roleFragment.getViewLifecycleOwner();
        final Function1<ZPlanRoleData, Unit> function1 = new Function1<ZPlanRoleData, Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$refreshMidData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanRoleData zPlanRoleData) {
                invoke2(zPlanRoleData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZPlanRoleData roleData) {
                QLog.i("portal_ZPlanRoleControllerV2", 1, "requestRoleData midComponent roleLiveData");
                ZPlanRoleMidComponent zPlanRoleMidComponent = ZPlanRoleControllerV2.this.midComponent;
                if (zPlanRoleMidComponent != null) {
                    Intrinsics.checkNotNullExpressionValue(roleData, "roleData");
                    zPlanRoleMidComponent.b0(roleData);
                }
            }
        };
        i3.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanRoleControllerV2.K0(Function1.this, obj);
            }
        });
        MutableLiveData<bk> e16 = gb4.a.f401894a.e();
        LifecycleOwner viewLifecycleOwner2 = this.roleFragment.getViewLifecycleOwner();
        final Function1<bk, Unit> function12 = new Function1<bk, Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$refreshMidData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bk bkVar) {
                invoke2(bkVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bk bkVar) {
                ZootopiaSource zootopiaSource;
                ZPlanRoleMidComponent zPlanRoleMidComponent = ZPlanRoleControllerV2.this.midComponent;
                if (zPlanRoleMidComponent != null) {
                    bi biVar = bkVar != null ? bkVar.f430082h : null;
                    String str = bkVar != null ? bkVar.f430083i : null;
                    zootopiaSource = ZPlanRoleControllerV2.this.source;
                    zPlanRoleMidComponent.Z(biVar, str, ah.b(zootopiaSource));
                }
            }
        };
        e16.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanRoleControllerV2.L0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "removeZplanRequestObserver");
            ((AppInterface) peekAppRuntime).removeObserver(this.zplanRequestObserver);
        }
    }

    private final void N0() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1380;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, new g());
    }

    private final void O() {
        M0();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "addZPlanRequestObserver");
            ((AppInterface) peekAppRuntime).addObserver(this.zplanRequestObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(bk bkVar) {
        QLog.d("portal_ZPlanRoleControllerV2", 1, "titleData.setter(). value: " + bkVar);
        this.titleData = bkVar;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$titleData$1
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
                bk bkVar2;
                List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> list;
                ZPlanRoleFragmentV2 zPlanRoleFragmentV2 = ZPlanRoleControllerV2.this.roleFragment;
                bkVar2 = ZPlanRoleControllerV2.this.titleData;
                list = ZPlanRoleControllerV2.this.titleBannerDataList;
                zPlanRoleFragmentV2.Th(bkVar2, list);
            }
        });
    }

    private final void U() {
        this.sceneInfoParser.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        Bundle bundle;
        Intent intent;
        Intent intent2;
        FragmentActivity activity = this.roleFragment.getActivity();
        if (activity == null || (intent2 = activity.getIntent()) == null || (bundle = intent2.getExtras()) == null) {
            bundle = new Bundle();
        }
        bundle.putString("tianshuID", null);
        FragmentActivity activity2 = this.roleFragment.getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            intent.putExtras(bundle);
        }
        this.tianshuAdId = 0;
        QLog.i("portal_ZPlanRoleControllerV2", 1, "clearTianshu AdId");
    }

    private final void W0(int viewportType) {
        this.sceneInfoParser.c(viewportType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup e0() {
        FragmentActivity activity = this.roleFragment.getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(activity, ZplanCacheComponentType.FACE_AD_CONTAINER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZplanOperationImpl f0() {
        return (ZplanOperationImpl) this.zplanOperationApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void i0(FaceAdDataEvent event) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(event.getAdInfo());
        ZootopiaFaceAdListData zootopiaFaceAdListData = new ZootopiaFaceAdListData(arrayList);
        ZplanOperationImpl f06 = f0();
        FragmentActivity activity = this.roleFragment.getActivity();
        f06.c(zootopiaFaceAdListData, activity != null ? activity.getSupportFragmentManager() : null, e0(), this.source, this.arguments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean o0() {
        Bundle bundle = this.arguments;
        Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID)) : null;
        return valueOf != null && valueOf.intValue() > 0;
    }

    public void B0() {
        ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
        if (zPlanRoleMidComponent != null) {
            zPlanRoleMidComponent.H();
        }
    }

    public void C0(final ViewGroup rootLayout) {
        Unit unit;
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        FragmentActivity activity = this.roleFragment.getActivity();
        if (activity != null) {
            ((IZPlanForceUpdateHelper) QRoute.api(IZPlanForceUpdateHelper.class)).tryShowForceUpdateDialog(activity, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$onViewCreated$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    QLog.i("portal_ZPlanRoleControllerV2", 1, "tryShowForceUpdateDialog callback - " + z16);
                    if (z16) {
                        return;
                    }
                    ZPlanRoleControllerV2.this.k0(rootLayout);
                    ZPlanRoleControllerV2.this.g0();
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            g0();
        }
        MutableLiveData<bk> e16 = gb4.a.f401894a.e();
        LifecycleOwner viewLifecycleOwner = this.roleFragment.getViewLifecycleOwner();
        final Function1<bk, Unit> function1 = new Function1<bk, Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bk bkVar) {
                invoke2(bkVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bk bkVar) {
                ZPlanRoleControllerV2.this.T0(bkVar);
            }
        };
        e16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanRoleControllerV2.D0(Function1.this, obj);
            }
        });
        N0();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    /* renamed from: E */
    public boolean getMInitDataReady() {
        if (this.avatarInitDataController.getMInitDataReady()) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "getAvatarDataInitStatus true from ExternalInitDataContainer");
            return true;
        }
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        boolean M = fVar != null ? fVar.M() : false;
        if (M) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "getAvatarDataInitStatus true from NativePanelView");
        }
        return M;
    }

    public void E0() {
        String str;
        int i3;
        Intent intent;
        Bundle extras;
        QLog.i("portal_ZPlanRoleControllerV2", 1, "parseTianshuAdId");
        FragmentActivity activity = this.roleFragment.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || (str = extras.getString("tianshuID")) == null) {
            str = "0";
        }
        try {
            i3 = Integer.parseInt(str);
        } catch (Exception unused) {
            i3 = 0;
        }
        this.tianshuAdId = i3;
        QLog.i("portal_ZPlanRoleControllerV2", 1, "getTianshu AdId: " + str);
    }

    public void N(k listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.avatarMallNativeUIListenerSet.add(listener);
    }

    public void O0(uk0.e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.engineListenerSet.add(listener);
    }

    public void P(FragmentActivity activity, QBaseFragment fragment, ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        this.avatarContainer = container;
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = this.avatarComponent;
        if (zPlanRoleAvatarComponent != null) {
            zPlanRoleAvatarComponent.j(activity, fragment, null, container);
        }
    }

    public void P0(ya4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.loadingListenerSet.add(listener);
    }

    public void Q(FragmentActivity activity, QBaseFragment fragment, ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        AvatarMallLoadingComponent avatarMallLoadingComponent = this.loadingComponent;
        if (avatarMallLoadingComponent != null) {
            avatarMallLoadingComponent.j(activity, fragment, null, container);
        }
        U0();
    }

    public void Q0(com.tencent.sqshow.zootopia.avatar.filament.h listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sceneRenderListenerSet.add(listener);
    }

    public void R(FragmentActivity activity, QBaseFragment fragment, ViewGroup container) {
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar2 = this.mallComponent;
        if (fVar2 != null) {
            fVar2.j(activity, fragment, null, container);
        }
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar3 = this.mallComponent;
        if (fVar3 != null) {
            FragmentActivity requireActivity = this.roleFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "roleFragment.requireActivity()");
            fVar3.N(new AvatarMallViewInitData(requireActivity, "pg_zplan_paradise", this.source));
        }
        if (!this.isResumedState || (fVar = this.mallComponent) == null) {
            return;
        }
        fVar.y();
    }

    public void R0(boolean select) {
        this.isTabSelected = select;
    }

    public void S(FragmentActivity activity, QBaseFragment fragment, ViewGroup container) {
        ZPlanRoleMidComponent zPlanRoleMidComponent;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        this.midContainer = container;
        ZPlanRoleMidComponent zPlanRoleMidComponent2 = this.midComponent;
        if (zPlanRoleMidComponent2 != null) {
            zPlanRoleMidComponent2.j(activity, fragment, null, container);
        }
        if (this.isResumedState && (zPlanRoleMidComponent = this.midComponent) != null) {
            zPlanRoleMidComponent.y();
        }
        J0();
    }

    public boolean T() {
        if (f0().d()) {
            return f0().a();
        }
        return false;
    }

    public boolean V0() {
        com.tencent.sqshow.dresskey.b bVar = com.tencent.sqshow.dresskey.b.f369818a;
        dw4.b value = bVar.l("start_portal", true).getValue();
        if (value != null && com.tencent.mobileqq.zootopia.utils.g.i(value)) {
            H0();
            return true;
        }
        QLog.i("portal_ZPlanRoleControllerV2", 1, "startEngine, dressInfo not ready");
        if (this.avatarDressInfoCallback == null) {
            this.avatarDressInfoCallback = new i();
        }
        com.tencent.mobileqq.zootopia.api.e<dw4.b> eVar = this.avatarDressInfoCallback;
        Intrinsics.checkNotNull(eVar);
        bVar.k("start_portal", true, eVar);
        return false;
    }

    public void W(com.tencent.zplan.zplantracing.c zplanSpanContext, Integer nativeAppId) {
        ZPlanRoleAvatarComponent b16 = FilamentApiImpl.f369933a.b(zplanSpanContext, nativeAppId);
        b16.e9(this);
        this.avatarComponent = b16;
    }

    public void X() {
        if (o0()) {
            return;
        }
        AvatarMallLoadingComponent avatarMallLoadingComponent = new AvatarMallLoadingComponent(0, EngineLoadingScene.ROLE, AvatarEngineType.FILAMENT, 1, null);
        avatarMallLoadingComponent.b0(new c());
        this.loadingComponent = avatarMallLoadingComponent;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public CameraKey Y() {
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            return fVar.getCameraId();
        }
        return null;
    }

    public void Ya(String from, boolean withoutBlend, boolean withDelay) {
        Intrinsics.checkNotNullParameter(from, "from");
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.Ya(from, withoutBlend, withDelay);
        }
    }

    public void Z() {
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = new com.tencent.sqshow.zootopia.recommend.characterV2.component.f(this);
        this.mallComponent = fVar;
        fVar.K(new d());
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.controller.a
    public boolean a() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "canShowBubble nativeUIShow:" + this.isNativeUIShow + ", isResumedState:" + this.isResumedState + ", isHiddenState:" + this.isHiddenState);
        return (this.isNativeUIShow || !this.isResumedState || this.isHiddenState) ? false : true;
    }

    public void a0() {
        this.midComponent = new ZPlanRoleMidComponent(this);
    }

    public void b0(boolean withAnim) {
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.u(withAnim);
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.controller.a
    public Set<Integer> c() {
        Set<Integer> emptySet;
        Set<Integer> V;
        ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
        if (zPlanRoleMidComponent != null && (V = zPlanRoleMidComponent.V()) != null) {
            return V;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public com.tencent.sqshow.zootopia.recommend.characterV2.component.a c0() {
        return this.avatarComponent;
    }

    public b94.a d0() {
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = this.avatarComponent;
        if (zPlanRoleAvatarComponent != null) {
            return zPlanRoleAvatarComponent.m8();
        }
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.controller.a
    /* renamed from: e, reason: from getter */
    public ViewGroup getMidContainer() {
        return this.midContainer;
    }

    /* renamed from: n0, reason: from getter */
    public boolean getIsLoading() {
        return this.isLoading;
    }

    @Override // uk0.e
    public void onEvent(String type, String eventData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "onEvent " + type);
            m0();
            F0();
        }
        Set<uk0.e> engineListenerSet = this.engineListenerSet;
        Intrinsics.checkNotNullExpressionValue(engineListenerSet, "engineListenerSet");
        Iterator<T> it = engineListenerSet.iterator();
        while (it.hasNext()) {
            ((uk0.e) it.next()).onEvent(type, eventData);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar;
        QLog.i("portal_ZPlanRoleControllerV2", 1, "onReceiveEvent tabSelected:" + this.isTabSelected + ", " + event);
        if (event instanceof EnterAvatarMallEvent) {
            if (this.isTabSelected) {
                com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar2 = this.mallComponent;
                if (!((fVar2 == null || fVar2.j6()) ? false : true) || (fVar = this.mallComponent) == null) {
                    return;
                }
                fVar.L();
                return;
            }
            return;
        }
        if (event instanceof FaceAdDataEvent) {
            i0((FaceAdDataEvent) event);
        } else if (event instanceof NewBodyUpdateAgreeEvent) {
            j0();
        }
    }

    public void onResume() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "onResume");
        this.isResumedState = true;
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = this.avatarComponent;
        if (zPlanRoleAvatarComponent != null) {
            zPlanRoleAvatarComponent.y();
        }
        AvatarMallLoadingComponent avatarMallLoadingComponent = this.loadingComponent;
        if (avatarMallLoadingComponent != null) {
            avatarMallLoadingComponent.y();
        }
        ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
        if (zPlanRoleMidComponent != null) {
            zPlanRoleMidComponent.y();
        }
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.y();
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        ZPlanRedDotManager zPlanRedDotManager = ZPlanRedDotManager.f373437a;
        zPlanRedDotManager.x();
        zPlanRedDotManager.v();
        yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
        f0().h();
        I0();
        if (this.needUpdateBannerInfos) {
            this.needUpdateBannerInfos = false;
            N0();
        }
    }

    public void q0(com.tencent.sqshow.zootopia.scene.component.d observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.q0(observer);
        }
    }

    public void qg(o listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("portal_ZPlanRoleControllerV2", 1, "addNativeUIDataListener " + listener + ", " + this.mallComponent);
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.qg(listener);
        }
    }

    public boolean s0() {
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            return fVar.O();
        }
        return false;
    }

    public void s2(o listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("portal_ZPlanRoleControllerV2", 1, "removeNativeUIDataListener " + listener + ", " + this.mallComponent);
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.s2(listener);
        }
    }

    public final void t0(com.tencent.sqshow.zootopia.recommend.characterV2.data.a bannerData) {
        Intrinsics.checkNotNullParameter(bannerData, "bannerData");
        this.needUpdateBannerInfos = true;
    }

    public void u0(Configuration newConfig, int fullViewWidth, int fullViewHeight) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QLog.i("portal_ZPlanRoleControllerV2", 1, "onConfigurationChanged " + newConfig + ", " + fullViewWidth + " * " + fullViewHeight);
        e84.a.f395879a.b(fullViewWidth, fullViewHeight);
        f0().e(newConfig);
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.P(newConfig);
        }
    }

    public void w0() {
        if (this.roleFragment.isDetached()) {
            return;
        }
        gb4.a aVar = gb4.a.f401894a;
        LifecycleOwner viewLifecycleOwner = this.roleFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "roleFragment.viewLifecycleOwner");
        aVar.g(viewLifecycleOwner);
        com.tencent.sqshow.zootopia.recommend.characterV2.data.c cVar = com.tencent.sqshow.zootopia.recommend.characterV2.data.c.f372487a;
        LifecycleOwner viewLifecycleOwner2 = this.roleFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "roleFragment.viewLifecycleOwner");
        cVar.c(viewLifecycleOwner2);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public qu4.a x0() {
        qu4.a x06 = this.avatarInitDataController.x0();
        if (x06 != null) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "getInitDressInfo from ExternalInitDataContainer");
            return x06;
        }
        qu4.a b16 = d.a.b(this);
        if (b16 != null) {
            QLog.i("portal_ZPlanRoleControllerV2", 1, "getInitDressInfo from AvatarDataCenter");
        }
        return b16;
    }

    public void y0(boolean hidden) {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "onHiddenChanged " + hidden);
        this.isHiddenState = hidden;
        if (hidden) {
            ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
            if (zPlanRoleMidComponent != null) {
                zPlanRoleMidComponent.r();
            }
            ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).smallHomeSetIsInAvatarScene(false);
            return;
        }
        ZPlanRoleMidComponent zPlanRoleMidComponent2 = this.midComponent;
        if (zPlanRoleMidComponent2 != null) {
            zPlanRoleMidComponent2.y();
        }
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).smallHomeSetIsInAvatarScene(!FilamentApiImpl.f369933a.d());
    }

    public void z0(Intent intent) {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "onNewIntent " + intent);
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "handleFaceAd");
        FragmentActivity activity = this.roleFragment.getActivity();
        if (activity == null) {
            return;
        }
        MutableLiveData<ZootopiaFaceAdListData> g16 = this.roleRepo.g();
        final Function1<ZootopiaFaceAdListData, Unit> function1 = new Function1<ZootopiaFaceAdListData, Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$handleFaceAd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaFaceAdListData zootopiaFaceAdListData) {
                invoke2(zootopiaFaceAdListData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaFaceAdListData zootopiaFaceAdListData) {
                boolean z16;
                Bundle bundle;
                ZplanOperationImpl f06;
                ViewGroup e06;
                ZootopiaSource zootopiaSource;
                Bundle bundle2;
                List<nw4.h> a16;
                QLog.i("portal_ZPlanRoleControllerV2", 1, "handleFaceAd#observe - " + ((zootopiaFaceAdListData == null || (a16 = zootopiaFaceAdListData.a()) == null) ? null : Integer.valueOf(a16.size())));
                if (zootopiaFaceAdListData == null) {
                    return;
                }
                z16 = ZPlanRoleControllerV2.this.hasHandleFaceAd;
                boolean z17 = !z16;
                if (!z17) {
                    ZPlanRoleControllerV2.this.roleFragment.pf();
                } else {
                    ZPlanRoleControllerV2 zPlanRoleControllerV2 = ZPlanRoleControllerV2.this;
                    f06 = zPlanRoleControllerV2.f0();
                    FragmentActivity activity2 = ZPlanRoleControllerV2.this.roleFragment.getActivity();
                    FragmentManager supportFragmentManager = activity2 != null ? activity2.getSupportFragmentManager() : null;
                    e06 = ZPlanRoleControllerV2.this.e0();
                    zootopiaSource = ZPlanRoleControllerV2.this.source;
                    bundle2 = ZPlanRoleControllerV2.this.arguments;
                    zPlanRoleControllerV2.hasHandleFaceAd = f06.c(zootopiaFaceAdListData, supportFragmentManager, e06, zootopiaSource, bundle2);
                }
                ZootopiaFaceAdReport zootopiaFaceAdReport = ZootopiaFaceAdReport.f372190a;
                bundle = ZPlanRoleControllerV2.this.arguments;
                zootopiaFaceAdReport.d(bundle, z17);
            }
        };
        g16.observe(activity, new Observer() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanRoleControllerV2.h0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(final ViewGroup rootLayout) {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "handlePortalSystemNotification");
        final FragmentActivity activity = this.roleFragment.getActivity();
        if (activity == null) {
            return;
        }
        MutableLiveData<bj> h16 = this.roleRepo.h();
        final Function1<bj, Unit> function1 = new Function1<bj, Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$handlePortalSystemNotification$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bj bjVar) {
                invoke2(bjVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bj bjVar) {
                QLog.i("portal_ZPlanRoleControllerV2", 1, "handlePortalSystemNotification#observe - " + bjVar);
                if (bjVar == null) {
                    return;
                }
                m.f373287a.h(FragmentActivity.this, bjVar, rootLayout);
            }
        };
        h16.observe(activity, new Observer() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanRoleControllerV2.l0(Function1.this, obj);
            }
        });
    }

    public void A0() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.isResumedState = false;
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = this.avatarComponent;
        if (zPlanRoleAvatarComponent != null) {
            zPlanRoleAvatarComponent.r();
        }
        AvatarMallLoadingComponent avatarMallLoadingComponent = this.loadingComponent;
        if (avatarMallLoadingComponent != null) {
            avatarMallLoadingComponent.r();
        }
        ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
        if (zPlanRoleMidComponent != null) {
            zPlanRoleMidComponent.r();
        }
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.r();
        }
        f0().g();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void U0() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "showLoadingView");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$showLoadingView$1
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
                Set loadingListenerSet;
                AvatarMallLoadingComponent avatarMallLoadingComponent = ZPlanRoleControllerV2.this.loadingComponent;
                if (avatarMallLoadingComponent != null) {
                    avatarMallLoadingComponent.show();
                }
                ZPlanRoleControllerV2.this.isLoading = true;
                loadingListenerSet = ZPlanRoleControllerV2.this.loadingListenerSet;
                Intrinsics.checkNotNullExpressionValue(loadingListenerSet, "loadingListenerSet");
                Iterator it = loadingListenerSet.iterator();
                while (it.hasNext()) {
                    ((ya4.a) it.next()).w0();
                }
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.controller.b
    public void b(com.tencent.mobileqq.zootopia.api.e<z> callback) {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "requestRoleData");
        this.roleRepo.t(new h(callback, this), this.tianshuAdId);
        ZootopiaFaceAdReport.f372190a.c(this.arguments);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.h
    public void d() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "onRenderComplete");
        Set<com.tencent.sqshow.zootopia.avatar.filament.h> sceneRenderListenerSet = this.sceneRenderListenerSet;
        Intrinsics.checkNotNullExpressionValue(sceneRenderListenerSet, "sceneRenderListenerSet");
        Iterator<T> it = sceneRenderListenerSet.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.avatar.filament.h) it.next()).d();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(EnterAvatarMallEvent.class, FaceAdDataEvent.class, NewBodyUpdateAgreeEvent.class);
        return arrayListOf;
    }

    public void m0() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "hideLoadingView");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$hideLoadingView$1
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
                Set loadingListenerSet;
                ZPlanRoleAvatarComponent zPlanRoleAvatarComponent;
                AvatarMallLoadingComponent avatarMallLoadingComponent = ZPlanRoleControllerV2.this.loadingComponent;
                if (avatarMallLoadingComponent != null) {
                    avatarMallLoadingComponent.f(0L);
                }
                ZPlanRoleControllerV2.this.isLoading = false;
                loadingListenerSet = ZPlanRoleControllerV2.this.loadingListenerSet;
                Intrinsics.checkNotNullExpressionValue(loadingListenerSet, "loadingListenerSet");
                Iterator it = loadingListenerSet.iterator();
                while (it.hasNext()) {
                    ((ya4.a) it.next()).U();
                }
                if (ZPlanRoleControllerV2.this.avatarContainer instanceof ZPlanRoleMidTouchTap) {
                    ViewGroup viewGroup = ZPlanRoleControllerV2.this.avatarContainer;
                    Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRoleMidTouchTap");
                    ((ZPlanRoleMidTouchTap) viewGroup).b();
                }
                zPlanRoleAvatarComponent = ZPlanRoleControllerV2.this.avatarComponent;
                if (zPlanRoleAvatarComponent != null) {
                    zPlanRoleAvatarComponent.Y();
                }
            }
        });
    }

    public void onDestroy() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = this.avatarComponent;
        if (zPlanRoleAvatarComponent != null) {
            zPlanRoleAvatarComponent.h();
        }
        AvatarMallLoadingComponent avatarMallLoadingComponent = this.loadingComponent;
        if (avatarMallLoadingComponent != null) {
            avatarMallLoadingComponent.h();
        }
        ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
        if (zPlanRoleMidComponent != null) {
            zPlanRoleMidComponent.h();
        }
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar = this.mallComponent;
        if (fVar != null) {
            fVar.h();
        }
        f0().f();
        ZootopiaFaceAdReport.f372190a.j(this.arguments);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ((IZPlanForceUpdateHelper) QRoute.api(IZPlanForceUpdateHelper.class)).clearShowedFlag();
        M0();
        com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.a.f371751a.c();
        this.avatarDressInfoCallback = null;
    }

    public void onStop() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, DKHippyEvent.EVENT_STOP);
        ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
        if (zPlanRoleMidComponent != null) {
            zPlanRoleMidComponent.i();
        }
    }

    public void p0() {
        ISceneLoadingView V;
        QLog.i("portal_ZPlanRoleControllerV2", 1, "retryPage");
        AvatarMallLoadingComponent avatarMallLoadingComponent = this.loadingComponent;
        if (avatarMallLoadingComponent == null || (V = avatarMallLoadingComponent.V()) == null) {
            return;
        }
        V.k();
    }

    public void r0() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "midComponentRetry");
        ZPlanRoleMidComponent zPlanRoleMidComponent = this.midComponent;
        if (zPlanRoleMidComponent != null) {
            zPlanRoleMidComponent.U();
        }
    }

    public void v0() {
        QLog.i("portal_ZPlanRoleControllerV2", 1, "onCreate");
        SimpleEventBus.getInstance().registerReceiver(this);
        gb4.a aVar = gb4.a.f401894a;
        aVar.e().postValue(aVar.f());
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).ensureDeviceInfoValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> list) {
        QLog.d("portal_ZPlanRoleControllerV2", 1, "titleBannerDataList.setter(). value.count: " + (list != null ? Integer.valueOf(list.size()) : null));
        this.titleBannerDataList = list;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2$titleBannerDataList$1
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
                bk bkVar;
                List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> list2;
                ZPlanRoleFragmentV2 zPlanRoleFragmentV2 = ZPlanRoleControllerV2.this.roleFragment;
                bkVar = ZPlanRoleControllerV2.this.titleData;
                list2 = ZPlanRoleControllerV2.this.titleBannerDataList;
                zPlanRoleFragmentV2.Th(bkVar, list2);
            }
        });
    }

    private final void j0() {
        b.a.a(this, null, 1, null);
        f fVar = new f();
        com.tencent.sqshow.zootopia.recommend.characterV2.component.f fVar2 = this.mallComponent;
        if (fVar2 != null) {
            fVar2.Q(true, new e(fVar));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$a;", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lmqq/util/WeakReference;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", "d", "Lmqq/util/WeakReference;", "getControllerV2Ref", "()Lmqq/util/WeakReference;", "controllerV2Ref", "<init>", "(Lmqq/util/WeakReference;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class a implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanRoleControllerV2> controllerV2Ref;

        public a(WeakReference<ZPlanRoleControllerV2> controllerV2Ref) {
            Intrinsics.checkNotNullParameter(controllerV2Ref, "controllerV2Ref");
            this.controllerV2Ref = controllerV2Ref;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            List emptyList;
            com.tencent.sqshow.zootopia.recommend.characterV2.component.a c06;
            if (type == 27405) {
                QLog.i("portal_ZPlanRoleControllerV2", 1, "receive PROFILE_APPEARANCE_KEY change");
                try {
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String?>");
                    emptyList = (List) data;
                } catch (Throwable th5) {
                    QLog.e("portal_ZPlanRoleControllerV2", 1, "onUpdate PROFILE_APPEARANCE_KEY exception", th5);
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                if (emptyList.isEmpty()) {
                    QLog.e("portal_ZPlanRoleControllerV2", 1, "uinList is empty");
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.e("portal_ZPlanRoleControllerV2", 1, "app is null");
                    return;
                }
                if (!emptyList.contains(peekAppRuntime.getCurrentUin())) {
                    QLog.i("portal_ZPlanRoleControllerV2", 1, "not self uin, no need refresh");
                    return;
                }
                qu4.a k3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
                ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.controllerV2Ref.get();
                qu4.a n3 = (zPlanRoleControllerV2 == null || (c06 = zPlanRoleControllerV2.c0()) == null) ? null : c06.n();
                ZPlanRoleControllerV2 zPlanRoleControllerV22 = this.controllerV2Ref.get();
                if (zPlanRoleControllerV22 == null) {
                    return;
                }
                zPlanRoleControllerV22.isAvatarCharacterChanged = (k3 == null || r94.a.c(k3, n3)) ? false : true;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2$c", "Lpd3/b;", "", "w0", "Bb", "U", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements pd3.b {
        c() {
        }

        @Override // pd3.b
        public void Bb() {
        }

        @Override // pd3.b
        public void U() {
        }

        @Override // pd3.b
        public void w0() {
        }
    }
}
