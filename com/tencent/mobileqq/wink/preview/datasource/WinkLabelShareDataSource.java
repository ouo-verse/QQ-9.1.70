package com.tencent.mobileqq.wink.preview.datasource;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.preview.datasource.WinkLabelShareDataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0014\u0010\u000f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R.\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/datasource/WinkLabelShareDataSource;", "Lcom/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "o", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/fragment/app/Fragment;", "host", "", "t", "", "labelList", ReportConstant.COSTREPORT_PREFIX, "", "d", "Ljava/util/List;", "slogans", "Landroidx/lifecycle/LiveData;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "e", "Landroidx/lifecycle/LiveData;", "r", "()Landroidx/lifecycle/LiveData;", "u", "(Landroidx/lifecycle/LiveData;)V", "templateLibrary", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "getTemplateMetaMaterial", "()Landroidx/lifecycle/MutableLiveData;", "templateMetaMaterial", "g", "labels", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLabelShareDataSource extends WinkBasePreviewShareDataSource {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final WinkLabelShareDataSource f325386c = new WinkLabelShareDataSource();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> slogans;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static LiveData<List<MetaCategory>> templateLibrary;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<MetaMaterial> templateMetaMaterial;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<String> labels;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/preview/datasource/WinkLabelShareDataSource$a", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "t", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Observer<List<? extends MetaCategory>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<MetaMaterial> f325391d;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super MetaMaterial> cancellableContinuation) {
            this.f325391d = cancellableContinuation;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable List<MetaCategory> t16) {
            WinkLabelShareDataSource.f325386c.r().removeObserver(this);
            MetaMaterial templateLibraryMaterial = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getTemplateLibraryMaterial("moban_mylabel");
            if (templateLibraryMaterial == null) {
                b.g("WinkLabelShareDataSource", "empty metaCategory");
                this.f325391d.resumeWith(Result.m476constructorimpl(null));
            } else {
                this.f325391d.resumeWith(Result.m476constructorimpl(templateLibraryMaterial));
            }
        }
    }

    static {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("\u8d34\u4e0a\u6807\u7b7e\n\u505a\u4e2a\u6027\u7684\u81ea\u5df1", "\u5feb\u6765\u56f4\u89c2\n\u6211\u7684\u4e2a\u6027\u6807\u7b7e", "\u7b49\u98ce\u6765\n\u4e0d\u5982\u8ffd\u98ce\u53bb", "\u4e2a\u6027\u662f\u4f1a\u53d8\u7684\u561b");
        slogans = mutableListOf;
        templateMetaMaterial = new MutableLiveData<>();
        labels = new ArrayList();
    }

    WinkLabelShareDataSource() {
    }

    private final String q() {
        Random.Companion companion = Random.INSTANCE;
        return slogans.get(companion.nextInt(0, r1.size() - 1));
    }

    @Override // com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource
    @Nullable
    public Object l(@NotNull Continuation<? super MetaMaterial> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QRouteApi api = QRoute.api(IWinkEditorResourceAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkEditorResourceAPI::class.java)");
        ((IWinkEditorResourceAPI) api).fetchTemplateLibraryResource();
        final a aVar = new a(cancellableContinuationImpl);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.preview.datasource.WinkLabelShareDataSource$getMaterial$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                WinkLabelShareDataSource.f325386c.r().removeObserver(WinkLabelShareDataSource.a.this);
            }
        });
        f325386c.r().observeForever(aVar);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource
    @Nullable
    public Map<String, String> o() {
        HashMap hashMap = new HashMap();
        String v16 = WinkEditorResourceManager.a1().v1();
        Intrinsics.checkNotNullExpressionValue(v16, "getInstance().qqNickName");
        hashMap.put("nickNameForQQ", n(v16, 10));
        hashMap.put("labelSlogan", q());
        if (!labels.isEmpty()) {
            int size = labels.size();
            for (int i3 = 0; i3 < size; i3++) {
                hashMap.put("labelForQQ" + i3, labels.get(i3));
            }
        }
        return hashMap;
    }

    @NotNull
    public final LiveData<List<MetaCategory>> r() {
        LiveData<List<MetaCategory>> liveData = templateLibrary;
        if (liveData != null) {
            return liveData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("templateLibrary");
        return null;
    }

    public final void s(@NotNull List<String> labelList) {
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(labelList, "labelList");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) labelList);
        labels = mutableList;
    }

    public final void t(@NotNull Fragment host) {
        Intrinsics.checkNotNullParameter(host, "host");
        QRouteApi api = QRoute.api(IWinkEditorResourceAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkEditorResourceAPI::class.java)");
        LiveData<List<MetaCategory>> templateLibraryCategoriesLiveData = ((IWinkEditorResourceAPI) api).getTemplateLibraryCategoriesLiveData(host);
        Intrinsics.checkNotNullExpressionValue(templateLibraryCategoriesLiveData, "resourceMgr.getTemplateL\u2026yCategoriesLiveData(host)");
        u(templateLibraryCategoriesLiveData);
    }

    public final void u(@NotNull LiveData<List<MetaCategory>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        templateLibrary = liveData;
    }
}
