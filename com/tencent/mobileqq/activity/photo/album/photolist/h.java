package com.tencent.mobileqq.activity.photo.album.photolist;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends AsyncTask<Object, Object, List<LocalMediaInfo>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<f> f184316a;

    public h(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f184316a = new WeakReference<>(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<LocalMediaInfo> doInBackground(Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) objArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "QueryPhotoTask,doInBackground");
        }
        f fVar = this.f184316a.get();
        if (fVar == null || !fVar.f184312h.f184303n.compareAndSet(false, true)) {
            return null;
        }
        List<LocalMediaInfo> Q = fVar.Q(objArr);
        fVar.f184312h.f184303n.set(false);
        return Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        f fVar = this.f184316a.get();
        if (fVar == null) {
            return;
        }
        fVar.N(list);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onPreExecute();
        }
    }
}
