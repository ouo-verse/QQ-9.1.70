package com.tencent.mobileqq.troop.troopsetting.bizconfig;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskCacheRepo;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskRefreshDataEvent;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskRefreshUIEvent;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B!\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/q;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "task", "", "d0", "a0", "c0", "b0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "r", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "", ReportConstant.COSTREPORT_PREFIX, "Ljava/lang/String;", "troopUin", "", "t", "Z", "needRefreshOnResume", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskRefreshUIEvent;", "u", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "taskRefreshReceiver", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Ljava/lang/String;)V", "v", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class q extends x<x.b.d, x.c.g> {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QUIListItemAdapter adapter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean needRefreshOnResume;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SimpleEventReceiver<TroopOwnerTaskRefreshUIEvent> taskRefreshReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/q$a;", "", "", "REPORT_IS_RED_TIPS", "Ljava/lang/String;", "REPORT_ITEM_EM_ID", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.bizconfig.q$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/bizconfig/q$b", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskRefreshUIEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements SimpleEventReceiver<TroopOwnerTaskRefreshUIEvent> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<TroopOwnerTaskRefreshUIEvent>> getEventClass() {
            ArrayList<Class<TroopOwnerTaskRefreshUIEvent>> arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopOwnerTaskRefreshUIEvent.class);
                return arrayListOf;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            TroopOwnerTaskRefreshUIEvent troopOwnerTaskRefreshUIEvent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            if (event instanceof TroopOwnerTaskRefreshUIEvent) {
                troopOwnerTaskRefreshUIEvent = (TroopOwnerTaskRefreshUIEvent) event;
            } else {
                troopOwnerTaskRefreshUIEvent = null;
            }
            if (troopOwnerTaskRefreshUIEvent != null) {
                q qVar = q.this;
                if (Intrinsics.areEqual(((TroopOwnerTaskRefreshUIEvent) event).getTroopUin(), qVar.troopUin)) {
                    qVar.d0(troopOwnerTaskRefreshUIEvent.getTroopOwnerTask());
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull Context context, @Nullable QUIListItemAdapter qUIListItemAdapter, @NotNull String troopUin) {
        super(new x.b.d("\u7fa4\u4e3b\u4efb\u52a1"), new x.c.g("", false, false, 6, null));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qUIListItemAdapter, troopUin);
            return;
        }
        this.context = context;
        this.adapter = qUIListItemAdapter;
        this.troopUin = troopUin;
        this.taskRefreshReceiver = new b();
        e0(this, null, 1, null);
        x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.X(q.this, view);
            }
        });
        w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.p
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                q.Y(q.this, view);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this.taskRefreshReceiver);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).preloadWebProcess(appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(q this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(q this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        VideoReport.setElementId(it, "em_group_owner_task_entrance");
        VideoReport.setElementParam(it, "is_red_tips", Integer.valueOf(this$0.O().getShowRedPoint() ? 1 : 0));
    }

    public static /* synthetic */ void e0(q qVar, com.tencent.mobileqq.troop.troopownertask.api.impl.b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bVar = null;
        }
        qVar.d0(bVar);
    }

    public final void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
        com.tencent.mobileqq.troop.troopownertask.api.impl.b n3 = troopOwnerTaskCacheRepo.n(this.troopUin);
        com.tencent.mobileqq.troop.troopownertask.g gVar = com.tencent.mobileqq.troop.troopownertask.g.f301003a;
        gVar.i(this.context, n3.a());
        troopOwnerTaskCacheRepo.s();
        gVar.k(this.troopUin, n3);
        this.needRefreshOnResume = true;
    }

    public final void b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this.taskRefreshReceiver);
            this.taskRefreshReceiver = null;
        }
    }

    public final void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.needRefreshOnResume) {
            SimpleEventBus.getInstance().dispatchEvent(new TroopOwnerTaskRefreshDataEvent(this.troopUin));
            this.needRefreshOnResume = false;
        }
    }

    public final void d0(@Nullable com.tencent.mobileqq.troop.troopownertask.api.impl.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
            return;
        }
        if (task == null) {
            task = TroopOwnerTaskCacheRepo.f300970a.n(this.troopUin);
        }
        if (!TroopOwnerTaskCacheRepo.f300970a.c()) {
            if (task.c() > 0) {
                O().h("\u6709" + task.c() + "\u9879\u65b0\u4efb\u52a1");
            }
            O().g(true);
        } else {
            O().h("");
            O().g(false);
        }
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            qUIListItemAdapter.l0(this);
        }
    }
}
