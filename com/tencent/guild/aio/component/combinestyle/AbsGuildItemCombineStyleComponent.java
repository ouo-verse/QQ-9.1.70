package com.tencent.guild.aio.component.combinestyle;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.combinestyle.ac;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\b&\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001TB\u000f\u0012\u0006\u00101\u001a\u00020\u0003\u00a2\u0006\u0004\bR\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J&\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\u0018H&J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\tH\u0014J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\tH\u0014J\u001a\u0010$\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u000bH\u0016R\u0017\u00101\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u00109\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u00106\u001a\u0004\b7\u00108R\u001b\u0010=\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u0010AR\"\u0010G\u001a\u00020\u00038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bC\u0010.\u001a\u0004\bD\u00100\"\u0004\bE\u0010FR\u001b\u0010J\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u00106\u001a\u0004\bI\u00100R$\u0010Q\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P\u00a8\u0006U"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/AbsGuildItemCombineStyleComponent;", "Lcom/tencent/guild/aio/component/combinestyle/AbsGuildMediaStyleComponent;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "Landroid/view/View;", "R1", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "Q1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "P1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/guild/aio/component/combinestyle/GuildItemStyleMsgItem;", "Lcom/tencent/guild/aio/component/combinestyle/i;", "X1", "Y1", "", "w1", "currentMsgItem", "z1", "A1", "", "roleColor", "tinyId", "N0", "msgItemNickName", "getNickName", "Landroid/app/Activity;", "getActivity", "resId", UserInfo.SEX_FEMALE, "k0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lkotlin/Lazy;", "U1", "()I", "defaultTextColor", "G", "W1", "()Landroid/widget/TextView;", "textView", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "H", "V1", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "iv", "I", "S1", "Z1", "(Landroid/view/View;)V", "bgContainer", "J", "T1", "contentView", "K", "Lcom/tencent/guild/aio/component/combinestyle/i;", "getGuildMediaAioCombineStyleChain", "()Lcom/tencent/guild/aio/component/combinestyle/i;", "setGuildMediaAioCombineStyleChain", "(Lcom/tencent/guild/aio/component/combinestyle/i;)V", "guildMediaAioCombineStyleChain", "<init>", "L", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class AbsGuildItemCombineStyleComponent extends AbsGuildMediaStyleComponent implements aa {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultTextColor;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy textView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy iv;

    /* renamed from: I, reason: from kotlin metadata */
    public View bgContainer;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain;

    public AbsGuildItemCombineStyleComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        Context context = root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.guild.aio.component.combinestyle.AbsGuildItemCombineStyleComponent$defaultTextColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(AbsGuildItemCombineStyleComponent.this.getContext().getResources().getColor(R.color.bpx));
            }
        });
        this.defaultTextColor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.component.combinestyle.AbsGuildItemCombineStyleComponent$textView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView Q1;
                AbsGuildItemCombineStyleComponent absGuildItemCombineStyleComponent = AbsGuildItemCombineStyleComponent.this;
                Q1 = absGuildItemCombineStyleComponent.Q1(absGuildItemCombineStyleComponent.getContext());
                return Q1;
            }
        });
        this.textView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guild.aio.component.combinestyle.AbsGuildItemCombineStyleComponent$iv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildUserAvatarView invoke() {
                GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(AbsGuildItemCombineStyleComponent.this.getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ae.d(), ae.d());
                layoutParams.gravity = 48;
                layoutParams.topMargin = ViewUtils.dip2px(0.5f);
                guildUserAvatarView.setLayoutParams(layoutParams);
                return guildUserAvatarView;
            }
        });
        this.iv = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guild.aio.component.combinestyle.AbsGuildItemCombineStyleComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View R1;
                R1 = AbsGuildItemCombineStyleComponent.this.R1();
                return R1;
            }
        });
        this.contentView = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(View.OnClickListener itClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itClick, "$itClick");
        itClick.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N1(View.OnLongClickListener olc, View view) {
        Intrinsics.checkNotNullParameter(olc, "$olc");
        return olc.onLongClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(AbsGuildItemCombineStyleComponent this$0, String elementId, GuildMediaAioCombineStyleChain it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(it, "$it");
        TextView W1 = this$0.W1();
        HashMap<String, Object> i3 = it.i();
        if (i3 == null) {
            i3 = new HashMap<>();
        }
        i3.put("dt_pgid", "pg_sgrp_avchannel_aio");
        Unit unit = Unit.INSTANCE;
        ae.i(W1, elementId, i3);
    }

    private final void P1(GuildMsgItem msgItem) {
        int i3;
        GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain = this.guildMediaAioCombineStyleChain;
        if (guildMediaAioCombineStyleChain != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (guildMediaAioCombineStyleChain.getBgRes() != -1) {
                i3 = guildMediaAioCombineStyleChain.getBgRes();
            } else {
                i3 = 0;
            }
            F(i3);
            for (z zVar : guildMediaAioCombineStyleChain.a()) {
                if (zVar instanceof ac) {
                    ac.a.a((ac) zVar, V1(), msgItem, spannableStringBuilder, W1(), this, 0, 32, null);
                } else if (zVar instanceof ad) {
                    ac.a.a(((ad) zVar).a(this), V1(), msgItem, spannableStringBuilder, W1(), this, 0, 32, null);
                }
            }
            W1().setText(spannableStringBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Q1(Context context) {
        TextView d16 = ((IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class)).createGuildLiveETTextView(context).d();
        d16.setMovementMethod(LinkMovementMethod.getInstance());
        ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).fixTextViewANRForAnd10(d16);
        d16.setSpannableFactory(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoSpanFactory());
        d16.setIncludeFontPadding(false);
        d16.setLongClickable(false);
        d16.setFocusable(false);
        d16.setTextSize(14.0f);
        d16.setLineSpacing(ViewUtils.dip2px(7.0f), 1.0f);
        d16.setTextColor(context.getResources().getColor(R.color.f157146bq2));
        d16.setLinkTextColor(context.getResources().getColor(R.color.bm5));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        d16.setLayoutParams(layoutParams);
        d16.setPadding(ae.b(), 0, 0, 0);
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View R1() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setPadding(ae.b(), ae.g(), ae.c(), ae.g());
        linearLayout.setOrientation(0);
        V1().setVisibility(8);
        linearLayout.addView(V1());
        linearLayout.addView(W1());
        Z1(linearLayout);
        return linearLayout;
    }

    private final View T1() {
        return (View) this.contentView.getValue();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected void A1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        P1(currentMsgItem);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.aa
    public void F(int resId) {
        S1().setBackgroundResource(resId);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.aa
    public int N0(@Nullable String roleColor, @NotNull String tinyId) {
        com.tencent.aio.api.runtime.a f16;
        AIOParam g16;
        Integer num;
        int U1;
        com.tencent.aio.api.runtime.a f17;
        AIOParam aioParam;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        int U12 = U1();
        if (getCurrentMsgItem() != null && TextUtils.isEmpty(roleColor) && (f17 = f1()) != null && (aioParam = f17.g()) != null) {
            Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
            U12 = com.tencent.guild.aio.util.h.k(com.tencent.guild.aio.util.h.f112401a, com.tencent.guild.aio.util.a.g(aioParam), com.tencent.guild.aio.util.a.b(aioParam), tinyId, "", 0, 0L, 32, null);
        }
        if (!TextUtils.isEmpty(roleColor)) {
            Intrinsics.checkNotNull(roleColor);
            U12 = Integer.parseInt(roleColor);
        }
        if ((U12 == -1 || U12 == U1()) && (f16 = f1()) != null && (g16 = f16.g()) != null) {
            Object e16 = up0.a.f439407a.e("TAG_MEMBER_ROLE_COLOR_CACHE", tinyId + "_" + com.tencent.guild.aio.util.a.b(g16));
            if (e16 instanceof Integer) {
                num = (Integer) e16;
            } else {
                num = null;
            }
            if (x.f110293a.d(num)) {
                Intrinsics.checkNotNull(num);
                U1 = (int) (num.intValue() | 4278190080L);
            } else {
                U1 = U1();
            }
            return U1;
        }
        return U12;
    }

    @NotNull
    public final View S1() {
        View view = this.bgContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bgContainer");
        return null;
    }

    public final int U1() {
        return ((Number) this.defaultTextColor.getValue()).intValue();
    }

    @NotNull
    public final GuildUserAvatarView V1() {
        return (GuildUserAvatarView) this.iv.getValue();
    }

    @NotNull
    public final TextView W1() {
        return (TextView) this.textView.getValue();
    }

    @Nullable
    public abstract GuildMediaAioCombineStyleChain X1(@NotNull GuildItemStyleMsgItem msgItem);

    @Nullable
    public abstract GuildMediaAioCombineStyleChain Y1(@NotNull GuildMsgItem msgItem);

    public final void Z1(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.bgContainer = view;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildItemStyleMsgItem) {
            guildMediaAioCombineStyleChain = X1((GuildItemStyleMsgItem) msgItem);
        } else if (msgItem instanceof GuildMsgItem) {
            guildMediaAioCombineStyleChain = Y1((GuildMsgItem) msgItem);
        } else {
            guildMediaAioCombineStyleChain = null;
        }
        this.guildMediaAioCombineStyleChain = guildMediaAioCombineStyleChain;
        if (msgItem instanceof GuildMsgItem) {
            P1((GuildMsgItem) msgItem);
        }
        final GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain2 = this.guildMediaAioCombineStyleChain;
        if (guildMediaAioCombineStyleChain2 != null) {
            this.root.setTag(R.id.zfk, Integer.valueOf(guildMediaAioCombineStyleChain2.getItemStyleType()));
            final View.OnClickListener itemOnClickListener = guildMediaAioCombineStyleChain2.getItemOnClickListener();
            if (itemOnClickListener != null) {
                S1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.component.combinestyle.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AbsGuildItemCombineStyleComponent.M1(itemOnClickListener, view);
                    }
                });
            }
            final View.OnLongClickListener itemOnLongClickListener = guildMediaAioCombineStyleChain2.getItemOnLongClickListener();
            if (itemOnLongClickListener != null) {
                S1().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.guild.aio.component.combinestyle.b
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean N1;
                        N1 = AbsGuildItemCombineStyleComponent.N1(itemOnLongClickListener, view);
                        return N1;
                    }
                });
            }
            final String elementId = guildMediaAioCombineStyleChain2.getElementId();
            if (elementId != null) {
                W1().post(new Runnable() { // from class: com.tencent.guild.aio.component.combinestyle.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsGuildItemCombineStyleComponent.O1(AbsGuildItemCombineStyleComponent.this, elementId, guildMediaAioCombineStyleChain2);
                    }
                });
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return T1();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.aa
    @NotNull
    public Activity getActivity() {
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) mContext;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.aa
    @NotNull
    public String getNickName(@NotNull String msgItemNickName) {
        Intrinsics.checkNotNullParameter(msgItemNickName, "msgItemNickName");
        return x.f110293a.b(msgItemNickName, W1());
    }

    @Override // com.tencent.guild.aio.component.combinestyle.aa
    public void k0() {
        GuildMsgItem currentMsgItem = getCurrentMsgItem();
        if (currentMsgItem != null) {
            P1(currentMsgItem);
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        this.guildMediaAioCombineStyleChain = null;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected boolean w1() {
        GuildMediaAioCombineStyleChain guildMediaAioCombineStyleChain = this.guildMediaAioCombineStyleChain;
        if (guildMediaAioCombineStyleChain == null || !guildMediaAioCombineStyleChain.getIsNeedListenerMemberRoleChanged()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected void z1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        P1(currentMsgItem);
    }
}
