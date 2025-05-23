package com.tencent.aelight.camera.ae.flashshow.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u00108\u001a\u00020\u001a\u00a2\u0006\u0004\b9\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/dq;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "data", "", "e", "g", tl.h.F, "f", "j", "i", "info", "c", "Landroid/content/Context;", "context", "b", "", "state", "d", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "getMImgvTemplateIcon", "()Lcom/tencent/image/URLImageView;", "setMImgvTemplateIcon", "(Lcom/tencent/image/URLImageView;)V", "mImgvTemplateIcon", "Landroid/view/View;", "Landroid/view/View;", "getMHightlightImage", "()Landroid/view/View;", "setMHightlightImage", "(Landroid/view/View;)V", "mHightlightImage", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getMImgDownAndNewIcon", "()Landroid/widget/ImageView;", "setMImgDownAndNewIcon", "(Landroid/widget/ImageView;)V", "mImgDownAndNewIcon", "getTopRightIcon", "setTopRightIcon", "topRightIcon", "Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "getMAEProgressView", "()Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "setMAEProgressView", "(Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;)V", "mAEProgressView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mCurrentState", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "mContext", "itemView", "<init>", "D", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class dq extends RecyclerView.ViewHolder {

    /* renamed from: C, reason: from kotlin metadata */
    private Context mContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private URLImageView mImgvTemplateIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mHightlightImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mImgDownAndNewIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView topRightIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AEDownLoadingView mAEProgressView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCurrentState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.s2g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.thumb)");
        this.mImgvTemplateIcon = (URLImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.s0n);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.select_highlight)");
        this.mHightlightImage = findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f163747rs4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.download_view)");
        this.mImgDownAndNewIcon = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.s2y);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.topright_view)");
        this.topRightIcon = (ImageView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.rys);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.progress_view)");
        this.mAEProgressView = (AEDownLoadingView) findViewById5;
    }

    private final void c(AEMaterialMetaData info) {
        Resources resources;
        if (TextUtils.isEmpty(info.iconurl)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        int f16 = BaseAIOUtils.f(64.0f, context.getResources());
        Context context2 = this.mContext;
        Drawable drawable = (context2 == null || (resources = context2.getResources()) == null) ? null : resources.getDrawable(R.drawable.itm);
        obtain.mRequestWidth = f16;
        obtain.mRequestHeight = f16;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mRetryCount = 3;
        URLDrawable drawable2 = URLDrawable.getDrawable(info.iconurl, obtain);
        if (drawable2.getStatus() == 2) {
            drawable2.restartDownload();
        }
        this.mImgvTemplateIcon.setImageDrawable(drawable2);
    }

    private final void e(AEMaterialMetaData data) {
        this.mHightlightImage.setVisibility(8);
        this.mImgDownAndNewIcon.setVisibility(8);
        this.topRightIcon.setVisibility(8);
    }

    private final void f(AEMaterialMetaData data) {
        this.mHightlightImage.setVisibility(0);
        h(data);
        j(data);
    }

    private final void g(AEMaterialMetaData data) {
        this.mHightlightImage.setVisibility(8);
        h(data);
        j(data);
    }

    private final void h(AEMaterialMetaData data) {
        if (data.isWsBanner()) {
            this.mImgDownAndNewIcon.setVisibility(8);
            this.mAEProgressView.setVisibility(8);
            return;
        }
        if (data.usable) {
            this.mImgDownAndNewIcon.setVisibility(8);
            this.mAEProgressView.setVisibility(8);
        } else if (data.downloading) {
            this.mImgDownAndNewIcon.setVisibility(8);
            this.mAEProgressView.setVisibility(0);
            this.mAEProgressView.setProgress(data.downloadProgress);
        } else {
            this.mImgDownAndNewIcon.setVisibility(0);
            this.mImgDownAndNewIcon.setImageResource(R.drawable.iwb);
            this.mAEProgressView.setVisibility(8);
        }
    }

    private final void i(AEMaterialMetaData data) {
        int i3 = this.mCurrentState;
        if (i3 == 0) {
            e(data);
            return;
        }
        if (i3 == 1) {
            g(data);
            c(data);
        } else if (i3 != 2) {
            e(data);
        } else {
            f(data);
            c(data);
        }
    }

    private final void j(AEMaterialMetaData data) {
        if (data.needDisplayType()) {
            this.topRightIcon.setVisibility(0);
            this.topRightIcon.setImageResource(data.getDisplayIconByType());
        } else {
            this.topRightIcon.setVisibility(8);
        }
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        int f16 = BaseAIOUtils.f(6.0f, context.getResources());
        int f17 = BaseAIOUtils.f(1.5f, context.getResources());
        int f18 = BaseAIOUtils.f(13.7f, context.getResources());
        this.mAEProgressView.setBgCorner(f18 / 2);
        this.mAEProgressView.setMinimumHeight(f18);
        this.mAEProgressView.setMinimumWidth(f18);
        this.mAEProgressView.setProgressSizeAndMode(f16, f17, false);
        this.mAEProgressView.setBgColor(1996488704);
        this.mAEProgressView.setProgressColor(-1);
        this.mAEProgressView.b(false);
    }

    public final void d(int state, AEMaterialMetaData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mCurrentState = state;
        i(data);
    }
}
