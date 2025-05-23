package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CarrierADView extends ADView implements Handler.Callback {
    private com.tencent.mobileqq.dating.g I;
    private MotionEvent J;
    private MqqHandler K;

    public CarrierADView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.widget.ADView
    public void c() {
        MqqHandler mqqHandler = this.K;
        if (mqqHandler != null) {
            mqqHandler.removeMessages(0);
            this.K.sendEmptyMessageDelayed(0, 3000L);
        }
    }

    @Override // com.tencent.mobileqq.widget.ADView
    public void d() {
        MqqHandler mqqHandler = this.K;
        if (mqqHandler != null) {
            mqqHandler.sendEmptyMessage(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                this.K.removeMessages(0);
            }
        } else {
            WorkSpaceView workSpaceView = this.f315352i;
            if (workSpaceView == null) {
                return false;
            }
            if (workSpaceView.getChildCount() > 1 && this.f315352i.getWidth() > 0) {
                WorkSpaceView workSpaceView2 = this.f315352i;
                workSpaceView2.e(workSpaceView2.b() + 1);
            }
            this.K.sendEmptyMessageDelayed(0, 3400);
        }
        return false;
    }

    public void l(View view, int i3) {
        if (this.f315350f.getChildCount() == 0) {
            this.f315350f.setPadding(0, 0, 0, 0);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f315352i = new WorkSpaceView(getContext());
            setCircle(this.G);
            this.f315352i.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.f315352i.setId(100000);
            relativeLayout.addView(this.f315352i, layoutParams);
            this.f315350f.addView(relativeLayout, new LinearLayout.LayoutParams(-1, -1));
        } else {
            this.f315352i = (WorkSpaceView) ((ViewGroup) this.f315350f.getChildAt(0)).getChildAt(0);
        }
        try {
            WorkSpaceView workSpaceView = this.f315352i;
            workSpaceView.addView(view, workSpaceView.getChildCount());
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.widget.ADView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.I != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.I.enableFlingRight(false);
                d();
                MotionEvent motionEvent2 = this.J;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.J = MotionEvent.obtain(motionEvent);
            } else if (action == 2) {
                MotionEvent motionEvent3 = this.J;
                if (motionEvent3 != null) {
                    if (Math.abs((this.J.getY() - motionEvent.getY()) / (motionEvent3.getX() - motionEvent.getX())) < 0.5f) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
                this.J = MotionEvent.obtain(motionEvent);
            } else if (action == 1 || action == 3) {
                this.I.enableFlingRight(true);
                c();
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    public void setCarrierData(List<AdData> list, int i3, com.tencent.mobileqq.dating.a aVar) {
        int i16;
        if (this.K == null) {
            this.K = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
        i();
        if (list != null && list.size() != 0) {
            while (true) {
                int i17 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                list.add(list.get(0));
                list.remove(0);
                i3 = i17;
            }
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            for (i16 = 0; i16 < list.size(); i16++) {
                try {
                    View inflate = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.awo, (ViewGroup) null);
                    aVar.e(inflate, list.get(i16));
                    l(inflate, i16);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CarrierADView", 2, e16.toString());
                    }
                }
            }
            c();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CarrierADView", 2, "carrier List is null or empty");
        }
        setVisibility(8);
    }

    public void setFlingSwitch(com.tencent.mobileqq.dating.g gVar) {
        this.I = gVar;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != 8 && i3 != 4) {
            c();
        } else {
            d();
        }
        WorkSpaceView workSpaceView = this.f315352i;
        if (workSpaceView != null) {
            workSpaceView.setVisibility(i3);
        }
        super.setVisibility(i3);
    }

    public CarrierADView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
