package com.tencent.mobileqq.wink.magicstudio.qzone.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0003J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/qzone/part/WinkQZonePic2PicPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "firstVisibleItemPosition", "lastVisibleItemPosition", "", "P9", "initViewModel", "S9", "", "show", "X9", "O9", "position", "B1", "R9", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartDestroy", "", "getLogTag", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/PagerSnapHelper;", "e", "Landroidx/recyclerview/widget/PagerSnapHelper;", "pagerSnapHelper", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "winkMagicStudioPic2PicRecycleView", tl.h.F, "Landroid/view/View;", "winkMagicStudioEmpty", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "i", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "magicStudioViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "magicStudioCreationViewModel", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "defaultSelectionStyleId", "Ll83/e;", "D", "Ll83/e;", "winkMagicStudioAdapter", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "E", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "agiButtonInfo", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", UserInfo.SEX_FEMALE, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "pic2picMetaCategory", "<init>", "()V", "G", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZonePic2PicPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String defaultSelectionStyleId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private l83.e winkMagicStudioAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MagicStudioButtonInfo agiButtonInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MetaCategory pic2picMetaCategory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PagerSnapHelper pagerSnapHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView winkMagicStudioPic2PicRecycleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View winkMagicStudioEmpty;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkQZoneMagicStudioViewModel magicStudioViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MagicStudioCreationViewModel magicStudioCreationViewModel;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/qzone/part/WinkQZonePic2PicPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                int R9 = WinkQZonePic2PicPart.this.R9();
                w53.b.a("WinkQZonePic2PicPart", "curSelectedPosition:" + R9);
                l83.e eVar = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                boolean z16 = false;
                if (eVar != null && eVar.getCurrentSelectedPosition() == R9) {
                    z16 = true;
                }
                if (!z16) {
                    l83.e eVar2 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    if (eVar2 != null) {
                        eVar2.S0(-1);
                    }
                    l83.e eVar3 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    if (eVar3 != null) {
                        eVar3.T0(R9);
                    }
                    l83.e eVar4 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    if (eVar4 != null) {
                        eVar4.notifyDataSetChanged();
                    }
                }
                com.tencent.mobileqq.wink.report.e.f326265a.y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            LinearLayoutManager linearLayoutManager = WinkQZonePic2PicPart.this.linearLayoutManager;
            LinearLayoutManager linearLayoutManager2 = null;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
                linearLayoutManager = null;
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            LinearLayoutManager linearLayoutManager3 = WinkQZonePic2PicPart.this.linearLayoutManager;
            if (linearLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
                linearLayoutManager3 = null;
            }
            int findLastVisibleItemPosition = linearLayoutManager3.findLastVisibleItemPosition();
            WinkQZonePic2PicPart winkQZonePic2PicPart = WinkQZonePic2PicPart.this;
            LinearLayoutManager linearLayoutManager4 = winkQZonePic2PicPart.linearLayoutManager;
            if (linearLayoutManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            } else {
                linearLayoutManager2 = linearLayoutManager4;
            }
            w53.b.a("WinkQZonePic2PicPart", "Scroll percent: " + winkQZonePic2PicPart.P9(linearLayoutManager2, findFirstVisibleItemPosition, findLastVisibleItemPosition));
        }
    }

    private final void B1(final int position) {
        RecyclerView recyclerView = this.winkMagicStudioPic2PicRecycleView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.k
                @Override // java.lang.Runnable
                public final void run() {
                    WinkQZonePic2PicPart.W9(WinkQZonePic2PicPart.this, position);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        List<MagicStudioPicStyle> list;
        WinkMagicStudioUtils winkMagicStudioUtils = WinkMagicStudioUtils.f323888a;
        String str = this.defaultSelectionStyleId;
        l83.e eVar = this.winkMagicStudioAdapter;
        if (eVar != null) {
            list = eVar.z0();
        } else {
            list = null;
        }
        int d16 = winkMagicStudioUtils.d(str, list);
        l83.e eVar2 = this.winkMagicStudioAdapter;
        if (eVar2 != null) {
            eVar2.T0(d16);
        }
        B1(d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float P9(LinearLayoutManager layoutManager, int firstVisibleItemPosition, int lastVisibleItemPosition) {
        View findViewByPosition = layoutManager.findViewByPosition(firstVisibleItemPosition);
        View findViewByPosition2 = layoutManager.findViewByPosition(lastVisibleItemPosition);
        if (findViewByPosition == null || findViewByPosition2 == null) {
            return 0.0f;
        }
        int top = findViewByPosition.getTop();
        int bottom = findViewByPosition2.getBottom() - top;
        int abs = (int) Math.abs(top);
        w53.b.a("WinkQZonePic2PicPart", "firstVisibleItemPosition:" + firstVisibleItemPosition + ", lastVisibleItemPosition:" + lastVisibleItemPosition + ", firstVisibleItemTop:" + top);
        if (bottom <= 0) {
            return 0.0f;
        }
        return abs / bottom;
    }

    private final RecyclerView.ViewHolder Q9() {
        int R9 = R9();
        RecyclerView recyclerView = this.winkMagicStudioPic2PicRecycleView;
        if (recyclerView != null) {
            return recyclerView.findViewHolderForAdapterPosition(R9);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R9() {
        PagerSnapHelper pagerSnapHelper = this.pagerSnapHelper;
        LinearLayoutManager linearLayoutManager = null;
        if (pagerSnapHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerSnapHelper");
            pagerSnapHelper = null;
        }
        LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager2 = null;
        }
        View findSnapView = pagerSnapHelper.findSnapView(linearLayoutManager2);
        if (findSnapView != null) {
            LinearLayoutManager linearLayoutManager3 = this.linearLayoutManager;
            if (linearLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            } else {
                linearLayoutManager = linearLayoutManager3;
            }
            return linearLayoutManager.getPosition(findSnapView);
        }
        return -1;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void S9() {
        MutableLiveData<List<MagicStudioHistoryImageModel>> O1;
        MutableLiveData<MagicStudioButtonInfo> N1;
        MutableLiveData<MetaCategory> P1;
        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel = this.magicStudioViewModel;
        if (winkQZoneMagicStudioViewModel != null && (P1 = winkQZoneMagicStudioViewModel.P1()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<MetaCategory, Unit> function1 = new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initObserver$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initObserver$1$1", f = "WinkQZonePic2PicPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initObserver$1$1, reason: invalid class name */
                /* loaded from: classes21.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MetaCategory $pic2picMataCategory;
                    int label;
                    final /* synthetic */ WinkQZonePic2PicPart this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MetaCategory metaCategory, WinkQZonePic2PicPart winkQZonePic2PicPart, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$pic2picMataCategory = metaCategory;
                        this.this$0 = winkQZonePic2PicPart;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void b(WinkQZonePic2PicPart winkQZonePic2PicPart, List list) {
                        l83.e eVar = winkQZonePic2PicPart.winkMagicStudioAdapter;
                        if (eVar != null) {
                            eVar.V0(list);
                        }
                        winkQZonePic2PicPart.O9();
                        l83.e eVar2 = winkQZonePic2PicPart.winkMagicStudioAdapter;
                        if (eVar2 != null) {
                            eVar2.notifyDataSetChanged();
                        }
                        winkQZonePic2PicPart.X9(list.isEmpty());
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass1(this.$pic2picMataCategory, this.this$0, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                            MetaCategory pic2picMataCategory = this.$pic2picMataCategory;
                            Intrinsics.checkNotNullExpressionValue(pic2picMataCategory, "pic2picMataCategory");
                            final List<MagicStudioPicStyle> c06 = magicStudioDataSource.c0(pic2picMataCategory, false, false);
                            w53.b.a("WinkQZonePic2PicPart", "pic2picMaterialsLiveData onChanged size " + c06.size());
                            Handler mainHandler = this.this$0.getMainHandler();
                            final WinkQZonePic2PicPart winkQZonePic2PicPart = this.this$0;
                            mainHandler.post(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0042: INVOKE 
                                  (r0v6 'mainHandler' android.os.Handler)
                                  (wrap:java.lang.Runnable:0x003f: CONSTRUCTOR 
                                  (r1v4 'winkQZonePic2PicPart' com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart A[DONT_INLINE])
                                  (r4v3 'c06' java.util.List<com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle> A[DONT_INLINE])
                                 A[MD:(com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart, java.util.List):void (m), WRAPPED] (LINE:64) call: com.tencent.mobileqq.wink.magicstudio.qzone.part.l.<init>(com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart, java.util.List):void type: CONSTRUCTOR)
                                 VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] (LINE:67) in method: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initObserver$1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes21.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.wink.magicstudio.qzone.part.l, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 23 more
                                */
                            /*
                                this = this;
                                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r0 = r3.label
                                if (r0 != 0) goto L48
                                kotlin.ResultKt.throwOnFailure(r4)
                                com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource r4 = com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource.f323652a
                                camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory r0 = r3.$pic2picMataCategory
                                java.lang.String r1 = "pic2picMataCategory"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                                r1 = 0
                                java.util.List r4 = r4.c0(r0, r1, r1)
                                int r0 = r4.size()
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                r1.<init>()
                                java.lang.String r2 = "pic2picMaterialsLiveData onChanged size "
                                r1.append(r2)
                                r1.append(r0)
                                java.lang.String r0 = r1.toString()
                                java.lang.String r1 = "WinkQZonePic2PicPart"
                                w53.b.a(r1, r0)
                                com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart r0 = r3.this$0
                                android.os.Handler r0 = r0.getMainHandler()
                                com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart r1 = r3.this$0
                                com.tencent.mobileqq.wink.magicstudio.qzone.part.l r2 = new com.tencent.mobileqq.wink.magicstudio.qzone.part.l
                                r2.<init>(r1, r4)
                                r0.post(r2)
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            L48:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r0)
                                throw r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initObserver$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MetaCategory metaCategory) {
                        invoke2(metaCategory);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(MetaCategory metaCategory) {
                        WinkQZonePic2PicPart.this.pic2picMetaCategory = metaCategory;
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new AnonymousClass1(metaCategory, WinkQZonePic2PicPart.this, null), 3, null);
                    }
                };
                P1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.h
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkQZonePic2PicPart.T9(Function1.this, obj);
                    }
                });
            }
            WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel2 = this.magicStudioViewModel;
            if (winkQZoneMagicStudioViewModel2 != null && (N1 = winkQZoneMagicStudioViewModel2.N1()) != null) {
                Fragment hostFragment2 = getHostFragment();
                final Function1<MagicStudioButtonInfo, Unit> function12 = new Function1<MagicStudioButtonInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initObserver$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MagicStudioButtonInfo magicStudioButtonInfo) {
                        invoke2(magicStudioButtonInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable MagicStudioButtonInfo magicStudioButtonInfo) {
                        MagicStudioButtonInfo magicStudioButtonInfo2;
                        WinkQZonePic2PicPart.this.agiButtonInfo = magicStudioButtonInfo;
                        l83.e eVar = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                        if (eVar != null) {
                            magicStudioButtonInfo2 = WinkQZonePic2PicPart.this.agiButtonInfo;
                            eVar.O0(magicStudioButtonInfo2);
                        }
                        l83.e eVar2 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                        if (eVar2 != null) {
                            eVar2.notifyDataSetChanged();
                        }
                    }
                };
                N1.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.i
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkQZonePic2PicPart.U9(Function1.this, obj);
                    }
                });
            }
            WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel3 = this.magicStudioViewModel;
            if (winkQZoneMagicStudioViewModel3 != null && (O1 = winkQZoneMagicStudioViewModel3.O1()) != null) {
                Fragment hostFragment3 = getHostFragment();
                final Function1<List<MagicStudioHistoryImageModel>, Unit> function13 = new Function1<List<MagicStudioHistoryImageModel>, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initObserver$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<MagicStudioHistoryImageModel> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<MagicStudioHistoryImageModel> pic2picHistoryList) {
                        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel4;
                        l83.e eVar;
                        MutableLiveData<MetaCategory> P12;
                        l83.e eVar2 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                        if (eVar2 != null) {
                            Intrinsics.checkNotNullExpressionValue(pic2picHistoryList, "pic2picHistoryList");
                            eVar2.U0(pic2picHistoryList);
                        }
                        winkQZoneMagicStudioViewModel4 = WinkQZonePic2PicPart.this.magicStudioViewModel;
                        if (((winkQZoneMagicStudioViewModel4 == null || (P12 = winkQZoneMagicStudioViewModel4.P1()) == null) ? null : P12.getValue()) == null || (eVar = WinkQZonePic2PicPart.this.winkMagicStudioAdapter) == null) {
                            return;
                        }
                        l83.e eVar3 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                        Intrinsics.checkNotNull(eVar3);
                        eVar.notifyItemChanged(eVar3.getCurrentSelectedPosition(), "payload_history");
                    }
                };
                O1.observe(hostFragment3, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.j
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkQZonePic2PicPart.V9(Function1.this, obj);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void T9(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void U9(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void V9(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void W9(WinkQZonePic2PicPart this$0, int i3) {
            int i16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            RecyclerView recyclerView = this$0.winkMagicStudioPic2PicRecycleView;
            Intrinsics.checkNotNull(recyclerView);
            int paddingTop = recyclerView.getPaddingTop();
            LinearLayoutManager linearLayoutManager = this$0.linearLayoutManager;
            LinearLayoutManager linearLayoutManager2 = null;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
                linearLayoutManager = null;
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            LinearLayoutManager linearLayoutManager3 = this$0.linearLayoutManager;
            if (linearLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
                linearLayoutManager3 = null;
            }
            View findViewByPosition = linearLayoutManager3.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                RecyclerView recyclerView2 = this$0.winkMagicStudioPic2PicRecycleView;
                Intrinsics.checkNotNull(recyclerView2);
                i16 = ((recyclerView2.getHeight() - paddingTop) / 2) - (findViewByPosition.getHeight() / 2);
            } else {
                i16 = 0;
            }
            LinearLayoutManager linearLayoutManager4 = this$0.linearLayoutManager;
            if (linearLayoutManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            } else {
                linearLayoutManager2 = linearLayoutManager4;
            }
            linearLayoutManager2.scrollToPositionWithOffset(i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void X9(boolean show) {
            QUIShimmerImageView qUIShimmerImageView = (QUIShimmerImageView) getPartRootView().findViewById(R.id.f123377gh);
            QUIShimmerImageView qUIShimmerImageView2 = (QUIShimmerImageView) getPartRootView().findViewById(R.id.f123387gi);
            View view = null;
            if (show) {
                if (qUIShimmerImageView != null) {
                    qUIShimmerImageView.startShimming(null);
                }
                if (qUIShimmerImageView2 != null) {
                    qUIShimmerImageView2.startShimming(null);
                }
                View view2 = this.winkMagicStudioEmpty;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioEmpty");
                } else {
                    view = view2;
                }
                view.setVisibility(0);
                return;
            }
            if (qUIShimmerImageView != null) {
                qUIShimmerImageView.stopShimming(null);
            }
            if (qUIShimmerImageView2 != null) {
                qUIShimmerImageView2.stopShimming(null);
            }
            View view3 = this.winkMagicStudioEmpty;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioEmpty");
            } else {
                view = view3;
            }
            view.setVisibility(8);
        }

        private final void initView() {
            w53.b.a("WinkQZonePic2PicPart", "initView");
            this.winkMagicStudioPic2PicRecycleView = (RecyclerView) getPartRootView().findViewById(R.id.f123297g_);
            l83.e eVar = new l83.e(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
                    winkQZoneMagicStudioViewModel = WinkQZonePic2PicPart.this.magicStudioViewModel;
                    if (winkQZoneMagicStudioViewModel == null) {
                        return;
                    }
                    l83.e eVar2 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    winkQZoneMagicStudioViewModel.U1(eVar2 != null ? eVar2.y0(i3) : null);
                }
            }, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    MagicStudioButtonInfo magicStudioButtonInfo;
                    MetaCategory metaCategory;
                    WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
                    l83.e eVar2 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    MagicStudioPicStyle y06 = eVar2 != null ? eVar2.y0(i3) : null;
                    WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
                    Activity activity = WinkQZonePic2PicPart.this.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    Fragment hostFragment = WinkQZonePic2PicPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    magicStudioButtonInfo = WinkQZonePic2PicPart.this.agiButtonInfo;
                    metaCategory = WinkQZonePic2PicPart.this.pic2picMetaCategory;
                    final WinkQZonePic2PicPart winkQZonePic2PicPart = WinkQZonePic2PicPart.this;
                    WinkMagicStudioLogicUtils.o(winkMagicStudioLogicUtils, activity, hostFragment, y06, magicStudioButtonInfo, metaCategory, null, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$2.1
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
                            WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel2;
                            winkQZoneMagicStudioViewModel2 = WinkQZonePic2PicPart.this.magicStudioViewModel;
                            if (winkQZoneMagicStudioViewModel2 != null) {
                                winkQZoneMagicStudioViewModel2.L1(2);
                            }
                        }
                    }, 96, null);
                    winkQZoneMagicStudioViewModel = WinkQZonePic2PicPart.this.magicStudioViewModel;
                    if (winkQZoneMagicStudioViewModel == null) {
                        return;
                    }
                    winkQZoneMagicStudioViewModel.X1("0");
                }
            }, new Function2<Integer, MagicStudioHistoryImageModel, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MagicStudioHistoryImageModel magicStudioHistoryImageModel) {
                    invoke(num.intValue(), magicStudioHistoryImageModel);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull MagicStudioHistoryImageModel historyImageItem) {
                    MagicStudioButtonInfo magicStudioButtonInfo;
                    MetaCategory metaCategory;
                    MagicStudioCreationViewModel magicStudioCreationViewModel;
                    MagicStudioCreationViewModel magicStudioCreationViewModel2;
                    WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
                    Intrinsics.checkNotNullParameter(historyImageItem, "historyImageItem");
                    WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
                    Activity activity = WinkQZonePic2PicPart.this.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    Fragment hostFragment = WinkQZonePic2PicPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    l83.e eVar2 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    MagicStudioPicStyle y06 = eVar2 != null ? eVar2.y0(i3) : null;
                    magicStudioButtonInfo = WinkQZonePic2PicPart.this.agiButtonInfo;
                    metaCategory = WinkQZonePic2PicPart.this.pic2picMetaCategory;
                    magicStudioCreationViewModel = WinkQZonePic2PicPart.this.magicStudioCreationViewModel;
                    if (magicStudioCreationViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("magicStudioCreationViewModel");
                        magicStudioCreationViewModel2 = null;
                    } else {
                        magicStudioCreationViewModel2 = magicStudioCreationViewModel;
                    }
                    final WinkQZonePic2PicPart winkQZonePic2PicPart = WinkQZonePic2PicPart.this;
                    winkMagicStudioLogicUtils.n(activity, hostFragment, y06, magicStudioButtonInfo, metaCategory, historyImageItem, magicStudioCreationViewModel2, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$3.1
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
                            WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel2;
                            winkQZoneMagicStudioViewModel2 = WinkQZonePic2PicPart.this.magicStudioViewModel;
                            if (winkQZoneMagicStudioViewModel2 != null) {
                                winkQZoneMagicStudioViewModel2.L1(2);
                            }
                        }
                    });
                    winkQZoneMagicStudioViewModel = WinkQZonePic2PicPart.this.magicStudioViewModel;
                    if (winkQZoneMagicStudioViewModel == null) {
                        return;
                    }
                    winkQZoneMagicStudioViewModel.X1("0");
                }
            }, new Function3<Integer, MagicStudioHistoryImageModel, Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$4

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$4$1", f = "WinkQZonePic2PicPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$4$1, reason: invalid class name */
                /* loaded from: classes21.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MagicStudioHistoryImageModel $historyImageItem;
                    final /* synthetic */ int $leftCount;
                    int label;
                    final /* synthetic */ WinkQZonePic2PicPart this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MagicStudioHistoryImageModel magicStudioHistoryImageModel, int i3, WinkQZonePic2PicPart winkQZonePic2PicPart, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$historyImageItem = magicStudioHistoryImageModel;
                        this.$leftCount = i3;
                        this.this$0 = winkQZonePic2PicPart;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass1(this.$historyImageItem, this.$leftCount, this.this$0, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
                        l83.e eVar;
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            m83.a.f416440a.a(this.$historyImageItem, this.$leftCount);
                            if (this.$leftCount == 0 && (eVar = this.this$0.winkMagicStudioAdapter) != null) {
                                eVar.S0(-1);
                            }
                            winkQZoneMagicStudioViewModel = this.this$0.magicStudioViewModel;
                            if (winkQZoneMagicStudioViewModel != null) {
                                winkQZoneMagicStudioViewModel.R1();
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MagicStudioHistoryImageModel magicStudioHistoryImageModel, Integer num2) {
                    invoke(num.intValue(), magicStudioHistoryImageModel, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull MagicStudioHistoryImageModel historyImageItem, int i16) {
                    Intrinsics.checkNotNullParameter(historyImageItem, "historyImageItem");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new AnonymousClass1(historyImageItem, i16, WinkQZonePic2PicPart.this, null), 3, null);
                }
            }, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    l83.e eVar2 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    if (eVar2 != null) {
                        eVar2.S0(i3);
                    }
                    l83.e eVar3 = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                    if (eVar3 != null) {
                        eVar3.notifyItemChanged(i3, "payload_history");
                    }
                }
            }, new Function1<MagicStudioPicStyle, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MagicStudioPicStyle magicStudioPicStyle) {
                    invoke2(magicStudioPicStyle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull MagicStudioPicStyle magicStudioPicStyle) {
                    WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
                    Intrinsics.checkNotNullParameter(magicStudioPicStyle, "magicStudioPicStyle");
                    WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
                    Activity activity = WinkQZonePic2PicPart.this.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    final WinkQZonePic2PicPart winkQZonePic2PicPart = WinkQZonePic2PicPart.this;
                    winkMagicStudioLogicUtils.g(activity, magicStudioPicStyle, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initView$6.1
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
                            WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel2;
                            winkQZoneMagicStudioViewModel2 = WinkQZonePic2PicPart.this.magicStudioViewModel;
                            if (winkQZoneMagicStudioViewModel2 != null) {
                                winkQZoneMagicStudioViewModel2.L1(2);
                            }
                        }
                    });
                    winkQZoneMagicStudioViewModel = WinkQZonePic2PicPart.this.magicStudioViewModel;
                    if (winkQZoneMagicStudioViewModel == null) {
                        return;
                    }
                    winkQZoneMagicStudioViewModel.X1("2");
                }
            });
            this.winkMagicStudioAdapter = eVar;
            RecyclerView recyclerView = this.winkMagicStudioPic2PicRecycleView;
            if (recyclerView != null) {
                recyclerView.setAdapter(eVar);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
            this.linearLayoutManager = linearLayoutManager;
            RecyclerView recyclerView2 = this.winkMagicStudioPic2PicRecycleView;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(linearLayoutManager);
            }
            PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
            this.pagerSnapHelper = pagerSnapHelper;
            pagerSnapHelper.attachToRecyclerView(this.winkMagicStudioPic2PicRecycleView);
            RecyclerView recyclerView3 = this.winkMagicStudioPic2PicRecycleView;
            if (recyclerView3 != null) {
                recyclerView3.addOnScrollListener(new b());
            }
            View findViewById = getPartRootView().findViewById(R.id.f123117fs);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026agic_studio_empty_layout)");
            this.winkMagicStudioEmpty = findViewById;
            X9(true);
        }

        private final void initViewModel() {
            this.magicStudioViewModel = WinkQZoneMagicStudioViewModel.INSTANCE.a(getActivity());
            ViewModel viewModel = new ViewModelProvider(getHostFragment()).get(MagicStudioCreationViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(hostFr\u2026ionViewModel::class.java)");
            MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) viewModel;
            magicStudioCreationViewModel.u3(true);
            magicStudioCreationViewModel.s3(true);
            this.magicStudioCreationViewModel = magicStudioCreationViewModel;
            if (magicStudioCreationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("magicStudioCreationViewModel");
                magicStudioCreationViewModel = null;
            }
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            MagicStudioCreationViewModel.v2(magicStudioCreationViewModel, hostFragment, activity, getPartRootView(), new Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart$initViewModel$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect) {
                    invoke2(gotoMultiSelect);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull MagicStudioCreationViewModel.b.GotoMultiSelect selectInfo) {
                    MagicStudioCreationViewModel magicStudioCreationViewModel2;
                    Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
                    Activity activity2 = WinkQZonePic2PicPart.this.getActivity();
                    if (activity2 instanceof FragmentActivity) {
                        magicStudioCreationViewModel2 = WinkQZonePic2PicPart.this.magicStudioCreationViewModel;
                        if (magicStudioCreationViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("magicStudioCreationViewModel");
                            magicStudioCreationViewModel2 = null;
                        }
                        l83.e eVar = WinkQZonePic2PicPart.this.winkMagicStudioAdapter;
                        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAIGCMultiSelectFragment((FragmentActivity) activity2, magicStudioCreationViewModel2.k3(activity2, selectInfo, eVar != null ? eVar.w0() : null));
                    }
                }
            }, null, null, null, false, false, w.CTRL_INDEX, null);
        }

        @Override // com.tencent.biz.richframework.part.Part
        @NotNull
        public String getLogTag() {
            return "WinkQZonePic2PicPart";
        }

        @Override // com.tencent.biz.richframework.part.Part
        public void onInitView(@Nullable View rootView) {
            String str;
            Intent intent;
            super.onInitView(rootView);
            Activity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                str = intent.getStringExtra("magic_studio_style");
            } else {
                str = null;
            }
            this.defaultSelectionStyleId = str;
            w53.b.a("WinkQZonePic2PicPart", "defaultSelectionStyleId: " + str);
            initView();
            initViewModel();
            S9();
        }

        @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
        public void onPartDestroy(@Nullable Activity activity) {
            super.onPartDestroy(activity);
            w53.b.f("WinkQZonePic2PicPart", "onPartDestroy");
            l83.e eVar = this.winkMagicStudioAdapter;
            if (eVar != null) {
                eVar.release();
            }
            this.winkMagicStudioAdapter = null;
            RecyclerView recyclerView = this.winkMagicStudioPic2PicRecycleView;
            if (recyclerView != null) {
                recyclerView.setAdapter(null);
            }
        }

        @Override // com.tencent.biz.richframework.part.Part
        public void onPartPause(@Nullable Activity activity) {
            l83.e eVar;
            super.onPartPause(activity);
            w53.b.f("WinkQZonePic2PicPart", "onPartPause");
            RecyclerView.ViewHolder Q9 = Q9();
            if (Q9 != null && (Q9 instanceof n83.b) && (eVar = this.winkMagicStudioAdapter) != null) {
                eVar.N0((n83.b) Q9);
            }
        }
    }
