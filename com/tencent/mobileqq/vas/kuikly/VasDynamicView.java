package com.tencent.mobileqq.vas.kuikly;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.kuikly.VasDynamicView;
import com.tencent.mobileqq.vip.api.impl.PngsFileDecoder;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.widget.QzoneEmotionUtils;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0003A\u001cBB\u000f\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J/\u0010\r\u001a\u00020\u00052%\u0010\f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0002J5\u0010\u000f\u001a\u00020\u00052+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001a\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\bH\u0016JI\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\u0016R\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010 R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010/R;\u00103\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R;\u00105\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00102R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasDynamicView;", "Landroid/widget/ImageView;", "Li01/c;", "Lcom/tencent/cachedrawable/dynamicdrawable/d;", "drawable", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "o", "", "url", "", "v", "offlinePath", "y", "r", "params", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "propKey", "propValue", "b", "method", "call", "d", "Ljava/lang/String;", "src", "e", "sceneTag", "f", "Z", "autoAvif", tl.h.F, "_scaleType", "", "i", "I", "loopCount", "Lmqq/util/WeakReference;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "Lmqq/util/WeakReference;", "fastDrawable", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "callPlayEndCallback", "D", "callLoadSuccessCallback", "E", "loadBlock", "", UserInfo.SEX_FEMALE, "[I", "ninePathCenterXYArr", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G", "a", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public class VasDynamicView extends ImageView implements i01.c {
    private static final boolean H = ar.INSTANCE.b("kenaiyu", "2024-02-10", "vas_bug_137559513").isEnable(true);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callPlayEndCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callLoadSuccessCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Function1<? super com.tencent.cachedrawable.dynamicdrawable.d, Unit> loadBlock;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private int[] ninePathCenterXYArr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String src;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sceneTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean autoAvif;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String _scaleType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int loopCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<FastDynamicDrawable> fastDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasDynamicView$c;", "Lkotlin/Function1;", "Lcom/tencent/cachedrawable/dynamicdrawable/d;", "", "p1", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/vas/kuikly/VasDynamicView;", "d", "Lmqq/util/WeakReference;", "viewRef", "view", "<init>", "(Lcom/tencent/mobileqq/vas/kuikly/VasDynamicView;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    private static final class c implements Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<VasDynamicView> viewRef;

        public c(@NotNull VasDynamicView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.viewRef = new WeakReference<>(view);
        }

        public void a(@NotNull com.tencent.cachedrawable.dynamicdrawable.d p16) {
            Intrinsics.checkNotNullParameter(p16, "p1");
            VasDynamicView vasDynamicView = this.viewRef.get();
            if (vasDynamicView != null) {
                vasDynamicView.q(p16);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
            a(dVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasDynamicView$d", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements com.tencent.cachedrawable.dynamicdrawable.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f309662a;

        d(long j3) {
            this.f309662a = j3;
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.e
        @NotNull
        public AbsFileDecoder a(@NotNull String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new PngsFileDecoder(filePath, this.f309662a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasDynamicView$e", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements com.tencent.cachedrawable.dynamicdrawable.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f309663a;

        e(long j3) {
            this.f309663a = j3;
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.e
        @NotNull
        public AbsFileDecoder a(@NotNull String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new PngsFileDecoder(filePath, this.f309663a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasDynamicView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.src = "";
        this.sceneTag = "";
        this._scaleType = "";
        this.loopCount = -1;
        this.loadBlock = new c(this);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private final void A() {
        String str = this._scaleType;
        int hashCode = str.hashCode();
        if (hashCode != -1362001767) {
            if (hashCode != -797304696) {
                if (hashCode == 727618043 && str.equals("aspectFill")) {
                    setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                }
                return;
            }
            if (str.equals(PTSNodeAttributeConstant.MODE_SCALE_TO_FILL)) {
                setScaleType(ImageView.ScaleType.FIT_XY);
                return;
            }
            return;
        }
        if (str.equals("aspectFit")) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private final void m(Function1<Object, Unit> callback) {
        Drawable drawable;
        FastDynamicDrawable fastDynamicDrawable;
        WeakReference<FastDynamicDrawable> weakReference = this.fastDrawable;
        if (weakReference != null && (fastDynamicDrawable = weakReference.get()) != null) {
            drawable = fastDynamicDrawable.o();
        } else {
            drawable = null;
        }
        if (drawable != null) {
            if (callback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("src", this.src);
                callback.invoke(jSONObject);
                return;
            }
            return;
        }
        this.callLoadSuccessCallback = callback;
    }

    private final void o(Function1<Object, Unit> callback) {
        this.callPlayEndCallback = callback;
    }

    private final void p(String params) {
        QLog.d("VasDynamicView", 1, "callTestMethod: " + params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(com.tencent.cachedrawable.dynamicdrawable.d drawable) {
        drawable.d(new b(this));
        Function1<Object, Unit> function1 = this.callLoadSuccessCallback;
        if (function1 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("src", this.src);
            function1.invoke(jSONObject);
        }
    }

    private final boolean r(String url) {
        boolean z16;
        boolean endsWith$default;
        boolean contains$default;
        boolean startsWith$default;
        boolean z17;
        boolean z18;
        String replace$default;
        int indexOf$default;
        boolean endsWith$default2;
        boolean contains$default2;
        boolean z19;
        boolean z26;
        if (Intrinsics.areEqual(this.src, url)) {
            return false;
        }
        this.src = url;
        int[] iArr = null;
        if (TextUtils.isEmpty(url)) {
            setImageDrawable(null);
            return true;
        }
        try {
            String offlineResPath = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(url);
            if (offlineResPath != null && offlineResPath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(url, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
                if (!endsWith$default2) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) ".gif?", false, 2, (Object) null);
                    if (!contains$default2) {
                        a.C1005a g16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(offlineResPath).g(new a.c() { // from class: com.tencent.mobileqq.vas.kuikly.l
                            @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                            public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                                VasDynamicView.t(VasDynamicView.this, kVar);
                            }
                        });
                        if (this.sceneTag.length() > 0) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            g16.i(this.sceneTag);
                        }
                        int[] iArr2 = this.ninePathCenterXYArr;
                        if (iArr2 != null) {
                            if (iArr2.length == 2) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                iArr = iArr2;
                            }
                            if (iArr != null) {
                                g16.e(iArr[0], iArr[1]);
                            }
                        }
                        FastDynamicDrawable a16 = g16.a();
                        this.fastDrawable = new WeakReference<>(a16);
                        a16.c0(this.loadBlock);
                        setImageDrawable(a16);
                    }
                }
                setImageDrawable(IVasApngFactory.INSTANCE.api().getApngDrawable("gif", url, new ApngOptions(), offlineResPath));
            } else {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
                if (!endsWith$default) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) ".gif?", false, 2, (Object) null);
                    if (!contains$default) {
                        a.C1005a l3 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE);
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "pngs://", false, 2, null);
                        if (startsWith$default) {
                            replace$default = StringsKt__StringsJVMKt.replace$default(url, "pngs://", "", false, 4, (Object) null);
                            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) replace$default, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
                            if (indexOf$default > 0) {
                                replace$default = replace$default.substring(0, indexOf$default);
                                Intrinsics.checkNotNullExpressionValue(replace$default, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            }
                            long j3 = 100;
                            try {
                                String str = URLUtil.getArgusFromURLWithoutDecode(url).get("duration");
                                if (str != null) {
                                    j3 = Long.parseLong(str);
                                }
                            } catch (Exception unused) {
                            }
                            l3.k(replace$default);
                            l3.c(new d(j3));
                        } else {
                            l3.k(url);
                        }
                        a.C1005a g17 = l3.g(new a.c() { // from class: com.tencent.mobileqq.vas.kuikly.m
                            @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                            public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                                VasDynamicView.u(VasDynamicView.this, kVar);
                            }
                        });
                        if (this.sceneTag.length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            g17.i(this.sceneTag);
                        }
                        if (this.autoAvif) {
                            g17.b(com.tencent.mobileqq.pendant.downloader.b.f257506a);
                        }
                        int[] iArr3 = this.ninePathCenterXYArr;
                        if (iArr3 != null) {
                            if (iArr3.length == 2) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                iArr = iArr3;
                            }
                            if (iArr != null) {
                                g17.e(iArr[0], iArr[1]);
                            }
                        }
                        FastDynamicDrawable a17 = g17.a();
                        this.fastDrawable = new WeakReference<>(a17);
                        a17.c0(this.loadBlock);
                        setImageDrawable(a17);
                    }
                }
                setImageDrawable(IVasApngFactory.INSTANCE.api().getApngDrawable("gif", url));
            }
            return true;
        } catch (UnsupportedOperationException unused2) {
            throw new UnsupportedOperationException("error : " + url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(VasDynamicView this$0, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        it.y(this$0.loopCount);
        if (this$0.loopCount == 1) {
            it.I(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(VasDynamicView this$0, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        it.y(this$0.loopCount);
        if (this$0.loopCount == 1) {
            it.I(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r0 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean v(final String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        final boolean z16 = false;
        if (Intrinsics.areEqual(this.src, url)) {
            return false;
        }
        this.src = url;
        if (!TextUtils.isEmpty(url)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
            }
            z16 = true;
            if (z16) {
                y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        VasDynamicView.w(z16, url, this);
                    }
                });
            } else {
                y(url, null);
            }
            return true;
        }
        setImageDrawable(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[Catch: UnsupportedOperationException -> 0x0035, TRY_LEAVE, TryCatch #0 {UnsupportedOperationException -> 0x0035, blocks: (B:7:0x0013, B:9:0x0025, B:14:0x0031), top: B:6:0x0013 }] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void w(boolean z16, final String url, final VasDynamicView this$0) {
        boolean z17;
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (z16) {
            try {
                ?? offlineResPath = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(url);
                objectRef.element = offlineResPath;
                CharSequence charSequence = (CharSequence) offlineResPath;
                if (charSequence != null && charSequence.length() != 0) {
                    z17 = false;
                    if (z17) {
                        objectRef.element = null;
                    }
                }
                z17 = true;
                if (z17) {
                }
            } catch (UnsupportedOperationException unused) {
                throw new UnsupportedOperationException("error : " + url);
            }
        }
        y13.d.c(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.o
            @Override // java.lang.Runnable
            public final void run() {
                VasDynamicView.x(VasDynamicView.this, url, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void x(VasDynamicView this$0, String url, Ref.ObjectRef offlinePath) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(offlinePath, "$offlinePath");
        this$0.y(url, (String) offlinePath.element);
    }

    private final void y(String url, String offlinePath) {
        boolean endsWith$default;
        boolean contains$default;
        boolean z16;
        boolean startsWith$default;
        String replace$default;
        int indexOf$default;
        boolean z17;
        boolean z18 = false;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
        boolean z19 = true;
        if (!endsWith$default) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) ".gif?", false, 2, (Object) null);
            if (!contains$default) {
                a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
                a16.g(new a.c() { // from class: com.tencent.mobileqq.vas.kuikly.n
                    @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                    public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                        VasDynamicView.z(VasDynamicView.this, kVar);
                    }
                });
                if (this.sceneTag.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    a16.i(this.sceneTag);
                }
                if (this.autoAvif) {
                    a16.b(com.tencent.mobileqq.pendant.downloader.b.f257506a);
                }
                int[] iArr = this.ninePathCenterXYArr;
                if (iArr != null) {
                    if (iArr.length == 2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        iArr = null;
                    }
                    if (iArr != null) {
                        a16.e(iArr[0], iArr[1]);
                    }
                }
                if (offlinePath != null && offlinePath.length() != 0) {
                    z19 = false;
                }
                if (z19) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "pngs://", false, 2, null);
                    if (startsWith$default) {
                        replace$default = StringsKt__StringsJVMKt.replace$default(url, "pngs://", "", false, 4, (Object) null);
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) replace$default, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
                        if (indexOf$default > 0) {
                            replace$default = replace$default.substring(0, indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(replace$default, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        }
                        long j3 = 100;
                        try {
                            String str = URLUtil.getArgusFromURLWithoutDecode(url).get("duration");
                            if (str != null) {
                                j3 = Long.parseLong(str);
                            }
                        } catch (Exception unused) {
                        }
                        a16.k(replace$default);
                        a16.c(new e(j3));
                    } else {
                        a16.k(url);
                    }
                    a16.l(VasDynamicDrawableCache.INSTANCE);
                } else {
                    a16.d(offlinePath);
                }
                FastDynamicDrawable a17 = a16.a();
                this.fastDrawable = new WeakReference<>(a17);
                a17.c0(this.loadBlock);
                setImageDrawable(a17);
                return;
            }
        }
        if (offlinePath == null || offlinePath.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            setImageDrawable(IVasApngFactory.INSTANCE.api().getApngDrawable("gif", url, new ApngOptions(), offlinePath));
        } else {
            setImageDrawable(IVasApngFactory.INSTANCE.api().getApngDrawable("gif", url));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(VasDynamicView this$0, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        it.y(this$0.loopCount);
        if (this$0.loopCount == 1) {
            it.I(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Function1<Object, Unit> function1;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1877911644:
                if (propKey.equals("scaleType")) {
                    this._scaleType = (String) propValue;
                    A();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -901121364:
                if (propKey.equals("ninePathCenterX")) {
                    JSONObject jSONObject = new JSONObject((String) propValue);
                    this.ninePathCenterXYArr = new int[]{jSONObject.optInt(HippyTKDListViewAdapter.X), jSONObject.optInt("y")};
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -775498898:
                if (propKey.equals("sceneTag")) {
                    this.sceneTag = (String) propValue;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 114148:
                if (propKey.equals("src")) {
                    if (H) {
                        return v((String) propValue);
                    }
                    return r((String) propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1438171745:
                if (propKey.equals("autoAvif")) {
                    this.autoAvif = ((Boolean) propValue).booleanValue();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1571519540:
                if (propKey.equals("repeatCount")) {
                    this.loopCount = ((Integer) propValue).intValue();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function1 = (Function1) propValue;
                    } else {
                        function1 = null;
                    }
                    m(function1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "test")) {
            p(params);
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(method, "playEnd")) {
            return c.a.b(this, method, params, callback);
        }
        o(callback);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasDynamicView$b;", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "", "onEnd", "onStart", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/vas/kuikly/VasDynamicView;", "a", "Lmqq/util/WeakReference;", "dynamicViewWeak", "view", "<init>", "(Lcom/tencent/mobileqq/vas/kuikly/VasDynamicView;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements d.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<VasDynamicView> dynamicViewWeak;

        public b(@NotNull VasDynamicView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.dynamicViewWeak = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(VasDynamicView vasDynamicView) {
            Function1 function1 = vasDynamicView.callPlayEndCallback;
            if (function1 != null) {
                function1.invoke(null);
            }
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onEnd() {
            final VasDynamicView vasDynamicView = this.dynamicViewWeak.get();
            if (vasDynamicView != null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        VasDynamicView.b.b(VasDynamicView.this);
                    }
                });
            }
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
        public void onStart() {
        }
    }
}
