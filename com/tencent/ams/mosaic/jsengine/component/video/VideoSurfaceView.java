package com.tencent.ams.mosaic.jsengine.component.video;

import android.content.Context;
import android.os.Build;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoSurfaceView extends SurfaceView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f71383d;

    /* renamed from: e, reason: collision with root package name */
    private int f71384e;

    /* renamed from: f, reason: collision with root package name */
    private int f71385f;

    /* renamed from: h, reason: collision with root package name */
    private int f71386h;

    /* renamed from: i, reason: collision with root package name */
    private int f71387i;

    public VideoSurfaceView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f71383d = "fitXY";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(FrameLayout.LayoutParams layoutParams) {
        setLayoutParams(layoutParams);
    }

    private void c() {
        d(this.f71386h, this.f71387i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c4, code lost:
    
        if (r7.f71383d.equals("centerCrop") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
    
        if (r7.f71383d.equals("centerCrop") != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == 0) {
            i3 = getWidth();
        }
        if (i16 == 0) {
            i16 = getHeight();
        }
        if (i3 > 0 && i16 > 0 && this.f71384e > 0 && this.f71385f > 0) {
            this.f71386h = i3;
            this.f71387i = i16;
            com.tencent.ams.mosaic.utils.f.a("VideoSurfaceView", "refreshLayout surfaceWidth:" + i3 + ", surfaceHeight:" + i16 + ", mVideoWidth:" + this.f71384e + ", mVideoHeight:" + this.f71385f);
            float f16 = (float) i3;
            float f17 = (float) i16;
            Math.max(((float) this.f71384e) / f16, ((float) this.f71385f) / f17);
            float f18 = ((float) this.f71384e) / ((float) this.f71385f);
            float f19 = f16 / f17;
            com.tencent.ams.mosaic.utils.f.e("VideoSurfaceView", "refreshLayout videoRatio:" + f18 + ", surfaceRatio:" + f19);
            if (f18 > f19) {
                if (!this.f71383d.equals("fitCenter")) {
                }
                i16 = (int) (f16 / f18);
            } else if (f18 < f19) {
                if (!this.f71383d.equals("fitCenter")) {
                }
                i3 = (int) (f17 * f18);
            }
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
            layoutParams.gravity = 17;
            post(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.r
                @Override // java.lang.Runnable
                public final void run() {
                    VideoSurfaceView.this.b(layoutParams);
                }
            });
        }
    }

    @Override // android.view.View
    public void setKeepScreenOn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else if (Build.VERSION.SDK_INT >= 26) {
            super.setKeepScreenOn(z16);
        }
    }

    public void setScaleType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else if (str != null && !str.equals(this.f71383d)) {
            this.f71383d = str;
            c();
        }
    }

    public void setVideoSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f71384e = i3;
        this.f71385f = i16;
        c();
    }
}
