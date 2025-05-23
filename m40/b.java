package m40;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lm40/b;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "i1", "h1", "", "w0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "", "position", "g1", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "ipTerritoryView", "J", "contentDateTv", "<init>", "()V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    private TextView ipTerritoryView;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView contentDateTv;

    /* JADX WARN: Multi-variable type inference failed */
    private final void h1() {
        if (((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().contains(42) && ((FeedCloudMeta$StFeed) this.f85017h).extInfo.has()) {
            String d16 = bh.d(((FeedCloudMeta$StFeed) this.f85017h).extInfo.get(), "qzone-user-area");
            TextView textView = null;
            if (!TextUtils.isEmpty(d16)) {
                String str = " \u00b7 " + d16;
                TextView textView2 = this.ipTerritoryView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ipTerritoryView");
                    textView2 = null;
                }
                textView2.setVisibility(0);
                TextView textView3 = this.ipTerritoryView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ipTerritoryView");
                } else {
                    textView = textView3;
                }
                textView.setText(str);
                return;
            }
            QLog.d("QFSLinearFeedDateAndIpPresenter", 1, "[updateIpTerritoryView] ipTerritory string is null");
            TextView textView4 = this.ipTerritoryView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ipTerritoryView");
            } else {
                textView = textView4;
            }
            textView.setVisibility(8);
            return;
        }
        QLog.e("QFSLinearFeedDateAndIpPresenter", 1, "[updateIpTerritoryView] feed do not contain ip info, data.extInfo.has() =" + ((FeedCloudMeta$StFeed) this.f85017h).extInfo.has());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i1() {
        TextView textView = this.contentDateTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentDateTv");
            textView = null;
        }
        textView.setText(com.tencent.biz.qqcircle.widgets.comment.b.d(((FeedCloudMeta$StFeed) this.f85017h).createTime.get() * 1000));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f40511ek);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026s_feed_ip_territory_view)");
        this.ipTerritoryView = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f363314_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_content_date)");
        this.contentDateTv = (TextView) findViewById2;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        i1();
        h1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedDateAndIpPresenter";
    }
}
