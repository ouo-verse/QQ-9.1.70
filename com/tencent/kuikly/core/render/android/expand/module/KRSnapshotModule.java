package com.tencent.kuikly.core.render.android.expand.module;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import d01.w;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J.\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\f\u0010\u001f\u001a\u00020\t*\u00020\u001eH\u0002JI\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRSnapshotModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "p", "Landroid/view/View;", "", "clipX", "clipY", "clipWidth", "clipHeight", "Landroid/graphics/Bitmap;", "o", MimeHelper.IMAGE_SUBTYPE_BITMAP, "savePath", "", "l", "Landroid/content/Context;", "context", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Ljava/io/OutputStream;", "g", "method", "call", "<init>", "()V", "d", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRSnapshotModule extends i01.e {
    private final void g(OutputStream outputStream) {
        try {
            outputStream.flush();
            outputStream.close();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(Context context) {
        return m(context) + '/' + j();
    }

    private final String j() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        return "temp_image__" + uuid + ".png";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(Bitmap bitmap, String savePath) {
        File file;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            file = new File(savePath);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 8192);
                try {
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 80, bufferedOutputStream2);
                    g(bufferedOutputStream2);
                    if (!compress) {
                        try {
                            file.delete();
                            return compress;
                        } catch (Throwable th5) {
                            w.f392617a.b("KRSnapshotModule", "delete temp file error: " + th5);
                            return compress;
                        }
                    }
                    return compress;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        w.f392617a.b("KRSnapshotModule", "saveSnapshotTempImage error: " + th);
                        return false;
                    } finally {
                        if (bufferedOutputStream != null) {
                            g(bufferedOutputStream);
                        }
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Throwable th7) {
                                w.f392617a.b("KRSnapshotModule", "delete temp file error: " + th7);
                            }
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            file = null;
        }
    }

    private final String m(Context context) {
        StringBuilder sb5 = new StringBuilder();
        File cacheDir = context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        sb5.append(cacheDir.getAbsolutePath());
        sb5.append("/ntc_snapshot_temp");
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap o(View view, float f16, float f17, float f18, float f19) {
        int i3 = (int) f16;
        int i16 = (int) f17;
        int i17 = (int) f18;
        int i18 = (int) f19;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-f16, -f17);
            view.draw(canvas);
            return createBitmap;
        } catch (Exception e16) {
            w.f392617a.b("KRSnapshotModule", "toBitmap, draw bitmap error: " + e16 + ", try use view cache");
            try {
                boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
                boolean willNotCacheDrawing = view.willNotCacheDrawing();
                view.setDrawingCacheEnabled(true);
                view.setWillNotCacheDrawing(false);
                Bitmap drawingCache = view.getDrawingCache();
                if (drawingCache == null) {
                    return null;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(drawingCache, i3, i16, i17, i18);
                if (i3 == 0 && i16 == 0 && i17 == view.getWidth() && i18 == view.getHeight()) {
                    createBitmap2 = createBitmap2.copy(Bitmap.Config.ARGB_8888, false);
                }
                view.destroyDrawingCache();
                view.setWillNotCacheDrawing(willNotCacheDrawing);
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
                return createBitmap2;
            } catch (Exception e17) {
                w.f392617a.b("KRSnapshotModule", "toBitmap view to bitmap error: " + e17);
                return null;
            }
        } catch (OutOfMemoryError e18) {
            w.f392617a.b("KRSnapshotModule", "toBitmap error OOM error: " + e18);
            return null;
        }
    }

    private final void p(String params, final Function1<Object, Unit> callback) {
        Map mapOf;
        final Context context = getContext();
        if (context != null) {
            JSONObject k06 = KRCSSViewExtensionKt.k0(params);
            final View viewWithTag = viewWithTag(k06.optInt("tag"));
            if (viewWithTag == null) {
                if (callback != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMsg", "the tag of view not found"));
                    callback.invoke(mapOf);
                    return;
                }
                return;
            }
            final float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble(HippyTKDListViewAdapter.X));
            final float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble("y"));
            final float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble("width"));
            final float I4 = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble("height"));
            KRSubThreadScheduler.f118174c.d(0L, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSnapshotModule$viewToImage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Map mapOf2;
                    Bitmap o16;
                    String i3;
                    boolean l3;
                    Map mapOf3;
                    Map mapOf4;
                    Map mapOf5;
                    try {
                        o16 = KRSnapshotModule.this.o(viewWithTag, I, I2, I3, I4);
                        if (o16 != null) {
                            i3 = KRSnapshotModule.this.i(context);
                            w.f392617a.c("KRSnapshotModule", "snapshot temp file path: " + i3);
                            l3 = KRSnapshotModule.this.l(o16, i3);
                            if (l3) {
                                Function1 function1 = callback;
                                if (function1 != null) {
                                    mapOf4 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("filePath", i3));
                                }
                            } else {
                                Function1 function12 = callback;
                                if (function12 != null) {
                                    mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMsg", "save snapshot temp file error"));
                                }
                            }
                        } else {
                            Function1 function13 = callback;
                            if (function13 != null) {
                                mapOf5 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMsg", "view to bitmap error"));
                            }
                        }
                    } catch (Throwable th5) {
                        w.f392617a.b("KRSnapshotModule", "viewToImage error: " + th5);
                        Function1 function14 = callback;
                        if (function14 != null) {
                            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMsg", "viewToImage error"));
                        }
                    }
                }
            });
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method.hashCode() == -1184724677 && method.equals("viewToImage")) {
            p(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
