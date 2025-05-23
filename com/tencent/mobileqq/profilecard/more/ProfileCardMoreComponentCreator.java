package com.tencent.mobileqq.profilecard.more;

import com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent;
import com.tencent.mobileqq.profilecard.more.component.DividerComponent;
import com.tencent.mobileqq.profilecard.more.component.MedalComponent;
import com.tencent.mobileqq.profilecard.more.component.PersonalInfoComponent;
import com.tencent.mobileqq.profilecard.more.component.PersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.more.component.PresentWallComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes35.dex */
public class ProfileCardMoreComponentCreator {
    private static String TAG = "ProfileCardMoreComponentCreator";
    private static Map<Integer, Class<? extends AbsMoreComponent>> mKey2Class;

    static {
        HashMap hashMap = new HashMap();
        mKey2Class = hashMap;
        hashMap.put(Integer.valueOf(ProfileCardMoreConstants.MORE_COMPONENT_KEY_DIVIDER), DividerComponent.class);
        mKey2Class.put(Integer.valueOf(ProfileCardMoreConstants.MORE_COMPONENT_KEY_BASIC_DATA), PersonalInfoComponent.class);
        mKey2Class.put(Integer.valueOf(ProfileCardMoreConstants.MORE_COMPONENT_KEY_MEDAL), MedalComponent.class);
        mKey2Class.put(Integer.valueOf(ProfileCardMoreConstants.MORE_COMPONENT_KEY_PRESENT_WALL), PresentWallComponent.class);
        mKey2Class.put(Integer.valueOf(ProfileCardMoreConstants.MORE_COMPONENT_KEY_PERSONALITY_LABEL), PersonalityLabelComponent.class);
    }

    public static AbsMoreComponent createComponent(int i3, ProfileCardMoreController profileCardMoreController) {
        AbsMoreComponent absMoreComponent = null;
        try {
            Class<? extends AbsMoreComponent> cls = mKey2Class.get(Integer.valueOf(i3));
            if (cls != null) {
                absMoreComponent = cls.getConstructor(ProfileCardMoreController.class).newInstance(profileCardMoreController);
            } else {
                QLog.e(TAG, 1, "create component fail. not found clazz");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "create component fail.", e16);
        }
        return absMoreComponent;
    }
}
