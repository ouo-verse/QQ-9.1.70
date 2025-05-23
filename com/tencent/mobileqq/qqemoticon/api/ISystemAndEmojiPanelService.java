package com.tencent.mobileqq.qqemoticon.api;

import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonPanel;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {"all"})
/* loaded from: classes16.dex */
public interface ISystemAndEmojiPanelService extends IRuntimeService {

    /* loaded from: classes16.dex */
    public interface a {
        a a(EditText editText);

        a b(b bVar);

        a c(EmoticonCallback emoticonCallback);

        IEmoticonPanel create();
    }

    /* loaded from: classes16.dex */
    public interface b {
        boolean dispatchKeyEvent(KeyEvent keyEvent);
    }

    a newBuilder();
}
