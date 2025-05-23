package com.tencent.guildmedia.aio.msglist.holder.component;

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
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
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
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u0001JB\u000f\u0012\u0006\u00105\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\"\u0010 \u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001a\u0010!\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\"\u0010&\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$H\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\b\u0010-\u001a\u00020\u0002H\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020$H\u0002J\b\u00100\u001a\u00020\u000bH\u0002R\u0017\u00105\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/holder/component/GuildMediaReplyComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "Landroid/view/View;", "d1", "Lcom/tencent/guildmedia/aio/msglist/holder/component/m;", "Z1", "", "Ljava/lang/Class;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getObserverStates", "state", "", "handleUIState", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "replyElement", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "V1", "Y1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Q1", "d2", "P1", "", "sourceMsgText", "", "isRevoke", "T1", "", "text", "U1", "j2", "X1", "g2", SemanticAttributes.DbSystemValues.H2, "show", "l2", "i2", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/LinearLayout;", "E", "Lkotlin/Lazy;", "c2", "()Landroid/widget/LinearLayout;", "contentView", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "replyNickname", "", "G", "Ljava/lang/Long;", "replyMsgSeq", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "replyTextView", "<init>", "(Landroid/view/View;)V", "I", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaReplyComponent extends a {
    private static final int J = ViewUtils.dip2px(15.0f);
    private static final int K = ViewUtils.dip2px(8.0f);
    private static final int L = ViewUtils.dip2px(7.0f);
    private static final int M = ViewUtils.dip2px(6.0f);
    private static final int N = ViewUtils.dip2px(4.3333335f);
    private static final float P = ViewUtils.dip2px(12.0f);
    private static final int Q = ViewUtils.dip2px(9.0f);

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

    public GuildMediaReplyComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guildmedia.aio.msglist.holder.component.GuildMediaReplyComponent$contentView$2
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
                LinearLayout linearLayout = new LinearLayout(GuildMediaReplyComponent.this.getRoot().getContext());
                GuildMediaReplyComponent guildMediaReplyComponent = GuildMediaReplyComponent.this;
                linearLayout.setGravity(16);
                linearLayout.setOrientation(0);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                g26 = guildMediaReplyComponent.g2();
                linearLayout.addView(g26);
                h26 = guildMediaReplyComponent.h2();
                linearLayout.addView(h26);
                return linearLayout;
            }
        });
        this.contentView = lazy;
        this.replyNickname = "";
    }

    private final void P1(MsgRecord msgRecord, ReplyElement replyElement) {
        String sourceMsgText;
        if (msgRecord == null) {
            U1(this.replyNickname + replyElement.sourceMsgText);
            return;
        }
        boolean b16 = com.tencent.guild.aio.util.ex.d.b(msgRecord);
        boolean a16 = com.tencent.guild.aio.util.ex.d.a(msgRecord);
        GuildMediaLogUtil.INSTANCE.c("GuildMediaReplyComponent", "[bindReplyContent] getMsg msg: isTypeNull = " + b16 + ", isRevokeMsg = " + a16);
        if (b16) {
            sourceMsgText = getMContext().getString(R.string.f152991aw);
        } else if (a16) {
            sourceMsgText = getMContext().getString(R.string.f153011ay);
        } else {
            sourceMsgText = replyElement.sourceMsgText;
        }
        Intrinsics.checkNotNullExpressionValue(sourceMsgText, "sourceMsgText");
        T1(msgRecord, sourceMsgText, a16);
    }

    private final void Q1(final ReplyElement replyElement, Contact contact) {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaReplyComponent", "[bindReplyMsg] replyElement: " + replyElement);
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = contact.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
        String str2 = contact.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "contact.guildId");
        if (iGuildChannelApi.isSelfGuest(str, str2)) {
            d2(getCurrentMsgItem(), replyElement, contact);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(replyElement.replayMsgSeq);
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsBySeqs(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.guildmedia.aio.msglist.holder.component.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str3, ArrayList arrayList2) {
                GuildMediaReplyComponent.R1(GuildMediaReplyComponent.this, replyElement, i3, str3, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(final GuildMediaReplyComponent this$0, final ReplyElement replyElement, final int i3, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        aa.b(new Runnable() { // from class: com.tencent.guildmedia.aio.msglist.holder.component.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaReplyComponent.S1(i3, str, this$0, replyElement, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(int i3, String str, GuildMediaReplyComponent this$0, ReplyElement replyElement, ArrayList msgList) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        if (i3 != 0) {
            GuildMediaLogUtil.INSTANCE.b("GuildMediaReplyComponent", "[bindReplyContent] result: " + i3 + ", errMsg, " + str);
            this$0.U1(this$0.replyNickname + replyElement.sourceMsgText);
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
        this$0.P1((MsgRecord) obj, replyElement);
    }

    private final void T1(MsgRecord msgRecord, String sourceMsgText, boolean isRevoke) {
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
            U1(str + ((Object) iq0.a.p(arrayList, false, false, 4, null)));
            return;
        }
        U1(str + sourceMsgText);
    }

    private final void U1(CharSequence text) {
        TextView textView = this.replyTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
            textView = null;
        }
        textView.setText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(text, 14), TextView.BufferType.SPANNABLE);
        j2();
    }

    private final void V1(ReplyElement replyElement, GuildMsgItem msgItem) {
        this.replyMsgSeq = replyElement.replayMsgSeq;
        String guildId = msgItem.getMsgRecord().guildId;
        String valueOf = String.valueOf(replyElement.senderUid);
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        this.replyNickname = iq0.a.u(valueOf, guildId) + MsgSummary.STR_COLON;
        Q1(replyElement, new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, guildId));
        c2().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.msglist.holder.component.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaReplyComponent.W1(GuildMediaReplyComponent.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(GuildMediaReplyComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X1() {
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
            this.root.requestLayout();
        }
    }

    private final void Y1() {
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
            sendIntent(new b(l3.longValue()));
        }
    }

    private final ReplyElement a2(MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            boolean z16 = false;
            if (msgElement != null && msgElement.elementType == 7) {
                z16 = true;
            }
            if (z16) {
                return msgElement.replyElement;
            }
        }
        return null;
    }

    private final LinearLayout c2() {
        return (LinearLayout) this.contentView.getValue();
    }

    private final void d2(final GuildMsgItem msgItem, final ReplyElement replyElement, Contact contact) {
        ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgByRange(contact, replyElement.replayMsgSeq.longValue() + 1, 1, true, new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.guildmedia.aio.msglist.holder.component.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                GuildMediaReplyComponent.e2(GuildMsgItem.this, this, replyElement, i3, str, arrayList, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(GuildMsgItem guildMsgItem, final GuildMediaReplyComponent this$0, final ReplyElement replyElement, int i3, String str, ArrayList msgList, HashMap hashMap) {
        Long l3;
        Long l16;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        GuildMediaLogUtil.INSTANCE.c("GuildMediaReplyComponent", "getGuestMsgByRange result=" + i3 + " errMsg=" + str);
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
            this$0.root.post(new Runnable() { // from class: com.tencent.guildmedia.aio.msglist.holder.component.l
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaReplyComponent.f2(GuildMediaReplyComponent.this, msgRecord, replyElement);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(GuildMediaReplyComponent this$0, MsgRecord msgRecord, ReplyElement replyElement) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        this$0.P1(msgRecord, replyElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View g2() {
        ImageView imageView = new ImageView(this.root.getContext());
        imageView.setImageResource(R.drawable.guild_live_reply_icon);
        int i3 = J;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMargins(K, M, L, N);
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
        textView.setTextSize(0, P);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(Q);
        textView.setLayoutParams(layoutParams);
        this.replyTextView = textView;
        return textView;
    }

    private final void i2() {
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

    private final void j2() {
        l2(true);
        c2().post(new Runnable() { // from class: com.tencent.guildmedia.aio.msglist.holder.component.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaReplyComponent.k2(GuildMediaReplyComponent.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(GuildMediaReplyComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X1();
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

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public m createVM() {
        return new m();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        l2(false);
        i2();
        this.replyMsgSeq = null;
        if (!(msgItem instanceof GuildMsgItem)) {
            vs0.a.p(c2(), false);
            return;
        }
        vs0.a.p(c2(), true);
        c2().setOnClickListener(null);
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        ReplyElement a26 = a2(guildMsgItem.getMsgRecord());
        if (a26 != null) {
            V1(a26, guildMsgItem);
        }
        vs0.a.o(c2(), "em_aio_reply_message_position", null, 4, null);
        vs0.a.m("imp", c2(), null, 4, null);
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

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Long l3;
        boolean contains;
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        TextView textView = null;
        if (state instanceof GuildUpdateReplyMsgUIState) {
            if (this.replyMsgSeq != null) {
                contains = CollectionsKt___CollectionsKt.contains(((GuildUpdateReplyMsgUIState) state).a(), this.replyMsgSeq);
                if (contains) {
                    TextView textView2 = this.replyTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
                    } else {
                        textView = textView2;
                    }
                    textView.setText(getMContext().getString(R.string.f153011ay));
                    j2();
                    return;
                }
                return;
            }
            return;
        }
        if ((state instanceof GuildDeleteRevokeMsgUIState) && (l3 = this.replyMsgSeq) != null) {
            long deleteSeq = ((GuildDeleteRevokeMsgUIState) state).getDeleteSeq();
            if (l3 != null && l3.longValue() == deleteSeq) {
                TextView textView3 = this.replyTextView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("replyTextView");
                    textView3 = null;
                }
                textView3.setText(getMContext().getString(R.string.f152991aw));
                j2();
                this.replyMsgSeq = null;
            }
        }
    }
}
