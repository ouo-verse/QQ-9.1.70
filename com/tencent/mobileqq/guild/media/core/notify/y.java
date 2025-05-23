package com.tencent.mobileqq.guild.media.core.notify;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class y extends q {
    @Override // com.tencent.mobileqq.guild.media.core.notify.q
    public void f(int i3, boolean z16, com.tencent.mobileqq.guild.media.core.data.i iVar) {
        String str = (String) iVar.a(1);
        String str2 = (String) iVar.a(2);
        switch (i3) {
            case 1:
                x((String) iVar.a(10), str, str2, (com.tencent.mobileqq.guild.media.core.data.f) iVar.a(3));
                return;
            case 2:
                t(str, str2, (String) iVar.a(5));
                return;
            case 3:
                s(str, str2, ((Integer) iVar.a(6)).intValue(), (String) iVar.a(7), ((Integer) iVar.a(8)).intValue(), (String) iVar.a(9));
                return;
            case 4:
                u();
                return;
            case 5:
            case 6:
            default:
                return;
            case 7:
                o(((Boolean) iVar.a(13)).booleanValue(), ((Integer) iVar.a(20)).intValue());
                return;
            case 8:
                p(((Boolean) iVar.a(14)).booleanValue());
                return;
            case 9:
                q(str2, (ArrayList) iVar.a(15));
                return;
            case 10:
                z((String) iVar.a(16), ((Boolean) iVar.a(17)).booleanValue());
                return;
            case 11:
                A((String) iVar.a(16), ((Integer) iVar.a(18)).intValue(), ((Integer) iVar.a(19)).intValue());
                return;
            case 12:
                y((String) iVar.a(10), (String) iVar.a(21), ((Boolean) iVar.a(22)).booleanValue());
                return;
            case 13:
                w(str, str2, (com.tencent.mobileqq.guild.media.core.data.f) iVar.a(3), (com.tencent.mobileqq.guild.media.core.data.r) iVar.a(4));
                return;
            case 14:
                String str3 = (String) iVar.a(23);
                boolean booleanValue = ((Boolean) iVar.a(25)).booleanValue();
                ArrayList arrayList = new ArrayList();
                arrayList.add(str3);
                r(arrayList, booleanValue);
                return;
            case 15:
                r((List) iVar.a(24), ((Boolean) iVar.a(25)).booleanValue());
                return;
            case 16:
                v(str, str2, (String) iVar.a(23), ((Boolean) iVar.a(25)).booleanValue());
                return;
        }
    }

    public void u() {
    }

    public void p(boolean z16) {
    }

    public void o(boolean z16, int i3) {
    }

    public void q(String str, ArrayList<TRTCQuality> arrayList) {
    }

    public void r(@NonNull List<String> list, boolean z16) {
    }

    public void z(String str, boolean z16) {
    }

    public void A(String str, int i3, int i16) {
    }

    public void t(String str, String str2, String str3) {
    }

    public void y(String str, String str2, boolean z16) {
    }

    public void v(String str, String str2, String str3, boolean z16) {
    }

    public void w(String str, String str2, com.tencent.mobileqq.guild.media.core.data.f fVar, com.tencent.mobileqq.guild.media.core.data.r rVar) {
    }

    public void x(String str, String str2, String str3, com.tencent.mobileqq.guild.media.core.data.f fVar) {
    }

    public void s(String str, String str2, int i3, String str3, int i16, String str4) {
    }
}
