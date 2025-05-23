package com.tencent.mobileqq.vas.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.Constants;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J4\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0002J&\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/i;", "", "", "bid", "", "", "updateList", "from", "Lkotlin/Pair;", "c", "cookie", "Lcom/tencent/mobileqq/vas/api/impl/r;", "b", "a", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "mCurrentCookieId", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "requestMap", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f308607a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicLong mCurrentCookieId = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, RequestWrapper> requestMap = new ConcurrentHashMap<>();

    i() {
    }

    private final Pair<Long, String> c(long bid, List<String> updateList, String from) {
        boolean equals;
        AtomicLong atomicLong = mCurrentCookieId;
        long andIncrement = atomicLong.getAndIncrement();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cookie", atomicLong);
            jSONObject.put("delta_mode", 1);
            jSONObject.put("storage_mode", 1);
            jSONObject.put("compress_mode", 1);
            jSONObject.put("from", from);
            equals = StringsKt__StringsJVMKt.equals(Constants.UpdateFrom.SILENT_UPDATE, from, true);
            if (equals) {
                jSONObject.put(FileReaderHelper.OPEN_FILE_FROM_FORCE, 2);
            } else {
                jSONObject.put(FileReaderHelper.OPEN_FILE_FROM_FORCE, 1);
            }
            JSONArray jSONArray = new JSONArray();
            for (String str : updateList) {
                if (str != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bid", bid);
                    jSONObject2.put("scid", str);
                    jSONObject2.put("srcMd5", "");
                    jSONObject2.put("dstMd5", "");
                    jSONArray.mo162put(jSONObject2);
                }
            }
            jSONObject.put("item_list", jSONArray);
        } catch (JSONException e16) {
            QLog.e("GetUrlReqContentHelper", 1, "exception happended: ", e16);
        }
        if (VasUpdateWrapper.getLog().isColorLevel()) {
            QLog.d("GetUrlReqContentHelper", 1, "batchGetUrl request content = " + jSONObject);
        }
        Long valueOf = Long.valueOf(andIncrement);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString()");
        return new Pair<>(valueOf, jSONObject3);
    }

    @NotNull
    public final RequestWrapper a(long bid, @NotNull List<String> updateList, @NotNull String from) {
        Intrinsics.checkNotNullParameter(updateList, "updateList");
        Intrinsics.checkNotNullParameter(from, "from");
        Pair<Long, String> c16 = c(bid, updateList, from);
        RequestWrapper requestWrapper = new RequestWrapper(c16.getSecond(), 0L, 2, null);
        requestMap.put(c16.getFirst(), requestWrapper);
        return requestWrapper;
    }

    @Nullable
    public final RequestWrapper b(long cookie) {
        return requestMap.remove(Long.valueOf(cookie));
    }
}
