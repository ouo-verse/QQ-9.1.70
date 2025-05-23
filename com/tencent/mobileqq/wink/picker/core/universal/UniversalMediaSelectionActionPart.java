package com.tencent.mobileqq.wink.picker.core.universal;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaSelectionPanelStateViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 22\u00020\u0001:\u00013B\u0019\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0004J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0014J\u001a\u0010\u0014\u001a\u00020\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0004J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0004R\u0014\u0010\u0019\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaSelectionActionPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "J9", "K9", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "X9", "", NodeProps.VISIBLE, "T9", "btn", "Q9", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMeda", "M9", "U9", "O9", "d", "Z", "enableVideoTemplate", "e", "Ljava/lang/String;", "nextBtnText", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaSelectionPanelStateViewModel;", "f", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaSelectionPanelStateViewModel;", "stateViewModel", tl.h.F, "Landroid/view/View;", "getMediaSelectionPanelPart", "()Landroid/view/View;", "setMediaSelectionPanelPart", "(Landroid/view/View;)V", "mediaSelectionPanelPart", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "hintText", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", "shadowLine", "<init>", "(ZLjava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class UniversalMediaSelectionActionPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVideoTemplate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nextBtnText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkMediaSelectionPanelStateViewModel stateViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mediaSelectionPanelPart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView hintText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout shadowLine;

    public /* synthetic */ UniversalMediaSelectionActionPart(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? "\u4e0b\u4e00\u6b65" : str);
    }

    private final void H9() {
        boolean z16;
        LiveData<String> O1;
        final TextView textView = (TextView) getPartRootView().findViewById(R.id.zqm);
        int i3 = 0;
        if (this.nextBtnText.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            textView.setText(this.nextBtnText);
        }
        WinkMediaSelectionPanelStateViewModel winkMediaSelectionPanelStateViewModel = this.stateViewModel;
        if (winkMediaSelectionPanelStateViewModel != null && (O1 = winkMediaSelectionPanelStateViewModel.O1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart$initActionBtn$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    String str2;
                    TextView textView2 = textView;
                    str2 = this.nextBtnText;
                    textView2.setText(str2 + str);
                }
            };
            O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.universal.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionActionPart.I9(Function1.this, obj);
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(textView, "this");
        Q9(textView);
        View view = (TextView) getPartRootView().findViewById(R.id.f1172070t);
        if (view != null) {
            if (!this.enableVideoTemplate || !((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady()) {
                i3 = 8;
            }
            view.setVisibility(i3);
            U9(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void J9() {
        View findViewById = getPartRootView().findViewById(R.id.yzh);
        if (findViewById != null) {
            com.tencent.mobileqq.wink.picker.report.a.b(findViewById, WinkDaTongReportConstant.ElementId.EM_XSJ_PIC_MEDIA_PANEL, null, null, true, 12, null);
        } else {
            findViewById = null;
        }
        this.mediaSelectionPanelPart = findViewById;
        this.shadowLine = (RelativeLayout) getPartRootView().findViewById(R.id.f84064l9);
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            RelativeLayout relativeLayout = this.shadowLine;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.shadowLine;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
    }

    private final void K9() {
        float f16;
        LiveData<String> P1;
        this.hintText = (TextView) getPartRootView().findViewById(R.id.x_m);
        if (ImmersiveUtils.getScreenWidth() < 720) {
            f16 = 10.0f;
        } else {
            f16 = 12.0f;
        }
        TextView textView = this.hintText;
        if (textView != null) {
            textView.setTextSize(1, f16);
        }
        TextView textView2 = this.hintText;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        WinkMediaSelectionPanelStateViewModel winkMediaSelectionPanelStateViewModel = this.stateViewModel;
        if (winkMediaSelectionPanelStateViewModel != null && (P1 = winkMediaSelectionPanelStateViewModel.P1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart$initHintText$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    TextView textView3;
                    textView3 = UniversalMediaSelectionActionPart.this.hintText;
                    if (textView3 == null) {
                        return;
                    }
                    textView3.setText(str);
                }
            };
            P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.universal.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionActionPart.L9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void N9(UniversalMediaSelectionActionPart universalMediaSelectionActionPart, List list, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                list = null;
            }
            universalMediaSelectionActionPart.M9(list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNextBtnClick");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void P9(UniversalMediaSelectionActionPart universalMediaSelectionActionPart, List list, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                list = null;
            }
            universalMediaSelectionActionPart.O9(list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoTemplateBtnClick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(UniversalMediaSelectionActionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        N9(this$0, null, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(UniversalMediaSelectionActionPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        P9(this$0, null, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M9(@Nullable List<? extends LocalMediaInfo> selectedMeda) {
        WinkMediaPickerMainBaseFragment<?> b16;
        if (!FastClickUtils.isFastDoubleClick("UniversalMediaSelectionPanelPart", 1500L) && (b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this)) != null) {
            b16.di(getHostFragment() instanceof WinkQZoneMediaListFragment, selectedMeda);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O9(@Nullable List<? extends LocalMediaInfo> selectedMeda) {
        WinkMediaPickerMainBaseFragment<?> b16;
        if (!FastClickUtils.isFastDoubleClick("UniversalMediaSelectionPanelPart", 1500L) && (b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this)) != null) {
            b16.hi(getHostFragment() instanceof WinkQZoneMediaListFragment, selectedMeda);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q9(@NotNull final View btn) {
        LiveData<Boolean> N1;
        Intrinsics.checkNotNullParameter(btn, "btn");
        WinkMediaSelectionPanelStateViewModel winkMediaSelectionPanelStateViewModel = this.stateViewModel;
        if (winkMediaSelectionPanelStateViewModel != null && (N1 = winkMediaSelectionPanelStateViewModel.N1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart$setNextBtn$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    View view = btn;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    view.setEnabled(it.booleanValue());
                }
            };
            N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.universal.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionActionPart.R9(Function1.this, obj);
                }
            });
        }
        btn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.universal.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversalMediaSelectionActionPart.S9(UniversalMediaSelectionActionPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T9(boolean visible) {
        View view = this.mediaSelectionPanelPart;
        if (view != null) {
            if (visible && view.getVisibility() == 8) {
                view.setVisibility(0);
                w53.b.f("UniversalMediaSelectionPanelPart", "selection panel is visible");
            } else if (!visible && view.getVisibility() != 8) {
                view.setVisibility(8);
                w53.b.f("UniversalMediaSelectionPanelPart", "selection panel is gone");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U9(@NotNull final View btn) {
        LiveData<Boolean> N1;
        Intrinsics.checkNotNullParameter(btn, "btn");
        WinkMediaSelectionPanelStateViewModel winkMediaSelectionPanelStateViewModel = this.stateViewModel;
        if (winkMediaSelectionPanelStateViewModel != null && (N1 = winkMediaSelectionPanelStateViewModel.N1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart$setVideoTemplateBtn$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    View view = btn;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    view.setEnabled(it.booleanValue());
                }
            };
            N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.universal.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionActionPart.V9(Function1.this, obj);
                }
            });
        }
        btn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.universal.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversalMediaSelectionActionPart.W9(UniversalMediaSelectionActionPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X9() {
        LiveData<Boolean> S1;
        WinkMediaSelectionPanelStateViewModel winkMediaSelectionPanelStateViewModel = this.stateViewModel;
        if (winkMediaSelectionPanelStateViewModel != null && (S1 = winkMediaSelectionPanelStateViewModel.S1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaSelectionActionPart$updatePartVisibility$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    UniversalMediaSelectionActionPart universalMediaSelectionActionPart = UniversalMediaSelectionActionPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    universalMediaSelectionActionPart.T9(it.booleanValue());
                }
            };
            S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.universal.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UniversalMediaSelectionActionPart.Y9(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "UniversalMediaSelectionPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        WinkMediaSelectionPanelStateViewModel winkMediaSelectionPanelStateViewModel;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
        if (b16 != null) {
            winkMediaSelectionPanelStateViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.g(b16);
        } else {
            winkMediaSelectionPanelStateViewModel = null;
        }
        this.stateViewModel = winkMediaSelectionPanelStateViewModel;
        J9();
        X9();
        K9();
        H9();
    }

    public UniversalMediaSelectionActionPart(boolean z16, @NotNull String nextBtnText) {
        Intrinsics.checkNotNullParameter(nextBtnText, "nextBtnText");
        this.enableVideoTemplate = z16;
        this.nextBtnText = nextBtnText;
    }
}
