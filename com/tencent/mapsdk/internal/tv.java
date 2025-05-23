package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tv implements om {

    /* renamed from: c, reason: collision with root package name */
    private Context f151111c;

    /* renamed from: d, reason: collision with root package name */
    private final float f151112d;

    /* renamed from: e, reason: collision with root package name */
    private String f151113e;

    /* renamed from: f, reason: collision with root package name */
    private String f151114f;

    public tv(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f151111c = applicationContext;
        this.f151112d = ht.a(applicationContext);
        this.f151113e = str;
    }

    private Bitmap b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        InputStream b16 = ku.b(mz.a(this.f151111c, (TencentMapOptions) null).a(this.f151113e) + str);
        if (b16 == null) {
            b16 = ku.b(mz.a(this.f151111c, (TencentMapOptions) null).b(this.f151113e) + str);
        }
        if (b16 == null) {
            b16 = ku.b(mz.a(this.f151111c, (TencentMapOptions) null).e() + str);
        }
        if (b16 == null && this.f151114f != null) {
            b16 = ku.a(new File(this.f151114f, str));
        }
        if (b16 == null) {
            if (mw.a() != null) {
                b16 = mw.b(this.f151111c, mw.a() + str);
            } else if (mw.b() != null) {
                b16 = ku.b(mw.b() + str);
            }
        }
        if (b16 == null) {
            b16 = mw.a(this.f151111c, str);
        }
        if (b16 == null) {
            b16 = mw.b(this.f151111c, str);
        }
        if (b16 == null) {
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(b16);
        ku.a((Closeable) b16);
        return decodeStream;
    }

    @Override // com.tencent.mapsdk.internal.om
    public final String a() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.om
    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains("../")) {
            str = str.replaceAll("\\.\\./", "");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f151114f = str;
    }

    @Override // com.tencent.mapsdk.internal.om
    public final void a(String str, IconImageInfo iconImageInfo) {
        Bitmap a16 = hn.f148686b.a(str);
        if (a16 == null) {
            a16 = hn.f148686b.a(str);
        }
        iconImageInfo.bitmap = a16;
        if (!str.endsWith(er.f148290s) && !str.contains("@2x")) {
            if (!str.endsWith("@3x.png") && !str.contains("@3x")) {
                iconImageInfo.scale = this.f151112d;
            } else {
                iconImageInfo.scale = 3.0f;
            }
        } else {
            iconImageInfo.scale = 2.0f;
        }
        if (this.f151111c != null && a16 == null) {
            try {
                if (str.startsWith("poi_icon") || str.startsWith(er.f148289r)) {
                    a16 = b(hs.b(str) + er.f148290s);
                }
                if (a16 != null) {
                    iconImageInfo.bitmap = a16;
                    iconImageInfo.scale = 2.0f;
                    return;
                }
                iconImageInfo.bitmap = b(str);
                if (!str.equals(om.f149479a) && !str.equals(om.f149480b)) {
                    iconImageInfo.scale = 1.0f;
                    return;
                }
                iconImageInfo.scale = this.f151112d;
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
            }
        }
    }
}
