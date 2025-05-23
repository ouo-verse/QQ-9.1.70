package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.widget.AdapterView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes10.dex */
public class BasePreviewPresent extends BrowserBasePresenter {
    static IPatchRedirector $redirector_;

    public BasePreviewPresent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    Context getContext() {
        return BaseApplication.getContext();
    }

    public URL getFileUrl(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URL) iPatchRedirector.redirect((short) 6, (Object) this, (Object) file);
        }
        if (file == null) {
            return null;
        }
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public View getView(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), view, viewGroup);
        }
        if (viewGroup != null) {
            return new ImageView(viewGroup.getContext());
        }
        return new ImageView(getContext());
    }

    public View onCreateView(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup);
        }
        return null;
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void onViewDetached() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }
}
