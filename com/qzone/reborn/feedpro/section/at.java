package com.qzone.reborn.feedpro.section;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedLikeManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLike;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010-R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/feedpro/section/at;", "Lne/a;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/Observer;", "Lzd/c;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "Lcom/tencent/hippykotlin/demo/pages/qzone/data/CommonCellLike;", "cellLike", "", "O", "J", "L", "Lre/b;", "H", "I", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "v", NodeProps.ON_CLICK, "t", "N", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "praiseContainer", UserInfo.SEX_FEMALE, "commentContainer", "G", "forwardContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "praiseIcon", "commentIcon", "forwardIcon", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "praiseNumTv", "commentNumTv", "M", "forwardNumTv", "Lde/a;", "Lde/a;", "commentIoc", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedLikeManager;", "P", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedLikeManager;", "feedManager", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class at extends ne.a implements View.OnClickListener, Observer<zd.c> {

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout praiseContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout commentContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout forwardContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView praiseIcon;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView commentIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView forwardIcon;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView praiseNumTv;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView commentNumTv;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView forwardNumTv;

    /* renamed from: N, reason: from kotlin metadata */
    private de.a commentIoc;

    /* renamed from: P, reason: from kotlin metadata */
    private QzoneFeedLikeManager feedManager = new QzoneFeedLikeManager();

    private final re.b H() {
        return (re.b) p(re.b.class);
    }

    private final void I() {
        if (this.commentIoc == null) {
            this.commentIoc = (de.a) g(de.a.class);
        }
        de.a aVar = this.commentIoc;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            aVar.y6(getMFeedData(), getMPosition(), 4, 0);
            de.a aVar2 = this.commentIoc;
            Intrinsics.checkNotNull(aVar2);
            aVar2.T8(getMFeedData(), null, getMPosition());
        }
    }

    private final void J(CommonFeed feedData) {
        LinearLayout linearLayout = this.commentContainer;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.as
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    at.K(at.this, view);
                }
            });
        }
        TextView textView = this.commentNumTv;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(at this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I();
        fo.c.b("dt_clck", this$0.commentContainer, "em_qz_feed_comment", null);
    }

    private final void L(final CommonFeed feedData) {
        LinearLayout linearLayout = this.forwardContainer;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.ar
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    at.M(at.this, feedData, view);
                }
            });
        }
        TextView textView = this.forwardNumTv;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(at this$0, CommonFeed commonFeed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        re.b H = this$0.H();
        if (H != null) {
            H.W1(commonFeed);
        }
        re.b H2 = this$0.H();
        MutableLiveData<Boolean> O1 = H2 != null ? H2.O1() : null;
        if (O1 != null) {
            O1.setValue(Boolean.TRUE);
        }
        fo.c.b("dt_clck", this$0.forwardContainer, "em_qz_feed_share", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(CommonCellLike commonCellLike, at this$0, CommonFeed commonFeed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (commonCellLike != null ? commonCellLike.liked : false) {
            QzoneFeedLikeManager.unlikeFeed$default(this$0.feedManager, commonFeed, null, 2, null);
        } else {
            QzoneFeedLikeManager.likeFeed$default(this$0.feedManager, commonFeed, null, 2, null);
        }
        fo.c.b("dt_clck", this$0.praiseContainer, "em_qz_feed_like", null);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onChanged(zd.c t16) {
        O(getMFeedData(), t16 != null ? t16.getCellLike() : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProOperateSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f20869j) {
            I();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // ne.a
    protected int q() {
        return R.id.no7;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (CommonFeedExtKt.isFakeFeed(feedData)) {
            ImageView imageView = this.praiseIcon;
            if (imageView != null) {
                imageView.setAlpha(0.3f);
            }
            ImageView imageView2 = this.commentIcon;
            if (imageView2 != null) {
                imageView2.setAlpha(0.3f);
            }
            ImageView imageView3 = this.forwardIcon;
            if (imageView3 != null) {
                imageView3.setAlpha(0.3f);
            }
            LinearLayout linearLayout = this.praiseContainer;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
            }
            ImageView imageView4 = this.praiseIcon;
            if (imageView4 != null) {
                imageView4.setEnabled(false);
            }
            ImageView imageView5 = this.commentIcon;
            if (imageView5 != null) {
                imageView5.setEnabled(false);
            }
            ImageView imageView6 = this.forwardIcon;
            if (imageView6 != null) {
                imageView6.setEnabled(false);
            }
            xd.c.D(this.praiseIcon, "qui_like_qzone_new", 0);
            return;
        }
        ImageView imageView7 = this.praiseIcon;
        if (imageView7 != null) {
            imageView7.setAlpha(1.0f);
        }
        ImageView imageView8 = this.commentIcon;
        if (imageView8 != null) {
            imageView8.setAlpha(1.0f);
        }
        ImageView imageView9 = this.forwardIcon;
        if (imageView9 != null) {
            imageView9.setAlpha(1.0f);
        }
        LinearLayout linearLayout2 = this.praiseContainer;
        if (linearLayout2 != null) {
            linearLayout2.setEnabled(true);
        }
        ImageView imageView10 = this.praiseIcon;
        if (imageView10 != null) {
            imageView10.setEnabled(true);
        }
        ImageView imageView11 = this.commentIcon;
        if (imageView11 != null) {
            imageView11.setEnabled(true);
        }
        ImageView imageView12 = this.forwardIcon;
        if (imageView12 != null) {
            imageView12.setEnabled(true);
        }
        ze.a.a().observerGlobalState(new zd.c(f(), CommonFeedExtKt.getFeedUniqueKey(feedData), feedData != null ? feedData.getCellLike() : null), this);
        O(feedData, feedData != null ? feedData.getCellLike() : null);
        J(feedData);
        L(feedData);
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.praiseContainer = (LinearLayout) containerView.findViewById(R.id.b0x);
        this.commentContainer = (LinearLayout) containerView.findViewById(R.id.f20859i);
        this.forwardContainer = (LinearLayout) containerView.findViewById(R.id.f20949r);
        this.praiseIcon = (ImageView) containerView.findViewById(R.id.bor);
        this.commentIcon = (ImageView) containerView.findViewById(R.id.f20869j);
        this.forwardIcon = (ImageView) containerView.findViewById(R.id.f20959s);
        this.praiseNumTv = (TextView) containerView.findViewById(R.id.boy);
        this.commentNumTv = (TextView) containerView.findViewById(R.id.f20879k);
        this.forwardNumTv = (TextView) containerView.findViewById(R.id.f20989v);
        ImageView imageView = this.commentIcon;
        if (imageView != null) {
            com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView, 0.0f, 1, null);
        }
        ImageView imageView2 = this.forwardIcon;
        if (imageView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView2, 0.0f, 1, null);
        }
    }

    private final void O(final CommonFeed feedData, final CommonCellLike cellLike) {
        QLog.d("QzoneFeedProOperateSection", 1, "updatePraiseArea, curStatus: " + (cellLike != null ? Boolean.valueOf(cellLike.liked) : null) + ", feed: " + (feedData != null ? feedData.hashCode() : 0));
        LinearLayout linearLayout = this.praiseContainer;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.aq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    at.P(CommonCellLike.this, this, feedData, view);
                }
            });
        }
        if (cellLike != null && cellLike.liked) {
            xd.c.D(this.praiseIcon, "qui_like_filled_qzone_new", R.color.qui_common_brand_standard);
        } else {
            xd.c.D(this.praiseIcon, "qui_like_qzone_new", 0);
        }
        ImageView imageView = this.praiseIcon;
        if (imageView != null) {
            com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView, 0.0f, 1, null);
        }
        TextView textView = this.praiseNumTv;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }
}
