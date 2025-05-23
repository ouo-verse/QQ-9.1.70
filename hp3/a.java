package hp3;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qconn.protofile.appType$AndroidInfo;
import com.tencent.qconn.protofile.appType$MsgIconsurl;
import com.tencent.qconn.protofile.preAuth$PreAuthResponse;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f405800a;

    /* renamed from: b, reason: collision with root package name */
    private List<d> f405801b;

    public a(String str, List<d> list) {
        this.f405800a = str;
        this.f405801b = list;
    }

    public static List<d> a(PBRepeatMessageField<appType$MsgIconsurl> pBRepeatMessageField) {
        if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty()) {
            List<appType$MsgIconsurl> list = pBRepeatMessageField.get();
            ArrayList arrayList = new ArrayList(list.size());
            for (appType$MsgIconsurl apptype_msgiconsurl : list) {
                arrayList.add(new d(apptype_msgiconsurl.url, apptype_msgiconsurl.size));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static a b(preAuth$PreAuthResponse preauth_preauthresponse, appType$AndroidInfo apptype_androidinfo) {
        String str;
        if (apptype_androidinfo.message_tail.has()) {
            str = apptype_androidinfo.message_tail.get();
        } else {
            str = "";
        }
        return new a(str, a(preauth_preauthresponse.icons_url));
    }

    public String c() {
        return this.f405800a;
    }

    public List<d> d() {
        return this.f405801b;
    }

    public String toString() {
        return "appName=" + this.f405800a;
    }
}
