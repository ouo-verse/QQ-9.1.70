package com.tencent.mobileqq.nearbypro.chats.part;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ca2.ChatsListInteractiveEntryModel;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.chats.event.NBPClearInteractiveRedNumberEvent;
import com.tencent.mobileqq.nearbypro.chats.event.NBPInteractivePushEvent;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.en;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u0015H\u0007J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0012\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030%0$H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListInteractiveEntryPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initView", "", WidgetCacheConstellationData.NUM, "W9", "(Ljava/lang/Integer;)V", "Lca2/a;", "data", "Q9", "", "nick", "type", "targetNick", "", "targetIsSelf", "M9", "N9", "Landroid/content/Context;", "ctx", "R9", "from", "U9", "L9", "K9", "V9", "context", "Landroid/view/View;", "S9", "O9", "T9", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Landroid/view/View;", "entryRootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "summaryView", "f", "timeView", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", h.F, "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "unreadView", "i", "I", "unreadCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lca2/a;", "cacheData", "Lcom/tencent/mobileqq/nearbypro/chats/repo/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/nearbypro/chats/repo/d;", "repo", "Lmqq/util/WeakReference;", "D", "Lmqq/util/WeakReference;", "wContext", "<init>", "()V", "E", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatsListInteractiveEntryPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.nearbypro.chats.repo.d repo = new com.tencent.mobileqq.nearbypro.chats.repo.d();

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeakReference<Context> wContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View entryRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView summaryView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView timeView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIBadge unreadView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int unreadCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChatsListInteractiveEntryModel cacheData;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListInteractiveEntryPart$a;", "", "", "a", "", "FEED_TYPE_COMMENT", "I", "FEED_TYPE_COMMENT_REPLY", "FEED_TYPE_PRAISE", "KEY_INTERACTIVE_ENTRY", "Ljava/lang/String;", "KEY_INTERACTIVE_ENTRY_CACHE_DATA", "KEY_INTERACTIVE_NUM", "NEARBY_AIO_LIST_CLEAR_MSG_EVENT", "TAG", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.chats.part.ChatsListInteractiveEntryPart$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return "nearbypro_key_interactive_num" + s.a();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K9() {
        return "nearbypro_key_interactive_entry_cache_data" + s.a();
    }

    private final String L9() {
        return "nearbypro_key_interactive_entry_show" + s.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String M9(String nick, int type, String targetNick, boolean targetIsSelf) {
        if (type != 51) {
            if (type != 52) {
                if (type != 62) {
                    return "";
                }
                return nick + " \u8d5e\u4e86\u4f60\u7684\u52a8\u6001";
            }
            if (targetIsSelf) {
                targetNick = "\u4f60";
            }
            return nick + " \u56de\u590d\u4e86" + targetNick + "\u7684\u8bc4\u8bba";
        }
        return nick + " \u8bc4\u8bba\u4e86\u4f60\u7684\u52a8\u6001";
    }

    private final void N9() {
        String str;
        try {
            ChatsListInteractiveEntryModel a16 = ChatsListInteractiveEntryModel.INSTANCE.a(c.a.g(j.d(), K9(), "", null, false, 12, null));
            this.cacheData = a16;
            Q9(a16);
            ga2.a c16 = j.c();
            ChatsListInteractiveEntryModel chatsListInteractiveEntryModel = this.cacheData;
            if (chatsListInteractiveEntryModel != null) {
                str = chatsListInteractiveEntryModel.getText();
            } else {
                str = null;
            }
            c16.e("ChatsListInteractiveEntryPart", "cache initCacheData: cacheData nick=" + str);
        } catch (Throwable th5) {
            j.c().d("ChatsListInteractiveEntryPart", "initCacheData: " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ChatsListInteractiveEntryPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        if (context != null) {
            this$0.R9(context);
            this$0.U9("click");
            com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a.a(this$0.entryRootView, "em_nearby_interactive_msg_en", null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(ChatsListInteractiveEntryModel data) {
        if (data == null) {
            return;
        }
        c.a.h(j.d(), L9(), true, null, false, 12, null);
        View view = this.entryRootView;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.timeView;
        if (textView != null) {
            textView.setText(en.r(new StringBuffer(25), data.getTime() * 1000, true, "", true));
        }
        TextView textView2 = this.summaryView;
        if (textView2 != null) {
            textView2.setCompoundDrawables(null, null, null, null);
        }
        TextView textView3 = this.summaryView;
        if (textView3 != null) {
            textView3.setText(data.getText());
        }
    }

    private final void R9(Context ctx) {
        String str;
        if (Intrinsics.areEqual(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102484", "0"), "1")) {
            str = "nbp_new_interactive&bundle_name=nearbypro";
        } else {
            str = "nearbypro_interactive_page";
        }
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(ctx, "mqqapi://kuikly/open?version=1&src_type=app&page_name=" + str + "&source=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(String from) {
        QUIBadge qUIBadge = this.unreadView;
        if (qUIBadge != null) {
            qUIBadge.setVisibility(8);
        }
        ((IQQKuiklyLocalConfig) QRoute.api(IQQKuiklyLocalConfig.class)).setString(INSTANCE.a(), "");
        j.c().c("ChatsListInteractiveEntryPart", "redViewHide: " + from);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        Context context;
        WeakReference<Context> weakReference = this.wContext;
        if (weakReference != null && (context = weakReference.get()) != null) {
            l.e(context, "NEARBY_AIO_LIST_CLEAR_MSG_EVENT", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.view.View] */
    public final void W9(Integer num) {
        QUIBadge qUIBadge;
        boolean z16;
        if (num != null) {
            num.intValue();
            this.unreadCount = num.intValue();
            QUIBadge qUIBadge2 = this.unreadView;
            if (qUIBadge2 != null) {
                qUIBadge2.setRedNum(num.intValue());
            }
            QUIBadge qUIBadge3 = this.unreadView;
            if (qUIBadge3 != null) {
                if (num.intValue() <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Boolean valueOf = Boolean.valueOf(z16);
                qUIBadge3.setVisibility(8);
                ?? r46 = (View) au.a(valueOf, qUIBadge3);
                if (r46 == 0) {
                    qUIBadge3.setVisibility(0);
                } else {
                    qUIBadge3 = r46;
                }
                qUIBadge = qUIBadge3;
            } else {
                qUIBadge = null;
            }
            if (qUIBadge != null) {
                return;
            }
        }
        QUIBadge qUIBadge4 = this.unreadView;
        if (qUIBadge4 != null) {
            qUIBadge4.setVisibility(8);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initView() {
        TextView textView;
        TextView textView2;
        View view = this.entryRootView;
        QUIBadge qUIBadge = null;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.zos);
        } else {
            textView = null;
        }
        this.summaryView = textView;
        View view2 = this.entryRootView;
        if (view2 != null) {
            textView2 = (TextView) view2.findViewById(R.id.zot);
        } else {
            textView2 = null;
        }
        this.timeView = textView2;
        View view3 = this.entryRootView;
        if (view3 != null) {
            qUIBadge = (QUIBadge) view3.findViewById(R.id.zor);
        }
        this.unreadView = qUIBadge;
        View view4 = this.entryRootView;
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.chats.part.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    ChatsListInteractiveEntryPart.P9(ChatsListInteractiveEntryPart.this, view5);
                }
            });
        }
        O9();
    }

    public final void O9() {
        final Integer intOrNull;
        if (c.a.a(j.d(), L9(), false, null, false, 12, null)) {
            View view = this.entryRootView;
            if (view != null) {
                view.setVisibility(0);
            }
            N9();
        }
        this.repo.g(new Function1<pp4.b, Unit>() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListInteractiveEntryPart$initEntryData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(pp4.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable pp4.b bVar) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                ChatsListInteractiveEntryModel chatsListInteractiveEntryModel;
                String c16;
                String K9;
                Unit unit = null;
                if (bVar != null) {
                    ChatsListInteractiveEntryPart chatsListInteractiveEntryPart = ChatsListInteractiveEntryPart.this;
                    textView = chatsListInteractiveEntryPart.summaryView;
                    String desc = "";
                    if (textView != null) {
                        textView.setText("");
                    }
                    textView2 = chatsListInteractiveEntryPart.summaryView;
                    if (textView2 != null) {
                        textView2.setCompoundDrawables(null, null, null, null);
                    }
                    textView3 = chatsListInteractiveEntryPart.timeView;
                    if (textView3 != null) {
                        textView3.setText("");
                    }
                    int i3 = bVar.f426966b;
                    if (i3 == 1) {
                        op4.e eVar = bVar.f426967c.f426976a;
                        String str = eVar.f423317d.f434143d;
                        Intrinsics.checkNotNullExpressionValue(str, "feed.fromUser.nick");
                        int i16 = eVar.f423316c;
                        String str2 = eVar.f423318e.f434143d;
                        Intrinsics.checkNotNullExpressionValue(str2, "feed.targetUser.nick");
                        desc = chatsListInteractiveEntryPart.M9(str, i16, str2, eVar.f423318e.f434140a == s.a());
                    } else if (i3 == 2) {
                        desc = bVar.f426967c.f426977b.f426973c;
                    } else if (i3 == 3) {
                        pp4.a aVar = bVar.f426967c.f426978c;
                        desc = aVar.f426961a + aVar.f426962b;
                    }
                    Intrinsics.checkNotNullExpressionValue(desc, "desc");
                    ChatsListInteractiveEntryModel chatsListInteractiveEntryModel2 = new ChatsListInteractiveEntryModel(desc, bVar.f426968d);
                    chatsListInteractiveEntryPart.cacheData = chatsListInteractiveEntryModel2;
                    chatsListInteractiveEntryPart.Q9(chatsListInteractiveEntryModel2);
                    chatsListInteractiveEntryModel = chatsListInteractiveEntryPart.cacheData;
                    if (chatsListInteractiveEntryModel != null && (c16 = chatsListInteractiveEntryModel.c()) != null) {
                        com.tencent.mobileqq.nearbypro.base.c d16 = j.d();
                        K9 = chatsListInteractiveEntryPart.K9();
                        c.a.m(d16, K9, c16, null, false, 12, null);
                    }
                    j.c().e("ChatsListInteractiveEntryPart", "repo interactiveEntry: msgType = " + bVar.f426966b + ", desc= " + desc);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    j.c().e("ChatsListInteractiveEntryPart", "repo interactiveEntry: is null");
                }
            }
        });
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(((IQQKuiklyLocalConfig) QRoute.api(IQQKuiklyLocalConfig.class)).getString(INSTANCE.a(), ""));
        W9(intOrNull);
        com.tencent.mobileqq.nearbypro.chats.repo.d.e(this.repo, false, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListInteractiveEntryPart$initEntryData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num) {
                ChatsListInteractiveEntryPart.this.W9(num);
                if (num != null && !Intrinsics.areEqual(num, intOrNull)) {
                    ((IQQKuiklyLocalConfig) QRoute.api(IQQKuiklyLocalConfig.class)).setString(ChatsListInteractiveEntryPart.INSTANCE.a(), num.toString());
                }
                j.c().e("ChatsListInteractiveEntryPart", "repo getUnreadMsg: unreadCount=" + num);
            }
        }, 1, null);
    }

    @SuppressLint({"InflateParams"})
    @Nullable
    public final View S9(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.wContext = new WeakReference<>(context);
        this.entryRootView = LayoutInflater.from(context).inflate(R.layout.fmq, (ViewGroup) null);
        initView();
        com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a.b(this.entryRootView, "em_nearby_interactive_msg_en", null);
        SimpleEventBus.getInstance().registerReceiver(this);
        return this.entryRootView;
    }

    public final void T9() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.wContext = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(NBPClearInteractiveRedNumberEvent.class);
        arrayList.add(NBPInteractivePushEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        if (event instanceof NBPClearInteractiveRedNumberEvent) {
            j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListInteractiveEntryPart$onReceiveEvent$1
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
                    com.tencent.mobileqq.nearbypro.chats.repo.d dVar;
                    dVar = ChatsListInteractiveEntryPart.this.repo;
                    final ChatsListInteractiveEntryPart chatsListInteractiveEntryPart = ChatsListInteractiveEntryPart.this;
                    dVar.i(new Function1<RspStatus, Unit>() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListInteractiveEntryPart$onReceiveEvent$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(RspStatus rspStatus) {
                            invoke2(rspStatus);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull RspStatus it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            j.c().e("ChatsListInteractiveEntryPart", "repo markAsReadRequest: success=" + it.c());
                            ChatsListInteractiveEntryPart.this.V9();
                        }
                    });
                    ChatsListInteractiveEntryPart.this.U9("NBPClearInteractiveRedNumberEvent");
                }
            });
        }
        if (event instanceof NBPInteractivePushEvent) {
            j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListInteractiveEntryPart$onReceiveEvent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ChatsListInteractiveEntryModel chatsListInteractiveEntryModel;
                    ChatsListInteractiveEntryModel chatsListInteractiveEntryModel2;
                    String c16;
                    String K9;
                    ChatsListInteractiveEntryPart.this.cacheData = ((NBPInteractivePushEvent) event).getModel();
                    ChatsListInteractiveEntryPart chatsListInteractiveEntryPart = ChatsListInteractiveEntryPart.this;
                    chatsListInteractiveEntryModel = chatsListInteractiveEntryPart.cacheData;
                    chatsListInteractiveEntryPart.Q9(chatsListInteractiveEntryModel);
                    chatsListInteractiveEntryModel2 = ChatsListInteractiveEntryPart.this.cacheData;
                    if (chatsListInteractiveEntryModel2 != null && (c16 = chatsListInteractiveEntryModel2.c()) != null) {
                        ChatsListInteractiveEntryPart chatsListInteractiveEntryPart2 = ChatsListInteractiveEntryPart.this;
                        com.tencent.mobileqq.nearbypro.base.c d16 = j.d();
                        K9 = chatsListInteractiveEntryPart2.K9();
                        c.a.m(d16, K9, c16, null, false, 12, null);
                    }
                    ChatsListInteractiveEntryPart.this.W9(Integer.valueOf(((NBPInteractivePushEvent) event).getUnreadNum()));
                    ((IQQKuiklyLocalConfig) QRoute.api(IQQKuiklyLocalConfig.class)).setString(ChatsListInteractiveEntryPart.INSTANCE.a(), String.valueOf(((NBPInteractivePushEvent) event).getUnreadNum()));
                    j.c().e("ChatsListInteractiveEntryPart", "NBPInteractivePushEvent: text=" + ((NBPInteractivePushEvent) event).getModel().getText() + ", unreadNum=" + ((NBPInteractivePushEvent) event).getUnreadNum());
                }
            });
        }
    }
}
