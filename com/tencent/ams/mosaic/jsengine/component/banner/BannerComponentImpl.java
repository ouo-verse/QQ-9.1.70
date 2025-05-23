package com.tencent.ams.mosaic.jsengine.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.actionbanner.TwoLineActionBannerView;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BannerComponentImpl extends FeatureComponent implements BannerComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final TwoLineActionBannerView f70950d;

    public BannerComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f70950d = new TwoLineActionBannerView(context);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public RectF getBannerRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (RectF) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f70950d.getBannerRect();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70950d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setActionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.f70950d.setActionType(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setBackgroundAnimationType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f70950d.setBackgroundAnimationType(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setBackgroundHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.f70950d.setBackgroundHeight(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setBannerBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.f70950d.setBackgroundColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setBannerHighlightBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.f70950d.setHighlightBackgroundColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setBannerHighlightDelayTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.f70950d.setHighlightDelayTime(j3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setIconBitmapArray(Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bitmapArr);
        } else {
            this.f70950d.setIconBitmapArray(bitmapArr);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setIconVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f70950d.setIconVisible(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setMargin(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            super.setMargin(f16, f17, f18, f19);
            this.f70950d.setMarginBottom(getBottomMargin());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setMarginBottom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f70950d.setMarginBottom(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setSlideIconShape(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.f70950d.setSlideIconShape(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f70950d.setSubTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setSubTitleColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f70950d.setSubTitleColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setSubTitleTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.f70950d.setSubTitleFontSize(MosaicUtils.j(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f70950d.setTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setTitleColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f70950d.setTitleColor(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setTitleTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.f70950d.setTitleFontSize(MosaicUtils.j(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setTouchAreaHeightFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else {
            this.f70950d.setTouchAreaHeightFactor(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.banner.BannerComponent
    public void setTouchAreaWidthFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
        } else {
            this.f70950d.setTouchAreaWidthFactor(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BannerComponentImpl";
    }
}
