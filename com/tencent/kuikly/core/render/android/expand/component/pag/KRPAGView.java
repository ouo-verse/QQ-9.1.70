package com.tencent.kuikly.core.render.android.expand.component.pag;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.a;
import com.tencent.kuikly.core.render.android.expand.component.KRAPNGView;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.kuikly.core.render.android.expand.module.e;
import com.tencent.kuikly.core.render.android.expand.module.j;
import com.tencent.kuikly.core.render.android.expand.vendor.KRFileManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import d01.PAGReplaceItem;
import d01.k;
import d01.s;
import d01.t;
import d01.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import l01.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bE\u0010FJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0016JI\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\u001c\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J3\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00032#\u0010&\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0017J\u000e\u0010(\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003R\u0016\u0010+\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u00102\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R;\u00105\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R;\u00107\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R;\u00109\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R;\u0010;\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R;\u0010<\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\u0004\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00104R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010-R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-R\u0018\u0010 \u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010@R\u0014\u0010B\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010/\u00a8\u0006G"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/pag/KRPAGView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Ld01/t;", "", "params", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "X", "", "", "W", "filePath", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "U", "V", "T", "propValue", "N", "Y", "propKey", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "pagView", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "a", "cdnUrl", "resultCallback", "O", "P", "H", "Ljava/lang/String;", "src", "I", "Z", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "autoPlay", "J", "Lkotlin/jvm/functions/Function1;", "loadFailureCallback", "K", "animationStartCallback", "L", "animationEndCallback", "M", "animationCancelCallback", "animationRepeatCallback", "hadStop", "hadFilePath", "Ld01/s;", "Ld01/s;", "k", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRPAGView extends KRView implements t {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private String src;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: J, reason: from kotlin metadata */
    private Function1<Object, Unit> loadFailureCallback;

    /* renamed from: K, reason: from kotlin metadata */
    private Function1<Object, Unit> animationStartCallback;

    /* renamed from: L, reason: from kotlin metadata */
    private Function1<Object, Unit> animationEndCallback;

    /* renamed from: M, reason: from kotlin metadata */
    private Function1<Object, Unit> animationCancelCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private Function1<Object, Unit> animationRepeatCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hadStop;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hadFilePath;

    /* renamed from: R, reason: from kotlin metadata */
    private s pagView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/pag/KRPAGView$a;", "", "", "ANIMATION_CANCEL", "Ljava/lang/String;", "ANIMATION_END", "ANIMATION_REPEAT", "ANIMATION_START", "AUTO_PLAY", "LOAD_FAIL", "METHOD_PLAY", "METHOD_STOP", "REPEAT_COUNT", "REPLACE_IMAGE_LAYER_CONTENT", "REPLACE_LAYER_CONTENTS", "REPLACE_TEXT_LAYER_CONTENT", "SRC", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.pag.KRPAGView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRPAGView(@NotNull Context context) {
        super(context);
        s sVar;
        Intrinsics.checkNotNullParameter(context, "context");
        this.src = "";
        this.autoPlay = true;
        k h16 = u.f392615m.h();
        if (h16 != null && (sVar = h16.a(context)) != null) {
            sVar.h(this);
            View d16 = sVar.d();
            d16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(d16);
            Unit unit = Unit.INSTANCE;
        } else {
            sVar = null;
        }
        this.pagView = sVar;
    }

    private final boolean N(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.autoPlay = z16;
            if (z16) {
                Y();
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void Q(String params) {
        this.autoPlay = true;
        this.hadStop = false;
        s sVar = this.pagView;
        if (sVar != null) {
            sVar.f();
        }
    }

    private final boolean R(Object params) {
        s sVar = this.pagView;
        if (sVar != null) {
            if (params != null) {
                sVar.setPAGViewRepeatCount(((Integer) params).intValue());
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(String filePath) {
        s sVar = this.pagView;
        if (sVar != null) {
            sVar.setFilePath(filePath);
        }
        this.hadFilePath = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r0, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean T(Object params) {
        List split$default;
        if (!(params instanceof String)) {
            params = null;
        }
        String str = (String) params;
        if (str == null || split$default == null) {
            return false;
        }
        String str2 = (String) split$default.get(0);
        String str3 = (String) split$default.get(1);
        s sVar = this.pagView;
        if (sVar != null) {
            sVar.b(str2, str3);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean U(Object params) {
        Integer num;
        Bitmap bitmap;
        j jVar;
        View viewWithTag;
        Bitmap h16;
        Object opt;
        Object opt2;
        Object opt3;
        Object opt4;
        Object opt5;
        j jVar2;
        Object obj = params;
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    Object opt6 = optJSONObject.opt("imageBitmapMemoryCacheKey");
                    if (!(opt6 instanceof String)) {
                        opt6 = null;
                    }
                    String str2 = (String) opt6;
                    Object opt7 = optJSONObject.opt("imageViewRef");
                    if (!(opt7 instanceof String)) {
                        opt7 = null;
                    }
                    String str3 = (String) opt7;
                    if (str3 != null) {
                        num = StringsKt__StringNumberConversionsKt.toIntOrNull(str3);
                    } else {
                        num = null;
                    }
                    if (str2 != null) {
                        a aVar = get_kuiklyRenderContext();
                        if (aVar != null) {
                            jVar2 = (j) aVar.a("KRMemoryCacheModule");
                        } else {
                            jVar2 = null;
                        }
                        if (jVar2 != null) {
                            h16 = (Bitmap) jVar2.g(str2);
                        } else {
                            h16 = null;
                        }
                        if (!(h16 instanceof Bitmap)) {
                            h16 = null;
                        }
                    } else {
                        if (num != null) {
                            a aVar2 = get_kuiklyRenderContext();
                            if (aVar2 != null) {
                                jVar = (j) aVar2.a("KRMemoryCacheModule");
                            } else {
                                jVar = null;
                            }
                            if (jVar != null && (viewWithTag = jVar.viewWithTag(num.intValue())) != null) {
                                h16 = b.h(viewWithTag);
                            }
                        }
                        bitmap = null;
                        int optInt = optJSONObject.optInt("type");
                        opt = optJSONObject.opt("layerName");
                        if (!(opt instanceof String)) {
                            opt = null;
                        }
                        String str4 = (String) opt;
                        opt2 = optJSONObject.opt("layerIndex");
                        if (!(opt2 instanceof Integer)) {
                            opt2 = null;
                        }
                        Integer num2 = (Integer) opt2;
                        opt3 = optJSONObject.opt("text");
                        if (!(opt3 instanceof String)) {
                            opt3 = null;
                        }
                        String str5 = (String) opt3;
                        opt4 = optJSONObject.opt("imageFilePath");
                        if (!(opt4 instanceof String)) {
                            opt4 = null;
                        }
                        String str6 = (String) opt4;
                        opt5 = optJSONObject.opt("imageFileAsset");
                        if (!(opt5 instanceof String)) {
                            opt5 = null;
                        }
                        arrayList.add(new PAGReplaceItem(optInt, str4, num2, str5, str6, (String) opt5, bitmap));
                    }
                    bitmap = h16;
                    int optInt2 = optJSONObject.optInt("type");
                    opt = optJSONObject.opt("layerName");
                    if (!(opt instanceof String)) {
                    }
                    String str42 = (String) opt;
                    opt2 = optJSONObject.opt("layerIndex");
                    if (!(opt2 instanceof Integer)) {
                    }
                    Integer num22 = (Integer) opt2;
                    opt3 = optJSONObject.opt("text");
                    if (!(opt3 instanceof String)) {
                    }
                    String str52 = (String) opt3;
                    opt4 = optJSONObject.opt("imageFilePath");
                    if (!(opt4 instanceof String)) {
                    }
                    String str62 = (String) opt4;
                    opt5 = optJSONObject.opt("imageFileAsset");
                    if (!(opt5 instanceof String)) {
                    }
                    arrayList.add(new PAGReplaceItem(optInt2, str42, num22, str52, str62, (String) opt5, bitmap));
                }
            }
            s sVar = this.pagView;
            if (sVar != null) {
                sVar.g(arrayList);
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r0, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean V(Object params) {
        List split$default;
        if (!(params instanceof String)) {
            params = null;
        }
        String str = (String) params;
        if (str == null || split$default == null) {
            return false;
        }
        String str2 = (String) split$default.get(0);
        String str3 = (String) split$default.get(1);
        s sVar = this.pagView;
        if (sVar != null) {
            sVar.c(str2, str3);
        }
        return true;
    }

    private final boolean W(Object params) {
        if (params != null) {
            String str = (String) params;
            if (Intrinsics.areEqual(this.src, str)) {
                return true;
            }
            this.src = str;
            if (KRAPNGView.INSTANCE.a(str)) {
                O(this.src, new Function1<String, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.pag.KRPAGView$setSrc$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable String str2) {
                        if (str2 != null) {
                            KRPAGView.this.S(str2);
                        }
                    }
                });
            } else {
                S(this.src);
                post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.pag.KRPAGView$setSrc$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        KRPAGView.this.Y();
                    }
                });
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void X(String params) {
        this.autoPlay = false;
        if (!this.hadStop) {
            this.hadStop = true;
            s sVar = this.pagView;
            if (sVar != null) {
                sVar.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        s sVar;
        if (this.autoPlay && this.hadFilePath && (sVar = this.pagView) != null) {
            sVar.f();
        }
    }

    public final void O(@NotNull final String cdnUrl, @NotNull final Function1<? super String, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        final String P = P(cdnUrl);
        a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            KRFileManager.f118087b.d(aVar, cdnUrl, P, new Function1<String, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.pag.KRPAGView$fetchPagFileIfNeedWithCdnUrl$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    Function1 function1;
                    if (str == null) {
                        function1 = KRPAGView.this.loadFailureCallback;
                        if (function1 != null) {
                        }
                        resultCallback.invoke(null);
                        return;
                    }
                    resultCallback.invoke(str);
                    KRPAGView.this.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.pag.KRPAGView$fetchPagFileIfNeedWithCdnUrl$$inlined$also$lambda$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            KRPAGView.this.Y();
                        }
                    });
                }
            });
        }
    }

    @NotNull
    public final String P(@NotNull String cdnUrl) {
        e eVar;
        String d16;
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            eVar = (e) aVar.a("KRCodecModule");
        } else {
            eVar = null;
        }
        if (eVar != null && (d16 = eVar.d(cdnUrl)) != null) {
            cdnUrl = d16;
        }
        StringBuilder sb5 = new StringBuilder();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        File cacheDir = context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        sb5.append(cacheDir.getAbsolutePath());
        sb5.append("/kuikly");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath() + "/kuikly_pag_" + cdnUrl + ".pag";
    }

    @Override // d01.t
    public void a(@NotNull View pagView) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Function1<Object, Unit> function1 = this.animationRepeatCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        boolean z16;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        boolean z17 = true;
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case -1458222274:
                if (propKey.equals("animationStart")) {
                    this.animationStartCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 114148:
                if (propKey.equals("src")) {
                    z17 = W(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 154219831:
                if (propKey.equals("replaceLayerContents")) {
                    z17 = U(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 253548169:
                if (propKey.equals("replaceTextLayerContent")) {
                    z17 = V(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 486417039:
                if (propKey.equals("replaceImageLayerContent")) {
                    z17 = T(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1173886647:
                if (propKey.equals("animationEnd")) {
                    this.animationEndCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1438608771:
                if (propKey.equals("autoPlay")) {
                    z17 = N(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1564508958:
                if (propKey.equals("animationCancel")) {
                    this.animationCancelCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1571519540:
                if (propKey.equals("repeatCount")) {
                    z17 = R(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1997701695:
                if (propKey.equals("animationRepeat")) {
                    this.animationRepeatCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            default:
                z17 = super.b(propKey, propValue);
                break;
        }
        if (!z17) {
            s sVar = this.pagView;
            if (sVar != null) {
                z16 = sVar.a(propKey, propValue);
            } else {
                z16 = false;
            }
            return z16;
        }
        return z17;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != 3443508) {
            if (hashCode == 3540994 && method.equals("stop")) {
                X(params);
                return Unit.INSTANCE;
            }
        } else if (method.equals("play")) {
            Q(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // d01.t
    public void onAnimationCancel(@NotNull View pagView) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Function1<Object, Unit> function1 = this.animationCancelCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    @Override // d01.t
    public void onAnimationEnd(@NotNull View pagView) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Function1<Object, Unit> function1 = this.animationEndCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    @Override // d01.t
    public void onAnimationStart(@NotNull View pagView) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Function1<Object, Unit> function1 = this.animationStartCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public void onDestroy() {
        super.onDestroy();
        X(null);
        s sVar = this.pagView;
        if (sVar != null) {
            sVar.e(this);
        }
    }

    public final void setAutoPlay(boolean z16) {
        this.autoPlay = z16;
    }
}
