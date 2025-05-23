package com.qzone.reborn.groupalbum.section.feed;

import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellMediaInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\u0006\u0010\u000f\u001a\u00020\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/groupalbum/section/feed/o;", "Lcom/qzone/reborn/groupalbum/section/feed/n;", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "K", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mAlbumNameTextView", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends n {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mAlbumNameTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.groupalbum.section.feed.n, vg.a
    public void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        super.C(containerView);
        this.mAlbumNameTextView = (TextView) containerView.findViewById(R.id.n2r);
        this.f441562d.setVisibility(0);
        TextView textView = this.mAlbumNameTextView;
        if (textView == null) {
            return;
        }
        textView.setMaxWidth(ef.d.b(K() ? 75 : 120));
    }

    public final boolean K() {
        return FontSettingManager.getFontLevel() > 17.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "GroupAlbumFeedTailPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnk;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        CellMediaInfo cellMediaInfo;
        CellMediaInfo cellMediaInfo2;
        String str = null;
        String str2 = (feedData == null || (cellMediaInfo2 = feedData.cellMediaInfo) == null) ? null : cellMediaInfo2.albumName;
        if (str2 == null || str2.length() == 0) {
            this.f441562d.setVisibility(8);
            return;
        }
        this.f441562d.setVisibility(0);
        TextView textView = this.mAlbumNameTextView;
        if (textView == null) {
            return;
        }
        if (feedData != null && (cellMediaInfo = feedData.cellMediaInfo) != null) {
            str = cellMediaInfo.albumName;
        }
        textView.setText(str);
    }
}
