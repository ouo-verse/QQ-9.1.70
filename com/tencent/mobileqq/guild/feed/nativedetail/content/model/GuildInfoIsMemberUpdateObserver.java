package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import com.tencent.mobileqq.guild.feed.nativedetail.content.model.GuildInfoIsMemberUpdateObserver;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n*\u0001\u0002\u0018\u0000 &2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010\u000b\u001a\u00020\bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/GuildInfoIsMemberUpdateObserver;", "", "com/tencent/mobileqq/guild/feed/nativedetail/content/model/GuildInfoIsMemberUpdateObserver$b", "k", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/GuildInfoIsMemberUpdateObserver$b;", "", "guildId", "Lkotlin/Function0;", "", "block", "l", "i", "a", "Lkotlin/jvm/functions/Function0;", "notifyListener", "b", "Ljava/lang/String;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/GuildInfoIsMemberUpdateObserver$b;", "gpsObserver", "Lcom/tencent/mobileqq/guild/base/a;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "e", "Lcom/tencent/mobileqq/guild/base/a;", "serviceHolder", "", "f", "Ljava/lang/Boolean;", "isMember", "j", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "<init>", "()V", "g", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInfoIsMemberUpdateObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> notifyListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isMember;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gpsObserver = k();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.a<IGPSService> serviceHolder = new GuildInfoIsMemberUpdateObserver$special$$inlined$newAccountAwareServiceHolder$1(new Function1<IGPSService, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.GuildInfoIsMemberUpdateObserver$serviceHolder$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IGPSService iGPSService) {
            invoke2(iGPSService);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IGPSService newAccountAwareServiceHolder) {
            GuildInfoIsMemberUpdateObserver.b bVar;
            Intrinsics.checkNotNullParameter(newAccountAwareServiceHolder, "$this$newAccountAwareServiceHolder");
            bVar = GuildInfoIsMemberUpdateObserver.this.gpsObserver;
            newAccountAwareServiceHolder.addObserver(bVar);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildInfoUpdateObserver", 2, "onCreate " + newAccountAwareServiceHolder);
            }
        }
    }, new Function1<IGPSService, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.GuildInfoIsMemberUpdateObserver$serviceHolder$3
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IGPSService iGPSService) {
            invoke2(iGPSService);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IGPSService newAccountAwareServiceHolder) {
            GuildInfoIsMemberUpdateObserver.b bVar;
            Intrinsics.checkNotNullParameter(newAccountAwareServiceHolder, "$this$newAccountAwareServiceHolder");
            bVar = GuildInfoIsMemberUpdateObserver.this.gpsObserver;
            newAccountAwareServiceHolder.deleteObserver(bVar);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildInfoUpdateObserver", 2, "onDestroy " + newAccountAwareServiceHolder);
            }
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/model/GuildInfoIsMemberUpdateObserver$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "onGuildListUpdated", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(guildId, GuildInfoIsMemberUpdateObserver.this.guildId)) {
                GuildInfoIsMemberUpdateObserver guildInfoIsMemberUpdateObserver = GuildInfoIsMemberUpdateObserver.this;
                IGProGuildInfo guildInfo = guildInfoIsMemberUpdateObserver.j().getGuildInfo(guildId);
                if (guildInfo != null) {
                    guildInfoIsMemberUpdateObserver.guildInfo = guildInfo;
                    IGProGuildInfo iGProGuildInfo = GuildInfoIsMemberUpdateObserver.this.guildInfo;
                    if (iGProGuildInfo != null) {
                        GuildInfoIsMemberUpdateObserver guildInfoIsMemberUpdateObserver2 = GuildInfoIsMemberUpdateObserver.this;
                        Logger.f235387a.d().i("GuildInfoUpdateObserver", 1, "onGuildInfoUpdated " + iGProGuildInfo.getGuildID() + "(" + ay.a(iGProGuildInfo.getGuildName()) + "), this.isMember=" + guildInfoIsMemberUpdateObserver2.isMember + ", it.isMember=" + iGProGuildInfo.isMember());
                        if (!Intrinsics.areEqual(guildInfoIsMemberUpdateObserver2.isMember, Boolean.valueOf(iGProGuildInfo.isMember()))) {
                            guildInfoIsMemberUpdateObserver2.isMember = Boolean.valueOf(iGProGuildInfo.isMember());
                            Function0 function0 = guildInfoIsMemberUpdateObserver2.notifyListener;
                            if (function0 != null) {
                                function0.invoke();
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            GuildInfoIsMemberUpdateObserver guildInfoIsMemberUpdateObserver = GuildInfoIsMemberUpdateObserver.this;
            IGProGuildInfo guildInfo = guildInfoIsMemberUpdateObserver.j().getGuildInfo(GuildInfoIsMemberUpdateObserver.this.guildId);
            if (guildInfo != null) {
                guildInfoIsMemberUpdateObserver.guildInfo = guildInfo;
                IGProGuildInfo iGProGuildInfo = GuildInfoIsMemberUpdateObserver.this.guildInfo;
                if (iGProGuildInfo != null) {
                    GuildInfoIsMemberUpdateObserver guildInfoIsMemberUpdateObserver2 = GuildInfoIsMemberUpdateObserver.this;
                    Logger.f235387a.d().i("GuildInfoUpdateObserver", 1, "onGuildListUpdated " + iGProGuildInfo.getGuildID() + "(" + ay.a(iGProGuildInfo.getGuildName()) + "), isMember=" + iGProGuildInfo.isMember());
                    if (!Intrinsics.areEqual(guildInfoIsMemberUpdateObserver2.isMember, Boolean.valueOf(iGProGuildInfo.isMember()))) {
                        guildInfoIsMemberUpdateObserver2.isMember = Boolean.valueOf(iGProGuildInfo.isMember());
                        Function0 function0 = guildInfoIsMemberUpdateObserver2.notifyListener;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService j() {
        return this.serviceHolder.getValue();
    }

    private final b k() {
        return new b();
    }

    public final void i() {
        this.notifyListener = null;
        this.guildId = "";
        this.guildInfo = null;
        this.isMember = null;
        this.serviceHolder.destroy();
    }

    public final void l(@NotNull String guildId, @NotNull Function0<Unit> block) {
        Boolean bool;
        String str;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(block, "block");
        this.notifyListener = block;
        if (Intrinsics.areEqual(this.guildId, guildId)) {
            return;
        }
        this.guildId = guildId;
        IGProGuildInfo guildInfo = j().getGuildInfo(guildId);
        this.guildInfo = guildInfo;
        Boolean bool2 = null;
        if (guildInfo != null) {
            bool = Boolean.valueOf(guildInfo.isMember());
        } else {
            bool = null;
        }
        this.isMember = bool;
        Logger.a d16 = Logger.f235387a.d();
        IGProGuildInfo iGProGuildInfo = this.guildInfo;
        if (iGProGuildInfo != null) {
            str = iGProGuildInfo.getGuildName();
        } else {
            str = null;
        }
        String a16 = ay.a(str);
        IGProGuildInfo iGProGuildInfo2 = this.guildInfo;
        if (iGProGuildInfo2 != null) {
            bool2 = Boolean.valueOf(iGProGuildInfo2.isMember());
        }
        d16.i("GuildInfoUpdateObserver", 1, "updateGuildId " + guildId + "(" + a16 + "), isMember=" + bool2);
    }
}
