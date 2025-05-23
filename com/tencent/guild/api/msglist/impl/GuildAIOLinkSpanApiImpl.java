package com.tencent.guild.api.msglist.impl;

import android.content.Context;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ark.ark;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J@\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001cH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/api/msglist/impl/GuildAIOLinkSpanApiImpl;", "Lcom/tencent/guild/api/msglist/IGuildAIOLinkSpanApi;", "()V", NodeProps.ON_CLICK, "", "url", "", "hashTagLinkParams", "", ark.APP_SPECIFIC_BIZSRC, AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/view/View;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "onInlineBtnClick", "app", "Lmqq/app/AppRuntime;", "context", "Landroid/content/Context;", "data", "parseLinkSpan", "", "Lkotlin/Triple;", "", "content", "enableHashTagLink", "", "unMatchTypes", "", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildAIOLinkSpanApiImpl implements IGuildAIOLinkSpanApi {
    @Override // com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi
    public void onClick(@NotNull String url, @Nullable Object hashTagLinkParams, @NotNull String bizSrc, @NotNull View widget, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ChatMessage chatMessage = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).convertToChatMessage(MobileQQ.sMobileQQ.peekAppRuntime(), msgRecord);
        chatMessage.extObj = msgRecord;
        IGuildAIOLinkSpanUtilsApi iGuildAIOLinkSpanUtilsApi = (IGuildAIOLinkSpanUtilsApi) QRoute.api(IGuildAIOLinkSpanUtilsApi.class);
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "sMobileQQ.peekAppRuntime().account");
        Intrinsics.checkNotNullExpressionValue(chatMessage, "chatMessage");
        iGuildAIOLinkSpanUtilsApi.onClick(url, hashTagLinkParams, bizSrc, widget, account, chatMessage);
    }

    @Override // com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi
    public void onInlineBtnClick(@NotNull AppRuntime app, @NotNull Context context, @NotNull String data) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        ((IGuildAIOLinkSpanUtilsApi) QRoute.api(IGuildAIOLinkSpanUtilsApi.class)).onInlineBtnClick(app, context, data);
    }

    @Override // com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi
    @NotNull
    public List<Triple<String, Integer, Integer>> parseLinkSpan(@NotNull String content, boolean enableHashTagLink, @Nullable Set<Integer> unMatchTypes) {
        Intrinsics.checkNotNullParameter(content, "content");
        return ((IGuildAIOLinkSpanUtilsApi) QRoute.api(IGuildAIOLinkSpanUtilsApi.class)).parseLinkSpan(content, enableHashTagLink, unMatchTypes);
    }

    @Override // com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi
    public void onClick(@NotNull String url, @NotNull String bizSrc, @NotNull View widget, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        onClick(url, null, bizSrc, widget, msgRecord);
    }
}
