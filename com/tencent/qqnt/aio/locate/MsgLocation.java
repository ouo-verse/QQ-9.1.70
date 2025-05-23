package com.tencent.qqnt.aio.locate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.api.i;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.PendingTransition;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.nt.adapter.session.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.aio.locate.MsgLocation;
import com.tencent.qqnt.aio.locate.api.IMsgLocationApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0007J*\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0002J-\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J:\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016JJ\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/locate/MsgLocation;", "Lcom/tencent/qqnt/aio/locate/api/IMsgLocationApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "", "uin", "secondUin", "", AppConstants.Key.COLUMN_SHMSG_SEQ, "", "jumpToTargetGuildAIOPosition", "guildExtra", "openGuildAIOByStandalone", "", "type", "troopUin", "suspendGetDisplayName", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayNameInPeak", "uinType", "msgId", "jumpToTargetNTAIOPosition", "chatType", "peerUid", "TAG", "Ljava/lang/String;", "Lcom/tencent/qqnt/aio/locate/MsgLocation$a;", "SUB", "Lcom/tencent/qqnt/aio/locate/MsgLocation$a;", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MsgLocation implements IMsgLocationApi {
    public static final MsgLocation INSTANCE = new MsgLocation();
    private static final a SUB = new a();
    public static final String TAG = "MsgLocation";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/locate/MsgLocation$a;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends ExecutorCoroutineDispatcher {
        @Override // kotlinx.coroutines.CoroutineDispatcher
        /* renamed from: dispatch */
        public void mo2047dispatch(CoroutineContext context, Runnable block) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            getExecutor().execute(block);
        }

        @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
        public Executor getExecutor() {
            return new Executor() { // from class: com.tencent.qqnt.aio.locate.a
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    MsgLocation.a.c(runnable);
                }
            };
        }

        @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            QLog.d(MsgLocation.TAG, 1, "SubDispatcher close()");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Runnable runnable) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        }
    }

    MsgLocation() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDisplayNameInPeak(int type, String uin, String troopUin) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putString("uin", uin);
        bundle2.putInt("uintype", type);
        if (troopUin != null) {
            uin = troopUin;
        }
        bundle2.putString("troop_uin", uin);
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IPeakIpcModuleServer.NAME, "action_get_display_name", bundle2);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getDisplayNameInPeak " + (callServer != null ? Boolean.valueOf(callServer.isSuccess()) : null));
        }
        boolean z16 = false;
        if (callServer != null && callServer.isSuccess()) {
            z16 = true;
        }
        if (!z16 || (bundle = callServer.data) == null) {
            return null;
        }
        return bundle.getString("uinname");
    }

    @JvmStatic
    public static final void jumpToTargetGuildAIOPosition(Activity activity, Bundle bundle, String uin, String secondUin, long shmsgseq) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(uin, "uin");
        byte byteExtra = activity.getIntent().getByteExtra(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 0);
        int intExtra = activity.getIntent().getIntExtra("extra.GUILD_CHANNEL_PAGE_SOURCE_TYPE", 1);
        Bundle bundle2 = new Bundle();
        bundle2.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, byteExtra);
        bundle2.putLong("navigate_msg_seq", shmsgseq);
        if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
            INSTANCE.openGuildAIOByStandalone(activity, secondUin, uin, bundle2);
            return;
        }
        if (intExtra == 0) {
            INSTANCE.openGuildAIOByStandalone(activity, secondUin, uin, bundle2);
            return;
        }
        if (intExtra != 3) {
            LaunchGuildChatPieParam b16 = new LaunchGuildChatPieParam().b(uin);
            if (secondUin == null) {
                secondUin = "";
            }
            Intent guildChatPieIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(activity, b16.l(secondUin).k(bundle2).r(true).o(1).g(4).f(true).a());
            guildChatPieIntent.putExtras(bundle);
            activity.startActivity(guildChatPieIntent);
            return;
        }
        i b17 = new i().b(uin);
        if (secondUin == null) {
            secondUin = "";
        }
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatActivity(activity, b17.f(secondUin).e(bundle2).d(com.tencent.guild.aio.factory.a.class.getName()).a());
    }

    private final void openGuildAIOByStandalone(Activity activity, String secondUin, String uin, Bundle guildExtra) {
        IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
        JumpGuildParam jumpGuildParam = new JumpGuildParam(secondUin, uin);
        jumpGuildParam.getExtras().putAll(guildExtra);
        PendingTransition pendingTransition = new PendingTransition(R.anim.f154427o, R.anim.f154429q);
        Bundle extras = jumpGuildParam.extras;
        Intrinsics.checkNotNullExpressionValue(extras, "extras");
        pendingTransition.saveTo(extras);
        Unit unit = Unit.INSTANCE;
        iGuildMainFrameApi.gotoChannelDirectly(activity, jumpGuildParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object suspendGetDisplayName(int i3, String str, String str2, Continuation<? super String> continuation) {
        return BuildersKt.withContext(SUB, new MsgLocation$suspendGetDisplayName$2(str, str2, i3, null), continuation);
    }

    @Override // com.tencent.qqnt.aio.locate.api.IMsgLocationApi
    public void jumpToTargetNTAIOPosition(Activity activity, int uinType, String uin, String troopUin, long shmsgseq, long msgId) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        int l3 = c.l(uinType);
        if (c.e(uinType)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
            str = uidFromUin;
        } else if (TextUtils.isEmpty(troopUin)) {
            str = uin;
        } else {
            Intrinsics.checkNotNull(troopUin);
            str = troopUin;
        }
        jumpToTargetNTAIOPosition(activity, uinType, uin, troopUin, shmsgseq, msgId, l3, str);
    }

    @Override // com.tencent.qqnt.aio.locate.api.IMsgLocationApi
    public void jumpToTargetNTAIOPosition(Activity activity, int uinType, String uin, String troopUin, long shmsgseq, long msgId, int chatType, String peerUid) {
        Long longOrNull;
        Long longOrNull2;
        Long longOrNull3;
        String str = troopUin;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        String stringExtra = activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        boolean booleanExtra = activity.getIntent().getBooleanExtra("key_jump_form_history", false);
        QLog.i(TAG, 1, "jumpToTargetNTAIOPosition, className = " + stringExtra + ", shmsgseq = " + shmsgseq + ", msgId = " + msgId + ", uinType = " + uinType + ", uin = " + uin + ", troopUin = " + str);
        if (uinType == 10014) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("need_jump_to_msg", true);
            bundle.putLong(AppConstants.Key.KEY_SEARCHED_TIMEORSEQ, shmsgseq);
            bundle.putBoolean(AppConstants.Key.KEY_SEARCHED_UPDATE_SESSION, true);
            bundle.putBoolean("jump_from_shmsgseq", true);
            jumpToTargetGuildAIOPosition(activity, bundle, uin, troopUin, shmsgseq);
            return;
        }
        if (str == null) {
            str = "";
        }
        new com.tencent.relation.common.nt.data.a(uin, uinType, str);
        Bundle bundle2 = new Bundle();
        bundle2.putLong("key_navigate_msgid", msgId);
        bundle2.putLong("key_navigate_msgseq", shmsgseq);
        if (ChatActivity.class.getName().equals(stringExtra)) {
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            longOrNull3 = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
            iAIOStarterApi.navigateToAIOActivity(activity, chatType, peerUid, "", 67108864, longOrNull3 != null ? longOrNull3.longValue() : 0L, bundle2);
        } else if (booleanExtra) {
            IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
            iAIOStarterApi2.navigateToAIOActivity(activity, chatType, peerUid, "", longOrNull2 != null ? longOrNull2.longValue() : 0L, bundle2);
        } else {
            IAIOStarterApi iAIOStarterApi3 = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
            iAIOStarterApi3.navigateToAIO(activity, chatType, peerUid, "", longOrNull != null ? longOrNull.longValue() : 0L, bundle2);
        }
    }
}
