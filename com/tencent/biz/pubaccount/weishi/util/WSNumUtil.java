package com.tencent.biz.pubaccount.weishi.util;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.text.DecimalFormat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/WSNumUtil;", "", "Landroid/widget/TextView;", "textView", "", "count", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "", "e", "d", "j", "c", "Ljava/text/DecimalFormat;", "b", "Lkotlin/Lazy;", "i", "()Ljava/text/DecimalFormat;", "commonCountDecimalFormat", tl.h.F, "commonBigCountDecimalFormat", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSNumUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final WSNumUtil f81677a = new WSNumUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy commonCountDecimalFormat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy commonBigCountDecimalFormat;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DecimalFormat>() { // from class: com.tencent.biz.pubaccount.weishi.util.WSNumUtil$commonCountDecimalFormat$2
            @Override // kotlin.jvm.functions.Function0
            public final DecimalFormat invoke() {
                return new DecimalFormat("##.#");
            }
        });
        commonCountDecimalFormat = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DecimalFormat>() { // from class: com.tencent.biz.pubaccount.weishi.util.WSNumUtil$commonBigCountDecimalFormat$2
            @Override // kotlin.jvm.functions.Function0
            public final DecimalFormat invoke() {
                return new DecimalFormat("##");
            }
        });
        commonBigCountDecimalFormat = lazy2;
    }

    WSNumUtil() {
    }

    @JvmStatic
    public static final void d(TextView textView, int count, String defaultValue) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (count > 0) {
            defaultValue = c(count);
        }
        textView.setText(defaultValue);
    }

    @JvmStatic
    public static final void e(final TextView textView, final int count, final String defaultValue) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        textView.setTag(50331903, Integer.valueOf(count));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.ad
            @Override // java.lang.Runnable
            public final void run() {
                WSNumUtil.f(count, defaultValue, textView);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final int i3, String defaultValue, final TextView textView) {
        Intrinsics.checkNotNullParameter(defaultValue, "$defaultValue");
        Intrinsics.checkNotNullParameter(textView, "$textView");
        final String j3 = f81677a.j(i3, defaultValue);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.ae
            @Override // java.lang.Runnable
            public final void run() {
                WSNumUtil.g(i3, textView, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, TextView textView, String countStr) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(countStr, "$countStr");
        if (Intrinsics.areEqual(Integer.valueOf(i3), textView.getTag(50331903))) {
            textView.setText(countStr);
        }
    }

    private final DecimalFormat h() {
        return (DecimalFormat) commonBigCountDecimalFormat.getValue();
    }

    private final DecimalFormat i() {
        return (DecimalFormat) commonCountDecimalFormat.getValue();
    }

    private final String j(int count, String defaultValue) {
        return count > 0 ? c(count) : defaultValue;
    }

    @JvmStatic
    public static final String c(int count) {
        if (count >= 99985000) {
            return "9999\u4e07";
        }
        if (count >= 10004999) {
            return f81677a.h().format(count / 10000.0d) + HardCodeUtil.qqStr(R.string.v1h);
        }
        if (count < 10000) {
            if (count > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(count);
                return sb5.toString();
            }
            return "";
        }
        return f81677a.i().format(count / 10000.0d) + HardCodeUtil.qqStr(R.string.v0y);
    }
}
