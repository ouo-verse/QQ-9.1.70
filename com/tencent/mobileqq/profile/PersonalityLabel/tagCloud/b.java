package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.text.Spannable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class a implements Comparator<Pair<Long, String>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<Long, String> pair, Pair<Long, String> pair2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair, (Object) pair2)).intValue();
            }
            return b.d((CharSequence) pair.second) - b.d((CharSequence) pair2.second);
        }
    }

    private static boolean a(String str) {
        if (!f(str)) {
            return false;
        }
        return true;
    }

    public static int b(Random random, int i3, int i16) {
        return random.nextInt(i16 - i3) + i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x015d, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x015b, code lost:
    
        if (r1 <= 12) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0152, code lost:
    
        if (r1 <= 8) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015f, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(List<com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a> list, ProfilePersonalityLabelInfo profilePersonalityLabelInfo, float f16) {
        List<PersonalityLabelInfo> list2;
        long j3;
        int i3;
        boolean z16;
        int i16;
        int i17;
        int i18;
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo2 = profilePersonalityLabelInfo;
        if (profilePersonalityLabelInfo2 != null && (list2 = profilePersonalityLabelInfo2.personalityLabelInfos) != null && list2.size() > 0) {
            ArrayList arrayList = new ArrayList(profilePersonalityLabelInfo.getSize());
            int i19 = 0;
            for (int i26 = 0; i26 < profilePersonalityLabelInfo2.personalityLabelInfos.size(); i26++) {
                arrayList.add(new Pair(Long.valueOf(profilePersonalityLabelInfo2.personalityLabelInfos.get(i26).f259897id), profilePersonalityLabelInfo2.personalityLabelInfos.get(i26).text));
            }
            Collections.sort(arrayList, new a());
            int size = profilePersonalityLabelInfo.getSize();
            boolean z17 = !TextUtils.isEmpty(profilePersonalityLabelInfo.getLatestThumbUrl());
            long j16 = -1;
            if (z17) {
                j3 = profilePersonalityLabelInfo2.personalityLabelInfos.get(0).f259897id;
            } else {
                j3 = -1;
            }
            if (z17) {
                if (profilePersonalityLabelInfo.getSize() > 1) {
                    j16 = profilePersonalityLabelInfo2.personalityLabelInfos.get(1).f259897id;
                }
            } else {
                j16 = profilePersonalityLabelInfo2.personalityLabelInfos.get(0).f259897id;
            }
            Random random = new Random();
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i27 < arrayList.size()) {
                ArrayList arrayList2 = arrayList;
                int i38 = i19;
                PersonalityLabelInfo labelById = profilePersonalityLabelInfo2.getLabelById(((Long) ((Pair) arrayList.get(i27)).first).longValue());
                if (labelById == null || TextUtils.isEmpty(labelById.text)) {
                    i19 = i38;
                } else {
                    String trim = labelById.text.trim();
                    com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar = new com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a();
                    aVar.f259971c = trim;
                    boolean f17 = f(trim);
                    long j17 = labelById.f259897id;
                    if (j3 == j17) {
                        aVar.f259979k = labelById.bgColor;
                        aVar.f259987s = 2;
                    } else if (j16 == j17) {
                        aVar.f259983o = true;
                        aVar.f259981m.setFakeBoldText(true);
                    }
                    aVar.f259978j = labelById.fgColor;
                    if (aVar.f259987s == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!(trim instanceof Spannable) && f17 && ((!z16 || trim.length() <= 4) && (z16 || trim.length() <= 6))) {
                        i16 = 1;
                    } else {
                        i16 = 1;
                        aVar.f259970b = true;
                        aVar.f259988t = true;
                        i28++;
                    }
                    boolean z18 = i16;
                    if (!aVar.f259988t) {
                        if (size > i16) {
                            if (i29 < 2 && i29 != size - 1 && trim.length() <= 6) {
                                aVar.f259970b = random.nextBoolean();
                                if (aVar.f259970b) {
                                    i29++;
                                } else {
                                    i28++;
                                }
                            } else {
                                z18 = 1;
                            }
                        }
                        aVar.f259970b = z18;
                        if (aVar.f259970b) {
                        }
                    }
                    h(aVar);
                    int d16 = d(trim);
                    if (z16) {
                        if (d16 > 6) {
                        }
                        i17 = 2;
                    } else {
                        if (d16 > 8) {
                        }
                        i17 = 2;
                    }
                    if (i17 == 2 && i36 >= 3) {
                        i17 = 1;
                    }
                    if (size <= 1) {
                        i17 = 2;
                    }
                    if (i17 == 2) {
                        i36++;
                    }
                    if (size <= 3 && i17 == 0 && i37 < 2) {
                        i17 = 1;
                    }
                    if (i37 + i36 < 2 && i17 == 0) {
                        i17 = 1;
                    }
                    if (i37 >= 4 && (i37 >= 6 || d16 >= 10 || (d16 >= 8 && random.nextBoolean()))) {
                        i17 = -1;
                    }
                    if (i17 > 0) {
                        i37++;
                    }
                    int e16 = e(random, i17);
                    if (size <= 3 && d16 < 8) {
                        i19 = i38;
                        if (i19 < 2) {
                            i18 = 48;
                            e16 = 48;
                            if (e16 == i18) {
                                i19++;
                            }
                            float f18 = e16 * f16;
                            aVar.f259977i = f18;
                            aVar.f259981m.setTextSize(f18);
                            if (QLog.isColorLevel()) {
                                QLog.i("TagUtil", 2, "getTags " + ((Object) aVar.f259971c) + " sizeLevel:" + i17 + " size:" + (aVar.f259977i / f16));
                            }
                            list.add(aVar);
                        }
                    } else {
                        i19 = i38;
                    }
                    i18 = 48;
                    if (e16 == i18) {
                    }
                    float f182 = e16 * f16;
                    aVar.f259977i = f182;
                    aVar.f259981m.setTextSize(f182);
                    if (QLog.isColorLevel()) {
                    }
                    list.add(aVar);
                }
                i27++;
                profilePersonalityLabelInfo2 = profilePersonalityLabelInfo;
                arrayList = arrayList2;
            }
            ArrayList arrayList3 = arrayList;
            if (i28 == 0) {
                com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar2 = list.get(0);
                i3 = 1;
                aVar2.f259970b = true;
                h(aVar2);
            } else {
                i3 = 1;
            }
            if (i29 == 0 && size > i3) {
                int i39 = 0;
                while (true) {
                    if (i39 >= list.size()) {
                        break;
                    }
                    com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar3 = list.get(i39);
                    if (!aVar3.f259988t && aVar3.f259971c.length() <= 4) {
                        aVar3.f259970b = false;
                        if (!f(aVar3.f259971c)) {
                            aVar3.f259980l = 0;
                        } else {
                            aVar3.f259980l = 4;
                        }
                        i29++;
                    } else {
                        i39++;
                    }
                }
            }
            if (i29 <= 1) {
                int i46 = 0;
                while (i46 < list.size() && i46 < arrayList3.size()) {
                    com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar4 = list.get(i46);
                    ArrayList arrayList4 = arrayList3;
                    String str = (String) ((Pair) arrayList4.get(i46)).second;
                    if (aVar4.f259970b && a(str)) {
                        com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar5 = new com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a();
                        aVar5.f259971c = str;
                        aVar5.f259982n = true;
                        aVar5.f259970b = false;
                        aVar5.f259977i = aVar4.f259977i;
                        aVar5.f259981m.setTextSize(aVar4.f259977i);
                        list.add(aVar5);
                        i29++;
                        if (i29 >= 2) {
                            return;
                        }
                    }
                    i46++;
                    arrayList3 = arrayList4;
                }
            }
        }
    }

    public static int d(CharSequence charSequence) {
        String str;
        if (charSequence instanceof Spannable) {
            str = charSequence.toString();
        } else {
            str = (String) charSequence;
        }
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length()) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt <= 126) {
                i16++;
            } else if (codePointAt >= 65535) {
                i16++;
                i3++;
            } else {
                i16 += 2;
            }
            i3++;
        }
        return i16;
    }

    public static int e(Random random, int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return 0;
                    }
                    return b(random, 40, 48);
                }
                return b(random, 30, 40);
            }
            return b(random, 22, 30);
        }
        return b(random, 18, 24);
    }

    public static boolean f(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            int codePointAt = charSequence2.codePointAt(i3);
            if (codePointAt < 19968 || codePointAt > 40959) {
                return false;
            }
        }
        return true;
    }

    public static boolean g() {
        return DeviceInfoMonitor.getModel().contains("vivo X6D");
    }

    private static void h(com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.a aVar) {
        boolean f16 = f(aVar.f259971c);
        if ((aVar.f259970b && aVar.f259971c.length() <= 5) || !f16) {
            aVar.f259980l = 0;
        } else {
            aVar.f259980l = 4;
        }
    }
}
