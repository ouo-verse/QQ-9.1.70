package com.tencent.ams.mosaic.jsengine.component.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ButtonComponentImpl extends BasicComponent implements ButtonComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final float f70951f;

    /* renamed from: h, reason: collision with root package name */
    private static final float f70952h;

    /* renamed from: d, reason: collision with root package name */
    private final ProgressButton f70953d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseIntArray f70954e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends ProgressButton {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ButtonComponentImpl.this, (Object) context);
            }
        }

        @Override // android.view.View
        public void setPressed(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            super.setPressed(z16);
            f.a("ButtonComponentImpl", "setPressed:" + z16);
            if (z16) {
                i3 = ButtonComponentImpl.this.f70954e.get(1);
            } else {
                i3 = ButtonComponentImpl.this.f70954e.get(0);
            }
            if (i3 != 0) {
                setProgressColor(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f70955a;

        b(c cVar) {
            this.f70955a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ButtonComponentImpl.this, (Object) cVar);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "onLoadFinish: " + this.f70955a.f70957a + ", object: " + obj);
            if (obj instanceof Bitmap) {
                c cVar = this.f70955a;
                cVar.f70964h = MosaicUtils.R((Bitmap) obj, (int) MosaicUtils.j(cVar.f70959c), (int) MosaicUtils.j(this.f70955a.f70960d));
                ButtonComponentImpl.this.v(this.f70955a);
            } else {
                if (obj instanceof Drawable) {
                    c cVar2 = this.f70955a;
                    cVar2.f70964h = MosaicUtils.k((Drawable) obj, (int) cVar2.f70959c, (int) cVar2.f70960d);
                    ButtonComponentImpl.this.v(this.f70955a);
                    return;
                }
                com.tencent.ams.mosaic.utils.f.h("ButtonComponentImpl", "onLoadFinish: icon bitmap load failed");
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "onLoadStart: " + this.f70955a.f70957a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f70957a;

        /* renamed from: b, reason: collision with root package name */
        String f70958b;

        /* renamed from: c, reason: collision with root package name */
        float f70959c;

        /* renamed from: d, reason: collision with root package name */
        float f70960d;

        /* renamed from: e, reason: collision with root package name */
        String f70961e;

        /* renamed from: f, reason: collision with root package name */
        int f70962f;

        /* renamed from: g, reason: collision with root package name */
        float f70963g;

        /* renamed from: h, reason: collision with root package name */
        Bitmap f70964h;

        c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ButtonComponentImpl.this, (Object) str);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f70957a = jSONObject.optString("src");
                this.f70958b = jSONObject.optString("data");
                this.f70959c = (float) jSONObject.optDouble("width", ButtonComponentImpl.f70951f);
                this.f70960d = (float) jSONObject.optDouble("height", ButtonComponentImpl.f70952h);
                this.f70961e = jSONObject.optString("position");
                this.f70962f = jSONObject.optInt("type");
                this.f70963g = (float) jSONObject.optDouble(ButtonComponent.IconInfoKey.ICON_SPACE, 4.0d);
            } catch (JSONException e16) {
                throw new IllegalArgumentException("Input info is not valid json string, please check!", e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f70951f = Utils.dp2px(20.0f);
            f70952h = Utils.dp2px(20.0f);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ButtonComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f70954e = new SparseIntArray();
            this.f70953d = new a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(c cVar) {
        this.f70953d.setIcon(cVar.f70964h, (int) Utils.dp2px(cVar.f70959c), (int) Utils.dp2px(cVar.f70960d), cVar.f70961e, cVar.f70962f, (int) Utils.dp2px(cVar.f70963g));
    }

    private void u(@NonNull c cVar) {
        if (!TextUtils.isEmpty(cVar.f70958b)) {
            cVar.f70964h = MosaicUtils.d(cVar.f70958b, MosaicUtils.j(cVar.f70959c), MosaicUtils.j(cVar.f70960d));
            v(cVar);
        } else if (!TextUtils.isEmpty(cVar.f70957a)) {
            getImageLoader().loadImage(cVar.f70957a, new b(cVar));
        } else {
            com.tencent.ams.mosaic.utils.f.h("ButtonComponentImpl", "loadIconBitmap failed: no data or src");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@NonNull final c cVar) {
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.button.a
            @Override // java.lang.Runnable
            public final void run() {
                ButtonComponentImpl.this.t(cVar);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70953d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setBackgroundColor: " + str);
        setStatusBackgroundColor(0, str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.Component
    public void setBorder(float f16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.BasicComponent, com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setCornerRadius: " + f16);
        this.f70953d.setCornerRadius(MosaicUtils.j(f16));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setEnable(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setEnable: " + z16);
        this.f70953d.setEnabled(z16);
        ProgressButton progressButton = this.f70953d;
        SparseIntArray sparseIntArray = this.f70954e;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        progressButton.setProgressColor(sparseIntArray.get(i3));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setIcon(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setIcon: " + str);
        try {
            u(new c(str));
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("ButtonComponentImpl", "setIcon failed", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setProgress: " + f16);
        this.f70953d.setProgress(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setProgressBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setProgressBackgroundColor: " + str);
        this.f70953d.setProgressBackgroundColor(MosaicUtils.O(str));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setStatusBackgroundColor(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setStatusBackgroundColor: status=" + i3 + ", colorHex=" + str);
        int O = MosaicUtils.O(str);
        if (i3 == 0) {
            this.f70953d.setProgressColor(O);
        }
        this.f70954e.put(i3, O);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setText: " + str);
        this.f70953d.setText(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setTextColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setTextColor: " + str);
        this.f70953d.setTextColor(MosaicUtils.O(str));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setTextSize: " + f16);
        this.f70953d.setTextSize(MosaicUtils.j(f16));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.button.ButtonComponent
    public void setTextTypeface(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("ButtonComponentImpl", "setTextTypeface: familyName=" + str + ", style=" + str2);
        this.f70953d.setTextTypeface(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ButtonComponentImpl";
    }
}
