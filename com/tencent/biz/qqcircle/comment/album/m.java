package com.tencent.biz.qqcircle.comment.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/m;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/biz/qqcircle/comment/album/k;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "j0", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "", "l0", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "dataList", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", com.tencent.luggage.wxa.c8.c.G, "onBindViewHolder", "position", "getItemViewType", "getItemCount", "", "getItemId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "k0", "()Ljava/util/List;", QAdVrReportParams.ParamKey.MEDIA, BdhLogUtil.LogTag.Tag_Conn, "Lcooperation/qqcircle/report/QCircleReportBean;", "<init>", "()V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class m extends ListAdapter<QFSLocalMediaInfo, RecyclerView.ViewHolder> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QCircleReportBean reportBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSLocalMediaInfo> media;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/m$a;", "", "", "a", "BIG_SCREEN_THRESHOLD", "I", "DEFAULT_MEDIA_ITEM_SPAN_COUNT", "MIN_PIC_WIDTH_DP", "", "TAG", "Ljava/lang/String;", "", "VIEW_HOLD_GAP", UserInfo.SEX_FEMALE, "VIEW_TYPE_CONTENT", "VIEW_TYPE_CONTENT_FIRST_ROW", "VIEW_TYPE_EMPTY", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.comment.album.m$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            if (!bz.r()) {
                return 4;
            }
            float screenWidth = DisplayUtil.getScreenWidth() / DisplayUtil.getDensity();
            if (screenWidth < 500.0f) {
                return 4;
            }
            return (int) (screenWidth / 100);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/biz/qqcircle/comment/album/m$b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {
        b(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/biz/qqcircle/comment/album/m$c", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ViewHolder {
        c(ImageView imageView) {
            super(imageView);
        }
    }

    public m() {
        super(new l());
        this.media = new ArrayList();
    }

    private final String j0() {
        String str;
        QCircleReportBean qCircleReportBean = this.reportBean;
        if (qCircleReportBean != null) {
            str = qCircleReportBean.getFeedId();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (super.getNUM_BACKGOURND_ICON() == 0) {
            return 1;
        }
        return super.getNUM_BACKGOURND_ICON();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (super.getNUM_BACKGOURND_ICON() == 0) {
            return 2;
        }
        if (position < INSTANCE.a()) {
            return 0;
        }
        return 1;
    }

    public final void i0(@NotNull List<LocalMediaInfo> dataList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Integer num;
        int i3;
        int i16;
        boolean contains;
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.media.clear();
        ArrayList arrayList = new ArrayList();
        List<StrategyImage> G = QFSCommentRecPicClusterHelper.f83716a.G(j0());
        aa aaVar = aa.f83750a;
        if (aaVar.H() && aaVar.F() && !RFSafeListUtils.isEmpty(G)) {
            if (G == null) {
                return;
            }
            if (G.size() > 4) {
                G = G.subList(0, 4);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<StrategyImage> it = G.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getPath());
            }
            ArrayList arrayList3 = new ArrayList();
            for (LocalMediaInfo localMediaInfo : dataList) {
                contains = CollectionsKt___CollectionsKt.contains(arrayList2, localMediaInfo.getPath());
                if (!contains && !TextUtils.isEmpty(localMediaInfo.getPath())) {
                    arrayList3.add(new QFSLocalMediaInfo(localMediaInfo, false, 0, 0.0f, 0.0f, 28, null));
                }
            }
            RFWLog.d("QFSMediaListAdapter", RFWLog.USR, "update media list. recPic size: " + G.size());
            List<StrategyImage> list = G;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
            for (StrategyImage strategyImage : list) {
                LocalMediaInfo localMediaInfo2 = new LocalMediaInfo(false);
                localMediaInfo2.setPath(strategyImage.getPath());
                Object obj = strategyImage.b().get("w");
                Integer num2 = null;
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                } else {
                    num = null;
                }
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    i3 = 0;
                }
                localMediaInfo2.setMediaWidth(i3);
                Object obj2 = strategyImage.b().get(tl.h.F);
                if (obj2 instanceof Integer) {
                    num2 = (Integer) obj2;
                }
                if (num2 != null) {
                    i16 = num2.intValue();
                } else {
                    i16 = 0;
                }
                localMediaInfo2.setMediaHeight(i16);
                arrayList4.add(new QFSLocalMediaInfo(localMediaInfo2, true, strategyImage.getStrategy(), 0.0f, strategyImage.getScore(), 8, null));
            }
            arrayList.addAll(arrayList4);
            arrayList.addAll(arrayList3);
            this.media.addAll(arrayList);
            submitList(arrayList);
            return;
        }
        List<LocalMediaInfo> list2 = dataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList5.add(new QFSLocalMediaInfo((LocalMediaInfo) it5.next(), false, 0, 0.0f, 0.0f, 28, null));
        }
        arrayList.addAll(arrayList5);
        this.media.addAll(arrayList);
        submitList(arrayList);
    }

    @NotNull
    public final List<QFSLocalMediaInfo> k0() {
        return this.media;
    }

    public final void l0(@Nullable QCircleReportBean reportBean) {
        this.reportBean = reportBean;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int pos) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof o) {
            QFSLocalMediaInfo mediaInfo = getItem(pos);
            Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
            ((o) holder).m(mediaInfo, pos, this.reportBean);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0 && viewType != 1) {
            if (viewType != 2) {
                return new c(new ImageView(parent.getContext()));
            }
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ftg, parent, false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f24910_e);
            QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(parent.getContext()).setImageType(6);
            String string = parent.getContext().getString(R.string.f1771933a);
            Intrinsics.checkNotNullExpressionValue(string, "parent.context.getString\u2026ring.qalbum_picker_empty)");
            relativeLayout.addView(imageType.setDesc(string).setBackgroundColorType(0).build(), layoutParams);
            return new b(inflate);
        }
        View frameLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.g_0, (ViewGroup) null, false);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.image);
        int screenWidth = DisplayUtil.getScreenWidth();
        Companion companion = INSTANCE;
        int a16 = companion.a() - 1;
        jy2.f fVar = jy2.f.f411169a;
        int f16 = (screenWidth - (a16 * fVar.f(Float.valueOf(2.0f)))) / companion.a();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(f16, f16);
        layoutParams2.topMargin = fVar.f(Float.valueOf(2.0f));
        imageView.setLayoutParams(layoutParams2);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "frameLayout");
        return new o(frameLayout);
    }
}
