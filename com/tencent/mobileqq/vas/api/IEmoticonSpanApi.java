package com.tencent.mobileqq.vas.api;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\\\u0010\u0019\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IEmoticonSpanApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "obj", "", "isEmoticonSpan", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Landroid/graphics/Rect;", "getRect", "Landroid/graphics/Canvas;", "var1", "", "var2", "", "var3", "var4", "", "var5", "var6", "var7", "var8", "Landroid/graphics/Paint;", "var9", "", "draw", "Companion", "a", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IEmoticonSpanApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f308449a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IEmoticonSpanApi$a;", "", "Lcom/tencent/mobileqq/vas/api/IEmoticonSpanApi;", "b", "Lcom/tencent/mobileqq/vas/api/IEmoticonSpanApi;", "a", "()Lcom/tencent/mobileqq/vas/api/IEmoticonSpanApi;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.api.IEmoticonSpanApi$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f308449a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final IEmoticonSpanApi instance;

        static {
            QRouteApi api = QRoute.api(IEmoticonSpanApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IEmoticonSpanApi::class.java)");
            instance = (IEmoticonSpanApi) api;
        }

        Companion() {
        }

        @NotNull
        public final IEmoticonSpanApi a() {
            return instance;
        }
    }

    void draw(@Nullable Object obj, @NotNull Canvas var1, @Nullable CharSequence var2, int var3, int var4, float var5, int var6, int var7, int var8, @NotNull Paint var9);

    @Nullable
    Drawable getDrawable(@Nullable Object obj);

    @Nullable
    Rect getRect(@Nullable Object obj);

    boolean isEmoticonSpan(@Nullable Object obj);
}
