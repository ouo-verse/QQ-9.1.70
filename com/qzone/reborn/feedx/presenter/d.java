package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class d extends vg.a {
    private BusinessFeedData K() {
        return this.f441565h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(QZoneRichTextView qZoneRichTextView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        xg.d.a(K(), this.C, qZoneRichTextView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(QZonePicMixVideoView qZonePicMixVideoView, PictureItem pictureItem, int i3, View view) {
        xg.d.a(K(), this.C, qZonePicMixVideoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(QZoneRichTextView qZoneRichTextView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        xg.d.a(K(), this.C, qZoneRichTextView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(BusinessFeedData businessFeedData, final QZoneRichTextView qZoneRichTextView) {
        if (qZoneRichTextView == null) {
            return;
        }
        if (businessFeedData != null && businessFeedData.getCellSummaryV2() != null) {
            String str = businessFeedData.getCellSummaryV2().displayStr;
            if (!TextUtils.isEmpty(str)) {
                qZoneRichTextView.setVisibility(0);
                qZoneRichTextView.setRichText(str);
                qZoneRichTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.this.L(qZoneRichTextView, view);
                    }
                });
                return;
            }
            qZoneRichTextView.setVisibility(8);
            return;
        }
        qZoneRichTextView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(BusinessFeedData businessFeedData, final QZoneRichTextView qZoneRichTextView) {
        if (qZoneRichTextView == null) {
            return;
        }
        if (businessFeedData != null && businessFeedData.getTitleInfoV2() != null) {
            String str = businessFeedData.getTitleInfoV2().title;
            if (!TextUtils.isEmpty(str)) {
                qZoneRichTextView.setRichText(str);
                qZoneRichTextView.setVisibility(0);
                qZoneRichTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.this.N(qZoneRichTextView, view);
                    }
                });
                return;
            }
            qZoneRichTextView.setVisibility(8);
            return;
        }
        qZoneRichTextView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(BusinessFeedData businessFeedData, QZoneRichTextView qZoneRichTextView, final QZonePicMixVideoView qZonePicMixVideoView) {
        if (qZonePicMixVideoView == null || qZoneRichTextView == null) {
            return;
        }
        if (businessFeedData != null && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null) {
            if (ArrayUtils.isOutOfArrayIndex(0, businessFeedData.getPictureInfo().pics)) {
                qZonePicMixVideoView.setVisibility(8);
                qZoneRichTextView.setMaxLine(8);
            } else {
                qZonePicMixVideoView.setVisibility(0);
                qZonePicMixVideoView.setOnItemClickListener(new QZonePicMixVideoView.c() { // from class: com.qzone.reborn.feedx.presenter.a
                    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView.c
                    public final void a(PictureItem pictureItem, int i3, View view) {
                        d.this.M(qZonePicMixVideoView, pictureItem, i3, view);
                    }
                });
                qZoneRichTextView.setMaxLine(3);
            }
            qZonePicMixVideoView.setData(businessFeedData, this.f441567m);
            return;
        }
        qZonePicMixVideoView.setVisibility(8);
    }
}
