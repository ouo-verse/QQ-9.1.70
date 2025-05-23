package com.tencent.mobileqq.wink.editor.music.lyric;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static C9030a f320852a = new C9030a();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.editor.music.lyric.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C9030a extends f73.c<a, Void> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // f73.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    @Nullable
    public static d73.b a(@Nullable String str, @Nullable String str2) {
        if (str != null && str2 != null) {
            if (TextUtils.equals(str2.toUpperCase(), LyricParseHelper.LYRIC_FROMAT_LRC)) {
                return b(str, false);
            }
            if (TextUtils.equals(str2.toUpperCase(), LyricParseHelper.LYRIC_FROMAT_QRC)) {
                return b(str, true);
            }
        }
        return null;
    }

    public static d73.b b(String str, boolean z16) {
        d73.b a16;
        if (str != null && str.length() >= 0) {
            try {
                if (z16) {
                    a16 = new c(str).b();
                } else {
                    a16 = new b(str).a();
                }
                if (a16 != null && a16.f393162b.size() > 0) {
                    Iterator<d73.e> it = a16.f393162b.iterator();
                    while (it.hasNext()) {
                        d73.e next = it.next();
                        String str2 = next.f393180a;
                        if (str2 != null) {
                            next.f393180a = str2.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", ContainerUtils.FIELD_DELIMITER);
                        }
                    }
                    return a16;
                }
                return null;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
