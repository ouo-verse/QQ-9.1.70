package com.tencent.mobileqq.troopgift;

import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.am;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGiftActionButton extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f302746d;

    /* renamed from: e, reason: collision with root package name */
    protected Handler f302747e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f302748f;

    /* renamed from: h, reason: collision with root package name */
    protected AnimationDrawable f302749h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftActionButton$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f302750d;
        final /* synthetic */ TroopGiftActionButton this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TroopGiftActionButton troopGiftActionButton = this.this$0;
            if (troopGiftActionButton.f302749h == null) {
                troopGiftActionButton.f302749h = new AnimationDrawable();
                for (int i3 = 0; i3 < 7; i3++) {
                    try {
                        this.this$0.f302749h.addFrame(new BitmapDrawable(BitmapFactory.decodeFile(String.format("%sInteractGiftButton/image_0%d.png", am.g(this.f302750d), Integer.valueOf(i3)))), 50);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                TroopGiftActionButton troopGiftActionButton2 = this.this$0;
                troopGiftActionButton2.f302748f.setImageDrawable(troopGiftActionButton2.f302749h);
                this.this$0.f302749h.setOneShot(true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                TroopGiftActionButton troopGiftActionButton3 = this.this$0;
                troopGiftActionButton3.addView(troopGiftActionButton3.f302748f, layoutParams);
            }
            this.this$0.f302749h.start();
            this.this$0.f302748f.setVisibility(0);
            this.this$0.f302747e.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troopgift.TroopGiftActionButton.2.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AnonymousClass2.this.this$0.f302748f.setVisibility(8);
                    }
                }
            }, 350L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private class a extends View {
        static IPatchRedirector $redirector_;

        public void a(int i3) {
            throw null;
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f302746d.a(i3);
        }
    }
}
