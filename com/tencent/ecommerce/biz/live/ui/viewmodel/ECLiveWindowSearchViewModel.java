package com.tencent.ecommerce.biz.live.ui.viewmodel;

import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.common.RefreshStatus;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.live.ECLiveTabInfoRepo;
import com.tencent.ecommerce.repo.live.ECLiveWindowProductRepo;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.TabInfo;
import com.tencent.ecommerce.repo.live.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wg0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\nJ\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0006R\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\"R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000207j\b\u0012\u0004\u0012\u00020\u0002`88\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010<R#\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR%\u0010G\u001a\u0010\u0012\f\u0012\n D*\u0004\u0018\u00010\u000f0\u000f0>8\u0006\u00a2\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010BR\u0017\u0010M\u001a\u00020H8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/repo/live/q;", "product", "Lfi0/a;", "adapter", "", "c2", "", "productList", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "e2", "liveProduct", "d2", "", "status", "f2", "Landroid/content/Intent;", "intent", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabInfo", "Z1", "", "queryText", SemanticAttributes.DbSystemValues.H2, "U1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "g2", "T1", "i", "Z", "isMaster", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "liveUserId", "", BdhLogUtil.LogTag.Tag_Conn, "J", "liveRoomId", "D", "I", WadlProxyConsts.CHANNEL, "E", "Lcom/tencent/ecommerce/repo/live/TabInfo;", UserInfo.SEX_FEMALE, "clickId", "Landroid/app/Application;", "G", "Landroid/app/Application;", "ctx", "Lcom/tencent/ecommerce/repo/live/k;", "H", "Lcom/tencent/ecommerce/repo/live/k;", "repo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "_liveProductList", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "_refreshStatus", "Landroidx/lifecycle/MutableLiveData;", "K", "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "liveProductListLiveData", "kotlin.jvm.PlatformType", "L", "X1", "refreshStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "M", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b2", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isListEnd", "<init>", "()V", "N", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowSearchViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private long liveRoomId;

    /* renamed from: D, reason: from kotlin metadata */
    private int channel;

    /* renamed from: E, reason: from kotlin metadata */
    private TabInfo tabInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private k repo;

    /* renamed from: I, reason: from kotlin metadata */
    private final ArrayList<LiveProduct> _liveProductList;

    /* renamed from: J, reason: from kotlin metadata */
    private final AtomicInteger _refreshStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<List<LiveProduct>> liveProductListLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<Integer> refreshStatus;

    /* renamed from: M, reason: from kotlin metadata */
    private final AtomicBoolean isListEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isMaster;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String liveUserId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String clickId = "";

    /* renamed from: G, reason: from kotlin metadata */
    private final Application ctx = a.a();

    public ECLiveWindowSearchViewModel() {
        ArrayList<LiveProduct> arrayList = new ArrayList<>();
        this._liveProductList = arrayList;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this._refreshStatus = atomicInteger;
        this.liveProductListLiveData = new MutableLiveData<>(arrayList);
        this.refreshStatus = new MutableLiveData<>(Integer.valueOf(atomicInteger.get()));
        this.isListEnd = new AtomicBoolean(false);
    }

    public static final /* synthetic */ TabInfo O1(ECLiveWindowSearchViewModel eCLiveWindowSearchViewModel) {
        TabInfo tabInfo = eCLiveWindowSearchViewModel.tabInfo;
        if (tabInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
        }
        return tabInfo;
    }

    private final void c2(LiveProduct product, fi0.a adapter) {
        int lastIndexOf = this._liveProductList.lastIndexOf(product);
        if (lastIndexOf >= 0) {
            adapter.notifyItemChanged(lastIndexOf);
        }
    }

    private final void d2(LiveProduct liveProduct) {
        if (liveProduct.getIsExplaining()) {
            k kVar = this.repo;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            }
            kVar.l(liveProduct, new Function1<k.CommonResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSearchViewModel$reqSetExplainStatus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k.CommonResponse commonResponse) {
                    invoke2(commonResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final k.CommonResponse commonResponse) {
                    boolean z16;
                    int i3;
                    long j3;
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSearchViewModel$reqSetExplainStatus$1.1
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
                            Application application;
                            CharSequence text;
                            Application application2;
                            if (commonResponse.isSuccess) {
                                application2 = ECLiveWindowSearchViewModel.this.ctx;
                                text = application2.getText(R.string.wmk);
                            } else {
                                application = ECLiveWindowSearchViewModel.this.ctx;
                                text = application.getText(R.string.wmj);
                            }
                            i.f101155b.d(text, ECToastIcon.ICON_SUCCESS, 0);
                        }
                    });
                    ECLiveTabInfoRepo eCLiveTabInfoRepo = ECLiveTabInfoRepo.f105070b;
                    z16 = ECLiveWindowSearchViewModel.this.isMaster;
                    i3 = ECLiveWindowSearchViewModel.this.channel;
                    j3 = ECLiveWindowSearchViewModel.this.liveRoomId;
                    eCLiveTabInfoRepo.j(z16, i3, j3);
                }
            });
            return;
        }
        k kVar2 = this.repo;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        kVar2.j(liveProduct, new Function1<k.CommonResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSearchViewModel$reqSetExplainStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k.CommonResponse commonResponse) {
                invoke2(commonResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final k.CommonResponse commonResponse) {
                boolean z16;
                int i3;
                long j3;
                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSearchViewModel$reqSetExplainStatus$2.1
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
                        Application application;
                        CharSequence text;
                        Application application2;
                        if (commonResponse.isSuccess) {
                            application2 = ECLiveWindowSearchViewModel.this.ctx;
                            text = application2.getText(R.string.wmu);
                        } else {
                            application = ECLiveWindowSearchViewModel.this.ctx;
                            text = application.getText(R.string.wmt);
                        }
                        i.f101155b.d(text, ECToastIcon.ICON_SUCCESS, 0);
                    }
                });
                ECLiveTabInfoRepo eCLiveTabInfoRepo = ECLiveTabInfoRepo.f105070b;
                z16 = ECLiveWindowSearchViewModel.this.isMaster;
                i3 = ECLiveWindowSearchViewModel.this.channel;
                j3 = ECLiveWindowSearchViewModel.this.liveRoomId;
                eCLiveTabInfoRepo.j(z16, i3, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(@RefreshStatus int status) {
        this._refreshStatus.set(status);
        this.refreshStatus.postValue(Integer.valueOf(status));
    }

    public final void T1() {
        if (this.isListEnd.get() || this._liveProductList.size() > 10) {
            return;
        }
        cg0.a.b("ECLiveWindowSearchViewModel", "updateProductList fetch more data");
        h2(true, "");
    }

    public final MutableLiveData<List<LiveProduct>> W1() {
        return this.liveProductListLiveData;
    }

    public final MutableLiveData<Integer> X1() {
        return this.refreshStatus;
    }

    public final boolean a2() {
        return this._liveProductList.size() == 0;
    }

    /* renamed from: b2, reason: from getter */
    public final AtomicBoolean getIsListEnd() {
        return this.isListEnd;
    }

    public final void g2(LiveProduct liveProduct, fi0.a adapter) {
        liveProduct.L(!liveProduct.getIsExplaining());
        d2(liveProduct);
        c2(liveProduct, adapter);
        Iterator<LiveProduct> it = this._liveProductList.iterator();
        while (it.hasNext()) {
            LiveProduct next = it.next();
            if ((!Intrinsics.areEqual(next, liveProduct)) && next.getIsExplaining()) {
                next.L(false);
                c2(next, adapter);
            }
        }
    }

    public final void h2(boolean isLoadMore, String queryText) {
        cg0.a.b("ECLiveWindowSearchViewModel", "updateProductList start, isMaster:" + this.isMaster + ", liveUserId:" + this.liveUserId + ", liveRoomId:{" + this.liveRoomId + "}, isLoadMore:" + isLoadMore + ", _refreshStatus:" + this._refreshStatus + ", _isListEnd:" + this.isListEnd);
        if (this._refreshStatus.get() != 1) {
            if (isLoadMore && this.isListEnd.get()) {
                return;
            }
            f2(1);
            final ECLiveWindowSearchViewModel$updateProductList$1 eCLiveWindowSearchViewModel$updateProductList$1 = new ECLiveWindowSearchViewModel$updateProductList$1(this, isLoadMore);
            if (isLoadMore) {
                k kVar = this.repo;
                if (kVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                }
                k.c.b(kVar, null, new Function1<k.PageResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSearchViewModel$updateProductList$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(k.PageResponse pageResponse) {
                        invoke2(pageResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(k.PageResponse pageResponse) {
                        ECLiveWindowSearchViewModel$updateProductList$1.this.invoke2(pageResponse);
                    }
                }, 1, null);
                return;
            }
            k kVar2 = this.repo;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            }
            k.c.a(kVar2, queryText, null, new Function1<k.PageResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSearchViewModel$updateProductList$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k.PageResponse pageResponse) {
                    invoke2(pageResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(k.PageResponse pageResponse) {
                    ECLiveWindowSearchViewModel$updateProductList$1.this.invoke2(pageResponse);
                }
            }, 2, null);
        }
    }

    public final void U1() {
        f2(0);
        this._liveProductList.clear();
        this.liveProductListLiveData.postValue(this._liveProductList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(List<LiveProduct> productList, boolean isLoadMore) {
        if (!isLoadMore) {
            this._liveProductList.clear();
            this._liveProductList.addAll(productList);
        } else {
            HashSet hashSet = new HashSet(this._liveProductList);
            for (LiveProduct liveProduct : productList) {
                if (!hashSet.contains(liveProduct)) {
                    hashSet.add(liveProduct);
                    this._liveProductList.add(liveProduct);
                }
            }
        }
        this.liveProductListLiveData.postValue(this._liveProductList);
    }

    public final void Z1(Intent intent, TabInfo tabInfo) {
        if (intent != null) {
            this.isMaster = Intrinsics.areEqual(intent.getStringExtra("is_master"), "1");
            String stringExtra = intent.getStringExtra("live_user_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.liveUserId = stringExtra;
            String stringExtra2 = intent.getStringExtra("live_room_id");
            if (stringExtra2 == null) {
                stringExtra2 = "0";
            }
            this.liveRoomId = Long.parseLong(stringExtra2);
            String stringExtra3 = intent.getStringExtra(WadlProxyConsts.CHANNEL);
            this.channel = Integer.parseInt(stringExtra3 != null ? stringExtra3 : "0");
            String stringExtra4 = intent.getStringExtra("qz_gdt");
            this.clickId = stringExtra4 != null ? stringExtra4 : "";
        }
        this.tabInfo = tabInfo;
        this.repo = new ECLiveWindowProductRepo(this.isMaster, this.liveUserId, this.liveRoomId, this.channel, tabInfo, this.clickId);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initArguments, intent.extras:");
        sb5.append(String.valueOf(intent != null ? intent.getExtras() : null));
        cg0.a.b("ECLiveWindowSearchViewModel", sb5.toString());
    }
}
