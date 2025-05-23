package com.tencent.mobileqq.qqemoticon.api.impl;

import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class SystemAndEmojiPanelServiceImpl implements ISystemAndEmojiPanelService {
    static IPatchRedirector $redirector_;
    private AppRuntime mAppRuntime;

    /* loaded from: classes16.dex */
    class a implements ISystemAndEmojiPanelService.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private SystemAndEmojiUniversalPanel.Builder f263439a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemAndEmojiPanelServiceImpl.this);
            } else {
                this.f263439a = new SystemAndEmojiUniversalPanel.Builder(BaseApplication.context);
            }
        }

        @Override // com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.a
        public ISystemAndEmojiPanelService.a a(EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ISystemAndEmojiPanelService.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) editText);
            }
            this.f263439a.setShowDeleteButton(editText);
            return this;
        }

        @Override // com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.a
        public ISystemAndEmojiPanelService.a b(ISystemAndEmojiPanelService.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ISystemAndEmojiPanelService.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            }
            this.f263439a.setDispatchKeyEventListener(bVar);
            return this;
        }

        @Override // com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.a
        public ISystemAndEmojiPanelService.a c(EmoticonCallback emoticonCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ISystemAndEmojiPanelService.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonCallback);
            }
            this.f263439a.setEmoticonCallback(emoticonCallback);
            return this;
        }

        @Override // com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.a
        public IEmoticonPanel create() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (IEmoticonPanel) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f263439a.create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(SystemAndEmojiPanelServiceImpl.this.mAppRuntime));
        }
    }

    public SystemAndEmojiPanelServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService
    public ISystemAndEmojiPanelService.a newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ISystemAndEmojiPanelService.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mAppRuntime = null;
        }
    }
}
