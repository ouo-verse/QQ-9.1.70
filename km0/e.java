package km0;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003R&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lkm0/e;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "", "key", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "content", "c", "domain", "", "a", "d", "Ljava/util/ArrayList;", "mDomainList", "<init>", "()V", "e", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements IConfigData {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f412664f = "domains";

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f412665h = "DownloadAdDomainConfigData";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> mDomainList;

    public e() {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("h5.gdt.qq.com", "test-xj.gdt.qq.com", "xj.gdt.qq.com", "xijingjianzhan.com");
        this.mDomainList = arrayListOf;
    }

    private final ArrayList<String> b(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return new ArrayList<>();
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        int length = jSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(jSONArray.getString(i3));
        }
        return arrayList;
    }

    public final boolean a(@Nullable String domain) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(this.mDomainList, domain);
        return contains;
    }

    @NotNull
    public final e c(@Nullable String content) {
        boolean z16;
        ArrayList<String> b16;
        e eVar = new e();
        String str = f412665h;
        QLog.e(str, 1, "content is " + content);
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(str, 1, "data is null");
            return eVar;
        }
        try {
            b16 = b(new JSONObject(content), f412664f);
        } catch (JSONException e16) {
            QLog.e(f412665h, 1, e16, new Object[0]);
        }
        if (b16.isEmpty()) {
            QLog.e(str, 1, "config is null");
            return eVar;
        }
        eVar.mDomainList = b16;
        QLog.d(str, 2, b16);
        return eVar;
    }
}
