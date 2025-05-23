package me;

import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedpro.section.ad.basepresenter.QZoneAdFeedBaseVideoSection;
import com.qzone.reborn.feedpro.widget.ad.QZoneAdFeedProSingleVideoWidgetView;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lme/l;", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection;", "", tl.h.F, "", "W", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "T", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcf/b;", "event", "r", "play", "pause", "Lyd/a;", "L", "Lyd/a;", "mAdFeedData", "<init>", "()V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends QZoneAdFeedBaseVideoSection {

    /* renamed from: L, reason: from kotlin metadata */
    private yd.a mAdFeedData;

    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.QZoneAdFeedBaseVideoSection
    public boolean Q() {
        return QZoneAdFeedUtils.f55717a.O(yd.b.h(this.mAdFeedData));
    }

    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.QZoneAdFeedBaseVideoSection
    public boolean R() {
        return QZoneAdFeedUtils.f55717a.S(yd.b.h(this.mAdFeedData));
    }

    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.QZoneAdFeedBaseVideoSection
    public boolean T() {
        yd.a h16 = xd.c.h(getMFeedData());
        String g16 = yd.b.g(h16);
        String l3 = yd.b.l(h16);
        String g17 = yd.b.g(this.mAdFeedData);
        String l16 = yd.b.l(this.mAdFeedData);
        QLog.i("PSLink-QZoneAdGdtFeedVideoSection", 2, "[onBindData] aid:" + g16 + " traceId:" + l3 + " oldAid:" + g17 + " oldTraceId:" + l16);
        return !TextUtils.isEmpty(l3) && TextUtils.equals(l3, l16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0055, code lost:
    
        if (r1 == null) goto L14;
     */
    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.QZoneAdFeedBaseVideoSection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W() {
        CommonMedia commonMedia;
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        int lastIndex;
        CommonMedia commonMedia2;
        this.mAdFeedData = xd.c.h(getMFeedData());
        X(new QZoneAdFeedBaseVideoSection.a());
        getMAdFeedVideoData().d(yd.b.g(this.mAdFeedData));
        getMAdFeedVideoData().e(yd.b.l(this.mAdFeedData));
        QZoneAdFeedBaseVideoSection.a mAdFeedVideoData = getMAdFeedVideoData();
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData != null && (cellMedia = mFeedData.getCellMedia()) != null && (mediaItems = cellMedia.getMediaItems()) != null) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(mediaItems);
            if (lastIndex >= 0) {
                commonMedia2 = mediaItems.get(0);
            } else {
                commonMedia2 = new CommonMedia();
            }
            commonMedia = commonMedia2;
        }
        commonMedia = new CommonMedia();
        mAdFeedVideoData.f(commonMedia);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "PSLink-QZoneAdGdtFeedVideoSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mvq /* 1745224777 */:
                case R.id.mvr /* 1745224778 */:
                    g6.c.f401419a.g(getActivity(), v3, this.mAdFeedData, FeedElement.VIDEO, 6, getMPosition(), null);
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // de.f
    public void pause() {
        QZoneAdFeedProSingleVideoWidgetView mVideoItemWidgetView = getMVideoItemWidgetView();
        if (mVideoItemWidgetView != null) {
            mVideoItemWidgetView.pause();
        }
    }

    @Override // de.f
    public void play() {
        QZoneAdFeedProSingleVideoWidgetView mVideoItemWidgetView = getMVideoItemWidgetView();
        if (mVideoItemWidgetView != null) {
            mVideoItemWidgetView.play();
        }
    }

    @Override // ne.a
    public void r(cf.b event) {
        QZoneAdFeedProSingleVideoWidgetView mVideoItemWidgetView;
        super.r(event);
        if (event == null || event.f30765a != 1005 || getMVideoItemWidgetView() == null || (mVideoItemWidgetView = getMVideoItemWidgetView()) == null) {
            return;
        }
        mVideoItemWidgetView.o1();
    }
}
