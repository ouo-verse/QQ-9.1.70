package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public class SystemAndEmojiEmoticonPanel extends SystemEmoticonPanel {
    static IPatchRedirector $redirector_;

    public SystemAndEmojiEmoticonPanel(Context context, EmoticonCallback emoticonCallback) {
        super(context, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) emoticonCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
    public void initUI(Context context, EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) emoticonCallback);
            return;
        }
        this.pageRadioGroup = (EmoticonPagerRadioGroup) this.root.findViewById(R.id.f166754hv2);
        this.viewPager = (ViewPager) this.root.findViewById(R.id.viewPager);
        this.pageAdapter = new EmoticonPagerAdapter();
        ArrayList arrayList = new ArrayList(1);
        ClassicEmoticonPanelViewBinder classicEmoticonPanelViewBinder = new ClassicEmoticonPanelViewBinder(context, emoticonCallback, 9);
        arrayList.add(classicEmoticonPanelViewBinder);
        this.pageAdapter.setViewBinderList(arrayList);
        this.viewPager.setAdapter(this.pageAdapter);
        this.pageRadioGroup.setViewPager(this.viewPager);
        this.pageRadioGroup.synClassicButton(classicEmoticonPanelViewBinder.getSystemPageCount(), classicEmoticonPanelViewBinder.getPanelPageCount());
        this.viewPager.setCurrentItem(9);
    }
}
