package com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.msg.service.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.announcement.detail.Param;
import com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\r\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000f\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/MessageListViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "", "p", "Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/MessageListViewModel$b;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "messages", "w", "com/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/MessageListViewModel$newRefreshAnnouncementObserver$1", "t", "()Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/MessageListViewModel$newRefreshAnnouncementObserver$1;", "u", "", "enable", "v", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "d", "Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "param", "Lcom/tencent/aio/data/AIOSession;", "e", "Lcom/tencent/aio/data/AIOSession;", "aioSession", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "f", "Ljava/util/List;", "emojiLikesList", "<init>", "()V", h.F, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MessageListViewModel extends com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Param param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIOSession aioSession;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MsgEmojiLikes> emojiLikesList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/MessageListViewModel$a;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "list1", "list2", "", "b", "FORCE_REFRESH", "Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b(List<MsgEmojiLikes> list1, List<MsgEmojiLikes> list2) {
            if (list1.size() != list2.size()) {
                return false;
            }
            int size = list1.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!qr0.c.l(list1.get(i3), list2.get(i3))) {
                    return false;
                }
            }
            return true;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e2\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/viewmodel/MessageListViewModel$b;", "", "", "result", "", "errMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "messages", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(int result, @NotNull String errMsg, @NotNull List<MsgRecord> messages);
    }

    public MessageListViewModel() {
        List<MsgEmojiLikes> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.emojiLikesList = emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        q(new b() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.c
            @Override // com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel.b
            public final void a(int i3, String str, List list) {
                MessageListViewModel.r(MessageListViewModel.this, i3, str, list);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(final b callback) {
        Logger.f235387a.d().i("Guild.ann.MessageListViewModel", 1, "fetchAnnouncement() isGuestMode: " + com.tencent.guild.aio.util.ex.a.j((com.tencent.aio.api.runtime.a) getMContext()));
        IGuildMsgApi iGuildMsgApi = (IGuildMsgApi) QRoute.api(IGuildMsgApi.class);
        Param param = this.param;
        Param param2 = null;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        String channelId = param.getChannelId();
        Param param3 = this.param;
        if (param3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param3 = null;
        }
        Contact contact = new Contact(4, channelId, param3.getGuildId());
        Param param4 = this.param;
        if (param4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            param2 = param4;
        }
        iGuildMsgApi.getAnnouncement(contact, param2.getMessageSeq(), com.tencent.guild.aio.util.ex.a.j((com.tencent.aio.api.runtime.a) getMContext()), new Function3<Integer, String, MsgRecord, Unit>() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel$fetchAnnouncement$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MsgRecord msgRecord) {
                invoke(num.intValue(), str, msgRecord);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String err, @Nullable MsgRecord msgRecord) {
                List<MsgRecord> listOfNotNull;
                Intrinsics.checkNotNullParameter(err, "err");
                MessageListViewModel.b bVar = MessageListViewModel.b.this;
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(msgRecord);
                bVar.a(i3, err, listOfNotNull);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MessageListViewModel messageListViewModel, int i3, String str, List<MsgRecord> list) {
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchAnnouncement failed: " + str + "(" + i3 + ")";
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.ann.MessageListViewModel", 1, (String) it.next(), null);
            }
            g.d(-1, R.string.f146140td, Integer.valueOf(i3));
            return;
        }
        Logger.f235387a.d().i("Guild.ann.MessageListViewModel", 1, "fetchAnnouncement success, messages: " + list);
        messageListViewModel.w(list);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel$newRefreshAnnouncementObserver$1] */
    private final MessageListViewModel$newRefreshAnnouncementObserver$1 t() {
        return new LifecycleObserver() { // from class: com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel$newRefreshAnnouncementObserver$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Logger.f235387a.d().i("Guild.ann.MessageListViewModel", 1, "onDestroy will remove observer");
                owner.getLifecycle().removeObserver(this);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onResume(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Logger.f235387a.d().i("Guild.ann.MessageListViewModel", 1, "onResume will fetch announcement");
                MessageListViewModel.this.p();
            }
        };
    }

    private final void u() {
        Logger.a d16 = Logger.f235387a.d();
        Param param = this.param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        String channelId = param.getChannelId();
        Param param2 = this.param;
        if (param2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param2 = null;
        }
        String guildId = param2.getGuildId();
        Param param3 = this.param;
        if (param3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param3 = null;
        }
        d16.i("Guild.ann.MessageListViewModel", 1, "registerEmojiUpdateListener() " + channelId + " / " + guildId + " / " + param3.getMessageSeq());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.x(), new MessageListViewModel$registerEmojiUpdateListener$2(this, null)), GuildAIODispatchers.f112358a.c()), vmScope());
    }

    private final void v(boolean enable) {
        ArrayList<Long> arrayList;
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            l lVar = l.f112634a;
            AIOSession aIOSession = this.aioSession;
            Param param = null;
            if (aIOSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioSession");
                aIOSession = null;
            }
            GProContact d16 = lVar.d(aIOSession);
            int hashCode = hashCode();
            if (enable) {
                Long[] lArr = new Long[1];
                Param param2 = this.param;
                if (param2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                } else {
                    param = param2;
                }
                lArr[0] = Long.valueOf(param.getMessageSeq());
                arrayList = CollectionsKt__CollectionsKt.arrayListOf(lArr);
            } else {
                arrayList = new ArrayList<>();
            }
            gProGuildMsgService.setCurOnScreenMsg(d16, hashCode, arrayList);
        }
    }

    private final void w(List<MsgRecord> messages) {
        int collectionSizeOrDefault;
        List<MsgRecord> list = messages;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            GuildMsgItem guildMsgItem = new GuildMsgItem((MsgRecord) it.next());
            guildMsgItem.saveExtInfoToExtStr("UNIQUE", String.valueOf(System.currentTimeMillis()));
            arrayList.add(guildMsgItem);
        }
        updateUI(new MsgListState(-1L, arrayList, 1, null, 8, null));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        v(false);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull at.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof com.tencent.mobileqq.guild.main.announcement.detail.aio.c) {
            Logger.f235387a.d().i("Guild.ann.MessageListViewModel", 1, "handleIntent " + intent);
            p();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Param b16;
        Intrinsics.checkNotNullParameter(context, "context");
        b16 = d.b(context);
        this.param = b16;
        this.aioSession = context.g().r();
        context.c().getLifecycle().addObserver(t());
        v(true);
        u();
    }
}
