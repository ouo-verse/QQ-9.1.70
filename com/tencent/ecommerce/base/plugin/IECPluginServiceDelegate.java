package com.tencent.ecommerce.base.plugin;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J4\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J4\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\t2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nH&J4\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nH&J\b\u0010\u0010\u001a\u00020\u0003H&J0\u0010\u0011\u001a\u00020\u00032&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;", "", "onCreate", "", "onHandleLogic", "type", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onHandlePtsLoad", "onHandleScheme", "url", "onHandleTargetScheme", "target", "onPtsLoadFailed", "onStartCommand", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECPluginServiceDelegate {
    void onCreate();

    void onHandleLogic(int type, @NotNull HashMap<String, String> params);

    void onHandlePtsLoad();

    void onHandleScheme(@NotNull String url, @NotNull HashMap<String, String> params);

    void onHandleTargetScheme(int target, @NotNull HashMap<String, String> params);

    void onPtsLoadFailed();

    void onStartCommand(@Nullable HashMap<String, String> params);
}
