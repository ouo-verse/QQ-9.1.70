package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.detail.DetailUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.reborn.feedpro.utils.r;
import com.qzone.reborn.feedpro.utils.u;
import com.qzone.reborn.feedpro.widget.comment.QZoneFeedProCommentWidget;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem;
import com.qzone.reborn.feedx.widget.QZoneCommentNickView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se.m;
import wd.a;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QZoneFeedProCommentWidget;", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProBaseCommentWidget;", "", "A0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "D0", "z0", "C0", "E0", "", "y0", "getLogTag", "", "getLayoutId", "Lwd/a;", "objData", "i", "x0", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "mCommentRootLayout", "Lcom/qzone/reborn/feedx/widget/QZoneCommentNickView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneCommentNickView;", "mCommentNickView", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "D", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mCommentContent", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "mCommentPictureGridView", "Lse/m;", UserInfo.SEX_FEMALE, "Lse/m;", "mCommentImageAdapter", "G", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "mComment", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedProCommentWidget extends QzoneFeedProBaseCommentWidget {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneCommentNickView mCommentNickView;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneRichTextView mCommentContent;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView mCommentPictureGridView;

    /* renamed from: F, reason: from kotlin metadata */
    private m mCommentImageAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private CommonComment mComment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mCommentRootLayout;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProCommentWidget$b", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "Landroid/view/View;", "v", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QzoneFeedProCommentImageItem.b {
        b() {
        }

        @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem.b
        public void a(View v3, int pos) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProCommentWidget$d", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "cell", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", JsonRuleKey.OPERATOR, "", NodeProps.ON_LONG_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements TextCellLayout.OnCellClickListener {
        d() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell cell, View view) {
            Intrinsics.checkNotNullParameter(cell, "cell");
            Intrinsics.checkNotNullParameter(view, "view");
            QZoneRichTextView qZoneRichTextView = QZoneFeedProCommentWidget.this.mCommentContent;
            QZoneRichTextView qZoneRichTextView2 = null;
            if (qZoneRichTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
                qZoneRichTextView = null;
            }
            qZoneRichTextView.k(cell);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Long uin = cell.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "cell.uin");
            linkedHashMap.put("touin", uin);
            fo.b l3 = new fo.b().l(linkedHashMap);
            QZoneRichTextView qZoneRichTextView3 = QZoneFeedProCommentWidget.this.mCommentContent;
            if (qZoneRichTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            } else {
                qZoneRichTextView2 = qZoneRichTextView3;
            }
            fo.c.b("dt_clck", qZoneRichTextView2, "em_qz_feed_comment_nickname", l3);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater operator) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(operator, "operator");
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedProCommentWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        A0();
    }

    private final void A0() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.mCommentRootLayout = linearLayout;
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ImmersiveUtils.dpToPx(4.0f);
        View view = this.mCommentRootLayout;
        QZoneRichTextView qZoneRichTextView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentRootLayout");
            view = null;
        }
        addView(view, layoutParams);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mCommentNickView = new QZoneCommentNickView(context);
        LinearLayout linearLayout2 = this.mCommentRootLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentRootLayout");
            linearLayout2 = null;
        }
        QZoneCommentNickView qZoneCommentNickView = this.mCommentNickView;
        if (qZoneCommentNickView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentNickView");
            qZoneCommentNickView = null;
        }
        linearLayout2.addView(qZoneCommentNickView, new LinearLayout.LayoutParams(-1, -2));
        QZoneCommentNickView qZoneCommentNickView2 = this.mCommentNickView;
        if (qZoneCommentNickView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentNickView");
            qZoneCommentNickView2 = null;
        }
        View findViewById = qZoneCommentNickView2.findViewById(R.id.mrm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mCommentNickView.findVie\u2026id.qzone_comment_content)");
        QZoneRichTextView qZoneRichTextView2 = (QZoneRichTextView) findViewById;
        this.mCommentContent = qZoneRichTextView2;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setTextSize(ar.e(14.0f));
        QZoneRichTextView qZoneRichTextView3 = this.mCommentContent;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView3 = null;
        }
        qZoneRichTextView3.setPreDecorateListener(new CellTextView.d() { // from class: se.a
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List B0;
                B0 = QZoneFeedProCommentWidget.B0(QZoneFeedProCommentWidget.this, list);
                return B0;
            }
        });
        QZoneRichTextView qZoneRichTextView4 = this.mCommentContent;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView4 = null;
        }
        qZoneRichTextView4.setOnCellClickListener(new d());
        QZoneRichTextView qZoneRichTextView5 = this.mCommentContent;
        if (qZoneRichTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView5 = null;
        }
        qZoneRichTextView5.setLineSpace(ImmersiveUtils.dpToPx(2.0f));
        QZoneRichTextView qZoneRichTextView6 = this.mCommentContent;
        if (qZoneRichTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView6 = null;
        }
        qZoneRichTextView6.setDrawBackground(true);
        QZoneRichTextView qZoneRichTextView7 = this.mCommentContent;
        if (qZoneRichTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView7 = null;
        }
        qZoneRichTextView7.setColorBackground(getResources().getColor(R.color.qui_common_fill_light_secondary_pressed));
        QZoneRichTextView qZoneRichTextView8 = this.mCommentContent;
        if (qZoneRichTextView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView8 = null;
        }
        r rVar = r.f54359a;
        qZoneRichTextView8.setTextColorLink(rVar.b(getContext()));
        QZoneRichTextView qZoneRichTextView9 = this.mCommentContent;
        if (qZoneRichTextView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView9 = null;
        }
        qZoneRichTextView9.setTextColorLinkBackground(rVar.a(getContext()));
        QZoneRichTextView qZoneRichTextView10 = this.mCommentContent;
        if (qZoneRichTextView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView10 = null;
        }
        qZoneRichTextView10.setMaxCommentLine(2);
        QZoneRichTextView qZoneRichTextView11 = this.mCommentContent;
        if (qZoneRichTextView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView11 = null;
        }
        qZoneRichTextView11.setShowMore(true);
        QZoneRichTextView qZoneRichTextView12 = this.mCommentContent;
        if (qZoneRichTextView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView12 = null;
        }
        qZoneRichTextView12.setEllipsisStr(l.a(R.string.jmx));
        QZoneRichTextView qZoneRichTextView13 = this.mCommentContent;
        if (qZoneRichTextView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            qZoneRichTextView13 = null;
        }
        qZoneRichTextView13.setMoreCellColor(rVar.b(getContext()));
        QZoneRichTextView qZoneRichTextView14 = this.mCommentContent;
        if (qZoneRichTextView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
        } else {
            qZoneRichTextView = qZoneRichTextView14;
        }
        r0(qZoneRichTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List B0(QZoneFeedProCommentWidget this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.f(list, r.f54359a.b(this$0.getContext()), false);
    }

    private final void E0(CommonComment comment) {
        String EmoCode2Text;
        String y06 = y0(comment);
        QZoneCommentNickView qZoneCommentNickView = this.mCommentNickView;
        QZoneRichTextView qZoneRichTextView = null;
        if (qZoneCommentNickView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentNickView");
            qZoneCommentNickView = null;
        }
        qZoneCommentNickView.s0(y06);
        if (i.H().S0()) {
            boolean isEmpty = TextUtils.isEmpty(CommonFeedDataUtilKt.msgToString(comment.getContent()));
            QZoneRichTextView qZoneRichTextView2 = this.mCommentContent;
            if (qZoneRichTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentContent");
            } else {
                qZoneRichTextView = qZoneRichTextView2;
            }
            if (isEmpty) {
                EmoCode2Text = "";
            } else {
                EmoCode2Text = DetailUtil.EmoCode2Text(CommonFeedDataUtilKt.msgToString(comment.getContent()));
            }
            qZoneRichTextView.setContentDescription(EmoCode2Text);
        }
    }

    private final String y0(CommonComment comment) {
        String str = u.f54367a.b(comment.getUser(), false, false) + MsgSummary.STR_COLON + CommonFeedDataUtilKt.msgToString(comment.getContent());
        Intrinsics.checkNotNullExpressionValue(str, "content.toString()");
        return str;
    }

    private final void z0() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.mCommentPictureGridView = recyclerView;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView2 = this.mCommentPictureGridView;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setHasFixedSize(true);
        RecyclerView recyclerView3 = this.mCommentPictureGridView;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setNestedScrollingEnabled(false);
        m mVar = new m();
        this.mCommentImageAdapter = mVar;
        Intrinsics.checkNotNull(mVar);
        mVar.j0(new b());
        RecyclerView recyclerView4 = this.mCommentPictureGridView;
        Intrinsics.checkNotNull(recyclerView4);
        recyclerView4.addOnItemTouchListener(new c());
        RecyclerView recyclerView5 = this.mCommentPictureGridView;
        Intrinsics.checkNotNull(recyclerView5);
        recyclerView5.setAdapter(this.mCommentImageAdapter);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProBaseCommentWidget
    public String getLogTag() {
        return "QZoneFeedProCommentWidget";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(a objData, int i3) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        CommonComment comment = objData.getComment();
        this.mComment = comment;
        C0(comment);
        D0(this.mComment);
    }

    private final void C0(CommonComment comment) {
        if (comment != null) {
            E0(comment);
        }
    }

    private final void D0(CommonComment comment) {
        RecyclerView recyclerView;
        LinearLayout linearLayout = null;
        List<CommonMedia> mediaItems = comment != null ? comment.getMediaItems() : null;
        if (bl.b(mediaItems) && (recyclerView = this.mCommentPictureGridView) != null) {
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(8);
            return;
        }
        if (this.mCommentPictureGridView == null) {
            z0();
            LinearLayout linearLayout2 = this.mCommentRootLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentRootLayout");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.addView(this.mCommentPictureGridView);
        }
        RecyclerView recyclerView2 = this.mCommentPictureGridView;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setVisibility(0);
        m mVar = this.mCommentImageAdapter;
        Intrinsics.checkNotNull(mVar);
        mVar.i0(comment);
        m mVar2 = this.mCommentImageAdapter;
        Intrinsics.checkNotNull(mVar2);
        mVar2.setDatas(mediaItems);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QZoneFeedProCommentWidget$c", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "onTouchEvent", "disallowIntercept", "onRequestDisallowInterceptTouchEvent", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements RecyclerView.OnItemTouchListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv5, MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
            if (e16.getAction() != 1 || rv5.findChildViewUnder(e16.getX(), e16.getY()) != null) {
                return false;
            }
            QZoneFeedProCommentWidget.this.p0();
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv5, MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
