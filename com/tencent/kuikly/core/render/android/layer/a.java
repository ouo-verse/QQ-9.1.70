package com.tencent.kuikly.core.render.android.layer;

import android.graphics.RectF;
import android.util.SizeF;
import android.view.View;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H&J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H&JO\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2+\u0010#\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0004\u0018\u0001`\"H&JQ\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010%\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012+\u0010#\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0004\u0018\u0001`\"H&J\u0088\u0001\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010%\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\b2+\u0010(\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0004\u0018\u0001`\"2+\u0010)\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\u0004\u0018\u0001`\"H&J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010-\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H&J\u0012\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH&J#\u00103\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00102*\u0002012\u0006\u0010 \u001a\u00020\bH&\u00a2\u0006\u0004\b3\u00104J\u0012\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u00109\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H&J\b\u0010:\u001a\u00020\u0004H&J\b\u0010;\u001a\u00020\u0004H&J\b\u0010<\u001a\u00020\u0004H&\u00a8\u0006="}, d2 = {"Lcom/tencent/kuikly/core/render/android/layer/a;", "", "Lcom/tencent/kuikly/core/render/android/layer/b;", "initCallback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "tag", "", "viewName", ReportConstant.COSTREPORT_PREFIX, "u", "parentTag", "childTag", "index", "l", "propKey", "propValue", "p", "Li01/b;", "shadow", "i", "Landroid/graphics/RectF;", AIInput.KEY_FRAME, h.F, "Landroid/util/SizeF;", "constraintSize", "k", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "r", "moduleName", "f", "callId", "successCallback", "errorCallback", "j", "c", "d", "t", "o", "methodName", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Li01/a;", "T", "a", "(Ljava/lang/String;)Li01/a;", "Landroid/view/View;", "b", "currentTag", "newTag", "g", "e", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface a {
    @Nullable
    <T extends i01.a> T a(@NotNull String name);

    @Nullable
    View b(int tag);

    void c(int tag, @NotNull String viewName);

    void d(int tag);

    void e();

    @Nullable
    Object f(@NotNull String moduleName, @NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback);

    void g(int currentTag, int newTag);

    void h(int tag, @NotNull RectF frame);

    void i(int tag, @NotNull i01.b shadow);

    @Nullable
    Object j(@NotNull String moduleName, @NotNull String method, @Nullable String params, @Nullable String callId, @Nullable Function1<Object, Unit> successCallback, @Nullable Function1<Object, Unit> errorCallback);

    @NotNull
    SizeF k(int tag, @NotNull SizeF constraintSize);

    void l(int parentTag, int childTag, int index);

    void m(@NotNull b initCallback);

    void n();

    @Nullable
    i01.b o(int tag);

    void onDestroy();

    void p(int tag, @NotNull String propKey, @NotNull Object propValue);

    @Nullable
    Object q(int tag, @NotNull String methodName, @NotNull String params);

    void r(int tag, @NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback);

    void s(int tag, @NotNull String viewName);

    void t(int tag, @NotNull String propKey, @NotNull Object propValue);

    void u(int tag);
}
