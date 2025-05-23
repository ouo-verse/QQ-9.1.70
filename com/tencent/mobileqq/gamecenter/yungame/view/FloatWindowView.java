package com.tencent.mobileqq.gamecenter.yungame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.gamecenter.yungame.YunGameManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FloatWindowView extends RemovableView {
    private ImageView G;
    private TextView H;
    private TextView I;
    private ImageView J;
    private GameInfo K;
    private Handler L;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            YunGameManager.F().W();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FloatWindowView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.gamecenter.yungame.view.RemovableView
    public void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.eal, this);
        this.G = (ImageView) findViewById(R.id.dvu);
        this.I = (TextView) findViewById(R.id.k75);
        this.H = (TextView) findViewById(R.id.f111486lc);
        this.J = (ImageView) findViewById(R.id.dum);
        this.L = new Handler(Looper.getMainLooper());
        this.J.setOnClickListener(new a());
    }

    public void f(final int i3, final int i16, int i17) {
        QLog.d("FloatWindowView", 1, "[onGameStatusChanged] status:" + i3 + ", index:" + i16);
        this.L.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.view.FloatWindowView.3
            @Override // java.lang.Runnable
            public void run() {
                int i18;
                QLog.d("FloatWindowView", 1, "[onGameStatusChanged] ui change status:" + i3 + ", index:" + i16);
                int i19 = i3;
                if (i19 == 2) {
                    FloatWindowView.this.H.setText("\u6392\u961f\u4e2d...");
                    int i26 = i16;
                    if (i26 * 16 > 60) {
                        i18 = (int) Math.ceil((i26 * 16.0d) / 60.0d);
                    } else {
                        i18 = 1;
                    }
                    FloatWindowView.this.I.setText(String.format("\u5f53\u524d%d\u540d,\u9884\u8ba1\u9700\u8981%d\u5206\u949f", Integer.valueOf(i16), Integer.valueOf(i18)));
                    return;
                }
                if (i19 == 0) {
                    FloatWindowView.this.H.setText("\u6392\u961f\u6210\u529f");
                    FloatWindowView.this.I.setText("\u7acb\u5373\u542f\u52a8\u6e38\u620f");
                } else {
                    FloatWindowView.this.H.setText("\u6392\u961f\u5931\u8d25");
                    FloatWindowView.this.I.setText("\u7f51\u7edc\u4e0d\u7a33\u5b9a");
                }
            }
        });
    }

    public void setGameInfo(final GameInfo gameInfo) {
        if (gameInfo == null) {
            QLog.d("FloatWindowView", 1, "[setGameInfo] gameInfo is null");
            return;
        }
        this.K = gameInfo;
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.jmc));
            QLog.d("FloatWindowView", 1, "[setGameInfo] iconUrl:" + gameInfo.getIconUrl());
            if (!TextUtils.isEmpty(gameInfo.getIconUrl())) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.view.FloatWindowView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final Bitmap h16 = com.tencent.mobileqq.gamecenter.yungame.a.h(gameInfo.getIconUrl());
                        if (h16 != null) {
                            FloatWindowView.this.L.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.view.FloatWindowView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    FloatWindowView.this.G.setImageBitmap(h16);
                                }
                            });
                        }
                    }
                }, 128, null, true);
            }
        }
    }

    public FloatWindowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatWindowView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
