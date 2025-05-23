package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseSceneType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.FeedThirdVideoFullScreenEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.FeedThirdVideoTextureView;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001XB?\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010(\u001a\u00020&\u0012\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00105\u001a\u00020\u000f\u0012\u0006\u00107\u001a\u00020\u000f\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'R\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00105\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u00104R\u001a\u00107\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b6\u00104R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010>R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010>R\u0016\u0010A\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010>R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010D\u001a\u0004\bO\u0010PR\u001b\u0010T\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010D\u001a\u0004\bS\u0010P\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedThirdVideoViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/h;", "", ReportConstant.COSTREPORT_PREFIX, "", "data", BdhLogUtil.LogTag.Tag_Conn, "B", UserInfo.SEX_FEMALE, "Landroid/graphics/drawable/Drawable;", "t", "E", "D", "Lkotlin/Pair;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getHeight", "getWidth", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "viewSizeChangedNotifier", "Landroid/view/View;", "c", "onDestroyView", "view", "g", "", "event", "f", "", "l", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter$TYPE;", "k", "j", "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextURLContent;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextURLContent;", "urlContent", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "d", "Ljava/lang/ref/WeakReference;", "lifecycleOwner", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "sceneType", "I", "u", "()I", "index", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "paragraphIndex", tl.h.F, "Lkotlin/Pair;", "mViewSize", "i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "mViewSizeChangedNotifier", "Z", "mDelayLoad", "mInited", "mViewCreated", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "v", "()Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "mContainer", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoTextureView;", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedThirdVideoTextureView;", "mPlayView", "Landroid/widget/ImageView;", "o", "w", "()Landroid/widget/ImageView;", "mCoverView", "p", "y", "mProgressView", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextURLContent;Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;II)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedThirdVideoViewAdapter extends BaseLongFeedViewAdapter implements com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStRichTextURLContent urlContent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WeakReference<LifecycleOwner> lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongFeedParseSceneType sceneType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> mViewSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h mViewSizeChangedNotifier;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean mDelayLoad;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mInited;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mViewCreated;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContainer;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mPlayView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mCoverView;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mProgressView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedThirdVideoViewAdapter$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(false);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            boolean z16 = false;
            if (state != null && state.isFinishError()) {
                z16 = true;
            }
            if (z16) {
                QLog.i("LongFeedThirdVideoViewAdapter", 1, "[loadVideoCover] error: " + state + ", thumbUrl: " + LongFeedThirdVideoViewAdapter.this.urlContent.getThirdVideoInfo().cover);
            }
        }
    }

    public LongFeedThirdVideoViewAdapter(@NotNull Context context, @NotNull GProStRichTextURLContent urlContent, @Nullable WeakReference<LifecycleOwner> weakReference, @NotNull LongFeedParseSceneType sceneType, int i3, int i16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(urlContent, "urlContent");
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.context = context;
        this.urlContent = urlContent;
        this.lifecycleOwner = weakReference;
        this.sceneType = sceneType;
        this.index = i3;
        this.paragraphIndex = i16;
        this.mViewSize = A();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoundCornerLayout>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter$mContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundCornerLayout invoke() {
                Context context2;
                View x16;
                ImageView w3;
                ImageView y16;
                context2 = LongFeedThirdVideoViewAdapter.this.context;
                RoundCornerLayout roundCornerLayout = new RoundCornerLayout(context2);
                LongFeedThirdVideoViewAdapter longFeedThirdVideoViewAdapter = LongFeedThirdVideoViewAdapter.this;
                x16 = longFeedThirdVideoViewAdapter.x();
                x16.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                roundCornerLayout.addView(x16);
                w3 = longFeedThirdVideoViewAdapter.w();
                w3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                w3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                roundCornerLayout.addView(w3);
                y16 = longFeedThirdVideoViewAdapter.y();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(30.0f), ViewUtils.dpToPx(30.0f));
                layoutParams.addRule(13, -1);
                y16.setLayoutParams(layoutParams);
                roundCornerLayout.setGravity(17);
                y16.setRotation(0.0f);
                y16.setImageResource(R.drawable.f160545jt);
                roundCornerLayout.addView(y16);
                float dpToPx = ViewUtils.dpToPx(6.0f);
                roundCornerLayout.setRadius(dpToPx, dpToPx, dpToPx, dpToPx);
                return roundCornerLayout;
            }
        });
        this.mContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FeedThirdVideoTextureView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter$mPlayView$2

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedThirdVideoViewAdapter$mPlayView$2$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "", "loadSucceed", "", "code", "", "msg", "onError", "", RemoteWebViewEvent.OPEN_FULL_SCREEN, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ LongFeedThirdVideoViewAdapter f221548a;

                a(LongFeedThirdVideoViewAdapter longFeedThirdVideoViewAdapter) {
                    this.f221548a = longFeedThirdVideoViewAdapter;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void c(LongFeedThirdVideoViewAdapter this$0) {
                    ImageView w3;
                    ImageView y16;
                    FeedThirdVideoTextureView x16;
                    FeedThirdVideoTextureView x17;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    w3 = this$0.w();
                    w3.setVisibility(8);
                    y16 = this$0.y();
                    y16.setVisibility(8);
                    x16 = this$0.x();
                    x16.setOpaque(true);
                    x17 = this$0.x();
                    x17.setAlpha(1.0f);
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
                public void a(boolean openFullScreen) {
                    FeedThirdVideoTextureView x16;
                    FeedThirdVideoTextureView x17;
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    x16 = this.f221548a.x();
                    String f16 = x16.f();
                    x17 = this.f221548a.x();
                    simpleEventBus.dispatchEvent(new FeedThirdVideoFullScreenEvent(openFullScreen, f16, x17.e()));
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
                public void loadSucceed() {
                    ImageView w3;
                    w3 = this.f221548a.w();
                    final LongFeedThirdVideoViewAdapter longFeedThirdVideoViewAdapter = this.f221548a;
                    w3.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE 
                          (r0v1 'w3' android.widget.ImageView)
                          (wrap:java.lang.Runnable:0x000a: CONSTRUCTOR 
                          (r1v0 'longFeedThirdVideoViewAdapter' com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter A[DONT_INLINE])
                         A[MD:(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter):void (m), WRAPPED] (LINE:11) call: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.i.<init>(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter):void type: CONSTRUCTOR)
                          (500 long)
                         VIRTUAL call: android.view.View.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:16) in method: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter$mPlayView$2.a.loadSucceed():void, file: classes13.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.i, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter r0 = r5.f221548a
                        android.widget.ImageView r0 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter.n(r0)
                        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter r1 = r5.f221548a
                        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.i r2 = new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.i
                        r2.<init>(r1)
                        r3 = 500(0x1f4, double:2.47E-321)
                        r0.postDelayed(r2, r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter$mPlayView$2.a.loadSucceed():void");
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.c
                public void onError(int code, @Nullable String msg2) {
                    ImageView w3;
                    ImageView y16;
                    FeedThirdVideoTextureView x16;
                    FeedThirdVideoTextureView x17;
                    w3 = this.f221548a.w();
                    w3.setVisibility(0);
                    y16 = this.f221548a.y();
                    y16.setVisibility(0);
                    x16 = this.f221548a.x();
                    x16.setOpaque(false);
                    x17 = this.f221548a.x();
                    x17.setAlpha(0.0f);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedThirdVideoTextureView invoke() {
                Context context2;
                Pair pair;
                context2 = LongFeedThirdVideoViewAdapter.this.context;
                pair = LongFeedThirdVideoViewAdapter.this.mViewSize;
                return new FeedThirdVideoTextureView(context2, "GuildFeed", null, pair, new a(LongFeedThirdVideoViewAdapter.this));
            }
        });
        this.mPlayView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter$mCoverView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context context2;
                context2 = LongFeedThirdVideoViewAdapter.this.context;
                return new ImageView(context2);
            }
        });
        this.mCoverView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter$mProgressView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context context2;
                context2 = LongFeedThirdVideoViewAdapter.this.context;
                return new ImageView(context2);
            }
        });
        this.mProgressView = lazy4;
    }

    private final Pair<Integer, Integer> A() {
        int d16 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.d(this.sceneType);
        return new Pair<>(Integer.valueOf(d16), Integer.valueOf((int) (d16 * 0.625d)));
    }

    private final void B() {
        this.mViewSize = A();
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h hVar = this.mViewSizeChangedNotifier;
        if (hVar != null) {
            hVar.a();
        }
    }

    private final void C(Object data) {
        Boolean bool;
        boolean z16;
        if (data instanceof Boolean) {
            bool = (Boolean) data;
        } else {
            bool = null;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        QLog.i("LongFeedThirdVideoViewAdapter", 1, "[handlePageAnimation] isAnimating: " + z16);
        if (z16) {
            this.mDelayLoad = true;
            return;
        }
        this.mDelayLoad = false;
        if (this.mViewCreated) {
            s();
        }
    }

    private final void D() {
        LifecycleOwner lifecycleOwner;
        x().setOpaque(false);
        x().setAlpha(0.0f);
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference != null && (lifecycleOwner = weakReference.get()) != null) {
            x().d(lifecycleOwner);
        }
        FeedThirdVideoTextureView x16 = x();
        String str = this.urlContent.playUrl;
        Intrinsics.checkNotNullExpressionValue(str, "urlContent.playUrl");
        x16.h(str);
    }

    private final void E() {
        Drawable t16 = t();
        com.tencent.mobileqq.guild.picload.e.a().f(Option.obtain().setTargetView(w()).setNeedFilterUrl(false).setPredecode(true).setUrl(this.urlContent.getThirdVideoInfo().cover).setRequestWidth(getWidth()).setRequestHeight(getHeight()).setLoadingDrawable(t16).setFailDrawable(t16), new b());
    }

    private final void F() {
        w().setImageDrawable(t());
    }

    private final void s() {
        if (this.mDelayLoad) {
            QLog.i("LongFeedThirdVideoViewAdapter", 1, "[doInit] delay load.");
            return;
        }
        if (!this.mInited) {
            E();
            D();
        }
        this.mInited = true;
    }

    private final Drawable t() {
        List<String> listOf;
        GuildFeedImagePreDecoder guildFeedImagePreDecoder = GuildFeedImagePreDecoder.INSTANCE;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.urlContent.getThirdVideoInfo().cover);
        BitmapDrawable bitmapDrawable = guildFeedImagePreDecoder.get(listOf);
        if (bitmapDrawable == null) {
            return new ColorDrawable(-10065297);
        }
        return bitmapDrawable;
    }

    private final RoundCornerLayout v() {
        return (RoundCornerLayout) this.mContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView w() {
        return (ImageView) this.mCoverView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedThirdVideoTextureView x() {
        return (FeedThirdVideoTextureView) this.mPlayView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView y() {
        return (ImageView) this.mProgressView.getValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    public int b() {
        return h.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    @NotNull
    public View c(@Nullable com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h viewSizeChangedNotifier) {
        TraceUtils.h("thirdV-load");
        F();
        s();
        this.mViewSizeChangedNotifier = viewSizeChangedNotifier;
        this.mViewCreated = true;
        TraceUtils.k();
        return v();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void f(@Nullable String event, @Nullable Object data) {
        if (Intrinsics.areEqual(event, "EVENT_TYPE_PAGE_ANIMATION")) {
            C(data);
        } else if (Intrinsics.areEqual(event, "EVENT_TYPE_CONFIGURATION_CHANGE")) {
            B();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void g(@Nullable View view) {
        super.g(view);
        QLog.i("LongFeedThirdVideoViewAdapter", 4, "[onViewVisible:ThirdVideo] url: " + this.urlContent.url);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getHeight() {
        return this.mViewSize.getSecond().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getWidth() {
        return this.mViewSize.getFirst().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public String j() {
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        String str = this.urlContent.playUrl;
        Intrinsics.checkNotNullExpressionValue(str, "urlContent.playUrl");
        return bVar.h(str, getIndex(), getParagraphIndex());
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public BaseLongFeedViewAdapter.TYPE k() {
        return BaseLongFeedViewAdapter.TYPE.THIRD_VIDEO;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    public boolean l() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void onDestroyView() {
        x().i();
    }

    /* renamed from: u, reason: from getter */
    public int getIndex() {
        return this.index;
    }

    /* renamed from: z, reason: from getter */
    public int getParagraphIndex() {
        return this.paragraphIndex;
    }
}
