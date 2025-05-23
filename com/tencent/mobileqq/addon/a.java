package com.tencent.mobileqq.addon;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.Invalidatable;
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements Invalidatable {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    static LRULinkedHashMap<String, Bitmap> f187618h;

    /* renamed from: d, reason: collision with root package name */
    JSONObject f187619d;

    /* renamed from: e, reason: collision with root package name */
    Bundle f187620e;

    /* renamed from: f, reason: collision with root package name */
    WeakReference<MessengerService> f187621f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f187618h = new LRULinkedHashMap<>(10);
        }
    }

    public a(JSONObject jSONObject, Bundle bundle, WeakReference<MessengerService> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, jSONObject, bundle, weakReference);
            return;
        }
        this.f187619d = jSONObject;
        this.f187620e = bundle;
        this.f187621f = weakReference;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.Invalidatable
    public Object getCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Object();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.Invalidatable
    public void invalidateSelf() {
        int i3;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String optString = this.f187619d.optString("text");
        int optInt = this.f187619d.optInt("width");
        int optInt2 = this.f187619d.optInt("height");
        int optInt3 = this.f187619d.optInt(MessageForRichState.SIGN_MSG_FONT_ID);
        String optString2 = this.f187619d.optString("fontColor");
        int optInt4 = this.f187619d.optInt(MessageForRichState.SIGN_MSG_FONT_TYPE);
        TextPaint textPaint = new TextPaint();
        float f16 = AvatarPendantUtil.f(textPaint, new Rect(3, 5, optInt - 3, optInt2 - 3), optString);
        try {
            i3 = Color.parseColor(optString2);
        } catch (Exception unused) {
            i3 = 0;
        }
        if (optInt4 == 1) {
            bitmap = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().fetchTextBitmap(this, optString, optInt3, optInt4, f16, i3, optInt, optInt2, textPaint);
        } else {
            Typeface fetchTextTypeface = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().fetchTextTypeface(this, optInt3, optInt4);
            if (fetchTextTypeface != null) {
                textPaint.setTypeface(fetchTextTypeface);
            }
            textPaint.setColor(i3);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(f16);
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f17 = (((r1.bottom + r1.top) - fontMetrics.bottom) - fontMetrics.top) / 2.0f;
            String str = optInt + "_" + optInt2;
            Bitmap bitmap2 = f187618h.get(str);
            if (bitmap2 == null && (bitmap2 = Bitmap.createBitmap(optInt, optInt2, Bitmap.Config.ARGB_8888)) != null) {
                f187618h.put(str, bitmap2);
            }
            bitmap = bitmap2;
            if (bitmap != null) {
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.drawText(optString, r1.centerX(), f17, textPaint);
            }
        }
        if (bitmap != null) {
            Bundle bundle = new Bundle();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                byteArrayOutputStream.close();
                bundle.putBoolean("updateResult", true);
                bundle.putString("file", "data:image/png;base64," + encodeToString);
            } catch (Exception e16) {
                bundle.putBoolean("updateResult", false);
                bundle.putString("errMsg", e16.getMessage());
            }
            this.f187620e.putBundle("response", bundle);
            WeakReference<MessengerService> weakReference = this.f187621f;
            if (weakReference != null && weakReference.get() != null) {
                this.f187621f.get().J(this.f187620e);
            }
        }
    }
}
