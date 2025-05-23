package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.param.TranslateParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class CoordTypeEnum {
    private static final /* synthetic */ CoordTypeEnum[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final CoordTypeEnum BAIDU;
    public static final CoordTypeEnum DEFAULT;
    public static final CoordTypeEnum GPS;
    public static final CoordTypeEnum MAPBAR;
    public static final CoordTypeEnum NONE;
    public static final CoordTypeEnum SOGOU;
    public static final CoordTypeEnum SOGOUMERCATOR;
    public TranslateParam.CoordType coordType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CoordTypeEnum coordTypeEnum = new CoordTypeEnum("NONE", 0, TranslateParam.CoordType.NONE);
        NONE = coordTypeEnum;
        CoordTypeEnum coordTypeEnum2 = new CoordTypeEnum("GPS", 1, TranslateParam.CoordType.GPS);
        GPS = coordTypeEnum2;
        CoordTypeEnum coordTypeEnum3 = new CoordTypeEnum("SOGOU", 2, TranslateParam.CoordType.SOGOU);
        SOGOU = coordTypeEnum3;
        CoordTypeEnum coordTypeEnum4 = new CoordTypeEnum("BAIDU", 3, TranslateParam.CoordType.BAIDU);
        BAIDU = coordTypeEnum4;
        CoordTypeEnum coordTypeEnum5 = new CoordTypeEnum("MAPBAR", 4, TranslateParam.CoordType.MAPBAR);
        MAPBAR = coordTypeEnum5;
        CoordTypeEnum coordTypeEnum6 = new CoordTypeEnum("DEFAULT", 5, TranslateParam.CoordType.STANDARD);
        DEFAULT = coordTypeEnum6;
        CoordTypeEnum coordTypeEnum7 = new CoordTypeEnum("SOGOUMERCATOR", 6, TranslateParam.CoordType.SOGOUMERCATOR);
        SOGOUMERCATOR = coordTypeEnum7;
        $VALUES = new CoordTypeEnum[]{coordTypeEnum, coordTypeEnum2, coordTypeEnum3, coordTypeEnum4, coordTypeEnum5, coordTypeEnum6, coordTypeEnum7};
    }

    CoordTypeEnum(String str, int i3, TranslateParam.CoordType coordType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), coordType);
        } else {
            this.coordType = coordType;
        }
    }

    public static CoordTypeEnum valueOf(String str) {
        return (CoordTypeEnum) Enum.valueOf(CoordTypeEnum.class, str);
    }

    public static CoordTypeEnum[] values() {
        return (CoordTypeEnum[]) $VALUES.clone();
    }
}
