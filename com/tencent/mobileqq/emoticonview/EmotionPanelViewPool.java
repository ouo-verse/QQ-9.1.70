package com.tencent.mobileqq.emoticonview;

import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes12.dex */
public class EmotionPanelViewPool {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionPanelViewPool";
    private static volatile EmotionPanelViewPool sInstance;
    public static int widthPixels;
    private Map<Integer, ArrayList<View>> views;

    EmotionPanelViewPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.views = new ConcurrentHashMap();
        }
    }

    public static EmotionPanelViewPool getInstance() {
        if (sInstance == null) {
            synchronized (EmotionPanelViewPool.class) {
                if (sInstance == null) {
                    sInstance = new EmotionPanelViewPool();
                }
            }
        }
        return sInstance;
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "destory");
        }
        Map<Integer, ArrayList<View>> map = this.views;
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<Integer, ArrayList<View>>> it = this.views.entrySet().iterator();
            while (it.hasNext()) {
                ArrayList<View> value = it.next().getValue();
                if (value != null) {
                    value.clear();
                }
            }
            this.views.clear();
        }
    }

    public View getView(int i3) {
        ArrayList<View> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        Map<Integer, ArrayList<View>> map = this.views;
        if (map != null && map.containsKey(Integer.valueOf(i3)) && (arrayList = this.views.get(Integer.valueOf(i3))) != null && arrayList.size() > 0) {
            View remove = arrayList.remove(0);
            if (QLog.isColorLevel()) {
                Log.d(TAG, "getView from pool : paneyType = " + i3);
            }
            return remove;
        }
        return null;
    }

    public void release(int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) view);
            return;
        }
        if (view == null) {
            return;
        }
        Map<Integer, ArrayList<View>> map = this.views;
        if (map == null) {
            this.views = new ConcurrentHashMap();
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view);
            this.views.put(Integer.valueOf(i3), arrayList);
            return;
        }
        if (map.containsKey(Integer.valueOf(i3))) {
            ArrayList<View> arrayList2 = this.views.get(Integer.valueOf(i3));
            if (arrayList2 != null && !arrayList2.contains(view)) {
                arrayList2.add(0, view);
            }
        } else {
            ArrayList<View> arrayList3 = new ArrayList<>();
            arrayList3.add(0, view);
            this.views.put(Integer.valueOf(i3), arrayList3);
        }
        if (QLog.isColorLevel()) {
            Log.d(TAG, "relase view panelType = " + i3);
        }
    }
}
