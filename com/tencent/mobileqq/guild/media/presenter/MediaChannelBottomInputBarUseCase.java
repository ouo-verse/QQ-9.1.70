package com.tencent.mobileqq.guild.media.presenter;

import android.animation.AnimatorInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.aio.AioUiState;
import com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.core.logic.gift.a;
import com.tencent.mobileqq.guild.media.core.notify.SwitchScreenState;
import com.tencent.mobileqq.guild.media.core.notify.bi;
import com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.ScanningView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0007*\u0002VY\u0018\u0000 \u00102\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\\\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020$\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0006\u0010\u0017\u001a\u00020\u0004R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u00104\u001a\n 1*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00108\u001a\n 1*\u0004\u0018\u000105058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010;\u001a\n 1*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010=\u001a\n 1*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u001c\u0010?\u001a\n 1*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u001c\u0010C\u001a\n 1*\u0004\u0018\u00010@0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010E\u001a\n 1*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010:R\u001c\u0010H\u001a\n 1*\u0004\u0018\u00010F0F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010GR\u001c\u0010K\u001a\n 1*\u0004\u0018\u00010I0I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010JR\u001c\u0010N\u001a\n 1*\u0004\u0018\u00010L0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010MR\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010OR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\f0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010RR\u001e\u0010U\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010WR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010Z\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase;", "", "", "isInputState", "", UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "D", "Landroid/view/View;", "emojiView", "u", "Le12/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", DomainData.DOMAIN_NAME, "t", "v", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper;", "r", "B", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/fragment/app/Fragment;", "a", "Landroidx/fragment/app/Fragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "p", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "o", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "d", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "aioViewModel", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "e", "Landroid/widget/LinearLayout;", "mInputBar", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "f", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "mInputDesc", "g", "Landroid/view/View;", "mOverFlowInput", tl.h.F, "mOverFlowInputText", "i", "mOverFlowInputEmoji", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "mInputStateDesc", "k", "mInputEmoji", "Lcom/tencent/mobileqq/guild/media/gift/GuildFreeGiftView;", "Lcom/tencent/mobileqq/guild/media/gift/GuildFreeGiftView;", "mFreeGiftView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mSaleGiftIv", "Lcom/tencent/mobileqq/guild/widget/ScanningView;", "Lcom/tencent/mobileqq/guild/widget/ScanningView;", "mScanningView", "I", "mCurrentState", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "mGuildMuteObserver", "Le12/a;", "mMuteTime", "com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase$c", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase$c;", "userTalkPermissionUpdateEvent", "com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase$b", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase$b;", "bottomBtnChangedEvent", "mRootView", "<init>", "(Landroid/view/View;Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelBottomInputBarUseCase {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProGuildInfo mGuildInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo mChannelInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aioViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mInputBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final GuildAIOInputEditText mInputDesc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final View mOverFlowInput;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View mOverFlowInputText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final View mOverFlowInputEmoji;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final TextView mInputStateDesc;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final View mInputEmoji;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final GuildFreeGiftView mFreeGiftView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ImageView mSaleGiftIv;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final ScanningView mScanningView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int mCurrentState;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Long> mGuildMuteObserver;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e12.a<Long> mMuteTime;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c userTalkPermissionUpdateEvent;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b bottomBtnChangedEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/d;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.d> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.d event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelBottomInputBarUseCase.this.D();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomInputBarUseCase$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<bi> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bi event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelBottomInputBarUseCase.this.t();
        }
    }

    public MediaChannelBottomInputBarUseCase(@NotNull View mRootView, @NotNull Fragment fragment, @NotNull IGProGuildInfo mGuildInfo, @NotNull IGProChannelInfo mChannelInfo) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        Intrinsics.checkNotNullParameter(mChannelInfo, "mChannelInfo");
        this.fragment = fragment;
        this.mGuildInfo = mGuildInfo;
        this.mChannelInfo = mChannelInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildMediaAioViewModel>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$aioViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaAioViewModel invoke() {
                GuildMediaAioViewModel.Companion companion = GuildMediaAioViewModel.INSTANCE;
                FragmentActivity requireActivity = MediaChannelBottomInputBarUseCase.this.getFragment().requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
                return companion.a(requireActivity);
            }
        });
        this.aioViewModel = lazy;
        final LinearLayout mInputBar$lambda$0 = (LinearLayout) mRootView.findViewById(R.id.wq7);
        Intrinsics.checkNotNullExpressionValue(mInputBar$lambda$0, "mInputBar$lambda$0");
        jt1.b.b(mInputBar$lambda$0, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$mInputBar$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                int i3;
                GuildMediaAioViewModel l3;
                GuildMediaAioViewModel l16;
                Intrinsics.checkNotNullParameter(it, "it");
                i3 = MediaChannelBottomInputBarUseCase.this.mCurrentState;
                if (i3 == 0) {
                    l3 = MediaChannelBottomInputBarUseCase.this.l();
                    l3.l2(b.o.f227881a);
                    return;
                }
                if (i3 == 1) {
                    FragmentActivity requireActivity = MediaChannelBottomInputBarUseCase.this.getFragment().requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
                    String guildID = MediaChannelBottomInputBarUseCase.this.getMGuildInfo().getGuildID();
                    Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo.guildID");
                    sz1.c.d(requireActivity, guildID);
                    return;
                }
                if (i3 == 2) {
                    QQToast.makeText(mInputBar$lambda$0.getContext(), com.tencent.mobileqq.guild.setting.mute.c.u(MediaChannelBottomInputBarUseCase.this.getMGuildInfo().getGuildID(), MediaChannelBottomInputBarUseCase.this.getMChannelInfo().getChannelUin()), 0).show();
                    return;
                }
                if (i3 == 3) {
                    QQToast.makeText(mInputBar$lambda$0.getContext(), "\u4f60\u5df2\u88ab\u5c01\u7981\uff0c\u53ef\u8054\u7cfb\u7ba1\u7406\u5458\u5f00\u542f", 0).show();
                    return;
                }
                if (i3 != 5) {
                    if (i3 != 6) {
                        return;
                    }
                    ch.h1(MediaChannelBottomInputBarUseCase.this.getFragment().requireActivity(), MediaChannelBottomInputBarUseCase.this.getMGuildInfo().getGuildID());
                } else {
                    l16 = MediaChannelBottomInputBarUseCase.this.l();
                    l16.l2(b.m.f227879a);
                    com.tencent.mobileqq.guild.media.core.j.d().i(SwitchScreenState.NORMAL);
                }
            }
        });
        this.mInputBar = mInputBar$lambda$0;
        GuildAIOInputEditText mInputDesc$lambda$1 = (GuildAIOInputEditText) mRootView.findViewById(R.id.wqa);
        mInputDesc$lambda$1.setBackground(null);
        mInputDesc$lambda$1.setFocusable(false);
        mInputDesc$lambda$1.setCursorVisible(false);
        mInputDesc$lambda$1.setLongClickable(false);
        mInputDesc$lambda$1.setTextIsSelectable(false);
        Intrinsics.checkNotNullExpressionValue(mInputDesc$lambda$1, "mInputDesc$lambda$1");
        jt1.b.b(mInputDesc$lambda$1, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$mInputDesc$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                GuildMediaAioViewModel l3;
                Intrinsics.checkNotNullParameter(it, "it");
                l3 = MediaChannelBottomInputBarUseCase.this.l();
                l3.l2(b.o.f227881a);
            }
        });
        this.mInputDesc = mInputDesc$lambda$1;
        this.mOverFlowInput = mRootView.findViewById(R.id.wq9);
        View mOverFlowInputText$lambda$2 = mRootView.findViewById(R.id.wq_);
        Intrinsics.checkNotNullExpressionValue(mOverFlowInputText$lambda$2, "mOverFlowInputText$lambda$2");
        jt1.b.b(mOverFlowInputText$lambda$2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$mOverFlowInputText$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                GuildMediaAioViewModel l3;
                Intrinsics.checkNotNullParameter(it, "it");
                l3 = MediaChannelBottomInputBarUseCase.this.l();
                l3.l2(b.o.f227881a);
            }
        });
        this.mOverFlowInputText = mOverFlowInputText$lambda$2;
        View findViewById = mRootView.findViewById(R.id.wq8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        u(findViewById);
        this.mOverFlowInputEmoji = findViewById;
        this.mInputStateDesc = (TextView) mRootView.findViewById(R.id.wqc);
        View findViewById2 = mRootView.findViewById(R.id.wqb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "this");
        u(findViewById2);
        this.mInputEmoji = findViewById2;
        GuildFreeGiftView guildFreeGiftView = (GuildFreeGiftView) mRootView.findViewById(R.id.swx);
        ch.T0(guildFreeGiftView, "em_sgrp_free_gift", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST, null);
        this.mFreeGiftView = guildFreeGiftView;
        ImageView mSaleGiftIv$lambda$6 = (ImageView) mRootView.findViewById(R.id.f164504sx0);
        ch.T0(mSaleGiftIv$lambda$6, "em_sgrp_aio_gifts", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, null);
        Intrinsics.checkNotNullExpressionValue(mSaleGiftIv$lambda$6, "mSaleGiftIv$lambda$6");
        jt1.b.b(mSaleGiftIv$lambda$6, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$mSaleGiftIv$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MediaChannelBottomInputBarUseCase.this.B();
            }
        });
        this.mSaleGiftIv = mSaleGiftIv$lambda$6;
        ScanningView scanningView = (ScanningView) mRootView.findViewById(R.id.f79734_k);
        this.mScanningView = scanningView;
        this.mCurrentState = -1;
        this.mGuildMuteObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.presenter.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaChannelBottomInputBarUseCase.z(MediaChannelBottomInputBarUseCase.this, (Long) obj);
            }
        };
        this.userTalkPermissionUpdateEvent = new c();
        this.bottomBtnChangedEvent = new b();
        s();
        v();
        guildFreeGiftView.E(fragment.getActivity());
        scanningView.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        QLog.i("QGMC.BottomInputBar", 1, "[onOnSaleGiftIconClicked] ");
        y();
    }

    private final void C() {
        e12.a<Long> aVar = this.mMuteTime;
        if (aVar != null) {
            aVar.removeObserver(this.mGuildMuteObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        if (this.mCurrentState != 0) {
            return;
        }
        this.mInputBar.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.presenter.o
            @Override // java.lang.Runnable
            public final void run() {
                MediaChannelBottomInputBarUseCase.E(MediaChannelBottomInputBarUseCase.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(MediaChannelBottomInputBarUseCase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((this$0.mInputBar.getVisibility() == 0 && this$0.mInputBar.getMeasuredWidth() < ViewUtils.dpToPx(110.0f)) || (this$0.mOverFlowInput.getVisibility() == 0 && this$0.mOverFlowInput.getMeasuredWidth() < ViewUtils.dpToPx(110.0f))) {
            this$0.mOverFlowInput.setVisibility(0);
            this$0.mInputBar.setVisibility(8);
        } else {
            this$0.mInputBar.setVisibility(0);
            this$0.mOverFlowInput.setVisibility(8);
        }
    }

    private final void F(boolean isInputState) {
        if (isInputState) {
            this.mInputDesc.setVisibility(0);
            this.mInputEmoji.setVisibility(0);
            this.mInputStateDesc.setVisibility(8);
            D();
            return;
        }
        this.mInputDesc.setVisibility(8);
        this.mInputEmoji.setVisibility(8);
        this.mInputStateDesc.setVisibility(0);
        this.mInputBar.setVisibility(0);
        this.mOverFlowInput.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildMediaAioViewModel l() {
        return (GuildMediaAioViewModel) this.aioViewModel.getValue();
    }

    private final int n() {
        AioUiState value = l().P1().getValue();
        if (value == AioUiState.SHOW_CANNOT_INPUT) {
            return 4;
        }
        if (value == AioUiState.HIDE) {
            return 5;
        }
        if (ch.r(this.mGuildInfo.getGuildID())) {
            return 6;
        }
        if (r().i0()) {
            return 1;
        }
        if (r().c0()) {
            return 3;
        }
        if (r().d0()) {
            return 2;
        }
        return 0;
    }

    private final e12.a<Long> q() {
        e12.a<Long> C = com.tencent.mobileqq.guild.setting.mute.c.C(this.mGuildInfo.getGuildID());
        Long value = C.getValue();
        Long l3 = 0L;
        if (value == null) {
            value = l3;
        }
        long longValue = value.longValue();
        e12.a<Long> s16 = com.tencent.mobileqq.guild.setting.mute.c.s(this.mGuildInfo.getGuildID());
        Long value2 = s16.getValue();
        if (value2 != null) {
            l3 = value2;
        }
        if (longValue <= l3.longValue()) {
            return s16;
        }
        return C;
    }

    private final MediaChannelPermissionHelper r() {
        return com.tencent.mobileqq.guild.media.core.j.a().S();
    }

    private final void s() {
        e12.a<Long> aVar;
        int n3 = n();
        if (n3 != 0 && n3 != 5) {
            l().l2(new b.h(true));
        }
        if (n3 != 2 && n3 == this.mCurrentState) {
            return;
        }
        this.mCurrentState = n3;
        C();
        if (n3 == 0) {
            F(true);
            return;
        }
        F(false);
        Long l3 = null;
        this.mInputStateDesc.setCompoundDrawables(null, null, null, null);
        this.mInputStateDesc.setStateListAnimator(null);
        switch (n3) {
            case 1:
                this.mInputStateDesc.setText("\u8fbe\u5230\u53d1\u8a00\u95e8\u69db\u53ef\u53d1\u8a00");
                return;
            case 2:
                this.mMuteTime = q();
                if (this.fragment.getView() != null && (aVar = this.mMuteTime) != null) {
                    aVar.observe(this.fragment.getViewLifecycleOwner(), this.mGuildMuteObserver);
                }
                e12.a<Long> aVar2 = this.mMuteTime;
                if (aVar2 != null) {
                    l3 = aVar2.getValue();
                }
                String B = com.tencent.mobileqq.guild.setting.mute.c.B(l3);
                if (Intrinsics.areEqual(B, "")) {
                    this.mInputStateDesc.setText(B);
                    return;
                }
                TextView textView = this.mInputStateDesc;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("\u7981\u8a00\u5269\u4f59%s", Arrays.copyOf(new Object[]{B}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView.setText(format);
                return;
            case 3:
                this.mInputStateDesc.setText("\u5c01\u7981\u4e2d\u65e0\u6cd5\u53d1\u8a00");
                return;
            case 4:
                this.mInputStateDesc.setText("\u8bc4\u8bba\u529f\u80fd\u7ef4\u62a4\u4e2d");
                return;
            case 5:
                this.mInputStateDesc.setText("\u5c55\u793a\u804a\u5929\u533a\u57df");
                this.mInputStateDesc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.guild_media_input_bar_show_aio, 0, 0, 0);
                TextView textView2 = this.mInputStateDesc;
                textView2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(textView2.getContext(), R.animator.f155134n));
                return;
            case 6:
                this.mInputStateDesc.setText("\u5b9e\u540d\u8ba4\u8bc1\u540e\u53ef\u53d1\u8a00");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        s();
    }

    private final void u(View emojiView) {
        ch.T0(emojiView, "em_sgrp_aio_stickers", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, null);
        jt1.b.b(emojiView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$initEmojiIv$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                int i3;
                LinearLayout linearLayout;
                GuildMediaAioViewModel l3;
                Intrinsics.checkNotNullParameter(it, "it");
                i3 = MediaChannelBottomInputBarUseCase.this.mCurrentState;
                if (i3 == 0) {
                    l3 = MediaChannelBottomInputBarUseCase.this.l();
                    l3.l2(b.n.f227880a);
                } else {
                    linearLayout = MediaChannelBottomInputBarUseCase.this.mInputBar;
                    linearLayout.performClick();
                }
            }
        });
    }

    private final void v() {
        com.tencent.mobileqq.guild.media.core.j.d().V(bi.class, this.userTalkPermissionUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.d.class, this.bottomBtnChangedEvent);
        LiveData<AioUiState> P1 = l().P1();
        Fragment fragment = this.fragment;
        final Function1<AioUiState, Unit> function1 = new Function1<AioUiState, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AioUiState aioUiState) {
                invoke2(aioUiState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AioUiState aioUiState) {
                MediaChannelBottomInputBarUseCase.this.t();
            }
        };
        P1.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.guild.media.presenter.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaChannelBottomInputBarUseCase.w(Function1.this, obj);
            }
        });
        LiveData<GuildAIOInputEditText> R1 = l().R1();
        Fragment fragment2 = this.fragment;
        final Function1<GuildAIOInputEditText, Unit> function12 = new Function1<GuildAIOInputEditText, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomInputBarUseCase$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildAIOInputEditText guildAIOInputEditText) {
                invoke2(guildAIOInputEditText);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildAIOInputEditText guildAIOInputEditText) {
                int i3;
                GuildAIOInputEditText guildAIOInputEditText2;
                i3 = MediaChannelBottomInputBarUseCase.this.mCurrentState;
                if (i3 != 0 || guildAIOInputEditText == null) {
                    return;
                }
                guildAIOInputEditText2 = MediaChannelBottomInputBarUseCase.this.mInputDesc;
                guildAIOInputEditText2.setText(guildAIOInputEditText.getText());
            }
        };
        R1.observe(fragment2, new Observer() { // from class: com.tencent.mobileqq.guild.media.presenter.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaChannelBottomInputBarUseCase.x(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void y() {
        boolean z16;
        QLog.i("QGMC.BottomInputBar", 1, "[launchGiftPanel] start");
        if (this.fragment.getActivity() != null) {
            FragmentActivity activity = this.fragment.getActivity();
            boolean z17 = false;
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                FragmentActivity activity2 = this.fragment.getActivity();
                if (activity2 != null && activity2.isDestroyed()) {
                    z17 = true;
                }
                if (!z17) {
                    com.tencent.mobileqq.guild.media.core.logic.gift.a b06 = com.tencent.mobileqq.guild.media.core.j.a().b0();
                    FragmentActivity requireActivity = this.fragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
                    a.C7832a.a(b06, requireActivity, null, 2, null);
                    return;
                }
            }
        }
        QLog.w("QGMC.BottomInputBar", 1, "[onFreeGiftIconClicked] invalid context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(MediaChannelBottomInputBarUseCase this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String B = com.tencent.mobileqq.guild.setting.mute.c.B(l3);
        if (Intrinsics.areEqual(B, "")) {
            this$0.C();
            this$0.mInputStateDesc.setText(B);
            return;
        }
        TextView textView = this$0.mInputStateDesc;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("\u7981\u8a00\u5269\u4f59%s", Arrays.copyOf(new Object[]{B}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    public final void A() {
        com.tencent.mobileqq.guild.media.core.j.d().j(bi.class, this.userTalkPermissionUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.d.class, this.bottomBtnChangedEvent);
        C();
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final Fragment getFragment() {
        return this.fragment;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final IGProChannelInfo getMChannelInfo() {
        return this.mChannelInfo;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final IGProGuildInfo getMGuildInfo() {
        return this.mGuildInfo;
    }
}
