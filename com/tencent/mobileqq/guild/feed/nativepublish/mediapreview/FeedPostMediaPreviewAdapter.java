package com.tencent.mobileqq.guild.feed.nativepublish.mediapreview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.feed.nativepublish.fragment.FeedThirdPlatformVideoWebFragment;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.widget.GuildHollowOutFrameLayout;
import com.tencent.mobileqq.guild.feed.widget.GuildLinkView;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ea\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0017\u0018\u0000 \u0083\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0010\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001B\u0011\u0012\u0006\u0010c\u001a\u00020*\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u0000H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u0011\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0012\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J.\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0014\u0010\u001b\u001a\u00020\u0005*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u001c\u0010\u001c\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u001eH\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0002J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\t2\u0006\u0010\"\u001a\u00020$H\u0002J*\u0010)\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001c\u0010-\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J.\u00100\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010/\u001a\u00020.H\u0002J.\u00104\u001a\n 3*\u0004\u0018\u000102022\n\u0010\u0004\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u00101\u001a\u00020.H\u0002J\u0014\u00105\u001a\u00020\u0005*\u00020&2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u00106\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0003R\u00020\u0000H\u0002J \u00109\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00192\u0006\u0010 \u001a\u0002082\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000f0:J\u0014\u0010=\u001a\u00020\u00052\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000f0:J\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010>J\u0014\u0010A\u001a\u00020\u00052\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000f0:J\u0014\u0010B\u001a\u00020\u00052\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000f0:J\u000e\u0010E\u001a\u00020\u00052\u0006\u0010D\u001a\u00020CJ\u0014\u0010F\u001a\b\u0018\u00010\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010J\u001a\u00020\u00022\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\u000bH\u0016J\u000e\u0010M\u001a\u00020\u00052\u0006\u0010L\u001a\u00020KJ&\u0010Q\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0NH\u0016J\u0018\u0010R\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010T\u001a\u00020S2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010U\u001a\u00020\u000bH\u0016J\u0010\u0010V\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010W\u001a\u00020.2\u0006\u0010\u0004\u001a\u000208J\u0016\u0010Z\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000bJ\u000e\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u000bJ\u0010\u0010]\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010`\u001a\u00020\u00052\u0006\u0010_\u001a\u00020^R\u0014\u0010c\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR&\u0010h\u001a\u0012\u0012\u0004\u0012\u00020\u000f0dj\b\u0012\u0004\u0012\u00020\u000f`e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010pR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010{\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\by\u0010zR\u0014\u0010}\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b|\u0010zR\u0018\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0:8F\u00a2\u0006\u0006\u001a\u0004\b~\u0010\u007f\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$h;", "holder", "", "A0", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$c;", "C0", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$b;", "B0", "", "position", "z0", "W0", "Lfm1/i;", "mediaInfo", "J0", "g1", "loadSeq", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "", "url", "o1", "Landroid/view/View;", "eid", "V0", "O0", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$g;", "Lfm1/f;", "M0", "viewHolder", "Lfm1/b;", "data", "F0", "Lfm1/a;", "D0", "Landroid/widget/ImageView;", "targetView", "size", "f1", "Landroid/content/Context;", "context", "r1", "S0", "", "shouldCheckMediaInfoReBind", "i1", NodeProps.CUSTOM_PROP_ISGIF, "Lcom/tencent/libra/request/Option;", "kotlin.jvm.PlatformType", "k1", "x1", "p1", "view", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ICustomDataEditor.STRING_PARAM_1, "", ICustomDataEditor.STRING_ARRAY_PARAM_1, "mediaInfoList", "w0", "", "c1", "mediaList", "v1", "x0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "w1", "d1", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", ICustomDataEditor.NUMBER_PARAM_1, "", "scale", "y0", "", "", "payload", "m1", "l1", "", "getItemId", "getItemCount", "getItemViewType", "e1", "start", "target", "j1", com.tencent.luggage.wxa.c8.c.G, "t1", "q1", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$f;", "eventListener", "u1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "mContext", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mMediaList", "D", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$f;", "mListener", "Landroid/view/View$OnClickListener;", "E", "Landroid/view/View$OnClickListener;", "dummyClickListener", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "G", "mMediaItemScaleCoff", "", "H", "Ljava/util/Set;", "mUnmodifiableSet", "Z0", "()I", "mThumbSizePx", "Y0", "mDeleteIconPx", "b1", "()Ljava/util/List;", "unmodifiableIndexList", "<init>", "(Landroid/content/Context;)V", "I", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedPostMediaPreviewAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<fm1.i> mMediaList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private f mListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener dummyClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mRecyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private float mMediaItemScaleCoff;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Set<fm1.i> mUnmodifiableSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfm1/i;", "E", "Lfm1/i;", "l", "()Lfm1/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lfm1/i;)V", "mediaInfo", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private fm1.i mediaInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        @Nullable
        /* renamed from: l, reason: from getter */
        public final fm1.i getMediaInfo() {
            return this.mediaInfo;
        }

        public final void m(@Nullable fm1.i iVar) {
            this.mediaInfo = iVar;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$a;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$c;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$a;", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/ImageView;", "thumb", "G", "getIcon", "icon", "H", "o", "ivDelete", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "r", "()Landroid/widget/TextView;", "tvDuration", "J", "p", "ivGifLabel", "Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout;", "K", "Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout;", "getThumbContainer", "()Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout;", "thumbContainer", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends a {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView thumb;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView icon;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView ivDelete;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView tvDuration;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView ivGifLabel;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final GuildHollowOutFrameLayout thumbContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.e16);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.thumb)");
            this.thumb = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.kro);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.video_icon)");
            this.icon = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f165918y20);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_delete)");
            ImageView imageView = (ImageView) findViewById3;
            this.ivDelete = imageView;
            View findViewById4 = itemView.findViewById(R.id.f107586at);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_duration)");
            this.tvDuration = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.w9p);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.guild_feed_gif_label)");
            this.ivGifLabel = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f97015j9);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.\u2026umb_hollow_out_container)");
            GuildHollowOutFrameLayout guildHollowOutFrameLayout = (GuildHollowOutFrameLayout) findViewById6;
            this.thumbContainer = guildHollowOutFrameLayout;
            guildHollowOutFrameLayout.setHollowOutArea(GuildHollowOutFrameLayout.PivotPosition.RIGHT_TOP, imageView);
        }

        @NotNull
        public final ImageView getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final ImageView getIvDelete() {
            return this.ivDelete;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getIvGifLabel() {
            return this.ivGifLabel;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final ImageView getThumb() {
            return this.thumb;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final TextView getTvDuration() {
            return this.tvDuration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$e;", "", "Landroid/view/View;", "view", "Lfm1/i;", "data", "", "b", "Lfm1/b;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final e f222131a = new e();

        e() {
        }

        public final void a(@NotNull View view, @NotNull fm1.b data) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            VideoReport.resetElementParams(view);
            com.tencent.mobileqq.guild.feed.report.f.a(view);
            String valueOf = String.valueOf(data.hashCode());
            int i3 = 2;
            Pair[] pairArr = new Pair[2];
            int urlType = data.getUrlType();
            if (urlType != 1) {
                if (urlType != 7) {
                    if (urlType != 8) {
                        if (urlType != 9) {
                            i3 = 1;
                        }
                    } else {
                        i3 = 3;
                    }
                }
                pairArr[0] = TuplesKt.to("sgrp_url_type", Integer.valueOf(i3));
                pairArr[1] = TuplesKt.to("sgrp_url", data.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String());
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                if1.a.b(view, "em_sgrp_insert_card_url", valueOf, mapOf, null, null, null, null, null, 248, null);
            }
            i3 = 4;
            pairArr[0] = TuplesKt.to("sgrp_url_type", Integer.valueOf(i3));
            pairArr[1] = TuplesKt.to("sgrp_url", data.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String());
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            if1.a.b(view, "em_sgrp_insert_card_url", valueOf, mapOf, null, null, null, null, null, 248, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b(@NotNull View view, @NotNull fm1.i data) {
            Map emptyMap;
            fm1.i iVar;
            fm1.b bVar;
            fm1.g gVar;
            String str;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            VideoReport.resetElementParams(view);
            com.tencent.mobileqq.guild.feed.report.f.a(view);
            String valueOf = String.valueOf(data.hashCode());
            if (fm1.d.b(data)) {
                emptyMap = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_video_url_source", 0));
            } else if (!fm1.d.c(data)) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            } else {
                int i3 = 2;
                Pair[] pairArr = new Pair[2];
                int urlType = data.getUrlType();
                if (urlType != 1) {
                    if (urlType != 7) {
                        if (urlType != 8) {
                            if (urlType != 9) {
                                i3 = 0;
                            }
                        }
                    } else {
                        i3 = 1;
                    }
                    pairArr[0] = TuplesKt.to("sgrp_video_url_source", Integer.valueOf(i3));
                    if (data instanceof fm1.b) {
                        iVar = null;
                    } else {
                        iVar = data;
                    }
                    bVar = (fm1.b) iVar;
                    if (bVar != null || (str = bVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String()) == null) {
                        if (!(data instanceof fm1.g)) {
                            data = null;
                        }
                        gVar = (fm1.g) data;
                        if (gVar == null) {
                            str = gVar.getVideoShortPlayUrl();
                        } else {
                            str = "";
                        }
                    }
                    pairArr[1] = TuplesKt.to("sgrp_url", str);
                    emptyMap = MapsKt__MapsKt.mapOf(pairArr);
                }
                i3 = 3;
                pairArr[0] = TuplesKt.to("sgrp_video_url_source", Integer.valueOf(i3));
                if (data instanceof fm1.b) {
                }
                bVar = (fm1.b) iVar;
                if (bVar != null) {
                }
                if (!(data instanceof fm1.g)) {
                }
                gVar = (fm1.g) data;
                if (gVar == null) {
                }
                pairArr[1] = TuplesKt.to("sgrp_url", str);
                emptyMap = MapsKt__MapsKt.mapOf(pairArr);
            }
            if1.a.b(view, "em_sgrp_insert_picture_video", valueOf, emptyMap, null, null, null, null, null, 248, null);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$f;", "", "", "Lfm1/i;", "mediaList", "", "a", "data", "Landroid/widget/ImageView;", "view", "", "position", "b", "removeItem", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface f {
        void a(@NotNull List<? extends fm1.i> mediaList);

        void b(@NotNull fm1.i data, @NotNull ImageView view, int position);

        void c(@NotNull fm1.i removeItem);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$g;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$a;", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "t", "()Landroid/widget/ImageView;", "setThumb", "(Landroid/widget/ImageView;)V", "thumb", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setIvDelete", "ivDelete", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "setDocTitle", "(Landroid/widget/TextView;)V", "docTitle", "I", "r", "setPermissionDsc", "permissionDsc", "J", "o", "setDocDsc", "docDsc", "K", ReportConstant.COSTREPORT_PREFIX, "setPlatformIconTv", "platformIconTv", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g extends a {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView thumb;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private ImageView ivDelete;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private TextView docTitle;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView permissionDsc;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private TextView docDsc;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private ImageView platformIconTv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.e16);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.thumb)");
            this.thumb = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f165918y20);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_delete)");
            this.ivDelete = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.uk7);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.doc_title)");
            this.docTitle = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.uk6);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.doc_permission_dsc)");
            this.permissionDsc = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f165005uk4);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.doc_dsc)");
            this.docDsc = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f25610ba);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.platform_icon)");
            this.platformIconTv = (ImageView) findViewById6;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getDocDsc() {
            return this.docDsc;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getDocTitle() {
            return this.docTitle;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final ImageView getIvDelete() {
            return this.ivDelete;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final TextView getPermissionDsc() {
            return this.permissionDsc;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final ImageView getPlatformIconTv() {
            return this.platformIconTv;
        }

        @NotNull
        /* renamed from: t, reason: from getter */
        public final ImageView getThumb() {
            return this.thumb;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$h;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$a;", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "r", "()Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "setThumb", "(Lcom/tencent/biz/richframework/widget/RFWRoundImageView;)V", "thumb", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "setIvDelete", "(Landroid/widget/ImageView;)V", "ivDelete", "Landroid/widget/RelativeLayout;", "H", "Landroid/widget/RelativeLayout;", "o", "()Landroid/widget/RelativeLayout;", "setCoverView", "(Landroid/widget/RelativeLayout;)V", "coverView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "setTvDuration", "(Landroid/widget/TextView;)V", "tvDuration", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setIvGifLabel", "ivGifLabel", "Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout;", "K", "Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout;", "getThumbContainer", "()Lcom/tencent/mobileqq/guild/feed/widget/GuildHollowOutFrameLayout;", "thumbContainer", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class h extends a {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private RFWRoundImageView thumb;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private ImageView ivDelete;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private RelativeLayout coverView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView tvDuration;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private TextView ivGifLabel;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final GuildHollowOutFrameLayout thumbContainer;
        final /* synthetic */ FeedPostMediaPreviewAdapter L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.L = feedPostMediaPreviewAdapter;
            View findViewById = itemView.findViewById(R.id.f97015j9);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026umb_hollow_out_container)");
            GuildHollowOutFrameLayout guildHollowOutFrameLayout = (GuildHollowOutFrameLayout) findViewById;
            this.thumbContainer = guildHollowOutFrameLayout;
            View findViewById2 = itemView.findViewById(R.id.e16);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.thumb)");
            this.thumb = (RFWRoundImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f165918y20);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_delete)");
            this.ivDelete = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f107586at);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_duration)");
            this.tvDuration = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.kq_);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.video_cover)");
            this.coverView = (RelativeLayout) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.w9p);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.guild_feed_gif_label)");
            this.ivGifLabel = (TextView) findViewById6;
            guildHollowOutFrameLayout.setHollowOutArea(GuildHollowOutFrameLayout.PivotPosition.RIGHT_TOP, this.ivDelete);
            this.thumb.setEnableClearBitmapCanvasWhenDirty(true);
            ImageViewPorterDuffUtils.f235385a.c(this.thumb);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final RelativeLayout getCoverView() {
            return this.coverView;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final ImageView getIvDelete() {
            return this.ivDelete;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final TextView getIvGifLabel() {
            return this.ivGifLabel;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final RFWRoundImageView getThumb() {
            return this.thumb;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final TextView getTvDuration() {
            return this.tvDuration;
        }
    }

    public FeedPostMediaPreviewAdapter(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mMediaList = new ArrayList<>();
        this.dummyClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostMediaPreviewAdapter.X0(view);
            }
        };
        this.mMediaItemScaleCoff = 1.0f;
    }

    private final void A0(h holder) {
        if (holder.getThumb().getHeight() != Z0()) {
            RFWRoundImageView thumb = holder.getThumb();
            ViewGroup.LayoutParams layoutParams = thumb.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = Z0();
                layoutParams.width = Z0();
                thumb.setLayoutParams(layoutParams);
                ImageView ivDelete = holder.getIvDelete();
                ViewGroup.LayoutParams layoutParams2 = ivDelete.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = Y0();
                    layoutParams2.width = Y0();
                    ivDelete.setLayoutParams(layoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    private final void B0(b holder) {
        if (holder.itemView.getHeight() != Z0()) {
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = Z0();
                layoutParams.width = -1;
                view.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    private final void C0(c holder) {
        if (holder.getThumb().getHeight() != Z0()) {
            ImageView thumb = holder.getThumb();
            ViewGroup.LayoutParams layoutParams = thumb.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = Z0();
                layoutParams.width = Z0();
                thumb.setLayoutParams(layoutParams);
                ImageView ivDelete = holder.getIvDelete();
                ViewGroup.LayoutParams layoutParams2 = ivDelete.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = Y0();
                    layoutParams2.width = Y0();
                    ivDelete.setLayoutParams(layoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    private final void D0(final b viewHolder, final fm1.a data) {
        GuildLinkView guildLinkView;
        View view = viewHolder.itemView;
        if (view instanceof GuildLinkView) {
            guildLinkView = (GuildLinkView) view;
        } else {
            guildLinkView = null;
        }
        if (guildLinkView != null) {
            guildLinkView.setOnClickContainerListener(null);
            GuildLinkView.d(guildLinkView, data.getTitle(), data.getAbstract(), data.getImageUrl(), data.getRedirectUrl(), null, null, null, null, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedPostMediaPreviewAdapter.E0(FeedPostMediaPreviewAdapter.this, viewHolder, data, view2);
                }
            }, 240, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(FeedPostMediaPreviewAdapter this$0, b viewHolder, fm1.a data, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.s1(v3, viewHolder, data);
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final void F0(final c viewHolder, final fm1.b data) {
        String str;
        e eVar = e.f222131a;
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        eVar.a(view, data);
        viewHolder.getIvGifLabel().setVisibility(8);
        viewHolder.getIvDelete().setVisibility(0);
        viewHolder.getIvDelete().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedPostMediaPreviewAdapter.H0(FeedPostMediaPreviewAdapter.this, viewHolder, data, view2);
            }
        });
        viewHolder.getTvDuration().setVisibility(4);
        GuildFeedListImageExKt.g(viewHolder.getThumb(), data.getImageUrl(), new Pair(Integer.valueOf(Z0()), Integer.valueOf(Z0())), data.getImageUrl(), null, null, false, false, false, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                FeedPostMediaPreviewAdapter.I0(loadState, option);
            }
        }, 248, null);
        int urlType = data.getUrlType();
        if (urlType != 8) {
            if (urlType != 9) {
                str = "https://world-channel-image-1251316161.cos.ap-guangzhou.myqcloud.com/feeds-elem/world_3k.png";
            } else {
                str = "https://world-channel-image-1251316161.cos.ap-guangzhou.myqcloud.com/feeds-elem/bilibili_3k.png";
            }
        } else {
            str = "https://world-channel-image-1251316161.cos.ap-guangzhou.myqcloud.com/feeds-elem/tencent_video.png";
        }
        u.p(str, viewHolder.getIcon());
        viewHolder.itemView.setOnClickListener(this.dummyClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(FeedPostMediaPreviewAdapter this$0, c viewHolder, fm1.b data, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            this$0.s1(v3, viewHolder, data);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess() && com.tencent.mobileqq.guild.feed.gallery.b.j(option)) {
            QLog.i("FeedPostMediaPreviewAdapter", 2, "[onLoadThirdVideoThumb]--width:" + option.getResultBitMap().getWidth() + ",height:" + option.getResultBitMap().getHeight());
        }
    }

    private final void J0(final h holder, final fm1.i mediaInfo) {
        x1(holder.getIvDelete(), mediaInfo);
        holder.getCoverView().setVisibility(8);
        holder.getIvDelete().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostMediaPreviewAdapter.K0(FeedPostMediaPreviewAdapter.this, holder, mediaInfo, view);
            }
        });
        holder.getThumb().setAdjustViewBounds(false);
        holder.getThumb().setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.getThumb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostMediaPreviewAdapter.L0(FeedPostMediaPreviewAdapter.this, mediaInfo, holder, view);
            }
        });
        g1(holder, mediaInfo);
        TextView ivGifLabel = holder.getIvGifLabel();
        Boolean valueOf = Boolean.valueOf(mediaInfo.getIsGif());
        ivGifLabel.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, ivGifLabel)) == null) {
            ivGifLabel.setVisibility(8);
        }
        com.tencent.mobileqq.guild.feed.report.f.a(holder.itemView);
        com.tencent.mobileqq.guild.feed.report.f.a(holder.getThumb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(FeedPostMediaPreviewAdapter this$0, h holder, fm1.i mediaInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.s1(it, holder, mediaInfo);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(FeedPostMediaPreviewAdapter this$0, fm1.i mediaInfo, h holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            this$0.p1(mediaInfo, holder);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M0(final g holder, final fm1.f mediaInfo) {
        holder.getThumb().setAdjustViewBounds(false);
        holder.getThumb().setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (QLog.isColorLevel()) {
            QLog.d("FeedPostMediaPreviewAdapter", 2, "bindTencentDocHolder urlStr=" + mediaInfo.getCoverUrl());
        }
        holder.getIvDelete().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostMediaPreviewAdapter.N0(FeedPostMediaPreviewAdapter.this, holder, mediaInfo, view);
            }
        });
        f1(holder.getThumb(), mediaInfo.getCoverUrl(), AlbumThumbDownloader.THUMB_WIDHT, this.mContext.getDrawable(R.drawable.o4h));
        f1(holder.getPlatformIconTv(), mediaInfo.getIconUrl(), com.tencent.guild.aio.util.c.b(12), this.mContext.getDrawable(R.drawable.o4i));
        holder.getDocTitle().setText(mediaInfo.getTitle());
        holder.getPermissionDsc().setText(mediaInfo.getPermissionDsc());
        holder.getDocDsc().setText(mediaInfo.getPlatformName());
        final View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        final long j3 = 200;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter$bindTencentDocHolder$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                Context context;
                EventCollector.getInstance().onViewClickedBefore(it);
                view.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this;
                context = feedPostMediaPreviewAdapter.mContext;
                feedPostMediaPreviewAdapter.r1(context, mediaInfo.j());
                final View view2 = view;
                view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter$bindTencentDocHolder$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view2.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        com.tencent.mobileqq.guild.feed.report.f.a(holder.getThumb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(FeedPostMediaPreviewAdapter this$0, g holder, fm1.f mediaInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.s1(it, holder, mediaInfo);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void O0(final h holder, final fm1.i mediaInfo) {
        e.f222131a.b(holder.getThumb(), mediaInfo);
        x1(holder.getIvDelete(), mediaInfo);
        holder.getIvDelete().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostMediaPreviewAdapter.Q0(FeedPostMediaPreviewAdapter.this, holder, mediaInfo, view);
            }
        });
        holder.getCoverView().setVisibility(0);
        if (mediaInfo.getVideoDuration() <= 0) {
            holder.getCoverView().setVisibility(8);
        } else {
            holder.getCoverView().setVisibility(0);
            holder.getTvDuration().setText(ax.k(mediaInfo.getVideoDuration()));
        }
        holder.getThumb().setAdjustViewBounds(false);
        holder.getThumb().setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.getThumb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostMediaPreviewAdapter.R0(FeedPostMediaPreviewAdapter.this, mediaInfo, holder, view);
            }
        });
        String videoCoverUrl = mediaInfo.getVideoCoverUrl();
        if (QLog.isColorLevel()) {
            QLog.d("FeedPostMediaPreviewAdapter", 2, "bindThirdPartyVideoHolder urlStr=" + videoCoverUrl);
        }
        com.tencent.mobileqq.guild.feed.report.f.a(holder.getThumb());
        Drawable drawable = this.mContext.getDrawable(R.drawable.asd);
        GuildFeedPicLoader guildFeedPicLoader = GuildFeedPicLoader.f231079a;
        Option k16 = k1(holder, drawable, false);
        k16.setUrl(videoCoverUrl);
        Intrinsics.checkNotNullExpressionValue(k16, "obtainDefaultThumbImageL\u2026rl = urlStr\n            }");
        GuildFeedPicLoader.e(guildFeedPicLoader, k16, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(FeedPostMediaPreviewAdapter this$0, h holder, fm1.i mediaInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.s1(it, holder, mediaInfo);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(FeedPostMediaPreviewAdapter this$0, fm1.i mediaInfo, h holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            this$0.p1(mediaInfo, holder);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S0(final h holder, final fm1.i mediaInfo) {
        e eVar = e.f222131a;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        eVar.b(view, mediaInfo);
        x1(holder.getIvDelete(), mediaInfo);
        holder.getIvDelete().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedPostMediaPreviewAdapter.T0(FeedPostMediaPreviewAdapter.this, holder, mediaInfo, view2);
            }
        });
        holder.getCoverView().setVisibility(0);
        if (mediaInfo.getVideoDuration() <= 0) {
            holder.getCoverView().setVisibility(8);
        } else {
            holder.getCoverView().setVisibility(0);
            holder.getTvDuration().setText(QAlbumUtil.formatTimeToString(mediaInfo.getVideoDuration()));
        }
        holder.getIvGifLabel().setVisibility(8);
        holder.getThumb().setAdjustViewBounds(false);
        holder.getThumb().setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.getThumb().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedPostMediaPreviewAdapter.U0(FeedPostMediaPreviewAdapter.h.this, this, mediaInfo, view2);
            }
        });
        g1(holder, mediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(FeedPostMediaPreviewAdapter this$0, h holder, fm1.i mediaInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.s1(it, holder, mediaInfo);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(h holder, FeedPostMediaPreviewAdapter this$0, fm1.i mediaInfo, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        QLog.d("FeedPostMediaPreviewAdapter", 4, "click: drawable=" + holder.getThumb().getDrawable().hashCode());
        if (!com.tencent.mobileqq.guild.util.o.c("FeedPostMediaPreviewAdapter")) {
            this$0.p1(mediaInfo, holder);
        }
        View view2 = holder.itemView;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_video_url_source", 0));
        VideoReport.setElementId(view2, "em_sgrp_insert_picture_video");
        VideoReport.setElementClickPolicy(view2, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view2, mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V0(View view, String str) {
        if1.a.b(view, str, null, null, ExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_NONE, null, null, null, 230, null);
        VideoReport.reportEvent("clck", view, null);
    }

    private final void W0(a holder, int position) {
        fm1.i iVar = this.mMediaList.get(position);
        Intrinsics.checkNotNullExpressionValue(iVar, "mMediaList[position]");
        fm1.i iVar2 = iVar;
        int i3 = iVar2.i();
        if (i3 != 0) {
            if (i3 != 1) {
                Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.ViewHolder");
                J0((h) holder, iVar2);
            } else {
                int urlType = iVar2.getUrlType();
                if (urlType != 1) {
                    if (urlType != 3) {
                        switch (urlType) {
                            case 6:
                                Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.CommThirdShareInfoViewHolder");
                                D0((b) holder, (fm1.a) iVar2);
                                break;
                            case 7:
                            case 8:
                            case 9:
                                Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.CommThirdVideoInfoViewHolder");
                                F0((c) holder, (fm1.b) iVar2);
                                break;
                        }
                    } else {
                        Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.TencentDocViewHolder");
                        M0((g) holder, (fm1.f) iVar2);
                    }
                } else {
                    Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.ViewHolder");
                    O0((h) holder, iVar2);
                }
            }
        } else if (fm1.d.a(iVar2)) {
            Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.ViewHolder");
            J0((h) holder, iVar2);
        } else {
            Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.ViewHolder");
            S0((h) holder, iVar2);
        }
        holder.m(iVar2);
        z0(holder, position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int Y0() {
        return (int) cw.c(18 * this.mMediaItemScaleCoff);
    }

    private final int Z0() {
        return (int) cw.c(66 * this.mMediaItemScaleCoff);
    }

    private final void f1(ImageView targetView, String url, int size, Drawable defaultDrawable) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = defaultDrawable;
        obtain.mFailedDrawable = defaultDrawable;
        obtain.mRequestWidth = size;
        obtain.mRequestHeight = size;
        try {
            targetView.setImageDrawable(URLDrawable.getDrawable(new URL(url), obtain));
        } catch (MalformedURLException e16) {
            QLog.e("FeedPostMediaPreviewAdapter", 1, "loadDrawable error: " + e16);
            targetView.setImageDrawable(defaultDrawable);
        }
    }

    private final void g1(final h holder, final fm1.i mediaInfo) {
        String videoPlayUrl;
        boolean z16;
        Class<f11.a> cls;
        if (fm1.d.e(mediaInfo)) {
            videoPlayUrl = mediaInfo.getImageUrl();
        } else {
            videoPlayUrl = mediaInfo.getVideoPlayUrl();
        }
        final Drawable drawable = this.mContext.getDrawable(R.drawable.asd);
        if (videoPlayUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RFWRoundImageView thumb = holder.getThumb();
            Pair pair = new Pair(Integer.valueOf(Z0()), Integer.valueOf(Z0()));
            String str = videoPlayUrl + "_image";
            if (fm1.d.e(mediaInfo)) {
                cls = f11.a.class;
            } else {
                cls = null;
            }
            final String str2 = videoPlayUrl;
            GuildFeedListImageExKt.g(thumb, videoPlayUrl, pair, str, drawable, cls, false, false, false, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    FeedPostMediaPreviewAdapter.h1(fm1.i.this, this, holder, drawable, str2, loadState, option);
                }
            }, 224, null);
            return;
        }
        holder.getThumb().setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(fm1.i mediaInfo, FeedPostMediaPreviewAdapter this$0, h holder, Drawable drawable, String url, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(url, "$url");
        if (loadState.isFinishSuccess() && com.tencent.mobileqq.guild.feed.gallery.b.j(option)) {
            QLog.i("FeedPostMediaPreviewAdapter", 2, "[onLoadThumb]--width:" + option.getResultBitMap().getWidth() + ",height:" + option.getResultBitMap().getHeight());
            return;
        }
        if (loadState.isFinishError()) {
            if (fm1.d.e(mediaInfo)) {
                this$0.i1(holder, mediaInfo, drawable, true);
            } else {
                this$0.o1(option.getSeq(), holder, drawable, url);
            }
        }
    }

    private final void i1(h holder, fm1.i mediaInfo, Drawable defaultDrawable, boolean shouldCheckMediaInfoReBind) {
        int i3;
        if (QLog.isColorLevel()) {
            fm1.i mediaInfo2 = holder.getMediaInfo();
            if (mediaInfo2 != null) {
                i3 = mediaInfo2.hashCode();
            } else {
                i3 = 0;
            }
            QLog.d("FeedPostMediaPreviewAdapter", 1, "[loadVideoCoverFallback]: holder.mediaInfo=" + i3 + ", mediaInfoWillLoad=" + mediaInfo.hashCode() + ", newPath=" + mediaInfo.getVideoPlayUrl() + ", shouldCheckMediaInfoReBind=" + shouldCheckMediaInfoReBind);
        }
        if (shouldCheckMediaInfoReBind && !Intrinsics.areEqual(holder.getMediaInfo(), mediaInfo)) {
            return;
        }
        GuildFeedPicLoader guildFeedPicLoader = GuildFeedPicLoader.f231079a;
        Option preferDecoder = k1(holder, defaultDrawable, false).setUrl(mediaInfo.getVideoPlayUrl()).setPreferDecoder(f11.a.class);
        Intrinsics.checkNotNullExpressionValue(preferDecoder, "obtainDefaultThumbImageL\u2026ThumbDecoder::class.java)");
        GuildFeedPicLoader.e(guildFeedPicLoader, preferDecoder, null, 2, null);
    }

    private final Option k1(h holder, Drawable defaultDrawable, boolean isGif) {
        Option obtain = Option.obtain();
        obtain.setLoadingDrawable(defaultDrawable);
        obtain.setFailedDrawable(defaultDrawable);
        obtain.setRequestWidth(Z0());
        obtain.setRequestHeight(Z0());
        if (!isGif) {
            obtain.setDecodeMode(1);
            obtain.setRegionScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            obtain.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        }
        obtain.setTargetView(holder.getThumb());
        return obtain;
    }

    private final void o1(int loadSeq, h holder, Drawable defaultDrawable, String url) {
        holder.getThumb().setImageDrawable(defaultDrawable);
        if (Build.VERSION.SDK_INT < 24) {
            QLog.w("FeedPostMediaPreviewAdapter", 1, "[onLoadPictureThumbFailed]: seq=" + loadSeq + ", load picture failed, use fallback strategy");
            GuildFeedListImageExKt.g(holder.getThumb(), url, TuplesKt.to(Integer.valueOf(Z0()), Integer.valueOf(Z0())), url + "_image", defaultDrawable, null, true, false, false, null, 400, null);
        }
    }

    private final void p1(fm1.i data, h holder) {
        f fVar = this.mListener;
        if (fVar != null) {
            fVar.b(data, holder.getThumb(), holder.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(Context context, String url) {
        boolean z16 = true;
        Logger.f235387a.d().i("FeedPostMediaPreviewAdapter", 1, "openNormalUrl " + url);
        if (url != null && url.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragment_class", FeedThirdPlatformVideoWebFragment.class.getCanonicalName());
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    private final void s1(View view, RecyclerView.ViewHolder viewHolder, fm1.i mediaInfo) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition >= 0 && adapterPosition < this.mMediaList.size()) {
            fm1.i remove = this.mMediaList.remove(adapterPosition);
            Intrinsics.checkNotNullExpressionValue(remove, "mMediaList.removeAt(pos)");
            fm1.i iVar = remove;
            notifyItemRemoved(adapterPosition);
            f fVar = this.mListener;
            if (fVar != null) {
                fVar.a(this.mMediaList);
            }
            f fVar2 = this.mListener;
            if (fVar2 != null) {
                fVar2.c(iVar);
            }
            V0(view, "em_sgrp_short_publisher_delete");
        }
    }

    private final void x1(ImageView imageView, fm1.i iVar) {
        boolean z16;
        Set<fm1.i> set = this.mUnmodifiableSet;
        if (set != null && set.contains(iVar)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            imageView.setClickable(false);
            imageView.setVisibility(8);
        } else {
            imageView.setClickable(true);
            imageView.setVisibility(0);
        }
    }

    private final void z0(a holder, int position) {
        fm1.i iVar = this.mMediaList.get(position);
        Intrinsics.checkNotNullExpressionValue(iVar, "mMediaList[position]");
        fm1.i iVar2 = iVar;
        int itemViewType = getItemViewType(position);
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    QLog.e("FeedPostMediaPreviewAdapter", 1, "[adjustItemSize]--illegal,mainType:" + iVar2.i() + ",subType:" + iVar2.getUrlType());
                    return;
                }
                if (!(holder instanceof b)) {
                    return;
                }
                B0((b) holder);
                return;
            }
            if (!(holder instanceof c)) {
                return;
            }
            C0((c) holder);
            return;
        }
        if (!(holder instanceof h)) {
            return;
        }
        A0((h) holder);
    }

    @NotNull
    public final List<fm1.i> a1() {
        return this.mMediaList;
    }

    @NotNull
    public final List<Integer> b1() {
        List<Integer> emptyList;
        boolean z16;
        Set<fm1.i> set = this.mUnmodifiableSet;
        if (set == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Integer valueOf = Integer.valueOf(this.mMediaList.indexOf((fm1.i) it.next()));
            if (valueOf.intValue() == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                arrayList.add(valueOf);
            }
        }
        return arrayList;
    }

    @Nullable
    public final Set<fm1.i> c1() {
        return this.mUnmodifiableSet;
    }

    @Nullable
    public final h d1(int position) {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
        } else {
            viewHolder = null;
        }
        return (h) viewHolder;
    }

    public final boolean e1(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getItemViewType() == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mMediaList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.mMediaList.get(position).getVideoPlayUrl().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int urlType;
        fm1.i iVar = this.mMediaList.get(position);
        Intrinsics.checkNotNullExpressionValue(iVar, "mMediaList[position]");
        fm1.i iVar2 = iVar;
        int i3 = iVar2.i();
        if (i3 == 0 || i3 != 1 || (urlType = iVar2.getUrlType()) == 1) {
            return 1;
        }
        if (urlType != 3) {
            switch (urlType) {
                case 6:
                    return 3;
                case 7:
                case 8:
                case 9:
                    return 2;
                default:
                    return 1;
            }
        }
        return 4;
    }

    public final void j1(int start, int target) {
        if (start != target) {
            fm1.i remove = this.mMediaList.remove(start);
            Intrinsics.checkNotNullExpressionValue(remove, "mMediaList.removeAt(start)");
            this.mMediaList.add(target, remove);
            f fVar = this.mListener;
            if (fVar != null) {
                fVar.a(this.mMediaList);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        W0(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position, @NotNull List<Object> payload) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (payload.contains("payload_size_change")) {
            z0(holder, position);
        } else {
            W0(holder, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 2) {
            if (viewType != 3) {
                if (viewType != 4) {
                    View itemView = LayoutInflater.from(this.mContext).inflate(R.layout.epy, parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    return new h(this, itemView);
                }
                View itemView2 = LayoutInflater.from(this.mContext).inflate(R.layout.epz, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                return new g(itemView2);
            }
            GuildLinkView guildLinkView = new GuildLinkView(this.mContext, null, 0, 6, null);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, kotlin.g.c(guildLinkView, 66.0f));
            marginLayoutParams.leftMargin = kotlin.g.c(guildLinkView, 4.0f);
            marginLayoutParams.rightMargin = kotlin.g.c(guildLinkView, 4.0f);
            guildLinkView.setLayoutParams(marginLayoutParams);
            return new b(guildLinkView);
        }
        View itemView3 = LayoutInflater.from(this.mContext).inflate(R.layout.epy, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
        return new c(itemView3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.m(null);
        super.onViewRecycled(holder);
    }

    public final void t1(int pos) {
        if (pos >= 0 && pos <= this.mMediaList.size()) {
            fm1.i remove = this.mMediaList.remove(pos);
            Intrinsics.checkNotNullExpressionValue(remove, "mMediaList.removeAt(pos)");
            fm1.i iVar = remove;
            f fVar = this.mListener;
            if (fVar != null) {
                fVar.c(iVar);
            }
            notifyItemRemoved(pos);
            notifyItemRangeChanged(pos, getNUM_BACKGOURND_ICON() - pos, "payload");
        }
    }

    public final void u1(@NotNull f eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.mListener = eventListener;
    }

    public final void v1(@NotNull List<? extends fm1.i> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Set<fm1.i> set = this.mUnmodifiableSet;
        if (set != null) {
            set.clear();
        }
        this.mMediaList.clear();
        this.mMediaList.addAll(mediaList);
        f fVar = this.mListener;
        if (fVar != null) {
            fVar.a(this.mMediaList);
        }
        notifyDataSetChanged();
    }

    public final void w0(@NotNull List<? extends fm1.i> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        List<? extends fm1.i> list = mediaInfoList;
        if (!list.isEmpty()) {
            Set<fm1.i> set = this.mUnmodifiableSet;
            if (set == null) {
                set = new LinkedHashSet<>();
            }
            set.addAll(list);
            this.mUnmodifiableSet = set;
        }
    }

    public final void w1(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.mRecyclerView = recyclerView;
    }

    public final void x0(@NotNull List<? extends fm1.i> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this.mMediaList.addAll(mediaList);
        f fVar = this.mListener;
        if (fVar != null) {
            fVar.a(this.mMediaList);
        }
        notifyDataSetChanged();
    }

    public final void y0(float scale) {
        this.mMediaItemScaleCoff = scale;
        notifyDataSetChanged();
    }
}
