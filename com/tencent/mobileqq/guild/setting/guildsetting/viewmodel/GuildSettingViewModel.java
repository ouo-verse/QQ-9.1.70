package com.tencent.mobileqq.guild.setting.guildsetting.viewmodel;

import android.app.Activity;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.s;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cj;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.ActionSheet;
import ef1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cz;
import wh2.ap;
import wh2.dc;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 e2\u00020\u0001:\u0001fB\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0017\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0002J\u001e\u0010\u0016\u001a\u00020\u00022\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0014R\u0014\u0010\u001f\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u000106058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0017058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0017058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0007058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00108R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130@058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u00108R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020C058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u00108R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020C058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u00108R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020C058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u00108R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u0007058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u00108R\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020L058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u00108R\u0019\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060O8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170O8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010QR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00170O8F\u00a2\u0006\u0006\u001a\u0004\bT\u0010QR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070O8F\u00a2\u0006\u0006\u001a\u0004\bV\u0010QR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130@0O8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010QR\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020C0O8F\u00a2\u0006\u0006\u001a\u0004\bY\u0010QR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020C0O8F\u00a2\u0006\u0006\u001a\u0004\b[\u0010QR\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020C0O8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010QR\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00070O8F\u00a2\u0006\u0006\u001a\u0004\b_\u0010QR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020L0O8F\u00a2\u0006\u0006\u001a\u0004\ba\u0010Q\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "Lef1/b;", "", "u2", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "d2", "m2", "", "notifyFlag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/widget/ActionSheet;", "actionSheet", "y2", "w2", WidgetCacheConstellationData.NUM, "e2", "t2", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "memberList", "B2", "", "userName", NowProxyConstants.AccountInfoKey.A2, "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingPermissionViewModel;", "D", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingPermissionViewModel;", "l2", "()Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingPermissionViewModel;", "guildSettingPermissionViewModel", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingItemViewModel;", "E", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingItemViewModel;", "k2", "()Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingItemViewModel;", "guildSettingItemViewModel", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "i2", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "G", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Le12/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "H", "Le12/a;", "_guildInfo", "I", "_userName", "J", "_userAvatar", "K", "_totalMemberCnt", "", "L", "_memberList", "", "M", "_canRemoveMember", "N", "_canInviteMember", "P", "_isExitGuild", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_unNotifyFlag", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", BdhLogUtil.LogTag.Tag_Req, "_userProfileInfo", "Landroidx/lifecycle/LiveData;", "j2", "()Landroidx/lifecycle/LiveData;", "guildInfo", "r2", "q2", "userAvatar", "o2", "totalMemberCnt", ICustomDataEditor.NUMBER_PARAM_2, SemanticAttributes.DbSystemValues.H2, "canRemoveMember", "g2", "canInviteMember", "v2", "isExitGuild", "p2", "unNotifyFlag", ICustomDataEditor.STRING_PARAM_2, "userProfileInfo", "<init>", "(Ljava/lang/String;)V", ExifInterface.LATITUDE_SOUTH, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildSettingPermissionViewModel guildSettingPermissionViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildSettingItemViewModel guildSettingItemViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e12.a<IGProGuildInfo> _guildInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _userName;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _userAvatar;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Integer> _totalMemberCnt;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final e12.a<List<IGProUserInfo>> _memberList;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _canRemoveMember;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _canInviteMember;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _isExitGuild;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Integer> _unNotifyFlag;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final e12.a<ev> _userProfileInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingViewModel$1", f = "GuildSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingViewModel$1, reason: invalid class name */
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
                GuildSettingViewModel.this.w2();
                yz1.q qVar = yz1.q.f451648a;
                GuildSettingViewModel.this.e2(qVar.a(qVar.b(bi.d())));
                GuildSettingViewModel.this.t2();
                GuildSettingViewModel.this._guildInfo.setValue(ch.L(GuildSettingViewModel.this.guildId));
                GuildSettingViewModel.this._canInviteMember.setValue(Boxing.boxBoolean(qVar.d((IGProGuildInfo) GuildSettingViewModel.this._guildInfo.getValue())));
                GuildSettingViewModel.this.m2();
                GuildSettingViewModel.this.u2();
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
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014J2\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0014J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J8\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014\u00a8\u0006\u001d"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "mGuildId", "", "b", "onGuildInfoUpdated", "guildId", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "", AppConstants.Key.COLUMN_IS_VALID, "isBanned", "isFrozen", "", "guildBannedTimeLimit", "onBannedStatusChanged", "tinyId", "onUserDisplayNameUpdate", "onGuildUserAvatarUrlUpdate", "result", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        private final void b(String mGuildId) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildSettingViewModel", "onLeaveGuild: mGuildId " + mGuildId);
            }
            if (Intrinsics.areEqual(mGuildId, GuildSettingViewModel.this.guildId)) {
                GuildSettingViewModel.this._guildInfo.setValue(ch.L(mGuildId));
                GuildSettingViewModel.this._canInviteMember.setValue(Boolean.valueOf(yz1.q.f451648a.d((IGProGuildInfo) GuildSettingViewModel.this._guildInfo.getValue())));
                GuildSettingViewModel.this._isExitGuild.setValue(Boolean.TRUE);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onBannedStatusChanged(@Nullable String guildId, boolean isValid, boolean isBanned, boolean isFrozen, long guildBannedTimeLimit) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildSettingViewModel", "onBannedStatusChanged: isBanned " + isBanned);
            }
            if (isBanned) {
                GuildSettingViewModel.this._guildInfo.setValue(ch.L(guildId));
                GuildSettingViewModel.this._canInviteMember.setValue(Boolean.valueOf(yz1.q.f451648a.d((IGProGuildInfo) GuildSettingViewModel.this._guildInfo.getValue())));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String mGuildId) {
            if (Intrinsics.areEqual(mGuildId, GuildSettingViewModel.this.guildId)) {
                GuildSettingViewModel.this._guildInfo.setValue(ch.L(mGuildId));
                GuildSettingViewModel.this._canInviteMember.setValue(Boolean.valueOf(yz1.q.f451648a.d((IGProGuildInfo) GuildSettingViewModel.this._guildInfo.getValue())));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(@NotNull String mGuildId, @NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildSettingViewModel", "onGuildUserAvatarUrlUpdate: tinyId " + tinyId);
            }
            if (Intrinsics.areEqual(GuildSettingViewModel.this.gProService.getSelfTinyId(), tinyId) && Intrinsics.areEqual(mGuildId, GuildSettingViewModel.this.guildId)) {
                GuildSettingViewModel.this._userAvatar.setValue(tinyId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            b(guildId);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildSettingViewModel", "onUserDisplayNameUpdate: tinyId " + tinyId);
            }
            if (Intrinsics.areEqual(GuildSettingViewModel.this.gProService.getSelfTinyId(), tinyId)) {
                GuildSettingViewModel.this.m2();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String mGuildId, @Nullable String tinyId, @Nullable ev info) {
            super.onUserProfileInfoUpdate(result, errMsg, mGuildId, tinyId, info);
            if (Intrinsics.areEqual(GuildSettingViewModel.this.gProService.getSelfTinyId(), tinyId) && info != null) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildSettingViewModel", "onUserProfileInfoUpdate: tinyId " + tinyId + ", " + info.a());
                }
                GuildSettingViewModel.this._userProfileInfo.setValue(info);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f234525a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildSettingViewModel f234526b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildSettingViewModel guildSettingViewModel) {
            this.f234525a = viewModelStoreOwner;
            this.f234526b = guildSettingViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildSettingPermissionViewModel(this.f234526b.guildId), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f234527a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildSettingViewModel f234528b;

        public d(ViewModelStoreOwner viewModelStoreOwner, GuildSettingViewModel guildSettingViewModel) {
            this.f234527a = viewModelStoreOwner;
            this.f234528b = guildSettingViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildSettingItemViewModel(this.f234528b.guildId), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public GuildSettingViewModel(@NotNull String guildId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this, this)).get(GuildSettingPermissionViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildSettingPermissionViewModel = (GuildSettingPermissionViewModel) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(this, new d(this, this)).get(GuildSettingItemViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildSettingItemViewModel = (GuildSettingItemViewModel) viewModel2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver d26;
                d26 = GuildSettingViewModel.this.d2();
                return d26;
            }
        });
        this.gProObserver = lazy;
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        this._guildInfo = new e12.a<>();
        this._userName = new e12.a<>();
        this._userAvatar = new e12.a<>();
        this._totalMemberCnt = new e12.a<>();
        this._memberList = new e12.a<>();
        this._canRemoveMember = new e12.a<>();
        this._canInviteMember = new e12.a<>();
        this._isExitGuild = new e12.a<>();
        this._unNotifyFlag = new e12.a<>();
        this._userProfileInfo = new e12.a<>();
        this.gProService.addObserver(i2());
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildSettingViewModel init", null, null, null, new AnonymousClass1(null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver d2() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(GuildSettingViewModel this$0, int i3, int i16, String str, IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
        boolean z16;
        List<IGProUserInfo> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 == 0) {
            ArrayList<IGProUserInfo> memberList = iGProGuildInfoAndMemberListRsp.getMemberList();
            if (memberList != null && !memberList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (this$0.h2().getValue() == null) {
                    this$0.t2();
                }
                if (iGProGuildInfoAndMemberListRsp.getMemberList().size() > i3) {
                    list = iGProGuildInfoAndMemberListRsp.getMemberList().subList(0, i3);
                    Intrinsics.checkNotNullExpressionValue(list, "{\n                    rs\u20260, num)\n                }");
                } else {
                    ArrayList<IGProUserInfo> memberList2 = iGProGuildInfoAndMemberListRsp.getMemberList();
                    Intrinsics.checkNotNullExpressionValue(memberList2, "rsp.memberList");
                    list = CollectionsKt___CollectionsKt.toList(memberList2);
                }
                this$0._memberList.setValue(list);
                this$0._totalMemberCnt.setValue(Integer.valueOf(iGProGuildInfoAndMemberListRsp.getTotalMemberCnt()));
                return;
            }
        }
        QLog.e("GuildSettingViewModel", 1, "fetchGuildInfoAndMemberList, result: " + i16 + ",errMsg: " + str);
    }

    private final GPServiceObserver i2() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void m2() {
        this._userName.setValue(this.gProService.getGuildUserDisplayNameInternal(this.guildId, this.gProService.getSelfTinyId()));
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildSettingViewModel", 2, "[getGuildUserDisplayNameInternal] userName " + cq.w((String) this._userName.getValue(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2() {
        f02.c cVar = new f02.c(this.guildId, M1());
        if (cVar.b() == 3) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("initNotifySetting error unNotifyType:SHIELD");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildSettingViewModel", 1, (String) it.next(), null);
            }
        }
        this._unNotifyFlag.setValue(Integer.valueOf(cVar.b()));
        QLog.i("GuildSettingViewModel", 4, "initNotifySetting _unNotifyType" + this._unNotifyFlag.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(GuildSettingViewModel this$0, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (arrayList != null && arrayList.size() > 0) {
            this$0.B2(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(Activity activity, GuildSettingViewModel this$0, int i3, ActionSheet actionSheet, int i16, String str, int i17) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 != 0) {
            if (i16 == 39006) {
                com.tencent.mobileqq.guild.util.security.b.c(activity, i16, str, activity.getResources().getString(R.string.f15197195));
            } else {
                com.tencent.mobileqq.guild.util.security.b.c(activity, i16, str, activity.getResources().getString(R.string.f141730hg));
            }
        } else {
            this$0._unNotifyFlag.setValue(Integer.valueOf(i3));
        }
        QLog.i("GuildSettingViewModel", 4, " setGuildUnNotifyFlag  req(guildId:" + this$0.guildId + ", notifyFlag:" + i3 + ")  result:" + i16 + " ,errMsg:" + str);
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }

    public final void A2(@NotNull String userName) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildSettingViewModel", 2, "[showGuildUserInfo] userName " + userName);
        }
        this._userName.setValue(userName);
        this._userAvatar.setValue(userName);
    }

    public final void B2(@NotNull ArrayList<IGProUserInfo> memberList) {
        List<IGProUserInfo> list;
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        yz1.q qVar = yz1.q.f451648a;
        int a16 = qVar.a(qVar.b(bi.d()));
        if (h2().getValue() == null) {
            t2();
        }
        if (memberList.size() <= a16) {
            list = CollectionsKt___CollectionsKt.toList(memberList);
        } else {
            list = memberList.subList(0, a16);
            Intrinsics.checkNotNullExpressionValue(list, "{\n            memberList.subList(0, num)\n        }");
        }
        this._memberList.setValue(list);
    }

    public final void e2(final int num) {
        cj cjVar = new cj();
        cjVar.g(Long.parseLong(this.guildId));
        cjVar.f(num * 3);
        cjVar.i(true);
        Logger.f235387a.d().d("GuildSettingViewModel", 1, "[fetchGuildInfoAndMemberList] guildId: " + this.guildId + ", getNum: " + cjVar.a());
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoAndMemberList(cjVar, new ap() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.o
            @Override // wh2.ap
            public final void a(int i3, String str, IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
                GuildSettingViewModel.f2(GuildSettingViewModel.this, num, i3, str, iGProGuildInfoAndMemberListRsp);
            }
        });
    }

    @NotNull
    public final LiveData<Boolean> g2() {
        return this._canInviteMember;
    }

    @NotNull
    public final LiveData<Boolean> h2() {
        return this._canRemoveMember;
    }

    @NotNull
    public final LiveData<IGProGuildInfo> j2() {
        return this._guildInfo;
    }

    @NotNull
    /* renamed from: k2, reason: from getter */
    public final GuildSettingItemViewModel getGuildSettingItemViewModel() {
        return this.guildSettingItemViewModel;
    }

    @NotNull
    /* renamed from: l2, reason: from getter */
    public final GuildSettingPermissionViewModel getGuildSettingPermissionViewModel() {
        return this.guildSettingPermissionViewModel;
    }

    @NotNull
    public final LiveData<List<IGProUserInfo>> n2() {
        return this._memberList;
    }

    @NotNull
    public final LiveData<Integer> o2() {
        return this._totalMemberCnt;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.gProService.deleteObserver(i2());
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(i2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(i2());
    }

    @NotNull
    public final LiveData<Integer> p2() {
        return this._unNotifyFlag;
    }

    @NotNull
    public final LiveData<String> q2() {
        return this._userAvatar;
    }

    @NotNull
    public final LiveData<String> r2() {
        return this._userName;
    }

    @NotNull
    public final LiveData<ev> s2() {
        return this._userProfileInfo;
    }

    public final void t2() {
        boolean z16;
        Permissions guildPermission = s.a().getGuildPermission(this.guildId);
        if (!guildPermission.a(100001) && !guildPermission.a(100002)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this._canRemoveMember.setValue(Boolean.valueOf(z16));
    }

    @NotNull
    public final LiveData<Boolean> v2() {
        return this._isExitGuild;
    }

    public final void w2() {
        ((IGPSService) ch.R0(IGPSService.class)).loadPartRoleMemberList(Long.parseLong(this.guildId), new dc() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.p
            @Override // wh2.dc
            public final void onGetUserInfo(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                GuildSettingViewModel.x2(GuildSettingViewModel.this, i3, str, arrayList, arrayList2);
            }
        });
    }

    public final void y2(final int notifyFlag, @NotNull final Activity activity, @Nullable final ActionSheet actionSheet) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BusinessHandler businessHandler = M1().getBusinessHandler(QQGuildHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler");
        ((QQGuildHandler) businessHandler).a3(this.guildId, notifyFlag, new cz() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.q
            @Override // vh2.cz
            public final void a(int i3, String str, int i16) {
                GuildSettingViewModel.z2(activity, this, notifyFlag, actionSheet, i3, str, i16);
            }
        });
    }
}
