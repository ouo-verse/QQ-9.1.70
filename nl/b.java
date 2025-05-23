package nl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.groupalbum.viewmodel.am;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.LeftTxtRightPicInfo;
import com.tencent.qqnt.kernel.nativeinterface.Notice;
import com.tencent.qqnt.kernel.nativeinterface.NoticePattonInfo;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StImage;
import com.tencent.state.report.SquareReportConst;
import fj.q;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lnl/b;", "Lcom/qzone/reborn/base/l;", "Lkl/a;", "Landroid/view/View;", "view", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "elementView", "", "elementId", HippyTKDListViewAdapter.X, "data", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lgf/a;", "e", "Lgf/a;", "mCommentIoc", "Landroid/view/View$OnClickListener;", "f", "Landroid/view/View$OnClickListener;", "y", "()Landroid/view/View$OnClickListener;", "clickSpaceListener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class b extends com.qzone.reborn.base.l<kl.a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private gf.a mCommentIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View.OnClickListener clickSpaceListener = new View.OnClickListener() { // from class: nl.a
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.w(b.this, view);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(b this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.A(v3);
        this$0.B(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(View view) {
        Notice notice;
        NoticePattonInfo noticePattonInfo;
        LeftTxtRightPicInfo leftTxtRightPicInfo;
        StImage stImage;
        Intrinsics.checkNotNullParameter(view, "view");
        BusinessFeedData v3 = v((kl.a) this.mData);
        if (v3 != null && ef.b.d(v3)) {
            oi.c m3 = ho.i.m();
            Intrinsics.checkNotNullExpressionValue(m3, "groupAlbum()");
            Activity activity = p();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            kl.a aVar = (kl.a) this.mData;
            oi.c.f(m3, activity, v3, 18, (aVar == null || (notice = aVar.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String()) == null || (noticePattonInfo = notice.noticePatton) == null || (leftTxtRightPicInfo = noticePattonInfo.lefttxtRightPic) == null || (stImage = leftTxtRightPicInfo.picInfo) == null) ? null : stImage.lloc, null, 16, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(View view) {
        Notice notice;
        Intrinsics.checkNotNullParameter(view, "view");
        kl.a aVar = (kl.a) this.mData;
        String str = (aVar == null || (notice = aVar.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String()) == null) ? null : notice.noticeId;
        if (str == null) {
            return;
        }
        q.f399468a.e(str, "em_qz_remaining_operating_area", view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(View elementView, String elementId) {
        Intrinsics.checkNotNullParameter(elementView, "elementView");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        HashMap hashMap = new HashMap();
        String str = ((kl.a) this.mData).getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().opUser.uid;
        Intrinsics.checkNotNullExpressionValue(str, "mData.notice.opUser.uid");
        hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str);
        fo.c.o(elementView, elementId, new fo.b().l(hashMap).i(((kl.a) this.mData).getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().noticeId));
    }

    /* renamed from: y, reason: from getter */
    public final View.OnClickListener getClickSpaceListener() {
        return this.clickSpaceListener;
    }

    public final void z(kl.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        BusinessFeedData v3 = v(data);
        if (v3 == null) {
            return;
        }
        Comment H = yh.b.H(data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().feedComment, data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().ext);
        Reply M = !TextUtils.isEmpty(data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().feedReply.f359225id) ? yh.b.M(data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().feedReply, data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().ext) : null;
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.isComment = M == null;
        clickedComment.setComment(H);
        clickedComment.setReply(M);
        com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(v3);
        bVar.f54740a = this.mPosition;
        bVar.f54741b = 4;
        if (this.mCommentIoc == null) {
            this.mCommentIoc = (gf.a) q(gf.a.class);
        }
        gf.a aVar = this.mCommentIoc;
        if (aVar != null) {
            aVar.f6(bVar);
        }
        if (data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().noticeType == 9) {
            gf.a aVar2 = this.mCommentIoc;
            if (aVar2 != null) {
                aVar2.c1(v3, null, this.mPosition);
                return;
            }
            return;
        }
        gf.a aVar3 = this.mCommentIoc;
        if (aVar3 != null) {
            aVar3.c1(v3, clickedComment, this.mPosition);
        }
    }

    public final BusinessFeedData v(kl.a data) {
        StFeed stFeed;
        BusinessFeedData f16;
        Notice notice;
        if (((data == null || (notice = data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String()) == null) ? null : notice.feed) == null || (stFeed = data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().feed) == null || (f16 = yh.a.f450323a.f(stFeed, data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().ext, data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().feedComment, data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().feedReply)) == null) {
            return null;
        }
        f16.cellGroupAlbumInfo.groupId = ((am) t(am.class)).getGroupId();
        return f16;
    }
}
