package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends ProfileTemplateBase {
    static IPatchRedirector $redirector_;

    public b(Activity activity, JSONObject jSONObject, ProfileCardInfo profileCardInfo) {
        super(activity, jSONObject, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, jSONObject, profileCardInfo);
        } else {
            this.f312975n = UIUtils.b(activity, 4.0f);
        }
    }

    @Override // com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
    public View C(JSONObject jSONObject, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject, (Object) view);
        }
        QZoneLayoutTemplate1 qZoneLayoutTemplate1 = (QZoneLayoutTemplate1) view.findViewById(R.id.dkt);
        if (qZoneLayoutTemplate1 != null) {
            qZoneLayoutTemplate1.setBorderWidth(f(jSONObject));
            qZoneLayoutTemplate1.setItemBg(d(jSONObject, b(100.0f), b(100.0f)), h(jSONObject));
            qZoneLayoutTemplate1.setLeftView(jSONObject.optString("ph"));
            qZoneLayoutTemplate1.setRightView(jSONObject.optString("ph"));
        }
        View findViewById = view.findViewById(R.id.icon);
        TextView textView = (TextView) view.findViewById(R.id.jj7);
        ImageView imageView = (ImageView) view.findViewById(R.id.dcv);
        String charSequence = textView.getText().toString();
        if (this.f312976o.allInOne.f260789pa != 0 && charSequence.length() > 4 && charSequence.substring(charSequence.length() - 4, charSequence.length()).equals("QQ\u7a7a\u95f4")) {
            textView.setText(charSequence.substring(0, charSequence.length() - 4) + HardCodeUtil.qqStr(R.string.u1u));
        }
        a(jSONObject, findViewById, textView, imageView);
        return view;
    }

    @Override // com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
    public ProfileCardFavorShowView g(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ProfileCardFavorShowView) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        }
        return new ProfileCardFavorShowView(activity, null, R.layout.be6);
    }

    @Override // com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
    public void o(HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap);
        } else {
            hashMap.put(IProfileContentKey.MAP_KEY_QZONE, this.f312970i.inflate(R.layout.bee, (ViewGroup) null));
        }
    }
}
