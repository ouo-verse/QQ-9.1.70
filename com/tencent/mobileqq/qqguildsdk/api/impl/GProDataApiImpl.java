package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetMyTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetRecommendTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProNavigationTab;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetMyTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetContentRecommendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetMyTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationTab;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSysPromptDigest;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTabContentCommonRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` *\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProDataApiImpl;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProDataApi;", "", "itemType", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContentRecommendFeed;", "feed", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "newGProRecommendContentItem", "", "byteArray", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GGProGetRecommendTabContentRsp;", "decodeGProGetRecommendTabContentRsp", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetMyTabContentRsp;", "decodeGProGetMyTabContentRsp", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guilds", "encodeGProGuilds", "decodeGProGuilds", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "list", "encodeGProNavigationTabs", "decodeGProNavigationTabs", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSysPromptDigest;", "decodeGProSysPromptDigest", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GGProGetContentRecommendRsp;", "fastDecodeMVPFeedsRspPb", "Lcom/tencent/mobileqq/qqguildsdk/data/p;", "attaData", "encodeShareAttaData", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRecommendContentItem;", "Lkotlin/collections/ArrayList;", "trimForSnapshot", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GProDataApiImpl implements IGProDataApi {
    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public IGProGetMyTabContentRsp decodeGProGetMyTabContentRsp(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        GProGetMyTabContentRsp O9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.O9(byteArray);
        GProTabContentCommonRsp gProTabContentCommonRsp = O9.commonRsp;
        ArrayList<GProRecommendContentItem> arrayList = gProTabContentCommonRsp.recommendList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "commonRsp.recommendList");
        gProTabContentCommonRsp.recommendList = trimForSnapshot(arrayList);
        return new GGProGetMyTabContentRsp(O9);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public List<IGProGuildInfo> decodeGProGuilds(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        ArrayList<GProGuild> R9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.R9(byteArray);
        Intrinsics.checkNotNullExpressionValue(R9, "decodeGProGuilds(byteArray)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = R9.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildInfo((GProGuild) it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public List<IGProNavigationTab> decodeGProNavigationTabs(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        ArrayList<GProNavigationTab> S9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.S9(byteArray);
        Intrinsics.checkNotNullExpressionValue(S9, "decodeGProNavigationTabs(byteArray)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = S9.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProNavigationTab((GProNavigationTab) it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public GProSysPromptDigest decodeGProSysPromptDigest(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        GProSysPromptDigest T9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.T9(byteArray);
        Intrinsics.checkNotNullExpressionValue(T9, "decodeGProSysPromptDigest(byteArray)");
        return T9;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public byte[] encodeGProGuilds(@NotNull List<? extends IGProGuildInfo> guilds) {
        Intrinsics.checkNotNullParameter(guilds, "guilds");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : guilds) {
            if (obj instanceof GProGuildInfo) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            GProGuild guild2 = ((GProGuildInfo) it.next()).getGuild();
            if (guild2 != null) {
                arrayList3.add(guild2);
            }
        }
        arrayList.addAll(arrayList3);
        byte[] U9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.U9(arrayList);
        Intrinsics.checkNotNullExpressionValue(U9, "encodeGProGuilds(arrayLi\u2026 { it.guild })\n        })");
        return U9;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public byte[] encodeGProNavigationTabs(@NotNull List<? extends IGProNavigationTab> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof GGProNavigationTab) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            GProNavigationTab gProNavigationTab = ((GGProNavigationTab) it.next()).mInfo;
            if (gProNavigationTab != null) {
                arrayList3.add(gProNavigationTab);
            }
        }
        arrayList.addAll(arrayList3);
        byte[] V9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.V9(arrayList);
        Intrinsics.checkNotNullExpressionValue(V9, "encodeGProNavigationTabs\u2026 { it.mInfo })\n        })");
        return V9;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public byte[] encodeShareAttaData(@NotNull com.tencent.mobileqq.qqguildsdk.data.p attaData) {
        Intrinsics.checkNotNullParameter(attaData, "attaData");
        byte[] W9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.W9(attaData.a());
        Intrinsics.checkNotNullExpressionValue(W9, "encodeShareAttaData(attaData.shareAttaData)");
        return W9;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public IGProRecommendContentItem newGProRecommendContentItem(int itemType, @NotNull GProContentRecommendFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        GProRecommendContentItem gProRecommendContentItem = new GProRecommendContentItem();
        gProRecommendContentItem.itemType = itemType;
        gProRecommendContentItem.feed = feed;
        return new GGProRecommendContentItem(gProRecommendContentItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ArrayList<GProRecommendContentItem> trimForSnapshot(@NotNull ArrayList<GProRecommendContentItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        ArrayList<GProRecommendContentItem> arrayList2 = new ArrayList<>();
        for (Object obj : arrayList) {
            int i3 = ((GProRecommendContentItem) obj).itemType;
            boolean z16 = true;
            if (i3 != 1 && i3 != 11 && i3 != 18) {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public GGProGetRecommendTabContentRsp decodeGProGetRecommendTabContentRsp(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        GProGetRecommendTabContentRsp P9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.P9(byteArray);
        GProTabContentCommonRsp gProTabContentCommonRsp = P9.commonRsp;
        ArrayList<GProRecommendContentItem> arrayList = gProTabContentCommonRsp.recommendList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "commonRsp.recommendList");
        gProTabContentCommonRsp.recommendList = trimForSnapshot(arrayList);
        return new GGProGetRecommendTabContentRsp(P9);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProDataApi
    @NotNull
    public GGProGetContentRecommendRsp fastDecodeMVPFeedsRspPb(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        GProGetContentRecommendRsp X9 = com.tencent.qqnt.kernelgpro.nativeinterface.k.X9(byteArray);
        ArrayList<GProRecommendContentItem> recommendList = X9.recommendList;
        Intrinsics.checkNotNullExpressionValue(recommendList, "recommendList");
        X9.recommendList = trimForSnapshot(recommendList);
        return new GGProGetContentRecommendRsp(X9);
    }
}
