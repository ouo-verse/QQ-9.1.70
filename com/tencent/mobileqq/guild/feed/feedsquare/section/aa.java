package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareLiveRoomItemData;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareLiveRoomUpdateEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.section.aa;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J*\u0010\u001d\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&`'H\u0016J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00102R\u0016\u0010>\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00105\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/aa;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/j;", "liveRoomItemData", "", "T", "", NodeProps.VISIBLE, "", "log", "U", "Landroid/widget/ImageView;", "imgView", "url", "X", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/lang/Runnable;", "task", "V", "e", "Z", "currentIsVisible", "f", "isNoLive", tl.h.F, "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "statusText", "Lcom/airbnb/lottie/LottieAnimationView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", BdhLogUtil.LogTag.Tag_Conn, "noLiveIcon", "D", "roomNameTv", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aa extends GuildFeedSquareFeedBaseSection implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView noLiveIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView roomNameTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean currentIsVisible;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNoLive;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView imgView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView statusText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView lottieView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/aa$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f219148f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImageView imageView) {
            super(false);
            this.f219148f = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Option option, final ImageView imgView) {
            final Bitmap bitmap;
            Bitmap resultBitMap;
            Intrinsics.checkNotNullParameter(imgView, "$imgView");
            if (option != null && (resultBitMap = option.getResultBitMap()) != null) {
                bitmap = resultBitMap.copy(Bitmap.Config.ARGB_8888, true);
            } else {
                bitmap = null;
            }
            eh.a(bitmap, 20);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.ad
                @Override // java.lang.Runnable
                public final void run() {
                    aa.b.h(imgView, bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(ImageView imgView, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(imgView, "$imgView");
            imgView.setImageBitmap(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(ImageView imgView, Option option) {
            Bitmap bitmap;
            Intrinsics.checkNotNullParameter(imgView, "$imgView");
            if (option != null) {
                bitmap = option.getResultBitMap();
            } else {
                bitmap = null;
            }
            imgView.setImageBitmap(bitmap);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable final Option option) {
            boolean z16 = false;
            if (state != null && state.isFinishSuccess()) {
                z16 = true;
            }
            if (z16 && com.tencent.mobileqq.guild.feed.gallery.b.j(option)) {
                if (aa.this.isNoLive) {
                    aa aaVar = aa.this;
                    final ImageView imageView = this.f219148f;
                    aaVar.V(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.ab
                        @Override // java.lang.Runnable
                        public final void run() {
                            aa.b.g(Option.this, imageView);
                        }
                    });
                } else {
                    final ImageView imageView2 = this.f219148f;
                    ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.ac
                        @Override // java.lang.Runnable
                        public final void run() {
                            aa.b.i(imageView2, option);
                        }
                    });
                }
            }
        }
    }

    private final void T(GuildFeedSquareLiveRoomItemData liveRoomItemData) {
        boolean z16;
        boolean z17;
        Object firstOrNull;
        boolean z18 = true;
        if (liveRoomItemData == null) {
            QLog.e(v(), 1, "onBindData, but liveRsp is null");
            this.mRootView.setVisibility(8);
            return;
        }
        this.mRootView.setVisibility(0);
        TextView textView = this.roomNameTv;
        LottieAnimationView lottieAnimationView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomNameTv");
            textView = null;
        }
        textView.setText(liveRoomItemData.getRoomTitle());
        String roomId = liveRoomItemData.getRoomId();
        if (roomId != null && roomId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(liveRoomItemData.getRoomId(), "0") && liveRoomItemData.getRoomState() == 1) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.isNoLive = z17;
        String str = liveRoomItemData.c().get("1:1");
        if (str == null) {
            Collection<String> values = liveRoomItemData.c().values();
            Intrinsics.checkNotNullExpressionValue(values, "liveRoomItemData.roomIcons.values");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(values);
            str = (String) firstOrNull;
        }
        if (str != null && str.length() != 0) {
            z18 = false;
        }
        if (z18) {
            str = "https://downv6.qq.com/innovate/guild/cover_info/active_channel_live.png";
        }
        ImageView imageView = this.imgView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgView");
            imageView = null;
        }
        X(imageView, str);
        if (this.isNoLive) {
            TextView textView2 = this.statusText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusText");
                textView2 = null;
            }
            textView2.setText("\u5df2\u7ed3\u675f");
            ImageView imageView2 = this.noLiveIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noLiveIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            LottieAnimationView lottieAnimationView2 = this.lottieView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.cancelAnimation();
            LottieAnimationView lottieAnimationView3 = this.lottieView;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationView = lottieAnimationView3;
            }
            lottieAnimationView.setVisibility(8);
            return;
        }
        TextView textView3 = this.statusText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
            textView3 = null;
        }
        textView3.setText("\u76f4\u64ad\u4e2d");
        ImageView imageView3 = this.noLiveIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noLiveIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        LottieAnimationView lottieAnimationView4 = this.lottieView;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView4 = null;
        }
        lottieAnimationView4.setVisibility(0);
        LottieAnimationView lottieAnimationView5 = this.lottieView;
        if (lottieAnimationView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView5 = null;
        }
        lottieAnimationView5.setAnimation(HardCodeUtil.qqStr(R.string.f1486910_));
        if (this.currentIsVisible) {
            LottieAnimationView lottieAnimationView6 = this.lottieView;
            if (lottieAnimationView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationView = lottieAnimationView6;
            }
            lottieAnimationView.playAnimation();
        }
    }

    private final void U(boolean visible, String log) {
        LottieAnimationView lottieAnimationView = null;
        if (visible) {
            LottieAnimationView lottieAnimationView2 = this.lottieView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationView = lottieAnimationView2;
            }
            lottieAnimationView.playAnimation();
        } else {
            LottieAnimationView lottieAnimationView3 = this.lottieView;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            } else {
                lottieAnimationView = lottieAnimationView3;
            }
            lottieAnimationView.cancelAnimation();
        }
        if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
            QLog.d(v(), 4, "changeAnimStatus:" + log + ", visible:" + visible);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.run();
    }

    private final void X(ImageView imgView, String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        com.tencent.mobileqq.guild.picload.e.a().f(Option.obtain().setUrl(url).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565).setDecodeMode(0), new b(imgView));
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ij1.g blockData;
        GuildFeedSquareLiveRoomItemData guildFeedSquareLiveRoomItemData;
        ImageView imageView = this.imgView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgView");
            imageView = null;
        }
        imageView.setBackgroundColor(-7829368);
        if (data != null && (blockData = data.getBlockData()) != null) {
            Object d16 = blockData.d(blockData.m());
            if (d16 instanceof GuildFeedSquareLiveRoomItemData) {
                guildFeedSquareLiveRoomItemData = (GuildFeedSquareLiveRoomItemData) d16;
            } else {
                guildFeedSquareLiveRoomItemData = null;
            }
            T(guildFeedSquareLiveRoomItemData);
            ImageView imageView3 = this.imgView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgView");
            } else {
                imageView2 = imageView3;
            }
            A(imageView2, "em_sgrp_nowplay_single_card");
        }
    }

    public final void V(@NotNull final Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.z
                @Override // java.lang.Runnable
                public final void run() {
                    aa.W(task);
                }
            });
        } else {
            task.run();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedSquareLiveRoomUpdateEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wap};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (!attached) {
            U(false, "onAttachedChanged");
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        U(false, "onDestroy.");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w_k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ild_feed_item_card_image)");
        ImageView imageView = (ImageView) findViewById;
        this.imgView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgView");
            imageView = null;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        View findViewById2 = containerView.findViewById(R.id.w_s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ld_feed_item_card_status)");
        this.statusText = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.w_n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026_item_card_lottie_status)");
        this.lottieView = (LottieAnimationView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.w_t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026item_card_status_no_live)");
        this.noLiveIcon = (ImageView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.w_r);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026feed_item_card_room_name)");
        this.roomNameTv = (TextView) findViewById5;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar;
        ij1.g blockData;
        if ((event instanceof GuildFeedSquareLiveRoomUpdateEvent) && (hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData) != null && (blockData = hVar.getBlockData()) != null) {
            GuildFeedSquareLiveRoomUpdateEvent guildFeedSquareLiveRoomUpdateEvent = (GuildFeedSquareLiveRoomUpdateEvent) event;
            if (Intrinsics.areEqual(blockData.b().idd, guildFeedSquareLiveRoomUpdateEvent.getFeedId())) {
                T(guildFeedSquareLiveRoomUpdateEvent.getItemData());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        this.currentIsVisible = visible;
        U(visible, "onVisibleChanged");
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareLiveContentSection";
    }
}
