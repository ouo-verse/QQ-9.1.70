package e61;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import e61.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Le61/b;", "Lcom/tencent/freesia/IConfigData;", "Ljava/util/ArrayList;", "Le61/a;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "interactSendItems", "<init>", "()V", "e", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b implements IConfigData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> interactSendItems = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Le61/b$a;", "", "", "configString", "Le61/b;", "a", "EMOTIONID", "Ljava/lang/String;", "ICON", "LABEL", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e61.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a(@NotNull String configString) {
            String obj;
            Long longOrNull;
            Intrinsics.checkNotNullParameter(configString, "configString");
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(configString);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null && (obj = next.toString()) != null) {
                        JSONObject jsonItem = jSONObject.getJSONObject(obj);
                        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(obj);
                        if (longOrNull != null) {
                            long longValue = longOrNull.longValue();
                            ArrayList<a> a16 = bVar.a();
                            a.Companion companion = a.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(jsonItem, "jsonItem");
                            a16.add(companion.a(longValue, jsonItem));
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("InteractSendMsgBean", 1, "parse configString error: " + configString + " " + e16);
            }
            return bVar;
        }

        Companion() {
        }
    }

    @NotNull
    public final ArrayList<a> a() {
        return this.interactSendItems;
    }
}
