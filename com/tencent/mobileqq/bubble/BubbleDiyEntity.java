package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BubbleDiyEntity extends Entity {
    static IPatchRedirector $redirector_;
    public String bottomLeftId;
    public String bottomRightId;
    public String diyText;
    public String topLeftId;
    public String topRightId;

    @unique
    public String uinAndDiyId;

    public BubbleDiyEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.diyText = "";
        }
    }

    public static void parsePasterMap(BubbleDiyEntity bubbleDiyEntity, HashMap<String, String> hashMap) {
        if (bubbleDiyEntity != null && hashMap != null) {
            for (String str : hashMap.keySet()) {
                if ("TL".equalsIgnoreCase(str)) {
                    bubbleDiyEntity.topLeftId = hashMap.get(str);
                } else if ("TR".equalsIgnoreCase(str)) {
                    bubbleDiyEntity.topRightId = hashMap.get(str);
                } else if ("BL".equalsIgnoreCase(str)) {
                    bubbleDiyEntity.bottomLeftId = hashMap.get(str);
                } else if ("BR".equalsIgnoreCase(str)) {
                    bubbleDiyEntity.bottomRightId = hashMap.get(str);
                }
            }
        }
    }

    public HashMap<String, String> convertToPasterMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashMap<String, String> hashMap = new HashMap<>(4);
        if (!TextUtils.isEmpty(this.topLeftId)) {
            hashMap.put("TL", this.topLeftId);
        }
        if (!TextUtils.isEmpty(this.topRightId)) {
            hashMap.put("TR", this.topRightId);
        }
        if (!TextUtils.isEmpty(this.bottomLeftId)) {
            hashMap.put("BL", this.bottomLeftId);
        }
        if (!TextUtils.isEmpty(this.bottomRightId)) {
            hashMap.put("BR", this.bottomRightId);
        }
        return hashMap;
    }
}
