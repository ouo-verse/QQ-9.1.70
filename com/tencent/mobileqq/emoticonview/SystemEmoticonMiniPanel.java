package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public class SystemEmoticonMiniPanel extends SystemEmoticonPanel {
    static IPatchRedirector $redirector_;

    public SystemEmoticonMiniPanel(Context context, EmoticonCallback emoticonCallback, boolean z16) {
        super(context, emoticonCallback, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, emoticonCallback, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
    protected void initUI(Context context, EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) emoticonCallback);
            return;
        }
        this.pageRadioGroup = (EmoticonPagerRadioGroup) this.root.findViewById(R.id.f166754hv2);
        ViewPager viewPager = (ViewPager) this.root.findViewById(R.id.viewPager);
        this.viewPager = viewPager;
        this.pageRadioGroup.setViewPager(viewPager);
        this.pageAdapter = new EmoticonPagerAdapter();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new SystemEmoticonPanelMiniBinder(context, emoticonCallback, 0, this.mIsHighDifinition));
        this.pageAdapter.setViewBinderList(arrayList);
        this.viewPager.setAdapter(this.pageAdapter);
        this.viewPager.setCurrentItem(0);
        this.pageRadioGroup.synButton(this.pageAdapter.getF373114d());
    }
}
