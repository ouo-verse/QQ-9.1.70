package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryAdminDisplayInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchCategoryAdminDisplayInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.af;
import wx1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/c;", "Lef1/b;", "", "P1", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGId", "()Ljava/lang/String;", "gId", "Landroidx/lifecycle/MutableLiveData;", "", "Lwx1/a$a;", "D", "Landroidx/lifecycle/MutableLiveData;", "_channelGroupList", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "channelGroupList", "<init>", "(Ljava/lang/String;)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String gId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<a.ChannelGroupUIData>> _channelGroupList;

    public c(@NotNull String gId) {
        Intrinsics.checkNotNullParameter(gId, "gId");
        this.gId = gId;
        this._channelGroupList = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(c this$0, int i3, String str, IGProFetchCategoryAdminDisplayInfoRsp iGProFetchCategoryAdminDisplayInfoRsp) {
        int collectionSizeOrDefault;
        Object lastOrNull;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && iGProFetchCategoryAdminDisplayInfoRsp != null) {
            int categoryAdminMaxNum = iGProFetchCategoryAdminDisplayInfoRsp.getCategoryAdminMaxNum();
            MutableLiveData<List<a.ChannelGroupUIData>> mutableLiveData = this$0._channelGroupList;
            ArrayList<IGProCategoryAdminDisplayInfo> categoryAdminDisplayList = iGProFetchCategoryAdminDisplayInfoRsp.getCategoryAdminDisplayList();
            Intrinsics.checkNotNullExpressionValue(categoryAdminDisplayList, "resp.categoryAdminDisplayList");
            ArrayList<IGProCategoryAdminDisplayInfo> arrayList = new ArrayList();
            for (Object obj : categoryAdminDisplayList) {
                IGProCategoryAdminDisplayInfo iGProCategoryAdminDisplayInfo = (IGProCategoryAdminDisplayInfo) obj;
                String categoryName = iGProCategoryAdminDisplayInfo.getCategoryName();
                Intrinsics.checkNotNullExpressionValue(categoryName, "it.categoryName");
                if (categoryName.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && iGProCategoryAdminDisplayInfo.getCategoryType() != 7) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            List<a.ChannelGroupUIData> arrayList2 = new ArrayList<>(collectionSizeOrDefault);
            for (IGProCategoryAdminDisplayInfo iGProCategoryAdminDisplayInfo2 : arrayList) {
                long categoryId = iGProCategoryAdminDisplayInfo2.getCategoryId();
                String categoryName2 = iGProCategoryAdminDisplayInfo2.getCategoryName();
                Intrinsics.checkNotNullExpressionValue(categoryName2, "it.categoryName");
                arrayList2.add(new a.ChannelGroupUIData(categoryId, categoryName2, (int) iGProCategoryAdminDisplayInfo2.getCategoryAdminNum(), categoryAdminMaxNum, false, false, 48, null));
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = CollectionsKt__CollectionsJVMKt.listOf(new a.ChannelGroupUIData(0L, "\u5f53\u524d\u9891\u9053\u6682\u65e0\u5206\u7ec4", 0, 0, true, false, 45, null));
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList2);
            a.ChannelGroupUIData channelGroupUIData = (a.ChannelGroupUIData) lastOrNull;
            if (channelGroupUIData != null) {
                channelGroupUIData.g(false);
            }
            mutableLiveData.setValue(arrayList2);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "fetchCategoryAdminInfoList code=" + i3 + " msg=" + str + " resp=" + iGProFetchCategoryAdminDisplayInfoRsp;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.rg.GuildCategoryAdminRoleViewModel", 1, (String) it.next(), null);
        }
    }

    @NotNull
    public final LiveData<List<a.ChannelGroupUIData>> O1() {
        return this._channelGroupList;
    }

    public final void P1() {
        Long longOrNull;
        long j3;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        as asVar = new as();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.gId);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        asVar.b(j3);
        iGPSService.fetchCategoryAdminInfoList(asVar, new af() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.b
            @Override // wh2.af
            public final void a(int i3, String str, IGProFetchCategoryAdminDisplayInfoRsp iGProFetchCategoryAdminDisplayInfoRsp) {
                c.Q1(c.this, i3, str, iGProFetchCategoryAdminDisplayInfoRsp);
            }
        });
    }
}
