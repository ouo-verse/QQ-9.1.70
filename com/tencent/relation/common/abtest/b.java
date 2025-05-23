package com.tencent.relation.common.abtest;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f364657a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f364657a = new String[]{"exp_kl_star_profile_add_frd", "exp_kl_profile_UI", "exp_kl_new_welcome_guide", "exp_search_people_jieban_entrance", "exp_kl_homepage_welcome_part", "exp_qqprofile_homepage_ui", "exp_qqprofile_relation", "exp_kuolie_new_feature"};
        }
    }

    public static List<String> a() {
        return new ArrayList(Arrays.asList(f364657a));
    }
}
