package com.tencent.mobileqq.guild.jump;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J$\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0014`\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cR\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpLoadingDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/jump/GuildJumpLoadingEvent;", "", "initView", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "sh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "D", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingView", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildJumpLoadingDialog extends BottomSheetDialogFragment implements SimpleEventReceiver<GuildJumpLoadingEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private ScanningLightView loadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpLoadingDialog$a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.jump.GuildJumpLoadingDialog$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@Nullable FragmentActivity activity) {
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                GuildJumpLoadingDialog guildJumpLoadingDialog = new GuildJumpLoadingDialog();
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                guildJumpLoadingDialog.sh(supportFragmentManager, "Guild.jump.GuildJumpLoadingDialog");
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "show error, activity state error " + activity;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpLoadingDialog", 1, (String) it.next(), null);
            }
        }

        Companion() {
        }
    }

    private final void initView() {
        View view = this.rootView;
        ScanningLightView scanningLightView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        view.setBackgroundResource(R.drawable.guild_dialog_content_bg);
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById = view2.findViewById(R.id.efs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.loading_view)");
        ScanningLightView scanningLightView2 = (ScanningLightView) findViewById;
        this.loadingView = scanningLightView2;
        if (scanningLightView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            scanningLightView = scanningLightView2;
        }
        scanningLightView.setImageResource(R.drawable.guild_jump_loading_join_guild_dialog);
        SimpleEventBus.getInstance().registerReceiver(this);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.jump.GuildJumpLoadingDialog", 2, "initView registerReceiver");
        }
    }

    private final void qh() {
        com.google.android.material.bottomsheet.a aVar;
        Dialog dialog = getDialog();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            aVar = (com.google.android.material.bottomsheet.a) dialog;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            bottomSheetBehavior = aVar.getBehavior();
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.cfk));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(GuildJumpLoadingDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.jump.GuildJumpLoadingDialog", 1, "onReceiveEvent dismissAllowingStateLoss " + this$0.getActivity());
        try {
            this$0.dismissAllowingStateLoss();
        } catch (IllegalStateException e16) {
            Logger.f235387a.d().w("Guild.jump.GuildJumpLoadingDialog", 1, "close failed, e:" + e16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildJumpLoadingEvent>> getEventClass() {
        ArrayList<Class<GuildJumpLoadingEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildJumpLoadingEvent.class);
        return arrayListOf;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.evn, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.rootView = inflate;
        initView();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildJumpLoadingEvent) {
            Function0.b(200, new Runnable() { // from class: com.tencent.mobileqq.guild.jump.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildJumpLoadingDialog.rh(GuildJumpLoadingDialog.this);
                }
            });
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Object obj;
        View view;
        Window window;
        super.onResume();
        qh();
        View view2 = getView();
        WindowManager.LayoutParams layoutParams = null;
        if (view2 != null) {
            obj = view2.getParent();
        } else {
            obj = null;
        }
        if (obj instanceof View) {
            view = (View) obj;
        } else {
            view = null;
        }
        if (view != null) {
            view.setBackgroundColor(0);
        }
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.windowAnimations = R.style.avx;
        }
    }

    public final void sh(@NotNull FragmentManager manager, @NotNull String tag) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("showAllowingStateLoss mDismissed get error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpLoadingDialog", 1, (String) it.next(), null);
            }
            return;
        }
        FragmentTransaction beginTransaction = manager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
        beginTransaction.add(this, tag);
        beginTransaction.commitAllowingStateLoss();
    }
}
