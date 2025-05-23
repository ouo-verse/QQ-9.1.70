package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper;
import com.tencent.mobileqq.guild.discovery.publicaccount.GuildPublicAccountDiscoveryFragmentV2;
import com.tencent.mobileqq.guild.util.TraceUtils;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildDiscoverApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildDiscoverApi;", "()V", "guildTabLoadingLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "fetchAbTest", "", "fetchSceneId", "", "bizId", "", "source", "guildTabLoadingFinishData", "Landroidx/lifecycle/LiveData;", "isGuildPublicAccount", "uin", "openDiscoverFromPublicAccount", "context", "Landroid/content/Context;", "pubAccountParams", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "postGuildTabLoadingFinished", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildDiscoverApiImpl implements IGuildDiscoverApi {

    @NotNull
    private final MutableLiveData<Boolean> guildTabLoadingLiveData = new MutableLiveData<>(Boolean.FALSE);

    @Override // com.tencent.mobileqq.guild.api.IGuildDiscoverApi
    public void fetchAbTest(int fetchSceneId, @NotNull String bizId, @NotNull String source) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(source, "source");
        GuildDiscoverABTestHelper.s(fetchSceneId, bizId, source, null, 8, null);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDiscoverApi
    @NotNull
    public LiveData<Boolean> guildTabLoadingFinishData() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new GuildDiscoverApiImpl$guildTabLoadingFinishData$1(this, null), 3, null);
        return this.guildTabLoadingLiveData;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDiscoverApi
    public boolean isGuildPublicAccount(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return Intrinsics.areEqual(uin, AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDiscoverApi
    public void openDiscoverFromPublicAccount(@NotNull Context context, @NotNull GuildPublicAccountParams pubAccountParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pubAccountParams, "pubAccountParams");
        TraceUtils.n("Guild.MainUi.PublicAccountDiscoveryStart.");
        com.tencent.mobileqq.guild.performance.report.v.f231062a.b();
        GuildPublicAccountDiscoveryFragmentV2.INSTANCE.a(context, pubAccountParams);
        com.tencent.mobileqq.guild.performance.report.w.f231064i.k("GuildDiscoverApiImpl#openDiscoverFromPublicAccount", System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDiscoverApi
    public void postGuildTabLoadingFinished() {
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.api.impl.GuildDiscoverApiImpl$postGuildTabLoadingFinished$1
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
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = GuildDiscoverApiImpl.this.guildTabLoadingLiveData;
                T value = mutableLiveData.getValue();
                Boolean bool = Boolean.TRUE;
                if (Intrinsics.areEqual(value, bool)) {
                    return;
                }
                mutableLiveData2 = GuildDiscoverApiImpl.this.guildTabLoadingLiveData;
                mutableLiveData2.postValue(bool);
            }
        });
    }
}
