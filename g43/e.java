package g43;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lg43/e;", "Lcom/tencent/freesia/IConfigData;", "", "content", "c", "a", "b", "d", "Ljava/lang/String;", "qqSportMainPageCompose", "e", "qqSportMsgListPage", "<init>", "()V", "f", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qqSportMainPageCompose = "mqqapi://kuikly/open?page_name=QQSportCompose&bundle_name=QQSportsKuikly&version=1&src_type=web";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qqSportMsgListPage = "mqqapi://kuikly/open?page_name=QQSportsMsgListPage&bundle_name=QQSportsKuikly&version=1&src_type=web";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getQqSportMainPageCompose() {
        return this.qqSportMainPageCompose;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getQqSportMsgListPage() {
        return this.qqSportMsgListPage;
    }

    @NotNull
    public final e c(@Nullable String content) {
        boolean z16;
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("SportMainPageConfigData", 1, "data is null");
            return new e();
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            String optString = jSONObject.optString("qq_sport_main_page_new", "mqqapi://kuikly/open?page_name=QQSportCompose&bundle_name=QQSportsKuikly&version=1&src_type=web");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY\u2026RT_MAIN_PAGE_COMPOSE_URL)");
            this.qqSportMainPageCompose = optString;
            String optString2 = jSONObject.optString("qq_sport_msg_list_page", "mqqapi://kuikly/open?page_name=QQSportsMsgListPage&bundle_name=QQSportsKuikly&version=1&src_type=web");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY\u2026_SPORT_MSG_LIST_PAGE_URL)");
            this.qqSportMsgListPage = optString2;
        } catch (JSONException e16) {
            QLog.e("SportMainPageConfigData", 1, "json parse error:", e16);
        }
        return this;
    }
}
