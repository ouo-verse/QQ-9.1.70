package com.tencent.mobileqq.wink.picker.interceptor;

import android.media.MediaMetadataRetriever;
import android.webkit.MimeTypeMap;
import androidx.exifinterface.media.ExifInterface;
import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.WinkPhotoListServiceHandler;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.VideoTemplateData;
import com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0004\u008a\u0001\u008b\u0001B\t\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0004J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0004J\b\u0010\u0018\u001a\u00020\u0007H\u0004J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0016H\u0004J\b\u0010\u001b\u001a\u00020\u0007H\u0014J\u001c\u0010\u001e\u001a\u00020\u00072\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001cH\u0004J\u001a\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u0005H\u0004J,\u0010(\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001cH\u0004J\u001c\u0010)\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010#H\u0004J\b\u0010*\u001a\u00020\u0007H\u0004J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020%0+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0+H\u0004J\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0\u001c2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0+H\u0014J\u001a\u00100\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010/H\u0004J&\u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/\u0018\u00010\u001cH\u0004J\u0010\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0014J\b\u00109\u001a\u00020\u0016H\u0014J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010:\u001a\u00020#H\u0004R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010=\u001a\u0004\b>\u0010?R$\u0010G\u001a\u0004\u0018\u00010A8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010N\u001a\u0004\u0018\u00010H8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010U\u001a\u0004\u0018\u00010O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR.\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050V8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R4\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\t0]8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR \u0010i\u001a\b\u0012\u0004\u0012\u00020e0d8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010f\u001a\u0004\bg\u0010hR$\u00102\u001a\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR&\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/0V8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010W\u001a\u0004\bo\u0010YR$\u0010u\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010{\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001b\u0010\u007f\u001a\u00020|8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010=\u001a\u0004\b}\u0010~R\u001f\u0010\u0083\u0001\u001a\u00030\u0080\u00018DX\u0084\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u001e\u0010=\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R+\u0010\u0087\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u0084\u00018DX\u0084\u0084\u0002\u00a2\u0006\u000e\n\u0004\bs\u0010=\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "index", "", "path", "", "H", "Lkotlin/Pair;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mime", "O", "logoUrl", "i", "g", "Lcom/tencent/mobileqq/wink/picker/d;", "templateLibraryData", "E", "Lcom/tencent/mobileqq/wink/picker/a;", "input", "", "G", "f", "isSuccess", BdhLogUtil.LogTag.Tag_Conn, "P", "", "data", "I", "Lcom/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor$b;", "info", "generatePath", "k", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig$Media;", "mediaConfig", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "uploadedImageUrls", "d", "j", tl.h.F, "", "selectedMedia", "u", ReportConstant.COSTREPORT_PREFIX, "", "D", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "templateInfoMap", "Lcom/tencent/mobileqq/wink/picker/e;", "B", "Lcom/tencent/mobileqq/winkpublish/report/MediaPickerErrorCode;", "errorCode", UserInfo.SEX_FEMALE, "e", "mediaPreProcessConfig", "c", "Landroid/media/MediaMetadataRetriever;", "Lkotlin/Lazy;", "w", "()Landroid/media/MediaMetadataRetriever;", "retriever", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "y", "()Ljava/util/concurrent/CountDownLatch;", "N", "(Ljava/util/concurrent/CountDownLatch;)V", "syncLatch", "Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "o", "()Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "L", "(Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;)V", "interceptException", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;", "setTemplatePreProcessConfig", "(Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;)V", "templatePreProcessConfig", "", "Ljava/util/Map;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/Map;", "setExtractedVideoFrameFiles", "(Ljava/util/Map;)V", "extractedVideoFrameFiles", "", "Ljava/util/List;", "r", "()Ljava/util/List;", "setNeedUploadImageInfos", "(Ljava/util/List;)V", "needUploadImageInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkPhotoListServiceHandler$d;", "Ljava/util/ArrayList;", "t", "()Ljava/util/ArrayList;", "processMediaInfos", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "l", "()Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "K", "(Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/lang/String;", "getAccount", "()Ljava/lang/String;", "J", "(Ljava/lang/String;)V", "account", "Z", "getNeedDownloadQQLogo", "()Z", "M", "(Z)V", "needDownloadQQLogo", "Lcom/google/gson/Gson;", DomainData.DOMAIN_NAME, "()Lcom/google/gson/Gson;", "gson", "Lcom/tencent/mobileqq/wink/edit/manager/WinkPhotoListServiceHandler;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/wink/edit/manager/WinkPhotoListServiceHandler;", "serviceHandler", "Ljava/util/TreeMap;", "v", "()Ljava/util/TreeMap;", "replaceLayerMediaInfoMap", "<init>", "()V", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class TemplateLibBaseMediaInterceptor implements com.tencent.mobileqq.wink.picker.interceptor.c, BusinessObserver {

    @NotNull
    private static final String L = u53.e.f438384a + "/templatelib_video_extract";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<WinkPhotoListServiceHandler.d> processMediaInfos;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private c.a chain;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Object> templateInfoMap;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String account;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needDownloadQQLogo;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy gson;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy serviceHandler;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy replaceLayerMediaInfoMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy retriever;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch syncLatch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterceptException interceptException;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TemplatePreProcessConfig templatePreProcessConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, String> extractedVideoFrameFiles;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Pair<String, Integer>> needUploadImageInfos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Integer) ((Map.Entry) t16).getKey(), (Integer) ((Map.Entry) t17).getKey());
            return compareValues;
        }
    }

    public TemplateLibBaseMediaInterceptor() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MediaMetadataRetriever>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor$retriever$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaMetadataRetriever invoke() {
                return new MediaMetadataRetriever();
            }
        });
        this.retriever = lazy;
        this.extractedVideoFrameFiles = new LinkedHashMap();
        this.needUploadImageInfos = new ArrayList();
        this.processMediaInfos = new ArrayList<>();
        this.templateInfoMap = new LinkedHashMap();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.gson = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkPhotoListServiceHandler>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor$serviceHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkPhotoListServiceHandler invoke() {
                BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkPhotoListServiceHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.edit.manager.WinkPhotoListServiceHandler");
                return (WinkPhotoListServiceHandler) businessHandler;
            }
        });
        this.serviceHandler = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TreeMap<Integer, ReplaceLayerMediaInfo>>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor$replaceLayerMediaInfoMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TreeMap<Integer, TemplateLibBaseMediaInterceptor.ReplaceLayerMediaInfo> invoke() {
                return new TreeMap<>();
            }
        });
        this.replaceLayerMediaInfoMap = lazy4;
    }

    private final void H(int index, String path) {
        ReplaceLayerMediaInfo replaceLayerMediaInfo = v().get(Integer.valueOf(index));
        if (replaceLayerMediaInfo != null) {
            k(replaceLayerMediaInfo, path);
        }
    }

    private final Pair<String, String> O(String mime) {
        boolean contains$default;
        int indexOf$default;
        if (mime == null) {
            return null;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) mime, (CharSequence) "/", false, 2, (Object) null);
        if (contains$default) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) mime, "/", 0, false, 6, (Object) null);
            String substring = mime.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return TuplesKt.to(substring, mime);
        }
        return TuplesKt.to("", mime);
    }

    private final void g() {
        if (NetworkUtil.isNetworkAvailable()) {
            return;
        }
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_BAD_NETWORK_TOAST);
        VideoReport.reportEvent("ev_xsj_camera_action", null, params);
        throw new InterceptException(name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_NO_NETWORK, null, 2, null));
    }

    private final void i(String logoUrl) {
        if (logoUrl != null) {
            String str = u53.b.f438371b + File.separator + this.account + "_template_user_avatar";
            w53.b.a("TemplateLibBaseMediaInterceptor", "downloadQQLogo path is " + str);
            com.tencent.mobileqq.wink.downloader.b.f318210a.b(logoUrl, str, new c(str));
            return;
        }
        F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_PROCESS_IMAGES_FAILED, null, 2, null));
    }

    private final Pair<String, String> p(String path) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(path);
        if (fileExtensionFromUrl != null) {
            return O(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
        }
        return null;
    }

    private final Pair<String, String> q(String path) {
        try {
            w().setDataSource(path);
            return O(w().extractMetadata(12));
        } catch (Throwable th5) {
            w53.b.d("TemplateLibBaseMediaInterceptor", "getMimeTypeByRetriever", th5);
            return null;
        }
    }

    private final MediaMetadataRetriever w() {
        return (MediaMetadataRetriever) this.retriever.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: A, reason: from getter */
    public final TemplatePreProcessConfig getTemplatePreProcessConfig() {
        return this.templatePreProcessConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final VideoTemplateData B(@NotNull c.a chain, @Nullable Map<String, ? extends Object> templateInfoMap) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        String templateJsAsset = chain.getMediaPickerInput().getVideoTemplateData().getTemplateJsAsset();
        if (templateJsAsset == null) {
            templateJsAsset = "{}";
        }
        try {
            JSONObject jSONObject = new JSONObject(templateJsAsset);
            if (templateInfoMap == null) {
                templateInfoMap = MapsKt__MapsKt.emptyMap();
            }
            for (Map.Entry<String, ? extends Object> entry : templateInfoMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "templateInfoMap ?: empty\u2026.toString()\n            }");
            return VideoTemplateData.b(chain.getMediaPickerInput().getVideoTemplateData(), false, false, jSONObject2, 3, null);
        } catch (Exception e16) {
            w53.b.d("TemplateLibBaseMediaInterceptor", "invalid template data", e16);
            return chain.getMediaPickerInput().getVideoTemplateData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C(boolean isSuccess) {
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        c.a aVar = this.chain;
        if (aVar != null && (b16 = aVar.b()) != null) {
            b16.m(0.6f);
        }
        if (!e()) {
            return;
        }
        if (!isSuccess) {
            F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_FACE_DETECTION_FAILED, null, 2, null));
            return;
        }
        w53.b.a("TemplateLibBaseMediaInterceptor", "handleGetFaceDetectResult success");
        if (this.templatePreProcessConfig != null) {
            P();
            return;
        }
        CountDownLatch countDownLatch = this.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D(boolean isSuccess, @Nullable Object data) {
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        c.a aVar = this.chain;
        if (aVar != null && (b16 = aVar.b()) != null) {
            b16.m(0.2f);
        }
        w53.b.f("TemplateLibBaseMediaInterceptor", "handleTemplateUserInfo  isSuccess " + isSuccess);
        if (!isSuccess) {
            F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_PROCESS_IMAGES_FAILED, null, 2, null));
            return;
        }
        if (data instanceof CircleTemplateInfo) {
            Map<String, Object> map = this.templateInfoMap;
            CircleTemplateInfo circleTemplateInfo = (CircleTemplateInfo) data;
            String str = circleTemplateInfo.NickWord;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            map.put("nickName", str);
            Map<String, Object> map2 = this.templateInfoMap;
            String str3 = circleTemplateInfo.TimeMapWord;
            if (str3 == null) {
                str3 = "";
            }
            map2.put("settlementTimeLabel", str3);
            Map<String, Object> map3 = this.templateInfoMap;
            String str4 = circleTemplateInfo.GenderMapWord;
            if (str4 == null) {
                str4 = "";
            }
            map3.put("gender", str4);
            Map<String, Object> map4 = this.templateInfoMap;
            String str5 = circleTemplateInfo.LocationMapWord;
            if (str5 == null) {
                str5 = "";
            }
            map4.put("locationLabel", str5);
            Map<String, Object> map5 = this.templateInfoMap;
            String str6 = circleTemplateInfo.DescMapWord;
            if (str6 == null) {
                str6 = "";
            }
            map5.put("describeLabel", str6);
            Map<String, Object> map6 = this.templateInfoMap;
            String str7 = circleTemplateInfo.MonthLabelWord;
            if (str7 == null) {
                str7 = "";
            }
            map6.put("monthLabel", str7);
            Map<String, Object> map7 = this.templateInfoMap;
            String str8 = circleTemplateInfo.DayLabelWord;
            if (str8 == null) {
                str8 = "";
            }
            map7.put("dayLabel", str8);
            Map<String, Object> map8 = this.templateInfoMap;
            String str9 = circleTemplateInfo.AgeMapWord;
            if (str9 == null) {
                str9 = "";
            }
            map8.put("ageLabel", str9);
            Map<String, Object> map9 = this.templateInfoMap;
            String str10 = circleTemplateInfo.StarMapWord;
            if (str10 != null) {
                str2 = str10;
            }
            map9.put("constellationLabel", str2);
            if (this.needDownloadQQLogo) {
                i(circleTemplateInfo.QqLogo);
            }
        }
        Map<String, Object> map10 = this.templateInfoMap;
        String v16 = WinkEditorResourceManager.a1().v1();
        Intrinsics.checkNotNullExpressionValue(v16, "getInstance().qqNickName");
        map10.put("nickNameForQQ", v16);
        this.templateInfoMap.put("yearNumber", Integer.valueOf(Calendar.getInstance().get(1)));
        this.templateInfoMap.put("monthNumber", Integer.valueOf(Calendar.getInstance().get(2)));
        this.templateInfoMap.put("dayNumber", Integer.valueOf(Calendar.getInstance().get(5)));
        CountDownLatch countDownLatch = this.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E(@Nullable TemplateLibraryData templateLibraryData) {
        MetaMaterial templateLibraryMaterial;
        String str;
        if (templateLibraryData != null && (templateLibraryMaterial = templateLibraryData.getTemplateLibraryMaterial()) != null && (str = templateLibraryMaterial.additionalFields.get("templatePreprocessConfig")) != null) {
            try {
                this.templatePreProcessConfig = (TemplatePreProcessConfig) n().fromJson(str, TemplatePreProcessConfig.class);
            } catch (Exception e16) {
                w53.b.d(name(), "initTemplatePreProcessConfig exception: ", e16);
            }
        }
        if (this.templatePreProcessConfig != null) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(@NotNull MediaPickerErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.interceptException = new InterceptException(name(), errorCode);
        CountDownLatch countDownLatch = this.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean G(@NotNull MediaPickerInput input) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(input, "input");
        TemplatePreProcessConfig templatePreProcessConfig = this.templatePreProcessConfig;
        if (templatePreProcessConfig != null && templatePreProcessConfig.isNeedFaceDetect()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        TemplateLibraryData templateLibraryData = input.getTemplateLibraryData();
        if (templateLibraryData != null && templateLibraryData.getNeedFaceDetection()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && input.getMediaPickerTabType() == TabType.ONLY_IMAGE) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I(@NotNull Map<Integer, String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            H(((Number) entry.getKey()).intValue(), (String) entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(@Nullable String str) {
        this.account = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(@Nullable c.a aVar) {
        this.chain = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(@Nullable InterceptException interceptException) {
        this.interceptException = interceptException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M(boolean z16) {
        this.needDownloadQQLogo = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(@Nullable CountDownLatch countDownLatch) {
        this.syncLatch = countDownLatch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(@NotNull LocalMediaInfo localMediaInfo, @NotNull TemplatePreProcessConfig.Media mediaPreProcessConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(mediaPreProcessConfig, "mediaPreProcessConfig");
        if (e93.i.I(localMediaInfo)) {
            List<TemplatePreProcessConfig.Media.Preprocess> preprocess = mediaPreProcessConfig.getPreprocess();
            if (preprocess != null) {
                for (TemplatePreProcessConfig.Media.Preprocess preprocess2 : preprocess) {
                    List<Pair<String, Integer>> list = this.needUploadImageInfos;
                    String str = this.extractedVideoFrameFiles.get(Integer.valueOf(preprocess2.getIndex()));
                    Intrinsics.checkNotNull(str);
                    list.add(TuplesKt.to(str, Integer.valueOf(mediaPreProcessConfig.getMaxSize())));
                }
                return;
            }
            return;
        }
        List<TemplatePreProcessConfig.Media.Preprocess> preprocess3 = mediaPreProcessConfig.getPreprocess();
        if (preprocess3 != null && !preprocess3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.needUploadImageInfos.add(TuplesKt.to(localMediaInfo.path, Integer.valueOf(mediaPreProcessConfig.getMaxSize())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(@NotNull TemplatePreProcessConfig.Media mediaConfig, @NotNull LocalMediaInfo localMediaInfo, @NotNull Map<String, String> uploadedImageUrls) {
        String str;
        boolean z16;
        List<Integer> multipleIndexes;
        String str2;
        long j3;
        long duration;
        int width;
        int height;
        String str3;
        long j16;
        long duration2;
        int width2;
        int height2;
        LocalMediaInfo localMediaInfo2;
        int duration3;
        int width3;
        int height3;
        MetaMaterial metaMaterial;
        MediaPickerInput mediaPickerInput;
        TemplateLibraryData templateLibraryData;
        boolean z17;
        Map<String, String> uploadedImageUrls2 = uploadedImageUrls;
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(uploadedImageUrls2, "uploadedImageUrls");
        if (mediaConfig.getIndex() >= 0) {
            TreeMap<Integer, ReplaceLayerMediaInfo> v3 = v();
            Integer valueOf = Integer.valueOf(mediaConfig.getIndex());
            String str4 = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str4, "localMediaInfo.path");
            v3.put(valueOf, new ReplaceLayerMediaInfo(str4, null, 0, 0L, 0, 0, null, 126, null));
        }
        List<TemplatePreProcessConfig.Media.Preprocess> preprocess = mediaConfig.getPreprocess();
        if (preprocess != null) {
            Iterator it = preprocess.iterator();
            while (it.hasNext()) {
                TemplatePreProcessConfig.Media.Preprocess preprocess2 = (TemplatePreProcessConfig.Media.Preprocess) it.next();
                if (e93.i.I(localMediaInfo)) {
                    str = this.extractedVideoFrameFiles.get(Integer.valueOf(preprocess2.getIndex()));
                } else {
                    str = localMediaInfo.path;
                }
                String str5 = uploadedImageUrls2.get(str);
                boolean z18 = true;
                if (str5 != null) {
                    if (str5.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        z16 = true;
                        if (z16) {
                            WinkPhotoListServiceHandler.d dVar = new WinkPhotoListServiceHandler.d(1, uploadedImageUrls2.get(str), preprocess2.getRequestParams().getBusiID(), preprocess2.getIndex(), preprocess2.getRequestParams().getExtra());
                            if (e93.i.I(localMediaInfo)) {
                                localMediaInfo2 = e93.i.b(localMediaInfo);
                                localMediaInfo2.path = str;
                                localMediaInfo2.mMimeType = "image";
                            } else {
                                localMediaInfo2 = localMediaInfo;
                            }
                            dVar.f318355f = localMediaInfo2;
                            dVar.f318356g = str;
                            if (preprocess2.getDuration() <= 0) {
                                duration3 = mediaConfig.getDuration();
                            } else {
                                duration3 = preprocess2.getDuration();
                            }
                            dVar.f318359j = duration3 / 1000;
                            if (preprocess2.getWidth() <= 0) {
                                width3 = mediaConfig.getWidth();
                            } else {
                                width3 = preprocess2.getWidth();
                            }
                            dVar.f318357h = width3;
                            if (preprocess2.getHeight() <= 0) {
                                height3 = mediaConfig.getHeight();
                            } else {
                                height3 = preprocess2.getHeight();
                            }
                            dVar.f318358i = height3;
                            c.a aVar = this.chain;
                            if (aVar != null && (mediaPickerInput = aVar.getMediaPickerInput()) != null && (templateLibraryData = mediaPickerInput.getTemplateLibraryData()) != null) {
                                metaMaterial = templateLibraryData.getTemplateLibraryMaterial();
                            } else {
                                metaMaterial = null;
                            }
                            dVar.f318360k = metaMaterial;
                            dVar.f318361l = mediaConfig.getIndex();
                            List<Integer> multipleIndexes2 = preprocess2.getMultipleIndexes();
                            if (multipleIndexes2 != null) {
                                Intrinsics.checkNotNullExpressionValue(multipleIndexes2, "multipleIndexes");
                                dVar.f318362m = multipleIndexes2;
                            }
                            this.processMediaInfos.add(dVar);
                        }
                        multipleIndexes = preprocess2.getMultipleIndexes();
                        if (multipleIndexes != null && !multipleIndexes.isEmpty()) {
                            z18 = false;
                        }
                        if (!z18) {
                            TreeMap<Integer, ReplaceLayerMediaInfo> v16 = v();
                            Integer valueOf2 = Integer.valueOf(preprocess2.getIndex());
                            if (str == null) {
                                str3 = "";
                            } else {
                                str3 = str;
                            }
                            String str6 = null;
                            int i3 = 0;
                            if (preprocess2.getDuration() <= 0) {
                                duration2 = mediaConfig.getDuration();
                                j16 = 1000;
                            } else {
                                j16 = 1000;
                                duration2 = preprocess2.getDuration();
                            }
                            long j17 = duration2 / j16;
                            if (preprocess2.getWidth() <= 0) {
                                width2 = mediaConfig.getWidth();
                            } else {
                                width2 = preprocess2.getWidth();
                            }
                            int i16 = width2;
                            if (preprocess2.getHeight() <= 0) {
                                height2 = mediaConfig.getHeight();
                            } else {
                                height2 = preprocess2.getHeight();
                            }
                            int i17 = height2;
                            String str7 = localMediaInfo.mMimeType;
                            Intrinsics.checkNotNullExpressionValue(str7, "localMediaInfo.mMimeType");
                            v16.put(valueOf2, new ReplaceLayerMediaInfo(str3, str6, i3, j17, i16, i17, str7, 6, null));
                        } else {
                            List<Integer> multipleIndexes3 = preprocess2.getMultipleIndexes();
                            Intrinsics.checkNotNullExpressionValue(multipleIndexes3, "preProcess.multipleIndexes");
                            for (Integer it5 : multipleIndexes3) {
                                TreeMap<Integer, ReplaceLayerMediaInfo> v17 = v();
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                if (str == null) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                String str8 = null;
                                int i18 = 0;
                                Iterator it6 = it;
                                if (preprocess2.getDuration() <= 0) {
                                    duration = mediaConfig.getDuration();
                                    j3 = 1000;
                                } else {
                                    j3 = 1000;
                                    duration = preprocess2.getDuration();
                                }
                                long j18 = duration / j3;
                                if (preprocess2.getWidth() <= 0) {
                                    width = mediaConfig.getWidth();
                                } else {
                                    width = preprocess2.getWidth();
                                }
                                int i19 = width;
                                if (preprocess2.getHeight() <= 0) {
                                    height = mediaConfig.getHeight();
                                } else {
                                    height = preprocess2.getHeight();
                                }
                                int i26 = height;
                                String str9 = localMediaInfo.mMimeType;
                                Intrinsics.checkNotNullExpressionValue(str9, "localMediaInfo.mMimeType");
                                v17.put(it5, new ReplaceLayerMediaInfo(str2, str8, i18, j18, i19, i26, str9, 6, null));
                                it = it6;
                            }
                        }
                        uploadedImageUrls2 = uploadedImageUrls;
                        it = it;
                    }
                }
                z16 = false;
                if (z16) {
                }
                multipleIndexes = preprocess2.getMultipleIndexes();
                if (multipleIndexes != null) {
                    z18 = false;
                }
                if (!z18) {
                }
                uploadedImageUrls2 = uploadedImageUrls;
                it = it;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        boolean z16;
        AtomicBoolean isRunning;
        c.a aVar = this.chain;
        if (aVar != null && (isRunning = aVar.getIsRunning()) != null && !isRunning.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_USER_CANCEL, null, 2, null));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f() {
        List<String> list;
        List<LocalMediaInfo> e16;
        int collectionSizeOrDefault;
        if (!e()) {
            return;
        }
        c.a aVar = this.chain;
        if (aVar != null && (e16 = aVar.e()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : e16) {
                if (e93.i.G((LocalMediaInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((LocalMediaInfo) it.next()).path);
            }
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        } else {
            list = null;
        }
        if (list != null) {
            list.addAll(this.extractedVideoFrameFiles.values());
        }
        x().N3(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        try {
            FileUtils.deleteFilesInDirectory(L);
        } catch (Exception e16) {
            w53.b.c("TemplateLibBaseMediaInterceptor", "clearExtractedVideoFrameFiles error: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(@Nullable LocalMediaInfo localMediaInfo, @Nullable TemplatePreProcessConfig.Media mediaConfig) {
        boolean z16;
        int collectionSizeOrDefault;
        if (localMediaInfo != null && e93.i.I(localMediaInfo) && mediaConfig != null) {
            List<TemplatePreProcessConfig.Media.Preprocess> preprocess = mediaConfig.getPreprocess();
            if (preprocess != null && !preprocess.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                List<TemplatePreProcessConfig.Media.Preprocess> preprocess2 = mediaConfig.getPreprocess();
                Intrinsics.checkNotNullExpressionValue(preprocess2, "mediaConfig.preprocess");
                List<TemplatePreProcessConfig.Media.Preprocess> list = preprocess2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((float) localMediaInfo.mStartTime) + (((TemplatePreProcessConfig.Media.Preprocess) it.next()).getVideoFrameTimeProportion() * mediaConfig.getDuration())));
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new TemplateLibBaseMediaInterceptor$extractVideoFrame$1(localMediaInfo, arrayList, mediaConfig, countDownLatch, this, null), 3, null);
                countDownLatch.await();
            }
        }
    }

    @NotNull
    protected final ReplaceLayerMediaInfo k(@NotNull ReplaceLayerMediaInfo info, @NotNull String generatePath) {
        boolean endsWith$default;
        String str;
        Pair<String, String> p16;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(generatePath, "generatePath");
        String originPath = info.getOriginPath();
        info.f(generatePath);
        info.g(QAlbumUtil.getMediaType(originPath));
        try {
            p16 = p(originPath);
            if (p16 == null) {
                p16 = q(originPath);
            }
        } catch (Exception unused) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(originPath, ".mp4", false, 2, null);
            if (endsWith$default) {
                str = "video/mp4";
            } else {
                str = "image/*";
            }
        }
        if (p16 == null || (str = p16.getSecond()) == null) {
            throw new IllegalArgumentException("invalid mime");
        }
        info.h(str);
        return info;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: l, reason: from getter */
    public final c.a getChain() {
        return this.chain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<Integer, String> m() {
        return this.extractedVideoFrameFiles;
    }

    @NotNull
    protected final Gson n() {
        return (Gson) this.gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: o, reason: from getter */
    public final InterceptException getInterceptException() {
        return this.interceptException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<Pair<String, Integer>> r() {
        return this.needUploadImageInfos;
    }

    @NotNull
    protected Map<String, LocalMediaInfo> s(@NotNull List<? extends LocalMediaInfo> selectedMedia) {
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<WinkPhotoListServiceHandler.d> t() {
        return this.processMediaInfos;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<LocalMediaInfo> u(@NotNull List<? extends LocalMediaInfo> selectedMedia) {
        List sortedWith;
        LocalMediaInfo localMediaInfo;
        boolean z16;
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        Map<String, LocalMediaInfo> s16 = s(selectedMedia);
        TreeMap<Integer, ReplaceLayerMediaInfo> v3 = v();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Integer, ReplaceLayerMediaInfo>> it = v3.entrySet().iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, ReplaceLayerMediaInfo> next = it.next();
            if (next.getKey().intValue() < 0) {
                z17 = false;
            }
            if (z17) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(linkedHashMap.entrySet(), new d());
        ArrayList arrayList = new ArrayList();
        Iterator it5 = sortedWith.iterator();
        while (it5.hasNext()) {
            ReplaceLayerMediaInfo replaceLayerMediaInfo = (ReplaceLayerMediaInfo) ((Map.Entry) it5.next()).getValue();
            LocalMediaInfo localMediaInfo2 = s16.get(replaceLayerMediaInfo.getOriginPath());
            String str = null;
            if (localMediaInfo2 != null) {
                localMediaInfo = e93.i.b(localMediaInfo2);
            } else {
                localMediaInfo = 0;
            }
            if (localMediaInfo != 0) {
                if (replaceLayerMediaInfo.getGeneratePath().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    localMediaInfo.orientation = 0;
                    localMediaInfo.path = replaceLayerMediaInfo.getGeneratePath();
                    localMediaInfo.mediaWidth = replaceLayerMediaInfo.getMediaWidth();
                    localMediaInfo.mediaHeight = replaceLayerMediaInfo.getMediaHeight();
                    localMediaInfo.mMediaType = QAlbumUtil.getMediaType(replaceLayerMediaInfo.getGeneratePath());
                    String str2 = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str2, "media.path");
                    Pair<String, String> p16 = p(str2);
                    if (p16 == null) {
                        String str3 = localMediaInfo.path;
                        Intrinsics.checkNotNullExpressionValue(str3, "media.path");
                        p16 = q(str3);
                    }
                    if (p16 != null) {
                        str = p16.getSecond();
                    }
                    localMediaInfo.mMimeType = str;
                    if (localMediaInfo.mMediaType == 1) {
                        if (replaceLayerMediaInfo.getDuration() > 0) {
                            localMediaInfo.mDuration = replaceLayerMediaInfo.getDuration();
                        }
                        if (localMediaInfo.mDuration <= 0) {
                            LocalMediaInfo b16 = e93.i.b(localMediaInfo);
                            com.tencent.mobileqq.wink.utils.o.f326724a.f(b16, w());
                            localMediaInfo.mDuration = b16.mDuration;
                        }
                    }
                }
                str = localMediaInfo;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TreeMap<Integer, ReplaceLayerMediaInfo> v() {
        return (TreeMap) this.replaceLayerMediaInfoMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkPhotoListServiceHandler x() {
        return (WinkPhotoListServiceHandler) this.serviceHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: y, reason: from getter */
    public final CountDownLatch getSyncLatch() {
        return this.syncLatch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<String, Object> z() {
        return this.templateInfoMap;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\t\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setOriginPath", "(Ljava/lang/String;)V", "originPath", "b", "f", "generatePath", "c", "I", "getMediaType", "()I", "g", "(I)V", "mediaType", "", "d", "J", "()J", "duration", "mediaWidth", "mediaHeight", "getMimeType", tl.h.F, "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJIILjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ReplaceLayerMediaInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String originPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String generatePath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int mediaType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long duration;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int mediaWidth;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int mediaHeight;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String mimeType;

        public ReplaceLayerMediaInfo(@NotNull String originPath, @NotNull String generatePath, int i3, long j3, int i16, int i17, @NotNull String mimeType) {
            Intrinsics.checkNotNullParameter(originPath, "originPath");
            Intrinsics.checkNotNullParameter(generatePath, "generatePath");
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.originPath = originPath;
            this.generatePath = generatePath;
            this.mediaType = i3;
            this.duration = j3;
            this.mediaWidth = i16;
            this.mediaHeight = i17;
            this.mimeType = mimeType;
        }

        /* renamed from: a, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGeneratePath() {
            return this.generatePath;
        }

        /* renamed from: c, reason: from getter */
        public final int getMediaHeight() {
            return this.mediaHeight;
        }

        /* renamed from: d, reason: from getter */
        public final int getMediaWidth() {
            return this.mediaWidth;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getOriginPath() {
            return this.originPath;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceLayerMediaInfo)) {
                return false;
            }
            ReplaceLayerMediaInfo replaceLayerMediaInfo = (ReplaceLayerMediaInfo) other;
            if (Intrinsics.areEqual(this.originPath, replaceLayerMediaInfo.originPath) && Intrinsics.areEqual(this.generatePath, replaceLayerMediaInfo.generatePath) && this.mediaType == replaceLayerMediaInfo.mediaType && this.duration == replaceLayerMediaInfo.duration && this.mediaWidth == replaceLayerMediaInfo.mediaWidth && this.mediaHeight == replaceLayerMediaInfo.mediaHeight && Intrinsics.areEqual(this.mimeType, replaceLayerMediaInfo.mimeType)) {
                return true;
            }
            return false;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.generatePath = str;
        }

        public final void g(int i3) {
            this.mediaType = i3;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mimeType = str;
        }

        public int hashCode() {
            return (((((((((((this.originPath.hashCode() * 31) + this.generatePath.hashCode()) * 31) + this.mediaType) * 31) + androidx.fragment.app.a.a(this.duration)) * 31) + this.mediaWidth) * 31) + this.mediaHeight) * 31) + this.mimeType.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReplaceLayerMediaInfo(originPath=" + this.originPath + ", generatePath=" + this.generatePath + ", mediaType=" + this.mediaType + ", duration=" + this.duration + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", mimeType=" + this.mimeType + ")";
        }

        public /* synthetic */ ReplaceLayerMediaInfo(String str, String str2, int i3, long j3, int i16, int i17, String str3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? -1L : j3, (i18 & 16) != 0 ? -1 : i16, (i18 & 32) == 0 ? i17 : -1, (i18 & 64) != 0 ? "image" : str3);
        }
    }

    protected void P() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor$c", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ResDownLoadListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f324909b;

        c(String str) {
            this.f324909b = str;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                w53.b.f("TemplateLibMediaInterceptor", "downloadQQLogo onDownloadFinish success");
                TemplateLibBaseMediaInterceptor.this.z().put("QQLogo", this.f324909b);
                CountDownLatch syncLatch = TemplateLibBaseMediaInterceptor.this.getSyncLatch();
                if (syncLatch != null) {
                    syncLatch.countDown();
                    return;
                }
                return;
            }
            TemplateLibBaseMediaInterceptor.this.F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_PROCESS_IMAGES_FAILED, null, 2, null));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}
