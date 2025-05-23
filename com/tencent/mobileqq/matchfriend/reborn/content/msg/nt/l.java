package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerOnPostThemeChanged;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteEntryPart;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.i;
import com.tencent.mobileqq.matchfriend.reborn.drag.DragViewProviderPriority;
import com.tencent.mobileqq.matchfriend.reborn.drag.QQStrangerDragLayoutPart;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAChangedEvent;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.QQStrangerLIAClickHandlerProvider;
import com.tencent.mobileqq.matchfriend.reborn.mark.chatlist.QQStrangerInteractiveMarkChatListHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.b;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002+/\u0018\u0000 :2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001;B7\u0012\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020403\u0012\u0006\u00107\u001a\u000206\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u0018j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019`\u001aH\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "C0", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/i$a;", "uiEvent", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "lightInterActionView", "B0", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$b;", "viewParams", "d0", "onResume", "f0", "e0", "Lcom/tencent/qqnt/chats/core/uistate/b;", "uiState", "N", "Lcom/tencent/qqnt/chats/core/uievent/b;", "b", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "a0", "Z", "showLiteAction", "b0", "needRegisterReloadEvent", "c0", "_isResume", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/chatlist/QQStrangerInteractiveMarkChatListHelper;", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/chatlist/QQStrangerInteractiveMarkChatListHelper;", "interactiveMarkChatListHelper", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteEntryPart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteEntryPart;", "mLiteEntryPart", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l$c", "g0", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l$c;", "priorityDragViewProvider", "com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l$d", "h0", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l$d;", "userInfoChangeListener", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mViewModel", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;ZZ)V", "i0", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class l extends ChatsListVB implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final boolean showLiteAction;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final boolean needRegisterReloadEvent;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean _isResume;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerInteractiveMarkChatListHelper interactiveMarkChatListHelper;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerLiteEntryPart mLiteEntryPart;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private LIAAnimView lightInterActionView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final c priorityDragViewProvider;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final d userInfoChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l$b", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b;", "anim", "", "a", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.QQStrangerShowLightInterActionAnim f244700a;

        b(i.QQStrangerShowLightInterActionAnim qQStrangerShowLightInterActionAnim) {
            this.f244700a = qQStrangerShowLightInterActionAnim;
        }

        @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b.a
        public void a(com.tencent.qqnt.biz.lightbusiness.lightinteraction.b anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
        }

        @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b.a
        public void b(com.tencent.qqnt.biz.lightbusiness.lightinteraction.b anim) {
            Intrinsics.checkNotNullParameter(anim, "anim");
            anim.setOnAnimActionListener(null);
            anim.b(null);
            anim.a(null);
            com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.a a16 = QQStrangerLIAClickHandlerProvider.f245123a.a(this.f244700a.getAction().getType());
            if (a16 != null) {
                a16.a(this.f244700a.getAction(), new Contact(this.f244700a.getData().n(), this.f244700a.getData().k(), ""));
            }
            QLog.d("QQStrangerChatVB", 1, "[handleShowLIAAnimEvent] end to send msg");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l$c", "Lcom/tencent/mobileqq/matchfriend/reborn/drag/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/drag/DragViewProviderPriority;", "getPriority", "", "Landroid/view/View;", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements com.tencent.mobileqq.matchfriend.reborn.drag.a {
        c() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.drag.a
        public List<View> a() {
            RecentContactItemBinding y16;
            ArrayList arrayList = new ArrayList();
            RecyclerView.LayoutManager layoutManager = l.this.D().getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            l lVar = l.this;
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition != -1 && findLastCompletelyVisibleItemPosition != -1 && findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
                while (true) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = lVar.D().findViewHolderForAdapterPosition(findFirstCompletelyVisibleItemPosition);
                    RollingTextView rollingTextView = null;
                    RecentContactItemHolder recentContactItemHolder = findViewHolderForAdapterPosition instanceof RecentContactItemHolder ? (RecentContactItemHolder) findViewHolderForAdapterPosition : null;
                    if (recentContactItemHolder != null && (y16 = recentContactItemHolder.y()) != null) {
                        rollingTextView = y16.o();
                    }
                    if (rollingTextView != null && rollingTextView.isShown() && rollingTextView.getDragType() != -1) {
                        arrayList.add(rollingTextView);
                    }
                    if (findFirstCompletelyVisibleItemPosition == findLastCompletelyVisibleItemPosition) {
                        break;
                    }
                    findFirstCompletelyVisibleItemPosition++;
                }
            }
            return arrayList;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.drag.a
        public DragViewProviderPriority getPriority() {
            return DragViewProviderPriority.MSG_ITEM;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/l$d", "Lcom/tencent/mobileqq/matchfriend/api/d;", "", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "infoList", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements com.tencent.mobileqq.matchfriend.api.d {
        d() {
        }

        @Override // com.tencent.mobileqq.matchfriend.api.d
        public void a(List<QQStrangerUserInfo> infoList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(infoList, "infoList");
            l lVar = l.this;
            ArrayList arrayList = new ArrayList();
            List<QQStrangerUserInfo> list = infoList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(((QQStrangerUserInfo) it.next()).tinyId));
            }
            arrayList.addAll(arrayList2);
            lVar.e(new com.tencent.qqnt.chats.biz.qqstranger.c(arrayList));
        }
    }

    public /* synthetic */ l(com.tencent.qqnt.chats.core.mvi.a aVar, com.tencent.qqnt.chats.core.data.a aVar2, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, aVar2, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17);
    }

    private final void C0() {
        RecyclerView.LayoutManager layoutManager = D().getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() >= B().getItemCount() - 1) {
            a().n(a.o.f355022a);
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgAppBarExpendEvent(true));
        } else {
            a().n(a.n.f355021a);
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgAppBarExpendEvent(false));
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB, com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    /* renamed from: N */
    public void c(com.tencent.qqnt.chats.core.uistate.b uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        super.c(uiState);
        if (uiState instanceof a.b) {
            a.b bVar = (a.b) uiState;
            this.interactiveMarkChatListHelper.c(bVar.d());
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerOnChatListUIUpdateState(bVar.d()));
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB, com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    public void b(com.tencent.qqnt.chats.core.uievent.b uiEvent) {
        Intrinsics.checkNotNullParameter(uiEvent, "uiEvent");
        if (uiEvent instanceof i.QQStrangerShowLightInterActionAnim) {
            B0((i.QQStrangerShowLightInterActionAnim) uiEvent, this.lightInterActionView);
        } else {
            super.b(uiEvent);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void d0(ChatsListVB.b viewParams) {
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        super.d0(viewParams);
        if (this.showLiteAction) {
            n(this.mLiteEntryPart.L9(C()), 0);
        }
        this.lightInterActionView = viewParams.e();
        QQStrangerDragLayoutPart.INSTANCE.a(this.priorityDragViewProvider);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.interactiveMarkChatListHelper.f(104);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = appInterface != null ? (IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "") : null;
        if (iQQStrangerUserInfoMgr != null) {
            iQQStrangerUserInfoMgr.addUserInfoListener(this.userInfoChangeListener);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void e0() {
        super.e0();
        LIAAnimView lIAAnimView = this.lightInterActionView;
        if (lIAAnimView != null) {
            lIAAnimView.k();
        }
        this.mLiteEntryPart.M9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QQStrangerDragLayoutPart.INSTANCE.b(this.priorityDragViewProvider);
        o0(null);
        this.interactiveMarkChatListHelper.g();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = appInterface != null ? (IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "") : null;
        if (iQQStrangerUserInfoMgr != null) {
            iQQStrangerUserInfoMgr.removeUserInfoListener(this.userInfoChangeListener);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQStrangerInteractiveMarkUpdateEvent.class);
        arrayList.add(QQStrangerOnPostThemeChanged.class);
        arrayList.add(QQStrangerChatTopUpdateEvent.class);
        arrayList.add(QQStrangerScrollToNextUnreadEvent.class);
        arrayList.add(QQStrangerMsgScrollToTopEvent.class);
        if (this.needRegisterReloadEvent) {
            arrayList.add(QQStrangerReloadEvent.class);
        }
        arrayList.add(QQStrangerLIAChangedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        int collectionSizeOrDefault;
        if (event instanceof QQStrangerInteractiveMarkUpdateEvent) {
            c0(((QQStrangerInteractiveMarkUpdateEvent) event).getTinyIdList(), com.tencent.qqnt.chats.core.adapter.itemdata.payload.j.f354601a);
            return;
        }
        if (event instanceof QQStrangerOnPostThemeChanged) {
            ChatsColorCache.f355526a.q(C());
            b(a.i.f355014a);
            return;
        }
        if (event instanceof QQStrangerChatTopUpdateEvent) {
            QQStrangerChatTopUpdateEvent qQStrangerChatTopUpdateEvent = (QQStrangerChatTopUpdateEvent) event;
            e(new com.tencent.qqnt.chats.biz.qqstranger.d(qQStrangerChatTopUpdateEvent.getTinyId(), qQStrangerChatTopUpdateEvent.getIsTop()));
            return;
        }
        if (event instanceof QQStrangerScrollToNextUnreadEvent) {
            if (this._isResume) {
                C0();
                return;
            }
            return;
        }
        if (event instanceof QQStrangerMsgScrollToTopEvent) {
            if (this._isResume) {
                a().n(a.o.f355022a);
            }
        } else {
            if (event instanceof QQStrangerReloadEvent) {
                e(com.tencent.qqnt.chats.biz.qqstranger.b.f354386a);
                return;
            }
            if (event instanceof QQStrangerLIAChangedEvent) {
                List<Contact> contactList = ((QQStrangerLIAChangedEvent) event).getContactList();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(contactList, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = contactList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Contact) it.next()).peerUid);
                }
                c0(arrayList, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, com.tencent.qqnt.chats.core.data.a mBuilder, boolean z16, boolean z17) {
        super(mViewModel, mBuilder);
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        this.showLiteAction = z16;
        this.needRegisterReloadEvent = z17;
        this.interactiveMarkChatListHelper = new QQStrangerInteractiveMarkChatListHelper();
        this.mLiteEntryPart = new QQStrangerLiteEntryPart();
        this.priorityDragViewProvider = new c();
        this.userInfoChangeListener = new d();
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void f0() {
        this._isResume = false;
        super.f0();
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void onResume() {
        this._isResume = true;
        super.onResume();
    }

    private final void B0(i.QQStrangerShowLightInterActionAnim uiEvent, LIAAnimView lightInterActionView) {
        if (lightInterActionView != null) {
            if (lightInterActionView.r()) {
                lightInterActionView.v();
            }
            lightInterActionView.setOnAnimActionListener(new b(uiEvent));
            lightInterActionView.a(uiEvent.getBmp());
            lightInterActionView.b(uiEvent.getAvatarView());
            lightInterActionView.t();
        }
    }
}
