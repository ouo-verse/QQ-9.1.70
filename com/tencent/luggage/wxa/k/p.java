package com.tencent.luggage.wxa.k;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public long f131353a = -1;

    /* renamed from: b, reason: collision with root package name */
    public float f131354b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    public int f131355c = 0;

    /* renamed from: d, reason: collision with root package name */
    public a f131356d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(float f16, float f17);

        void b();

        void c();
    }

    public void a(a aVar) {
        this.f131356d = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 5) {
                        if (action == 6) {
                            Log.d("MicroMsg.SRVTListener", "ACTION_POINTER_UP");
                            this.f131355c--;
                        }
                    } else {
                        Log.d("MicroMsg.SRVTListener", "ACTION_POINTER_DOWN");
                        this.f131355c++;
                    }
                } else if (this.f131355c >= 2) {
                    float a16 = a(motionEvent);
                    Log.v("MicroMsg.SRVTListener", "distance: " + a16);
                    if (a16 > 0.0f) {
                        float f16 = this.f131354b;
                        if (f16 <= 0.0f) {
                            this.f131354b = a16;
                        } else if (Math.abs(a16 - f16) > 15.0f) {
                            if (a16 > this.f131354b) {
                                Log.d("MicroMsg.SRVTListener", "zoom out");
                                a aVar = this.f131356d;
                                if (aVar != null) {
                                    aVar.c();
                                }
                            } else {
                                Log.d("MicroMsg.SRVTListener", "zoom in");
                                a aVar2 = this.f131356d;
                                if (aVar2 != null) {
                                    aVar2.a();
                                }
                            }
                            this.f131354b = a16;
                        }
                    }
                }
            } else {
                Log.d("MicroMsg.SRVTListener", "ACTION_UP");
                this.f131354b = -1.0f;
                this.f131355c = 0;
            }
        } else {
            Log.d("MicroMsg.SRVTListener", "ACTION_DOWN");
            if (this.f131353a > 0 && SystemClock.elapsedRealtime() - this.f131353a < 400) {
                a aVar3 = this.f131356d;
                if (aVar3 != null) {
                    aVar3.b();
                }
            } else {
                a aVar4 = this.f131356d;
                if (aVar4 != null) {
                    aVar4.a(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f131353a = SystemClock.elapsedRealtime();
            this.f131354b = -1.0f;
            this.f131355c++;
        }
        return true;
    }

    public final float a(MotionEvent motionEvent) {
        try {
            if (this.f131355c < 2) {
                return 0.0f;
            }
            return Math.abs(motionEvent.getX(0) - motionEvent.getX(1)) + Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
        } catch (Exception e16) {
            Log.e("MicroMsg.SRVTListener", "pointerDistance error: " + e16.getMessage());
            return 0.0f;
        }
    }
}
