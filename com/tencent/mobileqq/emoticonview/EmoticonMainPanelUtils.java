package com.tencent.mobileqq.emoticonview;

import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class EmoticonMainPanelUtils {
    static IPatchRedirector $redirector_;

    public EmoticonMainPanelUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IEmoticonMainPanel initEmojiPanel(QQAppInterface qQAppInterface, BaseActivity baseActivity, EditText editText, EmoticonCallback emoticonCallback) {
        IEmoticonMainPanel create = ((IEmoticonMainPanelService) qQAppInterface.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(baseActivity, 100002).setCallBack(emoticonCallback).setDisableGuide(true).setDisableMoreEmotionButton(true).setHasBigEmotion(false).setOnlySysAndEmoji(true).setDisableAutoDownload(true).setEmoticonListProvider(new EmoticonListProvider() { // from class: com.tencent.mobileqq.emoticonview.EmoticonMainPanelUtils.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
            public List<EmotionPanelInfo> getEmotionPanelInfo(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (List) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
                return arrayList;
            }
        }).create();
        create.setTabListOverScrollMode(2);
        return create;
    }
}
