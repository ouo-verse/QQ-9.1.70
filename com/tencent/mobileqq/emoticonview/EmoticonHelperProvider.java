package com.tencent.mobileqq.emoticonview;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class EmoticonHelperProvider implements IEmoticonHelperProvider {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "EmoticonHelperProvider";
    private static final int THRESHOLD = 5;
    private SparseArrayCompat<AbstractEmoticonPanelHelper> helpers;
    private SparseArrayCompat<SparseArrayCompat<AbstractEmoticonPanelHelper>> lifecycleObservers;

    public EmoticonHelperProvider(EmoticonPanelController emoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
            return;
        }
        this.lifecycleObservers = new SparseArrayCompat<>(10);
        this.helpers = new SparseArrayCompat<>();
        register(1, new EmoticonPanelExtendHelper(emoticonPanelController));
        register(2, new EmoticonPanelFavHelper(emoticonPanelController));
        register(3, new EmoticonPanelSystemAndEmojiHelper(emoticonPanelController));
        register(4, new EmoticonPanelMallHelper(emoticonPanelController));
        register(5, new EmoticonPanelSettingHelper(emoticonPanelController));
        register(6, new EmoticonPanelHotPicSearchHelper(emoticonPanelController));
        register(7, new EmoticonPanelTabSortHelper(emoticonPanelController));
        register(9, new EmoticonReportDtHelper(emoticonPanelController));
        register(10, new com.tencent.mobileqq.popanim.a(emoticonPanelController));
        register(13, new EmoticonPanelAIHelper(emoticonPanelController));
    }

    private void check(int i3) {
        if (this.helpers.get(i3) == null) {
            return;
        }
        throw new IllegalArgumentException("emoticon helper already exist with id: " + i3);
    }

    private void dispatchSate(AbstractEmoticonPanelHelper abstractEmoticonPanelHelper, int i3, int i16, boolean z16) {
        switch (i3) {
            case 1:
                abstractEmoticonPanelHelper.initBefore();
                return;
            case 2:
                abstractEmoticonPanelHelper.initAfter();
                return;
            case 3:
                abstractEmoticonPanelHelper.onPageSelected(i16);
                return;
            case 4:
                abstractEmoticonPanelHelper.onHide(z16);
                return;
            case 5:
                abstractEmoticonPanelHelper.onShow();
                return;
            case 6:
                abstractEmoticonPanelHelper.onResume();
                return;
            case 7:
                abstractEmoticonPanelHelper.onPause();
                return;
            case 8:
                abstractEmoticonPanelHelper.onDestory();
                return;
            case 9:
                abstractEmoticonPanelHelper.onAttachedToWindow();
                return;
            case 10:
                abstractEmoticonPanelHelper.onDetachedFromWindow();
                return;
            case 11:
                abstractEmoticonPanelHelper.onPullDown();
                return;
            case 12:
                abstractEmoticonPanelHelper.onPullUp();
                return;
            case 13:
                abstractEmoticonPanelHelper.onItemTabClick(i16);
                return;
            case 14:
                abstractEmoticonPanelHelper.onShowPageFinish();
                return;
            default:
                return;
        }
    }

    public void dispatchLifeCycle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            dispatchLifeCycle(i3, -1, false);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonHelperProvider
    public <T extends AbstractEmoticonPanelHelper> T getHelper(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return (T) this.helpers.get(i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonHelperProvider
    public void register(int i3, AbstractEmoticonPanelHelper abstractEmoticonPanelHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) abstractEmoticonPanelHelper);
            return;
        }
        this.helpers.put(i3, abstractEmoticonPanelHelper);
        for (int i16 : abstractEmoticonPanelHelper.interestedIn()) {
            SparseArrayCompat<AbstractEmoticonPanelHelper> sparseArrayCompat = this.lifecycleObservers.get(i16);
            if (sparseArrayCompat == null) {
                sparseArrayCompat = new SparseArrayCompat<>();
                this.lifecycleObservers.put(i16, sparseArrayCompat);
            }
            sparseArrayCompat.put(i3, abstractEmoticonPanelHelper);
        }
    }

    public void dispatchLifeCycle(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        SparseArrayCompat<AbstractEmoticonPanelHelper> sparseArrayCompat = this.lifecycleObservers.get(i3);
        if (sparseArrayCompat == null) {
            return;
        }
        int size = sparseArrayCompat.size();
        for (int i17 = 0; i17 < size; i17++) {
            dispatchSate(sparseArrayCompat.valueAt(i17), i3, i16, z16);
        }
    }
}
