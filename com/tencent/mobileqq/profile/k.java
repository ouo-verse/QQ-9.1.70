package com.tencent.mobileqq.profile;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.sigtopic.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f$UinItem;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final k f260196a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73791);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f260196a = new k();
            }
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(List<oidb_0xd9f$UinItem> list, oidb_0xd9f$UinItem oidb_0xd9f_uinitem) {
        if (oidb_0xd9f_uinitem == null) {
            return true;
        }
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).uint64_uin.get() == oidb_0xd9f_uinitem.uint64_uin.get()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static k d() {
        return a.f260196a;
    }

    public List<oidb_0xd9f$UinItem> b(List<oidb_0xd9f$TopicItem> list) {
        List<oidb_0xd9f$UinItem> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null && list.get(i3).rpt_frd_item.get() != null && (list2 = list.get(i3).rpt_frd_item.get()) != null) {
                    for (int i16 = 0; i16 < list2.size(); i16++) {
                        if (!a(arrayList, list2.get(i16))) {
                            arrayList.add(list2.get(i16));
                            if (arrayList.size() >= 3) {
                                return arrayList;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public int c(List<oidb_0xd9f$TopicItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list)).intValue();
        }
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            i3 += list.get(i16).uint32_frd_num.get();
        }
        return i3;
    }

    public long e(List<oidb_0xd9f$TopicItem> list) {
        List<oidb_0xd9f$UinItem> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this, (Object) list)).longValue();
        }
        long j3 = -1;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null && list.get(i3).rpt_frd_item.get() != null && (list2 = list.get(i3).rpt_frd_item.get()) != null) {
                    for (int i16 = 0; i16 < list2.size(); i16++) {
                        if (list2.get(i16).uint64_time.get() > j3) {
                            j3 = list2.get(i16).uint64_time.get();
                        }
                    }
                }
            }
        }
        return j3;
    }

    public Pair<Integer, String> f(List<oidb_0xd9f$TopicItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        int i3 = -1;
        String str = "";
        if (list != null && list.size() > 0) {
            String str2 = "";
            int i16 = -1;
            for (int i17 = 0; i17 < list.size(); i17++) {
                if (list.get(i17).uint32_frd_num.get() >= i16) {
                    i3 = list.get(i17).uint32_topic_id.get();
                    str2 = list.get(i17).str_topic.get();
                    i16 = list.get(i17).uint32_frd_num.get();
                }
            }
            str = str2;
        }
        return new Pair<>(Integer.valueOf(i3), str);
    }

    public CharSequence g(com.tencent.mobileqq.config.business.sigtopic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (CharSequence) iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<a.b> arrayList = aVar.a().f202831f;
        spannableStringBuilder.append((CharSequence) aVar.a().f202830e);
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                if (TextUtils.isEmpty(arrayList.get(i3).f202833b)) {
                    i3++;
                } else {
                    int length = spannableStringBuilder.length();
                    String str = arrayList.get(i3).f202833b;
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#4D94FF"));
                    spannableStringBuilder.append((CharSequence) str);
                    spannableStringBuilder.setSpan(foregroundColorSpan, length, str.length() + length, 33);
                    break;
                }
            } else {
                break;
            }
        }
        return spannableStringBuilder;
    }

    public boolean h(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, qQAppInterface, Long.valueOf(j3))).booleanValue();
        }
        if (j3 <= qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getLong(AppConstants.Preferences.COMMON_TOPIC_REFRESH_TIME, -1L)) {
            return false;
        }
        l(qQAppInterface, j3);
        return true;
    }

    public boolean i(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface)).booleanValue();
        }
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getBoolean(AppConstants.Preferences.SIG_WITH_TOPIC_BUBBLE_HAS_SHOWN, false);
    }

    public boolean j(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return !str.equals(str2);
    }

    public int k(TextView textView, String str, String str2, int i3, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, textView, str, str2, Integer.valueOf(i3), str3, Integer.valueOf(i16))).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        float f16 = i3;
        if (!TextUtils.isEmpty(str2)) {
            f16 += textView.getPaint().measureText(str2);
        }
        if (str3 != null && i16 > 0 && str3.length() >= i16) {
            f16 += textView.getPaint().measureText(str3.substring(0, i16));
        }
        float measureText = textView.getPaint().measureText(str);
        if (f16 >= textView.getWidth()) {
            return Integer.MIN_VALUE;
        }
        if (measureText + f16 >= textView.getWidth()) {
            return -((int) (f16 / 2.0f));
        }
        return (textView.getWidth() / 2) - ((int) (f16 + (measureText / 2.0f)));
    }

    public void l(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, qQAppInterface, Long.valueOf(j3));
            return;
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            QLog.e("SigTopicManager", 1, "refreshTopicUpdateTime fail, preference = null");
        } else {
            sharedPreferences.edit().putLong(AppConstants.Preferences.COMMON_TOPIC_REFRESH_TIME, j3).apply();
        }
    }

    public void m(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQAppInterface);
            return;
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            QLog.e("SigTopicManager", 1, "setHasShowBubble fail, preference = null");
        } else {
            sharedPreferences.edit().putBoolean(AppConstants.Preferences.SIG_WITH_TOPIC_BUBBLE_HAS_SHOWN, true).apply();
        }
    }

    public boolean n(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) qQAppInterface)).booleanValue();
        }
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getBoolean(AppConstants.Preferences.COMMON_TOPIC_FRIEND_LIST_SHOULD_SHOW, true);
    }

    public boolean o(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) qQAppInterface)).booleanValue();
        }
        if (qQAppInterface == null) {
            QLog.e("SigTopicManager", 1, "shouldShowRecommendTopic error, app is null");
            return false;
        }
        if (am.s().g(529, qQAppInterface.getCurrentAccountUin()) > qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getLong(AppConstants.Preferences.RECOMMEND_TOPIC_VERSION, -1L)) {
            return true;
        }
        return false;
    }

    public void p(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) qQAppInterface);
        } else if (qQAppInterface == null) {
            QLog.e("SigTopicManager", 1, "updateRecommendTopicVersion error, app is null");
        } else {
            qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit().putLong(AppConstants.Preferences.RECOMMEND_TOPIC_VERSION, am.s().g(529, qQAppInterface.getCurrentAccountUin())).apply();
        }
    }

    public void q(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qQAppInterface);
            return;
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            QLog.e("SigTopicManager", 1, "updateShouldNotShowCommonTopic fail, preference = null");
        } else {
            sharedPreferences.edit().putBoolean(AppConstants.Preferences.COMMON_TOPIC_FRIEND_LIST_SHOULD_SHOW, false).apply();
        }
    }

    public void r(QQAppInterface qQAppInterface, RichStatus richStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQAppInterface, (Object) richStatus);
            return;
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        String string = sharedPreferences.getString(AppConstants.Preferences.SIG_FEED_ID, "");
        if (richStatus != null && richStatus.feedsId != null) {
            if (d().j(string, richStatus.feedsId)) {
                sharedPreferences.edit().putString(AppConstants.Preferences.SIG_FEED_ID, richStatus.feedsId).apply();
                sharedPreferences.edit().putBoolean(AppConstants.Preferences.COMMON_TOPIC_FRIEND_LIST_SHOULD_SHOW, true).apply();
                return;
            }
            return;
        }
        if (d().j(string, "")) {
            sharedPreferences.edit().putString(AppConstants.Preferences.SIG_FEED_ID, "").apply();
            sharedPreferences.edit().putBoolean(AppConstants.Preferences.COMMON_TOPIC_FRIEND_LIST_SHOULD_SHOW, true).apply();
        }
    }
}
