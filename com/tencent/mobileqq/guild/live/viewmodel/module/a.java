package com.tencent.mobileqq.guild.live.viewmodel.module;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.GamePlayTogetherMgr;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import e12.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pf4.PlayTogetherTeamInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR:\u0010%\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020! \"*\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010 0 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R)\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 0\u00198\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR\"\u0010*\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00030\u00030\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010$R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u001dR\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/live/viewmodel/module/a;", "Lcom/tencent/mobileqq/guild/live/viewmodel/a;", "Landroidx/lifecycle/Observer;", "", "Lpf4/h;", "teamInfo", "", "S1", "init", "destroy", "enterRoomSuc", "R1", "(Ljava/lang/Boolean;)V", "i", "Z", "isInited", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "core", "Lcom/tencent/mobileqq/guild/util/cn;", "Ljava/lang/Void;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/util/cn;", "_playTogetherIconUpdateEvent", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "playTogetherIconUpdateEvent", "Le12/e;", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "E", "Le12/e;", "_playTogetherGuideText", UserInfo.SEX_FEMALE, "O1", "playTogetherGuideText", "G", "_playTogetherGuideVisible", "H", "P1", "playTogetherGuideVisible", "Lpf4/e;", "I", "Lpf4/e;", "playTogetherEventListener", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends com.tencent.mobileqq.guild.live.viewmodel.a implements Observer<Boolean> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final cn<Void> _playTogetherIconUpdateEvent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Void> playTogetherIconUpdateEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e<Pair<String, String>> _playTogetherGuideText;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<String, String>> playTogetherGuideText;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e<Boolean> _playTogetherGuideVisible;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> playTogetherGuideVisible;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final pf4.e playTogetherEventListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInited;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveChannelCore core = GLiveChannelCore.f226698a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/live/viewmodel/module/a$b", "Lpf4/e;", "Lpf4/h;", "teamInfo", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends pf4.e {
        b() {
        }

        @Override // pf4.e
        public void b(@NotNull PlayTogetherTeamInfo teamInfo) {
            Intrinsics.checkNotNullParameter(teamInfo, "teamInfo");
            if (QLog.isColorLevel()) {
                QLog.i("QGL.GuildPlayTogetherVM", 2, "onTeamInfoUpdate " + teamInfo);
            }
            a.this._playTogetherIconUpdateEvent.d();
            a.this.S1(teamInfo);
        }
    }

    public a() {
        cn<Void> cnVar = new cn<>();
        this._playTogetherIconUpdateEvent = cnVar;
        this.playTogetherIconUpdateEvent = cnVar;
        e<Pair<String, String>> eVar = new e<>(new Pair("", ""));
        this._playTogetherGuideText = eVar;
        this.playTogetherGuideText = eVar;
        e<Boolean> eVar2 = new e<>(Boolean.FALSE);
        this._playTogetherGuideVisible = eVar2;
        this.playTogetherGuideVisible = eVar2;
        this.playTogetherEventListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(PlayTogetherTeamInfo teamInfo) {
        if (!this.core.r().e()) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.GuildPlayTogetherVM", 2, "updatePlayTogetherGuideStatus is not game live, set game guide invisible");
            }
            this._playTogetherGuideVisible.setValue(Boolean.FALSE);
            return;
        }
        Boolean value = this.core.t().n().getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value, bool)) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.GuildPlayTogetherVM", 2, "updatePlayTogetherGuideStatus is not in live room, set game guide invisible");
            }
            this._playTogetherGuideVisible.setValue(Boolean.FALSE);
            return;
        }
        boolean areEqual = Intrinsics.areEqual(this.core.t().D().getValue(), bool);
        if (QLog.isColorLevel()) {
            QLog.i("QGL.GuildPlayTogetherVM", 2, "updatePlayTogetherGuideStatus " + areEqual);
        }
        if (!areEqual) {
            String modeName = teamInfo.getModeName();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f148170yv);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_live_play_together_join_team)");
            boolean z16 = false;
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(teamInfo.getCurrentPlayerCount()), Integer.valueOf(teamInfo.getModeMaxPlayerCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this._playTogetherGuideText.setValue(new Pair<>(modeName, format));
            e<Boolean> eVar = this._playTogetherGuideVisible;
            if (teamInfo.getStatus() == 1 && GamePlayTogetherMgr.INSTANCE.a().f().e() == 1) {
                z16 = true;
            }
            eVar.setValue(Boolean.valueOf(z16));
            return;
        }
        this._playTogetherGuideVisible.setValue(Boolean.FALSE);
    }

    @NotNull
    public final LiveData<Pair<String, String>> O1() {
        return this.playTogetherGuideText;
    }

    @NotNull
    public final LiveData<Boolean> P1() {
        return this.playTogetherGuideVisible;
    }

    @NotNull
    public final LiveData<Void> Q1() {
        return this.playTogetherIconUpdateEvent;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable Boolean enterRoomSuc) {
        if (!Intrinsics.areEqual(enterRoomSuc, Boolean.TRUE)) {
            this._playTogetherGuideVisible.setValue(Boolean.FALSE);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void destroy() {
        if (!this.isInited) {
            return;
        }
        this.core.t().n().removeObserver(this);
        GamePlayTogetherMgr.Companion companion = GamePlayTogetherMgr.INSTANCE;
        companion.a().f().b(this.playTogetherEventListener);
        companion.a().c();
    }

    @Override // com.tencent.mobileqq.guild.live.viewmodel.a
    public void init() {
        if (this.isInited) {
            return;
        }
        this.core.t().n().observeForever(this);
        GamePlayTogetherMgr.INSTANCE.a().f().a(this.playTogetherEventListener);
        this.isInited = true;
    }
}
