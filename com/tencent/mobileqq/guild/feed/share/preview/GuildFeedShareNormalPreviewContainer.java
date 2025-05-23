package com.tencent.mobileqq.guild.feed.share.preview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.component.qrcode.g;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.config.GuildFeedShareConfigParser;
import com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi;
import com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureGenerator;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.ShortFeedPicLineSection;
import com.tencent.mobileqq.guild.feed.util.GuildFeedTencentDocUI;
import com.tencent.mobileqq.guild.feed.widget.GuildLinkView;
import com.tencent.mobileqq.guild.feed.widget.GuildSmallWorldView;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.RoundImageView;
import cp1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.e;
import qj1.q;
import qj1.t;
import qj1.w;
import tl.h;
import x12.i;
import x12.j;
import x12.k;
import x12.l;
import x12.r;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 V2\u00020\u0001:\u0001WB%\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010S\u001a\u00020K\u00a2\u0006\u0004\bT\u0010UJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J+\u0010$\u001a\n #*\u0004\u0018\u00010\"0\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0013\u0010'\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010;R\u0016\u0010>\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010=R\"\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0@0?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0@0?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u001e\u0010J\u001a\n\u0018\u00010Fj\u0004\u0018\u0001`G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/share/preview/GuildFeedShareNormalPreviewContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", "feedDetail", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$b;", "reqParams", "", "y", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "it", "", "previousHeight", ReportConstant.COSTREPORT_PREFIX, "w", BdhLogUtil.LogTag.Tag_Conn, "k", "l", "u", "v", "t", "", "timeoutMillis", "Lcom/tencent/libra/listener/IPicLoadStateListener;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "", "url", "Landroid/widget/ImageView;", "imageView", "Lri1/a;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setParams", HippyTKDListViewAdapter.X, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lx12/l;", "e", "Lx12/l;", "binding", "f", "Lcom/tencent/mobileqq/guild/feed/api/IFeedSharePreviewApi$b;", "previewParams", h.F, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", "Lvk1/b;", "i", "Lvk1/b;", "feed", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Ljava/lang/String;", "shareUrl", "", "Lkotlinx/coroutines/Deferred;", "D", "Ljava/util/List;", "asyncContentImageTasks", "E", "otherImageTasks", "Lqj1/t;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IThirdVideoContentDisplayable;", UserInfo.SEX_FEMALE, "Lqj1/t;", "thirdVideoContent", "", "G", "I", "maxContentHeight", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedShareNormalPreviewContainer extends FrameLayout {
    private static final int I = (int) cw.b(66);

    /* renamed from: C, reason: from kotlin metadata */
    private String shareUrl;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<Deferred<ri1.a>> asyncContentImageTasks;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<Deferred<ri1.a>> otherImageTasks;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private t thirdVideoContent;

    /* renamed from: G, reason: from kotlin metadata */
    private int maxContentHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope coroutineScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IFeedSharePreviewApi.ReqParams previewParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FeedDetailMainDisplayableParser feedDetail;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private vk1.b feed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IGProGuildInfo guildInfo;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/share/preview/GuildFeedShareNormalPreviewContainer$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Continuation<ri1.a> f223428e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f223429f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Continuation<? super ri1.a> continuation, ImageView imageView) {
            super(false);
            this.f223428e = continuation;
            this.f223429f = imageView;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @Nullable Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Logger.f235387a.d().i("GuildFeedShareNormalPreviewContainer", 1, "onStateChangeCallback state=" + state + ", option=" + option);
            if (state.isFinishError()) {
                Continuation<ri1.a> continuation = this.f223428e;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ri1.a.c(-1, state.toString(), this.f223429f)));
            } else if (state.isFinishSuccess()) {
                Continuation<ri1.a> continuation2 = this.f223428e;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ri1.a.c(0, "", this.f223429f)));
            }
        }
    }

    public /* synthetic */ GuildFeedShareNormalPreviewContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final IPicLoadStateListener A(final long timeoutMillis) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        return new GuildPicStateListener() { // from class: com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer$newPicLoadListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(false);
            }

            @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
            public void c(@NotNull LoadState state, @NotNull Option option) {
                long e16;
                long e17;
                long e18;
                boolean z16;
                CoroutineScope coroutineScope;
                long e19;
                List list;
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(option, "option");
                Logger logger = Logger.f235387a;
                logger.d().i("GuildFeedShareNormalPreviewContainer", 1, "[newPicLoadListener] onStateChangeCallback state=" + state + ", option=" + option);
                if (state == LoadState.STATE_PREPARE) {
                    CompletableDeferred<ri1.a> CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    ConcurrentHashMap<Long, CompletableDeferred<ri1.a>> concurrentHashMap2 = concurrentHashMap;
                    e18 = GuildFeedShareNormalPreviewContainerKt.e(option);
                    if (concurrentHashMap2.putIfAbsent(Long.valueOf(e18), CompletableDeferred$default) == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Logger.a d16 = logger.d();
                        e19 = GuildFeedShareNormalPreviewContainerKt.e(option);
                        ImageView targetView = option.getTargetView();
                        Intrinsics.checkNotNullExpressionValue(targetView, "option.targetView");
                        d16.i("GuildFeedShareNormalPreviewContainer", 1, "[newPicLoadListener] onStateChangeCallback start loading " + option + "(" + e19 + "), " + m.a(targetView));
                        list = this.otherImageTasks;
                        list.add(CompletableDeferred$default);
                    }
                    coroutineScope = this.coroutineScope;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GuildFeedShareNormalPreviewContainer$newPicLoadListener$1$onStateChangeCallback$3(timeoutMillis, CompletableDeferred$default, option, null), 3, null);
                }
                if (!state.isFinish()) {
                    return;
                }
                ConcurrentHashMap<Long, CompletableDeferred<ri1.a>> concurrentHashMap3 = concurrentHashMap;
                e16 = GuildFeedShareNormalPreviewContainerKt.e(option);
                CompletableDeferred<ri1.a> remove = concurrentHashMap3.remove(Long.valueOf(e16));
                if (remove == null) {
                    Logger.b bVar = new Logger.b();
                    e17 = GuildFeedShareNormalPreviewContainerKt.e(option);
                    ImageView targetView2 = option.getTargetView();
                    Intrinsics.checkNotNullExpressionValue(targetView2, "option.targetView");
                    String str = "[newPicLoadListener] onStateChangeCallback deferred is null " + option + "(" + e17 + ", " + m.a(targetView2);
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GuildFeedShareNormalPreviewContainer", 1, (String) it.next(), null);
                    }
                }
                if (state.isFinishError()) {
                    if (remove != null) {
                        ri1.a c16 = ri1.a.c(-1, state.toString(), null);
                        Intrinsics.checkNotNullExpressionValue(c16, "error(-1, state.toString(), null)");
                        remove.complete(c16);
                        return;
                    }
                    return;
                }
                if (state.isFinishSuccess() && remove != null) {
                    ri1.a c17 = ri1.a.c(0, "", null);
                    Intrinsics.checkNotNullExpressionValue(c17, "error(0, \"\", null)");
                    remove.complete(c17);
                }
            }
        };
    }

    static /* synthetic */ IPicLoadStateListener B(GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 30000;
        }
        return guildFeedShareNormalPreviewContainer.A(j3);
    }

    private final void C() {
        int measuredHeight = (this.binding.f446957j.getMeasuredHeight() - this.binding.f446950c.getMeasuredHeight()) - this.binding.f446958k.getMeasuredHeight();
        Logger.f235387a.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(1): showMoreShadowLayout margin = " + measuredHeight);
        this.binding.f446958k.setTranslationY((float) measuredHeight);
        IFeedSharePreviewApi.ReqParams reqParams = this.previewParams;
        if (reqParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewParams");
            reqParams = null;
        }
        if (reqParams.getFromXhs()) {
            this.binding.f446951d.setText("\u524d\u5f80\u9891\u9053\u67e5\u770b\u66f4\u591a\u5185\u5bb9");
        }
    }

    private final void k() {
        l();
        u();
        v();
        t();
    }

    private final void l() {
        List listOf;
        vk1.b bVar = this.feed;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            bVar = null;
        }
        boolean z16 = true;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 1, 6, 7, 8, 9});
        Pair a16 = e.a.a(bVar, null, listOf, 0, null, 13, null);
        if (((CharSequence) a16.getFirst()).length() <= 0) {
            z16 = false;
        }
        if (z16) {
            TextView textView = new TextView(getContext());
            ViewExtKt.c(textView, (int) cw.b(12));
            textView.setText((CharSequence) a16.getFirst());
            textView.setTextSize(0, cw.b(18));
            TextViewCompat.setLineHeight(textView, (int) cw.b(30));
            textView.setTextColor(Color.parseColor("#0B0C0E"));
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.binding.f446949b.addView(textView, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private final void m() {
        Deferred<ri1.a> async$default;
        Deferred<ri1.a> async$default2;
        x12.h g16 = x12.h.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        TextView textView = g16.f446936d;
        IGProGuildInfo iGProGuildInfo = this.guildInfo;
        if (iGProGuildInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
            iGProGuildInfo = null;
        }
        textView.setText(iGProGuildInfo.getGuildName());
        TextView textView2 = g16.f446935c;
        c cVar = c.f391536a;
        IGProGuildInfo iGProGuildInfo2 = this.guildInfo;
        if (iGProGuildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
            iGProGuildInfo2 = null;
        }
        textView2.setText(cVar.a(iGProGuildInfo2.getUserNum(), "\u6210\u5458"));
        this.binding.f446955h.addView(g16.getRoot(), new FrameLayout.LayoutParams(-1, -2));
        List<Deferred<ri1.a>> list = this.otherImageTasks;
        async$default = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new GuildFeedShareNormalPreviewContainer$buildGuildInfoHeader$1(this, null), 3, null);
        list.add(async$default);
        List<Deferred<ri1.a>> list2 = this.otherImageTasks;
        async$default2 = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new GuildFeedShareNormalPreviewContainer$buildGuildInfoHeader$2(this, g16, null), 3, null);
        list2.add(async$default2);
    }

    private final void n(IFeedDetailDataParser feedDetail) {
        if (this.thirdVideoContent != null) {
            Logger.f235387a.d().i("GuildFeedShareNormalPreviewContainer", 1, "buildImageThumbnails: thirdVideoContent != null, return");
            return;
        }
        List<IFeedDetailDataParser.MediaInfo> mediaInfoList = feedDetail.getMediaInfoList();
        float f16 = 0.0f;
        int i3 = 0;
        for (Object obj : mediaInfoList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IFeedDetailDataParser.MediaInfo mediaInfo = (IFeedDetailDataParser.MediaInfo) obj;
            if (mediaInfo.getType() == 0) {
                if (f16 <= cw.b(this.maxContentHeight)) {
                    f16 = s(mediaInfo, f16);
                } else {
                    i3 = i16;
                }
            } else if (mediaInfo.getType() == 1) {
                w(mediaInfo);
            }
            if (f16 > cw.b(this.maxContentHeight)) {
                Logger.f235387a.d().i("GuildFeedShareNormalPreviewContainer", 1, "buildImageThumbnails[" + i3 + "]: currentHeight = " + f16 + ", break!!");
            } else if (i3 != mediaInfoList.size() - 1) {
                this.binding.f446949b.addView(new Space(getContext()), new FrameLayout.LayoutParams(-1, (int) cw.b(12)));
            }
            i3 = i16;
        }
    }

    private final void o() {
        j g16 = j.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
        ImageView imageView = g16.f446940b;
        Intrinsics.checkNotNullExpressionValue(imageView, "bottomBinding.guildLogo");
        IGProGuildInfo iGProGuildInfo = null;
        a16.f(v.d("https://downv6.qq.com/innovate/guild/sfeed/guild_long_feed_share_picture_guild_logo.png", imageView, null, null, 12, null).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a), B(this, 0L, 1, null));
        this.binding.f446950c.addView(g16.getRoot(), new FrameLayout.LayoutParams(-1, -2));
        GuildLongFeedPictureGenerator guildLongFeedPictureGenerator = GuildLongFeedPictureGenerator.f220341a;
        QUIColorfulQRCodeView qUIColorfulQRCodeView = g16.f446941c;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView, "bottomBinding.guildQrcode");
        guildLongFeedPictureGenerator.p(qUIColorfulQRCodeView);
        QUIColorfulQRCodeView qUIColorfulQRCodeView2 = g16.f446941c;
        String str = this.shareUrl;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareUrl");
            str = null;
        }
        qUIColorfulQRCodeView2.f(str, new g() { // from class: com.tencent.mobileqq.guild.feed.share.preview.a
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                GuildFeedShareNormalPreviewContainer.p(i3);
            }
        });
        IFeedSharePreviewApi.ReqParams reqParams = this.previewParams;
        if (reqParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewParams");
            reqParams = null;
        }
        if (reqParams.getFromXhs()) {
            QUIColorfulQRCodeView qUIColorfulQRCodeView3 = g16.f446941c;
            Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView3, "bottomBinding.guildQrcode");
            qUIColorfulQRCodeView3.setVisibility(8);
            TextView textView = g16.f446942d;
            IGProGuildInfo iGProGuildInfo2 = this.guildInfo;
            if (iGProGuildInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
            } else {
                iGProGuildInfo = iGProGuildInfo2;
            }
            textView.setText("\u6253\u5f00QQ\uff0c\u641c\u7d22\u300c" + iGProGuildInfo.getGuildName() + "\u300d\u9891\u9053");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(int i3) {
        Logger.f235387a.d().a("GuildFeedShareNormalPreviewContainer", 1, "bindQRCodeView result:" + i3);
    }

    private final void q() {
        i g16 = i.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
        ImageView imageView = g16.f446938b;
        Intrinsics.checkNotNullExpressionValue(imageView, "logoHeader.guildLogo");
        a16.f(v.d("https://downv6.qq.com/innovate/guild/sfeed/guild_long_feed_share_picture_guild_logo.png", imageView, null, null, 12, null).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a), B(this, 0L, 1, null));
        this.binding.f446955h.addView(g16.getRoot(), new FrameLayout.LayoutParams(-1, -2));
    }

    private final void r() {
        CharSequence f16;
        Deferred<ri1.a> async$default;
        x12.g g16 = x12.g.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        TextView textView = g16.f446931c;
        vk1.b bVar = this.feed;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            bVar = null;
        }
        textView.setText(bVar.L());
        TextView textView2 = g16.f446932d;
        FeedDetailMainDisplayableParser feedDetailMainDisplayableParser = this.feedDetail;
        if (feedDetailMainDisplayableParser == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDetail");
            feedDetailMainDisplayableParser = null;
        }
        f16 = GuildFeedShareNormalPreviewContainerKt.f(feedDetailMainDisplayableParser);
        textView2.setText(f16);
        vk1.b bVar2 = this.feed;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            bVar2 = null;
        }
        List<Deferred<ri1.a>> list = this.otherImageTasks;
        async$default = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new GuildFeedShareNormalPreviewContainer$buildPosterInfo$1$1(this, bVar2, g16, null), 3, null);
        list.add(async$default);
        this.binding.f446955h.addView(g16.getRoot());
    }

    private final float s(IFeedDetailDataParser.MediaInfo it, float previousHeight) {
        float b16;
        float height;
        Deferred<ri1.a> async$default;
        RoundImageView roundImageView = new RoundImageView(getContext());
        roundImageView.setQwRadius((int) cw.b(6));
        roundImageView.setAdjustViewBounds(true);
        if (it.getWidth() < 400.0f) {
            this.binding.f446949b.addView(roundImageView, new FrameLayout.LayoutParams((int) cw.b(128), -2));
            b16 = cw.b(128) / it.getWidth();
            height = it.getHeight();
        } else {
            this.binding.f446949b.addView(roundImageView, new FrameLayout.LayoutParams(-1, -2));
            b16 = cw.b(388) / it.getWidth();
            height = it.getHeight();
        }
        float f16 = previousHeight + (b16 * height);
        List<Deferred<ri1.a>> list = this.asyncContentImageTasks;
        async$default = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new GuildFeedShareNormalPreviewContainer$buildSingleImageThumbnail$1(this, it, roundImageView, null), 3, null);
        list.add(async$default);
        return f16;
    }

    private final void t() {
        Object firstOrNull;
        boolean z16;
        vk1.b bVar = this.feed;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            bVar = null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bVar.h());
        t tVar = (t) firstOrNull;
        if (tVar != null) {
            this.thirdVideoContent = tVar;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            GuildSmallWorldView guildSmallWorldView = new GuildSmallWorldView(context, null, 0, 6, null);
            guildSmallWorldView.g((int) cw.b(388));
            if (tVar.getUrlType() != 8 && tVar.getUrlType() != 9) {
                z16 = true;
            } else {
                z16 = false;
            }
            GuildSmallWorldView.j(guildSmallWorldView, new GuildSmallWorldView.b(tVar.getUrlType(), new GuildSmallWorldView.b.C7785b(tVar.getCoverUrl(), tVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String(), z16), new GuildSmallWorldView.b.a(tVar.getPlatformIconUrl(), tVar.getPlatformName())), null, B(this, 0L, 1, null), false, 10, null);
            guildSmallWorldView.setRadius(ShortFeedPicLineSection.INSTANCE.c());
            this.binding.f446949b.addView(guildSmallWorldView, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private final void u() {
        Object firstOrNull;
        vk1.b bVar = this.feed;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            bVar = null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bVar.f());
        w wVar = (w) firstOrNull;
        if (wVar != null) {
            r g16 = r.g(LayoutInflater.from(getContext()));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
            ConstraintLayout root = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "tencentDocBinding.root");
            GuildFeedTencentDocUI.d(new GuildFeedTencentDocUI(root), wVar, null, 2, null);
            this.binding.f446949b.addView(g16.getRoot(), new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private final void v() {
        Object firstOrNull;
        vk1.b bVar = this.feed;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            bVar = null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bVar.b());
        q qVar = (q) firstOrNull;
        if (qVar != null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            GuildLinkView guildLinkView = new GuildLinkView(context, null, 0, 6, null);
            int i3 = I;
            frameLayout.addView(guildLinkView, new FrameLayout.LayoutParams(-1, i3));
            this.binding.f446949b.addView(frameLayout, new FrameLayout.LayoutParams(-1, i3));
            GuildLinkView.d(guildLinkView, qVar.getTitle(), qVar.getAbstract(), qVar.getThumbUrl(), qVar.getRedirectUrl(), null, B(this, 0L, 1, null), null, TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(i3)), null, 336, null);
        }
    }

    private final void w(IFeedDetailDataParser.MediaInfo it) {
        CharSequence g16;
        Deferred<ri1.a> async$default;
        k g17 = k.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.from(context))");
        TextView textView = g17.f446945c;
        g16 = GuildFeedShareNormalPreviewContainerKt.g(it.getDurationMills());
        textView.setText(g16);
        this.binding.f446949b.addView(g17.getRoot(), new FrameLayout.LayoutParams(-1, -2));
        if (it.getUrlType() == 8 || it.getUrlType() == 9) {
            FrameLayout frameLayout = g17.f446944b;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mediaView.videoBottomShadow");
            frameLayout.setVisibility(8);
            ImageView imageView = g17.f446946d;
            Intrinsics.checkNotNullExpressionValue(imageView, "mediaView.videoPlay");
            imageView.setVisibility(8);
        }
        List<Deferred<ri1.a>> list = this.asyncContentImageTasks;
        async$default = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new GuildFeedShareNormalPreviewContainer$buildVideoThumbnail$1(this, it, g17, null), 3, null);
        list.add(async$default);
    }

    private final void y(FeedDetailMainDisplayableParser feedDetail, IFeedSharePreviewApi.ReqParams reqParams) {
        this.feedDetail = feedDetail;
        this.previewParams = reqParams;
        this.feed = feedDetail.getFeed();
        this.guildInfo = reqParams.getGuildInfo();
        this.shareUrl = reqParams.getShareUrl();
        this.maxContentHeight = Math.max(GuildFeedShareConfigParser.INSTANCE.getConfig().getFeedSharePicMaxHeight(), 594);
        Logger.f235387a.d().i("GuildFeedShareNormalPreviewContainer", 1, "initData: minContentHeight = 594, maxContentHeight = " + this.maxContentHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object z(String str, ImageView imageView, Continuation<? super ri1.a> continuation) {
        GuildFeedShareNormalPreviewContainer$loadImageAsync$1 guildFeedShareNormalPreviewContainer$loadImageAsync$1;
        Object coroutine_suspended;
        int i3;
        ri1.a aVar;
        if (continuation instanceof GuildFeedShareNormalPreviewContainer$loadImageAsync$1) {
            guildFeedShareNormalPreviewContainer$loadImageAsync$1 = (GuildFeedShareNormalPreviewContainer$loadImageAsync$1) continuation;
            int i16 = guildFeedShareNormalPreviewContainer$loadImageAsync$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildFeedShareNormalPreviewContainer$loadImageAsync$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildFeedShareNormalPreviewContainer$loadImageAsync$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildFeedShareNormalPreviewContainer$loadImageAsync$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        imageView = (ImageView) guildFeedShareNormalPreviewContainer$loadImageAsync$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    GuildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1 guildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1 = new GuildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1(null, str, imageView);
                    guildFeedShareNormalPreviewContainer$loadImageAsync$1.L$0 = imageView;
                    guildFeedShareNormalPreviewContainer$loadImageAsync$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(30000L, guildFeedShareNormalPreviewContainer$loadImageAsync$$inlined$suspendCoroutineWithTimeout$1, guildFeedShareNormalPreviewContainer$loadImageAsync$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                aVar = (ri1.a) obj;
                if (aVar != null) {
                    return ri1.a.c(-89, "loadImageAsync timeout", imageView);
                }
                return aVar;
            }
        }
        guildFeedShareNormalPreviewContainer$loadImageAsync$1 = new GuildFeedShareNormalPreviewContainer$loadImageAsync$1(this, continuation);
        Object obj2 = guildFeedShareNormalPreviewContainer$loadImageAsync$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildFeedShareNormalPreviewContainer$loadImageAsync$1.label;
        if (i3 == 0) {
        }
        aVar = (ri1.a) obj2;
        if (aVar != null) {
        }
    }

    public final void setParams(@NotNull IFeedSharePreviewApi.ReqParams reqParams) {
        Intrinsics.checkNotNullParameter(reqParams, "reqParams");
        IFeedDetailDataParser feedDetail = reqParams.getFeedDetail();
        if (feedDetail instanceof FeedDetailMainDisplayableParser) {
            y((FeedDetailMainDisplayableParser) feedDetail, reqParams);
            Logger.a d16 = Logger.f235387a.d();
            vk1.b bVar = this.feed;
            IFeedSharePreviewApi.ReqParams reqParams2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
                bVar = null;
            }
            String feedId = bVar.getFeedId();
            IGProGuildInfo iGProGuildInfo = this.guildInfo;
            if (iGProGuildInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
                iGProGuildInfo = null;
            }
            String guildID = iGProGuildInfo.getGuildID();
            String str = this.shareUrl;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareUrl");
                str = null;
            }
            IFeedSharePreviewApi.ReqParams reqParams3 = this.previewParams;
            if (reqParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewParams");
            } else {
                reqParams2 = reqParams3;
            }
            d16.i("GuildFeedShareNormalPreviewContainer", 1, "setParams: feedId = " + feedId + ", guildId = " + guildID + ", shareUrl = " + str + ", fromXhs = " + reqParams2.getFromXhs());
            q();
            m();
            r();
            k();
            n(feedDetail);
            o();
            return;
        }
        throw new IllegalArgumentException("feedDetail must be FeedDetailMainDisplayableParser".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object x(@NotNull Continuation<? super Unit> continuation) {
        GuildFeedShareNormalPreviewContainer$determineSize$1 guildFeedShareNormalPreviewContainer$determineSize$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        int b16;
        int b17;
        GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer;
        int i16;
        int i17;
        int i18;
        int i19;
        GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer2;
        int coerceIn;
        if (continuation instanceof GuildFeedShareNormalPreviewContainer$determineSize$1) {
            guildFeedShareNormalPreviewContainer$determineSize$1 = (GuildFeedShareNormalPreviewContainer$determineSize$1) continuation;
            int i26 = guildFeedShareNormalPreviewContainer$determineSize$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                guildFeedShareNormalPreviewContainer$determineSize$1.label = i26 - Integer.MIN_VALUE;
                obj = guildFeedShareNormalPreviewContainer$determineSize$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildFeedShareNormalPreviewContainer$determineSize$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                i17 = guildFeedShareNormalPreviewContainer$determineSize$1.I$2;
                                i18 = guildFeedShareNormalPreviewContainer$determineSize$1.I$1;
                                i19 = guildFeedShareNormalPreviewContainer$determineSize$1.I$0;
                                guildFeedShareNormalPreviewContainer2 = (GuildFeedShareNormalPreviewContainer) guildFeedShareNormalPreviewContainer$determineSize$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) cw.b(428), 1073741824);
                                coerceIn = RangesKt___RangesKt.coerceIn(guildFeedShareNormalPreviewContainer2.getMeasuredHeight(), i19, i18);
                                guildFeedShareNormalPreviewContainer2.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(coerceIn, 1073741824));
                                guildFeedShareNormalPreviewContainer2.layout(0, 0, guildFeedShareNormalPreviewContainer2.getMeasuredWidth(), guildFeedShareNormalPreviewContainer2.getMeasuredHeight());
                                com.tencent.mobileqq.guild.base.extension.t.h(guildFeedShareNormalPreviewContainer2).recycle();
                                if (i17 != 0) {
                                    guildFeedShareNormalPreviewContainer2.C();
                                }
                                Logger.f235387a.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(2): measuredHeight = " + guildFeedShareNormalPreviewContainer2.getMeasuredHeight());
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        b17 = guildFeedShareNormalPreviewContainer$determineSize$1.I$1;
                        i16 = guildFeedShareNormalPreviewContainer$determineSize$1.I$0;
                        GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer3 = (GuildFeedShareNormalPreviewContainer) guildFeedShareNormalPreviewContainer$determineSize$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        guildFeedShareNormalPreviewContainer = guildFeedShareNormalPreviewContainer3;
                        int i27 = 0;
                        for (Object obj2 : (List) obj) {
                            int i28 = i27 + 1;
                            if (i27 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            ri1.a aVar = (ri1.a) obj2;
                            Logger.a d16 = Logger.f235387a.d();
                            String str = aVar.f431478b;
                            Object obj3 = aVar.f431479c;
                            Intrinsics.checkNotNullExpressionValue(obj3, "it.what");
                            d16.i("GuildFeedShareNormalPreviewContainer", 1, "determineSize images[" + i27 + "]: " + str + " " + m.a(obj3));
                            i27 = i28;
                        }
                        Logger logger = Logger.f235387a;
                        logger.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(0): minHeight=" + i16 + ", maxHeight=" + b17);
                        guildFeedShareNormalPreviewContainer.binding.f446956i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                        guildFeedShareNormalPreviewContainer.measure(View.MeasureSpec.makeMeasureSpec((int) cw.b(428), 1073741824), View.MeasureSpec.makeMeasureSpec((int) cw.b(b17 + 200), Integer.MIN_VALUE));
                        logger.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(1): measuredHeight = " + guildFeedShareNormalPreviewContainer.getMeasuredHeight());
                        ScrollView scrollView = guildFeedShareNormalPreviewContainer.binding.f446956i;
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams.weight = 1.0f;
                        scrollView.setLayoutParams(layoutParams);
                        if (guildFeedShareNormalPreviewContainer.getMeasuredHeight() >= b17) {
                            FrameLayout frameLayout = guildFeedShareNormalPreviewContainer.binding.f446958k;
                            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.showMoreShadowLayout");
                            frameLayout.setVisibility(8);
                            ViewGroup.LayoutParams layoutParams2 = guildFeedShareNormalPreviewContainer.binding.f446949b.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            ((FrameLayout.LayoutParams) layoutParams2).gravity = 16;
                            logger.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(1): change gravity for small size");
                            i17 = 0;
                        } else {
                            i17 = 1;
                        }
                        guildFeedShareNormalPreviewContainer.requestLayout();
                        guildFeedShareNormalPreviewContainer$determineSize$1.L$0 = guildFeedShareNormalPreviewContainer;
                        guildFeedShareNormalPreviewContainer$determineSize$1.I$0 = i16;
                        guildFeedShareNormalPreviewContainer$determineSize$1.I$1 = b17;
                        guildFeedShareNormalPreviewContainer$determineSize$1.I$2 = i17;
                        guildFeedShareNormalPreviewContainer$determineSize$1.label = 3;
                        if (DelayKt.delay(1L, guildFeedShareNormalPreviewContainer$determineSize$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i18 = b17;
                        i19 = i16;
                        guildFeedShareNormalPreviewContainer2 = guildFeedShareNormalPreviewContainer;
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) cw.b(428), 1073741824);
                        coerceIn = RangesKt___RangesKt.coerceIn(guildFeedShareNormalPreviewContainer2.getMeasuredHeight(), i19, i18);
                        guildFeedShareNormalPreviewContainer2.measure(makeMeasureSpec2, View.MeasureSpec.makeMeasureSpec(coerceIn, 1073741824));
                        guildFeedShareNormalPreviewContainer2.layout(0, 0, guildFeedShareNormalPreviewContainer2.getMeasuredWidth(), guildFeedShareNormalPreviewContainer2.getMeasuredHeight());
                        com.tencent.mobileqq.guild.base.extension.t.h(guildFeedShareNormalPreviewContainer2).recycle();
                        if (i17 != 0) {
                        }
                        Logger.f235387a.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(2): measuredHeight = " + guildFeedShareNormalPreviewContainer2.getMeasuredHeight());
                        return Unit.INSTANCE;
                    }
                    b17 = guildFeedShareNormalPreviewContainer$determineSize$1.I$1;
                    b16 = guildFeedShareNormalPreviewContainer$determineSize$1.I$0;
                    guildFeedShareNormalPreviewContainer = (GuildFeedShareNormalPreviewContainer) guildFeedShareNormalPreviewContainer$determineSize$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    b16 = (int) cw.b(594);
                    b17 = (int) cw.b(this.maxContentHeight);
                    List<Deferred<ri1.a>> list = this.otherImageTasks;
                    guildFeedShareNormalPreviewContainer$determineSize$1.L$0 = this;
                    guildFeedShareNormalPreviewContainer$determineSize$1.I$0 = b16;
                    guildFeedShareNormalPreviewContainer$determineSize$1.I$1 = b17;
                    guildFeedShareNormalPreviewContainer$determineSize$1.label = 1;
                    if (AwaitKt.awaitAll(list, guildFeedShareNormalPreviewContainer$determineSize$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildFeedShareNormalPreviewContainer = this;
                }
                List<Deferred<ri1.a>> list2 = guildFeedShareNormalPreviewContainer.asyncContentImageTasks;
                guildFeedShareNormalPreviewContainer$determineSize$1.L$0 = guildFeedShareNormalPreviewContainer;
                guildFeedShareNormalPreviewContainer$determineSize$1.I$0 = b16;
                guildFeedShareNormalPreviewContainer$determineSize$1.I$1 = b17;
                guildFeedShareNormalPreviewContainer$determineSize$1.label = 2;
                obj = AwaitKt.awaitAll(list2, guildFeedShareNormalPreviewContainer$determineSize$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                i16 = b16;
                int i272 = 0;
                while (r1.hasNext()) {
                }
                Logger logger2 = Logger.f235387a;
                logger2.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(0): minHeight=" + i16 + ", maxHeight=" + b17);
                guildFeedShareNormalPreviewContainer.binding.f446956i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                guildFeedShareNormalPreviewContainer.measure(View.MeasureSpec.makeMeasureSpec((int) cw.b(428), 1073741824), View.MeasureSpec.makeMeasureSpec((int) cw.b(b17 + 200), Integer.MIN_VALUE));
                logger2.d().i("GuildFeedShareNormalPreviewContainer", 1, "determineSize(1): measuredHeight = " + guildFeedShareNormalPreviewContainer.getMeasuredHeight());
                ScrollView scrollView2 = guildFeedShareNormalPreviewContainer.binding.f446956i;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
                layoutParams3.weight = 1.0f;
                scrollView2.setLayoutParams(layoutParams3);
                if (guildFeedShareNormalPreviewContainer.getMeasuredHeight() >= b17) {
                }
                guildFeedShareNormalPreviewContainer.requestLayout();
                guildFeedShareNormalPreviewContainer$determineSize$1.L$0 = guildFeedShareNormalPreviewContainer;
                guildFeedShareNormalPreviewContainer$determineSize$1.I$0 = i16;
                guildFeedShareNormalPreviewContainer$determineSize$1.I$1 = b17;
                guildFeedShareNormalPreviewContainer$determineSize$1.I$2 = i17;
                guildFeedShareNormalPreviewContainer$determineSize$1.label = 3;
                if (DelayKt.delay(1L, guildFeedShareNormalPreviewContainer$determineSize$1) != coroutine_suspended) {
                }
            }
        }
        guildFeedShareNormalPreviewContainer$determineSize$1 = new GuildFeedShareNormalPreviewContainer$determineSize$1(this, continuation);
        obj = guildFeedShareNormalPreviewContainer$determineSize$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildFeedShareNormalPreviewContainer$determineSize$1.label;
        if (i3 == 0) {
        }
        List<Deferred<ri1.a>> list22 = guildFeedShareNormalPreviewContainer.asyncContentImageTasks;
        guildFeedShareNormalPreviewContainer$determineSize$1.L$0 = guildFeedShareNormalPreviewContainer;
        guildFeedShareNormalPreviewContainer$determineSize$1.I$0 = b16;
        guildFeedShareNormalPreviewContainer$determineSize$1.I$1 = b17;
        guildFeedShareNormalPreviewContainer$determineSize$1.label = 2;
        obj = AwaitKt.awaitAll(list22, guildFeedShareNormalPreviewContainer$determineSize$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareNormalPreviewContainer(@NotNull Context originContext, @Nullable AttributeSet attributeSet, int i3) {
        super(originContext, attributeSet, i3);
        Intrinsics.checkNotNullParameter(originContext, "originContext");
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.asyncContentImageTasks = new ArrayList();
        this.otherImageTasks = new ArrayList();
        this.maxContentHeight = 1200;
        l f16 = l.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        f16.getMRv().setPadding(0, 0, 0, (int) cw.b(20));
        setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
    }
}
