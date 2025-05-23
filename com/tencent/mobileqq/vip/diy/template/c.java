package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends ProfileTemplateBase {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f312998a;

        /* renamed from: b, reason: collision with root package name */
        private int f312999b;

        public a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f312998a = i3;
                this.f312999b = i16;
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f312998a, this.f312999b, Bitmap.Config.ARGB_8888);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth() / 5, bitmap.getHeight()), new Rect(0, 0, bitmap.getWidth() / 5, createBitmap.getHeight()), paint);
                canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() / 5, 0, bitmap.getWidth() - (bitmap.getWidth() / 5), bitmap.getHeight()), new Rect(bitmap.getWidth() / 5, 0, createBitmap.getWidth() - (bitmap.getWidth() / 5), createBitmap.getHeight()), paint);
                canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() - (bitmap.getWidth() / 5), 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(createBitmap.getWidth() - (bitmap.getWidth() / 5), 0, createBitmap.getWidth(), createBitmap.getHeight()), paint);
                return createBitmap;
            }
            return null;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "TitleDrawableDecoderHandler{reqW=" + this.f312998a + ", reqH=" + this.f312999b + '}';
        }
    }

    public c(Activity activity, JSONObject jSONObject, ProfileCardInfo profileCardInfo) {
        super(activity, jSONObject, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, jSONObject, profileCardInfo);
        } else {
            this.f312975n = UIUtils.b(activity, 3.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
    public void a(JSONObject jSONObject, View view, TextView textView, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, jSONObject, view, textView, imageView);
            return;
        }
        if (view != null && textView != null) {
            textView.setTextColor(this.f312973l);
            String k3 = k(jSONObject);
            if (!TextUtils.isEmpty(k3)) {
                view.setBackgroundDrawable(m(k3, new a(Math.min(((int) textView.getPaint().measureText(textView.getText().toString())) + UIUtils.b(this.f312971j, 23.0f), UIUtils.b(this.f312971j, 300.0f)), UIUtils.b(this.f312971j, 40.0f))));
            } else {
                if (jSONObject != null) {
                    QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, jSONObject.optString("type") + " bind title icon is null!");
                }
                view.setVisibility(8);
            }
        }
        if (imageView != null) {
            String c16 = c(jSONObject);
            if (!TextUtils.isEmpty(c16)) {
                imageView.setImageDrawable(l(c16));
                return;
            }
            if (jSONObject != null) {
                QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, jSONObject.optString("type") + " bind arrow icon is null!");
            }
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
    public ProfileCardFavorShowView g(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ProfileCardFavorShowView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        }
        return new ProfileCardFavorShowView(activity, null, R.layout.be7);
    }

    @Override // com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
    public void o(HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap);
        } else {
            hashMap.put(IProfileContentKey.MAP_KEY_QZONE, this.f312970i.inflate(R.layout.bef, (ViewGroup) null));
        }
    }

    @Override // com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
    public void x(JSONObject jSONObject, TextView textView, View view, ImageView imageView, View view2, View view3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, jSONObject, textView, view, imageView, view2, view3);
            return;
        }
        if (textView != null) {
            textView.setTextColor(this.f312973l);
        }
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(this.f312973l);
        } else if (view instanceof SingleLineTextView) {
            ((SingleLineTextView) view).setTextColor(this.f312973l);
        }
        if (imageView != null) {
            int b16 = b(25.0f);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = b16;
            layoutParams.height = b16;
            imageView.setLayoutParams(layoutParams);
            String c16 = c(jSONObject);
            if (!TextUtils.isEmpty(c16)) {
                imageView.setImageDrawable(l(c16));
            } else {
                imageView.setImageDrawable(null);
            }
        }
        if (textView != null && view2 != null) {
            int b17 = UIUtils.b(this.f312971j, 6.0f);
            int b18 = UIUtils.b(this.f312971j, 12.0f);
            int b19 = UIUtils.b(this.f312971j, 12.0f);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.bottomMargin = b17;
            layoutParams2.leftMargin = b18;
            layoutParams2.rightMargin = b19;
            textView.setLayoutParams(layoutParams2);
            textView.setTextSize(1, 15.0f);
            String k3 = k(jSONObject);
            if (!TextUtils.isEmpty(k3)) {
                int b26 = UIUtils.b(this.f312971j, 300.0f);
                view2.setBackgroundDrawable(m(k3, new a(Math.min(((int) textView.getPaint().measureText(textView.getText().toString())) + UIUtils.b(this.f312971j, 23.0f), b26), UIUtils.b(this.f312971j, 40.0f))));
                view2.setVisibility(0);
            } else {
                view2.setBackgroundDrawable(null);
                view2.setVisibility(8);
            }
        }
        if (view3 != null) {
            int b27 = b(10.0f);
            view3.setPadding(b27, b27, b27, b27);
            s(jSONObject, view3);
        }
    }
}
