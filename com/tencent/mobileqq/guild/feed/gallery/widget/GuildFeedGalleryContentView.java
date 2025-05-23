package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.imagebanner.ImageBanner;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryFirstPagerEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryItemTypeEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryPagerEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGallerySeekbarShowEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import hk1.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0001ZB\u001d\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J(\u0010!\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0004J\u0010\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\u0006\u0010&\u001a\u00020\u0002J\u0006\u0010'\u001a\u00020\u0004J\u0012\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(H\u0014J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010CR\u0016\u0010E\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010;R\u0016\u0010G\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010;R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryContentView;", "Landroid/widget/FrameLayout;", "", "position", "", "D", "bannerPos", "l", com.tencent.luggage.wxa.c8.c.G, BdhLogUtil.LogTag.Tag_Conn, "p", "Lcom/tencent/mobileqq/guild/feed/manager/f;", "selectFeedInfo", HippyTKDListViewAdapter.X, "panelHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lhk1/a$e;", "panelInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "unSelectFeedInfo", "y", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "u", "", "feedId", "r", "w", "v", DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "dataList", "setData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "setInitBean", "o", "B", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", ReportConstant.COSTREPORT_PREFIX, "t", "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/component/imagebanner/ImageBanner;", "e", "Lcom/tencent/mobileqq/guild/component/imagebanner/ImageBanner;", "mBanner", "Lfk1/a;", "f", "Lfk1/a;", "mBannerAdapter", "", tl.h.F, "Z", "forceUpdateFirstPos", "i", "Ljava/lang/String;", "mFirstFeedId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mCurrentBannerPos", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "mInitBean", "mIsPause", "E", "mIsDetachFromWindow", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "curContentImageView", "Lmk1/a;", "G", "Lmk1/a;", "animHelper", "Landroid/os/Handler;", "H", "Landroid/os/Handler;", "mainHandler", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryContentView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean mInitBean;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsPause;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsDetachFromWindow;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView curContentImageView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final mk1.a animHelper;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Handler mainHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageBanner mBanner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fk1.a mBannerAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean forceUpdateFirstPos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mFirstFeedId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCurrentBannerPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryContentView$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "bannerPos", "", "onPageSelected", "state", "onPageScrollStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            boolean z16;
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGallerySeekbarShowEvent(z16));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int bannerPos) {
            GuildFeedGalleryPagerEvent.GalleryPageScrollState galleryPageScrollState;
            String str;
            super.onPageSelected(bannerPos);
            GuildFeedGalleryContentView guildFeedGalleryContentView = GuildFeedGalleryContentView.this;
            guildFeedGalleryContentView.curContentImageView = guildFeedGalleryContentView.mBannerAdapter.s0(bannerPos);
            if (GuildFeedGalleryContentView.this.mCurrentBannerPos != bannerPos && GuildFeedGalleryContentView.this.mCurrentBannerPos != Integer.MIN_VALUE) {
                if (GuildFeedGalleryContentView.this.mIsPause) {
                    QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[onPageSelected] when isPause. ignored");
                    return;
                }
                if (bannerPos > GuildFeedGalleryContentView.this.mCurrentBannerPos) {
                    galleryPageScrollState = GuildFeedGalleryPagerEvent.GalleryPageScrollState.SCROLL_TO_RIGHT;
                } else {
                    galleryPageScrollState = GuildFeedGalleryPagerEvent.GalleryPageScrollState.SCROLL_TO_LEFT;
                }
                if (GuildFeedGalleryContentView.this.mCurrentBannerPos != bannerPos) {
                    GuildFeedGalleryContentView guildFeedGalleryContentView2 = GuildFeedGalleryContentView.this;
                    guildFeedGalleryContentView2.D(guildFeedGalleryContentView2.mCurrentBannerPos);
                    QLog.d("Guild_Feed_GAL_GuildFeedGalleryContentView", 4, "[onPageSelected] " + bannerPos + ", total: " + GuildFeedGalleryContentView.this.mBannerAdapter.k0());
                    String str2 = GuildFeedGalleryContentView.this.mFirstFeedId;
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean = GuildFeedGalleryContentView.this.mInitBean;
                    String str3 = null;
                    if (guildFeedGalleryInitBean != null) {
                        str = guildFeedGalleryInitBean.getFeedId();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str2, str) && GuildFeedGalleryContentView.this.forceUpdateFirstPos) {
                        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryFirstPagerEvent(GuildFeedGalleryContentView.this.mFirstFeedId, bannerPos), true);
                    }
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    int k06 = GuildFeedGalleryContentView.this.mBannerAdapter.k0();
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = GuildFeedGalleryContentView.this.mInitBean;
                    if (guildFeedGalleryInitBean2 != null) {
                        str3 = guildFeedGalleryInitBean2.getFeedId();
                    }
                    simpleEventBus.dispatchEvent(new GuildFeedGalleryPagerEvent(bannerPos, k06, str3, galleryPageScrollState));
                }
                GuildFeedGalleryContentView.this.l(bannerPos);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryContentView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C(int pos) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.mBannerAdapter.getRecyclerView().findViewHolderForAdapterPosition(pos);
        if (findViewHolderForAdapterPosition == null) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "setVideoType viewHolder == null");
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryItemTypeEvent(findViewHolderForAdapterPosition instanceof com.tencent.mobileqq.guild.feed.gallery.widget.item.n ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(final int position) {
        this.mainHandler.removeCallbacksAndMessages(null);
        this.mainHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryContentView.E(GuildFeedGalleryContentView.this, position);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(GuildFeedGalleryContentView this$0, int i3) {
        QCircleMultiTouchImageView qCircleMultiTouchImageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView s06 = this$0.mBannerAdapter.s0(i3);
        if (s06 instanceof QCircleMultiTouchImageView) {
            qCircleMultiTouchImageView = (QCircleMultiTouchImageView) s06;
        } else {
            qCircleMultiTouchImageView = null;
        }
        if (qCircleMultiTouchImageView != null) {
            qCircleMultiTouchImageView.setScale(1.0f, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final int bannerPos) {
        boolean z16 = this.mIsPause;
        if (!z16 && !this.mIsDetachFromWindow) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedGalleryContentView.m(bannerPos, this);
                }
            });
            return;
        }
        QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[dispatchHolderLifecycle] isPause:" + z16 + ", detach:" + this.mIsDetachFromWindow + ". ignore");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(int i3, GuildFeedGalleryContentView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[dispatchHolderLifecycle] select:: " + i3 + ", unselect: " + this$0.mCurrentBannerPos);
        this$0.mBannerAdapter.y0(i3);
        int i16 = this$0.mCurrentBannerPos;
        if (i3 != i16 && i16 >= 0) {
            this$0.mBannerAdapter.x0(i16);
        }
        this$0.mCurrentBannerPos = i3;
        this$0.C(i3);
    }

    public final void A(@NotNull a.PanelHeightChangeEventDataArgs panelInfo) {
        Intrinsics.checkNotNullParameter(panelInfo, "panelInfo");
        this.animHelper.e(panelInfo);
    }

    public final void B() {
        this.mBannerAdapter.B0();
    }

    public final void n() {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[doRequestItemLayout] mCurrentBannerPos: " + this.mCurrentBannerPos);
        int i3 = this.mCurrentBannerPos;
        if (i3 == Integer.MIN_VALUE) {
            return;
        }
        boolean t06 = this.mBannerAdapter.t0(i3);
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[doRequestItemLayout] needRequestLayout: " + t06);
        if (t06) {
            this.mBannerAdapter.notifyItemChanged(this.mCurrentBannerPos);
            l(this.mCurrentBannerPos);
        }
    }

    /* renamed from: o, reason: from getter */
    public final int getMCurrentBannerPos() {
        return this.mCurrentBannerPos;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        boolean z16;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 4, "[onConfigurationChanged]");
        if (this.mCurrentBannerPos != Integer.MIN_VALUE) {
            int currentItem = this.mBanner.S().getCurrentItem();
            int num_backgournd_icon = this.mBannerAdapter.getNUM_BACKGOURND_ICON();
            Integer valueOf = Integer.valueOf(currentItem + 1);
            boolean z17 = true;
            if (valueOf.intValue() < num_backgournd_icon) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView recyclerView = null;
            if (!z16) {
                valueOf = null;
            }
            if (valueOf == null) {
                valueOf = Integer.valueOf(currentItem - 1);
                if (valueOf.intValue() < 0 || currentItem >= num_backgournd_icon) {
                    z17 = false;
                }
                if (!z17) {
                    valueOf = null;
                }
                if (valueOf == null) {
                    return;
                }
            }
            int intValue = valueOf.intValue();
            View childAt = this.mBanner.S().getChildAt(0);
            if (childAt instanceof RecyclerView) {
                recyclerView = (RecyclerView) childAt;
            }
            if (recyclerView != null) {
                recyclerView.scrollToPosition(intValue);
                recyclerView.scrollToPosition(currentItem);
            }
        }
    }

    public final void p() {
        this.mBannerAdapter.setEnableLoop(false);
        this.mBanner.S().setOffscreenPageLimit(1);
        this.mBanner.setAdapter(this.mBannerAdapter);
        this.mBanner.setBackgroundColor(getResources().getColor(R.color.black));
        this.mBanner.i0(new b());
        this.mBanner.S().setOverScrollMode(2);
    }

    public final void q() {
        this.mCurrentBannerPos = Integer.MIN_VALUE;
    }

    public final void r(@Nullable String feedId) {
        this.mFirstFeedId = feedId;
    }

    public final void s() {
        this.mIsDetachFromWindow = false;
    }

    public final void setData(@Nullable GProStFeed feed, @Nullable List<? extends GuildFeedRichMediaData> dataList, int position) {
        Integer num;
        if (dataList != null) {
            num = Integer.valueOf(dataList.size());
        } else {
            num = null;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[setData] dataListSize: " + num);
        this.mBannerAdapter.C0(feed, dataList, position);
    }

    public final void setInitBean(@Nullable GuildFeedGalleryInitBean initBean) {
        String str;
        if (initBean != null) {
            str = initBean.getFeedId();
        } else {
            str = null;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[setInitBean] " + str);
        this.mInitBean = initBean;
        this.mBannerAdapter.D0(initBean);
    }

    public final void t() {
        this.mIsDetachFromWindow = true;
        this.mainHandler.removeCallbacksAndMessages(null);
        this.mBannerAdapter.v0();
        if (this.mBanner.S().getCurrentItem() > 0) {
            this.forceUpdateFirstPos = false;
            this.mBanner.setCurrentItem(0, true);
        }
    }

    public final void u(@Nullable GProStFeed feed) {
        this.mBannerAdapter.w0(feed);
    }

    public final void v() {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[onFeedGalleryPause] ");
        this.mIsPause = true;
        B();
    }

    public final void w() {
        RecyclerView.LayoutManager layoutManager;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[onFeedGalleryResume] ");
        this.mIsPause = false;
        RecyclerView recyclerView = this.mBannerAdapter.getRecyclerView();
        LinearLayoutManager linearLayoutManager = null;
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager == null) {
            QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "[onFeedGalleryResume] layoutManager is null");
            return;
        }
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition < 0 || findLastCompletelyVisibleItemPosition < 0 || findFirstCompletelyVisibleItemPosition > findLastCompletelyVisibleItemPosition) {
            return;
        }
        while (true) {
            this.mBannerAdapter.y0(findFirstCompletelyVisibleItemPosition);
            if (findFirstCompletelyVisibleItemPosition != findLastCompletelyVisibleItemPosition) {
                findFirstCompletelyVisibleItemPosition++;
            } else {
                return;
            }
        }
    }

    public final void x(@Nullable com.tencent.mobileqq.guild.feed.manager.f selectFeedInfo) {
        GuildFeedGalleryInitBean initBean;
        if (selectFeedInfo == null) {
            return;
        }
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryContentView", 4, "[onFeedSelected] " + selectFeedInfo.c());
        int i3 = this.mCurrentBannerPos;
        if (i3 < 0) {
            jk1.a b16 = selectFeedInfo.b();
            if (b16 != null && (initBean = b16.getInitBean()) != null) {
                i3 = initBean.getEnterPos();
            } else {
                i3 = 0;
            }
        }
        this.mBanner.setCurrentItem(i3, false);
        this.mCurrentBannerPos = i3;
        l(i3);
    }

    public final void y(@Nullable com.tencent.mobileqq.guild.feed.manager.f unSelectFeedInfo) {
        Integer num;
        String str = null;
        if (unSelectFeedInfo != null) {
            num = Integer.valueOf(unSelectFeedInfo.c());
        } else {
            num = null;
        }
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryContentView", 4, "[onFeedUnSelected] " + num);
        if (unSelectFeedInfo != null) {
            String a16 = unSelectFeedInfo.a();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mInitBean;
            if (guildFeedGalleryInitBean != null) {
                str = guildFeedGalleryInitBean.getFeedId();
            }
            if (Intrinsics.areEqual(a16, str)) {
                this.mBannerAdapter.B0();
            }
        }
        D(this.mCurrentBannerPos);
    }

    public final void z(int panelHeight) {
        Drawable drawable;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentView", 1, "onPanelStartOpen panelHeight=" + panelHeight);
        ImageView imageView = this.curContentImageView;
        if (imageView != null) {
            if (imageView != null) {
                drawable = imageView.getDrawable();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                mk1.a aVar = this.animHelper;
                ImageBanner imageBanner = this.mBanner;
                ImageView imageView2 = this.curContentImageView;
                Intrinsics.checkNotNull(imageView2);
                aVar.d(imageBanner, imageView2);
            }
        }
    }

    public /* synthetic */ GuildFeedGalleryContentView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.f168074eo1, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ery_content_layout, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.wgf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026d_gallery_content_banner)");
        this.mBanner = (ImageBanner) findViewById;
        fk1.a aVar = new fk1.a();
        aVar.setHasStableIds(true);
        this.mBannerAdapter = aVar;
        this.forceUpdateFirstPos = true;
        this.mCurrentBannerPos = Integer.MIN_VALUE;
        this.animHelper = new mk1.a();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }
}
