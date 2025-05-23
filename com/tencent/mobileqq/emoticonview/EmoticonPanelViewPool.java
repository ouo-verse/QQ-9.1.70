package com.tencent.mobileqq.emoticonview;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class EmoticonPanelViewPool {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_CAPACITY = 3;
    private static final String LOG_TAG = "EmoticonPanelViewPool";
    private SparseArray<List<View>> recyleViewsMap;

    public EmoticonPanelViewPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.recyleViewsMap = new SparseArray<>();
        }
    }

    public boolean addRecyleView(int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[RecyleView] addRecyleView, type=" + i3 + ", view=" + view);
        }
        if (view == null) {
            return false;
        }
        List<View> list = this.recyleViewsMap.get(i3);
        if (list == null) {
            list = new ArrayList<>(3);
            this.recyleViewsMap.put(i3, list);
        }
        if (list.size() >= 3) {
            if (QLog.isColorLevel()) {
                QLog.w(LOG_TAG, 2, "Capacity full for type " + i3);
            }
            return false;
        }
        list.add(view);
        return true;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int size = this.recyleViewsMap.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.recyleViewsMap.get(this.recyleViewsMap.keyAt(i3)).clear();
        }
        this.recyleViewsMap.clear();
    }

    public View getRecyleView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        List<View> list = this.recyleViewsMap.get(i3);
        if (list != null && list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

    public int getSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        List<View> list = this.recyleViewsMap.get(i3);
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
