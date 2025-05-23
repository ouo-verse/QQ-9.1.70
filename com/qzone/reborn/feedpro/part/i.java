package com.qzone.reborn.feedpro.part;

import android.view.View;
import com.qzone.reborn.base.n;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J.\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J6\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedpro/part/i;", "Lcom/qzone/reborn/feedpro/part/b;", "Lde/d;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "getLogTag", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "", "oldStatus", "Lcom/qzone/reborn/base/n$a;", "", "dataCallBack", "R3", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "reply", "F4", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "d", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends b implements de.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.i mDetailViewModel;

    @Override // de.d
    public void F4(CommonFeed feedData, CommonComment comment, CommonReply reply, int oldStatus, n.a<Boolean> dataCallBack) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(dataCallBack, "dataCallBack");
        if (oldStatus == 1) {
            com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
            if (iVar != null) {
                iVar.w2(feedData, comment, reply, dataCallBack);
                return;
            }
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar2 = this.mDetailViewModel;
        if (iVar2 != null) {
            iVar2.v2(feedData, comment, reply, dataCallBack);
        }
    }

    @Override // de.d
    public void R3(CommonFeed feedData, CommonComment comment, int oldStatus, n.a<Boolean> dataCallBack) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(dataCallBack, "dataCallBack");
        if (oldStatus == 1) {
            com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
            if (iVar != null) {
                iVar.u2(feedData, comment, dataCallBack);
                return;
            }
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.i iVar2 = this.mDetailViewModel;
        if (iVar2 != null) {
            iVar2.t2(feedData, comment, dataCallBack);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProDetailCommentLikePart";
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, de.d.class);
        this.mDetailViewModel = (com.qzone.reborn.feedpro.viewmodel.i) getViewModel(com.qzone.reborn.feedpro.viewmodel.i.class);
    }
}
