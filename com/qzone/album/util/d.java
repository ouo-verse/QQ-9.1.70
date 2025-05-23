package com.qzone.album.util;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import com.qzone.util.al;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static final al<d, Void> f44364b = new a();

    /* renamed from: a, reason: collision with root package name */
    private Dialog f44365a = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<d, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Void r16) {
            return new d();
        }
    }

    d() {
    }

    public static d b() {
        return f44364b.get(null);
    }

    public static boolean d(int i3) {
        if (i3 != -11501 && i3 != -11502 && i3 != -4009 && i3 != -10650) {
            return true;
        }
        return false;
    }

    public static boolean e(int i3) {
        if (i3 == -11545) {
            return true;
        }
        return false;
    }

    public static boolean f(int i3) {
        if (i3 != 5 && i3 != 2) {
            return false;
        }
        return true;
    }

    public static void g(String str, long j3, String str2) {
        String c16;
        if (TextUtils.isEmpty(str2) || (c16 = c(str, j3)) == null) {
            return;
        }
        u4.a.z().h0(c16, str2.trim());
    }

    public void a() {
        Dialog dialog = this.f44365a;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f44365a = null;
    }

    public void h(Context context) {
        Dialog dialog = this.f44365a;
        if (dialog == null || !dialog.isShowing()) {
            if (this.f44365a == null && context != null) {
                this.f44365a = u4.a.z().l0(context, R.string.gj5);
            }
            Dialog dialog2 = this.f44365a;
            if (dialog2 != null) {
                try {
                    dialog2.show();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    com.qzone.proxy.feedcomponent.b.i("rightsAlbumOpManager", e16.getMessage());
                }
            }
        }
    }

    private static String c(String str, long j3) {
        if (str == null || j3 == 0) {
            return null;
        }
        return "pre_album_answer_key_" + str + "_" + com.qzone.album.env.common.a.m().s() + "_" + j3;
    }
}
