package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseSceneType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x12.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0017BW\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020%\u0012\u0006\u0010)\u001a\u00020\u000e\u0012\u0006\u0010N\u001a\u00020\b\u0012\u0006\u0010O\u001a\u00020\b\u0012\u0006\u0010+\u001a\u00020\u000e\u0012\u0006\u0010-\u001a\u00020\b\u0012\u0006\u00100\u001a\u00020.\u0012\u0006\u00104\u001a\u00020\b\u0012\u0006\u00107\u001a\u00020\b\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0014\u0010)\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(R\u0014\u0010+\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010-\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/R\u001a\u00104\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103R\u001a\u00107\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b5\u0010,\u001a\u0004\b6\u00103R\u0014\u00108\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010,R\u0014\u00109\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010,R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010:R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010F\u001a\u0004\bG\u0010HR\u0011\u0010L\u001a\u00020J8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010KR\u0014\u0010M\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u00103\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedVideoCoverViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/h;", "", "u", "t", "Lkotlin/Pair;", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "viewSizeChangedNotifier", "Landroid/view/View;", "c", "", "event", "", "data", "f", "", "d", "Lkotlin/Function0;", "onLoaded", "a", "view", "g", "l", "getWidth", "getHeight", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/BaseLongFeedViewAdapter$TYPE;", "k", "j", "onDestroyView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "", UserInfo.SEX_FEMALE, "widthPercent", "Ljava/lang/String;", "coverUrl", "e", QFSEdgeItem.KEY_VIDEO_TIME, "I", "displayIndex", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "sceneType", tl.h.F, "p", "()I", "index", "i", "r", "paragraphIndex", "finalCoverWidth", "finalCoverHeight", "Z", "hadImageLoaded", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function0;", "onImageLoadedListener", DomainData.DOMAIN_NAME, "Lkotlin/Pair;", "mTargetSize", "o", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/h;", "mViewSizeChangedNotifier", "Lx12/u;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lx12/u;", "mBinding", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "mediaIndex", "coverWidth", "coverHeight", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;FLjava/lang/String;IILjava/lang/String;ILcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedVideoCoverViewAdapter extends BaseLongFeedViewAdapter implements com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h, h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongFeedParseParam parseParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float widthPercent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String coverUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int displayIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongFeedParseSceneType sceneType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int finalCoverWidth;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int finalCoverHeight;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean hadImageLoaded;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onImageLoadedListener;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> mTargetSize;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h mViewSizeChangedNotifier;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/LongFeedVideoCoverViewAdapter$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(false);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            boolean z16;
            Animatable animatable;
            String str;
            Logger logger = Logger.f235387a;
            String str2 = null;
            if (QLog.isDebugVersion()) {
                Logger.a d16 = logger.d();
                if (option != null) {
                    str = option.getUrl();
                } else {
                    str = null;
                }
                d16.d("LongFeedVideoCoverViewAdapter", 1, "loadImage state:" + state + " url:" + str);
            }
            boolean z17 = false;
            if (state != null && state.isFinishError()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (option != null) {
                    str2 = option.getUrl();
                }
                QLog.e("LongFeedVideoCoverViewAdapter", 1, "[loadImage] error: " + state + ", picUrl: " + str2);
            }
            if (state != null && state.isFinishSuccess()) {
                z17 = true;
            }
            if (z17) {
                if (option != null && (animatable = option.getAnimatable()) != null) {
                    animatable.start();
                }
                LongFeedVideoCoverViewAdapter.this.hadImageLoaded = true;
                Function0 function0 = LongFeedVideoCoverViewAdapter.this.onImageLoadedListener;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }

    public LongFeedVideoCoverViewAdapter(@NotNull LongFeedParseParam parseParam, float f16, @NotNull String coverUrl, int i3, int i16, @NotNull String videoTime, int i17, @NotNull LongFeedParseSceneType sceneType, int i18, int i19) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(videoTime, "videoTime");
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.parseParam = parseParam;
        this.widthPercent = f16;
        this.coverUrl = coverUrl;
        this.videoTime = videoTime;
        this.displayIndex = i17;
        this.sceneType = sceneType;
        this.index = i18;
        this.paragraphIndex = i19;
        i3 = i3 <= 0 ? com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.d(sceneType) : i3;
        this.finalCoverWidth = i3;
        this.finalCoverHeight = i16 <= 0 ? (int) (i3 * 0.625d) : i16;
        this.mTargetSize = s();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<u>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoCoverViewAdapter$mBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final u invoke() {
                return u.g(LayoutInflater.from(LongFeedVideoCoverViewAdapter.this.o()));
            }
        });
        this.mBinding = lazy;
    }

    private final u q() {
        return (u) this.mBinding.getValue();
    }

    private final Pair<Integer, Integer> s() {
        return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.f(this.finalCoverWidth, this.finalCoverHeight, this.widthPercent, this.sceneType);
    }

    private final void t() {
        this.mTargetSize = s();
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h hVar = this.mViewSizeChangedNotifier;
        if (hVar != null) {
            hVar.a();
        }
    }

    private final void u() {
        String str;
        Option loadingDrawable = Option.obtain().setTargetView(q().f447022c).setUrl(this.coverUrl).setRequestWidth(getWidth()).setRequestHeight(getHeight()).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            Logger.a d16 = logger.d();
            if (loadingDrawable != null) {
                str = loadingDrawable.getUrl();
            } else {
                str = null;
            }
            d16.d("LongFeedVideoCoverViewAdapter", 1, "loadImage start url:" + str);
        }
        com.tencent.mobileqq.guild.picload.e.a().f(loadingDrawable, new b());
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h
    public void a(@NotNull Function0<Unit> onLoaded) {
        Intrinsics.checkNotNullParameter(onLoaded, "onLoaded");
        this.onImageLoadedListener = onLoaded;
        if (this.hadImageLoaded) {
            onLoaded.invoke();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    /* renamed from: b, reason: from getter */
    public int getDisplayIndex() {
        return this.displayIndex;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    @NotNull
    public View c(@Nullable com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h viewSizeChangedNotifier) {
        boolean isBlank;
        int i3;
        this.mViewSizeChangedNotifier = viewSizeChangedNotifier;
        q().f447024e.setText(this.videoTime);
        FrameLayout frameLayout = q().f447023d;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.guildFeedVideoCoverBottomContainer");
        isBlank = StringsKt__StringsJVMKt.isBlank(this.videoTime);
        if (!isBlank) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        u();
        RadiusFrameLayout root = q().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h
    /* renamed from: d, reason: from getter */
    public boolean getHadImageLoaded() {
        return this.hadImageLoaded;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void f(@Nullable String event, @Nullable Object data) {
        if (Intrinsics.areEqual(event, "EVENT_TYPE_CONFIGURATION_CHANGE")) {
            t();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getHeight() {
        return this.mTargetSize.getSecond().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public int getWidth() {
        return this.mTargetSize.getFirst().intValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public String j() {
        return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.i(this.coverUrl, getIndex(), getParagraphIndex());
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    @NotNull
    public BaseLongFeedViewAdapter.TYPE k() {
        return BaseLongFeedViewAdapter.TYPE.VIDEO_COVER;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter
    public boolean l() {
        if (this.widthPercent >= 100.0f) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Context o() {
        Context context = this.parseParam.getTextViewContainer().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parseParam.textViewContainer.context");
        return context;
    }

    /* renamed from: p, reason: from getter */
    public int getIndex() {
        return this.index;
    }

    /* renamed from: r, reason: from getter */
    public int getParagraphIndex() {
        return this.paragraphIndex;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void onDestroyView() {
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g
    public void g(@Nullable View view) {
    }
}
