package com.tencent.mobileqq.vas.api;

import android.view.ViewGroup;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\b\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "updateSizeTag", "Lkotlin/Function0;", "schemaBuilder", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "newFrame", "a", "b", "vas-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasKuiklyNestPageFrame extends QRouteApi {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$a;", "", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "", "handle", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void handle(@NotNull String eventName, @NotNull JSONObject data);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J$\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH&J\b\u0010\r\u001a\u00020\u0004H&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "", "Landroid/view/ViewGroup;", AIInput.KEY_FRAME, "", "h0", "pause", "resume", "", AdMetricTag.EVENT_NAME, "", "data", "sentEvent", "detachView", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$a;", "handler", "a", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(@NotNull String eventName, @NotNull a handler);

        void detachView();

        void h0(@Nullable ViewGroup frame);

        void pause();

        void resume();

        void sentEvent(@NotNull String eventName, @NotNull Map<String, ? extends Object> data);
    }

    @NotNull
    b newFrame(@NotNull String updateSizeTag, @NotNull Function0<String> schemaBuilder);
}
