package com.tencent.qqmini.minigame.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import ku3.d;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FloatGameView extends RelativeLayout {
    private MiniAppInfo C;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f346870d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f346871e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f346872f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f346873h;

    /* renamed from: i, reason: collision with root package name */
    private c f346874i;

    /* renamed from: m, reason: collision with root package name */
    private d f346875m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FloatGameView.this.C != null && FloatGameView.this.f346875m != null && FloatGameView.this.f346875m.f413064a != null) {
                SDKMiniProgramLpReportDC04239.reportAsync(FloatGameView.this.f346875m.f413064a, 2115, "page_view", "em_click", "minigame_inner_floating", FloatGameView.this.f346875m.f413067d, FloatGameView.this.C.appId, "");
            }
            if (FloatGameView.this.f346874i != null) {
                FloatGameView.this.f346874i.onClose();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f346877d;

        b(Activity activity) {
            this.f346877d = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FloatGameView.this.f346875m != null && FloatGameView.this.f346875m.f413064a != null && FloatGameView.this.C != null) {
                SDKMiniProgramLpReportDC04239.reportAsync(FloatGameView.this.f346875m.f413064a, 2115, "page_view", "pg_click", "minigame_inner_floating", FloatGameView.this.f346875m.f413067d, FloatGameView.this.C.appId, "");
                FloatGameView.this.f346875m.f413064a.launchParam.scene = 2115;
                MiniAppLauncher.launchMiniApp(this.f346877d, FloatGameView.this.f346875m.f413064a, (Bundle) null, (ResultReceiver) null);
                QMLog.d("FloatGameView", "[updateInfo] start miniApp by appInfo.");
            } else {
                QMLog.e("FloatGameView", "[updateInfo] info is null, return.");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface c {
        void onClose();
    }

    public FloatGameView(Context context) {
        super(context);
        d(context);
    }

    private void d(Context context) {
        View.inflate(context, R.layout.mini_sdk_float_game_view, this);
        this.f346871e = (ImageView) findViewById(R.id.iv_close);
        this.f346873h = (TextView) findViewById(R.id.tv_game_name);
        this.f346870d = (ImageView) findViewById(R.id.iv_game_icon);
        this.f346872f = (RelativeLayout) findViewById(R.id.rl_container);
        this.f346871e.setOnClickListener(new a());
    }

    public void e(MiniAppInfo miniAppInfo, d dVar, Activity activity) {
        if (dVar != null && dVar.f413064a != null && miniAppInfo != null) {
            QMLog.i("FloatGameView", "[updateInfo] reportData:" + miniAppInfo.reportData);
            this.f346875m = dVar;
            this.C = miniAppInfo;
            SDKMiniProgramLpReportDC04239.reportAsync(dVar.f413064a, 2115, "page_view", "expo", "minigame_inner_floating", dVar.f413067d, miniAppInfo.appId, "");
            Drawable drawable = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(getContext(), dVar.f413064a.iconUrl, 0, 0, getContext().getResources().getDrawable(R.drawable.mini_sdk_game_box_icon));
            QMLog.i("FloatGameView", "[updateInfo] name " + dVar.f413064a.name + "url: " + dVar.f413064a.iconUrl);
            this.f346870d.setImageDrawable(drawable);
            this.f346873h.setText(dVar.f413064a.name);
            this.f346872f.setOnClickListener(new b(activity));
        }
    }

    public void setOnCloseListener(c cVar) {
        this.f346874i = cVar;
    }
}
