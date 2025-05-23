package com.tencent.mobileqq.emoticonview;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public class PanelRecycleBin {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_CAPACITY = 3;
    private ArrayList<View> mScrapViews;

    public PanelRecycleBin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mScrapViews = new ArrayList<>();
        }
    }

    public void addScrapView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            if (this.mScrapViews.size() >= 3) {
                return;
            }
            this.mScrapViews.add(view);
        }
    }

    public void clearScrapViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mScrapViews.clear();
        }
    }

    public View getScrapView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.mScrapViews.size() > 0) {
            return this.mScrapViews.remove(0);
        }
        return null;
    }

    public int getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mScrapViews.size();
    }
}
