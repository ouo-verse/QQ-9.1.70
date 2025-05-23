package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096\u0001J\u0019\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0001J#\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0001\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMediaUploadServiceApi;", "", "", "fileIdSet", "", "Lcom/tencent/mobileqq/guild/data/o;", "batchGetUploadMediaTaskInfoList", "fileId", "Lcom/tencent/mobileqq/guild/data/g;", "mediaInfo", "", "createUploadMediaTask", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "p0", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "pauseUploadMediaTask", "removeUploadMediaTask", "localMediaInfo", "", "extraInfo", "restoreUploadMediaTask", "resumeUploadMediaTask", "Lcom/tencent/mobileqq/guild/feed/api/f;", "listener", "subscribeTaskChangeListener", "unsubscribeAllTaskChangeListener", "unsubscribeTaskChangeListener", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMediaUploadServiceApiImpl implements IGuildFeedMediaUploadServiceApi {
    public static final boolean FEED_MEDIA_UPLOAD_USE_SDK_DEFAULT_SWITCH = false;

    @NotNull
    public static final String TAG = "GuildFeedMediaUploadServiceApiImpl";
    private final /* synthetic */ IGuildFeedMediaUploadServiceApi $$delegate_0;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final com.tencent.mobileqq.guild.feed.feedsquare.utils.a<String, Boolean> useSdk$delegate = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a<>(GuildFeedMediaUploadServiceApiImpl$Companion$useSdk$2.INSTANCE, ComputedKt.a(), new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiImpl$Companion$useSdk$3
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Boolean invoke(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_new_upload_media_service", com.tencent.mobileqq.guild.feed.debug.j.b().a("guild_new_upload_media_service", false)));
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedMediaUploadServiceApiImpl$a;", "", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMediaUploadServiceApi;", "c", "()Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedMediaUploadServiceApi;", "_impl", "", "useSdk$delegate", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "b", "()Z", "useSdk", "FEED_MEDIA_UPLOAD_USE_SDK_DEFAULT_SWITCH", "Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f218035a = {Reflection.property1(new PropertyReference1Impl(Companion.class, "useSdk", "getUseSdk()Z", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IGuildFeedMediaUploadServiceApi c() {
            int i3 = 1;
            q qVar = null;
            byte b16 = 0;
            byte b17 = 0;
            byte b18 = 0;
            if (b()) {
                return new GuildFeedMediaUploadServiceApiSDKImpl(qVar, i3, b18 == true ? 1 : 0);
            }
            return new GuildFeedMediaUploadServiceApiWinkImpl(b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
        }

        public final boolean b() {
            return ((Boolean) GuildFeedMediaUploadServiceApiImpl.useSdk$delegate.getValue(this, f218035a[0])).booleanValue();
        }

        Companion() {
        }
    }

    public GuildFeedMediaUploadServiceApiImpl() {
        Companion companion = INSTANCE;
        this.$$delegate_0 = companion.c();
        QLog.i(TAG, 1, "GuildFeedMediaUploadServiceApiImpl init useSDKImpl=" + companion.b());
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    @NotNull
    public Map<String, com.tencent.mobileqq.guild.data.o> batchGetUploadMediaTaskInfoList(@NotNull Set<String> fileIdSet) {
        Intrinsics.checkNotNullParameter(fileIdSet, "fileIdSet");
        return this.$$delegate_0.batchGetUploadMediaTaskInfoList(fileIdSet);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean createUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g mediaInfo) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return this.$$delegate_0.createUploadMediaTask(fileId, mediaInfo);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime p06) {
        this.$$delegate_0.onCreate(p06);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.$$delegate_0.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean pauseUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return this.$$delegate_0.pauseUploadMediaTask(fileId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean removeUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return this.$$delegate_0.removeUploadMediaTask(fileId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean restoreUploadMediaTask(@NotNull String fileId, @NotNull com.tencent.mobileqq.guild.data.g localMediaInfo, @Nullable Object extraInfo) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        return this.$$delegate_0.restoreUploadMediaTask(fileId, localMediaInfo, extraInfo);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public boolean resumeUploadMediaTask(@NotNull String fileId) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return this.$$delegate_0.resumeUploadMediaTask(fileId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public void subscribeTaskChangeListener(@NotNull com.tencent.mobileqq.guild.feed.api.f listener, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.$$delegate_0.subscribeTaskChangeListener(listener, fileId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public void unsubscribeAllTaskChangeListener(@NotNull com.tencent.mobileqq.guild.feed.api.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.$$delegate_0.unsubscribeAllTaskChangeListener(listener);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedMediaUploadServiceApi
    public void unsubscribeTaskChangeListener(@NotNull com.tencent.mobileqq.guild.feed.api.f listener, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.$$delegate_0.unsubscribeTaskChangeListener(listener, fileId);
    }
}
