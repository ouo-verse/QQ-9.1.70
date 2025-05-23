package com.tencent.mobileqq.profilecard.utils;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class ProfileEditPrivacyHelper {
    static IPatchRedirector $redirector_;
    private final HashMap<Integer, TextView> profileViewMap;

    public ProfileEditPrivacyHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.profileViewMap = new HashMap<>();
        }
    }

    private void updateTextView(TextView textView, CharSequence charSequence) {
        updateTextView(textView, charSequence, textView.getResources().getColor(R.color.qui_common_text_secondary));
    }

    public ProfileEditPrivacyHelper addView(int i3, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProfileEditPrivacyHelper) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) textView);
        }
        this.profileViewMap.remove(Integer.valueOf(i3));
        this.profileViewMap.put(Integer.valueOf(i3), textView);
        return this;
    }

    public void onHide(int i3) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else if (this.profileViewMap.containsKey(Integer.valueOf(i3)) && (textView = this.profileViewMap.get(Integer.valueOf(i3))) != null) {
            updateTextView(textView, "");
        }
    }

    private void updateTextView(TextView textView, CharSequence charSequence, int i3) {
        textView.setTextColor(i3);
        textView.setText(charSequence);
        textView.setContentDescription(charSequence);
    }
}
