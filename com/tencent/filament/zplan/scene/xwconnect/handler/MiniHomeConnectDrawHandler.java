package com.tencent.filament.zplan.scene.xwconnect.handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler;
import com.tencent.filament.zplan.scene.xwconnect.handler.a;
import com.tencent.filament.zplanservice.pbjava.XwConnect$DrawTextReq;
import com.tencent.filament.zplanservice.pbjava.XwConnect$ImagePixel;
import com.tencent.filament.zplanservice.pbjava.XwConnect$ImageRsp;
import com.tencent.filament.zplanservice.util.f;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0004,-\u0014.B\u001d\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010$\u001a\u00020 \u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u001c\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u001a\u0010\u000f\u001a\u00020\r2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u000bJ3\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00032\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/a;", "Lkotlinx/coroutines/CoroutineScope;", "", "colorString", "", "g", "value", h.F, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "f", "e", "url", "", "header", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c;", "c", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "contextTmp", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "Ljava/lang/ref/WeakReference;", "getNativeApp", "()Ljava/lang/ref/WeakReference;", "nativeApp", "", "J", "getSceneId", "()J", WadlProxyConsts.SCENE_ID, "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Ljava/lang/ref/WeakReference;J)V", "i", "a", "b", "MiddleTextView", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeConnectDrawHandler implements com.tencent.filament.zplan.scene.xwconnect.handler.a, CoroutineScope {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context contextTmp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> nativeApp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f106174h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(21)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$MiddleTextView;", "Landroid/widget/FrameLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$a;", "d", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$a;", "a", "()Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$a;", "textView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class MiddleTextView extends FrameLayout {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a textView;

        @JvmOverloads
        public MiddleTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0, 0, 12, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getTextView() {
            return this.textView;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            this.textView.measure(-2, -2);
            ViewGroup.LayoutParams layoutParams = this.textView.getLayoutParams();
            if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                layoutParams = null;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (layoutParams2 == null) {
                layoutParams2 = generateDefaultLayoutParams();
            }
            layoutParams2.width = this.textView.getMeasuredWidth();
            layoutParams2.height = this.textView.getMeasuredHeight();
            layoutParams2.gravity = 17;
            this.textView.setLayoutParams(layoutParams2);
            setMinimumWidth(this.textView.getMeasuredWidth());
            setMinimumHeight(this.textView.getMeasuredHeight());
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        @JvmOverloads
        public MiddleTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
            this(context, attributeSet, i3, 0, 8, null);
        }

        public /* synthetic */ MiddleTextView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public MiddleTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
            super(context, attributeSet, i3, i16);
            Intrinsics.checkNotNullParameter(context, "context");
            a aVar = new a(context);
            addView(aVar);
            Unit unit = Unit.INSTANCE;
            this.textView = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$a;", "Landroid/widget/TextView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    @SuppressLint({"AppCompatCustomView"})
    /* loaded from: classes6.dex */
    public static final class a extends TextView {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            TextPaint paint = getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            paint.setAntiAlias(true);
            TextPaint paint2 = getPaint();
            Intrinsics.checkNotNullExpressionValue(paint2, "paint");
            paint2.setSubpixelText(true);
            TextPaint paint3 = getPaint();
            Intrinsics.checkNotNullExpressionValue(paint3, "paint");
            paint3.setHinting(1);
            super.onDraw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c;", "", "<init>", "()V", "a", "b", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c$b;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c$a;", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static abstract class c {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c$a;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler$c$a, reason: from toString */
        /* loaded from: classes6.dex */
        public static final /* data */ class Fail extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String errorMessage;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fail(@NotNull String errorMessage) {
                super(null);
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                this.errorMessage = errorMessage;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (!(other instanceof Fail) || !Intrinsics.areEqual(this.errorMessage, ((Fail) other).errorMessage)) {
                        return false;
                    }
                    return true;
                }
                return true;
            }

            public int hashCode() {
                String str = this.errorMessage;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "Fail(errorMessage=" + this.errorMessage + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0014\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c$b;", "Lcom/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "b", "I", "getStatusCode", "()I", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "c", "Ljava/util/Map;", "getRspHeader", "()Ljava/util/Map;", "rspHeader", "<init>", "(Ljava/lang/String;ILjava/util/Map;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler$c$b, reason: from toString */
        /* loaded from: classes6.dex */
        public static final /* data */ class Success extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String filePath;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final int statusCode;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final Map<String, List<String>> rspHeader;

            /* JADX WARN: Multi-variable type inference failed */
            public Success(@Nullable String str, int i3, @Nullable Map<String, ? extends List<String>> map) {
                super(null);
                this.filePath = str;
                this.statusCode = i3;
                this.rspHeader = map;
            }

            @Nullable
            /* renamed from: a, reason: from getter */
            public final String getFilePath() {
                return this.filePath;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (other instanceof Success) {
                        Success success = (Success) other;
                        if (!Intrinsics.areEqual(this.filePath, success.filePath) || this.statusCode != success.statusCode || !Intrinsics.areEqual(this.rspHeader, success.rspHeader)) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }

            public int hashCode() {
                int i3;
                String str = this.filePath;
                int i16 = 0;
                if (str != null) {
                    i3 = str.hashCode();
                } else {
                    i3 = 0;
                }
                int i17 = ((i3 * 31) + this.statusCode) * 31;
                Map<String, List<String>> map = this.rspHeader;
                if (map != null) {
                    i16 = map.hashCode();
                }
                return i17 + i16;
            }

            @NotNull
            public String toString() {
                return "Success(filePath=" + this.filePath + ", statusCode=" + this.statusCode + ", rspHeader=" + this.rspHeader + ")";
            }
        }

        c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplan/scene/xwconnect/handler/MiniHomeConnectDrawHandler$d", "Lgl0/a;", "", "errorMsg", "", "b", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class d implements gl0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation f106180a;

        d(Continuation continuation) {
            this.f106180a = continuation;
        }

        @Override // gl0.a
        public void a(@Nullable String filePath, int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
            this.f106180a.resumeWith(Result.m476constructorimpl(new c.Success(filePath, statusCode, rspHeader)));
        }

        @Override // gl0.a
        public void b(@NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.f106180a.resumeWith(Result.m476constructorimpl(new c.Fail(errorMsg)));
        }
    }

    public MiniHomeConnectDrawHandler(@NotNull WeakReference<FilamentNativeAppV2305> nativeApp, long j3) {
        Context context;
        TextureView view;
        Intrinsics.checkNotNullParameter(nativeApp, "nativeApp");
        this.f106174h = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.nativeApp = nativeApp;
        this.sceneId = j3;
        FilamentNativeAppV2305 filamentNativeAppV2305 = nativeApp.get();
        if (filamentNativeAppV2305 != null && (view = filamentNativeAppV2305.getView()) != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        this.contextTmp = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object d(MiniHomeConnectDrawHandler miniHomeConnectDrawHandler, String str, Map map, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        return miniHomeConnectDrawHandler.c(str, map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g(String colorString) {
        return Color.parseColor(colorString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h(int value) {
        if (value != 0) {
            if (value == 1) {
                return 1;
            }
            if (value == 2) {
                return 2;
            }
            if (value == 3) {
                return 3;
            }
            throw new IllegalArgumentException("\u5b57\u4f53\u98ce\u683c\u4e0d\u6b63\u786e " + value);
        }
        return 0;
    }

    final /* synthetic */ Object c(String str, Map<String, String> map, Continuation<? super c> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object a16 = fl0.a.f399763a.a(dl0.b.class);
        Intrinsics.checkNotNull(a16);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ((dl0.b) a16).a(str, map, new d(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void e(@NotNull MessageMicro<?> pbField, @NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Intrinsics.checkNotNullParameter(pbField, "pbField");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new MiniHomeConnectDrawHandler$drawImage$1(this, pbField, callbackN2C, null), 3, null);
    }

    @RequiresApi(21)
    public final void f(@NotNull final MessageMicro<?> pbField, @NotNull final com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Pair pair;
        List<XwConnect$ImagePixel> mutableListOf;
        Intrinsics.checkNotNullParameter(pbField, "pbField");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        Context context = this.contextTmp;
        if (context != null) {
            final XwConnect$DrawTextReq xwConnect$DrawTextReq = (XwConnect$DrawTextReq) pbField;
            f fVar = new f(new MiddleTextView(context, null, 0, 0, 14, null));
            try {
                int i3 = xwConnect$DrawTextReq.text_desc.image_size.type.get();
                int i16 = 1;
                if (i3 != 0) {
                    if (i3 != 1) {
                        pair = TuplesKt.to(-2, -2);
                    } else {
                        pair = TuplesKt.to(-2, Integer.valueOf(xwConnect$DrawTextReq.text_desc.image_size.height.get()));
                    }
                } else {
                    pair = TuplesKt.to(Integer.valueOf(xwConnect$DrawTextReq.text_desc.image_size.width.get()), Integer.valueOf(xwConnect$DrawTextReq.text_desc.image_size.height.get()));
                }
                fVar.a(((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), new Function1<MiddleTextView, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler$drawText$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MiniHomeConnectDrawHandler.MiddleTextView middleTextView) {
                        invoke2(middleTextView);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x006b  */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(@NotNull MiniHomeConnectDrawHandler.MiddleTextView receiver) {
                        int i17;
                        boolean isBlank;
                        int h16;
                        boolean isBlank2;
                        int g16;
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.getTextView().setText(XwConnect$DrawTextReq.this.text_desc.text.get());
                        if (XwConnect$DrawTextReq.this.text_desc.color.has()) {
                            String str = XwConnect$DrawTextReq.this.text_desc.color.get();
                            Intrinsics.checkNotNullExpressionValue(str, "dataReq.text_desc.color.get()");
                            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                            if (!isBlank2) {
                                MiniHomeConnectDrawHandler.a textView = receiver.getTextView();
                                MiniHomeConnectDrawHandler miniHomeConnectDrawHandler = this;
                                String str2 = XwConnect$DrawTextReq.this.text_desc.color.get();
                                Intrinsics.checkNotNullExpressionValue(str2, "dataReq.text_desc.color.get()");
                                g16 = miniHomeConnectDrawHandler.g(str2);
                                textView.setTextColor(g16);
                                i17 = XwConnect$DrawTextReq.this.text_desc.font_size.get();
                                if (i17 > 0) {
                                    receiver.getTextView().setTextSize(0, i17);
                                }
                                if (XwConnect$DrawTextReq.this.text_desc.font_family.has()) {
                                    String str3 = XwConnect$DrawTextReq.this.text_desc.font_family.get();
                                    Intrinsics.checkNotNullExpressionValue(str3, "dataReq.text_desc.font_family.get()");
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                                    if (!isBlank) {
                                        MiniHomeConnectDrawHandler.a textView2 = receiver.getTextView();
                                        String str4 = XwConnect$DrawTextReq.this.text_desc.font_family.get();
                                        h16 = this.h(XwConnect$DrawTextReq.this.text_desc.font_style.get());
                                        textView2.setTypeface(Typeface.create(str4, h16));
                                        return;
                                    }
                                }
                                receiver.getTextView().setTypeface(Typeface.SANS_SERIF);
                            }
                        }
                        receiver.getTextView().setTextColor(-16777216);
                        i17 = XwConnect$DrawTextReq.this.text_desc.font_size.get();
                        if (i17 > 0) {
                        }
                        if (XwConnect$DrawTextReq.this.text_desc.font_family.has()) {
                        }
                        receiver.getTextView().setTypeface(Typeface.SANS_SERIF);
                    }
                });
                ByteBuffer d16 = f.d(fVar, null, 1, null);
                XwConnect$ImagePixel xwConnect$ImagePixel = new XwConnect$ImagePixel();
                PBBytesField pBBytesField = xwConnect$ImagePixel.data;
                byte[] array = d16.array();
                Intrinsics.checkNotNullExpressionValue(array, "buffer.array()");
                pBBytesField.set(com.tencent.filament.zplanservice.util.d.b(array));
                xwConnect$ImagePixel.width.set(fVar.g());
                xwConnect$ImagePixel.height.set(fVar.e());
                xwConnect$ImagePixel.level.set(0);
                Unit unit = Unit.INSTANCE;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(xwConnect$ImagePixel);
                if (xwConnect$DrawTextReq.level_count.get() >= 2) {
                    float f16 = 2;
                    float g16 = fVar.g() / f16;
                    float e16 = fVar.e() / f16;
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    floatRef.element = xwConnect$DrawTextReq.text_desc.font_size.get() / f16;
                    int i17 = 1;
                    while (i17 < xwConnect$DrawTextReq.level_count.get()) {
                        float f17 = i16;
                        if (g16 < f17 || e16 < f17 || floatRef.element < f17) {
                            break;
                        }
                        fVar.a((int) g16, (int) e16, new Function1<MiddleTextView, Unit>() { // from class: com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler$drawText$1$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(MiniHomeConnectDrawHandler.MiddleTextView middleTextView) {
                                invoke2(middleTextView);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull MiniHomeConnectDrawHandler.MiddleTextView receiver) {
                                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                                receiver.getTextView().setTextSize(0, Ref.FloatRef.this.element);
                            }
                        });
                        d16 = fVar.c(d16);
                        XwConnect$ImagePixel xwConnect$ImagePixel2 = new XwConnect$ImagePixel();
                        PBBytesField pBBytesField2 = xwConnect$ImagePixel2.data;
                        byte[] array2 = d16.array();
                        Intrinsics.checkNotNullExpressionValue(array2, "buffer.array()");
                        pBBytesField2.set(com.tencent.filament.zplanservice.util.d.b(array2));
                        xwConnect$ImagePixel2.width.set(fVar.g());
                        xwConnect$ImagePixel2.height.set(fVar.e());
                        xwConnect$ImagePixel2.level.set(i17);
                        Unit unit2 = Unit.INSTANCE;
                        mutableListOf.add(xwConnect$ImagePixel2);
                        i17++;
                        g16 /= f16;
                        e16 /= f16;
                        floatRef.element /= f16;
                        i16 = 1;
                    }
                }
                XwConnect$ImageRsp xwConnect$ImageRsp = new XwConnect$ImageRsp();
                xwConnect$ImageRsp.scene_address.set(xwConnect$DrawTextReq.scene_address.get());
                xwConnect$ImageRsp.mipmap_data.set(mutableListOf);
                com.tencent.filament.zplanservice.channel.handler.a.e(callbackN2C, xwConnect$ImageRsp);
                Unit unit3 = Unit.INSTANCE;
                CloseableKt.closeFinally(fVar, null);
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(fVar, th5);
                    throw th6;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f106174h.getCoroutineContext();
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onCreate() {
        a.C1118a.a(this);
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.handler.a
    public void onDestroy() {
        a.C1118a.b(this);
    }
}
