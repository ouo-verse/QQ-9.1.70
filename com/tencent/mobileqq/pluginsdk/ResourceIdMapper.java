package com.tencent.mobileqq.pluginsdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class ResourceIdMapper {
    static IPatchRedirector $redirector_ = null;
    public static final int RES_ID_ANIM_BOTTOM_IN = 2;
    public static final int RES_ID_ANIM_BOTTOM_OUT = 7;
    public static final int RES_ID_ANIM_FADE_IN = 0;
    public static final int RES_ID_ANIM_FADE_OUT = 1;
    public static final int RES_ID_ANIM_LEFT_IN = 5;
    public static final int RES_ID_ANIM_LEFT_OUT = 4;
    public static final int RES_ID_ANIM_RIGHT_IN = 3;
    public static final int RES_ID_ANIM_RIGHT_OUT = 6;
    public static final int RES_ID_STYLE_BOTTOM_IN_OUT = 8;
    public static final ResourceIdMapperFactory sFactory;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class ResourceIdMapperFactory {
        static IPatchRedirector $redirector_;

        public ResourceIdMapperFactory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public ResourceIdMapper getInstance(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ResourceIdMapper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            try {
                return (ResourceIdMapper) Class.forName(str).newInstance();
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
                return null;
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
                return null;
            } catch (InstantiationException e18) {
                e18.printStackTrace();
                return null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16479);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sFactory = new ResourceIdMapperFactory();
        }
    }

    public ResourceIdMapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract int getHostResourceId(int i3);
}
