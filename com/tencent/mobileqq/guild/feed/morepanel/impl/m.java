package com.tencent.mobileqq.guild.feed.morepanel.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J.\u0010\r\u001a\u00020\u000b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/impl/m;", "", "Lvk1/b;", "feedData", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "", "operationList", "", "d", "c", "", "guildId", "channelId", "", "a", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f220412a = new m();

    m() {
    }

    private final boolean a(long guildId, long channelId) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return false;
        }
        if (!iGPSService.getGuildPermission(String.valueOf(guildId)).a(30002) && !iGPSService.getChannelPermission(String.valueOf(guildId), String.valueOf(channelId)).a(30002)) {
            return false;
        }
        return true;
    }

    private final void c(PanelContext<Activity, vk1.b> panelContext, List<Integer> operationList) {
        FeedMorePanelBusiImpl.OperationListProvider.e eVar = (FeedMorePanelBusiImpl.OperationListProvider.e) panelContext.getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class);
        boolean z16 = false;
        if (eVar != null && eVar.a("")) {
            z16 = true;
        }
        if (z16) {
            operationList.add(243);
        } else {
            operationList.add(242);
        }
    }

    private final void d(vk1.b feedData, PanelContext<Activity, vk1.b> panelContext, List<Integer> operationList) {
        if (feedData.K()) {
            FeedMorePanelBusiImpl.OperationListProvider.e eVar = (FeedMorePanelBusiImpl.OperationListProvider.e) panelContext.getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class);
            boolean z16 = false;
            if (eVar != null && eVar.a(String.valueOf(feedData.getChannelId()))) {
                z16 = true;
            }
            if (z16) {
                operationList.add(245);
            } else {
                operationList.add(244);
            }
        }
    }

    @NotNull
    public final List<ShareActionSheetBuilder.ActionSheetItem> b(@NotNull PanelContext<Activity, vk1.b> panelContext) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        ArrayList arrayList = new ArrayList();
        vk1.b j3 = panelContext.j();
        boolean a16 = a(j3.getGuildId(), j3.getChannelId());
        String r16 = j3.r();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Object obj = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        } else {
            str = null;
        }
        boolean areEqual = Intrinsics.areEqual(r16, str);
        if (areEqual && panelContext.getExtra().getBoolean("preserve_edit_action")) {
            arrayList.add(94);
        }
        if (ch.m0(String.valueOf(j3.getGuildId()))) {
            c(panelContext, arrayList);
            d(j3, panelContext, arrayList);
        }
        if (a16) {
            arrayList.add(225);
        }
        if (j3.n() != null && panelContext.getExtra().getBoolean("EXTRA_KEY_PRESERVE_SAVE_ACTION")) {
            arrayList.add(39);
        }
        arrayList.add(153);
        boolean z16 = true;
        arrayList.add(1);
        boolean z17 = panelContext.getExtra().getBoolean("EXTRA_KEY_HIDE_FLOATING_WINDOW");
        Object n3 = j3.n();
        if (n3 instanceof GuildFeedRichMediaData) {
            obj = n3;
        }
        GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) obj;
        if (guildFeedRichMediaData == null || guildFeedRichMediaData.getType() != 1) {
            z16 = false;
        }
        if (z16 && !z17) {
            arrayList.add(216);
        }
        if (a16 || areEqual) {
            arrayList.add(40);
        }
        if (!areEqual) {
            arrayList.add(11);
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number) it.next()).intValue()));
        }
        return arrayList2;
    }
}
