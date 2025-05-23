package com.tencent.tdf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.filepicker.FilePickerDelegate;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFHostDelegate {
    static IPatchRedirector $redirector_;
    private HostCallback hostCallback;
    private FilePickerDelegate mFilePickDelegate;
    private TDFEngine tdfEngine;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface HostCallback {
        TDFEngine createEngine();

        Activity getActivity();
    }

    public TDFHostDelegate(HostCallback hostCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hostCallback);
        } else {
            this.hostCallback = hostCallback;
        }
    }

    private void initEngine() {
        TDFEngine createEngine = this.hostCallback.createEngine();
        this.tdfEngine = createEngine;
        if (createEngine == null) {
            this.tdfEngine = new TDFEngine(this.hostCallback.getActivity());
        }
        if (this.mFilePickDelegate == null) {
            this.mFilePickDelegate = new FilePickerDelegate(this.hostCallback.getActivity());
        }
        this.tdfEngine.setFilePickerDelegate(this.mFilePickDelegate);
    }

    public View getContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.tdfEngine.getTDFView();
    }

    public TDFEngine getEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TDFEngine) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.tdfEngine;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        FilePickerDelegate filePickerDelegate = this.mFilePickDelegate;
        if (filePickerDelegate != null) {
            filePickerDelegate.onActivityResult(i3, i16, intent);
        }
    }

    public void onCreate(Context context, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) bundle);
        } else {
            initEngine();
        }
    }

    public void onDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.tdfEngine.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMemoryPressure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.tdfEngine.onMemoryPressure();
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.tdfEngine.onPause();
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.tdfEngine.onResume();
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.tdfEngine.onStop();
        }
    }

    public void setFilePickerDelegate(FilePickerDelegate filePickerDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePickerDelegate);
        } else {
            this.mFilePickDelegate = filePickerDelegate;
        }
    }
}
