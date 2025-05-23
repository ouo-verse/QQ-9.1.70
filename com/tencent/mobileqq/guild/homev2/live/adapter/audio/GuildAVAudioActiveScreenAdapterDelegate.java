package com.tencent.mobileqq.guild.homev2.live.adapter.audio;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveScreenAdapterDelegate;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np1.a;
import org.jetbrains.annotations.NotNull;
import pp1.GuildAVAudioActiveScreenUIData;
import vp1.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioActiveScreenAdapterDelegate;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/GuildAVBaseAdapterDelegate;", "Lpp1/d;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder;", "Lpp1/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "Lnp1/a$b;", "e", "Lnp1/a$b;", "callback", "<init>", "(Lnp1/a$b;)V", "f", "a", "b", "LiveViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVAudioActiveScreenAdapterDelegate extends GuildAVBaseAdapterDelegate<GuildAVAudioActiveScreenUIData, LiveViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b callback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001e\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001c\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioActiveScreenAdapterDelegate$a;", "", "Lkotlin/Function0;", "", "onFinishSet", "Landroid/widget/ImageView;", "c", "b", "", "drawableId", "e", "Landroid/graphics/drawable/Drawable;", "drawable", "f", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "coverViewGroup", "Landroid/widget/ImageView;", "imageView1", "imageView2", "", "d", "Z", "useImageView1", "<init>", "(Landroid/view/ViewGroup;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewGroup coverViewGroup;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView imageView1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView imageView2;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean useImageView1;

        public a(@NotNull ViewGroup coverViewGroup) {
            Intrinsics.checkNotNullParameter(coverViewGroup, "coverViewGroup");
            this.coverViewGroup = coverViewGroup;
            ImageView b16 = b();
            this.imageView1 = b16;
            ImageView b17 = b();
            this.imageView2 = b17;
            coverViewGroup.addView(b16);
            coverViewGroup.addView(b17);
        }

        private final ImageView b() {
            RoundRectImageView roundRectImageView = new RoundRectImageView(this.coverViewGroup.getContext());
            roundRectImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            roundRectImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            roundRectImageView.setCornerRadiusAndMode(QQGuildUIUtil.f(10.0f), 1);
            return roundRectImageView;
        }

        private final ImageView c(final Function0<Unit> onFinishSet) {
            ImageView imageView;
            final ImageView imageView2;
            boolean z16 = !this.useImageView1;
            this.useImageView1 = z16;
            if (z16) {
                imageView = this.imageView1;
                imageView2 = this.imageView2;
            } else {
                imageView = this.imageView2;
                imageView2 = this.imageView1;
            }
            this.coverViewGroup.removeView(imageView);
            this.coverViewGroup.addView(imageView);
            imageView2.animate().cancel();
            imageView.animate().cancel();
            imageView2.setVisibility(0);
            imageView.setVisibility(0);
            imageView2.setAlpha(1.0f);
            imageView.setAlpha(0.0f);
            imageView.animate().alpha(1.0f).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildAVAudioActiveScreenAdapterDelegate.a.d(imageView2, onFinishSet);
                }
            }).start();
            return imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ImageView preImageView, Function0 onFinishSet) {
            Intrinsics.checkNotNullParameter(preImageView, "$preImageView");
            Intrinsics.checkNotNullParameter(onFinishSet, "$onFinishSet");
            preImageView.setVisibility(8);
            onFinishSet.invoke();
        }

        public final void e(@DrawableRes int drawableId, @NotNull Function0<Unit> onFinishSet) {
            Intrinsics.checkNotNullParameter(onFinishSet, "onFinishSet");
            TraceUtils.h("topCard_screen_coverResId");
            c(onFinishSet).setImageResource(drawableId);
            TraceUtils.k();
        }

        public final void f(@NotNull Drawable drawable, @NotNull Function0<Unit> onFinishSet) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            Intrinsics.checkNotNullParameter(onFinishSet, "onFinishSet");
            TraceUtils.h("topCard_screen_coverDrawable");
            c(onFinishSet).setImageDrawable(drawable);
            TraceUtils.k();
        }
    }

    public GuildAVAudioActiveScreenAdapterDelegate(@NotNull a.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        be g16 = be.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026rent, false\n            )");
        return new LiveViewHolder(g16, this.callback);
    }

    @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate
    protected boolean k(@NotNull pp1.g item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof GuildAVAudioActiveScreenUIData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull GuildAVAudioActiveScreenUIData item, @NotNull LiveViewHolder holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.Delegate.AudioScreen", 1, "onBindViewHolder item:" + item);
        }
        holder.z(item);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        new ro1.b(view).c(item.getChannelId()).f(pos).g(item.getSessionId()).b(item.getCardType()).d(1).a().d();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/GuildAVBaseAdapterDelegate$a;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lpp1/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", ReportConstant.COSTREPORT_PREFIX, "", "getTag", "Lvp1/be;", "G", "Lvp1/be;", "binding", "Lnp1/a$b;", "H", "Lnp1/a$b;", "callback", "I", "Lpp1/d;", "itemData", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioActiveScreenAdapterDelegate$a;", "J", "Lkotlin/Lazy;", "B", "()Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioActiveScreenAdapterDelegate$a;", "coverBgSwitcher", "<init>", "(Lvp1/be;Lnp1/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class LiveViewHolder extends GuildAVBaseAdapterDelegate.a {

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final be binding;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final a.b callback;

        /* renamed from: I, reason: from kotlin metadata */
        private GuildAVAudioActiveScreenUIData itemData;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final Lazy coverBgSwitcher;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public LiveViewHolder(@NotNull be binding, @NotNull a.b callback) {
            super(r0);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(callback, "callback");
            RadiusFrameLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this.binding = binding;
            this.callback = callback;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$coverBgSwitcher$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final GuildAVAudioActiveScreenAdapterDelegate.a invoke() {
                    be beVar;
                    beVar = GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder.this.binding;
                    FrameLayout frameLayout = beVar.f442433b;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.activeChannelBgContainer");
                    return new GuildAVAudioActiveScreenAdapterDelegate.a(frameLayout);
                }
            });
            this.coverBgSwitcher = lazy;
            binding.getRoot().post(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.n
                @Override // java.lang.Runnable
                public final void run() {
                    GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder.v(GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void A() {
            if (this.binding.f442433b.getBackground() != null) {
                this.binding.f442433b.setBackground(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final a B() {
            return (a) this.coverBgSwitcher.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(LiveViewHolder this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a.b bVar = this$0.callback;
            GuildAVAudioActiveScreenUIData guildAVAudioActiveScreenUIData = this$0.itemData;
            if (guildAVAudioActiveScreenUIData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                guildAVAudioActiveScreenUIData = null;
            }
            bVar.a(guildAVAudioActiveScreenUIData);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(final LiveViewHolder this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder.C(GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder.this, view);
                }
            });
            this$0.binding.f442436e.setImageResource(R.drawable.guild_top_screen_icon);
            this$0.binding.f442437f.setBackgroundResource(R.drawable.guild_home_active_channel_status_icon_bg);
            this$0.binding.f442433b.setBackgroundResource(R.drawable.guild_sticky_live_card_bg);
            RadiusFrameLayout root = this$0.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
            this$0.binding.f442435d.setBackgroundResource(R.drawable.guild_home_active_channel_mask_top);
            this$0.binding.f442434c.setBackgroundResource(R.drawable.guild_home_active_channel_mask_bottom);
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.AudioScreen";
        }

        public final void z(@NotNull GuildAVAudioActiveScreenUIData item) {
            boolean z16;
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
            this.binding.f442441j.setText(item.getTitle());
            int noMemberMaxLimit = item.getNoMemberMaxLimit();
            int memberMax = item.getMemberMax();
            int memberCount = item.getMemberCount();
            TextView textView = this.binding.f442439h;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.homeActivePeopleNumber");
            q(noMemberMaxLimit, memberMax, memberCount, textView);
            if (item.getCoverUrl().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                B().e(R.drawable.guild_sticky_live_card_bg, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$1
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
                        GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder.this.A();
                    }
                });
            } else {
                com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(item.getCoverUrl()), new GuildPicStateListener() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(true);
                    }

                    @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
                    public void c(@NotNull final LoadState state, @NotNull final Option option) {
                        GuildAVAudioActiveScreenAdapterDelegate.a B;
                        GuildAVAudioActiveScreenAdapterDelegate.a B2;
                        GuildAVAudioActiveScreenAdapterDelegate.a B3;
                        boolean z17;
                        Intrinsics.checkNotNullParameter(state, "state");
                        Intrinsics.checkNotNullParameter(option, "option");
                        Logger logger = Logger.f235387a;
                        if (QLog.isDevelopLevel()) {
                            if (option.getResultBitMap() != null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            Log.d("Guild.NewHome.content.active.Delegate.AudioScreen", "onStateChangeCallback state:" + state + " bitMapValid:" + z17);
                        }
                        ThreadUtils threadUtils = ThreadUtils.f235400a;
                        final GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder liveViewHolder = GuildAVAudioActiveScreenAdapterDelegate.LiveViewHolder.this;
                        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                            TraceUtils.h("topCard_screen_bindCoverDownloaded");
                            if (state == LoadState.STATE_SUCCESS) {
                                Bitmap resultBitMap = option.getResultBitMap();
                                if (resultBitMap != null) {
                                    B3 = liveViewHolder.B();
                                    B3.f(new BitmapDrawable(resultBitMap), new GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2$onStateChangeCallback$2$1(liveViewHolder));
                                } else {
                                    B2 = liveViewHolder.B();
                                    B2.e(R.drawable.guild_sticky_live_card_bg, new GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2$onStateChangeCallback$2$2(liveViewHolder));
                                }
                            } else if (state == LoadState.STATE_DOWNLOAD_FAILED || state == LoadState.STATE_DECODE_FAILED) {
                                B = liveViewHolder.B();
                                B.e(R.drawable.guild_sticky_live_card_bg, new GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2$onStateChangeCallback$2$3(liveViewHolder));
                            }
                            TraceUtils.k();
                            return;
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2$onStateChangeCallback$$inlined$ensureUiThread$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildAVAudioActiveScreenAdapterDelegate.a B4;
                                GuildAVAudioActiveScreenAdapterDelegate.a B5;
                                GuildAVAudioActiveScreenAdapterDelegate.a B6;
                                TraceUtils.h("topCard_screen_bindCoverDownloaded");
                                LoadState loadState = LoadState.this;
                                if (loadState == LoadState.STATE_SUCCESS) {
                                    Bitmap resultBitMap2 = option.getResultBitMap();
                                    if (resultBitMap2 != null) {
                                        B6 = liveViewHolder.B();
                                        B6.f(new BitmapDrawable(resultBitMap2), new GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2$onStateChangeCallback$2$1(liveViewHolder));
                                    } else {
                                        B5 = liveViewHolder.B();
                                        B5.e(R.drawable.guild_sticky_live_card_bg, new GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2$onStateChangeCallback$2$2(liveViewHolder));
                                    }
                                } else if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                                    B4 = liveViewHolder.B();
                                    B4.e(R.drawable.guild_sticky_live_card_bg, new GuildAVAudioActiveScreenAdapterDelegate$LiveViewHolder$bindData$2$onStateChangeCallback$2$3(liveViewHolder));
                                }
                                TraceUtils.k();
                            }
                        });
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        public void r() {
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        public void s() {
        }
    }
}
