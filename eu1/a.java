package eu1;

import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: eu1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C10265a {

        /* renamed from: a, reason: collision with root package name */
        public List<b> f397133a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public List<String> f397134b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public List<String> f397135c = new ArrayList();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f397136a;

        /* renamed from: b, reason: collision with root package name */
        public String f397137b;

        public b(String str, String str2) {
            this.f397136a = str;
            this.f397137b = str2;
        }
    }

    void o1(C10265a c10265a, int i3, String str, String str2, b bVar, AttaIdReportData attaIdReportData);
}
