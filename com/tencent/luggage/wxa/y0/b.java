package com.tencent.luggage.wxa.y0;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.tencent.luggage.wxa.d1.d;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;
import java.io.Serializable;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f145406a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements MediaScannerConnection.OnScanCompletedListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f145407a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f145408b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Uri f145409c;

        public a(c cVar, Context context, Uri uri) {
            this.f145407a = cVar;
            this.f145408b = context;
            this.f145409c = uri;
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            d.a().a("File " + str + " was scanned successfully: " + uri);
            if (str == null) {
                d.a().a("This should not happen, go back to Immediate implemenation");
                str = b.this.f145406a;
            }
            this.f145407a.a(com.tencent.luggage.wxa.f1.c.a(str));
            com.tencent.luggage.wxa.d1.c.a(this.f145408b, this.f145409c);
        }
    }

    public Intent a(Context context, com.tencent.luggage.wxa.a1.a aVar) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File a16 = com.tencent.luggage.wxa.d1.c.a(aVar.a());
        if (a16 == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        Uri uriForFile = FileProvider.getUriForFile(applicationContext, String.format(Locale.ENGLISH, "%s%s", applicationContext.getPackageName(), ".wmpf.imagepicker.provider"), a16);
        this.f145406a = HippyBridge.URI_SCHEME_FILE + a16.getAbsolutePath();
        intent.putExtra("output", uriForFile);
        com.tencent.luggage.wxa.d1.c.a(context, intent, uriForFile);
        return intent;
    }

    public void a(Context context, Intent intent, c cVar) {
        if (cVar != null) {
            String str = this.f145406a;
            if (str == null) {
                d.a().c("currentImagePath null. This happen if you haven't call #getCameraIntent() or the activity is being recreated");
                cVar.a(null);
                return;
            } else {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{parse.getPath()}, null, new a(cVar, context, parse));
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("OnImageReadyListener must not be null");
    }

    public void a() {
        if (this.f145406a != null) {
            File file = new File(this.f145406a);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
