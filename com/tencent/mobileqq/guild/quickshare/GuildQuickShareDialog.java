package com.tencent.mobileqq.guild.quickshare;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.quickshare.GuildQuickShareDialog;
import com.tencent.mobileqq.guild.quickshare.GuildQuickShareHandler;
import com.tencent.mobileqq.guild.quickshare.a;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000e\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002TUB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010*\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010#R\u0016\u00104\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010#R\u0016\u00106\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010#R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010#R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "Landroid/os/Handler$Callback;", "", "initData", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Ah", "updateTheme", "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog$b;", "xh", "com/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog$c", "yh", "()Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog$c;", "wh", "Bh", "Dh", "Ch", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/View;", "onCreateView", "onResume", "v", NodeProps.ON_CLICK, "Landroid/os/Message;", "msg", "", "handleMessage", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "D", "contentView", "E", "splitLine", UserInfo.SEX_FEMALE, "moreShareBg", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "tipsView", "H", "moreShareTips", "I", "closeButton", "J", "closeContainer", "K", "moreShareButton", "Landroidx/recyclerview/widget/RecyclerView;", "L", "Landroidx/recyclerview/widget/RecyclerView;", "recentUsersRv", "M", "bottomTransparentView", "Lcom/tencent/mobileqq/guild/quickshare/a;", "N", "Lcom/tencent/mobileqq/guild/quickshare/a;", "adapter", "Lcom/tencent/mobileqq/guild/quickshare/ShareParam;", "P", "Lcom/tencent/mobileqq/guild/quickshare/ShareParam;", "shareParam", "Lcom/tencent/mobileqq/guild/quickshare/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/quickshare/d;", "viewModel", "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$b;", "shareCallback", "Lcom/tencent/util/WeakReferenceHandler;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/util/WeakReferenceHandler;", "handler", "<init>", "()V", "T", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildQuickShareDialog extends BottomSheetDialogFragment implements View.OnClickListener, Handler.Callback {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private View contentView;

    /* renamed from: E, reason: from kotlin metadata */
    private View splitLine;

    /* renamed from: F, reason: from kotlin metadata */
    private View moreShareBg;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tipsView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView moreShareTips;

    /* renamed from: I, reason: from kotlin metadata */
    private View closeButton;

    /* renamed from: J, reason: from kotlin metadata */
    private View closeContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private View moreShareButton;

    /* renamed from: L, reason: from kotlin metadata */
    private RecyclerView recentUsersRv;

    /* renamed from: M, reason: from kotlin metadata */
    private View bottomTransparentView;

    /* renamed from: N, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: P, reason: from kotlin metadata */
    private ShareParam shareParam;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.quickshare.d viewModel;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final GuildQuickShareHandler.b shareCallback = yh();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final WeakReferenceHandler handler = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "Lcom/tencent/mobileqq/guild/quickshare/ShareParam;", "shareParam", "", "a", "", "AUTO_DISMISS_TIME_MS", "J", "", "MSG_AUTO_DISMISS", "I", "", "SHARE_PARAM", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quickshare.GuildQuickShareDialog$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager manager, @NotNull ShareParam shareParam) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(shareParam, "shareParam");
            GuildQuickShareDialog guildQuickShareDialog = new GuildQuickShareDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("SHARE_PARAM", shareParam);
            guildQuickShareDialog.setArguments(bundle);
            com.tencent.mobileqq.guild.base.extension.d.a(guildQuickShareDialog, manager, "Guild.share.GuildQuickShare.dialog");
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog$b;", "Lcom/tencent/mobileqq/guild/quickshare/a$b;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", QCircleAlphaUserReporter.KEY_USER, "", "a", "", "uin", "headPath", "Landroid/graphics/Bitmap;", "head", h.F, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog;", "Lmqq/util/WeakReference;", "guildQuickShareDialogRef", "guildQuickShareDialog", "<init>", "(Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements a.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<GuildQuickShareDialog> guildQuickShareDialogRef;

        public b(@NotNull GuildQuickShareDialog guildQuickShareDialog) {
            Intrinsics.checkNotNullParameter(guildQuickShareDialog, "guildQuickShareDialog");
            this.guildQuickShareDialogRef = new WeakReference<>(guildQuickShareDialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, String uin, Bitmap head) {
            Unit unit;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(uin, "$uin");
            Intrinsics.checkNotNullParameter(head, "$head");
            GuildQuickShareDialog guildQuickShareDialog = this$0.guildQuickShareDialogRef.get();
            if (guildQuickShareDialog != null) {
                RecyclerView recyclerView = guildQuickShareDialog.recentUsersRv;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentUsersRv");
                    recyclerView = null;
                }
                int childCount = recyclerView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    RecyclerView recyclerView2 = guildQuickShareDialog.recentUsersRv;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentUsersRv");
                        recyclerView2 = null;
                    }
                    RecyclerView recyclerView3 = guildQuickShareDialog.recentUsersRv;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentUsersRv");
                        recyclerView3 = null;
                    }
                    RecyclerView.ViewHolder childViewHolder = recyclerView2.getChildViewHolder(recyclerView3.getChildAt(i3));
                    if (childViewHolder instanceof a.d) {
                        GuildUserAvatarView avatarView = ((a.d) childViewHolder).getAvatarView();
                        if (avatarView != null) {
                            if (Intrinsics.areEqual(uin, avatarView.getTag())) {
                                avatarView.setImageBitmap(head);
                                avatarView.requestLayout();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            Logger logger = Logger.f235387a;
                            if (QLog.isDebugVersion()) {
                                logger.d().d("Guild.share.GuildQuickShare.dialog", 1, "onFaceUpdate holder.avatarView null uin:" + uin);
                            }
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.quickshare.a.b
        public void a(@NotNull View v3, @NotNull GuildRecentUser user) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(user, "user");
            GuildQuickShareDialog guildQuickShareDialog = this.guildQuickShareDialogRef.get();
            if (guildQuickShareDialog != null) {
                guildQuickShareDialog.wh();
                if (guildQuickShareDialog.getActivity() != null) {
                    FragmentActivity requireActivity = guildQuickShareDialog.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "dialog.requireActivity()");
                    ShareParam shareParam = guildQuickShareDialog.shareParam;
                    if (shareParam == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareParam");
                        shareParam = null;
                    }
                    GuildQuickShareHandler guildQuickShareHandler = new GuildQuickShareHandler(requireActivity, shareParam, user);
                    Logger logger = Logger.f235387a;
                    if (QLog.isDebugVersion()) {
                        logger.d().d("Guild.share.GuildQuickShare.dialog", 1, "share user:" + user);
                    }
                    guildQuickShareHandler.n(guildQuickShareDialog.shareCallback);
                    guildQuickShareHandler.o();
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.quickshare.a.b
        public void h(@NotNull final String uin, @NotNull String headPath, @NotNull final Bitmap head) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(headPath, "headPath");
            Intrinsics.checkNotNullParameter(head, "head");
            if (this.guildQuickShareDialogRef.get() == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.quickshare.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildQuickShareDialog.b.c(GuildQuickShareDialog.b.this, uin, head);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog$c", "Lcom/tencent/mobileqq/guild/quickshare/GuildQuickShareHandler$b;", "", "isOpenShareConfirmSuccess", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements GuildQuickShareHandler.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.quickshare.GuildQuickShareHandler.b
        public void onResult(boolean isOpenShareConfirmSuccess) {
            Logger.f235387a.d().i("Guild.share.GuildQuickShare.dialog", 1, "isOpenShareConfirmSuccess\uff1a" + isOpenShareConfirmSuccess);
            if (!isOpenShareConfirmSuccess) {
                GuildQuickShareDialog.this.Bh();
            } else {
                GuildQuickShareDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/quickshare/GuildQuickShareDialog$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                GuildQuickShareDialog.this.Bh();
            } else if (newState == 1) {
                GuildQuickShareDialog.this.wh();
            }
        }
    }

    private final void Ah(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.f3l, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026_share_dialog, container)");
        this.rootView = inflate;
        RecyclerView recyclerView = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content)");
        this.contentView = findViewById;
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.t1u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.avatar_split_line)");
        this.splitLine = findViewById2;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.jmp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tips)");
        this.tipsView = (TextView) findViewById3;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.az7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.close_btn)");
        this.closeButton = findViewById4;
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.ld_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.close_container)");
        this.closeContainer = findViewById5;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById6 = view5.findViewById(R.id.f166322zf3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.more_share_bg)");
        this.moreShareBg = findViewById6;
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view6 = null;
        }
        View findViewById7 = view6.findViewById(R.id.f166323zf4);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.more_share_btn)");
        this.moreShareButton = findViewById7;
        View view7 = this.rootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view7 = null;
        }
        View findViewById8 = view7.findViewById(R.id.zf5);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.more_share_tips)");
        this.moreShareTips = (TextView) findViewById8;
        View view8 = this.rootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view8 = null;
        }
        View findViewById9 = view8.findViewById(R.id.f70943mt);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.recent_users)");
        this.recentUsersRv = (RecyclerView) findViewById9;
        View view9 = this.rootView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view9 = null;
        }
        View findViewById10 = view9.findViewById(R.id.tb_);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.\u2026.bottom_transparent_view)");
        this.bottomTransparentView = findViewById10;
        TextView textView = this.tipsView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            textView = null;
        }
        ShareParam shareParam = this.shareParam;
        if (shareParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam = null;
        }
        textView.setText(shareParam.getDialogTips());
        View view10 = this.moreShareBg;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreShareBg");
            view10 = null;
        }
        view10.setOnClickListener(this);
        View view11 = this.closeContainer;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeContainer");
            view11 = null;
        }
        view11.setOnClickListener(this);
        View view12 = this.bottomTransparentView;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTransparentView");
            view12 = null;
        }
        view12.setOnClickListener(this);
        RecyclerView recyclerView2 = this.recentUsersRv;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentUsersRv");
            recyclerView2 = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView2.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.recentUsersRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentUsersRv");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new a.c());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ShareParam shareParam2 = this.shareParam;
        if (shareParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam2 = null;
        }
        this.adapter = new a(requireContext, shareParam2.getDialogTheme().getUserNameColor(), xh());
        RecyclerView recyclerView4 = this.recentUsersRv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentUsersRv");
            recyclerView4 = null;
        }
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        recyclerView4.setAdapter(aVar);
        RecyclerView recyclerView5 = this.recentUsersRv;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentUsersRv");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView.addOnScrollListener(new d());
        updateTheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.share.GuildQuickShare.dialog", 1, "openDelayDismiss");
        }
        if (this.handler.hasMessages(10000)) {
            this.handler.removeMessages(10000);
        }
        this.handler.sendEmptyMessageDelayed(10000, 5000L);
    }

    private final void Ch() {
        Map emptyMap;
        Map emptyMap2;
        View view = this.moreShareBg;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreShareBg");
            view = null;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        ch.W0(view, "em_sgrp_left_invite_button", emptyMap);
        View view3 = this.closeContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeContainer");
        } else {
            view2 = view3;
        }
        emptyMap2 = MapsKt__MapsKt.emptyMap();
        ch.W0(view2, "em_sgrp_upper_right_close_button", emptyMap2);
    }

    private final void Dh() {
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_quickly_share_layer");
        ShareParam shareParam = this.shareParam;
        if (shareParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam = null;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_trigger_scene", Integer.valueOf(shareParam.getTriggerScene().getValue())));
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        VideoReport.setPageParams(view2, new PageParams((Map<String, ?>) mapOf));
    }

    private final void initData() {
        Serializable serializable;
        Bundle arguments = getArguments();
        com.tencent.mobileqq.guild.quickshare.d dVar = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("SHARE_PARAM");
        } else {
            serializable = null;
        }
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.quickshare.ShareParam");
        this.shareParam = (ShareParam) serializable;
        com.tencent.mobileqq.guild.quickshare.d dVar2 = (com.tencent.mobileqq.guild.quickshare.d) ef1.c.INSTANCE.c(this, com.tencent.mobileqq.guild.quickshare.d.class, new Function0<com.tencent.mobileqq.guild.quickshare.d>() { // from class: com.tencent.mobileqq.guild.quickshare.GuildQuickShareDialog$initData$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                return new d();
            }
        });
        this.viewModel = dVar2;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            dVar = dVar2;
        }
        MutableLiveData<List<GuildRecentUser>> O1 = dVar.O1();
        final Function1<List<? extends GuildRecentUser>, Unit> function1 = new Function1<List<? extends GuildRecentUser>, Unit>() { // from class: com.tencent.mobileqq.guild.quickshare.GuildQuickShareDialog$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildRecentUser> list) {
                invoke2((List<GuildRecentUser>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<GuildRecentUser> it) {
                a aVar;
                Logger logger = Logger.f235387a;
                if (QLog.isDebugVersion()) {
                    logger.d().d("Guild.share.GuildQuickShare.dialog", 1, "recentUserLiveData size:" + it.size());
                }
                aVar = GuildQuickShareDialog.this.adapter;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    aVar = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.setData(it);
            }
        };
        O1.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.quickshare.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQuickShareDialog.zh(Function1.this, obj);
            }
        });
    }

    private final void updateTheme() {
        View view = this.contentView;
        ShareParam shareParam = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        ShareParam shareParam2 = this.shareParam;
        if (shareParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam2 = null;
        }
        view.setBackgroundResource(shareParam2.getDialogTheme().getBackgroundRes());
        View view2 = this.splitLine;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splitLine");
            view2 = null;
        }
        ShareParam shareParam3 = this.shareParam;
        if (shareParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam3 = null;
        }
        view2.setBackgroundResource(shareParam3.getDialogTheme().getSplitLineBg());
        View view3 = this.moreShareBg;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreShareBg");
            view3 = null;
        }
        ShareParam shareParam4 = this.shareParam;
        if (shareParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam4 = null;
        }
        view3.setBackgroundResource(shareParam4.getDialogTheme().getMoreShareBg());
        TextView textView = this.tipsView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            textView = null;
        }
        Resources resources = getResources();
        ShareParam shareParam5 = this.shareParam;
        if (shareParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam5 = null;
        }
        textView.setTextColor(resources.getColor(shareParam5.getDialogTheme().getTipsColor()));
        TextView textView2 = this.moreShareTips;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreShareTips");
            textView2 = null;
        }
        Resources resources2 = getResources();
        ShareParam shareParam6 = this.shareParam;
        if (shareParam6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam6 = null;
        }
        textView2.setTextColor(resources2.getColor(shareParam6.getDialogTheme().getUserNameColor()));
        View view4 = this.closeButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            view4 = null;
        }
        ShareParam shareParam7 = this.shareParam;
        if (shareParam7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
            shareParam7 = null;
        }
        view4.setBackgroundResource(shareParam7.getDialogTheme().getCloseIconRes());
        View view5 = this.moreShareButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreShareButton");
            view5 = null;
        }
        ShareParam shareParam8 = this.shareParam;
        if (shareParam8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareParam");
        } else {
            shareParam = shareParam8;
        }
        view5.setBackgroundResource(shareParam.getDialogTheme().getMoreShareRes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh() {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.share.GuildQuickShare.dialog", 1, "cancelDelayDismiss");
        }
        if (this.handler.hasMessages(10000)) {
            this.handler.removeMessages(10000);
        }
    }

    private final b xh() {
        return new b(this);
    }

    private final c yh() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 10000) {
            dismissAllowingStateLoss();
            Logger.f235387a.d().i("Guild.share.GuildQuickShare.dialog", 1, "auto dismiss");
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View] */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        View view = this.closeContainer;
        ShareParam shareParam = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeContainer");
            view = null;
        }
        if (Intrinsics.areEqual(v3, view)) {
            if (!o.c("fastClickGuard")) {
                dismissAllowingStateLoss();
            }
        } else {
            View view2 = this.moreShareBg;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreShareBg");
                view2 = null;
            }
            if (Intrinsics.areEqual(v3, view2)) {
                if (!o.c("fastClickGuard")) {
                    FragmentActivity requireActivity = requireActivity();
                    ShareParam shareParam2 = this.shareParam;
                    if (shareParam2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareParam");
                        shareParam2 = null;
                    }
                    IGProGuildInfo guildInfo = shareParam2.getGuildInfo();
                    ShareParam shareParam3 = this.shareParam;
                    if (shareParam3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareParam");
                        shareParam3 = null;
                    }
                    IGProChannelInfo channelInfo = shareParam3.getChannelInfo();
                    ShareParam shareParam4 = this.shareParam;
                    if (shareParam4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareParam");
                    } else {
                        shareParam = shareParam4;
                    }
                    new m(requireActivity, guildInfo, channelInfo, shareParam.getSource()).z();
                    dismissAllowingStateLoss();
                }
            } else {
                ?? r06 = this.bottomTransparentView;
                if (r06 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTransparentView");
                } else {
                    shareParam = r06;
                }
                if (Intrinsics.areEqual(v3, shareParam) && !o.c("fastClickGuard")) {
                    dismissAllowingStateLoss();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.clearFlags(2);
        aVar.getBehavior().setDraggable(false);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        initData();
        Ah(inflater, container);
        Dh();
        Ch();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.rootView;
        ViewGroup viewGroup = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
        Bh();
    }
}
