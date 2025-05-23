package com.qzone.reborn.groupalbum.section.feed;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.groupalbum.event.GroupAlbumFeedExposureEvent;
import com.qzone.reborn.groupalbum.reship.util.GroupAlbumReshipUtil;
import com.qzone.reborn.groupalbum.viewmodel.x;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0010H\u0014J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000eH\u0014J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0014J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/groupalbum/section/feed/l;", "Lvg/a;", "Landroidx/lifecycle/Observer;", "Laf/c;", "", ExifInterface.LATITUDE_SOUTH, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "M", "feedData", "a0", "Landroid/view/View;", "view", "", "isEnable", "Y", "", "O", "P", "", "k", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "containerView", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "likeInfoBean", "T", "Lcom/qzone/reborn/groupalbum/viewmodel/x;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/groupalbum/viewmodel/x;", "mLikeViewModel", "Lgf/a;", "G", "Lgf/a;", "mCommentIoc", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "H", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "mPraiseView", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mCommentView", "J", "mForwardView", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends vg.a implements Observer<af.c> {

    /* renamed from: F, reason: from kotlin metadata */
    private x mLikeViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private gf.a mCommentIoc;

    /* renamed from: H, reason: from kotlin metadata */
    private SuperLikeView mPraiseView;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mCommentView;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mForwardView;

    private final void M() {
        final String a16 = ef.b.a(this.f441565h);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: com.qzone.reborn.groupalbum.section.feed.g
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                l.N(l.this, a16, (gf.e) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(l this$0, String str, gf.e reportIoc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportIoc, "reportIoc");
        SuperLikeView superLikeView = this$0.mPraiseView;
        if (superLikeView != null) {
            Intrinsics.checkNotNull(superLikeView);
            reportIoc.k5(superLikeView, "em_qz_like_icon", str, this$0.f441565h);
        }
        ImageView imageView = this$0.mCommentView;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            reportIoc.k5(imageView, "em_qz_comment_icon", str, this$0.f441565h);
        }
        ImageView imageView2 = this$0.mForwardView;
        if (imageView2 != null) {
            Intrinsics.checkNotNull(imageView2);
            reportIoc.k5(imageView2, "em_qz_transfer_icon", str, this$0.f441565h);
        }
    }

    private final int O() {
        return R.drawable.qui_like_filled_brand;
    }

    private final int P() {
        return R.drawable.qui_like_qzone;
    }

    private final void Q() {
        if (this.mCommentIoc == null) {
            this.mCommentIoc = (gf.a) j(gf.a.class);
        }
        com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(this.f441565h);
        bVar.f54740a = this.f441567m;
        bVar.f54741b = 4;
        gf.a aVar = this.mCommentIoc;
        if (aVar != null) {
            aVar.f6(bVar);
        }
        gf.a aVar2 = this.mCommentIoc;
        if (aVar2 != null) {
            aVar2.c1(this.f441565h, null, this.f441567m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void R() {
        long j3;
        String str;
        CellPictureInfo cellPictureInfo;
        String str2;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null) {
            if (businessFeedData.cellPictureInfo == null && businessFeedData.getVideoInfo() == null) {
                return;
            }
            ArrayList<CommonStMedia> arrayList = new ArrayList<>();
            CellPictureInfo cellPictureInfo2 = this.f441565h.cellPictureInfo;
            int i3 = 0;
            if (cellPictureInfo2 != null) {
                ArrayList<PictureItem> arrayList2 = cellPictureInfo2.pics;
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    Iterator<PictureItem> it = this.f441565h.cellPictureInfo.pics.iterator();
                    while (it.hasNext()) {
                        CommonStMedia g16 = fj.e.g(it.next());
                        if (g16 != null) {
                            arrayList.add(g16);
                        }
                    }
                    str = this.f441565h.cellPictureInfo.albumid;
                    Intrinsics.checkNotNullExpressionValue(str, "mFeedData.cellPictureInfo.albumid");
                    j3 = this.f441565h.cellPictureInfo.batchId;
                    long j16 = j3;
                    cellPictureInfo = this.f441565h.cellPictureInfo;
                    if (cellPictureInfo != null && cellPictureInfo.uploadnum > arrayList.size()) {
                        i3 = (this.f441565h.cellPictureInfo.uploadnum - arrayList.size()) + 1;
                    }
                    int i16 = i3;
                    GroupAlbumReshipUtil groupAlbumReshipUtil = GroupAlbumReshipUtil.f56889a;
                    CellGroupAlbumInfo cellGroupAlbumInfo = this.f441565h.cellGroupAlbumInfo;
                    str2 = cellGroupAlbumInfo == null ? cellGroupAlbumInfo.groupId : null;
                    if (str2 == null) {
                        str2 = "";
                    }
                    Activity activity = i();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    groupAlbumReshipUtil.b(arrayList, str2, str, activity, j16, i16);
                }
            }
            if (this.f441565h.getVideoInfo() == null) {
                j3 = 0;
                str = "";
            } else {
                CommonStMedia commonStMedia = new CommonStMedia();
                commonStMedia.V(fj.e.h(this.f441565h.getVideoInfo()));
                commonStMedia.E(CommonEnumMediaType.VIDEO.ordinal());
                commonStMedia.x(this.f441565h.getVideoInfo().desc);
                commonStMedia.F(this.f441565h.getVideoInfo().uploadUid);
                commonStMedia.M(this.f441565h.getVideoInfo().shootTime);
                arrayList.add(commonStMedia);
                str = this.f441565h.getVideoInfo().albumid;
                Intrinsics.checkNotNullExpressionValue(str, "mFeedData.videoInfo.albumid");
                j3 = this.f441565h.getVideoInfo().batchId;
            }
            long j162 = j3;
            cellPictureInfo = this.f441565h.cellPictureInfo;
            if (cellPictureInfo != null) {
                i3 = (this.f441565h.cellPictureInfo.uploadnum - arrayList.size()) + 1;
            }
            int i162 = i3;
            GroupAlbumReshipUtil groupAlbumReshipUtil2 = GroupAlbumReshipUtil.f56889a;
            CellGroupAlbumInfo cellGroupAlbumInfo2 = this.f441565h.cellGroupAlbumInfo;
            if (cellGroupAlbumInfo2 == null) {
            }
            if (str2 == null) {
            }
            Activity activity2 = i();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            groupAlbumReshipUtil2.b(arrayList, str2, str, activity2, j162, i162);
        }
    }

    private final void S() {
        if (this.f441565h == null) {
            return;
        }
        if (this.mLikeViewModel == null) {
            this.mLikeViewModel = (x) r(x.class);
        }
        x xVar = this.mLikeViewModel;
        if (xVar != null) {
            BusinessFeedData mFeedData = this.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            xVar.M1(mFeedData);
        }
        BusinessFeedData mFeedData2 = this.f441565h;
        Intrinsics.checkNotNullExpressionValue(mFeedData2, "mFeedData");
        Z(mFeedData2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
        if (superLikeAnimator$Event == SuperLikeAnimator$Event.CLICK) {
            view.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Z(BusinessFeedData businessFeedData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(businessFeedData);
        SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumFeedExposureEvent(2, arrayList));
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.isFakeFeed()) {
            Y(this.mPraiseView, false);
            SuperLikeView superLikeView = this.mPraiseView;
            if (superLikeView != null) {
                superLikeView.setImageResource(P());
            }
            Y(this.mCommentView, false);
            Y(this.mForwardView, false);
            return;
        }
        Y(this.mPraiseView, true);
        Y(this.mCommentView, true);
        Y(this.mForwardView, true);
        a0(feedData);
        if (!TextUtils.isEmpty(ef.b.a(feedData))) {
            ze.a.a().observerGlobalState(new af.c(ef.b.a(feedData), feedData.cellLikeInfo), this);
        } else {
            QLog.e("GroupAlbumFeedOperatePresenter", 1, "ugcKey is empty");
        }
        M();
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mPraiseView = (SuperLikeView) containerView.findViewById(R.id.n9l);
        this.mCommentView = (ImageView) containerView.findViewById(R.id.mt7);
        this.mForwardView = (ImageView) containerView.findViewById(R.id.n2a);
        ImageView imageView = this.mCommentView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.section.feed.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.U(l.this, view);
                }
            });
        }
        SuperLikeView superLikeView = this.mPraiseView;
        if (superLikeView != null) {
            superLikeView.setImageResource(P());
        }
        SuperLikeView superLikeView2 = this.mPraiseView;
        if (superLikeView2 != null) {
            superLikeView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.section.feed.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.V(l.this, view);
                }
            });
        }
        SuperLikeView superLikeView3 = this.mPraiseView;
        if (superLikeView3 != null) {
            superLikeView3.setOnEventBack(new SuperLikeView.OnEventBack() { // from class: com.qzone.reborn.groupalbum.section.feed.j
                @Override // com.qzone.module.feedcomponent.ui.common.SuperLikeView.OnEventBack
                public final void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view) {
                    l.W(superLikeAnimator$Event, view);
                }
            });
        }
        ImageView imageView2 = this.mForwardView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.section.feed.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.X(l.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "GroupAlbumFeedOperatePresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnt;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private final void a0(BusinessFeedData feedData) {
        if ((feedData != null ? feedData.getLikeInfo() : null) == null) {
            return;
        }
        boolean z16 = feedData.getLikeInfo().isLiked;
        SuperLikeView superLikeView = this.mPraiseView;
        if (superLikeView != null) {
            superLikeView.setVisibility(0);
        }
        SuperLikeView superLikeView2 = this.mPraiseView;
        if (superLikeView2 != null) {
            superLikeView2.setSelected(z16);
        }
        if (z16) {
            SuperLikeView superLikeView3 = this.mPraiseView;
            if (superLikeView3 != null) {
                superLikeView3.setImageResource(O());
                return;
            }
            return;
        }
        SuperLikeView superLikeView4 = this.mPraiseView;
        if (superLikeView4 != null) {
            superLikeView4.setImageResource(P());
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.c likeInfoBean) {
        if (likeInfoBean == null || !TextUtils.equals(likeInfoBean.a(), ef.b.a(this.f441565h))) {
            return;
        }
        this.f441565h.cellLikeInfo = likeInfoBean.b();
        a0(this.f441565h);
    }

    private final void Y(View view, boolean isEnable) {
        if (isEnable) {
            if (view != null) {
                view.setAlpha(1.0f);
            }
        } else if (view != null) {
            view.setAlpha(0.3f);
        }
        if (view == null) {
            return;
        }
        view.setEnabled(isEnable);
    }
}
