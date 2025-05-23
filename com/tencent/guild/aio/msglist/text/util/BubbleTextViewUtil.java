package com.tencent.guild.aio.msglist.text.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.guild.aio.input.at.hashtag.ui.k;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nJ\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\bJ@\u0010!\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u001c2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fJ\u0006\u0010\"\u001a\u00020\bJ\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006JB\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u001cR\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R#\u00100\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020)0,8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/BubbleTextViewUtil;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", tl.h.F, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", "Landroid/text/method/MovementMethod;", "movementMethod", "Lwq0/l;", "txtView", "", DomainData.DOMAIN_NAME, "d", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "c", "width", "b", "isPreCreate", "e", "textView", "Lcom/tencent/aio/data/msglist/a;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "tempList", "r", "p", "i", "elemList", "Landroid/text/SpannableStringBuilder;", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "Ljava/lang/Object;", "Ljava/lang/Object;", "DUMMY_OBJ", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "k", "()Ljava/util/concurrent/ConcurrentHashMap;", "TEXT_CONTENT_LAYOUT_WIDTH_SIZE", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class BubbleTextViewUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final BubbleTextViewUtil f111916a = new BubbleTextViewUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object DUMMY_OBJ = new Object();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Object> TEXT_CONTENT_LAYOUT_WIDTH_SIZE = new ConcurrentHashMap<>();

    static {
        boolean z16;
        List<Integer> aioBubbleWidth = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getAioBubbleWidth();
        List<Integer> list = aioBubbleWidth;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            for (Integer w3 : aioBubbleWidth) {
                ConcurrentHashMap<Integer, Object> concurrentHashMap = TEXT_CONTENT_LAYOUT_WIDTH_SIZE;
                Intrinsics.checkNotNullExpressionValue(w3, "w");
                concurrentHashMap.put(w3, DUMMY_OBJ);
            }
        }
    }

    BubbleTextViewUtil() {
    }

    private final void d(GuildMsgItem msgItem) {
        ArrayList<Object> h16 = msgItem.getPreParseInfo().h();
        if (h16 != null) {
            Iterator<Object> it = h16.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof Pair) {
                    Pair pair = (Pair) next;
                    if ((pair.getFirst() instanceof com.tencent.aio.widget.textView.param.b) && (pair.getSecond() instanceof Layout)) {
                        wq0.j jVar = wq0.j.f446044a;
                        Object first = pair.getFirst();
                        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type com.tencent.aio.widget.textView.param.AIOStaticParam");
                        Object second = pair.getSecond();
                        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type android.text.Layout");
                        jVar.a((com.tencent.aio.widget.textView.param.b) first, (Layout) second);
                    }
                }
            }
        }
    }

    public static /* synthetic */ l f(BubbleTextViewUtil bubbleTextViewUtil, Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return bubbleTextViewUtil.e(context, z16);
    }

    private final int g(AIOParam aioParam) {
        int i3;
        if (aioParam != null) {
            try {
                Bundle l3 = aioParam.l();
                if (l3 != null) {
                    i3 = l3.getInt("AIOParam_FromScene", FromScene.DEFAULT.ordinal());
                    return i3;
                }
            } catch (Exception unused) {
                return FromScene.DEFAULT.ordinal();
            }
        }
        i3 = FromScene.DEFAULT.ordinal();
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (r4 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String h(GuildMsgItem msgItem) {
        String joinToString$default;
        boolean z16;
        final IGPSService d16 = at.d();
        if (d16 == null) {
            return "";
        }
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null) {
                Intrinsics.checkNotNullExpressionValue(textElement, "textElement");
                if (textElement.atType == 16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            textElement = null;
            if (textElement != null) {
                arrayList2.add(textElement);
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, new Function1<TextElement, CharSequence>() { // from class: com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil$getMsgElementsKeyId$elementsKeyId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull TextElement textElement2) {
                String num;
                Intrinsics.checkNotNullParameter(textElement2, "textElement");
                IGProChannelInfo channelInfo = IGPSService.this.getChannelInfo(String.valueOf(textElement2.atChannelId));
                return (channelInfo == null || (num = Integer.valueOf(channelInfo.getType()).toString()) == null) ? "" : num;
            }
        }, 31, null);
        return joinToString$default;
    }

    private final boolean m(AIOParam aioParam) {
        if (g(aioParam) == FromScene.DEFAULT.ordinal()) {
            return true;
        }
        return false;
    }

    private final void n(MovementMethod movementMethod, l txtView) {
        if (movementMethod instanceof k) {
            l.a.a(txtView, (com.tencent.aio.widget.textView.view.b) movementMethod, false, 2, null);
            txtView.getView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.text.util.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BubbleTextViewUtil.o(view);
                }
            });
            VideoReport.setElementId(txtView.getView(), "em_sgrp_sub_channel_link");
            VideoReport.setElementExposePolicy(txtView.getView(), ExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void b(int width) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap = TEXT_CONTENT_LAYOUT_WIDTH_SIZE;
        if (concurrentHashMap.size() > 2) {
            concurrentHashMap.clear();
        }
        int size = concurrentHashMap.size();
        concurrentHashMap.put(Integer.valueOf(width), DUMMY_OBJ);
        int size2 = concurrentHashMap.size();
        if (size != size2 && size2 == 2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(concurrentHashMap.keySet());
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "BubbleTextViewUtil_addTextContentLayoutWidth", null, null, null, new BubbleTextViewUtil$addTextContentLayoutWidth$1(arrayList, null), 14, null);
            }
        }
    }

    @NotNull
    public final TextView c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TextView createGuildETTextView = ((IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class)).createGuildETTextView(context);
        createGuildETTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).fixTextViewANRForAnd10(createGuildETTextView);
        createGuildETTextView.setSpannableFactory(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoSpanFactory());
        int i3 = 0;
        createGuildETTextView.setClickable(false);
        createGuildETTextView.setFocusable(false);
        createGuildETTextView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.ayp));
        createGuildETTextView.setId(R.id.vxp);
        if (AppSetting.f99565y) {
            i3 = 3;
        }
        createGuildETTextView.setAutoLinkMask(i3);
        return createGuildETTextView;
    }

    @NotNull
    public final l e(@NotNull Context context, boolean isPreCreate) {
        Intrinsics.checkNotNullParameter(context, "context");
        l c16 = wq0.j.c(wq0.j.f446044a, context, isPreCreate, false, 4, null);
        c16.getView().setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        c16.getView().setClickable(false);
        c16.getView().setFocusable(false);
        c16.setTextSize(17.0f);
        c16.b(new wq0.i());
        c16.getView().setId(R.id.vxp);
        return c16;
    }

    @NotNull
    public final String i(@NotNull GuildMsgItem msgItem, @Nullable AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        StringBuilder sb5 = new StringBuilder();
        String h16 = h(msgItem);
        sb5.append(msgItem.getMsgId());
        sb5.append("_");
        sb5.append(msgItem.getMsgRecord().peerUid);
        sb5.append(h16);
        sb5.append(g(aioParam));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @NotNull
    public final SpannableStringBuilder j(@NotNull GuildMsgItem msgItem, @NotNull l txtView, @NotNull ArrayList<MsgElement> elemList, @Nullable Context context, @Nullable AIOParam aioParam) {
        SpannableStringBuilder textComponent;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(txtView, "txtView");
        Intrinsics.checkNotNullParameter(elemList, "elemList");
        if (m(aioParam) && (textComponent = msgItem.getPreParseInfo().getTextComponent()) != null) {
            BubbleTextViewUtil bubbleTextViewUtil = f111916a;
            bubbleTextViewUtil.n(msgItem.getPreParseInfo().getTextViewMovementMethod(), txtView);
            bubbleTextViewUtil.d(msgItem);
            return textComponent;
        }
        if (context != null) {
            TextBubbleContentParser textBubbleContentParser = TextBubbleContentParser.f111932a;
            MsgRecord msgRecord = msgItem.getMsgRecord();
            bq0.e eVar = bq0.e.f28951a;
            boolean j3 = textBubbleContentParser.j(msgItem);
            BubbleTextViewUtil bubbleTextViewUtil2 = f111916a;
            Pair i3 = TextBubbleContentParser.i(textBubbleContentParser, context, msgRecord, elemList, eVar.h(j3, true, bubbleTextViewUtil2.q(msgItem), 17.0f, 17.0f), aioParam, 0, textBubbleContentParser.j(msgItem), bubbleTextViewUtil2.l(msgItem), 32, null);
            if (bubbleTextViewUtil2.m(aioParam)) {
                msgItem.getPreParseInfo().p((SpannableStringBuilder) i3.getFirst());
                msgItem.getPreParseInfo().r((MovementMethod) i3.getSecond());
                SpannableStringBuilder textComponent2 = msgItem.getPreParseInfo().getTextComponent();
                if (textComponent2 != null) {
                    bubbleTextViewUtil2.n((MovementMethod) i3.getSecond(), txtView);
                    return textComponent2;
                }
            } else {
                bubbleTextViewUtil2.n((MovementMethod) i3.getSecond(), txtView);
                return (SpannableStringBuilder) i3.getFirst();
            }
        }
        return new SpannableStringBuilder();
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Object> k() {
        return TEXT_CONTENT_LAYOUT_WIDTH_SIZE;
    }

    public final boolean l(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        GuildMsgItem guildMsgItem;
        boolean equals$default;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        try {
            if (msgItem instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) msgItem;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem == null) {
                return false;
            }
            String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, "guild_article_is_main_msg", null, 2, null);
            if (!TextUtils.isEmpty(extInfoFromExtStr$default)) {
                equals$default = StringsKt__StringsJVMKt.equals$default(extInfoFromExtStr$default, "1", false, 2, null);
                if (equals$default) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.e("BubbleTextViewUtil", 1, "isArticleMainMsgItem", e16);
            return false;
        }
    }

    public final boolean p() {
        boolean contains$default;
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, false, 2, (Object) null);
        if (contains$default) {
            return false;
        }
        return true;
    }

    public final boolean q(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return !TextUtils.isEmpty(GuildMsgItem.getExtInfoFromExtStr$default(msgItem, "guild_article_is_main_msg", null, 2, null));
    }

    public final void r(@NotNull Context context, @Nullable AIOParam aioParam, @NotNull l textView, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull ArrayList<MsgElement> tempList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(tempList, "tempList");
        if (msgItem.isSelf()) {
            f fVar = f.f111944a;
            textView.setTextColor(fVar.m(context));
            textView.setLinkTextColor(fVar.j(context));
        } else {
            f fVar2 = f.f111944a;
            textView.setTextColor(fVar2.g(context));
            textView.setLinkTextColor(fVar2.d(context));
        }
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        SpannableStringBuilder j3 = j(guildMsgItem, textView, tempList, context, aioParam);
        textView.f(j3, i(guildMsgItem, aioParam));
        textView.getView().setContentDescription(((ITextUtilsApi) QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(j3.toString()));
        if (!p()) {
            textView.k();
        }
    }
}
