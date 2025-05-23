package com.qzone.reborn.albumx.qzone.widgetview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxMediaListInitBean;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoSearchDebugView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "Landroid/view/View$OnClickListener;", "", "getLayoutId", "objData", c.G, "", "bindData", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/widget/EditText;", "e", "Landroid/widget/EditText;", "mSearchStartTimeView", "f", "mSearchEndTimeView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", h.F, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mSearchBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoSearchDebugView extends QZoneBaseWidgetView<Object> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final EditText mSearchStartTimeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final EditText mSearchEndTimeView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final QUIButton mSearchBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLocalPhotoSearchDebugView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n6w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026ommend_search_edit_start)");
        EditText editText = (EditText) findViewById;
        this.mSearchStartTimeView = editText;
        View findViewById2 = findViewById(R.id.n6v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_\u2026ecommend_search_edit_end)");
        EditText editText2 = (EditText) findViewById2;
        this.mSearchEndTimeView = editText2;
        View findViewById3 = findViewById(R.id.n6u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_\u2026cal_recommend_search_btn)");
        QUIButton qUIButton = (QUIButton) findViewById3;
        this.mSearchBtn = qUIButton;
        qUIButton.setOnClickListener(this);
        String dateTime = RFWRecommendDateUtils.getDateTime(System.currentTimeMillis() - 2592000000L, DateUtil.DATE_FORMAT_8);
        String dateTime2 = RFWRecommendDateUtils.getDateTime(System.currentTimeMillis(), DateUtil.DATE_FORMAT_8);
        editText.setText(dateTime);
        editText2.setText(dateTime2);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129155a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.n6u) {
            if (this.mSearchStartTimeView.getText().length() != 8) {
                ToastUtil.s("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u683c\u5f0f", 1);
            } else if (this.mSearchEndTimeView.getText().length() != 8) {
                ToastUtil.s("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u683c\u5f0f", 1);
            } else {
                long dayTimeStamp = RFWRecommendDateUtils.getDayTimeStamp(this.mSearchStartTimeView.getText().toString());
                long dayTimeStamp2 = RFWRecommendDateUtils.getDayTimeStamp(this.mSearchEndTimeView.getText().toString());
                if (dayTimeStamp > dayTimeStamp2) {
                    ToastUtil.s("\u8d77\u59cb\u65e5\u671f\u4e0d\u80fd\u665a\u4e8e\u7ed3\u675f\u65e5\u671f", 1);
                } else {
                    QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = new QZoneAlbumxMediaListInitBean();
                    qZoneAlbumxMediaListInitBean.setSubClassifyId(String.valueOf(dayTimeStamp));
                    qZoneAlbumxMediaListInitBean.setSelectArg(String.valueOf(dayTimeStamp2));
                    qZoneAlbumxMediaListInitBean.setMediaCount(500);
                    String a16 = l.a(R.string.jfo);
                    Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026commend_debug_title_text)");
                    qZoneAlbumxMediaListInitBean.setMediaDisplayName(a16);
                    QLog.d("QZoneAlbumxLocalPhotoSearchDebugView", 1, "[jumpToMediaListPage] " + qZoneAlbumxMediaListInitBean);
                    Context context = getContext();
                    if (context != null) {
                        i.y().d(context, qZoneAlbumxMediaListInitBean);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLocalPhotoSearchDebugView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n6w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026ommend_search_edit_start)");
        EditText editText = (EditText) findViewById;
        this.mSearchStartTimeView = editText;
        View findViewById2 = findViewById(R.id.n6v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_\u2026ecommend_search_edit_end)");
        EditText editText2 = (EditText) findViewById2;
        this.mSearchEndTimeView = editText2;
        View findViewById3 = findViewById(R.id.n6u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_\u2026cal_recommend_search_btn)");
        QUIButton qUIButton = (QUIButton) findViewById3;
        this.mSearchBtn = qUIButton;
        qUIButton.setOnClickListener(this);
        String dateTime = RFWRecommendDateUtils.getDateTime(System.currentTimeMillis() - 2592000000L, DateUtil.DATE_FORMAT_8);
        String dateTime2 = RFWRecommendDateUtils.getDateTime(System.currentTimeMillis(), DateUtil.DATE_FORMAT_8);
        editText.setText(dateTime);
        editText2.setText(dateTime2);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
    }
}
