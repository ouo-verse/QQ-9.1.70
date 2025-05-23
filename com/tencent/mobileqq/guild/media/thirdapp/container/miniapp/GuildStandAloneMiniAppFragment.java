package com.tencent.mobileqq.guild.media.thirdapp.container.miniapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.launcher.a;
import com.tencent.launcher.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.f;
import com.tencent.mobileqq.guild.media.thirdapp.container.vb.GuildStandAloneRootVB;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0002<@\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001eH\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR(\u0010H\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020<0E0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR0\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001b0Ij\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001b`J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/miniapp/GuildStandAloneMiniAppFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "vh", "wh", "Landroid/view/ViewGroup;", "parentView", "xh", "Landroid/view/View;", "sheetView", "yh", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", OcrConfig.CHINESE, "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "", "actionType", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "action", "mb", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "Rf", "onCreate", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onStart", DKHippyEvent.EVENT_STOP, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "D", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "", "E", "Z", "fromDragBar", "Lcom/tencent/launcher/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/launcher/a;", "inputProvider", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/GuildStandAloneRootVB;", "G", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/GuildStandAloneRootVB;", "rootVB", "com/tencent/mobileqq/guild/media/thirdapp/container/miniapp/GuildStandAloneMiniAppFragment$b", "H", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/miniapp/GuildStandAloneMiniAppFragment$b;", "actionCallback", "com/tencent/mobileqq/guild/media/thirdapp/container/miniapp/GuildStandAloneMiniAppFragment$c", "I", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/miniapp/GuildStandAloneMiniAppFragment$c;", "mBottomSheetCallback", "", "Lkotlin/Pair;", "J", "Ljava/util/List;", "messageList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "K", "Ljava/util/HashMap;", "registerCallbackMap", "<init>", "()V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildStandAloneMiniAppFragment extends BottomSheetDialogFragment implements com.tencent.mobileqq.guild.media.thirdapp.container.b {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private BottomSheetBehavior<View> bottomSheetBehavior;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean fromDragBar;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private a inputProvider;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GuildStandAloneRootVB rootVB;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b actionCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final c mBottomSheetCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, f> registerCallbackMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/miniapp/GuildStandAloneMiniAppFragment$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildStandAloneMiniAppFragment.this.vh(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/miniapp/GuildStandAloneMiniAppFragment$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends BottomSheetBehavior.e {
        c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            BottomSheetBehavior bottomSheetBehavior;
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 1 && !GuildStandAloneMiniAppFragment.this.fromDragBar && (bottomSheetBehavior = GuildStandAloneMiniAppFragment.this.bottomSheetBehavior) != null) {
                bottomSheetBehavior.setState(3);
            }
        }
    }

    public GuildStandAloneMiniAppFragment() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.actionCallback = bVar;
        this.mBottomSheetCallback = new c();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(MiniAppIntent.CloseCurrentContainerIntent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(MiniAppIntent.UpdateDragBar.class).getQualifiedName(), bVar)});
        this.messageList = listOf;
        this.registerCallbackMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh(MsgIntent intent) {
        ContainerMsgIntent containerMsgIntent;
        f fVar;
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[handleIntent] intent: " + intent);
        if (intent instanceof ContainerMsgIntent) {
            containerMsgIntent = (ContainerMsgIntent) intent;
        } else {
            containerMsgIntent = null;
        }
        if (containerMsgIntent != null && (fVar = this.registerCallbackMap.get(Reflection.getOrCreateKotlinClass(intent.getClass()).getQualifiedName())) != null) {
            fVar.a(containerMsgIntent);
        }
        if (intent instanceof MiniAppIntent.CloseCurrentContainerIntent) {
            uh();
        } else if (intent instanceof MiniAppIntent.UpdateDragBar) {
            this.fromDragBar = ((MiniAppIntent.UpdateDragBar) intent).getFromDragBar();
        }
    }

    private final void wh() {
        ViewGroup viewGroup;
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(requireContext());
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        aVar.getBehavior().setPeekHeight(instantScreenHeight);
        Window window = aVar.getWindow();
        if (window != null && (viewGroup = (ViewGroup) window.findViewById(R.id.ugk)) != null) {
            viewGroup.setBackgroundResource(17170445);
            yh(viewGroup);
        }
    }

    private final void xh(ViewGroup parentView) {
        this.rootVB = new GuildStandAloneRootVB();
        d.a c16 = new d.a().c(this);
        GuildStandAloneRootVB guildStandAloneRootVB = this.rootVB;
        Intrinsics.checkNotNull(guildStandAloneRootVB);
        d.a d16 = c16.f(guildStandAloneRootVB).e(parentView).d(this);
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        this.inputProvider = new com.tencent.launcher.c().a(d16.a(startParams).b());
    }

    private final void yh(View sheetView) {
        if (this.bottomSheetBehavior == null) {
            this.bottomSheetBehavior = BottomSheetBehavior.from(sheetView);
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.addBottomSheetCallback(this.mBottomSheetCallback);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.b
    public void Rf(@NotNull ContainerMsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.a(intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.b
    public void mb(@NotNull String actionType, @NotNull f action) {
        boolean z16;
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(action, "action");
        Logger.a d16 = Logger.f235387a.d();
        boolean z17 = false;
        if (this.inputProvider != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[registerIntentAction]: actionType " + actionType + ", " + z16);
        if (actionType.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return;
        }
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.b(actionType, this.actionCallback);
        }
        this.registerCallbackMap.put(actionType, action);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[onCreate] ");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        mt1.a aVar = new mt1.a(requireContext, getTheme());
        aVar.N(this);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Logger.a d16 = Logger.f235387a.d();
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        d16.d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "onCreateView, path: " + lt1.a.c(startParams));
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setBackgroundColor(0);
        xh(frameLayout);
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.launcher.a aVar = this.inputProvider;
            if (aVar != null) {
                String str = (String) pair.getFirst();
                if (str == null) {
                    str = "";
                }
                aVar.b(str, (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
        for (Map.Entry<String, f> entry : this.registerCallbackMap.entrySet()) {
            com.tencent.launcher.a aVar2 = this.inputProvider;
            if (aVar2 != null) {
                aVar2.b(entry.getKey(), this.actionCallback);
            }
        }
        com.tencent.launcher.a aVar3 = this.inputProvider;
        if (aVar3 != null) {
            aVar3.d(Lifecycle.Event.ON_CREATE);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[onDestroy] ");
        try {
            com.tencent.launcher.a aVar = this.inputProvider;
            if (aVar != null) {
                aVar.d(Lifecycle.Event.ON_DESTROY);
            }
        } catch (Throwable th5) {
            Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[onDestroy] error " + th5);
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.removeBottomSheetCallback(this.mBottomSheetCallback);
        }
        this.bottomSheetBehavior = null;
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.launcher.a aVar2 = this.inputProvider;
            if (aVar2 != null) {
                String str = (String) pair.getFirst();
                if (str == null) {
                    str = "";
                }
                aVar2.c(str, (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
        for (Map.Entry<String, f> entry : this.registerCallbackMap.entrySet()) {
            com.tencent.launcher.a aVar3 = this.inputProvider;
            if (aVar3 != null) {
                aVar3.c(entry.getKey(), this.actionCallback);
            }
        }
        GuildStandAloneRootVB guildStandAloneRootVB = this.rootVB;
        if (guildStandAloneRootVB != null) {
            guildStandAloneRootVB.destroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Logger.a d16 = Logger.f235387a.d();
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        d16.d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[onDismiss] path " + lt1.a.c(startParams));
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.a(new MainProcessIntent.ContainerLifeIntent(ContainerLifeEvent.ON_MINIAPP_DISMISS));
        }
        super.onDismiss(dialog);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.d(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "onResume");
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.d(Lifecycle.Event.ON_RESUME);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[onStart] ");
        wh();
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.d(Lifecycle.Event.ON_START);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[onStop] ");
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.d(Lifecycle.Event.ON_STOP);
        }
    }

    public void uh() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneMiniAppFragment", 1, "[closeCurrentContainer]");
        dismissAllowingStateLoss();
    }

    public final void zh(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        this.startParams = startParams;
    }
}
