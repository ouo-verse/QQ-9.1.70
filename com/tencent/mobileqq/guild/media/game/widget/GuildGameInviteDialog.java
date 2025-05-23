package com.tencent.mobileqq.guild.media.game.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bt1.RoomAuthParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.IGuildClientAuthApi;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.aj;
import com.tencent.mobileqq.guild.media.game.widget.GuildGameInviteDialog;
import com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs1.GuildAuthGameBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 92\u00020\u0001:\u0004@ABCB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J$\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u000bR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "scale", "Landroid/view/View;", "Fh", "", ZPlanPublishSource.FROM_SCHEME, "from", "", "Qh", "Rh", "Ph", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Hh", "Ih", "Sh", "Th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", DKHippyEvent.EVENT_STOP, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", "initView", "Jh", "Lbt1/h;", BdhLogUtil.LogTag.Tag_Conn, "Lbt1/h;", "roomViewModel", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$b;", "D", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$b;", "adapter", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "enterBtn", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "memberContainer", "", "G", "Z", "enterBtnClick", "", "H", "J", "exposureStart", "I", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "()V", "a", "b", "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGameInviteDialog extends ReportAndroidXDialogFragment {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static float K = 1.0f;

    /* renamed from: C, reason: from kotlin metadata */
    private bt1.h roomViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private b adapter;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView enterBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView memberContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean enterBtnClick;

    /* renamed from: H, reason: from kotlin metadata */
    private long exposureStart;

    /* renamed from: I, reason: from kotlin metadata */
    private View rootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$a;", "", "Landroid/content/Context;", "context", "", "mode", "", "scale", "Landroid/view/View;", "c", "dp", "d", "", "ENTER_BUTTON_BG", "Ljava/lang/String;", "ROOT_BG", "SEAT_WAIT", "STATE_OK", "I", "STATE_UNBIND_SMOBA_ACCOUNT", "TAG", UserInfo.SEX_FEMALE, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.game.widget.GuildGameInviteDialog$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View c(Context context, int mode, float scale) {
            float f16;
            if (mode == 2) {
                f16 = 63.0f;
            } else {
                f16 = 108.0f;
            }
            ConstraintLayout constraintLayout = new ConstraintLayout(context);
            constraintLayout.setId(R.id.wgp);
            constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(d(f16, scale), -1));
            constraintLayout.setBackgroundResource(R.drawable.guild_game_invite_member_bg);
            constraintLayout.setClipChildren(false);
            GuildWavAvatarImageView guildWavAvatarImageView = new GuildWavAvatarImageView(context, null);
            guildWavAvatarImageView.setImageWidth((int) (43 * scale));
            guildWavAvatarImageView.setId(R.id.wgm);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(d(43.0f, scale), d(43.0f, scale));
            layoutParams.endToEnd = R.id.wgp;
            layoutParams.startToStart = R.id.wgp;
            layoutParams.topToTop = R.id.wgp;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = d(11.0f, scale);
            guildWavAvatarImageView.setLayoutParams(layoutParams);
            constraintLayout.addView(guildWavAvatarImageView);
            ImageView imageView = new ImageView(context);
            imageView.setId(R.id.f165529wh4);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(d(20.0f, scale), d(20.0f, scale));
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = d(23.0f, scale);
            layoutParams2.startToStart = R.id.wgp;
            layoutParams2.endToEnd = R.id.wgp;
            layoutParams2.topToTop = R.id.wgp;
            imageView.setLayoutParams(layoutParams2);
            imageView.setImageResource(R.drawable.guild_game_invite_wait);
            constraintLayout.addView(imageView);
            TextView textView = new TextView(context);
            textView.setGravity(1);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setId(R.id.wgn);
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(d(48.0f, scale), -2);
            layoutParams3.startToStart = R.id.wgp;
            layoutParams3.endToEnd = R.id.wgp;
            layoutParams3.topToBottom = R.id.wgm;
            ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = d(8.0f, scale);
            textView.setLayoutParams(layoutParams3);
            textView.setTextSize(12.0f * scale);
            constraintLayout.addView(textView);
            TextView textView2 = new TextView(context);
            textView2.setId(R.id.wgo);
            ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams4.startToStart = R.id.wgp;
            layoutParams4.endToEnd = R.id.wgp;
            layoutParams4.topToBottom = R.id.wgn;
            ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = d(8.0f, scale);
            textView2.setLayoutParams(layoutParams4);
            textView2.setTextSize(scale * 11.0f);
            textView2.setTextColor(Color.parseColor("#80FFFFFF"));
            constraintLayout.addView(textView2);
            return constraintLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(float dp5, float scale) {
            return (int) (ViewUtils.dip2px(dp5) * scale);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\f\b\u0002\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\r\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$d;", "", "", "dataList", "", "setData", "tinyId", "j0", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "l0", "getItemCount", "Lbt1/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbt1/h;", "roomViewModel", BdhLogUtil.LogTag.Tag_Conn, "I", "mode", "", "D", "Ljava/util/List;", "memberDataList", "E", "itemCount", UserInfo.SEX_FEMALE, "validSize", "<init>", "(Lbt1/h;I)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.Adapter<d> {

        /* renamed from: C, reason: from kotlin metadata */
        private int mode;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private List<Long> memberDataList;

        /* renamed from: E, reason: from kotlin metadata */
        private int itemCount;

        /* renamed from: F, reason: from kotlin metadata */
        private int validSize;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private bt1.h roomViewModel;

        public b(@NotNull bt1.h roomViewModel, int i3) {
            int i16;
            List<Long> list;
            Intrinsics.checkNotNullParameter(roomViewModel, "roomViewModel");
            this.roomViewModel = roomViewModel;
            this.mode = i3;
            this.memberDataList = new ArrayList();
            if (this.mode == 1) {
                i16 = 3;
            } else {
                i16 = 5;
            }
            this.itemCount = i16;
            list = CollectionsKt___CollectionsKt.toList(this.roomViewModel.e2().b());
            setData(list);
            int size = this.memberDataList.size();
            this.validSize = size;
            int i17 = this.itemCount - size;
            while (true) {
                int i18 = i17 - 1;
                if (i17 > 0) {
                    this.memberDataList.add(-1L);
                    i17 = i18;
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m0(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this$0.roomViewModel.T1(new RoomAuthParams(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()), com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c()), 101, true, 1));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.itemCount;
        }

        public final void j0(long tinyId) {
            int i3 = this.validSize;
            if (i3 == this.itemCount) {
                return;
            }
            this.memberDataList.set(i3, Long.valueOf(tinyId));
            notifyItemChanged(this.validSize);
            this.validSize++;
        }

        public final void k0(long tinyId) {
            int indexOf = this.memberDataList.indexOf(Long.valueOf(tinyId));
            if (indexOf == -1) {
                return;
            }
            this.memberDataList.remove(indexOf);
            this.validSize--;
            notifyItemRemoved(indexOf);
            this.memberDataList.add(-1L);
            notifyItemInserted(this.itemCount - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            String str;
            Integer num;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (this.memberDataList.get(position).longValue() == -1) {
                holder.getMemberNickname().setText("\u5f85\u52a0\u5165");
                holder.getMemberNickname().setTextColor(Color.parseColor("#80FFFFFF"));
                holder.getMemberRank().setVisibility(8);
                GuildWavAvatarImageView memberAvatar = holder.getMemberAvatar();
                memberAvatar.setBackground(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("GuildGameInviteDialog", "https://downv6.qq.com/innovate/guild/media_game/guild_game_seat_loading.png", new ApngOptions()));
                memberAvatar.setIdentityView(-1);
                holder.getMemberWaitIcon().setVisibility(0);
                holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildGameInviteDialog.b.m0(GuildGameInviteDialog.b.this, view);
                    }
                });
                return;
            }
            holder.getMemberRank().setVisibility(0);
            holder.getMemberWaitIcon().setVisibility(8);
            holder.getMemberNickname().setText(ch.H(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.guild.media.core.m.d(this.roomViewModel.getMediaChannelDataHub()), String.valueOf(this.memberDataList.get(position).longValue())));
            holder.getMemberNickname().setTextColor(-1);
            TextView memberRank = holder.getMemberRank();
            com.tencent.mobileqq.guild.media.core.data.q s26 = this.roomViewModel.s2(String.valueOf(this.memberDataList.get(position).longValue()));
            if (s26 != null) {
                str = s26.getIdentityDesc();
            } else {
                str = null;
            }
            memberRank.setText(str);
            GuildWavAvatarImageView memberAvatar2 = holder.getMemberAvatar();
            memberAvatar2.setAvatarTinyId(com.tencent.mobileqq.guild.media.core.m.d(this.roomViewModel.getMediaChannelDataHub()), String.valueOf(this.memberDataList.get(position).longValue()));
            com.tencent.mobileqq.guild.media.core.data.p r26 = this.roomViewModel.r2(String.valueOf(this.memberDataList.get(position).longValue()));
            if (r26 != null) {
                num = Integer.valueOf(r26.f228117y);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                memberAvatar2.setIdentityView(R.drawable.guild_game_member_gender_man);
            } else if (num != null && num.intValue() == 2) {
                memberAvatar2.setIdentityView(R.drawable.guild_game_member_gender_woman);
            } else {
                memberAvatar2.setIdentityView(-1);
            }
            holder.itemView.setOnClickListener(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new d(context, this.mode);
        }

        public final void setData(@NotNull List<Long> dataList) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.memberDataList.clear();
            this.memberDataList.addAll(dataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view) != 0) {
                outRect.left = GuildGameInviteDialog.INSTANCE.d(4.0f, GuildGameInviteDialog.K);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "memberNickname", UserInfo.SEX_FEMALE, "o", "memberRank", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "G", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "l", "()Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "memberAvatar", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "memberWaitIcon", "Landroid/content/Context;", "context", "", "mode", "<init>", "(Landroid/content/Context;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView memberNickname;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView memberRank;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final GuildWavAvatarImageView memberAvatar;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView memberWaitIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull Context context, int i3) {
            super(GuildGameInviteDialog.INSTANCE.c(context, i3, GuildGameInviteDialog.K));
            Intrinsics.checkNotNullParameter(context, "context");
            View findViewById = this.itemView.findViewById(R.id.wgn);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026game_dlg_member_nickname)");
            this.memberNickname = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.wgo);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026ild_game_dlg_member_rank)");
            this.memberRank = (TextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.wgm);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026d_game_dlg_member_avatar)");
            this.memberAvatar = (GuildWavAvatarImageView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.f165529wh4);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026ld_game_invite_wait_icon)");
            this.memberWaitIcon = (ImageView) findViewById4;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final GuildWavAvatarImageView getMemberAvatar() {
            return this.memberAvatar;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getMemberNickname() {
            return this.memberNickname;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getMemberRank() {
            return this.memberRank;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final ImageView getMemberWaitIcon() {
            return this.memberWaitIcon;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.s> {
        public e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.s event) {
            com.tencent.mobileqq.guild.media.core.notify.s sVar = event;
            b bVar = GuildGameInviteDialog.this.adapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                bVar = null;
            }
            bVar.j0(sVar.getTinyId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<aj> {
        public f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(aj event) {
            aj ajVar = event;
            b bVar = GuildGameInviteDialog.this.adapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                bVar = null;
            }
            bVar.k0(ajVar.getTinyId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        public g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(SwitchThemeEvent event) {
            if (event.getNewThemeType() != 2) {
                GuildGameInviteDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.f> {
        public h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.f event) {
            if (event.getGameInfo().getResult() == 2) {
                GuildGameInviteDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$i", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i extends GuildPicStateListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f228819f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(View view) {
            super(true);
            this.f228819f = view;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            Bitmap bitmap;
            if (option != null) {
                bitmap = option.getResultBitMap();
            } else {
                bitmap = null;
            }
            if (bitmap != null && GuildGameInviteDialog.this.getContext() != null) {
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(GuildGameInviteDialog.this.getResources(), bitmap);
                Intrinsics.checkNotNullExpressionValue(create, "create(resources, bitmap)");
                create.setAntiAlias(true);
                create.setCornerRadius(GuildGameInviteDialog.INSTANCE.d(8.0f, GuildGameInviteDialog.K));
                ((ImageView) this.f228819f.findViewById(R.id.f165528wh3)).setBackground(create);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$j", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j extends LinearLayoutManager {
        j(FragmentActivity fragmentActivity) {
            super(fragmentActivity, 0, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$k", "Llf4/a;", "", "onSuccess", "b", "onUserCancel", "a", "onFailed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k implements lf4.a {
        k() {
        }

        @Override // lf4.a
        public void a() {
            QLog.i("GuildGameInviteDialog", 1, "launchGame onJumpForbidden");
            bt1.h hVar = GuildGameInviteDialog.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.v2();
        }

        @Override // lf4.a
        public void b() {
            QLog.i("GuildGameInviteDialog", 1, "launchGame onAppNotInstalled");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            String string = context.getString(R.string.f140010ct);
            Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(com.tencen\u2026failed_app_not_installed)");
            QQToast.makeText(context, string, 0).show();
            bt1.h hVar = GuildGameInviteDialog.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.v2();
        }

        @Override // lf4.a
        public void onFailed() {
            QLog.i("GuildGameInviteDialog", 1, "launchGame onFailed");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            String string = context.getString(R.string.f140020cu);
            Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(com.tencen\u2026_enter_game_failed_retry)");
            QQToast.makeText(context, string, 0).show();
            bt1.h hVar = GuildGameInviteDialog.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.v2();
        }

        @Override // lf4.a
        public void onSuccess() {
            QLog.i("GuildGameInviteDialog", 1, "launchGame onSuccess");
        }

        @Override // lf4.a
        public void onUserCancel() {
            QLog.i("GuildGameInviteDialog", 1, "launchGame onUserCancel");
            bt1.h hVar = GuildGameInviteDialog.this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.v2();
        }
    }

    private final View Fh(Context context, float scale) {
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setId(R.id.f165527wh2);
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        constraintLayout.setBackground(new ColorDrawable(Color.parseColor("#B3000000")));
        ConstraintLayout constraintLayout2 = new ConstraintLayout(context);
        constraintLayout2.setId(R.id.wgs);
        Companion companion = INSTANCE;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(companion.d(388.0f, K), companion.d(432.0f, K));
        QLog.d("GuildGameInviteDialog", 2, "dialogWidth=", Integer.valueOf(companion.d(388.0f, K)));
        layoutParams.topToTop = R.id.f165527wh2;
        layoutParams.startToStart = R.id.f165527wh2;
        layoutParams.endToEnd = R.id.f165527wh2;
        layoutParams.bottomToBottom = R.id.f165527wh2;
        constraintLayout2.setLayoutParams(layoutParams);
        constraintLayout2.setBackground(ContextCompat.getDrawable(context, R.drawable.guild_game_invite_root_bg));
        constraintLayout2.setClipChildren(false);
        constraintLayout.addView(constraintLayout2);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.f165528wh3);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, companion.d(203.0f, scale));
        layoutParams2.topToTop = R.id.wgs;
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        constraintLayout2.addView(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(R.id.wgu);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(companion.d(27.0f, scale), companion.d(27.0f, scale));
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = companion.d(15.0f, scale);
        layoutParams3.setMarginEnd(companion.d(15.0f, scale));
        layoutParams3.topToTop = R.id.wgs;
        layoutParams3.endToEnd = R.id.wgs;
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setImageResource(R.drawable.guild_game_invite_close);
        constraintLayout2.addView(imageView2);
        ch.X0(imageView2, "em_sgrp_honorofkings_game_invitation_close_btn", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.game.widget.g
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Gh;
                Gh = GuildGameInviteDialog.Gh(GuildGameInviteDialog.this, str);
                return Gh;
            }
        });
        GuildWavAvatarImageView guildWavAvatarImageView = new GuildWavAvatarImageView(context, null);
        guildWavAvatarImageView.setImageWidth((int) (70 * scale));
        guildWavAvatarImageView.setId(R.id.wgt);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(companion.d(70.0f, scale), companion.d(70.0f, scale));
        layoutParams4.endToEnd = R.id.wgs;
        layoutParams4.startToStart = R.id.wgs;
        layoutParams4.topToTop = R.id.wgs;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = companion.d(32.0f, scale);
        guildWavAvatarImageView.setLayoutParams(layoutParams4);
        constraintLayout2.addView(guildWavAvatarImageView);
        TextView textView = new TextView(context);
        textView.setId(R.id.f165525wh0);
        textView.setMaxLines(1);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.endToEnd = R.id.wgs;
        layoutParams5.startToStart = R.id.wgs;
        layoutParams5.topToBottom = R.id.wgt;
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = companion.d(12.0f, scale);
        textView.setLayoutParams(layoutParams5);
        textView.setTextSize(16.0f * scale);
        textView.setTextColor(-1);
        constraintLayout2.addView(textView);
        View view = new View(context);
        view.setId(R.id.wgv);
        view.setBackground(new ColorDrawable(Color.parseColor("#22FFFFFF")));
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-1, companion.d(1.0f, scale));
        layoutParams6.endToEnd = R.id.wgs;
        layoutParams6.startToStart = R.id.wgs;
        layoutParams6.topToBottom = R.id.f165525wh0;
        layoutParams6.setMarginStart(companion.d(28.0f, scale));
        layoutParams6.setMarginEnd(companion.d(28.0f, scale));
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = companion.d(15.0f, scale);
        view.setLayoutParams(layoutParams6);
        constraintLayout2.addView(view);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.wgz);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams7.startToStart = R.id.wgs;
        layoutParams7.topToBottom = R.id.wgv;
        layoutParams7.setMarginStart(companion.d(28.0f, scale));
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = companion.d(18.0f, scale);
        textView2.setLayoutParams(layoutParams7);
        textView2.setTextSize(14.0f * scale);
        textView2.setTextColor(-1);
        constraintLayout2.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(context);
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams8.endToEnd = R.id.wgs;
        layoutParams8.topToTop = R.id.wgz;
        layoutParams8.setMarginEnd(companion.d(28.0f, scale));
        frameLayout.setLayoutParams(layoutParams8);
        frameLayout.setBackgroundResource(R.drawable.guild_game_invite_grade_bg);
        TextView textView3 = new TextView(context);
        textView3.setId(R.id.wgx);
        textView3.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView3.setPadding(companion.d(4.0f, scale), companion.d(2.0f, scale), companion.d(4.0f, scale), companion.d(2.0f, scale));
        float f16 = scale * 12.0f;
        textView3.setTextSize(f16);
        textView3.setTextColor(Color.parseColor("#FF15D173"));
        frameLayout.addView(textView3);
        constraintLayout2.addView(frameLayout);
        RecyclerView recyclerView = new RecyclerView(context);
        this.memberContainer = recyclerView;
        recyclerView.setId(R.id.wgy);
        RecyclerView recyclerView2 = this.memberContainer;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            recyclerView2 = null;
        }
        recyclerView2.setClipChildren(false);
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-1, companion.d(111.0f, scale));
        layoutParams9.startToStart = R.id.wgs;
        layoutParams9.endToEnd = R.id.wgs;
        layoutParams9.topToBottom = R.id.wgz;
        layoutParams9.setMarginStart(companion.d(28.0f, scale));
        layoutParams9.setMarginEnd(companion.d(28.0f, scale));
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = companion.d(10.0f, scale);
        RecyclerView recyclerView3 = this.memberContainer;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutParams(layoutParams9);
        View view2 = this.memberContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            view2 = null;
        }
        constraintLayout2.addView(view2);
        RecyclerView recyclerView4 = this.memberContainer;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            recyclerView4 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(recyclerView4, "em_sgrp_honorofkings_game_invitation_seat_join_btn", clickPolicy, exposurePolicy);
        ImageView imageView3 = new ImageView(context);
        this.enterBtn = imageView3;
        imageView3.setId(R.id.wgw);
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(companion.d(340.0f, scale), companion.d(50.0f, scale));
        layoutParams10.startToStart = R.id.wgs;
        layoutParams10.endToEnd = R.id.wgs;
        layoutParams10.topToBottom = R.id.wgy;
        layoutParams10.setMarginStart(companion.d(28.0f, scale));
        layoutParams10.setMarginEnd(companion.d(28.0f, scale));
        ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = companion.d(13.0f, scale);
        ImageView imageView4 = this.enterBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterBtn");
            imageView4 = null;
        }
        imageView4.setLayoutParams(layoutParams10);
        ImageView imageView5 = this.enterBtn;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterBtn");
            imageView5 = null;
        }
        imageView5.setScaleType(ImageView.ScaleType.FIT_XY);
        View view3 = this.enterBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterBtn");
            view3 = null;
        }
        constraintLayout2.addView(view3);
        ImageView imageView6 = this.enterBtn;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterBtn");
            imageView6 = null;
        }
        ch.Y0(imageView6, "em_sgrp_honorofkings_game_invitation_join_btn", clickPolicy, exposurePolicy);
        TextView textView4 = new TextView(context);
        textView4.setId(R.id.f165526wh1);
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams11.startToStart = R.id.wgs;
        layoutParams11.endToEnd = R.id.wgs;
        layoutParams11.bottomToBottom = R.id.wgs;
        ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin = companion.d(30.0f, scale);
        textView4.setLayoutParams(layoutParams11);
        textView4.setTextSize(f16);
        textView4.setTextColor(Color.parseColor("#838387"));
        textView4.setText(R.string.f146010t1);
        constraintLayout2.addView(textView4);
        ImageView imageView7 = new ImageView(context);
        imageView7.setId(R.id.wgr);
        ConstraintLayout.LayoutParams layoutParams12 = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams12.topToTop = R.id.wgs;
        layoutParams12.bottomToBottom = R.id.wgs;
        layoutParams12.startToStart = R.id.wgs;
        layoutParams12.endToEnd = R.id.wgs;
        imageView7.setLayoutParams(layoutParams12);
        imageView7.setScaleType(ImageView.ScaleType.FIT_XY);
        constraintLayout2.addView(imageView7);
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Gh(GuildGameInviteDialog this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Object> Hh() {
        long j3;
        HashMap<String, Object> hashMap = new HashMap<>();
        bt1.h hVar = this.roomViewModel;
        bt1.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        hashMap.put("sgrp_avchannel_gameplay_id", hVar.h2());
        bt1.h hVar3 = this.roomViewModel;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar3 = null;
        }
        hashMap.put("sgrp_user_segment", hVar3.o2());
        bt1.h hVar4 = this.roomViewModel;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar4 = null;
        }
        hashMap.put("sgrp_game_team_id", hVar4.p2());
        bt1.h hVar5 = this.roomViewModel;
        if (hVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar5 = null;
        }
        hashMap.put("sgrp_game_mode", hVar5.i2());
        bt1.h hVar6 = this.roomViewModel;
        if (hVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar6 = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo = hVar6.e2().getRoomInfo();
        if (roomInfo != null) {
            j3 = roomInfo.getCurrentNum();
        } else {
            j3 = 0;
        }
        hashMap.put("sgrp_team_users_number", Long.valueOf(j3));
        bt1.h hVar7 = this.roomViewModel;
        if (hVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
        } else {
            hVar2 = hVar7;
        }
        hashMap.put("sgrp_team_state", Integer.valueOf(hVar2.q2()));
        hashMap.put("sgrp_segment_requirement", Ih());
        return hashMap;
    }

    private final String Ih() {
        IGProVoiceSmobaGameGameStaticInfo gameInfo;
        if (isDetached() || getContext() == null) {
            return "";
        }
        bt1.h hVar = this.roomViewModel;
        ArrayList<String> arrayList = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo = hVar.e2().getRoomInfo();
        if (roomInfo != null && (gameInfo = roomInfo.getGameInfo()) != null) {
            arrayList = gameInfo.getGradeNames();
        }
        if (arrayList == null) {
            return "";
        }
        if (arrayList.size() >= 2) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.f13830097, arrayList.get(0), arrayList.get(1));
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   \u2026List[1]\n                )");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        String string2 = getResources().getString(R.string.f170902ma);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.no_constrain)");
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildGameInviteDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.enterBtnClick = true;
            RoomAuthParams roomAuthParams = new RoomAuthParams(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()), com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c()), 101, true, 1);
            bt1.h hVar = this$0.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.T1(roomAuthParams);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildGameInviteDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        ((IGuildClientAuthApi) QRoute.api(IGuildClientAuthApi.class)).openClientAuthorizationDialog(QBaseActivity.sTopActivity, new GuildClientParams().e0(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c())).f(com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c())).l("100001").l0(7).e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(String scheme, String from) {
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getGameRoomHandler().a(scheme, requireActivity(), new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.hide();
        }
        if (Intrinsics.areEqual(bw.P(), "AUTH_PERMANENT")) {
            bt1.h hVar = this.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.t2();
            return;
        }
        GuildTeamAuthDialog guildTeamAuthDialog = new GuildTeamAuthDialog(new l(new Ref.BooleanRef(), this), 1);
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(guildTeamAuthDialog, supportFragmentManager, "GuildTeamAuthDialog");
    }

    private final void Sh() {
        this.exposureStart = System.currentTimeMillis();
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ch.Y0(view, "em_sgrp_honorofkings_game_invitation", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        VideoReport.reportEvent("imp", view2, Hh());
    }

    private final void Th() {
        if (this.exposureStart == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.exposureStart;
        HashMap<String, Object> Hh = Hh();
        Hh.put(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(currentTimeMillis));
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.reportEvent("imp_end", view, Hh);
    }

    public final void Jh() {
        com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.s.class, new e());
        com.tencent.mobileqq.guild.media.core.notify.p d17 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        d17.k0(viewLifecycleOwner2, aj.class, new f());
        com.tencent.mobileqq.guild.media.core.notify.p d18 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        d18.k0(viewLifecycleOwner3, SwitchThemeEvent.class, new g());
        com.tencent.mobileqq.guild.media.core.notify.p d19 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        d19.k0(viewLifecycleOwner4, com.tencent.mobileqq.guild.media.core.notify.f.class, new h());
        bt1.h hVar = this.roomViewModel;
        bt1.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        MutableLiveData<GuildAuthGameBean> c26 = hVar.c2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<GuildAuthGameBean, Unit> function1 = new Function1<GuildAuthGameBean, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameInviteDialog$initListeners$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildAuthGameBean guildAuthGameBean) {
                invoke2(guildAuthGameBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildAuthGameBean guildAuthGameBean) {
                if (guildAuthGameBean == null) {
                    return;
                }
                int state = guildAuthGameBean.getState();
                if (state == 1) {
                    GuildGameInviteDialog.this.Rh();
                } else if (state == 5) {
                    GuildGameInviteDialog.this.Ph();
                } else {
                    QQToast.makeText(GuildGameInviteDialog.this.getContext(), guildAuthGameBean.getTipsContent(), 0).show();
                }
            }
        };
        c26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGameInviteDialog.Mh(Function1.this, obj);
            }
        });
        bt1.h hVar3 = this.roomViewModel;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar3 = null;
        }
        MutableLiveData<Pair<String, String>> n26 = hVar3.n2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<Pair<? extends String, ? extends String>, Unit> function12 = new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameInviteDialog$initListeners$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends String> pair) {
                invoke2((Pair<String, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, String> pair) {
                if (pair == null || StringUtil.isEmpty(pair.getFirst())) {
                    return;
                }
                GuildGameInviteDialog.this.Qh(pair.getFirst(), pair.getSecond());
            }
        };
        n26.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGameInviteDialog.Kh(Function1.this, obj);
            }
        });
        bt1.h hVar4 = this.roomViewModel;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
        } else {
            hVar2 = hVar4;
        }
        MutableLiveData<Pair<Boolean, String>> k26 = hVar2.k2();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final Function1<Pair<? extends Boolean, ? extends String>, Unit> function13 = new Function1<Pair<? extends Boolean, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameInviteDialog$initListeners$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, String> pair) {
                boolean z16;
                Object obj;
                String str;
                if (pair == null) {
                    return;
                }
                HashMap Hh = GuildGameInviteDialog.this.Hh();
                if (pair.getFirst().booleanValue()) {
                    Hh.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_RESULT_JOIN_STATE, 1);
                } else {
                    Hh.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_RESULT_JOIN_STATE, 0);
                    QQToast.makeText(GuildGameInviteDialog.this.getContext(), pair.getSecond(), 0).show();
                }
                z16 = GuildGameInviteDialog.this.enterBtnClick;
                Object obj2 = null;
                if (z16) {
                    obj = GuildGameInviteDialog.this.enterBtn;
                    if (obj == null) {
                        str = "enterBtn";
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    obj2 = obj;
                } else {
                    obj = GuildGameInviteDialog.this.memberContainer;
                    if (obj == null) {
                        str = "memberContainer";
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    obj2 = obj;
                }
                VideoReport.reportEvent("clck", obj2, Hh);
                GuildGameInviteDialog.this.dismissAllowingStateLoss();
            }
        };
        k26.observe(viewLifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGameInviteDialog.Lh(Function1.this, obj);
            }
        });
    }

    public final void initView(@NotNull View view) {
        Integer num;
        Intrinsics.checkNotNullParameter(view, "view");
        ((ImageView) view.findViewById(R.id.wgr)).setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("GuildGameInviteDialog", "https://downv6.qq.com/innovate/guild/media_game/guild_game_grid_border.png", new ApngOptions()));
        com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
        Option option = new Option();
        bt1.h hVar = this.roomViewModel;
        ImageView imageView = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo = hVar.e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo);
        a16.f(option.setUrl(roomInfo.getGameInfo().getCoverUrl()), new i(view));
        GuildWavAvatarImageView guildWavAvatarImageView = (GuildWavAvatarImageView) view.findViewById(R.id.wgt);
        bt1.h hVar2 = this.roomViewModel;
        if (hVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar2 = null;
        }
        String d16 = com.tencent.mobileqq.guild.media.core.m.d(hVar2.getMediaChannelDataHub());
        bt1.h hVar3 = this.roomViewModel;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar3 = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo2 = hVar3.e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo2);
        guildWavAvatarImageView.setAvatarTinyId(d16, String.valueOf(roomInfo2.getCaptainTinyId()));
        bt1.h hVar4 = this.roomViewModel;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar4 = null;
        }
        bt1.h hVar5 = this.roomViewModel;
        if (hVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar5 = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo3 = hVar5.e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo3);
        com.tencent.mobileqq.guild.media.core.data.p r26 = hVar4.r2(String.valueOf(roomInfo3.getCaptainTinyId()));
        if (r26 != null) {
            num = Integer.valueOf(r26.f228117y);
        } else {
            num = null;
        }
        int i3 = 2;
        if (num != null && num.intValue() == 1) {
            guildWavAvatarImageView.setIdentityView(R.drawable.guild_game_member_gender_man);
        } else if (num != null && num.intValue() == 2) {
            guildWavAvatarImageView.setIdentityView(R.drawable.guild_game_member_gender_woman);
        } else {
            guildWavAvatarImageView.setIdentityView(-1);
        }
        bt1.h hVar6 = this.roomViewModel;
        if (hVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar6 = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo4 = hVar6.e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo4);
        if (((int) roomInfo4.getGameInfo().getMaxNum()) != 5) {
            i3 = 1;
        }
        bt1.h hVar7 = this.roomViewModel;
        if (hVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar7 = null;
        }
        this.adapter = new b(hVar7, i3);
        RecyclerView recyclerView = this.memberContainer;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            recyclerView = null;
        }
        b bVar = this.adapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            bVar = null;
        }
        recyclerView.setAdapter(bVar);
        j jVar = new j(requireActivity());
        RecyclerView recyclerView2 = this.memberContainer;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(jVar);
        RecyclerView recyclerView3 = this.memberContainer;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberContainer");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new c());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        bt1.h hVar8 = this.roomViewModel;
        if (hVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar8 = null;
        }
        String d17 = com.tencent.mobileqq.guild.media.core.m.d(hVar8.getMediaChannelDataHub());
        bt1.h hVar9 = this.roomViewModel;
        if (hVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar9 = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo5 = hVar9.e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo5);
        String captainNickname = ch.H(peekAppRuntime, d17, String.valueOf(roomInfo5.getCaptainTinyId()));
        if (captainNickname.length() > 5) {
            Intrinsics.checkNotNullExpressionValue(captainNickname, "captainNickname");
            String substring = captainNickname.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            captainNickname = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        ((TextView) view.findViewById(R.id.f165525wh0)).setText(captainNickname + "\u9080\u8bf7\u4f60\u4e00\u8d77\u5f00\u9ed1\uff0c\u5c31\u7b49\u4f60\u4e86\uff01");
        TextView textView = (TextView) view.findViewById(R.id.wgz);
        bt1.h hVar10 = this.roomViewModel;
        if (hVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
            hVar10 = null;
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo6 = hVar10.e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo6);
        textView.setText(roomInfo6.getGameInfo().getGameMode());
        ((TextView) view.findViewById(R.id.wgx)).setText(Ih());
        ImageView imageView2 = this.enterBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterBtn");
            imageView2 = null;
        }
        imageView2.setBackground(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("GuildGameInviteDialog", "https://downv6.qq.com/innovate/guild/media_game/guild_game_enter_btn.png", new ApngOptions()));
        ImageView imageView3 = this.enterBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterBtn");
        } else {
            imageView = imageView3;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildGameInviteDialog.Nh(GuildGameInviteDialog.this, view2);
            }
        });
        ((ImageView) view.findViewById(R.id.wgu)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildGameInviteDialog.Oh(GuildGameInviteDialog.this, view2);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this, new bt1.a(1L)).get(bt1.h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026oomViewModel::class.java]");
        this.roomViewModel = (bt1.h) viewModel;
        setStyle(1, R.style.avs);
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = (int) (i3 / displayMetrics.density);
        QLog.d("GuildGameInviteDialog", 2, "screenWidth=", Integer.valueOf(i3), ":", Integer.valueOf(i16));
        if (i16 < 428) {
            K = i16 / 428.0f;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        View Fh = Fh(requireActivity, K);
        this.rootView = Fh;
        View view = null;
        if (Fh == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            Fh = null;
        }
        initView(Fh);
        Jh();
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view2;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (com.tencent.mobileqq.guild.media.core.j.c().n().getResult() == 2) {
            dismissAllowingStateLoss();
        }
        Sh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Th();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameInviteDialog$l", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;", "", "e", "b", "d", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class l implements GuildTeamAuthDialog.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f228821a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildGameInviteDialog f228822b;

        l(Ref.BooleanRef booleanRef, GuildGameInviteDialog guildGameInviteDialog) {
            this.f228821a = booleanRef;
            this.f228822b = guildGameInviteDialog;
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void a() {
            if (!this.f228821a.element && this.f228822b.getDialog() != null && this.f228822b.getContext() != null) {
                HashMap Hh = this.f228822b.Hh();
                Hh.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_RESULT_JOIN_STATE, 0);
                ImageView imageView = this.f228822b.enterBtn;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("enterBtn");
                    imageView = null;
                }
                VideoReport.reportEvent("clck", imageView, Hh);
                this.f228822b.dismissAllowingStateLoss();
            }
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void b() {
            this.f228821a.element = true;
            bw.w1("AUTH_PERMANENT");
            bt1.h hVar = this.f228822b.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.t2();
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void e() {
            this.f228821a.element = true;
            bt1.h hVar = this.f228822b.roomViewModel;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomViewModel");
                hVar = null;
            }
            hVar.t2();
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void c() {
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void d() {
        }
    }
}
