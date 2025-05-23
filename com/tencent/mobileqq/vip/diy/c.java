package com.tencent.mobileqq.vip.diy;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import e15.f;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends f {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private String E;
    private String F;

    public c(String str, View view, String str2) {
        super(str, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, view, str2);
            return;
        }
        this.C = -1;
        this.D = -1;
        this.E = "";
        this.F = str2;
    }

    @Override // e15.f
    protected ViewGroup.LayoutParams k(ViewGroup.LayoutParams layoutParams, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutParams, (Object) jSONObject);
        }
        layoutParams.width = -1;
        layoutParams.height = -2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i3 = marginLayoutParams.leftMargin;
        marginLayoutParams.leftMargin = 0;
        View view = this.f395367e;
        if (view instanceof ProfileTemplateNickNameContainer) {
            ProfileTemplateNickNameContainer profileTemplateNickNameContainer = (ProfileTemplateNickNameContainer) view;
            profileTemplateNickNameContainer.setTextViewX(i3);
            if ("center_horizontal".equals(jSONObject.optString(LayoutAttrDefine.Gravity.Gravity))) {
                profileTemplateNickNameContainer.setTextCenter();
            }
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.m();
        View view = this.f395367e;
        if (view instanceof ProfileTemplateNickNameContainer) {
            ETTextViewPlus a16 = ((ProfileTemplateNickNameContainer) view).a();
            if (this.C > 0 && this.D > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "set name font id=" + this.C + " type=" + this.D);
                }
                a16.setFontAsync(this.C, this.D);
            } else {
                hd0.c.g("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "profile nick name set font error because font id=" + this.C + " type=" + this.D + " is illegal!");
            }
            ((ProfileTemplateNickNameContainer) this.f395367e).setTextBgUrl(this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if ("f".equals(str)) {
            try {
                this.C = Integer.parseInt(str2);
                if (QLog.isColorLevel()) {
                    QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "parse name font id=" + this.C);
                    return;
                }
                return;
            } catch (NumberFormatException e16) {
                hd0.c.g("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "pf_name font id illegal :" + str2 + " error=" + e16);
                return;
            }
        }
        if ("ft".equals(str)) {
            try {
                this.D = Integer.parseInt(str2);
                if (QLog.isColorLevel()) {
                    QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "parse name font type=" + this.D);
                    return;
                }
                return;
            } catch (NumberFormatException e17) {
                hd0.c.g("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "pf_name font type illegal :" + str2 + " error=" + e17);
                return;
            }
        }
        if (VasProfileTemplatePreloadHelper.BACKGROUND.equals(str)) {
            this.E = str2;
        } else {
            super.q(str, str2);
        }
    }
}
