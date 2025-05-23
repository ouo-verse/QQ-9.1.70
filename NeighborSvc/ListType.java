package NeighborSvc;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ListType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _ListType_Group = 1;
    public static final int _ListType_Normal = 0;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static ListType[] f25080d = new ListType[2];
    public static final ListType ListType_Normal = new ListType(0, 0, "ListType_Normal");
    public static final ListType ListType_Group = new ListType(1, 1, "ListType_Group");

    ListType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25080d[i3] = this;
    }

    public static ListType convert(int i3) {
        int i16 = 0;
        while (true) {
            ListType[] listTypeArr = f25080d;
            if (i16 >= listTypeArr.length) {
                return null;
            }
            if (listTypeArr[i16].value() == i3) {
                return f25080d[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static ListType convert(String str) {
        int i3 = 0;
        while (true) {
            ListType[] listTypeArr = f25080d;
            if (i3 >= listTypeArr.length) {
                return null;
            }
            if (listTypeArr[i3].toString().equals(str)) {
                return f25080d[i3];
            }
            i3++;
        }
    }
}
