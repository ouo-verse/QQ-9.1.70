package com.tencent.mobileqq.multishare.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.multishare.fragment.MultiShareBottomDialogFragment;
import com.tencent.mobileqq.multishare.fragment.MultiShareUsersListBottomFragment;
import com.tencent.mobileqq.multishare.widget.MultiShareIconListView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/MultiShareTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "initView", "initViewModel", "G9", "I9", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "closeBtn", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "titleWrapper", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleView", tl.h.F, "arrowView", "Lcom/tencent/mobileqq/multishare/widget/MultiShareIconListView;", "i", "Lcom/tencent/mobileqq/multishare/widget/MultiShareIconListView;", "avatarIconsListView", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "customTitleLayout", "", "Lcom/tencent/mobileqq/multishare/bean/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "chosenUsers", "<init>", "()V", "D", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiShareTitlePart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.multishare.bean.a> chosenUsers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView closeBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout titleWrapper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView arrowView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MultiShareIconListView avatarIconsListView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout customTitleLayout;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/MultiShareTitlePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.part.MultiShareTitlePart$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43335);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiShareTitlePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.chosenUsers = new ArrayList();
        }
    }

    private final void F9() {
        DialogFragment dialogFragment;
        Object partHost = getPartHost();
        if (partHost instanceof DialogFragment) {
            dialogFragment = (DialogFragment) partHost;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    private final void G9() {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.d dVar;
        IPartHost partHost = getPartHost();
        TextView textView = null;
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null) {
            dVar = multiShareBottomDialogFragment.wh();
        } else {
            dVar = null;
        }
        if (dVar != null) {
            FrameLayout frameLayout = (FrameLayout) getPartRootView().findViewById(R.id.ziu);
            this.customTitleLayout = frameLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            FrameLayout frameLayout2 = this.customTitleLayout;
            if (frameLayout2 != null) {
                frameLayout2.addView(dVar.create());
            }
            TextView textView2 = this.titleView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        if (!(getActivity() instanceof FragmentActivity)) {
            QLog.d("MultiShareTitlePart", 1, "no FragmentActivity.");
            return;
        }
        MultiShareUsersListBottomFragment multiShareUsersListBottomFragment = new MultiShareUsersListBottomFragment();
        multiShareUsersListBottomFragment.vh(this.chosenUsers);
        multiShareUsersListBottomFragment.uh(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.multishare.part.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MultiShareTitlePart.J9(MultiShareTitlePart.this, dialogInterface);
            }
        });
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().add(multiShareUsersListBottomFragment, "MultiShareUsersListBottomFragment").commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(MultiShareTitlePart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9();
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.zis);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.multi_share_close)");
        this.closeBtn = (ImageView) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.zj8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ulti_share_title_wrapper)");
        this.titleWrapper = (LinearLayout) findViewById2;
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageView imageView = this.closeBtn;
        LinearLayout linearLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView = null;
        }
        cVar.i(context, imageView);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        LinearLayout linearLayout2 = this.titleWrapper;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleWrapper");
            linearLayout2 = null;
        }
        cVar.i(context2, linearLayout2);
        View findViewById3 = getPartRootView().findViewById(R.id.zj5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.multi_share_title)");
        this.titleView = (TextView) findViewById3;
        View findViewById4 = getPartRootView().findViewById(R.id.zj7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026_share_title_avatar_list)");
        this.avatarIconsListView = (MultiShareIconListView) findViewById4;
        View findViewById5 = getPartRootView().findViewById(R.id.zj6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026.multi_share_title_arrow)");
        this.arrowView = (ImageView) findViewById5;
        ImageView imageView2 = this.closeBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        LinearLayout linearLayout3 = this.titleWrapper;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleWrapper");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setOnClickListener(this);
        G9();
    }

    private final void initViewModel() {
        MutableLiveData<List<com.tencent.mobileqq.multishare.bean.a>> L1 = ((com.tencent.mobileqq.multishare.viewmodel.a) getViewModel(com.tencent.mobileqq.multishare.viewmodel.a.class)).L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.multishare.bean.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.multishare.bean.a>, Unit>() { // from class: com.tencent.mobileqq.multishare.part.MultiShareTitlePart$initViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiShareTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.multishare.bean.a> list) {
                invoke2((List<com.tencent.mobileqq.multishare.bean.a>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.tencent.mobileqq.multishare.bean.a> it) {
                MultiShareIconListView multiShareIconListView;
                TextView textView;
                ImageView imageView;
                FrameLayout frameLayout;
                TextView textView2;
                List list;
                List list2;
                TextView textView3;
                ImageView imageView2;
                FrameLayout frameLayout2;
                TextView textView4;
                FrameLayout frameLayout3;
                TextView textView5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                multiShareIconListView = MultiShareTitlePart.this.avatarIconsListView;
                TextView textView6 = null;
                if (multiShareIconListView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarIconsListView");
                    multiShareIconListView = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                multiShareIconListView.setIconData(it);
                if (it.isEmpty()) {
                    textView3 = MultiShareTitlePart.this.titleView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleView");
                        textView3 = null;
                    }
                    textView3.setText(HardCodeUtil.qqStr(R.string.f169512ij));
                    imageView2 = MultiShareTitlePart.this.arrowView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("arrowView");
                        imageView2 = null;
                    }
                    imageView2.setVisibility(8);
                    frameLayout2 = MultiShareTitlePart.this.customTitleLayout;
                    if (frameLayout2 != null) {
                        frameLayout3 = MultiShareTitlePart.this.customTitleLayout;
                        if (frameLayout3 != null) {
                            frameLayout3.setVisibility(0);
                        }
                        textView5 = MultiShareTitlePart.this.titleView;
                        if (textView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("titleView");
                        } else {
                            textView6 = textView5;
                        }
                        textView6.setVisibility(8);
                    } else {
                        textView4 = MultiShareTitlePart.this.titleView;
                        if (textView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("titleView");
                        } else {
                            textView6 = textView4;
                        }
                        textView6.setVisibility(0);
                    }
                } else {
                    textView = MultiShareTitlePart.this.titleView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleView");
                        textView = null;
                    }
                    textView.setText(HardCodeUtil.qqStr(R.string.f169502ii));
                    imageView = MultiShareTitlePart.this.arrowView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("arrowView");
                        imageView = null;
                    }
                    imageView.setVisibility(0);
                    frameLayout = MultiShareTitlePart.this.customTitleLayout;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    textView2 = MultiShareTitlePart.this.titleView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    } else {
                        textView6 = textView2;
                    }
                    textView6.setVisibility(0);
                }
                list = MultiShareTitlePart.this.chosenUsers;
                list.clear();
                list2 = MultiShareTitlePart.this.chosenUsers;
                list2.addAll(it);
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.multishare.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiShareTitlePart.H9(Function1.this, obj);
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
            TextView textView = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.zis) {
                F9();
            } else if (num != null && num.intValue() == R.id.zj8) {
                TextView textView2 = this.titleView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                } else {
                    textView = textView2;
                }
                if (!Intrinsics.areEqual(textView.getText(), HardCodeUtil.qqStr(R.string.f169512ij))) {
                    I9();
                }
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
        initView();
        initViewModel();
    }
}
