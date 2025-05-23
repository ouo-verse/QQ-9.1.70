package com.tencent.opentelemetry.api.common;

import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AttributeType {
    private static final /* synthetic */ AttributeType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AttributeType BOOLEAN;
    public static final AttributeType BOOLEAN_ARRAY;
    public static final AttributeType DOUBLE;
    public static final AttributeType DOUBLE_ARRAY;
    public static final AttributeType LONG;
    public static final AttributeType LONG_ARRAY;
    public static final AttributeType STRING;
    public static final AttributeType STRING_ARRAY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AttributeType attributeType = new AttributeType("STRING", 0);
        STRING = attributeType;
        AttributeType attributeType2 = new AttributeType(AlbumSocialInfoCacheData.TYPE_ALBUM_IS_LIKED, 1);
        BOOLEAN = attributeType2;
        AttributeType attributeType3 = new AttributeType("LONG", 2);
        LONG = attributeType3;
        AttributeType attributeType4 = new AttributeType("DOUBLE", 3);
        DOUBLE = attributeType4;
        AttributeType attributeType5 = new AttributeType("STRING_ARRAY", 4);
        STRING_ARRAY = attributeType5;
        AttributeType attributeType6 = new AttributeType("BOOLEAN_ARRAY", 5);
        BOOLEAN_ARRAY = attributeType6;
        AttributeType attributeType7 = new AttributeType("LONG_ARRAY", 6);
        LONG_ARRAY = attributeType7;
        AttributeType attributeType8 = new AttributeType("DOUBLE_ARRAY", 7);
        DOUBLE_ARRAY = attributeType8;
        $VALUES = new AttributeType[]{attributeType, attributeType2, attributeType3, attributeType4, attributeType5, attributeType6, attributeType7, attributeType8};
    }

    AttributeType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AttributeType valueOf(String str) {
        return (AttributeType) Enum.valueOf(AttributeType.class, str);
    }

    public static AttributeType[] values() {
        return (AttributeType[]) $VALUES.clone();
    }
}
