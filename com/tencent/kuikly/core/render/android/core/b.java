package com.tencent.kuikly.core.render.android.core;

import android.view.View;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JV\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0010H&J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0001H&J#\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001a*\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH&J\b\u0010\"\u001a\u00020\u0010H&J\b\u0010#\u001a\u00020\u0010H&J\b\u0010$\u001a\u00020\u0010H&J\b\u0010%\u001a\u00020\u0010H&J\u001a\u0010)\u001a\u00020\u00102\u0010\u0010(\u001a\f\u0012\u0004\u0012\u00020\u00100&j\u0002`'H&J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020*H&J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010+\u001a\u00020-H&\u00a8\u0006/"}, d2 = {"Lcom/tencent/kuikly/core/render/android/core/b;", "", "Lcom/tencent/kuikly/core/render/android/d;", "renderView", "", "contextCode", "url", "", "params", "assetsPath", "Lcom/tencent/kuikly/core/render/android/g;", "contextParams", "Lcom/tencent/kuikly/core/render/android/core/a;", "contextInitCallback", "Lcom/tencent/kuikly/core/render/android/core/c;", "renderCoreDelegate", "", "l", "Lcom/tencent/kuikly/core/render/android/layer/b;", "initCallback", "k", "e", "event", "data", "d", "Li01/a;", "T", "name", "a", "(Ljava/lang/String;)Li01/a;", "", "tag", "Landroid/view/View;", "b", "destroy", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "g", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "task", "c", "Lcom/tencent/kuikly/core/render/android/f;", "listener", "j", "Lcom/tencent/kuikly/core/render/android/context/a;", "i", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface b {
    @Nullable
    <T extends i01.a> T a(@NotNull String name);

    @Nullable
    View b(int tag);

    void c(@NotNull Function0<Unit> task);

    void d(@NotNull String event, @NotNull Object data);

    void destroy();

    void e();

    void f();

    void g();

    void i(@NotNull com.tencent.kuikly.core.render.android.context.a listener);

    void j(@NotNull f listener);

    void k(@NotNull com.tencent.kuikly.core.render.android.layer.b initCallback);

    void l(@NotNull com.tencent.kuikly.core.render.android.d renderView, @NotNull String contextCode, @NotNull String url, @NotNull Map<String, ? extends Object> params, @Nullable String assetsPath, @NotNull KuiklyContextParams contextParams, @NotNull a contextInitCallback, @NotNull c renderCoreDelegate);

    void m();
}
