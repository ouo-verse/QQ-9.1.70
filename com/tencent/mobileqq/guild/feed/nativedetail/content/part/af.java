package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.FeedThirdVideoFullScreenEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.FeedThirdVideoTextureView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018`\u001aH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R2\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0'j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/af;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoFullScreenEvent;", "event", "", "D9", "", "linkedWebId", "url", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoTextureView;", "C9", "webPageId", "A9", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "f", "Z", "mIsFullScreen", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "mFullScreenViewMap", "i", "Ljava/lang/String;", "mCurrentLinkedWebPageId", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class af extends com.tencent.mobileqq.guild.feed.part.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View root;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, FeedThirdVideoTextureView> mFullScreenViewMap = new HashMap<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurrentLinkedWebPageId = "";

    private final void A9(String webPageId, String url) {
        Activity hostActivity;
        Window window;
        Activity hostActivity2;
        Window window2;
        ViewGroup viewGroup;
        QLog.i("ThirdVideoFullScreenPart", 1, "enterFullScreen: " + webPageId);
        this.mIsFullScreen = true;
        FeedThirdVideoTextureView C9 = C9(webPageId, url);
        if (C9.getParent() == null && (viewGroup = this.container) != null) {
            viewGroup.addView(C9);
        }
        C9.setVisibility(0);
        this.mCurrentLinkedWebPageId = webPageId;
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        IPartHost partHost = getPartHost();
        if (partHost != null && (hostActivity2 = partHost.getHostActivity()) != null && (window2 = hostActivity2.getWindow()) != null) {
            window2.clearFlags(2048);
        }
        IPartHost partHost2 = getPartHost();
        if (partHost2 != null && (hostActivity = partHost2.getHostActivity()) != null && (window = hostActivity.getWindow()) != null) {
            window.addFlags(1024);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B9() {
        Activity hostActivity;
        Window window;
        Activity hostActivity2;
        Window window2;
        FeedThirdVideoTextureView feedThirdVideoTextureView;
        QLog.i("ThirdVideoFullScreenPart", 1, "exitFullScreen.");
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        this.mIsFullScreen = false;
        if (this.mFullScreenViewMap.containsKey(this.mCurrentLinkedWebPageId) && (feedThirdVideoTextureView = this.mFullScreenViewMap.get(this.mCurrentLinkedWebPageId)) != null) {
            feedThirdVideoTextureView.setVisibility(8);
        }
        this.mCurrentLinkedWebPageId = "";
        IPartHost partHost = getPartHost();
        if (partHost != null && (hostActivity2 = partHost.getHostActivity()) != null && (window2 = hostActivity2.getWindow()) != null) {
            window2.clearFlags(1024);
        }
        IPartHost partHost2 = getPartHost();
        if (partHost2 != null && (hostActivity = partHost2.getHostActivity()) != null && (window = hostActivity.getWindow()) != null) {
            window.addFlags(2048);
        }
    }

    private final FeedThirdVideoTextureView C9(String linkedWebId, String url) {
        int i3;
        int coerceAtLeast;
        LifecycleOwner lifecycleOwner;
        if (this.mFullScreenViewMap.containsKey(linkedWebId)) {
            FeedThirdVideoTextureView feedThirdVideoTextureView = this.mFullScreenViewMap.get(linkedWebId);
            Intrinsics.checkNotNull(feedThirdVideoTextureView);
            return feedThirdVideoTextureView;
        }
        View view = this.root;
        int i16 = 0;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            i3 = view.getMeasuredHeight() - ImmersiveUtils.getStatusBarHeight(getContext());
        } else {
            i3 = 0;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View view2 = this.root;
        if (view2 != null) {
            i16 = view2.getMeasuredWidth();
        }
        FeedThirdVideoTextureView feedThirdVideoTextureView2 = new FeedThirdVideoTextureView(context, "GuildFeedFullScreen", linkedWebId, new Pair(Integer.valueOf(i16), Integer.valueOf(coerceAtLeast)), new b());
        feedThirdVideoTextureView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null) {
            feedThirdVideoTextureView2.d(lifecycleOwner);
        }
        feedThirdVideoTextureView2.h(url);
        this.mFullScreenViewMap.put(linkedWebId, feedThirdVideoTextureView2);
        return feedThirdVideoTextureView2;
    }

    private final void D9(FeedThirdVideoFullScreenEvent event) {
        if (event.getShowInFullScreen()) {
            if (!this.mIsFullScreen) {
                A9(event.getWebPageId(), event.getUrl());
                return;
            }
            return;
        }
        B9();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> list = super.getEventClass();
        list.add(FeedThirdVideoFullScreenEvent.class);
        Intrinsics.checkNotNullExpressionValue(list, "list");
        return list;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.i("ThirdVideoFullScreenPart", 1, "onConfigurationChanged.");
        this.mFullScreenViewMap.clear();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        this.root = rootView;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.v3l);
        } else {
            viewGroup = null;
        }
        this.container = viewGroup;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof FeedThirdVideoFullScreenEvent) {
            D9((FeedThirdVideoFullScreenEvent) simpleBaseEvent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/af$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "", "loadSucceed", "", "code", "", "msg", "onError", "", RemoteWebViewEvent.OPEN_FULL_SCREEN, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
        public void onError(int code, @Nullable String msg2) {
            if (af.this.mIsFullScreen) {
                QLog.e("ThirdVideoFullScreenPart", 1, "exit full screen on error.");
                af.this.B9();
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
        public void loadSucceed() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
        public void a(boolean openFullScreen) {
        }
    }
}
