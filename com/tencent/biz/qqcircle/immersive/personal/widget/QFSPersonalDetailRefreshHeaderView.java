package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class QFSPersonalDetailRefreshHeaderView extends LinearLayout implements IRefreshViewProvider, View.OnClickListener {
    private int C;
    private w D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private final int f89232d;

    /* renamed from: e, reason: collision with root package name */
    private int f89233e;

    /* renamed from: f, reason: collision with root package name */
    private RefreshHeaderView f89234f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f89235h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f89236i;

    /* renamed from: m, reason: collision with root package name */
    private View f89237m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements RefreshHeaderView.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView.b
        public void onChange(int i3) {
            QFSPersonalDetailRefreshHeaderView.this.f(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPersonalDetailRefreshHeaderView> f89239d;

        public b(QFSPersonalDetailRefreshHeaderView qFSPersonalDetailRefreshHeaderView) {
            this.f89239d = new WeakReference<>(qFSPersonalDetailRefreshHeaderView);
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            WeakReference<QFSPersonalDetailRefreshHeaderView> weakReference = this.f89239d;
            if (weakReference != null && weakReference.get() != null) {
                if (loadState == LoadState.STATE_SUCCESS) {
                    this.f89239d.get().i();
                    return;
                }
                return;
            }
            QLog.e("QFSPersonalDetailRefreshHeaderView", 1, "[onStateChange] viewWeakReference == null");
        }
    }

    public QFSPersonalDetailRefreshHeaderView(Context context) {
        super(context);
        this.f89232d = (int) (getResources().getDimension(R.dimen.d3q) + getResources().getDimension(R.dimen.d3r));
        c();
    }

    private void c() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 1);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.f168724gl4, (ViewGroup) null, false);
        this.f89235h = frameLayout;
        addView(frameLayout, new LinearLayout.LayoutParams(-1, this.f89232d));
        this.f89234f = (RefreshHeaderView) findViewById(R.id.yqc);
        ImageView imageView = (ImageView) findViewById(R.id.y48);
        this.f89236i = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalDetailRefreshHeaderView.this.onClick(view);
            }
        });
        this.f89237m = findViewById(R.id.f11878753);
        this.C = getContext().getResources().getColor(R.color.bd9);
        measure(-2, -2);
        this.f89234f.setHeightListener(new a());
        int screenHeight = (ImmersiveUtils.getScreenHeight() / 2) - this.f89232d;
        this.f89233e = screenHeight;
        this.f89234f.setMaxHeight(screenHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3) {
        h(i3 + this.f89232d);
    }

    private void g(int i3) {
        if (i3 == this.f89232d) {
            this.f89237m.setVisibility(8);
            return;
        }
        int i16 = 0;
        this.f89237m.setVisibility(0);
        int i17 = this.f89232d;
        int i18 = (int) ((((i3 - i17) * 1.0f) / (this.f89233e - i17)) * 255.0f);
        if (i18 > 255) {
            i16 = 255;
        } else if (i18 < 0) {
            this.f89237m.setVisibility(8);
        } else {
            i16 = i18;
        }
        this.f89237m.setBackgroundColor(Color.argb(i16, Color.red(this.C), Color.green(this.C), Color.blue(this.C)));
        if (i16 >= Color.alpha(this.C)) {
            this.f89237m.setBackgroundColor(this.C);
        }
    }

    private void h(int i3) {
        FrameLayout frameLayout = this.f89235h;
        if (frameLayout == null) {
            return;
        }
        int i16 = this.f89232d;
        if (i3 < i16) {
            i3 = i16;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        if (layoutParams.height == i3) {
            return;
        }
        layoutParams.height = i3;
        this.f89235h.setLayoutParams(layoutParams);
        g(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Context hostContext = ASEngineUtils.getHostContext(getContext());
        if (!(hostContext instanceof Activity)) {
            QLog.e("QFSPersonalDetailRefreshHeaderView", 1, "[updateStatusBarColor] is not activity");
        } else {
            QUIImmersiveHelper.s((Activity) hostContext, true, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(RecyclerView recyclerView) {
        this.f89234f.callRefresh(recyclerView);
    }

    public void d(w wVar) {
        if (wVar != null && wVar.e() != null) {
            this.D = wVar;
            String str = wVar.e().header_info.img.picUrl.get();
            if (TextUtils.isEmpty(str)) {
                str = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8895/profilepage_background/skin_profilepage_background_default.jpg";
            }
            if (TextUtils.equals(str, this.E)) {
                return;
            }
            this.E = str;
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(this.f89236i.getLayoutParams().width).setRequestHeight(this.f89236i.getLayoutParams().height).setLoadingDrawableColor(0).setUrl(QCircleSkinHelper.getInstance().getUrl(str)).setTargetView(this.f89236i), new b(this));
            e();
        }
    }

    public void e() {
        VideoReport.setElementId(this.f89236i, QCircleDaTongConstant.ElementId.EM_XSJ_BACKGROUND_PICTURE);
        VideoReport.setElementParams(this.f89236i, new QCircleDTParamBuilder().buildElementParams());
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent motionEvent) {
        if (getWindowVisibility() != 0) {
            return;
        }
        if (cx.i(this.f89236i, false, true) && this.f89234f.e() == 0) {
            return;
        }
        this.f89234f.handleRefreshGesture(motionEvent);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    /* renamed from: isRefresh */
    public boolean getIsRefreshing() {
        return this.f89234f.getIsRefreshing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void onDestroy() {
        this.f89234f.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener onRefreshListener) {
        this.f89234f.setOnRefreshListener(onRefreshListener);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean z16) {
        this.f89234f.setRefreshing(z16);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int i3) {
        this.f89234f.setState(i3);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }
}
