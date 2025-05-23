package com.tencent.mobileqq.leba;

import android.widget.TextView;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f240605a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<Long, String> f240606b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f240605a = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=" + PluginBaseInfoHelper.Base64Helper.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0);
        HashMap<Long, String> hashMap = new HashMap<>();
        f240606b = hashMap;
        hashMap.put(1047L, "biz_src_qqmusic");
        f240606b.put(5362L, "biz_src_zz_dianjing");
        f240606b.put(1113L, "biz_src_zz_bodong");
        f240606b.put(3053L, "biz_src_zf_dongtai_qianbao");
        f240606b.put(763L, "biz_src_zf_dongtai_qianbao");
        f240606b.put(883L, "biz_src_zf_dongtai_qianbao");
        f240606b.put(4559L, "biz_src_zf_sport");
        f240606b.put(826L, "biz_src_feeds_buluo");
        f240606b.put(489L, "biz_src_zf_games");
        f240606b.put(879L, "biz_src_hdsp_dtzbj");
        f240606b.put(769L, "biz_src_jc_neirong");
    }

    public static int a(RedTouch redTouch) {
        TextView textView;
        if (redTouch == null || (textView = redTouch.lebaTvAssists) == null || textView.getVisibility() != 0) {
            return 0;
        }
        return 1;
    }

    public static int b(RedTouch redTouch) {
        List<BusinessInfoCheckUpdate.RedTypeInfo> redTypeInfo;
        if (redTouch == null || !redTouch.hasLebaRedTouch() || (redTypeInfo = redTouch.getRedTypeInfo()) == null || redTypeInfo.isEmpty()) {
            return 0;
        }
        int outerRedType = redTouch.getOuterRedType();
        if (outerRedType == 16) {
            return 9;
        }
        if (outerRedType == 17) {
            return 10;
        }
        Iterator<BusinessInfoCheckUpdate.RedTypeInfo> it = redTypeInfo.iterator();
        while (it.hasNext()) {
            int i3 = it.next().red_type.get();
            if (i3 == 0) {
                return 1;
            }
            if (i3 == 5) {
                return 2;
            }
            if (i3 == 11) {
                break;
            }
        }
        return 3;
    }
}
