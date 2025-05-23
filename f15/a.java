package f15;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import e15.b;
import e15.c;
import e15.d;
import e15.e;
import e15.f;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public f a(View view) {
        if (view != null) {
            if (RelativeLayout.class.isInstance(view)) {
                return new d(TtmlNode.TAG_LAYOUT, view);
            }
            return new f(view);
        }
        return null;
    }

    public View b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if ("text_view".equals(str)) {
                return new TextView(context);
            }
            if ("image_view".equals(str)) {
                return new ImageView(context);
            }
            if (TtmlNode.TAG_LAYOUT.equals(str)) {
                return new RelativeLayout(context);
            }
            if ("lottie_view".equals(str)) {
                return new LottieAnimationView(context);
            }
            if ("mask_view".equals(str)) {
                return new ImageView(context);
            }
        }
        return null;
    }

    public f c(String str, View view) {
        if (view == null) {
            return null;
        }
        if ("text_view".equals(str)) {
            return new e(str, view);
        }
        if ("image_view".equals(str)) {
            return new e15.a(str, view);
        }
        if (TtmlNode.TAG_LAYOUT.equals(str)) {
            return new d(str, view);
        }
        if ("lottie_view".equals(str)) {
            return new b(str, view);
        }
        if (!"mask_view".equals(str)) {
            return null;
        }
        return new c(str, view);
    }

    public void d(f fVar, JSONObject jSONObject) {
    }
}
