package com.tencent.qqnt.aio.gallery.progress;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes23.dex */
public class FakeProgressSeekBar extends SeekBar {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f350141d;

    /* renamed from: e, reason: collision with root package name */
    private int f350142e;

    /* renamed from: f, reason: collision with root package name */
    private int f350143f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f350144h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f350145i;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f350146m;

    public FakeProgressSeekBar(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void g() {
        this.f350141d = 0;
        this.f350142e = 2;
        this.f350143f = 16;
        this.f350144h = false;
        this.f350145i = new Handler(Looper.getMainLooper());
    }

    public void setTargetProgress(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f350141d = i3;
        this.f350142e = i17;
        this.f350143f = i16;
        this.f350145i.removeCallbacks(this.f350146m);
        this.f350145i.postDelayed(this.f350146m, this.f350143f);
    }

    public FakeProgressSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FakeProgressSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f350146m = new Runnable() { // from class: com.tencent.qqnt.aio.gallery.progress.FakeProgressSeekBar.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FakeProgressSeekBar.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (FakeProgressSeekBar.this.getProgress() < FakeProgressSeekBar.this.f350141d) {
                        FakeProgressSeekBar fakeProgressSeekBar = FakeProgressSeekBar.this;
                        fakeProgressSeekBar.setProgress(Math.min(fakeProgressSeekBar.getMax(), FakeProgressSeekBar.this.getProgress() + FakeProgressSeekBar.this.f350142e));
                        FakeProgressSeekBar.this.f350145i.postDelayed(FakeProgressSeekBar.this.f350146m, FakeProgressSeekBar.this.f350143f);
                    } else if (FakeProgressSeekBar.this.getProgress() > FakeProgressSeekBar.this.f350141d && FakeProgressSeekBar.this.f350144h) {
                        FakeProgressSeekBar fakeProgressSeekBar2 = FakeProgressSeekBar.this;
                        fakeProgressSeekBar2.setProgress(Math.min(fakeProgressSeekBar2.f350141d, FakeProgressSeekBar.this.getProgress() - FakeProgressSeekBar.this.f350142e));
                        FakeProgressSeekBar.this.f350145i.postDelayed(FakeProgressSeekBar.this.f350146m, FakeProgressSeekBar.this.f350143f);
                    }
                }
            };
            g();
        }
    }
}
