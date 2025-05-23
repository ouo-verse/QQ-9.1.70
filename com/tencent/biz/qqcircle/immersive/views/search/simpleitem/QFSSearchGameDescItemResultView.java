package com.tencent.biz.qqcircle.immersive.views.search.simpleitem;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.views.search.simpleitem.QFSSearchGameDescItemResultView;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectTextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StSearchGameDesc;
import feedcloud.FeedCloudRead$StSearchTextItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchGameDescItemResultView extends QFSSearchBaseWidgetView<FeedCloudRead$StSearchGameDesc> {
    private final QFSPressEffectTextView C;
    private final QFSPressEffectTextView D;
    private final QFSPressEffectTextView E;
    private final QFSPressEffectTextView F;

    /* renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f91188e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f91189f;

    /* renamed from: h, reason: collision with root package name */
    private final SquareImageView f91190h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f91191i;

    /* renamed from: m, reason: collision with root package name */
    private final Barrier f91192m;

    public QFSSearchGameDescItemResultView(@NonNull Context context) {
        super(context);
        this.f91188e = (ConstraintLayout) findViewById(R.id.f52852ax);
        this.f91189f = (TextView) findViewById(R.id.f52872az);
        this.f91190h = (SquareImageView) findViewById(R.id.f52862ay);
        this.f91191i = (TextView) findViewById(R.id.f52882b0);
        Barrier barrier = (Barrier) findViewById(R.id.f52802as);
        this.f91192m = barrier;
        this.C = (QFSPressEffectTextView) findViewById(R.id.f52812at);
        this.D = (QFSPressEffectTextView) findViewById(R.id.f52822au);
        this.E = (QFSPressEffectTextView) findViewById(R.id.f52832av);
        this.F = (QFSPressEffectTextView) findViewById(R.id.f52842aw);
        barrier.setReferencedIds(new int[]{R.id.f52862ay, R.id.f52882b0});
    }

    private void n0(View view, int i3, FeedCloudRead$StSearchTextItem feedCloudRead$StSearchTextItem) {
        if (!TextUtils.isEmpty(QCircleDaTongConstant.ElementId.EM_XSJ_GAME_INTRODUCTION_ITEM) && view.getVisibility() != 8) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_item_index", Integer.valueOf(i3 + 1));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GAME_INTRODUCTION_ITEM_NAME, feedCloudRead$StSearchTextItem.text.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, feedCloudRead$StSearchTextItem.report.attachInfo.get());
            i.k(view, QCircleDaTongConstant.ElementId.EM_XSJ_GAME_INTRODUCTION_ITEM, hashMap, feedCloudRead$StSearchTextItem.hashCode());
        }
    }

    private boolean o0(FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc) {
        if (feedCloudRead$StSearchGameDesc == null || TextUtils.isEmpty(feedCloudRead$StSearchGameDesc.title.get().trim()) || TextUtils.isEmpty(feedCloudRead$StSearchGameDesc.content.get().trim())) {
            return false;
        }
        return true;
    }

    private void p0(FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc) {
        ConstraintLayout constraintLayout = this.f91188e;
        if (constraintLayout == null) {
            return;
        }
        i.k(constraintLayout, QCircleDaTongConstant.ElementId.EM_XSJ_GAME_INTRODUCTION_CARD, q0(feedCloudRead$StSearchGameDesc), feedCloudRead$StSearchGameDesc.hashCode());
    }

    private Map<String, Object> q0(FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRACE_ID, String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, feedCloudRead$StSearchGameDesc.report.attachInfo.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HAS_COVER_PIC, Integer.valueOf(!TextUtils.isEmpty(feedCloudRead$StSearchGameDesc.icon.get()) ? 1 : 0));
        return hashMap;
    }

    private void r0(QFSPressEffectTextView qFSPressEffectTextView, FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc, int i3) {
        List<FeedCloudRead$StSearchTextItem> list = feedCloudRead$StSearchGameDesc.items.get();
        if (list.size() > i3) {
            qFSPressEffectTextView.setVisibility(0);
            final FeedCloudRead$StSearchTextItem feedCloudRead$StSearchTextItem = list.get(i3);
            qFSPressEffectTextView.setText(feedCloudRead$StSearchTextItem.text.get().trim());
            qFSPressEffectTextView.setOnClickListener(new View.OnClickListener() { // from class: s90.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSSearchGameDescItemResultView.this.w0(feedCloudRead$StSearchTextItem, view);
                }
            });
            n0(qFSPressEffectTextView, i3, feedCloudRead$StSearchTextItem);
            return;
        }
        qFSPressEffectTextView.setVisibility(8);
    }

    private void s0() {
        this.f91188e.setVisibility(8);
    }

    private void u0(final FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc) {
        this.f91188e.setVisibility(0);
        this.f91189f.setText(feedCloudRead$StSearchGameDesc.title.get().trim());
        if (!TextUtils.isEmpty(feedCloudRead$StSearchGameDesc.icon.get())) {
            v0(feedCloudRead$StSearchGameDesc);
        } else {
            this.f91190h.setVisibility(8);
        }
        this.f91191i.setText(feedCloudRead$StSearchGameDesc.content.get().trim());
        r0(this.C, feedCloudRead$StSearchGameDesc, 0);
        r0(this.D, feedCloudRead$StSearchGameDesc, 1);
        r0(this.E, feedCloudRead$StSearchGameDesc, 2);
        r0(this.F, feedCloudRead$StSearchGameDesc, 3);
        p0(feedCloudRead$StSearchGameDesc);
        this.f91188e.setOnClickListener(new View.OnClickListener() { // from class: s90.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSSearchGameDescItemResultView.this.x0(feedCloudRead$StSearchGameDesc, view);
            }
        });
    }

    private void v0(FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc) {
        this.f91190h.setVisibility(0);
        this.f91190h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ColorDrawable colorDrawable = new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton));
        Option obtain = Option.obtain();
        obtain.setTargetView(this.f91190h);
        obtain.setUrl(feedCloudRead$StSearchGameDesc.icon.get());
        obtain.setFailDrawable(colorDrawable);
        obtain.setLoadingDrawable(colorDrawable);
        obtain.setRequestWidth(this.f91190h.getWidth());
        obtain.setRequestHeight(this.f91190h.getHeight());
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(FeedCloudRead$StSearchTextItem feedCloudRead$StSearchTextItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleSchemeLauncher.f(getContext(), feedCloudRead$StSearchTextItem.scheme.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleSchemeLauncher.f(getContext(), feedCloudRead$StSearchGameDesc.scheme.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.grx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc, int i3) {
        if (!o0(feedCloudRead$StSearchGameDesc)) {
            s0();
        } else {
            u0(feedCloudRead$StSearchGameDesc);
        }
    }
}
