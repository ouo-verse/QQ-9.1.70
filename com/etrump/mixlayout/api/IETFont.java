package com.etrump.mixlayout.api;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IETFont {
    void copy(IETFont iETFont);

    void disableEffects(boolean z16, boolean z17, boolean z18);

    boolean equals(Object obj);

    int getColor();

    long getDIYConfigHandle();

    int getFontType();

    int getId();

    String getPath();

    int getSize();

    long get_substitution();

    boolean isBold();

    void onDestroy();

    void parseDIYJsonString(String str);

    void setBold(boolean z16);

    void setColor(int i3);

    void setCrochet(boolean z16, int i3, int i16);

    void setDIYConfigHandle(long j3);

    void setFontType(int i3);

    void setId(int i3);

    void setPath(String str);

    void setShadow(boolean z16, int i3, int i16, int i17, int i18);

    void setSize(float f16);

    void set_substitution(long j3);

    String toString();
}
