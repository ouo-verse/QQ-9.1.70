package com.tencent.mobileqq.guild.media.listen.widget;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.ad;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.t;
import com.tencent.mobileqq.guild.media.listen.ListenPlugin;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.ContainerLoadParams;
import com.tencent.mobileqq.mini.api.IContainerPageNavigator;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.api.IMiniLoadCallback;
import com.tencent.mobileqq.mini.api.MiniContainerHolder;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.container.core.MiniView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0003>BF\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010!\u001a\u00020\u0002R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\f0\"j\b\u0012\u0004\u0012\u00020\f`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00105\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020*068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "Bh", "Ih", OcrConfig.CHINESE, "initView", "Ah", "Fh", "", "path", "Gh", "Lcom/tencent/mobileqq/mini/api/MiniContainerHolder;", ParseCommon.CONTAINER, "Hh", "yh", "", "Dh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "vh", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mMiniContainerList", "D", "Landroid/view/ViewGroup;", "mRootView", "Landroid/widget/FrameLayout;", "E", "Lkotlin/Lazy;", "xh", "()Landroid/widget/FrameLayout;", "mMiniViewRoot", UserInfo.SEX_FEMALE, "Z", "mFromDragBar", "G", "wh", "mDragBarView", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "H", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBehavior", "Lcom/tencent/mobileqq/mini/api/ContainerLoadParams;", "I", "Lcom/tencent/mobileqq/mini/api/ContainerLoadParams;", "mLoadParams", "com/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$d", "J", "Lcom/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$d;", "mMiniContainerNavCallback", "com/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$b", "K", "Lcom/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$b;", "dialogCloseEvent", "com/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$c", "L", "Lcom/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$c;", "mBottomSheetCallback", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaListenOrderDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<MiniContainerHolder> mMiniContainerList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMiniViewRoot;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mFromDragBar;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDragBarView;

    /* renamed from: H, reason: from kotlin metadata */
    private BottomSheetBehavior<FrameLayout> mBehavior;

    /* renamed from: I, reason: from kotlin metadata */
    private ContainerLoadParams mLoadParams;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final d mMiniContainerNavCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b dialogCloseEvent;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final c mBottomSheetCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$a;", "", "Lcom/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment;", "b", "", "a", "", "DIALOG_HEIGHT_RATIO", UserInfo.SEX_FEMALE, "MINI_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.listen.widget.MediaListenOrderDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            String builder = Uri.parse("10000-pages-together/playlist/playlist.html").buildUpon().appendQueryParameter("guild_id", j.a().getGuildID()).appendQueryParameter("channel_id", j.a().E()).appendQueryParameter("auth_meta", j.c().b()).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "parse(MINI_PATH).buildUp\u2026              .toString()");
            return builder;
        }

        @NotNull
        public final MediaListenOrderDialogFragment b() {
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).addExternalPlugin(ListenPlugin.class);
            return new MediaListenOrderDialogFragment();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ad;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements o<ad> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ad event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaListenOrderDialogFragment.this.dismissAllowingStateLoss();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 1 && !MediaListenOrderDialogFragment.this.mFromDragBar) {
                BottomSheetBehavior bottomSheetBehavior = MediaListenOrderDialogFragment.this.mBehavior;
                if (bottomSheetBehavior == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
                    bottomSheetBehavior = null;
                }
                bottomSheetBehavior.setState(3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/listen/widget/MediaListenOrderDialogFragment$d", "Lcom/tencent/mobileqq/mini/api/IContainerPageNavigator;", "", "path", "", "navigateTo", "navigateBack", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements IContainerPageNavigator {
        d() {
        }

        @Override // com.tencent.mobileqq.mini.api.IContainerPageNavigator
        public boolean navigateBack() {
            QLog.i("QGMC.MediaListen.MediaListenOrderDialogFragment", 1, "[navigateBack]");
            MediaListenOrderDialogFragment.this.vh();
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
        @Override // com.tencent.mobileqq.mini.api.IContainerPageNavigator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean navigateTo(@Nullable String path) {
            boolean z16;
            boolean isBlank;
            QLog.i("QGMC.MediaListen.MediaListenOrderDialogFragment", 1, "[navigateTo] path: " + path);
            if (path != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(path);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        MediaListenOrderDialogFragment.this.Gh(path);
                        return true;
                    }
                    return true;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    public MediaListenOrderDialogFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.guild.media.listen.widget.MediaListenOrderDialogFragment$mMiniViewRoot$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                ViewGroup viewGroup;
                viewGroup = MediaListenOrderDialogFragment.this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup = null;
                }
                return (FrameLayout) viewGroup.findViewById(R.id.f166285zb0);
            }
        });
        this.mMiniViewRoot = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.guild.media.listen.widget.MediaListenOrderDialogFragment$mDragBarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                ViewGroup viewGroup;
                viewGroup = MediaListenOrderDialogFragment.this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup = null;
                }
                return (FrameLayout) viewGroup.findViewById(R.id.f165708xb0);
            }
        });
        this.mDragBarView = lazy2;
        this.mMiniContainerNavCallback = new d();
        this.dialogCloseEvent = new b();
        this.mBottomSheetCallback = new c();
    }

    private final void Ah() {
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).setContainerNavigator(this.mMiniContainerNavCallback);
    }

    private final void Bh() {
        j.d().V(ad.class, this.dialogCloseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ch(MediaListenOrderDialogFragment this$0, View view, MotionEvent motionEvent) {
        Integer num;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        boolean z17 = true;
        if (num != null && num.intValue() == 0) {
            this$0.mFromDragBar = true;
        } else {
            if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 4)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (num == null || num.intValue() != 3)) {
                z17 = false;
            }
            if (z17) {
                this$0.mFromDragBar = false;
            }
        }
        return false;
    }

    private final boolean Dh() {
        boolean z16;
        boolean z17;
        if (getActivity() == null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && activity2.isDestroyed()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(int i3, String str) {
        QLog.i("QGMC.MediaListen.MediaListenOrderDialogFragment", 1, "load result code:" + i3 + ",msg:" + str);
    }

    private final void Fh() {
        QLog.i("QGMC.MediaListen.MediaListenOrderDialogFragment", 1, "[reloadAllMiniView] start");
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).reloadAllMiniContainer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(String path) {
        if (Dh()) {
            return;
        }
        IMiniContainer iMiniContainer = (IMiniContainer) QRoute.api(IMiniContainer.class);
        FragmentActivity activity = getActivity();
        ContainerLoadParams containerLoadParams = this.mLoadParams;
        if (containerLoadParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadParams");
            containerLoadParams = null;
        }
        MiniContainerHolder miniViewContainer = iMiniContainer.load(activity, this, path, containerLoadParams);
        Intrinsics.checkNotNullExpressionValue(miniViewContainer, "miniViewContainer");
        Hh(miniViewContainer);
    }

    private final void Hh(MiniContainerHolder container) {
        this.mMiniContainerList.add(container);
        zh();
    }

    private final void Ih() {
        j.d().j(ad.class, this.dialogCloseEvent);
    }

    private final void initView() {
        wh().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.media.listen.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Ch;
                Ch = MediaListenOrderDialogFragment.Ch(MediaListenOrderDialogFragment.this, view, motionEvent);
                return Ch;
            }
        });
    }

    private final FrameLayout wh() {
        Object value = this.mDragBarView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDragBarView>(...)");
        return (FrameLayout) value;
    }

    private final FrameLayout xh() {
        Object value = this.mMiniViewRoot.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mMiniViewRoot>(...)");
        return (FrameLayout) value;
    }

    private final void yh() {
        Window window;
        ViewGroup viewGroup;
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(requireContext());
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar != null && (window = aVar.getWindow()) != null && (viewGroup = (ViewGroup) window.findViewById(R.id.ugk)) != null) {
            viewGroup.setBackgroundResource(17170445);
        }
        Intrinsics.checkNotNull(aVar);
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "bottomSheetDialog!!.behavior");
        this.mBehavior = behavior;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        if (behavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            behavior = null;
        }
        behavior.setPeekHeight(instantScreenHeight);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = this.mBehavior;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
        } else {
            bottomSheetBehavior = bottomSheetBehavior2;
        }
        bottomSheetBehavior.addBottomSheetCallback(this.mBottomSheetCallback);
    }

    private final void zh() {
        int lastIndex;
        ArrayList<MiniContainerHolder> arrayList = this.mMiniContainerList;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        View view = arrayList.get(lastIndex).getView();
        view.setBackgroundColor(0);
        xh().addView(view, -1, new ViewGroup.LayoutParams(-1, (int) (ScreenUtil.getInstantScreenHeight(requireContext()) * 0.85714287f)));
        view.setNestedScrollingEnabled(false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Fh();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.d("QGMC.MediaListen.MediaListenOrderDialogFragment", 1, "onCreateView");
        View inflate = inflater.inflate(R.layout.eym, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mRootView = (ViewGroup) inflate;
        j.a().M0().V0(System.currentTimeMillis());
        ContainerLoadParams loadingCallback = new ContainerLoadParams().setAddDefaultRetryView(true).setAddDefaultLoadingView(false).setForceDefaultUIDarkMode(true).setLoadingCallback(new IMiniLoadCallback() { // from class: com.tencent.mobileqq.guild.media.listen.widget.c
            @Override // com.tencent.mobileqq.mini.api.IMiniLoadCallback
            public final void onLoaded(int i3, String str) {
                MediaListenOrderDialogFragment.Eh(i3, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(loadingCallback, "ContainerLoadParams()\n  \u2026:$msg\")\n                }");
        this.mLoadParams = loadingCallback;
        String a16 = INSTANCE.a();
        QLog.d("QGMC.MediaListen.MediaListenOrderDialogFragment", 4, "path:" + a16);
        Gh(a16);
        initView();
        Ah();
        Bh();
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Ih();
        int size = this.mMiniContainerList.size();
        for (int i3 = 0; i3 < size; i3++) {
            vh();
        }
        j.d().i(new t());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        QLog.d("QGMC.MediaListen.MediaListenOrderDialogFragment", 1, "onDismiss");
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.removeBottomSheetCallback(this.mBottomSheetCallback);
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).setContainerNavigator(null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        yh();
    }

    public final void vh() {
        int lastIndex;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.mMiniContainerList);
        if (lastIndex < 0) {
            return;
        }
        xh().removeViewAt(lastIndex);
        View view = this.mMiniContainerList.remove(lastIndex).getView();
        if (view instanceof MiniView) {
            ((MiniView) view).onDestroy();
        }
        if (this.mMiniContainerList.isEmpty()) {
            QLog.i("QGMC.MediaListen.MediaListenOrderDialogFragment", 1, "[clearLastMiniView] empty, dismiss dialog");
            dismissAllowingStateLoss();
        }
    }
}
