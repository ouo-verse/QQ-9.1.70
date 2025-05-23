package a7;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import b7.a;
import b7.b;
import b7.c;
import b7.d;
import b7.e;
import b7.f;
import com.qzone.homepage.diy.jsoninflate.widget.DIYAsyncImageView;
import com.qzone.homepage.diy.jsoninflate.widget.DIYTextView;
import e15.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends f15.a {
    @Override // f15.a
    public f c(String str, View view) {
        if ("image_view".equals(str)) {
            return new a(str, view);
        }
        if ("player_view".equals(str)) {
            return new d.b(str, view);
        }
        if ("intimacy_view".equals(str)) {
            return new b.a(str, view);
        }
        if ("vip_widget_view".equals(str)) {
            return new f.b(str, view);
        }
        if ("qzone_avatar_view".equals(str)) {
            return new a.C0103a(str, view);
        }
        if ("navigation_view".equals(str)) {
            return new c.b(str, view);
        }
        if ("video_view".equals(str)) {
            return new e.a(str, view);
        }
        if ("text_view".equals(str)) {
            return new b(str, view);
        }
        if ("lottie_view".equals(str)) {
            return new d(str, view);
        }
        return super.c(str, view);
    }

    @Override // f15.a
    public View b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if ("image_view".equals(str)) {
            return new DIYAsyncImageView(context);
        }
        if ("player_view".equals(str)) {
            return new b7.d(context).a();
        }
        if ("intimacy_view".equals(str)) {
            return new b7.b(context).a();
        }
        if ("vip_widget_view".equals(str)) {
            return new b7.f(context).a();
        }
        if ("qzone_avatar_view".equals(str)) {
            return new b7.a(context).a();
        }
        if ("navigation_view".equals(str)) {
            return new b7.c(context).a();
        }
        if ("video_view".equals(str)) {
            return new e(context).a();
        }
        if ("text_view".equals(str)) {
            return new DIYTextView(context);
        }
        return super.b(context, str);
    }
}
