package com.tencent.guild.aio.title;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.guild.aio.title.c;
import com.tencent.guild.aio.title.d;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.widget.ClickType;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;
import com.tencent.mobileqq.guild.widget.GuildRightIconLayout;
import com.tencent.mobileqq.guild.widget.IconType;
import com.tencent.mobileqq.guild.widget.TitleBarTheme;
import com.tencent.mobileqq.guild.widget.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vn0.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001>\u0018\u0000 D2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001EB\u000f\u0012\u0006\u0010.\u001a\u00020)\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0016\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030!0 H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u00162\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/guild/aio/title/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "", ICustomDataEditor.STRING_PARAM_1, "q1", "", "selectState", "i1", "k1", "j1", "m1", "Landroid/view/View;", "v", "o1", "v1", "isSelectMode", "isGuest", "hideGuestStatus", "fromJubao", ICustomDataEditor.NUMBER_PARAM_1, "Landroid/os/Bundle;", "l1", "u1", "r1", "Lcom/tencent/mvi/api/help/a;", "params", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "h1", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "p1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "d", "Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "getTitleBarTheme", "()Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "titleBarTheme", "Lvn0/n;", "e", "Lvn0/n;", "mBinding", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "f", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "mTitleBar", h.F, "Z", "mFromJuBao", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "postSubscribeAction", "com/tencent/guild/aio/title/a$d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/title/a$d;", "mThemeChangedCallback", "<init>", "(Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TitleBarTheme titleBarTheme;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private n mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildAIOTitleBar mTitleBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mFromJuBao;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable postSubscribeAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mThemeChangedCallback;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112342a;

        static {
            int[] iArr = new int[IGuildAioTitleUIState.TYPE.values().length];
            try {
                iArr[IGuildAioTitleUIState.TYPE.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.MULTISELECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.BACKBTN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.GUILDNAMETITLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.UNREADMSGCNT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f112342a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/title/a$c", "Lcom/tencent/mobileqq/guild/widget/ah;", "Lcom/tencent/mobileqq/guild/widget/ClickType;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "Landroid/view/View;", "v", "", "u2", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements ah {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.guild.aio.title.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public /* synthetic */ class C1214a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f112344a;

            static {
                int[] iArr = new int[ClickType.values().length];
                try {
                    iArr[ClickType.BACK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ClickType.SHARE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ClickType.JOIN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ClickType.RIGHT_TEXT_BUTTON.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ClickType.SHOW_GUILD_DIALOG.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ClickType.THREE_LINES_SETTING_RED_DOT.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ClickType.THREE_LINES_SETTING.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f112344a = iArr;
            }
        }

        c() {
        }

        @Override // com.tencent.mobileqq.guild.widget.ah
        public void u2(@NotNull ClickType clickType, @NotNull View v3) {
            Intrinsics.checkNotNullParameter(clickType, "clickType");
            Intrinsics.checkNotNullParameter(v3, "v");
            switch (C1214a.f112344a[clickType.ordinal()]) {
                case 1:
                    a.this.sendIntent(new c.l());
                    return;
                case 2:
                    a.this.sendIntent(new c.b());
                    return;
                case 3:
                    a.this.sendIntent(new c.a());
                    ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(v3, "em_sgrp_join_channel_subchannel", null);
                    VideoReport.reportEvent("dt_clck", v3, null);
                    return;
                case 4:
                    if (a.this.mFromJuBao) {
                        a.this.m1();
                        return;
                    } else {
                        a.this.j1();
                        return;
                    }
                case 5:
                    a.this.o1(v3);
                    return;
                case 6:
                case 7:
                    a.this.k1();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/title/a$d", "Lor0/a;", "", "onThemeChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements or0.a {
        d() {
        }

        @Override // or0.a
        public void onThemeChanged() {
            a.this.v1();
        }
    }

    public a(@NotNull TitleBarTheme titleBarTheme) {
        Intrinsics.checkNotNullParameter(titleBarTheme, "titleBarTheme");
        this.titleBarTheme = titleBarTheme;
        this.mThemeChangedCallback = new d();
    }

    private final void i1(boolean selectState) {
        if (!selectState) {
            Context mContext = getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) mContext).onKeyDown(4, new KeyEvent(1, 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        sendIntent(new c.k(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        sendIntent(new c.d());
    }

    private final Bundle l1() {
        n nVar = this.mBinding;
        n nVar2 = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            nVar = null;
        }
        int height = nVar.getRoot().getHeight();
        if (height == 0) {
            int screenWidth = ViewUtils.getScreenWidth();
            int screenHeight = ViewUtils.getScreenHeight();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(screenWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(screenHeight, Integer.MIN_VALUE);
            n nVar3 = this.mBinding;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                nVar3 = null;
            }
            nVar3.getRoot().measure(makeMeasureSpec, makeMeasureSpec2);
            n nVar4 = this.mBinding;
            if (nVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                nVar2 = nVar4;
            }
            height = nVar2.getRoot().getMeasuredHeight();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("guild_aio_title_height", height);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        sendIntent(new c.i());
    }

    private final void n1(boolean isSelectMode, boolean isGuest, boolean hideGuestStatus, boolean fromJubao) {
        List<? extends IconType> mutableListOf;
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        GuildAIOTitleBar guildAIOTitleBar2 = null;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        guildAIOTitleBar.setRightButtonVisibility(isSelectMode);
        if (isGuest && !hideGuestStatus) {
            GuildAIOTitleBar guildAIOTitleBar3 = this.mTitleBar;
            if (guildAIOTitleBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                guildAIOTitleBar3 = null;
            }
            guildAIOTitleBar3.setJoinButtonVisibility(!isSelectMode);
            r1();
        } else {
            if (!isSelectMode && !hideGuestStatus) {
                GuildAIOTitleBar guildAIOTitleBar4 = this.mTitleBar;
                if (guildAIOTitleBar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                    guildAIOTitleBar4 = null;
                }
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(IconType.THREE_LINES_SETTING);
                guildAIOTitleBar4.setRightIcons(mutableListOf);
            } else {
                GuildAIOTitleBar guildAIOTitleBar5 = this.mTitleBar;
                if (guildAIOTitleBar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                    guildAIOTitleBar5 = null;
                }
                guildAIOTitleBar5.setRightIcons(new ArrayList());
            }
            GuildAIOTitleBar guildAIOTitleBar6 = this.mTitleBar;
            if (guildAIOTitleBar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                guildAIOTitleBar6 = null;
            }
            guildAIOTitleBar6.setJoinButtonVisibility(false);
            r1();
        }
        this.mFromJuBao = fromJubao;
        if (fromJubao) {
            GuildAIOTitleBar guildAIOTitleBar7 = this.mTitleBar;
            if (guildAIOTitleBar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            } else {
                guildAIOTitleBar2 = guildAIOTitleBar7;
            }
            String string = getMContext().getResources().getString(R.string.f145870sn);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026ng(R.string.guild_finish)");
            guildAIOTitleBar2.setRightTextButtonText(string);
            return;
        }
        GuildAIOTitleBar guildAIOTitleBar8 = this.mTitleBar;
        if (guildAIOTitleBar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        } else {
            guildAIOTitleBar2 = guildAIOTitleBar8;
        }
        String string2 = getMContext().getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string2, "mContext.resources.getString(R.string.cancel)");
        guildAIOTitleBar2.setRightTextButtonText(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(View v3) {
        sendIntent(new c.m());
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(v3, "em_sgrp_half_channel", null);
        VideoReport.reportEvent("dt_clck", v3, null);
    }

    private final void q1() {
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        GuildAIOTitleBar guildAIOTitleBar2 = null;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        guildAIOTitleBar.setTheme(this.titleBarTheme);
        GuildAIOTitleBar guildAIOTitleBar3 = this.mTitleBar;
        if (guildAIOTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        } else {
            guildAIOTitleBar2 = guildAIOTitleBar3;
        }
        sendIntent(new c.TitleBarAvatarIntent(guildAIOTitleBar2.C0()));
        sendIntent(new c.f());
        sendIntent(new c.h());
        sendIntent(new c.g());
        sendIntent(new c.e());
        sendIntent(new c.j());
        QQGuildThemeManager.c(this.mThemeChangedCallback);
        v1();
    }

    private final void r1() {
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        GuildRightIconLayout E0 = guildAIOTitleBar.E0(IconType.SHARE);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(E0, "em_sgrp_subchannel_top_invite", null);
        VideoReport.traversePage(E0);
    }

    private final void s1() {
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        GuildAIOTitleBar guildAIOTitleBar2 = null;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        guildAIOTitleBar.setTheme(this.titleBarTheme);
        GuildAIOTitleBar guildAIOTitleBar3 = this.mTitleBar;
        if (guildAIOTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        } else {
            guildAIOTitleBar2 = guildAIOTitleBar3;
        }
        guildAIOTitleBar2.setTitleBarClickListener(new c());
        v1();
    }

    private final void u1() {
        Runnable runnable = this.postSubscribeAction;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        this.postSubscribeAction = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1() {
        sq0.a aVar = sq0.a.f434200a;
        n nVar = this.mBinding;
        GuildAIOTitleBar guildAIOTitleBar = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            nVar = null;
        }
        ConstraintLayout root = nVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        aVar.c(root);
        GuildAIOTitleBar guildAIOTitleBar2 = this.mTitleBar;
        if (guildAIOTitleBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        } else {
            guildAIOTitleBar = guildAIOTitleBar2;
        }
        guildAIOTitleBar.onThemeChanged();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        g12.b bVar = g12.b.f401087a;
        GuildHistogramScene guildHistogramScene = GuildHistogramScene.GUILD_AIO_BIND_TITLE_TIME_COST;
        bVar.h(guildHistogramScene, "");
        super.bindViewAndData();
        q1();
        bVar.a(guildHistogramScene, "");
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof d.b) {
            return l1();
        }
        return null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends IGuildAioTitleUIState>> getObserverStates() {
        List<Class<? extends IGuildAioTitleUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildAioTitleTextUIState.class, GuildAioTitleMultiSelectUIState.class, GuildAioTitleBackBtnUIState.class, GuildAioTitleGuildNameTextUIState.class, GuildAioTitleUnreadMsgCntUIState.class, GuildAioTitleCheckLoadDataUIState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> createVM() {
        return new GuildAioTitleViewModel();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        n g16 = n.g(LayoutInflater.from(params.a()), params.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, params.parent, false)");
        this.mBinding = g16;
        n nVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        GuildAIOTitleBar guildAIOTitleBar = g16.f441982c;
        Intrinsics.checkNotNullExpressionValue(guildAIOTitleBar, "mBinding.guildTitleBar");
        this.mTitleBar = guildAIOTitleBar;
        s1();
        n nVar2 = this.mBinding;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            nVar = nVar2;
        }
        ConstraintLayout root = nVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        u1();
        QQGuildThemeManager.d(this.mThemeChangedCallback);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull IGuildAioTitleUIState state) {
        a aVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        GuildAIOTitleBar guildAIOTitleBar = null;
        if (!state.getResult()) {
            aVar = this;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return;
        }
        int i3 = b.f112342a[state.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            GuildAioTitleUnreadMsgCntUIState guildAioTitleUnreadMsgCntUIState = (GuildAioTitleUnreadMsgCntUIState) state;
                            QLog.i("FileUtil", 1, "handleUIState unread count=" + guildAioTitleUnreadMsgCntUIState.getCntText());
                            try {
                                GuildAIOTitleBar guildAIOTitleBar2 = this.mTitleBar;
                                if (guildAIOTitleBar2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                                } else {
                                    guildAIOTitleBar = guildAIOTitleBar2;
                                }
                                guildAIOTitleBar.setUnreadCount((int) guildAioTitleUnreadMsgCntUIState.getCntText());
                                return;
                            } catch (NumberFormatException e16) {
                                QLog.e("FileUtil", 1, String.valueOf(e16));
                                return;
                            }
                        }
                        return;
                    }
                    GuildAioTitleGuildNameTextUIState guildAioTitleGuildNameTextUIState = (GuildAioTitleGuildNameTextUIState) state;
                    String name = guildAioTitleGuildNameTextUIState.getName();
                    if (name != null && name.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16 && !guildAioTitleGuildNameTextUIState.getNeedHideGuest()) {
                        GuildAIOTitleBar guildAIOTitleBar3 = this.mTitleBar;
                        if (guildAIOTitleBar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                            guildAIOTitleBar3 = null;
                        }
                        guildAIOTitleBar3.setGuildNavigateVisibility(true);
                        GuildAIOTitleBar guildAIOTitleBar4 = this.mTitleBar;
                        if (guildAIOTitleBar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                            guildAIOTitleBar4 = null;
                        }
                        String name2 = guildAioTitleGuildNameTextUIState.getName();
                        Intrinsics.checkNotNull(name2);
                        guildAIOTitleBar4.setGuildName(name2);
                        GuildAIOTitleBar guildAIOTitleBar5 = this.mTitleBar;
                        if (guildAIOTitleBar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                        } else {
                            guildAIOTitleBar = guildAIOTitleBar5;
                        }
                        guildAIOTitleBar.setGuildStateType(guildAioTitleGuildNameTextUIState.getStateType());
                        return;
                    }
                    GuildAIOTitleBar guildAIOTitleBar6 = this.mTitleBar;
                    if (guildAIOTitleBar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                    } else {
                        guildAIOTitleBar = guildAIOTitleBar6;
                    }
                    guildAIOTitleBar.setGuildNavigateVisibility(false);
                    return;
                }
                i1(((GuildAioTitleBackBtnUIState) state).getMultistate());
                return;
            }
            GuildAioTitleMultiSelectUIState guildAioTitleMultiSelectUIState = (GuildAioTitleMultiSelectUIState) state;
            n1(guildAioTitleMultiSelectUIState.getIsMultiSelectMode(), guildAioTitleMultiSelectUIState.getIsGuest(), guildAioTitleMultiSelectUIState.getNeedHideGuest(), guildAioTitleMultiSelectUIState.getFromJubao());
            return;
        }
        String name3 = ((GuildAioTitleTextUIState) state).getName();
        if (name3 != null) {
            GuildAIOTitleBar guildAIOTitleBar7 = this.mTitleBar;
            if (guildAIOTitleBar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            } else {
                guildAIOTitleBar = guildAIOTitleBar7;
            }
            guildAIOTitleBar.setChannelName(name3);
        }
    }
}
