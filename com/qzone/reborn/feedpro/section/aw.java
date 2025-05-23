package com.qzone.reborn.feedpro.section;

import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProSingleVideoWidgetView;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0014J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0011H\u0016J \u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0005R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010-\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/feedpro/section/aw;", "Lne/a;", "Lde/f;", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "", "I", "Landroid/view/View;", "containerView", "", "currentProgress", "Landroid/widget/ImageView;", "coverView", "J", "G", "", ViewStickEventHelper.IS_SHOW, "L", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "play", "pause", "a", "d", "Ljava/util/UUID;", "uuid", "id", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "generateTransAnimBean", "picId", "updateOriginContainer", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProSingleVideoWidgetView;", "E", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProSingleVideoWidgetView;", "mVideoItemWidgetView", UserInfo.SEX_FEMALE, "mTransCreatorKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", "mVideoInfo", "<init>", "()V", "H", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aw extends ne.a implements de.f, RFWTransitionHelper.TransAnimCreator {

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFeedProSingleVideoWidgetView mVideoItemWidgetView;

    /* renamed from: F, reason: from kotlin metadata */
    private int mTransCreatorKey;

    /* renamed from: G, reason: from kotlin metadata */
    private CommonVideo mVideoInfo;

    private final void G() {
        final CommonFeed mFeedData = getMFeedData();
        if (mFeedData == null) {
            return;
        }
        final String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        RFWIocAbilityProvider.g().getIoc(de.e.class).originView(getMRootView()).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedpro.section.au
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                aw.H(aw.this, feedUniqueKey, mFeedData, (de.e) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(aw this$0, String reuseKey, CommonFeed feedData, de.e eVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reuseKey, "$reuseKey");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this$0.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        eVar.b(qzoneFeedProSingleVideoWidgetView, "em_qz_video_content_block", reuseKey, feedData);
    }

    private final void I() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("feedid", CommonFeedExtKt.getFeedUniqueKey(getMFeedData()));
        linkedHashMap.put("click_type", 1);
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        fo.c.b("dt_clck", qzoneFeedProSingleVideoWidgetView, "em_qz_feed_picture", new fo.b().l(linkedHashMap));
    }

    private final void J(View containerView, long currentProgress, ImageView coverView) {
        ie.b.f407555a.b(getMFeedData(), getMForwardFeedData(), getActivity(), coverView, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(aw this$0, View containerView, View view) {
        ImageView imageView;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(containerView, "$containerView");
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = null;
        QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = view instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) view : null;
        if (qzoneFeedProMixBaseWidgetView == null || (imageView = qzoneFeedProMixBaseWidgetView.getMImageView()) == null) {
            imageView = null;
        } else {
            imageView.setTag(R.id.f100755tc, Integer.valueOf(this$0.mTransCreatorKey));
        }
        CommonVideo commonVideo = this$0.mVideoInfo;
        if (commonVideo != null) {
            QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView2 = this$0.mVideoItemWidgetView;
            if (qzoneFeedProSingleVideoWidgetView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            } else {
                qzoneFeedProSingleVideoWidgetView = qzoneFeedProSingleVideoWidgetView2;
            }
            j3 = qzoneFeedProSingleVideoWidgetView.Z0(commonVideo);
        } else {
            j3 = 0;
        }
        this$0.J(containerView, j3, imageView);
        this$0.I();
    }

    private final void L(boolean isShow) {
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        QZoneVideoView i16 = qzoneFeedProSingleVideoWidgetView.i1();
        if (i16 != null) {
            i16.setVisibility(isShow ? 0 : 4);
        }
        qzoneFeedProSingleVideoWidgetView.setPlayIconVisible(isShow);
    }

    @Override // de.f
    public void a() {
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        qzoneFeedProSingleVideoWidgetView.a();
    }

    @Override // de.f
    public View d() {
        int mPosition = getMPosition();
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        QLog.d("QzoneFeedProSingleVideoSection", 1, "getVideoItemView  | feedPos = " + mPosition + " | view = " + qzoneFeedProSingleVideoWidgetView);
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView2 = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView2 != null) {
            return qzoneFeedProSingleVideoWidgetView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
        return null;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String id5) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        ImageView mImageView = qzoneFeedProSingleVideoWidgetView.getMImageView();
        if (mImageView == null) {
            return null;
        }
        CommonFeed mFeedData = getMFeedData();
        Intrinsics.checkNotNull(mFeedData);
        CommonCellMedia cellMedia = mFeedData.getCellMedia();
        Intrinsics.checkNotNull(cellMedia);
        return RFWLayerLaunchUtil.getTransAnimBean(uuid, mImageView, je.a.x(cellMedia.getMediaItems().get(0), getMFeedData()), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProSingleVideoSection";
    }

    @Override // ne.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        a();
    }

    @Override // de.f
    public void pause() {
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        qzoneFeedProSingleVideoWidgetView.pause();
    }

    @Override // de.f
    public void play() {
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        qzoneFeedProSingleVideoWidgetView.play();
    }

    @Override // ne.a
    protected int q() {
        return R.id.no9;
    }

    @Override // ne.a
    protected boolean u() {
        return true;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String picId, boolean isShow) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(picId, "picId");
        L(isShow);
    }

    @Override // ne.a
    protected void z(final View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162966nl1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d.video_item_widget_view)");
        this.mVideoItemWidgetView = (QzoneFeedProSingleVideoWidgetView) findViewById;
        this.mTransCreatorKey = RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this);
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        qzoneFeedProSingleVideoWidgetView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.av
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aw.K(aw.this, containerView, view);
            }
        });
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        if (feedData == null || (cellMedia = feedData.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null || mediaItems.isEmpty() || mediaItems.get(0).getVideo() == null) {
            return;
        }
        this.mVideoInfo = mediaItems.get(0).getVideo();
        QzoneFeedProSingleVideoWidgetView qzoneFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qzoneFeedProSingleVideoWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoItemWidgetView");
            qzoneFeedProSingleVideoWidgetView = null;
        }
        qzoneFeedProSingleVideoWidgetView.setFeedData(feedData);
        qzoneFeedProSingleVideoWidgetView.setFeedPosition(getMPosition());
        qzoneFeedProSingleVideoWidgetView.Q0(mediaItems.get(0));
        G();
    }
}
