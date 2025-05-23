package com.tencent.mobileqq.guild.share.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.config.q;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.an;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.at;
import vp1.dr;
import vp1.ds;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J5\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ5\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020 H\u0002J\f\u0010$\u001a\u00020\n*\u00020#H\u0002J\u001d\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010%\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/GuildWXShareUtils;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/share/util/f;", "info", "", "p", "", "shareUrl", "", "businessType", "Lcom/tencent/mobileqq/guild/config/q;", DownloadInfo.spKey_Config, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/ey;", "o", "", "memberCount", QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "Landroid/graphics/Bitmap;", "k", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/share/util/f;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "i", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lvp1/dr;", "binding", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "imageUrl", "g", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/share/util/GuildWXShareUtils$a;", tl.h.F, "(Lcom/tencent/mobileqq/guild/share/util/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/v;", "l", DomainData.DOMAIN_NAME, "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildWXShareUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildWXShareUtils f235114a = new GuildWXShareUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/GuildWXShareUtils$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "shareUrl", "", "b", "J", "()J", "memberCount", QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "<init>", "(Ljava/lang/String;JJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.share.util.GuildWXShareUtils$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildShareUrlAndCountInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String shareUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long memberCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long feedCount;

        public GuildShareUrlAndCountInfo(@NotNull String shareUrl, long j3, long j16) {
            Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
            this.shareUrl = shareUrl;
            this.memberCount = j3;
            this.feedCount = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getFeedCount() {
            return this.feedCount;
        }

        /* renamed from: b, reason: from getter */
        public final long getMemberCount() {
            return this.memberCount;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getShareUrl() {
            return this.shareUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildShareUrlAndCountInfo)) {
                return false;
            }
            GuildShareUrlAndCountInfo guildShareUrlAndCountInfo = (GuildShareUrlAndCountInfo) other;
            if (Intrinsics.areEqual(this.shareUrl, guildShareUrlAndCountInfo.shareUrl) && this.memberCount == guildShareUrlAndCountInfo.memberCount && this.feedCount == guildShareUrlAndCountInfo.feedCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.shareUrl.hashCode() * 31) + androidx.fragment.app.a.a(this.memberCount)) * 31) + androidx.fragment.app.a.a(this.feedCount);
        }

        @NotNull
        public String toString() {
            return "GuildShareUrlAndCountInfo(shareUrl=" + this.shareUrl + ", memberCount=" + this.memberCount + ", feedCount=" + this.feedCount + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "(Landroid/graphics/Bitmap;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildLevelRoleView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Bitmap> f235118a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f235119b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Bitmap> continuation, String str) {
            this.f235118a = continuation;
            this.f235119b = str;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
        public final void a(@Nullable Bitmap bitmap) {
            if (bitmap == null) {
                Logger logger = Logger.f235387a;
                String str = this.f235119b;
                logger.d().w("Guild.share.GuildWXShareUtils", 1, "fetchBitmap fail " + str);
            }
            this.f235118a.resumeWith(Result.m476constructorimpl(bitmap));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J^\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/share/util/GuildWXShareUtils$c", "Lvh2/at;", "", "result", "", "errMsg", "shareUrl", "shareInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "shareExpiredTime", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProQRCodeShareInfo;", "qrCodeShareInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProShareExtendInfo;", "shareExtendInfo", "attaContendId", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements at {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<GuildShareUrlAndCountInfo> f235120a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super GuildShareUrlAndCountInfo> continuation) {
            this.f235120a = continuation;
        }

        @Override // vh2.at
        public void a(int result, @Nullable String errMsg, @Nullable String shareUrl, @Nullable String shareInfo, @Nullable IGProSecurityResult security, long shareExpiredTime, @Nullable IGProQRCodeShareInfo qrCodeShareInfo, @Nullable IGProShareExtendInfo shareExtendInfo, @Nullable String attaContendId) {
            boolean z16;
            long j3;
            if (result == 0) {
                if (shareUrl != null && shareUrl.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.share.GuildWXShareUtils", 1, "fetchLongShareUrl security:" + security + " shareUrl:" + shareUrl + " shareExtendInfo:" + shareExtendInfo);
                    }
                    Continuation<GuildShareUrlAndCountInfo> continuation = this.f235120a;
                    Result.Companion companion = Result.INSTANCE;
                    long j16 = 0;
                    if (shareExtendInfo != null) {
                        j3 = shareExtendInfo.getGuildMemberNum();
                    } else {
                        j3 = 0;
                    }
                    if (shareExtendInfo != null) {
                        j16 = shareExtendInfo.getFeedNum();
                    }
                    continuation.resumeWith(Result.m476constructorimpl(new GuildShareUrlAndCountInfo(shareUrl, j3, j16)));
                    return;
                }
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchLongShareUrl error, result:" + result + " errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.share.GuildWXShareUtils", 1, (String) it.next(), null);
            }
            Continuation<GuildShareUrlAndCountInfo> continuation2 = this.f235120a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(new GuildShareUrlAndCountInfo("", 0L, 0L)));
        }
    }

    GuildWXShareUtils() {
    }

    private final void f(Context context, IGProGuildInfo guildInfo, final dr binding) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) guildInfo.getGuildName());
        binding.f442983f.setText(spannableStringBuilder);
        binding.getRoot().measure(q(239.0f), q(191.0f));
        Logger logger = Logger.f235387a;
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildWXShareUtils", 1, "bindGuildName width:" + binding.f442983f.getMeasuredWidth() + " lineCount:" + binding.f442983f.getLineCount());
        }
        if (binding.f442983f.getLineCount() == 2) {
            binding.f442983f.setGravity(8388611);
        } else {
            binding.f442983f.setGravity(17);
        }
        ArrayList<IGProMedalInfo> medalInfoList = guildInfo.getMedalInfoList();
        Object obj = null;
        if (medalInfoList != null) {
            Iterator<T> it = medalInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((IGProMedalInfo) next).getOfficialMedalInfoExt().getIsOffical()) {
                    obj = next;
                    break;
                }
            }
            obj = (IGProMedalInfo) obj;
        }
        if (obj == null) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        an.Companion.f(an.INSTANCE, new WeakReference(binding.f442983f), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.share.util.GuildWXShareUtils$bindGuildName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                invoke(uRLDrawable, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull URLDrawable urlDrawable, int i3) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                h hVar = new h(urlDrawable);
                an.Companion companion = an.INSTANCE;
                hVar.b(companion.b(), 0);
                hVar.a(i3, companion.a());
                spannableStringBuilder.append((CharSequence) ":");
                spannableStringBuilder.setSpan(hVar, r4.length() - 1, spannableStringBuilder.length(), 33);
                binding.f442983f.setText(spannableStringBuilder);
            }
        }, 0, 4, null);
    }

    private final Object g(String str, Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildWXShareUtils", 1, "fetchBitmap imageUrl:" + str);
        }
        v.f(str, 0, 0, new b(safeContinuation, str));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(GuildShareToWXInfo guildShareToWXInfo, Continuation<? super GuildShareUrlAndCountInfo> continuation) {
        Continuation intercepted;
        String str;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        String str2 = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        String guildID = guildShareToWXInfo.getGuildInfo().getGuildID();
        IGProChannelInfo channelInfo = guildShareToWXInfo.getChannelInfo();
        String str3 = null;
        if (channelInfo != null) {
            str = channelInfo.getChannelUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "info.channelInfo?.channelUin ?: \"\"");
        }
        int businessType = guildShareToWXInfo.getBusinessType();
        ArrayList<ey> o16 = o();
        GuildWXShareUtils guildWXShareUtils = f235114a;
        IGProChannelInfo channelInfo2 = guildShareToWXInfo.getChannelInfo();
        if (channelInfo2 != null) {
            str3 = channelInfo2.getChannelUin();
        }
        if (str3 != null) {
            Intrinsics.checkNotNullExpressionValue(str3, "info.channelInfo?.channelUin ?: \"\"");
            str2 = str3;
        }
        iGPSService.fetchShareInfo(guildID, str, businessType, null, false, o16, guildWXShareUtils.l(str2), new c(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(Context context, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Continuation<? super Bitmap> continuation) {
        GuildWXShareUtils$generateGuildChannelShareBitmap$1 guildWXShareUtils$generateGuildChannelShareBitmap$1;
        Object coroutine_suspended;
        int i3;
        ds g16;
        GuildWXShareUtils guildWXShareUtils;
        Bitmap bitmap;
        if (continuation instanceof GuildWXShareUtils$generateGuildChannelShareBitmap$1) {
            guildWXShareUtils$generateGuildChannelShareBitmap$1 = (GuildWXShareUtils$generateGuildChannelShareBitmap$1) continuation;
            int i16 = guildWXShareUtils$generateGuildChannelShareBitmap$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildWXShareUtils$generateGuildChannelShareBitmap$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildWXShareUtils$generateGuildChannelShareBitmap$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildWXShareUtils$generateGuildChannelShareBitmap$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        g16 = (ds) guildWXShareUtils$generateGuildChannelShareBitmap$1.L$1;
                        guildWXShareUtils = (GuildWXShareUtils) guildWXShareUtils$generateGuildChannelShareBitmap$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    g16 = ds.g(LayoutInflater.from(context));
                    Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
                    g16.getRoot().setBackgroundColor(-1);
                    g16.f442988c.setText(iGProChannelInfo.getChannelName());
                    g16.getRoot().measure(q(239.0f), q(191.0f));
                    if (g16.f442988c.getLineCount() == 2) {
                        g16.getRoot().setPadding(0, bi.b(10), 0, bi.b(7));
                    } else {
                        g16.getRoot().setPadding(0, bi.b(20), 0, bi.b(17));
                    }
                    g16.f442987b.setImageResource(GuildChannelIconUtil.j(iGProChannelInfo.getType(), iGProChannelInfo.getTextChannelSubtypeId(), 0, 4, null));
                    g16.f442990e.setText("\u53bb\u770b\u770b");
                    String avatarUrl = iGProGuildInfo.getAvatarUrl(100);
                    Intrinsics.checkNotNullExpressionValue(avatarUrl, "avatarUrl");
                    guildWXShareUtils$generateGuildChannelShareBitmap$1.L$0 = this;
                    guildWXShareUtils$generateGuildChannelShareBitmap$1.L$1 = g16;
                    guildWXShareUtils$generateGuildChannelShareBitmap$1.label = 1;
                    obj = g(avatarUrl, guildWXShareUtils$generateGuildChannelShareBitmap$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildWXShareUtils = this;
                }
                bitmap = (Bitmap) obj;
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.share.GuildWXShareUtils", 1, "getGuildHomeShareBitmap avatarBitmap:" + bitmap);
                }
                if (bitmap != null) {
                    return null;
                }
                g16.f442989d.setImageBitmap(bitmap);
                g16.getRoot().measure(guildWXShareUtils.q(239.0f), guildWXShareUtils.q(191.0f));
                g16.getRoot().layout(0, 0, g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
                Bitmap createBitmap = Bitmap.createBitmap(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                g16.getRoot().draw(new Canvas(createBitmap));
                return createBitmap;
            }
        }
        guildWXShareUtils$generateGuildChannelShareBitmap$1 = new GuildWXShareUtils$generateGuildChannelShareBitmap$1(this, continuation);
        Object obj2 = guildWXShareUtils$generateGuildChannelShareBitmap$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildWXShareUtils$generateGuildChannelShareBitmap$1.label;
        if (i3 == 0) {
        }
        bitmap = (Bitmap) obj2;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
        }
        if (bitmap != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0130 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(Context context, IGProGuildInfo iGProGuildInfo, long j3, long j16, Continuation<? super Bitmap> continuation) {
        GuildWXShareUtils$generateGuildHomeShareBitmap$1 guildWXShareUtils$generateGuildHomeShareBitmap$1;
        Object coroutine_suspended;
        int i3;
        int i16;
        GuildWXShareUtils guildWXShareUtils;
        dr drVar;
        Bitmap bitmap;
        if (continuation instanceof GuildWXShareUtils$generateGuildHomeShareBitmap$1) {
            guildWXShareUtils$generateGuildHomeShareBitmap$1 = (GuildWXShareUtils$generateGuildHomeShareBitmap$1) continuation;
            int i17 = guildWXShareUtils$generateGuildHomeShareBitmap$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                guildWXShareUtils$generateGuildHomeShareBitmap$1.label = i17 - Integer.MIN_VALUE;
                Object obj = guildWXShareUtils$generateGuildHomeShareBitmap$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildWXShareUtils$generateGuildHomeShareBitmap$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        drVar = (dr) guildWXShareUtils$generateGuildHomeShareBitmap$1.L$1;
                        guildWXShareUtils = (GuildWXShareUtils) guildWXShareUtils$generateGuildHomeShareBitmap$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    dr g16 = dr.g(LayoutInflater.from(context));
                    Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
                    g16.getRoot().setBackgroundColor(-1);
                    f(context, iGProGuildInfo, g16);
                    g16.f442980c.setBackgroundColor(Color.parseColor("#5E5F62"));
                    TextView textView = g16.f442985h;
                    cp1.c cVar = cp1.c.f391536a;
                    textView.setText(cVar.a((int) j3, "\u6210\u5458"));
                    g16.f442981d.setText(cVar.a((int) j16, "\u5e16\u5b50"));
                    g16.f442984g.setText("\u52a0\u5165\u9891\u9053");
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        i16 = 1;
                        logger.d().d("Guild.share.GuildWXShareUtils", 1, "getGuildHomeShareBitmap gId:" + iGProGuildInfo.getGuildID() + " memberCount:" + j3 + " " + ((Object) g16.f442985h.getText()) + " feedCount:" + j16 + " " + ((Object) g16.f442981d.getText()));
                    } else {
                        i16 = 1;
                    }
                    String avatarUrl = iGProGuildInfo.getAvatarUrl(100);
                    Intrinsics.checkNotNullExpressionValue(avatarUrl, "avatarUrl");
                    guildWXShareUtils$generateGuildHomeShareBitmap$1.L$0 = this;
                    guildWXShareUtils$generateGuildHomeShareBitmap$1.L$1 = g16;
                    guildWXShareUtils$generateGuildHomeShareBitmap$1.label = i16;
                    Object g17 = g(avatarUrl, guildWXShareUtils$generateGuildHomeShareBitmap$1);
                    if (g17 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildWXShareUtils = this;
                    obj = g17;
                    drVar = g16;
                }
                bitmap = (Bitmap) obj;
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("Guild.share.GuildWXShareUtils", 1, "getGuildHomeShareBitmap avatarBitmap:" + bitmap);
                }
                if (bitmap != null) {
                    return null;
                }
                drVar.f442982e.setImageBitmap(bitmap);
                drVar.getRoot().measure(guildWXShareUtils.q(239.0f), guildWXShareUtils.q(191.0f));
                if (QLog.isColorLevel()) {
                    logger2.d().d("Guild.share.GuildWXShareUtils", 1, "binding.guildName.lineCount " + drVar.f442983f.getLineCount());
                }
                if (drVar.f442983f.getLineCount() == 2) {
                    LinearLayout linearLayout = drVar.f442979b;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.countContainer");
                    linearLayout.setVisibility(8);
                }
                drVar.getRoot().measure(guildWXShareUtils.q(239.0f), guildWXShareUtils.q(191.0f));
                drVar.getRoot().layout(0, 0, drVar.getRoot().getMeasuredWidth(), drVar.getRoot().getMeasuredHeight());
                Bitmap createBitmap = Bitmap.createBitmap(drVar.getRoot().getMeasuredWidth(), drVar.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                drVar.getRoot().draw(new Canvas(createBitmap));
                return createBitmap;
            }
        }
        guildWXShareUtils$generateGuildHomeShareBitmap$1 = new GuildWXShareUtils$generateGuildHomeShareBitmap$1(this, continuation);
        Object obj2 = guildWXShareUtils$generateGuildHomeShareBitmap$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildWXShareUtils$generateGuildHomeShareBitmap$1.label;
        if (i3 == 0) {
        }
        bitmap = (Bitmap) obj2;
        Logger logger22 = Logger.f235387a;
        if (QLog.isColorLevel()) {
        }
        if (bitmap != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(Context context, GuildShareToWXInfo guildShareToWXInfo, long j3, long j16, Continuation<? super Bitmap> continuation) {
        if (guildShareToWXInfo.getChannelInfo() == null) {
            return j(context, guildShareToWXInfo.getGuildInfo(), j3, j16, continuation);
        }
        return i(context, guildShareToWXInfo.getGuildInfo(), guildShareToWXInfo.getChannelInfo(), continuation);
    }

    private final com.tencent.mobileqq.qqguildsdk.data.genc.v l(String channelId) {
        com.tencent.mobileqq.qqguildsdk.data.genc.v vVar = new com.tencent.mobileqq.qqguildsdk.data.genc.v();
        if (MiscKt.f(channelId)) {
            vVar.e(1);
        }
        return vVar;
    }

    @JvmStatic
    @NotNull
    public static final String m(@NotNull String shareUrl, int businessType, @NotNull q config) {
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(config, "config");
        Uri parse = Uri.parse(shareUrl);
        String queryParameter = parse.getQueryParameter("inviteCode");
        if (TextUtils.isEmpty(queryParameter)) {
            return "";
        }
        if (businessType != 2) {
            if (businessType != 7) {
                if (businessType != 9) {
                    if (businessType != 10) {
                        return "";
                    }
                    return config.getPathGuildFeedChannel() + "?fromSource=13&inviteCode=" + queryParameter;
                }
                return config.getPathGuildHome() + "?fromSource=13&inviteCode=" + queryParameter;
            }
            return config.getPathGuildTextChannel() + "?fromSource=13&type=chatroom&inviteCode=" + queryParameter;
        }
        String encode = URLEncoder.encode(queryParameter + ContainerUtils.FIELD_DELIMITER + parse.getQueryParameter("contentID"), "UTF-8");
        return config.getPathGuildFeedDetail() + "?fromSource=13&scene=" + encode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n(GuildShareToWXInfo info) {
        int businessType = info.getBusinessType();
        if (businessType != 7) {
            if (businessType != 9) {
                return info.getDefaultTitle();
            }
            String s16 = QQGuildUIUtil.s(R.string.f156521kf, info.getGuildInfo().getGuildName());
            Intrinsics.checkNotNullExpressionValue(s16, "getString(\n             \u2026o.guildName\n            )");
            return s16;
        }
        String s17 = QQGuildUIUtil.s(R.string.f156581kl, info.getGuildInfo().getGuildName());
        Intrinsics.checkNotNullExpressionValue(s17, "getString(\n             \u2026o.guildName\n            )");
        return s17;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<ey> o() {
        ArrayList arrayList = new ArrayList();
        ey eyVar = new ey();
        ey eyVar2 = new ey();
        eyVar.c("mainSourceId");
        eyVar.d("wechat_connect");
        eyVar2.c("subSourceId");
        eyVar2.d("qq_share");
        arrayList.add(eyVar);
        arrayList.add(eyVar2);
        return new ArrayList<>(arrayList);
    }

    @JvmStatic
    public static final void p(@NotNull Context context, @NotNull GuildShareToWXInfo info) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        String str2 = null;
        if (!m02.d.i()) {
            Logger.a d16 = Logger.f235387a.d();
            String guildID = info.getGuildInfo().getGuildID();
            IGProChannelInfo channelInfo = info.getChannelInfo();
            if (channelInfo != null) {
                str2 = channelInfo.getChannelUin();
            }
            d16.w("Guild.share.GuildWXShareUtils", 1, "NotSupportWX gId:" + guildID + " cId:" + str2);
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f156731l0));
            return;
        }
        Logger.a d17 = Logger.f235387a.d();
        String guildID2 = info.getGuildInfo().getGuildID();
        IGProChannelInfo channelInfo2 = info.getChannelInfo();
        if (channelInfo2 != null) {
            str = channelInfo2.getChannelUin();
        } else {
            str = null;
        }
        d17.d("Guild.share.GuildWXShareUtils", 1, "startShare gId:" + guildID2 + " cId:" + str);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.share.GuildWXShareUtils startShare", null, null, null, new GuildWXShareUtils$startShare$3(info, context, null), 14, null);
        }
    }

    private final int q(float f16) {
        return View.MeasureSpec.makeMeasureSpec(bi.a(f16), 1073741824);
    }
}
