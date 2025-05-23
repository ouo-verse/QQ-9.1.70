package com.tencent.biz.qqcircle.push;

import android.app.Activity;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$PushBrokeToast;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h extends PopupWindow implements View.OnClickListener, SimpleEventReceiver {
    private TextView C;
    private TextView D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private Context f91845d;

    /* renamed from: e, reason: collision with root package name */
    private View f91846e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f91847f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f91848h;

    /* renamed from: i, reason: collision with root package name */
    private FeedCloudMeta$PushBrokeToast f91849i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f91850m;

    public h(Context context, FeedCloudMeta$PushBrokeToast feedCloudMeta$PushBrokeToast, String str) {
        this.f91845d = context;
        this.f91849i = feedCloudMeta$PushBrokeToast;
        this.E = str;
        c();
    }

    private void a(View view, String str) {
        if (this.f91849i == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("amount", Integer.valueOf(this.f91849i.give_rocket_num.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_OPT_CNT, Integer.valueOf(this.f91849i.give_no.get()));
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setLogicParent(view, this.f91846e);
        VideoReport.reportEvent("dt_imp", view, buildElementParams);
    }

    private void b(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && !aSEngineTabStatusEvent.isSelected()) {
            dismiss();
        }
    }

    private void c() {
        View inflate = LayoutInflater.from(this.f91845d).inflate(R.layout.gp9, (ViewGroup) null, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f44151oe);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f504625g);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.f504525f);
        this.f91847f = (ImageView) inflate.findViewById(R.id.f3630147);
        f(QCircleSkinHelper.getInstance().getUrl("qvideo_rocket_pochan_bg_card"), 264, 400, imageView);
        f(QCircleSkinHelper.getInstance().getUrl("qvideo_rocket_pochan_text_title"), 132, 32, imageView2);
        f(QCircleSkinHelper.getInstance().getUrl("qvideo_rocket_icon_pochan"), 56, 56, imageView3);
        f(QCircleSkinHelper.getInstance().getUrl("qvideo_rocket_pochan_bt"), 212, 32, this.f91847f);
        this.f91848h = (ImageView) inflate.findViewById(R.id.f41911ic);
        this.f91850m = (TextView) inflate.findViewById(R.id.f55572i_);
        this.C = (TextView) inflate.findViewById(R.id.f504425e);
        this.D = (TextView) inflate.findViewById(R.id.f504225c);
        this.f91847f.setOnClickListener(this);
        this.f91848h.setOnClickListener(this);
        d();
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setOutsideTouchable(false);
        setTouchable(true);
        setFocusable(false);
    }

    private void d() {
        FeedCloudMeta$PushBrokeToast feedCloudMeta$PushBrokeToast = this.f91849i;
        if (feedCloudMeta$PushBrokeToast == null) {
            return;
        }
        TextView textView = this.f91850m;
        if (textView != null) {
            textView.setText(feedCloudMeta$PushBrokeToast.title.get());
        }
        TextView textView2 = this.C;
        if (textView2 != null) {
            textView2.setText(String.valueOf(this.f91849i.give_rocket_num.get()));
            g(this.C);
        }
        TextView textView3 = this.D;
        if (textView3 != null) {
            textView3.setText(this.f91849i.content.get());
        }
    }

    private boolean e() {
        View view = this.f91846e;
        if (view == null || !(view.getContext() instanceof Activity) || ((Activity) this.f91846e.getContext()).isFinishing() || ((Activity) this.f91846e.getContext()).isDestroyed()) {
            return false;
        }
        return true;
    }

    private void f(String str, int i3, int i16, ImageView imageView) {
        Option loadingDrawableColor = Option.obtain().setUrl(str).setRequestWidth(ImmersiveUtils.dpToPx(i3)).setRequestHeight(ImmersiveUtils.dpToPx(i16)).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
    }

    private void g(TextView textView) {
        if (this.f91845d != null && textView != null) {
            textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, textView.getPaint().getTextSize(), this.f91845d.getResources().getColor(R.color.cki), this.f91845d.getResources().getColor(R.color.ckh), Shader.TileMode.CLAMP));
            textView.invalidate();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (isShowing() && e()) {
            super.dismiss();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(9, this.E, false));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(ASEngineTabStatusEvent.class);
        return arrayList;
    }

    public void h(View view) {
        this.f91846e = view;
        if (view == null) {
            return;
        }
        if (e() && view.getWindowToken() != null) {
            showAtLocation(this.f91846e, 17, 0, 0);
            SimpleEventBus.getInstance().registerReceiver(this);
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(9, this.E, true));
        }
        a(this.f91850m, QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_SHORTAGE_WINDOW);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f41911ic || id5 == R.id.f3630147) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            b((ASEngineTabStatusEvent) simpleBaseEvent);
        }
    }
}
