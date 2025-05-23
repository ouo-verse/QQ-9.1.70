package com.tencent.mobileqq.guild.message.draft.api.impl;

import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.message.draft.api.IGuildDraftService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yt1.DraftInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001\u0019\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/message/draft/api/impl/GuildDraftServiceImpl;", "Lcom/tencent/mobileqq/guild/message/draft/api/IGuildDraftService;", "Lyt1/a;", "draftInfo", "", "onDraftInfoUpdate", "Lzt1/a;", "callback", "registerChannelDraftCallback", "unRegisterChannelDraftCallback", "", "guildId", "channelId", "getDraftInfo", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/ConcurrentHashMap;", "Lau1/a;", "draftInfoProcesses", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "channelDraftCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mobileqq/guild/message/draft/api/impl/GuildDraftServiceImpl$b", "draftInfoCallback", "Lcom/tencent/mobileqq/guild/message/draft/api/impl/GuildDraftServiceImpl$b;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildDraftServiceImpl implements IGuildDraftService {

    @NotNull
    private static final String TAG = "Guild.GSC.GuildDraftServiceImpl";

    @NotNull
    private final ConcurrentHashMap<String, au1.a> draftInfoProcesses = new ConcurrentHashMap<>();

    @NotNull
    private final CopyOnWriteArrayList<zt1.a> channelDraftCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private final b draftInfoCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/message/draft/api/impl/GuildDraftServiceImpl$b", "Lyt1/b;", "", "result", "", "errMsg", "Lyt1/a;", "draftInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements yt1.b {
        b() {
        }

        @Override // yt1.b
        public void a(int result, @NotNull String errMsg, @NotNull DraftInfo draftInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(draftInfo, "draftInfo");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(GuildDraftServiceImpl.TAG, "draftInfoCallback draftInfo: " + draftInfo);
            }
            GuildDraftServiceImpl.this.onDraftInfoUpdate(draftInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDraftInfoUpdate(DraftInfo draftInfo) {
        synchronized (this.draftInfoProcesses) {
            if (!this.draftInfoProcesses.containsKey(draftInfo.getChannelId())) {
                this.draftInfoProcesses.put(draftInfo.getChannelId(), new au1.a(draftInfo.getGuildId(), draftInfo.getChannelId()));
            }
            au1.a aVar = this.draftInfoProcesses.get(draftInfo.getChannelId());
            Intrinsics.checkNotNull(aVar);
            if (aVar.b(draftInfo)) {
                Iterator<T> it = this.channelDraftCallbacks.iterator();
                while (it.hasNext()) {
                    ((zt1.a) it.next()).a(draftInfo);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.draft.api.IGuildDraftService
    @Nullable
    public DraftInfo getDraftInfo(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!this.draftInfoProcesses.containsKey(channelId)) {
            au1.a aVar = new au1.a(guildId, channelId);
            aVar.c();
            synchronized (this.draftInfoProcesses) {
                if (!this.draftInfoProcesses.containsKey(channelId)) {
                    this.draftInfoProcesses.put(channelId, aVar);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        au1.a aVar2 = this.draftInfoProcesses.get(channelId);
        if (aVar2 != null) {
            return aVar2.getDraftInfo();
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Logger.f235387a.d().i(TAG, 1, "onCreate");
        GuildDraftAdapter.f230542a.l(TAG, this.draftInfoCallback);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        Logger.f235387a.d().i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        GuildDraftAdapter.f230542a.m(TAG);
    }

    @Override // com.tencent.mobileqq.guild.message.draft.api.IGuildDraftService
    public void registerChannelDraftCallback(@NotNull zt1.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.channelDraftCallbacks.addIfAbsent(callback);
    }

    @Override // com.tencent.mobileqq.guild.message.draft.api.IGuildDraftService
    public void unRegisterChannelDraftCallback(@NotNull zt1.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.channelDraftCallbacks.remove(callback);
    }
}
