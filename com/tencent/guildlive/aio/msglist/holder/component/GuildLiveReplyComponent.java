package com.tencent.guildlive.aio.msglist.holder.component;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.util.aa;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001QB\u000f\u0012\u0006\u00106\u001a\u00020\u0002\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010$\u001a\u00020#H\u0002J\"\u0010&\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010$\u001a\u00020#H\u0002J\u001a\u0010'\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\"\u0010+\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002R\u0017\u00106\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveReplyComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Landroid/view/View;", "d1", "Lcom/tencent/guildlive/aio/msglist/holder/component/t;", "Y1", "", "Ljava/lang/Class;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getObserverStates", "state", "", "handleUIState", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "replyElement", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "U1", "X1", "", "i2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", ICustomDataEditor.STRING_ARRAY_PARAM_2, "g2", SemanticAttributes.DbSystemValues.H2, "show", "l2", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "P1", "d2", "O1", "", "sourceMsgText", "isRevoke", "S1", "", "text", "T1", "k2", "W1", "j2", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", "E", "Lkotlin/Lazy;", "c2", "()Landroid/widget/LinearLayout;", "contentView", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "replyNickname", "", "G", "Ljava/lang/Long;", "replyMsgSeq", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "replyTextView", "I", "J", "firstMsgSeq", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "deleteClickListener", "<init>", "(Landroid/view/View;)V", "K", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveReplyComponent extends AbsGuildLiveComponent {
    private static final int L = ViewUtils.dip2px(15.0f);
    private static final int M = ViewUtils.dip2px(8.0f);
    private static final int N = ViewUtils.dip2px(7.0f);
    private static final int P = ViewUtils.dip2px(6.0f);
    private static final int Q = ViewUtils.dip2px(4.3333335f);
    private static final float R = ViewUtils.dip2px(12.0f);
    private static final int S = ViewUtils.dip2px(9.0f);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String replyNickname;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Long replyMsgSeq;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView replyTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private long firstMsgSeq;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener deleteClickListener;

    public GuildLiveReplyComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.GuildLiveReplyComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                View g26;
                View h26;
                LinearLayout linearLayout = new LinearLayout(GuildLiveReplyComponent.this.getRoot().getContext());
                GuildLiveReplyComponent guildLiveReplyComponent = GuildLiveReplyComponent.this;
                linearLayout.setGravity(16);
                linearLayout.setOrientation(0);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                g26 = guildLiveReplyComponent.g2();
                linearLayout.addView(g26);
                h26 = guildLiveReplyComponent.h2();
                linearLayout.addView(h26);
                return linearLayout;
            }
        });
        this.contentView = lazy;
        this.replyNickname = "";
        this.deleteClickListener = new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.component.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveReplyComponent.Z1(view);
            }
        };
    }

    private final void O1(MsgRecord msgRecord, ReplyElement replyElement) {
        String sourceMsgText;
        if (msgRecord == null) {
            T1(this.replyNickname + replyElement.sourceMsgText);
            return;
        }
        boolean b16 = com.tencent.guild.aio.util.ex.d.b(msgRecord);
        boolean a16 = com.tencent.guild.aio.util.ex.d.a(msgRecord);
        GuildLiveLogUtil.INSTANCE.e("GuildLiveReplyComponent", "[bindReplyContent] getMsg msg: isTypeNull = " + b16 + ", isRevokeMsg = " + a16);
        if (b16) {
            sourceMsgText = getMContext().getString(R.string.f152991aw);
        } else if (a16) {
            sourceMsgText = getMContext().getString(R.string.f153011ay);
        } else {
            sourceMsgText = replyElement.sourceMsgText;
        }
        Intrinsics.checkNotNullExpressionValue(sourceMsgText, "sourceMsgText");
        S1(msgRecord, sourceMsgText, a16);
    }

    private final void P1(final ReplyElement replyElement, Contact contact) {
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = contact.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
        String str2 = contact.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "contact.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        GuildLiveLogUtil.INSTANCE.e("GuildLiveReplyComponent", "[bindReplyMsg] selfGuest: " + isSelfGuest);
        if (isSelfGuest) {
            d2(getCurrentMsgItem(), replyElement, contact);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(replyElement.replayMsgSeq);
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsBySeqs(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.guildlive.aio.msglist.holder.component.p
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str3, ArrayList arrayList2) {
                GuildLiveReplyComponent.Q1(GuildLiveReplyComponent.this, replyElement, i3, str3, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(final GuildLiveReplyComponent this$0, final ReplyElement replyElement, final int i3, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        aa.b(new Runnable() { // from class: com.tencent.guildlive.aio.msglist.holder.component.r
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveReplyComponent.R1(i3, str, this$0, replyElement, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(int i3, String str, GuildLiveReplyComponent this$0, ReplyElement replyElement, ArrayList msgList) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        if (i3 != 0) {
            GuildLiveLogUtil.INSTANCE.d("GuildLiveReplyComponent", "[bindReplyContent] result: " + i3 + ", errMsg, " + str);
            this$0.T1(this$0.replyNickname + replyElement.sourceMsgText);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        Iterator it = msgList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                long j3 = ((MsgRecord) obj).msgSeq;
                Long l3 = replyElement.replayMsgSeq;
                if (l3 != null && j3 == l3.longValue()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        this$0.O1((MsgRecord) obj, replyElement);
    }

    private final void S1(MsgRecord msgRecord, String sourceMsgText, boolean isRevoke) {
        String str;
        List filterNotNull;
        if (isRevoke) {
            str = "";
        } else {
            str = this.replyNickname;
        }
        if (MsgExtKt.P(msgRecord)) {
            ArrayList arrayList = new ArrayList();
            ArrayList<MsgElement> elements = msgRecord.elements;
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
            T1(str + ((Object) iq0.a.p(arrayList, false, false, 4, null)));
            return;
        }
        T1(str + sourceMsgText);
    }

    private final void T1(CharSequence text) {
        TextView textView = this.replyTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
            textView = null;
        }
        textView.setText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(text, 14), TextView.BufferType.SPANNABLE);
        k2();
    }

    private final void U1(ReplyElement replyElement, GuildMsgItem msgItem) {
        c cVar = new c(0L);
        sendIntent(cVar);
        this.replyMsgSeq = replyElement.replayMsgSeq;
        this.firstMsgSeq = cVar.getFirstMsgSeq();
        if (i2()) {
            String string = getMContext().getString(R.string.f152991aw);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026ply_navigate_source_null)");
            T1(string);
            c2().setOnClickListener(this.deleteClickListener);
            return;
        }
        String guildId = msgItem.getMsgRecord().guildId;
        String valueOf = String.valueOf(replyElement.senderUid);
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        this.replyNickname = iq0.a.u(valueOf, guildId) + MsgSummary.STR_COLON;
        P1(replyElement, new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, guildId));
        c2().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.component.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveReplyComponent.V1(GuildLiveReplyComponent.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V1(GuildLiveReplyComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void W1() {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        View findViewById = this.root.findViewById(R.id.zgk);
        int i16 = 0;
        if (findViewById != null) {
            i3 = findViewById.getRight();
        } else {
            i3 = 0;
        }
        View findViewById2 = this.root.findViewById(R.id.zfv);
        if (findViewById2 != null) {
            i16 = findViewById2.getRight();
        }
        if (i3 < i16) {
            View findViewById3 = this.root.findViewById(R.id.f73133sq);
            if (findViewById3 != null && (layoutParams2 = findViewById3.getLayoutParams()) != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams2).addRule(19, R.id.zfv);
            }
            View findViewById4 = this.root.findViewById(R.id.wri);
            if (findViewById4 != null && (layoutParams = findViewById4.getLayoutParams()) != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(19, R.id.zfv);
            }
        } else {
            j2();
        }
        this.root.requestLayout();
    }

    private final void X1() {
        TextView textView = this.replyTextView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
            textView = null;
        }
        if (Intrinsics.areEqual(textView.getText().toString(), getMContext().getString(R.string.f152991aw))) {
            com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f152991aw);
            return;
        }
        TextView textView3 = this.replyTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
        } else {
            textView2 = textView3;
        }
        if (Intrinsics.areEqual(textView2.getText().toString(), getMContext().getString(R.string.f153011ay))) {
            com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f153011ay);
        }
        Long l3 = this.replyMsgSeq;
        if (l3 != null) {
            Intrinsics.checkNotNull(l3);
            sendIntent(new k(l3.longValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f152991aw);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final ReplyElement a2(MsgRecord msgRecord) {
        ReplyElement replyElement;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            boolean z16 = false;
            if (msgElement != null && msgElement.elementType == 7) {
                z16 = true;
            }
            if (z16 && (replyElement = msgElement.replyElement) != null) {
                return replyElement;
            }
        }
        return null;
    }

    private final LinearLayout c2() {
        return (LinearLayout) this.contentView.getValue();
    }

    private final void d2(final GuildMsgItem msgItem, final ReplyElement replyElement, Contact contact) {
        ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgByRange(contact, replyElement.replayMsgSeq.longValue() + 1, 1, true, new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.guildlive.aio.msglist.holder.component.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                GuildLiveReplyComponent.e2(GuildMsgItem.this, this, replyElement, i3, str, arrayList, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(GuildMsgItem guildMsgItem, final GuildLiveReplyComponent this$0, final ReplyElement replyElement, int i3, String str, ArrayList msgList, HashMap hashMap) {
        Long l3;
        Long l16;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveReplyComponent", "getGuestMsgByRange result=" + i3 + " errMsg=" + str);
        Object obj = null;
        if (guildMsgItem != null) {
            l3 = Long.valueOf(guildMsgItem.getMsgId());
        } else {
            l3 = null;
        }
        GuildMsgItem currentMsgItem = this$0.getCurrentMsgItem();
        if (currentMsgItem != null) {
            l16 = Long.valueOf(currentMsgItem.getMsgId());
        } else {
            l16 = null;
        }
        if (Intrinsics.areEqual(l3, l16)) {
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            Iterator it = msgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                long j3 = ((MsgRecord) next).msgSeq;
                Long l17 = replyElement.replayMsgSeq;
                if (l17 != null && j3 == l17.longValue()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            final MsgRecord msgRecord = (MsgRecord) obj;
            aa.b(new Runnable() { // from class: com.tencent.guildlive.aio.msglist.holder.component.s
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLiveReplyComponent.f2(GuildLiveReplyComponent.this, msgRecord, replyElement);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(GuildLiveReplyComponent this$0, MsgRecord msgRecord, ReplyElement replyElement) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        this$0.O1(msgRecord, replyElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View g2() {
        ImageView imageView = new ImageView(this.root.getContext());
        imageView.setImageResource(R.drawable.guild_live_reply_icon);
        int i3 = L;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMargins(M, P, N, Q);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View h2() {
        TextView textView = new TextView(this.root.getContext());
        textView.setId(R.id.f73323t9);
        textView.setIncludeFontPadding(false);
        textView.setLongClickable(false);
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.guild_aio_reply_msg));
        textView.setTextSize(0, R);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(S);
        textView.setLayoutParams(layoutParams);
        this.replyTextView = textView;
        return textView;
    }

    private final boolean i2() {
        Long l3 = this.replyMsgSeq;
        if (l3 != null) {
            Intrinsics.checkNotNull(l3);
            if (l3.longValue() < this.firstMsgSeq) {
                return true;
            }
        }
        return false;
    }

    private final void j2() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        View findViewById = this.root.findViewById(R.id.f73133sq);
        if (findViewById != null && (layoutParams2 = findViewById.getLayoutParams()) != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams2).addRule(19, R.id.zgk);
        }
        View findViewById2 = this.root.findViewById(R.id.wri);
        if (findViewById2 != null && (layoutParams = findViewById2.getLayoutParams()) != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(19, R.id.zgk);
        }
    }

    private final void k2() {
        l2(true);
        W1();
    }

    private final void l2(boolean show) {
        int i3;
        View findViewById = this.root.findViewById(R.id.f73133sq);
        if (findViewById != null) {
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public t createVM() {
        return new t();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        l2(false);
        j2();
        this.replyMsgSeq = null;
        if (!(msgItem instanceof GuildMsgItem)) {
            yr0.a.s(c2(), false);
            return;
        }
        yr0.a.s(c2(), true);
        c2().setOnClickListener(null);
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        ReplyElement a26 = a2(guildMsgItem.getMsgRecord());
        if (a26 != null) {
            U1(a26, guildMsgItem);
        }
        yr0.a.q(c2(), "em_aio_reply_message_position", null, 4, null);
        yr0.a.o("imp", c2(), null, 4, null);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return c2();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MviUIState>> getObserverStates() {
        List<Class<? extends MviUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildUpdateReplyMsgUIState.class, GuildDeleteRevokeMsgUIState.class});
        return listOf;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        boolean contains;
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        TextView textView = null;
        if (state instanceof GuildUpdateReplyMsgUIState) {
            if (this.replyMsgSeq != null) {
                contains = CollectionsKt___CollectionsKt.contains(((GuildUpdateReplyMsgUIState) state).a(), this.replyMsgSeq);
                if (contains && !i2()) {
                    TextView textView2 = this.replyTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
                    } else {
                        textView = textView2;
                    }
                    textView.setText(getMContext().getString(R.string.f153011ay));
                    k2();
                    return;
                }
                return;
            }
            return;
        }
        if (state instanceof GuildDeleteRevokeMsgUIState) {
            GuildDeleteRevokeMsgUIState guildDeleteRevokeMsgUIState = (GuildDeleteRevokeMsgUIState) state;
            GuildLiveLogUtil.INSTANCE.e("GuildLiveReplyComponent", "[handleUIState] deleteSeq = " + guildDeleteRevokeMsgUIState.getDeleteSeq() + ", replyMsgSeq = " + this.replyMsgSeq);
            Long l3 = this.replyMsgSeq;
            if (l3 != null) {
                long deleteSeq = guildDeleteRevokeMsgUIState.getDeleteSeq();
                if (l3 != null && l3.longValue() == deleteSeq) {
                    TextView textView3 = this.replyTextView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
                        textView3 = null;
                    }
                    textView3.setText(getMContext().getString(R.string.f152991aw));
                    k2();
                    this.replyMsgSeq = null;
                }
            }
        }
    }
}
