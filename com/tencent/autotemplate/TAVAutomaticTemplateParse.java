package com.tencent.autotemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* loaded from: classes3.dex */
public class TAVAutomaticTemplateParse {
    static IPatchRedirector $redirector_;
    private static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12354);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = TAVAutomaticTemplateParse.class.getCanonicalName();
        }
    }

    public TAVAutomaticTemplateParse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TAVAutomaticTemplate parseAutomaticTemplate(@NonNull String str) {
        return (TAVAutomaticTemplate) JsonUtils.parseObjectFromFile(null, str, TAVAutomaticTemplate.class);
    }

    public static TAVRhythmAutomaticTemplate parseRhythmAutomaticTemplate(@NonNull String str, @NonNull String str2) {
        TAVRhythmAutomaticTemplate tAVRhythmAutomaticTemplate = (TAVRhythmAutomaticTemplate) JsonUtils.parseObjectFromFile(null, str + "/" + str2, TAVRhythmAutomaticTemplate.class);
        if (tAVRhythmAutomaticTemplate == null) {
            return null;
        }
        tAVRhythmAutomaticTemplate.setTemplateDir(str);
        return tAVRhythmAutomaticTemplate;
    }

    public static TAVAutomaticTemplate parseAutomaticTemplate(@NonNull String str, @NonNull String str2) {
        TAVAutomaticTemplate tAVAutomaticTemplate = (TAVAutomaticTemplate) JsonUtils.parseObjectFromFile(null, str + "/" + str2, TAVAutomaticTemplate.class);
        tAVAutomaticTemplate.setTemplateDir(str);
        return tAVAutomaticTemplate;
    }

    public static TAVRhythmAutomaticTemplate parseRhythmAutomaticTemplate(@Nullable Context context, @NonNull String str, @NonNull String str2) {
        TAVRhythmAutomaticTemplate tAVRhythmAutomaticTemplate = (TAVRhythmAutomaticTemplate) JsonUtils.parseObjectFromFile(context, str + "/" + str2, TAVRhythmAutomaticTemplate.class);
        if (tAVRhythmAutomaticTemplate == null) {
            return null;
        }
        tAVRhythmAutomaticTemplate.setTemplateDir(str);
        return tAVRhythmAutomaticTemplate;
    }

    public static TAVAutomaticTemplate parseAutomaticTemplate(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        TAVAutomaticTemplate tAVAutomaticTemplate = (TAVAutomaticTemplate) JsonUtils.parseObjectFromFile(context, str + File.separator + str2, TAVAutomaticTemplate.class);
        if (tAVAutomaticTemplate != null) {
            tAVAutomaticTemplate.setContext(context);
            tAVAutomaticTemplate.setTemplateDir(str);
        } else {
            Log.d(TAG, "parseAutomaticTemplate error, TAVAutomaticTemplate Object is null, Please template config file.");
        }
        return tAVAutomaticTemplate;
    }

    public static TAVRhythmAutomaticTemplate parseRhythmAutomaticTemplate(@NonNull String str) {
        return (TAVRhythmAutomaticTemplate) JsonUtils.parseObjectFromFile(null, str, TAVRhythmAutomaticTemplate.class);
    }
}
