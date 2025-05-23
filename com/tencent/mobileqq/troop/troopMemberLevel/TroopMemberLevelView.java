package com.tencent.mobileqq.troop.troopMemberLevel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.utils.a;
import com.tencent.mobileqq.widget.ColorNickTextView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberLevelView extends ColorNickTextView {
    static IPatchRedirector $redirector_;

    public TroopMemberLevelView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void setTroopMemberLevel(QQAppInterface qQAppInterface, boolean z16, String str, boolean z17, int i3, int i16) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (z16) {
            setTextColor(i16);
            if (i3 != -1) {
                IBizTroopMemberInfoService iBizTroopMemberInfoService = (IBizTroopMemberInfoService) qQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "");
                if (iBizTroopMemberInfoService != null) {
                    drawable = iBizTroopMemberInfoService.getTroopMemberLevelDrawable(i3, str);
                } else {
                    drawable = null;
                }
                if (drawable == null) {
                    drawable = a.a(getResources(), i3);
                    if (iBizTroopMemberInfoService != null) {
                        iBizTroopMemberInfoService.saveTroopMemberLevelDrawable(i3, str, drawable);
                    }
                }
                setBackgroundDrawable(drawable);
            }
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            setText(str);
            setContentDescription(HardCodeUtil.qqStr(R.string.jx6) + str);
            setMosaicEffect(null);
            return;
        }
        if (getVisibility() != 8) {
            setVisibility(8);
        }
        setMosaicEffect(null);
    }

    public TroopMemberLevelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TroopMemberLevelView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
