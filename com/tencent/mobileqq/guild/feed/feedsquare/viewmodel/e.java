package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.br;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0018\u0010\u001d\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020 R\u0018\u0010$\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R(\u00100\u001a\u0004\u0018\u00010\u00162\b\u0010+\u001a\u0004\u0018\u00010\u00168\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/e;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "sectionList", "", "Q1", "R1", "newSectionList", "", "S1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bd;", "P1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "Lkotlin/collections/ArrayList;", "infoList", "T1", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "channelList", "Z1", "", "getLogTag", "", "N1", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "bean", "newSectionInFirst", "X1", "U1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroidx/lifecycle/MutableLiveData;", "O1", "i", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "initBean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "sectionListData", BdhLogUtil.LogTag.Tag_Conn, "J", "categoryId", "<set-?>", "D", "Ljava/lang/String;", "getHiddenChannelId", "()Ljava/lang/String;", "hiddenChannelId", "E", "Z", "getNewSectionInFirst", "()Z", "setNewSectionInFirst", "(Z)V", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private long categoryId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String hiddenChannelId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean newSectionInFirst;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedMainInitBean initBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.guild.feed.feedsquare.data.l>> sectionListData = new MutableLiveData<>();

    private final bd P1() {
        String str = null;
        if (this.initBean == null) {
            return null;
        }
        bd bdVar = new bd();
        GuildFeedMainInitBean guildFeedMainInitBean = this.initBean;
        if (guildFeedMainInitBean != null) {
            str = guildFeedMainInitBean.getGuildId();
        }
        Intrinsics.checkNotNull(str);
        bdVar.k(Long.parseLong(str));
        bdVar.h(false);
        bdVar.i(true);
        bdVar.j(false);
        return bdVar;
    }

    private final void Q1(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> sectionList) {
        this.sectionListData.postValue(sectionList);
    }

    private final void R1(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> sectionList) {
        if (S1(sectionList)) {
            this.sectionListData.postValue(sectionList);
        }
    }

    private final boolean S1(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> newSectionList) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z16;
        boolean z17;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> value = this.sectionListData.getValue();
        ArrayList arrayList2 = null;
        if (value != null) {
            List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list = value;
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault4);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((com.tencent.mobileqq.guild.feed.feedsquare.data.l) it.next()).getSectionInfo().getChannelId());
            }
        } else {
            arrayList = null;
        }
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list2 = newSectionList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(((com.tencent.mobileqq.guild.feed.feedsquare.data.l) it5.next()).getSectionInfo().getChannelId());
        }
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> value2 = this.sectionListData.getValue();
        if (value2 != null) {
            List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list3 = value2;
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            arrayList2 = new ArrayList(collectionSizeOrDefault3);
            Iterator<T> it6 = list3.iterator();
            while (it6.hasNext()) {
                arrayList2.add(((com.tencent.mobileqq.guild.feed.feedsquare.data.l) it6.next()).getSectionInfo().getName());
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it7 = list2.iterator();
        while (it7.hasNext()) {
            arrayList4.add(((com.tencent.mobileqq.guild.feed.feedsquare.data.l) it7.next()).getSectionInfo().getName());
        }
        if (arrayList != null) {
            z16 = arrayList.equals(arrayList3);
        } else {
            z16 = false;
        }
        boolean z18 = !z16;
        if (arrayList2 != null) {
            z17 = arrayList2.equals(arrayList4);
        } else {
            z17 = false;
        }
        boolean z19 = !z17;
        QLog.i("GuildFeedSectionListViewModel", 1, "needUpdate channelIdChange=" + z18 + " channelNameChange=" + z19);
        if (!z18 && !z19) {
            return false;
        }
        return true;
    }

    private final List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> T1(ArrayList<IGProCategoryChannelInfoList> infoList) {
        ArrayList arrayList = new ArrayList();
        Iterator<IGProCategoryChannelInfoList> it = infoList.iterator();
        while (it.hasNext()) {
            IGProCategoryChannelInfoList next = it.next();
            if (next.getCategoryType() == 1) {
                this.categoryId = next.getCategoryId();
            }
            ArrayList<IGProChannel> channelInfoList = next.getChannelInfoList();
            Intrinsics.checkNotNullExpressionValue(channelInfoList, "entry.channelInfoList");
            arrayList.addAll(channelInfoList);
        }
        return Z1(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(e this$0, ArrayList infoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(infoList, "infoList");
        this$0.Q1(this$0.T1(infoList));
    }

    private final List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> Z1(List<IGProChannel> channelList) {
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list;
        ArrayList arrayList = new ArrayList();
        for (IGProChannel iGProChannel : channelList) {
            if (iGProChannel.getChannelType() == 7) {
                if (iGProChannel.getHiddenPostChannel() == 1) {
                    this.hiddenChannelId = String.valueOf(iGProChannel.getChannelId());
                    com.tencent.mobileqq.guild.feed.feedsquare.utils.j jVar = com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a;
                    arrayList.add(0, jVar.j(iGProChannel, 5));
                    QLog.i("GuildFeedSectionListViewModel", 2, "transToSectionList newSectionInFirst=" + this.newSectionInFirst);
                    if (this.newSectionInFirst) {
                        arrayList.add(0, jVar.j(iGProChannel, 4));
                    } else {
                        arrayList.add(jVar.j(iGProChannel, 4));
                    }
                } else {
                    arrayList.add(com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a.j(iGProChannel, 1));
                }
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(e this$0, ArrayList infoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(infoList, "infoList");
        this$0.R1(this$0.T1(infoList));
    }

    /* renamed from: N1, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.guild.feed.feedsquare.data.l>> O1() {
        return this.sectionListData;
    }

    public final void U1() {
        bd P1 = P1();
        if (P1 == null) {
            return;
        }
        ((IGPSService) ch.R0(IGPSService.class)).getCategoryChannelInfoListV2(P1, new br() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.c
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                e.W1(e.this, arrayList);
            }
        });
    }

    public final void X1(@Nullable GuildFeedMainInitBean bean, boolean newSectionInFirst) {
        this.initBean = bean;
        this.newSectionInFirst = newSectionInFirst;
    }

    public final void a2() {
        bd P1 = P1();
        if (P1 == null) {
            return;
        }
        ((IGPSService) ch.R0(IGPSService.class)).getCategoryChannelInfoListV2(P1, new br() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.d
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                e.b2(e.this, arrayList);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedSectionListViewModel";
    }
}
