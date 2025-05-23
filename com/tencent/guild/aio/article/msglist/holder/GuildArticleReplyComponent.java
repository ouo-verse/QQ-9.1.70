package com.tencent.guild.aio.article.msglist.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.msglist.holder.component.nick.GuildReplyMsgNickState;
import com.tencent.guild.aio.util.ex.d;
import com.tencent.guild.aio.util.ex.f;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 L2\u00020\u0001:\u0001MB\u000f\u0012\u0006\u00103\u001a\u00020 \u00a2\u0006\u0004\bJ\u0010KJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016J\u0016\u0010(\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%H\u0016J&\u0010,\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020+2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020'H\u0016R\u0017\u00103\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00108R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/holder/GuildArticleReplyComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "o1", "guildMsgItem", "replyElement", "", "x1", "", "", "payloads", "z1", "", "w1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "replyMsgRecord", "u1", "", "r1", "msgRecord", "y1", "senderUid", "guildId", "p1", "isSelf", "replyNickName", "sourceMsgText", "A1", "tinyId", "v1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "state", "handleUIState", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "mCurrentMsgItem", "i", "Ljava/lang/String;", "mReplyMsgSenderId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mReplyMsgRevoked", BdhLogUtil.LogTag.Tag_Conn, "mSourceMsgText", "Landroid/view/ViewGroup;", "D", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_1, "()Landroid/view/ViewGroup;", "contentView", "Landroid/widget/TextView;", "E", ICustomDataEditor.STRING_PARAM_1, "()Landroid/widget/TextView;", "sourceMsgTextView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleReplyComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String mSourceMsgText;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy sourceMsgTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem mCurrentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mReplyMsgSenderId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mReplyMsgRevoked;

    public GuildArticleReplyComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.mSourceMsgText = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.guild.aio.article.msglist.holder.GuildArticleReplyComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewGroup invoke() {
                LayoutInflater from = LayoutInflater.from(GuildArticleReplyComponent.this.getRoot().getContext());
                View root2 = GuildArticleReplyComponent.this.getRoot();
                Intrinsics.checkNotNull(root2, "null cannot be cast to non-null type android.view.ViewGroup");
                View inflate = from.inflate(R.layout.efz, (ViewGroup) root2, false);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                return (ViewGroup) inflate;
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.article.msglist.holder.GuildArticleReplyComponent$sourceMsgTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                ViewGroup n16;
                n16 = GuildArticleReplyComponent.this.n1();
                return (TextView) n16.findViewById(R.id.f73323t9);
            }
        });
        this.sourceMsgTextView = lazy2;
    }

    private final void A1(boolean isSelf, ReplyElement replyElement, String replyNickName, String sourceMsgText) {
        Long l3;
        Long l16 = replyElement.replayMsgSeq;
        if (l16 != null && (l3 = replyElement.replayMsgRootSeq) != null && Intrinsics.areEqual(l16, l3)) {
            n1().setVisibility(8);
            ImageView imageView = (ImageView) this.root.findViewById(R.id.f73123sp);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            n1().setVisibility(0);
            if (isSelf) {
                ImageView imageView2 = (ImageView) this.root.findViewById(R.id.f73123sp);
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    Context context = imageView2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    imageView2.setBackgroundColor(iq0.a.i(context, false, 2, null));
                }
            } else {
                ImageView imageView3 = (ImageView) this.root.findViewById(R.id.f73123sp);
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                    Context context2 = imageView3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    imageView3.setBackgroundColor(iq0.a.e(context2, false, 2, null));
                }
            }
        }
        this.mSourceMsgText = sourceMsgText;
        s1().setText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(replyNickName + sourceMsgText, 16));
        s1().setVisibility(0);
        s1().setTextColor(iq0.a.s(getMContext(), isSelf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(final long j3, final GuildArticleReplyComponent this$0, final com.tencent.aio.data.msglist.a msgItem, final ReplyElement replyElement, int i3, String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.guild.aio.article.msglist.holder.GuildArticleReplyComponent$bind$1$1$1
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
                GuildMsgItem guildMsgItem;
                Object obj;
                guildMsgItem = this$0.mCurrentMsgItem;
                if (guildMsgItem != null && j3 == guildMsgItem.getMsgId()) {
                    ArrayList<MsgRecord> msgList = arrayList;
                    Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                    ReplyElement replyElement2 = replyElement;
                    Iterator<T> it = msgList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        long j16 = ((MsgRecord) obj).msgSeq;
                        Long l3 = replyElement2.replayMsgSeq;
                        if (l3 != null && j16 == l3.longValue()) {
                            break;
                        }
                    }
                    this$0.u1((GuildMsgItem) msgItem, replyElement, (MsgRecord) obj);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup n1() {
        return (ViewGroup) this.contentView.getValue();
    }

    private final ReplyElement o1(GuildMsgItem msgItem) {
        ReplyElement replyElement;
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7 && (replyElement = msgElement.replyElement) != null) {
                return replyElement;
            }
        }
        return null;
    }

    private final String p1(String senderUid, String guildId, MsgRecord replyMsgRecord) {
        if (replyMsgRecord != null && y1(replyMsgRecord)) {
            return "";
        }
        return iq0.a.u(senderUid, guildId) + MsgSummary.STR_COLON;
    }

    static /* synthetic */ String q1(GuildArticleReplyComponent guildArticleReplyComponent, String str, String str2, MsgRecord msgRecord, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            msgRecord = null;
        }
        return guildArticleReplyComponent.p1(str, str2, msgRecord);
    }

    private final String r1(MsgRecord replyMsgRecord, ReplyElement replyElement) {
        if (y1(replyMsgRecord)) {
            String string = this.root.getContext().getString(R.string.f153011ay);
            Intrinsics.checkNotNullExpressionValue(string, "root.context.getString(R\u2026_reply_source_msg_revoke)");
            return string;
        }
        if (MsgExtKt.P(replyMsgRecord)) {
            ArrayList arrayList = new ArrayList();
            ArrayList<MsgElement> arrayList2 = replyMsgRecord.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "replyMsgRecord.elements");
            for (MsgElement msgElement : arrayList2) {
                int i3 = msgElement.elementType;
                if (i3 == 1 || i3 == 3 || i3 == 6 || i3 == 14) {
                    arrayList.add(msgElement);
                }
            }
            return iq0.a.p(arrayList, false, false, 4, null).toString();
        }
        String str = replyElement.sourceMsgText;
        Intrinsics.checkNotNullExpressionValue(str, "replyElement.sourceMsgText");
        return str;
    }

    private final TextView s1() {
        Object value = this.sourceMsgTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sourceMsgTextView>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(GuildMsgItem msgItem, ReplyElement replyElement, MsgRecord replyMsgRecord) {
        if (replyMsgRecord == null) {
            QLog.d("ReplyContentComponent", 1, "handleGetReplyMsgRecordResult replyMsgRecord is null. msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq() + " replyMsgSeq = " + replyElement.replayMsgSeq);
        }
        if (replyMsgRecord != null) {
            this.mReplyMsgRevoked = d.a(replyMsgRecord);
            this.mReplyMsgSenderId = replyMsgRecord.senderUid;
            A1(msgItem.isSelf(), replyElement, p1(String.valueOf(replyElement.senderUid), f.a(msgItem), replyMsgRecord), r1(replyMsgRecord, replyElement));
        }
    }

    private final void v1(String tinyId) {
        ReplyElement o16;
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null && Intrinsics.areEqual(tinyId, this.mReplyMsgSenderId) && !this.mReplyMsgRevoked && (o16 = o1(guildMsgItem)) != null) {
            String q16 = q1(this, String.valueOf(o16.senderUid), f.a(guildMsgItem), null, 4, null);
            QLog.d("ReplyContentComponent", 1, "handleReplyMsgNickNameChanged replyNickName = " + q16);
            String str = this.mSourceMsgText;
            if (str != null) {
                A1(guildMsgItem.isSelf(), o16, q16, str);
            }
        }
    }

    private final void w1() {
        ReplyElement o16;
        this.mReplyMsgRevoked = true;
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null && (o16 = o1(guildMsgItem)) != null) {
            String string = this.root.getContext().getString(R.string.f153011ay);
            Intrinsics.checkNotNullExpressionValue(string, "root.context.getString(R\u2026_reply_source_msg_revoke)");
            A1(guildMsgItem.isSelf(), o16, "", string);
        }
    }

    private final boolean x1(GuildMsgItem guildMsgItem, ReplyElement replyElement) {
        Long l3;
        Long l16 = replyElement.replayMsgSeq;
        if ((l16 != null && (l3 = replyElement.replayMsgRootSeq) != null && Intrinsics.areEqual(l16, l3)) || guildMsgItem.getIsNeedCombine()) {
            return false;
        }
        return true;
    }

    private final boolean y1(MsgRecord msgRecord) {
        MsgElement c16;
        GrayTipElement grayTipElement;
        int i3 = msgRecord.msgType;
        if (i3 == 1) {
            return true;
        }
        if (i3 == 5 && (c16 = iq0.a.c(8, msgRecord)) != null && (grayTipElement = c16.grayTipElement) != null && grayTipElement.subElementType == 1) {
            return true;
        }
        return false;
    }

    private final boolean z1(GuildMsgItem msgItem, List<Object> payloads) {
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null) {
            Intrinsics.checkNotNull(guildMsgItem);
            if (guildMsgItem.isSameItem(msgItem)) {
                boolean z16 = true;
                for (Object obj : payloads) {
                    if (obj instanceof HashMap) {
                        Map map = (Map) obj;
                        if (map.get(GuildMsgItemPayloadType.REPLAY_MSG_COMMENT_COUNT_PAYLOAD) != null) {
                            z16 = false;
                        }
                        if (map.get(GuildMsgItemPayloadType.REPLY_MSG_REVOKED_PAYLOAD) != null) {
                            w1();
                            QLog.d("ReplyContentComponent", 1, "REPLY_MSG_REVOKED_PAYLOAD msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq() + " revoked!");
                            z16 = false;
                        }
                    }
                }
                return z16;
            }
        }
        return true;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        if (!z1(guildMsgItem, payloads)) {
            this.mCurrentMsgItem = guildMsgItem;
            return;
        }
        s1().setVisibility(4);
        this.mCurrentMsgItem = guildMsgItem;
        this.mReplyMsgSenderId = "";
        this.mReplyMsgRevoked = false;
        this.mSourceMsgText = "";
        final ReplyElement o16 = o1(guildMsgItem);
        if (o16 != null) {
            Contact contact = new Contact(guildMsgItem.getMsgRecord().chatType, guildMsgItem.getMsgRecord().peerUid, f.a(guildMsgItem));
            if (!x1(guildMsgItem, o16)) {
                n1().setVisibility(8);
                ImageView imageView = (ImageView) this.root.findViewById(R.id.f73123sp);
                if (imageView != null) {
                    Intrinsics.checkNotNullExpressionValue(imageView, "findViewById<ImageView>(R.id.reply_divide_line)");
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(o16.replayMsgSeq);
            QLog.d("ReplyContentComponent", 1, "bind begin msgItem msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq() + " replyMsgSeq = " + o16.replayMsgSeq);
            final long msgId = msgItem.getMsgId();
            ((IMsgService) QRoute.api(IMsgService.class)).getMsgsBySeqs(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.guild.aio.article.msglist.holder.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList2) {
                    GuildArticleReplyComponent.m1(msgId, this, msgItem, o16, i3, str, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return n1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new c();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        String tinyId;
        Intrinsics.checkNotNullParameter(state, "state");
        if ((state instanceof GuildReplyMsgNickState) && (tinyId = ((GuildReplyMsgNickState) state).getTinyId()) != null) {
            v1(tinyId);
        }
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
