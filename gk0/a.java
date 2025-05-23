package gk0;

import android.content.Intent;
import fk0.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a {
    private WeakReference<c> mVInstance;
    private String mModuleName = "BaseModule";
    private ArrayList<String> mFunctions = new ArrayList<>();

    public boolean callbackJavascript(Object obj) {
        return true;
    }

    public String getModuleName() {
        return this.mModuleName;
    }

    public c getViolaInstance() {
        WeakReference<c> weakReference = this.mVInstance;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean onActivityBack() {
        return false;
    }

    public void setModuleName(String str) {
        this.mModuleName = str;
    }

    public void setViolaInstance(c cVar) {
        this.mVInstance = new WeakReference<>(cVar);
    }

    public void onActivityCreate() {
    }

    public void onActivityDestroy() {
    }

    public void onActivityPause() {
    }

    public void onActivityResume() {
    }

    public void onActivityStart() {
    }

    public void onActivityStop() {
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
