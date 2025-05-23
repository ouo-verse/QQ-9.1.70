package k51;

import com.tencent.minibox.common.log.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lk51/a;", "", "", "url", "b", "groupName", "a", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f411715a = new a();

    a() {
    }

    private final String b(String url) {
        String str;
        boolean z16;
        Response response = j51.a.f409276b.a().newCall(new Request.Builder().url(url).build()).execute();
        Intrinsics.checkExpressionValueIsNotNull(response, "response");
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            if (body != null) {
                str = body.string();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            return str;
        }
        LogUtils.e("RainbowConfigClient", "requestConfig: failed, code=" + response.code() + ", msg=" + response.message());
        return null;
    }

    @Nullable
    public final String a(@NotNull String groupName) {
        Intrinsics.checkParameterIsNotNull(groupName, "groupName");
        String str = "https://h5.qzone.qq.com/miniapp/act/rainbowApi?" + ("group=" + groupName);
        LogUtils.i("RainbowConfigClient", "pullConfig: groupName=" + groupName);
        return b(str);
    }
}
