package com.tencent.mobileqq.microapp.widget.media;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b extends AsyncTask {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private c f246217a;

    public b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            this.f246217a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File doInBackground(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String str = strArr[0];
        if (!str.startsWith("http") && !str.startsWith("https")) {
            mediaMetadataRetriever.setDataSource(str);
        } else {
            mediaMetadataRetriever.setDataSource(str, new HashMap());
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        File file = new File(com.tencent.mobileqq.microapp.appbrand.b.b.a().a("jpg"));
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            frameAtTime.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        mediaMetadataRetriever.release();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) file);
            return;
        }
        super.onPostExecute(file);
        c cVar = this.f246217a;
        if (cVar != null) {
            cVar.a(file);
        }
    }
}
