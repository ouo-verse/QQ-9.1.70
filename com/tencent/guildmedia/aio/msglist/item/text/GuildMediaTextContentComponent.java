package com.tencent.guildmedia.aio.msglist.item.text;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import bq0.GuildHighlightParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.aio.util.ex.e;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.emoji.IRandomLottieProxyApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 K2\u00020\u0001:\u0001LB\u000f\u0012\u0006\u00102\u001a\u00020\u0002\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J&\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0013H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0014J\u0016\u0010\u0019\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J(\u0010 \u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00132\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010'\u001a\u00020\r2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010\t\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0013H\u0002R\u0017\u00102\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R*\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00107R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010H\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010A\u001a\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/text/GuildMediaTextContentComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "Landroid/view/View;", "d1", "Lcom/tencent/guildmedia/aio/msglist/item/text/GuildMediaTextContentComponentVM;", "O1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "", "F1", ICustomDataEditor.NUMBER_PARAM_1, "w1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "A1", "z1", "R1", "S1", "T1", "Z1", "V1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "M1", "Y1", "W1", "Landroid/widget/TextView;", "textView", "Landroid/text/SpannableStringBuilder;", "result", "K1", "X1", "Landroid/content/Context;", "context", "Lgr0/a;", "N1", "U1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Ljava/util/ArrayList;", "tempList", UserInfo.SEX_FEMALE, "Z", "isLottie", "", "G", "Ljava/lang/String;", "randomLottieResultId", "H", "isRandomLottie", "Landroid/view/ViewGroup;", "I", "Lkotlin/Lazy;", "P1", "()Landroid/view/ViewGroup;", "contentView", "J", "Q1", "()Lgr0/a;", "contentViewCtrl", "<init>", "(Landroid/view/View;)V", "K", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMediaTextContentComponent extends com.tencent.guildmedia.aio.msglist.holder.component.a {

    @NotNull
    private static final Lazy<IGuildMediaChannelApi> L;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<MsgElement> tempList;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLottie;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String randomLottieResultId;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isRandomLottie;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentViewCtrl;

    static {
        Lazy<IGuildMediaChannelApi> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildMediaChannelApi>() { // from class: com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponent$Companion$iMediaChannelApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildMediaChannelApi invoke() {
                return (IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class);
            }
        });
        L = lazy;
    }

    public GuildMediaTextContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.randomLottieResultId = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                gr0.a Q1;
                FrameLayout frameLayout = new FrameLayout(GuildMediaTextContentComponent.this.getRoot().getContext());
                GuildMediaTextContentComponent guildMediaTextContentComponent = GuildMediaTextContentComponent.this;
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                Q1 = guildMediaTextContentComponent.Q1();
                frameLayout.addView(Q1.d());
                return frameLayout;
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<gr0.a>() { // from class: com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponent$contentViewCtrl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final gr0.a invoke() {
                gr0.a N1;
                GuildMediaTextContentComponent guildMediaTextContentComponent = GuildMediaTextContentComponent.this;
                Context context = guildMediaTextContentComponent.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                N1 = guildMediaTextContentComponent.N1(context);
                return N1;
            }
        });
        this.contentViewCtrl = lazy2;
    }

    private final void K1(TextView textView, SpannableStringBuilder result, final GuildMsgItem msgItem) {
        String str;
        com.tencent.guildmedia.aio.msglist.b bVar = new com.tencent.guildmedia.aio.msglist.b(textView);
        String d16 = bVar.d(msgItem);
        if (U1(msgItem)) {
            str = bVar.b(msgItem);
        } else {
            str = "";
        }
        bVar.g(result, 0, d16, str);
        bVar.h(result, d16, R1(msgItem));
        if (!TextUtils.isEmpty(str)) {
            bVar.k(result, d16.length(), d16.length() + str.length(), R1(msgItem));
        }
        bVar.i(result, d16 + str, S1());
        Q1().setNickName(d16);
        Q1().setNickClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.msglist.item.text.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaTextContentComponent.L1(GuildMediaTextContentComponent.this, msgItem, view);
            }
        });
        textView.setText(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(GuildMediaTextContentComponent this$0, GuildMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.u1(this$0.root)) {
            Context mContext = this$0.getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            vs0.a.i((Activity) mContext, msgItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M1(GuildMsgItem msgItem, ArrayList<MsgElement> msgElements) {
        int b16;
        FaceElement a16 = e.a(msgElements);
        if (a16 != null && (b16 = e.b(msgElements)) != 0) {
            sendIntent(new b(msgItem.getMsgSeq(), (ViewGroup) this.root.findViewById(R.id.zfv), a16, b16));
            this.randomLottieResultId = a16.resultId;
            Y1(msgItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gr0.a N1(Context context) {
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

    private final ViewGroup P1() {
        return (ViewGroup) this.contentView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gr0.a Q1() {
        return (gr0.a) this.contentViewCtrl.getValue();
    }

    private final boolean T1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    private final boolean U1(GuildMsgItem msgItem) {
        h.MemberRoleInfo d16 = h.f112401a.d(msgItem);
        if (d16 == null || d16.getType() != 6) {
            return false;
        }
        return true;
    }

    private final void V1() {
        ViewGroup viewGroup = (ViewGroup) this.root.findViewById(R.id.zfv);
        if (viewGroup != null) {
            for (View view : ViewGroupKt.getChildren(viewGroup)) {
                if (!Intrinsics.areEqual(view, P1())) {
                    view.setVisibility(8);
                }
            }
        }
    }

    private final void W1(final com.tencent.aio.data.msglist.a msgItem) {
        SpannableStringBuilder d16;
        if (msgItem instanceof GuildMsgItem) {
            s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
            sendIntent(new s.GetAioContext(aioContextWrapper));
            final TextView d17 = Q1().d();
            TextBubbleContentParser textBubbleContentParser = TextBubbleContentParser.f111932a;
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            MsgRecord msgRecord = guildMsgItem.getMsgRecord();
            ArrayList<MsgElement> arrayList = this.tempList;
            Intrinsics.checkNotNull(arrayList);
            GuildHighlightParams.GuildHighlightStyle guildHighlightStyle = new GuildHighlightParams.GuildHighlightStyle(0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 255, null);
            guildHighlightStyle.g(R.color.bpk);
            guildHighlightStyle.i(R.color.bpl);
            guildHighlightStyle.k(R.color.bpk);
            guildHighlightStyle.m(R.color.bpl);
            guildHighlightStyle.l(R.color.bpm);
            guildHighlightStyle.j(14.0f);
            guildHighlightStyle.h(14.0f);
            Unit unit = Unit.INSTANCE;
            d16 = textBubbleContentParser.d(msgRecord, d17, arrayList, (r27 & 8) != 0 ? null : guildHighlightStyle, (r27 & 16) != 0 ? null : aioContextWrapper.getContext(), (r27 & 32) != 0 ? 18 : 14, false, (r27 & 128) != 0 ? false : false, (r27 & 256) != 0 ? null : new Function1<String, Boolean>() { // from class: com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponent$updateContentText$style$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(GuildMediaTextContentComponent.this.x1(it, ((GuildMsgItem) msgItem).getMsgRecord(), d17));
                }
            }, (r27 & 512) != 0 ? false : false, (r27 & 1024) != 0 ? false : false);
            d17.setText(d16);
            K1(d17, d16, guildMsgItem);
            return;
        }
        Q1().setNickClickListener(null);
    }

    private final void X1(GuildMsgItem currentMsgItem) {
        W1(currentMsgItem);
    }

    private final void Y1(GuildMsgItem msgItem) {
        TextView d16 = Q1().d();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        d16.setText(spannableStringBuilder);
        K1(d16, spannableStringBuilder, msgItem);
    }

    private final void Z1() {
        FaceElement a16;
        String str;
        ArrayList<MsgElement> arrayList = this.tempList;
        if (arrayList != null && (a16 = e.a(arrayList)) != null) {
            String str2 = a16.resultId;
            this.randomLottieResultId = str2;
            if (!TextUtils.isEmpty(str2) && (str = this.randomLottieResultId) != null) {
                QRouteApi api = QRoute.api(IRandomLottieProxyApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IRandomLottieProxyApi::class.java)");
                IRandomLottieProxyApi.a.a((IRandomLottieProxyApi) api, str, this.root, null, null, 12, null);
            }
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected void A1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        X1(currentMsgItem);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected boolean F1() {
        if (!this.isRandomLottie && !this.isLottie) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public GuildMediaTextContentComponentVM createVM() {
        return new GuildMediaTextContentComponentVM();
    }

    protected int R1(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        int h16 = h.f112401a.h(msgItem, 4278190080L);
        if (h16 == -1 || h16 == -16777216) {
            return S1();
        }
        return h16;
    }

    protected int S1() {
        return getMContext().getResources().getColor(R.color.bpx);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        List filterNotNull;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(msgItem instanceof GuildMsgItem)) {
            return;
        }
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
        super.b1(position, msgItem, payloads);
        if (!T1(payloads) && this.isRandomLottie) {
            Z1();
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return P1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected void n1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(msgItem instanceof GuildMsgItem)) {
            return;
        }
        V1();
        if (!this.isLottie) {
            W1(msgItem);
            return;
        }
        ArrayList<MsgElement> arrayList = this.tempList;
        if (arrayList != null) {
            M1((GuildMsgItem) msgItem, arrayList);
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected boolean w1() {
        return true;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent
    protected void z1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        X1(currentMsgItem);
    }
}
