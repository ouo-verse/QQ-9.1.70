package com.tencent.guild.aio.msglist.text.util;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bq0.GuildHighlightParams;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.input.at.hashtag.ui.k;
import com.tencent.guild.aio.msglist.markdown.LinkSpanEntity;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.m;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u009d\u0001\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eJp\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010&0%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011J \u0010*\u001a\u00020)2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004JG\u0010+\u001a\u00020)2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014J?\u0010,\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014\u00a8\u0006/"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/TextBubbleContentParser;", "", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/widget/TextView;", "tv", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Lbq0/a$a;", "style", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "emoSize", "", "isSelf", "isArticleMain", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "url", "urlClickCb", "useGuildSpan", "useNewAtJumpChannelStyle", "Landroid/text/SpannableStringBuilder;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "j", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lkotlin/Pair;", "Landroid/text/method/MovementMethod;", tl.h.F, "result", "", "b", "c", "f", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class TextBubbleContentParser {

    /* renamed from: a */
    @NotNull
    public static final TextBubbleContentParser f111932a = new TextBubbleContentParser();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BF\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012%\b\u0002\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001c\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR1\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/TextBubbleContentParser$a;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "", "d", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "Lcom/tencent/mobileqq/text/m;", "e", "Lcom/tencent/mobileqq/text/m;", "getHashTagLinkParams", "()Lcom/tencent/mobileqq/text/m;", "hashTagLinkParams", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsgRecord", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "setMsgRecord", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "msgRecord", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", tl.h.F, "Lkotlin/jvm/functions/Function1;", "urlClickCb", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/text/m;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lkotlin/jvm/functions/Function1;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: d, reason: from kotlin metadata */
        @NotNull
        private String url;

        /* renamed from: e, reason: from kotlin metadata */
        @NotNull
        private final m hashTagLinkParams;

        /* renamed from: f, reason: from kotlin metadata */
        @NotNull
        private MsgRecord msgRecord;

        /* renamed from: h */
        @Nullable
        private final Function1<String, Boolean> urlClickCb;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull String url, @NotNull m hashTagLinkParams, @NotNull MsgRecord msgRecord, @Nullable Function1<? super String, Boolean> function1) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(hashTagLinkParams, "hashTagLinkParams");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            this.url = url;
            this.hashTagLinkParams = hashTagLinkParams;
            this.msgRecord = msgRecord;
            this.urlClickCb = function1;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Function1<String, Boolean> function1 = this.urlClickCb;
            boolean z16 = false;
            if (function1 != null && function1.invoke(this.url).booleanValue()) {
                z16 = true;
            }
            if (z16) {
                return;
            }
            HashMap hashMap = new HashMap();
            String str = this.msgRecord.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.guildId");
            hashMap.put("sgrp_channel_id", str);
            String str2 = this.msgRecord.channelId;
            Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.channelId");
            hashMap.put("sgrp_sub_channel_id", str2);
            VideoReport.reportEvent("ev_sgrp_click_link", hashMap);
            ((IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class)).onClick(this.url, this.hashTagLinkParams, "biz_src_jc_aio", widget, this.msgRecord);
        }
    }

    TextBubbleContentParser() {
    }

    private final int a() {
        return 3;
    }

    public static /* synthetic */ SpannableStringBuilder e(TextBubbleContentParser textBubbleContentParser, MsgRecord msgRecord, TextView textView, ArrayList arrayList, GuildHighlightParams.GuildHighlightStyle guildHighlightStyle, com.tencent.aio.api.runtime.a aVar, int i3, boolean z16, boolean z17, Function1 function1, boolean z18, boolean z19, int i16, Object obj) {
        return textBubbleContentParser.d(msgRecord, textView, arrayList, (i16 & 8) != 0 ? null : guildHighlightStyle, (i16 & 16) != 0 ? null : aVar, (i16 & 32) != 0 ? 18 : i3, z16, (i16 & 128) != 0 ? false : z17, (i16 & 256) != 0 ? null : function1, (i16 & 512) != 0 ? false : z18, (i16 & 1024) != 0 ? false : z19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MovementMethod g(TextBubbleContentParser textBubbleContentParser, SpannableStringBuilder spannableStringBuilder, MsgRecord msgRecord, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return textBubbleContentParser.f(spannableStringBuilder, msgRecord, function1);
    }

    public static /* synthetic */ Pair i(TextBubbleContentParser textBubbleContentParser, Context context, MsgRecord msgRecord, ArrayList arrayList, GuildHighlightParams.GuildHighlightStyle guildHighlightStyle, AIOParam aIOParam, int i3, boolean z16, boolean z17, int i16, Object obj) {
        GuildHighlightParams.GuildHighlightStyle guildHighlightStyle2;
        AIOParam aIOParam2;
        int i17;
        boolean z18;
        if ((i16 & 8) != 0) {
            guildHighlightStyle2 = null;
        } else {
            guildHighlightStyle2 = guildHighlightStyle;
        }
        if ((i16 & 16) != 0) {
            aIOParam2 = null;
        } else {
            aIOParam2 = aIOParam;
        }
        if ((i16 & 32) != 0) {
            i17 = 18;
        } else {
            i17 = i3;
        }
        if ((i16 & 128) != 0) {
            z18 = false;
        } else {
            z18 = z17;
        }
        return textBubbleContentParser.h(context, msgRecord, arrayList, guildHighlightStyle2, aIOParam2, i17, z16, z18);
    }

    public final void b(@Nullable TextView tv5, @NotNull SpannableStringBuilder result, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        c(tv5, result, msgRecord, null);
    }

    public final void c(@Nullable TextView tv5, @NotNull SpannableStringBuilder result, @NotNull MsgRecord msgRecord, @Nullable Function1<? super String, Boolean> urlClickCb) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MovementMethod f16 = f(result, msgRecord, urlClickCb);
        if (f16 != null && tv5 != null) {
            tv5.setMovementMethod(f16);
        }
    }

    @NotNull
    public final SpannableStringBuilder d(@NotNull MsgRecord msgRecord, @NotNull TextView tv5, @NotNull ArrayList<MsgElement> msgElements, @Nullable GuildHighlightParams.GuildHighlightStyle style, @Nullable com.tencent.aio.api.runtime.a aioContext, int emoSize, boolean isSelf, boolean isArticleMain, @Nullable Function1<? super String, Boolean> urlClickCb, boolean useGuildSpan, boolean useNewAtJumpChannelStyle) {
        IGuildMsgElementApi iGuildMsgElementApi;
        String str;
        String str2;
        GuildHighlightParams guildHighlightParams;
        Fragment c16;
        AIOParam g16;
        Integer d16;
        AIOParam g17;
        Bundle l3;
        AIOParam g18;
        Bundle l16;
        AIOParam g19;
        String g26;
        AIOParam g27;
        AIOParam g28;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(tv5, "tv");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (msgElements.isEmpty()) {
            return spannableStringBuilder;
        }
        QRouteApi api = QRoute.api(IGuildMsgElementApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMsgElementApi::class.java)");
        IGuildMsgElementApi iGuildMsgElementApi2 = (IGuildMsgElementApi) api;
        for (MsgElement msgElement : msgElements) {
            int i3 = msgElement.elementType;
            if (i3 == 6) {
                FaceElement faceElement = msgElement.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                    spannableStringBuilder.append(d.d(d.f111941a, faceElement, emoSize, false, useGuildSpan, 4, null));
                }
            } else if (i3 == 1) {
                String elementContent = iGuildMsgElementApi2.getElementContent(msgElement);
                if (msgElement.textElement.atType != 0) {
                    int length = spannableStringBuilder.length();
                    SpannableStringBuilder it = spannableStringBuilder.append((CharSequence) elementContent);
                    Bundle bundle = new Bundle();
                    bundle.putString("jumpChannelId", String.valueOf(msgElement.textElement.atChannelId));
                    String str3 = "";
                    if (aioContext == null || (g28 = aioContext.g()) == null || (str = com.tencent.guild.aio.util.a.b(g28)) == null) {
                        str = "";
                    }
                    bundle.putString("sourceChannelId", str);
                    if (aioContext == null || (g27 = aioContext.g()) == null || (str2 = g27.n()) == null) {
                        str2 = "";
                    }
                    bundle.putString("factoryName", str2);
                    if (aioContext != null && (g19 = aioContext.g()) != null && (g26 = com.tencent.guild.aio.util.a.g(g19)) != null) {
                        str3 = g26;
                    }
                    bundle.putString("guildId", str3);
                    FragmentActivity fragmentActivity = null;
                    JumpGuildParam.JoinInfoParam joinInfoParam = (aioContext == null || (g18 = aioContext.g()) == null || (l16 = g18.l()) == null) ? null : (JumpGuildParam.JoinInfoParam) l16.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                    GuildAppReportSourceInfo guildAppReportSourceInfo = (aioContext == null || (g17 = aioContext.g()) == null || (l3 = g17.l()) == null) ? null : (GuildAppReportSourceInfo) l3.getParcelable("GuildAppReportSourceInfo");
                    bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
                    bundle.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
                    bundle.putBoolean("isSelf", isSelf);
                    bundle.putBoolean("IS_ARTICLE_MAIN", isArticleMain);
                    if (aioContext != null && (g16 = aioContext.g()) != null && (d16 = com.tencent.guild.aio.util.a.d(g16)) != null) {
                        bundle.putInt("CHANNEL_TYPE", d16.intValue());
                    }
                    bundle.putBoolean("NEW_AT_JUMP_CHANNEL_STYLE", useNewAtJumpChannelStyle);
                    if (aioContext != null && (c16 = aioContext.c()) != null) {
                        fragmentActivity = c16.getActivity();
                    }
                    WeakReference weakReference = new WeakReference(fragmentActivity);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    iGuildMsgElementApi = iGuildMsgElementApi2;
                    GuildHighlightParams guildHighlightParams2 = new GuildHighlightParams(weakReference, tv5, it, length, it.length(), msgElement.textElement.atType, bundle, false, null, 0, 896, null);
                    TextElement textElement = msgElement.textElement;
                    if (textElement.atType == 8) {
                        Integer num = textElement.atRoleColor;
                        Intrinsics.checkNotNullExpressionValue(num, "element.textElement.atRoleColor");
                        guildHighlightParams = guildHighlightParams2;
                        guildHighlightParams.k(num.intValue());
                    } else {
                        guildHighlightParams = guildHighlightParams2;
                    }
                    if (style != null) {
                        guildHighlightParams.l(style);
                    }
                    bq0.e.f28951a.m(guildHighlightParams);
                    spannableStringBuilder = it;
                } else {
                    iGuildMsgElementApi = iGuildMsgElementApi2;
                    spannableStringBuilder.append((CharSequence) new QQText(elementContent, f111932a.a(), 16));
                }
                iGuildMsgElementApi2 = iGuildMsgElementApi;
            }
            iGuildMsgElementApi = iGuildMsgElementApi2;
            iGuildMsgElementApi2 = iGuildMsgElementApi;
        }
        c(tv5, spannableStringBuilder, msgRecord, urlClickCb);
        return spannableStringBuilder;
    }

    @Nullable
    public final MovementMethod f(@NotNull SpannableStringBuilder result, @NotNull MsgRecord msgRecord, @Nullable Function1<? super String, Boolean> urlClickCb) {
        Long longOrNull;
        long j3;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (result.length() >= 1000) {
            return null;
        }
        m.Companion companion = m.INSTANCE;
        String str = msgRecord.channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.channelId");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        m a16 = companion.a(j3, 4);
        com.tencent.guild.aio.util.j jVar = com.tencent.guild.aio.util.j.f112409a;
        String spannableStringBuilder = result.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "result.toString()");
        List<LinkSpanEntity> b16 = com.tencent.guild.aio.util.j.b(jVar, spannableStringBuilder, a16.enable, null, 4, null);
        if (b16.isEmpty()) {
            return null;
        }
        for (LinkSpanEntity linkSpanEntity : b16) {
            Object[] spans = result.getSpans(linkSpanEntity.getStart(), linkSpanEntity.getEnd(), Object.class);
            Intrinsics.checkNotNullExpressionValue(spans, "spans");
            int length = spans.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (!(spans[i3] instanceof EmoticonSpan)) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (z16) {
                int start = linkSpanEntity.getStart();
                int end = linkSpanEntity.getEnd();
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(spans, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Object, CharSequence>() { // from class: com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser$preParseLinkSpan$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(Object obj) {
                        return obj.toString();
                    }
                }, 31, (Object) null);
                QLog.e("GuildPreParseLinkSpan", 1, start + ".." + end + " has " + joinToString$default + " ignore " + linkSpanEntity);
            } else {
                result.setSpan(new a(linkSpanEntity.getContent(), a16, msgRecord, urlClickCb), linkSpanEntity.getStart(), linkSpanEntity.getEnd(), 33);
            }
        }
        return new k();
    }

    @NotNull
    public final Pair<SpannableStringBuilder, MovementMethod> h(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull ArrayList<MsgElement> msgElements, @Nullable GuildHighlightParams.GuildHighlightStyle guildHighlightStyle, @Nullable AIOParam aIOParam, int i3, boolean z16, boolean z17) {
        String str;
        String str2;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        Bundle l3;
        Bundle l16;
        String n3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        SpannableStringBuilder it = new SpannableStringBuilder();
        if (msgElements.isEmpty()) {
            return new Pair<>(it, null);
        }
        QRouteApi api = QRoute.api(IGuildMsgElementApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMsgElementApi::class.java)");
        IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) api;
        MovementMethod movementMethod = null;
        for (MsgElement msgElement : msgElements) {
            int i16 = msgElement.elementType;
            if (i16 == 6) {
                FaceElement faceElement = msgElement.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                    it.append(d.d(d.f111941a, faceElement, i3, false, false, 12, null));
                }
            } else if (i16 == 1) {
                String elementContent = iGuildMsgElementApi.getElementContent(msgElement);
                if (msgElement.textElement.atType != 0) {
                    int length = it.length();
                    it = it.append((CharSequence) elementContent);
                    Bundle bundle = new Bundle();
                    String str3 = "";
                    if (aIOParam == null || (str = com.tencent.guild.aio.util.a.g(aIOParam)) == null) {
                        str = "";
                    }
                    if (aIOParam == null || (str2 = com.tencent.guild.aio.util.a.b(aIOParam)) == null) {
                        str2 = "";
                    }
                    int channelType = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(MobileQQ.sMobileQQ.peekAppRuntime(), str, str2);
                    bundle.putString("jumpChannelId", String.valueOf(msgElement.textElement.atChannelId));
                    bundle.putString("sourceChannelId", str2);
                    if (aIOParam != null && (n3 = aIOParam.n()) != null) {
                        str3 = n3;
                    }
                    bundle.putString("factoryName", str3);
                    bundle.putString("guildId", str);
                    bundle.putInt("CHANNEL_TYPE", channelType);
                    if (aIOParam != null && (l16 = aIOParam.l()) != null) {
                        joinInfoParam = (JumpGuildParam.JoinInfoParam) l16.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                    } else {
                        joinInfoParam = null;
                    }
                    if (aIOParam != null && (l3 = aIOParam.l()) != null) {
                        guildAppReportSourceInfo = (GuildAppReportSourceInfo) l3.getParcelable("GuildAppReportSourceInfo");
                    } else {
                        guildAppReportSourceInfo = null;
                    }
                    bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
                    bundle.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
                    bundle.putBoolean("isSelf", z16);
                    bundle.putBoolean("IS_ARTICLE_MAIN", z17);
                    WeakReference weakReference = new WeakReference(context);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    GuildHighlightParams guildHighlightParams = new GuildHighlightParams(weakReference, null, it, length, it.length(), msgElement.textElement.atType, bundle, false, null, 0, 896, null);
                    if (msgElement.textElement.atType == 8) {
                        boolean isNowThemeIsNight = ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isNowThemeIsNight();
                        if (!z16 || isNowThemeIsNight) {
                            Integer num = msgElement.textElement.atRoleColor;
                            Intrinsics.checkNotNullExpressionValue(num, "element.textElement.atRoleColor");
                            guildHighlightParams.k(num.intValue());
                        }
                    }
                    if (guildHighlightStyle != null) {
                        guildHighlightParams.l(guildHighlightStyle);
                    }
                    movementMethod = bq0.e.f28951a.p(guildHighlightParams, context, movementMethod);
                } else {
                    it.append((CharSequence) new QQText(elementContent, f111932a.a(), 16));
                }
            }
        }
        MovementMethod g16 = g(this, it, msgRecord, null, 4, null);
        if (g16 != null) {
            movementMethod = g16;
        }
        return new Pair<>(it, movementMethod);
    }

    public final boolean j(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.isMixMsg()) {
            return false;
        }
        return msgItem.isSelf();
    }
}
