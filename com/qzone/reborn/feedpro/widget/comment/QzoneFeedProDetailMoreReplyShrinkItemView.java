package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedpro.utils.n;
import com.qzone.reborn.feedpro.viewmodel.i;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailMoreReplyShrinkItemView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0014J\u001a\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\tH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u0014R\u0016\u0010'\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\u0014R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailMoreReplyShrinkItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lwd/c;", "", "s0", "u0", "", "loadingStatus", "v0", "", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "initView", "objData", c.G, "p0", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mMoreReplyShrinkLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mTvMoreReplyShrink", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "mIvMoreReplyIcon", "Landroid/view/View;", "i", "Landroid/view/View;", "mMoreReplyLoading", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIvCloseReplyIcon", BdhLogUtil.LogTag.Tag_Conn, "mExpendMoreRoot", "D", "mCloseMoreRoot", "E", "Z", "mIsLoadingStatus", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProDetailMoreReplyShrinkItemView extends QZoneBaseWidgetView<wd.c> {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout mExpendMoreRoot;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout mCloseMoreRoot;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsLoadingStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mMoreReplyShrinkLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mTvMoreReplyShrink;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvMoreReplyIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mMoreReplyLoading;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvCloseReplyIcon;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailMoreReplyShrinkItemView$a", "Lcom/qzone/reborn/base/n$a;", "", "t", "", "retCode", "", "msg", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements n.a<Boolean> {
        a() {
        }

        public void a(boolean t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QzoneFeedProDetailMoreReplyShrinkItemView.this.v0(false);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QzoneFeedProDetailMoreReplyShrinkItemView.this.v0(false);
            QQToastUtil.showQQToast(0, QzoneFeedProDetailMoreReplyShrinkItemView.this.getContext().getString(R.string.w_h));
        }

        @Override // com.qzone.reborn.base.n.a
        public /* bridge */ /* synthetic */ void onSuccess(Boolean bool, long j3, String str, boolean z16) {
            a(bool.booleanValue(), j3, str, z16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProDetailMoreReplyShrinkItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(QzoneFeedProDetailMoreReplyShrinkItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(QzoneFeedProDetailMoreReplyShrinkItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s0() {
        ConcurrentHashMap<String, n.a> h26;
        n.a aVar;
        wd.c data = getData();
        if (data == null) {
            return;
        }
        CommonComment mComment = data.getMComment();
        RFWLog.d("BaseWidgetView", RFWLog.USR, "handleOnClickCloseReply commentId:" + mComment.getId());
        i iVar = (i) p(i.class);
        if (iVar == null || (h26 = iVar.h2()) == null || (aVar = h26.get(mComment.getId())) == null) {
            return;
        }
        aVar.f();
        iVar.l2().postValue(mComment);
    }

    private final void u0() {
        wd.c data;
        if (this.mIsLoadingStatus || (data = getData()) == null) {
            return;
        }
        CommonComment mComment = data.getMComment();
        RFWLog.d("BaseWidgetView", RFWLog.USR, "handleOnClickMoreReply commentId:" + mComment.getId());
        i iVar = (i) p(i.class);
        v0(true);
        if (iVar != null) {
            iVar.s2(mComment, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(boolean loadingStatus) {
        this.mIsLoadingStatus = loadingStatus;
        ImageView imageView = null;
        if (loadingStatus) {
            View view = this.mMoreReplyLoading;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreReplyLoading");
                view = null;
            }
            view.setVisibility(0);
            ImageView imageView2 = this.mIvMoreReplyIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvMoreReplyIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        View view2 = this.mMoreReplyLoading;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreReplyLoading");
            view2 = null;
        }
        view2.setVisibility(8);
        ImageView imageView3 = this.mIvMoreReplyIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvMoreReplyIcon");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130488w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int viewType) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.initView(context, viewType);
        View findViewById = findViewById(R.id.n6z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_lv_reply_shrink_more)");
        this.mExpendMoreRoot = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.n6y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_lv_reply_shrink_close)");
        this.mCloseMoreRoot = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.mgb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_more_reply_shrink)");
        this.mMoreReplyShrinkLayout = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.njb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_more_reply_shrink)");
        this.mTvMoreReplyShrink = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.ljj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_more_reply_icon)");
        this.mIvMoreReplyIcon = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f162749ll1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_more_reply_loading)");
        this.mMoreReplyLoading = findViewById6;
        View findViewById7 = findViewById(R.id.n6e);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qzone_iv_close_reply_icon)");
        this.mIvCloseReplyIcon = (ImageView) findViewById7;
        ImageView imageView = this.mIvMoreReplyIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvMoreReplyIcon");
            imageView = null;
        }
        rn.h.a(imageView, "qui_chevron_down", R.color.qui_common_text_secondary_light);
        ImageView imageView3 = this.mIvCloseReplyIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCloseReplyIcon");
        } else {
            imageView2 = imageView3;
        }
        rn.h.a(imageView2, "qui_chevron_up", R.color.qui_common_text_secondary_light);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(wd.c objData, int pos) {
        CommonComment mComment;
        CommonComment mComment2;
        Boolean hasMoreReply;
        CommonComment mComment3;
        List<CommonReply> replys;
        CommonComment mComment4;
        LinearLayout linearLayout;
        CommonComment mComment5;
        if (bl.b((objData == null || (mComment5 = objData.getMComment()) == null) ? null : mComment5.getReplys())) {
            LinearLayout linearLayout2 = this.mMoreReplyShrinkLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreReplyShrinkLayout");
                linearLayout = null;
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        this.mIsLoadingStatus = false;
        LinearLayout linearLayout3 = this.mExpendMoreRoot;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpendMoreRoot");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: se.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProDetailMoreReplyShrinkItemView.q0(QzoneFeedProDetailMoreReplyShrinkItemView.this, view);
            }
        });
        LinearLayout linearLayout4 = this.mCloseMoreRoot;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseMoreRoot");
            linearLayout4 = null;
        }
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: se.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProDetailMoreReplyShrinkItemView.r0(QzoneFeedProDetailMoreReplyShrinkItemView.this, view);
            }
        });
        LinearLayout linearLayout5 = this.mMoreReplyShrinkLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreReplyShrinkLayout");
            linearLayout5 = null;
        }
        linearLayout5.setVisibility(0);
        long replyNum = (objData == null || (mComment4 = objData.getMComment()) == null) ? 0L : mComment4.getReplyNum();
        int size = (objData == null || (mComment3 = objData.getMComment()) == null || (replys = mComment3.getReplys()) == null) ? 0 : replys.size();
        int mReplyShowNumber = objData != null ? objData.getMReplyShowNumber() : 0;
        int mPageIndex = objData != null ? objData.getMPageIndex() : 0;
        boolean booleanValue = (objData == null || (mComment2 = objData.getMComment()) == null || (hasMoreReply = mComment2.getHasMoreReply()) == null) ? false : hasMoreReply.booleanValue();
        int d16 = (objData == null || (mComment = objData.getMComment()) == null) ? 0 : com.qzone.reborn.feedpro.utils.n.f54347a.d(mComment);
        if (mPageIndex > 0) {
            if ((mReplyShowNumber >= size) && !booleanValue) {
                LinearLayout linearLayout6 = this.mExpendMoreRoot;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpendMoreRoot");
                    linearLayout6 = null;
                }
                linearLayout6.setVisibility(8);
            } else {
                LinearLayout linearLayout7 = this.mExpendMoreRoot;
                if (linearLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpendMoreRoot");
                    linearLayout7 = null;
                }
                linearLayout7.setVisibility(0);
                TextView textView = this.mTvMoreReplyShrink;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvMoreReplyShrink");
                    textView = null;
                }
                textView.setText(getContext().getResources().getString(R.string.f169530jn2));
            }
        } else {
            long max = Math.max(0L, Math.max(replyNum, size) - mReplyShowNumber);
            if (max > 0) {
                LinearLayout linearLayout8 = this.mExpendMoreRoot;
                if (linearLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpendMoreRoot");
                    linearLayout8 = null;
                }
                linearLayout8.setVisibility(0);
                TextView textView2 = this.mTvMoreReplyShrink;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvMoreReplyShrink");
                    textView2 = null;
                }
                textView2.setText(getContext().getResources().getString(R.string.f169531jn3, Long.valueOf(max)));
            } else {
                LinearLayout linearLayout9 = this.mExpendMoreRoot;
                if (linearLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpendMoreRoot");
                    linearLayout9 = null;
                }
                linearLayout9.setVisibility(8);
            }
        }
        if (mReplyShowNumber > d16) {
            LinearLayout linearLayout10 = this.mCloseMoreRoot;
            if (linearLayout10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCloseMoreRoot");
                linearLayout10 = null;
            }
            linearLayout10.setVisibility(0);
            return;
        }
        LinearLayout linearLayout11 = this.mCloseMoreRoot;
        if (linearLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseMoreRoot");
            linearLayout11 = null;
        }
        linearLayout11.setVisibility(8);
    }
}
