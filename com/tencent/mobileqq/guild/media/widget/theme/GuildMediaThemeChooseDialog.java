package com.tencent.mobileqq.guild.media.widget.theme;

import android.app.Dialog;
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
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelMiniContainerUtil;
import com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper;
import com.tencent.mobileqq.guild.media.core.notify.ad;
import com.tencent.mobileqq.guild.media.core.notify.t;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.listen.ListenPlugin;
import com.tencent.mobileqq.guild.media.z;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.ContainerLoadParams;
import com.tencent.mobileqq.mini.api.IContainerPageNavigator;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.api.IMiniLoadCallback;
import com.tencent.mobileqq.mini.api.MiniContainerHolder;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelToolBar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.container.core.MiniView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0003NRV\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J$\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010 \u001a\u00020\u0002J\u001a\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010=\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u00106R$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\b0>j\b\u0012\u0004\u0012\u00020\b`?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "Eh", "Lh", "", "path", "Jh", "Lcom/tencent/mobileqq/mini/api/MiniContainerHolder;", "miniViewContainer", "Kh", "Hh", "initView", "initData", "Dh", "Ch", "Bh", "Lcom/tencent/mobileqq/mini/api/ContainerLoadParams;", "xh", "", "Gh", "Landroid/view/View;", "sheetView", "Ih", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onCreate", "wh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/guild/media/widget/theme/GuildThemeMiniViewHandler;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/widget/theme/GuildThemeMiniViewHandler;", "mThemeChooseHandler", "D", "Landroid/view/ViewGroup;", "mRootView", "Landroid/widget/FrameLayout;", "E", "Lkotlin/Lazy;", "Ah", "()Landroid/widget/FrameLayout;", "mMiniViewRoot", UserInfo.SEX_FEMALE, "Z", "mFromDragBar", "G", OcrConfig.CHINESE, "mDragBarView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "mMiniContainerList", "I", "Lcom/tencent/mobileqq/mini/api/ContainerLoadParams;", "loadParams", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "J", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "K", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBottomSheetBehavior", "com/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$d", "L", "Lcom/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$d;", "mMiniContainerNavCallback", "com/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$a", "M", "Lcom/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$a;", "dialogCloseEvent", "com/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$c", "N", "Lcom/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$c;", "mBottomSheetCallback", "<init>", "()V", "P", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaThemeChooseDialog extends BottomSheetDialogFragment {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private GuildThemeMiniViewHandler mThemeChooseHandler;

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
    @NotNull
    private final ArrayList<MiniContainerHolder> mMiniContainerList;

    /* renamed from: I, reason: from kotlin metadata */
    private ContainerLoadParams loadParams;

    /* renamed from: J, reason: from kotlin metadata */
    private y mAudioRoomObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private BottomSheetBehavior<View> mBottomSheetBehavior;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final d mMiniContainerNavCallback;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final a dialogCloseEvent;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final c mBottomSheetCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$Companion;", "", "", "startIndex", "Lcom/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog;", "d", "c", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "tag", "", "e", "Landroid/os/Bundle;", "bundle", "b", "MINI_FRAGMENT_PACKAGE", "Ljava/lang/String;", "MINI_PATH", "START_INDEX", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String c() {
            boolean mIsForbiddenPushReceived = com.tencent.mobileqq.guild.media.core.j.a().X().getMIsForbiddenPushReceived();
            if (mIsForbiddenPushReceived) {
                return "true";
            }
            if (!mIsForbiddenPushReceived) {
                return "false";
            }
            throw new NoWhenBranchMatchedException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GuildMediaThemeChooseDialog d(String startIndex) {
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).addExternalPlugin(ListenPlugin.class);
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).addExternalPlugin(PlayTogetherMiniAppPlugin.class);
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog = new GuildMediaThemeChooseDialog();
            Bundle bundle = new Bundle();
            bundle.putString("START_INDEX", startIndex);
            guildMediaThemeChooseDialog.setArguments(bundle);
            return guildMediaThemeChooseDialog;
        }

        @NotNull
        public final String b(@Nullable Bundle bundle) {
            String str;
            String str2;
            IGProChannelToolBar U = com.tencent.mobileqq.guild.media.core.j.c().U();
            String str3 = null;
            if (U != null) {
                str = U.getToolbarListStr();
            } else {
                str = null;
            }
            Uri.Builder appendQueryParameter = Uri.parse("10000-pages-together/index/index.html").buildUpon().appendQueryParameter(INetChannelCallback.KEY_TINY_ID, com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a).appendQueryParameter("guild_id", com.tencent.mobileqq.guild.media.core.j.a().getGuildID()).appendQueryParameter("channel_id", com.tencent.mobileqq.guild.media.core.j.a().E()).appendQueryParameter("tab_msg", str).appendQueryParameter("native_disable_share", c()).appendQueryParameter("from", "voiceChannel").appendQueryParameter("auth_meta", com.tencent.mobileqq.guild.media.core.j.c().b());
            IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
            if (channelInfo != null) {
                str2 = channelInfo.getChannelName();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("channel_name", str2).appendQueryParameter("user_type", String.valueOf(z.h(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()))).appendQueryParameter("start_permission", String.valueOf(GuildMediaUtils.k(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()) ? 1 : 0));
            if (bundle != null) {
                str3 = bundle.getString("START_INDEX", "");
            }
            String builder = appendQueryParameter2.appendQueryParameter("start_index", str3).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "parse(MINI_PATH).buildUp\u2026              .toString()");
            return builder;
        }

        public final void e(@Nullable final String startIndex, @NotNull final FragmentManager fragmentManager, @Nullable final String tag) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            MediaChannelMiniContainerUtil.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.theme.GuildMediaThemeChooseDialog$Companion$safeOpenWithX5Init$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildMediaThemeChooseDialog d16;
                    d16 = GuildMediaThemeChooseDialog.INSTANCE.d(startIndex);
                    com.tencent.mobileqq.guild.base.extension.d.a(d16, fragmentManager, tag);
                }
            });
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$a", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ad;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.media.core.notify.o<ad> {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ad event) {
            boolean z16;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getFrom() > 0) {
                GuildMediaThemeChooseDialog.this.dismissAllowingStateLoss();
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if ((qBaseActivity instanceof QPublicFragmentActivity) && Intrinsics.areEqual("com.tencent.mobileqq.mini.activity.MiniContainerPageFragment", ((QPublicFragmentActivity) qBaseActivity).getFragment().getClass().getName())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.d("QGMC.GuildMediaThemeChooseDialog", 1, "dismiss MiniContainerPageFragment: " + z16);
                if (z16) {
                    qBaseActivity.doOnBackPressed();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "action", "", "l", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void b() {
            QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[onForceStopScreenSharePushed] ");
            GuildMediaThemeChooseDialog.this.dismissAllowingStateLoss();
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void l(@Nullable String action) {
            GuildThemeMiniViewHandler guildThemeMiniViewHandler = GuildMediaThemeChooseDialog.this.mThemeChooseHandler;
            if (guildThemeMiniViewHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mThemeChooseHandler");
                guildThemeMiniViewHandler = null;
            }
            guildThemeMiniViewHandler.i(action);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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
            if (newState == 1 && !GuildMediaThemeChooseDialog.this.mFromDragBar && (bottomSheetBehavior = GuildMediaThemeChooseDialog.this.mBottomSheetBehavior) != null) {
                bottomSheetBehavior.setState(3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog$d", "Lcom/tencent/mobileqq/mini/api/IContainerPageNavigator;", "", "path", "", "navigateTo", "navigateBack", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements IContainerPageNavigator {
        d() {
        }

        @Override // com.tencent.mobileqq.mini.api.IContainerPageNavigator
        public boolean navigateBack() {
            QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[navigateBack]");
            GuildMediaThemeChooseDialog.this.wh();
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
            QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[navigateTo] path: " + path);
            if (path != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(path);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        GuildMediaThemeChooseDialog.this.Jh(path);
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

    public GuildMediaThemeChooseDialog() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.guild.media.widget.theme.GuildMediaThemeChooseDialog$mMiniViewRoot$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                ViewGroup viewGroup;
                viewGroup = GuildMediaThemeChooseDialog.this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup = null;
                }
                return (FrameLayout) viewGroup.findViewById(R.id.f166285zb0);
            }
        });
        this.mMiniViewRoot = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.guild.media.widget.theme.GuildMediaThemeChooseDialog$mDragBarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                ViewGroup viewGroup;
                viewGroup = GuildMediaThemeChooseDialog.this.mRootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    viewGroup = null;
                }
                return (FrameLayout) viewGroup.findViewById(R.id.f165708xb0);
            }
        });
        this.mDragBarView = lazy2;
        this.mMiniContainerList = new ArrayList<>();
        this.mMiniContainerNavCallback = new d();
        this.dialogCloseEvent = new a();
        this.mBottomSheetCallback = new c();
    }

    private final FrameLayout Ah() {
        Object value = this.mMiniViewRoot.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mMiniViewRoot>(...)");
        return (FrameLayout) value;
    }

    private final void Bh() {
        ViewGroup viewGroup;
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(requireContext());
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        aVar.getBehavior().setPeekHeight(instantScreenHeight);
        Window window = aVar.getWindow();
        if (window != null && (viewGroup = (ViewGroup) window.findViewById(R.id.ugk)) != null) {
            viewGroup.setBackgroundResource(17170445);
            Ih(viewGroup);
        }
    }

    private final void Ch() {
        int lastIndex;
        ArrayList<MiniContainerHolder> arrayList = this.mMiniContainerList;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        View view = arrayList.get(lastIndex).getView();
        view.setBackgroundColor(0);
        Ah().addView(view, -1, new ViewGroup.LayoutParams(-1, (int) (ScreenUtil.getInstantScreenHeight(requireContext()) * 0.85714287f)));
        view.setNestedScrollingEnabled(false);
    }

    private final void Dh() {
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).setContainerNavigator(this.mMiniContainerNavCallback);
    }

    private final void Eh() {
        this.mAudioRoomObserver = new b();
        AudioNotifyHelper l06 = com.tencent.mobileqq.guild.media.core.j.a().l0();
        y yVar = this.mAudioRoomObserver;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioRoomObserver");
            yVar = null;
        }
        l06.b(yVar);
        com.tencent.mobileqq.guild.media.core.j.d().V(ad.class, this.dialogCloseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Fh(GuildMediaThemeChooseDialog this$0, View view, MotionEvent motionEvent) {
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

    private final boolean Gh() {
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

    private final void Hh() {
        QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[reloadAllMiniView] start");
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).reloadAllMiniContainer();
    }

    private final void Ih(View sheetView) {
        if (this.mBottomSheetBehavior == null) {
            this.mBottomSheetBehavior = BottomSheetBehavior.from(sheetView);
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.addBottomSheetCallback(this.mBottomSheetCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(String path) {
        if (Gh()) {
            return;
        }
        IMiniContainer iMiniContainer = (IMiniContainer) QRoute.api(IMiniContainer.class);
        FragmentActivity activity = getActivity();
        ContainerLoadParams containerLoadParams = this.loadParams;
        if (containerLoadParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadParams");
            containerLoadParams = null;
        }
        MiniContainerHolder miniViewContainer = iMiniContainer.load(activity, this, path, containerLoadParams);
        Intrinsics.checkNotNullExpressionValue(miniViewContainer, "miniViewContainer");
        Kh(miniViewContainer);
    }

    private final void Kh(MiniContainerHolder miniViewContainer) {
        this.mMiniContainerList.add(miniViewContainer);
        Ch();
    }

    private final void Lh() {
        com.tencent.mobileqq.guild.media.core.j.d().j(ad.class, this.dialogCloseEvent);
        AudioNotifyHelper l06 = com.tencent.mobileqq.guild.media.core.j.a().l0();
        y yVar = this.mAudioRoomObserver;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioRoomObserver");
            yVar = null;
        }
        l06.B(yVar);
    }

    private final void initData() {
        com.tencent.mobileqq.guild.media.core.j.a().W().e(false);
    }

    private final void initView() {
        zh().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Fh;
                Fh = GuildMediaThemeChooseDialog.Fh(GuildMediaThemeChooseDialog.this, view, motionEvent);
                return Fh;
            }
        });
    }

    private final ContainerLoadParams xh() {
        ContainerLoadParams loadingCallback = new ContainerLoadParams().setAddDefaultRetryView(false).setAddDefaultLoadingView(false).setForceDefaultUIDarkMode(true).setLoadingCallback(new IMiniLoadCallback() { // from class: com.tencent.mobileqq.guild.media.widget.theme.a
            @Override // com.tencent.mobileqq.mini.api.IMiniLoadCallback
            public final void onLoaded(int i3, String str) {
                GuildMediaThemeChooseDialog.yh(i3, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(loadingCallback, "ContainerLoadParams()\n  \u2026ssage\")\n                }");
        return loadingCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(int i3, String str) {
        QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[onLoaded] result: code: " + i3 + ", msg: " + str);
    }

    private final FrameLayout zh() {
        Object value = this.mDragBarView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDragBarView>(...)");
        return (FrameLayout) value;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Hh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Eh();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ez5, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mRootView = (ViewGroup) inflate;
        com.tencent.mobileqq.guild.media.core.j.a().M0().V0(System.currentTimeMillis());
        this.loadParams = xh();
        String b16 = INSTANCE.b(getArguments());
        QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[onCreateView] path: " + b16);
        Jh(b16);
        this.mThemeChooseHandler = new GuildThemeMiniViewHandler(new WeakReference(this));
        initView();
        initData();
        Dh();
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
        Lh();
        int size = this.mMiniContainerList.size();
        for (int i3 = 0; i3 < size; i3++) {
            wh();
        }
        com.tencent.mobileqq.guild.media.core.j.d().i(new t());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.removeBottomSheetCallback(this.mBottomSheetCallback);
        }
        this.mBottomSheetBehavior = null;
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).setContainerNavigator(null);
        super.onDismiss(dialog);
        QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[onDismiss] ");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Bh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        QLog.d("QGMC.GuildMediaThemeChooseDialog", 4, "[onViewCreated] ");
    }

    public final void wh() {
        int lastIndex;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.mMiniContainerList);
        if (lastIndex < 0) {
            return;
        }
        Ah().removeViewAt(lastIndex);
        View view = this.mMiniContainerList.remove(lastIndex).getView();
        if (view instanceof MiniView) {
            ((MiniView) view).onDestroy();
        }
        if (this.mMiniContainerList.isEmpty()) {
            QLog.i("QGMC.GuildMediaThemeChooseDialog", 1, "[clearLastMiniView] empty, dismiss dialog");
            dismissAllowingStateLoss();
        }
    }
}
