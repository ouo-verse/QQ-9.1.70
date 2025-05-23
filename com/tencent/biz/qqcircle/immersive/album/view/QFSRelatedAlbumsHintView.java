package com.tencent.biz.qqcircle.immersive.album.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedAlbum$StVideoAlbumFeedInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/album/view/QFSRelatedAlbumsHintView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lqqcircle/QQCircleFeedAlbum$StVideoAlbumFeedInfo;", "", "hint", "", "l0", "", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "initView", "objData", com.tencent.luggage.wxa.c8.c.G, "k0", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "hintTextView", "<init>", "(Landroid/content/Context;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRelatedAlbumsHintView extends QCircleBaseWidgetView<QQCircleFeedAlbum$StVideoAlbumFeedInfo> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView hintTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSRelatedAlbumsHintView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l0(String hint) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        textView.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary));
        textView.setTextSize(1, 12.0f);
        textView.setText(hint);
        addView(textView);
        int a16 = cx.a(24.0f);
        setPadding(0, a16, 0, a16);
        this.hintTextView = textView;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull QQCircleFeedAlbum$StVideoAlbumFeedInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        if (pos == 0 && objData.album_id.get() == 0 && !TextUtils.isEmpty(objData.album_desc.get())) {
            TextView textView = this.hintTextView;
            if (textView == null) {
                String str = objData.album_desc.get();
                Intrinsics.checkNotNullExpressionValue(str, "objData.album_desc.get()");
                l0(str);
            } else if (textView != null) {
                textView.setText(objData.album_desc.get());
            }
        }
    }
}
