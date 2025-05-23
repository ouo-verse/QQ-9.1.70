package com.tencent.mobileqq.guild.media.thirdapp.widget;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper;
import com.tencent.mobileqq.guild.media.core.notify.ThirdAppBarClickEvent;
import com.tencent.mobileqq.guild.media.viewmodel.MicState;
import com.tencent.mobileqq.guild.media.widget.GuildMediaFullScreenUserListView;
import com.tencent.mobileqq.guild.media.widget.bd;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001^B\u001d\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0002J$\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002J$\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002JH\u0010\u001e\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00142\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\u001c\u0010'\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u0010\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+J\u0012\u0010/\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0019H\u0016R\u0018\u00101\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u00109R\u0016\u0010<\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00106R\u0016\u0010=\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u00109R\u0016\u0010?\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u00109R\u0016\u0010B\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010OR#\u0010V\u001a\n R*\u0004\u0018\u00010Q0Q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\b;\u0010U\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppFullScreenActionBar;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/media/viewmodel/MicState;", "micState", "", "j", "", "isPortrait", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper;", "f", "isEnd", "t", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "e", "g", "Landroid/view/View;", "reportView", "elementId", "reportEventParams", "eventType", ReportConstant.COSTREPORT_PREFIX, "", h.F, "d", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "viewModel", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "weakReference", "setMediaMicStateViewModel", "setOrientationIsPortrait", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "w", "v", NodeProps.ON_CLICK, "Landroid/widget/RelativeLayout;", "mRootView", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaFullScreenUserListView;", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaFullScreenUserListView;", "userListView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "actionBarLayout", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "micIv", "i", "controlBarLayout", "minimizeIv", BdhLogUtil.LogTag.Tag_Conn, "rotateIv", "D", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "micStateViewModel", "E", "Ljava/lang/ref/WeakReference;", "fragmentReference", UserInfo.SEX_FEMALE, "I", "lastUserVolume", "G", "Z", "isPortraitFullView", "H", "isInit", "Lcom/tencent/mobileqq/guild/media/widget/bd;", "Lcom/tencent/mobileqq/guild/media/widget/bd;", "micOnDrawable", "Landroid/animation/StateListAnimator;", "kotlin.jvm.PlatformType", "J", "Lkotlin/Lazy;", "()Landroid/animation/StateListAnimator;", "voiceMicStateListAnimator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaThirdAppFullScreenActionBar extends RelativeLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView rotateIv;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.media.viewmodel.b micStateViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private WeakReference<Fragment> fragmentReference;

    /* renamed from: F, reason: from kotlin metadata */
    private int lastUserVolume;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isPortraitFullView;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isInit;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final bd micOnDrawable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy voiceMicStateListAnimator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMediaFullScreenUserListView userListView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout actionBarLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView micIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout controlBarLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView minimizeIv;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229582a;

        static {
            int[] iArr = new int[MicState.values().length];
            try {
                iArr[MicState.MIC_STATE_ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MicState.MIC_STATE_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MicState.MIC_STATE_DISABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MicState.MIC_STATE_IN_ACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MicState.MIC_STATE_GONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f229582a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaThirdAppFullScreenActionBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int d() {
        if (this.isPortraitFullView) {
            return 2;
        }
        return 3;
    }

    private final HashMap<String, Object> e() {
        IGProLobbyAppInfo thirdAppInfo = f().getThirdAppInfo();
        if (thirdAppInfo == null) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        String appId = thirdAppInfo.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "thirdAppInfo.appId");
        hashMap.put("sgrp_appid", appId);
        String appName = thirdAppInfo.getAppName();
        Intrinsics.checkNotNullExpressionValue(appName, "thirdAppInfo.appName");
        hashMap.put("sgrp_app_name", appName);
        hashMap.put("sgrp_avchannel_app_window_status", Integer.valueOf(d()));
        return hashMap;
    }

    private final MediaChannelThirdAppHelper f() {
        return j.a().d0();
    }

    private final HashMap<String, Object> g() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.putAll(e());
        hashMap.put("sgrp_is_user_talking", Integer.valueOf(h()));
        return hashMap;
    }

    private final int h() {
        if (this.lastUserVolume > 0) {
            return 1;
        }
        return 0;
    }

    private final StateListAnimator i() {
        return (StateListAnimator) this.voiceMicStateListAnimator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(MicState micState) {
        int i3 = b.f229582a[micState.ordinal()];
        ImageView imageView = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    if (i3 == 5) {
                        ImageView imageView2 = this.micIv;
                        if (imageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("micIv");
                        } else {
                            imageView = imageView2;
                        }
                        imageView.setVisibility(8);
                        return;
                    }
                    return;
                }
                ImageView imageView3 = this.micIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("micIv");
                    imageView3 = null;
                }
                imageView3.setImageResource(R.drawable.guild_media_mic_off_disable);
                ImageView imageView4 = this.micIv;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("micIv");
                    imageView4 = null;
                }
                imageView4.setStateListAnimator(null);
                return;
            }
            ImageView imageView5 = this.micIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("micIv");
                imageView5 = null;
            }
            imageView5.setImageResource(R.drawable.guild_media_mic_off_press);
            ImageView imageView6 = this.micIv;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("micIv");
                imageView6 = null;
            }
            imageView6.setEnabled(true);
            ImageView imageView7 = this.micIv;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("micIv");
            } else {
                imageView = imageView7;
            }
            imageView.setStateListAnimator(i());
            return;
        }
        ImageView imageView8 = this.micIv;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("micIv");
            imageView8 = null;
        }
        imageView8.setImageDrawable(this.micOnDrawable);
        ImageView imageView9 = this.micIv;
        if (imageView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("micIv");
            imageView9 = null;
        }
        imageView9.setEnabled(true);
        ImageView imageView10 = this.micIv;
        if (imageView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("micIv");
        } else {
            imageView = imageView10;
        }
        imageView.setStateListAnimator(i());
    }

    private final void k() {
        RelativeLayout relativeLayout = this.mRootView;
        Intrinsics.checkNotNull(relativeLayout);
        View findViewById = relativeLayout.findViewById(R.id.wga);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById\u2026d_full_screen_action_bar)");
        this.actionBarLayout = (LinearLayout) findViewById;
        RelativeLayout relativeLayout2 = this.mRootView;
        Intrinsics.checkNotNull(relativeLayout2);
        View findViewById2 = relativeLayout2.findViewById(R.id.wqz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView!!.findViewById(R.id.guild_mic_iv)");
        this.micIv = (ImageView) findViewById2;
        com.tencent.mobileqq.guild.media.viewmodel.b bVar = this.micStateViewModel;
        ImageView imageView = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("micStateViewModel");
            bVar = null;
        }
        MicState value = bVar.c2().getValue();
        if (value != null) {
            j(value);
        }
        ImageView imageView2 = this.micIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("micIv");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(this);
    }

    private final void l() {
        RelativeLayout relativeLayout = this.mRootView;
        Intrinsics.checkNotNull(relativeLayout);
        View findViewById = relativeLayout.findViewById(R.id.wgb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById\u2026uild_full_screen_control)");
        this.controlBarLayout = (LinearLayout) findViewById;
        RelativeLayout relativeLayout2 = this.mRootView;
        Intrinsics.checkNotNull(relativeLayout2);
        View findViewById2 = relativeLayout2.findViewById(R.id.f165575wr0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView!!.findViewById(R.id.guild_minimize_btn)");
        ImageView imageView = (ImageView) findViewById2;
        this.minimizeIv = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minimizeIv");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        RelativeLayout relativeLayout3 = this.mRootView;
        Intrinsics.checkNotNull(relativeLayout3);
        View findViewById3 = relativeLayout3.findViewById(R.id.wxf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView!!.findViewById(R.id.guild_rotate_btn)");
        ImageView imageView3 = (ImageView) findViewById3;
        this.rotateIv = imageView3;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateIv");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(this);
    }

    private final void m() {
        RelativeLayout relativeLayout = this.mRootView;
        Intrinsics.checkNotNull(relativeLayout);
        GuildMediaFullScreenUserListView guildMediaFullScreenUserListView = (GuildMediaFullScreenUserListView) relativeLayout.findViewById(R.id.wgc);
        this.userListView = guildMediaFullScreenUserListView;
        if (guildMediaFullScreenUserListView != null) {
            guildMediaFullScreenUserListView.setOnClickListener(this);
        }
    }

    private final void n() {
        if (o.d("COMMON_BTN_CLICK_TAG", 1500L)) {
            return;
        }
        j.d().i(ThirdAppBarClickEvent.MINIMIZE_PORTRAIT);
        ImageView imageView = this.minimizeIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minimizeIv");
            imageView = null;
        }
        s(imageView, "em_sgrp_avchannel_transfer_gridpage", e(), "clck");
    }

    private final void o() {
        if (o.d("COMMON_BTN_CLICK_TAG", 1500L)) {
            return;
        }
        j.d().i(ThirdAppBarClickEvent.MINIMIZE_LAND);
        ImageView imageView = this.rotateIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateIv");
            imageView = null;
        }
        s(imageView, "em_sgrp_avchannel_switchpicture", e(), "clck");
    }

    private final void p(boolean isPortrait) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2 = this.mRootView;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        if (isPortrait) {
            View inflate = View.inflate(getContext(), R.layout.ez8, this);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            relativeLayout = (RelativeLayout) inflate;
        } else {
            View inflate2 = View.inflate(getContext(), R.layout.ez9, this);
            Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.widget.RelativeLayout");
            relativeLayout = (RelativeLayout) inflate2;
        }
        this.mRootView = relativeLayout;
        m();
        k();
        l();
        this.isInit = true;
        u(this, false, 1, null);
    }

    private final void s(View reportView, String elementId, HashMap<String, Object> reportEventParams, String eventType) {
        if (reportView == null) {
            return;
        }
        MediaChannelUtils.f228046a.G(reportView, elementId, reportEventParams, eventType);
    }

    private final void t(boolean isEnd) {
        String str;
        if (!this.isInit) {
            return;
        }
        if (isEnd) {
            str = "imp_end";
        } else {
            str = "imp";
        }
        HashMap<String, Object> e16 = e();
        ImageView imageView = this.micIv;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("micIv");
            imageView = null;
        }
        s(imageView, "em_sgrp_subchannel_microphone", e16, str);
        ImageView imageView3 = this.rotateIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotateIv");
            imageView3 = null;
        }
        s(imageView3, "em_sgrp_avchannel_switchpicture", e16, str);
        ImageView imageView4 = this.minimizeIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minimizeIv");
        } else {
            imageView2 = imageView4;
        }
        s(imageView2, "em_sgrp_avchannel_transfer_gridpage", e16, str);
        s(this.userListView, "em_sgrp_room_hot_head", g(), str);
    }

    static /* synthetic */ void u(GuildMediaThirdAppFullScreenActionBar guildMediaThirdAppFullScreenActionBar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMediaThirdAppFullScreenActionBar.t(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        AppInterface appInterface;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && !o.a(v3)) {
            String guildID = j.a().getGuildID();
            String E = j.a().E();
            ImageView imageView = null;
            if (Intrinsics.areEqual(v3, this.userListView)) {
                IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                iQQGuildRouterApi.openGuildMediaChannelDetailFragment(appInterface, getContext(), guildID, E, 3);
                GuildMediaFullScreenUserListView guildMediaFullScreenUserListView = this.userListView;
                Intrinsics.checkNotNull(guildMediaFullScreenUserListView);
                s(guildMediaFullScreenUserListView, "em_sgrp_room_hot_head", g(), "clck");
            } else {
                ImageView imageView2 = this.micIv;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("micIv");
                    imageView2 = null;
                }
                if (Intrinsics.areEqual(v3, imageView2)) {
                    com.tencent.mobileqq.guild.media.viewmodel.b bVar = this.micStateViewModel;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("micStateViewModel");
                        bVar = null;
                    }
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    WeakReference<Fragment> weakReference = this.fragmentReference;
                    if (weakReference == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fragmentReference");
                        weakReference = null;
                    }
                    bVar.i2(null, context, weakReference);
                    ImageView imageView3 = this.micIv;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("micIv");
                    } else {
                        imageView = imageView3;
                    }
                    s(imageView, "em_sgrp_subchannel_microphone", e(), "clck");
                } else {
                    ImageView imageView4 = this.minimizeIv;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("minimizeIv");
                        imageView4 = null;
                    }
                    if (Intrinsics.areEqual(v3, imageView4)) {
                        n();
                    } else {
                        ImageView imageView5 = this.rotateIv;
                        if (imageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rotateIv");
                        } else {
                            imageView = imageView5;
                        }
                        if (Intrinsics.areEqual(v3, imageView)) {
                            o();
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void q() {
        GuildMediaFullScreenUserListView guildMediaFullScreenUserListView;
        if (this.isInit && this.lastUserVolume <= 0 && (guildMediaFullScreenUserListView = this.userListView) != null) {
            GuildMediaFullScreenUserListView.h(guildMediaFullScreenUserListView, j.a().getGuildID(), null, false, 6, null);
        }
    }

    public final void r() {
        t(true);
        this.isInit = false;
    }

    public final void setMediaMicStateViewModel(@NotNull com.tencent.mobileqq.guild.media.viewmodel.b viewModel, @NotNull WeakReference<Fragment> weakReference) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(weakReference, "weakReference");
        this.micStateViewModel = viewModel;
        this.fragmentReference = weakReference;
        Fragment fragment = weakReference.get();
        if (fragment != null) {
            com.tencent.mobileqq.guild.media.viewmodel.b bVar = this.micStateViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("micStateViewModel");
                bVar = null;
            }
            e12.e<MicState> c26 = bVar.c2();
            final Function1<MicState, Unit> function1 = new Function1<MicState, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppFullScreenActionBar$setMediaMicStateViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MicState micState) {
                    invoke2(micState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MicState micState) {
                    if (GuildMediaThirdAppFullScreenActionBar.this.getVisibility() == 0) {
                        GuildMediaThirdAppFullScreenActionBar guildMediaThirdAppFullScreenActionBar = GuildMediaThirdAppFullScreenActionBar.this;
                        Intrinsics.checkNotNullExpressionValue(micState, "micState");
                        guildMediaThirdAppFullScreenActionBar.j(micState);
                    }
                }
            };
            c26.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildMediaThirdAppFullScreenActionBar.v(Function1.this, obj);
                }
            });
        }
    }

    public final void setOrientationIsPortrait(boolean isPortrait) {
        this.isPortraitFullView = isPortrait;
        p(isPortrait);
    }

    public final void w(@Nullable p userInfo) {
        int i3;
        List<? extends p> arrayList;
        boolean z16;
        boolean z17 = true;
        if (userInfo != null) {
            if (this.lastUserVolume == userInfo.f228109q) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
        }
        if (userInfo != null) {
            i3 = userInfo.f228109q;
        } else {
            i3 = 0;
        }
        this.lastUserVolume = i3;
        if (userInfo != null && Intrinsics.areEqual(userInfo.f228093a, j.c().getSelfUserInfo().f228093a)) {
            this.micOnDrawable.k(userInfo.f228109q);
        }
        GuildMediaFullScreenUserListView guildMediaFullScreenUserListView = this.userListView;
        if (guildMediaFullScreenUserListView != null) {
            String guildID = j.a().getGuildID();
            if (userInfo != null) {
                arrayList = Collections.singletonList(userInfo);
            } else {
                arrayList = new ArrayList<>();
            }
            Intrinsics.checkNotNullExpressionValue(arrayList, "if (userInfo != null) {\n\u2026bleListOf()\n            }");
            if (userInfo == null) {
                z17 = false;
            }
            guildMediaFullScreenUserListView.g(guildID, arrayList, z17);
        }
    }

    public /* synthetic */ GuildMediaThirdAppFullScreenActionBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaThirdAppFullScreenActionBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isPortraitFullView = true;
        this.micOnDrawable = new bd(context, context.getResources().getDimensionPixelOffset(R.dimen.cip), context.getResources().getDimensionPixelOffset(R.dimen.cip));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<StateListAnimator>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppFullScreenActionBar$voiceMicStateListAnimator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StateListAnimator invoke() {
                ImageView imageView;
                imageView = GuildMediaThirdAppFullScreenActionBar.this.micIv;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("micIv");
                    imageView = null;
                }
                return AnimatorInflater.loadStateListAnimator(imageView.getContext(), R.animator.f155134n);
            }
        });
        this.voiceMicStateListAnimator = lazy;
    }
}
