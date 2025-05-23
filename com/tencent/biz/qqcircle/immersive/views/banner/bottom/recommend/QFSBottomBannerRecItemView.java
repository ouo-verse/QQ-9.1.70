package com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.events.QFSBottomRecSelectEvent;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomBannerRecItemView extends QCircleBaseWidgetView<e30.b> implements View.OnClickListener, SimpleEventReceiver {
    private static final int E = ImmersiveUtils.dpToPx(4.0f);
    private static final int F = ImmersiveUtils.dpToPx(72.0f);
    private static final int G = ImmersiveUtils.dpToPx(96.0f);
    private LinearLayout C;
    private LinearLayout D;

    /* renamed from: d, reason: collision with root package name */
    private RoundCorneredFrameLayout f90714d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90715e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90716f;

    /* renamed from: h, reason: collision with root package name */
    private int f90717h;

    /* renamed from: i, reason: collision with root package name */
    private e30.b f90718i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f90719m;

    public QFSBottomBannerRecItemView(@NonNull @NotNull Context context) {
        super(context);
        q0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void k0() {
        Option targetView;
        if (this.f90715e == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f90719m.cover.layerPicUrl.get())) {
            targetView = Option.obtain().setUrl(this.f90719m.cover.picUrl.get()).setTargetView(this.f90715e);
        } else {
            targetView = Option.obtain().setUrl(this.f90719m.cover.layerPicUrl.get()).setTargetView(this.f90715e);
        }
        targetView.setRequestWidth(F);
        targetView.setRequestHeight(G);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        targetView.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    private void l0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(r.A(this.f90718i)));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(o0()));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_FEED_ID, this.f90719m.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_ORIGINAL_FEED_ID, r.A(this.f90718i).e().f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_TYPE, r.I(this.f90718i));
        VideoReport.setElementId(this.f90714d, QCircleDaTongConstant.ElementId.EM_XSJ_REC_SLOT_LIST);
        VideoReport.setElementParams(this.f90714d, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.f90714d, this.f90719m.f398449id.get());
    }

    private void m0() {
        if (this.f90716f == null) {
            return;
        }
        String f16 = r.f(this.f90719m.visitorInfo.viewCount.get());
        if (!TextUtils.isEmpty(f16)) {
            this.f90716f.setText(f16);
        }
    }

    private void n0(t40.a aVar, List<e30.b> list, int i3) {
        try {
            if (r.d0(this.f90718i, this.f90717h)) {
                QLog.d("QFSFeedBottomRecommendView", 1, "doReplace return same feed");
                return;
            }
            e30.b bVar = list.get(i3);
            bVar.m(this.f90718i);
            r.R0(this.f90718i);
            s0();
            aVar.triggerFeedReplace(bVar, i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSBottomRecSelectEvent().setSourcePos(i3).setFeedBlockData(this.f90718i).setClickPos(this.f90717h));
        } catch (Exception e16) {
            QLog.d("QFSFeedBottomRecommendView", 1, "doReplace error:" + e16);
        }
    }

    private int o0() {
        t40.a aVar = (t40.a) getIocInterface(t40.a.class);
        if (aVar == null) {
            return 0;
        }
        return aVar.getFeedPosition() + 1;
    }

    private boolean p0(int i3, List<e30.b> list) {
        if (list != null && list.size() > 0 && list.size() > i3) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r0() {
        t40.a aVar = (t40.a) getIocInterface(t40.a.class);
        if (aVar == null) {
            QLog.d("QFSFeedBottomRecommendView", 1, "can not find ioc");
            return;
        }
        int feedPosition = aVar.getFeedPosition();
        String viewModelKey = aVar.getViewModelKey();
        if (feedPosition >= 0 && !TextUtils.isEmpty(viewModelKey)) {
            IDataDisplaySurface displaySurface = w20.a.j().getDisplaySurface(e30.b.class, viewModelKey);
            if (displaySurface != null && displaySurface.getDisplaySurfaceData(new Object[0]) != null) {
                MutableLiveData displaySurfaceData = displaySurface.getDisplaySurfaceData(new Object[0]);
                if (displaySurfaceData.getValue() == 0) {
                    QLog.d("QFSFeedBottomRecommendView", 1, "can not replace surface, has not value");
                    return;
                }
                List<e30.b> list = (List) ((UIStateData) displaySurfaceData.getValue()).getData();
                if (p0(feedPosition, list)) {
                    QLog.d("QFSFeedBottomRecommendView", 1, "can replace surface params error,try get list form ioc");
                    list = aVar.getFeedList();
                }
                if (p0(feedPosition, list)) {
                    QLog.d("QFSFeedBottomRecommendView", 1, "can replace surface params error");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                n0(aVar, arrayList, feedPosition);
                return;
            }
            QLog.d("QFSFeedBottomRecommendView", 1, "can not replace,surface error ");
            return;
        }
        QLog.d("QFSFeedBottomRecommendView", 1, "can replace error params");
    }

    private void s0() {
        if (r.d0(this.f90718i, this.f90717h)) {
            this.C.setVisibility(0);
            this.D.setVisibility(8);
            QLog.d("QFSFeedBottomRecommendView", 1, "updatePlayStatus:" + this.f90717h);
            return;
        }
        this.C.setVisibility(8);
        this.D.setVisibility(0);
        QLog.d("QFSFeedBottomRecommendView", 1, "updatePlayStatus unselected:" + this.f90717h);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSBottomRecSelectEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g8k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f41201gf) {
            r0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSBottomRecSelectEvent) {
            s0();
        }
    }

    protected void q0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById(R.id.f41201gf);
        this.f90714d = roundCorneredFrameLayout;
        int i3 = E;
        roundCorneredFrameLayout.setRadius(i3, i3, i3, i3);
        this.f90714d.setOnClickListener(this);
        this.f90715e = (ImageView) findViewById(R.id.f517528y);
        this.f90716f = (TextView) findViewById(R.id.f517328w);
        this.C = (LinearLayout) findViewById(R.id.f34350yx);
        this.D = (LinearLayout) findViewById(R.id.f34360yy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        this.f90717h = i3;
        this.f90718i = bVar;
        this.f90719m = bVar.e();
        m0();
        k0();
        s0();
        l0();
    }
}
