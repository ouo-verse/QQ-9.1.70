package com.tencent.mobileqq.wink.aiavatar.mainpage;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ai.AIAvatarCapsuleTabBar;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "initViewModel", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategory", "I9", "H9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleViewModel;", "d", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleViewModel;", "aiAvatarViewModel", "Lcom/tencent/mobileqq/ai/AIAvatarCapsuleTabBar;", "e", "Lcom/tencent/mobileqq/ai/AIAvatarCapsuleTabBar;", "tabBar", "Lcom/tencent/mobileqq/widget/QQViewPager;", "f", "Lcom/tencent/mobileqq/widget/QQViewPager;", "viewPager", "Lo53/e;", h.F, "Lo53/e;", "adapter", "i", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "currentCategory", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarStyleListPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiAvatarViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIAvatarCapsuleTabBar tabBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQViewPager viewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private o53.e adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaCategory currentCategory;

    public WinkAIAvatarStyleListPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarStyleViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleListPart$aiAvatarViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarStyleViewModel invoke() {
                return (WinkAIAvatarStyleViewModel) WinkAIAvatarStyleListPart.this.getViewModel(WinkAIAvatarStyleViewModel.class);
            }
        });
        this.aiAvatarViewModel = lazy;
    }

    private final WinkAIAvatarStyleViewModel C9() {
        Object value = this.aiAvatarViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-aiAvatarViewModel>(...)");
        return (WinkAIAvatarStyleViewModel) value;
    }

    private final void D9(View rootView) {
        AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar;
        QQViewPager qQViewPager = null;
        if (rootView != null) {
            aIAvatarCapsuleTabBar = (AIAvatarCapsuleTabBar) rootView.findViewById(R.id.f164750tp4);
        } else {
            aIAvatarCapsuleTabBar = null;
        }
        this.tabBar = aIAvatarCapsuleTabBar;
        if (rootView != null) {
            qQViewPager = (QQViewPager) rootView.findViewById(R.id.tp9);
        }
        this.viewPager = qQViewPager;
        WinkAIAvatarStyleViewModel C9 = C9();
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        o53.e eVar = new o53.e(C9, childFragmentManager);
        this.adapter = eVar;
        QQViewPager qQViewPager2 = this.viewPager;
        if (qQViewPager2 != null) {
            qQViewPager2.setAdapter(eVar);
        }
        AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar2 = this.tabBar;
        if (aIAvatarCapsuleTabBar2 != null) {
            aIAvatarCapsuleTabBar2.setViewPager(this.viewPager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H9() {
        WinkAIAvatarStyleViewModel C9 = C9();
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        o53.e eVar = new o53.e(C9, childFragmentManager);
        this.adapter = eVar;
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager != null) {
            qQViewPager.setAdapter(eVar);
        }
        I9(this.currentCategory);
        QQViewPager qQViewPager2 = this.viewPager;
        if (qQViewPager2 != null) {
            qQViewPager2.invalidate();
        }
        QQViewPager qQViewPager3 = this.viewPager;
        if (qQViewPager3 != null) {
            qQViewPager3.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(MetaCategory metaCategory) {
        boolean z16;
        if (metaCategory != null) {
            ArrayList<MetaCategory> arrayList = metaCategory.subCategories;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.currentCategory = metaCategory;
                C9().X1(metaCategory);
                ArrayList<MetaCategory> arrayList2 = metaCategory.subCategories;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "metaCategory.subCategories");
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = ((MetaCategory) it.next()).name;
                    if (str != null) {
                        arrayList3.add(str);
                    }
                }
                Object[] array = new ArrayList(arrayList3).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar = this.tabBar;
                if (aIAvatarCapsuleTabBar != null) {
                    aIAvatarCapsuleTabBar.setTabData(strArr);
                }
                o53.e eVar = this.adapter;
                if (eVar != null) {
                    ArrayList<MetaCategory> arrayList4 = metaCategory.subCategories;
                    Intrinsics.checkNotNullExpressionValue(arrayList4, "metaCategory.subCategories");
                    eVar.f(arrayList4);
                }
                AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar2 = this.tabBar;
                if (aIAvatarCapsuleTabBar2 != null) {
                    aIAvatarCapsuleTabBar2.notifyDataSetChanged();
                }
                AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar3 = this.tabBar;
                if (aIAvatarCapsuleTabBar3 != null) {
                    aIAvatarCapsuleTabBar3.setCurrentPosition(C9().getTargetStyleTabPosition());
                }
                QQViewPager qQViewPager = this.viewPager;
                if (qQViewPager != null) {
                    qQViewPager.setCurrentItem(C9().getTargetStyleTabPosition());
                }
                o53.e eVar2 = this.adapter;
                if (eVar2 != null) {
                    eVar2.e();
                }
            }
        }
    }

    private final void initViewModel() {
        LiveData<MetaCategory> P1 = C9().P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<MetaCategory, Unit> function1 = new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleListPart$initViewModel$1
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
                WinkAIAvatarStyleListPart.this.I9(metaCategory);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarStyleListPart.E9(Function1.this, obj);
            }
        });
        LiveData<MetaCategory> Q1 = C9().Q1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final WinkAIAvatarStyleListPart$initViewModel$2 winkAIAvatarStyleListPart$initViewModel$2 = new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleListPart$initViewModel$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetaCategory metaCategory) {
                invoke2(metaCategory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MetaCategory metaCategory) {
                if (metaCategory == null) {
                    w53.b.a("WinkAIAvatarStyleListPart", "uploadImgSuggestData shareinfo observe null");
                    return;
                }
                ArrayList<MetaCategory> arrayList = metaCategory.subCategories;
                w53.b.a("WinkAIAvatarStyleListPart", "uploadImgSuggestData shareinfo observe size: " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
                WinkAIAvatarUtils.f317678a.A(metaCategory);
            }
        };
        Q1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarStyleListPart.F9(Function1.this, obj);
            }
        });
        LiveData<MetaCategory> U1 = C9().U1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final WinkAIAvatarStyleListPart$initViewModel$3 winkAIAvatarStyleListPart$initViewModel$3 = new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleListPart$initViewModel$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetaCategory metaCategory) {
                invoke2(metaCategory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MetaCategory metaCategory) {
                if (metaCategory == null) {
                    w53.b.a("WinkAIAvatarStyleListPart", "uploadImgSuggestData observe null");
                    return;
                }
                ArrayList<MetaCategory> arrayList = metaCategory.subCategories;
                w53.b.a("WinkAIAvatarStyleListPart", "uploadImgSuggestData observe size: " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
                WinkAIAvatarUtils.f317678a.x(metaCategory);
            }
        };
        U1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarStyleListPart.G9(Function1.this, obj);
            }
        });
        C9().b2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity()) || hVar.w(getActivity())) {
            H9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        D9(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QQViewPager qQViewPager = this.viewPager;
        if (qQViewPager != null) {
            qQViewPager.setAdapter(null);
        }
    }
}
