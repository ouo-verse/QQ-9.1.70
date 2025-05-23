package com.qzone.reborn.groupalbum.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.reborn.groupalbum.block.GroupAlbumAlbumListHeaderAdapter;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0014R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/groupalbum/widget/GroupAlbumAlbumListInfoHeadView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$GroupAlbumHeadInfoBean;", "", "n0", "", "getLayoutId", "data", c.G, "m0", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mAlbumNum", "f", "mMediaNum", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumListInfoHeadView extends QZoneBaseWidgetView<GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mMediaNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumAlbumListInfoHeadView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.nhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_album_num)");
        this.mAlbumNum = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.nj_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_media_num)");
        this.mMediaNum = (TextView) findViewById2;
        n0();
    }

    private final void n0() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, ar.e(24.0f)));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cir;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean data, int pos) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mAlbumNum.setText(data.getAlbumNum() + " \u76f8\u518c");
        this.mMediaNum.setText(data.getMediaNum() + " \u56fe\u50cf");
        setVisibility(data.getShow() ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumAlbumListInfoHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.nhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_album_num)");
        this.mAlbumNum = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.nj_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_media_num)");
        this.mMediaNum = (TextView) findViewById2;
        n0();
    }
}
