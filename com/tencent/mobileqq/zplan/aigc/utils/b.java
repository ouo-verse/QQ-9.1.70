package com.tencent.mobileqq.zplan.aigc.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.component.network.utils.thread.AsyncTask;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0014R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/utils/b;", "Lcom/tencent/component/network/utils/thread/AsyncTask;", "", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "", "params", "a", "([Ljava/lang/String;)Landroid/graphics/Bitmap;", "result", "", "b", "Lcom/tencent/mobileqq/zplan/aigc/utils/b$a;", "Lcom/tencent/mobileqq/zplan/aigc/utils/b$a;", "listener", "<init>", "(Lcom/tencent/mobileqq/zplan/aigc/utils/b$a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/utils/b$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    public b(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.network.utils.thread.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... params) {
        Throwable th5;
        HttpURLConnection httpURLConnection;
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(params, "params");
        HttpURLConnection httpURLConnection2 = null;
        Bitmap bitmap2 = null;
        httpURLConnection2 = null;
        try {
            try {
                URLConnection openConnection = new URL(params[0]).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
                try {
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    bitmap2 = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return bitmap2;
                } catch (Exception e16) {
                    e = e16;
                    Bitmap bitmap3 = bitmap2;
                    httpURLConnection2 = httpURLConnection;
                    bitmap = bitmap3;
                    e.printStackTrace();
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return bitmap;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                th5 = th7;
                httpURLConnection = httpURLConnection3;
            }
        } catch (Exception e17) {
            e = e17;
            bitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.network.utils.thread.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        this.listener.a(result);
    }
}
