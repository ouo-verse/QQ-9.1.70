package com.tencent.guild.aio.msglist.welcome;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.welcome.GuildDirectWelcomeRobotComponent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotDataApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import tl.h;
import vn0.t;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010!\u001a\u00020\u0018\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0017\u0010!\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R&\u00102\u001a\u0012\u0012\u0004\u0012\u00020.0-j\b\u0012\u0004\u0012\u00020.`/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/guild/aio/msglist/welcome/GuildDirectWelcomeRobotComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/aio/msglist/welcome/GuildDirectRobotWelcomeMsgItem;", "message", "", "r1", "x1", "welcomeMsg", "", "q1", "p1", "v1", "u1", "w1", "", "index", "y1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lvn0/t;", h.F, "Lkotlin/Lazy;", "o1", "()Lvn0/t;", "binding", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "i", "getMGProService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "mGProService", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mGuildUrls", BdhLogUtil.LogTag.Tag_Conn, "I", "mGuildCount", "<init>", "(Landroid/view/View;)V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildDirectWelcomeRobotComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    private int mGuildCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGProService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> mGuildUrls;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J2\u0010\u000e\u001a\u00020\u00072\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/guild/aio/msglist/welcome/GuildDirectWelcomeRobotComponent$b", "Lvw1/c;", "Lxw1/b;", "", "errCode", "", "msg", "", "onError", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dataList", "", "params", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements vw1.c<xw1.b> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.data.msglist.a f112022b;

        b(com.tencent.aio.data.msglist.a aVar) {
            this.f112022b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(GuildDirectWelcomeRobotComponent this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
            this$0.u1((GuildDirectRobotWelcomeMsgItem) msgItem);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // vw1.c
        public void a(@Nullable ArrayList<xw1.b> dataList, @Nullable Object params) {
            GuildDirectWelcomeRobotComponent.this.mGuildCount = 0;
            if (params instanceof Integer) {
                GuildDirectWelcomeRobotComponent.this.mGuildCount = ((Number) params).intValue();
            }
            GuildDirectWelcomeRobotComponent.this.mGuildUrls.clear();
            Intrinsics.checkNotNull(dataList);
            Iterator<xw1.b> it = dataList.iterator();
            while (it.hasNext()) {
                xw1.b next = it.next();
                ArrayList arrayList = GuildDirectWelcomeRobotComponent.this.mGuildUrls;
                Intrinsics.checkNotNull(next);
                arrayList.add(next.a());
            }
            String robotName = ((GuildDirectRobotWelcomeMsgItem) this.f112022b).getRobotName();
            if (QLog.isColorLevel()) {
                QLog.d(GuildMsgItem.TAG, 1, "peerName = " + robotName);
            }
            LinearLayout linearLayout = GuildDirectWelcomeRobotComponent.this.o1().f442033h;
            final GuildDirectWelcomeRobotComponent guildDirectWelcomeRobotComponent = GuildDirectWelcomeRobotComponent.this;
            final com.tencent.aio.data.msglist.a aVar = this.f112022b;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.welcome.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildDirectWelcomeRobotComponent.b.c(GuildDirectWelcomeRobotComponent.this, aVar, view);
                }
            });
            GuildDirectWelcomeRobotComponent.this.x1();
        }

        @Override // vw1.c
        public void onError(int errCode, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(GuildMsgItem.TAG, 2, "getRobotCommonGuilds error with errCode:" + errCode + ", msg:" + msg2);
        }
    }

    public GuildDirectWelcomeRobotComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<t>() { // from class: com.tencent.guild.aio.msglist.welcome.GuildDirectWelcomeRobotComponent$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final t invoke() {
                return t.g(LayoutInflater.from(GuildDirectWelcomeRobotComponent.this.getRoot().getContext()));
            }
        });
        this.binding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.guild.aio.msglist.welcome.GuildDirectWelcomeRobotComponent$mGProService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGPSService invoke() {
                IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
                return (IGPSService) runtimeService;
            }
        });
        this.mGProService = lazy2;
        this.mGuildUrls = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final t o1() {
        return (t) this.binding.getValue();
    }

    private final CharSequence p1(GuildDirectRobotWelcomeMsgItem welcomeMsg) {
        String robotName = welcomeMsg.getRobotName();
        if (TextUtils.isEmpty(robotName)) {
            CharSequence text = this.root.getContext().getText(R.string.f153631cm);
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type kotlin.String");
            robotName = (String) text;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        CharSequence text2 = this.root.getContext().getText(R.string.f153671cq);
        Intrinsics.checkNotNull(text2, "null cannot be cast to non-null type kotlin.String");
        String format = String.format((String) text2, Arrays.copyOf(new Object[]{robotName}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final CharSequence q1(GuildDirectRobotWelcomeMsgItem welcomeMsg) {
        String robotName = welcomeMsg.getRobotName();
        if (TextUtils.isEmpty(robotName)) {
            CharSequence text = this.root.getContext().getText(R.string.f153631cm);
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type kotlin.String");
            return (String) text;
        }
        return robotName;
    }

    private final void r1(final GuildDirectRobotWelcomeMsgItem message) {
        o1().f442031f.setText(q1(message));
        o1().f442030e.setText(p1(message));
        o1().f442028c.setVisibility(0);
        o1().f442029d.setAvatarTinyId(message.getGuildId(), message.getRobotTid());
        o1().f442029d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.welcome.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildDirectWelcomeRobotComponent.s1(GuildDirectWelcomeRobotComponent.this, message, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(GuildDirectWelcomeRobotComponent this$0, GuildDirectRobotWelcomeMsgItem message, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.v1(message);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(GuildDirectRobotWelcomeMsgItem message) {
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openRobotCommonGuildFragment(message.getAioContext().c().getActivity(), message.getGuildId(), message.getChannelId(), message.getRobotTid(), "", 7, 2);
    }

    private final void v1(GuildDirectRobotWelcomeMsgItem welcomeMsg) {
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openRobotProfileCard(welcomeMsg.getAioContext().c().getActivity(), welcomeMsg.getGuildId(), welcomeMsg.getChannelId(), welcomeMsg.getRobotTid(), "", "6", true);
    }

    private final void w1() {
        URLDrawable uRLDrawable;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= this.mGuildUrls.size()) {
                break;
            }
            if (i3 >= 7) {
                o1().f442032g.getChildAt(6).setAlpha(0.5f);
                y1(i3 - 1);
                z16 = true;
                break;
            }
            Context context = this.root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "root.context");
            CircleBorderRoundImageView circleBorderRoundImageView = new CircleBorderRoundImageView(context);
            circleBorderRoundImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f)));
            if (i3 != 0) {
                circleBorderRoundImageView.setTranslationX(ViewUtils.dpToPx(i3 * (-4.0f)));
            }
            try {
                uRLDrawable = com.tencent.mobileqq.guild.robot.utils.a.a(this.mGuildUrls.get(i3), ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f), null, true, true);
            } catch (JSONException e16) {
                e16.printStackTrace();
                uRLDrawable = null;
            }
            circleBorderRoundImageView.setImageDrawable(uRLDrawable);
            o1().f442032g.addView(circleBorderRoundImageView);
            i3++;
        }
        if (z16) {
            o1().f442035j.setTranslationX(ViewUtils.dpToPx((i3 + 1) * (-4.0f)));
        } else {
            o1().f442035j.setTranslationX(ViewUtils.dpToPx(i3 * (-4.0f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        CharSequence text = this.root.getContext().getText(R.string.f153621cl);
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type kotlin.String");
        String format = String.format((String) text, Arrays.copyOf(new Object[]{Integer.valueOf(this.mGuildCount)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        o1().f442034i.setText(format);
        o1().f442032g.removeAllViews();
        if (this.mGuildUrls.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildDirectWelcomeRobotComponent", 2, "mGuildUrls size is 0");
            }
            o1().f442035j.setTranslationX(0.0f);
            o1().f442032g.setVisibility(8);
            return;
        }
        o1().f442032g.setVisibility(0);
        w1();
    }

    private final void y1(int index) {
        RoundImageView roundImageView = new RoundImageView(this.root.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        layoutParams.gravity = 17;
        roundImageView.setLayoutParams(layoutParams);
        roundImageView.setTranslationX(ViewUtils.dpToPx((index * (-4.0f)) - 16.0f));
        roundImageView.setImageDrawable(ContextCompat.getDrawable(this.root.getContext(), R.drawable.guild_robot_common_guild_more));
        o1().f442032g.addView(roundImageView);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(msgItem instanceof GuildDirectRobotWelcomeMsgItem)) {
            QLog.e("GuildDirectWelcomeRobotComponent", 1, "bind, msgItem = " + msgItem.getClass());
            return;
        }
        GuildDirectRobotWelcomeMsgItem guildDirectRobotWelcomeMsgItem = (GuildDirectRobotWelcomeMsgItem) msgItem;
        r1(guildDirectRobotWelcomeMsgItem);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ((IGuildRobotDataApi) QRoute.api(IGuildRobotDataApi.class)).getRobotCommonGuilds((AppInterface) peekAppRuntime, guildDirectRobotWelcomeMsgItem.getRobotTid(), new b(msgItem));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        LinearLayout linearLayout = o1().f442027b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.container");
        return linearLayout;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
