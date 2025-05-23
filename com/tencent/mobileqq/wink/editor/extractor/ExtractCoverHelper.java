package com.tencent.mobileqq.wink.editor.extractor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.n;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.q;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.picker.MediaData;
import common.config.service.QzoneConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001YB\t\b\u0002\u00a2\u0006\u0004\bW\u0010XJ\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J1\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ?\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0003J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010J$\u0010\u001e\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00022\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\u001f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010 \u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003H\u0002J.\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00022\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J.\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00022\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J \u00103\u001a\u0002022\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00122\u0006\u00101\u001a\u000200H\u0002J%\u00106\u001a\u0004\u0018\u00010-2\b\u00104\u001a\u0004\u0018\u00010\u00102\b\u00105\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0004\b6\u00107J\u0012\u0010:\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u000108H\u0002J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00022\u0006\u0010;\u001a\u00020\u000eH\u0002J&\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002H\u0002J\u0012\u0010?\u001a\u00020\u00072\b\u0010>\u001a\u0004\u0018\u00010\u0012H\u0002J(\u0010D\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0010H\u0002J(\u0010E\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0010H\u0002R\u0016\u0010H\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR,\u0010N\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020K0J0I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bG\u0010U\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/extractor/ExtractCoverHelper;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/mobileqq/wink/editor/extractor/ExtractCoverHelper$a;", "callback", "", "D", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timestamps", "", "maxLength", "", "outputDir", "E", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mediaInfo", "Lcom/tencent/videocut/picker/MediaData;", "G", "mediaSize", UserInfo.SEX_FEMALE, "Lcom/tencent/videocut/model/MediaClip;", "clips", "totalDurationUs", "y", ReportConstant.COSTREPORT_PREFIX, "u", "toAddedMedia", "l", "toRemovedMedia", "J", "p", "", "isReady", "N", "info", "M", HippyTKDListViewAdapter.X, "B", "Lorg/light/lightAssetKit/components/Size;", "targetSize", "path", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSource", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/n;", "r", "resWidth", "resHeight", "H", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lorg/light/lightAssetKit/components/Size;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, DomainData.DOMAIN_NAME, "multiCutVideoDurationInMs", "o", "t", "mediaPath", "L", "url", HippyControllerProps.ARRAY, "timestamp", "index", "P", "O", "b", "I", "EXTRACT_BITMAP_PIC_MAX_BYTE", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/f;", "c", "Ljava/util/Map;", "thumbProviders", "d", "Z", "isResReady", "Landroid/os/Handler;", "e", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "extractHandler", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ExtractCoverHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ExtractCoverHelper f320276a = new ExtractCoverHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int EXTRACT_BITMAP_PIC_MAX_BYTE = 100000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f>> thumbProviders = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isResReady;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy extractHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/extractor/ExtractCoverHelper$a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NotNull ArrayList<byte[]> result);
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper$extractHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ExtractCoverHelper");
                baseHandlerThread.start();
                return new Handler(baseHandlerThread.getLooper());
            }
        });
        extractHandler = lazy;
    }

    ExtractCoverHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(a callback, ArrayList result) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(result, "$result");
        callback.a(result);
    }

    private final ArrayList<byte[]> B(List<? extends MediaClip> clips, long totalDurationUs) {
        boolean z16;
        Long l3;
        boolean z17;
        List<Long> o16 = o(totalDurationUs / 1000);
        ArrayList<byte[]> arrayList = new ArrayList<>();
        Ref.LongRef longRef = new Ref.LongRef();
        long currentTimeMillis = System.currentTimeMillis();
        List<? extends MediaClip> list = clips;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z18 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MediaClip) next).resource == null) {
                z18 = false;
            }
            if (z18) {
                arrayList2.add(next);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(arrayList2.size());
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (((MediaClip) obj).resource != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList3.add(obj);
            }
        }
        Iterator it5 = arrayList3.iterator();
        long j3 = 0;
        while (it5.hasNext()) {
            ClipSource A = com.tencent.videocut.render.extension.e.A((MediaClip) it5.next(), false, null, 3, null);
            if (A == null) {
                countDownLatch.countDown();
            } else {
                ArrayList arrayList4 = new ArrayList();
                Iterator<T> it6 = o16.iterator();
                while (it6.hasNext()) {
                    long longValue = ((Number) it6.next()).longValue() - j3;
                    if (0 <= longValue && longValue <= A.getDuration()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        l3 = Long.valueOf(longValue);
                    } else {
                        l3 = null;
                    }
                    if (l3 != null) {
                        arrayList4.add(l3);
                    }
                }
                w53.b.f("ExtractCoverHelper", "extractBitmapsForVideo keyFrameStamp: " + arrayList4);
                String path = A.getPath();
                if (path == null || BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ExtractCoverHelper$extractBitmapsForVideoNew$2$1$1(path, arrayList4, countDownLatch, longRef, arrayList, null), 3, null) == null) {
                    countDownLatch.countDown();
                    Unit unit = Unit.INSTANCE;
                }
                j3 += A.getDuration();
            }
        }
        countDownLatch.await();
        w53.b.f("ExtractCoverHelper", "extract cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", frame count: " + arrayList.size());
        return arrayList;
    }

    private final Size H(Integer resWidth, Integer resHeight) {
        int i3;
        int i16;
        int winkTemplateSampleShortSideMinValue = QzoneConfig.getWinkTemplateSampleShortSideMinValue();
        if (resWidth != null) {
            i3 = resWidth.intValue();
        } else {
            i3 = winkTemplateSampleShortSideMinValue;
        }
        if (resHeight != null) {
            i16 = resHeight.intValue();
        } else {
            i16 = winkTemplateSampleShortSideMinValue;
        }
        if (i3 > 0 && i16 > 0) {
            if (i3 >= winkTemplateSampleShortSideMinValue && i16 >= winkTemplateSampleShortSideMinValue) {
                float f16 = i16;
                float f17 = i3;
                float f18 = f16 / (f17 * 1.0f);
                if (i3 > i16) {
                    return new Size((int) ((f17 / (f16 * 1.0f)) * winkTemplateSampleShortSideMinValue), winkTemplateSampleShortSideMinValue);
                }
                return new Size(winkTemplateSampleShortSideMinValue, (int) (f18 * winkTemplateSampleShortSideMinValue));
            }
            return new Size(i3, i16);
        }
        return null;
    }

    private final Handler I() {
        return (Handler) extractHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(LocalMediaInfo toRemovedMedia) {
        Intrinsics.checkNotNullParameter(toRemovedMedia, "$toRemovedMedia");
        f320276a.L(toRemovedMedia.path);
    }

    private final void L(String mediaPath) {
        com.tencent.mobileqq.wink.editor.clipping.thumbnail.f second;
        if (mediaPath != null) {
            Map<String, Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f>> map = thumbProviders;
            Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f> pair = map.get(mediaPath);
            if (pair != null && (second = pair.getSecond()) != null) {
                second.release();
            }
            map.remove(mediaPath);
        }
    }

    private final void M(LocalMediaInfo info) {
        if (info.mMimeType != null) {
            return;
        }
        info.mMimeType = "image";
    }

    private final void O(String url, byte[] array, long timestamp, int index) {
        w53.b.a("ExtractCoverHelper", "writeFile url: " + url + ",timestamp: " + timestamp + ", index: " + index);
        try {
            File file = new File(com.tencent.mobileqq.wink.edit.manager.h.d().b(u53.f.B, com.tencent.open.base.g.d(url)));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, index + "-" + timestamp + ".jpeg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(array);
            fileOutputStream.close();
        } catch (Exception e16) {
            w53.b.d("ExtractCoverHelper", "writeFile url: " + url, e16);
        }
    }

    private final void P(String url, byte[] array, long timestamp, int index) {
        if (ar.f326685a.c("SP_SAVE_RECOMMEND_THUMB", false)) {
            O(url, array, timestamp, index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(LocalMediaInfo toAddedMedia) {
        List emptyList;
        Object obj;
        Intrinsics.checkNotNullParameter(toAddedMedia, "$toAddedMedia");
        Map<String, Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f>> map = thumbProviders;
        if (map.size() == QzoneConfig.getWinkTemplateSampleMaxCount()) {
            Iterator<T> it = map.entrySet().iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                Object next = it.next();
                if (it.hasNext()) {
                    long longValue = ((Number) ((Pair) ((Map.Entry) next).getValue()).getFirst()).longValue();
                    do {
                        Object next2 = it.next();
                        long longValue2 = ((Number) ((Pair) ((Map.Entry) next2).getValue()).getFirst()).longValue();
                        if (longValue > longValue2) {
                            next = next2;
                            longValue = longValue2;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (entry != null) {
                f320276a.L((String) entry.getKey());
            }
        }
        ExtractCoverHelper extractCoverHelper = f320276a;
        Size H = extractCoverHelper.H(Integer.valueOf(toAddedMedia.mediaWidth), Integer.valueOf(toAddedMedia.mediaHeight));
        if (H != null) {
            extractCoverHelper.L(toAddedMedia.path);
            Map<String, Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f>> map2 = thumbProviders;
            String str = toAddedMedia.path;
            Intrinsics.checkNotNullExpressionValue(str, "toAddedMedia.path");
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            String str2 = toAddedMedia.path;
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "toAddedMedia.path ?: \"\"");
            }
            String uuid = UUID.randomUUID().toString();
            String str3 = toAddedMedia.path;
            ClipType clipType = ClipType.VIDEO;
            long j3 = 1000000 * toAddedMedia.mDuration;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            n r16 = extractCoverHelper.r(H, str2, new ClipSource(uuid, str3, clipType, j3, Float.valueOf(1.0f), Float.valueOf(1.0f), 0L, emptyList, null, null, null, null, null, 6912, null));
            Bitmap b16 = r16.b(0L);
            if (b16 != null) {
                b16.recycle();
            }
            map2.put(str, new Pair<>(valueOf, r16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] n(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        if (bytes.length > 20000) {
            w53.b.a("ExtractCoverHelper", "size:" + bytes.length + ", hit lower quality");
            byteArrayOutputStream.reset();
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, (int) (QzoneConfig.getWinkTemplateSampleQuality() * 100), byteArrayOutputStream);
            }
            bytes = byteArrayOutputStream.toByteArray();
        }
        Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
        return bytes;
    }

    private final List<Long> o(long multiCutVideoDurationInMs) {
        LinkedList linkedList = new LinkedList();
        if (multiCutVideoDurationInMs > 60000) {
            multiCutVideoDurationInMs = 60000;
        }
        long winkTemplateSampleMaxCount = QzoneConfig.getWinkTemplateSampleMaxCount();
        long j3 = multiCutVideoDurationInMs / winkTemplateSampleMaxCount;
        if (j3 > 1000) {
            j3 = (multiCutVideoDurationInMs - 1000) / winkTemplateSampleMaxCount;
        }
        long j16 = 0;
        for (int i3 = 0; i3 < winkTemplateSampleMaxCount && j16 < multiCutVideoDurationInMs; i3++) {
            j16 += j3;
            linkedList.add(Long.valueOf(1000 * j16));
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        Iterator<Map.Entry<String, Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f>>> it = thumbProviders.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().getSecond().release();
        }
        thumbProviders.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n r(Size targetSize, String path, ClipSource clipSource) {
        boolean z16;
        int i3;
        List<ClipSource> mutableListOf;
        ClipType type = clipSource.getType();
        ClipType clipType = ClipType.VIDEO;
        if (type == clipType) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (clipSource.getType() == clipType) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        n nVar = new n(targetSize, new ThumbAssetModel(path, i3, clipSource.getDuration()));
        if (!z16) {
            rd4.c cVar = rd4.c.f431135f;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(clipSource);
            nVar.h(cVar.y(mutableListOf));
            nVar.i(q.f319269a.d(path));
        } else {
            nVar.i(false);
        }
        return nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00da A[Catch: all -> 0x00ea, TRY_LEAVE, TryCatch #0 {all -> 0x00ea, blocks: (B:15:0x0051, B:17:0x005f, B:22:0x0075, B:27:0x007c, B:29:0x00da, B:36:0x006a), top: B:14:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<byte[]> t(List<? extends MediaClip> clips) {
        Integer num;
        com.tencent.mobileqq.wink.editor.clipping.thumbnail.f r16;
        com.tencent.mobileqq.wink.editor.clipping.thumbnail.f fVar;
        Bitmap b16;
        ArrayList<byte[]> arrayList = new ArrayList<>();
        long j3 = 0;
        long j16 = 0;
        for (MediaClip mediaClip : clips) {
            if (mediaClip.resource != null) {
                Integer num2 = null;
                ClipSource A = com.tencent.videocut.render.extension.e.A(mediaClip, false, null, 3, null);
                Intrinsics.checkNotNull(A);
                SizeF sizeF = mediaClip.resource.size;
                if (sizeF != null) {
                    num = Integer.valueOf((int) sizeF.width);
                } else {
                    num = null;
                }
                SizeF sizeF2 = mediaClip.resource.size;
                if (sizeF2 != null) {
                    num2 = Integer.valueOf((int) sizeF2.height);
                }
                Size H = H(num, num2);
                if (H == null) {
                    continue;
                } else {
                    try {
                        Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f> pair = thumbProviders.get(A.getPath());
                        if (pair != null) {
                            r16 = pair.getSecond();
                            if (r16 == null) {
                            }
                            fVar = r16;
                            if (fVar == null && (b16 = fVar.b(j3)) != null) {
                                Bitmap m3 = com.tencent.mobileqq.wink.utils.f.m(b16, H.width, H.height);
                                byte[] n3 = n(m3);
                                P(mediaClip.resource.path, n3, 0L, 0);
                                w53.b.a("ExtractCoverHelper", "final size: " + n3.length + ",bitmap width: " + m3.getWidth() + ", height: " + m3.getHeight());
                                j16 += (long) n3.length;
                                if (j16 < EXTRACT_BITMAP_PIC_MAX_BYTE) {
                                    break;
                                }
                                arrayList.add(n3);
                                m3.recycle();
                                b16.recycle();
                                fVar.release();
                            }
                        }
                        r16 = r(H, mediaClip.resource.path, A);
                        fVar = r16;
                        if (fVar == null) {
                            continue;
                        } else {
                            Bitmap m36 = com.tencent.mobileqq.wink.utils.f.m(b16, H.width, H.height);
                            byte[] n36 = n(m36);
                            P(mediaClip.resource.path, n36, 0L, 0);
                            w53.b.a("ExtractCoverHelper", "final size: " + n36.length + ",bitmap width: " + m36.getWidth() + ", height: " + m36.getHeight());
                            j16 += (long) n36.length;
                            if (j16 < EXTRACT_BITMAP_PIC_MAX_BYTE) {
                            }
                        }
                    } catch (Throwable th5) {
                        Throwable cause = th5.getCause();
                        th5.printStackTrace();
                        w53.b.c("ExtractCoverHelper", "throwable cause: " + cause + ", e: " + Unit.INSTANCE + ")");
                    }
                }
            }
            j3 = 0;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(List clips, final a callback) {
        Intrinsics.checkNotNullParameter(clips, "$clips");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        final ArrayList<byte[]> t16 = f320276a.t(clips);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.e
            @Override // java.lang.Runnable
            public final void run() {
                ExtractCoverHelper.w(ExtractCoverHelper.a.this, t16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(a callback, ArrayList result) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(result, "$result");
        callback.a(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(23:62|63|64|(5:65|66|67|68|69)|(18:74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(2:97|98)(5:92|93|94|95|96))|117|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:62|63|64|65|66|67|68|69|(18:74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(2:97|98)(5:92|93|94|95|96))|117|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01c3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01dc, code lost:
    
        r24 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01c5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01c6, code lost:
    
        r22 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01c9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01ce, code lost:
    
        r22 = r4;
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01cb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01cc, code lost:
    
        r20 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01d3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d4, code lost:
    
        r22 = r4;
        r21 = r8;
        r20 = r14;
        r19 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b1 A[Catch: all -> 0x01c3, TRY_LEAVE, TryCatch #0 {all -> 0x01c3, blocks: (B:90:0x0183, B:92:0x01b1), top: B:89:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01af A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<byte[]> x(List<? extends MediaClip> clips, long totalDurationUs) {
        boolean z16;
        Integer num;
        com.tencent.mobileqq.wink.editor.clipping.thumbnail.f r16;
        List<Long> list;
        long j3;
        List<Long> list2;
        long j16;
        Iterator it;
        Iterator<Long> it5;
        MediaClip mediaClip;
        String str;
        Iterator<Long> it6;
        Bitmap b16;
        byte[] n3;
        ResourceModel resourceModel;
        String str2;
        String str3;
        SizeF sizeF;
        SizeF sizeF2;
        List<Long> o16 = o(totalDurationUs / 1000);
        ArrayList<byte[]> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it7 = clips.iterator();
        while (true) {
            z16 = false;
            if (!it7.hasNext()) {
                break;
            }
            Object next = it7.next();
            if (((MediaClip) next).resource != null) {
                z16 = true;
            }
            if (z16) {
                arrayList2.add(next);
            }
        }
        Iterator it8 = arrayList2.iterator();
        int i3 = 0;
        long j17 = 0;
        while (it8.hasNext()) {
            MediaClip mediaClip2 = (MediaClip) it8.next();
            Integer num2 = null;
            ClipSource A = com.tencent.videocut.render.extension.e.A(mediaClip2, z16, null, 3, null);
            Intrinsics.checkNotNull(A);
            ExtractCoverHelper extractCoverHelper = f320276a;
            ResourceModel resourceModel2 = mediaClip2.resource;
            if (resourceModel2 != null && (sizeF2 = resourceModel2.size) != null) {
                num = Integer.valueOf((int) sizeF2.width);
            } else {
                num = null;
            }
            ResourceModel resourceModel3 = mediaClip2.resource;
            if (resourceModel3 != null && (sizeF = resourceModel3.size) != null) {
                num2 = Integer.valueOf((int) sizeF.height);
            }
            Size H = extractCoverHelper.H(num, num2);
            if (H == null) {
                list = o16;
                j16 = currentTimeMillis;
                it = it8;
            } else {
                Pair<Long, com.tencent.mobileqq.wink.editor.clipping.thumbnail.f> pair = thumbProviders.get(A.getPath());
                String str4 = "";
                if (pair == null || (r16 = pair.getSecond()) == null) {
                    String path = A.getPath();
                    if (path == null) {
                        path = "";
                    }
                    r16 = extractCoverHelper.r(H, path, A);
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<Long> it9 = o16.iterator();
                while (it9.hasNext()) {
                    List<Long> list3 = o16;
                    long longValue = it9.next().longValue() - i3;
                    if (longValue >= 0 && longValue <= A.getDuration()) {
                        arrayList3.add(Long.valueOf(longValue));
                    }
                    o16 = list3;
                }
                list = o16;
                if (A.getType() == ClipType.VIDEO) {
                    j3 = j17;
                    list2 = com.tencent.tavcut.core.utils.a.a(A.getPath(), arrayList3, JsonGrayBusiId.UI_RESERVE_100000_110000);
                } else {
                    j3 = j17;
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.addAll(arrayList3);
                    list2 = arrayList4;
                }
                w53.b.f("ExtractCoverHelper", "extractBitmapsForVideo keyFrameStamp: " + list2);
                Iterator<Long> it10 = list2.iterator();
                j17 = j3;
                int i16 = 0;
                while (true) {
                    if (it10.hasNext()) {
                        Long timestamp = it10.next();
                        try {
                            Intrinsics.checkNotNullExpressionValue(timestamp, "timestamp");
                            it6 = it10;
                            try {
                                b16 = r16.b(timestamp.longValue());
                            } catch (Throwable th5) {
                                th = th5;
                                j16 = currentTimeMillis;
                                it = it8;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            it5 = it10;
                            j16 = currentTimeMillis;
                            it = it8;
                        }
                        if (b16 == null) {
                            it10 = it6;
                        } else {
                            ExtractCoverHelper extractCoverHelper2 = f320276a;
                            it = it8;
                            try {
                                n3 = extractCoverHelper2.n(b16);
                                it5 = it6;
                                try {
                                    resourceModel = mediaClip2.resource;
                                } catch (Throwable th7) {
                                    th = th7;
                                    j16 = currentTimeMillis;
                                    mediaClip = mediaClip2;
                                    str = str4;
                                    Throwable cause = th.getCause();
                                    th.printStackTrace();
                                    w53.b.c("ExtractCoverHelper", "throwable cause: " + cause + ", e: " + Unit.INSTANCE + ")");
                                    it8 = it;
                                    it10 = it5;
                                    str4 = str;
                                    mediaClip2 = mediaClip;
                                    currentTimeMillis = j16;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                j16 = currentTimeMillis;
                                it5 = it6;
                                mediaClip = mediaClip2;
                                str = str4;
                                Throwable cause2 = th.getCause();
                                th.printStackTrace();
                                w53.b.c("ExtractCoverHelper", "throwable cause: " + cause2 + ", e: " + Unit.INSTANCE + ")");
                                it8 = it;
                                it10 = it5;
                                str4 = str;
                                mediaClip2 = mediaClip;
                                currentTimeMillis = j16;
                            }
                            if (resourceModel != null && (str3 = resourceModel.path) != null) {
                                str2 = str3;
                                int i17 = i16 + 1;
                                extractCoverHelper2.P(str2, n3, timestamp.longValue(), i16);
                                MediaClip mediaClip3 = mediaClip2;
                                str = str4;
                                long length = n3.length;
                                int width = b16.getWidth();
                                mediaClip = mediaClip3;
                                int height = b16.getHeight();
                                int i18 = i17;
                                StringBuilder sb5 = new StringBuilder();
                                j16 = currentTimeMillis;
                                sb5.append("final size: ");
                                sb5.append(length);
                                sb5.append(",bitmap width: ");
                                sb5.append(width);
                                sb5.append(", height: ");
                                sb5.append(height);
                                w53.b.a("ExtractCoverHelper", sb5.toString());
                                j17 += n3.length;
                                if (j17 < EXTRACT_BITMAP_PIC_MAX_BYTE) {
                                    break;
                                }
                                arrayList.add(n3);
                                b16.recycle();
                                it8 = it;
                                it10 = it5;
                                str4 = str;
                                mediaClip2 = mediaClip;
                                i16 = i18;
                                currentTimeMillis = j16;
                            }
                            str2 = str4;
                            int i172 = i16 + 1;
                            extractCoverHelper2.P(str2, n3, timestamp.longValue(), i16);
                            MediaClip mediaClip32 = mediaClip2;
                            str = str4;
                            long length2 = n3.length;
                            int width2 = b16.getWidth();
                            mediaClip = mediaClip32;
                            int height2 = b16.getHeight();
                            int i182 = i172;
                            StringBuilder sb52 = new StringBuilder();
                            j16 = currentTimeMillis;
                            sb52.append("final size: ");
                            sb52.append(length2);
                            sb52.append(",bitmap width: ");
                            sb52.append(width2);
                            sb52.append(", height: ");
                            sb52.append(height2);
                            w53.b.a("ExtractCoverHelper", sb52.toString());
                            j17 += n3.length;
                            if (j17 < EXTRACT_BITMAP_PIC_MAX_BYTE) {
                            }
                        }
                    } else {
                        j16 = currentTimeMillis;
                        it = it8;
                        break;
                    }
                }
                i3 += (int) A.getDuration();
                r16.release();
                TypeIntrinsics.asMutableMap(thumbProviders).remove(A.getPath());
            }
            it8 = it;
            o16 = list;
            currentTimeMillis = j16;
            z16 = false;
        }
        w53.b.f("ExtractCoverHelper", "extract cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", frame count: " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        if (r1 == com.tencent.videocut.model.MediaType.VIDEO) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void z(List clips, long j3, final a callback) {
        final ArrayList<byte[]> x16;
        float f16;
        MediaType mediaType;
        SizeF sizeF;
        SizeF sizeF2;
        Intrinsics.checkNotNullParameter(clips, "$clips");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean isExperiment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_optimize_auto_music_2");
        if (clips.size() == 1) {
            ResourceModel resourceModel = ((MediaClip) clips.get(0)).resource;
            float f17 = 0.0f;
            if (resourceModel != null && (sizeF2 = resourceModel.size) != null) {
                f16 = sizeF2.height;
            } else {
                f16 = 0.0f;
            }
            if (f16 < 1920.0f) {
                ResourceModel resourceModel2 = ((MediaClip) clips.get(0)).resource;
                if (resourceModel2 != null && (sizeF = resourceModel2.size) != null) {
                    f17 = sizeF.width;
                }
                if (f17 < 1920.0f) {
                    ResourceModel resourceModel3 = ((MediaClip) clips.get(0)).resource;
                    if (resourceModel3 != null) {
                        mediaType = resourceModel3.type;
                    } else {
                        mediaType = null;
                    }
                }
            }
        }
        isExperiment = false;
        if (isExperiment) {
            x16 = f320276a.B(clips, j3);
        } else {
            x16 = f320276a.x(clips, j3);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.g
            @Override // java.lang.Runnable
            public final void run() {
                ExtractCoverHelper.A(ExtractCoverHelper.a.this, x16);
            }
        });
    }

    @Nullable
    public final Object C(@NotNull List<? extends LocalMediaInfo> list, @NotNull Continuation<? super ArrayList<byte[]>> continuation) {
        MediaData mediaData;
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Ref.LongRef longRef = new Ref.LongRef();
        final ArrayList arrayList = new ArrayList();
        for (LocalMediaInfo localMediaInfo : list) {
            if (e93.i.I(localMediaInfo)) {
                longRef.element += localMediaInfo.mDuration;
                mediaData = f320276a.G(localMediaInfo);
            } else if (e93.i.G(localMediaInfo)) {
                mediaData = f320276a.F(localMediaInfo, list.size());
                longRef.element += mediaData.b() / 1000;
            } else {
                mediaData = null;
            }
            if (mediaData != null) {
                arrayList.add(mediaData);
            }
        }
        f320276a.I().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper$extractCover$2$1
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList x16;
                Continuation<ArrayList<byte[]>> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                x16 = ExtractCoverHelper.f320276a.x(com.tencent.videocut.render.repository.a.f384196a.b(arrayList).videos, longRef.element * 1000);
                continuation2.resumeWith(Result.m476constructorimpl(x16));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void D(@NotNull List<? extends LocalMediaInfo> media, @NotNull a callback) {
        MediaData mediaData;
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        for (LocalMediaInfo localMediaInfo : media) {
            if (e93.i.I(localMediaInfo)) {
                j3 += localMediaInfo.mDuration;
                mediaData = f320276a.G(localMediaInfo);
            } else if (e93.i.G(localMediaInfo)) {
                mediaData = f320276a.F(localMediaInfo, media.size());
                j3 += mediaData.b() / 1000;
            } else {
                mediaData = null;
            }
            if (mediaData != null) {
                arrayList.add(mediaData);
            }
        }
        y(com.tencent.videocut.render.repository.a.f384196a.b(arrayList).videos, j3 * 1000, callback);
    }

    @Nullable
    public final Object E(@NotNull final LocalMediaInfo localMediaInfo, @NotNull final List<Long> list, final int i3, @NotNull final String str, @NotNull Continuation<? super List<String>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Function0<List<String>> function0 = new Function0<List<String>>() { // from class: com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper$extractVideoFrames$2$extract$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<String> invoke() {
                Size size;
                List<MediaData> mutableListOf;
                n r16;
                LocalMediaInfo localMediaInfo2 = LocalMediaInfo.this;
                int i16 = localMediaInfo2.mediaWidth;
                int i17 = localMediaInfo2.mediaHeight;
                if (i16 > i17) {
                    int i18 = i3;
                    size = new Size(i18, (i17 * i18) / i16);
                } else {
                    int i19 = i3;
                    size = new Size((i16 * i19) / i17, i19);
                }
                com.tencent.videocut.render.repository.a aVar = com.tencent.videocut.render.repository.a.f384196a;
                ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(extractCoverHelper.G(LocalMediaInfo.this));
                MediaClip mediaClip = aVar.b(mutableListOf).videos.get(0);
                String str2 = LocalMediaInfo.this.path;
                Intrinsics.checkNotNullExpressionValue(str2, "media.path");
                ClipSource A = com.tencent.videocut.render.extension.e.A(mediaClip, false, null, 3, null);
                Intrinsics.checkNotNull(A);
                r16 = extractCoverHelper.r(size, str2, A);
                ArrayList arrayList = new ArrayList();
                Iterator<Long> it = list.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    try {
                        Bitmap b16 = r16.b(longValue);
                        if (b16 == null) {
                            w53.b.c("ExtractCoverHelper", "extractVideoFrames file failed: file: " + LocalMediaInfo.this.path + ", timestamp: " + longValue);
                            arrayList.add("");
                        } else {
                            String path = new File(str, com.tencent.open.base.g.d(LocalMediaInfo.this.path) + "-" + longValue + ".jpeg").getPath();
                            Intrinsics.checkNotNullExpressionValue(path, "path");
                            arrayList.add(path);
                            com.tencent.mobileqq.wink.utils.f.u(path, b16, 90);
                            b16.recycle();
                        }
                    } catch (Exception e16) {
                        w53.b.d("ExtractCoverHelper", "extractVideoFrames failed", e16);
                    }
                }
                r16.release();
                return arrayList;
            }
        };
        f320276a.I().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper$extractVideoFrames$2$1
            @Override // java.lang.Runnable
            public final void run() {
                Continuation<List<String>> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(function0.invoke()));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @NotNull
    public final MediaData F(@NotNull LocalMediaInfo mediaInfo, int mediaSize) {
        long j3;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        M(mediaInfo);
        if (mediaInfo.mediaWidth == 0 || mediaInfo.mediaHeight == 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(mediaInfo.path, options);
            mediaInfo.mediaWidth = options.outWidth;
            mediaInfo.mediaHeight = options.outHeight;
        }
        if (mediaInfo.mediaWidth == 0 || mediaInfo.mediaHeight == 0) {
            mediaInfo.mediaWidth = 720;
            mediaInfo.mediaHeight = 1280;
        }
        if (mediaSize > 1) {
            j3 = 2500000;
        } else {
            j3 = 10000000;
        }
        String str = mediaInfo.mMimeType;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.mMimeType");
        int i3 = mediaInfo.mediaWidth;
        int i16 = mediaInfo.mediaHeight;
        String str2 = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str2, "mediaInfo.path");
        return new MediaData(1, str, i3, i16, 0L, 0L, j3, str2, mediaInfo.path, mediaInfo.mAlbumName);
    }

    @NotNull
    public final MediaData G(@NotNull LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String str = mediaInfo.mMimeType;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.mMimeType");
        int i3 = mediaInfo.mediaWidth;
        int i16 = mediaInfo.mediaHeight;
        long j3 = mediaInfo.mDuration * 1000;
        String str2 = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str2, "mediaInfo.path");
        return new MediaData(0, str, i3, i16, 0L, 0L, j3, str2, mediaInfo.path, mediaInfo.mAlbumName);
    }

    public final void J(@NotNull final LocalMediaInfo toRemovedMedia) {
        Intrinsics.checkNotNullParameter(toRemovedMedia, "toRemovedMedia");
        I().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.d
            @Override // java.lang.Runnable
            public final void run() {
                ExtractCoverHelper.K(LocalMediaInfo.this);
            }
        });
    }

    public final void N(boolean isReady) {
        isResReady = isReady;
    }

    public final void l(@NotNull final LocalMediaInfo toAddedMedia) {
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        if (!isResReady) {
            return;
        }
        I().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.f
            @Override // java.lang.Runnable
            public final void run() {
                ExtractCoverHelper.m(LocalMediaInfo.this);
            }
        });
    }

    public final void p() {
        I().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.a
            @Override // java.lang.Runnable
            public final void run() {
                ExtractCoverHelper.q();
            }
        });
    }

    public final void s(@NotNull List<? extends LocalMediaInfo> media, @NotNull a callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        boolean z17 = true;
        for (LocalMediaInfo localMediaInfo : media) {
            boolean z18 = false;
            MediaData mediaData = null;
            if (e93.i.I(localMediaInfo)) {
                String str = localMediaInfo.path;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    j3 += localMediaInfo.mDuration;
                    mediaData = f320276a.G(localMediaInfo);
                    z17 = false;
                }
            } else if (e93.i.G(localMediaInfo)) {
                String str2 = localMediaInfo.path;
                if (str2 == null || str2.length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    mediaData = f320276a.F(localMediaInfo, media.size());
                    j3 += mediaData.b() / 1000;
                }
            }
            if (mediaData != null) {
                arrayList.add(mediaData);
            }
        }
        if (z17) {
            u(com.tencent.videocut.render.repository.a.f384196a.b(arrayList).videos, callback);
        } else {
            y(com.tencent.videocut.render.repository.a.f384196a.b(arrayList).videos, j3, callback);
        }
    }

    public final void u(@NotNull final List<? extends MediaClip> clips, @NotNull final a callback) {
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(callback, "callback");
        I().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.b
            @Override // java.lang.Runnable
            public final void run() {
                ExtractCoverHelper.v(clips, callback);
            }
        });
    }

    public final void y(@NotNull final List<? extends MediaClip> clips, final long totalDurationUs, @NotNull final a callback) {
        Intrinsics.checkNotNullParameter(clips, "clips");
        Intrinsics.checkNotNullParameter(callback, "callback");
        I().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.c
            @Override // java.lang.Runnable
            public final void run() {
                ExtractCoverHelper.z(clips, totalDurationUs, callback);
            }
        });
    }
}
