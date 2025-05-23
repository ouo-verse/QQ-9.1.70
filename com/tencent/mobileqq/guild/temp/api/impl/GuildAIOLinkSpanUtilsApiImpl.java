package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ark.ark;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.impl.GuildWebApiImpl;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.m;
import com.tencent.mobileqq.text.n;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016JH\u0010\u0015\u001a\"\u0012\u001e\u0012\u001c\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00170\u00162\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eH\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildAIOLinkSpanUtilsApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildAIOLinkSpanUtilsApi;", "()V", NodeProps.ON_CLICK, "", "url", "", "hashTagLinkParams", "", ark.APP_SPECIFIC_BIZSRC, AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/view/View;", "uin", "msg", "Lcom/tencent/mobileqq/data/MessageRecord;", "onInlineBtnClick", "app", "Lmqq/app/AppRuntime;", "context", "Landroid/content/Context;", "data", "parseLinkSpan", "", "Lkotlin/Triple;", "kotlin.jvm.PlatformType", "", "content", "enableHashTagLink", "", "unMatchTypes", "", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GuildAIOLinkSpanUtilsApiImpl implements IGuildAIOLinkSpanUtilsApi {
    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi
    public void onClick(String url, String bizSrc, View widget) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        Intrinsics.checkNotNullParameter(widget, "widget");
        LinkSpan linkSpan = new LinkSpan(url);
        linkSpan.o(bizSrc);
        linkSpan.onClick(widget);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi
    public void onInlineBtnClick(AppRuntime app, Context context, String data) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.length() == 0) {
            return;
        }
        QRouteApi api = QRoute.api(IMiniAppService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
        IMiniAppService iMiniAppService = (IMiniAppService) api;
        if (iMiniAppService.isMiniAppUrl(data)) {
            iMiniAppService.startMiniApp(app.getApp(), data, 5006, new MiniAppLaunchListener() { // from class: com.tencent.mobileqq.guild.temp.api.impl.a
                @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                public final void onLaunchResult(boolean z16, Bundle bundle) {
                    GuildAIOLinkSpanUtilsApiImpl.onInlineBtnClick$lambda$1(z16, bundle);
                }
            });
            return;
        }
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isGuildShareUrl(data)) {
            GuildShareUrlParam guildShareUrlParam = new GuildShareUrlParam(data);
            Bundle bundle = new Bundle();
            bundle.putBoolean("open_channel_on_standalone_page", true);
            guildShareUrlParam.b(bundle);
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuild(context, guildShareUrlParam);
            return;
        }
        GuildWebApiImpl.Companion.c(GuildWebApiImpl.INSTANCE, app.getApp(), data, null, null, null, 28, null);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi
    public List<Triple<String, Integer, Integer>> parseLinkSpan(String content, boolean enableHashTagLink, Set<Integer> unMatchTypes) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(content, "content");
        List<com.tencent.mobileqq.text.d> c16 = n.c(content, enableHashTagLink, unMatchTypes);
        Intrinsics.checkNotNullExpressionValue(c16, "parseLinkSpan(content, e\u2026ashTagLink, unMatchTypes)");
        List<com.tencent.mobileqq.text.d> list = c16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.mobileqq.text.d dVar : list) {
            arrayList.add(new Triple(dVar.f292676a, Integer.valueOf(dVar.f292677b), Integer.valueOf(dVar.f292678c)));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi
    public void onClick(String url, Object hashTagLinkParams, String bizSrc, View widget, String uin, MessageRecord msg2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        LinkSpan linkSpan = new LinkSpan(url, uin, msg2);
        linkSpan.o(bizSrc);
        m mVar = hashTagLinkParams instanceof m ? (m) hashTagLinkParams : null;
        if (mVar != null) {
            linkSpan.q(mVar);
        }
        linkSpan.onClick(widget);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInlineBtnClick$lambda$1(boolean z16, Bundle bundle) {
    }
}
