package m92;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f416458a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<InterestTagInfo> f416459b = new ArrayList<>(2);

    public a(int i3) {
        this.f416458a = i3;
    }

    public JSONObject a() {
        JSONObject convertTo;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tagType", this.f416458a);
            JSONArray jSONArray = new JSONArray();
            if (this.f416459b.size() > 0) {
                Iterator<InterestTagInfo> it = this.f416459b.iterator();
                while (it.hasNext()) {
                    InterestTagInfo next = it.next();
                    if (next != null && (convertTo = next.convertTo()) != null) {
                        jSONArray.mo162put(convertTo);
                    }
                }
            }
            jSONObject.put("tagInfos", jSONArray);
            return jSONObject;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.NEARBY_PEOPLE_CARD, 2, e16.toString());
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f416458a != this.f416458a || aVar.f416459b.size() != this.f416459b.size()) {
            return false;
        }
        int size = this.f416459b.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Utils.p(this.f416459b.get(i3), aVar.f416459b.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(80);
        sb5.append("[");
        sb5.append("tagType = ");
        sb5.append(this.f416458a);
        sb5.append(",");
        sb5.append("size = ");
        sb5.append(this.f416459b.size());
        sb5.append(",");
        if (this.f416459b.size() > 0) {
            Iterator<InterestTagInfo> it = this.f416459b.iterator();
            while (it.hasNext()) {
                InterestTagInfo next = it.next();
                if (next != null) {
                    sb5.append(next.toString());
                    sb5.append(",");
                }
            }
        }
        sb5.append("]");
        return sb5.toString();
    }
}
