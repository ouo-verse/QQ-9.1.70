package com.qzone.reborn.publicaccount;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/publicaccount/i;", "", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "a", "", "template", "", "c", "d", "count", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f58780a = new i();

    i() {
    }

    public final boolean c(int template) {
        if (template == 1) {
            return true;
        }
        return false;
    }

    public final boolean d(int template) {
        if (template == 2) {
            return true;
        }
        return false;
    }

    public final void a(ViewGroup rootView) {
        if (rootView == null || rootView.getContext() == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.me5);
        View view = new View(rootView.getContext());
        view.setBackground(rootView.getContext().getDrawable(R.drawable.qui_common_border_standard_bg));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, ar.e(0.5f));
        marginLayoutParams.setMargins(ar.e(16.0f), 0, ar.d(16.0f), 0);
        linearLayout.addView(view, marginLayoutParams);
    }

    public final String b(int count) {
        if (count <= 9999) {
            return String.valueOf(count);
        }
        if (count <= 9990000) {
            int i3 = count / 10000;
            int i16 = (count % 10000) / 1000;
            if (i3 < 10) {
                return i3 + "." + i16 + "w";
            }
            return i3 + "w";
        }
        return "999w";
    }
}
