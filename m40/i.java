package m40;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchCommentAsyncTextView;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.cm;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$ExpressionInfo;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00103R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010&R\u0018\u0010K\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010JR\u0018\u0010Q\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010JR\u0018\u0010S\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010V\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006["}, d2 = {"Lm40/i;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "", "t1", VasPerfReportUtils.WHILE_UPDATE_ITEM, "B1", "C1", "", ICustomDataEditor.STRING_PARAM_1, "z1", "Landroid/text/SpannableStringBuilder;", "content", "E1", "Landroid/graphics/drawable/Drawable;", "o1", "m1", ICustomDataEditor.NUMBER_PARAM_1, "", "busiId", "p1", "r1", "w1", "q1", "y1", "Lcom/tencent/biz/qqcircle/beans/QFSCommentInfo;", "l1", "", "k1", "feed", "position", "x1", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "w0", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "commentContainer", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "J", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "K", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "posterNickView", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "labelIcon", "Lcom/tencent/biz/qqcircle/immersive/views/search/widget/QFSSearchCommentAsyncTextView;", "M", "Lcom/tencent/biz/qqcircle/immersive/views/search/widget/QFSSearchCommentAsyncTextView;", "postContentView", "Lcom/tencent/biz/qqcircle/widgets/QFSCommentPraiseLayout;", "N", "Lcom/tencent/biz/qqcircle/widgets/QFSCommentPraiseLayout;", "praiseLayout", "P", "specialCommentIcon", "Lfeedcloud/FeedCloudMeta$StComment;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfeedcloud/FeedCloudMeta$StComment;", "comment", "Lfeedcloud/FeedCloudMeta$StUser;", BdhLogUtil.LogTag.Tag_Req, "Lfeedcloud/FeedCloudMeta$StUser;", "postUser", ExifInterface.LATITUDE_SOUTH, com.tencent.luggage.wxa.c8.c.G, "T", "Landroid/graphics/drawable/Drawable;", "hostMarkDrawable", "U", "commentTopMarkDrawable", "V", "commentHotMarkDrawable", "W", "hostPraiseMarkDrawable", "X", "specialDrawable", "Y", "Ljava/lang/String;", "contentType", "<init>", "()V", "Z", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private static final int f416122a0 = ViewUtils.dpToPx(30.0f);

    /* renamed from: b0, reason: collision with root package name */
    private static final int f416123b0 = ViewUtils.dpToPx(32.0f);

    /* renamed from: c0, reason: collision with root package name */
    private static final int f416124c0 = ViewUtils.dpToPx(52.0f);

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private LinearLayout commentContainer;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private QCircleAvatarView avatarView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QCircleAsyncTextView posterNickView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView labelIcon;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private QFSSearchCommentAsyncTextView postContentView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private QFSCommentPraiseLayout praiseLayout;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView specialCommentIcon;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StComment comment;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StUser postUser;

    /* renamed from: S, reason: from kotlin metadata */
    private int pos;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Drawable hostMarkDrawable;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Drawable commentTopMarkDrawable;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private Drawable commentHotMarkDrawable;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Drawable hostPraiseMarkDrawable;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Drawable specialDrawable;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private String contentType = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B1() {
        boolean z16;
        String str;
        String str2;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.postUser;
        if (feedCloudMeta$StUser != null && !feedCloudMeta$StUser.has()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Size a16 = com.tencent.biz.qqcircle.immersive.utils.n.a(m0(), R.dimen.d4z);
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setUser(this.postUser, a16);
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.postUser;
        FeedCloudMeta$StUser feedCloudMeta$StUser3 = null;
        if (feedCloudMeta$StUser2 != null && (pBStringField2 = feedCloudMeta$StUser2.nick) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        FeedCloudMeta$StUser feedCloudMeta$StUser4 = this.postUser;
        if (feedCloudMeta$StUser4 != null && (pBStringField = feedCloudMeta$StUser4.f398463id) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        if (!TextUtils.equals(str2, ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get())) {
            QCircleAsyncTextView qCircleAsyncTextView = this.posterNickView;
            if (qCircleAsyncTextView != null) {
                qCircleAsyncTextView.showEllipseEndImageSpan(false);
            }
            QCircleAsyncTextView qCircleAsyncTextView2 = this.posterNickView;
            if (qCircleAsyncTextView2 != null) {
                qCircleAsyncTextView2.setText(spannableStringBuilder);
            }
            Context m06 = m0();
            ImageView imageView = this.labelIcon;
            FeedCloudMeta$StUser feedCloudMeta$StUser5 = this.postUser;
            if (feedCloudMeta$StUser5 != null) {
                feedCloudMeta$StUser3 = feedCloudMeta$StUser5.get();
            }
            cm.d(m06, imageView, feedCloudMeta$StUser3);
            return;
        }
        if (this.hostMarkDrawable == null) {
            Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.qvideo_skin_comment_tag_author);
            this.hostMarkDrawable = drawable;
            if (drawable != null) {
                drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
            }
        }
        QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.hostMarkDrawable);
        QCircleAsyncTextView qCircleAsyncTextView3 = this.posterNickView;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.showEllipseEndImageSpan(true);
        }
        QCircleAsyncTextView qCircleAsyncTextView4 = this.posterNickView;
        if (qCircleAsyncTextView4 != null) {
            qCircleAsyncTextView4.setText(spannableStringBuilder);
        }
        ImageView imageView2 = this.labelIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C1() {
        QFSCommentPraiseLayout qFSCommentPraiseLayout = this.praiseLayout;
        if (qFSCommentPraiseLayout != null) {
            qFSCommentPraiseLayout.setData(1, (FeedCloudMeta$StFeed) this.f85017h, this.comment, null, true);
        }
        QFSCommentPraiseLayout qFSCommentPraiseLayout2 = this.praiseLayout;
        if (qFSCommentPraiseLayout2 != null) {
            qFSCommentPraiseLayout2.setOnClickHookListener(new QFSCommentPraiseLayout.i() { // from class: m40.e
                @Override // com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout.i
                public final void onClick(int i3) {
                    i.D1(i.this, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(i this$0, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        if (i3 == 14) {
            str = "like";
        } else {
            str = "cancel";
        }
        hashMap.put("xsj_action_type", str);
        this$0.i0(this$0.commentContainer, QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, hashMap);
    }

    private final void E1(SpannableStringBuilder content) {
        boolean z16;
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.comment;
        boolean z17 = true;
        if (feedCloudMeta$StComment != null && (pBUInt32Field2 = feedCloudMeta$StComment.typeFlag) != null && pBUInt32Field2.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        ViewGroup.LayoutParams layoutParams = null;
        if (z16) {
            if (this.commentTopMarkDrawable == null) {
                this.commentTopMarkDrawable = o1();
            }
            this.specialDrawable = o1();
            ImageView imageView = this.specialCommentIcon;
            if (imageView != null) {
                layoutParams = imageView.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.width = f416122a0;
            }
            QCircleAsyncTextView.e(content, content.length(), this.commentTopMarkDrawable);
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment2 = this.comment;
        Intrinsics.checkNotNull(feedCloudMeta$StComment2);
        PBUInt32Field pBUInt32Field3 = feedCloudMeta$StComment2.typeFlag2;
        Intrinsics.checkNotNull(pBUInt32Field3);
        if (QFSCommentHelper.V(pBUInt32Field3.get(), 4)) {
            if (this.commentHotMarkDrawable == null) {
                this.commentHotMarkDrawable = m1();
            }
            this.specialDrawable = m1();
            ImageView imageView2 = this.specialCommentIcon;
            if (imageView2 != null) {
                layoutParams = imageView2.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.width = f416123b0;
            }
            QCircleAsyncTextView.e(content, content.length(), this.commentHotMarkDrawable);
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment3 = this.comment;
        if (feedCloudMeta$StComment3 == null || (feedCloudMeta$StLike = feedCloudMeta$StComment3.likeInfo) == null || (pBUInt32Field = feedCloudMeta$StLike.ownerStatus) == null || pBUInt32Field.get() != 1) {
            z17 = false;
        }
        if (z17) {
            if (this.hostPraiseMarkDrawable == null) {
                this.hostPraiseMarkDrawable = n1();
            }
            this.specialDrawable = n1();
            ImageView imageView3 = this.specialCommentIcon;
            if (imageView3 != null) {
                layoutParams = imageView3.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.width = f416124c0;
            }
            QCircleAsyncTextView.e(content, content.length(), this.hostPraiseMarkDrawable);
            return;
        }
        this.specialDrawable = null;
    }

    private final int k1() {
        String str = this.contentType;
        if (Intrinsics.areEqual(str, "article")) {
            return 15;
        }
        if (Intrinsics.areEqual(str, "feed")) {
            return 16;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final QFSCommentInfo l1() {
        String str;
        PBStringField pBStringField;
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = new e30.b((FeedCloudMeta$StFeed) this.f85017h);
        qFSCommentInfo.mFeed = (FeedCloudMeta$StFeed) this.f85017h;
        qFSCommentInfo.mRelocationScrollType = 104;
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mExtraTypeInfo = r();
        qFSCommentInfo.mCmtPanelSource = k1();
        qFSCommentInfo.mIsShowMask = true;
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.comment;
        if (feedCloudMeta$StComment == null || (pBStringField = feedCloudMeta$StComment.f398447id) == null || (str = pBStringField.get()) == null) {
            str = "";
        }
        qCircleActionBean.mItemTopAnimationCommentId = str;
        actionBean.mCommentInitBeanActionBean = qCircleActionBean;
        qFSCommentInfo.mActionBean = actionBean;
        return qFSCommentInfo;
    }

    private final Drawable m1() {
        Drawable drawable = ResourcesCompat.getDrawable(m0().getResources(), R.drawable.f162035nq0, null);
        if (drawable != null) {
            drawable.setBounds(ImmersiveUtils.dpToPx(2.5f), ImmersiveUtils.dpToPx(0.0f), ImmersiveUtils.dpToPx(33.75f), ImmersiveUtils.dpToPx(18.0f));
        }
        return drawable;
    }

    private final Drawable n1() {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.qvideo_skin_comment_tag_authorlike);
        drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(55.5f), ImmersiveUtils.dpToPx(16.0f));
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    private final Drawable o1() {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.qvideo_skin_comment_tag_top);
        drawable.setBounds(ImmersiveUtils.dpToPx(4.0f), 0, ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(16.0f));
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    private final void p1(String busiId) {
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.comment;
        if (feedCloudMeta$StComment != null && TextUtils.equals(busiId, feedCloudMeta$StComment.goodsInfo.goodsID.get()) && !TextUtils.isEmpty(feedCloudMeta$StComment.goodsInfo.goodsURL.get())) {
            com.tencent.biz.qqcircle.helpers.l.e().i(feedCloudMeta$StComment.goodsInfo.goodsURL.get());
        }
    }

    private final void q1() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.postUser;
        boolean z16 = false;
        if (feedCloudMeta$StUser != null && !feedCloudMeta$StUser.has()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.postUser;
        Intrinsics.checkNotNull(feedCloudMeta$StUser2);
        int i3 = feedCloudMeta$StUser2.label.get();
        if (i3 != 1) {
            if (i3 == 3) {
                cm.i(m0());
                return;
            }
            return;
        }
        cm.h(m0());
    }

    private final void r1() {
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.comment;
        if (feedCloudMeta$StComment != null) {
            com.tencent.biz.qqcircle.helpers.l.e().i(feedCloudMeta$StComment.goodsInfo.goodsURL.get());
        }
    }

    private final boolean s1() {
        FeedCloudMeta$ExpressionInfo feedCloudMeta$ExpressionInfo;
        boolean z16;
        boolean z17;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        PBStringField pBStringField;
        String str;
        FeedCloudMeta$StComment feedCloudMeta$StComment2 = this.comment;
        String str2 = null;
        if (feedCloudMeta$StComment2 != null) {
            feedCloudMeta$ExpressionInfo = feedCloudMeta$StComment2.expressionInfo;
        } else {
            feedCloudMeta$ExpressionInfo = null;
        }
        if (feedCloudMeta$ExpressionInfo != null && feedCloudMeta$ExpressionInfo.has()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            PBStringField pBStringField2 = feedCloudMeta$ExpressionInfo.expressionURL;
            if (pBStringField2 != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                z17 = true;
                feedCloudMeta$StComment = this.comment;
                if (feedCloudMeta$StComment != null && (feedCloudMeta$StImage = feedCloudMeta$StComment.commentPic) != null && (pBStringField = feedCloudMeta$StImage.picUrl) != null) {
                    str2 = pBStringField.get();
                }
                boolean z18 = !TextUtils.isEmpty(str2);
                if (z17 && !z18) {
                    return false;
                }
                return true;
            }
        }
        z17 = false;
        feedCloudMeta$StComment = this.comment;
        if (feedCloudMeta$StComment != null) {
            str2 = pBStringField.get();
        }
        boolean z182 = !TextUtils.isEmpty(str2);
        if (z17) {
        }
        return true;
    }

    private final void t1() {
        if (this.commentContainer != null) {
            return;
        }
        this.commentContainer = (LinearLayout) this.C.findViewById(R.id.b3r);
        this.avatarView = (QCircleAvatarView) this.C.findViewById(R.id.a2o);
        this.posterNickView = (QCircleAsyncTextView) this.C.findViewById(R.id.fxo);
        this.labelIcon = (ImageView) this.C.findViewById(R.id.yce);
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView = (QFSSearchCommentAsyncTextView) this.C.findViewById(R.id.fxm);
        this.postContentView = qFSSearchCommentAsyncTextView;
        if (qFSSearchCommentAsyncTextView != null) {
            qFSSearchCommentAsyncTextView.setSpecialClickAreaColor(R.color.qui_common_text_link_selector);
        }
        this.praiseLayout = (QFSCommentPraiseLayout) this.C.findViewById(R.id.f26700e9);
        this.specialCommentIcon = (ImageView) this.C.findViewById(R.id.f87184to);
        LinearLayout linearLayout = this.commentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QFSCommentPraiseLayout qFSCommentPraiseLayout = this.praiseLayout;
        if (qFSCommentPraiseLayout != null) {
            qFSCommentPraiseLayout.I();
        }
        LinearLayout linearLayout2 = this.commentContainer;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this);
        }
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setOnClickListener(this);
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.posterNickView;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setOnClickListener(this);
        }
        ImageView imageView = this.labelIcon;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView2 = this.postContentView;
        if (qFSSearchCommentAsyncTextView2 != null) {
            qFSSearchCommentAsyncTextView2.setOnClickListener(this);
        }
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView3 = this.postContentView;
        if (qFSSearchCommentAsyncTextView3 != null) {
            qFSSearchCommentAsyncTextView3.seOnClickableImageSpanListener(new RFWAsyncRichTextView.OnClickableImageSpanListener() { // from class: m40.g
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickableImageSpanListener
                public final void onClick(int i3, String str) {
                    i.u1(i.this, i3, str);
                }
            });
        }
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView4 = this.postContentView;
        if (qFSSearchCommentAsyncTextView4 != null) {
            qFSSearchCommentAsyncTextView4.setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: m40.h
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
                public final void onClick(String str) {
                    i.v1(i.this, str);
                }
            });
        }
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView5 = this.postContentView;
        if (qFSSearchCommentAsyncTextView5 != null) {
            qFSSearchCommentAsyncTextView5.showEllipseEndImageSpan(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(i this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 == 59) {
                this$0.r1();
                return;
            }
            return;
        }
        this$0.p1(str);
    }

    private final void updateView() {
        t1();
        LinearLayout linearLayout = this.commentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        B1();
        C1();
        z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(i this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(str);
        qCircleInitBean.setFromReportBean(this$0.getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(this$0.m0(), qCircleInitBean);
    }

    private final void w1() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.postUser;
        boolean z16 = false;
        if (feedCloudMeta$StUser != null && !feedCloudMeta$StUser.has()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.postUser);
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
    }

    private final void y1() {
        t40.a s06 = s0();
        if (s06 != null) {
            s06.onHandlerMessage("event_open_comment", l1());
        }
    }

    private final void z1() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.comment;
        if (feedCloudMeta$StComment != null && (pBStringField = feedCloudMeta$StComment.content) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (s1()) {
            spannableStringBuilder.append(" ").append((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f196554hm));
            int length = str.length();
            int i3 = length + 5;
            QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView = this.postContentView;
            if (qFSSearchCommentAsyncTextView != null) {
                qFSSearchCommentAsyncTextView.j(length, i3);
            }
            QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView2 = this.postContentView;
            if (qFSSearchCommentAsyncTextView2 != null) {
                qFSSearchCommentAsyncTextView2.d(spannableStringBuilder, length, i3, new QCircleAsyncTextView.b() { // from class: m40.f
                    @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                    public final void onClick() {
                        i.A1(i.this);
                    }
                }, R.color.cay, false);
            }
        }
        E1(spannableStringBuilder);
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView3 = this.postContentView;
        if (qFSSearchCommentAsyncTextView3 != null) {
            qFSSearchCommentAsyncTextView3.setText(spannableStringBuilder);
        }
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView4 = this.postContentView;
            if (qFSSearchCommentAsyncTextView4 != null) {
                qFSSearchCommentAsyncTextView4.setVisibility(8);
            }
            if (this.specialDrawable != null) {
                ImageView imageView = this.specialCommentIcon;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = this.specialCommentIcon;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(this.specialDrawable);
                    return;
                }
                return;
            }
            ImageView imageView3 = this.specialCommentIcon;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
                return;
            }
            return;
        }
        QFSSearchCommentAsyncTextView qFSSearchCommentAsyncTextView5 = this.postContentView;
        if (qFSSearchCommentAsyncTextView5 != null) {
            qFSSearchCommentAsyncTextView5.setVisibility(0);
        }
        ImageView imageView4 = this.specialCommentIcon;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        boolean z16 = true;
        if (id5 != R.id.a2o && id5 != R.id.fxo) {
            z16 = false;
        }
        if (z16) {
            w1();
        } else if (id5 == R.id.yce) {
            q1();
        } else if (id5 == R.id.fxm) {
            y1();
            i0(this.commentContainer, "dt_clck", null);
        } else if (id5 == R.id.b3r) {
            y1();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedOutCommentPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull FeedCloudMeta$StFeed feed, int position) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        Intrinsics.checkNotNullParameter(feed, "feed");
        super.L0(feed, position);
        this.pos = position;
        if (!feed.vecComment.get().isEmpty() && feed.vecComment.get(0).f398447id.has()) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = feed.vecComment.get(0);
            this.comment = feedCloudMeta$StComment;
            String str = null;
            if (feedCloudMeta$StComment != null) {
                feedCloudMeta$StUser = feedCloudMeta$StComment.postUser;
            } else {
                feedCloudMeta$StUser = null;
            }
            this.postUser = feedCloudMeta$StUser;
            updateView();
            FeedCloudMeta$StComment feedCloudMeta$StComment2 = this.comment;
            if (feedCloudMeta$StComment2 != null) {
                HashMap hashMap = new HashMap();
                String str2 = feedCloudMeta$StComment2.f398447id.get();
                Intrinsics.checkNotNullExpressionValue(str2, "it.id.get()");
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str2);
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_BURN, Integer.valueOf(QFSCommentHelper.V(feedCloudMeta$StComment2.typeFlag2.get(), 4) ? 1 : 0));
                g0(this.commentContainer, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_DETAIL, hashMap);
            }
            Object b16 = this.E.b("KEY_LINEAR_FEED_CONTENT_TYPE");
            if (b16 instanceof String) {
                str = (String) b16;
            }
            if (str != null) {
                this.contentType = str;
                return;
            }
            return;
        }
        LinearLayout linearLayout = this.commentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QLog.w("QFSLinearFeedOutCommentPresenter", 1, "[onBindData] data should not be null.");
    }
}
