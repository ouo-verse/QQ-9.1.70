package com.tencent.shadow.core.runtime.skin.entity;

import com.tencent.shadow.core.runtime.skin.loader.ContextHolder;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AttrFactory {
    private static final String TAG = "SKIN" + AttrFactory.class.getSimpleName();

    public static SkinAttr createAttr(String str, int i3, String str2) {
        if (i3 == 0) {
            return null;
        }
        try {
            SkinAttr createAttrByName = createAttrByName(str);
            if (createAttrByName != null) {
                createAttrByName.setBaseValue(str, str2, ContextHolder.getContext().getResources().getResourceTypeName(i3), i3);
            }
            return createAttrByName;
        } catch (Exception unused) {
            return null;
        }
    }

    private static SkinAttr createAttrByName(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1240751833:
                if (str.equals("TextColorAttr")) {
                    c16 = 0;
                    break;
                }
                break;
            case -289402411:
                if (str.equals("SrcAttr")) {
                    c16 = 1;
                    break;
                }
                break;
            case 424945759:
                if (str.equals("BackgroundAttr")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new TextColorAttr();
            case 1:
                return new SrcAttr();
            case 2:
                return new BackgroundAttr();
            default:
                return null;
        }
    }
}
