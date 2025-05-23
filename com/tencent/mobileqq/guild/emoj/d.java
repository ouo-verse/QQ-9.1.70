package com.tencent.mobileqq.guild.emoj;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private static int f217881d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f217882e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f217883f;

    static {
        int i3 = 0 + 1;
        f217881d = i3 + 1;
        f217883f = i3;
    }

    private void c(int i3, boolean z16, Object obj) {
        long j3;
        List<a> list;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i16;
        boolean z17;
        if (i3 != f217883f) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 9) {
                String str6 = (String) objArr[0];
                String str7 = (String) objArr[1];
                j3 = ((Long) objArr[2]).longValue();
                String str8 = (String) objArr[3];
                int intValue = ((Integer) objArr[4]).intValue();
                String str9 = (String) objArr[5];
                String str10 = (String) objArr[6];
                boolean booleanValue = ((Boolean) objArr[7]).booleanValue();
                list = (List) objArr[8];
                str3 = str8;
                i16 = intValue;
                str4 = str9;
                str5 = str10;
                z17 = booleanValue;
                str = str6;
                str2 = str7;
                a(z16, str, str2, j3, str3, i16, str4, str5, z17, list);
            }
        }
        j3 = 0;
        list = null;
        str = "";
        str2 = str;
        str3 = str2;
        str4 = str3;
        str5 = str4;
        i16 = 0;
        z17 = false;
        a(z16, str, str2, j3, str3, i16, str4, str5, z17, list);
    }

    private void d(int i3, boolean z16, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z17;
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        int i16;
        if (i3 != f217882e) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 7) {
                String str5 = (String) objArr[0];
                String str6 = (String) objArr[1];
                long longValue = ((Long) objArr[2]).longValue();
                String str7 = (String) objArr[3];
                long longValue2 = ((Long) objArr[4]).longValue();
                boolean booleanValue = ((Boolean) objArr[5]).booleanValue();
                int intValue = ((Integer) objArr[6]).intValue();
                long longValue3 = ((Long) objArr[7]).longValue();
                long longValue4 = ((Long) objArr[8]).longValue();
                long longValue5 = ((Long) objArr[9]).longValue();
                str4 = (String) objArr[10];
                str3 = str7;
                j16 = longValue2;
                z17 = booleanValue;
                i16 = intValue;
                j17 = longValue3;
                j18 = longValue4;
                j19 = longValue5;
                str = str5;
                str2 = str6;
                j3 = longValue;
                b(z16, str, str2, j3, str3, j16, z17, i16, j17, j18, j19, str4);
            }
        }
        str = "";
        str2 = str;
        str3 = str2;
        str4 = str3;
        z17 = false;
        j3 = 0;
        j16 = 0;
        j17 = 0;
        j18 = 0;
        j19 = 0;
        i16 = -1;
        b(z16, str, str2, j3, str3, j16, z17, i16, j17, j18, j19, str4);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        d(i3, z16, obj);
        c(i3, z16, obj);
    }

    protected void b(boolean z16, String str, String str2, long j3, String str3, long j16, boolean z17, int i3, long j17, long j18, long j19, String str4) {
    }

    protected void a(boolean z16, String str, String str2, long j3, String str3, int i3, String str4, String str5, boolean z17, List<a> list) {
    }
}
