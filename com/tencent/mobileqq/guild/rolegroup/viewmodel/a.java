package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 &2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002J*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0013J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0013J\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/a;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "result", "", "U1", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cy;", "allCategoryList", "", "channelIds", "", "R1", "categoryList", "Lcom/tencent/mobileqq/guild/channel/manage/b;", "O1", "Lcom/tencent/mobileqq/guild/base/repository/h;", "P1", "initData", "Landroidx/lifecycle/MutableLiveData;", "S1", "T1", "Q1", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGuildId", "D", "mRoleId", "E", "Landroidx/lifecycle/MutableLiveData;", "mSpeakChannelsLiveData", UserInfo.SEX_FEMALE, "mVisibleChannelsLiveData", "G", "Lcom/tencent/mobileqq/guild/base/repository/h;", "fetchRoleGroupCallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String mRoleId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<com.tencent.mobileqq.guild.channel.manage.b>> mSpeakChannelsLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<com.tencent.mobileqq.guild.channel.manage.b>> mVisibleChannelsLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> fetchRoleGroupCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/a$b", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable RoleGroupModel result) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (error.d() && result != null) {
                a.this.U1(result);
                return;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.rg.ChannelPermissionForRoleViewModel", 2, "fetchRoleGroup error:" + error);
            }
        }
    }

    public a(@NotNull String mGuildId, @NotNull String mRoleId) {
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        Intrinsics.checkNotNullParameter(mRoleId, "mRoleId");
        this.mGuildId = mGuildId;
        this.mRoleId = mRoleId;
        this.mSpeakChannelsLiveData = new MutableLiveData<>(new ArrayList());
        this.mVisibleChannelsLiveData = new MutableLiveData<>(new ArrayList());
        this.fetchRoleGroupCallback = P1();
    }

    private final List<com.tencent.mobileqq.guild.channel.manage.b> O1(List<? extends cy> categoryList, List<String> channelIds) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (cy cyVar : categoryList) {
            String categoryName = cyVar.getCategoryName();
            Intrinsics.checkNotNullExpressionValue(categoryName, "categoryInfo.categoryName");
            if (categoryName.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.guild.channel.manage.b bVar = new com.tencent.mobileqq.guild.channel.manage.b();
                bVar.f215081a = 1;
                bVar.f215082b = cyVar.getCategoryName();
                arrayList.add(bVar);
            }
            for (IGProChannelInfo iGProChannelInfo : cyVar.getChannelList()) {
                if (channelIds.contains(iGProChannelInfo.getChannelUin())) {
                    com.tencent.mobileqq.guild.channel.manage.b bVar2 = new com.tencent.mobileqq.guild.channel.manage.b();
                    bVar2.f215081a = 0;
                    bVar2.f215083c = iGProChannelInfo;
                    arrayList.add(bVar2);
                }
            }
        }
        return arrayList;
    }

    private final com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> P1() {
        return new b();
    }

    private final List<cy> R1(List<? extends cy> allCategoryList, List<String> channelIds) {
        ArrayList arrayList = new ArrayList();
        for (cy cyVar : allCategoryList) {
            Iterator<IGProChannelInfo> it = cyVar.getChannelList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (channelIds.contains(it.next().getChannelUin())) {
                    arrayList.add(cyVar);
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(RoleGroupModel result) {
        List<cy> channelCategoryList = ((IGPSService) MiscKt.c(IGPSService.class, "Guild.rg.ChannelPermissionForRoleViewModel", "")).getChannelCategoryList(this.mGuildId);
        Intrinsics.checkNotNullExpressionValue(channelCategoryList, "gpsService.getChannelCategoryList(mGuildId)");
        List<cy> R1 = R1(channelCategoryList, result.getChannelPermission().a());
        List<cy> R12 = R1(channelCategoryList, result.getChannelPermission().b());
        List<com.tencent.mobileqq.guild.channel.manage.b> O1 = O1(R1, result.getChannelPermission().a());
        List<com.tencent.mobileqq.guild.channel.manage.b> O12 = O1(R12, result.getChannelPermission().b());
        this.mSpeakChannelsLiveData.setValue(O1);
        this.mVisibleChannelsLiveData.setValue(O12);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.ChannelPermissionForRoleViewModel", 2, "updateChannelsPermissionData approveSpeakChannelList:" + O1);
        }
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.ChannelPermissionForRoleViewModel", 2, "updateChannelsPermissionData approveVisibleChannelList:" + O12);
        }
    }

    public final void Q1() {
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.f232798e.g(new FetchRoleGroupParam(this.mGuildId, this.mRoleId, true, 117), this.fetchRoleGroupCallback);
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.guild.channel.manage.b>> S1() {
        return this.mSpeakChannelsLiveData;
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.guild.channel.manage.b>> T1() {
        return this.mVisibleChannelsLiveData;
    }

    public final void initData() {
        RoleGroupModel e16 = com.tencent.mobileqq.guild.rolegroup.model.repositories.r.f232798e.e(new FetchRoleGroupParam(this.mGuildId, this.mRoleId, true, 0, 8, null));
        if (e16 != null) {
            U1(e16);
        }
    }
}
