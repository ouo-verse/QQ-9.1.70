package com.tencent.mobileqq.flock.feeddetail.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R#\u0010\"\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/part/FlockFeedDetailTitlePart;", "Lcom/tencent/mobileqq/flock/feedcommon/part/d;", "Landroid/view/View$OnClickListener;", "", "B9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "uiStateData", "D9", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvTitle", tl.h.F, "ivShare", "i", "ivMore", "Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "vm", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedDetailTitlePart extends com.tencent.mobileqq.flock.feedcommon.part.d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivShare;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivMore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/part/FlockFeedDetailTitlePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailTitlePart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30405);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedDetailTitlePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feeddetail.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailTitlePart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedDetailTitlePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.flock.feeddetail.viewmodel.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) FlockFeedDetailTitlePart.this.getViewModel(com.tencent.mobileqq.flock.feeddetail.viewmodel.a.class) : (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
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
        FlockBaseFragment flockBaseFragment;
        UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value = C9().R1().getValue();
        if (value != null && (data = value.getData()) != null && (a16 = data.a()) != null) {
            IPartHost partHost = getPartHost();
            String str = null;
            if (partHost instanceof FlockBaseFragment) {
                flockBaseFragment = (FlockBaseFragment) partHost;
            } else {
                flockBaseFragment = null;
            }
            if (flockBaseFragment != null) {
                str = flockBaseFragment.getPageId();
            }
            broadcastMessage("ACTION_MSG_SHARE", new l(a16, String.valueOf(str), null, 4, null));
        }
    }

    private final void B9() {
        ImageView imageView = this.ivShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivShare");
            imageView = null;
        }
        com.tencent.mobileqq.flock.datong.c.c(imageView, "em_bas_search_partner_share");
    }

    private final com.tencent.mobileqq.flock.feeddetail.viewmodel.a C9() {
        return (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uiStateData) {
        ImageView imageView = this.ivShare;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivShare");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView3 = this.ivMore;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        LiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> R1 = C9().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit> function1 = new Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit>() { // from class: com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailTitlePart$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailTitlePart.this);
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
                    return;
                }
                int state = it.getState();
                if (state == 2 || state == 3) {
                    FlockFeedDetailTitlePart flockFeedDetailTitlePart = FlockFeedDetailTitlePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    flockFeedDetailTitlePart.D9(it);
                }
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feeddetail.part.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedDetailTitlePart.E9(Function1.this, obj);
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
            if (num != null && num.intValue() == R.id.du6) {
                getActivity().finish();
            } else if (num != null && num.intValue() == R.id.f165970y94) {
                A9();
            } else if (num != null && num.intValue() == R.id.dwf) {
                broadcastMessage("ACTION_MSG_MORE", null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.part.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.du6);
            ImageView imageView = (ImageView) findViewById;
            imageView.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026lTitlePart)\n            }");
            this.ivBack = imageView;
            View findViewById2 = rootView.findViewById(R.id.kbs);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_title)");
            this.tvTitle = (TextView) findViewById2;
            View findViewById3 = rootView.findViewById(R.id.f165970y94);
            ImageView imageView2 = (ImageView) findViewById3;
            imageView2.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<ImageView>(\u2026lTitlePart)\n            }");
            this.ivShare = imageView2;
            B9();
            View findViewById4 = rootView.findViewById(R.id.dwf);
            ImageView imageView3 = (ImageView) findViewById4;
            imageView3.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<ImageView>(\u2026lTitlePart)\n            }");
            this.ivMore = imageView3;
            initData();
        }
    }
}
