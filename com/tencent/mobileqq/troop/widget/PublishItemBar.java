package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes19.dex */
public class PublishItemBar extends LinearLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private Handler C;

    /* renamed from: d, reason: collision with root package name */
    private boolean f302366d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f302367e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f302368f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f302369h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f302370i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f302371m;

    public PublishItemBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302366d = false;
        this.f302367e = false;
        this.f302368f = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag != null && this.f302369h != null) {
                int intValue = ((Integer) tag).intValue();
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue != 4) {
                                if (intValue == 5) {
                                    this.f302369h.sendEmptyMessage(5);
                                }
                            } else {
                                this.f302369h.sendEmptyMessage(4);
                                Handler handler = this.f302371m;
                                if (handler != null) {
                                    handler.sendEmptyMessage(4);
                                }
                            }
                        } else {
                            this.f302369h.sendEmptyMessage(3);
                            Handler handler2 = this.f302370i;
                            if (handler2 != null) {
                                handler2.sendEmptyMessage(3);
                            }
                        }
                    } else {
                        this.f302369h.sendEmptyMessage(2);
                        Handler handler3 = this.C;
                        if (handler3 != null) {
                            handler3.sendEmptyMessage(2);
                        }
                    }
                } else {
                    this.f302369h.sendEmptyMessage(1);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setAudioCallback(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) handler);
        } else {
            this.C = handler;
        }
    }

    public void setAudioEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            childAt.setEnabled(z16);
            if (childAt instanceof ImageButton) {
                if (z16) {
                    ((ImageButton) childAt).setImageResource(R.drawable.e4b);
                } else {
                    ((ImageButton) childAt).setImageResource(R.drawable.e4a);
                }
            }
        }
    }

    public void setCallback(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) handler);
        } else {
            this.f302369h = handler;
        }
    }

    public void setMusicCallback(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) handler);
        } else {
            this.f302371m = handler;
        }
    }

    public void setVideoCallback(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) handler);
        } else {
            this.f302370i = handler;
        }
    }
}
