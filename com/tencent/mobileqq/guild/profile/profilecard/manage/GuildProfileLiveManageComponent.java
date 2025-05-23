package com.tencent.mobileqq.guild.profile.profilecard.manage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.repository.h;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.manage.GuildProfileLiveManageComponent;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.z;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bq;
import vh2.cc;
import vh2.f;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J,\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0)j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*`+2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0016J&\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\"H\u0016J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\"H\u0016J\b\u0010:\u001a\u00020\"H\u0016J\u0010\u0010;\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001bH\u0002J\b\u0010<\u001a\u00020\"H\u0002J\u0010\u0010=\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010>\u001a\u00020\"H\u0002J\b\u0010?\u001a\u00020\"H\u0002J\b\u0010@\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/manage/GuildProfileLiveManageComponent;", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/component/AbsGuildProfileComponent;", "Landroid/view/View$OnClickListener;", "componentController", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/controller/IGuildComponentController;", "data", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "(Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/controller/IGuildComponentController;Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;)V", "TAG", "", "appRuntime", "Lmqq/app/AppRuntime;", "dstUserIsChannelAdmin", "", "gPServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "isLoading", "isMute", "Landroidx/lifecycle/MutableLiveData;", "mIsFinishing", "muteIcon", "Landroid/widget/ImageView;", "muteTips", "Landroid/widget/TextView;", "operatorType", "", "userData", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildBaseProfileData;", "userDstType", "userTypeChange", "visibility", "checkCanShow", "", "detachFromComponentController", "fetchDstUseRoles", "getComponentName", "getComponentType", "getContentLayoutId", "getReportUserMasterType", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onCreate", "fragment", "Landroidx/fragment/app/Fragment;", "appInterface", "Lcom/tencent/common/app/AppInterface;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onInitData", "guildProfileData", "onLoadFinish", HippyQQPagView.EventName.ON_LOAD_START, "setContainerVisibleAwareLoading", "setDtElement", "setDtPage", "setMuteInLive", "setObservers", "updateMuteContainerVisible", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildProfileLiveManageComponent extends AbsGuildProfileComponent implements View.OnClickListener {

    @NotNull
    private final String TAG;
    private AppRuntime appRuntime;
    private boolean dstUserIsChannelAdmin;
    private GPServiceObserver gPServiceObserver;
    private IGPSService gpsService;
    private boolean isLoading;

    @NotNull
    private MutableLiveData<Boolean> isMute;
    private boolean mIsFinishing;
    private ImageView muteIcon;
    private TextView muteTips;
    private int operatorType;
    private GuildBaseProfileData userData;
    private int userDstType;

    @NotNull
    private MutableLiveData<Boolean> userTypeChange;
    private int visibility;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/profile/profilecard/manage/GuildProfileLiveManageComponent$a", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements h<List<? extends RoleGroupModel>> {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable List<RoleGroupModel> result) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (BaseApplication.getContext() != null && !GuildProfileLiveManageComponent.this.mIsFinishing && error.d() && result != null) {
                Iterator<RoleGroupModel> it = result.iterator();
                while (it.hasNext()) {
                    if (it.next().u()) {
                        GuildProfileLiveManageComponent.this.dstUserIsChannelAdmin = true;
                        GuildProfileLiveManageComponent.this.userTypeChange.postValue(Boolean.TRUE);
                        QLog.d(GuildProfileLiveManageComponent.this.TAG, 1, "[fetchDstUseRoles is channel admin] ");
                        return;
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/profile/profilecard/manage/GuildProfileLiveManageComponent$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "result", "", "errMsg", "guildId", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @NotNull String errMsg, @NotNull String guildId, @NotNull String tinyId, @NotNull ev info) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(info, "info");
            QLog.i(GuildProfileLiveManageComponent.this.TAG, 1, "onUserProfileInfoUpdate result: " + result);
            if (result == 0) {
                GuildBaseProfileData guildBaseProfileData = GuildProfileLiveManageComponent.this.userData;
                if (guildBaseProfileData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    guildBaseProfileData = null;
                }
                if (Intrinsics.areEqual(tinyId, guildBaseProfileData.b())) {
                    GuildProfileLiveManageComponent.this.userDstType = info.getUserType();
                    GuildProfileLiveManageComponent.this.userTypeChange.postValue(Boolean.TRUE);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileLiveManageComponent(@NotNull IGuildComponentController componentController, @NotNull GuildProfileData data) {
        super(componentController, data);
        Intrinsics.checkNotNullParameter(componentController, "componentController");
        Intrinsics.checkNotNullParameter(data, "data");
        this.TAG = "Guild.profile.GuildProfileLiveManageComponent";
        this.isMute = new MutableLiveData<>(Boolean.FALSE);
        this.userTypeChange = new MutableLiveData<>();
        this.visibility = 8;
    }

    private final void checkCanShow() {
        String str;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.t().e().getValue() != null) {
            IGProChannelInfo value = gLiveChannelCore.t().e().getValue();
            Intrinsics.checkNotNull(value);
            str = String.valueOf(value.getLiveAnchorTinyId());
            QLog.d(this.TAG, 1, "currentAnchorId " + str);
        } else {
            str = "";
        }
        if (gLiveChannelCore.s().isLiving()) {
            GuildBaseProfileData guildBaseProfileData = this.userData;
            GuildBaseProfileData guildBaseProfileData2 = null;
            if (guildBaseProfileData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                guildBaseProfileData = null;
            }
            if (!Intrinsics.areEqual(str, guildBaseProfileData.b())) {
                GuildBaseProfileData guildBaseProfileData3 = this.userData;
                if (guildBaseProfileData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    guildBaseProfileData3 = null;
                }
                String b16 = guildBaseProfileData3.b();
                GuildBaseProfileData guildBaseProfileData4 = this.userData;
                if (guildBaseProfileData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                    guildBaseProfileData4 = null;
                }
                if (!Intrinsics.areEqual(b16, guildBaseProfileData4.j())) {
                    boolean t06 = ch.t0(gLiveChannelCore.s().getGuildInfo());
                    QLog.i(this.TAG, 1, "checkCanShow self isGuildManager " + t06);
                    if (!t06) {
                        Boolean value2 = gLiveChannelCore.t().D().getValue();
                        Intrinsics.checkNotNull(value2);
                        if (!value2.booleanValue()) {
                            IRoleGroupListRepository p16 = r.p();
                            GuildBaseProfileData guildBaseProfileData5 = this.userData;
                            if (guildBaseProfileData5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("userData");
                                guildBaseProfileData5 = null;
                            }
                            String e16 = guildBaseProfileData5.e();
                            Intrinsics.checkNotNullExpressionValue(e16, "userData.guildId");
                            GuildBaseProfileData guildBaseProfileData6 = this.userData;
                            if (guildBaseProfileData6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("userData");
                            } else {
                                guildBaseProfileData2 = guildBaseProfileData6;
                            }
                            String a16 = guildBaseProfileData2.a();
                            Intrinsics.checkNotNullExpressionValue(a16, "userData.channelId");
                            if (p16.getChannelPermission(e16, a16).a(20013)) {
                                return;
                            }
                            setContainerVisibleAwareLoading(8);
                            return;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    GuildBaseProfileData guildBaseProfileData7 = this.userData;
                    if (guildBaseProfileData7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userData");
                        guildBaseProfileData7 = null;
                    }
                    arrayList.add(guildBaseProfileData7.b());
                    IGPSService iGPSService = this.gpsService;
                    if (iGPSService == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gpsService");
                        iGPSService = null;
                    }
                    GuildBaseProfileData guildBaseProfileData8 = this.userData;
                    if (guildBaseProfileData8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userData");
                    } else {
                        guildBaseProfileData2 = guildBaseProfileData8;
                    }
                    iGPSService.fetchUserInfo(guildBaseProfileData2.e(), arrayList, false, new bq() { // from class: bw1.b
                        @Override // vh2.bq
                        public final void a(int i3, String str2, List list, List list2) {
                            GuildProfileLiveManageComponent.checkCanShow$lambda$2(GuildProfileLiveManageComponent.this, i3, str2, list, list2);
                        }
                    });
                    this.userTypeChange.observe(this.mFragment.getViewLifecycleOwner(), new Observer() { // from class: bw1.c
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            GuildProfileLiveManageComponent.checkCanShow$lambda$3(GuildProfileLiveManageComponent.this, (Boolean) obj);
                        }
                    });
                    return;
                }
            }
        }
        setContainerVisibleAwareLoading(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkCanShow$lambda$2(GuildProfileLiveManageComponent this$0, int i3, String str, List list, List list2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.TAG, 1, "queryUserIsAdmin onGetUserInfo result:" + i3 + " errMsg:" + str);
        if (i3 == 0 && list != null && (!list.isEmpty())) {
            boolean f06 = ch.f0((IGProUserInfo) list.get(0));
            QLog.i(this$0.TAG, 1, "queryUserIsAdmin : " + f06);
            if (f06) {
                this$0.setContainerVisibleAwareLoading(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkCanShow$lambda$3(GuildProfileLiveManageComponent this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateMuteContainerVisible();
    }

    private final void fetchDstUseRoles() {
        GuildBaseProfileData guildBaseProfileData = this.userData;
        GuildBaseProfileData guildBaseProfileData2 = null;
        if (guildBaseProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            guildBaseProfileData = null;
        }
        if (TextUtils.isEmpty(guildBaseProfileData.a())) {
            QLog.d(this.TAG, 1, "[fetchDstUseRoles] channelId is null");
            return;
        }
        IRoleGroupListRepository p16 = r.p();
        GuildTarget.Companion companion = GuildTarget.INSTANCE;
        GuildBaseProfileData guildBaseProfileData3 = this.userData;
        if (guildBaseProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            guildBaseProfileData3 = null;
        }
        String e16 = guildBaseProfileData3.e();
        Intrinsics.checkNotNullExpressionValue(e16, "userData.guildId");
        GuildBaseProfileData guildBaseProfileData4 = this.userData;
        if (guildBaseProfileData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            guildBaseProfileData4 = null;
        }
        String a16 = guildBaseProfileData4.a();
        Intrinsics.checkNotNullExpressionValue(a16, "userData.channelId");
        GuildTarget a17 = companion.a(e16, a16);
        GuildBaseProfileData guildBaseProfileData5 = this.userData;
        if (guildBaseProfileData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
        } else {
            guildBaseProfileData2 = guildBaseProfileData5;
        }
        String b16 = guildBaseProfileData2.b();
        Intrinsics.checkNotNullExpressionValue(b16, "userData.dstTinyId");
        p16.n(a17, b16, new a());
    }

    private final HashMap<String, Object> getReportUserMasterType(GuildProfileData data) {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        HashMap<String, Object> pageParams = new z(gLiveChannelCore.s().getChannelInfo(), gLiveChannelCore.s().getGuildInfo()).b();
        Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
        pageParams.put("sgrp_profile_scene", 4);
        String j3 = data.getGuildBaseProfileData().j();
        String b16 = data.getGuildBaseProfileData().b();
        if (j3 != null && b16 != null) {
            Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
            pageParams.put("sgrp_profile_userid", b16);
            if (Intrinsics.areEqual(j3, b16)) {
                Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
                pageParams.put("sgrp_user_master", 1);
            } else {
                Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
                pageParams.put("sgrp_user_master", 0);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
            pageParams.put("sgrp_user_master", 0);
            Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
            pageParams.put("sgrp_profile_userid", 0);
        }
        pageParams.putAll(com.tencent.mobileqq.guild.report.b.d());
        Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
        return pageParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitData$lambda$0(GuildProfileLiveManageComponent this$0, int i3, String str, int i16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 2, "checkUserBannedSpeakInChannel:" + i3 + " err:" + str + " ban:" + i16);
        if (i3 == 0) {
            MutableLiveData<Boolean> mutableLiveData = this$0.isMute;
            if (i16 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            mutableLiveData.postValue(Boolean.valueOf(z16));
        }
    }

    private final void setContainerVisibleAwareLoading(int visibility) {
        this.visibility = visibility;
        if (!this.isLoading) {
            this.mViewContainer.setVisibility(visibility);
        }
    }

    private final void setDtElement() {
        int i3 = 1;
        HashMap hashMap = new HashMap(1);
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        if (channelInfo == null) {
            return;
        }
        if (channelInfo.getBannedSpeak() == 1) {
            i3 = 2;
        }
        hashMap.put("sgrp_voicechannel_profile_block_condition", Integer.valueOf(i3));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.mViewContainer.findViewById(R.id.f165952y64), "em_sgrp_profile_block", hashMap);
    }

    private final void setDtPage(GuildProfileData data) {
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        if (channelInfo == null) {
            return;
        }
        HashMap<String, Object> reportUserMasterType = getReportUserMasterType(data);
        VideoReport.setPageId(this.mViewContainer, "pg_sgrp_profile");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.mViewContainer, channelInfo, reportUserMasterType);
    }

    private final void setMuteInLive() {
        IGPSService iGPSService;
        long roomId = GLiveChannelCore.f226698a.s().getRoomId();
        IGPSService iGPSService2 = this.gpsService;
        GuildBaseProfileData guildBaseProfileData = null;
        if (iGPSService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gpsService");
            iGPSService = null;
        } else {
            iGPSService = iGPSService2;
        }
        GuildBaseProfileData guildBaseProfileData2 = this.userData;
        if (guildBaseProfileData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            guildBaseProfileData2 = null;
        }
        String e16 = guildBaseProfileData2.e();
        GuildBaseProfileData guildBaseProfileData3 = this.userData;
        if (guildBaseProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            guildBaseProfileData3 = null;
        }
        String a16 = guildBaseProfileData3.a();
        String valueOf = String.valueOf(roomId);
        GuildBaseProfileData guildBaseProfileData4 = this.userData;
        if (guildBaseProfileData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
        } else {
            guildBaseProfileData = guildBaseProfileData4;
        }
        iGPSService.setLiveChannelBannedUser(e16, a16, valueOf, guildBaseProfileData.b(), this.operatorType, new cc() { // from class: bw1.a
            @Override // vh2.cc
            public final void onResult(int i3, String str) {
                GuildProfileLiveManageComponent.setMuteInLive$lambda$4(GuildProfileLiveManageComponent.this, i3, str);
            }
        });
        setDtElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMuteInLive$lambda$4(GuildProfileLiveManageComponent this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 4, "setLiveChannelBannedUser: " + i3 + " errMsg: " + str + " opreator: " + this$0.operatorType);
        if (i3 == 0) {
            MutableLiveData<Boolean> mutableLiveData = this$0.isMute;
            boolean z16 = true;
            if (this$0.operatorType != 1) {
                z16 = false;
            }
            mutableLiveData.postValue(Boolean.valueOf(z16));
            return;
        }
        aa.a(R.string.f1521119i);
    }

    private final void setObservers() {
        this.isMute.observe(this.mFragment.getViewLifecycleOwner(), new Observer() { // from class: bw1.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileLiveManageComponent.setObservers$lambda$1(GuildProfileLiveManageComponent.this, (Boolean) obj);
            }
        });
        this.gPServiceObserver = new b();
        QLog.e(this.TAG, 1, "setObservers " + System.identityHashCode(ch.R0(IGPSService.class)));
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        GPServiceObserver gPServiceObserver = this.gPServiceObserver;
        if (gPServiceObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gPServiceObserver");
            gPServiceObserver = null;
        }
        iGPSService.addObserver(gPServiceObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setObservers$lambda$1(GuildProfileLiveManageComponent this$0, Boolean it) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        TextView textView = null;
        if (it.booleanValue()) {
            ImageView imageView = this$0.muteIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteIcon");
                imageView = null;
            }
            imageView.setImageDrawable(this$0.m193getContainerView().getContext().getResources().getDrawable(R.drawable.guild_profile_mute_on_icon));
            TextView textView2 = this$0.muteTips;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteTips");
            } else {
                textView = textView2;
            }
            textView.setText(R.string.f1521319k);
            i3 = 2;
        } else {
            ImageView imageView2 = this$0.muteIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteIcon");
                imageView2 = null;
            }
            imageView2.setImageDrawable(this$0.m193getContainerView().getContext().getResources().getDrawable(R.drawable.guild_profile_mute_off_icon));
            TextView textView3 = this$0.muteTips;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteTips");
            } else {
                textView = textView3;
            }
            textView.setText(R.string.f1521219j);
            i3 = 1;
        }
        this$0.operatorType = i3;
    }

    private final void updateMuteContainerVisible() {
        int i3;
        if (!this.dstUserIsChannelAdmin && (i3 = this.userDstType) != 2 && i3 != 1) {
            setContainerVisibleAwareLoading(0);
        } else {
            setContainerVisibleAwareLoading(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.b
    public void detachFromComponentController() {
        super.detachFromComponentController();
        QLog.e(this.TAG, 1, "detachFromComponentController " + System.identityHashCode(ch.R0(IGPSService.class)));
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        GPServiceObserver gPServiceObserver = this.gPServiceObserver;
        if (gPServiceObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gPServiceObserver");
            gPServiceObserver = null;
        }
        iGPSService.deleteObserver(gPServiceObserver);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    @NotNull
    /* renamed from: getComponentName, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1004;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f168148f24;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f165952y64) {
            setMuteInLive();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(@Nullable Fragment fragment, @Nullable AppInterface appInterface, @Nullable Bundle savedInstanceState) {
        super.onCreate(fragment, appInterface, savedInstanceState);
        this.mIsFinishing = false;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
        super.onDestroy();
        this.mIsFinishing = true;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadFinish() {
        this.isLoading = false;
        setContainerVisibleAwareLoading(this.visibility);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadStart() {
        this.isLoading = true;
        this.mViewContainer.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(@NotNull GuildProfileData guildProfileData) {
        Intrinsics.checkNotNullParameter(guildProfileData, "guildProfileData");
        this.dstUserIsChannelAdmin = false;
        View findViewById = this.mViewContainer.findViewById(R.id.f165952y64);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mViewContainer.findViewById(R.id.iv_mute_in_live)");
        this.muteIcon = (ImageView) findViewById;
        View findViewById2 = this.mViewContainer.findViewById(R.id.f109476fx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mViewContainer.findViewById(R.id.tv_mute_live)");
        this.muteTips = (TextView) findViewById2;
        ImageView imageView = this.muteIcon;
        GuildBaseProfileData guildBaseProfileData = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteIcon");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        setObservers();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        this.appRuntime = peekAppRuntime;
        if (peekAppRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            peekAppRuntime = null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        this.gpsService = (IGPSService) runtimeService;
        super.onInitData(guildProfileData);
        GuildBaseProfileData guildBaseProfileData2 = guildProfileData.getGuildBaseProfileData();
        Intrinsics.checkNotNullExpressionValue(guildBaseProfileData2, "guildProfileData.guildBaseProfileData");
        this.userData = guildBaseProfileData2;
        IGPSService iGPSService = this.gpsService;
        if (iGPSService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gpsService");
            iGPSService = null;
        }
        GuildBaseProfileData guildBaseProfileData3 = this.userData;
        if (guildBaseProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            guildBaseProfileData3 = null;
        }
        String e16 = guildBaseProfileData3.e();
        GuildBaseProfileData guildBaseProfileData4 = this.userData;
        if (guildBaseProfileData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            guildBaseProfileData4 = null;
        }
        String a16 = guildBaseProfileData4.a();
        GuildBaseProfileData guildBaseProfileData5 = this.userData;
        if (guildBaseProfileData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
        } else {
            guildBaseProfileData = guildBaseProfileData5;
        }
        iGPSService.checkUserBannedSpeakInChannel(e16, a16, guildBaseProfileData.b(), new f() { // from class: bw1.d
            @Override // vh2.f
            public final void a(int i3, String str, int i16) {
                GuildProfileLiveManageComponent.onInitData$lambda$0(GuildProfileLiveManageComponent.this, i3, str, i16);
            }
        });
        checkCanShow();
        setDtPage(guildProfileData);
        setDtElement();
        fetchDstUseRoles();
    }
}
