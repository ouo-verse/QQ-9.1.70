package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DataReport {
    static IPatchRedirector $redirector_ = null;
    public static final int CONTINUOUS_DROP_TIMES = 5;
    public static final String EVENTCODE_SHORTVIDEO_PLAY = "ShortVideo.Play";
    public static final String PARAM_FRAM_DELAY_TIME = "param_framDelayTime";
    private final String TAG;
    private LinkedList<Integer> mList;

    public DataReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "URLDrawable_DataReport";
            this.mList = new LinkedList<>();
        }
    }

    private void doReport(LinkedList<Integer> linkedList) {
        long currentTimeMillis = System.currentTimeMillis();
        if (linkedList != null && linkedList.size() >= 5) {
            int size = linkedList.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                i3 += linkedList.get(i16).intValue();
            }
            int i17 = (int) (i3 / size);
            new HashMap().put(PARAM_FRAM_DELAY_TIME, String.valueOf(i17));
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d("URLDrawable_DataReport", 2, "doReport(), cost:" + currentTimeMillis2 + "ms, averageTime=" + i17);
            }
        }
    }

    public void onVideoFrameDroped(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        int size = this.mList.size();
        if (z16) {
            this.mList.add(Integer.valueOf(i3));
            if (size >= 5) {
                doReport(this.mList);
                this.mList.clear();
                return;
            }
            return;
        }
        if (size < 5) {
            this.mList.clear();
        } else {
            doReport(this.mList);
            this.mList.clear();
        }
    }
}
