package oo4;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\f"}, d2 = {"Loo4/b;", "", "", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "list", "Lorg/json/JSONObject;", "a", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "yesGameRole", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f423274a = new b();

    b() {
    }

    @NotNull
    public final JSONObject a(@Nullable List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(GdtGetUserInfoHandler.KEY_AREA, yesGameInfoOuterClass$YesGameRoleAbsInfo.area.get());
                jSONObject.put("partition", yesGameInfoOuterClass$YesGameRoleAbsInfo.partition.get());
                jSONObject.put("roleName", yesGameInfoOuterClass$YesGameRoleAbsInfo.role_name.get());
                jSONObject.put("logicGradeLevel", yesGameInfoOuterClass$YesGameRoleAbsInfo.logic_grade_level.get());
                jSONObject.put("dispGradeLevel", yesGameInfoOuterClass$YesGameRoleAbsInfo.disp_grade_level.get());
                jSONObject.put("gradeLevelName", yesGameInfoOuterClass$YesGameRoleAbsInfo.grade_level_name.get());
                jSONObject.put("gradeLevelShortName", yesGameInfoOuterClass$YesGameRoleAbsInfo.grade_level_short_name.get());
                jSONObject.put("roleLevel", yesGameInfoOuterClass$YesGameRoleAbsInfo.role_level.get());
                jSONObject.put("roleDesc", yesGameInfoOuterClass$YesGameRoleAbsInfo.role_desc.get());
                jSONObject.put("isDefault", yesGameInfoOuterClass$YesGameRoleAbsInfo.is_default.get());
                jSONObject.put("bigGradeLevel", yesGameInfoOuterClass$YesGameRoleAbsInfo.big_grade_level.get());
                jSONArray.mo162put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("smobaRoleList", jSONArray);
        return jSONObject2;
    }

    @NotNull
    public final JSONObject b(@Nullable YesGameInfoOuterClass$YesGameRoleInfo yesGameRole) {
        JSONObject jSONObject = new JSONObject();
        if (yesGameRole != null) {
            jSONObject.put(GdtGetUserInfoHandler.KEY_AREA, yesGameRole.area.get());
            jSONObject.put("partition", yesGameRole.partition.get());
            jSONObject.put("roleName", yesGameRole.role_name.get());
            jSONObject.put("logicGradeLevel", yesGameRole.logic_grade_level.get());
            jSONObject.put("dispGradeLevel", yesGameRole.disp_grade_level.get());
            jSONObject.put("gradeLevelName", yesGameRole.grade_level_name.get());
            jSONObject.put("gradeLevelShortName", yesGameRole.grade_level_short_name.get());
            jSONObject.put("roleLevel", yesGameRole.role_level.get());
            jSONObject.put("roleDesc", yesGameRole.role_desc.get());
            jSONObject.put("isDefault", true);
            jSONObject.put("bigGradeLevel", yesGameRole.big_grade_level.get());
        }
        return jSONObject;
    }
}
