package com.qzone.reborn.intimate.part.feed;

import android.app.Activity;
import android.view.View;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/t;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mDetailTitle", "e", "Landroid/view/View;", "mItemView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mDetailTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mItemView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(t this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("toggle_share_panel", null);
        fo.c.d("em_qz_on_the_feed_entrance", "pg_qz_dynamic_detail_page", view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(t this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mItemView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            view = null;
        }
        fo.c.f("em_qz_on_the_feed_entrance", "pg_qz_dynamic_detail_page", view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateFeedxDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mz9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qzone_feedx_detail_title)");
        QZoneCommonTitle qZoneCommonTitle = (QZoneCommonTitle) findViewById;
        this.mDetailTitle = qZoneCommonTitle;
        QZoneCommonTitle qZoneCommonTitle2 = null;
        if (qZoneCommonTitle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
            qZoneCommonTitle = null;
        }
        qZoneCommonTitle.getMCenterTitle().setText(com.qzone.util.l.a(R.string.mvm));
        QZoneCommonTitle qZoneCommonTitle3 = this.mDetailTitle;
        if (qZoneCommonTitle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
            qZoneCommonTitle3 = null;
        }
        qZoneCommonTitle3.setupTitleHeight(QZoneFeedxViewUtils.b(getActivity()));
        QZoneCommonTitle qZoneCommonTitle4 = this.mDetailTitle;
        if (qZoneCommonTitle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
        } else {
            qZoneCommonTitle2 = qZoneCommonTitle4;
        }
        String a16 = com.qzone.util.l.a(R.string.akv);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.feed.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.A9(t.this, view);
            }
        };
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026il_button_top_right_more)");
        this.mItemView = qZoneCommonTitle2.c(new uh.d(R.drawable.qui_more, null, onClickListener, null, a16, false, 42, null));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        View view = this.mItemView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            view = null;
        }
        view.post(new Runnable() { // from class: com.qzone.reborn.intimate.part.feed.r
            @Override // java.lang.Runnable
            public final void run() {
                t.B9(t.this);
            }
        });
    }
}
