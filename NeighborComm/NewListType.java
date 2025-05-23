package NeighborComm;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NewListType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _NewListType_Encounter_Number = 6;
    public static final int _NewListType_Nomal = 0;
    public static final int _NewListType_None = 100;
    public static final int _NewListType_Only_Female = 1;
    public static final int _NewListType_Only_Male = 2;
    public static final int _NewListType_RankingList = 4;
    public static final int _NewListType_Recommend = 7;
    public static final int _NewListType_Single = 5;
    public static final int _NewListType_Tag = 3;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static NewListType[] f25079d = new NewListType[9];
    public static final NewListType NewListType_Nomal = new NewListType(0, 0, "NewListType_Nomal");
    public static final NewListType NewListType_Only_Female = new NewListType(1, 1, "NewListType_Only_Female");
    public static final NewListType NewListType_Only_Male = new NewListType(2, 2, "NewListType_Only_Male");
    public static final NewListType NewListType_Tag = new NewListType(3, 3, "NewListType_Tag");
    public static final NewListType NewListType_RankingList = new NewListType(4, 4, "NewListType_RankingList");
    public static final NewListType NewListType_Single = new NewListType(5, 5, "NewListType_Single");
    public static final NewListType NewListType_Encounter_Number = new NewListType(6, 6, "NewListType_Encounter_Number");
    public static final NewListType NewListType_Recommend = new NewListType(7, 7, "NewListType_Recommend");
    public static final NewListType NewListType_None = new NewListType(8, 100, "NewListType_None");

    NewListType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f25079d[i3] = this;
    }

    public static NewListType convert(int i3) {
        int i16 = 0;
        while (true) {
            NewListType[] newListTypeArr = f25079d;
            if (i16 >= newListTypeArr.length) {
                return null;
            }
            if (newListTypeArr[i16].value() == i3) {
                return f25079d[i16];
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

    public static NewListType convert(String str) {
        int i3 = 0;
        while (true) {
            NewListType[] newListTypeArr = f25079d;
            if (i3 >= newListTypeArr.length) {
                return null;
            }
            if (newListTypeArr[i3].toString().equals(str)) {
                return f25079d[i3];
            }
            i3++;
        }
    }
}
