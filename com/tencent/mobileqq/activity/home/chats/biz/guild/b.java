package com.tencent.mobileqq.activity.home.chats.biz.guild;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR.\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0013*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00120\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001bR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R#\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u00178\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001bR \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0015R#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00120\u00178\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u0015R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001b\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/b;", "Landroidx/lifecycle/ViewModel;", "", "isDisplay", "", "P1", NodeProps.VISIBLE, "O1", "", "guildId", "Q1", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$GuildState;", "state", "R1", "Laf1/a;", "jumpAction", "S1", "Landroidx/lifecycle/MutableLiveData;", "Lef1/a;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_isDisplayGuildFrameLayout", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "isDisplayGuildFrameLayout", BdhLogUtil.LogTag.Tag_Conn, "_guildId", "D", "L1", "E", "_guildState", UserInfo.SEX_FEMALE, "M1", "guildState", "G", "_jumpEvent", "H", "getJumpEvent", "jumpEvent", "I", "_completedVisible", "J", "getCompletedVisible", "completedVisible", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<String>> _guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ef1.a<String>> guildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<IGuildLayoutApi.GuildState>> _guildState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ef1.a<IGuildLayoutApi.GuildState>> guildState;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<af1.a>> _jumpEvent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ef1.a<af1.a>> jumpEvent;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _completedVisible;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> completedVisible;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Boolean>> _isDisplayGuildFrameLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<ef1.a<Boolean>> isDisplayGuildFrameLayout;

    public b() {
        MutableLiveData<ef1.a<Boolean>> mutableLiveData = new MutableLiveData<>(new ef1.a(Boolean.FALSE));
        this._isDisplayGuildFrameLayout = mutableLiveData;
        this.isDisplayGuildFrameLayout = mutableLiveData;
        MutableLiveData<ef1.a<String>> mutableLiveData2 = new MutableLiveData<>();
        this._guildId = mutableLiveData2;
        this.guildId = mutableLiveData2;
        MutableLiveData<ef1.a<IGuildLayoutApi.GuildState>> mutableLiveData3 = new MutableLiveData<>();
        this._guildState = mutableLiveData3;
        this.guildState = mutableLiveData3;
        MutableLiveData<ef1.a<af1.a>> mutableLiveData4 = new MutableLiveData<>();
        this._jumpEvent = mutableLiveData4;
        this.jumpEvent = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._completedVisible = mutableLiveData5;
        this.completedVisible = mutableLiveData5;
    }

    @NotNull
    public final LiveData<ef1.a<String>> L1() {
        return this.guildId;
    }

    @NotNull
    public final LiveData<ef1.a<IGuildLayoutApi.GuildState>> M1() {
        return this.guildState;
    }

    @NotNull
    public final LiveData<ef1.a<Boolean>> N1() {
        return this.isDisplayGuildFrameLayout;
    }

    public final void O1(boolean visible) {
        this._completedVisible.postValue(Boolean.valueOf(visible));
    }

    public final void P1(boolean isDisplay) {
        this._isDisplayGuildFrameLayout.setValue(new ef1.a<>(Boolean.valueOf(isDisplay)));
    }

    public final void Q1(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this._guildId.setValue(new ef1.a<>(guildId));
    }

    public final void R1(@NotNull IGuildLayoutApi.GuildState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this._guildState.setValue(new ef1.a<>(state));
    }

    public final void S1(@NotNull af1.a jumpAction) {
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        this._jumpEvent.setValue(new ef1.a<>(jumpAction));
    }
}
