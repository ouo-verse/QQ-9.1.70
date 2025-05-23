package com.tencent.mobileqq.guild.setting.folder;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.temp.api.IGuildFolderApi;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.chats.api.IGuildFolderGuideApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.av;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0001/\u0018\u0000 52\u00020\u0001:\u0003678B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "xh", "yh", "", "guildId", OcrConfig.CHINESE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onStart", "Landroid/app/Dialog;", "onCreateDialog", "onDestroyView", "Landroid/content/DialogInterface;", "dialog", "onDismiss", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getMScene", "()Ljava/lang/String;", "mScene", "D", "Ah", "mGuildId", "Lkotlin/Function0;", "E", "Lkotlin/jvm/functions/Function0;", "onDismissListener", "Lr01/c;", UserInfo.SEX_FEMALE, "Lr01/c;", "mLibraAnimatable", "Landroid/os/Handler;", "G", "Landroid/os/Handler;", "mHandler", "Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$IndirectAnimationRunnable;", "H", "Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$IndirectAnimationRunnable;", "mRunnable", "com/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$c", "I", "Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$c;", "serviceObserver", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "J", "a", "b", "IndirectAnimationRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildFolderGuideDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String mScene;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onDismissListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private r01.c mLibraAnimatable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IndirectAnimationRunnable mRunnable;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final c serviceObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$IndirectAnimationRunnable;", "Ljava/lang/Runnable;", "Lr01/c;", "drawable", "", "a", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "drawableWeakReference", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class IndirectAnimationRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<r01.c> drawableWeakReference;

        public final void a(@NotNull r01.c drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.drawableWeakReference = new WeakReference<>(drawable);
        }

        @Override // java.lang.Runnable
        public void run() {
            r01.c cVar;
            Logger.f235387a.d().w("GuildFolderGuideDialogFragment", 1, "[IndirectAnimationRunnable] run()");
            WeakReference<r01.c> weakReference = this.drawableWeakReference;
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.setLoopCount(1);
                cVar.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$a;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "onAnimationEnd", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$IndirectAnimationRunnable;", "b", "Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$IndirectAnimationRunnable;", "getRunnable", "()Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$IndirectAnimationRunnable;", "runnable", "", "c", "I", "loopNum", "<init>", "(Landroid/os/Handler;Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$IndirectAnimationRunnable;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends Animatable2Compat.AnimationCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler handler;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IndirectAnimationRunnable runnable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int loopNum;

        public a(@NotNull Handler handler, @NotNull IndirectAnimationRunnable runnable) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.handler = handler;
            this.runnable = runnable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(@Nullable Drawable drawable) {
            super.onAnimationEnd(drawable);
            Logger logger = Logger.f235387a;
            logger.d().d("GuildFolderGuideDialogFragment", 1, "[onAnimationEnd]");
            int i3 = this.loopNum + 1;
            this.loopNum = i3;
            if (i3 >= 10000) {
                logger.d().d("GuildFolderGuideDialogFragment", 1, "[onAnimationEnd]loopNum=" + this.loopNum + ", completely end the animation \uff01");
                return;
            }
            IndirectAnimationRunnable indirectAnimationRunnable = this.runnable;
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
            indirectAnimationRunnable.a((r01.c) drawable);
            this.handler.postDelayed(this.runnable, 1500L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$b;", "", "", "scene", "guildId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "", "callback", "a", "", "ANIM_DELAY", "J", "ANIM_INTERVAL", "", "ANIM_LOOP_COUNT", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.folder.GuildFolderGuideDialogFragment$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String scene, @NotNull String guildId, @NotNull FragmentManager fragmentManager, @NotNull Function0<Unit> callback) {
            GuildFolderGuideDialogFragment guildFolderGuideDialogFragment;
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(callback, "callback");
            IGuildFolderGuideApi iGuildFolderGuideApi = (IGuildFolderGuideApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildFolderGuideApi.class);
            if (!iGuildFolderGuideApi.alwaysShowInDebug() && iGuildFolderGuideApi.isShowGuildFolderGuide(scene)) {
                Logger.f235387a.d().d("GuildFolderGuideDialogFragment", 1, "[showIfNeed] return, mmkv.isShowGuildFolderGuide=true");
                return;
            }
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag("GuildFolderGuideDialogFragment");
            if (findFragmentByTag != null) {
                if (findFragmentByTag instanceof GuildFolderGuideDialogFragment) {
                    guildFolderGuideDialogFragment = (GuildFolderGuideDialogFragment) findFragmentByTag;
                } else {
                    guildFolderGuideDialogFragment = null;
                }
                if (guildFolderGuideDialogFragment != null) {
                    guildFolderGuideDialogFragment.onDismissListener = callback;
                }
            }
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            GuildFolderGuideDialogFragment guildFolderGuideDialogFragment2 = new GuildFolderGuideDialogFragment(scene, guildId);
            guildFolderGuideDialogFragment2.onDismissListener = callback;
            beginTransaction.add(guildFolderGuideDialogFragment2, "GuildFolderGuideDialogFragment").commitAllowingStateLoss();
            if (!iGuildFolderGuideApi.alwaysShowInDebug()) {
                Logger.f235387a.d().d("GuildFolderGuideDialogFragment", 1, "[showIfNeed] do mmkv.setShowGuildFolderGuide !");
                iGuildFolderGuideApi.setShowGuildFolderGuide(scene);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/folder/GuildFolderGuideDialogFragment$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            if (guildId != null) {
                GuildFolderGuideDialogFragment.this.zh(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildFolderGuideDialogFragment.this.zh(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildFolderGuideDialogFragment.this.zh(guildId);
        }
    }

    public GuildFolderGuideDialogFragment(@NotNull String mScene, @NotNull String mGuildId) {
        Intrinsics.checkNotNullParameter(mScene, "mScene");
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        this.mScene = mScene;
        this.mGuildId = mGuildId;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRunnable = new IndirectAnimationRunnable();
        this.serviceObserver = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(GuildFolderGuideDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(GuildFolderGuideDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            ((IGuildFolderApi) QRoute.api(IGuildFolderApi.class)).toMsgListGuildHelper(this$0.mScene, activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void xh() {
        AppInterface appInterface;
        at atVar = at.f235448a;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.addObserver(this.serviceObserver);
        }
    }

    private final void yh() {
        AppInterface appInterface;
        at atVar = at.f235448a;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.serviceObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(String guildId) {
        if (Intrinsics.areEqual(guildId, this.mGuildId)) {
            dismiss();
        }
    }

    @NotNull
    /* renamed from: Ah, reason: from getter */
    public final String getMGuildId() {
        return this.mGuildId;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        xh();
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        av g16 = av.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        g16.f442320b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.folder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFolderGuideDialogFragment.Bh(GuildFolderGuideDialogFragment.this, view);
            }
        });
        g16.f442327i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.folder.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFolderGuideDialogFragment.Ch(GuildFolderGuideDialogFragment.this, view);
            }
        });
        GuildFolderGuideConfig guildFolderGuideConfig = new GuildFolderGuideConfig(null, null, null, 7, null);
        e12.a<Boolean> d16 = GuildThemeManager.f235286a.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final GuildFolderGuideDialogFragment$onCreateView$3 guildFolderGuideDialogFragment$onCreateView$3 = new GuildFolderGuideDialogFragment$onCreateView$3(guildFolderGuideConfig, g16, this);
        d16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.folder.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFolderGuideDialogFragment.Dh(Function1.this, obj);
            }
        });
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Logger.f235387a.d().d("GuildFolderGuideDialogFragment", 1, "[onDestroyView]guildId=" + getMGuildId());
        yh();
        r01.c cVar = this.mLibraAnimatable;
        if (cVar != null) {
            cVar.stop();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View view;
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            view = window.findViewById(R.id.ugk);
        } else {
            view = null;
        }
        if (view != null) {
            view.setBackground(null);
        }
    }
}
