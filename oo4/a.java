package oo4;

import com.tencent.mobileqq.qqlive.sail.c;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tk4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Loo4/a;", "", "", "anchorUid", "", "", "a", "Lorg/json/JSONObject;", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f423273a = new a();

    a() {
    }

    private final Map<String, String> a(long anchorUid) {
        if (anchorUid != c.f272176a.G()) {
            return tk4.c.INSTANCE.a().b();
        }
        return d.f436481a.d();
    }

    @NotNull
    public final JSONObject b(long anchorUid) {
        Map<String, String> a16 = a(anchorUid);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", -1);
        jSONObject.put("code", 0);
        jSONObject.put("userId", a16.get("qqlive_user_id"));
        jSONObject.put("roomId", a16.get("qqlive_room_id"));
        jSONObject.put("programId", a16.get("qqlive_program_id"));
        jSONObject.put("enterId", a16.get("qqlive_enter_id"));
        jSONObject.put("zhiboType", a16.get("qqlive_zhibo_type"));
        jSONObject.put("zhiboContent", a16.get("qqlive_zhibo_content"));
        jSONObject.put("comingWay", a16.get("qqlive_coming_way"));
        jSONObject.put("startSource", a16.get("qqlive_start_source"));
        return jSONObject;
    }
}
