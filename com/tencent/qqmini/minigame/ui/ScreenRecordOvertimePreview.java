package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* loaded from: classes23.dex */
public class ScreenRecordOvertimePreview extends RelativeLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f346801d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f346802e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f346803f;

    /* renamed from: h, reason: collision with root package name */
    private a f346804h;

    /* loaded from: classes23.dex */
    public interface a {
        void b();

        void c();

        void d();
    }

    public ScreenRecordOvertimePreview(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_screen_recorder_preview_overtime, (ViewGroup) this, true);
        this.f346803f = (RelativeLayout) findViewById(R.id.rl_record_overtime_container);
        this.f346801d = (ImageView) findViewById(R.id.iv_snapshot);
        this.f346802e = (TextView) findViewById(R.id.tv_record_again);
        this.f346801d.setOnClickListener(this);
        this.f346802e.setOnClickListener(this);
        this.f346803f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.f346804h;
        if (aVar != null) {
            if (view == this.f346802e) {
                aVar.b();
            } else if (view == this.f346801d) {
                aVar.d();
            } else if (view == this.f346803f) {
                aVar.c();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setClickListener(a aVar) {
        this.f346804h = aVar;
    }

    public void setScreenSnapshot(Bitmap bitmap) {
        ImageView imageView;
        QMLog.i("ScreenRecordOvertimeView", "[setScreenSnapshot]");
        if (bitmap != null && !bitmap.isRecycled() && (imageView = this.f346801d) != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public ScreenRecordOvertimePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
