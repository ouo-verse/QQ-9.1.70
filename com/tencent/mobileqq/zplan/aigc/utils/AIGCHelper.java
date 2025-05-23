package com.tencent.mobileqq.zplan.aigc.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.data.FeedListCache;
import com.tencent.mobileqq.zplan.aigc.data.TASK_STATUS;
import com.tencent.mobileqq.zplan.aigc.render.MaterialInst;
import com.tencent.mobileqq.zplan.aigc.render.ModelExtraInfo;
import com.tencent.mobileqq.zplan.aigc.render.ModelStyle;
import com.tencent.mobileqq.zplan.aigc.render.ParamsConfig;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.zplan.meme.encoder.a;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import tl.h;
import uk3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b[\u0010\\J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eJ&\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\u001a\u001a\u00020\u000eJ\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eJ \u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ \u0010 \u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0012\u0010!\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ>\u0010%\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d0\"J.\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0&2\u0006\u0010\u001a\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\"J\u0013\u0010(\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J#\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0006\u0010.\u001a\u00020\u0007J\u0016\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004JF\u00107\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`42\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`42\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4J&\u00109\u001a\u00020\u00102\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`42\u0006\u00108\u001a\u000203J\u001e\u0010:\u001a\u00020\u00072\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4J\u000e\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u000203J\u001c\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\"2\b\u0010;\u001a\u0004\u0018\u000103J\u0018\u0010@\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020*2\b\b\u0002\u0010?\u001a\u00020\u0004J.\u0010D\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\tJ0\u0010F\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0012\u0010H\u001a\u0004\u0018\u00010\u001d2\b\u0010G\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010K\u001a\u00020\u000e2\b\u0010I\u001a\u0004\u0018\u00010\u000e2\u0006\u0010J\u001a\u00020\u0004R'\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u000402j\b\u0012\u0004\u0012\u00020\u0004`48\u0006\u00a2\u0006\f\n\u0004\b\n\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010T\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\"\u0010Z\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/utils/AIGCHelper;", "", "", "pixels", "", "width", "height", "", "onlyHorizontal", "Landroid/graphics/Rect;", "b", "", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "data", "", "eTag", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/zplan/aigc/data/g;", ReportConstant.COSTREPORT_PREFIX, "slotID", "gltfPath", "o", "ugcEditorId", "Lcom/tencent/mobileqq/zplan/aigc/render/MaterialInst;", "materialList", "root", "l", DomainData.DOMAIN_NAME, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "", "matTextureNameMap", "matTextureMap", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "itemID", "j", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", h.F, "index", "limitSize", "v", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "Lkotlin/collections/ArrayList;", "baseTasks", "appendedTasks", "y", ISchemeApi.KEY_ENABLE_NEW_TASK, "B", "d", "renderTask", "w", HippyTKDListViewAdapter.X, "ugcId", "from", "a", "sourcePixels", "targetBitmap", "targetRect", "k", "source", "e", "avatarBitmap", "g", "str", "maxLength", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/ArrayList;", "t", "()Ljava/util/ArrayList;", "firstRenderTypes", "c", "Lcom/tencent/mobileqq/zplan/aigc/data/g;", "getFeedDataListCache", "()Lcom/tencent/mobileqq/zplan/aigc/data/g;", "feedDataListCache", "J", "getLastCacheUseTime", "()J", "setLastCacheUseTime", "(J)V", "lastCacheUseTime", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AIGCHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final AIGCHelper f330685a = new AIGCHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<Integer> firstRenderTypes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final FeedListCache feedDataListCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long lastCacheUseTime;

    static {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0, 0, 1, 2);
        firstRenderTypes = arrayListOf;
        feedDataListCache = new FeedListCache(null, null, 3, null);
    }

    AIGCHelper() {
    }

    public final void B(ArrayList<AIGCModelRenderTask> baseTasks, AIGCModelRenderTask newTask) {
        Intrinsics.checkNotNullParameter(baseTasks, "baseTasks");
        Intrinsics.checkNotNullParameter(newTask, "newTask");
        Iterator<AIGCModelRenderTask> it = baseTasks.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else {
                if (it.next().getId() == newTask.getId()) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (i3 != -1) {
            baseTasks.set(i3, newTask);
        }
    }

    public final String a(long ugcId, int from) {
        Bundle bundle = new Bundle();
        bundle.putInt("subPageId", 1);
        bundle.putInt("from", from);
        bundle.putLong("ugcId", ugcId);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        ZootopiaSource b16 = ag.f373258a.b();
        if (b16 == null) {
            b16 = ZootopiaSource.INSTANCE.g();
        }
        String buildPageScheme = iSchemeApi.buildPageScheme(b16, 18, bundle);
        QLog.d("AIGCHelper", 1, "\u8df3\u8f6c\u505a\u540c\u6b3e\u7684\u8bd5\u7a7f\u9875schema: " + buildPageScheme);
        return buildPageScheme;
    }

    public final boolean d(ArrayList<AIGCModelRenderTask> baseTasks) {
        Intrinsics.checkNotNullParameter(baseTasks, "baseTasks");
        Iterator<T> it = baseTasks.iterator();
        while (it.hasNext()) {
            if (((AIGCModelRenderTask) it.next()).getStatus() != TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS) {
                return false;
            }
        }
        return true;
    }

    public final Bitmap e(Bitmap source, byte[] pixels, int width, int height, boolean onlyHorizontal) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        QLog.i("AIGCHelper", 1, "origin avatar width: " + width + ", height: " + height);
        Rect b16 = b(pixels, width, height, onlyHorizontal);
        int i3 = b16.left;
        int i16 = b16.top;
        int i17 = b16.right - i3;
        int i18 = b16.bottom - i16;
        QLog.i("AIGCHelper", 1, "cropped avatar bounds (x, y, w, h) = (" + i3 + ", " + i16 + ", " + i17 + ", " + i18 + ")");
        Bitmap createBitmap = Bitmap.createBitmap(source, i3, i16, i17, i18);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(source, x, y, rectWidth, rectHeight)");
        return createBitmap;
    }

    public final boolean h() {
        if (!i.f439124a.c()) {
            com.tencent.mobileqq.zplan.cc.util.a aVar = com.tencent.mobileqq.zplan.cc.util.a.f332553a;
            if (!aVar.c("exp_zplan_aigc_20_update", aVar.a("exp_zplan_aigc_20_update"))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(Continuation<? super String> continuation) {
        AIGCHelper$fetchIblImage$1 aIGCHelper$fetchIblImage$1;
        Object coroutine_suspended;
        int i3;
        Deferred async$default;
        if (continuation instanceof AIGCHelper$fetchIblImage$1) {
            aIGCHelper$fetchIblImage$1 = (AIGCHelper$fetchIblImage$1) continuation;
            int i16 = aIGCHelper$fetchIblImage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aIGCHelper$fetchIblImage$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aIGCHelper$fetchIblImage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aIGCHelper$fetchIblImage$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AIGCHelper$fetchIblImage$indirectLightPathDeferred$1(null), 3, null);
                    aIGCHelper$fetchIblImage$1.label = 1;
                    obj = async$default.await(aIGCHelper$fetchIblImage$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Resource resource = (Resource) obj;
                String path = resource.getPath();
                resource.getDownloadFromNet();
                FLog.INSTANCE.i("AIGCHelper", "fetchIndirectLight path: " + path);
                return path;
            }
        }
        aIGCHelper$fetchIblImage$1 = new AIGCHelper$fetchIblImage$1(this, continuation);
        Object obj2 = aIGCHelper$fetchIblImage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aIGCHelper$fetchIblImage$1.label;
        if (i3 != 0) {
        }
        Resource resource2 = (Resource) obj2;
        String path2 = resource2.getPath();
        resource2.getDownloadFromNet();
        FLog.INSTANCE.i("AIGCHelper", "fetchIndirectLight path: " + path2);
        return path2;
    }

    public final void k(byte[] sourcePixels, int width, int height, Bitmap targetBitmap, Rect targetRect) {
        Intrinsics.checkNotNullParameter(sourcePixels, "sourcePixels");
        Intrinsics.checkNotNullParameter(targetBitmap, "targetBitmap");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        QLog.i("AIGCHelper", 1, "origin avatar width: " + width + ", height: " + height);
        Bitmap b16 = a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, sourcePixels, width, height, null, 4, null);
        Rect c16 = c(this, sourcePixels, width, height, false, 8, null);
        QLog.i("AIGCHelper", 1, "cropped avatar rect = (" + c16 + ")");
        float f16 = ((float) (c16.right - c16.left)) / ((float) (c16.bottom - c16.top));
        int i3 = targetRect.right;
        int i16 = targetRect.left;
        float f17 = i3 - i16;
        float f18 = targetRect.bottom - targetRect.top;
        if (f16 < f17 / f18) {
            float f19 = (f16 * f18) / 2.0f;
            targetRect.left = (int) (((i16 + i3) / 2.0f) - f19);
            targetRect.right = (int) (((i3 + r1) / 2.0f) + f19);
        } else {
            float f26 = (f17 / f16) / 2.0f;
            targetRect.top = (int) (((r4 + r3) / 2.0f) - f26);
            targetRect.bottom = (int) (((r12 + r3) / 2.0f) + f26);
        }
        Canvas canvas = new Canvas(targetBitmap);
        Intrinsics.checkNotNull(b16);
        canvas.drawBitmap(b16, c16, targetRect, (Paint) null);
    }

    public final String l(String ugcEditorId, List<MaterialInst> materialList, String root) {
        Intrinsics.checkNotNullParameter(ugcEditorId, "ugcEditorId");
        Intrinsics.checkNotNullParameter(materialList, "materialList");
        Intrinsics.checkNotNullParameter(root, "root");
        File file = new File(root + "/ConfigData/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ugcEditorId + "_ParamsConfig.json");
        if (file2.exists()) {
            file2.delete();
        }
        String json = new Gson().toJson(new ParamsConfig(materialList));
        try {
            Intrinsics.checkNotNullExpressionValue(json, "json");
            FilesKt.writeText$default(file2, json, null, 2, null);
            return file2.getAbsolutePath();
        } catch (Exception e16) {
            e16.printStackTrace();
            FLog.INSTANCE.e("AIGCHelper", "generateConfigData failed");
            return "";
        }
    }

    public final boolean m(String ugcEditorId, String root, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(ugcEditorId, "ugcEditorId");
        Intrinsics.checkNotNullParameter(root, "root");
        File file = new File(root + "/Icon/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ugcEditorId + "_icon.png");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            FLog.INSTANCE.e("AIGCHelper", "generateIcon failed");
            return false;
        }
    }

    public final boolean n(String ugcEditorId, String root) {
        Intrinsics.checkNotNullParameter(ugcEditorId, "ugcEditorId");
        Intrinsics.checkNotNullParameter(root, "root");
        File file = new File(root + "/OperateData/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ugcEditorId + "_data.json");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FilesKt.writeText$default(file2, "{}", null, 2, null);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            FLog.INSTANCE.e("AIGCHelper", "generateOperateData failed");
            return false;
        }
    }

    public final String o(String slotID, String gltfPath) {
        Intrinsics.checkNotNullParameter(slotID, "slotID");
        Intrinsics.checkNotNullParameter(gltfPath, "gltfPath");
        return "{\"male\" :{\"avatar_info\": {\"" + slotID + "\":\"" + gltfPath + "\"}},\"female\" :{\"avatar_info\": {\"" + slotID + "\":\"" + gltfPath + "\"}}}";
    }

    public final boolean p(String ugcEditorId, String root, Map<String, String> matTextureNameMap, Map<String, Bitmap> matTextureMap) {
        Intrinsics.checkNotNullParameter(ugcEditorId, "ugcEditorId");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(matTextureNameMap, "matTextureNameMap");
        Intrinsics.checkNotNullParameter(matTextureMap, "matTextureMap");
        File file = new File(root + "/Texture/");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            for (Map.Entry<String, String> entry : matTextureNameMap.entrySet()) {
                String key = entry.getKey();
                File file2 = new File(file, entry.getValue() + ".png");
                if (file2.exists()) {
                    file2.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                Bitmap bitmap = matTextureMap.get(key);
                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            FLog.INSTANCE.e("AIGCHelper", "generateTexture failed");
            return false;
        }
    }

    public final Map<String, String> q(String root, Map<String, String> matTextureNameMap) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(matTextureNameMap, "matTextureNameMap");
        File file = new File(root + "/Texture/");
        if (!file.exists()) {
            file.mkdirs();
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(matTextureNameMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = matTextureNameMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), new File(file, ((String) entry.getValue()) + ".png").getAbsolutePath());
        }
        return linkedHashMap;
    }

    public final boolean r(String ugcEditorId, String root, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(ugcEditorId, "ugcEditorId");
        Intrinsics.checkNotNullParameter(root, "root");
        File file = new File(root + "/Thumbnail/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ugcEditorId + "_thumbnail.png");
        if (file2.exists()) {
            file2.delete();
        }
        m(ugcEditorId, root, u(bitmap));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            FLog.INSTANCE.e("AIGCHelper", "generateThumbnail failed");
            return false;
        }
    }

    public final FeedListCache s() {
        if (System.currentTimeMillis() - lastCacheUseTime > 60000) {
            return null;
        }
        return feedDataListCache;
    }

    public final ArrayList<Integer> t() {
        return firstRenderTypes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        r4 = com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper.firstRenderTypes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r3 >= r4.size()) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        r3 = r4.get(r3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "{\n            firstRende\u2026ypes[safeIndex]\n        }");
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return r3.intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0017, code lost:
    
        if (r0.intValue() >= r4) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0019, code lost:
    
        if (r3 <= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        r3 = r3 - 1;
        r0 = com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper.firstRenderTypes.get(r3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "firstRenderTypes[safeIndex]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
    
        if (r0.intValue() >= r4) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        if (r3 < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int v(int index, int limitSize) {
        ArrayList<Integer> arrayList = firstRenderTypes;
        int size = index % arrayList.size();
        Integer num = arrayList.get(size);
        Intrinsics.checkNotNullExpressionValue(num, "firstRenderTypes[safeIndex]");
    }

    public final String w(AIGCModelRenderTask renderTask) {
        Intrinsics.checkNotNullParameter(renderTask, "renderTask");
        ModelExtraInfo modelExtraInfo = renderTask.getModel().getModelExtraInfo();
        List<ModelStyle> modelStyles = modelExtraInfo != null ? modelExtraInfo.getModelStyles() : null;
        List<ModelStyle> list = modelStyles;
        int i3 = 0;
        if (!(list == null || list.isEmpty())) {
            for (Object obj : modelStyles) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ModelStyle modelStyle = (ModelStyle) obj;
                if (i3 == renderTask.getPatternPosType()) {
                    return modelStyle.getStyleName();
                }
                i3 = i16;
            }
            return "";
        }
        return "";
    }

    public final Map<String, Object> x(AIGCModelRenderTask renderTask) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (renderTask == null) {
            return linkedHashMap;
        }
        String modelItemId = renderTask.getModelItemId();
        if (modelItemId == null) {
            modelItemId = "";
        }
        linkedHashMap.put("zplan_model_id", modelItemId);
        String w3 = w(renderTask);
        if (w3 == null) {
            w3 = "";
        }
        linkedHashMap.put("zplan_paste_way", w3);
        if (TextUtils.isEmpty(renderTask.getPatternImage().getImageryName())) {
            String imageryDesc = renderTask.getPatternImage().getImageryDesc();
            if (imageryDesc == null) {
                imageryDesc = "";
            }
            linkedHashMap.put("zplan_keywords", imageryDesc);
        } else {
            String imageryName = renderTask.getPatternImage().getImageryName();
            if (imageryName == null) {
                imageryName = "";
            }
            linkedHashMap.put("zplan_keywords", imageryName);
        }
        String color = renderTask.getColor();
        linkedHashMap.put("zplan_clothes_background", color != null ? color : "");
        return linkedHashMap;
    }

    public final ArrayList<AIGCModelRenderTask> y(ArrayList<AIGCModelRenderTask> baseTasks, ArrayList<AIGCModelRenderTask> appendedTasks) {
        Intrinsics.checkNotNullParameter(baseTasks, "baseTasks");
        Intrinsics.checkNotNullParameter(appendedTasks, "appendedTasks");
        ArrayList<AIGCModelRenderTask> arrayList = new ArrayList<>(baseTasks);
        Iterator<AIGCModelRenderTask> it = appendedTasks.iterator();
        while (it.hasNext()) {
            AIGCModelRenderTask next = it.next();
            Iterator<AIGCModelRenderTask> it5 = baseTasks.iterator();
            int i3 = 0;
            while (true) {
                if (!it5.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (it5.next().getId() == next.getId()) {
                    break;
                }
                i3++;
            }
            if (i3 != -1) {
                if (arrayList.get(i3).getStatus() != TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS) {
                    arrayList.set(i3, next);
                }
                arrayList.set(i3, next);
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final void z(List<? extends com.tencent.mobileqq.zplan.aigc.data.b> data, String eTag) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        if (System.currentTimeMillis() - lastCacheUseTime <= 60000 || data.size() <= 2) {
            return;
        }
        FeedListCache feedListCache = feedDataListCache;
        feedListCache.d(new ArrayList<>());
        ArrayList<com.tencent.mobileqq.zplan.aigc.data.b> b16 = feedListCache.b();
        Intrinsics.checkNotNull(b16);
        b16.addAll(data);
        feedListCache.c(eTag);
        lastCacheUseTime = System.currentTimeMillis();
    }

    public final String A(String str, int maxLength) {
        if (str == null) {
            return "";
        }
        if (str.length() <= maxLength) {
            return str;
        }
        String substring = str.substring(0, maxLength);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(long j3, long j16, Continuation<? super String> continuation) {
        AIGCHelper$fetchWhiteModel$1 aIGCHelper$fetchWhiteModel$1;
        Object coroutine_suspended;
        int i3;
        Deferred async$default;
        if (continuation instanceof AIGCHelper$fetchWhiteModel$1) {
            aIGCHelper$fetchWhiteModel$1 = (AIGCHelper$fetchWhiteModel$1) continuation;
            int i16 = aIGCHelper$fetchWhiteModel$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aIGCHelper$fetchWhiteModel$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aIGCHelper$fetchWhiteModel$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aIGCHelper$fetchWhiteModel$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AIGCHelper$fetchWhiteModel$whiteModelDeferred$1(j3, j16, null), 3, null);
                    aIGCHelper$fetchWhiteModel$1.label = 1;
                    obj = async$default.await(aIGCHelper$fetchWhiteModel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Resource resource = (Resource) obj;
                String path = resource.getPath();
                resource.getDownloadFromNet();
                FLog.INSTANCE.i("AIGCHelper", "fetchWhiteModel path: " + path);
                return path;
            }
        }
        aIGCHelper$fetchWhiteModel$1 = new AIGCHelper$fetchWhiteModel$1(this, continuation);
        Object obj2 = aIGCHelper$fetchWhiteModel$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aIGCHelper$fetchWhiteModel$1.label;
        if (i3 != 0) {
        }
        Resource resource2 = (Resource) obj2;
        String path2 = resource2.getPath();
        resource2.getDownloadFromNet();
        FLog.INSTANCE.i("AIGCHelper", "fetchWhiteModel path: " + path2);
        return path2;
    }

    public final Bitmap u(Bitmap bitmap) {
        Integer valueOf = bitmap != null ? Integer.valueOf(bitmap.getWidth()) : null;
        Integer valueOf2 = bitmap != null ? Integer.valueOf(bitmap.getHeight()) : null;
        if (bitmap != null && (bitmap.getWidth() < 1 || bitmap.getHeight() < 1)) {
            return null;
        }
        Intrinsics.checkNotNull(valueOf);
        Intrinsics.checkNotNull(valueOf2);
        Matrix matrix = new Matrix();
        matrix.postScale(176.0f / valueOf.intValue(), 176.0f / valueOf2.intValue());
        if (bitmap != null) {
            return Bitmap.createBitmap(bitmap, 0, 0, valueOf.intValue(), valueOf2.intValue(), matrix, true);
        }
        return null;
    }

    private final Rect b(byte[] pixels, int width, int height, boolean onlyHorizontal) {
        int i3;
        IntRange until;
        IntProgression step;
        int i16;
        IntRange until2;
        IntProgression step2;
        boolean z16;
        IntRange until3;
        IntProgression step3;
        boolean z17;
        IntRange until4;
        IntProgression step4;
        IntRange until5;
        IntProgression step5;
        boolean z18;
        IntRange until6;
        IntProgression step6;
        boolean z19;
        Rect rect = new Rect();
        int i17 = height - 1;
        int i18 = 2;
        int i19 = 0;
        if (onlyHorizontal) {
            i3 = 0;
        } else {
            until4 = RangesKt___RangesKt.until(0, height);
            step4 = RangesKt___RangesKt.step(until4, 8);
            int first = step4.getFirst();
            int last = step4.getLast();
            int step7 = step4.getStep();
            if ((step7 <= 0 || first > last) && (step7 >= 0 || last > first)) {
                i3 = 0;
            } else {
                i3 = 0;
                while (true) {
                    until6 = RangesKt___RangesKt.until(0, width);
                    step6 = RangesKt___RangesKt.step(until6, 2);
                    int first2 = step6.getFirst();
                    int last2 = step6.getLast();
                    int step8 = step6.getStep();
                    if ((step8 > 0 && first2 <= last2) || (step8 < 0 && last2 <= first2)) {
                        while (pixels[((first * width) + first2) * 4] <= 1) {
                            if (first2 != last2) {
                                first2 += step8;
                            }
                        }
                        i3 = Math.max(0, first - 8);
                        z19 = true;
                        if (!z19 || first == last) {
                            break;
                            break;
                        }
                        first += step7;
                    }
                    z19 = false;
                    if (!z19) {
                        break;
                    }
                    first += step7;
                }
            }
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(i17, 0, -8);
            if (progressionLastElement <= i17) {
                int i26 = i17;
                int i27 = i26;
                while (true) {
                    until5 = RangesKt___RangesKt.until(0, width);
                    step5 = RangesKt___RangesKt.step(until5, 2);
                    int first3 = step5.getFirst();
                    int last3 = step5.getLast();
                    int step9 = step5.getStep();
                    if ((step9 > 0 && first3 <= last3) || (step9 < 0 && last3 <= first3)) {
                        while (pixels[((i27 * width) + first3) * 4] <= 1) {
                            if (first3 != last3) {
                                first3 += step9;
                            }
                        }
                        i26 = Math.min(i17, i27 + 8);
                        z18 = true;
                        if (z18 && i27 != progressionLastElement) {
                            i27 -= 8;
                        }
                    }
                    z18 = false;
                    if (z18) {
                        break;
                    }
                    i27 -= 8;
                }
                i17 = i26;
            }
        }
        until = RangesKt___RangesKt.until(0, width);
        step = RangesKt___RangesKt.step(until, 8);
        int first4 = step.getFirst();
        int last4 = step.getLast();
        int step10 = step.getStep();
        if ((step10 <= 0 || first4 > last4) && (step10 >= 0 || last4 > first4)) {
            i16 = 0;
        } else {
            i16 = 0;
            while (true) {
                until3 = RangesKt___RangesKt.until(0, height);
                step3 = RangesKt___RangesKt.step(until3, i18);
                int first5 = step3.getFirst();
                int last5 = step3.getLast();
                int step11 = step3.getStep();
                if ((step11 > 0 && first5 <= last5) || (step11 < 0 && last5 <= first5)) {
                    while (pixels[((first5 * width) + first4) * 4] <= 1) {
                        if (first5 != last5) {
                            first5 += step11;
                        }
                    }
                    i16 = Math.max(0, first4 - 8);
                    z17 = true;
                    if (!z17 || first4 == last4) {
                        break;
                        break;
                    }
                    first4 += step10;
                    i18 = 2;
                }
                z17 = false;
                if (!z17) {
                    break;
                }
                first4 += step10;
                i18 = 2;
            }
        }
        int i28 = width - 1;
        int progressionLastElement2 = ProgressionUtilKt.getProgressionLastElement(i28, 0, -8);
        if (progressionLastElement2 <= i28) {
            int i29 = i28;
            int i36 = i29;
            while (true) {
                until2 = RangesKt___RangesKt.until(i19, height);
                step2 = RangesKt___RangesKt.step(until2, 2);
                int first6 = step2.getFirst();
                int last6 = step2.getLast();
                int step12 = step2.getStep();
                if ((step12 > 0 && first6 <= last6) || (step12 < 0 && last6 <= first6)) {
                    while (pixels[((first6 * width) + i36) * 4] <= 1) {
                        if (first6 != last6) {
                            first6 += step12;
                        }
                    }
                    i29 = Math.min(i28, i36 + 8);
                    z16 = true;
                    if (z16 && i36 != progressionLastElement2) {
                        i36 -= 8;
                        i19 = 0;
                    }
                }
                z16 = false;
                if (z16) {
                    break;
                }
                i36 -= 8;
                i19 = 0;
            }
            i28 = i29;
        }
        rect.left = i16;
        rect.right = i28;
        rect.top = i3;
        rect.bottom = i17;
        return rect;
    }

    static /* synthetic */ Rect c(AIGCHelper aIGCHelper, byte[] bArr, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = false;
        }
        return aIGCHelper.b(bArr, i3, i16, z16);
    }

    public final Bitmap g(Bitmap avatarBitmap) {
        if (avatarBitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(900, 1600, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        canvas.drawBitmap(avatarBitmap, (900.0f - avatarBitmap.getWidth()) / 2.0f, 0.0f, (Paint) null);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap f(AIGCHelper aIGCHelper, Bitmap bitmap, byte[] bArr, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            z16 = false;
        }
        return aIGCHelper.e(bitmap, bArr, i3, i16, z16);
    }
}
