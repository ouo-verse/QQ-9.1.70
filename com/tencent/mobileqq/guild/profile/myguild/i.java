package com.tencent.mobileqq.guild.profile.myguild;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.ck;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/i;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", NotifyMsgApiImpl.KEY_GROUP_TYPE, "", "Q1", "", "sourceForLog", "", "R1", "refresh", "onResume", "T1", "type", "U1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/guild/profile/myguild/a;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_pageDataLiveData", "", "Lcom/tencent/mobileqq/guild/profile/myguild/j;", "D", "Ljava/util/List;", "groupList", "", "E", "Ljava/util/Map;", "groupToIsCollapse", UserInfo.SEX_FEMALE, "Z", "isLoading", "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "pageDataLiveData", "<init>", "()V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<a>> _pageDataLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<j> groupList = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Map<GroupType, Boolean> groupToIsCollapse = new LinkedHashMap();

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLoading;

    private final boolean Q1(GroupType groupType) {
        Boolean bool = this.groupToIsCollapse.get(groupType);
        if (bool != null) {
            return bool.booleanValue();
        }
        return groupType.getIsDefaultCollapse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(i this$0, ArrayList createdGuilds, ArrayList managedGuilds, ArrayList joinedGuilds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isLoading = false;
        this$0.groupList.clear();
        List<j> list = this$0.groupList;
        GroupType groupType = GroupType.CreatedGroup;
        Intrinsics.checkNotNullExpressionValue(createdGuilds, "createdGuilds");
        list.add(new j(groupType, createdGuilds));
        List<j> list2 = this$0.groupList;
        GroupType groupType2 = GroupType.ManagedGroup;
        Intrinsics.checkNotNullExpressionValue(managedGuilds, "managedGuilds");
        list2.add(new j(groupType2, managedGuilds));
        List<j> list3 = this$0.groupList;
        GroupType groupType3 = GroupType.JoinedGroup;
        Intrinsics.checkNotNullExpressionValue(joinedGuilds, "joinedGuilds");
        list3.add(new j(groupType3, joinedGuilds));
        this$0.T1();
    }

    @NotNull
    public final LiveData<List<a>> P1() {
        return this._pageDataLiveData;
    }

    public final void R1(@NotNull String sourceForLog) {
        String str;
        Intrinsics.checkNotNullParameter(sourceForLog, "sourceForLog");
        Logger.a d16 = Logger.f235387a.d();
        if (!this.isLoading) {
            str = "";
        } else {
            str = "isLoading";
        }
        d16.i("GuildMyGuildViewModel", 1, "loadGuilds(" + sourceForLog + ") " + str);
        if (this.isLoading) {
            return;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getGuildsInContact(new ck() { // from class: com.tencent.mobileqq.guild.profile.myguild.h
            @Override // wh2.ck
            public final void onGetGuildsInContact(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
                i.S1(i.this, arrayList, arrayList2, arrayList3);
            }
        });
    }

    public final void T1() {
        ArrayList arrayList = new ArrayList();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        List<String> topGuildList = ((IGPSService) S0).getTopGuildList();
        if (topGuildList == null) {
            topGuildList = CollectionsKt__CollectionsKt.emptyList();
        }
        Logger.f235387a.d().i("GuildMyGuildViewModel", 1, "topGuildIds: " + topGuildList);
        for (j jVar : this.groupList) {
            arrayList.addAll(jVar.b(Q1(jVar.getGroupType()), topGuildList));
        }
        this._pageDataLiveData.setValue(arrayList);
    }

    public final void U1(@NotNull GroupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.groupToIsCollapse.put(type, Boolean.valueOf(!Q1(type)));
        T1();
    }

    public final void onResume() {
        R1("onResume");
    }

    public final void refresh() {
        R1("refresh");
    }
}
