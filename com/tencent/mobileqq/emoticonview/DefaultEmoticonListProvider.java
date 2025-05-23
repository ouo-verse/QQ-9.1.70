package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class DefaultEmoticonListProvider implements EmoticonListProvider {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DefaultEmoticonListProvider";
    private EmoticonPanelController mController;

    public DefaultEmoticonListProvider(EmoticonPanelController emoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
        } else {
            this.mController = emoticonPanelController;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
    public List<EmotionPanelInfo> getEmotionPanelInfo(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        if (!z17 && !this.mController.getParams().mIsOnlySysEmotion) {
            if (com.tencent.mobileqq.emosm.h.a()) {
                List<EmotionPanelInfo> allEmotionPanelData = EmoticonTabNtUtils.INSTANCE.getAllEmotionPanelData(this.mController);
                if (!z16) {
                    for (int size = allEmotionPanelData.size() - 1; size >= 0; size--) {
                        int i3 = allEmotionPanelData.get(size).type;
                        if (i3 == 17 || i3 == 10 || i3 == 6) {
                            allEmotionPanelData.remove(size);
                        }
                    }
                }
                if (allEmotionPanelData.size() > 0) {
                    return allEmotionPanelData;
                }
                QLog.e(TAG, 1, "[getEmotionPanelInfo(ignore big emotion)]from nt kernel error, try use old panel data!");
            }
            if (!z16) {
                EmoticonPanelController emoticonPanelController = this.mController;
                return EmoticonUtils.getNonBigEmotionPanelData(emoticonPanelController.app, emoticonPanelController.getEmotionPanelManager());
            }
            EmoticonPanelController emoticonPanelController2 = this.mController;
            return EmoticonUtils.getAllEmotionPanelData(emoticonPanelController2.app, emoticonPanelController2.getEmotionPanelManager(), this.mController.getBusinessType(), this.mController.getKanDianBiu());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
        return arrayList;
    }
}
