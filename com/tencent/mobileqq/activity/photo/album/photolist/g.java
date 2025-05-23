package com.tencent.mobileqq.activity.photo.album.photolist;

import android.os.AsyncTask;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends AsyncTask<Object, Object, Pair<List<LocalMediaInfo>, Integer>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<f> f184315a;

    public g(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f184315a = new WeakReference<>(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Pair<List<LocalMediaInfo>, Integer> doInBackground(Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) objArr);
        }
        f fVar = this.f184315a.get();
        if (fVar == null) {
            return null;
        }
        MediaQueryHelper mediaQueryHelper = fVar.f184310e.getMediaQueryHelper();
        if (mediaQueryHelper == null) {
            QLog.w("QQAlbum", 1, "QueryPhotoTask,doInBackground, mediaQueryHelper is null");
            return null;
        }
        List<LocalMediaInfo> list = mediaQueryHelper.mediaList;
        int size = list.size();
        if (fVar.f184312h.f184303n.compareAndSet(false, true)) {
            mediaQueryHelper.queryNext();
            fVar.S(list, size);
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + list.size());
            }
            fVar.f184312h.f184303n.set(false);
        }
        return new Pair<>(list, Integer.valueOf(size));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Pair<List<LocalMediaInfo>, Integer> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pair);
            return;
        }
        f fVar = this.f184315a.get();
        if (fVar == null) {
            return;
        }
        fVar.f184313i.Q.t0((List) pair.first);
        fVar.f184313i.Q.notifyItemRangeInserted(((Integer) pair.second).intValue(), ((List) pair.first).size() - ((Integer) pair.second).intValue());
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
