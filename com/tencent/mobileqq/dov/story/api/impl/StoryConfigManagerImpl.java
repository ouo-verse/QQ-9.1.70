package com.tencent.mobileqq.dov.story.api.impl;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.h;
import com.tencent.biz.qqstory.model.i;
import com.tencent.mobileqq.dov.story.api.IStoryConfigManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StoryConfigManagerImpl implements IStoryConfigManager {
    static IPatchRedirector $redirector_;

    public StoryConfigManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dov.story.api.IStoryConfigManager
    public int getHighBitrate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return h.h();
    }

    @Override // com.tencent.mobileqq.dov.story.api.IStoryConfigManager
    public int getMaxUploadFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return h.i();
    }

    @Override // com.tencent.mobileqq.dov.story.api.IStoryConfigManager
    public <V> V getStoryValue(@NonNull String str, @NonNull V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) v3);
        }
        return (V) ((h) i.c(10)).j(str, v3);
    }
}
