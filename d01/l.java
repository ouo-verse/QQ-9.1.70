package d01;

import android.content.Context;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u0010"}, d2 = {"Ld01/l;", "", "Lcom/tencent/kuikly/core/render/android/a;", "renderContext", "", "pageName", "Lorg/json/JSONObject;", ISchemeApi.KEY_PAGE_DATA, "hotReloadIp", "", "c", "Landroid/content/Context;", "context", "a", "b", "getContext", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface l {
    void a(@NotNull Context context, @NotNull String pageName, @NotNull JSONObject pageData, @NotNull String hotReloadIp);

    void b(@NotNull com.tencent.kuikly.core.render.android.a renderContext);

    void c(@NotNull com.tencent.kuikly.core.render.android.a renderContext, @NotNull String pageName, @NotNull JSONObject pageData, @NotNull String hotReloadIp);
}
