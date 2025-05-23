package com.tencent.ams.dsdk.view.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.RequiresApi;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKImageView extends HippyImageView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKImageView";
    private float mBlurRadius;
    boolean mHardwareAccelerated;

    public DKImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mHardwareAccelerated = false;
            this.mBlurRadius = -1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void handleImageRequest(IDrawableTarget iDrawableTarget, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iDrawableTarget, Integer.valueOf(i3), obj);
            return;
        }
        super.handleImageRequest(new DrawableTargetWrapper(iDrawableTarget, this.mBlurRadius), i3, obj);
        if ((iDrawableTarget instanceof HippyDrawable) && ((HippyDrawable) iDrawableTarget).isAnimated() && this.mHardwareAccelerated) {
            setLayerType(2, null);
        }
    }

    public void setBlurRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mBlurRadius = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class DrawableTargetWrapper implements IDrawableTarget {
        static IPatchRedirector $redirector_;
        private float blurRadius;
        private final IDrawableTarget mOriginalDrawableTarget;

        public DrawableTargetWrapper(IDrawableTarget iDrawableTarget, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, iDrawableTarget, Float.valueOf(f16));
            } else {
                this.mOriginalDrawableTarget = iDrawableTarget;
                this.blurRadius = f16;
            }
        }

        @RequiresApi(api = 17)
        private Bitmap blur(Bitmap bitmap, float f16) {
            BaseObj baseObj;
            Allocation allocation;
            Allocation allocation2;
            RenderScript renderScript = null;
            ScriptIntrinsicBlur scriptIntrinsicBlur = null;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    safeDestroy((BaseObj) null);
                    safeDestroy((BaseObj) null);
                    safeDestroy((BaseObj) null);
                    safeDestroy((RenderScript) null);
                    return bitmap;
                }
                RenderScript create = RenderScript.create(DKEngine.getApplicationContext());
                try {
                    allocation = Allocation.createFromBitmap(create, bitmap);
                    try {
                        allocation2 = Allocation.createTyped(create, allocation.getType());
                    } catch (Throwable th5) {
                        th = th5;
                        baseObj = null;
                        allocation2 = null;
                    }
                    try {
                        scriptIntrinsicBlur = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                        scriptIntrinsicBlur.setRadius(f16);
                        scriptIntrinsicBlur.setInput(allocation);
                        scriptIntrinsicBlur.forEach(allocation2);
                        allocation2.copyTo(createBitmap);
                        DLog.d(DKImageView.TAG, "blur bitmap success, cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                        safeDestroy(allocation);
                        safeDestroy(allocation2);
                        safeDestroy(scriptIntrinsicBlur);
                        safeDestroy(create);
                        return createBitmap;
                    } catch (Throwable th6) {
                        th = th6;
                        baseObj = scriptIntrinsicBlur;
                        renderScript = create;
                        try {
                            DLog.w(DKImageView.TAG, "blur failed: " + th);
                            return bitmap;
                        } finally {
                            safeDestroy(allocation);
                            safeDestroy(allocation2);
                            safeDestroy(baseObj);
                            safeDestroy(renderScript);
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    baseObj = null;
                    allocation = null;
                    allocation2 = null;
                }
            } catch (Throwable th8) {
                th = th8;
                baseObj = null;
                allocation = null;
                allocation2 = null;
            }
        }

        private void safeDestroy(BaseObj baseObj) {
            if (baseObj != null) {
                try {
                    baseObj.destroy();
                } catch (Throwable th5) {
                    DLog.e(DKImageView.TAG, "destroy error.", th5);
                }
            }
        }

        @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
        public Bitmap getBitmap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            DLog.i(DKImageView.TAG, "getBitmap");
            IDrawableTarget iDrawableTarget = this.mOriginalDrawableTarget;
            if (iDrawableTarget != null) {
                Bitmap bitmap = iDrawableTarget.getBitmap();
                float f16 = this.blurRadius;
                if (f16 >= 0.0f && bitmap != null) {
                    return blur(bitmap, f16);
                }
                return bitmap;
            }
            return null;
        }

        @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
        public Drawable getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            DLog.i(DKImageView.TAG, "getDrawable");
            IDrawableTarget iDrawableTarget = this.mOriginalDrawableTarget;
            if (iDrawableTarget != null) {
                return iDrawableTarget.getDrawable();
            }
            return null;
        }

        @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
        public Object getExtraData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this);
            }
            DLog.i(DKImageView.TAG, "getExtraData");
            IDrawableTarget iDrawableTarget = this.mOriginalDrawableTarget;
            if (iDrawableTarget != null) {
                return iDrawableTarget.getExtraData();
            }
            return null;
        }

        @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
        public String getImageType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            DLog.i(DKImageView.TAG, "getImageType");
            IDrawableTarget iDrawableTarget = this.mOriginalDrawableTarget;
            if (iDrawableTarget != null) {
                return iDrawableTarget.getImageType();
            }
            return null;
        }

        @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
        public String getSource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            DLog.i(DKImageView.TAG, "getSource");
            IDrawableTarget iDrawableTarget = this.mOriginalDrawableTarget;
            if (iDrawableTarget != null) {
                return iDrawableTarget.getSource();
            }
            return null;
        }

        @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
        public void onDrawableAttached() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            DLog.i(DKImageView.TAG, "onDrawableAttached");
            IDrawableTarget iDrawableTarget = this.mOriginalDrawableTarget;
            if (iDrawableTarget != null) {
                iDrawableTarget.onDrawableAttached();
            }
        }

        @Override // com.tencent.mtt.supportui.adapters.image.IDrawableTarget
        public void onDrawableDetached() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            DLog.i(DKImageView.TAG, "onDrawableDetached");
            IDrawableTarget iDrawableTarget = this.mOriginalDrawableTarget;
            if (iDrawableTarget != null) {
                iDrawableTarget.onDrawableDetached();
            }
        }

        private void safeDestroy(RenderScript renderScript) {
            if (renderScript != null) {
                try {
                    renderScript.destroy();
                } catch (Throwable th5) {
                    DLog.e(DKImageView.TAG, "destroy error.", th5);
                }
            }
        }
    }
}
