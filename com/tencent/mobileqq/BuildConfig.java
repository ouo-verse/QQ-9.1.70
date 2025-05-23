package com.tencent.mobileqq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class BuildConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_PATCH_ID = "20250427222402783";

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f154060a;

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f154061b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42746);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f154060a = new HashSet<String>() { // from class: com.tencent.mobileqq.BuildConfig.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    } else {
                        add("qqminisearch_feature.apk");
                    }
                }
            };
            f154061b = new ArrayList<String>() { // from class: com.tencent.mobileqq.BuildConfig.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    add("AQQLiteApp");
                    add("kandian_feature_impl");
                    add("aelight_impl");
                    add("qqpay_temp_impl");
                    add("qqmini_impl");
                    add("qqrtc_feature_impl");
                    add("qq_comic_impl");
                    add("cmshow_impl");
                    add("zplan_impl");
                    add("webview_impl");
                    add("qqpubaccount_impl");
                    add("qqnearby_impl");
                    add("qqweishi_impl");
                    add("qqexpand_impl");
                    add("wxmini_impl");
                    add("profilecard_feature_impl");
                    add("qq_selectfriend_impl");
                    add("relation_common_business_impl");
                    add("matchfriend_impl");
                    add("mutualmark_impl");
                    add("qq_winkpublish_impl");
                    add("qqecommerce_impl");
                    add("qqecommerce_shell_impl");
                    add("qzone_df_impl");
                    add("qqguild_df_impl");
                    add("qq_setting_impl");
                    add("qq_nearby_pro_df_impl");
                    add("base_proj_ext_impl");
                    add("base_proj_nt_ext_impl");
                    add("qqfriend_impl");
                    add("qq_deprecated_impl");
                }
            };
        }
    }

    public BuildConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
