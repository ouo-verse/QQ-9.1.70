package com.tencent.mobileqq.vas;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class au extends ReportDialog {
    private static int F = 150;
    private static int G = 56;
    ImageView C;
    b D;
    View.OnClickListener E;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.h7s) {
                au.this.dismiss();
            } else if (id5 == R.id.h7q) {
                b bVar = au.this.D;
                if (bVar != null) {
                    bVar.onLeftClick();
                }
                au.this.dismiss();
            } else if (id5 == R.id.h7r) {
                b bVar2 = au.this.D;
                if (bVar2 != null) {
                    bVar2.onRightClick();
                }
                au.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onLeftClick();

        void onRightClick();
    }

    public au(Context context) {
        super(context, R.style.f173448dl);
        this.E = new a();
    }

    public void N(b bVar) {
        this.D = bVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bf5);
        findViewById(R.id.h7q).setOnClickListener(this.E);
        findViewById(R.id.h7r).setOnClickListener(this.E);
        findViewById(R.id.h7s).setOnClickListener(this.E);
        this.C = (ImageView) findViewById(R.id.h7t);
        ColorDrawable colorDrawable = new ColorDrawable(15856629);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        float f16 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
        obtain.mRequestWidth = (int) (r1.getDisplayMetrics().widthPixels - (G * f16));
        obtain.mRequestHeight = (int) (f16 * F);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        this.C.setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/like/app/zanDoubleConfig/single.png", obtain));
    }
}
