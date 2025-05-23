package com.tencent.mobileqq.guild.media.presenter;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.core.notify.ak;
import com.tencent.mobileqq.guild.media.core.notify.ap;
import com.tencent.mobileqq.guild.media.core.notify.ax;
import com.tencent.mobileqq.guild.media.core.notify.bh;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.widget.GuildMediaRaiseHandInvitationDialogFragment;
import com.tencent.mobileqq.guild.media.widget.GuildRaiseHandDialogFragment;
import com.tencent.mobileqq.guild.media.widget.u;
import com.tencent.mobileqq.guild.performance.report.aa;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0004BEHK\u0018\u0000 \u00062\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\f\u0010\u000e\u001a\u00020\r*\u00020\tH\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00100\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u001c\u00104\u001a\n '*\u0004\u0018\u000101018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00108\u001a\n '*\u0004\u0018\u000105058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010>\u001a\n '*\u0004\u0018\u00010<0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "openType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper;", "k", ReportConstant.COSTREPORT_PREFIX, "r", "", "o", "p", "Landroidx/fragment/app/Fragment;", "a", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getMGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getMChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mRaiseHandIv", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "e", "Landroid/view/ViewGroup;", "mRaiseHandGroup", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "f", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "g", "mRaiseHandAdmin", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mRaiseHandNumber", "Lcom/airbnb/lottie/LottieAnimationView;", "i", "Lcom/airbnb/lottie/LottieAnimationView;", "mRaiseHandAnim", "j", "Z", "mAnimating", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "", "J", "mLastRaiseHandTime", "com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$f", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$f;", "raiseHandCountObserver", "com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$g", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$g;", "raiseHandIconObserver", "com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$h", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$h;", "userReceivedInvitationObserver", "com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$e", "Lcom/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$e;", "mThirdAppInfoUpdateEvent", "Landroid/view/View;", "mRootView", "<init>", "(Landroid/view/View;Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelBottomRaiseHandUseCase {

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
    private final ImageView mRaiseHandIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mRaiseHandGroup;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y mAudioRoomObserver;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mRaiseHandAdmin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView mRaiseHandNumber;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LottieAnimationView mRaiseHandAnim;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean mAnimating;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long mLastRaiseHandTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f raiseHandCountObserver;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g raiseHandIconObserver;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h userReceivedInvitationObserver;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mThirdAppInfoUpdateEvent;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229078a;

        static {
            int[] iArr = new int[MediaChannelRaiseHandHelper.RaiseHandState.values().length];
            try {
                iArr[MediaChannelRaiseHandHelper.RaiseHandState.MANAGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_NOT_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_CLICKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f229078a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$c", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends y {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void a() {
            MediaChannelBottomRaiseHandUseCase.this.r();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ax;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<ax> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ax event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelBottomRaiseHandUseCase.this.r();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ak;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<ak> {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ak event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelBottomRaiseHandUseCase.this.s();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ap;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<ap> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ap event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelBottomRaiseHandUseCase.this.r();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bh;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.media.core.notify.o<bh> {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bh event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelBottomRaiseHandUseCase.this.q(event.getOpenType());
        }
    }

    public MediaChannelBottomRaiseHandUseCase(@NotNull View mRootView, @NotNull Fragment fragment, @NotNull IGProGuildInfo mGuildInfo, @NotNull IGProChannelInfo mChannelInfo) {
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        Intrinsics.checkNotNullParameter(mChannelInfo, "mChannelInfo");
        this.fragment = fragment;
        this.mGuildInfo = mGuildInfo;
        this.mChannelInfo = mChannelInfo;
        View findViewById = mRootView.findViewById(R.id.sx7);
        ImageView imageView = (ImageView) findViewById;
        imageView.setImageResource(R.drawable.guild_media_raise_hand);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<I\u2026d_media_raise_hand)\n    }");
        this.mRaiseHandIv = imageView;
        ViewGroup mRaiseHandGroup$lambda$1 = (ViewGroup) mRootView.findViewById(R.id.sx6);
        Intrinsics.checkNotNullExpressionValue(mRaiseHandGroup$lambda$1, "mRaiseHandGroup$lambda$1");
        jt1.b.b(mRaiseHandGroup$lambda$1, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomRaiseHandUseCase$mRaiseHandGroup$1$1
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
                MediaChannelRaiseHandHelper k3;
                boolean o16;
                LottieAnimationView lottieAnimationView;
                LottieAnimationView lottieAnimationView2;
                LottieAnimationView lottieAnimationView3;
                LottieAnimationView lottieAnimationView4;
                LottieAnimationView lottieAnimationView5;
                LottieAnimationView lottieAnimationView6;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToast.makeText(BaseApplication.context, 0, "\u5f53\u524d\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", 0).show();
                    return;
                }
                MediaChannelBottomRaiseHandUseCase mediaChannelBottomRaiseHandUseCase = MediaChannelBottomRaiseHandUseCase.this;
                k3 = mediaChannelBottomRaiseHandUseCase.k();
                o16 = mediaChannelBottomRaiseHandUseCase.o(k3);
                if (o16) {
                    lottieAnimationView = MediaChannelBottomRaiseHandUseCase.this.mRaiseHandAnim;
                    String imageAssetsFolder = lottieAnimationView.getImageAssetsFolder();
                    if (imageAssetsFolder == null || imageAssetsFolder.length() == 0) {
                        lottieAnimationView5 = MediaChannelBottomRaiseHandUseCase.this.mRaiseHandAnim;
                        lottieAnimationView5.setAnimation("media/raisehand/big/guild_raisehand_big.json");
                        lottieAnimationView6 = MediaChannelBottomRaiseHandUseCase.this.mRaiseHandAnim;
                        lottieAnimationView6.setImageAssetsFolder("media/raisehand/big/images/");
                    }
                    MediaChannelBottomRaiseHandUseCase.this.mRaiseHandIv.setVisibility(8);
                    lottieAnimationView2 = MediaChannelBottomRaiseHandUseCase.this.mRaiseHandAnim;
                    lottieAnimationView2.setVisibility(0);
                    lottieAnimationView3 = MediaChannelBottomRaiseHandUseCase.this.mRaiseHandAnim;
                    lottieAnimationView3.setRepeatCount(1);
                    MediaChannelBottomRaiseHandUseCase.this.mAnimating = true;
                    lottieAnimationView4 = MediaChannelBottomRaiseHandUseCase.this.mRaiseHandAnim;
                    lottieAnimationView4.playAnimation();
                }
                MediaChannelBottomRaiseHandUseCase.this.l();
            }
        });
        this.mRaiseHandGroup = mRaiseHandGroup$lambda$1;
        this.mAudioRoomObserver = new c();
        ViewGroup mRaiseHandAdmin$lambda$3 = (ViewGroup) mRootView.findViewById(R.id.f164510sx3);
        Intrinsics.checkNotNullExpressionValue(mRaiseHandAdmin$lambda$3, "mRaiseHandAdmin$lambda$3");
        jt1.b.b(mRaiseHandAdmin$lambda$3, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.presenter.MediaChannelBottomRaiseHandUseCase$mRaiseHandAdmin$1$1
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
                if (NetworkUtil.isNetworkAvailable()) {
                    MediaChannelBottomRaiseHandUseCase.this.l();
                } else {
                    QQToast.makeText(BaseApplication.context, 0, "\u5f53\u524d\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", 0).show();
                }
            }
        });
        ((ImageView) mRaiseHandAdmin$lambda$3.findViewById(R.id.f164509sx2)).setImageResource(R.drawable.guild_media_av_raise_hand);
        this.mRaiseHandAdmin = mRaiseHandAdmin$lambda$3;
        this.mRaiseHandNumber = (TextView) mRootView.findViewById(R.id.sx5);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) mRootView.findViewById(R.id.f164511sx4);
        lottieAnimationView.setVisibility(8);
        lottieAnimationView.addAnimatorListener(new d(lottieAnimationView));
        this.mRaiseHandAnim = lottieAnimationView;
        this.mContext = mRootView.getContext();
        this.raiseHandCountObserver = new f();
        this.raiseHandIconObserver = new g();
        this.userReceivedInvitationObserver = new h();
        this.mThirdAppInfoUpdateEvent = new e();
        n();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaChannelRaiseHandHelper k() {
        return com.tencent.mobileqq.guild.media.core.j.a().T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        int i3 = b.f229078a[k().getSelfRaiseHandState().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.mLastRaiseHandTime > 3000) {
                        this.mLastRaiseHandTime = currentTimeMillis;
                        MediaChannelRaiseHandHelper.l2(k(), null, 1, null);
                        return;
                    }
                    return;
                }
                return;
            }
            if (com.tencent.mobileqq.guild.media.core.j.a().S().i0()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("requestRaiseHand: limit by speak threshold.");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
                }
                FragmentActivity requireActivity = this.fragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
                String guildID = this.mGuildInfo.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo.guildID");
                sz1.c.d(requireActivity, guildID);
                return;
            }
            MediaChannelRaiseHandHelper.l2(k(), null, 1, null);
            return;
        }
        aa.f230980i.j();
        String guildID2 = this.mGuildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID2, "mGuildInfo.guildID");
        GuildRaiseHandDialogFragment guildRaiseHandDialogFragment = new GuildRaiseHandDialogFragment(guildID2, this.mChannelInfo);
        FragmentManager childFragmentManager = this.fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(guildRaiseHandDialogFragment, childFragmentManager, "RaiseHandDialogFragment");
    }

    private final void m() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(ak.class, this.raiseHandCountObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(ap.class, this.raiseHandIconObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(bh.class, this.userReceivedInvitationObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(ax.class, this.mThirdAppInfoUpdateEvent);
    }

    private final void n() {
        r();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(MediaChannelRaiseHandHelper mediaChannelRaiseHandHelper) {
        if (k().getSelfRaiseHandState() != MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_NOT_CLICK && k().getSelfRaiseHandState() != MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_CLICKED) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String openType) {
        if (com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228101i) {
            QLog.d("MediaChannelBottomRaiseHandUseCase", 1, "showUserInvitationDialog self already open mic");
            return;
        }
        if (u.a()) {
            QLog.d("MediaChannelBottomRaiseHandUseCase", 1, "has invite dialog");
            return;
        }
        if (this.fragment.isAdded()) {
            Bundle bundle = new Bundle();
            bundle.putString("OPEN_TYPE", openType);
            GuildMediaRaiseHandInvitationDialogFragment guildMediaRaiseHandInvitationDialogFragment = new GuildMediaRaiseHandInvitationDialogFragment();
            guildMediaRaiseHandInvitationDialogFragment.setArguments(bundle);
            if (this.fragment.getView() != null) {
                View requireView = this.fragment.requireView();
                Intrinsics.checkNotNullExpressionValue(requireView, "fragment.requireView()");
                guildMediaRaiseHandInvitationDialogFragment.sh(requireView);
            }
            FragmentManager childFragmentManager = this.fragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(guildMediaRaiseHandInvitationDialogFragment, childFragmentManager, "GuildMediaRaiseHandInvitationDialogFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        if (com.tencent.mobileqq.guild.media.core.j.a().d0().m1()) {
            this.mRaiseHandGroup.setVisibility(8);
            this.mRaiseHandIv.setVisibility(8);
            this.mRaiseHandAdmin.setVisibility(8);
        } else {
            int i3 = b.f229078a[k().getSelfRaiseHandState().ordinal()];
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    this.mRaiseHandGroup.setVisibility(8);
                    this.mRaiseHandIv.setVisibility(8);
                    this.mRaiseHandAdmin.setVisibility(8);
                } else {
                    this.mRaiseHandGroup.setVisibility(0);
                    this.mRaiseHandAdmin.setVisibility(8);
                    if (!this.mAnimating) {
                        this.mRaiseHandIv.setVisibility(0);
                    }
                }
            } else {
                this.mRaiseHandAdmin.setVisibility(0);
                this.mRaiseHandGroup.setVisibility(8);
            }
        }
        com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        String valueOf;
        int x16 = k().x1();
        if (b.f229078a[k().getSelfRaiseHandState().ordinal()] == 1) {
            if (x16 > 0) {
                this.mRaiseHandNumber.setVisibility(0);
                TextView textView = this.mRaiseHandNumber;
                if (x16 > 99) {
                    valueOf = "99+";
                } else {
                    valueOf = String.valueOf(x16);
                }
                textView.setText(valueOf);
                return;
            }
            this.mRaiseHandNumber.setVisibility(8);
        }
    }

    public final void p() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(ak.class, this.raiseHandCountObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(ap.class, this.raiseHandIconObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(bh.class, this.userReceivedInvitationObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(ax.class, this.mThirdAppInfoUpdateEvent);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/MediaChannelBottomRaiseHandUseCase$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f229081e;

        d(LottieAnimationView lottieAnimationView) {
            this.f229081e = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            MediaChannelBottomRaiseHandUseCase.this.mAnimating = false;
            this.f229081e.setVisibility(8);
            MediaChannelBottomRaiseHandUseCase.this.mRaiseHandIv.setVisibility(0);
            MediaChannelBottomRaiseHandUseCase.this.mRaiseHandNumber.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
