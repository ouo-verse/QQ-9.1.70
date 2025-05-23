package fk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.base.l;
import com.qzone.util.ar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nk.z;
import qj.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J*\u0010\u0017\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u0014\u0010\u001c\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0016\u00100\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00102\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010'\u00a8\u00065"}, d2 = {"Lfk/d;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", "u", "w", "v", "Lnk/z;", HippyTKDListViewAdapter.X, "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "y", "view", NodeProps.ON_CLICK, "e", "Ljava/lang/String;", "TAG", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "mAlbumSyncContainer", "Landroid/widget/LinearLayout;", h.F, "Landroid/widget/LinearLayout;", "mAlbumInSyncContainer", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mAlbumInSyncText", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mAlbumSyncLoadingView", BdhLogUtil.LogTag.Tag_Conn, "mAlbumSyncRetryContainer", "D", "mAlbumSyncRetryArea", "E", "mAlbumSyncCancel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends l<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout mAlbumSyncRetryContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout mAlbumSyncRetryArea;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mAlbumSyncCancel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateAlbumListSyncSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mAlbumSyncContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAlbumInSyncContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumInSyncText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumSyncLoadingView;

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        View view = null;
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getStatus() == 2) {
            FrameLayout frameLayout = this.mAlbumSyncContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
                frameLayout = null;
            }
            frameLayout.setClickable(true);
            FrameLayout frameLayout2 = this.mAlbumSyncContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
                frameLayout2 = null;
            }
            frameLayout2.setVisibility(0);
            LinearLayout linearLayout = this.mAlbumInSyncContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumInSyncContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.mAlbumSyncRetryContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncRetryContainer");
            } else {
                view = linearLayout2;
            }
            view.setVisibility(8);
            return;
        }
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getStatus() == 3) {
            FrameLayout frameLayout3 = this.mAlbumSyncContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
                frameLayout3 = null;
            }
            frameLayout3.setClickable(true);
            FrameLayout frameLayout4 = this.mAlbumSyncContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
                frameLayout4 = null;
            }
            frameLayout4.setVisibility(0);
            LinearLayout linearLayout3 = this.mAlbumInSyncContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumInSyncContainer");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(8);
            LinearLayout linearLayout4 = this.mAlbumSyncRetryContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncRetryContainer");
            } else {
                view = linearLayout4;
            }
            view.setVisibility(0);
            return;
        }
        FrameLayout frameLayout5 = this.mAlbumSyncContainer;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
            frameLayout5 = null;
        }
        frameLayout5.setClickable(false);
        FrameLayout frameLayout6 = this.mAlbumSyncContainer;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
        } else {
            view = frameLayout6;
        }
        view.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        RFWLog.i(this.TAG, RFWLog.USR, "[clickAlbumSyncCancelView]" + ((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId());
        z x16 = x();
        if (x16 != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            x16.P1((CommonAlbumListBean) mData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        ArrayList<String> arrayListOf;
        RFWLog.i(this.TAG, RFWLog.USR, "[clickAlbumSyncRetryArea]" + ((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId());
        g gVar = (g) q(g.class);
        if (gVar != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId());
            gVar.i2(arrayListOf);
        }
    }

    private final z x() {
        qj.c cVar = (qj.c) q(qj.c.class);
        if (cVar != null) {
            return cVar.J7();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        if (id5 == R.id.n3y) {
            v();
        } else if (id5 == R.id.f162883n45) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162878n40);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ate_album_sync_container)");
        this.mAlbumSyncContainer = (FrameLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n3m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026_album_in_sync_container)");
        this.mAlbumInSyncContainer = (LinearLayout) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n3n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026imate_album_in_sync_text)");
        this.mAlbumInSyncText = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f162882n44);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026imate_album_sync_loading)");
        this.mAlbumSyncLoadingView = (ImageView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.n46);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026bum_sync_retry_container)");
        this.mAlbumSyncRetryContainer = (LinearLayout) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f162883n45);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026te_album_sync_retry_area)");
        this.mAlbumSyncRetryArea = (LinearLayout) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.n3y);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026timate_album_sync_cancel)");
        this.mAlbumSyncCancel = (TextView) findViewById7;
        LinearLayout linearLayout = this.mAlbumSyncRetryArea;
        ImageView imageView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncRetryArea");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        TextView textView = this.mAlbumSyncCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncCancel");
            textView = null;
        }
        textView.setOnClickListener(this);
        FrameLayout frameLayout = this.mAlbumSyncContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        FrameLayout frameLayout2 = this.mAlbumSyncContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncContainer");
            frameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        ImageView imageView2 = this.mAlbumSyncLoadingView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncLoadingView");
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(p(), 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlu};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        if (data != null) {
            u();
        }
    }
}
