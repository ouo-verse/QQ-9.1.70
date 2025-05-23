package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes12.dex */
public class SystemAndEmojiEmoticonPanelWithActionBar extends SystemAndEmojiEmoticonPanel {
    static IPatchRedirector $redirector_;
    protected EmoticonCallback mCallback;
    protected View mSendBtn;

    public SystemAndEmojiEmoticonPanelWithActionBar(Context context, EmoticonCallback emoticonCallback) {
        super(context, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) emoticonCallback);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
    protected int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.hro;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel, com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
    public void initUI(Context context, EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) emoticonCallback);
            return;
        }
        super.initUI(context, emoticonCallback);
        this.mCallback = emoticonCallback;
        View findViewById = findViewById(R.id.send_btn);
        this.mSendBtn = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemAndEmojiEmoticonPanelWithActionBar.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    EmoticonCallback emoticonCallback2 = SystemAndEmojiEmoticonPanelWithActionBar.this.mCallback;
                    if (emoticonCallback2 != null) {
                        emoticonCallback2.send();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }
}
