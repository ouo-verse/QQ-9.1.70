package com.tencent.ecommerce.biz.aftersale.viewmodel;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import cg0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import com.tencent.ecommerce.biz.comment.UploadStateListener;
import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyOptionInfo;
import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyRepo;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.aftersale.apply.PageType;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplySubOptionItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.d;
import com.tencent.ecommerce.repo.aftersale.apply.item.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 C2\u00020\u0001:\u0003DEFB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ.\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002J\u0013\u0010\u0017\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0005H\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020#0'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00030-j\b\u0012\u0004\u0012\u00020\u0003`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R#\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0007028\u0006\u00a2\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u00106R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\t028\u0006\u00a2\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u00106R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006G"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", VideoTemplateParser.ITEM_LIST, "", "W1", "Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;", "reqPageType", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "skuId", "afterSalesId", "U1", "pageType", "processId", "Z1", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/e;", "optionItem", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "localMedias", "X1", "b2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "i", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "uploadListener", "Lcom/tencent/ecommerce/biz/comment/BatchUploader;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/comment/BatchUploader;", "batchUploader", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_uiState", "Lkotlinx/coroutines/flow/StateFlow;", "D", "Lkotlinx/coroutines/flow/StateFlow;", "T1", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "_liveApplyItemList", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "applyItemListLiveData", "G", "S1", "targetPageTypeLiveData", "H", "R1", "pageTitleLiveData", "I", "Ljava/util/List;", "mediaInfos", "<init>", "()V", "J", "a", "b", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAfterSaleApplyViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableStateFlow<c> _uiState;

    /* renamed from: D, reason: from kotlin metadata */
    private final StateFlow<c> uiState;

    /* renamed from: E, reason: from kotlin metadata */
    private final ArrayList<com.tencent.ecommerce.repo.aftersale.apply.item.d> _liveApplyItemList;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>> applyItemListLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<PageType> targetPageTypeLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<String> pageTitleLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private List<ECMediaInfo> mediaInfos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final UploadStateListener uploadListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final BatchUploader batchUploader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b$a;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b$a;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final a f101317a = new a();

            a() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b$b;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1038b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C1038b f101318a = new C1038b();

            C1038b() {
                super(null);
            }
        }

        b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$a;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$c;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$e;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$d;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$b;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$g;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$h;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$f;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class c {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$a;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends c {

            /* renamed from: a, reason: collision with root package name */
            public static final a f101319a = new a();

            a() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$b;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "", "a", "Ljava/lang/String;", "failReason", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final String failReason;

            public b(String str) {
                super(null);
                this.failReason = str;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$c;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel$c$c, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1039c extends c {

            /* renamed from: a, reason: collision with root package name */
            public static final C1039c f101321a = new C1039c();

            C1039c() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$d;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class d extends c {

            /* renamed from: a, reason: collision with root package name */
            public static final d f101322a = new d();

            d() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$e;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class e extends c {

            /* renamed from: a, reason: collision with root package name */
            public static final e f101323a = new e();

            e() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$f;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b;", "a", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b;", "exception", "<init>", "(Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$b;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class f extends c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final b exception;

            public f(b bVar) {
                super(null);
                this.exception = bVar;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$g;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class g extends c {

            /* renamed from: a, reason: collision with root package name */
            public static final g f101325a = new g();

            g() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c$h;", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$c;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class h extends c {

            /* renamed from: a, reason: collision with root package name */
            public static final h f101326a = new h();

            h() {
                super(null);
            }
        }

        c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel$d", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "state", "", "onStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements UploadStateListener {
        d() {
        }

        @Override // com.tencent.ecommerce.biz.comment.UploadStateListener
        public void onStateChanged(UploadStateListener.a state) {
            if (state instanceof UploadStateListener.a.d) {
                return;
            }
            a.b("ECAfterSaleApplyViewModel", "UploadStateListener onStateChanged: " + state);
        }
    }

    public ECAfterSaleApplyViewModel() {
        List<ECMediaInfo> emptyList;
        d dVar = new d();
        this.uploadListener = dVar;
        this.batchUploader = new BatchUploader("aftersale", dVar, null, null, null, 28, null);
        MutableStateFlow<c> MutableStateFlow = StateFlowKt.MutableStateFlow(c.a.f101319a);
        this._uiState = MutableStateFlow;
        this.uiState = MutableStateFlow;
        ArrayList<com.tencent.ecommerce.repo.aftersale.apply.item.d> arrayList = new ArrayList<>();
        this._liveApplyItemList = arrayList;
        this.applyItemListLiveData = new MutableLiveData<>(arrayList);
        this.targetPageTypeLiveData = new MutableLiveData<>(PageType.PAGE_TYPE_UNINIT);
        this.pageTitleLiveData = new MutableLiveData<>("");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mediaInfos = emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(List<? extends com.tencent.ecommerce.repo.aftersale.apply.item.d> itemList) {
        this._liveApplyItemList.clear();
        this._liveApplyItemList.addAll(itemList);
        this.applyItemListLiveData.postValue(this._liveApplyItemList);
    }

    public final MutableLiveData<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>> Q1() {
        return this.applyItemListLiveData;
    }

    public final MutableLiveData<String> R1() {
        return this.pageTitleLiveData;
    }

    public final MutableLiveData<PageType> S1() {
        return this.targetPageTypeLiveData;
    }

    public final StateFlow<c> T1() {
        return this.uiState;
    }

    public final void U1(PageType reqPageType, String orderId, String skuId, String afterSalesId) {
        a.b("ECAfterSaleApplyViewModel", "requestApplyPageData reqPageType:" + reqPageType + " orderId:" + orderId + " skuId:" + skuId + " afterSalesId:" + afterSalesId);
        this._uiState.setValue(c.C1039c.f101321a);
        ECAfterSaleApplyRepo.f104899h.q(reqPageType, orderId, skuId, afterSalesId, new Function4<PageType, String, List<? extends com.tencent.ecommerce.repo.aftersale.apply.item.d>, Pair<? extends Integer, ? extends String>, Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel$requestApplyPageData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(PageType pageType, String str, List<? extends d> list, Pair<? extends Integer, ? extends String> pair) {
                invoke2(pageType, str, list, (Pair<Integer, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PageType pageType, String str, List<? extends d> list, Pair<Integer, String> pair) {
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                MutableStateFlow mutableStateFlow3;
                MutableStateFlow mutableStateFlow4;
                ECAfterSaleApplyViewModel.this.S1().postValue(pageType);
                ECAfterSaleApplyViewModel.this.R1().postValue(str);
                ECAfterSaleApplyViewModel.this.W1(list);
                if (pair == null) {
                    mutableStateFlow4 = ECAfterSaleApplyViewModel.this._uiState;
                    mutableStateFlow4.setValue(list.isEmpty() ? new ECAfterSaleApplyViewModel.c.b(null) : ECAfterSaleApplyViewModel.c.e.f101323a);
                    return;
                }
                int intValue = pair.getFirst().intValue();
                if (intValue == 0) {
                    mutableStateFlow = ECAfterSaleApplyViewModel.this._uiState;
                    mutableStateFlow.setValue(ECAfterSaleApplyViewModel.c.e.f101323a);
                } else if (intValue != 33300) {
                    mutableStateFlow3 = ECAfterSaleApplyViewModel.this._uiState;
                    mutableStateFlow3.setValue(new ECAfterSaleApplyViewModel.c.b(pair.getSecond()));
                } else {
                    mutableStateFlow2 = ECAfterSaleApplyViewModel.this._uiState;
                    mutableStateFlow2.setValue(ECAfterSaleApplyViewModel.c.d.f101322a);
                }
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel$requestApplyPageData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String str) {
                MutableStateFlow mutableStateFlow;
                mutableStateFlow = ECAfterSaleApplyViewModel.this._uiState;
                mutableStateFlow.setValue(new ECAfterSaleApplyViewModel.c.b(null));
                a.a("ECAfterSaleApplyViewModel", "requestApplyPageData", "rsp error, code=" + i3 + ", msg=" + str);
            }
        });
    }

    public final void X1(List<ECMediaInfo> localMedias) {
        a.b("ECAfterSaleApplyViewModel", "setUploadImages localMedias:" + localMedias);
        this.mediaInfos = localMedias;
        ArrayList<com.tencent.ecommerce.repo.aftersale.apply.item.d> arrayList = this._liveApplyItemList;
        ArrayList<ECAfterSaleApplyExtraItem> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof ECAfterSaleApplyExtraItem) {
                arrayList2.add(obj);
            }
        }
        for (ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem : arrayList2) {
            ArrayList arrayList3 = new ArrayList();
            if (localMedias != null) {
                Iterator<T> it = localMedias.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((ECMediaInfo) it.next()).getMediaPath());
                }
            }
            eCAfterSaleApplyExtraItem.f(arrayList3);
        }
    }

    public final void Z1(PageType pageType, String orderId, String skuId, String afterSalesId, String processId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECAfterSaleApplyViewModel$submitApplyPageData$1(this, pageType, orderId, afterSalesId, processId, skuId, null), 3, null);
    }

    public final void a2(e optionItem) {
        Set set;
        OptionValue selectedOption = optionItem.getOptionInfo().getSelectedOption();
        if (selectedOption != null) {
            int indexOf = this._liveApplyItemList.indexOf(optionItem);
            ArrayList<com.tencent.ecommerce.repo.aftersale.apply.item.d> arrayList = this._liveApplyItemList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof ECAfterSaleApplySubOptionItem) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((ECAfterSaleApplySubOptionItem) it.next()).getOptionInfo().g(null);
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList2);
            arrayList.removeAll(set);
            List<ECAfterSaleApplyOptionInfo> a16 = selectedOption.a();
            if (a16 != null) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it5 = a16.iterator();
                while (it5.hasNext()) {
                    arrayList3.add(new ECAfterSaleApplySubOptionItem((ECAfterSaleApplyOptionInfo) it5.next(), null, 2, null));
                }
                this._liveApplyItemList.addAll(indexOf + 1, arrayList3);
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    this.applyItemListLiveData.setValue(this._liveApplyItemList);
                } else {
                    this.applyItemListLiveData.postValue(this._liveApplyItemList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object b2(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        a.b("ECAfterSaleApplyViewModel", "uploadImages mediaList:" + this.mediaInfos);
        Object k3 = this.batchUploader.k(this.mediaInfos, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return k3 == coroutine_suspended ? k3 : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        a.b("ECAfterSaleApplyViewModel", "onCleared");
        super.onCleared();
        this.batchUploader.i();
    }
}
