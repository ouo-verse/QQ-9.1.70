package com.tencent.mobileqq.guild.media.thirdapp.container.plugin;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/b;", "", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;", "runtime", "", "a", "", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface b {
    void a(@NotNull OpenPluginRuntime runtime);

    @NotNull
    String b();

    boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull c callback);

    void onDestroy();
}
