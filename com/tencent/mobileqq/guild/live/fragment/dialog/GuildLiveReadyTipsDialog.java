package com.tencent.mobileqq.guild.live.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.b;
import com.tencent.mobileqq.guild.live.config.GuildLiveTipsBean;
import com.tencent.mobileqq.guild.live.config.GuildLiveTipsContentItem;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR1\u0010&\u001a\u001d\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00040\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R#\u0010/\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R#\u00102\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R#\u00106\u001a\n **\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u00105R#\u0010:\u001a\n **\u0004\u0018\u000107078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b8\u00109R#\u0010?\u001a\n **\u0004\u0018\u00010;0;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010,\u001a\u0004\b=\u0010>R#\u0010B\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010,\u001a\u0004\bA\u0010.R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/dialog/GuildLiveReadyTipsDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Jh", "Ih", "Dh", "initViews", "Kh", "initData", "", "Lcom/tencent/mobileqq/guild/live/config/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "", BdhLogUtil.LogTag.Tag_Conn, "I", "liveType", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "needRecord", "D", "Lkotlin/jvm/functions/Function1;", "startCallback", "E", "Landroid/view/View;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Ch", "()Landroid/widget/TextView;", "tvTitle", "G", "Bh", "tvDesc", "H", "yh", "()Landroid/view/ViewGroup;", "itemContainer", "Landroid/widget/CheckBox;", "Ah", "()Landroid/widget/CheckBox;", "tipsCheckBox", "Landroid/widget/ScrollView;", "J", "getContentScrollView", "()Landroid/widget/ScrollView;", "contentScrollView", "K", OcrConfig.CHINESE, "startView", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "L", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "tipsCheckStatus", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveReadyTipsDialog extends BottomSheetDialogFragment {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int N = QQGuildUIUtil.f(140.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private int liveType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Function1<? super Boolean, Unit> startCallback = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$startCallback$1
        public final void invoke(boolean z16) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }
    };

    /* renamed from: E, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvTitle;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvDesc;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy tipsCheckBox;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentScrollView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy startView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final IDynamicParams tipsCheckStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J;\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fH\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/dialog/GuildLiveReadyTipsDialog$a;", "", "", "liveType", "", "f", "Lcom/tencent/mobileqq/guild/live/config/b;", "b", "", "d", "Landroidx/fragment/app/FragmentManager;", "fragManager", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "needRecord", "", "startBlock", "e", "c", "TAG", "Ljava/lang/String;", "mImgSize", "I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GuildLiveTipsBean b(int liveType) {
            if (liveType != 0) {
                if (liveType != 1) {
                    if (liveType != 2) {
                        return null;
                    }
                    return bs.f235483a.h("100576").getLiveReadyTipsConfBean().get_programLiveConf();
                }
                return bs.f235483a.h("100576").getLiveReadyTipsConfBean().get_gameLiveConf();
            }
            return bs.f235483a.h("100576").getLiveReadyTipsConfBean().g();
        }

        private final String f(int liveType) {
            return ch.g() + "_LiveReadyTips_" + liveType;
        }

        @JvmStatic
        public final void c(int liveType) {
            QLog.d("QGL.GuildLiveReadyTipsDialog", 4, "saveAgreeRecord:" + liveType);
            bw.L().encodeBool(f(liveType), true);
        }

        @JvmStatic
        public final boolean d(int liveType) {
            boolean z16;
            GuildLiveTipsBean b16 = b(liveType);
            if (b16 != null) {
                z16 = b16.getEnable();
            } else {
                z16 = false;
            }
            boolean decodeBool = bw.L().decodeBool(f(liveType), false);
            QLog.d("QGL.GuildLiveReadyTipsDialog", 4, "shouldShow liveType:" + liveType + ", haveRecord:" + decodeBool);
            if (!z16 || decodeBool) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final void e(int liveType, @NotNull FragmentManager fragManager, @NotNull Function1<? super Boolean, Unit> startBlock) {
            Intrinsics.checkNotNullParameter(fragManager, "fragManager");
            Intrinsics.checkNotNullParameter(startBlock, "startBlock");
            GuildLiveReadyTipsDialog guildLiveReadyTipsDialog = new GuildLiveReadyTipsDialog();
            guildLiveReadyTipsDialog.liveType = liveType;
            guildLiveReadyTipsDialog.startCallback = startBlock;
            com.tencent.mobileqq.guild.base.extension.d.a(guildLiveReadyTipsDialog, fragManager, "QGL.GuildLiveReadyTipsDialog");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/dialog/GuildLiveReadyTipsDialog$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                GuildLiveReadyTipsDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    public GuildLiveReadyTipsDialog() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$tvTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = GuildLiveReadyTipsDialog.this.rootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view = null;
                }
                return (TextView) view.findViewById(R.id.wnz);
            }
        });
        this.tvTitle = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$tvDesc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = GuildLiveReadyTipsDialog.this.rootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view = null;
                }
                return (TextView) view.findViewById(R.id.wnu);
            }
        });
        this.tvDesc = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ViewGroup>() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$itemContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                View view;
                view = GuildLiveReadyTipsDialog.this.rootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view = null;
                }
                return (ViewGroup) view.findViewById(R.id.wnv);
            }
        });
        this.itemContainer = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CheckBox>() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$tipsCheckBox$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CheckBox invoke() {
                View view;
                view = GuildLiveReadyTipsDialog.this.rootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view = null;
                }
                return (CheckBox) view.findViewById(R.id.wnt);
            }
        });
        this.tipsCheckBox = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ScrollView>() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$contentScrollView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScrollView invoke() {
                View view;
                view = GuildLiveReadyTipsDialog.this.rootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view = null;
                }
                return (ScrollView) view.findViewById(R.id.wm9);
            }
        });
        this.contentScrollView = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog$startView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = GuildLiveReadyTipsDialog.this.rootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view = null;
                }
                return (TextView) view.findViewById(R.id.wnx);
            }
        });
        this.startView = lazy6;
        this.tipsCheckStatus = new IDynamicParams() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Lh;
                Lh = GuildLiveReadyTipsDialog.Lh(GuildLiveReadyTipsDialog.this, str);
                return Lh;
            }
        };
    }

    private final CheckBox Ah() {
        return (CheckBox) this.tipsCheckBox.getValue();
    }

    private final TextView Bh() {
        return (TextView) this.tvDesc.getValue();
    }

    private final TextView Ch() {
        return (TextView) this.tvTitle.getValue();
    }

    private final void Dh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior<FrameLayout> behavior = ((com.google.android.material.bottomsheet.a) dialog).getBehavior();
        behavior.setPeekHeight(0);
        behavior.setState(3);
        behavior.addBottomSheetCallback(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(GuildLiveReadyTipsDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(GuildLiveReadyTipsDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Kh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(GuildLiveReadyTipsDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah().setChecked(!this$0.Ah().isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(GuildLiveReadyTipsDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ih() {
        ch.f235509b.setElementExposureAndClickDynamicParams(zh(), "em_guilid_agree", this.tipsCheckStatus);
    }

    private final void Jh(View rootView) {
        String str;
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        if (channelInfo == null) {
            return;
        }
        VideoReport.setPageId(rootView, "pg_sgrp_guilid_violation_tips");
        HashMap hashMap = new HashMap();
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        hashMap.put("sgrp_channel_id", guildId);
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        hashMap.put("sgrp_sub_channel_id", channelUin);
        if (this.liveType == 1) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("sgrp_live_method", str);
        ch.f235509b.setChannelPageParams(rootView, channelInfo, hashMap);
    }

    private final void Kh() {
        dismissAllowingStateLoss();
        this.startCallback.invoke(Boolean.valueOf(Ah().isChecked()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Lh(GuildLiveReadyTipsDialog this$0, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        if (this$0.Ah().isChecked()) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        hashMap.put("no_more_reminder", str2);
        return hashMap;
    }

    private final void initData() {
        GuildLiveTipsBean b16 = INSTANCE.b(this.liveType);
        boolean z16 = true;
        if (b16 == null) {
            QLog.e("QGL.GuildLiveReadyTipsDialog", 1, "initData, bean == null !!!");
            dismissAllowingStateLoss();
            return;
        }
        Ch().setText(b16.getTitle());
        if (b16.getContent().getDes().length() <= 0) {
            z16 = false;
        }
        if (z16) {
            Bh().setText(b16.getContent().getDes());
            Bh().setVisibility(0);
        }
        xh(b16.getContent().b());
    }

    private final void initViews() {
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ((TextView) view.findViewById(R.id.wns)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildLiveReadyTipsDialog.Eh(GuildLiveReadyTipsDialog.this, view3);
            }
        });
        zh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildLiveReadyTipsDialog.Fh(GuildLiveReadyTipsDialog.this, view3);
            }
        });
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        view2.findViewById(R.id.f165223v82).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildLiveReadyTipsDialog.Gh(GuildLiveReadyTipsDialog.this, view4);
            }
        });
    }

    private final void xh(List<GuildLiveTipsContentItem> item) {
        boolean z16;
        for (GuildLiveTipsContentItem guildLiveTipsContentItem : item) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ex8, (ViewGroup) null);
            yh().addView(inflate);
            ((TextView) inflate.findViewById(R.id.wny)).setText(guildLiveTipsContentItem.getText());
            if (guildLiveTipsContentItem.getIconUrl().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ImageView iconIv = (ImageView) inflate.findViewById(R.id.wnw);
                b.Companion companion = com.tencent.mobileqq.guild.discover.b.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(iconIv, "iconIv");
                String iconUrl = guildLiveTipsContentItem.getIconUrl();
                int i3 = N;
                b.Companion.f(companion, iconIv, iconUrl, i3, i3, null, 16, null);
            }
        }
    }

    private final ViewGroup yh() {
        return (ViewGroup) this.itemContainer.getValue();
    }

    private final TextView zh() {
        return (TextView) this.startView.getValue();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.f174032aw0;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ex9, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
        this.rootView = inflate;
        Dh();
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        Jh(view);
        Ih();
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ((ViewGroup) view.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        view2.getRootView().findViewById(tp1.a.c()).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildLiveReadyTipsDialog.Hh(GuildLiveReadyTipsDialog.this, view4);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViews();
        initData();
    }
}
