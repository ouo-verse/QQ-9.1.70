package com.tencent.mobileqq.tribe.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* loaded from: classes19.dex */
public class TribeVideoPublishParams implements Serializable {
    static IPatchRedirector $redirector_;
    public static final String BUNDLE_EXTRA_KEY;
    public int beauty;
    public ChangeFace changeFace;
    public ComboInfo combo0Info;
    public Filter filter;
    public boolean hasFace;
    public boolean hasGraffiti;
    public boolean hasText;
    public boolean isSoundOn;
    public Music music;

    /* loaded from: classes19.dex */
    public static class ChangeFace implements Serializable {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public String f293474id;
        public String type;

        public ChangeFace() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class ComboInfo implements Serializable {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public String f293475id;
        public String name;
        public String type;

        public ComboInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class Filter implements Serializable {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public String f293476id;
        public String name;
        public String typeId;

        public Filter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class Music implements Serializable {
        static IPatchRedirector $redirector_;
        public String name;
        public String type;

        public Music() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25975);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            BUNDLE_EXTRA_KEY = TribeVideoPublishParams.class.getName();
        }
    }

    public TribeVideoPublishParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
