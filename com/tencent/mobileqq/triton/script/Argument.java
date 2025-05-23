package com.tencent.mobileqq.triton.script;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u0003H&J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0010H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00060\u000bj\u0002`\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/triton/script/Argument;", "", "callbackId", "", "getCallbackId", "()I", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "params", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/triton/script/ScriptData;", "getParams", "()Lorg/json/JSONObject;", "rawParams", "", "getRawParams", "()Ljava/lang/String;", "callback", "", "result", "createBuffer", "buffer", "", "offset", "", "length", "getBuffer", "bufferId", "subscribe", AdMetricTag.EVENT_NAME, "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface Argument {
    boolean callback(@Nullable String result);

    int createBuffer(@NotNull byte[] buffer, long offset, long length);

    @Nullable
    byte[] getBuffer(int bufferId);

    int getCallbackId();

    @NotNull
    ScriptContextType getContextType();

    @NotNull
    JSONObject getParams();

    @NotNull
    String getRawParams();

    boolean subscribe(@NotNull String eventName, @Nullable String params);
}
