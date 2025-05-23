package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.content.Context;
import android.database.StaleDataException;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.gallery.MiniPhotoListAdapter;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.PTFaceAttr;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003FGHB\u000f\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J;\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000bH\u0007J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0005J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0015H\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00030&j\b\u0012\u0004\u0012\u00020\u0003`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00103R.\u0010B\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:8\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u00105\u00a8\u0006I"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/af;", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/ac;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "v0", "Landroid/content/Context;", "context", "", "detectFace", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onEmpty", "B0", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "z0", "Landroid/view/ViewGroup;", "vg", "", "position", "t0", "holder", "r0", "localMediaInfo", "y0", "o0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "u0", "getItemCount", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$b;", "preSelectListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "data", "D", "I", "currentSelectedIndex", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$ScanJob;", "E", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$ScanJob;", "scanJob", UserInfo.SEX_FEMALE, "Z", "q0", "()Z", "setDetectFace", "(Z)V", "G", "headerInserted", "", "value", "H", "Ljava/lang/String;", "p0", "()Ljava/lang/String;", "A0", "(Ljava/lang/String;)V", "bindId", "isEmpty", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$b;)V", "a", "b", "ScanJob", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MiniPhotoListAdapter extends RecyclerView.Adapter<af> {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String J = "PhotoListAdapter";

    /* renamed from: C, reason: from kotlin metadata */
    private final ArrayList<PhotoInfo> data;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentSelectedIndex;

    /* renamed from: E, reason: from kotlin metadata */
    private ScanJob scanJob;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean detectFace;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean headerInserted;

    /* renamed from: H, reason: from kotlin metadata */
    private String bindId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final b preSelectListener;

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u00010Ba\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012H\u0010\u0018\u001aD\u0012\u001e\u0012\u001c\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tj\u0002`\u000b\u0018\u00010\u0002\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\u000b\u0012\u0004\u0012\u00020\u00070\u0016\u00a2\u0006\u0004\b-\u0010.J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\r\u001a\u00020\u00072\u001e\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tj\u0002`\u000b0\u0002H\u0002J\"\u0010\u000f\u001a\u00020\u000e2\u0018\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tj\u0002`\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014RV\u0010\u0018\u001aD\u0012\u001e\u0012\u001c\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tj\u0002`\u000b\u0018\u00010\u0002\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\u000b\u0012\u0004\u0012\u00020\u00070\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R*\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$R\u001c\u0010*\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00061"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$ScanJob;", "Ljava/lang/Runnable;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "inputList", "", "concurrentCount", "", "c", "Lkotlin/Pair;", "Lcom/tencent/ttpic/openapi/PTFaceAttr;", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/DetectPair;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, tl.h.F, "", "i", "e", "g", TencentLocation.RUN_MODE, "d", "Z", "detectFace", "Lkotlin/Function2;", "Lkotlin/jvm/functions/Function2;", "consumer", "value", "f", "getCancelled", "()Z", "j", "(Z)V", "cancelled", "getEnough", "setEnough", "enough", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "maxCount", "Lcom/tencent/mobileqq/activity/photo/album/querymedia/MediaQueryHelper;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/photo/album/querymedia/MediaQueryHelper;", "queryHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function2;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class ScanJob implements Runnable {

        /* renamed from: C, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean detectFace;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final Function2<List<? extends Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>>, Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>, Unit> consumer;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private volatile boolean cancelled;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private volatile boolean enough;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final AtomicInteger maxCount;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final MediaQueryHelper queryHelper;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$ScanJob$a;", "", "", "path", "Lcom/tencent/ttpic/openapi/PTFaceAttr;", "a", "", "CONCURRENT_COUNT", "I", "MAX_PHOTO_COUNT", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.aelight.camera.ae.camera.ui.gallery.MiniPhotoListAdapter$ScanJob$a, reason: from kotlin metadata */
        /* loaded from: classes32.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0030  */
            /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
            @JvmStatic
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final PTFaceAttr a(String path) {
                boolean z16;
                Bitmap c36;
                PTFaceAttr detectFace;
                boolean isBlank;
                if (path != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(path);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16 || !new File(path).exists()) {
                            return null;
                        }
                        try {
                            c36 = CameraPeakServiceHandler.c3(path);
                            if (c36 != null || (detectFace = FaceChangeUtils.detectFace(c36)) == null) {
                                return null;
                            }
                            if (FaceChangeUtils.hasValidFace(detectFace)) {
                                return null;
                            }
                            return detectFace;
                        } catch (Exception e16) {
                            ms.a.d(MiniPhotoListAdapter.INSTANCE.a(), "check face fail", e16);
                            return null;
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                    return null;
                }
                c36 = CameraPeakServiceHandler.c3(path);
                if (c36 != null) {
                    return null;
                }
                if (FaceChangeUtils.hasValidFace(detectFace)) {
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ScanJob(Context context, boolean z16, Function2<? super List<? extends Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>>, ? super Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>, Unit> consumer) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            this.detectFace = z16;
            this.consumer = consumer;
            this.maxCount = new AtomicInteger(0);
            this.queryHelper = new MediaQueryHelper.Builder().needImage(true).needVideo(false).setAlbumId(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID).setLimit(300).setListener(new ICursor.FilterListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.y
                @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.FilterListener
                public final boolean needMediaInfo(LocalMediaInfo localMediaInfo) {
                    boolean f16;
                    f16 = MiniPhotoListAdapter.ScanJob.f(MiniPhotoListAdapter.ScanJob.this, localMediaInfo);
                    return f16;
                }
            }).build(context);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0011 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void c(List<? extends LocalMediaInfo> inputList, int concurrentCount) {
            List take;
            int collectionSizeOrDefault;
            boolean endsWith$default;
            boolean z16;
            boolean endsWith$default2;
            if (!this.detectFace) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : inputList) {
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                    String str = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str, "it.path");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
                    if (!endsWith$default) {
                        String str2 = localMediaInfo.path;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.path");
                        endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str2, ".ico", false, 2, null);
                        if (!endsWith$default2) {
                            z16 = true;
                            if (!z16) {
                                arrayList.add(obj);
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                }
                take = CollectionsKt___CollectionsKt.take(arrayList, 45);
                List list = take;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(TuplesKt.to(null, (LocalMediaInfo) it.next()));
                }
                h(arrayList2);
                return;
            }
            if (inputList.size() < concurrentCount * 2) {
                e(inputList);
                return;
            }
            int i3 = concurrentCount - 1;
            final CountDownLatch countDownLatch = new CountDownLatch(i3);
            int size = inputList.size() / concurrentCount;
            System.currentTimeMillis();
            int i16 = 0;
            while (i16 < concurrentCount) {
                int i17 = i16 + 1;
                final List<? extends LocalMediaInfo> subList = inputList.subList(i16 * size, i17 * size);
                if (i16 == i3) {
                    e(subList);
                } else {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiniPhotoListAdapter.ScanJob.d(MiniPhotoListAdapter.ScanJob.this, subList, countDownLatch);
                        }
                    }, 64, null, false);
                }
                i16 = i17;
            }
            try {
                countDownLatch.await();
            } catch (Exception e16) {
                ms.a.e(MiniPhotoListAdapter.INSTANCE.a(), e16);
            }
            System.currentTimeMillis();
            MiniPhotoListAdapter.INSTANCE.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ScanJob this$0, List subList, CountDownLatch latch) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(subList, "$subList");
            Intrinsics.checkNotNullParameter(latch, "$latch");
            try {
                this$0.e(subList);
            } finally {
                latch.countDown();
            }
        }

        private final void e(List<? extends LocalMediaInfo> inputList) {
            boolean endsWith$default;
            boolean endsWith$default2;
            for (LocalMediaInfo localMediaInfo : inputList) {
                if (this.cancelled) {
                    return;
                }
                String str = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str, "it.path");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
                if (!endsWith$default) {
                    String str2 = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.path");
                    endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str2, ".ico", false, 2, null);
                    if (endsWith$default2) {
                        continue;
                    } else {
                        String str3 = localMediaInfo.path;
                        Companion companion = MiniPhotoListAdapter.INSTANCE;
                        companion.a();
                        PTFaceAttr a16 = INSTANCE.a(str3);
                        companion.a();
                        if ((a16 != null && !i(TuplesKt.to(a16, localMediaInfo))) || this.enough) {
                            return;
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean f(ScanJob this$0, LocalMediaInfo localMediaInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.cancelled) {
                throw new StaleDataException("cancel query by user");
            }
            return true;
        }

        private final List<LocalMediaInfo> g() {
            Companion companion = MiniPhotoListAdapter.INSTANCE;
            companion.a();
            System.currentTimeMillis();
            this.queryHelper.queryAll();
            System.currentTimeMillis();
            companion.a();
            List<LocalMediaInfo> list = this.queryHelper.mediaList;
            Intrinsics.checkNotNullExpressionValue(list, "queryHelper.mediaList");
            return list;
        }

        private final void h(List<? extends Pair<? extends PTFaceAttr, ? extends LocalMediaInfo>> item) {
            if (this.cancelled) {
                return;
            }
            this.consumer.invoke(item, null);
        }

        private final boolean i(Pair<? extends PTFaceAttr, ? extends LocalMediaInfo> item) {
            if (this.cancelled) {
                return false;
            }
            this.consumer.invoke(null, item);
            if (this.maxCount.incrementAndGet() < 45) {
                return true;
            }
            this.enough = true;
            return false;
        }

        public final void j(boolean z16) {
            this.cancelled = z16;
            this.queryHelper.close();
        }

        @Override // java.lang.Runnable
        public void run() {
            c(g(), 1);
            MiniPhotoListAdapter.INSTANCE.a();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "getTAG$annotations", "()V", "<init>", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.gallery.MiniPhotoListAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return MiniPhotoListAdapter.J;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/MiniPhotoListAdapter$b;", "", "Lcom/tencent/ttpic/openapi/PTFaceAttr;", "attr", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void a(PTFaceAttr attr, LocalMediaInfo info);
    }

    public MiniPhotoListAdapter(b preSelectListener) {
        Intrinsics.checkNotNullParameter(preSelectListener, "preSelectListener");
        this.preSelectListener = preSelectListener;
        this.data = new ArrayList<>();
        this.currentSelectedIndex = -1;
        this.detectFace = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEmpty() {
        boolean z16;
        if (this.data.isEmpty()) {
            return true;
        }
        ArrayList<PhotoInfo> arrayList = this.data;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((PhotoInfo) it.next()) == PhotoInfo.INSTANCE.a()) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(af holder, MiniPhotoListAdapter this$0, View view) {
        Object orNull;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.data, holder.getAdapterPosition());
        PhotoInfo photoInfo = (PhotoInfo) orNull;
        if (photoInfo != null && !photoInfo.getSelected()) {
            this$0.v0(photoInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v0(final PhotoInfo item) {
        if (item.getDetectResult() == null && this.detectFace) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.v
                @Override // java.lang.Runnable
                public final void run() {
                    MiniPhotoListAdapter.w0(PhotoInfo.this, this);
                }
            }, 64, null, false);
            return;
        }
        b bVar = this.preSelectListener;
        PTFaceAttr detectResult = item.getDetectResult();
        LocalMediaInfo info = item.getInfo();
        Intrinsics.checkNotNull(info);
        bVar.a(detectResult, info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(final PhotoInfo item, final MiniPhotoListAdapter this$0) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScanJob.Companion companion = ScanJob.INSTANCE;
        LocalMediaInfo info = item.getInfo();
        final PTFaceAttr a16 = companion.a(info != null ? info.path : null);
        item.f(a16);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.w
            @Override // java.lang.Runnable
            public final void run() {
                MiniPhotoListAdapter.x0(PTFaceAttr.this, this$0, item);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(PTFaceAttr pTFaceAttr, MiniPhotoListAdapter this$0, PhotoInfo item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (pTFaceAttr != null) {
            b bVar = this$0.preSelectListener;
            PTFaceAttr detectResult = item.getDetectResult();
            LocalMediaInfo info = item.getInfo();
            Intrinsics.checkNotNull(info);
            bVar.a(detectResult, info);
            return;
        }
        this$0.preSelectListener.a(null, null);
    }

    public final void A0(String str) {
        this.bindId = str;
        if (!isEmpty()) {
            this.currentSelectedIndex = 0;
            Iterator<PhotoInfo> it = this.data.iterator();
            while (it.hasNext()) {
                it.next().g(false);
            }
        }
        notifyDataSetChanged();
    }

    public final void B0(Context context, boolean detectFace, Function1<? super Boolean, Unit> onEmpty) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onEmpty, "onEmpty");
        this.detectFace = detectFace;
        this.data.clear();
        this.headerInserted = false;
        this.currentSelectedIndex = -1;
        ArrayList<PhotoInfo> arrayList = this.data;
        ArrayList arrayList2 = new ArrayList(10);
        for (int i3 = 0; i3 < 10; i3++) {
            arrayList2.add(PhotoInfo.INSTANCE.a());
        }
        arrayList.addAll(arrayList2);
        ScanJob scanJob = this.scanJob;
        if (scanJob != null) {
            scanJob.j(true);
        }
        ScanJob scanJob2 = new ScanJob(context, detectFace, new MiniPhotoListAdapter$startQuery$2(this, onEmpty, detectFace));
        this.scanJob = scanJob2;
        ThreadManagerV2.excute(scanJob2, 96, null, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void o0() {
        Object orNull;
        int i3 = this.currentSelectedIndex;
        if (i3 >= 0) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.data, i3);
            PhotoInfo photoInfo = (PhotoInfo) orNull;
            if (photoInfo != null) {
                photoInfo.g(false);
                notifyItemChanged(this.currentSelectedIndex);
            }
            this.currentSelectedIndex = -1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        ScanJob scanJob = this.scanJob;
        if (scanJob == null) {
            return;
        }
        scanJob.j(true);
    }

    /* renamed from: p0, reason: from getter */
    public final String getBindId() {
        return this.bindId;
    }

    /* renamed from: q0, reason: from getter */
    public final boolean getDetectFace() {
        return this.detectFace;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final af holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PhotoInfo photoInfo = this.data.get(position);
        Intrinsics.checkNotNullExpressionValue(photoInfo, "data[position]");
        PhotoInfo photoInfo2 = photoInfo;
        if (photoInfo2.d()) {
            holder.getSelectFrame().setVisibility(8);
            holder.getImg().setVisibility(8);
            holder.getLoadingIcon().setVisibility(0);
            holder.itemView.setOnClickListener(null);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            holder.getLoadingIcon().setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/Android/res/loading_white.png", obtain));
            return;
        }
        holder.getSelectFrame().setVisibility(photoInfo2.getSelected() ? 0 : 8);
        holder.getImg().setVisibility(0);
        holder.getLoadingIcon().setVisibility(8);
        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        obtain2.mRequestWidth = eVar.a(48.0f);
        obtain2.mRequestHeight = eVar.a(48.0f);
        obtain2.mLoadingDrawable = new ColorDrawable(0);
        URLImageView img = holder.getImg();
        LocalMediaInfo info = photoInfo2.getInfo();
        Intrinsics.checkNotNull(info);
        img.setImageDrawable(URLDrawable.getDrawable("file://" + info.path, obtain2));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.gallery.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniPhotoListAdapter.s0(af.this, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public af onCreateViewHolder(ViewGroup vg5, int position) {
        Intrinsics.checkNotNullParameter(vg5, "vg");
        View itemView = LayoutInflater.from(vg5.getContext()).inflate(R.layout.dmf, vg5, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new af(itemView);
    }

    public final void u0() {
        ScanJob scanJob = this.scanJob;
        if (scanJob == null) {
            return;
        }
        scanJob.j(true);
    }

    public final void y0(LocalMediaInfo localMediaInfo) {
        int i3;
        Object orNull;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Iterator<PhotoInfo> it = this.data.iterator();
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                i16 = -1;
                break;
            }
            PhotoInfo next = it.next();
            LocalMediaInfo info = next.getInfo();
            if ((info != null && (localMediaInfo._id > info._id ? 1 : (localMediaInfo._id == info._id ? 0 : -1)) == 0) && Intrinsics.areEqual(localMediaInfo.path, next.getInfo().path)) {
                break;
            } else {
                i16++;
            }
        }
        if (i16 == -1 || i16 == (i3 = this.currentSelectedIndex)) {
            return;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.data, i3);
        PhotoInfo photoInfo = (PhotoInfo) orNull;
        if (photoInfo != null) {
            photoInfo.g(false);
            notifyItemChanged(this.currentSelectedIndex);
        }
        this.currentSelectedIndex = i16;
        this.data.get(i16).g(true);
        notifyItemChanged(i16);
    }

    public final void z0(LocalMediaInfo info) {
        Object orNull;
        Object orNull2;
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.headerInserted) {
            this.data.set(0, new PhotoInfo(true, info, null));
            int i3 = this.currentSelectedIndex;
            if (i3 > 0) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.data, i3);
                PhotoInfo photoInfo = (PhotoInfo) orNull2;
                if (photoInfo != null) {
                    photoInfo.g(false);
                    notifyItemChanged(this.currentSelectedIndex);
                }
            }
            this.currentSelectedIndex = 0;
            notifyItemChanged(0);
            return;
        }
        int i16 = this.currentSelectedIndex;
        if (i16 != -1) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.data, i16);
            PhotoInfo photoInfo2 = (PhotoInfo) orNull;
            if (photoInfo2 != null) {
                photoInfo2.g(false);
                notifyItemChanged(this.currentSelectedIndex);
            }
        }
        this.data.add(0, new PhotoInfo(true, info, null));
        this.currentSelectedIndex = 0;
        notifyItemInserted(0);
        this.headerInserted = true;
    }
}
