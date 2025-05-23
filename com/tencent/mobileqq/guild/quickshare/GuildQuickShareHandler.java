package com.tencent.mobileqq.guild.quickshare;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.share.FetchGuildArkInfo;
import com.tencent.mobileqq.guild.share.w;
import com.tencent.mobileqq.guild.share.y;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0015\u0019B!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010C\u001a\u00020 \u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010;R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler;", "", "", "j", "com/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$c", "i", "()Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$c;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "l", "Lri1/a;", "error", "Landroid/content/Context;", "context", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$b;", "shareCallback", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "c", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "source", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "d", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "recentUser", "Lmqq/util/WeakReference;", "e", "Lmqq/util/WeakReference;", "activityRef", "Lcom/tencent/mobileqq/guild/usecases/b$b;", "f", "Lcom/tencent/mobileqq/guild/usecases/b$b;", "mShareInfoHandler", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "g", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "mShareUrlInfo", "", h.F, "Z", "mShareInfoFetched", "Lcom/tencent/mobileqq/guild/share/w;", "Lcom/tencent/mobileqq/guild/share/w;", "mExecutor", "", "Ljava/lang/String;", "mCreatorName", "Lcom/tencent/mobileqq/guild/share/FetchGuildArkInfo;", "Lcom/tencent/mobileqq/guild/share/FetchGuildArkInfo;", "mFetchArk", "shareCallbackRef", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "shareTask", "Lcom/tencent/mobileqq/guild/quickshare/ShareParam;", "sharedParam", QCircleAlphaUserReporter.KEY_USER, "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/guild/quickshare/ShareParam;Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildQuickShareHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProGuildInfo guildInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo channelInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSharePageSource source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildRecentUser recentUser;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Activity> activityRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b.InterfaceC7909b mShareInfoHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b.c mShareUrlInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mShareInfoFetched;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private w mExecutor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCreatorName;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FetchGuildArkInfo mFetchArk;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<b> shareCallbackRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b shareTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$b;", "", "", "isOpenShareConfirmSuccess", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void onResult(boolean isOpenShareConfirmSuccess);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$c", "Lcom/tencent/mobileqq/guild/usecases/b$b;", "Lri1/a;", "error", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "info", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements b.InterfaceC7909b {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.usecases.b.InterfaceC7909b
        public void a(@NotNull ri1.a error, @Nullable b.c info) {
            b bVar;
            Intrinsics.checkNotNullParameter(error, "error");
            Activity activity = (Activity) GuildQuickShareHandler.this.activityRef.get();
            if (activity == null) {
                return;
            }
            int i3 = error.f431477a;
            if (i3 == -200) {
                GuildQuickShareHandler.this.k(error, activity);
                WeakReference weakReference = GuildQuickShareHandler.this.shareCallbackRef;
                if (weakReference != null && (bVar = (b) weakReference.get()) != null) {
                    bVar.onResult(false);
                    return;
                }
                return;
            }
            if (i3 == 0 && info != null) {
                GuildQuickShareHandler.this.mShareUrlInfo = info;
                GuildQuickShareHandler.this.mShareInfoFetched = true;
                GuildQuickShareHandler.this.o();
            }
        }
    }

    public GuildQuickShareHandler(@NotNull Activity activity, @NotNull ShareParam sharedParam, @NotNull GuildRecentUser user) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sharedParam, "sharedParam");
        Intrinsics.checkNotNullParameter(user, "user");
        this.mShareInfoHandler = i();
        this.mShareUrlInfo = new b.c("", "");
        this.activityRef = new WeakReference<>(activity);
        IGProGuildInfo guildInfo = sharedParam.getGuildInfo();
        this.guildInfo = guildInfo;
        IGProChannelInfo channelInfo = sharedParam.getChannelInfo();
        this.channelInfo = channelInfo;
        this.recentUser = user;
        GuildSharePageSource source = sharedParam.getSource();
        this.source = source;
        String guildUserDisplayName = ((IGPSService) ch.S0(IGPSService.class, "")).getGuildUserDisplayName(guildInfo.getGuildID(), guildInfo.getCreatorId());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "runtimeService(IGPSServi\u2026dID, guildInfo.creatorId)");
        this.mCreatorName = guildUserDisplayName;
        this.mFetchArk = new FetchGuildArkInfo(guildInfo, channelInfo, com.tencent.mobileqq.guild.share.shorturl.b.a(source));
    }

    private final c i() {
        return new c();
    }

    private final void j() {
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.shareTask;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = null;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
            Logger logger = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("cancel the previous show");
            Iterator<T> it = bVar3.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.share.GuildQuickShare.handler", 1, (String) it.next(), null);
            }
        }
        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f17 != null) {
            bVar2 = CorountineFunKt.e(f17, "Guild.share.GuildQuickShare.handlershare panel", null, null, Boolean.TRUE, new GuildQuickShareHandler$fetchArkInfo$2(this, null), 6, null);
        }
        this.shareTask = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(ri1.a error, Context context) {
        Object obj = error.f431479c;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult");
        IGProSecurityResult iGProSecurityResult = (IGProSecurityResult) obj;
        if (iGProSecurityResult.get$actionCode() == 102) {
            try {
                cx.a(context, new JSONObject(iGProSecurityResult.getStrDetail()).optString("verify_url"));
                return;
            } catch (Exception e16) {
                QLog.e("Guild.share.GuildShareAction", 1, e16, new Object[0]);
                return;
            }
        }
        QQToast.makeText(context, 1, iGProSecurityResult.getStrPrompt(), 1).show();
    }

    private final void l(Activity activity) {
        if (this.mExecutor != null) {
            return;
        }
        this.mExecutor = new w(activity, new y(this.guildInfo, this.channelInfo, this.mShareUrlInfo), this.source);
    }

    private final void m(Activity activity) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
        }
    }

    public final void n(@Nullable b shareCallback) {
        if (shareCallback != null) {
            this.shareCallbackRef = new WeakReference<>(shareCallback);
        }
    }

    public final void o() {
        b bVar;
        if (TextUtils.isEmpty(this.mShareUrlInfo.f235319a) && !this.mShareInfoFetched) {
            com.tencent.mobileqq.guild.usecases.b.g(this.guildInfo, this.channelInfo, 0, this.mShareInfoHandler);
            return;
        }
        Activity activity = this.activityRef.get();
        if (activity == null) {
            QLog.e("Guild.share.GuildShareAction", 1, "showActionSheet(), context null");
            WeakReference<b> weakReference = this.shareCallbackRef;
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.onResult(false);
                return;
            }
            return;
        }
        this.mFetchArk.h(this.source, this.mShareUrlInfo);
        l(activity);
        m(activity);
        j();
    }
}
