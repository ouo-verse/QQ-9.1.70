package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class EmotionPanelListViewPool {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionPanelListViewPool";
    private static EmotionPanelListViewPool sInstance;
    private List<EmotionPanelListView> listViews;

    EmotionPanelListViewPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.listViews = new ArrayList();
        }
    }

    public static EmotionPanelListViewPool getInstance() {
        if (sInstance == null) {
            synchronized (EmotionPanelListViewPool.class) {
                if (sInstance == null) {
                    sInstance = new EmotionPanelListViewPool();
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
            QLog.d(TAG, 4, "destory");
        }
        List<EmotionPanelListView> list = this.listViews;
        if (list != null) {
            list.clear();
            this.listViews = null;
        }
    }

    public EmotionPanelListView getListView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EmotionPanelListView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        List<EmotionPanelListView> list = this.listViews;
        if (list != null && list.size() > 0) {
            EmotionPanelListView remove = this.listViews.remove(0);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "from listview pool and poolSize = " + this.listViews.size());
            }
            return remove;
        }
        return new EmotionPanelListView(context);
    }

    public void relase(EmotionPanelListView emotionPanelListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emotionPanelListView);
            return;
        }
        if (emotionPanelListView == null) {
            return;
        }
        List<EmotionPanelListView> list = this.listViews;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.listViews = arrayList;
            arrayList.add(emotionPanelListView);
        } else if (!list.contains(emotionPanelListView)) {
            this.listViews.add(0, emotionPanelListView);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "relase listview");
        }
    }
}
