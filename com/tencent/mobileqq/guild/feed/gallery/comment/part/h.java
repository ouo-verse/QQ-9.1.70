package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.gallery.part.f;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DataChangedState;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailCommentViewModel;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.LoadDataArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.x;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import hk1.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002fj\u0018\u0000 r2\u00020\u0001:\u0001sB\u0011\u0012\b\u0010o\u001a\u0004\u0018\u00010n\u00a2\u0006\u0004\bp\u0010qJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010 \u001a\u00020\u00022\u001a\u0010\u001f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001e0\u001dH\u0002J\u001a\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010$\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020&H\u0002J\u0012\u0010(\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010+\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010,\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0002H\u0002J\b\u0010/\u001a\u00020\u0002H\u0002J\b\u00100\u001a\u00020\u0002H\u0002J\u0018\u00103\u001a\u00020\u00022\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020\u0002H\u0002J\u0010\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0016J\u0012\u0010;\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u001e\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010?\u001a\u00020\u00022\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010B\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020S0Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010UR(\u0010e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001e0\u001d8CX\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010l\u00a8\u0006t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/h;", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/a;", "", "ma", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/x;", "state", "aa", "Z9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/c;", "U9", "", "source", "ca", "T9", "", "args", "Y9", "msg", "ba", "Ltl1/g$aa;", "reloadMessage", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "S9", "message", "V9", "Ltl1/g$l;", "", "O9", "da", "Ljava/util/Queue;", "Lkotlin/Pair;", "changeSourceList", "P9", "dataChangedSource", "payload", "wa", "X9", "xa", "Landroid/view/ViewGroup;", "ga", "ea", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "ha", "ia", LocaleUtils.L_JAPANESE, "R9", "la", "ua", "ta", "dx", "dy", "sa", "Q9", "va", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "action", "getMessage", "handleBroadcastMessage", "f", "Landroid/view/ViewGroup;", "commentContentView", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "i", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "safeLayoutManager", "Lhl1/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lhl1/f;", "contentAdapter", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "defaultAnimator", "Ljava/util/concurrent/atomic/AtomicBoolean;", "D", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFirstLoadingComment", "E", "isLoadingMore", "Landroid/util/SparseArray;", UserInfo.SEX_FEMALE, "Landroid/util/SparseArray;", "isReloadingFlags", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailCommentViewModel;", "G", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailCommentViewModel;", "viewMode", "H", "isBlockUpScreen", "I", "Ljava/util/Queue;", "submitCallbackClosureQueue", "com/tencent/mobileqq/guild/feed/gallery/comment/part/h$b", "J", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/h$b;", "childHelperApiIoc", "com/tencent/mobileqq/guild/feed/gallery/comment/part/h$d", "K", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/h$d;", "onScrollerListener", "Lgk1/b;", "contextProvider", "<init>", "(Lgk1/b;)V", "L", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecyclerView.ItemAnimator defaultAnimator;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isFirstLoadingComment;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isLoadingMore;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final SparseArray<AtomicBoolean> isReloadingFlags;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private DetailCommentViewModel viewMode;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean isBlockUpScreen;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Queue<Pair<Integer, Object>> submitCallbackClosureQueue;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b childHelperApiIoc;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private d onScrollerListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup commentContentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SafeLinearLayoutManager safeLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private hl1.f contentAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/h$b", "Lvi1/g;", "", "position", "Landroid/view/View;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements vi1.g {
        b() {
        }

        @Override // vi1.g
        @Nullable
        public View a(int position) {
            int i3;
            RecyclerView.LayoutManager layoutManager;
            List<hl1.g> items;
            if (position >= 0) {
                hl1.f fVar = h.this.contentAdapter;
                if (fVar != null && (items = fVar.getItems()) != null) {
                    i3 = items.size();
                } else {
                    i3 = 0;
                }
                if (position < i3) {
                    if (h.this.recyclerView != null) {
                        RecyclerView recyclerView = h.this.recyclerView;
                        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                            return null;
                        }
                        return layoutManager.findViewByPosition(position);
                    }
                    QLog.w("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "getChild |check calling time!");
                    return null;
                }
            }
            QLog.w("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "getChild an invalid Position: " + position);
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f219600a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f219601b;

        public c(ViewModelStoreOwner viewModelStoreOwner, h hVar) {
            this.f219600a = viewModelStoreOwner;
            this.f219601b = hVar;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            DetailCommentViewModel.Companion.Config config = new DetailCommentViewModel.Companion.Config(0, 1, null);
            config.b(this.f219601b.z9().getCommentCount());
            TimedValue timedValue = new TimedValue(new DetailCommentViewModel(config), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/h$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0) {
                if (newState == 1 || newState == 2) {
                    AbstractGifImage.pauseAll();
                    ApngImage.pauseAll();
                    URLDrawable.pause();
                    return;
                }
                return;
            }
            AbstractGifImage.resumeAll();
            ApngImage.resumeAll();
            URLDrawable.resume();
            h.this.ua();
            h.this.ta();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            h.this.sa(dx5, dy5);
        }
    }

    public h(@Nullable gk1.b bVar) {
        super(bVar);
        this.isFirstLoadingComment = new AtomicBoolean(false);
        this.isLoadingMore = new AtomicBoolean(false);
        SparseArray<AtomicBoolean> sparseArray = new SparseArray<>();
        sparseArray.append(2, new AtomicBoolean(false));
        this.isReloadingFlags = sparseArray;
        this.isBlockUpScreen = new AtomicBoolean(false);
        this.submitCallbackClosureQueue = new LinkedList();
        this.childHelperApiIoc = new b();
        this.onScrollerListener = new d();
    }

    private final boolean O9(g.OnDataListChangedMessage msg2) {
        if (msg2.getChangedSource() != 11) {
            Boolean bool = null;
            Object broadcastGetMessage = broadcastGetMessage("message_get_comment_can_up_screen", null);
            if (broadcastGetMessage instanceof Boolean) {
                bool = (Boolean) broadcastGetMessage;
            }
            if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                return false;
            }
        }
        return true;
    }

    private final void P9(Queue<Pair<Integer, Object>> changeSourceList) {
        Iterator<T> it = changeSourceList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            wa(((Number) pair.getFirst()).intValue(), pair.getSecond());
        }
    }

    private final int Q9() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        return 0;
    }

    private final LoadDataArgs R9() {
        GuildGalleryCommentPanelParams z95 = z9();
        return new LoadDataArgs("load_data_call_source_init", z95.getFeedId(), z95.getGuildId(), z95.getChannelId(), 0, z95.getLastModifiedTime(), null, null, B9().getNeedInsertCommentID(), null, B9().getNeedInsertCommentIDS(), System.currentTimeMillis(), 0, false, 13008, null);
    }

    private final LoadDataArgs S9(g.ReloadMessage reloadMessage) {
        if (reloadMessage.getVmIdentifier() == 2 && (reloadMessage.getPayload() instanceof g.ReloadCommentDataMessage)) {
            LoadDataArgs R9 = R9();
            R9.n("load_data_call_source_init");
            R9.o(((g.ReloadCommentDataMessage) reloadMessage.getPayload()).getType());
            return R9;
        }
        return null;
    }

    private final void T9(x state) {
        broadcastMessage(state.getMessage(), state.getMsgObject());
    }

    private final void U9(DataChangedState state) {
        DetailCommentViewModel detailCommentViewModel = this.viewMode;
        if (detailCommentViewModel != null) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "OnDataListChangedMessage source " + state.getDataChangedSource());
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(detailCommentViewModel.i());
            broadcastMessage("message_data_list_changed", new g.OnDataListChangedMessage(arrayList, state.getDataChangedSource(), state.getPayload()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.util.Collection, java.util.ArrayList] */
    private final void V9(Object message) {
        boolean z16;
        if (!(message instanceof g.OnDataListChangedMessage)) {
            return;
        }
        g.OnDataListChangedMessage onDataListChangedMessage = (g.OnDataListChangedMessage) message;
        xa(onDataListChangedMessage);
        this.submitCallbackClosureQueue.offer(TuplesKt.to(Integer.valueOf(onDataListChangedMessage.getChangedSource()), onDataListChangedMessage.getPayload()));
        boolean z17 = true;
        if (!O9(onDataListChangedMessage)) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "handleDataListChanged canUpScreen not changedSource:" + onDataListChangedMessage.getChangedSource());
            this.isBlockUpScreen.set(true);
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        List<hl1.g> b16 = onDataListChangedMessage.b();
        boolean isEmpty = b16.isEmpty();
        T t16 = b16;
        if (isEmpty) {
            t16 = 0;
        }
        objectRef.element = t16;
        if (t16 != 0) {
            ?? arrayList = new ArrayList();
            for (Object obj : (Iterable) t16) {
                if (!(((hl1.g) obj) instanceof jl1.f)) {
                    arrayList.add(obj);
                }
            }
            objectRef.element = arrayList;
        }
        hl1.f fVar = this.contentAdapter;
        if (fVar != null) {
            fVar.setItems((List) objectRef.element, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.b
                @Override // java.lang.Runnable
                public final void run() {
                    h.W9(h.this, objectRef);
                }
            });
        }
        gk1.b contextProvide = getContextProvide();
        if (contextProvide != null && contextProvide.getBusinessType() == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            gk1.b contextProvide2 = getContextProvide();
            if (contextProvide2 == null || contextProvide2.getBusinessType() != 15) {
                z17 = false;
            }
            if (!z17) {
                return;
            }
        }
        va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(h this$0, Ref.ObjectRef dataList) {
        Integer num;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        LinkedList linkedList = new LinkedList(this$0.submitCallbackClosureQueue);
        this$0.submitCallbackClosureQueue.clear();
        List list = (List) dataList.element;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "itemCount=" + num + " flush queue: " + linkedList);
        List list2 = (List) dataList.element;
        if (list2 != null) {
            i3 = list2.size();
        } else {
            i3 = 0;
        }
        this$0.broadcastMessage("message_data_changed_render_on_screen", new g.OnDataChangedRenderOnScreenMessage(i3, linkedList));
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (tl1.f.f436523a.a().contains(pair.getFirst()) && ((Number) pair.getFirst()).intValue() != 11) {
                this$0.broadcastMessage("message_update_load_more_view_visible", null);
            }
        }
        this$0.P9(linkedList);
    }

    private final void X9(Object msg2) {
        String str;
        if (!(msg2 instanceof g.OnItemDataChangedMessage)) {
            if (msg2 != null) {
                str = msg2.getClass().getName();
            } else {
                str = null;
            }
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "handleItemDataChanged|args type error, " + str);
            return;
        }
        hl1.f fVar = this.contentAdapter;
        if (fVar != null) {
            g.OnItemDataChangedMessage onItemDataChangedMessage = (g.OnItemDataChangedMessage) msg2;
            fVar.notifyItemChanged(onItemDataChangedMessage.getPosition(), onItemDataChangedMessage.getPayload());
        }
    }

    private final void Y9(Object args) {
        if (!(args instanceof g.LoadMoreMessage)) {
            return;
        }
        boolean z16 = this.isFirstLoadingComment.get();
        boolean z17 = this.isReloadingFlags.get(2).get();
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "handleLoadMoreMessage, isFirstLoading=" + z16 + ", isReloadingFromComment=" + z17);
        if (!z16 && !z17 && this.isLoadingMore.compareAndSet(false, true)) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "do loadMore");
            GuildGalleryCommentPanelParams z95 = z9();
            LoadDataArgs loadDataArgs = new LoadDataArgs(((g.LoadMoreMessage) args).getCallSource(), z95.getFeedId(), z95.getGuildId(), z95.getChannelId(), 0, 0L, null, null, null, null, null, 0L, 0, false, 16368, null);
            broadcastMessage("message_on_load_more_begin", new g.OnLoadMoreBeginMessage(loadDataArgs.getCallSource()));
            DetailCommentViewModel detailCommentViewModel = this.viewMode;
            if (detailCommentViewModel != null) {
                detailCommentViewModel.s(loadDataArgs);
            }
        }
    }

    private final void Z9(x state) {
        if (this.isLoadingMore.compareAndSet(true, false)) {
            broadcastMessage(state.getMessage(), state.getMsgObject());
        }
    }

    private final void aa(x state) {
        if (Intrinsics.areEqual(state.getMessage(), "message_on_load_comment_completed")) {
            this.isFirstLoadingComment.compareAndSet(true, false);
        }
        broadcastMessage(state.getMessage(), state.getMsgObject());
    }

    private final void ba(Object msg2) {
        DetailCommentViewModel detailCommentViewModel;
        if (!(msg2 instanceof g.ReloadMessage)) {
            return;
        }
        g.ReloadMessage reloadMessage = (g.ReloadMessage) msg2;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 4, "handleReloadMessage, callsource=" + reloadMessage.getCallSource() + ", vmIdentifier = " + reloadMessage.getVmIdentifier() + ",  isReloadingFlags[msg.vmIdentifier] = " + this.isReloadingFlags.get(reloadMessage.getVmIdentifier()));
        LoadDataArgs S9 = S9(reloadMessage);
        if (S9 == null) {
            return;
        }
        if (this.isReloadingFlags.get(reloadMessage.getVmIdentifier()).compareAndSet(false, true)) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 4, "after set, sReloadingFlags[msg.vmIdentifier] = " + this.isReloadingFlags.get(reloadMessage.getVmIdentifier()));
            broadcastMessage("message_on_reload_begin", new g.OnReloadBeginMessage(reloadMessage.getVmIdentifier()));
            if (reloadMessage.getVmIdentifier() == 2 && (detailCommentViewModel = this.viewMode) != null) {
                detailCommentViewModel.t0(S9);
            }
        }
        this.isLoadingMore.set(false);
    }

    private final void ca(int source, x state) {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 4, "handleReloadStateChanged , sReloadingFlags[msg.vmIdentifier] = " + this.isReloadingFlags.get(source));
        if (this.isReloadingFlags.get(source).compareAndSet(true, false)) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 4, "handleReloadStateChanged , update false");
            broadcastMessage(state.getMessage(), state.getMsgObject());
        }
    }

    private final void da(Object msg2) {
        if (this.isBlockUpScreen.compareAndSet(true, false)) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, "handlerCommentUpScreen");
            U9(new DataChangedState(14, null, 2, null));
        }
    }

    private final boolean ea(Object args) {
        RecyclerView recyclerView;
        if (!(args instanceof Integer) || (recyclerView = this.recyclerView) == null) {
            return false;
        }
        return recyclerView.canScrollVertically(((Number) args).intValue());
    }

    private final ViewGroup ga() {
        if (this.commentContentView == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.eny, (ViewGroup) null, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            this.commentContentView = (ViewGroup) inflate;
            la();
        }
        ViewGroup viewGroup = this.commentContentView;
        Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type android.view.ViewGroup");
        return viewGroup;
    }

    private final a.OnCommentMainFeedDataResult ha(Object args) {
        f.SendInputContentExtData sendInputContentExtData;
        GuildGalleryCommentPanelParams z95 = z9();
        if (args instanceof f.SendInputContentExtData) {
            sendInputContentExtData = (f.SendInputContentExtData) args;
        } else {
            sendInputContentExtData = null;
        }
        if (sendInputContentExtData != null) {
            String guildId = z95.getGuildId();
            String channelId = z95.getChannelId();
            String feedId = z95.getFeedId();
            if (!Intrinsics.areEqual(sendInputContentExtData.getGuildId(), guildId.toString()) || !Intrinsics.areEqual(sendInputContentExtData.getChannelId(), channelId.toString()) || !Intrinsics.areEqual(sendInputContentExtData.getFeedId(), feedId)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "handlerGetCommentFeedMainData sendExtData and curItem not match sendExtData:" + sendInputContentExtData + " curGuildId:" + guildId + " curChannelId:" + channelId + " curFeedId:" + feedId;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryCommentContentPart", 1, (String) it.next(), null);
                }
                return null;
            }
        }
        a.OnCommentMainFeedDataResult onCommentMainFeedDataResult = new a.OnCommentMainFeedDataResult(null, 1, null);
        onCommentMainFeedDataResult.b(new a.CommentMainFeedData(z95.getGuildId(), z95.getChannelId(), z95.getFeedId(), z95.getCreatedTime(), z95.getPosterId()));
        return onCommentMainFeedDataResult;
    }

    private final void ia(Object args) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.swapAdapter(null, true);
        }
    }

    private final void ja(Object args) {
        if (!(args instanceof a.ShowCommentPanelArgs)) {
            return;
        }
        this.isFirstLoadingComment.compareAndSet(false, true);
        LoadDataArgs R9 = R9();
        R9.n("load_data_call_source_init");
        R9.o(1);
        DetailCommentViewModel detailCommentViewModel = this.viewMode;
        if (detailCommentViewModel != null) {
            detailCommentViewModel.e1(R9);
        }
    }

    private final void la() {
        Object obj;
        a.GetInputViewRecycledInfo getInputViewRecycledInfo;
        kk1.a aVar;
        RecyclerView.RecycledViewPool recycledViewPool;
        wk1.i a16;
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        safeLinearLayoutManager.setOrientation(1);
        this.safeLayoutManager = safeLinearLayoutManager;
        gk1.b contextProvide = getContextProvide();
        if (contextProvide != null && (a16 = contextProvide.a()) != null) {
            obj = a16.I2("message_get_comment_cache_recycled_info", null);
        } else {
            obj = null;
        }
        if (obj instanceof a.GetInputViewRecycledInfo) {
            getInputViewRecycledInfo = (a.GetInputViewRecycledInfo) obj;
        } else {
            getInputViewRecycledInfo = null;
        }
        hl1.d dVar = new hl1.d();
        if (getInputViewRecycledInfo == null || (aVar = getInputViewRecycledInfo.getDelegatesManager()) == null) {
            aVar = new kk1.a();
        }
        hl1.f fVar = new hl1.f(dVar, aVar);
        fVar.setHasStableIds(true);
        this.contentAdapter = fVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(false).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        Object broadcastGetMessage = broadcastGetMessage("action_get_comment_load_more_adapter", null);
        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.adapter.CommentLoadMoreAdapter");
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.contentAdapter, (il1.c) broadcastGetMessage});
        if (getInputViewRecycledInfo == null || (recycledViewPool = getInputViewRecycledInfo.getRecyclerViewPool()) == null) {
            recycledViewPool = new RecyclerView.RecycledViewPool();
            recycledViewPool.setMaxRecycledViews(6, 8);
            recycledViewPool.setMaxRecycledViews(7, 8);
            recycledViewPool.setMaxRecycledViews(4, 2);
        }
        ViewGroup viewGroup = this.commentContentView;
        if (viewGroup != null) {
            RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.leg);
            this.recyclerView = recyclerView;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setLayoutManager(this.safeLayoutManager);
            recyclerView.setAdapter(rFWConcatAdapter);
            recyclerView.setRecycledViewPool(recycledViewPool);
            recyclerView.addOnScrollListener(this.onScrollerListener);
            recyclerView.setOverScrollMode(2);
        }
        this.defaultAnimator = new DefaultItemAnimator();
    }

    private final void ma() {
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new c(partHost, this)).get(DetailCommentViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        DetailCommentViewModel detailCommentViewModel = (DetailCommentViewModel) viewModel;
        this.viewMode = detailCommentViewModel;
        Intrinsics.checkNotNull(detailCommentViewModel);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        detailCommentViewModel.N(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.na(h.this, (x) obj);
            }
        });
        DetailCommentViewModel detailCommentViewModel2 = this.viewMode;
        Intrinsics.checkNotNull(detailCommentViewModel2);
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "partHost.hostLifecycleOwner");
        detailCommentViewModel2.b(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.oa(h.this, (x) obj);
            }
        });
        DetailCommentViewModel detailCommentViewModel3 = this.viewMode;
        Intrinsics.checkNotNull(detailCommentViewModel3);
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
        detailCommentViewModel3.d(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.pa(h.this, (DataChangedState) obj);
            }
        });
        DetailCommentViewModel detailCommentViewModel4 = this.viewMode;
        Intrinsics.checkNotNull(detailCommentViewModel4);
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "partHost.hostLifecycleOwner");
        detailCommentViewModel4.A1(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.qa(h.this, (x) obj);
            }
        });
        DetailCommentViewModel detailCommentViewModel5 = this.viewMode;
        Intrinsics.checkNotNull(detailCommentViewModel5);
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner5, "partHost.hostLifecycleOwner");
        detailCommentViewModel5.I(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.ra(h.this, (x) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(h this$0, x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.aa(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(h this$0, x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Z9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(h this$0, DataChangedState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.U9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(h this$0, x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DetailCommentViewModel detailCommentViewModel = this$0.viewMode;
        Intrinsics.checkNotNull(detailCommentViewModel);
        int identifier = detailCommentViewModel.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.ca(identifier, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(h this$0, x it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.T9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(int dx5, int dy5) {
        broadcastMessage("message_on_comment_on_scroll", new a.CommentListOnScroll(dx5, dy5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta() {
        broadcastMessage("message_on_scroll_idle", a.b.f405206a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua() {
        boolean z16;
        if (Q9() >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        broadcastMessage("message_comment_list_visibility_change", new g.CommentListVisibilityChangeMessage(z16));
    }

    private final void va() {
        broadcastMessage("message_update_feed_allow_comment", new g.UpdateFeedAllowCommentMessage(z9().getIsAllowComment(), z9().getIsPosterSelf()));
    }

    private final void wa(int dataChangedSource, Object payload) {
        Integer num;
        int coerceAtLeast;
        SafeLinearLayoutManager safeLinearLayoutManager;
        if (dataChangedSource == 13 && (safeLinearLayoutManager = this.safeLayoutManager) != null) {
            safeLinearLayoutManager.scrollToPositionWithOffset(0, 0);
        }
        if (dataChangedSource == 6) {
            if (payload instanceof Integer) {
                num = (Integer) payload;
            } else {
                num = null;
            }
            if (num != null) {
                int intValue = num.intValue();
                SafeLinearLayoutManager safeLinearLayoutManager2 = this.safeLayoutManager;
                if (safeLinearLayoutManager2 != null) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(intValue, 0);
                    safeLinearLayoutManager2.scrollToPositionWithOffset(coerceAtLeast, 0);
                }
            }
        }
    }

    private final void xa(g.OnDataListChangedMessage message) {
        RecyclerView.ItemAnimator itemAnimator;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            if (tl1.f.f436523a.b().contains(Integer.valueOf(message.getChangedSource()))) {
                itemAnimator = this.defaultAnimator;
            } else {
                itemAnimator = null;
            }
            recyclerView.setItemAnimator(itemAnimator);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        Object obj;
        DetailCommentViewModel detailCommentViewModel = this.viewMode;
        if (detailCommentViewModel != null) {
            obj = detailCommentViewModel.a0(action, args);
        } else {
            obj = null;
        }
        if (obj != null) {
            return obj;
        }
        if (action == null) {
            return null;
        }
        int hashCode = action.hashCode();
        if (hashCode != -296737012) {
            if (hashCode != 68441322) {
                if (hashCode != 584003583 || !action.equals("message_get_comment_content_can_scroll_vertically")) {
                    return null;
                }
                return Boolean.valueOf(ea(args));
            }
            if (!action.equals("message_get_comment_feed_data")) {
                return null;
            }
            return ha(args);
        }
        if (!action.equals("message_get_comment_content_view")) {
            return null;
        }
        return ga();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            switch (action.hashCode()) {
                case -1765047909:
                    if (action.equals("message_on_comment_panel_pre_destroy")) {
                        ia(args);
                        return;
                    }
                    break;
                case -927405176:
                    if (action.equals("message_on_comment_up_screen")) {
                        da(args);
                        return;
                    }
                    break;
                case -655946230:
                    if (action.equals("message_on_comment_panel_show_begin")) {
                        ja(args);
                        return;
                    }
                    break;
                case -147387757:
                    if (action.equals("message_item_data_changed")) {
                        X9(args);
                        return;
                    }
                    break;
                case 966244561:
                    if (action.equals("message_reload")) {
                        ba(args);
                        return;
                    }
                    break;
                case 1157992528:
                    if (action.equals("message_data_list_changed")) {
                        V9(args);
                        return;
                    }
                    break;
                case 1534930134:
                    if (action.equals("message_load_more")) {
                        Y9(args);
                        return;
                    }
                    break;
            }
        }
        DetailCommentViewModel detailCommentViewModel = this.viewMode;
        if (detailCommentViewModel != null) {
            detailCommentViewModel.c(action, args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ma();
        PartIOCKt.registerIoc(this, rootView, this.childHelperApiIoc, vi1.g.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.onScrollerListener);
        }
        DetailCommentViewModel detailCommentViewModel = this.viewMode;
        if (detailCommentViewModel != null) {
            detailCommentViewModel.onDestroy();
        }
        RFWIocAbilityProvider.g();
        PartIOCKt.unregisterIoc(this, vi1.g.class);
    }
}
