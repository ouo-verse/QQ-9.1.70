package com.tencent.qqguild.directmessage.aio.title;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.title.GuildAioTitleViewModel;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.temp.api.IGuildMakeQQFriendApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.base.mvvm.AIOViewModel;
import com.tencent.qqguild.directmessage.aio.DirectMessageNodeUpdateEvent;
import com.tencent.qqguild.directmessage.aio.title.UIState;
import com.tencent.qqguild.directmessage.aio.title.a;
import com.tencent.qqnt.kernelgpro.nativeinterface.DirectSessionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ay;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0016\u0018\u0000 V2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0007J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020#H\u0016R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010&R\u001b\u00103\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b0\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010CR\u0014\u0010H\u001a\u00020E8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010MR\u0014\u0010O\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010MR\u0014\u0010P\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010MR\u0014\u0010S\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/TitleViewModel;", "Lcom/tencent/qqguild/base/mvvm/AIOViewModel;", "Lcom/tencent/qqguild/directmessage/aio/title/a;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Landroidx/lifecycle/LifecycleObserver;", "", "u", "L", "", "guildId", "H", HippyTKDListViewAdapter.X, "Lcom/tencent/qqguild/directmessage/aio/title/UIState$AddFriendState;", "state", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqguild/directmessage/aio/title/a$d;", "intent", "P", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "N", "com/tencent/qqguild/directmessage/aio/title/TitleViewModel$b", "w", "()Lcom/tencent/qqguild/directmessage/aio/title/TitleViewModel$b;", "Lcom/tencent/qqguild/base/mvvm/b;", "O", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "account", "onAccountChanged", "K", "", "onBackEvent", "e", "Ljava/lang/String;", "channelId", "f", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "nameUpdateListener", "i", "tinyId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "openId", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "()Lcom/tencent/qqguild/base/mvvm/b;", "onMessageEvent", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "D", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "E", "Lcom/tencent/qqguild/directmessage/aio/title/TitleViewModel$b;", "directSessionListener", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "directMsgNode", "G", "Z", "neverUpdateAddFriendUIState", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "firstUpdateAddFriendUIState", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "B", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", "igProSession", "()Ljava/lang/String;", "targetTinyId", "sourceGuildId", "sourceGuildName", "M", "()Z", "isRobot", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class TitleViewModel extends AIOViewModel<a, UIState> implements com.tencent.aio.api.runtime.emitter.a, com.tencent.mobileqq.guild.base.repository.a, LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy onMessageEvent;

    /* renamed from: D, reason: from kotlin metadata */
    private RuntimeServiceHolder serviceHolder;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b directSessionListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private DirectMessageNode directMsgNode;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean neverUpdateAddFriendUIState;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable firstUpdateAddFriendUIState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GPServiceObserver nameUpdateListener = N();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tinyId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String openId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001Jd\u0010\f\u001a\u00020\u000b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqguild/directmessage/aio/title/TitleViewModel$b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelDirectSessionListener;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "sortedGuildIdList", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/DirectSessionInfo;", "changedList", "deletedGuildIdList", "", "isAll", "", "onDirectSessionListChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements IKernelDirectSessionListener {
        b() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
        public /* synthetic */ void onCreateDirectSession(DirectSessionInfo directSessionInfo, int i3) {
            com.tencent.qqnt.kernelgpro.nativeinterface.a.a(this, directSessionInfo, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
        public void onDirectSessionListChanged(@Nullable ArrayList<String> sortedGuildIdList, @Nullable ArrayList<DirectSessionInfo> changedList, @Nullable ArrayList<String> deletedGuildIdList, boolean isAll) {
            if (deletedGuildIdList != null && deletedGuildIdList.contains(TitleViewModel.this.guildId)) {
                Logger logger = Logger.f235387a;
                TitleViewModel titleViewModel = TitleViewModel.this;
                logger.d().d("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "[onDirectSessionListChanged] deleted current:" + titleViewModel.guildId);
                TitleViewModel.this.updateUI(UIState.CloseCurrentPage.f345136f);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
        public /* synthetic */ void onDirectSwitchStatus(int i3) {
            com.tencent.qqnt.kernelgpro.nativeinterface.a.c(this, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
        public /* synthetic */ void onSetDirectSessionBlackStatus(DirectSessionInfo directSessionInfo, int i3) {
            com.tencent.qqnt.kernelgpro.nativeinterface.a.d(this, directSessionInfo, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/qqguild/directmessage/aio/title/TitleViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "notifyType", "", "onDirectMsgNotifyTypeChanged", "guildId", "channelId", "notifyStatus", "onPushDirectMsgNotifyUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onDirectMsgNotifyTypeChanged(@NotNull String tinyId, int notifyType) {
            TitleViewModel titleViewModel;
            DirectMessageNode directMessageNode;
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.AIO.DirectMessage-TitleViewModel", 2, "onDirectMsgNotifyTypeChanged(" + tinyId + ", " + notifyType + ")");
            }
            if (!Intrinsics.areEqual(tinyId, TitleViewModel.this.G())) {
                return;
            }
            TitleViewModel.this.updateUI(new UIState.NotifyTypeUpdate(notifyType));
            TitleViewModel titleViewModel2 = TitleViewModel.this;
            DirectMessageNode directMessageNode2 = titleViewModel2.directMsgNode;
            if (directMessageNode2 != null) {
                titleViewModel = titleViewModel2;
                directMessageNode = directMessageNode2.c((r32 & 1) != 0 ? directMessageNode2.guildId : null, (r32 & 2) != 0 ? directMessageNode2.channelId : null, (r32 & 4) != 0 ? directMessageNode2.notifyType : notifyType, (r32 & 8) != 0 ? directMessageNode2.source : null, (r32 & 16) != 0 ? directMessageNode2.eventTime : 0L, (r32 & 32) != 0 ? directMessageNode2.isInBlack : false, (r32 & 64) != 0 ? directMessageNode2.isVisible : false, (r32 & 128) != 0 ? directMessageNode2.draftIdentify : 0, (r32 & 256) != 0 ? directMessageNode2.memberType : 0, (r32 & 512) != 0 ? directMessageNode2.lastMessage : null, (r32 & 1024) != 0 ? directMessageNode2.unreadInfo : null, (r32 & 2048) != 0 ? directMessageNode2.draftInfo : null, (r32 & 4096) != 0 ? directMessageNode2._messageTime : 0L);
            } else {
                titleViewModel = titleViewModel2;
                directMessageNode = null;
            }
            titleViewModel.directMsgNode = directMessageNode;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushDirectMsgNotifyUpdate(@NotNull String guildId, @NotNull String channelId, int notifyStatus) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.AIO.DirectMessage-TitleViewModel", 2, "onPushDirectMsgNotifyUpdate(" + guildId + ", " + channelId + ", " + notifyStatus + ")");
            }
            if (!Intrinsics.areEqual(TitleViewModel.this.tinyId, TitleViewModel.this.G())) {
                return;
            }
            TitleViewModel.this.updateUI(new UIState.NotifyTypeUpdate(notifyStatus));
        }
    }

    public TitleViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqguild.base.mvvm.b>() { // from class: com.tencent.qqguild.directmessage.aio.title.TitleViewModel$onMessageEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.qqguild.base.mvvm.b invoke() {
                com.tencent.qqguild.base.mvvm.b O;
                O = TitleViewModel.this.O();
                return O;
            }
        });
        this.onMessageEvent = lazy;
        this.directSessionListener = w();
        this.neverUpdateAddFriendUIState = true;
        this.firstUpdateAddFriendUIState = new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.title.g
            @Override // java.lang.Runnable
            public final void run() {
                TitleViewModel.z(TitleViewModel.this);
            }
        };
    }

    private final IGProSession A() {
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            runtimeServiceHolder = null;
        }
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IGProSession.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IGProSession.class.getSimpleName() + ") calling...";
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return (IGProSession) runtimeServiceHolder.b("", IGProSession.class);
    }

    private final IGPSService B() {
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            runtimeServiceHolder = null;
        }
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...";
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return (IGPSService) runtimeServiceHolder.b("", IGPSService.class);
    }

    private final com.tencent.qqguild.base.mvvm.b C() {
        return (com.tencent.qqguild.base.mvvm.b) this.onMessageEvent.getValue();
    }

    private final String D() {
        MessageSource source;
        String guildId;
        DirectMessageNode C = DirectMessageNodeRepository.C(this.channelId);
        if (C == null || (source = C.getSource()) == null || (guildId = source.getGuildId()) == null) {
            return "";
        }
        return guildId;
    }

    private final String F() {
        MessageSource source;
        String guildName;
        DirectMessageNode C = DirectMessageNodeRepository.C(this.channelId);
        if (C == null || (source = C.getSource()) == null || (guildName = source.getGuildName()) == null) {
            return "";
        }
        return guildName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String G() {
        MessageSource source;
        String tinyId;
        DirectMessageNode C = DirectMessageNodeRepository.C(this.channelId);
        if (C == null || (source = C.getSource()) == null || (tinyId = source.getTinyId()) == null) {
            return "";
        }
        return tinyId;
    }

    private final void H(final String guildId) {
        QLog.i("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "AddFriend you are visitor. guildId=" + guildId);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).fetchAddGuildInfo(3, az.d(guildId, 0L), new wh2.a() { // from class: com.tencent.qqguild.directmessage.aio.title.i
            @Override // wh2.a
            public final void onResult(int i3, String str, String str2, String str3, String str4) {
                TitleViewModel.J(guildId, this, i3, str, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void J(String guildId, TitleViewModel this$0, int i3, String errMsg, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (i3 == 0) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getContext(), new JumpGuildParam(guildId, null, str3, str, str2), HardCodeUtil.qqStr(R.string.f147270wf), false, true);
            return;
        }
        QLog.w("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "fetchAddGuildInfo error, guildId:" + guildId + " errMsg:" + errMsg);
        QQToastUtil.showQQToast(0, errMsg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
        boolean z16;
        FragmentActivity activity;
        DirectMessageNode directMessageNode = this.directMsgNode;
        int i3 = 1;
        if (directMessageNode == null) {
            Logger.f235387a.d().i("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "[handleTitleRightClick] directMsgNode is null");
            return;
        }
        if (directMessageNode.getNotifyType() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 != null && (activity = c16.getActivity()) != null) {
            IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
            String guildId = directMessageNode.getGuildId();
            String guildId2 = directMessageNode.getSource().getGuildId();
            String channelId = directMessageNode.getChannelId();
            String tinyId = directMessageNode.getSource().getTinyId();
            if (M()) {
                i3 = 2;
            }
            iQQGuildRouterApi.openGuildDirectMessageDetailFragment(activity, guildId, guildId2, channelId, tinyId, i3, z16);
        }
    }

    private final boolean M() {
        DirectMessageNode C = DirectMessageNodeRepository.C(this.channelId);
        if (C == null || C.getMemberType() != 1) {
            return false;
        }
        return true;
    }

    private final GPServiceObserver N() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqguild.base.mvvm.b O() {
        return new com.tencent.qqguild.base.mvvm.b(new Function1<MsgIntent, Unit>() { // from class: com.tencent.qqguild.directmessage.aio.title.TitleViewModel$newMessageEventHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgIntent msgIntent) {
                invoke2(msgIntent);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MsgIntent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
                    TitleViewModel.this.updateUI(new UIState.TitleMultiSelectState(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode(), com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) TitleViewModel.this.getMContext())));
                } else if (intent instanceof DirectMessageNodeUpdateEvent) {
                    DirectMessageNodeUpdateEvent directMessageNodeUpdateEvent = (DirectMessageNodeUpdateEvent) intent;
                    TitleViewModel.this.updateUI(new UIState.TitleState(directMessageNodeUpdateEvent.getNickName(), directMessageNodeUpdateEvent.getNode().getSource().getGuildName(), directMessageNodeUpdateEvent.getNode().getNotifyType(), directMessageNodeUpdateEvent.getNode().getMemberType()));
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P(a.ToggleMultiSelect intent) {
        if (com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())) {
            FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
            if (activity == null) {
                return;
            }
            int d16 = com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext());
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            GuildAioTitleViewModel.INSTANCE.a(activity, com.tencent.guild.aio.util.a.b(g16), d16);
            activity.finish();
            return;
        }
        GuildMultiMsgManager.INSTANCE.a().p((com.tencent.aio.api.runtime.a) getMContext(), intent.getEnable(), "Guild.C2C.AIO.DirectMessage-TitleViewModel");
    }

    private final void Q(UIState.AddFriendState state) {
        this.neverUpdateAddFriendUIState = false;
        updateUI(state);
    }

    private final void u() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        final String D = D();
        String guildName = iGPSService.getGuildName(D);
        if (guildName == null) {
            guildName = F();
        }
        final String str = guildName;
        final String guildUserDisplayName = iGPSService.getGuildUserDisplayName(D, G());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "service.getGuildUserDisp\u2026me(guildId, targetTinyId)");
        final String guildUserDisplayName2 = iGPSService.getGuildUserDisplayName(D, iGPSService.getSelfTinyId());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName2, "service.getGuildUserDisp\u2026ldId, service.selfTinyId)");
        if (ch.j0(D)) {
            H(D);
            return;
        }
        QLog.i("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "AddFriend guildName: " + str + ", guildId:" + D + " openid:" + this.openId + " friendDefaultNickName:" + guildUserDisplayName);
        iGPSService.fetchAddGuildInfo(1, az.d(D, 0L), new wh2.a() { // from class: com.tencent.qqguild.directmessage.aio.title.h
            @Override // wh2.a
            public final void onResult(int i3, String str2, String str3, String str4, String str5) {
                TitleViewModel.v(TitleViewModel.this, D, str, guildUserDisplayName2, guildUserDisplayName, i3, str2, str3, str4, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v(TitleViewModel this$0, String guildId, String guildName, String selfName, String friendDefaultNickName, int i3, String errMsg, String str, String str2, String joinGuildSig) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(guildName, "$guildName");
        Intrinsics.checkNotNullParameter(selfName, "$selfName");
        Intrinsics.checkNotNullParameter(friendDefaultNickName, "$friendDefaultNickName");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        if (i3 == 0) {
            IGuildMakeQQFriendApi.a aVar = new IGuildMakeQQFriendApi.a();
            aVar.f235218a = joinGuildSig;
            aVar.f235219b = "1";
            aVar.f235220c = "1";
            aVar.f235221d = "1";
            aVar.f235222e = 1;
            aVar.f235223f = guildId;
            aVar.f235224g = guildName;
            aVar.f235225h = 6;
            aVar.f235226i = this$0.openId;
            aVar.f235227j = selfName;
            aVar.f235228k = friendDefaultNickName;
            aVar.f235229l = 3;
            ((IGuildMakeQQFriendApi) QRoute.api(IGuildMakeQQFriendApi.class)).makeQQFriend(((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getContext(), aVar);
            return;
        }
        QLog.w("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "fetchAddGuildInfo error, guildId:" + guildId + " errMsg:" + errMsg);
    }

    private final b w() {
        return new b();
    }

    private final void x() {
        if (this.neverUpdateAddFriendUIState) {
            getMMainHandler().postDelayed(this.firstUpdateAddFriendUIState, 500L);
        }
        B().fetchProfileAddFriendField(D(), G(), new ay() { // from class: com.tencent.qqguild.directmessage.aio.title.f
            @Override // wh2.ay
            public final void onFetchProfileAddFriendField(int i3, String str, String str2, boolean z16) {
                TitleViewModel.y(TitleViewModel.this, i3, str, str2, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(TitleViewModel this$0, int i3, String str, String openId, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.neverUpdateAddFriendUIState) {
            this$0.getMMainHandler().removeCallbacks(this$0.firstUpdateAddFriendUIState);
        }
        boolean z18 = false;
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fail to fetchProfileAddFriendField, result: " + i3 + ", errMsg: " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, (String) it.next(), null);
            }
            if (this$0.neverUpdateAddFriendUIState) {
                this$0.Q(new UIState.AddFriendState(false));
                return;
            }
            return;
        }
        Logger.f235387a.d().i("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "fetchProfileAddFriendField, openId: " + openId + ", isQQFriend: " + z16);
        Intrinsics.checkNotNullExpressionValue(openId, "openId");
        this$0.openId = openId;
        if (!z16) {
            if (openId.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 && !this$0.M()) {
                z18 = true;
            }
        }
        this$0.Q(new UIState.AddFriendState(z18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(TitleViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q(new UIState.AddFriendState(false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.ToggleMultiSelect) {
            P((a.ToggleMultiSelect) intent);
            return;
        }
        if (Intrinsics.areEqual(intent, a.b.f345145d)) {
            if (com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())) {
                updateUI(new UIState.TitleMultiSelectState(true, true));
            }
        } else if (Intrinsics.areEqual(intent, a.C9366a.f345144d)) {
            u();
        } else if (Intrinsics.areEqual(intent, a.c.f345146d)) {
            L();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        B().deleteObserver(this.nameUpdateListener);
        uh2.a gProDirectSessionService = A().getGProDirectSessionService();
        if (gProDirectSessionService != null) {
            gProDirectSessionService.removeKernelDirectSessionListener(this.directSessionListener);
        }
        this.serviceHolder = new RuntimeServiceHolder();
        B().addObserver(this.nameUpdateListener);
        uh2.a gProDirectSessionService2 = A().getGProDirectSessionService();
        if (gProDirectSessionService2 != null) {
            gProDirectSessionService2.addKernelDirectSessionListener(this.directSessionListener);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().i("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        B().deleteObserver(this.nameUpdateListener);
        uh2.a gProDirectSessionService = A().getGProDirectSessionService();
        if (gProDirectSessionService != null) {
            gProDirectSessionService.removeKernelDirectSessionListener(this.directSessionListener);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), C());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(DirectMessageNodeUpdateEvent.class).getQualifiedName(), C());
        AccountChangedNotifier.f214789d.d(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Logger.f235387a.d().i("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "onResume");
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        Logger.f235387a.d().i("Guild.C2C.AIO.DirectMessage-TitleViewModel", 1, "onCreate");
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        this.channelId = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = context.g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        this.guildId = com.tencent.guild.aio.util.a.g(g17);
        this.directMsgNode = DirectMessageNodeRepository.C(this.channelId);
        this.serviceHolder = new RuntimeServiceHolder();
        B().addObserver(this.nameUpdateListener);
        uh2.a gProDirectSessionService = A().getGProDirectSessionService();
        if (gProDirectSessionService != null) {
            gProDirectSessionService.addKernelDirectSessionListener(this.directSessionListener);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), C());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(DirectMessageNodeUpdateEvent.class).getQualifiedName(), C());
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        AccountChangedNotifier.f214789d.a(this);
    }
}
