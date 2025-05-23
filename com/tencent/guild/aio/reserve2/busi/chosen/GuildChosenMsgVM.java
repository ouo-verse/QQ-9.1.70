package com.tencent.guild.aio.reserve2.busi.chosen;

import android.os.Handler;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgState;
import com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM;
import com.tencent.guild.aio.util.DataCompatTransformKt;
import com.tencent.guild.aio.util.apicompat.SuspendAipKt;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qq0.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0007*\u0001E\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001JB\u001d\u0012\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J#\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0015H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0013\u0010\u001b\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001e\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0016\u0010\u001f\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000fH\u0002J(\u0010'\u001a\u00020\u00062\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\r0$j\b\u0012\u0004\u0012\u00020\r`%2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020,H\u0002R \u00103\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010F\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006K"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "intent", "J", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "M", "N", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "downloadType", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lqq0/b$d;", "O", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "B", "", "y", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "L", "H", "", "msgSeq", "topMsgType", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "D", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState$GuildGetCurMsgUIState;", "state", "delayCheckAgain", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lpl3/a;", "Loq0/a;", "", "d", "Lpl3/a;", "showMenuUseCase", "e", "Ljava/util/List;", "mChosenMsgList", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "f", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "eventReceiver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", h.F, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observer", "i", "Z", "isChosenMsgReadyToShow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgState$GuildGetCurMsgUIState;", "getCurMsgUIState", "com/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgVM$b", "Lcom/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgVM$b;", "action", "<init>", "(Lpl3/a;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChosenMsgVM extends com.tencent.aio.base.mvvm.b<qq0.b, GuildChosenMsgState> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pl3.a<oq0.a, Object> showMenuUseCase;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends IGProTopMsg> mChosenMsgList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FlowEventReceiver eventReceiver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver observer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isChosenMsgReadyToShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildChosenMsgState.GuildGetCurMsgUIState getCurMsgUIState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(GuildChosenMsgVM this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isChosenMsgReadyToShow = true;
            GuildChosenMsgState.GuildGetCurMsgUIState guildGetCurMsgUIState = this$0.getCurMsgUIState;
            if (guildGetCurMsgUIState != null) {
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                QLog.i("GuildChosenMsgVM", 1, "LoadFirstPageFinEvent. update getCurMsgUIState. channelUin=" + com.tencent.guild.aio.util.a.b(g16));
                this$0.updateUI(guildGetCurMsgUIState);
                this$0.getCurMsgUIState = null;
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof GuildMsgListIntent.OnSkeletonHide) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final GuildChosenMsgVM guildChosenMsgVM = GuildChosenMsgVM.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildChosenMsgVM.b.b(GuildChosenMsgVM.this);
                    }
                });
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"com/tencent/guild/aio/reserve2/busi/chosen/GuildChosenMsgVM$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "fromTinyId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "Lkotlin/collections/ArrayList;", "topMsgList", "oldMsgList", "", "onChannelTopMsgUpdated", "onGuildListUpdated", "channelUin", "onChannelInfoUpdated", "tinyId", "onUserDisplayNameUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildChosenMsgVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.b(g16), channelUin)) {
                QLog.i("GuildChosenMsgVM", 1, "onChannelInfoUpdated channelUin=" + channelUin);
                GuildChosenMsgVM.this.N();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelTopMsgUpdated(@NotNull String guildId, @NotNull String channelId, @NotNull String fromTinyId, @NotNull ArrayList<IGProTopMsg> topMsgList, @NotNull ArrayList<IGProTopMsg> oldMsgList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(fromTinyId, "fromTinyId");
            Intrinsics.checkNotNullParameter(topMsgList, "topMsgList");
            Intrinsics.checkNotNullParameter(oldMsgList, "oldMsgList");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildChosenMsgVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                AIOParam g17 = ((com.tencent.aio.api.runtime.a) GuildChosenMsgVM.this.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
                if (TextUtils.equals(com.tencent.guild.aio.util.a.b(g17), channelId)) {
                    QLog.i("GuildChosenMsgVM", 1, "onChannelTopMsgUpdated guildId=" + guildId + " channelId=" + channelId + " chosenMsgSize=" + topMsgList.size());
                    GuildChosenMsgVM.this.N();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            QLog.i("GuildChosenMsgVM", 1, "onGuildListUpdated");
            GuildChosenMsgVM.this.N();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            GuildChosenMsgState.GuildUpdateNickNameUIState guildUpdateNickNameUIState;
            if (tinyId != null) {
                guildUpdateNickNameUIState = new GuildChosenMsgState.GuildUpdateNickNameUIState(tinyId);
            } else {
                guildUpdateNickNameUIState = null;
            }
            if (guildUpdateNickNameUIState != null) {
                GuildChosenMsgVM.this.updateUI(guildUpdateNickNameUIState);
            }
        }
    }

    public /* synthetic */ GuildChosenMsgVM(pl3.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new oq0.b() : aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A(MsgRecord msgRecord, int i3, Continuation<? super FileTransNotifyInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.B(), new GuildChosenMsgVM$downloadPic$2$1(cancellableContinuationImpl, msgRecord, null)), Dispatchers.getIO()), vmScope());
        if (i3 == 2) {
            com.tencent.guild.aio.reserve2.busi.chosen.view.a.f112232a.d(msgRecord);
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<IGProTopMsg> B() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        ArrayList<IGProTopMsg> arrayList;
        int collectionSizeOrDefault;
        boolean z16;
        IGProChannelInfo channelInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ArrayList arrayList2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j())) != null) {
            arrayList = channelInfo.getTopMsgList();
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList) {
                if (((IGProTopMsg) obj).getTopMsgSeq() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList3.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add((IGProTopMsg) it.next());
            }
            arrayList2 = arrayList4;
        }
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        QLog.i("GuildChosenMsgVM", 1, "fetchTopMsgSeqList=" + arrayList2 + " channelUin=" + com.tencent.guild.aio.util.a.b(g16));
        if (arrayList2 == null) {
            return new ArrayList();
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long msgSeq, int topMsgType) {
        Contact z16 = z();
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = z16.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
        String str2 = z16.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "contact.guildId");
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildChosenMsgVM$handleGetCurSelectedMsg$1(z16, msgSeq, iGuildChannelApi.isSelfGuest(str, str2), this, topMsgType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void D(ArrayList<MsgRecord> msgList, int topMsgType) {
        Object first;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) DataCompatTransformKt.h(msgList, topMsgType));
        GuildChosenMsgState.GuildGetCurMsgUIState guildGetCurMsgUIState = new GuildChosenMsgState.GuildGetCurMsgUIState((a) first);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (com.tencent.guild.aio.util.a.k(g16)) {
            F(guildGetCurMsgUIState, true);
        } else {
            updateUI(guildGetCurMsgUIState);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(final GuildChosenMsgState.GuildGetCurMsgUIState state, boolean delayCheckAgain) {
        i.g gVar;
        boolean z16;
        if (this.isChosenMsgReadyToShow) {
            updateUI(state);
            return;
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildMsgListIntent.GetSkeletonState.f110414d);
        boolean z17 = k3 instanceof i.g;
        i.g gVar2 = null;
        if (z17) {
            gVar = (i.g) k3;
        } else {
            gVar = null;
        }
        boolean z18 = false;
        if (gVar != null) {
            z16 = gVar.getIsShowing();
        } else {
            z16 = false;
        }
        if (z17) {
            gVar2 = (i.g) k3;
        }
        if (gVar2 != null) {
            z18 = gVar2.getIsMsgListEmpty();
        }
        if (!z18) {
            this.isChosenMsgReadyToShow = true;
            updateUI(state);
            return;
        }
        if (z16) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            QLog.i("GuildChosenMsgVM", 1, "[handleGetMsgResultForTextChannel] waiting for firstPageFinish, delay handle handleGetMsgResult. channelUin=" + com.tencent.guild.aio.util.a.b(g16));
            this.getCurMsgUIState = state;
            return;
        }
        if (delayCheckAgain) {
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            QLog.i("GuildChosenMsgVM", 1, "[handleGetMsgResultForTextChannel] delayCheckAgain. channelUin=" + com.tencent.guild.aio.util.a.b(g17));
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildChosenMsgVM.G(GuildChosenMsgVM.this, state);
                }
            }, 50L);
            return;
        }
        this.isChosenMsgReadyToShow = true;
        updateUI(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(GuildChosenMsgVM this$0, GuildChosenMsgState.GuildGetCurMsgUIState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.F(state, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void H(List<? extends IGProTopMsg> result) {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        GuildChosenMsgState.GuildInitListUIState guildInitListUIState = new GuildChosenMsgState.GuildInitListUIState(result, com.tencent.guild.aio.util.a.b(g16));
        this.mChosenMsgList = result;
        updateUI(guildInitListUIState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(final MsgRecord msgRecord, int downloadType) {
        if (downloadType == 2) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildChosenMsgVM$handleLoadPic$1(this, msgRecord, downloadType, null), 3, null);
            return;
        }
        MsgElement e16 = com.tencent.guild.aio.reserve2.busi.chosen.view.a.f112232a.e(msgRecord, 2);
        if (e16 != null) {
            GuildChatPicDownloader.f112420a.g(e16, PicSize.PIC_DOWNLOAD_THUMB, msgRecord, new Function1<FileTransNotifyInfo, Unit>() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$handleLoadPic$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                    invoke2(fileTransNotifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FileTransNotifyInfo trans) {
                    Intrinsics.checkNotNullParameter(trans, "trans");
                    this.updateUI(new GuildChosenMsgState.GuildUpdatePicIvUIState(MsgRecord.this.msgSeq, trans.filePath));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(final List<? extends IGProTopMsg> result) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<? extends IGProTopMsg> list = this.mChosenMsgList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((IGProTopMsg) it.next()).getTopMsgSeq()));
        }
        List<? extends IGProTopMsg> list2 = result;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Long.valueOf(((IGProTopMsg) it5.next()).getTopMsgSeq()));
        }
        com.tencent.guild.aio.util.ex.g.b(Boolean.valueOf(DataCompatTransformKt.c(arrayList2, arrayList)), new Function0<Unit>() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$handleUpdateResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List<IGProTopMsg> list3 = result;
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) this.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                GuildChosenMsgState.GuildUpdateListUIState guildUpdateListUIState = new GuildChosenMsgState.GuildUpdateListUIState(list3, com.tencent.guild.aio.util.a.b(g16));
                this.mChosenMsgList = result;
                this.updateUI(guildUpdateListUIState);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        QLog.i("GuildChosenMsgVM", 4, "initChannelChosenMsg===>channelUin:" + com.tencent.guild.aio.util.a.b(g16));
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildChosenMsgVM$initChannelChosenMsg$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void N() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        QLog.i("GuildChosenMsgVM", 4, "requestChosenMsg===>channelUin:" + com.tencent.guild.aio.util.a.b(g16));
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildChosenMsgVM$requestChosenMsgIfNeed$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O(b.d intent) {
        this.showMenuUseCase.a(new oq0.a(intent, (com.tencent.aio.api.runtime.a) getMContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object y(Continuation<? super Boolean> continuation) {
        GuildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1 guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.qqnt.msg.api.c cVar;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        if (continuation instanceof GuildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1) {
            guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1 = (GuildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1) continuation;
            int i16 = guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                    String g17 = com.tencent.guild.aio.util.a.g(g16);
                    AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
                    String b16 = com.tencent.guild.aio.util.a.b(g18);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    cVar = null;
                    if (peekAppRuntime instanceof AppInterface) {
                        appInterface = (AppInterface) peekAppRuntime;
                    } else {
                        appInterface = null;
                    }
                    if (appInterface != null) {
                        iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                    } else {
                        iRuntimeService = null;
                    }
                    IGPSService iGPSService = (IGPSService) iRuntimeService;
                    if (iGPSService != null) {
                        guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1.label = 1;
                        obj = SuspendAipKt.a(iGPSService, g17, b16, guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (cVar != null) {
                        if (!y.b(cVar.c()) || !((Boolean) cVar.a()).booleanValue()) {
                            z16 = false;
                        }
                        return Boxing.boxBoolean(z16);
                    }
                    return Boxing.boxBoolean(true);
                }
                cVar = (com.tencent.qqnt.msg.api.c) obj;
                if (cVar != null) {
                }
            }
        }
        guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1 = new GuildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1(this, continuation);
        Object obj2 = guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildChosenMsgVM$checkChannelChosenMsgCloseSuspend$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        cVar = (com.tencent.qqnt.msg.api.c) obj2;
        if (cVar != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Contact z() {
        Contact contact = new Contact();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        contact.chatType = com.tencent.guild.aio.util.a.e(g16);
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        contact.guildId = com.tencent.guild.aio.util.a.g(g17);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        contact.peerUid = com.tencent.guild.aio.util.a.b(g18);
        return contact;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull qq0.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.d) {
            O((b.d) intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        super.onDestroy();
        QLog.i("GuildChosenMsgVM", 4, "onCleared");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.observer);
        }
        this.eventReceiver.d();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonHide.class).getQualifiedName(), this.action);
        this.getCurMsgUIState = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.observer);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonHide.class).getQualifiedName(), this.action);
        this.isChosenMsgReadyToShow = false;
        this.getCurMsgUIState = null;
        this.eventReceiver.c(nq0.c.class, true, new GuildChosenMsgVM$onCreate$1(this, null));
        this.eventReceiver.c(nq0.a.class, true, new GuildChosenMsgVM$onCreate$2(this, null));
        this.eventReceiver.c(nq0.b.class, true, new GuildChosenMsgVM$onCreate$3(this, null));
        M();
    }

    public GuildChosenMsgVM(@NotNull pl3.a<oq0.a, Object> showMenuUseCase) {
        Intrinsics.checkNotNullParameter(showMenuUseCase, "showMenuUseCase");
        this.showMenuUseCase = showMenuUseCase;
        this.mChosenMsgList = new ArrayList();
        this.eventReceiver = new FlowEventReceiver(null, 1, null);
        this.observer = new c();
        this.action = new b();
    }
}
