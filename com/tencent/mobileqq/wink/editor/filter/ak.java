package com.tencent.mobileqq.wink.editor.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.wink.editor.filter.ak;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.videocut.model.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u000b*\u0001=\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003DEFB\u001d\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030$\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\tJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003J\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tJ\b\u0010\u001c\u001a\u00020\tH\u0016J\u0006\u0010\u001d\u001a\u00020\u0005R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R8\u00100\u001a&\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010,0*j\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010,`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/ak;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/filter/ak$c;", "Lcom/tencent/mobileqq/wink/editor/filter/an;", "videoItem", "", "v0", "u0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "t0", "holder", "position", "p0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "x0", "m0", "", "currentDurationUs", "playerDurationUs", "filterModeRange", "r0", "getItemCount", "release", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "o0", "()Ljava/util/List;", "videoItems", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "thumbnailMap", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "E", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", "n0", "()Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", "w0", "(Lcom/tencent/mobileqq/wink/editor/filter/ak$b;)V", "videoItemClickListener", "com/tencent/mobileqq/wink/editor/filter/ak$e", "G", "Lcom/tencent/mobileqq/wink/editor/filter/ak$e;", "thumbnailGeneratedListener", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "H", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ak extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<an> videoItems;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Object, Bitmap> thumbnailMap;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private b videoItemClickListener;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e thumbnailGeneratedListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", "", "Lcom/tencent/mobileqq/wink/editor/filter/an;", "videoItem", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@NotNull an videoItem);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b&\u0010'J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/ak$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "position", "Lcom/tencent/mobileqq/wink/editor/filter/an;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "videoItem", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "itemCount", DomainData.DOMAIN_NAME, "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", "getItemClickListener", "()Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", "itemClickListener", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mCoverImageView", "H", "mFilterSelectedView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mFilterNameView", "J", "mFilterVideoTimeView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/wink/editor/filter/ak$b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private final b itemClickListener;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private final ImageView mCoverImageView;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private final View mFilterSelectedView;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private final TextView mFilterNameView;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private final TextView mFilterVideoTimeView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView, @Nullable b bVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.itemView = itemView;
            this.itemClickListener = bVar;
            this.mCoverImageView = (ImageView) this.itemView.findViewById(R.id.v5z);
            this.mFilterSelectedView = this.itemView.findViewById(R.id.v5y);
            this.mFilterNameView = (TextView) this.itemView.findViewById(R.id.suy);
            this.mFilterVideoTimeView = (TextView) this.itemView.findViewById(R.id.f165208v62);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.filter.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ak.c.m(ak.c.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(c this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            b bVar = this$0.itemClickListener;
            if (bVar != null) {
                Object tag = view.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.filter.WinkFilterVideoItem");
                bVar.a((an) tag);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(View view, int position, an item) {
            VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_THUMBNAIL_ITEM);
            VideoReport.setElementReuseIdentifier(view, String.valueOf(item.hashCode()));
            Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
            reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CLIP_INDEX, Integer.valueOf(position + 1));
            Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
            reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
            VideoReport.setElementParams(view, reportMap);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0064  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void n(@NotNull an videoItem, @Nullable Bitmap bitmap, int position, int itemCount) {
            Unit unit;
            boolean z16;
            TextView textView;
            int roundToInt;
            boolean z17;
            ImageView imageView;
            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
            this.itemView.setTag(videoItem);
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            o(itemView, position, videoItem);
            if (bitmap != null) {
                ImageView imageView2 = this.mCoverImageView;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(bitmap);
                }
                ImageView imageView3 = this.mCoverImageView;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null && (imageView = this.mCoverImageView) != null) {
                imageView.setVisibility(8);
            }
            String filterName = videoItem.getFilterName();
            if (filterName != null) {
                if (filterName.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (!z16) {
                        TextView textView2 = this.mFilterNameView;
                        if (textView2 != null) {
                            textView2.setText(videoItem.getFilterName());
                        }
                        TextView textView3 = this.mFilterNameView;
                        if (textView3 != null) {
                            textView3.setVisibility(0);
                        }
                    } else {
                        TextView textView4 = this.mFilterNameView;
                        if (textView4 != null) {
                            textView4.setVisibility(8);
                        }
                    }
                    textView = this.mFilterVideoTimeView;
                    if (textView != null) {
                        roundToInt = MathKt__MathJVMKt.roundToInt(((float) videoItem.getDuration()) / 10000.0f);
                        textView.setText((roundToInt / 100.0f) + ReportConstant.COSTREPORT_PREFIX);
                    }
                    if (!videoItem.getIsSelect()) {
                        View view = this.mFilterSelectedView;
                        if (view != null) {
                            view.setBackgroundResource(R.drawable.l4x);
                        }
                    } else {
                        View view2 = this.mFilterSelectedView;
                        if (view2 != null) {
                            view2.setBackgroundResource(R.color.ajr);
                        }
                    }
                    if (position != 0) {
                        this.itemView.setPadding(ViewExKt.d(16), 0, 0, 0);
                    } else {
                        this.itemView.setPadding(ViewExKt.d(8), 0, 0, 0);
                    }
                    if (position != itemCount - 1) {
                        View view3 = this.itemView;
                        view3.setPadding(view3.getPaddingLeft(), 0, ViewExKt.d(8), 0);
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            if (!z16) {
            }
            textView = this.mFilterVideoTimeView;
            if (textView != null) {
            }
            if (!videoItem.getIsSelect()) {
            }
            if (position != 0) {
            }
            if (position != itemCount - 1) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/filter/ak$d", "Lcom/tencent/mobileqq/wink/editor/filter/ak$b;", "Lcom/tencent/mobileqq/wink/editor/filter/an;", "videoItem", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements b {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.filter.ak.b
        public void a(@NotNull an videoItem) {
            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
            ak.this.v0(videoItem);
            b videoItemClickListener = ak.this.getVideoItemClickListener();
            if (videoItemClickListener != null) {
                videoItemClickListener.a(videoItem);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/filter/ak$e", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ak this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.notifyItemChanged(i3);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            int i3;
            final int i16 = 0;
            if (bitmap != null) {
                i3 = bitmap.getWidth();
            } else {
                i3 = 0;
            }
            w53.b.a("WinkFilterVideoAdapter", "onThumbnailGenerated startTimeMs " + startTimeMs + ", bitmap width: " + i3 + ", tag " + tag);
            if (bitmap == null) {
                return;
            }
            List<an> o06 = ak.this.o0();
            final ak akVar = ak.this;
            for (Object obj : o06) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                an anVar = (an) obj;
                if (Intrinsics.areEqual(anVar.getId(), tag)) {
                    akVar.thumbnailMap.put(anVar.getId(), bitmap);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.am
                        @Override // java.lang.Runnable
                        public final void run() {
                            ak.e.c(ak.this, i16);
                        }
                    });
                }
                i16 = i17;
            }
        }
    }

    public ak(@NotNull Context context, @NotNull List<an> videoItems) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoItems, "videoItems");
        this.context = context;
        this.videoItems = videoItems;
        this.thumbnailMap = new HashMap<>();
        this.thumbnailProvider = com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a;
        this.thumbnailGeneratedListener = new e();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = videoItems.iterator();
        while (true) {
            int i16 = 0;
            if (!it.hasNext()) {
                break;
            }
            an anVar = (an) it.next();
            String thumbUrl = anVar.getThumbUrl();
            MediaType type = anVar.getType();
            if (type != null) {
                i16 = type.ordinal();
            }
            arrayList.add(new ThumbAssetModel(thumbUrl, i16, anVar.getDuration()));
        }
        ThumbnailProviderManager.f319211a.d(arrayList, "WinkFilterVideoAdapter");
        this.thumbnailProvider.b(this.thumbnailGeneratedListener);
        for (an anVar2 : this.videoItems) {
            Bitmap bitmapByTime = this.thumbnailProvider.getBitmapByTime(anVar2.getSelectStart(), anVar2.getId(), anVar2.getThumbUrl());
            long selectStart = anVar2.getSelectStart();
            if (bitmapByTime != null) {
                i3 = bitmapByTime.getWidth();
            } else {
                i3 = 0;
            }
            w53.b.a("WinkFilterVideoAdapter", "get bitmap sync startTimeMs " + selectStart + ", bitmap width: " + i3 + ", tag " + anVar2.getId());
            this.thumbnailMap.put(anVar2.getId(), bitmapByTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    private final void u0() {
        Iterator<T> it = this.videoItems.iterator();
        while (it.hasNext()) {
            ((an) it.next()).m(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(an videoItem) {
        int i3 = 0;
        for (Object obj : this.videoItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            an anVar = (an) obj;
            if (anVar.getIsSelect() != Intrinsics.areEqual(anVar, videoItem)) {
                anVar.m(Intrinsics.areEqual(anVar, videoItem));
                notifyItemChanged(i3);
            }
            i3 = i16;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.videoItems.size();
    }

    public final int l0(@Nullable an item) {
        if (item != null) {
            return this.videoItems.indexOf(item);
        }
        return -1;
    }

    @Nullable
    public final an m0() {
        Object obj;
        Iterator<T> it = this.videoItems.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((an) obj).getIsSelect()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (an) obj;
    }

    @Nullable
    /* renamed from: n0, reason: from getter */
    public final b getVideoItemClickListener() {
        return this.videoItemClickListener;
    }

    @NotNull
    public final List<an> o0() {
        return this.videoItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.n(this.videoItems.get(position), this.thumbnailMap.get(this.videoItems.get(position).getId()), position, getNUM_BACKGOURND_ICON());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.hde, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ideo_item, parent, false)");
        return new c(inflate, new d());
    }

    public final int r0(long currentDurationUs, long playerDurationUs, int filterModeRange) {
        int i3 = 0;
        for (Object obj : this.videoItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            an anVar = (an) obj;
            if (anVar.getStartTime() <= currentDurationUs && anVar.getStartTime() + anVar.getDuration() >= currentDurationUs && !anVar.getIsSelect()) {
                u0();
                w53.b.c("WinkFilterVideoAdapter", "currentDurationUs:" + currentDurationUs + ", start:" + anVar.getStartTime() + ", duration:" + anVar.getDuration());
                anVar.m(true);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.aj
                    @Override // java.lang.Runnable
                    public final void run() {
                        ak.s0(ak.this);
                    }
                });
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    public final void release() {
        this.thumbnailProvider.c(this.thumbnailGeneratedListener);
        ThumbnailProviderManager.f319211a.r("WinkFilterVideoAdapter");
    }

    public final void t0(@NotNull an videoItem) {
        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
        b bVar = this.videoItemClickListener;
        if (bVar != null) {
            bVar.a(videoItem);
        }
    }

    public final void w0(@Nullable b bVar) {
        this.videoItemClickListener = bVar;
    }

    public final void x0(@Nullable MetaMaterial material, int position) {
        String str;
        String str2;
        Map<String, String> map;
        if (this.videoItems.size() >= position && position >= 0) {
            an anVar = this.videoItems.get(position);
            Integer num = null;
            if (material != null) {
                str = material.f30533id;
            } else {
                str = null;
            }
            if (material != null && (map = material.additionalFields) != null) {
                str2 = map.get("name");
            } else {
                str2 = null;
            }
            if (material != null) {
                num = Integer.valueOf(f.i(material));
            }
            anVar.k(str, str2, num);
            notifyItemChanged(position);
        }
    }
}
