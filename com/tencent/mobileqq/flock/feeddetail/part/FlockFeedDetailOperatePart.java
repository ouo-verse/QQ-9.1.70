package com.tencent.mobileqq.flock.feeddetail.part;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/part/FlockFeedDetailOperatePart;", "Lcom/tencent/mobileqq/flock/base/b;", "Landroid/view/View$OnClickListener;", "", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "it", "E9", "", "isActive", "B9", "D9", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvEnterGroup", "Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "vm", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedDetailOperatePart extends com.tencent.mobileqq.flock.base.b implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvEnterGroup;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    public FlockFeedDetailOperatePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feeddetail.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailOperatePart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedDetailOperatePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.flock.feeddetail.viewmodel.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) FlockFeedDetailOperatePart.this.getViewModel(com.tencent.mobileqq.flock.feeddetail.viewmodel.a.class) : (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A9() {
        com.tencent.mobileqq.flock.feeddetail.bean.a data;
        y45.b a16;
        UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value = C9().R1().getValue();
        if (value != null && (data = value.getData()) != null && (a16 = data.a()) != null) {
            broadcastMessage("ACTION_MSG_JOIN_GROUP", new com.tencent.mobileqq.flock.feedcommon.part.a(a16, C9().S1().getSubSourceId()));
        }
    }

    private final void B9(boolean isActive) {
        int i3;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[1];
        if (isActive) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        pairArr[0] = TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, Integer.valueOf(i3));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        TextView textView = this.tvEnterGroup;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvEnterGroup");
            textView = null;
        }
        com.tencent.mobileqq.flock.datong.c.d(textView, "em_bas_search_sub_activity_entry_button", new com.tencent.mobileqq.flock.datong.b().g(mutableMapOf));
    }

    private final com.tencent.mobileqq.flock.feeddetail.viewmodel.a C9() {
        return (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) this.vm.getValue();
    }

    private final void D9(boolean isActive) {
        String str;
        TextView textView = this.tvEnterGroup;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvEnterGroup");
            textView = null;
        }
        if (isActive) {
            str = "\u8fdb\u5165\u7fa4\u804a";
        } else {
            str = "\u5df2\u7ed3\u675f";
        }
        textView.setText(str);
        textView.setEnabled(isActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> it) {
        y45.b a16 = it.getData().a();
        TextView textView = this.tvEnterGroup;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvEnterGroup");
            textView = null;
        }
        textView.setVisibility(0);
        D9(com.tencent.mobileqq.flock.ktx.e.e(a16.f449374i));
        B9(com.tencent.mobileqq.flock.ktx.e.e(a16.f449374i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        LiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> R1 = C9().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit> function1 = new Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailOperatePart$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailOperatePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else if (it.getState() == 3) {
                    FlockFeedDetailOperatePart flockFeedDetailOperatePart = FlockFeedDetailOperatePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    flockFeedDetailOperatePart.E9(it);
                }
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feeddetail.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedDetailOperatePart.F9(Function1.this, obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f107746b9) {
                A9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f107746b9);
            TextView textView = (TextView) findViewById;
            textView.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView?>(\u2026peratePart)\n            }");
            this.tvEnterGroup = textView;
            initData();
        }
    }
}
