package com.tencent.guildmedia.aio.msglist.item.thirdapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponentVM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 82\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010%\u001a\u00020\u0013\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\nH\u0014J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\nH\u0014R\u0017\u0010%\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R*\u0010+\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00105\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/thirdapp/GuildMediaThirdAppMsgTextContentComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "S1", "Landroid/widget/TextView;", "textView", "Landroid/text/SpannableStringBuilder;", "result", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "K1", "", "Q1", "R1", "Landroid/content/Context;", "context", "Lgr0/a;", "M1", "Landroid/view/View;", "d1", "Lcom/tencent/guildmedia/aio/msglist/item/text/GuildMediaTextContentComponentVM;", "N1", "position", "", "", "payloads", "b1", "", "w1", "currentMsgItem", "A1", "z1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "tempList", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "O1", "()Landroid/view/ViewGroup;", "contentView", "G", "P1", "()Lgr0/a;", "contentViewCtrl", "<init>", "(Landroid/view/View;)V", "H", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaThirdAppMsgTextContentComponent extends com.tencent.guildmedia.aio.msglist.holder.component.a {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<MsgElement> tempList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentViewCtrl;

    public GuildMediaThirdAppMsgTextContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.guildmedia.aio.msglist.item.thirdapp.GuildMediaThirdAppMsgTextContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                gr0.a P1;
                FrameLayout frameLayout = new FrameLayout(GuildMediaThirdAppMsgTextContentComponent.this.getRoot().getContext());
                GuildMediaThirdAppMsgTextContentComponent guildMediaThirdAppMsgTextContentComponent = GuildMediaThirdAppMsgTextContentComponent.this;
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                P1 = guildMediaThirdAppMsgTextContentComponent.P1();
                frameLayout.addView(P1.d());
                return frameLayout;
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<gr0.a>() { // from class: com.tencent.guildmedia.aio.msglist.item.thirdapp.GuildMediaThirdAppMsgTextContentComponent$contentViewCtrl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final gr0.a invoke() {
                gr0.a M1;
                GuildMediaThirdAppMsgTextContentComponent guildMediaThirdAppMsgTextContentComponent = GuildMediaThirdAppMsgTextContentComponent.this;
                Context context = guildMediaThirdAppMsgTextContentComponent.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                M1 = guildMediaThirdAppMsgTextContentComponent.M1(context);
                return M1;
            }
        });
        this.contentViewCtrl = lazy2;
    }

    private final void K1(TextView textView, SpannableStringBuilder result, GuildMsgItem msgItem) {
        com.tencent.guildmedia.aio.msglist.b bVar = new com.tencent.guildmedia.aio.msglist.b(textView);
        String d16 = vs0.a.d(msgItem, "app_name");
        final String d17 = vs0.a.d(msgItem, "app_id");
        bVar.g(result, 0, d16, "\u5e94\u7528");
        bVar.h(result, d16, Q1(msgItem));
        if (!TextUtils.isEmpty("\u5e94\u7528")) {
            bVar.j(result, d16.length(), d16.length() + 2, Q1(msgItem), Color.parseColor("#3AB0FF"), Color.parseColor("#10E8F6"));
        }
        bVar.i(result, d16 + "\u5e94\u7528", R1());
        P1().setNickName(d16);
        P1().setNickClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.msglist.item.thirdapp.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaThirdAppMsgTextContentComponent.L1(GuildMediaThirdAppMsgTextContentComponent.this, d17, view);
            }
        });
        textView.setText(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(GuildMediaThirdAppMsgTextContentComponent this$0, String appId, View view) {
        String str;
        AIOParam g16;
        String b16;
        AIOParam g17;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        if (this$0.u1(this$0.root)) {
            Context mContext = this$0.getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) mContext;
            com.tencent.aio.api.runtime.a f16 = this$0.f1();
            String str2 = "";
            if (f16 == null || (g17 = f16.g()) == null || (str = com.tencent.guild.aio.util.a.g(g17)) == null) {
                str = "";
            }
            com.tencent.aio.api.runtime.a f17 = this$0.f1();
            if (f17 != null && (g16 = f17.g()) != null && (b16 = com.tencent.guild.aio.util.a.b(g16)) != null) {
                str2 = b16;
            }
            vs0.a.k(activity, appId, str, str2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gr0.a M1(Context context) {
        gr0.a createGuildLiveETTextView = ((IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class)).createGuildLiveETTextView(context);
        TextView d16 = createGuildLiveETTextView.d();
        d16.setMovementMethod(LinkMovementMethod.getInstance());
        ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).fixTextViewANRForAnd10(d16);
        d16.setSpannableFactory(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoSpanFactory());
        int i3 = 0;
        d16.setIncludeFontPadding(false);
        d16.setLongClickable(false);
        d16.setFocusable(false);
        d16.setLineSpacing(ViewUtils.dip2px(7.0f), 1.0f);
        d16.setTextSize(0, ViewUtils.dip2px(14.0f));
        d16.setTextColor(context.getResources().getColor(R.color.f157146bq2));
        d16.setLinkTextColor(context.getResources().getColor(R.color.bm5));
        d16.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (AppSetting.f99565y) {
            i3 = 3;
        }
        d16.setAutoLinkMask(i3);
        return createGuildLiveETTextView;
    }

    private final ViewGroup O1() {
        return (ViewGroup) this.contentView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gr0.a P1() {
        return (gr0.a) this.contentViewCtrl.getValue();
    }

    private final int Q1(GuildMsgItem msgItem) {
        return Color.parseColor("#66FFFFFF");
    }

    private final int R1() {
        return getMContext().getResources().getColor(R.color.bpx);
    }

    private final void S1(com.tencent.aio.data.msglist.a msgItem) {
        if (msgItem instanceof GuildMsgItem) {
            String d16 = vs0.a.d(msgItem, "text");
            sendIntent(new s.GetAioContext(new s.AioContextWrapper(null, 1, null)));
            TextView d17 = P1().d();
            d17.setText(d16);
            K1(d17, new SpannableStringBuilder(d16), (GuildMsgItem) msgItem);
            return;
        }
        P1().setNickClickListener(null);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected void A1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        S1(currentMsgItem);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public GuildMediaTextContentComponentVM createVM() {
        return new GuildMediaTextContentComponentVM();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        List filterNotNull;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            ArrayList<MsgElement> arrayList = new ArrayList<>();
            ArrayList<MsgElement> elements = ((GuildMsgItem) msgItem).getMsgRecord().elements;
            if (elements != null) {
                Intrinsics.checkNotNullExpressionValue(elements, "elements");
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
                if (filterNotNull != null) {
                    Iterator it = filterNotNull.iterator();
                    while (it.hasNext()) {
                        arrayList.add((MsgElement) it.next());
                    }
                }
            }
            this.tempList = arrayList;
            if (arrayList.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            S1(msgItem);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return O1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected boolean w1() {
        return true;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected void z1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        S1(currentMsgItem);
    }
}
