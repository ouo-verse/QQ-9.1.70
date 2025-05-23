package com.qzone.homepage.ui.Facade.model;

import NS_MOBILE_CUSTOM.ProfileRect;
import android.text.TextUtils;
import com.qzone.homepage.ui.Facade.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class ProfileRectArea extends _ProfileRectArea {
    private static ArrayList<ConfigArea> getFilledProfileRect(ArrayList<ConfigArea> arrayList) {
        ArrayList<ConfigArea> arrayList2 = new ArrayList<>();
        Iterator<ConfigArea> it = arrayList.iterator();
        while (it.hasNext()) {
            ConfigArea next = it.next();
            if (!TextUtils.isEmpty(next.defaultText)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    private static void rearrangeConfigLocationHorizontal(ProfileRectArea profileRectArea, ArrayList<ConfigArea> arrayList) {
        Iterator<ConfigArea> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().f47629wp;
        }
        int i16 = profileRectArea.mWp - i3;
        int i17 = profileRectArea.mXp + i16;
        Iterator<ConfigArea> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            i17 = rearrangeSingleRectHorizontal(i16, i17, it5.next());
        }
    }

    private static void rearrangeConfigLocationVertical(ProfileRectArea profileRectArea, ArrayList<ConfigArea> arrayList) {
        Iterator<ConfigArea> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().f47628hp;
        }
        int i16 = profileRectArea.mHp - i3;
        int i17 = profileRectArea.mYp + i16;
        Iterator<ConfigArea> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            i17 = rearrangeSingleRectVertical(i16, i17, it5.next());
        }
    }

    private static int rearrangeSingleRectHorizontal(int i3, int i16, ConfigArea configArea) {
        configArea.f47630xp = i16;
        return i16 + configArea.f47629wp + i3;
    }

    private static int rearrangeSingleRectVertical(int i3, int i16, ConfigArea configArea) {
        configArea.f47631yp = i16;
        return i16 + configArea.f47628hp + i3;
    }

    public static ProfileRectArea createFromJce(ProfileRect profileRect) {
        if (profileRect == null) {
            return null;
        }
        ProfileRectArea profileRectArea = new ProfileRectArea();
        profileRectArea.mAlignType = profileRect.eAlignType;
        profileRectArea.mIndexContainer = profileRect.vecIndexContainer;
        profileRectArea.mWp = profileRect.iWp;
        profileRectArea.mHp = profileRect.iHp;
        profileRectArea.mXp = profileRect.iXp;
        profileRectArea.mYp = profileRect.iYp;
        return profileRectArea;
    }

    public static ArrayList<ConfigArea> AdjustProfileConfiArea(ProfileRectArea profileRectArea, ArrayList<ConfigArea> arrayList) {
        if (profileRectArea == null || arrayList == null) {
            return null;
        }
        h.l().z(arrayList);
        Collections.sort(profileRectArea.mIndexContainer);
        ArrayList<ConfigArea> arrayList2 = new ArrayList<>();
        Iterator<Integer> it = profileRectArea.mIndexContainer.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (arrayList.get(i3).indexId == it.next().intValue()) {
                arrayList2.add(arrayList.get(i3));
            }
            i3++;
        }
        ArrayList<ConfigArea> filledProfileRect = getFilledProfileRect(arrayList2);
        if (filledProfileRect.size() != arrayList2.size()) {
            int i16 = profileRectArea.mAlignType;
            if (i16 == 1) {
                rearrangeConfigLocationVertical(profileRectArea, filledProfileRect);
            } else if (i16 == 2) {
                rearrangeConfigLocationHorizontal(profileRectArea, filledProfileRect);
            }
        }
        return arrayList2;
    }
}
