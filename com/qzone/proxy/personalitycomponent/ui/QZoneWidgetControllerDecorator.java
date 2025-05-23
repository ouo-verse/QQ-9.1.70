package com.qzone.proxy.personalitycomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qzone.common.event.EventCenter;
import com.qzone.module.personalitycomponent.coverWidget.b;
import com.qzone.proxy.personalitycomponent.PersonalityComponentProxy;
import com.qzone.util.ar;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import f6.a;
import fo.c;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneWidgetControllerDecorator extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private b f50992d;

    /* renamed from: e, reason: collision with root package name */
    View.OnClickListener f50993e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable.Callback f50994f;

    public QZoneWidgetControllerDecorator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50992d = null;
        this.f50993e = new View.OnClickListener() { // from class: com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (QZoneWidgetControllerDecorator.this.f50992d == null || !QZoneWidgetControllerDecorator.this.f50992d.j()) {
                    if (QZoneWidgetControllerDecorator.this.f50992d != null) {
                        QZoneWidgetControllerDecorator.this.f50992d.c().onClick(view);
                    }
                } else {
                    EventCenter.getInstance().post("Lbs", 6);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.f50994f = new Drawable.Callback() { // from class: com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator.2
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                QZoneWidgetControllerDecorator.this.invalidate();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
                QZoneWidgetControllerDecorator.this.scheduleDrawable(drawable, runnable, j3);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                QZoneWidgetControllerDecorator.this.unscheduleDrawable(drawable, runnable);
            }
        };
    }

    private int b(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i3, size) : i3;
    }

    public void clearNextRefresh() {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public b getWidgetBase() {
        return this.f50992d;
    }

    public int getWidgetType() {
        b bVar = this.f50992d;
        if (bVar != null) {
            return bVar.g();
        }
        return -1;
    }

    public void init(Context context, Handler handler, int i3) {
        this.f50992d = PersonalityComponentProxy.f50957g.getUiInterface().getWidgetController(context, handler, i3);
        setOnClickListener(this.f50993e);
        a.c(this);
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.v(this.f50994f);
        }
        c(i3);
    }

    public boolean isInitiated() {
        return this.f50992d != null;
    }

    public void onDestory() {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.k();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.q();
            this.f50992d.v(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.l(canvas);
        }
    }

    public void onLbsPermissionFail(String str) {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.m(str);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        int b16;
        int b17;
        b bVar = this.f50992d;
        if (bVar != null) {
            b16 = bVar.i(i3);
            b17 = this.f50992d.h(i16);
            setContentDescription(this.f50992d.b());
        } else {
            b16 = b(ar.d(72.0f), i3);
            b17 = b(ar.d(22.0f), i16);
        }
        setMeasuredDimension(b16, b17);
    }

    public void onPause() {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.n();
        }
    }

    public void onResume() {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.p();
        }
    }

    public void refresh() {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.s();
        }
    }

    public void refreshFailed(String str) {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.o();
        }
        requestLayout();
        QZLog.e(AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "refresh widget fail " + str);
    }

    public void setNextRefresh() {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.u();
        }
        requestLayout();
    }

    public void update(Object obj) {
        b bVar = this.f50992d;
        if (bVar != null) {
            bVar.w(obj);
        }
        requestLayout();
    }

    public void hide() {
        setVisibility(4);
    }

    public void show() {
        setVisibility(0);
    }

    public QZoneWidgetControllerDecorator(Context context) {
        super(context);
        this.f50992d = null;
        this.f50993e = new View.OnClickListener() { // from class: com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (QZoneWidgetControllerDecorator.this.f50992d == null || !QZoneWidgetControllerDecorator.this.f50992d.j()) {
                    if (QZoneWidgetControllerDecorator.this.f50992d != null) {
                        QZoneWidgetControllerDecorator.this.f50992d.c().onClick(view);
                    }
                } else {
                    EventCenter.getInstance().post("Lbs", 6);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.f50994f = new Drawable.Callback() { // from class: com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator.2
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                QZoneWidgetControllerDecorator.this.invalidate();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
                QZoneWidgetControllerDecorator.this.scheduleDrawable(drawable, runnable, j3);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                QZoneWidgetControllerDecorator.this.unscheduleDrawable(drawable, runnable);
            }
        };
    }

    private void c(int i3) {
        if (i3 == 4 || i3 == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("pendant_type", Integer.valueOf(i3 == 4 ? 2 : 1));
            c.g("em_qz_pendant", "pg_bas_social_updates", this, hashMap);
        }
    }

    public QZoneWidgetControllerDecorator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f50992d = null;
        this.f50993e = new View.OnClickListener() { // from class: com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (QZoneWidgetControllerDecorator.this.f50992d == null || !QZoneWidgetControllerDecorator.this.f50992d.j()) {
                    if (QZoneWidgetControllerDecorator.this.f50992d != null) {
                        QZoneWidgetControllerDecorator.this.f50992d.c().onClick(view);
                    }
                } else {
                    EventCenter.getInstance().post("Lbs", 6);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.f50994f = new Drawable.Callback() { // from class: com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator.2
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                QZoneWidgetControllerDecorator.this.invalidate();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
                QZoneWidgetControllerDecorator.this.scheduleDrawable(drawable, runnable, j3);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                QZoneWidgetControllerDecorator.this.unscheduleDrawable(drawable, runnable);
            }
        };
    }
}
