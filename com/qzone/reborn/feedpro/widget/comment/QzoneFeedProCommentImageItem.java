package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerRouteBean;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import je.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000234B\u0011\u0012\b\b\u0001\u0010/\u001a\u00020.\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\u0010\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\"\u0010\u001b\u001a\u00020\u00032\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0019J\u0010\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001f\u001a\u00020\u0003H\u0014J\b\u0010 \u001a\u00020\u0003H\u0014R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R*\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "", "w0", "r0", "Landroid/view/View;", "v", "s0", "p0", "picInfo", "u0", "z0", "A0", "", "getLayoutId", "radius", "setRoundRect", "objData", c.G, "q0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "commentData", "setCommentData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pictureItems", "setPicList", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "longClickListener", "setOnImageLongClickListener", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", "e", "Lcom/tencent/biz/richframework/widget/RFWSquareImageView;", "mImageView", "f", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "mCommentData", h.F, "Ljava/util/ArrayList;", "mPictureItems", "i", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "mLongClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProCommentImageItem extends QZoneBaseWidgetView<CommonMedia> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWSquareImageView mImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonComment mCommentData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<CommonMedia> mPictureItems;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b mLongClickListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "", "Landroid/view/View;", "v", "", c.G, "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(View v3, int pos);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProCommentImageItem(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        w0();
    }

    private final void A0() {
        RFWSquareImageView rFWSquareImageView = this.mImageView;
        if (rFWSquareImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView = null;
        }
        Object drawable = rFWSquareImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
    }

    private final void p0() {
        int dpToPx;
        RFWSquareImageView rFWSquareImageView = this.mImageView;
        RFWSquareImageView rFWSquareImageView2 = null;
        if (rFWSquareImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView = null;
        }
        ViewGroup.LayoutParams layoutParams = rFWSquareImageView.getLayoutParams();
        if (x.f55790a.c(k0().getPageType())) {
            dpToPx = ImmersiveUtils.dpToPx(70.0f);
        } else {
            dpToPx = ImmersiveUtils.dpToPx(64.0f);
        }
        layoutParams.width = dpToPx;
        layoutParams.height = dpToPx;
        RFWSquareImageView rFWSquareImageView3 = this.mImageView;
        if (rFWSquareImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        } else {
            rFWSquareImageView2 = rFWSquareImageView3;
        }
        rFWSquareImageView2.setLayoutParams(layoutParams);
    }

    private final void r0() {
        CommonComment commonComment;
        if (i.c(this) == null || this.mPictureItems == null || (commonComment = this.mCommentData) == null) {
            return;
        }
        Intrinsics.checkNotNull(commonComment);
        if (commonComment.getUser() == null) {
            return;
        }
        QLog.i("QzoneFeedProCommentImageItem", 1, "index is " + this.dataPosInList);
        QzoneFeedProLayerRouteBean qzoneFeedProLayerRouteBean = new QzoneFeedProLayerRouteBean();
        ArrayList<CommonMedia> arrayList = this.mPictureItems;
        Intrinsics.checkNotNull(arrayList);
        qzoneFeedProLayerRouteBean.o(a.p(arrayList));
        ArrayList<CommonMedia> arrayList2 = this.mPictureItems;
        Intrinsics.checkNotNull(arrayList2);
        qzoneFeedProLayerRouteBean.y(a.n(qzoneFeedProLayerRouteBean, arrayList2));
        qzoneFeedProLayerRouteBean.x(String.valueOf(getContext().hashCode()));
        RFWSquareImageView rFWSquareImageView = this.mImageView;
        if (rFWSquareImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView = null;
        }
        qzoneFeedProLayerRouteBean.l(rFWSquareImageView);
        qzoneFeedProLayerRouteBean.m(this.dataPosInList);
        qzoneFeedProLayerRouteBean.n(true);
        ho.i.i().d(getContext(), qzoneFeedProLayerRouteBean);
    }

    private final void s0(View v3) {
        b bVar = this.mLongClickListener;
        if (bVar != null) {
            bVar.a(v3, this.dataPosInList);
        }
    }

    private final void u0(CommonMedia picInfo) {
        CommonPicUrl defaultUrl;
        CommonImage image = picInfo.getImage();
        RFWSquareImageView rFWSquareImageView = null;
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e((image == null || (defaultUrl = image.getDefaultUrl()) == null) ? null : defaultUrl.getUrl());
        RFWSquareImageView rFWSquareImageView2 = this.mImageView;
        if (rFWSquareImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView2 = null;
        }
        e16.setTargetView(rFWSquareImageView2);
        RFWSquareImageView rFWSquareImageView3 = this.mImageView;
        if (rFWSquareImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView3 = null;
        }
        if (rFWSquareImageView3.getLayoutParams() != null) {
            RFWSquareImageView rFWSquareImageView4 = this.mImageView;
            if (rFWSquareImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                rFWSquareImageView4 = null;
            }
            e16.setRequestWidth(rFWSquareImageView4.getLayoutParams().width);
            RFWSquareImageView rFWSquareImageView5 = this.mImageView;
            if (rFWSquareImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                rFWSquareImageView5 = null;
            }
            e16.setRequestHeight(rFWSquareImageView5.getLayoutParams().height);
        }
        e16.setLoadingDrawable(getResources().getDrawable(R.drawable.at8));
        e16.setFailDrawable(getResources().getDrawable(R.drawable.at_));
        String d16 = com.tencent.mobileqq.qzone.picload.c.a().d(e16);
        RFWSquareImageView rFWSquareImageView6 = this.mImageView;
        if (rFWSquareImageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView6 = null;
        }
        if (rFWSquareImageView6.getTag() != null) {
            RFWSquareImageView rFWSquareImageView7 = this.mImageView;
            if (rFWSquareImageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageView");
                rFWSquareImageView7 = null;
            }
            if (Intrinsics.areEqual(rFWSquareImageView7.getTag(), d16)) {
                QLog.d("QzoneFeedProCommentImageItem", 4, "initImageView, same url, just return: " + d16);
                return;
            }
        }
        RFWSquareImageView rFWSquareImageView8 = this.mImageView;
        if (rFWSquareImageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        } else {
            rFWSquareImageView = rFWSquareImageView8;
        }
        rFWSquareImageView.setTag(com.tencent.mobileqq.qzone.picload.c.a().d(e16));
        QLog.d("QzoneFeedProCommentImageItem", 4, "initImageView, url=" + e16.getUrl() + ", width=" + e16.getRequestWidth() + ", height=" + e16.getRequestHeight());
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: se.p
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QzoneFeedProCommentImageItem.v0(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(LoadState loadState, Option option) {
        if (!loadState.isFinishSuccess() || option.getAnimatable() == null) {
            return;
        }
        option.getAnimatable().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(QzoneFeedProCommentImageItem this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y0(QzoneFeedProCommentImageItem this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.s0(it);
        return false;
    }

    private final void z0() {
        RFWSquareImageView rFWSquareImageView = this.mImageView;
        if (rFWSquareImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView = null;
        }
        Object drawable = rFWSquareImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167263a44;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        z0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonMedia objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        p0();
        u0(objData);
    }

    public final void setCommentData(CommonComment commentData) {
        this.mCommentData = commentData;
    }

    public final void setOnImageLongClickListener(b longClickListener) {
        this.mLongClickListener = longClickListener;
    }

    public final void setPicList(ArrayList<CommonMedia> pictureItems) {
        this.mPictureItems = pictureItems;
    }

    public final void setRoundRect(int radius) {
        RFWSquareImageView rFWSquareImageView = this.mImageView;
        if (rFWSquareImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView = null;
        }
        rFWSquareImageView.setRoundRect(radius);
    }

    private final void w0() {
        View findViewById = findViewById(R.id.mrq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_comment_image_view)");
        RFWSquareImageView rFWSquareImageView = (RFWSquareImageView) findViewById;
        this.mImageView = rFWSquareImageView;
        RFWSquareImageView rFWSquareImageView2 = null;
        if (rFWSquareImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            rFWSquareImageView = null;
        }
        rFWSquareImageView.setOnClickListener(new View.OnClickListener() { // from class: se.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProCommentImageItem.x0(QzoneFeedProCommentImageItem.this, view);
            }
        });
        RFWSquareImageView rFWSquareImageView3 = this.mImageView;
        if (rFWSquareImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        } else {
            rFWSquareImageView2 = rFWSquareImageView3;
        }
        rFWSquareImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: se.o
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean y06;
                y06 = QzoneFeedProCommentImageItem.y0(QzoneFeedProCommentImageItem.this, view);
                return y06;
            }
        });
    }
}
