package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.share.util.GuildWXShareUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.channel_share.ChannelShareRequest$FeedParam;
import vh2.at;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J1\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\f\u0010\u001f\u001a\u00020\u0007*\u00020\u001eH\u0002J\u001d\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010+\u001a\u0004\u0018\u00010**\u00020(2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0016\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u00102\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/GuildFeedShareToWXHelper;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/v;", "info", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", DomainData.DOMAIN_NAME, "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/feed/morepanel/handler/v;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "imageUrl", "imageWith", "imageHeight", "", BaseProfileQZoneComponent.KEY_IS_VIDEO, "k", "(Landroid/content/Context;Ljava/lang/String;IIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "width", "height", "url", "g", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/text/SpannableStringBuilder;", "textContents", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/content/Context;Landroid/text/SpannableStringBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "r", tl.h.F, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/widget/ImageView;", "imageView", "p", "(Ljava/lang/String;Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "(Lcom/tencent/mobileqq/guild/feed/morepanel/handler/v;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "urlContentType", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "j", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "Lkotlin/Lazy;", "o", "()I", "SMALL_IMAGE_SIZE_DP", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedShareToWXHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedShareToWXHelper f220290a = new GuildFeedShareToWXHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy SMALL_IMAGE_SIZE_DP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "(Landroid/graphics/Bitmap;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildLevelRoleView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Bitmap> f220292a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f220293b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Bitmap> continuation, String str) {
            this.f220292a = continuation;
            this.f220293b = str;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
        public final void a(@Nullable Bitmap bitmap) {
            if (bitmap == null) {
                Logger logger = Logger.f235387a;
                String str = this.f220293b;
                logger.d().w("Guild.share.GuildFeedShareToWXHelper", 1, "fetchBitmap fail " + str);
            }
            this.f220292a.resumeWith(Result.m476constructorimpl(bitmap));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J^\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/GuildFeedShareToWXHelper$b", "Lvh2/at;", "", "result", "", "errMsg", "shareUrl", "shareInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "shareExpiredTime", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProQRCodeShareInfo;", "qrCodeShareInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProShareExtendInfo;", "shareExtendInfo", "attaContendId", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements at {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f220294a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super String> continuation) {
            this.f220294a = continuation;
        }

        @Override // vh2.at
        public void a(int result, @Nullable String errMsg, @Nullable String shareUrl, @Nullable String shareInfo, @Nullable IGProSecurityResult security, long shareExpiredTime, @Nullable IGProQRCodeShareInfo qrCodeShareInfo, @Nullable IGProShareExtendInfo shareExtendInfo, @Nullable String attaContendId) {
            boolean z16;
            if (result == 0) {
                if (shareUrl != null && shareUrl.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "fetchLongShareUrl security:" + security + " shareUrl:" + shareUrl + " shareExtendInfo:" + shareExtendInfo);
                    }
                    this.f220294a.resumeWith(Result.m476constructorimpl(shareUrl));
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
                Logger.f235387a.d().e("Guild.share.GuildFeedShareToWXHelper", 1, (String) it.next(), null);
            }
            this.f220294a.resumeWith(Result.m476constructorimpl(""));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/GuildFeedShareToWXHelper$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f220295e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Boolean> continuation) {
            super(false);
            this.f220295e = continuation;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            Logger logger = Logger.f235387a;
            boolean z16 = true;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "fetchBitmap onStateChangeCallback state:" + state);
            }
            if (state == LoadState.STATE_SUCCESS) {
                Continuation<Boolean> continuation = this.f220295e;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            if (state == null || !state.isFinishError()) {
                z16 = false;
            }
            if (z16) {
                Continuation<Boolean> continuation2 = this.f220295e;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedShareToWXHelper$SMALL_IMAGE_SIZE_DP$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(bi.b(128));
            }
        });
        SMALL_IMAGE_SIZE_DP = lazy;
    }

    GuildFeedShareToWXHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(int i3, int i16, String str, Continuation<? super Boolean> continuation) {
        GuildFeedShareToWXHelper$checkSmallImage$1 guildFeedShareToWXHelper$checkSmallImage$1;
        Object coroutine_suspended;
        int i17;
        Bitmap bitmap;
        if (continuation instanceof GuildFeedShareToWXHelper$checkSmallImage$1) {
            guildFeedShareToWXHelper$checkSmallImage$1 = (GuildFeedShareToWXHelper$checkSmallImage$1) continuation;
            int i18 = guildFeedShareToWXHelper$checkSmallImage$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                guildFeedShareToWXHelper$checkSmallImage$1.label = i18 - Integer.MIN_VALUE;
                Object obj = guildFeedShareToWXHelper$checkSmallImage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = guildFeedShareToWXHelper$checkSmallImage$1.label;
                boolean z16 = false;
                if (i17 == 0) {
                    if (i17 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (i3 > 0 && i16 > 0) {
                        if (i3 < 134 || i16 < 134) {
                            z16 = true;
                        }
                        return Boxing.boxBoolean(z16);
                    }
                    guildFeedShareToWXHelper$checkSmallImage$1.label = 1;
                    obj = h(str, guildFeedShareToWXHelper$checkSmallImage$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    return Boxing.boxBoolean(false);
                }
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "checkSmallImage bitmapSize:" + bitmap.getWidth() + " " + bitmap.getHeight());
                }
                if ((bitmap.getWidth() > 0 && bitmap.getWidth() < 134) || (bitmap.getHeight() > 0 && bitmap.getHeight() < 134)) {
                    z16 = true;
                }
                return Boxing.boxBoolean(z16);
            }
        }
        guildFeedShareToWXHelper$checkSmallImage$1 = new GuildFeedShareToWXHelper$checkSmallImage$1(this, continuation);
        Object obj2 = guildFeedShareToWXHelper$checkSmallImage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = guildFeedShareToWXHelper$checkSmallImage$1.label;
        boolean z162 = false;
        if (i17 == 0) {
        }
        bitmap = (Bitmap) obj2;
        if (bitmap != null) {
        }
    }

    private final Object h(String str, Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "fetchBitmap imageUrl:" + str);
        }
        com.tencent.mobileqq.guild.util.v.f(str, 0, 0, new a(safeContinuation, str));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(GuildFeedShareToWXInfo guildFeedShareToWXInfo, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ChannelShareRequest$FeedParam channelShareRequest$FeedParam = new ChannelShareRequest$FeedParam();
        channelShareRequest$FeedParam.feed_id.set(guildFeedShareToWXInfo.getFeedId());
        channelShareRequest$FeedParam.create_time.set(guildFeedShareToWXInfo.getCreateTime());
        channelShareRequest$FeedParam.poster_tiny_id.set(MiscKt.l(guildFeedShareToWXInfo.getPosterId()));
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchShareInfo(String.valueOf(guildFeedShareToWXInfo.getGuildId()), String.valueOf(guildFeedShareToWXInfo.getChannelId()), 2, channelShareRequest$FeedParam.toByteArray(), false, GuildWXShareUtils.o(), new com.tencent.mobileqq.qqguildsdk.data.genc.v(), new b(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final GProStRichTextContent j(GProStFeed gProStFeed, int i3) {
        Object obj;
        boolean z16;
        ArrayList<GProStRichTextContent> arrayList = gProStFeed.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "contents.contents");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                GProStRichTextContent gProStRichTextContent = (GProStRichTextContent) obj;
                if (gProStRichTextContent.type == 3 && gProStRichTextContent.urlContent.type == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (GProStRichTextContent) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(Context context, String str, int i3, int i16, boolean z16, Continuation<? super Bitmap> continuation) {
        GuildFeedShareToWXHelper$generateBitmapForImage$1 guildFeedShareToWXHelper$generateBitmapForImage$1;
        Object obj;
        Object coroutine_suspended;
        int i17;
        x12.m g16;
        String str2;
        GuildFeedShareToWXHelper guildFeedShareToWXHelper;
        int i18;
        ImageView imageView;
        if (continuation instanceof GuildFeedShareToWXHelper$generateBitmapForImage$1) {
            guildFeedShareToWXHelper$generateBitmapForImage$1 = (GuildFeedShareToWXHelper$generateBitmapForImage$1) continuation;
            int i19 = guildFeedShareToWXHelper$generateBitmapForImage$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                guildFeedShareToWXHelper$generateBitmapForImage$1.label = i19 - Integer.MIN_VALUE;
                obj = guildFeedShareToWXHelper$generateBitmapForImage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = guildFeedShareToWXHelper$generateBitmapForImage$1.label;
                if (i17 == 0) {
                    if (i17 != 1) {
                        if (i17 == 2) {
                            g16 = (x12.m) guildFeedShareToWXHelper$generateBitmapForImage$1.L$1;
                            guildFeedShareToWXHelper = (GuildFeedShareToWXHelper) guildFeedShareToWXHelper$generateBitmapForImage$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            g16.getRoot().measure(guildFeedShareToWXHelper.r(239.0f), guildFeedShareToWXHelper.r(191.0f));
                            g16.getRoot().layout(0, 0, g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
                            Bitmap createBitmap = Bitmap.createBitmap(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                            g16.getRoot().draw(new Canvas(createBitmap));
                            return createBitmap;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z16 = guildFeedShareToWXHelper$generateBitmapForImage$1.Z$0;
                    g16 = (x12.m) guildFeedShareToWXHelper$generateBitmapForImage$1.L$2;
                    String str3 = (String) guildFeedShareToWXHelper$generateBitmapForImage$1.L$1;
                    GuildFeedShareToWXHelper guildFeedShareToWXHelper2 = (GuildFeedShareToWXHelper) guildFeedShareToWXHelper$generateBitmapForImage$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str3;
                    guildFeedShareToWXHelper = guildFeedShareToWXHelper2;
                } else {
                    ResultKt.throwOnFailure(obj);
                    Logger.f235387a.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "generateBitmapForImage imageUrl:" + str + " size:" + i3 + " " + i16 + " isVideo:" + z16);
                    g16 = x12.m.g(LayoutInflater.from(context));
                    Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
                    guildFeedShareToWXHelper$generateBitmapForImage$1.L$0 = this;
                    guildFeedShareToWXHelper$generateBitmapForImage$1.L$1 = str;
                    guildFeedShareToWXHelper$generateBitmapForImage$1.L$2 = g16;
                    guildFeedShareToWXHelper$generateBitmapForImage$1.Z$0 = z16;
                    guildFeedShareToWXHelper$generateBitmapForImage$1.label = 1;
                    obj = g(i3, i16, str, guildFeedShareToWXHelper$generateBitmapForImage$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = str;
                    guildFeedShareToWXHelper = this;
                }
                if (((Boolean) obj).booleanValue()) {
                    g16.getRoot().setBackgroundColor(Color.parseColor("#F5F5F5"));
                    g16.f446960b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ViewGroup.LayoutParams layoutParams = g16.f446960b.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    GuildFeedShareToWXHelper guildFeedShareToWXHelper3 = f220290a;
                    layoutParams.width = guildFeedShareToWXHelper3.o();
                    layoutParams.height = guildFeedShareToWXHelper3.o();
                }
                ImageView imageView2 = g16.f446961c;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.playVideo");
                if (!z16) {
                    i18 = 0;
                } else {
                    i18 = 8;
                }
                imageView2.setVisibility(i18);
                if (z16) {
                    g16.f446961c.setImageResource(R.drawable.guild_feed_share_to_wx_play_video);
                }
                imageView = g16.f446960b;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageContent");
                guildFeedShareToWXHelper$generateBitmapForImage$1.L$0 = guildFeedShareToWXHelper;
                guildFeedShareToWXHelper$generateBitmapForImage$1.L$1 = g16;
                guildFeedShareToWXHelper$generateBitmapForImage$1.L$2 = null;
                guildFeedShareToWXHelper$generateBitmapForImage$1.label = 2;
                if (guildFeedShareToWXHelper.p(str2, imageView, guildFeedShareToWXHelper$generateBitmapForImage$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                g16.getRoot().measure(guildFeedShareToWXHelper.r(239.0f), guildFeedShareToWXHelper.r(191.0f));
                g16.getRoot().layout(0, 0, g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
                Bitmap createBitmap2 = Bitmap.createBitmap(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                g16.getRoot().draw(new Canvas(createBitmap2));
                return createBitmap2;
            }
        }
        guildFeedShareToWXHelper$generateBitmapForImage$1 = new GuildFeedShareToWXHelper$generateBitmapForImage$1(this, continuation);
        obj = guildFeedShareToWXHelper$generateBitmapForImage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = guildFeedShareToWXHelper$generateBitmapForImage$1.label;
        if (i17 == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        ImageView imageView22 = g16.f446961c;
        Intrinsics.checkNotNullExpressionValue(imageView22, "binding.playVideo");
        if (!z16) {
        }
        imageView22.setVisibility(i18);
        if (z16) {
        }
        imageView = g16.f446960b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageContent");
        guildFeedShareToWXHelper$generateBitmapForImage$1.L$0 = guildFeedShareToWXHelper;
        guildFeedShareToWXHelper$generateBitmapForImage$1.L$1 = g16;
        guildFeedShareToWXHelper$generateBitmapForImage$1.L$2 = null;
        guildFeedShareToWXHelper$generateBitmapForImage$1.label = 2;
        if (guildFeedShareToWXHelper.p(str2, imageView, guildFeedShareToWXHelper$generateBitmapForImage$1) == coroutine_suspended) {
        }
        g16.getRoot().measure(guildFeedShareToWXHelper.r(239.0f), guildFeedShareToWXHelper.r(191.0f));
        g16.getRoot().layout(0, 0, g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
        Bitmap createBitmap22 = Bitmap.createBitmap(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        g16.getRoot().draw(new Canvas(createBitmap22));
        return createBitmap22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(Context context, Continuation<? super Bitmap> continuation) {
        GuildFeedShareToWXHelper$generateBitmapForQQDoc$1 guildFeedShareToWXHelper$generateBitmapForQQDoc$1;
        Object coroutine_suspended;
        int i3;
        x12.m g16;
        GuildFeedShareToWXHelper guildFeedShareToWXHelper;
        if (continuation instanceof GuildFeedShareToWXHelper$generateBitmapForQQDoc$1) {
            guildFeedShareToWXHelper$generateBitmapForQQDoc$1 = (GuildFeedShareToWXHelper$generateBitmapForQQDoc$1) continuation;
            int i16 = guildFeedShareToWXHelper$generateBitmapForQQDoc$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildFeedShareToWXHelper$generateBitmapForQQDoc$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildFeedShareToWXHelper$generateBitmapForQQDoc$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildFeedShareToWXHelper$generateBitmapForQQDoc$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        g16 = (x12.m) guildFeedShareToWXHelper$generateBitmapForQQDoc$1.L$1;
                        guildFeedShareToWXHelper = (GuildFeedShareToWXHelper) guildFeedShareToWXHelper$generateBitmapForQQDoc$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    g16 = x12.m.g(LayoutInflater.from(context));
                    Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
                    ViewGroup.LayoutParams layoutParams = g16.f446960b.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    layoutParams.width = bi.b(135);
                    layoutParams.height = bi.b(102);
                    g16.getRoot().setBackgroundColor(Color.parseColor("#F5F5F5"));
                    ImageView imageView = g16.f446960b;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageContent");
                    guildFeedShareToWXHelper$generateBitmapForQQDoc$1.L$0 = this;
                    guildFeedShareToWXHelper$generateBitmapForQQDoc$1.L$1 = g16;
                    guildFeedShareToWXHelper$generateBitmapForQQDoc$1.label = 1;
                    if (p("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_share_to_wx_doc.png", imageView, guildFeedShareToWXHelper$generateBitmapForQQDoc$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildFeedShareToWXHelper = this;
                }
                g16.getRoot().measure(guildFeedShareToWXHelper.r(239.0f), guildFeedShareToWXHelper.r(191.0f));
                g16.getRoot().layout(0, 0, g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
                Bitmap createBitmap = Bitmap.createBitmap(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                g16.getRoot().draw(new Canvas(createBitmap));
                return createBitmap;
            }
        }
        guildFeedShareToWXHelper$generateBitmapForQQDoc$1 = new GuildFeedShareToWXHelper$generateBitmapForQQDoc$1(this, continuation);
        Object obj2 = guildFeedShareToWXHelper$generateBitmapForQQDoc$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildFeedShareToWXHelper$generateBitmapForQQDoc$1.label;
        if (i3 == 0) {
        }
        g16.getRoot().measure(guildFeedShareToWXHelper.r(239.0f), guildFeedShareToWXHelper.r(191.0f));
        g16.getRoot().layout(0, 0, g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
        Bitmap createBitmap2 = Bitmap.createBitmap(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        g16.getRoot().draw(new Canvas(createBitmap2));
        return createBitmap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(Context context, SpannableStringBuilder spannableStringBuilder, Continuation<? super Bitmap> continuation) {
        GuildFeedShareToWXHelper$generateBitmapForTextContents$1 guildFeedShareToWXHelper$generateBitmapForTextContents$1;
        Object coroutine_suspended;
        int i3;
        GuildFeedShareToWXHelper guildFeedShareToWXHelper;
        if (continuation instanceof GuildFeedShareToWXHelper$generateBitmapForTextContents$1) {
            guildFeedShareToWXHelper$generateBitmapForTextContents$1 = (GuildFeedShareToWXHelper$generateBitmapForTextContents$1) continuation;
            int i16 = guildFeedShareToWXHelper$generateBitmapForTextContents$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildFeedShareToWXHelper$generateBitmapForTextContents$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildFeedShareToWXHelper$generateBitmapForTextContents$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildFeedShareToWXHelper$generateBitmapForTextContents$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        spannableStringBuilder = (SpannableStringBuilder) guildFeedShareToWXHelper$generateBitmapForTextContents$1.L$2;
                        context = (Context) guildFeedShareToWXHelper$generateBitmapForTextContents$1.L$1;
                        guildFeedShareToWXHelper = (GuildFeedShareToWXHelper) guildFeedShareToWXHelper$generateBitmapForTextContents$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "generateBitmapForTextContents textContents:" + ((Object) spannableStringBuilder));
                    }
                    guildFeedShareToWXHelper$generateBitmapForTextContents$1.L$0 = this;
                    guildFeedShareToWXHelper$generateBitmapForTextContents$1.L$1 = context;
                    guildFeedShareToWXHelper$generateBitmapForTextContents$1.L$2 = spannableStringBuilder;
                    guildFeedShareToWXHelper$generateBitmapForTextContents$1.label = 1;
                    obj = h("https://downv6.qq.com/innovate/guild/sfeed/guild_feed_share_to_wx_text_bg.png", guildFeedShareToWXHelper$generateBitmapForTextContents$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildFeedShareToWXHelper = this;
                }
                x12.o g16 = x12.o.g(LayoutInflater.from(context));
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
                g16.getRoot().setBackground(new BitmapDrawable(context.getResources(), (Bitmap) obj));
                g16.f446980b.setText(spannableStringBuilder);
                g16.getRoot().measure(guildFeedShareToWXHelper.r(239.0f), guildFeedShareToWXHelper.r(191.0f));
                g16.getRoot().layout(0, 0, g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight());
                Bitmap createBitmap = Bitmap.createBitmap(g16.getRoot().getMeasuredWidth(), g16.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                g16.getRoot().draw(new Canvas(createBitmap));
                return createBitmap;
            }
        }
        guildFeedShareToWXHelper$generateBitmapForTextContents$1 = new GuildFeedShareToWXHelper$generateBitmapForTextContents$1(this, continuation);
        Object obj2 = guildFeedShareToWXHelper$generateBitmapForTextContents$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildFeedShareToWXHelper$generateBitmapForTextContents$1.label;
        if (i3 == 0) {
        }
        x12.o g162 = x12.o.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g162, "inflate(LayoutInflater.from(context))");
        g162.getRoot().setBackground(new BitmapDrawable(context.getResources(), (Bitmap) obj2));
        g162.f446980b.setText(spannableStringBuilder);
        g162.getRoot().measure(guildFeedShareToWXHelper.r(239.0f), guildFeedShareToWXHelper.r(191.0f));
        g162.getRoot().layout(0, 0, g162.getRoot().getMeasuredWidth(), g162.getRoot().getMeasuredHeight());
        Bitmap createBitmap2 = Bitmap.createBitmap(g162.getRoot().getMeasuredWidth(), g162.getRoot().getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        g162.getRoot().draw(new Canvas(createBitmap2));
        return createBitmap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0027. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(Context context, GuildFeedShareToWXInfo guildFeedShareToWXInfo, Continuation<? super Pair<Integer, Bitmap>> continuation) {
        GuildFeedShareToWXHelper$generateBitmapToShare$1 guildFeedShareToWXHelper$generateBitmapToShare$1;
        GuildFeedShareToWXHelper$generateBitmapToShare$1 guildFeedShareToWXHelper$generateBitmapToShare$12;
        Object coroutine_suspended;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        if (continuation instanceof GuildFeedShareToWXHelper$generateBitmapToShare$1) {
            guildFeedShareToWXHelper$generateBitmapToShare$1 = (GuildFeedShareToWXHelper$generateBitmapToShare$1) continuation;
            int i3 = guildFeedShareToWXHelper$generateBitmapToShare$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                guildFeedShareToWXHelper$generateBitmapToShare$1.label = i3 - Integer.MIN_VALUE;
                guildFeedShareToWXHelper$generateBitmapToShare$12 = guildFeedShareToWXHelper$generateBitmapToShare$1;
                Object obj = guildFeedShareToWXHelper$generateBitmapToShare$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (guildFeedShareToWXHelper$generateBitmapToShare$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Intrinsics.checkNotNullExpressionValue(guildFeedShareToWXInfo.getFeedInfo().images, "info.feedInfo.images");
                        if (!r0.isEmpty()) {
                            GProStImage imageInfo = guildFeedShareToWXInfo.getFeedInfo().images.get(0);
                            Intrinsics.checkNotNullExpressionValue(imageInfo, "imageInfo");
                            String imageUrl = pl1.a.e(imageInfo).url;
                            Integer boxInt = Boxing.boxInt(1);
                            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
                            int i16 = imageInfo.width;
                            int i17 = imageInfo.height;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.L$0 = boxInt;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.label = 1;
                            obj = k(context, imageUrl, i16, i17, false, guildFeedShareToWXHelper$generateBitmapToShare$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            num6 = boxInt;
                            return new Pair(num6, obj);
                        }
                        Intrinsics.checkNotNullExpressionValue(guildFeedShareToWXInfo.getFeedInfo().videos, "info.feedInfo.videos");
                        if (!r0.isEmpty()) {
                            GProStImage gProStImage = guildFeedShareToWXInfo.getFeedInfo().videos.get(0).cover;
                            GProStImage gProStImage2 = guildFeedShareToWXInfo.getFeedInfo().videos.get(0).cover;
                            Intrinsics.checkNotNullExpressionValue(gProStImage2, "info.feedInfo.videos[0].cover");
                            String imageUrl2 = pl1.a.e(gProStImage2).url;
                            Integer boxInt2 = Boxing.boxInt(2);
                            Intrinsics.checkNotNullExpressionValue(imageUrl2, "imageUrl");
                            int i18 = gProStImage.width;
                            int i19 = gProStImage.height;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.L$0 = boxInt2;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.label = 2;
                            obj = k(context, imageUrl2, i18, i19, true, guildFeedShareToWXHelper$generateBitmapToShare$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            num5 = boxInt2;
                            return new Pair(num5, obj);
                        }
                        GProStRichTextContent j3 = j(guildFeedShareToWXInfo.getFeedInfo(), 1);
                        if (j3 == null && (j3 = j(guildFeedShareToWXInfo.getFeedInfo(), 7)) == null && (j3 = j(guildFeedShareToWXInfo.getFeedInfo(), 9)) == null) {
                            j3 = j(guildFeedShareToWXInfo.getFeedInfo(), 8);
                        }
                        if (j3 != null) {
                            String coverUrl = j3.urlContent.thirdVideoInfo.cover;
                            Integer boxInt3 = Boxing.boxInt(3);
                            GuildFeedShareToWXHelper guildFeedShareToWXHelper = f220290a;
                            Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
                            guildFeedShareToWXHelper$generateBitmapToShare$12.L$0 = boxInt3;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.label = 3;
                            obj = guildFeedShareToWXHelper.k(context, coverUrl, 0, 0, true, guildFeedShareToWXHelper$generateBitmapToShare$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            num4 = boxInt3;
                            return TuplesKt.to(num4, obj);
                        }
                        GProStRichTextContent j16 = j(guildFeedShareToWXInfo.getFeedInfo(), 2);
                        if (j16 != null) {
                            String coverUrl2 = j16.urlContent.weixinOffcialAccountsContent.url;
                            Integer boxInt4 = Boxing.boxInt(4);
                            GuildFeedShareToWXHelper guildFeedShareToWXHelper2 = f220290a;
                            Intrinsics.checkNotNullExpressionValue(coverUrl2, "coverUrl");
                            guildFeedShareToWXHelper$generateBitmapToShare$12.L$0 = boxInt4;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.label = 4;
                            obj = guildFeedShareToWXHelper2.k(context, coverUrl2, 0, 0, false, guildFeedShareToWXHelper$generateBitmapToShare$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            num3 = boxInt4;
                            return new Pair(num3, obj);
                        }
                        if (j(guildFeedShareToWXInfo.getFeedInfo(), 3) != null) {
                            Integer boxInt5 = Boxing.boxInt(5);
                            GuildFeedShareToWXHelper guildFeedShareToWXHelper3 = f220290a;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.L$0 = boxInt5;
                            guildFeedShareToWXHelper$generateBitmapToShare$12.label = 5;
                            obj = guildFeedShareToWXHelper3.l(context, guildFeedShareToWXHelper$generateBitmapToShare$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            num2 = boxInt5;
                            return new Pair(num2, obj);
                        }
                        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
                        ArrayList<GProStRichTextContent> contents = guildFeedShareToWXInfo.getFeedInfo().contents.contents;
                        String valueOf = String.valueOf(guildFeedShareToWXInfo.getGuildId());
                        IParseRichTextConfig<GProStRichTextContent> e16 = IParseRichTextConfig.INSTANCE.e();
                        String valueOf2 = String.valueOf(guildFeedShareToWXInfo.getChannelId());
                        Intrinsics.checkNotNullExpressionValue(contents, "contents");
                        Pair s16 = FeedRichTextContentParser.s(feedRichTextContentParser, contents, null, e16, valueOf2, valueOf, 1, null);
                        Integer boxInt6 = Boxing.boxInt(0);
                        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) s16.getFirst();
                        guildFeedShareToWXHelper$generateBitmapToShare$12.L$0 = boxInt6;
                        guildFeedShareToWXHelper$generateBitmapToShare$12.label = 6;
                        obj = m(context, spannableStringBuilder, guildFeedShareToWXHelper$generateBitmapToShare$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        num = boxInt6;
                        return new Pair(num, obj);
                    case 1:
                        num6 = (Integer) guildFeedShareToWXHelper$generateBitmapToShare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return new Pair(num6, obj);
                    case 2:
                        num5 = (Integer) guildFeedShareToWXHelper$generateBitmapToShare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return new Pair(num5, obj);
                    case 3:
                        num4 = (Integer) guildFeedShareToWXHelper$generateBitmapToShare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return TuplesKt.to(num4, obj);
                    case 4:
                        num3 = (Integer) guildFeedShareToWXHelper$generateBitmapToShare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return new Pair(num3, obj);
                    case 5:
                        num2 = (Integer) guildFeedShareToWXHelper$generateBitmapToShare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return new Pair(num2, obj);
                    case 6:
                        num = (Integer) guildFeedShareToWXHelper$generateBitmapToShare$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return new Pair(num, obj);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        guildFeedShareToWXHelper$generateBitmapToShare$1 = new GuildFeedShareToWXHelper$generateBitmapToShare$1(this, continuation);
        guildFeedShareToWXHelper$generateBitmapToShare$12 = guildFeedShareToWXHelper$generateBitmapToShare$1;
        Object obj2 = guildFeedShareToWXHelper$generateBitmapToShare$12.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (guildFeedShareToWXHelper$generateBitmapToShare$12.label) {
        }
    }

    private final int o() {
        return ((Number) SMALL_IMAGE_SIZE_DP.getValue()).intValue();
    }

    private final Object p(String str, ImageView imageView, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "fetchBitmap imageUrl:" + str);
        }
        com.tencent.mobileqq.guild.picload.e.a().f(com.tencent.mobileqq.guild.util.v.d(str, imageView, null, null, 12, null), new c(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final int r(float f16) {
        return View.MeasureSpec.makeMeasureSpec(bi.a(f16), 1073741824);
    }

    public final void q(@NotNull Context context, @NotNull GuildFeedShareToWXInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        if (!m02.d.i()) {
            Logger.f235387a.d().w("Guild.share.GuildFeedShareToWXHelper", 1, "NotSupportWX gId:" + info.getGuildId() + " cId:" + info.getChannelId() + " fId:" + info.getFeedId());
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f156731l0));
            return;
        }
        Logger.f235387a.d().d("Guild.share.GuildFeedShareToWXHelper", 1, "startShare gId:" + info.getGuildId() + " cId:" + info.getChannelId() + " fId:" + info.getFeedId() + " title:" + info.getTitle());
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.share.GuildFeedShareToWXHelper startShare", null, null, null, new GuildFeedShareToWXHelper$startShare$3(info, context, null), 14, null);
        }
    }
}
