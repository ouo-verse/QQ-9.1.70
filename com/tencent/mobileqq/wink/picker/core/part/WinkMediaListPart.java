package com.tencent.mobileqq.wink.picker.core.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaTakeCaptureFirstItemAdapter;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView;
import com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.AppSetting;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0004fghiB\u0017\u0012\u0006\u0010/\u001a\u00020*\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0003J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u001c\u0010\u0016\u001a\u00020\u00032\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010&\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010$H\u0017J\u0012\u0010)\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010@\u001a\u00060=R\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u00105R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010UR\u0014\u0010X\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u00105R\u0016\u0010Z\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u00105R\u0016\u0010\\\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010PR\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010P\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnTouchListener;", "", "aa", "", "ea", "ha", "position", "", "pa", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ca", "ia", "ga", "initViewModel", "ba", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "uiStateData", "ra", "Le93/a;", "action", "sa", "qa", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "v", "Landroid/view/MotionEvent;", "event", "onTouch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "d", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "da", "()Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "e", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "winkMediaViewModel", "f", "I", "viewHolderGap", tl.h.F, "mediaViewHolderSize", "Lcom/tencent/mobileqq/wink/picker/core/view/MediaRecyclerView;", "i", "Lcom/tencent/mobileqq/wink/picker/core/view/MediaRecyclerView;", "mediaRecyclerView", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$MediaListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$MediaListAdapter;", "mediaListAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "D", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "contactAdapter", "E", "firstRowContentSize", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "G", "Z", "showFooter", "H", "selectEnable", "Lcom/tencent/mobileqq/wink/picker/core/view/d;", "Lcom/tencent/mobileqq/wink/picker/core/view/d;", "timelineController", "J", "timeBubbleOffset", "K", "scrollLength", "L", "hasReportScroll", "Landroid/graphics/Paint;", "M", "Landroid/graphics/Paint;", "paint", "N", "isPublishVersion", "<init>", "(Lcom/tencent/mobileqq/wink/picker/MediaType;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;)V", "P", "a", "b", "c", "MediaListAdapter", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaListPart extends Part implements View.OnTouchListener {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ColorDrawable Q = new ColorDrawable(Integer.MIN_VALUE);

    /* renamed from: C, reason: from kotlin metadata */
    private GridLayoutManager layoutManager;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RFWConcatAdapter contactAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private int firstRowContentSize;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private WinkSelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean showFooter;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean selectEnable;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.picker.core.view.d timelineController;

    /* renamed from: J, reason: from kotlin metadata */
    private final int timeBubbleOffset;

    /* renamed from: K, reason: from kotlin metadata */
    private int scrollLength;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean hasReportScroll;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: N, reason: from kotlin metadata */
    private final boolean isPublishVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaType mediaType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseWinkMediaViewModel winkMediaViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int viewHolderGap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mediaViewHolderSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MediaRecyclerView mediaRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MediaListAdapter mediaListAdapter;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$MediaListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/wink/picker/core/b;", "k0", "l0", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemViewType", "getItemCount", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "m0", "()Ljava/util/List;", QAdVrReportParams.ParamKey.MEDIA, "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class MediaListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final List<LocalMediaInfo> media;
        final /* synthetic */ WinkMediaListPart D;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WinkSelectedMediaViewModel selectedMediaViewModel;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f324525a;

            static {
                int[] iArr = new int[MediaType.values().length];
                try {
                    iArr[MediaType.LOCAL_ALL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MediaType.QZONE_ALL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MediaType.LOCAL_VIDEO.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MediaType.LOCAL_IMAGE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f324525a = iArr;
            }
        }

        public MediaListAdapter(@NotNull WinkMediaListPart winkMediaListPart, WinkSelectedMediaViewModel selectedMediaViewModel) {
            Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
            this.D = winkMediaListPart;
            this.selectedMediaViewModel = selectedMediaViewModel;
            this.media = new ArrayList();
        }

        private final com.tencent.mobileqq.wink.picker.core.b k0(ViewGroup parent, int viewType) {
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
            View itemView = from.inflate(cVar.e().getMediaViewHolderLayout(), parent, false);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.D.mediaViewHolderSize, this.D.mediaViewHolderSize);
            if (viewType == 1) {
                marginLayoutParams.topMargin = this.D.viewHolderGap;
            }
            itemView.setLayoutParams(marginLayoutParams);
            com.tencent.mobileqq.wink.picker.core.d e16 = cVar.e();
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return e16.f(itemView, this.selectedMediaViewModel);
        }

        private final com.tencent.mobileqq.wink.picker.core.b l0(ViewGroup parent, int viewType) {
            long currentTimeMillis = System.currentTimeMillis();
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
            View itemView = from.inflate(cVar.e().getMediaViewHolderLayout(), parent, false);
            long currentTimeMillis2 = System.currentTimeMillis();
            long j3 = currentTimeMillis2 - currentTimeMillis;
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.D.mediaViewHolderSize, this.D.mediaViewHolderSize);
            if (viewType == 1) {
                marginLayoutParams.topMargin = this.D.viewHolderGap;
            }
            itemView.setLayoutParams(marginLayoutParams);
            long currentTimeMillis3 = System.currentTimeMillis();
            long j16 = currentTimeMillis3 - currentTimeMillis2;
            com.tencent.mobileqq.wink.picker.core.d e16 = cVar.e();
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            com.tencent.mobileqq.wink.picker.core.b f16 = e16.f(itemView, this.selectedMediaViewModel);
            long currentTimeMillis4 = System.currentTimeMillis();
            long j17 = currentTimeMillis4 - currentTimeMillis3;
            long j18 = currentTimeMillis4 - currentTimeMillis;
            if (j18 >= 52) {
                w53.b.f("WinkMediaListPart", "[onCreateViewHolder] Cost " + j18 + ContainerUtils.KEY_VALUE_DELIMITER + j3 + Marker.ANY_NON_NULL_MARKER + j16 + Marker.ANY_NON_NULL_MARKER + j17);
            }
            return f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n0(WinkMediaListPart this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.winkMediaViewModel.loadMoreMedia();
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.D.showFooter) {
                return this.media.size() + 1;
            }
            return this.media.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (this.D.showFooter && position == getItemCount() - 1) {
                return 2;
            }
            if (position >= this.D.firstRowContentSize) {
                return 1;
            }
            return 0;
        }

        @NotNull
        public final List<LocalMediaInfo> m0() {
            return this.media;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof com.tencent.mobileqq.wink.picker.core.b) {
                LocalMediaInfo localMediaInfo = this.media.get(position);
                int i3 = a.f324525a[this.D.getMediaType().ordinal()];
                if (i3 != 1 && i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            e93.i.N(localMediaInfo, position);
                        }
                    } else {
                        e93.i.W(localMediaInfo, position);
                    }
                } else {
                    e93.i.P(localMediaInfo, position);
                }
                final WinkMediaListPart winkMediaListPart = this.D;
                Function1<View, Unit> function1 = new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart$MediaListAdapter$onBindViewHolder$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        WinkSelectedMediaViewModel winkSelectedMediaViewModel;
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.mobileqq.wink.picker.core.a d16 = com.tencent.mobileqq.wink.picker.core.c.f324480a.d();
                        List<LocalMediaInfo> m06 = WinkMediaListPart.MediaListAdapter.this.m0();
                        MediaType mediaType = winkMediaListPart.getMediaType();
                        int i16 = position;
                        winkSelectedMediaViewModel = WinkMediaListPart.MediaListAdapter.this.selectedMediaViewModel;
                        d16.b(it, m06, mediaType, i16, winkSelectedMediaViewModel);
                    }
                };
                final WinkMediaListPart winkMediaListPart2 = this.D;
                ((com.tencent.mobileqq.wink.picker.core.b) holder).l(localMediaInfo, function1, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart$MediaListAdapter$onBindViewHolder$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        WinkSelectedMediaViewModel winkSelectedMediaViewModel;
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.mobileqq.wink.picker.core.a d16 = com.tencent.mobileqq.wink.picker.core.c.f324480a.d();
                        LocalMediaInfo localMediaInfo2 = WinkMediaListPart.MediaListAdapter.this.m0().get(position);
                        MediaType mediaType = winkMediaListPart2.getMediaType();
                        winkSelectedMediaViewModel = WinkMediaListPart.MediaListAdapter.this.selectedMediaViewModel;
                        d16.a(it, localMediaInfo2, mediaType, winkSelectedMediaViewModel);
                    }
                });
                return;
            }
            if (holder instanceof c) {
                View view = holder.itemView;
                final WinkMediaListPart winkMediaListPart3 = this.D;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WinkMediaListPart.MediaListAdapter.n0(WinkMediaListPart.this, view2);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            com.tencent.mobileqq.wink.picker.core.b l06;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (viewType != 0 && viewType != 1) {
                WinkMediaListPart winkMediaListPart = this.D;
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.i69, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026ew_footer, parent, false)");
                return new c(winkMediaListPart, inflate);
            }
            if (this.D.isPublishVersion) {
                l06 = k0(parent, viewType);
            } else {
                l06 = l0(parent, viewType);
            }
            return l06;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\tR\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$a;", "", "Landroid/graphics/drawable/ColorDrawable;", "SELECTED_MASK_COLOR", "Landroid/graphics/drawable/ColorDrawable;", "a", "()Landroid/graphics/drawable/ColorDrawable;", "", "CREATE_VIEW_HOLDER_COST_THRESHOLD_MS", "I", "", "DINALTERNATE_BOLD_FONT_PATH", "Ljava/lang/String;", "LOAD_MORE_ITEM_SPAN_COUNT", "MEDIA_ITEM_SPAN_COUNT", "TAG", "", "THUMB_IMAGE_DISABLE_ALPHA", UserInfo.SEX_FEMALE, "THUMB_IMAGE_ENABLE_ALPHA", "THUMB_IMAGE_SIZE", "TIMEVIEW_HEIGHT", "TIMEVIEW_TEXT_SIZE", "VIEW_HOLD_GAP", "VIEW_TYPE_CONTENT", "VIEW_TYPE_CONTENT_FIRST_ROW", "VIEW_TYPE_FOOTER", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorDrawable a() {
            return WinkMediaListPart.Q;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "d", "Ljava/util/List;", QAdVrReportParams.ParamKey.MEDIA, "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<LocalMediaInfo> media;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkMediaListPart f324527e;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull WinkMediaListPart winkMediaListPart, List<? extends LocalMediaInfo> media) {
            Intrinsics.checkNotNullParameter(media, "media");
            this.f324527e = winkMediaListPart;
            this.media = media;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (this.media.isEmpty()) {
                return;
            }
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (this.f324527e.showFooter) {
                MediaListAdapter mediaListAdapter = this.f324527e.mediaListAdapter;
                if (mediaListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter = null;
                }
                if (childAdapterPosition == mediaListAdapter.getItemCount() - 1) {
                    return;
                }
            }
            MediaListAdapter mediaListAdapter2 = this.f324527e.mediaListAdapter;
            if (mediaListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter2 = null;
            }
            String t16 = e93.i.t(mediaListAdapter2.m0().get(childAdapterPosition));
            int i3 = childAdapterPosition;
            while (true) {
                if (-1 >= i3) {
                    break;
                }
                MediaListAdapter mediaListAdapter3 = this.f324527e.mediaListAdapter;
                if (mediaListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter3 = null;
                }
                if (!Intrinsics.areEqual(e93.i.t(mediaListAdapter3.m0().get(i3)), t16)) {
                    childAdapterPosition = (childAdapterPosition - i3) - 1;
                    break;
                }
                i3--;
            }
            if (childAdapterPosition < 3) {
                outRect.set(0, ViewUtils.dpToPx(45.0f), 0, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            String t16;
            String replace$default;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onDraw(canvas, parent, state);
            if (this.media.isEmpty()) {
                return;
            }
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewGroup.LayoutParams layoutParams = parent.getChildAt(i3).getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
                this.f324527e.paint.setStyle(Paint.Style.FILL);
                this.f324527e.paint.setTextSize(com.tencent.mobileqq.util.x.j(this.f324527e.getContext(), 16.0f));
                this.f324527e.paint.setColor(ContextCompat.getColor(this.f324527e.getContext(), R.color.qui_common_text_primary));
                this.f324527e.paint.setTypeface(Typeface.createFromAsset(this.f324527e.getContext().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
                Paint.FontMetrics fontMetrics = this.f324527e.paint.getFontMetrics();
                float f16 = fontMetrics.bottom;
                float dpToPx = (ViewUtils.dpToPx(45.0f) / 2) - (((f16 - fontMetrics.top) / 2) - f16);
                if (this.f324527e.showFooter) {
                    MediaListAdapter mediaListAdapter = this.f324527e.mediaListAdapter;
                    if (mediaListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                        mediaListAdapter = null;
                    }
                    if (viewLayoutPosition == mediaListAdapter.getItemCount() - 1) {
                    }
                }
                if ((viewLayoutPosition == 0 || (e93.i.t(this.media.get(viewLayoutPosition)) != null && !Intrinsics.areEqual(e93.i.t(this.media.get(viewLayoutPosition)), e93.i.t(this.media.get(viewLayoutPosition - 1))))) && (t16 = e93.i.t(this.media.get(viewLayoutPosition))) != null) {
                    WinkMediaListPart winkMediaListPart = this.f324527e;
                    replace$default = StringsKt__StringsJVMKt.replace$default(t16, "-", "/", false, 4, (Object) null);
                    canvas.drawText(replace$default, ViewUtils.dpToPx(16.0f), r1.getTop() - dpToPx, winkMediaListPart.paint);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends RecyclerView.ViewHolder {
        final /* synthetic */ WinkMediaListPart E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull WinkMediaListPart winkMediaListPart, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = winkMediaListPart;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324528a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.LOCAL_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.QZONE_ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.LOCAL_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaType.LOCAL_IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f324528a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$f", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends GridLayoutManager.SpanSizeLookup {
        f() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (WinkMediaListPart.this.getMediaType() == MediaType.QZONE_ALL) {
                if (!WinkMediaListPart.this.pa(position)) {
                    MediaListAdapter mediaListAdapter = WinkMediaListPart.this.mediaListAdapter;
                    if (mediaListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                        mediaListAdapter = null;
                    }
                    if (position < mediaListAdapter.m0().size() - 1) {
                        MediaListAdapter mediaListAdapter2 = WinkMediaListPart.this.mediaListAdapter;
                        if (mediaListAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                            mediaListAdapter2 = null;
                        }
                        if (e93.i.t(mediaListAdapter2.m0().get(position)) != null) {
                            MediaListAdapter mediaListAdapter3 = WinkMediaListPart.this.mediaListAdapter;
                            if (mediaListAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                                mediaListAdapter3 = null;
                            }
                            String t16 = e93.i.t(mediaListAdapter3.m0().get(position));
                            MediaListAdapter mediaListAdapter4 = WinkMediaListPart.this.mediaListAdapter;
                            if (mediaListAdapter4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                                mediaListAdapter4 = null;
                            }
                            if (!Intrinsics.areEqual(t16, e93.i.t(mediaListAdapter4.m0().get(position + 1)))) {
                                MediaListAdapter mediaListAdapter5 = WinkMediaListPart.this.mediaListAdapter;
                                if (mediaListAdapter5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                                    mediaListAdapter5 = null;
                                }
                                String t17 = e93.i.t(mediaListAdapter5.m0().get(position));
                                int i3 = position;
                                while (true) {
                                    if (-1 >= i3) {
                                        break;
                                    }
                                    MediaListAdapter mediaListAdapter6 = WinkMediaListPart.this.mediaListAdapter;
                                    if (mediaListAdapter6 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                                        mediaListAdapter6 = null;
                                    }
                                    if (!Intrinsics.areEqual(e93.i.t(mediaListAdapter6.m0().get(i3)), t17)) {
                                        position = (position - i3) - 1;
                                        break;
                                    }
                                    i3--;
                                }
                                return 3 - (position % 3);
                            }
                        }
                    }
                } else {
                    return 3;
                }
            } else if (WinkMediaListPart.this.pa(position)) {
                return 3;
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$g", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g extends RecyclerView.OnScrollListener {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (dy5 > 0 && WinkMediaListPart.this.qa()) {
                WinkMediaListPart.this.winkMediaViewModel.loadMoreMedia();
            }
            WinkMediaListPart.this.scrollLength += dy5;
            if (!WinkMediaListPart.this.hasReportScroll && WinkMediaListPart.this.scrollLength >= WinkMediaListPart.this.mediaViewHolderSize) {
                WinkMediaListPart.this.hasReportScroll = true;
                com.tencent.mobileqq.wink.picker.report.a.q("em_xsj_content");
            }
        }
    }

    public WinkMediaListPart(@NotNull MediaType mediaType, @NotNull BaseWinkMediaViewModel winkMediaViewModel) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(winkMediaViewModel, "winkMediaViewModel");
        this.mediaType = mediaType;
        this.winkMediaViewModel = winkMediaViewModel;
        this.firstRowContentSize = 3;
        this.selectEnable = true;
        this.timeBubbleOffset = ViewUtils.dpToPx(59.0f);
        this.paint = new Paint();
        com.tencent.mobileqq.wink.picker.core.c.f324480a.e().b();
        this.isPublishVersion = AppSetting.isPublicVersion() && !AppSetting.isGrayVersion();
    }

    private final void aa() {
        this.mediaViewHolderSize = (ea() - (this.viewHolderGap * 2)) / 3;
    }

    private final void ba() {
        com.tencent.mobileqq.wink.picker.core.view.a aVar;
        MediaRecyclerView mediaRecyclerView;
        MediaRecyclerView mediaRecyclerView2 = this.mediaRecyclerView;
        MediaRecyclerView mediaRecyclerView3 = null;
        if (mediaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView2 = null;
        }
        WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.selectedMediaViewModel;
        if (winkSelectedMediaViewModel != null) {
            MediaRecyclerView mediaRecyclerView4 = this.mediaRecyclerView;
            if (mediaRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView = null;
            } else {
                mediaRecyclerView = mediaRecyclerView4;
            }
            MediaType mediaType = this.mediaType;
            MediaListAdapter mediaListAdapter = this.mediaListAdapter;
            if (mediaListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter = null;
            }
            aVar = new com.tencent.mobileqq.wink.picker.core.view.a(mediaRecyclerView, mediaType, mediaListAdapter.m0(), winkSelectedMediaViewModel, new e());
        } else {
            aVar = null;
        }
        mediaRecyclerView2.setOnIndexChangedListener(aVar);
        MediaRecyclerView mediaRecyclerView5 = this.mediaRecyclerView;
        if (mediaRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView5 = null;
        }
        if (mediaRecyclerView5.getLayoutManager() instanceof GridLayoutManager) {
            MediaRecyclerView mediaRecyclerView6 = this.mediaRecyclerView;
            if (mediaRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView6 = null;
            }
            MediaRecyclerView mediaRecyclerView7 = this.mediaRecyclerView;
            if (mediaRecyclerView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView3 = mediaRecyclerView7;
            }
            RecyclerView.LayoutManager layoutManager = mediaRecyclerView3.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            mediaRecyclerView6.setGridLayoutManager((GridLayoutManager) layoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> ca() {
        WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.selectedMediaViewModel;
        MediaListAdapter mediaListAdapter = null;
        if (winkSelectedMediaViewModel == null) {
            return null;
        }
        int i3 = 2;
        if (winkSelectedMediaViewModel != null) {
            if (this.mediaListAdapter == null) {
                this.mediaListAdapter = new MediaListAdapter(this, winkSelectedMediaViewModel);
            }
            com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
            com.tencent.mobileqq.wink.picker.core.adapter.c i16 = cVar.e().i(this, this.mediaViewHolderSize);
            if (i16 != null) {
                RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
                adapterArr[0] = i16;
                MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
                if (mediaListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter2 = null;
                }
                adapterArr[1] = mediaListAdapter2;
                this.contactAdapter = new RFWConcatAdapter(adapterArr);
            } else if (cVar.b().getFirstIconCamera() && Intrinsics.areEqual(this.winkMediaViewModel.getMediaStoragePermissionLiveData().getValue(), Boolean.TRUE)) {
                RecyclerView.Adapter[] adapterArr2 = new RecyclerView.Adapter[2];
                adapterArr2[0] = new WinkMediaTakeCaptureFirstItemAdapter(this, this.mediaViewHolderSize);
                MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
                if (mediaListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter3 = null;
                }
                adapterArr2[1] = mediaListAdapter3;
                this.contactAdapter = new RFWConcatAdapter(adapterArr2);
            }
        }
        RFWConcatAdapter rFWConcatAdapter = this.contactAdapter;
        if (rFWConcatAdapter == null) {
            i3 = 3;
        }
        this.firstRowContentSize = i3;
        if (rFWConcatAdapter == null) {
            MediaListAdapter mediaListAdapter4 = this.mediaListAdapter;
            if (mediaListAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            } else {
                mediaListAdapter = mediaListAdapter4;
            }
            return mediaListAdapter;
        }
        return rFWConcatAdapter;
    }

    private final int ea() {
        Resources resources;
        DisplayMetrics displayMetrics;
        boolean isInMultiWindowMode;
        int i3;
        Resources resources2;
        Configuration configuration;
        if (Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = getActivity().isInMultiWindowMode();
            if (isInMultiWindowMode) {
                View partRootView = getPartRootView();
                if (partRootView != null && (resources2 = partRootView.getResources()) != null && (configuration = resources2.getConfiguration()) != null) {
                    i3 = configuration.screenWidthDp;
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    return ViewUtils.dip2px(i3 * 1.0f);
                }
            }
        }
        View partRootView2 = getPartRootView();
        if (partRootView2 != null && (resources = partRootView2.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            return displayMetrics.widthPixels;
        }
        return ImmersiveUtils.getScreenWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int ga() {
        MediaRecyclerView mediaRecyclerView = this.mediaRecyclerView;
        MediaRecyclerView mediaRecyclerView2 = null;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView = null;
        }
        int height = mediaRecyclerView.getHeight();
        MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
        if (mediaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
        } else {
            mediaRecyclerView2 = mediaRecyclerView3;
        }
        return (height - mediaRecyclerView2.getTop()) - this.timeBubbleOffset;
    }

    private final void ha() {
        if (this.selectedMediaViewModel == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.layoutManager = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new f());
        View findViewById = getPartRootView().findViewById(R.id.yzg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.mediaRecyclerView)");
        this.mediaRecyclerView = (MediaRecyclerView) findViewById;
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
        MediaRecyclerView mediaRecyclerView = null;
        if (b16 != null) {
            MediaType mediaType = this.mediaType;
            MediaRecyclerView mediaRecyclerView2 = this.mediaRecyclerView;
            if (mediaRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView2 = null;
            }
            b16.Dh(mediaType, mediaRecyclerView2);
        }
        MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
        if (mediaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView3 = null;
        }
        GridLayoutManager gridLayoutManager2 = this.layoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager2 = null;
        }
        mediaRecyclerView3.setLayoutManager(gridLayoutManager2);
        RecyclerView.Adapter<RecyclerView.ViewHolder> ca5 = ca();
        if (ca5 != null) {
            MediaRecyclerView mediaRecyclerView4 = this.mediaRecyclerView;
            if (mediaRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView4 = null;
            }
            mediaRecyclerView4.setAdapter(ca5);
        }
        if (this.mediaType == MediaType.QZONE_ALL) {
            MediaRecyclerView mediaRecyclerView5 = this.mediaRecyclerView;
            if (mediaRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView5 = null;
            }
            MediaListAdapter mediaListAdapter = this.mediaListAdapter;
            if (mediaListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                mediaListAdapter = null;
            }
            mediaRecyclerView5.addItemDecoration(new b(this, mediaListAdapter.m0()));
        }
        MediaRecyclerView mediaRecyclerView6 = this.mediaRecyclerView;
        if (mediaRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
        } else {
            mediaRecyclerView = mediaRecyclerView6;
        }
        mediaRecyclerView.addOnScrollListener(new g());
        if (com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getNeedDragSelect()) {
            ba();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void ia() {
        View view;
        LiveData<e93.a> Z1;
        View findViewById;
        if (!com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getNeedScrollTimeline() || !this.mediaType.isLocalMedia()) {
            return;
        }
        Activity activity = getActivity();
        MediaRecyclerView mediaRecyclerView = null;
        if (activity != null) {
            view = activity.findViewById(R.id.f99585q7);
        } else {
            view = null;
        }
        View partRootView = getPartRootView();
        MediaRecyclerView mediaRecyclerView2 = this.mediaRecyclerView;
        if (mediaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView2 = null;
        }
        this.timelineController = new com.tencent.mobileqq.wink.picker.core.view.d(view, partRootView, mediaRecyclerView2);
        MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
        if (mediaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView3 = null;
        }
        mediaRecyclerView3.setOnTouchListener(this);
        View partRootView2 = getPartRootView();
        if (partRootView2 != null && (findViewById = partRootView2.findViewById(R.id.f246109l)) != null) {
            findViewById.setOnTouchListener(this);
        }
        MediaRecyclerView mediaRecyclerView4 = this.mediaRecyclerView;
        if (mediaRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
        } else {
            mediaRecyclerView = mediaRecyclerView4;
        }
        mediaRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.part.l
            @Override // java.lang.Runnable
            public final void run() {
                WinkMediaListPart.ja(WinkMediaListPart.this);
            }
        });
        WinkSelectedMediaViewModel winkSelectedMediaViewModel = this.selectedMediaViewModel;
        if (winkSelectedMediaViewModel != null && (Z1 = winkSelectedMediaViewModel.Z1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final WinkMediaListPart$initTimelineView$2 winkMediaListPart$initTimelineView$2 = new WinkMediaListPart$initTimelineView$2(this);
            Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaListPart.la(Function1.this, obj);
                }
            });
        }
    }

    private final void initViewModel() {
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
        if (b16 != null) {
            WinkSelectedMediaViewModel j3 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
            this.winkMediaViewModel.observeSelectedMediaChange(this.mediaType, j3.Z1());
            this.selectedMediaViewModel = j3;
        }
        LiveData<UIStateData<List<LocalMediaInfo>>> mediaUIState = this.winkMediaViewModel.getMediaUIState(this.mediaType);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<LocalMediaInfo>>, Unit> function1 = new Function1<UIStateData<List<LocalMediaInfo>>, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<LocalMediaInfo>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<LocalMediaInfo>> it) {
                WinkMediaListPart winkMediaListPart = WinkMediaListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkMediaListPart.ra(it);
            }
        };
        mediaUIState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMediaListPart.ma(Function1.this, obj);
            }
        });
        LiveData<e93.a> mediaChangedActionLiveData = this.winkMediaViewModel.getMediaChangedActionLiveData();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<e93.a, Unit> function12 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e93.a it) {
                WinkMediaListPart winkMediaListPart = WinkMediaListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkMediaListPart.sa(it);
            }
        };
        mediaChangedActionLiveData.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMediaListPart.na(Function1.this, obj);
            }
        });
        LiveData<Boolean> mediaStoragePermissionLiveData = this.winkMediaViewModel.getMediaStoragePermissionLiveData();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                RecyclerView.Adapter ca5;
                MediaRecyclerView mediaRecyclerView;
                ca5 = WinkMediaListPart.this.ca();
                if (ca5 != null) {
                    mediaRecyclerView = WinkMediaListPart.this.mediaRecyclerView;
                    if (mediaRecyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                        mediaRecyclerView = null;
                    }
                    mediaRecyclerView.setAdapter(ca5);
                }
            }
        };
        mediaStoragePermissionLiveData.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMediaListPart.oa(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(WinkMediaListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.picker.core.view.d dVar = this$0.timelineController;
        if (dVar != null) {
            dVar.r(this$0.ga());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean pa(int position) {
        if (this.showFooter) {
            MediaListAdapter mediaListAdapter = null;
            if (this.contactAdapter == null) {
                MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
                if (mediaListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter2 = null;
                }
                if (position == mediaListAdapter2.getItemCount() - 1) {
                    return true;
                }
            }
            if (this.contactAdapter != null) {
                MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
                if (mediaListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                } else {
                    mediaListAdapter = mediaListAdapter3;
                }
                if (position == mediaListAdapter.getItemCount()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean qa() {
        GridLayoutManager gridLayoutManager = this.layoutManager;
        MediaListAdapter mediaListAdapter = null;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        int findLastCompletelyVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
        MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
        if (mediaListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
        } else {
            mediaListAdapter = mediaListAdapter2;
        }
        if (findLastCompletelyVisibleItemPosition == mediaListAdapter.m0().size() - 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(UIStateData<List<LocalMediaInfo>> uiStateData) {
        int state = uiStateData.getState();
        MediaListAdapter mediaListAdapter = null;
        if (state != 0) {
            if (state == 2 || state == 3) {
                this.showFooter = !uiStateData.getIsFinish();
                MediaListAdapter mediaListAdapter2 = this.mediaListAdapter;
                if (mediaListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter2 = null;
                }
                mediaListAdapter2.m0().clear();
                MediaListAdapter mediaListAdapter3 = this.mediaListAdapter;
                if (mediaListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                    mediaListAdapter3 = null;
                }
                List<LocalMediaInfo> m06 = mediaListAdapter3.m0();
                List<LocalMediaInfo> data = uiStateData.getData();
                Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
                m06.addAll(data);
                MediaListAdapter mediaListAdapter4 = this.mediaListAdapter;
                if (mediaListAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                } else {
                    mediaListAdapter = mediaListAdapter4;
                }
                mediaListAdapter.notifyDataSetChanged();
                com.tencent.mobileqq.wink.picker.core.view.d dVar = this.timelineController;
                if (dVar != null) {
                    dVar.s(uiStateData);
                    return;
                }
                return;
            }
            return;
        }
        this.showFooter = false;
        MediaListAdapter mediaListAdapter5 = this.mediaListAdapter;
        if (mediaListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            mediaListAdapter5 = null;
        }
        mediaListAdapter5.m0().clear();
        MediaListAdapter mediaListAdapter6 = this.mediaListAdapter;
        if (mediaListAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
        } else {
            mediaListAdapter = mediaListAdapter6;
        }
        mediaListAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(final e93.a action) {
        MediaRecyclerView mediaRecyclerView = this.mediaRecyclerView;
        MediaListAdapter mediaListAdapter = null;
        MediaRecyclerView mediaRecyclerView2 = null;
        MediaListAdapter mediaListAdapter2 = null;
        MediaListAdapter mediaListAdapter3 = null;
        MediaListAdapter mediaListAdapter4 = null;
        MediaListAdapter mediaListAdapter5 = null;
        MediaListAdapter mediaListAdapter6 = null;
        if (mediaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            mediaRecyclerView = null;
        }
        if (mediaRecyclerView.isComputingLayout()) {
            w53.b.g("WinkMediaListPart", "encounter isComputingLayout, post updateRecyclerViewWhenDataChanged, action=" + action);
            MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
            if (mediaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView2 = mediaRecyclerView3;
            }
            mediaRecyclerView2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.part.q
                @Override // java.lang.Runnable
                public final void run() {
                    WinkMediaListPart.ta(WinkMediaListPart.this, action);
                }
            });
            return;
        }
        if (action instanceof e93.h) {
            MediaListAdapter mediaListAdapter7 = this.mediaListAdapter;
            if (mediaListAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            } else {
                mediaListAdapter2 = mediaListAdapter7;
            }
            mediaListAdapter2.notifyDataSetChanged();
            return;
        }
        if (action instanceof e93.b) {
            int i3 = d.f324528a[this.mediaType.ordinal()];
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        MediaListAdapter mediaListAdapter8 = this.mediaListAdapter;
                        if (mediaListAdapter8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                        } else {
                            mediaListAdapter3 = mediaListAdapter8;
                        }
                        mediaListAdapter3.notifyItemChanged(e93.i.o(((e93.b) action).getAddedMedia()));
                        return;
                    }
                    return;
                }
                MediaListAdapter mediaListAdapter9 = this.mediaListAdapter;
                if (mediaListAdapter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                } else {
                    mediaListAdapter4 = mediaListAdapter9;
                }
                mediaListAdapter4.notifyItemChanged(e93.i.z(((e93.b) action).getAddedMedia()));
                return;
            }
            MediaListAdapter mediaListAdapter10 = this.mediaListAdapter;
            if (mediaListAdapter10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            } else {
                mediaListAdapter5 = mediaListAdapter10;
            }
            mediaListAdapter5.notifyItemChanged(e93.i.q(((e93.b) action).getAddedMedia()));
            return;
        }
        if (action instanceof e93.f) {
            if (!this.selectEnable) {
                this.selectEnable = true;
                MediaListAdapter mediaListAdapter11 = this.mediaListAdapter;
                if (mediaListAdapter11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
                } else {
                    mediaListAdapter6 = mediaListAdapter11;
                }
                mediaListAdapter6.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (action instanceof e93.c) {
            this.selectEnable = false;
            MediaListAdapter mediaListAdapter12 = this.mediaListAdapter;
            if (mediaListAdapter12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaListAdapter");
            } else {
                mediaListAdapter = mediaListAdapter12;
            }
            mediaListAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(WinkMediaListPart this$0, e93.a action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        this$0.sa(action);
    }

    @NotNull
    /* renamed from: da, reason: from getter */
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "WinkMediaListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mediaListAdapter != null) {
            aa();
            MediaRecyclerView mediaRecyclerView = this.mediaRecyclerView;
            if (mediaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView = null;
            }
            mediaRecyclerView.setAdapter(ca());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        this.viewHolderGap = ImmersiveUtils.dpToPx(2.0f);
        aa();
        initViewModel();
        ha();
        ia();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        w53.b.a("WinkMediaListPart", "onPartDestroy");
        MediaRecyclerView mediaRecyclerView = this.mediaRecyclerView;
        if (mediaRecyclerView != null) {
            MediaRecyclerView mediaRecyclerView2 = null;
            if (mediaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView = null;
            }
            mediaRecyclerView.setOnTouchListener(null);
            MediaRecyclerView mediaRecyclerView3 = this.mediaRecyclerView;
            if (mediaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
                mediaRecyclerView3 = null;
            }
            mediaRecyclerView3.setAdapter(null);
            MediaRecyclerView mediaRecyclerView4 = this.mediaRecyclerView;
            if (mediaRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecyclerView");
            } else {
                mediaRecyclerView2 = mediaRecyclerView4;
            }
            mediaRecyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        com.tencent.mobileqq.wink.picker.core.view.d dVar = this.timelineController;
        if (dVar != null) {
            return dVar.p(v3, event);
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart$e", "Lcom/tencent/mobileqq/wink/picker/core/view/MediaRecyclerView$c;", "", "beginIndex", "", "onSelectBegin", "selectIndex", "onSelectChanged", "onSelectEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements MediaRecyclerView.c {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView.c
        public void onSelectBegin(int beginIndex) {
            com.tencent.mobileqq.wink.picker.core.view.d dVar = WinkMediaListPart.this.timelineController;
            if (dVar != null) {
                dVar.q(false);
            }
        }

        @Override // com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView.c
        public void onSelectEnd() {
            com.tencent.mobileqq.wink.picker.core.view.d dVar = WinkMediaListPart.this.timelineController;
            if (dVar != null) {
                dVar.q(true);
            }
        }

        @Override // com.tencent.mobileqq.wink.picker.core.view.MediaRecyclerView.c
        public void onSelectChanged(int beginIndex, int selectIndex) {
        }
    }
}
