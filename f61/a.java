package f61;

import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.common.Banner$ActivityBanner;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f397889a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f397890b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f397891c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f397892d = "";

    /* renamed from: e, reason: collision with root package name */
    public Boolean f397893e = Boolean.FALSE;

    public static List<a> a(List<Banner$ActivityBanner> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (Banner$ActivityBanner banner$ActivityBanner : list) {
                a aVar = new a();
                aVar.f397889a = banner$ActivityBanner.image_link.get();
                aVar.f397890b = banner$ActivityBanner.jump_link.get();
                aVar.f397891c = banner$ActivityBanner.title.get();
                aVar.f397892d = banner$ActivityBanner.sub_title.get();
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
