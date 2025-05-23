package com.tencent.mobileqq.service.lbs;

import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static ArrayList<CardProfile> a(List<CardProfile> list, List<CardProfile> list2) {
        HashSet hashSet = new HashSet();
        ArrayList<CardProfile> arrayList = new ArrayList<>();
        for (CardProfile cardProfile : list) {
            hashSet.add(Long.valueOf(cardProfile.lEctID));
            arrayList.add(cardProfile);
        }
        for (CardProfile cardProfile2 : list2) {
            if (!hashSet.contains(Long.valueOf(cardProfile2.lEctID))) {
                arrayList.add(cardProfile2);
            }
        }
        return arrayList;
    }
}
