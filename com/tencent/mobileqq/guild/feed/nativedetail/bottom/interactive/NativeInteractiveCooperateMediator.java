package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive;

import android.view.View;
import androidx.annotation.UiThread;
import androidx.core.util.Supplier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailInteractiveEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalCommentsUpdatedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalPreferUpdatedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DataChangedState;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;
import yl1.n;
import yl1.o;
import zp1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00018B\u001b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010*\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\b5\u00106J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0003J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001cH\u0003J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001eH\u0003J\b\u0010 \u001a\u00020\bH\u0007J\b\u0010!\u001a\u00020\bH\u0007J\u001a\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010%\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'`(H\u0016R\u0016\u0010-\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/NativeInteractiveCooperateMediator;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lwk1/c;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "w", "", "sourceTag", "", ReportConstant.COSTREPORT_PREFIX, "", "args", DomainData.DOMAIN_NAME, "o", "", "interactiveType", "u", "j", "Ltl1/g$l;", "r", "feedId", "commentCount", "i", "", "v", "Lcom/tencent/mobileqq/guild/feed/event/GuildDetailViewDestroyEvent;", "event", "l", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedExternalPreferUpdatedEvent;", "k", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShareChannelEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "action", "msg", "c", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "d", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Lwk1/h;", "e", "Lwk1/h;", "inputContext", "f", "Z", "isNeedNotifyExternalComment", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Lwk1/h;)V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NativeInteractiveCooperateMediator implements SimpleEventReceiver<SimpleBaseEvent>, wk1.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IPartHost partHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.h inputContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedNotifyExternalComment;

    public NativeInteractiveCooperateMediator(@Nullable IPartHost iPartHost, @NotNull wk1.h inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.partHost = iPartHost;
        this.inputContext = inputContext;
    }

    private final void i(String feedId, int commentCount) {
        QLog.d("NativeInteractiveCooperateMediator", 1, "[handleCommentContentChange] commentCount=" + commentCount);
        bl.c().b(new GuildFeedExternalCommentsUpdatedEvent(feedId, commentCount), true);
    }

    private final void j(Object args) {
        Object obj;
        if (!(args instanceof g.OnDataListChangedMessage)) {
            return;
        }
        g.OnDataListChangedMessage onDataListChangedMessage = (g.OnDataListChangedMessage) args;
        QLog.i("NativeInteractiveCooperateMediator", 1, "handleDataListChangedMessage, source=" + onDataListChangedMessage.getChangedSource() + ", payload=" + onDataListChangedMessage.getPayload());
        r(onDataListChangedMessage);
        if (!v(onDataListChangedMessage)) {
            return;
        }
        Iterator<T> it = onDataListChangedMessage.b().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((hl1.g) obj) instanceof FeedDetailMainData) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        hl1.g gVar = (hl1.g) obj;
        if (gVar != null) {
            this.inputContext.getDelegate().lh("message_on_bottom_interactive_changed", ((FeedDetailMainData) gVar).getBottomInteractiveDisplayable());
        }
    }

    @UiThread
    private final void k(GuildFeedExternalPreferUpdatedEvent event) {
        FeedDetailMainData w3;
        GProStFeed gProStFeed;
        if (Intrinsics.areEqual(event.getFeedId(), this.inputContext.getFeedId()) && (w3 = w()) != null) {
            Object a16 = w3.getFeedDetail().a();
            if (a16 instanceof GProStFeed) {
                gProStFeed = (GProStFeed) a16;
            } else {
                gProStFeed = null;
            }
            if (gProStFeed != null) {
                gProStFeed.externalLikeUserList = event.getPreferList();
            }
            wk1.i delegate = this.inputContext.getDelegate();
            a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = new a.ModifyBottomInteractiveDataMessage(null, true, null, null, null, null, 61, null);
            modifyBottomInteractiveDataMessage.h(event.getFeedId());
            modifyBottomInteractiveDataMessage.i(Integer.valueOf(event.getPreferCountWithoutLike()));
            Unit unit = Unit.INSTANCE;
            delegate.lh("message_modify_bottom_interact_data", modifyBottomInteractiveDataMessage);
        }
    }

    @UiThread
    private final void l(GuildDetailViewDestroyEvent event) {
        if (Intrinsics.areEqual(event.getFeedId(), this.inputContext.getFeedId()) && w() != null) {
            wk1.i delegate = this.inputContext.getDelegate();
            a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = new a.ModifyBottomInteractiveDataMessage(null, true, null, null, null, null, 61, null);
            modifyBottomInteractiveDataMessage.j(Integer.valueOf(event.getPreferStatus()));
            modifyBottomInteractiveDataMessage.i(Integer.valueOf(event.getPreferCount()));
            modifyBottomInteractiveDataMessage.g(Integer.valueOf(event.getCommentCount()));
            modifyBottomInteractiveDataMessage.k(Integer.valueOf(event.getShareCount()));
            Unit unit = Unit.INSTANCE;
            delegate.lh("message_modify_bottom_interact_data", modifyBottomInteractiveDataMessage);
        }
    }

    @UiThread
    private final void m(GuildFeedShareChannelEvent event) {
        FeedDetailMainData w3;
        if (Intrinsics.areEqual(event.feedId, this.inputContext.getFeedId()) && (w3 = w()) != null) {
            int d16 = w3.getBottomInteractiveDisplayable().d() + event.getShareCount();
            wk1.i delegate = this.inputContext.getDelegate();
            a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = new a.ModifyBottomInteractiveDataMessage(null, true, null, null, null, null, 61, null);
            modifyBottomInteractiveDataMessage.k(Integer.valueOf(d16));
            Unit unit = Unit.INSTANCE;
            delegate.lh("message_modify_bottom_interact_data", modifyBottomInteractiveDataMessage);
        }
    }

    private final void n(Object args) {
        if ((args instanceof a.OnDoPreferMessage) && ((a.OnDoPreferMessage) args).getNewPreferStatus() == 1) {
            s("do prefer");
            u(1);
        }
    }

    private final void o(Object args) {
        View view;
        FeedDetailMainData w3 = w();
        if (w3 != null) {
            final qj1.h feedDetail = w3.getFeedDetail();
            IocPromise ioc = RFWIocAbilityProvider.g().getIoc(zp1.a.class);
            if (args instanceof View) {
                view = (View) args;
            } else {
                view = null;
            }
            ioc.originView(view).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.g
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    NativeInteractiveCooperateMediator.p(qj1.h.this, (zp1.a) obj);
                }
            }).run();
            u(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(qj1.h feedDetail, zp1.a aVar) {
        Intrinsics.checkNotNullParameter(feedDetail, "$feedDetail");
        if (aVar == null) {
            aVar = null;
        }
        zp1.a aVar2 = aVar;
        if (aVar2 != null) {
            a.C11708a.a(aVar2, -1, feedDetail, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.h
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Map q16;
                    q16 = NativeInteractiveCooperateMediator.q();
                    return q16;
                }
            }, 0, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map q() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    private final void r(g.OnDataListChangedMessage args) {
        if (args.getChangedSource() == 16) {
            QLog.d("NativeInteractiveCooperateMediator", 4, "[markerCommentContentChange]");
            this.isNeedNotifyExternalComment = true;
        }
    }

    private final void s(final String sourceTag) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.f
            @Override // java.lang.Runnable
            public final void run() {
                NativeInteractiveCooperateMediator.t(NativeInteractiveCooperateMediator.this, sourceTag);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(NativeInteractiveCooperateMediator this$0, String sourceTag) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sourceTag, "$sourceTag");
        com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), this$0.inputContext.getGuildId(), sourceTag);
    }

    private final void u(int interactiveType) {
        Object I2 = this.inputContext.getDelegate().I2("action_get_detail_channel_extension_info", null);
        Intrinsics.checkNotNull(I2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.utils.NativeDetailContentMessage.FeedDetailChannelExtensionInfoMessage");
        g.FeedDetailChannelExtensionInfoMessage feedDetailChannelExtensionInfoMessage = (g.FeedDetailChannelExtensionInfoMessage) I2;
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDetailInteractiveEvent().setBusinessType(feedDetailChannelExtensionInfoMessage.getBusinessType()).setInteractiveType(interactiveType).setChannelExtensionInfo(feedDetailChannelExtensionInfoMessage.getExtensionInfo()).setSearchExtensionInfo(feedDetailChannelExtensionInfoMessage.getSearchExtensionInfo()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        if (r0 == false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:0: B:32:0x0063->B:45:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean v(g.OnDataListChangedMessage args) {
        boolean z16;
        boolean z17;
        List list;
        boolean z18;
        boolean contains;
        if (args.getChangedSource() == 1) {
            Object payload = args.getPayload();
            if (payload instanceof List) {
                list = (List) payload;
            } else {
                list = null;
            }
            if (list != null) {
                contains = CollectionsKt___CollectionsKt.contains(list, "main_changed_payload_db_response");
                if (contains) {
                    z18 = true;
                }
            }
            z18 = false;
        }
        if (args.getChangedSource() != 16 || !Intrinsics.areEqual(args.getPayload(), Boolean.TRUE)) {
            if (args.getChangedSource() != 15) {
                return false;
            }
            if (args.getPayload() instanceof List) {
                Iterable iterable = (Iterable) args.getPayload();
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    for (Object obj : iterable) {
                        if (obj instanceof DataChangedState) {
                            DataChangedState dataChangedState = (DataChangedState) obj;
                            if (dataChangedState.getDataChangedSource() == 1 && dataChangedState.getPayload() == null) {
                                z16 = true;
                                if (!z16) {
                                    z17 = true;
                                    break;
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                    return false;
                }
            }
        }
        return true;
    }

    private final FeedDetailMainData w() {
        Object I2 = this.inputContext.getDelegate().I2("action_get_detail_main_data", null);
        Intrinsics.checkNotNull(I2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.utils.NativeDetailContentMessage.OnGetFeedDetailMainDataMessage");
        FeedDetailMainData feedDetailMainData = ((g.OnGetFeedDetailMainDataMessage) I2).getFeedDetailMainData();
        if (feedDetailMainData == null) {
            QLog.e(o.f450625a.a(), 1, "tryGetFeedMainData is null");
        }
        return feedDetailMainData;
    }

    @Override // wk1.j
    public void c(@NotNull String action, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(action, "action");
        switch (action.hashCode()) {
            case -1571406538:
                if (action.equals("message_share_feed")) {
                    if (bn.f223895a.d(n.q(GuildSplitViewUtils.f235370a.h(this.partHost)))) {
                        return;
                    }
                    o(msg2);
                    return;
                }
                return;
            case -738605245:
                if (action.equals("message_on_comment_completed") && (msg2 instanceof a.OnCommentCompletedMessage) && ((a.OnCommentCompletedMessage) msg2).getIsSuccess()) {
                    s("do comment or reply");
                    return;
                }
                return;
            case -527176932:
                if (action.equals("message_on_do_prefer")) {
                    n(msg2);
                    return;
                }
                return;
            case 390249661:
                if (action.equals("message_comment_request_operation_result") && (msg2 instanceof a.CommentRequestOperationResult)) {
                    a.CommentRequestOperationResult commentRequestOperationResult = (a.CommentRequestOperationResult) msg2;
                    if (commentRequestOperationResult.getIsSuccess() && commentRequestOperationResult.getOperationMessage().getOperation() == 2) {
                        s("do comment or reply");
                        return;
                    }
                    return;
                }
                return;
            case 1047580686:
                if (action.equals("message_on_reply_completed") && (msg2 instanceof a.OnReplyCommentCompletedMessage) && ((a.OnReplyCommentCompletedMessage) msg2).getIsSuccess()) {
                    s("do comment or reply");
                    return;
                }
                return;
            case 1157992528:
                if (action.equals("message_data_list_changed")) {
                    j(msg2);
                    return;
                }
                return;
            case 1751847274:
                if (action.equals("message_reply_request_operation") && (msg2 instanceof a.ReplyRequestOperationResult)) {
                    a.ReplyRequestOperationResult replyRequestOperationResult = (a.ReplyRequestOperationResult) msg2;
                    if (replyRequestOperationResult.getIsSuccess() && replyRequestOperationResult.getOperationMessage().getOperation() == 2) {
                        s("do comment or reply");
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildDetailViewDestroyEvent.class, GuildFeedExternalPreferUpdatedEvent.class, GuildFeedShareChannelEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        GProStFeed gProStFeed;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        FeedDetailMainData w3 = w();
        if (w3 == null) {
            return;
        }
        bl.c().b(new GuildDetailViewDestroyEvent(w3.getFeedDetail().getFeedId(), w3.getBottomInteractiveDisplayable().getCommentCount(), w3.getBottomInteractiveDisplayable().e(), w3.getBottomInteractiveDisplayable().getPreferStatus(), w3.getBottomInteractiveDisplayable().d()), true);
        i(w3.getFeedDetail().getFeedId(), w3.getBottomInteractiveDisplayable().getCommentCount());
        Object a16 = w3.getFeedDetail().a();
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed != null) {
            String feedId = w3.getFeedDetail().getFeedId();
            ArrayList<GProStUser> arrayList = gProStFeed.externalLikeUserList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.externalLikeUserList");
            bl.c().b(new GuildFeedExternalPreferUpdatedEvent(feedId, arrayList, w3.getBottomInteractiveDisplayable().e()), true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildFeedShareChannelEvent) {
            m((GuildFeedShareChannelEvent) event);
        } else if (event instanceof GuildDetailViewDestroyEvent) {
            l((GuildDetailViewDestroyEvent) event);
        } else if (event instanceof GuildFeedExternalPreferUpdatedEvent) {
            k((GuildFeedExternalPreferUpdatedEvent) event);
        }
    }

    public /* synthetic */ NativeInteractiveCooperateMediator(IPartHost iPartHost, wk1.h hVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iPartHost, hVar);
    }
}
