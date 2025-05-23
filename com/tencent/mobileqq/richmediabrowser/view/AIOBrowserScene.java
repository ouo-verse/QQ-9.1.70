package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c04.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.d;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.subtitle.itemview.SubtitleItemView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.HashMap;
import vm2.i;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOBrowserScene extends MainBrowserScene {

    /* renamed from: d, reason: collision with root package name */
    private AIOBrowserPresenter f281942d;

    /* renamed from: e, reason: collision with root package name */
    public TextureView f281943e;

    /* renamed from: f, reason: collision with root package name */
    public SubtitleItemView f281944f;

    /* renamed from: h, reason: collision with root package name */
    private View f281945h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f281946i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            i.f441880a.c(((MainBrowserScene) AIOBrowserScene.this).mContext, view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AIOBrowserScene(Context context, AIOBrowserPresenter aIOBrowserPresenter) {
        super(context, aIOBrowserPresenter);
        ((MainBrowserScene) this).mContext = context;
        this.f281942d = aIOBrowserPresenter;
    }

    private void o(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("data_changed_error", str);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "richmediaBrowserDataChanged", true, 0L, 0L, hashMap, "");
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.BrowserBaseScene
    public boolean back() {
        u(false);
        v(false);
        return super.back();
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.BrowserBaseScene
    public void buildComplete() {
        super.buildComplete();
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.BrowserBaseScene
    public void buildParams(Intent intent) {
        super.buildParams(intent);
        this.f281946i = new Handler(Looper.getMainLooper());
    }

    public void c() {
        Handler handler = this.f281946i;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene.3
                @Override // java.lang.Runnable
                public void run() {
                    AIOBrowserScene.this.u(true);
                }
            }, 1000L);
        }
    }

    public com.tencent.mobileqq.richmediabrowser.view.a i() {
        tm2.a aVar;
        RichMediaBrowserInfo selectedItem;
        RichMediaBaseData richMediaBaseData;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281942d;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null && (selectedItem = aVar.getSelectedItem()) != null && (richMediaBaseData = selectedItem.baseData) != null) {
            b decoratorPresenter = this.f281942d.getDecoratorPresenter(richMediaBaseData.getType());
            if (decoratorPresenter instanceof com.tencent.mobileqq.richmediabrowser.presenter.a) {
                return ((com.tencent.mobileqq.richmediabrowser.presenter.a) decoratorPresenter).f281860f;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene
    public void initView() {
        super.initView();
        this.mDragView.setOriginRect(h.a().d());
        this.f281945h = LayoutInflater.from(((MainBrowserScene) this).mContext).inflate(R.layout.hnj, (ViewGroup) null);
        if (d.i()) {
            this.f281943e = (TextureView) this.f281945h.findViewById(R.id.a3x);
        }
        getContentView().addView(this.f281945h);
    }

    public void j() {
        if (this.f281944f != null) {
            return;
        }
        SubtitleItemView subtitleItemView = new SubtitleItemView(((MainBrowserScene) this).mContext);
        this.f281944f = subtitleItemView;
        subtitleItemView.setOnClickListener(new a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(12, -1);
        layoutParams.bottomMargin = ViewUtils.dpToPx(160.0f);
        getContentView().addView(this.f281944f, layoutParams);
    }

    public boolean m() {
        TextureView textureView = this.f281943e;
        if (textureView == null || textureView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void n(int i3, int i16, Intent intent) {
        com.tencent.mobileqq.richmediabrowser.view.a i17;
        if (i3 == 19002) {
            Context context = ((MainBrowserScene) this).mContext;
            if (context instanceof Activity) {
                if (i16 == -1) {
                    ((Activity) context).setResult(-1, intent);
                }
                ((Activity) ((MainBrowserScene) this).mContext).finish();
                return;
            }
        }
        if (i3 != 19000) {
            if (i3 == 19005) {
                if (i16 == -1 && (i17 = i()) != null) {
                    i17.k();
                    return;
                }
                return;
            }
            if (i3 != 103) {
                if (i16 == -1 && i3 == 0 && (((MainBrowserScene) this).mContext instanceof Activity)) {
                    ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).startChatAndSendMsg((Activity) ((MainBrowserScene) this).mContext, intent.getExtras());
                    if (h.a().f() == 9501) {
                        ((Activity) ((MainBrowserScene) this).mContext).finish();
                        return;
                    }
                    return;
                }
                if (i16 == -1 && i3 == 10001) {
                    QQToast.makeText(((MainBrowserScene) this).mContext, R.string.f221906c3, 0).show();
                }
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.BrowserBaseScene
    public boolean needEnterRectAnimation() {
        return true;
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.BrowserBaseScene
    public boolean needExitRectAnimation() {
        return true;
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene
    public void notifyDataSetChanged() {
        try {
            super.notifyDataSetChanged();
        } catch (Exception e16) {
            o("AIOBrowserScene");
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserScene", 4, "notifyDataSetChanged exception = " + e16.getMessage());
        }
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onContentMove(float f16) {
        super.onContentMove(f16);
        AIOBrowserPresenter aIOBrowserPresenter = this.f281942d;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.B(false);
        }
        com.tencent.mobileqq.richmediabrowser.view.a i3 = i();
        if (i3 != null) {
            i3.D(false);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public void onCreate() {
        super.onCreate();
        this.mRoot.setVisibility(4);
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.BrowserBaseScene
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f281946i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f281946i = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGestureFinish() {
        String str;
        String str2;
        RichMediaBaseData richMediaBaseData;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281942d;
        if (aIOBrowserPresenter != null) {
            RichMediaBrowserInfo selectedItem = aIOBrowserPresenter.f281850e.getSelectedItem();
            if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null) {
                if (richMediaBaseData.getType() == 100) {
                    str = "0X8009AB2";
                } else if (selectedItem.baseData.getType() == 101) {
                    str = "0X8009AB3";
                }
                str2 = str;
                if (!TextUtils.isEmpty(str2)) {
                    ReportController.o(null, "dc00898", "", "", str2, str2, h.a().c(), 0, "", "", "", "");
                }
                this.f281942d.J();
            }
            str = null;
            str2 = str;
            if (!TextUtils.isEmpty(str2)) {
            }
            this.f281942d.J();
        }
        super.onGestureFinish();
    }

    @Override // com.tencent.richmediabrowser.view.MainBrowserScene, com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onResetPosition() {
        if (h.a().c() == 4) {
            return;
        }
        super.onResetPosition();
        AIOBrowserPresenter aIOBrowserPresenter = this.f281942d;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.W();
        }
        com.tencent.mobileqq.richmediabrowser.view.a i3 = i();
        if (i3 != null) {
            i3.D(true);
        }
    }

    public void t(final String str) {
        SubtitleItemView subtitleItemView = this.f281944f;
        if (subtitleItemView == null) {
            return;
        }
        subtitleItemView.post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene.1
            @Override // java.lang.Runnable
            public void run() {
                AIOBrowserScene.this.f281944f.setVideoSubtitleContent(str);
            }
        });
    }

    public void v(boolean z16) {
        SubtitleItemView subtitleItemView = this.f281944f;
        if (subtitleItemView != null) {
            subtitleItemView.d(z16);
        }
    }

    public void w() {
        SubtitleItemView subtitleItemView = this.f281944f;
        if (subtitleItemView != null) {
            subtitleItemView.e();
        }
    }

    public void x() {
        SubtitleItemView subtitleItemView = this.f281944f;
        if (subtitleItemView != null) {
            subtitleItemView.f();
        }
    }

    public void u(boolean z16) {
    }
}
