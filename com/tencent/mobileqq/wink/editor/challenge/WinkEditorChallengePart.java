package com.tencent.mobileqq.wink.editor.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.d;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.model.AEDataToEditor;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.view.InteractiveFrameLayout;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/challenge/WinkEditorChallengePart;", "Lcom/tencent/mobileqq/wink/editor/d;", "", "tagName", "", "Z9", "aa", "", "B9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "initAfterInflation", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "ba", "Landroid/os/Bundle;", "args", "L9", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout;", "D", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout;", "interactiveFrameLayout", "E", "Landroid/view/View;", "customView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "textView", "Lb63/a;", "G", "Lb63/a;", "winkEditorChallengeViewModel", "H", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "lastModel", "<init>", "()V", "I", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorChallengePart extends d {

    /* renamed from: D, reason: from kotlin metadata */
    private InteractiveFrameLayout interactiveFrameLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private View customView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView textView;

    /* renamed from: G, reason: from kotlin metadata */
    private b63.a winkEditorChallengeViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private InteractiveModel lastModel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/challenge/WinkEditorChallengePart$b", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout$d;", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "model", "", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements InteractiveFrameLayout.d {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void a() {
            InteractiveFrameLayout.d.a.a(this);
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void b(@Nullable InteractiveModel model) {
            String tagName;
            if (model != null && (tagName = model.getTagName()) != null) {
                WinkEditorChallengePart.this.aa(tagName);
            }
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void c(@Nullable InteractiveModel model) {
            String str;
            String str2;
            QLog.d(WinkEditorChallengePart.this.getTAG(), 1, "onDeleteCallback... isFromCapture challenge model:" + model);
            com.tencent.mobileqq.wink.model.b bVar = com.tencent.mobileqq.wink.model.b.f324006a;
            if (model != null) {
                str = model.getTagName();
            } else {
                str = null;
            }
            bVar.h(str, false);
            if (model == null || (str2 = model.getTagName()) == null) {
                str2 = "";
            }
            bVar.i(str2);
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void d(@Nullable InteractiveModel interactiveModel) {
            InteractiveFrameLayout.d.a.b(this, interactiveModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(String tagName) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_challenge_topic", tagName);
        InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
        InteractiveFrameLayout interactiveFrameLayout2 = null;
        if (interactiveFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout = null;
        }
        VideoReport.setElementParams(interactiveFrameLayout, params);
        InteractiveFrameLayout interactiveFrameLayout3 = this.interactiveFrameLayout;
        if (interactiveFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout3 = null;
        }
        VideoReport.setElementId(interactiveFrameLayout3, "em_xsj_topic_challenge_guide_bar");
        InteractiveFrameLayout interactiveFrameLayout4 = this.interactiveFrameLayout;
        if (interactiveFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout4 = null;
        }
        VideoReport.setElementExposePolicy(interactiveFrameLayout4, ExposurePolicy.REPORT_ALL);
        InteractiveFrameLayout interactiveFrameLayout5 = this.interactiveFrameLayout;
        if (interactiveFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
        } else {
            interactiveFrameLayout2 = interactiveFrameLayout5;
        }
        VideoReport.setElementClickPolicy(interactiveFrameLayout2, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(String tagName) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_challenge_topic", tagName);
        params.put("xsj_eid", "em_xsj_topic_challenge_guide_bar");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
        if (interactiveFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout = null;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", interactiveFrameLayout, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f164761tr1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
    }

    @Nullable
    public final InteractiveModel ba() {
        InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
        if (interactiveFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout = null;
        }
        return interactiveFrameLayout.H();
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorChallengePart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        View inflate;
        AEDataToEditor aEDataToEditor;
        Unit unit;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        View findViewById = rootView.findViewById(R.id.xpb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026d.interactiveFrameLayout)");
        this.interactiveFrameLayout = (InteractiveFrameLayout) findViewById;
        b63.a aVar = null;
        if (z73.a.f452126a.a()) {
            LayoutInflater from = LayoutInflater.from(getContext());
            InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
            if (interactiveFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                interactiveFrameLayout = null;
            }
            inflate = from.inflate(R.layout.f168933hd4, (ViewGroup) interactiveFrameLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            LayoutInfl\u2026eLayout, false)\n        }");
        } else {
            LayoutInflater from2 = LayoutInflater.from(getContext());
            InteractiveFrameLayout interactiveFrameLayout2 = this.interactiveFrameLayout;
            if (interactiveFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                interactiveFrameLayout2 = null;
            }
            inflate = from2.inflate(R.layout.f168932hd3, (ViewGroup) interactiveFrameLayout2, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            LayoutInfl\u2026eLayout, false)\n        }");
        }
        this.customView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customView");
            inflate = null;
        }
        View findViewById2 = inflate.findViewById(R.id.f164762tr2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "customView.findViewById(\u2026api.R.id.challenge_topic)");
        this.textView = (TextView) findViewById2;
        InteractiveFrameLayout interactiveFrameLayout3 = this.interactiveFrameLayout;
        if (interactiveFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout3 = null;
        }
        View view = this.customView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customView");
            view = null;
        }
        interactiveFrameLayout3.K(view);
        InteractiveFrameLayout interactiveFrameLayout4 = this.interactiveFrameLayout;
        if (interactiveFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout4 = null;
        }
        interactiveFrameLayout4.setVisibility(8);
        InteractiveFrameLayout interactiveFrameLayout5 = this.interactiveFrameLayout;
        if (interactiveFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            interactiveFrameLayout5 = null;
        }
        interactiveFrameLayout5.setOnCenterViewClick(new b());
        ViewModel viewModel = getViewModel(b63.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorC\u2026ngeViewModel::class.java)");
        b63.a aVar2 = (b63.a) viewModel;
        this.winkEditorChallengeViewModel = aVar2;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkEditorChallengeViewModel");
            aVar2 = null;
        }
        LiveData<InteractiveModel> L1 = aVar2.L1();
        Fragment hostFragment = getHostFragment();
        final Function1<InteractiveModel, Unit> function1 = new Function1<InteractiveModel, Unit>() { // from class: com.tencent.mobileqq.wink.editor.challenge.WinkEditorChallengePart$initAfterInflation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InteractiveModel interactiveModel) {
                invoke2(interactiveModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable InteractiveModel interactiveModel) {
                Unit unit2;
                InteractiveFrameLayout interactiveFrameLayout6;
                InteractiveFrameLayout interactiveFrameLayout7;
                InteractiveFrameLayout interactiveFrameLayout8;
                InteractiveFrameLayout interactiveFrameLayout9;
                com.tencent.mobileqq.wink.model.b bVar = com.tencent.mobileqq.wink.model.b.f324006a;
                if (bVar.d()) {
                    QLog.d(WinkEditorChallengePart.this.getTAG(), 1, "initAfterInflation... challenge model:" + interactiveModel);
                    InteractiveFrameLayout interactiveFrameLayout10 = null;
                    if (interactiveModel != null) {
                        WinkEditorChallengePart winkEditorChallengePart = WinkEditorChallengePart.this;
                        winkEditorChallengePart.Z9(interactiveModel.getTagName());
                        bVar.g(interactiveModel.getTagName(), true);
                        interactiveFrameLayout8 = winkEditorChallengePart.interactiveFrameLayout;
                        if (interactiveFrameLayout8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                            interactiveFrameLayout8 = null;
                        }
                        interactiveFrameLayout8.setVisibility(0);
                        interactiveFrameLayout9 = winkEditorChallengePart.interactiveFrameLayout;
                        if (interactiveFrameLayout9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                            interactiveFrameLayout9 = null;
                        }
                        interactiveFrameLayout9.b0(interactiveModel, true);
                        unit2 = Unit.INSTANCE;
                    } else {
                        unit2 = null;
                    }
                    if (unit2 == null) {
                        WinkEditorChallengePart winkEditorChallengePart2 = WinkEditorChallengePart.this;
                        bVar.g("", false);
                        interactiveFrameLayout6 = winkEditorChallengePart2.interactiveFrameLayout;
                        if (interactiveFrameLayout6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                            interactiveFrameLayout6 = null;
                        }
                        interactiveFrameLayout6.setVisibility(8);
                        interactiveFrameLayout7 = winkEditorChallengePart2.interactiveFrameLayout;
                        if (interactiveFrameLayout7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                        } else {
                            interactiveFrameLayout10 = interactiveFrameLayout7;
                        }
                        interactiveFrameLayout10.G();
                    }
                }
            }
        };
        L1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.editor.challenge.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorChallengePart.ca(Function1.this, obj);
            }
        });
        LiveData<MenuType> e36 = G9().e3();
        Fragment hostFragment2 = getHostFragment();
        final Function1<MenuType, Unit> function12 = new Function1<MenuType, Unit>() { // from class: com.tencent.mobileqq.wink.editor.challenge.WinkEditorChallengePart$initAfterInflation$3

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes21.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f319077a;

                static {
                    int[] iArr = new int[MenuType.values().length];
                    try {
                        iArr[MenuType.TO_IMAGE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MenuType.EFFECT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MenuType.TO_VIDEO.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[MenuType.BOTTOM_DASHBOARD.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f319077a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MenuType menuType) {
                invoke2(menuType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MenuType menuType) {
                InteractiveFrameLayout interactiveFrameLayout6;
                b63.a aVar3;
                InteractiveModel interactiveModel;
                b63.a aVar4;
                int i3 = menuType == null ? -1 : a.f319077a[menuType.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    WinkEditorChallengePart winkEditorChallengePart = WinkEditorChallengePart.this;
                    interactiveFrameLayout6 = winkEditorChallengePart.interactiveFrameLayout;
                    if (interactiveFrameLayout6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                        interactiveFrameLayout6 = null;
                    }
                    winkEditorChallengePart.lastModel = interactiveFrameLayout6.H();
                    aVar3 = WinkEditorChallengePart.this.winkEditorChallengeViewModel;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkEditorChallengeViewModel");
                        aVar3 = null;
                    }
                    aVar3.N1(null);
                    return;
                }
                if (i3 == 3 || i3 == 4) {
                    interactiveModel = WinkEditorChallengePart.this.lastModel;
                    if (interactiveModel != null) {
                        aVar4 = WinkEditorChallengePart.this.winkEditorChallengeViewModel;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkEditorChallengeViewModel");
                            aVar4 = null;
                        }
                        aVar4.N1(interactiveModel);
                    }
                    WinkEditorChallengePart.this.lastModel = null;
                }
            }
        };
        e36.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.challenge.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorChallengePart.da(Function1.this, obj);
            }
        });
        Intent intent = getActivity().getIntent();
        AEMaterialMetaData aEMaterialMetaData = (AEMaterialMetaData) intent.getSerializableExtra(QQWinkConstants.CAPTURE_MATERIAL);
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.CAPTURE_AE_TO_EDITOR);
        if (serializableExtra instanceof AEDataToEditor) {
            aEDataToEditor = (AEDataToEditor) serializableExtra;
        } else {
            aEDataToEditor = null;
        }
        if (aEMaterialMetaData != null) {
            String str = aEMaterialMetaData.challengeTopic;
            Intrinsics.checkNotNullExpressionValue(str, "it.challengeTopic");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if ((!isBlank2) && com.tencent.mobileqq.wink.model.b.f324006a.e(aEMaterialMetaData.challengeTopic)) {
                QLog.d(this.TAG, 1, "captureMaterial... challengeTopic:" + aEMaterialMetaData.challengeTopic);
                float f16 = aEMaterialMetaData.challengePositionX;
                float f17 = aEMaterialMetaData.challengePositionY;
                float f18 = aEMaterialMetaData.challengeRotation;
                float f19 = aEMaterialMetaData.challengeScale;
                String str2 = aEMaterialMetaData.challengeTopic;
                Intrinsics.checkNotNullExpressionValue(str2, "it.challengeTopic");
                InteractiveModel interactiveModel = new InteractiveModel(f16, f17, f18, f19, str2, aEMaterialMetaData.challengeJoinsNums);
                b63.a aVar3 = this.winkEditorChallengeViewModel;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkEditorChallengeViewModel");
                    aVar3 = null;
                }
                aVar3.N1(interactiveModel);
            }
            unit = Unit.INSTANCE;
        } else if (aEDataToEditor != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(aEDataToEditor.getChallengeTopic());
            if ((!isBlank) && com.tencent.mobileqq.wink.model.b.f324006a.e(aEDataToEditor.getChallengeTopic())) {
                QLog.d(this.TAG, 1, "captureMaterial... from aeDataToEditor challengeTopic:" + aEDataToEditor.getChallengeTopic());
                InteractiveModel interactiveModel2 = new InteractiveModel(aEDataToEditor.getChallengePositionX(), aEDataToEditor.getChallengePositionY(), aEDataToEditor.getChallengeRotation(), aEDataToEditor.getChallengeScale(), aEDataToEditor.getChallengeTopic(), aEDataToEditor.getChallengeJoinsNums());
                b63.a aVar4 = this.winkEditorChallengeViewModel;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkEditorChallengeViewModel");
                    aVar4 = null;
                }
                aVar4.N1(interactiveModel2);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b63.a aVar5 = this.winkEditorChallengeViewModel;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkEditorChallengeViewModel");
            } else {
                aVar = aVar5;
            }
            aVar.M1(intent);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        com.tencent.mobileqq.wink.model.b.f324006a.i("");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        if (!com.tencent.mobileqq.wink.model.b.isShowChallengeFromCapture.getSecond().booleanValue() && !com.tencent.mobileqq.wink.model.b.isShowChallengeFromEditor.getSecond().booleanValue()) {
            QLog.d(getTAG(), 1, "onPartResume... " + com.tencent.mobileqq.wink.model.b.isShowChallengeFromCapture + " " + com.tencent.mobileqq.wink.model.b.isShowChallengeFromEditor);
            InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
            InteractiveFrameLayout interactiveFrameLayout2 = null;
            if (interactiveFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
                interactiveFrameLayout = null;
            }
            interactiveFrameLayout.G();
            InteractiveFrameLayout interactiveFrameLayout3 = this.interactiveFrameLayout;
            if (interactiveFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveFrameLayout");
            } else {
                interactiveFrameLayout2 = interactiveFrameLayout3;
            }
            interactiveFrameLayout2.setVisibility(8);
        }
    }
}
