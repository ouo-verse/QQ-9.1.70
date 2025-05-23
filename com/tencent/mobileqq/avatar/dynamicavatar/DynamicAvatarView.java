package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawableImpl;
import com.tencent.mobileqq.app.face.NearByFaceDrawable;
import com.tencent.mobileqq.app.face.h;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.proavatar.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.URLTextImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DynamicAvatarView extends URLTextImageView implements ThemeImageWrapper.DrawInterface {
    static IPatchRedirector $redirector_;
    public boolean C;
    public boolean D;
    public h E;
    public String F;
    public int G;
    public String H;
    private Runnable I;
    private VideoDrawable.OnPlayRepeatListener J;
    public ThemeImageWrapper K;
    private Path L;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements VideoDrawable.OnPlayRepeatListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarView.this);
            }
        }

        @Override // com.tencent.image.VideoDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int i3) {
            h hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "onPlayRepeat: " + i3);
            }
            DynamicAvatarView dynamicAvatarView = DynamicAvatarView.this;
            if (!dynamicAvatarView.D && i3 >= 1 && (hVar = dynamicAvatarView.E) != null) {
                URLDrawable uRLDrawable = hVar.f195575b;
                if (uRLDrawable instanceof URLDrawable) {
                    Drawable currDrawable = uRLDrawable.getCurrDrawable();
                    if (currDrawable instanceof VideoDrawable) {
                        ((VideoDrawable) currDrawable).removeOnPlayRepeatListener(this);
                        h hVar2 = DynamicAvatarView.this.E;
                        hVar2.f195591r.B(hVar2, true);
                        if (QLog.isColorLevel()) {
                            QLog.e(LogTag.TAG_DYNAMIC_AVATAR, 2, "removeOnPlayRepeatListener.03");
                        }
                    }
                }
                DynamicAvatarView dynamicAvatarView2 = DynamicAvatarView.this;
                dynamicAvatarView2.E.f195575b = null;
                dynamicAvatarView2.d();
            }
        }
    }

    public DynamicAvatarView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.I = new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DynamicAvatarView dynamicAvatarView = DynamicAvatarView.this;
                h hVar = dynamicAvatarView.E;
                if (hVar != null) {
                    dynamicAvatarView.setImageDrawable(hVar.a());
                }
            }
        };
        this.J = new a();
        this.L = new Path();
    }

    private void c(AppInterface appInterface, Drawable drawable, int i3, int i16, String str, boolean z16, int i17, boolean z17, boolean z18, boolean z19, boolean z26, int i18) {
        setFaceDrawable(appInterface, drawable, i3, i16, str, i17, z18, null, z16, z19, z26, z17, i18);
    }

    public void d() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.E != null && this.C) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setImageDrawable(this.E.a());
                return;
            } else {
                ThreadManager.getUIHandler().post(this.I);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateImageDrawable null == mDynamicFaceDrawable: ");
            if (this.E == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" isAttachToWindow: ");
            sb5.append(this.C);
            QLog.w(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        this.C = true;
        h hVar = this.E;
        if (hVar != null) {
            setImageDrawable(hVar.a());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Drawable drawable = getDrawable();
        if ((drawable instanceof URLDrawable) && (((URLDrawable) drawable).getCurrDrawable() instanceof VideoDrawable)) {
            h hVar = this.E;
            if (hVar != null) {
                hVar.f195591r.B(hVar, true);
            }
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_DYNAMIC_AVATAR, 2, "removeOnPlayRepeatListener.01");
            }
        }
        super.onDetachedFromWindow();
        removeCallbacks(this.I);
        this.C = false;
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) uRLDrawable, (Object) th5);
        } else {
            super.onLoadFialed(uRLDrawable, th5);
            QLog.e(LogTag.TAG_DYNAMIC_AVATAR, 1, "onLoadFailed", th5);
        }
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uRLDrawable);
            return;
        }
        super.onLoadSuccessed(uRLDrawable);
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (!this.D && this.C && VideoDrawable.class.isInstance(currDrawable)) {
            ((VideoDrawable) currDrawable).setOnPlayRepeatListener(this.J);
        }
        QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 1, "onLoadSuccessed, curDrawable " + currDrawable);
    }

    public void setFaceDrawable(AppInterface appInterface, Drawable drawable, int i3, int i16, String str, int i17, boolean z16, DynamicAvatar dynamicAvatar, boolean z17, boolean z18, boolean z19, boolean z26, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, drawable, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Boolean.valueOf(z16), dynamicAvatar, Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Integer.valueOf(i18));
            return;
        }
        this.G = i18;
        this.H = str;
        this.D = z16;
        h hVar = this.E;
        if (DynamicAvatarManager.l(i3, i16, str, i17).equals(hVar != null ? DynamicAvatarManager.k(hVar, false) : null)) {
            h hVar2 = this.E;
            if (hVar2 != null) {
                boolean f16 = hVar2.f();
                this.E.c(appInterface, drawable, i3, i16, str, i17, 3, z16, i18, z26, z19, z17, dynamicAvatar, true);
                this.E.b(z18, dynamicAvatar);
                if (!f16) {
                    setImageDrawable(this.E.a());
                }
            }
        } else {
            this.F = "";
            h hVar3 = this.E;
            if (hVar3 == null) {
                this.E = new h(appInterface, drawable, i3, i16, str, i17, z16, dynamicAvatar, z17, z18, z19, z26, i18);
            } else {
                hVar3.c(appInterface, drawable, i3, i16, str, i17, 3, z16, i18, z26, z19, z17, dynamicAvatar, false);
                this.E.b(z18, dynamicAvatar);
            }
            this.E.f195592s = new WeakReference<>(this);
            setImageDrawable(this.E.a());
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(LogTag.TAG_DYNAMIC_AVATAR, 2, "setFaceDrwable bitmapDrawable is: " + drawable + " id: " + str);
        }
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        boolean z16;
        boolean z17;
        VideoDrawable videoDrawable;
        boolean z18;
        boolean z19;
        VideoDrawable videoDrawable2;
        h hVar;
        boolean z26;
        boolean z27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) drawable);
            return;
        }
        Drawable drawable2 = getDrawable();
        if (drawable == drawable2) {
            return;
        }
        if (drawable2 instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) drawable2).getCurrDrawable();
            if (currDrawable instanceof VideoDrawable) {
                videoDrawable = (VideoDrawable) currDrawable;
                z16 = true;
            } else {
                z16 = false;
                videoDrawable = null;
            }
            z17 = true;
        } else {
            z16 = false;
            z17 = false;
            videoDrawable = null;
        }
        if (drawable instanceof URLDrawable) {
            Drawable currDrawable2 = ((URLDrawable) drawable).getCurrDrawable();
            if (VideoDrawable.class.isInstance(currDrawable2)) {
                videoDrawable2 = (VideoDrawable) currDrawable2;
                z18 = true;
            } else {
                z18 = false;
                videoDrawable2 = null;
            }
            z19 = true;
        } else {
            z18 = false;
            z19 = false;
            videoDrawable2 = null;
        }
        if (QLog.isDevelopLevel()) {
            String obj = toString();
            int indexOf = obj.indexOf("{");
            if (indexOf >= 0) {
                obj = obj.substring(indexOf);
            }
            if (this.E != null) {
                String str = obj + this.E.f195590q;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setImageDrawable isStatic: ");
                if (drawable == this.E.f195574a) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                sb5.append(z26);
                sb5.append(" isDynamic: ");
                if (drawable == this.E.f195575b) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                sb5.append(z27);
                sb5.append(" ");
                sb5.append(str);
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
            } else {
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "setImageDrawable isNotDynamicDrawable. " + obj + " " + this.H);
            }
        }
        if (z16) {
            if (!z18) {
                videoDrawable.removeOnPlayRepeatListener(this.J);
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_DYNAMIC_AVATAR, 2, "removeOnPlayRepeatListener.02");
                }
            }
        } else if (z18 && !this.D) {
            videoDrawable2.setOnPlayRepeatListener(this.J);
        }
        if (((z17 && !z19) || drawable2 == null) && (hVar = this.E) != null) {
            hVar.f195591r.B(hVar, false);
        }
        h hVar2 = this.E;
        if (hVar2 != null && drawable != hVar2.f195575b && drawable != hVar2.f195574a) {
            this.H = "";
            this.F = "";
            this.D = false;
            this.E = null;
        }
        super.setImageDrawable(drawable);
        QLog.isDevelopLevel();
    }

    public void setStrangerFaceDrawable(AppInterface appInterface, int i3, String str, boolean z16, int i16, boolean z17, boolean z18, boolean z19, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appInterface, Integer.valueOf(i3), str, Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Integer.valueOf(i17));
        } else {
            Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(32, 3);
            setFaceDrawable(appInterface, 32, i3, str, (byte) 1, 3, z16, defaultDrawable, defaultDrawable, null, i16, false, z17, z18, z19, i17);
        }
    }

    @Override // com.tencent.widget.ThemeImageWrapper.DrawInterface
    public void superOnDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
        } else {
            onDraw(canvas);
        }
    }

    public DynamicAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.I = new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DynamicAvatarView dynamicAvatarView = DynamicAvatarView.this;
                h hVar = dynamicAvatarView.E;
                if (hVar != null) {
                    dynamicAvatarView.setImageDrawable(hVar.a());
                }
            }
        };
        this.J = new a();
        this.L = new Path();
    }

    public DynamicAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.I = new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DynamicAvatarView dynamicAvatarView = DynamicAvatarView.this;
                h hVar = dynamicAvatarView.E;
                if (hVar != null) {
                    dynamicAvatarView.setImageDrawable(hVar.a());
                }
            }
        };
        this.J = new a();
        this.L = new Path();
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, int i18, boolean z17, boolean z18, boolean z19, boolean z26, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            setFaceDrawable(appInterface, i3, i16, str, b16, i17, z16, drawable, drawable2, onLoadingStateChangeListener, i18, z17, z18, z19, z26, i19, false, 0);
        } else {
            iPatchRedirector.redirect((short) 6, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Integer.valueOf(i18), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Integer.valueOf(i19));
        }
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, int i18, boolean z17, boolean z18, boolean z19, boolean z26, int i19, boolean z27, int i26) {
        int i27;
        String str2;
        DynamicAvatarView dynamicAvatarView = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, dynamicAvatarView, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Integer.valueOf(i18), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Integer.valueOf(i19), Boolean.valueOf(z27), Integer.valueOf(i26));
            return;
        }
        dynamicAvatarView.G = i19;
        dynamicAvatarView.H = str;
        dynamicAvatarView.D = z18;
        h hVar = dynamicAvatarView.E;
        if (hVar != null) {
            str2 = DynamicAvatarManager.k(hVar, false);
            i27 = i3;
        } else {
            i27 = i3;
            str2 = null;
        }
        if (DynamicAvatarManager.l(i27, i16, str, i18).equals(str2)) {
            h hVar2 = dynamicAvatarView.E;
            if (hVar2 != null) {
                boolean f16 = hVar2.f();
                dynamicAvatarView.E.c(appInterface, null, i3, i16, str, i18, i17, z18, i19, z17, z26, z16, null, true);
                if (i16 == 205) {
                    dynamicAvatarView.E.f195574a = ((IQQGuildAvatarApi) appInterface.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(str, i18, true, "");
                    dynamicAvatarView.setImageDrawable(dynamicAvatarView.E.a());
                    return;
                }
                if (appInterface instanceof QQAppInterface) {
                    if (AvatarOptimiseConfigUtil.b()) {
                        dynamicAvatarView.E.f195574a = new g(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z19, z27, i26);
                    } else {
                        dynamicAvatarView.E.f195574a = new FaceDrawableImpl(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z19, z27, i26);
                    }
                    dynamicAvatarView = this;
                } else {
                    dynamicAvatarView.E.f195574a = new NearByFaceDrawable(appInterface, i3, i16, str, (byte) 1, i17, z16, drawable, drawable2, onLoadingStateChangeListener, z19);
                }
                dynamicAvatarView.E.b(z19, null);
                if (f16) {
                    return;
                }
                dynamicAvatarView.setImageDrawable(dynamicAvatarView.E.a());
                return;
            }
            return;
        }
        dynamicAvatarView.F = "";
        h hVar3 = dynamicAvatarView.E;
        if (hVar3 != null) {
            hVar3.c(appInterface, null, i3, i16, str, i18, i17, z18, i19, z17, z26, z16, null, false);
            if (i16 == 205) {
                dynamicAvatarView = this;
                dynamicAvatarView.E.f195574a = ((IQQGuildAvatarApi) appInterface.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(str, i18, true, "");
            } else {
                dynamicAvatarView = this;
                if (appInterface instanceof QQAppInterface) {
                    if (AvatarOptimiseConfigUtil.b()) {
                        dynamicAvatarView.E.f195574a = new g(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z19, z27, i26);
                    } else {
                        dynamicAvatarView.E.f195574a = new FaceDrawableImpl(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z19, z27, i26);
                    }
                    dynamicAvatarView = this;
                } else {
                    dynamicAvatarView.E.f195574a = new NearByFaceDrawable(appInterface, i3, i16, str, b16, i17, z16, drawable, drawable2, onLoadingStateChangeListener, z19);
                }
            }
            dynamicAvatarView.E.b(z19, null);
        } else {
            dynamicAvatarView.E = new h(appInterface, i3, i16, str, b16, i17, z16, drawable, drawable2, onLoadingStateChangeListener, i18, z17, z18, z19, z26, i19, z27, i26);
        }
        h hVar4 = dynamicAvatarView.E;
        if (hVar4 != null) {
            hVar4.f195592s = new WeakReference<>(dynamicAvatarView);
            dynamicAvatarView.setImageDrawable(dynamicAvatarView.E.a());
        }
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, String str, int i16, boolean z16, boolean z17, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appInterface, Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i17));
        } else {
            Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(i3, 3);
            setFaceDrawable(appInterface, i3, 200, str, (byte) 0, 3, false, defaultDrawable, defaultDrawable, null, i16, false, z16, z17, false, i17);
        }
    }

    public void setFaceDrawable(AppInterface appInterface, Drawable drawable, int i3, String str, int i16, boolean z16, boolean z17, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appInterface, drawable, Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i17));
        } else {
            FaceDrawable.getDefaultDrawable(i3, 3);
            c(appInterface, drawable, i3, 200, str, false, i16, false, z16, z17, false, i17);
        }
    }

    public void setFaceDrawable(AppInterface appInterface, int i3, String str, int i16, boolean z16, boolean z17, boolean z18, boolean z19, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appInterface, Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Integer.valueOf(i17));
        } else {
            Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(i3, 3);
            setFaceDrawable(appInterface, i3, 200, str, (byte) 0, 3, false, defaultDrawable, defaultDrawable, null, i16, z16, z17, z18, z19, i17);
        }
    }
}
