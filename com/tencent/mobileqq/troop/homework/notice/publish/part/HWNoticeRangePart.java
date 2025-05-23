package com.tencent.mobileqq.troop.homework.notice.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.HWPageType;
import com.tencent.mobileqq.troop.homework.common.trooplist.HWTroopListFragment;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeRoleType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016R\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/publish/part/HWNoticeRangePart;", "Lcom/tencent/mobileqq/troop/homework/notice/publish/part/a;", "Landroid/view/View$OnClickListener;", "", "E9", "F9", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "", "e", "Lkotlin/Lazy;", "C9", "()Ljava/lang/String;", "troopUin", "f", "Landroid/view/View;", "viewGroup", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "rangeTextView", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "i", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "rangeInfo", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeRangePart extends a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View viewGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView rangeTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.common.trooplist.data.b rangeInfo;

    public HWNoticeRangePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.homework.notice.publish.part.HWNoticeRangePart$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeRangePart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    Intent intent;
                    String stringExtra;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Activity activity = HWNoticeRangePart.this.getActivity();
                    return (activity == null || (intent = activity.getIntent()) == null || (stringExtra = intent.getStringExtra("TROOP_UIN")) == null) ? "0" : stringExtra;
                }
            });
            this.troopUin = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void D9() {
        View view;
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        View view2 = this.viewGroup;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
            view = null;
        } else {
            view = view2;
        }
        h.a.m(aVar, view, "em_group_notice_area", ExposurePolicy.REPORT_NONE, null, null, null, 56, null);
        View view4 = this.viewGroup;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
        } else {
            view3 = view4;
        }
        aVar.f(view3);
    }

    private final void E9() {
        View findViewById = getPartRootView().findViewById(R.id.ztj);
        findViewById.setOnClickListener(this);
        if (HWNoticeUtils.f297171a.f(C9()) != HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_TEACHER) {
            findViewById.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026E\n            }\n        }");
        this.viewGroup = findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.zti);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.notice_range_troop_name)");
        this.rangeTextView = (TextView) findViewById2;
    }

    private final void F9() {
        LiveData<com.tencent.mobileqq.troop.homework.common.trooplist.data.b> R1 = x9().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.common.trooplist.data.b, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.common.trooplist.data.b, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.publish.part.HWNoticeRangePart$observeData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWNoticeRangePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.common.trooplist.data.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.common.trooplist.data.b bVar) {
                TextView textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                HWNoticeRangePart.this.rangeInfo = bVar;
                textView = HWNoticeRangePart.this.rangeTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rangeTextView");
                    textView = null;
                }
                textView.setText(bVar.a());
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.publish.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWNoticeRangePart.G9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final String C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (String) this.troopUin.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        List<String> emptyList;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            HWTroopListFragment.Companion companion = HWTroopListFragment.INSTANCE;
            HWPageType hWPageType = HWPageType.PAGE_TYPE_NOTICE;
            com.tencent.mobileqq.troop.homework.common.trooplist.data.b bVar = this.rangeInfo;
            if (bVar == null || (emptyList = bVar.b()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            companion.a(hWPageType, emptyList, C9());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        E9();
        F9();
        D9();
    }
}
