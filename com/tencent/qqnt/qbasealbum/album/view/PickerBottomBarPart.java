package com.tencent.qqnt.qbasealbum.album.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerFragment;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.event.PreviewEnterEvent;
import com.tencent.qqnt.qbasealbum.event.PreviewExitEvent;
import com.tencent.qqnt.qbasealbum.event.SelectMediaSizeEvent;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.utils.AccessibilityUtils;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001c\u0010\u001a\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001eH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0018\u00105\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010*R\u0018\u00107\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010*R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/PickerBottomBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/qqnt/qbasealbum/report/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/widget/TextView;", "textView", "", "H9", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "action", "I9", "C9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "u3", "", "duration", "onPageOut", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "d", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "bottomBarPart", "f", "Landroid/widget/TextView;", "previewBtn", tl.h.F, "editBtn", "Landroid/widget/CheckBox;", "i", "Landroid/widget/CheckBox;", "qualityCb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selectMediaSize", BdhLogUtil.LogTag.Tag_Conn, "qualityTv", "D", "sendBtn", "Lcom/tencent/qqnt/qbasealbum/share/a;", "E", "Lkotlin/Lazy;", "D9", "()Lcom/tencent/qqnt/qbasealbum/share/a;", "shareDataViewModel", "Lcom/tencent/qqnt/qbasealbum/utils/AccessibilityUtils$a;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "responseAccessibilityEventViewHandlers", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerBottomBarPart extends Part implements com.tencent.qqnt.qbasealbum.report.b, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView qualityTv;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView sendBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareDataViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<AccessibilityUtils.a> responseAccessibilityEventViewHandlers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup bottomBarPart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView previewBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView editBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CheckBox qualityCb;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView selectMediaSize;

    public PickerBottomBarPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.qbasealbum.share.a>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerBottomBarPart$shareDataViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerBottomBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.qqnt.qbasealbum.share.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.qbasealbum.share.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Object partHost = PickerBottomBarPart.this.getPartHost();
                    Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                    FragmentActivity requireActivity = ((Fragment) partHost).requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "partHost as Fragment).requireActivity()");
                    return com.tencent.qqnt.qbasealbum.album.b.h(requireActivity);
                }
            });
            this.shareDataViewModel = lazy;
            this.responseAccessibilityEventViewHandlers = new ArrayList<>();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void C9() {
        List<View> listOf;
        Map mapOf;
        TextView textView = this.qualityTv;
        if (textView != null) {
            ViewCompat.setImportantForAccessibility(textView, 2);
        }
        CheckBox checkBox = this.qualityCb;
        if (checkBox != null) {
            checkBox.setContentDescription(getContext().getResources().getString(R.string.f1772333e));
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.qualityCb, this.previewBtn, this.editBtn, this.sendBtn});
        for (View view : listOf) {
            if (view != null) {
                ArrayList<AccessibilityUtils.a> arrayList = this.responseAccessibilityEventViewHandlers;
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.f361618a;
                Function2<Object, View, Unit> c16 = accessibilityUtils.c();
                Function2<Object, View, Unit> d16 = accessibilityUtils.d();
                WeakReference weakReference = new WeakReference(view);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(PreviewEnterEvent.class, c16), TuplesKt.to(PreviewExitEvent.class, d16));
                arrayList.add(new AccessibilityUtils.a(weakReference, mapOf));
            }
        }
    }

    private final com.tencent.qqnt.qbasealbum.share.a D9() {
        return (com.tencent.qqnt.qbasealbum.share.a) this.shareDataViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(PickerBottomBarPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c(WinkDaTongReportConstant.ElementId.EM_BAS_ORIGINAL_DRAWING, 2, PickerBottomBarPart$onInitView$3$1.INSTANCE);
        CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = customizationFacade.b();
        boolean z17 = false;
        if (b16 != null && b16.checkQualityRawChange(z16)) {
            z17 = true;
        }
        if (z17) {
            this$0.D9().W1(z16);
            AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b17 = customizationFacade.b();
            if (b17 != null) {
                b17.onQualityRawChangeEvent(z16);
            }
        } else {
            compoundButton.setChecked(!z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        if ((!r4.isEmpty()) == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void G9(PickerBottomBarPart this$0, Boolean isRaw) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CheckBox checkBox = this$0.qualityCb;
        if (checkBox != null) {
            Intrinsics.checkNotNullExpressionValue(isRaw, "isRaw");
            checkBox.setChecked(isRaw.booleanValue());
        }
        Intrinsics.checkNotNullExpressionValue(isRaw, "isRaw");
        if (isRaw.booleanValue()) {
            SelectedMediaViewModel selectedMediaViewModel = this$0.selectedMediaViewModel;
            if (selectedMediaViewModel != null && (r4 = selectedMediaViewModel.getSelectedMedia()) != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                TextView textView = this$0.selectMediaSize;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this$0.selectMediaSize;
                if (textView2 != null) {
                    SelectedMediaViewModel selectedMediaViewModel2 = this$0.selectedMediaViewModel;
                    if (selectedMediaViewModel2 != null) {
                        str = selectedMediaViewModel2.a2();
                    } else {
                        str = null;
                    }
                    textView2.setText(str);
                    return;
                }
                return;
            }
        }
        TextView textView3 = this$0.selectMediaSize;
        if (textView3 != null) {
            textView3.setVisibility(4);
        }
        TextView textView4 = this$0.selectMediaSize;
        if (textView4 != null) {
            textView4.setText("");
        }
    }

    private final void H9(TextView textView) {
        int i3;
        if (textView != null) {
            if (textView.isEnabled()) {
                i3 = R.color.qui_common_text_primary;
            } else {
                i3 = R.color.qui_common_text_secondary_light;
            }
            textView.setTextColor(textView.getContext().getColorStateList(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(com.tencent.qqnt.qbasealbum.select.model.a action) {
        boolean z16;
        boolean z17;
        int i3;
        String str;
        TextView textView;
        String str2;
        boolean z18;
        int i16;
        CheckBox checkBox;
        int i17;
        boolean z19;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        boolean z26;
        boolean z27;
        List<LocalMediaInfo> selectedMedia;
        boolean z28 = true;
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.f) {
            z16 = true;
        } else {
            z16 = action instanceof com.tencent.qqnt.qbasealbum.select.model.b;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = action instanceof com.tencent.qqnt.qbasealbum.select.model.h;
        }
        if (z17) {
            SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
            if (selectedMediaViewModel != null && (selectedMedia = selectedMediaViewModel.getSelectedMedia()) != null) {
                i3 = selectedMedia.size();
            } else {
                i3 = 0;
            }
            TextView textView2 = this.editBtn;
            if (textView2 != null) {
                if (i3 == 1) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                textView2.setEnabled(z27);
            }
            H9(this.editBtn);
            TextView textView3 = this.previewBtn;
            if (textView3 != null) {
                if (i3 > 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                textView3.setEnabled(z26);
            }
            H9(this.previewBtn);
            TextView textView4 = this.sendBtn;
            if (textView4 != null) {
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
                if (b16 != null && (photoCommonData = b16.getPhotoCommonData()) != null) {
                    i17 = photoCommonData.e();
                } else {
                    i17 = 1;
                }
                if (i3 >= i17) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                textView4.setEnabled(z19);
            }
            if (i3 == 0 && (checkBox = this.qualityCb) != null) {
                checkBox.setChecked(false);
            }
            TextView textView5 = this.selectMediaSize;
            if (textView5 != null) {
                CheckBox checkBox2 = this.qualityCb;
                if (checkBox2 != null && checkBox2.isChecked()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 && i3 > 0) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                textView5.setVisibility(i16);
            }
            TextView textView6 = this.selectMediaSize;
            if (textView6 == null || textView6.getVisibility() != 0) {
                z28 = false;
            }
            if (z28 && (textView = this.selectMediaSize) != null) {
                SelectedMediaViewModel selectedMediaViewModel2 = this.selectedMediaViewModel;
                if (selectedMediaViewModel2 != null) {
                    str2 = selectedMediaViewModel2.a2();
                } else {
                    str2 = null;
                }
                textView.setText(str2);
            }
            if (i3 == 0) {
                str = "";
            } else {
                str = "(" + i3 + ")";
            }
            TextView textView7 = this.sendBtn;
            if (textView7 != null) {
                IPartHost partHost = getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerFragment");
                textView7.setText(((QAlbumPickerFragment) partHost).Eh().a() + str);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(PreviewEnterEvent.class);
        arrayList.add(PreviewExitEvent.class);
        arrayList.add(SelectMediaSizeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QBaseAlbumBottomPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        TextView textView;
        TextView textView2;
        CheckBox checkBox;
        TextView textView3;
        TextView textView4;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QAlbumBaseMainFragment<?> a16 = com.tencent.qqnt.qbasealbum.ktx.c.a(this);
        if (a16 != null) {
            FragmentActivity requireActivity = a16.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SelectedMediaViewModel g16 = com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
            this.selectedMediaViewModel = g16;
            if (g16 != null) {
                LiveData<com.tencent.qqnt.qbasealbum.select.model.a> S1 = g16.S1();
                IPartHost partHost = getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.view.PickerBottomBarPart$onInitView$1$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerBottomBarPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a action) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) action);
                            return;
                        }
                        PickerBottomBarPart pickerBottomBarPart = PickerBottomBarPart.this;
                        Intrinsics.checkNotNullExpressionValue(action, "action");
                        pickerBottomBarPart.I9(action);
                    }
                };
                S1.observe((LifecycleOwner) partHost, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.c
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        PickerBottomBarPart.E9(Function1.this, obj);
                    }
                });
            }
        }
        View findViewById = rootView.findViewById(R.id.t9g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.bottomBarPart)");
        this.bottomBarPart = (ViewGroup) findViewById;
        CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = customizationFacade.b();
        if (b16 != null) {
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            ViewGroup viewGroup = this.bottomBarPart;
            Button button = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarPart");
                viewGroup = null;
            }
            View bottomView = b16.getBottomView(context, viewGroup);
            if (bottomView != null) {
                ViewGroup viewGroup2 = this.bottomBarPart;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomBarPart");
                    viewGroup2 = null;
                }
                viewGroup2.addView(bottomView);
                boolean z16 = true;
                RFWNavigationBarImmersiveHelper.INSTANCE.adjustView(bottomView, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
                ViewGroup viewGroup3 = this.bottomBarPart;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomBarPart");
                    viewGroup3 = null;
                }
                viewGroup3.setVisibility(0);
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b17 = customizationFacade.b();
                if (b17 != null) {
                    textView = b17.getPreviewBtn();
                } else {
                    textView = null;
                }
                this.previewBtn = textView;
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b18 = customizationFacade.b();
                if (b18 != null) {
                    textView2 = b18.getMagicBtn();
                } else {
                    textView2 = null;
                }
                this.editBtn = textView2;
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b19 = customizationFacade.b();
                if (b19 != null) {
                    checkBox = b19.getQualityCb();
                } else {
                    checkBox = null;
                }
                this.qualityCb = checkBox;
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b26 = customizationFacade.b();
                if (b26 != null) {
                    textView3 = b26.getQualityTv();
                } else {
                    textView3 = null;
                }
                this.qualityTv = textView3;
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b27 = customizationFacade.b();
                if (b27 != null) {
                    textView4 = b27.getMediaSizeTv();
                } else {
                    textView4 = null;
                }
                this.selectMediaSize = textView4;
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b28 = customizationFacade.b();
                if (b28 != null) {
                    button = b28.getSendBtn();
                }
                this.sendBtn = button;
                if (button != null) {
                    IPartHost partHost2 = getPartHost();
                    Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerFragment");
                    button.setText(((QAlbumPickerFragment) partHost2).Eh().a());
                }
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b29 = customizationFacade.b();
                if (b29 == null || (photoCommonData = b29.getPhotoCommonData()) == null || photoCommonData.g()) {
                    z16 = false;
                }
                if (z16) {
                    TextView textView5 = this.qualityTv;
                    if (textView5 != null) {
                        textView5.setVisibility(4);
                    }
                    CheckBox checkBox2 = this.qualityCb;
                    if (checkBox2 != null) {
                        checkBox2.setVisibility(4);
                    }
                    TextView textView6 = this.selectMediaSize;
                    if (textView6 != null) {
                        textView6.setVisibility(4);
                    }
                }
            }
        }
        CheckBox checkBox3 = this.qualityCb;
        if (checkBox3 != null) {
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.qbasealbum.album.view.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                    PickerBottomBarPart.F9(PickerBottomBarPart.this, compoundButton, z17);
                }
            });
        }
        com.tencent.qqnt.qbasealbum.share.a D9 = D9();
        IPartHost partHost3 = getPartHost();
        Intrinsics.checkNotNull(partHost3, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        D9.Q1((LifecycleOwner) partHost3, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.view.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PickerBottomBarPart.G9(PickerBottomBarPart.this, (Boolean) obj);
            }
        });
        C9();
    }

    @Override // com.tencent.qqnt.qbasealbum.report.b
    public void onPageOut(long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, duration);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        boolean z17;
        TextView textView;
        String str;
        List<LocalMediaInfo> selectedMedia;
        Function2<Object, View, Unit> function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        boolean z18 = true;
        if (event instanceof PreviewEnterEvent) {
            z16 = true;
        } else {
            z16 = event instanceof PreviewExitEvent;
        }
        if (z16) {
            for (AccessibilityUtils.a aVar : this.responseAccessibilityEventViewHandlers) {
                View view = aVar.b().get();
                if (view != null && (function2 = aVar.a().get(event.getClass())) != null) {
                    function2.invoke(event, view);
                }
            }
            return;
        }
        if (event instanceof SelectMediaSizeEvent) {
            CheckBox checkBox = this.qualityCb;
            if (checkBox != null && checkBox.isChecked()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                SelectedMediaViewModel selectedMediaViewModel = this.selectedMediaViewModel;
                if (selectedMediaViewModel == null || (selectedMedia = selectedMediaViewModel.getSelectedMedia()) == null || !(!selectedMedia.isEmpty())) {
                    z18 = false;
                }
                if (z18 && (textView = this.selectMediaSize) != null) {
                    SelectedMediaViewModel selectedMediaViewModel2 = this.selectedMediaViewModel;
                    if (selectedMediaViewModel2 != null) {
                        str = selectedMediaViewModel2.a2();
                    } else {
                        str = null;
                    }
                    textView.setText(str);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.report.b
    public void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            com.tencent.qqnt.qbasealbum.report.c.f361503a.e(WinkDaTongReportConstant.ElementId.EM_BAS_PREVIEW, 2, PickerBottomBarPart$onPageIn$1.INSTANCE);
        }
    }
}
