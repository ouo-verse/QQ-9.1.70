package com.tencent.robot.profile.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.common.util.k;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileOpenApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.webview.swift.ag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.profile.RobotProfileFragment;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0015\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001d2\u0006\u0010\u0017\u001a\u00020\u0004J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u001e\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011J\u001e\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J6\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010-2\b\u0010,\u001a\u0004\u0018\u00010+J$\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\n\u00101\u001a\u00020\u0004*\u000200J\n\u00103\u001a\u00020\u0004*\u000202J\u0012\u00106\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104J\u0006\u00107\u001a\u00020\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/robot/profile/utils/RobotProfileUtils;", "", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, "", "t", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peerUin", "Landroidx/core/util/Consumer;", "consumer", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "p", "robotUin", "y", "troopUin", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "url", "Lkotlin/Function0;", "exitFunc", "D", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "Lkotlin/Pair;", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", IProfileProtocolConst.PARAM_IS_FRIEND, HippyTKDListViewAdapter.X, "verify", "r", "robotName", "title", "o", h.F, "pskey", "i", "Landroid/os/Bundle;", "bundle", "", "g", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBaseInfo;", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "v", "Landroid/view/View;", "view", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RobotProfileUtils f368193a = new RobotProfileUtils();

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/profile/utils/RobotProfileUtils$a", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<String> f368194a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super String> cancellableContinuation) {
            this.f368194a = cancellableContinuation;
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f368194a.resumeWith(Result.m476constructorimpl(""));
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            CancellableContinuation<String> cancellableContinuation = this.f368194a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(domainToKeyMap.get(FlockBaseRequest.QUN_DOMAIN)));
        }
    }

    RobotProfileUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ITroopUtilApi troopApi, Context context, String robotUin, String troopUin, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopApi, "$troopApi");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        QLog.d("robot.profile.RobotProfileUtils", 4, "shareRobot2Troop arkInfoStr:" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("robot.profile.RobotProfileUtils", 1, "shareRobot2Troop failed fetch arkInfo");
            return;
        }
        Bundle forwardRobotCardBundle = troopApi.getForwardRobotCardBundle(context, robotUin, str);
        forwardRobotCardBundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        forwardRobotCardBundle.putInt("key_direct_show_uin_type", 1);
        forwardRobotCardBundle.putString("key_direct_show_uin", troopUin);
        Intent intent = new Intent();
        intent.putExtra("isFromShare", true);
        intent.putExtras(forwardRobotCardBundle);
        RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean E(RobotProfileUtils robotProfileUtils, Context context, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.robot.profile.utils.RobotProfileUtils$shouldInterceptForRobotProfile$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return robotProfileUtils.D(context, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable F(final String peerUin, final Consumer<String> consumer) {
        return new Runnable() { // from class: com.tencent.robot.profile.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                RobotProfileUtils.G(peerUin, consumer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final String peerUin, final Consumer consumer) {
        boolean z16;
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        String nick = ((IProfileOpenApi) QRoute.api(IProfileOpenApi.class)).getNick(peerUin, "default", new IProfileOpenApi.ProfileServiceCallback() { // from class: com.tencent.robot.profile.utils.e
            @Override // com.tencent.mobileqq.profilecard.api.IProfileOpenApi.ProfileServiceCallback
            public final void onResult(int i3, String str, Bundle bundle) {
                RobotProfileUtils.H(Consumer.this, peerUin, i3, str, bundle);
            }
        });
        if (nick != null && nick.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            consumer.accept(nick);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Consumer consumer, String peerUin, int i3, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        if (i3 == 0 && bundle != null) {
            consumer.accept(bundle.getString(IProfileOpenApi.ProfileServiceCallback.PROFILE_NICK));
            return;
        }
        QLog.e("robot.profile.RobotProfileUtils", 1, "getMemberNickByUin|errCode=" + i3 + ", msg=" + str);
        consumer.accept(peerUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026va, ProcessConstant.MAIN)");
        ((IPskeyManager) runtimeService).getPskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final boolean p(Uri uri) {
        boolean z16;
        if (!Intrinsics.areEqual(uri.getHost(), "bot.q.qq.com")) {
            return false;
        }
        String path = uri.getPath();
        if (path != null) {
            z16 = StringsKt__StringsJVMKt.startsWith$default(path, "/s/", false, 2, null);
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void t(@NotNull Context context, @NotNull String jumpUrl) {
        boolean isBlank;
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        isBlank = StringsKt__StringsJVMKt.isBlank(jumpUrl);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("fail to openUrlOrSchema, url is empty");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("robot.profile.RobotProfileUtils", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().i("robot.profile.RobotProfileUtils", 1, "openUrlOrSchema(" + jumpUrl + ")");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "http", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "https", false, 2, null);
            if (!startsWith$default2) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
                ax c16 = bi.c((BaseQQAppInterface) peekAppRuntime, context, jumpUrl);
                if (c16 != null) {
                    c16.b();
                    return;
                }
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", jumpUrl);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ITroopUtilApi troopApi, Context context, String robotUin, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopApi, "$troopApi");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        QLog.d("robot.profile.RobotProfileUtils", 4, "fetchRobotShareInfo arkInfoStr:" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("robot.profile.RobotProfileUtils", 1, "fetchRobotShareInfo failed fetch arkInfo");
        } else {
            troopApi.forwardRobotCard(context, robotUin, str);
        }
    }

    public final void A(@NotNull final Context context, @NotNull final String robotUin, @NotNull final String troopUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        QRouteApi api = QRoute.api(ITroopUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
        final ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) api;
        iTroopUtilApi.fetchRobotShareInfo(MobileQQ.sMobileQQ.peekAppRuntime(), robotUin, new com.tencent.mobileqq.troop.api.a() { // from class: com.tencent.robot.profile.utils.c
            @Override // com.tencent.mobileqq.troop.api.a
            public final void onResult(String str) {
                RobotProfileUtils.B(ITroopUtilApi.this, context, robotUin, troopUin, str);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0007, B:5:0x000f, B:6:0x00d6, B:14:0x0017, B:16:0x0053, B:17:0x005b, B:19:0x0068, B:21:0x009c, B:22:0x0075, B:25:0x0085, B:27:0x0092, B:29:0x00a3, B:31:0x00ad, B:32:0x00b4, B:34:0x00bd, B:39:0x00c9, B:40:0x00d0), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0007, B:5:0x000f, B:6:0x00d6, B:14:0x0017, B:16:0x0053, B:17:0x005b, B:19:0x0068, B:21:0x009c, B:22:0x0075, B:25:0x0085, B:27:0x0092, B:29:0x00a3, B:31:0x00ad, B:32:0x00b4, B:34:0x00bd, B:39:0x00c9, B:40:0x00d0), top: B:2:0x0007 }] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Boolean, Uri> C(@NotNull String url) {
        Object m476constructorimpl;
        boolean z16;
        Pair pair;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!u64.a.b()) {
                pair = TuplesKt.to(Boolean.FALSE, null);
            } else {
                Uri uri = Uri.parse(url);
                QLog.i("robot.profile.RobotProfileUtils", 4, "shouldInterceptForRobotProfile host:" + uri.getHost() + " path:" + uri.getPath());
                RobotProfileUtils robotProfileUtils = f368193a;
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                if (robotProfileUtils.p(uri)) {
                    pair = TuplesKt.to(Boolean.TRUE, uri);
                } else if ((!Intrinsics.areEqual(uri.getHost(), "web.qun.qq.com") && !Intrinsics.areEqual(uri.getHost(), FlockBaseRequest.QUN_DOMAIN)) || (!Intrinsics.areEqual(uri.getPath(), "/qunrobot/data.html") && !Intrinsics.areEqual(uri.getPath(), "/qunpro/robot/qunshare") && !Intrinsics.areEqual(uri.getPath(), "/qunpro/robot/agent-index"))) {
                    pair = TuplesKt.to(Boolean.FALSE, null);
                } else if (Intrinsics.areEqual(uri.getPath(), "/qunpro/robot/agent-index")) {
                    pair = TuplesKt.to(Boolean.TRUE, uri);
                } else {
                    String queryParameter = uri.getQueryParameter("robot_uin");
                    if (queryParameter != null && queryParameter.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            pair = TuplesKt.to(Boolean.FALSE, null);
                        } else {
                            pair = TuplesKt.to(Boolean.TRUE, uri);
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
            }
            m476constructorimpl = Result.m476constructorimpl(pair);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Pair pair2 = TuplesKt.to(Boolean.FALSE, null);
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = pair2;
        }
        return (Pair) m476constructorimpl;
    }

    public final boolean D(@NotNull Context context, @NotNull String url, @NotNull Function0<Unit> exitFunc) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(exitFunc, "exitFunc");
        try {
            Result.Companion companion = Result.INSTANCE;
            RobotProfileUtils robotProfileUtils = f368193a;
            Pair<Boolean, Uri> C = robotProfileUtils.C(url);
            boolean booleanValue = C.component1().booleanValue();
            Uri component2 = C.component2();
            if (booleanValue && component2 != null) {
                if (Intrinsics.areEqual(component2.getPath(), "/qunpro/robot/agent-index") && robotProfileUtils.n(context, component2)) {
                    exitFunc.invoke();
                    return true;
                }
                if (robotProfileUtils.p(component2)) {
                    RobotProfileFragment.INSTANCE.d(url, exitFunc);
                    return true;
                }
                robotProfileUtils.s(component2, context);
                exitFunc.invoke();
                return true;
            }
            return false;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
            if (m479exceptionOrNullimpl != null) {
                QLog.w("robot.profile.RobotProfileUtils", 1, "shouldInterceptForRobotProfile url:" + url + " throwable:" + m479exceptionOrNullimpl);
            }
            return false;
        }
    }

    @NotNull
    public final Map<String, Object> g(@Nullable Bundle bundle) {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] strArr = {"qq_robot_type", "uin", "robot_import_source"};
        for (int i3 = 0; i3 < 3; i3++) {
            String str = strArr[i3];
            if (bundle != null && (obj = bundle.get(str)) != null) {
                linkedHashMap.put(str, obj);
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public final String h() {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new RobotProfileUtils$getBKN$pskey$1(null), 1, null);
        String str = (String) runBlocking$default;
        QLog.d("robot.profile.RobotProfileUtils", 1, "getPskey onSuccess " + k.e("p_skey=" + str, new String[0]));
        return i(str);
    }

    @NotNull
    public final String i(@Nullable String pskey) {
        boolean z16;
        String str;
        boolean z17;
        if (pskey != null && pskey.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || pskey.length() < 10) {
            str = "";
        } else {
            str = pskey.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        if (str.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            QLog.e("robot.profile.RobotProfileUtils", 1, "getBKN skey is empty");
            return "";
        }
        int length = str.length();
        int i3 = 5381;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + str.codePointAt(i16);
        }
        return String.valueOf(Integer.MAX_VALUE & i3);
    }

    @Nullable
    public final View j(@Nullable View view) {
        if (view == null) {
            return null;
        }
        if (view.getContext() instanceof Activity) {
            Context context = view.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context).getWindow() != null) {
                Context context2 = view.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                return ((Activity) context2).getWindow().getDecorView();
            }
            return view;
        }
        return view;
    }

    public final void k(@NotNull String peerUin, @NotNull String troopUin, @NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(troopUin, peerUin, "robot.profile.RobotProfileUtils", new RobotProfileUtils$getMemberNickByUin$1(consumer, peerUin));
    }

    @NotNull
    public final String m(@Nullable String robotUin, @Nullable String troopUin) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("https://web.qun.qq.com/qunrobot/data.html?");
        boolean z17 = false;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            sb5.append("gc=" + troopUin + ContainerUtils.FIELD_DELIMITER);
        }
        if (robotUin == null || robotUin.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            sb5.append("robot_uin=" + robotUin);
        }
        sb5.append("&_wwv=130&_wv=3");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "urlBuilder.toString()");
        return sb6;
    }

    public final boolean n(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter("source");
        if (queryParameter == null) {
            queryParameter = "0";
        }
        ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context, "mqqapi://adelie/open_home?version=1&src_type=app&source=" + queryParameter);
        if (c16 != null) {
            return c16.b();
        }
        QLog.e("robot.profile.RobotProfileUtils", 1, "interceptForRobotListShare action is null");
        return false;
    }

    public final void o(@NotNull Context context, @NotNull String robotUin, @NotNull String robotName, @NotNull String troopUin, @NotNull String url, @NotNull String title) {
        boolean z16;
        Long longOrNull;
        long j3;
        Activity activity;
        Long longOrNull2;
        long j16;
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Bundle bundle = new Bundle();
        bundle.putString("troopuin", troopUin);
        bundle.putString("robotuin", robotUin);
        bundle.putString("robotname", robotName);
        bundle.putString("onurl", "");
        bundle.putString("ontitle", "");
        bundle.putString("offurl", url);
        bundle.putString("offtitle", title);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(AppConstants.Key.KEY_INVOKE_TROOP_ROBOT_FUNCTION, bundle);
        bundle2.putBoolean("key_is_ignore_draft", true);
        boolean z17 = false;
        if (troopUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && (intent = activity.getIntent()) != null && intent.getBooleanExtra("key_enter_chat_by_finish", false)) {
                z17 = true;
            }
            boolean z18 = !z17;
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(robotUin);
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(robotUin);
            if (longOrNull2 != null) {
                j16 = longOrNull2.longValue();
            } else {
                j16 = 0;
            }
            if (z18) {
                IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                iAIOStarterApi.navigateToAIOActivity(context, 1, uid, robotName, j16, bundle2);
                return;
            } else {
                IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                iAIOStarterApi2.navigateToAIO(context, 1, uid, robotName, j16, bundle2);
                return;
            }
        }
        IAIOStarterApi iAIOStarterApi3 = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        iAIOStarterApi3.navigateToAIO(context, 2, troopUin, "", j3, bundle2);
    }

    public final boolean q() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("robot_profile_reverse_empty_switch_910_119421042", true);
    }

    public final void r(@NotNull Context context, @NotNull String robotUin, @NotNull String verify) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(verify, "verify");
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        String format = String.format("https://web.qun.qq.com/qunrobot/more.html?robot_uin=%s&verify=%s&_wwv=128&_wv=3", Arrays.copyOf(new Object[]{robotUin, verify}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        intent.putExtra("url", format);
        context.startActivity(intent);
    }

    public final void s(@NotNull Uri uri, @NotNull Context context) {
        String str;
        String str2;
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(context, "context");
        String queryParameter = uri.getQueryParameter("robot_uin");
        if (queryParameter == null) {
            str = "";
        } else {
            str = queryParameter;
        }
        String queryParameter2 = uri.getQueryParameter("gc");
        if (queryParameter2 == null) {
            str2 = "";
        } else {
            str2 = queryParameter2;
        }
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        RobotProfileFragment.Companion.c(RobotProfileFragment.INSTANCE, context, str2, str, i3, !(context instanceof Activity), 0, null, 96, null);
    }

    public final void u(@NotNull Context context, @NotNull String robotUin, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String m3 = m(robotUin, troopUin);
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", m3);
        if (ag.f314191a.containsKey("robotsummary")) {
            intent.putExtra("insertPluginsArray", new String[]{"robotsummary"});
        }
        context.startActivity(intent);
    }

    @NotNull
    public final String v(@NotNull GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        RobotBaseInfo robotData = groupRobotProfile.robotData;
        Intrinsics.checkNotNullExpressionValue(robotData, "robotData");
        String w3 = w(robotData);
        int i3 = groupRobotProfile.userMembership;
        int i16 = groupRobotProfile.robotMembership;
        boolean z16 = groupRobotProfile.isFriend;
        boolean z17 = groupRobotProfile.isReceive;
        boolean z18 = groupRobotProfile.isGroupReceive;
        boolean z19 = groupRobotProfile.canResetHistory;
        int i17 = groupRobotProfile.subscribeMsgTplCnt;
        RobotTTSList robotTTSList = groupRobotProfile.ttsList;
        return w3 + "\nuMember=" + i3 + " rMember=" + i16 + " friend=" + z16 + " receive=" + z17 + " gReceive=" + z18 + " canReset=" + z19 + " msgTplCnt=" + i17 + " defaultTtsId=" + robotTTSList.defaultTtsId + " pickTtsId=" + robotTTSList.pickTtsId + " hasQZone=" + groupRobotProfile.qzoneInfo.hasOpenQQZone + " addedUin = " + groupRobotProfile.traceInfo.addOperatorUin;
    }

    @NotNull
    public final String w(@NotNull RobotBaseInfo robotBaseInfo) {
        Intrinsics.checkNotNullParameter(robotBaseInfo, "<this>");
        return robotBaseInfo.name + " uin=" + robotBaseInfo.robotUin + " appid=" + robotBaseInfo.appid + " uid=" + robotBaseInfo.robotUid + " type=" + robotBaseInfo.robotBizType + " allowGroup=" + robotBaseInfo.allowedAddGroup + " allowC2C=" + robotBaseInfo.allowedAddC2C + " status=" + robotBaseInfo.robotStatus;
    }

    public final void x(@NotNull Context context, @NotNull String robotUin, @NotNull String troopUin, boolean isFriend) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (context instanceof QBaseActivity) {
            QRouteApi api = QRoute.api(ITroopUtilApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
            ((ITroopUtilApi) api).reportRobotProfile((QBaseActivity) context, robotUin, troopUin, isFriend);
        }
    }

    public final void y(@NotNull final Context context, @NotNull final String robotUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        QRouteApi api = QRoute.api(ITroopUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
        final ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) api;
        iTroopUtilApi.fetchRobotShareInfo(MobileQQ.sMobileQQ.peekAppRuntime(), robotUin, new com.tencent.mobileqq.troop.api.a() { // from class: com.tencent.robot.profile.utils.b
            @Override // com.tencent.mobileqq.troop.api.a
            public final void onResult(String str) {
                RobotProfileUtils.z(ITroopUtilApi.this, context, robotUin, str);
            }
        });
    }
}
