package ep0;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.guild.aio.input.at.trooptag.view.GuildHashTagItemListView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oo0.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u001f\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u00100\u001a\u00020.\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0016\u0010&\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00101R\u0018\u00103\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00101\u00a8\u00068"}, d2 = {"Lep0/a;", "Loo0/c$c;", "Loo0/c$d;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "pageType", "Lcom/tencent/guild/aio/input/at/trooptag/view/GuildHashTagItemListView;", h.F, "i", "g", "", "Lcp0/a;", "newDataList", "", "k", "Loo0/c$f;", "holder", "e", "", "position", "", "getPageTitle", "pageIndex", "onPageSelected", "getCount", "Landroid/view/View;", "view", "", "obj", "", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "j", "viewObject", "destroyItem", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "deltaScrollY", "currentTab", "f", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "d", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "panelContext", "Lfp0/b;", "Lfp0/b;", "style", "Lip0/b;", "Lip0/b;", "dataChangedListener", "Lcom/tencent/guild/aio/input/at/trooptag/view/GuildHashTagItemListView;", "channelListView", "troopListView", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;Lfp0/b;Lip0/b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends c.AbstractC10933c implements c.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fp0.b style;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ip0.b dataChangedListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHashTagItemListView channelListView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHashTagItemListView troopListView;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f396921a;

        static {
            int[] iArr = new int[HashTagPageType.values().length];
            try {
                iArr[HashTagPageType.Troop_Page.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HashTagPageType.Channel_Page.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f396921a = iArr;
        }
    }

    public a(@NotNull com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext, @NotNull fp0.b style, @NotNull ip0.b dataChangedListener) {
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(dataChangedListener, "dataChangedListener");
        this.panelContext = panelContext;
        this.style = style;
        this.dataChangedListener = dataChangedListener;
    }

    private final GuildHashTagItemListView g() {
        if (this.channelListView == null) {
            GuildHashTagItemListView guildHashTagItemListView = new GuildHashTagItemListView(this.panelContext, this.style, null, 0, 12, null);
            guildHashTagItemListView.C(this.dataChangedListener);
            this.channelListView = guildHashTagItemListView;
        }
        GuildHashTagItemListView guildHashTagItemListView2 = this.channelListView;
        Intrinsics.checkNotNull(guildHashTagItemListView2);
        return guildHashTagItemListView2;
    }

    private final GuildHashTagItemListView h(HashTagPageType pageType) {
        int i3 = b.f396921a[pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return g();
            }
            return g();
        }
        return i();
    }

    private final GuildHashTagItemListView i() {
        if (this.troopListView == null) {
            GuildHashTagItemListView guildHashTagItemListView = new GuildHashTagItemListView(this.panelContext, this.style, null, 0, 12, null);
            guildHashTagItemListView.C(this.dataChangedListener);
            this.troopListView = guildHashTagItemListView;
        }
        GuildHashTagItemListView guildHashTagItemListView2 = this.troopListView;
        Intrinsics.checkNotNull(guildHashTagItemListView2);
        return guildHashTagItemListView2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object viewObject) {
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(viewObject, "viewObject");
        if (viewObject instanceof View) {
            view = (View) viewObject;
        } else {
            view = null;
        }
        if (view != null) {
            container.removeView(view);
        }
    }

    @Override // oo0.c.AbstractC10933c
    public void e(@NotNull c.f holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public final boolean f(int deltaScrollY, int currentTab) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.panelContext.j(), currentTab);
        HashTagPageType hashTagPageType = (HashTagPageType) orNull;
        if (hashTagPageType == null) {
            hashTagPageType = HashTagPageType.Channel_Page;
        }
        return h(hashTagPageType).canScrollVertically(deltaScrollY);
    }

    @Override // oo0.c.AbstractC10933c, androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.panelContext.j().size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public CharSequence getPageTitle(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.panelContext.j(), position);
        HashTagPageType hashTagPageType = (HashTagPageType) orNull;
        if (hashTagPageType == null) {
            hashTagPageType = HashTagPageType.Channel_Page;
        }
        return hashTagPageType.getTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public View instantiateItem(@NotNull ViewGroup container, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(container, "container");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.panelContext.j(), position);
        HashTagPageType hashTagPageType = (HashTagPageType) orNull;
        if (hashTagPageType == null) {
            hashTagPageType = HashTagPageType.Channel_Page;
        }
        GuildHashTagItemListView h16 = h(hashTagPageType);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
        h16.setPadding(0, 0, 0, this.style.getDimen().getFullStatusTopPadding());
        container.addView(h16, layoutParams);
        return h16;
    }

    public final void k(@NotNull HashTagPageType pageType, @NotNull List<? extends cp0.a> newDataList) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        h(pageType).E(newDataList);
    }

    @Override // oo0.c.AbstractC10933c
    public void onDestroy() {
        super.onDestroy();
        GuildHashTagItemListView guildHashTagItemListView = this.channelListView;
        if (guildHashTagItemListView != null) {
            guildHashTagItemListView.D();
        }
        GuildHashTagItemListView guildHashTagItemListView2 = this.troopListView;
        if (guildHashTagItemListView2 != null) {
            guildHashTagItemListView2.D();
        }
        this.channelListView = null;
        this.troopListView = null;
    }

    @Override // oo0.c.d
    public void onPageSelected(int pageIndex) {
    }
}
