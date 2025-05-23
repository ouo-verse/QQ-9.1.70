package com.tencent.ecommerce.biz.consumer.factory;

import android.content.Context;
import com.tencent.ecommerce.base.config.service.b;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.model.ECGoodsCommentViewModel;
import com.tencent.ecommerce.biz.consumer.model.ECGoodsTopViewViewModel;
import com.tencent.ecommerce.biz.consumer.model.ECGoodsVideoFeedsViewModel;
import com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsCardFactory;
import com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u001a\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\"\u0010\u0018\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0017\u001a\u00020\u0016J*\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001a\u0010\u001a\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\u001b\u001a\u00020\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016R\u0014\u0010\u001d\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR)\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b$\u0010%R!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030'8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/factory/ECGoodsCardFactory;", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsCardFactory;", "Ljava/util/HashMap;", "", "data", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "b", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextWeakReference", "contentInfo", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "d", "key", "", "a", "e", "", "c", "j", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "preloadViewModel", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callback", "i", "getViewModel", "k", "releaseViewModels", "Ljava/lang/String;", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Lazy;", "f", "()Ljava/util/concurrent/ConcurrentHashMap;", "preloadMap", "", "g", "()I", "preloadMaxNum", "Ljava/util/ArrayList;", h.F, "()Ljava/util/ArrayList;", "preloadNumList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsCardFactory implements IECGoodsCardFactory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy preloadMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy preloadMaxNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy preloadNumList;

    /* renamed from: e, reason: collision with root package name */
    public static final ECGoodsCardFactory f101594e;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        ECGoodsCardFactory eCGoodsCardFactory = new ECGoodsCardFactory();
        f101594e = eCGoodsCardFactory;
        TAG = "ECGoodsCardFactory[" + eCGoodsCardFactory.hashCode() + ']';
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, IECGoodsViewModel>>() { // from class: com.tencent.ecommerce.biz.consumer.factory.ECGoodsCardFactory$preloadMap$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<String, IECGoodsViewModel> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        preloadMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.factory.ECGoodsCardFactory$preloadMaxNum$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return ((Number) b.f100655b.b(100314, "video_goods_preload_num", 2)).intValue();
            }
        });
        preloadMaxNum = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<String>>() { // from class: com.tencent.ecommerce.biz.consumer.factory.ECGoodsCardFactory$preloadNumList$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<String> invoke() {
                return new ArrayList<>();
            }
        });
        preloadNumList = lazy3;
    }

    ECGoodsCardFactory() {
    }

    private final void a(String key) {
        h().add(key);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
    
        r10 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ECContentInfo b(HashMap<String, String> data) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        String str = data.get("PARAM_BUSINESS_ID");
        int intValue = (str == null || intOrNull5 == null) ? 0 : intOrNull5.intValue();
        String str2 = data.get("PARAM_BUSINESS_SCENE");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = data.get("PARAM_CONTENT_ID");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = data.get("PARAM_CONTENT_SCENE");
        int intValue2 = (str4 == null || intOrNull4 == null) ? 0 : intOrNull4.intValue();
        String str5 = data.get("PARAM_VIDEO_INDEX");
        int intValue3 = (str5 == null || intOrNull3 == null) ? 0 : intOrNull3.intValue();
        String str6 = data.get("PARAM_AUTHOR_UIN");
        if (str6 == null) {
            str6 = "";
        }
        String str7 = data.get("PARAM_SEAL_TRANSFER");
        if (str7 == null) {
            str7 = "";
        }
        String str8 = data.get("PARAM_TRACE_ID");
        String str9 = str8 != null ? str8 : "";
        String str10 = data.get("PARAM_PAGE_ID");
        int intValue4 = (str10 == null || intOrNull2 == null) ? 0 : intOrNull2.intValue();
        String str11 = data.get("PARAM_SOURCE_FROM");
        int intValue5 = (str11 == null || intOrNull == null) ? -1 : intOrNull.intValue();
        String str12 = data.get("PARAM_IS_CONTINUATION");
        boolean parseBoolean = str12 != null ? Boolean.parseBoolean(str12) : false;
        String str13 = data.get("PARAM_IS_TOP_VIEW_PRELOAD");
        return new ECContentInfo.Builder().setBusinessId(intValue).setBusinessScene(str2).setContentId(str3).setContentScene(intValue2).setVideoIndex(intValue3).setAuthorUin(str6).setSealTransfer(str7).setTraceId(str9).setPageId(intValue4).setSourceFrom(intValue5).setIsContinuation(parseBoolean).setIsTopViewPreload(str13 != null ? Boolean.parseBoolean(str13) : false).getData();
    }

    private final boolean c() {
        return h().size() > g();
    }

    private final void e(String key) {
        if (h().contains(key)) {
            h().remove(key);
        }
    }

    private final int g() {
        return ((Number) preloadMaxNum.getValue()).intValue();
    }

    public final ConcurrentHashMap<String, IECGoodsViewModel> f() {
        return (ConcurrentHashMap) preloadMap.getValue();
    }

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsCardFactory
    public IECGoodsViewModel getViewModel(String uniqueId, WeakReference<Context> contextWeakReference, ECContentInfo contentInfo) {
        if (f().containsKey(uniqueId)) {
            IECGoodsViewModel iECGoodsViewModel = f().get(uniqueId);
            if (iECGoodsViewModel != null) {
                e(uniqueId);
                cg0.a.b(TAG, "getViewModel from cached model, uniqueId:" + uniqueId + ",contentId:" + contentInfo.getContentId() + ",content scene:" + contentInfo.getContentScene() + ",model hashcode:" + iECGoodsViewModel.hashCode() + ",isContinuation:" + contentInfo.getIsContinuation());
                return iECGoodsViewModel;
            }
            f().remove(uniqueId);
        }
        IECGoodsViewModel d16 = d(contextWeakReference, contentInfo);
        f().put(uniqueId, d16);
        e(uniqueId);
        cg0.a.b(TAG, "getViewModel from new model, uniqueId:" + uniqueId + ",contentId:" + contentInfo.getContentId() + ",content scene:" + contentInfo.getContentScene() + ",model hashcode:" + d16.hashCode() + ",isContinuation:" + contentInfo.getIsContinuation());
        return d16;
    }

    public final ArrayList<String> h() {
        return (ArrayList) preloadNumList.getValue();
    }

    public final void i(HashMap<String, String> data, IECLogicCallback callback) {
        HashMap<String, Object> hashMapOf;
        String str = data.get("PARAM_UNIQUE_ID");
        if (str == null) {
            str = "";
        }
        IECGoodsViewModel viewModel = getViewModel(str, new WeakReference<>(wg0.a.a()), b(data));
        if (viewModel != null) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_VIEW_MODEL_OBJECT", viewModel));
            callback.onResult(hashMapOf);
        }
    }

    public final void j(HashMap<String, String> data) {
        String str = data.get("PARAM_UNIQUE_ID");
        if (str == null) {
            str = "";
        }
        preloadViewModel(str, new WeakReference<>(wg0.a.a()), b(data));
    }

    public final void k(HashMap<String, String> data) {
        int i3;
        boolean startsWith$default;
        String str = data.get("PARAM_UNIQUE_ID_PREFIX_CODE");
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, IECGoodsViewModel>> it = f().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, IECGoodsViewModel> next = it.next();
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(next.getKey(), str, false, 2, null);
                if (startsWith$default) {
                    arrayList.add(next.getKey());
                }
            }
            int size = arrayList.size();
            for (i3 = 0; i3 < size; i3++) {
                f().remove(arrayList.get(i3));
            }
            h().clear();
            oh0.a.f422682b.a();
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsCardFactory
    public void preloadViewModel(String uniqueId, WeakReference<Context> contextWeakReference, ECContentInfo contentInfo) {
        if (!contentInfo.getIsTopViewPreload() && c()) {
            cg0.a.b(TAG, "preloadViewModel return by max pre siz, uniqueId:" + uniqueId + ",contentId:" + contentInfo.getContentId() + ",content scene:" + contentInfo.getContentScene() + ",isContinuation:" + contentInfo.getIsContinuation());
            return;
        }
        if (!f().containsKey(uniqueId)) {
            IECGoodsViewModel d16 = d(contextWeakReference, contentInfo);
            f().put(uniqueId, d16);
            a(uniqueId);
            cg0.a.b(TAG, "preloadViewModel 1, uniqueId:" + uniqueId + ",contentId:" + contentInfo.getContentId() + ",content scene:" + contentInfo.getContentScene() + ",model hashcode:" + d16.hashCode() + ",isContinuation:" + contentInfo.getIsContinuation());
            return;
        }
        if (f().get(uniqueId) == null) {
            IECGoodsViewModel d17 = d(contextWeakReference, contentInfo);
            f().put(uniqueId, d17);
            a(uniqueId);
            cg0.a.b(TAG, "preloadViewModel 2, uniqueId:" + uniqueId + ",contentId:" + contentInfo.getContentId() + ",content scene:" + contentInfo.getContentScene() + ",model hashcode:" + d17.hashCode() + ",isContinuation:" + contentInfo.getIsContinuation());
        }
    }

    private final IECGoodsViewModel d(WeakReference<Context> contextWeakReference, ECContentInfo contentInfo) {
        Context a16;
        if (contextWeakReference == null || (a16 = contextWeakReference.get()) == null) {
            a16 = wg0.a.a();
        }
        if (contentInfo.getContentScene() == 4) {
            return new ECGoodsCommentViewModel(a16, contentInfo);
        }
        if (contentInfo.getContentScene() == 8) {
            return new ECGoodsTopViewViewModel(a16, contentInfo);
        }
        return new ECGoodsVideoFeedsViewModel(a16, contentInfo);
    }

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsCardFactory
    public void releaseViewModels(WeakReference<Context> contextWeakReference) {
    }
}
