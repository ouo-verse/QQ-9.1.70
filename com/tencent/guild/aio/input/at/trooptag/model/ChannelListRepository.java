package com.tencent.guild.aio.input.at.trooptag.model;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextChannelInfo;
import cp0.HashTagChannelData;
import cp0.HashTagGroupData;
import cp0.HashTagGroupType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uo0.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b%\u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J&\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019R\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001d\u0012\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/model/ChannelListRepository;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "categoryInfo", "", "f", "", "categoryInfoList", "Lze1/c;", "search", "", "channelType", "Ljava/util/ArrayList;", "Lcp0/a;", "Lkotlin/collections/ArrayList;", "c", "Lcom/tencent/common/app/AppInterface;", "qqAppInterface", "guildId", "", "e", "", "isGroup", "Lcom/tencent/mobileqq/guild/util/HashTagViewType;", "g", "Lcom/tencent/guild/aio/input/at/trooptag/model/b;", "fetchCallback", "d", "a", "I", "mFilterChannelType", "b", "getMPermissionType$annotations", "()V", "mPermissionType", "Ljava/lang/String;", "mFilterChannelId", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ChannelListRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mFilterChannelType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mPermissionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mFilterChannelId = "";

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<cp0.a> c(List<? extends IGProCategoryChannelInfoList> categoryInfoList, ze1.c search, int channelType) {
        int i3;
        uo0.d dVar;
        IGProChannel iGProChannel;
        long j3;
        String str;
        int i16;
        int i17;
        IGProTextChannelInfo textChannelInfo;
        ArrayList<cp0.a> arrayList = new ArrayList<>();
        for (IGProCategoryChannelInfoList iGProCategoryChannelInfoList : categoryInfoList) {
            ArrayList arrayList2 = new ArrayList();
            HashTagGroupType hashTagGroupType = new HashTagGroupType(f(iGProCategoryChannelInfoList));
            if (iGProCategoryChannelInfoList.getCategoryType() != 0 || !TextUtils.isEmpty(iGProCategoryChannelInfoList.getCategoryName())) {
                if (iGProCategoryChannelInfoList.getCategoryType() == 1) {
                    if (search instanceof uo0.d) {
                        dVar = (uo0.d) search;
                    } else {
                        dVar = null;
                    }
                    if (dVar != null) {
                        iGProChannel = dVar.q();
                    } else {
                        iGProChannel = null;
                    }
                    long j16 = 0;
                    if (iGProChannel != null) {
                        j3 = iGProChannel.getGuildId();
                    } else {
                        j3 = 0;
                    }
                    if (iGProChannel != null) {
                        j16 = iGProChannel.getChannelId();
                    }
                    long j17 = j16;
                    if (channelType == 1000050) {
                        str = "\u4e3b\u9875";
                    } else {
                        str = "\u70ed\u95e8";
                    }
                    String str2 = str;
                    if (iGProChannel != null) {
                        i16 = iGProChannel.getChannelType();
                    } else {
                        i16 = 0;
                    }
                    if (iGProChannel != null && (textChannelInfo = iGProChannel.getTextChannelInfo()) != null) {
                        i17 = textChannelInfo.getSubTypeId();
                    } else {
                        i17 = 0;
                    }
                    arrayList2.add(new HashTagChannelData(hashTagGroupType, j3, j17, str2, i16, i17, g(iGProCategoryChannelInfoList, true), false, 128, null));
                }
                Iterator<IGProChannel> it = iGProCategoryChannelInfoList.getChannelInfoList().iterator();
                while (it.hasNext()) {
                    IGProChannel next = it.next();
                    long guildId = next.getGuildId();
                    long channelId = next.getChannelId();
                    String channelName = next.getChannelName();
                    Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
                    int channelType2 = next.getChannelType();
                    IGProTextChannelInfo textChannelInfo2 = next.getTextChannelInfo();
                    if (textChannelInfo2 != null) {
                        i3 = textChannelInfo2.getSubTypeId();
                    } else {
                        i3 = 0;
                    }
                    arrayList2.add(new HashTagChannelData(hashTagGroupType, guildId, channelId, channelName, channelType2, i3, h(this, iGProCategoryChannelInfoList, false, 2, null), false, 128, null));
                }
                if (!arrayList2.isEmpty()) {
                    arrayList.add(new HashTagGroupData(hashTagGroupType, hashTagGroupType.getGroupName(), arrayList2, false, null, 24, null));
                    arrayList.addAll(arrayList2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(AppInterface qqAppInterface, String guildId, List<? extends IGProCategoryChannelInfoList> categoryInfoList) {
        boolean z16;
        if (categoryInfoList.isEmpty() || this.mFilterChannelType == 0) {
            return;
        }
        dx guildPermission = ((IGPSService) qqAppInterface.getRuntimeService(IGPSService.class, "")).getGuildPermission(guildId);
        Intrinsics.checkNotNullExpressionValue(guildPermission, "qqAppInterface.getRuntim\u2026tGuildPermission(guildId)");
        int i3 = this.mPermissionType;
        if (i3 != 0 && !guildPermission.a(i3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        Iterator<? extends IGProCategoryChannelInfoList> it = categoryInfoList.iterator();
        while (it.hasNext()) {
            ArrayList<IGProChannel> channelInfoList = it.next().getChannelInfoList();
            Intrinsics.checkNotNullExpressionValue(channelInfoList, "categoryInfo.channelInfoList");
            if (!channelInfoList.isEmpty()) {
                Iterator<IGProChannel> it5 = channelInfoList.iterator();
                Intrinsics.checkNotNullExpressionValue(it5, "channelInfoList.iterator()");
                while (it5.hasNext()) {
                    IGProChannel next = it5.next();
                    Intrinsics.checkNotNullExpressionValue(next, "channelIterator.next()");
                    IGProChannel iGProChannel = next;
                    if (!TextUtils.isEmpty(this.mFilterChannelId) && TextUtils.equals(String.valueOf(iGProChannel.getChannelId()), this.mFilterChannelId)) {
                        it5.remove();
                    } else if (this.mFilterChannelType != 0 && iGProChannel.getChannelType() != this.mFilterChannelType) {
                        it5.remove();
                    } else if (!z16 && iGProChannel.getIsChannelAdmin() != 1 && iGProChannel.getIsCategoryAdmin() != 1) {
                        it5.remove();
                    }
                }
            }
        }
    }

    private final String f(IGProCategoryChannelInfoList categoryInfo) {
        if (categoryInfo.getCategoryType() == 1) {
            return "\u7248\u5757";
        }
        String categoryName = categoryInfo.getCategoryName();
        Intrinsics.checkNotNullExpressionValue(categoryName, "{\n           categoryInfo.name\n       }");
        return categoryName;
    }

    private final HashTagViewType g(IGProCategoryChannelInfoList categoryInfo, boolean isGroup) {
        if (categoryInfo.getCategoryType() == 1) {
            if (isGroup) {
                return HashTagViewType.VIEW_TYPE_FEED_SQUARE;
            }
            return HashTagViewType.VIEW_TYPE_FEED_SECTION;
        }
        if (categoryInfo.getCategoryType() == 0) {
            if (isGroup) {
                return HashTagViewType.VIEW_TYPE_GROUP_NAME;
            }
            return HashTagViewType.VIEW_TYPE_CHANNEL_ITEM;
        }
        return HashTagViewType.VIEW_TYPE_INVALID;
    }

    static /* synthetic */ HashTagViewType h(ChannelListRepository channelListRepository, IGProCategoryChannelInfoList iGProCategoryChannelInfoList, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return channelListRepository.g(iGProCategoryChannelInfoList, z16);
    }

    public final void d(@NotNull final AppInterface qqAppInterface, @NotNull final String guildId, final int channelType, @NotNull final b fetchCallback) {
        Intrinsics.checkNotNullParameter(qqAppInterface, "qqAppInterface");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(fetchCallback, "fetchCallback");
        new uo0.b(new p.b() { // from class: com.tencent.guild.aio.input.at.trooptag.model.ChannelListRepository$fetchChannelList$searchSession$1
            @Override // ze1.d
            public void d(@Nullable ze1.c search, @Nullable String keyword, @Nullable String errorMsg, int errorCode) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "[onSearchError] errorMsg " + errorMsg + " errorCode " + errorCode;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GFT_ChannelListRepository", 1, (String) it.next(), null);
                }
                final b bVar2 = fetchCallback;
                PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.guild.aio.input.at.trooptag.model.ChannelListRepository$fetchChannelList$searchSession$1$onSearchError$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        b.this.a(new ArrayList<>());
                    }
                });
            }

            @Override // ze1.d
            public void e(@Nullable final ze1.c search, @Nullable String keyword, @Nullable List<? extends Object> list, @Nullable Object ext) {
                Logger.f235387a.d().d("GFT_ChannelListRepository", 1, "[onSearchResult] ");
                if (list == null) {
                    list = null;
                }
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                final List<? extends Object> list2 = list;
                ChannelListRepository.this.e(qqAppInterface, guildId, list2);
                final b bVar = fetchCallback;
                final ChannelListRepository channelListRepository = ChannelListRepository.this;
                final int i3 = channelType;
                PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.guild.aio.input.at.trooptag.model.ChannelListRepository$fetchChannelList$searchSession$1$onSearchResult$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        ArrayList<cp0.a> c16;
                        b bVar2 = b.this;
                        c16 = channelListRepository.c(list2, search, i3);
                        bVar2.a(c16);
                    }
                });
            }
        }).u(guildId, "", true);
    }
}
