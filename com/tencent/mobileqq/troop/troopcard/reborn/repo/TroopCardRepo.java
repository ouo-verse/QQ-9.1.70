package com.tencent.mobileqq.troop.troopcard.reborn.repo;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.m;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.a;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopMetaDreamGameInfo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.inner.compator.troopinfo.d;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupLatestEssenceListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberCommonInfo;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopBatchFetch;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troopmemberlist.datasync.e;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$RspBody;
import tencent.trpcprotocol.QunVideohubForwardProxyPB$GetCurrentLiveInfoReq;
import tencent.trpcprotocol.QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;
import trpc.mizarproto.passthrough.FunctionLockMsg$FunctionLockBeatRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\bQ\u0010RJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u0019\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J3\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020&2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010%J'\u0010+\u001a\u00020*2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010)\u001a\u0004\u0018\u00010(H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J5\u00100\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101JC\u00107\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00102\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u00010\u00022\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u000105H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J%\u0010:\u001a\u0002092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00103\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;J\u001f\u0010<\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010%J+\u0010>\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010?J\u001d\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010A\u001a\u00020@H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010DJ\u001d\u0010F\u001a\u00020E2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010%J\u001d\u0010H\u001a\u00020G2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010%J\u001f\u0010J\u001a\u0004\u0018\u00010I2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010%J\u001f\u0010L\u001a\u0004\u0018\u00010K2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010%J#\u0010O\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010P\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a;", "", "troopUin", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$a;", "con", "Lcom/tencent/qqnt/troopmemberlist/datasync/e;", "syncData", "", "v", "resp", "i", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "w", "", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "rsp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$b;", "Lcom/tencent/qqnt/bean/JoinTroopParam;", "param", "t", "Lcom/tencent/qqnt/kernel/api/s;", "p", "", "", "source", QQBrowserActivity.KEY_MSG_TYPE, "cookie", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/model/a;", "k", "(JIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ltencent/im/cs/cmd0x6ff/subcmd0x608/troop_member_distribute$RspBody;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$c;", "d", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "troopOwnerUin", "isMember", "from", "j", "(Ljava/lang/String;Ljava/lang/String;ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "statOption", "authKey", "authSig", "", "joinGroupTransInfo", "b", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$d;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/model/c;", DomainData.DOMAIN_NAME, "(JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;", "o", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ltencent/trpcprotocol/QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;", "l", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$e;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/troop/troopgame/data/TroopGameInfo;", "y", "Lcom/tencent/mobileqq/troop/troopgame/data/TroopMetaDreamGameInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "troopInfo", "newTroopName", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/mobileqq/data/troop/TroopInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopCardRepo implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo$a;", "", "", "CMD_MEMBER_DISTRIBUTION_STATISTIC", "Ljava/lang/String;", "", "FETCH_DIGEST_LIST_SOURCE_FORM_TROOP_CARD_INFO", "I", "KING_SOF_HONOR_APPID", "LIVE_STATUS_METHOD", "LIVE_STATUS_SERVICE", "TAG", "TROOP_DIGEST_ARK_MSG_TYPE", "TROOP_DIGEST_EMOJI_MSG_TYPE", "TROOP_DIGEST_FILE_MSG_TYPE", "TROOP_DIGEST_PIC_MSG_TYPE", "TROOP_DIGEST_TEXT_MSG_TYPE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "response", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b implements IGetGroupLatestEssenceListCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a> f299689a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a> continuation) {
            this.f299689a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupLatestEssenceListCallback
        public final void onResult(int i3, String errMsg, GetGroupLatestEssenceListRsp getGroupLatestEssenceListRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, getGroupLatestEssenceListRsp);
                return;
            }
            if (!com.tencent.qqnt.e.d(i3)) {
                QLog.e("TroopCardRepo", 1, "fetchDigestList getGroupLatestEssenceList result\uff1a " + i3 + " err: " + errMsg);
                Continuation<com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a> continuation = this.f299689a;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                continuation.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a(i3, errMsg, null)));
                return;
            }
            Continuation<com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a> continuation2 = this.f299689a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a(0, "", getGroupLatestEssenceListRsp)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo$c", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "successResponse", "", "b", "errorResponse", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f299690a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp f299691b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp> f299692c;

        /* JADX WARN: Multi-variable type inference failed */
        c(String str, QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp, CancellableContinuation<? super QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp> cancellableContinuation) {
            this.f299690a = str;
            this.f299691b = qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;
            this.f299692c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            QLog.e("TroopCardRepo", 1, "fetchLiveStatus error, troopUin=" + this.f299690a + ", errorCode=" + errorResponse.code + ", errorMsg=" + errorResponse.f293941msg);
            CancellableContinuation<QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp> cancellableContinuation = this.f299692c;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(this.f299691b));
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            try {
                QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp mergeFrom = new QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp().mergeFrom(successResponse.data);
                QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp2 = mergeFrom;
                QLog.i("TroopCardRepo", 1, "fetchLiveStatus troopUin=" + this.f299690a + ", isLiving=" + qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp2.is_living.get() + ", liveUrl=" + qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp2.living_detail_url.get());
                qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp = mergeFrom;
            } catch (Throwable th5) {
                QLog.e("TroopCardRepo", 1, "fetchLiveStatus error, troopUin=" + this.f299690a + ", e=" + th5.getMessage());
                qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp = this.f299691b;
            }
            this.f299692c.resumeWith(Result.m476constructorimpl(qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "isSuccess", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    static final class d implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f299693d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<troop_member_distribute$RspBody> f299694e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ troop_member_distribute$RspBody f299695f;

        /* JADX WARN: Multi-variable type inference failed */
        d(String str, CancellableContinuation<? super troop_member_distribute$RspBody> cancellableContinuation, troop_member_distribute$RspBody troop_member_distribute_rspbody) {
            this.f299693d = str;
            this.f299694e = cancellableContinuation;
            this.f299695f = troop_member_distribute_rspbody;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, cancellableContinuation, troop_member_distribute_rspbody);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            byte[] bArr;
            troop_member_distribute$RspBody troop_member_distribute_rspbody;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (!z16) {
                QLog.e("TroopCardRepo", 1, "fetchMemberDistribution, failed " + this.f299693d);
                CancellableContinuation<troop_member_distribute$RspBody> cancellableContinuation = this.f299694e;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(this.f299695f));
                return;
            }
            if (bundle != null) {
                bArr = bundle.getByteArray("data");
            } else {
                bArr = null;
            }
            if (bArr == null) {
                QLog.e("TroopCardRepo", 1, "fetchMemberDistribution, data is null " + this.f299693d);
                CancellableContinuation<troop_member_distribute$RspBody> cancellableContinuation2 = this.f299694e;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(this.f299695f));
                return;
            }
            try {
                troop_member_distribute_rspbody = new troop_member_distribute$RspBody().mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("TroopCardRepo", 1, "fetchMemberDistribution, error, e=" + e16.getMessage() + " " + this.f299693d);
                troop_member_distribute_rspbody = this.f299695f;
            }
            this.f299694e.resumeWith(Result.m476constructorimpl(troop_member_distribute_rspbody));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "response", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    static final class e implements IGetGroupLatestEssenceListCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<GetGroupLatestEssenceListRsp> f299696a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super GetGroupLatestEssenceListRsp> continuation) {
            this.f299696a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupLatestEssenceListCallback
        public final void onResult(int i3, String str, GetGroupLatestEssenceListRsp getGroupLatestEssenceListRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, getGroupLatestEssenceListRsp);
                return;
            }
            if (!com.tencent.qqnt.e.d(i3)) {
                QLog.e("TroopCardRepo", 1, "getGroupLatestEssenceList result\uff1a " + i3 + " err: " + str);
                this.f299696a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            this.f299696a.resumeWith(Result.m476constructorimpl(getGroupLatestEssenceListRsp));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0014J\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo$f", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "isSuccess", "", "noVerify", "", "troopUinResult", "userUin", "authKey", "highRiskTroop", "", "f", "g", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class f extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String I;
        final /* synthetic */ AppInterface J;
        final /* synthetic */ CancellableContinuation<a.d> K;

        /* JADX WARN: Multi-variable type inference failed */
        f(String str, AppInterface appInterface, CancellableContinuation<? super a.d> cancellableContinuation) {
            this.I = str;
            this.J = appInterface;
            this.K = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, appInterface, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void f(boolean isSuccess, int noVerify, @Nullable String troopUinResult, @Nullable String userUin, @Nullable String authKey, int highRiskTroop) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(noVerify), troopUinResult, userUin, authKey, Integer.valueOf(highRiskTroop));
                return;
            }
            if (!Intrinsics.areEqual(troopUinResult, this.I)) {
                return;
            }
            this.J.removeObserver(this);
            QLog.i("TroopCardRepo", 1, "onQueryJoinTroopCanNoVerify, isSuccess=" + isSuccess + ",highRiskTroop=" + highRiskTroop + ", noVerify=" + noVerify);
            if (isSuccess) {
                CancellableContinuation<a.d> cancellableContinuation = this.K;
                Result.Companion companion = Result.INSTANCE;
                if (highRiskTroop != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (noVerify == 1) {
                    z17 = true;
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new a.d(z16, z17)));
                return;
            }
            CancellableContinuation<a.d> cancellableContinuation2 = this.K;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new a.d(false, false)));
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void g(boolean isSuccess, @Nullable String troopUinResult, int highRiskTroop) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), troopUinResult, Integer.valueOf(highRiskTroop));
                return;
            }
            if (!Intrinsics.areEqual(troopUinResult, this.I)) {
                return;
            }
            QLog.i("TroopCardRepo", 1, "onQueryJoinTroopWhetherHighRisk, isSuccess=" + isSuccess + ",highRiskTroop=" + highRiskTroop);
            this.J.removeObserver(this);
            CancellableContinuation<a.d> cancellableContinuation = this.K;
            Result.Companion companion = Result.INSTANCE;
            if (!isSuccess || highRiskTroop == 0) {
                z16 = false;
            }
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new a.d(z16, false)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo$g", "Lcom/tencent/mobileqq/troop/troopgame/api/b;", "", "isSuccess", "", "troopUinResult", "Lcom/tencent/mobileqq/troop/troopgame/data/TroopGameInfo;", "gameInfo", "", "onGetTroopGameGameCard", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class g extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f299697d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppInterface f299698e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<TroopGameInfo> f299699f;

        /* JADX WARN: Multi-variable type inference failed */
        g(String str, AppInterface appInterface, CancellableContinuation<? super TroopGameInfo> cancellableContinuation) {
            this.f299697d = str;
            this.f299698e = appInterface;
            this.f299699f = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, appInterface, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onGetTroopGameGameCard(boolean isSuccess, @Nullable String troopUinResult, @Nullable TroopGameInfo gameInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUinResult, gameInfo);
                return;
            }
            if (!Intrinsics.areEqual(troopUinResult, this.f299697d)) {
                return;
            }
            QLog.i("TroopCardRepo", 1, "requestGameCardInfo, isSuccess=" + isSuccess);
            this.f299698e.removeObserver(this);
            this.f299699f.resumeWith(Result.m476constructorimpl(gameInfo));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo$h", "Lcom/tencent/mobileqq/troop/troopgame/api/b;", "", "isSuccess", "", "troopUinResult", "Lcom/tencent/mobileqq/troop/troopgame/data/TroopMetaDreamGameInfo;", "gameInfo", "", "onGetTroopGameMetaDreamCard", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class h extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f299700d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppInterface f299701e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<TroopMetaDreamGameInfo> f299702f;

        /* JADX WARN: Multi-variable type inference failed */
        h(String str, AppInterface appInterface, CancellableContinuation<? super TroopMetaDreamGameInfo> cancellableContinuation) {
            this.f299700d = str;
            this.f299701e = appInterface;
            this.f299702f = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, appInterface, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onGetTroopGameMetaDreamCard(boolean isSuccess, @Nullable String troopUinResult, @Nullable TroopMetaDreamGameInfo gameInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUinResult, gameInfo);
                return;
            }
            if (!Intrinsics.areEqual(troopUinResult, this.f299700d)) {
                return;
            }
            QLog.i("TroopCardRepo", 1, "requestMetaDreamGameCardInfo, isSuccess=" + isSuccess);
            this.f299701e.removeObserver(this);
            this.f299702f.resumeWith(Result.m476constructorimpl(gameInfo));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo$i", "Lcom/tencent/mobileqq/troop/api/observer/a;", "", "isSuc", "", "troopUinResult", "", "result", "errorMsg", "seq", "", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "picList", "", "onGetTroopAvatar", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class i extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f299703d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppInterface f299704e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<a.e> f299705f;

        /* JADX WARN: Multi-variable type inference failed */
        i(String str, AppInterface appInterface, CancellableContinuation<? super a.e> cancellableContinuation) {
            this.f299703d = str;
            this.f299704e = appInterface;
            this.f299705f = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, appInterface, cancellableContinuation);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.a
        public void onGetTroopAvatar(boolean isSuc, @Nullable String troopUinResult, int result, @Nullable String errorMsg, int seq, @Nullable List<TroopClipPic> picList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), troopUinResult, Integer.valueOf(result), errorMsg, Integer.valueOf(seq), picList);
                return;
            }
            if (!Intrinsics.areEqual(troopUinResult, this.f299703d)) {
                return;
            }
            if (picList != null) {
                i3 = picList.size();
            }
            QLog.i("TroopCardRepo", 1, "onGetTroopAvatar, isSuc=" + isSuc + ", result=" + result + ",errorMsg=" + errorMsg + ", picList.size=" + i3);
            this.f299704e.removeObserver(this);
            if (picList == null) {
                picList = new ArrayList<>();
                IRuntimeService runtimeService = this.f299704e.getRuntimeService(ITroopInfoService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026                        )");
                ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getAllPicFromDb(picList, ((ITroopInfoService) runtimeService).findTroopInfo(this.f299703d));
            }
            CancellableContinuation<a.e> cancellableContinuation = this.f299705f;
            Result.Companion companion = Result.INSTANCE;
            if (errorMsg == null) {
                errorMsg = "";
            }
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new a.e(isSuc, result, errorMsg, picList)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopCardRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a.C8792a i(String troopUin, com.tencent.qqnt.troopmemberlist.datasync.e resp) {
        return new a.C8792a(true, s(resp), w(troopUin, resp), x(resp));
    }

    private final Object k(long j3, int i3, int i16, String str, Continuation<? super com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        GetGroupLatestEssenceListReq getGroupLatestEssenceListReq = new GetGroupLatestEssenceListReq();
        getGroupLatestEssenceListReq.groupCode = j3;
        getGroupLatestEssenceListReq.source = i3;
        getGroupLatestEssenceListReq.msgType = i16;
        getGroupLatestEssenceListReq.pageCookie = str;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        s p16 = p();
        if (p16 != null) {
            p16.getGroupLatestEssenceList(getGroupLatestEssenceListReq, new b(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final s p() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getGroupService();
        }
        return null;
    }

    private final void q(GroupMemberExtListResult rsp) {
        TroopInfo troopInfo;
        QLog.i("TroopCardRepo", 1, "[handleTroopMemberLevelResp] groupCode:" + rsp.groupCode);
        if (rsp.groupCode == 0) {
            return;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
        long j3 = rsp.groupCode;
        if (iTroopInfoService != null) {
            troopInfo = iTroopInfoService.findTroopInfo(String.valueOf(j3));
        } else {
            troopInfo = null;
        }
        if (troopInfo != null) {
            final com.tencent.qqnt.inner.compator.troopinfo.d dVar = new com.tencent.qqnt.inner.compator.troopinfo.d();
            dVar.b(troopInfo);
            com.tencent.qqnt.inner.g.e(com.tencent.qqnt.inner.g.f357168a, rsp, troopInfo, false, 4, null);
            QLog.i("TroopCardRepo", 1, "handleTroopMemberLevelResp, " + j3 + ", sysFlag:" + rsp.sysShowFlag + ", userFlag:" + rsp.userShowFlag + ",newUserFlag:" + rsp.userShowFlagNew);
            dVar.a(troopInfo);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.repo.b
                @Override // java.lang.Runnable
                public final void run() {
                    TroopCardRepo.r(d.this);
                }
            }, 8, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(com.tencent.qqnt.inner.compator.troopinfo.d comparator) {
        Intrinsics.checkNotNullParameter(comparator, "$comparator");
        comparator.c();
    }

    private final boolean s(com.tencent.qqnt.troopmemberlist.datasync.e resp) {
        if (resp.k() != null && resp.l() == 72) {
            QLog.e("TroopCardRepo", 1, "isTroopDisBind true");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(final CancellableContinuation<? super a.b> con, JoinTroopParam param) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).joinGroup(param, null, "TroopCardRepo", new com.tencent.qqnt.troop.d() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.repo.c
            @Override // com.tencent.qqnt.troop.d
            public final void a(boolean z16, int i3, String str, com.tencent.qqnt.bean.c cVar) {
                TroopCardRepo.u(CancellableContinuation.this, z16, i3, str, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(CancellableContinuation con, boolean z16, int i3, String errMsg, com.tencent.qqnt.bean.c hint) {
        int i16;
        long j3;
        FunctionLockMsg$FunctionLockBeatRsp functionLockMsg$FunctionLockBeatRsp;
        Intrinsics.checkNotNullParameter(con, "$con");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(hint, "hint");
        QLog.i("TroopCardRepo", 1, "[joinGroup] isSuccess:" + z16 + ", result:" + i3 + ", errMsg:" + errMsg);
        com.tencent.qqnt.bean.e b16 = hint.b();
        if (b16 != null) {
            i16 = b16.a();
            j3 = b16.b();
        } else {
            i16 = 0;
            j3 = 0;
        }
        int i17 = i16;
        long j16 = j3;
        com.tencent.qqnt.bean.d a16 = hint.a();
        if (a16 != null) {
            functionLockMsg$FunctionLockBeatRsp = a16.a();
        } else {
            functionLockMsg$FunctionLockBeatRsp = null;
        }
        con.resumeWith(Result.m476constructorimpl(new a.b(z16, i3, i17, j16, functionLockMsg$FunctionLockBeatRsp)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String troopUin, CancellableContinuation<? super a.C8792a> con, com.tencent.qqnt.troopmemberlist.datasync.e syncData) {
        QLog.d("TroopCardRepo", 1, "[onBatchGetTroopInfoResp] isSuccess:" + syncData.n() + ", syncData:" + syncData);
        if (syncData.n()) {
            Result.Companion companion = Result.INSTANCE;
            con.resumeWith(Result.m476constructorimpl(i(troopUin, syncData)));
            GroupMemberExtListResult o16 = syncData.o();
            if (o16 != null) {
                q(o16);
                return;
            }
            return;
        }
        Result.Companion companion2 = Result.INSTANCE;
        con.resumeWith(Result.m476constructorimpl(new a.C8792a(false, s(syncData), new TroopInfo(troopUin), null, 8, null)));
    }

    private final TroopInfo w(String troopUin, com.tencent.qqnt.troopmemberlist.datasync.e resp) {
        if (resp.l() == 0 && resp.k() != null) {
            TroopInfo k3 = resp.k();
            if (k3 == null) {
                return new TroopInfo(troopUin);
            }
            return k3;
        }
        return new TroopInfo(troopUin);
    }

    private final List<String> x(com.tencent.qqnt.troopmemberlist.datasync.e resp) {
        int collectionSizeOrDefault;
        boolean z16;
        List<String> emptyList;
        GroupMemberCommonListResult m3 = resp.m();
        if (m3 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList<MemberCommonInfo> arrayList = m3.memberList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.memberList");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((MemberCommonInfo) obj).memberUin != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(String.valueOf(((MemberCommonInfo) it.next()).memberUin));
        }
        return arrayList3;
    }

    @Nullable
    public Object A(@Nullable String str, @NotNull Continuation<? super a.e> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "requestTroopAvatarList, troopUin=" + str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            com.tencent.mobileqq.troop.api.handler.b bVar = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                QLog.e("TroopCardRepo", 1, "requestTroopAvatarList, app == null");
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.e(false, -1, "", new ArrayList())));
            } else {
                Object businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAvatarHandlerName());
                if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.b) {
                    bVar = (com.tencent.mobileqq.troop.api.handler.b) businessHandler;
                }
                if (bVar == null) {
                    QLog.e("TroopCardRepo", 1, "requestTroopAvatarList, handler == null");
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.e(false, -1, "", new ArrayList())));
                } else {
                    appInterface.addObserver(new i(str, appInterface, cancellableContinuationImpl));
                    bVar.o2(str);
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) continuation);
    }

    @Nullable
    public Object B(@Nullable String str, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "requestTroopTags, troopUin=" + str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                QLog.e("TroopCardRepo", 1, "requestTroopTags, app == null");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
            } else {
                ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopTags(str, null, new Function2<Boolean, TroopInfo, Unit>(cancellableContinuationImpl) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo$requestTroopTags$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation<String> $con;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                        this.$con = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                        invoke(bool.booleanValue(), troopInfo);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull TroopInfo info) {
                        String str2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), info);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(info, "info");
                        QLog.i("TroopCardRepo", 1, "onGetTroopTagResult, isSuc=" + z16 + ", tags=" + info.mTags);
                        if (z16 && (str2 = info.mTags) != null) {
                            this.$con.resumeWith(Result.m476constructorimpl(str2));
                        } else {
                            this.$con.resumeWith(Result.m476constructorimpl(null));
                        }
                    }
                });
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) continuation);
    }

    @Nullable
    public Object C(@NotNull final TroopInfo troopInfo, @NotNull final String str, @NotNull Continuation<? super TroopInfo> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "updateTroopName, troopUin=" + troopInfo.getTroopUin() + ", newTroopName=" + str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                QLog.e("TroopCardRepo", 1, "updateTroopName, app == null");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(troopInfo));
            } else {
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyGroupName(troopInfo.getTroopUin(), str, null, "TroopCardRepo", new com.tencent.qqnt.troop.i(str, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo$updateTroopName$2$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f299707b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<TroopInfo> f299708c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.f299707b = str;
                        this.f299708c = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopInfo.this, str, cancellableContinuationImpl);
                        }
                    }

                    @Override // com.tencent.qqnt.troop.i
                    public final void onResult(boolean z16, int i3, @NotNull String errMsg) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                        QLog.i("TroopCardRepo", 1, "[updateTroopName], troopUin=" + TroopInfo.this.getTroopUin() + ", newName=" + this.f299707b + ", isSuccess=" + z16);
                        ThreadManager.getUIHandler().post(new Runnable(z16, TroopInfo.this, this.f299707b, this.f299708c) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo$updateTroopName$2$1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f299709d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ TroopInfo f299710e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ String f299711f;

                            /* renamed from: h, reason: collision with root package name */
                            final /* synthetic */ CancellableContinuation<TroopInfo> f299712h;

                            {
                                this.f299709d = z16;
                                this.f299710e = r6;
                                this.f299711f = r7;
                                this.f299712h = r8;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, Boolean.valueOf(z16), r6, r7, r8);
                                }
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (this.f299709d) {
                                    TroopInfo troopInfo2 = this.f299710e;
                                    troopInfo2.hasSetNewTroopName = true;
                                    troopInfo2.troopname = this.f299711f;
                                    if (troopInfo2.hasSetNewTroopHead) {
                                        troopInfo2.isNewTroop = false;
                                    }
                                    this.f299712h.resumeWith(Result.m476constructorimpl(troopInfo2));
                                }
                            }
                        });
                    }
                });
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 16, this, troopInfo, str, continuation);
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.repo.a
    @Nullable
    public Object a(@Nullable String str, @NotNull Continuation<? super TroopInfo> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) continuation);
        }
        if (!StringUtils.isNumeric(str)) {
            return null;
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new TroopCardRepo$fetchTroopInfoFromCachedOrDB$2(str, null), continuation);
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.repo.a
    @Nullable
    public Object b(@Nullable String str, int i3, @Nullable String str2, @Nullable String str3, @Nullable byte[] bArr, @NotNull Continuation<? super a.b> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "requestJoinTroop, statOption=" + i3);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            com.tencent.mobileqq.troop.api.handler.h hVar = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                QLog.e("TroopCardRepo", 1, "requestJoinTroop error, app = null");
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.b(false, -1, 0, 0L, null, 28, null)));
            } else {
                if (str == null || str.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    QLog.e("TroopCardRepo", 1, "requestJoinTroop error, uin = null");
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.b(false, -1, 0, 0L, null, 28, null)));
                } else {
                    Object businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
                    if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.h) {
                        hVar = (com.tencent.mobileqq.troop.api.handler.h) businessHandler;
                    }
                    if (hVar == null) {
                        QLog.e("TroopCardRepo", 1, "requestJoinTroop error, handler == null");
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.b(false, -1, 0, 0L, null, 28, null)));
                    } else {
                        JoinTroopParam joinTroopParam = new JoinTroopParam(str, i3, str2, str3);
                        joinTroopParam.g(bArr);
                        t(cancellableContinuationImpl, joinTroopParam);
                    }
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, str3, bArr, continuation);
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.repo.a
    @Nullable
    public Object c(@Nullable String str, @NotNull String str2, @NotNull Continuation<? super a.d> continuation) {
        Continuation intercepted;
        boolean z16;
        AppInterface appInterface;
        com.tencent.mobileqq.troop.api.handler.h hVar;
        Long l3;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            if (str2.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("TroopCardRepo", 1, "queryCanJoinTroopWithoutVerify, troopUin=" + str + ",authKey.isEmpty=" + z16);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Long l16 = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                QLog.e("TroopCardRepo", 1, "queryCanJoinTroopWithoutVerify, app == null");
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.d(false, false)));
            } else {
                String userUin = appInterface.getCurrentAccountUin();
                Object businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
                if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.h) {
                    hVar = (com.tencent.mobileqq.troop.api.handler.h) businessHandler;
                } else {
                    hVar = null;
                }
                if (str != null) {
                    l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                } else {
                    l3 = null;
                }
                if (userUin != null) {
                    Intrinsics.checkNotNullExpressionValue(userUin, "userUin");
                    l16 = StringsKt__StringNumberConversionsKt.toLongOrNull(userUin);
                }
                if (hVar != null && l3 != null && l16 != null) {
                    appInterface.addObserver(new f(str, appInterface, cancellableContinuationImpl));
                    hVar.v0(l3.longValue(), l16.longValue(), str2);
                } else {
                    QLog.e("TroopCardRepo", 1, "queryCanJoinTroopWithoutVerify, troopMngHandler == null");
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.d(false, false)));
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 7, this, str, str2, continuation);
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.repo.a
    @Nullable
    public Object d(@Nullable String str, @Nullable LifecycleOwner lifecycleOwner, @NotNull Continuation<? super a.c> continuation) {
        Continuation intercepted;
        Long l3;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "[fetchJoinTroopSettingForVisitor] troopUin:" + str);
            if (str != null) {
                l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            } else {
                l3 = null;
            }
            if (l3 == null) {
                QLog.e("TroopCardRepo", 1, "[fetchJoinTroopSettingForVisitor] failed, troopUin:" + str);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.c(false, null)));
            } else {
                final WeakReference weakReference = new WeakReference(cancellableContinuationImpl);
                TroopInfoRepo.INSTANCE.fetchTroopInfoForJoinTroop(str, "TroopCardRepo", lifecycleOwner, false, new Function2<Boolean, TroopInfo, Unit>(weakReference) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo$fetchJoinTroopSettingForVisitor$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ WeakReference<CancellableContinuation<a.c>> $conRef;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$conRef = weakReference;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) weakReference);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                        invoke(bool.booleanValue(), troopInfo);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull TroopInfo troopInfo) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), troopInfo);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
                        QLog.i("TroopCardRepo", 1, "[fetchJoinTroopSettingForVisitor], isSuccess=" + z16);
                        CancellableContinuation<a.c> cancellableContinuation = this.$conRef.get();
                        if (cancellableContinuation != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(new a.c(z16, troopInfo)));
                        }
                    }
                });
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 4, this, str, lifecycleOwner, continuation);
    }

    @Nullable
    public Object j(@Nullable final String str, @NotNull String str2, boolean z16, int i3, @NotNull Continuation<? super a.C8792a> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Long l3;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "fetchBatchTroopInfo, troopUin=" + str + ", isMember=" + z16 + MttLoader.QQBROWSER_PARAMS_FROME + i3);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.C8792a(false, false, new TroopInfo(str), null, 8, null)));
                QLog.i("TroopCardRepo", 1, "fetchBatchTroopInfo, app == null");
            } else {
                if (str != null) {
                    l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                } else {
                    l3 = null;
                }
                if (l3 == null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new a.C8792a(false, false, new TroopInfo(str), null, 8, null)));
                    QLog.e("TroopCardRepo", 1, "fetchBatchTroopInfo error, troopUinForLong=" + l3);
                } else {
                    TroopBatchFetch.c(str, z16, null, "TroopCardRepo", new Function1<com.tencent.qqnt.troopmemberlist.datasync.e, Unit>(str, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo$fetchBatchTroopInfo$2$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ CancellableContinuation<a.C8792a> $con;
                        final /* synthetic */ String $troopUin;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                            this.$troopUin = str;
                            this.$con = cancellableContinuationImpl;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, TroopCardRepo.this, str, cancellableContinuationImpl);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                            invoke2(eVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull e it) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            } else {
                                Intrinsics.checkNotNullParameter(it, "it");
                                TroopCardRepo.this.v(this.$troopUin, this.$con, it);
                            }
                        }
                    });
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 5, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r13);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object l(@Nullable String str, @NotNull Continuation<? super QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp> continuation) {
        Long longOrNull;
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) continuation);
        }
        QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp = new QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp();
        if (str != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            QunVideohubForwardProxyPB$GetCurrentLiveInfoReq qunVideohubForwardProxyPB$GetCurrentLiveInfoReq = new QunVideohubForwardProxyPB$GetCurrentLiveInfoReq();
            qunVideohubForwardProxyPB$GetCurrentLiveInfoReq.guin.set(longValue);
            qunVideohubForwardProxyPB$GetCurrentLiveInfoReq.fromid.set(5);
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.videohub_live_info_svr.VideohubLiveInfo", "/trpc.iqun.videohub_live_info_svr.VideohubLiveInfo/GetCurrentLiveInfo", qunVideohubForwardProxyPB$GetCurrentLiveInfoReq.toByteArray(), 1, null, new c(str, qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp, cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        QLog.e("TroopCardRepo", 1, "fetchLiveStatus error, troopUin=" + str);
        return qunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r8);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m(@Nullable String str, @NotNull Continuation<? super troop_member_distribute$RspBody> continuation) {
        Long longOrNull;
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) continuation);
        }
        troop_member_distribute$RspBody troop_member_distribute_rspbody = new troop_member_distribute$RspBody();
        troop_member_distribute_rspbody.uint32_result.set(-1);
        if (str != null && longOrNull != null) {
            long longValue = longOrNull.longValue();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                d dVar = new d(str, cancellableContinuationImpl, troop_member_distribute_rspbody);
                troop_member_distribute$ReqBody troop_member_distribute_reqbody = new troop_member_distribute$ReqBody();
                troop_member_distribute_reqbody.uint64_group_code.set(longValue);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApp(), m.class);
                newIntent.putExtra("cmd", "group_member_statistic.get_group_member_statistic");
                newIntent.putExtra("data", troop_member_distribute_reqbody.toByteArray());
                newIntent.setObserver(dVar);
                peekAppRuntime.startServlet(newIntent);
                Object result = cancellableContinuationImpl.getResult();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return result;
            }
            QLog.e("TroopCardRepo", 1, "fetchMemberDistribution, app is null " + str);
            return troop_member_distribute_rspbody;
        }
        QLog.e("TroopCardRepo", 1, "fetchMemberDistribution, troopUin is invalid " + str);
        return troop_member_distribute_rspbody;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object n(long j3, int i3, @NotNull String str, @NotNull Continuation<? super com.tencent.mobileqq.troop.troopcard.reborn.repo.model.c> continuation) {
        TroopCardRepo$fetchTroopDigestFileList$1 troopCardRepo$fetchTroopDigestFileList$1;
        Object coroutine_suspended;
        int i16;
        com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Integer.valueOf(i3), str, continuation);
        }
        if (continuation instanceof TroopCardRepo$fetchTroopDigestFileList$1) {
            troopCardRepo$fetchTroopDigestFileList$1 = (TroopCardRepo$fetchTroopDigestFileList$1) continuation;
            int i17 = troopCardRepo$fetchTroopDigestFileList$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                troopCardRepo$fetchTroopDigestFileList$1.label = i17 - Integer.MIN_VALUE;
                TroopCardRepo$fetchTroopDigestFileList$1 troopCardRepo$fetchTroopDigestFileList$12 = troopCardRepo$fetchTroopDigestFileList$1;
                Object obj = troopCardRepo$fetchTroopDigestFileList$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = troopCardRepo$fetchTroopDigestFileList$12.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    troopCardRepo$fetchTroopDigestFileList$12.label = 1;
                    obj = k(j3, i3, 4, str, troopCardRepo$fetchTroopDigestFileList$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                aVar = (com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a) obj;
                if (aVar.a() != 0 && aVar.c() != null) {
                    return new com.tencent.mobileqq.troop.troopcard.reborn.repo.model.c(0, "", com.tencent.mobileqq.troop.troopcard.reborn.repo.model.b.INSTANCE.a(aVar.c()));
                }
                return new com.tencent.mobileqq.troop.troopcard.reborn.repo.model.c(aVar.a(), aVar.b(), null);
            }
        }
        troopCardRepo$fetchTroopDigestFileList$1 = new TroopCardRepo$fetchTroopDigestFileList$1(this, continuation);
        TroopCardRepo$fetchTroopDigestFileList$1 troopCardRepo$fetchTroopDigestFileList$122 = troopCardRepo$fetchTroopDigestFileList$1;
        Object obj2 = troopCardRepo$fetchTroopDigestFileList$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = troopCardRepo$fetchTroopDigestFileList$122.label;
        if (i16 == 0) {
        }
        aVar = (com.tencent.mobileqq.troop.troopcard.reborn.repo.model.a) obj2;
        if (aVar.a() != 0) {
        }
        return new com.tencent.mobileqq.troop.troopcard.reborn.repo.model.c(aVar.a(), aVar.b(), null);
    }

    @Nullable
    public Object o(@NotNull GetGroupLatestEssenceListReq getGroupLatestEssenceListReq, @NotNull Continuation<? super GetGroupLatestEssenceListRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            s p16 = p();
            if (p16 != null) {
                p16.getGroupLatestEssenceList(getGroupLatestEssenceListReq, new e(safeContinuation));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 10, (Object) this, (Object) getGroupLatestEssenceListReq, (Object) continuation);
    }

    @Nullable
    public Object y(@Nullable String str, @NotNull Continuation<? super TroopGameInfo> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        com.tencent.mobileqq.troop.troopgame.api.a aVar;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "requestGameCardInfo, troopUin=" + str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                QLog.e("TroopCardRepo", 1, "requestGameCardInfo, app == null");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
            } else {
                Object businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
                if (businessHandler instanceof com.tencent.mobileqq.troop.troopgame.api.a) {
                    aVar = (com.tencent.mobileqq.troop.troopgame.api.a) businessHandler;
                } else {
                    aVar = null;
                }
                if (aVar == null) {
                    QLog.e("TroopCardRepo", 1, "requestGameCardInfo, gameHandler = null");
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
                } else {
                    appInterface.addObserver(new g(str, appInterface, cancellableContinuationImpl));
                    aVar.K(str);
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) continuation);
    }

    @Nullable
    public Object z(@Nullable String str, @NotNull Continuation<? super TroopMetaDreamGameInfo> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        com.tencent.mobileqq.troop.troopgame.api.a aVar;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QLog.i("TroopCardRepo", 1, "requestMetaDreamGameCardInfo, troopUin=" + str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                QLog.e("TroopCardRepo", 1, "requestMetaDreamGameCardInfo, app == null");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
            } else {
                Object businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
                if (businessHandler instanceof com.tencent.mobileqq.troop.troopgame.api.a) {
                    aVar = (com.tencent.mobileqq.troop.troopgame.api.a) businessHandler;
                } else {
                    aVar = null;
                }
                if (aVar == null) {
                    QLog.e("TroopCardRepo", 1, "requestMetaDreamGameCardInfo, gameHandler = null");
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
                } else {
                    appInterface.addObserver(new h(str, appInterface, cancellableContinuationImpl));
                    aVar.J(str);
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) continuation);
    }
}
