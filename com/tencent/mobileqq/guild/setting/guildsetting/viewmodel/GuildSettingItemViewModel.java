package com.tencent.mobileqq.guild.setting.guildsetting.viewmodel;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingItemViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.al;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildActiveValue;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotCardRecommendReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotCardRecommendRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotCardRecommendCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import tencent.im.oidb.cmd0x106a.oidb_0x106a$CardRecommendReply;
import tencent.im.oidb.cmd0x106a.oidb_0x106a$RobotInfo;
import vh2.ak;
import wh2.df;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001aR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001aR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001aR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070'8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010)R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0'8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010)\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingItemViewModel;", "Lef1/b;", "", "g2", "T1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildActiveValue;", "activeValue", "", "Z1", SemanticAttributes.DbSystemValues.H2, "i2", "", HippyHeaderListViewController.VIEW_TAG, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f2", "W1", "Landroid/view/View;", "view", "e2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "Le12/a;", "Lwz1/b;", "D", "Le12/a;", "mUpdateRobotRecommendData", "", "E", "c2", "()Le12/a;", "noRobotRecommendData", UserInfo.SEX_FEMALE, "_myGuildTodayActive", "G", "_levelIcon", "H", "_showReportEntrance", "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "myGuildTodayActive", ICustomDataEditor.STRING_ARRAY_PARAM_2, "levelIcon", "d2", "showReportEntrance", "<init>", "(Ljava/lang/String;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingItemViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<wz1.b> mUpdateRobotRecommendData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> noRobotRecommendData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _myGuildTodayActive;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _levelIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _showReportEntrance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingItemViewModel$1", f = "GuildSettingItemViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingItemViewModel$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildSettingItemViewModel.this.W1();
                GuildSettingItemViewModel.this.T1();
                GuildSettingItemViewModel.this.h2();
                GuildSettingItemViewModel.this.g2();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingItemViewModel$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildRobotCardRecommendCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotCardRecommendRsp;", "cardRecommendReply", "", "d", "", "errCode", "", "msg", "b", "result", "errMsg", "rsp", "onGetGuildRobotCardRecommend", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IGetGuildRobotCardRecommendCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f234518a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildSettingItemViewModel f234519b;

        b(String str, GuildSettingItemViewModel guildSettingItemViewModel) {
            this.f234518a = str;
            this.f234519b = guildSettingItemViewModel;
        }

        private final void b(int errCode, String msg2) {
            QLog.e("GuildSettingItemViewModel", 1, "showRobotRecommend errCode = " + errCode + " msg = " + msg2);
            this.f234519b.c2().setValue(Boolean.TRUE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i3, b this$0, String errMsg, GProGuildRobotCardRecommendRsp rsp) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            if (i3 != 0) {
                this$0.b(i3, errMsg);
            } else {
                this$0.d(rsp);
            }
        }

        private final void d(GProGuildRobotCardRecommendRsp cardRecommendReply) {
            ArrayList<GProGuildRobotInfo> bots = cardRecommendReply.getBots();
            Intrinsics.checkNotNullExpressionValue(bots, "cardRecommendReply.getBots()");
            int moreNum = cardRecommendReply.getMoreNum();
            int maxRecommendIcon = cardRecommendReply.getMaxRecommendIcon();
            if (QLog.isColorLevel()) {
                QLog.d("GuildSettingItemViewModel", 2, "showRobotRecommend text = " + cardRecommendReply.getText() + ",more_num = " + moreNum + ",maxShowIcon = " + maxRecommendIcon + ",next_update_timestamp = " + cardRecommendReply.getNextUpdateTimestamp() + ",save_robot = " + this.f234518a);
            }
            String tips = cardRecommendReply.getText();
            bw.f235485a.N1(this.f234518a, cardRecommendReply.getNextUpdateTimestamp());
            ArrayList arrayList = new ArrayList();
            int min = Math.min(maxRecommendIcon, bots.size());
            if (moreNum > 0) {
                min--;
            }
            for (int i3 = 0; i3 < min; i3++) {
                arrayList.add(String.valueOf(bots.get(i3).getRobotTid()));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_robot_num", Integer.valueOf(bots.size()));
            Intrinsics.checkNotNullExpressionValue(tips, "tips");
            hashMap.put("sgrp_robot_word", tips);
            hashMap.put("sgrp_robot_id_list", arrayList);
            this.f234519b.mUpdateRobotRecommendData.setValue(new wz1.b(bots, moreNum, maxRecommendIcon, tips, hashMap, cardRecommendReply));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotCardRecommendCallback
        public void onGetGuildRobotCardRecommend(final int result, @NotNull final String errMsg, @NotNull final GProGuildRobotCardRecommendRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildSettingItemViewModel.b.c(result, this, errMsg, rsp);
                }
            });
        }
    }

    public GuildSettingItemViewModel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.mUpdateRobotRecommendData = new e12.a<>();
        this.noRobotRecommendData = new e12.a<>();
        this._myGuildTodayActive = new e12.a<>();
        this._levelIcon = new e12.a<>();
        this._showReportEntrance = new e12.a<>();
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildSettingItemViewModel init", null, null, null, new AnonymousClass1(null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildActiveValue(NumberUtil.stringToLong(this.guildId), new df() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.g
            @Override // wh2.df
            public final void a(int i3, String str, IGProGuildActiveValue iGProGuildActiveValue) {
                GuildSettingItemViewModel.U1(GuildSettingItemViewModel.this, i3, str, iGProGuildActiveValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(GuildSettingItemViewModel this$0, int i3, String errMsg, IGProGuildActiveValue iGProGuildActiveValue) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (QLog.isColorLevel()) {
            QLog.i("GuildSettingItemViewModel", 2, "fetchGuildActiveValue result " + i3 + ",errMsg: " + errMsg + ",value: " + this$0.Z1(iGProGuildActiveValue));
        }
        if (i3 == 0 && iGProGuildActiveValue != null) {
            if (iGProGuildActiveValue.getMyTodayActive() > 0) {
                this$0._myGuildTodayActive.setValue(Marker.ANY_NON_NULL_MARKER + al.a(iGProGuildActiveValue.getMyTodayActive()));
                return;
            }
            return;
        }
        QLog.i("GuildSettingItemViewModel", 1, "fetchGuildActiveValue failed result " + i3 + ",errMsg: " + errMsg + ",value: " + this$0.Z1(iGProGuildActiveValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(GuildSettingItemViewModel this$0, int i3, String errMsg, List list) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (i3 == 0) {
            List list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QLog.i("GuildSettingItemViewModel", 2, "fetchMemberRoles, result: " + i3 + ",list: " + list);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    IGProGuildRoleInfo iGProGuildRoleInfo = (IGProGuildRoleInfo) it.next();
                    if (iGProGuildRoleInfo != null && iGProGuildRoleInfo.isLevelRole()) {
                        this$0._levelIcon.setValue(iGProGuildRoleInfo.getLevelIconUrl());
                        return;
                    }
                }
                return;
            }
        }
        QLog.w("GuildSettingItemViewModel", 1, "fetchMemberRoles, result: " + i3 + ",errMsg: " + errMsg + ", list: " + list);
    }

    private final String Z1(IGProGuildActiveValue activeValue) {
        StringBuilder sb5 = new StringBuilder();
        if (activeValue != null) {
            sb5.append("getTotalGuildActive: ");
            sb5.append(activeValue.getTotalGuildActive());
            sb5.append(", getGuildTodayAddActive: ");
            sb5.append(activeValue.getTotalGuildActive());
            sb5.append(", getMyTodayActive: ");
            sb5.append(activeValue.getMyTodayActive());
        }
        return sb5.toString();
    }

    private final void f2(Object viewTag, Activity activity) {
        bw.f235485a.M1(i2(), false);
        ArrayList<String> arrayList = new ArrayList<>();
        if (viewTag instanceof oidb_0x106a$CardRecommendReply) {
            Iterator<oidb_0x106a$RobotInfo> it = ((oidb_0x106a$CardRecommendReply) viewTag).bots.get().iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().robot_uin.get()));
            }
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openRobotList(activity, this.guildId, arrayList);
        this.noRobotRecommendData.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        boolean z16 = true;
        List<IGProChannelInfo> channelList = ((IGuildAdapterService) ch.R0(IGuildAdapterService.class)).getChannelList(this.guildId, true);
        e12.a<Boolean> aVar = this._showReportEntrance;
        if (channelList == null || channelList.isEmpty()) {
            z16 = false;
        }
        aVar.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        String str = "robot_recommend_tablerobot_recommend_" + this.guildId;
        bw bwVar = bw.f235485a;
        long c06 = bwVar.c0(str);
        boolean b06 = bwVar.b0(i2());
        if (!b06 && System.currentTimeMillis() / 1000 >= c06) {
            b06 = true;
            bwVar.M1(i2(), true);
        }
        if (!b06) {
            this.noRobotRecommendData.setValue(Boolean.TRUE);
            return;
        }
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.getGuildRobotCardRecommend(new GProGuildRobotCardRecommendReq(az.d(this.guildId, 0L), 0L), new b(str, this));
    }

    private final String i2() {
        return "robot_recommend_tableis_show_robot_recommend_" + this.guildId;
    }

    public final void W1() {
        IRuntimeService runtimeService = M1().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        String selfTinyId = ((IGPSService) runtimeService).getSelfTinyId();
        QLog.i("GuildSettingItemViewModel", 1, "fetchMemberRoles:  selfTinyId: " + selfTinyId);
        ((IGPSService) ch.R0(IGPSService.class)).fetchMemberRoleList(this.guildId, "", selfTinyId, 102, new ak() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.f
            @Override // vh2.ak
            public final void a(int i3, String str, List list) {
                GuildSettingItemViewModel.X1(GuildSettingItemViewModel.this, i3, str, list);
            }
        });
    }

    @NotNull
    public final LiveData<String> a2() {
        return this._levelIcon;
    }

    @NotNull
    public final LiveData<String> b2() {
        return this._myGuildTodayActive;
    }

    @NotNull
    public final e12.a<Boolean> c2() {
        return this.noRobotRecommendData;
    }

    @NotNull
    public final LiveData<Boolean> d2() {
        return this._showReportEntrance;
    }

    public final void e2(@NotNull View view, @Nullable Activity activity) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (QQGuildUIUtil.v()) {
            return;
        }
        f2(view.getTag(), activity);
    }
}
